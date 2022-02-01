package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "", "mIsRenderLocal", "", "hashCode", "", "(ZI)V", "canRender", "getCanRender", "()Z", "setCanRender", "(Z)V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHashCode", "()I", "setHashCode", "(I)V", "inputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getInputTexture", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setInputTexture", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "isRelease", "mDrawPerFrameStartTimes", "", "getMDrawPerFrameStartTimes", "()J", "setMDrawPerFrameStartTimes", "(J)V", "mLocalRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "mRemoteRenderSurface", "mShareHeight", "getMShareHeight", "setMShareHeight", "mShareWidth", "getMShareWidth", "setMShareWidth", "onDrawPrcoEndYUVCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cost", "", "getOnDrawPrcoEndYUVCallback", "()Lkotlin/jvm/functions/Function1;", "setOnDrawPrcoEndYUVCallback", "(Lkotlin/jvm/functions/Function1;)V", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "getOnDrawProcPerFrameCost", "setOnDrawProcPerFrameCost", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "getRenderProc", "()Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "setRenderProc", "(Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;)V", "renderSide", "getRenderSide", "setRenderSide", "renderThread", "Landroid/os/HandlerThread;", "rendering", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "addRenderSurface", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "needRefresh", "choiceRenderSurface", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "h", "flag", "", "queue", "release", "removeSurface", "render", "requestRender", "texture", "setInputExternalTexture", "setShowMode", "mode", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public abstract class d
{
  public static final d.a Hno = new d.a((byte)0);
  long HiP;
  public com.tencent.mm.media.g.d Hko;
  a<x> Hnc;
  b<? super Long, x> Hnd;
  b<? super Long, x> Hne;
  private boolean Hnf;
  boolean Hng;
  private f Hnh;
  private f Hni;
  public l Hnj;
  int Hnk;
  int Hnl;
  int Hnm;
  private boolean Hnn;
  private int aHK;
  private MMHandler handler;
  private boolean ife;
  private final HandlerThread igZ;
  c.b ilw;
  Surface surface;
  SurfaceTexture surfaceTexture;
  
  public d(boolean paramBoolean, int paramInt)
  {
    this.Hnn = paramBoolean;
    this.aHK = paramInt;
    this.HiP = -1L;
    HandlerThread localHandlerThread = com.tencent.f.c.d.hC("WindowSurfaceRenderer_renderThread_" + this.aHK, 5);
    p.g(localHandlerThread, "SpecialThreadFactory.cre…e\", Thread.NORM_PRIORITY)");
    this.igZ = localHandlerThread;
    this.igZ.start();
    this.handler = new MMHandler(this.igZ.getLooper());
    this.Hnf = false;
    this.ife = false;
    if (this.Hnn) {}
    for (paramInt = i;; paramInt = 1)
    {
      this.Hnm = paramInt;
      return;
    }
  }
  
  public final void a(final com.tencent.mm.media.g.d paramd)
  {
    if (paramd != null) {
      k((a)new f(this, paramd));
    }
  }
  
  public final void a(f paramf)
  {
    if ((p.j(paramf, this.Hnh)) || (p.j(paramf, this.Hni)) || (paramf == null)) {
      k((a)new h(this));
    }
  }
  
  public final void a(f paramf, int paramInt)
  {
    if (paramInt == 0)
    {
      this.Hnh = paramf;
      return;
    }
    this.Hni = paramf;
  }
  
  public abstract void a(g paramg, ac paramac, Integer paramInteger, Boolean paramBoolean);
  
  public abstract void a(b<? super d, x> paramb, g paramg, boolean paramBoolean);
  
  public final void b(com.tencent.mm.media.g.d paramd)
  {
    p.h(paramd, "texture");
    if (this.Hnf)
    {
      l locall = this.Hnj;
      if (locall != null) {
        locall.hDl = paramd.igv;
      }
      k((a)new e(this));
    }
  }
  
  public final void b(f paramf, int paramInt)
  {
    if (paramf != null)
    {
      Log.printInfoStack("MicroMsg.WindowSurfaceRenderer", "add render surface renderSide " + paramInt + " and :" + paramf, new Object[0]);
      if (paramInt == 0)
      {
        this.Hnh = paramf;
        return;
      }
      this.Hni = paramf;
      return;
    }
    Log.e("MicroMsg.WindowSurfaceRenderer", "add a null surface");
  }
  
  public final void c(final f paramf, final int paramInt)
  {
    k((a)new d(this, paramf, paramInt));
  }
  
  public final void fLQ()
  {
    Log.printInfoStack("MicroMsg.WindowSurfaceRenderer", "switchRenderSurface", new Object[0]);
    k((a)new i(this));
  }
  
  public final void fLR()
  {
    k((a)new g(this));
  }
  
  public final void k(a<x> parama)
  {
    p.h(parama, "callback");
    if (this.igZ.isAlive())
    {
      MMHandler localMMHandler = this.handler;
      if (localMMHandler != null) {
        localMMHandler.post((Runnable)new e(parama));
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
    k((a)new c(this));
  }
  
  public final void setShowMode(int paramInt)
  {
    l locall = this.Hnj;
    if (locall != null) {
      locall.hEi = paramInt;
    }
  }
  
  public final void xA(final boolean paramBoolean)
  {
    k((a)new b(this, paramBoolean));
  }
  
  public abstract void xz(boolean paramBoolean);
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(d paramd, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(d paramd, f paramf, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(d paramd, com.tencent.mm.media.g.d paramd1)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<x>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<x>
  {
    h(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements a<x>
  {
    i(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.d
 * JD-Core Version:    0.7.0.1
 */