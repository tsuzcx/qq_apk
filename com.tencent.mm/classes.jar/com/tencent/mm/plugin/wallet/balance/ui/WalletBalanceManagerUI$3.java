package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.h;
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
    if (!bt.isNullOrNil(this.zHn.zHd.AbY))
    {
      ad.i("MicroMsg.WalletBalanceManagerUI", "carson: entry_url: %s", new Object[] { this.zHn.zHd.AbY });
      paramMenuItem.putExtra("rawUrl", this.zHn.zHd.AbY);
    }
    for (;;)
    {
      paramMenuItem.putExtra("showShare", false);
      paramMenuItem.putExtra("geta8key_username", u.aqG());
      paramMenuItem.putExtra("KPublisherId", "pay_blance_list");
      paramMenuItem.putExtra("geta8key_scene", 33);
      paramMenuItem.putExtra(e.m.FIC, true);
      e.X(this.zHn.getContext(), paramMenuItem);
      e.aby(16);
      h.vKh.f(16503, new Object[] { Integer.valueOf(1), "balanceBill" });
      AppMethodBeat.o(68648);
      return true;
      paramMenuItem.putExtra("rawUrl", this.zHn.zHd.AbX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.3
 * JD-Core Version:    0.7.0.1
 */