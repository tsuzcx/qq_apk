package com.tencent.mm.ui.base;

import android.database.DataSetObserver;

final class HorizontalListView$1
  extends DataSetObserver
{
  HorizontalListView$1(HorizontalListView paramHorizontalListView) {}
  
  public final void onChanged()
  {
    synchronized (this.uTr)
    {
      HorizontalListView.a(this.uTr);
      this.uTr.invalidate();
      this.uTr.requestLayout();
      return;
    }
  }
  
  public final void onInvalidated()
  {
    HorizontalListView.b(this.uTr);
    this.uTr.invalidate();
    this.uTr.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListView.1
 * JD-Core Version:    0.7.0.1
 */