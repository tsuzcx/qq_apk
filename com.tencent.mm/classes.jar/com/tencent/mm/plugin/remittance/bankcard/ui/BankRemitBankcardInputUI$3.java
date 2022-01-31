package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.a;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.protocal.protobuf.fj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitBankcardInputUI$3
  implements p.a
{
  BankRemitBankcardInputUI$3(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, a parama) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44515);
    BankRemitBankcardInputUI.c(this.qhe, this.qhf.qfJ.wry);
    BankRemitBankcardInputUI.a(this.qhe, new BankcardElemParcel(this.qhf.qfJ.wrx));
    if (BankRemitBankcardInputUI.v(this.qhe) != null) {}
    for (paramString = BankRemitBankcardInputUI.v(this.qhe).nLq;; paramString = "")
    {
      ab.i("MicroMsg.BankRemitBankcardInputUI", "response bank: %s", new Object[] { paramString });
      BankRemitBankcardInputUI.H(this.qhe);
      BankRemitBankcardInputUI.I(this.qhe);
      BankRemitBankcardInputUI.J(this.qhe);
      BankRemitBankcardInputUI.K(this.qhe);
      BankRemitBankcardInputUI.k(this.qhe);
      AppMethodBeat.o(44515);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.3
 * JD-Core Version:    0.7.0.1
 */