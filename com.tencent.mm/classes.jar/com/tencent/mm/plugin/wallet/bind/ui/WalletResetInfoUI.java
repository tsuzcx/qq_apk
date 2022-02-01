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
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.x;
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
  private WalletFormView CGs;
  private WalletFormView CGt;
  private WalletFormView CGu;
  private WalletFormView CGv;
  private WalletPhoneInputView CGw;
  private Authen CGx;
  private ElementQuery CGy;
  private Bankcard CzV;
  private Button fQh;
  private TextView lZb;
  private Orders ygb;
  
  private boolean aUW()
  {
    AppMethodBeat.i(69171);
    if (!this.CGt.ho(null)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (this.CGw.getVisibility() == 0)
      {
        bool2 = bool1;
        if (this.CGw.eIE())
        {
          bool2 = bool1;
          if (!this.CGv.ho(null)) {
            bool2 = false;
          }
        }
      }
      if (!this.CGu.ho(null)) {
        bool2 = false;
      }
      if ((this.ygb == null) || (this.CGx == null)) {
        bool2 = false;
      }
      if (bool2)
      {
        this.fQh.setEnabled(true);
        this.fQh.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(69171);
        return bool2;
        this.fQh.setEnabled(false);
        this.fQh.setClickable(false);
      }
    }
  }
  
  private boolean eDn()
  {
    AppMethodBeat.i(69167);
    if ((getInput().getInt("key_err_code", 408) == 408) && (this.CGy == null))
    {
      AppMethodBeat.o(69167);
      return true;
    }
    AppMethodBeat.o(69167);
    return false;
  }
  
  private void eDo()
  {
    AppMethodBeat.i(69168);
    switch (getInput().getInt("key_err_code", 408))
    {
    default: 
      if (getInput().getBoolean("key_balance_change_phone_need_confirm_phone", true))
      {
        setMMTitle(2131765808);
        this.CGw.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      if (this.CzV != null)
      {
        ad.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", new Object[] { this.CzV.field_bankPhone });
        this.lZb.setText(String.format(getString(2131765807), new Object[] { this.CzV.field_bankPhone }));
      }
      if ((this.CGy == null) && (this.CzV != null)) {
        this.CGy = t.eFG().aEp(this.CzV.field_bankcardType);
      }
      if ((this.CGy != null) && (this.CGy.CWi)) {
        this.CGu.setVisibility(0);
      }
      if ((this.CGy != null) && (this.CGy.CWj)) {
        this.CGt.setVisibility(0);
      }
      for (;;)
      {
        this.fQh = ((Button)findViewById(2131302852));
        this.fQh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(69163);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletResetInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (!WalletResetInfoUI.a(WalletResetInfoUI.this))
            {
              ad.w("Micromsg.WalletResetInfoUI", "input format illegal!");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletResetInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(69163);
              return;
            }
            if (WalletResetInfoUI.b(WalletResetInfoUI.this).getVisibility() == 0) {
              WalletResetInfoUI.c(WalletResetInfoUI.this).CTT = WalletResetInfoUI.b(WalletResetInfoUI.this).getText();
            }
            if (WalletResetInfoUI.d(WalletResetInfoUI.this).getVisibility() == 0) {
              WalletResetInfoUI.c(WalletResetInfoUI.this).CTU = bt.bI(WalletResetInfoUI.d(WalletResetInfoUI.this).getText(), "");
            }
            if (WalletResetInfoUI.e(WalletResetInfoUI.this).getVisibility() == 0)
            {
              WalletResetInfoUI.c(WalletResetInfoUI.this).CPf = bt.bI(WalletResetInfoUI.f(WalletResetInfoUI.this).getText(), "");
              paramAnonymousView = e.aYI(WalletResetInfoUI.c(WalletResetInfoUI.this).CPf);
              WalletResetInfoUI.this.getInput().putString("key_mobile", paramAnonymousView);
            }
            ad.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", new Object[] { WalletResetInfoUI.c(WalletResetInfoUI.this).dkR, WalletResetInfoUI.c(WalletResetInfoUI.this).wBI });
            WalletResetInfoUI.c(WalletResetInfoUI.this).CTO = 1;
            WalletResetInfoUI.c(WalletResetInfoUI.this).CUe = ("+" + WalletResetInfoUI.e(WalletResetInfoUI.this).getCountryCode());
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
        aUW();
        if (!eDn()) {
          break;
        }
        setContentViewVisibility(4);
        AppMethodBeat.o(69168);
        return;
        setMMTitle(2131765804);
        this.CGu.setVisibility(0);
        this.lZb.setText(2131765803);
        continue;
        setMMTitle(2131765811);
        this.CGt.setVisibility(0);
        this.lZb.setText(2131765810);
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
    this.lZb = ((TextView)findViewById(2131306830));
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_switch_phone_reset_bank_card");
    Object localObject = localBankcard;
    if (localBankcard == null) {
      localObject = (Bankcard)getInput().getParcelable("key_bankcard");
    }
    this.CzV = ((Bankcard)localObject);
    this.ygb = ((Orders)getInput().getParcelable("key_orders"));
    this.CGx = ((Authen)getInput().getParcelable("key_authen"));
    if (this.CGx == null)
    {
      ad.w("Micromsg.WalletResetInfoUI", "authen is null!");
      AppMethodBeat.o(69166);
      return;
    }
    if (TextUtils.isEmpty(getInput().getString("key_pwd1", "")))
    {
      getInput().putString("key_pwd1", this.CGx.CTP);
      ad.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
    }
    this.CGy = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.CGw = ((WalletPhoneInputView)findViewById(2131302361));
    this.CGv = this.CGw.getPhoneNumberEt();
    if (this.CzV.CUX == 1)
    {
      this.CGw.eIG();
      localObject = (EditText)this.CGw.findViewById(2131303383);
      setEditFocusListener(this.CGw.getPhoneNumberEt(), 0, false);
      setEditFocusListener(this.CGw.getPhoneNumberEt(), (EditText)localObject, 0, false, false, true);
      this.CGs = ((WalletFormView)findViewById(2131297157));
      this.CGt = ((WalletFormView)findViewById(2131298929));
      com.tencent.mm.wallet_core.ui.formview.a.a(this, this.CGt);
      this.CGu = ((WalletFormView)findViewById(2131298914));
      com.tencent.mm.wallet_core.ui.formview.a.b(this, this.CGu);
      this.CGt.setOnInputValidChangeListener(this);
      this.CGu.setOnInputValidChangeListener(this);
      this.CGv.setOnInputValidChangeListener(this);
      localObject = (MMScrollView)findViewById(2131306834);
      ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
      if (this.CzV == null) {
        break label415;
      }
      this.CGs.setText(this.CzV.field_desc);
    }
    for (;;)
    {
      eDo();
      if (eDn()) {
        doSceneProgress(new y("", "", null), true);
      }
      AppMethodBeat.o(69166);
      return;
      this.CGw.eIF();
      break;
      label415:
      this.CGs.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69170);
    if (this.CGw.f(paramInt1, paramInt2, paramIntent))
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
    aUW();
    AppMethodBeat.o(69172);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(69169);
    ad.d("Micromsg.WalletResetInfoUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      if (((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) || ((paramn instanceof c)))
      {
        paramn = (com.tencent.mm.plugin.wallet.pay.a.a.b)paramn;
        if (!paramn.CIm) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.putBoolean("key_need_verify_sms", bool);
          paramString.putString("kreq_token", paramn.getToken());
          if (paramn.isPaySuccess) {
            paramString.putParcelable("key_orders", paramn.CIn);
          }
          paramn = paramn.wya;
          if (paramn != null) {
            paramString.putParcelable("key_realname_guide_helper", paramn);
          }
          paramString.putInt("key_err_code", 0);
          com.tencent.mm.wallet_core.a.k(this, paramString);
          AppMethodBeat.o(69169);
          return true;
        }
      }
      if (((paramn instanceof y)) && (this.CzV != null))
      {
        this.CGy = t.eFG().aEq(this.CzV.field_bindSerial);
        eDo();
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