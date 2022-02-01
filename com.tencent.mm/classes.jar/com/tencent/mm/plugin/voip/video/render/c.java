package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "", "mIsRenderLocal", "", "hashCode", "", "(ZI)V", "canRender", "getCanRender", "()Z", "setCanRender", "(Z)V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHashCode", "()I", "setHashCode", "(I)V", "inputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getInputTexture", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setInputTexture", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "isRelease", "mDrawPerFrameStartTimes", "", "getMDrawPerFrameStartTimes", "()J", "setMDrawPerFrameStartTimes", "(J)V", "mLocalRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "mRemoteRenderSurface", "mShareHeight", "getMShareHeight", "setMShareHeight", "mShareWidth", "getMShareWidth", "setMShareWidth", "onDrawPrcoEndYUVCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cost", "", "getOnDrawPrcoEndYUVCallback", "()Lkotlin/jvm/functions/Function1;", "setOnDrawPrcoEndYUVCallback", "(Lkotlin/jvm/functions/Function1;)V", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "getOnDrawProcPerFrameCost", "setOnDrawProcPerFrameCost", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "getRenderProc", "()Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "setRenderProc", "(Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;)V", "renderSide", "getRenderSide", "setRenderSide", "renderThread", "Landroid/os/HandlerThread;", "rendering", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "addRenderSurface", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "choiceRenderSurface", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "h", "flag", "", "makeOutputSurface", "queue", "release", "removeSurface", "render", "requestRender", "texture", "setInputExternalTexture", "setShowMode", "mode", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public abstract class c
{
  public static final c.a CJk = new c.a((byte)0);
  long CFB;
  public com.tencent.mm.media.g.d CGt;
  public a<z> CIY;
  b<? super Long, z> CIZ;
  b<? super Long, z> CJa;
  private boolean CJb;
  boolean CJc;
  private f CJd;
  private f CJe;
  public l CJf;
  int CJg;
  int CJh;
  int CJi;
  private boolean CJj;
  private int aHQ;
  private aq handler;
  private boolean hmi;
  private final HandlerThread hnG;
  com.tencent.mm.media.k.c.b hxc;
  Surface surface;
  SurfaceTexture surfaceTexture;
  
  public c(boolean paramBoolean, int paramInt)
  {
    this.CJj = paramBoolean;
    this.aHQ = paramInt;
    this.CFB = -1L;
    HandlerThread localHandlerThread = com.tencent.e.c.d.hi("WindowSurfaceRenderer_renderThread_" + this.aHQ, 5);
    p.g(localHandlerThread, "SpecialThreadFactory.cre…e\", Thread.NORM_PRIORITY)");
    this.hnG = localHandlerThread;
    this.hnG.start();
    this.handler = new aq(this.hnG.getLooper());
    this.CJb = false;
    this.hmi = false;
    if (this.CJj) {}
    for (paramInt = i;; paramInt = 1)
    {
      this.CJi = paramInt;
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
        if (this.hxc != null)
        {
          Object localObject2 = new StringBuilder("eGl display= ");
          localObject1 = this.hxc;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.media.k.c.b)localObject1).hrE;
            localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglContext=");
            localObject1 = this.hxc;
            if (localObject1 == null) {
              break label253;
            }
            localObject1 = ((com.tencent.mm.media.k.c.b)localObject1).hrF;
            localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglSurface=");
            localObject1 = this.hxc;
            if (localObject1 == null) {
              break label258;
            }
            localObject1 = ((com.tencent.mm.media.k.c.b)localObject1).eglSurface;
            ae.i("MicroMsg.WindowSurfaceRenderer", localObject1 + " and current surface is " + paramf);
            localObject1 = com.tencent.mm.media.k.c.hrD;
            localObject1 = this.hxc;
            if (localObject1 == null) {
              p.gkB();
            }
            paramf.a(com.tencent.mm.media.k.c.a.a(((com.tencent.mm.media.k.c.b)localObject1).hrE, paramf.CJw));
            localObject1 = this.hxc;
            if (localObject1 == null) {
              break label263;
            }
            localObject1 = ((com.tencent.mm.media.k.c.b)localObject1).hrE;
            localObject2 = paramf.eEQ();
            EGLSurface localEGLSurface2 = paramf.eEQ();
            com.tencent.mm.media.k.c.b localb = this.hxc;
            if (localb != null) {
              localEGLContext = localb.hrF;
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
        ae.w("MicroMsg.WindowSurfaceRenderer", "can't create eglSurface");
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
  
  public final void VA(int paramInt)
  {
    l locall = this.CJf;
    if (locall != null) {
      locall.Abn = paramInt;
    }
  }
  
  public final void a(final com.tencent.mm.media.g.d paramd)
  {
    if (paramd != null) {
      j((a)new f(this, paramd));
    }
  }
  
  public final void a(f paramf, int paramInt)
  {
    if (paramInt == 0)
    {
      this.CJd = paramf;
      return;
    }
    this.CJe = paramf;
  }
  
  public abstract void a(g paramg, ac paramac, Integer paramInteger, Boolean paramBoolean);
  
  public abstract void a(b<? super c, z> paramb, g paramg);
  
  public final void b(com.tencent.mm.media.g.d paramd)
  {
    p.h(paramd, "texture");
    if (this.CJb)
    {
      l locall = this.CJf;
      if (locall != null) {
        locall.gNq = paramd.hnc;
      }
      j((a)new e(this));
    }
  }
  
  public final void b(f paramf)
  {
    if ((p.i(paramf, this.CJd)) || (p.i(paramf, this.CJe)) || (paramf == null)) {
      j((a)new h(this));
    }
  }
  
  public final void b(f paramf, int paramInt)
  {
    if (paramf != null)
    {
      ae.m("MicroMsg.WindowSurfaceRenderer", "add render surface renderSide " + paramInt + " and :" + paramf, new Object[0]);
      if (paramInt == 0)
      {
        this.CJd = paramf;
        return;
      }
      this.CJe = paramf;
      return;
    }
    ae.e("MicroMsg.WindowSurfaceRenderer", "add a null surface");
  }
  
  public final void c(final f paramf, final int paramInt)
  {
    j((a)new d(this, paramf, paramInt));
  }
  
  public final void eEJ()
  {
    ae.m("MicroMsg.WindowSurfaceRenderer", "switchRenderSurface", new Object[0]);
    j((a)new i(this));
  }
  
  public final void eEK()
  {
    j((a)new g(this));
  }
  
  public final void j(a<z> parama)
  {
    p.h(parama, "callback");
    if (this.hnG.isAlive())
    {
      aq localaq = this.handler;
      if (localaq != null) {
        localaq.post((Runnable)new d(parama));
      }
    }
  }
  
  public final void release()
  {
    ae.i("MicroMsg.WindowSurfaceRenderer", "onSurfaceTextureDestroyed");
    aq localaq = this.handler;
    if (localaq != null) {
      localaq.removeCallbacksAndMessages(null);
    }
    j((a)new c(this));
  }
  
  public abstract void tR(boolean paramBoolean);
  
  public final void tS(final boolean paramBoolean)
  {
    j((a)new b(this, paramBoolean));
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    b(c paramc, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(c paramc, f paramf, int paramInt)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<z>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<z>
  {
    f(c paramc, com.tencent.mm.media.g.d paramd)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<z>
  {
    g(c paramc)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<z>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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