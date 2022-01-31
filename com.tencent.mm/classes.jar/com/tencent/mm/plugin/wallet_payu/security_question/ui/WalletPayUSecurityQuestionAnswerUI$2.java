package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletPayUSecurityQuestionAnswerUI$2
  implements View.OnClickListener
{
  WalletPayUSecurityQuestionAnswerUI$2(WalletPayUSecurityQuestionAnswerUI paramWalletPayUSecurityQuestionAnswerUI) {}
  
  public final void onClick(View paramView)
  {
    if (WalletPayUSecurityQuestionAnswerUI.b(this.qOT).YL())
    {
      this.qOT.BX.putString("key_question_answer", WalletPayUSecurityQuestionAnswerUI.b(this.qOT).getText());
      this.qOT.cNk().m(new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI.2
 * JD-Core Version:    0.7.0.1
 */