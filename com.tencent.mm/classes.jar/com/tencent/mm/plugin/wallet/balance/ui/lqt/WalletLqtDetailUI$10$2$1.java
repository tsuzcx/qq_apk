package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtDetailUI$10$2$1
  implements DialogInterface.OnClickListener
{
  WalletLqtDetailUI$10$2$1(WalletLqtDetailUI.10.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142292);
    WalletLqtDetailUI.i(this.tPU.tPT.tPQ);
    paramDialogInterface = new Intent(this.tPU.tPT.tPQ, WalletLqtSimpleCheckPwdUI.class);
    this.tPU.tPT.tPQ.startActivityForResult(paramDialogInterface, 123);
    AppMethodBeat.o(142292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.10.2.1
 * JD-Core Version:    0.7.0.1
 */