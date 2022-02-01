package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.player.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.MMTextureView;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canResume", "", "cropRect", "Landroid/graphics/Rect;", "frameCount", "invokePrepareCallback", "isRendering", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "prepareCallback", "Lkotlin/Function0;", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "model", "reset", "resume", "setCropRect", "rect", "setMute", "mute", "setPrepareCallback", "stop", "updateFrameOnTime", "Companion", "plugin-vlog_release"})
public final class VLogPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final a zcV;
  com.tencent.mm.plugin.vlog.player.m LrT;
  com.tencent.mm.plugin.vlog.player.h Lti;
  int frameCount;
  private Rect gtE;
  boolean vsr;
  private d.g.a.m<? super Long, ? super Long, y> zaT;
  HandlerThread zcO;
  ap zcP;
  private d.g.a.m<? super Integer, ? super Integer, y> zcQ;
  volatile boolean zcR;
  com.tencent.mm.plugin.vlog.model.h zcS;
  a<y> zcT;
  boolean zcU;
  
  static
  {
    AppMethodBeat.i(111210);
    zcV = new a((byte)0);
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
    ad.i("MicroMsg.VLogPlayView", "surfaceAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.zcO = d.gv("VLogPlayView_PreviewPlayer", -4);
    Object localObject = this.zcO;
    if (localObject != null) {
      ((HandlerThread)localObject).start();
    }
    localObject = this.zcO;
    if (localObject != null) {}
    for (localObject = ((HandlerThread)localObject).getLooper();; localObject = null)
    {
      this.zcP = new ap((Looper)localObject);
      if (paramSurfaceTexture == null) {
        break;
      }
      this.LrT = ((com.tencent.mm.plugin.vlog.player.m)new i(paramInt1, paramInt2));
      localObject = this.LrT;
      if (localObject != null) {
        ((com.tencent.mm.plugin.vlog.player.m)localObject).l(new Surface(paramSurfaceTexture));
      }
      this.Lti = new com.tencent.mm.plugin.vlog.player.h(paramInt1, paramInt2);
      localObject = this.Lti;
      if (localObject != null)
      {
        com.tencent.mm.plugin.vlog.player.m localm = this.LrT;
        if (localm == null) {
          k.fvU();
        }
        ((com.tencent.mm.plugin.vlog.player.h)localObject).a(localm);
      }
      localObject = this.Lti;
      if (localObject != null) {
        ((com.tencent.mm.plugin.vlog.player.h)localObject).fYV();
      }
      localObject = this.zcQ;
      if (localObject != null) {
        ((d.g.a.m)localObject).n(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      localObject = this.Lti;
      if (localObject == null) {
        break;
      }
      ((com.tencent.mm.plugin.vlog.player.h)localObject).zaT = ((d.g.a.m)new b(this, paramInt1, paramInt2, paramSurfaceTexture));
      ((com.tencent.mm.plugin.vlog.player.h)localObject).LrU = ((b)new c(this, paramInt1, paramInt2, paramSurfaceTexture));
      paramSurfaceTexture = this.zcS;
      if (paramSurfaceTexture != null)
      {
        ad.i("MicroMsg.VLogPlayView", "play in onSurfaceTextureAvailable " + paramSurfaceTexture.hashCode());
        this.zcR = true;
        ((com.tencent.mm.plugin.vlog.player.h)localObject).a(paramSurfaceTexture, paramSurfaceTexture.getVideoDurationMs(), paramSurfaceTexture.yZt);
        com.tencent.mm.plugin.vlog.player.h.a((com.tencent.mm.plugin.vlog.player.h)localObject, null, false, 7);
        this.frameCount += 1;
      }
      if (this.gtE != null) {
        ((com.tencent.mm.plugin.vlog.player.h)localObject).setCropRect(this.gtE);
      }
      AppMethodBeat.o(111202);
      return;
    }
    AppMethodBeat.o(111202);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111201);
    ad.i("MicroMsg.VLogPlayView", "surfaceDestroy");
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    AppMethodBeat.o(111201);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111200);
    ad.i("MicroMsg.VLogPlayView", "surfaceSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(111200);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(201211);
    if (this.Lti == null)
    {
      this.gtE = paramRect;
      AppMethodBeat.o(201211);
      return;
    }
    com.tencent.mm.plugin.vlog.player.h localh = this.Lti;
    if (localh != null)
    {
      localh.setCropRect(paramRect);
      AppMethodBeat.o(201211);
      return;
    }
    AppMethodBeat.o(201211);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(111206);
    com.tencent.mm.plugin.vlog.player.h localh = this.Lti;
    if (localh != null)
    {
      localh.setMute(paramBoolean);
      AppMethodBeat.o(111206);
      return;
    }
    AppMethodBeat.o(111206);
  }
  
  public final void setPrepareCallback(a<y> parama)
  {
    AppMethodBeat.i(111207);
    k.h(parama, "prepareCallback");
    this.zcT = parama;
    AppMethodBeat.o(111207);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "pts", "", "duration", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$onSurfaceTextureAvailable$1$1$1", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$$special$$inlined$apply$lambda$1"})
  static final class b
    extends d.g.b.l
    implements d.g.a.m<Long, Long, y>
  {
    b(VLogPlayView paramVLogPlayView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$onSurfaceTextureAvailable$1$1$2", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$$special$$inlined$apply$lambda$2"})
  static final class c
    extends d.g.b.l
    implements b<Long, y>
  {
    c(VLogPlayView paramVLogPlayView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$updateFrameOnTime$1$1"})
  static final class d
    implements Runnable
  {
    d(com.tencent.mm.plugin.vlog.player.h paramh, VLogPlayView paramVLogPlayView) {}
    
    public final void run()
    {
      AppMethodBeat.i(111199);
      com.tencent.mm.plugin.vlog.player.h.a(this.Lva, null, false, 7);
      VLogPlayView localVLogPlayView = this.zcW;
      VLogPlayView.a(localVLogPlayView, VLogPlayView.c(localVLogPlayView) + 1);
      AppMethodBeat.o(111199);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogPlayView
 * JD-Core Version:    0.7.0.1
 */