package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class BankRemitDetailUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BankRemitDetailUI$1(BankRemitDetailUI paramBankRemitDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(44594);
    ab.i("MicroMsg.BankRemitDetailUI", "back press");
    this.qhE.finish();
    AppMethodBeat.o(44594);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI.1
 * JD-Core Version:    0.7.0.1
 */