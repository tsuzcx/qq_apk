package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aba;
import com.tencent.mm.f.a.aba.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;

final class BankRemitBankcardInputUI$1
  implements Runnable
{
  BankRemitBankcardInputUI$1(BankRemitBankcardInputUI paramBankRemitBankcardInputUI, aba paramaba) {}
  
  public final void run()
  {
    AppMethodBeat.i(67422);
    if (!Util.isNullOrNil(this.uaN.gad.gae)) {
      g.a((TextView)this.IgX.findViewById(a.f.banner_tips), this.uaN.gad.gae, this.uaN.gad.content, this.uaN.gad.url);
    }
    AppMethodBeat.o(67422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.1
 * JD-Core Version:    0.7.0.1
 */