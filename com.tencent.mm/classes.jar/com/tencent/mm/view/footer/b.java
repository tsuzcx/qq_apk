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
import com.tencent.mm.api.w;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends a
{
  private Bitmap LtD;
  private Bitmap LtE;
  private Bitmap LtF;
  private Bitmap LtG;
  private Bitmap LtH;
  private Bitmap LtI;
  private Bitmap LtJ;
  private Bitmap LtK;
  private Bitmap LtL;
  private Bitmap LtM;
  private Bitmap LtN;
  private Bitmap LtO;
  private Bitmap LtP;
  private Bitmap LtQ;
  private Rect[] LtR;
  private Rect[] LtS;
  private boolean LtT;
  private boolean LtU;
  private boolean LtV;
  private boolean LtW;
  private boolean LtX;
  private int LtY;
  private Paint vuq;
  
  public b(Context paramContext, com.tencent.mm.bu.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(9405);
    this.LtR = new Rect[2];
    this.LtS = new Rect[4];
    this.LtX = true;
    this.LtY = -1;
    AppMethodBeat.o(9405);
  }
  
  private void fQv()
  {
    AppMethodBeat.i(9414);
    if (this.LtR == null) {
      this.LtR = new Rect[2];
    }
    if (this.Ltt == null) {
      this.Ltt = new Rect();
    }
    float f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.Ltn.getWidth() - this.LtK.getWidth() - this.LtH.getWidth()) / 3.0F;
    int k = (int)(this.LtJ.getWidth() / 2 + f1);
    int i = (getDetailHeight() - this.LtJ.getWidth()) / 2 + this.LtJ.getWidth() / 2;
    int j = this.LtJ.getWidth() * 2;
    this.LtR[0] = new Rect(k - j, i - j, k + j, i + j);
    float f2 = k;
    k = (int)(f1 + this.LtJ.getWidth() + f2);
    this.LtR[1] = new Rect(k - j, i - j, k + j, i + j);
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.Ltn.getWidth() / 2;
    this.Ltt.set(i - this.Ltn.getWidth(), 0, i + this.Ltn.getWidth(), getDetailHeight());
    AppMethodBeat.o(9414);
  }
  
  private void fQw()
  {
    AppMethodBeat.i(9415);
    if (this.LtS == null) {
      this.LtS = new Rect[4];
    }
    int i = (int)getResources().getDimension(2131166083);
    float f1 = i / 2 - this.LtM.getHeight() / 2;
    float f2 = getResources().getDimension(2131166289) / 2.0F;
    float f3 = this.LtQ.getHeight() / 2;
    float f4 = i;
    float f5 = 1.0F * getPaddingLeftAndRight() / 2.0F;
    int j = (int)(f1 + this.LtQ.getHeight() / 2);
    int k = (int)(f5 + this.LtQ.getHeight() / 2);
    i = this.LtQ.getHeight();
    this.LtS[0] = new Rect(k - i, j - i, k + i, j + i);
    j = (int)(f4 + (f2 - f3) + this.LtQ.getHeight() / 2);
    this.LtS[1] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.LtQ.getHeight() / 2;
    this.LtS[2] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() / 2;
    this.LtS[3] = new Rect(k - i, j - i, k + i, j + i);
    AppMethodBeat.o(9415);
  }
  
  protected final Bitmap a(com.tencent.mm.api.g paramg, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramg == com.tencent.mm.api.g.cRH) {
      if (paramBoolean) {
        localBitmap = this.LtG;
      }
    }
    while (paramg != com.tencent.mm.api.g.cRG)
    {
      return localBitmap;
      return this.LtF;
    }
    if (paramBoolean) {
      return this.LtD;
    }
    return this.LtE;
  }
  
  protected final boolean agd(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(9410);
    boolean bool2 = super.agd(paramInt);
    switch (1.FmQ[agc(paramInt).ordinal()])
    {
    default: 
      bool1 = bool2;
    }
    AppMethodBeat.o(9410);
    return bool1;
  }
  
  protected final void fQp()
  {
    AppMethodBeat.i(9406);
    super.fQp();
    this.vuq = new Paint(1);
    this.vuq.setTextSize(getResources().getDimension(2131166082));
    this.LtH = BitmapFactory.decodeResource(getResources(), 2131233346);
    this.LtI = BitmapFactory.decodeResource(getResources(), 2131233345);
    this.LtJ = BitmapFactory.decodeResource(getResources(), 2131233348);
    this.LtK = BitmapFactory.decodeResource(getResources(), 2131233347);
    this.LtE = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131690855));
    this.LtD = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131690854));
    this.LtF = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131690008));
    this.LtG = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131690007));
    this.LtL = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131691102));
    this.LtM = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131691103));
    this.LtO = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131691268));
    this.LtN = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131691267));
    this.LtP = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131689858));
    this.LtQ = com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131689857));
    AppMethodBeat.o(9406);
  }
  
  protected final void fQr()
  {
    AppMethodBeat.i(9413);
    super.fQr();
    if (getCurFeatureType() == com.tencent.mm.api.g.cRG)
    {
      fQv();
      AppMethodBeat.o(9413);
      return;
    }
    if (getCurFeatureType() == com.tencent.mm.api.g.cRH) {
      fQw();
    }
    AppMethodBeat.o(9413);
  }
  
  protected final int getDetailHeight()
  {
    AppMethodBeat.i(9409);
    int i = super.getDetailHeight();
    if (i == 0)
    {
      if (getCurFeatureType() == com.tencent.mm.api.g.cRG)
      {
        i = (int)getResources().getDimension(2131166288);
        AppMethodBeat.o(9409);
        return i;
      }
      if (getCurFeatureType() == com.tencent.mm.api.g.cRH)
      {
        i = (int)(getResources().getDimension(2131166289) + getResources().getDimension(2131166083));
        AppMethodBeat.o(9409);
        return i;
      }
    }
    AppMethodBeat.o(9409);
    return i;
  }
  
  protected final void kx(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9411);
    super.kx(paramInt1, paramInt2);
    switch (1.FmQ[agc(this.npu).ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(9411);
      return;
      i = 0;
      Rect localRect;
      while (i < this.LtR.length)
      {
        localRect = this.LtR[i];
        if (localRect == null) {
          ad.e("PhotoFooterView", "[onDetailTouchDispatch] detailRect is null! %s", new Object[] { Integer.valueOf(i) });
        }
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          this.LtY = i;
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
        if (i >= this.LtS.length) {
          break;
        }
        localRect = this.LtS[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)));
      if (i == 0)
      {
        this.LtU = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 1)
      {
        this.LtT = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 2)
      {
        this.LtV = true;
        AppMethodBeat.o(9411);
        return;
      }
    } while (i != 3);
    this.LtW = true;
    AppMethodBeat.o(9411);
  }
  
  protected final void ky(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9412);
    super.ky(paramInt1, paramInt2);
    switch (1.FmQ[agc(this.npu).ordinal()])
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
        if ((this.LtR == null) || (i >= this.LtR.length)) {
          break;
        }
        localRect = this.LtR[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)) || (i != this.LtY));
      getPresenter().getSelectedFeatureListener().a(com.tencent.mm.api.g.cRG, i, null);
      this.Ltp = this.npu;
      AppMethodBeat.o(9412);
      return;
      AppMethodBeat.o(9412);
      return;
      i = 0;
      while ((this.LtS != null) && (i < this.LtS.length))
      {
        localRect = this.LtS[i];
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          if (((i == 0) && (this.LtU)) || ((i == 1) && (this.LtT)) || ((i == 2) && (this.LtV)) || ((i == 3) && (this.LtW)))
          {
            getPresenter().getSelectedFeatureListener().a(com.tencent.mm.api.g.cRH, i, null);
            this.Ltp = this.npu;
          }
          this.LtU = false;
          this.LtT = false;
          this.LtV = false;
          this.LtW = false;
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
    if (getCurFeatureType() != com.tencent.mm.api.g.cRH)
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
    fQr();
    AppMethodBeat.o(9407);
  }
  
  protected final void q(Canvas paramCanvas)
  {
    AppMethodBeat.i(9408);
    if (!this.Lty)
    {
      if (getCurFeatureType() != com.tencent.mm.api.g.cRH)
      {
        super.q(paramCanvas);
        AppMethodBeat.o(9408);
        return;
      }
      r(paramCanvas);
    }
    AppMethodBeat.o(9408);
  }
  
  protected final void r(Canvas paramCanvas)
  {
    AppMethodBeat.i(9416);
    super.r(paramCanvas);
    float f1;
    float f2;
    if (getCurFeatureType() == com.tencent.mm.api.g.cRG)
    {
      Paint localPaint = new Paint();
      if (NN())
      {
        localPaint.setAlpha(255);
        if ((!this.Ltu) || (!NN())) {
          break label239;
        }
      }
      label239:
      for (Bitmap localBitmap = this.Lto;; localBitmap = this.Ltn)
      {
        paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.Ltn.getWidth(), (getDetailHeight() - this.Ltn.getHeight()) / 2, localPaint);
        f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.Ltn.getWidth() - this.LtK.getWidth() - this.LtH.getWidth()) / 3.0F;
        f2 = 1.0F * (getDetailHeight() - this.LtK.getHeight()) / 2.0F;
        if (this.LtX)
        {
          this.LtY = 0;
          this.LtX = false;
        }
        if (this.LtY != 0) {
          break label248;
        }
        paramCanvas.drawBitmap(this.LtI, f1, f2, null);
        paramCanvas.drawBitmap(this.LtJ, f1 + f1 + this.LtK.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
        localPaint.setAlpha(160);
        break;
      }
      label248:
      if (this.LtY == 1)
      {
        paramCanvas.drawBitmap(this.LtH, f1, f2, null);
        paramCanvas.drawBitmap(this.LtK, f1 + f1 + this.LtK.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
      }
      paramCanvas.drawBitmap(this.LtH, f1, f2, null);
      paramCanvas.drawBitmap(this.LtJ, f1 + f1 + this.LtK.getWidth(), f2, null);
      AppMethodBeat.o(9416);
      return;
    }
    if (getCurFeatureType() == com.tencent.mm.api.g.cRH)
    {
      int i = (int)getResources().getDimension(2131166083);
      paramCanvas.drawLine(0.0F, i, getMeasuredWidth(), i, this.Ltw);
      f1 = getResources().getDimension(2131166289) / 2.0F - this.LtQ.getHeight() / 2 + i;
      f2 = 1.0F * getPaddingLeftAndRight() / 2.0F;
      float f3 = i / 2 - this.LtM.getHeight() / 2;
      if (this.LtU)
      {
        paramCanvas.drawBitmap(this.LtM, f2, f3, null);
        if (!this.LtV) {
          break label633;
        }
        paramCanvas.drawBitmap(this.LtO, getMeasuredWidth() - f2 - this.LtQ.getWidth(), f1, null);
        label484:
        if (!this.LtT) {
          break label662;
        }
        paramCanvas.drawBitmap(this.LtP, f2, f1, null);
      }
      for (;;)
      {
        f1 = getResources().getDimension(2131166082) * 2.0F;
        f2 = getResources().getDimension(2131166082);
        f3 = getResources().getDimension(2131166289) / 2.0F;
        f2 = (f2 - 8.0F) / 2.0F + f3 + i;
        f3 = getMeasuredWidth() / 2;
        if (!this.LtW) {
          break label676;
        }
        this.vuq.setColor(-1);
        this.vuq.setAlpha(160);
        paramCanvas.drawText(getResources().getString(2131757966), f3 - f1 / 2.0F, f2, this.vuq);
        AppMethodBeat.o(9416);
        return;
        paramCanvas.drawBitmap(this.LtL, f2, f3, null);
        break;
        label633:
        paramCanvas.drawBitmap(this.LtN, getMeasuredWidth() - f2 - this.LtQ.getWidth(), f1, null);
        break label484;
        label662:
        paramCanvas.drawBitmap(this.LtQ, f2, f1, null);
      }
      label676:
      if (NN())
      {
        this.vuq.setColor(-1);
        this.vuq.setAlpha(255);
        paramCanvas.drawText(getResources().getString(2131757966), f3 - f1 / 2.0F, f2, this.vuq);
        AppMethodBeat.o(9416);
        return;
      }
      this.vuq.setColor(-1);
      this.vuq.setAlpha(100);
      paramCanvas.drawText(getResources().getString(2131757966), f3 - f1 / 2.0F, f2, this.vuq);
    }
    AppMethodBeat.o(9416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.footer.b
 * JD-Core Version:    0.7.0.1
 */