package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.model.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.t;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class BankRemitMoneyInputUI$3
  extends t
{
  BankRemitMoneyInputUI$3(BankRemitMoneyInputUI paramBankRemitMoneyInputUI) {}
  
  public final void bhX()
  {
    AppMethodBeat.i(44632);
    ab.d("MicroMsg.BankRemitMoneyInputUI", "on click next");
    double d = a.fW(BankRemitMoneyInputUI.c(this.qij).getText(), "100");
    if (d <= 0.0D)
    {
      ab.w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", new Object[] { Double.valueOf(d) });
      Toast.makeText(this.qij, 2131297496, 1).show();
      AppMethodBeat.o(44632);
      return;
    }
    BankRemitMoneyInputUI.d(this.qij);
    AppMethodBeat.o(44632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.3
 * JD-Core Version:    0.7.0.1
 */