package com.tencent.mm.ui.widget.sortlist;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class DragSortListView$j
{
  private SparseIntArray Ywe;
  private ArrayList<Integer> Ywf;
  private int mMaxSize;
  
  private DragSortListView$j(DragSortListView paramDragSortListView)
  {
    AppMethodBeat.i(159781);
    this.Ywe = new SparseIntArray(3);
    this.Ywf = new ArrayList(3);
    this.mMaxSize = 3;
    AppMethodBeat.o(159781);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(159784);
    this.Ywe.clear();
    this.Ywf.clear();
    AppMethodBeat.o(159784);
  }
  
  public final int get(int paramInt)
  {
    AppMethodBeat.i(159783);
    paramInt = this.Ywe.get(paramInt, -1);
    AppMethodBeat.o(159783);
    return paramInt;
  }
  
  public final void nf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159782);
    int i = this.Ywe.get(paramInt1, -1);
    if (i != paramInt2)
    {
      if (i != -1) {
        break label87;
      }
      if (this.Ywe.size() == this.mMaxSize) {
        this.Ywe.delete(((Integer)this.Ywf.remove(0)).intValue());
      }
    }
    for (;;)
    {
      this.Ywe.put(paramInt1, paramInt2);
      this.Ywf.add(Integer.valueOf(paramInt1));
      AppMethodBeat.o(159782);
      return;
      label87:
      this.Ywf.remove(Integer.valueOf(paramInt1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.j
 * JD-Core Version:    0.7.0.1
 */