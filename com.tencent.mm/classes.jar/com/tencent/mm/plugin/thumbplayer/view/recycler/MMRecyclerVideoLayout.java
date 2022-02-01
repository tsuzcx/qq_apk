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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.thumbplayer.f.d.a;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMRecyclerVideoLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "getPlayer$plugin_thumbplayer_release", "()Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "setPlayer$plugin_thumbplayer_release", "(Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;)V", "surface", "Landroid/view/Surface;", "getSurface$plugin_thumbplayer_release", "()Landroid/view/Surface;", "setSurface$plugin_thumbplayer_release", "(Landroid/view/Surface;)V", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "getTextureView$plugin_thumbplayer_release", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "setTextureView$plugin_thumbplayer_release", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;)V", "initPlayer", "", "initTextureView", "onVideoContentUpdate", "pause", "setLoop", "isLoop", "", "setMediaInfo", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "setMute", "isMute", "start", "stop", "recycler", "Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "SurfaceTextureListener", "plugin-thumbplayer_release"})
public class MMRecyclerVideoLayout
  extends FrameLayout
{
  private MMThumbPlayerTextureView AMp;
  private com.tencent.mm.plugin.thumbplayer.f.b Ght;
  private final String TAG;
  private Surface surface;
  
  public MMRecyclerVideoLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(190359);
    this.TAG = ("MicroMsg.TP.MMRecyclerVideoLayout@" + hashCode());
    AppMethodBeat.o(190359);
  }
  
  public MMRecyclerVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(190362);
    this.TAG = ("MicroMsg.TP.MMRecyclerVideoLayout@" + hashCode());
    AppMethodBeat.o(190362);
  }
  
  public MMRecyclerVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190365);
    this.TAG = ("MicroMsg.TP.MMRecyclerVideoLayout@" + hashCode());
    AppMethodBeat.o(190365);
  }
  
  public final void dLb()
  {
    AppMethodBeat.i(190336);
    Object localObject = com.tencent.mm.plugin.thumbplayer.f.d.MTv;
    localObject = getContext();
    p.j(localObject, "context");
    this.Ght = d.a.iA((Context)localObject);
    this.AMp = new MMThumbPlayerTextureView(getContext());
    localObject = this.AMp;
    if (localObject != null)
    {
      ((MMThumbPlayerTextureView)localObject).setAlpha(1.0F);
      AppMethodBeat.o(190336);
      return;
    }
    AppMethodBeat.o(190336);
  }
  
  public final com.tencent.mm.plugin.thumbplayer.f.b getPlayer$plugin_thumbplayer_release()
  {
    return this.Ght;
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
    return this.AMp;
  }
  
  public final void goW()
  {
    AppMethodBeat.i(190349);
    Object localObject1 = this.AMp;
    int i;
    label127:
    int j;
    label156:
    Object localObject2;
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject1 = ((MMThumbPlayerTextureView)localObject1).getParent();
      if (localObject1 != null) {
        removeView((View)this.AMp);
      }
      localObject1 = this.AMp;
      if (localObject1 != null) {
        ((MMThumbPlayerTextureView)localObject1).setTextureListenerCallback((TextureView.SurfaceTextureListener)new a());
      }
      localObject1 = this.Ght;
      if (localObject1 == null) {
        break label368;
      }
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).MSO;
      if ((localObject1 == null) || (((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSB != true)) {
        break label368;
      }
      localObject1 = this.Ght;
      if (localObject1 == null) {
        break label358;
      }
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).MSO;
      if (localObject1 == null) {
        break label358;
      }
      i = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).width;
      localObject1 = this.Ght;
      if (localObject1 == null) {
        break label363;
      }
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).MSO;
      if (localObject1 == null) {
        break label363;
      }
      j = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).height;
      int k = a.kr(MMApplicationContext.getContext());
      float f = i / k;
      f = j / f;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("width", k);
      ((Bundle)localObject1).putInt("height", (int)f);
      i = ((Bundle)localObject1).getInt("width", 0);
      j = ((Bundle)localObject1).getInt("height", 0);
      localObject1 = this.AMp;
      if (localObject1 != null) {
        ((MMThumbPlayerTextureView)localObject1).kw(i, j);
      }
      localObject1 = new FrameLayout.LayoutParams(i, j);
      ((FrameLayout.LayoutParams)localObject1).gravity = 17;
      addView((View)this.AMp, (ViewGroup.LayoutParams)localObject1);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("initTextureView() ");
      localObject1 = this.Ght;
      if (localObject1 == null) {
        break label466;
      }
    }
    label415:
    label461:
    label466:
    for (localObject1 = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).eha();; localObject1 = null)
    {
      Log.i((String)localObject2, (String)localObject1 + ", layout size:[" + i + ',' + j + ']');
      AppMethodBeat.o(190349);
      return;
      localObject1 = null;
      break;
      label358:
      i = 0;
      break label127;
      label363:
      j = 0;
      break label156;
      label368:
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
            break label461;
          }
          localObject2 = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject2).MSO;
          if (localObject2 == null) {
            break label461;
          }
        }
      }
      for (j = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).height;; j = 0)
      {
        localObject1 = com.tencent.mm.plugin.thumbplayer.b.l((Context)localObject1, i, j);
        break;
        i = 0;
        break label415;
      }
    }
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(190354);
    com.tencent.mm.plugin.thumbplayer.f.b localb = this.Ght;
    if (localb != null)
    {
      localb.setLoop(paramBoolean);
      AppMethodBeat.o(190354);
      return;
    }
    AppMethodBeat.o(190354);
  }
  
  public final void setMediaInfo(com.tencent.mm.plugin.thumbplayer.e.d paramd)
  {
    AppMethodBeat.i(190339);
    p.k(paramd, "mediaInfo");
    Log.i(this.TAG, "setMediaInfo:".concat(String.valueOf(paramd)));
    com.tencent.mm.plugin.thumbplayer.f.b localb = this.Ght;
    if (localb != null)
    {
      localb.setMediaInfo(paramd);
      AppMethodBeat.o(190339);
      return;
    }
    AppMethodBeat.o(190339);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(190350);
    com.tencent.mm.plugin.thumbplayer.f.b localb = this.Ght;
    if (localb != null)
    {
      localb.setMute(paramBoolean);
      AppMethodBeat.o(190350);
      return;
    }
    AppMethodBeat.o(190350);
  }
  
  public final void setPlayer$plugin_thumbplayer_release(com.tencent.mm.plugin.thumbplayer.f.b paramb)
  {
    this.Ght = paramb;
  }
  
  public final void setSurface$plugin_thumbplayer_release(Surface paramSurface)
  {
    this.surface = paramSurface;
  }
  
  public final void setTextureView$plugin_thumbplayer_release(MMThumbPlayerTextureView paramMMThumbPlayerTextureView)
  {
    this.AMp = paramMMThumbPlayerTextureView;
  }
  
  public final void start()
  {
    AppMethodBeat.i(190357);
    com.tencent.mm.plugin.thumbplayer.f.b localb = this.Ght;
    if (localb != null) {
      localb.ALj = true;
    }
    localb = this.Ght;
    if (localb != null)
    {
      localb.gos();
      AppMethodBeat.o(190357);
      return;
    }
    AppMethodBeat.o(190357);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMRecyclerVideoLayout$SurfaceTextureListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "(Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMRecyclerVideoLayout;)V", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"})
  public final class a
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(189487);
      String str = this.MVi.getTAG();
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
      Surface localSurface = this.MVi.getSurface$plugin_thumbplayer_release();
      if (localSurface != null) {}
      for (int i = localSurface.hashCode();; i = 0)
      {
        Log.i(str, i + ", width:" + paramInt1 + ", height:" + paramInt2);
        this.MVi.setSurface$plugin_thumbplayer_release(new Surface(paramSurfaceTexture));
        paramSurfaceTexture = this.MVi.getPlayer$plugin_thumbplayer_release();
        if (paramSurfaceTexture == null) {
          break;
        }
        paramSurfaceTexture.b(this.MVi.getSurface$plugin_thumbplayer_release(), true);
        AppMethodBeat.o(189487);
        return;
      }
      AppMethodBeat.o(189487);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(189479);
      String str = this.MVi.getTAG();
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureDestroyed, surface:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i(str, i);
        paramSurfaceTexture = this.MVi.getPlayer$plugin_thumbplayer_release();
        if (paramSurfaceTexture != null) {
          com.tencent.mm.plugin.thumbplayer.f.b.a(paramSurfaceTexture, null);
        }
        AppMethodBeat.o(189479);
        return true;
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(189469);
      String str = this.MVi.getTAG();
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureSizeChanged, surface:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i(str, i + ", width:" + paramInt1 + ", height:" + paramInt2 + ", layout size:[" + this.MVi.getWidth() + ',' + this.MVi.getHeight() + ']');
        AppMethodBeat.o(189469);
        return;
      }
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(189470);
      MMRecyclerVideoLayout.a(this.MVi);
      AppMethodBeat.o(189470);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.recycler.MMRecyclerVideoLayout
 * JD-Core Version:    0.7.0.1
 */