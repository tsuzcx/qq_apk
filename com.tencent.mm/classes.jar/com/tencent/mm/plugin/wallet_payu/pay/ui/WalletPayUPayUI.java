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
import com.tencent.mm.g.a.xu;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUPayUI
  extends WalletPayUI
{
  private String BSL = null;
  
  public final void aq(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(72133);
    this.Bjm = true;
    if (this.wSu != null) {
      paramBundle.putInt("key_support_bankcard", this.wSu.BoU);
    }
    if (!epM()) {}
    for (;;)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      com.tencent.mm.wallet_core.a.a(this, d.class, paramBundle);
      AppMethodBeat.o(72133);
      return;
      bool = false;
    }
  }
  
  public final void epB()
  {
    AppMethodBeat.i(72132);
    if (!aRK())
    {
      AppMethodBeat.o(72132);
      return;
    }
    ac.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
    this.BjE = b.a(this, this.wSu, this.Bix, this.AYu, new b.b()new View.OnClickListener
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, FavorPayInfo paramAnonymousFavorPayInfo)
      {
        AppMethodBeat.i(72124);
        WalletPayUPayUI.this.hideVKB();
        WalletPayUPayUI.a(WalletPayUPayUI.this, paramAnonymousString1);
        WalletPayUPayUI.b(WalletPayUPayUI.this, paramAnonymousString2);
        WalletPayUPayUI.this.tw(false);
        f.euN();
        AppMethodBeat.o(72124);
      }
    }, new View.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72125);
        WalletPayUPayUI.a(WalletPayUPayUI.this, (FavorPayInfo)paramAnonymousView.getTag());
        if (WalletPayUPayUI.a(WalletPayUPayUI.this) != null) {
          WalletPayUPayUI.b(WalletPayUPayUI.this).Bwz = "";
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
    }, "CREDITCARD_PAYU".equals(this.AYu.field_bankcardType));
    AppMethodBeat.o(72132);
  }
  
  public final void epH()
  {
    AppMethodBeat.i(72131);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.b(getPayInfo().dac), getPayInfo().DGJ);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.b.a(getPayInfo().dac), getPayInfo().DGJ);
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
    ac.i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
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
        this.wSu = ((com.tencent.mm.plugin.wallet_payu.pay.a.b)paramn).wSu;
        if (this.wSu != null)
        {
          paramInt1 = this.wSu.BxR.size();
          this.mCount = paramInt1;
          paramn = new StringBuilder("get mOrders! bankcardTag : ");
          if (this.wSu == null) {
            break label208;
          }
        }
        label208:
        for (paramString = Integer.valueOf(this.wSu.BoU);; paramString = "")
        {
          ac.d("MicroMsg.WalletPayUPayUI", paramString);
          aRK();
          if ((this.wSu == null) || (this.wSu.BxR == null)) {
            break label299;
          }
          paramString = new LinkedList();
          paramn = this.wSu.BxR.iterator();
          while (paramn.hasNext())
          {
            Orders.Commodity localCommodity = (Orders.Commodity)paramn.next();
            if (bs.isNullOrNil(localCommodity.dad)) {
              localCommodity.dad = this.mPayInfo.dac;
            }
            paramString.add(localCommodity.dad);
          }
          paramInt1 = 0;
          break;
        }
        if (paramString.size() > 0)
        {
          paramn = new xu();
          paramn.dBh.dBj = paramString;
          com.tencent.mm.sdk.b.a.GpY.l(paramn);
        }
        paramString = new Bundle();
        paramString.putDouble("total_fee", this.wSu.daf);
        paramString.putString("fee_type", "ZAR");
        if (this.mPayInfo.hbR == null) {
          this.mPayInfo.hbR = paramString;
        }
      }
      label299:
      do
      {
        do
        {
          for (;;)
          {
            cL();
            AppMethodBeat.o(72135);
            return true;
            this.mPayInfo.hbR.putAll(paramString);
          }
          if (!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.b.a)) {
            break;
          }
          s.epp();
          this.AYt = s.epq().tE(epU());
          s.epp();
          this.AYu = s.epq().a(null, null, epU(), false);
          this.wRL.setClickable(true);
        } while ((this.wSu == null) || (this.AYt == null) || (this.mPayInfo == null));
        f.a(this.mPayInfo, this.wSu);
        paramString = com.tencent.mm.plugin.report.service.h.wUl;
        paramInt2 = this.mPayInfo.dqL;
        s.epp();
        if (s.epq().esa()) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          paramString.f(10690, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf((int)(this.wSu.daf * 100.0D)), this.wSu.vxl });
          break;
        }
        if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a))
        {
          paramString = (com.tencent.mm.plugin.wallet_payu.pay.a.a)paramn;
          paramn = getInput();
          paramn.putParcelable("key_pay_info", this.mPayInfo);
          paramn.putParcelable("key_bankcard", this.AYu);
          paramn.putString("key_bank_type", this.AYu.field_bankcardType);
          if (!bs.isNullOrNil(this.iXf)) {
            paramn.putString("key_pwd1", this.iXf);
          }
          paramn.putString("kreq_token", paramString.getToken());
          paramn.putParcelable("key_authen", epL());
          paramn.putBoolean("key_need_verify_sms", false);
          paramn.putString("key_mobile", this.AYu.field_mobile);
          if (paramString.isSuccess()) {
            paramn.putParcelable("key_orders", c.a(this.wSu, paramString.BSH, paramString.BSI, paramString.oxC, paramString.dlW));
          }
          getInput().putBoolean("key_should_redirect", paramString.BSF);
          getInput().putString("key_gateway_code", paramString.BRk);
          getInput().putString("key_gateway_reference", paramString.BRj);
          getInput().putBoolean("key_should_force_adjust", paramString.BSG);
          getInput().putString("key_force_adjust_code", paramString.BRm);
          paramn.putInt("key_pay_flag", 3);
          aq(paramn);
          AppMethodBeat.o(72135);
          return true;
        }
      } while (!(paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a));
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.a)paramn;
      paramn = getInput();
      paramn.putParcelable("key_pay_info", this.mPayInfo);
      paramn.putParcelable("key_bankcard", this.AYu);
      paramn.putString("key_bank_type", this.AYu.field_bankcardType);
      if (!bs.isNullOrNil(this.iXf)) {
        paramn.putString("key_pwd1", this.iXf);
      }
      paramn.putString("kreq_token", paramString.getToken());
      paramn.putParcelable("key_authen", epL());
      paramn.putBoolean("key_need_verify_sms", false);
      paramn.putString("key_mobile", this.AYu.field_mobile);
      paramn.putParcelable("key_orders", this.wSu);
      paramn.putInt("key_pay_flag", 3);
      aq(paramn);
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
      this.Bjr = getInput();
      this.Bjr.putParcelable("key_pay_info", this.mPayInfo);
      this.Bjr.putParcelable("key_bankcard", this.AYu);
      if (!bs.isNullOrNil(this.iXf)) {
        this.Bjr.putString("key_pwd1", this.iXf);
      }
      this.Bjr.putString("kreq_token", paramn.getToken());
      this.Bjr.putString("key_mobile", this.AYu.field_mobile);
      this.Bjr.putInt("key_err_code", paramInt2);
      this.Bjr.putParcelable("key_orders", this.wSu);
      if (bs.isNullOrNil(paramString)) {
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
          WalletPayUPayUI.this.aq(WalletPayUPayUI.i(WalletPayUPayUI.this));
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
      if ((this.AYu == null) || (this.wSu == null)) {
        break;
      }
      this.AYu.Bun = this.wSu.dac;
      if ((this.AYt != null) && (this.AYt.size() > 1)) {
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
  
  public final void tw(boolean paramBoolean)
  {
    AppMethodBeat.i(72134);
    if ((this.mPayInfo.dqL == 32) || (this.mPayInfo.dqL == 31))
    {
      if (this.mPayInfo.dqL == 32) {
        ac.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.dac, this.iXf, this.mPayInfo.hbR.getDouble("total_fee"), this.mPayInfo.hbR.getString("fee_type"), i, this.mPayInfo.hbR.getString("extinfo_key_1"), this.AYu.field_bindSerial, this.mPayInfo.hbR.getString("extinfo_key_4")));
        AppMethodBeat.o(72134);
        return;
      }
    }
    if (this.mPayInfo.dqL == 11)
    {
      String str1 = this.iXf;
      String str2 = this.BSL;
      String str3 = this.mPayInfo.dac;
      double d = this.mPayInfo.hbR.getDouble("total_fee");
      String str4 = this.mPayInfo.hbR.getString("fee_type");
      String str5 = this.AYu.field_bindSerial;
      String str6 = this.AYu.field_bankcardType;
      s.epp();
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str1, str2, str3, d, str4, str5, str6, s.epq().AZp.field_bindSerial));
      AppMethodBeat.o(72134);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.a(this.mPayInfo.dac, this.mPayInfo.hbR.getDouble("total_fee"), this.mPayInfo.hbR.getString("fee_type"), this.AYu.field_bankcardType, this.AYu.field_bindSerial, this.BSL, this.iXf));
    AppMethodBeat.o(72134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI
 * JD-Core Version:    0.7.0.1
 */