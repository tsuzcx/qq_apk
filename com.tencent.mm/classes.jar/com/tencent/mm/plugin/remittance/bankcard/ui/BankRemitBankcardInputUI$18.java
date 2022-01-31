package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class BankRemitBankcardInputUI$18
  implements AdapterView.OnItemClickListener
{
  BankRemitBankcardInputUI$18(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.i("MicroMsg.BankRemitBankcardInputUI", "popup window click: %d", new Object[] { Integer.valueOf(paramInt) });
    BankRemitBankcardInputUI.a(this.nwd, false);
    BankRemitBankcardInputUI.a(this.nwd, (TransferRecordParcel)paramAdapterView.getAdapter().getItem(paramInt));
    BankRemitBankcardInputUI.E(this.nwd);
    BankRemitBankcardInputUI.a(this.nwd, BankRemitBankcardInputUI.F(this.nwd).nvy, BankRemitBankcardInputUI.A(this.nwd), BankRemitBankcardInputUI.F(this.nwd).mOb);
    ai.l(new BankRemitBankcardInputUI.18.1(this), 500L);
    BankRemitBankcardInputUI.f(this.nwd).dismiss();
    this.nwd.XM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.18
 * JD-Core Version:    0.7.0.1
 */