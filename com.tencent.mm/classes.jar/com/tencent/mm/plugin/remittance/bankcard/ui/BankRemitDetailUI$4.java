package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitDetailUI$4
  implements p.a
{
  BankRemitDetailUI$4(BankRemitDetailUI paramBankRemitDetailUI, l paraml) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44597);
    ab.e("MicroMsg.BankRemitDetailUI", "detail reponse error: %s, %s", new Object[] { Integer.valueOf(this.qhF.qfU.cnK), this.qhF.qfU.kNv });
    if (!bo.isNullOrNil(this.qhF.qfU.kNv))
    {
      Toast.makeText(this.qhE, this.qhF.qfU.kNv, 1).show();
      AppMethodBeat.o(44597);
      return;
    }
    Toast.makeText(this.qhE, 2131297477, 1).show();
    AppMethodBeat.o(44597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI.4
 * JD-Core Version:    0.7.0.1
 */