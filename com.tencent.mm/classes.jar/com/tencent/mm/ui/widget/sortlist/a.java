package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends d
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  private int AKK;
  boolean AKL;
  boolean AKM;
  private boolean AKN;
  private GestureDetector AKO;
  private int AKP;
  private int AKQ;
  private int AKR;
  private int AKS;
  private int AKT;
  private boolean AKU;
  private float AKV;
  private int AKW;
  private int AKX;
  private int AKY;
  private boolean AKZ;
  private DragSortListView ALa;
  private int ALb;
  private GestureDetector.OnGestureListener ALc;
  private GestureDetector FQ;
  private int ien;
  private int ieo;
  private int loh;
  private int mTouchSlop;
  private int[] rw;
  
  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    AppMethodBeat.i(113010);
    this.AKK = 0;
    this.AKL = true;
    this.AKM = false;
    this.AKN = false;
    this.AKP = -1;
    this.AKQ = -1;
    this.AKR = -1;
    this.rw = new int[2];
    this.AKU = false;
    this.AKV = 500.0F;
    this.ALc = new a.1(this);
    this.ALa = paramDragSortListView;
    this.FQ = new GestureDetector(paramDragSortListView.getContext(), this);
    this.AKO = new GestureDetector(paramDragSortListView.getContext(), this.ALc);
    this.AKO.setIsLongpressEnabled(false);
    this.mTouchSlop = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.AKW = paramInt1;
    this.AKX = paramInt4;
    this.AKY = paramInt5;
    this.loh = paramInt3;
    this.AKK = paramInt2;
    AppMethodBeat.o(113010);
  }
  
  private boolean aE(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    AppMethodBeat.i(113011);
    if ((this.AKL) && (!this.AKN)) {}
    for (int i = 12;; i = 0)
    {
      if ((this.AKM) && (this.AKN)) {
        i = i | 0x1 | 0x2;
      }
      for (;;)
      {
        DragSortListView localDragSortListView = this.ALa;
        paramInt1 -= this.ALa.getHeaderViewsCount();
        boolean bool1 = bool2;
        if (localDragSortListView.ALP)
        {
          if (localDragSortListView.ALQ != null) {
            break label108;
          }
          bool1 = bool2;
        }
        for (;;)
        {
          this.AKU = bool1;
          bool1 = this.AKU;
          AppMethodBeat.o(113011);
          return bool1;
          label108:
          View localView = localDragSortListView.ALQ.RC(paramInt1);
          bool1 = bool2;
          if (localView != null) {
            bool1 = localDragSortListView.a(paramInt1, localView, i, paramInt2, paramInt3);
          }
        }
      }
    }
  }
  
  private int e(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(113013);
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    i = this.ALa.pointToPosition(i, j);
    j = this.ALa.getHeaderViewsCount();
    int k = this.ALa.getFooterViewsCount();
    int m = this.ALa.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      Object localObject = this.ALa;
      localObject = ((DragSortListView)localObject).getChildAt(i - ((DragSortListView)localObject).getFirstVisiblePosition());
      k = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = (MotionEvent)localObject; paramMotionEvent != null; paramMotionEvent = ((View)localObject).findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.rw);
        if ((k <= this.rw[0]) || (j <= this.rw[1]) || (k >= this.rw[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.rw[1];
        if (j >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.AKS = ((View)localObject).getLeft();
        this.AKT = ((View)localObject).getTop();
        AppMethodBeat.o(113013);
        return i;
      }
    }
    AppMethodBeat.o(113013);
    return -1;
  }
  
  public final void i(Point paramPoint)
  {
    if ((this.AKM) && (this.AKN)) {
      this.ALb = paramPoint.x;
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    int i = -1;
    AppMethodBeat.i(113014);
    if ((this.AKM) && (this.loh == 0)) {
      this.AKR = e(paramMotionEvent, this.AKX);
    }
    this.AKP = e(paramMotionEvent, this.AKW);
    if ((this.AKP != -1) && (this.AKK == 0)) {
      aE(this.AKP, (int)paramMotionEvent.getX() - this.AKS, (int)paramMotionEvent.getY() - this.AKT);
    }
    this.AKN = false;
    this.AKZ = true;
    this.ALb = 0;
    if (this.loh == 1) {
      i = e(paramMotionEvent, this.AKY);
    }
    this.AKQ = i;
    AppMethodBeat.o(113014);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113016);
    if ((this.AKP != -1) && (this.AKK == 2))
    {
      this.ALa.performHapticFeedback(0);
      aE(this.AKP, this.ien - this.AKS, this.ieo - this.AKT);
    }
    AppMethodBeat.o(113016);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(113015);
    int i = (int)paramMotionEvent1.getX();
    int j = (int)paramMotionEvent1.getY();
    int k = (int)paramMotionEvent2.getX();
    int m = (int)paramMotionEvent2.getY();
    int n = k - this.AKS;
    int i1 = m - this.AKT;
    if ((this.AKZ) && (!this.AKU) && ((this.AKP != -1) || (this.AKQ != -1)))
    {
      if (this.AKP == -1) {
        break label189;
      }
      if ((this.AKK != 1) || (Math.abs(m - j) <= this.mTouchSlop) || (!this.AKL)) {
        break label139;
      }
      aE(this.AKP, n, i1);
    }
    for (;;)
    {
      AppMethodBeat.o(113015);
      return false;
      label139:
      if ((this.AKK != 0) && (Math.abs(k - i) > this.mTouchSlop) && (this.AKM))
      {
        this.AKN = true;
        aE(this.AKQ, n, i1);
        continue;
        label189:
        if (this.AKQ != -1) {
          if ((Math.abs(k - i) > this.mTouchSlop) && (this.AKM))
          {
            this.AKN = true;
            aE(this.AKQ, n, i1);
          }
          else if (Math.abs(m - j) > this.mTouchSlop)
          {
            this.AKZ = false;
          }
        }
      }
    }
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113017);
    if ((this.AKM) && (this.loh == 0) && (this.AKR != -1)) {
      this.ALa.removeItem(this.AKR - this.ALa.getHeaderViewsCount());
    }
    AppMethodBeat.o(113017);
    return true;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113012);
    if ((!this.ALa.ALu) || (this.ALa.AMf))
    {
      AppMethodBeat.o(113012);
      return false;
    }
    this.FQ.onTouchEvent(paramMotionEvent);
    if ((this.AKM) && (this.AKU) && (this.loh == 1)) {
      this.AKO.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113012);
      return false;
      this.ien = ((int)paramMotionEvent.getX());
      this.ieo = ((int)paramMotionEvent.getY());
      continue;
      if ((this.AKM) && (this.AKN))
      {
        if (this.ALb >= 0) {}
        for (int i = this.ALb; i > this.ALa.getWidth() / 2; i = -this.ALb)
        {
          this.ALa.bz(0.0F);
          break;
        }
        this.AKN = false;
        this.AKU = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.a
 * JD-Core Version:    0.7.0.1
 */