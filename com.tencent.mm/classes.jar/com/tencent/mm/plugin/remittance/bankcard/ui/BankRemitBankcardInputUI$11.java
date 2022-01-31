package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.d;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitBankcardInputUI$11
  implements p.a
{
  BankRemitBankcardInputUI$11(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, d paramd) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44523);
    ab.e("MicroMsg.BankRemitBankcardInputUI", "check response error: %s, %s", new Object[] { Integer.valueOf(this.qhi.qfM.cnK), this.qhi.qfM.kNv });
    if (!bo.isNullOrNil(this.qhi.qfM.kNv)) {
      Toast.makeText(this.qhe, this.qhi.qfM.kNv, 1).show();
    }
    AppMethodBeat.o(44523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.11
 * JD-Core Version:    0.7.0.1
 */