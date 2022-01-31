package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletWXCreditDetailUI$2
  implements MenuItem.OnMenuItemClickListener
{
  WalletWXCreditDetailUI$2(WalletWXCreditDetailUI paramWalletWXCreditDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(48721);
    this.vIB.hideVKB();
    this.vIB.finish();
    AppMethodBeat.o(48721);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI.2
 * JD-Core Version:    0.7.0.1
 */