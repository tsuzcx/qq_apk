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
  private int JlW;
  boolean JlX;
  boolean JlY;
  private boolean JlZ;
  private GestureDetector Jma;
  private int Jmb;
  private int Jmc;
  private int Jmd;
  private int Jme;
  private int Jmf;
  private boolean Jmg;
  private float Jmh;
  private int Jmi;
  private int Jmj;
  private int Jmk;
  private boolean Jml;
  private DragSortListView Jmm;
  private int Jmn;
  private GestureDetector.OnGestureListener Jmo;
  private GestureDetector NL;
  private int kSG;
  private int kSH;
  private int mTouchSlop;
  private int phU;
  private int[] yT;
  
  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    AppMethodBeat.i(159739);
    this.JlW = 0;
    this.JlX = true;
    this.JlY = false;
    this.JlZ = false;
    this.Jmb = -1;
    this.Jmc = -1;
    this.Jmd = -1;
    this.yT = new int[2];
    this.Jmg = false;
    this.Jmh = 500.0F;
    this.Jmo = new GestureDetector.SimpleOnGestureListener()
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
            a.c(a.this).bV(paramAnonymousFloat1);
          }
        }
        for (;;)
        {
          a.f(a.this);
          AppMethodBeat.o(159738);
          return false;
          label91:
          if ((paramAnonymousFloat1 < -a.d(a.this)) && (a.e(a.this) < i)) {
            a.c(a.this).bV(paramAnonymousFloat1);
          }
        }
      }
    };
    this.Jmm = paramDragSortListView;
    this.NL = new GestureDetector(paramDragSortListView.getContext(), this);
    this.Jma = new GestureDetector(paramDragSortListView.getContext(), this.Jmo);
    this.Jma.setIsLongpressEnabled(false);
    this.mTouchSlop = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.Jmi = paramInt1;
    this.Jmj = paramInt4;
    this.Jmk = paramInt5;
    this.phU = paramInt3;
    this.JlW = paramInt2;
    AppMethodBeat.o(159739);
  }
  
  private boolean aS(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    AppMethodBeat.i(159740);
    if ((this.JlX) && (!this.JlZ)) {}
    for (int i = 12;; i = 0)
    {
      if ((this.JlY) && (this.JlZ)) {
        i = i | 0x1 | 0x2;
      }
      for (;;)
      {
        DragSortListView localDragSortListView = this.Jmm;
        paramInt1 -= this.Jmm.getHeaderViewsCount();
        boolean bool1 = bool2;
        if (localDragSortListView.Jna)
        {
          if (localDragSortListView.Jnb != null) {
            break label108;
          }
          bool1 = bool2;
        }
        for (;;)
        {
          this.Jmg = bool1;
          bool1 = this.Jmg;
          AppMethodBeat.o(159740);
          return bool1;
          label108:
          View localView = localDragSortListView.Jnb.adn(paramInt1);
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
    i = this.Jmm.pointToPosition(i, j);
    j = this.Jmm.getHeaderViewsCount();
    int k = this.Jmm.getFooterViewsCount();
    int m = this.Jmm.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      Object localObject = this.Jmm;
      localObject = ((DragSortListView)localObject).getChildAt(i - ((DragSortListView)localObject).getFirstVisiblePosition());
      k = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = (MotionEvent)localObject; paramMotionEvent != null; paramMotionEvent = ((View)localObject).findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.yT);
        if ((k <= this.yT[0]) || (j <= this.yT[1]) || (k >= this.yT[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.yT[1];
        if (j >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.Jme = ((View)localObject).getLeft();
        this.Jmf = ((View)localObject).getTop();
        AppMethodBeat.o(159742);
        return i;
      }
    }
    AppMethodBeat.o(159742);
    return -1;
  }
  
  public final void j(Point paramPoint)
  {
    if ((this.JlY) && (this.JlZ)) {
      this.Jmn = paramPoint.x;
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    int i = -1;
    AppMethodBeat.i(159743);
    if ((this.JlY) && (this.phU == 0)) {
      this.Jmd = f(paramMotionEvent, this.Jmj);
    }
    this.Jmb = f(paramMotionEvent, this.Jmi);
    if ((this.Jmb != -1) && (this.JlW == 0)) {
      aS(this.Jmb, (int)paramMotionEvent.getX() - this.Jme, (int)paramMotionEvent.getY() - this.Jmf);
    }
    this.JlZ = false;
    this.Jml = true;
    this.Jmn = 0;
    if (this.phU == 1) {
      i = f(paramMotionEvent, this.Jmk);
    }
    this.Jmc = i;
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
    if ((this.Jmb != -1) && (this.JlW == 2))
    {
      this.Jmm.performHapticFeedback(0);
      aS(this.Jmb, this.kSG - this.Jme, this.kSH - this.Jmf);
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
    int n = k - this.Jme;
    int i1 = m - this.Jmf;
    if ((this.Jml) && (!this.Jmg) && ((this.Jmb != -1) || (this.Jmc != -1)))
    {
      if (this.Jmb == -1) {
        break label189;
      }
      if ((this.JlW != 1) || (Math.abs(m - j) <= this.mTouchSlop) || (!this.JlX)) {
        break label139;
      }
      aS(this.Jmb, n, i1);
    }
    for (;;)
    {
      AppMethodBeat.o(159744);
      return false;
      label139:
      if ((this.JlW != 0) && (Math.abs(k - i) > this.mTouchSlop) && (this.JlY))
      {
        this.JlZ = true;
        aS(this.Jmc, n, i1);
        continue;
        label189:
        if (this.Jmc != -1) {
          if ((Math.abs(k - i) > this.mTouchSlop) && (this.JlY))
          {
            this.JlZ = true;
            aS(this.Jmc, n, i1);
          }
          else if (Math.abs(m - j) > this.mTouchSlop)
          {
            this.Jml = false;
          }
        }
      }
    }
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159746);
    if ((this.JlY) && (this.phU == 0) && (this.Jmd != -1)) {
      this.Jmm.removeItem(this.Jmd - this.Jmm.getHeaderViewsCount());
    }
    AppMethodBeat.o(159746);
    return true;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159741);
    if ((!this.Jmm.JmG) || (this.Jmm.Jnq))
    {
      AppMethodBeat.o(159741);
      return false;
    }
    this.NL.onTouchEvent(paramMotionEvent);
    if ((this.JlY) && (this.Jmg) && (this.phU == 1)) {
      this.Jma.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(159741);
      return false;
      this.kSG = ((int)paramMotionEvent.getX());
      this.kSH = ((int)paramMotionEvent.getY());
      continue;
      if ((this.JlY) && (this.JlZ))
      {
        if (this.Jmn >= 0) {}
        for (int i = this.Jmn; i > this.Jmm.getWidth() / 2; i = -this.Jmn)
        {
          this.Jmm.bV(0.0F);
          break;
        }
        this.JlZ = false;
        this.Jmg = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.a
 * JD-Core Version:    0.7.0.1
 */