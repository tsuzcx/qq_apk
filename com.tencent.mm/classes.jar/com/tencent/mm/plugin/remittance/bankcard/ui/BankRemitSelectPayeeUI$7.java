package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.r.a;

final class BankRemitSelectPayeeUI$7
  implements r.a
{
  BankRemitSelectPayeeUI$7(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI, j paramj) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67591);
    ae.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[] { Integer.valueOf(this.ykK.yhQ.dmy), this.ykK.yhQ.phe });
    if (!bu.isNullOrNil(this.ykK.yhQ.phe)) {
      Toast.makeText(this.ykG, this.ykK.yhQ.phe, 1).show();
    }
    AppMethodBeat.o(67591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.7
 * JD-Core Version:    0.7.0.1
 */