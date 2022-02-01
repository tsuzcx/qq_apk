package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "", "mIsRenderLocal", "", "hashCode", "", "(ZI)V", "canRender", "getCanRender", "()Z", "setCanRender", "(Z)V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHashCode", "()I", "setHashCode", "(I)V", "inputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getInputTexture", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setInputTexture", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "isRelease", "mDrawPerFrameStartTimes", "", "getMDrawPerFrameStartTimes", "()J", "setMDrawPerFrameStartTimes", "(J)V", "mLocalRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getMLocalRenderSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setMLocalRenderSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "mRemoteRenderSurface", "getMRemoteRenderSurface", "setMRemoteRenderSurface", "mShareHeight", "getMShareHeight", "setMShareHeight", "mShareWidth", "getMShareWidth", "setMShareWidth", "onDrawPrcoEndYUVCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cost", "", "getOnDrawPrcoEndYUVCallback", "()Lkotlin/jvm/functions/Function1;", "setOnDrawPrcoEndYUVCallback", "(Lkotlin/jvm/functions/Function1;)V", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "getOnDrawProcPerFrameCost", "setOnDrawProcPerFrameCost", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "getRenderProc", "()Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "setRenderProc", "(Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;)V", "renderSide", "getRenderSide", "setRenderSide", "renderThread", "Landroid/os/HandlerThread;", "rendering", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "addRenderSurface", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "needRefresh", "choiceRenderSurface", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "h", "flag", "", "getRenderSurface", "", "()[Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "queue", "release", "removeSurface", "render", "requestRender", "texture", "setInputExternalTexture", "setShowMode", "mode", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public abstract class e
{
  public static final a Oen = new a((byte)0);
  long NZD;
  public com.tencent.mm.media.g.d Obd;
  a<x> Oea;
  b<? super Long, x> Oeb;
  b<? super Long, x> Oec;
  private boolean Oed;
  boolean Oee;
  g Oef;
  g Oeg;
  public o Oei;
  int Oej;
  int Oek;
  int Oel;
  private boolean Oem;
  private int aNf;
  private MMHandler handler;
  private boolean kTS;
  private final HandlerThread kVN;
  c.b lav;
  Surface surface;
  SurfaceTexture surfaceTexture;
  
  public e(boolean paramBoolean, int paramInt)
  {
    this.Oem = paramBoolean;
    this.aNf = paramInt;
    this.NZD = -1L;
    HandlerThread localHandlerThread = com.tencent.e.c.d.im("WindowSurfaceRenderer_renderThread_" + this.aNf, 5);
    p.j(localHandlerThread, "SpecialThreadFactory.cre…e\", Thread.NORM_PRIORITY)");
    this.kVN = localHandlerThread;
    this.kVN.start();
    this.handler = new MMHandler(this.kVN.getLooper());
    this.Oed = false;
    this.kTS = false;
    if (this.Oem) {}
    for (paramInt = i;; paramInt = 1)
    {
      this.Oel = paramInt;
      return;
    }
  }
  
  public abstract void Bs(boolean paramBoolean);
  
  public final void Bt(final boolean paramBoolean)
  {
    j((a)new b(this, paramBoolean));
  }
  
  public final void a(final com.tencent.mm.media.g.d paramd)
  {
    if (paramd != null) {
      j((a)new g(this, paramd));
    }
  }
  
  public final void a(g paramg)
  {
    if ((p.h(paramg, this.Oef)) || (p.h(paramg, this.Oeg)) || (paramg == null)) {
      j((a)new i(this));
    }
  }
  
  public final void a(g paramg, int paramInt)
  {
    if (paramInt == 0)
    {
      this.Oef = paramg;
      return;
    }
    this.Oeg = paramg;
  }
  
  public abstract void a(h paramh, ad paramad, Integer paramInteger, Boolean paramBoolean);
  
  public abstract void a(b<? super e, x> paramb, h paramh, boolean paramBoolean);
  
  public final void b(com.tencent.mm.media.g.d paramd)
  {
    p.k(paramd, "texture");
    if (this.Oed)
    {
      o localo = this.Oei;
      if (localo != null) {
        localo.kre = paramd.kVj;
      }
      j((a)new f(this));
    }
  }
  
  public final void b(g paramg, int paramInt)
  {
    if (paramg != null)
    {
      Log.printInfoStack("MicroMsg.WindowSurfaceRenderer", "add render surface renderSide " + paramInt + " and :" + paramg, new Object[0]);
      if (paramInt == 0)
      {
        this.Oef = paramg;
        return;
      }
      this.Oeg = paramg;
      return;
    }
    Log.e("MicroMsg.WindowSurfaceRenderer", "add a null surface");
  }
  
  public final void c(final g paramg, final int paramInt)
  {
    j((a)new e(this, paramg, paramInt));
  }
  
  public final void gEr()
  {
    Log.printInfoStack("MicroMsg.WindowSurfaceRenderer", "switchRenderSurface", new Object[0]);
    j((a)new j(this));
  }
  
  public final void gEs()
  {
    j((a)new h(this));
  }
  
  public final void j(a<x> parama)
  {
    p.k(parama, "callback");
    if (this.kVN.isAlive())
    {
      MMHandler localMMHandler = this.handler;
      if (localMMHandler != null) {
        localMMHandler.post((Runnable)new f(parama));
      }
    }
  }
  
  public final void release()
  {
    Log.i("MicroMsg.WindowSurfaceRenderer", "onSurfaceTextureDestroyed");
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    j((a)new d(this));
  }
  
  public final void setShowMode(int paramInt)
  {
    o localo = this.Oei;
    if (localo != null) {
      localo.ksn = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(e parame, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(e parame, g paramg, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<x>
  {
    g(e parame, com.tencent.mm.media.g.d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<x>
  {
    h(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements a<x>
  {
    i(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements a<x>
  {
    j(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.e
 * JD-Core Version:    0.7.0.1
 */