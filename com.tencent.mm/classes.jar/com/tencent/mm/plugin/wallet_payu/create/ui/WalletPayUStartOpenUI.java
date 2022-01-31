package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletPayUStartOpenUI
  extends WalletBaseUI
{
  private String foD;
  private WalletPayUOpenIntroView qNq;
  private MMFormMobileInputView qNr;
  private EditText qNs;
  private EditText qNt;
  private Button qNu;
  private TextView qNv;
  private TextView qNw;
  private String qNx;
  
  private String bTM()
  {
    if (this.qNr.getCountryCode().startsWith("+")) {
      return this.qNr.getCountryCode().substring(1);
    }
    return this.qNr.getCountryCode();
  }
  
  private void bXG()
  {
    if (this.qNr.getVisibility() == 0) {
      if ((bk.bl(bTM())) || (bk.bl(this.qNt.getText().toString()))) {
        break label70;
      }
    }
    label70:
    for (int i = 1; i != 0; i = 0)
    {
      this.qNx = bTM();
      this.foD = this.qNr.getMobileNumber();
      this.qNu.setEnabled(true);
      return;
    }
    this.qNu.setEnabled(false);
  }
  
  protected final boolean bTZ()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.payu_ui_startopen;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.foD = this.BX.getString("key_mobile");
    this.qNx = this.BX.getString("dial_code");
    if (bk.bl(this.qNx)) {
      this.qNx = "27";
    }
    this.qNq = ((WalletPayUOpenIntroView)findViewById(a.f.intro_view));
    this.qNq.setPagerData(new d[] { new d(a.e.payu_open_logo_1, a.i.wallet_payu_start_tip_1, a.i.wallet_payu_start_hint_1), new d(a.e.payu_open_logo_2, a.i.wallet_payu_start_tip_2, a.i.wallet_payu_start_hint_2), new d(a.e.payu_open_logo_3, a.i.wallet_payu_start_tip_3, a.i.wallet_payu_start_hint_3) });
    this.qNr = ((MMFormMobileInputView)findViewById(a.f.start_mobile_et));
    this.qNu = ((Button)findViewById(a.f.start_btn));
    this.qNs = this.qNr.getCountryCodeEditText();
    this.qNt = this.qNr.getMobileNumberEditText();
    if (!bk.bl(this.foD)) {
      this.qNt.setText(this.foD);
    }
    if (!bk.bl(this.qNx)) {
      this.qNs.setText(this.qNx);
    }
    paramBundle = new WalletPayUStartOpenUI.1(this);
    this.qNt.addTextChangedListener(paramBundle);
    this.qNs.addTextChangedListener(paramBundle);
    this.qNu.setOnClickListener(new WalletPayUStartOpenUI.2(this));
    this.qNv = ((TextView)findViewById(a.f.start_introduction_tv));
    c.a(this, this.qNv);
    this.qNw = ((TextView)findViewById(a.f.start_power_tv));
    this.qNw.setText(ab.cMK());
  }
  
  public void onResume()
  {
    super.onResume();
    bXG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI
 * JD-Core Version:    0.7.0.1
 */