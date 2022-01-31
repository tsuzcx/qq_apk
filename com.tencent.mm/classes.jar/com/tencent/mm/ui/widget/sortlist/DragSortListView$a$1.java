package com.tencent.mm.ui.widget.sortlist;

import android.database.DataSetObserver;

final class DragSortListView$a$1
  extends DataSetObserver
{
  DragSortListView$a$1(DragSortListView.a parama, DragSortListView paramDragSortListView) {}
  
  public final void onChanged()
  {
    this.wrF.notifyDataSetChanged();
  }
  
  public final void onInvalidated()
  {
    this.wrF.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.a.1
 * JD-Core Version:    0.7.0.1
 */