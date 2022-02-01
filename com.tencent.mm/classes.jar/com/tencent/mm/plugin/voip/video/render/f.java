package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES30;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.b;
import d.g.a.q;
import d.g.b.k;
import d.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "", "width", "", "height", "(II)V", "beautyParam", "dataCallbackList", "Ljava/util/ArrayList;", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "", "Lkotlin/collections/ArrayList;", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "externalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "faceBeautyAlgorithm", "getFaceBeautyAlgorithm", "()I", "setFaceBeautyAlgorithm", "(I)V", "fboCallbackList", "Lkotlin/Function1;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHeight", "setHeight", "initCallback", "isRelease", "", "logFrameAvailable", "mDrawPerFrameStartTimes", "", "mIsRenderLocal", "mLocalRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "mRemoteRenderSurface", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "Lkotlin/ParameterName;", "name", "cost", "getOnDrawProcPerFrameCost", "()Lkotlin/jvm/functions/Function1;", "setOnDrawProcPerFrameCost", "(Lkotlin/jvm/functions/Function1;)V", "pauseRender", "postInit", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "renderThread", "Landroid/os/HandlerThread;", "rendering", "rotateRenderDegree", "getRotateRenderDegree", "()Ljava/lang/Integer;", "setRotateRenderDegree", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getWidth", "setWidth", "addFBOAvailableCallback", "callback", "addFrameDataCallback", "buffer", "addRenderSurface", "renderSide", "checkInit", "choiceRenderSurface", "createContext", "destroy", "getFaceBeautyType", "getGLContext", "Landroid/opengl/EGLContext;", "getOutputExternalTexture", "makeOutputSurface", "onPreviewTextureFrameAvailable", "onRendererFrameAvailable", "queue", "removeSurface", "renderImpl", "setLocalRenderOrientation", "rotateDegree", "setVoIPBeauty", "cmd", "start", "stop", "switchRenderSurface", "switchRenderSurfaceToBeauty", "updateDrawViewSize", "outputSurface", "updatePboAndWindowsSize", "cameraSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "mIsMirror", "Companion", "plugin-voip_release"})
public final class f
{
  public static final f.a ASf;
  private long AOD;
  private int AOs;
  e ARB;
  e ARC;
  private boolean ARH;
  public i ARV;
  private com.tencent.mm.media.f.d ARW;
  boolean ARX;
  private boolean ARY;
  private b<? super f, y> ARZ;
  d.g.a.a<y> ARw;
  b<? super Long, y> ARx;
  private boolean ARz;
  ArrayList<q<ByteBuffer, Integer, Integer, y>> ASa;
  ArrayList<b<com.tencent.mm.media.f.d, y>> ASb;
  private boolean ASc;
  int ASd;
  public Integer ASe;
  private boolean gRc;
  private final HandlerThread gSR;
  ao handler;
  c.b hcg;
  int height;
  Surface surface;
  SurfaceTexture surfaceTexture;
  int width;
  
  static
  {
    AppMethodBeat.i(208787);
    ASf = new f.a((byte)0);
    AppMethodBeat.o(208787);
  }
  
  public f(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208786);
    this.width = paramInt1;
    this.height = paramInt2;
    Object localObject = com.tencent.e.c.d.gB("PboSurfaceRender_renderThread_" + hashCode(), 5);
    k.g(localObject, "SpecialThreadFactory.cre…}\", Thread.NORM_PRIORITY)");
    this.gSR = ((HandlerThread)localObject);
    this.ASa = new ArrayList();
    this.ASb = new ArrayList();
    this.AOD = -1L;
    this.ARH = true;
    this.gSR.start();
    this.handler = new ao(this.gSR.getLooper());
    this.ARz = false;
    this.gRc = false;
    this.AOs = -1;
    localObject = this.ARV;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((com.tencent.mm.media.i.b.a)localObject).gVh);; localObject = null)
    {
      this.ASe = ((Integer)localObject);
      AppMethodBeat.o(208786);
      return;
    }
  }
  
  private final boolean a(e parame)
  {
    EGLContext localEGLContext = null;
    AppMethodBeat.i(208785);
    try
    {
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
            break label219;
          }
          localObject1 = ((c.b)localObject1).gWL;
          label69:
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglSurface=");
          localObject1 = this.hcg;
          if (localObject1 == null) {
            break label224;
          }
          localObject1 = ((c.b)localObject1).eglSurface;
          label97:
          ac.i("MicroMsg.PboSurfaceRender", localObject1 + " and current surface is " + parame);
          localObject1 = c.gWJ;
          localObject1 = this.hcg;
          if (localObject1 == null) {
            k.fOy();
          }
          parame.a(c.a.a(((c.b)localObject1).gWK, parame.ARS));
          localObject1 = this.hcg;
          if (localObject1 == null) {
            break label229;
          }
        }
        label219:
        label224:
        label229:
        for (localObject1 = ((c.b)localObject1).gWK;; localObject1 = null)
        {
          localObject2 = parame.enk();
          EGLSurface localEGLSurface2 = parame.enk();
          c.b localb = this.hcg;
          if (localb != null) {
            localEGLContext = localb.gWL;
          }
          EGL14.eglMakeCurrent((EGLDisplay)localObject1, (EGLSurface)localObject2, localEGLSurface2, localEGLContext);
          AppMethodBeat.o(208785);
          return true;
          localObject1 = null;
          break;
          localObject1 = null;
          break label69;
          localObject1 = null;
          break label97;
        }
      }
      Object localObject1 = EGL14.EGL_NO_SURFACE;
      k.g(localObject1, "EGL14.EGL_NO_SURFACE");
      parame.a((EGLSurface)localObject1);
      AppMethodBeat.o(208785);
      return false;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.PboSurfaceRender", "can't create eglSurface");
      EGLSurface localEGLSurface1 = EGL14.EGL_NO_SURFACE;
      k.g(localEGLSurface1, "EGL14.EGL_NO_SURFACE");
      parame.a(localEGLSurface1);
      AppMethodBeat.o(208785);
    }
    return false;
  }
  
  private final void arr()
  {
    AppMethodBeat.i(208781);
    Object localObject1 = this.surfaceTexture;
    if (localObject1 != null)
    {
      if (this.ARY)
      {
        AppMethodBeat.o(208781);
        return;
      }
      try
      {
        ((SurfaceTexture)localObject1).updateTexImage();
        if (eng() != 0) {
          break label284;
        }
        if (this.ARH)
        {
          localObject1 = this.ARB;
          if ((localObject1 == null) || (!this.ARz)) {
            break label277;
          }
          if ((((e)localObject1).enk() != EGL14.EGL_NO_SURFACE) || (a((e)localObject1))) {
            break label117;
          }
          AppMethodBeat.o(208781);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.PboSurfaceRender", (Throwable)localException, "updateTexImage error", new Object[0]);
          continue;
          localObject2 = this.ARC;
        }
        label117:
        this.AOD = bs.Gn();
        Object localObject3 = this.ARV;
        if (localObject3 != null) {
          ((i)localObject3).cR(((e)localObject2).ART.width, ((e)localObject2).ART.height);
        }
        localObject3 = this.ARV;
        if (localObject3 != null) {
          ((i)localObject3).ajG();
        }
        localObject3 = c.gWJ;
        localObject3 = this.hcg;
        if (localObject3 != null) {}
        for (localObject3 = ((c.b)localObject3).gWK;; localObject3 = null)
        {
          c.a.a((EGLDisplay)localObject3, ((e)localObject2).enk());
          if (this.ARw == null) {
            break;
          }
          GLES30.glFinish();
          localObject2 = this.ARw;
          if (localObject2 != null) {
            ((d.g.a.a)localObject2).invoke();
          }
          this.ARw = null;
          AppMethodBeat.o(208781);
          return;
        }
        GLES30.glFinish();
        localObject2 = this.ARx;
        if (localObject2 != null)
        {
          ((b)localObject2).ay(Long.valueOf(bs.aO(this.AOD)));
          AppMethodBeat.o(208781);
          return;
        }
        AppMethodBeat.o(208781);
        return;
      }
      label277:
      AppMethodBeat.o(208781);
      return;
      label284:
      this.AOD = bs.Gn();
      Object localObject2 = this.ARV;
      if (localObject2 != null) {
        ((i)localObject2).ajG();
      }
      localObject2 = this.ARx;
      if (localObject2 != null)
      {
        ((b)localObject2).ay(Long.valueOf(bs.aO(this.AOD)));
        AppMethodBeat.o(208781);
        return;
      }
      AppMethodBeat.o(208781);
      return;
    }
    AppMethodBeat.o(208781);
  }
  
  public final void Td(final int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(208782);
    ac.i("MicroMsg.PboSurfaceRender", "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt) });
    this.AOs = paramInt;
    int i;
    if ((this.AOs & 0x8) != 0)
    {
      i = 1;
      if ((this.AOs == 0) || (i != 0)) {
        break label100;
      }
      ac.i("MicroMsg.PboSurfaceRender", "render YT face-beauty algorithm");
      i = 2;
    }
    for (;;)
    {
      this.ASd = i;
      i((d.g.a.a)new j(this, paramInt));
      AppMethodBeat.o(208782);
      return;
      i = 0;
      break;
      label100:
      if ((i != 0) && ((this.AOs & 0x8) != 0))
      {
        ac.i("MicroMsg.PboSurfaceRender", "render WC face-beauty algorithm");
        i = j;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void enc()
  {
    AppMethodBeat.i(208784);
    ac.m("MicroMsg.PboSurfaceRender", "switchRenderSurface", new Object[0]);
    i((d.g.a.a)new m(this));
    AppMethodBeat.o(208784);
  }
  
  public final int eng()
  {
    i locali = this.ARV;
    if (locali != null) {
      return locali.ASU;
    }
    return 0;
  }
  
  public final void i(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(208783);
    k.h(parama, "callback");
    if (this.gSR.isAlive())
    {
      ao localao = this.handler;
      if (localao != null)
      {
        localao.post((Runnable)new g(parama));
        AppMethodBeat.o(208783);
        return;
      }
    }
    AppMethodBeat.o(208783);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(f paramf, b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/PboSurfaceRender$createContext$3$1"})
  static final class d
    implements SurfaceTexture.OnFrameAvailableListener
  {
    d(f paramf) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(208769);
      f.i(this.ASg);
      if (this.ASg.eng() != 0) {
        f.j(this.ASg);
      }
      AppMethodBeat.o(208769);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(208772);
      b localb = f.b(this.ASg);
      if (localb != null)
      {
        localb.ay(this.ASg);
        AppMethodBeat.o(208772);
        return;
      }
      AppMethodBeat.o(208772);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    j(f paramf, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    k(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    l(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    m(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    n(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.f
 * JD-Core Version:    0.7.0.1
 */