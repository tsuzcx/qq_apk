package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.sdk.platformtools.bk;

final class RechargeUI$16
  implements View.OnClickListener
{
  RechargeUI$16(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(RechargeUI.h(this.nrE).qzx.qzG))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", RechargeUI.h(this.nrE).qzx.qzG);
      paramView.putExtra("geta8key_username", q.Gj());
      d.b(this.nrE, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.16
 * JD-Core Version:    0.7.0.1
 */