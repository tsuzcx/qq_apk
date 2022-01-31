package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.d;
import java.util.ArrayList;
import java.util.List;

final class WalletBalanceSaveUI$5
  implements n.d
{
  WalletBalanceSaveUI$5(WalletBalanceSaveUI paramWalletBalanceSaveUI, d paramd, List paramList) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(45475);
    if (this.tOT != null)
    {
      this.tOT.cre();
      if (paramInt < this.nIy.size())
      {
        this.tOS.tNH = ((Bankcard)WalletBalanceSaveUI.e(this.tOS).get(paramInt));
        WalletBalanceSaveUI.f(this.tOS);
        AppMethodBeat.o(45475);
        return;
      }
      this.tOS.tNH = null;
      WalletBalanceSaveUI.f(this.tOS);
    }
    AppMethodBeat.o(45475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.5
 * JD-Core Version:    0.7.0.1
 */