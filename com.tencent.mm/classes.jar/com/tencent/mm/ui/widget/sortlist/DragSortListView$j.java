package com.tencent.mm.ui.widget.sortlist;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class DragSortListView$j
{
  private SparseIntArray AMy;
  private ArrayList<Integer> AMz;
  private int yrn;
  
  private DragSortListView$j(DragSortListView paramDragSortListView)
  {
    AppMethodBeat.i(113051);
    this.AMy = new SparseIntArray(3);
    this.AMz = new ArrayList(3);
    this.yrn = 3;
    AppMethodBeat.o(113051);
  }
  
  public final void add(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113052);
    int i = this.AMy.get(paramInt1, -1);
    if (i != paramInt2)
    {
      if (i != -1) {
        break label87;
      }
      if (this.AMy.size() == this.yrn) {
        this.AMy.delete(((Integer)this.AMz.remove(0)).intValue());
      }
    }
    for (;;)
    {
      this.AMy.put(paramInt1, paramInt2);
      this.AMz.add(Integer.valueOf(paramInt1));
      AppMethodBeat.o(113052);
      return;
      label87:
      this.AMz.remove(Integer.valueOf(paramInt1));
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(113054);
    this.AMy.clear();
    this.AMz.clear();
    AppMethodBeat.o(113054);
  }
  
  public final int get(int paramInt)
  {
    AppMethodBeat.i(113053);
    paramInt = this.AMy.get(paramInt, -1);
    AppMethodBeat.o(113053);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.j
 * JD-Core Version:    0.7.0.1
 */