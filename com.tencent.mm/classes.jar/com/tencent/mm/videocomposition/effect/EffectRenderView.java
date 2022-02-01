package com.tencent.mm.videocomposition.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/effect/EffectRenderView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "TAG", "", "renderController", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController;", "value", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "surfaceCallback", "getSurfaceCallback", "()Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "setSurfaceCallback", "(Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;)V", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "queue", "callback", "Lkotlin/Function0;", "release", "requestRender", "setInputBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setInputContentInfo", "rotate", "video_composition_release"})
public final class EffectRenderView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private final String TAG;
  public b YIy;
  
  public EffectRenderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(248299);
    this.TAG = ("EffectRenderView@" + hashCode());
    this.YIy = new b();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    AppMethodBeat.o(248299);
  }
  
  public EffectRenderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(248303);
    this.TAG = ("EffectRenderView@" + hashCode());
    this.YIy = new b();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    AppMethodBeat.o(248303);
  }
  
  public EffectRenderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(248306);
    this.TAG = ("EffectRenderView@" + hashCode());
    this.YIy = new b();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    AppMethodBeat.o(248306);
  }
  
  public final void bg(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(248292);
    com.tencent.mm.videocomposition.c.b.i(this.TAG, "setInputContentInfo, size:[" + paramInt1 + ',' + paramInt2 + "], rotate:" + paramInt3, new Object[0]);
    this.YIy.bg(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(248292);
  }
  
  public final EffectManager getEffectManager()
  {
    return this.YIy.ANo;
  }
  
  public final b.b getSurfaceCallback()
  {
    return this.YIy.YIF;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248290);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
    if (paramSurfaceTexture != null) {}
    for (int i = paramSurfaceTexture.hashCode();; i = 0)
    {
      com.tencent.mm.videocomposition.c.b.i(str, i + ", size:[" + paramInt1 + ", " + paramInt2 + ']', new Object[0]);
      if (paramSurfaceTexture == null) {
        break;
      }
      this.YIy.d(paramSurfaceTexture, paramInt1, paramInt2);
      AppMethodBeat.o(248290);
      return;
    }
    AppMethodBeat.o(248290);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248287);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureDestroyed, surface:");
    if (paramSurfaceTexture != null) {}
    for (int i = paramSurfaceTexture.hashCode();; i = 0)
    {
      com.tencent.mm.videocomposition.c.b.i(str, i, new Object[0]);
      this.YIy.igN();
      AppMethodBeat.o(248287);
      return true;
    }
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248284);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureSizeChanged, surface:");
    if (paramSurfaceTexture != null) {}
    for (int i = paramSurfaceTexture.hashCode();; i = 0)
    {
      com.tencent.mm.videocomposition.c.b.i(str, i + ", size:[" + paramInt1 + ", " + paramInt2 + ']', new Object[0]);
      this.YIy.setSize(paramInt1, paramInt2);
      AppMethodBeat.o(248284);
      return;
    }
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setInputBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(248294);
    p.k(paramBitmap, "bitmap");
    com.tencent.mm.videocomposition.c.b.i(this.TAG, "setInputBitmap: " + paramBitmap + ", size:[" + paramBitmap.getWidth() + ',' + paramBitmap.getHeight() + ']', new Object[0]);
    this.YIy.setInputBitmap(paramBitmap);
    AppMethodBeat.o(248294);
  }
  
  public final void setSurfaceCallback(b.b paramb)
  {
    AppMethodBeat.i(248282);
    b localb = this.YIy;
    localb.YIF = paramb;
    localb.YID = true;
    if ((localb.YIM) && (localb.YIB.textureId <= 0)) {
      localb.j((a)new b.l(localb));
    }
    AppMethodBeat.o(248282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.EffectRenderView
 * JD-Core Version:    0.7.0.1
 */