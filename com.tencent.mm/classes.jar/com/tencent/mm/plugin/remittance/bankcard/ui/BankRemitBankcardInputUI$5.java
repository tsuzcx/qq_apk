package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.g;
import com.tencent.mm.protocal.c.abx;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitBankcardInputUI$5
  implements n.a
{
  BankRemitBankcardInputUI$5(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, g paramg) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.e("MicroMsg.BankRemitBankcardInputUI", "bank info reponse error: %s, msg: %s", new Object[] { Integer.valueOf(this.nwf.nuW.iHq), this.nwf.nuW.iHr });
    BankRemitBankcardInputUI.q(this.nwd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.5
 * JD-Core Version:    0.7.0.1
 */