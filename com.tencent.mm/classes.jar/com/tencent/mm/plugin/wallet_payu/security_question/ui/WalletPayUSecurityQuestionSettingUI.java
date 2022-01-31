package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.plugin.wallet_payu.security_question.model.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionSettingUI
  extends WalletBaseUI
{
  private Button frP;
  private WalletPayUSecurityQuestionView qOP;
  private WalletFormView qOQ;
  private k qOU;
  private String qOV = "";
  private WalletPayUSecurityQuestionSettingUI.a qOW;
  
  protected final boolean bTZ()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (((paramm instanceof d)) && (this.qOU.isShowing())) {
      this.qOU.dismiss();
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.payu_ui_security_question_setting;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.qOU = new k(this);
    this.qOU.nL(true);
    this.qOU.phH = new n.c()
    {
      public final void a(l paramAnonymousl)
      {
        paramAnonymousl.clear();
        ArrayList localArrayList = WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this);
        if (localArrayList != null)
        {
          int i = 0;
          while (i < localArrayList.size())
          {
            paramAnonymousl.add(((PayUSecurityQuestion)localArrayList.get(i)).desc);
            i += 1;
          }
        }
      }
    };
    this.qOU.phI = new WalletPayUSecurityQuestionSettingUI.2(this);
    this.qOW = new WalletPayUSecurityQuestionSettingUI.a(this);
    this.qOP = ((WalletPayUSecurityQuestionView)findViewById(a.f.payu_sec_ques));
    this.qOQ = ((WalletFormView)findViewById(a.f.payu_sec_answer));
    com.tencent.mm.wallet_core.ui.formview.a.g(this.qOQ);
    this.frP = ((Button)findViewById(a.f.payu_next));
    this.qOP.setOnClickListener(new WalletPayUSecurityQuestionSettingUI.3(this));
    this.qOQ.setOnInputValidChangeListener(new WalletPayUSecurityQuestionSettingUI.4(this));
    this.frP.setOnClickListener(new WalletPayUSecurityQuestionSettingUI.5(this));
    WalletPayUSecurityQuestionSettingUI.a.a(this.qOW);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI
 * JD-Core Version:    0.7.0.1
 */