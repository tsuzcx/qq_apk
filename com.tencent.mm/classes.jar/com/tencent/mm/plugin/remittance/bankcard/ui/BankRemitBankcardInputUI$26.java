package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class BankRemitBankcardInputUI$26
  implements View.OnClickListener
{
  BankRemitBankcardInputUI$26(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44542);
    ab.i("MicroMsg.BankRemitBankcardInputUI", "click arrive time et");
    this.qhe.hideVKB();
    BankRemitBankcardInputUI.r(this.qhe).cfJ();
    if (!BankRemitBankcardInputUI.u(this.qhe))
    {
      paramView = new Intent(this.qhe.getContext(), BankRemitSelectArriveTimeUI.class);
      if ((BankRemitBankcardInputUI.v(this.qhe) != null) && (BankRemitBankcardInputUI.v(this.qhe).qge != null)) {
        paramView.putParcelableArrayListExtra("key_arrive_time_parcel_list", BankRemitBankcardInputUI.v(this.qhe).qge);
      }
      if (BankRemitBankcardInputUI.w(this.qhe) != null) {
        paramView.putExtra("key_select_arrive_time", BankRemitBankcardInputUI.w(this.qhe).qgh);
      }
      this.qhe.startActivityForResult(paramView, 3);
    }
    AppMethodBeat.o(44542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.26
 * JD-Core Version:    0.7.0.1
 */