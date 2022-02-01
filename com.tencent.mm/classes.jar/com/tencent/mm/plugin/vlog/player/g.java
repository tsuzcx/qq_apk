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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "width", "", "height", "textureWidth", "textureHeight", "(IIII)V", "(II)V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "remuxEGLSurface", "Landroid/opengl/EGLSurface;", "attachConsumer", "", "surface", "Landroid/view/Surface;", "bindPreloadConsumer", "eglContext", "Landroid/opengl/EGLContext;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "clearTask", "initGLEnvironment", "queueEvent", "task", "Lkotlin/Function0;", "release", "setPresentationTime", "nsecs", "", "submitProduction", "ptsMS", "unbindPreloadConsumer", "Companion", "plugin-vlog_release"})
public final class g
  extends k
{
  public static final a Caa;
  private EGLSurface BZZ;
  private int gNs;
  private int gNt;
  public c.b gNx;
  private aq handler;
  HandlerThread thB;
  
  static
  {
    AppMethodBeat.i(191401);
    Caa = new a((byte)0);
    AppMethodBeat.o(191401);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(191399);
    HandlerThread localHandlerThread = d.hf("VLogRemuxSurface_EncodeThread", -4);
    p.g(localHandlerThread, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.thB = localHandlerThread;
    AppMethodBeat.o(191399);
  }
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2);
    AppMethodBeat.i(191400);
    this.gNs = paramInt3;
    this.gNt = paramInt4;
    ae.i("MicroMsg.VLog.VLogRemuxSurface", "create VLogRemuxSurface, surface:[" + paramInt1 + ", " + paramInt2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(191400);
  }
  
  public final void BN(long paramLong)
  {
    AppMethodBeat.i(191397);
    Object localObject = this.gNx;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((c.b)localObject).hrE, ((c.b)localObject).eglSurface, paramLong * 1000L * 1000L);
    }
    localObject = c.hrD;
    c.a.yR("eglPresentationTimeANDROID");
    localObject = this.gNx;
    if (localObject != null)
    {
      c.a locala = c.hrD;
      c.a.a(((c.b)localObject).hrE, ((c.b)localObject).eglSurface);
      AppMethodBeat.o(191397);
      return;
    }
    AppMethodBeat.o(191397);
  }
  
  public final void a(final EGLContext paramEGLContext, final EGLDisplay paramEGLDisplay, final Surface paramSurface, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(191393);
    p.h(paramEGLContext, "eglContext");
    p.h(paramEGLDisplay, "eglDisplay");
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] bind surface before, surface: ").append(paramSurface).append(", eglEnv: ");
    Object localObject = this.gNx;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).hrF;; localObject = null)
    {
      ae.i("MicroMsg.VLog.VLogRemuxSurface", localObject);
      i((a)new b(this, paramEGLContext, paramEGLDisplay, paramSurface, paramInt1, paramInt2));
      AppMethodBeat.o(191393);
      return;
    }
  }
  
  public final void clearTask()
  {
    AppMethodBeat.i(191396);
    aq localaq = this.handler;
    if (localaq != null)
    {
      localaq.removeCallbacksAndMessages(null);
      AppMethodBeat.o(191396);
      return;
    }
    AppMethodBeat.o(191396);
  }
  
  public final void ewp()
  {
    AppMethodBeat.i(191394);
    i((a)new e(this));
    AppMethodBeat.o(191394);
  }
  
  public final void i(a<z> parama)
  {
    AppMethodBeat.i(191395);
    p.h(parama, "task");
    aq localaq = this.handler;
    if (localaq != null)
    {
      localaq.post((Runnable)new h(parama));
      AppMethodBeat.o(191395);
      return;
    }
    AppMethodBeat.o(191395);
  }
  
  public final void k(Surface paramSurface)
  {
    AppMethodBeat.i(191392);
    this.Cau = paramSurface;
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] init egl environment before, surface: ").append(paramSurface).append(", eglEnv: ");
    paramSurface = this.gNx;
    if (paramSurface != null) {}
    for (paramSurface = paramSurface.hrF;; paramSurface = null)
    {
      ae.i("MicroMsg.VLog.VLogRemuxSurface", paramSurface);
      ae.i("MicroMsg.VLog.VLogRemuxSurface", "initGL");
      this.thB.start();
      this.handler = new aq(this.thB.getLooper());
      i((a)new c(this));
      AppMethodBeat.o(191392);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(191398);
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] VLogRelease release egl environment, surface: ").append(this.Cau).append(", eglEnv: ");
    Object localObject = this.gNx;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).hrF;; localObject = null)
    {
      ae.m("MicroMsg.VLog.VLogRemuxSurface", localObject, new Object[0]);
      i((a)new d(this));
      AppMethodBeat.o(191398);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    b(g paramg, EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, Surface paramSurface, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<z>
  {
    e(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.g
 * JD-Core Version:    0.7.0.1
 */