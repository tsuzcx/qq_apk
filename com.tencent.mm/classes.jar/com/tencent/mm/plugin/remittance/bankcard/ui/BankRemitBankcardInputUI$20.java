package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class BankRemitBankcardInputUI$20
  implements View.OnClickListener
{
  BankRemitBankcardInputUI$20(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44535);
    ab.d("MicroMsg.BankRemitBankcardInputUI", "name iv click");
    if ((BankRemitBankcardInputUI.T(this.qhe)) || (!BankRemitBankcardInputUI.U(this.qhe))) {
      BankRemitBankcardInputUI.V(this.qhe);
    }
    for (;;)
    {
      h.qsU.e(14673, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(44535);
      return;
      paramView = new Intent(this.qhe.getContext(), BankRemitSelectPayeeUI.class);
      if (BankRemitBankcardInputUI.M(this.qhe) != null) {
        paramView.putParcelableArrayListExtra("key_self_transfer_record_list", BankRemitBankcardInputUI.M(this.qhe));
      }
      if (BankRemitBankcardInputUI.N(this.qhe) != null) {
        paramView.putParcelableArrayListExtra("key_freq_transfer_record_list", BankRemitBankcardInputUI.N(this.qhe));
      }
      this.qhe.startActivityForResult(paramView, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.20
 * JD-Core Version:    0.7.0.1
 */