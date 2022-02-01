package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class WalletBalanceSaveUI$9
  implements DialogInterface.OnClickListener
{
  WalletBalanceSaveUI$9(WalletBalanceSaveUI paramWalletBalanceSaveUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(68704);
    h.wUl.f(17084, new Object[] { Integer.valueOf(7) });
    paramDialogInterface.dismiss();
    AppMethodBeat.o(68704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.9
 * JD-Core Version:    0.7.0.1
 */