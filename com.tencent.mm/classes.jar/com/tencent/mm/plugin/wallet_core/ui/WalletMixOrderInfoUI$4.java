package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.sdk.b.a;

final class WalletMixOrderInfoUI$4
  implements DialogInterface.OnClickListener
{
  WalletMixOrderInfoUI$4(WalletMixOrderInfoUI paramWalletMixOrderInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(47415);
    paramDialogInterface.dismiss();
    if (WalletMixOrderInfoUI.k(this.uqN))
    {
      paramDialogInterface = new wf();
      paramDialogInterface.cNw.result = this.uqO;
      a.ymk.l(paramDialogInterface);
    }
    paramDialogInterface = new vk();
    paramDialogInterface.cMA.cnI = WalletMixOrderInfoUI.a(this.uqN);
    paramDialogInterface.cMA.result = this.uqO;
    a.ymk.l(paramDialogInterface);
    this.uqN.setResult(this.uqO);
    this.uqN.finish();
    AppMethodBeat.o(47415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI.4
 * JD-Core Version:    0.7.0.1
 */