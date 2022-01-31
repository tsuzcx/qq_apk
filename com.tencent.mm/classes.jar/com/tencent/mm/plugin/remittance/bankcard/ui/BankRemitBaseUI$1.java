package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class BankRemitBaseUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BankRemitBaseUI$1(BankRemitBaseUI paramBankRemitBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (BankRemitBaseUI.a(this.nwn))
    {
      this.nwn.XM();
      this.nwn.showDialog(1000);
    }
    for (;;)
    {
      return true;
      this.nwn.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI.1
 * JD-Core Version:    0.7.0.1
 */