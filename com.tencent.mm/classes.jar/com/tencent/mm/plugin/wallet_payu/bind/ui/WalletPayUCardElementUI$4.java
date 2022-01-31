package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.HashMap;

final class WalletPayUCardElementUI$4
  implements View.OnClickListener
{
  WalletPayUCardElementUI$4(WalletPayUCardElementUI paramWalletPayUCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = (NetScenePayUElementQuery.PayUBankcardElement)WalletPayUCardElementUI.d(this.qMZ).get(WalletPayUCardElementUI.c(this.qMZ).getText());
    if (paramView == null)
    {
      y.e("MicroMsg.WalletPayUCardElementUI", "hy: should not be NULL!!!");
      return;
    }
    WalletPayUCardElementUI.c(this.qMZ).setEncryptType(50);
    this.qMZ.BX.putParcelable("key_card_element", paramView);
    this.qMZ.BX.putString("key_card_id", WalletPayUCardElementUI.c(this.qMZ).getText());
    this.qMZ.BX.putString("key_cvv", WalletPayUCardElementUI.a(this.qMZ).getText());
    this.qMZ.BX.putString("key_expire_data", this.qMZ.qMO.getText());
    this.qMZ.cNk().m(new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI.4
 * JD-Core Version:    0.7.0.1
 */