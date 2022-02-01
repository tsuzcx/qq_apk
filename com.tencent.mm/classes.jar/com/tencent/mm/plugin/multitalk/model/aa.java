package com.tencent.mm.plugin.multitalk.model;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.c;
import com.tencent.mm.media.k.c.b;
import java.nio.ByteBuffer;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper;", "", "()V", "decoderOutputSurface", "Landroid/view/Surface;", "decoderOutputSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "decoderOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "height", "", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "width", "getSurface", "init", "", "post", "task", "Lkotlin/Function0;", "release", "requestRender", "setRgbBufferListener", "listener", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "setSize", "plugin-multitalk_release"})
public final class aa
{
  com.tencent.mm.media.g.d Fuc;
  SurfaceTexture Fud;
  Surface Fue;
  c Fuf;
  private Handler handler;
  HandlerThread handlerThread;
  int height = 1;
  c.b krl;
  int width = 1;
  
  public final void X(a<x> parama)
  {
    AppMethodBeat.i(195681);
    p.k(parama, "task");
    Handler localHandler = this.handler;
    if (localHandler != null)
    {
      localHandler.post((Runnable)new ab(parama));
      AppMethodBeat.o(195681);
      return;
    }
    AppMethodBeat.o(195681);
  }
  
  public final void c(final kotlin.g.a.q<? super ByteBuffer, ? super Integer, ? super Integer, x> paramq)
  {
    AppMethodBeat.i(195678);
    p.k(paramq, "listener");
    X((a)new d(this, paramq));
    AppMethodBeat.o(195678);
  }
  
  public final void eXW()
  {
    AppMethodBeat.i(195677);
    if (this.handlerThread != null)
    {
      AppMethodBeat.o(195677);
      return;
    }
    HandlerThread localHandlerThread = com.tencent.e.c.d.ij("multatalk_HW_render_thread", -4);
    if (localHandlerThread != null)
    {
      localHandlerThread.start();
      this.handler = new Handler(localHandlerThread.getLooper());
    }
    for (;;)
    {
      this.handlerThread = localHandlerThread;
      X((a)new a(this));
      AppMethodBeat.o(195677);
      return;
      localHandlerThread = null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements a<x>
  {
    a(aa paramaa)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper$init$2$1$1$1", "com/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper$init$2$$special$$inlined$apply$lambda$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(SurfaceTexture paramSurfaceTexture, aa.a parama) {}
      
      public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(201391);
        paramSurfaceTexture = this.Fui.Fug;
        paramSurfaceTexture.X((a)new aa.c(paramSurfaceTexture));
        this.Fuh.updateTexImage();
        AppMethodBeat.o(201391);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<x>
  {
    b(aa paramaa)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements a<x>
  {
    c(aa paramaa)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements a<x>
  {
    d(aa paramaa, kotlin.g.a.q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.aa
 * JD-Core Version:    0.7.0.1
 */