package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitBankcardInputUI$16
  implements p.a
{
  BankRemitBankcardInputUI$16(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, k paramk) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44530);
    if ((BankRemitBankcardInputUI.B(this.qhe) != null) && (BankRemitBankcardInputUI.B(this.qhe).isShowing())) {
      BankRemitBankcardInputUI.B(this.qhe).dismiss();
    }
    BankRemitBankcardInputUI.P(this.qhe);
    BankRemitBankcardInputUI.C(this.qhe);
    BankRemitBankcardInputUI.h(this.qhe, this.qhk.qfT.xxU);
    BankRemitBankcardInputUI.i(this.qhe, this.qhk.qfT.xxV);
    ab.i("MicroMsg.BankRemitBankcardInputUI", "set uniqueId:%s", new Object[] { BankRemitBankcardInputUI.Q(this.qhe) });
    BankRemitBankcardInputUI.a(this.qhe, this.qhk.qfT.xxW);
    ab.d("MicroMsg.BankRemitBankcardInputUI", "set nameLenLimit:%s", new Object[] { Integer.valueOf(BankRemitBankcardInputUI.o(this.qhe)) });
    if (BankRemitBankcardInputUI.z(this.qhe))
    {
      if (BankRemitBankcardInputUI.y(this.qhe))
      {
        if (BankRemitBankcardInputUI.i(this.qhe))
        {
          ab.i("MicroMsg.BankRemitBankcardInputUI", "NetSceneBankRemitOperation: from record goto next direct");
          BankRemitBankcardInputUI.A(this.qhe);
        }
        for (;;)
        {
          BankRemitBankcardInputUI.b(this.qhe, false);
          AppMethodBeat.o(44530);
          return;
          BankRemitBankcardInputUI.b(this.qhe, BankRemitBankcardInputUI.v(this.qhe).nLq, BankRemitBankcardInputUI.v(this.qhe).poq);
        }
      }
    }
    else {
      BankRemitBankcardInputUI.k(this.qhe);
    }
    AppMethodBeat.o(44530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.16
 * JD-Core Version:    0.7.0.1
 */