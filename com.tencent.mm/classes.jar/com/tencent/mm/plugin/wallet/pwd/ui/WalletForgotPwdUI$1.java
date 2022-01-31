package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class WalletForgotPwdUI$1
  implements View.OnClickListener
{
  WalletForgotPwdUI$1(WalletForgotPwdUI paramWalletForgotPwdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46272);
    h.qsU.e(11353, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    WalletForgotPwdUI.a(this.tZg);
    AppMethodBeat.o(46272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.1
 * JD-Core Version:    0.7.0.1
 */