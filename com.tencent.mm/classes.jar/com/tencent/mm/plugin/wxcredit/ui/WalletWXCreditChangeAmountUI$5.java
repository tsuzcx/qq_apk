package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletWXCreditChangeAmountUI$5
  implements MenuItem.OnMenuItemClickListener
{
  WalletWXCreditChangeAmountUI$5(WalletWXCreditChangeAmountUI paramWalletWXCreditChangeAmountUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(48693);
    this.vIv.hideVKB();
    this.vIv.showDialog(3);
    AppMethodBeat.o(48693);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.5
 * JD-Core Version:    0.7.0.1
 */