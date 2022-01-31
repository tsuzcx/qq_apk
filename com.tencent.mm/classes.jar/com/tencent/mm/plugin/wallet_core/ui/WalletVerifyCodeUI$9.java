package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletVerifyCodeUI$9
  implements View.OnClickListener
{
  WalletVerifyCodeUI$9(WalletVerifyCodeUI paramWalletVerifyCodeUI, Bankcard paramBankcard) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    y.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
    y.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess3 and finish!");
    if ((WalletVerifyCodeUI.d(this.qHg) != null) && (WalletVerifyCodeUI.d(this.qHg).bUZ())) {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13731, new Object[] { Integer.valueOf(9) });
    }
    paramView = this.qHg.BX;
    paramView.putInt("key_err_code", 417);
    paramView.putBoolean("key_need_show_switch_phone", true);
    if ((this.qge == null) || (this.qge.bUQ())) {
      bool = true;
    }
    paramView.putBoolean("key_isbalance", bool);
    a.j(this.qHg, paramView);
    this.qHg.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.9
 * JD-Core Version:    0.7.0.1
 */