package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.player.c;
import com.tencent.mm.plugin.vlog.player.g;
import com.tencent.mm.plugin.vlog.player.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MMTextureView;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canResume", "", "cropRect", "Landroid/graphics/Rect;", "frameCount", "invokePrepareCallback", "isRendering", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "prepareCallback", "Lkotlin/Function0;", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "model", "reset", "resume", "setCropRect", "rect", "setMute", "mute", "setPrepareCallback", "stop", "updateFrameOnTime", "Companion", "plugin-vlog_release"})
public final class VLogPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VLogPlayView.a GOu;
  boolean Cel;
  k GBp;
  private m<? super Long, ? super Long, x> GBq;
  c GCP;
  HandlerThread GOn;
  MMHandler GOo;
  private m<? super Integer, ? super Integer, x> GOp;
  volatile boolean GOq;
  ah GOr;
  a<x> GOs;
  boolean GOt;
  int frameCount;
  private Rect iiw;
  
  static
  {
    AppMethodBeat.i(111210);
    GOu = new VLogPlayView.a((byte)0);
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
    Log.i("MicroMsg.VLogPlayView", "surfaceAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.GOn = d.hA("VLogPlayView_PreviewPlayer", -4);
    Object localObject = this.GOn;
    if (localObject != null) {
      ((HandlerThread)localObject).start();
    }
    localObject = this.GOn;
    if (localObject != null) {}
    for (localObject = ((HandlerThread)localObject).getLooper();; localObject = null)
    {
      this.GOo = new MMHandler((Looper)localObject);
      if (paramSurfaceTexture == null) {
        break;
      }
      this.GBp = ((k)new g(paramInt1, paramInt2));
      localObject = this.GBp;
      if (localObject != null) {
        ((k)localObject).k(new Surface(paramSurfaceTexture));
      }
      this.GCP = new c(paramInt1, paramInt2);
      localObject = this.GCP;
      if (localObject != null)
      {
        k localk = this.GBp;
        if (localk == null) {
          p.hyc();
        }
        ((c)localObject).a(localk);
      }
      localObject = this.GCP;
      if (localObject != null) {
        ((c)localObject).fCl();
      }
      localObject = this.GOp;
      if (localObject != null) {
        ((m)localObject).invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      localObject = this.GCP;
      if (localObject == null) {
        break;
      }
      ((c)localObject).GBq = ((m)new b(this, paramInt1, paramInt2, paramSurfaceTexture));
      ((c)localObject).GBr = ((b)new c(this, paramInt1, paramInt2, paramSurfaceTexture));
      paramSurfaceTexture = this.GOr;
      if (paramSurfaceTexture != null)
      {
        Log.i("MicroMsg.VLogPlayView", "play in onSurfaceTextureAvailable " + paramSurfaceTexture.hashCode());
        this.GOq = true;
        ((c)localObject).a(paramSurfaceTexture, paramSurfaceTexture.getVideoDurationMs(), paramSurfaceTexture.GzR);
        c.a((c)localObject, null, false, 7);
        this.frameCount += 1;
      }
      if (this.iiw != null) {
        ((c)localObject).setCropRect(this.iiw);
      }
      AppMethodBeat.o(111202);
      return;
    }
    AppMethodBeat.o(111202);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111201);
    Log.i("MicroMsg.VLogPlayView", "surfaceDestroy");
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    AppMethodBeat.o(111201);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111200);
    Log.i("MicroMsg.VLogPlayView", "surfaceSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(111200);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(192019);
    if (this.GCP == null)
    {
      this.iiw = paramRect;
      AppMethodBeat.o(192019);
      return;
    }
    c localc = this.GCP;
    if (localc != null)
    {
      localc.setCropRect(paramRect);
      AppMethodBeat.o(192019);
      return;
    }
    AppMethodBeat.o(192019);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(111206);
    c localc = this.GCP;
    if (localc != null)
    {
      localc.setMute(paramBoolean);
      AppMethodBeat.o(111206);
      return;
    }
    AppMethodBeat.o(111206);
  }
  
  public final void setPrepareCallback(a<x> parama)
  {
    AppMethodBeat.i(111207);
    p.h(parama, "prepareCallback");
    this.GOs = parama;
    AppMethodBeat.o(111207);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "pts", "", "duration", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$onSurfaceTextureAvailable$1$1$1", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$$special$$inlined$apply$lambda$1"})
  static final class b
    extends q
    implements m<Long, Long, x>
  {
    b(VLogPlayView paramVLogPlayView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$onSurfaceTextureAvailable$1$1$2", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$$special$$inlined$apply$lambda$2"})
  static final class c
    extends q
    implements b<Long, x>
  {
    c(VLogPlayView paramVLogPlayView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/ui/preview/VLogPlayView$updateFrameOnTime$1$1"})
  static final class d
    implements Runnable
  {
    d(c paramc, VLogPlayView paramVLogPlayView) {}
    
    public final void run()
    {
      AppMethodBeat.i(111199);
      c.a(this.GOw, null, false, 7);
      VLogPlayView localVLogPlayView = this.GOv;
      VLogPlayView.a(localVLogPlayView, VLogPlayView.c(localVLogPlayView) + 1);
      AppMethodBeat.o(111199);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogPlayView
 * JD-Core Version:    0.7.0.1
 */