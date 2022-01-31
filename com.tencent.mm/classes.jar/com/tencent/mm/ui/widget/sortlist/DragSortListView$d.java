package com.tencent.mm.ui.widget.sortlist;

import android.os.SystemClock;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DragSortListView$d
  implements Runnable
{
  boolean AEZ = false;
  private boolean AMk;
  private long AMl;
  private long AMm;
  private float AMn;
  private long AMo;
  int AMp;
  private float AMq;
  private int dy;
  
  DragSortListView$d(DragSortListView paramDragSortListView) {}
  
  public final void RB(int paramInt)
  {
    AppMethodBeat.i(113041);
    if (!this.AEZ)
    {
      this.AMk = false;
      this.AEZ = true;
      this.AMo = SystemClock.uptimeMillis();
      this.AMl = this.AMo;
      this.AMp = paramInt;
      this.AMh.post(this);
    }
    AppMethodBeat.o(113041);
  }
  
  public final void dPN()
  {
    AppMethodBeat.i(113042);
    this.AMh.removeCallbacks(this);
    this.AEZ = false;
    AppMethodBeat.o(113042);
  }
  
  public final void run()
  {
    AppMethodBeat.i(113043);
    if (this.AMk)
    {
      this.AEZ = false;
      AppMethodBeat.o(113043);
      return;
    }
    int j = this.AMh.getFirstVisiblePosition();
    int i = this.AMh.getLastVisiblePosition();
    int m = this.AMh.getCount();
    int k = this.AMh.getPaddingTop();
    int n = this.AMh.getHeight() - k - this.AMh.getPaddingBottom();
    int i1 = Math.min(DragSortListView.e(this.AMh), DragSortListView.r(this.AMh) + DragSortListView.c(this.AMh));
    int i2 = Math.max(DragSortListView.e(this.AMh), DragSortListView.r(this.AMh) - DragSortListView.c(this.AMh));
    View localView;
    if (this.AMp == 0)
    {
      localView = this.AMh.getChildAt(0);
      if (localView == null)
      {
        this.AEZ = false;
        AppMethodBeat.o(113043);
        return;
      }
      if ((j == 0) && (localView.getTop() == k))
      {
        this.AEZ = false;
        AppMethodBeat.o(113043);
        return;
      }
      this.AMq = DragSortListView.u(this.AMh).bA((DragSortListView.s(this.AMh) - i2) / DragSortListView.t(this.AMh));
      this.AMm = SystemClock.uptimeMillis();
      this.AMn = ((float)(this.AMm - this.AMl));
      this.dy = Math.round(this.AMq * this.AMn);
      if (this.dy < 0) {
        break label496;
      }
      this.dy = Math.min(n, this.dy);
      i = j;
    }
    for (;;)
    {
      localView = this.AMh.getChildAt(i - j);
      m = localView.getTop() + this.dy;
      j = m;
      if (i == 0)
      {
        j = m;
        if (m > k) {
          j = k;
        }
      }
      DragSortListView.a(this.AMh, true);
      this.AMh.setSelectionFromTop(i, j - k);
      this.AMh.layoutChildren();
      this.AMh.invalidate();
      DragSortListView.a(this.AMh, false);
      DragSortListView.c(this.AMh, i, localView);
      this.AMl = this.AMm;
      this.AMh.post(this);
      AppMethodBeat.o(113043);
      return;
      localView = this.AMh.getChildAt(i - j);
      if (localView == null)
      {
        this.AEZ = false;
        AppMethodBeat.o(113043);
        return;
      }
      if ((i == m - 1) && (localView.getBottom() <= n + k))
      {
        this.AEZ = false;
        AppMethodBeat.o(113043);
        return;
      }
      this.AMq = (-DragSortListView.u(this.AMh).bA((i1 - DragSortListView.v(this.AMh)) / DragSortListView.w(this.AMh)));
      break;
      label496:
      this.dy = Math.max(-n, this.dy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.d
 * JD-Core Version:    0.7.0.1
 */