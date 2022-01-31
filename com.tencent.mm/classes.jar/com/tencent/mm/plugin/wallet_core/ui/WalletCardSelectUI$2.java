package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletCardSelectUI$2
  implements MenuItem.OnMenuItemClickListener
{
  WalletCardSelectUI$2(WalletCardSelectUI paramWalletCardSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(47297);
    this.upv.finish();
    AppMethodBeat.o(47297);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI.2
 * JD-Core Version:    0.7.0.1
 */