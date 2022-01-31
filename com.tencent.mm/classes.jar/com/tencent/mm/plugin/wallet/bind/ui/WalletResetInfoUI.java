package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

@com.tencent.mm.ui.base.a(19)
public class WalletResetInfoUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private Button fpF;
  private TextView gSy;
  private Orders nEh;
  private Bankcard qhv;
  private WalletFormView qkA;
  private WalletFormView qkB;
  private WalletPhoneInputView qkC;
  private Authen qkD;
  private ElementQuery qkE;
  private WalletFormView qky;
  private WalletFormView qkz;
  
  private boolean YH()
  {
    if (!this.qkz.eq(null)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (this.qkC.getVisibility() == 0)
      {
        bool2 = bool1;
        if (this.qkC.bXi())
        {
          bool2 = bool1;
          if (!this.qkB.eq(null)) {
            bool2 = false;
          }
        }
      }
      if (!this.qkA.eq(null)) {
        bool2 = false;
      }
      if ((this.nEh == null) || (this.qkD == null)) {
        bool2 = false;
      }
      if (bool2)
      {
        this.fpF.setEnabled(true);
        this.fpF.setClickable(true);
        return bool2;
      }
      this.fpF.setEnabled(false);
      this.fpF.setClickable(false);
      return bool2;
    }
  }
  
  private boolean bTI()
  {
    return (this.BX.getInt("key_err_code", 408) == 408) && (this.qkE == null);
  }
  
  private void bTJ()
  {
    switch (this.BX.getInt("key_err_code", 408))
    {
    default: 
      if (this.BX.getBoolean("key_balance_change_phone_need_confirm_phone", true))
      {
        setMMTitle(a.i.wallet_reset_mobile_title);
        this.qkC.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      if (this.qhv != null)
      {
        y.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", new Object[] { this.qhv.field_bankPhone });
        this.gSy.setText(String.format(getString(a.i.wallet_reset_mobile_tips), new Object[] { this.qhv.field_bankPhone }));
      }
      if ((this.qkE == null) && (this.qhv != null)) {
        this.qkE = o.bVA().Qp(this.qhv.field_bankcardType);
      }
      if ((this.qkE != null) && (this.qkE.quZ)) {
        this.qkA.setVisibility(0);
      }
      if ((this.qkE != null) && (this.qkE.qva)) {
        this.qkz.setVisibility(0);
      }
      for (;;)
      {
        this.fpF = ((Button)findViewById(a.f.next_btn));
        this.fpF.setOnClickListener(new WalletResetInfoUI.1(this));
        YH();
        if (!bTI()) {
          break;
        }
        vN(4);
        return;
        setMMTitle(a.i.wallet_reset_cvv_title);
        this.qkA.setVisibility(0);
        this.gSy.setText(a.i.wallet_reset_cvv_tips);
        continue;
        setMMTitle(a.i.wallet_reset_valid_date_title);
        this.qkz.setVisibility(0);
        this.gSy.setText(a.i.wallet_reset_valid_date_tips);
      }
      setMMTitle(a.i.wallet_reset_mobile_info_tips);
    }
    vN(0);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("Micromsg.WalletResetInfoUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.BX;
      if (((paramm instanceof b)) || ((paramm instanceof c)))
      {
        paramm = (b)paramm;
        if (!paramm.qmb) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_verify_sms", bool);
          paramString.putString("kreq_token", paramm.token);
          if (paramm.qno) {
            paramString.putParcelable("key_orders", paramm.qmc);
          }
          paramm = paramm.mKP;
          if (paramm != null) {
            paramString.putParcelable("key_realname_guide_helper", paramm);
          }
          paramString.putInt("key_err_code", 0);
          com.tencent.mm.wallet_core.a.j(this, paramString);
          return true;
        }
      }
      if (((paramm instanceof t)) && (this.qhv != null))
      {
        this.qkE = o.bVA().Qq(this.qhv.field_bindSerial);
        bTJ();
      }
    }
    return false;
  }
  
  public final void gG(boolean paramBoolean)
  {
    YH();
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_reset_info_ui;
  }
  
  protected final void initView()
  {
    this.gSy = ((TextView)findViewById(a.f.wallet_reset_info_tips));
    Bankcard localBankcard = (Bankcard)this.BX.getParcelable("key_switch_phone_reset_bank_card");
    Object localObject = localBankcard;
    if (localBankcard == null) {
      localObject = (Bankcard)this.BX.getParcelable("key_bankcard");
    }
    this.qhv = ((Bankcard)localObject);
    this.nEh = ((Orders)this.BX.getParcelable("key_orders"));
    this.qkD = ((Authen)this.BX.getParcelable("key_authen"));
    if (TextUtils.isEmpty(this.BX.getString("key_pwd1", "")))
    {
      this.BX.putString("key_pwd1", this.qkD.qsI);
      y.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
    }
    this.qkE = ((ElementQuery)this.BX.getParcelable("elemt_query"));
    this.qkC = ((WalletPhoneInputView)findViewById(a.f.mobile_new_et));
    this.qkB = this.qkC.getPhoneNumberEt();
    if (this.qhv.qtQ == 1)
    {
      this.qkC.bXk();
      localObject = (EditText)this.qkC.findViewById(a.f.prefix_input_et);
      e(this.qkC.getPhoneNumberEt(), 0, false);
      a(this.qkC.getPhoneNumberEt(), (EditText)localObject, 0, false, false, true);
      this.qky = ((WalletFormView)findViewById(a.f.bankcard_et));
      this.qkz = ((WalletFormView)findViewById(a.f.date_et));
      com.tencent.mm.wallet_core.ui.formview.a.a(this, this.qkz);
      this.qkA = ((WalletFormView)findViewById(a.f.cvv_et));
      com.tencent.mm.wallet_core.ui.formview.a.b(this, this.qkA);
      this.qkz.setOnInputValidChangeListener(this);
      this.qkA.setOnInputValidChangeListener(this);
      this.qkB.setOnInputValidChangeListener(this);
      localObject = (MMScrollView)findViewById(a.f.wallet_sv);
      ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
      if (this.qhv == null) {
        break label396;
      }
      this.qky.setText(this.qhv.field_desc);
    }
    for (;;)
    {
      bTJ();
      if (bTI()) {
        a(new t("", "", null), true, false);
      }
      return;
      this.qkC.bXj();
      break;
      label396:
      this.qky.setVisibility(8);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.qkC.e(paramInt1, paramInt2, paramIntent)) {
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI
 * JD-Core Version:    0.7.0.1
 */