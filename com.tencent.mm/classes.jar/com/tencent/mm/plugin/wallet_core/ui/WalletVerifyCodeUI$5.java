package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.a;

final class WalletVerifyCodeUI$5
  implements View.OnClickListener
{
  WalletVerifyCodeUI$5(WalletVerifyCodeUI paramWalletVerifyCodeUI, Bankcard paramBankcard) {}
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(47693);
    ab.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
    ab.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess and finish!");
    paramView = this.uul.getInput();
    paramView.putInt("key_err_code", 417);
    paramView.putBoolean("key_need_show_switch_phone", true);
    this.uul.getInput().putBoolean("key_block_bind_new_card", true);
    boolean bool1 = bool2;
    if (this.tNr != null) {
      if (!this.tNr.cTf()) {
        break label107;
      }
    }
    label107:
    for (bool1 = bool2;; bool1 = false)
    {
      paramView.putBoolean("key_isbalance", bool1);
      a.j(this.uul, paramView);
      this.uul.finish();
      AppMethodBeat.o(47693);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.5
 * JD-Core Version:    0.7.0.1
 */