package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionAnswerUI
  extends WalletBaseUI
{
  private WalletPayUSecurityQuestionView IuK;
  private WalletFormView IuL;
  private PayUSecurityQuestion IuM;
  private a IuN;
  private Button krs;
  
  public int getLayoutId()
  {
    return 2131495911;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72221);
    super.onCreate(paramBundle);
    this.IuN = new a();
    this.IuK = ((WalletPayUSecurityQuestionView)findViewById(2131305864));
    this.IuL = ((WalletFormView)findViewById(2131305863));
    com.tencent.mm.wallet_core.ui.formview.a.g(this.IuL);
    this.krs = ((Button)findViewById(2131305862));
    this.IuL.setOnInputValidChangeListener(new WalletFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(72219);
        WalletPayUSecurityQuestionAnswerUI.a locala = WalletPayUSecurityQuestionAnswerUI.a(WalletPayUSecurityQuestionAnswerUI.this);
        if (WalletPayUSecurityQuestionAnswerUI.b(locala.IuO).bql()) {}
        for (int i = 1; i != 0; i = 0)
        {
          WalletPayUSecurityQuestionAnswerUI.c(locala.IuO).setEnabled(true);
          AppMethodBeat.o(72219);
          return;
        }
        WalletPayUSecurityQuestionAnswerUI.c(locala.IuO).setEnabled(false);
        AppMethodBeat.o(72219);
      }
    });
    this.krs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72220);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionAnswerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (WalletPayUSecurityQuestionAnswerUI.b(WalletPayUSecurityQuestionAnswerUI.this).bql())
        {
          WalletPayUSecurityQuestionAnswerUI.this.getInput().putString("key_question_answer", WalletPayUSecurityQuestionAnswerUI.b(WalletPayUSecurityQuestionAnswerUI.this).getText());
          WalletPayUSecurityQuestionAnswerUI.this.getNetController().r(new Object[0]);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionAnswerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72220);
      }
    });
    AppMethodBeat.o(72221);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72222);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.IuM = ((PayUSecurityQuestion)getInput().getParcelable("key_security_question"));
      Log.d("MicroMsg.WalletPayUSecurityQuestionAnswerUI", "hy: updating view");
      if (this.IuM != null) {
        this.IuK.setQuestionText(this.IuM.desc);
      }
      this.IuL.eIj();
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