package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.plugin.wallet_payu.security_question.model.d;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionSettingUI
  extends WalletBaseUI
{
  private WalletPayUSecurityQuestionView IuK;
  private WalletFormView IuL;
  private com.tencent.mm.ui.tools.m IuP;
  private String IuQ = "";
  private a IuR;
  private Button krs;
  
  public int getLayoutId()
  {
    return 2131495912;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72231);
    super.onCreate(paramBundle);
    this.IuP = new com.tencent.mm.ui.tools.m(this);
    this.IuP.CL(true);
    this.IuP.HLX = new o.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
      {
        AppMethodBeat.i(72223);
        paramAnonymousm.clear();
        ArrayList localArrayList = WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this);
        if (localArrayList != null)
        {
          int i = 0;
          while (i < localArrayList.size())
          {
            paramAnonymousm.add(((PayUSecurityQuestion)localArrayList.get(i)).desc);
            i += 1;
          }
        }
        AppMethodBeat.o(72223);
      }
    };
    this.IuP.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(72224);
        WalletPayUSecurityQuestionSettingUI.b(WalletPayUSecurityQuestionSettingUI.this).setQuestionText(((PayUSecurityQuestion)WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this).get(paramAnonymousInt)).desc);
        WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this, ((PayUSecurityQuestion)WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this).get(paramAnonymousInt)).id);
        WalletPayUSecurityQuestionSettingUI.c(WalletPayUSecurityQuestionSettingUI.this).eIj();
        WalletPayUSecurityQuestionSettingUI.a.a(WalletPayUSecurityQuestionSettingUI.d(WalletPayUSecurityQuestionSettingUI.this));
        AppMethodBeat.o(72224);
      }
    };
    this.IuR = new a();
    this.IuK = ((WalletPayUSecurityQuestionView)findViewById(2131305864));
    this.IuL = ((WalletFormView)findViewById(2131305863));
    com.tencent.mm.wallet_core.ui.formview.a.g(this.IuL);
    this.krs = ((Button)findViewById(2131305862));
    this.IuK.setOnClickListener(new WalletPayUSecurityQuestionSettingUI.3(this));
    this.IuL.setOnInputValidChangeListener(new WalletFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(72226);
        WalletPayUSecurityQuestionSettingUI.a.a(WalletPayUSecurityQuestionSettingUI.d(WalletPayUSecurityQuestionSettingUI.this));
        AppMethodBeat.o(72226);
      }
    });
    this.krs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72227);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (WalletPayUSecurityQuestionSettingUI.d(WalletPayUSecurityQuestionSettingUI.this).fUD())
        {
          WalletPayUSecurityQuestionSettingUI.this.getInput().putString("key_question_id", WalletPayUSecurityQuestionSettingUI.f(WalletPayUSecurityQuestionSettingUI.this));
          WalletPayUSecurityQuestionSettingUI.this.getInput().putString("key_question_answer", WalletPayUSecurityQuestionSettingUI.c(WalletPayUSecurityQuestionSettingUI.this).getText());
          com.tencent.mm.wallet_core.a.l(WalletPayUSecurityQuestionSettingUI.this, WalletPayUSecurityQuestionSettingUI.this.getInput());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72227);
          return;
          WalletPayUSecurityQuestionSettingUI.a.a(WalletPayUSecurityQuestionSettingUI.d(WalletPayUSecurityQuestionSettingUI.this));
        }
      }
    });
    a.a(this.IuR);
    AppMethodBeat.o(72231);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(72232);
    super.onResume();
    AppMethodBeat.o(72232);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72233);
    if (((paramq instanceof d)) && (this.IuP.isShowing())) {
      this.IuP.dismiss();
    }
    AppMethodBeat.o(72233);
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
    
    private void fUz()
    {
      AppMethodBeat.i(72228);
      if (fUD())
      {
        WalletPayUSecurityQuestionSettingUI.g(WalletPayUSecurityQuestionSettingUI.this).setEnabled(true);
        AppMethodBeat.o(72228);
        return;
      }
      WalletPayUSecurityQuestionSettingUI.g(WalletPayUSecurityQuestionSettingUI.this).setEnabled(false);
      AppMethodBeat.o(72228);
    }
    
    protected final boolean fUD()
    {
      AppMethodBeat.i(72229);
      if ((WalletPayUSecurityQuestionSettingUI.b(WalletPayUSecurityQuestionSettingUI.this).bql()) && (WalletPayUSecurityQuestionSettingUI.c(WalletPayUSecurityQuestionSettingUI.this).bql()))
      {
        AppMethodBeat.o(72229);
        return true;
      }
      AppMethodBeat.o(72229);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI
 * JD-Core Version:    0.7.0.1
 */