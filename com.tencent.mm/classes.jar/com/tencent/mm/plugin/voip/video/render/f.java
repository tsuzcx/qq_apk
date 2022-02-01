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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.b;
import d.g.a.q;
import d.g.b.k;
import d.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "", "width", "", "height", "(II)V", "beautyParam", "dataCallbackList", "Ljava/util/ArrayList;", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "", "Lkotlin/collections/ArrayList;", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "externalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "faceBeautyAlgorithm", "getFaceBeautyAlgorithm", "()I", "setFaceBeautyAlgorithm", "(I)V", "fboCallbackList", "Lkotlin/Function1;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHeight", "setHeight", "initCallback", "isRelease", "", "logFrameAvailable", "mDrawPerFrameStartTimes", "", "mIsRenderLocal", "mLocalRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "mRemoteRenderSurface", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "Lkotlin/ParameterName;", "name", "cost", "getOnDrawProcPerFrameCost", "()Lkotlin/jvm/functions/Function1;", "setOnDrawProcPerFrameCost", "(Lkotlin/jvm/functions/Function1;)V", "pauseRender", "postInit", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "renderThread", "Landroid/os/HandlerThread;", "rendering", "rotateRenderDegree", "getRotateRenderDegree", "()Ljava/lang/Integer;", "setRotateRenderDegree", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getWidth", "setWidth", "addFBOAvailableCallback", "callback", "addFrameDataCallback", "buffer", "addRenderSurface", "renderSide", "checkInit", "choiceRenderSurface", "createContext", "destroy", "getFaceBeautyType", "getGLContext", "Landroid/opengl/EGLContext;", "getOutputExternalTexture", "makeOutputSurface", "onPreviewTextureFrameAvailable", "onRendererFrameAvailable", "queue", "removeSurface", "renderImpl", "setLocalRenderOrientation", "rotateDegree", "setVoIPBeauty", "cmd", "start", "stop", "switchRenderSurface", "switchRenderSurfaceToBeauty", "updateDrawViewSize", "outputSurface", "updatePboAndWindowsSize", "cameraSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "mIsMirror", "Companion", "plugin-voip_release"})
public final class f
{
  public static final f.a zzO;
  c.b gBJ;
  private boolean gqu;
  private final HandlerThread gsj;
  ap handler;
  int height;
  Surface surface;
  SurfaceTexture surfaceTexture;
  int width;
  private int zvB;
  private long zvM;
  d.g.a.a<y> zyF;
  b<? super Long, y> zyG;
  private boolean zyI;
  e zyK;
  e zyL;
  private boolean zyQ;
  public i zzE;
  private com.tencent.mm.media.f.d zzF;
  boolean zzG;
  private boolean zzH;
  private b<? super f, y> zzI;
  ArrayList<q<ByteBuffer, Integer, Integer, y>> zzJ;
  ArrayList<b<com.tencent.mm.media.f.d, y>> zzK;
  private boolean zzL;
  int zzM;
  public Integer zzN;
  
  static
  {
    AppMethodBeat.i(192436);
    zzO = new f.a((byte)0);
    AppMethodBeat.o(192436);
  }
  
  public f(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192435);
    this.width = paramInt1;
    this.height = paramInt2;
    Object localObject = com.tencent.e.c.d.gx("PboSurfaceRender_renderThread_" + hashCode(), 5);
    k.g(localObject, "SpecialThreadFactory.cre…}\", Thread.NORM_PRIORITY)");
    this.gsj = ((HandlerThread)localObject);
    this.zzJ = new ArrayList();
    this.zzK = new ArrayList();
    this.zvM = -1L;
    this.zyQ = true;
    this.gsj.start();
    this.handler = new ap(this.gsj.getLooper());
    this.zyI = false;
    this.gqu = false;
    this.zvB = -1;
    localObject = this.zzE;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((com.tencent.mm.media.i.b.a)localObject).guD);; localObject = null)
    {
      this.zzN = ((Integer)localObject);
      AppMethodBeat.o(192435);
      return;
    }
  }
  
  private final boolean a(e parame)
  {
    EGLContext localEGLContext = null;
    AppMethodBeat.i(192434);
    try
    {
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
            break label219;
          }
          localObject1 = ((c.b)localObject1).gwo;
          label69:
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",eglSurface=");
          localObject1 = this.gBJ;
          if (localObject1 == null) {
            break label224;
          }
          localObject1 = ((c.b)localObject1).eglSurface;
          label97:
          ad.i("MicroMsg.PboSurfaceRender", localObject1 + " and current surface is " + parame);
          localObject1 = c.gwl;
          localObject1 = this.gBJ;
          if (localObject1 == null) {
            k.fvU();
          }
          parame.a(c.a.a(((c.b)localObject1).gwm, parame.zzB));
          localObject1 = this.gBJ;
          if (localObject1 == null) {
            break label229;
          }
        }
        label219:
        label224:
        label229:
        for (localObject1 = ((c.b)localObject1).gwm;; localObject1 = null)
        {
          localObject2 = parame.dXO();
          EGLSurface localEGLSurface2 = parame.dXO();
          c.b localb = this.gBJ;
          if (localb != null) {
            localEGLContext = localb.gwo;
          }
          EGL14.eglMakeCurrent((EGLDisplay)localObject1, (EGLSurface)localObject2, localEGLSurface2, localEGLContext);
          AppMethodBeat.o(192434);
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
      AppMethodBeat.o(192434);
      return false;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.PboSurfaceRender", "can't create eglSurface");
      EGLSurface localEGLSurface1 = EGL14.EGL_NO_SURFACE;
      k.g(localEGLSurface1, "EGL14.EGL_NO_SURFACE");
      parame.a(localEGLSurface1);
      AppMethodBeat.o(192434);
    }
    return false;
  }
  
  private final void akv()
  {
    AppMethodBeat.i(192430);
    Object localObject1 = this.surfaceTexture;
    if (localObject1 != null)
    {
      if (this.zzH)
      {
        AppMethodBeat.o(192430);
        return;
      }
      try
      {
        ((SurfaceTexture)localObject1).updateTexImage();
        if (dXK() != 0) {
          break label277;
        }
        if (this.zyQ)
        {
          localObject1 = this.zyK;
          if (localObject1 == null) {
            break label270;
          }
          if ((((e)localObject1).dXO() != EGL14.EGL_NO_SURFACE) || (a((e)localObject1))) {
            break label110;
          }
          AppMethodBeat.o(192430);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.PboSurfaceRender", (Throwable)localException, "updateTexImage error", new Object[0]);
          continue;
          localObject2 = this.zyL;
        }
        label110:
        this.zvM = bt.GC();
        Object localObject3 = this.zzE;
        if (localObject3 != null) {
          ((i)localObject3).cT(((e)localObject2).zzC.width, ((e)localObject2).zzC.height);
        }
        localObject3 = this.zzE;
        if (localObject3 != null) {
          ((i)localObject3).akk();
        }
        localObject3 = c.gwl;
        localObject3 = this.gBJ;
        if (localObject3 != null) {}
        for (localObject3 = ((c.b)localObject3).gwm;; localObject3 = null)
        {
          c.a.a((EGLDisplay)localObject3, ((e)localObject2).dXO());
          if (this.zyF == null) {
            break;
          }
          GLES30.glFinish();
          localObject2 = this.zyF;
          if (localObject2 != null) {
            ((d.g.a.a)localObject2).invoke();
          }
          this.zyF = null;
          AppMethodBeat.o(192430);
          return;
        }
        GLES30.glFinish();
        localObject2 = this.zyG;
        if (localObject2 != null)
        {
          ((b)localObject2).aA(Long.valueOf(bt.aS(this.zvM)));
          AppMethodBeat.o(192430);
          return;
        }
        AppMethodBeat.o(192430);
        return;
      }
      label270:
      AppMethodBeat.o(192430);
      return;
      label277:
      this.zvM = bt.GC();
      Object localObject2 = this.zzE;
      if (localObject2 != null) {
        ((i)localObject2).akk();
      }
      localObject2 = this.zyG;
      if (localObject2 != null)
      {
        ((b)localObject2).aA(Long.valueOf(bt.aS(this.zvM)));
        AppMethodBeat.o(192430);
        return;
      }
      AppMethodBeat.o(192430);
      return;
    }
    AppMethodBeat.o(192430);
  }
  
  public final void QU(final int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(192431);
    ad.i("MicroMsg.PboSurfaceRender", "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt) });
    this.zvB = paramInt;
    int i;
    if ((this.zvB & 0x8) != 0)
    {
      i = 1;
      if ((this.zvB == 0) || (i != 0)) {
        break label100;
      }
      ad.i("MicroMsg.PboSurfaceRender", "render YT face-beauty algorithm");
      i = 2;
    }
    for (;;)
    {
      this.zzM = i;
      i((d.g.a.a)new j(this, paramInt));
      AppMethodBeat.o(192431);
      return;
      i = 0;
      break;
      label100:
      if ((i != 0) && ((this.zvB & 0x8) != 0))
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
  
  public final void dXH()
  {
    AppMethodBeat.i(192433);
    ad.m("MicroMsg.PboSurfaceRender", "switchRenderSurface", new Object[0]);
    i((d.g.a.a)new m(this));
    AppMethodBeat.o(192433);
  }
  
  public final int dXK()
  {
    i locali = this.zzE;
    if (locali != null) {
      return locali.zAC;
    }
    return 0;
  }
  
  public final void i(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(192432);
    k.h(parama, "callback");
    if (this.gsj.isAlive())
    {
      ap localap = this.handler;
      if (localap != null)
      {
        localap.post((Runnable)new g(parama));
        AppMethodBeat.o(192432);
        return;
      }
    }
    AppMethodBeat.o(192432);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(f paramf, b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/PboSurfaceRender$createContext$3$1"})
  static final class d
    implements SurfaceTexture.OnFrameAvailableListener
  {
    d(f paramf) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(192418);
      f.i(this.zzP);
      if (this.zzP.dXK() != 0) {
        f.j(this.zzP);
      }
      AppMethodBeat.o(192418);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(192421);
      b localb = f.b(this.zzP);
      if (localb != null)
      {
        localb.aA(this.zzP);
        AppMethodBeat.o(192421);
        return;
      }
      AppMethodBeat.o(192421);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    j(f paramf, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    k(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    l(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    m(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.f
 * JD-Core Version:    0.7.0.1
 */