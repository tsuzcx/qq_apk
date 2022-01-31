package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wallet_payu.pay.a.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUPayUI
  extends WalletPayUI
{
  private String uDj = null;
  
  public final void Z(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(48492);
    this.tWF = true;
    if (this.qrf != null) {
      paramBundle.putInt("key_support_bankcard", this.qrf.ubU);
    }
    if (!cSe()) {}
    for (;;)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      com.tencent.mm.wallet_core.a.a(this, e.class, paramBundle);
      AppMethodBeat.o(48492);
      return;
      bool = false;
    }
  }
  
  public final void cRT()
  {
    AppMethodBeat.i(48491);
    if (!asr())
    {
      AppMethodBeat.o(48491);
      return;
    }
    ab.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
    this.tWX = b.a(this, this.qrf, this.tVQ, this.tNH, new WalletPayUPayUI.1(this), new WalletPayUPayUI.2(this), new WalletPayUPayUI.3(this), "CREDITCARD_PAYU".equals(this.tNH.field_bankcardType));
    AppMethodBeat.o(48491);
  }
  
  public final void cRZ()
  {
    AppMethodBeat.i(48490);
    doSceneProgress(new c(getPayInfo().cnI), getPayInfo().wgt);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.b.a(getPayInfo().cnI), getPayInfo().wgt);
    AppMethodBeat.o(48490);
  }
  
  public final void nB(boolean paramBoolean)
  {
    AppMethodBeat.i(48493);
    if ((this.mPayInfo.cCD == 32) || (this.mPayInfo.cCD == 31))
    {
      if (this.mPayInfo.cCD == 32) {
        ab.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.mPayInfo.cnI, this.gJv, this.mPayInfo.wgv.getDouble("total_fee"), this.mPayInfo.wgv.getString("fee_type"), i, this.mPayInfo.wgv.getString("extinfo_key_1"), this.tNH.field_bindSerial, this.mPayInfo.wgv.getString("extinfo_key_4")));
        AppMethodBeat.o(48493);
        return;
      }
    }
    if (this.mPayInfo.cCD == 11)
    {
      String str1 = this.gJv;
      String str2 = this.uDj;
      String str3 = this.mPayInfo.cnI;
      double d = this.mPayInfo.wgv.getDouble("total_fee");
      String str4 = this.mPayInfo.wgv.getString("fee_type");
      String str5 = this.tNH.field_bindSerial;
      String str6 = this.tNH.field_bankcardType;
      s.cRG();
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str1, str2, str3, d, str4, str5, str6, s.cRH().tOD.field_bindSerial));
      AppMethodBeat.o(48493);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.mPayInfo.cnI, this.mPayInfo.wgv.getDouble("total_fee"), this.mPayInfo.wgv.getString("fee_type"), this.tNH.field_bankcardType, this.tNH.field_bindSerial, this.uDj, this.gJv));
    AppMethodBeat.o(48493);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48488);
    super.onCreate(paramBundle);
    AppMethodBeat.o(48488);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48489);
    ab.i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(48489);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48494);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof c))
      {
        this.qrf = ((c)paramm).qrf;
        if (this.qrf != null)
        {
          paramInt1 = this.qrf.ujl.size();
          this.mCount = paramInt1;
          paramm = new StringBuilder("get mOrders! bankcardTag : ");
          if (this.qrf == null) {
            break label210;
          }
        }
        label210:
        for (paramString = Integer.valueOf(this.qrf.ubU);; paramString = "")
        {
          ab.d("MicroMsg.WalletPayUPayUI", paramString);
          asr();
          if ((this.qrf == null) || (this.qrf.ujl == null)) {
            break label299;
          }
          paramString = new LinkedList();
          paramm = this.qrf.ujl.iterator();
          while (paramm.hasNext())
          {
            Orders.Commodity localCommodity = (Orders.Commodity)paramm.next();
            if (bo.isNullOrNil(localCommodity.cnJ)) {
              localCommodity.cnJ = this.mPayInfo.cnI;
            }
            paramString.add(localCommodity.cnJ);
          }
          paramInt1 = 0;
          break;
        }
        if (paramString.size() > 0)
        {
          paramm = new vj();
          paramm.cMx.cMz = paramString;
          com.tencent.mm.sdk.b.a.ymk.l(paramm);
        }
        paramString = new Bundle();
        paramString.putDouble("total_fee", this.qrf.cnL);
        paramString.putString("fee_type", "ZAR");
        if (this.mPayInfo.wgv == null) {
          this.mPayInfo.wgv = paramString;
        }
      }
      label299:
      do
      {
        do
        {
          for (;;)
          {
            bJ();
            AppMethodBeat.o(48494);
            return true;
            this.mPayInfo.wgv.putAll(paramString);
          }
          if (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.b.a)) {
            break;
          }
          s.cRG();
          this.tNG = s.cRH().nI(cSm());
          s.cRG();
          this.tNH = s.cRH().a(null, null, cSm(), false);
          this.qqy.setClickable(true);
        } while ((this.qrf == null) || (this.tNG == null) || (this.mPayInfo == null));
        com.tencent.mm.plugin.wallet_core.utils.d.a(this.mPayInfo, this.qrf);
        paramString = com.tencent.mm.plugin.report.service.h.qsU;
        paramInt2 = this.mPayInfo.cCD;
        s.cRG();
        if (s.cRH().cUl()) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          paramString.e(10690, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf((int)(this.qrf.cnL * 100.0D)), this.qrf.ppp });
          break;
        }
        if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b))
        {
          paramString = (com.tencent.mm.plugin.wallet_payu.pay.a.b)paramm;
          paramm = getInput();
          paramm.putParcelable("key_pay_info", this.mPayInfo);
          paramm.putParcelable("key_bankcard", this.tNH);
          paramm.putString("key_bank_type", this.tNH.field_bankcardType);
          if (!bo.isNullOrNil(this.gJv)) {
            paramm.putString("key_pwd1", this.gJv);
          }
          paramm.putString("kreq_token", paramString.getToken());
          paramm.putParcelable("key_authen", cSd());
          paramm.putBoolean("key_need_verify_sms", false);
          paramm.putString("key_mobile", this.tNH.field_mobile);
          if (paramString.isSuccess()) {
            paramm.putParcelable("key_orders", com.tencent.mm.plugin.wallet_payu.pay.a.d.a(this.qrf, paramString.uDf, paramString.uDg, paramString.timestamp, paramString.umN));
          }
          getInput().putBoolean("key_should_redirect", paramString.uDd);
          getInput().putString("key_gateway_code", paramString.uBI);
          getInput().putString("key_gateway_reference", paramString.uBH);
          getInput().putBoolean("key_should_force_adjust", paramString.uDe);
          getInput().putString("key_force_adjust_code", paramString.uBK);
          paramm.putInt("key_pay_flag", 3);
          Z(paramm);
          AppMethodBeat.o(48494);
          return true;
        }
      } while (!(paramm instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a));
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.a)paramm;
      paramm = getInput();
      paramm.putParcelable("key_pay_info", this.mPayInfo);
      paramm.putParcelable("key_bankcard", this.tNH);
      paramm.putString("key_bank_type", this.tNH.field_bankcardType);
      if (!bo.isNullOrNil(this.gJv)) {
        paramm.putString("key_pwd1", this.gJv);
      }
      paramm.putString("kreq_token", paramString.getToken());
      paramm.putParcelable("key_authen", cSd());
      paramm.putBoolean("key_need_verify_sms", false);
      paramm.putString("key_mobile", this.tNH.field_mobile);
      paramm.putParcelable("key_orders", this.qrf);
      paramm.putInt("key_pay_flag", 3);
      Z(paramm);
      AppMethodBeat.o(48494);
      return true;
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b)) {}
    switch (paramInt2)
    {
    case 405: 
    case 406: 
    case 407: 
    default: 
      AppMethodBeat.o(48494);
      return false;
    case 402: 
    case 403: 
    case 408: 
      paramm = (com.tencent.mm.plugin.wallet_payu.pay.a.b)paramm;
      this.tWK = getInput();
      this.tWK.putParcelable("key_pay_info", this.mPayInfo);
      this.tWK.putParcelable("key_bankcard", this.tNH);
      if (!bo.isNullOrNil(this.gJv)) {
        this.tWK.putString("key_pwd1", this.gJv);
      }
      this.tWK.putString("kreq_token", paramm.getToken());
      this.tWK.putString("key_mobile", this.tNH.field_mobile);
      this.tWK.putInt("key_err_code", paramInt2);
      this.tWK.putParcelable("key_orders", this.qrf);
      if (bo.isNullOrNil(paramString)) {
        paramString = getString(2131305490);
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.d(this, paramString, "", getString(2131305489), getString(2131296888), new WalletPayUPayUI.4(this), new WalletPayUPayUI.5(this));
      AppMethodBeat.o(48494);
      return true;
      if ((this.tNH == null) || (this.qrf == null)) {
        break;
      }
      this.tNH.ufL = this.qrf.cnI;
      if ((this.tNG != null) && (this.tNG.size() > 1)) {
        c(true, 4, paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(48494);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI
 * JD-Core Version:    0.7.0.1
 */