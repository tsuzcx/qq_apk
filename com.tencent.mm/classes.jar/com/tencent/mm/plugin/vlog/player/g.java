package com.tencent.mm.plugin.vlog.player;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.threadpool.c.d;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "width", "", "height", "textureWidth", "textureHeight", "(IIII)V", "(II)V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "remuxEGLSurface", "Landroid/opengl/EGLSurface;", "attachConsumer", "", "surface", "Landroid/view/Surface;", "bindPreloadConsumer", "eglContext", "Landroid/opengl/EGLContext;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "clearTask", "initGLEnvironment", "queueEvent", "task", "Lkotlin/Function0;", "release", "setPresentationTime", "nsecs", "", "submitProduction", "ptsMS", "unbindPreloadConsumer", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends j
{
  public static final a Udq;
  HandlerThread GDF;
  private EGLSurface Udr;
  private MMHandler handler;
  private int mVd;
  private int mVe;
  public c.b mVi;
  
  static
  {
    AppMethodBeat.i(281235);
    Udq = new a((byte)0);
    AppMethodBeat.o(281235);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(281204);
    HandlerThread localHandlerThread = d.jv("VLogRemuxSurface_EncodeThread", -4);
    s.s(localHandlerThread, "createEGLThread(\"VLogRem….THREAD_PRIORITY_DISPLAY)");
    this.GDF = localHandlerThread;
    AppMethodBeat.o(281204);
  }
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2);
    AppMethodBeat.i(281207);
    this.mVd = paramInt3;
    this.mVe = paramInt4;
    Log.i("MicroMsg.VLog.VLogRemuxSurface", "create VLogRemuxSurface, surface:[" + paramInt1 + ", " + paramInt2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(281207);
  }
  
  private static final void ab(a parama)
  {
    AppMethodBeat.i(281212);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(281212);
  }
  
  public final void H(a<ah> parama)
  {
    AppMethodBeat.i(281276);
    s.u(parama, "task");
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.post(new g..ExternalSyntheticLambda0(parama));
    }
    AppMethodBeat.o(281276);
  }
  
  public final void a(EGLContext paramEGLContext, final EGLDisplay paramEGLDisplay, final Surface paramSurface, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(281260);
    s.u(paramEGLContext, "eglContext");
    s.u(paramEGLDisplay, "eglDisplay");
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] bind surface before, surface: ").append(paramSurface).append(", eglEnv: ");
    Object localObject = this.mVi;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((c.b)localObject).eXL)
    {
      Log.i("MicroMsg.VLog.VLogRemuxSurface", localObject);
      H((a)new b(paramEGLContext, paramEGLDisplay, paramSurface, paramInt1, paramInt2, this));
      AppMethodBeat.o(281260);
      return;
    }
  }
  
  public final void clearTask()
  {
    AppMethodBeat.i(281286);
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null) {
      localMMHandler.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(281286);
  }
  
  public final void hSc()
  {
    AppMethodBeat.i(281270);
    H((a)new e(this));
    AppMethodBeat.o(281270);
  }
  
  public final void release()
  {
    AppMethodBeat.i(281310);
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] VLogRelease release egl environment, surface: ").append(this.UdI).append(", eglEnv: ");
    Object localObject = this.mVi;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((c.b)localObject).eXL)
    {
      Log.printInfoStack("MicroMsg.VLog.VLogRemuxSurface", localObject, new Object[0]);
      H((a)new d(this));
      AppMethodBeat.o(281310);
      return;
    }
  }
  
  public final void t(Surface paramSurface)
  {
    AppMethodBeat.i(281247);
    this.UdI = paramSurface;
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] init egl environment before, surface: ").append(paramSurface).append(", eglEnv: ");
    paramSurface = this.mVi;
    if (paramSurface == null) {}
    for (paramSurface = null;; paramSurface = paramSurface.eXL)
    {
      Log.i("MicroMsg.VLog.VLogRemuxSurface", paramSurface);
      Log.i("MicroMsg.VLog.VLogRemuxSurface", "initGL");
      this.GDF.start();
      this.handler = new MMHandler(this.GDF.getLooper());
      H((a)new c(this));
      AppMethodBeat.o(281247);
      return;
    }
  }
  
  public final void wJ(long paramLong)
  {
    AppMethodBeat.i(281299);
    Object localObject = this.mVi;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((c.b)localObject).nFB, ((c.b)localObject).eglSurface, paramLong * 1000L * 1000L);
    }
    localObject = c.nFs;
    c.a.GR("eglPresentationTimeANDROID");
    localObject = this.mVi;
    if (localObject != null)
    {
      c.a locala = c.nFs;
      c.a.a(((c.b)localObject).nFB, ((c.b)localObject).eglSurface);
    }
    AppMethodBeat.o(281299);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, Surface paramSurface, int paramInt1, int paramInt2, g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.g
 * JD-Core Version:    0.7.0.1
 */