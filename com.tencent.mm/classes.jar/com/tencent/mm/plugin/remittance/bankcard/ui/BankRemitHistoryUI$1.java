package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.l;

final class BankRemitHistoryUI$1
  implements AdapterView.OnItemLongClickListener
{
  BankRemitHistoryUI$1(BankRemitHistoryUI paramBankRemitHistoryUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44606);
    ab.d("MicroMsg.BankRemitHistoryUI", "click item, %s", new Object[] { ((avb)paramAdapterView.getAdapter().getItem(paramInt)).title });
    BankRemitHistoryUI.a(this.qhI).a(paramView, paramInt, paramLong, this.qhI, this.qhI);
    AppMethodBeat.o(44606);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.1
 * JD-Core Version:    0.7.0.1
 */