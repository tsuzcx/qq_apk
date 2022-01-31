package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.l;

final class BankRemitSelectPayeeUI$3
  implements AdapterView.OnItemLongClickListener
{
  BankRemitSelectPayeeUI$3(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44673);
    BankRemitSelectPayeeUI.b(this.qiD).a(paramView, paramInt, paramLong, this.qiD, this.qiD);
    AppMethodBeat.o(44673);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.3
 * JD-Core Version:    0.7.0.1
 */