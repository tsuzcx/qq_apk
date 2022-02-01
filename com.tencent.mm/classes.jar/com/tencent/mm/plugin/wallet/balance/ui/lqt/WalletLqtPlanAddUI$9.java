package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.ui.a;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.j;

final class WalletLqtPlanAddUI$9
  implements u.i
{
  WalletLqtPlanAddUI$9(WalletLqtPlanAddUI paramWalletLqtPlanAddUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(316414);
    if (WalletLqtPlanAddUI.p(this.Vge) == null)
    {
      AppMethodBeat.o(316414);
      return;
    }
    WalletLqtPlanAddUI.p(this.Vge).xcO.cyW();
    WalletLqtPlanAddUI.q(this.Vge);
    AppMethodBeat.o(316414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.9
 * JD-Core Version:    0.7.0.1
 */