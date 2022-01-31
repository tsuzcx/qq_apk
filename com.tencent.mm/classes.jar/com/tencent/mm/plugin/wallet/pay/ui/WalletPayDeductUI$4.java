package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WalletPayDeductUI$4
  implements View.OnClickListener
{
  WalletPayDeductUI$4(WalletPayDeductUI paramWalletPayDeductUI, Orders.DeductShowInfo paramDeductShowInfo) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletPayDeductUI", "click link_type: %s", new Object[] { Integer.valueOf(this.qnj.qxv) });
    if (this.qnj.qxv == 1) {
      if (!bk.bl(this.qnj.qxy))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", this.qnj.qxy);
        paramView.putExtra("showShare", false);
        d.b(this.qng, "webview", ".ui.tools.WebViewUI", paramView);
      }
    }
    while (this.qnj.qxv != 2) {
      return;
    }
    paramView = new rc();
    paramView.caq.userName = this.qnj.qxw;
    paramView.caq.cas = bk.aM(this.qnj.qxx, "");
    paramView.caq.scene = 1097;
    paramView.caq.cat = 0;
    a.udP.m(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.4
 * JD-Core Version:    0.7.0.1
 */