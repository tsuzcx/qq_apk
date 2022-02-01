package com.tencent.tav.core;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Trace;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
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
  private final String TAG;
  private IAssetWriter assetWriter;
  private Handler handler;
  private HandlerThread handlerThread;
  public PipelineIndicatorInfo indicatorInfo;
  public Filter matrixFilter;
  private int mediaType;
  private List<MetadataItem> metadata;
  private WriterProgressListener progressListener;
  private boolean readyForMoreMediaData;
  private long renderCost;
  private boolean started;
  private StatusListener statusListener;
  private boolean stop;
  private Matrix transform;
  private EncoderWriter writer;
  private Handler writerHandler;
  private HandlerThread writerThread;
  
  public AssetWriterInput(int paramInt)
  {
    AppMethodBeat.i(215244);
    this.TAG = ("AssetWriterInput" + hashCode());
    this.started = false;
    this.stop = false;
    this.renderCost = 0L;
    this.mediaType = paramInt;
    AppMethodBeat.o(215244);
  }
  
  private ExportErrorStatus appendAudioSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(215250);
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
    AppMethodBeat.o(215250);
    return null;
  }
  
  private ExportErrorStatus appendVideoSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(215256);
    paramCMSampleBuffer = appendVideoSampleBuffer(paramCMSampleBuffer, false);
    AppMethodBeat.o(215256);
    return paramCMSampleBuffer;
  }
  
  /* Error */
  private ExportErrorStatus appendVideoSampleBuffer(CMSampleBuffer paramCMSampleBuffer, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 182
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 184	com/tencent/tav/coremedia/CMPerformance
    //   8: dup
    //   9: getstatic 190	com/tencent/tav/coremedia/CMPerformance$CMPerformanceStage:ENCODE_RENDER_CLEAR	Lcom/tencent/tav/coremedia/CMPerformance$CMPerformanceStage;
    //   12: invokespecial 193	com/tencent/tav/coremedia/CMPerformance:<init>	(Lcom/tencent/tav/coremedia/CMPerformance$CMPerformanceStage;)V
    //   15: astore 5
    //   17: aload 5
    //   19: invokevirtual 196	com/tencent/tav/coremedia/CMPerformance:markStart	()V
    //   22: aload_0
    //   23: getfield 198	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/IAssetWriter;
    //   26: invokeinterface 204 1 0
    //   31: iload_2
    //   32: invokevirtual 210	com/tencent/tav/decoder/RenderContext:makeCurrent	(Z)V
    //   35: fconst_0
    //   36: fconst_0
    //   37: fconst_0
    //   38: fconst_1
    //   39: invokestatic 216	android/opengl/GLES20:glClearColor	(FFFF)V
    //   42: sipush 16640
    //   45: invokestatic 219	android/opengl/GLES20:glClear	(I)V
    //   48: aload 5
    //   50: invokevirtual 222	com/tencent/tav/coremedia/CMPerformance:markEnd	()V
    //   53: aload_1
    //   54: ifnull +305 -> 359
    //   57: aload_1
    //   58: invokevirtual 122	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   61: invokevirtual 226	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   64: lconst_0
    //   65: lcmp
    //   66: iflt +293 -> 359
    //   69: aload_0
    //   70: getfield 87	com/tencent/tav/core/AssetWriterInput:TAG	Ljava/lang/String;
    //   73: new 68	java/lang/StringBuilder
    //   76: dup
    //   77: ldc 228
    //   79: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   82: aload_1
    //   83: invokevirtual 122	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   86: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 236	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: new 184	com/tencent/tav/coremedia/CMPerformance
    //   98: dup
    //   99: getstatic 239	com/tencent/tav/coremedia/CMPerformance$CMPerformanceStage:ENCODE_RENDER	Lcom/tencent/tav/coremedia/CMPerformance$CMPerformanceStage;
    //   102: invokespecial 193	com/tencent/tav/coremedia/CMPerformance:<init>	(Lcom/tencent/tav/coremedia/CMPerformance$CMPerformanceStage;)V
    //   105: astore 6
    //   107: aload 6
    //   109: aload 5
    //   111: invokevirtual 243	com/tencent/tav/coremedia/CMPerformance:addPreNode	(Lcom/tencent/tav/coremedia/CMPerformance;)V
    //   114: aload 6
    //   116: invokevirtual 196	com/tencent/tav/coremedia/CMPerformance:markStart	()V
    //   119: aload_0
    //   120: aload_1
    //   121: invokespecial 247	com/tencent/tav/core/AssetWriterInput:renderSampleBuffer	(Lcom/tencent/tav/coremedia/CMSampleBuffer;)Lcom/tencent/tav/coremedia/TextureInfo;
    //   124: astore 5
    //   126: aload_0
    //   127: getfield 105	com/tencent/tav/core/AssetWriterInput:writer	Lcom/tencent/tav/decoder/EncoderWriter;
    //   130: invokevirtual 253	com/tencent/tav/decoder/EncoderWriter:isVideoEncodeNeedVideoRenderOutputTexture	()Z
    //   133: ifeq +6 -> 139
    //   136: invokestatic 256	android/opengl/GLES20:glFinish	()V
    //   139: invokestatic 261	java/lang/System:currentTimeMillis	()J
    //   142: lstore_3
    //   143: aload_0
    //   144: getfield 105	com/tencent/tav/core/AssetWriterInput:writer	Lcom/tencent/tav/decoder/EncoderWriter;
    //   147: aload 5
    //   149: aload_1
    //   150: invokevirtual 122	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   153: invokevirtual 265	com/tencent/tav/decoder/EncoderWriter:processVideoTexture	(Lcom/tencent/tav/coremedia/TextureInfo;Lcom/tencent/tav/coremedia/CMTime;)V
    //   156: aload_0
    //   157: invokestatic 261	java/lang/System:currentTimeMillis	()J
    //   160: lload_3
    //   161: lsub
    //   162: aload_0
    //   163: getfield 93	com/tencent/tav/core/AssetWriterInput:renderCost	J
    //   166: ladd
    //   167: putfield 93	com/tencent/tav/core/AssetWriterInput:renderCost	J
    //   170: aconst_null
    //   171: astore 5
    //   173: aload 6
    //   175: invokevirtual 222	com/tencent/tav/coremedia/CMPerformance:markEnd	()V
    //   178: new 184	com/tencent/tav/coremedia/CMPerformance
    //   181: dup
    //   182: getstatic 268	com/tencent/tav/coremedia/CMPerformance$CMPerformanceStage:ENCODE_SWAP_BUFFER	Lcom/tencent/tav/coremedia/CMPerformance$CMPerformanceStage;
    //   185: invokespecial 193	com/tencent/tav/coremedia/CMPerformance:<init>	(Lcom/tencent/tav/coremedia/CMPerformance$CMPerformanceStage;)V
    //   188: astore 7
    //   190: aload 7
    //   192: aload 6
    //   194: invokevirtual 243	com/tencent/tav/coremedia/CMPerformance:addPreNode	(Lcom/tencent/tav/coremedia/CMPerformance;)V
    //   197: aload 7
    //   199: invokevirtual 196	com/tencent/tav/coremedia/CMPerformance:markStart	()V
    //   202: aload_0
    //   203: getfield 198	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/IAssetWriter;
    //   206: invokeinterface 204 1 0
    //   211: aload_1
    //   212: invokevirtual 122	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   215: invokevirtual 226	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   218: invokevirtual 272	com/tencent/tav/decoder/RenderContext:setPresentationTime	(J)V
    //   221: aload_0
    //   222: getfield 198	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/IAssetWriter;
    //   225: invokeinterface 204 1 0
    //   230: invokevirtual 275	com/tencent/tav/decoder/RenderContext:swapBuffers	()Z
    //   233: pop
    //   234: invokestatic 280	android/os/Trace:endSection	()V
    //   237: aload 7
    //   239: invokevirtual 222	com/tencent/tav/coremedia/CMPerformance:markEnd	()V
    //   242: aload_1
    //   243: invokevirtual 284	com/tencent/tav/coremedia/CMSampleBuffer:getState	()Lcom/tencent/tav/coremedia/CMSampleState;
    //   246: aload 7
    //   248: putfield 290	com/tencent/tav/coremedia/CMSampleState:performance	Lcom/tencent/tav/coremedia/CMPerformance;
    //   251: aload_0
    //   252: getfield 87	com/tencent/tav/core/AssetWriterInput:TAG	Ljava/lang/String;
    //   255: new 68	java/lang/StringBuilder
    //   258: dup
    //   259: ldc_w 292
    //   262: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   265: aload_1
    //   266: invokevirtual 122	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   269: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 295	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: aload_0
    //   279: getfield 165	com/tencent/tav/core/AssetWriterInput:writerHandler	Landroid/os/Handler;
    //   282: new 21	com/tencent/tav/core/AssetWriterInput$WriterVideoRunnable
    //   285: dup
    //   286: aload_0
    //   287: aload_1
    //   288: aconst_null
    //   289: invokespecial 298	com/tencent/tav/core/AssetWriterInput$WriterVideoRunnable:<init>	(Lcom/tencent/tav/core/AssetWriterInput;Lcom/tencent/tav/coremedia/CMSampleBuffer;Lcom/tencent/tav/core/AssetWriterInput$1;)V
    //   292: invokevirtual 174	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   295: pop
    //   296: ldc 182
    //   298: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aload 5
    //   303: areturn
    //   304: astore_1
    //   305: new 300	com/tencent/tav/core/ExportErrorStatus
    //   308: dup
    //   309: bipush 145
    //   311: aload_1
    //   312: invokespecial 303	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   315: astore_1
    //   316: ldc 182
    //   318: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: aload_1
    //   322: areturn
    //   323: astore 5
    //   325: new 300	com/tencent/tav/core/ExportErrorStatus
    //   328: dup
    //   329: bipush 144
    //   331: aload 5
    //   333: invokespecial 303	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   336: astore 5
    //   338: goto -165 -> 173
    //   341: astore 5
    //   343: new 300	com/tencent/tav/core/ExportErrorStatus
    //   346: dup
    //   347: bipush 143
    //   349: aload 5
    //   351: invokespecial 303	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   354: astore 5
    //   356: goto -119 -> 237
    //   359: aconst_null
    //   360: astore 5
    //   362: goto -84 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	AssetWriterInput
    //   0	365	1	paramCMSampleBuffer	CMSampleBuffer
    //   0	365	2	paramBoolean	boolean
    //   142	19	3	l	long
    //   15	287	5	localObject	Object
    //   323	9	5	localException1	Exception
    //   336	1	5	localExportErrorStatus1	ExportErrorStatus
    //   341	9	5	localException2	Exception
    //   354	7	5	localExportErrorStatus2	ExportErrorStatus
    //   105	88	6	localCMPerformance1	com.tencent.tav.coremedia.CMPerformance
    //   188	59	7	localCMPerformance2	com.tencent.tav.coremedia.CMPerformance
    // Exception table:
    //   from	to	target	type
    //   22	35	304	java/lang/Exception
    //   119	139	323	java/lang/Exception
    //   139	170	323	java/lang/Exception
    //   202	237	341	java/lang/Exception
  }
  
  private void onStartError(Exception paramException, int paramInt)
  {
    AppMethodBeat.i(215290);
    if ((paramException instanceof ExportRuntimeException))
    {
      paramException = ((ExportRuntimeException)paramException).getErrorStatus();
      if (this.progressListener != null)
      {
        paramException.indicatorInfo = this.indicatorInfo;
        this.progressListener.onError(paramException);
      }
      AppMethodBeat.o(215290);
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
    AppMethodBeat.i(215281);
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
          break label118;
        }
      }
      label118:
      for (boolean bool = true;; bool = false)
      {
        localFilter.setRenderForScreen(bool);
        paramCMSampleBuffer = this.matrixFilter.applyFilter(paramCMSampleBuffer, this.transform, paramCMSampleBuffer.getTextureMatrix());
        AppMethodBeat.o(215281);
        return paramCMSampleBuffer;
      }
    }
    AppMethodBeat.o(215281);
    return null;
  }
  
  public void addStatusListener(StatusListener paramStatusListener)
  {
    this.statusListener = paramStatusListener;
  }
  
  public ExportErrorStatus appendSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(215372);
    paramCMSampleBuffer = appendSampleBuffer(paramCMSampleBuffer, false);
    AppMethodBeat.o(215372);
    return paramCMSampleBuffer;
  }
  
  public ExportErrorStatus appendSampleBuffer(CMSampleBuffer paramCMSampleBuffer, boolean paramBoolean)
  {
    AppMethodBeat.i(215385);
    if (!this.stop) {
      try
      {
        Logger.i(this.TAG, "appendSampleBuffer: start " + paramCMSampleBuffer.getTime() + " type: " + this.mediaType);
        if ((this.mediaType == 1) && (this.assetWriter.renderContext() != null))
        {
          paramCMSampleBuffer = appendVideoSampleBuffer(paramCMSampleBuffer, paramBoolean);
          AppMethodBeat.o(215385);
          return paramCMSampleBuffer;
        }
        if (this.mediaType == 2)
        {
          paramCMSampleBuffer = appendAudioSampleBuffer(paramCMSampleBuffer);
          AppMethodBeat.o(215385);
          return paramCMSampleBuffer;
        }
      }
      finally
      {
        Logger.e(this.TAG, "appendSampleBuffer: error", paramCMSampleBuffer);
        if (this.statusListener != null) {
          this.statusListener.statusChanged(this, AssetWriterStatus.AssetWriterStatusFailed);
        }
        paramCMSampleBuffer = new ExportErrorStatus(-110, paramCMSampleBuffer);
        AppMethodBeat.o(215385);
        return paramCMSampleBuffer;
      }
    }
    paramCMSampleBuffer = new ExportErrorStatus(-11);
    AppMethodBeat.o(215385);
    return paramCMSampleBuffer;
  }
  
  public void close()
  {
    try
    {
      AppMethodBeat.i(215427);
      Logger.i(this.TAG, "close");
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
      AppMethodBeat.o(215427);
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
  
  void initConfig(IAssetWriter paramIAssetWriter)
  {
    AppMethodBeat.i(215411);
    this.assetWriter = paramIAssetWriter;
    this.writer = paramIAssetWriter.encoderWriter();
    AppMethodBeat.o(215411);
  }
  
  public boolean isReadyForMoreMediaData()
  {
    AppMethodBeat.i(215345);
    if (this.readyForMoreMediaData) {
      if (this.mediaType == 1)
      {
        if (!this.writer.videoTrackWritable()) {}
      }
      else {
        while (this.writer.audioTrackWritable())
        {
          AppMethodBeat.o(215345);
          return true;
        }
      }
    }
    AppMethodBeat.o(215345);
    return false;
  }
  
  public void markAsFinished()
  {
    AppMethodBeat.i(215394);
    this.writerHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(215295);
        if (AssetWriterInput.this.mediaType == 1) {
          try
          {
            AssetWriterInput.this.writer.endWriteVideoSample(null);
            if (AssetWriterInput.this.progressListener != null)
            {
              AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, -1L);
              AppMethodBeat.o(215295);
              return;
            }
          }
          finally
          {
            while (AssetWriterInput.this.progressListener == null) {}
            AssetWriterInput.this.progressListener.onError(new ExportErrorStatus(-123, localThrowable1, "", AssetWriterInput.this.indicatorInfo));
            AppMethodBeat.o(215295);
            return;
          }
        }
        try
        {
          AssetWriterInput.this.writer.endWriteAudioSample();
          if (AssetWriterInput.this.progressListener != null) {
            AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, -1L);
          }
          AppMethodBeat.o(215295);
          return;
        }
        finally
        {
          while (AssetWriterInput.this.progressListener == null) {}
          AssetWriterInput.this.progressListener.onError(new ExportErrorStatus(-124, localThrowable2, "", AssetWriterInput.this.indicatorInfo));
          AppMethodBeat.o(215295);
        }
      }
    });
    AppMethodBeat.o(215394);
  }
  
  public void postRunnable(Runnable paramRunnable)
  {
    AppMethodBeat.i(215443);
    if ((this.handler != null) && (this.handlerThread.isAlive())) {
      this.handler.post(paramRunnable);
    }
    AppMethodBeat.o(215443);
  }
  
  public void requestMediaDataWhenReadyOnQueue(HandlerThread paramHandlerThread, final Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(215364);
        if (this.handler != null)
        {
          Logger.e(this.TAG, "正在处理上一次的request请求，无法重复发起");
          AppMethodBeat.o(215364);
          return;
        }
        if (this.assetWriter == null)
        {
          Logger.e(this.TAG, "还没有与AssetWriter关联，无法发起request请求");
          AppMethodBeat.o(215364);
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
          AppMethodBeat.i(215268);
          if (AssetWriterInput.this.start()) {
            paramRunnable.run();
          }
          AppMethodBeat.o(215268);
        }
      });
      this.writerThread = new HandlerThread("writerThread");
      this.writerThread.start();
      this.writerHandler = new Handler(this.writerThread.getLooper());
      AppMethodBeat.o(215364);
    }
  }
  
  public void reset(final Runnable paramRunnable)
  {
    AppMethodBeat.i(215352);
    this.handler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(215262);
        if (AssetWriterInput.this.start()) {
          paramRunnable.run();
        }
        AppMethodBeat.o(215262);
      }
    });
    AppMethodBeat.o(215352);
  }
  
  public void setMetadata(List<MetadataItem> paramList)
  {
    this.metadata = paramList;
  }
  
  public void setTransform(Matrix paramMatrix)
  {
    this.transform = paramMatrix;
  }
  
  public void setWriterProgressListener(WriterProgressListener paramWriterProgressListener)
  {
    this.progressListener = paramWriterProgressListener;
  }
  
  boolean start()
  {
    AppMethodBeat.i(215422);
    Logger.i(this.TAG, "start");
    if (this.started)
    {
      AppMethodBeat.o(215422);
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
        Logger.e(this.TAG, "start: ", localException);
        onStartError(localException, this.mediaType);
        continue;
      }
      bool = this.started;
      AppMethodBeat.o(215422);
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
    public abstract void statusChanged(AssetWriterInput paramAssetWriterInput, AssetWriterStatus paramAssetWriterStatus);
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
      AppMethodBeat.i(215243);
      if (AssetWriterInput.this.handler == null)
      {
        AppMethodBeat.o(215243);
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
        finally
        {
          if (!(localObject instanceof ExportRuntimeException)) {
            continue;
          }
          ExportErrorStatus localExportErrorStatus = ((ExportRuntimeException)localObject).getErrorStatus();
          if (AssetWriterInput.this.progressListener == null) {
            continue;
          }
          localExportErrorStatus.indicatorInfo = AssetWriterInput.this.indicatorInfo;
          AssetWriterInput.this.progressListener.onError(localExportErrorStatus);
          AppMethodBeat.o(215243);
          return;
          localExportErrorStatus = new ExportErrorStatus(-122, localExportErrorStatus);
          continue;
          long l = -1L;
          continue;
        }
        if (AssetWriterInput.this.progressListener != null) {
          AssetWriterInput.this.progressListener.onProgressChanged(AssetWriterInput.this, l);
        }
        AppMethodBeat.o(215243);
        return;
        AssetWriterInput.this.writer.writeAudioSample(this.sampleBuffer.getTime().getTimeUs(), this.sampleBuffer.getSampleByteBuffer());
        l = AssetWriterInput.this.writer.getAudioPresentationTimeUs();
      }
    }
  }
  
  public static abstract interface WriterProgressListener
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
      AppMethodBeat.i(215201);
      Trace.beginSection("leex-encode");
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
          Trace.endSection();
          AppMethodBeat.o(215201);
          return;
        }
        finally
        {
          if (!(localObject instanceof ExportRuntimeException)) {}
        }
        for (ExportErrorStatus localExportErrorStatus = ((ExportRuntimeException)localObject).getErrorStatus(); AssetWriterInput.this.progressListener != null; localExportErrorStatus = new ExportErrorStatus(-121, localExportErrorStatus))
        {
          localExportErrorStatus.indicatorInfo = AssetWriterInput.this.indicatorInfo;
          AssetWriterInput.this.progressListener.onError(localExportErrorStatus);
          AppMethodBeat.o(215201);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput
 * JD-Core Version:    0.7.0.1
 */