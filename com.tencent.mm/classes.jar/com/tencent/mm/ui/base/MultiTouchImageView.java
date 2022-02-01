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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.f.b.a;
import com.tencent.mm.ui.f.b.c;

public class MultiTouchImageView
  extends ImageView
  implements g
{
  private boolean AdH;
  private final float[] DQ;
  protected Matrix Jpf;
  private final Matrix Jpg;
  int Jph;
  int Jpi;
  private float Jpj;
  private float Jpk;
  private float Jpl;
  private float Jpm;
  private float Jpn;
  private float Jpo;
  private float Jpp;
  private boolean Jpq;
  private float Jpr;
  private float Jps;
  private a Jpt;
  float Jpu;
  public boolean Jpv;
  public Drawable Jpw;
  public boolean aXA;
  public boolean aXB;
  protected Matrix aYM;
  private float aYZ;
  private boolean dFh;
  private int gfT;
  private int gfU;
  private int imageHeight;
  private int imageWidth;
  private boolean ivz;
  private float kHI;
  protected ap mHandler;
  protected Bitmap zJA;
  
  private MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(142343);
    this.Jpf = new Matrix();
    this.aYM = new Matrix();
    this.Jpg = new Matrix();
    this.DQ = new float[9];
    this.zJA = null;
    this.Jph = -1;
    this.Jpi = -1;
    this.Jpj = 0.0F;
    this.kHI = 0.0F;
    this.Jpk = 0.0F;
    this.ivz = false;
    this.dFh = false;
    this.Jpm = 2.0F;
    this.Jpn = 0.75F;
    this.Jpo = 20.0F;
    this.Jpp = 0.0F;
    this.Jpq = false;
    this.aXB = false;
    this.aXA = false;
    this.AdH = true;
    this.mHandler = new ap();
    this.aYZ = 1.0F;
    this.Jpu = 0.0F;
    this.Jpv = false;
    this.imageHeight = paramInt2;
    this.imageWidth = paramInt1;
    this.Jpt = null;
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
    this.Jpf = new Matrix();
    this.aYM = new Matrix();
    this.Jpg = new Matrix();
    this.DQ = new float[9];
    this.zJA = null;
    this.Jph = -1;
    this.Jpi = -1;
    this.Jpj = 0.0F;
    this.kHI = 0.0F;
    this.Jpk = 0.0F;
    this.ivz = false;
    this.dFh = false;
    this.Jpm = 2.0F;
    this.Jpn = 0.75F;
    this.Jpo = 20.0F;
    this.Jpp = 0.0F;
    this.Jpq = false;
    this.aXB = false;
    this.aXA = false;
    this.AdH = true;
    this.mHandler = new ap();
    this.aYZ = 1.0F;
    this.Jpu = 0.0F;
    this.Jpv = false;
    this.imageHeight = 0;
    this.imageWidth = 0;
    init();
    AppMethodBeat.o(142344);
  }
  
  private void aV(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(142352);
    if ((this.zJA == null) && (!this.Jpv))
    {
      AppMethodBeat.o(142352);
      return;
    }
    if ((this.Jpw == null) && (this.Jpv))
    {
      AppMethodBeat.o(142352);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f4;
    if (this.Jpv)
    {
      localRectF = new RectF(0.0F, 0.0F, this.Jpw.getIntrinsicWidth(), this.Jpw.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f4 = localRectF.width();
      if (!paramBoolean2) {
        break label296;
      }
      if (f1 >= this.gfU) {
        break label247;
      }
      f1 = (this.gfU - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label139:
      if (paramBoolean1) {
        if (f4 < this.gfT) {
          f2 = (this.gfT - f4) / 2.0F - localRectF.left;
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
        localRectF = new RectF(0.0F, 0.0F, this.zJA.getWidth(), this.zJA.getHeight());
        break;
        label247:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label139;
        }
        if (localRectF.bottom >= this.gfU) {
          break label519;
        }
        f1 = this.gfU - localRectF.bottom;
        break label139;
        label296:
        f1 = localRectF.top;
        float f5 = this.gfU - localRectF.bottom;
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
        if (localRectF.bottom >= this.gfU) {
          break label519;
        }
        f1 = f5 - f1;
        break label139;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.gfT)
        {
          f2 = this.gfT - localRectF.right;
          continue;
          f3 = localRectF.left;
          f5 = this.gfT - localRectF.right;
          f4 = (f3 + f5) / 2.0F;
          f3 = f4;
          if (f4 < 0.0F) {
            f3 = 0.0F;
          }
          if (localRectF.left > 0.0F) {
            f2 = f3 - localRectF.left;
          } else if (localRectF.right < this.gfT) {
            f2 = f5 - f3;
          }
        }
      }
      label519:
      f1 = 0.0F;
    }
  }
  
  private void fzp()
  {
    boolean bool2 = true;
    this.Jpr = (this.gfT / this.imageWidth);
    this.Jps = (this.gfU / this.imageHeight);
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
      if ((!this.aXB) || (this.imageWidth <= this.gfT)) {
        break label221;
      }
      bool1 = true;
      label106:
      this.aXB = bool1;
      if ((!this.aXA) || (this.imageHeight <= this.gfU)) {
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
      if (this.gfT != 0)
      {
        f1 = f2;
        if (this.gfU != 0) {
          f1 = this.gfU / this.gfT;
        }
      }
      if ((f3 <= f1) || (f3 > 2.2D)) {
        break label233;
      }
      this.Jpl = this.Jps;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      bool1 = false;
      break label106;
    }
    label233:
    this.Jpl = this.Jpr;
  }
  
  private void init()
  {
    AppMethodBeat.i(142353);
    ad.d("dktest", "init screenWidth:" + this.gfT + " screenHeight :" + this.gfU);
    setScaleType(ImageView.ScaleType.MATRIX);
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.aYZ = f;
    }
    fyy();
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
        float f1 = Math.min(this.Jpx, (float)(l - l));
        float f2 = paramFloat1;
        float f3 = paramFloat2;
        MultiTouchImageView.this.o(f2 + f3 * f1, paramFloat3, this.dbl);
        MultiTouchImageView.this.fyz();
        if (f1 < this.Jpx) {
          MultiTouchImageView.this.mHandler.post(this);
        }
        AppMethodBeat.o(142339);
      }
    });
    AppMethodBeat.o(142361);
  }
  
  public final PointF a(PointF paramPointF, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186483);
    if (paramPointF == null)
    {
      AppMethodBeat.o(186483);
      return null;
    }
    int i = this.imageWidth;
    int j = (int)(1.0F * this.imageWidth * paramInt2 / paramInt1);
    float f1 = paramPointF.x;
    float f2 = i;
    float f3 = paramPointF.y;
    float f4 = j;
    ad.v("MicroMsg.MultiTouchImageView", "mapPoint srcPoint: %s, width: %d, height: %d, viewWidth: %d, viewHeight: %d, targetWidth: %d, targetHeight: %d", new Object[] { paramPointF, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.gfT), Integer.valueOf(this.gfU), Integer.valueOf(i), Integer.valueOf(j) });
    paramPointF = getImageViewMatrix();
    if (paramPointF != null)
    {
      float[] arrayOfFloat = new float[2];
      ad.v("MicroMsg.MultiTouchImageView", "mapPoint scaleRate: %s", new Object[] { Float.valueOf(this.Jpl) });
      paramPointF.mapPoints(arrayOfFloat, new float[] { f1 * f2, f3 * f4 });
      paramPointF = new PointF(arrayOfFloat[0], arrayOfFloat[1]);
      AppMethodBeat.o(186483);
      return paramPointF;
    }
    AppMethodBeat.o(186483);
    return null;
  }
  
  public final void am(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142349);
    fzp();
    p(this.Jpl, paramFloat1, paramFloat2);
    AppMethodBeat.o(142349);
  }
  
  public final void an(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142360);
    this.Jpj = getDoubleTabScale();
    p(this.Jpj, paramFloat1, paramFloat2);
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
    AppMethodBeat.i(186480);
    fzp();
    this.Jpl *= getOriginScale();
    p(this.Jpl, paramFloat1, paramFloat2);
    fyz();
    AppMethodBeat.o(186480);
  }
  
  public final void aq(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(186481);
    fzp();
    this.Jpl *= getOriginScale();
    p(this.Jpl, paramFloat1, paramFloat2);
    fyz();
    AppMethodBeat.o(186481);
  }
  
  public final void bS(float paramFloat)
  {
    AppMethodBeat.i(186482);
    if (getScale() >= this.kHI)
    {
      AppMethodBeat.o(186482);
      return;
    }
    if (getScale() <= this.Jpk)
    {
      AppMethodBeat.o(186482);
      return;
    }
    if ((this.zJA == null) && (!this.Jpv))
    {
      AppMethodBeat.o(186482);
      return;
    }
    if ((this.Jpw == null) && (this.Jpv))
    {
      AppMethodBeat.o(186482);
      return;
    }
    float f1 = this.gfT / 2.0F;
    float f2 = this.gfU / 2.0F;
    this.aYM.postScale(paramFloat, paramFloat, f1, f2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(186482);
  }
  
  public final void cH(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public final void fyA()
  {
    AppMethodBeat.i(142357);
    if ((this.Jpq) && (0.0F == this.Jpj)) {
      this.Jpj = getDoubleTabScale();
    }
    AppMethodBeat.o(142357);
  }
  
  public final boolean fyw()
  {
    return this.aXB;
  }
  
  public final boolean fyx()
  {
    return this.aXA;
  }
  
  public final void fyy()
  {
    AppMethodBeat.i(142348);
    this.aYM.reset();
    fzp();
    o(this.Jpl, 0.0F, 0.0F);
    fyz();
    AppMethodBeat.o(142348);
  }
  
  public final void fyz()
  {
    boolean bool2 = true;
    AppMethodBeat.i(142356);
    boolean bool1;
    if ((!this.AdH) || (!this.aXB))
    {
      bool1 = true;
      if (this.aXA) {
        break label49;
      }
    }
    for (;;)
    {
      aV(bool1, bool2);
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
        f1 = getScaleRate() * this.Jpm;
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
    this.Jpg.set(this.Jpf);
    this.Jpg.postConcat(this.aYM);
    Matrix localMatrix = this.Jpg;
    AppMethodBeat.o(142355);
    return localMatrix;
  }
  
  public int getImageWidth()
  {
    return this.imageWidth;
  }
  
  public float getMaxZoom()
  {
    return this.kHI;
  }
  
  public float getMinZoom()
  {
    return this.Jpk;
  }
  
  public float getOriginScale()
  {
    return this.Jpp;
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
    fzp();
    this.kHI = (this.Jpo * this.aYZ);
    this.Jpk = (this.Jpl * this.Jpn);
    if (this.kHI < 1.0F) {
      this.kHI = 1.0F;
    }
    if (this.Jpk > 1.0F) {
      this.Jpk = 1.0F;
    }
    float f = this.DQ[0];
    AppMethodBeat.o(142354);
    return f;
  }
  
  public float getScaleHeight()
  {
    return this.Jps;
  }
  
  public float getScaleRate()
  {
    return this.Jpl;
  }
  
  public float getScaleWidth()
  {
    return this.Jpr;
  }
  
  public final void jL(int paramInt1, int paramInt2)
  {
    this.gfU = paramInt2;
    this.gfT = paramInt1;
  }
  
  public final void o(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(142358);
    float f2 = getScale();
    float f1;
    if (this.Jpq)
    {
      if (0.0F == this.Jpj)
      {
        f1 = this.Jpo * this.aYZ;
        this.kHI = f1;
      }
    }
    else
    {
      if (paramFloat1 <= this.kHI * 2.0F) {
        break label124;
      }
      f1 = this.kHI * 2.0F + (paramFloat1 - this.kHI) * 0.1F;
    }
    for (;;)
    {
      paramFloat1 = f1 / f2;
      if (!this.Jpv)
      {
        setImageMatrix(getImageViewMatrix());
        this.aYM.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      AppMethodBeat.o(142358);
      return;
      f1 = this.Jpj;
      break;
      label124:
      f1 = paramFloat1;
      if (paramFloat1 < this.Jpk) {
        f1 = this.Jpk;
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.ivz = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142347);
    if ((!this.Jpv) && (this.zJA != null) && (this.zJA.isRecycled()))
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
      o(1.0F, this.gfT / 2.0F, this.gfU / 2.0F);
      fyz();
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
    if ((this.gfT != View.MeasureSpec.getSize(paramInt1)) || (this.gfU != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.dFh = true;; this.dFh = false)
    {
      this.gfT = View.MeasureSpec.getSize(paramInt1);
      this.gfU = View.MeasureSpec.getSize(paramInt2);
      if (!this.ivz)
      {
        this.ivz = true;
        init();
      }
      if (this.dFh) {
        fyy();
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
    this.Jpm = paramFloat;
    AppMethodBeat.o(142342);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.AdH = paramBoolean;
  }
  
  public void setGifDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142365);
    this.Jpv = true;
    this.Jpw = paramDrawable;
    setImageDrawable(this.Jpw);
    AppMethodBeat.o(142365);
  }
  
  public void setGifPath(String paramString)
  {
    AppMethodBeat.i(142364);
    this.Jpv = true;
    try
    {
      this.Jpw = c.mq(paramString, paramString);
      setImageDrawable(this.Jpw);
      if (this.Jpw != null) {
        cH(this.Jpw.getIntrinsicWidth(), this.Jpw.getIntrinsicHeight());
      }
      AppMethodBeat.o(142364);
      return;
    }
    catch (Exception paramString)
    {
      this.Jpv = false;
      AppMethodBeat.o(142364);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142346);
    this.Jpv = false;
    this.zJA = paramBitmap;
    this.ivz = false;
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
    this.Jpq = paramBoolean;
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
    this.Jpo = paramFloat;
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
    this.Jpn = paramFloat;
    AppMethodBeat.o(142341);
  }
  
  public void setOriginScale(float paramFloat)
  {
    this.Jpp = paramFloat;
  }
  
  public final void start()
  {
    AppMethodBeat.i(142366);
    if ((this.Jpv) && (this.Jpw != null)) {
      ((a)this.Jpw).start();
    }
    AppMethodBeat.o(142366);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */