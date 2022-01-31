package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class BankRemitBankcardInputUI$26
  implements View.OnClickListener
{
  BankRemitBankcardInputUI$26(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.BankRemitBankcardInputUI", "click arrive time et");
    this.nwd.XM();
    BankRemitBankcardInputUI.o(this.nwd).bvq();
    if (!BankRemitBankcardInputUI.r(this.nwd))
    {
      paramView = new Intent(this.nwd.mController.uMN, BankRemitSelectArriveTimeUI.class);
      if ((BankRemitBankcardInputUI.s(this.nwd) != null) && (BankRemitBankcardInputUI.s(this.nwd).nvk != null)) {
        paramView.putParcelableArrayListExtra("key_arrive_time_parcel_list", BankRemitBankcardInputUI.s(this.nwd).nvk);
      }
      if (BankRemitBankcardInputUI.t(this.nwd) != null) {
        paramView.putExtra("key_select_arrive_time", BankRemitBankcardInputUI.t(this.nwd).nvl);
      }
      this.nwd.startActivityForResult(paramView, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.26
 * JD-Core Version:    0.7.0.1
 */