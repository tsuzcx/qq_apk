package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitDetailUI$5
  implements p.a
{
  BankRemitDetailUI$5(BankRemitDetailUI paramBankRemitDetailUI, l paraml) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44598);
    ab.i("MicroMsg.BankRemitDetailUI", "state: %s, amount: %s, fee: %s, account: %s", new Object[] { Integer.valueOf(this.qhF.qfU.state), Integer.valueOf(this.qhF.qfU.okH), Integer.valueOf(this.qhF.qfU.xEu), this.qhF.qfU.xEv });
    BankRemitDetailUI.a(this.qhE, this.qhF.qfU.state);
    BankRemitDetailUI.a(this.qhE, this.qhF.qfU.state, this.qhF.qfU.xEt);
    BankRemitDetailUI.a(this.qhE, this.qhF.qfU);
    BankRemitDetailUI.a(this.qhE).setVisibility(0);
    AppMethodBeat.o(44598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI.5
 * JD-Core Version:    0.7.0.1
 */