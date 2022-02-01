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
import com.tencent.mm.ah.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.i.b.a;
import com.tencent.mm.ui.i.b.c;

public class MultiTouchImageView
  extends ImageView
  implements i
{
  private i.a OUx;
  protected Bitmap QUQ;
  private boolean RrU;
  private float adVA;
  public float adVB;
  private boolean adVC;
  private float adVD;
  private float adVE;
  private a adVF;
  float adVG;
  public boolean adVH;
  public Drawable adVI;
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
  public boolean horizontalLong;
  private int imageHeight;
  private int imageWidth;
  protected MMHandler mHandler;
  private float mScreenExtraScale;
  protected Matrix mSuppMatrix;
  private int mbM;
  private int mbN;
  private Paint mzW;
  private boolean ojM;
  private float rPT;
  public boolean verticalLong;
  
  private MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(142343);
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
    this.adVA = 0.0F;
    this.adVB = 1.0F;
    this.adVC = false;
    this.horizontalLong = false;
    this.verticalLong = false;
    this.RrU = true;
    this.mzW = null;
    this.mHandler = new MMHandler();
    this.mScreenExtraScale = 1.0F;
    this.adVG = 0.0F;
    this.adVH = false;
    this.imageHeight = paramInt2;
    this.imageWidth = paramInt1;
    this.adVF = null;
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
    this.adVA = 0.0F;
    this.adVB = 1.0F;
    this.adVC = false;
    this.horizontalLong = false;
    this.verticalLong = false;
    this.RrU = true;
    this.mzW = null;
    this.mHandler = new MMHandler();
    this.mScreenExtraScale = 1.0F;
    this.adVG = 0.0F;
    this.adVH = false;
    this.imageHeight = 0;
    this.imageWidth = 0;
    init();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.MultiTouchImageView);
    try
    {
      setImageBackgroundColor(paramContext.getColor(a.m.MultiTouchImageView_imageBackgroundColor, 0));
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(142344);
    }
  }
  
  private void bM(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(142352);
    if ((this.QUQ == null) && (!this.adVH))
    {
      AppMethodBeat.o(142352);
      return;
    }
    if ((this.adVI == null) && (this.adVH))
    {
      AppMethodBeat.o(142352);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f4;
    if (this.adVH)
    {
      localRectF = new RectF(0.0F, 0.0F, this.adVI.getIntrinsicWidth(), this.adVI.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f4 = localRectF.width();
      if (!paramBoolean2) {
        break label296;
      }
      if (f1 >= this.mbN) {
        break label247;
      }
      f1 = (this.mbN - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label139:
      if (paramBoolean1) {
        if (f4 < this.mbM) {
          f2 = (this.mbM - f4) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        be(f2, f1);
        localMatrix = getImageViewMatrix();
        setImageMatrix(localMatrix);
        localMatrix.mapRect(localRectF);
        localRectF.height();
        localRectF.width();
        AppMethodBeat.o(142352);
        return;
        localRectF = new RectF(0.0F, 0.0F, this.QUQ.getWidth(), this.QUQ.getHeight());
        break;
        label247:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label139;
        }
        if (localRectF.bottom >= this.mbN) {
          break label519;
        }
        f1 = this.mbN - localRectF.bottom;
        break label139;
        label296:
        f1 = localRectF.top;
        float f5 = this.mbN - localRectF.bottom;
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
        if (localRectF.bottom >= this.mbN) {
          break label519;
        }
        f1 = f5 - f1;
        break label139;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.mbM)
        {
          f2 = this.mbM - localRectF.right;
          continue;
          f3 = localRectF.left;
          f5 = this.mbM - localRectF.right;
          f4 = (f3 + f5) / 2.0F;
          f3 = f4;
          if (f4 < 0.0F) {
            f3 = 0.0F;
          }
          if (localRectF.left > 0.0F) {
            f2 = f3 - localRectF.left;
          } else if (localRectF.right < this.mbM) {
            f2 = f5 - f3;
          }
        }
      }
      label519:
      f1 = 0.0F;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(142353);
    Log.d("dktest", "init screenWidth:" + this.mbM + " screenHeight :" + this.mbN);
    setScaleType(ImageView.ScaleType.MATRIX);
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.mScreenExtraScale = f;
    }
    jma();
    AppMethodBeat.o(142353);
  }
  
  private void jmV()
  {
    boolean bool2 = true;
    AppMethodBeat.i(251486);
    if (this.adVw != null)
    {
      this.adVv = this.adVw.floatValue();
      AppMethodBeat.o(251486);
      return;
    }
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
        if (f4 < 1.5F)
        {
          f2 = 2.5F;
          f1 = f4;
        }
      }
    }
    this.adVD = (this.mbM / this.imageWidth);
    this.adVE = (this.mbN / this.imageHeight);
    if (this.imageWidth > this.imageHeight * f2)
    {
      bool1 = true;
      this.horizontalLong = bool1;
      if (this.imageHeight <= this.imageWidth * f2) {
        break label286;
      }
      bool1 = true;
      label175:
      this.verticalLong = bool1;
      if ((!this.horizontalLong) || (this.imageWidth <= this.mbM)) {
        break label292;
      }
      bool1 = true;
      label202:
      this.horizontalLong = bool1;
      if ((!this.verticalLong) || (this.imageHeight <= this.mbN)) {
        break label298;
      }
    }
    label286:
    label292:
    label298:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.verticalLong = bool1;
      f3 = this.imageHeight / this.imageWidth;
      if ((f3 <= f1) || (f3 > f2)) {
        break label304;
      }
      this.adVv = (this.adVE * this.adVB);
      AppMethodBeat.o(251486);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label175;
      bool1 = false;
      break label202;
    }
    label304:
    this.adVv = (this.adVD * this.adVB);
    AppMethodBeat.o(251486);
  }
  
  private float k(Matrix paramMatrix)
  {
    AppMethodBeat.i(251490);
    if (paramMatrix != null)
    {
      paramMatrix.getValues(this.cia);
      float f = this.cia[0];
      AppMethodBeat.o(251490);
      return f;
    }
    AppMethodBeat.o(251490);
    return 0.0F;
  }
  
  private void y(final float paramFloat1, final float paramFloat2, final float paramFloat3)
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
        float f1 = Math.min(this.adVJ, (float)(l - l));
        float f2 = paramFloat1;
        float f3 = paramFloat2;
        MultiTouchImageView.this.x(f2 + f3 * f1, paramFloat3, this.hpT);
        MultiTouchImageView.this.jmb();
        if (f1 < this.adVJ) {
          MultiTouchImageView.this.mHandler.post(this);
        }
        AppMethodBeat.o(142339);
      }
    });
    AppMethodBeat.o(142361);
  }
  
  public final PointF a(PointF paramPointF, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251563);
    int i = this.imageWidth;
    int j = (int)(1.0F * this.imageWidth * paramInt2 / paramInt1);
    float f1 = paramPointF.x;
    float f2 = i;
    float f3 = paramPointF.y;
    float f4 = j;
    Log.v("MicroMsg.MultiTouchImageView", "mapPoint srcPoint: %s, width: %d, height: %d, viewWidth: %d, viewHeight: %d, targetWidth: %d, targetHeight: %d", new Object[] { paramPointF, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mbM), Integer.valueOf(this.mbN), Integer.valueOf(i), Integer.valueOf(j) });
    paramPointF = getImageViewMatrix();
    if (paramPointF != null)
    {
      float[] arrayOfFloat = new float[2];
      Log.v("MicroMsg.MultiTouchImageView", "mapPoint scaleRate: %s", new Object[] { Float.valueOf(this.adVv) });
      paramPointF.mapPoints(arrayOfFloat, new float[] { f1 * f2, f3 * f4 });
      paramPointF = new PointF(arrayOfFloat[0], arrayOfFloat[1]);
      AppMethodBeat.o(251563);
      return paramPointF;
    }
    AppMethodBeat.o(251563);
    return null;
  }
  
  public final float ag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(251526);
    this.adVt = getDoubleTabScale();
    y(this.adVt, paramFloat1, paramFloat2);
    paramFloat1 = this.adVt;
    AppMethodBeat.o(251526);
    return paramFloat1;
  }
  
  public final void bd(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142349);
    jmV();
    y(this.adVv, paramFloat1, paramFloat2);
    AppMethodBeat.o(142349);
  }
  
  public final void be(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142363);
    this.mSuppMatrix.postTranslate(paramFloat1, paramFloat2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(142363);
  }
  
  public final void bf(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(251530);
    jmV();
    this.adVv *= getOriginScale();
    y(this.adVv, paramFloat1, paramFloat2);
    jmb();
    AppMethodBeat.o(251530);
  }
  
  public final void bg(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(251534);
    jmV();
    this.adVv *= getOriginScale();
    y(this.adVv, paramFloat1, paramFloat2);
    jmb();
    AppMethodBeat.o(251534);
  }
  
  public final PointF c(PointF paramPointF)
  {
    AppMethodBeat.i(251567);
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
      AppMethodBeat.o(251567);
      return localObject1;
      label146:
      localObject2 = new float[2];
      Log.v("MicroMsg.MultiTouchImageView", "invertMapPoint scaleRate: %s", new Object[] { Float.valueOf(this.adVv) });
      ((Matrix)localObject1).mapPoints((float[])localObject2, new float[] { f1, f2 });
    }
  }
  
  public final void dU(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public final void dY(float paramFloat)
  {
    AppMethodBeat.i(251539);
    if (getScale() >= this.rPT)
    {
      AppMethodBeat.o(251539);
      return;
    }
    if (getScale() <= this.adVu)
    {
      AppMethodBeat.o(251539);
      return;
    }
    if ((this.QUQ == null) && (!this.adVH))
    {
      AppMethodBeat.o(251539);
      return;
    }
    if ((this.adVI == null) && (this.adVH))
    {
      AppMethodBeat.o(251539);
      return;
    }
    float f1 = this.mbM / 2.0F;
    float f2 = this.mbN / 2.0F;
    this.mSuppMatrix.postScale(paramFloat, paramFloat, f1, f2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(251539);
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
        f1 = getScaleRate() * this.adVx;
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
    this.adVq.set(this.adVp);
    this.adVq.postConcat(this.mSuppMatrix);
    Matrix localMatrix = this.adVq;
    AppMethodBeat.o(142355);
    return localMatrix;
  }
  
  public PointF getImageViewMatrixScale()
  {
    AppMethodBeat.i(251570);
    this.mSuppMatrix.getValues(this.cia);
    PointF localPointF = new PointF(this.cia[0], this.cia[4]);
    AppMethodBeat.o(251570);
    return localPointF;
  }
  
  public PointF getImageViewMatrixTranslation()
  {
    AppMethodBeat.i(251573);
    this.mSuppMatrix.getValues(this.cia);
    PointF localPointF = new PointF(this.cia[2], this.cia[5]);
    AppMethodBeat.o(251573);
    return localPointF;
  }
  
  public int getImageWidth()
  {
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
  
  public float getOriginScale()
  {
    return this.adVA;
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
    this.mSuppMatrix.getValues(this.cia);
    jmV();
    this.rPT = (this.adVz * this.mScreenExtraScale);
    this.adVu = (this.adVv * this.adVy);
    if (this.rPT < 1.0F) {
      this.rPT = 1.0F;
    }
    if (this.adVu > 1.0F) {
      this.adVu = 1.0F;
    }
    float f = this.cia[0];
    AppMethodBeat.o(142354);
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
    AppMethodBeat.i(142348);
    this.mSuppMatrix.reset();
    jmV();
    x(this.adVv, 0.0F, 0.0F);
    jmb();
    AppMethodBeat.o(142348);
  }
  
  public final void jmb()
  {
    boolean bool2 = true;
    AppMethodBeat.i(142356);
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
      AppMethodBeat.o(142356);
      return;
      bool1 = false;
      break;
      label49:
      bool2 = false;
    }
  }
  
  public final void jmc()
  {
    AppMethodBeat.i(142357);
    if ((this.adVC) && (0.0F == this.adVt)) {
      this.adVt = getDoubleTabScale();
    }
    AppMethodBeat.o(142357);
  }
  
  public final void jmd()
  {
    AppMethodBeat.i(251578);
    this.adVw = null;
    jmV();
    AppMethodBeat.o(251578);
  }
  
  public final void ok(int paramInt1, int paramInt2)
  {
    this.mbN = paramInt2;
    this.mbM = paramInt1;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.ojM = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142347);
    if ((!this.adVH) && (this.QUQ != null) && (this.QUQ.isRecycled()))
    {
      Log.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
      AppMethodBeat.o(142347);
      return;
    }
    if ((this.mzW != null) && (((this.adVH) && (this.adVI != null)) || (this.QUQ != null)))
    {
      Matrix localMatrix = getImageMatrix();
      if (localMatrix != null)
      {
        paramCanvas.save();
        paramCanvas.concat(localMatrix);
        if (!this.adVH) {
          break label168;
        }
        if ((this.adVI.getIntrinsicWidth() > 2) && (this.adVI.getIntrinsicHeight() > 2)) {
          paramCanvas.drawRect(1.0F, 1.0F, this.adVI.getIntrinsicWidth() - 1, this.adVI.getIntrinsicHeight() - 1, this.mzW);
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
      if ((this.QUQ.getWidth() > 2) && (this.QUQ.getHeight() > 2)) {
        paramCanvas.drawRect(1.0F, 1.0F, this.QUQ.getWidth() - 1, this.QUQ.getHeight() - 1, this.mzW);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(142350);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      g.n(paramKeyEvent);
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
    if ((paramInt == 4) && (g.o(paramKeyEvent)) && (!g.p(paramKeyEvent)) && (getScale() > 1.0F))
    {
      x(1.0F, this.mbM / 2.0F, this.mbN / 2.0F);
      jmb();
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
    if ((this.mbM != View.MeasureSpec.getSize(paramInt1)) || (this.mbN != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.hXM = true;; this.hXM = false)
    {
      this.mbM = View.MeasureSpec.getSize(paramInt1);
      this.mbN = View.MeasureSpec.getSize(paramInt2);
      if (!this.ojM)
      {
        this.ojM = true;
        init();
      }
      if ((this.hXM) && (this.canRefresh)) {
        jma();
      }
      AppMethodBeat.o(142345);
      return;
    }
  }
  
  public void setCanRefresh(boolean paramBoolean)
  {
    this.canRefresh = paramBoolean;
  }
  
  public void setCustomScaleRate(Float paramFloat)
  {
    AppMethodBeat.i(251576);
    this.adVw = paramFloat;
    if (paramFloat != null) {
      this.adVv = paramFloat.floatValue();
    }
    AppMethodBeat.o(251576);
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
    this.adVx = paramFloat;
    AppMethodBeat.o(142342);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.RrU = paramBoolean;
  }
  
  public void setGifDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142365);
    this.adVH = true;
    this.adVI = paramDrawable;
    setImageDrawable(this.adVI);
    AppMethodBeat.o(142365);
  }
  
  public void setGifPath(String paramString)
  {
    AppMethodBeat.i(142364);
    this.adVH = true;
    try
    {
      this.adVI = c.qd(paramString, paramString);
      setImageDrawable(this.adVI);
      if (this.adVI != null) {
        dU(this.adVI.getIntrinsicWidth(), this.adVI.getIntrinsicHeight());
      }
      AppMethodBeat.o(142364);
      return;
    }
    catch (Exception paramString)
    {
      this.adVH = false;
      AppMethodBeat.o(142364);
    }
  }
  
  public void setImageBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(251510);
    if (Color.alpha(paramInt) == 0) {
      this.mzW = null;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(251510);
      return;
      this.mzW = new Paint(1);
      this.mzW.setStyle(Paint.Style.FILL);
      this.mzW.setColor(paramInt);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142346);
    this.adVH = false;
    this.QUQ = paramBitmap;
    this.ojM = false;
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(142346);
  }
  
  public void setImageHeight(int paramInt)
  {
    this.imageHeight = paramInt;
  }
  
  public void setImageViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(251511);
    float f1 = k(getImageViewMatrix());
    this.mSuppMatrix.reset();
    this.mSuppMatrix.set(paramMatrix);
    float f2 = k(this.mSuppMatrix);
    setImageMatrix(getImageViewMatrix());
    if ((f2 != f1) && (this.OUx != null)) {
      this.OUx.onScaleChanged(f1, f2);
    }
    AppMethodBeat.o(251511);
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
    AppMethodBeat.i(142340);
    if (Float.compare(paramFloat, 1.0F) < 0)
    {
      Log.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
      AppMethodBeat.o(142340);
      return;
    }
    this.adVz = paramFloat;
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
    this.adVy = paramFloat;
    AppMethodBeat.o(142341);
  }
  
  public void setOnZoomScaleChangedListener(i.a parama)
  {
    this.OUx = parama;
  }
  
  public void setOriginScale(float paramFloat)
  {
    this.adVA = paramFloat;
  }
  
  public final void start()
  {
    AppMethodBeat.i(142366);
    if ((this.adVH) && (this.adVI != null)) {
      ((a)this.adVI).start();
    }
    AppMethodBeat.o(142366);
  }
  
  public final void x(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(142358);
    float f2 = getScale();
    float f1;
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
        break label144;
      }
      f1 = this.rPT * 2.0F + (paramFloat1 - this.rPT) * 0.1F;
    }
    for (;;)
    {
      paramFloat1 = f1 / f2;
      if (!this.adVH)
      {
        setImageMatrix(getImageViewMatrix());
        this.mSuppMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      if (this.OUx != null) {
        this.OUx.onScaleChanged(f2, f1);
      }
      AppMethodBeat.o(142358);
      return;
      f1 = this.adVt;
      break;
      label144:
      f1 = paramFloat1;
      if (paramFloat1 < this.adVu) {
        f1 = this.adVu;
      }
    }
  }
  
  public final void zoomToWithAnimation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(251518);
    y(paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(251518);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.MultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */