package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletSelectBankcardModeUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletSelectBankcardModeUI$1(WalletSelectBankcardModeUI paramWalletSelectBankcardModeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(45489);
    this.tOZ.setResult(0);
    this.tOZ.finish();
    AppMethodBeat.o(45489);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI.1
 * JD-Core Version:    0.7.0.1
 */