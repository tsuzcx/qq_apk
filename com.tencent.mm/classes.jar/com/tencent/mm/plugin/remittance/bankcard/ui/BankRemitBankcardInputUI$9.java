package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;
import java.util.ArrayList;

final class BankRemitBankcardInputUI$9
  implements n.a
{
  BankRemitBankcardInputUI$9(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, com.tencent.mm.plugin.remittance.bankcard.a.m paramm) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    BankRemitBankcardInputUI.b(this.nwd, false);
    BankRemitBankcardInputUI.b(this.nwd, this.nwg.nvc.sxT);
    y.d("MicroMsg.BankRemitBankcardInputUI", "timing_id: %s", new Object[] { BankRemitBankcardInputUI.A(this.nwd) });
    BankRemitBankcardInputUI.a(this.nwd, TransferRecordParcel.ci(this.nwg.nvc.tCy));
    BankRemitBankcardInputUI.b(this.nwd, TransferRecordParcel.ci(this.nwg.nvc.tCx));
    y.i("MicroMsg.BankRemitBankcardInputUI", "selfList: %d, freqList: %d", new Object[] { Integer.valueOf(BankRemitBankcardInputUI.B(this.nwd).size()), Integer.valueOf(BankRemitBankcardInputUI.C(this.nwd).size()) });
    BankRemitBankcardInputUI.D(this.nwd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.9
 * JD-Core Version:    0.7.0.1
 */