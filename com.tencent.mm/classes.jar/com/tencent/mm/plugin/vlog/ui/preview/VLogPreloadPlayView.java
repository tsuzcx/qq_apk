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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.MMTextureView;
import d.g.a.b;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cropRect", "Landroid/graphics/Rect;", "isRendering", "", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "texture", "Landroid/graphics/SurfaceTexture;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "bindPreloadManager", "surfaceTexture", "clearCurrentScript", "detachPreloadManager", "getSize", "Landroid/util/Size;", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "resume", "setCropRect", "rect", "setMute", "mute", "setOnProgressListener", "setOnSizeChangedListener", "updateFrameOnTime", "Companion", "plugin-vlog_release"})
public final class VLogPreloadPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VLogPreloadPlayView.a BTV;
  public k BId;
  private m<? super Long, ? super Long, z> BIe;
  public com.tencent.mm.plugin.vlog.player.c BJC;
  public aa BMh;
  public HandlerThread BTK;
  public ap BTL;
  private m<? super Integer, ? super Integer, z> BTM;
  public volatile boolean BTN;
  private x BTU;
  private Rect hmm;
  public SurfaceTexture htD;
  
  static
  {
    AppMethodBeat.i(111223);
    BTV = new VLogPreloadPlayView.a((byte)0);
    AppMethodBeat.o(111223);
  }
  
  public VLogPreloadPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(111222);
    paramContext = d.gX("VLogPlayView_PreviewPlayer", -4);
    p.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.BTK = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.BMt;
    this.BTU = com.tencent.mm.plugin.vlog.ui.manager.c.esZ();
    AppMethodBeat.o(111222);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111221);
    paramContext = d.gX("VLogPlayView_PreviewPlayer", -4);
    p.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.BTK = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.BMt;
    this.BTU = com.tencent.mm.plugin.vlog.ui.manager.c.esZ();
    AppMethodBeat.o(111221);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111220);
    paramContext = d.gX("VLogPlayView_PreviewPlayer", -4);
    p.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.BTK = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.BMt;
    this.BTU = com.tencent.mm.plugin.vlog.ui.manager.c.esZ();
    AppMethodBeat.o(111220);
  }
  
  public final Size getSize()
  {
    AppMethodBeat.i(196818);
    Object localObject = this.BJC;
    if (localObject != null)
    {
      localObject = new Size(((com.tencent.mm.plugin.vlog.player.c)localObject).width, ((com.tencent.mm.plugin.vlog.player.c)localObject).height);
      AppMethodBeat.o(196818);
      return localObject;
    }
    AppMethodBeat.o(196818);
    return null;
  }
  
  public final void l(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111219);
    ad.i("MicroMsg.VLogPreloadPlayView", "bindPreloadManager surfaceTexture:".concat(String.valueOf(paramSurfaceTexture)));
    if (paramSurfaceTexture != null)
    {
      Object localObject1 = new StringBuilder("vLogDirector init : ");
      Object localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.BMt;
      localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.etb();
      if (localObject2 != null)
      {
        i = localObject2.hashCode();
        localObject1 = ((StringBuilder)localObject1).append(i).append(", vLogSurface : ");
        localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.BMt;
        localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.eta();
        if (localObject2 == null) {
          break label411;
        }
      }
      label411:
      for (int i = localObject2.hashCode();; i = 0)
      {
        ad.i("MicroMsg.VLogPreloadPlayView", i);
        localObject1 = com.tencent.mm.plugin.vlog.ui.manager.c.BMt;
        this.BJC = com.tencent.mm.plugin.vlog.ui.manager.c.etb();
        localObject1 = com.tencent.mm.plugin.vlog.ui.manager.c.BMt;
        this.BId = ((k)com.tencent.mm.plugin.vlog.ui.manager.c.eta());
        localObject1 = this.BId;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.BMt;
          localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.eta();
          if (localObject2 == null) {
            p.gfZ();
          }
          localObject2 = ((g)localObject2).gKO;
          if (localObject2 == null) {
            p.gfZ();
          }
          localObject2 = ((c.b)localObject2).hoR;
          Object localObject3 = com.tencent.mm.plugin.vlog.ui.manager.c.BMt;
          localObject3 = com.tencent.mm.plugin.vlog.ui.manager.c.eta();
          if (localObject3 == null) {
            p.gfZ();
          }
          localObject3 = ((g)localObject3).gKO;
          if (localObject3 == null) {
            p.gfZ();
          }
          ((k)localObject1).a((EGLContext)localObject2, ((c.b)localObject3).hoQ, new Surface(paramSurfaceTexture), getWidth(), getHeight());
        }
        localObject1 = this.BMh;
        if (localObject1 != null)
        {
          ad.i("MicroMsg.VLogPreloadPlayView", "later set model: " + this.BMh);
          localObject2 = this.BJC;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.vlog.player.c)localObject2).a((aa)localObject1, ((aa)localObject1).getVideoDurationMs(), ((aa)localObject1).BGN);
          }
        }
        localObject1 = this.BJC;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).esG();
        }
        localObject1 = this.BJC;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).BIe = ((m)new b(this, paramSurfaceTexture));
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).BIf = ((b)new c(this, paramSurfaceTexture));
          if (this.hmm != null) {
            ((com.tencent.mm.plugin.vlog.player.c)localObject1).setCropRect(this.hmm);
          }
        }
        paramSurfaceTexture = this.BJC;
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.cS(getWidth(), getHeight());
        }
        paramSurfaceTexture = this.BJC;
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
    ad.i("MicroMsg.VLogPreloadPlayView", "surfaceAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.htD = paramSurfaceTexture;
    if (!this.BTK.isAlive())
    {
      this.BTK.start();
      ad.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is not alive, start");
    }
    for (;;)
    {
      this.BTL = new ap(this.BTK.getLooper());
      l(paramSurfaceTexture);
      paramSurfaceTexture = this.BTM;
      if (paramSurfaceTexture == null) {
        break;
      }
      paramSurfaceTexture.p(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
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
    AppMethodBeat.i(196817);
    if (this.BJC == null)
    {
      this.hmm = paramRect;
      AppMethodBeat.o(196817);
      return;
    }
    com.tencent.mm.plugin.vlog.player.c localc = this.BJC;
    if (localc != null)
    {
      localc.setCropRect(paramRect);
      AppMethodBeat.o(196817);
      return;
    }
    AppMethodBeat.o(196817);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(111218);
    com.tencent.mm.plugin.vlog.player.c localc = this.BJC;
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
    this.BIe = paramm;
  }
  
  public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, z> paramm)
  {
    this.BTM = paramm;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "pts", "", "duration", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$1", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$1"})
  static final class b
    extends q
    implements m<Long, Long, z>
  {
    b(VLogPreloadPlayView paramVLogPreloadPlayView, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$2", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$2"})
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