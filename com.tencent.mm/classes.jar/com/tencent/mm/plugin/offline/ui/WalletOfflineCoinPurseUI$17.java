package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletOfflineCoinPurseUI$17
  implements DialogInterface.OnDismissListener
{
  WalletOfflineCoinPurseUI$17(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(43523);
    if (this.pnN != null) {
      this.pnN.onDismiss(paramDialogInterface);
    }
    if (WalletOfflineCoinPurseUI.A(this.pny))
    {
      WalletOfflineCoinPurseUI.a(this.pny);
      WalletOfflineCoinPurseUI.B(this.pny);
      WalletOfflineCoinPurseUI.C(this.pny);
      WalletOfflineCoinPurseUI.D(this.pny);
    }
    AppMethodBeat.o(43523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.17
 * JD-Core Version:    0.7.0.1
 */