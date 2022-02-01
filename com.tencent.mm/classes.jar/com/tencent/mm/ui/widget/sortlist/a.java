package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends d
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  boolean HLA;
  boolean HLB;
  private boolean HLC;
  private GestureDetector HLD;
  private int HLE;
  private int HLF;
  private int HLG;
  private int HLH;
  private int HLI;
  private boolean HLJ;
  private float HLK;
  private int HLL;
  private int HLM;
  private int HLN;
  private boolean HLO;
  private DragSortListView HLP;
  private int HLQ;
  private GestureDetector.OnGestureListener HLR;
  private int HLz;
  private GestureDetector MQ;
  private int krn;
  private int kro;
  private int mTouchSlop;
  private int oEv;
  private int[] xV;
  
  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    AppMethodBeat.i(159739);
    this.HLz = 0;
    this.HLA = true;
    this.HLB = false;
    this.HLC = false;
    this.HLE = -1;
    this.HLF = -1;
    this.HLG = -1;
    this.xV = new int[2];
    this.HLJ = false;
    this.HLK = 500.0F;
    this.HLR = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(159738);
        int i;
        if ((a.a(a.this)) && (a.b(a.this)))
        {
          i = a.c(a.this).getWidth() / 5;
          if (paramAnonymousFloat1 <= a.d(a.this)) {
            break label91;
          }
          if (a.e(a.this) > -i) {
            a.c(a.this).bM(paramAnonymousFloat1);
          }
        }
        for (;;)
        {
          a.f(a.this);
          AppMethodBeat.o(159738);
          return false;
          label91:
          if ((paramAnonymousFloat1 < -a.d(a.this)) && (a.e(a.this) < i)) {
            a.c(a.this).bM(paramAnonymousFloat1);
          }
        }
      }
    };
    this.HLP = paramDragSortListView;
    this.MQ = new GestureDetector(paramDragSortListView.getContext(), this);
    this.HLD = new GestureDetector(paramDragSortListView.getContext(), this.HLR);
    this.HLD.setIsLongpressEnabled(false);
    this.mTouchSlop = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.HLL = paramInt1;
    this.HLM = paramInt4;
    this.HLN = paramInt5;
    this.oEv = paramInt3;
    this.HLz = paramInt2;
    AppMethodBeat.o(159739);
  }
  
  private boolean aQ(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    AppMethodBeat.i(159740);
    if ((this.HLA) && (!this.HLC)) {}
    for (int i = 12;; i = 0)
    {
      if ((this.HLB) && (this.HLC)) {
        i = i | 0x1 | 0x2;
      }
      for (;;)
      {
        DragSortListView localDragSortListView = this.HLP;
        paramInt1 -= this.HLP.getHeaderViewsCount();
        boolean bool1 = bool2;
        if (localDragSortListView.HME)
        {
          if (localDragSortListView.HMF != null) {
            break label108;
          }
          bool1 = bool2;
        }
        for (;;)
        {
          this.HLJ = bool1;
          bool1 = this.HLJ;
          AppMethodBeat.o(159740);
          return bool1;
          label108:
          View localView = localDragSortListView.HMF.abb(paramInt1);
          bool1 = bool2;
          if (localView != null) {
            bool1 = localDragSortListView.a(paramInt1, localView, i, paramInt2, paramInt3);
          }
        }
      }
    }
  }
  
  private int f(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(159742);
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    i = this.HLP.pointToPosition(i, j);
    j = this.HLP.getHeaderViewsCount();
    int k = this.HLP.getFooterViewsCount();
    int m = this.HLP.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      Object localObject = this.HLP;
      localObject = ((DragSortListView)localObject).getChildAt(i - ((DragSortListView)localObject).getFirstVisiblePosition());
      k = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = (MotionEvent)localObject; paramMotionEvent != null; paramMotionEvent = ((View)localObject).findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.xV);
        if ((k <= this.xV[0]) || (j <= this.xV[1]) || (k >= this.xV[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.xV[1];
        if (j >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.HLH = ((View)localObject).getLeft();
        this.HLI = ((View)localObject).getTop();
        AppMethodBeat.o(159742);
        return i;
      }
    }
    AppMethodBeat.o(159742);
    return -1;
  }
  
  public final void h(Point paramPoint)
  {
    if ((this.HLB) && (this.HLC)) {
      this.HLQ = paramPoint.x;
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    int i = -1;
    AppMethodBeat.i(159743);
    if ((this.HLB) && (this.oEv == 0)) {
      this.HLG = f(paramMotionEvent, this.HLM);
    }
    this.HLE = f(paramMotionEvent, this.HLL);
    if ((this.HLE != -1) && (this.HLz == 0)) {
      aQ(this.HLE, (int)paramMotionEvent.getX() - this.HLH, (int)paramMotionEvent.getY() - this.HLI);
    }
    this.HLC = false;
    this.HLO = true;
    this.HLQ = 0;
    if (this.oEv == 1) {
      i = f(paramMotionEvent, this.HLN);
    }
    this.HLF = i;
    AppMethodBeat.o(159743);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159745);
    if ((this.HLE != -1) && (this.HLz == 2))
    {
      this.HLP.performHapticFeedback(0);
      aQ(this.HLE, this.krn - this.HLH, this.kro - this.HLI);
    }
    AppMethodBeat.o(159745);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(159744);
    int i = (int)paramMotionEvent1.getX();
    int j = (int)paramMotionEvent1.getY();
    int k = (int)paramMotionEvent2.getX();
    int m = (int)paramMotionEvent2.getY();
    int n = k - this.HLH;
    int i1 = m - this.HLI;
    if ((this.HLO) && (!this.HLJ) && ((this.HLE != -1) || (this.HLF != -1)))
    {
      if (this.HLE == -1) {
        break label189;
      }
      if ((this.HLz != 1) || (Math.abs(m - j) <= this.mTouchSlop) || (!this.HLA)) {
        break label139;
      }
      aQ(this.HLE, n, i1);
    }
    for (;;)
    {
      AppMethodBeat.o(159744);
      return false;
      label139:
      if ((this.HLz != 0) && (Math.abs(k - i) > this.mTouchSlop) && (this.HLB))
      {
        this.HLC = true;
        aQ(this.HLF, n, i1);
        continue;
        label189:
        if (this.HLF != -1) {
          if ((Math.abs(k - i) > this.mTouchSlop) && (this.HLB))
          {
            this.HLC = true;
            aQ(this.HLF, n, i1);
          }
          else if (Math.abs(m - j) > this.mTouchSlop)
          {
            this.HLO = false;
          }
        }
      }
    }
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159746);
    if ((this.HLB) && (this.oEv == 0) && (this.HLG != -1)) {
      this.HLP.removeItem(this.HLG - this.HLP.getHeaderViewsCount());
    }
    AppMethodBeat.o(159746);
    return true;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159741);
    if ((!this.HLP.HMk) || (this.HLP.HMU))
    {
      AppMethodBeat.o(159741);
      return false;
    }
    this.MQ.onTouchEvent(paramMotionEvent);
    if ((this.HLB) && (this.HLJ) && (this.oEv == 1)) {
      this.HLD.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(159741);
      return false;
      this.krn = ((int)paramMotionEvent.getX());
      this.kro = ((int)paramMotionEvent.getY());
      continue;
      if ((this.HLB) && (this.HLC))
      {
        if (this.HLQ >= 0) {}
        for (int i = this.HLQ; i > this.HLP.getWidth() / 2; i = -this.HLQ)
        {
          this.HLP.bM(0.0F);
          break;
        }
        this.HLC = false;
        this.HLJ = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.a
 * JD-Core Version:    0.7.0.1
 */