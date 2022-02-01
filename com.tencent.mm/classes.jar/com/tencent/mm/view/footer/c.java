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
import com.tencent.mm.bv.a.c;
import com.tencent.mm.bv.a.d;
import com.tencent.mm.bv.a.g;
import com.tencent.mm.bv.a.h;
import com.tencent.mm.ca.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;

public class c
  extends a
{
  private Paint EFQ;
  private Bitmap YQA;
  private Bitmap YQB;
  private Bitmap YQC;
  private Bitmap YQD;
  private Bitmap YQE;
  private Rect[] YQF;
  private Rect[] YQG;
  private boolean YQH;
  private boolean YQI;
  private boolean YQJ;
  private boolean YQK;
  private boolean YQL;
  private int YQM;
  private Bitmap YQr;
  private Bitmap YQs;
  private Bitmap YQt;
  private Bitmap YQu;
  private Bitmap YQv;
  private Bitmap YQw;
  private Bitmap YQx;
  private Bitmap YQy;
  private Bitmap YQz;
  
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(9405);
    this.YQF = new Rect[2];
    this.YQG = new Rect[4];
    this.YQL = true;
    this.YQM = -1;
    AppMethodBeat.o(9405);
  }
  
  private void ihO()
  {
    AppMethodBeat.i(9414);
    if (this.YQF == null) {
      this.YQF = new Rect[2];
    }
    if (this.YQg == null) {
      this.YQg = new Rect();
    }
    float f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.YQa.getWidth() - this.YQy.getWidth() - this.YQv.getWidth()) / 3.0F;
    int k = (int)(this.YQx.getWidth() / 2 + f1);
    int i = (getDetailHeight() - this.YQx.getWidth()) / 2 + this.YQx.getWidth() / 2;
    int j = this.YQx.getWidth() * 2;
    this.YQF[0] = new Rect(k - j, i - j, k + j, i + j);
    float f2 = k;
    k = (int)(f1 + this.YQx.getWidth() + f2);
    this.YQF[1] = new Rect(k - j, i - j, k + j, i + j);
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.YQa.getWidth() / 2;
    this.YQg.set(i - this.YQa.getWidth(), 0, i + this.YQa.getWidth(), getDetailHeight());
    AppMethodBeat.o(9414);
  }
  
  private void ihP()
  {
    AppMethodBeat.i(9415);
    if (this.YQG == null) {
      this.YQG = new Rect[4];
    }
    int i = (int)getResources().getDimension(a.c.crop_rotation_layout_height);
    float f1 = i / 2 - this.YQA.getHeight() / 2;
    float f2 = getResources().getDimension(a.c.feature_select_layout_height) / 2.0F;
    float f3 = this.YQE.getHeight() / 2;
    float f4 = i;
    float f5 = 1.0F * getPaddingLeftAndRight() / 2.0F;
    int j = (int)(f1 + this.YQE.getHeight() / 2);
    int k = (int)(f5 + this.YQE.getHeight() / 2);
    i = this.YQE.getHeight();
    this.YQG[0] = new Rect(k - i, j - i, k + i, j + i);
    j = (int)(f4 + (f2 - f3) + this.YQE.getHeight() / 2);
    this.YQG[1] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.YQE.getHeight() / 2;
    this.YQG[2] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() / 2;
    this.YQG[3] = new Rect(k - i, j - i, k + i, j + i);
    AppMethodBeat.o(9415);
  }
  
  protected final void D(Canvas paramCanvas)
  {
    AppMethodBeat.i(9408);
    if (!this.YQl)
    {
      if (getCurFeatureType() != h.far)
      {
        super.D(paramCanvas);
        AppMethodBeat.o(9408);
        return;
      }
      E(paramCanvas);
    }
    AppMethodBeat.o(9408);
  }
  
  protected final void E(Canvas paramCanvas)
  {
    AppMethodBeat.i(9416);
    super.E(paramCanvas);
    float f1;
    float f2;
    if (getCurFeatureType() == h.faq)
    {
      Paint localPaint = new Paint();
      if (acD())
      {
        localPaint.setAlpha(255);
        if ((!this.YQh) || (!acD())) {
          break label239;
        }
      }
      label239:
      for (Bitmap localBitmap = this.YQb;; localBitmap = this.YQa)
      {
        paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.YQa.getWidth(), (getDetailHeight() - this.YQa.getHeight()) / 2, localPaint);
        f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.YQa.getWidth() - this.YQy.getWidth() - this.YQv.getWidth()) / 3.0F;
        f2 = (getDetailHeight() - this.YQy.getHeight()) * 1.0F / 2.0F;
        if (this.YQL)
        {
          this.YQM = 0;
          this.YQL = false;
        }
        if (this.YQM != 0) {
          break label248;
        }
        paramCanvas.drawBitmap(this.YQw, f1, f2, null);
        paramCanvas.drawBitmap(this.YQx, f1 + f1 + this.YQy.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
        localPaint.setAlpha(160);
        break;
      }
      label248:
      if (this.YQM == 1)
      {
        paramCanvas.drawBitmap(this.YQv, f1, f2, null);
        paramCanvas.drawBitmap(this.YQy, f1 + f1 + this.YQy.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
      }
      paramCanvas.drawBitmap(this.YQv, f1, f2, null);
      paramCanvas.drawBitmap(this.YQx, f1 + f1 + this.YQy.getWidth(), f2, null);
      AppMethodBeat.o(9416);
      return;
    }
    if (getCurFeatureType() == h.far)
    {
      int i = (int)getResources().getDimension(a.c.crop_rotation_layout_height);
      paramCanvas.drawLine(0.0F, i, getMeasuredWidth(), i, this.YQj);
      f1 = getResources().getDimension(a.c.feature_select_layout_height) / 2.0F - this.YQE.getHeight() / 2 + i;
      f2 = getPaddingLeftAndRight() * 1.0F / 2.0F;
      float f3 = i / 2 - this.YQA.getHeight() / 2;
      if (this.YQI)
      {
        paramCanvas.drawBitmap(this.YQA, f2, f3, null);
        if (!this.YQJ) {
          break label637;
        }
        paramCanvas.drawBitmap(this.YQC, getMeasuredWidth() - f2 - this.YQE.getWidth(), f1, null);
        label486:
        if (!this.YQH) {
          break label666;
        }
        paramCanvas.drawBitmap(this.YQD, f2, f1, null);
      }
      for (;;)
      {
        f1 = getResources().getDimension(a.c.crop_reset_text_size) * 2.0F;
        f2 = getResources().getDimension(a.c.crop_reset_text_size);
        f3 = getResources().getDimension(a.c.feature_select_layout_height) / 2.0F;
        f2 = (f2 - 8.0F) / 2.0F + f3 + i;
        f3 = getMeasuredWidth() / 2;
        if (!this.YQK) {
          break label680;
        }
        this.EFQ.setColor(-1);
        this.EFQ.setAlpha(160);
        paramCanvas.drawText(getResources().getString(a.h.crop_reset), f3 - f1 / 2.0F, f2, this.EFQ);
        AppMethodBeat.o(9416);
        return;
        paramCanvas.drawBitmap(this.YQz, f2, f3, null);
        break;
        label637:
        paramCanvas.drawBitmap(this.YQB, getMeasuredWidth() - f2 - this.YQE.getWidth(), f1, null);
        break label486;
        label666:
        paramCanvas.drawBitmap(this.YQE, f2, f1, null);
      }
      label680:
      if (acD())
      {
        this.EFQ.setColor(-1);
        this.EFQ.setAlpha(255);
        paramCanvas.drawText(getResources().getString(a.h.crop_reset), f3 - f1 / 2.0F, f2, this.EFQ);
        AppMethodBeat.o(9416);
        return;
      }
      this.EFQ.setColor(-1);
      this.EFQ.setAlpha(100);
      paramCanvas.drawText(getResources().getString(a.h.crop_reset), f3 - f1 / 2.0F, f2, this.EFQ);
    }
    AppMethodBeat.o(9416);
  }
  
  protected final Bitmap a(h paramh, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (paramh == h.far) {
      if (paramBoolean) {
        localBitmap = this.YQu;
      }
    }
    while (paramh != h.faq)
    {
      return localBitmap;
      return this.YQt;
    }
    if (paramBoolean) {
      return this.YQr;
    }
    return this.YQs;
  }
  
  protected final boolean azw(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(9410);
    boolean bool2 = super.azw(paramInt);
    switch (1.RAi[azv(paramInt).ordinal()])
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
      if (getCurFeatureType() == h.faq)
      {
        i = (int)getResources().getDimension(a.c.feature_select_detail_layout_height);
        AppMethodBeat.o(9409);
        return i;
      }
      if (getCurFeatureType() == h.far)
      {
        i = (int)(getResources().getDimension(a.c.feature_select_layout_height) + getResources().getDimension(a.c.crop_rotation_layout_height));
        AppMethodBeat.o(9409);
        return i;
      }
    }
    AppMethodBeat.o(9409);
    return i;
  }
  
  protected final void ihI()
  {
    AppMethodBeat.i(9406);
    super.ihI();
    this.EFQ = new Paint(1);
    this.EFQ.setTextSize(getResources().getDimension(a.c.crop_reset_text_size));
    this.YQv = BitmapFactory.decodeResource(getResources(), a.d.mosaic_one_unselected);
    this.YQw = BitmapFactory.decodeResource(getResources(), a.d.mosaic_one_selected);
    this.YQx = BitmapFactory.decodeResource(getResources(), a.d.mosaic_two_unselected);
    this.YQy = BitmapFactory.decodeResource(getResources(), a.d.mosaic_two_selected);
    this.YQs = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.mosaic_unselected));
    this.YQr = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.mosaic_selected));
    this.YQt = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.crop_unselected));
    this.YQu = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.crop_selected));
    this.YQz = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.rotation_normal));
    this.YQA = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.rotation_press));
    this.YQC = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.sure_crop_press));
    this.YQB = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.sure_crop_normal));
    this.YQD = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.cancel_crop_press));
    this.YQE = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.cancel_crop_normal));
    AppMethodBeat.o(9406);
  }
  
  protected final void ihK()
  {
    AppMethodBeat.i(9413);
    super.ihK();
    if (getCurFeatureType() == h.faq)
    {
      ihO();
      AppMethodBeat.o(9413);
      return;
    }
    if (getCurFeatureType() == h.far) {
      ihP();
    }
    AppMethodBeat.o(9413);
  }
  
  protected final void nt(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9411);
    super.nt(paramInt1, paramInt2);
    switch (1.RAi[azv(this.rGs).ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(9411);
      return;
      i = 0;
      Rect localRect;
      while (i < this.YQF.length)
      {
        localRect = this.YQF[i];
        if (localRect == null) {
          Log.e("PhotoFooterView", "[onDetailTouchDispatch] detailRect is null! %s", new Object[] { Integer.valueOf(i) });
        }
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          this.YQM = i;
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
        if (i >= this.YQG.length) {
          break;
        }
        localRect = this.YQG[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)));
      if (i == 0)
      {
        this.YQI = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 1)
      {
        this.YQH = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 2)
      {
        this.YQJ = true;
        AppMethodBeat.o(9411);
        return;
      }
    } while (i != 3);
    this.YQK = true;
    AppMethodBeat.o(9411);
  }
  
  protected final void nu(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9412);
    super.nu(paramInt1, paramInt2);
    switch (1.RAi[azv(this.rGs).ordinal()])
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
        if ((this.YQF == null) || (i >= this.YQF.length)) {
          break;
        }
        localRect = this.YQF[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)) || (i != this.YQM));
      getPresenter().getSelectedFeatureListener().a(h.faq, i, null);
      this.YQc = this.rGs;
      AppMethodBeat.o(9412);
      return;
      AppMethodBeat.o(9412);
      return;
      i = 0;
      while ((this.YQG != null) && (i < this.YQG.length))
      {
        localRect = this.YQG[i];
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          if (((i == 0) && (this.YQI)) || ((i == 1) && (this.YQH)) || ((i == 2) && (this.YQJ)) || ((i == 3) && (this.YQK)))
          {
            getPresenter().getSelectedFeatureListener().a(h.far, i, null);
            this.YQc = this.rGs;
          }
          this.YQI = false;
          this.YQH = false;
          this.YQJ = false;
          this.YQK = false;
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
    if (getCurFeatureType() != h.far)
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
    ihK();
    AppMethodBeat.o(9407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.footer.c
 * JD-Core Version:    0.7.0.1
 */