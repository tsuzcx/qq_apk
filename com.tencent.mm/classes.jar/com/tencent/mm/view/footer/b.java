package com.tencent.mm.view.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View.MeasureSpec;
import com.tencent.mm.api.d;
import com.tencent.mm.api.p;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.bo.a.d;
import com.tencent.mm.bo.a.g;
import com.tencent.mm.bo.a.h;
import com.tencent.mm.sdk.platformtools.c;

public final class b
  extends a
{
  private Paint vXV;
  private Bitmap wya;
  private Bitmap wyb;
  private Bitmap wyc;
  private Bitmap wyd;
  private Bitmap wye;
  private Bitmap wyf;
  private Bitmap wyg;
  private Bitmap wyh;
  private Bitmap wyi;
  private Bitmap wyj;
  private Bitmap wyk;
  private Bitmap wyl;
  private Bitmap wym;
  private Bitmap wyn;
  private Rect[] wyo = new Rect[2];
  private Rect[] wyp = new Rect[4];
  private boolean wyq;
  private boolean wyr;
  private boolean wys;
  private boolean wyt;
  private boolean wyu = true;
  private int wyv = -1;
  
  public b(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext, paramb);
  }
  
  protected final boolean IS(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = super.IS(paramInt);
    switch (1.soJ[IR(paramInt).ordinal()])
    {
    default: 
      bool1 = bool2;
    }
    return bool1;
  }
  
  protected final Bitmap a(d paramd, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramd == d.buP) {
      if (paramBoolean) {
        localBitmap = this.wyd;
      }
    }
    while (paramd != d.buO)
    {
      return localBitmap;
      return this.wyc;
    }
    if (paramBoolean) {
      return this.wya;
    }
    return this.wyb;
  }
  
  protected final void cLD()
  {
    super.cLD();
    this.vXV = new Paint(1);
    this.vXV.setTextSize(getResources().getDimension(a.c.crop_reset_text_size));
    this.wye = BitmapFactory.decodeResource(getResources(), a.d.mosaic_one_unselected);
    this.wyf = BitmapFactory.decodeResource(getResources(), a.d.mosaic_one_selected);
    this.wyg = BitmapFactory.decodeResource(getResources(), a.d.mosaic_two_unselected);
    this.wyh = BitmapFactory.decodeResource(getResources(), a.d.mosaic_two_selected);
    this.wyb = c.q(getResources().getDrawable(a.g.mosaic_unselected));
    this.wya = c.q(getResources().getDrawable(a.g.mosaic_selected));
    this.wyc = c.q(getResources().getDrawable(a.g.crop_unselected));
    this.wyd = c.q(getResources().getDrawable(a.g.crop_selected));
    this.wyi = c.q(getResources().getDrawable(a.g.rotation_normal));
    this.wyj = c.q(getResources().getDrawable(a.g.rotation_press));
    this.wyl = c.q(getResources().getDrawable(a.g.sure_crop_press));
    this.wyk = c.q(getResources().getDrawable(a.g.sure_crop_normal));
    this.wym = c.q(getResources().getDrawable(a.g.cancel_crop_press));
    this.wyn = c.q(getResources().getDrawable(a.g.cancel_crop_normal));
  }
  
  protected final void cLF()
  {
    super.cLF();
    if (getCurFeatureType() == d.buO)
    {
      if (this.wyo == null) {
        this.wyo = new Rect[2];
      }
      if (this.wxS == null) {
        this.wxS = new Rect();
      }
      f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.wxM.getWidth() - this.wyh.getWidth() - this.wye.getWidth()) / 3.0F;
      k = (int)(this.wyg.getWidth() / 2 + f1);
      i = (getDetailHeight() - this.wyg.getWidth()) / 2 + this.wyg.getWidth() / 2;
      j = this.wyg.getWidth() * 2;
      this.wyo[0] = new Rect(k - j, i - j, k + j, i + j);
      f2 = k;
      k = (int)(f1 + this.wyg.getWidth() + f2);
      this.wyo[1] = new Rect(k - j, i - j, k + j, i + j);
      i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.wxM.getWidth() / 2;
      this.wxS.set(i - this.wxM.getWidth(), 0, i + this.wxM.getWidth(), getDetailHeight());
    }
    while (getCurFeatureType() != d.buP) {
      return;
    }
    if (this.wyp == null) {
      this.wyp = new Rect[4];
    }
    int i = (int)getResources().getDimension(a.c.crop_rotation_layout_height);
    float f1 = i / 2 - this.wyj.getHeight() / 2;
    float f2 = getResources().getDimension(a.c.feature_select_layout_height) / 2.0F;
    float f3 = this.wyn.getHeight() / 2;
    float f4 = i;
    float f5 = 1.0F * getPaddingLeftAndRight() / 2.0F;
    int j = (int)(f1 + this.wyn.getHeight() / 2);
    int k = (int)(f5 + this.wyn.getHeight() / 2);
    i = this.wyn.getHeight();
    this.wyp[0] = new Rect(k - i, j - i, k + i, j + i);
    j = (int)(f4 + (f2 - f3) + this.wyn.getHeight() / 2);
    this.wyp[1] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.wyn.getHeight() / 2;
    this.wyp[2] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() / 2;
    this.wyp[3] = new Rect(k - i, j - i, k + i, j + i);
  }
  
  protected final void fR(int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = 0;
    super.fR(paramInt1, paramInt2);
    switch (1.soJ[IR(this.hnL).ordinal()])
    {
    }
    do
    {
      return;
      do
      {
        i += 1;
        if (i >= this.wyo.length) {
          break;
        }
      } while (!this.wyo[i].contains(paramInt1, paramInt2));
      this.wyv = i;
      return;
      do
      {
        j += 1;
        if (j >= this.wyp.length) {
          break;
        }
      } while (!this.wyp[j].contains(paramInt1, paramInt2));
      if (j == 0)
      {
        this.wyr = true;
        return;
      }
      if (j == 1)
      {
        this.wyq = true;
        return;
      }
      if (j == 2)
      {
        this.wys = true;
        return;
      }
    } while (j != 3);
    this.wyt = true;
  }
  
  protected final void fS(int paramInt1, int paramInt2)
  {
    int i = 0;
    super.fS(paramInt1, paramInt2);
    switch (1.soJ[IR(this.hnL).ordinal()])
    {
    }
    for (;;)
    {
      return;
      Rect localRect;
      do
      {
        i += 1;
        if ((this.wyo == null) || (i >= this.wyo.length)) {
          break;
        }
        localRect = this.wyo[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)) || (i != this.wyv));
      getPresenter().getSelectedFeatureListener().a(d.buO, i);
      this.wxO = this.hnL;
      return;
      i = 0;
      while ((this.wyp != null) && (i < this.wyp.length))
      {
        localRect = this.wyp[i];
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          if (((i == 0) && (this.wyr)) || ((i == 1) && (this.wyq)) || ((i == 2) && (this.wys)) || ((i == 3) && (this.wyt)))
          {
            getPresenter().getSelectedFeatureListener().a(d.buP, i);
            this.wxO = this.hnL;
          }
          this.wyr = false;
          this.wyq = false;
          this.wys = false;
          this.wyt = false;
          return;
        }
        i += 1;
      }
    }
  }
  
  protected final int getDetailHeight()
  {
    int j = super.getDetailHeight();
    int i = j;
    if (j == 0)
    {
      if (getCurFeatureType() != d.buO) {
        break label35;
      }
      i = (int)getResources().getDimension(a.c.feature_select_detail_layout_height);
    }
    label35:
    do
    {
      return i;
      i = j;
    } while (getCurFeatureType() != d.buP);
    return (int)(getResources().getDimension(a.c.feature_select_layout_height) + getResources().getDimension(a.c.crop_rotation_layout_height));
  }
  
  protected final void n(Canvas paramCanvas)
  {
    if (getCurFeatureType() != d.buP)
    {
      super.n(paramCanvas);
      return;
    }
    o(paramCanvas);
  }
  
  protected final void o(Canvas paramCanvas)
  {
    super.o(paramCanvas);
    if (getCurFeatureType() == d.buO)
    {
      localPaint = new Paint();
      if (tM())
      {
        localPaint.setAlpha(255);
        if ((!this.wxT) || (!tM())) {
          break label227;
        }
        localBitmap = this.wxN;
        paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.wxM.getWidth(), (getDetailHeight() - this.wxM.getHeight()) / 2, localPaint);
        f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.wxM.getWidth() - this.wyh.getWidth() - this.wye.getWidth()) / 3.0F;
        f2 = (getDetailHeight() - this.wyh.getHeight()) * 1.0F / 2.0F;
        if (this.wyu)
        {
          this.wyv = 0;
          this.wyu = false;
        }
        if (this.wyv != 0) {
          break label236;
        }
        paramCanvas.drawBitmap(this.wyf, f1, f2, null);
        paramCanvas.drawBitmap(this.wyg, f1 + f1 + this.wyh.getWidth(), f2, null);
      }
    }
    label227:
    label236:
    while (getCurFeatureType() != d.buP)
    {
      for (;;)
      {
        Paint localPaint;
        return;
        localPaint.setAlpha(160);
        continue;
        Bitmap localBitmap = this.wxM;
      }
      if (this.wyv == 1)
      {
        paramCanvas.drawBitmap(this.wye, f1, f2, null);
        paramCanvas.drawBitmap(this.wyh, f1 + f1 + this.wyh.getWidth(), f2, null);
        return;
      }
      paramCanvas.drawBitmap(this.wye, f1, f2, null);
      paramCanvas.drawBitmap(this.wyg, f1 + f1 + this.wyh.getWidth(), f2, null);
      return;
    }
    int i = (int)getResources().getDimension(a.c.crop_rotation_layout_height);
    paramCanvas.drawLine(0.0F, i, getMeasuredWidth(), i, this.wxU);
    float f1 = getResources().getDimension(a.c.feature_select_layout_height) / 2.0F - this.wyn.getHeight() / 2 + i;
    float f2 = getPaddingLeftAndRight() * 1.0F / 2.0F;
    float f3 = i / 2 - this.wyj.getHeight() / 2;
    if (this.wyr)
    {
      paramCanvas.drawBitmap(this.wyj, f2, f3, null);
      if (!this.wys) {
        break label608;
      }
      paramCanvas.drawBitmap(this.wyl, getMeasuredWidth() - f2 - this.wyn.getWidth(), f1, null);
      label462:
      if (!this.wyq) {
        break label637;
      }
      paramCanvas.drawBitmap(this.wym, f2, f1, null);
    }
    for (;;)
    {
      f1 = getResources().getDimension(a.c.crop_reset_text_size) * 2.0F;
      f2 = getResources().getDimension(a.c.crop_reset_text_size);
      f3 = getResources().getDimension(a.c.feature_select_layout_height) / 2.0F;
      f2 = (f2 - 8.0F) / 2.0F + f3 + i;
      f3 = getMeasuredWidth() / 2;
      if (!this.wyt) {
        break label651;
      }
      this.vXV.setColor(-1);
      this.vXV.setAlpha(160);
      paramCanvas.drawText(getResources().getString(a.h.crop_reset), f3 - f1 / 2.0F, f2, this.vXV);
      return;
      paramCanvas.drawBitmap(this.wyi, f2, f3, null);
      break;
      label608:
      paramCanvas.drawBitmap(this.wyk, getMeasuredWidth() - f2 - this.wyn.getWidth(), f1, null);
      break label462;
      label637:
      paramCanvas.drawBitmap(this.wyn, f2, f1, null);
    }
    label651:
    if (tM())
    {
      this.vXV.setColor(-1);
      this.vXV.setAlpha(255);
      paramCanvas.drawText(getResources().getString(a.h.crop_reset), f3 - f1 / 2.0F, f2, this.vXV);
      return;
    }
    this.vXV.setColor(-1);
    this.vXV.setAlpha(100);
    paramCanvas.drawText(getResources().getString(a.h.crop_reset), f3 - f1 / 2.0F, f2, this.vXV);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if (getCurFeatureType() != d.buP)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = getPaddingLeft();
    int i = getPaddingRight();
    int j = View.MeasureSpec.makeMeasureSpec(getDetailHeight(), 1073741824);
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt2 - i, 1073741824), j);
    cLF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.footer.b
 * JD-Core Version:    0.7.0.1
 */