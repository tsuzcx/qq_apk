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
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.b;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "", "width", "", "height", "(II)V", "beautyParam", "dataCallbackList", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "externalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "faceBeautyAlgorithm", "getFaceBeautyAlgorithm", "()I", "setFaceBeautyAlgorithm", "(I)V", "fboCallbackList", "Lkotlin/Function1;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHeight", "setHeight", "initCallback", "isRelease", "", "logFrameAvailable", "mDrawPerFrameStartTimes", "", "mIsRenderLocal", "mLocalRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "mRemoteRenderSurface", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "Lkotlin/ParameterName;", "name", "cost", "getOnDrawProcPerFrameCost", "()Lkotlin/jvm/functions/Function1;", "setOnDrawProcPerFrameCost", "(Lkotlin/jvm/functions/Function1;)V", "pauseRender", "postInit", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "renderThread", "Landroid/os/HandlerThread;", "rendering", "rotateRenderDegree", "getRotateRenderDegree", "()Ljava/lang/Integer;", "setRotateRenderDegree", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getWidth", "setWidth", "addFBOAvailableCallback", "callback", "addFrameDataCallback", "addRenderSurface", "renderSide", "checkInit", "choiceRenderSurface", "createContext", "destroy", "getFaceBeautyType", "getGLContext", "Landroid/opengl/EGLContext;", "getOutputExternalTexture", "makeOutputSurface", "onPreviewTextureFrameAvailable", "onRendererFrameAvailable", "queue", "removeSurface", "renderImpl", "setLocalRenderOrientation", "rotateDegree", "setVoIPBeauty", "cmd", "start", "stop", "switchRenderSurface", "switchRenderSurfaceToBeauty", "updateDrawViewSize", "outputSurface", "updatePboAndWindowsSize", "cameraSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "mIsMirror", "Companion", "plugin-voip_release"})
public final class g
{
  public static final g.a Csf;
  private int CnM;
  private long CnX;
  f CrA;
  private boolean CrF;
  public k CrV;
  private com.tencent.mm.media.g.d CrW;
  boolean CrX;
  private boolean CrY;
  private b<? super g, z> CrZ;
  d.g.a.a<z> Cru;
  b<? super Long, z> Crv;
  private boolean Crx;
  f Crz;
  ArrayList<r<ByteBuffer, Integer, Integer, Integer, z>> Csa;
  ArrayList<b<com.tencent.mm.media.g.d, z>> Csb;
  private boolean Csc;
  int Csd;
  public Integer Cse;
  ap handler;
  int height;
  private boolean hju;
  private final HandlerThread hkS;
  c.b huo;
  Surface surface;
  SurfaceTexture surfaceTexture;
  int width;
  
  static
  {
    AppMethodBeat.i(216149);
    Csf = new g.a((byte)0);
    AppMethodBeat.o(216149);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216148);
    this.width = paramInt1;
    this.height = paramInt2;
    Object localObject = com.tencent.e.c.d.gZ("PboSurfaceRender_renderThread_" + hashCode(), 5);
    p.g(localObject, "SpecialThreadFactory.cre…}\", Thread.NORM_PRIORITY)");
    this.hkS = ((HandlerThread)localObject);
    this.Csa = new ArrayList();
    this.Csb = new ArrayList();
    this.CnX = -1L;
    this.CrF = true;
    this.hkS.start();
    this.handler = new ap(this.hkS.getLooper());
    this.Crx = false;
    this.hju = false;
    this.CnM = -1;
    localObject = this.CrV;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((com.tencent.mm.media.j.b.a)localObject).hnk);; localObject = null)
    {
      this.Cse = ((Integer)localObject);
      AppMethodBeat.o(216148);
      return;
    }
  }
  
  private final boolean a(f paramf)
  {
    EGLContext localEGLContext = null;
    AppMethodBeat.i(216147);
    try
    {
      if (this.huo != null)
      {
        Object localObject2 = new StringBuilder("eGl display= ");
        localObject1 = this.huo;
        if (localObject1 != null)
        {
          localObject1 = ((c.b)localObject1).hoQ;
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglContext=");
          localObject1 = this.huo;
          if (localObject1 == null) {
            break label219;
          }
          localObject1 = ((c.b)localObject1).hoR;
          label69:
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglSurface=");
          localObject1 = this.huo;
          if (localObject1 == null) {
            break label224;
          }
          localObject1 = ((c.b)localObject1).eglSurface;
          label97:
          ad.i("MicroMsg.PboSurfaceRender", localObject1 + " and current surface is " + paramf);
          localObject1 = c.hoP;
          localObject1 = this.huo;
          if (localObject1 == null) {
            p.gfZ();
          }
          paramf.a(c.a.a(((c.b)localObject1).hoQ, paramf.CrS));
          localObject1 = this.huo;
          if (localObject1 == null) {
            break label229;
          }
        }
        label219:
        label224:
        label229:
        for (localObject1 = ((c.b)localObject1).hoQ;; localObject1 = null)
        {
          localObject2 = paramf.eBi();
          EGLSurface localEGLSurface2 = paramf.eBi();
          c.b localb = this.huo;
          if (localb != null) {
            localEGLContext = localb.hoR;
          }
          EGL14.eglMakeCurrent((EGLDisplay)localObject1, (EGLSurface)localObject2, localEGLSurface2, localEGLContext);
          AppMethodBeat.o(216147);
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
      p.g(localObject1, "EGL14.EGL_NO_SURFACE");
      paramf.a((EGLSurface)localObject1);
      AppMethodBeat.o(216147);
      return false;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.PboSurfaceRender", "can't create eglSurface");
      EGLSurface localEGLSurface1 = EGL14.EGL_NO_SURFACE;
      p.g(localEGLSurface1, "EGL14.EGL_NO_SURFACE");
      paramf.a(localEGLSurface1);
      AppMethodBeat.o(216147);
    }
    return false;
  }
  
  private final void aue()
  {
    AppMethodBeat.i(216143);
    Object localObject1 = this.surfaceTexture;
    if (localObject1 != null)
    {
      if (this.CrY)
      {
        AppMethodBeat.o(216143);
        return;
      }
      try
      {
        ((SurfaceTexture)localObject1).updateTexImage();
        if (eBe() != 0) {
          break label284;
        }
        if (this.CrF)
        {
          localObject1 = this.Crz;
          if ((localObject1 == null) || (!this.Crx)) {
            break label277;
          }
          if ((((f)localObject1).eBi() != EGL14.EGL_NO_SURFACE) || (a((f)localObject1))) {
            break label117;
          }
          AppMethodBeat.o(216143);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.PboSurfaceRender", (Throwable)localException, "updateTexImage error", new Object[0]);
          continue;
          localObject2 = this.CrA;
        }
        label117:
        this.CnX = bt.HI();
        Object localObject3 = this.CrV;
        if (localObject3 != null) {
          ((k)localObject3).cT(((f)localObject2).CrT.width, ((f)localObject2).CrT.height);
        }
        localObject3 = this.CrV;
        if (localObject3 != null) {
          ((k)localObject3).ams();
        }
        localObject3 = c.hoP;
        localObject3 = this.huo;
        if (localObject3 != null) {}
        for (localObject3 = ((c.b)localObject3).hoQ;; localObject3 = null)
        {
          c.a.a((EGLDisplay)localObject3, ((f)localObject2).eBi());
          if (this.Cru == null) {
            break;
          }
          GLES30.glFinish();
          localObject2 = this.Cru;
          if (localObject2 != null) {
            ((d.g.a.a)localObject2).invoke();
          }
          this.Cru = null;
          AppMethodBeat.o(216143);
          return;
        }
        GLES30.glFinish();
        localObject2 = this.Crv;
        if (localObject2 != null)
        {
          ((b)localObject2).invoke(Long.valueOf(bt.aO(this.CnX)));
          AppMethodBeat.o(216143);
          return;
        }
        AppMethodBeat.o(216143);
        return;
      }
      label277:
      AppMethodBeat.o(216143);
      return;
      label284:
      this.CnX = bt.HI();
      Object localObject2 = this.CrV;
      if (localObject2 != null) {
        ((k)localObject2).ams();
      }
      localObject2 = this.Crv;
      if (localObject2 != null)
      {
        ((b)localObject2).invoke(Long.valueOf(bt.aO(this.CnX)));
        AppMethodBeat.o(216143);
        return;
      }
      AppMethodBeat.o(216143);
      return;
    }
    AppMethodBeat.o(216143);
  }
  
  public final void UW(final int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(216144);
    ad.i("MicroMsg.PboSurfaceRender", "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt) });
    this.CnM = paramInt;
    int i;
    if ((this.CnM & 0x8) != 0)
    {
      i = 1;
      if ((this.CnM == 0) || (i != 0)) {
        break label100;
      }
      ad.i("MicroMsg.PboSurfaceRender", "render YT face-beauty algorithm");
      i = 2;
    }
    for (;;)
    {
      this.Csd = i;
      i((d.g.a.a)new j(this, paramInt));
      AppMethodBeat.o(216144);
      return;
      i = 0;
      break;
      label100:
      if ((i != 0) && ((this.CnM & 0x8) != 0))
      {
        ad.i("MicroMsg.PboSurfaceRender", "render WC face-beauty algorithm");
        i = j;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void eBb()
  {
    AppMethodBeat.i(216146);
    ad.m("MicroMsg.PboSurfaceRender", "switchRenderSurface", new Object[0]);
    i((d.g.a.a)new m(this));
    AppMethodBeat.o(216146);
  }
  
  public final int eBe()
  {
    k localk = this.CrV;
    if (localk != null) {
      return localk.Ctc;
    }
    return 0;
  }
  
  public final void i(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(216145);
    p.h(parama, "callback");
    if (this.hkS.isAlive())
    {
      ap localap = this.handler;
      if (localap != null)
      {
        localap.post((Runnable)new h(parama));
        AppMethodBeat.o(216145);
        return;
      }
    }
    AppMethodBeat.o(216145);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(g paramg, b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/PboSurfaceRender$createContext$3$1"})
  static final class d
    implements SurfaceTexture.OnFrameAvailableListener
  {
    d(g paramg) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(216131);
      g.i(this.Csg);
      if (this.Csg.eBe() != 0) {
        g.j(this.Csg);
      }
      AppMethodBeat.o(216131);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<z>
  {
    j(g paramg, int paramInt)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<z>
  {
    k(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<z>
  {
    l(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<z>
  {
    m(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements d.g.a.a<z>
  {
    n(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.g
 * JD-Core Version:    0.7.0.1
 */