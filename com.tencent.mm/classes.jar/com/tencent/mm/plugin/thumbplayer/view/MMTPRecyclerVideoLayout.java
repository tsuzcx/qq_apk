package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "createPlayer", "", "(Landroid/content/Context;Z)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "effector", "Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "getEffector", "()Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "setEffector", "(Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;)V", "enableEffect", "onFrameAvailable", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surface", "", "getOnFrameAvailable", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailable", "(Lkotlin/jvm/functions/Function1;)V", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "playerSurface", "Landroid/view/Surface;", "playerSurfaceTexture", "surfaceHeight", "surfaceTexture", "surfaceWidth", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "getTextureView", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "setTextureView", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;)V", "init", "initEffector", "initTextureView", "onVideoContentUpdate", "recreatePlayer", "recreatePlayerSurface", "setEnableEffect", "enable", "setMediaInfo", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "SurfaceTextureListener", "plugin-thumbplayer_release"})
public final class MMTPRecyclerVideoLayout
  extends FrameLayout
{
  private com.tencent.mm.plugin.thumbplayer.e.b Asn;
  private com.tencent.mm.plugin.thumbplayer.c.a Gig;
  private SurfaceTexture Gii;
  private Surface Gij;
  private kotlin.g.a.b<? super SurfaceTexture, x> Giq;
  private final String TAG;
  private boolean rwI;
  private int surfaceHeight;
  private SurfaceTexture surfaceTexture;
  private int surfaceWidth;
  public MMThumbPlayerTextureView wdE;
  
  public MMTPRecyclerVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(238800);
    this.TAG = ("MicroMsg.TP.MMTPRecyclerVideoLayout@" + hashCode());
    this.Gig = new com.tencent.mm.plugin.thumbplayer.c.a();
    this.rwI = true;
    init(true);
    AppMethodBeat.o(238800);
  }
  
  public MMTPRecyclerVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(238801);
    this.TAG = ("MicroMsg.TP.MMTPRecyclerVideoLayout@" + hashCode());
    this.Gig = new com.tencent.mm.plugin.thumbplayer.c.a();
    this.rwI = true;
    init(true);
    AppMethodBeat.o(238801);
  }
  
  public MMTPRecyclerVideoLayout(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(238799);
    this.TAG = ("MicroMsg.TP.MMTPRecyclerVideoLayout@" + hashCode());
    this.Gig = new com.tencent.mm.plugin.thumbplayer.c.a();
    this.rwI = true;
    init(paramBoolean);
    AppMethodBeat.o(238799);
  }
  
  private final void fxc()
  {
    AppMethodBeat.i(238797);
    this.Gig.aq((kotlin.g.a.a)new b(this));
    this.Gig.M((kotlin.g.a.b)new c(this));
    AppMethodBeat.o(238797);
  }
  
  private final void init(boolean paramBoolean)
  {
    AppMethodBeat.i(238793);
    if (paramBoolean)
    {
      localObject = d.GhZ;
      localObject = getContext();
      p.g(localObject, "context");
      localObject = d.a.hu((Context)localObject);
      this.Gig.j((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
      this.Asn = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
    }
    this.wdE = new MMThumbPlayerTextureView(getContext());
    Object localObject = this.wdE;
    if (localObject == null) {
      p.btv("textureView");
    }
    ((MMThumbPlayerTextureView)localObject).setAlpha(1.0F);
    if (this.rwI) {
      fxc();
    }
    AppMethodBeat.o(238793);
  }
  
  public final void fxd()
  {
    int j = 0;
    AppMethodBeat.i(238794);
    Object localObject2 = this.TAG;
    Object localObject1 = new StringBuilder("recreatePlayer, this.player:");
    Object localObject3 = this.Asn;
    int i;
    if (localObject3 != null)
    {
      i = localObject3.hashCode();
      localObject3 = ((StringBuilder)localObject1).append(i).append(", mediaInfo:");
      localObject1 = this.Asn;
      if (localObject1 == null) {
        break label266;
      }
    }
    label266:
    for (localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).Ghy;; localObject1 = null)
    {
      Log.i((String)localObject2, localObject1);
      localObject1 = this.Asn;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).dFs();
      }
      localObject1 = this.Asn;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).dFp();
      }
      localObject1 = this.Asn;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).stopAsync();
      }
      localObject1 = this.Asn;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).recycle();
      }
      this.Asn = null;
      localObject1 = this.Gij;
      if (localObject1 != null) {
        ((Surface)localObject1).release();
      }
      this.Gij = null;
      this.Gii = null;
      localObject1 = d.GhZ;
      localObject1 = getContext();
      p.g(localObject1, "context");
      localObject1 = d.a.hu((Context)localObject1);
      this.Gig.j((com.tencent.mm.plugin.thumbplayer.e.b)localObject1);
      this.Asn = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1);
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("recreatePlayer finished, this.player:");
      localObject3 = this.Asn;
      i = j;
      if (localObject3 != null) {
        i = localObject3.hashCode();
      }
      Log.i((String)localObject1, i + ", playerSurface:" + this.Gij);
      AppMethodBeat.o(238794);
      return;
      i = 0;
      break;
    }
  }
  
  public final void fxf()
  {
    AppMethodBeat.i(238798);
    Object localObject1 = this.wdE;
    if (localObject1 == null) {
      p.btv("textureView");
    }
    if (((MMThumbPlayerTextureView)localObject1).getParent() != null)
    {
      localObject1 = this.wdE;
      if (localObject1 == null) {
        p.btv("textureView");
      }
      removeView((View)localObject1);
    }
    localObject1 = this.wdE;
    if (localObject1 == null) {
      p.btv("textureView");
    }
    ((MMThumbPlayerTextureView)localObject1).setTextureListenerCallback((TextureView.SurfaceTextureListener)new a());
    Object localObject2;
    int i;
    int j;
    StringBuilder localStringBuilder;
    if (this.rwI)
    {
      localObject1 = this.wdE;
      if (localObject1 == null) {
        p.btv("textureView");
      }
      localObject2 = MMThumbPlayerTextureView.GiC;
      ((MMThumbPlayerTextureView)localObject1).setScaleType(MMThumbPlayerTextureView.fxj());
      i = -1;
      j = -1;
      localObject1 = new FrameLayout.LayoutParams(j, i);
      localObject2 = this.wdE;
      if (localObject2 == null) {
        p.btv("textureView");
      }
      addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("initTextureView() ");
      localObject1 = this.Asn;
      if (localObject1 == null) {
        break label368;
      }
    }
    label281:
    label363:
    label368:
    for (localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).dFm();; localObject1 = null)
    {
      Log.i((String)localObject2, (String)localObject1 + ", layout size:[" + getWidth() + ',' + getHeight() + ']');
      AppMethodBeat.o(238798);
      return;
      localObject1 = com.tencent.mm.plugin.thumbplayer.a.Ggt;
      localObject1 = getContext();
      p.g(localObject1, "context");
      localObject2 = this.Asn;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).Ghy;
        if (localObject2 != null)
        {
          i = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).width;
          localObject2 = this.Asn;
          if (localObject2 == null) {
            break label363;
          }
          localObject2 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).Ghy;
          if (localObject2 == null) {
            break label363;
          }
        }
      }
      for (j = ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).height;; j = 0)
      {
        localObject1 = com.tencent.mm.plugin.thumbplayer.a.k((Context)localObject1, i, j);
        j = ((Bundle)localObject1).getInt("width", 0);
        i = ((Bundle)localObject1).getInt("height", 0);
        localObject1 = this.wdE;
        if (localObject1 == null) {
          p.btv("textureView");
        }
        ((MMThumbPlayerTextureView)localObject1).jk(j, i);
        break;
        i = 0;
        break label281;
      }
    }
  }
  
  public final com.tencent.mm.plugin.thumbplayer.c.a getEffector()
  {
    return this.Gig;
  }
  
  public final kotlin.g.a.b<SurfaceTexture, x> getOnFrameAvailable()
  {
    return this.Giq;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.e.b getPlayer()
  {
    return this.Asn;
  }
  
  public final MMThumbPlayerTextureView getTextureView()
  {
    AppMethodBeat.i(238790);
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.wdE;
    if (localMMThumbPlayerTextureView == null) {
      p.btv("textureView");
    }
    AppMethodBeat.o(238790);
    return localMMThumbPlayerTextureView;
  }
  
  public final void setEffector(com.tencent.mm.plugin.thumbplayer.c.a parama)
  {
    AppMethodBeat.i(238792);
    p.h(parama, "<set-?>");
    this.Gig = parama;
    AppMethodBeat.o(238792);
  }
  
  public final void setEnableEffect(boolean paramBoolean)
  {
    AppMethodBeat.i(238796);
    Log.i(this.TAG, "setEnableEffect:" + paramBoolean + ", surfaceTexture:" + this.surfaceTexture);
    Object localObject1;
    Object localObject2;
    if (this.rwI != paramBoolean)
    {
      this.rwI = paramBoolean;
      if (this.rwI)
      {
        localObject1 = this.wdE;
        if (localObject1 == null) {
          p.btv("textureView");
        }
        localObject2 = MMThumbPlayerTextureView.GiC;
        ((MMThumbPlayerTextureView)localObject1).setScaleType(MMThumbPlayerTextureView.fxj());
        localObject1 = new FrameLayout.LayoutParams(-1, -1);
        localObject2 = this.wdE;
        if (localObject2 == null) {
          p.btv("textureView");
        }
        if (((MMThumbPlayerTextureView)localObject2).getParent() != null) {
          break label156;
        }
        localObject2 = this.wdE;
        if (localObject2 == null) {
          p.btv("textureView");
        }
        addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      }
    }
    for (;;)
    {
      fxc();
      AppMethodBeat.o(238796);
      return;
      label156:
      localObject2 = this.wdE;
      if (localObject2 == null) {
        p.btv("textureView");
      }
      ((MMThumbPlayerTextureView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.wdE;
      if (localObject1 == null) {
        p.btv("textureView");
      }
      ((MMThumbPlayerTextureView)localObject1).requestLayout();
    }
  }
  
  public final void setMediaInfo(com.tencent.mm.plugin.thumbplayer.d.a parama)
  {
    AppMethodBeat.i(238795);
    p.h(parama, "mediaInfo");
    Object localObject = this.Asn;
    if (localObject != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).setMediaInfo(parama);
    }
    Log.i(this.TAG, "setMediaInfo:".concat(String.valueOf(parama)));
    localObject = this.Gig;
    p.h(parama, "mediaInfo");
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).videoWidth = parama.width;
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).videoHeight = parama.height;
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).GgZ = parama;
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).Ghb = parama.pLQ;
    Log.i(((com.tencent.mm.plugin.thumbplayer.c.a)localObject).TAG, "setMediaInfo, size:[" + ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).videoWidth + ',' + ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).videoHeight + "], totalDurationMs:" + ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).Ghb);
    localObject = this.wdE;
    if (localObject == null) {
      p.btv("textureView");
    }
    ((MMThumbPlayerTextureView)localObject).jk(parama.width, parama.height);
    parama = this.Gij;
    if (parama != null) {
      parama.release();
    }
    this.Gij = null;
    this.Gii = null;
    this.Gig.L((kotlin.g.a.b)new MMTPRecyclerVideoLayout.d(this));
    AppMethodBeat.o(238795);
  }
  
  public final void setOnFrameAvailable(kotlin.g.a.b<? super SurfaceTexture, x> paramb)
  {
    this.Giq = paramb;
  }
  
  public final void setPlayer(com.tencent.mm.plugin.thumbplayer.e.b paramb)
  {
    this.Asn = paramb;
  }
  
  public final void setTextureView(MMThumbPlayerTextureView paramMMThumbPlayerTextureView)
  {
    AppMethodBeat.i(238791);
    p.h(paramMMThumbPlayerTextureView, "<set-?>");
    this.wdE = paramMMThumbPlayerTextureView;
    AppMethodBeat.o(238791);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout$SurfaceTextureListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;)V", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"})
  public final class a
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(238787);
      String str = MMTPRecyclerVideoLayout.a(this.Gir);
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i(str, i + ", width:" + paramInt1 + ", height:" + paramInt2 + ", enableEffect:" + MMTPRecyclerVideoLayout.d(this.Gir));
        MMTPRecyclerVideoLayout.a(this.Gir, paramSurfaceTexture);
        MMTPRecyclerVideoLayout.a(this.Gir, paramInt1);
        MMTPRecyclerVideoLayout.b(this.Gir, paramInt2);
        this.Gir.getEffector().jj(paramInt1, paramInt2);
        if (!MMTPRecyclerVideoLayout.d(this.Gir)) {
          break;
        }
        if (paramSurfaceTexture == null) {
          break label241;
        }
        this.Gir.getEffector().m(paramSurfaceTexture);
        AppMethodBeat.o(238787);
        return;
      }
      MMTPRecyclerVideoLayout.b(this.Gir, paramSurfaceTexture);
      if (MMTPRecyclerVideoLayout.e(this.Gir) != null)
      {
        paramSurfaceTexture = MMTPRecyclerVideoLayout.e(this.Gir);
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.release();
        }
      }
      MMTPRecyclerVideoLayout.a(this.Gir, new Surface(MMTPRecyclerVideoLayout.f(this.Gir)));
      paramSurfaceTexture = this.Gir.getPlayer();
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.b(MMTPRecyclerVideoLayout.e(this.Gir), true);
        AppMethodBeat.o(238787);
        return;
      }
      label241:
      AppMethodBeat.o(238787);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(238786);
      String str = MMTPRecyclerVideoLayout.a(this.Gir);
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureDestroyed, surface:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i(str, i + ", enableEffect:" + MMTPRecyclerVideoLayout.d(this.Gir));
        MMTPRecyclerVideoLayout.a(this.Gir, null);
        if (!MMTPRecyclerVideoLayout.d(this.Gir))
        {
          paramSurfaceTexture = MMTPRecyclerVideoLayout.e(this.Gir);
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.release();
          }
        }
        paramSurfaceTexture = this.Gir.getPlayer();
        if (paramSurfaceTexture != null) {
          com.tencent.mm.plugin.thumbplayer.e.b.a(paramSurfaceTexture, null);
        }
        AppMethodBeat.o(238786);
        return true;
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(238784);
      String str = MMTPRecyclerVideoLayout.a(this.Gir);
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureSizeChanged, surface:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i(str, i + ", width:" + paramInt1 + ", height:" + paramInt2 + ", layout size:[" + this.Gir.getWidth() + ',' + this.Gir.getHeight() + ']');
        MMTPRecyclerVideoLayout.a(this.Gir, paramSurfaceTexture);
        MMTPRecyclerVideoLayout.a(this.Gir, paramInt1);
        MMTPRecyclerVideoLayout.b(this.Gir, paramInt2);
        this.Gir.getEffector().jj(paramInt1, paramInt2);
        AppMethodBeat.o(238784);
        return;
      }
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(238785);
      MMTPRecyclerVideoLayout.c(this.Gir);
      MMTPRecyclerVideoLayout.a(this.Gir, paramSurfaceTexture);
      AppMethodBeat.o(238785);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(MMTPRecyclerVideoLayout paramMMTPRecyclerVideoLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Long, x>
  {
    c(MMTPRecyclerVideoLayout paramMMTPRecyclerVideoLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMTPRecyclerVideoLayout
 * JD-Core Version:    0.7.0.1
 */