package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class SmileyPanelScrollView
  extends View
{
  private static boolean DEBUG = false;
  private SmileyPanelScrollView.b AQT;
  private com.tencent.mm.view.f.a AQU;
  private Drawable AQV;
  private Drawable AQW;
  private Drawable AQX;
  private Drawable AQY;
  private int AQZ;
  public int ARa;
  private int ARb;
  private Paint ARc;
  private int ARd;
  private int ARe;
  private int ARf;
  private int ARg;
  private int ARh;
  private int ARi;
  private int ARj;
  private boolean ARk;
  private boolean ARl;
  public int ARm;
  public int ARn;
  public float ARo;
  public boolean ARp;
  private boolean ARq;
  public int ARr;
  private int ARs;
  private SmileyPanelScrollView.a ARt;
  private int STATE_NONE;
  private Context mContext;
  private int mHeight;
  private int mState;
  private int mWidth;
  private int qO;
  private int qQ;
  
  public SmileyPanelScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(62944);
    this.ARk = false;
    this.ARl = false;
    this.ARm = -1;
    this.ARn = -1;
    this.ARp = false;
    this.ARq = false;
    this.ARr = 0;
    this.ARs = 1;
    this.STATE_NONE = 0;
    this.mState = this.STATE_NONE;
    this.ARt = new SmileyPanelScrollView.a(this);
    init(paramContext);
    AppMethodBeat.o(62944);
  }
  
  public SmileyPanelScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62945);
    this.ARk = false;
    this.ARl = false;
    this.ARm = -1;
    this.ARn = -1;
    this.ARp = false;
    this.ARq = false;
    this.ARr = 0;
    this.ARs = 1;
    this.STATE_NONE = 0;
    this.mState = this.STATE_NONE;
    this.ARt = new SmileyPanelScrollView.a(this);
    init(paramContext);
    AppMethodBeat.o(62945);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(62946);
    this.mContext = paramContext;
    this.AQV = com.tencent.mm.svg.a.a.g(getResources(), 2131232001);
    this.AQX = this.mContext.getResources().getDrawable(2130840362);
    this.AQW = this.mContext.getResources().getDrawable(2130840361);
    this.AQY = this.mContext.getResources().getDrawable(2130840364);
    this.ARd = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
    this.ARe = this.AQW.getIntrinsicHeight();
    this.ARf = this.AQW.getIntrinsicWidth();
    this.ARg = this.AQY.getIntrinsicHeight();
    this.ARi = this.AQX.getIntrinsicHeight();
    this.ARj = this.AQX.getIntrinsicWidth();
    ab.d("MicroMsg.SmileyPanelScrollView", "init mDotPadding:%d mDotHeight:%d mDotWidth:%d", new Object[] { Integer.valueOf(this.ARd), Integer.valueOf(this.ARe), Integer.valueOf(this.ARf) });
    this.ARc = new Paint();
    this.ARc.setColor(-65536);
    this.ARc.setAntiAlias(true);
    this.ARc.setTextAlign(Paint.Align.CENTER);
    this.mWidth = getMeasuredWidth();
    this.mHeight = getMeasuredHeight();
    this.ARb = (this.ARh / (this.ARf + this.ARd));
    ab.d("MicroMsg.SmileyPanelScrollView", "init mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.ARh), Integer.valueOf(this.ARb) });
    AppMethodBeat.o(62946);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(62948);
    super.draw(paramCanvas);
    SmileyPanelScrollView.a locala = this.ARt;
    int j;
    if (locala.ARv.getState() != locala.ARv.ARs)
    {
      j = 102;
      if (this.AQZ <= this.ARb) {
        break label491;
      }
      this.ARk = true;
      k = (this.mHeight - this.ARg) / 2;
      i = (this.mWidth - this.ARh) / 2;
      this.qO = (i - this.ARj / 2);
      this.qQ = (this.qO + this.ARh + this.ARj);
      if (DEBUG)
      {
        paramCanvas.drawLine(this.qO, 0.0F, this.qO, this.mHeight, this.ARc);
        paramCanvas.drawLine(this.qQ, 0.0F, this.qQ, this.mHeight, this.ARc);
      }
      this.AQY.setBounds(i, k, this.ARh + i, this.ARg + k);
      this.AQY.setAlpha(j);
      this.AQY.draw(paramCanvas);
      k = (this.mHeight - this.ARi) / 2;
      if ((!this.ARl) && (!this.ARp)) {
        break label382;
      }
      i = this.ARh / (this.AQZ - 1) * this.ARa + i - this.ARj / 2;
    }
    for (;;)
    {
      this.AQX.setBounds(i, k, this.ARj + i, this.ARi + k);
      this.AQX.draw(paramCanvas);
      if ((getState() == this.ARs) && (j < 255)) {
        invalidate();
      }
      AppMethodBeat.o(62948);
      return;
      long l = SystemClock.uptimeMillis();
      if (l > locala.mStartTime + locala.ARu) {
        i = 255;
      }
      for (;;)
      {
        j = i;
        break;
        j = (int)((l - locala.mStartTime) * 153L / locala.ARu) + 102;
        i = j;
        if (j < 102) {
          i = 102;
        }
      }
      label382:
      if (this.ARn == this.ARm) {
        i = this.ARh / (this.AQZ - 1) * this.ARm + i - this.ARj / 2 + (int)(this.ARh / (this.AQZ - 1) * this.ARo);
      } else {
        i = this.ARh / (this.AQZ - 1) * this.ARm + i - this.ARj / 2 - (int)(this.ARh / (this.AQZ - 1) * (1.0F - this.ARo));
      }
    }
    label491:
    this.ARk = false;
    int k = (this.mHeight - this.ARe) / 2;
    int i = (this.mWidth - ((this.ARd + this.ARf) * (this.AQZ - 1) + this.ARf)) / 2;
    this.qO = (i - (this.ARj - this.ARf) / 2);
    this.qQ = (this.qO + this.ARf * this.AQZ + this.ARd * (this.AQZ - 1) + (this.ARj - this.ARf));
    if (DEBUG)
    {
      paramCanvas.drawLine(this.qO, 0.0F, this.qO, this.mHeight, this.ARc);
      paramCanvas.drawLine(this.qQ, 0.0F, this.qQ, this.mHeight, this.ARc);
    }
    this.AQW.setBounds(i, k, this.ARf + i, this.ARe + k);
    int m = (this.AQV.getIntrinsicWidth() - this.ARf) / 2;
    int n = (this.AQV.getIntrinsicHeight() - this.ARe) / 2;
    this.AQV.setBounds(i - m, k - n, m + (this.ARf + i), n + (this.ARe + k));
    k = (this.mHeight - this.ARi) / 2;
    if ((this.ARl) || (this.ARp))
    {
      i -= (this.ARj - this.ARf) / 2;
      this.AQX.setBounds(i, k, this.ARj + i, this.ARi + k);
      k = 0;
      label806:
      if (k >= this.AQZ) {
        break label940;
      }
      paramCanvas.save();
      if (k > 0) {
        paramCanvas.translate((this.ARf + this.ARd) * k, 0.0F);
      }
      if ((k != 0) || (!this.ARq)) {
        break label921;
      }
      this.AQV.draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      k += 1;
      break label806;
      i = i - (this.ARj - this.ARf) / 2 + (int)((this.ARf + this.ARd) * (this.ARn - this.ARm + this.ARo));
      break;
      label921:
      this.AQW.setAlpha(j);
      this.AQW.draw(paramCanvas);
    }
    label940:
    if (this.ARm > this.AQZ - 1) {
      this.ARm = (this.AQZ - 1);
    }
    k = (this.ARf + this.ARd) * this.ARm;
    if (i + k > this.qQ)
    {
      i = 0;
      ab.i("MicroMsg.SmileyPanelScrollView", "over right.");
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.translate(i, 0.0F);
      this.AQX.draw(paramCanvas);
      paramCanvas.restore();
      break;
      i = k;
    }
  }
  
  public final void f(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62947);
    ab.d("MicroMsg.SmileyPanelScrollView", "setDot dotCount:%d selectDot:%d force:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1) });
    this.AQZ = paramInt1;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.ARa = paramInt1;
      if ((this.ARn == -1) || (paramBoolean1) || (this.ARr == 0)) {
        this.ARn = this.ARa;
      }
      if ((this.ARm == -1) || (paramBoolean1) || (this.ARr == 0))
      {
        this.ARm = this.ARa;
        this.ARo = 0.0F;
      }
      this.ARq = paramBoolean2;
      invalidate();
      AppMethodBeat.o(62947);
      return;
      paramInt1 = paramInt2;
      if (paramInt2 > this.AQZ) {
        paramInt1 = this.AQZ;
      }
    }
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62949);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != this.mWidth)
    {
      this.mWidth = getMeasuredWidth();
      this.mHeight = getMeasuredHeight();
      this.ARh = (this.mWidth - (this.AQU.getColumnWidth() - this.AQU.AUM) - com.tencent.mm.cb.a.ao(this.mContext, 2131427859) * 2);
      this.ARb = (this.ARh / (this.ARf + this.ARd));
      ab.d("MicroMsg.SmileyPanelScrollView", "onSizeChanged mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.ARh), Integer.valueOf(this.ARb) });
      if (this.mHeight == 0)
      {
        ab.i("MicroMsg.SmileyPanelScrollView", "user default height");
        this.mHeight = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16);
      }
    }
    AppMethodBeat.o(62949);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(62950);
    int m = paramMotionEvent.getAction();
    int k = (int)paramMotionEvent.getX();
    if ((k < this.qO - this.ARd) || (k > this.qQ + this.ARd))
    {
      ab.d("MicroMsg.SmileyPanelScrollView", "over x :%d mLeft:%d mRight:%d ", new Object[] { Integer.valueOf(k), Integer.valueOf(this.qO), Integer.valueOf(this.qQ) });
      if (m == 0)
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(62950);
        return bool;
      }
    }
    for (int j = 1;; j = 0)
    {
      int i;
      if (j == 0)
      {
        i = k;
        if (k < this.qO) {
          i = this.qO;
        }
        k = i;
        if (i > this.qQ) {
          k = this.qQ;
        }
        if (this.ARk)
        {
          i = this.ARh / (this.AQZ - 1);
          i = (k - this.qO) / i;
          k = i;
          if (i > this.AQZ - 1) {
            k = this.AQZ - 1;
          }
          this.AQT.RF(k);
          this.ARm = k;
          this.ARn = k;
        }
      }
      else
      {
        switch (m)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(62950);
        return true;
        i = (k - this.qO + this.ARd) / (this.ARf + this.ARd);
        break;
        if (j == 0)
        {
          this.ARl = true;
          this.ARp = true;
          setState(this.ARs);
          this.ARt.dQP();
          invalidate();
          continue;
          if ((j == 0) && (getState() != this.ARs))
          {
            setState(this.ARs);
            this.ARt.dQP();
            invalidate();
            continue;
            setState(this.STATE_NONE);
            this.ARl = false;
            invalidate();
          }
        }
      }
    }
  }
  
  public void setOnPageSelectListener(SmileyPanelScrollView.b paramb)
  {
    this.AQT = paramb;
  }
  
  public void setSmileyPanelStg(com.tencent.mm.view.f.a parama)
  {
    this.AQU = parama;
  }
  
  public void setState(int paramInt)
  {
    this.mState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelScrollView
 * JD-Core Version:    0.7.0.1
 */