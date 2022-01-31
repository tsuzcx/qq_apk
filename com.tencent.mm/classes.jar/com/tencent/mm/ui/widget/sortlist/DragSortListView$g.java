package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DragSortListView$g
  extends DragSortListView.m
{
  private int AMu;
  private int AMv;
  private float AMw;
  private float AMx;
  
  private DragSortListView$g(DragSortListView paramDragSortListView, int paramInt)
  {
    super(paramDragSortListView, paramInt, (byte)0);
  }
  
  private int dPO()
  {
    AppMethodBeat.i(113048);
    int i = this.AMh.getFirstVisiblePosition();
    int j = (DragSortListView.i(this.AMh) + this.AMh.getDividerHeight()) / 2;
    View localView = this.AMh.getChildAt(this.AMu - i);
    i = -1;
    if (localView != null) {
      if (this.AMu == this.AMv) {
        i = localView.getTop();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113048);
      return i;
      if (this.AMu < this.AMv)
      {
        i = localView.getTop() - j;
      }
      else
      {
        i = localView.getBottom() + j - DragSortListView.j(this.AMh);
        continue;
        this.qM = true;
      }
    }
  }
  
  public final void bB(float paramFloat)
  {
    AppMethodBeat.i(113049);
    int i = dPO();
    int j = this.AMh.getPaddingLeft();
    float f1 = DragSortListView.d(this.AMh).y - i;
    float f2 = DragSortListView.d(this.AMh).x - j;
    paramFloat = 1.0F - paramFloat;
    if ((paramFloat < Math.abs(f1 / this.AMw)) || (paramFloat < Math.abs(f2 / this.AMx)))
    {
      DragSortListView.d(this.AMh).y = (i + (int)(this.AMw * paramFloat));
      DragSortListView.d(this.AMh).x = (this.AMh.getPaddingLeft() + (int)(this.AMx * paramFloat));
      DragSortListView.f(this.AMh);
    }
    AppMethodBeat.o(113049);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(113047);
    this.AMu = DragSortListView.g(this.AMh);
    this.AMv = DragSortListView.h(this.AMh);
    DragSortListView.a(this.AMh, 2);
    this.AMw = (DragSortListView.d(this.AMh).y - dPO());
    this.AMx = (DragSortListView.d(this.AMh).x - this.AMh.getPaddingLeft());
    AppMethodBeat.o(113047);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(113050);
    DragSortListView.k(this.AMh);
    AppMethodBeat.o(113050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.g
 * JD-Core Version:    0.7.0.1
 */