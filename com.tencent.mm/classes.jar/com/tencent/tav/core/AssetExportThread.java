package com.tencent.tav.core;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.codec.IMediaFactory;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.AverageTimeReporter;
import com.tencent.tav.report.ExportReportSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AssetExportThread
  extends HandlerThread
  implements Handler.Callback
{
  public static final int FRAME_OPERATE_TIMEOUT = 20000;
  private static final String TAG = "AssetExportThread";
  private static final int msg_done_a = 2;
  private static final int msg_done_v = 1;
  private AssetReader assetReader;
  private AssetWriter assetWriter;
  private HandlerThread audioExportThread;
  private AudioInfo audioInfo;
  private AudioMix audioMix;
  private float audioProgress;
  private boolean audioReadFinish;
  private AssetReaderOutput audioReader;
  private long audioTime;
  private volatile boolean audioTimeout;
  private AudioFrameOperateTimeoutCallback audioTimeoutCallback;
  private AssetWriterInput audioWriter;
  private volatile boolean audioWriterDone;
  private AssetExportSession.ExportCallbackHandler callbackHandler;
  private volatile boolean cancel;
  private int count;
  private final ExportConfig encodeOption;
  private Handler exportHandler;
  private AssetExportSession exportSession;
  private int frameCount;
  private volatile boolean isFinishing;
  private boolean isNeedCheckFrameProcessTimeout;
  private long lastFrameTimeStamp;
  private long lastHandleAudioTimeStamp;
  private long lastHandleVideoTimeStamp;
  private IMediaFactory mediaFactory;
  private RenderContextParams renderContextParams;
  private ExportReportSession reportSession;
  private boolean timeoutInterruptWork;
  private HandlerThread videoExportThread;
  private float videoProgress;
  private boolean videoReadFinish;
  private AssetReaderOutput videoReader;
  private long videoTime;
  private volatile boolean videoTimeout;
  private VideoFrameOperateTimeoutCallback videoTimeoutCallback;
  private AssetWriterInput videoWriter;
  private volatile boolean videoWriterDone;
  
  AssetExportThread(AssetExportSession paramAssetExportSession, AssetExportSession.ExportCallbackHandler paramExportCallbackHandler, AudioMix paramAudioMix, ExportConfig paramExportConfig)
  {
    super("ExportThread");
    AppMethodBeat.i(215368);
    this.videoWriterDone = false;
    this.audioWriterDone = false;
    this.videoReadFinish = false;
    this.audioReadFinish = false;
    this.videoTime = 0L;
    this.audioTime = 0L;
    this.cancel = false;
    this.videoTimeout = false;
    this.audioTimeout = false;
    this.reportSession = new ExportReportSession();
    this.videoTimeoutCallback = new VideoFrameOperateTimeoutCallback(null);
    this.audioTimeoutCallback = new AudioFrameOperateTimeoutCallback(null);
    this.lastHandleVideoTimeStamp = SystemClock.uptimeMillis();
    this.lastHandleAudioTimeStamp = SystemClock.uptimeMillis();
    this.isNeedCheckFrameProcessTimeout = true;
    this.timeoutInterruptWork = false;
    this.lastFrameTimeStamp = 0L;
    this.frameCount = 0;
    this.count = 0;
    this.exportSession = paramAssetExportSession;
    this.callbackHandler = paramExportCallbackHandler;
    this.audioMix = paramAudioMix;
    this.audioInfo = new AudioInfo(paramExportConfig.getAudioSampleRateHz(), paramExportConfig.getAudioChannelCount(), 2);
    this.encodeOption = paramExportConfig;
    AppMethodBeat.o(215368);
  }
  
  private AssetReaderOutput createAudioTrackOutput()
  {
    AppMethodBeat.i(215511);
    Object localObject = (ArrayList)this.exportSession.asset.tracksWithMediaType(2);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = new AssetReaderAudioMixOutput((ArrayList)localObject, null, this.mediaFactory);
      ((AssetReaderAudioMixOutput)localObject).setAudioMix(this.audioMix);
      ((AssetReaderAudioMixOutput)localObject).setAudioInfo(this.audioInfo);
      AppMethodBeat.o(215511);
      return localObject;
    }
    localObject = new EmptyReaderOutput();
    AppMethodBeat.o(215511);
    return localObject;
  }
  
  private AssetWriterInput createAudioWriterInput()
  {
    AppMethodBeat.i(215478);
    AssetWriterInput localAssetWriterInput = new AssetWriterInput(2);
    AppMethodBeat.o(215478);
    return localAssetWriterInput;
  }
  
  private AssetReaderOutput createVideoTrackOutput()
  {
    AppMethodBeat.i(215498);
    Object localObject = this.exportSession.asset.tracksWithMediaType(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("frame-rate", Integer.valueOf(this.encodeOption.getVideoFrameRate()));
      localObject = new AssetReaderVideoCompositionOutput((List)localObject, localHashMap, this.exportSession.assetExtension, this.mediaFactory);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoComposition(this.exportSession.videoComposition);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoCompositing(this.exportSession.videoCompositing);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoRevertMode(this.exportSession.isRevertMode());
      AppMethodBeat.o(215498);
      return localObject;
    }
    localObject = new EmptyReaderOutput();
    AppMethodBeat.o(215498);
    return localObject;
  }
  
  private AssetWriterInput createVideoWriterInput()
  {
    AppMethodBeat.i(215468);
    if (this.reportSession != null) {
      this.reportSession.setFramePerSecond(this.encodeOption.getVideoFrameRate());
    }
    AssetWriterInput localAssetWriterInput = new AssetWriterInput(1);
    AppMethodBeat.o(215468);
    return localAssetWriterInput;
  }
  
  private void exportError(int paramInt, Throwable paramThrowable)
  {
    try
    {
      AppMethodBeat.i(215402);
      exportError(new ExportErrorStatus(paramInt, paramThrowable));
      AppMethodBeat.o(215402);
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  private void exportError(ExportErrorStatus paramExportErrorStatus)
  {
    AppMethodBeat.i(215418);
    if (this.exportSession.status != AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed)
    {
      this.cancel = true;
      this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed;
      this.exportSession.exportErrorStatus = paramExportErrorStatus;
      if (this.reportSession != null) {
        this.reportSession.onExportError();
      }
      if (this.callbackHandler != null) {
        this.callbackHandler.handlerCallback(this.exportSession);
      }
    }
    AppMethodBeat.o(215418);
  }
  
  /* Error */
  private void exportSuccess()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 447
    //   5: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 167	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   14: getfield 428	com/tencent/tav/core/AssetExportSession:status	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   17: getstatic 450	com/tencent/tav/core/AssetExportSession$AssetExportSessionStatus:AssetExportSessionStatusCompleted	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   20: if_acmpne +14 -> 34
    //   23: aload_0
    //   24: monitorexit
    //   25: ldc_w 447
    //   28: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 167	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   38: fconst_1
    //   39: putfield 453	com/tencent/tav/core/AssetExportSession:progress	F
    //   42: aload_0
    //   43: getfield 167	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   46: getstatic 450	com/tencent/tav/core/AssetExportSession$AssetExportSessionStatus:AssetExportSessionStatusCompleted	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   49: putfield 428	com/tencent/tav/core/AssetExportSession:status	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_0
    //   55: getfield 137	com/tencent/tav/core/AssetExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
    //   58: ifnull +10 -> 68
    //   61: aload_0
    //   62: getfield 137	com/tencent/tav/core/AssetExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
    //   65: invokevirtual 456	com/tencent/tav/report/ExportReportSession:onExportSuccess	()V
    //   68: aload_0
    //   69: getfield 169	com/tencent/tav/core/AssetExportThread:callbackHandler	Lcom/tencent/tav/core/AssetExportSession$ExportCallbackHandler;
    //   72: ifnull +16 -> 88
    //   75: aload_0
    //   76: getfield 169	com/tencent/tav/core/AssetExportThread:callbackHandler	Lcom/tencent/tav/core/AssetExportSession$ExportCallbackHandler;
    //   79: aload_0
    //   80: getfield 167	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   83: invokeinterface 446 2 0
    //   88: ldc_w 447
    //   91: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: goto -63 -> 31
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: ldc_w 447
    //   108: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	AssetExportThread
    //   97	4	1	localObject1	Object
    //   102	10	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	97	finally
    //   25	31	97	finally
    //   54	68	97	finally
    //   68	88	97	finally
    //   88	94	97	finally
    //   103	113	97	finally
    //   10	25	102	finally
    //   34	54	102	finally
  }
  
  private void exporting()
  {
    AppMethodBeat.i(215441);
    initReaderAndWriter();
    this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting;
    this.videoExportThread = new HandlerThread("VideoWriter");
    this.videoWriter.setWriterProgressListener(new VideoWriterProgressListener(null));
    this.videoWriter.requestMediaDataWhenReadyOnQueue(this.videoExportThread, new VideoRequestMediaDataCallback(null));
    if (this.audioWriter != null)
    {
      this.audioExportThread = new HandlerThread("AudioWriter");
      this.audioWriter.setWriterProgressListener(new AudioWriterProgressListener(null));
      this.audioWriter.requestMediaDataWhenReadyOnQueue(this.audioExportThread, new AudioRequestMediaDataCallback(null));
      AppMethodBeat.o(215441);
      return;
    }
    this.audioReadFinish = true;
    this.audioWriterDone = true;
    AppMethodBeat.o(215441);
  }
  
  private void finish()
  {
    AppMethodBeat.i(215384);
    Logger.i("AssetExportThread", "finish");
    if (this.videoExportThread == null)
    {
      Logger.w("AssetExportThread", "videoExportThread is null");
      AppMethodBeat.o(215384);
      return;
    }
    if (this.isFinishing)
    {
      Logger.w("AssetExportThread", "already finished");
      AppMethodBeat.o(215384);
      return;
    }
    this.isFinishing = true;
    new Handler(this.videoExportThread.getLooper()).post(new Runnable()
    {
      public void run()
      {
        long l2 = 0L;
        AppMethodBeat.i(215153);
        label75:
        ExportReportSession localExportReportSession;
        if (AssetExportThread.this.videoExportThread != null)
        {
          if (Build.VERSION.SDK_INT >= 18)
          {
            AssetExportThread.this.videoExportThread.quitSafely();
            AssetExportThread.access$202(AssetExportThread.this, null);
          }
        }
        else
        {
          if (AssetExportThread.this.audioExportThread != null)
          {
            if (Build.VERSION.SDK_INT < 18) {
              break label448;
            }
            AssetExportThread.this.audioExportThread.quitSafely();
            AssetExportThread.access$302(AssetExportThread.this, null);
          }
          if (AssetExportThread.this.assetReader != null)
          {
            AssetExportThread.this.assetReader.cancelReading();
            AssetExportThread.access$402(AssetExportThread.this, null);
          }
          if (AssetExportThread.this.reportSession != null)
          {
            localExportReportSession = AssetExportThread.this.reportSession;
            if ((AssetExportThread.this.videoReader == null) || (AssetExportThread.this.videoReader.getDecodePerformance() == null)) {
              break label462;
            }
          }
        }
        label448:
        label462:
        for (long l1 = AssetExportThread.this.videoReader.getDecodePerformance().getTotal() * 1000L;; l1 = 0L)
        {
          localExportReportSession.setTotalRealDecodeUs(l1);
          localExportReportSession = AssetExportThread.this.reportSession;
          l1 = l2;
          if (AssetExportThread.this.assetWriter != null)
          {
            l1 = l2;
            if (AssetExportThread.this.assetWriter.getEncodePerformance() != null) {
              l1 = AssetExportThread.this.assetWriter.getEncodePerformance().getTotal() * 1000L;
            }
          }
          localExportReportSession.setTotalEncodeUs(l1);
          i = 0;
          j = 0;
          if (AssetExportThread.this.assetWriter != null) {}
          try
          {
            AssetExportThread.this.assetWriter.finishWriting();
            i = 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Logger.e("AssetExportSession", "code = -10 run: finishWriting error", localException);
              AssetExportThread.access$800(AssetExportThread.this, -10, localException);
              i = j;
              continue;
              if (AssetExportThread.this.videoTimeout)
              {
                AssetExportThread.this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusTimeout;
                AssetExportThread.this.exportSession.exportErrorStatus = new ExportErrorStatus(-203, null, "handle video timeout");
                if (AssetExportThread.this.callbackHandler != null) {
                  AssetExportThread.this.callbackHandler.handlerCallback(AssetExportThread.this.exportSession);
                }
              }
              else if ((AssetExportThread.this.cancel) && (AssetExportThread.this.exportSession.status != AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed))
              {
                AssetExportThread.this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled;
                if (AssetExportThread.this.callbackHandler != null) {
                  AssetExportThread.this.callbackHandler.handlerCallback(AssetExportThread.this.exportSession);
                }
              }
              else if ((AssetExportThread.this.videoWriterDone) && (AssetExportThread.this.audioWriterDone) && (i != 0) && (!AssetExportThread.this.cancel))
              {
                AssetExportThread.access$1800(AssetExportThread.this);
                continue;
                AssetExportThread.this.quit();
              }
            }
          }
          AssetExportThread.access$702(AssetExportThread.this, null);
          if (AssetExportThread.this.videoWriter != null) {
            AssetExportThread.this.videoWriter.close();
          }
          if (AssetExportThread.this.audioWriter != null) {
            AssetExportThread.this.audioWriter.close();
          }
          if (!AssetExportThread.this.audioTimeout) {
            break label494;
          }
          AssetExportThread.this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusTimeout;
          AssetExportThread.this.exportSession.exportErrorStatus = new ExportErrorStatus(-204, null, "handle audio timeout");
          if (AssetExportThread.this.callbackHandler != null) {
            AssetExportThread.this.callbackHandler.handlerCallback(AssetExportThread.this.exportSession);
          }
          if (Build.VERSION.SDK_INT < 18) {
            break label687;
          }
          AssetExportThread.this.quitSafely();
          if (AssetExportThread.this.exportSession != null) {
            AssetExportThread.this.exportSession.release();
          }
          AppMethodBeat.o(215153);
          return;
          AssetExportThread.this.videoExportThread.quit();
          break;
          AssetExportThread.this.audioExportThread.quit();
          break label75;
        }
      }
    });
    AppMethodBeat.o(215384);
  }
  
  private long getDuration()
  {
    long l2 = 0L;
    AppMethodBeat.i(215521);
    if ((this.exportSession != null) && (this.exportSession.timeRange != null))
    {
      l1 = this.exportSession.timeRange.getDuration().getTimeUs();
      AppMethodBeat.o(215521);
      return l1 * 2L;
    }
    if (this.audioReader != null) {}
    for (long l1 = this.audioReader.duration();; l1 = 0L)
    {
      if (this.videoReader != null) {
        l2 = this.videoReader.duration();
      }
      AppMethodBeat.o(215521);
      return l1 + l2;
    }
  }
  
  private void initReaderAndWriter()
  {
    AppMethodBeat.i(215456);
    this.assetReader = new AssetReader(this.exportSession.asset);
    this.assetReader.setTimeRange(this.exportSession.timeRange);
    this.videoReader = createVideoTrackOutput();
    this.audioReader = createAudioTrackOutput();
    if (this.assetReader.canAddOutput(this.videoReader)) {
      this.assetReader.addOutput(this.videoReader);
    }
    if ((!(this.audioReader instanceof EmptyReaderOutput)) && (this.assetReader.canAddOutput(this.audioReader))) {
      this.assetReader.addOutput(this.audioReader);
    }
    this.assetWriter = new AssetWriter(this.exportSession.outputFilePath, this.exportSession.outputFileType);
    this.assetWriter.setRenderContextParams(this.renderContextParams);
    if (this.exportSession.timeRange != null)
    {
      this.assetWriter.startSessionAtSourceTime(this.exportSession.timeRange.getStart());
      this.assetWriter.endSessionAtSourceTime(this.exportSession.timeRange.getEnd());
      if (this.reportSession != null) {
        this.reportSession.setFileDurationUs(this.exportSession.timeRange.getDurationUs());
      }
    }
    this.assetWriter.setEncodeOption(this.encodeOption);
    this.videoWriter = createVideoWriterInput();
    if (!(this.audioReader instanceof EmptyReaderOutput)) {
      this.audioWriter = createAudioWriterInput();
    }
    if (this.assetWriter.canAddInput(this.videoWriter))
    {
      Matrix localMatrix = null;
      if (this.exportSession.appliesPreferredTrackTransform) {
        localMatrix = DecoderUtils.getPreferMatrix(new CGSize(this.encodeOption.getOutputWidth(), this.encodeOption.getOutputHeight()), this.exportSession.asset.getNaturalSize(), this.exportSession.asset.getPreferRotation());
      }
      this.videoWriter.setTransform(localMatrix);
      this.assetWriter.addInput(this.videoWriter);
    }
    if ((this.audioWriter != null) && (this.assetWriter.canAddInput(this.audioWriter))) {
      this.assetWriter.addInput(this.audioWriter);
    }
    this.assetWriter.startWriting(this.mediaFactory);
    this.assetReader.startReading(this.assetWriter);
    AppMethodBeat.o(215456);
  }
  
  void cancel()
  {
    try
    {
      AppMethodBeat.i(215957);
      this.cancel = true;
      if (this.reportSession != null)
      {
        this.reportSession.reset();
        this.reportSession = null;
      }
      if (this.exportHandler != null) {
        this.exportHandler.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(215172);
            AssetExportThread.access$1900(AssetExportThread.this);
            AppMethodBeat.o(215172);
          }
        });
      }
      AppMethodBeat.o(215957);
      return;
    }
    finally {}
  }
  
  public ExportReportSession getReportSession()
  {
    return this.reportSession;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(215976);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215976);
      return true;
      if (!this.isFinishing)
      {
        if (this.cancel) {
          finish();
        }
        if ((this.videoWriterDone) && (this.audioWriterDone) && (this.audioReadFinish) && (this.videoReadFinish)) {
          finish();
        }
      }
    }
  }
  
  public void setMediaFactory(IMediaFactory paramIMediaFactory)
  {
    this.mediaFactory = paramIMediaFactory;
  }
  
  void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    AppMethodBeat.i(215985);
    this.renderContextParams = paramRenderContextParams;
    if (this.assetWriter != null) {
      this.assetWriter.setRenderContextParams(paramRenderContextParams);
    }
    AppMethodBeat.o(215985);
  }
  
  public void setTimeoutParameter(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215950);
    this.isNeedCheckFrameProcessTimeout = paramBoolean1;
    this.timeoutInterruptWork = paramBoolean2;
    Logger.i("AssetExportThread", "setNeedCheckFrameProcessTimeout:%b timeoutInterruptWork:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(215950);
  }
  
  void startExport()
  {
    AppMethodBeat.i(215966);
    start();
    this.cancel = false;
    if (this.reportSession != null) {
      this.reportSession.onExportStart(System.nanoTime());
    }
    this.exportHandler = new Handler(getLooper(), this);
    this.exportHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(215173);
        AssetExportThread.access$2000(AssetExportThread.this);
        AppMethodBeat.o(215173);
      }
    });
    AppMethodBeat.o(215966);
  }
  
  class AudioFrameOperateTimeoutCallback
    implements Runnable
  {
    private AudioFrameOperateTimeoutCallback() {}
    
    public void run()
    {
      AppMethodBeat.i(215120);
      if (SystemClock.uptimeMillis() - AssetExportThread.this.lastHandleAudioTimeStamp >= 20000L)
      {
        if (AssetExportThread.this.timeoutInterruptWork)
        {
          Logger.i("AssetExportThread", "audioTimeout");
          AssetExportThread.access$1102(AssetExportThread.this, true);
          AssetExportThread.access$1900(AssetExportThread.this);
          AppMethodBeat.o(215120);
          return;
        }
        AssetExportThread.this.exportSession.processErrorStatus = new ExportErrorStatus(-204);
      }
      AppMethodBeat.o(215120);
    }
  }
  
  class AudioRequestMediaDataCallback
    implements Runnable
  {
    private AudioRequestMediaDataCallback() {}
    
    private void onAudioRequestMediaData()
    {
      boolean bool = true;
      AppMethodBeat.i(215341);
      Object localObject2;
      while ((!AssetExportThread.this.audioWriterDone) && (!AssetExportThread.this.cancel) && (AssetExportThread.this.audioWriter != null))
      {
        AssetExportThread.access$3702(AssetExportThread.this, SystemClock.uptimeMillis());
        if (AssetExportThread.this.isNeedCheckFrameProcessTimeout)
        {
          AssetExportThread.this.exportHandler.removeCallbacks(AssetExportThread.this.audioTimeoutCallback);
          AssetExportThread.this.exportHandler.postDelayed(AssetExportThread.this.audioTimeoutCallback, 20000L);
        }
        if ((AssetExportThread.this.audioReader != null) && (AssetExportThread.this.audioWriter.isReadyForMoreMediaData()))
        {
          AssetExportThread.this.audioReader.duration();
          localObject1 = AssetExportThread.this.audioReader.copyNextSampleBuffer(true);
          localObject2 = ((CMSampleBuffer)localObject1).getState();
          if (((CMSampleState)localObject2).getStateCode() < 0L) {
            break label273;
          }
          localObject2 = AssetExportThread.this.audioWriter.appendSampleBuffer((CMSampleBuffer)localObject1);
          if (localObject2 != null) {
            AssetExportThread.access$3000(AssetExportThread.this, (ExportErrorStatus)localObject2);
          }
          if (((CMSampleBuffer)localObject1).getTime().getTimeUs() >= AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs()) {
            AssetExportThread.this.audioWriter.markAsFinished();
          }
        }
      }
      label217:
      Object localObject1 = AssetExportThread.this;
      if (!AssetExportThread.this.cancel) {}
      for (;;)
      {
        AssetExportThread.access$3902((AssetExportThread)localObject1, bool);
        AssetExportThread.this.exportHandler.removeCallbacks(AssetExportThread.this.audioTimeoutCallback);
        AssetExportThread.this.exportHandler.sendEmptyMessage(2);
        AppMethodBeat.o(215341);
        return;
        label273:
        if (((CMSampleState)localObject2).getStateCode() == -1L)
        {
          AssetExportThread.this.audioWriter.markAsFinished();
          break label217;
        }
        if (((CMSampleState)localObject2).getStateCode() == -4L) {
          break;
        }
        AssetExportThread.access$3000(AssetExportThread.this, new ExportErrorStatus((CMSampleState)localObject2));
        break label217;
        bool = false;
      }
    }
    
    public void run()
    {
      AppMethodBeat.i(215359);
      try
      {
        onAudioRequestMediaData();
        AppMethodBeat.o(215359);
        return;
      }
      finally
      {
        Logger.e("AssetExportThread", "AudioRequestMediaDateCallback run: ", localThrowable);
        AssetExportThread.access$800(AssetExportThread.this, -15, localThrowable);
        AppMethodBeat.o(215359);
      }
    }
  }
  
  class AudioWriterProgressListener
    implements AssetWriterInput.WriterProgressListener
  {
    private AudioWriterProgressListener() {}
    
    public void onError(ExportErrorStatus paramExportErrorStatus)
    {
      AppMethodBeat.i(215142);
      Logger.e("AssetExportThread", "AudioWriterProgressListener onError: ", paramExportErrorStatus.throwable);
      AssetExportThread.access$3000(AssetExportThread.this, paramExportErrorStatus);
      AppMethodBeat.o(215142);
    }
    
    public void onProgressChanged(AssetWriterInput paramAssetWriterInput, long paramLong)
    {
      AppMethodBeat.i(215132);
      Logger.i("AssetExportSession", "onProgressChanged: audioWriter " + paramLong + "  / " + AssetExportThread.access$2500(AssetExportThread.this));
      if (paramLong == -1L)
      {
        AssetExportThread.access$3502(AssetExportThread.this, AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs());
        AssetExportThread.access$2902(AssetExportThread.this, 1.0F);
        AssetExportThread.access$1702(AssetExportThread.this, true);
        AssetExportThread.this.exportHandler.sendEmptyMessage(2);
        AppMethodBeat.o(215132);
        return;
      }
      AssetExportThread.access$3502(AssetExportThread.this, paramLong);
      if (AssetExportThread.this.exportSession.timeRange != null) {
        paramLong = AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs();
      }
      for (;;)
      {
        if (paramLong != 0L) {
          AssetExportThread.access$2902(AssetExportThread.this, (float)AssetExportThread.this.videoTime * 1.0F / (float)paramLong);
        }
        for (;;)
        {
          AssetExportThread.this.exportSession.progress = Math.min(AssetExportThread.this.videoProgress, AssetExportThread.this.audioProgress);
          if (AssetExportThread.this.callbackHandler != null) {
            AssetExportThread.this.callbackHandler.handlerCallback(AssetExportThread.this.exportSession);
          }
          if (((AssetExportThread.this.audioTime > AssetExportThread.this.videoTime) && (AssetExportThread.this.videoWriterDone)) || (AssetExportThread.this.audioTime >= AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs()))
          {
            AssetExportThread.access$3502(AssetExportThread.this, AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs());
            AssetExportThread.access$1702(AssetExportThread.this, true);
            AssetExportThread.this.exportHandler.sendEmptyMessage(2);
          }
          AppMethodBeat.o(215132);
          return;
          if (AssetExportThread.this.audioReader == null) {
            break label373;
          }
          paramLong = AssetExportThread.this.audioReader.duration();
          break;
          AssetExportThread.access$2902(AssetExportThread.this, 1.0F);
        }
        label373:
        paramLong = 0L;
      }
    }
  }
  
  class VideoFrameOperateTimeoutCallback
    implements Runnable
  {
    private VideoFrameOperateTimeoutCallback() {}
    
    public void run()
    {
      AppMethodBeat.i(215138);
      if (SystemClock.uptimeMillis() - AssetExportThread.this.lastHandleVideoTimeStamp >= 20000L)
      {
        if (AssetExportThread.this.timeoutInterruptWork)
        {
          AssetExportThread.access$1402(AssetExportThread.this, true);
          Logger.i("AssetExportThread", "videoTimeout");
          AssetExportThread.access$1900(AssetExportThread.this);
          AppMethodBeat.o(215138);
          return;
        }
        AssetExportThread.this.exportSession.processErrorStatus = new ExportErrorStatus(-203);
      }
      AppMethodBeat.o(215138);
    }
  }
  
  class VideoRequestMediaDataCallback
    implements Runnable
  {
    private long cost = 0L;
    private long frame = 1L;
    
    private VideoRequestMediaDataCallback() {}
    
    private void onRequestMediaData()
    {
      boolean bool = false;
      AppMethodBeat.i(215270);
      for (;;)
      {
        Object localObject;
        CMSampleState localCMSampleState;
        if ((!AssetExportThread.this.videoWriterDone) && (!AssetExportThread.this.cancel))
        {
          AssetExportThread.access$3102(AssetExportThread.this, SystemClock.uptimeMillis());
          if (AssetExportThread.this.isNeedCheckFrameProcessTimeout)
          {
            AssetExportThread.this.exportHandler.removeCallbacks(AssetExportThread.this.videoTimeoutCallback);
            AssetExportThread.this.exportHandler.postDelayed(AssetExportThread.this.videoTimeoutCallback, 20000L);
          }
          System.currentTimeMillis();
          if ((AssetExportThread.this.videoReader == null) || (!AssetExportThread.this.videoWriter.isReadyForMoreMediaData())) {
            break label425;
          }
          long l = System.nanoTime();
          localObject = AssetExportThread.this.videoReader.copyNextSampleBuffer(true);
          if (AssetExportThread.this.reportSession != null) {
            AssetExportThread.this.reportSession.tickDecode(System.nanoTime() - l);
          }
          localCMSampleState = ((CMSampleBuffer)localObject).getState();
          Logger.i("AssetExportThread", "onRequestMediaData stateCode: " + localCMSampleState.getStateCode());
          if (localCMSampleState.getStateCode() >= 0L)
          {
            localObject = AssetExportThread.this.videoWriter.appendSampleBuffer((CMSampleBuffer)localObject);
            if (localObject != null) {
              AssetExportThread.access$3000(AssetExportThread.this, (ExportErrorStatus)localObject);
            }
            if (AssetExportThread.this.reportSession == null) {
              continue;
            }
            AssetExportThread.this.reportSession.tickExport(System.nanoTime() - l);
            continue;
          }
          if (!localCMSampleState.stateMatchingTo(new long[] { -1L })) {
            break label394;
          }
          AssetExportThread.this.videoWriter.markAsFinished();
        }
        for (;;)
        {
          if (AssetExportThread.this.videoWriter.matrixFilter != null) {
            AssetExportThread.this.videoWriter.matrixFilter.release();
          }
          if (AssetExportThread.this.exportSession.videoCompositing != null) {
            AssetExportThread.this.exportSession.videoCompositing.release();
          }
          localObject = AssetExportThread.this;
          if (!AssetExportThread.this.cancel) {
            bool = true;
          }
          AssetExportThread.access$3402((AssetExportThread)localObject, bool);
          AssetExportThread.this.exportHandler.removeCallbacks(AssetExportThread.this.videoTimeoutCallback);
          AssetExportThread.this.exportHandler.sendEmptyMessage(1);
          AppMethodBeat.o(215270);
          return;
          label394:
          if (localCMSampleState.getStateCode() == -4L) {
            break;
          }
          AssetExportThread.access$3000(AssetExportThread.this, new ExportErrorStatus(localCMSampleState));
        }
        label425:
        Logger.i("AssetExportThread", "leex not ReadyForMoreMediaData");
      }
    }
    
    public void run()
    {
      AppMethodBeat.i(215289);
      try
      {
        onRequestMediaData();
        AppMethodBeat.o(215289);
        return;
      }
      finally
      {
        Logger.e("AssetExportThread", "VideoRequestMediaDateCallback run: ", localThrowable);
        AssetExportThread.access$800(AssetExportThread.this, -14, localThrowable);
        AppMethodBeat.o(215289);
      }
    }
  }
  
  class VideoWriterProgressListener
    implements AssetWriterInput.WriterProgressListener
  {
    private VideoWriterProgressListener() {}
    
    public void onError(ExportErrorStatus paramExportErrorStatus)
    {
      AppMethodBeat.i(215170);
      Logger.e("AssetExportThread", "VideoWriterProgressListener onError: ", paramExportErrorStatus.throwable);
      AssetExportThread.access$3000(AssetExportThread.this, paramExportErrorStatus);
      AppMethodBeat.o(215170);
    }
    
    public void onProgressChanged(AssetWriterInput paramAssetWriterInput, long paramLong)
    {
      AppMethodBeat.i(215156);
      Logger.i("AssetExportSession", "onProgressChanged: videoWriter " + paramLong + "  / " + AssetExportThread.access$2500(AssetExportThread.this));
      if (paramLong == -1L)
      {
        AssetExportThread.access$2602(AssetExportThread.this, AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs());
        AssetExportThread.access$2702(AssetExportThread.this, 1.0F);
        AssetExportThread.access$1602(AssetExportThread.this, true);
        AssetExportThread.this.exportHandler.sendEmptyMessage(1);
        AppMethodBeat.o(215156);
        return;
      }
      AssetExportThread.access$2602(AssetExportThread.this, paramLong);
      if (AssetExportThread.this.exportSession.timeRange != null) {
        paramLong = AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs();
      }
      for (;;)
      {
        if (paramLong != 0L) {
          AssetExportThread.access$2702(AssetExportThread.this, (float)AssetExportThread.this.videoTime * 1.0F / (float)paramLong);
        }
        for (;;)
        {
          AssetExportThread.this.exportSession.progress = Math.min(AssetExportThread.this.videoProgress, AssetExportThread.this.audioProgress);
          if (AssetExportThread.this.callbackHandler != null) {
            AssetExportThread.this.callbackHandler.handlerCallback(AssetExportThread.this.exportSession);
          }
          AppMethodBeat.o(215156);
          return;
          if (AssetExportThread.this.videoReader == null) {
            break label273;
          }
          paramLong = AssetExportThread.this.videoReader.duration();
          break;
          AssetExportThread.access$2702(AssetExportThread.this, 1.0F);
        }
        label273:
        paramLong = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread
 * JD-Core Version:    0.7.0.1
 */