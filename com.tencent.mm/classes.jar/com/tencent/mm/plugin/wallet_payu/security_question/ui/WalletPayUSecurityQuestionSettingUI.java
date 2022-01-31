package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.plugin.wallet_payu.security_question.model.d;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionSettingUI
  extends WalletBaseUI
{
  private Button gJr;
  private WalletPayUSecurityQuestionView uDW;
  private WalletFormView uDX;
  private com.tencent.mm.ui.tools.m uEb;
  private String uEc = "";
  private WalletPayUSecurityQuestionSettingUI.a uEd;
  
  public int getLayoutId()
  {
    return 2130970411;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48590);
    super.onCreate(paramBundle);
    this.uEb = new com.tencent.mm.ui.tools.m(this);
    this.uEb.rv(true);
    this.uEb.sao = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(48582);
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
        AppMethodBeat.o(48582);
      }
    };
    this.uEb.sap = new WalletPayUSecurityQuestionSettingUI.2(this);
    this.uEd = new WalletPayUSecurityQuestionSettingUI.a(this);
    this.uDW = ((WalletPayUSecurityQuestionView)findViewById(2131826704));
    this.uDX = ((WalletFormView)findViewById(2131826705));
    com.tencent.mm.wallet_core.ui.formview.a.g(this.uDX);
    this.gJr = ((Button)findViewById(2131826706));
    this.uDW.setOnClickListener(new WalletPayUSecurityQuestionSettingUI.3(this));
    this.uDX.setOnInputValidChangeListener(new WalletPayUSecurityQuestionSettingUI.4(this));
    this.gJr.setOnClickListener(new WalletPayUSecurityQuestionSettingUI.5(this));
    WalletPayUSecurityQuestionSettingUI.a.a(this.uEd);
    AppMethodBeat.o(48590);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(48591);
    super.onResume();
    AppMethodBeat.o(48591);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(48592);
    if (((paramm instanceof d)) && (this.uEb.isShowing())) {
      this.uEb.dismiss();
    }
    AppMethodBeat.o(48592);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI
 * JD-Core Version:    0.7.0.1
 */