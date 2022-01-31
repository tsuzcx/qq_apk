package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.protocal.protobuf.beu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitSelectPayeeUI$7
  implements p.a
{
  BankRemitSelectPayeeUI$7(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI, j paramj) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44678);
    ab.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[] { Integer.valueOf(this.qiH.qfS.cnK), this.qiH.qfS.kNv });
    if (!bo.isNullOrNil(this.qiH.qfS.kNv)) {
      Toast.makeText(this.qiD, this.qiH.qfS.kNv, 1).show();
    }
    AppMethodBeat.o(44678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.7
 * JD-Core Version:    0.7.0.1
 */