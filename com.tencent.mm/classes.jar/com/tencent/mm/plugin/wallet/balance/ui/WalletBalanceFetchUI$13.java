package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class WalletBalanceFetchUI$13
  implements DialogInterface.OnCancelListener
{
  WalletBalanceFetchUI$13(WalletBalanceFetchUI paramWalletBalanceFetchUI, Dialog paramDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(68592);
    ac.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog onCancel");
    if ((this.AZd != null) && (this.AZd.isShowing())) {
      this.AZd.dismiss();
    }
    AppMethodBeat.o(68592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.13
 * JD-Core Version:    0.7.0.1
 */