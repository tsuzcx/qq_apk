package com.tencent.tav.core;

import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetWriterInput
{
  private static final String TAG = "AssetWriterInput";
  private AssetWriter assetWriter;
  private boolean canPerformMultiplePasses;
  private boolean expectsMediaDataInRealTime;
  private String extendedLanguageTag;
  private Handler handler;
  private Handler.Callback handlerCallback;
  private HandlerThread handlerThread;
  private String languageCode;
  private boolean marksOutputTrackAsEnabled;
  Filter matrixFilter;
  private int mediaTimeScale;
  private int mediaType;
  private List<MetadataItem> metadata;
  private CGSize naturalSize;
  private Map<String, Object> outputSettings;
  private boolean performsMultiPassEncodingIfSupported;
  private int preferredMediaChunkAlignment;
  private CMTime preferredMediaChunkDuration;
  private float preferredVolume;
  private WriterProgressListener progressListener;
  private boolean readyForMoreMediaData;
  private boolean started;
  private StatusListener statusListener;
  private boolean stop;
  private Matrix transform;
  private EncoderWriter writer;
  private Handler writerHandler;
  private HandlerThread writerThread;
  
  public AssetWriterInput(int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(201499);
    this.outputSettings = new HashMap();
    this.started = false;
    this.stop = false;
    this.mediaType = paramInt;
    this.outputSettings.putAll(paramMap);
    AppMethodBeat.o(201499);
  }
  
  private int getNextStep(int paramInt)
  {
    return paramInt + 2;
  }
  
  private int getStatus(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return -24;
      return -18;
      return -19;
      return -20;
      return -21;
      switch (paramInt)
      {
      }
    }
    return -22;
    return -23;
  }
  
  void addStatusListener(StatusListener paramStatusListener)
  {
    this.statusListener = paramStatusListener;
  }
  
  public void addTrackAssociationWithTrackOfInputAndType(AssetWriterInput paramAssetWriterInput, String paramString) {}
  
  public int appendSampleBuffer(final CMSampleBuffer paramCMSampleBuffer)
  {
    int j = 2;
    boolean bool = true;
    AppMethodBeat.i(201501);
    if (!this.stop) {}
    try
    {
      if (this.mediaType == 1)
      {
        localObject = this.assetWriter.renderContext();
        if (localObject == null) {}
      }
    }
    catch (Throwable paramCMSampleBuffer)
    {
      label544:
      for (;;)
      {
        Object localObject;
        int k;
        label436:
        label466:
        i = 0;
      }
    }
    try
    {
      this.assetWriter.renderContext().makeCurrent();
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      j = getNextStep(1);
      k = j;
      if (paramCMSampleBuffer != null)
      {
        k = j;
        i = j;
      }
      try
      {
        if (paramCMSampleBuffer.getTime().getTimeUs() >= 0L)
        {
          i = j;
          Logger.e("AssetWriterInput", "appendSampleBuffer: start " + paramCMSampleBuffer.getTime());
          i = j;
          localObject = paramCMSampleBuffer.getTextureInfo();
          k = j;
          if (localObject != null)
          {
            i = j;
            if (this.matrixFilter == null)
            {
              i = j;
              this.matrixFilter = new Filter();
              i = j;
              this.matrixFilter.setRendererWidth(this.assetWriter.renderContext().width());
              i = j;
              this.matrixFilter.setRendererHeight(this.assetWriter.renderContext().height());
            }
            i = j;
            this.matrixFilter.applyFilter((TextureInfo)localObject, this.transform, ((TextureInfo)localObject).getTextureMatrix());
            i = j;
            k = getNextStep(j);
          }
          i = k;
          this.assetWriter.renderContext().setPresentationTime(paramCMSampleBuffer.getTime().getTimeUs());
          i = k;
          k = getNextStep(k);
          i = k;
          this.assetWriter.renderContext().swapBuffers();
          i = k;
          Logger.e("AssetWriterInput", "appendSampleBuffer: end " + paramCMSampleBuffer.getTime());
        }
        i = k;
        this.writerHandler.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(201494);
            if (AssetWriterInput.this.handler != null) {}
            try
            {
              AssetWriterInput.this.writer.writeVideoSample();
              if ((paramCMSampleBuffer != null) && (paramCMSampleBuffer.getTime().equalsTo(IDecoder.SAMPLE_TIME_FINISH))) {
                AssetWriterInput.this.writer.endWriteVideoSample();
              }
              if (AssetWriterInput.this.progressListener != null) {
                AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, AssetWriterInput.this.writer.getVideoPresentationTimeUs());
              }
              AppMethodBeat.o(201494);
              return;
            }
            catch (Throwable localThrowable)
            {
              while (AssetWriterInput.this.progressListener == null) {}
              AssetWriterInput.this.progressListener.onError(localThrowable);
              AppMethodBeat.o(201494);
            }
          }
        });
        AppMethodBeat.o(201501);
        return -16;
      }
      catch (Throwable paramCMSampleBuffer) {}
      i = this.mediaType;
      if (i != 2) {
        break label544;
      }
      i = j;
      if (!paramCMSampleBuffer.getTime().smallThan(CMTime.CMTimeZero))
      {
        i = j;
        localObject = paramCMSampleBuffer.getTime();
        i = j;
        final ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramCMSampleBuffer.getSampleByteBuffer().limit());
        i = j;
        j = getNextStep(2);
        i = j;
        localByteBuffer.order(paramCMSampleBuffer.getSampleByteBuffer().order());
        i = j;
        localByteBuffer.put(paramCMSampleBuffer.getSampleByteBuffer());
        i = j;
        localByteBuffer.flip();
        i = j;
        this.writerHandler.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(201495);
            if (AssetWriterInput.this.handler != null) {}
            try
            {
              AssetWriterInput.this.writer.writeAudioSample(this.val$time.getTimeUs(), localByteBuffer);
              if (AssetWriterInput.this.progressListener != null) {
                AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, AssetWriterInput.this.writer.getAudioPresentationTimeUs());
              }
              AppMethodBeat.o(201495);
              return;
            }
            catch (Throwable localThrowable)
            {
              while (AssetWriterInput.this.progressListener == null) {}
              AssetWriterInput.this.progressListener.onError(localThrowable);
              AppMethodBeat.o(201495);
            }
          }
        });
        AppMethodBeat.o(201501);
        return -17;
      }
      i = j;
      this.writerHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(201496);
          if (AssetWriterInput.this.handler != null) {}
          try
          {
            AssetWriterInput.this.writer.endWriteAudioSample();
            if (AssetWriterInput.this.progressListener != null) {
              AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, -1L);
            }
            AppMethodBeat.o(201496);
            return;
          }
          catch (Throwable localThrowable)
          {
            while (AssetWriterInput.this.progressListener == null) {}
            AssetWriterInput.this.progressListener.onError(localThrowable);
            AppMethodBeat.o(201496);
          }
        }
      });
      break label436;
    }
    catch (Throwable paramCMSampleBuffer)
    {
      i = 1;
      break label466;
    }
    if (this.mediaType == 1) {}
    for (;;)
    {
      i = getStatus(bool, i);
      Logger.e("AssetWriterInput", "error:" + i + " write failed ", paramCMSampleBuffer);
      if (this.statusListener != null) {
        this.statusListener.statusChanged(this, AssetWriter.AssetWriterStatus.AssetWriterStatusFailed);
      }
      AppMethodBeat.o(201501);
      return i;
      bool = false;
    }
    AppMethodBeat.o(201501);
    return -11;
  }
  
  public boolean canAddTrackAssociationWithTrackOfInputAndType(AssetWriterInput paramAssetWriterInput, String paramString)
  {
    return false;
  }
  
  public void close()
  {
    try
    {
      AppMethodBeat.i(201505);
      Logger.i("AssetWriterInput", "close", new Object[0]);
      if (this.handlerThread != null)
      {
        this.readyForMoreMediaData = false;
        this.handlerThread.quit();
        this.handlerThread = null;
        this.handlerCallback = null;
        this.handler = null;
      }
      if (this.writerThread != null)
      {
        this.writerHandler.removeCallbacks(null);
        this.writerThread.quit();
        this.writerThread = null;
        this.writerHandler = null;
      }
      AppMethodBeat.o(201505);
      return;
    }
    finally {}
  }
  
  public String getExtendedLanguageTag()
  {
    return this.extendedLanguageTag;
  }
  
  public String getLanguageCode()
  {
    return this.languageCode;
  }
  
  public int getMediaTimeScale()
  {
    return this.mediaTimeScale;
  }
  
  public int getMediaType()
  {
    return this.mediaType;
  }
  
  public List<MetadataItem> getMetadata()
  {
    return this.metadata;
  }
  
  public CGSize getNaturalSize()
  {
    return this.naturalSize;
  }
  
  public Map<String, Object> getOutputSettings()
  {
    return this.outputSettings;
  }
  
  public int getPreferredMediaChunkAlignment()
  {
    return this.preferredMediaChunkAlignment;
  }
  
  public CMTime getPreferredMediaChunkDuration()
  {
    return this.preferredMediaChunkDuration;
  }
  
  public float getPreferredVolume()
  {
    return this.preferredVolume;
  }
  
  public Matrix getTransform()
  {
    return this.transform;
  }
  
  void initConfig(AssetWriter paramAssetWriter)
  {
    AppMethodBeat.i(201503);
    this.assetWriter = paramAssetWriter;
    this.writer = paramAssetWriter.encoderWriter();
    if (this.mediaType == 1)
    {
      localOutputConfig = new EncoderWriter.OutputConfig();
      if ((!this.outputSettings.containsKey("width")) || (!this.outputSettings.containsKey("height")))
      {
        paramAssetWriter = new IllegalArgumentException("width and height must > 0");
        AppMethodBeat.o(201503);
        throw paramAssetWriter;
      }
      localOutputConfig.VIDEO_TARGET_WIDTH = ((Integer)this.outputSettings.get("width")).intValue();
      localOutputConfig.VIDEO_TARGET_HEIGHT = ((Integer)this.outputSettings.get("height")).intValue();
      if (this.outputSettings.containsKey("frame-rate"))
      {
        paramAssetWriter = this.outputSettings.get("frame-rate");
        localOutputConfig.VIDEO_FRAME_RATE = ((Integer)paramAssetWriter).intValue();
        if (!this.outputSettings.containsKey("bitrate")) {
          break label291;
        }
        paramAssetWriter = this.outputSettings.get("bitrate");
        label195:
        localOutputConfig.VIDEO_BIT_RATE = ((Integer)paramAssetWriter).intValue();
        if (!this.outputSettings.containsKey("i-frame-interval")) {
          break label301;
        }
      }
      label291:
      label301:
      for (paramAssetWriter = this.outputSettings.get("i-frame-interval");; paramAssetWriter = Integer.valueOf(1))
      {
        localOutputConfig.VIDEO_IFRAME_INTERVAL = ((Integer)paramAssetWriter).intValue();
        localOutputConfig.VIDEO_QUALITY = ((Boolean)this.outputSettings.get("QUALITY")).booleanValue();
        this.writer.outputVideoEncoderConfig(localOutputConfig);
        AppMethodBeat.o(201503);
        return;
        paramAssetWriter = Integer.valueOf(30);
        break;
        paramAssetWriter = Integer.valueOf(8000000);
        break label195;
      }
    }
    EncoderWriter.OutputConfig localOutputConfig = new EncoderWriter.OutputConfig();
    if (this.outputSettings.containsKey("aac-profile"))
    {
      paramAssetWriter = this.outputSettings.get("aac-profile");
      localOutputConfig.AUDIO_AAC_PROFILE = ((Integer)paramAssetWriter).intValue();
      if (!this.outputSettings.containsKey("bitrate")) {
        break label532;
      }
      paramAssetWriter = this.outputSettings.get("bitrate");
      label384:
      localOutputConfig.AUDIO_BIT_RATE = ((Integer)paramAssetWriter).intValue();
      if (!this.outputSettings.containsKey("channel-count")) {
        break label542;
      }
      paramAssetWriter = this.outputSettings.get("channel-count");
      label423:
      localOutputConfig.AUDIO_CHANNEL_COUNT = ((Integer)paramAssetWriter).intValue();
      if (!this.outputSettings.containsKey("mime")) {
        break label550;
      }
      paramAssetWriter = (String)this.outputSettings.get("mime");
      label465:
      localOutputConfig.AUDIO_MIME_TYPE = paramAssetWriter;
      if (!this.outputSettings.containsKey("sample-rate")) {
        break label557;
      }
    }
    label532:
    label542:
    label550:
    label557:
    for (paramAssetWriter = this.outputSettings.get("sample-rate");; paramAssetWriter = Integer.valueOf(44100))
    {
      localOutputConfig.AUDIO_SAMPLE_RATE_HZ = ((Integer)paramAssetWriter).intValue();
      this.writer.outputAudioEncoderConfig(localOutputConfig);
      AppMethodBeat.o(201503);
      return;
      paramAssetWriter = Integer.valueOf(2);
      break;
      paramAssetWriter = Integer.valueOf(128000);
      break label384;
      paramAssetWriter = Integer.valueOf(1);
      break label423;
      paramAssetWriter = "audio/mp4a-latm";
      break label465;
    }
  }
  
  public boolean isCanPerformMultiplePasses()
  {
    return this.canPerformMultiplePasses;
  }
  
  public boolean isExpectsMediaDataInRealTime()
  {
    return this.expectsMediaDataInRealTime;
  }
  
  public boolean isMarksOutputTrackAsEnabled()
  {
    return this.marksOutputTrackAsEnabled;
  }
  
  public boolean isPerformsMultiPassEncodingIfSupported()
  {
    return this.performsMultiPassEncodingIfSupported;
  }
  
  public boolean isReadyForMoreMediaData()
  {
    AppMethodBeat.i(201498);
    if (this.readyForMoreMediaData) {
      if (this.mediaType == 1)
      {
        if (!this.writer.videoTrackWritable()) {}
      }
      else {
        while (this.writer.audioTrackWritable())
        {
          AppMethodBeat.o(201498);
          return true;
        }
      }
    }
    AppMethodBeat.o(201498);
    return false;
  }
  
  public void markAsFinished()
  {
    AppMethodBeat.i(201502);
    this.writerHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(201497);
        if (AssetWriterInput.this.mediaType == 1) {
          try
          {
            AssetWriterInput.this.writer.endWriteVideoSample();
            if (AssetWriterInput.this.progressListener != null)
            {
              AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, -1L);
              AppMethodBeat.o(201497);
              return;
            }
          }
          catch (Throwable localThrowable1)
          {
            while (AssetWriterInput.this.progressListener == null) {}
            AssetWriterInput.this.progressListener.onError(localThrowable1);
            AppMethodBeat.o(201497);
            return;
          }
        }
        try
        {
          AssetWriterInput.this.writer.endWriteAudioSample();
          if (AssetWriterInput.this.progressListener != null) {
            AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, -1L);
          }
          AppMethodBeat.o(201497);
          return;
        }
        catch (Throwable localThrowable2)
        {
          while (AssetWriterInput.this.progressListener == null) {}
          AssetWriterInput.this.progressListener.onError(localThrowable2);
          AppMethodBeat.o(201497);
        }
      }
    });
    AppMethodBeat.o(201502);
  }
  
  public void requestMediaDataWhenReadyOnQueue(HandlerThread paramHandlerThread, final Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(201500);
        if (this.handler != null)
        {
          Logger.e("AssetWriterInput", "正在处理上一次的request请求，无法重复发起");
          AppMethodBeat.o(201500);
          return;
        }
        if (this.assetWriter == null)
        {
          Logger.e("AssetWriterInput", "还没有与AssetWriter关联，无法发起request请求");
          AppMethodBeat.o(201500);
          continue;
        }
        this.handlerThread = paramHandlerThread;
      }
      finally {}
      paramHandlerThread.start();
      this.handler = new Handler(paramHandlerThread.getLooper());
      this.handler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(201493);
          AssetWriterInput.this.start();
          paramRunnable.run();
          AppMethodBeat.o(201493);
        }
      });
      this.writerThread = new HandlerThread("writerThread");
      this.writerThread.start();
      this.writerHandler = new Handler(this.writerThread.getLooper());
      AppMethodBeat.o(201500);
    }
  }
  
  void setAssetWriter(AssetWriter paramAssetWriter)
  {
    this.assetWriter = paramAssetWriter;
  }
  
  public void setCanPerformMultiplePasses(boolean paramBoolean)
  {
    this.canPerformMultiplePasses = paramBoolean;
  }
  
  public void setExpectsMediaDataInRealTime(boolean paramBoolean)
  {
    this.expectsMediaDataInRealTime = paramBoolean;
  }
  
  public void setExtendedLanguageTag(String paramString)
  {
    this.extendedLanguageTag = paramString;
  }
  
  public void setLanguageCode(String paramString)
  {
    this.languageCode = paramString;
  }
  
  public void setMarksOutputTrackAsEnabled(boolean paramBoolean)
  {
    this.marksOutputTrackAsEnabled = paramBoolean;
  }
  
  public void setMediaTimeScale(int paramInt)
  {
    this.mediaTimeScale = paramInt;
  }
  
  public void setMetadata(List<MetadataItem> paramList)
  {
    this.metadata = paramList;
  }
  
  public void setNaturalSize(CGSize paramCGSize)
  {
    this.naturalSize = paramCGSize;
  }
  
  public void setPerformsMultiPassEncodingIfSupported(boolean paramBoolean)
  {
    this.performsMultiPassEncodingIfSupported = paramBoolean;
  }
  
  public void setPreferredMediaChunkAlignment(int paramInt)
  {
    this.preferredMediaChunkAlignment = paramInt;
  }
  
  public void setPreferredMediaChunkDuration(CMTime paramCMTime)
  {
    this.preferredMediaChunkDuration = paramCMTime;
  }
  
  public void setPreferredVolume(float paramFloat)
  {
    this.preferredVolume = paramFloat;
  }
  
  public void setTransform(Matrix paramMatrix)
  {
    this.transform = paramMatrix;
  }
  
  void setWriterProgressListener(WriterProgressListener paramWriterProgressListener)
  {
    this.progressListener = paramWriterProgressListener;
  }
  
  boolean start()
  {
    AppMethodBeat.i(201504);
    Logger.i("AssetWriterInput", "start", new Object[0]);
    if (this.started)
    {
      AppMethodBeat.o(201504);
      return true;
    }
    for (;;)
    {
      try
      {
        if (this.mediaType != 1) {
          continue;
        }
        this.writer.startVideoEncoder();
        this.readyForMoreMediaData = true;
        this.started = true;
      }
      catch (Exception localException)
      {
        boolean bool;
        Logger.e("AssetWriterInput", "start", localException);
        continue;
      }
      bool = this.started;
      AppMethodBeat.o(201504);
      return bool;
      this.writer.startAudioEncoder();
    }
  }
  
  void stop()
  {
    this.stop = true;
    this.readyForMoreMediaData = false;
  }
  
  static abstract interface StatusListener
  {
    public abstract void statusChanged(AssetWriterInput paramAssetWriterInput, AssetWriter.AssetWriterStatus paramAssetWriterStatus);
  }
  
  static abstract interface WriterProgressListener
  {
    public abstract void onError(Throwable paramThrowable);
    
    public abstract void onProgressChanged(AssetWriterInput paramAssetWriterInput, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput
 * JD-Core Version:    0.7.0.1
 */