package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class BankRemitBankcardInputUI$7
  implements n.a
{
  BankRemitBankcardInputUI$7(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramm });
    BankRemitBankcardInputUI.b(this.nwd, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.7
 * JD-Core Version:    0.7.0.1
 */