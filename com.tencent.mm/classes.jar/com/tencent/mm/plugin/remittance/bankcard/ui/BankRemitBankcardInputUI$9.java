package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;
import java.util.ArrayList;

final class BankRemitBankcardInputUI$9
  implements p.a
{
  BankRemitBankcardInputUI$9(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, com.tencent.mm.plugin.remittance.bankcard.a.m paramm) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(44521);
    BankRemitBankcardInputUI.c(this.qhe, false);
    BankRemitBankcardInputUI.d(this.qhe, this.qhh.qfV.wrw);
    ab.d("MicroMsg.BankRemitBankcardInputUI", "timing_id: %s", new Object[] { BankRemitBankcardInputUI.L(this.qhe) });
    BankRemitBankcardInputUI.a(this.qhe, TransferRecordParcel.cL(this.qhh.qfV.xEB));
    BankRemitBankcardInputUI.b(this.qhe, TransferRecordParcel.cL(this.qhh.qfV.xEA));
    ab.i("MicroMsg.BankRemitBankcardInputUI", "selfList: %d, freqList: %d", new Object[] { Integer.valueOf(BankRemitBankcardInputUI.M(this.qhe).size()), Integer.valueOf(BankRemitBankcardInputUI.N(this.qhe).size()) });
    BankRemitBankcardInputUI.O(this.qhe);
    AppMethodBeat.o(44521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.9
 * JD-Core Version:    0.7.0.1
 */