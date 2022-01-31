package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ConfirmScanBankCardResultUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ConfirmScanBankCardResultUI$2(ConfirmScanBankCardResultUI paramConfirmScanBankCardResultUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(81011);
    this.qwV.finish();
    AppMethodBeat.o(81011);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI.2
 * JD-Core Version:    0.7.0.1
 */