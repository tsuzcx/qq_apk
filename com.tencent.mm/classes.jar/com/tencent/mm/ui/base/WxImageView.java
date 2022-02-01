package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.ui.WxBaseImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public class WxImageView
  extends WxBaseImageView
  implements g
{
  private final float[] Ba;
  private final Matrix GbA;
  int GbB;
  int GbC;
  private float GbD;
  private float GbE;
  private float GbF;
  private float GbG;
  private float GbH;
  private float GbI;
  private boolean GbK;
  private boolean GbL;
  private boolean GbM;
  private float GbN;
  private float GbO;
  private boolean GbR;
  private Drawable GbS;
  protected Matrix Gbz;
  protected Matrix aNC;
  private float aNP;
  private boolean dvt;
  private int fIN;
  private int fIO;
  private boolean hBC;
  private float jMh;
  protected ap mHandler;
  private int orientation;
  protected Bitmap xfE;
  private boolean xzx;
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142468);
    this.Gbz = new Matrix();
    this.aNC = new Matrix();
    this.GbA = new Matrix();
    this.Ba = new float[9];
    this.xfE = null;
    this.GbB = -1;
    this.GbC = -1;
    this.GbD = 0.0F;
    this.jMh = 0.0F;
    this.GbE = 0.0F;
    this.hBC = false;
    this.dvt = false;
    this.GbG = 2.0F;
    this.GbH = 0.75F;
    this.GbI = 20.0F;
    this.GbK = false;
    this.GbL = false;
    this.GbM = false;
    this.xzx = true;
    this.GbR = false;
    this.mHandler = new ap();
    this.aNP = 1.0F;
    AppMethodBeat.o(142468);
  }
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142469);
    this.Gbz = new Matrix();
    this.aNC = new Matrix();
    this.GbA = new Matrix();
    this.Ba = new float[9];
    this.xfE = null;
    this.GbB = -1;
    this.GbC = -1;
    this.GbD = 0.0F;
    this.jMh = 0.0F;
    this.GbE = 0.0F;
    this.hBC = false;
    this.dvt = false;
    this.GbG = 2.0F;
    this.GbH = 0.75F;
    this.GbI = 20.0F;
    this.GbK = false;
    this.GbL = false;
    this.GbM = false;
    this.xzx = true;
    this.GbR = false;
    this.mHandler = new ap();
    this.aNP = 1.0F;
    AppMethodBeat.o(142469);
  }
  
  private void aJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(142482);
    if ((this.GbS == null) && (this.GbR))
    {
      AppMethodBeat.o(142482);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f3;
    if (this.GbR)
    {
      localRectF = new RectF(0.0F, 0.0F, this.GbS.getIntrinsicWidth(), this.GbS.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f3 = localRectF.width();
      if (!paramBoolean2) {
        break label248;
      }
      if (f1 >= this.fIO) {
        break label199;
      }
      f1 = (this.fIO - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label119:
      if (paramBoolean1) {
        if (f3 < this.fIN) {
          f2 = (this.fIN - f3) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        ag(f2, f1);
        getImageViewMatrix().mapRect(localRectF);
        AppMethodBeat.o(142482);
        return;
        localRectF = new RectF(0.0F, 0.0F, this.imageWidth, this.imageHeight);
        break;
        label199:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label119;
        }
        if (localRectF.bottom >= this.fIO) {
          break label399;
        }
        f1 = this.fIO - localRectF.bottom;
        break label119;
        label248:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label119;
        }
        if (localRectF.bottom >= this.fIO) {
          break label399;
        }
        f1 = this.fIO - localRectF.bottom;
        break label119;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.fIN)
        {
          f2 = this.fIN - localRectF.right;
          continue;
          if (localRectF.left > 0.0F) {
            f2 = -localRectF.left;
          } else if (localRectF.right < this.fIN) {
            f2 = this.fIN - localRectF.right;
          }
        }
      }
      label399:
      f1 = 0.0F;
    }
  }
  
  private void eTp()
  {
    boolean bool2 = true;
    AppMethodBeat.i(142479);
    int i = getImageWidth();
    int j = getImageHeight();
    this.GbN = (this.fIN / i);
    this.GbO = (this.fIO / j);
    boolean bool1;
    if (i > j * 2.2F)
    {
      bool1 = true;
      this.GbL = bool1;
      if (j <= i * 2.2F) {
        break label225;
      }
      bool1 = true;
      label84:
      this.GbM = bool1;
      if ((!this.GbL) || (i <= this.fIN)) {
        break label231;
      }
      bool1 = true;
      label109:
      this.GbL = bool1;
      if ((!this.GbM) || (j <= this.fIO)) {
        break label237;
      }
      bool1 = bool2;
      label135:
      this.GbM = bool1;
      float f3 = j / i;
      float f2 = 1.8F;
      float f1 = f2;
      if (this.fIN != 0)
      {
        f1 = f2;
        if (this.fIO != 0) {
          f1 = this.fIO / this.fIN;
        }
      }
      if ((f3 <= f1) || (f3 > 2.2D)) {
        break label243;
      }
    }
    label225:
    label231:
    label237:
    label243:
    for (this.GbF = this.GbO;; this.GbF = this.GbN)
    {
      setScaleRate(this.GbF);
      AppMethodBeat.o(142479);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label84;
      bool1 = false;
      break label109;
      bool1 = false;
      break label135;
    }
  }
  
  private void n(final float paramFloat1, final float paramFloat2, final float paramFloat3)
  {
    AppMethodBeat.i(142489);
    paramFloat1 = (paramFloat1 - getScale()) / 128.0F;
    float f = getScale();
    final long l = System.currentTimeMillis();
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142467);
        long l = System.currentTimeMillis();
        float f1 = Math.min(this.GbT, (float)(l - l));
        float f2 = paramFloat1;
        float f3 = paramFloat2;
        WxImageView.this.m(f2 + f3 * f1, paramFloat3, this.cSy);
        if (f1 < this.GbT) {
          WxImageView.this.mHandler.post(this);
        }
        AppMethodBeat.o(142467);
      }
    });
    AppMethodBeat.o(142489);
  }
  
  public final void ae(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142477);
    eTp();
    n(this.GbF, paramFloat1, paramFloat2);
    AppMethodBeat.o(142477);
  }
  
  public final void af(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142488);
    this.GbD = getDoubleTabScale();
    n(this.GbD, paramFloat1, paramFloat2);
    AppMethodBeat.o(142488);
  }
  
  public final void ag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142490);
    ad.d("MicroMsg.WxImageView", "alvinluo WxImageView postTranslate dx: %f, dy: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.aNC.postTranslate(paramFloat1, paramFloat2);
    AppMethodBeat.o(142490);
  }
  
  public final void eSA()
  {
    boolean bool2 = true;
    AppMethodBeat.i(164159);
    boolean bool1;
    if ((!this.xzx) || (!this.GbL))
    {
      bool1 = true;
      if (this.GbM) {
        break label49;
      }
    }
    for (;;)
    {
      aJ(bool1, bool2);
      AppMethodBeat.o(164159);
      return;
      bool1 = false;
      break;
      label49:
      bool2 = false;
    }
  }
  
  public final void eSB()
  {
    AppMethodBeat.i(142485);
    if ((this.GbK) && (0.0F == this.GbD)) {
      this.GbD = getDoubleTabScale();
    }
    AppMethodBeat.o(142485);
  }
  
  public final boolean eSx()
  {
    return this.GbL;
  }
  
  public final boolean eSy()
  {
    return this.GbM;
  }
  
  public final void eSz()
  {
    AppMethodBeat.i(142476);
    ad.d("MicroMsg.WxImageView", "alvinluo adaptViewSize");
    this.aNC.reset();
    eTp();
    adg();
    m(this.GbF, 0.0F, 0.0F);
    AppMethodBeat.o(142476);
  }
  
  public int getContentLeft()
  {
    AppMethodBeat.i(142475);
    if (!this.hBC)
    {
      AppMethodBeat.o(142475);
      return 0;
    }
    float f1 = this.GbF;
    float f2 = this.imageWidth;
    int j = (int)((this.fIN - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ad.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageWidth: %d, viewWidth: %d, left: %d", new Object[] { Float.valueOf(this.GbF), Integer.valueOf(this.imageWidth), Integer.valueOf(this.fIN), Integer.valueOf(i) });
    AppMethodBeat.o(142475);
    return i;
  }
  
  public int getContentTop()
  {
    AppMethodBeat.i(142474);
    if (!this.hBC)
    {
      AppMethodBeat.o(142474);
      return 0;
    }
    float f1 = this.GbF;
    float f2 = getImageHeight();
    int j = (int)((this.fIO - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ad.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageHeight: %d, viewHeight: %d, top: %d", new Object[] { Float.valueOf(this.GbF), Integer.valueOf(getImageHeight()), Integer.valueOf(this.fIO), Integer.valueOf(i) });
    AppMethodBeat.o(142474);
    return i;
  }
  
  public float getDoubleTabScale()
  {
    AppMethodBeat.i(142487);
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
      AppMethodBeat.o(142487);
      return f1;
      if (getScaleHeight() * 0.7F > f1) {
        f1 = getScaleHeight();
      } else {
        f1 = getScaleRate() * this.GbG;
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
    AppMethodBeat.i(142492);
    this.GbA.set(this.Gbz);
    this.GbA.postConcat(this.aNC);
    Matrix localMatrix = this.GbA;
    AppMethodBeat.o(142492);
    return localMatrix;
  }
  
  protected Matrix getImageViewMatrix()
  {
    AppMethodBeat.i(142484);
    this.GbA.set(this.Gbz);
    this.GbA.postConcat(this.aNC);
    Matrix localMatrix = this.GbA;
    AppMethodBeat.o(142484);
    return localMatrix;
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
    return this.jMh;
  }
  
  public float getMinZoom()
  {
    return this.GbE;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(142483);
    float f = super.getScale();
    AppMethodBeat.o(142483);
    return f;
  }
  
  public float getScaleHeight()
  {
    return this.GbO;
  }
  
  public float getScaleRate()
  {
    return this.GbF;
  }
  
  public float getScaleWidth()
  {
    return this.GbN;
  }
  
  public final void m(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(142486);
    float f2 = getScale();
    float f1;
    label78:
    boolean bool1;
    if (this.GbK)
    {
      if (0.0F == this.GbD)
      {
        f1 = this.GbI * this.aNP;
        this.jMh = f1;
      }
    }
    else
    {
      if (paramFloat1 <= this.jMh * 2.0F) {
        break label206;
      }
      f1 = this.jMh * 2.0F + (paramFloat1 - this.jMh) * 0.1F;
      paramFloat1 = f1 / f2;
      ad.d("MicroMsg.WxImageView", "alvinluo zoomTo mzdt=%f,mz=%f,scale=%f,oldScale=%f,deltaScale=%f", new Object[] { Float.valueOf(this.GbD), Float.valueOf(this.jMh), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramFloat1) });
      if (!this.GbR) {
        this.aNC.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      if ((this.xzx) && (this.GbL)) {
        break label227;
      }
      bool1 = true;
      label175:
      if (this.GbM) {
        break label233;
      }
    }
    for (;;)
    {
      aJ(bool1, bool2);
      AppMethodBeat.o(142486);
      return;
      f1 = this.GbD;
      break;
      label206:
      f1 = paramFloat1;
      if (paramFloat1 >= this.GbE) {
        break label78;
      }
      f1 = this.GbE;
      break label78;
      label227:
      bool1 = false;
      break label175;
      label233:
      bool2 = false;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.hBC = false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(142480);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      f.e(paramKeyEvent);
      AppMethodBeat.o(142480);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(142480);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(142481);
    if ((paramInt == 4) && (f.f(paramKeyEvent)) && (!f.g(paramKeyEvent)) && (getScale() > 1.0F))
    {
      m(1.0F, this.fIN / 2.0F, this.fIO / 2.0F);
      AppMethodBeat.o(142481);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(142481);
    return bool;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142473);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.fIN != View.MeasureSpec.getSize(paramInt1)) || (this.fIO != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.dvt = true;; this.dvt = false)
    {
      this.fIN = View.MeasureSpec.getSize(paramInt1);
      this.fIO = View.MeasureSpec.getSize(paramInt2);
      ad.d("MicroMsg.WxImageView", "alvinluo onMeasure viewWidth: %d, viewHeight: %d", new Object[] { Integer.valueOf(this.fIN), Integer.valueOf(this.fIO) });
      if (!this.hBC)
      {
        this.hBC = true;
        this.GbR = false;
        ad.d("MicroMsg.WxImageView", "init screenWidth:" + this.fIN + " screenHeight :" + this.fIO);
        float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
        if (f > 1.0F) {
          this.aNP = f;
        }
        eSz();
      }
      if (this.dvt) {
        eSz();
      }
      AppMethodBeat.o(142473);
      return;
    }
  }
  
  public void setDoubleTabScaleLimit(float paramFloat)
  {
    AppMethodBeat.i(142472);
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      ad.w("MicroMsg.WxImageView", "double tab scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142472);
      return;
    }
    this.GbG = paramFloat;
    AppMethodBeat.o(142472);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.xzx = paramBoolean;
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
    this.GbK = paramBoolean;
  }
  
  public void setMaxZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(142470);
    if (Float.compare(paramFloat, 1.0F) < 0)
    {
      ad.w("MicroMsg.WxImageView", "max scale limit is less than 1.0, change nothing, return");
      AppMethodBeat.o(142470);
      return;
    }
    this.GbI = paramFloat;
    AppMethodBeat.o(142470);
  }
  
  public void setMinZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(142471);
    if (Float.compare(paramFloat, 1.0F) > 0)
    {
      ad.w("MicroMsg.WxImageView", "min scale limit is greater than 1.0, change nothing, return");
      AppMethodBeat.o(142471);
      return;
    }
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      ad.w("MicroMsg.WxImageView", "min scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142471);
      return;
    }
    this.GbH = paramFloat;
    AppMethodBeat.o(142471);
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(142478);
    this.orientation = paramInt;
    eTp();
    AppMethodBeat.o(142478);
  }
  
  public final void translate(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142491);
    float f1 = getTranslationX();
    float f2 = getTranslationY();
    setTranslationX(f1 + paramFloat1);
    setTranslationY(f2 + paramFloat2);
    ad.i("MicroMsg.WxImageView", "alvinluo translate x: %f, y: %f, x + dx: %f, y + dy: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f1 + paramFloat1), Float.valueOf(f2 + paramFloat2) });
    AppMethodBeat.o(142491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.WxImageView
 * JD-Core Version:    0.7.0.1
 */