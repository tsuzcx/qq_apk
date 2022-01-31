package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.sortview.d;

final class BankRemitSelectBankUI$1
  implements AdapterView.OnItemClickListener
{
  BankRemitSelectBankUI$1(BankRemitSelectBankUI paramBankRemitSelectBankUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44663);
    paramAdapterView = (hi)((d)paramAdapterView.getAdapter().getItem(paramInt)).data;
    if (paramAdapterView != null)
    {
      paramAdapterView = new BankcardElemParcel(paramAdapterView);
      paramView = new Intent();
      paramView.putExtra("key_bank_card_elem_parcel", paramAdapterView);
      this.qit.setResult(-1, paramView);
      this.qit.finish();
      AppMethodBeat.o(44663);
      return;
    }
    ab.w("MicroMsg.BankRemitSelectBankUI", "bankcardelem is null, : %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(44663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI.1
 * JD-Core Version:    0.7.0.1
 */