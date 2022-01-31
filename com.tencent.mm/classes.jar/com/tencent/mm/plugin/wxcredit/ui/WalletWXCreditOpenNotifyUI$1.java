package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletWXCreditOpenNotifyUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletWXCreditOpenNotifyUI$1(WalletWXCreditOpenNotifyUI paramWalletWXCreditOpenNotifyUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(48740);
    this.vIH.setResult(-1);
    this.vIH.finish();
    AppMethodBeat.o(48740);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenNotifyUI.1
 * JD-Core Version:    0.7.0.1
 */