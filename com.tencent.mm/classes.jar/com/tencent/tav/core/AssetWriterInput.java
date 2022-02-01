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
    AppMethodBeat.i(217810);
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
    AppMethodBeat.o(217810);
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
    //   29: ifnull +194 -> 223
    //   32: aload_1
    //   33: invokevirtual 91	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   36: invokevirtual 177	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   39: lconst_0
    //   40: lcmp
    //   41: iflt +182 -> 223
    //   44: ldc 24
    //   46: new 179	java/lang/StringBuilder
    //   49: dup
    //   50: ldc 181
    //   52: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   55: aload_1
    //   56: invokevirtual 91	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   59: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 197	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: aload_1
    //   70: invokespecial 201	com/tencent/tav/core/AssetWriterInput:renderSampleBuffer	(Lcom/tencent/tav/coremedia/CMSampleBuffer;)Lcom/tencent/tav/coremedia/TextureInfo;
    //   73: astore_2
    //   74: aload_0
    //   75: getfield 69	com/tencent/tav/core/AssetWriterInput:writer	Lcom/tencent/tav/decoder/EncoderWriter;
    //   78: invokevirtual 207	com/tencent/tav/decoder/EncoderWriter:isVideoEncodeNeedVideoRenderOutputTexture	()Z
    //   81: ifeq +6 -> 87
    //   84: invokestatic 210	android/opengl/GLES20:glFinish	()V
    //   87: aload_0
    //   88: getfield 69	com/tencent/tav/core/AssetWriterInput:writer	Lcom/tencent/tav/decoder/EncoderWriter;
    //   91: aload_2
    //   92: invokevirtual 214	com/tencent/tav/decoder/EncoderWriter:inputVideoSampleTexture	(Lcom/tencent/tav/coremedia/TextureInfo;)V
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_0
    //   98: getfield 153	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/AssetWriter;
    //   101: invokevirtual 159	com/tencent/tav/core/AssetWriter:renderContext	()Lcom/tencent/tav/decoder/RenderContext;
    //   104: aload_1
    //   105: invokevirtual 91	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   108: invokevirtual 177	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   111: invokevirtual 218	com/tencent/tav/decoder/RenderContext:setPresentationTime	(J)V
    //   114: aload_0
    //   115: getfield 153	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/AssetWriter;
    //   118: invokevirtual 159	com/tencent/tav/core/AssetWriter:renderContext	()Lcom/tencent/tav/decoder/RenderContext;
    //   121: invokevirtual 221	com/tencent/tav/decoder/RenderContext:swapBuffers	()Z
    //   124: pop
    //   125: ldc 24
    //   127: new 179	java/lang/StringBuilder
    //   130: dup
    //   131: ldc 223
    //   133: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: aload_1
    //   137: invokevirtual 91	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   140: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 226	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_0
    //   150: getfield 135	com/tencent/tav/core/AssetWriterInput:writerHandler	Landroid/os/Handler;
    //   153: new 19	com/tencent/tav/core/AssetWriterInput$WriterVideoRunnable
    //   156: dup
    //   157: aload_0
    //   158: aload_1
    //   159: aconst_null
    //   160: invokespecial 229	com/tencent/tav/core/AssetWriterInput$WriterVideoRunnable:<init>	(Lcom/tencent/tav/core/AssetWriterInput;Lcom/tencent/tav/coremedia/CMSampleBuffer;Lcom/tencent/tav/core/AssetWriterInput$1;)V
    //   163: invokevirtual 144	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   166: pop
    //   167: ldc 151
    //   169: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_2
    //   173: areturn
    //   174: astore_1
    //   175: new 231	com/tencent/tav/core/ExportErrorStatus
    //   178: dup
    //   179: bipush 145
    //   181: aload_1
    //   182: invokespecial 234	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   185: astore_1
    //   186: ldc 151
    //   188: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_1
    //   192: areturn
    //   193: astore_2
    //   194: new 231	com/tencent/tav/core/ExportErrorStatus
    //   197: dup
    //   198: bipush 144
    //   200: aload_2
    //   201: invokespecial 234	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   204: astore_2
    //   205: goto -108 -> 97
    //   208: astore_2
    //   209: new 231	com/tencent/tav/core/ExportErrorStatus
    //   212: dup
    //   213: bipush 143
    //   215: aload_2
    //   216: invokespecial 234	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   219: astore_2
    //   220: goto -95 -> 125
    //   223: aconst_null
    //   224: astore_2
    //   225: goto -76 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	AssetWriterInput
    //   0	228	1	paramCMSampleBuffer	CMSampleBuffer
    //   73	100	2	localTextureInfo	TextureInfo
    //   193	8	2	localException1	Exception
    //   204	1	2	localExportErrorStatus1	ExportErrorStatus
    //   208	8	2	localException2	Exception
    //   219	6	2	localExportErrorStatus2	ExportErrorStatus
    // Exception table:
    //   from	to	target	type
    //   5	15	174	java/lang/Exception
    //   68	87	193	java/lang/Exception
    //   87	95	193	java/lang/Exception
    //   97	125	208	java/lang/Exception
  }
  
  private void onStartError(Exception paramException, int paramInt)
  {
    AppMethodBeat.i(217816);
    if ((paramException instanceof ExportRuntimeException))
    {
      paramException = ((ExportRuntimeException)paramException).getErrorStatus();
      if (this.progressListener != null) {
        this.progressListener.onError(paramException);
      }
      AppMethodBeat.o(217816);
      return;
    }
    if (paramInt == 1) {}
    for (paramInt = -101;; paramInt = -102)
    {
      paramException = new ExportErrorStatus(paramInt, paramException);
      break;
    }
  }
  
  private TextureInfo renderSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(217812);
    paramCMSampleBuffer = paramCMSampleBuffer.getTextureInfo();
    if (paramCMSampleBuffer != null)
    {
      Filter localFilter;
      if (this.matrixFilter == null)
      {
        this.matrixFilter = new Filter();
        this.matrixFilter.setRendererWidth(this.assetWriter.renderContext().width());
        this.matrixFilter.setRendererHeight(this.assetWriter.renderContext().height());
        localFilter = this.matrixFilter;
        if (this.writer.isVideoEncodeNeedVideoRenderOutputTexture()) {
          break label112;
        }
      }
      label112:
      for (boolean bool = true;; bool = false)
      {
        localFilter.setRenderForScreen(bool);
        paramCMSampleBuffer = this.matrixFilter.applyFilter(paramCMSampleBuffer, this.transform, paramCMSampleBuffer.getTextureMatrix());
        AppMethodBeat.o(217812);
        return paramCMSampleBuffer;
      }
    }
    AppMethodBeat.o(217812);
    return null;
  }
  
  void addStatusListener(StatusListener paramStatusListener)
  {
    this.statusListener = paramStatusListener;
  }
  
  public ExportErrorStatus appendSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(217809);
    if (!this.stop) {
      try
      {
        Logger.e("AssetWriterInput", "appendSampleBuffer: start " + paramCMSampleBuffer.getTime() + " type: " + this.mediaType);
        if ((this.mediaType == 1) && (this.assetWriter.renderContext() != null))
        {
          paramCMSampleBuffer = appendVideoSampleBuffer(paramCMSampleBuffer);
          AppMethodBeat.o(217809);
          return paramCMSampleBuffer;
        }
        if (this.mediaType == 2)
        {
          paramCMSampleBuffer = appendAudioSampleBuffer(paramCMSampleBuffer);
          AppMethodBeat.o(217809);
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
        AppMethodBeat.o(217809);
        return paramCMSampleBuffer;
      }
    }
    paramCMSampleBuffer = new ExportErrorStatus(-11);
    AppMethodBeat.o(217809);
    return paramCMSampleBuffer;
  }
  
  public void close()
  {
    try
    {
      AppMethodBeat.i(217817);
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
      AppMethodBeat.o(217817);
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
    AppMethodBeat.i(217814);
    this.assetWriter = paramAssetWriter;
    this.writer = paramAssetWriter.encoderWriter();
    AppMethodBeat.o(217814);
  }
  
  public boolean isReadyForMoreMediaData()
  {
    AppMethodBeat.i(217807);
    if (this.readyForMoreMediaData) {
      if (this.mediaType == 1)
      {
        if (!this.writer.videoTrackWritable()) {}
      }
      else {
        while (this.writer.audioTrackWritable())
        {
          AppMethodBeat.o(217807);
          return true;
        }
      }
    }
    AppMethodBeat.o(217807);
    return false;
  }
  
  public void markAsFinished()
  {
    AppMethodBeat.i(217813);
    this.writerHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(217804);
        if (AssetWriterInput.this.mediaType == 1) {
          try
          {
            AssetWriterInput.this.writer.endWriteVideoSample(null);
            if (AssetWriterInput.this.progressListener != null)
            {
              AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, -1L);
              AppMethodBeat.o(217804);
              return;
            }
          }
          catch (Throwable localThrowable1)
          {
            while (AssetWriterInput.this.progressListener == null) {}
            AssetWriterInput.this.progressListener.onError(new ExportErrorStatus(-123, localThrowable1));
            AppMethodBeat.o(217804);
            return;
          }
        }
        try
        {
          AssetWriterInput.this.writer.endWriteAudioSample();
          if (AssetWriterInput.this.progressListener != null) {
            AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, -1L);
          }
          AppMethodBeat.o(217804);
          return;
        }
        catch (Throwable localThrowable2)
        {
          while (AssetWriterInput.this.progressListener == null) {}
          AssetWriterInput.this.progressListener.onError(new ExportErrorStatus(-124, localThrowable2));
          AppMethodBeat.o(217804);
        }
      }
    });
    AppMethodBeat.o(217813);
  }
  
  public void requestMediaDataWhenReadyOnQueue(HandlerThread paramHandlerThread, final Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(217808);
        if (this.handler != null)
        {
          Logger.e("AssetWriterInput", "正在处理上一次的request请求，无法重复发起");
          AppMethodBeat.o(217808);
          return;
        }
        if (this.assetWriter == null)
        {
          Logger.e("AssetWriterInput", "还没有与AssetWriter关联，无法发起request请求");
          AppMethodBeat.o(217808);
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
          AppMethodBeat.i(217803);
          if (AssetWriterInput.this.start()) {
            paramRunnable.run();
          }
          AppMethodBeat.o(217803);
        }
      });
      this.writerThread = new HandlerThread("writerThread");
      this.writerThread.start();
      this.writerHandler = new Handler(this.writerThread.getLooper());
      AppMethodBeat.o(217808);
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
    AppMethodBeat.i(217815);
    Logger.i("AssetWriterInput", "start");
    if (this.started)
    {
      AppMethodBeat.o(217815);
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
        this.writer.setVideoSampleRenderContext(this.assetWriter.renderContext());
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
      AppMethodBeat.o(217815);
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
      AppMethodBeat.i(217805);
      if (AssetWriterInput.this.handler == null)
      {
        AppMethodBeat.o(217805);
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
          AppMethodBeat.o(217805);
          return;
          localExportErrorStatus = new ExportErrorStatus(-122, localExportErrorStatus);
          continue;
          long l = -1L;
          continue;
        }
        if (AssetWriterInput.this.progressListener != null) {
          AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, l);
        }
        AppMethodBeat.o(217805);
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
      AppMethodBeat.i(217806);
      if (AssetWriterInput.this.handler != null) {}
      for (;;)
      {
        try
        {
          AssetWriterInput.this.writer.writeVideoSample(this.sampleBuffer);
          if (this.sampleBuffer != null) {
            if (this.sampleBuffer.getState().stateMatchingTo(new long[] { -1L })) {
              AssetWriterInput.this.writer.endWriteVideoSample(this.sampleBuffer);
            }
          }
          if (AssetWriterInput.this.progressListener != null) {
            AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, AssetWriterInput.this.writer.getVideoPresentationTimeUs());
          }
          AppMethodBeat.o(217806);
          return;
        }
        catch (Throwable localThrowable)
        {
          if (!(localThrowable instanceof ExportRuntimeException)) {}
        }
        for (ExportErrorStatus localExportErrorStatus = ((ExportRuntimeException)localThrowable).getErrorStatus(); AssetWriterInput.this.progressListener != null; localExportErrorStatus = new ExportErrorStatus(-121, localExportErrorStatus))
        {
          AssetWriterInput.this.progressListener.onError(localExportErrorStatus);
          AppMethodBeat.o(217806);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput
 * JD-Core Version:    0.7.0.1
 */