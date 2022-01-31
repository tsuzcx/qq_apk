package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;

final class WalletForgotPwdVerifyIdUI$3
  implements Runnable
{
  WalletForgotPwdVerifyIdUI$3(WalletForgotPwdVerifyIdUI paramWalletForgotPwdVerifyIdUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(46308);
    WalletForgotPwdVerifyIdUI.c(this.tZw).setVisibility(8);
    WalletForgotPwdVerifyIdUI.d(this.tZw).setVisibility(8);
    this.tZw.tZp = ((ViewGroup.MarginLayoutParams)WalletForgotPwdVerifyIdUI.e(this.tZw).getLayoutParams());
    this.tZw.tZp.topMargin = al.fromDPToPix(this.tZw, 47);
    WalletForgotPwdVerifyIdUI.e(this.tZw).setLayoutParams(this.tZw.tZp);
    this.tZw.tZq = ((ViewGroup.MarginLayoutParams)WalletForgotPwdVerifyIdUI.f(this.tZw).getLayoutParams());
    this.tZw.tZq.topMargin = al.fromDPToPix(this.tZw, 48);
    WalletForgotPwdVerifyIdUI.f(this.tZw).setLayoutParams(this.tZw.tZq);
    AppMethodBeat.o(46308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.3
 * JD-Core Version:    0.7.0.1
 */