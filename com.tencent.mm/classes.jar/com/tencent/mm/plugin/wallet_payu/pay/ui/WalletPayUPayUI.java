package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.yu;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUPayUI
  extends WalletPayUI
{
  private String DKJ = null;
  
  public final void aw(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(72133);
    this.Dbg = true;
    if (this.yvS != null) {
      paramBundle.putInt("key_support_bankcard", this.yvS.DgN);
    }
    if (!eHt()) {}
    for (;;)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      com.tencent.mm.wallet_core.a.a(this, d.class, paramBundle);
      AppMethodBeat.o(72133);
      return;
      bool = false;
    }
  }
  
  public final void eHi()
  {
    AppMethodBeat.i(72132);
    if (!aVv())
    {
      AppMethodBeat.o(72132);
      return;
    }
    ae.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
    this.Dby = b.a(this, this.yvS, this.Dar, this.CQi, new b.b()new View.OnClickListener
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, FavorPayInfo paramAnonymousFavorPayInfo)
      {
        AppMethodBeat.i(72124);
        WalletPayUPayUI.this.hideVKB();
        WalletPayUPayUI.a(WalletPayUPayUI.this, paramAnonymousString1);
        WalletPayUPayUI.b(WalletPayUPayUI.this, paramAnonymousString2);
        WalletPayUPayUI.this.un(false);
        f.eMB();
        AppMethodBeat.o(72124);
      }
    }, new View.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72125);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/pay/ui/WalletPayUPayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletPayUPayUI.a(WalletPayUPayUI.this, (FavorPayInfo)paramAnonymousView.getTag());
        if (WalletPayUPayUI.a(WalletPayUPayUI.this) != null) {
          WalletPayUPayUI.b(WalletPayUPayUI.this).Dou = "";
        }
        WalletPayUPayUI.c(WalletPayUPayUI.this, "");
        WalletPayUPayUI.c(WalletPayUPayUI.this).dismiss();
        WalletPayUPayUI.d(WalletPayUPayUI.this);
        WalletPayUPayUI.e(WalletPayUPayUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/pay/ui/WalletPayUPayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72125);
      }
    }, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(72126);
        WalletPayUPayUI.f(WalletPayUPayUI.this);
        WalletPayUPayUI.g(WalletPayUPayUI.this);
        if (WalletPayUPayUI.this.isTransparent()) {
          WalletPayUPayUI.this.finish();
        }
        AppMethodBeat.o(72126);
      }
    }, "CREDITCARD_PAYU".equals(this.CQi.field_bankcardType));
    AppMethodBeat.o(72132);
  }
  
  public final void eHo()
  {
    AppMethodBeat.i(72131);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.b(getPayInfo().dmw), getPayInfo().FEo);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.b.a(getPayInfo().dmw), getPayInfo().FEo);
    AppMethodBeat.o(72131);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72129);
    super.onCreate(paramBundle);
    AppMethodBeat.o(72129);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(72130);
    ae.i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(72130);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72135);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b))
      {
        this.yvS = ((com.tencent.mm.plugin.wallet_payu.pay.a.b)paramn).yvS;
        if (this.yvS != null)
        {
          paramInt1 = this.yvS.DpP.size();
          this.mCount = paramInt1;
          paramn = new StringBuilder("get mOrders! bankcardTag : ");
          if (this.yvS == null) {
            break label208;
          }
        }
        label208:
        for (paramString = Integer.valueOf(this.yvS.DgN);; paramString = "")
        {
          ae.d("MicroMsg.WalletPayUPayUI", paramString);
          aVv();
          if ((this.yvS == null) || (this.yvS.DpP == null)) {
            break label299;
          }
          paramString = new LinkedList();
          paramn = this.yvS.DpP.iterator();
          while (paramn.hasNext())
          {
            Orders.Commodity localCommodity = (Orders.Commodity)paramn.next();
            if (bu.isNullOrNil(localCommodity.dmx)) {
              localCommodity.dmx = this.mPayInfo.dmw;
            }
            paramString.add(localCommodity.dmx);
          }
          paramInt1 = 0;
          break;
        }
        if (paramString.size() > 0)
        {
          paramn = new yu();
          paramn.dOK.dOM = paramString;
          com.tencent.mm.sdk.b.a.IvT.l(paramn);
        }
        paramString = new Bundle();
        paramString.putDouble("total_fee", this.yvS.dmz);
        paramString.putString("fee_type", "ZAR");
        if (this.mPayInfo.hwN == null) {
          this.mPayInfo.hwN = paramString;
        }
      }
      label299:
      do
      {
        do
        {
          for (;;)
          {
            updateView();
            AppMethodBeat.o(72135);
            return true;
            this.mPayInfo.hwN.putAll(paramString);
          }
          if (!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.b.a)) {
            break;
          }
          s.eGW();
          this.CQh = s.eGX().uw(eHB());
          s.eGW();
          this.CQi = s.eGX().a(null, null, eHB(), false);
          this.yvk.setClickable(true);
        } while ((this.yvS == null) || (this.CQh == null) || (this.mPayInfo == null));
        f.a(this.mPayInfo, this.yvS);
        paramString = g.yxI;
        paramInt2 = this.mPayInfo.dDH;
        s.eGW();
        if (s.eGX().eJH()) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          paramString.f(10690, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf((int)(this.yvS.dmz * 100.0D)), this.yvS.wSq });
          break;
        }
        if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a))
        {
          paramString = (com.tencent.mm.plugin.wallet_payu.pay.a.a)paramn;
          paramn = getInput();
          paramn.putParcelable("key_pay_info", this.mPayInfo);
          paramn.putParcelable("key_bankcard", this.CQi);
          paramn.putString("key_bank_type", this.CQi.field_bankcardType);
          if (!bu.isNullOrNil(this.jth)) {
            paramn.putString("key_pwd1", this.jth);
          }
          paramn.putString("kreq_token", paramString.getToken());
          paramn.putParcelable("key_authen", eHs());
          paramn.putBoolean("key_need_verify_sms", false);
          paramn.putString("key_mobile", this.CQi.field_mobile);
          if (paramString.isSuccess()) {
            paramn.putParcelable("key_orders", c.a(this.yvS, paramString.DKF, paramString.DKG, paramString.phB, paramString.dyP));
          }
          getInput().putBoolean("key_should_redirect", paramString.DKD);
          getInput().putString("key_gateway_code", paramString.DJi);
          getInput().putString("key_gateway_reference", paramString.DJh);
          getInput().putBoolean("key_should_force_adjust", paramString.DKE);
          getInput().putString("key_force_adjust_code", paramString.DJk);
          paramn.putInt("key_pay_flag", 3);
          aw(paramn);
          AppMethodBeat.o(72135);
          return true;
        }
      } while (!(paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a));
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.a)paramn;
      paramn = getInput();
      paramn.putParcelable("key_pay_info", this.mPayInfo);
      paramn.putParcelable("key_bankcard", this.CQi);
      paramn.putString("key_bank_type", this.CQi.field_bankcardType);
      if (!bu.isNullOrNil(this.jth)) {
        paramn.putString("key_pwd1", this.jth);
      }
      paramn.putString("kreq_token", paramString.getToken());
      paramn.putParcelable("key_authen", eHs());
      paramn.putBoolean("key_need_verify_sms", false);
      paramn.putString("key_mobile", this.CQi.field_mobile);
      paramn.putParcelable("key_orders", this.yvS);
      paramn.putInt("key_pay_flag", 3);
      aw(paramn);
      AppMethodBeat.o(72135);
      return true;
    }
    if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a)) {}
    switch (paramInt2)
    {
    case 405: 
    case 406: 
    case 407: 
    default: 
      AppMethodBeat.o(72135);
      return false;
    case 402: 
    case 403: 
    case 408: 
      paramn = (com.tencent.mm.plugin.wallet_payu.pay.a.a)paramn;
      this.Dbl = getInput();
      this.Dbl.putParcelable("key_pay_info", this.mPayInfo);
      this.Dbl.putParcelable("key_bankcard", this.CQi);
      if (!bu.isNullOrNil(this.jth)) {
        this.Dbl.putString("key_pwd1", this.jth);
      }
      this.Dbl.putString("kreq_token", paramn.getToken());
      this.Dbl.putString("key_mobile", this.CQi.field_mobile);
      this.Dbl.putInt("key_err_code", paramInt2);
      this.Dbl.putParcelable("key_orders", this.yvS);
      if (bu.isNullOrNil(paramString)) {
        paramString = getString(2131765705);
      }
      break;
    }
    for (;;)
    {
      h.e(this, paramString, "", getString(2131765704), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72127);
          WalletPayUPayUI.h(WalletPayUPayUI.this).putInt("key_pay_flag", 3);
          WalletPayUPayUI.this.aw(WalletPayUPayUI.i(WalletPayUPayUI.this));
          AppMethodBeat.o(72127);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72128);
          if (WalletPayUPayUI.this.isTransparent()) {
            WalletPayUPayUI.this.finish();
          }
          AppMethodBeat.o(72128);
        }
      });
      AppMethodBeat.o(72135);
      return true;
      if ((this.CQi == null) || (this.yvS == null)) {
        break;
      }
      this.CQi.Dmi = this.yvS.dmw;
      if ((this.CQh != null) && (this.CQh.size() > 1)) {
        d(true, 4, paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(72135);
        return true;
        c(true, 4, paramString);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void un(boolean paramBoolean)
  {
    AppMethodBeat.i(72134);
    if ((this.mPayInfo.dDH == 32) || (this.mPayInfo.dDH == 31))
    {
      if (this.mPayInfo.dDH == 32) {
        ae.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.dmw, this.jth, this.mPayInfo.hwN.getDouble("total_fee"), this.mPayInfo.hwN.getString("fee_type"), i, this.mPayInfo.hwN.getString("extinfo_key_1"), this.CQi.field_bindSerial, this.mPayInfo.hwN.getString("extinfo_key_4")));
        AppMethodBeat.o(72134);
        return;
      }
    }
    if (this.mPayInfo.dDH == 11)
    {
      String str1 = this.jth;
      String str2 = this.DKJ;
      String str3 = this.mPayInfo.dmw;
      double d = this.mPayInfo.hwN.getDouble("total_fee");
      String str4 = this.mPayInfo.hwN.getString("fee_type");
      String str5 = this.CQi.field_bindSerial;
      String str6 = this.CQi.field_bankcardType;
      s.eGW();
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str1, str2, str3, d, str4, str5, str6, s.eGX().CRg.field_bindSerial));
      AppMethodBeat.o(72134);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.a(this.mPayInfo.dmw, this.mPayInfo.hwN.getDouble("total_fee"), this.mPayInfo.hwN.getString("fee_type"), this.CQi.field_bankcardType, this.CQi.field_bindSerial, this.DKJ, this.jth));
    AppMethodBeat.o(72134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI
 * JD-Core Version:    0.7.0.1
 */