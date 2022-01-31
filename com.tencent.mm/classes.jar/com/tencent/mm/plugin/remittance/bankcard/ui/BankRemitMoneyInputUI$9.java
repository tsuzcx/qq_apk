package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.a.o;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.dc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class BankRemitMoneyInputUI$9
  implements DialogInterface.OnClickListener
{
  BankRemitMoneyInputUI$9(BankRemitMoneyInputUI paramBankRemitMoneyInputUI, o paramo, dc paramdc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(44641);
    if (this.qik.qfX.cnK == 0)
    {
      if (BankRemitMoneyInputUI.l(this.qij)) {
        BankRemitMoneyInputUI.m(this.qij);
      }
      BankRemitMoneyInputUI.a(this.qij, this.qik.qfX.opy, this.qik.qfX.qgw, this.qik.qfX.nLq, this.qik.qfX.qgv);
      AppMethodBeat.o(44641);
      return;
    }
    if (!bo.isNullOrNil(this.qin.kNB)) {
      e.m(this.qij.getContext(), this.qin.kNB, false);
    }
    AppMethodBeat.o(44641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.9
 * JD-Core Version:    0.7.0.1
 */