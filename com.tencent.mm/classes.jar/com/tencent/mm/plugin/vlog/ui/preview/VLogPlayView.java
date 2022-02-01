package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.player.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.base.MMTextureView;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canResume", "", "cropRect", "Landroid/graphics/Rect;", "frameCount", "invokePrepareCallback", "isRendering", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "prepareCallback", "Lkotlin/Function0;", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "model", "reset", "resume", "setCropRect", "rect", "setMute", "mute", "setPrepareCallback", "stop", "updateFrameOnTime", "Companion", "plugin-vlog_release"})
public final class VLogPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VLogPlayView.a AuG;
  com.tencent.mm.plugin.vlog.player.l ApF;
  private m<? super Long, ? super Long, d.y> ApG;
  private m<? super Integer, ? super Integer, d.y> Apv;
  com.tencent.mm.plugin.vlog.player.d ArL;
  HandlerThread AuA;
  ao AuB;
  volatile boolean AuC;
  com.tencent.mm.plugin.vlog.model.y AuD;
  a<d.y> AuE;
  boolean AuF;
  int frameCount;
  private Rect gUl;
  boolean wCr;
  
  static
  {
    AppMethodBeat.i(111210);
    AuG = new VLogPlayView.a((byte)0);
    AppMethodBeat.o(111210);
  }
  
  public VLogPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111209);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    AppMethodBeat.o(111209);
  }
  
  public VLogPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111208);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    AppMethodBeat.o(111208);
  }
  
  public final void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(111202);
    ac.i("MicroMsg.VLogPlayView", "surfaceAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.AuA = com.tencent.e.c.d.gz("VLogPlayView_PreviewPlayer", -4);
    Object localObject = this.AuA;
    if (localObject != null) {
      ((HandlerThread)localObject).start();
    }
    localObject = this.AuA;
    if (localObject != null) {}
    for (localObject = ((HandlerThread)localObject).getLooper();; localObject = null)
    {
      this.AuB = new ao((Looper)localObject);
      if (paramSurfaceTexture == null) {
        break;
      }
      this.ApF = ((com.tencent.mm.plugin.vlog.player.l)new h(paramInt1, paramInt2));
      localObject = this.ApF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.vlog.player.l)localObject).k(new Surface(paramSurfaceTexture));
      }
      this.ArL = new com.tencent.mm.plugin.vlog.player.d(paramInt1, paramInt2);
      localObject = this.ArL;
      if (localObject != null)
      {
        com.tencent.mm.plugin.vlog.player.l locall = this.ApF;
        if (locall == null) {
          k.fOy();
        }
        ((com.tencent.mm.plugin.vlog.player.d)localObject).a(locall);
      }
      localObject = this.ArL;
      if (localObject != null) {
        ((com.tencent.mm.plugin.vlog.player.d)localObject).efS();
      }
      localObject = this.Apv;
      if (localObject != null) {
        ((m)localObject).n(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      localObject = this.ArL;
      if (localObject == null) {
        break;
      }
      ((com.tencent.mm.plugin.vlog.player.d)localObject).ApG = ((m)new b(this, paramInt1, paramInt2, paramSurfaceTexture));
      ((com.tencent.mm.plugin.vlog.player.d)localObject).ApH = ((b)new c(this, paramInt1, paramInt2, paramSurfaceTexture));
      paramSurfaceTexture = this.AuD;
      if (paramSurfaceTexture != null)
      {
        ac.i("MicroMsg.VLogPlayView", "play in onSurfaceTextureAvailable " + paramSurfaceTexture.hashCode());
        this.AuC = true;
        ((com.tencent.mm.plugin.vlog.player.d)localObject).a(paramSurfaceTexture, paramSurfaceTexture.getVideoDurationMs(), paramSurfaceTexture.AoW);
        com.tencent.mm.plugin.vlog.player.d.a((com.tencent.mm.plugin.vlog.player.d)localObject, null, false, 7);
        this.frameCount += 1;
      }
      if (this.gUl != null) {
        ((com.tencent.mm.plugin.vlog.player.d)localObject).setCropRect(this.gUl);
      }
      AppMethodBeat.o(111202);
      return;
    }
    AppMethodBeat.o(111202);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111201);
    ac.i("MicroMsg.VLogPlayView", "surfaceDestroy");
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    AppMethodBeat.o(111201);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111200);
    ac.i("MicroMsg.VLogPlayView", "surfaceSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(111200);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(207896);
    if (this.ArL == null)
    {
      this.gUl = paramRect;
      AppMethodBeat.o(207896);
      return;
    }
    com.tencent.mm.plugin.vlog.player.d locald = this.ArL;
    if (locald != null)
    {
      locald.setCropRect(paramRect);
      AppMethodBeat.o(207896);
      return;
    }
    AppMethodBeat.o(207896);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(111206);
    com.tencent.mm.plugin.vlog.player.d locald = this.ArL;
    if (locald != null)
    {
      locald.setMute(paramBoolean);
      AppMethodBeat.o(111206);
      return;
    }
    AppMethodBeat.o(111206);
  }
  
  public final void setPrepareCallback(a<d.y> parama)
  {
    AppMethodBeat.i(111207);
    k.h(parama, "prepareCallback");
    this.AuE = parama;
    AppMethodBeat.o(111207);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "pts", "", "duration", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$onSurfaceTextureAvailable$1$1$1", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$$special$$inlined$apply$lambda$1"})
  static final class b
    extends d.g.b.l
    implements m<Long, Long, d.y>
  {
    b(VLogPlayView paramVLogPlayView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$onSurfaceTextureAvailable$1$1$2", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$$special$$inlined$apply$lambda$2"})
  static final class c
    extends d.g.b.l
    implements b<Long, d.y>
  {
    c(VLogPlayView paramVLogPlayView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$updateFrameOnTime$1$1"})
  static final class d
    implements Runnable
  {
    d(com.tencent.mm.plugin.vlog.player.d paramd, VLogPlayView paramVLogPlayView) {}
    
    public final void run()
    {
      AppMethodBeat.i(111199);
      com.tencent.mm.plugin.vlog.player.d.a(this.AuI, null, false, 7);
      VLogPlayView localVLogPlayView = this.AuH;
      VLogPlayView.a(localVLogPlayView, VLogPlayView.c(localVLogPlayView) + 1);
      AppMethodBeat.o(111199);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogPlayView
 * JD-Core Version:    0.7.0.1
 */