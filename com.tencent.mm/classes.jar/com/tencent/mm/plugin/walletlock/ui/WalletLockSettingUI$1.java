package com.tencent.mm.plugin.walletlock.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLockSettingUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletLockSettingUI$1(WalletLockSettingUI paramWalletLockSettingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(51744);
    if (WalletLockSettingUI.a(this.uGz)) {
      WalletLockSettingUI.a(this.uGz, "user cancel setting wallet lock");
    }
    for (;;)
    {
      AppMethodBeat.o(51744);
      return false;
      this.uGz.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI.1
 * JD-Core Version:    0.7.0.1
 */