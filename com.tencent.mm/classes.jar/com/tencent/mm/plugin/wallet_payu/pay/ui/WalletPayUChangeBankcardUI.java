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
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUChangeBankcardUI
  extends WalletChangeBankcardUI
{
  private String BSL;
  private com.tencent.mm.sdk.b.c BSM;
  
  public WalletPayUChangeBankcardUI()
  {
    AppMethodBeat.i(72106);
    this.BSL = null;
    this.BSM = new WalletPayUChangeBankcardUI.4(this);
    AppMethodBeat.o(72106);
  }
  
  public final void ayX(String paramString)
  {
    AppMethodBeat.i(72111);
    this.Bgj.BtA = paramString;
    label168:
    Object localObject;
    boolean bool;
    if (this.AYu != null)
    {
      getInput().putString("key_mobile", this.AYu.field_mobile);
      getInput().putParcelable("key_bankcard", this.AYu);
      this.Bgj.vwo = this.AYu.field_bindSerial;
      this.Bgj.cZz = this.AYu.field_bankcardType;
      if (this.Bix == null) {
        break label340;
      }
      this.Bgj.BtK = this.Bix.Bwv;
      if ((this.wSu != null) && (this.wSu.BxS != null)) {
        this.Bgj.BtJ = this.wSu.BxS.BgL;
      }
      if ((this.wSu != null) && (this.wSu.BoU == 3))
      {
        if (!this.AYu.eqU()) {
          break label351;
        }
        this.Bgj.drx = 3;
        localObject = getInput();
        if (this.AYu.eqU()) {
          break label363;
        }
        bool = true;
        label187:
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
      }
    }
    getInput().putParcelable("key_authen", this.Bgj);
    if ((this.mPayInfo.dqL == 32) || (this.mPayInfo.dqL == 31))
    {
      if (this.mPayInfo.dqL == 32) {
        ac.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.dac, this.iXf, this.mPayInfo.hbR.getDouble("total_fee"), this.mPayInfo.hbR.getString("fee_type"), i, this.mPayInfo.hbR.getString("extinfo_key_1"), this.AYu.field_bindSerial, this.mPayInfo.hbR.getString("extinfo_key_4")));
        AppMethodBeat.o(72111);
        return;
        label340:
        this.Bgj.BtK = null;
        break;
        label351:
        this.Bgj.drx = 6;
        break label168;
        label363:
        bool = false;
        break label187;
      }
    }
    if (this.mPayInfo.dqL == 11)
    {
      paramString = this.iXf;
      localObject = this.BSL;
      String str1 = this.mPayInfo.dac;
      double d = this.mPayInfo.hbR.getDouble("total_fee");
      String str2 = this.mPayInfo.hbR.getString("fee_type");
      String str3 = this.AYu.field_bindSerial;
      String str4 = this.AYu.field_bankcardType;
      com.tencent.mm.plugin.wallet.a.s.epp();
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(paramString, (String)localObject, str1, d, str2, str3, str4, com.tencent.mm.plugin.wallet.a.s.epq().AZp.field_bindSerial));
      AppMethodBeat.o(72111);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.a(this.mPayInfo.dac, this.mPayInfo.hbR.getDouble("total_fee"), this.mPayInfo.hbR.getString("fee_type"), this.AYu.field_bankcardType, this.AYu.field_bindSerial, this.BSL, paramString));
    AppMethodBeat.o(72111);
  }
  
  public final k epA()
  {
    AppMethodBeat.i(72109);
    a locala = new a(this, this.AYt, this.Biu, this.wSu);
    AppMethodBeat.o(72109);
    return locala;
  }
  
  public final void epB()
  {
    AppMethodBeat.i(72110);
    ac.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
    String str = getInput().getString("key_pwd1");
    if (bs.isNullOrNil(str))
    {
      setContentViewVisibility(4);
      this.Bit = b.a(this, this.wSu, this.Bix, this.AYu, new b.b()new View.OnClickListener
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, FavorPayInfo paramAnonymousFavorPayInfo)
        {
          AppMethodBeat.i(72102);
          WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this, paramAnonymousFavorPayInfo);
          WalletPayUChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this));
          WalletPayUChangeBankcardUI.a(WalletPayUChangeBankcardUI.this, paramAnonymousString1);
          WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this, paramAnonymousString2);
          WalletPayUChangeBankcardUI.this.hideVKB();
          WalletPayUChangeBankcardUI.this.ayX(paramAnonymousString1);
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
            WalletPayUChangeBankcardUI.g(WalletPayUChangeBankcardUI.this).Bwz = "";
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
      }, "CREDITCARD_PAYU".equals(this.AYu.field_bankcardType));
      AppMethodBeat.o(72110);
      return;
    }
    ayX(str);
    AppMethodBeat.o(72110);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(72113);
    if (paramInt1 == 23351)
    {
      ac.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", new Object[] { Integer.valueOf(paramInt2) });
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
    com.tencent.mm.sdk.b.a.GpY.c(this.BSM);
    AppMethodBeat.o(72107);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(72108);
    super.onDestroy();
    com.tencent.mm.sdk.b.a.GpY.d(this.BSM);
    AppMethodBeat.o(72108);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72112);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a)) || ((paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a)) || ((paramn instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))))
    {
      paramString = getInput();
      if (!bs.isNullOrNil(this.iXf)) {
        paramString.putString("key_pwd1", this.iXf);
      }
      paramString.putBoolean("key_need_verify_sms", false);
      paramString.putParcelable("key_pay_info", this.mPayInfo);
      paramString.putInt("key_pay_flag", 3);
      if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a))
      {
        com.tencent.mm.plugin.wallet_payu.pay.a.a locala = (com.tencent.mm.plugin.wallet_payu.pay.a.a)paramn;
        paramString.putString("transid", locala.owt);
        paramString.putBoolean("key_should_redirect", locala.BSF);
        paramString.putString("key_gateway_code", locala.BRk);
        paramString.putString("key_gateway_reference", locala.BRj);
        paramString.putString("key_force_adjust_code", locala.BRm);
        paramString.putBoolean("key_should_force_adjust", locala.BSG);
        if (locala.isSuccess()) {
          paramString.putParcelable("key_orders", com.tencent.mm.plugin.wallet_payu.pay.a.c.a(this.wSu, locala.BSH, locala.BSI, locala.oxC, locala.dlW));
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))
      {
        paramn = (com.tencent.mm.plugin.wallet_payu.balance.a.b)paramn;
        paramString.putString("transid", paramn.owt);
        paramString.putBoolean("key_should_redirect", paramn.BRi);
        paramString.putString("key_gateway_code", paramn.BRk);
        paramString.putString("key_gateway_reference", paramn.BRj);
        paramString.putString("key_force_adjust_code", paramn.BRm);
        paramString.putBoolean("key_should_force_adjust", paramn.BRl);
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