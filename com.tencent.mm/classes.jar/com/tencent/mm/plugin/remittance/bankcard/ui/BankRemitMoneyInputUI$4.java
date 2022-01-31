package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.a;

final class BankRemitMoneyInputUI$4
  implements a
{
  BankRemitMoneyInputUI$4(BankRemitMoneyInputUI paramBankRemitMoneyInputUI) {}
  
  public final void onVisibleStateChange(boolean paramBoolean)
  {
    AppMethodBeat.i(44633);
    if (paramBoolean)
    {
      BankRemitMoneyInputUI.e(this.qij);
      AppMethodBeat.o(44633);
      return;
    }
    BankRemitMoneyInputUI.f(this.qij).scrollTo(0, 0);
    AppMethodBeat.o(44633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.4
 * JD-Core Version:    0.7.0.1
 */