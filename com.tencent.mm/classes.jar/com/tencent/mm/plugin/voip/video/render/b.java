package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "", "mIsRenderLocal", "", "hashCode", "", "(ZI)V", "canRender", "getCanRender", "()Z", "setCanRender", "(Z)V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHashCode", "()I", "setHashCode", "(I)V", "inputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getInputTexture", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setInputTexture", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "isRelease", "mDrawPerFrameStartTimes", "", "getMDrawPerFrameStartTimes", "()J", "setMDrawPerFrameStartTimes", "(J)V", "mLocalRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "mRemoteRenderSurface", "mShareHeight", "getMShareHeight", "setMShareHeight", "mShareWidth", "getMShareWidth", "setMShareWidth", "onDrawPrcoEndYUVCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cost", "", "getOnDrawPrcoEndYUVCallback", "()Lkotlin/jvm/functions/Function1;", "setOnDrawPrcoEndYUVCallback", "(Lkotlin/jvm/functions/Function1;)V", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "getOnDrawProcPerFrameCost", "setOnDrawProcPerFrameCost", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "getRenderProc", "()Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "setRenderProc", "(Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;)V", "renderSide", "getRenderSide", "setRenderSide", "renderThread", "Landroid/os/HandlerThread;", "rendering", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "addRenderSurface", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "choiceRenderSurface", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "h", "flag", "", "makeOutputSurface", "queue", "release", "removeSurface", "render", "requestRender", "texture", "setInputExternalTexture", "setShowMode", "mode", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public abstract class b
{
  public static final b.a ARI = new b.a((byte)0);
  long AOD;
  public com.tencent.mm.media.f.d APu;
  boolean ARA;
  private e ARB;
  private e ARC;
  public j ARD;
  int ARE;
  int ARF;
  int ARG;
  private boolean ARH;
  public a<y> ARw;
  d.g.a.b<? super Long, y> ARx;
  d.g.a.b<? super Long, y> ARy;
  private boolean ARz;
  private int aFZ;
  private boolean gRc;
  private final HandlerThread gSR;
  private ao handler;
  c.b hcg;
  Surface surface;
  SurfaceTexture surfaceTexture;
  
  public b(boolean paramBoolean, int paramInt)
  {
    this.ARH = paramBoolean;
    this.aFZ = paramInt;
    this.AOD = -1L;
    HandlerThread localHandlerThread = com.tencent.e.c.d.gB("WindowSurfaceRenderer_renderThread_" + this.aFZ, 5);
    k.g(localHandlerThread, "SpecialThreadFactory.cre…e\", Thread.NORM_PRIORITY)");
    this.gSR = localHandlerThread;
    this.gSR.start();
    this.handler = new ao(this.gSR.getLooper());
    this.ARz = false;
    this.gRc = false;
    if (this.ARH) {}
    for (paramInt = i;; paramInt = 1)
    {
      this.ARG = paramInt;
      return;
    }
  }
  
  private final boolean a(e parame)
  {
    EGLContext localEGLContext = null;
    for (;;)
    {
      try
      {
        Object localObject1;
        if (this.hcg != null)
        {
          Object localObject2 = new StringBuilder("eGl display= ");
          localObject1 = this.hcg;
          if (localObject1 != null)
          {
            localObject1 = ((c.b)localObject1).gWK;
            localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglContext=");
            localObject1 = this.hcg;
            if (localObject1 == null) {
              break label253;
            }
            localObject1 = ((c.b)localObject1).gWL;
            localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglSurface=");
            localObject1 = this.hcg;
            if (localObject1 == null) {
              break label258;
            }
            localObject1 = ((c.b)localObject1).eglSurface;
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WindowSurfaceRenderer", localObject1 + " and current surface is " + parame);
            localObject1 = com.tencent.mm.media.j.c.gWJ;
            localObject1 = this.hcg;
            if (localObject1 == null) {
              k.fOy();
            }
            parame.a(c.a.a(((c.b)localObject1).gWK, parame.ARS));
            localObject1 = this.hcg;
            if (localObject1 == null) {
              break label263;
            }
            localObject1 = ((c.b)localObject1).gWK;
            localObject2 = parame.enk();
            EGLSurface localEGLSurface2 = parame.enk();
            c.b localb = this.hcg;
            if (localb != null) {
              localEGLContext = localb.gWL;
            }
            EGL14.eglMakeCurrent((EGLDisplay)localObject1, (EGLSurface)localObject2, localEGLSurface2, localEGLContext);
            return true;
          }
        }
        else
        {
          localObject1 = EGL14.EGL_NO_SURFACE;
          k.g(localObject1, "EGL14.EGL_NO_SURFACE");
          parame.a((EGLSurface)localObject1);
          return false;
        }
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WindowSurfaceRenderer", "can't create eglSurface");
        localEGLSurface1 = EGL14.EGL_NO_SURFACE;
        k.g(localEGLSurface1, "EGL14.EGL_NO_SURFACE");
        parame.a(localEGLSurface1);
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
  
  public final void Ta(int paramInt)
  {
    j localj = this.ARD;
    if (localj != null) {
      localj.ysY = paramInt;
    }
  }
  
  public final void a(final com.tencent.mm.media.f.d paramd)
  {
    if (paramd != null) {
      i((a)new e(this, paramd));
    }
  }
  
  public final void a(e parame, int paramInt)
  {
    if (paramInt == 0)
    {
      this.ARB = parame;
      return;
    }
    this.ARC = parame;
  }
  
  public abstract void a(f paramf, com.tencent.mm.compatible.deviceinfo.ac paramac, Integer paramInteger, Boolean paramBoolean);
  
  public abstract void a(d.g.a.b<? super b, y> paramb, f paramf);
  
  public final void b(com.tencent.mm.media.f.d paramd)
  {
    k.h(paramd, "texture");
    if (this.ARz)
    {
      j localj = this.ARD;
      if (localj != null) {
        localj.gqX = paramd.gRW;
      }
      i((a)new d(this));
    }
  }
  
  public final void b(e parame, int paramInt)
  {
    if (parame != null)
    {
      com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.WindowSurfaceRenderer", "add render surface renderSide " + paramInt + " and :" + parame, new Object[0]);
      if (paramInt == 0)
      {
        this.ARB = parame;
        return;
      }
      this.ARC = parame;
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WindowSurfaceRenderer", "add a null surface");
  }
  
  public final void c(e parame, int paramInt)
  {
    i((a)new b.i(this, parame, paramInt));
  }
  
  public final void enc()
  {
    com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.WindowSurfaceRenderer", "switchRenderSurface", new Object[0]);
    i((a)new h(this));
  }
  
  public final void ene()
  {
    i((a)new f(this));
  }
  
  public final void enf()
  {
    i((a)new g(this));
  }
  
  public final void i(a<y> parama)
  {
    k.h(parama, "callback");
    if (this.gSR.isAlive())
    {
      ao localao = this.handler;
      if (localao != null) {
        localao.post((Runnable)new c(parama));
      }
    }
  }
  
  public final void release()
  {
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WindowSurfaceRenderer", "onSurfaceTextureDestroyed");
    ao localao = this.handler;
    if (localao != null) {
      localao.removeCallbacksAndMessages(null);
    }
    i((a)new c(this));
  }
  
  public abstract void ta(boolean paramBoolean);
  
  public final void tb(final boolean paramBoolean)
  {
    i((a)new b(this, paramBoolean));
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<y>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<y>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<y>
  {
    e(b paramb, com.tencent.mm.media.f.d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<y>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements a<y>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements a<y>
  {
    h(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.b
 * JD-Core Version:    0.7.0.1
 */