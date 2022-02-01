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
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUChangeBankcardUI
  extends WalletChangeBankcardUI
{
  private String Dte;
  private com.tencent.mm.sdk.b.c Dtf;
  
  public WalletPayUChangeBankcardUI()
  {
    AppMethodBeat.i(72106);
    this.Dte = null;
    this.Dtf = new WalletPayUChangeBankcardUI.4(this);
    AppMethodBeat.o(72106);
  }
  
  public final void aEf(String paramString)
  {
    AppMethodBeat.i(72111);
    this.CGx.CTP = paramString;
    label168:
    Object localObject;
    boolean bool;
    if (this.CyD != null)
    {
      getInput().putString("key_mobile", this.CyD.field_mobile);
      getInput().putParcelable("key_bankcard", this.CyD);
      this.CGx.wBI = this.CyD.field_bindSerial;
      this.CGx.dkR = this.CyD.field_bankcardType;
      if (this.CIL == null) {
        break label340;
      }
      this.CGx.CTZ = this.CIL.CWL;
      if ((this.ygb != null) && (this.ygb.CYl != null)) {
        this.CGx.CTY = this.ygb.CYl.CGZ;
      }
      if ((this.ygb != null) && (this.ygb.CPj == 3))
      {
        if (!this.CyD.eEU()) {
          break label351;
        }
        this.CGx.dDp = 3;
        localObject = getInput();
        if (this.CyD.eEU()) {
          break label363;
        }
        bool = true;
        label187:
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putParcelable("key_authen", this.CGx);
    if ((this.mPayInfo.dCC == 32) || (this.mPayInfo.dCC == 31))
    {
      if (this.mPayInfo.dCC == 32) {
        ad.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.dlu, this.jqo, this.mPayInfo.htZ.getDouble("total_fee"), this.mPayInfo.htZ.getString("fee_type"), i, this.mPayInfo.htZ.getString("extinfo_key_1"), this.CyD.field_bindSerial, this.mPayInfo.htZ.getString("extinfo_key_4")));
        AppMethodBeat.o(72111);
        return;
        label340:
        this.CGx.CTZ = null;
        break;
        label351:
        this.CGx.dDp = 6;
        break label168;
        label363:
        bool = false;
        break label187;
      }
    }
    if (this.mPayInfo.dCC == 11)
    {
      paramString = this.jqo;
      localObject = this.Dte;
      String str1 = this.mPayInfo.dlu;
      double d = this.mPayInfo.htZ.getDouble("total_fee");
      String str2 = this.mPayInfo.htZ.getString("fee_type");
      String str3 = this.CyD.field_bindSerial;
      String str4 = this.CyD.field_bankcardType;
      com.tencent.mm.plugin.wallet.a.s.eDp();
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(paramString, (String)localObject, str1, d, str2, str3, str4, com.tencent.mm.plugin.wallet.a.s.eDq().CzB.field_bindSerial));
      AppMethodBeat.o(72111);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.a(this.mPayInfo.dlu, this.mPayInfo.htZ.getDouble("total_fee"), this.mPayInfo.htZ.getString("fee_type"), this.CyD.field_bankcardType, this.CyD.field_bindSerial, this.Dte, paramString));
    AppMethodBeat.o(72111);
  }
  
  public final k eDA()
  {
    AppMethodBeat.i(72109);
    a locala = new a(this, this.CyC, this.CII, this.ygb);
    AppMethodBeat.o(72109);
    return locala;
  }
  
  public final void eDB()
  {
    AppMethodBeat.i(72110);
    ad.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
    String str = getInput().getString("key_pwd1");
    if (bt.isNullOrNil(str))
    {
      setContentViewVisibility(4);
      this.CIH = b.a(this, this.ygb, this.CIL, this.CyD, new b.b()new View.OnClickListener
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, FavorPayInfo paramAnonymousFavorPayInfo)
        {
          AppMethodBeat.i(72102);
          WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this, paramAnonymousFavorPayInfo);
          WalletPayUChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this));
          WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this, paramAnonymousString1);
          WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this, paramAnonymousString2);
          WalletPayUChangeBankcardUI.this.hideVKB();
          WalletPayUChangeBankcardUI.this.aEf(paramAnonymousString1);
          AppMethodBeat.o(72102);
        }
      }, new View.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72103);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/pay/ui/WalletPayUChangeBankcardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this) != null) {
            WalletPayUChangeBankcardUI.c(WalletPayUChangeBankcardUI.this).dismiss();
          }
          WalletPayUChangeBankcardUI.e(WalletPayUChangeBankcardUI.this).f(WalletPayUChangeBankcardUI.d(WalletPayUChangeBankcardUI.this), true);
          WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this, (FavorPayInfo)paramAnonymousView.getTag());
          if (WalletPayUChangeBankcardUI.f(WalletPayUChangeBankcardUI.this) != null) {
            WalletPayUChangeBankcardUI.g(WalletPayUChangeBankcardUI.this).CWP = "";
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
      }, "CREDITCARD_PAYU".equals(this.CyD.field_bankcardType));
      AppMethodBeat.o(72110);
      return;
    }
    aEf(str);
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
    com.tencent.mm.sdk.b.a.IbL.c(this.Dtf);
    AppMethodBeat.o(72107);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(72108);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IbL.d(this.Dtf);
    AppMethodBeat.o(72108);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72112);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a)) || ((paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a)) || ((paramn instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))))
    {
      paramString = getInput();
      if (!bt.isNullOrNil(this.jqo)) {
        paramString.putString("key_pwd1", this.jqo);
      }
      paramString.putBoolean("key_need_verify_sms", false);
      paramString.putParcelable("key_pay_info", this.mPayInfo);
      paramString.putInt("key_pay_flag", 3);
      if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a))
      {
        com.tencent.mm.plugin.wallet_payu.pay.a.a locala = (com.tencent.mm.plugin.wallet_payu.pay.a.a)paramn;
        paramString.putString("transid", locala.oZO);
        paramString.putBoolean("key_should_redirect", locala.DsY);
        paramString.putString("key_gateway_code", locala.DrD);
        paramString.putString("key_gateway_reference", locala.DrC);
        paramString.putString("key_force_adjust_code", locala.DrF);
        paramString.putBoolean("key_should_force_adjust", locala.DsZ);
        if (locala.isSuccess()) {
          paramString.putParcelable("key_orders", com.tencent.mm.plugin.wallet_payu.pay.a.c.a(this.ygb, locala.Dta, locala.Dtb, locala.paX, locala.dxK));
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))
      {
        paramn = (com.tencent.mm.plugin.wallet_payu.balance.a.b)paramn;
        paramString.putString("transid", paramn.oZO);
        paramString.putBoolean("key_should_redirect", paramn.DrB);
        paramString.putString("key_gateway_code", paramn.DrD);
        paramString.putString("key_gateway_reference", paramn.DrC);
        paramString.putString("key_force_adjust_code", paramn.DrF);
        paramString.putBoolean("key_should_force_adjust", paramn.DrE);
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