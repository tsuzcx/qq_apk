package com.tencent.mm.plugin.thumbplayer.view.recycler;

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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMRecyclerVideoLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "getPlayer$plugin_thumbplayer_release", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "setPlayer$plugin_thumbplayer_release", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "surface", "Landroid/view/Surface;", "getSurface$plugin_thumbplayer_release", "()Landroid/view/Surface;", "setSurface$plugin_thumbplayer_release", "(Landroid/view/Surface;)V", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "getTextureView$plugin_thumbplayer_release", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "setTextureView$plugin_thumbplayer_release", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;)V", "initPlayer", "", "initTextureView", "onVideoContentUpdate", "pause", "setLoop", "isLoop", "", "setMediaInfo", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "setMute", "isMute", "start", "stop", "recycler", "Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "SurfaceTextureListener", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public class MMRecyclerVideoLayout
  extends FrameLayout
{
  private MMThumbPlayerTextureView Fld;
  private com.tencent.mm.plugin.thumbplayer.e.b GvH;
  private final String TAG;
  private Surface surface;
  
  public MMRecyclerVideoLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(272454);
    this.TAG = s.X("MicroMsg.TP.MMRecyclerVideoLayout@", Integer.valueOf(hashCode()));
    AppMethodBeat.o(272454);
  }
  
  public MMRecyclerVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(272461);
    this.TAG = s.X("MicroMsg.TP.MMRecyclerVideoLayout@", Integer.valueOf(hashCode()));
    AppMethodBeat.o(272461);
  }
  
  public MMRecyclerVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(272465);
    this.TAG = s.X("MicroMsg.TP.MMRecyclerVideoLayout@", Integer.valueOf(hashCode()));
    AppMethodBeat.o(272465);
  }
  
  public final void eDO()
  {
    AppMethodBeat.i(272513);
    Object localObject = d.TFK;
    localObject = getContext();
    s.s(localObject, "context");
    this.GvH = d.a.ks((Context)localObject);
    this.Fld = new MMThumbPlayerTextureView(getContext());
    localObject = this.Fld;
    if (localObject != null) {
      ((MMThumbPlayerTextureView)localObject).setAlpha(1.0F);
    }
    AppMethodBeat.o(272513);
  }
  
  public final com.tencent.mm.plugin.thumbplayer.e.b getPlayer$plugin_thumbplayer_release()
  {
    return this.GvH;
  }
  
  public final Surface getSurface$plugin_thumbplayer_release()
  {
    return this.surface;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final MMThumbPlayerTextureView getTextureView$plugin_thumbplayer_release()
  {
    return this.Fld;
  }
  
  public final void hLO()
  {
    AppMethodBeat.i(272536);
    Object localObject1 = this.Fld;
    int i;
    label96:
    label113:
    int j;
    label126:
    Object localObject2;
    StringBuilder localStringBuilder;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        removeView((View)this.Fld);
      }
      localObject1 = this.Fld;
      if (localObject1 != null) {
        ((MMThumbPlayerTextureView)localObject1).setTextureListenerCallback((TextureView.SurfaceTextureListener)new a());
      }
      localObject1 = this.GvH;
      if (localObject1 == null) {
        break label328;
      }
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TFb;
      if ((localObject1 == null) || (((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).TBK != true)) {
        break label328;
      }
      i = 1;
      if (i == 0) {
        break label385;
      }
      localObject1 = this.GvH;
      if (localObject1 != null) {
        break label333;
      }
      i = 0;
      localObject1 = this.GvH;
      if (localObject1 != null) {
        break label359;
      }
      j = 0;
      int k = a.ms(MMApplicationContext.getContext());
      float f = i / k;
      f = j / f;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("width", k);
      ((Bundle)localObject1).putInt("height", (int)f);
      i = ((Bundle)localObject1).getInt("width", 0);
      j = ((Bundle)localObject1).getInt("height", 0);
      localObject1 = this.Fld;
      if (localObject1 != null) {
        ((MMThumbPlayerTextureView)localObject1).mj(i, j);
      }
      localObject1 = new FrameLayout.LayoutParams(i, j);
      ((FrameLayout.LayoutParams)localObject1).gravity = 17;
      addView((View)this.Fld, (ViewGroup.LayoutParams)localObject1);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("initTextureView() ");
      localObject1 = this.GvH;
      if (localObject1 != null) {
        break label493;
      }
    }
    label328:
    label333:
    label359:
    label493:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).hLo())
    {
      Log.i((String)localObject2, localObject1 + ", layout size:[" + i + ',' + j + ']');
      AppMethodBeat.o(272536);
      return;
      localObject1 = ((MMThumbPlayerTextureView)localObject1).getParent();
      break;
      i = 0;
      break label96;
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TFb;
      if (localObject1 == null)
      {
        i = 0;
        break label113;
      }
      i = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).width;
      break label113;
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TFb;
      if (localObject1 == null)
      {
        j = 0;
        break label126;
      }
      j = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).height;
      break label126;
      localObject1 = com.tencent.mm.plugin.thumbplayer.b.TBI;
      localObject1 = getContext();
      s.s(localObject1, "context");
      localObject2 = this.GvH;
      if (localObject2 == null)
      {
        i = 0;
        localObject2 = this.GvH;
        if (localObject2 != null) {
          break label467;
        }
        j = 0;
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.thumbplayer.b.p((Context)localObject1, i, j);
        break;
        localObject2 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).TFb;
        if (localObject2 == null)
        {
          i = 0;
          break label416;
        }
        i = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).width;
        break label416;
        localObject2 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).TFb;
        if (localObject2 == null) {
          j = 0;
        } else {
          j = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).height;
        }
      }
    }
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(272550);
    com.tencent.mm.plugin.thumbplayer.e.b localb = this.GvH;
    if (localb != null) {
      localb.setLoop(paramBoolean);
    }
    AppMethodBeat.o(272550);
  }
  
  public final void setMediaInfo(com.tencent.mm.plugin.thumbplayer.a.b paramb)
  {
    AppMethodBeat.i(272518);
    s.u(paramb, "mediaInfo");
    Log.i(this.TAG, s.X("setMediaInfo:", paramb));
    com.tencent.mm.plugin.thumbplayer.e.b localb = this.GvH;
    if (localb != null) {
      localb.setMediaInfo(paramb);
    }
    AppMethodBeat.o(272518);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(272543);
    com.tencent.mm.plugin.thumbplayer.e.b localb = this.GvH;
    if (localb != null) {
      localb.setMute(paramBoolean);
    }
    AppMethodBeat.o(272543);
  }
  
  public final void setPlayer$plugin_thumbplayer_release(com.tencent.mm.plugin.thumbplayer.e.b paramb)
  {
    this.GvH = paramb;
  }
  
  public final void setSurface$plugin_thumbplayer_release(Surface paramSurface)
  {
    this.surface = paramSurface;
  }
  
  public final void setTextureView$plugin_thumbplayer_release(MMThumbPlayerTextureView paramMMThumbPlayerTextureView)
  {
    this.Fld = paramMMThumbPlayerTextureView;
  }
  
  public final void start()
  {
    AppMethodBeat.i(272556);
    com.tencent.mm.plugin.thumbplayer.e.b localb = this.GvH;
    if (localb != null) {
      localb.Flr = true;
    }
    localb = this.GvH;
    if (localb != null) {
      localb.hLh();
    }
    AppMethodBeat.o(272556);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMRecyclerVideoLayout$SurfaceTextureListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "(Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMRecyclerVideoLayout;)V", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    implements TextureView.SurfaceTextureListener
  {
    public a()
    {
      AppMethodBeat.i(272439);
      AppMethodBeat.o(272439);
    }
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(272471);
      s.u(paramSurfaceTexture, "surfaceTexture");
      String str = this.THK.getTAG();
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
      Surface localSurface = this.THK.getSurface$plugin_thumbplayer_release();
      if (localSurface != null) {}
      for (int i = localSurface.hashCode();; i = 0)
      {
        Log.i(str, i + ", width:" + paramInt1 + ", height:" + paramInt2);
        this.THK.setSurface$plugin_thumbplayer_release(new Surface(paramSurfaceTexture));
        paramSurfaceTexture = this.THK.getPlayer$plugin_thumbplayer_release();
        if (paramSurfaceTexture != null) {
          paramSurfaceTexture.b(this.THK.getSurface$plugin_thumbplayer_release(), true);
        }
        AppMethodBeat.o(272471);
        return;
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(272462);
      s.u(paramSurfaceTexture, "surface");
      Log.i(this.THK.getTAG(), s.X("onSurfaceTextureDestroyed, surface:", Integer.valueOf(paramSurfaceTexture.hashCode())));
      paramSurfaceTexture = this.THK.getPlayer$plugin_thumbplayer_release();
      if (paramSurfaceTexture != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.a(paramSurfaceTexture, null);
      }
      AppMethodBeat.o(272462);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(272450);
      s.u(paramSurfaceTexture, "surface");
      Log.i(this.THK.getTAG(), "onSurfaceTextureSizeChanged, surface:" + paramSurfaceTexture.hashCode() + ", width:" + paramInt1 + ", height:" + paramInt2 + ", layout size:[" + this.THK.getWidth() + ',' + this.THK.getHeight() + ']');
      AppMethodBeat.o(272450);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(272456);
      s.u(paramSurfaceTexture, "surface");
      MMRecyclerVideoLayout.a(this.THK);
      AppMethodBeat.o(272456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.recycler.MMRecyclerVideoLayout
 * JD-Core Version:    0.7.0.1
 */