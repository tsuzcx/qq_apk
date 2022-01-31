package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.protocal.c.fx;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.sortview.d;

final class BankRemitSelectBankUI$1
  implements AdapterView.OnItemClickListener
{
  BankRemitSelectBankUI$1(BankRemitSelectBankUI paramBankRemitSelectBankUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (fx)((d)paramAdapterView.getAdapter().getItem(paramInt)).data;
    if (paramAdapterView != null)
    {
      paramAdapterView = new BankcardElemParcel(paramAdapterView);
      paramView = new Intent();
      paramView.putExtra("key_bank_card_elem_parcel", paramAdapterView);
      this.nxs.setResult(-1, paramView);
      this.nxs.finish();
      return;
    }
    y.w("MicroMsg.BankRemitSelectBankUI", "bankcardelem is null, : %s", new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI.1
 * JD-Core Version:    0.7.0.1
 */