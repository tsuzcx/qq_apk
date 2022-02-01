package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletSetPasswordUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletSetPasswordUI$1(WalletSetPasswordUI paramWalletSetPasswordUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(301282);
    if (this.VTd.needConfirmFinish())
    {
      this.VTd.hideVKB();
      this.VTd.showDialog(1000);
    }
    for (;;)
    {
      AppMethodBeat.o(301282);
      return false;
      this.VTd.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI.1
 * JD-Core Version:    0.7.0.1
 */