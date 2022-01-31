package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.view.View;

final class DragSortListView$g
  extends DragSortListView.m
{
  private int wrQ;
  private int wrR;
  private float wrS;
  private float wrT;
  
  private DragSortListView$g(DragSortListView paramDragSortListView, int paramInt)
  {
    super(paramDragSortListView, paramInt, (byte)0);
  }
  
  private int cKH()
  {
    int i = this.wrD.getFirstVisiblePosition();
    int j = (DragSortListView.i(this.wrD) + this.wrD.getDividerHeight()) / 2;
    View localView = this.wrD.getChildAt(this.wrQ - i);
    if (localView != null)
    {
      if (this.wrQ == this.wrR) {
        return localView.getTop();
      }
      if (this.wrQ < this.wrR) {
        return localView.getTop() - j;
      }
      return localView.getBottom() + j - DragSortListView.j(this.wrD);
    }
    this.pP = true;
    return -1;
  }
  
  public final void aQ(float paramFloat)
  {
    int i = cKH();
    int j = this.wrD.getPaddingLeft();
    float f1 = DragSortListView.d(this.wrD).y - i;
    float f2 = DragSortListView.d(this.wrD).x - j;
    paramFloat = 1.0F - paramFloat;
    if ((paramFloat < Math.abs(f1 / this.wrS)) || (paramFloat < Math.abs(f2 / this.wrT)))
    {
      DragSortListView.d(this.wrD).y = (i + (int)(this.wrS * paramFloat));
      DragSortListView.d(this.wrD).x = (this.wrD.getPaddingLeft() + (int)(this.wrT * paramFloat));
      DragSortListView.f(this.wrD);
    }
  }
  
  public final void onStart()
  {
    this.wrQ = DragSortListView.g(this.wrD);
    this.wrR = DragSortListView.h(this.wrD);
    DragSortListView.a(this.wrD, 2);
    this.wrS = (DragSortListView.d(this.wrD).y - cKH());
    this.wrT = (DragSortListView.d(this.wrD).x - this.wrD.getPaddingLeft());
  }
  
  public final void onStop()
  {
    DragSortListView.k(this.wrD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.g
 * JD-Core Version:    0.7.0.1
 */