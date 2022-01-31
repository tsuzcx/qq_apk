package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.c;

final class WalletBalanceFetchResultUI$3
  implements DialogInterface.OnClickListener
{
  WalletBalanceFetchResultUI$3(WalletBalanceFetchResultUI paramWalletBalanceFetchResultUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45349);
    this.tNF.getProcess().a(this.tNF, 0, this.tNF.getInput());
    AppMethodBeat.o(45349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI.3
 * JD-Core Version:    0.7.0.1
 */