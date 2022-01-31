package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.wallet_core.ui.e;

final class WalletForgotPwdUI$3
  implements View.OnClickListener
{
  WalletForgotPwdUI$3(WalletForgotPwdUI paramWalletForgotPwdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46274);
    h.qsU.e(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
    paramView = this.tZg;
    s.cRG();
    e.d(paramView, s.cRH().getTrueName());
    AppMethodBeat.o(46274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.3
 * JD-Core Version:    0.7.0.1
 */