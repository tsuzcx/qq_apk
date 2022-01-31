package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.security_question.model.a;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class f
  extends e
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48510);
    b(paramActivity, WalletPayUSecurityQuestionAnswerUI.class, paramBundle);
    paramActivity = super.a(paramActivity, paramBundle);
    AppMethodBeat.o(48510);
    return paramActivity;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(48512);
    if ((paramMMActivity instanceof WalletPayUSecurityQuestionAnswerUI))
    {
      paramMMActivity = new a(paramMMActivity, parami, this.mEJ);
      AppMethodBeat.o(48512);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(48512);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(48511);
    if ((paramActivity instanceof WalletPayUSecurityQuestionAnswerUI))
    {
      b(paramActivity, WalletPayUSetPasswordUI.class, paramBundle);
      AppMethodBeat.o(48511);
      return;
    }
    super.a(paramActivity, paramInt, paramBundle);
    AppMethodBeat.o(48511);
  }
  
  public final String bzC()
  {
    return "PayUForgotPwdProcess";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.f
 * JD-Core Version:    0.7.0.1
 */