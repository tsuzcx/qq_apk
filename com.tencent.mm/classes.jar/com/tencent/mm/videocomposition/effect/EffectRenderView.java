package com.tencent.mm.videocomposition.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/effect/EffectRenderView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "TAG", "", "renderController", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController;", "reportData", "Lcom/tencent/mm/videocomposition/effect/EffectRenderReportData;", "getReportData", "()Lcom/tencent/mm/videocomposition/effect/EffectRenderReportData;", "value", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "surfaceCallback", "getSurfaceCallback", "()Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "setSurfaceCallback", "(Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;)V", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "queue", "callback", "Lkotlin/Function0;", "release", "requestRender", "setInputBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setInputContentInfo", "rotate", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class EffectRenderView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  public b HkF;
  private final String TAG;
  
  public EffectRenderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(233634);
    this.TAG = ("EffectRenderView@" + hashCode());
    this.HkF = new b();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    getReportData().oQw = 2;
    AppMethodBeat.o(233634);
  }
  
  public EffectRenderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(233641);
    this.TAG = ("EffectRenderView@" + hashCode());
    this.HkF = new b();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    getReportData().oQw = 2;
    AppMethodBeat.o(233641);
  }
  
  public EffectRenderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(233648);
    this.TAG = ("EffectRenderView@" + hashCode());
    this.HkF = new b();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    getReportData().oQw = 2;
    AppMethodBeat.o(233648);
  }
  
  public final void bH(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(233701);
    com.tencent.mm.videocomposition.d.b.i(this.TAG, "setInputContentInfo, size:[" + paramInt1 + ',' + paramInt2 + "], rotate:" + paramInt3, new Object[0]);
    this.HkF.bH(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(233701);
  }
  
  public final EffectManager getEffectManager()
  {
    return this.HkF.GpO;
  }
  
  public final f getReportData()
  {
    return this.HkF.agEB;
  }
  
  public final b.b getSurfaceCallback()
  {
    return this.HkF.agEm;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233695);
    s.t(paramSurfaceTexture, "surface");
    com.tencent.mm.videocomposition.d.b.i(this.TAG, "onSurfaceTextureAvailable, surface:" + paramSurfaceTexture.hashCode() + ", size:[" + paramInt1 + ", " + paramInt2 + ']', new Object[0]);
    this.HkF.d(paramSurfaceTexture, paramInt1, paramInt2);
    AppMethodBeat.o(233695);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(233689);
    s.t(paramSurfaceTexture, "surface");
    com.tencent.mm.videocomposition.d.b.i(this.TAG, "onSurfaceTextureDestroyed, surface:" + paramSurfaceTexture.hashCode(), new Object[0]);
    this.HkF.jMc();
    paramSurfaceTexture = this.HkF.GpO;
    Object localObject = this.HkF.agEm;
    this.HkF = new b();
    this.HkF.setSurfaceCallback((b.b)localObject);
    localObject = this.HkF;
    s.t(paramSurfaceTexture, "<set-?>");
    ((d)localObject).GpO = paramSurfaceTexture;
    AppMethodBeat.o(233689);
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233672);
    s.t(paramSurfaceTexture, "surface");
    com.tencent.mm.videocomposition.d.b.i(this.TAG, "onSurfaceTextureSizeChanged, surface:" + paramSurfaceTexture.hashCode() + ", size:[" + paramInt1 + ", " + paramInt2 + ']', new Object[0]);
    this.HkF.setSize(paramInt1, paramInt2);
    AppMethodBeat.o(233672);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(233679);
    s.t(paramSurfaceTexture, "surface");
    AppMethodBeat.o(233679);
  }
  
  public final void setInputBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(233709);
    s.t(paramBitmap, "bitmap");
    com.tencent.mm.videocomposition.d.b.i(this.TAG, "setInputBitmap: " + paramBitmap + ", size:[" + paramBitmap.getWidth() + ',' + paramBitmap.getHeight() + ']', new Object[0]);
    this.HkF.setInputBitmap(paramBitmap);
    AppMethodBeat.o(233709);
  }
  
  public final void setSurfaceCallback(b.b paramb)
  {
    AppMethodBeat.i(233666);
    this.HkF.setSurfaceCallback(paramb);
    AppMethodBeat.o(233666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.EffectRenderView
 * JD-Core Version:    0.7.0.1
 */