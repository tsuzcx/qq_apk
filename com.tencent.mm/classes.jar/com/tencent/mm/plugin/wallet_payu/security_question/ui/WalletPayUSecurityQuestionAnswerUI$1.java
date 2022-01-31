package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

final class WalletPayUSecurityQuestionAnswerUI$1
  implements WalletFormView.a
{
  WalletPayUSecurityQuestionAnswerUI$1(WalletPayUSecurityQuestionAnswerUI paramWalletPayUSecurityQuestionAnswerUI) {}
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(48578);
    WalletPayUSecurityQuestionAnswerUI.a locala = WalletPayUSecurityQuestionAnswerUI.a(this.uEa);
    if (WalletPayUSecurityQuestionAnswerUI.b(locala.uEa).asv()) {}
    for (int i = 1; i != 0; i = 0)
    {
      WalletPayUSecurityQuestionAnswerUI.c(locala.uEa).setEnabled(true);
      AppMethodBeat.o(48578);
      return;
    }
    WalletPayUSecurityQuestionAnswerUI.c(locala.uEa).setEnabled(false);
    AppMethodBeat.o(48578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI.1
 * JD-Core Version:    0.7.0.1
 */