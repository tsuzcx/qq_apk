package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;

final class RechargeUI$11
  implements View.OnClickListener
{
  RechargeUI$11(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("rawUrl", RechargeUI.a(this.nrE));
    d.b(this.nrE, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.11
 * JD-Core Version:    0.7.0.1
 */