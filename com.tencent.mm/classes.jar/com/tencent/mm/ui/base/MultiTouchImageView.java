package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.f.b.a;
import com.tencent.mm.ui.f.b.c;

public class MultiTouchImageView
  extends ImageView
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
  private float GbJ;
  private boolean GbK;
  public boolean GbL;
  public boolean GbM;
  private float GbN;
  private float GbO;
  private a GbP;
  float GbQ;
  public boolean GbR;
  public Drawable GbS;
  protected Matrix Gbz;
  protected Matrix aNC;
  private float aNP;
  private boolean dvt;
  private int fIN;
  private int fIO;
  private boolean hBC;
  private int imageHeight;
  private int imageWidth;
  private float jMh;
  protected ap mHandler;
  protected Bitmap xfE;
  private boolean xzx;
  
  private MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(142343);
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
    this.GbJ = 0.0F;
    this.GbK = false;
    this.GbL = false;
    this.GbM = false;
    this.xzx = true;
    this.mHandler = new ap();
    this.aNP = 1.0F;
    this.GbQ = 0.0F;
    this.GbR = false;
    this.imageHeight = paramInt2;
    this.imageWidth = paramInt1;
    this.GbP = null;
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
    this.GbJ = 0.0F;
    this.GbK = false;
    this.GbL = false;
    this.GbM = false;
    this.xzx = true;
    this.mHandler = new ap();
    this.aNP = 1.0F;
    this.GbQ = 0.0F;
    this.GbR = false;
    this.imageHeight = 0;
    this.imageWidth = 0;
    init();
    AppMethodBeat.o(142344);
  }
  
  private void aJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(142352);
    if ((this.xfE == null) && (!this.GbR))
    {
      AppMethodBeat.o(142352);
      return;
    }
    if ((this.GbS == null) && (this.GbR))
    {
      AppMethodBeat.o(142352);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f4;
    if (this.GbR)
    {
      localRectF = new RectF(0.0F, 0.0F, this.GbS.getIntrinsicWidth(), this.GbS.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f4 = localRectF.width();
      if (!paramBoolean2) {
        break label296;
      }
      if (f1 >= this.fIO) {
        break label247;
      }
      f1 = (this.fIO - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label139:
      if (paramBoolean1) {
        if (f4 < this.fIN) {
          f2 = (this.fIN - f4) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        ag(f2, f1);
        localMatrix = getImageViewMatrix();
        setImageMatrix(localMatrix);
        localMatrix.mapRect(localRectF);
        localRectF.height();
        localRectF.width();
        AppMethodBeat.o(142352);
        return;
        localRectF = new RectF(0.0F, 0.0F, this.xfE.getWidth(), this.xfE.getHeight());
        break;
        label247:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label139;
        }
        if (localRectF.bottom >= this.fIO) {
          break label519;
        }
        f1 = this.fIO - localRectF.bottom;
        break label139;
        label296:
        f1 = localRectF.top;
        float f5 = this.fIO - localRectF.bottom;
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
        if (localRectF.bottom >= this.fIO) {
          break label519;
        }
        f1 = f5 - f1;
        break label139;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.fIN)
        {
          f2 = this.fIN - localRectF.right;
          continue;
          f3 = localRectF.left;
          f5 = this.fIN - localRectF.right;
          f4 = (f3 + f5) / 2.0F;
          f3 = f4;
          if (f4 < 0.0F) {
            f3 = 0.0F;
          }
          if (localRectF.left > 0.0F) {
            f2 = f3 - localRectF.left;
          } else if (localRectF.right < this.fIN) {
            f2 = f5 - f3;
          }
        }
      }
      label519:
      f1 = 0.0F;
    }
  }
  
  private void eTp()
  {
    boolean bool2 = true;
    this.GbN = (this.fIN / this.imageWidth);
    this.GbO = (this.fIO / this.imageHeight);
    if (this.imageWidth > this.imageHeight * 2.2F)
    {
      bool1 = true;
      this.GbL = bool1;
      if (this.imageHeight <= this.imageWidth * 2.2F) {
        break label215;
      }
      bool1 = true;
      label79:
      this.GbM = bool1;
      if ((!this.GbL) || (this.imageWidth <= this.fIN)) {
        break label221;
      }
      bool1 = true;
      label106:
      this.GbL = bool1;
      if ((!this.GbM) || (this.imageHeight <= this.fIO)) {
        break label227;
      }
    }
    label215:
    label221:
    label227:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.GbM = bool1;
      float f3 = this.imageHeight / this.imageWidth;
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
        break label233;
      }
      this.GbF = this.GbO;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      bool1 = false;
      break label106;
    }
    label233:
    this.GbF = this.GbN;
  }
  
  private void init()
  {
    AppMethodBeat.i(142353);
    ad.d("dktest", "init screenWidth:" + this.fIN + " screenHeight :" + this.fIO);
    setScaleType(ImageView.ScaleType.MATRIX);
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.aNP = f;
    }
    eSz();
    AppMethodBeat.o(142353);
  }
  
  private void n(final float paramFloat1, final float paramFloat2, final float paramFloat3)
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
        float f1 = Math.min(this.GbT, (float)(l - l));
        float f2 = paramFloat1;
        float f3 = paramFloat2;
        MultiTouchImageView.this.m(f2 + f3 * f1, paramFloat3, this.cSy);
        MultiTouchImageView.this.eSA();
        if (f1 < this.GbT) {
          MultiTouchImageView.this.mHandler.post(this);
        }
        AppMethodBeat.o(142339);
      }
    });
    AppMethodBeat.o(142361);
  }
  
  public final void ae(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142349);
    eTp();
    n(this.GbF, paramFloat1, paramFloat2);
    AppMethodBeat.o(142349);
  }
  
  public final void af(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142360);
    this.GbD = getDoubleTabScale();
    n(this.GbD, paramFloat1, paramFloat2);
    AppMethodBeat.o(142360);
  }
  
  public final void ag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142363);
    this.aNC.postTranslate(paramFloat1, paramFloat2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(142363);
  }
  
  public final void ah(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(190982);
    eTp();
    this.GbF *= getOriginScale();
    n(this.GbF, paramFloat1, paramFloat2);
    eSA();
    AppMethodBeat.o(190982);
  }
  
  public final void ai(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(190983);
    eTp();
    this.GbF *= getOriginScale();
    n(this.GbF, paramFloat1, paramFloat2);
    eSA();
    AppMethodBeat.o(190983);
  }
  
  public final void bF(float paramFloat)
  {
    AppMethodBeat.i(190984);
    if (getScale() >= this.jMh)
    {
      AppMethodBeat.o(190984);
      return;
    }
    if (getScale() <= this.GbE)
    {
      AppMethodBeat.o(190984);
      return;
    }
    if ((this.xfE == null) && (!this.GbR))
    {
      AppMethodBeat.o(190984);
      return;
    }
    if ((this.GbS == null) && (this.GbR))
    {
      AppMethodBeat.o(190984);
      return;
    }
    float f1 = this.fIN / 2.0F;
    float f2 = this.fIO / 2.0F;
    this.aNC.postScale(paramFloat, paramFloat, f1, f2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(190984);
  }
  
  public final void cH(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public final void eSA()
  {
    boolean bool2 = true;
    AppMethodBeat.i(142356);
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
      AppMethodBeat.o(142356);
      return;
      bool1 = false;
      break;
      label49:
      bool2 = false;
    }
  }
  
  public final void eSB()
  {
    AppMethodBeat.i(142357);
    if ((this.GbK) && (0.0F == this.GbD)) {
      this.GbD = getDoubleTabScale();
    }
    AppMethodBeat.o(142357);
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
    AppMethodBeat.i(142348);
    this.aNC.reset();
    eTp();
    m(this.GbF, 0.0F, 0.0F);
    eSA();
    AppMethodBeat.o(142348);
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
        f1 = getScaleRate() * this.GbG;
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
    this.GbA.set(this.Gbz);
    this.GbA.postConcat(this.aNC);
    Matrix localMatrix = this.GbA;
    AppMethodBeat.o(142355);
    return localMatrix;
  }
  
  public int getImageWidth()
  {
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
  
  public float getOriginScale()
  {
    return this.GbJ;
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
    this.aNC.getValues(this.Ba);
    eTp();
    this.jMh = (this.GbI * this.aNP);
    this.GbE = (this.GbF * this.GbH);
    if (this.jMh < 1.0F) {
      this.jMh = 1.0F;
    }
    if (this.GbE > 1.0F) {
      this.GbE = 1.0F;
    }
    float f = this.Ba[0];
    AppMethodBeat.o(142354);
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
  
  public final void jm(int paramInt1, int paramInt2)
  {
    this.fIO = paramInt2;
    this.fIN = paramInt1;
  }
  
  public final void m(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(142358);
    float f2 = getScale();
    float f1;
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
        break label124;
      }
      f1 = this.jMh * 2.0F + (paramFloat1 - this.jMh) * 0.1F;
    }
    for (;;)
    {
      paramFloat1 = f1 / f2;
      if (!this.GbR)
      {
        setImageMatrix(getImageViewMatrix());
        this.aNC.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      AppMethodBeat.o(142358);
      return;
      f1 = this.GbD;
      break;
      label124:
      f1 = paramFloat1;
      if (paramFloat1 < this.GbE) {
        f1 = this.GbE;
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.hBC = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142347);
    if ((!this.GbR) && (this.xfE != null) && (this.xfE.isRecycled()))
    {
      ad.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
      AppMethodBeat.o(142347);
      return;
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(142347);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(142350);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      f.e(paramKeyEvent);
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
    if ((paramInt == 4) && (f.f(paramKeyEvent)) && (!f.g(paramKeyEvent)) && (getScale() > 1.0F))
    {
      m(1.0F, this.fIN / 2.0F, this.fIO / 2.0F);
      eSA();
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
    if ((this.fIN != View.MeasureSpec.getSize(paramInt1)) || (this.fIO != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.dvt = true;; this.dvt = false)
    {
      this.fIN = View.MeasureSpec.getSize(paramInt1);
      this.fIO = View.MeasureSpec.getSize(paramInt2);
      if (!this.hBC)
      {
        this.hBC = true;
        init();
      }
      if (this.dvt) {
        eSz();
      }
      AppMethodBeat.o(142345);
      return;
    }
  }
  
  public void setDoubleTabScaleLimit(float paramFloat)
  {
    AppMethodBeat.i(142342);
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      ad.w("MicroMsg.MultiTouchImageView", "double tab scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142342);
      return;
    }
    this.GbG = paramFloat;
    AppMethodBeat.o(142342);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.xzx = paramBoolean;
  }
  
  public void setGifDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142365);
    this.GbR = true;
    this.GbS = paramDrawable;
    setImageDrawable(this.GbS);
    AppMethodBeat.o(142365);
  }
  
  public void setGifPath(String paramString)
  {
    AppMethodBeat.i(142364);
    this.GbR = true;
    try
    {
      this.GbS = c.lu(paramString, paramString);
      setImageDrawable(this.GbS);
      if (this.GbS != null) {
        cH(this.GbS.getIntrinsicWidth(), this.GbS.getIntrinsicHeight());
      }
      AppMethodBeat.o(142364);
      return;
    }
    catch (Exception paramString)
    {
      this.GbR = false;
      AppMethodBeat.o(142364);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142346);
    this.GbR = false;
    this.xfE = paramBitmap;
    this.hBC = false;
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(142346);
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
    AppMethodBeat.i(142340);
    if (Float.compare(paramFloat, 1.0F) < 0)
    {
      ad.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
      AppMethodBeat.o(142340);
      return;
    }
    this.GbI = paramFloat;
    AppMethodBeat.o(142340);
  }
  
  public void setMinZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(142341);
    if (Float.compare(paramFloat, 1.0F) > 0)
    {
      ad.w("MicroMsg.MultiTouchImageView", "min scale limit is greater than 1.0, change nothing, return");
      AppMethodBeat.o(142341);
      return;
    }
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      ad.w("MicroMsg.MultiTouchImageView", "min scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142341);
      return;
    }
    this.GbH = paramFloat;
    AppMethodBeat.o(142341);
  }
  
  public void setOriginScale(float paramFloat)
  {
    this.GbJ = paramFloat;
  }
  
  public final void start()
  {
    AppMethodBeat.i(142366);
    if ((this.GbR) && (this.GbS != null)) {
      ((a)this.GbS).start();
    }
    AppMethodBeat.o(142366);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */