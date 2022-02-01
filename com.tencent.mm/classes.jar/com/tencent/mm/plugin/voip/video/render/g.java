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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "", "width", "", "height", "(II)V", "beautyParam", "dataCallbackList", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "externalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "faceBeautyAlgorithm", "getFaceBeautyAlgorithm", "()I", "setFaceBeautyAlgorithm", "(I)V", "fboCallbackList", "Lkotlin/Function1;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHeight", "setHeight", "initCallback", "isRelease", "", "logFrameAvailable", "mCameraOrientation", "getMCameraOrientation", "setMCameraOrientation", "mDrawPerFrameStartTimes", "", "mIsMirror", "mIsRenderLocal", "mLocalRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "mRemoteRenderSurface", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "Lkotlin/ParameterName;", "name", "cost", "getOnDrawProcPerFrameCost", "()Lkotlin/jvm/functions/Function1;", "setOnDrawProcPerFrameCost", "(Lkotlin/jvm/functions/Function1;)V", "onFrameDataAvailableCallback", "getOnFrameDataAvailableCallback", "setOnFrameDataAvailableCallback", "pauseRender", "postInit", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "renderThread", "Landroid/os/HandlerThread;", "rendering", "spatiotemporalDenosingAllow", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getWidth", "setWidth", "addFBOAvailableCallback", "callback", "addFrameDataCallback", "addRenderSurface", "renderSide", "checkInit", "choiceRenderSurface", "createContext", "createSurface", "glSurface", "destroy", "getFaceBeautyType", "getGLContext", "Landroid/opengl/EGLContext;", "getOutputExternalTexture", "getUseSTFilter", "onPreviewTextureFrameAvailable", "onRendererFrameAvailable", "queue", "removeSurface", "renderImpl", "setCameraIsMirror", "mirror", "setCameraOrientation", "orientation", "setLocalRenderOrientation", "rotateDegree", "cameraOrientation", "setLocalVideoSize", "setSTFilterMotionNoiseData", "motion", "noise", "", "setSpatiotemporalDenosing", "cmd", "skipFilter", "setVoIPBeauty", "start", "stop", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updatePboAndWindowsSize", "cameraSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "Companion", "plugin-voip_release"})
public final class g
{
  public static final g.a HnH;
  boolean HhF;
  private int HiD;
  private long HiP;
  private b<? super g, x> HnA;
  private ArrayList<r<ByteBuffer, Integer, Integer, Integer, x>> HnB;
  ArrayList<b<com.tencent.mm.media.g.d, x>> HnC;
  private boolean HnD;
  a<x> HnE;
  int HnF;
  private int HnG;
  a<x> Hnc;
  b<? super Long, x> Hnd;
  private boolean Hnf;
  private f Hnh;
  private f Hni;
  private boolean Hnn;
  k Hnx;
  boolean Hny;
  private boolean Hnz;
  private MMHandler handler;
  int height;
  private boolean ife;
  private final HandlerThread igZ;
  c.b ilw;
  int sUv;
  Surface surface;
  SurfaceTexture surfaceTexture;
  int width;
  private com.tencent.mm.media.g.d zLQ;
  
  static
  {
    AppMethodBeat.i(236247);
    HnH = new g.a((byte)0);
    AppMethodBeat.o(236247);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236246);
    this.width = paramInt1;
    this.height = paramInt2;
    HandlerThread localHandlerThread = com.tencent.f.c.d.hC("PboSurfaceRender_renderThread_" + hashCode(), 5);
    p.g(localHandlerThread, "SpecialThreadFactory.cre…}\", Thread.NORM_PRIORITY)");
    this.igZ = localHandlerThread;
    this.HnB = new ArrayList();
    this.HnC = new ArrayList();
    this.HiP = -1L;
    this.Hnn = true;
    this.igZ.start();
    this.handler = new MMHandler(this.igZ.getLooper());
    this.Hnf = false;
    this.ife = false;
    AppMethodBeat.o(236246);
  }
  
  private final void aMV()
  {
    AppMethodBeat.i(236231);
    Object localObject1 = this.surfaceTexture;
    if (localObject1 != null)
    {
      if (this.Hnz)
      {
        AppMethodBeat.o(236231);
        return;
      }
      try
      {
        ((SurfaceTexture)localObject1).updateTexImage();
        if (com.tencent.mm.plugin.voip.b.g.fKg())
        {
          this.HiP = Util.currentTicks();
          localObject1 = this.Hnx;
          if (localObject1 != null) {
            ((k)localObject1).aED();
          }
          localObject1 = this.Hnd;
          if (localObject1 != null) {
            ((b)localObject1).invoke(Long.valueOf(Util.ticksToNow(this.HiP)));
          }
          localObject1 = this.HnE;
          if (localObject1 != null)
          {
            ((a)localObject1).invoke();
            AppMethodBeat.o(236231);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.PboSurfaceRender", (Throwable)localException, "updateTexImage error", new Object[0]);
        }
        AppMethodBeat.o(236231);
        return;
      }
      if (this.HnF == 0)
      {
        label227:
        Object localObject4;
        if (this.Hnn)
        {
          localObject2 = this.Hnh;
          if ((localObject2 == null) || (!this.Hnf)) {
            break label394;
          }
          this.HiP = Util.currentTicks();
          localObject3 = this.Hnx;
          if (localObject3 != null) {
            ((k)localObject3).cY(((f)localObject2).Hnv.width, ((f)localObject2).Hnv.height);
          }
          localObject3 = this.Hnx;
          if (localObject3 != null) {
            ((k)localObject3).aED();
          }
          localObject3 = this.ilw;
          if (localObject3 == null) {
            break label336;
          }
          localObject3 = ((c.b)localObject3).ilu;
          EGLSurface localEGLSurface1 = ((f)localObject2).fLS();
          EGLSurface localEGLSurface2 = ((f)localObject2).fLS();
          localObject4 = this.ilw;
          if (localObject4 == null) {
            break label341;
          }
          localObject4 = ((c.b)localObject4).ilv;
          label253:
          EGL14.eglMakeCurrent((EGLDisplay)localObject3, localEGLSurface1, localEGLSurface2, (EGLContext)localObject4);
          localObject3 = c.ilt;
          localObject3 = this.ilw;
          if (localObject3 == null) {
            break label346;
          }
        }
        label336:
        label341:
        label346:
        for (Object localObject3 = ((c.b)localObject3).ilu;; localObject3 = null)
        {
          c.a.a((EGLDisplay)localObject3, ((f)localObject2).fLS());
          if (this.Hnc == null) {
            break label351;
          }
          GLES30.glFinish();
          localObject2 = this.Hnc;
          if (localObject2 != null) {
            ((a)localObject2).invoke();
          }
          this.Hnc = null;
          AppMethodBeat.o(236231);
          return;
          localObject2 = this.Hni;
          break;
          localObject3 = null;
          break label227;
          localObject4 = null;
          break label253;
        }
        label351:
        GLES30.glFinish();
        localObject2 = this.Hnd;
        if (localObject2 != null)
        {
          ((b)localObject2).invoke(Long.valueOf(Util.ticksToNow(this.HiP)));
          AppMethodBeat.o(236231);
          return;
        }
        AppMethodBeat.o(236231);
        return;
        label394:
        AppMethodBeat.o(236231);
        return;
      }
      this.HiP = Util.currentTicks();
      Object localObject2 = this.Hnx;
      if (localObject2 != null) {
        ((k)localObject2).aED();
      }
      localObject2 = this.Hnd;
      if (localObject2 != null)
      {
        ((b)localObject2).invoke(Long.valueOf(Util.ticksToNow(this.HiP)));
        AppMethodBeat.o(236231);
        return;
      }
      AppMethodBeat.o(236231);
      return;
    }
    AppMethodBeat.o(236231);
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
  
  public final void a(f paramf, b<? super f, x> paramb)
  {
    AppMethodBeat.i(236245);
    p.h(paramf, "glSurface");
    Object localObject = c.ilt;
    localObject = this.ilw;
    if (localObject == null) {
      p.hyc();
    }
    localObject = c.a.a(((c.b)localObject).ilu, paramf.Hnu);
    p.h(localObject, "eglSurface");
    paramf.eglSurface = ((EGLSurface)localObject);
    if (paramb != null)
    {
      paramb.invoke(paramf);
      AppMethodBeat.o(236245);
      return;
    }
    AppMethodBeat.o(236245);
  }
  
  public final void aF(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(236234);
    k((a)new q(this, paramInt1, paramInt2, paramInt3));
    AppMethodBeat.o(236234);
  }
  
  public final void adZ(final int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(236232);
    Log.printInfoStack("MicroMsg.PboSurfaceRender", "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt) });
    this.HiD = paramInt;
    int i;
    if ((this.HiD & 0x8) != 0)
    {
      i = 1;
      if ((this.HiD == 0) || (i != 0)) {
        break label100;
      }
      Log.i("MicroMsg.PboSurfaceRender", "render YT face-beauty algorithm");
      i = 2;
    }
    for (;;)
    {
      this.HnF = i;
      k((a)new m(this, paramInt));
      AppMethodBeat.o(236232);
      return;
      i = 0;
      break;
      label100:
      if ((i != 0) && ((this.HiD & 0x8) != 0))
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
  
  public final void aea(final int paramInt)
  {
    AppMethodBeat.i(236233);
    Log.i("MicroMsg.PboSurfaceRender", "setSpatiotemporalDenosing, isON:%d", new Object[] { Integer.valueOf(paramInt) });
    this.HnG = paramInt;
    if (((this.HnF == 0) || (this.HnF == 3)) && (this.HnG == 1)) {
      this.HnF = 3;
    }
    k((a)new l(this, paramInt, false));
    AppMethodBeat.o(236233);
  }
  
  public final void b(f paramf, int paramInt)
  {
    AppMethodBeat.i(236244);
    if (paramf != null)
    {
      Log.printInfoStack("MicroMsg.PboSurfaceRender", "add render surface renderSide " + paramInt + " and :" + paramf, new Object[0]);
      if (paramInt == 0)
      {
        this.Hnh = paramf;
        AppMethodBeat.o(236244);
        return;
      }
      this.Hni = paramf;
      AppMethodBeat.o(236244);
      return;
    }
    Log.e("MicroMsg.PboSurfaceRender", "add a null surface");
    AppMethodBeat.o(236244);
  }
  
  public final void c(f paramf, int paramInt)
  {
    AppMethodBeat.i(236243);
    if (paramf != null)
    {
      Log.i("MicroMsg.PboSurfaceRender", "remove render surface :".concat(String.valueOf(paramf)));
      Object localObject = this.ilw;
      if (localObject != null)
      {
        localObject = ((c.b)localObject).ilu;
        if ((localObject != null) && ((p.j(paramf.fLS(), EGL14.EGL_NO_SURFACE) ^ true)))
        {
          localObject = this.ilw;
          if (localObject == null) {
            break label103;
          }
        }
      }
      label103:
      for (localObject = ((c.b)localObject).ilu;; localObject = null)
      {
        EGL14.eglDestroySurface((EGLDisplay)localObject, paramf.fLS());
        if (paramInt != 0) {
          break label108;
        }
        this.Hnh = null;
        AppMethodBeat.o(236243);
        return;
        localObject = null;
        break;
      }
      label108:
      this.Hni = null;
      AppMethodBeat.o(236243);
      return;
    }
    Log.e("MicroMsg.PboSurfaceRender", "remove a null surface");
    AppMethodBeat.o(236243);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(236237);
    Log.i("MicroMsg.PboSurfaceRender", "destroy");
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    this.HnB.clear();
    this.HnC.clear();
    k((a)new h(this));
    AppMethodBeat.o(236237);
  }
  
  public final void fLQ()
  {
    AppMethodBeat.i(236241);
    Log.printInfoStack("MicroMsg.PboSurfaceRender", "switchRenderSurface", new Object[0]);
    k((a)new p(this));
    AppMethodBeat.o(236241);
  }
  
  public final void fLT()
  {
    AppMethodBeat.i(236242);
    k((a)new c(this, true));
    AppMethodBeat.o(236242);
  }
  
  public final void h(r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, x> paramr)
  {
    AppMethodBeat.i(236239);
    if ((paramr != null) && (!this.HnB.contains(paramr))) {
      this.HnB.add(paramr);
    }
    AppMethodBeat.o(236239);
  }
  
  public final void jN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236240);
    Log.i("MicroMsg.PboSurfaceRender", "setLocalRenderOrientation " + paramInt1 + ',' + paramInt2 + ",$");
    k localk;
    if ((com.tencent.mm.plugin.voip.b.g.fKg()) || (this.HnF != 0))
    {
      if (!this.HhF)
      {
        if ((paramInt1 == 180) || (paramInt1 == 0))
        {
          localk = this.Hnx;
          if (localk != null) {
            localk.qx(paramInt2);
          }
          localk = this.Hnx;
          if (localk != null) {
            localk.HoZ = (paramInt2 - paramInt1);
          }
          localk = this.Hnx;
          if (localk != null) {
            localk.Hpb = true;
          }
        }
        for (;;)
        {
          localk = this.Hnx;
          if (localk == null) {
            break;
          }
          localk.iju = false;
          AppMethodBeat.o(236240);
          return;
          localk = this.Hnx;
          if (localk != null) {
            localk.qx((paramInt1 - paramInt2) % 360);
          }
          localk = this.Hnx;
          if (localk != null) {
            localk.HoZ = ((paramInt1 - paramInt2) % 360);
          }
          localk = this.Hnx;
          if (localk != null) {
            localk.Hpb = true;
          }
        }
      }
      if ((paramInt1 == 180) || (paramInt1 == 0))
      {
        localk = this.Hnx;
        if (localk != null) {
          localk.qx((paramInt2 + 180) % 360);
        }
        localk = this.Hnx;
        if (localk != null) {
          localk.HoZ = ((paramInt2 - paramInt1) % 360);
        }
      }
      for (;;)
      {
        localk = this.Hnx;
        if (localk == null) {
          break;
        }
        localk.Hpb = true;
        break;
        localk = this.Hnx;
        if (localk != null) {
          localk.qx((paramInt1 - paramInt2 + 180) % 360);
        }
        localk = this.Hnx;
        if (localk != null) {
          localk.HoZ = ((paramInt1 - paramInt2) % 360);
        }
      }
      AppMethodBeat.o(236240);
      return;
    }
    if (this.HnF == 0)
    {
      if (!this.HhF)
      {
        if ((paramInt1 == 180) || (paramInt1 == 0))
        {
          localk = this.Hnx;
          if (localk != null) {
            localk.qx((paramInt2 + 180) % 360);
          }
        }
        for (;;)
        {
          localk = this.Hnx;
          if (localk == null) {
            break;
          }
          localk.iju = false;
          AppMethodBeat.o(236240);
          return;
          localk = this.Hnx;
          if (localk != null) {
            localk.qx(paramInt2 % 360);
          }
        }
        AppMethodBeat.o(236240);
        return;
      }
      if ((paramInt1 == 180) || (paramInt1 == 0))
      {
        localk = this.Hnx;
        if (localk != null) {
          localk.qx(paramInt2);
        }
      }
      for (;;)
      {
        localk = this.Hnx;
        if (localk == null) {
          break;
        }
        localk.iju = true;
        AppMethodBeat.o(236240);
        return;
        localk = this.Hnx;
        if (localk != null) {
          localk.qx((paramInt2 + 180) % 360);
        }
      }
    }
    AppMethodBeat.o(236240);
  }
  
  public final void k(a<x> parama)
  {
    AppMethodBeat.i(236238);
    p.h(parama, "callback");
    if (this.igZ.isAlive())
    {
      MMHandler localMMHandler = this.handler;
      if (localMMHandler != null)
      {
        localMMHandler.post((Runnable)new h(parama));
        AppMethodBeat.o(236238);
        return;
      }
    }
    AppMethodBeat.o(236238);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(236236);
    Log.i("MicroMsg.PboSurfaceRender", "stop");
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    k((a)new o(this));
    AppMethodBeat.o(236236);
  }
  
  public final void x(final int paramInt, final float paramFloat)
  {
    AppMethodBeat.i(236235);
    k((a)new k(this, paramInt, paramFloat));
    AppMethodBeat.o(236235);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(g paramg, b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(g paramg, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/PboSurfaceRender$createContext$3$1"})
  static final class d
    implements SurfaceTexture.OnFrameAvailableListener
  {
    d(g paramg) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(236216);
      g.h(this.HnI);
      if (com.tencent.mm.plugin.voip.b.g.fKg())
      {
        g.i(this.HnI);
        AppMethodBeat.o(236216);
        return;
      }
      if (this.HnI.HnF != 0) {
        g.i(this.HnI);
      }
      AppMethodBeat.o(236216);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dataBuffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class e
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, x>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dataBuffer", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class f
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, x>
  {
    f(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(236219);
      b localb = g.b(this.HnI);
      if (localb != null)
      {
        localb.invoke(this.HnI);
        AppMethodBeat.o(236219);
        return;
      }
      AppMethodBeat.o(236219);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<x>
  {
    h(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements a<x>
  {
    i(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements a<x>
  {
    j(g paramg, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements a<x>
  {
    k(g paramg, int paramInt, float paramFloat)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements a<x>
  {
    l(g paramg, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements a<x>
  {
    m(g paramg, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements a<x>
  {
    n(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements a<x>
  {
    o(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements a<x>
  {
    p(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements a<x>
  {
    q(g paramg, int paramInt1, int paramInt2, int paramInt3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.g
 * JD-Core Version:    0.7.0.1
 */