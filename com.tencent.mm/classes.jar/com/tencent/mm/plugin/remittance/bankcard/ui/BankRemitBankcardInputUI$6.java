package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.g;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.protocal.c.abx;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitBankcardInputUI$6
  implements n.a
{
  BankRemitBankcardInputUI$6(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, g paramg) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.nwf.nuW.sxU == null)
    {
      y.w("MicroMsg.BankRemitBankcardInputUI", "bank_elem is null");
      BankRemitBankcardInputUI.q(this.nwd);
      return;
    }
    BankRemitBankcardInputUI.a(this.nwd, new BankcardElemParcel(this.nwf.nuW.sxU));
    BankRemitBankcardInputUI.w(this.nwd);
    BankRemitBankcardInputUI.x(this.nwd);
    BankRemitBankcardInputUI.y(this.nwd);
    BankRemitBankcardInputUI.z(this.nwd);
    BankRemitBankcardInputUI.k(this.nwd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.6
 * JD-Core Version:    0.7.0.1
 */