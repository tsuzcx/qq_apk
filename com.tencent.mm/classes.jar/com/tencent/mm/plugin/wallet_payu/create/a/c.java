package com.tencent.mm.plugin.wallet_payu.create.a;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.security_question.model.a;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;

public class c
  extends com.tencent.mm.wallet_core.c
{
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    if (paramInt == 1) {
      return a.i.wallet_payu_endprocesstip_create;
    }
    return super.a(paramMMActivity, paramInt);
  }
  
  public final com.tencent.mm.wallet_core.c a(Activity paramActivity, Bundle paramBundle)
  {
    y.d("MicroMsg.PayUOpenProcess", "hy: start process PayUOpenProcess");
    p.bTK();
    String str1 = p.NL();
    p.bTK();
    String str2 = p.bTM();
    if (paramBundle != null)
    {
      paramBundle.putString("key_mobile", str1);
      paramBundle.putString("dial_code", str2);
    }
    b(paramActivity, WalletPayUStartOpenUI.class, paramBundle);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletPayUStartOpenUI)) {
      return new c.1(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletPayUVerifyCodeUI)) {
      return new c.2(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletPayUSecurityQuestionSettingUI)) {
      return new c.3(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletPayUPwdConfirmUI)) {
      return new c.4(this, paramMMActivity, parami);
    }
    if ((paramMMActivity instanceof WalletPayUSecurityQuestionAnswerUI)) {
      return new a(paramMMActivity, parami, this.kke);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletPayUStartOpenUI)) {
      b(paramActivity, WalletPayUVerifyCodeUI.class, paramBundle);
    }
    if ((paramActivity instanceof WalletPayUVerifyCodeUI))
    {
      if (paramBundle.getBoolean("key_is_has_mobile")) {
        break label85;
      }
      b(paramActivity, WalletPayUSecurityQuestionSettingUI.class, paramBundle);
    }
    for (;;)
    {
      if ((paramActivity instanceof WalletPayUSecurityQuestionSettingUI)) {
        b(paramActivity, WalletPayUSetPasswordUI.class, paramBundle);
      }
      if ((paramActivity instanceof WalletPayUSetPasswordUI)) {
        b(paramActivity, WalletPayUPwdConfirmUI.class, paramBundle);
      }
      if ((paramActivity instanceof WalletPayUSecurityQuestionAnswerUI)) {
        b(paramActivity, WalletPayUSetPasswordUI.class, paramBundle);
      }
      return;
      label85:
      b(paramActivity, WalletPayUSecurityQuestionAnswerUI.class, paramBundle);
    }
  }
  
  public final String aTh()
  {
    return "PayUOpenProcess";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    if ((paramActivity instanceof WalletPayUPwdConfirmUI))
    {
      a(paramActivity, WalletPayUSetPasswordUI.class, paramInt);
      return;
    }
    b(paramActivity, this.kke);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    if (paramBundle.getInt("key_open_error_code", -1) == 0)
    {
      y.i("MicroMsg.PayUOpenProcess", "hy: user open success");
      d(paramActivity, "mall", ".ui.MallIndexUI");
      return;
    }
    y.i("MicroMsg.PayUOpenProcess", "hy: user interrupted the process. go to preference");
    super.ak(paramActivity);
    e.hn(paramActivity);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final boolean h(Activity paramActivity, Bundle paramBundle)
  {
    paramBundle.putInt("key_open_error_code", 1);
    s.makeText(paramActivity, paramActivity.getString(a.i.wallet_payu_start_failed), 0).show();
    b(paramActivity, paramBundle);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.c
 * JD-Core Version:    0.7.0.1
 */