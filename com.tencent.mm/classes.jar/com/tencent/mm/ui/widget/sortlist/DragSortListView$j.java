package com.tencent.mm.ui.widget.sortlist;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class DragSortListView$j
{
  private SparseIntArray HNo;
  private ArrayList<Integer> HNp;
  private int xZb;
  
  private DragSortListView$j(DragSortListView paramDragSortListView)
  {
    AppMethodBeat.i(159781);
    this.HNo = new SparseIntArray(3);
    this.HNp = new ArrayList(3);
    this.xZb = 3;
    AppMethodBeat.o(159781);
  }
  
  public final void add(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159782);
    int i = this.HNo.get(paramInt1, -1);
    if (i != paramInt2)
    {
      if (i != -1) {
        break label87;
      }
      if (this.HNo.size() == this.xZb) {
        this.HNo.delete(((Integer)this.HNp.remove(0)).intValue());
      }
    }
    for (;;)
    {
      this.HNo.put(paramInt1, paramInt2);
      this.HNp.add(Integer.valueOf(paramInt1));
      AppMethodBeat.o(159782);
      return;
      label87:
      this.HNp.remove(Integer.valueOf(paramInt1));
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(159784);
    this.HNo.clear();
    this.HNp.clear();
    AppMethodBeat.o(159784);
  }
  
  public final int get(int paramInt)
  {
    AppMethodBeat.i(159783);
    paramInt = this.HNo.get(paramInt, -1);
    AppMethodBeat.o(159783);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.j
 * JD-Core Version:    0.7.0.1
 */