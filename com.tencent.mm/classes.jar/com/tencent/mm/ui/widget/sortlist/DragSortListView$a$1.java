package com.tencent.mm.ui.widget.sortlist;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DragSortListView$a$1
  extends DataSetObserver
{
  DragSortListView$a$1(DragSortListView.a parama, DragSortListView paramDragSortListView) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(113028);
    this.AMj.notifyDataSetChanged();
    AppMethodBeat.o(113028);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(113029);
    this.AMj.notifyDataSetInvalidated();
    AppMethodBeat.o(113029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.a.1
 * JD-Core Version:    0.7.0.1
 */