package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletOpenFingerprintPayRedirectUI$1
  implements DialogInterface.OnCancelListener
{
  WalletOpenFingerprintPayRedirectUI$1(WalletOpenFingerprintPayRedirectUI paramWalletOpenFingerprintPayRedirectUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(48290);
    WalletOpenFingerprintPayRedirectUI.a(this.uBv);
    WalletOpenFingerprintPayRedirectUI.a(this.uBv, "");
    AppMethodBeat.o(48290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletOpenFingerprintPayRedirectUI.1
 * JD-Core Version:    0.7.0.1
 */