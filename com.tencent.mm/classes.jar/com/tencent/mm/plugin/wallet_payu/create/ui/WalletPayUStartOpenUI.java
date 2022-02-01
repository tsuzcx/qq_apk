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
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUStartOpenUI
  extends WalletBaseUI
{
  private WalletPayUOpenIntroView PlY;
  private MMFormMobileInputView PlZ;
  private EditText Pma;
  private EditText Pmb;
  private TextView Pmc;
  private TextView Pmd;
  private String Pme;
  private String nfH;
  private Button tKD;
  
  private String gGN()
  {
    AppMethodBeat.i(72040);
    if (this.PlZ.getCountryCode().startsWith("+"))
    {
      str = this.PlZ.getCountryCode().substring(1);
      AppMethodBeat.o(72040);
      return str;
    }
    String str = this.PlZ.getCountryCode();
    AppMethodBeat.o(72040);
    return str;
  }
  
  private boolean gNg()
  {
    AppMethodBeat.i(72041);
    if ((!Util.isNullOrNil(gGN())) && (!Util.isNullOrNil(this.Pmb.getText().toString())))
    {
      AppMethodBeat.o(72041);
      return true;
    }
    AppMethodBeat.o(72041);
    return false;
  }
  
  private void gNh()
  {
    AppMethodBeat.i(72042);
    if (this.PlZ.getVisibility() == 0)
    {
      if (gNg())
      {
        this.Pme = gGN();
        this.nfH = this.PlZ.getMobileNumber();
        this.tKD.setEnabled(true);
        AppMethodBeat.o(72042);
        return;
      }
      this.tKD.setEnabled(false);
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
    this.nfH = getInput().getString("key_mobile");
    this.Pme = getInput().getString("dial_code");
    if (Util.isNullOrNil(this.Pme)) {
      this.Pme = "27";
    }
    this.PlY = ((WalletPayUOpenIntroView)findViewById(a.f.intro_view));
    this.PlY.setPagerData(new d[] { new d(a.e.payu_open_logo_1, a.i.wallet_payu_start_tip_1, a.i.wallet_payu_start_hint_1), new d(a.e.payu_open_logo_2, a.i.wallet_payu_start_tip_2, a.i.wallet_payu_start_hint_2), new d(a.e.payu_open_logo_3, a.i.wallet_payu_start_tip_3, a.i.wallet_payu_start_hint_3) });
    this.PlZ = ((MMFormMobileInputView)findViewById(a.f.start_mobile_et));
    this.tKD = ((Button)findViewById(a.f.start_btn));
    this.Pma = this.PlZ.getCountryCodeEditText();
    this.Pmb = this.PlZ.getMobileNumberEditText();
    if (!Util.isNullOrNil(this.nfH)) {
      this.Pmb.setText(this.nfH);
    }
    if (!Util.isNullOrNil(this.Pme)) {
      this.Pma.setText(this.Pme);
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
    this.Pmb.addTextChangedListener(paramBundle);
    this.Pma.addTextChangedListener(paramBundle);
    this.tKD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72037);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_payu/create/ui/WalletPayUStartOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (WalletPayUStartOpenUI.b(WalletPayUStartOpenUI.this).getVisibility() == 0)
        {
          WalletPayUStartOpenUI.this.getInput().putString("key_mobile", WalletPayUStartOpenUI.c(WalletPayUStartOpenUI.this));
          WalletPayUStartOpenUI.this.getInput().putString("dial_code", WalletPayUStartOpenUI.d(WalletPayUStartOpenUI.this));
        }
        WalletPayUStartOpenUI.this.getNetController().r(new Object[0]);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/create/ui/WalletPayUStartOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72037);
      }
    });
    this.Pmc = ((TextView)findViewById(a.f.start_introduction_tv));
    c.a(this, this.Pmc);
    this.Pmd = ((TextView)findViewById(a.f.start_power_tv));
    this.Pmd.setText(ah.ija());
    AppMethodBeat.o(72038);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(72039);
    super.onResume();
    gNh();
    AppMethodBeat.o(72039);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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