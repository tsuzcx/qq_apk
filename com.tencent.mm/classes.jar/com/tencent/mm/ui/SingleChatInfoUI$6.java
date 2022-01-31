package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SingleChatInfoUI$6
  implements MenuItem.OnMenuItemClickListener
{
  SingleChatInfoUI$6(SingleChatInfoUI paramSingleChatInfoUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(29873);
    this.zfe.finish();
    AppMethodBeat.o(29873);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI.6
 * JD-Core Version:    0.7.0.1
 */