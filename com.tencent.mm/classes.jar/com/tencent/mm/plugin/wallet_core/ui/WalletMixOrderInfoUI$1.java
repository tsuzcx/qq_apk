package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletMixOrderInfoUI$1
  implements DialogInterface.OnClickListener
{
  WalletMixOrderInfoUI$1(WalletMixOrderInfoUI paramWalletMixOrderInfoUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(47411);
    paramDialogInterface.dismiss();
    WalletMixOrderInfoUI.a(this.uqN, this.uqM);
    AppMethodBeat.o(47411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI.1
 * JD-Core Version:    0.7.0.1
 */