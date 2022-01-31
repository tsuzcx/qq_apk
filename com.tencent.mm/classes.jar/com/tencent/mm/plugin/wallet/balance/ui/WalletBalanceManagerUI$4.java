package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceManagerUI$4
  implements MenuItem.OnMenuItemClickListener
{
  WalletBalanceManagerUI$4(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    if (!bk.bl(this.qhk.qhj.qtC))
    {
      y.i("MicroMsg.WalletBalanceManagerUI", "carson: entry_url: %s", new Object[] { this.qhk.qhj.qtC });
      paramMenuItem.putExtra("rawUrl", this.qhk.qhj.qtC);
    }
    for (;;)
    {
      paramMenuItem.putExtra("showShare", false);
      paramMenuItem.putExtra("geta8key_username", q.Gj());
      paramMenuItem.putExtra("KPublisherId", "pay_blance_list");
      paramMenuItem.putExtra("geta8key_scene", 33);
      d.b(this.qhk, "webview", ".ui.tools.WebViewUI", paramMenuItem);
      e.Jc(16);
      return true;
      paramMenuItem.putExtra("rawUrl", this.qhk.qhj.qtB);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.4
 * JD-Core Version:    0.7.0.1
 */