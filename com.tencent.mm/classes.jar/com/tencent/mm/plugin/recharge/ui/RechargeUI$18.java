package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.br.d;

final class RechargeUI$18
  implements MenuItem.OnMenuItemClickListener
{
  RechargeUI$18(RechargeUI paramRechargeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("rawUrl", RechargeUI.j(this.nrE));
    d.b(this.nrE, "webview", ".ui.tools.WebViewUI", paramMenuItem);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.18
 * JD-Core Version:    0.7.0.1
 */