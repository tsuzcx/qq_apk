package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e;

final class WalletBalanceFetchResultUI$3
  implements DialogInterface.OnClickListener
{
  WalletBalanceFetchResultUI$3(WalletBalanceFetchResultUI paramWalletBalanceFetchResultUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(68572);
    this.Vbs.getProcess().a(this.Vbs, 0, this.Vbs.getInput());
    AppMethodBeat.o(68572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI.3
 * JD-Core Version:    0.7.0.1
 */