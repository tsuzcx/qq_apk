package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionAnswerUI
  extends WalletBaseUI
{
  private Button gJr;
  private WalletPayUSecurityQuestionView uDW;
  private WalletFormView uDX;
  private PayUSecurityQuestion uDY;
  private WalletPayUSecurityQuestionAnswerUI.a uDZ;
  
  public int getLayoutId()
  {
    return 2130970410;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48580);
    super.onCreate(paramBundle);
    this.uDZ = new WalletPayUSecurityQuestionAnswerUI.a(this);
    this.uDW = ((WalletPayUSecurityQuestionView)findViewById(2131826704));
    this.uDX = ((WalletFormView)findViewById(2131826705));
    com.tencent.mm.wallet_core.ui.formview.a.g(this.uDX);
    this.gJr = ((Button)findViewById(2131826706));
    this.uDX.setOnInputValidChangeListener(new WalletPayUSecurityQuestionAnswerUI.1(this));
    this.gJr.setOnClickListener(new WalletPayUSecurityQuestionAnswerUI.2(this));
    AppMethodBeat.o(48580);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48581);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.uDY = ((PayUSecurityQuestion)getInput().getParcelable("key_security_question"));
      ab.d("MicroMsg.WalletPayUSecurityQuestionAnswerUI", "hy: updating view");
      if (this.uDY != null) {
        this.uDW.setQuestionText(this.uDY.desc);
      }
      this.uDX.cfK();
    }
    AppMethodBeat.o(48581);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI
 * JD-Core Version:    0.7.0.1
 */