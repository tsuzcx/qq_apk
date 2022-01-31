package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.protocal.c.bhv;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitHistoryUI$4
  implements n.a
{
  BankRemitHistoryUI$4(BankRemitHistoryUI paramBankRemitHistoryUI, i parami) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.e("MicroMsg.BankRemitHistoryUI", "history response error: %s, %s", new Object[] { Integer.valueOf(this.nwH.nuY.iHq), this.nwH.nuY.iHr });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.4
 * JD-Core Version:    0.7.0.1
 */