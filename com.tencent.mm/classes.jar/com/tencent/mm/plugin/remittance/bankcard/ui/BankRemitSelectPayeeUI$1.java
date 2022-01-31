package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.sdk.platformtools.ab;

final class BankRemitSelectPayeeUI$1
  implements AdapterView.OnItemClickListener
{
  BankRemitSelectPayeeUI$1(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44671);
    ab.d("MicroMsg.BankRemitSelectPayeeUI", "item click: %s", new Object[] { Integer.valueOf(paramInt) });
    paramAdapterView = (TransferRecordParcel)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView != null)
    {
      BankRemitSelectPayeeUI.a(this.qiD).putExtra("key_bank_card_seqno", paramAdapterView.qgu);
      this.qiD.setResult(-1, BankRemitSelectPayeeUI.a(this.qiD));
      this.qiD.finish();
    }
    AppMethodBeat.o(44671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.1
 * JD-Core Version:    0.7.0.1
 */