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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private Bankcard Bfr;
  private WalletFormView Bge;
  private WalletFormView Bgf;
  private WalletFormView Bgg;
  private WalletFormView Bgh;
  private WalletPhoneInputView Bgi;
  private Authen Bgj;
  private ElementQuery Bgk;
  private Button fwU;
  private TextView lzD;
  private Orders wSu;
  
  private boolean aRK()
  {
    AppMethodBeat.i(69171);
    if (!this.Bgf.gX(null)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (this.Bgi.getVisibility() == 0)
      {
        bool2 = bool1;
        if (this.Bgi.euy())
        {
          bool2 = bool1;
          if (!this.Bgh.gX(null)) {
            bool2 = false;
          }
        }
      }
      if (!this.Bgg.gX(null)) {
        bool2 = false;
      }
      if ((this.wSu == null) || (this.Bgj == null)) {
        bool2 = false;
      }
      if (bool2)
      {
        this.fwU.setEnabled(true);
        this.fwU.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(69171);
        return bool2;
        this.fwU.setEnabled(false);
        this.fwU.setClickable(false);
      }
    }
  }
  
  private boolean epn()
  {
    AppMethodBeat.i(69167);
    if ((getInput().getInt("key_err_code", 408) == 408) && (this.Bgk == null))
    {
      AppMethodBeat.o(69167);
      return true;
    }
    AppMethodBeat.o(69167);
    return false;
  }
  
  private void epo()
  {
    AppMethodBeat.i(69168);
    switch (getInput().getInt("key_err_code", 408))
    {
    default: 
      if (getInput().getBoolean("key_balance_change_phone_need_confirm_phone", true))
      {
        setMMTitle(2131765808);
        this.Bgi.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      if (this.Bfr != null)
      {
        ac.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", new Object[] { this.Bfr.field_bankPhone });
        this.lzD.setText(String.format(getString(2131765807), new Object[] { this.Bfr.field_bankPhone }));
      }
      if ((this.Bgk == null) && (this.Bfr != null)) {
        this.Bgk = s.erG().azh(this.Bfr.field_bankcardType);
      }
      if ((this.Bgk != null) && (this.Bgk.BvS)) {
        this.Bgg.setVisibility(0);
      }
      if ((this.Bgk != null) && (this.Bgk.BvT)) {
        this.Bgf.setVisibility(0);
      }
      for (;;)
      {
        this.fwU = ((Button)findViewById(2131302852));
        this.fwU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69163);
            if (!WalletResetInfoUI.a(WalletResetInfoUI.this))
            {
              ac.w("Micromsg.WalletResetInfoUI", "input format illegal!");
              AppMethodBeat.o(69163);
              return;
            }
            if (WalletResetInfoUI.b(WalletResetInfoUI.this).getVisibility() == 0) {
              WalletResetInfoUI.c(WalletResetInfoUI.this).BtE = WalletResetInfoUI.b(WalletResetInfoUI.this).getText();
            }
            if (WalletResetInfoUI.d(WalletResetInfoUI.this).getVisibility() == 0) {
              WalletResetInfoUI.c(WalletResetInfoUI.this).BtF = bs.bG(WalletResetInfoUI.d(WalletResetInfoUI.this).getText(), "");
            }
            if (WalletResetInfoUI.e(WalletResetInfoUI.this).getVisibility() == 0)
            {
              WalletResetInfoUI.c(WalletResetInfoUI.this).BoQ = bs.bG(WalletResetInfoUI.f(WalletResetInfoUI.this).getText(), "");
              paramAnonymousView = e.aSJ(WalletResetInfoUI.c(WalletResetInfoUI.this).BoQ);
              WalletResetInfoUI.this.getInput().putString("key_mobile", paramAnonymousView);
            }
            ac.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", new Object[] { WalletResetInfoUI.c(WalletResetInfoUI.this).cZz, WalletResetInfoUI.c(WalletResetInfoUI.this).vwo });
            WalletResetInfoUI.c(WalletResetInfoUI.this).Btz = 1;
            WalletResetInfoUI.c(WalletResetInfoUI.this).BtP = ("+" + WalletResetInfoUI.e(WalletResetInfoUI.this).getCountryCode());
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
        aRK();
        if (!epn()) {
          break;
        }
        setContentViewVisibility(4);
        AppMethodBeat.o(69168);
        return;
        setMMTitle(2131765804);
        this.Bgg.setVisibility(0);
        this.lzD.setText(2131765803);
        continue;
        setMMTitle(2131765811);
        this.Bgf.setVisibility(0);
        this.lzD.setText(2131765810);
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
    this.lzD = ((TextView)findViewById(2131306830));
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_switch_phone_reset_bank_card");
    Object localObject = localBankcard;
    if (localBankcard == null) {
      localObject = (Bankcard)getInput().getParcelable("key_bankcard");
    }
    this.Bfr = ((Bankcard)localObject);
    this.wSu = ((Orders)getInput().getParcelable("key_orders"));
    this.Bgj = ((Authen)getInput().getParcelable("key_authen"));
    if (this.Bgj == null)
    {
      ac.w("Micromsg.WalletResetInfoUI", "authen is null!");
      AppMethodBeat.o(69166);
      return;
    }
    if (TextUtils.isEmpty(getInput().getString("key_pwd1", "")))
    {
      getInput().putString("key_pwd1", this.Bgj.BtA);
      ac.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
    }
    this.Bgk = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.Bgi = ((WalletPhoneInputView)findViewById(2131302361));
    this.Bgh = this.Bgi.getPhoneNumberEt();
    if (this.Bfr.BuI == 1)
    {
      this.Bgi.euA();
      localObject = (EditText)this.Bgi.findViewById(2131303383);
      setEditFocusListener(this.Bgi.getPhoneNumberEt(), 0, false);
      setEditFocusListener(this.Bgi.getPhoneNumberEt(), (EditText)localObject, 0, false, false, true);
      this.Bge = ((WalletFormView)findViewById(2131297157));
      this.Bgf = ((WalletFormView)findViewById(2131298929));
      com.tencent.mm.wallet_core.ui.formview.a.a(this, this.Bgf);
      this.Bgg = ((WalletFormView)findViewById(2131298914));
      com.tencent.mm.wallet_core.ui.formview.a.b(this, this.Bgg);
      this.Bgf.setOnInputValidChangeListener(this);
      this.Bgg.setOnInputValidChangeListener(this);
      this.Bgh.setOnInputValidChangeListener(this);
      localObject = (MMScrollView)findViewById(2131306834);
      ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
      if (this.Bfr == null) {
        break label415;
      }
      this.Bge.setText(this.Bfr.field_desc);
    }
    for (;;)
    {
      epo();
      if (epn()) {
        doSceneProgress(new y("", "", null), true);
      }
      AppMethodBeat.o(69166);
      return;
      this.Bgi.euz();
      break;
      label415:
      this.Bge.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69170);
    if (this.Bgi.f(paramInt1, paramInt2, paramIntent))
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
    aRK();
    AppMethodBeat.o(69172);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(69169);
    ac.d("Micromsg.WalletResetInfoUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      if (((paramn instanceof b)) || ((paramn instanceof c)))
      {
        paramn = (b)paramn;
        if (!paramn.BhY) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_verify_sms", bool);
          paramString.putString("kreq_token", paramn.getToken());
          if (paramn.isPaySuccess) {
            paramString.putParcelable("key_orders", paramn.BhZ);
          }
          paramn = paramn.vsI;
          if (paramn != null) {
            paramString.putParcelable("key_realname_guide_helper", paramn);
          }
          paramString.putInt("key_err_code", 0);
          com.tencent.mm.wallet_core.a.k(this, paramString);
          AppMethodBeat.o(69169);
          return true;
        }
      }
      if (((paramn instanceof y)) && (this.Bfr != null))
      {
        this.Bgk = s.erG().azi(this.Bfr.field_bindSerial);
        epo();
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