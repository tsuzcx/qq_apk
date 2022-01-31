package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletPayUSecurityQuestionAnswerUI$2
  implements View.OnClickListener
{
  WalletPayUSecurityQuestionAnswerUI$2(WalletPayUSecurityQuestionAnswerUI paramWalletPayUSecurityQuestionAnswerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48579);
    if (WalletPayUSecurityQuestionAnswerUI.b(this.uEa).asv())
    {
      this.uEa.getInput().putString("key_question_answer", WalletPayUSecurityQuestionAnswerUI.b(this.uEa).getText());
      this.uEa.getNetController().p(new Object[0]);
    }
    AppMethodBeat.o(48579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI.2
 * JD-Core Version:    0.7.0.1
 */