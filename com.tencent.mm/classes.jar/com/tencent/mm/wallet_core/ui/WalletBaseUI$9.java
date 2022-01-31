package com.tencent.mm.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBaseUI$9
  implements MenuItem.OnMenuItemClickListener
{
  WalletBaseUI$9(WalletBaseUI paramWalletBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(142668);
    this.AYz.mPayResultType = 4;
    if (this.AYz.needConfirmFinish())
    {
      this.AYz.hideVKB();
      this.AYz.showDialog(1000);
    }
    for (;;)
    {
      AppMethodBeat.o(142668);
      return true;
      this.AYz.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.9
 * JD-Core Version:    0.7.0.1
 */