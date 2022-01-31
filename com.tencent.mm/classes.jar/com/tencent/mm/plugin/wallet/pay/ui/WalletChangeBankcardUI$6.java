package com.tencent.mm.plugin.wallet.pay.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletChangeBankcardUI$6
  implements View.OnClickListener
{
  WalletChangeBankcardUI$6(WalletChangeBankcardUI paramWalletChangeBankcardUI) {}
  
  public final void onClick(View paramView)
  {
    if (this.qmD.qgo != null) {
      this.qmD.qgo.dismiss();
    }
    this.qmD.ku(false);
    this.qmD.qmy.e(this.qmD.qgr, true);
    this.qmD.qmA = ((FavorPayInfo)paramView.getTag());
    if (this.qmD.qmA != null) {
      this.qmD.qmA.qvG = "";
    }
    this.qmD.BX.putParcelable("key_favor_pay_info", this.qmD.qmA);
    this.qmD.aZ();
    this.qmD.vN(0);
    this.qmD.qmC = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.6
 * JD-Core Version:    0.7.0.1
 */