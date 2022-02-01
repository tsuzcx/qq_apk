package com.tencent.mm.plugin.vlog.model;

import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.h;
import com.tencent.mm.media.util.c;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.threadpool.c.d;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder;", "Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;", "()V", "bufId", "", "copyTmpBuffer", "Ljava/nio/ByteBuffer;", "eGLEnvironmentCond", "Landroid/os/ConditionVariable;", "encodeRGB2YuvHandler", "Landroid/os/Handler;", "encodeRGB2YuvHandlerThread", "Landroid/os/HandlerThread;", "encodeRGB2YuvImageReader", "Landroid/media/ImageReader;", "encodeSurfaceImageReader", "encodeYuvCount", "fakeVideoBuffer", "kotlin.jvm.PlatformType", "imageReaderInitSucc", "", "isInputEndOfStream", "isStopped", "muxer", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "renderRgb2YuvLock", "Ljava/util/concurrent/Semaphore;", "renderYuvCount", "rgb2yuvEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "rgbAvailableCount", "sampleTimeUs", "", "startEncodeTick", "stopLock", "Ljava/lang/Object;", "videoBitrate", "videoFormat", "Landroid/media/MediaFormat;", "videoFps", "videoHeight", "videoSampleRenderContext", "Lcom/tencent/tav/decoder/RenderContext;", "videoSize", "Lcom/tencent/tav/coremedia/CGSize;", "videoWidth", "writeRGBCount", "writeYuvCount", "yuvHeight", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/RGB2YUVI420RenderProc;", "yuvWidth", "checkInitBufId", "", "createInputSurface", "Landroid/view/Surface;", "finishEncode", "flush", "getEncodeFormat", "getEncodePresentationTimeUs", "getEncodeSize", "initRgb2YuvImageReader", "isEncodeToEndOfStream", "isNeedVideoOutputTexture", "onInputEndOfStream", "prepare", "outputConfig", "Lcom/tencent/tav/core/ExportConfig;", "processImageYUVBufferToWriteYUVData", "width", "height", "plane", "Landroid/media/Image$Plane;", "processVideoTexture", "sampleBufferRenderOutputTexture", "Lcom/tencent/tav/coremedia/TextureInfo;", "sampleTime", "Lcom/tencent/tav/coremedia/CMTime;", "release", "requestConvertGpuRgb2YuvRender", "timestamp", "reset", "setMediaMuxer", "setVideoSampleRenderContext", "renderContext", "signalEndOfInputStream", "start", "stop", "writeVideoSample", "sampleBuffer", "Lcom/tencent/tav/coremedia/CMSampleBuffer;", "isEndOfStream", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements AssetWriterVideoEncoder
{
  public static final a TYF;
  private RenderContext TYG;
  private volatile boolean TYH;
  private ImageReader TYI;
  private volatile boolean TYJ;
  private ConditionVariable TYK;
  private final Semaphore TYL;
  private volatile int TYM;
  private int TYN;
  private int TYO;
  private ByteBuffer TYP;
  private int bufId;
  private final Object cBq;
  private volatile long cUj;
  private IMediaMuxer muxer;
  private ByteBuffer nAa;
  private ImageReader nAb;
  private Handler nAc;
  private HandlerThread nAd;
  private h nAe;
  private c.b nAf;
  private int nAg;
  private int nAh;
  private volatile boolean nAi;
  private long nAj;
  private volatile int nAn;
  private volatile int nAo;
  private int videoBitrate;
  private MediaFormat videoFormat;
  private int videoFps;
  private int videoHeight;
  private CGSize videoSize;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(283467);
    TYF = new a((byte)0);
    AppMethodBeat.o(283467);
  }
  
  public g()
  {
    AppMethodBeat.i(283391);
    HandlerThread localHandlerThread = d.jv("finder_soft_encode_rgb2yuv_thread", -4);
    s.s(localHandlerThread, "createEGLThread(\"finder_….THREAD_PRIORITY_DISPLAY)");
    this.nAd = localHandlerThread;
    this.TYK = new ConditionVariable();
    this.bufId = -1;
    this.cBq = new Object();
    this.TYL = new Semaphore(1);
    this.TYP = ByteBuffer.allocate(1);
    AppMethodBeat.o(283391);
  }
  
  private static final void a(long paramLong, g paramg)
  {
    Object localObject3 = null;
    AppMethodBeat.i(283454);
    s.u(paramg, "this$0");
    Log.i("MicroMsg.CompositionSoftwareEncoder", s.X("render gpu rgb2yuv, timestamp:", Long.valueOf(paramLong)));
    Object localObject1 = paramg.nAe;
    if (localObject1 != null) {
      ((h)localObject1).bgE();
    }
    localObject1 = paramg.nAf;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = paramg.nAf;
      if (localObject2 != null) {
        break label139;
      }
      localObject2 = null;
      label66:
      EGLExt.eglPresentationTimeANDROID((EGLDisplay)localObject1, (EGLSurface)localObject2, 1000L * paramLong);
      localObject1 = c.nFs;
      localObject1 = paramg.nAf;
      if (localObject1 != null) {
        break label149;
      }
      localObject1 = null;
      label93:
      localObject2 = paramg.nAf;
      if (localObject2 != null) {
        break label157;
      }
    }
    label139:
    label149:
    label157:
    for (Object localObject2 = localObject3;; localObject2 = ((c.b)localObject2).eglSurface)
    {
      c.a.a((EGLDisplay)localObject1, (EGLSurface)localObject2);
      paramg.nAn += 1;
      AppMethodBeat.o(283454);
      return;
      localObject1 = ((c.b)localObject1).nFB;
      break;
      localObject2 = ((c.b)localObject2).eglSurface;
      break label66;
      localObject1 = ((c.b)localObject1).nFB;
      break label93;
    }
  }
  
  /* Error */
  private static final void a(ImageReader paramImageReader, g paramg)
  {
    // Byte code:
    //   0: ldc_w 291
    //   3: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 293
    //   10: invokestatic 229	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc 226
    //   16: invokestatic 229	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 299	android/media/ImageReader:getSurface	()Landroid/view/Surface;
    //   23: invokevirtual 305	android/view/Surface:isValid	()Z
    //   26: ifeq +155 -> 181
    //   29: getstatic 271	com/tencent/mm/media/util/c:nFs	Lcom/tencent/mm/media/util/c$a;
    //   32: astore_2
    //   33: aload_0
    //   34: invokevirtual 299	android/media/ImageReader:getSurface	()Landroid/view/Surface;
    //   37: astore_3
    //   38: aload_1
    //   39: getfield 307	com/tencent/mm/plugin/vlog/model/g:TYG	Lcom/tencent/tav/decoder/RenderContext;
    //   42: astore_0
    //   43: aload_0
    //   44: ifnonnull +121 -> 165
    //   47: aconst_null
    //   48: astore_0
    //   49: aload_1
    //   50: aload_2
    //   51: aload_3
    //   52: iconst_0
    //   53: iconst_0
    //   54: aload_0
    //   55: bipush 14
    //   57: invokestatic 310	com/tencent/mm/media/util/c$a:a	(Lcom/tencent/mm/media/util/c$a;Landroid/view/Surface;IILandroid/opengl/EGLContext;I)Lcom/tencent/mm/media/util/c$b;
    //   60: putfield 257	com/tencent/mm/plugin/vlog/model/g:nAf	Lcom/tencent/mm/media/util/c$b;
    //   63: aload_1
    //   64: new 252	com/tencent/mm/media/j/b/h
    //   67: dup
    //   68: iconst_1
    //   69: bipush 15
    //   71: invokespecial 313	com/tencent/mm/media/j/b/h:<init>	(II)V
    //   74: putfield 250	com/tencent/mm/plugin/vlog/model/g:nAe	Lcom/tencent/mm/media/j/b/h;
    //   77: aload_1
    //   78: getfield 250	com/tencent/mm/plugin/vlog/model/g:nAe	Lcom/tencent/mm/media/j/b/h;
    //   81: astore_0
    //   82: aload_0
    //   83: ifnull +15 -> 98
    //   86: aload_0
    //   87: aload_1
    //   88: getfield 315	com/tencent/mm/plugin/vlog/model/g:nAg	I
    //   91: aload_1
    //   92: getfield 317	com/tencent/mm/plugin/vlog/model/g:nAh	I
    //   95: invokevirtual 320	com/tencent/mm/media/j/b/h:ek	(II)V
    //   98: new 322	java/lang/StringBuilder
    //   101: dup
    //   102: ldc_w 324
    //   105: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: getfield 257	com/tencent/mm/plugin/vlog/model/g:nAf	Lcom/tencent/mm/media/util/c$b;
    //   112: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: ldc_w 333
    //   118: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: astore_2
    //   122: aload_1
    //   123: getfield 307	com/tencent/mm/plugin/vlog/model/g:TYG	Lcom/tencent/tav/decoder/RenderContext;
    //   126: astore_0
    //   127: aload_0
    //   128: ifnonnull +45 -> 173
    //   131: aconst_null
    //   132: astore_0
    //   133: ldc 231
    //   135: aload_2
    //   136: aload_0
    //   137: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_1
    //   147: iconst_1
    //   148: putfield 342	com/tencent/mm/plugin/vlog/model/g:TYJ	Z
    //   151: aload_1
    //   152: getfield 205	com/tencent/mm/plugin/vlog/model/g:TYK	Landroid/os/ConditionVariable;
    //   155: invokevirtual 345	android/os/ConditionVariable:open	()V
    //   158: ldc_w 291
    //   161: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: return
    //   165: aload_0
    //   166: invokevirtual 351	com/tencent/tav/decoder/RenderContext:eglContext	()Landroid/opengl/EGLContext;
    //   169: astore_0
    //   170: goto -121 -> 49
    //   173: aload_0
    //   174: invokevirtual 351	com/tencent/tav/decoder/RenderContext:eglContext	()Landroid/opengl/EGLContext;
    //   177: astore_0
    //   178: goto -45 -> 133
    //   181: ldc 231
    //   183: ldc_w 353
    //   186: invokestatic 356	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: goto -43 -> 146
    //   192: astore_0
    //   193: ldc 231
    //   195: aload_0
    //   196: checkcast 358	java/lang/Throwable
    //   199: ldc_w 360
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 364	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: aload_1
    //   210: iconst_0
    //   211: putfield 342	com/tencent/mm/plugin/vlog/model/g:TYJ	Z
    //   214: aload_1
    //   215: getfield 205	com/tencent/mm/plugin/vlog/model/g:TYK	Landroid/os/ConditionVariable;
    //   218: invokevirtual 345	android/os/ConditionVariable:open	()V
    //   221: ldc_w 291
    //   224: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: return
    //   228: astore_0
    //   229: aload_1
    //   230: getfield 205	com/tencent/mm/plugin/vlog/model/g:TYK	Landroid/os/ConditionVariable;
    //   233: invokevirtual 345	android/os/ConditionVariable:open	()V
    //   236: ldc_w 291
    //   239: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aload_0
    //   243: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramImageReader	ImageReader
    //   0	244	1	paramg	g
    //   32	104	2	localObject	Object
    //   37	15	3	localSurface	Surface
    // Exception table:
    //   from	to	target	type
    //   19	43	192	java/lang/Exception
    //   49	82	192	java/lang/Exception
    //   86	98	192	java/lang/Exception
    //   98	127	192	java/lang/Exception
    //   133	146	192	java/lang/Exception
    //   146	151	192	java/lang/Exception
    //   165	170	192	java/lang/Exception
    //   173	178	192	java/lang/Exception
    //   181	189	192	java/lang/Exception
    //   19	43	228	finally
    //   49	82	228	finally
    //   86	98	228	finally
    //   98	127	228	finally
    //   133	146	228	finally
    //   146	151	228	finally
    //   165	170	228	finally
    //   173	178	228	finally
    //   181	189	228	finally
    //   193	214	228	finally
  }
  
  private static final void a(g paramg, ImageReader paramImageReader)
  {
    AppMethodBeat.i(283436);
    s.u(paramg, "this$0");
    paramImageReader = paramImageReader.acquireNextImage();
    if (paramImageReader != null) {
      try
      {
        Log.i("MicroMsg.CompositionSoftwareEncoder", "nextYUVImage, size:[" + paramImageReader.getWidth() + 'x' + paramImageReader.getHeight() + "], format:" + paramImageReader.getFormat() + ", planes.size:" + paramImageReader.getPlanes().length + ", timestamp:" + paramImageReader.getTimestamp() + ", rowStride:" + paramImageReader.getPlanes()[0].getRowStride() + ", pixelStride:" + paramImageReader.getPlanes()[0].getPixelStride() + ",buffer.capacity:" + paramImageReader.getPlanes()[0].getBuffer().capacity());
        int i = paramImageReader.getWidth();
        int j = paramImageReader.getHeight();
        Image.Plane localPlane = paramImageReader.getPlanes()[0];
        s.s(localPlane, "image.planes[0]");
        paramg.a(i, j, localPlane);
        paramg.nAo += 1;
        paramg.TYL.release();
        return;
      }
      catch (Exception paramg)
      {
        Log.printErrStackTrace("MicroMsg.CompositionSoftwareEncoder", (Throwable)paramg, "acquireNextImage error", new Object[0]);
        return;
      }
      finally
      {
        paramImageReader.close();
        AppMethodBeat.o(283436);
      }
    }
    AppMethodBeat.o(283436);
  }
  
  private static final void a(g paramg, c.b paramb)
  {
    AppMethodBeat.i(283461);
    s.u(paramg, "this$0");
    s.u(paramb, "$it");
    paramg = paramg.nAe;
    if (paramg != null) {
      paramg.release();
    }
    paramg = c.nFs;
    c.a.a(paramb);
    AppMethodBeat.o(283461);
  }
  
  private final boolean a(int paramInt1, int paramInt2, Image.Plane paramPlane)
  {
    AppMethodBeat.i(283410);
    Object localObject2;
    synchronized (this.cBq)
    {
      if ((this.bufId >= 0) || (!(this.muxer instanceof TAVKitMuxer.SightVideoJNIMediaMuxer))) {
        break label145;
      }
      localObject2 = this.muxer;
      if (localObject2 == null)
      {
        paramPlane = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.TAVKitMuxer.SightVideoJNIMediaMuxer");
        AppMethodBeat.o(283410);
        throw paramPlane;
      }
    }
    if (((TAVKitMuxer.SightVideoJNIMediaMuxer)localObject2).getBufId() >= 0)
    {
      localObject2 = this.muxer;
      if (localObject2 == null)
      {
        paramPlane = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.TAVKitMuxer.SightVideoJNIMediaMuxer");
        AppMethodBeat.o(283410);
        throw paramPlane;
      }
      this.bufId = ((TAVKitMuxer.SightVideoJNIMediaMuxer)localObject2).getBufId();
      Log.i("MicroMsg.CompositionSoftwareEncoder", s.X("set bufId:", Integer.valueOf(this.bufId)));
    }
    label145:
    if (this.bufId >= 0)
    {
      long l = Util.currentTicks();
      Log.i("MicroMsg.CompositionSoftwareEncoder", "processImageYUVBufferToWriteYUVData, width:" + paramInt1 + ", height:" + paramInt2 + ", videoWidth:" + this.videoWidth + ", videoHeight:" + this.videoHeight);
      paramInt1 = paramPlane.getRowStride();
      paramInt2 = paramPlane.getPixelStride();
      if (this.nAa == null) {
        this.nAa = ByteBuffer.allocateDirect(this.nAg * this.nAh * paramInt2);
      }
      localObject2 = this.nAa;
      if (localObject2 != null) {
        ((ByteBuffer)localObject2).position(0);
      }
      paramPlane = paramPlane.getBuffer();
      paramPlane.position(0);
      SightVideoJNI.nativeBufferCopy(paramPlane, this.nAa, this.nAg * paramInt2, this.nAh, paramInt1 - paramInt2 * this.nAg);
      SightVideoJNI.writeYuvDataForMMSightEncode(this.bufId, (Buffer)this.nAa, this.videoWidth, this.videoHeight);
      paramPlane = this.muxer;
      if (paramPlane != null)
      {
        localObject2 = this.muxer;
        if (localObject2 != null) {
          break label419;
        }
      }
      label419:
      for (paramInt1 = -1;; paramInt1 = ((IMediaMuxer)localObject2).videoTrackIndex())
      {
        localObject2 = this.TYP;
        MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
        localBufferInfo.presentationTimeUs = this.cUj;
        ah localah = ah.aiuX;
        paramPlane.writeSampleData(paramInt1, (ByteBuffer)localObject2, localBufferInfo);
        Log.i("MicroMsg.CompositionSoftwareEncoder", s.X("end processImageYUVBufferToWriteYUVData, cost:", Long.valueOf(Util.ticksToNow(l))));
        AppMethodBeat.o(283410);
        return true;
      }
    }
    paramPlane = ah.aiuX;
    AppMethodBeat.o(283410);
    return false;
  }
  
  private final void boZ()
  {
    AppMethodBeat.i(283421);
    synchronized (this.cBq)
    {
      Log.i("MicroMsg.CompositionSoftwareEncoder", "finishEncode, imageReader:" + this.TYI + ", isInputEndOfStream:" + this.TYH);
      this.nAi = true;
      Object localObject2 = this.TYI;
      if (localObject2 != null) {
        ((ImageReader)localObject2).close();
      }
      localObject2 = this.nAb;
      if (localObject2 != null) {
        ((ImageReader)localObject2).close();
      }
      localObject2 = this.nAf;
      if (localObject2 != null)
      {
        Handler localHandler = this.nAc;
        if (localHandler != null) {
          localHandler.post(new g..ExternalSyntheticLambda3(this, (c.b)localObject2));
        }
      }
      if (this.bufId >= 0) {
        SightVideoJNI.finishVideoEncode(this.bufId);
      }
      this.bufId = -1;
      this.nAd.quitSafely();
      this.nAc = null;
      this.nAb = null;
      this.nAf = null;
      this.TYI = null;
      Log.i("MicroMsg.CompositionSoftwareEncoder", "finishEncode, encodeYuvCount:" + this.TYM + ", writeYuvCount:" + this.nAo + ", renderYuvCount:" + this.nAn);
      localObject2 = ah.aiuX;
      AppMethodBeat.o(283421);
      return;
    }
  }
  
  private final void hQo()
  {
    AppMethodBeat.i(283426);
    this.TYH = true;
    this.cUj = -1L;
    Log.i("MicroMsg.CompositionSoftwareEncoder", "onInputEndOfStream, renderYuvCount:" + this.nAn + ", writeYuvCount:" + this.nAo + ", writeRGBCount:" + this.TYN + ", rgbAvailableCount:" + this.TYO);
    AppMethodBeat.o(283426);
  }
  
  public final Surface createInputSurface()
  {
    AppMethodBeat.i(283548);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "createInputSurface");
    Object localObject = this.TYI;
    if (localObject == null)
    {
      AppMethodBeat.o(283548);
      return null;
    }
    localObject = ((ImageReader)localObject).getSurface();
    AppMethodBeat.o(283548);
    return localObject;
  }
  
  public final void flush() {}
  
  public final MediaFormat getEncodeFormat()
  {
    AppMethodBeat.i(283518);
    MediaFormat localMediaFormat = this.videoFormat;
    s.checkNotNull(localMediaFormat);
    AppMethodBeat.o(283518);
    return localMediaFormat;
  }
  
  public final long getEncodePresentationTimeUs()
  {
    return this.cUj;
  }
  
  public final CGSize getEncodeSize()
  {
    AppMethodBeat.i(283581);
    CGSize localCGSize = this.videoSize;
    if (localCGSize == null)
    {
      localCGSize = CGSize.CGSizeZero;
      s.s(localCGSize, "CGSizeZero");
      AppMethodBeat.o(283581);
      return localCGSize;
    }
    AppMethodBeat.o(283581);
    return localCGSize;
  }
  
  public final boolean isEncodeToEndOfStream()
  {
    return this.TYH;
  }
  
  public final boolean isNeedVideoOutputTexture()
  {
    return true;
  }
  
  public final boolean prepare(ExportConfig paramExportConfig, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(283510);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "prepare, outputConfig:" + paramExportConfig + ", videoFormat:" + paramMediaFormat);
    if (paramExportConfig != null)
    {
      this.videoWidth = paramExportConfig.getOutputWidth();
      this.videoHeight = paramExportConfig.getOutputHeight();
      this.videoFps = paramExportConfig.getVideoFrameRate();
      this.videoBitrate = paramExportConfig.getVideoBitRate();
      this.videoSize = new CGSize(this.videoWidth, this.videoHeight);
      this.videoFormat = paramMediaFormat;
      this.TYI = ImageReader.newInstance(this.videoWidth, this.videoHeight, 1, 1);
      AppMethodBeat.o(283510);
      return true;
    }
    AppMethodBeat.o(283510);
    return false;
  }
  
  public final void processVideoTexture(TextureInfo paramTextureInfo, CMTime paramCMTime)
  {
    int i = 1;
    AppMethodBeat.i(283611);
    s.u(paramCMTime, "sampleTime");
    if (!this.TYJ)
    {
      Log.e("MicroMsg.CompositionSoftwareEncoder", "processVideoTexture imageReader not init now");
      paramTextureInfo = new Exception("ImageReader not init");
      AppMethodBeat.o(283611);
      throw paramTextureInfo;
    }
    Object localObject = this.muxer;
    if ((localObject != null) && (((IMediaMuxer)localObject).isMuxerStarted() == true)) {}
    while ((i != 0) && (paramTextureInfo != null))
    {
      Log.i("MicroMsg.CompositionSoftwareEncoder", "input sample buffer render texture:" + paramTextureInfo + ", sampleTime:" + paramCMTime.getTimeUs());
      localObject = this.nAe;
      if (localObject != null) {
        ((h)localObject).nEW = paramTextureInfo.textureID;
      }
      localObject = this.nAe;
      if (localObject != null) {
        ((h)localObject).el(paramTextureInfo.width, paramTextureInfo.height);
      }
      this.cUj = paramCMTime.getTimeUs();
      if (this.nAf != null)
      {
        long l = this.cUj;
        paramTextureInfo = this.nAc;
        if (paramTextureInfo != null) {
          paramTextureInfo.post(new g..ExternalSyntheticLambda1(l, this));
        }
        if (!this.nAi)
        {
          l = Util.currentTicks();
          this.TYL.acquire();
          Log.i("MicroMsg.CompositionSoftwareEncoder", s.X("wait output yuv data cost:", Long.valueOf(Util.ticksToNow(l))));
        }
      }
      AppMethodBeat.o(283611);
      return;
      i = 0;
    }
    localObject = new StringBuilder("muxer stared ");
    paramCMTime = this.muxer;
    if (paramCMTime == null) {}
    for (paramCMTime = null;; paramCMTime = Boolean.valueOf(paramCMTime.isMuxerStarted()))
    {
      Log.w("MicroMsg.CompositionSoftwareEncoder", paramCMTime + "; texture:" + paramTextureInfo);
      AppMethodBeat.o(283611);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(283594);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "release");
    boZ();
    AppMethodBeat.o(283594);
  }
  
  public final void reset() {}
  
  public final void setMediaMuxer(IMediaMuxer paramIMediaMuxer)
  {
    AppMethodBeat.i(283568);
    this.muxer = paramIMediaMuxer;
    Log.i("MicroMsg.CompositionSoftwareEncoder", s.X("setMediaMuxer: ", paramIMediaMuxer));
    if ((paramIMediaMuxer instanceof TAVKitMuxer.SightVideoJNIMediaMuxer))
    {
      ((TAVKitMuxer.SightVideoJNIMediaMuxer)paramIMediaMuxer).configMuxerToSoftEncode(true);
      ((TAVKitMuxer.SightVideoJNIMediaMuxer)paramIMediaMuxer).setSoftEncoder((AssetWriterVideoEncoder)this);
    }
    AppMethodBeat.o(283568);
  }
  
  public final void setVideoSampleRenderContext(RenderContext paramRenderContext)
  {
    AppMethodBeat.i(283525);
    this.TYG = paramRenderContext;
    if ((this.TYG != null) && (this.nAf == null))
    {
      int i = this.videoWidth;
      int j = this.videoHeight;
      long l = Util.currentTicks();
      this.nAg = (i / 4);
      this.nAh = (j * 3 / 2);
      this.nAb = ImageReader.newInstance(this.nAg, this.nAh, 1, 1);
      paramRenderContext = this.nAb;
      if (paramRenderContext != null)
      {
        this.nAd.start();
        this.nAc = new Handler(this.nAd.getLooper());
        paramRenderContext.setOnImageAvailableListener(new g..ExternalSyntheticLambda0(this), this.nAc);
        Handler localHandler = this.nAc;
        if (localHandler != null) {
          localHandler.post(new g..ExternalSyntheticLambda2(paramRenderContext, this));
        }
      }
      this.TYK.block(1000L);
      Log.i("MicroMsg.CompositionSoftwareEncoder", "initRgb2YuvImageReader, yuv size:[" + this.nAg + 'x' + this.nAh + "], cost:" + Util.ticksToNow(l));
    }
    AppMethodBeat.o(283525);
  }
  
  public final void signalEndOfInputStream()
  {
    AppMethodBeat.i(283542);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "signalEndOfInputStream");
    hQo();
    AppMethodBeat.o(283542);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(283557);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "start");
    this.nAj = Util.currentTicks();
    AppMethodBeat.o(283557);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(283572);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "stop");
    boZ();
    AppMethodBeat.o(283572);
  }
  
  public final boolean writeVideoSample(CMSampleBuffer paramCMSampleBuffer, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(283614);
    IMediaMuxer localIMediaMuxer = this.muxer;
    if (localIMediaMuxer == null) {}
    for (int i = -1; i == -1; i = localIMediaMuxer.videoTrackIndex())
    {
      AppMethodBeat.o(283614);
      return true;
    }
    if (paramCMSampleBuffer != null)
    {
      localIMediaMuxer = this.muxer;
      if ((localIMediaMuxer != null) && (localIMediaMuxer.isMuxerStarted() == true))
      {
        i = 1;
        if (i == 0) {
          break label158;
        }
      }
    }
    for (;;)
    {
      if (paramCMSampleBuffer != null)
      {
        Log.i("MicroMsg.CompositionSoftwareEncoder", s.X("writeVideoSample sampleTimeUs:", Long.valueOf(paramCMSampleBuffer.getTime().getTimeUs())));
        if ((this.nAf != null) && (this.TYH)) {
          this.cUj = -1L;
        }
      }
      if (paramBoolean)
      {
        Log.i("MicroMsg.CompositionSoftwareEncoder", s.X("writeVideoSample endOfStream, sampleBuffer:", paramCMSampleBuffer));
        hQo();
      }
      AppMethodBeat.o(283614);
      return bool;
      i = 0;
      break;
      label158:
      bool = false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$Companion;", "", "()V", "EGLEnvironmentInitTimeout", "", "TAG", "", "alignN", "", "value", "align", "alignSize", "Landroid/util/Size;", "size", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static int apx(int paramInt)
    {
      int i = paramInt;
      if (paramInt % 4 == 0) {
        return paramInt;
      }
      for (;;)
      {
        paramInt = i;
        if (i % 4 == 0) {
          break;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.g
 * JD-Core Version:    0.7.0.1
 */