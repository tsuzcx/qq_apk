package com.tencent.mm.plugin.wallet.pwd.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

final class WalletForgotPwdVerifyIdUI$4
  implements TextWatcher
{
  WalletForgotPwdVerifyIdUI$4(WalletForgotPwdVerifyIdUI paramWalletForgotPwdVerifyIdUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveNameext：" + WalletForgotPwdVerifyIdUI.f(this.qpj).getText());
    if ((WalletForgotPwdVerifyIdUI.f(this.qpj).getText() == null) || ("".equals(WalletForgotPwdVerifyIdUI.f(this.qpj).getText().toString()))) {
      WalletForgotPwdVerifyIdUI.a(this.qpj, false);
    }
    for (;;)
    {
      WalletForgotPwdVerifyIdUI.g(this.qpj);
      return;
      WalletForgotPwdVerifyIdUI.a(this.qpj, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.4
 * JD-Core Version:    0.7.0.1
 */