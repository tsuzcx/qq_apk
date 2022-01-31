package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.a;

final class WalletVerifyCodeUI$7
  implements View.OnClickListener
{
  WalletVerifyCodeUI$7(WalletVerifyCodeUI paramWalletVerifyCodeUI, Bankcard paramBankcard) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(47696);
    ab.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
    ab.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess3 and finish!");
    if ((WalletVerifyCodeUI.d(this.uul) != null) && (WalletVerifyCodeUI.d(this.uul).cTq())) {
      h.qsU.e(13731, new Object[] { Integer.valueOf(9) });
    }
    paramView = this.uul.getInput();
    paramView.putInt("key_err_code", 417);
    paramView.putBoolean("key_need_show_switch_phone", true);
    if ((this.tNr == null) || (this.tNr.cTf())) {
      bool = true;
    }
    paramView.putBoolean("key_isbalance", bool);
    a.j(this.uul, paramView);
    AppMethodBeat.o(47696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.7
 * JD-Core Version:    0.7.0.1
 */