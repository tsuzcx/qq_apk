package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public final class a
  extends d
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  private GestureDetector Fh;
  private int gFj;
  private int gFk;
  private int jb;
  private int jfp;
  private int[] qz = new int[2];
  private int wqh = 0;
  boolean wqi = true;
  boolean wqj = false;
  private boolean wqk = false;
  private GestureDetector wql;
  private int wqm = -1;
  private int wqn = -1;
  private int wqo = -1;
  private int wqp;
  private int wqq;
  private boolean wqr = false;
  private float wqs = 500.0F;
  private int wqt;
  private int wqu;
  private int wqv;
  private boolean wqw;
  private DragSortListView wqx;
  private int wqy;
  private GestureDetector.OnGestureListener wqz = new a.1(this);
  
  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    this.wqx = paramDragSortListView;
    this.Fh = new GestureDetector(paramDragSortListView.getContext(), this);
    this.wql = new GestureDetector(paramDragSortListView.getContext(), this.wqz);
    this.wql.setIsLongpressEnabled(false);
    this.jb = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.wqt = paramInt1;
    this.wqu = paramInt4;
    this.wqv = paramInt5;
    this.jfp = paramInt3;
    this.wqh = paramInt2;
  }
  
  private boolean as(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    if ((this.wqi) && (!this.wqk)) {}
    for (int i = 12;; i = 0)
    {
      if ((this.wqj) && (this.wqk)) {
        i = i | 0x1 | 0x2;
      }
      for (;;)
      {
        DragSortListView localDragSortListView = this.wqx;
        paramInt1 -= this.wqx.getHeaderViewsCount();
        boolean bool1 = bool2;
        if (localDragSortListView.wrl)
        {
          if (localDragSortListView.wrm != null) {
            break label94;
          }
          bool1 = bool2;
        }
        for (;;)
        {
          this.wqr = bool1;
          return this.wqr;
          label94:
          View localView = localDragSortListView.wrm.II(paramInt1);
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
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    i = this.wqx.pointToPosition(i, j);
    j = this.wqx.getHeaderViewsCount();
    int k = this.wqx.getFooterViewsCount();
    int m = this.wqx.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      View localView = this.wqx.getChildAt(i - this.wqx.getFirstVisiblePosition());
      k = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = localView; paramMotionEvent != null; paramMotionEvent = localView.findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.qz);
        if ((k <= this.qz[0]) || (j <= this.qz[1]) || (k >= this.qz[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.qz[1];
        if (j >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.wqp = localView.getLeft();
        this.wqq = localView.getTop();
        return i;
      }
    }
    return -1;
  }
  
  public final void i(Point paramPoint)
  {
    if ((this.wqj) && (this.wqk)) {
      this.wqy = paramPoint.x;
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    int i = -1;
    if ((this.wqj) && (this.jfp == 0)) {
      this.wqo = e(paramMotionEvent, this.wqu);
    }
    this.wqm = e(paramMotionEvent, this.wqt);
    if ((this.wqm != -1) && (this.wqh == 0)) {
      as(this.wqm, (int)paramMotionEvent.getX() - this.wqp, (int)paramMotionEvent.getY() - this.wqq);
    }
    this.wqk = false;
    this.wqw = true;
    this.wqy = 0;
    if (this.jfp == 1) {
      i = e(paramMotionEvent, this.wqv);
    }
    this.wqn = i;
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.wqm != -1) && (this.wqh == 2))
    {
      this.wqx.performHapticFeedback(0);
      as(this.wqm, this.gFj - this.wqp, this.gFk - this.wqq);
    }
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i = (int)paramMotionEvent1.getX();
    int j = (int)paramMotionEvent1.getY();
    int k = (int)paramMotionEvent2.getX();
    int m = (int)paramMotionEvent2.getY();
    int n = k - this.wqp;
    int i1 = m - this.wqq;
    if ((this.wqw) && (!this.wqr) && ((this.wqm != -1) || (this.wqn != -1)))
    {
      if (this.wqm == -1) {
        break label178;
      }
      if ((this.wqh != 1) || (Math.abs(m - j) <= this.jb) || (!this.wqi)) {
        break label129;
      }
      as(this.wqm, n, i1);
    }
    label129:
    label178:
    do
    {
      do
      {
        do
        {
          return false;
        } while ((this.wqh == 0) || (Math.abs(k - i) <= this.jb) || (!this.wqj));
        this.wqk = true;
        as(this.wqn, n, i1);
        return false;
      } while (this.wqn == -1);
      if ((Math.abs(k - i) > this.jb) && (this.wqj))
      {
        this.wqk = true;
        as(this.wqn, n, i1);
        return false;
      }
    } while (Math.abs(m - j) <= this.jb);
    this.wqw = false;
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((this.wqj) && (this.jfp == 0) && (this.wqo != -1)) {
      this.wqx.removeItem(this.wqo - this.wqx.getHeaderViewsCount());
    }
    return true;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!this.wqx.wqR) || (this.wqx.wrB)) {}
    do
    {
      return false;
      this.Fh.onTouchEvent(paramMotionEvent);
      if ((this.wqj) && (this.wqr) && (this.jfp == 1)) {
        this.wql.onTouchEvent(paramMotionEvent);
      }
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        return false;
      case 0: 
        this.gFj = ((int)paramMotionEvent.getX());
        this.gFk = ((int)paramMotionEvent.getY());
        return false;
      }
    } while ((!this.wqj) || (!this.wqk));
    if (this.wqy >= 0) {}
    for (int i = this.wqy; i > this.wqx.getWidth() / 2; i = -this.wqy)
    {
      this.wqx.aO(0.0F);
      return false;
    }
    this.wqk = false;
    this.wqr = false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.a
 * JD-Core Version:    0.7.0.1
 */