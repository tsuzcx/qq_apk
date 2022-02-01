package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;

final class RechargeUI$18
  implements MenuItem.OnMenuItemClickListener
{
  RechargeUI$18(RechargeUI paramRechargeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(67232);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("rawUrl", RechargeUI.j(this.BFe));
    c.b(this.BFe, "webview", ".ui.tools.WebViewUI", paramMenuItem);
    AppMethodBeat.o(67232);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.18
 * JD-Core Version:    0.7.0.1
 */