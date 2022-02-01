package com.tencent.mm.plugin.voip.video.render;

import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.voip.f.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.c.d;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "", "()V", "callbackBufferMap", "Ljava/util/HashMap;", "", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/nio/ByteBuffer;", "Lkotlin/collections/HashMap;", "dataCallback", "Lkotlin/Function4;", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "encHeight", "encType", "encWidth", "handler", "Landroid/os/Handler;", "handlerT", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "value", "height", "setHeight", "(I)V", "imgReader", "Landroid/media/ImageReader;", "outWH", "Lkotlin/Pair;", "renderInfoQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender$RenderInfo;", "sharedContext", "Landroid/opengl/EGLContext;", "texture", "useGpuCrop", "", "width", "setWidth", "yuvCropEncodeProg", "Lcom/tencent/mm/media/render/proc/RGB2YUVCropRenderProc;", "yuvHeight", "yuvWidth", "cacheCallbackBuffer", "size", "frameMirror", "mirror", "post", "task", "Lkotlin/Function0;", "release", "requestRender", "setDataCallBack", "setInputTexture", "setRotate", "rotate", "setUpImageReader", "updateEncodeResType", "encoderType", "updateSize", "Companion", "RenderInfo", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a URN;
  public int TXY;
  public final boolean UIy;
  public final HandlerThread URO;
  public ImageReader URP;
  public kotlin.g.a.r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, ah> URQ;
  public g URR;
  public final ConcurrentLinkedQueue<c.b> URS;
  public final HashMap<Integer, LinkedBlockingQueue<ByteBuffer>> URT;
  private kotlin.r<Integer, Integer> URU;
  public int URV;
  public int URW;
  private final Handler handler;
  public int height;
  public com.tencent.mm.media.util.c.b mVi;
  public int nAg;
  public int nAh;
  public int qIF;
  private final EGLContext sharedContext;
  public int width;
  
  static
  {
    AppMethodBeat.i(293177);
    URN = new c.a((byte)0);
    AppMethodBeat.o(293177);
  }
  
  public c()
  {
    AppMethodBeat.i(293062);
    this.URO = d.jv("voip_rgb2yuv_thread", -4);
    h localh = h.ULL;
    this.UIy = h.ibC();
    this.sharedContext = EGL14.eglGetCurrentContext();
    this.URS = new ConcurrentLinkedQueue();
    this.URT = new HashMap();
    this.URU = new kotlin.r(Integer.valueOf(0), Integer.valueOf(0));
    this.TXY = -1;
    this.URR = new g(1, 15);
    this.URO.start();
    this.handler = new Handler(this.URO.getLooper());
    AppMethodBeat.o(293062);
  }
  
  private static final void bX(a parama)
  {
    AppMethodBeat.i(293065);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(293065);
  }
  
  public final void bI(a<ah> parama)
  {
    AppMethodBeat.i(293188);
    this.handler.post(new c..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(293188);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements a<ah>
  {
    public c(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends u
    implements a<ah>
  {
    public d(c paramc)
    {
      super();
    }
    
    private static final void b(c paramc, ImageReader paramImageReader)
    {
      AppMethodBeat.i(293212);
      s.u(paramc, "this$0");
      Image localImage = paramImageReader.acquireLatestImage();
      if (localImage != null) {
        try
        {
          Object localObject2 = localImage.getPlanes()[0];
          c.e(paramc);
          paramImageReader = (c.b)c.e(paramc).remove();
          while (localImage.getTimestamp() > paramImageReader.URZ)
          {
            paramImageReader = (c.b)c.e(paramc).remove();
            Log.i("EncoderSurfaceRender", s.X("drop render info pts: ", Long.valueOf(localImage.getTimestamp())));
          }
          int j = paramImageReader.URX * paramImageReader.URY * 3 / 2;
          c.c(paramc, j);
          Object localObject1 = (LinkedBlockingQueue)c.g(paramc).get(Integer.valueOf(j));
          if (localObject1 == null)
          {
            localObject1 = null;
            c.a(paramc, new kotlin.r(Integer.valueOf(paramImageReader.URX), Integer.valueOf(paramImageReader.URY)));
            if (localObject1 != null)
            {
              SightVideoJNI.nativeBufferCopy(((Image.Plane)localObject2).getBuffer(), (ByteBuffer)localObject1, paramImageReader.URY, paramImageReader.URX * 3 / 2, ((Image.Plane)localObject2).getRowStride() - paramImageReader.URY);
              localObject2 = c.f(paramc);
              if (localObject2 != null) {
                ((kotlin.g.a.r)localObject2).a(localObject1, Integer.valueOf(paramImageReader.URY), Integer.valueOf(paramImageReader.URX), Integer.valueOf(paramImageReader.dataType));
              }
              paramImageReader = i.USW;
              i.bj(4, Util.ticksToNow(localImage.getTimestamp()));
              paramImageReader = (LinkedBlockingQueue)c.g(paramc).get(Integer.valueOf(j));
              if (paramImageReader != null) {
                break label331;
              }
            }
          }
          label331:
          for (int i = 0;; i = paramImageReader.size())
          {
            if (i < 2)
            {
              paramc = (LinkedBlockingQueue)c.g(paramc).get(Integer.valueOf(j));
              if (paramc != null) {
                paramc.add(localObject1);
              }
            }
            return;
            localObject1 = (ByteBuffer)((LinkedBlockingQueue)localObject1).remove();
            break;
          }
          AppMethodBeat.o(293212);
        }
        catch (NoSuchElementException paramc)
        {
          Log.e("EncoderSurfaceRender", paramc.getMessage());
          return;
        }
        catch (IllegalStateException paramc)
        {
          Log.e("EncoderSurfaceRender", paramc.getMessage());
          return;
        }
        finally
        {
          localImage.close();
          AppMethodBeat.o(293212);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.c
 * JD-Core Version:    0.7.0.1
 */