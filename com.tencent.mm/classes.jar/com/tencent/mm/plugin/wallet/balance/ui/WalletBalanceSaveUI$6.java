package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.ui.a;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.j;

final class WalletBalanceSaveUI$6
  implements u.i
{
  WalletBalanceSaveUI$6(WalletBalanceSaveUI paramWalletBalanceSaveUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(316350);
    if (WalletBalanceSaveUI.j(this.Vdh) == null)
    {
      AppMethodBeat.o(316350);
      return;
    }
    WalletBalanceSaveUI.j(this.Vdh).xcO.cyW();
    this.Vdh.Vbu = null;
    WalletBalanceSaveUI.k(this.Vdh);
    AppMethodBeat.o(316350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.6
 * JD-Core Version:    0.7.0.1
 */