package com.tencent.mm.ui.widget.sortlist;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class DragSortListView$j
{
  private SparseIntArray LBJ;
  private ArrayList<Integer> LBK;
  private int zsh;
  
  private DragSortListView$j(DragSortListView paramDragSortListView)
  {
    AppMethodBeat.i(159781);
    this.LBJ = new SparseIntArray(3);
    this.LBK = new ArrayList(3);
    this.zsh = 3;
    AppMethodBeat.o(159781);
  }
  
  public final void add(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159782);
    int i = this.LBJ.get(paramInt1, -1);
    if (i != paramInt2)
    {
      if (i != -1) {
        break label87;
      }
      if (this.LBJ.size() == this.zsh) {
        this.LBJ.delete(((Integer)this.LBK.remove(0)).intValue());
      }
    }
    for (;;)
    {
      this.LBJ.put(paramInt1, paramInt2);
      this.LBK.add(Integer.valueOf(paramInt1));
      AppMethodBeat.o(159782);
      return;
      label87:
      this.LBK.remove(Integer.valueOf(paramInt1));
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(159784);
    this.LBJ.clear();
    this.LBK.clear();
    AppMethodBeat.o(159784);
  }
  
  public final int get(int paramInt)
  {
    AppMethodBeat.i(159783);
    paramInt = this.LBJ.get(paramInt, -1);
    AppMethodBeat.o(159783);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.j
 * JD-Core Version:    0.7.0.1
 */