package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.remittance.bankcard.b.j;
import com.tencent.mm.protocal.protobuf.dqo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.r.a;

final class BankRemitSelectPayeeUI$7
  implements r.a
{
  BankRemitSelectPayeeUI$7(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI, j paramj) {}
  
  public final void c(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(67591);
    Log.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[] { Integer.valueOf(this.Ofo.Ocj.hAV), this.Ofo.Ocj.wYI });
    if (!Util.isNullOrNil(this.Ofo.Ocj.wYI)) {
      Toast.makeText(this.Ofk, this.Ofo.Ocj.wYI, 1).show();
    }
    AppMethodBeat.o(67591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.7
 * JD-Core Version:    0.7.0.1
 */