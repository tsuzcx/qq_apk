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
    AppMethodBeat.i(68586);
    paramDialogInterface.dismiss();
    h.wUl.f(16398, new Object[] { WalletBalanceFetchUI.d(this.AYV), Integer.valueOf(4), "", "" });
    AppMethodBeat.o(68586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.9
 * JD-Core Version:    0.7.0.1
 */