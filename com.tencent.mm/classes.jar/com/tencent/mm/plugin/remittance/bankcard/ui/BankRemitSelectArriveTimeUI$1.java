package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BankRemitSelectArriveTimeUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BankRemitSelectArriveTimeUI$1(BankRemitSelectArriveTimeUI paramBankRemitSelectArriveTimeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(44659);
    this.qir.finish();
    AppMethodBeat.o(44659);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectArriveTimeUI.1
 * JD-Core Version:    0.7.0.1
 */