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
import com.tencent.mm.api.h;
import com.tencent.mm.api.z;
import com.tencent.mm.bt.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;

public class c
  extends a
{
  private Bitmap RoX;
  private Bitmap RoY;
  private Bitmap RoZ;
  private Bitmap Rpa;
  private Bitmap Rpb;
  private Bitmap Rpc;
  private Bitmap Rpd;
  private Bitmap Rpe;
  private Bitmap Rpf;
  private Bitmap Rpg;
  private Bitmap Rph;
  private Bitmap Rpi;
  private Bitmap Rpj;
  private Bitmap Rpk;
  private Rect[] Rpl;
  private Rect[] Rpm;
  private boolean Rpn;
  private boolean Rpo;
  private boolean Rpp;
  private boolean Rpq;
  private boolean Rpr;
  private int Rps;
  private Paint zbt;
  
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(9405);
    this.Rpl = new Rect[2];
    this.Rpm = new Rect[4];
    this.Rpr = true;
    this.Rps = -1;
    AppMethodBeat.o(9405);
  }
  
  private void hgn()
  {
    AppMethodBeat.i(9414);
    if (this.Rpl == null) {
      this.Rpl = new Rect[2];
    }
    if (this.RoM == null) {
      this.RoM = new Rect();
    }
    float f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.RoG.getWidth() - this.Rpe.getWidth() - this.Rpb.getWidth()) / 3.0F;
    int k = (int)(this.Rpd.getWidth() / 2 + f1);
    int i = (getDetailHeight() - this.Rpd.getWidth()) / 2 + this.Rpd.getWidth() / 2;
    int j = this.Rpd.getWidth() * 2;
    this.Rpl[0] = new Rect(k - j, i - j, k + j, i + j);
    float f2 = k;
    k = (int)(f1 + this.Rpd.getWidth() + f2);
    this.Rpl[1] = new Rect(k - j, i - j, k + j, i + j);
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.RoG.getWidth() / 2;
    this.RoM.set(i - this.RoG.getWidth(), 0, i + this.RoG.getWidth(), getDetailHeight());
    AppMethodBeat.o(9414);
  }
  
  private void hgo()
  {
    AppMethodBeat.i(9415);
    if (this.Rpm == null) {
      this.Rpm = new Rect[4];
    }
    int i = (int)getResources().getDimension(2131166124);
    float f1 = i / 2 - this.Rpg.getHeight() / 2;
    float f2 = getResources().getDimension(2131166336) / 2.0F;
    float f3 = this.Rpk.getHeight() / 2;
    float f4 = i;
    float f5 = 1.0F * getPaddingLeftAndRight() / 2.0F;
    int j = (int)(f1 + this.Rpk.getHeight() / 2);
    int k = (int)(f5 + this.Rpk.getHeight() / 2);
    i = this.Rpk.getHeight();
    this.Rpm[0] = new Rect(k - i, j - i, k + i, j + i);
    j = (int)(f4 + (f2 - f3) + this.Rpk.getHeight() / 2);
    this.Rpm[1] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.Rpk.getHeight() / 2;
    this.Rpm[2] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() / 2;
    this.Rpm[3] = new Rect(k - i, j - i, k + i, j + i);
    AppMethodBeat.o(9415);
  }
  
  protected final void A(Canvas paramCanvas)
  {
    AppMethodBeat.i(9408);
    if (!this.RoR)
    {
      if (getCurFeatureType() != h.diL)
      {
        super.A(paramCanvas);
        AppMethodBeat.o(9408);
        return;
      }
      B(paramCanvas);
    }
    AppMethodBeat.o(9408);
  }
  
  protected final void B(Canvas paramCanvas)
  {
    AppMethodBeat.i(9416);
    super.B(paramCanvas);
    float f1;
    float f2;
    if (getCurFeatureType() == h.diK)
    {
      Paint localPaint = new Paint();
      if (XX())
      {
        localPaint.setAlpha(255);
        if ((!this.RoN) || (!XX())) {
          break label239;
        }
      }
      label239:
      for (Bitmap localBitmap = this.RoH;; localBitmap = this.RoG)
      {
        paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.RoG.getWidth(), (getDetailHeight() - this.RoG.getHeight()) / 2, localPaint);
        f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.RoG.getWidth() - this.Rpe.getWidth() - this.Rpb.getWidth()) / 3.0F;
        f2 = 1.0F * (getDetailHeight() - this.Rpe.getHeight()) / 2.0F;
        if (this.Rpr)
        {
          this.Rps = 0;
          this.Rpr = false;
        }
        if (this.Rps != 0) {
          break label248;
        }
        paramCanvas.drawBitmap(this.Rpc, f1, f2, null);
        paramCanvas.drawBitmap(this.Rpd, f1 + f1 + this.Rpe.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
        localPaint.setAlpha(160);
        break;
      }
      label248:
      if (this.Rps == 1)
      {
        paramCanvas.drawBitmap(this.Rpb, f1, f2, null);
        paramCanvas.drawBitmap(this.Rpe, f1 + f1 + this.Rpe.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
      }
      paramCanvas.drawBitmap(this.Rpb, f1, f2, null);
      paramCanvas.drawBitmap(this.Rpd, f1 + f1 + this.Rpe.getWidth(), f2, null);
      AppMethodBeat.o(9416);
      return;
    }
    if (getCurFeatureType() == h.diL)
    {
      int i = (int)getResources().getDimension(2131166124);
      paramCanvas.drawLine(0.0F, i, getMeasuredWidth(), i, this.RoP);
      f1 = getResources().getDimension(2131166336) / 2.0F - this.Rpk.getHeight() / 2 + i;
      f2 = 1.0F * getPaddingLeftAndRight() / 2.0F;
      float f3 = i / 2 - this.Rpg.getHeight() / 2;
      if (this.Rpo)
      {
        paramCanvas.drawBitmap(this.Rpg, f2, f3, null);
        if (!this.Rpp) {
          break label631;
        }
        paramCanvas.drawBitmap(this.Rpi, getMeasuredWidth() - f2 - this.Rpk.getWidth(), f1, null);
        label484:
        if (!this.Rpn) {
          break label660;
        }
        paramCanvas.drawBitmap(this.Rpj, f2, f1, null);
      }
      for (;;)
      {
        f1 = getResources().getDimension(2131166123) * 2.0F;
        f2 = getResources().getDimension(2131166123);
        f3 = getResources().getDimension(2131166336) / 2.0F;
        f2 = (f2 - 8.0F) / 2.0F + f3 + i;
        f3 = getMeasuredWidth() / 2;
        if (!this.Rpq) {
          break label674;
        }
        this.zbt.setColor(-1);
        this.zbt.setAlpha(160);
        paramCanvas.drawText(getResources().getString(2131758215), f3 - f1 / 2.0F, f2, this.zbt);
        AppMethodBeat.o(9416);
        return;
        paramCanvas.drawBitmap(this.Rpf, f2, f3, null);
        break;
        label631:
        paramCanvas.drawBitmap(this.Rph, getMeasuredWidth() - f2 - this.Rpk.getWidth(), f1, null);
        break label484;
        label660:
        paramCanvas.drawBitmap(this.Rpk, f2, f1, null);
      }
      label674:
      if (XX())
      {
        this.zbt.setColor(-1);
        this.zbt.setAlpha(255);
        paramCanvas.drawText(getResources().getString(2131758215), f3 - f1 / 2.0F, f2, this.zbt);
        AppMethodBeat.o(9416);
        return;
      }
      this.zbt.setColor(-1);
      this.zbt.setAlpha(100);
      paramCanvas.drawText(getResources().getString(2131758215), f3 - f1 / 2.0F, f2, this.zbt);
    }
    AppMethodBeat.o(9416);
  }
  
  protected final Bitmap a(h paramh, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramh == h.diL) {
      if (paramBoolean) {
        localBitmap = this.Rpa;
      }
    }
    while (paramh != h.diK)
    {
      return localBitmap;
      return this.RoZ;
    }
    if (paramBoolean) {
      return this.RoX;
    }
    return this.RoY;
  }
  
  protected final boolean apX(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(9410);
    boolean bool2 = super.apX(paramInt);
    switch (1.Kyu[apW(paramInt).ordinal()])
    {
    default: 
      bool1 = bool2;
    }
    AppMethodBeat.o(9410);
    return bool1;
  }
  
  protected int getDetailHeight()
  {
    AppMethodBeat.i(9409);
    int i = super.getDetailHeight();
    if (i == 0)
    {
      if (getCurFeatureType() == h.diK)
      {
        i = (int)getResources().getDimension(2131166335);
        AppMethodBeat.o(9409);
        return i;
      }
      if (getCurFeatureType() == h.diL)
      {
        i = (int)(getResources().getDimension(2131166336) + getResources().getDimension(2131166124));
        AppMethodBeat.o(9409);
        return i;
      }
    }
    AppMethodBeat.o(9409);
    return i;
  }
  
  protected final void hgh()
  {
    AppMethodBeat.i(9406);
    super.hgh();
    this.zbt = new Paint(1);
    this.zbt.setTextSize(getResources().getDimension(2131166123));
    this.Rpb = BitmapFactory.decodeResource(getResources(), 2131234026);
    this.Rpc = BitmapFactory.decodeResource(getResources(), 2131234025);
    this.Rpd = BitmapFactory.decodeResource(getResources(), 2131234028);
    this.Rpe = BitmapFactory.decodeResource(getResources(), 2131234027);
    this.RoY = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131691141));
    this.RoX = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131691140));
    this.RoZ = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131690037));
    this.Rpa = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131690036));
    this.Rpf = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131691405));
    this.Rpg = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131691406));
    this.Rpi = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131691599));
    this.Rph = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131691598));
    this.Rpj = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131689873));
    this.Rpk = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131689872));
    AppMethodBeat.o(9406);
  }
  
  protected final void hgj()
  {
    AppMethodBeat.i(9413);
    super.hgj();
    if (getCurFeatureType() == h.diK)
    {
      hgn();
      AppMethodBeat.o(9413);
      return;
    }
    if (getCurFeatureType() == h.diL) {
      hgo();
    }
    AppMethodBeat.o(9413);
  }
  
  protected final void mc(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9411);
    super.mc(paramInt1, paramInt2);
    switch (1.Kyu[apW(this.oEI).ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(9411);
      return;
      i = 0;
      Rect localRect;
      while (i < this.Rpl.length)
      {
        localRect = this.Rpl[i];
        if (localRect == null) {
          Log.e("PhotoFooterView", "[onDetailTouchDispatch] detailRect is null! %s", new Object[] { Integer.valueOf(i) });
        }
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          this.Rps = i;
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
        if (i >= this.Rpm.length) {
          break;
        }
        localRect = this.Rpm[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)));
      if (i == 0)
      {
        this.Rpo = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 1)
      {
        this.Rpn = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 2)
      {
        this.Rpp = true;
        AppMethodBeat.o(9411);
        return;
      }
    } while (i != 3);
    this.Rpq = true;
    AppMethodBeat.o(9411);
  }
  
  protected final void md(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9412);
    super.md(paramInt1, paramInt2);
    switch (1.Kyu[apW(this.oEI).ordinal()])
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
        if ((this.Rpl == null) || (i >= this.Rpl.length)) {
          break;
        }
        localRect = this.Rpl[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)) || (i != this.Rps));
      getPresenter().getSelectedFeatureListener().a(h.diK, i, null);
      this.RoI = this.oEI;
      AppMethodBeat.o(9412);
      return;
      AppMethodBeat.o(9412);
      return;
      i = 0;
      while ((this.Rpm != null) && (i < this.Rpm.length))
      {
        localRect = this.Rpm[i];
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          if (((i == 0) && (this.Rpo)) || ((i == 1) && (this.Rpn)) || ((i == 2) && (this.Rpp)) || ((i == 3) && (this.Rpq)))
          {
            getPresenter().getSelectedFeatureListener().a(h.diL, i, null);
            this.RoI = this.oEI;
          }
          this.Rpo = false;
          this.Rpn = false;
          this.Rpp = false;
          this.Rpq = false;
          AppMethodBeat.o(9412);
          return;
        }
        i += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9407);
    if (getCurFeatureType() != h.diL)
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
    hgj();
    AppMethodBeat.o(9407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.footer.c
 * JD-Core Version:    0.7.0.1
 */