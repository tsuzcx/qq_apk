package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUChangeBankcardUI
  extends WalletChangeBankcardUI
{
  private String DKJ;
  private com.tencent.mm.sdk.b.c DKK;
  
  public WalletPayUChangeBankcardUI()
  {
    AppMethodBeat.i(72106);
    this.DKJ = null;
    this.DKK = new WalletPayUChangeBankcardUI.4(this);
    AppMethodBeat.o(72106);
  }
  
  public final void aFy(String paramString)
  {
    AppMethodBeat.i(72111);
    this.CYd.Dlv = paramString;
    label168:
    Object localObject;
    boolean bool;
    if (this.CQi != null)
    {
      getInput().putString("key_mobile", this.CQi.field_mobile);
      getInput().putParcelable("key_bankcard", this.CQi);
      this.CYd.wRt = this.CQi.field_bindSerial;
      this.CYd.dlT = this.CQi.field_bankcardType;
      if (this.Dar == null) {
        break label340;
      }
      this.CYd.DlF = this.Dar.Doq;
      if ((this.yvS != null) && (this.yvS.DpQ != null)) {
        this.CYd.DlE = this.yvS.DpQ.CYF;
      }
      if ((this.yvS != null) && (this.yvS.DgN == 3))
      {
        if (!this.CQi.eIB()) {
          break label351;
        }
        this.CYd.dEu = 3;
        localObject = getInput();
        if (this.CQi.eIB()) {
          break label363;
        }
        bool = true;
        label187:
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putParcelable("key_authen", this.CYd);
    if ((this.mPayInfo.dDH == 32) || (this.mPayInfo.dDH == 31))
    {
      if (this.mPayInfo.dDH == 32) {
        ae.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.dmw, this.jth, this.mPayInfo.hwN.getDouble("total_fee"), this.mPayInfo.hwN.getString("fee_type"), i, this.mPayInfo.hwN.getString("extinfo_key_1"), this.CQi.field_bindSerial, this.mPayInfo.hwN.getString("extinfo_key_4")));
        AppMethodBeat.o(72111);
        return;
        label340:
        this.CYd.DlF = null;
        break;
        label351:
        this.CYd.dEu = 6;
        break label168;
        label363:
        bool = false;
        break label187;
      }
    }
    if (this.mPayInfo.dDH == 11)
    {
      paramString = this.jth;
      localObject = this.DKJ;
      String str1 = this.mPayInfo.dmw;
      double d = this.mPayInfo.hwN.getDouble("total_fee");
      String str2 = this.mPayInfo.hwN.getString("fee_type");
      String str3 = this.CQi.field_bindSerial;
      String str4 = this.CQi.field_bankcardType;
      com.tencent.mm.plugin.wallet.a.s.eGW();
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(paramString, (String)localObject, str1, d, str2, str3, str4, com.tencent.mm.plugin.wallet.a.s.eGX().CRg.field_bindSerial));
      AppMethodBeat.o(72111);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.a(this.mPayInfo.dmw, this.mPayInfo.hwN.getDouble("total_fee"), this.mPayInfo.hwN.getString("fee_type"), this.CQi.field_bankcardType, this.CQi.field_bindSerial, this.DKJ, paramString));
    AppMethodBeat.o(72111);
  }
  
  public final k eHh()
  {
    AppMethodBeat.i(72109);
    a locala = new a(this, this.CQh, this.Dao, this.yvS);
    AppMethodBeat.o(72109);
    return locala;
  }
  
  public final void eHi()
  {
    AppMethodBeat.i(72110);
    ae.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
    String str = getInput().getString("key_pwd1");
    if (bu.isNullOrNil(str))
    {
      setContentViewVisibility(4);
      this.Dan = b.a(this, this.yvS, this.Dar, this.CQi, new b.b()new View.OnClickListener
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, FavorPayInfo paramAnonymousFavorPayInfo)
        {
          AppMethodBeat.i(72102);
          WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this, paramAnonymousFavorPayInfo);
          WalletPayUChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this));
          WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this, paramAnonymousString1);
          WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this, paramAnonymousString2);
          WalletPayUChangeBankcardUI.this.hideVKB();
          WalletPayUChangeBankcardUI.this.aFy(paramAnonymousString1);
          AppMethodBeat.o(72102);
        }
      }, new View.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72103);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/pay/ui/WalletPayUChangeBankcardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this) != null) {
            WalletPayUChangeBankcardUI.c(WalletPayUChangeBankcardUI.this).dismiss();
          }
          WalletPayUChangeBankcardUI.e(WalletPayUChangeBankcardUI.this).f(WalletPayUChangeBankcardUI.d(WalletPayUChangeBankcardUI.this), true);
          WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this, (FavorPayInfo)paramAnonymousView.getTag());
          if (WalletPayUChangeBankcardUI.f(WalletPayUChangeBankcardUI.this) != null) {
            WalletPayUChangeBankcardUI.g(WalletPayUChangeBankcardUI.this).Dou = "";
          }
          WalletPayUChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.h(WalletPayUChangeBankcardUI.this));
          WalletPayUChangeBankcardUI.i(WalletPayUChangeBankcardUI.this);
          WalletPayUChangeBankcardUI.this.setContentViewVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/pay/ui/WalletPayUChangeBankcardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      }, "CREDITCARD_PAYU".equals(this.CQi.field_bankcardType));
      AppMethodBeat.o(72110);
      return;
    }
    aFy(str);
    AppMethodBeat.o(72110);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(72113);
    if (paramInt1 == 23351)
    {
      ae.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", new Object[] { Integer.valueOf(paramInt2) });
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
    com.tencent.mm.sdk.b.a.IvT.c(this.DKK);
    AppMethodBeat.o(72107);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(72108);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IvT.d(this.DKK);
    AppMethodBeat.o(72108);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72112);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a)) || ((paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a)) || ((paramn instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))))
    {
      paramString = getInput();
      if (!bu.isNullOrNil(this.jth)) {
        paramString.putString("key_pwd1", this.jth);
      }
      paramString.putBoolean("key_need_verify_sms", false);
      paramString.putParcelable("key_pay_info", this.mPayInfo);
      paramString.putInt("key_pay_flag", 3);
      if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a))
      {
        com.tencent.mm.plugin.wallet_payu.pay.a.a locala = (com.tencent.mm.plugin.wallet_payu.pay.a.a)paramn;
        paramString.putString("transid", locala.pgs);
        paramString.putBoolean("key_should_redirect", locala.DKD);
        paramString.putString("key_gateway_code", locala.DJi);
        paramString.putString("key_gateway_reference", locala.DJh);
        paramString.putString("key_force_adjust_code", locala.DJk);
        paramString.putBoolean("key_should_force_adjust", locala.DKE);
        if (locala.isSuccess()) {
          paramString.putParcelable("key_orders", com.tencent.mm.plugin.wallet_payu.pay.a.c.a(this.yvS, locala.DKF, locala.DKG, locala.phB, locala.dyP));
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))
      {
        paramn = (com.tencent.mm.plugin.wallet_payu.balance.a.b)paramn;
        paramString.putString("transid", paramn.pgs);
        paramString.putBoolean("key_should_redirect", paramn.DJg);
        paramString.putString("key_gateway_code", paramn.DJi);
        paramString.putString("key_gateway_reference", paramn.DJh);
        paramString.putString("key_force_adjust_code", paramn.DJk);
        paramString.putBoolean("key_should_force_adjust", paramn.DJj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */