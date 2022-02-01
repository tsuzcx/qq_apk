package com.tencent.tav.core;

import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.VideoDecoder;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.ExtractorUtils;
import com.tencent.tav.report.ExportReportSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetExportSession
{
  public static final String TAG = "AssetExportSession";
  private boolean appliesPreferredTrackTransform;
  private Asset asset;
  private AssetExtension assetExtension;
  private AudioMix audioMix;
  private int errCode;
  private ExportThread exportThread;
  private List<MetadataItem> metadata;
  private EncoderWriter.OutputConfig outputConfig;
  private String outputFilePath;
  private String outputFileType;
  private String presetName;
  private float progress;
  private RenderContextParams renderContextParams;
  private boolean revertMode;
  private AssetExportSessionStatus status;
  private List<String> supportedFileTypes;
  private CMTimeRange timeRange;
  private VideoCompositing videoCompositing;
  private VideoComposition videoComposition;
  
  public AssetExportSession(Asset paramAsset, EncoderWriter.OutputConfig paramOutputConfig)
  {
    this(paramAsset, paramOutputConfig, new AssetExtension("export"));
    AppMethodBeat.i(201414);
    AppMethodBeat.o(201414);
  }
  
  public AssetExportSession(Asset paramAsset, EncoderWriter.OutputConfig paramOutputConfig, AssetExtension paramAssetExtension)
  {
    AppMethodBeat.i(201415);
    this.outputFileType = "mp4";
    this.revertMode = false;
    this.appliesPreferredTrackTransform = false;
    this.asset = paramAsset;
    this.assetExtension = paramAssetExtension;
    paramAssetExtension = paramOutputConfig;
    if (paramOutputConfig == null)
    {
      paramAssetExtension = new EncoderWriter.OutputConfig();
      paramAssetExtension.VIDEO_TARGET_HEIGHT = ((int)paramAsset.getNaturalSize().height);
      paramAssetExtension.VIDEO_TARGET_WIDTH = ((int)paramAsset.getNaturalSize().width);
    }
    this.outputConfig = paramAssetExtension;
    AppMethodBeat.o(201415);
  }
  
  private void release()
  {
    AppMethodBeat.i(201418);
    Logger.i("AssetExportSession", "release", new Object[0]);
    if (this.audioMix != null)
    {
      this.audioMix.release();
      this.audioMix = null;
    }
    AppMethodBeat.o(201418);
  }
  
  public void cancelExport()
  {
    AppMethodBeat.i(201417);
    Logger.i("AssetExportSession", "cancelExport", new Object[0]);
    if (this.exportThread != null) {
      ExportThread.access$200(this.exportThread);
    }
    AppMethodBeat.o(201417);
  }
  
  public void exportAsynchronouslyWithCompletionHandler(ExportCallbackHandler paramExportCallbackHandler)
  {
    AppMethodBeat.i(201416);
    this.exportThread = new ExportThread(this, paramExportCallbackHandler, this.audioMix);
    ExportThread.access$000(this.exportThread, this.renderContextParams);
    ExportThread.access$100(this.exportThread);
    AppMethodBeat.o(201416);
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public AudioMix getAudioMix()
  {
    return this.audioMix;
  }
  
  public int getErrCode()
  {
    return this.errCode;
  }
  
  public List<MetadataItem> getMetadata()
  {
    return this.metadata;
  }
  
  public String getOutputFilePath()
  {
    return this.outputFilePath;
  }
  
  public String getOutputFileType()
  {
    return this.outputFileType;
  }
  
  public String getPresetName()
  {
    return this.presetName;
  }
  
  public float getProgress()
  {
    return this.progress;
  }
  
  public RenderContextParams getRenderContextParams()
  {
    return this.renderContextParams;
  }
  
  public AssetExportSessionStatus getStatus()
  {
    return this.status;
  }
  
  public List<String> getSupportedFileTypes()
  {
    return this.supportedFileTypes;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public VideoComposition getVideoComposition()
  {
    return this.videoComposition;
  }
  
  public boolean isRevertMode()
  {
    return this.revertMode;
  }
  
  public void setAppliesPreferredTrackTransform(boolean paramBoolean)
  {
    this.appliesPreferredTrackTransform = paramBoolean;
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    this.audioMix = paramAudioMix;
  }
  
  public void setMetadata(List<MetadataItem> paramList)
  {
    this.metadata = paramList;
  }
  
  public void setOutputFilePath(String paramString)
  {
    this.outputFilePath = paramString;
  }
  
  public void setOutputFileType(String paramString)
  {
    this.outputFileType = paramString;
  }
  
  public void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    AppMethodBeat.i(201413);
    this.renderContextParams = paramRenderContextParams;
    if (this.exportThread != null) {
      ExportThread.access$000(this.exportThread, paramRenderContextParams);
    }
    AppMethodBeat.o(201413);
  }
  
  public void setRevertMode(boolean paramBoolean)
  {
    this.revertMode = paramBoolean;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    AppMethodBeat.i(201412);
    this.videoComposition = paramVideoComposition;
    if (paramVideoComposition != null) {
      this.videoCompositing = paramVideoComposition.getCustomVideoCompositor();
    }
    AppMethodBeat.o(201412);
  }
  
  public static enum AssetExportSessionStatus
  {
    static
    {
      AppMethodBeat.i(201379);
      AssetExportSessionStatusUnknown = new AssetExportSessionStatus("AssetExportSessionStatusUnknown", 0);
      AssetExportSessionStatusExporting = new AssetExportSessionStatus("AssetExportSessionStatusExporting", 1);
      AssetExportSessionStatusCompleted = new AssetExportSessionStatus("AssetExportSessionStatusCompleted", 2);
      AssetExportSessionStatusFailed = new AssetExportSessionStatus("AssetExportSessionStatusFailed", 3);
      AssetExportSessionStatusCancelled = new AssetExportSessionStatus("AssetExportSessionStatusCancelled", 4);
      $VALUES = new AssetExportSessionStatus[] { AssetExportSessionStatusUnknown, AssetExportSessionStatusExporting, AssetExportSessionStatusCompleted, AssetExportSessionStatusFailed, AssetExportSessionStatusCancelled };
      AppMethodBeat.o(201379);
    }
    
    private AssetExportSessionStatus() {}
  }
  
  public static abstract interface ExportCallbackHandler
  {
    public abstract void handlerCallback(AssetExportSession paramAssetExportSession);
  }
  
  static class ExportThread
    extends HandlerThread
    implements Handler.Callback
  {
    private static final int msg_done_a = 2;
    private static final int msg_done_v = 1;
    private AssetReader assetReader;
    private AssetWriter assetWriter;
    private HandlerThread audioExportThread;
    private AudioInfo audioInfo;
    private AudioMix audioMix;
    private boolean audioReadFinish;
    private AssetReaderOutput audioReader;
    private long audioTime;
    private AssetWriterInput audioWriter;
    volatile boolean audioWriterDone;
    private AssetExportSession.ExportCallbackHandler callbackHandler;
    private volatile boolean cancel;
    private Handler exportHandler;
    private AssetExportSession exportSession;
    private boolean isFinishing;
    private RenderContextParams renderContextParams;
    private ExportReportSession reportSession;
    private HandlerThread videoExportThread;
    private boolean videoReadFinish;
    private AssetReaderOutput videoReader;
    private long videoTime;
    private AssetWriterInput videoWriter;
    volatile boolean videoWriterDone;
    
    ExportThread(AssetExportSession paramAssetExportSession, AssetExportSession.ExportCallbackHandler paramExportCallbackHandler, AudioMix paramAudioMix)
    {
      super();
      AppMethodBeat.i(201388);
      this.videoWriterDone = false;
      this.audioWriterDone = false;
      this.videoReadFinish = false;
      this.audioReadFinish = false;
      this.videoTime = 0L;
      this.audioTime = 0L;
      this.cancel = false;
      this.audioInfo = new AudioInfo(44100, 1, 2);
      this.reportSession = new ExportReportSession();
      this.exportSession = paramAssetExportSession;
      this.callbackHandler = paramExportCallbackHandler;
      this.audioMix = paramAudioMix;
      AppMethodBeat.o(201388);
    }
    
    private void cancel()
    {
      try
      {
        AppMethodBeat.i(201390);
        this.cancel = true;
        AssetExportSession.access$1402(this.exportSession, AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled);
        if (this.reportSession != null)
        {
          this.reportSession.reset();
          this.reportSession = null;
        }
        AppMethodBeat.o(201390);
        return;
      }
      finally {}
    }
    
    private AssetReaderOutput createAudioTrackOutput()
    {
      AppMethodBeat.i(201400);
      Object localObject = (ArrayList)this.exportSession.asset.tracksWithMediaType(2);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = new AssetReaderAudioMixOutput((ArrayList)localObject, null);
        ((AssetReaderAudioMixOutput)localObject).setAudioMix(this.audioMix);
        ((AssetReaderAudioMixOutput)localObject).setAudioInfo(this.audioInfo);
        AppMethodBeat.o(201400);
        return localObject;
      }
      AppMethodBeat.o(201400);
      return null;
    }
    
    private AssetWriterInput createAudioWriterInput()
    {
      AppMethodBeat.i(201398);
      Object localObject = new HashMap();
      ((HashMap)localObject).put("bitrate", Integer.valueOf(this.exportSession.outputConfig.AUDIO_BIT_RATE));
      ((HashMap)localObject).put("aac-profile", Integer.valueOf(this.exportSession.outputConfig.AUDIO_AAC_PROFILE));
      ((HashMap)localObject).put("channel-count", Integer.valueOf(this.exportSession.outputConfig.AUDIO_CHANNEL_COUNT));
      ((HashMap)localObject).put("mime", this.exportSession.outputConfig.AUDIO_MIME_TYPE);
      ((HashMap)localObject).put("sample-rate", Integer.valueOf(this.exportSession.outputConfig.AUDIO_SAMPLE_RATE_HZ));
      localObject = new AssetWriterInput(2, (Map)localObject);
      AppMethodBeat.o(201398);
      return localObject;
    }
    
    private AssetReaderOutput createVideoTrackOutput()
    {
      AppMethodBeat.i(201399);
      Object localObject = this.exportSession.asset.tracksWithMediaType(1);
      if (localObject != null)
      {
        HashMap localHashMap = new HashMap(4);
        localHashMap.put("frame-rate", Integer.valueOf(this.exportSession.outputConfig.VIDEO_FRAME_RATE));
        localObject = new AssetReaderVideoCompositionOutput((List)localObject, localHashMap, this.exportSession.assetExtension);
        ((AssetReaderVideoCompositionOutput)localObject).setVideoComposition(this.exportSession.videoComposition);
        ((AssetReaderVideoCompositionOutput)localObject).setVideoCompositing(this.exportSession.videoCompositing);
        ((AssetReaderVideoCompositionOutput)localObject).setVideoRevertMode(this.exportSession.isRevertMode());
        AppMethodBeat.o(201399);
        return localObject;
      }
      localObject = new EmptyReaderOutput();
      AppMethodBeat.o(201399);
      return localObject;
    }
    
    private AssetWriterInput createVideoWriterInput()
    {
      AppMethodBeat.i(201397);
      Object localObject = new HashMap();
      ((HashMap)localObject).put("bitrate", Integer.valueOf(this.exportSession.outputConfig.VIDEO_BIT_RATE));
      ((HashMap)localObject).put("frame-rate", Integer.valueOf(this.exportSession.outputConfig.VIDEO_FRAME_RATE));
      ((HashMap)localObject).put("i-frame-interval", Integer.valueOf(this.exportSession.outputConfig.VIDEO_IFRAME_INTERVAL));
      ((HashMap)localObject).put("height", Integer.valueOf(this.exportSession.outputConfig.VIDEO_TARGET_HEIGHT));
      ((HashMap)localObject).put("width", Integer.valueOf(this.exportSession.outputConfig.VIDEO_TARGET_WIDTH));
      ((HashMap)localObject).put("QUALITY", Boolean.valueOf(this.exportSession.outputConfig.VIDEO_QUALITY));
      if (this.reportSession != null) {
        this.reportSession.setFramePerSecond(this.exportSession.outputConfig.VIDEO_FRAME_RATE);
      }
      localObject = new AssetWriterInput(1, (Map)localObject);
      AppMethodBeat.o(201397);
      return localObject;
    }
    
    private void exportError(int paramInt)
    {
      try
      {
        AppMethodBeat.i(201391);
        if (this.exportSession.status != AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed)
        {
          this.cancel = true;
          AssetExportSession.access$1402(this.exportSession, AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed);
          AssetExportSession.access$1502(this.exportSession, paramInt);
          if (this.reportSession != null) {
            this.reportSession.onExportError();
          }
          if (this.callbackHandler != null) {
            this.callbackHandler.handlerCallback(this.exportSession);
          }
        }
        AppMethodBeat.o(201391);
        return;
      }
      finally {}
    }
    
    /* Error */
    private void exportSuccess()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc_w 417
      //   5: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: monitorenter
      //   10: aload_0
      //   11: getfield 107	com/tencent/tav/core/AssetExportSession$ExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
      //   14: invokestatic 400	com/tencent/tav/core/AssetExportSession:access$1400	(Lcom/tencent/tav/core/AssetExportSession;)Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
      //   17: getstatic 420	com/tencent/tav/core/AssetExportSession$AssetExportSessionStatus:AssetExportSessionStatusCompleted	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
      //   20: if_acmpne +14 -> 34
      //   23: aload_0
      //   24: monitorexit
      //   25: ldc_w 417
      //   28: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   31: aload_0
      //   32: monitorexit
      //   33: return
      //   34: aload_0
      //   35: getfield 107	com/tencent/tav/core/AssetExportSession$ExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
      //   38: fconst_1
      //   39: invokestatic 424	com/tencent/tav/core/AssetExportSession:access$1602	(Lcom/tencent/tav/core/AssetExportSession;F)F
      //   42: pop
      //   43: aload_0
      //   44: getfield 107	com/tencent/tav/core/AssetExportSession$ExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
      //   47: getstatic 420	com/tencent/tav/core/AssetExportSession$AssetExportSessionStatus:AssetExportSessionStatusCompleted	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
      //   50: invokestatic 229	com/tencent/tav/core/AssetExportSession:access$1402	(Lcom/tencent/tav/core/AssetExportSession;Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;)Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
      //   53: pop
      //   54: aload_0
      //   55: monitorexit
      //   56: aload_0
      //   57: getfield 105	com/tencent/tav/core/AssetExportSession$ExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
      //   60: ifnull +10 -> 70
      //   63: aload_0
      //   64: getfield 105	com/tencent/tav/core/AssetExportSession$ExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
      //   67: invokevirtual 427	com/tencent/tav/report/ExportReportSession:onExportSuccess	()V
      //   70: aload_0
      //   71: getfield 109	com/tencent/tav/core/AssetExportSession$ExportThread:callbackHandler	Lcom/tencent/tav/core/AssetExportSession$ExportCallbackHandler;
      //   74: ifnull +16 -> 90
      //   77: aload_0
      //   78: getfield 109	com/tencent/tav/core/AssetExportSession$ExportThread:callbackHandler	Lcom/tencent/tav/core/AssetExportSession$ExportCallbackHandler;
      //   81: aload_0
      //   82: getfield 107	com/tencent/tav/core/AssetExportSession$ExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
      //   85: invokeinterface 416 2 0
      //   90: ldc_w 417
      //   93: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   96: goto -65 -> 31
      //   99: astore_1
      //   100: aload_0
      //   101: monitorexit
      //   102: aload_1
      //   103: athrow
      //   104: astore_1
      //   105: aload_0
      //   106: monitorexit
      //   107: ldc_w 417
      //   110: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   113: aload_1
      //   114: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	115	0	this	ExportThread
      //   99	4	1	localObject1	Object
      //   104	10	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   2	10	99	finally
      //   25	31	99	finally
      //   56	70	99	finally
      //   70	90	99	finally
      //   90	96	99	finally
      //   107	115	99	finally
      //   10	25	104	finally
      //   34	56	104	finally
      //   105	107	104	finally
    }
    
    private void exporting()
    {
      AppMethodBeat.i(201394);
      Logger.i("AssetExportSession", "exporting", new Object[0]);
      initReaderAndWriter();
      AssetExportSession.access$1402(this.exportSession, AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting);
      this.videoExportThread = new HandlerThread("VideoWriter");
      this.videoWriter.setWriterProgressListener(new AssetWriterInput.WriterProgressListener()
      {
        public void onError(Throwable paramAnonymousThrowable)
        {
          AppMethodBeat.i(201383);
          Logger.e("AssetExportSession", "videoWriter onError", paramAnonymousThrowable);
          AssetExportSession.ExportThread.access$700(AssetExportSession.ExportThread.this, -12);
          AppMethodBeat.o(201383);
        }
        
        public void onProgressChanged(AssetWriterInput paramAnonymousAssetWriterInput, long paramAnonymousLong)
        {
          AppMethodBeat.i(201382);
          Logger.e("AssetExportSession", "onProgressChanged: videoWriter " + paramAnonymousLong + "  / " + AssetExportSession.ExportThread.access$1800(AssetExportSession.ExportThread.this));
          if (paramAnonymousLong == -1L)
          {
            AssetExportSession.ExportThread.access$1902(AssetExportSession.ExportThread.this, AssetExportSession.this.timeRange.getDuration().getTimeUs());
            AssetExportSession.ExportThread.this.videoWriterDone = true;
            AssetExportSession.ExportThread.this.exportHandler.sendEmptyMessage(1);
            AppMethodBeat.o(201382);
            return;
          }
          AssetExportSession.ExportThread.access$1902(AssetExportSession.ExportThread.this, paramAnonymousLong);
          AssetExportSession.access$1602(AssetExportSession.this, (float)(AssetExportSession.ExportThread.this.videoTime + AssetExportSession.ExportThread.this.audioTime) * 1.0F / (float)AssetExportSession.ExportThread.access$1800(AssetExportSession.ExportThread.this));
          if (AssetExportSession.ExportThread.this.callbackHandler != null) {
            AssetExportSession.ExportThread.this.callbackHandler.handlerCallback(AssetExportSession.this);
          }
          AppMethodBeat.o(201382);
        }
      });
      this.videoWriter.requestMediaDataWhenReadyOnQueue(this.videoExportThread, new Runnable()
      {
        public void run()
        {
          boolean bool = true;
          AppMethodBeat.i(201384);
          try
          {
            for (;;)
            {
              if ((AssetExportSession.ExportThread.this.videoWriterDone) || (AssetExportSession.ExportThread.this.cancel) || (AssetExportSession.ExportThread.this.videoReader == null)) {
                break label186;
              }
              if (AssetExportSession.ExportThread.this.videoWriter.isReadyForMoreMediaData())
              {
                long l = System.nanoTime();
                CMSampleBuffer localCMSampleBuffer = AssetExportSession.ExportThread.this.videoReader.copyNextSampleBuffer();
                if (localCMSampleBuffer.getTime().getTimeUs() < 0L) {
                  break;
                }
                int i = AssetExportSession.ExportThread.this.videoWriter.appendSampleBuffer(localCMSampleBuffer);
                if (AssetExportSession.ExportThread.access$2500(AssetExportSession.ExportThread.this, i)) {
                  AssetExportSession.ExportThread.access$700(AssetExportSession.ExportThread.this, i);
                }
                if (AssetExportSession.ExportThread.this.reportSession != null) {
                  AssetExportSession.ExportThread.this.reportSession.tickExport(System.nanoTime() - l);
                }
              }
            }
            if (localThrowable.getTime() != VideoDecoder.SAMPLE_TIME_FINISH) {
              break label281;
            }
          }
          catch (Throwable localThrowable)
          {
            Logger.e("AssetExportSession", "videoWriter requestMediaDataWhenReadyOnQueue", localThrowable);
            AssetExportSession.ExportThread.access$700(AssetExportSession.ExportThread.this, -14);
            AppMethodBeat.o(201384);
            return;
          }
          AssetExportSession.ExportThread.this.videoWriter.markAsFinished();
          label186:
          if (AssetExportSession.ExportThread.this.videoWriter.matrixFilter != null) {
            AssetExportSession.ExportThread.this.videoWriter.matrixFilter.release();
          }
          if (AssetExportSession.this.videoCompositing != null) {
            AssetExportSession.this.videoCompositing.release();
          }
          AssetExportSession.ExportThread localExportThread = AssetExportSession.ExportThread.this;
          if (!AssetExportSession.ExportThread.this.cancel) {}
          for (;;)
          {
            AssetExportSession.ExportThread.access$2802(localExportThread, bool);
            AssetExportSession.ExportThread.this.exportHandler.sendEmptyMessage(1);
            AppMethodBeat.o(201384);
            return;
            label281:
            if (localExportThread.getTime() == VideoDecoder.SAMPLE_TIME_TIMEOUT) {
              break;
            }
            AssetExportSession.ExportThread.access$700(AssetExportSession.ExportThread.this, (int)localExportThread.getTime().getValue());
            break label186;
            bool = false;
          }
        }
      });
      if (this.audioWriter != null)
      {
        this.audioExportThread = new HandlerThread("VideoWriter");
        this.audioWriter.setWriterProgressListener(new AssetWriterInput.WriterProgressListener()
        {
          public void onError(Throwable paramAnonymousThrowable)
          {
            AppMethodBeat.i(201386);
            Logger.e("AssetExportSession", "audioWriter onError", paramAnonymousThrowable);
            AssetExportSession.ExportThread.access$700(AssetExportSession.ExportThread.this, -13);
            AppMethodBeat.o(201386);
          }
          
          public void onProgressChanged(AssetWriterInput paramAnonymousAssetWriterInput, long paramAnonymousLong)
          {
            AppMethodBeat.i(201385);
            Logger.e("AssetExportSession", "onProgressChanged: audioWriter " + paramAnonymousLong + "  / " + AssetExportSession.ExportThread.access$1800(AssetExportSession.ExportThread.this));
            if (paramAnonymousLong == -1L)
            {
              AssetExportSession.ExportThread.access$2202(AssetExportSession.ExportThread.this, AssetExportSession.this.timeRange.getDuration().getTimeUs());
              AssetExportSession.ExportThread.this.audioWriterDone = true;
              AssetExportSession.ExportThread.this.exportHandler.sendEmptyMessage(2);
              AppMethodBeat.o(201385);
              return;
            }
            AssetExportSession.ExportThread.access$2202(AssetExportSession.ExportThread.this, paramAnonymousLong);
            AssetExportSession.access$1602(AssetExportSession.this, (float)(AssetExportSession.ExportThread.this.videoTime + AssetExportSession.ExportThread.this.audioTime) * 1.0F / (float)AssetExportSession.ExportThread.access$1800(AssetExportSession.ExportThread.this));
            if (AssetExportSession.ExportThread.this.callbackHandler != null) {
              AssetExportSession.ExportThread.this.callbackHandler.handlerCallback(AssetExportSession.this);
            }
            if (((AssetExportSession.ExportThread.this.audioTime > AssetExportSession.ExportThread.this.videoTime) && (AssetExportSession.ExportThread.this.videoWriterDone)) || (AssetExportSession.ExportThread.this.audioTime >= AssetExportSession.this.timeRange.getDuration().getTimeUs()))
            {
              AssetExportSession.ExportThread.access$2202(AssetExportSession.ExportThread.this, AssetExportSession.this.timeRange.getDuration().getTimeUs());
              AssetExportSession.ExportThread.this.audioWriterDone = true;
              AssetExportSession.ExportThread.this.exportHandler.sendEmptyMessage(2);
            }
            AppMethodBeat.o(201385);
          }
        });
        this.audioWriter.requestMediaDataWhenReadyOnQueue(this.audioExportThread, new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(201387);
            for (;;)
            {
              try
              {
                Object localObject;
                if ((!AssetExportSession.ExportThread.this.audioWriterDone) && (!AssetExportSession.ExportThread.this.cancel))
                {
                  if ((AssetExportSession.ExportThread.this.audioReader == null) || (!AssetExportSession.ExportThread.this.audioWriter.isReadyForMoreMediaData())) {
                    continue;
                  }
                  AssetExportSession.ExportThread.this.audioReader.duration();
                  localObject = AssetExportSession.ExportThread.this.audioReader.copyNextSampleBuffer();
                  if (((CMSampleBuffer)localObject).getTime().getTimeUs() >= 0L)
                  {
                    int i = AssetExportSession.ExportThread.this.audioWriter.appendSampleBuffer((CMSampleBuffer)localObject);
                    if (AssetExportSession.ExportThread.access$2500(AssetExportSession.ExportThread.this, i)) {
                      AssetExportSession.ExportThread.access$700(AssetExportSession.ExportThread.this, i);
                    }
                    if (((CMSampleBuffer)localObject).getTime().getTimeUs() < AssetExportSession.this.timeRange.getDuration().getTimeUs()) {
                      continue;
                    }
                    AssetExportSession.ExportThread.this.audioWriter.markAsFinished();
                  }
                }
                else
                {
                  localObject = AssetExportSession.ExportThread.this;
                  if (AssetExportSession.ExportThread.this.cancel) {
                    break label266;
                  }
                  bool = true;
                  AssetExportSession.ExportThread.access$3002((AssetExportSession.ExportThread)localObject, bool);
                  AssetExportSession.ExportThread.this.exportHandler.sendEmptyMessage(2);
                  AppMethodBeat.o(201387);
                  return;
                }
                if (((CMSampleBuffer)localObject).getTime() == VideoDecoder.SAMPLE_TIME_FINISH)
                {
                  AssetExportSession.ExportThread.this.audioWriter.markAsFinished();
                  continue;
                }
                if (localThrowable.getTime() == VideoDecoder.SAMPLE_TIME_TIMEOUT) {
                  continue;
                }
              }
              catch (Throwable localThrowable)
              {
                Logger.e("AssetExportSession", "audioWriter requestMediaDataWhenReadyOnQueue", localThrowable);
                AssetExportSession.ExportThread.access$700(AssetExportSession.ExportThread.this, -15);
                AppMethodBeat.o(201387);
                return;
              }
              AssetExportSession.ExportThread.access$700(AssetExportSession.ExportThread.this, (int)localThrowable.getTime().getValue());
              continue;
              label266:
              boolean bool = false;
            }
          }
        });
        AppMethodBeat.o(201394);
        return;
      }
      this.audioTime = this.exportSession.timeRange.getDuration().getTimeUs();
      this.audioWriterDone = true;
      this.audioReadFinish = true;
      this.exportHandler.sendEmptyMessage(2);
      AppMethodBeat.o(201394);
    }
    
    private void finish()
    {
      AppMethodBeat.i(201389);
      new Handler(this.videoExportThread.getLooper()).post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(201380);
          if (AssetExportSession.ExportThread.this.videoExportThread != null)
          {
            if (Build.VERSION.SDK_INT >= 18)
            {
              AssetExportSession.ExportThread.this.videoExportThread.quitSafely();
              AssetExportSession.ExportThread.access$302(AssetExportSession.ExportThread.this, null);
            }
          }
          else if (AssetExportSession.ExportThread.this.audioExportThread != null)
          {
            if (Build.VERSION.SDK_INT < 18) {
              break label283;
            }
            AssetExportSession.ExportThread.this.audioExportThread.quitSafely();
          }
          for (;;)
          {
            AssetExportSession.ExportThread.access$402(AssetExportSession.ExportThread.this, null);
            if (AssetExportSession.ExportThread.this.assetReader != null)
            {
              AssetExportSession.ExportThread.this.assetReader.cancelReading();
              AssetExportSession.ExportThread.access$502(AssetExportSession.ExportThread.this, null);
            }
            i = 0;
            j = 0;
            if (AssetExportSession.ExportThread.this.assetWriter != null) {}
            try
            {
              AssetExportSession.ExportThread.this.assetWriter.finishWriting();
              i = 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Logger.e("AssetExportSession", "code = -10 run: finishWriting error", localException);
                AssetExportSession.ExportThread.access$700(AssetExportSession.ExportThread.this, -10);
                i = j;
                continue;
                AssetExportSession.ExportThread.this.quit();
              }
            }
            AssetExportSession.ExportThread.access$602(AssetExportSession.ExportThread.this, null);
            if (AssetExportSession.ExportThread.this.videoWriter != null) {
              AssetExportSession.ExportThread.this.videoWriter.close();
            }
            if (AssetExportSession.ExportThread.this.audioWriter != null) {
              AssetExportSession.ExportThread.this.audioWriter.close();
            }
            if ((AssetExportSession.ExportThread.this.videoWriterDone) && (AssetExportSession.ExportThread.this.audioWriterDone) && (i != 0) && (!AssetExportSession.ExportThread.this.cancel)) {
              AssetExportSession.ExportThread.access$1100(AssetExportSession.ExportThread.this);
            }
            if (Build.VERSION.SDK_INT < 18) {
              break label320;
            }
            AssetExportSession.ExportThread.this.quitSafely();
            if (AssetExportSession.this != null) {
              AssetExportSession.access$1300(AssetExportSession.this);
            }
            AppMethodBeat.o(201380);
            return;
            AssetExportSession.ExportThread.this.videoExportThread.quit();
            break;
            label283:
            AssetExportSession.ExportThread.this.audioExportThread.quit();
          }
        }
      });
      AppMethodBeat.o(201389);
    }
    
    private long getDuration()
    {
      long l2 = 0L;
      AppMethodBeat.i(201401);
      if ((this.exportSession != null) && (this.exportSession.timeRange != null))
      {
        l1 = this.exportSession.timeRange.getDuration().getTimeUs();
        AppMethodBeat.o(201401);
        return l1 * 2L;
      }
      if (this.audioReader != null) {}
      for (long l1 = this.audioReader.duration();; l1 = 0L)
      {
        if (this.videoReader != null) {
          l2 = this.videoReader.duration();
        }
        AppMethodBeat.o(201401);
        return l1 + l2;
      }
    }
    
    private Matrix getPreferMatrix()
    {
      AppMethodBeat.i(201396);
      int i = this.exportSession.asset.getPreferRotation();
      CGSize localCGSize = this.exportSession.asset.getNaturalSize();
      Matrix localMatrix1 = new Matrix();
      DecoderUtils.getMatrixAndCropRect(localCGSize, i, 1.0F, 0.0F, new Point(0, 0), localMatrix1);
      Matrix localMatrix2 = new Matrix();
      localCGSize = ExtractorUtils.getTransformedSize(localCGSize, i, 0.0F);
      float f1;
      float f2;
      if (localCGSize.width * 1.0F / this.exportSession.outputConfig.VIDEO_TARGET_WIDTH > 1.0F * localCGSize.height / this.exportSession.outputConfig.VIDEO_TARGET_HEIGHT)
      {
        f1 = this.exportSession.outputConfig.VIDEO_TARGET_WIDTH / localCGSize.width;
        localMatrix2.setScale(f1, f1);
        f2 = localCGSize.height;
        localMatrix2.postTranslate(0.0F, Math.round((this.exportSession.outputConfig.VIDEO_TARGET_HEIGHT - f2 * f1) * 0.5F));
      }
      for (;;)
      {
        localMatrix1.postConcat(localMatrix2);
        AppMethodBeat.o(201396);
        return localMatrix1;
        f1 = this.exportSession.outputConfig.VIDEO_TARGET_HEIGHT / localCGSize.height;
        localMatrix2.setScale(f1, f1);
        f2 = localCGSize.width;
        localMatrix2.postTranslate(Math.round((this.exportSession.outputConfig.VIDEO_TARGET_WIDTH - f2 * f1) * 0.5F), 0.0F);
      }
    }
    
    private void initReaderAndWriter()
    {
      AppMethodBeat.i(201395);
      this.assetReader = new AssetReader(this.exportSession.asset);
      this.assetReader.setTimeRange(this.exportSession.timeRange);
      this.videoReader = createVideoTrackOutput();
      this.audioReader = createAudioTrackOutput();
      if (this.assetReader.canAddOutput(this.videoReader)) {
        this.assetReader.addOutput(this.videoReader);
      }
      if (this.audioReader != null) {
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
      this.videoWriter = createVideoWriterInput();
      if (this.audioReader != null) {
        this.audioWriter = createAudioWriterInput();
      }
      if (this.assetWriter.canAddInput(this.videoWriter))
      {
        Matrix localMatrix = null;
        if (this.exportSession.appliesPreferredTrackTransform) {
          localMatrix = getPreferMatrix();
        }
        this.videoWriter.setTransform(localMatrix);
        this.assetWriter.addInput(this.videoWriter);
      }
      if (this.audioWriter != null) {
        this.assetWriter.addInput(this.audioWriter);
      }
      this.assetWriter.startWriting();
      this.assetReader.startReading(this.assetWriter);
      AppMethodBeat.o(201395);
    }
    
    private boolean isExportingStop(int paramInt)
    {
      return (paramInt == -11) || (paramInt == -18) || (paramInt == -19) || (paramInt == -20) || (paramInt == -21) || (paramInt == -22) || (paramInt == -23) || (paramInt == -24);
    }
    
    private void setRenderContextParams(RenderContextParams paramRenderContextParams)
    {
      AppMethodBeat.i(201403);
      this.renderContextParams = paramRenderContextParams;
      if (this.assetWriter != null) {
        this.assetWriter.setRenderContextParams(paramRenderContextParams);
      }
      AppMethodBeat.o(201403);
    }
    
    private void startExport()
    {
      AppMethodBeat.i(201393);
      Logger.i("AssetExportSession", "startExport", new Object[0]);
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
          AppMethodBeat.i(201381);
          AssetExportSession.ExportThread.access$1700(AssetExportSession.ExportThread.this);
          AppMethodBeat.o(201381);
        }
      });
      AppMethodBeat.o(201393);
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(201402);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(201402);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportSession
 * JD-Core Version:    0.7.0.1
 */