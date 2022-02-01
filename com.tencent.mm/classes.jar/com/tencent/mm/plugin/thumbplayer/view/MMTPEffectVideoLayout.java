package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.plugin.xlabeffect.c;
import com.tencent.mm.plugin.xlabeffect.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import com.tencent.mm.videocomposition.effect.b.b;
import com.tencent.mm.videocomposition.effect.f;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "context", "Landroid/content/Context;", "createPlayer", "", "(Landroid/content/Context;Z)V", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "effectRenderReport", "Lcom/tencent/mm/videocomposition/effect/EffectRenderReportData;", "getEffectRenderReport", "()Lcom/tencent/mm/videocomposition/effect/EffectRenderReportData;", "isFirstFrame", "onFirstFrameAvailable", "Lkotlin/Function3;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surface", "width", "height", "", "getOnFirstFrameAvailable", "()Lkotlin/jvm/functions/Function3;", "setOnFirstFrameAvailable", "(Lkotlin/jvm/functions/Function3;)V", "onFrameAvailable", "getOnFrameAvailable", "setOnFrameAvailable", "onSurfaceDestroyListener", "Lkotlin/Function1;", "getOnSurfaceDestroyListener", "()Lkotlin/jvm/functions/Function1;", "setOnSurfaceDestroyListener", "(Lkotlin/jvm/functions/Function1;)V", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "playerSurface", "Landroid/view/Surface;", "getPlayerSurface", "()Landroid/view/Surface;", "setPlayerSurface", "(Landroid/view/Surface;)V", "surfaceHeight", "surfaceWidth", "textureView", "Lcom/tencent/mm/videocomposition/effect/EffectRenderView;", "bindToExternalPlayer", "externalPlayer", "getBitmap", "Landroid/graphics/Bitmap;", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "init", "inputEffectViewVideoInfo", "onSurfaceAvailable", "onSurfaceDestroy", "onSurfaceSizeChanged", "onSurfaceUpdate", "recreatePlayer", "recreatePlayerSurface", "release", "setMediaInfo", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "Companion", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public class MMTPEffectVideoLayout
  extends FrameLayout
  implements b.b
{
  public static final MMTPEffectVideoLayout.a TGL;
  private com.tencent.mm.plugin.thumbplayer.e.b GvH;
  private Surface HkH;
  private final String TAG;
  private q<? super SurfaceTexture, ? super Integer, ? super Integer, ah> TGM;
  private q<? super SurfaceTexture, ? super Integer, ? super Integer, ah> TGN;
  private kotlin.g.a.b<? super SurfaceTexture, ah> TGO;
  public final EffectRenderView TGP;
  private boolean eYU;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(272410);
    TGL = new MMTPEffectVideoLayout.a((byte)0);
    c localc = c.XJQ;
    c.fXr();
    m.iGg();
    AppMethodBeat.o(272410);
  }
  
  public MMTPEffectVideoLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(272288);
    this.TAG = s.X("MicroMsg.MMTPEffectVideoLayout@", Integer.valueOf(hashCode()));
    this.eYU = true;
    paramContext = getContext();
    s.s(paramContext, "context");
    this.TGP = new EffectRenderView(paramContext);
    FB(false);
    AppMethodBeat.o(272288);
  }
  
  public MMTPEffectVideoLayout(Context paramContext, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(272304);
    this.TAG = s.X("MicroMsg.MMTPEffectVideoLayout@", Integer.valueOf(hashCode()));
    this.eYU = true;
    paramContext = getContext();
    s.s(paramContext, "context");
    this.TGP = new EffectRenderView(paramContext);
    FB(true);
    AppMethodBeat.o(272304);
  }
  
  public MMTPEffectVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(272323);
    this.TAG = s.X("MicroMsg.MMTPEffectVideoLayout@", Integer.valueOf(hashCode()));
    this.eYU = true;
    paramContext = getContext();
    s.s(paramContext, "context");
    this.TGP = new EffectRenderView(paramContext);
    FB(true);
    AppMethodBeat.o(272323);
  }
  
  public MMTPEffectVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(272340);
    this.TAG = s.X("MicroMsg.MMTPEffectVideoLayout@", Integer.valueOf(hashCode()));
    this.eYU = true;
    paramContext = getContext();
    s.s(paramContext, "context");
    this.TGP = new EffectRenderView(paramContext);
    FB(true);
    AppMethodBeat.o(272340);
  }
  
  private final void FB(boolean paramBoolean)
  {
    AppMethodBeat.i(272360);
    if (paramBoolean)
    {
      localObject = d.TFK;
      localObject = getContext();
      s.s(localObject, "context");
      this.GvH = d.a.ks((Context)localObject);
      hLN();
    }
    this.TGP.setAlpha(1.0F);
    this.TGP.setSurfaceCallback((b.b)this);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    addView((View)this.TGP, (ViewGroup.LayoutParams)localObject);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("init ");
    localObject = this.GvH;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).hLo())
    {
      Log.i(str, localObject + ", layout size:[" + getWidth() + ',' + getHeight() + ']');
      AppMethodBeat.o(272360);
      return;
    }
  }
  
  private final void hLN()
  {
    AppMethodBeat.i(272377);
    com.tencent.mm.plugin.thumbplayer.e.b localb = this.GvH;
    if (localb != null) {
      localb.aF((kotlin.g.a.b)new b(this));
    }
    AppMethodBeat.o(272377);
  }
  
  public final void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(272603);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("onSurfaceAvailable, surface:");
    if (paramSurfaceTexture != null) {}
    for (int i = paramSurfaceTexture.hashCode();; i = 0)
    {
      Log.i((String)localObject1, i + ", width:" + paramInt1 + ", height:" + paramInt2 + ", layout size:[" + getWidth() + ',' + getHeight() + ']');
      this.HkH = new Surface(paramSurfaceTexture);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
      paramSurfaceTexture = this.GvH;
      if (paramSurfaceTexture != null)
      {
        localObject1 = this.HkH;
        localObject2 = this.GvH;
        boolean bool1 = bool2;
        if (localObject2 != null)
        {
          bool1 = bool2;
          if (((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).isPlaying() == true) {
            bool1 = true;
          }
        }
        paramSurfaceTexture.b((Surface)localObject1, bool1);
      }
      hLN();
      AppMethodBeat.o(272603);
      return;
    }
  }
  
  public final void fva()
  {
    int j = 0;
    AppMethodBeat.i(272571);
    Object localObject2 = this.TAG;
    Object localObject1 = new StringBuilder("recreatePlayer, this.player:");
    Object localObject3 = this.GvH;
    int i;
    if (localObject3 != null)
    {
      i = localObject3.hashCode();
      localObject3 = ((StringBuilder)localObject1).append(i).append(", mediaInfo:");
      localObject1 = this.GvH;
      if (localObject1 != null) {
        break label238;
      }
    }
    label238:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TFb)
    {
      Log.i((String)localObject2, localObject1);
      localObject1 = this.GvH;
      if (localObject1 != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.c((com.tencent.mm.plugin.thumbplayer.e.b)localObject1);
      }
      localObject1 = this.GvH;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).eLO();
      }
      localObject1 = this.GvH;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).stopAsync();
      }
      localObject1 = this.GvH;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).recycle();
      }
      this.GvH = null;
      localObject1 = d.TFK;
      localObject1 = getContext();
      s.s(localObject1, "context");
      this.GvH = d.a.ks((Context)localObject1);
      hLN();
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("recreatePlayer finished, this.player:");
      localObject3 = this.GvH;
      i = j;
      if (localObject3 != null) {
        i = localObject3.hashCode();
      }
      Log.i((String)localObject1, i + ", playerSurface:" + this.HkH);
      AppMethodBeat.o(272571);
      return;
      i = 0;
      break;
    }
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(272633);
    Bitmap localBitmap = this.TGP.getBitmap();
    AppMethodBeat.o(272633);
    return localBitmap;
  }
  
  public final EffectManager getEffectManager()
  {
    AppMethodBeat.i(272593);
    EffectManager localEffectManager = this.TGP.getEffectManager();
    AppMethodBeat.o(272593);
    return localEffectManager;
  }
  
  public final f getEffectRenderReport()
  {
    AppMethodBeat.i(272522);
    f localf = this.TGP.getReportData();
    AppMethodBeat.o(272522);
    return localf;
  }
  
  public final q<SurfaceTexture, Integer, Integer, ah> getOnFirstFrameAvailable()
  {
    return this.TGN;
  }
  
  public final q<SurfaceTexture, Integer, Integer, ah> getOnFrameAvailable()
  {
    return this.TGM;
  }
  
  public final kotlin.g.a.b<SurfaceTexture, ah> getOnSurfaceDestroyListener()
  {
    return this.TGO;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.e.b getPlayer()
  {
    return this.GvH;
  }
  
  protected final Surface getPlayerSurface()
  {
    return this.HkH;
  }
  
  public final void k(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(272617);
    Object localObject = this.TAG;
    if (paramSurfaceTexture != null) {}
    for (int i = paramSurfaceTexture.hashCode();; i = 0)
    {
      Log.i((String)localObject, s.X("onSurfaceTextureDestroyed, surface:", Integer.valueOf(i)));
      localObject = this.HkH;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      localObject = this.GvH;
      if (localObject != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.a((com.tencent.mm.plugin.thumbplayer.e.b)localObject, null);
      }
      localObject = this.TGO;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(paramSurfaceTexture);
      }
      this.eYU = true;
      AppMethodBeat.o(272617);
      return;
    }
  }
  
  public final void l(SurfaceTexture paramSurfaceTexture)
  {
    int i = 1;
    AppMethodBeat.i(272626);
    Object localObject = this.HkH;
    if ((localObject != null) && (((Surface)localObject).isValid() == true)) {}
    while (i == 0)
    {
      AppMethodBeat.o(272626);
      return;
      i = 0;
    }
    this.TGP.setAlpha(1.0F);
    if (this.eYU)
    {
      localObject = this.TGN;
      if (localObject != null) {
        ((q)localObject).invoke(paramSurfaceTexture, Integer.valueOf(this.surfaceWidth), Integer.valueOf(this.surfaceHeight));
      }
      this.TGN = null;
      this.eYU = false;
    }
    localObject = this.TGM;
    if (localObject != null) {
      ((q)localObject).invoke(paramSurfaceTexture, Integer.valueOf(this.surfaceWidth), Integer.valueOf(this.surfaceHeight));
    }
    AppMethodBeat.o(272626);
  }
  
  public void setMediaInfo(com.tencent.mm.plugin.thumbplayer.a.b paramb)
  {
    AppMethodBeat.i(272585);
    s.u(paramb, "mediaInfo");
    com.tencent.mm.plugin.thumbplayer.e.b localb = this.GvH;
    if (localb != null) {
      localb.setMediaInfo(paramb);
    }
    Log.i(this.TAG, s.X("setMediaInfo:", paramb));
    paramb = this.HkH;
    if (paramb != null) {
      paramb.release();
    }
    this.HkH = null;
    hLN();
    AppMethodBeat.o(272585);
  }
  
  public final void setOnFirstFrameAvailable(q<? super SurfaceTexture, ? super Integer, ? super Integer, ah> paramq)
  {
    this.TGN = paramq;
  }
  
  public final void setOnFrameAvailable(q<? super SurfaceTexture, ? super Integer, ? super Integer, ah> paramq)
  {
    this.TGM = paramq;
  }
  
  public final void setOnSurfaceDestroyListener(kotlin.g.a.b<? super SurfaceTexture, ah> paramb)
  {
    this.TGO = paramb;
  }
  
  public final void setPlayer(com.tencent.mm.plugin.thumbplayer.e.b paramb)
  {
    this.GvH = paramb;
  }
  
  protected final void setPlayerSurface(Surface paramSurface)
  {
    this.HkH = paramSurface;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.e.b, ah>
  {
    b(MMTPEffectVideoLayout paramMMTPEffectVideoLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout
 * JD-Core Version:    0.7.0.1
 */