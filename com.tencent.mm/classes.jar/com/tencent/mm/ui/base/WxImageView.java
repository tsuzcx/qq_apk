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
  private int FO;
  private boolean KRV;
  protected Bitmap Kwh;
  protected Matrix Woa;
  private final Matrix Wob;
  int Woc;
  int Wod;
  private float Woe;
  private float Wof;
  private float Wog;
  private Float Woh;
  private float Woi;
  private float Woj;
  private float Wok;
  private boolean Won;
  private float Woo;
  private float Wop;
  private boolean Wos;
  private Drawable Wot;
  private boolean aGJ;
  private boolean aGK;
  private boolean aHd;
  protected Matrix aId;
  private float aIq;
  private final float[] atr;
  private boolean fRO;
  private int jBZ;
  private int jCa;
  private boolean lsn;
  protected MMHandler mHandler;
  private float oLY;
  
  public WxImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(213661);
    this.Woa = new Matrix();
    this.aId = new Matrix();
    this.Wob = new Matrix();
    this.atr = new float[9];
    this.Kwh = null;
    this.Woc = -1;
    this.Wod = -1;
    this.Woe = 0.0F;
    this.oLY = 0.0F;
    this.Wof = 0.0F;
    this.lsn = false;
    this.fRO = false;
    this.aHd = true;
    this.Woi = 2.0F;
    this.Woj = 0.75F;
    this.Wok = 20.0F;
    this.Won = false;
    this.aGK = false;
    this.aGJ = false;
    this.KRV = true;
    this.Wos = false;
    this.mHandler = new MMHandler();
    this.aIq = 1.0F;
    AppMethodBeat.o(213661);
  }
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142468);
    this.Woa = new Matrix();
    this.aId = new Matrix();
    this.Wob = new Matrix();
    this.atr = new float[9];
    this.Kwh = null;
    this.Woc = -1;
    this.Wod = -1;
    this.Woe = 0.0F;
    this.oLY = 0.0F;
    this.Wof = 0.0F;
    this.lsn = false;
    this.fRO = false;
    this.aHd = true;
    this.Woi = 2.0F;
    this.Woj = 0.75F;
    this.Wok = 20.0F;
    this.Won = false;
    this.aGK = false;
    this.aGJ = false;
    this.KRV = true;
    this.Wos = false;
    this.mHandler = new MMHandler();
    this.aIq = 1.0F;
    initView();
    AppMethodBeat.o(142468);
  }
  
  public WxImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142469);
    this.Woa = new Matrix();
    this.aId = new Matrix();
    this.Wob = new Matrix();
    this.atr = new float[9];
    this.Kwh = null;
    this.Woc = -1;
    this.Wod = -1;
    this.Woe = 0.0F;
    this.oLY = 0.0F;
    this.Wof = 0.0F;
    this.lsn = false;
    this.fRO = false;
    this.aHd = true;
    this.Woi = 2.0F;
    this.Woj = 0.75F;
    this.Wok = 20.0F;
    this.Won = false;
    this.aGK = false;
    this.aGJ = false;
    this.KRV = true;
    this.Wos = false;
    this.mHandler = new MMHandler();
    this.aIq = 1.0F;
    initView();
    AppMethodBeat.o(142469);
  }
  
  private void bo(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(142482);
    if ((this.Wot == null) && (this.Wos))
    {
      AppMethodBeat.o(142482);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f3;
    if (this.Wos)
    {
      localRectF = new RectF(0.0F, 0.0F, this.Wot.getIntrinsicWidth(), this.Wot.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f3 = localRectF.width();
      if (!paramBoolean2) {
        break label248;
      }
      if (f1 >= this.jCa) {
        break label199;
      }
      f1 = (this.jCa - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label119:
      if (paramBoolean1) {
        if (f3 < this.jBZ) {
          f2 = (this.jBZ - f3) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        az(f2, f1);
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
        if (localRectF.bottom >= this.jCa) {
          break label399;
        }
        f1 = this.jCa - localRectF.bottom;
        break label119;
        label248:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label119;
        }
        if (localRectF.bottom >= this.jCa) {
          break label399;
        }
        f1 = this.jCa - localRectF.bottom;
        break label119;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.jBZ)
        {
          f2 = this.jBZ - localRectF.right;
          continue;
          if (localRectF.left > 0.0F) {
            f2 = -localRectF.left;
          } else if (localRectF.right < this.jBZ) {
            f2 = this.jBZ - localRectF.right;
          }
        }
      }
      label399:
      f1 = 0.0F;
    }
  }
  
  private void hKp()
  {
    AppMethodBeat.i(142479);
    if (this.Woh != null)
    {
      this.Wog = this.Woh.floatValue();
      AppMethodBeat.o(142479);
      return;
    }
    int i = getImageWidth();
    int j = getImageHeight();
    float f3 = 2.2F;
    float f4 = 1.8F;
    float f1 = f4;
    float f2 = f3;
    if (this.jBZ != 0)
    {
      f1 = f4;
      f2 = f3;
      if (this.jCa != 0)
      {
        f4 = this.jCa / this.jBZ;
        f1 = f4;
        f2 = f3;
        if (f4 < 1.5D)
        {
          f2 = 2.5F;
          f1 = f4;
        }
      }
    }
    this.Woo = (this.jBZ / i);
    this.Wop = (this.jCa / j);
    boolean bool;
    if (i > j * f2)
    {
      bool = true;
      this.aGK = bool;
      if (j <= i * f2) {
        break label367;
      }
      bool = true;
      label168:
      this.aGJ = bool;
      if ((!this.aGK) || (i <= this.jBZ)) {
        break label373;
      }
      bool = true;
      label193:
      this.aGK = bool;
      if ((!this.aGJ) || (j <= this.jCa)) {
        break label379;
      }
      bool = true;
      label218:
      this.aGJ = bool;
      f3 = j / i;
      if ((f3 <= f1) || (f3 > f2)) {
        break label385;
      }
    }
    label385:
    for (this.Wog = this.Wop;; this.Wog = this.Woo)
    {
      Log.i("MicroMsg.WxImageView", "imgWidth:%s, imgHeight:%s, viewWidth:%s, viewHeight:%s, verticalLong:%b, horizontalLong:%b, scale:%s, viewScale:%s, scaleRate:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.jBZ), Integer.valueOf(this.jCa), Boolean.valueOf(this.aGJ), Boolean.valueOf(this.aGK), Float.valueOf(f3), Float.valueOf(f1), Float.valueOf(this.Wog) });
      setScaleRate(this.Wog);
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
  
  private void initView()
  {
    AppMethodBeat.i(213671);
    a(new WxImageView.1(this));
    AppMethodBeat.o(213671);
  }
  
  public final float A(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(213710);
    paramFloat1 = super.A(paramFloat1, paramFloat2);
    AppMethodBeat.o(213710);
    return paramFloat1;
  }
  
  public final PointF a(PointF paramPointF, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213720);
    int i = getImageWidth();
    int j = (int)(1.0F * i * paramInt2 / paramInt1);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (paramPointF.x * i);
    arrayOfFloat[1] = (paramPointF.y * j);
    Log.v("MicroMsg.WxImageView", "mapPoint srcPoint: %s, width: %d, height: %d, viewWidth: %d, viewHeight: %d, targetWidth: %d, targetHeight: %d", new Object[] { paramPointF, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.jBZ), Integer.valueOf(this.jCa), Integer.valueOf(i), Integer.valueOf(j) });
    if (this.jWm != null)
    {
      paramPointF = this.jWm;
      paramPointF = new PointF(paramPointF.K(arrayOfFloat[0]), paramPointF.L(arrayOfFloat[1]));
      AppMethodBeat.o(213720);
      return paramPointF;
    }
    AppMethodBeat.o(213720);
    return null;
  }
  
  public final void aC(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142491);
    float f1 = getTranslationX();
    float f2 = getTranslationY();
    setTranslationX(f1 + paramFloat1);
    setTranslationY(f2 + paramFloat2);
    Log.i("MicroMsg.WxImageView", "alvinluo translate x: %f, y: %f, x + dx: %f, y + dy: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f1 + paramFloat1), Float.valueOf(f2 + paramFloat2) });
    AppMethodBeat.o(142491);
  }
  
  public final void ay(final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(142477);
    hKp();
    final float f1 = (this.Wog - getScale()) / 128.0F;
    float f2 = getScale();
    final long l = System.currentTimeMillis();
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193808);
        long l = System.currentTimeMillis();
        float f1 = Math.min(this.Wou, (float)(l - l));
        float f2 = f1;
        float f3 = paramFloat1;
        WxImageView.this.s(f2 + f3 * f1, paramFloat2, this.flG);
        if (f1 < this.Wou) {
          WxImageView.this.mHandler.post(this);
        }
        AppMethodBeat.o(193808);
      }
    });
    AppMethodBeat.o(142477);
  }
  
  public final void az(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142490);
    Log.d("MicroMsg.WxImageView", "alvinluo WxImageView postTranslate dx: %f, dy: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.aId.postTranslate(paramFloat1, paramFloat2);
    AppMethodBeat.o(142490);
  }
  
  public final PointF d(PointF paramPointF)
  {
    float f3 = 0.0F;
    AppMethodBeat.i(213725);
    int i = getImageWidth();
    int j = getImageHeight();
    Object localObject = new float[2];
    localObject[0] = paramPointF.x;
    localObject[1] = paramPointF.y;
    SubsamplingScaleImageView localSubsamplingScaleImageView;
    float f1;
    float f2;
    if (this.jWm != null)
    {
      localSubsamplingScaleImageView = this.jWm;
      f1 = localObject[0];
      if (localSubsamplingScaleImageView.aHj == null)
      {
        f1 = 0.0F;
        f2 = localObject[1];
        if (localSubsamplingScaleImageView.aHj != null) {
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
      AppMethodBeat.o(213725);
      return localObject;
      f2 = (f1 - localSubsamplingScaleImageView.aHj.x) / localSubsamplingScaleImageView.scale;
      if (!Float.isNaN(f2))
      {
        f1 = f2;
        if (!Float.isInfinite(f2)) {
          break;
        }
      }
      f1 = 0.0F;
      break;
      float f4 = (f2 - localSubsamplingScaleImageView.aHj.y) / localSubsamplingScaleImageView.scale;
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
    if (!this.lsn)
    {
      AppMethodBeat.o(142475);
      return 0;
    }
    float f1 = this.Wog;
    float f2 = this.imageWidth;
    int j = (int)((this.jBZ - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Log.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageWidth: %d, viewWidth: %d, left: %d", new Object[] { Float.valueOf(this.Wog), Integer.valueOf(this.imageWidth), Integer.valueOf(this.jBZ), Integer.valueOf(i) });
    AppMethodBeat.o(142475);
    return i;
  }
  
  public int getContentTop()
  {
    AppMethodBeat.i(142474);
    if (!this.lsn)
    {
      AppMethodBeat.o(142474);
      return 0;
    }
    float f1 = this.Wog;
    float f2 = getImageHeight();
    int j = (int)((this.jCa - f1 * f2) / 2.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Log.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageHeight: %d, viewHeight: %d, top: %d", new Object[] { Float.valueOf(this.Wog), Integer.valueOf(getImageHeight()), Integer.valueOf(this.jCa), Integer.valueOf(i) });
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
        f1 = getScaleRate() * this.Woi;
      }
    }
  }
  
  public int getImageHeight()
  {
    if ((this.FO == 90) || (this.FO == 270)) {
      return this.imageWidth;
    }
    return this.imageHeight;
  }
  
  public Matrix getImageMatrix()
  {
    AppMethodBeat.i(142492);
    this.Wob.set(this.Woa);
    this.Wob.postConcat(this.aId);
    Matrix localMatrix = this.Wob;
    AppMethodBeat.o(142492);
    return localMatrix;
  }
  
  protected Matrix getImageViewMatrix()
  {
    AppMethodBeat.i(142484);
    this.Wob.set(this.Woa);
    this.Wob.postConcat(this.aId);
    Matrix localMatrix = this.Wob;
    AppMethodBeat.o(142484);
    return localMatrix;
  }
  
  public PointF getImageViewMatrixScale()
  {
    AppMethodBeat.i(213729);
    PointF localPointF = super.getImageViewMatrixScale();
    AppMethodBeat.o(213729);
    return localPointF;
  }
  
  public PointF getImageViewMatrixTranslation()
  {
    AppMethodBeat.i(213733);
    PointF localPointF = super.getImageViewMatrixTranslation();
    AppMethodBeat.o(213733);
    return localPointF;
  }
  
  public int getImageWidth()
  {
    if ((this.FO == 90) || (this.FO == 270)) {
      return this.imageHeight;
    }
    return this.imageWidth;
  }
  
  public float getMaxZoom()
  {
    return this.oLY;
  }
  
  public float getMinZoom()
  {
    return this.Wof;
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
    return this.Wop;
  }
  
  public float getScaleRate()
  {
    return this.Wog;
  }
  
  public float getScaleWidth()
  {
    return this.Woo;
  }
  
  public final void hJA()
  {
    AppMethodBeat.i(213748);
    this.Woh = null;
    hKp();
    AppMethodBeat.o(213748);
  }
  
  public final boolean hJv()
  {
    return this.aGK;
  }
  
  public final boolean hJw()
  {
    return this.aGJ;
  }
  
  public final void hJx()
  {
    AppMethodBeat.i(142476);
    Log.d("MicroMsg.WxImageView", "alvinluo adaptViewSize");
    this.aId.reset();
    hKp();
    aFa();
    s(this.Wog, 0.0F, 0.0F);
    AppMethodBeat.o(142476);
  }
  
  public final void hJy()
  {
    boolean bool2 = true;
    AppMethodBeat.i(164159);
    boolean bool1;
    if ((!this.KRV) || (!this.aGK))
    {
      bool1 = true;
      if (this.aGJ) {
        break label49;
      }
    }
    for (;;)
    {
      bo(bool1, bool2);
      AppMethodBeat.o(164159);
      return;
      bool1 = false;
      break;
      label49:
      bool2 = false;
    }
  }
  
  public final void hJz()
  {
    AppMethodBeat.i(142485);
    if ((this.Won) && (0.0F == this.Woe)) {
      this.Woe = getDoubleTabScale();
    }
    AppMethodBeat.o(142485);
  }
  
  public final void m(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(213736);
    super.m(paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(213736);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.lsn = false;
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
      s(1.0F, this.jBZ / 2.0F, this.jCa / 2.0F);
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
    if ((this.jBZ != View.MeasureSpec.getSize(paramInt1)) || (this.jCa != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.fRO = true;; this.fRO = false)
    {
      this.jBZ = View.MeasureSpec.getSize(paramInt1);
      this.jCa = View.MeasureSpec.getSize(paramInt2);
      if (!this.lsn)
      {
        this.lsn = true;
        this.Wos = false;
        Log.d("MicroMsg.WxImageView", "init screenWidth:" + this.jBZ + " screenHeight :" + this.jCa);
        float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
        if (f > 1.0F) {
          this.aIq = f;
        }
        hJx();
      }
      if ((this.fRO) && (this.aHd)) {
        hJx();
      }
      AppMethodBeat.o(142473);
      return;
    }
  }
  
  public final void s(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(142486);
    float f2 = getScale();
    float f1;
    label78:
    boolean bool1;
    if (this.Won)
    {
      if (0.0F == this.Woe)
      {
        f1 = this.Wok * this.aIq;
        this.oLY = f1;
      }
    }
    else
    {
      if (paramFloat1 <= this.oLY * 2.0F) {
        break label206;
      }
      f1 = this.oLY * 2.0F + (paramFloat1 - this.oLY) * 0.1F;
      paramFloat1 = f1 / f2;
      Log.d("MicroMsg.WxImageView", "alvinluo zoomTo mzdt=%f,mz=%f,scale=%f,oldScale=%f,deltaScale=%f", new Object[] { Float.valueOf(this.Woe), Float.valueOf(this.oLY), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramFloat1) });
      if (!this.Wos) {
        this.aId.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      if ((this.KRV) && (this.aGK)) {
        break label227;
      }
      bool1 = true;
      label175:
      if (this.aGJ) {
        break label233;
      }
    }
    for (;;)
    {
      bo(bool1, bool2);
      AppMethodBeat.o(142486);
      return;
      f1 = this.Woe;
      break;
      label206:
      f1 = paramFloat1;
      if (paramFloat1 >= this.Wof) {
        break label78;
      }
      f1 = this.Wof;
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
    AppMethodBeat.i(213754);
    super.setAllowInterceptTouchEvent(paramBoolean);
    AppMethodBeat.o(213754);
  }
  
  public void setCanRefresh(boolean paramBoolean)
  {
    AppMethodBeat.i(213739);
    super.setCanRefresh(paramBoolean);
    AppMethodBeat.o(213739);
  }
  
  public void setCustomScaleRate(Float paramFloat)
  {
    AppMethodBeat.i(213744);
    if (paramFloat != null)
    {
      this.Woh = paramFloat;
      super.setCustomScaleRate(paramFloat);
      AppMethodBeat.o(213744);
      return;
    }
    hJA();
    AppMethodBeat.o(213744);
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
    this.Woi = paramFloat;
    AppMethodBeat.o(142472);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.KRV = paramBoolean;
  }
  
  public void setImageHeight(int paramInt)
  {
    this.imageHeight = paramInt;
  }
  
  public void setImageViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(213705);
    super.setImageViewMatrix(paramMatrix);
    AppMethodBeat.o(213705);
  }
  
  public void setImageWidth(int paramInt)
  {
    this.imageWidth = paramInt;
  }
  
  public void setMaxZoomDoubleTab(boolean paramBoolean)
  {
    this.Won = paramBoolean;
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
    this.Wok = paramFloat;
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
    this.Woj = paramFloat;
    AppMethodBeat.o(142471);
  }
  
  public void setOnZoomScaleChangedListener(final g.a parama)
  {
    AppMethodBeat.i(213752);
    if (parama != null)
    {
      super.setOnZoomScaleChangedListener(new SubsamplingScaleImageView.f()
      {
        public final void o(float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          AppMethodBeat.i(195169);
          parama.ak(paramAnonymousFloat2, paramAnonymousFloat1);
          AppMethodBeat.o(195169);
        }
      });
      AppMethodBeat.o(213752);
      return;
    }
    super.setOnZoomScaleChangedListener(null);
    AppMethodBeat.o(213752);
  }
  
  public void setOrientation(int paramInt)
  {
    AppMethodBeat.i(142478);
    this.FO = paramInt;
    hKp();
    AppMethodBeat.o(142478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.WxImageView
 * JD-Core Version:    0.7.0.1
 */