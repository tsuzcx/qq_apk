package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceManagerUI$3
  implements MenuItem.OnMenuItemClickListener
{
  WalletBalanceManagerUI$3(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68648);
    paramMenuItem = new Intent();
    if (!bt.isNullOrNil(this.CzL.CzB.CUH))
    {
      ad.i("MicroMsg.WalletBalanceManagerUI", "carson: entry_url: %s", new Object[] { this.CzL.CzB.CUH });
      paramMenuItem.putExtra("rawUrl", this.CzL.CzB.CUH);
    }
    for (;;)
    {
      paramMenuItem.putExtra("showShare", false);
      paramMenuItem.putExtra("geta8key_username", u.aAm());
      paramMenuItem.putExtra("KPublisherId", "pay_blance_list");
      paramMenuItem.putExtra("geta8key_scene", 33);
      paramMenuItem.putExtra(e.m.IVa, true);
      e.an(this.CzL.getContext(), paramMenuItem);
      e.agr(16);
      g.yhR.f(16503, new Object[] { Integer.valueOf(1), "balanceBill" });
      AppMethodBeat.o(68648);
      return true;
      paramMenuItem.putExtra("rawUrl", this.CzL.CzB.CUG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.3
 * JD-Core Version:    0.7.0.1
 */