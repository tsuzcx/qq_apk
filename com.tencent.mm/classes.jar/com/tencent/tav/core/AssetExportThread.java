package com.tencent.tav.core;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.ExportReportSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class AssetExportThread
  extends HandlerThread
  implements Handler.Callback
{
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
  private AssetWriterInput audioWriter;
  private volatile boolean audioWriterDone;
  private AssetExportSession.ExportCallbackHandler callbackHandler;
  private volatile boolean cancel;
  private final ExportConfig encodeOption;
  private Handler exportHandler;
  private AssetExportSession exportSession;
  private boolean isFinishing;
  private RenderContextParams renderContextParams;
  private ExportReportSession reportSession;
  private AssetWriterVideoEncoder videoEncoder;
  private HandlerThread videoExportThread;
  private float videoProgress;
  private boolean videoReadFinish;
  private AssetReaderOutput videoReader;
  private long videoTime;
  private AssetWriterInput videoWriter;
  private volatile boolean videoWriterDone;
  
  AssetExportThread(AssetExportSession paramAssetExportSession, AssetExportSession.ExportCallbackHandler paramExportCallbackHandler, AudioMix paramAudioMix, ExportConfig paramExportConfig)
  {
    super("ExportThread");
    AppMethodBeat.i(217709);
    this.videoWriterDone = false;
    this.audioWriterDone = false;
    this.videoReadFinish = false;
    this.audioReadFinish = false;
    this.videoTime = 0L;
    this.audioTime = 0L;
    this.cancel = false;
    this.reportSession = new ExportReportSession();
    this.exportSession = paramAssetExportSession;
    this.callbackHandler = paramExportCallbackHandler;
    this.audioMix = paramAudioMix;
    this.audioInfo = new AudioInfo(paramExportConfig.getAudioSampleRateHz(), paramExportConfig.getAudioChannelCount(), 2);
    this.encodeOption = paramExportConfig;
    AppMethodBeat.o(217709);
  }
  
  private AssetReaderOutput createAudioTrackOutput()
  {
    AppMethodBeat.i(217721);
    Object localObject = (ArrayList)this.exportSession.asset.tracksWithMediaType(2);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = new AssetReaderAudioMixOutput((ArrayList)localObject, null);
      ((AssetReaderAudioMixOutput)localObject).setAudioMix(this.audioMix);
      ((AssetReaderAudioMixOutput)localObject).setAudioInfo(this.audioInfo);
      AppMethodBeat.o(217721);
      return localObject;
    }
    localObject = new EmptyReaderOutput();
    AppMethodBeat.o(217721);
    return localObject;
  }
  
  private AssetWriterInput createAudioWriterInput()
  {
    AppMethodBeat.i(217719);
    AssetWriterInput localAssetWriterInput = new AssetWriterInput(2);
    AppMethodBeat.o(217719);
    return localAssetWriterInput;
  }
  
  private AssetReaderOutput createVideoTrackOutput()
  {
    AppMethodBeat.i(217720);
    Object localObject = this.exportSession.asset.tracksWithMediaType(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("frame-rate", Integer.valueOf(this.encodeOption.getVideoFrameRate()));
      localObject = new AssetReaderVideoCompositionOutput((List)localObject, localHashMap, this.exportSession.assetExtension);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoComposition(this.exportSession.videoComposition);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoCompositing(this.exportSession.videoCompositing);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoRevertMode(this.exportSession.isRevertMode());
      AppMethodBeat.o(217720);
      return localObject;
    }
    localObject = new EmptyReaderOutput();
    AppMethodBeat.o(217720);
    return localObject;
  }
  
  private AssetWriterInput createVideoWriterInput()
  {
    AppMethodBeat.i(217718);
    if (this.reportSession != null) {
      this.reportSession.setFramePerSecond(this.encodeOption.getVideoFrameRate());
    }
    AssetWriterInput localAssetWriterInput = new AssetWriterInput(1);
    AppMethodBeat.o(217718);
    return localAssetWriterInput;
  }
  
  private void exportError(int paramInt, Throwable paramThrowable)
  {
    try
    {
      AppMethodBeat.i(217712);
      exportError(new ExportErrorStatus(paramInt, paramThrowable));
      AppMethodBeat.o(217712);
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
    AppMethodBeat.i(217713);
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
    AppMethodBeat.o(217713);
  }
  
  /* Error */
  private void exportSuccess()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 372
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 112	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   14: getfield 353	com/tencent/tav/core/AssetExportSession:status	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   17: getstatic 375	com/tencent/tav/core/AssetExportSession$AssetExportSessionStatus:AssetExportSessionStatusCompleted	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   20: if_acmpne +14 -> 34
    //   23: aload_0
    //   24: monitorexit
    //   25: ldc_w 372
    //   28: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 112	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   38: fconst_1
    //   39: putfield 378	com/tencent/tav/core/AssetExportSession:progress	F
    //   42: aload_0
    //   43: getfield 112	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   46: getstatic 375	com/tencent/tav/core/AssetExportSession$AssetExportSessionStatus:AssetExportSessionStatusCompleted	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   49: putfield 353	com/tencent/tav/core/AssetExportSession:status	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_0
    //   55: getfield 110	com/tencent/tav/core/AssetExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
    //   58: ifnull +10 -> 68
    //   61: aload_0
    //   62: getfield 110	com/tencent/tav/core/AssetExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
    //   65: invokevirtual 381	com/tencent/tav/report/ExportReportSession:onExportSuccess	()V
    //   68: aload_0
    //   69: getfield 114	com/tencent/tav/core/AssetExportThread:callbackHandler	Lcom/tencent/tav/core/AssetExportSession$ExportCallbackHandler;
    //   72: ifnull +16 -> 88
    //   75: aload_0
    //   76: getfield 114	com/tencent/tav/core/AssetExportThread:callbackHandler	Lcom/tencent/tav/core/AssetExportSession$ExportCallbackHandler;
    //   79: aload_0
    //   80: getfield 112	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   83: invokeinterface 371 2 0
    //   88: ldc_w 372
    //   91: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: goto -63 -> 31
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: ldc_w 372
    //   108: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   105	113	97	finally
    //   10	25	102	finally
    //   34	54	102	finally
    //   103	105	102	finally
  }
  
  private void exporting()
  {
    AppMethodBeat.i(217716);
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
      AppMethodBeat.o(217716);
      return;
    }
    this.audioReadFinish = true;
    this.audioWriterDone = true;
    AppMethodBeat.o(217716);
  }
  
  private void finish()
  {
    AppMethodBeat.i(217710);
    new Handler(this.videoExportThread.getLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(217699);
        if (AssetExportThread.this.videoExportThread != null)
        {
          if (Build.VERSION.SDK_INT >= 18)
          {
            AssetExportThread.this.videoExportThread.quitSafely();
            AssetExportThread.access$002(AssetExportThread.this, null);
          }
        }
        else if (AssetExportThread.this.audioExportThread != null)
        {
          if (Build.VERSION.SDK_INT < 18) {
            break label283;
          }
          AssetExportThread.this.audioExportThread.quitSafely();
        }
        for (;;)
        {
          AssetExportThread.access$102(AssetExportThread.this, null);
          if (AssetExportThread.this.assetReader != null)
          {
            AssetExportThread.this.assetReader.cancelReading();
            AssetExportThread.access$202(AssetExportThread.this, null);
          }
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
              AssetExportThread.access$400(AssetExportThread.this, -10, localException);
              i = j;
              continue;
              AssetExportThread.this.quit();
            }
          }
          AssetExportThread.access$302(AssetExportThread.this, null);
          if (AssetExportThread.this.videoWriter != null) {
            AssetExportThread.this.videoWriter.close();
          }
          if (AssetExportThread.this.audioWriter != null) {
            AssetExportThread.this.audioWriter.close();
          }
          if ((AssetExportThread.this.videoWriterDone) && (AssetExportThread.this.audioWriterDone) && (i != 0) && (!AssetExportThread.this.cancel)) {
            AssetExportThread.access$1000(AssetExportThread.this);
          }
          if (Build.VERSION.SDK_INT < 18) {
            break label321;
          }
          AssetExportThread.this.quitSafely();
          if (AssetExportThread.this.exportSession != null) {
            AssetExportThread.this.exportSession.release();
          }
          AppMethodBeat.o(217699);
          return;
          AssetExportThread.this.videoExportThread.quit();
          break;
          label283:
          AssetExportThread.this.audioExportThread.quit();
        }
      }
    });
    AppMethodBeat.o(217710);
  }
  
  private long getDuration()
  {
    long l2 = 0L;
    AppMethodBeat.i(217722);
    if ((this.exportSession != null) && (this.exportSession.timeRange != null))
    {
      l1 = this.exportSession.timeRange.getDuration().getTimeUs();
      AppMethodBeat.o(217722);
      return l1 * 2L;
    }
    if (this.audioReader != null) {}
    for (long l1 = this.audioReader.duration();; l1 = 0L)
    {
      if (this.videoReader != null) {
        l2 = this.videoReader.duration();
      }
      AppMethodBeat.o(217722);
      return l1 + l2;
    }
  }
  
  private void initReaderAndWriter()
  {
    AppMethodBeat.i(217717);
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
    this.assetWriter.startWriting(this.videoEncoder);
    this.assetReader.startReading(this.assetWriter);
    AppMethodBeat.o(217717);
  }
  
  void cancel()
  {
    try
    {
      AppMethodBeat.i(217711);
      this.cancel = true;
      this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled;
      if (this.reportSession != null)
      {
        this.reportSession.reset();
        this.reportSession = null;
      }
      AppMethodBeat.o(217711);
      return;
    }
    finally {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(217723);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(217723);
      return true;
      if (!this.isFinishing)
      {
        if (this.cancel)
        {
          this.isFinishing = true;
          finish();
        }
        if ((this.videoWriterDone) && (this.audioWriterDone) && (this.audioReadFinish) && (this.videoReadFinish))
        {
          this.isFinishing = true;
          finish();
        }
      }
    }
  }
  
  void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    AppMethodBeat.i(217724);
    this.renderContextParams = paramRenderContextParams;
    if (this.assetWriter != null) {
      this.assetWriter.setRenderContextParams(paramRenderContextParams);
    }
    AppMethodBeat.o(217724);
  }
  
  public void setVideoEncoder(AssetWriterVideoEncoder paramAssetWriterVideoEncoder)
  {
    this.videoEncoder = paramAssetWriterVideoEncoder;
  }
  
  void startExport()
  {
    AppMethodBeat.i(217715);
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
        AppMethodBeat.i(217700);
        AssetExportThread.access$1200(AssetExportThread.this);
        AppMethodBeat.o(217700);
      }
    });
    AppMethodBeat.o(217715);
  }
  
  class AudioRequestMediaDataCallback
    implements Runnable
  {
    private AudioRequestMediaDataCallback() {}
    
    private void onAudioRequestMediaData()
    {
      AppMethodBeat.i(217702);
      Object localObject2;
      while ((!AssetExportThread.this.audioWriterDone) && (!AssetExportThread.this.cancel) && (AssetExportThread.this.audioWriter != null)) {
        if ((AssetExportThread.this.audioReader != null) && (AssetExportThread.this.audioWriter.isReadyForMoreMediaData()))
        {
          AssetExportThread.this.audioReader.duration();
          localObject1 = AssetExportThread.this.audioReader.copyNextSampleBuffer();
          localObject2 = ((CMSampleBuffer)localObject1).getState();
          if (((CMSampleState)localObject2).getStateCode() < 0L) {
            break label196;
          }
          localObject2 = AssetExportThread.this.audioWriter.appendSampleBuffer((CMSampleBuffer)localObject1);
          if (localObject2 != null) {
            AssetExportThread.access$2400(AssetExportThread.this, (ExportErrorStatus)localObject2);
          }
          if (((CMSampleBuffer)localObject1).getTime().getTimeUs() >= AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs()) {
            AssetExportThread.this.audioWriter.markAsFinished();
          }
        }
      }
      label155:
      Object localObject1 = AssetExportThread.this;
      if (!AssetExportThread.this.cancel) {}
      for (boolean bool = true;; bool = false)
      {
        AssetExportThread.access$2902((AssetExportThread)localObject1, bool);
        AssetExportThread.this.exportHandler.sendEmptyMessage(2);
        AppMethodBeat.o(217702);
        return;
        label196:
        if (((CMSampleState)localObject2).getStateCode() == -1L)
        {
          AssetExportThread.this.audioWriter.markAsFinished();
          break label155;
        }
        if (((CMSampleState)localObject2).getStateCode() == -4L) {
          break;
        }
        AssetExportThread.access$2400(AssetExportThread.this, new ExportErrorStatus((CMSampleState)localObject2));
        break label155;
      }
    }
    
    public void run()
    {
      AppMethodBeat.i(217701);
      try
      {
        onAudioRequestMediaData();
        AppMethodBeat.o(217701);
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("AssetExportThread", "AudioRequestMediaDateCallback run: ", localThrowable);
        AssetExportThread.access$400(AssetExportThread.this, -15, localThrowable);
        AppMethodBeat.o(217701);
      }
    }
  }
  
  class AudioWriterProgressListener
    implements AssetWriterInput.WriterProgressListener
  {
    private AudioWriterProgressListener() {}
    
    public void onError(ExportErrorStatus paramExportErrorStatus)
    {
      AppMethodBeat.i(217704);
      Logger.e("AssetExportThread", "AudioWriterProgressListener onError: ", paramExportErrorStatus.throwable);
      AssetExportThread.access$2400(AssetExportThread.this, paramExportErrorStatus);
      AppMethodBeat.o(217704);
    }
    
    public void onProgressChanged(AssetWriterInput paramAssetWriterInput, long paramLong)
    {
      AppMethodBeat.i(217703);
      Logger.i("AssetExportSession", "onProgressChanged: audioWriter " + paramLong + "  / " + AssetExportThread.access$1700(AssetExportThread.this));
      if (paramLong == -1L)
      {
        AssetExportThread.access$2702(AssetExportThread.this, AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs());
        AssetExportThread.access$2202(AssetExportThread.this, 1.0F);
        AssetExportThread.access$802(AssetExportThread.this, true);
        AssetExportThread.this.exportHandler.sendEmptyMessage(2);
        AppMethodBeat.o(217703);
        return;
      }
      AssetExportThread.access$2702(AssetExportThread.this, paramLong);
      if (AssetExportThread.this.exportSession.timeRange != null) {
        paramLong = AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs();
      }
      for (;;)
      {
        if (paramLong != 0L) {
          AssetExportThread.access$2202(AssetExportThread.this, (float)AssetExportThread.this.videoTime * 1.0F / (float)paramLong);
        }
        for (;;)
        {
          AssetExportThread.this.exportSession.progress = Math.min(AssetExportThread.this.videoProgress, AssetExportThread.this.audioProgress);
          if (AssetExportThread.this.callbackHandler != null) {
            AssetExportThread.this.callbackHandler.handlerCallback(AssetExportThread.this.exportSession);
          }
          if (((AssetExportThread.this.audioTime > AssetExportThread.this.videoTime) && (AssetExportThread.this.videoWriterDone)) || (AssetExportThread.this.audioTime >= AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs()))
          {
            AssetExportThread.access$2702(AssetExportThread.this, AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs());
            AssetExportThread.access$802(AssetExportThread.this, true);
            AssetExportThread.this.exportHandler.sendEmptyMessage(2);
          }
          AppMethodBeat.o(217703);
          return;
          if (AssetExportThread.this.audioReader == null) {
            break label373;
          }
          paramLong = AssetExportThread.this.audioReader.duration();
          break;
          AssetExportThread.access$2202(AssetExportThread.this, 1.0F);
        }
        label373:
        paramLong = 0L;
      }
    }
  }
  
  class VideoRequestMediaDataCallback
    implements Runnable
  {
    private VideoRequestMediaDataCallback() {}
    
    private void onRequestMediaData()
    {
      boolean bool = false;
      AppMethodBeat.i(217706);
      Object localObject;
      CMSampleState localCMSampleState;
      while ((!AssetExportThread.this.videoWriterDone) && (!AssetExportThread.this.cancel)) {
        if ((AssetExportThread.this.videoReader != null) && (AssetExportThread.this.videoWriter.isReadyForMoreMediaData()))
        {
          long l = System.nanoTime();
          localObject = AssetExportThread.this.videoReader.copyNextSampleBuffer();
          localCMSampleState = ((CMSampleBuffer)localObject).getState();
          Logger.i("AssetExportThread", "onRequestMediaData stateCode: " + localCMSampleState.getStateCode());
          if (localCMSampleState.getStateCode() >= 0L)
          {
            localObject = AssetExportThread.this.videoWriter.appendSampleBuffer((CMSampleBuffer)localObject);
            if (localObject != null) {
              AssetExportThread.access$2400(AssetExportThread.this, (ExportErrorStatus)localObject);
            }
            if (AssetExportThread.this.reportSession != null) {
              AssetExportThread.this.reportSession.tickExport(System.nanoTime() - l);
            }
          }
          else
          {
            if (!localCMSampleState.stateMatchingTo(new long[] { -1L })) {
              break label288;
            }
            AssetExportThread.this.videoWriter.markAsFinished();
          }
        }
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
        AssetExportThread.access$2602((AssetExportThread)localObject, bool);
        AssetExportThread.this.exportHandler.sendEmptyMessage(1);
        AppMethodBeat.o(217706);
        return;
        label288:
        if (localCMSampleState.getStateCode() == -4L) {
          break;
        }
        AssetExportThread.access$2400(AssetExportThread.this, new ExportErrorStatus(localCMSampleState));
      }
    }
    
    public void run()
    {
      AppMethodBeat.i(217705);
      try
      {
        onRequestMediaData();
        AppMethodBeat.o(217705);
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("AssetExportThread", "VideoRequestMediaDateCallback run: ", localThrowable);
        AssetExportThread.access$400(AssetExportThread.this, -14, localThrowable);
        AppMethodBeat.o(217705);
      }
    }
  }
  
  class VideoWriterProgressListener
    implements AssetWriterInput.WriterProgressListener
  {
    private VideoWriterProgressListener() {}
    
    public void onError(ExportErrorStatus paramExportErrorStatus)
    {
      AppMethodBeat.i(217708);
      Logger.e("AssetExportThread", "VideoWriterProgressListener onError: ", paramExportErrorStatus.throwable);
      AssetExportThread.access$2400(AssetExportThread.this, paramExportErrorStatus);
      AppMethodBeat.o(217708);
    }
    
    public void onProgressChanged(AssetWriterInput paramAssetWriterInput, long paramLong)
    {
      AppMethodBeat.i(217707);
      Logger.i("AssetExportSession", "onProgressChanged: videoWriter " + paramLong + "  / " + AssetExportThread.access$1700(AssetExportThread.this));
      if (paramLong == -1L)
      {
        AssetExportThread.access$1802(AssetExportThread.this, AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs());
        AssetExportThread.access$1902(AssetExportThread.this, 1.0F);
        AssetExportThread.access$702(AssetExportThread.this, true);
        AssetExportThread.this.exportHandler.sendEmptyMessage(1);
        AppMethodBeat.o(217707);
        return;
      }
      AssetExportThread.access$1802(AssetExportThread.this, paramLong);
      if (AssetExportThread.this.exportSession.timeRange != null) {
        paramLong = AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs();
      }
      for (;;)
      {
        if (paramLong != 0L) {
          AssetExportThread.access$1902(AssetExportThread.this, (float)AssetExportThread.this.videoTime * 1.0F / (float)paramLong);
        }
        for (;;)
        {
          AssetExportThread.this.exportSession.progress = Math.min(AssetExportThread.this.videoProgress, AssetExportThread.this.audioProgress);
          if (AssetExportThread.this.callbackHandler != null) {
            AssetExportThread.this.callbackHandler.handlerCallback(AssetExportThread.this.exportSession);
          }
          AppMethodBeat.o(217707);
          return;
          if (AssetExportThread.this.videoReader == null) {
            break label273;
          }
          paramLong = AssetExportThread.this.videoReader.duration();
          break;
          AssetExportThread.access$1902(AssetExportThread.this, 1.0F);
        }
        label273:
        paramLong = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread
 * JD-Core Version:    0.7.0.1
 */