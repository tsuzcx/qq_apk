package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.plugin.vlog.model.z;
import com.tencent.mm.plugin.vlog.player.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.MMTextureView;
import d.g.a.b;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cropRect", "Landroid/graphics/Rect;", "isRendering", "", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "texture", "Landroid/graphics/SurfaceTexture;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "bindPreloadManager", "surfaceTexture", "clearCurrentScript", "detachPreloadManager", "getSize", "Landroid/util/Size;", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "resume", "setCropRect", "rect", "setMute", "mute", "setOnProgressListener", "setOnSizeChangedListener", "updateFrameOnTime", "Companion", "plugin-vlog_release"})
public final class VLogPreloadPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final a zcY;
  public com.tencent.mm.plugin.vlog.player.m LrT;
  public com.tencent.mm.plugin.vlog.player.h Lti;
  private z Lvb;
  public SurfaceTexture gAZ;
  private Rect gtE;
  private d.g.a.m<? super Long, ? super Long, y> zaT;
  public HandlerThread zcO;
  public ap zcP;
  private d.g.a.m<? super Integer, ? super Integer, y> zcQ;
  public volatile boolean zcR;
  public com.tencent.mm.plugin.vlog.model.h zcs;
  
  static
  {
    AppMethodBeat.i(111223);
    zcY = new a((byte)0);
    AppMethodBeat.o(111223);
  }
  
  public VLogPreloadPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(111222);
    paramContext = com.tencent.e.c.d.gv("VLogPlayView_PreviewPlayer", -4);
    k.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.zcO = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
    this.Lvb = com.tencent.mm.plugin.vlog.ui.manager.d.fZa();
    AppMethodBeat.o(111222);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111221);
    paramContext = com.tencent.e.c.d.gv("VLogPlayView_PreviewPlayer", -4);
    k.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.zcO = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
    this.Lvb = com.tencent.mm.plugin.vlog.ui.manager.d.fZa();
    AppMethodBeat.o(111221);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111220);
    paramContext = com.tencent.e.c.d.gv("VLogPlayView_PreviewPlayer", -4);
    k.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.zcO = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
    this.Lvb = com.tencent.mm.plugin.vlog.ui.manager.d.fZa();
    AppMethodBeat.o(111220);
  }
  
  public final Size getSize()
  {
    AppMethodBeat.i(201213);
    Object localObject = this.Lti;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.vlog.player.h)localObject).getSize();
      AppMethodBeat.o(201213);
      return localObject;
    }
    AppMethodBeat.o(201213);
    return null;
  }
  
  public final void l(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111219);
    ad.i("MicroMsg.VLogPreloadPlayView", "bindPreloadManager surfaceTexture:".concat(String.valueOf(paramSurfaceTexture)));
    if (paramSurfaceTexture != null)
    {
      Object localObject1 = new StringBuilder("vLogDirector init : ");
      Object localObject2 = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
      localObject2 = com.tencent.mm.plugin.vlog.ui.manager.d.fZc();
      if (localObject2 != null)
      {
        i = localObject2.hashCode();
        localObject1 = ((StringBuilder)localObject1).append(i).append(", vLogSurface : ");
        localObject2 = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
        localObject2 = com.tencent.mm.plugin.vlog.ui.manager.d.fZb();
        if (localObject2 == null) {
          break label410;
        }
      }
      label410:
      for (int i = localObject2.hashCode();; i = 0)
      {
        ad.i("MicroMsg.VLogPreloadPlayView", i);
        localObject1 = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
        this.Lti = com.tencent.mm.plugin.vlog.ui.manager.d.fZc();
        localObject1 = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
        this.LrT = ((com.tencent.mm.plugin.vlog.player.m)com.tencent.mm.plugin.vlog.ui.manager.d.fZb());
        localObject1 = this.LrT;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
          localObject2 = com.tencent.mm.plugin.vlog.ui.manager.d.fZb();
          if (localObject2 == null) {
            k.fvU();
          }
          localObject2 = ((i)localObject2).gsl;
          if (localObject2 == null) {
            k.fvU();
          }
          localObject2 = ((c.b)localObject2).gwo;
          Object localObject3 = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
          localObject3 = com.tencent.mm.plugin.vlog.ui.manager.d.fZb();
          if (localObject3 == null) {
            k.fvU();
          }
          localObject3 = ((i)localObject3).gsl;
          if (localObject3 == null) {
            k.fvU();
          }
          ((com.tencent.mm.plugin.vlog.player.m)localObject1).a((EGLContext)localObject2, ((c.b)localObject3).gwm, new Surface(paramSurfaceTexture), getWidth(), getHeight());
        }
        localObject1 = this.zcs;
        if (localObject1 != null)
        {
          ad.i("MicroMsg.VLogPreloadPlayView", "later set model: " + this.zcs);
          localObject2 = this.Lti;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.vlog.player.h)localObject2).a((com.tencent.mm.plugin.vlog.model.h)localObject1, ((com.tencent.mm.plugin.vlog.model.h)localObject1).getVideoDurationMs(), ((com.tencent.mm.plugin.vlog.model.h)localObject1).yZt);
          }
        }
        localObject1 = this.Lti;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.vlog.player.h)localObject1).fYW();
        }
        localObject1 = this.Lti;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.vlog.player.h)localObject1).zaT = ((d.g.a.m)new b(this, paramSurfaceTexture));
          ((com.tencent.mm.plugin.vlog.player.h)localObject1).LrU = ((b)new c(this, paramSurfaceTexture));
          if (this.gtE != null) {
            ((com.tencent.mm.plugin.vlog.player.h)localObject1).setCropRect(this.gtE);
          }
        }
        paramSurfaceTexture = this.Lti;
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.cR(getWidth(), getHeight());
        }
        paramSurfaceTexture = this.Lti;
        if (paramSurfaceTexture == null) {
          break label415;
        }
        com.tencent.mm.plugin.vlog.player.h.a(paramSurfaceTexture, null, false, 7);
        AppMethodBeat.o(111219);
        return;
        i = 0;
        break;
      }
    }
    label415:
    AppMethodBeat.o(111219);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111217);
    ad.i("MicroMsg.VLogPreloadPlayView", "surfaceAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.gAZ = paramSurfaceTexture;
    if (!this.zcO.isAlive())
    {
      this.zcO.start();
      ad.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is not alive, start");
    }
    for (;;)
    {
      this.zcP = new ap(this.zcO.getLooper());
      l(paramSurfaceTexture);
      paramSurfaceTexture = this.zcQ;
      if (paramSurfaceTexture == null) {
        break;
      }
      paramSurfaceTexture.n(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(111217);
      return;
      ad.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is alive");
    }
    AppMethodBeat.o(111217);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111216);
    ad.i("MicroMsg.VLogPreloadPlayView", "surfaceDestroy");
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    AppMethodBeat.o(111216);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111215);
    ad.i("MicroMsg.VLogPreloadPlayView", "surfaceSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(111215);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(201212);
    if (this.Lti == null)
    {
      this.gtE = paramRect;
      AppMethodBeat.o(201212);
      return;
    }
    com.tencent.mm.plugin.vlog.player.h localh = this.Lti;
    if (localh != null)
    {
      localh.setCropRect(paramRect);
      AppMethodBeat.o(201212);
      return;
    }
    AppMethodBeat.o(201212);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(111218);
    com.tencent.mm.plugin.vlog.player.h localh = this.Lti;
    if (localh != null)
    {
      localh.setMute(paramBoolean);
      AppMethodBeat.o(111218);
      return;
    }
    AppMethodBeat.o(111218);
  }
  
  public final void setOnProgressListener(d.g.a.m<? super Long, ? super Long, y> paramm)
  {
    this.zaT = paramm;
  }
  
  public final void setOnSizeChangedListener(d.g.a.m<? super Integer, ? super Integer, y> paramm)
  {
    this.zcQ = paramm;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "pts", "", "duration", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$1", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$1"})
  static final class b
    extends d.g.b.l
    implements d.g.a.m<Long, Long, y>
  {
    b(VLogPreloadPlayView paramVLogPreloadPlayView, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$2", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$2"})
  static final class c
    extends d.g.b.l
    implements b<Long, y>
  {
    c(VLogPreloadPlayView paramVLogPreloadPlayView, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(com.tencent.mm.plugin.vlog.player.h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(111214);
      com.tencent.mm.plugin.vlog.player.h.a(this.Lva, null, false, 7);
      AppMethodBeat.o(111214);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView
 * JD-Core Version:    0.7.0.1
 */