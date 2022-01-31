package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.a;

final class WalletVerifyCodeUI$1$2
  implements DialogInterface.OnClickListener
{
  WalletVerifyCodeUI$1$2(WalletVerifyCodeUI.1 param1, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(47690);
    paramDialogInterface = this.uun.uul.getInput();
    paramDialogInterface.putInt("key_err_code", 417);
    paramDialogInterface.putBoolean("key_need_show_switch_phone", true);
    if ((this.uun.tNr == null) || (this.uun.tNr.cTf())) {}
    for (boolean bool = true;; bool = false)
    {
      paramDialogInterface.putBoolean("key_isbalance", bool);
      a.j(this.uun.uul, paramDialogInterface);
      h.qsU.e(15443, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(this.uum) });
      AppMethodBeat.o(47690);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.1.2
 * JD-Core Version:    0.7.0.1
 */