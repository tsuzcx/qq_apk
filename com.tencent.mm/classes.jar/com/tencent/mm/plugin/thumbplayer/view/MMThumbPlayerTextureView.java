package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cropRect", "Landroid/graphics/Rect;", "originVideoHeight", "", "originVideoWidth", "radioHeight", "radioWidth", "scaleType", "textureListener", "com/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView$textureListener$1", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView$textureListener$1;", "textureListenerCallback", "Landroid/view/TextureView$SurfaceTextureListener;", "videoDegree", "videoHeight", "videoWidth", "centerCrop", "", "containerWidth", "containerHeight", "centerFit", "cropVideo", "getScaleType", "handleOnMeasureLikeMM", "widthMeasureSpec", "heightMeasureSpec", "initView", "onMeasure", "reset", "rotateVideoSurface", "measureWidth", "measureHeight", "setCropRect", "setDegree", "", "degree", "setOpaqueInfo", "isOpaque", "setOriginVideoWidthAndHeight", "width", "height", "setRadio", "num", "den", "setScaleType", "setTextureListenerCallback", "listener", "setVideoWidthAndHeight", "Companion", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMThumbPlayerTextureView
  extends MMTextureView
{
  public static final MMThumbPlayerTextureView.a TGU;
  private Rect Gl;
  private int TFO;
  private float TFP;
  private float TFQ;
  private TextureView.SurfaceTextureListener TGV;
  private final MMThumbPlayerTextureView.b TGW;
  private int nDl;
  private int videoHeight;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(272475);
    TGU = new MMThumbPlayerTextureView.a((byte)0);
    AppMethodBeat.o(272475);
  }
  
  public MMThumbPlayerTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(272441);
    this.Gl = new Rect();
    this.TGW = new MMThumbPlayerTextureView.b(this);
    initView();
    AppMethodBeat.o(272441);
  }
  
  public MMThumbPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(272448);
    this.Gl = new Rect();
    this.TGW = new MMThumbPlayerTextureView.b(this);
    initView();
    AppMethodBeat.o(272448);
  }
  
  public MMThumbPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(272455);
    this.Gl = new Rect();
    this.TGW = new MMThumbPlayerTextureView.b(this);
    initView();
    AppMethodBeat.o(272455);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(272459);
    setOpaque(false);
    setAlpha(0.0F);
    setScaleX(1.0001F);
    setScaleY(1.0001F);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this.TGW);
    AppMethodBeat.o(272459);
  }
  
  private final void mk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272468);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "centerCrop, container:[" + paramInt1 + ", " + paramInt2 + ']');
    float f3 = paramInt1 / this.videoWidth;
    float f1 = paramInt2 / this.videoHeight;
    float f2 = Math.max(f3, f1);
    f3 = f2 / f3;
    f1 = f2 / f1;
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(f3, f1, paramInt1 / 2.0F, paramInt2 / 2.0F);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", s.X("centerCrop matrix:", localMatrix));
    setTransform(localMatrix);
    AppMethodBeat.o(272468);
  }
  
  public final void aZ(float paramFloat1, float paramFloat2)
  {
    this.TFP = paramFloat1;
    this.TFQ = paramFloat2;
  }
  
  public final int getScaleType()
  {
    return this.nDl;
  }
  
  public final void mj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272501);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "setVideoWidthAndHeight videoWidth:" + this.videoWidth + ", videoHeight:" + this.videoHeight + ", width:" + paramInt1 + ", height:" + paramInt2 + " scaleType:" + this.nDl);
    if ((this.videoWidth != paramInt1) || (this.videoHeight != paramInt2))
    {
      this.videoWidth = paramInt1;
      this.videoHeight = paramInt2;
      requestLayout();
      AppMethodBeat.o(272501);
      return;
    }
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    AppMethodBeat.o(272501);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272539);
    if ((this.videoWidth == 0) || (this.videoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      AppMethodBeat.o(272539);
      return;
    }
    int j = MMTextureView.getDefaultSize(1, paramInt1);
    int k = MMTextureView.getDefaultSize(1, paramInt2);
    Object localObject;
    float f1;
    float f2;
    float f3;
    switch (this.nDl)
    {
    case 2: 
    default: 
      setTransform(new Matrix());
      if ((this.TFO == 90) || (this.TFO == 270))
      {
        localObject = new Matrix();
        ((Matrix)localObject).set(getMatrix());
        f1 = j / 2.0F;
        f2 = k / 2.0F;
        f3 = k / j;
        if (getScaleX() != 1.0F) {
          break label703;
        }
        i = 1;
        label162:
        if (i != 0) {
          if (getScaleY() != 1.0F) {
            break label709;
          }
        }
      }
      break;
    }
    label450:
    label709:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((Matrix)localObject).setScale(getScaleX(), getScaleY(), f1, f2);
      }
      ((Matrix)localObject).postRotate(this.TFO, f1, f2);
      ((Matrix)localObject).postScale(1.0F / f3, f3, f1, f2);
      setTransform((Matrix)localObject);
      setMeasuredDimension(j, k);
      Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "onMeasure#handleOnMeasureLikeMM video size[" + this.videoWidth + ' ' + this.videoHeight + "] spec[" + MMTextureView.getDefaultSize(1, paramInt1) + ", " + MMTextureView.getDefaultSize(1, paramInt2) + "] result=" + j + ',' + k);
      AppMethodBeat.o(272539);
      return;
      mk(j, k);
      break;
      f3 = j / this.videoWidth;
      f1 = k / this.videoHeight;
      f2 = Math.min(f3, f1);
      f3 = f2 / f3;
      f1 = f2 / f1;
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f3, f1, j / 2.0F, k / 2.0F);
      setTransform((Matrix)localObject);
      break;
      if (!this.Gl.isEmpty())
      {
        localObject = this.Gl;
        if (this.TFP == 0.0F)
        {
          i = 1;
          if (i != 0) {
            break label684;
          }
          if (this.TFQ != 0.0F) {
            break label686;
          }
        }
        for (i = 1;; i = 0)
        {
          if ((i != 0) || (((Rect)localObject).isEmpty())) {
            break label690;
          }
          f1 = j / ((Rect)localObject).width();
          f2 = k / ((Rect)localObject).height();
          f3 = j / this.TFP;
          float f4 = k / this.TFQ;
          float f5 = Math.max(f3, f4);
          f3 = f5 / f3;
          f4 = f5 / f4;
          f5 = this.TFP / 2.0F;
          float f6 = ((Rect)localObject).centerX();
          float f7 = this.TFQ / 2.0F;
          float f8 = ((Rect)localObject).centerY();
          localObject = new Matrix();
          ((Matrix)localObject).setScale(f3, f4, j / 2.0F, k / 2.0F);
          ((Matrix)localObject).postTranslate(f1 * (f5 - f6), (f7 - f8) * f2);
          Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "cropRect(), containerWidth:" + j + " containerHeight:" + k + ' ' + localObject);
          setTransform((Matrix)localObject);
          break;
          i = 0;
          break label450;
          break;
        }
        break;
      }
      mk(j, k);
      break;
      i = 0;
      break label162;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(272484);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", s.X("reset cropRect=", this.Gl));
    this.Gl = new Rect();
    AppMethodBeat.o(272484);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(272478);
    s.u(paramRect, "cropRect");
    this.Gl = paramRect;
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", s.X("setCropRect, cropRect:", paramRect));
    AppMethodBeat.o(272478);
  }
  
  public final void setOpaqueInfo(boolean paramBoolean)
  {
    AppMethodBeat.i(272514);
    if (paramBoolean)
    {
      setOpaque(true);
      setAlpha(1.0F);
      AppMethodBeat.o(272514);
      return;
    }
    setOpaque(false);
    setAlpha(0.0F);
    AppMethodBeat.o(272514);
  }
  
  public final void setScaleType(int paramInt)
  {
    AppMethodBeat.i(272490);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", s.X("setScaleType, scaleType:", Integer.valueOf(paramInt)));
    this.nDl = paramInt;
    AppMethodBeat.o(272490);
  }
  
  public final void setTextureListenerCallback(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    this.TGV = paramSurfaceTextureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */