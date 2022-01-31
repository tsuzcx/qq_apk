package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;

final class WalletSelectBankcardUI$1
  implements h.a
{
  WalletSelectBankcardUI$1(WalletSelectBankcardUI paramWalletSelectBankcardUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletSelectBankcardUI", "hy: user clicked the phone.go to dial");
    e.bG(this.qGy, this.qGy.getString(a.i.wallet_bankcard_detail_bankphone_number));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.1
 * JD-Core Version:    0.7.0.1
 */