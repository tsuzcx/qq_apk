package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.a;
import com.tencent.mm.protocal.protobuf.fj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitBankcardInputUI$2
  implements p.a
{
  BankRemitBankcardInputUI$2(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, a parama) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44514);
    ab.e("MicroMsg.BankRemitBankcardInputUI", "appoint reponse error: %s, msg: %s", new Object[] { Integer.valueOf(this.qhf.qfJ.cnK), this.qhf.qfJ.kNv });
    if (!bo.isNullOrNil(this.qhf.qfJ.kNv)) {
      Toast.makeText(this.qhe, this.qhf.qfJ.kNv, 1).show();
    }
    AppMethodBeat.o(44514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.2
 * JD-Core Version:    0.7.0.1
 */