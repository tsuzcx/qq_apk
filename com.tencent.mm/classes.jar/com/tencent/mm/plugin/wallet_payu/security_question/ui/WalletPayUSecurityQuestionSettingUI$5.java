package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletPayUSecurityQuestionSettingUI$5
  implements View.OnClickListener
{
  WalletPayUSecurityQuestionSettingUI$5(WalletPayUSecurityQuestionSettingUI paramWalletPayUSecurityQuestionSettingUI) {}
  
  public final void onClick(View paramView)
  {
    if (WalletPayUSecurityQuestionSettingUI.d(this.qOX).bXK())
    {
      this.qOX.BX.putString("key_question_id", WalletPayUSecurityQuestionSettingUI.f(this.qOX));
      this.qOX.BX.putString("key_question_answer", WalletPayUSecurityQuestionSettingUI.c(this.qOX).getText());
      a.j(this.qOX, this.qOX.BX);
      return;
    }
    WalletPayUSecurityQuestionSettingUI.a.a(WalletPayUSecurityQuestionSettingUI.d(this.qOX));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI.5
 * JD-Core Version:    0.7.0.1
 */