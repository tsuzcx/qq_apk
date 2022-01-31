package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletOrderInfoUI$2
  implements DialogInterface.OnClickListener
{
  WalletOrderInfoUI$2(WalletOrderInfoUI paramWalletOrderInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(47524);
    this.usr.finish();
    AppMethodBeat.o(47524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI.2
 * JD-Core Version:    0.7.0.1
 */