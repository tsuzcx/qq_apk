package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletForgotPwdVerifyIdUI$7
  implements View.OnFocusChangeListener
{
  WalletForgotPwdVerifyIdUI$7(WalletForgotPwdVerifyIdUI paramWalletForgotPwdVerifyIdUI) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(46312);
    if (paramBoolean)
    {
      ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " has focus");
      WalletForgotPwdVerifyIdUI.i(this.tZw);
      AppMethodBeat.o(46312);
      return;
    }
    ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " lose focus");
    AppMethodBeat.o(46312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.7
 * JD-Core Version:    0.7.0.1
 */