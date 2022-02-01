package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cropRect", "Landroid/graphics/Rect;", "originVideoHeight", "", "originVideoWidth", "radioHeight", "radioWidth", "scaleType", "textureListener", "com/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView$textureListener$1", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView$textureListener$1;", "textureListenerCallback", "Landroid/view/TextureView$SurfaceTextureListener;", "videoDegree", "videoHeight", "videoWidth", "centerCrop", "", "containerWidth", "containerHeight", "centerFit", "cropVideo", "getScaleType", "handleOnMeasureLikeMM", "widthMeasureSpec", "heightMeasureSpec", "initView", "onMeasure", "reset", "rotateVideoSurface", "measureWidth", "measureHeight", "setCropRect", "setDegree", "", "degree", "setOpaqueInfo", "isOpaque", "setOriginVideoWidthAndHeight", "width", "height", "setRadio", "num", "den", "setScaleType", "setTextureListenerCallback", "listener", "setVideoWidthAndHeight", "Companion", "plugin-thumbplayer_release"})
public final class MMThumbPlayerTextureView
  extends MMTextureView
{
  private static final int MUs = 0;
  private static final int MUt = 1;
  private static final int MUu = 2;
  private static final int MUv = 3;
  public static final MMThumbPlayerTextureView.a MUw;
  private int MUn;
  private float MUo;
  private float MUp;
  private TextureView.SurfaceTextureListener MUq;
  private final b MUr;
  private Rect kXj;
  private int kYn;
  private int videoHeight;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(191403);
    MUw = new MMThumbPlayerTextureView.a((byte)0);
    MUt = 1;
    MUu = 2;
    MUv = 3;
    AppMethodBeat.o(191403);
  }
  
  public MMThumbPlayerTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(191399);
    this.kYn = MUs;
    this.kXj = new Rect();
    this.MUr = new b(this);
    initView();
    AppMethodBeat.o(191399);
  }
  
  public MMThumbPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(191400);
    this.kYn = MUs;
    this.kXj = new Rect();
    this.MUr = new b(this);
    initView();
    AppMethodBeat.o(191400);
  }
  
  public MMThumbPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(191402);
    this.kYn = MUs;
    this.kXj = new Rect();
    this.MUr = new b(this);
    initView();
    AppMethodBeat.o(191402);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(191365);
    setOpaque(false);
    setAlpha(0.0F);
    setScaleX(1.0001F);
    setScaleY(1.0001F);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this.MUr);
    AppMethodBeat.o(191365);
  }
  
  private final void kx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191398);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "centerCrop, container:[" + paramInt1 + ", " + paramInt2 + ']');
    float f3 = paramInt1 / this.videoWidth;
    float f1 = paramInt2 / this.videoHeight;
    float f2 = Math.max(f3, f1);
    f3 = f2 / f3;
    f1 = f2 / f1;
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(f3, f1, getWidth() / 2.0F, getHeight() / 2.0F);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "centerCrop matrix:".concat(String.valueOf(localMatrix)));
    setTransform(localMatrix);
    AppMethodBeat.o(191398);
  }
  
  public final void at(float paramFloat1, float paramFloat2)
  {
    this.MUo = paramFloat1;
    this.MUp = paramFloat2;
  }
  
  public final int getScaleType()
  {
    return this.kYn;
  }
  
  public final void kw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191376);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "setVideoWidthAndHeight videoWidth:" + this.videoWidth + ", videoHeight:" + this.videoHeight + ", width:" + paramInt1 + ", height:" + paramInt2 + " scaleType:" + this.kYn);
    if ((this.videoWidth != paramInt1) || (this.videoHeight != paramInt2))
    {
      this.videoWidth = paramInt1;
      this.videoHeight = paramInt2;
      requestLayout();
      AppMethodBeat.o(191376);
      return;
    }
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    AppMethodBeat.o(191376);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191397);
    if ((this.videoWidth == 0) || (this.videoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      AppMethodBeat.o(191397);
      return;
    }
    int i = MMTextureView.getDefaultSize(1, paramInt1);
    int j = MMTextureView.getDefaultSize(1, paramInt2);
    int k = this.kYn;
    if (k == MUs) {
      kx(i, j);
    }
    for (;;)
    {
      Object localObject;
      float f1;
      float f2;
      float f3;
      if ((this.MUn == 90) || (this.MUn == 270))
      {
        localObject = new Matrix();
        ((Matrix)localObject).set(getMatrix());
        f1 = i / 2.0F;
        f2 = j / 2.0F;
        f3 = j / i;
        if ((getScaleX() != 1.0F) || (getScaleY() != 1.0F)) {
          ((Matrix)localObject).setScale(getScaleX(), getScaleY(), f1, f2);
        }
        ((Matrix)localObject).postRotate(this.MUn, f1, f2);
        ((Matrix)localObject).postScale(1.0F / f3, f3, f1, f2);
        setTransform((Matrix)localObject);
      }
      setMeasuredDimension(i, j);
      Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "onMeasure#handleOnMeasureLikeMM video size[" + this.videoWidth + ' ' + this.videoHeight + "] spec[" + MMTextureView.getDefaultSize(1, paramInt1) + ", " + MMTextureView.getDefaultSize(1, paramInt2) + "] result=" + i + ',' + j);
      AppMethodBeat.o(191397);
      return;
      if (k == MUt)
      {
        f3 = i / this.videoWidth;
        f1 = j / this.videoHeight;
        f2 = Math.min(f3, f1);
        f3 = f2 / f3;
        f1 = f2 / f1;
        localObject = new Matrix();
        ((Matrix)localObject).setScale(f3, f1, getWidth() / 2.0F, getHeight() / 2.0F);
        setTransform((Matrix)localObject);
      }
      else if (k == MUv)
      {
        if (!this.kXj.isEmpty())
        {
          localObject = this.kXj;
          if ((this.MUo != 0.0F) && (this.MUp != 0.0F) && (!((Rect)localObject).isEmpty()))
          {
            f1 = i / ((Rect)localObject).width();
            f2 = j / ((Rect)localObject).height();
            f3 = i / this.MUo;
            float f4 = j / this.MUp;
            float f5 = Math.max(f3, f4);
            f3 = f5 / f3;
            f4 = f5 / f4;
            f5 = this.MUo / 2.0F;
            float f6 = ((Rect)localObject).centerX();
            float f7 = this.MUp / 2.0F;
            float f8 = ((Rect)localObject).centerY();
            localObject = new Matrix();
            ((Matrix)localObject).setScale(f3, f4, i / 2.0F, j / 2.0F);
            ((Matrix)localObject).postTranslate(f1 * (f5 - f6), (f7 - f8) * f2);
            Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "cropRect(), containerWidth:" + i + " containerHeight:" + j + ' ' + localObject);
            setTransform((Matrix)localObject);
          }
        }
        else
        {
          kx(i, j);
        }
      }
      else
      {
        setTransform(new Matrix());
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(191371);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "reset cropRect=" + this.kXj);
    this.kXj = new Rect();
    AppMethodBeat.o(191371);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(191368);
    p.k(paramRect, "cropRect");
    this.kXj = paramRect;
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "setCropRect, cropRect:".concat(String.valueOf(paramRect)));
    AppMethodBeat.o(191368);
  }
  
  public final void setOpaqueInfo(boolean paramBoolean)
  {
    AppMethodBeat.i(191382);
    if (paramBoolean)
    {
      setOpaque(true);
      setAlpha(1.0F);
      AppMethodBeat.o(191382);
      return;
    }
    setOpaque(false);
    setAlpha(0.0F);
    AppMethodBeat.o(191382);
  }
  
  public final void setScaleType(int paramInt)
  {
    AppMethodBeat.i(191373);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "setScaleType, scaleType:".concat(String.valueOf(paramInt)));
    this.kYn = paramInt;
    AppMethodBeat.o(191373);
  }
  
  public final void setTextureListenerCallback(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    this.MUq = paramSurfaceTextureListener;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView$textureListener$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"})
  public static final class b
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192752);
      p.k(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.MUx);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
        AppMethodBeat.o(192752);
        return;
      }
      AppMethodBeat.o(192752);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(192754);
      p.k(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.MUx);
      if (localSurfaceTextureListener != null) {
        localSurfaceTextureListener.onSurfaceTextureDestroyed(paramSurfaceTexture);
      }
      AppMethodBeat.o(192754);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192757);
      p.k(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.MUx);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
        AppMethodBeat.o(192757);
        return;
      }
      AppMethodBeat.o(192757);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(192760);
      p.k(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.MUx);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureUpdated(paramSurfaceTexture);
        AppMethodBeat.o(192760);
        return;
      }
      AppMethodBeat.o(192760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */