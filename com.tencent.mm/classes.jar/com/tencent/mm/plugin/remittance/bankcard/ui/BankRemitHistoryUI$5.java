package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.ListView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.protocal.c.bhv;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;
import java.util.LinkedList;
import java.util.List;

final class BankRemitHistoryUI$5
  implements n.a
{
  BankRemitHistoryUI$5(BankRemitHistoryUI paramBankRemitHistoryUI, i parami) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.nwH.nuY.tjF != null)
    {
      y.i("MicroMsg.BankRemitHistoryUI", "history size: %s", new Object[] { Integer.valueOf(this.nwH.nuY.tjF.size()) });
      if (this.nwH.nuY.tjF.size() < this.nwH.limit)
      {
        y.i("MicroMsg.BankRemitHistoryUI", "is last: %s", new Object[] { Integer.valueOf(BankRemitHistoryUI.f(this.nwG)) });
        BankRemitHistoryUI.g(this.nwG);
        BankRemitHistoryUI.b(this.nwG).removeFooterView(BankRemitHistoryUI.h(this.nwG));
      }
      if (this.nwH.nuY.tjF != null)
      {
        BankRemitHistoryUI.a(this.nwG, BankRemitHistoryUI.f(this.nwG) + this.nwH.nuY.tjF.size());
        BankRemitHistoryUI.i(this.nwG).addAll(this.nwH.nuY.tjF);
        BankRemitHistoryUI.j(this.nwG).notifyDataSetChanged();
      }
      return;
    }
    y.i("MicroMsg.BankRemitHistoryUI", "return history is null");
    BankRemitHistoryUI.g(this.nwG);
    BankRemitHistoryUI.b(this.nwG).removeFooterView(BankRemitHistoryUI.h(this.nwG));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.5
 * JD-Core Version:    0.7.0.1
 */