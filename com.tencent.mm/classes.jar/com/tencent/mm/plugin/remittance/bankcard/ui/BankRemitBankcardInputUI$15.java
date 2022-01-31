package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitBankcardInputUI$15
  implements p.a
{
  BankRemitBankcardInputUI$15(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, k paramk) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44529);
    ab.e("MicroMsg.BankRemitBankcardInputUI", "operation response error: %s, %s", new Object[] { Integer.valueOf(this.qhk.qfT.cnK), this.qhk.qfT.kNv });
    if (!bo.isNullOrNil(this.qhk.qfT.kNv)) {
      Toast.makeText(this.qhe, this.qhk.qfT.kNv, 1).show();
    }
    this.qhe.finish();
    AppMethodBeat.o(44529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.15
 * JD-Core Version:    0.7.0.1
 */