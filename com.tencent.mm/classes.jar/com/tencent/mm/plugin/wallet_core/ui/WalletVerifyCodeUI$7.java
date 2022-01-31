package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletVerifyCodeUI$7
  implements View.OnClickListener
{
  WalletVerifyCodeUI$7(WalletVerifyCodeUI paramWalletVerifyCodeUI, Bankcard paramBankcard) {}
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    y.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
    y.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess and finish!");
    paramView = this.qHg.BX;
    paramView.putInt("key_err_code", 417);
    paramView.putBoolean("key_need_show_switch_phone", true);
    this.qHg.BX.putBoolean("key_block_bind_new_card", true);
    boolean bool1 = bool2;
    if (this.qge != null) {
      if (!this.qge.bUQ()) {
        break label97;
      }
    }
    label97:
    for (bool1 = bool2;; bool1 = false)
    {
      paramView.putBoolean("key_isbalance", bool1);
      a.j(this.qHg, paramView);
      this.qHg.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.7
 * JD-Core Version:    0.7.0.1
 */