package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceManagerUI$4
  implements MenuItem.OnMenuItemClickListener
{
  WalletBalanceManagerUI$4(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(142281);
    paramMenuItem = new Intent();
    if (!bo.isNullOrNil(this.tOJ.tOD.ufQ))
    {
      ab.i("MicroMsg.WalletBalanceManagerUI", "carson: entry_url: %s", new Object[] { this.tOJ.tOD.ufQ });
      paramMenuItem.putExtra("rawUrl", this.tOJ.tOD.ufQ);
    }
    for (;;)
    {
      paramMenuItem.putExtra("showShare", false);
      paramMenuItem.putExtra("geta8key_username", r.Zn());
      paramMenuItem.putExtra("KPublisherId", "pay_blance_list");
      paramMenuItem.putExtra("geta8key_scene", 33);
      d.b(this.tOJ, "webview", ".ui.tools.WebViewUI", paramMenuItem);
      e.RX(16);
      h.qsU.e(16503, new Object[] { Integer.valueOf(1), "balanceBill" });
      AppMethodBeat.o(142281);
      return true;
      paramMenuItem.putExtra("rawUrl", this.tOJ.tOD.ufP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.4
 * JD-Core Version:    0.7.0.1
 */