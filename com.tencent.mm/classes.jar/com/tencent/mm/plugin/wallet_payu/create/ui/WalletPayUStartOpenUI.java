package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUStartOpenUI
  extends WalletBaseUI
{
  private WalletPayUOpenIntroView Wdk;
  private MMFormMobileInputView Wdl;
  private EditText Wdm;
  private EditText Wdn;
  private TextView Wdo;
  private TextView Wdp;
  private String Wdq;
  private String qcQ;
  private Button wNX;
  
  private String ifQ()
  {
    AppMethodBeat.i(72040);
    if (this.Wdl.getCountryCode().startsWith("+"))
    {
      str = this.Wdl.getCountryCode().substring(1);
      AppMethodBeat.o(72040);
      return str;
    }
    String str = this.Wdl.getCountryCode();
    AppMethodBeat.o(72040);
    return str;
  }
  
  private boolean imv()
  {
    AppMethodBeat.i(72041);
    if ((!Util.isNullOrNil(ifQ())) && (!Util.isNullOrNil(this.Wdn.getText().toString())))
    {
      AppMethodBeat.o(72041);
      return true;
    }
    AppMethodBeat.o(72041);
    return false;
  }
  
  private void imw()
  {
    AppMethodBeat.i(72042);
    if (this.Wdl.getVisibility() == 0)
    {
      if (imv())
      {
        this.Wdq = ifQ();
        this.qcQ = this.Wdl.getMobileNumber();
        this.wNX.setEnabled(true);
        AppMethodBeat.o(72042);
        return;
      }
      this.wNX.setEnabled(false);
    }
    AppMethodBeat.o(72042);
  }
  
  public int getLayoutId()
  {
    return a.g.payu_ui_startopen;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72038);
    super.onCreate(paramBundle);
    this.qcQ = getInput().getString("key_mobile");
    this.Wdq = getInput().getString("dial_code");
    if (Util.isNullOrNil(this.Wdq)) {
      this.Wdq = "27";
    }
    this.Wdk = ((WalletPayUOpenIntroView)findViewById(a.f.intro_view));
    this.Wdk.setPagerData(new d[] { new d(a.e.payu_open_logo_1, a.i.wallet_payu_start_tip_1, a.i.wallet_payu_start_hint_1), new d(a.e.payu_open_logo_2, a.i.wallet_payu_start_tip_2, a.i.wallet_payu_start_hint_2), new d(a.e.payu_open_logo_3, a.i.wallet_payu_start_tip_3, a.i.wallet_payu_start_hint_3) });
    this.Wdl = ((MMFormMobileInputView)findViewById(a.f.start_mobile_et));
    this.wNX = ((Button)findViewById(a.f.start_btn));
    this.Wdm = this.Wdl.getCountryCodeEditText();
    this.Wdn = this.Wdl.getMobileNumberEditText();
    if (!Util.isNullOrNil(this.qcQ)) {
      this.Wdn.setText(this.qcQ);
    }
    if (!Util.isNullOrNil(this.Wdq)) {
      this.Wdm.setText(this.Wdq);
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
    this.Wdn.addTextChangedListener(paramBundle);
    this.Wdm.addTextChangedListener(paramBundle);
    this.wNX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72037);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_payu/create/ui/WalletPayUStartOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (WalletPayUStartOpenUI.b(WalletPayUStartOpenUI.this).getVisibility() == 0)
        {
          WalletPayUStartOpenUI.this.getInput().putString("key_mobile", WalletPayUStartOpenUI.c(WalletPayUStartOpenUI.this));
          WalletPayUStartOpenUI.this.getInput().putString("dial_code", WalletPayUStartOpenUI.d(WalletPayUStartOpenUI.this));
        }
        WalletPayUStartOpenUI.this.getNetController().t(new Object[0]);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/create/ui/WalletPayUStartOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72037);
      }
    });
    this.Wdo = ((TextView)findViewById(a.f.start_introduction_tv));
    c.a(this, this.Wdo);
    this.Wdp = ((TextView)findViewById(a.f.start_power_tv));
    this.Wdp.setText(ai.jOW());
    AppMethodBeat.o(72038);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(72039);
    super.onResume();
    imw();
    AppMethodBeat.o(72039);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI
 * JD-Core Version:    0.7.0.1
 */