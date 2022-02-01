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
import com.tencent.mm.plugin.thumbplayer.d.g;
import com.tencent.mm.plugin.thumbplayer.f.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/MMTPVideoLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "createPlayer", "", "(Landroid/content/Context;Z)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "effector", "Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "getEffector", "()Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "setEffector", "(Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;)V", "enableEffect", "onFrameAvailable", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surface", "", "getOnFrameAvailable", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailable", "(Lkotlin/jvm/functions/Function1;)V", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "playerSurface", "Landroid/view/Surface;", "playerSurfaceTexture", "surfaceHeight", "surfaceTexture", "surfaceWidth", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "getTextureView", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "setTextureView", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;)V", "init", "initEffector", "initTextureView", "onVideoContentUpdate", "recreatePlayer", "recreatePlayerSurface", "release", "setEnableEffect", "enable", "setMediaInfo", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "SurfaceTextureListener", "plugin-thumbplayer_release"})
public final class MMTPVideoLayout
  extends FrameLayout
{
  public MMThumbPlayerTextureView AMp;
  private com.tencent.mm.plugin.thumbplayer.f.b Ght;
  private g MTT;
  private SurfaceTexture MTW;
  private Surface MTX;
  private kotlin.g.a.b<? super SurfaceTexture, x> MUk;
  private final String TAG;
  private int surfaceHeight;
  private SurfaceTexture surfaceTexture;
  private int surfaceWidth;
  private boolean vco;
  
  public MMTPVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(191125);
    this.TAG = ("MicroMsg.TP.MMTPVideoLayout@" + hashCode());
    this.MTT = new g();
    this.vco = true;
    Af(true);
    AppMethodBeat.o(191125);
  }
  
  public MMTPVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(191131);
    this.TAG = ("MicroMsg.TP.MMTPVideoLayout@" + hashCode());
    this.MTT = new g();
    this.vco = true;
    Af(true);
    AppMethodBeat.o(191131);
  }
  
  public MMTPVideoLayout(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(191123);
    this.TAG = ("MicroMsg.TP.MMTPVideoLayout@" + hashCode());
    this.MTT = new g();
    this.vco = true;
    Af(paramBoolean);
    AppMethodBeat.o(191123);
  }
  
  private final void Af(boolean paramBoolean)
  {
    AppMethodBeat.i(191087);
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.thumbplayer.f.d.MTv;
      localObject = getContext();
      p.j(localObject, "context");
      localObject = d.a.iA((Context)localObject);
      this.MTT.a((com.tencent.mm.plugin.thumbplayer.f.b)localObject);
      this.Ght = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject);
    }
    this.AMp = new MMThumbPlayerTextureView(getContext());
    Object localObject = this.AMp;
    if (localObject == null) {
      p.bGy("textureView");
    }
    ((MMThumbPlayerTextureView)localObject).setAlpha(1.0F);
    if (this.vco) {
      goS();
    }
    AppMethodBeat.o(191087);
  }
  
  private final void goS()
  {
    AppMethodBeat.i(191112);
    this.MTT.ai((a)new b(this));
    this.MTT.W((kotlin.g.a.b)new c(this));
    AppMethodBeat.o(191112);
  }
  
  public final g getEffector()
  {
    return this.MTT;
  }
  
  public final kotlin.g.a.b<SurfaceTexture, x> getOnFrameAvailable()
  {
    return this.MUk;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.f.b getPlayer()
  {
    return this.Ght;
  }
  
  public final MMThumbPlayerTextureView getTextureView()
  {
    AppMethodBeat.i(191076);
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.AMp;
    if (localMMThumbPlayerTextureView == null) {
      p.bGy("textureView");
    }
    AppMethodBeat.o(191076);
    return localMMThumbPlayerTextureView;
  }
  
  public final void goU()
  {
    int j = 0;
    AppMethodBeat.i(191097);
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
        break label267;
      }
    }
    label267:
    for (localObject1 = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).MSO;; localObject1 = null)
    {
      Log.i((String)localObject2, localObject1);
      localObject1 = this.Ght;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).ehf();
      }
      localObject1 = this.Ght;
      if (localObject1 != null) {
        com.tencent.mm.plugin.thumbplayer.f.b.b((com.tencent.mm.plugin.thumbplayer.f.b)localObject1);
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
      localObject1 = this.MTX;
      if (localObject1 != null) {
        ((Surface)localObject1).release();
      }
      this.MTX = null;
      this.MTW = null;
      localObject1 = com.tencent.mm.plugin.thumbplayer.f.d.MTv;
      localObject1 = getContext();
      p.j(localObject1, "context");
      localObject1 = d.a.iA((Context)localObject1);
      this.MTT.a((com.tencent.mm.plugin.thumbplayer.f.b)localObject1);
      this.Ght = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1);
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("recreatePlayer finished, this.player:");
      localObject3 = this.Ght;
      i = j;
      if (localObject3 != null) {
        i = localObject3.hashCode();
      }
      Log.i((String)localObject1, i + ", playerSurface:" + this.MTX);
      AppMethodBeat.o(191097);
      return;
      i = 0;
      break;
    }
  }
  
  public final void goW()
  {
    AppMethodBeat.i(191120);
    Object localObject1 = this.AMp;
    if (localObject1 == null) {
      p.bGy("textureView");
    }
    if (((MMThumbPlayerTextureView)localObject1).getParent() != null)
    {
      localObject1 = this.AMp;
      if (localObject1 == null) {
        p.bGy("textureView");
      }
      removeView((View)localObject1);
    }
    localObject1 = this.AMp;
    if (localObject1 == null) {
      p.bGy("textureView");
    }
    ((MMThumbPlayerTextureView)localObject1).setTextureListenerCallback((TextureView.SurfaceTextureListener)new a());
    Object localObject2;
    int i;
    int j;
    StringBuilder localStringBuilder;
    if (this.vco)
    {
      localObject1 = this.AMp;
      if (localObject1 == null) {
        p.bGy("textureView");
      }
      localObject2 = MMThumbPlayerTextureView.MUw;
      ((MMThumbPlayerTextureView)localObject1).setScaleType(MMThumbPlayerTextureView.gpa());
      i = -1;
      j = -1;
      localObject1 = new FrameLayout.LayoutParams(j, i);
      localObject2 = this.AMp;
      if (localObject2 == null) {
        p.bGy("textureView");
      }
      addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("initTextureView() ");
      localObject1 = this.Ght;
      if (localObject1 == null) {
        break label368;
      }
    }
    label281:
    label363:
    label368:
    for (localObject1 = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).eha();; localObject1 = null)
    {
      Log.i((String)localObject2, (String)localObject1 + ", layout size:[" + getWidth() + ',' + getHeight() + ']');
      AppMethodBeat.o(191120);
      return;
      localObject1 = com.tencent.mm.plugin.thumbplayer.b.MPi;
      localObject1 = getContext();
      p.j(localObject1, "context");
      localObject2 = this.Ght;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject2).MSO;
        if (localObject2 != null)
        {
          i = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).width;
          localObject2 = this.Ght;
          if (localObject2 == null) {
            break label363;
          }
          localObject2 = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject2).MSO;
          if (localObject2 == null) {
            break label363;
          }
        }
      }
      for (j = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).height;; j = 0)
      {
        localObject1 = com.tencent.mm.plugin.thumbplayer.b.l((Context)localObject1, i, j);
        j = ((Bundle)localObject1).getInt("width", 0);
        i = ((Bundle)localObject1).getInt("height", 0);
        localObject1 = this.AMp;
        if (localObject1 == null) {
          p.bGy("textureView");
        }
        ((MMThumbPlayerTextureView)localObject1).kw(j, i);
        break;
        i = 0;
        break label281;
      }
    }
  }
  
  public final void setEffector(g paramg)
  {
    AppMethodBeat.i(191081);
    p.k(paramg, "<set-?>");
    this.MTT = paramg;
    AppMethodBeat.o(191081);
  }
  
  public final void setEnableEffect(boolean paramBoolean)
  {
    AppMethodBeat.i(191109);
    Log.i(this.TAG, "setEnableEffect:" + paramBoolean + ", surfaceTexture:" + this.surfaceTexture);
    Object localObject1;
    Object localObject2;
    if (this.vco != paramBoolean)
    {
      this.vco = paramBoolean;
      if (this.vco)
      {
        localObject1 = this.AMp;
        if (localObject1 == null) {
          p.bGy("textureView");
        }
        localObject2 = MMThumbPlayerTextureView.MUw;
        ((MMThumbPlayerTextureView)localObject1).setScaleType(MMThumbPlayerTextureView.gpa());
        localObject1 = new FrameLayout.LayoutParams(-1, -1);
        localObject2 = this.AMp;
        if (localObject2 == null) {
          p.bGy("textureView");
        }
        if (((MMThumbPlayerTextureView)localObject2).getParent() != null) {
          break label156;
        }
        localObject2 = this.AMp;
        if (localObject2 == null) {
          p.bGy("textureView");
        }
        addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      }
    }
    for (;;)
    {
      goS();
      AppMethodBeat.o(191109);
      return;
      label156:
      localObject2 = this.AMp;
      if (localObject2 == null) {
        p.bGy("textureView");
      }
      ((MMThumbPlayerTextureView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.AMp;
      if (localObject1 == null) {
        p.bGy("textureView");
      }
      ((MMThumbPlayerTextureView)localObject1).requestLayout();
    }
  }
  
  public final void setMediaInfo(com.tencent.mm.plugin.thumbplayer.e.d paramd)
  {
    AppMethodBeat.i(191102);
    p.k(paramd, "mediaInfo");
    Object localObject = this.Ght;
    if (localObject != null) {
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).setMediaInfo(paramd);
    }
    Log.i(this.TAG, "setMediaInfo:".concat(String.valueOf(paramd)));
    localObject = this.MTT;
    p.k(paramd, "mediaInfo");
    ((g)localObject).videoWidth = paramd.width;
    ((g)localObject).videoHeight = paramd.height;
    ((g)localObject).MRk = paramd;
    ((g)localObject).MRm = paramd.sTg;
    Log.i(((g)localObject).TAG, "setMediaInfo, size:[" + ((g)localObject).videoWidth + ',' + ((g)localObject).videoHeight + "], totalDurationMs:" + ((g)localObject).MRm);
    localObject = this.AMp;
    if (localObject == null) {
      p.bGy("textureView");
    }
    ((MMThumbPlayerTextureView)localObject).kw(paramd.width, paramd.height);
    paramd = this.MTX;
    if (paramd != null) {
      paramd.release();
    }
    this.MTX = null;
    this.MTW = null;
    this.MTT.X((kotlin.g.a.b)new d(this));
    AppMethodBeat.o(191102);
  }
  
  public final void setOnFrameAvailable(kotlin.g.a.b<? super SurfaceTexture, x> paramb)
  {
    this.MUk = paramb;
  }
  
  public final void setPlayer(com.tencent.mm.plugin.thumbplayer.f.b paramb)
  {
    this.Ght = paramb;
  }
  
  public final void setTextureView(MMThumbPlayerTextureView paramMMThumbPlayerTextureView)
  {
    AppMethodBeat.i(191078);
    p.k(paramMMThumbPlayerTextureView, "<set-?>");
    this.AMp = paramMMThumbPlayerTextureView;
    AppMethodBeat.o(191078);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/MMTPVideoLayout$SurfaceTextureListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPVideoLayout;)V", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"})
  public final class a
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192059);
      String str = MMTPVideoLayout.a(this.MUl);
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i(str, i + ", width:" + paramInt1 + ", height:" + paramInt2 + ", enableEffect:" + MMTPVideoLayout.d(this.MUl));
        MMTPVideoLayout.a(this.MUl, paramSurfaceTexture);
        MMTPVideoLayout.a(this.MUl, paramInt1);
        MMTPVideoLayout.b(this.MUl, paramInt2);
        this.MUl.getEffector().ku(paramInt1, paramInt2);
        if (!MMTPVideoLayout.d(this.MUl)) {
          break;
        }
        if (paramSurfaceTexture == null) {
          break label241;
        }
        this.MUl.getEffector().p(paramSurfaceTexture);
        AppMethodBeat.o(192059);
        return;
      }
      MMTPVideoLayout.b(this.MUl, paramSurfaceTexture);
      if (MMTPVideoLayout.e(this.MUl) != null)
      {
        paramSurfaceTexture = MMTPVideoLayout.e(this.MUl);
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.release();
        }
      }
      MMTPVideoLayout.a(this.MUl, new Surface(MMTPVideoLayout.f(this.MUl)));
      paramSurfaceTexture = this.MUl.getPlayer();
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture.b(MMTPVideoLayout.e(this.MUl), true);
        AppMethodBeat.o(192059);
        return;
      }
      label241:
      AppMethodBeat.o(192059);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(192047);
      String str = MMTPVideoLayout.a(this.MUl);
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureDestroyed, surface:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i(str, i + ", enableEffect:" + MMTPVideoLayout.d(this.MUl));
        MMTPVideoLayout.a(this.MUl, null);
        if (!MMTPVideoLayout.d(this.MUl))
        {
          paramSurfaceTexture = MMTPVideoLayout.e(this.MUl);
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.release();
          }
        }
        paramSurfaceTexture = this.MUl.getPlayer();
        if (paramSurfaceTexture != null) {
          com.tencent.mm.plugin.thumbplayer.f.b.a(paramSurfaceTexture, null);
        }
        AppMethodBeat.o(192047);
        return true;
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192034);
      String str = MMTPVideoLayout.a(this.MUl);
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureSizeChanged, surface:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i(str, i + ", width:" + paramInt1 + ", height:" + paramInt2 + ", layout size:[" + this.MUl.getWidth() + ',' + this.MUl.getHeight() + ']');
        MMTPVideoLayout.a(this.MUl, paramSurfaceTexture);
        MMTPVideoLayout.a(this.MUl, paramInt1);
        MMTPVideoLayout.b(this.MUl, paramInt2);
        this.MUl.getEffector().ku(paramInt1, paramInt2);
        AppMethodBeat.o(192034);
        return;
      }
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(192037);
      MMTPVideoLayout.c(this.MUl);
      MMTPVideoLayout.a(this.MUl, paramSurfaceTexture);
      AppMethodBeat.o(192037);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(MMTPVideoLayout paramMMTPVideoLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Long, x>
  {
    c(MMTPVideoLayout paramMMTPVideoLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "surface", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<SurfaceTexture, x>
  {
    d(MMTPVideoLayout paramMMTPVideoLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMTPVideoLayout
 * JD-Core Version:    0.7.0.1
 */