package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.g;
import com.tencent.mm.protocal.protobuf.agp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitBankcardInputUI$5
  implements p.a
{
  BankRemitBankcardInputUI$5(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, g paramg) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44517);
    ab.e("MicroMsg.BankRemitBankcardInputUI", "bank info reponse error: %s, msg: %s", new Object[] { Integer.valueOf(this.qhg.qfP.cnK), this.qhg.qfP.kNv });
    BankRemitBankcardInputUI.t(this.qhe);
    AppMethodBeat.o(44517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.5
 * JD-Core Version:    0.7.0.1
 */