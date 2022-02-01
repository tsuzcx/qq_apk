package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.remittance.bankcard.b.h;
import com.tencent.mm.protocal.protobuf.cfa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.r.a;

final class BankRemitSelectBankUI$3
  implements r.a
{
  BankRemitSelectBankUI$3(BankRemitSelectBankUI paramBankRemitSelectBankUI, h paramh) {}
  
  public final void c(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(67578);
    Log.e("MicroMsg.BankRemitSelectBankUI", "response error: %s, %s", new Object[] { Integer.valueOf(this.Ofb.Och.hAV), this.Ofb.Och.wYI });
    if (!Util.isNullOrNil(this.Ofb.Och.wYI)) {
      Toast.makeText(this.Ofa, this.Ofb.Och.wYI, 1).show();
    }
    AppMethodBeat.o(67578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI.3
 * JD-Core Version:    0.7.0.1
 */