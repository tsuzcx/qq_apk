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
import com.tencent.mm.g.a.xj;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUPayUI
  extends WalletPayUI
{
  private String AAp = null;
  
  public final void al(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(72133);
    this.zQS = true;
    if (this.vIq != null) {
      paramBundle.putInt("key_support_bankcard", this.vIq.zWA);
    }
    if (!eaq()) {}
    for (;;)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      com.tencent.mm.wallet_core.a.a(this, d.class, paramBundle);
      AppMethodBeat.o(72133);
      return;
      bool = false;
    }
  }
  
  public final void eaf()
  {
    AppMethodBeat.i(72132);
    if (!aKT())
    {
      AppMethodBeat.o(72132);
      return;
    }
    ad.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
    this.zRk = b.a(this, this.vIq, this.zQd, this.zGh, new b.b()new View.OnClickListener
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, FavorPayInfo paramAnonymousFavorPayInfo)
      {
        AppMethodBeat.i(72124);
        WalletPayUPayUI.this.hideVKB();
        WalletPayUPayUI.a(WalletPayUPayUI.this, paramAnonymousString1);
        WalletPayUPayUI.b(WalletPayUPayUI.this, paramAnonymousString2);
        WalletPayUPayUI.this.sv(false);
        f.eft();
        AppMethodBeat.o(72124);
      }
    }, new View.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72125);
        WalletPayUPayUI.a(WalletPayUPayUI.this, (FavorPayInfo)paramAnonymousView.getTag());
        if (WalletPayUPayUI.a(WalletPayUPayUI.this) != null) {
          WalletPayUPayUI.b(WalletPayUPayUI.this).Aef = "";
        }
        WalletPayUPayUI.c(WalletPayUPayUI.this, "");
        WalletPayUPayUI.c(WalletPayUPayUI.this).dismiss();
        WalletPayUPayUI.d(WalletPayUPayUI.this);
        WalletPayUPayUI.e(WalletPayUPayUI.this);
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
    }, "CREDITCARD_PAYU".equals(this.zGh.field_bankcardType));
    AppMethodBeat.o(72132);
  }
  
  public final void eal()
  {
    AppMethodBeat.i(72131);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.b(getPayInfo().dcE), getPayInfo().Coq);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.b.a(getPayInfo().dcE), getPayInfo().Coq);
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
        this.vIq = ((com.tencent.mm.plugin.wallet_payu.pay.a.b)paramn).vIq;
        if (this.vIq != null)
        {
          paramInt1 = this.vIq.Afx.size();
          this.mCount = paramInt1;
          paramn = new StringBuilder("get mOrders! bankcardTag : ");
          if (this.vIq == null) {
            break label208;
          }
        }
        label208:
        for (paramString = Integer.valueOf(this.vIq.zWA);; paramString = "")
        {
          ad.d("MicroMsg.WalletPayUPayUI", paramString);
          aKT();
          if ((this.vIq == null) || (this.vIq.Afx == null)) {
            break label299;
          }
          paramString = new LinkedList();
          paramn = this.vIq.Afx.iterator();
          while (paramn.hasNext())
          {
            Orders.Commodity localCommodity = (Orders.Commodity)paramn.next();
            if (bt.isNullOrNil(localCommodity.dcF)) {
              localCommodity.dcF = this.mPayInfo.dcE;
            }
            paramString.add(localCommodity.dcF);
          }
          paramInt1 = 0;
          break;
        }
        if (paramString.size() > 0)
        {
          paramn = new xj();
          paramn.dDv.dDx = paramString;
          com.tencent.mm.sdk.b.a.ESL.l(paramn);
        }
        paramString = new Bundle();
        paramString.putDouble("total_fee", this.vIq.dcH);
        paramString.putString("fee_type", "ZAR");
        if (this.mPayInfo.Cos == null) {
          this.mPayInfo.Cos = paramString;
        }
      }
      label299:
      do
      {
        do
        {
          for (;;)
          {
            cE();
            AppMethodBeat.o(72135);
            return true;
            this.mPayInfo.Cos.putAll(paramString);
          }
          if (!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.b.a)) {
            break;
          }
          s.dZT();
          this.zGg = s.dZU().sD(eay());
          s.dZT();
          this.zGh = s.dZU().a(null, null, eay(), false);
          this.vHH.setClickable(true);
        } while ((this.vIq == null) || (this.zGg == null) || (this.mPayInfo == null));
        f.a(this.mPayInfo, this.vIq);
        paramString = com.tencent.mm.plugin.report.service.h.vKh;
        paramInt2 = this.mPayInfo.dtb;
        s.dZT();
        if (s.dZU().ecF()) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          paramString.f(10690, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf((int)(this.vIq.dcH * 100.0D)), this.vIq.uop });
          break;
        }
        if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a))
        {
          paramString = (com.tencent.mm.plugin.wallet_payu.pay.a.a)paramn;
          paramn = getInput();
          paramn.putParcelable("key_pay_info", this.mPayInfo);
          paramn.putParcelable("key_bankcard", this.zGh);
          paramn.putString("key_bank_type", this.zGh.field_bankcardType);
          if (!bt.isNullOrNil(this.ixc)) {
            paramn.putString("key_pwd1", this.ixc);
          }
          paramn.putString("kreq_token", paramString.getToken());
          paramn.putParcelable("key_authen", eap());
          paramn.putBoolean("key_need_verify_sms", false);
          paramn.putString("key_mobile", this.zGh.field_mobile);
          if (paramString.isSuccess()) {
            paramn.putParcelable("key_orders", c.a(this.vIq, paramString.AAl, paramString.AAm, paramString.nUh, paramString.don));
          }
          getInput().putBoolean("key_should_redirect", paramString.AAj);
          getInput().putString("key_gateway_code", paramString.AyO);
          getInput().putString("key_gateway_reference", paramString.AyN);
          getInput().putBoolean("key_should_force_adjust", paramString.AAk);
          getInput().putString("key_force_adjust_code", paramString.AyQ);
          paramn.putInt("key_pay_flag", 3);
          al(paramn);
          AppMethodBeat.o(72135);
          return true;
        }
      } while (!(paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a));
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.a)paramn;
      paramn = getInput();
      paramn.putParcelable("key_pay_info", this.mPayInfo);
      paramn.putParcelable("key_bankcard", this.zGh);
      paramn.putString("key_bank_type", this.zGh.field_bankcardType);
      if (!bt.isNullOrNil(this.ixc)) {
        paramn.putString("key_pwd1", this.ixc);
      }
      paramn.putString("kreq_token", paramString.getToken());
      paramn.putParcelable("key_authen", eap());
      paramn.putBoolean("key_need_verify_sms", false);
      paramn.putString("key_mobile", this.zGh.field_mobile);
      paramn.putParcelable("key_orders", this.vIq);
      paramn.putInt("key_pay_flag", 3);
      al(paramn);
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
      this.zQX = getInput();
      this.zQX.putParcelable("key_pay_info", this.mPayInfo);
      this.zQX.putParcelable("key_bankcard", this.zGh);
      if (!bt.isNullOrNil(this.ixc)) {
        this.zQX.putString("key_pwd1", this.ixc);
      }
      this.zQX.putString("kreq_token", paramn.getToken());
      this.zQX.putString("key_mobile", this.zGh.field_mobile);
      this.zQX.putInt("key_err_code", paramInt2);
      this.zQX.putParcelable("key_orders", this.vIq);
      if (bt.isNullOrNil(paramString)) {
        paramString = getString(2131765705);
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.d(this, paramString, "", getString(2131765704), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72127);
          WalletPayUPayUI.h(WalletPayUPayUI.this).putInt("key_pay_flag", 3);
          WalletPayUPayUI.this.al(WalletPayUPayUI.i(WalletPayUPayUI.this));
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
      if ((this.zGh == null) || (this.vIq == null)) {
        break;
      }
      this.zGh.AbT = this.vIq.dcE;
      if ((this.zGg != null) && (this.zGg.size() > 1)) {
        c(true, 4, paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(72135);
        return true;
        b(true, 4, paramString);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sv(boolean paramBoolean)
  {
    AppMethodBeat.i(72134);
    if ((this.mPayInfo.dtb == 32) || (this.mPayInfo.dtb == 31))
    {
      if (this.mPayInfo.dtb == 32) {
        ad.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.dcE, this.ixc, this.mPayInfo.Cos.getDouble("total_fee"), this.mPayInfo.Cos.getString("fee_type"), i, this.mPayInfo.Cos.getString("extinfo_key_1"), this.zGh.field_bindSerial, this.mPayInfo.Cos.getString("extinfo_key_4")));
        AppMethodBeat.o(72134);
        return;
      }
    }
    if (this.mPayInfo.dtb == 11)
    {
      String str1 = this.ixc;
      String str2 = this.AAp;
      String str3 = this.mPayInfo.dcE;
      double d = this.mPayInfo.Cos.getDouble("total_fee");
      String str4 = this.mPayInfo.Cos.getString("fee_type");
      String str5 = this.zGh.field_bindSerial;
      String str6 = this.zGh.field_bankcardType;
      s.dZT();
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str1, str2, str3, d, str4, str5, str6, s.dZU().zHd.field_bindSerial));
      AppMethodBeat.o(72134);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.a(this.mPayInfo.dcE, this.mPayInfo.Cos.getDouble("total_fee"), this.mPayInfo.Cos.getString("fee_type"), this.zGh.field_bankcardType, this.zGh.field_bindSerial, this.AAp, this.ixc));
    AppMethodBeat.o(72134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI
 * JD-Core Version:    0.7.0.1
 */