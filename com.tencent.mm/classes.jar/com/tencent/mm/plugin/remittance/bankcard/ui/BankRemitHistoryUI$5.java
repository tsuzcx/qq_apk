package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.protocal.protobuf.bqf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;
import java.util.LinkedList;
import java.util.List;

final class BankRemitHistoryUI$5
  implements p.a
{
  BankRemitHistoryUI$5(BankRemitHistoryUI paramBankRemitHistoryUI, i parami) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44610);
    if (this.qhJ.qfR.xis != null)
    {
      ab.i("MicroMsg.BankRemitHistoryUI", "history size: %s", new Object[] { Integer.valueOf(this.qhJ.qfR.xis.size()) });
      if (this.qhJ.qfR.xis.size() < this.qhJ.limit)
      {
        ab.i("MicroMsg.BankRemitHistoryUI", "is last: %s", new Object[] { Integer.valueOf(BankRemitHistoryUI.f(this.qhI)) });
        BankRemitHistoryUI.g(this.qhI);
        BankRemitHistoryUI.b(this.qhI).removeFooterView(BankRemitHistoryUI.h(this.qhI));
      }
      if (this.qhJ.qfR.xis != null)
      {
        BankRemitHistoryUI.a(this.qhI, BankRemitHistoryUI.f(this.qhI) + this.qhJ.qfR.xis.size());
        BankRemitHistoryUI.i(this.qhI).addAll(this.qhJ.qfR.xis);
        BankRemitHistoryUI.j(this.qhI).notifyDataSetChanged();
        AppMethodBeat.o(44610);
      }
    }
    else
    {
      ab.i("MicroMsg.BankRemitHistoryUI", "return history is null");
      BankRemitHistoryUI.g(this.qhI);
      BankRemitHistoryUI.b(this.qhI).removeFooterView(BankRemitHistoryUI.h(this.qhI));
    }
    AppMethodBeat.o(44610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.5
 * JD-Core Version:    0.7.0.1
 */