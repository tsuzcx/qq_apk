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
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.OnStateChangedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.ui.WxBaseImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class WxImageView
  extends WxBaseImageView
  implements i
{
  protected Bitmap QUQ;
  private boolean RrU;
  private boolean adVC;
  private float adVD;
  private float adVE;
  private boolean adVH;
  private Drawable adVI;
  protected Matrix adVp;
  private final Matrix adVq;
  int adVr;
  int adVs;
  private float adVt;
  private float adVu;
  private float adVv;
  private Float adVw;
  private float adVx;
  private float adVy;
  private float adVz;
  private boolean canRefresh;
  private final float[] cia;
  private boolean hXM;
  private boolean horizontalLong;
  protected MMHandler mHandler;
  private float mScreenExtraScale;
  protected Matrix mSuppMatrix;
  private int mbM;
  private int mbN;
  private boolean ojM;
  private int orientation;
  private float rPT;
  private boolean verticalLong;
  
  public WxImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(251324);
    this.adVp = new Matrix();
    this.mSuppMatrix = new Matrix();
    this.adVq = new Matrix();
    this.cia = new float[9];
    this.QUQ = null;
    this.adVr = -1;
    this.adVs = -1;
    this.adVt = 0.0F;
    this.rPT = 0.0F;
    this.adVu = 0.0F;
    this.ojM = false;
    this.hXM = false;
    this.canRefresh = true;
    this.adVx = 2.0F;
    this.adVy = 0.75F;
    this.adVz = 20.0F;
    this.adVC = false;
    this.horizontalLong = false;
    this.verticalLong = false;
    this.RrU = true;
    this.adVH = false;
    this.mHandler = new MMHandler();
    this.mScreenExtraScale = 1.0F;
    AppMethodBeat.o(251324);
  }
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142468);
    this.adVp = new Matrix();
    this.mSuppMatrix = new Matrix();
    this.adVq = new Matrix();
    this.cia = new float[9];
    this.QUQ = null;
    this.adVr = -1;
    this.adVs = -1;
    this.adVt = 0.0F;
    this.rPT = 0.0F;
    this.adVu = 0.0F;
    this.ojM = false;
    this.hXM = false;
    this.canRefresh = true;
    this.adVx = 2.0F;
    this.adVy = 0.75F;
    this.adVz = 20.0F;
    this.adVC = false;
    this.horizontalLong = false;
    this.verticalLong = false;
    this.RrU = true;
    this.adVH = false;
    this.mHandler = new MMHandler();
    this.mScreenExtraScale = 1.0F;
    initView();
    AppMethodBeat.o(142468);
  }
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142469);
    this.adVp = new Matrix();
    this.mSuppMatrix = new Matrix();
    this.adVq = new Matrix();
    this.cia = new float[9];
    this.QUQ = null;
    this.adVr = -1;
    this.adVs = -1;
    this.adVt = 0.0F;
    this.rPT = 0.0F;
    this.adVu = 0.0F;
    this.ojM = false;
    this.hXM = false;
    this.canRefresh = true;
    this.adVx = 2.0F;
    this.adVy = 0.75F;
    this.adVz = 20.0F;
    this.adVC = false;
    this.horizontalLong = false;
    this.verticalLong = false;
    this.RrU = true;
    this.adVH = false;
    this.mHandler = new MMHandler();
    this.mScreenExtraScale = 1.0F;
    initView();
    AppMethodBeat.o(142469);
  }
  
  private void bM(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(142482);
    if ((this.adVI == null) && (this.adVH))
    {
      AppMethodBeat.o(142482);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f3;
    if (this.adVH)
    {
      localRectF = new RectF(0.0F, 0.0F, this.adVI.getIntrinsicWidth(), this.adVI.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f3 = localRectF.width();
      if (!paramBoolean2) {
        break label248;
      }
      if (f1 >= this.mbN) {
        break label199;
      }
      f1 = (this.mbN - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label119:
      if (paramBoolean1) {
        if (f3 < this.mbM) {
          f2 = (this.mbM - f3) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        be(f2, f1);
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
        if (localRectF.bottom >= this.mbN) {
          break label399;
        }
        f1 = this.mbN - localRectF.bottom;
        break label119;
        label248:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label119;
        }
        if (localRectF.bottom >= this.mbN) {
          break label399;
        }
        f1 = this.mbN - localRectF.bottom;
        break label119;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.mbM)
        {
          f2 = this.mbM - localRectF.right;
          continue;
          if (localRectF.left > 0.0F) {
            f2 = -localRectF.left;
          } else if (localRectF.right < this.mbM) {
            f2 = this.mbM - localRectF.right;
          }
        }
      }
      label399:
      f1 = 0.0F;
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(251331);
    addOnTouchListener(new WxImageView.1(this));
    AppMethodBeat.o(251331);
  }
  
  private void jmV()
  {
    AppMethodBeat.i(142479);
    if (this.adVw != null)
    {
      this.adVv = this.adVw.floatValue();
      AppMethodBeat.o(142479);
      return;
    }
    int i = getImageWidth();
    int j = getImageHeight();
    float f3 = 2.2F;
    float f4 = 1.8F;
    float f1 = f4;
    float f2 = f3;
    if (this.mbM != 0)
    {
      f1 = f4;
      f2 = f3;
      if (this.mbN != 0)
      {
        f4 = this.mbN / this.mbM;
        f1 = f4;
        f2 = f3;
        if (f4 < 1.5D)
        {
          f2 = 2.5F;
          f1 = f4;
        }
      }
    }
    this.adVD = (this.mbM / i);
    this.adVE = (this.mbN / j);
    boolean bool;
    if (i > j * f2)
    {
      bool = true;
      this.horizontalLong = bool;
      if (j <= i * f2) {
        break label367;
      }
      bool = true;
      label168:
      this.verticalLong = bool;
      if ((!this.horizontalLong) || (i <= this.mbM)) {
        break label373;
      }
      bool = true;
      label193:
      this.horizontalLong = bool;
      if ((!this.verticalLong) || (j <= this.mbN)) {
        break label379;
      }
      bool = true;
      label218:
      this.verticalLong = bool;
      f3 = j / i;
      if ((f3 <= f1) || (f3 > f2)) {
        break label385;
      }
    }
    label385:
    for (this.adVv = this.adVE;; this.adVv = this.adVD)
    {
      Log.i("MicroMsg.WxImageView", "imgWidth:%s, imgHeight:%s, viewWidth:%s, viewHeight:%s, verticalLong:%b, horizontalLong:%b, scale:%s, viewScale:%s, scaleRate:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.mbM), Integer.valueOf(this.mbN), Boolean.valueOf(this.verticalLong), Boolean.valueOf(this.horizontalLong), Float.valueOf(f3), Float.valueOf(f1), Float.valueOf(this.adVv) });
      setScaleRate(this.adVv);
      AppMethodBeat.o(142479);
      return;
      bool = false;
      break;
      label367:
      bool = false;
      break label168;
      label373:
      bool = false;
      break label193;
      label379:
      bool = false;
      break label218;
    }
  }
  
  public final void A(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142491);
    float f1 = getTranslationX();
    float f2 = getTranslationY();
    setTranslationX(f1 + paramFloat1);
    setTranslationY(f2 + paramFloat2);
    Log.i("MicroMsg.WxImageView", "alvinluo translate x: %f, y: %f, x + dx: %f, y + dy: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f1 + paramFloat1), Float.valueOf(f2 + paramFloat2) });
    AppMethodBeat.o(142491);
  }
  
  public final PointF a(PointF paramPointF, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251399);
    int i = getImageWidth();
    int j = (int)(1.0F * i * paramInt2 / paramInt1);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (paramPointF.x * i);
    arrayOfFloat[1] = (paramPointF.y * j);
    Log.v("MicroMsg.WxImageView", "mapPoint srcPoint: %s, width: %d, height: %d, viewWidth: %d, viewHeight: %d, targetWidth: %d, targetHeight: %d", new Object[] { paramPointF, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mbM), Integer.valueOf(this.mbN), Integer.valueOf(i), Integer.valueOf(j) });
    if (this.mwg != null)
    {
      paramPointF = this.mwg;
      paramPointF = new PointF(paramPointF.sourceToViewX(arrayOfFloat[0]), paramPointF.sourceToViewY(arrayOfFloat[1]));
      AppMethodBeat.o(251399);
      return paramPointF;
    }
    AppMethodBeat.o(251399);
    return null;
  }
  
  public final float ag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(251389);
    paramFloat1 = super.ag(paramFloat1, paramFloat2);
    AppMethodBeat.o(251389);
    return paramFloat1;
  }
  
  public final void bd(final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(142477);
    jmV();
    final float f1 = (this.adVv - getScale()) / 128.0F;
    float f2 = getScale();
    final long l = System.currentTimeMillis();
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(251284);
        long l = System.currentTimeMillis();
        float f1 = Math.min(this.adVJ, (float)(l - l));
        float f2 = f1;
        float f3 = paramFloat1;
        WxImageView.this.x(f2 + f3 * f1, paramFloat2, this.hpT);
        if (f1 < this.adVJ) {
          WxImageView.this.mHandler.post(this);
        }
        AppMethodBeat.o(251284);
      }
    });
    AppMethodBeat.o(142477);
  }
  
  public final void be(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142490);
    Log.d("MicroMsg.WxImageView", "alvinluo WxImageView postTranslate dx: %f, dy: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.mSuppMatrix.postTranslate(paramFloat1, paramFloat2);
    AppMethodBeat.o(142490);
  }
  
  public final PointF c(PointF paramPointF)
  {
    float f3 = 0.0F;
    AppMethodBeat.i(251400);
    int i = getImageWidth();
    int j = getImageHeight();
    Object localObject = new float[2];
    localObject[0] = paramPointF.x;
    localObject[1] = paramPointF.y;
    SubsamplingScaleImageView localSubsamplingScaleImageView;
    float f1;
    float f2;
    if (this.mwg != null)
    {
      localSubsamplingScaleImageView = this.mwg;
      f1 = localObject[0];
      if (localSubsamplingScaleImageView.vTranslate == null)
      {
        f1 = 0.0F;
        f2 = localObject[1];
        if (localSubsamplingScaleImageView.vTranslate != null) {
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
      AppMethodBeat.o(251400);
      return localObject;
      f2 = (f1 - localSubsamplingScaleImageView.vTranslate.x) / localSubsamplingScaleImageView.scale;
      if (!Float.isNaN(f2))
      {
        f1 = f2;
        if (!Float.isInfinite(f2)) {
          break;
        }
      }
      f1 = 0.0F;
      break;
      float f4 = (f2 - localSubsamplingScaleImageView.vTranslate.y) / localSubsamplingScaleImageView.scale;
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
  
  public int getContentLeft()
  {
    AppMethodBeat.i(142475);
    if (!this.ojM)
    {
      AppMethodBeat.o(142475);
      return 0;
    }
    float f1 = this.adVv;
    float f2 = this.imageWidth;
    int j = (int)((this.mbM - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Log.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageWidth: %d, viewWidth: %d, left: %d", new Object[] { Float.valueOf(this.adVv), Integer.valueOf(this.imageWidth), Integer.valueOf(this.mbM), Integer.valueOf(i) });
    AppMethodBeat.o(142475);
    return i;
  }
  
  public int getContentTop()
  {
    AppMethodBeat.i(142474);
    if (!this.ojM)
    {
      AppMethodBeat.o(142474);
      return 0;
    }
    float f1 = this.adVv;
    float f2 = getImageHeight();
    int j = (int)((this.mbN - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Log.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageHeight: %d, viewHeight: %d, top: %d", new Object[] { Float.valueOf(this.adVv), Integer.valueOf(getImageHeight()), Integer.valueOf(this.mbN), Integer.valueOf(i) });
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
        f1 = getScaleRate() * this.adVx;
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
    this.adVq.set(this.adVp);
    this.adVq.postConcat(this.mSuppMatrix);
    Matrix localMatrix = this.adVq;
    AppMethodBeat.o(142492);
    return localMatrix;
  }
  
  protected Matrix getImageViewMatrix()
  {
    AppMethodBeat.i(142484);
    this.adVq.set(this.adVp);
    this.adVq.postConcat(this.mSuppMatrix);
    Matrix localMatrix = this.adVq;
    AppMethodBeat.o(142484);
    return localMatrix;
  }
  
  public PointF getImageViewMatrixScale()
  {
    AppMethodBeat.i(251401);
    PointF localPointF = super.getImageViewMatrixScale();
    AppMethodBeat.o(251401);
    return localPointF;
  }
  
  public PointF getImageViewMatrixTranslation()
  {
    AppMethodBeat.i(251402);
    PointF localPointF = super.getImageViewMatrixTranslation();
    AppMethodBeat.o(251402);
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
    return this.rPT;
  }
  
  public float getMinZoom()
  {
    return this.adVu;
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
    return this.adVE;
  }
  
  public float getScaleRate()
  {
    return this.adVv;
  }
  
  public float getScaleWidth()
  {
    return this.adVD;
  }
  
  public final boolean jlY()
  {
    return this.horizontalLong;
  }
  
  public final boolean jlZ()
  {
    return this.verticalLong;
  }
  
  public final void jma()
  {
    AppMethodBeat.i(142476);
    Log.d("MicroMsg.WxImageView", "alvinluo adaptViewSize");
    this.mSuppMatrix.reset();
    jmV();
    resetSize();
    x(this.adVv, 0.0F, 0.0F);
    AppMethodBeat.o(142476);
  }
  
  public final void jmb()
  {
    boolean bool2 = true;
    AppMethodBeat.i(164159);
    boolean bool1;
    if ((!this.RrU) || (!this.horizontalLong))
    {
      bool1 = true;
      if (this.verticalLong) {
        break label49;
      }
    }
    for (;;)
    {
      bM(bool1, bool2);
      AppMethodBeat.o(164159);
      return;
      bool1 = false;
      break;
      label49:
      bool2 = false;
    }
  }
  
  public final void jmc()
  {
    AppMethodBeat.i(142485);
    if ((this.adVC) && (0.0F == this.adVt)) {
      this.adVt = getDoubleTabScale();
    }
    AppMethodBeat.o(142485);
  }
  
  public final void jmd()
  {
    AppMethodBeat.i(251408);
    this.adVw = null;
    jmV();
    AppMethodBeat.o(251408);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.ojM = false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(142480);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      g.n(paramKeyEvent);
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
    if ((paramInt == 4) && (g.o(paramKeyEvent)) && (!g.p(paramKeyEvent)) && (getScale() > 1.0F))
    {
      x(1.0F, this.mbM / 2.0F, this.mbN / 2.0F);
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
    if ((this.mbM != View.MeasureSpec.getSize(paramInt1)) || (this.mbN != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.hXM = true;; this.hXM = false)
    {
      this.mbM = View.MeasureSpec.getSize(paramInt1);
      this.mbN = View.MeasureSpec.getSize(paramInt2);
      if (!this.ojM)
      {
        this.ojM = true;
        this.adVH = false;
        Log.d("MicroMsg.WxImageView", "init screenWidth:" + this.mbM + " screenHeight :" + this.mbN);
        float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
        if (f > 1.0F) {
          this.mScreenExtraScale = f;
        }
        jma();
      }
      if ((this.hXM) && (this.canRefresh)) {
        jma();
      }
      AppMethodBeat.o(142473);
      return;
    }
  }
  
  public void setAllowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(251413);
    super.setAllowInterceptTouchEvent(paramBoolean);
    AppMethodBeat.o(251413);
  }
  
  public void setCanRefresh(boolean paramBoolean)
  {
    AppMethodBeat.i(251404);
    super.setCanRefresh(paramBoolean);
    AppMethodBeat.o(251404);
  }
  
  public void setCustomScaleRate(Float paramFloat)
  {
    AppMethodBeat.i(251406);
    if (paramFloat != null)
    {
      this.adVw = paramFloat;
      super.setCustomScaleRate(paramFloat);
      AppMethodBeat.o(251406);
      return;
    }
    jmd();
    AppMethodBeat.o(251406);
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
    this.adVx = paramFloat;
    AppMethodBeat.o(142472);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.RrU = paramBoolean;
  }
  
  public void setImageHeight(int paramInt)
  {
    this.imageHeight = paramInt;
  }
  
  public void setImageViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(251382);
    super.setImageViewMatrix(paramMatrix);
    AppMethodBeat.o(251382);
  }
  
  public void setImageWidth(int paramInt)
  {
    this.imageWidth = paramInt;
  }
  
  public void setMaxZoomDoubleTab(boolean paramBoolean)
  {
    this.adVC = paramBoolean;
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
    this.adVz = paramFloat;
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
    this.adVy = paramFloat;
    AppMethodBeat.o(142471);
  }
  
  public void setOnZoomScaleChangedListener(final i.a parama)
  {
    AppMethodBeat.i(251412);
    if (parama != null)
    {
      super.setOnZoomScaleChangedListener(new SubsamplingScaleImageView.OnStateChangedListener()
      {
        public final void bv(float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(369633);
          parama.onScaleChanged(paramAnonymousFloat2, paramAnonymousFloat1);
          AppMethodBeat.o(369633);
        }
      });
      AppMethodBeat.o(251412);
      return;
    }
    super.setOnZoomScaleChangedListener(null);
    AppMethodBeat.o(251412);
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(142478);
    this.orientation = paramInt;
    jmV();
    AppMethodBeat.o(142478);
  }
  
  public final void x(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(142486);
    float f2 = getScale();
    float f1;
    label78:
    boolean bool1;
    if (this.adVC)
    {
      if (0.0F == this.adVt)
      {
        f1 = this.adVz * this.mScreenExtraScale;
        this.rPT = f1;
      }
    }
    else
    {
      if (paramFloat1 <= this.rPT * 2.0F) {
        break label206;
      }
      f1 = this.rPT * 2.0F + (paramFloat1 - this.rPT) * 0.1F;
      paramFloat1 = f1 / f2;
      Log.d("MicroMsg.WxImageView", "alvinluo zoomTo mzdt=%f,mz=%f,scale=%f,oldScale=%f,deltaScale=%f", new Object[] { Float.valueOf(this.adVt), Float.valueOf(this.rPT), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramFloat1) });
      if (!this.adVH) {
        this.mSuppMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      if ((this.RrU) && (this.horizontalLong)) {
        break label227;
      }
      bool1 = true;
      label175:
      if (this.verticalLong) {
        break label233;
      }
    }
    for (;;)
    {
      bM(bool1, bool2);
      AppMethodBeat.o(142486);
      return;
      f1 = this.adVt;
      break;
      label206:
      f1 = paramFloat1;
      if (paramFloat1 >= this.adVu) {
        break label78;
      }
      f1 = this.adVu;
      break label78;
      label227:
      bool1 = false;
      break label175;
      label233:
      bool2 = false;
    }
  }
  
  public final void zoomToWithAnimation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(251403);
    super.zoomToWithAnimation(paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(251403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.WxImageView
 * JD-Core Version:    0.7.0.1
 */