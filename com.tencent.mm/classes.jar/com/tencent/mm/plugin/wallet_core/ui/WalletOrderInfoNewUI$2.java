package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WalletOrderInfoNewUI$2
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$2(WalletOrderInfoNewUI paramWalletOrderInfoNewUI, Orders.ShowInfo paramShowInfo) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletOrderInfoNewUI", "onClick jump tinyApp, linkWeApp:%s, linkAddr:%s", new Object[] { this.qEs.qxU, this.qEs.qxV });
    paramView = new rc();
    paramView.caq.userName = this.qEs.qxU;
    paramView.caq.cas = bk.aM(this.qEs.qxV, "");
    paramView.caq.scene = 1060;
    paramView.caq.bFv = WalletOrderInfoNewUI.l(this.qEr);
    paramView.caq.cat = 0;
    paramView.caq.context = this.qEr;
    a.udP.m(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.2
 * JD-Core Version:    0.7.0.1
 */