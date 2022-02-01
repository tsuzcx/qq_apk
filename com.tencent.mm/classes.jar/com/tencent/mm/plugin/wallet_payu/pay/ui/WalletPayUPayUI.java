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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zz;
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
  private String ItZ = null;
  
  public final void aI(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(72133);
    this.HGU = true;
    if (this.CwO != null) {
      paramBundle.putInt("key_support_bankcard", this.CwO.HQg);
    }
    if (!fOD()) {}
    for (;;)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      com.tencent.mm.wallet_core.a.a(this, d.class, paramBundle);
      AppMethodBeat.o(72133);
      return;
      bool = false;
    }
  }
  
  public final void fOs()
  {
    AppMethodBeat.i(72132);
    if (!bqg())
    {
      AppMethodBeat.o(72132);
      return;
    }
    Log.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
    this.HHm = b.a(this, this.CwO, this.HGf, this.Hvb, new b.b()new View.OnClickListener
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, FavorPayInfo paramAnonymousFavorPayInfo)
      {
        AppMethodBeat.i(72124);
        WalletPayUPayUI.this.hideVKB();
        WalletPayUPayUI.a(WalletPayUPayUI.this, paramAnonymousString1);
        WalletPayUPayUI.b(WalletPayUPayUI.this, paramAnonymousString2);
        WalletPayUPayUI.this.xY(false);
        f.fUi();
        AppMethodBeat.o(72124);
      }
    }, new View.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72125);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/pay/ui/WalletPayUPayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletPayUPayUI.a(WalletPayUPayUI.this, (FavorPayInfo)paramAnonymousView.getTag());
        if (WalletPayUPayUI.a(WalletPayUPayUI.this) != null) {
          WalletPayUPayUI.b(WalletPayUPayUI.this).HXM = "";
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
    }, "CREDITCARD_PAYU".equals(this.Hvb.field_bankcardType));
    AppMethodBeat.o(72132);
  }
  
  public final void fOy()
  {
    AppMethodBeat.i(72131);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.b(getPayInfo().dDL), getPayInfo().Kxs);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.b.a(getPayInfo().dDL), getPayInfo().Kxs);
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
        this.CwO = ((com.tencent.mm.plugin.wallet_payu.pay.a.b)paramq).CwO;
        if (this.CwO != null)
        {
          paramInt1 = this.CwO.HZd.size();
          this.mCount = paramInt1;
          paramq = new StringBuilder("get mOrders! bankcardTag : ");
          if (this.CwO == null) {
            break label208;
          }
        }
        label208:
        for (paramString = Integer.valueOf(this.CwO.HQg);; paramString = "")
        {
          Log.d("MicroMsg.WalletPayUPayUI", paramString);
          bqg();
          if ((this.CwO == null) || (this.CwO.HZd == null)) {
            break label299;
          }
          paramString = new LinkedList();
          paramq = this.CwO.HZd.iterator();
          while (paramq.hasNext())
          {
            Orders.Commodity localCommodity = (Orders.Commodity)paramq.next();
            if (Util.isNullOrNil(localCommodity.dDM)) {
              localCommodity.dDM = this.mPayInfo.dDL;
            }
            paramString.add(localCommodity.dDM);
          }
          paramInt1 = 0;
          break;
        }
        if (paramString.size() > 0)
        {
          paramq = new zz();
          paramq.egG.egI = paramString;
          EventCenter.instance.publish(paramq);
        }
        paramString = new Bundle();
        paramString.putDouble("total_fee", this.CwO.dDO);
        paramString.putString("fee_type", "ZAR");
        if (this.mPayInfo.iqp == null) {
          this.mPayInfo.iqp = paramString;
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
            this.mPayInfo.iqp.putAll(paramString);
          }
          if (!(paramq instanceof com.tencent.mm.plugin.wallet_core.c.b.a)) {
            break;
          }
          s.fOg();
          this.Hva = s.fOh().yk(fOL());
          s.fOg();
          this.Hvb = s.fOh().a(null, null, fOL(), false);
          this.Cwg.setClickable(true);
        } while ((this.CwO == null) || (this.Hva == null) || (this.mPayInfo == null));
        f.a(this.mPayInfo, this.CwO);
        paramString = com.tencent.mm.plugin.report.service.h.CyF;
        paramInt2 = this.mPayInfo.dVv;
        s.fOg();
        if (s.fOh().fRk()) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          paramString.a(10690, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf((int)(this.CwO.dDO * 100.0D)), this.CwO.AOl });
          break;
        }
        if ((paramq instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a))
        {
          paramString = (com.tencent.mm.plugin.wallet_payu.pay.a.a)paramq;
          paramq = getInput();
          paramq.putParcelable("key_pay_info", this.mPayInfo);
          paramq.putParcelable("key_bankcard", this.Hvb);
          paramq.putString("key_bank_type", this.Hvb.field_bankcardType);
          if (!Util.isNullOrNil(this.krw)) {
            paramq.putString("key_pwd1", this.krw);
          }
          paramq.putString("kreq_token", paramString.getToken());
          paramq.putParcelable("key_authen", fOC());
          paramq.putBoolean("key_need_verify_sms", false);
          paramq.putString("key_mobile", this.Hvb.field_mobile);
          if (paramString.isSuccess()) {
            paramq.putParcelable("key_orders", c.a(this.CwO, paramString.ItV, paramString.ItW, paramString.qwL, paramString.dQl));
          }
          getInput().putBoolean("key_should_redirect", paramString.ItT);
          getInput().putString("key_gateway_code", paramString.Isy);
          getInput().putString("key_gateway_reference", paramString.Isx);
          getInput().putBoolean("key_should_force_adjust", paramString.ItU);
          getInput().putString("key_force_adjust_code", paramString.IsA);
          paramq.putInt("key_pay_flag", 3);
          aI(paramq);
          AppMethodBeat.o(72135);
          return true;
        }
      } while (!(paramq instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a));
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.a)paramq;
      paramq = getInput();
      paramq.putParcelable("key_pay_info", this.mPayInfo);
      paramq.putParcelable("key_bankcard", this.Hvb);
      paramq.putString("key_bank_type", this.Hvb.field_bankcardType);
      if (!Util.isNullOrNil(this.krw)) {
        paramq.putString("key_pwd1", this.krw);
      }
      paramq.putString("kreq_token", paramString.getToken());
      paramq.putParcelable("key_authen", fOC());
      paramq.putBoolean("key_need_verify_sms", false);
      paramq.putString("key_mobile", this.Hvb.field_mobile);
      paramq.putParcelable("key_orders", this.CwO);
      paramq.putInt("key_pay_flag", 3);
      aI(paramq);
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
      this.HGZ = getInput();
      this.HGZ.putParcelable("key_pay_info", this.mPayInfo);
      this.HGZ.putParcelable("key_bankcard", this.Hvb);
      if (!Util.isNullOrNil(this.krw)) {
        this.HGZ.putString("key_pwd1", this.krw);
      }
      this.HGZ.putString("kreq_token", paramq.getToken());
      this.HGZ.putString("key_mobile", this.Hvb.field_mobile);
      this.HGZ.putInt("key_err_code", paramInt2);
      this.HGZ.putParcelable("key_orders", this.CwO);
      if (Util.isNullOrNil(paramString)) {
        paramString = getString(2131768158);
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.c(this, paramString, "", getString(2131768157), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72127);
          WalletPayUPayUI.h(WalletPayUPayUI.this).putInt("key_pay_flag", 3);
          WalletPayUPayUI.this.aI(WalletPayUPayUI.i(WalletPayUPayUI.this));
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
      if ((this.Hvb == null) || (this.CwO == null)) {
        break;
      }
      this.Hvb.HVB = this.CwO.dDL;
      if ((this.Hva != null) && (this.Hva.size() > 1)) {
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
  
  public final void xY(boolean paramBoolean)
  {
    AppMethodBeat.i(72134);
    if ((this.mPayInfo.dVv == 32) || (this.mPayInfo.dVv == 31))
    {
      if (this.mPayInfo.dVv == 32) {
        Log.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.dDL, this.krw, this.mPayInfo.iqp.getDouble("total_fee"), this.mPayInfo.iqp.getString("fee_type"), i, this.mPayInfo.iqp.getString("extinfo_key_1"), this.Hvb.field_bindSerial, this.mPayInfo.iqp.getString("extinfo_key_4")));
        AppMethodBeat.o(72134);
        return;
      }
    }
    if (this.mPayInfo.dVv == 11)
    {
      String str1 = this.krw;
      String str2 = this.ItZ;
      String str3 = this.mPayInfo.dDL;
      double d = this.mPayInfo.iqp.getDouble("total_fee");
      String str4 = this.mPayInfo.iqp.getString("fee_type");
      String str5 = this.Hvb.field_bindSerial;
      String str6 = this.Hvb.field_bankcardType;
      s.fOg();
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str1, str2, str3, d, str4, str5, str6, s.fOh().Hwc.field_bindSerial));
      AppMethodBeat.o(72134);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.a(this.mPayInfo.dDL, this.mPayInfo.iqp.getDouble("total_fee"), this.mPayInfo.iqp.getString("fee_type"), this.Hvb.field_bankcardType, this.Hvb.field_bindSerial, this.ItZ, this.krw));
    AppMethodBeat.o(72134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI
 * JD-Core Version:    0.7.0.1
 */