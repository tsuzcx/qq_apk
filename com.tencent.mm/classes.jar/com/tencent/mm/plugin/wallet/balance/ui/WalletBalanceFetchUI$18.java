package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletBalanceFetchUI$18
  implements DialogInterface.OnCancelListener
{
  WalletBalanceFetchUI$18(WalletBalanceFetchUI paramWalletBalanceFetchUI, Dialog paramDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(213888);
    Log.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog onCancel");
    if ((this.HvS != null) && (this.HvS.isShowing())) {
      this.HvS.dismiss();
    }
    AppMethodBeat.o(213888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.18
 * JD-Core Version:    0.7.0.1
 */