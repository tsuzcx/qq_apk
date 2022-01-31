package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(48583);
    WalletPayUSecurityQuestionSettingUI.b(this.uEe).setQuestionText(((PayUSecurityQuestion)WalletPayUSecurityQuestionSettingUI.a(this.uEe).get(paramInt)).desc);
    WalletPayUSecurityQuestionSettingUI.a(this.uEe, ((PayUSecurityQuestion)WalletPayUSecurityQuestionSettingUI.a(this.uEe).get(paramInt)).id);
    WalletPayUSecurityQuestionSettingUI.c(this.uEe).cfK();
    WalletPayUSecurityQuestionSettingUI.a.a(WalletPayUSecurityQuestionSettingUI.d(this.uEe));
    AppMethodBeat.o(48583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI.2
 * JD-Core Version:    0.7.0.1
 */