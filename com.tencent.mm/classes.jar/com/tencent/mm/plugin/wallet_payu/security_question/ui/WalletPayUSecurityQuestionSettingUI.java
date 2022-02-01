package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.plugin.wallet_payu.security_question.model.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionSettingUI
  extends WalletBaseUI
{
  private WalletPayUSecurityQuestionView WdS;
  private WalletFormView WdT;
  private m WdX;
  private String WdY = "";
  private a WdZ;
  private Button qgp;
  
  public int getLayoutId()
  {
    return a.g.payu_ui_security_question_setting;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72231);
    super.onCreate(paramBundle);
    this.WdX = new m(this);
    this.WdX.Na(true);
    this.WdX.Vtg = new WalletPayUSecurityQuestionSettingUI.1(this);
    this.WdX.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(72224);
        WalletPayUSecurityQuestionSettingUI.b(WalletPayUSecurityQuestionSettingUI.this).setQuestionText(((PayUSecurityQuestion)WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this).get(paramAnonymousInt)).desc);
        WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this, ((PayUSecurityQuestion)WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this).get(paramAnonymousInt)).id);
        WalletPayUSecurityQuestionSettingUI.c(WalletPayUSecurityQuestionSettingUI.this).gGd();
        WalletPayUSecurityQuestionSettingUI.a.a(WalletPayUSecurityQuestionSettingUI.d(WalletPayUSecurityQuestionSettingUI.this));
        AppMethodBeat.o(72224);
      }
    };
    this.WdZ = new a();
    this.WdS = ((WalletPayUSecurityQuestionView)findViewById(a.f.payu_sec_ques));
    this.WdT = ((WalletFormView)findViewById(a.f.payu_sec_answer));
    com.tencent.mm.wallet_core.ui.formview.a.g(this.WdT);
    this.qgp = ((Button)findViewById(a.f.payu_next));
    this.WdS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72225);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WalletPayUSecurityQuestionSettingUI.e(WalletPayUSecurityQuestionSettingUI.this).du();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72225);
      }
    });
    this.WdT.setOnInputValidChangeListener(new WalletFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(72226);
        WalletPayUSecurityQuestionSettingUI.a.a(WalletPayUSecurityQuestionSettingUI.d(WalletPayUSecurityQuestionSettingUI.this));
        AppMethodBeat.o(72226);
      }
    });
    this.qgp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72227);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (WalletPayUSecurityQuestionSettingUI.d(WalletPayUSecurityQuestionSettingUI.this).imy())
        {
          WalletPayUSecurityQuestionSettingUI.this.getInput().putString("key_question_id", WalletPayUSecurityQuestionSettingUI.f(WalletPayUSecurityQuestionSettingUI.this));
          WalletPayUSecurityQuestionSettingUI.this.getInput().putString("key_question_answer", WalletPayUSecurityQuestionSettingUI.c(WalletPayUSecurityQuestionSettingUI.this).getText());
          com.tencent.mm.wallet_core.a.k(WalletPayUSecurityQuestionSettingUI.this, WalletPayUSecurityQuestionSettingUI.this.getInput());
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
    a.a(this.WdZ);
    AppMethodBeat.o(72231);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(72232);
    super.onResume();
    AppMethodBeat.o(72232);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(72233);
    if (((paramp instanceof d)) && (this.WdX.isShowing())) {
      this.WdX.dismiss();
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
    
    private void imu()
    {
      AppMethodBeat.i(72228);
      if (imy())
      {
        WalletPayUSecurityQuestionSettingUI.g(WalletPayUSecurityQuestionSettingUI.this).setEnabled(true);
        AppMethodBeat.o(72228);
        return;
      }
      WalletPayUSecurityQuestionSettingUI.g(WalletPayUSecurityQuestionSettingUI.this).setEnabled(false);
      AppMethodBeat.o(72228);
    }
    
    protected final boolean imy()
    {
      AppMethodBeat.i(72229);
      if ((WalletPayUSecurityQuestionSettingUI.b(WalletPayUSecurityQuestionSettingUI.this).bZp()) && (WalletPayUSecurityQuestionSettingUI.c(WalletPayUSecurityQuestionSettingUI.this).bZp()))
      {
        AppMethodBeat.o(72229);
        return true;
      }
      AppMethodBeat.o(72229);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI
 * JD-Core Version:    0.7.0.1
 */