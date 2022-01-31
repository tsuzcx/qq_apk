package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.g;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.protocal.protobuf.agp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitBankcardInputUI$6
  implements p.a
{
  BankRemitBankcardInputUI$6(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, g paramg) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44518);
    if (this.qhg.qfP.wrx == null)
    {
      ab.w("MicroMsg.BankRemitBankcardInputUI", "bank_elem is null");
      BankRemitBankcardInputUI.t(this.qhe);
      AppMethodBeat.o(44518);
      return;
    }
    BankRemitBankcardInputUI.a(this.qhe, new BankcardElemParcel(this.qhg.qfP.wrx));
    BankRemitBankcardInputUI.H(this.qhe);
    BankRemitBankcardInputUI.I(this.qhe);
    BankRemitBankcardInputUI.J(this.qhe);
    BankRemitBankcardInputUI.K(this.qhe);
    BankRemitBankcardInputUI.k(this.qhe);
    AppMethodBeat.o(44518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.6
 * JD-Core Version:    0.7.0.1
 */