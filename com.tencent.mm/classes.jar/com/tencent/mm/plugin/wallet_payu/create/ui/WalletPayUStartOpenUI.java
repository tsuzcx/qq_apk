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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletPayUStartOpenUI
  extends WalletBaseUI
{
  private WalletPayUOpenIntroView BRZ;
  private MMFormMobileInputView BSa;
  private EditText BSb;
  private EditText BSc;
  private Button BSd;
  private TextView BSe;
  private TextView BSf;
  private String BSg;
  private String iTD;
  
  private String epr()
  {
    AppMethodBeat.i(72040);
    if (this.BSa.getCountryCode().startsWith("+"))
    {
      str = this.BSa.getCountryCode().substring(1);
      AppMethodBeat.o(72040);
      return str;
    }
    String str = this.BSa.getCountryCode();
    AppMethodBeat.o(72040);
    return str;
  }
  
  private boolean evd()
  {
    AppMethodBeat.i(72041);
    if ((!bs.isNullOrNil(epr())) && (!bs.isNullOrNil(this.BSc.getText().toString())))
    {
      AppMethodBeat.o(72041);
      return true;
    }
    AppMethodBeat.o(72041);
    return false;
  }
  
  private void eve()
  {
    AppMethodBeat.i(72042);
    if (this.BSa.getVisibility() == 0)
    {
      if (evd())
      {
        this.BSg = epr();
        this.iTD = this.BSa.getMobileNumber();
        this.BSd.setEnabled(true);
        AppMethodBeat.o(72042);
        return;
      }
      this.BSd.setEnabled(false);
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
    this.iTD = getInput().getString("key_mobile");
    this.BSg = getInput().getString("dial_code");
    if (bs.isNullOrNil(this.BSg)) {
      this.BSg = "27";
    }
    this.BRZ = ((WalletPayUOpenIntroView)findViewById(2131301044));
    this.BRZ.setPagerData(new d[] { new d(2131233575, 2131765731, 2131765725), new d(2131233576, 2131765732, 2131765726), new d(2131233577, 2131765733, 2131765727) });
    this.BSa = ((MMFormMobileInputView)findViewById(2131305178));
    this.BSd = ((Button)findViewById(2131305174));
    this.BSb = this.BSa.getCountryCodeEditText();
    this.BSc = this.BSa.getMobileNumberEditText();
    if (!bs.isNullOrNil(this.iTD)) {
      this.BSc.setText(this.iTD);
    }
    if (!bs.isNullOrNil(this.BSg)) {
      this.BSb.setText(this.BSg);
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
    this.BSc.addTextChangedListener(paramBundle);
    this.BSb.addTextChangedListener(paramBundle);
    this.BSd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72037);
        if (WalletPayUStartOpenUI.b(WalletPayUStartOpenUI.this).getVisibility() == 0)
        {
          WalletPayUStartOpenUI.this.getInput().putString("key_mobile", WalletPayUStartOpenUI.c(WalletPayUStartOpenUI.this));
          WalletPayUStartOpenUI.this.getInput().putString("dial_code", WalletPayUStartOpenUI.d(WalletPayUStartOpenUI.this));
        }
        WalletPayUStartOpenUI.this.getNetController().s(new Object[0]);
        AppMethodBeat.o(72037);
      }
    });
    this.BSe = ((TextView)findViewById(2131305177));
    c.a(this, this.BSe);
    this.BSf = ((TextView)findViewById(2131305180));
    this.BSf.setText(ah.fAv());
    AppMethodBeat.o(72038);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(72039);
    super.onResume();
    eve();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI
 * JD-Core Version:    0.7.0.1
 */