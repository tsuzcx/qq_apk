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
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.vlog.model.aa;
import com.tencent.mm.plugin.vlog.model.x;
import com.tencent.mm.plugin.vlog.player.g;
import com.tencent.mm.plugin.vlog.player.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.MMTextureView;
import d.g.a.b;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cropRect", "Landroid/graphics/Rect;", "isRendering", "", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "texture", "Landroid/graphics/SurfaceTexture;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "bindPreloadManager", "surfaceTexture", "clearCurrentScript", "detachPreloadManager", "getSize", "Landroid/util/Size;", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "resume", "setCropRect", "rect", "setMute", "mute", "setOnProgressListener", "setOnSizeChangedListener", "updateFrameOnTime", "Companion", "plugin-vlog_release"})
public final class VLogPreloadPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VLogPreloadPlayView.a Clw;
  public k BZC;
  private m<? super Long, ? super Long, z> BZD;
  public com.tencent.mm.plugin.vlog.player.c Cbb;
  public aa CdG;
  public HandlerThread Cll;
  public aq Clm;
  private m<? super Integer, ? super Integer, z> Cln;
  public volatile boolean Clo;
  private x Clv;
  private Rect hpa;
  public SurfaceTexture hwr;
  
  static
  {
    AppMethodBeat.i(111223);
    Clw = new VLogPreloadPlayView.a((byte)0);
    AppMethodBeat.o(111223);
  }
  
  public VLogPreloadPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(111222);
    paramContext = d.hg("VLogPlayView_PreviewPlayer", -4);
    p.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.Cll = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.CdS;
    this.Clv = com.tencent.mm.plugin.vlog.ui.manager.c.ewG();
    AppMethodBeat.o(111222);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111221);
    paramContext = d.hg("VLogPlayView_PreviewPlayer", -4);
    p.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.Cll = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.CdS;
    this.Clv = com.tencent.mm.plugin.vlog.ui.manager.c.ewG();
    AppMethodBeat.o(111221);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111220);
    paramContext = d.hg("VLogPlayView_PreviewPlayer", -4);
    p.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.Cll = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.CdS;
    this.Clv = com.tencent.mm.plugin.vlog.ui.manager.c.ewG();
    AppMethodBeat.o(111220);
  }
  
  public final Size getSize()
  {
    AppMethodBeat.i(192281);
    Object localObject = this.Cbb;
    if (localObject != null)
    {
      localObject = new Size(((com.tencent.mm.plugin.vlog.player.c)localObject).width, ((com.tencent.mm.plugin.vlog.player.c)localObject).height);
      AppMethodBeat.o(192281);
      return localObject;
    }
    AppMethodBeat.o(192281);
    return null;
  }
  
  public final void l(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111219);
    ae.i("MicroMsg.VLogPreloadPlayView", "bindPreloadManager surfaceTexture:".concat(String.valueOf(paramSurfaceTexture)));
    if (paramSurfaceTexture != null)
    {
      Object localObject1 = new StringBuilder("vLogDirector init : ");
      Object localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.CdS;
      localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.ewI();
      if (localObject2 != null)
      {
        i = localObject2.hashCode();
        localObject1 = ((StringBuilder)localObject1).append(i).append(", vLogSurface : ");
        localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.CdS;
        localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.ewH();
        if (localObject2 == null) {
          break label411;
        }
      }
      label411:
      for (int i = localObject2.hashCode();; i = 0)
      {
        ae.i("MicroMsg.VLogPreloadPlayView", i);
        localObject1 = com.tencent.mm.plugin.vlog.ui.manager.c.CdS;
        this.Cbb = com.tencent.mm.plugin.vlog.ui.manager.c.ewI();
        localObject1 = com.tencent.mm.plugin.vlog.ui.manager.c.CdS;
        this.BZC = ((k)com.tencent.mm.plugin.vlog.ui.manager.c.ewH());
        localObject1 = this.BZC;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.CdS;
          localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.ewH();
          if (localObject2 == null) {
            p.gkB();
          }
          localObject2 = ((g)localObject2).gNx;
          if (localObject2 == null) {
            p.gkB();
          }
          localObject2 = ((c.b)localObject2).hrF;
          Object localObject3 = com.tencent.mm.plugin.vlog.ui.manager.c.CdS;
          localObject3 = com.tencent.mm.plugin.vlog.ui.manager.c.ewH();
          if (localObject3 == null) {
            p.gkB();
          }
          localObject3 = ((g)localObject3).gNx;
          if (localObject3 == null) {
            p.gkB();
          }
          ((k)localObject1).a((EGLContext)localObject2, ((c.b)localObject3).hrE, new Surface(paramSurfaceTexture), getWidth(), getHeight());
        }
        localObject1 = this.CdG;
        if (localObject1 != null)
        {
          ae.i("MicroMsg.VLogPreloadPlayView", "later set model: " + this.CdG);
          localObject2 = this.Cbb;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.vlog.player.c)localObject2).a((aa)localObject1, ((aa)localObject1).getVideoDurationMs(), ((aa)localObject1).BYm);
          }
        }
        localObject1 = this.Cbb;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).ewn();
        }
        localObject1 = this.Cbb;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).BZD = ((m)new b(this, paramSurfaceTexture));
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).BZE = ((b)new c(this, paramSurfaceTexture));
          if (this.hpa != null) {
            ((com.tencent.mm.plugin.vlog.player.c)localObject1).setCropRect(this.hpa);
          }
        }
        paramSurfaceTexture = this.Cbb;
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.cS(getWidth(), getHeight());
        }
        paramSurfaceTexture = this.Cbb;
        if (paramSurfaceTexture == null) {
          break label416;
        }
        com.tencent.mm.plugin.vlog.player.c.a(paramSurfaceTexture, null, false, 7);
        AppMethodBeat.o(111219);
        return;
        i = 0;
        break;
      }
    }
    label416:
    AppMethodBeat.o(111219);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111217);
    ae.i("MicroMsg.VLogPreloadPlayView", "surfaceAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.hwr = paramSurfaceTexture;
    if (!this.Cll.isAlive())
    {
      this.Cll.start();
      ae.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is not alive, start");
    }
    for (;;)
    {
      this.Clm = new aq(this.Cll.getLooper());
      l(paramSurfaceTexture);
      paramSurfaceTexture = this.Cln;
      if (paramSurfaceTexture == null) {
        break;
      }
      paramSurfaceTexture.p(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(111217);
      return;
      ae.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is alive");
    }
    AppMethodBeat.o(111217);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111216);
    ae.i("MicroMsg.VLogPreloadPlayView", "surfaceDestroy");
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    AppMethodBeat.o(111216);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111215);
    ae.i("MicroMsg.VLogPreloadPlayView", "surfaceSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(111215);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(192280);
    if (this.Cbb == null)
    {
      this.hpa = paramRect;
      AppMethodBeat.o(192280);
      return;
    }
    com.tencent.mm.plugin.vlog.player.c localc = this.Cbb;
    if (localc != null)
    {
      localc.setCropRect(paramRect);
      AppMethodBeat.o(192280);
      return;
    }
    AppMethodBeat.o(192280);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(111218);
    com.tencent.mm.plugin.vlog.player.c localc = this.Cbb;
    if (localc != null)
    {
      localc.setMute(paramBoolean);
      AppMethodBeat.o(111218);
      return;
    }
    AppMethodBeat.o(111218);
  }
  
  public final void setOnProgressListener(m<? super Long, ? super Long, z> paramm)
  {
    this.BZD = paramm;
  }
  
  public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, z> paramm)
  {
    this.Cln = paramm;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "pts", "", "duration", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$1", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$1"})
  static final class b
    extends q
    implements m<Long, Long, z>
  {
    b(VLogPreloadPlayView paramVLogPreloadPlayView, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$2", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$2"})
  static final class c
    extends q
    implements b<Long, z>
  {
    c(VLogPreloadPlayView paramVLogPreloadPlayView, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView
 * JD-Core Version:    0.7.0.1
 */