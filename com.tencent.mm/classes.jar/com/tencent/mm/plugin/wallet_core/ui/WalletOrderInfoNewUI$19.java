package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.sdk.platformtools.y;

final class WalletOrderInfoNewUI$19
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$19(WalletOrderInfoNewUI paramWalletOrderInfoNewUI, Orders.ShowInfo paramShowInfo) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletOrderInfoNewUI", "onClick showInfo, jump url: %s", new Object[] { this.qEs.qxW });
    this.qEr.QK(this.qEs.qxW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.19
 * JD-Core Version:    0.7.0.1
 */