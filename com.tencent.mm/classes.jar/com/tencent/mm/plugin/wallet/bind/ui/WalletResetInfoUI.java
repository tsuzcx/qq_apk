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
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

@com.tencent.mm.ui.base.a(19)
public class WalletResetInfoUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private Button ftn;
  private TextView kXT;
  private Orders vIq;
  private Bankcard zMX;
  private WalletFormView zNK;
  private WalletFormView zNL;
  private WalletFormView zNM;
  private WalletFormView zNN;
  private WalletPhoneInputView zNO;
  private Authen zNP;
  private ElementQuery zNQ;
  
  private boolean aKT()
  {
    AppMethodBeat.i(69171);
    if (!this.zNL.gF(null)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (this.zNO.getVisibility() == 0)
      {
        bool2 = bool1;
        if (this.zNO.efd())
        {
          bool2 = bool1;
          if (!this.zNN.gF(null)) {
            bool2 = false;
          }
        }
      }
      if (!this.zNM.gF(null)) {
        bool2 = false;
      }
      if ((this.vIq == null) || (this.zNP == null)) {
        bool2 = false;
      }
      if (bool2)
      {
        this.ftn.setEnabled(true);
        this.ftn.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(69171);
        return bool2;
        this.ftn.setEnabled(false);
        this.ftn.setClickable(false);
      }
    }
  }
  
  private boolean dZR()
  {
    AppMethodBeat.i(69167);
    if ((getInput().getInt("key_err_code", 408) == 408) && (this.zNQ == null))
    {
      AppMethodBeat.o(69167);
      return true;
    }
    AppMethodBeat.o(69167);
    return false;
  }
  
  private void dZS()
  {
    AppMethodBeat.i(69168);
    switch (getInput().getInt("key_err_code", 408))
    {
    default: 
      if (getInput().getBoolean("key_balance_change_phone_need_confirm_phone", true))
      {
        setMMTitle(2131765808);
        this.zNO.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      if (this.zMX != null)
      {
        ad.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", new Object[] { this.zMX.field_bankPhone });
        this.kXT.setText(String.format(getString(2131765807), new Object[] { this.zMX.field_bankPhone }));
      }
      if ((this.zNQ == null) && (this.zMX != null)) {
        this.zNQ = s.eck().atP(this.zMX.field_bankcardType);
      }
      if ((this.zNQ != null) && (this.zNQ.Ady)) {
        this.zNM.setVisibility(0);
      }
      if ((this.zNQ != null) && (this.zNQ.Adz)) {
        this.zNL.setVisibility(0);
      }
      for (;;)
      {
        this.ftn = ((Button)findViewById(2131302852));
        this.ftn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69163);
            if (!WalletResetInfoUI.a(WalletResetInfoUI.this))
            {
              ad.w("Micromsg.WalletResetInfoUI", "input format illegal!");
              AppMethodBeat.o(69163);
              return;
            }
            if (WalletResetInfoUI.b(WalletResetInfoUI.this).getVisibility() == 0) {
              WalletResetInfoUI.c(WalletResetInfoUI.this).Abk = WalletResetInfoUI.b(WalletResetInfoUI.this).getText();
            }
            if (WalletResetInfoUI.d(WalletResetInfoUI.this).getVisibility() == 0) {
              WalletResetInfoUI.c(WalletResetInfoUI.this).Abl = bt.by(WalletResetInfoUI.d(WalletResetInfoUI.this).getText(), "");
            }
            if (WalletResetInfoUI.e(WalletResetInfoUI.this).getVisibility() == 0)
            {
              WalletResetInfoUI.c(WalletResetInfoUI.this).zWw = bt.by(WalletResetInfoUI.f(WalletResetInfoUI.this).getText(), "");
              paramAnonymousView = e.aNg(WalletResetInfoUI.c(WalletResetInfoUI.this).zWw);
              WalletResetInfoUI.this.getInput().putString("key_mobile", paramAnonymousView);
            }
            ad.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", new Object[] { WalletResetInfoUI.c(WalletResetInfoUI.this).dca, WalletResetInfoUI.c(WalletResetInfoUI.this).uns });
            WalletResetInfoUI.c(WalletResetInfoUI.this).Abf = 1;
            WalletResetInfoUI.c(WalletResetInfoUI.this).Abv = ("+" + WalletResetInfoUI.e(WalletResetInfoUI.this).getCountryCode());
            if (WalletResetInfoUI.this.getInput().getBoolean("key_is_changing_balance_phone_num", false))
            {
              WalletResetInfoUI.this.doSceneProgress(com.tencent.mm.plugin.wallet.pay.a.a.b(WalletResetInfoUI.c(WalletResetInfoUI.this), WalletResetInfoUI.g(WalletResetInfoUI.this), WalletResetInfoUI.this.getInput().getBoolean("key_isbalance", false)));
              AppMethodBeat.o(69163);
              return;
            }
            paramAnonymousView = com.tencent.mm.plugin.wallet.pay.a.a.a(WalletResetInfoUI.c(WalletResetInfoUI.this), WalletResetInfoUI.g(WalletResetInfoUI.this), false);
            if (paramAnonymousView != null) {
              WalletResetInfoUI.this.doSceneProgress(paramAnonymousView);
            }
            AppMethodBeat.o(69163);
          }
        });
        aKT();
        if (!dZR()) {
          break;
        }
        setContentViewVisibility(4);
        AppMethodBeat.o(69168);
        return;
        setMMTitle(2131765804);
        this.zNM.setVisibility(0);
        this.kXT.setText(2131765803);
        continue;
        setMMTitle(2131765811);
        this.zNL.setVisibility(0);
        this.kXT.setText(2131765810);
      }
      setMMTitle(2131765806);
    }
    setContentViewVisibility(0);
    AppMethodBeat.o(69168);
  }
  
  public int getLayoutId()
  {
    return 2131496022;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69166);
    this.kXT = ((TextView)findViewById(2131306830));
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_switch_phone_reset_bank_card");
    Object localObject = localBankcard;
    if (localBankcard == null) {
      localObject = (Bankcard)getInput().getParcelable("key_bankcard");
    }
    this.zMX = ((Bankcard)localObject);
    this.vIq = ((Orders)getInput().getParcelable("key_orders"));
    this.zNP = ((Authen)getInput().getParcelable("key_authen"));
    if (this.zNP == null)
    {
      ad.w("Micromsg.WalletResetInfoUI", "authen is null!");
      AppMethodBeat.o(69166);
      return;
    }
    if (TextUtils.isEmpty(getInput().getString("key_pwd1", "")))
    {
      getInput().putString("key_pwd1", this.zNP.Abg);
      ad.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
    }
    this.zNQ = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.zNO = ((WalletPhoneInputView)findViewById(2131302361));
    this.zNN = this.zNO.getPhoneNumberEt();
    if (this.zMX.Aco == 1)
    {
      this.zNO.eff();
      localObject = (EditText)this.zNO.findViewById(2131303383);
      setEditFocusListener(this.zNO.getPhoneNumberEt(), 0, false);
      setEditFocusListener(this.zNO.getPhoneNumberEt(), (EditText)localObject, 0, false, false, true);
      this.zNK = ((WalletFormView)findViewById(2131297157));
      this.zNL = ((WalletFormView)findViewById(2131298929));
      com.tencent.mm.wallet_core.ui.formview.a.a(this, this.zNL);
      this.zNM = ((WalletFormView)findViewById(2131298914));
      com.tencent.mm.wallet_core.ui.formview.a.b(this, this.zNM);
      this.zNL.setOnInputValidChangeListener(this);
      this.zNM.setOnInputValidChangeListener(this);
      this.zNN.setOnInputValidChangeListener(this);
      localObject = (MMScrollView)findViewById(2131306834);
      ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
      if (this.zMX == null) {
        break label415;
      }
      this.zNK.setText(this.zMX.field_desc);
    }
    for (;;)
    {
      dZS();
      if (dZR()) {
        doSceneProgress(new y("", "", null), true);
      }
      AppMethodBeat.o(69166);
      return;
      this.zNO.efe();
      break;
      label415:
      this.zNK.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69170);
    if (this.zNO.f(paramInt1, paramInt2, paramIntent))
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
    aKT();
    AppMethodBeat.o(69172);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(69169);
    ad.d("Micromsg.WalletResetInfoUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      if (((paramn instanceof b)) || ((paramn instanceof c)))
      {
        paramn = (b)paramn;
        if (!paramn.zPE) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_verify_sms", bool);
          paramString.putString("kreq_token", paramn.getToken());
          if (paramn.isPaySuccess) {
            paramString.putParcelable("key_orders", paramn.zPF);
          }
          paramn = paramn.ujM;
          if (paramn != null) {
            paramString.putParcelable("key_realname_guide_helper", paramn);
          }
          paramString.putInt("key_err_code", 0);
          com.tencent.mm.wallet_core.a.k(this, paramString);
          AppMethodBeat.o(69169);
          return true;
        }
      }
      if (((paramn instanceof y)) && (this.zMX != null))
      {
        this.zNQ = s.eck().atQ(this.zMX.field_bindSerial);
        dZS();
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