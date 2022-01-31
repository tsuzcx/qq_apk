package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class WalletMixOrderInfoUI$1
  implements DialogInterface.OnClickListener
{
  WalletMixOrderInfoUI$1(WalletMixOrderInfoUI paramWalletMixOrderInfoUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    WalletMixOrderInfoUI.a(this.qDS, this.qDR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI.1
 * JD-Core Version:    0.7.0.1
 */