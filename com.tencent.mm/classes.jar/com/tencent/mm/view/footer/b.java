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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;

public final class b
  extends a
{
  private Bitmap JAA;
  private Bitmap JAB;
  private Bitmap JAC;
  private Bitmap JAD;
  private Bitmap JAE;
  private Bitmap JAF;
  private Bitmap JAG;
  private Bitmap JAH;
  private Bitmap JAI;
  private Bitmap JAJ;
  private Rect[] JAK;
  private Rect[] JAL;
  private boolean JAM;
  private boolean JAN;
  private boolean JAO;
  private boolean JAP;
  private boolean JAQ;
  private int JAR;
  private Bitmap JAw;
  private Bitmap JAx;
  private Bitmap JAy;
  private Bitmap JAz;
  private Paint urN;
  
  public b(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(9405);
    this.JAK = new Rect[2];
    this.JAL = new Rect[4];
    this.JAQ = true;
    this.JAR = -1;
    AppMethodBeat.o(9405);
  }
  
  private void fzm()
  {
    AppMethodBeat.i(9414);
    if (this.JAK == null) {
      this.JAK = new Rect[2];
    }
    if (this.JAm == null) {
      this.JAm = new Rect();
    }
    float f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.JAg.getWidth() - this.JAD.getWidth() - this.JAA.getWidth()) / 3.0F;
    int k = (int)(this.JAC.getWidth() / 2 + f1);
    int i = (getDetailHeight() - this.JAC.getWidth()) / 2 + this.JAC.getWidth() / 2;
    int j = this.JAC.getWidth() * 2;
    this.JAK[0] = new Rect(k - j, i - j, k + j, i + j);
    float f2 = k;
    k = (int)(f1 + this.JAC.getWidth() + f2);
    this.JAK[1] = new Rect(k - j, i - j, k + j, i + j);
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.JAg.getWidth() / 2;
    this.JAm.set(i - this.JAg.getWidth(), 0, i + this.JAg.getWidth(), getDetailHeight());
    AppMethodBeat.o(9414);
  }
  
  private void fzn()
  {
    AppMethodBeat.i(9415);
    if (this.JAL == null) {
      this.JAL = new Rect[4];
    }
    int i = (int)getResources().getDimension(2131166083);
    float f1 = i / 2 - this.JAF.getHeight() / 2;
    float f2 = getResources().getDimension(2131166289) / 2.0F;
    float f3 = this.JAJ.getHeight() / 2;
    float f4 = i;
    float f5 = 1.0F * getPaddingLeftAndRight() / 2.0F;
    int j = (int)(f1 + this.JAJ.getHeight() / 2);
    int k = (int)(f5 + this.JAJ.getHeight() / 2);
    i = this.JAJ.getHeight();
    this.JAL[0] = new Rect(k - i, j - i, k + i, j + i);
    j = (int)(f4 + (f2 - f3) + this.JAJ.getHeight() / 2);
    this.JAL[1] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.JAJ.getHeight() / 2;
    this.JAL[2] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() / 2;
    this.JAL[3] = new Rect(k - i, j - i, k + i, j + i);
    AppMethodBeat.o(9415);
  }
  
  protected final Bitmap a(g paramg, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramg == g.cGD) {
      if (paramBoolean) {
        localBitmap = this.JAz;
      }
    }
    while (paramg != g.cGC)
    {
      return localBitmap;
      return this.JAy;
    }
    if (paramBoolean) {
      return this.JAw;
    }
    return this.JAx;
  }
  
  protected final boolean adD(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(9410);
    boolean bool2 = super.adD(paramInt);
    switch (1.DHJ[adC(paramInt).ordinal()])
    {
    default: 
      bool1 = bool2;
    }
    AppMethodBeat.o(9410);
    return bool1;
  }
  
  protected final void fzg()
  {
    AppMethodBeat.i(9406);
    super.fzg();
    this.urN = new Paint(1);
    this.urN.setTextSize(getResources().getDimension(2131166082));
    this.JAA = BitmapFactory.decodeResource(getResources(), 2131233346);
    this.JAB = BitmapFactory.decodeResource(getResources(), 2131233345);
    this.JAC = BitmapFactory.decodeResource(getResources(), 2131233348);
    this.JAD = BitmapFactory.decodeResource(getResources(), 2131233347);
    this.JAx = f.A(getResources().getDrawable(2131690855));
    this.JAw = f.A(getResources().getDrawable(2131690854));
    this.JAy = f.A(getResources().getDrawable(2131690008));
    this.JAz = f.A(getResources().getDrawable(2131690007));
    this.JAE = f.A(getResources().getDrawable(2131691102));
    this.JAF = f.A(getResources().getDrawable(2131691103));
    this.JAH = f.A(getResources().getDrawable(2131691268));
    this.JAG = f.A(getResources().getDrawable(2131691267));
    this.JAI = f.A(getResources().getDrawable(2131689858));
    this.JAJ = f.A(getResources().getDrawable(2131689857));
    AppMethodBeat.o(9406);
  }
  
  protected final void fzi()
  {
    AppMethodBeat.i(9413);
    super.fzi();
    if (getCurFeatureType() == g.cGC)
    {
      fzm();
      AppMethodBeat.o(9413);
      return;
    }
    if (getCurFeatureType() == g.cGD) {
      fzn();
    }
    AppMethodBeat.o(9413);
  }
  
  protected final int getDetailHeight()
  {
    AppMethodBeat.i(9409);
    int i = super.getDetailHeight();
    if (i == 0)
    {
      if (getCurFeatureType() == g.cGC)
      {
        i = (int)getResources().getDimension(2131166288);
        AppMethodBeat.o(9409);
        return i;
      }
      if (getCurFeatureType() == g.cGD)
      {
        i = (int)(getResources().getDimension(2131166289) + getResources().getDimension(2131166083));
        AppMethodBeat.o(9409);
        return i;
      }
    }
    AppMethodBeat.o(9409);
    return i;
  }
  
  protected final void kh(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9411);
    super.kh(paramInt1, paramInt2);
    switch (1.DHJ[adC(this.mOX).ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(9411);
      return;
      i = 0;
      Rect localRect;
      while (i < this.JAK.length)
      {
        localRect = this.JAK[i];
        if (localRect == null) {
          ac.e("PhotoFooterView", "[onDetailTouchDispatch] detailRect is null! %s", new Object[] { Integer.valueOf(i) });
        }
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          this.JAR = i;
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
        if (i >= this.JAL.length) {
          break;
        }
        localRect = this.JAL[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)));
      if (i == 0)
      {
        this.JAN = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 1)
      {
        this.JAM = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 2)
      {
        this.JAO = true;
        AppMethodBeat.o(9411);
        return;
      }
    } while (i != 3);
    this.JAP = true;
    AppMethodBeat.o(9411);
  }
  
  protected final void ki(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9412);
    super.ki(paramInt1, paramInt2);
    switch (1.DHJ[adC(this.mOX).ordinal()])
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
        if ((this.JAK == null) || (i >= this.JAK.length)) {
          break;
        }
        localRect = this.JAK[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)) || (i != this.JAR));
      getPresenter().getSelectedFeatureListener().a(g.cGC, i, null);
      this.JAi = this.mOX;
      AppMethodBeat.o(9412);
      return;
      AppMethodBeat.o(9412);
      return;
      i = 0;
      while ((this.JAL != null) && (i < this.JAL.length))
      {
        localRect = this.JAL[i];
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          if (((i == 0) && (this.JAN)) || ((i == 1) && (this.JAM)) || ((i == 2) && (this.JAO)) || ((i == 3) && (this.JAP)))
          {
            getPresenter().getSelectedFeatureListener().a(g.cGD, i, null);
            this.JAi = this.mOX;
          }
          this.JAN = false;
          this.JAM = false;
          this.JAO = false;
          this.JAP = false;
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
    if (getCurFeatureType() != g.cGD)
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
    fzi();
    AppMethodBeat.o(9407);
  }
  
  protected final void r(Canvas paramCanvas)
  {
    AppMethodBeat.i(9408);
    if (!this.JAr)
    {
      if (getCurFeatureType() != g.cGD)
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
    if (getCurFeatureType() == g.cGC)
    {
      Paint localPaint = new Paint();
      if (Me())
      {
        localPaint.setAlpha(255);
        if ((!this.JAn) || (!Me())) {
          break label239;
        }
      }
      label239:
      for (Bitmap localBitmap = this.JAh;; localBitmap = this.JAg)
      {
        paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.JAg.getWidth(), (getDetailHeight() - this.JAg.getHeight()) / 2, localPaint);
        f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.JAg.getWidth() - this.JAD.getWidth() - this.JAA.getWidth()) / 3.0F;
        f2 = 1.0F * (getDetailHeight() - this.JAD.getHeight()) / 2.0F;
        if (this.JAQ)
        {
          this.JAR = 0;
          this.JAQ = false;
        }
        if (this.JAR != 0) {
          break label248;
        }
        paramCanvas.drawBitmap(this.JAB, f1, f2, null);
        paramCanvas.drawBitmap(this.JAC, f1 + f1 + this.JAD.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
        localPaint.setAlpha(160);
        break;
      }
      label248:
      if (this.JAR == 1)
      {
        paramCanvas.drawBitmap(this.JAA, f1, f2, null);
        paramCanvas.drawBitmap(this.JAD, f1 + f1 + this.JAD.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
      }
      paramCanvas.drawBitmap(this.JAA, f1, f2, null);
      paramCanvas.drawBitmap(this.JAC, f1 + f1 + this.JAD.getWidth(), f2, null);
      AppMethodBeat.o(9416);
      return;
    }
    if (getCurFeatureType() == g.cGD)
    {
      int i = (int)getResources().getDimension(2131166083);
      paramCanvas.drawLine(0.0F, i, getMeasuredWidth(), i, this.JAp);
      f1 = getResources().getDimension(2131166289) / 2.0F - this.JAJ.getHeight() / 2 + i;
      f2 = 1.0F * getPaddingLeftAndRight() / 2.0F;
      float f3 = i / 2 - this.JAF.getHeight() / 2;
      if (this.JAN)
      {
        paramCanvas.drawBitmap(this.JAF, f2, f3, null);
        if (!this.JAO) {
          break label633;
        }
        paramCanvas.drawBitmap(this.JAH, getMeasuredWidth() - f2 - this.JAJ.getWidth(), f1, null);
        label484:
        if (!this.JAM) {
          break label662;
        }
        paramCanvas.drawBitmap(this.JAI, f2, f1, null);
      }
      for (;;)
      {
        f1 = getResources().getDimension(2131166082) * 2.0F;
        f2 = getResources().getDimension(2131166082);
        f3 = getResources().getDimension(2131166289) / 2.0F;
        f2 = (f2 - 8.0F) / 2.0F + f3 + i;
        f3 = getMeasuredWidth() / 2;
        if (!this.JAP) {
          break label676;
        }
        this.urN.setColor(-1);
        this.urN.setAlpha(160);
        paramCanvas.drawText(getResources().getString(2131757966), f3 - f1 / 2.0F, f2, this.urN);
        AppMethodBeat.o(9416);
        return;
        paramCanvas.drawBitmap(this.JAE, f2, f3, null);
        break;
        label633:
        paramCanvas.drawBitmap(this.JAG, getMeasuredWidth() - f2 - this.JAJ.getWidth(), f1, null);
        break label484;
        label662:
        paramCanvas.drawBitmap(this.JAJ, f2, f1, null);
      }
      label676:
      if (Me())
      {
        this.urN.setColor(-1);
        this.urN.setAlpha(255);
        paramCanvas.drawText(getResources().getString(2131757966), f3 - f1 / 2.0F, f2, this.urN);
        AppMethodBeat.o(9416);
        return;
      }
      this.urN.setColor(-1);
      this.urN.setAlpha(100);
      paramCanvas.drawText(getResources().getString(2131757966), f3 - f1 / 2.0F, f2, this.urN);
    }
    AppMethodBeat.o(9416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.footer.b
 * JD-Core Version:    0.7.0.1
 */