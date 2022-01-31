package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class BankRemitBankcardInputUI$20
  implements View.OnClickListener
{
  BankRemitBankcardInputUI$20(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.BankRemitBankcardInputUI", "name iv click");
    if ((BankRemitBankcardInputUI.G(this.nwd)) || (!BankRemitBankcardInputUI.H(this.nwd))) {
      BankRemitBankcardInputUI.I(this.nwd);
    }
    for (;;)
    {
      h.nFQ.f(14673, new Object[] { Integer.valueOf(3) });
      return;
      paramView = new Intent(this.nwd.mController.uMN, BankRemitSelectPayeeUI.class);
      if (BankRemitBankcardInputUI.B(this.nwd) != null) {
        paramView.putParcelableArrayListExtra("key_self_transfer_record_list", BankRemitBankcardInputUI.B(this.nwd));
      }
      if (BankRemitBankcardInputUI.C(this.nwd) != null) {
        paramView.putParcelableArrayListExtra("key_freq_transfer_record_list", BankRemitBankcardInputUI.C(this.nwd));
      }
      this.nwd.startActivityForResult(paramView, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.20
 * JD-Core Version:    0.7.0.1
 */