package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletPayUSecurityQuestionSettingUI$5
  implements View.OnClickListener
{
  WalletPayUSecurityQuestionSettingUI$5(WalletPayUSecurityQuestionSettingUI paramWalletPayUSecurityQuestionSettingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48586);
    if (WalletPayUSecurityQuestionSettingUI.d(this.uEe).cXs())
    {
      this.uEe.getInput().putString("key_question_id", WalletPayUSecurityQuestionSettingUI.f(this.uEe));
      this.uEe.getInput().putString("key_question_answer", WalletPayUSecurityQuestionSettingUI.c(this.uEe).getText());
      a.j(this.uEe, this.uEe.getInput());
      AppMethodBeat.o(48586);
      return;
    }
    WalletPayUSecurityQuestionSettingUI.a.a(WalletPayUSecurityQuestionSettingUI.d(this.uEe));
    AppMethodBeat.o(48586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI.5
 * JD-Core Version:    0.7.0.1
 */