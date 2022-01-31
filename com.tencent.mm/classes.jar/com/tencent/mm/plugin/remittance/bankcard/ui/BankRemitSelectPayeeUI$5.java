package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class BankRemitSelectPayeeUI$5
  implements DialogInterface.OnClickListener
{
  BankRemitSelectPayeeUI$5(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(44676);
    al.p(new BankRemitSelectPayeeUI.5.1(this), 500L);
    AppMethodBeat.o(44676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.5
 * JD-Core Version:    0.7.0.1
 */