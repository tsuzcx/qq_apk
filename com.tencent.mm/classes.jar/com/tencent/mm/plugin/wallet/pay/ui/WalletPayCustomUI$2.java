package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayCustomUI$2
  implements DialogInterface.OnCancelListener
{
  WalletPayCustomUI$2(WalletPayCustomUI paramWalletPayCustomUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(46010);
    this.tWl.finish();
    AppMethodBeat.o(46010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI.2
 * JD-Core Version:    0.7.0.1
 */