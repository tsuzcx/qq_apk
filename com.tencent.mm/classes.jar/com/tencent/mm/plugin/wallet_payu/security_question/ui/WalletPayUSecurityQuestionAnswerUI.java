package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionAnswerUI
  extends WalletBaseUI
{
  private WalletPayUSecurityQuestionView WdS;
  private WalletFormView WdT;
  private PayUSecurityQuestion WdU;
  private a WdV;
  private Button qgp;
  
  public int getLayoutId()
  {
    return a.g.payu_ui_security_question_answer;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72221);
    super.onCreate(paramBundle);
    this.WdV = new a();
    this.WdS = ((WalletPayUSecurityQuestionView)findViewById(a.f.payu_sec_ques));
    this.WdT = ((WalletFormView)findViewById(a.f.payu_sec_answer));
    com.tencent.mm.wallet_core.ui.formview.a.g(this.WdT);
    this.qgp = ((Button)findViewById(a.f.payu_next));
    this.WdT.setOnInputValidChangeListener(new WalletFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(72219);
        WalletPayUSecurityQuestionAnswerUI.a locala = WalletPayUSecurityQuestionAnswerUI.a(WalletPayUSecurityQuestionAnswerUI.this);
        if (WalletPayUSecurityQuestionAnswerUI.b(locala.WdW).bZp()) {}
        for (int i = 1; i != 0; i = 0)
        {
          WalletPayUSecurityQuestionAnswerUI.c(locala.WdW).setEnabled(true);
          AppMethodBeat.o(72219);
          return;
        }
        WalletPayUSecurityQuestionAnswerUI.c(locala.WdW).setEnabled(false);
        AppMethodBeat.o(72219);
      }
    });
    this.qgp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72220);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionAnswerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (WalletPayUSecurityQuestionAnswerUI.b(WalletPayUSecurityQuestionAnswerUI.this).bZp())
        {
          WalletPayUSecurityQuestionAnswerUI.this.getInput().putString("key_question_answer", WalletPayUSecurityQuestionAnswerUI.b(WalletPayUSecurityQuestionAnswerUI.this).getText());
          WalletPayUSecurityQuestionAnswerUI.this.getNetController().t(new Object[0]);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionAnswerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72220);
      }
    });
    AppMethodBeat.o(72221);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(72222);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.WdU = ((PayUSecurityQuestion)getInput().getParcelable("key_security_question"));
      Log.d("MicroMsg.WalletPayUSecurityQuestionAnswerUI", "hy: updating view");
      if (this.WdU != null) {
        this.WdS.setQuestionText(this.WdU.desc);
      }
      this.WdT.gGd();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI
 * JD-Core Version:    0.7.0.1
 */