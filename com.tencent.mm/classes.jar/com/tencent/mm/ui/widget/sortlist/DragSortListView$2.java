package com.tencent.mm.ui.widget.sortlist;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DragSortListView$2
  extends DataSetObserver
{
  DragSortListView$2(DragSortListView paramDragSortListView) {}
  
  private void cancel()
  {
    AppMethodBeat.i(113025);
    if (DragSortListView.b(this.AMh) == 4) {
      this.AMh.dPC();
    }
    AppMethodBeat.o(113025);
  }
  
  public final void onChanged()
  {
    AppMethodBeat.i(113026);
    cancel();
    AppMethodBeat.o(113026);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(113027);
    cancel();
    AppMethodBeat.o(113027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.2
 * JD-Core Version:    0.7.0.1
 */