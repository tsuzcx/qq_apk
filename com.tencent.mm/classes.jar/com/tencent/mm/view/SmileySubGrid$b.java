package com.tencent.mm.view;

import android.view.View;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SmileySubGrid$b
  extends SmileySubGrid.d
  implements Runnable
{
  int Aph;
  View ws;
  
  private SmileySubGrid$b(SmileySubGrid paramSmileySubGrid)
  {
    super(paramSmileySubGrid, (byte)0);
  }
  
  public final void run()
  {
    AppMethodBeat.i(62956);
    ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "Click run");
    ListAdapter localListAdapter = this.ARL.getAdapter();
    int i = this.Aph;
    if ((localListAdapter != null) && (this.ARL.getCount() > 0) && (i != -1) && (i < localListAdapter.getCount()) && (dNo()))
    {
      ab.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", new Object[] { Integer.valueOf(i), Long.valueOf(localListAdapter.getItemId(i)) });
      this.ARL.performItemClick(this.ws, i, localListAdapter.getItemId(i));
    }
    AppMethodBeat.o(62956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.SmileySubGrid.b
 * JD-Core Version:    0.7.0.1
 */