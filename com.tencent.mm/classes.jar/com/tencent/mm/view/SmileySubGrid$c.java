package com.tencent.mm.view;

import android.view.WindowManager;
import com.tencent.mm.view.popview.AbstractPopView;

final class SmileySubGrid$c
  implements Runnable
{
  private SmileySubGrid$c(SmileySubGrid paramSmileySubGrid) {}
  
  public final void run()
  {
    if (!SmileySubGrid.c(this.wwJ))
    {
      SmileySubGrid.e(this.wwJ).addView(SmileySubGrid.d(this.wwJ), SmileySubGrid.d(this.wwJ).getWindowLayoutParams());
      SmileySubGrid.f(this.wwJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.SmileySubGrid.c
 * JD-Core Version:    0.7.0.1
 */