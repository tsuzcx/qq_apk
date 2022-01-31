package com.tencent.mm.plugin.wallet.pwd.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;

final class WalletForgotPwdVerifyIdUI$4
  implements TextWatcher
{
  WalletForgotPwdVerifyIdUI$4(WalletForgotPwdVerifyIdUI paramWalletForgotPwdVerifyIdUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(46309);
    ab.i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveNameext：" + WalletForgotPwdVerifyIdUI.b(this.tZw).getText());
    if ((WalletForgotPwdVerifyIdUI.b(this.tZw).getText() == null) || ("".equals(WalletForgotPwdVerifyIdUI.b(this.tZw).getText().toString()))) {
      WalletForgotPwdVerifyIdUI.a(this.tZw, false);
    }
    for (;;)
    {
      WalletForgotPwdVerifyIdUI.g(this.tZw);
      AppMethodBeat.o(46309);
      return;
      WalletForgotPwdVerifyIdUI.a(this.tZw, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.4
 * JD-Core Version:    0.7.0.1
 */