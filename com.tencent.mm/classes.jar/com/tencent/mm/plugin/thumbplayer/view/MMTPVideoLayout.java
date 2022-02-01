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
import com.tencent.mm.plugin.thumbplayer.c.e;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/MMTPVideoLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "createPlayer", "", "(Landroid/content/Context;Z)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "effector", "Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "getEffector", "()Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;", "setEffector", "(Lcom/tencent/mm/plugin/thumbplayer/effect/TPPlayerEffector;)V", "enableEffect", "onFrameAvailable", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surface", "", "getOnFrameAvailable", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailable", "(Lkotlin/jvm/functions/Function1;)V", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "playerSurface", "Landroid/view/Surface;", "playerSurfaceTexture", "surfaceHeight", "surfaceTexture", "surfaceWidth", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "getTextureView", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "setTextureView", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;)V", "init", "initEffector", "initTextureView", "onVideoContentUpdate", "recreatePlayer", "recreatePlayerSurface", "release", "setEnableEffect", "enable", "setMediaInfo", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "SurfaceTextureListener", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMTPVideoLayout
  extends FrameLayout
{
  public MMThumbPlayerTextureView Fld;
  private com.tencent.mm.plugin.thumbplayer.e.b GvH;
  private Surface HkH;
  private final String TAG;
  private e TGA;
  private SurfaceTexture TGC;
  private kotlin.g.a.b<? super SurfaceTexture, ah> TGR;
  private int surfaceHeight;
  private SurfaceTexture surfaceTexture;
  private int surfaceWidth;
  private boolean yoh;
  
  public MMTPVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(272253);
    this.TAG = s.X("MicroMsg.TP.MMTPVideoLayout@", Integer.valueOf(hashCode()));
    this.TGA = new e();
    this.yoh = true;
    FB(true);
    AppMethodBeat.o(272253);
  }
  
  public MMTPVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(272262);
    this.TAG = s.X("MicroMsg.TP.MMTPVideoLayout@", Integer.valueOf(hashCode()));
    this.TGA = new e();
    this.yoh = true;
    FB(true);
    AppMethodBeat.o(272262);
  }
  
  public MMTPVideoLayout(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(272243);
    this.TAG = s.X("MicroMsg.TP.MMTPVideoLayout@", Integer.valueOf(hashCode()));
    this.TGA = new e();
    this.yoh = true;
    FB(paramBoolean);
    AppMethodBeat.o(272243);
  }
  
  private final void FB(boolean paramBoolean)
  {
    AppMethodBeat.i(272272);
    if (paramBoolean)
    {
      Object localObject = d.TFK;
      localObject = getContext();
      s.s(localObject, "context");
      localObject = d.a.ks((Context)localObject);
      getEffector().a((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
      ah localah = ah.aiuX;
      this.GvH = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
    }
    setTextureView(new MMThumbPlayerTextureView(getContext()));
    getTextureView().setAlpha(1.0F);
    if (this.yoh) {
      hLL();
    }
    AppMethodBeat.o(272272);
  }
  
  private final void hLL()
  {
    AppMethodBeat.i(272280);
    this.TGA.bS((a)new b(this));
    this.TGA.aD((kotlin.g.a.b)new c(this));
    AppMethodBeat.o(272280);
  }
  
  public final void fva()
  {
    int j = 0;
    AppMethodBeat.i(272418);
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
        break label269;
      }
    }
    label269:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TFb)
    {
      Log.i((String)localObject2, localObject1);
      localObject1 = this.GvH;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).eLO();
      }
      localObject1 = this.GvH;
      if (localObject1 != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.c((com.tencent.mm.plugin.thumbplayer.e.b)localObject1);
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
      localObject1 = this.HkH;
      if (localObject1 != null) {
        ((Surface)localObject1).release();
      }
      this.HkH = null;
      this.TGC = null;
      localObject1 = d.TFK;
      localObject1 = getContext();
      s.s(localObject1, "context");
      localObject1 = d.a.ks((Context)localObject1);
      getEffector().a((com.tencent.mm.plugin.thumbplayer.e.b)localObject1);
      localObject2 = ah.aiuX;
      this.GvH = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1);
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("recreatePlayer finished, this.player:");
      localObject3 = this.GvH;
      i = j;
      if (localObject3 != null) {
        i = localObject3.hashCode();
      }
      Log.i((String)localObject1, i + ", playerSurface:" + this.HkH);
      AppMethodBeat.o(272418);
      return;
      i = 0;
      break;
    }
  }
  
  public final e getEffector()
  {
    return this.TGA;
  }
  
  public final kotlin.g.a.b<SurfaceTexture, ah> getOnFrameAvailable()
  {
    return this.TGR;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.e.b getPlayer()
  {
    return this.GvH;
  }
  
  public final MMThumbPlayerTextureView getTextureView()
  {
    AppMethodBeat.i(272372);
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.Fld;
    if (localMMThumbPlayerTextureView != null)
    {
      AppMethodBeat.o(272372);
      return localMMThumbPlayerTextureView;
    }
    s.bIx("textureView");
    AppMethodBeat.o(272372);
    return null;
  }
  
  public final void hLO()
  {
    AppMethodBeat.i(272444);
    if (getTextureView().getParent() != null) {
      removeView((View)getTextureView());
    }
    getTextureView().setTextureListenerCallback((TextureView.SurfaceTextureListener)new a());
    int i;
    int j;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (this.yoh)
    {
      getTextureView().setScaleType(2);
      i = -1;
      j = -1;
      localObject1 = new FrameLayout.LayoutParams(j, i);
      addView((View)getTextureView(), (ViewGroup.LayoutParams)localObject1);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("initTextureView() ");
      localObject1 = this.GvH;
      if (localObject1 != null) {
        break label299;
      }
    }
    label273:
    label299:
    for (Object localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).hLo())
    {
      Log.i((String)localObject2, localObject1 + ", layout size:[" + getWidth() + ',' + getHeight() + ']');
      AppMethodBeat.o(272444);
      return;
      localObject1 = com.tencent.mm.plugin.thumbplayer.b.TBI;
      localObject1 = getContext();
      s.s(localObject1, "context");
      localObject2 = this.GvH;
      if (localObject2 == null)
      {
        i = 0;
        label197:
        localObject2 = this.GvH;
        if (localObject2 != null) {
          break label273;
        }
        j = 0;
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.thumbplayer.b.p((Context)localObject1, i, j);
        j = ((Bundle)localObject1).getInt("width", 0);
        i = ((Bundle)localObject1).getInt("height", 0);
        getTextureView().mj(j, i);
        break;
        localObject2 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).TFb;
        if (localObject2 == null)
        {
          i = 0;
          break label197;
        }
        i = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).width;
        break label197;
        localObject2 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).TFb;
        if (localObject2 == null) {
          j = 0;
        } else {
          j = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).height;
        }
      }
    }
  }
  
  public final void setEffector(e parame)
  {
    AppMethodBeat.i(272395);
    s.u(parame, "<set-?>");
    this.TGA = parame;
    AppMethodBeat.o(272395);
  }
  
  public final void setEnableEffect(boolean paramBoolean)
  {
    AppMethodBeat.i(272435);
    Log.i(this.TAG, "setEnableEffect:" + paramBoolean + ", surfaceTexture:" + this.surfaceTexture);
    FrameLayout.LayoutParams localLayoutParams;
    if (this.yoh != paramBoolean)
    {
      this.yoh = paramBoolean;
      if (this.yoh)
      {
        getTextureView().setScaleType(2);
        localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (getTextureView().getParent() != null) {
          break label117;
        }
        addView((View)getTextureView(), (ViewGroup.LayoutParams)localLayoutParams);
      }
    }
    for (;;)
    {
      hLL();
      AppMethodBeat.o(272435);
      return;
      label117:
      getTextureView().setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      getTextureView().requestLayout();
    }
  }
  
  public final void setMediaInfo(com.tencent.mm.plugin.thumbplayer.a.b paramb)
  {
    AppMethodBeat.i(272430);
    s.u(paramb, "mediaInfo");
    Object localObject = this.GvH;
    if (localObject != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).setMediaInfo(paramb);
    }
    Log.i(this.TAG, s.X("setMediaInfo:", paramb));
    localObject = this.TGA;
    s.u(paramb, "mediaInfo");
    ((e)localObject).videoWidth = paramb.width;
    ((e)localObject).videoHeight = paramb.height;
    ((e)localObject).TDK = paramb;
    ((e)localObject).TDM = paramb.vYw;
    Log.i(((e)localObject).TAG, "setMediaInfo, size:[" + ((e)localObject).videoWidth + ',' + ((e)localObject).videoHeight + "], totalDurationMs:" + ((e)localObject).TDM);
    getTextureView().mj(paramb.width, paramb.height);
    paramb = this.HkH;
    if (paramb != null) {
      paramb.release();
    }
    this.HkH = null;
    this.TGC = null;
    this.TGA.aE((kotlin.g.a.b)new d(this));
    AppMethodBeat.o(272430);
  }
  
  public final void setOnFrameAvailable(kotlin.g.a.b<? super SurfaceTexture, ah> paramb)
  {
    this.TGR = paramb;
  }
  
  public final void setPlayer(com.tencent.mm.plugin.thumbplayer.e.b paramb)
  {
    this.GvH = paramb;
  }
  
  public final void setTextureView(MMThumbPlayerTextureView paramMMThumbPlayerTextureView)
  {
    AppMethodBeat.i(272382);
    s.u(paramMMThumbPlayerTextureView, "<set-?>");
    this.Fld = paramMMThumbPlayerTextureView;
    AppMethodBeat.o(272382);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/MMTPVideoLayout$SurfaceTextureListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPVideoLayout;)V", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    implements TextureView.SurfaceTextureListener
  {
    public a()
    {
      AppMethodBeat.i(272287);
      AppMethodBeat.o(272287);
    }
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(272324);
      s.u(paramSurfaceTexture, "surface");
      Log.i(MMTPVideoLayout.a(this.TGS), "onSurfaceTextureAvailable, surface:" + paramSurfaceTexture.hashCode() + ", width:" + paramInt1 + ", height:" + paramInt2 + ", enableEffect:" + MMTPVideoLayout.f(this.TGS));
      MMTPVideoLayout.b(this.TGS, paramSurfaceTexture);
      MMTPVideoLayout.a(this.TGS, paramInt1);
      MMTPVideoLayout.b(this.TGS, paramInt2);
      this.TGS.getEffector().mh(paramInt1, paramInt2);
      if (MMTPVideoLayout.f(this.TGS))
      {
        this.TGS.getEffector().r(paramSurfaceTexture);
        AppMethodBeat.o(272324);
        return;
      }
      MMTPVideoLayout.a(this.TGS, paramSurfaceTexture);
      if (MMTPVideoLayout.c(this.TGS) != null)
      {
        paramSurfaceTexture = MMTPVideoLayout.c(this.TGS);
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.release();
        }
      }
      MMTPVideoLayout.a(this.TGS, new Surface(MMTPVideoLayout.b(this.TGS)));
      paramSurfaceTexture = this.TGS.getPlayer();
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.b(MMTPVideoLayout.c(this.TGS), true);
      }
      AppMethodBeat.o(272324);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(272312);
      s.u(paramSurfaceTexture, "surface");
      Log.i(MMTPVideoLayout.a(this.TGS), "onSurfaceTextureDestroyed, surface:" + paramSurfaceTexture.hashCode() + ", enableEffect:" + MMTPVideoLayout.f(this.TGS));
      MMTPVideoLayout.b(this.TGS, null);
      if (!MMTPVideoLayout.f(this.TGS))
      {
        paramSurfaceTexture = MMTPVideoLayout.c(this.TGS);
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.release();
        }
      }
      paramSurfaceTexture = this.TGS.getPlayer();
      if (paramSurfaceTexture != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.a(paramSurfaceTexture, null);
      }
      AppMethodBeat.o(272312);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(272297);
      s.u(paramSurfaceTexture, "surface");
      Log.i(MMTPVideoLayout.a(this.TGS), "onSurfaceTextureSizeChanged, surface:" + paramSurfaceTexture.hashCode() + ", width:" + paramInt1 + ", height:" + paramInt2 + ", layout size:[" + this.TGS.getWidth() + ',' + this.TGS.getHeight() + ']');
      MMTPVideoLayout.b(this.TGS, paramSurfaceTexture);
      MMTPVideoLayout.a(this.TGS, paramInt1);
      MMTPVideoLayout.b(this.TGS, paramInt2);
      this.TGS.getEffector().mh(paramInt1, paramInt2);
      AppMethodBeat.o(272297);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(272303);
      s.u(paramSurfaceTexture, "surface");
      MMTPVideoLayout.d(this.TGS);
      MMTPVideoLayout.b(this.TGS, paramSurfaceTexture);
      AppMethodBeat.o(272303);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(MMTPVideoLayout paramMMTPVideoLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Long, ah>
  {
    c(MMTPVideoLayout paramMMTPVideoLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "surface", "Landroid/graphics/SurfaceTexture;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<SurfaceTexture, ah>
  {
    d(MMTPVideoLayout paramMMTPVideoLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMTPVideoLayout
 * JD-Core Version:    0.7.0.1
 */