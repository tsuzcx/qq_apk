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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.ui.WxBaseImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public class WxImageView
  extends WxBaseImageView
  implements g
{
  private boolean AdH;
  private final float[] DQ;
  protected Matrix Jpf;
  private final Matrix Jpg;
  int Jph;
  int Jpi;
  private float Jpj;
  private float Jpk;
  private float Jpl;
  private float Jpm;
  private float Jpn;
  private float Jpo;
  private boolean Jpq;
  private float Jpr;
  private float Jps;
  private boolean Jpv;
  private Drawable Jpw;
  private boolean aXA;
  private boolean aXB;
  protected Matrix aYM;
  private float aYZ;
  private boolean dFh;
  private int gfT;
  private int gfU;
  private boolean ivz;
  private float kHI;
  protected ap mHandler;
  private int orientation;
  protected Bitmap zJA;
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142468);
    this.Jpf = new Matrix();
    this.aYM = new Matrix();
    this.Jpg = new Matrix();
    this.DQ = new float[9];
    this.zJA = null;
    this.Jph = -1;
    this.Jpi = -1;
    this.Jpj = 0.0F;
    this.kHI = 0.0F;
    this.Jpk = 0.0F;
    this.ivz = false;
    this.dFh = false;
    this.Jpm = 2.0F;
    this.Jpn = 0.75F;
    this.Jpo = 20.0F;
    this.Jpq = false;
    this.aXB = false;
    this.aXA = false;
    this.AdH = true;
    this.Jpv = false;
    this.mHandler = new ap();
    this.aYZ = 1.0F;
    AppMethodBeat.o(142468);
  }
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142469);
    this.Jpf = new Matrix();
    this.aYM = new Matrix();
    this.Jpg = new Matrix();
    this.DQ = new float[9];
    this.zJA = null;
    this.Jph = -1;
    this.Jpi = -1;
    this.Jpj = 0.0F;
    this.kHI = 0.0F;
    this.Jpk = 0.0F;
    this.ivz = false;
    this.dFh = false;
    this.Jpm = 2.0F;
    this.Jpn = 0.75F;
    this.Jpo = 20.0F;
    this.Jpq = false;
    this.aXB = false;
    this.aXA = false;
    this.AdH = true;
    this.Jpv = false;
    this.mHandler = new ap();
    this.aYZ = 1.0F;
    AppMethodBeat.o(142469);
  }
  
  private void aV(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(142482);
    if ((this.Jpw == null) && (this.Jpv))
    {
      AppMethodBeat.o(142482);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f3;
    if (this.Jpv)
    {
      localRectF = new RectF(0.0F, 0.0F, this.Jpw.getIntrinsicWidth(), this.Jpw.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f3 = localRectF.width();
      if (!paramBoolean2) {
        break label248;
      }
      if (f1 >= this.gfU) {
        break label199;
      }
      f1 = (this.gfU - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label119:
      if (paramBoolean1) {
        if (f3 < this.gfT) {
          f2 = (this.gfT - f3) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        ao(f2, f1);
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
        if (localRectF.bottom >= this.gfU) {
          break label399;
        }
        f1 = this.gfU - localRectF.bottom;
        break label119;
        label248:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label119;
        }
        if (localRectF.bottom >= this.gfU) {
          break label399;
        }
        f1 = this.gfU - localRectF.bottom;
        break label119;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.gfT)
        {
          f2 = this.gfT - localRectF.right;
          continue;
          if (localRectF.left > 0.0F) {
            f2 = -localRectF.left;
          } else if (localRectF.right < this.gfT) {
            f2 = this.gfT - localRectF.right;
          }
        }
      }
      label399:
      f1 = 0.0F;
    }
  }
  
  private void fzp()
  {
    boolean bool2 = true;
    AppMethodBeat.i(142479);
    int i = getImageWidth();
    int j = getImageHeight();
    this.Jpr = (this.gfT / i);
    this.Jps = (this.gfU / j);
    boolean bool1;
    if (i > j * 2.2F)
    {
      bool1 = true;
      this.aXB = bool1;
      if (j <= i * 2.2F) {
        break label225;
      }
      bool1 = true;
      label84:
      this.aXA = bool1;
      if ((!this.aXB) || (i <= this.gfT)) {
        break label231;
      }
      bool1 = true;
      label109:
      this.aXB = bool1;
      if ((!this.aXA) || (j <= this.gfU)) {
        break label237;
      }
      bool1 = bool2;
      label135:
      this.aXA = bool1;
      float f3 = j / i;
      float f2 = 1.8F;
      float f1 = f2;
      if (this.gfT != 0)
      {
        f1 = f2;
        if (this.gfU != 0) {
          f1 = this.gfU / this.gfT;
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
    for (this.Jpl = this.Jps;; this.Jpl = this.Jpr)
    {
      setScaleRate(this.Jpl);
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
  
  private void p(final float paramFloat1, final float paramFloat2, final float paramFloat3)
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
        float f1 = Math.min(this.Jpx, (float)(l - l));
        float f2 = paramFloat1;
        float f3 = paramFloat2;
        WxImageView.this.o(f2 + f3 * f1, paramFloat3, this.dbl);
        if (f1 < this.Jpx) {
          WxImageView.this.mHandler.post(this);
        }
        AppMethodBeat.o(142467);
      }
    });
    AppMethodBeat.o(142489);
  }
  
  public final PointF a(PointF paramPointF, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186485);
    if (paramPointF == null)
    {
      AppMethodBeat.o(186485);
      return null;
    }
    int i = getImageWidth();
    int j = (int)(1.0F * i * paramInt2 / paramInt1);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (paramPointF.x * i);
    arrayOfFloat[1] = (paramPointF.y * j);
    ad.v("MicroMsg.WxImageView", "mapPoint srcPoint: %s, width: %d, height: %d, viewWidth: %d, viewHeight: %d, targetWidth: %d, targetHeight: %d", new Object[] { paramPointF, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.gfT), Integer.valueOf(this.gfU), Integer.valueOf(i), Integer.valueOf(j) });
    if (this.gvj != null)
    {
      paramPointF = this.gvj;
      paramPointF = new PointF(paramPointF.Y(arrayOfFloat[0]), paramPointF.Z(arrayOfFloat[1]));
      AppMethodBeat.o(186485);
      return paramPointF;
    }
    AppMethodBeat.o(186485);
    return null;
  }
  
  public final void am(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142477);
    fzp();
    p(this.Jpl, paramFloat1, paramFloat2);
    AppMethodBeat.o(142477);
  }
  
  public final void an(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142488);
    this.Jpj = getDoubleTabScale();
    p(this.Jpj, paramFloat1, paramFloat2);
    AppMethodBeat.o(142488);
  }
  
  public final void ao(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142490);
    ad.d("MicroMsg.WxImageView", "alvinluo WxImageView postTranslate dx: %f, dy: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.aYM.postTranslate(paramFloat1, paramFloat2);
    AppMethodBeat.o(142490);
  }
  
  public final void fyA()
  {
    AppMethodBeat.i(142485);
    if ((this.Jpq) && (0.0F == this.Jpj)) {
      this.Jpj = getDoubleTabScale();
    }
    AppMethodBeat.o(142485);
  }
  
  public final boolean fyw()
  {
    return this.aXB;
  }
  
  public final boolean fyx()
  {
    return this.aXA;
  }
  
  public final void fyy()
  {
    AppMethodBeat.i(142476);
    ad.d("MicroMsg.WxImageView", "alvinluo adaptViewSize");
    this.aYM.reset();
    fzp();
    ahi();
    o(this.Jpl, 0.0F, 0.0F);
    AppMethodBeat.o(142476);
  }
  
  public final void fyz()
  {
    boolean bool2 = true;
    AppMethodBeat.i(164159);
    boolean bool1;
    if ((!this.AdH) || (!this.aXB))
    {
      bool1 = true;
      if (this.aXA) {
        break label49;
      }
    }
    for (;;)
    {
      aV(bool1, bool2);
      AppMethodBeat.o(164159);
      return;
      bool1 = false;
      break;
      label49:
      bool2 = false;
    }
  }
  
  public int getContentLeft()
  {
    AppMethodBeat.i(142475);
    if (!this.ivz)
    {
      AppMethodBeat.o(142475);
      return 0;
    }
    float f1 = this.Jpl;
    float f2 = this.imageWidth;
    int j = (int)((this.gfT - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ad.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageWidth: %d, viewWidth: %d, left: %d", new Object[] { Float.valueOf(this.Jpl), Integer.valueOf(this.imageWidth), Integer.valueOf(this.gfT), Integer.valueOf(i) });
    AppMethodBeat.o(142475);
    return i;
  }
  
  public int getContentTop()
  {
    AppMethodBeat.i(142474);
    if (!this.ivz)
    {
      AppMethodBeat.o(142474);
      return 0;
    }
    float f1 = this.Jpl;
    float f2 = getImageHeight();
    int j = (int)((this.gfU - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ad.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageHeight: %d, viewHeight: %d, top: %d", new Object[] { Float.valueOf(this.Jpl), Integer.valueOf(getImageHeight()), Integer.valueOf(this.gfU), Integer.valueOf(i) });
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
        f1 = getScaleRate() * this.Jpm;
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
    this.Jpg.set(this.Jpf);
    this.Jpg.postConcat(this.aYM);
    Matrix localMatrix = this.Jpg;
    AppMethodBeat.o(142492);
    return localMatrix;
  }
  
  protected Matrix getImageViewMatrix()
  {
    AppMethodBeat.i(142484);
    this.Jpg.set(this.Jpf);
    this.Jpg.postConcat(this.aYM);
    Matrix localMatrix = this.Jpg;
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
    return this.kHI;
  }
  
  public float getMinZoom()
  {
    return this.Jpk;
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
    return this.Jps;
  }
  
  public float getScaleRate()
  {
    return this.Jpl;
  }
  
  public float getScaleWidth()
  {
    return this.Jpr;
  }
  
  public final void o(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(142486);
    float f2 = getScale();
    float f1;
    label78:
    boolean bool1;
    if (this.Jpq)
    {
      if (0.0F == this.Jpj)
      {
        f1 = this.Jpo * this.aYZ;
        this.kHI = f1;
      }
    }
    else
    {
      if (paramFloat1 <= this.kHI * 2.0F) {
        break label206;
      }
      f1 = this.kHI * 2.0F + (paramFloat1 - this.kHI) * 0.1F;
      paramFloat1 = f1 / f2;
      ad.d("MicroMsg.WxImageView", "alvinluo zoomTo mzdt=%f,mz=%f,scale=%f,oldScale=%f,deltaScale=%f", new Object[] { Float.valueOf(this.Jpj), Float.valueOf(this.kHI), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramFloat1) });
      if (!this.Jpv) {
        this.aYM.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      if ((this.AdH) && (this.aXB)) {
        break label227;
      }
      bool1 = true;
      label175:
      if (this.aXA) {
        break label233;
      }
    }
    for (;;)
    {
      aV(bool1, bool2);
      AppMethodBeat.o(142486);
      return;
      f1 = this.Jpj;
      break;
      label206:
      f1 = paramFloat1;
      if (paramFloat1 >= this.Jpk) {
        break label78;
      }
      f1 = this.Jpk;
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
      this.ivz = false;
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
      o(1.0F, this.gfT / 2.0F, this.gfU / 2.0F);
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
    if ((this.gfT != View.MeasureSpec.getSize(paramInt1)) || (this.gfU != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.dFh = true;; this.dFh = false)
    {
      this.gfT = View.MeasureSpec.getSize(paramInt1);
      this.gfU = View.MeasureSpec.getSize(paramInt2);
      ad.d("MicroMsg.WxImageView", "alvinluo onMeasure viewWidth: %d, viewHeight: %d", new Object[] { Integer.valueOf(this.gfT), Integer.valueOf(this.gfU) });
      if (!this.ivz)
      {
        this.ivz = true;
        this.Jpv = false;
        ad.d("MicroMsg.WxImageView", "init screenWidth:" + this.gfT + " screenHeight :" + this.gfU);
        float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
        if (f > 1.0F) {
          this.aYZ = f;
        }
        fyy();
      }
      if (this.dFh) {
        fyy();
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
    this.Jpm = paramFloat;
    AppMethodBeat.o(142472);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.AdH = paramBoolean;
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
    this.Jpq = paramBoolean;
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
    this.Jpo = paramFloat;
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
    this.Jpn = paramFloat;
    AppMethodBeat.o(142471);
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(142478);
    this.orientation = paramInt;
    fzp();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.WxImageView
 * JD-Core Version:    0.7.0.1
 */