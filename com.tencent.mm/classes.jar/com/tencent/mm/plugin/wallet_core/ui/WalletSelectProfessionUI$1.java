package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletSelectProfessionUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletSelectProfessionUI$1(WalletSelectProfessionUI paramWalletSelectProfessionUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(47661);
    this.utJ.setResult(0);
    this.utJ.finish();
    AppMethodBeat.o(47661);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI.1
 * JD-Core Version:    0.7.0.1
 */