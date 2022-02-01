package com.tencent.mm.plugin.vlog.model;

import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
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
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder;", "Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;", "()V", "bufId", "", "copyTmpBuffer", "Ljava/nio/ByteBuffer;", "encodeRGB2YuvHandler", "Landroid/os/Handler;", "encodeRGB2YuvHandlerThread", "Landroid/os/HandlerThread;", "encodeRGB2YuvImageReader", "Landroid/media/ImageReader;", "encodeSurfaceImageReader", "encodeYuvCount", "fakeVideoBuffer", "kotlin.jvm.PlatformType", "imageReaderInitSucc", "", "isInputEndOfStream", "isStopped", "muxer", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "renderRgb2YuvLock", "Ljava/util/concurrent/Semaphore;", "renderYuvCount", "rgb2yuvEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "rgbAvailableCount", "sampleTimeUs", "", "startEncodeTick", "stopLock", "Ljava/lang/Object;", "videoBitrate", "videoFormat", "Landroid/media/MediaFormat;", "videoFps", "videoHeight", "videoSampleRenderContext", "Lcom/tencent/tav/decoder/RenderContext;", "videoSize", "Lcom/tencent/tav/coremedia/CGSize;", "videoWidth", "writeRGBCount", "writeYuvCount", "yuvHeight", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/RGB2YUVPortraitRenderProc;", "yuvWidth", "checkInitBufId", "", "createInputSurface", "Landroid/view/Surface;", "finishEncode", "getEncodeFormat", "getEncodePresentationTimeUs", "getEncodeSize", "initRgb2YuvImageReader", "isEncodeToEndOfStream", "isNeedVideoOutputTexture", "onInputEndOfStream", "prepare", "outputConfig", "Lcom/tencent/tav/core/ExportConfig;", "processImageYUVBufferToWriteYUVData", "width", "height", "plane", "Landroid/media/Image$Plane;", "processVideoTexture", "sampleBufferRenderOutputTexture", "Lcom/tencent/tav/coremedia/TextureInfo;", "sampleTime", "Lcom/tencent/tav/coremedia/CMTime;", "release", "requestConvertGpuRgb2YuvRender", "timestamp", "setMediaMuxer", "setVideoSampleRenderContext", "renderContext", "signalEndOfInputStream", "start", "stop", "writeVideoSample", "sampleBuffer", "Lcom/tencent/tav/coremedia/CMSampleBuffer;", "isEndOfStream", "Companion", "plugin-vlog_release"})
public final class h
  implements AssetWriterVideoEncoder
{
  public static final h.a Nlm;
  private RenderContext Nld;
  private volatile boolean Nle;
  private ImageReader Nlf;
  private volatile boolean Nlg;
  private final Semaphore Nlh;
  private volatile int Nli;
  private int Nlj;
  private int Nlk;
  private ByteBuffer Nll;
  private final Object aFF;
  private volatile long bao;
  private int bufId;
  private c.b kUA;
  private int kUB;
  private int kUC;
  private volatile boolean kUD;
  private long kUE;
  private volatile int kUI;
  private volatile int kUJ;
  private ByteBuffer kUv;
  private ImageReader kUw;
  private Handler kUx;
  private HandlerThread kUy;
  private com.tencent.mm.media.j.b.h kUz;
  private IMediaMuxer muxer;
  private int videoBitrate;
  private MediaFormat videoFormat;
  private int videoFps;
  private int videoHeight;
  private CGSize videoSize;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(245045);
    Nlm = new h.a((byte)0);
    AppMethodBeat.o(245045);
  }
  
  public h()
  {
    AppMethodBeat.i(245044);
    HandlerThread localHandlerThread = d.ij("finder_soft_encode_rgb2yuv_thread", -4);
    p.j(localHandlerThread, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.kUy = localHandlerThread;
    this.bufId = -1;
    this.aFF = new Object();
    this.Nlh = new Semaphore(1);
    this.Nll = ByteBuffer.allocate(1);
    AppMethodBeat.o(245044);
  }
  
  private final boolean a(int paramInt1, int paramInt2, Image.Plane paramPlane)
  {
    AppMethodBeat.i(245019);
    Object localObject2;
    synchronized (this.aFF)
    {
      if ((this.bufId >= 0) || (!(this.muxer instanceof TAVKitMuxer.SightVideoJNIMediaMuxer))) {
        break label145;
      }
      localObject2 = this.muxer;
      if (localObject2 == null)
      {
        paramPlane = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.TAVKitMuxer.SightVideoJNIMediaMuxer");
        AppMethodBeat.o(245019);
        throw paramPlane;
      }
    }
    if (((TAVKitMuxer.SightVideoJNIMediaMuxer)localObject2).getBufId() >= 0)
    {
      localObject2 = this.muxer;
      if (localObject2 == null)
      {
        paramPlane = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.TAVKitMuxer.SightVideoJNIMediaMuxer");
        AppMethodBeat.o(245019);
        throw paramPlane;
      }
      this.bufId = ((TAVKitMuxer.SightVideoJNIMediaMuxer)localObject2).getBufId();
      Log.i("MicroMsg.CompositionSoftwareEncoder", "set bufId:" + this.bufId);
    }
    label145:
    if (this.bufId >= 0)
    {
      long l = Util.currentTicks();
      Log.i("MicroMsg.CompositionSoftwareEncoder", "processImageYUVBufferToWriteYUVData, width:" + paramInt1 + ", height:" + paramInt2 + ", videoWidth:" + this.videoWidth + ", videoHeight:" + this.videoHeight);
      paramInt1 = paramPlane.getRowStride();
      paramInt2 = paramPlane.getPixelStride();
      if (this.kUv == null) {
        this.kUv = ByteBuffer.allocateDirect(this.kUB * this.kUC * paramInt2);
      }
      localObject2 = this.kUv;
      if (localObject2 != null) {
        ((ByteBuffer)localObject2).position(0);
      }
      paramPlane = paramPlane.getBuffer();
      paramPlane.position(0);
      SightVideoJNI.nativeBufferCopy(paramPlane, this.kUv, this.kUB * paramInt2, this.kUC, paramInt1 - paramInt2 * this.kUB);
      SightVideoJNI.writeYuvDataForMMSightEncode(this.bufId, (Buffer)this.kUv, this.videoWidth, this.videoHeight);
      paramPlane = this.muxer;
      if (paramPlane != null)
      {
        localObject2 = this.muxer;
        if (localObject2 == null) {
          break label426;
        }
      }
      label426:
      for (paramInt1 = ((IMediaMuxer)localObject2).videoTrackIndex();; paramInt1 = -1)
      {
        localObject2 = this.Nll;
        MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
        localBufferInfo.presentationTimeUs = this.bao;
        paramPlane.writeSampleData(paramInt1, (ByteBuffer)localObject2, localBufferInfo);
        Log.i("MicroMsg.CompositionSoftwareEncoder", "end processImageYUVBufferToWriteYUVData, cost:" + Util.ticksToNow(l));
        AppMethodBeat.o(245019);
        return true;
      }
    }
    paramPlane = x.aazN;
    AppMethodBeat.o(245019);
    return false;
  }
  
  private final void aUx()
  {
    AppMethodBeat.i(245036);
    synchronized (this.aFF)
    {
      Log.i("MicroMsg.CompositionSoftwareEncoder", "finishEncode, imageReader:" + this.Nlf + ", isInputEndOfStream:" + this.Nle);
      this.kUD = true;
      Object localObject2 = this.Nlf;
      if (localObject2 != null) {
        ((ImageReader)localObject2).close();
      }
      localObject2 = this.kUw;
      if (localObject2 != null) {
        ((ImageReader)localObject2).close();
      }
      localObject2 = this.kUA;
      if (localObject2 != null)
      {
        Handler localHandler = this.kUx;
        if (localHandler != null) {
          localHandler.post((Runnable)new b((c.b)localObject2, this));
        }
      }
      if (this.bufId >= 0) {
        SightVideoJNI.finishVideoEncode(this.bufId);
      }
      this.bufId = -1;
      this.kUy.quitSafely();
      this.kUx = null;
      this.kUw = null;
      this.kUA = null;
      this.Nlf = null;
      Log.i("MicroMsg.CompositionSoftwareEncoder", "finishEncode, encodeYuvCount:" + this.Nli + ", writeYuvCount:" + this.kUJ + ", renderYuvCount:" + this.kUI);
      localObject2 = x.aazN;
      AppMethodBeat.o(245036);
      return;
    }
  }
  
  private final void gsS()
  {
    AppMethodBeat.i(245042);
    this.Nle = true;
    this.bao = -1L;
    Log.i("MicroMsg.CompositionSoftwareEncoder", "onInputEndOfStream, renderYuvCount:" + this.kUI + ", writeYuvCount:" + this.kUJ + ", writeRGBCount:" + this.Nlj + ", rgbAvailableCount:" + this.Nlk);
    AppMethodBeat.o(245042);
  }
  
  public final Surface createInputSurface()
  {
    AppMethodBeat.i(245025);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "createInputSurface");
    Object localObject = this.Nlf;
    if (localObject != null)
    {
      localObject = ((ImageReader)localObject).getSurface();
      AppMethodBeat.o(245025);
      return localObject;
    }
    AppMethodBeat.o(245025);
    return null;
  }
  
  public final MediaFormat getEncodeFormat()
  {
    AppMethodBeat.i(245021);
    MediaFormat localMediaFormat = this.videoFormat;
    if (localMediaFormat == null) {
      p.iCn();
    }
    AppMethodBeat.o(245021);
    return localMediaFormat;
  }
  
  public final long getEncodePresentationTimeUs()
  {
    return this.bao;
  }
  
  public final CGSize getEncodeSize()
  {
    AppMethodBeat.i(245031);
    CGSize localCGSize2 = this.videoSize;
    CGSize localCGSize1 = localCGSize2;
    if (localCGSize2 == null)
    {
      localCGSize1 = CGSize.CGSizeZero;
      p.j(localCGSize1, "CGSize.CGSizeZero");
    }
    AppMethodBeat.o(245031);
    return localCGSize1;
  }
  
  public final boolean isEncodeToEndOfStream()
  {
    return this.Nle;
  }
  
  public final boolean isNeedVideoOutputTexture()
  {
    return true;
  }
  
  public final boolean prepare(ExportConfig paramExportConfig, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(245015);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "prepare, outputConfig:" + paramExportConfig + ", videoFormat:" + paramMediaFormat);
    if (paramExportConfig != null)
    {
      this.videoWidth = paramExportConfig.getOutputWidth();
      this.videoHeight = paramExportConfig.getOutputHeight();
      this.videoFps = paramExportConfig.getVideoFrameRate();
      this.videoBitrate = paramExportConfig.getVideoBitRate();
      this.videoSize = new CGSize(this.videoWidth, this.videoHeight);
      this.videoFormat = paramMediaFormat;
      this.Nlf = ImageReader.newInstance(this.videoWidth, this.videoHeight, 1, 1);
      AppMethodBeat.o(245015);
      return true;
    }
    AppMethodBeat.o(245015);
    return false;
  }
  
  public final void processVideoTexture(TextureInfo paramTextureInfo, CMTime paramCMTime)
  {
    AppMethodBeat.i(245039);
    p.k(paramCMTime, "sampleTime");
    if (!this.Nlg)
    {
      Log.e("MicroMsg.CompositionSoftwareEncoder", "processVideoTexture imageReader not init now");
      paramTextureInfo = (Throwable)new Exception("ImageReader not init");
      AppMethodBeat.o(245039);
      throw paramTextureInfo;
    }
    Object localObject = this.muxer;
    if ((localObject != null) && (((IMediaMuxer)localObject).isMuxerStarted() == true) && (paramTextureInfo != null))
    {
      Log.i("MicroMsg.CompositionSoftwareEncoder", "input sample buffer render texture:" + paramTextureInfo + ", sampleTime:" + paramCMTime.getTimeUs());
      localObject = this.kUz;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.h)localObject).kZT = paramTextureInfo.textureID;
      }
      localObject = this.kUz;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.h)localObject).dv(paramTextureInfo.width, paramTextureInfo.height);
      }
    }
    this.bao = paramCMTime.getTimeUs();
    if (this.kUA != null)
    {
      final long l = this.bao;
      paramTextureInfo = this.kUx;
      if (paramTextureInfo != null) {
        paramTextureInfo.post((Runnable)new e(this, l));
      }
      if (!this.kUD)
      {
        l = Util.currentTicks();
        this.Nlh.acquire();
        Log.i("MicroMsg.CompositionSoftwareEncoder", "wait output yuv data cost:" + Util.ticksToNow(l));
      }
    }
    AppMethodBeat.o(245039);
  }
  
  public final void release()
  {
    AppMethodBeat.i(245035);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "release");
    aUx();
    AppMethodBeat.o(245035);
  }
  
  public final void setMediaMuxer(IMediaMuxer paramIMediaMuxer)
  {
    AppMethodBeat.i(245028);
    this.muxer = paramIMediaMuxer;
    Log.i("MicroMsg.CompositionSoftwareEncoder", "setMediaMuxer: ".concat(String.valueOf(paramIMediaMuxer)));
    if ((paramIMediaMuxer instanceof TAVKitMuxer.SightVideoJNIMediaMuxer)) {
      ((TAVKitMuxer.SightVideoJNIMediaMuxer)paramIMediaMuxer).configMuxerToSoftEncode(true);
    }
    AppMethodBeat.o(245028);
  }
  
  public final void setVideoSampleRenderContext(RenderContext paramRenderContext)
  {
    AppMethodBeat.i(245022);
    this.Nld = paramRenderContext;
    if ((this.Nld != null) && (this.kUA == null))
    {
      int i = this.videoWidth;
      int j = this.videoHeight;
      this.kUB = (i / 4);
      this.kUC = (j * 3 / 2);
      this.kUw = ImageReader.newInstance(this.kUB, this.kUC, 1, 1);
      paramRenderContext = this.kUw;
      if (paramRenderContext != null)
      {
        this.kUy.start();
        this.kUx = new Handler(this.kUy.getLooper());
        paramRenderContext.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)new c(this), this.kUx);
        Handler localHandler = this.kUx;
        if (localHandler != null) {
          localHandler.post((Runnable)new d(paramRenderContext, this));
        }
      }
      Log.i("MicroMsg.CompositionSoftwareEncoder", "initRgb2YuvImageReader, yuv size:[" + this.kUB + 'x' + this.kUC + ']');
    }
    AppMethodBeat.o(245022);
  }
  
  public final void signalEndOfInputStream()
  {
    AppMethodBeat.i(245024);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "signalEndOfInputStream");
    gsS();
    AppMethodBeat.o(245024);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(245026);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "start");
    this.kUE = Util.currentTicks();
    AppMethodBeat.o(245026);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(245029);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "stop");
    aUx();
    AppMethodBeat.o(245029);
  }
  
  public final boolean writeVideoSample(CMSampleBuffer paramCMSampleBuffer, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(245040);
    Object localObject;
    if (paramCMSampleBuffer != null)
    {
      localObject = this.muxer;
      if ((localObject == null) || (((IMediaMuxer)localObject).isMuxerStarted() != true)) {}
    }
    for (;;)
    {
      if (paramCMSampleBuffer != null)
      {
        localObject = new StringBuilder("writeVideoSample sampleTimeUs:");
        CMTime localCMTime = paramCMSampleBuffer.getTime();
        p.j(localCMTime, "sampleBuffer.time");
        Log.i("MicroMsg.CompositionSoftwareEncoder", localCMTime.getTimeUs());
        if ((this.kUA != null) && (this.Nle)) {
          this.bao = -1L;
        }
      }
      if (paramBoolean)
      {
        Log.i("MicroMsg.CompositionSoftwareEncoder", "writeVideoSample endOfStream, sampleBuffer:".concat(String.valueOf(paramCMSampleBuffer)));
        gsS();
      }
      AppMethodBeat.o(245040);
      return bool;
      bool = false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$finishEncode$1$1$1", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$$special$$inlined$let$lambda$1"})
  static final class b
    implements Runnable
  {
    b(c.b paramb, h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(247725);
      Object localObject = h.h(jdField_this);
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.h)localObject).release();
      }
      localObject = c.lar;
      c.a.a(this.kUN);
      AppMethodBeat.o(247725);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$initRgb2YuvImageReader$1$1"})
  static final class c
    implements ImageReader.OnImageAvailableListener
  {
    c(h paramh) {}
    
    public final void onImageAvailable(ImageReader paramImageReader)
    {
      AppMethodBeat.i(241001);
      paramImageReader = paramImageReader.acquireNextImage();
      if (paramImageReader != null) {
        try
        {
          Object localObject1 = new StringBuilder("nextYUVImage, size:[").append(paramImageReader.getWidth()).append('x').append(paramImageReader.getHeight()).append("], format:").append(paramImageReader.getFormat()).append(", planes.size:").append(paramImageReader.getPlanes().length).append(", timestamp:").append(paramImageReader.getTimestamp()).append(", rowStride:");
          Object localObject3 = paramImageReader.getPlanes()[0];
          p.j(localObject3, "image.planes[0]");
          localObject1 = ((StringBuilder)localObject1).append(((Image.Plane)localObject3).getRowStride()).append(", pixelStride:");
          localObject3 = paramImageReader.getPlanes()[0];
          p.j(localObject3, "image.planes[0]");
          localObject1 = ((StringBuilder)localObject1).append(((Image.Plane)localObject3).getPixelStride()).append(',').append("buffer.capacity:");
          localObject3 = paramImageReader.getPlanes()[0];
          p.j(localObject3, "image.planes[0]");
          Log.i("MicroMsg.CompositionSoftwareEncoder", ((Image.Plane)localObject3).getBuffer().capacity());
          localObject1 = this.Nln;
          int i = paramImageReader.getWidth();
          int j = paramImageReader.getHeight();
          localObject3 = paramImageReader.getPlanes()[0];
          p.j(localObject3, "image.planes[0]");
          h.a((h)localObject1, i, j, (Image.Plane)localObject3);
          localObject1 = this.Nln;
          h.a((h)localObject1, h.a((h)localObject1) + 1);
          localObject1 = h.b(this.Nln);
          if (localObject1 != null)
          {
            localObject3 = h.b(this.Nln);
            if (localObject3 == null) {
              break label348;
            }
          }
          label348:
          for (i = ((IMediaMuxer)localObject3).videoTrackIndex();; i = -1)
          {
            localObject3 = h.c(this.Nln);
            MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
            localBufferInfo.presentationTimeUs = h.d(this.Nln);
            ((IMediaMuxer)localObject1).writeSampleData(i, (ByteBuffer)localObject3, localBufferInfo);
            h.e(this.Nln).release();
            return;
          }
          AppMethodBeat.o(241001);
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.CompositionSoftwareEncoder", (Throwable)localException, "acquireNextImage error", new Object[0]);
          return;
        }
        finally
        {
          paramImageReader.close();
          AppMethodBeat.o(241001);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$initRgb2YuvImageReader$1$2"})
  static final class d
    implements Runnable
  {
    d(ImageReader paramImageReader, h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(227258);
      try
      {
        Object localObject1 = this.kUT.getSurface();
        p.j(localObject1, "it.surface");
        if (((Surface)localObject1).isValid())
        {
          Object localObject2 = jdField_this;
          c.a locala = c.lar;
          Surface localSurface = this.kUT.getSurface();
          localObject1 = h.g(jdField_this);
          if (localObject1 != null)
          {
            localObject1 = ((RenderContext)localObject1).eglContext();
            h.a((h)localObject2, c.a.a(locala, localSurface, 0, 0, (EGLContext)localObject1, 14));
            h.a(jdField_this, new com.tencent.mm.media.j.b.h(1, 15));
            localObject1 = h.h(jdField_this);
            if (localObject1 != null) {
              ((com.tencent.mm.media.j.b.h)localObject1).du(h.i(jdField_this), h.j(jdField_this));
            }
            localObject2 = new StringBuilder("create rgb2yuvEGLEnvironment:").append(h.f(jdField_this)).append(", shareEGLContext:");
            localObject1 = h.g(jdField_this);
            if (localObject1 == null) {
              break label197;
            }
            localObject1 = ((RenderContext)localObject1).eglContext();
            label165:
            Log.i("MicroMsg.CompositionSoftwareEncoder", localObject1);
          }
        }
        for (;;)
        {
          h.a(jdField_this, true);
          AppMethodBeat.o(227258);
          return;
          localObject1 = null;
          break;
          label197:
          localObject1 = null;
          break label165;
          Log.e("MicroMsg.CompositionSoftwareEncoder", "create rgb2yuvEGLEnvironment error surface invalid");
        }
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.CompositionSoftwareEncoder", (Throwable)localException, "configure imageReader render error", new Object[0]);
        h.a(jdField_this, false);
        AppMethodBeat.o(227258);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(h paramh, long paramLong) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(250181);
      Log.i("MicroMsg.CompositionSoftwareEncoder", "render gpu rgb2yuv, timestamp:" + l);
      Object localObject1 = h.h(this.Nln);
      if (localObject1 != null) {
        ((com.tencent.mm.media.j.b.h)localObject1).aMU();
      }
      localObject1 = h.f(this.Nln);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((c.b)localObject1).las;
        localObject2 = h.f(this.Nln);
        if (localObject2 == null) {
          break label170;
        }
        localObject2 = ((c.b)localObject2).eglSurface;
        label81:
        EGLExt.eglPresentationTimeANDROID((EGLDisplay)localObject1, (EGLSurface)localObject2, l * 1000L);
        localObject1 = c.lar;
        localObject1 = h.f(this.Nln);
        if (localObject1 == null) {
          break label175;
        }
      }
      label170:
      label175:
      for (localObject1 = ((c.b)localObject1).las;; localObject1 = null)
      {
        c.b localb = h.f(this.Nln);
        localObject2 = localObject3;
        if (localb != null) {
          localObject2 = localb.eglSurface;
        }
        c.a.a((EGLDisplay)localObject1, (EGLSurface)localObject2);
        localObject1 = this.Nln;
        h.b((h)localObject1, h.k((h)localObject1) + 1);
        AppMethodBeat.o(250181);
        return;
        localObject1 = null;
        break;
        localObject2 = null;
        break label81;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.h
 * JD-Core Version:    0.7.0.1
 */