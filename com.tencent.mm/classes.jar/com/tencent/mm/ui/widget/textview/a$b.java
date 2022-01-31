package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;

final class a$b
  extends View
{
  int[] ANA;
  private Point ANB;
  private boolean ANC;
  boolean ANv;
  private int ANw;
  private int ANx;
  private int ANy;
  private int ANz;
  private int mHeight;
  private int mPadding;
  private Paint mPaint;
  PopupWindow mPopupWindow;
  int mWidth;
  private Rect rect;
  private int vzU;
  private int[] zzX;
  
  a$b(a parama, boolean paramBoolean)
  {
    super(parama.mContext);
    AppMethodBeat.i(113131);
    this.vzU = (this.ANs.ANc / 2);
    this.mWidth = (this.vzU * 2);
    this.mHeight = (this.vzU * 2);
    this.mPadding = 25;
    this.ANA = new int[2];
    this.rect = new Rect();
    this.ANB = new Point();
    this.ANC = false;
    this.zzX = new int[2];
    this.ANv = paramBoolean;
    this.mPaint = new Paint(1);
    this.mPaint.setColor(parama.mContext.getResources().getColor(parama.ANb));
    this.mPopupWindow = new PopupWindow(this);
    this.mPopupWindow.setClippingEnabled(false);
    this.mPopupWindow.setWidth(this.mWidth + this.mPadding * 2);
    this.mPopupWindow.setHeight(this.mHeight + this.mPadding / 2);
    AppMethodBeat.o(113131);
  }
  
  private void dPY()
  {
    AppMethodBeat.i(113134);
    if (!this.ANv) {}
    for (boolean bool = true;; bool = false)
    {
      this.ANv = bool;
      invalidate();
      AppMethodBeat.o(113134);
      return;
    }
  }
  
  private void dPZ()
  {
    AppMethodBeat.i(113136);
    this.ANs.AMT.getLocationInWindow(this.ANA);
    Object localObject = b.fA(this.ANs.AMT);
    if (localObject != null)
    {
      int i = (int)((TextPaint)localObject).getFontMetrics().descent;
      if (this.ANv)
      {
        this.mPopupWindow.update((int)b.aw(this.ANs.AMT, this.ANs.AMQ.akX) - this.mWidth + dQa(), i + b.au(this.ANs.AMT, b.av(this.ANs.AMT, this.ANs.AMQ.akX)) + dQb(), -1, -1);
        AppMethodBeat.o(113136);
        return;
      }
      localObject = ia((int)b.aw(this.ANs.AMT, this.ANs.AMQ.Fe), i + b.au(this.ANs.AMT, b.av(this.ANs.AMT, this.ANs.AMQ.Fe)));
      i = localObject[0];
      int j = localObject[1];
      this.mPopupWindow.update(i + dQa(), j + dQb(), -1, -1);
    }
    AppMethodBeat.o(113136);
  }
  
  private void update(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113135);
    this.ANs.AMT.getLocationInWindow(this.ANA);
    int i;
    b localb;
    if (this.ANv)
    {
      i = this.ANs.AMQ.akX;
      int j = this.ANA[1];
      paramInt1 = b.d(this.ANs.AMT, paramInt1, paramInt2 - j, i);
      if (paramInt1 == i) {
        break label225;
      }
      this.ANs.dPQ();
      if (!this.ANv) {
        break label169;
      }
      if (paramInt1 <= this.ANz) {
        break label157;
      }
      localb = a.a(this.ANs, false);
      dPY();
      localb.dPY();
      this.ANy = this.ANz;
      this.ANs.hZ(this.ANz, paramInt1);
      localb.dPZ();
    }
    for (;;)
    {
      dPZ();
      AppMethodBeat.o(113135);
      return;
      i = this.ANs.AMQ.Fe;
      break;
      label157:
      this.ANs.hZ(paramInt1, -1);
    }
    label169:
    if (paramInt1 < this.ANy)
    {
      localb = a.a(this.ANs, true);
      localb.dPY();
      dPY();
      this.ANz = this.ANy;
      this.ANs.hZ(paramInt1, this.ANy);
      localb.dPZ();
    }
    for (;;)
    {
      dPZ();
      label225:
      AppMethodBeat.o(113135);
      return;
      this.ANs.hZ(this.ANy, paramInt1);
    }
  }
  
  public final int dQa()
  {
    AppMethodBeat.i(113137);
    int i = this.ANA[0];
    int j = this.mPadding;
    int k = this.ANs.AMT.getPaddingLeft();
    AppMethodBeat.o(113137);
    return i - j + k;
  }
  
  public final int dQb()
  {
    AppMethodBeat.i(113138);
    int i = this.ANA[1];
    int j = this.ANs.AMT.getPaddingTop();
    AppMethodBeat.o(113138);
    return i + j;
  }
  
  public final void dQc()
  {
    AppMethodBeat.i(113140);
    this.mPopupWindow.setOutsideTouchable(true);
    AppMethodBeat.o(113140);
  }
  
  final int[] ia(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113139);
    int j = paramInt1;
    int i = paramInt2;
    if (paramInt1 == 0)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.ANs.AMQ.Fe > 1)
      {
        this.ANs.AMT.getLocationInWindow(this.ANA);
        TextPaint localTextPaint = b.fA(this.ANs.AMT);
        j = paramInt1;
        i = paramInt2;
        if (localTextPaint != null)
        {
          paramInt1 = (int)localTextPaint.getFontMetrics().descent;
          paramInt2 = b.av(this.ANs.AMT, this.ANs.AMQ.Fe - 1);
          j = (int)b.az(this.ANs.AMT, paramInt2);
          i = b.au(this.ANs.AMT, b.av(this.ANs.AMT, this.ANs.AMQ.Fe - 1)) + paramInt1;
        }
      }
    }
    AppMethodBeat.o(113139);
    return new int[] { j, i };
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113132);
    int i;
    int j;
    int k;
    if (this.ANs.AMU != null) {
      if (this.ANv)
      {
        i = this.ANs.AMQ.akX;
        TextPaint localTextPaint = b.fA(this.ANs.AMT);
        if (localTextPaint == null) {
          break label486;
        }
        j = b.au(this.ANs.AMT, b.av(this.ANs.AMT, i));
        j = (int)localTextPaint.getFontMetrics().descent + j;
        k = (int)b.aw(this.ANs.AMT, i);
        i = j;
        j = k;
      }
    }
    for (;;)
    {
      this.ANs.AMT.getLocationInWindow(this.ANA);
      k = i;
      if (!this.ANv) {
        k = ia(j, i)[1];
      }
      i = dQb() + k;
      if (this.ANs.AMT.getGlobalVisibleRect(this.rect, this.ANB))
      {
        if (i >= this.rect.bottom)
        {
          if (this.ANv)
          {
            ak.d("SelectableTextHelper", "start below bottom, dismiss all.", new Object[0]);
            this.ANs.dPQ();
            this.ANs.ANj = true;
            this.ANs.ANk = true;
            this.ANs.dPP();
            this.ANs.AMU.dismiss();
          }
          ak.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
          AppMethodBeat.o(113132);
          return;
          i = this.ANs.AMQ.Fe;
          break;
        }
        if (i > this.rect.top) {
          break label374;
        }
        if (!this.ANv)
        {
          ak.d("SelectableTextHelper", "end above top, dismiss all.", new Object[0]);
          this.ANs.dPQ();
          this.ANs.ANj = true;
          this.ANs.ANk = true;
          this.ANs.dPP();
          this.ANs.AMU.dismiss();
        }
        ak.d("SelectableTextHelper", "cursor invisible.", new Object[0]);
        AppMethodBeat.o(113132);
        return;
      }
      ak.d("SelectableTextHelper", "view invisible.", new Object[0]);
      AppMethodBeat.o(113132);
      return;
      label374:
      paramCanvas.drawCircle(this.vzU + this.mPadding, this.vzU, this.vzU, this.mPaint);
      if (this.ANv)
      {
        paramCanvas.drawRect(this.vzU + this.mPadding, 0.0F, this.vzU * 2 + this.mPadding, this.vzU, this.mPaint);
        AppMethodBeat.o(113132);
        return;
      }
      paramCanvas.drawRect(this.mPadding, 0.0F, this.vzU + this.mPadding, this.vzU, this.mPaint);
      AppMethodBeat.o(113132);
      return;
      label486:
      j = 0;
      i = 0;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113133);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113133);
      return true;
      this.ANy = this.ANs.AMQ.akX;
      this.ANz = this.ANs.AMQ.Fe;
      this.ANw = ((int)paramMotionEvent.getX());
      this.ANx = ((int)paramMotionEvent.getY());
      this.ANC = false;
      this.ANs.AMT.getLocationInWindow(this.zzX);
      continue;
      if ((this.ANs.AMU != null) && (!this.ANC))
      {
        this.ANC = true;
        if (this.ANs.AMQ.Fe - this.ANs.AMQ.akX == b.fz(this.ANs.AMT).length())
        {
          this.ANs.AMU.eW(this.ANs.AMT);
          this.ANs.ANj = true;
          this.ANs.dPU();
        }
        else
        {
          this.ANs.AMU.dismiss();
          this.ANs.ANj = false;
          this.ANs.dPW();
        }
      }
      else if (!this.ANs.ANj)
      {
        this.ANs.dPW();
        continue;
        if (this.ANs.AMU != null) {
          this.ANs.AMU.dismiss();
        }
        this.ANs.dPU();
        int i = (int)paramMotionEvent.getRawX();
        int j = (int)paramMotionEvent.getRawY();
        if (this.ANs.AMU == null) {
          update(i - this.zzX[0], j + this.ANx - this.mHeight - this.ANs.ANe);
        } else {
          update(i - this.zzX[0] + this.vzU, j + this.ANx - this.mHeight - this.ANs.ANe);
        }
      }
    }
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(138212);
    this.mPopupWindow.setOnDismissListener(paramOnDismissListener);
    AppMethodBeat.o(138212);
  }
  
  public final void setTouchInterceptor(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(113141);
    this.mPopupWindow.setTouchInterceptor(paramOnTouchListener);
    AppMethodBeat.o(113141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.b
 * JD-Core Version:    0.7.0.1
 */