package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayUI$17
  implements DialogInterface.OnClickListener
{
  WalletPayUI$17(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(69406);
    this.zRD.zQX.putInt("key_pay_flag", 3);
    this.zRD.al(this.zRD.zQX);
    AppMethodBeat.o(69406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.17
 * JD-Core Version:    0.7.0.1
 */