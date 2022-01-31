package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.tp;
import com.tencent.mm.sdk.b.a;

final class WalletMixOrderInfoUI$2
  implements DialogInterface.OnClickListener
{
  WalletMixOrderInfoUI$2(WalletMixOrderInfoUI paramWalletMixOrderInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new tp();
    paramDialogInterface.cdQ.bMX = WalletMixOrderInfoUI.a(this.qDS);
    paramDialogInterface.cdQ.result = 0;
    a.udP.m(paramDialogInterface);
    this.qDS.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI.2
 * JD-Core Version:    0.7.0.1
 */