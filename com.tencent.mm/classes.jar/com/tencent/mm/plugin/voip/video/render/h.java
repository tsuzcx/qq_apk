package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGLDisplay;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "", "width", "", "height", "(II)V", "beautyParam", "dataCallbackList", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "externalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "faceBeautyAlgorithm", "getFaceBeautyAlgorithm", "()I", "setFaceBeautyAlgorithm", "(I)V", "fboCallbackList", "Lkotlin/Function1;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHeight", "setHeight", "initCallback", "isRelease", "", "logFrameAvailable", "mCameraOrientation", "getMCameraOrientation", "setMCameraOrientation", "mDrawPerFrameStartTimes", "", "mIsMirror", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "Lkotlin/ParameterName;", "name", "cost", "getOnDrawProcPerFrameCost", "()Lkotlin/jvm/functions/Function1;", "setOnDrawProcPerFrameCost", "(Lkotlin/jvm/functions/Function1;)V", "onFrameDataAvailableCallback", "getOnFrameDataAvailableCallback", "setOnFrameDataAvailableCallback", "pauseRender", "postInit", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "renderThread", "Landroid/os/HandlerThread;", "rendering", "spatiotemporalDenosingAllow", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getWidth", "setWidth", "addFBOAvailableCallback", "callback", "addFrameDataCallback", "checkInit", "createContext", "createSurface", "glSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getFaceBeautyType", "getGLContext", "Landroid/opengl/EGLContext;", "getOutputExternalTexture", "getUseSTFilter", "onPreviewTextureFrameAvailable", "onRendererFrameAvailable", "queue", "release", "releaseSurface", "renderImpl", "setCameraIsMirror", "mirror", "setCameraOrientation", "orientation", "setLocalRenderOrientation", "rotateDegree", "cameraOrientation", "setLocalVideoSize", "setSTFilterMotionNoiseData", "motion", "noise", "", "setSpatiotemporalDenosing", "cmd", "skipFilter", "setVoIPBeauty", "start", "stop", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updatePboAndWindowsSize", "cameraSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "Companion", "plugin-voip_release"})
public final class h
{
  public static final a OeE;
  private com.tencent.mm.media.g.d Frh;
  boolean NYu;
  private long NZD;
  private int NZs;
  ArrayList<b<com.tencent.mm.media.g.d, x>> OeA;
  private boolean OeB;
  int OeC;
  private int OeD;
  a<x> Oea;
  b<? super Long, x> Oeb;
  private boolean Oed;
  n Oew;
  boolean Oex;
  private boolean Oey;
  private b<? super h, x> Oez;
  ArrayList<r<ByteBuffer, Integer, Integer, Integer, x>> Suk;
  a<x> Sul;
  MMHandler handler;
  int height;
  private volatile boolean kTS;
  private final HandlerThread kVN;
  c.b lav;
  Surface surface;
  SurfaceTexture surfaceTexture;
  int width;
  
  static
  {
    AppMethodBeat.i(237182);
    OeE = new a((byte)0);
    AppMethodBeat.o(237182);
  }
  
  public h(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237181);
    this.width = paramInt1;
    this.height = paramInt2;
    HandlerThread localHandlerThread = com.tencent.e.c.d.im("PboSurfaceRender_renderThread_" + hashCode(), 5);
    p.j(localHandlerThread, "SpecialThreadFactory.cre…}\", Thread.NORM_PRIORITY)");
    this.kVN = localHandlerThread;
    this.Suk = new ArrayList();
    this.OeA = new ArrayList();
    this.NZD = -1L;
    this.kVN.start();
    this.handler = new MMHandler(this.kVN.getLooper());
    this.Oed = false;
    this.kTS = false;
    AppMethodBeat.o(237181);
  }
  
  private final void aVw()
  {
    AppMethodBeat.i(237164);
    Object localObject = this.surfaceTexture;
    if (localObject != null)
    {
      if (this.Oey)
      {
        AppMethodBeat.o(237164);
        return;
      }
      try
      {
        ((SurfaceTexture)localObject).updateTexImage();
        this.NZD = Util.currentTicks();
        localObject = this.Oew;
        if (localObject != null) {
          ((n)localObject).aMU();
        }
        localObject = this.Oeb;
        if (localObject != null) {
          ((b)localObject).invoke(Long.valueOf(Util.ticksToNow(this.NZD)));
        }
        localObject = this.Sul;
        if (localObject != null)
        {
          ((a)localObject).invoke();
          AppMethodBeat.o(237164);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.PboSurfaceRender", (Throwable)localException, "updateTexImage error", new Object[0]);
        }
        AppMethodBeat.o(237164);
        return;
      }
    }
    AppMethodBeat.o(237164);
  }
  
  public final void a(g paramg, b<? super g, x> paramb)
  {
    AppMethodBeat.i(293154);
    p.k(paramg, "glSurface");
    if (this.lav != null)
    {
      Object localObject2 = paramg.Oet;
      if (localObject2 != null)
      {
        Object localObject1 = c.lar;
        localObject1 = this.lav;
        if (localObject1 != null) {}
        for (localObject1 = ((c.b)localObject1).las;; localObject1 = null)
        {
          if (localObject1 == null) {
            p.iCn();
          }
          paramg.a(c.a.a((EGLDisplay)localObject1, localObject2));
          if (paramb == null) {
            break;
          }
          paramb.invoke(paramg);
          AppMethodBeat.o(293154);
          return;
        }
        AppMethodBeat.o(293154);
        return;
      }
    }
    AppMethodBeat.o(293154);
  }
  
  public final void aJ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(293152);
    j((a)new h.o(this, paramInt1, paramInt2, paramInt3));
    AppMethodBeat.o(293152);
  }
  
  public final void alM(final int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(237167);
    Log.printInfoStack("MicroMsg.PboSurfaceRender", "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt) });
    this.NZs = paramInt;
    int i;
    if ((this.NZs & 0x8) != 0)
    {
      i = 1;
      if ((this.NZs == 0) || (i != 0)) {
        break label100;
      }
      Log.i("MicroMsg.PboSurfaceRender", "render YT face-beauty algorithm");
      i = 2;
    }
    for (;;)
    {
      this.OeC = i;
      j((a)new j(this, paramInt));
      AppMethodBeat.o(237167);
      return;
      i = 0;
      break;
      label100:
      if ((i != 0) && ((this.NZs & 0x8) != 0))
      {
        Log.i("MicroMsg.PboSurfaceRender", "render WC face-beauty algorithm");
        i = j;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void alN(final int paramInt)
  {
    AppMethodBeat.i(237169);
    Log.i("MicroMsg.PboSurfaceRender", "setSpatiotemporalDenosing, isON:%d", new Object[] { Integer.valueOf(paramInt) });
    this.OeD = paramInt;
    if (((this.OeC == 0) || (this.OeC == 3)) && (this.OeD == 1)) {
      this.OeC = 3;
    }
    j((a)new i(this, paramInt, false));
    AppMethodBeat.o(237169);
  }
  
  public final void h(r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> paramr)
  {
    AppMethodBeat.i(293153);
    if ((paramr != null) && (!this.Suk.contains(paramr))) {
      this.Suk.add(paramr);
    }
    AppMethodBeat.o(293153);
  }
  
  public final void j(a<x> parama)
  {
    AppMethodBeat.i(237173);
    p.k(parama, "callback");
    if ((this.kVN.isAlive()) && (!this.kTS))
    {
      MMHandler localMMHandler = this.handler;
      if (localMMHandler != null)
      {
        localMMHandler.post((Runnable)new i(parama));
        AppMethodBeat.o(237173);
        return;
      }
    }
    AppMethodBeat.o(237173);
  }
  
  public final void lc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237178);
    Log.i("MicroMsg.PboSurfaceRender", "setLocalRenderOrientation " + paramInt1 + ',' + paramInt2 + ",$");
    n localn;
    if (!this.NYu)
    {
      if ((paramInt1 == 180) || (paramInt1 == 0))
      {
        localn = this.Oew;
        if (localn != null) {
          localn.tm(paramInt2);
        }
        localn = this.Oew;
        if (localn != null) {
          localn.OfP = (paramInt2 - paramInt1);
        }
        localn = this.Oew;
        if (localn != null) {
          localn.OfR = true;
        }
      }
      for (;;)
      {
        localn = this.Oew;
        if (localn == null) {
          break;
        }
        localn.kYh = false;
        AppMethodBeat.o(237178);
        return;
        localn = this.Oew;
        if (localn != null) {
          localn.tm((paramInt1 - paramInt2) % 360);
        }
        localn = this.Oew;
        if (localn != null) {
          localn.OfP = ((paramInt1 - paramInt2) % 360);
        }
        localn = this.Oew;
        if (localn != null) {
          localn.OfR = true;
        }
      }
    }
    if ((paramInt1 == 180) || (paramInt1 == 0))
    {
      localn = this.Oew;
      if (localn != null) {
        localn.tm((paramInt2 + 180) % 360);
      }
      localn = this.Oew;
      if (localn != null) {
        localn.OfP = ((paramInt2 - paramInt1) % 360);
      }
    }
    for (;;)
    {
      localn = this.Oew;
      if (localn == null) {
        break;
      }
      localn.OfR = true;
      break;
      localn = this.Oew;
      if (localn != null) {
        localn.tm((paramInt1 - paramInt2 + 180) % 360);
      }
      localn = this.Oew;
      if (localn != null) {
        localn.OfP = ((paramInt1 - paramInt2) % 360);
      }
    }
    AppMethodBeat.o(237178);
  }
  
  public final void y(final int paramInt, final float paramFloat)
  {
    AppMethodBeat.i(237170);
    j((a)new h(this, paramInt, paramFloat));
    AppMethodBeat.o(237170);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(h paramh, b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/PboSurfaceRender$createContext$3$1"})
  static final class c
    implements SurfaceTexture.OnFrameAvailableListener
  {
    c(h paramh) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(237401);
      h.f(this.OeF);
      h.g(this.OeF);
      AppMethodBeat.o(237401);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dataBuffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class d
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, x>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dataBuffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class e
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, x>
  {
    e(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<x>
  {
    g(h paramh, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<x>
  {
    h(h paramh, int paramInt, float paramFloat)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements a<x>
  {
    i(h paramh, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements a<x>
  {
    j(h paramh, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements a<x>
  {
    k(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements a<x>
  {
    l(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.h
 * JD-Core Version:    0.7.0.1
 */