package com.tencent.mm.plugin.voip.video.render;

import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.voip.b.h;
import com.tencent.mm.plugin.voip.video.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import d.z;
import java.nio.ByteBuffer;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "", "()V", "buffer", "Ljava/nio/ByteBuffer;", "dataCallback", "Lkotlin/Function4;", "", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "handler", "Landroid/os/Handler;", "handlerT", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "value", "height", "setHeight", "(I)V", "imgReader", "Landroid/media/ImageReader;", "outWH", "Lkotlin/Pair;", "renderInfoQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$RenderInfo;", "sharedContext", "Landroid/opengl/EGLContext;", "texture", "useGpuCrop", "", "width", "setWidth", "yuvCropEncodeProg", "Lcom/tencent/mm/plugin/voip/video/programv2/RGB2YUVCropRenderProc;", "yuvEncodeProg", "Lcom/tencent/mm/plugin/voip/video/programv2/RGB2YUVRenderProc;", "yuvHeight", "yuvWidth", "cpBuffer", "byteArray", "", "padding", "nativeBufferCopy", "src", "dst", "post", "task", "Lkotlin/Function0;", "release", "requestRender", "setDataCallBack", "setInputTexture", "setRotate", "rotate", "setUpImageReader", "updateSize", "Companion", "RenderInfo", "plugin-voip_release"})
public final class EncoderSurfaceRender
{
  public static final EncoderSurfaceRender.a Cro;
  public int BHZ;
  private final boolean Cli;
  private final HandlerThread Crh;
  private ImageReader Cri;
  public r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, z> Crj;
  private b Crk;
  private com.tencent.mm.plugin.voip.video.c.a Crl;
  private final ConcurrentLinkedQueue<EncoderSurfaceRender.b> Crm;
  private o<Integer, Integer> Crn;
  private ByteBuffer buffer;
  private c.b gKO;
  private final Handler handler;
  private int height;
  private final EGLContext sharedContext;
  private int vOK;
  private int vOL;
  private int width;
  
  static
  {
    AppMethodBeat.i(216095);
    Cro = new EncoderSurfaceRender.a((byte)0);
    AppMethodBeat.o(216095);
  }
  
  public EncoderSurfaceRender()
  {
    AppMethodBeat.i(216094);
    this.Crh = d.gW("voip_rgb2yuv_thread", -4);
    Object localObject = h.Cls;
    this.Cli = h.ezH();
    this.sharedContext = EGL14.eglGetCurrentContext();
    this.Crm = new ConcurrentLinkedQueue();
    this.Crn = new o(Integer.valueOf(0), Integer.valueOf(0));
    this.BHZ = -1;
    if (this.Cli) {
      this.Crl = new com.tencent.mm.plugin.voip.video.c.a(1, 15);
    }
    for (;;)
    {
      this.Crh.start();
      localObject = this.Crh;
      p.g(localObject, "handlerT");
      this.handler = new Handler(((HandlerThread)localObject).getLooper());
      AppMethodBeat.o(216094);
      return;
      this.Crk = new b(1, 15);
    }
  }
  
  private final void B(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(216089);
    this.handler.post((Runnable)new a(parama));
    AppMethodBeat.o(216089);
  }
  
  private final void eBa()
  {
    AppMethodBeat.i(216090);
    B((d.g.a.a)new d(this));
    AppMethodBeat.o(216090);
  }
  
  private final native void nativeBufferCopy(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int paramInt1, int paramInt2, int paramInt3);
  
  private final void setHeight(int paramInt)
  {
    this.height = paramInt;
    this.vOL = (this.height / 4);
  }
  
  private final void setWidth(int paramInt)
  {
    this.width = paramInt;
    this.vOK = (this.width * 3 / 2);
  }
  
  public final void iA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216091);
    if ((this.width == paramInt1) && (this.height == paramInt2))
    {
      AppMethodBeat.o(216091);
      return;
    }
    setWidth(paramInt1);
    setHeight(paramInt2);
    eBa();
    AppMethodBeat.o(216091);
  }
  
  public final void release()
  {
    AppMethodBeat.i(216093);
    Object localObject = this.gKO;
    if (localObject != null)
    {
      c.a locala = c.hoP;
      c.a.a((c.b)localObject);
    }
    localObject = this.Cri;
    if (localObject != null) {
      ((ImageReader)localObject).close();
    }
    this.Crm.clear();
    this.gKO = null;
    this.Crh.quitSafely();
    localObject = this.Crk;
    if (localObject != null) {
      ((b)localObject).release();
    }
    localObject = this.Crl;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.video.c.a)localObject).release();
    }
    this.Cri = null;
    this.buffer = null;
    this.Crj = null;
    AppMethodBeat.o(216093);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(216092);
    B((d.g.a.a)new c(this));
    AppMethodBeat.o(216092);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(EncoderSurfaceRender paramEncoderSurfaceRender)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(EncoderSurfaceRender paramEncoderSurfaceRender)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable", "com/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$setUpImageReader$1$2$1"})
    static final class a
      implements ImageReader.OnImageAvailableListener
    {
      a(EncoderSurfaceRender.d paramd) {}
      
      public final void onImageAvailable(ImageReader paramImageReader)
      {
        AppMethodBeat.i(216087);
        Image localImage = paramImageReader.acquireNextImage();
        if (localImage != null) {
          try
          {
            Object localObject = localImage.getPlanes()[0];
            EncoderSurfaceRender.e(this.Crt.Crs);
            paramImageReader = (EncoderSurfaceRender.b)EncoderSurfaceRender.e(this.Crt.Crs).remove();
            while (localImage.getTimestamp() > paramImageReader.Crr)
            {
              paramImageReader = (EncoderSurfaceRender.b)EncoderSurfaceRender.e(this.Crt.Crs).remove();
              ad.i("EncoderSurfaceRender", "drop render info pts: " + localImage.getTimestamp());
            }
            ad.i("EncoderSurfaceRender", "get render info pts: " + localImage.getTimestamp());
            if ((EncoderSurfaceRender.f(this.Crt.Crs) == null) || (paramImageReader.Crp != ((Number)EncoderSurfaceRender.g(this.Crt.Crs).first).intValue()) || (paramImageReader.Crq != ((Number)EncoderSurfaceRender.g(this.Crt.Crs).second).intValue()))
            {
              EncoderSurfaceRender.a(this.Crt.Crs, ByteBuffer.allocateDirect(paramImageReader.Crp * paramImageReader.Crq * 3 / 2));
              EncoderSurfaceRender.a(this.Crt.Crs, new o(Integer.valueOf(paramImageReader.Crp), Integer.valueOf(paramImageReader.Crq)));
            }
            ByteBuffer localByteBuffer1 = EncoderSurfaceRender.f(this.Crt.Crs);
            if (localByteBuffer1 != null)
            {
              EncoderSurfaceRender localEncoderSurfaceRender = this.Crt.Crs;
              p.g(localObject, "plan");
              ByteBuffer localByteBuffer2 = ((Image.Plane)localObject).getBuffer();
              p.g(localByteBuffer2, "plan.buffer");
              EncoderSurfaceRender.a(localEncoderSurfaceRender, localByteBuffer2, localByteBuffer1, paramImageReader.Crq, paramImageReader.Crp * 3 / 2, ((Image.Plane)localObject).getRowStride() - paramImageReader.Crq);
              localObject = EncoderSurfaceRender.h(this.Crt.Crs);
              if (localObject != null) {
                ((r)localObject).a(localByteBuffer1, Integer.valueOf(paramImageReader.Crq), Integer.valueOf(paramImageReader.Crp), Integer.valueOf(paramImageReader.dataType));
              }
              paramImageReader = i.Csj;
              i.aJ(4, bt.aO(localImage.getTimestamp()));
              paramImageReader = z.MKo;
            }
            return;
          }
          catch (NoSuchElementException paramImageReader)
          {
            ad.e("EncoderSurfaceRender", paramImageReader.getMessage());
            paramImageReader = z.MKo;
            return;
          }
          catch (IllegalStateException paramImageReader)
          {
            ad.e("EncoderSurfaceRender", paramImageReader.getMessage());
            paramImageReader = z.MKo;
            return;
          }
          finally
          {
            localImage.close();
            AppMethodBeat.o(216087);
          }
        }
        AppMethodBeat.o(216087);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.EncoderSurfaceRender
 * JD-Core Version:    0.7.0.1
 */