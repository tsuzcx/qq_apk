package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "", "mIsRenderLocal", "", "hashCode", "", "(ZI)V", "canRender", "getCanRender", "()Z", "setCanRender", "(Z)V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHashCode", "()I", "setHashCode", "(I)V", "inputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getInputTexture", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setInputTexture", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "isRelease", "mDrawPerFrameStartTimes", "", "getMDrawPerFrameStartTimes", "()J", "setMDrawPerFrameStartTimes", "(J)V", "mLocalRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "mRemoteRenderSurface", "mShareHeight", "getMShareHeight", "setMShareHeight", "mShareWidth", "getMShareWidth", "setMShareWidth", "onDrawPrcoEndYUVCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cost", "", "getOnDrawPrcoEndYUVCallback", "()Lkotlin/jvm/functions/Function1;", "setOnDrawPrcoEndYUVCallback", "(Lkotlin/jvm/functions/Function1;)V", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "getOnDrawProcPerFrameCost", "setOnDrawProcPerFrameCost", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "getRenderProc", "()Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "setRenderProc", "(Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;)V", "renderSide", "getRenderSide", "setRenderSide", "renderThread", "Landroid/os/HandlerThread;", "rendering", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "addRenderSurface", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "choiceRenderSurface", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "h", "flag", "", "makeOutputSurface", "queue", "release", "removeSurface", "render", "requestRender", "texture", "setInputExternalTexture", "setShowMode", "mode", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "rotateDegree", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public abstract class b
{
  public static final b.a zyR = new b.a((byte)0);
  private int aFj;
  c.b gBJ;
  private boolean gqu;
  private final HandlerThread gsj;
  private ap handler;
  Surface surface;
  SurfaceTexture surfaceTexture;
  long zvM;
  public com.tencent.mm.media.f.d zwD;
  public a<y> zyF;
  d.g.a.b<? super Long, y> zyG;
  d.g.a.b<? super Long, y> zyH;
  private boolean zyI;
  boolean zyJ;
  private e zyK;
  private e zyL;
  public j zyM;
  int zyN;
  int zyO;
  int zyP;
  private boolean zyQ;
  
  public b(boolean paramBoolean, int paramInt)
  {
    this.zyQ = paramBoolean;
    this.aFj = paramInt;
    this.zvM = -1L;
    HandlerThread localHandlerThread = com.tencent.e.c.d.gx("WindowSurfaceRenderer_renderThread_" + this.aFj, 5);
    k.g(localHandlerThread, "SpecialThreadFactory.cre…e\", Thread.NORM_PRIORITY)");
    this.gsj = localHandlerThread;
    this.gsj.start();
    this.handler = new ap(this.gsj.getLooper());
    this.zyI = false;
    this.gqu = false;
    if (this.zyQ) {}
    for (paramInt = i;; paramInt = 1)
    {
      this.zyP = paramInt;
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
        if (this.gBJ != null)
        {
          Object localObject2 = new StringBuilder("eGl display= ");
          localObject1 = this.gBJ;
          if (localObject1 != null)
          {
            localObject1 = ((c.b)localObject1).gwm;
            localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglContext=");
            localObject1 = this.gBJ;
            if (localObject1 == null) {
              break label253;
            }
            localObject1 = ((c.b)localObject1).gwo;
            localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglSurface=");
            localObject1 = this.gBJ;
            if (localObject1 == null) {
              break label258;
            }
            localObject1 = ((c.b)localObject1).eglSurface;
            ad.i("MicroMsg.WindowSurfaceRenderer", localObject1 + " and current surface is " + parame);
            localObject1 = com.tencent.mm.media.j.c.gwl;
            localObject1 = this.gBJ;
            if (localObject1 == null) {
              k.fvU();
            }
            parame.a(c.a.a(((c.b)localObject1).gwm, parame.zzB));
            localObject1 = this.gBJ;
            if (localObject1 == null) {
              break label263;
            }
            localObject1 = ((c.b)localObject1).gwm;
            localObject2 = parame.dXO();
            EGLSurface localEGLSurface2 = parame.dXO();
            c.b localb = this.gBJ;
            if (localb != null) {
              localEGLContext = localb.gwo;
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
        ad.w("MicroMsg.WindowSurfaceRenderer", "can't create eglSurface");
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
  
  public final void QR(int paramInt)
  {
    j localj = this.zyM;
    if (localj != null) {
      localj.xgk = paramInt;
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
      this.zyK = parame;
      return;
    }
    this.zyL = parame;
  }
  
  public abstract void a(f paramf, ac paramac, Integer paramInteger, Boolean paramBoolean);
  
  public abstract void a(d.g.a.b<? super b, y> paramb, f paramf);
  
  public final void b(com.tencent.mm.media.f.d paramd)
  {
    k.h(paramd, "texture");
    if (this.zyI)
    {
      j localj = this.zyM;
      if (localj != null) {
        localj.guC = paramd.gro;
      }
      i((a)new d(this));
    }
  }
  
  public final void b(e parame, int paramInt)
  {
    if (parame != null)
    {
      ad.m("MicroMsg.WindowSurfaceRenderer", "add render surface renderSide " + paramInt + " and :" + parame, new Object[0]);
      if (paramInt == 0)
      {
        this.zyK = parame;
        return;
      }
      this.zyL = parame;
      return;
    }
    ad.e("MicroMsg.WindowSurfaceRenderer", "add a null surface");
  }
  
  public final void c(e parame, int paramInt)
  {
    if (parame != null)
    {
      ad.i("MicroMsg.WindowSurfaceRenderer", "remove render surface :".concat(String.valueOf(parame)));
      Object localObject = this.gBJ;
      if (localObject != null)
      {
        localObject = ((c.b)localObject).gwm;
        if (localObject != null)
        {
          if (!(k.g(parame.dXO(), EGL14.EGL_NO_SURFACE) ^ true)) {
            break label96;
          }
          localObject = this.gBJ;
          if (localObject == null) {
            break label91;
          }
        }
      }
      label91:
      for (localObject = ((c.b)localObject).gwm;; localObject = null)
      {
        EGL14.eglDestroySurface((EGLDisplay)localObject, parame.dXO());
        if (paramInt != 0) {
          break label143;
        }
        this.zyK = null;
        return;
        localObject = null;
        break;
      }
      label96:
      parame = this.gBJ;
      if (parame != null)
      {
        parame = parame.gwm;
        label110:
        localObject = this.gBJ;
        if (localObject == null) {
          break label138;
        }
      }
      label138:
      for (localObject = ((c.b)localObject).eglSurface;; localObject = null)
      {
        EGL14.eglDestroySurface(parame, (EGLSurface)localObject);
        break;
        parame = null;
        break label110;
      }
      label143:
      this.zyL = null;
      return;
    }
    ad.e("MicroMsg.WindowSurfaceRenderer", "remove a null surface");
  }
  
  public final void dXH()
  {
    ad.m("MicroMsg.WindowSurfaceRenderer", "switchRenderSurface", new Object[0]);
    i((a)new h(this));
  }
  
  public final void dXI()
  {
    i((a)new f(this));
  }
  
  public final void dXJ()
  {
    i((a)new g(this));
  }
  
  public final void i(a<y> parama)
  {
    k.h(parama, "callback");
    if (this.gsj.isAlive())
    {
      ap localap = this.handler;
      if (localap != null) {
        localap.post((Runnable)new c(parama));
      }
    }
  }
  
  public abstract void rZ(boolean paramBoolean);
  
  public final void release()
  {
    ad.i("MicroMsg.WindowSurfaceRenderer", "onSurfaceTextureDestroyed");
    ap localap = this.handler;
    if (localap != null) {
      localap.removeCallbacksAndMessages(null);
    }
    i((a)new c(this));
  }
  
  public final void sa(final boolean paramBoolean)
  {
    i((a)new b(this, paramBoolean));
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<y>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<y>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<y>
  {
    e(b paramb, com.tencent.mm.media.f.d paramd)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<y>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements a<y>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.b
 * JD-Core Version:    0.7.0.1
 */