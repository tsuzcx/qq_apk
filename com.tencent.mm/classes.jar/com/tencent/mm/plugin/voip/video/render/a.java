package com.tencent.mm.plugin.voip.video.render;

import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "", "()V", "callbackBufferMap", "Ljava/util/HashMap;", "", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/nio/ByteBuffer;", "Lkotlin/collections/HashMap;", "dataCallback", "Lkotlin/Function4;", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "encHeight", "encType", "encWidth", "handler", "Landroid/os/Handler;", "handlerT", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "value", "height", "setHeight", "(I)V", "imgReader", "Landroid/media/ImageReader;", "outWH", "Lkotlin/Pair;", "renderInfoQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$RenderInfo;", "sharedContext", "Landroid/opengl/EGLContext;", "texture", "useGpuCrop", "", "width", "setWidth", "yuvCropEncodeProg", "Lcom/tencent/mm/media/render/proc/RGB2YUVCropRenderProc;", "yuvEncodeProg", "Lcom/tencent/mm/media/render/proc/RGB2YUVRenderProc;", "yuvHeight", "yuvWidth", "cacheCallbackBuffer", "size", "cpBuffer", "buffer", "byteArray", "", "padding", "post", "task", "Lkotlin/Function0;", "release", "requestRender", "setDataCallBack", "setInputTexture", "setRotate", "rotate", "setUpImageReader", "updateEncodeResType", "encoderType", "updateSize", "Companion", "RenderInfo", "plugin-voip_release"})
public final class a
{
  public static final a.a HmW;
  public int Gxi;
  private final boolean HdC;
  private final HandlerThread HmM;
  private ImageReader HmN;
  public r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> HmO;
  private com.tencent.mm.media.j.b.i HmP;
  private com.tencent.mm.media.j.b.g HmQ;
  private final ConcurrentLinkedQueue<a.b> HmR;
  private final HashMap<Integer, LinkedBlockingQueue<ByteBuffer>> HmS;
  private o<Integer, Integer> HmT;
  private int HmU;
  private int HmV;
  private c.b hDs;
  private final Handler handler;
  private int height;
  private int ifN;
  private int ifO;
  private int kOM;
  private final EGLContext sharedContext;
  private int width;
  
  static
  {
    AppMethodBeat.i(236197);
    HmW = new a.a((byte)0);
    AppMethodBeat.o(236197);
  }
  
  public a()
  {
    AppMethodBeat.i(236196);
    this.HmM = d.hz("voip_rgb2yuv_thread", -4);
    Object localObject = com.tencent.mm.plugin.voip.b.g.HgZ;
    this.HdC = com.tencent.mm.plugin.voip.b.g.fKj();
    this.sharedContext = EGL14.eglGetCurrentContext();
    this.HmR = new ConcurrentLinkedQueue();
    this.HmS = new HashMap();
    this.HmT = new o(Integer.valueOf(0), Integer.valueOf(0));
    this.Gxi = -1;
    if (this.HdC) {
      this.HmQ = new com.tencent.mm.media.j.b.g(1, 15);
    }
    for (;;)
    {
      this.HmM.start();
      localObject = this.HmM;
      p.g(localObject, "handlerT");
      this.handler = new Handler(((HandlerThread)localObject).getLooper());
      AppMethodBeat.o(236196);
      return;
      this.HmP = new com.tencent.mm.media.j.b.i(1, 15);
    }
  }
  
  private final void U(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(236191);
    this.handler.post((Runnable)new b(parama));
    AppMethodBeat.o(236191);
  }
  
  private final void fLP()
  {
    AppMethodBeat.i(236192);
    U((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(236192);
  }
  
  private final void setHeight(int paramInt)
  {
    this.height = paramInt;
    this.ifN = (this.height / 4);
  }
  
  private final void setWidth(int paramInt)
  {
    this.width = paramInt;
    this.ifO = (this.width * 3 / 2);
  }
  
  public final void aF(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.HdC)
    {
      this.HmU = paramInt1;
      this.HmV = paramInt2;
      this.kOM = paramInt3;
    }
  }
  
  public final void jj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236193);
    if ((this.width == paramInt1) && (this.height == paramInt2))
    {
      AppMethodBeat.o(236193);
      return;
    }
    setWidth(paramInt1);
    setHeight(paramInt2);
    fLP();
    AppMethodBeat.o(236193);
  }
  
  public final void release()
  {
    AppMethodBeat.i(236195);
    Object localObject = this.hDs;
    if (localObject != null)
    {
      c.a locala = c.ilt;
      c.a.a((c.b)localObject);
    }
    localObject = this.HmN;
    if (localObject != null) {
      ((ImageReader)localObject).close();
    }
    this.HmR.clear();
    this.hDs = null;
    this.HmM.quitSafely();
    localObject = this.HmP;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.i)localObject).release();
    }
    localObject = this.HmQ;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.g)localObject).release();
    }
    this.HmN = null;
    this.HmS.clear();
    this.HmO = null;
    AppMethodBeat.o(236195);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(236194);
    U((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(236194);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(a parama)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable", "com/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$setUpImageReader$1$2$1"})
    static final class a
      implements ImageReader.OnImageAvailableListener
    {
      a(a.d paramd) {}
      
      public final void onImageAvailable(ImageReader paramImageReader)
      {
        AppMethodBeat.i(236189);
        Image localImage = paramImageReader.acquireLatestImage();
        if (localImage != null) {
          try
          {
            Object localObject2 = localImage.getPlanes()[0];
            a.e(this.Hnb.Hna);
            paramImageReader = (a.b)a.e(this.Hnb.Hna).remove();
            while (localImage.getTimestamp() > paramImageReader.HmZ)
            {
              paramImageReader = (a.b)a.e(this.Hnb.Hna).remove();
              Log.i("EncoderSurfaceRender", "drop render info pts: " + localImage.getTimestamp());
            }
            Log.i("EncoderSurfaceRender", "get render info pts: " + localImage.getTimestamp());
            int j = paramImageReader.HmX * paramImageReader.HmY * 3 / 2;
            a.a(this.Hnb.Hna, j);
            Object localObject1 = (LinkedBlockingQueue)a.f(this.Hnb.Hna).get(Integer.valueOf(j));
            int i;
            if (localObject1 != null)
            {
              localObject1 = (ByteBuffer)((LinkedBlockingQueue)localObject1).remove();
              a.a(this.Hnb.Hna, new o(Integer.valueOf(paramImageReader.HmX), Integer.valueOf(paramImageReader.HmY)));
              if (localObject1 != null)
              {
                p.g(localObject2, "plan");
                SightVideoJNI.nativeBufferCopy(((Image.Plane)localObject2).getBuffer(), (ByteBuffer)localObject1, paramImageReader.HmY, paramImageReader.HmX * 3 / 2, ((Image.Plane)localObject2).getRowStride() - paramImageReader.HmY);
                localObject2 = a.g(this.Hnb.Hna);
                if (localObject2 != null) {
                  ((r)localObject2).invoke(localObject1, Integer.valueOf(paramImageReader.HmY), Integer.valueOf(paramImageReader.HmX), Integer.valueOf(paramImageReader.dataType));
                }
                paramImageReader = i.HnR;
                i.aO(4, Util.ticksToNow(localImage.getTimestamp()));
                paramImageReader = (LinkedBlockingQueue)a.f(this.Hnb.Hna).get(Integer.valueOf(j));
                if (paramImageReader == null) {
                  break label483;
                }
                i = paramImageReader.size();
                label367:
                if (i < 2)
                {
                  paramImageReader = (LinkedBlockingQueue)a.f(this.Hnb.Hna).get(Integer.valueOf(j));
                  if (paramImageReader != null) {
                    paramImageReader.add(localObject1);
                  }
                }
                localObject1 = new StringBuilder("callback buffer, queue size:");
                paramImageReader = (LinkedBlockingQueue)a.f(this.Hnb.Hna).get(Integer.valueOf(j));
                if (paramImageReader == null) {
                  break label488;
                }
              }
            }
            label483:
            label488:
            for (paramImageReader = Integer.valueOf(paramImageReader.size());; paramImageReader = null)
            {
              Log.d("EncoderSurfaceRender", paramImageReader);
              paramImageReader = x.SXb;
              return;
              localObject1 = null;
              break;
              i = 0;
              break label367;
            }
            AppMethodBeat.o(236189);
          }
          catch (NoSuchElementException paramImageReader)
          {
            Log.e("EncoderSurfaceRender", paramImageReader.getMessage());
            paramImageReader = x.SXb;
            return;
          }
          catch (IllegalStateException paramImageReader)
          {
            Log.e("EncoderSurfaceRender", paramImageReader.getMessage());
            paramImageReader = x.SXb;
            return;
          }
          finally
          {
            localImage.close();
            AppMethodBeat.o(236189);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.a
 * JD-Core Version:    0.7.0.1
 */