package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BankRemitBaseUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BankRemitBaseUI$1(BankRemitBaseUI paramBankRemitBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(44587);
    if (BankRemitBaseUI.a(this.qhp))
    {
      this.qhp.hideVKB();
      this.qhp.showDialog(1000);
    }
    for (;;)
    {
      AppMethodBeat.o(44587);
      return true;
      this.qhp.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI.1
 * JD-Core Version:    0.7.0.1
 */