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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.yo;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUPayUI
  extends WalletPayUI
{
  private String Dte = null;
  
  public final void av(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(72133);
    this.CJA = true;
    if (this.ygb != null) {
      paramBundle.putInt("key_support_bankcard", this.ygb.CPj);
    }
    if (!eDM()) {}
    for (;;)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      com.tencent.mm.wallet_core.a.a(this, d.class, paramBundle);
      AppMethodBeat.o(72133);
      return;
      bool = false;
    }
  }
  
  public final void eDB()
  {
    AppMethodBeat.i(72132);
    if (!aUW())
    {
      AppMethodBeat.o(72132);
      return;
    }
    ad.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
    this.CJS = b.a(this, this.ygb, this.CIL, this.CyD, new b.b()new View.OnClickListener
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, FavorPayInfo paramAnonymousFavorPayInfo)
      {
        AppMethodBeat.i(72124);
        WalletPayUPayUI.this.hideVKB();
        WalletPayUPayUI.a(WalletPayUPayUI.this, paramAnonymousString1);
        WalletPayUPayUI.b(WalletPayUPayUI.this, paramAnonymousString2);
        WalletPayUPayUI.this.ug(false);
        f.eIT();
        AppMethodBeat.o(72124);
      }
    }, new View.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72125);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/pay/ui/WalletPayUPayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletPayUPayUI.a(WalletPayUPayUI.this, (FavorPayInfo)paramAnonymousView.getTag());
        if (WalletPayUPayUI.a(WalletPayUPayUI.this) != null) {
          WalletPayUPayUI.b(WalletPayUPayUI.this).CWP = "";
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
    }, "CREDITCARD_PAYU".equals(this.CyD.field_bankcardType));
    AppMethodBeat.o(72132);
  }
  
  public final void eDH()
  {
    AppMethodBeat.i(72131);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.b(getPayInfo().dlu), getPayInfo().FlQ);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.b.a(getPayInfo().dlu), getPayInfo().FlQ);
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
    ad.i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
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
        this.ygb = ((com.tencent.mm.plugin.wallet_payu.pay.a.b)paramn).ygb;
        if (this.ygb != null)
        {
          paramInt1 = this.ygb.CYk.size();
          this.mCount = paramInt1;
          paramn = new StringBuilder("get mOrders! bankcardTag : ");
          if (this.ygb == null) {
            break label208;
          }
        }
        label208:
        for (paramString = Integer.valueOf(this.ygb.CPj);; paramString = "")
        {
          ad.d("MicroMsg.WalletPayUPayUI", paramString);
          aUW();
          if ((this.ygb == null) || (this.ygb.CYk == null)) {
            break label299;
          }
          paramString = new LinkedList();
          paramn = this.ygb.CYk.iterator();
          while (paramn.hasNext())
          {
            Orders.Commodity localCommodity = (Orders.Commodity)paramn.next();
            if (bt.isNullOrNil(localCommodity.dlv)) {
              localCommodity.dlv = this.mPayInfo.dlu;
            }
            paramString.add(localCommodity.dlv);
          }
          paramInt1 = 0;
          break;
        }
        if (paramString.size() > 0)
        {
          paramn = new yo();
          paramn.dNu.dNw = paramString;
          com.tencent.mm.sdk.b.a.IbL.l(paramn);
        }
        paramString = new Bundle();
        paramString.putDouble("total_fee", this.ygb.dlx);
        paramString.putString("fee_type", "ZAR");
        if (this.mPayInfo.htZ == null) {
          this.mPayInfo.htZ = paramString;
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
            this.mPayInfo.htZ.putAll(paramString);
          }
          if (!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.b.a)) {
            break;
          }
          s.eDp();
          this.CyC = s.eDq().uo(eDU());
          s.eDp();
          this.CyD = s.eDq().a(null, null, eDU(), false);
          this.yft.setClickable(true);
        } while ((this.ygb == null) || (this.CyC == null) || (this.mPayInfo == null));
        f.a(this.mPayInfo, this.ygb);
        paramString = g.yhR;
        paramInt2 = this.mPayInfo.dCC;
        s.eDp();
        if (s.eDq().eGa()) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          paramString.f(10690, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf((int)(this.ygb.dlx * 100.0D)), this.ygb.wCF });
          break;
        }
        if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a))
        {
          paramString = (com.tencent.mm.plugin.wallet_payu.pay.a.a)paramn;
          paramn = getInput();
          paramn.putParcelable("key_pay_info", this.mPayInfo);
          paramn.putParcelable("key_bankcard", this.CyD);
          paramn.putString("key_bank_type", this.CyD.field_bankcardType);
          if (!bt.isNullOrNil(this.jqo)) {
            paramn.putString("key_pwd1", this.jqo);
          }
          paramn.putString("kreq_token", paramString.getToken());
          paramn.putParcelable("key_authen", eDL());
          paramn.putBoolean("key_need_verify_sms", false);
          paramn.putString("key_mobile", this.CyD.field_mobile);
          if (paramString.isSuccess()) {
            paramn.putParcelable("key_orders", c.a(this.ygb, paramString.Dta, paramString.Dtb, paramString.paX, paramString.dxK));
          }
          getInput().putBoolean("key_should_redirect", paramString.DsY);
          getInput().putString("key_gateway_code", paramString.DrD);
          getInput().putString("key_gateway_reference", paramString.DrC);
          getInput().putBoolean("key_should_force_adjust", paramString.DsZ);
          getInput().putString("key_force_adjust_code", paramString.DrF);
          paramn.putInt("key_pay_flag", 3);
          av(paramn);
          AppMethodBeat.o(72135);
          return true;
        }
      } while (!(paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a));
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.a)paramn;
      paramn = getInput();
      paramn.putParcelable("key_pay_info", this.mPayInfo);
      paramn.putParcelable("key_bankcard", this.CyD);
      paramn.putString("key_bank_type", this.CyD.field_bankcardType);
      if (!bt.isNullOrNil(this.jqo)) {
        paramn.putString("key_pwd1", this.jqo);
      }
      paramn.putString("kreq_token", paramString.getToken());
      paramn.putParcelable("key_authen", eDL());
      paramn.putBoolean("key_need_verify_sms", false);
      paramn.putString("key_mobile", this.CyD.field_mobile);
      paramn.putParcelable("key_orders", this.ygb);
      paramn.putInt("key_pay_flag", 3);
      av(paramn);
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
      this.CJF = getInput();
      this.CJF.putParcelable("key_pay_info", this.mPayInfo);
      this.CJF.putParcelable("key_bankcard", this.CyD);
      if (!bt.isNullOrNil(this.jqo)) {
        this.CJF.putString("key_pwd1", this.jqo);
      }
      this.CJF.putString("kreq_token", paramn.getToken());
      this.CJF.putString("key_mobile", this.CyD.field_mobile);
      this.CJF.putInt("key_err_code", paramInt2);
      this.CJF.putParcelable("key_orders", this.ygb);
      if (bt.isNullOrNil(paramString)) {
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
          WalletPayUPayUI.this.av(WalletPayUPayUI.i(WalletPayUPayUI.this));
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
      if ((this.CyD == null) || (this.ygb == null)) {
        break;
      }
      this.CyD.CUC = this.ygb.dlu;
      if ((this.CyC != null) && (this.CyC.size() > 1)) {
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
  
  public final void ug(boolean paramBoolean)
  {
    AppMethodBeat.i(72134);
    if ((this.mPayInfo.dCC == 32) || (this.mPayInfo.dCC == 31))
    {
      if (this.mPayInfo.dCC == 32) {
        ad.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.dlu, this.jqo, this.mPayInfo.htZ.getDouble("total_fee"), this.mPayInfo.htZ.getString("fee_type"), i, this.mPayInfo.htZ.getString("extinfo_key_1"), this.CyD.field_bindSerial, this.mPayInfo.htZ.getString("extinfo_key_4")));
        AppMethodBeat.o(72134);
        return;
      }
    }
    if (this.mPayInfo.dCC == 11)
    {
      String str1 = this.jqo;
      String str2 = this.Dte;
      String str3 = this.mPayInfo.dlu;
      double d = this.mPayInfo.htZ.getDouble("total_fee");
      String str4 = this.mPayInfo.htZ.getString("fee_type");
      String str5 = this.CyD.field_bindSerial;
      String str6 = this.CyD.field_bankcardType;
      s.eDp();
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str1, str2, str3, d, str4, str5, str6, s.eDq().CzB.field_bindSerial));
      AppMethodBeat.o(72134);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.a(this.mPayInfo.dlu, this.mPayInfo.htZ.getDouble("total_fee"), this.mPayInfo.htZ.getString("fee_type"), this.CyD.field_bankcardType, this.CyD.field_bindSerial, this.Dte, this.jqo));
    AppMethodBeat.o(72134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI
 * JD-Core Version:    0.7.0.1
 */