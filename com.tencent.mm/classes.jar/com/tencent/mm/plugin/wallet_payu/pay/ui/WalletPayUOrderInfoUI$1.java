package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;

final class WalletPayUOrderInfoUI$1
  implements DialogInterface.OnClickListener
{
  WalletPayUOrderInfoUI$1(WalletPayUOrderInfoUI paramWalletPayUOrderInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48476);
    a.b(this.uDm, this.uDm.getInput(), 0);
    AppMethodBeat.o(48476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUOrderInfoUI.1
 * JD-Core Version:    0.7.0.1
 */