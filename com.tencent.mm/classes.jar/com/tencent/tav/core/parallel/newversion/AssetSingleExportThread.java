package com.tencent.tav.core.parallel.newversion;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.codec.IMediaFactory;
import com.tencent.tav.core.AssetParallelExportSession;
import com.tencent.tav.core.AssetParallelSegmentStatus;
import com.tencent.tav.core.AssetReader;
import com.tencent.tav.core.AssetReaderAudioMixOutput;
import com.tencent.tav.core.AssetReaderOutput;
import com.tencent.tav.core.AssetReaderVideoCompositionOutput;
import com.tencent.tav.core.AssetWriter;
import com.tencent.tav.core.AssetWriterInput;
import com.tencent.tav.core.AssetWriterInput.WriterProgressListener;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.EmptyReaderOutput;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.report.AverageTimeReporter;
import com.tencent.tav.report.ExportReportSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AssetSingleExportThread
  extends HandlerThread
  implements Handler.Callback
{
  public static final int FRAME_OPERATE_TIMEOUT = 20000;
  private static final int msg_done_a = 2;
  private static final int msg_done_v = 1;
  private final String TAG;
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
  private volatile boolean cancel;
  private final ExportConfig encodeOption;
  private Handler exportHandler;
  private AssetParallelExportSession exportSession;
  private volatile boolean hasError;
  public PipelineIndicatorInfo indicatorInfo;
  private volatile boolean isFinishing;
  private boolean isNeedCheckFrameProcessTimeout;
  private volatile boolean isReleased;
  private long lastHandleAudioTimeStamp;
  private long lastHandleVideoTimeStamp;
  private IMediaFactory mediaFactory;
  private y<PipelineIndicatorInfo> observer;
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
  
  public AssetSingleExportThread(PipelineIndicatorInfo paramPipelineIndicatorInfo, AssetParallelExportSession paramAssetParallelExportSession, AudioMix paramAudioMix, ExportConfig paramExportConfig)
  {
    super("ExportThread");
    AppMethodBeat.i(215649);
    this.TAG = ("AssetExportThread-" + hashCode());
    this.videoWriterDone = false;
    this.audioWriterDone = false;
    this.videoReadFinish = false;
    this.audioReadFinish = false;
    this.videoTime = 0L;
    this.audioTime = 0L;
    this.cancel = false;
    this.hasError = false;
    this.videoTimeout = false;
    this.audioTimeout = false;
    this.isReleased = false;
    this.reportSession = new ExportReportSession();
    this.videoTimeoutCallback = new VideoFrameOperateTimeoutCallback(null);
    this.audioTimeoutCallback = new AudioFrameOperateTimeoutCallback(null);
    this.lastHandleVideoTimeStamp = SystemClock.uptimeMillis();
    this.lastHandleAudioTimeStamp = SystemClock.uptimeMillis();
    this.isNeedCheckFrameProcessTimeout = true;
    this.timeoutInterruptWork = false;
    this.indicatorInfo = paramPipelineIndicatorInfo;
    this.audioMix = paramAudioMix;
    this.exportSession = paramAssetParallelExportSession;
    this.audioInfo = new AudioInfo(paramExportConfig.getAudioSampleRateHz(), paramExportConfig.getAudioChannelCount(), 2);
    this.encodeOption = paramExportConfig;
    AppMethodBeat.o(215649);
  }
  
  private AssetReaderOutput createAudioTrackOutput()
  {
    AppMethodBeat.i(215738);
    Object localObject = (ArrayList)this.exportSession.asset.tracksWithMediaType(2);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = new AssetReaderAudioMixOutput((ArrayList)localObject, null, this.mediaFactory);
      ((AssetReaderAudioMixOutput)localObject).setAudioMix(this.audioMix);
      ((AssetReaderAudioMixOutput)localObject).setAudioInfo(this.audioInfo);
      AppMethodBeat.o(215738);
      return localObject;
    }
    localObject = new EmptyReaderOutput();
    AppMethodBeat.o(215738);
    return localObject;
  }
  
  private AssetWriterInput createAudioWriterInput()
  {
    AppMethodBeat.i(215718);
    AssetWriterInput localAssetWriterInput = new AssetWriterInput(2);
    AppMethodBeat.o(215718);
    return localAssetWriterInput;
  }
  
  private AssetReaderOutput createVideoTrackOutput()
  {
    AppMethodBeat.i(215730);
    Object localObject = this.exportSession.asset.tracksWithMediaType(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("frame-rate", Integer.valueOf(this.encodeOption.getVideoFrameRate()));
      localObject = new AssetReaderVideoCompositionOutput((List)localObject, localHashMap, this.exportSession.assetExtension, this.mediaFactory);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoComposition(this.exportSession.videoComposition);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoCompositing(this.exportSession.newVideoCompositing());
      ((AssetReaderVideoCompositionOutput)localObject).setVideoRevertMode(this.exportSession.isRevertMode());
      AppMethodBeat.o(215730);
      return localObject;
    }
    localObject = new EmptyReaderOutput();
    AppMethodBeat.o(215730);
    return localObject;
  }
  
  private AssetWriterInput createVideoWriterInput()
  {
    AppMethodBeat.i(215712);
    if (this.reportSession != null) {
      this.reportSession.setFramePerSecond(this.encodeOption.getVideoFrameRate());
    }
    AssetWriterInput localAssetWriterInput = new AssetWriterInput(1);
    AppMethodBeat.o(215712);
    return localAssetWriterInput;
  }
  
  private void exportError(int paramInt, Throwable paramThrowable)
  {
    try
    {
      AppMethodBeat.i(215670);
      exportError(new ExportErrorStatus(paramInt, paramThrowable));
      AppMethodBeat.o(215670);
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
    AppMethodBeat.i(215677);
    Logger.i(this.TAG, "exportError:%s", new Object[] { paramExportErrorStatus.toString() });
    if (this.indicatorInfo.getSegmentStatus() != AssetParallelSegmentStatus.AssetParallelStatusFailed)
    {
      this.hasError = true;
      this.indicatorInfo.setSegmentStatus(AssetParallelSegmentStatus.AssetParallelStatusFailed);
      this.indicatorInfo.errorStatus = paramExportErrorStatus;
      if (this.reportSession != null) {
        this.reportSession.onExportError();
      }
      if (this.observer != null) {
        this.observer.onChanged(this.indicatorInfo);
      }
    }
    AppMethodBeat.o(215677);
  }
  
  /* Error */
  private void exportSuccess()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 474
    //   5: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 188	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread:indicatorInfo	Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;
    //   14: invokevirtual 449	com/tencent/tav/core/parallel/info/PipelineIndicatorInfo:getSegmentStatus	()Lcom/tencent/tav/core/AssetParallelSegmentStatus;
    //   17: getstatic 477	com/tencent/tav/core/AssetParallelSegmentStatus:AssetExportStatusCompleted	Lcom/tencent/tav/core/AssetParallelSegmentStatus;
    //   20: if_acmpne +14 -> 34
    //   23: aload_0
    //   24: monitorexit
    //   25: ldc_w 474
    //   28: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 188	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread:indicatorInfo	Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;
    //   38: fconst_1
    //   39: invokevirtual 481	com/tencent/tav/core/parallel/info/PipelineIndicatorInfo:setProgress	(F)V
    //   42: aload_0
    //   43: getfield 188	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread:indicatorInfo	Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;
    //   46: getstatic 477	com/tencent/tav/core/AssetParallelSegmentStatus:AssetExportStatusCompleted	Lcom/tencent/tav/core/AssetParallelSegmentStatus;
    //   49: invokevirtual 459	com/tencent/tav/core/parallel/info/PipelineIndicatorInfo:setSegmentStatus	(Lcom/tencent/tav/core/AssetParallelSegmentStatus;)V
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_0
    //   55: getfield 164	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
    //   58: ifnull +10 -> 68
    //   61: aload_0
    //   62: getfield 164	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
    //   65: invokevirtual 484	com/tencent/tav/report/ExportReportSession:onExportSuccess	()V
    //   68: aload_0
    //   69: getfield 260	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread:observer	Landroidx/lifecycle/y;
    //   72: ifnull +16 -> 88
    //   75: aload_0
    //   76: getfield 260	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread:observer	Landroidx/lifecycle/y;
    //   79: aload_0
    //   80: getfield 188	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread:indicatorInfo	Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;
    //   83: invokeinterface 472 2 0
    //   88: ldc_w 474
    //   91: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: goto -63 -> 31
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: ldc_w 474
    //   108: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	AssetSingleExportThread
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
    AppMethodBeat.i(215692);
    initReaderAndWriter();
    this.indicatorInfo.setSegmentStatus(AssetParallelSegmentStatus.AssetParallelStatusStarted);
    if (this.videoWriter != null)
    {
      this.videoExportThread = new HandlerThread("VideoWriter");
      this.videoWriter.setWriterProgressListener(new VideoWriterProgressListener(null));
      this.videoWriter.requestMediaDataWhenReadyOnQueue(this.videoExportThread, new VideoRequestMediaDataCallback(null));
      if (this.audioWriter == null) {
        break label178;
      }
      this.audioExportThread = new HandlerThread("AudioWriter");
      this.audioWriter.setWriterProgressListener(new AudioWriterProgressListener(null));
      this.audioWriter.requestMediaDataWhenReadyOnQueue(this.audioExportThread, new AudioRequestMediaDataCallback(null));
    }
    for (;;)
    {
      Logger.i(this.TAG, "[%d]exporting", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(215692);
      return;
      this.videoReadFinish = true;
      this.videoWriterDone = true;
      break;
      label178:
      this.audioReadFinish = true;
      this.audioWriterDone = true;
    }
  }
  
  private long getDuration()
  {
    long l2 = 0L;
    AppMethodBeat.i(215745);
    if ((this.indicatorInfo != null) && (this.indicatorInfo.timeRange != null))
    {
      l1 = this.indicatorInfo.timeRange.getDuration().getTimeUs();
      AppMethodBeat.o(215745);
      return l1 * 2L;
    }
    if (this.audioReader != null) {}
    for (long l1 = this.audioReader.duration();; l1 = 0L)
    {
      if (this.videoReader != null) {
        l2 = this.videoReader.duration();
      }
      AppMethodBeat.o(215745);
      return l1 + l2;
    }
  }
  
  private void initReaderAndWriter()
  {
    AppMethodBeat.i(215705);
    this.assetReader = new AssetReader(this.exportSession.asset);
    this.assetReader.setTimeRange(this.indicatorInfo.timeRange);
    this.assetWriter = new AssetWriter(this.exportSession.outputFilePath, this.exportSession.outputFileType);
    this.assetWriter.setRenderContextParams(this.renderContextParams);
    if (this.indicatorInfo.timeRange != null)
    {
      this.assetWriter.startSessionAtSourceTime(this.indicatorInfo.timeRange.getStart());
      this.assetWriter.endSessionAtSourceTime(this.indicatorInfo.timeRange.getEnd());
      if (this.reportSession != null) {
        this.reportSession.setFileDurationUs(this.indicatorInfo.timeRange.getDurationUs());
      }
    }
    this.assetWriter.setEncodeOption(this.encodeOption);
    if (this.indicatorInfo.type == 1)
    {
      this.videoReader = createVideoTrackOutput();
      if (this.assetReader.canAddOutput(this.videoReader)) {
        this.assetReader.addOutput(this.videoReader);
      }
      this.videoWriter = createVideoWriterInput();
      if (this.assetWriter.canAddInput(this.videoWriter))
      {
        Matrix localMatrix = null;
        if (this.exportSession.appliesPreferredTrackTransform) {
          localMatrix = DecoderUtils.getPreferMatrix(new CGSize(this.encodeOption.getOutputWidth(), this.encodeOption.getOutputHeight()), this.exportSession.asset.getNaturalSize(), this.exportSession.asset.getPreferRotation());
        }
        this.videoWriter.setTransform(localMatrix);
        this.assetWriter.addInput(this.videoWriter);
      }
    }
    for (;;)
    {
      this.assetWriter.startWriting(this.mediaFactory);
      this.assetWriter.prepareParallelSegmentInfo(this.indicatorInfo);
      this.assetWriter.prepareParallelSegmentInfo(this.indicatorInfo);
      this.assetReader.startReading(this.assetWriter);
      AppMethodBeat.o(215705);
      return;
      if (this.indicatorInfo.type == 2)
      {
        this.audioReader = createAudioTrackOutput();
        if ((!(this.audioReader instanceof EmptyReaderOutput)) && (this.assetReader.canAddOutput(this.audioReader))) {
          this.assetReader.addOutput(this.audioReader);
        }
        if (!(this.audioReader instanceof EmptyReaderOutput)) {
          this.audioWriter = createAudioWriterInput();
        }
        if ((this.audioWriter != null) && (this.assetWriter.canAddInput(this.audioWriter))) {
          this.assetWriter.addInput(this.audioWriter);
        }
      }
    }
  }
  
  private void releaseAudio(final Runnable paramRunnable)
  {
    AppMethodBeat.i(215664);
    if (this.audioExportThread == null)
    {
      Logger.w(this.TAG, "releaseAudio is null");
      AppMethodBeat.o(215664);
      return;
    }
    Logger.i(this.TAG, "releaseAudio");
    new Handler(this.audioExportThread.getLooper()).post(new Runnable()
    {
      public void run()
      {
        long l2 = 0L;
        AppMethodBeat.i(215627);
        if (AssetSingleExportThread.this.assetReader != null)
        {
          AssetSingleExportThread.this.assetReader.cancelReading();
          AssetSingleExportThread.access$202(AssetSingleExportThread.this, null);
        }
        ExportReportSession localExportReportSession;
        long l1;
        if (AssetSingleExportThread.this.reportSession != null)
        {
          localExportReportSession = AssetSingleExportThread.this.reportSession;
          if ((AssetSingleExportThread.this.videoReader == null) || (AssetSingleExportThread.this.videoReader.getDecodePerformance() == null)) {
            break label263;
          }
          l1 = AssetSingleExportThread.this.videoReader.getDecodePerformance().getTotal() * 1000L;
        }
        for (;;)
        {
          localExportReportSession.setTotalRealDecodeUs(l1);
          localExportReportSession = AssetSingleExportThread.this.reportSession;
          l1 = l2;
          if (AssetSingleExportThread.this.assetWriter != null)
          {
            l1 = l2;
            if (AssetSingleExportThread.this.assetWriter.getEncodePerformance() != null) {
              l1 = AssetSingleExportThread.this.assetWriter.getEncodePerformance().getTotal() * 1000L;
            }
          }
          localExportReportSession.setTotalEncodeUs(l1);
          if (AssetSingleExportThread.this.assetWriter != null) {}
          try
          {
            AssetSingleExportThread.this.assetWriter.finishWriting();
            if (AssetSingleExportThread.this.audioWriter != null) {
              AssetSingleExportThread.this.audioWriter.close();
            }
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            if (AssetSingleExportThread.this.audioExportThread != null)
            {
              if (Build.VERSION.SDK_INT >= 18)
              {
                AssetSingleExportThread.this.audioExportThread.quitSafely();
                AssetSingleExportThread.access$1002(AssetSingleExportThread.this, null);
              }
            }
            else
            {
              AppMethodBeat.o(215627);
              return;
              label263:
              l1 = 0L;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Logger.e("AssetExportSession", "code = -10 run: finishWriting error", localException);
              AssetSingleExportThread.access$600(AssetSingleExportThread.this, -10, localException);
              continue;
              AssetSingleExportThread.this.audioExportThread.quit();
            }
          }
        }
      }
    });
    AppMethodBeat.o(215664);
  }
  
  private void releaseVideo(final Runnable paramRunnable)
  {
    AppMethodBeat.i(215654);
    if (this.videoExportThread == null)
    {
      Logger.w(this.TAG, "videoExportThread is null");
      AppMethodBeat.o(215654);
      return;
    }
    Logger.i(this.TAG, "releaseVideo");
    new Handler(this.videoExportThread.getLooper()).post(new Runnable()
    {
      public void run()
      {
        long l2 = 0L;
        AppMethodBeat.i(215628);
        if (AssetSingleExportThread.this.assetReader != null)
        {
          AssetSingleExportThread.this.assetReader.cancelReading();
          AssetSingleExportThread.access$202(AssetSingleExportThread.this, null);
        }
        ExportReportSession localExportReportSession;
        long l1;
        if (AssetSingleExportThread.this.reportSession != null)
        {
          localExportReportSession = AssetSingleExportThread.this.reportSession;
          if ((AssetSingleExportThread.this.videoReader == null) || (AssetSingleExportThread.this.videoReader.getDecodePerformance() == null)) {
            break label310;
          }
          l1 = AssetSingleExportThread.this.videoReader.getDecodePerformance().getTotal() * 1000L;
        }
        for (;;)
        {
          localExportReportSession.setTotalRealDecodeUs(l1);
          localExportReportSession = AssetSingleExportThread.this.reportSession;
          l1 = l2;
          if (AssetSingleExportThread.this.assetWriter != null)
          {
            l1 = l2;
            if (AssetSingleExportThread.this.assetWriter.getEncodePerformance() != null) {
              l1 = AssetSingleExportThread.this.assetWriter.getEncodePerformance().getTotal() * 1000L;
            }
          }
          localExportReportSession.setTotalEncodeUs(l1);
          if (AssetSingleExportThread.this.assetWriter != null) {}
          try
          {
            AssetSingleExportThread.this.assetWriter.finishWriting();
            if (AssetSingleExportThread.this.videoWriter != null) {
              AssetSingleExportThread.this.videoWriter.close();
            }
            if (((AssetSingleExportThread.this.videoReader instanceof AssetReaderVideoCompositionOutput)) && (((AssetReaderVideoCompositionOutput)AssetSingleExportThread.this.videoReader).getVideoCompositing() != null)) {
              ((AssetReaderVideoCompositionOutput)AssetSingleExportThread.this.videoReader).getVideoCompositing().release();
            }
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            if (AssetSingleExportThread.this.videoExportThread != null)
            {
              if (Build.VERSION.SDK_INT >= 18)
              {
                AssetSingleExportThread.this.videoExportThread.quitSafely();
                AssetSingleExportThread.access$802(AssetSingleExportThread.this, null);
              }
            }
            else
            {
              AppMethodBeat.o(215628);
              return;
              label310:
              l1 = 0L;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Logger.e("AssetExportSession", "code = -10 run: finishWriting error", localException);
              AssetSingleExportThread.access$600(AssetSingleExportThread.this, -10, localException);
              continue;
              AssetSingleExportThread.this.videoExportThread.quit();
            }
          }
        }
      }
    });
    AppMethodBeat.o(215654);
  }
  
  void cancel()
  {
    try
    {
      AppMethodBeat.i(216015);
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
            AppMethodBeat.i(215631);
            AssetSingleExportThread.this.release(null);
            AppMethodBeat.o(215631);
          }
        });
      }
      AppMethodBeat.o(216015);
      return;
    }
    finally {}
  }
  
  public void clearResource()
  {
    AppMethodBeat.i(216010);
    if (getMuxer() != null) {
      getMuxer().clearResource();
    }
    AppMethodBeat.o(216010);
  }
  
  public IMediaMuxer getMuxer()
  {
    AppMethodBeat.i(216065);
    if ((this.assetWriter != null) && (this.assetWriter.encoderWriter() != null))
    {
      IMediaMuxer localIMediaMuxer = this.assetWriter.encoderWriter().getMuxer();
      AppMethodBeat.o(216065);
      return localIMediaMuxer;
    }
    AppMethodBeat.o(216065);
    return null;
  }
  
  public ExportReportSession getReportSession()
  {
    return this.reportSession;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(216040);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216040);
      return true;
      Logger.i(this.TAG, "handleMessage:%d", new Object[] { Integer.valueOf(paramMessage.what) });
      if (!this.isFinishing)
      {
        if (this.cancel)
        {
          Logger.i(this.TAG, "setSegmentStatus AssetParallelStatusCancelled");
          this.isFinishing = true;
          this.indicatorInfo.setSegmentStatus(AssetParallelSegmentStatus.AssetParallelStatusCancelled);
          if (this.observer != null) {
            this.observer.onChanged(this.indicatorInfo);
          }
          AppMethodBeat.o(216040);
          return true;
        }
        if ((this.videoWriterDone) && (this.audioWriterDone) && (this.audioReadFinish) && (this.videoReadFinish))
        {
          Logger.i(this.TAG, "setSegmentStatus AssetExportStatusCompleted");
          this.isFinishing = true;
          this.indicatorInfo.setSegmentStatus(AssetParallelSegmentStatus.AssetExportStatusCompleted);
          if (this.observer != null) {
            this.observer.onChanged(this.indicatorInfo);
          }
        }
      }
    }
  }
  
  public void observe(y<PipelineIndicatorInfo> paramy)
  {
    this.observer = paramy;
  }
  
  public void release(Runnable paramRunnable)
  {
    AppMethodBeat.i(216005);
    Logger.i(this.TAG, "finish");
    if (this.isReleased)
    {
      Logger.w(this.TAG, "already release");
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      AppMethodBeat.o(216005);
      return;
    }
    this.isReleased = true;
    releaseVideo(paramRunnable);
    releaseAudio(paramRunnable);
    if (Build.VERSION.SDK_INT >= 18)
    {
      quitSafely();
      AppMethodBeat.o(216005);
      return;
    }
    quit();
    AppMethodBeat.o(216005);
  }
  
  public void setMediaFactory(IMediaFactory paramIMediaFactory)
  {
    this.mediaFactory = paramIMediaFactory;
  }
  
  void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    AppMethodBeat.i(216048);
    this.renderContextParams = paramRenderContextParams;
    if (this.assetWriter != null) {
      this.assetWriter.setRenderContextParams(paramRenderContextParams);
    }
    AppMethodBeat.o(216048);
  }
  
  public void setTimeoutParameter(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(216030);
    this.isNeedCheckFrameProcessTimeout = paramBoolean1;
    this.timeoutInterruptWork = paramBoolean2;
    Logger.i(this.TAG, "setNeedCheckFrameProcessTimeout:%b timeoutInterruptWork:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(216030);
  }
  
  void startExport()
  {
    AppMethodBeat.i(216023);
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
        AppMethodBeat.i(215630);
        AssetSingleExportThread.access$1100(AssetSingleExportThread.this);
        AppMethodBeat.o(215630);
      }
    });
    AppMethodBeat.o(216023);
  }
  
  class AudioFrameOperateTimeoutCallback
    implements Runnable
  {
    private AudioFrameOperateTimeoutCallback() {}
    
    public void run()
    {
      AppMethodBeat.i(215626);
      if (SystemClock.uptimeMillis() - AssetSingleExportThread.this.lastHandleAudioTimeStamp >= 20000L)
      {
        Logger.i(AssetSingleExportThread.this.TAG, "audioTimeout");
        AssetSingleExportThread.access$4002(AssetSingleExportThread.this, true);
        AssetSingleExportThread.this.indicatorInfo.setSegmentStatus(AssetParallelSegmentStatus.AssetParallelStatusTimeout);
        AssetSingleExportThread.this.indicatorInfo.errorStatus = new ExportErrorStatus(-204, null, "handle audio timeout");
        if (AssetSingleExportThread.this.observer != null)
        {
          AssetSingleExportThread.this.observer.onChanged(AssetSingleExportThread.this.indicatorInfo);
          AppMethodBeat.o(215626);
        }
      }
      else
      {
        Logger.i(AssetSingleExportThread.this.TAG, "Maybe app into background audio");
      }
      AppMethodBeat.o(215626);
    }
  }
  
  class AudioRequestMediaDataCallback
    implements Runnable
  {
    private AudioRequestMediaDataCallback() {}
    
    private void onAudioRequestMediaData()
    {
      boolean bool = false;
      AppMethodBeat.i(215641);
      Object localObject1;
      Object localObject2;
      while ((!AssetSingleExportThread.this.audioWriterDone) && (!AssetSingleExportThread.this.cancel) && (AssetSingleExportThread.this.audioWriter != null) && (!AssetSingleExportThread.this.hasError))
      {
        AssetSingleExportThread.access$3502(AssetSingleExportThread.this, SystemClock.uptimeMillis());
        if (AssetSingleExportThread.this.isNeedCheckFrameProcessTimeout)
        {
          AssetSingleExportThread.this.exportHandler.removeCallbacks(AssetSingleExportThread.this.audioTimeoutCallback);
          AssetSingleExportThread.this.exportHandler.postDelayed(AssetSingleExportThread.this.audioTimeoutCallback, 20000L);
        }
        if ((AssetSingleExportThread.this.audioReader != null) && (AssetSingleExportThread.this.audioWriter.isReadyForMoreMediaData()))
        {
          AssetSingleExportThread.this.audioReader.duration();
          localObject1 = AssetSingleExportThread.this.audioReader.copyNextSampleBuffer(false);
          localObject2 = ((CMSampleBuffer)localObject1).getState();
          if (((CMSampleState)localObject2).getStateCode() < 0L) {
            break label286;
          }
          localObject2 = AssetSingleExportThread.this.audioWriter.appendSampleBuffer((CMSampleBuffer)localObject1, false);
          if (localObject2 != null) {
            AssetSingleExportThread.access$2300(AssetSingleExportThread.this, (ExportErrorStatus)localObject2);
          }
          if (((CMSampleBuffer)localObject1).getTime().getTimeUs() >= AssetSingleExportThread.this.indicatorInfo.timeRange.getDuration().getTimeUs()) {
            AssetSingleExportThread.this.audioWriter.markAsFinished();
          }
        }
      }
      for (;;)
      {
        localObject1 = AssetSingleExportThread.this;
        if (!AssetSingleExportThread.this.cancel) {
          bool = true;
        }
        AssetSingleExportThread.access$3702((AssetSingleExportThread)localObject1, bool);
        AssetSingleExportThread.this.exportHandler.removeCallbacks(AssetSingleExportThread.this.audioTimeoutCallback);
        AssetSingleExportThread.this.exportHandler.sendEmptyMessage(2);
        AppMethodBeat.o(215641);
        return;
        label286:
        if (((CMSampleState)localObject2).getStateCode() == -1L)
        {
          AssetSingleExportThread.this.audioWriter.markAsFinished();
        }
        else
        {
          if (((CMSampleState)localObject2).getStateCode() == -4L) {
            break;
          }
          AssetSingleExportThread.access$2300(AssetSingleExportThread.this, new ExportErrorStatus((CMSampleState)localObject2));
        }
      }
    }
    
    public void run()
    {
      AppMethodBeat.i(215650);
      try
      {
        onAudioRequestMediaData();
        AppMethodBeat.o(215650);
        return;
      }
      finally
      {
        Logger.e(AssetSingleExportThread.this.TAG, "AudioRequestMediaDateCallback run: ", localThrowable);
        AssetSingleExportThread.access$600(AssetSingleExportThread.this, -15, localThrowable);
        AppMethodBeat.o(215650);
      }
    }
  }
  
  class AudioWriterProgressListener
    implements AssetWriterInput.WriterProgressListener
  {
    private AudioWriterProgressListener() {}
    
    public void onError(ExportErrorStatus paramExportErrorStatus)
    {
      AppMethodBeat.i(215646);
      Logger.e(AssetSingleExportThread.this.TAG, "AudioWriterProgressListener onError: ", paramExportErrorStatus.throwable);
      AssetSingleExportThread.access$2300(AssetSingleExportThread.this, paramExportErrorStatus);
      AppMethodBeat.o(215646);
    }
    
    public void onProgressChanged(AssetWriterInput paramAssetWriterInput, long paramLong)
    {
      AppMethodBeat.i(215638);
      Logger.d("AssetExportSession", "onProgressChanged: audioWriter " + paramLong + "  / " + AssetSingleExportThread.access$1700(AssetSingleExportThread.this));
      if (paramLong == -1L)
      {
        AssetSingleExportThread.access$3102(AssetSingleExportThread.this, AssetSingleExportThread.this.indicatorInfo.timeRange.getDuration().getTimeUs());
        AssetSingleExportThread.access$3202(AssetSingleExportThread.this, 1.0F);
        AssetSingleExportThread.access$3302(AssetSingleExportThread.this, true);
        AssetSingleExportThread.this.exportHandler.sendEmptyMessage(2);
        AppMethodBeat.o(215638);
        return;
      }
      AssetSingleExportThread.access$3102(AssetSingleExportThread.this, paramLong);
      if (AssetSingleExportThread.this.indicatorInfo.timeRange != null) {
        paramLong = AssetSingleExportThread.this.indicatorInfo.timeRange.getDuration().getTimeUs();
      }
      for (;;)
      {
        if (paramLong != 0L) {
          AssetSingleExportThread.access$3202(AssetSingleExportThread.this, (float)AssetSingleExportThread.this.videoTime * 1.0F / (float)paramLong);
        }
        for (;;)
        {
          AssetSingleExportThread.this.indicatorInfo.setProgress(AssetSingleExportThread.this.audioProgress);
          if (AssetSingleExportThread.this.observer != null) {
            AssetSingleExportThread.this.observer.onChanged(AssetSingleExportThread.this.indicatorInfo);
          }
          if (AssetSingleExportThread.this.audioTime >= AssetSingleExportThread.this.indicatorInfo.timeRange.getDuration().getTimeUs())
          {
            AssetSingleExportThread.access$3102(AssetSingleExportThread.this, AssetSingleExportThread.this.indicatorInfo.timeRange.getDuration().getTimeUs());
            AssetSingleExportThread.access$3302(AssetSingleExportThread.this, true);
            AssetSingleExportThread.this.exportHandler.sendEmptyMessage(2);
          }
          AppMethodBeat.o(215638);
          return;
          if (AssetSingleExportThread.this.audioReader == null) {
            break label335;
          }
          paramLong = AssetSingleExportThread.this.audioReader.duration();
          break;
          AssetSingleExportThread.access$3202(AssetSingleExportThread.this, 1.0F);
        }
        label335:
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
      AppMethodBeat.i(215648);
      if (SystemClock.uptimeMillis() - AssetSingleExportThread.this.lastHandleVideoTimeStamp >= 20000L) {
        if (AssetSingleExportThread.this.timeoutInterruptWork)
        {
          AssetSingleExportThread.access$3902(AssetSingleExportThread.this, true);
          Logger.i(AssetSingleExportThread.this.TAG, "videoTimeout");
          AssetSingleExportThread.this.indicatorInfo.setSegmentStatus(AssetParallelSegmentStatus.AssetParallelStatusTimeout);
          AssetSingleExportThread.this.indicatorInfo.errorStatus = new ExportErrorStatus(-203, null, "handle video timeout");
          if (AssetSingleExportThread.this.observer != null)
          {
            AssetSingleExportThread.this.observer.onChanged(AssetSingleExportThread.this.indicatorInfo);
            AppMethodBeat.o(215648);
          }
        }
        else
        {
          AssetSingleExportThread.this.exportSession.processErrorStatus = new ExportErrorStatus(-203);
        }
      }
      AppMethodBeat.o(215648);
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
      AppMethodBeat.i(215622);
      for (;;)
      {
        Object localObject;
        CMSampleState localCMSampleState;
        if ((!AssetSingleExportThread.this.videoWriterDone) && (!AssetSingleExportThread.this.cancel) && (!AssetSingleExportThread.this.hasError))
        {
          AssetSingleExportThread.access$2602(AssetSingleExportThread.this, SystemClock.uptimeMillis());
          if (AssetSingleExportThread.this.isNeedCheckFrameProcessTimeout)
          {
            AssetSingleExportThread.this.exportHandler.removeCallbacks(AssetSingleExportThread.this.videoTimeoutCallback);
            AssetSingleExportThread.this.exportHandler.postDelayed(AssetSingleExportThread.this.videoTimeoutCallback, 20000L);
          }
          System.currentTimeMillis();
          if ((AssetSingleExportThread.this.videoReader == null) || (!AssetSingleExportThread.this.videoWriter.isReadyForMoreMediaData())) {
            break label463;
          }
          long l = System.nanoTime();
          localObject = AssetSingleExportThread.this.videoReader.copyNextSampleBuffer(false);
          if (AssetSingleExportThread.this.reportSession != null) {
            AssetSingleExportThread.this.reportSession.tickDecode(System.nanoTime() - l);
          }
          localCMSampleState = ((CMSampleBuffer)localObject).getState();
          if (localCMSampleState.getStateCode() < 0L) {
            Logger.i(AssetSingleExportThread.this.TAG, "onRequestMediaData stateCode: " + localCMSampleState.getStateCode());
          }
          if (localCMSampleState.getStateCode() >= 0L)
          {
            localObject = AssetSingleExportThread.this.videoWriter.appendSampleBuffer((CMSampleBuffer)localObject, true);
            if (localObject != null) {
              AssetSingleExportThread.access$2300(AssetSingleExportThread.this, (ExportErrorStatus)localObject);
            }
            if (AssetSingleExportThread.this.reportSession == null) {
              continue;
            }
            AssetSingleExportThread.this.reportSession.tickExport(System.nanoTime() - l);
            continue;
          }
          if (!localCMSampleState.stateMatchingTo(new long[] { -1L })) {
            break label432;
          }
          AssetSingleExportThread.this.videoWriter.markAsFinished();
          Logger.i(AssetSingleExportThread.this.TAG, "markAsFinished");
        }
        for (;;)
        {
          if (AssetSingleExportThread.this.videoWriter.matrixFilter != null) {
            AssetSingleExportThread.this.videoWriter.matrixFilter.release();
          }
          if (AssetSingleExportThread.this.exportSession.videoCompositing != null) {
            AssetSingleExportThread.this.exportSession.videoCompositing.release();
          }
          localObject = AssetSingleExportThread.this;
          if (!AssetSingleExportThread.this.cancel) {
            bool = true;
          }
          AssetSingleExportThread.access$3002((AssetSingleExportThread)localObject, bool);
          AssetSingleExportThread.this.exportHandler.removeCallbacks(AssetSingleExportThread.this.videoTimeoutCallback);
          AssetSingleExportThread.this.exportHandler.sendEmptyMessage(1);
          AppMethodBeat.o(215622);
          return;
          label432:
          if (localCMSampleState.getStateCode() == -4L) {
            break;
          }
          AssetSingleExportThread.access$2300(AssetSingleExportThread.this, new ExportErrorStatus(localCMSampleState));
        }
        label463:
        Logger.i(AssetSingleExportThread.this.TAG, "leex not ReadyForMoreMediaData");
      }
    }
    
    public void run()
    {
      AppMethodBeat.i(215633);
      try
      {
        onRequestMediaData();
        AppMethodBeat.o(215633);
        return;
      }
      finally
      {
        Logger.e(AssetSingleExportThread.this.TAG, "VideoRequestMediaDateCallback run: ", localThrowable);
        AssetSingleExportThread.access$600(AssetSingleExportThread.this, -14, localThrowable);
        AppMethodBeat.o(215633);
      }
    }
  }
  
  class VideoWriterProgressListener
    implements AssetWriterInput.WriterProgressListener
  {
    private VideoWriterProgressListener() {}
    
    public void onError(ExportErrorStatus paramExportErrorStatus)
    {
      AppMethodBeat.i(215623);
      Logger.e(AssetSingleExportThread.this.TAG, "VideoWriterProgressListener onError: ", paramExportErrorStatus.throwable);
      AssetSingleExportThread.access$2300(AssetSingleExportThread.this, paramExportErrorStatus);
      AppMethodBeat.o(215623);
    }
    
    public void onProgressChanged(AssetWriterInput paramAssetWriterInput, long paramLong)
    {
      AppMethodBeat.i(215620);
      Logger.d(AssetSingleExportThread.this.TAG, "onProgressChanged: videoWriter " + paramLong + "  / " + AssetSingleExportThread.access$1700(AssetSingleExportThread.this));
      if (paramLong == -1L)
      {
        AssetSingleExportThread.access$1802(AssetSingleExportThread.this, AssetSingleExportThread.this.indicatorInfo.timeRange.getDuration().getTimeUs());
        AssetSingleExportThread.access$1902(AssetSingleExportThread.this, 1.0F);
        AssetSingleExportThread.access$2002(AssetSingleExportThread.this, true);
        AssetSingleExportThread.this.exportHandler.sendEmptyMessage(1);
        AppMethodBeat.o(215620);
        return;
      }
      AssetSingleExportThread.access$1802(AssetSingleExportThread.this, paramLong);
      if (AssetSingleExportThread.this.indicatorInfo.timeRange != null) {
        paramLong = AssetSingleExportThread.this.indicatorInfo.timeRange.getDuration().getTimeUs();
      }
      for (;;)
      {
        if (paramLong != 0L) {
          AssetSingleExportThread.access$1902(AssetSingleExportThread.this, (float)AssetSingleExportThread.this.videoTime * 1.0F / (float)paramLong);
        }
        for (;;)
        {
          AssetSingleExportThread.this.indicatorInfo.setProgress(AssetSingleExportThread.this.videoProgress);
          if (AssetSingleExportThread.this.observer != null) {
            AssetSingleExportThread.this.observer.onChanged(AssetSingleExportThread.this.indicatorInfo);
          }
          AppMethodBeat.o(215620);
          return;
          if (AssetSingleExportThread.this.videoReader == null) {
            break label268;
          }
          paramLong = AssetSingleExportThread.this.videoReader.duration();
          break;
          AssetSingleExportThread.access$1902(AssetSingleExportThread.this, 1.0F);
        }
        label268:
        paramLong = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.newversion.AssetSingleExportThread
 * JD-Core Version:    0.7.0.1
 */