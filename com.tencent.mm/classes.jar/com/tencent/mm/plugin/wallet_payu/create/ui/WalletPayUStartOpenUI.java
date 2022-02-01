package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletPayUStartOpenUI
  extends WalletBaseUI
{
  private WalletPayUOpenIntroView AzD;
  private MMFormMobileInputView AzE;
  private EditText AzF;
  private EditText AzG;
  private Button AzH;
  private TextView AzI;
  private TextView AzJ;
  private String AzK;
  private String ity;
  
  private String dZV()
  {
    AppMethodBeat.i(72040);
    if (this.AzE.getCountryCode().startsWith("+"))
    {
      str = this.AzE.getCountryCode().substring(1);
      AppMethodBeat.o(72040);
      return str;
    }
    String str = this.AzE.getCountryCode();
    AppMethodBeat.o(72040);
    return str;
  }
  
  private boolean efJ()
  {
    AppMethodBeat.i(72041);
    if ((!bt.isNullOrNil(dZV())) && (!bt.isNullOrNil(this.AzG.getText().toString())))
    {
      AppMethodBeat.o(72041);
      return true;
    }
    AppMethodBeat.o(72041);
    return false;
  }
  
  private void efK()
  {
    AppMethodBeat.i(72042);
    if (this.AzE.getVisibility() == 0)
    {
      if (efJ())
      {
        this.AzK = dZV();
        this.ity = this.AzE.getMobileNumber();
        this.AzH.setEnabled(true);
        AppMethodBeat.o(72042);
        return;
      }
      this.AzH.setEnabled(false);
    }
    AppMethodBeat.o(72042);
  }
  
  public int getLayoutId()
  {
    return 2131495076;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72038);
    super.onCreate(paramBundle);
    this.ity = getInput().getString("key_mobile");
    this.AzK = getInput().getString("dial_code");
    if (bt.isNullOrNil(this.AzK)) {
      this.AzK = "27";
    }
    this.AzD = ((WalletPayUOpenIntroView)findViewById(2131301044));
    this.AzD.setPagerData(new d[] { new d(2131233575, 2131765731, 2131765725), new d(2131233576, 2131765732, 2131765726), new d(2131233577, 2131765733, 2131765727) });
    this.AzE = ((MMFormMobileInputView)findViewById(2131305178));
    this.AzH = ((Button)findViewById(2131305174));
    this.AzF = this.AzE.getCountryCodeEditText();
    this.AzG = this.AzE.getMobileNumberEditText();
    if (!bt.isNullOrNil(this.ity)) {
      this.AzG.setText(this.ity);
    }
    if (!bt.isNullOrNil(this.AzK)) {
      this.AzF.setText(this.AzK);
    }
    paramBundle = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(72036);
        WalletPayUStartOpenUI.a(WalletPayUStartOpenUI.this);
        AppMethodBeat.o(72036);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.AzG.addTextChangedListener(paramBundle);
    this.AzF.addTextChangedListener(paramBundle);
    this.AzH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72037);
        if (WalletPayUStartOpenUI.b(WalletPayUStartOpenUI.this).getVisibility() == 0)
        {
          WalletPayUStartOpenUI.this.getInput().putString("key_mobile", WalletPayUStartOpenUI.c(WalletPayUStartOpenUI.this));
          WalletPayUStartOpenUI.this.getInput().putString("dial_code", WalletPayUStartOpenUI.d(WalletPayUStartOpenUI.this));
        }
        WalletPayUStartOpenUI.this.getNetController().q(new Object[0]);
        AppMethodBeat.o(72037);
      }
    });
    this.AzI = ((TextView)findViewById(2131305177));
    c.a(this, this.AzI);
    this.AzJ = ((TextView)findViewById(2131305180));
    this.AzJ.setText(ah.fkf());
    AppMethodBeat.o(72038);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(72039);
    super.onResume();
    efK();
    AppMethodBeat.o(72039);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI
 * JD-Core Version:    0.7.0.1
 */