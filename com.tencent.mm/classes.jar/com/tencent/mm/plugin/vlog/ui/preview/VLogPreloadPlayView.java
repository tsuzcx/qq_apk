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
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.player.g;
import com.tencent.mm.plugin.vlog.player.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MMTextureView;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cropRect", "Landroid/graphics/Rect;", "isRendering", "", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "texture", "Landroid/graphics/SurfaceTexture;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "bindPreloadManager", "surfaceTexture", "clearCurrentScript", "detachPreloadManager", "getSize", "Landroid/util/Size;", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "resume", "setCropRect", "rect", "setMute", "mute", "setOnProgressListener", "setOnSizeChangedListener", "updateFrameOnTime", "Companion", "plugin-vlog_release"})
public final class VLogPreloadPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VLogPreloadPlayView.a GOy;
  public k GBp;
  private m<? super Long, ? super Long, x> GBq;
  public com.tencent.mm.plugin.vlog.player.c GCP;
  public ah GFW;
  public HandlerThread GOn;
  public MMHandler GOo;
  private m<? super Integer, ? super Integer, x> GOp;
  public volatile boolean GOq;
  private ae GOx;
  private Rect iiw;
  public SurfaceTexture ipT;
  
  static
  {
    AppMethodBeat.i(111223);
    GOy = new VLogPreloadPlayView.a((byte)0);
    AppMethodBeat.o(111223);
  }
  
  public VLogPreloadPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(111222);
    paramContext = d.hA("VLogPlayView_PreviewPlayer", -4);
    p.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.GOn = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
    this.GOx = com.tencent.mm.plugin.vlog.ui.manager.c.fCM();
    AppMethodBeat.o(111222);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111221);
    paramContext = d.hA("VLogPlayView_PreviewPlayer", -4);
    p.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.GOn = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
    this.GOx = com.tencent.mm.plugin.vlog.ui.manager.c.fCM();
    AppMethodBeat.o(111221);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111220);
    paramContext = d.hA("VLogPlayView_PreviewPlayer", -4);
    p.g(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.GOn = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
    this.GOx = com.tencent.mm.plugin.vlog.ui.manager.c.fCM();
    AppMethodBeat.o(111220);
  }
  
  public final Size getSize()
  {
    AppMethodBeat.i(192021);
    Object localObject = this.GCP;
    if (localObject != null)
    {
      localObject = new Size(((com.tencent.mm.plugin.vlog.player.c)localObject).width, ((com.tencent.mm.plugin.vlog.player.c)localObject).height);
      AppMethodBeat.o(192021);
      return localObject;
    }
    AppMethodBeat.o(192021);
    return null;
  }
  
  public final void n(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111219);
    Log.i("MicroMsg.VLogPreloadPlayView", "bindPreloadManager surfaceTexture:".concat(String.valueOf(paramSurfaceTexture)));
    if (paramSurfaceTexture != null)
    {
      Object localObject1 = new StringBuilder("vLogDirector init : ");
      Object localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
      localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.fCO();
      if (localObject2 != null)
      {
        i = localObject2.hashCode();
        localObject1 = ((StringBuilder)localObject1).append(i).append(", vLogSurface : ");
        localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
        localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.fCN();
        if (localObject2 == null) {
          break label411;
        }
      }
      label411:
      for (int i = localObject2.hashCode();; i = 0)
      {
        Log.i("MicroMsg.VLogPreloadPlayView", i);
        localObject1 = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
        this.GCP = com.tencent.mm.plugin.vlog.ui.manager.c.fCO();
        localObject1 = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
        this.GBp = ((k)com.tencent.mm.plugin.vlog.ui.manager.c.fCN());
        localObject1 = this.GBp;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
          localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.fCN();
          if (localObject2 == null) {
            p.hyc();
          }
          localObject2 = ((g)localObject2).hDs;
          if (localObject2 == null) {
            p.hyc();
          }
          localObject2 = ((c.b)localObject2).ilv;
          Object localObject3 = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
          localObject3 = com.tencent.mm.plugin.vlog.ui.manager.c.fCN();
          if (localObject3 == null) {
            p.hyc();
          }
          localObject3 = ((g)localObject3).hDs;
          if (localObject3 == null) {
            p.hyc();
          }
          ((k)localObject1).a((EGLContext)localObject2, ((c.b)localObject3).ilu, new Surface(paramSurfaceTexture), getWidth(), getHeight());
        }
        localObject1 = this.GFW;
        if (localObject1 != null)
        {
          Log.i("MicroMsg.VLogPreloadPlayView", "later set model: " + this.GFW);
          localObject2 = this.GCP;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.vlog.player.c)localObject2).a((ah)localObject1, ((ah)localObject1).getVideoDurationMs(), ((ah)localObject1).GzR);
          }
        }
        localObject1 = this.GCP;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).fCm();
        }
        localObject1 = this.GCP;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).GBq = ((m)new b(this, paramSurfaceTexture));
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).GBr = ((b)new c(this, paramSurfaceTexture));
          if (this.iiw != null) {
            ((com.tencent.mm.plugin.vlog.player.c)localObject1).setCropRect(this.iiw);
          }
        }
        paramSurfaceTexture = this.GCP;
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.cX(getWidth(), getHeight());
        }
        paramSurfaceTexture = this.GCP;
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
    Log.i("MicroMsg.VLogPreloadPlayView", "surfaceAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.ipT = paramSurfaceTexture;
    if (!this.GOn.isAlive())
    {
      this.GOn.start();
      Log.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is not alive, start");
    }
    for (;;)
    {
      this.GOo = new MMHandler(this.GOn.getLooper());
      n(paramSurfaceTexture);
      paramSurfaceTexture = this.GOp;
      if (paramSurfaceTexture == null) {
        break;
      }
      paramSurfaceTexture.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(111217);
      return;
      Log.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is alive");
    }
    AppMethodBeat.o(111217);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111216);
    Log.i("MicroMsg.VLogPreloadPlayView", "surfaceDestroy");
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    AppMethodBeat.o(111216);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111215);
    Log.i("MicroMsg.VLogPreloadPlayView", "surfaceSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(111215);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(192020);
    if (this.GCP == null)
    {
      this.iiw = paramRect;
      AppMethodBeat.o(192020);
      return;
    }
    com.tencent.mm.plugin.vlog.player.c localc = this.GCP;
    if (localc != null)
    {
      localc.setCropRect(paramRect);
      AppMethodBeat.o(192020);
      return;
    }
    AppMethodBeat.o(192020);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(111218);
    com.tencent.mm.plugin.vlog.player.c localc = this.GCP;
    if (localc != null)
    {
      localc.setMute(paramBoolean);
      AppMethodBeat.o(111218);
      return;
    }
    AppMethodBeat.o(111218);
  }
  
  public final void setOnProgressListener(m<? super Long, ? super Long, x> paramm)
  {
    this.GBq = paramm;
  }
  
  public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, x> paramm)
  {
    this.GOp = paramm;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "pts", "", "duration", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$1", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$1"})
  static final class b
    extends q
    implements m<Long, Long, x>
  {
    b(VLogPreloadPlayView paramVLogPreloadPlayView, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$2", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$2"})
  static final class c
    extends q
    implements b<Long, x>
  {
    c(VLogPreloadPlayView paramVLogPreloadPlayView, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(com.tencent.mm.plugin.vlog.player.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(111214);
      com.tencent.mm.plugin.vlog.player.c.a(this.GOw, null, false, 7);
      AppMethodBeat.o(111214);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView
 * JD-Core Version:    0.7.0.1
 */