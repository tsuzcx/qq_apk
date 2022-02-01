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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "width", "", "height", "textureWidth", "textureHeight", "(IIII)V", "(II)V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "remuxEGLSurface", "Landroid/opengl/EGLSurface;", "attachConsumer", "", "surface", "Landroid/view/Surface;", "bindPreloadConsumer", "eglContext", "Landroid/opengl/EGLContext;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "clearTask", "initGLEnvironment", "queueEvent", "task", "Lkotlin/Function0;", "release", "setPresentationTime", "nsecs", "", "submitProduction", "ptsMS", "unbindPreloadConsumer", "Companion", "plugin-vlog_release"})
public final class g
  extends k
{
  public static final a BIB;
  private EGLSurface BIA;
  private int gKJ;
  private int gKK;
  public c.b gKO;
  private ap handler;
  HandlerThread sWo;
  
  static
  {
    AppMethodBeat.i(195941);
    BIB = new a((byte)0);
    AppMethodBeat.o(195941);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(195939);
    HandlerThread localHandlerThread = d.gW("VLogRemuxSurface_EncodeThread", -4);
    p.g(localHandlerThread, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.sWo = localHandlerThread;
    AppMethodBeat.o(195939);
  }
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2);
    AppMethodBeat.i(195940);
    this.gKJ = paramInt3;
    this.gKK = paramInt4;
    ad.i("MicroMsg.VLog.VLogRemuxSurface", "create VLogRemuxSurface, surface:[" + paramInt1 + ", " + paramInt2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(195940);
  }
  
  public final void Bp(long paramLong)
  {
    AppMethodBeat.i(195937);
    Object localObject = this.gKO;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((c.b)localObject).hoQ, ((c.b)localObject).eglSurface, paramLong * 1000L * 1000L);
    }
    localObject = c.hoP;
    c.a.yh("eglPresentationTimeANDROID");
    localObject = this.gKO;
    if (localObject != null)
    {
      c.a locala = c.hoP;
      c.a.a(((c.b)localObject).hoQ, ((c.b)localObject).eglSurface);
      AppMethodBeat.o(195937);
      return;
    }
    AppMethodBeat.o(195937);
  }
  
  public final void a(final EGLContext paramEGLContext, final EGLDisplay paramEGLDisplay, final Surface paramSurface, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(195933);
    p.h(paramEGLContext, "eglContext");
    p.h(paramEGLDisplay, "eglDisplay");
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] bind surface before, surface: ").append(paramSurface).append(", eglEnv: ");
    Object localObject = this.gKO;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).hoR;; localObject = null)
    {
      ad.i("MicroMsg.VLog.VLogRemuxSurface", localObject);
      h((a)new b(this, paramEGLContext, paramEGLDisplay, paramSurface, paramInt1, paramInt2));
      AppMethodBeat.o(195933);
      return;
    }
  }
  
  public final void clearTask()
  {
    AppMethodBeat.i(195936);
    ap localap = this.handler;
    if (localap != null)
    {
      localap.removeCallbacksAndMessages(null);
      AppMethodBeat.o(195936);
      return;
    }
    AppMethodBeat.o(195936);
  }
  
  public final void esI()
  {
    AppMethodBeat.i(195934);
    h((a)new e(this));
    AppMethodBeat.o(195934);
  }
  
  public final void h(a<z> parama)
  {
    AppMethodBeat.i(195935);
    p.h(parama, "task");
    ap localap = this.handler;
    if (localap != null)
    {
      localap.post((Runnable)new h(parama));
      AppMethodBeat.o(195935);
      return;
    }
    AppMethodBeat.o(195935);
  }
  
  public final void k(Surface paramSurface)
  {
    AppMethodBeat.i(195932);
    this.BIV = paramSurface;
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] init egl environment before, surface: ").append(paramSurface).append(", eglEnv: ");
    paramSurface = this.gKO;
    if (paramSurface != null) {}
    for (paramSurface = paramSurface.hoR;; paramSurface = null)
    {
      ad.i("MicroMsg.VLog.VLogRemuxSurface", paramSurface);
      ad.i("MicroMsg.VLog.VLogRemuxSurface", "initGL");
      this.sWo.start();
      this.handler = new ap(this.sWo.getLooper());
      h((a)new c(this));
      AppMethodBeat.o(195932);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(195938);
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] VLogRelease release egl environment, surface: ").append(this.BIV).append(", eglEnv: ");
    Object localObject = this.gKO;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).hoR;; localObject = null)
    {
      ad.m("MicroMsg.VLog.VLogRemuxSurface", localObject, new Object[0]);
      h((a)new d(this));
      AppMethodBeat.o(195938);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    b(g paramg, EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, Surface paramSurface, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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