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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cropRect", "Landroid/graphics/Rect;", "isRendering", "", "model", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "onProgress", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "now", "total", "", "onSizeChanged", "width", "height", "previewPlayer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "previewPlayerThread", "Landroid/os/HandlerThread;", "texture", "Landroid/graphics/SurfaceTexture;", "vLogDirector", "Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "vLogManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "bindPreloadManager", "surfaceTexture", "clearCurrentScript", "detachPreloadManager", "getSize", "Landroid/util/Size;", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "renderScript", "resume", "setCropRect", "rect", "setMute", "mute", "setOnProgressListener", "setOnSizeChangedListener", "updateFrameOnTime", "Companion", "plugin-vlog_release"})
public final class VLogPreloadPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final a NCe;
  public HandlerThread NBT;
  public MMHandler NBU;
  private m<? super Integer, ? super Integer, x> NBV;
  public volatile boolean NBW;
  private ae NCd;
  public k Npb;
  private m<? super Long, ? super Long, x> Npc;
  public com.tencent.mm.plugin.vlog.player.c Nqz;
  public ah NtN;
  private Rect kXj;
  public SurfaceTexture leZ;
  
  static
  {
    AppMethodBeat.i(111223);
    NCe = new a((byte)0);
    AppMethodBeat.o(111223);
  }
  
  public VLogPreloadPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(111222);
    paramContext = d.ik("VLogPlayView_PreviewPlayer", -4);
    p.j(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.NBT = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.NtZ;
    this.NCd = com.tencent.mm.plugin.vlog.ui.manager.c.guL();
    AppMethodBeat.o(111222);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111221);
    paramContext = d.ik("VLogPlayView_PreviewPlayer", -4);
    p.j(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.NBT = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.NtZ;
    this.NCd = com.tencent.mm.plugin.vlog.ui.manager.c.guL();
    AppMethodBeat.o(111221);
  }
  
  public VLogPreloadPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111220);
    paramContext = d.ik("VLogPlayView_PreviewPlayer", -4);
    p.j(paramContext, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.NBT = paramContext;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.NtZ;
    this.NCd = com.tencent.mm.plugin.vlog.ui.manager.c.guL();
    AppMethodBeat.o(111220);
  }
  
  public final Size getSize()
  {
    AppMethodBeat.i(249248);
    Object localObject = this.Nqz;
    if (localObject != null)
    {
      localObject = new Size(((com.tencent.mm.plugin.vlog.player.c)localObject).width, ((com.tencent.mm.plugin.vlog.player.c)localObject).height);
      AppMethodBeat.o(249248);
      return localObject;
    }
    AppMethodBeat.o(249248);
    return null;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111217);
    Log.i("MicroMsg.VLogPreloadPlayView", "surfaceAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.leZ = paramSurfaceTexture;
    if (!this.NBT.isAlive())
    {
      this.NBT.start();
      Log.i("MicroMsg.VLogPreloadPlayView", "previewPlayerThread is not alive, start");
    }
    for (;;)
    {
      this.NBU = new MMHandler(this.NBT.getLooper());
      q(paramSurfaceTexture);
      paramSurfaceTexture = this.NBV;
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
  
  public final void q(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(111219);
    Log.i("MicroMsg.VLogPreloadPlayView", "bindPreloadManager surfaceTexture:".concat(String.valueOf(paramSurfaceTexture)));
    if (paramSurfaceTexture != null)
    {
      Object localObject1 = new StringBuilder("vLogDirector init : ");
      Object localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.NtZ;
      localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.guN();
      if (localObject2 != null)
      {
        i = localObject2.hashCode();
        localObject1 = ((StringBuilder)localObject1).append(i).append(", vLogSurface : ");
        localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.NtZ;
        localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.guM();
        if (localObject2 == null) {
          break label415;
        }
      }
      label415:
      for (int i = localObject2.hashCode();; i = 0)
      {
        Log.i("MicroMsg.VLogPreloadPlayView", i);
        localObject1 = com.tencent.mm.plugin.vlog.ui.manager.c.NtZ;
        this.Nqz = com.tencent.mm.plugin.vlog.ui.manager.c.guN();
        localObject1 = com.tencent.mm.plugin.vlog.ui.manager.c.NtZ;
        this.Npb = ((k)com.tencent.mm.plugin.vlog.ui.manager.c.guM());
        localObject1 = this.Npb;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.NtZ;
          localObject2 = com.tencent.mm.plugin.vlog.ui.manager.c.guM();
          if (localObject2 == null) {
            p.iCn();
          }
          localObject2 = ((g)localObject2).krl;
          if (localObject2 == null) {
            p.iCn();
          }
          localObject2 = ((c.b)localObject2).lau;
          Object localObject3 = com.tencent.mm.plugin.vlog.ui.manager.c.NtZ;
          localObject3 = com.tencent.mm.plugin.vlog.ui.manager.c.guM();
          if (localObject3 == null) {
            p.iCn();
          }
          localObject3 = ((g)localObject3).krl;
          if (localObject3 == null) {
            p.iCn();
          }
          ((k)localObject1).a((EGLContext)localObject2, ((c.b)localObject3).las, new Surface(paramSurfaceTexture), getWidth(), getHeight());
        }
        localObject1 = this.NtN;
        if (localObject1 != null)
        {
          Log.i("MicroMsg.VLogPreloadPlayView", "later set model: " + this.NtN);
          localObject2 = this.Nqz;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.vlog.player.c)localObject2).a((ah)localObject1, ((ah)localObject1).getVideoDurationMs(), ((ah)localObject1).Nnx);
          }
        }
        localObject1 = this.Nqz;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).gul();
        }
        localObject1 = this.Nqz;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).Npc = ((m)new b(this, paramSurfaceTexture));
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).Npd = ((b)new c(this, paramSurfaceTexture));
          if (this.kXj != null) {
            ((com.tencent.mm.plugin.vlog.player.c)localObject1).setCropRect(this.kXj);
          }
        }
        paramSurfaceTexture = this.Nqz;
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.dt(getWidth(), getHeight());
        }
        paramSurfaceTexture = this.Nqz;
        if (paramSurfaceTexture == null) {
          break label420;
        }
        com.tencent.mm.plugin.vlog.player.c.a(paramSurfaceTexture, null, false, 7);
        AppMethodBeat.o(111219);
        return;
        i = 0;
        break;
      }
    }
    label420:
    AppMethodBeat.o(111219);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(249246);
    if (this.Nqz == null)
    {
      this.kXj = paramRect;
      AppMethodBeat.o(249246);
      return;
    }
    com.tencent.mm.plugin.vlog.player.c localc = this.Nqz;
    if (localc != null)
    {
      localc.setCropRect(paramRect);
      AppMethodBeat.o(249246);
      return;
    }
    AppMethodBeat.o(249246);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(111218);
    com.tencent.mm.plugin.vlog.player.c localc = this.Nqz;
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
    this.Npc = paramm;
  }
  
  public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, x> paramm)
  {
    this.NBV = paramm;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pts", "", "duration", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$1", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$1"})
  static final class b
    extends q
    implements m<Long, Long, x>
  {
    b(VLogPreloadPlayView paramVLogPreloadPlayView, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$bindPreloadManager$1$2$2", "com/tencent/mm/plugin/vlog/ui/preview/VLogPreloadPlayView$$special$$inlined$apply$lambda$2"})
  static final class c
    extends q
    implements b<Long, x>
  {
    c(VLogPreloadPlayView paramVLogPreloadPlayView, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(com.tencent.mm.plugin.vlog.player.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(111214);
      com.tencent.mm.plugin.vlog.player.c.a(this.NCc, null, false, 7);
      AppMethodBeat.o(111214);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView
 * JD-Core Version:    0.7.0.1
 */