package com.tencent.mm.view.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.api.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;

public final class b
  extends a
{
  private Bitmap HZG;
  private Bitmap HZH;
  private Bitmap HZI;
  private Bitmap HZJ;
  private Bitmap HZK;
  private Bitmap HZL;
  private Bitmap HZM;
  private Bitmap HZN;
  private Bitmap HZO;
  private Bitmap HZP;
  private Bitmap HZQ;
  private Bitmap HZR;
  private Bitmap HZS;
  private Bitmap HZT;
  private Rect[] HZU;
  private Rect[] HZV;
  private boolean HZW;
  private boolean HZX;
  private boolean HZY;
  private boolean HZZ;
  private boolean Iaa;
  private int Iab;
  private Paint tju;
  
  public b(Context paramContext, com.tencent.mm.bu.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(9405);
    this.HZU = new Rect[2];
    this.HZV = new Rect[4];
    this.Iaa = true;
    this.Iab = -1;
    AppMethodBeat.o(9405);
  }
  
  private void fiZ()
  {
    AppMethodBeat.i(9414);
    if (this.HZU == null) {
      this.HZU = new Rect[2];
    }
    if (this.HZw == null) {
      this.HZw = new Rect();
    }
    float f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.HZq.getWidth() - this.HZN.getWidth() - this.HZK.getWidth()) / 3.0F;
    int k = (int)(this.HZM.getWidth() / 2 + f1);
    int i = (getDetailHeight() - this.HZM.getWidth()) / 2 + this.HZM.getWidth() / 2;
    int j = this.HZM.getWidth() * 2;
    this.HZU[0] = new Rect(k - j, i - j, k + j, i + j);
    float f2 = k;
    k = (int)(f1 + this.HZM.getWidth() + f2);
    this.HZU[1] = new Rect(k - j, i - j, k + j, i + j);
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.HZq.getWidth() / 2;
    this.HZw.set(i - this.HZq.getWidth(), 0, i + this.HZq.getWidth(), getDetailHeight());
    AppMethodBeat.o(9414);
  }
  
  private void fja()
  {
    AppMethodBeat.i(9415);
    if (this.HZV == null) {
      this.HZV = new Rect[4];
    }
    int i = (int)getResources().getDimension(2131166083);
    float f1 = i / 2 - this.HZP.getHeight() / 2;
    float f2 = getResources().getDimension(2131166289) / 2.0F;
    float f3 = this.HZT.getHeight() / 2;
    float f4 = i;
    float f5 = 1.0F * getPaddingLeftAndRight() / 2.0F;
    int j = (int)(f1 + this.HZT.getHeight() / 2);
    int k = (int)(f5 + this.HZT.getHeight() / 2);
    i = this.HZT.getHeight();
    this.HZV[0] = new Rect(k - i, j - i, k + i, j + i);
    j = (int)(f4 + (f2 - f3) + this.HZT.getHeight() / 2);
    this.HZV[1] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.HZT.getHeight() / 2;
    this.HZV[2] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() / 2;
    this.HZV[3] = new Rect(k - i, j - i, k + i, j + i);
    AppMethodBeat.o(9415);
  }
  
  protected final Bitmap a(g paramg, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramg == g.cJw) {
      if (paramBoolean) {
        localBitmap = this.HZJ;
      }
    }
    while (paramg != g.cJv)
    {
      return localBitmap;
      return this.HZI;
    }
    if (paramBoolean) {
      return this.HZG;
    }
    return this.HZH;
  }
  
  protected final boolean abl(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(9410);
    boolean bool2 = super.abl(paramInt);
    switch (1.Cpr[abk(paramInt).ordinal()])
    {
    default: 
      bool1 = bool2;
    }
    AppMethodBeat.o(9410);
    return bool1;
  }
  
  protected final void fiT()
  {
    AppMethodBeat.i(9406);
    super.fiT();
    this.tju = new Paint(1);
    this.tju.setTextSize(getResources().getDimension(2131166082));
    this.HZK = BitmapFactory.decodeResource(getResources(), 2131233346);
    this.HZL = BitmapFactory.decodeResource(getResources(), 2131233345);
    this.HZM = BitmapFactory.decodeResource(getResources(), 2131233348);
    this.HZN = BitmapFactory.decodeResource(getResources(), 2131233347);
    this.HZH = f.B(getResources().getDrawable(2131690855));
    this.HZG = f.B(getResources().getDrawable(2131690854));
    this.HZI = f.B(getResources().getDrawable(2131690008));
    this.HZJ = f.B(getResources().getDrawable(2131690007));
    this.HZO = f.B(getResources().getDrawable(2131691102));
    this.HZP = f.B(getResources().getDrawable(2131691103));
    this.HZR = f.B(getResources().getDrawable(2131691268));
    this.HZQ = f.B(getResources().getDrawable(2131691267));
    this.HZS = f.B(getResources().getDrawable(2131689858));
    this.HZT = f.B(getResources().getDrawable(2131689857));
    AppMethodBeat.o(9406);
  }
  
  protected final void fiV()
  {
    AppMethodBeat.i(9413);
    super.fiV();
    if (getCurFeatureType() == g.cJv)
    {
      fiZ();
      AppMethodBeat.o(9413);
      return;
    }
    if (getCurFeatureType() == g.cJw) {
      fja();
    }
    AppMethodBeat.o(9413);
  }
  
  protected final int getDetailHeight()
  {
    AppMethodBeat.i(9409);
    int i = super.getDetailHeight();
    if (i == 0)
    {
      if (getCurFeatureType() == g.cJv)
      {
        i = (int)getResources().getDimension(2131166288);
        AppMethodBeat.o(9409);
        return i;
      }
      if (getCurFeatureType() == g.cJw)
      {
        i = (int)(getResources().getDimension(2131166289) + getResources().getDimension(2131166083));
        AppMethodBeat.o(9409);
        return i;
      }
    }
    AppMethodBeat.o(9409);
    return i;
  }
  
  protected final void jV(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9411);
    super.jV(paramInt1, paramInt2);
    switch (1.Cpr[abk(this.mmW).ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(9411);
      return;
      i = 0;
      Rect localRect;
      while (i < this.HZU.length)
      {
        localRect = this.HZU[i];
        if (localRect == null) {
          ad.e("PhotoFooterView", "[onDetailTouchDispatch] detailRect is null! %s", new Object[] { Integer.valueOf(i) });
        }
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          this.Iab = i;
          AppMethodBeat.o(9411);
          return;
        }
        i += 1;
      }
      AppMethodBeat.o(9411);
      return;
      do
      {
        i += 1;
        if (i >= this.HZV.length) {
          break;
        }
        localRect = this.HZV[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)));
      if (i == 0)
      {
        this.HZX = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 1)
      {
        this.HZW = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 2)
      {
        this.HZY = true;
        AppMethodBeat.o(9411);
        return;
      }
    } while (i != 3);
    this.HZZ = true;
    AppMethodBeat.o(9411);
  }
  
  protected final void jW(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9412);
    super.jW(paramInt1, paramInt2);
    switch (1.Cpr[abk(this.mmW).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(9412);
      return;
      Rect localRect;
      do
      {
        i += 1;
        if ((this.HZU == null) || (i >= this.HZU.length)) {
          break;
        }
        localRect = this.HZU[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)) || (i != this.Iab));
      getPresenter().getSelectedFeatureListener().a(g.cJv, i, null);
      this.HZs = this.mmW;
      AppMethodBeat.o(9412);
      return;
      AppMethodBeat.o(9412);
      return;
      i = 0;
      while ((this.HZV != null) && (i < this.HZV.length))
      {
        localRect = this.HZV[i];
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          if (((i == 0) && (this.HZX)) || ((i == 1) && (this.HZW)) || ((i == 2) && (this.HZY)) || ((i == 3) && (this.HZZ)))
          {
            getPresenter().getSelectedFeatureListener().a(g.cJw, i, null);
            this.HZs = this.mmW;
          }
          this.HZX = false;
          this.HZW = false;
          this.HZY = false;
          this.HZZ = false;
          AppMethodBeat.o(9412);
          return;
        }
        i += 1;
      }
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9407);
    if (getCurFeatureType() != g.cJw)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(9407);
      return;
    }
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = getPaddingLeft();
    int i = getPaddingRight();
    int j = View.MeasureSpec.makeMeasureSpec(getDetailHeight(), 1073741824);
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt2 - i, 1073741824), j);
    fiV();
    AppMethodBeat.o(9407);
  }
  
  protected final void r(Canvas paramCanvas)
  {
    AppMethodBeat.i(9408);
    if (!this.HZB)
    {
      if (getCurFeatureType() != g.cJw)
      {
        super.r(paramCanvas);
        AppMethodBeat.o(9408);
        return;
      }
      s(paramCanvas);
    }
    AppMethodBeat.o(9408);
  }
  
  protected final void s(Canvas paramCanvas)
  {
    AppMethodBeat.i(9416);
    super.s(paramCanvas);
    float f1;
    float f2;
    if (getCurFeatureType() == g.cJv)
    {
      Paint localPaint = new Paint();
      if (Mg())
      {
        localPaint.setAlpha(255);
        if ((!this.HZx) || (!Mg())) {
          break label239;
        }
      }
      label239:
      for (Bitmap localBitmap = this.HZr;; localBitmap = this.HZq)
      {
        paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.HZq.getWidth(), (getDetailHeight() - this.HZq.getHeight()) / 2, localPaint);
        f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.HZq.getWidth() - this.HZN.getWidth() - this.HZK.getWidth()) / 3.0F;
        f2 = 1.0F * (getDetailHeight() - this.HZN.getHeight()) / 2.0F;
        if (this.Iaa)
        {
          this.Iab = 0;
          this.Iaa = false;
        }
        if (this.Iab != 0) {
          break label248;
        }
        paramCanvas.drawBitmap(this.HZL, f1, f2, null);
        paramCanvas.drawBitmap(this.HZM, f1 + f1 + this.HZN.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
        localPaint.setAlpha(160);
        break;
      }
      label248:
      if (this.Iab == 1)
      {
        paramCanvas.drawBitmap(this.HZK, f1, f2, null);
        paramCanvas.drawBitmap(this.HZN, f1 + f1 + this.HZN.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
      }
      paramCanvas.drawBitmap(this.HZK, f1, f2, null);
      paramCanvas.drawBitmap(this.HZM, f1 + f1 + this.HZN.getWidth(), f2, null);
      AppMethodBeat.o(9416);
      return;
    }
    if (getCurFeatureType() == g.cJw)
    {
      int i = (int)getResources().getDimension(2131166083);
      paramCanvas.drawLine(0.0F, i, getMeasuredWidth(), i, this.HZz);
      f1 = getResources().getDimension(2131166289) / 2.0F - this.HZT.getHeight() / 2 + i;
      f2 = 1.0F * getPaddingLeftAndRight() / 2.0F;
      float f3 = i / 2 - this.HZP.getHeight() / 2;
      if (this.HZX)
      {
        paramCanvas.drawBitmap(this.HZP, f2, f3, null);
        if (!this.HZY) {
          break label633;
        }
        paramCanvas.drawBitmap(this.HZR, getMeasuredWidth() - f2 - this.HZT.getWidth(), f1, null);
        label484:
        if (!this.HZW) {
          break label662;
        }
        paramCanvas.drawBitmap(this.HZS, f2, f1, null);
      }
      for (;;)
      {
        f1 = getResources().getDimension(2131166082) * 2.0F;
        f2 = getResources().getDimension(2131166082);
        f3 = getResources().getDimension(2131166289) / 2.0F;
        f2 = (f2 - 8.0F) / 2.0F + f3 + i;
        f3 = getMeasuredWidth() / 2;
        if (!this.HZZ) {
          break label676;
        }
        this.tju.setColor(-1);
        this.tju.setAlpha(160);
        paramCanvas.drawText(getResources().getString(2131757966), f3 - f1 / 2.0F, f2, this.tju);
        AppMethodBeat.o(9416);
        return;
        paramCanvas.drawBitmap(this.HZO, f2, f3, null);
        break;
        label633:
        paramCanvas.drawBitmap(this.HZQ, getMeasuredWidth() - f2 - this.HZT.getWidth(), f1, null);
        break label484;
        label662:
        paramCanvas.drawBitmap(this.HZT, f2, f1, null);
      }
      label676:
      if (Mg())
      {
        this.tju.setColor(-1);
        this.tju.setAlpha(255);
        paramCanvas.drawText(getResources().getString(2131757966), f3 - f1 / 2.0F, f2, this.tju);
        AppMethodBeat.o(9416);
        return;
      }
      this.tju.setColor(-1);
      this.tju.setAlpha(100);
      paramCanvas.drawText(getResources().getString(2131757966), f3 - f1 / 2.0F, f2, this.tju);
    }
    AppMethodBeat.o(9416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.footer.b
 * JD-Core Version:    0.7.0.1
 */