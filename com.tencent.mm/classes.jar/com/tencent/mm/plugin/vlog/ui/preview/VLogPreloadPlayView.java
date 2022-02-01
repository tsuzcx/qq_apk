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
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.player.g;
import com.tencent.mm.plugin.vlog.player.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.threadpool.c.d;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cropRect", "Landroid/graphics/Rect;", "isRendering", "", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "texture", "Landroid/graphics/SurfaceTexture;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "bindPreloadManager", "surfaceTexture", "clearCurrentScript", "detachPreloadManager", "getSize", "Landroid/util/Size;", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "resume", "setCropRect", "rect", "setMute", "mute", "setOnProgressListener", "setOnSizeChangedListener", "updateFrameOnTime", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VLogPreloadPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VLogPreloadPlayView.a UoJ;
  private Rect Gl;
  public j UcX;
  private m<? super Long, ? super Long, kotlin.ah> UcY;
  public com.tencent.mm.plugin.vlog.player.c Uep;
  public com.tencent.mm.plugin.vlog.model.ah Uhd;
  public HandlerThread UoB;
  public MMHandler UoC;
  private m<? super Integer, ? super Integer, kotlin.ah> UoD;
  public volatile boolean UoE;
  private ae UoK;
  public SurfaceTexture nwH;
  
  static
  {
    AppMethodBeat.i(111223);
    UoJ = new VLogPreloadPlayView.a((byte)0);
    AppMethodBeat.o(111223);
  }
  
  public VLogPreloadPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(111222);
    paramContext = d.jw("VLogPlayView_PreviewPlayer", -4);
    s.s(paramContext, "createAboutMeidaThread(\"….THREAD_PRIORITY_DISPLAY)");
    this.UoB = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.Uhq;
    this.UoK = com.tencent.mm.plugin.vlog.ui.manager.c.hSA();
    AppMethodBeat.o(111222);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111221);
    paramContext = d.jw("VLogPlayView_PreviewPlayer", -4);
    s.s(paramContext, "createAboutMeidaThread(\"….THREAD_PRIORITY_DISPLAY)");
    this.UoB = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.Uhq;
    this.UoK = com.tencent.mm.plugin.vlog.ui.manager.c.hSA();
    AppMethodBeat.o(111221);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111220);
    paramContext = d.jw("VLogPlayView_PreviewPlayer", -4);
    s.s(paramContext, "createAboutMeidaThread(\"….THREAD_PRIORITY_DISPLAY)");
    this.UoB = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.Uhq;
    this.UoK = com.tencent.mm.plugin.vlog.ui.manager.c.hSA();
    AppMethodBeat.o(111220);
  }
  
  private static final void j(com.tencent.mm.plugin.vlog.player.c paramc)
  {
    AppMethodBeat.i(281543);
    s.u(paramc, "$this_apply");
    com.tencent.mm.plugin.vlog.player.c.a(paramc, null, false, 7);
    AppMethodBeat.o(281543);
  }
  
  public final Size getSize()
  {
    AppMethodBeat.i(281586);
    Object localObject = this.Uep;
    if (localObject == null)
    {
      AppMethodBeat.o(281586);
      return null;
    }
    localObject = new Size(((com.tencent.mm.plugin.vlog.player.c)localObject).width, ((com.tencent.mm.plugin.vlog.player.c)localObject).height);
    AppMethodBeat.o(281586);
    return localObject;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111217);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.VLogPreloadPlayView", "surfaceAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.nwH = paramSurfaceTexture;
    if (!this.UoB.isAlive())
    {
      this.UoB.start();
      Log.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is not alive, start");
    }
    for (;;)
    {
      this.UoC = new MMHandler(this.UoB.getLooper());
      s(paramSurfaceTexture);
      paramSurfaceTexture = this.UoD;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      AppMethodBeat.o(111217);
      return;
      Log.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is alive");
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111216);
    s.u(paramSurfaceTexture, "surface");
    Log.i("MicroMsg.VLogPreloadPlayView", "surfaceDestroy");
    paramSurfaceTexture.release();
    AppMethodBeat.o(111216);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111215);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.VLogPreloadPlayView", "surfaceSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(111215);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(281562);
    s.u(paramSurfaceTexture, "surface");
    AppMethodBeat.o(281562);
  }
  
  public final void s(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111219);
    Log.i("MicroMsg.VLogPreloadPlayView", s.X("bindPreloadManager surfaceTexture:", paramSurfaceTexture));
    Object localObject1;
    Object localObject2;
    if (paramSurfaceTexture != null)
    {
      localObject1 = new StringBuilder("vLogDirector init : ");
      localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.Uhq;
      localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.hSC();
      if (localObject2 == null) {
        break label380;
      }
      i = localObject2.hashCode();
      localObject1 = ((StringBuilder)localObject1).append(i).append(", vLogSurface : ");
      localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.Uhq;
      localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.hSB();
      if (localObject2 == null) {
        break label385;
      }
    }
    label385:
    for (int i = localObject2.hashCode();; i = 0)
    {
      Log.i("MicroMsg.VLogPreloadPlayView", i);
      localObject1 = com.tencent.mm.plugin.vlog.ui.manager.c.Uhq;
      this.Uep = com.tencent.mm.plugin.vlog.ui.manager.c.hSC();
      localObject1 = com.tencent.mm.plugin.vlog.ui.manager.c.Uhq;
      this.UcX = ((j)com.tencent.mm.plugin.vlog.ui.manager.c.hSB());
      localObject1 = this.UcX;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.Uhq;
        localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.hSB();
        s.checkNotNull(localObject2);
        localObject2 = ((g)localObject2).mVi;
        s.checkNotNull(localObject2);
        localObject2 = ((c.b)localObject2).eXL;
        Object localObject3 = com.tencent.mm.plugin.vlog.ui.manager.c.Uhq;
        localObject3 = com.tencent.mm.plugin.vlog.ui.manager.c.hSB();
        s.checkNotNull(localObject3);
        localObject3 = ((g)localObject3).mVi;
        s.checkNotNull(localObject3);
        ((j)localObject1).a((EGLContext)localObject2, ((c.b)localObject3).nFB, new Surface(paramSurfaceTexture), getWidth(), getHeight());
      }
      paramSurfaceTexture = this.Uhd;
      if (paramSurfaceTexture != null)
      {
        Log.i("MicroMsg.VLogPreloadPlayView", s.X("later set model: ", this.Uhd));
        localObject1 = this.Uep;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).a(paramSurfaceTexture, paramSurfaceTexture.getVideoDurationMs(), paramSurfaceTexture.UaZ);
        }
      }
      paramSurfaceTexture = this.Uep;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.hSa();
      }
      paramSurfaceTexture = this.Uep;
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.UcY = ((m)new b(this));
        paramSurfaceTexture.UcZ = ((b)new c(this));
        if (this.Gl != null) {
          paramSurfaceTexture.setCropRect(this.Gl);
        }
      }
      paramSurfaceTexture = this.Uep;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.ej(getWidth(), getHeight());
      }
      paramSurfaceTexture = this.Uep;
      if (paramSurfaceTexture != null) {
        com.tencent.mm.plugin.vlog.player.c.a(paramSurfaceTexture, null, false, 7);
      }
      AppMethodBeat.o(111219);
      return;
      label380:
      i = 0;
      break;
    }
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(281579);
    if (this.Uep == null)
    {
      this.Gl = paramRect;
      AppMethodBeat.o(281579);
      return;
    }
    com.tencent.mm.plugin.vlog.player.c localc = this.Uep;
    if (localc != null) {
      localc.setCropRect(paramRect);
    }
    AppMethodBeat.o(281579);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(111218);
    com.tencent.mm.plugin.vlog.player.c localc = this.Uep;
    if (localc != null) {
      localc.setMute(paramBoolean);
    }
    AppMethodBeat.o(111218);
  }
  
  public final void setOnProgressListener(m<? super Long, ? super Long, kotlin.ah> paramm)
  {
    this.UcY = paramm;
  }
  
  public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, kotlin.ah> paramm)
  {
    this.UoD = paramm;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pts", "", "duration"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Long, Long, kotlin.ah>
  {
    b(VLogPreloadPlayView paramVLogPreloadPlayView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<Long, kotlin.ah>
  {
    c(VLogPreloadPlayView paramVLogPreloadPlayView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView
 * JD-Core Version:    0.7.0.1
 */