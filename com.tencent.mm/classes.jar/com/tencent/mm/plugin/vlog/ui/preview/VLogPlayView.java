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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.MMTextureView;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canResume", "", "cropRect", "Landroid/graphics/Rect;", "frameCount", "invokePrepareCallback", "isRendering", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "prepareCallback", "Lkotlin/Function0;", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "model", "reset", "resume", "setCropRect", "rect", "setMute", "mute", "setPrepareCallback", "stop", "updateFrameOnTime", "Companion", "plugin-vlog_release"})
public final class VLogPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VLogPlayView.a Cls;
  k BZC;
  private m<? super Long, ? super Long, z> BZD;
  c Cbb;
  HandlerThread Cll;
  aq Clm;
  private m<? super Integer, ? super Integer, z> Cln;
  volatile boolean Clo;
  aa Clp;
  a<z> Clq;
  boolean Clr;
  int frameCount;
  private Rect hpa;
  boolean ydj;
  
  static
  {
    AppMethodBeat.i(111210);
    Cls = new VLogPlayView.a((byte)0);
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
    ae.i("MicroMsg.VLogPlayView", "surfaceAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.Cll = d.hg("VLogPlayView_PreviewPlayer", -4);
    Object localObject = this.Cll;
    if (localObject != null) {
      ((HandlerThread)localObject).start();
    }
    localObject = this.Cll;
    if (localObject != null) {}
    for (localObject = ((HandlerThread)localObject).getLooper();; localObject = null)
    {
      this.Clm = new aq((Looper)localObject);
      if (paramSurfaceTexture == null) {
        break;
      }
      this.BZC = ((k)new g(paramInt1, paramInt2));
      localObject = this.BZC;
      if (localObject != null) {
        ((k)localObject).k(new Surface(paramSurfaceTexture));
      }
      this.Cbb = new c(paramInt1, paramInt2);
      localObject = this.Cbb;
      if (localObject != null)
      {
        k localk = this.BZC;
        if (localk == null) {
          p.gkB();
        }
        ((c)localObject).a(localk);
      }
      localObject = this.Cbb;
      if (localObject != null) {
        ((c)localObject).ewm();
      }
      localObject = this.Cln;
      if (localObject != null) {
        ((m)localObject).p(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      localObject = this.Cbb;
      if (localObject == null) {
        break;
      }
      ((c)localObject).BZD = ((m)new b(this, paramInt1, paramInt2, paramSurfaceTexture));
      ((c)localObject).BZE = ((b)new c(this, paramInt1, paramInt2, paramSurfaceTexture));
      paramSurfaceTexture = this.Clp;
      if (paramSurfaceTexture != null)
      {
        ae.i("MicroMsg.VLogPlayView", "play in onSurfaceTextureAvailable " + paramSurfaceTexture.hashCode());
        this.Clo = true;
        ((c)localObject).a(paramSurfaceTexture, paramSurfaceTexture.getVideoDurationMs(), paramSurfaceTexture.BYm);
        c.a((c)localObject, null, false, 7);
        this.frameCount += 1;
      }
      if (this.hpa != null) {
        ((c)localObject).setCropRect(this.hpa);
      }
      AppMethodBeat.o(111202);
      return;
    }
    AppMethodBeat.o(111202);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111201);
    ae.i("MicroMsg.VLogPlayView", "surfaceDestroy");
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    AppMethodBeat.o(111201);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111200);
    ae.i("MicroMsg.VLogPlayView", "surfaceSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(111200);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(192279);
    if (this.Cbb == null)
    {
      this.hpa = paramRect;
      AppMethodBeat.o(192279);
      return;
    }
    c localc = this.Cbb;
    if (localc != null)
    {
      localc.setCropRect(paramRect);
      AppMethodBeat.o(192279);
      return;
    }
    AppMethodBeat.o(192279);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(111206);
    c localc = this.Cbb;
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
    this.Clq = parama;
    AppMethodBeat.o(111207);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "pts", "", "duration", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$onSurfaceTextureAvailable$1$1$1", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$$special$$inlined$apply$lambda$1"})
  static final class b
    extends q
    implements m<Long, Long, z>
  {
    b(VLogPlayView paramVLogPlayView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$onSurfaceTextureAvailable$1$1$2", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$$special$$inlined$apply$lambda$2"})
  static final class c
    extends q
    implements b<Long, z>
  {
    c(VLogPlayView paramVLogPlayView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$updateFrameOnTime$1$1"})
  static final class d
    implements Runnable
  {
    d(c paramc, VLogPlayView paramVLogPlayView) {}
    
    public final void run()
    {
      AppMethodBeat.i(111199);
      c.a(this.Clu, null, false, 7);
      VLogPlayView localVLogPlayView = this.Clt;
      VLogPlayView.a(localVLogPlayView, VLogPlayView.c(localVLogPlayView) + 1);
      AppMethodBeat.o(111199);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogPlayView
 * JD-Core Version:    0.7.0.1
 */