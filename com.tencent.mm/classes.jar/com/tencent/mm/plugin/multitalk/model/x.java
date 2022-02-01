package com.tencent.mm.plugin.multitalk.model;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.c;
import com.tencent.mm.media.k.c.b;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.ByteBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper;", "", "()V", "decoderOutputSurface", "Landroid/view/Surface;", "decoderOutputSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "decoderOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "height", "", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "width", "getSurface", "init", "", "post", "task", "Lkotlin/Function0;", "release", "requestRender", "setRgbBufferListener", "listener", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "setSize", "plugin-multitalk_release"})
public final class x
{
  c.b gKO;
  Handler handler;
  HandlerThread handlerThread;
  int height = 1;
  d wcR;
  SurfaceTexture wcS;
  Surface wcT;
  c wcU;
  int width = 1;
  
  public final void B(a<z> parama)
  {
    AppMethodBeat.i(206694);
    p.h(parama, "task");
    Handler localHandler = this.handler;
    if (localHandler != null)
    {
      localHandler.post((Runnable)new y(parama));
      AppMethodBeat.o(206694);
      return;
    }
    AppMethodBeat.o(206694);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.q
    implements a<z>
  {
    a(x paramx)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper$init$2$1$1$1", "com/tencent/mm/plugin/multitalk/model/ScreenCastHWRenderHelper$init$2$$special$$inlined$apply$lambda$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(SurfaceTexture paramSurfaceTexture, x.a parama) {}
      
      public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(206687);
        paramSurfaceTexture = this.wcX.wcV;
        paramSurfaceTexture.B((a)new x.c(paramSurfaceTexture));
        this.wcW.updateTexImage();
        AppMethodBeat.o(206687);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<z>
  {
    b(x paramx)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements a<z>
  {
    c(x paramx)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements a<z>
  {
    d(x paramx, d.g.a.q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.x
 * JD-Core Version:    0.7.0.1
 */