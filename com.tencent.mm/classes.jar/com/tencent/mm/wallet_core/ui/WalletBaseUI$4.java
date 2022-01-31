package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBaseUI$4
  implements DialogInterface.OnCancelListener
{
  WalletBaseUI$4(WalletBaseUI paramWalletBaseUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(142664);
    this.AYz.forceCancel();
    AppMethodBeat.o(142664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.4
 * JD-Core Version:    0.7.0.1
 */