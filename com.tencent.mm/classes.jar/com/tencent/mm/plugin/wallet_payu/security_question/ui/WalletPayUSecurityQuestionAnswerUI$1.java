package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.widget.Button;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

final class WalletPayUSecurityQuestionAnswerUI$1
  implements WalletFormView.a
{
  WalletPayUSecurityQuestionAnswerUI$1(WalletPayUSecurityQuestionAnswerUI paramWalletPayUSecurityQuestionAnswerUI) {}
  
  public final void gG(boolean paramBoolean)
  {
    WalletPayUSecurityQuestionAnswerUI.a locala = WalletPayUSecurityQuestionAnswerUI.a(this.qOT);
    if (WalletPayUSecurityQuestionAnswerUI.b(locala.qOT).YL()) {}
    for (int i = 1; i != 0; i = 0)
    {
      WalletPayUSecurityQuestionAnswerUI.c(locala.qOT).setEnabled(true);
      return;
    }
    WalletPayUSecurityQuestionAnswerUI.c(locala.qOT).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI.1
 * JD-Core Version:    0.7.0.1
 */