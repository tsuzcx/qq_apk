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
import com.tencent.mm.ui.h.b.a;
import com.tencent.mm.ui.h.b.c;

public class MultiTouchImageView
  extends ImageView
  implements g
{
  private g.a INs;
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
  private float Wol;
  public float Wom;
  private boolean Won;
  private float Woo;
  private float Wop;
  private a Woq;
  float Wor;
  public boolean Wos;
  public Drawable Wot;
  public boolean aGJ;
  public boolean aGK;
  private boolean aHd;
  protected Matrix aId;
  private float aIq;
  private final float[] atr;
  private boolean fRO;
  private int imageHeight;
  private int imageWidth;
  private int jBZ;
  private int jCa;
  private Paint jZS;
  private boolean lsn;
  protected MMHandler mHandler;
  private float oLY;
  
  private MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(142343);
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
    this.Wol = 0.0F;
    this.Wom = 1.0F;
    this.Won = false;
    this.aGK = false;
    this.aGJ = false;
    this.KRV = true;
    this.jZS = null;
    this.mHandler = new MMHandler();
    this.aIq = 1.0F;
    this.Wor = 0.0F;
    this.Wos = false;
    this.imageHeight = paramInt2;
    this.imageWidth = paramInt1;
    this.Woq = null;
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
    this.Wol = 0.0F;
    this.Wom = 1.0F;
    this.Won = false;
    this.aGK = false;
    this.aGJ = false;
    this.KRV = true;
    this.jZS = null;
    this.mHandler = new MMHandler();
    this.aIq = 1.0F;
    this.Wor = 0.0F;
    this.Wos = false;
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
  
  private void bo(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(142352);
    if ((this.Kwh == null) && (!this.Wos))
    {
      AppMethodBeat.o(142352);
      return;
    }
    if ((this.Wot == null) && (this.Wos))
    {
      AppMethodBeat.o(142352);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f4;
    if (this.Wos)
    {
      localRectF = new RectF(0.0F, 0.0F, this.Wot.getIntrinsicWidth(), this.Wot.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f4 = localRectF.width();
      if (!paramBoolean2) {
        break label296;
      }
      if (f1 >= this.jCa) {
        break label247;
      }
      f1 = (this.jCa - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label139:
      if (paramBoolean1) {
        if (f4 < this.jBZ) {
          f2 = (this.jBZ - f4) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        az(f2, f1);
        localMatrix = getImageViewMatrix();
        setImageMatrix(localMatrix);
        localMatrix.mapRect(localRectF);
        localRectF.height();
        localRectF.width();
        AppMethodBeat.o(142352);
        return;
        localRectF = new RectF(0.0F, 0.0F, this.Kwh.getWidth(), this.Kwh.getHeight());
        break;
        label247:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label139;
        }
        if (localRectF.bottom >= this.jCa) {
          break label519;
        }
        f1 = this.jCa - localRectF.bottom;
        break label139;
        label296:
        f1 = localRectF.top;
        float f5 = this.jCa - localRectF.bottom;
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
        if (localRectF.bottom >= this.jCa) {
          break label519;
        }
        f1 = f5 - f1;
        break label139;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.jBZ)
        {
          f2 = this.jBZ - localRectF.right;
          continue;
          f3 = localRectF.left;
          f5 = this.jBZ - localRectF.right;
          f4 = (f3 + f5) / 2.0F;
          f3 = f4;
          if (f4 < 0.0F) {
            f3 = 0.0F;
          }
          if (localRectF.left > 0.0F) {
            f2 = f3 - localRectF.left;
          } else if (localRectF.right < this.jBZ) {
            f2 = f5 - f3;
          }
        }
      }
      label519:
      f1 = 0.0F;
    }
  }
  
  private void hKp()
  {
    boolean bool2 = true;
    AppMethodBeat.i(222582);
    if (this.Woh != null)
    {
      this.Wog = this.Woh.floatValue();
      AppMethodBeat.o(222582);
      return;
    }
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
        if (f4 < 1.5F)
        {
          f2 = 2.5F;
          f1 = f4;
        }
      }
    }
    this.Woo = (this.jBZ / this.imageWidth);
    this.Wop = (this.jCa / this.imageHeight);
    if (this.imageWidth > this.imageHeight * f2)
    {
      bool1 = true;
      this.aGK = bool1;
      if (this.imageHeight <= this.imageWidth * f2) {
        break label283;
      }
      bool1 = true;
      label173:
      this.aGJ = bool1;
      if ((!this.aGK) || (this.imageWidth <= this.jBZ)) {
        break label289;
      }
      bool1 = true;
      label200:
      this.aGK = bool1;
      if ((!this.aGJ) || (this.imageHeight <= this.jCa)) {
        break label295;
      }
    }
    label283:
    label289:
    label295:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aGJ = bool1;
      f3 = this.imageHeight / this.imageWidth;
      if ((f3 <= f1) || (f3 > f2)) {
        break label301;
      }
      this.Wog = (this.Wop * this.Wom);
      AppMethodBeat.o(222582);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label173;
      bool1 = false;
      break label200;
    }
    label301:
    this.Wog = (this.Woo * this.Wom);
    AppMethodBeat.o(222582);
  }
  
  private float i(Matrix paramMatrix)
  {
    AppMethodBeat.i(222624);
    if (paramMatrix != null)
    {
      paramMatrix.getValues(this.atr);
      float f = this.atr[0];
      AppMethodBeat.o(222624);
      return f;
    }
    AppMethodBeat.o(222624);
    return 0.0F;
  }
  
  private void init()
  {
    AppMethodBeat.i(142353);
    Log.d("dktest", "init screenWidth:" + this.jBZ + " screenHeight :" + this.jCa);
    setScaleType(ImageView.ScaleType.MATRIX);
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.aIq = f;
    }
    hJx();
    AppMethodBeat.o(142353);
  }
  
  private void t(final float paramFloat1, final float paramFloat2, final float paramFloat3)
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
        float f1 = Math.min(this.Wou, (float)(l - l));
        float f2 = paramFloat1;
        float f3 = paramFloat2;
        MultiTouchImageView.this.s(f2 + f3 * f1, paramFloat3, this.flG);
        MultiTouchImageView.this.hJy();
        if (f1 < this.Wou) {
          MultiTouchImageView.this.mHandler.post(this);
        }
        AppMethodBeat.o(142339);
      }
    });
    AppMethodBeat.o(142361);
  }
  
  public final float A(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222640);
    this.Woe = getDoubleTabScale();
    t(this.Woe, paramFloat1, paramFloat2);
    paramFloat1 = this.Woe;
    AppMethodBeat.o(222640);
    return paramFloat1;
  }
  
  public final PointF a(PointF paramPointF, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222665);
    int i = this.imageWidth;
    int j = (int)(1.0F * this.imageWidth * paramInt2 / paramInt1);
    float f1 = paramPointF.x;
    float f2 = i;
    float f3 = paramPointF.y;
    float f4 = j;
    Log.v("MicroMsg.MultiTouchImageView", "mapPoint srcPoint: %s, width: %d, height: %d, viewWidth: %d, viewHeight: %d, targetWidth: %d, targetHeight: %d", new Object[] { paramPointF, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.jBZ), Integer.valueOf(this.jCa), Integer.valueOf(i), Integer.valueOf(j) });
    paramPointF = getImageViewMatrix();
    if (paramPointF != null)
    {
      float[] arrayOfFloat = new float[2];
      Log.v("MicroMsg.MultiTouchImageView", "mapPoint scaleRate: %s", new Object[] { Float.valueOf(this.Wog) });
      paramPointF.mapPoints(arrayOfFloat, new float[] { f1 * f2, f3 * f4 });
      paramPointF = new PointF(arrayOfFloat[0], arrayOfFloat[1]);
      AppMethodBeat.o(222665);
      return paramPointF;
    }
    AppMethodBeat.o(222665);
    return null;
  }
  
  public final void aA(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222644);
    hKp();
    this.Wog *= getOriginScale();
    t(this.Wog, paramFloat1, paramFloat2);
    hJy();
    AppMethodBeat.o(222644);
  }
  
  public final void aB(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222647);
    hKp();
    this.Wog *= getOriginScale();
    t(this.Wog, paramFloat1, paramFloat2);
    hJy();
    AppMethodBeat.o(222647);
  }
  
  public final void ay(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142349);
    hKp();
    t(this.Wog, paramFloat1, paramFloat2);
    AppMethodBeat.o(142349);
  }
  
  public final void az(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142363);
    this.aId.postTranslate(paramFloat1, paramFloat2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(142363);
  }
  
  public final void cK(float paramFloat)
  {
    AppMethodBeat.i(222654);
    if (getScale() >= this.oLY)
    {
      AppMethodBeat.o(222654);
      return;
    }
    if (getScale() <= this.Wof)
    {
      AppMethodBeat.o(222654);
      return;
    }
    if ((this.Kwh == null) && (!this.Wos))
    {
      AppMethodBeat.o(222654);
      return;
    }
    if ((this.Wot == null) && (this.Wos))
    {
      AppMethodBeat.o(222654);
      return;
    }
    float f1 = this.jBZ / 2.0F;
    float f2 = this.jCa / 2.0F;
    this.aId.postScale(paramFloat, paramFloat, f1, f2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(222654);
  }
  
  public final PointF d(PointF paramPointF)
  {
    AppMethodBeat.i(222669);
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
      AppMethodBeat.o(222669);
      return localObject1;
      label146:
      localObject2 = new float[2];
      Log.v("MicroMsg.MultiTouchImageView", "invertMapPoint scaleRate: %s", new Object[] { Float.valueOf(this.Wog) });
      ((Matrix)localObject1).mapPoints((float[])localObject2, new float[] { f1, f2 });
    }
  }
  
  public final void di(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
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
        f1 = getScaleRate() * this.Woi;
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
    this.Wob.set(this.Woa);
    this.Wob.postConcat(this.aId);
    Matrix localMatrix = this.Wob;
    AppMethodBeat.o(142355);
    return localMatrix;
  }
  
  public PointF getImageViewMatrixScale()
  {
    AppMethodBeat.i(222671);
    this.aId.getValues(this.atr);
    PointF localPointF = new PointF(this.atr[0], this.atr[4]);
    AppMethodBeat.o(222671);
    return localPointF;
  }
  
  public PointF getImageViewMatrixTranslation()
  {
    AppMethodBeat.i(222674);
    this.aId.getValues(this.atr);
    PointF localPointF = new PointF(this.atr[2], this.atr[5]);
    AppMethodBeat.o(222674);
    return localPointF;
  }
  
  public int getImageWidth()
  {
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
  
  public float getOriginScale()
  {
    return this.Wol;
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
    this.aId.getValues(this.atr);
    hKp();
    this.oLY = (this.Wok * this.aIq);
    this.Wof = (this.Wog * this.Woj);
    if (this.oLY < 1.0F) {
      this.oLY = 1.0F;
    }
    if (this.Wof > 1.0F) {
      this.Wof = 1.0F;
    }
    float f = this.atr[0];
    AppMethodBeat.o(142354);
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
    AppMethodBeat.i(222678);
    this.Woh = null;
    hKp();
    AppMethodBeat.o(222678);
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
    AppMethodBeat.i(142348);
    this.aId.reset();
    hKp();
    s(this.Wog, 0.0F, 0.0F);
    hJy();
    AppMethodBeat.o(142348);
  }
  
  public final void hJy()
  {
    boolean bool2 = true;
    AppMethodBeat.i(142356);
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
      AppMethodBeat.o(142356);
      return;
      bool1 = false;
      break;
      label49:
      bool2 = false;
    }
  }
  
  public final void hJz()
  {
    AppMethodBeat.i(142357);
    if ((this.Won) && (0.0F == this.Woe)) {
      this.Woe = getDoubleTabScale();
    }
    AppMethodBeat.o(142357);
  }
  
  public final void m(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(222634);
    t(paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(222634);
  }
  
  public final void mq(int paramInt1, int paramInt2)
  {
    this.jCa = paramInt2;
    this.jBZ = paramInt1;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.lsn = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142347);
    if ((!this.Wos) && (this.Kwh != null) && (this.Kwh.isRecycled()))
    {
      Log.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
      AppMethodBeat.o(142347);
      return;
    }
    if ((this.jZS != null) && (((this.Wos) && (this.Wot != null)) || (this.Kwh != null)))
    {
      Matrix localMatrix = getImageMatrix();
      if (localMatrix != null)
      {
        paramCanvas.save();
        paramCanvas.concat(localMatrix);
        if (!this.Wos) {
          break label168;
        }
        if ((this.Wot.getIntrinsicWidth() > 2) && (this.Wot.getIntrinsicHeight() > 2)) {
          paramCanvas.drawRect(1.0F, 1.0F, this.Wot.getIntrinsicWidth() - 1, this.Wot.getIntrinsicHeight() - 1, this.jZS);
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
      if ((this.Kwh.getWidth() > 2) && (this.Kwh.getHeight() > 2)) {
        paramCanvas.drawRect(1.0F, 1.0F, this.Kwh.getWidth() - 1, this.Kwh.getHeight() - 1, this.jZS);
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
      s(1.0F, this.jBZ / 2.0F, this.jCa / 2.0F);
      hJy();
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
    if ((this.jBZ != View.MeasureSpec.getSize(paramInt1)) || (this.jCa != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.fRO = true;; this.fRO = false)
    {
      this.jBZ = View.MeasureSpec.getSize(paramInt1);
      this.jCa = View.MeasureSpec.getSize(paramInt2);
      if (!this.lsn)
      {
        this.lsn = true;
        init();
      }
      if ((this.fRO) && (this.aHd)) {
        hJx();
      }
      AppMethodBeat.o(142345);
      return;
    }
  }
  
  public final void s(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(142358);
    float f2 = getScale();
    float f1;
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
        break label144;
      }
      f1 = this.oLY * 2.0F + (paramFloat1 - this.oLY) * 0.1F;
    }
    for (;;)
    {
      paramFloat1 = f1 / f2;
      if (!this.Wos)
      {
        setImageMatrix(getImageViewMatrix());
        this.aId.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      if (this.INs != null) {
        this.INs.ak(f2, f1);
      }
      AppMethodBeat.o(142358);
      return;
      f1 = this.Woe;
      break;
      label144:
      f1 = paramFloat1;
      if (paramFloat1 < this.Wof) {
        f1 = this.Wof;
      }
    }
  }
  
  public void setCanRefresh(boolean paramBoolean)
  {
    this.aHd = paramBoolean;
  }
  
  public void setCustomScaleRate(Float paramFloat)
  {
    AppMethodBeat.i(222676);
    this.Woh = paramFloat;
    if (paramFloat != null) {
      this.Wog = paramFloat.floatValue();
    }
    AppMethodBeat.o(222676);
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
    this.Woi = paramFloat;
    AppMethodBeat.o(142342);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.KRV = paramBoolean;
  }
  
  public void setGifDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142365);
    this.Wos = true;
    this.Wot = paramDrawable;
    setImageDrawable(this.Wot);
    AppMethodBeat.o(142365);
  }
  
  public void setGifPath(String paramString)
  {
    AppMethodBeat.i(142364);
    this.Wos = true;
    try
    {
      this.Wot = c.of(paramString, paramString);
      setImageDrawable(this.Wot);
      if (this.Wot != null) {
        di(this.Wot.getIntrinsicWidth(), this.Wot.getIntrinsicHeight());
      }
      AppMethodBeat.o(142364);
      return;
    }
    catch (Exception paramString)
    {
      this.Wos = false;
      AppMethodBeat.o(142364);
    }
  }
  
  public void setImageBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(222618);
    if (Color.alpha(paramInt) == 0) {
      this.jZS = null;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(222618);
      return;
      this.jZS = new Paint(1);
      this.jZS.setStyle(Paint.Style.FILL);
      this.jZS.setColor(paramInt);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142346);
    this.Wos = false;
    this.Kwh = paramBitmap;
    this.lsn = false;
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(142346);
  }
  
  public void setImageHeight(int paramInt)
  {
    this.imageHeight = paramInt;
  }
  
  public void setImageViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(222628);
    float f1 = i(getImageViewMatrix());
    this.aId.reset();
    this.aId.set(paramMatrix);
    float f2 = i(this.aId);
    setImageMatrix(getImageViewMatrix());
    if ((f2 != f1) && (this.INs != null)) {
      this.INs.ak(f1, f2);
    }
    AppMethodBeat.o(222628);
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
    AppMethodBeat.i(142340);
    if (Float.compare(paramFloat, 1.0F) < 0)
    {
      Log.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
      AppMethodBeat.o(142340);
      return;
    }
    this.Wok = paramFloat;
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
    this.Woj = paramFloat;
    AppMethodBeat.o(142341);
  }
  
  public void setOnZoomScaleChangedListener(g.a parama)
  {
    this.INs = parama;
  }
  
  public void setOriginScale(float paramFloat)
  {
    this.Wol = paramFloat;
  }
  
  public final void start()
  {
    AppMethodBeat.i(142366);
    if ((this.Wos) && (this.Wot != null)) {
      ((a)this.Wot).start();
    }
    AppMethodBeat.o(142366);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */