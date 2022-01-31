package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ui.ap;

final class WalletForgotPwdVerifyIdUI$3
  implements Runnable
{
  WalletForgotPwdVerifyIdUI$3(WalletForgotPwdVerifyIdUI paramWalletForgotPwdVerifyIdUI) {}
  
  public final void run()
  {
    WalletForgotPwdVerifyIdUI.b(this.qpj).setVisibility(8);
    WalletForgotPwdVerifyIdUI.c(this.qpj).setVisibility(8);
    this.qpj.qpc = ((ViewGroup.MarginLayoutParams)WalletForgotPwdVerifyIdUI.d(this.qpj).getLayoutParams());
    this.qpj.qpc.topMargin = ap.fromDPToPix(this.qpj, 47);
    WalletForgotPwdVerifyIdUI.d(this.qpj).setLayoutParams(this.qpj.qpc);
    this.qpj.qpd = ((ViewGroup.MarginLayoutParams)WalletForgotPwdVerifyIdUI.e(this.qpj).getLayoutParams());
    this.qpj.qpd.topMargin = ap.fromDPToPix(this.qpj, 48);
    WalletForgotPwdVerifyIdUI.e(this.qpj).setLayoutParams(this.qpj.qpd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.3
 * JD-Core Version:    0.7.0.1
 */