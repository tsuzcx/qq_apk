package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;

final class RechargeUI$11
  implements View.OnClickListener
{
  RechargeUI$11(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67225);
    paramView = new Intent();
    paramView.putExtra("rawUrl", RechargeUI.a(this.whA));
    d.b(this.whA, "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(67225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.11
 * JD-Core Version:    0.7.0.1
 */