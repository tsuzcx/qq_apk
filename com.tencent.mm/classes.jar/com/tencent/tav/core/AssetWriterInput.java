package com.tencent.tav.core;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.util.List;

public class AssetWriterInput
{
  private static final String TAG = "AssetWriterInput";
  private AssetWriter assetWriter;
  private Handler handler;
  private HandlerThread handlerThread;
  Filter matrixFilter;
  private int mediaType;
  private List<MetadataItem> metadata;
  private WriterProgressListener progressListener;
  private boolean readyForMoreMediaData;
  private boolean started = false;
  private StatusListener statusListener;
  private boolean stop = false;
  private Matrix transform;
  private EncoderWriter writer;
  private Handler writerHandler;
  private HandlerThread writerThread;
  
  public AssetWriterInput(int paramInt)
  {
    this.mediaType = paramInt;
  }
  
  private ExportErrorStatus appendAudioSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(214478);
    boolean bool = paramCMSampleBuffer.getTime().smallThan(CMTime.CMTimeZero);
    Object localObject = paramCMSampleBuffer;
    if (!bool)
    {
      localObject = ByteBuffer.allocate(paramCMSampleBuffer.getSampleByteBuffer().limit());
      ((ByteBuffer)localObject).order(paramCMSampleBuffer.getSampleByteBuffer().order());
      ((ByteBuffer)localObject).put(paramCMSampleBuffer.getSampleByteBuffer());
      ((ByteBuffer)localObject).flip();
      localObject = new CMSampleBuffer(paramCMSampleBuffer.getTime(), (ByteBuffer)localObject);
    }
    this.writerHandler.post(new WriterAudioRunnable((CMSampleBuffer)localObject, bool, null));
    AppMethodBeat.o(214478);
    return null;
  }
  
  /* Error */
  private ExportErrorStatus appendVideoSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    // Byte code:
    //   0: ldc 151
    //   2: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 153	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/AssetWriter;
    //   9: invokevirtual 159	com/tencent/tav/core/AssetWriter:renderContext	()Lcom/tencent/tav/decoder/RenderContext;
    //   12: invokevirtual 164	com/tencent/tav/decoder/RenderContext:makeCurrent	()V
    //   15: fconst_0
    //   16: fconst_0
    //   17: fconst_0
    //   18: fconst_1
    //   19: invokestatic 170	android/opengl/GLES20:glClearColor	(FFFF)V
    //   22: sipush 16640
    //   25: invokestatic 173	android/opengl/GLES20:glClear	(I)V
    //   28: aload_1
    //   29: ifnull +172 -> 201
    //   32: aload_1
    //   33: invokevirtual 91	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   36: invokevirtual 177	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   39: lconst_0
    //   40: lcmp
    //   41: iflt +160 -> 201
    //   44: ldc 24
    //   46: new 179	java/lang/StringBuilder
    //   49: dup
    //   50: ldc 181
    //   52: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   55: aload_1
    //   56: invokevirtual 91	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   59: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 198	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: aload_1
    //   70: invokespecial 202	com/tencent/tav/core/AssetWriterInput:renderSampleBuffer	(Lcom/tencent/tav/coremedia/CMSampleBuffer;)V
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_0
    //   76: getfield 153	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/AssetWriter;
    //   79: invokevirtual 159	com/tencent/tav/core/AssetWriter:renderContext	()Lcom/tencent/tav/decoder/RenderContext;
    //   82: aload_1
    //   83: invokevirtual 91	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   86: invokevirtual 177	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   89: invokevirtual 206	com/tencent/tav/decoder/RenderContext:setPresentationTime	(J)V
    //   92: aload_0
    //   93: getfield 153	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/AssetWriter;
    //   96: invokevirtual 159	com/tencent/tav/core/AssetWriter:renderContext	()Lcom/tencent/tav/decoder/RenderContext;
    //   99: invokevirtual 210	com/tencent/tav/decoder/RenderContext:swapBuffers	()Z
    //   102: pop
    //   103: ldc 24
    //   105: new 179	java/lang/StringBuilder
    //   108: dup
    //   109: ldc 212
    //   111: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload_1
    //   115: invokevirtual 91	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   118: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 198	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_0
    //   128: getfield 135	com/tencent/tav/core/AssetWriterInput:writerHandler	Landroid/os/Handler;
    //   131: new 19	com/tencent/tav/core/AssetWriterInput$WriterVideoRunnable
    //   134: dup
    //   135: aload_0
    //   136: aload_1
    //   137: aconst_null
    //   138: invokespecial 215	com/tencent/tav/core/AssetWriterInput$WriterVideoRunnable:<init>	(Lcom/tencent/tav/core/AssetWriterInput;Lcom/tencent/tav/coremedia/CMSampleBuffer;Lcom/tencent/tav/core/AssetWriterInput$1;)V
    //   141: invokevirtual 144	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   144: pop
    //   145: ldc 151
    //   147: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_2
    //   151: areturn
    //   152: astore_1
    //   153: new 217	com/tencent/tav/core/ExportErrorStatus
    //   156: dup
    //   157: bipush 145
    //   159: aload_1
    //   160: invokespecial 220	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   163: astore_1
    //   164: ldc 151
    //   166: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_1
    //   170: areturn
    //   171: astore_2
    //   172: new 217	com/tencent/tav/core/ExportErrorStatus
    //   175: dup
    //   176: bipush 144
    //   178: aload_2
    //   179: invokespecial 220	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   182: astore_2
    //   183: goto -108 -> 75
    //   186: astore_2
    //   187: new 217	com/tencent/tav/core/ExportErrorStatus
    //   190: dup
    //   191: bipush 143
    //   193: aload_2
    //   194: invokespecial 220	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   197: astore_2
    //   198: goto -95 -> 103
    //   201: aconst_null
    //   202: astore_2
    //   203: goto -76 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	AssetWriterInput
    //   0	206	1	paramCMSampleBuffer	CMSampleBuffer
    //   74	77	2	localExportErrorStatus1	ExportErrorStatus
    //   171	8	2	localException1	Exception
    //   182	1	2	localExportErrorStatus2	ExportErrorStatus
    //   186	8	2	localException2	Exception
    //   197	6	2	localExportErrorStatus3	ExportErrorStatus
    // Exception table:
    //   from	to	target	type
    //   5	15	152	java/lang/Exception
    //   68	73	171	java/lang/Exception
    //   75	103	186	java/lang/Exception
  }
  
  private void onStartError(Exception paramException, int paramInt)
  {
    AppMethodBeat.i(214484);
    if ((paramException instanceof ExportRuntimeException))
    {
      paramException = ((ExportRuntimeException)paramException).getErrorStatus();
      if (this.progressListener != null) {
        this.progressListener.onError(paramException);
      }
      AppMethodBeat.o(214484);
      return;
    }
    if (paramInt == 1) {}
    for (paramInt = -101;; paramInt = -102)
    {
      paramException = new ExportErrorStatus(paramInt, paramException);
      break;
    }
  }
  
  private void renderSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(214480);
    paramCMSampleBuffer = paramCMSampleBuffer.getTextureInfo();
    if (paramCMSampleBuffer != null)
    {
      if (this.matrixFilter == null)
      {
        this.matrixFilter = new Filter();
        this.matrixFilter.setRendererWidth(this.assetWriter.renderContext().width());
        this.matrixFilter.setRendererHeight(this.assetWriter.renderContext().height());
      }
      this.matrixFilter.applyFilter(paramCMSampleBuffer, this.transform, paramCMSampleBuffer.getTextureMatrix());
    }
    AppMethodBeat.o(214480);
  }
  
  void addStatusListener(StatusListener paramStatusListener)
  {
    this.statusListener = paramStatusListener;
  }
  
  public ExportErrorStatus appendSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(214477);
    if (!this.stop) {
      try
      {
        Logger.e("AssetWriterInput", "appendSampleBuffer: start " + paramCMSampleBuffer.getTime() + " type: " + this.mediaType);
        if ((this.mediaType == 1) && (this.assetWriter.renderContext() != null))
        {
          paramCMSampleBuffer = appendVideoSampleBuffer(paramCMSampleBuffer);
          AppMethodBeat.o(214477);
          return paramCMSampleBuffer;
        }
        if (this.mediaType == 2)
        {
          paramCMSampleBuffer = appendAudioSampleBuffer(paramCMSampleBuffer);
          AppMethodBeat.o(214477);
          return paramCMSampleBuffer;
        }
      }
      catch (Throwable paramCMSampleBuffer)
      {
        Logger.e("AssetWriterInput", "appendSampleBuffer: error", paramCMSampleBuffer);
        if (this.statusListener != null) {
          this.statusListener.statusChanged(this, AssetWriter.AssetWriterStatus.AssetWriterStatusFailed);
        }
        paramCMSampleBuffer = new ExportErrorStatus(-110, paramCMSampleBuffer);
        AppMethodBeat.o(214477);
        return paramCMSampleBuffer;
      }
    }
    paramCMSampleBuffer = new ExportErrorStatus(-11);
    AppMethodBeat.o(214477);
    return paramCMSampleBuffer;
  }
  
  public void close()
  {
    try
    {
      AppMethodBeat.i(214485);
      Logger.i("AssetWriterInput", "close");
      if (this.handlerThread != null)
      {
        this.readyForMoreMediaData = false;
        this.handlerThread.quit();
        this.handlerThread = null;
        this.handler = null;
      }
      if (this.writerThread != null)
      {
        this.writerHandler.removeCallbacks(null);
        this.writerThread.quit();
        this.writerThread = null;
        this.writerHandler = null;
      }
      AppMethodBeat.o(214485);
      return;
    }
    finally {}
  }
  
  public int getMediaType()
  {
    return this.mediaType;
  }
  
  public List<MetadataItem> getMetadata()
  {
    return this.metadata;
  }
  
  void initConfig(AssetWriter paramAssetWriter)
  {
    AppMethodBeat.i(214482);
    this.assetWriter = paramAssetWriter;
    this.writer = paramAssetWriter.encoderWriter();
    AppMethodBeat.o(214482);
  }
  
  public boolean isReadyForMoreMediaData()
  {
    AppMethodBeat.i(214475);
    if (this.readyForMoreMediaData) {
      if (this.mediaType == 1)
      {
        if (!this.writer.videoTrackWritable()) {}
      }
      else {
        while (this.writer.audioTrackWritable())
        {
          AppMethodBeat.o(214475);
          return true;
        }
      }
    }
    AppMethodBeat.o(214475);
    return false;
  }
  
  public void markAsFinished()
  {
    AppMethodBeat.i(214481);
    this.writerHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(214472);
        if (AssetWriterInput.this.mediaType == 1) {
          try
          {
            AssetWriterInput.this.writer.endWriteVideoSample();
            if (AssetWriterInput.this.progressListener != null)
            {
              AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, -1L);
              AppMethodBeat.o(214472);
              return;
            }
          }
          catch (Throwable localThrowable1)
          {
            while (AssetWriterInput.this.progressListener == null) {}
            AssetWriterInput.this.progressListener.onError(new ExportErrorStatus(-123, localThrowable1));
            AppMethodBeat.o(214472);
            return;
          }
        }
        try
        {
          AssetWriterInput.this.writer.endWriteAudioSample();
          if (AssetWriterInput.this.progressListener != null) {
            AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, -1L);
          }
          AppMethodBeat.o(214472);
          return;
        }
        catch (Throwable localThrowable2)
        {
          while (AssetWriterInput.this.progressListener == null) {}
          AssetWriterInput.this.progressListener.onError(new ExportErrorStatus(-124, localThrowable2));
          AppMethodBeat.o(214472);
        }
      }
    });
    AppMethodBeat.o(214481);
  }
  
  public void requestMediaDataWhenReadyOnQueue(HandlerThread paramHandlerThread, final Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(214476);
        if (this.handler != null)
        {
          Logger.e("AssetWriterInput", "正在处理上一次的request请求，无法重复发起");
          AppMethodBeat.o(214476);
          return;
        }
        if (this.assetWriter == null)
        {
          Logger.e("AssetWriterInput", "还没有与AssetWriter关联，无法发起request请求");
          AppMethodBeat.o(214476);
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
          AppMethodBeat.i(214471);
          if (AssetWriterInput.this.start()) {
            paramRunnable.run();
          }
          AppMethodBeat.o(214471);
        }
      });
      this.writerThread = new HandlerThread("writerThread");
      this.writerThread.start();
      this.writerHandler = new Handler(this.writerThread.getLooper());
      AppMethodBeat.o(214476);
    }
  }
  
  public void setMetadata(List<MetadataItem> paramList)
  {
    this.metadata = paramList;
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
    AppMethodBeat.i(214483);
    Logger.i("AssetWriterInput", "start");
    if (this.started)
    {
      AppMethodBeat.o(214483);
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
        Logger.e("AssetWriterInput", "start: ", localException);
        onStartError(localException, this.mediaType);
        continue;
      }
      bool = this.started;
      AppMethodBeat.o(214483);
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
  
  class WriterAudioRunnable
    implements Runnable
  {
    private final boolean isEndBuffer;
    private final CMSampleBuffer sampleBuffer;
    
    private WriterAudioRunnable(CMSampleBuffer paramCMSampleBuffer, boolean paramBoolean)
    {
      this.sampleBuffer = paramCMSampleBuffer;
      this.isEndBuffer = paramBoolean;
    }
    
    public void run()
    {
      AppMethodBeat.i(214473);
      if (AssetWriterInput.this.handler == null)
      {
        AppMethodBeat.o(214473);
        return;
      }
      for (;;)
      {
        try
        {
          if (!this.isEndBuffer) {
            continue;
          }
          AssetWriterInput.this.writer.endWriteAudioSample();
          l = -1L;
        }
        catch (Throwable localThrowable)
        {
          if (!(localThrowable instanceof ExportRuntimeException)) {
            continue;
          }
          ExportErrorStatus localExportErrorStatus = ((ExportRuntimeException)localThrowable).getErrorStatus();
          if (AssetWriterInput.this.progressListener == null) {
            continue;
          }
          AssetWriterInput.this.progressListener.onError(localExportErrorStatus);
          AppMethodBeat.o(214473);
          return;
          localExportErrorStatus = new ExportErrorStatus(-122, localExportErrorStatus);
          continue;
          long l = -1L;
          continue;
        }
        if (AssetWriterInput.this.progressListener != null) {
          AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, l);
        }
        AppMethodBeat.o(214473);
        return;
        AssetWriterInput.this.writer.writeAudioSample(this.sampleBuffer.getTime().getTimeUs(), this.sampleBuffer.getSampleByteBuffer());
        l = AssetWriterInput.this.writer.getAudioPresentationTimeUs();
      }
    }
  }
  
  static abstract interface WriterProgressListener
  {
    public abstract void onError(ExportErrorStatus paramExportErrorStatus);
    
    public abstract void onProgressChanged(AssetWriterInput paramAssetWriterInput, long paramLong);
  }
  
  class WriterVideoRunnable
    implements Runnable
  {
    private final CMSampleBuffer sampleBuffer;
    
    private WriterVideoRunnable(CMSampleBuffer paramCMSampleBuffer)
    {
      this.sampleBuffer = paramCMSampleBuffer;
    }
    
    public void run()
    {
      AppMethodBeat.i(214474);
      if (AssetWriterInput.this.handler != null) {}
      for (;;)
      {
        try
        {
          AssetWriterInput.this.writer.writeVideoSample();
          if (this.sampleBuffer != null) {
            if (this.sampleBuffer.getState().stateMatchingTo(new long[] { -1L })) {
              AssetWriterInput.this.writer.endWriteVideoSample();
            }
          }
          if (AssetWriterInput.this.progressListener != null) {
            AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, AssetWriterInput.this.writer.getVideoPresentationTimeUs());
          }
          AppMethodBeat.o(214474);
          return;
        }
        catch (Throwable localThrowable)
        {
          if (!(localThrowable instanceof ExportRuntimeException)) {}
        }
        for (ExportErrorStatus localExportErrorStatus = ((ExportRuntimeException)localThrowable).getErrorStatus(); AssetWriterInput.this.progressListener != null; localExportErrorStatus = new ExportErrorStatus(-121, localExportErrorStatus))
        {
          AssetWriterInput.this.progressListener.onError(localExportErrorStatus);
          AppMethodBeat.o(214474);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput
 * JD-Core Version:    0.7.0.1
 */