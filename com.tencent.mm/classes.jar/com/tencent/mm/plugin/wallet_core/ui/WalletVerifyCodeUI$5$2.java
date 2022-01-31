package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletVerifyCodeUI$5$2
  implements DialogInterface.OnClickListener
{
  WalletVerifyCodeUI$5$2(WalletVerifyCodeUI.5 param5, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.qHi.qHg.BX;
    paramDialogInterface.putInt("key_err_code", 417);
    paramDialogInterface.putBoolean("key_need_show_switch_phone", true);
    if ((this.qHi.qge == null) || (this.qHi.qge.bUQ())) {}
    for (boolean bool = true;; bool = false)
    {
      paramDialogInterface.putBoolean("key_isbalance", bool);
      a.j(this.qHi.qHg, paramDialogInterface);
      this.qHi.qHg.finish();
      h.nFQ.f(15443, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(this.qHh) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.5.2
 * JD-Core Version:    0.7.0.1
 */