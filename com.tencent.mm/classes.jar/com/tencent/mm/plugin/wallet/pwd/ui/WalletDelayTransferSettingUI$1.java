package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.e;

final class WalletDelayTransferSettingUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletDelayTransferSettingUI$1(WalletDelayTransferSettingUI paramWalletDelayTransferSettingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(46239);
    e.m(this.tYN.getContext(), WalletDelayTransferSettingUI.a(this.tYN), false);
    AppMethodBeat.o(46239);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferSettingUI.1
 * JD-Core Version:    0.7.0.1
 */