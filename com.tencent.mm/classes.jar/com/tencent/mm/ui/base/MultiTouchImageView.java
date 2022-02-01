package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.f.b.a;
import com.tencent.mm.ui.f.b.c;

public class MultiTouchImageView
  extends ImageView
  implements g
{
  protected Bitmap AaH;
  private boolean AuT;
  private final float[] DQ;
  protected Matrix JJU;
  private final Matrix JJV;
  int JJW;
  int JJX;
  private float JJY;
  private float JJZ;
  private float JKa;
  private float JKb;
  private float JKc;
  private float JKd;
  private float JKe;
  private boolean JKf;
  private float JKg;
  private float JKh;
  private a JKi;
  float JKj;
  public boolean JKk;
  public Drawable JKl;
  public boolean aXA;
  public boolean aXB;
  protected Matrix aYM;
  private float aYZ;
  private boolean dGm;
  private int gil;
  private int gim;
  private int imageHeight;
  private int imageWidth;
  private boolean iys;
  private float kKX;
  protected aq mHandler;
  
  private MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(142343);
    this.JJU = new Matrix();
    this.aYM = new Matrix();
    this.JJV = new Matrix();
    this.DQ = new float[9];
    this.AaH = null;
    this.JJW = -1;
    this.JJX = -1;
    this.JJY = 0.0F;
    this.kKX = 0.0F;
    this.JJZ = 0.0F;
    this.iys = false;
    this.dGm = false;
    this.JKb = 2.0F;
    this.JKc = 0.75F;
    this.JKd = 20.0F;
    this.JKe = 0.0F;
    this.JKf = false;
    this.aXB = false;
    this.aXA = false;
    this.AuT = true;
    this.mHandler = new aq();
    this.aYZ = 1.0F;
    this.JKj = 0.0F;
    this.JKk = false;
    this.imageHeight = paramInt2;
    this.imageWidth = paramInt1;
    this.JKi = null;
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
    this.JJU = new Matrix();
    this.aYM = new Matrix();
    this.JJV = new Matrix();
    this.DQ = new float[9];
    this.AaH = null;
    this.JJW = -1;
    this.JJX = -1;
    this.JJY = 0.0F;
    this.kKX = 0.0F;
    this.JJZ = 0.0F;
    this.iys = false;
    this.dGm = false;
    this.JKb = 2.0F;
    this.JKc = 0.75F;
    this.JKd = 20.0F;
    this.JKe = 0.0F;
    this.JKf = false;
    this.aXB = false;
    this.aXA = false;
    this.AuT = true;
    this.mHandler = new aq();
    this.aYZ = 1.0F;
    this.JKj = 0.0F;
    this.JKk = false;
    this.imageHeight = 0;
    this.imageWidth = 0;
    init();
    AppMethodBeat.o(142344);
  }
  
  private void aU(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(142352);
    if ((this.AaH == null) && (!this.JKk))
    {
      AppMethodBeat.o(142352);
      return;
    }
    if ((this.JKl == null) && (this.JKk))
    {
      AppMethodBeat.o(142352);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f4;
    if (this.JKk)
    {
      localRectF = new RectF(0.0F, 0.0F, this.JKl.getIntrinsicWidth(), this.JKl.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f4 = localRectF.width();
      if (!paramBoolean2) {
        break label296;
      }
      if (f1 >= this.gim) {
        break label247;
      }
      f1 = (this.gim - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label139:
      if (paramBoolean1) {
        if (f4 < this.gil) {
          f2 = (this.gil - f4) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        ao(f2, f1);
        localMatrix = getImageViewMatrix();
        setImageMatrix(localMatrix);
        localMatrix.mapRect(localRectF);
        localRectF.height();
        localRectF.width();
        AppMethodBeat.o(142352);
        return;
        localRectF = new RectF(0.0F, 0.0F, this.AaH.getWidth(), this.AaH.getHeight());
        break;
        label247:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label139;
        }
        if (localRectF.bottom >= this.gim) {
          break label519;
        }
        f1 = this.gim - localRectF.bottom;
        break label139;
        label296:
        f1 = localRectF.top;
        float f5 = this.gim - localRectF.bottom;
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
        if (localRectF.bottom >= this.gim) {
          break label519;
        }
        f1 = f5 - f1;
        break label139;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.gil)
        {
          f2 = this.gil - localRectF.right;
          continue;
          f3 = localRectF.left;
          f5 = this.gil - localRectF.right;
          f4 = (f3 + f5) / 2.0F;
          f3 = f4;
          if (f4 < 0.0F) {
            f3 = 0.0F;
          }
          if (localRectF.left > 0.0F) {
            f2 = f3 - localRectF.left;
          } else if (localRectF.right < this.gil) {
            f2 = f5 - f3;
          }
        }
      }
      label519:
      f1 = 0.0F;
    }
  }
  
  private void fDr()
  {
    boolean bool2 = true;
    this.JKg = (this.gil / this.imageWidth);
    this.JKh = (this.gim / this.imageHeight);
    if (this.imageWidth > this.imageHeight * 2.2F)
    {
      bool1 = true;
      this.aXB = bool1;
      if (this.imageHeight <= this.imageWidth * 2.2F) {
        break label215;
      }
      bool1 = true;
      label79:
      this.aXA = bool1;
      if ((!this.aXB) || (this.imageWidth <= this.gil)) {
        break label221;
      }
      bool1 = true;
      label106:
      this.aXB = bool1;
      if ((!this.aXA) || (this.imageHeight <= this.gim)) {
        break label227;
      }
    }
    label215:
    label221:
    label227:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aXA = bool1;
      float f3 = this.imageHeight / this.imageWidth;
      float f2 = 1.8F;
      float f1 = f2;
      if (this.gil != 0)
      {
        f1 = f2;
        if (this.gim != 0) {
          f1 = this.gim / this.gil;
        }
      }
      if ((f3 <= f1) || (f3 > 2.2D)) {
        break label233;
      }
      this.JKa = this.JKh;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      bool1 = false;
      break label106;
    }
    label233:
    this.JKa = this.JKg;
  }
  
  private void init()
  {
    AppMethodBeat.i(142353);
    ae.d("dktest", "init screenWidth:" + this.gil + " screenHeight :" + this.gim);
    setScaleType(ImageView.ScaleType.MATRIX);
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.aYZ = f;
    }
    fCA();
    AppMethodBeat.o(142353);
  }
  
  private void p(final float paramFloat1, final float paramFloat2, final float paramFloat3)
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
        float f1 = Math.min(this.JKm, (float)(l - l));
        float f2 = paramFloat1;
        float f3 = paramFloat2;
        MultiTouchImageView.this.o(f2 + f3 * f1, paramFloat3, this.dcn);
        MultiTouchImageView.this.fCB();
        if (f1 < this.JKm) {
          MultiTouchImageView.this.mHandler.post(this);
        }
        AppMethodBeat.o(142339);
      }
    });
    AppMethodBeat.o(142361);
  }
  
  public final PointF a(PointF paramPointF, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193740);
    if (paramPointF == null)
    {
      AppMethodBeat.o(193740);
      return null;
    }
    int i = this.imageWidth;
    int j = (int)(1.0F * this.imageWidth * paramInt2 / paramInt1);
    float f1 = paramPointF.x;
    float f2 = i;
    float f3 = paramPointF.y;
    float f4 = j;
    ae.v("MicroMsg.MultiTouchImageView", "mapPoint srcPoint: %s, width: %d, height: %d, viewWidth: %d, viewHeight: %d, targetWidth: %d, targetHeight: %d", new Object[] { paramPointF, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.gil), Integer.valueOf(this.gim), Integer.valueOf(i), Integer.valueOf(j) });
    paramPointF = getImageViewMatrix();
    if (paramPointF != null)
    {
      float[] arrayOfFloat = new float[2];
      ae.v("MicroMsg.MultiTouchImageView", "mapPoint scaleRate: %s", new Object[] { Float.valueOf(this.JKa) });
      paramPointF.mapPoints(arrayOfFloat, new float[] { f1 * f2, f3 * f4 });
      paramPointF = new PointF(arrayOfFloat[0], arrayOfFloat[1]);
      AppMethodBeat.o(193740);
      return paramPointF;
    }
    AppMethodBeat.o(193740);
    return null;
  }
  
  public final void am(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142349);
    fDr();
    p(this.JKa, paramFloat1, paramFloat2);
    AppMethodBeat.o(142349);
  }
  
  public final void an(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142360);
    this.JJY = getDoubleTabScale();
    p(this.JJY, paramFloat1, paramFloat2);
    AppMethodBeat.o(142360);
  }
  
  public final void ao(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142363);
    this.aYM.postTranslate(paramFloat1, paramFloat2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(142363);
  }
  
  public final void ap(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(193737);
    fDr();
    this.JKa *= getOriginScale();
    p(this.JKa, paramFloat1, paramFloat2);
    fCB();
    AppMethodBeat.o(193737);
  }
  
  public final void aq(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(193738);
    fDr();
    this.JKa *= getOriginScale();
    p(this.JKa, paramFloat1, paramFloat2);
    fCB();
    AppMethodBeat.o(193738);
  }
  
  public final void bQ(float paramFloat)
  {
    AppMethodBeat.i(193739);
    if (getScale() >= this.kKX)
    {
      AppMethodBeat.o(193739);
      return;
    }
    if (getScale() <= this.JJZ)
    {
      AppMethodBeat.o(193739);
      return;
    }
    if ((this.AaH == null) && (!this.JKk))
    {
      AppMethodBeat.o(193739);
      return;
    }
    if ((this.JKl == null) && (this.JKk))
    {
      AppMethodBeat.o(193739);
      return;
    }
    float f1 = this.gil / 2.0F;
    float f2 = this.gim / 2.0F;
    this.aYM.postScale(paramFloat, paramFloat, f1, f2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(193739);
  }
  
  public final void cH(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public final void fCA()
  {
    AppMethodBeat.i(142348);
    this.aYM.reset();
    fDr();
    o(this.JKa, 0.0F, 0.0F);
    fCB();
    AppMethodBeat.o(142348);
  }
  
  public final void fCB()
  {
    boolean bool2 = true;
    AppMethodBeat.i(142356);
    boolean bool1;
    if ((!this.AuT) || (!this.aXB))
    {
      bool1 = true;
      if (this.aXA) {
        break label49;
      }
    }
    for (;;)
    {
      aU(bool1, bool2);
      AppMethodBeat.o(142356);
      return;
      bool1 = false;
      break;
      label49:
      bool2 = false;
    }
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(142357);
    if ((this.JKf) && (0.0F == this.JJY)) {
      this.JJY = getDoubleTabScale();
    }
    AppMethodBeat.o(142357);
  }
  
  public final boolean fCy()
  {
    return this.aXB;
  }
  
  public final boolean fCz()
  {
    return this.aXA;
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
        f1 = getScaleRate() * this.JKb;
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
    this.JJV.set(this.JJU);
    this.JJV.postConcat(this.aYM);
    Matrix localMatrix = this.JJV;
    AppMethodBeat.o(142355);
    return localMatrix;
  }
  
  public int getImageWidth()
  {
    return this.imageWidth;
  }
  
  public float getMaxZoom()
  {
    return this.kKX;
  }
  
  public float getMinZoom()
  {
    return this.JJZ;
  }
  
  public float getOriginScale()
  {
    return this.JKe;
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
    this.aYM.getValues(this.DQ);
    fDr();
    this.kKX = (this.JKd * this.aYZ);
    this.JJZ = (this.JKa * this.JKc);
    if (this.kKX < 1.0F) {
      this.kKX = 1.0F;
    }
    if (this.JJZ > 1.0F) {
      this.JJZ = 1.0F;
    }
    float f = this.DQ[0];
    AppMethodBeat.o(142354);
    return f;
  }
  
  public float getScaleHeight()
  {
    return this.JKh;
  }
  
  public float getScaleRate()
  {
    return this.JKa;
  }
  
  public float getScaleWidth()
  {
    return this.JKg;
  }
  
  public final void jP(int paramInt1, int paramInt2)
  {
    this.gim = paramInt2;
    this.gil = paramInt1;
  }
  
  public final void o(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(142358);
    float f2 = getScale();
    float f1;
    if (this.JKf)
    {
      if (0.0F == this.JJY)
      {
        f1 = this.JKd * this.aYZ;
        this.kKX = f1;
      }
    }
    else
    {
      if (paramFloat1 <= this.kKX * 2.0F) {
        break label124;
      }
      f1 = this.kKX * 2.0F + (paramFloat1 - this.kKX) * 0.1F;
    }
    for (;;)
    {
      paramFloat1 = f1 / f2;
      if (!this.JKk)
      {
        setImageMatrix(getImageViewMatrix());
        this.aYM.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      AppMethodBeat.o(142358);
      return;
      f1 = this.JJY;
      break;
      label124:
      f1 = paramFloat1;
      if (paramFloat1 < this.JJZ) {
        f1 = this.JJZ;
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.iys = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142347);
    if ((!this.JKk) && (this.AaH != null) && (this.AaH.isRecycled()))
    {
      ae.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
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
      o(1.0F, this.gil / 2.0F, this.gim / 2.0F);
      fCB();
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
    if ((this.gil != View.MeasureSpec.getSize(paramInt1)) || (this.gim != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.dGm = true;; this.dGm = false)
    {
      this.gil = View.MeasureSpec.getSize(paramInt1);
      this.gim = View.MeasureSpec.getSize(paramInt2);
      if (!this.iys)
      {
        this.iys = true;
        init();
      }
      if (this.dGm) {
        fCA();
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
      ae.w("MicroMsg.MultiTouchImageView", "double tab scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142342);
      return;
    }
    this.JKb = paramFloat;
    AppMethodBeat.o(142342);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.AuT = paramBoolean;
  }
  
  public void setGifDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142365);
    this.JKk = true;
    this.JKl = paramDrawable;
    setImageDrawable(this.JKl);
    AppMethodBeat.o(142365);
  }
  
  public void setGifPath(String paramString)
  {
    AppMethodBeat.i(142364);
    this.JKk = true;
    try
    {
      this.JKl = c.mx(paramString, paramString);
      setImageDrawable(this.JKl);
      if (this.JKl != null) {
        cH(this.JKl.getIntrinsicWidth(), this.JKl.getIntrinsicHeight());
      }
      AppMethodBeat.o(142364);
      return;
    }
    catch (Exception paramString)
    {
      this.JKk = false;
      AppMethodBeat.o(142364);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142346);
    this.JKk = false;
    this.AaH = paramBitmap;
    this.iys = false;
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
    this.JKf = paramBoolean;
  }
  
  public void setMaxZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(142340);
    if (Float.compare(paramFloat, 1.0F) < 0)
    {
      ae.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
      AppMethodBeat.o(142340);
      return;
    }
    this.JKd = paramFloat;
    AppMethodBeat.o(142340);
  }
  
  public void setMinZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(142341);
    if (Float.compare(paramFloat, 1.0F) > 0)
    {
      ae.w("MicroMsg.MultiTouchImageView", "min scale limit is greater than 1.0, change nothing, return");
      AppMethodBeat.o(142341);
      return;
    }
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      ae.w("MicroMsg.MultiTouchImageView", "min scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142341);
      return;
    }
    this.JKc = paramFloat;
    AppMethodBeat.o(142341);
  }
  
  public void setOriginScale(float paramFloat)
  {
    this.JKe = paramFloat;
  }
  
  public final void start()
  {
    AppMethodBeat.i(142366);
    if ((this.JKk) && (this.JKl != null)) {
      ((a)this.JKl).start();
    }
    AppMethodBeat.o(142366);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */