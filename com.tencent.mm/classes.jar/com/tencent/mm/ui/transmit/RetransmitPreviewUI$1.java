package com.tencent.mm.ui.transmit;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RetransmitPreviewUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RetransmitPreviewUI$1(RetransmitPreviewUI paramRetransmitPreviewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35120);
    this.AzP.finish();
    AppMethodBeat.o(35120);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.RetransmitPreviewUI.1
 * JD-Core Version:    0.7.0.1
 */