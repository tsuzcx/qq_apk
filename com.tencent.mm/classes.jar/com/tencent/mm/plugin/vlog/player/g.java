package com.tencent.mm.plugin.vlog.player;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "width", "", "height", "textureWidth", "textureHeight", "(IIII)V", "(II)V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "remuxEGLSurface", "Landroid/opengl/EGLSurface;", "attachConsumer", "", "surface", "Landroid/view/Surface;", "bindPreloadConsumer", "eglContext", "Landroid/opengl/EGLContext;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "clearTask", "initGLEnvironment", "queueEvent", "task", "Lkotlin/Function0;", "release", "setPresentationTime", "nsecs", "", "submitProduction", "ptsMS", "unbindPreloadConsumer", "Companion", "plugin-vlog_release"})
public final class g
  extends k
{
  public static final a Npy;
  HandlerThread Bbu;
  private EGLSurface Npx;
  private MMHandler handler;
  private int krg;
  private int krh;
  public c.b krl;
  
  static
  {
    AppMethodBeat.i(249730);
    Npy = new a((byte)0);
    AppMethodBeat.o(249730);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(249728);
    HandlerThread localHandlerThread = d.ij("VLogRemuxSurface_EncodeThread", -4);
    p.j(localHandlerThread, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.Bbu = localHandlerThread;
    AppMethodBeat.o(249728);
  }
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2);
    AppMethodBeat.i(249729);
    this.krg = paramInt3;
    this.krh = paramInt4;
    Log.i("MicroMsg.VLog.VLogRemuxSurface", "create VLogRemuxSurface, surface:[" + paramInt1 + ", " + paramInt2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(249729);
  }
  
  public final void Sv(long paramLong)
  {
    AppMethodBeat.i(249726);
    Object localObject = this.krl;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((c.b)localObject).las, ((c.b)localObject).eglSurface, paramLong * 1000L * 1000L);
    }
    localObject = c.lar;
    c.a.OB("eglPresentationTimeANDROID");
    localObject = this.krl;
    if (localObject != null)
    {
      c.a locala = c.lar;
      c.a.a(((c.b)localObject).las, ((c.b)localObject).eglSurface);
      AppMethodBeat.o(249726);
      return;
    }
    AppMethodBeat.o(249726);
  }
  
  public final void a(final EGLContext paramEGLContext, final EGLDisplay paramEGLDisplay, final Surface paramSurface, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(249722);
    p.k(paramEGLContext, "eglContext");
    p.k(paramEGLDisplay, "eglDisplay");
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] bind surface before, surface: ").append(paramSurface).append(", eglEnv: ");
    Object localObject = this.krl;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).lau;; localObject = null)
    {
      Log.i("MicroMsg.VLog.VLogRemuxSurface", localObject);
      i((a)new b(this, paramEGLContext, paramEGLDisplay, paramSurface, paramInt1, paramInt2));
      AppMethodBeat.o(249722);
      return;
    }
  }
  
  public final void clearTask()
  {
    AppMethodBeat.i(249725);
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null)
    {
      localMMHandler.removeCallbacksAndMessages(null);
      AppMethodBeat.o(249725);
      return;
    }
    AppMethodBeat.o(249725);
  }
  
  public final void gun()
  {
    AppMethodBeat.i(249723);
    i((a)new e(this));
    AppMethodBeat.o(249723);
  }
  
  public final void i(a<x> parama)
  {
    AppMethodBeat.i(249724);
    p.k(parama, "task");
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null)
    {
      localMMHandler.post((Runnable)new h(parama));
      AppMethodBeat.o(249724);
      return;
    }
    AppMethodBeat.o(249724);
  }
  
  public final void o(Surface paramSurface)
  {
    AppMethodBeat.i(249721);
    this.NpS = paramSurface;
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] init egl environment before, surface: ").append(paramSurface).append(", eglEnv: ");
    paramSurface = this.krl;
    if (paramSurface != null) {}
    for (paramSurface = paramSurface.lau;; paramSurface = null)
    {
      Log.i("MicroMsg.VLog.VLogRemuxSurface", paramSurface);
      Log.i("MicroMsg.VLog.VLogRemuxSurface", "initGL");
      this.Bbu.start();
      this.handler = new MMHandler(this.Bbu.getLooper());
      i((a)new c(this));
      AppMethodBeat.o(249721);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(249727);
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] VLogRelease release egl environment, surface: ").append(this.NpS).append(", eglEnv: ");
    Object localObject = this.krl;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).lau;; localObject = null)
    {
      Log.printInfoStack("MicroMsg.VLog.VLogRemuxSurface", localObject, new Object[0]);
      i((a)new d(this));
      AppMethodBeat.o(249727);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(g paramg, EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, Surface paramSurface, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.g
 * JD-Core Version:    0.7.0.1
 */