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
import com.tencent.mm.api.aa;
import com.tencent.mm.api.i;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.bo.a.d;
import com.tencent.mm.bo.a.g;
import com.tencent.mm.bo.a.h;
import com.tencent.mm.bt.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;

public class c
  extends a
{
  private Paint KyZ;
  private Bitmap agLX;
  private Bitmap agLY;
  private Bitmap agLZ;
  private Bitmap agMa;
  private Bitmap agMb;
  private Bitmap agMc;
  private Bitmap agMd;
  private Bitmap agMe;
  private Bitmap agMf;
  private Bitmap agMg;
  private Bitmap agMh;
  private Bitmap agMi;
  private Bitmap agMj;
  private Bitmap agMk;
  private Rect[] agMl;
  private Rect[] agMm;
  private boolean agMn;
  private boolean agMo;
  private boolean agMp;
  private boolean agMq;
  private boolean agMr;
  private int agMs;
  
  public c(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(9405);
    this.agMl = new Rect[2];
    this.agMm = new Rect[4];
    this.agMr = true;
    this.agMs = -1;
    AppMethodBeat.o(9405);
  }
  
  private void jNb()
  {
    AppMethodBeat.i(9414);
    if (this.agMl == null) {
      this.agMl = new Rect[2];
    }
    if (this.agLN == null) {
      this.agLN = new Rect();
    }
    float f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.agLH.getWidth() - this.agMe.getWidth() - this.agMb.getWidth()) / 3.0F;
    int k = (int)(this.agMd.getWidth() / 2 + f1);
    int i = (getDetailHeight() - this.agMd.getWidth()) / 2 + this.agMd.getWidth() / 2;
    int j = this.agMd.getWidth() * 2;
    this.agMl[0] = new Rect(k - j, i - j, k + j, i + j);
    float f2 = k;
    k = (int)(f1 + this.agMd.getWidth() + f2);
    this.agMl[1] = new Rect(k - j, i - j, k + j, i + j);
    i = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.agLH.getWidth() / 2;
    this.agLN.set(i - this.agLH.getWidth(), 0, i + this.agLH.getWidth(), getDetailHeight());
    AppMethodBeat.o(9414);
  }
  
  private void jNc()
  {
    AppMethodBeat.i(9415);
    if (this.agMm == null) {
      this.agMm = new Rect[4];
    }
    int i = (int)getResources().getDimension(a.c.crop_rotation_layout_height);
    float f1 = i / 2 - this.agMg.getHeight() / 2;
    float f2 = getResources().getDimension(a.c.feature_select_layout_height) / 2.0F;
    float f3 = this.agMk.getHeight() / 2;
    float f4 = i;
    float f5 = 1.0F * getPaddingLeftAndRight() / 2.0F;
    int j = (int)(f1 + this.agMk.getHeight() / 2);
    int k = (int)(f5 + this.agMk.getHeight() / 2);
    i = this.agMk.getHeight();
    this.agMm[0] = new Rect(k - i, j - i, k + i, j + i);
    j = (int)(f4 + (f2 - f3) + this.agMk.getHeight() / 2);
    this.agMm[1] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.agMk.getHeight() / 2;
    this.agMm[2] = new Rect(k - i, j - i, k + i, j + i);
    k = getMeasuredWidth() / 2;
    this.agMm[3] = new Rect(k - i, j - i, k + i, j + i);
    AppMethodBeat.o(9415);
  }
  
  protected final Bitmap a(i parami, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (parami == i.hdS) {
      if (paramBoolean) {
        localBitmap = this.agMa;
      }
    }
    while (parami != i.hdR)
    {
      return localBitmap;
      return this.agLZ;
    }
    if (paramBoolean) {
      return this.agLX;
    }
    return this.agLY;
  }
  
  protected final boolean aGa(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(9410);
    boolean bool2 = super.aGa(paramInt);
    switch (1.YwI[aFZ(paramInt).ordinal()])
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
      if (getCurFeatureType() == i.hdR)
      {
        i = (int)getResources().getDimension(a.c.feature_select_detail_layout_height);
        AppMethodBeat.o(9409);
        return i;
      }
      if (getCurFeatureType() == i.hdS)
      {
        i = (int)(getResources().getDimension(a.c.feature_select_layout_height) + getResources().getDimension(a.c.crop_rotation_layout_height));
        AppMethodBeat.o(9409);
        return i;
      }
    }
    AppMethodBeat.o(9409);
    return i;
  }
  
  protected final void jMV()
  {
    AppMethodBeat.i(9406);
    super.jMV();
    this.KyZ = new Paint(1);
    this.KyZ.setTextSize(getResources().getDimension(a.c.crop_reset_text_size));
    this.agMb = BitmapFactory.decodeResource(getResources(), a.d.mosaic_one_unselected);
    this.agMc = BitmapFactory.decodeResource(getResources(), a.d.mosaic_one_selected);
    this.agMd = BitmapFactory.decodeResource(getResources(), a.d.mosaic_two_unselected);
    this.agMe = BitmapFactory.decodeResource(getResources(), a.d.mosaic_two_selected);
    this.agLY = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.mosaic_unselected));
    this.agLX = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.mosaic_selected));
    this.agLZ = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.crop_unselected));
    this.agMa = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.crop_selected));
    this.agMf = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.rotation_normal));
    this.agMg = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.rotation_press));
    this.agMi = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.sure_crop_press));
    this.agMh = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.sure_crop_normal));
    this.agMj = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.cancel_crop_press));
    this.agMk = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(a.g.cancel_crop_normal));
    AppMethodBeat.o(9406);
  }
  
  protected final void jMX()
  {
    AppMethodBeat.i(9413);
    super.jMX();
    if (getCurFeatureType() == i.hdR)
    {
      jNb();
      AppMethodBeat.o(9413);
      return;
    }
    if (getCurFeatureType() == i.hdS) {
      jNc();
    }
    AppMethodBeat.o(9413);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9407);
    if (getCurFeatureType() != i.hdS)
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
    jMX();
    AppMethodBeat.o(9407);
  }
  
  protected final void pp(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9411);
    super.pp(paramInt1, paramInt2);
    switch (1.YwI[aFZ(this.uRE).ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(9411);
      return;
      i = 0;
      Rect localRect;
      while (i < this.agMl.length)
      {
        localRect = this.agMl[i];
        if (localRect == null) {
          Log.e("PhotoFooterView", "[onDetailTouchDispatch] detailRect is null! %s", new Object[] { Integer.valueOf(i) });
        }
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          this.agMs = i;
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
        if (i >= this.agMm.length) {
          break;
        }
        localRect = this.agMm[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)));
      if (i == 0)
      {
        this.agMo = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 1)
      {
        this.agMn = true;
        AppMethodBeat.o(9411);
        return;
      }
      if (i == 2)
      {
        this.agMp = true;
        AppMethodBeat.o(9411);
        return;
      }
    } while (i != 3);
    this.agMq = true;
    AppMethodBeat.o(9411);
  }
  
  protected final void pq(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(9412);
    super.pq(paramInt1, paramInt2);
    switch (1.YwI[aFZ(this.uRE).ordinal()])
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
        if ((this.agMl == null) || (i >= this.agMl.length)) {
          break;
        }
        localRect = this.agMl[i];
      } while ((localRect == null) || (!localRect.contains(paramInt1, paramInt2)) || (i != this.agMs));
      getPresenter().getSelectedFeatureListener().a(i.hdR, i, null);
      this.agLJ = this.uRE;
      AppMethodBeat.o(9412);
      return;
      AppMethodBeat.o(9412);
      return;
      i = 0;
      while ((this.agMm != null) && (i < this.agMm.length))
      {
        localRect = this.agMm[i];
        if ((localRect != null) && (localRect.contains(paramInt1, paramInt2)))
        {
          if (((i == 0) && (this.agMo)) || ((i == 1) && (this.agMn)) || ((i == 2) && (this.agMp)) || ((i == 3) && (this.agMq)))
          {
            getPresenter().getSelectedFeatureListener().a(i.hdS, i, null);
            this.agLJ = this.uRE;
          }
          this.agMo = false;
          this.agMn = false;
          this.agMp = false;
          this.agMq = false;
          AppMethodBeat.o(9412);
          return;
        }
        i += 1;
      }
    }
  }
  
  protected final void y(Canvas paramCanvas)
  {
    AppMethodBeat.i(9408);
    if (!this.agLR)
    {
      if (getCurFeatureType() != i.hdS)
      {
        super.y(paramCanvas);
        AppMethodBeat.o(9408);
        return;
      }
      z(paramCanvas);
    }
    AppMethodBeat.o(9408);
  }
  
  protected final void z(Canvas paramCanvas)
  {
    AppMethodBeat.i(9416);
    super.z(paramCanvas);
    float f1;
    float f2;
    if (getCurFeatureType() == i.hdR)
    {
      Paint localPaint = new Paint();
      if (aED())
      {
        localPaint.setAlpha(255);
        if ((!this.agLO) || (!aED())) {
          break label239;
        }
      }
      label239:
      for (Bitmap localBitmap = this.agLI;; localBitmap = this.agLH)
      {
        paramCanvas.drawBitmap(localBitmap, getMeasuredWidth() - getPaddingLeftAndRight() / 2 - this.agLH.getWidth(), (getDetailHeight() - this.agLH.getHeight()) / 2, localPaint);
        f1 = (getMeasuredWidth() - getPaddingLeftAndRight() - this.agLH.getWidth() - this.agMe.getWidth() - this.agMb.getWidth()) / 3.0F;
        f2 = (getDetailHeight() - this.agMe.getHeight()) * 1.0F / 2.0F;
        if (this.agMr)
        {
          this.agMs = 0;
          this.agMr = false;
        }
        if (this.agMs != 0) {
          break label248;
        }
        paramCanvas.drawBitmap(this.agMc, f1, f2, null);
        paramCanvas.drawBitmap(this.agMd, f1 + f1 + this.agMe.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
        localPaint.setAlpha(160);
        break;
      }
      label248:
      if (this.agMs == 1)
      {
        paramCanvas.drawBitmap(this.agMb, f1, f2, null);
        paramCanvas.drawBitmap(this.agMe, f1 + f1 + this.agMe.getWidth(), f2, null);
        AppMethodBeat.o(9416);
        return;
      }
      paramCanvas.drawBitmap(this.agMb, f1, f2, null);
      paramCanvas.drawBitmap(this.agMd, f1 + f1 + this.agMe.getWidth(), f2, null);
      AppMethodBeat.o(9416);
      return;
    }
    if (getCurFeatureType() == i.hdS)
    {
      int i = (int)getResources().getDimension(a.c.crop_rotation_layout_height);
      paramCanvas.drawLine(0.0F, i, getMeasuredWidth(), i, this.afny);
      f1 = getResources().getDimension(a.c.feature_select_layout_height) / 2.0F - this.agMk.getHeight() / 2 + i;
      f2 = getPaddingLeftAndRight() * 1.0F / 2.0F;
      float f3 = i / 2 - this.agMg.getHeight() / 2;
      if (this.agMo)
      {
        paramCanvas.drawBitmap(this.agMg, f2, f3, null);
        if (!this.agMp) {
          break label638;
        }
        paramCanvas.drawBitmap(this.agMi, getMeasuredWidth() - f2 - this.agMk.getWidth(), f1, null);
        label486:
        if (!this.agMn) {
          break label667;
        }
        paramCanvas.drawBitmap(this.agMj, f2, f1, null);
      }
      for (;;)
      {
        f1 = getResources().getDimension(a.c.crop_reset_text_size) * 2.0F;
        f2 = getResources().getDimension(a.c.crop_reset_text_size);
        f3 = getResources().getDimension(a.c.feature_select_layout_height) / 2.0F;
        f2 = (f2 - 8.0F) / 2.0F + f3 + i;
        f3 = getMeasuredWidth() / 2;
        if (!this.agMq) {
          break label681;
        }
        this.KyZ.setColor(-1);
        this.KyZ.setAlpha(160);
        paramCanvas.drawText(getResources().getString(a.h.crop_reset), f3 - f1 / 2.0F, f2, this.KyZ);
        AppMethodBeat.o(9416);
        return;
        paramCanvas.drawBitmap(this.agMf, f2, f3, null);
        break;
        label638:
        paramCanvas.drawBitmap(this.agMh, getMeasuredWidth() - f2 - this.agMk.getWidth(), f1, null);
        break label486;
        label667:
        paramCanvas.drawBitmap(this.agMk, f2, f1, null);
      }
      label681:
      if (aED())
      {
        this.KyZ.setColor(-1);
        this.KyZ.setAlpha(255);
        paramCanvas.drawText(getResources().getString(a.h.crop_reset), f3 - f1 / 2.0F, f2, this.KyZ);
        AppMethodBeat.o(9416);
        return;
      }
      this.KyZ.setColor(-1);
      this.KyZ.setAlpha(100);
      paramCanvas.drawText(getResources().getString(a.h.crop_reset), f3 - f1 / 2.0F, f2, this.KyZ);
    }
    AppMethodBeat.o(9416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.footer.c
 * JD-Core Version:    0.7.0.1
 */