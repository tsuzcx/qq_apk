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
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.ui.WxBaseImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class WxImageView
  extends WxBaseImageView
  implements g
{
  private final float[] DZ;
  private boolean EEg;
  protected Bitmap EiY;
  protected Matrix OUN;
  private final Matrix OUO;
  int OUP;
  int OUQ;
  private float OUR;
  private float OUS;
  private float OUT;
  private Float OUU;
  private boolean OUV;
  private float OUW;
  private float OUX;
  private float OUY;
  private boolean OVb;
  private float OVc;
  private float OVd;
  private boolean OVg;
  private Drawable OVh;
  private boolean aXp;
  private boolean aXq;
  protected Matrix aYH;
  private float aYU;
  private boolean dXX;
  private int gRD;
  private int gRE;
  private boolean iCs;
  private float lPE;
  protected MMHandler mHandler;
  private int orientation;
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142468);
    this.OUN = new Matrix();
    this.aYH = new Matrix();
    this.OUO = new Matrix();
    this.DZ = new float[9];
    this.EiY = null;
    this.OUP = -1;
    this.OUQ = -1;
    this.OUR = 0.0F;
    this.lPE = 0.0F;
    this.OUS = 0.0F;
    this.iCs = false;
    this.dXX = false;
    this.OUV = true;
    this.OUW = 2.0F;
    this.OUX = 0.75F;
    this.OUY = 20.0F;
    this.OVb = false;
    this.aXq = false;
    this.aXp = false;
    this.EEg = true;
    this.OVg = false;
    this.mHandler = new MMHandler();
    this.aYU = 1.0F;
    initView();
    AppMethodBeat.o(142468);
  }
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142469);
    this.OUN = new Matrix();
    this.aYH = new Matrix();
    this.OUO = new Matrix();
    this.DZ = new float[9];
    this.EiY = null;
    this.OUP = -1;
    this.OUQ = -1;
    this.OUR = 0.0F;
    this.lPE = 0.0F;
    this.OUS = 0.0F;
    this.iCs = false;
    this.dXX = false;
    this.OUV = true;
    this.OUW = 2.0F;
    this.OUX = 0.75F;
    this.OUY = 20.0F;
    this.OVb = false;
    this.aXq = false;
    this.aXp = false;
    this.EEg = true;
    this.OVg = false;
    this.mHandler = new MMHandler();
    this.aYU = 1.0F;
    initView();
    AppMethodBeat.o(142469);
  }
  
  private void be(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(142482);
    if ((this.OVh == null) && (this.OVg))
    {
      AppMethodBeat.o(142482);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f3;
    if (this.OVg)
    {
      localRectF = new RectF(0.0F, 0.0F, this.OVh.getIntrinsicWidth(), this.OVh.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f3 = localRectF.width();
      if (!paramBoolean2) {
        break label248;
      }
      if (f1 >= this.gRE) {
        break label199;
      }
      f1 = (this.gRE - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label119:
      if (paramBoolean1) {
        if (f3 < this.gRD) {
          f2 = (this.gRD - f3) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        au(f2, f1);
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
        if (localRectF.bottom >= this.gRE) {
          break label399;
        }
        f1 = this.gRE - localRectF.bottom;
        break label119;
        label248:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label119;
        }
        if (localRectF.bottom >= this.gRE) {
          break label399;
        }
        f1 = this.gRE - localRectF.bottom;
        break label119;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.gRD)
        {
          f2 = this.gRD - localRectF.right;
          continue;
          if (localRectF.left > 0.0F) {
            f2 = -localRectF.left;
          } else if (localRectF.right < this.gRD) {
            f2 = this.gRD - localRectF.right;
          }
        }
      }
      label399:
      f1 = 0.0F;
    }
  }
  
  private void gLq()
  {
    boolean bool2 = true;
    AppMethodBeat.i(142479);
    if (this.OUU != null)
    {
      this.OUT = this.OUU.floatValue();
      AppMethodBeat.o(142479);
      return;
    }
    int i = getImageWidth();
    int j = getImageHeight();
    this.OVc = (this.gRD / i);
    this.OVd = (this.gRE / j);
    boolean bool1;
    if (i > j * 2.2F)
    {
      bool1 = true;
      this.aXq = bool1;
      if (j <= i * 2.2F) {
        break label249;
      }
      bool1 = true;
      label108:
      this.aXp = bool1;
      if ((!this.aXq) || (i <= this.gRD)) {
        break label255;
      }
      bool1 = true;
      label133:
      this.aXq = bool1;
      if ((!this.aXp) || (j <= this.gRE)) {
        break label261;
      }
      bool1 = bool2;
      label159:
      this.aXp = bool1;
      float f3 = j / i;
      float f2 = 1.8F;
      float f1 = f2;
      if (this.gRD != 0)
      {
        f1 = f2;
        if (this.gRE != 0) {
          f1 = this.gRE / this.gRD;
        }
      }
      if ((f3 <= f1) || (f3 > 2.2D)) {
        break label267;
      }
    }
    label261:
    label267:
    for (this.OUT = this.OVd;; this.OUT = this.OVc)
    {
      setScaleRate(this.OUT);
      AppMethodBeat.o(142479);
      return;
      bool1 = false;
      break;
      label249:
      bool1 = false;
      break label108;
      label255:
      bool1 = false;
      break label133;
      bool1 = false;
      break label159;
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(205277);
    a(new WxImageView.1(this));
    AppMethodBeat.o(205277);
  }
  
  public final PointF a(PointF paramPointF, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205280);
    if (paramPointF == null)
    {
      AppMethodBeat.o(205280);
      return null;
    }
    int i = getImageWidth();
    int j = (int)(1.0F * i * paramInt2 / paramInt1);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (paramPointF.x * i);
    arrayOfFloat[1] = (paramPointF.y * j);
    Log.v("MicroMsg.WxImageView", "mapPoint srcPoint: %s, width: %d, height: %d, viewWidth: %d, viewHeight: %d, targetWidth: %d, targetHeight: %d", new Object[] { paramPointF, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.gRD), Integer.valueOf(this.gRE), Integer.valueOf(i), Integer.valueOf(j) });
    if (this.hkD != null)
    {
      paramPointF = this.hkD;
      paramPointF = new PointF(paramPointF.Y(arrayOfFloat[0]), paramPointF.Z(arrayOfFloat[1]));
      AppMethodBeat.o(205280);
      return paramPointF;
    }
    AppMethodBeat.o(205280);
    return null;
  }
  
  public final void at(final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(142477);
    gLq();
    final float f1 = (this.OUT - getScale()) / 128.0F;
    float f2 = getScale();
    final long l = System.currentTimeMillis();
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205275);
        long l = System.currentTimeMillis();
        float f1 = Math.min(this.OVi, (float)(l - l));
        float f2 = f1;
        float f3 = paramFloat1;
        WxImageView.this.r(f2 + f3 * f1, paramFloat2, this.dsV);
        if (f1 < this.OVi) {
          WxImageView.this.mHandler.post(this);
        }
        AppMethodBeat.o(205275);
      }
    });
    AppMethodBeat.o(142477);
  }
  
  public final void au(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142490);
    Log.d("MicroMsg.WxImageView", "alvinluo WxImageView postTranslate dx: %f, dy: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.aYH.postTranslate(paramFloat1, paramFloat2);
    AppMethodBeat.o(142490);
  }
  
  public final PointF c(PointF paramPointF)
  {
    float f3 = 0.0F;
    AppMethodBeat.i(205281);
    int i = getImageWidth();
    int j = getImageHeight();
    Object localObject = new float[2];
    localObject[0] = paramPointF.x;
    localObject[1] = paramPointF.y;
    SubsamplingScaleImageView localSubsamplingScaleImageView;
    float f1;
    float f2;
    if (this.hkD != null)
    {
      localSubsamplingScaleImageView = this.hkD;
      f1 = localObject[0];
      if (localSubsamplingScaleImageView.aXO == null)
      {
        f1 = 0.0F;
        f2 = localObject[1];
        if (localSubsamplingScaleImageView.aXO != null) {
          break label214;
        }
        f2 = f3;
      }
    }
    label86:
    for (localObject = new PointF(f1, f2);; localObject = null)
    {
      if (localObject != null)
      {
        ((PointF)localObject).x /= i;
        ((PointF)localObject).y /= j;
        Log.i("MicroMsg.WxImageView", "alvinluo convertScreenToImageCoordinate screenCoordinate: %s, imageCoordinate: %s, imageWidth: %s, imageHeight: %s", new Object[] { paramPointF, localObject, Integer.valueOf(i), Integer.valueOf(j) });
      }
      AppMethodBeat.o(205281);
      return localObject;
      f2 = (f1 - localSubsamplingScaleImageView.aXO.x) / localSubsamplingScaleImageView.scale;
      if (!Float.isNaN(f2))
      {
        f1 = f2;
        if (!Float.isInfinite(f2)) {
          break;
        }
      }
      f1 = 0.0F;
      break;
      float f4 = (f2 - localSubsamplingScaleImageView.aXO.y) / localSubsamplingScaleImageView.scale;
      f2 = f3;
      if (Float.isNaN(f4)) {
        break label86;
      }
      f2 = f3;
      if (Float.isInfinite(f4)) {
        break label86;
      }
      f2 = f4;
      break label86;
    }
  }
  
  public final void gKA()
  {
    AppMethodBeat.i(142485);
    if ((this.OVb) && (0.0F == this.OUR)) {
      this.OUR = getDoubleTabScale();
    }
    AppMethodBeat.o(142485);
  }
  
  public final void gKB()
  {
    AppMethodBeat.i(205286);
    this.OUU = null;
    gLq();
    AppMethodBeat.o(205286);
  }
  
  public final boolean gKw()
  {
    return this.aXq;
  }
  
  public final boolean gKx()
  {
    return this.aXp;
  }
  
  public final void gKy()
  {
    AppMethodBeat.i(142476);
    Log.d("MicroMsg.WxImageView", "alvinluo adaptViewSize");
    this.aYH.reset();
    gLq();
    axJ();
    r(this.OUT, 0.0F, 0.0F);
    AppMethodBeat.o(142476);
  }
  
  public final void gKz()
  {
    boolean bool2 = true;
    AppMethodBeat.i(164159);
    boolean bool1;
    if ((!this.EEg) || (!this.aXq))
    {
      bool1 = true;
      if (this.aXp) {
        break label49;
      }
    }
    for (;;)
    {
      be(bool1, bool2);
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
    if (!this.iCs)
    {
      AppMethodBeat.o(142475);
      return 0;
    }
    float f1 = this.OUT;
    float f2 = this.imageWidth;
    int j = (int)((this.gRD - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Log.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageWidth: %d, viewWidth: %d, left: %d", new Object[] { Float.valueOf(this.OUT), Integer.valueOf(this.imageWidth), Integer.valueOf(this.gRD), Integer.valueOf(i) });
    AppMethodBeat.o(142475);
    return i;
  }
  
  public int getContentTop()
  {
    AppMethodBeat.i(142474);
    if (!this.iCs)
    {
      AppMethodBeat.o(142474);
      return 0;
    }
    float f1 = this.OUT;
    float f2 = getImageHeight();
    int j = (int)((this.gRE - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Log.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageHeight: %d, viewHeight: %d, top: %d", new Object[] { Float.valueOf(this.OUT), Integer.valueOf(getImageHeight()), Integer.valueOf(this.gRE), Integer.valueOf(i) });
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
        f1 = getScaleRate() * this.OUW;
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
    this.OUO.set(this.OUN);
    this.OUO.postConcat(this.aYH);
    Matrix localMatrix = this.OUO;
    AppMethodBeat.o(142492);
    return localMatrix;
  }
  
  protected Matrix getImageViewMatrix()
  {
    AppMethodBeat.i(142484);
    this.OUO.set(this.OUN);
    this.OUO.postConcat(this.aYH);
    Matrix localMatrix = this.OUO;
    AppMethodBeat.o(142484);
    return localMatrix;
  }
  
  public PointF getImageViewMatrixScale()
  {
    AppMethodBeat.i(205282);
    PointF localPointF = super.getImageViewMatrixScale();
    AppMethodBeat.o(205282);
    return localPointF;
  }
  
  public PointF getImageViewMatrixTranslation()
  {
    AppMethodBeat.i(205283);
    PointF localPointF = super.getImageViewMatrixTranslation();
    AppMethodBeat.o(205283);
    return localPointF;
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
    return this.lPE;
  }
  
  public float getMinZoom()
  {
    return this.OUS;
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
    return this.OVd;
  }
  
  public float getScaleRate()
  {
    return this.OUT;
  }
  
  public float getScaleWidth()
  {
    return this.OVc;
  }
  
  public final void l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(205284);
    super.l(paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(205284);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.iCs = false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(142480);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      f.f(paramKeyEvent);
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
    if ((paramInt == 4) && (f.g(paramKeyEvent)) && (!f.h(paramKeyEvent)) && (getScale() > 1.0F))
    {
      r(1.0F, this.gRD / 2.0F, this.gRE / 2.0F);
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
    if ((this.gRD != View.MeasureSpec.getSize(paramInt1)) || (this.gRE != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.dXX = true;; this.dXX = false)
    {
      this.gRD = View.MeasureSpec.getSize(paramInt1);
      this.gRE = View.MeasureSpec.getSize(paramInt2);
      if (!this.iCs)
      {
        this.iCs = true;
        this.OVg = false;
        Log.d("MicroMsg.WxImageView", "init screenWidth:" + this.gRD + " screenHeight :" + this.gRE);
        float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
        if (f > 1.0F) {
          this.aYU = f;
        }
        gKy();
      }
      if ((this.dXX) && (this.OUV)) {
        gKy();
      }
      AppMethodBeat.o(142473);
      return;
    }
  }
  
  public final void r(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(142486);
    float f2 = getScale();
    float f1;
    label78:
    boolean bool1;
    if (this.OVb)
    {
      if (0.0F == this.OUR)
      {
        f1 = this.OUY * this.aYU;
        this.lPE = f1;
      }
    }
    else
    {
      if (paramFloat1 <= this.lPE * 2.0F) {
        break label206;
      }
      f1 = this.lPE * 2.0F + (paramFloat1 - this.lPE) * 0.1F;
      paramFloat1 = f1 / f2;
      Log.d("MicroMsg.WxImageView", "alvinluo zoomTo mzdt=%f,mz=%f,scale=%f,oldScale=%f,deltaScale=%f", new Object[] { Float.valueOf(this.OUR), Float.valueOf(this.lPE), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramFloat1) });
      if (!this.OVg) {
        this.aYH.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      if ((this.EEg) && (this.aXq)) {
        break label227;
      }
      bool1 = true;
      label175:
      if (this.aXp) {
        break label233;
      }
    }
    for (;;)
    {
      be(bool1, bool2);
      AppMethodBeat.o(142486);
      return;
      f1 = this.OUR;
      break;
      label206:
      f1 = paramFloat1;
      if (paramFloat1 >= this.OUS) {
        break label78;
      }
      f1 = this.OUS;
      break label78;
      label227:
      bool1 = false;
      break label175;
      label233:
      bool2 = false;
    }
  }
  
  public void setAllowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(205288);
    super.setAllowInterceptTouchEvent(paramBoolean);
    AppMethodBeat.o(205288);
  }
  
  public void setCanRefresh(boolean paramBoolean)
  {
    this.OUV = paramBoolean;
  }
  
  public void setCustomScaleRate(Float paramFloat)
  {
    AppMethodBeat.i(205285);
    if (paramFloat != null)
    {
      this.OUU = paramFloat;
      super.setCustomScaleRate(paramFloat);
      AppMethodBeat.o(205285);
      return;
    }
    gKB();
    AppMethodBeat.o(205285);
  }
  
  public void setDoubleTabScaleLimit(float paramFloat)
  {
    AppMethodBeat.i(142472);
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      Log.w("MicroMsg.WxImageView", "double tab scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142472);
      return;
    }
    this.OUW = paramFloat;
    AppMethodBeat.o(142472);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.EEg = paramBoolean;
  }
  
  public void setImageHeight(int paramInt)
  {
    this.imageHeight = paramInt;
  }
  
  public void setImageViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(205278);
    super.setImageViewMatrix(paramMatrix);
    AppMethodBeat.o(205278);
  }
  
  public void setImageWidth(int paramInt)
  {
    this.imageWidth = paramInt;
  }
  
  public void setMaxZoomDoubleTab(boolean paramBoolean)
  {
    this.OVb = paramBoolean;
  }
  
  public void setMaxZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(142470);
    if (Float.compare(paramFloat, 1.0F) < 0)
    {
      Log.w("MicroMsg.WxImageView", "max scale limit is less than 1.0, change nothing, return");
      AppMethodBeat.o(142470);
      return;
    }
    this.OUY = paramFloat;
    AppMethodBeat.o(142470);
  }
  
  public void setMinZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(142471);
    if (Float.compare(paramFloat, 1.0F) > 0)
    {
      Log.w("MicroMsg.WxImageView", "min scale limit is greater than 1.0, change nothing, return");
      AppMethodBeat.o(142471);
      return;
    }
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      Log.w("MicroMsg.WxImageView", "min scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142471);
      return;
    }
    this.OUX = paramFloat;
    AppMethodBeat.o(142471);
  }
  
  public void setOnZoomScaleChangedListener(final g.a parama)
  {
    AppMethodBeat.i(205287);
    if (parama != null)
    {
      super.setOnZoomScaleChangedListener(new SubsamplingScaleImageView.f()
      {
        public final void r(float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(205276);
          parama.aj(paramAnonymousFloat2, paramAnonymousFloat1);
          AppMethodBeat.o(205276);
        }
      });
      AppMethodBeat.o(205287);
      return;
    }
    super.setOnZoomScaleChangedListener(null);
    AppMethodBeat.o(205287);
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(142478);
    this.orientation = paramInt;
    gLq();
    AppMethodBeat.o(142478);
  }
  
  public final void translate(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142491);
    float f1 = getTranslationX();
    float f2 = getTranslationY();
    setTranslationX(f1 + paramFloat1);
    setTranslationY(f2 + paramFloat2);
    Log.i("MicroMsg.WxImageView", "alvinluo translate x: %f, y: %f, x + dx: %f, y + dy: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f1 + paramFloat1), Float.valueOf(f2 + paramFloat2) });
    AppMethodBeat.o(142491);
  }
  
  public final float y(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205279);
    paramFloat1 = super.y(paramFloat1, paramFloat2);
    AppMethodBeat.o(205279);
    return paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.WxImageView
 * JD-Core Version:    0.7.0.1
 */