package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.protocal.c.apc;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.j;

final class BankRemitHistoryUI$1
  implements AdapterView.OnItemLongClickListener
{
  BankRemitHistoryUI$1(BankRemitHistoryUI paramBankRemitHistoryUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.d("MicroMsg.BankRemitHistoryUI", "click item, %s", new Object[] { ((apc)paramAdapterView.getAdapter().getItem(paramInt)).title });
    BankRemitHistoryUI.a(this.nwG).a(paramView, paramInt, paramLong, this.nwG, this.nwG);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.1
 * JD-Core Version:    0.7.0.1
 */