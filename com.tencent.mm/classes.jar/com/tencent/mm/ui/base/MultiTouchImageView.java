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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.f.b.a;
import com.tencent.mm.ui.f.b.c;

public class MultiTouchImageView
  extends ImageView
  implements g
{
  protected Matrix asS;
  private float atf;
  private int imageHeight;
  private int imageWidth;
  private boolean isInited;
  private boolean jeA;
  private int jgD;
  private int jgE;
  protected ak mHandler;
  private MultiTouchImageView.a rRA;
  private boolean rRd;
  protected Bitmap rzS;
  private final float[] uA;
  protected Matrix zoa;
  private final Matrix zob;
  int zoc;
  int zod;
  private float zoe;
  private float zof;
  private float zog;
  private float zoh;
  private float zoi;
  private float zoj;
  private float zok;
  private boolean zol;
  public boolean zom;
  public boolean zon;
  private float zoo;
  private float zop;
  float zoq;
  public boolean zor;
  public Drawable zos;
  
  public MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, paramInt1, paramInt2, null);
  }
  
  public MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2, MultiTouchImageView.a parama)
  {
    super(paramContext);
    AppMethodBeat.i(106977);
    this.zoa = new Matrix();
    this.asS = new Matrix();
    this.zob = new Matrix();
    this.uA = new float[9];
    this.rzS = null;
    this.zoc = -1;
    this.zod = -1;
    this.zoe = 0.0F;
    this.zof = 0.0F;
    this.zog = 0.0F;
    this.isInited = false;
    this.jeA = false;
    this.zoi = 2.0F;
    this.zoj = 0.75F;
    this.zok = 20.0F;
    this.zol = false;
    this.zom = false;
    this.zon = false;
    this.rRd = true;
    this.mHandler = new ak();
    this.atf = 1.0F;
    this.zoq = 0.0F;
    this.zor = false;
    this.imageHeight = paramInt2;
    this.imageWidth = paramInt1;
    this.rRA = parama;
    init();
    AppMethodBeat.o(106977);
  }
  
  public MultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private MultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106978);
    this.zoa = new Matrix();
    this.asS = new Matrix();
    this.zob = new Matrix();
    this.uA = new float[9];
    this.rzS = null;
    this.zoc = -1;
    this.zod = -1;
    this.zoe = 0.0F;
    this.zof = 0.0F;
    this.zog = 0.0F;
    this.isInited = false;
    this.jeA = false;
    this.zoi = 2.0F;
    this.zoj = 0.75F;
    this.zok = 20.0F;
    this.zol = false;
    this.zom = false;
    this.zon = false;
    this.rRd = true;
    this.mHandler = new ak();
    this.atf = 1.0F;
    this.zoq = 0.0F;
    this.zor = false;
    this.imageHeight = 0;
    this.imageWidth = 0;
    init();
    AppMethodBeat.o(106978);
  }
  
  private void aj(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(106986);
    if ((this.rzS == null) && (!this.zor))
    {
      AppMethodBeat.o(106986);
      return;
    }
    if ((this.zos == null) && (this.zor))
    {
      AppMethodBeat.o(106986);
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF;
    float f1;
    float f4;
    if (this.zor)
    {
      localRectF = new RectF(0.0F, 0.0F, this.zos.getIntrinsicWidth(), this.zos.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f4 = localRectF.width();
      if (!paramBoolean2) {
        break label296;
      }
      if (f1 >= this.jgE) {
        break label247;
      }
      f1 = (this.jgE - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label139:
      if (paramBoolean1) {
        if (f4 < this.jgD) {
          f2 = (this.jgD - f4) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        ap(f2, f1);
        localMatrix = getImageViewMatrix();
        setImageMatrix(localMatrix);
        localMatrix.mapRect(localRectF);
        localRectF.height();
        localRectF.width();
        AppMethodBeat.o(106986);
        return;
        localRectF = new RectF(0.0F, 0.0F, this.rzS.getWidth(), this.rzS.getHeight());
        break;
        label247:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label139;
        }
        if (localRectF.bottom >= this.jgE) {
          break label519;
        }
        f1 = this.jgE - localRectF.bottom;
        break label139;
        label296:
        f1 = localRectF.top;
        float f5 = this.jgE - localRectF.bottom;
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
        if (localRectF.bottom >= this.jgE) {
          break label519;
        }
        f1 = f5 - f1;
        break label139;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.jgD)
        {
          f2 = this.jgD - localRectF.right;
          continue;
          f3 = localRectF.left;
          f5 = this.jgD - localRectF.right;
          f4 = (f3 + f5) / 2.0F;
          f3 = f4;
          if (f4 < 0.0F) {
            f3 = 0.0F;
          }
          if (localRectF.left > 0.0F) {
            f2 = f3 - localRectF.left;
          } else if (localRectF.right < this.jgD) {
            f2 = f5 - f3;
          }
        }
      }
      label519:
      f1 = 0.0F;
    }
  }
  
  private void dEz()
  {
    boolean bool2 = true;
    this.zoo = (this.jgD / this.imageWidth);
    this.zop = (this.jgE / this.imageHeight);
    if (this.imageWidth > this.imageHeight * 2.2F)
    {
      bool1 = true;
      this.zom = bool1;
      if (this.imageHeight <= this.imageWidth * 2.2F) {
        break label215;
      }
      bool1 = true;
      label79:
      this.zon = bool1;
      if ((!this.zom) || (this.imageWidth <= this.jgD)) {
        break label221;
      }
      bool1 = true;
      label106:
      this.zom = bool1;
      if ((!this.zon) || (this.imageHeight <= this.jgE)) {
        break label227;
      }
    }
    label215:
    label221:
    label227:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.zon = bool1;
      float f3 = this.imageHeight / this.imageWidth;
      float f2 = 1.8F;
      float f1 = f2;
      if (this.jgD != 0)
      {
        f1 = f2;
        if (this.jgE != 0) {
          f1 = this.jgE / this.jgD;
        }
      }
      if ((f3 <= f1) || (f3 > 2.2D)) {
        break label233;
      }
      this.zoh = this.zop;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      bool1 = false;
      break label106;
    }
    label233:
    this.zoh = this.zoo;
  }
  
  private void init()
  {
    AppMethodBeat.i(106987);
    ab.d("dktest", "init screenWidth:" + this.jgD + " screenHeight :" + this.jgE);
    setScaleType(ImageView.ScaleType.MATRIX);
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.atf = f;
    }
    dDJ();
    AppMethodBeat.o(106987);
  }
  
  private void l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(106995);
    paramFloat1 = (paramFloat1 - getScale()) / 128.0F;
    float f = getScale();
    long l = System.currentTimeMillis();
    this.mHandler.post(new MultiTouchImageView.1(this, l, f, paramFloat1, paramFloat2, paramFloat3));
    AppMethodBeat.o(106995);
  }
  
  public final void an(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(106983);
    dEz();
    l(this.zoh, paramFloat1, paramFloat2);
    AppMethodBeat.o(106983);
  }
  
  public final void ao(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(106994);
    this.zoe = getDoubleTabScale();
    l(this.zoe, paramFloat1, paramFloat2);
    AppMethodBeat.o(106994);
  }
  
  public final void ap(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(106997);
    this.asS.postTranslate(paramFloat1, paramFloat2);
    setImageMatrix(getImageViewMatrix());
    AppMethodBeat.o(106997);
  }
  
  public final void cb(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public final boolean dDH()
  {
    return this.zom;
  }
  
  public final boolean dDI()
  {
    return this.zon;
  }
  
  public final void dDJ()
  {
    AppMethodBeat.i(106982);
    this.asS.reset();
    dEz();
    k(this.zoh, 0.0F, 0.0F);
    AppMethodBeat.o(106982);
  }
  
  public final void dDK()
  {
    AppMethodBeat.i(106991);
    if ((this.zol) && (0.0F == this.zoe)) {
      this.zoe = getDoubleTabScale();
    }
    AppMethodBeat.o(106991);
  }
  
  public final void dEA()
  {
    boolean bool2 = true;
    AppMethodBeat.i(106990);
    boolean bool1;
    if ((!this.rRd) || (!this.zom))
    {
      bool1 = true;
      if (this.zon) {
        break label49;
      }
    }
    for (;;)
    {
      aj(bool1, bool2);
      AppMethodBeat.o(106990);
      return;
      bool1 = false;
      break;
      label49:
      bool2 = false;
    }
  }
  
  public float getDoubleTabScale()
  {
    AppMethodBeat.i(106993);
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
      AppMethodBeat.o(106993);
      return f1;
      if (getScaleHeight() * 0.7F > f1) {
        f1 = getScaleHeight();
      } else {
        f1 = getScaleRate() * this.zoi;
      }
    }
  }
  
  public int getImageHeight()
  {
    return this.imageHeight;
  }
  
  protected Matrix getImageViewMatrix()
  {
    AppMethodBeat.i(106989);
    this.zob.set(this.zoa);
    this.zob.postConcat(this.asS);
    Matrix localMatrix = this.zob;
    AppMethodBeat.o(106989);
    return localMatrix;
  }
  
  public int getImageWidth()
  {
    return this.imageWidth;
  }
  
  public float getMaxZoom()
  {
    return this.zof;
  }
  
  public float getMinZoom()
  {
    return this.zog;
  }
  
  public float getRealWidth()
  {
    AppMethodBeat.i(106996);
    float f1 = getScale();
    float f2 = getImageWidth();
    AppMethodBeat.o(106996);
    return f1 * f2;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(106988);
    this.asS.getValues(this.uA);
    dEz();
    this.zof = (this.zok * this.atf);
    this.zog = (this.zoh * this.zoj);
    if (this.zof < 1.0F) {
      this.zof = 1.0F;
    }
    if (this.zog > 1.0F) {
      this.zog = 1.0F;
    }
    float f = this.uA[0];
    AppMethodBeat.o(106988);
    return f;
  }
  
  public float getScaleHeight()
  {
    return this.zop;
  }
  
  public float getScaleRate()
  {
    return this.zoh;
  }
  
  public float getScaleWidth()
  {
    return this.zoo;
  }
  
  public final void hz(int paramInt1, int paramInt2)
  {
    this.jgE = paramInt2;
    this.jgD = paramInt1;
  }
  
  public final void k(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool2 = true;
    AppMethodBeat.i(106992);
    float f2 = getScale();
    float f1;
    label78:
    boolean bool1;
    if (this.zol)
    {
      if (0.0F == this.zoe)
      {
        f1 = this.zok * this.atf;
        this.zof = f1;
      }
    }
    else
    {
      if (paramFloat1 <= this.zof * 2.0F) {
        break label181;
      }
      f1 = this.zof * 2.0F + (paramFloat1 - this.zof) * 0.1F;
      paramFloat1 = f1 / f2;
      if (!this.zor)
      {
        setImageMatrix(getImageViewMatrix());
        this.asS.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      if ((this.rRd) && (this.zom)) {
        break label202;
      }
      bool1 = true;
      label128:
      if (this.zon) {
        break label208;
      }
    }
    for (;;)
    {
      aj(bool1, bool2);
      if (this.rRA == null) {
        break label229;
      }
      if (paramFloat1 <= 1.0F) {
        break label214;
      }
      this.rRA.cvq();
      AppMethodBeat.o(106992);
      return;
      f1 = this.zoe;
      break;
      label181:
      f1 = paramFloat1;
      if (paramFloat1 >= this.zog) {
        break label78;
      }
      f1 = this.zog;
      break label78;
      label202:
      bool1 = false;
      break label128;
      label208:
      bool2 = false;
    }
    label214:
    if (paramFloat1 < 1.0F) {
      this.rRA.cvp();
    }
    label229:
    AppMethodBeat.o(106992);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.isInited = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106981);
    if ((!this.zor) && (this.rzS != null) && (this.rzS.isRecycled()))
    {
      ab.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
      AppMethodBeat.o(106981);
      return;
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(106981);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106984);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      f.c(paramKeyEvent);
      AppMethodBeat.o(106984);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(106984);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106985);
    if ((paramInt == 4) && (f.d(paramKeyEvent)) && (!f.e(paramKeyEvent)) && (getScale() > 1.0F))
    {
      k(1.0F, this.jgD / 2.0F, this.jgE / 2.0F);
      AppMethodBeat.o(106985);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(106985);
    return bool;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106979);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.jgD != View.MeasureSpec.getSize(paramInt1)) || (this.jgE != View.MeasureSpec.getSize(paramInt2))) {}
    for (this.jeA = true;; this.jeA = false)
    {
      this.jgD = View.MeasureSpec.getSize(paramInt1);
      this.jgE = View.MeasureSpec.getSize(paramInt2);
      if (!this.isInited)
      {
        this.isInited = true;
        init();
      }
      if (this.jeA) {
        dDJ();
      }
      AppMethodBeat.o(106979);
      return;
    }
  }
  
  public void setDoubleTabScaleLimit(float paramFloat)
  {
    AppMethodBeat.i(106976);
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      ab.w("MicroMsg.MultiTouchImageView", "double tab scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(106976);
      return;
    }
    this.zoi = paramFloat;
    AppMethodBeat.o(106976);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.rRd = paramBoolean;
  }
  
  public void setGifDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(106999);
    this.zor = true;
    this.zos = paramDrawable;
    setImageDrawable(this.zos);
    AppMethodBeat.o(106999);
  }
  
  public void setGifPath(String paramString)
  {
    AppMethodBeat.i(106998);
    this.zor = true;
    try
    {
      this.zos = c.iB(paramString, paramString);
      setImageDrawable(this.zos);
      if (this.zos != null) {
        cb(this.zos.getIntrinsicWidth(), this.zos.getIntrinsicHeight());
      }
      AppMethodBeat.o(106998);
      return;
    }
    catch (Exception paramString)
    {
      this.zor = false;
      AppMethodBeat.o(106998);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(106980);
    this.zor = false;
    this.rzS = paramBitmap;
    this.isInited = false;
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(106980);
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
    this.zol = paramBoolean;
  }
  
  public void setMaxZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(106974);
    if (Float.compare(paramFloat, 1.0F) < 0)
    {
      ab.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
      AppMethodBeat.o(106974);
      return;
    }
    this.zok = paramFloat;
    AppMethodBeat.o(106974);
  }
  
  public void setMinZoomLimit(float paramFloat)
  {
    AppMethodBeat.i(106975);
    if (Float.compare(paramFloat, 1.0F) > 0)
    {
      ab.w("MicroMsg.MultiTouchImageView", "min scale limit is greater than 1.0, change nothing, return");
      AppMethodBeat.o(106975);
      return;
    }
    if (Float.compare(paramFloat, 0.0F) < 0)
    {
      ab.w("MicroMsg.MultiTouchImageView", "min scale limit is less than 0.0, change nothing, return");
      AppMethodBeat.o(106975);
      return;
    }
    this.zoj = paramFloat;
    AppMethodBeat.o(106975);
  }
  
  public final void start()
  {
    AppMethodBeat.i(107000);
    if ((this.zor) && (this.zos != null)) {
      ((a)this.zos).start();
    }
    AppMethodBeat.o(107000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */