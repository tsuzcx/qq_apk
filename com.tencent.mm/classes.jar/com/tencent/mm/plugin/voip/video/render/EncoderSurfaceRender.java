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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import d.z;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "", "()V", "callbackBufferMap", "Ljava/util/HashMap;", "", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/nio/ByteBuffer;", "Lkotlin/collections/HashMap;", "dataCallback", "Lkotlin/Function4;", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "handler", "Landroid/os/Handler;", "handlerT", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "value", "height", "setHeight", "(I)V", "imgReader", "Landroid/media/ImageReader;", "outWH", "Lkotlin/Pair;", "renderInfoQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$RenderInfo;", "sharedContext", "Landroid/opengl/EGLContext;", "texture", "useGpuCrop", "", "width", "setWidth", "yuvCropEncodeProg", "Lcom/tencent/mm/plugin/voip/video/programv2/RGB2YUVCropRenderProc;", "yuvEncodeProg", "Lcom/tencent/mm/plugin/voip/video/programv2/RGB2YUVRenderProc;", "yuvHeight", "yuvWidth", "cacheCallbackBuffer", "size", "cpBuffer", "buffer", "byteArray", "", "padding", "nativeBufferCopy", "src", "dst", "post", "task", "Lkotlin/Function0;", "release", "requestRender", "setDataCallBack", "setInputTexture", "setRotate", "rotate", "setUpImageReader", "updateSize", "Companion", "RenderInfo", "plugin-voip_release"})
public final class EncoderSurfaceRender
{
  public static final EncoderSurfaceRender.a CIS;
  public int BZy;
  private final HandlerThread CIL;
  private ImageReader CIM;
  public r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, z> CIN;
  private b CIO;
  private com.tencent.mm.plugin.voip.video.c.a CIP;
  private final ConcurrentLinkedQueue<EncoderSurfaceRender.b> CIQ;
  private o<Integer, Integer> CIR;
  private final boolean CzL;
  private final HashMap<Integer, LinkedBlockingQueue<ByteBuffer>> JhQ;
  private c.b gNx;
  private final Handler handler;
  private int height;
  private final EGLContext sharedContext;
  private int waN;
  private int waO;
  private int width;
  
  static
  {
    AppMethodBeat.i(210516);
    CIS = new EncoderSurfaceRender.a((byte)0);
    AppMethodBeat.o(210516);
  }
  
  public EncoderSurfaceRender()
  {
    AppMethodBeat.i(210515);
    this.CIL = d.hf("voip_rgb2yuv_thread", -4);
    Object localObject = h.CCW;
    this.CzL = h.eDp();
    this.sharedContext = EGL14.eglGetCurrentContext();
    this.CIQ = new ConcurrentLinkedQueue();
    this.JhQ = new HashMap();
    this.CIR = new o(Integer.valueOf(0), Integer.valueOf(0));
    this.BZy = -1;
    if (this.CzL) {
      this.CIP = new com.tencent.mm.plugin.voip.video.c.a(1, 15);
    }
    for (;;)
    {
      this.CIL.start();
      localObject = this.CIL;
      p.g(localObject, "handlerT");
      this.handler = new Handler(((HandlerThread)localObject).getLooper());
      AppMethodBeat.o(210515);
      return;
      this.CIO = new b(1, 15);
    }
  }
  
  private final void B(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(210510);
    this.handler.post((Runnable)new a(parama));
    AppMethodBeat.o(210510);
  }
  
  private final void eEI()
  {
    AppMethodBeat.i(210511);
    B((d.g.a.a)new d(this));
    AppMethodBeat.o(210511);
  }
  
  private final native void nativeBufferCopy(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int paramInt1, int paramInt2, int paramInt3);
  
  private final void setHeight(int paramInt)
  {
    this.height = paramInt;
    this.waO = (this.height / 4);
  }
  
  private final void setWidth(int paramInt)
  {
    this.width = paramInt;
    this.waN = (this.width * 3 / 2);
  }
  
  public final void iE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210512);
    if ((this.width == paramInt1) && (this.height == paramInt2))
    {
      AppMethodBeat.o(210512);
      return;
    }
    setWidth(paramInt1);
    setHeight(paramInt2);
    eEI();
    AppMethodBeat.o(210512);
  }
  
  public final void release()
  {
    AppMethodBeat.i(210514);
    Object localObject = this.gNx;
    if (localObject != null)
    {
      c.a locala = c.hrD;
      c.a.a((c.b)localObject);
    }
    localObject = this.CIM;
    if (localObject != null) {
      ((ImageReader)localObject).close();
    }
    this.CIQ.clear();
    this.gNx = null;
    this.CIL.quitSafely();
    localObject = this.CIO;
    if (localObject != null) {
      ((b)localObject).release();
    }
    localObject = this.CIP;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.video.c.a)localObject).release();
    }
    this.CIM = null;
    this.JhQ.clear();
    this.CIN = null;
    AppMethodBeat.o(210514);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(210513);
    B((d.g.a.a)new c(this));
    AppMethodBeat.o(210513);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(EncoderSurfaceRender paramEncoderSurfaceRender)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(EncoderSurfaceRender paramEncoderSurfaceRender)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable", "com/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$setUpImageReader$1$2$1"})
    static final class a
      implements ImageReader.OnImageAvailableListener
    {
      a(EncoderSurfaceRender.d paramd) {}
      
      public final void onImageAvailable(ImageReader paramImageReader)
      {
        AppMethodBeat.i(210508);
        Image localImage = paramImageReader.acquireNextImage();
        if (localImage != null) {
          try
          {
            Object localObject2 = localImage.getPlanes()[0];
            EncoderSurfaceRender.e(this.CIX.CIW);
            paramImageReader = (EncoderSurfaceRender.b)EncoderSurfaceRender.e(this.CIX.CIW).remove();
            while (localImage.getTimestamp() > paramImageReader.CIV)
            {
              paramImageReader = (EncoderSurfaceRender.b)EncoderSurfaceRender.e(this.CIX.CIW).remove();
              ae.i("EncoderSurfaceRender", "drop render info pts: " + localImage.getTimestamp());
            }
            ae.i("EncoderSurfaceRender", "get render info pts: " + localImage.getTimestamp());
            int j = paramImageReader.CIT * paramImageReader.CIU * 3 / 2;
            EncoderSurfaceRender.a(this.CIX.CIW, j);
            Object localObject1 = (LinkedBlockingQueue)EncoderSurfaceRender.f(this.CIX.CIW).get(Integer.valueOf(j));
            int i;
            if (localObject1 != null)
            {
              localObject1 = (ByteBuffer)((LinkedBlockingQueue)localObject1).remove();
              EncoderSurfaceRender.a(this.CIX.CIW, new o(Integer.valueOf(paramImageReader.CIT), Integer.valueOf(paramImageReader.CIU)));
              if (localObject1 != null)
              {
                EncoderSurfaceRender localEncoderSurfaceRender = this.CIX.CIW;
                p.g(localObject2, "plan");
                ByteBuffer localByteBuffer = ((Image.Plane)localObject2).getBuffer();
                p.g(localByteBuffer, "plan.buffer");
                EncoderSurfaceRender.a(localEncoderSurfaceRender, localByteBuffer, (ByteBuffer)localObject1, paramImageReader.CIU, paramImageReader.CIT * 3 / 2, ((Image.Plane)localObject2).getRowStride() - paramImageReader.CIU);
                localObject2 = EncoderSurfaceRender.h(this.CIX.CIW);
                if (localObject2 != null) {
                  ((r)localObject2).a(localObject1, Integer.valueOf(paramImageReader.CIU), Integer.valueOf(paramImageReader.CIT), Integer.valueOf(paramImageReader.dataType));
                }
                paramImageReader = i.CJN;
                i.aJ(4, bu.aO(localImage.getTimestamp()));
                paramImageReader = (LinkedBlockingQueue)EncoderSurfaceRender.f(this.CIX.CIW).get(Integer.valueOf(j));
                if (paramImageReader == null) {
                  break label505;
                }
                i = paramImageReader.size();
                label389:
                if (i < 2)
                {
                  paramImageReader = (LinkedBlockingQueue)EncoderSurfaceRender.f(this.CIX.CIW).get(Integer.valueOf(j));
                  if (paramImageReader != null) {
                    paramImageReader.add(localObject1);
                  }
                }
                localObject1 = new StringBuilder("callback buffer, queue size:");
                paramImageReader = (LinkedBlockingQueue)EncoderSurfaceRender.f(this.CIX.CIW).get(Integer.valueOf(j));
                if (paramImageReader == null) {
                  break label510;
                }
              }
            }
            label505:
            label510:
            for (paramImageReader = Integer.valueOf(paramImageReader.size());; paramImageReader = null)
            {
              ae.d("EncoderSurfaceRender", paramImageReader);
              paramImageReader = z.Nhr;
              return;
              localObject1 = null;
              break;
              i = 0;
              break label389;
            }
            AppMethodBeat.o(210508);
          }
          catch (NoSuchElementException paramImageReader)
          {
            ae.e("EncoderSurfaceRender", paramImageReader.getMessage());
            paramImageReader = z.Nhr;
            return;
          }
          catch (IllegalStateException paramImageReader)
          {
            ae.e("EncoderSurfaceRender", paramImageReader.getMessage());
            paramImageReader = z.Nhr;
            return;
          }
          finally
          {
            localImage.close();
            AppMethodBeat.o(210508);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.EncoderSurfaceRender
 * JD-Core Version:    0.7.0.1
 */