package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.c;

final class WalletWXCreditChangeAmountResultUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletWXCreditChangeAmountResultUI$1(WalletWXCreditChangeAmountResultUI paramWalletWXCreditChangeAmountResultUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(48685);
    this.vIb.getProcess().a(this.vIb.getContext(), 0, this.vIb.getInput());
    AppMethodBeat.o(48685);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI.1
 * JD-Core Version:    0.7.0.1
 */