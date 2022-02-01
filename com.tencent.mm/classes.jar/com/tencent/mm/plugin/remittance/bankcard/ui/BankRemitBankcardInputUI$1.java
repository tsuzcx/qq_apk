package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.g.a.yo.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;

final class BankRemitBankcardInputUI$1
  implements Runnable
{
  BankRemitBankcardInputUI$1(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, yo paramyo) {}
  
  public final void run()
  {
    AppMethodBeat.i(67422);
    if (!bu.isNullOrNil(this.pmv.dNS.dNT)) {
      f.a((TextView)this.yjd.findViewById(2131297186), this.pmv.dNS.dNT, this.pmv.dNS.content, this.pmv.dNS.url);
    }
    AppMethodBeat.o(67422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.1
 * JD-Core Version:    0.7.0.1
 */