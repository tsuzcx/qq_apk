package com.tencent.mm.plugin.multitalk.model;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.c;
import com.tencent.mm.media.util.c.b;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper;", "", "()V", "decoderOutputSurface", "Landroid/view/Surface;", "decoderOutputSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "decoderOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "height", "", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "width", "getSurface", "init", "", "post", "task", "Lkotlin/Function0;", "release", "requestRender", "setRgbBufferListener", "listener", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "setSize", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
{
  com.tencent.mm.media.g.d Lqv;
  SurfaceTexture Lqw;
  Surface Lqx;
  c Lqy;
  private Handler handler;
  private HandlerThread handlerThread;
  int height = 1;
  c.b mVi;
  int width = 1;
  
  private static final void bJ(a parama)
  {
    AppMethodBeat.i(284725);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(284725);
  }
  
  public final void bI(a<ah> parama)
  {
    AppMethodBeat.i(284745);
    s.u(parama, "task");
    Handler localHandler = this.handler;
    if (localHandler != null) {
      localHandler.post(new z..ExternalSyntheticLambda0(parama));
    }
    AppMethodBeat.o(284745);
  }
  
  public final void ggL()
  {
    AppMethodBeat.i(284735);
    if (this.handlerThread != null)
    {
      AppMethodBeat.o(284735);
      return;
    }
    HandlerThread localHandlerThread = com.tencent.threadpool.c.d.jv("multatalk_HW_render_thread", -4);
    if (localHandlerThread == null) {
      localHandlerThread = null;
    }
    for (;;)
    {
      this.handlerThread = localHandlerThread;
      bI((a)new a(this));
      AppMethodBeat.o(284735);
      return;
      localHandlerThread.start();
      this.handler = new Handler(localHandlerThread.getLooper());
      ah localah = ah.aiuX;
    }
  }
  
  public final void i(final q<? super ByteBuffer, ? super Integer, ? super Integer, ah> paramq)
  {
    AppMethodBeat.i(284738);
    s.u(paramq, "listener");
    bI((a)new d(this, paramq));
    AppMethodBeat.o(284738);
  }
  
  public final void release()
  {
    AppMethodBeat.i(284741);
    bI((a)new b(this));
    HandlerThread localHandlerThread = this.handlerThread;
    if (localHandlerThread != null) {
      localHandlerThread.quitSafely();
    }
    AppMethodBeat.o(284741);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(z paramz)
    {
      super();
    }
    
    private static final void a(z paramz, SurfaceTexture paramSurfaceTexture1, SurfaceTexture paramSurfaceTexture2)
    {
      AppMethodBeat.i(284679);
      s.u(paramz, "this$0");
      s.u(paramSurfaceTexture1, "$this_apply");
      z.a(paramz);
      paramSurfaceTexture1.updateTexImage();
      AppMethodBeat.o(284679);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(z paramz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(z paramz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(z paramz, q<? super ByteBuffer, ? super Integer, ? super Integer, ah> paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.z
 * JD-Core Version:    0.7.0.1
 */