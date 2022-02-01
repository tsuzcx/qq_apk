package com.tencent.mm.plugin.mv.ui.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.xlabeffect.b.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.xeffect.VLogDirector;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/thumb/TPTrackThumbRenderer;", "", "width", "", "height", "(II)V", "TAG", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eGLHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eGLThread", "Landroid/os/HandlerThread;", "getHeight", "()I", "setHeight", "(I)V", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "outputSizeChanged", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "renderFrameCallback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "", "renderSurface", "Landroid/view/Surface;", "renderSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "renderTexture", "surfaceCallback", "Lkotlin/Function1;", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "waitNextVideoFrameTimeMs", "getWidth", "setWidth", "createEGLEnvironment", "createEGLThread", "createVideoTexture", "initVLogDirector", "queue", "call", "Lkotlin/Function0;", "release", "renderFrame", "timestampNs", "setMediaInfo", "setRenderFrameCallback", "callback", "setup", "afterSurfaceCreated", "updateSize", "waitNextVideoFrame", "timeMs", "Companion", "plugin-mv_release"})
public final class d
{
  public static final d.a AsM;
  com.tencent.mm.plugin.thumbplayer.d.a AsA;
  HandlerThread AsC;
  MMHandler AsD;
  kotlin.g.a.b<? super Surface, x> AsE;
  private Surface AsF;
  private SurfaceTexture AsG;
  private com.tencent.mm.media.g.d AsH;
  private VLogDirector AsI;
  boolean AsJ;
  m<? super Bitmap, ? super Long, x> AsK;
  volatile long AsL;
  final String TAG;
  private com.tencent.mm.media.g.d hDm;
  int height;
  private c.b ilw;
  int width;
  
  static
  {
    AppMethodBeat.i(257079);
    AsM = new d.a((byte)0);
    b.a locala = com.tencent.mm.plugin.xlabeffect.b.JRv;
    b.a.tryLoadLibrary();
    AppMethodBeat.o(257079);
  }
  
  public d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257078);
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = ("MicroMsg.TPTrackThumbRenderer@" + hashCode());
    this.AsI = new VLogDirector();
    AppMethodBeat.o(257078);
  }
  
  public final void k(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(257077);
    p.h(parama, "call");
    Object localObject = this.AsC;
    if (localObject != null)
    {
      if (((HandlerThread)localObject).isAlive() == true)
      {
        localObject = this.AsD;
        if (localObject != null)
        {
          ((MMHandler)localObject).post((Runnable)new e(parama));
          AppMethodBeat.o(257077);
        }
      }
    }
    else
    {
      AppMethodBeat.o(257077);
      return;
    }
    AppMethodBeat.o(257077);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(d paramd)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/mv/ui/thumb/TPTrackThumbRenderer$createVideoTexture$1$1$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(d.c paramc) {}
      
      public final void onFrameAvailable(final SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(257071);
        Looper localLooper = Looper.myLooper();
        Object localObject = d.f(this.AsO.AsN);
        if (localObject != null) {}
        for (localObject = ((HandlerThread)localObject).getLooper(); p.j(localLooper, localObject); localObject = null)
        {
          paramSurfaceTexture.updateTexImage();
          localObject = this.AsO.AsN;
          p.g(paramSurfaceTexture, "it");
          d.a((d)localObject, paramSurfaceTexture.getTimestamp());
          AppMethodBeat.o(257071);
          return;
        }
        this.AsO.AsN.k((kotlin.g.a.a)new q(paramSurfaceTexture) {});
        AppMethodBeat.o(257071);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.b.d
 * JD-Core Version:    0.7.0.1
 */