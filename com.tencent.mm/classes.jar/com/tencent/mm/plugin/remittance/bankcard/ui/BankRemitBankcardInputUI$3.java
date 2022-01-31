package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.a;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitBankcardInputUI$3
  implements n.a
{
  BankRemitBankcardInputUI$3(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, a parama) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    BankRemitBankcardInputUI.a(this.nwd, this.nwe.nuQ.sxV);
    BankRemitBankcardInputUI.a(this.nwd, new BankcardElemParcel(this.nwe.nuQ.sxU));
    if (BankRemitBankcardInputUI.s(this.nwd) != null) {}
    for (paramString = BankRemitBankcardInputUI.s(this.nwd).lnT;; paramString = "")
    {
      y.i("MicroMsg.BankRemitBankcardInputUI", "response bank: %s", new Object[] { paramString });
      BankRemitBankcardInputUI.w(this.nwd);
      BankRemitBankcardInputUI.x(this.nwd);
      BankRemitBankcardInputUI.y(this.nwd);
      BankRemitBankcardInputUI.z(this.nwd);
      BankRemitBankcardInputUI.k(this.nwd);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.3
 * JD-Core Version:    0.7.0.1
 */