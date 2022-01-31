package com.tencent.mm.ui.widget.sortlist;

import android.database.DataSetObserver;

final class DragSortListView$2
  extends DataSetObserver
{
  DragSortListView$2(DragSortListView paramDragSortListView) {}
  
  private void cancel()
  {
    if (DragSortListView.b(this.wrD) == 4) {
      this.wrD.cKw();
    }
  }
  
  public final void onChanged()
  {
    cancel();
  }
  
  public final void onInvalidated()
  {
    cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.2
 * JD-Core Version:    0.7.0.1
 */