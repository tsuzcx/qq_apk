package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletPayUStartOpenUI
  extends WalletBaseUI
{
  private String gFX;
  private EditText uCA;
  private Button uCB;
  private TextView uCC;
  private TextView uCD;
  private String uCE;
  private WalletPayUOpenIntroView uCx;
  private MMFormMobileInputView uCy;
  private EditText uCz;
  
  private String cRI()
  {
    AppMethodBeat.i(48399);
    if (this.uCy.getCountryCode().startsWith("+"))
    {
      str = this.uCy.getCountryCode().substring(1);
      AppMethodBeat.o(48399);
      return str;
    }
    String str = this.uCy.getCountryCode();
    AppMethodBeat.o(48399);
    return str;
  }
  
  private boolean cXo()
  {
    AppMethodBeat.i(48400);
    if ((!bo.isNullOrNil(cRI())) && (!bo.isNullOrNil(this.uCA.getText().toString())))
    {
      AppMethodBeat.o(48400);
      return true;
    }
    AppMethodBeat.o(48400);
    return false;
  }
  
  private void cXp()
  {
    AppMethodBeat.i(48401);
    if (this.uCy.getVisibility() == 0)
    {
      if (cXo())
      {
        this.uCE = cRI();
        this.gFX = this.uCy.getMobileNumber();
        this.uCB.setEnabled(true);
        AppMethodBeat.o(48401);
        return;
      }
      this.uCB.setEnabled(false);
    }
    AppMethodBeat.o(48401);
  }
  
  public int getLayoutId()
  {
    return 2130970412;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48397);
    super.onCreate(paramBundle);
    this.gFX = getInput().getString("key_mobile");
    this.uCE = getInput().getString("dial_code");
    if (bo.isNullOrNil(this.uCE)) {
      this.uCE = "27";
    }
    this.uCx = ((WalletPayUOpenIntroView)findViewById(2131826707));
    this.uCx.setPagerData(new d[] { new d(2130839909, 2131305516, 2131305510), new d(2130839910, 2131305517, 2131305511), new d(2130839911, 2131305518, 2131305512) });
    this.uCy = ((MMFormMobileInputView)findViewById(2131826708));
    this.uCB = ((Button)findViewById(2131823304));
    this.uCz = this.uCy.getCountryCodeEditText();
    this.uCA = this.uCy.getMobileNumberEditText();
    if (!bo.isNullOrNil(this.gFX)) {
      this.uCA.setText(this.gFX);
    }
    if (!bo.isNullOrNil(this.uCE)) {
      this.uCz.setText(this.uCE);
    }
    paramBundle = new WalletPayUStartOpenUI.1(this);
    this.uCA.addTextChangedListener(paramBundle);
    this.uCz.addTextChangedListener(paramBundle);
    this.uCB.setOnClickListener(new WalletPayUStartOpenUI.2(this));
    this.uCC = ((TextView)findViewById(2131826698));
    c.a(this, this.uCC);
    this.uCD = ((TextView)findViewById(2131826709));
    this.uCD.setText(ae.dSy());
    AppMethodBeat.o(48397);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(48398);
    super.onResume();
    cXp();
    AppMethodBeat.o(48398);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI
 * JD-Core Version:    0.7.0.1
 */