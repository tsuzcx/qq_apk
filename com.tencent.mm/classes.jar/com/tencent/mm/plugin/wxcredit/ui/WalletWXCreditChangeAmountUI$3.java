package com.tencent.mm.plugin.wxcredit.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

final class WalletWXCreditChangeAmountUI$3
  implements DialogInterface.OnClickListener
{
  WalletWXCreditChangeAmountUI$3(WalletWXCreditChangeAmountUI paramWalletWXCreditChangeAmountUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48691);
    paramDialogInterface = a.aM(this.vIv);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.b(this.vIv, this.vIv.getInput());
      AppMethodBeat.o(48691);
      return;
    }
    this.vIv.finish();
    AppMethodBeat.o(48691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.3
 * JD-Core Version:    0.7.0.1
 */