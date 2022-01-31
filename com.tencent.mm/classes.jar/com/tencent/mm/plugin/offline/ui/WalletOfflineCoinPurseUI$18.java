package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletOfflineCoinPurseUI$18
  implements DialogInterface.OnCancelListener
{
  WalletOfflineCoinPurseUI$18(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(43524);
    WalletOfflineCoinPurseUI.E(this.pny);
    AppMethodBeat.o(43524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.18
 * JD-Core Version:    0.7.0.1
 */