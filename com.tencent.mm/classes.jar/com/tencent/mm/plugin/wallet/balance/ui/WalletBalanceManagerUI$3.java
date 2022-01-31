package com.tencent.mm.plugin.wallet.balance.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.utils.e.8;
import com.tencent.mm.plugin.wallet_core.utils.e.9;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.ui.widget.b.d;
import java.util.LinkedList;

final class WalletBalanceManagerUI$3
  implements MenuItem.OnMenuItemClickListener
{
  WalletBalanceManagerUI$3(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(45429);
    paramMenuItem = new d(this.tOJ.getContext(), 1, false);
    AppCompatActivity localAppCompatActivity = this.tOJ.getContext();
    ba localba = WalletBalanceManagerUI.e(this.tOJ);
    WalletBalanceManagerUI.3.1 local1 = new WalletBalanceManagerUI.3.1(this);
    if ((localba == null) || (localba.wnb == null) || (localba.wnb.isEmpty())) {}
    for (;;)
    {
      paramMenuItem.crd();
      h.qsU.e(16503, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(45429);
      return false;
      paramMenuItem.sao = new e.8(localba, localAppCompatActivity);
      paramMenuItem.sap = new e.9(localba, localAppCompatActivity, local1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.3
 * JD-Core Version:    0.7.0.1
 */