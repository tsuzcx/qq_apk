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
import com.tencent.mm.plugin.vlog.model.aa;
import com.tencent.mm.plugin.vlog.player.c;
import com.tencent.mm.plugin.vlog.player.g;
import com.tencent.mm.plugin.vlog.player.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.MMTextureView;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canResume", "", "cropRect", "Landroid/graphics/Rect;", "frameCount", "invokePrepareCallback", "isRendering", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "prepareCallback", "Lkotlin/Function0;", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "model", "reset", "resume", "setCropRect", "rect", "setMute", "mute", "setPrepareCallback", "stop", "updateFrameOnTime", "Companion", "plugin-vlog_release"})
public final class VLogPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VLogPlayView.a BTR;
  k BId;
  private m<? super Long, ? super Long, z> BIe;
  c BJC;
  HandlerThread BTK;
  ap BTL;
  private m<? super Integer, ? super Integer, z> BTM;
  volatile boolean BTN;
  aa BTO;
  a<z> BTP;
  boolean BTQ;
  int frameCount;
  private Rect hmm;
  boolean xNq;
  
  static
  {
    AppMethodBeat.i(111210);
    BTR = new VLogPlayView.a((byte)0);
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
    this.BTK = d.gX("VLogPlayView_PreviewPlayer", -4);
    Object localObject = this.BTK;
    if (localObject != null) {
      ((HandlerThread)localObject).start();
    }
    localObject = this.BTK;
    if (localObject != null) {}
    for (localObject = ((HandlerThread)localObject).getLooper();; localObject = null)
    {
      this.BTL = new ap((Looper)localObject);
      if (paramSurfaceTexture == null) {
        break;
      }
      this.BId = ((k)new g(paramInt1, paramInt2));
      localObject = this.BId;
      if (localObject != null) {
        ((k)localObject).k(new Surface(paramSurfaceTexture));
      }
      this.BJC = new c(paramInt1, paramInt2);
      localObject = this.BJC;
      if (localObject != null)
      {
        k localk = this.BId;
        if (localk == null) {
          p.gfZ();
        }
        ((c)localObject).a(localk);
      }
      localObject = this.BJC;
      if (localObject != null) {
        ((c)localObject).esF();
      }
      localObject = this.BTM;
      if (localObject != null) {
        ((m)localObject).p(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      localObject = this.BJC;
      if (localObject == null) {
        break;
      }
      ((c)localObject).BIe = ((m)new b(this, paramInt1, paramInt2, paramSurfaceTexture));
      ((c)localObject).BIf = ((b)new c(this, paramInt1, paramInt2, paramSurfaceTexture));
      paramSurfaceTexture = this.BTO;
      if (paramSurfaceTexture != null)
      {
        ad.i("MicroMsg.VLogPlayView", "play in onSurfaceTextureAvailable " + paramSurfaceTexture.hashCode());
        this.BTN = true;
        ((c)localObject).a(paramSurfaceTexture, paramSurfaceTexture.getVideoDurationMs(), paramSurfaceTexture.BGN);
        c.a((c)localObject, null, false, 7);
        this.frameCount += 1;
      }
      if (this.hmm != null) {
        ((c)localObject).setCropRect(this.hmm);
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
    AppMethodBeat.i(196816);
    if (this.BJC == null)
    {
      this.hmm = paramRect;
      AppMethodBeat.o(196816);
      return;
    }
    c localc = this.BJC;
    if (localc != null)
    {
      localc.setCropRect(paramRect);
      AppMethodBeat.o(196816);
      return;
    }
    AppMethodBeat.o(196816);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(111206);
    c localc = this.BJC;
    if (localc != null)
    {
      localc.setMute(paramBoolean);
      AppMethodBeat.o(111206);
      return;
    }
    AppMethodBeat.o(111206);
  }
  
  public final void setPrepareCallback(a<z> parama)
  {
    AppMethodBeat.i(111207);
    p.h(parama, "prepareCallback");
    this.BTP = parama;
    AppMethodBeat.o(111207);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "pts", "", "duration", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$onSurfaceTextureAvailable$1$1$1", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$$special$$inlined$apply$lambda$1"})
  static final class b
    extends q
    implements m<Long, Long, z>
  {
    b(VLogPlayView paramVLogPlayView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$onSurfaceTextureAvailable$1$1$2", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$$special$$inlined$apply$lambda$2"})
  static final class c
    extends q
    implements b<Long, z>
  {
    c(VLogPlayView paramVLogPlayView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$updateFrameOnTime$1$1"})
  static final class d
    implements Runnable
  {
    d(c paramc, VLogPlayView paramVLogPlayView) {}
    
    public final void run()
    {
      AppMethodBeat.i(111199);
      c.a(this.BTT, null, false, 7);
      VLogPlayView localVLogPlayView = this.BTS;
      VLogPlayView.a(localVLogPlayView, VLogPlayView.c(localVLogPlayView) + 1);
      AppMethodBeat.o(111199);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogPlayView
 * JD-Core Version:    0.7.0.1
 */