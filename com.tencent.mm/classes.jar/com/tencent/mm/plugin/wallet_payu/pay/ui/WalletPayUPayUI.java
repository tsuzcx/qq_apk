package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.to;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.plugin.wallet_payu.pay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUPayUI
  extends WalletPayUI
{
  private String qOc = null;
  
  protected final void I(Bundle paramBundle)
  {
    boolean bool = true;
    this.qnp = true;
    if (this.nEh != null) {
      paramBundle.putInt("key_support_bankcard", this.nEh.qqY);
    }
    if (!bUk()) {}
    for (;;)
    {
      paramBundle.putBoolean("key_is_oversea", bool);
      com.tencent.mm.wallet_core.a.a(this, e.class, paramBundle);
      return;
      bool = false;
    }
  }
  
  protected final void bTY()
  {
    if (!YH()) {
      return;
    }
    y.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
    this.qgo = b.a(this, this.nEh, this.qmA, this.qgs, new WalletPayUPayUI.1(this), new View.OnClickListener()new WalletPayUPayUI.3
    {
      public final void onClick(View paramAnonymousView)
      {
        WalletPayUPayUI.a(WalletPayUPayUI.this, (FavorPayInfo)paramAnonymousView.getTag());
        if (WalletPayUPayUI.a(WalletPayUPayUI.this) != null) {
          WalletPayUPayUI.b(WalletPayUPayUI.this).qvG = "";
        }
        WalletPayUPayUI.c(WalletPayUPayUI.this, "");
        WalletPayUPayUI.c(WalletPayUPayUI.this).dismiss();
        WalletPayUPayUI.d(WalletPayUPayUI.this);
        WalletPayUPayUI.e(WalletPayUPayUI.this);
      }
    }, new WalletPayUPayUI.3(this), "CREDITCARD_PAYU".equals(this.qgs.field_bankcardType));
  }
  
  protected final void bUf()
  {
    a(new com.tencent.mm.plugin.wallet_payu.pay.a.c(bUr().bMX), bUr().snV, false);
    a(new com.tencent.mm.plugin.wallet_core.c.b.a(bUr().bMX), bUr().snV, false);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.pay.a.c))
      {
        this.nEh = ((com.tencent.mm.plugin.wallet_payu.pay.a.c)paramm).nEh;
        paramInt1 = i;
        if (this.nEh != null) {
          paramInt1 = this.nEh.qwN.size();
        }
        this.mCount = paramInt1;
        paramm = new StringBuilder("get mOrders! bankcardTag : ");
        if (this.nEh != null) {}
        for (paramString = Integer.valueOf(this.nEh.qqY);; paramString = "")
        {
          y.d("MicroMsg.WalletPayUPayUI", paramString);
          YH();
          if ((this.nEh == null) || (this.nEh.qwN == null)) {
            break label294;
          }
          paramString = new LinkedList();
          paramm = this.nEh.qwN.iterator();
          while (paramm.hasNext())
          {
            Orders.Commodity localCommodity = (Orders.Commodity)paramm.next();
            if (bk.bl(localCommodity.bMY)) {
              localCommodity.bMY = this.nDu.bMX;
            }
            paramString.add(localCommodity.bMY);
          }
        }
        if (paramString.size() > 0)
        {
          paramm = new to();
          paramm.cdN.cdP = paramString;
          com.tencent.mm.sdk.b.a.udP.m(paramm);
        }
        paramString = new Bundle();
        paramString.putDouble("total_fee", this.nEh.nCq);
        paramString.putString("fee_type", "ZAR");
        if (this.nDu.snX == null) {
          this.nDu.snX = paramString;
        }
      }
      label294:
      do
      {
        do
        {
          for (;;)
          {
            aZ();
            return true;
            this.nDu.snX.putAll(paramString);
          }
          if (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.b.a)) {
            break;
          }
          p.bTK();
          this.qgr = p.bTL().kt(bTV());
          p.bTK();
          this.qgs = p.bTL().a(null, null, bTV(), false);
          this.nBL.setClickable(true);
        } while ((this.nEh == null) || (this.qgr == null) || (this.nDu == null));
        com.tencent.mm.plugin.wallet_core.e.c.a(this.nDu, this.nEh);
        paramString = com.tencent.mm.plugin.report.service.h.nFQ;
        paramInt2 = this.nDu.bUV;
        p.bTK();
        if (p.bTL().bVN()) {}
        for (paramInt1 = 2;; paramInt1 = 1)
        {
          paramString.f(10690, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf((int)(this.nEh.nCq * 100.0D)), this.nEh.mOZ });
          break;
        }
        if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b))
        {
          paramString = (com.tencent.mm.plugin.wallet_payu.pay.a.b)paramm;
          paramm = this.BX;
          paramm.putParcelable("key_pay_info", this.nDu);
          paramm.putParcelable("key_bankcard", this.qgs);
          paramm.putString("key_bank_type", this.qgs.field_bankcardType);
          if (!bk.bl(this.frT)) {
            paramm.putString("key_pwd1", this.frT);
          }
          paramm.putString("kreq_token", paramString.getToken());
          paramm.putParcelable("key_authen", bUj());
          paramm.putBoolean("key_need_verify_sms", false);
          paramm.putString("key_mobile", this.qgs.field_mobile);
          if (paramString.isSuccess()) {
            paramm.putParcelable("key_orders", d.a(this.nEh, paramString.qNY, paramString.qNZ, paramString.timestamp, paramString.qAc));
          }
          this.BX.putBoolean("key_should_redirect", paramString.qNW);
          this.BX.putString("key_gateway_code", paramString.qMB);
          this.BX.putString("key_gateway_reference", paramString.qMA);
          this.BX.putBoolean("key_should_force_adjust", paramString.qNX);
          this.BX.putString("key_force_adjust_code", paramString.qMD);
          paramm.putInt("key_pay_flag", 3);
          I(paramm);
          return true;
        }
      } while (!(paramm instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a));
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.a)paramm;
      paramm = this.BX;
      paramm.putParcelable("key_pay_info", this.nDu);
      paramm.putParcelable("key_bankcard", this.qgs);
      paramm.putString("key_bank_type", this.qgs.field_bankcardType);
      if (!bk.bl(this.frT)) {
        paramm.putString("key_pwd1", this.frT);
      }
      paramm.putString("kreq_token", paramString.getToken());
      paramm.putParcelable("key_authen", bUj());
      paramm.putBoolean("key_need_verify_sms", false);
      paramm.putString("key_mobile", this.qgs.field_mobile);
      paramm.putParcelable("key_orders", this.nEh);
      paramm.putInt("key_pay_flag", 3);
      I(paramm);
      return true;
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b)) {}
    switch (paramInt2)
    {
    case 405: 
    case 406: 
    case 407: 
    default: 
      return false;
    case 402: 
    case 403: 
    case 408: 
      paramm = (com.tencent.mm.plugin.wallet_payu.pay.a.b)paramm;
      this.qnt = this.BX;
      this.qnt.putParcelable("key_pay_info", this.nDu);
      this.qnt.putParcelable("key_bankcard", this.qgs);
      if (!bk.bl(this.frT)) {
        this.qnt.putString("key_pwd1", this.frT);
      }
      this.qnt.putString("kreq_token", paramm.getToken());
      this.qnt.putString("key_mobile", this.qgs.field_mobile);
      this.qnt.putInt("key_err_code", paramInt2);
      this.qnt.putParcelable("key_orders", this.nEh);
      if (bk.bl(paramString)) {
        paramString = getString(a.i.wallet_pay_reset_info_tips);
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(a.i.wallet_pay_reset_info), getString(a.i.app_cancel), new WalletPayUPayUI.4(this), new WalletPayUPayUI.5(this));
      return true;
      if ((this.qgs == null) || (this.nEh == null)) {
        break;
      }
      this.qgs.qtx = this.nEh.bMX;
      if ((this.qgr != null) && (this.qgr.size() > 1))
      {
        c(true, 4, paramString);
        return true;
      }
      b(true, 4, paramString);
      return true;
    }
  }
  
  protected final void kx(boolean paramBoolean)
  {
    if ((this.nDu.bUV == 32) || (this.nDu.bUV == 31))
    {
      if (this.nDu.bUV == 32) {
        y.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        a(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.nDu.bMX, this.frT, this.nDu.snX.getDouble("total_fee"), this.nDu.snX.getString("fee_type"), i, this.nDu.snX.getString("extinfo_key_1"), this.qgs.field_bindSerial, this.nDu.snX.getString("extinfo_key_4")), true, false);
        return;
      }
    }
    if (this.nDu.bUV == 11)
    {
      String str1 = this.frT;
      String str2 = this.qOc;
      String str3 = this.nDu.bMX;
      double d = this.nDu.snX.getDouble("total_fee");
      String str4 = this.nDu.snX.getString("fee_type");
      String str5 = this.qgs.field_bindSerial;
      String str6 = this.qgs.field_bankcardType;
      p.bTK();
      a(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str1, str2, str3, d, str4, str5, str6, p.bTL().qhj.field_bindSerial), true, false);
      return;
    }
    a(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.nDu.bMX, this.nDu.snX.getDouble("total_fee"), this.nDu.snX.getString("fee_type"), this.qgs.field_bankcardType, this.qgs.field_bindSerial, this.qOc, this.frT), true, true);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
    super.onNewIntent(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI
 * JD-Core Version:    0.7.0.1
 */