package com.tencent.mm.plugin.mv.ui.c;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.xeffect.VLogDirector;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/thumb/TPTrackThumbRenderer;", "", "width", "", "height", "(II)V", "TAG", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eGLHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eGLThread", "Landroid/os/HandlerThread;", "getHeight", "()I", "setHeight", "(I)V", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "outputSizeChanged", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "renderFrameCallback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "", "renderSurface", "Landroid/view/Surface;", "renderSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "renderTexture", "surfaceCallback", "Lkotlin/Function1;", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "waitNextVideoFrameTimeMs", "getWidth", "setWidth", "createEGLEnvironment", "createEGLThread", "createVideoTexture", "initVLogDirector", "queue", "call", "Lkotlin/Function0;", "release", "renderFrame", "timestampNs", "setMediaInfo", "setRenderFrameCallback", "callback", "setup", "afterSurfaceCreated", "updateSize", "waitNextVideoFrame", "timeMs", "Companion", "plugin-mv_release"})
public final class e
{
  public static final e.a GhP;
  com.tencent.mm.plugin.thumbplayer.e.d GhE;
  HandlerThread GhG;
  MMHandler GhH;
  b<? super Surface, x> GhI;
  private SurfaceTexture GhJ;
  private com.tencent.mm.media.g.d GhK;
  private VLogDirector GhL;
  boolean GhM;
  m<? super Bitmap, ? super Long, x> GhN;
  volatile long GhO;
  final String TAG;
  int height;
  private com.tencent.mm.media.g.d krf;
  private c.b lav;
  private Surface ooH;
  int width;
  
  static
  {
    AppMethodBeat.i(231467);
    GhP = new e.a((byte)0);
    com.tencent.mm.plugin.xlabeffect.e.a locala = com.tencent.mm.plugin.xlabeffect.e.QQp;
    com.tencent.mm.plugin.xlabeffect.e.a.tryLoadLibrary();
    AppMethodBeat.o(231467);
  }
  
  public e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231465);
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = ("MicroMsg.TPTrackThumbRenderer@" + hashCode());
    this.GhL = new VLogDirector();
    AppMethodBeat.o(231465);
  }
  
  public final void j(a<x> parama)
  {
    AppMethodBeat.i(231463);
    p.k(parama, "call");
    Object localObject = this.GhG;
    if (localObject != null)
    {
      if (((HandlerThread)localObject).isAlive() == true)
      {
        localObject = this.GhH;
        if (localObject != null)
        {
          ((MMHandler)localObject).post((Runnable)new f(parama));
          AppMethodBeat.o(231463);
        }
      }
    }
    else
    {
      AppMethodBeat.o(231463);
      return;
    }
    AppMethodBeat.o(231463);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(e parame)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/mv/ui/thumb/TPTrackThumbRenderer$createVideoTexture$1$1$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(e.c paramc) {}
      
      public final void onFrameAvailable(final SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(231237);
        Looper localLooper = Looper.myLooper();
        Object localObject = e.f(this.GhR.GhQ);
        if (localObject != null) {}
        for (localObject = ((HandlerThread)localObject).getLooper(); p.h(localLooper, localObject); localObject = null)
        {
          paramSurfaceTexture.updateTexImage();
          localObject = this.GhR.GhQ;
          p.j(paramSurfaceTexture, "it");
          e.a((e)localObject, paramSurfaceTexture.getTimestamp());
          AppMethodBeat.o(231237);
          return;
        }
        this.GhR.GhQ.j((a)new q(paramSurfaceTexture) {});
        AppMethodBeat.o(231237);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.c.e
 * JD-Core Version:    0.7.0.1
 */