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
import com.tencent.mm.plugin.l.a.c;
import com.tencent.mm.plugin.l.a.d;
import com.tencent.mm.plugin.l.a.g;
import com.tencent.mm.sdk.platformtools.y;

public class SmileyPanelScrollView
  extends View
{
  private static boolean DEBUG = false;
  private int STATE_NONE = 0;
  private Context mContext;
  private int mHeight;
  private int mState = this.STATE_NONE;
  private int mWidth;
  private int pR;
  private int pT;
  private b wvR;
  private com.tencent.mm.view.f.a wvS;
  private Drawable wvT;
  private Drawable wvU;
  private Drawable wvV;
  private Drawable wvW;
  public int wvX;
  public int wvY;
  private int wvZ;
  private Paint wwa;
  private int wwb;
  private int wwc;
  private int wwd;
  private int wwe;
  private int wwf;
  private int wwg;
  private int wwh;
  private boolean wwi = false;
  private boolean wwj = false;
  public int wwk = -1;
  public int wwl = -1;
  public float wwm;
  public boolean wwn = false;
  public boolean wwo = false;
  public int wwp = 0;
  private int wwq = 1;
  private SmileyPanelScrollView.a wwr = new SmileyPanelScrollView.a(this);
  
  public SmileyPanelScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public SmileyPanelScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.wvT = com.tencent.mm.svg.a.a.e(getResources(), a.g.smiley_recent_dot);
    this.wvV = this.mContext.getResources().getDrawable(a.d.smiley_panel_scroll_thumb_selected);
    this.wvU = this.mContext.getResources().getDrawable(a.d.smiley_panel_scroll_thumb_pressed);
    this.wvW = this.mContext.getResources().getDrawable(a.d.smiley_panel_scroll_track_pressed);
    this.wwb = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
    this.wwc = this.wvU.getIntrinsicHeight();
    this.wwd = this.wvU.getIntrinsicWidth();
    this.wwe = this.wvW.getIntrinsicHeight();
    this.wwg = this.wvV.getIntrinsicHeight();
    this.wwh = this.wvV.getIntrinsicWidth();
    y.d("MicroMsg.SmileyPanelScrollView", "init mDotPadding:%d mDotHeight:%d mDotWidth:%d", new Object[] { Integer.valueOf(this.wwb), Integer.valueOf(this.wwc), Integer.valueOf(this.wwd) });
    this.wwa = new Paint();
    this.wwa.setColor(-65536);
    this.wwa.setAntiAlias(true);
    this.wwa.setTextAlign(Paint.Align.CENTER);
    this.mWidth = getMeasuredWidth();
    this.mHeight = getMeasuredHeight();
    this.wvZ = (this.wwf / (this.wwd + this.wwb));
    y.d("MicroMsg.SmileyPanelScrollView", "init mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.wwf), Integer.valueOf(this.wvZ) });
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = 102;
    int m = 0;
    super.draw(paramCanvas);
    SmileyPanelScrollView.a locala = this.wwr;
    int j;
    if (locala.wwt.getState() != locala.wwt.wwq)
    {
      j = 102;
      if (this.wvX <= this.wvZ) {
        break label484;
      }
      this.wwi = true;
      k = (this.mHeight - this.wwe) / 2;
      i = (this.mWidth - this.wwf) / 2;
      this.pR = (i - this.wwh / 2);
      this.pT = (this.pR + this.wwf + this.wwh);
      if (DEBUG)
      {
        paramCanvas.drawLine(this.pR, 0.0F, this.pR, this.mHeight, this.wwa);
        paramCanvas.drawLine(this.pT, 0.0F, this.pT, this.mHeight, this.wwa);
      }
      this.wvW.setBounds(i, k, this.wwf + i, this.wwe + k);
      this.wvW.setAlpha(j);
      this.wvW.draw(paramCanvas);
      k = (this.mHeight - this.wwg) / 2;
      if ((!this.wwj) && (!this.wwn)) {
        break label375;
      }
      i = this.wwf / (this.wvX - 1) * this.wvY + i - this.wwh / 2;
    }
    for (;;)
    {
      this.wvV.setBounds(i, k, this.wwh + i, this.wwg + k);
      this.wvV.draw(paramCanvas);
      if ((getState() == this.wwq) && (j < 255)) {
        invalidate();
      }
      return;
      long l = SystemClock.uptimeMillis();
      if (l > locala.mStartTime + locala.wws) {
        i = 255;
      }
      for (;;)
      {
        j = i;
        break;
        j = (int)((l - locala.mStartTime) * 153L / locala.wws) + 102;
        if (j >= 102) {
          i = j;
        }
      }
      label375:
      if (this.wwl == this.wwk) {
        i = this.wwf / (this.wvX - 1) * this.wwk + i - this.wwh / 2 + (int)(this.wwf / (this.wvX - 1) * this.wwm);
      } else {
        i = this.wwf / (this.wvX - 1) * this.wwk + i - this.wwh / 2 - (int)(this.wwf / (this.wvX - 1) * (1.0F - this.wwm));
      }
    }
    label484:
    this.wwi = false;
    int k = (this.mHeight - this.wwc) / 2;
    i = (this.mWidth - ((this.wwb + this.wwd) * (this.wvX - 1) + this.wwd)) / 2;
    this.pR = (i - (this.wwh - this.wwd) / 2);
    this.pT = (this.pR + this.wwd * this.wvX + this.wwb * (this.wvX - 1) + (this.wwh - this.wwd));
    if (DEBUG)
    {
      paramCanvas.drawLine(this.pR, 0.0F, this.pR, this.mHeight, this.wwa);
      paramCanvas.drawLine(this.pT, 0.0F, this.pT, this.mHeight, this.wwa);
    }
    this.wvU.setBounds(i, k, this.wwd + i, this.wwc + k);
    int n = (this.wvT.getIntrinsicWidth() - this.wwd) / 2;
    int i1 = (this.wvT.getIntrinsicHeight() - this.wwc) / 2;
    this.wvT.setBounds(i - n, k - i1, n + (this.wwd + i), i1 + (k + this.wwc));
    k = (this.mHeight - this.wwg) / 2;
    if ((this.wwj) || (this.wwn))
    {
      i -= (this.wwh - this.wwd) / 2;
      this.wvV.setBounds(i, k, this.wwh + i, this.wwg + k);
      k = 0;
      label799:
      if (k >= this.wvX) {
        break label933;
      }
      paramCanvas.save();
      if (k > 0) {
        paramCanvas.translate((this.wwd + this.wwb) * k, 0.0F);
      }
      if ((k != 0) || (!this.wwo)) {
        break label914;
      }
      this.wvT.draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      k += 1;
      break label799;
      i = i - (this.wwh - this.wwd) / 2 + (int)((this.wwd + this.wwb) * (this.wwl - this.wwk + this.wwm));
      break;
      label914:
      this.wvU.setAlpha(j);
      this.wvU.draw(paramCanvas);
    }
    label933:
    if (this.wwk > this.wvX - 1) {
      this.wwk = (this.wvX - 1);
    }
    k = (this.wwd + this.wwb) * this.wwk;
    if (i + k > this.pT) {
      y.i("MicroMsg.SmileyPanelScrollView", "over right.");
    }
    for (i = m;; i = k)
    {
      paramCanvas.save();
      paramCanvas.translate(i, 0.0F);
      this.wvV.draw(paramCanvas);
      paramCanvas.restore();
      break;
    }
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != this.mWidth)
    {
      this.mWidth = getMeasuredWidth();
      this.mHeight = getMeasuredHeight();
      this.wwf = (this.mWidth - (this.wvS.getColumnWidth() - this.wvS.wzr) - com.tencent.mm.cb.a.aa(this.mContext, a.c.SmallerPadding) * 2);
      this.wvZ = (this.wwf / (this.wwd + this.wwb));
      y.d("MicroMsg.SmileyPanelScrollView", "onSizeChanged mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.wwf), Integer.valueOf(this.wvZ) });
      if (this.mHeight == 0)
      {
        y.i("MicroMsg.SmileyPanelScrollView", "user default height");
        this.mHeight = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    int k = (int)paramMotionEvent.getX();
    if ((k < this.pR - this.wwb) || (k > this.pT + this.wwb))
    {
      y.d("MicroMsg.SmileyPanelScrollView", "over x :%d mLeft:%d mRight:%d ", new Object[] { Integer.valueOf(k), Integer.valueOf(this.pR), Integer.valueOf(this.pT) });
      if (m == 0) {
        return super.onTouchEvent(paramMotionEvent);
      }
    }
    for (int j = 1;; j = 0)
    {
      int i;
      if (j == 0)
      {
        i = k;
        if (k < this.pR) {
          i = this.pR;
        }
        k = i;
        if (i > this.pT) {
          k = this.pT;
        }
        if (this.wwi)
        {
          i = this.wwf / (this.wvX - 1);
          i = (k - this.pR) / i;
          k = i;
          if (i > this.wvX - 1) {
            k = this.wvX - 1;
          }
          this.wvR.IM(k);
          this.wwk = k;
          this.wwl = k;
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
        return true;
        i = (k - this.pR + this.wwb) / (this.wwd + this.wwb);
        break;
        if (j == 0)
        {
          this.wwj = true;
          this.wwn = true;
          setState(this.wwq);
          this.wwr.cLx();
          invalidate();
          continue;
          if ((j == 0) && (getState() != this.wwq))
          {
            setState(this.wwq);
            this.wwr.cLx();
            invalidate();
            continue;
            setState(this.STATE_NONE);
            this.wwj = false;
            invalidate();
          }
        }
      }
    }
  }
  
  public void setOnPageSelectListener(b paramb)
  {
    this.wvR = paramb;
  }
  
  public void setSmileyPanelStg(com.tencent.mm.view.f.a parama)
  {
    this.wvS = parama;
  }
  
  public void setState(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public static abstract interface b
  {
    public abstract void IM(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelScrollView
 * JD-Core Version:    0.7.0.1
 */