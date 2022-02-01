package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.remittance.bankcard.b.f;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.r.a;

final class BankRemitSelectPayeeUI$10
  implements r.a
{
  BankRemitSelectPayeeUI$10(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI, f paramf) {}
  
  public final void c(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(67594);
    Log.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[] { Integer.valueOf(this.Ofl.Ocf.hAV), this.Ofl.Ocf.wYI });
    if (!Util.isNullOrNil(this.Ofl.Ocf.wYI)) {
      Toast.makeText(this.Ofk, this.Ofl.Ocf.wYI, 1).show();
    }
    AppMethodBeat.o(67594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.10
 * JD-Core Version:    0.7.0.1
 */