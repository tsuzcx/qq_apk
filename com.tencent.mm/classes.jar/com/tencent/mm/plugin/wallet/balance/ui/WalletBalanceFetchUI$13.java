package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletBalanceFetchUI$13
  implements DialogInterface.OnCancelListener
{
  WalletBalanceFetchUI$13(WalletBalanceFetchUI paramWalletBalanceFetchUI, Dialog paramDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(142275);
    ab.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog onCancel");
    if ((this.tOr != null) && (this.tOr.isShowing())) {
      this.tOr.dismiss();
    }
    AppMethodBeat.o(142275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.13
 * JD-Core Version:    0.7.0.1
 */