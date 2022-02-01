package com.tencent.mm.plugin.wxcredit.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;

final class WalletWXCreditChangeAmountUI$3
  implements DialogInterface.OnClickListener
{
  WalletWXCreditChangeAmountUI$3(WalletWXCreditChangeAmountUI paramWalletWXCreditChangeAmountUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(72335);
    paramDialogInterface = a.bs(this.EZL);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.b(this.EZL, this.EZL.getInput());
      AppMethodBeat.o(72335);
      return;
    }
    this.EZL.finish();
    AppMethodBeat.o(72335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.3
 * JD-Core Version:    0.7.0.1
 */