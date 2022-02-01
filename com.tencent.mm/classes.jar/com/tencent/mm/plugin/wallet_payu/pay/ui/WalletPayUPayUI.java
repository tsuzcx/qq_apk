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
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.abg;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.utils.j;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUPayUI
  extends WalletPayUI
{
  private String PmJ = null;
  
  public final void BS(boolean paramBoolean)
  {
    AppMethodBeat.i(72134);
    if ((this.mPayInfo.fOY == 32) || (this.mPayInfo.fOY == 31))
    {
      if (this.mPayInfo.fOY == 32) {
        Log.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.fwv, this.njf, this.mPayInfo.lfu.getDouble("total_fee"), this.mPayInfo.lfu.getString("fee_type"), i, this.mPayInfo.lfu.getString("extinfo_key_1"), this.OmO.field_bindSerial, this.mPayInfo.lfu.getString("extinfo_key_4")));
        AppMethodBeat.o(72134);
        return;
      }
    }
    if (this.mPayInfo.fOY == 11)
    {
      String str1 = this.njf;
      String str2 = this.PmJ;
      String str3 = this.mPayInfo.fwv;
      double d = this.mPayInfo.lfu.getDouble("total_fee");
      String str4 = this.mPayInfo.lfu.getString("fee_type");
      String str5 = this.OmO.field_bindSerial;
      String str6 = this.OmO.field_bankcardType;
      s.gGL();
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str1, str2, str3, d, str4, str5, str6, s.gGM().OnP.field_bindSerial));
      AppMethodBeat.o(72134);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.a(this.mPayInfo.fwv, this.mPayInfo.lfu.getDouble("total_fee"), this.mPayInfo.lfu.getString("fee_type"), this.OmO.field_bankcardType, this.OmO.field_bindSerial, this.PmJ, this.njf));
    AppMethodBeat.o(72134);
  }
  
  public final void aE(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(72133);
    this.OyO = true;
    if (this.Ivh != null) {
      paramBundle.putInt("key_support_bankcard", this.Ivh.OIp);
    }
    if (!gHj()) {}
    for (;;)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      com.tencent.mm.wallet_core.a.a(this, d.class, paramBundle);
      AppMethodBeat.o(72133);
      return;
      bool = false;
    }
  }
  
  public final void gGY()
  {
    AppMethodBeat.i(72132);
    if (!bAu())
    {
      AppMethodBeat.o(72132);
      return;
    }
    Log.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
    this.Ozg = b.a(this, this.Ivh, this.OxY, this.OmO, new b.b()new View.OnClickListener
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, FavorPayInfo paramAnonymousFavorPayInfo)
      {
        AppMethodBeat.i(72124);
        WalletPayUPayUI.this.hideVKB();
        WalletPayUPayUI.a(WalletPayUPayUI.this, paramAnonymousString1);
        WalletPayUPayUI.b(WalletPayUPayUI.this, paramAnonymousString2);
        WalletPayUPayUI.this.BS(false);
        j.gMO();
        AppMethodBeat.o(72124);
      }
    }, new View.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72125);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_payu/pay/ui/WalletPayUPayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletPayUPayUI.a(WalletPayUPayUI.this, (FavorPayInfo)paramAnonymousView.getTag());
        if (WalletPayUPayUI.a(WalletPayUPayUI.this) != null) {
          WalletPayUPayUI.b(WalletPayUPayUI.this).OPM = "";
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
    }, "CREDITCARD_PAYU".equals(this.OmO.field_bankcardType));
    AppMethodBeat.o(72132);
  }
  
  public final void gHe()
  {
    AppMethodBeat.i(72131);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.b(getPayInfo().fwv), getPayInfo().Rzg);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.b.a(getPayInfo().fwv), getPayInfo().Rzg);
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
    Log.i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(72130);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72135);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b))
      {
        this.Ivh = ((com.tencent.mm.plugin.wallet_payu.pay.a.b)paramq).Ivh;
        if (this.Ivh != null)
        {
          paramInt1 = this.Ivh.ORd.size();
          this.mCount = paramInt1;
          paramq = new StringBuilder("get mOrders! bankcardTag : ");
          if (this.Ivh == null) {
            break label210;
          }
        }
        label210:
        for (paramString = Integer.valueOf(this.Ivh.OIp);; paramString = "")
        {
          Log.d("MicroMsg.WalletPayUPayUI", paramString);
          bAu();
          if ((this.Ivh == null) || (this.Ivh.ORd == null)) {
            break label299;
          }
          paramString = new LinkedList();
          paramq = this.Ivh.ORd.iterator();
          while (paramq.hasNext())
          {
            Orders.Commodity localCommodity = (Orders.Commodity)paramq.next();
            if (Util.isNullOrNil(localCommodity.fww)) {
              localCommodity.fww = this.mPayInfo.fwv;
            }
            paramString.add(localCommodity.fww);
          }
          paramInt1 = 0;
          break;
        }
        if (paramString.size() > 0)
        {
          paramq = new abg();
          paramq.gaW.gaY = paramString;
          EventCenter.instance.publish(paramq);
        }
        paramString = new Bundle();
        paramString.putDouble("total_fee", this.Ivh.fwy);
        paramString.putString("fee_type", "ZAR");
        if (this.mPayInfo.lfu == null) {
          this.mPayInfo.lfu = paramString;
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
            this.mPayInfo.lfu.putAll(paramString);
          }
          if (!(paramq instanceof com.tencent.mm.plugin.wallet_core.c.b.a)) {
            break;
          }
          s.gGL();
          this.OmN = s.gGM().Cf(gGW());
          s.gGL();
          this.OmO = s.gGM().a(null, null, gGW(), false);
          this.Iub.setClickable(true);
        } while ((this.Ivh == null) || (this.OmN == null) || (this.mPayInfo == null));
        j.a(this.mPayInfo, this.Ivh);
        paramString = com.tencent.mm.plugin.report.service.h.IzE;
        paramInt2 = this.mPayInfo.fOY;
        s.gGL();
        if (s.gGM().gJQ()) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          paramString.a(10690, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf((int)(this.Ivh.fwy * 100.0D)), this.Ivh.GHz });
          break;
        }
        if ((paramq instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a))
        {
          paramString = (com.tencent.mm.plugin.wallet_payu.pay.a.a)paramq;
          paramq = getInput();
          paramq.putParcelable("key_pay_info", this.mPayInfo);
          paramq.putParcelable("key_bankcard", this.OmO);
          paramq.putString("key_bank_type", this.OmO.field_bankcardType);
          if (!Util.isNullOrNil(this.njf)) {
            paramq.putString("key_pwd1", this.njf);
          }
          paramq.putString("kreq_token", paramString.getToken());
          paramq.putParcelable("key_authen", gHi());
          paramq.putBoolean("key_need_verify_sms", false);
          paramq.putString("key_mobile", this.OmO.field_mobile);
          if (paramString.isSuccess()) {
            paramq.putParcelable("key_orders", c.a(this.Ivh, paramString.PmF, paramString.PmG, paramString.dXr, paramString.fJC));
          }
          getInput().putBoolean("key_should_redirect", paramString.PmD);
          getInput().putString("key_gateway_code", paramString.Pli);
          getInput().putString("key_gateway_reference", paramString.Plh);
          getInput().putBoolean("key_should_force_adjust", paramString.PmE);
          getInput().putString("key_force_adjust_code", paramString.Plk);
          paramq.putInt("key_pay_flag", 3);
          aE(paramq);
          AppMethodBeat.o(72135);
          return true;
        }
      } while (!(paramq instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a));
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.a)paramq;
      paramq = getInput();
      paramq.putParcelable("key_pay_info", this.mPayInfo);
      paramq.putParcelable("key_bankcard", this.OmO);
      paramq.putString("key_bank_type", this.OmO.field_bankcardType);
      if (!Util.isNullOrNil(this.njf)) {
        paramq.putString("key_pwd1", this.njf);
      }
      paramq.putString("kreq_token", paramString.getToken());
      paramq.putParcelable("key_authen", gHi());
      paramq.putBoolean("key_need_verify_sms", false);
      paramq.putString("key_mobile", this.OmO.field_mobile);
      paramq.putParcelable("key_orders", this.Ivh);
      paramq.putInt("key_pay_flag", 3);
      aE(paramq);
      AppMethodBeat.o(72135);
      return true;
    }
    if ((paramq instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a)) {}
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
      paramq = (com.tencent.mm.plugin.wallet_payu.pay.a.a)paramq;
      this.OyT = getInput();
      this.OyT.putParcelable("key_pay_info", this.mPayInfo);
      this.OyT.putParcelable("key_bankcard", this.OmO);
      if (!Util.isNullOrNil(this.njf)) {
        this.OyT.putString("key_pwd1", this.njf);
      }
      this.OyT.putString("kreq_token", paramq.getToken());
      this.OyT.putString("key_mobile", this.OmO.field_mobile);
      this.OyT.putInt("key_err_code", paramInt2);
      this.OyT.putParcelable("key_orders", this.Ivh);
      if (Util.isNullOrNil(paramString)) {
        paramString = getString(a.i.wallet_pay_reset_info_tips);
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, "", getString(a.i.wallet_pay_reset_info), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72127);
          WalletPayUPayUI.h(WalletPayUPayUI.this).putInt("key_pay_flag", 3);
          WalletPayUPayUI.this.aE(WalletPayUPayUI.i(WalletPayUPayUI.this));
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
      if ((this.OmO == null) || (this.Ivh == null)) {
        break;
      }
      this.OmO.ONC = this.Ivh.fwv;
      if ((this.OmN != null) && (this.OmN.size() > 1)) {
        e(true, 4, paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(72135);
        return true;
        d(true, 4, paramString);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI
 * JD-Core Version:    0.7.0.1
 */