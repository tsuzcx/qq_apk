package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.protocal.protobuf.agr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitSelectBankUI$3
  implements p.a
{
  BankRemitSelectBankUI$3(BankRemitSelectBankUI paramBankRemitSelectBankUI, h paramh) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44665);
    ab.e("MicroMsg.BankRemitSelectBankUI", "response error: %s, %s", new Object[] { Integer.valueOf(this.qiu.qfQ.cnK), this.qiu.qfQ.kNv });
    if (!bo.isNullOrNil(this.qiu.qfQ.kNv)) {
      Toast.makeText(this.qit, this.qiu.qfQ.kNv, 1).show();
    }
    AppMethodBeat.o(44665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI.3
 * JD-Core Version:    0.7.0.1
 */