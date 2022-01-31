package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.i;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUChangeBankcardUI
  extends WalletChangeBankcardUI
{
  private String uDj;
  private c uDk;
  
  public WalletPayUChangeBankcardUI()
  {
    AppMethodBeat.i(48466);
    this.uDj = null;
    this.uDk = new WalletPayUChangeBankcardUI.4(this);
    AppMethodBeat.o(48466);
  }
  
  public final void afb(String paramString)
  {
    AppMethodBeat.i(48471);
    this.tTD.ueW = paramString;
    label168:
    Object localObject;
    boolean bool;
    if (this.tNH != null)
    {
      getInput().putString("key_mobile", this.tNH.field_mobile);
      getInput().putParcelable("key_bankcard", this.tNH);
      this.tTD.por = this.tNH.field_bindSerial;
      this.tTD.poq = this.tNH.field_bankcardType;
      if (this.tVQ == null) {
        break label340;
      }
      this.tTD.ufh = this.tVQ.uhU;
      if ((this.qrf != null) && (this.qrf.ujm != null)) {
        this.tTD.ufg = this.qrf.ujm.tUf;
      }
      if ((this.qrf != null) && (this.qrf.ubU == 3))
      {
        if (!this.tNH.cTi()) {
          break label351;
        }
        this.tTD.bsY = 3;
        localObject = getInput();
        if (this.tNH.cTi()) {
          break label363;
        }
        bool = true;
        label187:
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putParcelable("key_authen", this.tTD);
    if ((this.mPayInfo.cCD == 32) || (this.mPayInfo.cCD == 31))
    {
      if (this.mPayInfo.cCD == 32) {
        ab.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.cnI, this.gJv, this.mPayInfo.wgv.getDouble("total_fee"), this.mPayInfo.wgv.getString("fee_type"), i, this.mPayInfo.wgv.getString("extinfo_key_1"), this.tNH.field_bindSerial, this.mPayInfo.wgv.getString("extinfo_key_4")));
        AppMethodBeat.o(48471);
        return;
        label340:
        this.tTD.ufh = null;
        break;
        label351:
        this.tTD.bsY = 6;
        break label168;
        label363:
        bool = false;
        break label187;
      }
    }
    if (this.mPayInfo.cCD == 11)
    {
      paramString = this.gJv;
      localObject = this.uDj;
      String str1 = this.mPayInfo.cnI;
      double d = this.mPayInfo.wgv.getDouble("total_fee");
      String str2 = this.mPayInfo.wgv.getString("fee_type");
      String str3 = this.tNH.field_bindSerial;
      String str4 = this.tNH.field_bankcardType;
      s.cRG();
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(paramString, (String)localObject, str1, d, str2, str3, str4, s.cRH().tOD.field_bindSerial));
      AppMethodBeat.o(48471);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.mPayInfo.cnI, this.mPayInfo.wgv.getDouble("total_fee"), this.mPayInfo.wgv.getString("fee_type"), this.tNH.field_bankcardType, this.tNH.field_bindSerial, this.uDj, paramString));
    AppMethodBeat.o(48471);
  }
  
  public final i cRS()
  {
    AppMethodBeat.i(48469);
    a locala = new a(this, this.tNG, this.tVN, this.qrf);
    AppMethodBeat.o(48469);
    return locala;
  }
  
  public final void cRT()
  {
    AppMethodBeat.i(48470);
    ab.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
    String str = getInput().getString("key_pwd1");
    if (bo.isNullOrNil(str))
    {
      setContentViewVisibility(4);
      this.tVM = b.a(this, this.qrf, this.tVQ, this.tNH, new WalletPayUChangeBankcardUI.1(this), new View.OnClickListener()new WalletPayUChangeBankcardUI.3
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48462);
          if (WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this) != null) {
            WalletPayUChangeBankcardUI.c(WalletPayUChangeBankcardUI.this).dismiss();
          }
          WalletPayUChangeBankcardUI.e(WalletPayUChangeBankcardUI.this).g(WalletPayUChangeBankcardUI.d(WalletPayUChangeBankcardUI.this), true);
          WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this, (FavorPayInfo)paramAnonymousView.getTag());
          if (WalletPayUChangeBankcardUI.f(WalletPayUChangeBankcardUI.this) != null) {
            WalletPayUChangeBankcardUI.g(WalletPayUChangeBankcardUI.this).uhY = "";
          }
          WalletPayUChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.h(WalletPayUChangeBankcardUI.this));
          WalletPayUChangeBankcardUI.i(WalletPayUChangeBankcardUI.this);
          WalletPayUChangeBankcardUI.this.setContentViewVisibility(0);
          AppMethodBeat.o(48462);
        }
      }, new WalletPayUChangeBankcardUI.3(this), "CREDITCARD_PAYU".equals(this.tNH.field_bankcardType));
      AppMethodBeat.o(48470);
      return;
    }
    afb(str);
    AppMethodBeat.o(48470);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48473);
    if (paramInt1 == 23351)
    {
      ab.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramInt2 == -1)
      {
        getInput().putBoolean("key_should_redirect", false);
        com.tencent.mm.wallet_core.a.j(this, getInput());
      }
      if (paramInt2 == 0) {
        com.tencent.mm.wallet_core.a.b(this, getInput(), 0);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(48473);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48467);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.ymk.c(this.uDk);
    AppMethodBeat.o(48467);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48468);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ymk.d(this.uDk);
    AppMethodBeat.o(48468);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48472);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((paramm instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b)) || ((paramm instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a)) || ((paramm instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))))
    {
      paramString = getInput();
      if (!bo.isNullOrNil(this.gJv)) {
        paramString.putString("key_pwd1", this.gJv);
      }
      paramString.putBoolean("key_need_verify_sms", false);
      paramString.putParcelable("key_pay_info", this.mPayInfo);
      paramString.putInt("key_pay_flag", 3);
      if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b))
      {
        com.tencent.mm.plugin.wallet_payu.pay.a.b localb = (com.tencent.mm.plugin.wallet_payu.pay.a.b)paramm;
        paramString.putString("transid", localb.kMN);
        paramString.putBoolean("key_should_redirect", localb.uDd);
        paramString.putString("key_gateway_code", localb.uBI);
        paramString.putString("key_gateway_reference", localb.uBH);
        paramString.putString("key_force_adjust_code", localb.uBK);
        paramString.putBoolean("key_should_force_adjust", localb.uDe);
        if (localb.isSuccess()) {
          paramString.putParcelable("key_orders", d.a(this.qrf, localb.uDf, localb.uDg, localb.timestamp, localb.umN));
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))
      {
        paramm = (com.tencent.mm.plugin.wallet_payu.balance.a.b)paramm;
        paramString.putString("transid", paramm.kMN);
        paramString.putBoolean("key_should_redirect", paramm.uBG);
        paramString.putString("key_gateway_code", paramm.uBI);
        paramString.putString("key_gateway_reference", paramm.uBH);
        paramString.putString("key_force_adjust_code", paramm.uBK);
        paramString.putBoolean("key_should_force_adjust", paramm.uBJ);
      }
      com.tencent.mm.wallet_core.a.j(this, paramString);
      AppMethodBeat.o(48472);
      return true;
    }
    AppMethodBeat.o(48472);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */