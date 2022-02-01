package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletLockCheckPwdUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletLockCheckPwdUI$1(WalletLockCheckPwdUI paramWalletLockCheckPwdUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(69713);
    Log.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
    WalletLockCheckPwdUI.a(this.HKh);
    AppMethodBeat.o(69713);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI.1
 * JD-Core Version:    0.7.0.1
 */