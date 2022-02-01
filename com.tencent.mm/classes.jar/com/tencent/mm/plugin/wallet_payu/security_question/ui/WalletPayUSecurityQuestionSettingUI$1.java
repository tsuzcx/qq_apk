package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import java.util.ArrayList;

final class WalletPayUSecurityQuestionSettingUI$1
  implements q.f
{
  WalletPayUSecurityQuestionSettingUI$1(WalletPayUSecurityQuestionSettingUI paramWalletPayUSecurityQuestionSettingUI) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(72223);
    paramo.clear();
    ArrayList localArrayList = WalletPayUSecurityQuestionSettingUI.a(this.PnB);
    if (localArrayList != null)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        paramo.add(((PayUSecurityQuestion)localArrayList.get(i)).desc);
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