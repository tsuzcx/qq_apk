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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;

public final class b
  extends a
{
  private Bitmap LQA;
  private Bitmap LQB;
  private Bitmap LQC;
  private Bitmap LQD;
  private Rect[] LQE;
  private Rect[] LQF;
  private boolean LQG;
  private boolean LQH;
  private boolean LQI;
  private boolean LQJ;
  private boolean LQK;
  private int LQL;
  private Bitmap LQq;
  private Bitmap LQr;
  private Bitmap LQs;
  private Bitmap LQt;
  private Bitmap LQu;
  private Bitmap LQv;
  private Bitmap LQw;
  private Bitmap LQx;
  private Bitmap LQy;
  private Bitmap LQz;
  private Paint vGu;
  
  public b(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(9405);
    this.LQE = new Rect[2];
    this.LQF = new Rect[4];
    this.LQK = true;
    this.LQL = -1;
    AppMethodBeat.o(9405);
  }
  
  private void fUR()
  {
    AppMethodBeat.i(9414);
    if (this.LQE == null) {
      this.LQE = new Rect[2];
    }
    if (this.LQg == null) {
      this.LQg = new Rect();
    }
    float f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.LQa.getWidth() - this.LQx.getWidth() - this.LQu.getWidth()) / 3.0F;
    int k = (int)(this.LQw.getWidth() / 2 + f1);
    int i = (getDetailHeight() - this.LQw.getWidth()) / 2 + this.LQw.getWidth() / 2;
    int j = this.LQw.getWidth() * 2;
    this.LQE[0] = new Rect(k - j, i - j, k + j, i + j);
    float f2 = k;
    k = (int)(f1 + this.LQw.getWidth() + f2);
    this.LQE[1] = new Rect(k - j, i - j, k + j, i + j);
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.LQa.getWidth() / 2;
    this.LQg.set(i - this.LQa.getWidth(), 0, i + this.LQa.getWidth(), getDetailHeight());
    AppMethodBeat.o(9414);
  }
  
  private void fUS()
  {
    AppMethodBeat.i(9415);
    if (this.LQF == null) {
      this.LQF = new Rect[4];
    }
    int i = (int)getResources().getDimension(2131166083);
    float f1 = i / 2 - this.LQz.getHeight() / 2;
    float f2 = getResources().getDimension(2131166289) / 2.0F;
    float f3 = this.LQD.getHeight() / 2;
    float f4 = i;
    float f5 = 1.0F * getPaddingLeftAndRight() / 2.0F;
    int j = (int)(f1 + this.LQD.getHeight() / 2);
    int k = (int)(f5 + this.LQD.getHeight() / 2);
    i = this.LQD.getHeight();
    this.LQF[0] = new Rect(k - i, j - i, k + i, j + i);
    j = (int)(f4 + (f2 - f3) + this.LQD.getHeight() / 2);
    this.LQF[1] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.LQD.getHeight() / 2;
    this.LQF[2] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() / 2;
    this.LQF[3] = new Rect(k - i, j - i, k + i, j + i);
    AppMethodBeat.o(9415);
  }
  
  protected final Bitmap a(g paramg, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramg == g.cSr) {
      if (paramBoolean) {
        localBitmap = this.LQt;
      }
    }
    while (paramg != g.cSq)
    {
      return localBitmap;
      return this.LQs;
    }
    if (paramBoolean) {
      return this.LQq;
    }
    return this.LQr;
  }
  
  protected final boolean agM(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(9410);
    boolean bool2 = super.agM(paramInt);
    switch (b.1.FFo[agL(paramInt).ordinal()])
    {
    default: 
      bool1 = bool2;
    }
    AppMethodBeat.o(9410);
    return bool1;
  }
  
  protected final void fUL()
  {
    AppMethodBeat.i(9406);
    super.fUL();
    this.vGu = new Paint(1);
    this.vGu.setTextSize(getResources().getDimension(2131166082));
    this.LQu = BitmapFactory.decodeResource(getResources(), 2131233346);
    this.LQv = BitmapFactory.decodeResource(getResources(), 2131233345);
    this.LQw = BitmapFactory.decodeResource(getResources(), 2131233348);
    this.LQx = BitmapFactory.decodeResource(getResources(), 2131233347);
    this.LQr = h.B(getResources().getDrawable(2131690855));
    this.LQq = h.B(getResources().getDrawable(2131690854));
    this.LQs = h.B(getResources().getDrawable(2131690008));
    this.LQt = h.B(getResources().getDrawable(2131690007));
    this.LQy = h.B(getResources().getDrawable(2131691102));
    this.LQz = h.B(getResources().getDrawable(2131691103));
    this.LQB = h.B(getResources().getDrawable(2131691268));
    this.LQA = h.B(getResources().getDrawable(2131691267));
    this.LQC = h.B(getResources().getDrawable(2131689858));
    this.LQD = h.B(getResources().getDrawable(2131689857));
    AppMethodBeat.o(9406);
  }
  
  protected final void fUN()
  {
    AppMethodBeat.i(9413);
    super.fUN();
    if (getCurFeatureType() == g.cSq)
    {
      fUR();
      AppMethodBeat.o(9413);
      return;
    }
    if (getCurFeatureType() == g.cSr) {
      fUS();
    }
    AppMethodBeat.o(9413);
  }
  
  protected final int getDetailHeight()
  {
    AppMethodBeat.i(9409);
    int i = super.getDetailHeight();
    if (i == 0)
    {
      if (getCurFeatureType() == g.cSq)
      {
        i = (int)getResources().getDimension(2131166288);
        AppMethodBeat.o(9409);
        return i;
      }
      if (getCurFeatureType() == g.cSr)
      {
        i = (int)(getResources().getDimension(2131166289) + getResources().getDimension(2131166083));
        AppMethodBeat.o(9409);
        return i;
      }
    }
    AppMethodBeat.o(9409);
    return i;
  }
  
  protected final void kE(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9411);
    super.kE(paramInt1, paramInt2);
    switch (b.1.FFo[agL(this.nuE).ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(9411);
      return;
      i = 0;
      Rect localRect;
      while (i < this.LQE.length)
      {
        localRect = this.LQE[i];
        if (localRect == null) {
          ae.e("PhotoFooterView", "[onDetailTouchDispatch] detailRect is null! %s", new Object[] { Integer.valueOf(i) });
        }
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          this.LQL = i;
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
        if (i >= this.LQF.length) {
          break;
        }
        localRect = this.LQF[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)));
      if (i == 0)
      {
        this.LQH = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 1)
      {
        this.LQG = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 2)
      {
        this.LQI = true;
        AppMethodBeat.o(9411);
        return;
      }
    } while (i != 3);
    this.LQJ = true;
    AppMethodBeat.o(9411);
  }
  
  protected final void kF(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9412);
    super.kF(paramInt1, paramInt2);
    switch (b.1.FFo[agL(this.nuE).ordinal()])
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
        if ((this.LQE == null) || (i >= this.LQE.length)) {
          break;
        }
        localRect = this.LQE[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)) || (i != this.LQL));
      getPresenter().getSelectedFeatureListener().a(g.cSq, i, null);
      this.LQc = this.nuE;
      AppMethodBeat.o(9412);
      return;
      AppMethodBeat.o(9412);
      return;
      i = 0;
      while ((this.LQF != null) && (i < this.LQF.length))
      {
        localRect = this.LQF[i];
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          if (((i == 0) && (this.LQH)) || ((i == 1) && (this.LQG)) || ((i == 2) && (this.LQI)) || ((i == 3) && (this.LQJ)))
          {
            getPresenter().getSelectedFeatureListener().a(g.cSr, i, null);
            this.LQc = this.nuE;
          }
          this.LQH = false;
          this.LQG = false;
          this.LQI = false;
          this.LQJ = false;
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
    if (getCurFeatureType() != g.cSr)
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
    fUN();
    AppMethodBeat.o(9407);
  }
  
  protected final void q(Canvas paramCanvas)
  {
    AppMethodBeat.i(9408);
    if (!this.LQl)
    {
      if (getCurFeatureType() != g.cSr)
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
    if (getCurFeatureType() == g.cSq)
    {
      Paint localPaint = new Paint();
      if (NL())
      {
        localPaint.setAlpha(255);
        if ((!this.LQh) || (!NL())) {
          break label239;
        }
      }
      label239:
      for (Bitmap localBitmap = this.LQb;; localBitmap = this.LQa)
      {
        paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.LQa.getWidth(), (getDetailHeight() - this.LQa.getHeight()) / 2, localPaint);
        f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.LQa.getWidth() - this.LQx.getWidth() - this.LQu.getWidth()) / 3.0F;
        f2 = 1.0F * (getDetailHeight() - this.LQx.getHeight()) / 2.0F;
        if (this.LQK)
        {
          this.LQL = 0;
          this.LQK = false;
        }
        if (this.LQL != 0) {
          break label248;
        }
        paramCanvas.drawBitmap(this.LQv, f1, f2, null);
        paramCanvas.drawBitmap(this.LQw, f1 + f1 + this.LQx.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
        localPaint.setAlpha(160);
        break;
      }
      label248:
      if (this.LQL == 1)
      {
        paramCanvas.drawBitmap(this.LQu, f1, f2, null);
        paramCanvas.drawBitmap(this.LQx, f1 + f1 + this.LQx.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
      }
      paramCanvas.drawBitmap(this.LQu, f1, f2, null);
      paramCanvas.drawBitmap(this.LQw, f1 + f1 + this.LQx.getWidth(), f2, null);
      AppMethodBeat.o(9416);
      return;
    }
    if (getCurFeatureType() == g.cSr)
    {
      int i = (int)getResources().getDimension(2131166083);
      paramCanvas.drawLine(0.0F, i, getMeasuredWidth(), i, this.LQj);
      f1 = getResources().getDimension(2131166289) / 2.0F - this.LQD.getHeight() / 2 + i;
      f2 = 1.0F * getPaddingLeftAndRight() / 2.0F;
      float f3 = i / 2 - this.LQz.getHeight() / 2;
      if (this.LQH)
      {
        paramCanvas.drawBitmap(this.LQz, f2, f3, null);
        if (!this.LQI) {
          break label633;
        }
        paramCanvas.drawBitmap(this.LQB, getMeasuredWidth() - f2 - this.LQD.getWidth(), f1, null);
        label484:
        if (!this.LQG) {
          break label662;
        }
        paramCanvas.drawBitmap(this.LQC, f2, f1, null);
      }
      for (;;)
      {
        f1 = getResources().getDimension(2131166082) * 2.0F;
        f2 = getResources().getDimension(2131166082);
        f3 = getResources().getDimension(2131166289) / 2.0F;
        f2 = (f2 - 8.0F) / 2.0F + f3 + i;
        f3 = getMeasuredWidth() / 2;
        if (!this.LQJ) {
          break label676;
        }
        this.vGu.setColor(-1);
        this.vGu.setAlpha(160);
        paramCanvas.drawText(getResources().getString(2131757966), f3 - f1 / 2.0F, f2, this.vGu);
        AppMethodBeat.o(9416);
        return;
        paramCanvas.drawBitmap(this.LQy, f2, f3, null);
        break;
        label633:
        paramCanvas.drawBitmap(this.LQA, getMeasuredWidth() - f2 - this.LQD.getWidth(), f1, null);
        break label484;
        label662:
        paramCanvas.drawBitmap(this.LQD, f2, f1, null);
      }
      label676:
      if (NL())
      {
        this.vGu.setColor(-1);
        this.vGu.setAlpha(255);
        paramCanvas.drawText(getResources().getString(2131757966), f3 - f1 / 2.0F, f2, this.vGu);
        AppMethodBeat.o(9416);
        return;
      }
      this.vGu.setColor(-1);
      this.vGu.setAlpha(100);
      paramCanvas.drawText(getResources().getString(2131757966), f3 - f1 / 2.0F, f2, this.vGu);
    }
    AppMethodBeat.o(9416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.footer.b
 * JD-Core Version:    0.7.0.1
 */