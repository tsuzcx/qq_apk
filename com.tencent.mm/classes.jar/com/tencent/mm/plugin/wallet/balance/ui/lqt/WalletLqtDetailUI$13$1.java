package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletLqtDetailUI$13$1
  implements Runnable
{
  WalletLqtDetailUI$13$1(WalletLqtDetailUI.13 param13) {}
  
  public final void run()
  {
    AppMethodBeat.i(142297);
    if (WalletLqtDetailUI.a(this.tPV.tPQ) != null) {
      WalletLqtDetailUI.a(this.tPV.tPQ).dismiss();
    }
    Toast.makeText(this.tPV.tPQ, this.tPV.tPQ.getString(2131305188), 1).show();
    this.tPV.tPQ.finish();
    AppMethodBeat.o(142297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.13.1
 * JD-Core Version:    0.7.0.1
 */