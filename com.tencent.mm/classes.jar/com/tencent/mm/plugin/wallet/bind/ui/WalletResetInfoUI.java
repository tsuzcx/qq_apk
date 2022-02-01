package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.i;

@com.tencent.mm.ui.base.a(19)
public class WalletResetInfoUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private Orders OsJ;
  private Bankcard VcZ;
  private WalletFormView VkR;
  private WalletFormView VkS;
  private WalletFormView VkT;
  private WalletFormView VkU;
  private WalletPhoneInputView VkV;
  private Authen VkW;
  private ElementQuery VkX;
  private Button lDJ;
  private TextView ttU;
  
  private boolean bZk()
  {
    AppMethodBeat.i(69171);
    if (!this.VkS.mJ(null)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (this.VkV.getVisibility() == 0)
      {
        bool2 = bool1;
        if (this.VkV.ilN())
        {
          bool2 = bool1;
          if (!this.VkU.mJ(null)) {
            bool2 = false;
          }
        }
      }
      if (!this.VkT.mJ(null)) {
        bool2 = false;
      }
      if ((this.OsJ == null) || (this.VkW == null)) {
        bool2 = false;
      }
      if (bool2)
      {
        this.lDJ.setEnabled(true);
        this.lDJ.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(69171);
        return bool2;
        this.lDJ.setEnabled(false);
        this.lDJ.setClickable(false);
      }
    }
  }
  
  private boolean ifM()
  {
    AppMethodBeat.i(69167);
    if ((getInput().getInt("key_err_code", 408) == 408) && (this.VkX == null))
    {
      AppMethodBeat.o(69167);
      return true;
    }
    AppMethodBeat.o(69167);
    return false;
  }
  
  private void ifN()
  {
    AppMethodBeat.i(69168);
    switch (getInput().getInt("key_err_code", 408))
    {
    default: 
      if (getInput().getBoolean("key_balance_change_phone_need_confirm_phone", true))
      {
        setMMTitle(a.i.wallet_reset_mobile_title);
        this.VkV.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      if (this.VcZ != null)
      {
        Log.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", new Object[] { this.VcZ.field_bankPhone });
        this.ttU.setText(String.format(getString(a.i.wallet_reset_mobile_tips), new Object[] { this.VcZ.field_bankPhone }));
      }
      if ((this.VkX == null) && (this.VcZ != null)) {
        this.VkX = u.iiK().bgz(this.VcZ.field_bankcardType);
      }
      if ((this.VkX != null) && (this.VkX.VEZ)) {
        this.VkT.setVisibility(0);
      }
      if ((this.VkX != null) && (this.VkX.VFa)) {
        this.VkS.setVisibility(0);
      }
      for (;;)
      {
        this.lDJ = ((Button)findViewById(a.f.next_btn));
        this.lDJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69163);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/bind/ui/WalletResetInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (!WalletResetInfoUI.a(WalletResetInfoUI.this))
            {
              Log.w("Micromsg.WalletResetInfoUI", "input format illegal!");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletResetInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(69163);
              return;
            }
            if (WalletResetInfoUI.b(WalletResetInfoUI.this).getVisibility() == 0) {
              WalletResetInfoUI.c(WalletResetInfoUI.this).VCE = WalletResetInfoUI.b(WalletResetInfoUI.this).getText();
            }
            if (WalletResetInfoUI.d(WalletResetInfoUI.this).getVisibility() == 0) {
              WalletResetInfoUI.c(WalletResetInfoUI.this).VCF = Util.nullAs(WalletResetInfoUI.d(WalletResetInfoUI.this).getText(), "");
            }
            if (WalletResetInfoUI.e(WalletResetInfoUI.this).getVisibility() == 0)
            {
              WalletResetInfoUI.c(WalletResetInfoUI.this).VxX = Util.nullAs(WalletResetInfoUI.f(WalletResetInfoUI.this).getText(), "");
              paramAnonymousView = i.bEO(WalletResetInfoUI.c(WalletResetInfoUI.this).VxX);
              WalletResetInfoUI.this.getInput().putString("key_mobile", paramAnonymousView);
            }
            Log.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", new Object[] { WalletResetInfoUI.c(WalletResetInfoUI.this).hAk, WalletResetInfoUI.c(WalletResetInfoUI.this).MDt });
            WalletResetInfoUI.c(WalletResetInfoUI.this).VCz = 1;
            WalletResetInfoUI.c(WalletResetInfoUI.this).VCP = ("+" + WalletResetInfoUI.e(WalletResetInfoUI.this).getCountryCode());
            if (WalletResetInfoUI.this.getInput().getBoolean("key_is_changing_balance_phone_num", false)) {
              WalletResetInfoUI.this.doSceneProgress(com.tencent.mm.plugin.wallet.pay.a.a.b(WalletResetInfoUI.c(WalletResetInfoUI.this), WalletResetInfoUI.g(WalletResetInfoUI.this), WalletResetInfoUI.this.getInput().getBoolean("key_isbalance", false)));
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletResetInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(69163);
              return;
              paramAnonymousView = com.tencent.mm.plugin.wallet.pay.a.a.a(WalletResetInfoUI.c(WalletResetInfoUI.this), WalletResetInfoUI.g(WalletResetInfoUI.this), false);
              if (paramAnonymousView != null) {
                WalletResetInfoUI.this.doSceneProgress(paramAnonymousView);
              }
            }
          }
        });
        bZk();
        if (!ifM()) {
          break;
        }
        setContentViewVisibility(4);
        AppMethodBeat.o(69168);
        return;
        setMMTitle(a.i.wallet_reset_cvv_title);
        this.VkT.setVisibility(0);
        this.ttU.setText(a.i.wallet_reset_cvv_tips);
        continue;
        setMMTitle(a.i.wallet_reset_valid_date_title);
        this.VkS.setVisibility(0);
        this.ttU.setText(a.i.wallet_reset_valid_date_tips);
      }
      setMMTitle(a.i.wallet_reset_mobile_info_tips);
    }
    setContentViewVisibility(0);
    AppMethodBeat.o(69168);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_reset_info_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69166);
    this.ttU = ((TextView)findViewById(a.f.wallet_reset_info_tips));
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_switch_phone_reset_bank_card");
    Object localObject = localBankcard;
    if (localBankcard == null) {
      localObject = (Bankcard)getInput().getParcelable("key_bankcard");
    }
    this.VcZ = ((Bankcard)localObject);
    this.OsJ = ((Orders)getInput().getParcelable("key_orders"));
    this.VkW = ((Authen)getInput().getParcelable("key_authen"));
    if (this.VkW == null)
    {
      Log.w("Micromsg.WalletResetInfoUI", "authen is null!");
      AppMethodBeat.o(69166);
      return;
    }
    if (TextUtils.isEmpty(getInput().getString("key_pwd1", "")))
    {
      getInput().putString("key_pwd1", this.VkW.VCA);
      Log.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
    }
    this.VkX = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.VkV = ((WalletPhoneInputView)findViewById(a.f.mobile_new_et));
    this.VkU = this.VkV.getPhoneNumberEt();
    if (this.VcZ.VDH == 1)
    {
      this.VkV.ilP();
      localObject = (EditText)this.VkV.findViewById(a.f.prefix_input_et);
      setEditFocusListener(this.VkV.getPhoneNumberEt(), 0, false);
      setEditFocusListener(this.VkV.getPhoneNumberEt(), (EditText)localObject, 0, false, false, true);
      this.VkR = ((WalletFormView)findViewById(a.f.bankcard_et));
      this.VkS = ((WalletFormView)findViewById(a.f.date_et));
      com.tencent.mm.wallet_core.ui.formview.a.a(this, this.VkS);
      this.VkT = ((WalletFormView)findViewById(a.f.cvv_et));
      com.tencent.mm.wallet_core.ui.formview.a.b(this, this.VkT);
      this.VkS.setOnInputValidChangeListener(this);
      this.VkT.setOnInputValidChangeListener(this);
      this.VkU.setOnInputValidChangeListener(this);
      localObject = (MMScrollView)findViewById(a.f.wallet_sv);
      ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
      if (this.VcZ == null) {
        break label425;
      }
      this.VkR.setText(this.VcZ.field_desc);
    }
    for (;;)
    {
      ifN();
      if (ifM()) {
        doSceneProgress(new z("", "", null), true);
      }
      AppMethodBeat.o(69166);
      return;
      this.VkV.ilO();
      break;
      label425:
      this.VkR.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69170);
    if (this.VkV.j(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(69170);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(69170);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69164);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(69164);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69165);
    super.onDestroy();
    AppMethodBeat.o(69165);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(69172);
    bZk();
    AppMethodBeat.o(69172);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(69169);
    Log.d("Micromsg.WalletResetInfoUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      if (((paramp instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) || ((paramp instanceof c)))
      {
        paramp = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramp;
        if (!paramp.VmK) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_verify_sms", bool);
          paramString.putString("kreq_token", paramp.getToken());
          if (paramp.isPaySuccess) {
            paramString.putParcelable("key_orders", paramp.VmL);
          }
          paramp = paramp.MyJ;
          if (paramp != null) {
            paramString.putParcelable("key_realname_guide_helper", paramp);
          }
          paramString.putInt("key_err_code", 0);
          com.tencent.mm.wallet_core.a.k(this, paramString);
          AppMethodBeat.o(69169);
          return true;
        }
      }
      if (((paramp instanceof z)) && (this.VcZ != null))
      {
        this.VkX = u.iiK().bgA(this.VcZ.field_bindSerial);
        ifN();
      }
    }
    AppMethodBeat.o(69169);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI
 * JD-Core Version:    0.7.0.1
 */