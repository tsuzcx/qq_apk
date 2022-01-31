package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;

final class WalletPayUSecurityQuestionSettingUI$2
  implements n.d
{
  WalletPayUSecurityQuestionSettingUI$2(WalletPayUSecurityQuestionSettingUI paramWalletPayUSecurityQuestionSettingUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    WalletPayUSecurityQuestionSettingUI.b(this.qOX).setQuestionText(((PayUSecurityQuestion)WalletPayUSecurityQuestionSettingUI.a(this.qOX).get(paramInt)).desc);
    WalletPayUSecurityQuestionSettingUI.a(this.qOX, ((PayUSecurityQuestion)WalletPayUSecurityQuestionSettingUI.a(this.qOX).get(paramInt)).id);
    WalletPayUSecurityQuestionSettingUI.c(this.qOX).bvr();
    WalletPayUSecurityQuestionSettingUI.a.a(WalletPayUSecurityQuestionSettingUI.d(this.qOX));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI.2
 * JD-Core Version:    0.7.0.1
 */