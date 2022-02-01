package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.g.b.a;
import com.tencent.mm.ui.g.b.c;

public class MultiTouchImageView
  extends ImageView
  implements g
{
  private g.a CIB;
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
  private float OUZ;
  public float OVa;
  private boolean OVb;
  private float OVc;
  private float OVd;
  private a OVe;
  float OVf;
  public boolean OVg;
  public Drawable OVh;
  public boolean aXp;
  public boolean aXq;
  protected Matrix aYH;
  private float aYU;
  private boolean dXX;
  private int gRD;
  private int gRE;
  private Paint hob;
  private boolean iCs;
  private int imageHeight;
  private int imageWidth;
  private float lPE;
  protected MMHandler mHandler;
  
  private MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(142343);
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
    this.OUZ = 0.0F;
    this.OVa = 1.0F;
    this.OVb = false;
    this.aXq = false;
    this.aXp = false;
    this.EEg = true;
    this.hob = null;
    this.mHandler = new MMHandler();
    this.aYU = 1.0F;
    this.OVf = 0.0F;
    this.OVg = false;
    this.imageHeight = paramInt2;
    this.imageWidth = paramInt1;
    this.OVe = null;
    init();
    AppMethodBeat.o(142343);
  }
  
  public MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2, byte paramByte)
  {
    this(paramContext, paramInt1, paramInt2);
  }
  
  public MultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private MultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142344);
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
    this.OUZ = 0.0F;
    this.OVa = 1.0F;
    this.OVb = false;
    this.aXq = false;
    this.aXp = false;
    this.EEg = true;
    this.hob = null;
    this.mHandler = new MMHandler();
    this.aYU = 1.0F;
    this.OVf = 0.0F;
    this.OVg = false;
    this.imageHeight = 0;
    this.imageWidth = 0;
    init();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MultiTouchImageView);
    try
    {
      setImageBackgroundColor(paramContext.getColor(0, 0));
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(142344);
    }
  }
  
  private void be(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(142352);
    if ((this.EiY == null) && (!this.OVg))
    {
      AppMethodBeat.o(142352);
      return;
    }
    if ((this.OVh == null) && (this.OVg))
    {
      AppMethodBeat.o(142352);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f4;
    if (this.OVg)
    {
      localRectF = new RectF(0.0F, 0.0F, this.OVh.getIntrinsicWidth(), this.OVh.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f4 = localRectF.width();
      if (!paramBoolean2) {
        break label296;
      }
      if (f1 >= this.gRE) {
        break label247;
      }
      f1 = (this.gRE - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label139:
      if (paramBoolean1) {
        if (f4 < this.gRD) {
          f2 = (this.gRD - f4) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        au(f2, f1);
        localMatrix = getImageViewMatrix();
        setImageMatrix(localMatrix);
        localMatrix.mapRect(localRectF);
        localRectF.height();
        localRectF.width();
        AppMethodBeat.o(142352);
        return;
        localRectF = new RectF(0.0F, 0.0F, this.EiY.getWidth(), this.EiY.getHeight());
        break;
        label247:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label139;
        }
        if (localRectF.bottom >= this.gRE) {
          break label519;
        }
        f1 = this.gRE - localRectF.bottom;
        break label139;
        label296:
        f1 = localRectF.top;
        float f5 = this.gRE - localRectF.bottom;
        float f3 = (f1 + f5) / 2.0F;
        f1 = f3;
        if (f3 < 0.0F) {
          f1 = 0.0F;
        }
        if (localRectF.top > 0.0F)
        {
          f1 -= localRectF.top;
          break label139;
        }
        if (localRectF.bottom >= this.gRE) {
          break label519;
        }
        f1 = f5 - f1;
        break label139;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.gRD)
        {
          f2 = this.gRD - localRectF.right;
          continue;
          f3 = localRectF.left;
          f5 = this.gRD - localRectF.right;
          f4 = (f3 + f5) / 2.0F;
          f3 = f4;
          if (f4 < 0.0F) {
            f3 = 0.0F;
          }
          if (localRectF.left > 0.0F) {
            f2 = f3 - localRectF.left;
          } else if (localRectF.right < this.gRD) {
            f2 = f5 - f3;
          }
        }
      }
      label519:
      f1 = 0.0F;
    }
  }
  
  private void gLq()
  {
    boolean bool2 = true;
    AppMethodBeat.i(205258);
    if (this.OUU != null)
    {
      this.OUT = this.OUU.floatValue();
      AppMethodBeat.o(205258);
      return;
    }
    this.OVc = (this.gRD / this.imageWidth);
    this.OVd = (this.gRE / this.imageHeight);
    if (this.imageWidth > this.imageHeight * 2.2F)
    {
      bool1 = true;
      this.aXq = bool1;
      if (this.imageHeight <= this.imageWidth * 2.2F) {
        break label257;
      }
      bool1 = true;
      label110:
      this.aXp = bool1;
      if ((!this.aXq) || (this.imageWidth <= this.gRD)) {
        break label263;
      }
      bool1 = true;
      label137:
      this.aXq = bool1;
      if ((!this.aXp) || (this.imageHeight <= this.gRE)) {
        break label269;
      }
    }
    label257:
    label263:
    label269:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aXp = bool1;
      float f3 = this.imageHeight / this.imageWidth;
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
        break label275;
      }
      this.OUT = (this.OVd * this.OVa);
      AppMethodBeat.o(205258);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label110;
      bool1 = false;
      break label137;
    }
    label275:
    this.OUT = (this.OVc * this.OVa);
    AppMethodBeat.o(205258);
  }
  
  private float i(Matrix paramMatrix)
  {
    AppMethodBeat.i(205260);
    if (paramMatrix != null)
    {
      paramMatrix.getValues(this.DZ);
      float f = this.DZ[0];
      AppMethodBeat.o(205260);
      return f;
    }
    AppMethodBeat.o(205260);
    return 0.0F;
  }
  
  private void init()
  {
    AppMethodBeat.i(142353);
    Log.d("dktest", "init screenWidth:" + this.gRD + " screenHeight :" + this.gRE);
    setScaleType(ImageView.ScaleType.MATRIX);
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.aYU = f;
    }
    gKy();
    AppMethodBeat.o(142353);
  }
  
  private void s(final float paramFloat1, final float paramFloat2, final float paramFloat3)
  {
    AppMethodBeat.i(142361);
    paramFloat1 = (paramFloat1 - getScale()) / 128.0F;
    float f = getScale();
    final long l = System.currentTimeMillis();
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142339);
        long l = System.currentTimeMillis();
        float f1 = Math.min(this.OVi, (float)(l - l));
        float f2 = paramFloat1;
        float f3 = paramFloat2;
        MultiTouchImageView.this.r(f2 + f3 * f1, paramFloat3, this.dsV);
        MultiTouchImageView.this.gKz();
        if (f1 < this.OVi) {
          MultiTouchImageView.this.mHandler.post(this);
        }
        AppMethodBeat.o(142339);
      }
    });
    AppMethodBeat.o(142361);
  }
  
  public final PointF a(PointF paramPointF, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205267);
    if (paramPointF == null)
    {
      AppMethodBeat.o(205267);
      return null;
    }
    int i = this.imageWidth;
    int j = (int)(1.0F * this.imageWidth * paramInt2 / paramInt1);
    float f1 = paramPointF.x;
    float f2 = i;
    float f3 = paramPointF.y;
    float f4 = j;
    Log.v("MicroMsg.MultiTouchImageView", "mapPoint srcPoint: %s, width: %d, height: %d, viewWidth: %d, viewHeight: %d, targetWidth: %d, targetHeight: %d", new Object[] { paramPointF, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.gRD), Integer.valueOf(this.gRE), Integer.valueOf(i), Integer.valueOf(j) });
    paramPointF = getImageViewMatrix();
    if (paramPointF != null)
    {
      float[] arrayOfFloat = new float[2];
      Log.v("MicroMsg.MultiTouchImageView", "mapPoint scaleRate: %s", new Object[] { Float.valueOf(this.OUT) });
      paramPointF.mapPoints(arrayOfFloat, new float[] { f1 * f2, f3 * f4 });
      paramPointF = new PointF(arrayOfFloat[0], arrayOfFloat[1]);
      AppMethodBeat.o(205267);
      return paramPointF;
    }
    AppMethodBeat.o(205267);
    return null;
  }
  
  public final void at(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142349);
    gLq();
    s(this.OUT, paramFloat1, paramFloat2);
    AppMethodBeat.o(142349);
  }
  
  public final void au(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142363);
    this.aYH.postTranslate(paramFloat1, paramFloat2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(142363);
  }
  
  public final void av(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205264);
    gLq();
    this.OUT *= getOriginScale();
    s(this.OUT, paramFloat1, paramFloat2);
    gKz();
    AppMethodBeat.o(205264);
  }
  
  public final void aw(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205265);
    gLq();
    this.OUT *= getOriginScale();
    s(this.OUT, paramFloat1, paramFloat2);
    gKz();
    AppMethodBeat.o(205265);
  }
  
  public final PointF c(PointF paramPointF)
  {
    AppMethodBeat.i(205268);
    float f1 = paramPointF.x;
    float f2 = paramPointF.y;
    Object localObject2 = getImageViewMatrix();
    if (localObject2 != null)
    {
      localObject1 = new Matrix();
      if (((Matrix)localObject2).invert((Matrix)localObject1)) {
        break label146;
      }
      Log.e("MicroMsg.MultiTouchImageView", "invertMapPoint invert matrix failed");
    }
    for (Object localObject1 = null;; localObject1 = new PointF(localObject2[0], localObject2[1]))
    {
      if (localObject1 != null)
      {
        ((PointF)localObject1).x /= this.imageWidth;
        ((PointF)localObject1).y /= this.imageHeight;
        Log.i("MicroMsg.MultiTouchImageView", "alvinluo convertScreenToImageCoordinate screenCoordinate: %s, imageCoordinate: %s, imageWidth: %s, imageHeight: %s", new Object[] { paramPointF, localObject1, Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageHeight) });
      }
      AppMethodBeat.o(205268);
      return localObject1;
      label146:
      localObject2 = new float[2];
      Log.v("MicroMsg.MultiTouchImageView", "invertMapPoint scaleRate: %s", new Object[] { Float.valueOf(this.OUT) });
      ((Matrix)localObject1).mapPoints((float[])localObject2, new float[] { f1, f2 });
    }
  }
  
  public final void cN(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public final void cs(float paramFloat)
  {
    AppMethodBeat.i(205266);
    if (getScale() >= this.lPE)
    {
      AppMethodBeat.o(205266);
      return;
    }
    if (getScale() <= this.OUS)
    {
      AppMethodBeat.o(205266);
      return;
    }
    if ((this.EiY == null) && (!this.OVg))
    {
      AppMethodBeat.o(205266);
      return;
    }
    if ((this.OVh == null) && (this.OVg))
    {
      AppMethodBeat.o(205266);
      return;
    }
    float f1 = this.gRD / 2.0F;
    float f2 = this.gRE / 2.0F;
    this.aYH.postScale(paramFloat, paramFloat, f1, f2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(205266);
  }
  
  public final void gKA()
  {
    AppMethodBeat.i(142357);
    if ((this.OVb) && (0.0F == this.OUR)) {
      this.OUR = getDoubleTabScale();
    }
    AppMethodBeat.o(142357);
  }
  
  public final void gKB()
  {
    AppMethodBeat.i(205272);
    this.OUU = null;
    gLq();
    AppMethodBeat.o(205272);
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
    AppMethodBeat.i(142348);
    this.aYH.reset();
    gLq();
    r(this.OUT, 0.0F, 0.0F);
    gKz();
    AppMethodBeat.o(142348);
  }
  
  public final void gKz()
  {
    boolean bool2 = true;
    AppMethodBeat.i(142356);
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
      AppMethodBeat.o(142356);
      return;
      bool1 = false;
      break;
      label49:
      bool2 = false;
    }
  }
  
  public float getDoubleTabScale()
  {
    AppMethodBeat.i(142359);
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
      AppMethodBeat.o(142359);
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
    return this.imageHeight;
  }
  
  protected Matrix getImageViewMatrix()
  {
    AppMethodBeat.i(142355);
    this.OUO.set(this.OUN);
    this.OUO.postConcat(this.aYH);
    Matrix localMatrix = this.OUO;
    AppMethodBeat.o(142355);
    return localMatrix;
  }
  
  public PointF getImageViewMatrixScale()
  {
    AppMethodBeat.i(205269);
    this.aYH.getValues(this.DZ);
    PointF localPointF = new PointF(this.DZ[0], this.DZ[4]);
    AppMethodBeat.o(205269);
    return localPointF;
  }
  
  public PointF getImageViewMatrixTranslation()
  {
    AppMethodBeat.i(205270);
    this.aYH.getValues(this.DZ);
    PointF localPointF = new PointF(this.DZ[2], this.DZ[5]);
    AppMethodBeat.o(205270);
    return localPointF;
  }
  
  public int getImageWidth()
  {
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
  
  public float getOriginScale()
  {
    return this.OUZ;
  }
  
  public float getRealWidth()
  {
    AppMethodBeat.i(142362);
    float f1 = getScale();
    float f2 = getImageWidth();
    AppMethodBeat.o(142362);
    return f1 * f2;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(142354);
    this.aYH.getValues(this.DZ);
    gLq();
    this.lPE = (this.OUY * this.aYU);
    this.OUS = (this.OUT * this.OUX);
    if (this.lPE < 1.0F) {
      this.lPE = 1.0F;
    }
    if (this.OUS > 1.0F) {
      this.OUS = 1.0F;
    }
    float f = this.DZ[0];
    AppMethodBeat.o(142354);
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
  
  public final void kY(int paramInt1, int paramInt2)
  {
    this.gRE = paramInt2;
    this.gRD = paramInt1;
  }
  
  public final void l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(205262);
    s(paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(205262);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.iCs = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142347);
    if ((!this.OVg) && (this.EiY != null) && (this.EiY.isRecycled()))
    {
      Log.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
      AppMethodBeat.o(142347);
      return;
    }
    if ((this.hob != null) && (((this.OVg) && (this.OVh != null)) || (this.EiY != null)))
    {
      Matrix localMatrix = getImageMatrix();
      if (localMatrix != null)
      {
        paramCanvas.save();
        paramCanvas.concat(localMatrix);
        if (!this.OVg) {
          break label168;
        }
        if ((this.OVh.getIntrinsicWidth() > 2) && (this.OVh.getIntrinsicHeight() > 2)) {
          paramCanvas.drawRect(1.0F, 1.0F, this.OVh.getIntrinsicWidth() - 1, this.OVh.getIntrinsicHeight() - 1, this.hob);
        }
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      super.onDraw(paramCanvas);
      AppMethodBeat.o(142347);
      return;
      label168:
      if ((this.EiY.getWidth() > 2) && (this.EiY.getHeight() > 2)) {
        paramCanvas.drawRect(1.0F, 1.0F, this.EiY.getWidth() - 1, this.EiY.getHeight() - 1, this.hob);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(142350);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      f.f(paramKeyEvent);
      AppMethodBeat.o(142350);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(142350);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(142351);
    if ((paramInt == 4) && (f.g(paramKeyEvent)) && (!f.h(paramKeyEvent)) && (getScale() > 1.0F))
    {
      r(1.0F, this.gRD / 2.0F, this.gRE / 2.0F);
      gKz();
      AppMethodBeat.o(142351);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(142351);
    return bool;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142345);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.gRD != View.MeasureSpec.getSize(paramInt1)) || (this.gRE != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.dXX = true;; this.dXX = false)
    {
      this.gRD = View.MeasureSpec.getSize(paramInt1);
      this.gRE = View.MeasureSpec.getSize(paramInt2);
      if (!this.iCs)
      {
        this.iCs = true;
        init();
      }
      if ((this.dXX) && (this.OUV)) {
        gKy();
      }
      AppMethodBeat.o(142345);
      return;
    }
  }
  
  public final void r(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(142358);
    float f2 = getScale();
    float f1;
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
        break label144;
      }
      f1 = this.lPE * 2.0F + (paramFloat1 - this.lPE) * 0.1F;
    }
    for (;;)
    {
      paramFloat1 = f1 / f2;
      if (!this.OVg)
      {
        setImageMatrix(getImageViewMatrix());
        this.aYH.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      if (this.CIB != null) {
        this.CIB.aj(f2, f1);
      }
      AppMethodBeat.o(142358);
      return;
      f1 = this.OUR;
      break;
      label144:
      f1 = paramFloat1;
      if (paramFloat1 < this.OUS) {
        f1 = this.OUS;
      }
    }
  }
  
  public void setCanRefresh(boolean paramBoolean)
  {
    this.OUV = paramBoolean;
  }
  
  public void setCustomScaleRate(Float paramFloat)
  {
    AppMethodBeat.i(205271);
    this.OUU = paramFloat;
    if (paramFloat != null) {
      this.OUT = paramFloat.floatValue();
    }
    AppMethodBeat.o(205271);
  }
  
  public void setDoubleTabScaleLimit(float paramFloat)
  {
    AppMethodBeat.i(142342);
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      Log.w("MicroMsg.MultiTouchImageView", "double tab scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142342);
      return;
    }
    this.OUW = paramFloat;
    AppMethodBeat.o(142342);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.EEg = paramBoolean;
  }
  
  public void setGifDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142365);
    this.OVg = true;
    this.OVh = paramDrawable;
    setImageDrawable(this.OVh);
    AppMethodBeat.o(142365);
  }
  
  public void setGifPath(String paramString)
  {
    AppMethodBeat.i(142364);
    this.OVg = true;
    try
    {
      this.OVh = c.nl(paramString, paramString);
      setImageDrawable(this.OVh);
      if (this.OVh != null) {
        cN(this.OVh.getIntrinsicWidth(), this.OVh.getIntrinsicHeight());
      }
      AppMethodBeat.o(142364);
      return;
    }
    catch (Exception paramString)
    {
      this.OVg = false;
      AppMethodBeat.o(142364);
    }
  }
  
  public void setImageBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(205259);
    if (Color.alpha(paramInt) == 0) {
      this.hob = null;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(205259);
      return;
      this.hob = new Paint(1);
      this.hob.setStyle(Paint.Style.FILL);
      this.hob.setColor(paramInt);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142346);
    this.OVg = false;
    this.EiY = paramBitmap;
    this.iCs = false;
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(142346);
  }
  
  public void setImageHeight(int paramInt)
  {
    this.imageHeight = paramInt;
  }
  
  public void setImageViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(205261);
    float f1 = i(getImageViewMatrix());
    this.aYH.reset();
    this.aYH.set(paramMatrix);
    float f2 = i(this.aYH);
    setImageMatrix(getImageViewMatrix());
    if ((f2 != f1) && (this.CIB != null)) {
      this.CIB.aj(f1, f2);
    }
    AppMethodBeat.o(205261);
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
    AppMethodBeat.i(142340);
    if (Float.compare(paramFloat, 1.0F) < 0)
    {
      Log.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
      AppMethodBeat.o(142340);
      return;
    }
    this.OUY = paramFloat;
    AppMethodBeat.o(142340);
  }
  
  public void setMinZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(142341);
    if (Float.compare(paramFloat, 1.0F) > 0)
    {
      Log.w("MicroMsg.MultiTouchImageView", "min scale limit is greater than 1.0, change nothing, return");
      AppMethodBeat.o(142341);
      return;
    }
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      Log.w("MicroMsg.MultiTouchImageView", "min scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142341);
      return;
    }
    this.OUX = paramFloat;
    AppMethodBeat.o(142341);
  }
  
  public void setOnZoomScaleChangedListener(g.a parama)
  {
    this.CIB = parama;
  }
  
  public void setOriginScale(float paramFloat)
  {
    this.OUZ = paramFloat;
  }
  
  public final void start()
  {
    AppMethodBeat.i(142366);
    if ((this.OVg) && (this.OVh != null)) {
      ((a)this.OVh).start();
    }
    AppMethodBeat.o(142366);
  }
  
  public final float y(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205263);
    this.OUR = getDoubleTabScale();
    s(this.OUR, paramFloat1, paramFloat2);
    paramFloat1 = this.OUR;
    AppMethodBeat.o(205263);
    return paramFloat1;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */