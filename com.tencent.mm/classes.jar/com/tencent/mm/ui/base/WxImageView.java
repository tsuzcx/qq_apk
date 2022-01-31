package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.mm.graphics.ui.WxBaseImageView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public class WxImageView
  extends WxBaseImageView
  implements g
{
  private float aqM = 1.0F;
  protected Matrix aqz = new Matrix();
  private boolean isInited = false;
  private int jsq;
  private int jsr;
  protected ah mHandler = new ah();
  protected Bitmap oJZ = null;
  private boolean oYK = true;
  private MultiTouchImageView.a oZh;
  private int orientation;
  private final float[] tz = new float[9];
  protected Matrix uZJ = new Matrix();
  private final Matrix uZK = new Matrix();
  int uZL = -1;
  int uZM = -1;
  private float uZN = 0.0F;
  private float uZO = 0.0F;
  private float uZP = 0.0F;
  private float uZQ;
  private boolean uZR = false;
  private float uZS = 2.0F;
  private float uZT = 0.75F;
  private float uZU = 20.0F;
  private boolean uZV = false;
  private boolean uZW = false;
  private boolean uZX = false;
  private float uZY;
  private float uZZ;
  private boolean vab = false;
  private Drawable vac;
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cBk()
  {
    boolean bool2 = true;
    int i = getImageWidth();
    int j = getImageHeight();
    this.uZY = (this.jsq / i);
    this.uZZ = (this.jsr / j);
    boolean bool1;
    if (i > j * 2.2F)
    {
      bool1 = true;
      this.uZW = bool1;
      if (j <= i * 2.2F) {
        break label215;
      }
      bool1 = true;
      label79:
      this.uZX = bool1;
      if ((!this.uZW) || (i <= this.jsq)) {
        break label221;
      }
      bool1 = true;
      label104:
      this.uZW = bool1;
      if ((!this.uZX) || (j <= this.jsr)) {
        break label227;
      }
      bool1 = bool2;
      label130:
      this.uZX = bool1;
      float f3 = j / i;
      float f2 = 1.8F;
      float f1 = f2;
      if (this.jsq != 0)
      {
        f1 = f2;
        if (this.jsr != 0) {
          f1 = this.jsr / this.jsq;
        }
      }
      if ((f3 <= f1) || (f3 > 2.2D)) {
        break label233;
      }
    }
    label215:
    label221:
    label227:
    label233:
    for (this.uZQ = this.uZZ;; this.uZQ = this.uZY)
    {
      setScaleRate(this.uZQ);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      bool1 = false;
      break label104;
      bool1 = false;
      break label130;
    }
  }
  
  private void l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = (paramFloat1 - getScale()) / 128.0F;
    float f = getScale();
    long l = System.currentTimeMillis();
    this.mHandler.post(new WxImageView.1(this, l, f, paramFloat1, paramFloat2, paramFloat3));
  }
  
  public final void ac(float paramFloat1, float paramFloat2)
  {
    cBk();
    l(this.uZQ, paramFloat1, paramFloat2);
  }
  
  public final void ad(float paramFloat1, float paramFloat2)
  {
    this.uZN = getDoubleTabScale();
    l(this.uZN, paramFloat1, paramFloat2);
  }
  
  public final void ae(float paramFloat1, float paramFloat2)
  {
    y.d("MicroMsg.WxImageView", "alvinluo WxImageView postTranslate dx: %f, dy: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.aqz.postTranslate(paramFloat1, paramFloat2);
  }
  
  public final boolean cAw()
  {
    return this.uZW;
  }
  
  public final boolean cAx()
  {
    return this.uZX;
  }
  
  public final void cAy()
  {
    y.d("MicroMsg.WxImageView", "alvinluo adaptViewSize");
    this.aqz.reset();
    cBk();
    if (this.dDM != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.dDM;
      localSubsamplingScaleImageView.a(localSubsamplingScaleImageView.aqJ, new PointF(0.0F, 0.0F));
    }
    k(this.uZQ, 0.0F, 0.0F);
  }
  
  public final void cAz()
  {
    if ((this.uZV) && (0.0F == this.uZN)) {
      this.uZN = getDoubleTabScale();
    }
  }
  
  public int getContentLeft()
  {
    if (!this.isInited) {
      return 0;
    }
    float f1 = this.uZQ;
    float f2 = this.imageWidth;
    int j = (int)((this.jsq - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    y.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageWidth: %d, viewWidth: %d, left: %d", new Object[] { Float.valueOf(this.uZQ), Integer.valueOf(this.imageWidth), Integer.valueOf(this.jsq), Integer.valueOf(i) });
    return i;
  }
  
  public int getContentTop()
  {
    if (!this.isInited) {
      return 0;
    }
    float f1 = this.uZQ;
    float f2 = getImageHeight();
    int j = (int)((this.jsr - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    y.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageHeight: %d, viewHeight: %d, top: %d", new Object[] { Float.valueOf(this.uZQ), Integer.valueOf(getImageHeight()), Integer.valueOf(this.jsr), Integer.valueOf(i) });
    return i;
  }
  
  public float getDoubleTabScale()
  {
    float f1 = getScaleRate();
    if (getScaleWidth() * 0.7F > f1) {
      f1 = getScaleWidth();
    }
    for (;;)
    {
      float f2 = f1;
      if (f1 < 1.0D) {
        f2 = 1.0F;
      }
      f1 = f2;
      if (f2 > getMaxZoom()) {
        f1 = getMaxZoom();
      }
      return f1;
      if (getScaleHeight() * 0.7F > f1) {
        f1 = getScaleHeight();
      } else {
        f1 = getScaleRate() * this.uZS;
      }
    }
  }
  
  public int getImageHeight()
  {
    if ((this.orientation == 90) || (this.orientation == 270)) {
      return this.imageWidth;
    }
    return this.imageHeight;
  }
  
  public Matrix getImageMatrix()
  {
    this.uZK.set(this.uZJ);
    this.uZK.postConcat(this.aqz);
    return this.uZK;
  }
  
  protected Matrix getImageViewMatrix()
  {
    this.uZK.set(this.uZJ);
    this.uZK.postConcat(this.aqz);
    return this.uZK;
  }
  
  public int getImageWidth()
  {
    if ((this.orientation == 90) || (this.orientation == 270)) {
      return this.imageHeight;
    }
    return this.imageWidth;
  }
  
  public float getMaxZoom()
  {
    return this.uZO;
  }
  
  public float getMinZoom()
  {
    return this.uZP;
  }
  
  public float getScale()
  {
    return super.getScale();
  }
  
  public float getScaleHeight()
  {
    return this.uZZ;
  }
  
  public float getScaleRate()
  {
    return this.uZQ;
  }
  
  public float getScaleWidth()
  {
    return this.uZY;
  }
  
  public final void k(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int j = 1;
    float f3 = getScale();
    float f1;
    label72:
    float f2;
    int i;
    label173:
    label180:
    RectF localRectF;
    if (this.uZV)
    {
      if (0.0F == this.uZN)
      {
        f1 = this.uZU * this.aqM;
        this.uZO = f1;
      }
    }
    else
    {
      if (paramFloat1 <= this.uZO * 2.0F) {
        break label365;
      }
      f1 = this.uZO * 2.0F + (paramFloat1 - this.uZO) * 0.1F;
      f2 = f1 / f3;
      y.d("MicroMsg.WxImageView", "alvinluo zoomTo mzdt=%f,mz=%f,scale=%f,oldScale=%f,deltaScale=%f", new Object[] { Float.valueOf(this.uZN), Float.valueOf(this.uZO), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f2) });
      if (!this.vab) {
        this.aqz.postScale(f2, f2, paramFloat2, paramFloat3);
      }
      if ((this.oYK) && (this.uZW)) {
        break label386;
      }
      i = 1;
      if (this.uZX) {
        break label392;
      }
      if ((this.vac != null) || (!this.vab))
      {
        Matrix localMatrix = getImageViewMatrix();
        if (!this.vab) {
          break label398;
        }
        localRectF = new RectF(0.0F, 0.0F, this.vac.getIntrinsicWidth(), this.vac.getIntrinsicHeight());
        label234:
        localMatrix.mapRect(localRectF);
        paramFloat1 = localRectF.height();
        paramFloat2 = localRectF.width();
        if (j == 0) {
          break label471;
        }
        if (paramFloat1 >= this.jsr) {
          break label422;
        }
        paramFloat1 = (this.jsr - paramFloat1) / 2.0F - localRectF.top;
      }
    }
    for (;;)
    {
      label285:
      if (i != 0) {
        if (paramFloat2 < this.jsq) {
          paramFloat2 = (this.jsq - paramFloat2) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        label316:
        ae(paramFloat2, paramFloat1);
        getImageViewMatrix().mapRect(localRectF);
        if (this.oZh != null)
        {
          if (f2 <= 1.0F) {
            break label618;
          }
          this.oZh.bIV();
        }
        label365:
        while (f2 >= 1.0F)
        {
          return;
          f1 = this.uZN;
          break;
          f1 = paramFloat1;
          if (paramFloat1 >= this.uZP) {
            break label72;
          }
          f1 = this.uZP;
          break label72;
          i = 0;
          break label173;
          j = 0;
          break label180;
          localRectF = new RectF(0.0F, 0.0F, this.imageWidth, this.imageHeight);
          break label234;
          if (localRectF.top > 0.0F)
          {
            paramFloat1 = -localRectF.top;
            break label285;
          }
          if (localRectF.bottom >= this.jsr) {
            break label640;
          }
          paramFloat1 = this.jsr - localRectF.bottom;
          break label285;
          if (localRectF.top > 0.0F)
          {
            paramFloat1 = -localRectF.top;
            break label285;
          }
          if (localRectF.bottom >= this.jsr) {
            break label640;
          }
          paramFloat1 = this.jsr - localRectF.bottom;
          break label285;
          if (localRectF.left > 0.0F)
          {
            paramFloat2 = -localRectF.left;
            break label316;
          }
          if (localRectF.right >= this.jsq) {
            break label635;
          }
          paramFloat2 = this.jsq - localRectF.right;
          break label316;
          if (localRectF.left > 0.0F)
          {
            paramFloat2 = -localRectF.left;
            break label316;
          }
          if (localRectF.right >= this.jsq) {
            break label635;
          }
          paramFloat2 = this.jsq - localRectF.right;
          break label316;
        }
        label386:
        label392:
        label398:
        label422:
        label471:
        label618:
        this.oZh.bIU();
        return;
        label635:
        paramFloat2 = 0.0F;
      }
      label640:
      paramFloat1 = 0.0F;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.isInited = false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      f.c(paramKeyEvent);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (f.d(paramKeyEvent)) && (!f.e(paramKeyEvent)) && (getScale() > 1.0F))
    {
      k(1.0F, this.jsq / 2.0F, this.jsr / 2.0F);
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.jsq != View.MeasureSpec.getSize(paramInt1)) || (this.jsr != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.uZR = true;; this.uZR = false)
    {
      this.jsq = View.MeasureSpec.getSize(paramInt1);
      this.jsr = View.MeasureSpec.getSize(paramInt2);
      y.d("MicroMsg.WxImageView", "alvinluo onMeasure viewWidth: %d, viewHeight: %d", new Object[] { Integer.valueOf(this.jsq), Integer.valueOf(this.jsr) });
      if (!this.isInited)
      {
        this.isInited = true;
        this.vab = false;
        y.d("MicroMsg.WxImageView", "init screenWidth:" + this.jsq + " screenHeight :" + this.jsr);
        float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
        if (f > 1.0F) {
          this.aqM = f;
        }
        cAy();
      }
      if (this.uZR) {
        cAy();
      }
      return;
    }
  }
  
  public void setDoubleTabScaleLimit(float paramFloat)
  {
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      y.w("MicroMsg.WxImageView", "double tab scale limit is less than 0.0, change nothing, return");
      return;
    }
    this.uZS = paramFloat;
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.oYK = paramBoolean;
  }
  
  public void setImageHeight(int paramInt)
  {
    this.imageHeight = paramInt;
  }
  
  public void setImageWidth(int paramInt)
  {
    this.imageWidth = paramInt;
  }
  
  public void setMaxZoomDoubleTab(boolean paramBoolean)
  {
    this.uZV = paramBoolean;
  }
  
  public void setMaxZoomLimit(float paramFloat)
  {
    if (Float.compare(paramFloat, 1.0F) < 0)
    {
      y.w("MicroMsg.WxImageView", "max scale limit is less than 1.0, change nothing, return");
      return;
    }
    this.uZU = paramFloat;
  }
  
  public void setMinZoomLimit(float paramFloat)
  {
    if (Float.compare(paramFloat, 1.0F) > 0)
    {
      y.w("MicroMsg.WxImageView", "min scale limit is greater than 1.0, change nothing, return");
      return;
    }
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      y.w("MicroMsg.WxImageView", "min scale limit is less than 0.0, change nothing, return");
      return;
    }
    this.uZT = paramFloat;
  }
  
  public void setOrientation(int paramInt)
  {
    this.orientation = paramInt;
    cBk();
  }
  
  public final void translate(float paramFloat1, float paramFloat2)
  {
    float f1 = getTranslationX();
    float f2 = getTranslationY();
    setTranslationX(f1 + paramFloat1);
    setTranslationY(f2 + paramFloat2);
    y.i("MicroMsg.WxImageView", "alvinluo translate x: %f, y: %f, x + dx: %f, y + dy: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f1 + paramFloat1), Float.valueOf(f2 + paramFloat2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.WxImageView
 * JD-Core Version:    0.7.0.1
 */