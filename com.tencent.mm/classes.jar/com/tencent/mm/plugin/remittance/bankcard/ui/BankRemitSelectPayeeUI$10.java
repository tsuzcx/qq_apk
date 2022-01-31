package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.f;
import com.tencent.mm.protocal.protobuf.ya;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitSelectPayeeUI$10
  implements p.a
{
  BankRemitSelectPayeeUI$10(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI, f paramf) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44681);
    ab.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[] { Integer.valueOf(this.qiE.qfO.cnK), this.qiE.qfO.kNv });
    if (!bo.isNullOrNil(this.qiE.qfO.kNv)) {
      Toast.makeText(this.qiD, this.qiE.qfO.kNv, 1).show();
    }
    AppMethodBeat.o(44681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.10
 * JD-Core Version:    0.7.0.1
 */