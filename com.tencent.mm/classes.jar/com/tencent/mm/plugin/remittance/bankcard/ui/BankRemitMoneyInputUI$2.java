package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BankRemitMoneyInputUI$2
  implements Runnable
{
  BankRemitMoneyInputUI$2(BankRemitMoneyInputUI paramBankRemitMoneyInputUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(44631);
    BankRemitMoneyInputUI.f(this.qij).scrollBy(0, this.val$scrollDistance);
    AppMethodBeat.o(44631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.2
 * JD-Core Version:    0.7.0.1
 */