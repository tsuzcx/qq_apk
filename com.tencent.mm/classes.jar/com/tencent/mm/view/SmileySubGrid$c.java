package com.tencent.mm.view;

import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.popview.AbstractPopView;

final class SmileySubGrid$c
  implements Runnable
{
  private SmileySubGrid$c(SmileySubGrid paramSmileySubGrid) {}
  
  public final void run()
  {
    AppMethodBeat.i(62957);
    if (!SmileySubGrid.c(this.ARL))
    {
      SmileySubGrid.e(this.ARL).addView(SmileySubGrid.d(this.ARL), SmileySubGrid.d(this.ARL).getWindowLayoutParams());
      SmileySubGrid.f(this.ARL);
    }
    AppMethodBeat.o(62957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.SmileySubGrid.c
 * JD-Core Version:    0.7.0.1
 */