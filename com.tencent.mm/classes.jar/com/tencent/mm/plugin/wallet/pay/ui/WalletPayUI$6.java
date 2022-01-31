package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayUI$6
  implements DialogInterface.OnClickListener
{
  WalletPayUI$6(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46039);
    this.tXq.finish();
    AppMethodBeat.o(46039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.6
 * JD-Core Version:    0.7.0.1
 */