package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.protocal.c.blo;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitMoneyInputUI$6
  implements n.a
{
  BankRemitMoneyInputUI$6(BankRemitMoneyInputUI paramBankRemitMoneyInputUI, n paramn) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", new Object[] { Integer.valueOf(this.nxj.nvd.iHq), this.nxj.nvd.iHr });
    BankRemitMoneyInputUI.a(this.nxh, this.nxj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.6
 * JD-Core Version:    0.7.0.1
 */