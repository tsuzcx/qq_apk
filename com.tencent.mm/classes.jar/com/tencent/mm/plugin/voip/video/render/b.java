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
import com.tencent.mm.media.j.b.i;
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
import kotlin.g.a.a;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "", "()V", "callbackBufferMap", "Ljava/util/HashMap;", "", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/nio/ByteBuffer;", "Lkotlin/collections/HashMap;", "dataCallback", "Lkotlin/Function4;", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "encHeight", "encType", "encWidth", "handler", "Landroid/os/Handler;", "handlerT", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "value", "height", "setHeight", "(I)V", "imgReader", "Landroid/media/ImageReader;", "outWH", "Lkotlin/Pair;", "renderInfoQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$RenderInfo;", "sharedContext", "Landroid/opengl/EGLContext;", "texture", "useGpuCrop", "", "width", "setWidth", "yuvCropEncodeProg", "Lcom/tencent/mm/media/render/proc/RGB2YUVCropRenderProc;", "yuvEncodeProg", "Lcom/tencent/mm/media/render/proc/RGB2YUVRenderProc;", "yuvHeight", "yuvWidth", "cacheCallbackBuffer", "size", "cpBuffer", "buffer", "byteArray", "", "padding", "post", "task", "Lkotlin/Function0;", "release", "requestRender", "setDataCallBack", "setInputTexture", "setRotate", "rotate", "setUpImageReader", "updateEncodeResType", "encoderType", "updateSize", "Companion", "RenderInfo", "plugin-voip_release"})
public final class b
{
  public static final a OdU;
  private final boolean NUs;
  public int NkK;
  private final HandlerThread OdK;
  private ImageReader OdL;
  public r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> OdM;
  private i OdN;
  private com.tencent.mm.media.j.b.g OdO;
  private final ConcurrentLinkedQueue<b> OdP;
  private final HashMap<Integer, LinkedBlockingQueue<ByteBuffer>> OdQ;
  private o<Integer, Integer> OdR;
  private int OdS;
  private int OdT;
  private final Handler handler;
  private int height;
  private int kUB;
  private int kUC;
  private c.b krl;
  private int nIP;
  private final EGLContext sharedContext;
  private int width;
  
  static
  {
    AppMethodBeat.i(235730);
    OdU = new a((byte)0);
    AppMethodBeat.o(235730);
  }
  
  public b()
  {
    AppMethodBeat.i(235728);
    this.OdK = d.ij("voip_rgb2yuv_thread", -4);
    Object localObject = com.tencent.mm.plugin.voip.c.g.NXO;
    this.NUs = com.tencent.mm.plugin.voip.c.g.gCI();
    this.sharedContext = EGL14.eglGetCurrentContext();
    this.OdP = new ConcurrentLinkedQueue();
    this.OdQ = new HashMap();
    this.OdR = new o(Integer.valueOf(0), Integer.valueOf(0));
    this.NkK = -1;
    if (this.NUs) {
      this.OdO = new com.tencent.mm.media.j.b.g(1, 15);
    }
    for (;;)
    {
      this.OdK.start();
      localObject = this.OdK;
      p.j(localObject, "handlerT");
      this.handler = new Handler(((HandlerThread)localObject).getLooper());
      AppMethodBeat.o(235728);
      return;
      this.OdN = new i(1, 15);
    }
  }
  
  private final void X(a<x> parama)
  {
    AppMethodBeat.i(235726);
    this.handler.post((Runnable)new c(parama));
    AppMethodBeat.o(235726);
  }
  
  private final void gTf()
  {
    AppMethodBeat.i(293142);
    X((a)new d(this));
    AppMethodBeat.o(293142);
  }
  
  private final void setHeight(int paramInt)
  {
    this.height = paramInt;
    this.kUB = (this.height / 4);
  }
  
  private final void setWidth(int paramInt)
  {
    this.width = paramInt;
    this.kUC = (this.width * 3 / 2);
  }
  
  public final void aJ(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.NUs)
    {
      this.OdS = paramInt1;
      this.OdT = paramInt2;
      this.nIP = paramInt3;
    }
  }
  
  public final void ku(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293143);
    if ((this.width == paramInt1) && (this.height == paramInt2))
    {
      AppMethodBeat.o(293143);
      return;
    }
    setWidth(paramInt1);
    setHeight(paramInt2);
    gTf();
    AppMethodBeat.o(293143);
  }
  
  public final void release()
  {
    AppMethodBeat.i(293145);
    Object localObject = this.krl;
    if (localObject != null)
    {
      c.a locala = com.tencent.mm.media.k.c.lar;
      c.a.a((c.b)localObject);
    }
    localObject = this.OdL;
    if (localObject != null) {
      ((ImageReader)localObject).close();
    }
    this.OdP.clear();
    this.krl = null;
    this.OdK.quitSafely();
    localObject = this.OdN;
    if (localObject != null) {
      ((i)localObject).release();
    }
    localObject = this.OdO;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.g)localObject).release();
    }
    this.OdL = null;
    this.OdQ.clear();
    this.OdM = null;
    AppMethodBeat.o(293145);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(293144);
    X((a)new c(this));
    AppMethodBeat.o(293144);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$Companion;", "", "()V", "CallbackBufferMaxCacheSize", "", "TAG", "", "plugin-voip_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$RenderInfo;", "", "outW", "", "outH", "dataType", "presentationTime", "", "(IIIJ)V", "getDataType", "()I", "getOutH", "getOutW", "getPresentationTime", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-voip_release"})
  public static final class b
  {
    final int OdV;
    final int OdW;
    final long OdX;
    final int dataType;
    
    public b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      this.OdV = paramInt1;
      this.OdW = paramInt2;
      this.dataType = paramInt3;
      this.OdX = paramLong;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.OdV != paramObject.OdV) || (this.OdW != paramObject.OdW) || (this.dataType != paramObject.dataType) || (this.OdX != paramObject.OdX)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      int i = this.OdV;
      int j = this.OdW;
      int k = this.dataType;
      long l = this.OdX;
      return ((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(241769);
      String str = "RenderInfo(outW=" + this.OdV + ", outH=" + this.OdW + ", dataType=" + this.dataType + ", presentationTime=" + this.OdX + ")";
      AppMethodBeat.o(241769);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(b paramb)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable", "com/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$setUpImageReader$1$2$1"})
    static final class a
      implements ImageReader.OnImageAvailableListener
    {
      a(b.d paramd) {}
      
      public final void onImageAvailable(ImageReader paramImageReader)
      {
        AppMethodBeat.i(238314);
        Image localImage = paramImageReader.acquireLatestImage();
        if (localImage != null) {
          try
          {
            Object localObject2 = localImage.getPlanes()[0];
            b.e(this.OdZ.OdY);
            paramImageReader = (b.b)b.e(this.OdZ.OdY).remove();
            while (localImage.getTimestamp() > paramImageReader.OdX)
            {
              paramImageReader = (b.b)b.e(this.OdZ.OdY).remove();
              Log.i("EncoderSurfaceRender", "drop render info pts: " + localImage.getTimestamp());
            }
            Log.i("EncoderSurfaceRender", "get render info pts: " + localImage.getTimestamp());
            int j = paramImageReader.OdV * paramImageReader.OdW * 3 / 2;
            b.a(this.OdZ.OdY, j);
            Object localObject1 = (LinkedBlockingQueue)b.f(this.OdZ.OdY).get(Integer.valueOf(j));
            int i;
            if (localObject1 != null)
            {
              localObject1 = (ByteBuffer)((LinkedBlockingQueue)localObject1).remove();
              b.a(this.OdZ.OdY, new o(Integer.valueOf(paramImageReader.OdV), Integer.valueOf(paramImageReader.OdW)));
              if (localObject1 != null)
              {
                p.j(localObject2, "plan");
                SightVideoJNI.nativeBufferCopy(((Image.Plane)localObject2).getBuffer(), (ByteBuffer)localObject1, paramImageReader.OdW, paramImageReader.OdV * 3 / 2, ((Image.Plane)localObject2).getRowStride() - paramImageReader.OdW);
                localObject2 = b.g(this.OdZ.OdY);
                if (localObject2 != null) {
                  ((r)localObject2).a(localObject1, Integer.valueOf(paramImageReader.OdW), Integer.valueOf(paramImageReader.OdV), Integer.valueOf(paramImageReader.dataType));
                }
                paramImageReader = j.OeL;
                j.ba(4, Util.ticksToNow(localImage.getTimestamp()));
                paramImageReader = (LinkedBlockingQueue)b.f(this.OdZ.OdY).get(Integer.valueOf(j));
                if (paramImageReader == null) {
                  break label483;
                }
                i = paramImageReader.size();
                label367:
                if (i < 2)
                {
                  paramImageReader = (LinkedBlockingQueue)b.f(this.OdZ.OdY).get(Integer.valueOf(j));
                  if (paramImageReader != null) {
                    paramImageReader.add(localObject1);
                  }
                }
                localObject1 = new StringBuilder("callback buffer, queue size:");
                paramImageReader = (LinkedBlockingQueue)b.f(this.OdZ.OdY).get(Integer.valueOf(j));
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
              paramImageReader = x.aazN;
              return;
              localObject1 = null;
              break;
              i = 0;
              break label367;
            }
            AppMethodBeat.o(238314);
          }
          catch (NoSuchElementException paramImageReader)
          {
            Log.e("EncoderSurfaceRender", paramImageReader.getMessage());
            paramImageReader = x.aazN;
            return;
          }
          catch (IllegalStateException paramImageReader)
          {
            Log.e("EncoderSurfaceRender", paramImageReader.getMessage());
            paramImageReader = x.aazN;
            return;
          }
          finally
          {
            localImage.close();
            AppMethodBeat.o(238314);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.b
 * JD-Core Version:    0.7.0.1
 */