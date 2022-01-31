package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.sdk.platformtools.y;

final class WalletForgotPwdVerifyIdUI$7
  implements View.OnFocusChangeListener
{
  WalletForgotPwdVerifyIdUI$7(WalletForgotPwdVerifyIdUI paramWalletForgotPwdVerifyIdUI) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      y.i("MicroMsg.WalletForgotPwdVerifyIdUI", " has focus");
      WalletForgotPwdVerifyIdUI.i(this.qpj);
      return;
    }
    y.i("MicroMsg.WalletForgotPwdVerifyIdUI", " lose focus");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.7
 * JD-Core Version:    0.7.0.1
 */