package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.tp;
import com.tencent.mm.h.a.ul;
import com.tencent.mm.sdk.b.a;

final class WalletMixOrderInfoUI$4
  implements DialogInterface.OnClickListener
{
  WalletMixOrderInfoUI$4(WalletMixOrderInfoUI paramWalletMixOrderInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (WalletMixOrderInfoUI.k(this.qDS))
    {
      paramDialogInterface = new ul();
      paramDialogInterface.ceQ.result = this.qDT;
      a.udP.m(paramDialogInterface);
    }
    paramDialogInterface = new tp();
    paramDialogInterface.cdQ.bMX = WalletMixOrderInfoUI.a(this.qDS);
    paramDialogInterface.cdQ.result = this.qDT;
    a.udP.m(paramDialogInterface);
    this.qDS.setResult(this.qDT);
    this.qDS.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI.4
 * JD-Core Version:    0.7.0.1
 */