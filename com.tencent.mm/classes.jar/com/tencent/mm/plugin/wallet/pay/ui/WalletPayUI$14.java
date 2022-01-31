package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayUI$14
  implements DialogInterface.OnClickListener
{
  WalletPayUI$14(WalletPayUI paramWalletPayUI, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46050);
    if (WalletPayUI.m(this.tXq))
    {
      this.tXq.nA(true);
      AppMethodBeat.o(46050);
      return;
    }
    this.tXq.ar(this.tXr, false);
    AppMethodBeat.o(46050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.14
 * JD-Core Version:    0.7.0.1
 */