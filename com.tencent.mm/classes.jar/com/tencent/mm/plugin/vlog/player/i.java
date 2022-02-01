package com.tencent.mm.plugin.vlog.player;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "width", "", "height", "textureWidth", "textureHeight", "(IIII)V", "(II)V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "remuxEGLSurface", "Landroid/opengl/EGLSurface;", "attachConsumer", "", "surface", "Landroid/view/Surface;", "bindPreloadConsumer", "eglContext", "Landroid/opengl/EGLContext;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "clearTask", "initGLEnvironment", "queueEvent", "task", "Lkotlin/Function0;", "release", "setPresentationTime", "nsecs", "", "submitProduction", "ptsMS", "unbindPreloadConsumer", "Companion", "plugin-vlog_release"})
public final class i
  extends m
{
  public static final a Lsj;
  private EGLSurface Lsi;
  public c.b gsl;
  private int guI;
  private int guJ;
  private ap handler;
  HandlerThread veL;
  
  static
  {
    AppMethodBeat.i(201033);
    Lsj = new a((byte)0);
    AppMethodBeat.o(201033);
  }
  
  public i(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(201031);
    HandlerThread localHandlerThread = d.gu("VLogRemuxSurface_EncodeThread", -4);
    k.g(localHandlerThread, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.veL = localHandlerThread;
    AppMethodBeat.o(201031);
  }
  
  public i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2);
    AppMethodBeat.i(201032);
    this.guI = paramInt3;
    this.guJ = paramInt4;
    ad.i("MicroMsg.VLog.VLogRemuxSurface", "create VLogRemuxSurface, surface:[" + paramInt1 + ", " + paramInt2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(201032);
  }
  
  public final void Cg(long paramLong)
  {
    AppMethodBeat.i(201029);
    Object localObject = this.gsl;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((c.b)localObject).gwm, ((c.b)localObject).eglSurface, paramLong * 1000L * 1000L);
    }
    localObject = c.gwl;
    c.a.ro("eglPresentationTimeANDROID");
    localObject = this.gsl;
    if (localObject != null)
    {
      c.a locala = c.gwl;
      c.a.a(((c.b)localObject).gwm, ((c.b)localObject).eglSurface);
      AppMethodBeat.o(201029);
      return;
    }
    AppMethodBeat.o(201029);
  }
  
  public final void a(final EGLContext paramEGLContext, final EGLDisplay paramEGLDisplay, final Surface paramSurface, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(201025);
    k.h(paramEGLContext, "eglContext");
    k.h(paramEGLDisplay, "eglDisplay");
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] bind surface before, surface: ").append(paramSurface).append(", eglEnv: ");
    Object localObject = this.gsl;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).gwo;; localObject = null)
    {
      ad.i("MicroMsg.VLog.VLogRemuxSurface", localObject);
      j((a)new b(this, paramEGLContext, paramEGLDisplay, paramSurface, paramInt1, paramInt2));
      AppMethodBeat.o(201025);
      return;
    }
  }
  
  public final void clearTask()
  {
    AppMethodBeat.i(201028);
    ap localap = this.handler;
    if (localap != null)
    {
      localap.removeCallbacksAndMessages(null);
      AppMethodBeat.o(201028);
      return;
    }
    AppMethodBeat.o(201028);
  }
  
  public final void fYY()
  {
    AppMethodBeat.i(201026);
    j((a)new e(this));
    AppMethodBeat.o(201026);
  }
  
  public final void j(a<y> parama)
  {
    AppMethodBeat.i(201027);
    k.h(parama, "task");
    ap localap = this.handler;
    if (localap != null)
    {
      localap.post((Runnable)new j(parama));
      AppMethodBeat.o(201027);
      return;
    }
    AppMethodBeat.o(201027);
  }
  
  public final void l(Surface paramSurface)
  {
    AppMethodBeat.i(201024);
    this.LsC = paramSurface;
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] init egl environment before, surface: ").append(paramSurface).append(", eglEnv: ");
    paramSurface = this.gsl;
    if (paramSurface != null) {}
    for (paramSurface = paramSurface.gwo;; paramSurface = null)
    {
      ad.i("MicroMsg.VLog.VLogRemuxSurface", paramSurface);
      ad.i("MicroMsg.VLog.VLogRemuxSurface", "initGL");
      this.veL.start();
      this.handler = new ap(this.veL.getLooper());
      j((a)new c(this));
      AppMethodBeat.o(201024);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(201030);
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] VLogRelease release egl environment, surface: ").append(this.LsC).append(", eglEnv: ");
    Object localObject = this.gsl;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).gwo;; localObject = null)
    {
      ad.m("MicroMsg.VLog.VLogRemuxSurface", localObject, new Object[0]);
      j((a)new d(this));
      AppMethodBeat.o(201030);
      return;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(i parami, EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, Surface paramSurface, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<y>
  {
    c(i parami)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<y>
  {
    d(i parami)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<y>
  {
    e(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.i
 * JD-Core Version:    0.7.0.1
 */