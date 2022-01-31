package com.tencent.mm.plugin.order.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallOrderTransactionInfoUI$2
  implements MenuItem.OnMenuItemClickListener
{
  MallOrderTransactionInfoUI$2(MallOrderTransactionInfoUI paramMallOrderTransactionInfoUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(43878);
    this.pru.finish();
    AppMethodBeat.o(43878);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI.2
 * JD-Core Version:    0.7.0.1
 */