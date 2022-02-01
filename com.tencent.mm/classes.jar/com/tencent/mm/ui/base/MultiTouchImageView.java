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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.f.b.a;
import com.tencent.mm.ui.f.b.c;

public class MultiTouchImageView
  extends ImageView
  implements g
{
  private final float[] BY;
  public boolean HBA;
  public boolean HBB;
  private float HBC;
  private float HBD;
  private a HBE;
  float HBF;
  public boolean HBG;
  public Drawable HBH;
  protected Matrix HBo;
  private final Matrix HBp;
  int HBq;
  int HBr;
  private float HBs;
  private float HBt;
  private float HBu;
  private float HBv;
  private float HBw;
  private float HBx;
  private float HBy;
  private boolean HBz;
  private float aOF;
  protected Matrix aOs;
  private boolean dtf;
  private int fMt;
  private int fMu;
  private boolean icd;
  private int imageHeight;
  private int imageWidth;
  private float kmI;
  protected ao mHandler;
  private boolean yMl;
  protected Bitmap yss;
  
  private MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(142343);
    this.HBo = new Matrix();
    this.aOs = new Matrix();
    this.HBp = new Matrix();
    this.BY = new float[9];
    this.yss = null;
    this.HBq = -1;
    this.HBr = -1;
    this.HBs = 0.0F;
    this.kmI = 0.0F;
    this.HBt = 0.0F;
    this.icd = false;
    this.dtf = false;
    this.HBv = 2.0F;
    this.HBw = 0.75F;
    this.HBx = 20.0F;
    this.HBy = 0.0F;
    this.HBz = false;
    this.HBA = false;
    this.HBB = false;
    this.yMl = true;
    this.mHandler = new ao();
    this.aOF = 1.0F;
    this.HBF = 0.0F;
    this.HBG = false;
    this.imageHeight = paramInt2;
    this.imageWidth = paramInt1;
    this.HBE = null;
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
    this.HBo = new Matrix();
    this.aOs = new Matrix();
    this.HBp = new Matrix();
    this.BY = new float[9];
    this.yss = null;
    this.HBq = -1;
    this.HBr = -1;
    this.HBs = 0.0F;
    this.kmI = 0.0F;
    this.HBt = 0.0F;
    this.icd = false;
    this.dtf = false;
    this.HBv = 2.0F;
    this.HBw = 0.75F;
    this.HBx = 20.0F;
    this.HBy = 0.0F;
    this.HBz = false;
    this.HBA = false;
    this.HBB = false;
    this.yMl = true;
    this.mHandler = new ao();
    this.aOF = 1.0F;
    this.HBF = 0.0F;
    this.HBG = false;
    this.imageHeight = 0;
    this.imageWidth = 0;
    init();
    AppMethodBeat.o(142344);
  }
  
  private void aN(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(142352);
    if ((this.yss == null) && (!this.HBG))
    {
      AppMethodBeat.o(142352);
      return;
    }
    if ((this.HBH == null) && (this.HBG))
    {
      AppMethodBeat.o(142352);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f4;
    if (this.HBG)
    {
      localRectF = new RectF(0.0F, 0.0F, this.HBH.getIntrinsicWidth(), this.HBH.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f4 = localRectF.width();
      if (!paramBoolean2) {
        break label296;
      }
      if (f1 >= this.fMu) {
        break label247;
      }
      f1 = (this.fMu - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label139:
      if (paramBoolean1) {
        if (f4 < this.fMt) {
          f2 = (this.fMt - f4) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        ak(f2, f1);
        localMatrix = getImageViewMatrix();
        setImageMatrix(localMatrix);
        localMatrix.mapRect(localRectF);
        localRectF.height();
        localRectF.width();
        AppMethodBeat.o(142352);
        return;
        localRectF = new RectF(0.0F, 0.0F, this.yss.getWidth(), this.yss.getHeight());
        break;
        label247:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label139;
        }
        if (localRectF.bottom >= this.fMu) {
          break label519;
        }
        f1 = this.fMu - localRectF.bottom;
        break label139;
        label296:
        f1 = localRectF.top;
        float f5 = this.fMu - localRectF.bottom;
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
        if (localRectF.bottom >= this.fMu) {
          break label519;
        }
        f1 = f5 - f1;
        break label139;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.fMt)
        {
          f2 = this.fMt - localRectF.right;
          continue;
          f3 = localRectF.left;
          f5 = this.fMt - localRectF.right;
          f4 = (f3 + f5) / 2.0F;
          f3 = f4;
          if (f4 < 0.0F) {
            f3 = 0.0F;
          }
          if (localRectF.left > 0.0F) {
            f2 = f3 - localRectF.left;
          } else if (localRectF.right < this.fMt) {
            f2 = f5 - f3;
          }
        }
      }
      label519:
      f1 = 0.0F;
    }
  }
  
  private void fja()
  {
    boolean bool2 = true;
    this.HBC = (this.fMt / this.imageWidth);
    this.HBD = (this.fMu / this.imageHeight);
    if (this.imageWidth > this.imageHeight * 2.2F)
    {
      bool1 = true;
      this.HBA = bool1;
      if (this.imageHeight <= this.imageWidth * 2.2F) {
        break label215;
      }
      bool1 = true;
      label79:
      this.HBB = bool1;
      if ((!this.HBA) || (this.imageWidth <= this.fMt)) {
        break label221;
      }
      bool1 = true;
      label106:
      this.HBA = bool1;
      if ((!this.HBB) || (this.imageHeight <= this.fMu)) {
        break label227;
      }
    }
    label215:
    label221:
    label227:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.HBB = bool1;
      float f3 = this.imageHeight / this.imageWidth;
      float f2 = 1.8F;
      float f1 = f2;
      if (this.fMt != 0)
      {
        f1 = f2;
        if (this.fMu != 0) {
          f1 = this.fMu / this.fMt;
        }
      }
      if ((f3 <= f1) || (f3 > 2.2D)) {
        break label233;
      }
      this.HBu = this.HBD;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      bool1 = false;
      break label106;
    }
    label233:
    this.HBu = this.HBC;
  }
  
  private void init()
  {
    AppMethodBeat.i(142353);
    ac.d("dktest", "init screenWidth:" + this.fMt + " screenHeight :" + this.fMu);
    setScaleType(ImageView.ScaleType.MATRIX);
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.aOF = f;
    }
    fij();
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
        float f1 = Math.min(this.HBI, (float)(l - l));
        float f2 = paramFloat1;
        float f3 = paramFloat2;
        MultiTouchImageView.this.m(f2 + f3 * f1, paramFloat3, this.cPV);
        MultiTouchImageView.this.fik();
        if (f1 < this.HBI) {
          MultiTouchImageView.this.mHandler.post(this);
        }
        AppMethodBeat.o(142339);
      }
    });
    AppMethodBeat.o(142361);
  }
  
  public final void ai(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142349);
    fja();
    n(this.HBu, paramFloat1, paramFloat2);
    AppMethodBeat.o(142349);
  }
  
  public final void aj(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142360);
    this.HBs = getDoubleTabScale();
    n(this.HBs, paramFloat1, paramFloat2);
    AppMethodBeat.o(142360);
  }
  
  public final void ak(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142363);
    this.aOs.postTranslate(paramFloat1, paramFloat2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(142363);
  }
  
  public final void al(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(197193);
    fja();
    this.HBu *= getOriginScale();
    n(this.HBu, paramFloat1, paramFloat2);
    fik();
    AppMethodBeat.o(197193);
  }
  
  public final void am(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(197194);
    fja();
    this.HBu *= getOriginScale();
    n(this.HBu, paramFloat1, paramFloat2);
    fik();
    AppMethodBeat.o(197194);
  }
  
  public final void bN(float paramFloat)
  {
    AppMethodBeat.i(197195);
    if (getScale() >= this.kmI)
    {
      AppMethodBeat.o(197195);
      return;
    }
    if (getScale() <= this.HBt)
    {
      AppMethodBeat.o(197195);
      return;
    }
    if ((this.yss == null) && (!this.HBG))
    {
      AppMethodBeat.o(197195);
      return;
    }
    if ((this.HBH == null) && (this.HBG))
    {
      AppMethodBeat.o(197195);
      return;
    }
    float f1 = this.fMt / 2.0F;
    float f2 = this.fMu / 2.0F;
    this.aOs.postScale(paramFloat, paramFloat, f1, f2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(197195);
  }
  
  public final void cF(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public final boolean fih()
  {
    return this.HBA;
  }
  
  public final boolean fii()
  {
    return this.HBB;
  }
  
  public final void fij()
  {
    AppMethodBeat.i(142348);
    this.aOs.reset();
    fja();
    m(this.HBu, 0.0F, 0.0F);
    fik();
    AppMethodBeat.o(142348);
  }
  
  public final void fik()
  {
    boolean bool2 = true;
    AppMethodBeat.i(142356);
    boolean bool1;
    if ((!this.yMl) || (!this.HBA))
    {
      bool1 = true;
      if (this.HBB) {
        break label49;
      }
    }
    for (;;)
    {
      aN(bool1, bool2);
      AppMethodBeat.o(142356);
      return;
      bool1 = false;
      break;
      label49:
      bool2 = false;
    }
  }
  
  public final void fil()
  {
    AppMethodBeat.i(142357);
    if ((this.HBz) && (0.0F == this.HBs)) {
      this.HBs = getDoubleTabScale();
    }
    AppMethodBeat.o(142357);
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
        f1 = getScaleRate() * this.HBv;
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
    this.HBp.set(this.HBo);
    this.HBp.postConcat(this.aOs);
    Matrix localMatrix = this.HBp;
    AppMethodBeat.o(142355);
    return localMatrix;
  }
  
  public int getImageWidth()
  {
    return this.imageWidth;
  }
  
  public float getMaxZoom()
  {
    return this.kmI;
  }
  
  public float getMinZoom()
  {
    return this.HBt;
  }
  
  public float getOriginScale()
  {
    return this.HBy;
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
    this.aOs.getValues(this.BY);
    fja();
    this.kmI = (this.HBx * this.aOF);
    this.HBt = (this.HBu * this.HBw);
    if (this.kmI < 1.0F) {
      this.kmI = 1.0F;
    }
    if (this.HBt > 1.0F) {
      this.HBt = 1.0F;
    }
    float f = this.BY[0];
    AppMethodBeat.o(142354);
    return f;
  }
  
  public float getScaleHeight()
  {
    return this.HBD;
  }
  
  public float getScaleRate()
  {
    return this.HBu;
  }
  
  public float getScaleWidth()
  {
    return this.HBC;
  }
  
  public final void jz(int paramInt1, int paramInt2)
  {
    this.fMu = paramInt2;
    this.fMt = paramInt1;
  }
  
  public final void m(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(142358);
    float f2 = getScale();
    float f1;
    if (this.HBz)
    {
      if (0.0F == this.HBs)
      {
        f1 = this.HBx * this.aOF;
        this.kmI = f1;
      }
    }
    else
    {
      if (paramFloat1 <= this.kmI * 2.0F) {
        break label124;
      }
      f1 = this.kmI * 2.0F + (paramFloat1 - this.kmI) * 0.1F;
    }
    for (;;)
    {
      paramFloat1 = f1 / f2;
      if (!this.HBG)
      {
        setImageMatrix(getImageViewMatrix());
        this.aOs.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      AppMethodBeat.o(142358);
      return;
      f1 = this.HBs;
      break;
      label124:
      f1 = paramFloat1;
      if (paramFloat1 < this.HBt) {
        f1 = this.HBt;
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.icd = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142347);
    if ((!this.HBG) && (this.yss != null) && (this.yss.isRecycled()))
    {
      ac.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
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
      m(1.0F, this.fMt / 2.0F, this.fMu / 2.0F);
      fik();
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
    if ((this.fMt != View.MeasureSpec.getSize(paramInt1)) || (this.fMu != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.dtf = true;; this.dtf = false)
    {
      this.fMt = View.MeasureSpec.getSize(paramInt1);
      this.fMu = View.MeasureSpec.getSize(paramInt2);
      if (!this.icd)
      {
        this.icd = true;
        init();
      }
      if (this.dtf) {
        fij();
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
      ac.w("MicroMsg.MultiTouchImageView", "double tab scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142342);
      return;
    }
    this.HBv = paramFloat;
    AppMethodBeat.o(142342);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.yMl = paramBoolean;
  }
  
  public void setGifDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142365);
    this.HBG = true;
    this.HBH = paramDrawable;
    setImageDrawable(this.HBH);
    AppMethodBeat.o(142365);
  }
  
  public void setGifPath(String paramString)
  {
    AppMethodBeat.i(142364);
    this.HBG = true;
    try
    {
      this.HBH = c.lR(paramString, paramString);
      setImageDrawable(this.HBH);
      if (this.HBH != null) {
        cF(this.HBH.getIntrinsicWidth(), this.HBH.getIntrinsicHeight());
      }
      AppMethodBeat.o(142364);
      return;
    }
    catch (Exception paramString)
    {
      this.HBG = false;
      AppMethodBeat.o(142364);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142346);
    this.HBG = false;
    this.yss = paramBitmap;
    this.icd = false;
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
    this.HBz = paramBoolean;
  }
  
  public void setMaxZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(142340);
    if (Float.compare(paramFloat, 1.0F) < 0)
    {
      ac.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
      AppMethodBeat.o(142340);
      return;
    }
    this.HBx = paramFloat;
    AppMethodBeat.o(142340);
  }
  
  public void setMinZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(142341);
    if (Float.compare(paramFloat, 1.0F) > 0)
    {
      ac.w("MicroMsg.MultiTouchImageView", "min scale limit is greater than 1.0, change nothing, return");
      AppMethodBeat.o(142341);
      return;
    }
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      ac.w("MicroMsg.MultiTouchImageView", "min scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(142341);
      return;
    }
    this.HBw = paramFloat;
    AppMethodBeat.o(142341);
  }
  
  public void setOriginScale(float paramFloat)
  {
    this.HBy = paramFloat;
  }
  
  public final void start()
  {
    AppMethodBeat.i(142366);
    if ((this.HBG) && (this.HBH != null)) {
      ((a)this.HBH).start();
    }
    AppMethodBeat.o(142366);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */