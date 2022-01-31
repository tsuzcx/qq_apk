package com.tencent.mm.plugin.wallet.pay.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.o.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletChangeBankcardUI$5
  implements o.c
{
  WalletChangeBankcardUI$5(WalletChangeBankcardUI paramWalletChangeBankcardUI) {}
  
  public final void a(String paramString, FavorPayInfo paramFavorPayInfo, boolean paramBoolean)
  {
    this.qmD.qmA = paramFavorPayInfo;
    this.qmD.BX.putParcelable("key_favor_pay_info", this.qmD.qmA);
    if ((this.qmD.qmA != null) && (paramBoolean))
    {
      if (this.qmD.qmA != null)
      {
        this.qmD.ku(true);
        this.qmD.qmy.e(this.qmD.qgr, false);
      }
      if (this.qmD.qgo != null) {
        this.qmD.qgo.dismiss();
      }
      this.qmD.aZ();
      this.qmD.vN(0);
      return;
    }
    this.qmD.frT = paramString;
    this.qmD.XM();
    this.qmD.Qj(paramString);
    this.qmD.qmC = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.5
 * JD-Core Version:    0.7.0.1
 */