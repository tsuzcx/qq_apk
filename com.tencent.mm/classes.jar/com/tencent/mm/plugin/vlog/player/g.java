package com.tencent.mm.plugin.vlog.player;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.f.c.d;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface;", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "width", "", "height", "textureWidth", "textureHeight", "(IIII)V", "(II)V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "remuxEGLSurface", "Landroid/opengl/EGLSurface;", "attachConsumer", "", "surface", "Landroid/view/Surface;", "bindPreloadConsumer", "eglContext", "Landroid/opengl/EGLContext;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "clearTask", "initGLEnvironment", "queueEvent", "task", "Lkotlin/Function0;", "release", "setPresentationTime", "nsecs", "", "submitProduction", "ptsMS", "unbindPreloadConsumer", "Companion", "plugin-vlog_release"})
public final class g
  extends k
{
  public static final a GBN;
  private EGLSurface GBM;
  private int hDn;
  private int hDo;
  public c.b hDs;
  private MMHandler handler;
  HandlerThread wpM;
  
  static
  {
    AppMethodBeat.i(190872);
    GBN = new a((byte)0);
    AppMethodBeat.o(190872);
  }
  
  public g(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(190870);
    HandlerThread localHandlerThread = d.hz("VLogRemuxSurface_EncodeThread", -4);
    p.g(localHandlerThread, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.wpM = localHandlerThread;
    AppMethodBeat.o(190870);
  }
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2);
    AppMethodBeat.i(190871);
    this.hDn = paramInt3;
    this.hDo = paramInt4;
    Log.i("MicroMsg.VLog.VLogRemuxSurface", "create VLogRemuxSurface, surface:[" + paramInt1 + ", " + paramInt2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(190871);
  }
  
  public final void KY(long paramLong)
  {
    AppMethodBeat.i(190868);
    Object localObject = this.hDs;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((c.b)localObject).ilu, ((c.b)localObject).eglSurface, paramLong * 1000L * 1000L);
    }
    localObject = c.ilt;
    c.a.Hq("eglPresentationTimeANDROID");
    localObject = this.hDs;
    if (localObject != null)
    {
      c.a locala = c.ilt;
      c.a.a(((c.b)localObject).ilu, ((c.b)localObject).eglSurface);
      AppMethodBeat.o(190868);
      return;
    }
    AppMethodBeat.o(190868);
  }
  
  public final void a(final EGLContext paramEGLContext, final EGLDisplay paramEGLDisplay, final Surface paramSurface, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(190864);
    p.h(paramEGLContext, "eglContext");
    p.h(paramEGLDisplay, "eglDisplay");
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] bind surface before, surface: ").append(paramSurface).append(", eglEnv: ");
    Object localObject = this.hDs;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).ilv;; localObject = null)
    {
      Log.i("MicroMsg.VLog.VLogRemuxSurface", localObject);
      j((a)new b(this, paramEGLContext, paramEGLDisplay, paramSurface, paramInt1, paramInt2));
      AppMethodBeat.o(190864);
      return;
    }
  }
  
  public final void clearTask()
  {
    AppMethodBeat.i(190867);
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null)
    {
      localMMHandler.removeCallbacksAndMessages(null);
      AppMethodBeat.o(190867);
      return;
    }
    AppMethodBeat.o(190867);
  }
  
  public final void fCo()
  {
    AppMethodBeat.i(190865);
    j((a)new e(this));
    AppMethodBeat.o(190865);
  }
  
  public final void j(a<x> parama)
  {
    AppMethodBeat.i(190866);
    p.h(parama, "task");
    MMHandler localMMHandler = this.handler;
    if (localMMHandler != null)
    {
      localMMHandler.post((Runnable)new h(parama));
      AppMethodBeat.o(190866);
      return;
    }
    AppMethodBeat.o(190866);
  }
  
  public final void k(Surface paramSurface)
  {
    AppMethodBeat.i(190863);
    this.GCh = paramSurface;
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] init egl environment before, surface: ").append(paramSurface).append(", eglEnv: ");
    paramSurface = this.hDs;
    if (paramSurface != null) {}
    for (paramSurface = paramSurface.ilv;; paramSurface = null)
    {
      Log.i("MicroMsg.VLog.VLogRemuxSurface", paramSurface);
      Log.i("MicroMsg.VLog.VLogRemuxSurface", "initGL");
      this.wpM.start();
      this.handler = new MMHandler(this.wpM.getLooper());
      j((a)new c(this));
      AppMethodBeat.o(190863);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(190869);
    StringBuilder localStringBuilder = new StringBuilder("[OpenGL] VLogRelease release egl environment, surface: ").append(this.GCh).append(", eglEnv: ");
    Object localObject = this.hDs;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).ilv;; localObject = null)
    {
      Log.printInfoStack("MicroMsg.VLog.VLogRemuxSurface", localObject, new Object[0]);
      j((a)new d(this));
      AppMethodBeat.o(190869);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/player/VLogRemuxSurface$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(g paramg, EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, Surface paramSurface, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.g
 * JD-Core Version:    0.7.0.1
 */