package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.a;

final class WalletForgotPwdVerifyIdUI$6
  implements a
{
  WalletForgotPwdVerifyIdUI$6(WalletForgotPwdVerifyIdUI paramWalletForgotPwdVerifyIdUI) {}
  
  public final void gK(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      y.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS visible");
      WalletForgotPwdVerifyIdUI.a(this.qpj, WalletForgotPwdVerifyIdUI.h(this.qpj), WalletForgotPwdVerifyIdUI.a(this.qpj));
      WalletForgotPwdVerifyIdUI.i(this.qpj);
      return;
    }
    y.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS unvisible");
    WalletForgotPwdVerifyIdUI.j(this.qpj);
    WalletForgotPwdVerifyIdUI.h(this.qpj).scrollTo(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.6
 * JD-Core Version:    0.7.0.1
 */