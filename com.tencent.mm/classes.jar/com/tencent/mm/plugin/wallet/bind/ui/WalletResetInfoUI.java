package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

@com.tencent.mm.ui.base.a(19)
public class WalletResetInfoUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private Button gHb;
  private TextView ivt;
  private Orders qrf;
  private Bankcard tOQ;
  private WalletFormView tTA;
  private WalletFormView tTB;
  private WalletPhoneInputView tTC;
  private Authen tTD;
  private ElementQuery tTE;
  private WalletFormView tTy;
  private WalletFormView tTz;
  
  private boolean asr()
  {
    AppMethodBeat.i(45827);
    if (!this.tTz.fE(null)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (this.tTC.getVisibility() == 0)
      {
        bool2 = bool1;
        if (this.tTC.cWJ())
        {
          bool2 = bool1;
          if (!this.tTB.fE(null)) {
            bool2 = false;
          }
        }
      }
      if (!this.tTA.fE(null)) {
        bool2 = false;
      }
      if ((this.qrf == null) || (this.tTD == null)) {
        bool2 = false;
      }
      if (bool2)
      {
        this.gHb.setEnabled(true);
        this.gHb.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(45827);
        return bool2;
        this.gHb.setEnabled(false);
        this.gHb.setClickable(false);
      }
    }
  }
  
  private boolean cRE()
  {
    AppMethodBeat.i(45823);
    if ((getInput().getInt("key_err_code", 408) == 408) && (this.tTE == null))
    {
      AppMethodBeat.o(45823);
      return true;
    }
    AppMethodBeat.o(45823);
    return false;
  }
  
  private void cRF()
  {
    AppMethodBeat.i(45824);
    switch (getInput().getInt("key_err_code", 408))
    {
    default: 
      if (getInput().getBoolean("key_balance_change_phone_need_confirm_phone", true))
      {
        setMMTitle(2131305592);
        this.tTC.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      if (this.tOQ != null)
      {
        ab.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", new Object[] { this.tOQ.field_bankPhone });
        this.ivt.setText(String.format(getString(2131305591), new Object[] { this.tOQ.field_bankPhone }));
      }
      if ((this.tTE == null) && (this.tOQ != null)) {
        this.tTE = t.cTV().afh(this.tOQ.field_bankcardType);
      }
      if ((this.tTE != null) && (this.tTE.uhr)) {
        this.tTA.setVisibility(0);
      }
      if ((this.tTE != null) && (this.tTE.uhs)) {
        this.tTz.setVisibility(0);
      }
      for (;;)
      {
        this.gHb = ((Button)findViewById(2131822914));
        this.gHb.setOnClickListener(new WalletResetInfoUI.1(this));
        asr();
        if (!cRE()) {
          break;
        }
        setContentViewVisibility(4);
        AppMethodBeat.o(45824);
        return;
        setMMTitle(2131305588);
        this.tTA.setVisibility(0);
        this.ivt.setText(2131305587);
        continue;
        setMMTitle(2131305595);
        this.tTz.setVisibility(0);
        this.ivt.setText(2131305594);
      }
      setMMTitle(2131305590);
    }
    setContentViewVisibility(0);
    AppMethodBeat.o(45824);
  }
  
  public int getLayoutId()
  {
    return 2130971245;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45821);
    this.ivt = ((TextView)findViewById(2131829384));
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_switch_phone_reset_bank_card");
    Object localObject = localBankcard;
    if (localBankcard == null) {
      localObject = (Bankcard)getInput().getParcelable("key_bankcard");
    }
    this.tOQ = ((Bankcard)localObject);
    this.qrf = ((Orders)getInput().getParcelable("key_orders"));
    this.tTD = ((Authen)getInput().getParcelable("key_authen"));
    if (this.tTD == null)
    {
      ab.w("Micromsg.WalletResetInfoUI", "authen is null!");
      AppMethodBeat.o(45821);
      return;
    }
    if (TextUtils.isEmpty(getInput().getString("key_pwd1", "")))
    {
      getInput().putString("key_pwd1", this.tTD.ueW);
      ab.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
    }
    this.tTE = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.tTC = ((WalletPhoneInputView)findViewById(2131829060));
    this.tTB = this.tTC.getPhoneNumberEt();
    if (this.tOQ.ugf == 1)
    {
      this.tTC.cWL();
      localObject = (EditText)this.tTC.findViewById(2131829352);
      setEditFocusListener(this.tTC.getPhoneNumberEt(), 0, false);
      setEditFocusListener(this.tTC.getPhoneNumberEt(), (EditText)localObject, 0, false, false, true);
      this.tTy = ((WalletFormView)findViewById(2131829385));
      this.tTz = ((WalletFormView)findViewById(2131826697));
      com.tencent.mm.wallet_core.ui.formview.a.a(this, this.tTz);
      this.tTA = ((WalletFormView)findViewById(2131826695));
      com.tencent.mm.wallet_core.ui.formview.a.b(this, this.tTA);
      this.tTz.setOnInputValidChangeListener(this);
      this.tTA.setOnInputValidChangeListener(this);
      this.tTB.setOnInputValidChangeListener(this);
      localObject = (MMScrollView)findViewById(2131823477);
      ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
      if (this.tOQ == null) {
        break label415;
      }
      this.tTy.setText(this.tOQ.field_desc);
    }
    for (;;)
    {
      cRF();
      if (cRE()) {
        doSceneProgress(new w("", "", null), true);
      }
      AppMethodBeat.o(45821);
      return;
      this.tTC.cWK();
      break;
      label415:
      this.tTy.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45826);
    if (this.tTC.e(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(45826);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(45826);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45819);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(45819);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45820);
    super.onDestroy();
    AppMethodBeat.o(45820);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(45828);
    asr();
    AppMethodBeat.o(45828);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45825);
    ab.d("Micromsg.WalletResetInfoUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      if (((paramm instanceof b)) || ((paramm instanceof c)))
      {
        paramm = (b)paramm;
        if (!paramm.tVq) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_verify_sms", bool);
          paramString.putString("kreq_token", paramm.getToken());
          if (paramm.isPaySuccess) {
            paramString.putParcelable("key_orders", paramm.tVr);
          }
          paramm = paramm.plg;
          if (paramm != null) {
            paramString.putParcelable("key_realname_guide_helper", paramm);
          }
          paramString.putInt("key_err_code", 0);
          com.tencent.mm.wallet_core.a.j(this, paramString);
          AppMethodBeat.o(45825);
          return true;
        }
      }
      if (((paramm instanceof w)) && (this.tOQ != null))
      {
        this.tTE = t.cTV().afi(this.tOQ.field_bindSerial);
        cRF();
      }
    }
    AppMethodBeat.o(45825);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI
 * JD-Core Version:    0.7.0.1
 */