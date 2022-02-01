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
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.player.h;
import com.tencent.mm.plugin.vlog.ui.manager.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.base.MMTextureView;
import d.g.a.b;
import d.g.a.m;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cropRect", "Landroid/graphics/Rect;", "isRendering", "", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "texture", "Landroid/graphics/SurfaceTexture;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "bindPreloadManager", "surfaceTexture", "clearCurrentScript", "detachPreloadManager", "getSize", "Landroid/util/Size;", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "resume", "setCropRect", "rect", "setMute", "mute", "setOnProgressListener", "setOnSizeChangedListener", "updateFrameOnTime", "Companion", "plugin-vlog_release"})
public final class VLogPreloadPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VLogPreloadPlayView.a AuK;
  public com.tencent.mm.plugin.vlog.player.l ApF;
  private m<? super Long, ? super Long, d.y> ApG;
  private m<? super Integer, ? super Integer, d.y> Apv;
  public com.tencent.mm.plugin.vlog.player.d ArL;
  public com.tencent.mm.plugin.vlog.model.y Asu;
  public HandlerThread AuA;
  public ao AuB;
  public volatile boolean AuC;
  private v AuJ;
  private Rect gUl;
  public SurfaceTexture hbv;
  
  static
  {
    AppMethodBeat.i(111223);
    AuK = new VLogPreloadPlayView.a((byte)0);
    AppMethodBeat.o(111223);
  }
  
  public VLogPreloadPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(111222);
    paramContext = com.tencent.e.c.d.gz("VLogPlayView_PreviewPlayer", -4);
    k.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.AuA = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = c.AsH;
    this.AuJ = c.ega();
    AppMethodBeat.o(111222);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111221);
    paramContext = com.tencent.e.c.d.gz("VLogPlayView_PreviewPlayer", -4);
    k.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.AuA = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = c.AsH;
    this.AuJ = c.ega();
    AppMethodBeat.o(111221);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111220);
    paramContext = com.tencent.e.c.d.gz("VLogPlayView_PreviewPlayer", -4);
    k.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.AuA = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = c.AsH;
    this.AuJ = c.ega();
    AppMethodBeat.o(111220);
  }
  
  public final Size getSize()
  {
    AppMethodBeat.i(207898);
    Object localObject = this.ArL;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.vlog.player.d)localObject).getSize();
      AppMethodBeat.o(207898);
      return localObject;
    }
    AppMethodBeat.o(207898);
    return null;
  }
  
  public final void l(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111219);
    ac.i("MicroMsg.VLogPreloadPlayView", "bindPreloadManager surfaceTexture:".concat(String.valueOf(paramSurfaceTexture)));
    if (paramSurfaceTexture != null)
    {
      Object localObject1 = new StringBuilder("vLogDirector init : ");
      Object localObject2 = c.AsH;
      localObject2 = c.egc();
      if (localObject2 != null)
      {
        i = localObject2.hashCode();
        localObject1 = ((StringBuilder)localObject1).append(i).append(", vLogSurface : ");
        localObject2 = c.AsH;
        localObject2 = c.egb();
        if (localObject2 == null) {
          break label410;
        }
      }
      label410:
      for (int i = localObject2.hashCode();; i = 0)
      {
        ac.i("MicroMsg.VLogPreloadPlayView", i);
        localObject1 = c.AsH;
        this.ArL = c.egc();
        localObject1 = c.AsH;
        this.ApF = ((com.tencent.mm.plugin.vlog.player.l)c.egb());
        localObject1 = this.ApF;
        if (localObject1 != null)
        {
          localObject2 = c.AsH;
          localObject2 = c.egb();
          if (localObject2 == null) {
            k.fOy();
          }
          localObject2 = ((h)localObject2).gre;
          if (localObject2 == null) {
            k.fOy();
          }
          localObject2 = ((c.b)localObject2).gWL;
          Object localObject3 = c.AsH;
          localObject3 = c.egb();
          if (localObject3 == null) {
            k.fOy();
          }
          localObject3 = ((h)localObject3).gre;
          if (localObject3 == null) {
            k.fOy();
          }
          ((com.tencent.mm.plugin.vlog.player.l)localObject1).a((EGLContext)localObject2, ((c.b)localObject3).gWK, new Surface(paramSurfaceTexture), getWidth(), getHeight());
        }
        localObject1 = this.Asu;
        if (localObject1 != null)
        {
          ac.i("MicroMsg.VLogPreloadPlayView", "later set model: " + this.Asu);
          localObject2 = this.ArL;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.vlog.player.d)localObject2).a((com.tencent.mm.plugin.vlog.model.y)localObject1, ((com.tencent.mm.plugin.vlog.model.y)localObject1).getVideoDurationMs(), ((com.tencent.mm.plugin.vlog.model.y)localObject1).AoW);
          }
        }
        localObject1 = this.ArL;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.vlog.player.d)localObject1).efT();
        }
        localObject1 = this.ArL;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.vlog.player.d)localObject1).ApG = ((m)new b(this, paramSurfaceTexture));
          ((com.tencent.mm.plugin.vlog.player.d)localObject1).ApH = ((b)new c(this, paramSurfaceTexture));
          if (this.gUl != null) {
            ((com.tencent.mm.plugin.vlog.player.d)localObject1).setCropRect(this.gUl);
          }
        }
        paramSurfaceTexture = this.ArL;
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.cQ(getWidth(), getHeight());
        }
        paramSurfaceTexture = this.ArL;
        if (paramSurfaceTexture == null) {
          break label415;
        }
        com.tencent.mm.plugin.vlog.player.d.a(paramSurfaceTexture, null, false, 7);
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
    ac.i("MicroMsg.VLogPreloadPlayView", "surfaceAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.hbv = paramSurfaceTexture;
    if (!this.AuA.isAlive())
    {
      this.AuA.start();
      ac.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is not alive, start");
    }
    for (;;)
    {
      this.AuB = new ao(this.AuA.getLooper());
      l(paramSurfaceTexture);
      paramSurfaceTexture = this.Apv;
      if (paramSurfaceTexture == null) {
        break;
      }
      paramSurfaceTexture.n(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(111217);
      return;
      ac.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is alive");
    }
    AppMethodBeat.o(111217);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111216);
    ac.i("MicroMsg.VLogPreloadPlayView", "surfaceDestroy");
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    AppMethodBeat.o(111216);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111215);
    ac.i("MicroMsg.VLogPreloadPlayView", "surfaceSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(111215);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(207897);
    if (this.ArL == null)
    {
      this.gUl = paramRect;
      AppMethodBeat.o(207897);
      return;
    }
    com.tencent.mm.plugin.vlog.player.d locald = this.ArL;
    if (locald != null)
    {
      locald.setCropRect(paramRect);
      AppMethodBeat.o(207897);
      return;
    }
    AppMethodBeat.o(207897);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(111218);
    com.tencent.mm.plugin.vlog.player.d locald = this.ArL;
    if (locald != null)
    {
      locald.setMute(paramBoolean);
      AppMethodBeat.o(111218);
      return;
    }
    AppMethodBeat.o(111218);
  }
  
  public final void setOnProgressListener(m<? super Long, ? super Long, d.y> paramm)
  {
    this.ApG = paramm;
  }
  
  public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, d.y> paramm)
  {
    this.Apv = paramm;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "pts", "", "duration", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$1", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$1"})
  static final class b
    extends d.g.b.l
    implements m<Long, Long, d.y>
  {
    b(VLogPreloadPlayView paramVLogPreloadPlayView, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$2", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$2"})
  static final class c
    extends d.g.b.l
    implements b<Long, d.y>
  {
    c(VLogPreloadPlayView paramVLogPreloadPlayView, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(com.tencent.mm.plugin.vlog.player.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(111214);
      com.tencent.mm.plugin.vlog.player.d.a(this.AuI, null, false, 7);
      AppMethodBeat.o(111214);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView
 * JD-Core Version:    0.7.0.1
 */