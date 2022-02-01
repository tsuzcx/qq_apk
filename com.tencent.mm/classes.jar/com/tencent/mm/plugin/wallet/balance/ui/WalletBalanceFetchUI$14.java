package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class WalletBalanceFetchUI$14
  implements DialogInterface.OnCancelListener
{
  WalletBalanceFetchUI$14(WalletBalanceFetchUI paramWalletBalanceFetchUI, Dialog paramDialog) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(199200);
    ad.i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog onCancel");
    if ((this.Czp != null) && (this.Czp.isShowing())) {
      this.Czp.dismiss();
    }
    AppMethodBeat.o(199200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.14
 * JD-Core Version:    0.7.0.1
 */