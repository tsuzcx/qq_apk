package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionAnswerUI
  extends WalletBaseUI
{
  private WalletPayUSecurityQuestionView DtQ;
  private WalletFormView DtR;
  private PayUSecurityQuestion DtS;
  private a DtT;
  private Button jqk;
  
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
    this.DtT = new a();
    this.DtQ = ((WalletPayUSecurityQuestionView)findViewById(2131303198));
    this.DtR = ((WalletFormView)findViewById(2131303197));
    com.tencent.mm.wallet_core.ui.formview.a.g(this.DtR);
    this.jqk = ((Button)findViewById(2131303196));
    this.DtR.setOnInputValidChangeListener(new WalletFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(72219);
        WalletPayUSecurityQuestionAnswerUI.a locala = WalletPayUSecurityQuestionAnswerUI.a(WalletPayUSecurityQuestionAnswerUI.this);
        if (WalletPayUSecurityQuestionAnswerUI.b(locala.DtU).aVa()) {}
        for (int i = 1; i != 0; i = 0)
        {
          WalletPayUSecurityQuestionAnswerUI.c(locala.DtU).setEnabled(true);
          AppMethodBeat.o(72219);
          return;
        }
        WalletPayUSecurityQuestionAnswerUI.c(locala.DtU).setEnabled(false);
        AppMethodBeat.o(72219);
      }
    });
    this.jqk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72220);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionAnswerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (WalletPayUSecurityQuestionAnswerUI.b(WalletPayUSecurityQuestionAnswerUI.this).aVa())
        {
          WalletPayUSecurityQuestionAnswerUI.this.getInput().putString("key_question_answer", WalletPayUSecurityQuestionAnswerUI.b(WalletPayUSecurityQuestionAnswerUI.this).getText());
          WalletPayUSecurityQuestionAnswerUI.this.getNetController().s(new Object[0]);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionAnswerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      this.DtS = ((PayUSecurityQuestion)getInput().getParcelable("key_security_question"));
      ad.d("MicroMsg.WalletPayUSecurityQuestionAnswerUI", "hy: updating view");
      if (this.DtS != null) {
        this.DtQ.setQuestionText(this.DtS.desc);
      }
      this.DtR.dEe();
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