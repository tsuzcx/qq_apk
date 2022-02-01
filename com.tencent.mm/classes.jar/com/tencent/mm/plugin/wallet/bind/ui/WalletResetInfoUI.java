package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
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
import com.tencent.mm.an.q;
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
import com.tencent.mm.wallet_core.ui.g;

@com.tencent.mm.ui.base.a(19)
public class WalletResetInfoUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private Orders Ivh;
  private Bankcard Ooj;
  private WalletFormView OvF;
  private WalletFormView OvG;
  private WalletFormView OvH;
  private WalletFormView OvI;
  private WalletPhoneInputView OvJ;
  private Authen OvK;
  private ElementQuery OvL;
  private Button jbJ;
  private TextView qpt;
  
  private boolean bAu()
  {
    AppMethodBeat.i(69171);
    if (!this.OvG.jf(null)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (this.OvJ.getVisibility() == 0)
      {
        bool2 = bool1;
        if (this.OvJ.gMz())
        {
          bool2 = bool1;
          if (!this.OvI.jf(null)) {
            bool2 = false;
          }
        }
      }
      if (!this.OvH.jf(null)) {
        bool2 = false;
      }
      if ((this.Ivh == null) || (this.OvK == null)) {
        bool2 = false;
      }
      if (bool2)
      {
        this.jbJ.setEnabled(true);
        this.jbJ.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(69171);
        return bool2;
        this.jbJ.setEnabled(false);
        this.jbJ.setClickable(false);
      }
    }
  }
  
  private boolean gGJ()
  {
    AppMethodBeat.i(69167);
    if ((getInput().getInt("key_err_code", 408) == 408) && (this.OvL == null))
    {
      AppMethodBeat.o(69167);
      return true;
    }
    AppMethodBeat.o(69167);
    return false;
  }
  
  private void gGK()
  {
    AppMethodBeat.i(69168);
    switch (getInput().getInt("key_err_code", 408))
    {
    default: 
      if (getInput().getBoolean("key_balance_change_phone_need_confirm_phone", true))
      {
        setMMTitle(a.i.wallet_reset_mobile_title);
        this.OvJ.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      if (this.Ooj != null)
      {
        Log.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", new Object[] { this.Ooj.field_bankPhone });
        this.qpt.setText(String.format(getString(a.i.wallet_reset_mobile_tips), new Object[] { this.Ooj.field_bankPhone }));
      }
      if ((this.OvL == null) && (this.Ooj != null)) {
        this.OvL = u.gJw().bgR(this.Ooj.field_bankcardType);
      }
      if ((this.OvL != null) && (this.OvL.OPf)) {
        this.OvH.setVisibility(0);
      }
      if ((this.OvL != null) && (this.OvL.OPg)) {
        this.OvG.setVisibility(0);
      }
      for (;;)
      {
        this.jbJ = ((Button)findViewById(a.f.next_btn));
        this.jbJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69163);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/bind/ui/WalletResetInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (!WalletResetInfoUI.a(WalletResetInfoUI.this))
            {
              Log.w("Micromsg.WalletResetInfoUI", "input format illegal!");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletResetInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(69163);
              return;
            }
            if (WalletResetInfoUI.b(WalletResetInfoUI.this).getVisibility() == 0) {
              WalletResetInfoUI.c(WalletResetInfoUI.this).OMT = WalletResetInfoUI.b(WalletResetInfoUI.this).getText();
            }
            if (WalletResetInfoUI.d(WalletResetInfoUI.this).getVisibility() == 0) {
              WalletResetInfoUI.c(WalletResetInfoUI.this).OMU = Util.nullAs(WalletResetInfoUI.d(WalletResetInfoUI.this).getText(), "");
            }
            if (WalletResetInfoUI.e(WalletResetInfoUI.this).getVisibility() == 0)
            {
              WalletResetInfoUI.c(WalletResetInfoUI.this).OIl = Util.nullAs(WalletResetInfoUI.f(WalletResetInfoUI.this).getText(), "");
              paramAnonymousView = g.bCq(WalletResetInfoUI.c(WalletResetInfoUI.this).OIl);
              WalletResetInfoUI.this.getInput().putString("key_mobile", paramAnonymousView);
            }
            Log.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", new Object[] { WalletResetInfoUI.c(WalletResetInfoUI.this).fvP, WalletResetInfoUI.c(WalletResetInfoUI.this).GGC });
            WalletResetInfoUI.c(WalletResetInfoUI.this).OMO = 1;
            WalletResetInfoUI.c(WalletResetInfoUI.this).ONe = ("+" + WalletResetInfoUI.e(WalletResetInfoUI.this).getCountryCode());
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
        bAu();
        if (!gGJ()) {
          break;
        }
        setContentViewVisibility(4);
        AppMethodBeat.o(69168);
        return;
        setMMTitle(a.i.wallet_reset_cvv_title);
        this.OvH.setVisibility(0);
        this.qpt.setText(a.i.wallet_reset_cvv_tips);
        continue;
        setMMTitle(a.i.wallet_reset_valid_date_title);
        this.OvG.setVisibility(0);
        this.qpt.setText(a.i.wallet_reset_valid_date_tips);
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
    this.qpt = ((TextView)findViewById(a.f.wallet_reset_info_tips));
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_switch_phone_reset_bank_card");
    Object localObject = localBankcard;
    if (localBankcard == null) {
      localObject = (Bankcard)getInput().getParcelable("key_bankcard");
    }
    this.Ooj = ((Bankcard)localObject);
    this.Ivh = ((Orders)getInput().getParcelable("key_orders"));
    this.OvK = ((Authen)getInput().getParcelable("key_authen"));
    if (this.OvK == null)
    {
      Log.w("Micromsg.WalletResetInfoUI", "authen is null!");
      AppMethodBeat.o(69166);
      return;
    }
    if (TextUtils.isEmpty(getInput().getString("key_pwd1", "")))
    {
      getInput().putString("key_pwd1", this.OvK.OMP);
      Log.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
    }
    this.OvL = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.OvJ = ((WalletPhoneInputView)findViewById(a.f.mobile_new_et));
    this.OvI = this.OvJ.getPhoneNumberEt();
    if (this.Ooj.ONW == 1)
    {
      this.OvJ.gMB();
      localObject = (EditText)this.OvJ.findViewById(a.f.prefix_input_et);
      setEditFocusListener(this.OvJ.getPhoneNumberEt(), 0, false);
      setEditFocusListener(this.OvJ.getPhoneNumberEt(), (EditText)localObject, 0, false, false, true);
      this.OvF = ((WalletFormView)findViewById(a.f.bankcard_et));
      this.OvG = ((WalletFormView)findViewById(a.f.date_et));
      com.tencent.mm.wallet_core.ui.formview.a.a(this, this.OvG);
      this.OvH = ((WalletFormView)findViewById(a.f.cvv_et));
      com.tencent.mm.wallet_core.ui.formview.a.b(this, this.OvH);
      this.OvG.setOnInputValidChangeListener(this);
      this.OvH.setOnInputValidChangeListener(this);
      this.OvI.setOnInputValidChangeListener(this);
      localObject = (MMScrollView)findViewById(a.f.wallet_sv);
      ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
      if (this.Ooj == null) {
        break label425;
      }
      this.OvF.setText(this.Ooj.field_desc);
    }
    for (;;)
    {
      gGK();
      if (gGJ()) {
        doSceneProgress(new z("", "", null), true);
      }
      AppMethodBeat.o(69166);
      return;
      this.OvJ.gMA();
      break;
      label425:
      this.OvF.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69170);
    if (this.OvJ.g(paramInt1, paramInt2, paramIntent))
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
    bAu();
    AppMethodBeat.o(69172);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69169);
    Log.d("Micromsg.WalletResetInfoUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      if (((paramq instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) || ((paramq instanceof c)))
      {
        paramq = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramq;
        if (!paramq.Oxz) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_verify_sms", bool);
          paramString.putString("kreq_token", paramq.getToken());
          if (paramq.isPaySuccess) {
            paramString.putParcelable("key_orders", paramq.OxA);
          }
          paramq = paramq.GCy;
          if (paramq != null) {
            paramString.putParcelable("key_realname_guide_helper", paramq);
          }
          paramString.putInt("key_err_code", 0);
          com.tencent.mm.wallet_core.a.l(this, paramString);
          AppMethodBeat.o(69169);
          return true;
        }
      }
      if (((paramq instanceof z)) && (this.Ooj != null))
      {
        this.OvL = u.gJw().bgS(this.Ooj.field_bindSerial);
        gGK();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI
 * JD-Core Version:    0.7.0.1
 */