package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionAnswerUI
  extends WalletBaseUI
{
  private WalletPayUSecurityQuestionView BTw;
  private WalletFormView BTx;
  private PayUSecurityQuestion BTy;
  private a BTz;
  private Button iXb;
  
  public int getLayoutId()
  {
    return 2131495074;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72221);
    super.onCreate(paramBundle);
    this.BTz = new a();
    this.BTw = ((WalletPayUSecurityQuestionView)findViewById(2131303198));
    this.BTx = ((WalletFormView)findViewById(2131303197));
    com.tencent.mm.wallet_core.ui.formview.a.g(this.BTx);
    this.iXb = ((Button)findViewById(2131303196));
    this.BTx.setOnInputValidChangeListener(new WalletFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(72219);
        WalletPayUSecurityQuestionAnswerUI.a locala = WalletPayUSecurityQuestionAnswerUI.a(WalletPayUSecurityQuestionAnswerUI.this);
        if (WalletPayUSecurityQuestionAnswerUI.b(locala.BTA).aRO()) {}
        for (int i = 1; i != 0; i = 0)
        {
          WalletPayUSecurityQuestionAnswerUI.c(locala.BTA).setEnabled(true);
          AppMethodBeat.o(72219);
          return;
        }
        WalletPayUSecurityQuestionAnswerUI.c(locala.BTA).setEnabled(false);
        AppMethodBeat.o(72219);
      }
    });
    this.iXb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72220);
        if (WalletPayUSecurityQuestionAnswerUI.b(WalletPayUSecurityQuestionAnswerUI.this).aRO())
        {
          WalletPayUSecurityQuestionAnswerUI.this.getInput().putString("key_question_answer", WalletPayUSecurityQuestionAnswerUI.b(WalletPayUSecurityQuestionAnswerUI.this).getText());
          WalletPayUSecurityQuestionAnswerUI.this.getNetController().s(new Object[0]);
        }
        AppMethodBeat.o(72220);
      }
    });
    AppMethodBeat.o(72221);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72222);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.BTy = ((PayUSecurityQuestion)getInput().getParcelable("key_security_question"));
      ac.d("MicroMsg.WalletPayUSecurityQuestionAnswerUI", "hy: updating view");
      if (this.BTy != null) {
        this.BTw.setQuestionText(this.BTy.desc);
      }
      this.BTx.dtH();
    }
    AppMethodBeat.o(72222);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final class a
  {
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI
 * JD-Core Version:    0.7.0.1
 */