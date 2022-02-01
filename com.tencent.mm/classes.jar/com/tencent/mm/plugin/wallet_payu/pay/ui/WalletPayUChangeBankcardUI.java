package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.t;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUChangeBankcardUI
  extends WalletChangeBankcardUI
{
  private String PmJ;
  private IListener PmK;
  
  public WalletPayUChangeBankcardUI()
  {
    AppMethodBeat.i(72106);
    this.PmJ = null;
    this.PmK = new WalletPayUChangeBankcardUI.4(this);
    AppMethodBeat.o(72106);
  }
  
  public final void bgF(String paramString)
  {
    AppMethodBeat.i(72111);
    this.OvK.OMP = paramString;
    label168:
    Object localObject;
    boolean bool;
    if (this.OmO != null)
    {
      getInput().putString("key_mobile", this.OmO.field_mobile);
      getInput().putParcelable("key_bankcard", this.OmO);
      this.OvK.GGC = this.OmO.field_bindSerial;
      this.OvK.fvP = this.OmO.field_bankcardType;
      if (this.OxY == null) {
        break label340;
      }
      this.OvK.OMZ = this.OxY.OPI;
      if ((this.Ivh != null) && (this.Ivh.ORe != null)) {
        this.OvK.OMY = this.Ivh.ORe.Owm;
      }
      if ((this.Ivh != null) && (this.Ivh.OIp == 3))
      {
        if (!this.OmO.gIK()) {
          break label351;
        }
        this.OvK.cUP = 3;
        localObject = getInput();
        if (this.OmO.gIK()) {
          break label363;
        }
        bool = true;
        label187:
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putParcelable("key_authen", this.OvK);
    if ((this.mPayInfo.fOY == 32) || (this.mPayInfo.fOY == 31))
    {
      if (this.mPayInfo.fOY == 32) {
        Log.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.fwv, this.njf, this.mPayInfo.lfu.getDouble("total_fee"), this.mPayInfo.lfu.getString("fee_type"), i, this.mPayInfo.lfu.getString("extinfo_key_1"), this.OmO.field_bindSerial, this.mPayInfo.lfu.getString("extinfo_key_4")));
        AppMethodBeat.o(72111);
        return;
        label340:
        this.OvK.OMZ = null;
        break;
        label351:
        this.OvK.cUP = 6;
        break label168;
        label363:
        bool = false;
        break label187;
      }
    }
    if (this.mPayInfo.fOY == 11)
    {
      paramString = this.njf;
      localObject = this.PmJ;
      String str1 = this.mPayInfo.fwv;
      double d = this.mPayInfo.lfu.getDouble("total_fee");
      String str2 = this.mPayInfo.lfu.getString("fee_type");
      String str3 = this.OmO.field_bindSerial;
      String str4 = this.OmO.field_bankcardType;
      s.gGL();
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(paramString, (String)localObject, str1, d, str2, str3, str4, s.gGM().OnP.field_bindSerial));
      AppMethodBeat.o(72111);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.a(this.mPayInfo.fwv, this.mPayInfo.lfu.getDouble("total_fee"), this.mPayInfo.lfu.getString("fee_type"), this.OmO.field_bankcardType, this.OmO.field_bindSerial, this.PmJ, paramString));
    AppMethodBeat.o(72111);
  }
  
  public final l gGX()
  {
    AppMethodBeat.i(72109);
    a locala = new a(this, this.OmN, this.OxV, this.Ivh);
    AppMethodBeat.o(72109);
    return locala;
  }
  
  public final void gGY()
  {
    AppMethodBeat.i(72110);
    Log.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
    String str = getInput().getString("key_pwd1");
    if (Util.isNullOrNil(str))
    {
      setContentViewVisibility(4);
      this.OxU = b.a(this, this.Ivh, this.OxY, this.OmO, new b.b()new View.OnClickListener
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, FavorPayInfo paramAnonymousFavorPayInfo)
        {
          AppMethodBeat.i(72102);
          WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this, paramAnonymousFavorPayInfo);
          WalletPayUChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this));
          WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this, paramAnonymousString1);
          WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this, paramAnonymousString2);
          WalletPayUChangeBankcardUI.this.hideVKB();
          WalletPayUChangeBankcardUI.this.bgF(paramAnonymousString1);
          AppMethodBeat.o(72102);
        }
      }, new View.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72103);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_payu/pay/ui/WalletPayUChangeBankcardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this) != null) {
            WalletPayUChangeBankcardUI.c(WalletPayUChangeBankcardUI.this).dismiss();
          }
          WalletPayUChangeBankcardUI.e(WalletPayUChangeBankcardUI.this).i(WalletPayUChangeBankcardUI.d(WalletPayUChangeBankcardUI.this), true);
          WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this, (FavorPayInfo)paramAnonymousView.getTag());
          if (WalletPayUChangeBankcardUI.f(WalletPayUChangeBankcardUI.this) != null) {
            WalletPayUChangeBankcardUI.g(WalletPayUChangeBankcardUI.this).OPM = "";
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
      }, "CREDITCARD_PAYU".equals(this.OmO.field_bankcardType));
      AppMethodBeat.o(72110);
      return;
    }
    bgF(str);
    AppMethodBeat.o(72110);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(72113);
    if (paramInt1 == 23351)
    {
      Log.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramInt2 == -1)
      {
        getInput().putBoolean("key_should_redirect", false);
        com.tencent.mm.wallet_core.a.l(this, getInput());
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
    EventCenter.instance.addListener(this.PmK);
    AppMethodBeat.o(72107);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(72108);
    super.onDestroy();
    EventCenter.instance.removeListener(this.PmK);
    AppMethodBeat.o(72108);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72112);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((paramq instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a)) || ((paramq instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a)) || ((paramq instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))))
    {
      paramString = getInput();
      if (!Util.isNullOrNil(this.njf)) {
        paramString.putString("key_pwd1", this.njf);
      }
      paramString.putBoolean("key_need_verify_sms", false);
      paramString.putParcelable("key_pay_info", this.mPayInfo);
      paramString.putInt("key_pay_flag", 3);
      if ((paramq instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a))
      {
        com.tencent.mm.plugin.wallet_payu.pay.a.a locala = (com.tencent.mm.plugin.wallet_payu.pay.a.a)paramq;
        paramString.putString("transid", locala.tUC);
        paramString.putBoolean("key_should_redirect", locala.PmD);
        paramString.putString("key_gateway_code", locala.Pli);
        paramString.putString("key_gateway_reference", locala.Plh);
        paramString.putString("key_force_adjust_code", locala.Plk);
        paramString.putBoolean("key_should_force_adjust", locala.PmE);
        if (locala.isSuccess()) {
          paramString.putParcelable("key_orders", c.a(this.Ivh, locala.PmF, locala.PmG, locala.dXr, locala.fJC));
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))
      {
        paramq = (com.tencent.mm.plugin.wallet_payu.balance.a.b)paramq;
        paramString.putString("transid", paramq.tUC);
        paramString.putBoolean("key_should_redirect", paramq.Plg);
        paramString.putString("key_gateway_code", paramq.Pli);
        paramString.putString("key_gateway_reference", paramq.Plh);
        paramString.putString("key_force_adjust_code", paramq.Plk);
        paramString.putBoolean("key_should_force_adjust", paramq.Plj);
      }
      com.tencent.mm.wallet_core.a.l(this, paramString);
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