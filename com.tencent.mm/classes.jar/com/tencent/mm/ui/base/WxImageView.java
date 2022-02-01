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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

public class WxImageView
  extends WxBaseImageView
  implements g
{
  private final float[] BY;
  private boolean HBA;
  private boolean HBB;
  private float HBC;
  private float HBD;
  private boolean HBG;
  private Drawable HBH;
  protected Matrix HBo;
  private final Matrix HBp;
  int HBq;
  int HBr;
  private float HBs;
  private float HBt;
  private float HBu;
  private float HBv;
  private float HBw;
  private float HBx;
  private boolean HBz;
  private float aOF;
  protected Matrix aOs;
  private boolean dtf;
  private int fMt;
  private int fMu;
  private boolean icd;
  private float kmI;
  protected ao mHandler;
  private int orientation;
  private boolean yMl;
  protected Bitmap yss;
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142468);
    this.HBo = new Matrix();
    this.aOs = new Matrix();
    this.HBp = new Matrix();
    this.BY = new float[9];
    this.yss = null;
    this.HBq = -1;
    this.HBr = -1;
    this.HBs = 0.0F;
    this.kmI = 0.0F;
    this.HBt = 0.0F;
    this.icd = false;
    this.dtf = false;
    this.HBv = 2.0F;
    this.HBw = 0.75F;
    this.HBx = 20.0F;
    this.HBz = false;
    this.HBA = false;
    this.HBB = false;
    this.yMl = true;
    this.HBG = false;
    this.mHandler = new ao();
    this.aOF = 1.0F;
    AppMethodBeat.o(142468);
  }
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142469);
    this.HBo = new Matrix();
    this.aOs = new Matrix();
    this.HBp = new Matrix();
    this.BY = new float[9];
    this.yss = null;
    this.HBq = -1;
    this.HBr = -1;
    this.HBs = 0.0F;
    this.kmI = 0.0F;
    this.HBt = 0.0F;
    this.icd = false;
    this.dtf = false;
    this.HBv = 2.0F;
    this.HBw = 0.75F;
    this.HBx = 20.0F;
    this.HBz = false;
    this.HBA = false;
    this.HBB = false;
    this.yMl = true;
    this.HBG = false;
    this.mHandler = new ao();
    this.aOF = 1.0F;
    AppMethodBeat.o(142469);
  }
  
  private void aN(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(142482);
    if ((this.HBH == null) && (this.HBG))
    {
      AppMethodBeat.o(142482);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f3;
    if (this.HBG)
    {
      localRectF = new RectF(0.0F, 0.0F, this.HBH.getIntrinsicWidth(), this.HBH.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f3 = localRectF.width();
      if (!paramBoolean2) {
        break label248;
      }
      if (f1 >= this.fMu) {
        break label199;
      }
      f1 = (this.fMu - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label119:
      if (paramBoolean1) {
        if (f3 < this.fMt) {
          f2 = (this.fMt - f3) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        ak(f2, f1);
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
        if (localRectF.bottom >= this.fMu) {
          break label399;
        }
        f1 = this.fMu - localRectF.bottom;
        break label119;
        label248:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label119;
        }
        if (localRectF.bottom >= this.fMu) {
          break label399;
        }
        f1 = this.fMu - localRectF.bottom;
        break label119;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.fMt)
        {
          f2 = this.fMt - localRectF.right;
          continue;
          if (localRectF.left > 0.0F) {
            f2 = -localRectF.left;
          } else if (localRectF.right < this.fMt) {
            f2 = this.fMt - localRectF.right;
          }
        }
      }
      label399:
      f1 = 0.0F;
    }
  }
  
  private void fja()
  {
    boolean bool2 = true;
    AppMethodBeat.i(142479);
    int i = getImageWidth();
    int j = getImageHeight();
    this.HBC = (this.fMt / i);
    this.HBD = (this.fMu / j);
    boolean bool1;
    if (i > j * 2.2F)
    {
      bool1 = true;
      this.HBA = bool1;
      if (j <= i * 2.2F) {
        break label225;
      }
      bool1 = true;
      label84:
      this.HBB = bool1;
      if ((!this.HBA) || (i <= this.fMt)) {
        break label231;
      }
      bool1 = true;
      label109:
      this.HBA = bool1;
      if ((!this.HBB) || (j <= this.fMu)) {
        break label237;
      }
      bool1 = bool2;
      label135:
      this.HBB = bool1;
      float f3 = j / i;
      float f2 = 1.8F;
      float f1 = f2;
      if (this.fMt != 0)
      {
        f1 = f2;
        if (this.fMu != 0) {
          f1 = this.fMu / this.fMt;
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
    for (this.HBu = this.HBD;; this.HBu = this.HBC)
    {
      setScaleRate(this.HBu);
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
        float f1 = Math.min(this.HBI, (float)(l - l));
        float f2 = paramFloat1;
        float f3 = paramFloat2;
        WxImageView.this.m(f2 + f3 * f1, paramFloat3, this.cPV);
        if (f1 < this.HBI) {
          WxImageView.this.mHandler.post(this);
        }
        AppMethodBeat.o(142467);
      }
    });
    AppMethodBeat.o(142489);
  }
  
  public final void ai(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142477);
    fja();
    n(this.HBu, paramFloat1, paramFloat2);
    AppMethodBeat.o(142477);
  }
  
  public final void aj(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142488);
    this.HBs = getDoubleTabScale();
    n(this.HBs, paramFloat1, paramFloat2);
    AppMethodBeat.o(142488);
  }
  
  public final void ak(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142490);
    ac.d("MicroMsg.WxImageView", "alvinluo WxImageView postTranslate dx: %f, dy: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.aOs.postTranslate(paramFloat1, paramFloat2);
    AppMethodBeat.o(142490);
  }
  
  public final boolean fih()
  {
    return this.HBA;
  }
  
  public final boolean fii()
  {
    return this.HBB;
  }
  
  public final void fij()
  {
    AppMethodBeat.i(142476);
    ac.d("MicroMsg.WxImageView", "alvinluo adaptViewSize");
    this.aOs.reset();
    fja();
    aew();
    m(this.HBu, 0.0F, 0.0F);
    AppMethodBeat.o(142476);
  }
  
  public final void fik()
  {
    boolean bool2 = true;
    AppMethodBeat.i(164159);
    boolean bool1;
    if ((!this.yMl) || (!this.HBA))
    {
      bool1 = true;
      if (this.HBB) {
        break label49;
      }
    }
    for (;;)
    {
      aN(bool1, bool2);
      AppMethodBeat.o(164159);
      return;
      bool1 = false;
      break;
      label49:
      bool2 = false;
    }
  }
  
  public final void fil()
  {
    AppMethodBeat.i(142485);
    if ((this.HBz) && (0.0F == this.HBs)) {
      this.HBs = getDoubleTabScale();
    }
    AppMethodBeat.o(142485);
  }
  
  public int getContentLeft()
  {
    AppMethodBeat.i(142475);
    if (!this.icd)
    {
      AppMethodBeat.o(142475);
      return 0;
    }
    float f1 = this.HBu;
    float f2 = this.imageWidth;
    int j = (int)((this.fMt - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ac.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageWidth: %d, viewWidth: %d, left: %d", new Object[] { Float.valueOf(this.HBu), Integer.valueOf(this.imageWidth), Integer.valueOf(this.fMt), Integer.valueOf(i) });
    AppMethodBeat.o(142475);
    return i;
  }
  
  public int getContentTop()
  {
    AppMethodBeat.i(142474);
    if (!this.icd)
    {
      AppMethodBeat.o(142474);
      return 0;
    }
    float f1 = this.HBu;
    float f2 = getImageHeight();
    int j = (int)((this.fMu - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ac.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageHeight: %d, viewHeight: %d, top: %d", new Object[] { Float.valueOf(this.HBu), Integer.valueOf(getImageHeight()), Integer.valueOf(this.fMu), Integer.valueOf(i) });
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
        f1 = getScaleRate() * this.HBv;
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
    this.HBp.set(this.HBo);
    this.HBp.postConcat(this.aOs);
    Matrix localMatrix = this.HBp;
    AppMethodBeat.o(142492);
    return localMatrix;
  }
  
  protected Matrix getImageViewMatrix()
  {
    AppMethodBeat.i(142484);
    this.HBp.set(this.HBo);
    this.HBp.postConcat(this.aOs);
    Matrix localMatrix = this.HBp;
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
    return this.kmI;
  }
  
  public float getMinZoom()
  {
    return this.HBt;
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
    return this.HBD;
  }
  
  public float getScaleRate()
  {
    return this.HBu;
  }
  
  public float getScaleWidth()
  {
    return this.HBC;
  }
  
  public final void m(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(142486);
    float f2 = getScale();
    float f1;
    label78:
    boolean bool1;
    if (this.HBz)
    {
      if (0.0F == this.HBs)
      {
        f1 = this.HBx * this.aOF;
        this.kmI = f1;
      }
    }
    else
    {
      if (paramFloat1 <= this.kmI * 2.0F) {
        break label206;
      }
      f1 = this.kmI * 2.0F + (paramFloat1 - this.kmI) * 0.1F;
      paramFloat1 = f1 / f2;
      ac.d("MicroMsg.WxImageView", "alvinluo zoomTo mzdt=%f,mz=%f,scale=%f,oldScale=%f,deltaScale=%f", new Object[] { Float.valueOf(this.HBs), Float.valueOf(this.kmI), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramFloat1) });
      if (!this.HBG) {
        this.aOs.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      if ((this.yMl) && (this.HBA)) {
        break label227;
      }
      bool1 = true;
      label175:
      if (this.HBB) {
        break label233;
      }
    }
    for (;;)
    {
      aN(bool1, bool2);
      AppMethodBeat.o(142486);
      return;
      f1 = this.HBs;
      break;
      label206:
      f1 = paramFloat1;
      if (paramFloat1 >= this.HBt) {
        break label78;
      }
      f1 = this.HBt;
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
      this.icd = false;
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
      m(1.0F, this.fMt / 2.0F, this.fMu / 2.0F);
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
    if ((this.fMt != View.MeasureSpec.getSize(paramInt1)) || (this.fMu != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.dtf = true;; this.dtf = false)
    {
      this.fMt = View.MeasureSpec.getSize(paramInt1);
      this.fMu = View.MeasureSpec.getSize(paramInt2);
      ac.d("MicroMsg.WxImageView", "alvinluo onMeasure viewWidth: %d, viewHeight: %d", new Object[] { Integer.valueOf(this.fMt), Integer.valueOf(this.fMu) });
      if (!this.icd)
      {
        this.icd = true;
        this.HBG = false;
        ac.d("MicroMsg.WxImageView", "init screenWidth:" + this.fMt + " screenHeight :" + this.fMu);
        float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
        if (f > 1.0F) {
          this.aOF = f;
        }
        fij();
      }
      if (this.dtf) {
        fij();
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
      ac.w("MicroMsg.WxImageView", "double tab scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142472);
      return;
    }
    this.HBv = paramFloat;
    AppMethodBeat.o(142472);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.yMl = paramBoolean;
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
    this.HBz = paramBoolean;
  }
  
  public void setMaxZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(142470);
    if (Float.compare(paramFloat, 1.0F) < 0)
    {
      ac.w("MicroMsg.WxImageView", "max scale limit is less than 1.0, change nothing, return");
      AppMethodBeat.o(142470);
      return;
    }
    this.HBx = paramFloat;
    AppMethodBeat.o(142470);
  }
  
  public void setMinZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(142471);
    if (Float.compare(paramFloat, 1.0F) > 0)
    {
      ac.w("MicroMsg.WxImageView", "min scale limit is greater than 1.0, change nothing, return");
      AppMethodBeat.o(142471);
      return;
    }
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      ac.w("MicroMsg.WxImageView", "min scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142471);
      return;
    }
    this.HBw = paramFloat;
    AppMethodBeat.o(142471);
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(142478);
    this.orientation = paramInt;
    fja();
    AppMethodBeat.o(142478);
  }
  
  public final void translate(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142491);
    float f1 = getTranslationX();
    float f2 = getTranslationY();
    setTranslationX(f1 + paramFloat1);
    setTranslationY(f2 + paramFloat2);
    ac.i("MicroMsg.WxImageView", "alvinluo translate x: %f, y: %f, x + dx: %f, y + dy: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f1 + paramFloat1), Float.valueOf(f2 + paramFloat2) });
    AppMethodBeat.o(142491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.WxImageView
 * JD-Core Version:    0.7.0.1
 */