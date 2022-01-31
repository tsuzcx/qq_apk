package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vd.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class BankRemitBankcardInputUI$1
  implements Runnable
{
  BankRemitBankcardInputUI$1(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, vd paramvd) {}
  
  public final void run()
  {
    AppMethodBeat.i(44513);
    if (!bo.isNullOrNil(this.kSA.cLF.cLG)) {
      e.a((TextView)this.qhe.findViewById(2131821672), this.kSA.cLF.cLG, this.kSA.cLF.content, this.kSA.cLF.url);
    }
    AppMethodBeat.o(44513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.1
 * JD-Core Version:    0.7.0.1
 */