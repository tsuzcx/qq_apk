package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.bankcard.a.f;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.r.a;

final class BankRemitSelectPayeeUI$10
  implements r.a
{
  BankRemitSelectPayeeUI$10(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI, f paramf) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67594);
    ae.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[] { Integer.valueOf(this.ykH.yhM.dmy), this.ykH.yhM.phe });
    if (!bu.isNullOrNil(this.ykH.yhM.phe)) {
      Toast.makeText(this.ykG, this.ykH.yhM.phe, 1).show();
    }
    AppMethodBeat.o(67594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.10
 * JD-Core Version:    0.7.0.1
 */