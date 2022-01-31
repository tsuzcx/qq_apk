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
import com.tencent.mm.api.e;
import com.tencent.mm.api.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;

public final class b
  extends a
{
  private Bitmap ATA;
  private Bitmap ATB;
  private Bitmap ATC;
  private Bitmap ATD;
  private Bitmap ATE;
  private Bitmap ATF;
  private Rect[] ATG;
  private Rect[] ATH;
  private boolean ATI;
  private boolean ATJ;
  private boolean ATK;
  private boolean ATL;
  private boolean ATM;
  private int ATN;
  private Bitmap ATs;
  private Bitmap ATt;
  private Bitmap ATu;
  private Bitmap ATv;
  private Bitmap ATw;
  private Bitmap ATx;
  private Bitmap ATy;
  private Bitmap ATz;
  private Paint oqV;
  
  public b(Context paramContext, com.tencent.mm.bs.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(116427);
    this.ATG = new Rect[2];
    this.ATH = new Rect[4];
    this.ATM = true;
    this.ATN = -1;
    AppMethodBeat.o(116427);
  }
  
  private void dRb()
  {
    AppMethodBeat.i(116436);
    if (this.ATG == null) {
      this.ATG = new Rect[2];
    }
    if (this.ATj == null) {
      this.ATj = new Rect();
    }
    float f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.ATd.getWidth() - this.ATz.getWidth() - this.ATw.getWidth()) / 3.0F;
    int k = (int)(this.ATy.getWidth() / 2 + f1);
    int i = (getDetailHeight() - this.ATy.getWidth()) / 2 + this.ATy.getWidth() / 2;
    int j = this.ATy.getWidth() * 2;
    this.ATG[0] = new Rect(k - j, i - j, k + j, i + j);
    float f2 = k;
    k = (int)(f1 + this.ATy.getWidth() + f2);
    this.ATG[1] = new Rect(k - j, i - j, k + j, i + j);
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.ATd.getWidth() / 2;
    this.ATj.set(i - this.ATd.getWidth(), 0, i + this.ATd.getWidth(), getDetailHeight());
    AppMethodBeat.o(116436);
  }
  
  private void dRc()
  {
    AppMethodBeat.i(116437);
    if (this.ATH == null) {
      this.ATH = new Rect[4];
    }
    int i = (int)getResources().getDimension(2131428268);
    float f1 = i / 2 - this.ATB.getHeight() / 2;
    float f2 = getResources().getDimension(2131428423) / 2.0F;
    float f3 = this.ATF.getHeight() / 2;
    float f4 = i;
    float f5 = 1.0F * getPaddingLeftAndRight() / 2.0F;
    int j = (int)(f1 + this.ATF.getHeight() / 2);
    int k = (int)(f5 + this.ATF.getHeight() / 2);
    i = this.ATF.getHeight();
    this.ATH[0] = new Rect(k - i, j - i, k + i, j + i);
    j = (int)(f4 + (f2 - f3) + this.ATF.getHeight() / 2);
    this.ATH[1] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.ATF.getHeight() / 2;
    this.ATH[2] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() / 2;
    this.ATH[3] = new Rect(k - i, j - i, k + i, j + i);
    AppMethodBeat.o(116437);
  }
  
  protected final boolean RM(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(116432);
    boolean bool2 = super.RM(paramInt);
    switch (1.whp[RL(paramInt).ordinal()])
    {
    default: 
      bool1 = bool2;
    }
    AppMethodBeat.o(116432);
    return bool1;
  }
  
  protected final Bitmap a(e parame, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (parame == e.bWa) {
      if (paramBoolean) {
        localBitmap = this.ATv;
      }
    }
    while (parame != e.bVZ)
    {
      return localBitmap;
      return this.ATu;
    }
    if (paramBoolean) {
      return this.ATs;
    }
    return this.ATt;
  }
  
  protected final void dQV()
  {
    AppMethodBeat.i(116428);
    super.dQV();
    this.oqV = new Paint(1);
    this.oqV.setTextSize(getResources().getDimension(2131428267));
    this.ATw = BitmapFactory.decodeResource(getResources(), 2130839721);
    this.ATx = BitmapFactory.decodeResource(getResources(), 2130839720);
    this.ATy = BitmapFactory.decodeResource(getResources(), 2130839723);
    this.ATz = BitmapFactory.decodeResource(getResources(), 2130839722);
    this.ATt = d.u(getResources().getDrawable(2131231695));
    this.ATs = d.u(getResources().getDrawable(2131231694));
    this.ATu = d.u(getResources().getDrawable(2131231203));
    this.ATv = d.u(getResources().getDrawable(2131231202));
    this.ATA = d.u(getResources().getDrawable(2131231928));
    this.ATB = d.u(getResources().getDrawable(2131231929));
    this.ATD = d.u(getResources().getDrawable(2131232068));
    this.ATC = d.u(getResources().getDrawable(2131232067));
    this.ATE = d.u(getResources().getDrawable(2131231067));
    this.ATF = d.u(getResources().getDrawable(2131231066));
    AppMethodBeat.o(116428);
  }
  
  protected final void dQX()
  {
    AppMethodBeat.i(116435);
    super.dQX();
    if (getCurFeatureType() == e.bVZ)
    {
      dRb();
      AppMethodBeat.o(116435);
      return;
    }
    if (getCurFeatureType() == e.bWa) {
      dRc();
    }
    AppMethodBeat.o(116435);
  }
  
  protected final int getDetailHeight()
  {
    AppMethodBeat.i(116431);
    int i = super.getDetailHeight();
    if (i == 0)
    {
      if (getCurFeatureType() == e.bVZ)
      {
        i = (int)getResources().getDimension(2131428422);
        AppMethodBeat.o(116431);
        return i;
      }
      if (getCurFeatureType() == e.bWa)
      {
        i = (int)(getResources().getDimension(2131428423) + getResources().getDimension(2131428268));
        AppMethodBeat.o(116431);
        return i;
      }
    }
    AppMethodBeat.o(116431);
    return i;
  }
  
  protected final void ib(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(116433);
    super.ib(paramInt1, paramInt2);
    switch (1.whp[RL(this.jwK).ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(116433);
      return;
      i = 0;
      Rect localRect;
      while (i < this.ATG.length)
      {
        localRect = this.ATG[i];
        if (localRect == null) {
          ab.e("PhotoFooterView", "[onDetailTouchDispatch] detailRect is null! %s", new Object[] { Integer.valueOf(i) });
        }
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          this.ATN = i;
          AppMethodBeat.o(116433);
          return;
        }
        i += 1;
      }
      AppMethodBeat.o(116433);
      return;
      do
      {
        i += 1;
        if (i >= this.ATH.length) {
          break;
        }
        localRect = this.ATH[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)));
      if (i == 0)
      {
        this.ATJ = true;
        AppMethodBeat.o(116433);
        return;
      }
      if (i == 1)
      {
        this.ATI = true;
        AppMethodBeat.o(116433);
        return;
      }
      if (i == 2)
      {
        this.ATK = true;
        AppMethodBeat.o(116433);
        return;
      }
    } while (i != 3);
    this.ATL = true;
    AppMethodBeat.o(116433);
  }
  
  protected final void ic(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(116434);
    super.ic(paramInt1, paramInt2);
    switch (1.whp[RL(this.jwK).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116434);
      return;
      Rect localRect;
      do
      {
        i += 1;
        if ((this.ATG == null) || (i >= this.ATG.length)) {
          break;
        }
        localRect = this.ATG[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)) || (i != this.ATN));
      getPresenter().getSelectedFeatureListener().a(e.bVZ, i);
      this.ATf = this.jwK;
      AppMethodBeat.o(116434);
      return;
      AppMethodBeat.o(116434);
      return;
      i = 0;
      while ((this.ATH != null) && (i < this.ATH.length))
      {
        localRect = this.ATH[i];
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          if (((i == 0) && (this.ATJ)) || ((i == 1) && (this.ATI)) || ((i == 2) && (this.ATK)) || ((i == 3) && (this.ATL)))
          {
            getPresenter().getSelectedFeatureListener().a(e.bWa, i);
            this.ATf = this.jwK;
          }
          this.ATJ = false;
          this.ATI = false;
          this.ATK = false;
          this.ATL = false;
          AppMethodBeat.o(116434);
          return;
        }
        i += 1;
      }
    }
  }
  
  protected final void o(Canvas paramCanvas)
  {
    AppMethodBeat.i(116430);
    if (!this.ATn)
    {
      if (getCurFeatureType() != e.bWa)
      {
        super.o(paramCanvas);
        AppMethodBeat.o(116430);
        return;
      }
      p(paramCanvas);
    }
    AppMethodBeat.o(116430);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116429);
    if (getCurFeatureType() != e.bWa)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(116429);
      return;
    }
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = getPaddingLeft();
    int i = getPaddingRight();
    int j = View.MeasureSpec.makeMeasureSpec(getDetailHeight(), 1073741824);
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt2 - i, 1073741824), j);
    dQX();
    AppMethodBeat.o(116429);
  }
  
  protected final void p(Canvas paramCanvas)
  {
    AppMethodBeat.i(116438);
    super.p(paramCanvas);
    float f1;
    float f2;
    if (getCurFeatureType() == e.bVZ)
    {
      Paint localPaint = new Paint();
      if (CE())
      {
        localPaint.setAlpha(255);
        if ((!this.ATk) || (!CE())) {
          break label239;
        }
      }
      label239:
      for (Bitmap localBitmap = this.ATe;; localBitmap = this.ATd)
      {
        paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.ATd.getWidth(), (getDetailHeight() - this.ATd.getHeight()) / 2, localPaint);
        f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.ATd.getWidth() - this.ATz.getWidth() - this.ATw.getWidth()) / 3.0F;
        f2 = 1.0F * (getDetailHeight() - this.ATz.getHeight()) / 2.0F;
        if (this.ATM)
        {
          this.ATN = 0;
          this.ATM = false;
        }
        if (this.ATN != 0) {
          break label248;
        }
        paramCanvas.drawBitmap(this.ATx, f1, f2, null);
        paramCanvas.drawBitmap(this.ATy, f1 + f1 + this.ATz.getWidth(), f2, null);
        AppMethodBeat.o(116438);
        return;
        localPaint.setAlpha(160);
        break;
      }
      label248:
      if (this.ATN == 1)
      {
        paramCanvas.drawBitmap(this.ATw, f1, f2, null);
        paramCanvas.drawBitmap(this.ATz, f1 + f1 + this.ATz.getWidth(), f2, null);
        AppMethodBeat.o(116438);
        return;
      }
      paramCanvas.drawBitmap(this.ATw, f1, f2, null);
      paramCanvas.drawBitmap(this.ATy, f1 + f1 + this.ATz.getWidth(), f2, null);
      AppMethodBeat.o(116438);
      return;
    }
    if (getCurFeatureType() == e.bWa)
    {
      int i = (int)getResources().getDimension(2131428268);
      paramCanvas.drawLine(0.0F, i, getMeasuredWidth(), i, this.ATl);
      f1 = getResources().getDimension(2131428423) / 2.0F - this.ATF.getHeight() / 2 + i;
      f2 = 1.0F * getPaddingLeftAndRight() / 2.0F;
      float f3 = i / 2 - this.ATB.getHeight() / 2;
      if (this.ATJ)
      {
        paramCanvas.drawBitmap(this.ATB, f2, f3, null);
        if (!this.ATK) {
          break label633;
        }
        paramCanvas.drawBitmap(this.ATD, getMeasuredWidth() - f2 - this.ATF.getWidth(), f1, null);
        label484:
        if (!this.ATI) {
          break label662;
        }
        paramCanvas.drawBitmap(this.ATE, f2, f1, null);
      }
      for (;;)
      {
        f1 = getResources().getDimension(2131428267) * 2.0F;
        f2 = getResources().getDimension(2131428267);
        f3 = getResources().getDimension(2131428423) / 2.0F;
        f2 = (f2 - 8.0F) / 2.0F + f3 + i;
        f3 = getMeasuredWidth() / 2;
        if (!this.ATL) {
          break label676;
        }
        this.oqV.setColor(-1);
        this.oqV.setAlpha(160);
        paramCanvas.drawText(getResources().getString(2131298886), f3 - f1 / 2.0F, f2, this.oqV);
        AppMethodBeat.o(116438);
        return;
        paramCanvas.drawBitmap(this.ATA, f2, f3, null);
        break;
        label633:
        paramCanvas.drawBitmap(this.ATC, getMeasuredWidth() - f2 - this.ATF.getWidth(), f1, null);
        break label484;
        label662:
        paramCanvas.drawBitmap(this.ATF, f2, f1, null);
      }
      label676:
      if (CE())
      {
        this.oqV.setColor(-1);
        this.oqV.setAlpha(255);
        paramCanvas.drawText(getResources().getString(2131298886), f3 - f1 / 2.0F, f2, this.oqV);
        AppMethodBeat.o(116438);
        return;
      }
      this.oqV.setColor(-1);
      this.oqV.setAlpha(100);
      paramCanvas.drawText(getResources().getString(2131298886), f3 - f1 / 2.0F, f2, this.oqV);
    }
    AppMethodBeat.o(116438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.footer.b
 * JD-Core Version:    0.7.0.1
 */