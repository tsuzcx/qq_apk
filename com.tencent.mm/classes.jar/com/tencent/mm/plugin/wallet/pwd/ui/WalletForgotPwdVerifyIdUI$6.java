package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.a;

final class WalletForgotPwdVerifyIdUI$6
  implements a
{
  WalletForgotPwdVerifyIdUI$6(WalletForgotPwdVerifyIdUI paramWalletForgotPwdVerifyIdUI) {}
  
  public final void onVisibleStateChange(boolean paramBoolean)
  {
    AppMethodBeat.i(46311);
    if (paramBoolean)
    {
      ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS visible");
      WalletForgotPwdVerifyIdUI.a(this.tZw, WalletForgotPwdVerifyIdUI.h(this.tZw), WalletForgotPwdVerifyIdUI.a(this.tZw));
      WalletForgotPwdVerifyIdUI.i(this.tZw);
      AppMethodBeat.o(46311);
      return;
    }
    ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS unvisible");
    WalletForgotPwdVerifyIdUI.j(this.tZw);
    WalletForgotPwdVerifyIdUI.h(this.tZw).scrollTo(0, 0);
    AppMethodBeat.o(46311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.6
 * JD-Core Version:    0.7.0.1
 */