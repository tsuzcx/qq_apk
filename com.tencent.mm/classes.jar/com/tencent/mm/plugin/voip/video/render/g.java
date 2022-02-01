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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.b;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "", "width", "", "height", "(II)V", "beautyParam", "dataCallbackList", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "externalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "faceBeautyAlgorithm", "getFaceBeautyAlgorithm", "()I", "setFaceBeautyAlgorithm", "(I)V", "fboCallbackList", "Lkotlin/Function1;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHeight", "setHeight", "initCallback", "isRelease", "", "logFrameAvailable", "mDrawPerFrameStartTimes", "", "mIsRenderLocal", "mLocalRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "mRemoteRenderSurface", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "Lkotlin/ParameterName;", "name", "cost", "getOnDrawProcPerFrameCost", "()Lkotlin/jvm/functions/Function1;", "setOnDrawProcPerFrameCost", "(Lkotlin/jvm/functions/Function1;)V", "pauseRender", "postInit", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "renderThread", "Landroid/os/HandlerThread;", "rendering", "rotateRenderDegree", "getRotateRenderDegree", "()Ljava/lang/Integer;", "setRotateRenderDegree", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getWidth", "setWidth", "addFBOAvailableCallback", "callback", "addFrameDataCallback", "addRenderSurface", "renderSide", "checkInit", "choiceRenderSurface", "createContext", "destroy", "getFaceBeautyType", "getGLContext", "Landroid/opengl/EGLContext;", "getOutputExternalTexture", "makeOutputSurface", "onPreviewTextureFrameAvailable", "onRendererFrameAvailable", "queue", "removeSurface", "renderImpl", "setLocalRenderOrientation", "rotateDegree", "setVoIPBeauty", "cmd", "start", "stop", "switchRenderSurface", "switchRenderSurfaceToBeauty", "updateDrawViewSize", "outputSurface", "updatePboAndWindowsSize", "cameraSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "mIsMirror", "Companion", "plugin-voip_release"})
public final class g
{
  public static final g.a CJJ;
  private long CFB;
  private int CFq;
  d.g.a.a<z> CIY;
  b<? super Long, z> CIZ;
  private com.tencent.mm.media.g.d CJA;
  boolean CJB;
  private boolean CJC;
  private b<? super g, z> CJD;
  ArrayList<r<ByteBuffer, Integer, Integer, Integer, z>> CJE;
  ArrayList<b<com.tencent.mm.media.g.d, z>> CJF;
  private boolean CJG;
  int CJH;
  public Integer CJI;
  private boolean CJb;
  f CJd;
  f CJe;
  private boolean CJj;
  public k CJz;
  aq handler;
  int height;
  private boolean hmi;
  private final HandlerThread hnG;
  c.b hxc;
  Surface surface;
  SurfaceTexture surfaceTexture;
  int width;
  
  static
  {
    AppMethodBeat.i(210570);
    CJJ = new g.a((byte)0);
    AppMethodBeat.o(210570);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210569);
    this.width = paramInt1;
    this.height = paramInt2;
    Object localObject = com.tencent.e.c.d.hi("PboSurfaceRender_renderThread_" + hashCode(), 5);
    p.g(localObject, "SpecialThreadFactory.cre…}\", Thread.NORM_PRIORITY)");
    this.hnG = ((HandlerThread)localObject);
    this.CJE = new ArrayList();
    this.CJF = new ArrayList();
    this.CFB = -1L;
    this.CJj = true;
    this.hnG.start();
    this.handler = new aq(this.hnG.getLooper());
    this.CJb = false;
    this.hmi = false;
    this.CFq = -1;
    localObject = this.CJz;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((com.tencent.mm.media.j.b.a)localObject).hpY);; localObject = null)
    {
      this.CJI = ((Integer)localObject);
      AppMethodBeat.o(210569);
      return;
    }
  }
  
  private final boolean a(f paramf)
  {
    EGLContext localEGLContext = null;
    AppMethodBeat.i(210568);
    try
    {
      if (this.hxc != null)
      {
        Object localObject2 = new StringBuilder("eGl display= ");
        localObject1 = this.hxc;
        if (localObject1 != null)
        {
          localObject1 = ((c.b)localObject1).hrE;
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglContext=");
          localObject1 = this.hxc;
          if (localObject1 == null) {
            break label219;
          }
          localObject1 = ((c.b)localObject1).hrF;
          label69:
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglSurface=");
          localObject1 = this.hxc;
          if (localObject1 == null) {
            break label224;
          }
          localObject1 = ((c.b)localObject1).eglSurface;
          label97:
          ae.i("MicroMsg.PboSurfaceRender", localObject1 + " and current surface is " + paramf);
          localObject1 = c.hrD;
          localObject1 = this.hxc;
          if (localObject1 == null) {
            p.gkB();
          }
          paramf.a(c.a.a(((c.b)localObject1).hrE, paramf.CJw));
          localObject1 = this.hxc;
          if (localObject1 == null) {
            break label229;
          }
        }
        label219:
        label224:
        label229:
        for (localObject1 = ((c.b)localObject1).hrE;; localObject1 = null)
        {
          localObject2 = paramf.eEQ();
          EGLSurface localEGLSurface2 = paramf.eEQ();
          c.b localb = this.hxc;
          if (localb != null) {
            localEGLContext = localb.hrF;
          }
          EGL14.eglMakeCurrent((EGLDisplay)localObject1, (EGLSurface)localObject2, localEGLSurface2, localEGLContext);
          AppMethodBeat.o(210568);
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
      AppMethodBeat.o(210568);
      return false;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.PboSurfaceRender", "can't create eglSurface");
      EGLSurface localEGLSurface1 = EGL14.EGL_NO_SURFACE;
      p.g(localEGLSurface1, "EGL14.EGL_NO_SURFACE");
      paramf.a(localEGLSurface1);
      AppMethodBeat.o(210568);
    }
    return false;
  }
  
  private final void aut()
  {
    AppMethodBeat.i(210564);
    Object localObject1 = this.surfaceTexture;
    if (localObject1 != null)
    {
      if (this.CJC)
      {
        AppMethodBeat.o(210564);
        return;
      }
      try
      {
        ((SurfaceTexture)localObject1).updateTexImage();
        if (eEM() != 0) {
          break label284;
        }
        if (this.CJj)
        {
          localObject1 = this.CJd;
          if ((localObject1 == null) || (!this.CJb)) {
            break label277;
          }
          if ((((f)localObject1).eEQ() != EGL14.EGL_NO_SURFACE) || (a((f)localObject1))) {
            break label117;
          }
          AppMethodBeat.o(210564);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.PboSurfaceRender", (Throwable)localException, "updateTexImage error", new Object[0]);
          continue;
          localObject2 = this.CJe;
        }
        label117:
        this.CFB = bu.HQ();
        Object localObject3 = this.CJz;
        if (localObject3 != null) {
          ((k)localObject3).cT(((f)localObject2).CJx.width, ((f)localObject2).CJx.height);
        }
        localObject3 = this.CJz;
        if (localObject3 != null) {
          ((k)localObject3).amH();
        }
        localObject3 = c.hrD;
        localObject3 = this.hxc;
        if (localObject3 != null) {}
        for (localObject3 = ((c.b)localObject3).hrE;; localObject3 = null)
        {
          c.a.a((EGLDisplay)localObject3, ((f)localObject2).eEQ());
          if (this.CIY == null) {
            break;
          }
          GLES30.glFinish();
          localObject2 = this.CIY;
          if (localObject2 != null) {
            ((d.g.a.a)localObject2).invoke();
          }
          this.CIY = null;
          AppMethodBeat.o(210564);
          return;
        }
        GLES30.glFinish();
        localObject2 = this.CIZ;
        if (localObject2 != null)
        {
          ((b)localObject2).invoke(Long.valueOf(bu.aO(this.CFB)));
          AppMethodBeat.o(210564);
          return;
        }
        AppMethodBeat.o(210564);
        return;
      }
      label277:
      AppMethodBeat.o(210564);
      return;
      label284:
      this.CFB = bu.HQ();
      Object localObject2 = this.CJz;
      if (localObject2 != null) {
        ((k)localObject2).amH();
      }
      localObject2 = this.CIZ;
      if (localObject2 != null)
      {
        ((b)localObject2).invoke(Long.valueOf(bu.aO(this.CFB)));
        AppMethodBeat.o(210564);
        return;
      }
      AppMethodBeat.o(210564);
      return;
    }
    AppMethodBeat.o(210564);
  }
  
  public final void VD(final int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(210565);
    ae.i("MicroMsg.PboSurfaceRender", "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt) });
    this.CFq = paramInt;
    int i;
    if ((this.CFq & 0x8) != 0)
    {
      i = 1;
      if ((this.CFq == 0) || (i != 0)) {
        break label100;
      }
      ae.i("MicroMsg.PboSurfaceRender", "render YT face-beauty algorithm");
      i = 2;
    }
    for (;;)
    {
      this.CJH = i;
      j((d.g.a.a)new j(this, paramInt));
      AppMethodBeat.o(210565);
      return;
      i = 0;
      break;
      label100:
      if ((i != 0) && ((this.CFq & 0x8) != 0))
      {
        ae.i("MicroMsg.PboSurfaceRender", "render WC face-beauty algorithm");
        i = j;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void eEJ()
  {
    AppMethodBeat.i(210567);
    ae.m("MicroMsg.PboSurfaceRender", "switchRenderSurface", new Object[0]);
    j((d.g.a.a)new m(this));
    AppMethodBeat.o(210567);
  }
  
  public final int eEM()
  {
    k localk = this.CJz;
    if (localk != null) {
      return localk.CKG;
    }
    return 0;
  }
  
  public final void j(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(210566);
    p.h(parama, "callback");
    if (this.hnG.isAlive())
    {
      aq localaq = this.handler;
      if (localaq != null)
      {
        localaq.post((Runnable)new h(parama));
        AppMethodBeat.o(210566);
        return;
      }
    }
    AppMethodBeat.o(210566);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(g paramg, b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/PboSurfaceRender$createContext$3$1"})
  static final class d
    implements SurfaceTexture.OnFrameAvailableListener
  {
    d(g paramg) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(210552);
      g.i(this.CJK);
      if (this.CJK.eEM() != 0) {
        g.j(this.CJK);
      }
      AppMethodBeat.o(210552);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dataBuffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class f
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, z>
  {
    f(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(210555);
      b localb = g.b(this.CJK);
      if (localb != null)
      {
        localb.invoke(this.CJK);
        AppMethodBeat.o(210555);
        return;
      }
      AppMethodBeat.o(210555);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<z>
  {
    i(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<z>
  {
    j(g paramg, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<z>
  {
    k(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<z>
  {
    l(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<z>
  {
    m(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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