package com.tencent.mm.plugin.wallet.pwd.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletForgotPwdVerifyIdUI$5
  implements TextWatcher
{
  WalletForgotPwdVerifyIdUI$5(WalletForgotPwdVerifyIdUI paramWalletForgotPwdVerifyIdUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(46310);
    if (WalletForgotPwdVerifyIdUI.a(this.tZw).getText() != null) {
      WalletForgotPwdVerifyIdUI.b(this.tZw, true);
    }
    for (;;)
    {
      WalletForgotPwdVerifyIdUI.g(this.tZw);
      AppMethodBeat.o(46310);
      return;
      WalletForgotPwdVerifyIdUI.b(this.tZw, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.5
 * JD-Core Version:    0.7.0.1
 */