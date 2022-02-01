package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import java.util.ArrayList;

final class WalletPayUSecurityQuestionSettingUI$1
  implements u.g
{
  WalletPayUSecurityQuestionSettingUI$1(WalletPayUSecurityQuestionSettingUI paramWalletPayUSecurityQuestionSettingUI) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(72223);
    params.clear();
    ArrayList localArrayList = WalletPayUSecurityQuestionSettingUI.a(this.Wea);
    if (localArrayList != null)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        params.add(((PayUSecurityQuestion)localArrayList.get(i)).desc);
        i += 1;
      }
    }
    AppMethodBeat.o(72223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI.1
 * JD-Core Version:    0.7.0.1
 */