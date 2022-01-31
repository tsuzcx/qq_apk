package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h.b;

final class BankRemitMoneyInputUI$8$1
  implements h.b
{
  BankRemitMoneyInputUI$8$1(BankRemitMoneyInputUI.8 param8) {}
  
  public final boolean onFinish(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(44637);
    if (!bo.isNullOrNil(paramCharSequence.toString()))
    {
      BankRemitMoneyInputUI.c(this.qil.qij, paramCharSequence.toString());
      BankRemitMoneyInputUI.k(this.qil.qij);
    }
    for (;;)
    {
      AppMethodBeat.o(44637);
      return true;
      BankRemitMoneyInputUI.c(this.qil.qij, null);
      BankRemitMoneyInputUI.k(this.qil.qij);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.8.1
 * JD-Core Version:    0.7.0.1
 */