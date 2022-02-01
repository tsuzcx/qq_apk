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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "width", "", "height", "textureWidth", "textureHeight", "(IIII)V", "(II)V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "remuxEGLSurface", "Landroid/opengl/EGLSurface;", "attachConsumer", "", "surface", "Landroid/view/Surface;", "bindPreloadConsumer", "eglContext", "Landroid/opengl/EGLContext;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "clearTask", "initGLEnvironment", "queueEvent", "task", "Lkotlin/Function0;", "release", "setPresentationTime", "nsecs", "", "submitProduction", "ptsMS", "unbindPreloadConsumer", "Companion", "plugin-vlog_release"})
public final class h
  extends l
{
  public static final h.a Aqe;
  private EGLSurface Aqd;
  private int gqZ;
  private int gra;
  public c.b gre;
  private ao handler;
  HandlerThread rZs;
  
  static
  {
    AppMethodBeat.i(207719);
    Aqe = new h.a((byte)0);
    AppMethodBeat.o(207719);
  }
  
  public h(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(207717);
    HandlerThread localHandlerThread = d.gy("VLogRemuxSurface_EncodeThread", -4);
    k.g(localHandlerThread, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.rZs = localHandlerThread;
    AppMethodBeat.o(207717);
  }
  
  public h(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2);
    AppMethodBeat.i(207718);
    this.gqZ = paramInt3;
    this.gra = paramInt4;
    ac.i("MicroMsg.VLog.VLogRemuxSurface", "create VLogRemuxSurface, surface:[" + paramInt1 + ", " + paramInt2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(207718);
  }
  
  public final void a(final EGLContext paramEGLContext, final EGLDisplay paramEGLDisplay, final Surface paramSurface, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(207711);
    k.h(paramEGLContext, "eglContext");
    k.h(paramEGLDisplay, "eglDisplay");
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] bind surface before, surface: ").append(paramSurface).append(", eglEnv: ");
    Object localObject = this.gre;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).gWL;; localObject = null)
    {
      ac.i("MicroMsg.VLog.VLogRemuxSurface", localObject);
      h((a)new b(this, paramEGLContext, paramEGLDisplay, paramSurface, paramInt1, paramInt2));
      AppMethodBeat.o(207711);
      return;
    }
  }
  
  public final void clearTask()
  {
    AppMethodBeat.i(207714);
    ao localao = this.handler;
    if (localao != null)
    {
      localao.removeCallbacksAndMessages(null);
      AppMethodBeat.o(207714);
      return;
    }
    AppMethodBeat.o(207714);
  }
  
  public final void efV()
  {
    AppMethodBeat.i(207712);
    h((a)new e(this));
    AppMethodBeat.o(207712);
  }
  
  public final void h(a<y> parama)
  {
    AppMethodBeat.i(207713);
    k.h(parama, "task");
    ao localao = this.handler;
    if (localao != null)
    {
      localao.post((Runnable)new i(parama));
      AppMethodBeat.o(207713);
      return;
    }
    AppMethodBeat.o(207713);
  }
  
  public final void k(Surface paramSurface)
  {
    AppMethodBeat.i(207710);
    this.Aqy = paramSurface;
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] init egl environment before, surface: ").append(paramSurface).append(", eglEnv: ");
    paramSurface = this.gre;
    if (paramSurface != null) {}
    for (paramSurface = paramSurface.gWL;; paramSurface = null)
    {
      ac.i("MicroMsg.VLog.VLogRemuxSurface", paramSurface);
      ac.i("MicroMsg.VLog.VLogRemuxSurface", "initGL");
      this.rZs.start();
      this.handler = new ao(this.rZs.getLooper());
      h((a)new c(this));
      AppMethodBeat.o(207710);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(207716);
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] VLogRelease release egl environment, surface: ").append(this.Aqy).append(", eglEnv: ");
    Object localObject = this.gre;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).gWL;; localObject = null)
    {
      ac.m("MicroMsg.VLog.VLogRemuxSurface", localObject, new Object[0]);
      h((a)new d(this));
      AppMethodBeat.o(207716);
      return;
    }
  }
  
  public final void yM(long paramLong)
  {
    AppMethodBeat.i(207715);
    Object localObject = this.gre;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((c.b)localObject).gWK, ((c.b)localObject).eglSurface, paramLong * 1000L * 1000L);
    }
    localObject = c.gWJ;
    c.a.vq("eglPresentationTimeANDROID");
    localObject = this.gre;
    if (localObject != null)
    {
      c.a locala = c.gWJ;
      c.a.a(((c.b)localObject).gWK, ((c.b)localObject).eglSurface);
      AppMethodBeat.o(207715);
      return;
    }
    AppMethodBeat.o(207715);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(h paramh, EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, Surface paramSurface, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<y>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<y>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<y>
  {
    e(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.h
 * JD-Core Version:    0.7.0.1
 */