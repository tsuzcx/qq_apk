package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletPayUChangeBankcardUI$1
  implements b.b
{
  WalletPayUChangeBankcardUI$1(WalletPayUChangeBankcardUI paramWalletPayUChangeBankcardUI) {}
  
  public final void a(String paramString1, String paramString2, FavorPayInfo paramFavorPayInfo)
  {
    WalletPayUChangeBankcardUI.a(this.qOe, paramFavorPayInfo);
    this.qOe.BX.putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.a(this.qOe));
    WalletPayUChangeBankcardUI.a(this.qOe, paramString1);
    WalletPayUChangeBankcardUI.b(this.qOe, paramString2);
    this.qOe.XM();
    this.qOe.Qj(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI.1
 * JD-Core Version:    0.7.0.1
 */