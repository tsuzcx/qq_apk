package com.tencent.mm.view;

import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mm.sdk.platformtools.y;

final class SmileySubGrid$b
  extends SmileySubGrid.d
  implements Runnable
{
  int vWZ;
  View wd;
  
  private SmileySubGrid$b(SmileySubGrid paramSmileySubGrid)
  {
    super(paramSmileySubGrid, (byte)0);
  }
  
  public final void run()
  {
    y.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "Click run");
    ListAdapter localListAdapter = this.wwJ.getAdapter();
    int i = this.vWZ;
    if ((localListAdapter != null) && (this.wwJ.getCount() > 0) && (i != -1) && (i < localListAdapter.getCount()) && (cIE()))
    {
      y.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", new Object[] { Integer.valueOf(i), Long.valueOf(localListAdapter.getItemId(i)) });
      this.wwJ.performItemClick(this.wd, i, localListAdapter.getItemId(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.SmileySubGrid.b
 * JD-Core Version:    0.7.0.1
 */