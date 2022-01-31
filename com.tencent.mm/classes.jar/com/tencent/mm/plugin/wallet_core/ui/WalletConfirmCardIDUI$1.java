package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.c.x;

final class WalletConfirmCardIDUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletConfirmCardIDUI$1(WalletConfirmCardIDUI paramWalletConfirmCardIDUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(47365);
    x.dSs();
    this.uqm.finish();
    AppMethodBeat.o(47365);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI.1
 * JD-Core Version:    0.7.0.1
 */