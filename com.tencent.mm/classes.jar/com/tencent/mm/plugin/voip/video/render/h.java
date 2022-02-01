package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.opengl.GLES30;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "", "width", "", "height", "mUseGLOpt", "", "(IIZ)V", "beautyParam", "dataCallbackList", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "encoderProgram", "Lcom/tencent/mm/plugin/voip/video/render/EncodeProgram;", "getEncoderProgram", "()Lcom/tencent/mm/plugin/voip/video/render/EncodeProgram;", "setEncoderProgram", "(Lcom/tencent/mm/plugin/voip/video/render/EncodeProgram;)V", "externalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "faceBeautyAlgorithm", "getFaceBeautyAlgorithm", "()I", "setFaceBeautyAlgorithm", "(I)V", "fboCallbackList", "Lkotlin/Function1;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHeight", "setHeight", "initCallback", "isRelease", "logFrameAvailable", "mDrawPerFrameStartTimes", "", "mIsMirror", "getMUseGLOpt", "()Z", "setMUseGLOpt", "(Z)V", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "Lkotlin/ParameterName;", "name", "cost", "getOnDrawProcPerFrameCost", "()Lkotlin/jvm/functions/Function1;", "setOnDrawProcPerFrameCost", "(Lkotlin/jvm/functions/Function1;)V", "pauseRender", "postInit", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "getRenderProc", "()Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "setRenderProc", "(Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;)V", "renderThread", "Landroid/os/HandlerThread;", "rendering", "getRendering", "setRendering", "spatiotemporalDenosingAllow", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getWidth", "setWidth", "addFBOAvailableCallback", "callback", "checkInit", "createContext", "createSurface", "glSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "eglCreateBufferSurface", "getFaceBeautyType", "getGLContext", "Landroid/opengl/EGLContext;", "getOutputExternalTexture", "getUseSTFilter", "isInRenderThread", "onPreviewTextureFrameAvailable", "onRendererFrameAvailable", "queue", "recreateSurface", "renderSide", "release", "releaseSurface", "renderImpl", "setCameraIsMirror", "mirror", "setSTFilterMotionNoiseData", "motion", "noise", "", "setSpatiotemporalDenosing", "cmd", "skipFilter", "setVoIPBeauty", "start", "stop", "switchCameraWithResumeSurface", "updatePboAndWindowsSize", "cameraSize", "Landroid/util/Size;", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h.a USD;
  private com.tencent.mm.media.g.d Lns;
  private long UNA;
  private int UNp;
  private boolean USE;
  m USF;
  private boolean USG;
  private boolean USH;
  private b<? super h, ah> USI;
  private ArrayList<r<ByteBuffer, Integer, Integer, Integer, ah>> USJ;
  private ArrayList<b<com.tencent.mm.media.g.d, ah>> USK;
  private boolean USL;
  public a USM;
  int USN;
  private int USO;
  kotlin.g.a.a<ah> USg;
  b<? super Long, ah> USh;
  boolean USj;
  private MMHandler handler;
  int height;
  c.b nFD;
  private final HandlerThread nty;
  private volatile boolean nzB;
  Surface surface;
  SurfaceTexture surfaceTexture;
  int width;
  
  static
  {
    AppMethodBeat.i(293256);
    USD = new h.a((byte)0);
    AppMethodBeat.o(293256);
  }
  
  public h(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(293100);
    this.width = paramInt1;
    this.height = paramInt2;
    this.USE = paramBoolean;
    HandlerThread localHandlerThread = com.tencent.threadpool.c.d.jy(s.X("PboSurfaceRender_renderThread_", Integer.valueOf(hashCode())), 5);
    s.s(localHandlerThread, "createRendererThread(\"Pb…}\", Thread.NORM_PRIORITY)");
    this.nty = localHandlerThread;
    this.USJ = new ArrayList();
    this.USK = new ArrayList();
    this.UNA = -1L;
    if (this.USE) {
      this.USM = new a();
    }
    this.nty.start();
    this.handler = new MMHandler(this.nty.getLooper());
    this.USj = false;
    this.nzB = false;
    AppMethodBeat.o(293100);
  }
  
  private static final void a(h paramh)
  {
    AppMethodBeat.i(293160);
    s.u(paramh, "this$0");
    b localb = paramh.USI;
    if (localb != null) {
      localb.invoke(paramh);
    }
    AppMethodBeat.o(293160);
  }
  
  private static final void a(h paramh, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(293153);
    s.u(paramh, "this$0");
    paramSurfaceTexture = com.tencent.mm.plugin.voip.d.g.UHs;
    com.tencent.mm.plugin.voip.d.g.iad();
    paramSurfaceTexture = com.tencent.mm.plugin.voip.d.a.UFW;
    com.tencent.mm.plugin.voip.d.a.hZy();
    paramh.idn();
    AppMethodBeat.o(293153);
  }
  
  private static final void bY(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(293165);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(293165);
  }
  
  private final void bqg()
  {
    AppMethodBeat.i(293124);
    Object localObject1 = this.surfaceTexture;
    if (localObject1 != null)
    {
      if (this.USH)
      {
        AppMethodBeat.o(293124);
        return;
      }
      Object localObject3 = this.Lns;
      if ((localObject3 != null) && (((com.tencent.mm.media.g.d)localObject3).nAx == true))
      {
        i = 1;
        if (i == 0)
        {
          if (!com.tencent.mm.compatible.util.d.rb(26)) {
            break label109;
          }
          localObject3 = this.surfaceTexture;
          if ((localObject3 == null) || (((SurfaceTexture)localObject3).isReleased() != true)) {
            break label104;
          }
        }
      }
      label104:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label109;
        }
        Log.e("MicroMsg.PboSurfaceRender", "render external texture is released");
        AppMethodBeat.o(293124);
        return;
        i = 0;
        break;
      }
      label562:
      label710:
      label718:
      for (;;)
      {
        label109:
        Object localObject4;
        c.b localb;
        Object localObject5;
        Object localObject2;
        try
        {
          ((SurfaceTexture)localObject1).updateTexImage();
          this.UNA = Util.currentTicks();
          localObject1 = this.USF;
          if (localObject1 != null) {
            ((m)localObject1).bgE();
          }
          GLES30.glFinish();
          localObject1 = this.USh;
          if (localObject1 != null) {
            ((b)localObject1).invoke(Long.valueOf(Util.ticksToNow(this.UNA)));
          }
          if (!this.USj) {
            break;
          }
          localObject3 = this.USK.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (b)((Iterator)localObject3).next();
          localObject1 = this.USF;
          if (localObject1 == null)
          {
            localObject1 = null;
            ((b)localObject4).invoke(localObject1);
            localObject1 = this.USF;
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((m)localObject1).idE();
            if (localObject1 == null) {
              continue;
            }
            localObject4 = this.USM;
            if (localObject4 != null)
            {
              s.u(localObject1, "texObject");
              localObject4 = ((a)localObject4).URD;
              if (localObject4 != null) {
                ((l)localObject4).a((com.tencent.mm.media.g.d)localObject1);
              }
            }
            localb = this.nFD;
            if (localb == null) {
              continue;
            }
            localObject4 = this.USM;
            if (localObject4 == null) {
              continue;
            }
            s.u(localb, "eGLEnvironment");
            if (s.p(localb.nFB, EGL14.EGL_NO_DISPLAY)) {
              continue;
            }
            localObject1 = com.tencent.mm.plugin.voip.f.h.ULL;
            if (com.tencent.mm.plugin.voip.f.h.ibJ()) {
              continue;
            }
            localObject1 = ((a)localObject4).URB;
            if (localObject1 == null) {
              continue;
            }
            if (s.p(((g)localObject1).idj(), EGL14.EGL_NO_SURFACE)) {
              continue;
            }
            i = 1;
            if (i == 0) {
              continue;
            }
            if (localObject1 == null) {
              continue;
            }
            GLES30.glClear(16640);
            GLES30.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
            localObject5 = ((a)localObject4).URD;
            if (localObject5 != null) {
              ((l)localObject5).ek(((g)localObject1).USA.width, ((g)localObject1).USA.height);
            }
            localObject5 = ((a)localObject4).URD;
            if (localObject5 != null) {
              ((l)localObject5).bgE();
            }
            EGL14.eglMakeCurrent(localb.nFB, ((g)localObject1).idj(), ((g)localObject1).idj(), localb.eXL);
            localObject5 = c.nFs;
            c.a.a(localb.nFB, ((g)localObject1).idj());
            localObject1 = ((a)localObject4).URA;
            if (localObject1 == null) {
              continue;
            }
            ((q)localObject1).invoke(Integer.valueOf(((a)localObject4).mWidth), Integer.valueOf(((a)localObject4).mHeight), Boolean.FALSE);
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.PboSurfaceRender", (Throwable)localException, "updateTexImage error", new Object[0]);
          continue;
          localObject2 = localException.idE();
          continue;
          i = 0;
          continue;
          localObject2 = null;
          continue;
          localObject2 = ((a)localObject4).URC;
          if (localObject2 == null) {
            continue;
          }
          if (s.p(((g)localObject2).idj(), EGL14.EGL_NO_SURFACE)) {
            break label710;
          }
        }
        i = 1;
        if (i != 0) {}
        for (;;)
        {
          if (localObject2 == null) {
            break label718;
          }
          GLES30.glClear(16640);
          GLES30.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          localObject5 = ((a)localObject4).URD;
          if (localObject5 != null) {
            ((l)localObject5).ek(((g)localObject2).USA.width, ((g)localObject2).USA.height);
          }
          localObject5 = ((a)localObject4).URD;
          if (localObject5 != null) {
            ((l)localObject5).bgE();
          }
          EGL14.eglMakeCurrent(localb.nFB, ((g)localObject2).idj(), ((g)localObject2).idj(), localb.eXL);
          localObject5 = c.nFs;
          c.a.a(localb.nFB, ((g)localObject2).idj());
          localObject2 = ((a)localObject4).URA;
          if (localObject2 == null) {
            break;
          }
          ((q)localObject2).invoke(Integer.valueOf(((a)localObject4).mWidth), Integer.valueOf(((a)localObject4).mHeight), Boolean.TRUE);
          break;
          i = 0;
          break label562;
          localObject2 = null;
        }
      }
    }
    AppMethodBeat.o(293124);
  }
  
  private final void idn()
  {
    AppMethodBeat.i(293134);
    if (!this.USL)
    {
      Log.i("MicroMsg.PboSurfaceRender", s.X("onPreviewTextureFrameAvailable, looper:", Looper.myLooper()));
      this.USL = true;
    }
    Looper localLooper = Looper.myLooper();
    Object localObject = this.handler;
    if (localObject == null) {}
    for (localObject = null; s.p(localLooper, localObject); localObject = ((MMHandler)localObject).getLooper())
    {
      bqg();
      AppMethodBeat.o(293134);
      return;
    }
    K((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(293134);
  }
  
  private final boolean idq()
  {
    AppMethodBeat.i(293138);
    boolean bool = s.p(Looper.myLooper(), this.nty.getLooper());
    AppMethodBeat.o(293138);
    return bool;
  }
  
  public final void B(final int paramInt, final float paramFloat)
  {
    AppMethodBeat.i(293288);
    K((kotlin.g.a.a)new g(this, paramInt, paramFloat));
    AppMethodBeat.o(293288);
  }
  
  public final void K(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(293298);
    s.u(parama, "callback");
    if ((this.nty.isAlive()) && (!this.nzB))
    {
      MMHandler localMMHandler = this.handler;
      if (localMMHandler != null) {
        localMMHandler.post(new h..ExternalSyntheticLambda2(parama));
      }
    }
    AppMethodBeat.o(293298);
  }
  
  public final void a(g paramg, final b<? super g, ah> paramb)
  {
    AppMethodBeat.i(293307);
    s.u(paramg, "glSurface");
    Log.i("MicroMsg.PboSurfaceRender", s.X("createSurface ", paramg));
    paramg = (kotlin.g.a.a)new c(paramg, this, paramb);
    if (idq())
    {
      paramg.invoke();
      AppMethodBeat.o(293307);
      return;
    }
    K(paramg);
    AppMethodBeat.o(293307);
  }
  
  public final void aN(final b<? super h, ah> paramb)
  {
    AppMethodBeat.i(293278);
    if ((this.nFD != null) || (this.USG)) {
      paramb.invoke(this);
    }
    K((kotlin.g.a.a)new b(this, paramb));
    AppMethodBeat.o(293278);
  }
  
  public final void aO(b<? super com.tencent.mm.media.g.d, ah> paramb)
  {
    AppMethodBeat.i(293301);
    if (!this.USK.contains(paramb)) {
      this.USK.add(paramb);
    }
    AppMethodBeat.o(293301);
  }
  
  public final void arv(final int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(293282);
    Log.printInfoStack("MicroMsg.PboSurfaceRender", "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt) });
    this.UNp = paramInt;
    int i;
    if ((this.UNp & 0x8) != 0)
    {
      i = 1;
      if ((this.UNp == 0) || (i != 0)) {
        break label100;
      }
      Log.i("MicroMsg.PboSurfaceRender", "render YT face-beauty algorithm");
      i = 2;
    }
    for (;;)
    {
      this.USN = i;
      K((kotlin.g.a.a)new i(this, paramInt));
      AppMethodBeat.o(293282);
      return;
      i = 0;
      break;
      label100:
      if ((i != 0) && ((this.UNp & 0x8) != 0))
      {
        Log.i("MicroMsg.PboSurfaceRender", "render WC face-beauty algorithm");
        i = j;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void arw(final int paramInt)
  {
    AppMethodBeat.i(293286);
    Log.i("MicroMsg.PboSurfaceRender", "setSpatiotemporalDenosing, isON:%d", new Object[] { Integer.valueOf(paramInt) });
    this.USO = paramInt;
    if (((this.USN == 0) || (this.USN == 3)) && (this.USO == 1)) {
      this.USN = 3;
    }
    K((kotlin.g.a.a)new h(this, paramInt, false));
    AppMethodBeat.o(293286);
  }
  
  public final boolean b(g paramg)
  {
    AppMethodBeat.i(293310);
    s.u(paramg, "glSurface");
    Log.i("MicroMsg.PboSurfaceRender", s.X("createSurface:", paramg));
    if (!paramg.idk())
    {
      AppMethodBeat.o(293310);
      return false;
    }
    if (paramg.idl())
    {
      AppMethodBeat.o(293310);
      return false;
    }
    Object localObject = paramg.USz;
    if (localObject == null)
    {
      AppMethodBeat.o(293310);
      return false;
    }
    c.b localb = this.nFD;
    if (localb != null)
    {
      Log.i("MicroMsg.PboSurfaceRender", s.X("start createEGLSurface:", Integer.valueOf(localObject.hashCode())));
      c.a locala = c.nFs;
      paramg.a(c.a.a(localb.nFB, localObject));
      paramg.GX(false);
      Log.i("MicroMsg.PboSurfaceRender", "createSurface finished:" + localObject.hashCode() + ", " + paramg.idj().hashCode());
      AppMethodBeat.o(293310);
      return true;
    }
    AppMethodBeat.o(293310);
    return false;
  }
  
  public final EGLContext ido()
  {
    c.b localb = this.nFD;
    if (localb == null) {
      return null;
    }
    return localb.eXL;
  }
  
  public final com.tencent.mm.media.g.d idp()
  {
    m localm = this.USF;
    if (localm == null) {
      return null;
    }
    return localm.nDF;
  }
  
  public final void j(Size paramSize)
  {
    AppMethodBeat.i(293291);
    s.u(paramSize, "cameraSize");
    Log.printInfoStack("MicroMsg.PboSurfaceRender", "updatePboAndWindowsSize is " + paramSize.getWidth() + " and " + paramSize.getHeight(), new Object[0]);
    m localm = this.USF;
    if (localm != null) {
      localm.el(paramSize.getWidth(), paramSize.getHeight());
    }
    AppMethodBeat.o(293291);
  }
  
  public final void release()
  {
    AppMethodBeat.i(293297);
    Log.i("MicroMsg.PboSurfaceRender", "stop");
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    this.USJ.clear();
    this.USK.clear();
    K((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(293297);
  }
  
  public final void start()
  {
    AppMethodBeat.i(293296);
    Log.i("MicroMsg.PboSurfaceRender", "start");
    K((kotlin.g.a.a)new j(this));
    AppMethodBeat.o(293296);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(293294);
    Log.i("MicroMsg.PboSurfaceRender", "stop");
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    K((kotlin.g.a.a)new k(this));
    AppMethodBeat.o(293294);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(h paramh, b<? super h, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(g paramg, h paramh, b<? super g, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(h paramh, g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(h paramh, int paramInt, float paramFloat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(h paramh, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(h paramh, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    k(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class l
    extends u
    implements kotlin.g.a.a<ah>
  {
    public l(h paramh, b<? super SurfaceTexture, ah> paramb)
    {
      super();
    }
    
    private static final void b(h paramh, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(293049);
      s.u(paramh, "this$0");
      paramSurfaceTexture = com.tencent.mm.plugin.voip.d.g.UHs;
      com.tencent.mm.plugin.voip.d.g.iad();
      paramSurfaceTexture = com.tencent.mm.plugin.voip.d.a.UFW;
      com.tencent.mm.plugin.voip.d.a.hZy();
      h.e(paramh);
      paramh.USj = true;
      AppMethodBeat.o(293049);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.h
 * JD-Core Version:    0.7.0.1
 */