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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public class WxImageView
  extends WxBaseImageView
  implements g
{
  protected Matrix asS;
  private float atf;
  private boolean isInited;
  private boolean jeA;
  private int jgD;
  private int jgE;
  protected ak mHandler;
  private int orientation;
  private MultiTouchImageView.a rRA;
  private boolean rRd;
  protected Bitmap rzS;
  private final float[] uA;
  protected Matrix zoa;
  private final Matrix zob;
  int zoc;
  int zod;
  private float zoe;
  private float zof;
  private float zog;
  private float zoh;
  private float zoi;
  private float zoj;
  private float zok;
  private boolean zol;
  private boolean zom;
  private boolean zon;
  private float zoo;
  private float zop;
  private boolean zor;
  private Drawable zos;
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107098);
    this.zoa = new Matrix();
    this.asS = new Matrix();
    this.zob = new Matrix();
    this.uA = new float[9];
    this.rzS = null;
    this.zoc = -1;
    this.zod = -1;
    this.zoe = 0.0F;
    this.zof = 0.0F;
    this.zog = 0.0F;
    this.isInited = false;
    this.jeA = false;
    this.zoi = 2.0F;
    this.zoj = 0.75F;
    this.zok = 20.0F;
    this.zol = false;
    this.zom = false;
    this.zon = false;
    this.rRd = true;
    this.zor = false;
    this.mHandler = new ak();
    this.atf = 1.0F;
    AppMethodBeat.o(107098);
  }
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107099);
    this.zoa = new Matrix();
    this.asS = new Matrix();
    this.zob = new Matrix();
    this.uA = new float[9];
    this.rzS = null;
    this.zoc = -1;
    this.zod = -1;
    this.zoe = 0.0F;
    this.zof = 0.0F;
    this.zog = 0.0F;
    this.isInited = false;
    this.jeA = false;
    this.zoi = 2.0F;
    this.zoj = 0.75F;
    this.zok = 20.0F;
    this.zol = false;
    this.zom = false;
    this.zon = false;
    this.rRd = true;
    this.zor = false;
    this.mHandler = new ak();
    this.atf = 1.0F;
    AppMethodBeat.o(107099);
  }
  
  private void aj(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(107112);
    if ((this.zos == null) && (this.zor))
    {
      AppMethodBeat.o(107112);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f3;
    if (this.zor)
    {
      localRectF = new RectF(0.0F, 0.0F, this.zos.getIntrinsicWidth(), this.zos.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f3 = localRectF.width();
      if (!paramBoolean2) {
        break label248;
      }
      if (f1 >= this.jgE) {
        break label199;
      }
      f1 = (this.jgE - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label119:
      if (paramBoolean1) {
        if (f3 < this.jgD) {
          f2 = (this.jgD - f3) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        ap(f2, f1);
        getImageViewMatrix().mapRect(localRectF);
        AppMethodBeat.o(107112);
        return;
        localRectF = new RectF(0.0F, 0.0F, this.imageWidth, this.imageHeight);
        break;
        label199:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label119;
        }
        if (localRectF.bottom >= this.jgE) {
          break label399;
        }
        f1 = this.jgE - localRectF.bottom;
        break label119;
        label248:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label119;
        }
        if (localRectF.bottom >= this.jgE) {
          break label399;
        }
        f1 = this.jgE - localRectF.bottom;
        break label119;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.jgD)
        {
          f2 = this.jgD - localRectF.right;
          continue;
          if (localRectF.left > 0.0F) {
            f2 = -localRectF.left;
          } else if (localRectF.right < this.jgD) {
            f2 = this.jgD - localRectF.right;
          }
        }
      }
      label399:
      f1 = 0.0F;
    }
  }
  
  private void dEz()
  {
    boolean bool2 = true;
    AppMethodBeat.i(107109);
    int i = getImageWidth();
    int j = getImageHeight();
    this.zoo = (this.jgD / i);
    this.zop = (this.jgE / j);
    boolean bool1;
    if (i > j * 2.2F)
    {
      bool1 = true;
      this.zom = bool1;
      if (j <= i * 2.2F) {
        break label225;
      }
      bool1 = true;
      label84:
      this.zon = bool1;
      if ((!this.zom) || (i <= this.jgD)) {
        break label231;
      }
      bool1 = true;
      label109:
      this.zom = bool1;
      if ((!this.zon) || (j <= this.jgE)) {
        break label237;
      }
      bool1 = bool2;
      label135:
      this.zon = bool1;
      float f3 = j / i;
      float f2 = 1.8F;
      float f1 = f2;
      if (this.jgD != 0)
      {
        f1 = f2;
        if (this.jgE != 0) {
          f1 = this.jgE / this.jgD;
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
    for (this.zoh = this.zop;; this.zoh = this.zoo)
    {
      setScaleRate(this.zoh);
      AppMethodBeat.o(107109);
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
  
  private void l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(107119);
    paramFloat1 = (paramFloat1 - getScale()) / 128.0F;
    float f = getScale();
    long l = System.currentTimeMillis();
    this.mHandler.post(new WxImageView.1(this, l, f, paramFloat1, paramFloat2, paramFloat3));
    AppMethodBeat.o(107119);
  }
  
  public final void an(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(107107);
    dEz();
    l(this.zoh, paramFloat1, paramFloat2);
    AppMethodBeat.o(107107);
  }
  
  public final void ao(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(107118);
    this.zoe = getDoubleTabScale();
    l(this.zoe, paramFloat1, paramFloat2);
    AppMethodBeat.o(107118);
  }
  
  public final void ap(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(107120);
    ab.d("MicroMsg.WxImageView", "alvinluo WxImageView postTranslate dx: %f, dy: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.asS.postTranslate(paramFloat1, paramFloat2);
    AppMethodBeat.o(107120);
  }
  
  public final boolean dDH()
  {
    return this.zom;
  }
  
  public final boolean dDI()
  {
    return this.zon;
  }
  
  public final void dDJ()
  {
    AppMethodBeat.i(107106);
    ab.d("MicroMsg.WxImageView", "alvinluo adaptViewSize");
    this.asS.reset();
    dEz();
    Pz();
    k(this.zoh, 0.0F, 0.0F);
    AppMethodBeat.o(107106);
  }
  
  public final void dDK()
  {
    AppMethodBeat.i(107115);
    if ((this.zol) && (0.0F == this.zoe)) {
      this.zoe = getDoubleTabScale();
    }
    AppMethodBeat.o(107115);
  }
  
  public int getContentLeft()
  {
    AppMethodBeat.i(107105);
    if (!this.isInited)
    {
      AppMethodBeat.o(107105);
      return 0;
    }
    float f1 = this.zoh;
    float f2 = this.imageWidth;
    int j = (int)((this.jgD - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ab.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageWidth: %d, viewWidth: %d, left: %d", new Object[] { Float.valueOf(this.zoh), Integer.valueOf(this.imageWidth), Integer.valueOf(this.jgD), Integer.valueOf(i) });
    AppMethodBeat.o(107105);
    return i;
  }
  
  public int getContentTop()
  {
    AppMethodBeat.i(107104);
    if (!this.isInited)
    {
      AppMethodBeat.o(107104);
      return 0;
    }
    float f1 = this.zoh;
    float f2 = getImageHeight();
    int j = (int)((this.jgE - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ab.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageHeight: %d, viewHeight: %d, top: %d", new Object[] { Float.valueOf(this.zoh), Integer.valueOf(getImageHeight()), Integer.valueOf(this.jgE), Integer.valueOf(i) });
    AppMethodBeat.o(107104);
    return i;
  }
  
  public float getDoubleTabScale()
  {
    AppMethodBeat.i(107117);
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
      AppMethodBeat.o(107117);
      return f1;
      if (getScaleHeight() * 0.7F > f1) {
        f1 = getScaleHeight();
      } else {
        f1 = getScaleRate() * this.zoi;
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
    AppMethodBeat.i(107122);
    this.zob.set(this.zoa);
    this.zob.postConcat(this.asS);
    Matrix localMatrix = this.zob;
    AppMethodBeat.o(107122);
    return localMatrix;
  }
  
  protected Matrix getImageViewMatrix()
  {
    AppMethodBeat.i(107114);
    this.zob.set(this.zoa);
    this.zob.postConcat(this.asS);
    Matrix localMatrix = this.zob;
    AppMethodBeat.o(107114);
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
    return this.zof;
  }
  
  public float getMinZoom()
  {
    return this.zog;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(107113);
    float f = super.getScale();
    AppMethodBeat.o(107113);
    return f;
  }
  
  public float getScaleHeight()
  {
    return this.zop;
  }
  
  public float getScaleRate()
  {
    return this.zoh;
  }
  
  public float getScaleWidth()
  {
    return this.zoo;
  }
  
  public final void k(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(107116);
    float f2 = getScale();
    float f1;
    label78:
    boolean bool1;
    if (this.zol)
    {
      if (0.0F == this.zoe)
      {
        f1 = this.zok * this.atf;
        this.zof = f1;
      }
    }
    else
    {
      if (paramFloat1 <= this.zof * 2.0F) {
        break label228;
      }
      f1 = this.zof * 2.0F + (paramFloat1 - this.zof) * 0.1F;
      paramFloat1 = f1 / f2;
      ab.d("MicroMsg.WxImageView", "alvinluo zoomTo mzdt=%f,mz=%f,scale=%f,oldScale=%f,deltaScale=%f", new Object[] { Float.valueOf(this.zoe), Float.valueOf(this.zof), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramFloat1) });
      if (!this.zor) {
        this.asS.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      if ((this.rRd) && (this.zom)) {
        break label249;
      }
      bool1 = true;
      label175:
      if (this.zon) {
        break label255;
      }
    }
    for (;;)
    {
      aj(bool1, bool2);
      if (this.rRA == null) {
        break label276;
      }
      if (paramFloat1 <= 1.0F) {
        break label261;
      }
      this.rRA.cvq();
      AppMethodBeat.o(107116);
      return;
      f1 = this.zoe;
      break;
      label228:
      f1 = paramFloat1;
      if (paramFloat1 >= this.zog) {
        break label78;
      }
      f1 = this.zog;
      break label78;
      label249:
      bool1 = false;
      break label175;
      label255:
      bool2 = false;
    }
    label261:
    if (paramFloat1 < 1.0F) {
      this.rRA.cvp();
    }
    label276:
    AppMethodBeat.o(107116);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.isInited = false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107110);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      f.c(paramKeyEvent);
      AppMethodBeat.o(107110);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(107110);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107111);
    if ((paramInt == 4) && (f.d(paramKeyEvent)) && (!f.e(paramKeyEvent)) && (getScale() > 1.0F))
    {
      k(1.0F, this.jgD / 2.0F, this.jgE / 2.0F);
      AppMethodBeat.o(107111);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(107111);
    return bool;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107103);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.jgD != View.MeasureSpec.getSize(paramInt1)) || (this.jgE != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.jeA = true;; this.jeA = false)
    {
      this.jgD = View.MeasureSpec.getSize(paramInt1);
      this.jgE = View.MeasureSpec.getSize(paramInt2);
      ab.d("MicroMsg.WxImageView", "alvinluo onMeasure viewWidth: %d, viewHeight: %d", new Object[] { Integer.valueOf(this.jgD), Integer.valueOf(this.jgE) });
      if (!this.isInited)
      {
        this.isInited = true;
        this.zor = false;
        ab.d("MicroMsg.WxImageView", "init screenWidth:" + this.jgD + " screenHeight :" + this.jgE);
        float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
        if (f > 1.0F) {
          this.atf = f;
        }
        dDJ();
      }
      if (this.jeA) {
        dDJ();
      }
      AppMethodBeat.o(107103);
      return;
    }
  }
  
  public void setDoubleTabScaleLimit(float paramFloat)
  {
    AppMethodBeat.i(107102);
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      ab.w("MicroMsg.WxImageView", "double tab scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(107102);
      return;
    }
    this.zoi = paramFloat;
    AppMethodBeat.o(107102);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.rRd = paramBoolean;
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
    this.zol = paramBoolean;
  }
  
  public void setMaxZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(107100);
    if (Float.compare(paramFloat, 1.0F) < 0)
    {
      ab.w("MicroMsg.WxImageView", "max scale limit is less than 1.0, change nothing, return");
      AppMethodBeat.o(107100);
      return;
    }
    this.zok = paramFloat;
    AppMethodBeat.o(107100);
  }
  
  public void setMinZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(107101);
    if (Float.compare(paramFloat, 1.0F) > 0)
    {
      ab.w("MicroMsg.WxImageView", "min scale limit is greater than 1.0, change nothing, return");
      AppMethodBeat.o(107101);
      return;
    }
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      ab.w("MicroMsg.WxImageView", "min scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(107101);
      return;
    }
    this.zoj = paramFloat;
    AppMethodBeat.o(107101);
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(107108);
    this.orientation = paramInt;
    dEz();
    AppMethodBeat.o(107108);
  }
  
  public final void translate(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(107121);
    float f1 = getTranslationX();
    float f2 = getTranslationY();
    setTranslationX(f1 + paramFloat1);
    setTranslationY(f2 + paramFloat2);
    ab.i("MicroMsg.WxImageView", "alvinluo translate x: %f, y: %f, x + dx: %f, y + dy: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f1 + paramFloat1), Float.valueOf(f2 + paramFloat2) });
    AppMethodBeat.o(107121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.WxImageView
 * JD-Core Version:    0.7.0.1
 */