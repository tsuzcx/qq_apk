package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;

final class RechargeUI$17
  implements MenuItem.OnMenuItemClickListener
{
  RechargeUI$17(RechargeUI paramRechargeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(67232);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("rawUrl", RechargeUI.j(this.NyL));
    c.b(this.NyL, "webview", ".ui.tools.WebViewUI", paramMenuItem);
    AppMethodBeat.o(67232);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.17
 * JD-Core Version:    0.7.0.1
 */