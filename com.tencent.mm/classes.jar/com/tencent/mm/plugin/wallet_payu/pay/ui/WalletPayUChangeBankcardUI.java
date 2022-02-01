package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUChangeBankcardUI
  extends WalletChangeBankcardUI
{
  private String AAp;
  private com.tencent.mm.sdk.b.c AAq;
  
  public WalletPayUChangeBankcardUI()
  {
    AppMethodBeat.i(72106);
    this.AAp = null;
    this.AAq = new WalletPayUChangeBankcardUI.4(this);
    AppMethodBeat.o(72106);
  }
  
  public final void atF(String paramString)
  {
    AppMethodBeat.i(72111);
    this.zNP.Abg = paramString;
    label168:
    Object localObject;
    boolean bool;
    if (this.zGh != null)
    {
      getInput().putString("key_mobile", this.zGh.field_mobile);
      getInput().putParcelable("key_bankcard", this.zGh);
      this.zNP.uns = this.zGh.field_bindSerial;
      this.zNP.dca = this.zGh.field_bankcardType;
      if (this.zQd == null) {
        break label340;
      }
      this.zNP.Abq = this.zQd.Aeb;
      if ((this.vIq != null) && (this.vIq.Afy != null)) {
        this.zNP.Abp = this.vIq.Afy.zOr;
      }
      if ((this.vIq != null) && (this.vIq.zWA == 3))
      {
        if (!this.zGh.eby()) {
          break label351;
        }
        this.zNP.dtM = 3;
        localObject = getInput();
        if (this.zGh.eby()) {
          break label363;
        }
        bool = true;
        label187:
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putParcelable("key_authen", this.zNP);
    if ((this.mPayInfo.dtb == 32) || (this.mPayInfo.dtb == 31))
    {
      if (this.mPayInfo.dtb == 32) {
        ad.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.dcE, this.ixc, this.mPayInfo.Cos.getDouble("total_fee"), this.mPayInfo.Cos.getString("fee_type"), i, this.mPayInfo.Cos.getString("extinfo_key_1"), this.zGh.field_bindSerial, this.mPayInfo.Cos.getString("extinfo_key_4")));
        AppMethodBeat.o(72111);
        return;
        label340:
        this.zNP.Abq = null;
        break;
        label351:
        this.zNP.dtM = 6;
        break label168;
        label363:
        bool = false;
        break label187;
      }
    }
    if (this.mPayInfo.dtb == 11)
    {
      paramString = this.ixc;
      localObject = this.AAp;
      String str1 = this.mPayInfo.dcE;
      double d = this.mPayInfo.Cos.getDouble("total_fee");
      String str2 = this.mPayInfo.Cos.getString("fee_type");
      String str3 = this.zGh.field_bindSerial;
      String str4 = this.zGh.field_bankcardType;
      com.tencent.mm.plugin.wallet.a.s.dZT();
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(paramString, (String)localObject, str1, d, str2, str3, str4, com.tencent.mm.plugin.wallet.a.s.dZU().zHd.field_bindSerial));
      AppMethodBeat.o(72111);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.a(this.mPayInfo.dcE, this.mPayInfo.Cos.getDouble("total_fee"), this.mPayInfo.Cos.getString("fee_type"), this.zGh.field_bankcardType, this.zGh.field_bindSerial, this.AAp, paramString));
    AppMethodBeat.o(72111);
  }
  
  public final k eae()
  {
    AppMethodBeat.i(72109);
    a locala = new a(this, this.zGg, this.zQa, this.vIq);
    AppMethodBeat.o(72109);
    return locala;
  }
  
  public final void eaf()
  {
    AppMethodBeat.i(72110);
    ad.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
    String str = getInput().getString("key_pwd1");
    if (bt.isNullOrNil(str))
    {
      setContentViewVisibility(4);
      this.zPZ = b.a(this, this.vIq, this.zQd, this.zGh, new b.b()new View.OnClickListener
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, FavorPayInfo paramAnonymousFavorPayInfo)
        {
          AppMethodBeat.i(72102);
          WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this, paramAnonymousFavorPayInfo);
          WalletPayUChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this));
          WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this, paramAnonymousString1);
          WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this, paramAnonymousString2);
          WalletPayUChangeBankcardUI.this.hideVKB();
          WalletPayUChangeBankcardUI.this.atF(paramAnonymousString1);
          AppMethodBeat.o(72102);
        }
      }, new View.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72103);
          if (WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this) != null) {
            WalletPayUChangeBankcardUI.c(WalletPayUChangeBankcardUI.this).dismiss();
          }
          WalletPayUChangeBankcardUI.e(WalletPayUChangeBankcardUI.this).f(WalletPayUChangeBankcardUI.d(WalletPayUChangeBankcardUI.this), true);
          WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this, (FavorPayInfo)paramAnonymousView.getTag());
          if (WalletPayUChangeBankcardUI.f(WalletPayUChangeBankcardUI.this) != null) {
            WalletPayUChangeBankcardUI.g(WalletPayUChangeBankcardUI.this).Aef = "";
          }
          WalletPayUChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.h(WalletPayUChangeBankcardUI.this));
          WalletPayUChangeBankcardUI.i(WalletPayUChangeBankcardUI.this);
          WalletPayUChangeBankcardUI.this.setContentViewVisibility(0);
          AppMethodBeat.o(72103);
        }
      }, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(72104);
          WalletPayUChangeBankcardUI.j(WalletPayUChangeBankcardUI.this);
          if (WalletPayUChangeBankcardUI.k(WalletPayUChangeBankcardUI.this).getVisibility() != 0) {
            WalletPayUChangeBankcardUI.l(WalletPayUChangeBankcardUI.this);
          }
          AppMethodBeat.o(72104);
        }
      }, "CREDITCARD_PAYU".equals(this.zGh.field_bankcardType));
      AppMethodBeat.o(72110);
      return;
    }
    atF(str);
    AppMethodBeat.o(72110);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(72113);
    if (paramInt1 == 23351)
    {
      ad.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramInt2 == -1)
      {
        getInput().putBoolean("key_should_redirect", false);
        com.tencent.mm.wallet_core.a.k(this, getInput());
      }
      if (paramInt2 == 0) {
        com.tencent.mm.wallet_core.a.b(this, getInput(), 0);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(72113);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72107);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.ESL.c(this.AAq);
    AppMethodBeat.o(72107);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(72108);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ESL.d(this.AAq);
    AppMethodBeat.o(72108);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72112);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a)) || ((paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a)) || ((paramn instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))))
    {
      paramString = getInput();
      if (!bt.isNullOrNil(this.ixc)) {
        paramString.putString("key_pwd1", this.ixc);
      }
      paramString.putBoolean("key_need_verify_sms", false);
      paramString.putParcelable("key_pay_info", this.mPayInfo);
      paramString.putInt("key_pay_flag", 3);
      if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a))
      {
        com.tencent.mm.plugin.wallet_payu.pay.a.a locala = (com.tencent.mm.plugin.wallet_payu.pay.a.a)paramn;
        paramString.putString("transid", locala.nSY);
        paramString.putBoolean("key_should_redirect", locala.AAj);
        paramString.putString("key_gateway_code", locala.AyO);
        paramString.putString("key_gateway_reference", locala.AyN);
        paramString.putString("key_force_adjust_code", locala.AyQ);
        paramString.putBoolean("key_should_force_adjust", locala.AAk);
        if (locala.isSuccess()) {
          paramString.putParcelable("key_orders", com.tencent.mm.plugin.wallet_payu.pay.a.c.a(this.vIq, locala.AAl, locala.AAm, locala.nUh, locala.don));
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))
      {
        paramn = (com.tencent.mm.plugin.wallet_payu.balance.a.b)paramn;
        paramString.putString("transid", paramn.nSY);
        paramString.putBoolean("key_should_redirect", paramn.AyM);
        paramString.putString("key_gateway_code", paramn.AyO);
        paramString.putString("key_gateway_reference", paramn.AyN);
        paramString.putString("key_force_adjust_code", paramn.AyQ);
        paramString.putBoolean("key_should_force_adjust", paramn.AyP);
      }
      com.tencent.mm.wallet_core.a.k(this, paramString);
      AppMethodBeat.o(72112);
      return true;
    }
    AppMethodBeat.o(72112);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */