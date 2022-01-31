package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.b.a;
import com.tencent.mm.ui.e.b.c;

public class MultiTouchImageView
  extends ImageView
  implements g
{
  private float aqM = 1.0F;
  protected Matrix aqz = new Matrix();
  private int imageHeight;
  private int imageWidth;
  private boolean isInited = false;
  private int jsq;
  private int jsr;
  protected ah mHandler = new ah();
  protected Bitmap oJZ = null;
  private boolean oYK = true;
  private MultiTouchImageView.a oZh;
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
  public boolean uZW = false;
  public boolean uZX = false;
  private float uZY;
  private float uZZ;
  float vaa = 0.0F;
  public boolean vab = false;
  public Drawable vac;
  
  public MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, paramInt1, paramInt2, null);
  }
  
  public MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2, MultiTouchImageView.a parama)
  {
    super(paramContext);
    this.imageHeight = paramInt2;
    this.imageWidth = paramInt1;
    this.oZh = parama;
    init();
  }
  
  public MultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private MultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(paramContext, paramAttributeSet);
    this.imageHeight = 0;
    this.imageWidth = 0;
    init();
  }
  
  private void Y(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    if ((this.oJZ == null) && (!this.vab)) {}
    while ((this.vac == null) && (this.vab)) {
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f4;
    if (this.vab)
    {
      localRectF = new RectF(0.0F, 0.0F, this.vac.getIntrinsicWidth(), this.vac.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f4 = localRectF.width();
      if (!paramBoolean2) {
        break label275;
      }
      if (f1 >= this.jsr) {
        break label226;
      }
      f1 = (this.jsr - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label123:
      if (paramBoolean1) {
        if (f4 < this.jsq) {
          f2 = (this.jsq - f4) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        ae(f2, f1);
        localMatrix = getImageViewMatrix();
        setImageMatrix(localMatrix);
        localMatrix.mapRect(localRectF);
        localRectF.height();
        localRectF.width();
        return;
        localRectF = new RectF(0.0F, 0.0F, this.oJZ.getWidth(), this.oJZ.getHeight());
        break;
        label226:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label123;
        }
        if (localRectF.bottom >= this.jsr) {
          break label498;
        }
        f1 = this.jsr - localRectF.bottom;
        break label123;
        label275:
        f1 = localRectF.top;
        float f5 = this.jsr - localRectF.bottom;
        float f3 = (f1 + f5) / 2.0F;
        f1 = f3;
        if (f3 < 0.0F) {
          f1 = 0.0F;
        }
        if (localRectF.top > 0.0F)
        {
          f1 -= localRectF.top;
          break label123;
        }
        if (localRectF.bottom >= this.jsr) {
          break label498;
        }
        f1 = f5 - f1;
        break label123;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.jsq)
        {
          f2 = this.jsq - localRectF.right;
          continue;
          f3 = localRectF.left;
          f5 = this.jsq - localRectF.right;
          f4 = (f3 + f5) / 2.0F;
          f3 = f4;
          if (f4 < 0.0F) {
            f3 = 0.0F;
          }
          if (localRectF.left > 0.0F) {
            f2 = f3 - localRectF.left;
          } else if (localRectF.right < this.jsq) {
            f2 = f5 - f3;
          }
        }
      }
      label498:
      f1 = 0.0F;
    }
  }
  
  private void cBk()
  {
    boolean bool2 = true;
    this.uZY = (this.jsq / this.imageWidth);
    this.uZZ = (this.jsr / this.imageHeight);
    if (this.imageWidth > this.imageHeight * 2.2F)
    {
      bool1 = true;
      this.uZW = bool1;
      if (this.imageHeight <= this.imageWidth * 2.2F) {
        break label215;
      }
      bool1 = true;
      label79:
      this.uZX = bool1;
      if ((!this.uZW) || (this.imageWidth <= this.jsq)) {
        break label221;
      }
      bool1 = true;
      label106:
      this.uZW = bool1;
      if ((!this.uZX) || (this.imageHeight <= this.jsr)) {
        break label227;
      }
    }
    label215:
    label221:
    label227:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.uZX = bool1;
      float f3 = this.imageHeight / this.imageWidth;
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
      this.uZQ = this.uZZ;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      bool1 = false;
      break label106;
    }
    label233:
    this.uZQ = this.uZY;
  }
  
  private void init()
  {
    y.d("dktest", "init screenWidth:" + this.jsq + " screenHeight :" + this.jsr);
    setScaleType(ImageView.ScaleType.MATRIX);
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.aqM = f;
    }
    cAy();
  }
  
  private void l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = (paramFloat1 - getScale()) / 128.0F;
    float f = getScale();
    long l = System.currentTimeMillis();
    this.mHandler.post(new MultiTouchImageView.1(this, l, f, paramFloat1, paramFloat2, paramFloat3));
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
    this.aqz.postTranslate(paramFloat1, paramFloat2);
    setImageMatrix(getImageViewMatrix());
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
    this.aqz.reset();
    cBk();
    k(this.uZQ, 0.0F, 0.0F);
  }
  
  public final void cAz()
  {
    if ((this.uZV) && (0.0F == this.uZN)) {
      this.uZN = getDoubleTabScale();
    }
  }
  
  public final void cBl()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!this.oYK) || (!this.uZW))
    {
      bool1 = true;
      if (this.uZX) {
        break label37;
      }
    }
    for (;;)
    {
      Y(bool1, bool2);
      return;
      bool1 = false;
      break;
      label37:
      bool2 = false;
    }
  }
  
  public final void fs(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public final void ft(int paramInt1, int paramInt2)
  {
    this.jsr = paramInt2;
    this.jsq = paramInt1;
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
    return this.imageHeight;
  }
  
  protected Matrix getImageViewMatrix()
  {
    this.uZK.set(this.uZJ);
    this.uZK.postConcat(this.aqz);
    return this.uZK;
  }
  
  public int getImageWidth()
  {
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
  
  public float getRealWidth()
  {
    return getScale() * getImageWidth();
  }
  
  public float getScale()
  {
    this.aqz.getValues(this.tz);
    cBk();
    this.uZO = (this.uZU * this.aqM);
    this.uZP = (this.uZQ * this.uZT);
    if (this.uZO < 1.0F) {
      this.uZO = 1.0F;
    }
    if (this.uZP > 1.0F) {
      this.uZP = 1.0F;
    }
    return this.tz[0];
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
    boolean bool2 = true;
    float f2 = getScale();
    float f1;
    label72:
    boolean bool1;
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
        break label169;
      }
      f1 = this.uZO * 2.0F + (paramFloat1 - this.uZO) * 0.1F;
      paramFloat1 = f1 / f2;
      if (!this.vab)
      {
        setImageMatrix(getImageViewMatrix());
        this.aqz.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      if ((this.oYK) && (this.uZW)) {
        break label190;
      }
      bool1 = true;
      label122:
      if (this.uZX) {
        break label196;
      }
      label129:
      Y(bool1, bool2);
      if (this.oZh != null)
      {
        if (paramFloat1 <= 1.0F) {
          break label202;
        }
        this.oZh.bIV();
      }
    }
    label169:
    label190:
    label196:
    label202:
    while (paramFloat1 >= 1.0F)
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
      bool1 = false;
      break label122;
      bool2 = false;
      break label129;
    }
    this.oZh.bIU();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.isInited = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((!this.vab) && (this.oJZ != null) && (this.oJZ.isRecycled()))
    {
      y.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
      return;
    }
    super.onDraw(paramCanvas);
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
      if (!this.isInited)
      {
        this.isInited = true;
        init();
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
      y.w("MicroMsg.MultiTouchImageView", "double tab scale limit is less than 0.0, change nothing, return");
      return;
    }
    this.uZS = paramFloat;
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.oYK = paramBoolean;
  }
  
  public void setGifDrawable(Drawable paramDrawable)
  {
    this.vab = true;
    this.vac = paramDrawable;
    setImageDrawable(this.vac);
  }
  
  public void setGifPath(String paramString)
  {
    this.vab = true;
    try
    {
      this.vac = c.gy(paramString, paramString);
      setImageDrawable(this.vac);
      if (this.vac != null) {
        fs(this.vac.getIntrinsicWidth(), this.vac.getIntrinsicHeight());
      }
      return;
    }
    catch (Exception paramString)
    {
      this.vab = false;
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.vab = false;
    this.oJZ = paramBitmap;
    this.isInited = false;
    super.setImageBitmap(paramBitmap);
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
      y.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
      return;
    }
    this.uZU = paramFloat;
  }
  
  public void setMinZoomLimit(float paramFloat)
  {
    if (Float.compare(paramFloat, 1.0F) > 0)
    {
      y.w("MicroMsg.MultiTouchImageView", "min scale limit is greater than 1.0, change nothing, return");
      return;
    }
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      y.w("MicroMsg.MultiTouchImageView", "min scale limit is less than 0.0, change nothing, return");
      return;
    }
    this.uZT = paramFloat;
  }
  
  public final void start()
  {
    if ((this.vab) && (this.vac != null)) {
      ((a)this.vac).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */