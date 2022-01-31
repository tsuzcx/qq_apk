package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class BankRemitBankcardInputUI$18
  implements AdapterView.OnItemClickListener
{
  BankRemitBankcardInputUI$18(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44533);
    ab.i("MicroMsg.BankRemitBankcardInputUI", "popup window click: %d", new Object[] { Integer.valueOf(paramInt) });
    BankRemitBankcardInputUI.a(this.qhe, false);
    BankRemitBankcardInputUI.a(this.qhe, (TransferRecordParcel)paramAdapterView.getAdapter().getItem(paramInt));
    BankRemitBankcardInputUI.R(this.qhe);
    BankRemitBankcardInputUI.a(this.qhe, BankRemitBankcardInputUI.S(this.qhe).qgu, BankRemitBankcardInputUI.L(this.qhe), BankRemitBankcardInputUI.S(this.qhe).poq);
    al.p(new BankRemitBankcardInputUI.18.1(this), 500L);
    BankRemitBankcardInputUI.f(this.qhe).dismiss();
    this.qhe.hideVKB();
    AppMethodBeat.o(44533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.18
 * JD-Core Version:    0.7.0.1
 */