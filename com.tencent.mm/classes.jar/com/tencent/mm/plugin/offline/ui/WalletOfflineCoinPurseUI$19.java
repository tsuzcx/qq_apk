package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletOfflineCoinPurseUI$19
  implements DialogInterface.OnCancelListener
{
  WalletOfflineCoinPurseUI$19(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(213645);
    WalletOfflineCoinPurseUI.G(this.AMt);
    AppMethodBeat.o(213645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.19
 * JD-Core Version:    0.7.0.1
 */