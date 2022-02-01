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
import com.tencent.mm.plugin.vlog.player.c;
import com.tencent.mm.plugin.vlog.player.g;
import com.tencent.mm.plugin.vlog.player.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.threadpool.c.d;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canResume", "", "cropRect", "Landroid/graphics/Rect;", "frameCount", "invokePrepareCallback", "isRendering", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "prepareCallback", "Lkotlin/Function0;", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "model", "reset", "resume", "setCropRect", "rect", "setMute", "mute", "setPrepareCallback", "stop", "updateFrameOnTime", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VLogPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VLogPlayView.a UoA;
  private Rect Gl;
  boolean NXm;
  j UcX;
  private m<? super Long, ? super Long, kotlin.ah> UcY;
  c Uep;
  HandlerThread UoB;
  MMHandler UoC;
  private m<? super Integer, ? super Integer, kotlin.ah> UoD;
  public volatile boolean UoE;
  com.tencent.mm.plugin.vlog.model.ah UoF;
  a<kotlin.ah> UoG;
  boolean UoH;
  int frameCount;
  
  static
  {
    AppMethodBeat.i(111210);
    UoA = new VLogPlayView.a((byte)0);
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
  
  private static final void a(c paramc, VLogPlayView paramVLogPlayView)
  {
    AppMethodBeat.i(281546);
    s.u(paramc, "$this_apply");
    s.u(paramVLogPlayView, "this$0");
    c.a(paramc, null, false, 7);
    paramVLogPlayView.frameCount += 1;
    AppMethodBeat.o(281546);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111202);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.VLogPlayView", "surfaceAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.UoB = d.jw("VLogPlayView_PreviewPlayer", -4);
    Object localObject = this.UoB;
    if (localObject != null) {
      ((HandlerThread)localObject).start();
    }
    localObject = this.UoB;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((HandlerThread)localObject).getLooper())
    {
      this.UoC = new MMHandler((Looper)localObject);
      this.UcX = ((j)new g(paramInt1, paramInt2));
      localObject = this.UcX;
      if (localObject != null) {
        ((j)localObject).t(new Surface(paramSurfaceTexture));
      }
      this.Uep = new c(paramInt1, paramInt2);
      paramSurfaceTexture = this.Uep;
      if (paramSurfaceTexture != null)
      {
        localObject = this.UcX;
        s.checkNotNull(localObject);
        paramSurfaceTexture.a((j)localObject);
      }
      paramSurfaceTexture = this.Uep;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.hRZ();
      }
      paramSurfaceTexture = this.UoD;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      paramSurfaceTexture = this.Uep;
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.UcY = ((m)new b(this));
        paramSurfaceTexture.UcZ = ((b)new c(this));
        localObject = this.UoF;
        if (localObject != null)
        {
          Log.i("MicroMsg.VLogPlayView", s.X("play in onSurfaceTextureAvailable ", Integer.valueOf(((com.tencent.mm.plugin.vlog.model.ah)localObject).hashCode())));
          this.UoE = true;
          paramSurfaceTexture.a((com.tencent.mm.plugin.vlog.model.ah)localObject, ((com.tencent.mm.plugin.vlog.model.ah)localObject).getVideoDurationMs(), ((com.tencent.mm.plugin.vlog.model.ah)localObject).UaZ);
          c.a(paramSurfaceTexture, null, false, 7);
          this.frameCount += 1;
        }
        if (this.Gl != null) {
          paramSurfaceTexture.setCropRect(this.Gl);
        }
      }
      AppMethodBeat.o(111202);
      return;
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111201);
    s.u(paramSurfaceTexture, "surface");
    Log.i("MicroMsg.VLogPlayView", "surfaceDestroy");
    paramSurfaceTexture.release();
    AppMethodBeat.o(111201);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111200);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.VLogPlayView", "surfaceSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(111200);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(281585);
    s.u(paramSurfaceTexture, "surface");
    AppMethodBeat.o(281585);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(281576);
    if (this.Uep == null)
    {
      this.Gl = paramRect;
      AppMethodBeat.o(281576);
      return;
    }
    c localc = this.Uep;
    if (localc != null) {
      localc.setCropRect(paramRect);
    }
    AppMethodBeat.o(281576);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(111206);
    c localc = this.Uep;
    if (localc != null) {
      localc.setMute(paramBoolean);
    }
    AppMethodBeat.o(111206);
  }
  
  public final void setPrepareCallback(a<kotlin.ah> parama)
  {
    AppMethodBeat.i(111207);
    s.u(parama, "prepareCallback");
    this.UoG = parama;
    AppMethodBeat.o(111207);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pts", "", "duration"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Long, Long, kotlin.ah>
  {
    b(VLogPlayView paramVLogPlayView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<Long, kotlin.ah>
  {
    c(VLogPlayView paramVLogPlayView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogPlayView
 * JD-Core Version:    0.7.0.1
 */