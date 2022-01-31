package com.tencent.mm.plugin.wallet.pwd.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletForgotPwdVerifyIdUI$5
  implements TextWatcher
{
  WalletForgotPwdVerifyIdUI$5(WalletForgotPwdVerifyIdUI paramWalletForgotPwdVerifyIdUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (WalletForgotPwdVerifyIdUI.a(this.qpj).getText() != null) {
      WalletForgotPwdVerifyIdUI.b(this.qpj, true);
    }
    for (;;)
    {
      WalletForgotPwdVerifyIdUI.g(this.qpj);
      return;
      WalletForgotPwdVerifyIdUI.b(this.qpj, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.5
 * JD-Core Version:    0.7.0.1
 */