package com.tencent.mm.plugin.vlog.model;

import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.f.c.d;
import com.tencent.f.e.a;
import com.tencent.f.e.f;
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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder;", "Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;", "()V", "bufId", "", "copyTmpBuffer", "Ljava/nio/ByteBuffer;", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeRGB2YuvHandler", "Landroid/os/Handler;", "encodeRGB2YuvHandlerThread", "Landroid/os/HandlerThread;", "encodeRGB2YuvImageReader", "Landroid/media/ImageReader;", "encodeSurfaceHandler", "encodeSurfaceHandlerThread", "encodeSurfaceImageReader", "isInputEndOfStream", "", "isStopped", "muxer", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "renderYuvCount", "rgb2yuvEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "rgbAvailableCount", "sampleTimeUs", "", "startEncodeTick", "stopLock", "Ljava/lang/Object;", "useGpuRgb2Yuv", "videoBitrate", "videoFormat", "Landroid/media/MediaFormat;", "videoFps", "videoHeight", "videoSampleRenderContext", "Lcom/tencent/tav/decoder/RenderContext;", "videoSize", "Lcom/tencent/tav/coremedia/CGSize;", "videoWidth", "writeDataWaitEncodeLock", "writeRGBCount", "writeYuvCount", "writeYuvDataEncodeLock", "yuvHeight", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/RGB2YUVPortraitRenderProc;", "yuvWidth", "checkInitBufId", "", "checkStartEncodeLoop", "createInputSurface", "Landroid/view/Surface;", "encodeLoop", "finishEncode", "getEncodeFormat", "getEncodePresentationTimeUs", "getEncodeSize", "initEncodeSurfaceImageReader", "initRgb2YuvImageReader", "inputVideoTexture", "sampleBufferRenderOutputTexture", "Lcom/tencent/tav/coremedia/TextureInfo;", "isEncodeToEndOfStream", "isNeedVideoOutputTexture", "notifyToEncode", "onInputEndOfStream", "prepare", "outputConfig", "Lcom/tencent/tav/core/ExportConfig;", "processImageRGBABufferToWriteRGBAData", "width", "height", "plane", "Landroid/media/Image$Plane;", "processImageYUVBufferToWriteYUVData", "release", "requestConvertGpuRgb2YuvRender", "timestamp", "setMediaMuxer", "setVideoSampleRenderContext", "renderContext", "signalEndOfInputStream", "start", "stop", "writeVideoSample", "sampleBuffer", "Lcom/tencent/tav/coremedia/CMSampleBuffer;", "isEndOfStream", "Companion", "plugin-vlog_release"})
public final class h
  implements AssetWriterVideoEncoder
{
  public static final h.a GxK;
  private RenderContext GxC;
  private volatile boolean GxD;
  private ImageReader GxE;
  private Handler GxF;
  private HandlerThread GxG;
  private boolean GxH;
  private int GxI;
  private int GxJ;
  private volatile long bqM;
  private int bufId;
  private volatile int ifA;
  private ByteBuffer ifH;
  private ImageReader ifI;
  private Handler ifJ;
  private HandlerThread ifK;
  private com.tencent.mm.media.j.b.h ifL;
  private c.b ifM;
  private int ifN;
  private int ifO;
  private volatile boolean ifP;
  private long ifQ;
  private final Object ifR;
  private final Object ifT;
  private volatile int ifU;
  private volatile int ifV;
  private f<?> ifx;
  private IMediaMuxer muxer;
  private final Object stopLock;
  private int videoBitrate;
  private MediaFormat videoFormat;
  private int videoFps;
  private int videoHeight;
  private CGSize videoSize;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(190537);
    GxK = new h.a((byte)0);
    AppMethodBeat.o(190537);
  }
  
  public h()
  {
    AppMethodBeat.i(190536);
    HandlerThread localHandlerThread = d.hz("finder_soft_encode_process_data_thread", 0);
    p.g(localHandlerThread, "SpecialThreadFactory.cre….THREAD_PRIORITY_DEFAULT)");
    this.GxG = localHandlerThread;
    localHandlerThread = d.hz("finder_soft_encode_rgb2yuv_thread", -4);
    p.g(localHandlerThread, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.ifK = localHandlerThread;
    this.GxH = true;
    this.bufId = -1;
    this.stopLock = new Object();
    this.ifT = new Object();
    this.ifR = new Object();
    AppMethodBeat.o(190536);
  }
  
  private final boolean a(int paramInt1, int paramInt2, Image.Plane paramPlane)
  {
    AppMethodBeat.i(190520);
    synchronized (this.stopLock)
    {
      checkInitBufId();
      if (this.bufId >= 0)
      {
        long l = Util.currentTicks();
        Log.i("MicroMsg.CompositionSoftwareEncoder", "processImageYUVBufferToWriteYUVData, width:" + paramInt1 + ", height:" + paramInt2 + ", videoWidth:" + this.videoWidth + ", videoHeight:" + this.videoHeight);
        paramInt1 = paramPlane.getRowStride();
        paramInt2 = paramPlane.getPixelStride();
        if (this.ifH == null) {
          this.ifH = ByteBuffer.allocateDirect(this.ifN * this.ifO * paramInt2);
        }
        ByteBuffer localByteBuffer = this.ifH;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        paramPlane = paramPlane.getBuffer();
        paramPlane.position(0);
        SightVideoJNI.nativeBufferCopy(paramPlane, this.ifH, this.ifN * paramInt2, this.ifO, paramInt1 - paramInt2 * this.ifN);
        SightVideoJNI.writeYuvDataForMMSightWithBuffer(this.bufId, (Buffer)this.ifH, this.videoWidth, this.videoHeight, false, false, this.videoWidth, this.videoHeight);
        Log.i("MicroMsg.CompositionSoftwareEncoder", "end processImageYUVBufferToWriteYUVData, cost:" + Util.ticksToNow(l));
      }
      AppMethodBeat.o(190520);
      return false;
    }
  }
  
  private final void aMi()
  {
    AppMethodBeat.i(190532);
    synchronized (this.stopLock)
    {
      Log.i("MicroMsg.CompositionSoftwareEncoder", "finishEncode, imageReader:" + this.GxE + ", encodePipeline:" + this.ifx + ", isInputEndOfStream:" + this.GxD);
      this.ifP = true;
      Object localObject2 = this.GxE;
      if (localObject2 != null) {
        ((ImageReader)localObject2).close();
      }
      this.GxG.quitSafely();
      if (this.GxH) {
        aMo();
      }
      localObject2 = this.ifI;
      if (localObject2 != null) {
        ((ImageReader)localObject2).close();
      }
      localObject2 = this.ifM;
      if (localObject2 != null)
      {
        Handler localHandler = this.ifJ;
        if (localHandler != null) {
          localHandler.post((Runnable)new c((c.b)localObject2, this));
        }
      }
      this.ifK.quitSafely();
      this.ifI = null;
      this.ifM = null;
      localObject2 = this.ifx;
      if (localObject2 != null) {
        ((f)localObject2).take();
      }
      this.GxE = null;
      this.ifx = null;
      localObject2 = x.SXb;
      AppMethodBeat.o(190532);
      return;
    }
  }
  
  private final void aMo()
  {
    AppMethodBeat.i(190518);
    synchronized (this.ifR)
    {
      try
      {
        Log.i("MicroMsg.CompositionSoftwareEncoder", "notify to encode");
        this.ifR.notifyAll();
        x localx = x.SXb;
        AppMethodBeat.o(190518);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.CompositionSoftwareEncoder", (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  private final boolean b(int paramInt1, int paramInt2, Image.Plane paramPlane)
  {
    AppMethodBeat.i(190519);
    synchronized (this.stopLock)
    {
      checkInitBufId();
      if (this.bufId >= 0)
      {
        long l = Util.currentTicks();
        Log.i("MicroMsg.CompositionSoftwareEncoder", "processImageRGBABufferToWriteRGBAData, width:" + paramInt1 + ", height:" + paramInt2);
        int i = paramPlane.getRowStride();
        int j = paramPlane.getPixelStride();
        if (this.ifH == null) {
          this.ifH = ByteBuffer.allocateDirect(paramInt1 * paramInt2 * j);
        }
        ByteBuffer localByteBuffer = this.ifH;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        paramPlane = paramPlane.getBuffer();
        paramPlane.position(0);
        SightVideoJNI.nativeBufferCopy(paramPlane, this.ifH, paramInt1 * j, paramInt2, i - j * paramInt1);
        SightVideoJNI.writeRGBDataForMMSight(this.bufId, (Buffer)this.ifH, paramInt1, paramInt2, false, false, paramInt1, paramInt2);
        Log.i("MicroMsg.CompositionSoftwareEncoder", "end processImageRGBABufferToWriteRGBAData, cost:" + Util.ticksToNow(l));
        this.GxI += 1;
        AppMethodBeat.o(190519);
        return true;
      }
      AppMethodBeat.o(190519);
      return false;
    }
  }
  
  private final void checkInitBufId()
  {
    AppMethodBeat.i(190521);
    if ((this.bufId < 0) && ((this.muxer instanceof TAVKitMuxer.SightVideoJNIMediaMuxer)))
    {
      Object localObject = this.muxer;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.TAVKitMuxer.SightVideoJNIMediaMuxer");
        AppMethodBeat.o(190521);
        throw ((Throwable)localObject);
      }
      if (((TAVKitMuxer.SightVideoJNIMediaMuxer)localObject).getBufId() >= 0)
      {
        localObject = this.muxer;
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.TAVKitMuxer.SightVideoJNIMediaMuxer");
          AppMethodBeat.o(190521);
          throw ((Throwable)localObject);
        }
        this.bufId = ((TAVKitMuxer.SightVideoJNIMediaMuxer)localObject).getBufId();
        Log.i("MicroMsg.CompositionSoftwareEncoder", "set bufId:" + this.bufId);
      }
    }
    AppMethodBeat.o(190521);
  }
  
  private final void fAR()
  {
    AppMethodBeat.i(190522);
    if (this.ifx == null)
    {
      Log.i("MicroMsg.CompositionSoftwareEncoder", "do start encode loop");
      this.ifx = f.hmn().hms().c((a)new b(this));
      f localf = this.ifx;
      if (localf != null)
      {
        localf.begin();
        AppMethodBeat.o(190522);
        return;
      }
    }
    AppMethodBeat.o(190522);
  }
  
  private final void fAS()
  {
    AppMethodBeat.i(190535);
    this.GxD = true;
    this.bqM = -1L;
    Log.i("MicroMsg.CompositionSoftwareEncoder", "onInputEndOfStream, renderYuvCount:" + this.ifU + ", writeYuvCount:" + this.ifV + ", writeRGBCount:" + this.GxI + ", rgbAvailableCount:" + this.GxJ);
    AppMethodBeat.o(190535);
  }
  
  public final Surface createInputSurface()
  {
    AppMethodBeat.i(190526);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "createInputSurface");
    Object localObject = this.GxE;
    if (localObject != null)
    {
      localObject = ((ImageReader)localObject).getSurface();
      AppMethodBeat.o(190526);
      return localObject;
    }
    AppMethodBeat.o(190526);
    return null;
  }
  
  public final MediaFormat getEncodeFormat()
  {
    AppMethodBeat.i(190523);
    MediaFormat localMediaFormat = this.videoFormat;
    if (localMediaFormat == null) {
      p.hyc();
    }
    AppMethodBeat.o(190523);
    return localMediaFormat;
  }
  
  public final long getEncodePresentationTimeUs()
  {
    return this.bqM;
  }
  
  public final CGSize getEncodeSize()
  {
    AppMethodBeat.i(190530);
    CGSize localCGSize2 = this.videoSize;
    CGSize localCGSize1 = localCGSize2;
    if (localCGSize2 == null)
    {
      localCGSize1 = CGSize.CGSizeZero;
      p.g(localCGSize1, "CGSize.CGSizeZero");
    }
    AppMethodBeat.o(190530);
    return localCGSize1;
  }
  
  public final void inputVideoTexture(TextureInfo arg1)
  {
    AppMethodBeat.i(190533);
    Object localObject1 = this.muxer;
    if ((localObject1 != null) && (((IMediaMuxer)localObject1).isMuxerStarted() == true) && (??? != null))
    {
      Log.i("MicroMsg.CompositionSoftwareEncoder", "input sample buffer render texture:" + ??? + ", sampleTime:" + this.bqM);
      localObject1 = this.ifL;
      if (localObject1 != null) {
        ((com.tencent.mm.media.j.b.h)localObject1).ikZ = ???.textureID;
      }
      localObject1 = this.ifL;
      if (localObject1 != null) {
        ((com.tencent.mm.media.j.b.h)localObject1).cZ(???.width, ???.height);
      }
    }
    if ((!this.ifP) && (this.ifV - this.ifA >= 10))
    {
      Log.i("MicroMsg.CompositionSoftwareEncoder", "writeYuvCount:" + this.ifV + ", curEncodeIndex:" + this.ifA + ", need to wait encode");
      synchronized (this.ifT)
      {
        try
        {
          this.ifT.wait(500L);
          localObject1 = x.SXb;
          AppMethodBeat.o(190533);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.CompositionSoftwareEncoder", (Throwable)localException, "", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(190533);
  }
  
  public final boolean isEncodeToEndOfStream()
  {
    return this.GxD;
  }
  
  public final boolean isNeedVideoOutputTexture()
  {
    return this.GxH;
  }
  
  public final boolean prepare(ExportConfig paramExportConfig, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(190517);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "prepare, outputConfig:" + paramExportConfig + ", videoFormat:" + paramMediaFormat);
    if (paramExportConfig != null)
    {
      this.videoWidth = paramExportConfig.getOutputWidth();
      this.videoHeight = paramExportConfig.getOutputHeight();
      this.videoFps = paramExportConfig.getVideoFrameRate();
      this.videoBitrate = paramExportConfig.getVideoBitRate();
      this.videoSize = new CGSize(this.videoWidth, this.videoHeight);
      this.videoFormat = paramMediaFormat;
      this.GxE = ImageReader.newInstance(this.videoWidth, this.videoHeight, 1, 1);
      if (!this.GxH)
      {
        this.GxG.start();
        this.GxF = new Handler(this.GxG.getLooper());
        paramExportConfig = this.GxE;
        if (paramExportConfig != null) {
          paramExportConfig.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)new d(this), this.GxF);
        }
      }
      AppMethodBeat.o(190517);
      return true;
    }
    AppMethodBeat.o(190517);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(190531);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "release");
    aMi();
    AppMethodBeat.o(190531);
  }
  
  public final void setMediaMuxer(IMediaMuxer paramIMediaMuxer)
  {
    AppMethodBeat.i(190528);
    this.muxer = paramIMediaMuxer;
    Log.i("MicroMsg.CompositionSoftwareEncoder", "setMediaMuxer: ".concat(String.valueOf(paramIMediaMuxer)));
    if ((paramIMediaMuxer instanceof TAVKitMuxer.SightVideoJNIMediaMuxer)) {
      ((TAVKitMuxer.SightVideoJNIMediaMuxer)paramIMediaMuxer).configMuxerToSoftEncode(true);
    }
    AppMethodBeat.o(190528);
  }
  
  public final void setVideoSampleRenderContext(RenderContext paramRenderContext)
  {
    AppMethodBeat.i(190524);
    this.GxC = paramRenderContext;
    if ((this.GxC != null) && (this.GxH) && (this.ifM == null))
    {
      int i = this.videoWidth;
      int j = this.videoHeight;
      this.ifN = (i / 4);
      this.ifO = (j * 3 / 2);
      this.ifI = ImageReader.newInstance(this.ifN, this.ifO, 1, 1);
      paramRenderContext = this.ifI;
      if (paramRenderContext != null)
      {
        this.ifK.start();
        this.ifJ = new Handler(this.ifK.getLooper());
        paramRenderContext.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)new e(this), this.ifJ);
        Handler localHandler = this.ifJ;
        if (localHandler != null) {
          localHandler.post((Runnable)new f(paramRenderContext, this));
        }
      }
      Log.i("MicroMsg.CompositionSoftwareEncoder", "initRgb2YuvImageReader, yuv size:[" + this.ifN + 'x' + this.ifO + ']');
    }
    AppMethodBeat.o(190524);
  }
  
  public final void signalEndOfInputStream()
  {
    AppMethodBeat.i(190525);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "signalEndOfInputStream");
    fAS();
    AppMethodBeat.o(190525);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(190527);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "start");
    this.ifQ = Util.currentTicks();
    AppMethodBeat.o(190527);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(190529);
    Log.i("MicroMsg.CompositionSoftwareEncoder", "stop");
    aMi();
    AppMethodBeat.o(190529);
  }
  
  public final boolean writeVideoSample(CMSampleBuffer paramCMSampleBuffer, boolean paramBoolean)
  {
    AppMethodBeat.i(190534);
    Object localObject;
    if (paramCMSampleBuffer != null)
    {
      localObject = this.muxer;
      if ((localObject == null) || (((IMediaMuxer)localObject).isMuxerStarted() != true)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (paramCMSampleBuffer != null)
      {
        localObject = new StringBuilder("writeVideoSample sampleTimeUs:");
        CMTime localCMTime = paramCMSampleBuffer.getTime();
        p.g(localCMTime, "sampleBuffer.time");
        Log.i("MicroMsg.CompositionSoftwareEncoder", localCMTime.getTimeUs());
        if ((this.ifM != null) && (this.GxH))
        {
          localObject = paramCMSampleBuffer.getTime();
          p.g(localObject, "sampleBuffer.time");
          this.bqM = ((CMTime)localObject).getTimeUs();
          if (this.GxD) {
            this.bqM = -1L;
          }
          if ((this.ifM != null) && (this.GxH))
          {
            final long l = this.bqM;
            localObject = this.ifJ;
            if (localObject != null) {
              ((Handler)localObject).post((Runnable)new g(this, l));
            }
            fAR();
          }
        }
      }
      if (paramBoolean)
      {
        Log.i("MicroMsg.CompositionSoftwareEncoder", "writeVideoSample endOfStream, sampleBuffer:".concat(String.valueOf(paramCMSampleBuffer)));
        fAS();
      }
      AppMethodBeat.o(190534);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/threadpool/internal/Pipeline$NIL;", "kotlin.jvm.PlatformType", "input"})
  static final class b<I, O>
    implements a<E, R>
  {
    b(h paramh) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$finishEncode$1$1$1", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$$special$$inlined$let$lambda$1"})
  static final class c
    implements Runnable
  {
    c(c.b paramb, h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(190512);
      Object localObject = h.l(jdField_this);
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.h)localObject).release();
      }
      localObject = c.ilt;
      c.a.a(this.ifZ);
      AppMethodBeat.o(190512);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$initEncodeSurfaceImageReader$1$1"})
  static final class d
    implements ImageReader.OnImageAvailableListener
  {
    d(h paramh) {}
    
    public final void onImageAvailable(ImageReader paramImageReader)
    {
      int j = 1;
      AppMethodBeat.i(190513);
      Object localObject1 = this.GxL;
      h.a((h)localObject1, h.a((h)localObject1) + 1);
      paramImageReader = paramImageReader.acquireNextImage();
      if (paramImageReader != null) {}
      for (;;)
      {
        int i;
        try
        {
          localObject1 = paramImageReader.getPlanes();
          p.g(localObject1, "image.planes");
          if (localObject1.length == 0)
          {
            i = 1;
            break label474;
            if ((i != 0) && (!h.b(this.GxL)) && (!h.c(this.GxL)))
            {
              localObject1 = new StringBuilder("nextRGBImage, size:[").append(paramImageReader.getWidth()).append('x').append(paramImageReader.getHeight()).append("], format:").append(paramImageReader.getFormat()).append(", planes.size:").append(paramImageReader.getPlanes().length).append(", timestamp:").append(paramImageReader.getTimestamp()).append(", rowStride:");
              Image.Plane localPlane = paramImageReader.getPlanes()[0];
              p.g(localPlane, "image.planes[0]");
              localObject1 = ((StringBuilder)localObject1).append(localPlane.getRowStride()).append(", pixelStride:");
              localPlane = paramImageReader.getPlanes()[0];
              p.g(localPlane, "image.planes[0]");
              localObject1 = ((StringBuilder)localObject1).append(localPlane.getPixelStride()).append(',').append("buffer.capacity:");
              localPlane = paramImageReader.getPlanes()[0];
              p.g(localPlane, "image.planes[0]");
              Log.i("MicroMsg.CompositionSoftwareEncoder", localPlane.getBuffer().capacity());
              localObject1 = this.GxL;
              i = paramImageReader.getWidth();
              j = paramImageReader.getHeight();
              localPlane = paramImageReader.getPlanes()[0];
              p.g(localPlane, "image.planes[0]");
              if (h.a((h)localObject1, i, j, localPlane)) {
                h.e(this.GxL);
              }
              h.a(this.GxL, paramImageReader.getTimestamp() / 1000L);
              if (h.g(this.GxL)) {
                h.a(this.GxL, -1L);
              }
              Log.i("MicroMsg.CompositionSoftwareEncoder", "update sampleTimeUs:" + h.f(this.GxL) + ", isInputEndOfStream:" + h.g(this.GxL));
            }
          }
          else
          {
            i = 0;
            break label474;
            i = 0;
            continue;
          }
          if (!h.b(this.GxL)) {
            continue;
          }
          Log.i("MicroMsg.CompositionSoftwareEncoder", "nextImage but already stop");
          continue;
          AppMethodBeat.o(190513);
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.CompositionSoftwareEncoder", (Throwable)localException, "acquireNextImage error", new Object[0]);
          return;
        }
        finally
        {
          paramImageReader.close();
          AppMethodBeat.o(190513);
        }
        return;
        label474:
        if (i == 0) {
          i = j;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$initRgb2YuvImageReader$1$1"})
  static final class e
    implements ImageReader.OnImageAvailableListener
  {
    e(h paramh) {}
    
    public final void onImageAvailable(ImageReader paramImageReader)
    {
      AppMethodBeat.i(190514);
      paramImageReader = paramImageReader.acquireNextImage();
      if (paramImageReader != null) {
        try
        {
          Object localObject1 = new StringBuilder("nextYUVImage, size:[").append(paramImageReader.getWidth()).append('x').append(paramImageReader.getHeight()).append("], format:").append(paramImageReader.getFormat()).append(", planes.size:").append(paramImageReader.getPlanes().length).append(", timestamp:").append(paramImageReader.getTimestamp()).append(", rowStride:");
          Image.Plane localPlane = paramImageReader.getPlanes()[0];
          p.g(localPlane, "image.planes[0]");
          localObject1 = ((StringBuilder)localObject1).append(localPlane.getRowStride()).append(", pixelStride:");
          localPlane = paramImageReader.getPlanes()[0];
          p.g(localPlane, "image.planes[0]");
          localObject1 = ((StringBuilder)localObject1).append(localPlane.getPixelStride()).append(',').append("buffer.capacity:");
          localPlane = paramImageReader.getPlanes()[0];
          p.g(localPlane, "image.planes[0]");
          Log.i("MicroMsg.CompositionSoftwareEncoder", localPlane.getBuffer().capacity());
          localObject1 = this.GxL;
          int i = paramImageReader.getWidth();
          int j = paramImageReader.getHeight();
          localPlane = paramImageReader.getPlanes()[0];
          p.g(localPlane, "image.planes[0]");
          h.b((h)localObject1, i, j, localPlane);
          localObject1 = this.GxL;
          h.b((h)localObject1, h.h((h)localObject1) + 1);
          if (h.h(this.GxL) % 10 == 0) {
            h.i(this.GxL);
          }
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.CompositionSoftwareEncoder", (Throwable)localException, "acquireNextImage error", new Object[0]);
          return;
        }
        finally
        {
          paramImageReader.close();
          AppMethodBeat.o(190514);
        }
      }
      AppMethodBeat.o(190514);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/model/CompositionSoftwareEncoder$initRgb2YuvImageReader$1$2"})
  static final class f
    implements Runnable
  {
    f(ImageReader paramImageReader, h paramh) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(190515);
      Object localObject1 = this.igf.getSurface();
      p.g(localObject1, "it.surface");
      if (((Surface)localObject1).isValid())
      {
        Object localObject3 = jdField_this;
        Object localObject4 = c.ilt;
        Surface localSurface = this.igf.getSurface();
        localObject1 = h.k(jdField_this);
        if (localObject1 != null) {}
        for (localObject1 = ((RenderContext)localObject1).eglContext();; localObject1 = null)
        {
          h.a((h)localObject3, c.a.a((c.a)localObject4, localSurface, 0, 0, (EGLContext)localObject1, 14));
          h.a(jdField_this, new com.tencent.mm.media.j.b.h(1, 15));
          localObject1 = h.l(jdField_this);
          if (localObject1 != null) {
            ((com.tencent.mm.media.j.b.h)localObject1).cY(h.m(jdField_this), h.n(jdField_this));
          }
          localObject3 = new StringBuilder("create rgb2yuvEGLEnvironment:").append(h.j(jdField_this)).append(", shareEGLContext:");
          localObject4 = h.k(jdField_this);
          localObject1 = localObject2;
          if (localObject4 != null) {
            localObject1 = ((RenderContext)localObject4).eglContext();
          }
          Log.i("MicroMsg.CompositionSoftwareEncoder", localObject1);
          AppMethodBeat.o(190515);
          return;
        }
      }
      Log.e("MicroMsg.CompositionSoftwareEncoder", "create rgb2yuvEGLEnvironment error surface invalid");
      h.d(jdField_this);
      AppMethodBeat.o(190515);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(h paramh, long paramLong) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(190516);
      Log.i("MicroMsg.CompositionSoftwareEncoder", "render gpu rgb2yuv, timestamp:" + l);
      Object localObject1 = h.l(this.GxL);
      if (localObject1 != null) {
        ((com.tencent.mm.media.j.b.h)localObject1).aED();
      }
      localObject1 = h.j(this.GxL);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((c.b)localObject1).ilu;
        localObject2 = h.j(this.GxL);
        if (localObject2 == null) {
          break label170;
        }
        localObject2 = ((c.b)localObject2).eglSurface;
        label81:
        EGLExt.eglPresentationTimeANDROID((EGLDisplay)localObject1, (EGLSurface)localObject2, l * 1000L);
        localObject1 = c.ilt;
        localObject1 = h.j(this.GxL);
        if (localObject1 == null) {
          break label175;
        }
      }
      label170:
      label175:
      for (localObject1 = ((c.b)localObject1).ilu;; localObject1 = null)
      {
        c.b localb = h.j(this.GxL);
        localObject2 = localObject3;
        if (localb != null) {
          localObject2 = localb.eglSurface;
        }
        c.a.a((EGLDisplay)localObject1, (EGLSurface)localObject2);
        localObject1 = this.GxL;
        h.c((h)localObject1, h.o((h)localObject1) + 1);
        AppMethodBeat.o(190516);
        return;
        localObject1 = null;
        break;
        localObject2 = null;
        break label81;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.h
 * JD-Core Version:    0.7.0.1
 */