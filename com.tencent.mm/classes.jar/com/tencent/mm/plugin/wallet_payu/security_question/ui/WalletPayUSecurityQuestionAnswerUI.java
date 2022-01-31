package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionAnswerUI
  extends WalletBaseUI
{
  private Button frP;
  private WalletPayUSecurityQuestionView qOP;
  private WalletFormView qOQ;
  private PayUSecurityQuestion qOR;
  private WalletPayUSecurityQuestionAnswerUI.a qOS;
  
  protected final boolean bTZ()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.qOR = ((PayUSecurityQuestion)this.BX.getParcelable("key_security_question"));
      y.d("MicroMsg.WalletPayUSecurityQuestionAnswerUI", "hy: updating view");
      if (this.qOR != null) {
        this.qOP.setQuestionText(this.qOR.desc);
      }
      this.qOQ.bvr();
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.payu_ui_security_question_answer;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.qOS = new WalletPayUSecurityQuestionAnswerUI.a(this);
    this.qOP = ((WalletPayUSecurityQuestionView)findViewById(a.f.payu_sec_ques));
    this.qOQ = ((WalletFormView)findViewById(a.f.payu_sec_answer));
    com.tencent.mm.wallet_core.ui.formview.a.g(this.qOQ);
    this.frP = ((Button)findViewById(a.f.payu_next));
    this.qOQ.setOnInputValidChangeListener(new WalletPayUSecurityQuestionAnswerUI.1(this));
    this.frP.setOnClickListener(new WalletPayUSecurityQuestionAnswerUI.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI
 * JD-Core Version:    0.7.0.1
 */