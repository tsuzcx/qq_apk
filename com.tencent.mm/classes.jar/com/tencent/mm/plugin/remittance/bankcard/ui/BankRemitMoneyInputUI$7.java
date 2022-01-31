package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.protocal.c.blo;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitMoneyInputUI$7
  implements n.a
{
  BankRemitMoneyInputUI$7(BankRemitMoneyInputUI paramBankRemitMoneyInputUI, n paramn) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", new Object[] { this.nxj.nvd.lRA, this.nxj.nvd.sFw });
    y.d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", new Object[] { this.nxj.nvd.nvA, this.nxj.nvd.lnT });
    BankRemitMoneyInputUI.b(this.nxh, this.nxj.nvd.sFw);
    if (!BankRemitMoneyInputUI.a(this.nxh, this.nxj)) {
      BankRemitMoneyInputUI.a(this.nxh, this.nxj.nvd.lRA, this.nxj.nvd.nvA, this.nxj.nvd.lnT, this.nxj.nvd.nvz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.7
 * JD-Core Version:    0.7.0.1
 */