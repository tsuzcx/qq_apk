package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class WalletBalanceFetchUI$9
  implements DialogInterface.OnClickListener
{
  WalletBalanceFetchUI$9(WalletBalanceFetchUI paramWalletBalanceFetchUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45363);
    paramDialogInterface.dismiss();
    h.qsU.e(16398, new Object[] { WalletBalanceFetchUI.d(this.tOj), Integer.valueOf(4), "", "" });
    AppMethodBeat.o(45363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.9
 * JD-Core Version:    0.7.0.1
 */