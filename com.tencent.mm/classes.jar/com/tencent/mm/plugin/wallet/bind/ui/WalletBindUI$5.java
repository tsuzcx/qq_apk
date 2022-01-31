package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBindUI$5
  implements DialogInterface.OnClickListener
{
  WalletBindUI$5(WalletBindUI paramWalletBindUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45800);
    this.tTw.finish();
    AppMethodBeat.o(45800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.5
 * JD-Core Version:    0.7.0.1
 */