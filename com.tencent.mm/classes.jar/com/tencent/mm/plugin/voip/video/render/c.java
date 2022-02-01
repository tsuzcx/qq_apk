package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "", "mIsRenderLocal", "", "hashCode", "", "(ZI)V", "canRender", "getCanRender", "()Z", "setCanRender", "(Z)V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHashCode", "()I", "setHashCode", "(I)V", "inputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getInputTexture", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setInputTexture", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "isRelease", "mDrawPerFrameStartTimes", "", "getMDrawPerFrameStartTimes", "()J", "setMDrawPerFrameStartTimes", "(J)V", "mLocalRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "mRemoteRenderSurface", "mShareHeight", "getMShareHeight", "setMShareHeight", "mShareWidth", "getMShareWidth", "setMShareWidth", "onDrawPrcoEndYUVCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cost", "", "getOnDrawPrcoEndYUVCallback", "()Lkotlin/jvm/functions/Function1;", "setOnDrawPrcoEndYUVCallback", "(Lkotlin/jvm/functions/Function1;)V", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "getOnDrawProcPerFrameCost", "setOnDrawProcPerFrameCost", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "getRenderProc", "()Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "setRenderProc", "(Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;)V", "renderSide", "getRenderSide", "setRenderSide", "renderThread", "Landroid/os/HandlerThread;", "rendering", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "addRenderSurface", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "choiceRenderSurface", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "h", "flag", "", "makeOutputSurface", "queue", "release", "removeSurface", "render", "requestRender", "texture", "setInputExternalTexture", "setShowMode", "mode", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public abstract class c
{
  public static final c.a CrG = new c.a((byte)0);
  long CnX;
  public com.tencent.mm.media.g.d CoP;
  private f CrA;
  public l CrB;
  int CrC;
  int CrD;
  int CrE;
  private boolean CrF;
  public a<z> Cru;
  b<? super Long, z> Crv;
  b<? super Long, z> Crw;
  private boolean Crx;
  boolean Cry;
  private f Crz;
  private int aHQ;
  private ap handler;
  private boolean hju;
  private final HandlerThread hkS;
  com.tencent.mm.media.k.c.b huo;
  Surface surface;
  SurfaceTexture surfaceTexture;
  
  public c(boolean paramBoolean, int paramInt)
  {
    this.CrF = paramBoolean;
    this.aHQ = paramInt;
    this.CnX = -1L;
    HandlerThread localHandlerThread = com.tencent.e.c.d.gZ("WindowSurfaceRenderer_renderThread_" + this.aHQ, 5);
    p.g(localHandlerThread, "SpecialThreadFactory.cre…e\", Thread.NORM_PRIORITY)");
    this.hkS = localHandlerThread;
    this.hkS.start();
    this.handler = new ap(this.hkS.getLooper());
    this.Crx = false;
    this.hju = false;
    if (this.CrF) {}
    for (paramInt = i;; paramInt = 1)
    {
      this.CrE = paramInt;
      return;
    }
  }
  
  private final boolean a(f paramf)
  {
    EGLContext localEGLContext = null;
    for (;;)
    {
      try
      {
        Object localObject1;
        if (this.huo != null)
        {
          Object localObject2 = new StringBuilder("eGl display= ");
          localObject1 = this.huo;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.media.k.c.b)localObject1).hoQ;
            localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglContext=");
            localObject1 = this.huo;
            if (localObject1 == null) {
              break label253;
            }
            localObject1 = ((com.tencent.mm.media.k.c.b)localObject1).hoR;
            localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglSurface=");
            localObject1 = this.huo;
            if (localObject1 == null) {
              break label258;
            }
            localObject1 = ((com.tencent.mm.media.k.c.b)localObject1).eglSurface;
            ad.i("MicroMsg.WindowSurfaceRenderer", localObject1 + " and current surface is " + paramf);
            localObject1 = com.tencent.mm.media.k.c.hoP;
            localObject1 = this.huo;
            if (localObject1 == null) {
              p.gfZ();
            }
            paramf.a(com.tencent.mm.media.k.c.a.a(((com.tencent.mm.media.k.c.b)localObject1).hoQ, paramf.CrS));
            localObject1 = this.huo;
            if (localObject1 == null) {
              break label263;
            }
            localObject1 = ((com.tencent.mm.media.k.c.b)localObject1).hoQ;
            localObject2 = paramf.eBi();
            EGLSurface localEGLSurface2 = paramf.eBi();
            com.tencent.mm.media.k.c.b localb = this.huo;
            if (localb != null) {
              localEGLContext = localb.hoR;
            }
            EGL14.eglMakeCurrent((EGLDisplay)localObject1, (EGLSurface)localObject2, localEGLSurface2, localEGLContext);
            return true;
          }
        }
        else
        {
          localObject1 = EGL14.EGL_NO_SURFACE;
          p.g(localObject1, "EGL14.EGL_NO_SURFACE");
          paramf.a((EGLSurface)localObject1);
          return false;
        }
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.WindowSurfaceRenderer", "can't create eglSurface");
        localEGLSurface1 = EGL14.EGL_NO_SURFACE;
        p.g(localEGLSurface1, "EGL14.EGL_NO_SURFACE");
        paramf.a(localEGLSurface1);
        return false;
      }
      EGLSurface localEGLSurface1 = null;
      continue;
      label253:
      localEGLSurface1 = null;
      continue;
      label258:
      localEGLSurface1 = null;
      continue;
      label263:
      localEGLSurface1 = null;
    }
  }
  
  public final void UT(int paramInt)
  {
    l locall = this.CrB;
    if (locall != null) {
      locall.zKg = paramInt;
    }
  }
  
  public final void a(final com.tencent.mm.media.g.d paramd)
  {
    if (paramd != null) {
      i((a)new f(this, paramd));
    }
  }
  
  public final void a(f paramf, int paramInt)
  {
    if (paramInt == 0)
    {
      this.Crz = paramf;
      return;
    }
    this.CrA = paramf;
  }
  
  public abstract void a(g paramg, ac paramac, Integer paramInteger, Boolean paramBoolean);
  
  public abstract void a(b<? super c, z> paramb, g paramg);
  
  public final void b(com.tencent.mm.media.g.d paramd)
  {
    p.h(paramd, "texture");
    if (this.Crx)
    {
      l locall = this.CrB;
      if (locall != null) {
        locall.gKH = paramd.hko;
      }
      i((a)new e(this));
    }
  }
  
  public final void b(f paramf, int paramInt)
  {
    if (paramf != null)
    {
      ad.m("MicroMsg.WindowSurfaceRenderer", "add render surface renderSide " + paramInt + " and :" + paramf, new Object[0]);
      if (paramInt == 0)
      {
        this.Crz = paramf;
        return;
      }
      this.CrA = paramf;
      return;
    }
    ad.e("MicroMsg.WindowSurfaceRenderer", "add a null surface");
  }
  
  public final void c(final f paramf, final int paramInt)
  {
    i((a)new d(this, paramf, paramInt));
  }
  
  public final void eBb()
  {
    ad.m("MicroMsg.WindowSurfaceRenderer", "switchRenderSurface", new Object[0]);
    i((a)new i(this));
  }
  
  public final void eBc()
  {
    i((a)new g(this));
  }
  
  public final void eBd()
  {
    i((a)new h(this));
  }
  
  public final void i(a<z> parama)
  {
    p.h(parama, "callback");
    if (this.hkS.isAlive())
    {
      ap localap = this.handler;
      if (localap != null) {
        localap.post((Runnable)new d(parama));
      }
    }
  }
  
  public final void release()
  {
    ad.i("MicroMsg.WindowSurfaceRenderer", "onSurfaceTextureDestroyed");
    ap localap = this.handler;
    if (localap != null) {
      localap.removeCallbacksAndMessages(null);
    }
    i((a)new c(this));
  }
  
  public abstract void tK(boolean paramBoolean);
  
  public final void tL(final boolean paramBoolean)
  {
    i((a)new b(this, paramBoolean));
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    b(c paramc, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(c paramc, f paramf, int paramInt)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<z>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<z>
  {
    f(c paramc, com.tencent.mm.media.g.d paramd)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<z>
  {
    g(c paramc)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<z>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements a<z>
  {
    i(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.c
 * JD-Core Version:    0.7.0.1
 */