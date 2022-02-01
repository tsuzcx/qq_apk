package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import com.tencent.mm.media.util.c;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "", "mIsRenderLocal", "", "hashCode", "", "(ZI)V", "TAG", "", "canRender", "getCanRender", "()Z", "setCanRender", "(Z)V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHashCode", "()I", "setHashCode", "(I)V", "inputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getInputTexture", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setInputTexture", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "isRelease", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isUpdateRenderSize", "mBackUpSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getMBackUpSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setMBackUpSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "mDrawPerFrameStartTimes", "", "getMDrawPerFrameStartTimes", "()J", "setMDrawPerFrameStartTimes", "(J)V", "mEncodeSurface", "getMEncodeSurface", "setMEncodeSurface", "getMIsRenderLocal", "setMIsRenderLocal", "mLocalRenderSurface", "getMLocalRenderSurface", "setMLocalRenderSurface", "mRemoteRenderSurface", "getMRemoteRenderSurface", "setMRemoteRenderSurface", "mRenderEventListener", "Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "getMRenderEventListener", "()Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "setMRenderEventListener", "(Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;)V", "mShareHeight", "getMShareHeight", "setMShareHeight", "mShareWidth", "getMShareWidth", "setMShareWidth", "onDrawPrcoEndYUVCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cost", "", "getOnDrawPrcoEndYUVCallback", "()Lkotlin/jvm/functions/Function1;", "setOnDrawPrcoEndYUVCallback", "(Lkotlin/jvm/functions/Function1;)V", "onDrawProcEndAfterViewAddCallback", "Lkotlin/Function0;", "getOnDrawProcEndAfterViewAddCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDrawProcEndAfterViewAddCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDrawProcPerFrameCost", "getOnDrawProcPerFrameCost", "setOnDrawProcPerFrameCost", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "getRenderProc", "()Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "setRenderProc", "(Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;)V", "renderSide", "getRenderSide", "setRenderSide", "renderThread", "Landroid/os/HandlerThread;", "rendering", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "addEncodeSurface", "addRenderSurface", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "needRefresh", "choiceRenderSurface", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "h", "flag", "", "getRenderSurface", "", "()[Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "pauseRender", "queue", "release", "removeSurface", "render", "requestRender", "texture", "setInputExternalTexture", "setShowMode", "mode", "setVoipFaceBeauty", "beauty", "setVoipSTFilter", "stFilter", "startRender", "stopRender", "switchRenderSurface", "updateDrawViewSize", "outputSurface", "updateRendererSize", "renderSize", "Landroid/util/Size;", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
{
  final String TAG;
  long UNA;
  g URB;
  g URC;
  boolean USf;
  a<ah> USg;
  b<? super Long, ah> USh;
  b<? super Long, ah> USi;
  volatile boolean USj;
  boolean USk;
  g USl;
  g USm;
  n USn;
  int USo;
  int USp;
  int USq;
  e USr;
  private boolean USs;
  private AtomicBoolean UvW;
  private int cHb;
  private MMHandler handler;
  c.b nFD;
  private final HandlerThread nty;
  com.tencent.mm.media.g.d ntz;
  Surface surface;
  SurfaceTexture surfaceTexture;
  
  public f(boolean paramBoolean, int paramInt)
  {
    this.USf = paramBoolean;
    this.cHb = paramInt;
    this.TAG = s.X("MicroMsg.WindowSurfaceRenderer@", Integer.valueOf(hashCode()));
    this.UNA = -1L;
    HandlerThread localHandlerThread = com.tencent.threadpool.c.d.jy(s.X("WindowSurfaceRenderer_renderThread_", Integer.valueOf(this.cHb)), 10);
    s.s(localHandlerThread, "createRendererThread(\"Wi…de\", Thread.MAX_PRIORITY)");
    this.nty = localHandlerThread;
    this.UvW = new AtomicBoolean(false);
    this.nty.start();
    this.handler = new MMHandler(this.nty.getLooper());
    this.USj = false;
    if (this.USf) {}
    for (paramInt = i;; paramInt = 1)
    {
      this.USq = paramInt;
      return;
    }
  }
  
  private static final void aH(a parama)
  {
    s.u(parama, "$tmp0");
    parama.invoke();
  }
  
  private static final void b(f paramf)
  {
    s.u(paramf, "this$0");
    Log.i(paramf.TAG, "do WindowSurfaceRenderer release");
    paramf.USi = null;
    paramf.USg = null;
    paramf.USh = null;
    paramf.c(paramf.USl, 0);
    paramf.c(paramf.USm, 1);
    paramf.c(paramf.URC, 0);
    paramf.c(paramf.URB, 0);
    Object localObject = paramf.surface;
    if (localObject != null) {
      ((Surface)localObject).release();
    }
    localObject = paramf.surfaceTexture;
    if (localObject != null) {
      ((SurfaceTexture)localObject).release();
    }
    localObject = paramf.ntz;
    if (localObject != null) {
      ((com.tencent.mm.media.g.d)localObject).close();
    }
    localObject = paramf.USn;
    if (localObject != null) {
      ((n)localObject).release();
    }
    localObject = paramf.nFD;
    if (localObject != null)
    {
      c.a locala = c.nFs;
      c.a.a((c.b)localObject);
      paramf.USm = null;
      paramf.USl = null;
    }
    paramf.nty.quitSafely();
  }
  
  public abstract void GV(boolean paramBoolean);
  
  public final void GW(boolean paramBoolean)
  {
    K((a)new a(paramBoolean, this));
  }
  
  public final void K(a<ah> parama)
  {
    s.u(parama, "callback");
    if (s.p(this.nty.getLooper(), Looper.myLooper())) {
      parama.invoke();
    }
    MMHandler localMMHandler;
    do
    {
      return;
      if ((!this.nty.isAlive()) || (this.UvW.get())) {
        break;
      }
      localMMHandler = this.handler;
    } while (localMMHandler == null);
    localMMHandler.post(new f..ExternalSyntheticLambda1(parama));
    return;
    Log.e(this.TAG, s.X("queue render thread is dead or released:", this.UvW));
  }
  
  public final void a(g paramg)
  {
    Log.printInfoStack(this.TAG, s.X("stopRender, surface:", paramg), new Object[0]);
    if ((s.p(paramg, this.USl)) || (s.p(paramg, this.USm)) || (paramg == null)) {
      K((a)new f(this));
    }
  }
  
  public final void a(g paramg, int paramInt)
  {
    if (paramInt == 0) {
      this.USl = paramg;
    }
    for (;;)
    {
      this.USs = true;
      return;
      this.USm = paramg;
    }
  }
  
  public abstract void a(b<? super f, ah> paramb, h paramh, boolean paramBoolean);
  
  public final void b(final com.tencent.mm.media.g.d paramd)
  {
    if (paramd != null) {
      K((a)new d(this, paramd));
    }
  }
  
  public final void b(g paramg, int paramInt)
  {
    if (paramg != null)
    {
      Log.printInfoStack(this.TAG, "add render surface renderSide " + paramInt + " and :" + paramg, new Object[0]);
      if (paramInt == 0)
      {
        this.USl = paramg;
        return;
      }
      this.USm = paramg;
      return;
    }
    Log.e(this.TAG, "add a null surface");
  }
  
  protected void bgE()
  {
    K((a)new c(this));
  }
  
  public final void c(com.tencent.mm.media.g.d paramd)
  {
    s.u(paramd, "texture");
    if (this.USj)
    {
      n localn = this.USn;
      if (localn != null) {
        localn.a(paramd);
      }
      bgE();
    }
  }
  
  public final void c(g paramg, final int paramInt)
  {
    Log.printInfoStack(this.TAG, s.X("remove render surface :", paramg), new Object[0]);
    paramg = (a)new b(paramg, this, paramInt);
    if ((Looper.myLooper() != null) && (s.p(Looper.myLooper(), this.nty.getLooper())))
    {
      paramg.invoke();
      return;
    }
    K(paramg);
  }
  
  public final void i(Size paramSize)
  {
    s.u(paramSize, "renderSize");
    this.USo = paramSize.getWidth();
    this.USp = paramSize.getHeight();
    n localn = this.USn;
    if (localn != null) {
      localn.el(paramSize.getWidth(), paramSize.getHeight());
    }
  }
  
  public final void idh()
  {
    Log.printInfoStack(this.TAG, "switchRenderSurface", new Object[0]);
    K((a)new g(this));
  }
  
  public final void idi()
  {
    Log.printInfoStack(this.TAG, "startRender", new Object[0]);
    K((a)new e(this));
  }
  
  public void release()
  {
    Log.i(this.TAG, "onSurfaceTextureDestroyed");
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    if (!this.UvW.compareAndSet(false, true)) {
      Log.e(this.TAG, "release already release");
    }
    do
    {
      return;
      if (!this.nty.isAlive())
      {
        Log.e(this.TAG, "release renderThread not alive");
        return;
      }
      localMMHandler = this.handler;
    } while (localMMHandler == null);
    localMMHandler.post(new f..ExternalSyntheticLambda0(this));
  }
  
  public final void setShowMode(int paramInt)
  {
    n localn = this.USn;
    if (localn != null) {
      localn.mWg = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(boolean paramBoolean, f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(g paramg, f paramf, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(f paramf, com.tencent.mm.media.g.d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<ah>
  {
    f(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements a<ah>
  {
    g(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.f
 * JD-Core Version:    0.7.0.1
 */