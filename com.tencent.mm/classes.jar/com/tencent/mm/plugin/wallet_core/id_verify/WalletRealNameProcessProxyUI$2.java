package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletRealNameProcessProxyUI$2
  implements DialogInterface.OnClickListener
{
  WalletRealNameProcessProxyUI$2(WalletRealNameProcessProxyUI paramWalletRealNameProcessProxyUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(70041);
    this.Bqf.setResult(1);
    this.Bqf.finish();
    AppMethodBeat.o(70041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameProcessProxyUI.2
 * JD-Core Version:    0.7.0.1
 */