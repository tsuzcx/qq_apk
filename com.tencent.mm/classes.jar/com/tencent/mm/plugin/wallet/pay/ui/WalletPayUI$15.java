package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayUI$15
  implements DialogInterface.OnClickListener
{
  WalletPayUI$15(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46051);
    if (this.tXq.isTransparent()) {
      this.tXq.finish();
    }
    AppMethodBeat.o(46051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.15
 * JD-Core Version:    0.7.0.1
 */