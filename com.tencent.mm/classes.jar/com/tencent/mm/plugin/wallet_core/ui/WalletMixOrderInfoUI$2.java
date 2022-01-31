package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.sdk.b.a;

final class WalletMixOrderInfoUI$2
  implements DialogInterface.OnClickListener
{
  WalletMixOrderInfoUI$2(WalletMixOrderInfoUI paramWalletMixOrderInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(47412);
    paramDialogInterface.dismiss();
    paramDialogInterface = new vk();
    paramDialogInterface.cMA.cnI = WalletMixOrderInfoUI.a(this.uqN);
    paramDialogInterface.cMA.result = 0;
    a.ymk.l(paramDialogInterface);
    this.uqN.finish();
    AppMethodBeat.o(47412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI.2
 * JD-Core Version:    0.7.0.1
 */