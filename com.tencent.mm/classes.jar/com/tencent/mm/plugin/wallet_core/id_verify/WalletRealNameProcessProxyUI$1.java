package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletRealNameProcessProxyUI$1
  implements DialogInterface.OnClickListener
{
  WalletRealNameProcessProxyUI$1(WalletRealNameProcessProxyUI paramWalletRealNameProcessProxyUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46613);
    this.ucU.setResult(1);
    this.ucU.finish();
    AppMethodBeat.o(46613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameProcessProxyUI.1
 * JD-Core Version:    0.7.0.1
 */