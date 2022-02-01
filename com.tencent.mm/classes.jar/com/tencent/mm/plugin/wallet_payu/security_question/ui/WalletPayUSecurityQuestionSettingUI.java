package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.plugin.wallet_payu.security_question.model.d;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionSettingUI
  extends WalletBaseUI
{
  private WalletPayUSecurityQuestionView ABb;
  private WalletFormView ABc;
  private m ABg;
  private String ABh = "";
  private a ABi;
  private Button iwY;
  
  public int getLayoutId()
  {
    return 2131495075;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72231);
    super.onCreate(paramBundle);
    this.ABg = new m(this);
    this.ABg.wI(true);
    this.ABg.HrX = new WalletPayUSecurityQuestionSettingUI.1(this);
    this.ABg.HrY = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(72224);
        WalletPayUSecurityQuestionSettingUI.b(WalletPayUSecurityQuestionSettingUI.this).setQuestionText(((PayUSecurityQuestion)WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this).get(paramAnonymousInt)).desc);
        WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this, ((PayUSecurityQuestion)WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this).get(paramAnonymousInt)).id);
        WalletPayUSecurityQuestionSettingUI.c(WalletPayUSecurityQuestionSettingUI.this).dga();
        WalletPayUSecurityQuestionSettingUI.a.a(WalletPayUSecurityQuestionSettingUI.d(WalletPayUSecurityQuestionSettingUI.this));
        AppMethodBeat.o(72224);
      }
    };
    this.ABi = new a();
    this.ABb = ((WalletPayUSecurityQuestionView)findViewById(2131303198));
    this.ABc = ((WalletFormView)findViewById(2131303197));
    com.tencent.mm.wallet_core.ui.formview.a.g(this.ABc);
    this.iwY = ((Button)findViewById(2131303196));
    this.ABb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72225);
        WalletPayUSecurityQuestionSettingUI.e(WalletPayUSecurityQuestionSettingUI.this).hM();
        AppMethodBeat.o(72225);
      }
    });
    this.ABc.setOnInputValidChangeListener(new WalletFormView.a()
    {
      public final void onInputValidChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(72226);
        WalletPayUSecurityQuestionSettingUI.a.a(WalletPayUSecurityQuestionSettingUI.d(WalletPayUSecurityQuestionSettingUI.this));
        AppMethodBeat.o(72226);
      }
    });
    this.iwY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72227);
        if (WalletPayUSecurityQuestionSettingUI.d(WalletPayUSecurityQuestionSettingUI.this).efM())
        {
          WalletPayUSecurityQuestionSettingUI.this.getInput().putString("key_question_id", WalletPayUSecurityQuestionSettingUI.f(WalletPayUSecurityQuestionSettingUI.this));
          WalletPayUSecurityQuestionSettingUI.this.getInput().putString("key_question_answer", WalletPayUSecurityQuestionSettingUI.c(WalletPayUSecurityQuestionSettingUI.this).getText());
          com.tencent.mm.wallet_core.a.k(WalletPayUSecurityQuestionSettingUI.this, WalletPayUSecurityQuestionSettingUI.this.getInput());
          AppMethodBeat.o(72227);
          return;
        }
        WalletPayUSecurityQuestionSettingUI.a.a(WalletPayUSecurityQuestionSettingUI.d(WalletPayUSecurityQuestionSettingUI.this));
        AppMethodBeat.o(72227);
      }
    });
    a.a(this.ABi);
    AppMethodBeat.o(72231);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(72232);
    super.onResume();
    AppMethodBeat.o(72232);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72233);
    if (((paramn instanceof d)) && (this.ABg.isShowing())) {
      this.ABg.dismiss();
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
    
    private void efI()
    {
      AppMethodBeat.i(72228);
      if (efM())
      {
        WalletPayUSecurityQuestionSettingUI.g(WalletPayUSecurityQuestionSettingUI.this).setEnabled(true);
        AppMethodBeat.o(72228);
        return;
      }
      WalletPayUSecurityQuestionSettingUI.g(WalletPayUSecurityQuestionSettingUI.this).setEnabled(false);
      AppMethodBeat.o(72228);
    }
    
    protected final boolean efM()
    {
      AppMethodBeat.i(72229);
      if ((WalletPayUSecurityQuestionSettingUI.b(WalletPayUSecurityQuestionSettingUI.this).aKX()) && (WalletPayUSecurityQuestionSettingUI.c(WalletPayUSecurityQuestionSettingUI.this).aKX()))
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