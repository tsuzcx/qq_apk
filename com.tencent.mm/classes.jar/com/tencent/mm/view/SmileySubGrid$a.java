package com.tencent.mm.view;

import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mm.sdk.platformtools.y;

final class SmileySubGrid$a
  extends SmileySubGrid.d
  implements Runnable
{
  private SmileySubGrid$a(SmileySubGrid paramSmileySubGrid)
  {
    super(paramSmileySubGrid, (byte)0);
  }
  
  public final void run()
  {
    y.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "LongPress run");
    int i = this.wwJ.acg;
    View localView = this.wwJ.getChildAt(i - this.wwJ.getFirstVisiblePosition());
    if (localView != null)
    {
      int j = this.wwJ.acg;
      long l = this.wwJ.getAdapter().getItemId(this.wwJ.acg);
      if (cIE())
      {
        y.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", new Object[] { Integer.valueOf(j), Long.valueOf(l) });
        SmileySubGrid.a(this.wwJ, localView, i);
        this.wwJ.alA = -1;
        this.wwJ.uTR = 5;
        this.wwJ.setScrollEnable(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.SmileySubGrid.a
 * JD-Core Version:    0.7.0.1
 */