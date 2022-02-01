package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.f.d.a;
import com.tencent.mm.plugin.xlabeffect.c;
import com.tencent.mm.plugin.xlabeffect.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import com.tencent.mm.videocomposition.effect.b.b;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "context", "Landroid/content/Context;", "createPlayer", "", "(Landroid/content/Context;Z)V", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "onFrameAvailable", "Lkotlin/Function3;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surface", "width", "height", "", "getOnFrameAvailable", "()Lkotlin/jvm/functions/Function3;", "setOnFrameAvailable", "(Lkotlin/jvm/functions/Function3;)V", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "playerSurface", "Landroid/view/Surface;", "surfaceHeight", "surfaceWidth", "textureView", "Lcom/tencent/mm/videocomposition/effect/EffectRenderView;", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "init", "inputEffectViewVideoInfo", "onSurfaceAvailable", "onSurfaceDestroy", "onSurfaceSizeChanged", "onSurfaceUpdate", "recreatePlayer", "recreatePlayerSurface", "release", "setMediaInfo", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "Companion", "plugin-thumbplayer_release"})
public final class MMTPEffectVideoLayout
  extends FrameLayout
  implements b.b
{
  public static final a MUi;
  private com.tencent.mm.plugin.thumbplayer.f.b Ght;
  private Surface MTX;
  private kotlin.g.a.q<? super SurfaceTexture, ? super Integer, ? super Integer, x> MUg;
  public final EffectRenderView MUh;
  private final String TAG;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(192145);
    MUi = new a((byte)0);
    c localc = c.QPp;
    c.eON();
    g.hfh();
    AppMethodBeat.o(192145);
  }
  
  public MMTPEffectVideoLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(192125);
    this.TAG = ("MicroMsg.MMTPEffectVideoLayout@" + hashCode());
    this.MUh = new EffectRenderView(getContext());
    Af(false);
    AppMethodBeat.o(192125);
  }
  
  public MMTPEffectVideoLayout(Context paramContext, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(192130);
    this.TAG = ("MicroMsg.MMTPEffectVideoLayout@" + hashCode());
    this.MUh = new EffectRenderView(getContext());
    Af(true);
    AppMethodBeat.o(192130);
  }
  
  public MMTPEffectVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192137);
    this.TAG = ("MicroMsg.MMTPEffectVideoLayout@" + hashCode());
    this.MUh = new EffectRenderView(getContext());
    Af(true);
    AppMethodBeat.o(192137);
  }
  
  public MMTPEffectVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192143);
    this.TAG = ("MicroMsg.MMTPEffectVideoLayout@" + hashCode());
    this.MUh = new EffectRenderView(getContext());
    Af(true);
    AppMethodBeat.o(192143);
  }
  
  private final void Af(boolean paramBoolean)
  {
    AppMethodBeat.i(192078);
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.thumbplayer.f.d.MTv;
      localObject = getContext();
      p.j(localObject, "context");
      this.Ght = d.a.iA((Context)localObject);
      goV();
    }
    this.MUh.setAlpha(1.0F);
    this.MUh.setSurfaceCallback((b.b)this);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    addView((View)this.MUh, (ViewGroup.LayoutParams)localObject);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("init ");
    localObject = this.Ght;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).eha();; localObject = null)
    {
      Log.i(str, (String)localObject + ", layout size:[" + getWidth() + ',' + getHeight() + ']');
      AppMethodBeat.o(192078);
      return;
    }
  }
  
  private final void goV()
  {
    AppMethodBeat.i(192100);
    com.tencent.mm.plugin.thumbplayer.f.b localb = this.Ght;
    if (localb != null)
    {
      localb.MRH = ((kotlin.g.a.b)new b(this));
      AppMethodBeat.o(192100);
      return;
    }
    AppMethodBeat.o(192100);
  }
  
  public final void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192108);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSurfaceAvailable, surface:");
    if (paramSurfaceTexture != null) {}
    for (int i = paramSurfaceTexture.hashCode();; i = 0)
    {
      Log.i(str, i + ", width:" + paramInt1 + ", height:" + paramInt2 + ", layout size:[" + getWidth() + ',' + getHeight() + ']');
      this.MTX = new Surface(paramSurfaceTexture);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
      paramSurfaceTexture = this.Ght;
      if (paramSurfaceTexture == null) {
        break;
      }
      paramSurfaceTexture.b(this.MTX, true);
      AppMethodBeat.o(192108);
      return;
    }
    AppMethodBeat.o(192108);
  }
  
  public final EffectManager getEffectManager()
  {
    AppMethodBeat.i(192095);
    EffectManager localEffectManager = this.MUh.getEffectManager();
    AppMethodBeat.o(192095);
    return localEffectManager;
  }
  
  public final kotlin.g.a.q<SurfaceTexture, Integer, Integer, x> getOnFrameAvailable()
  {
    return this.MUg;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.f.b getPlayer()
  {
    return this.Ght;
  }
  
  public final void goU()
  {
    int j = 0;
    AppMethodBeat.i(192088);
    Object localObject2 = this.TAG;
    Object localObject1 = new StringBuilder("recreatePlayer, this.player:");
    Object localObject3 = this.Ght;
    int i;
    if (localObject3 != null)
    {
      i = localObject3.hashCode();
      localObject3 = ((StringBuilder)localObject1).append(i).append(", mediaInfo:");
      localObject1 = this.Ght;
      if (localObject1 == null) {
        break label241;
      }
    }
    label241:
    for (localObject1 = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).MSO;; localObject1 = null)
    {
      Log.i((String)localObject2, localObject1);
      localObject1 = this.Ght;
      if (localObject1 != null) {
        com.tencent.mm.plugin.thumbplayer.f.b.b((com.tencent.mm.plugin.thumbplayer.f.b)localObject1);
      }
      localObject1 = this.Ght;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).ehf();
      }
      localObject1 = this.Ght;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).stopAsync();
      }
      localObject1 = this.Ght;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).recycle();
      }
      this.Ght = null;
      localObject1 = com.tencent.mm.plugin.thumbplayer.f.d.MTv;
      localObject1 = getContext();
      p.j(localObject1, "context");
      this.Ght = d.a.iA((Context)localObject1);
      goV();
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("recreatePlayer finished, this.player:");
      localObject3 = this.Ght;
      i = j;
      if (localObject3 != null) {
        i = localObject3.hashCode();
      }
      Log.i((String)localObject1, i + ", playerSurface:" + this.MTX);
      AppMethodBeat.o(192088);
      return;
      i = 0;
      break;
    }
  }
  
  public final void l(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(192115);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureDestroyed, surface:");
    if (paramSurfaceTexture != null) {}
    for (int i = paramSurfaceTexture.hashCode();; i = 0)
    {
      Log.i(str, i);
      paramSurfaceTexture = this.MTX;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.release();
      }
      paramSurfaceTexture = this.Ght;
      if (paramSurfaceTexture == null) {
        break;
      }
      com.tencent.mm.plugin.thumbplayer.f.b.a(paramSurfaceTexture, null);
      AppMethodBeat.o(192115);
      return;
    }
    AppMethodBeat.o(192115);
  }
  
  public final void m(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(192122);
    this.MUh.setAlpha(1.0F);
    kotlin.g.a.q localq = this.MUg;
    if (localq != null)
    {
      localq.c(paramSurfaceTexture, Integer.valueOf(this.surfaceWidth), Integer.valueOf(this.surfaceHeight));
      this.MUg = null;
      AppMethodBeat.o(192122);
      return;
    }
    AppMethodBeat.o(192122);
  }
  
  public final void setMediaInfo(com.tencent.mm.plugin.thumbplayer.e.d paramd)
  {
    AppMethodBeat.i(192093);
    p.k(paramd, "mediaInfo");
    com.tencent.mm.plugin.thumbplayer.f.b localb = this.Ght;
    if (localb != null) {
      localb.setMediaInfo(paramd);
    }
    Log.i(this.TAG, "setMediaInfo:".concat(String.valueOf(paramd)));
    paramd = this.MTX;
    if (paramd != null) {
      paramd.release();
    }
    this.MTX = null;
    goV();
    AppMethodBeat.o(192093);
  }
  
  public final void setOnFrameAvailable(kotlin.g.a.q<? super SurfaceTexture, ? super Integer, ? super Integer, x> paramq)
  {
    this.MUg = paramq;
  }
  
  public final void setPlayer(com.tencent.mm.plugin.thumbplayer.f.b paramb)
  {
    this.Ght = paramb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout$Companion;", "", "()V", "plugin-thumbplayer_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.f.b, x>
  {
    b(MMTPEffectVideoLayout paramMMTPEffectVideoLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout
 * JD-Core Version:    0.7.0.1
 */