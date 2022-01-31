package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUChangeBankcardUI
  extends WalletChangeBankcardUI
{
  private String qOc = null;
  private c qOd = new WalletPayUChangeBankcardUI.4(this);
  
  protected final void Qj(String paramString)
  {
    this.qkD.qsI = paramString;
    label163:
    Object localObject;
    boolean bool;
    if (this.qgs != null)
    {
      this.BX.putString("key_mobile", this.qgs.field_mobile);
      this.BX.putParcelable("key_bankcard", this.qgs);
      this.qkD.mOc = this.qgs.field_bindSerial;
      this.qkD.mOb = this.qgs.field_bankcardType;
      if (this.qmA == null) {
        break label332;
      }
      this.qkD.qsU = this.qmA.qvC;
      if ((this.nEh != null) && (this.nEh.qwO != null)) {
        this.qkD.qsT = this.nEh.qwO.qkW;
      }
      if ((this.nEh != null) && (this.nEh.qqY == 3))
      {
        if (!this.qgs.bUT()) {
          break label343;
        }
        this.qkD.bcw = 3;
        localObject = this.BX;
        if (this.qgs.bUT()) {
          break label355;
        }
        bool = true;
        label182:
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
      }
    }
    this.BX.putParcelable("key_authen", this.qkD);
    if ((this.nDu.bUV == 32) || (this.nDu.bUV == 31))
    {
      if (this.nDu.bUV == 32) {
        y.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
      }
      for (int i = 1;; i = 0)
      {
        a(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.nDu.bMX, this.frT, this.nDu.snX.getDouble("total_fee"), this.nDu.snX.getString("fee_type"), i, this.nDu.snX.getString("extinfo_key_1"), this.qgs.field_bindSerial, this.nDu.snX.getString("extinfo_key_4")), true, false);
        return;
        label332:
        this.qkD.qsU = null;
        break;
        label343:
        this.qkD.bcw = 6;
        break label163;
        label355:
        bool = false;
        break label182;
      }
    }
    if (this.nDu.bUV == 11)
    {
      paramString = this.frT;
      localObject = this.qOc;
      String str1 = this.nDu.bMX;
      double d = this.nDu.snX.getDouble("total_fee");
      String str2 = this.nDu.snX.getString("fee_type");
      String str3 = this.qgs.field_bindSerial;
      String str4 = this.qgs.field_bankcardType;
      p.bTK();
      a(new com.tencent.mm.plugin.wallet_payu.balance.a.b(paramString, (String)localObject, str1, d, str2, str3, str4, p.bTL().qhj.field_bindSerial), true, false);
      return;
    }
    a(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.nDu.bMX, this.nDu.snX.getDouble("total_fee"), this.nDu.snX.getString("fee_type"), this.qgs.field_bankcardType, this.qgs.field_bindSerial, this.qOc, paramString), true, true);
  }
  
  protected final g bTX()
  {
    return new a(this, this.qgr, this.qmx, this.nEh);
  }
  
  protected final void bTY()
  {
    y.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
    String str = this.BX.getString("key_pwd1");
    if (bk.bl(str))
    {
      vN(4);
      this.qgo = b.a(this, this.nEh, this.qmA, this.qgs, new WalletPayUChangeBankcardUI.1(this), new View.OnClickListener()new WalletPayUChangeBankcardUI.3
      {
        public final void onClick(View paramAnonymousView)
        {
          if (WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this) != null) {
            WalletPayUChangeBankcardUI.c(WalletPayUChangeBankcardUI.this).dismiss();
          }
          WalletPayUChangeBankcardUI.e(WalletPayUChangeBankcardUI.this).e(WalletPayUChangeBankcardUI.d(WalletPayUChangeBankcardUI.this), true);
          WalletPayUChangeBankcardUI.b(WalletPayUChangeBankcardUI.this, (FavorPayInfo)paramAnonymousView.getTag());
          if (WalletPayUChangeBankcardUI.f(WalletPayUChangeBankcardUI.this) != null) {
            WalletPayUChangeBankcardUI.g(WalletPayUChangeBankcardUI.this).qvG = "";
          }
          WalletPayUChangeBankcardUI.this.BX.putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.h(WalletPayUChangeBankcardUI.this));
          WalletPayUChangeBankcardUI.i(WalletPayUChangeBankcardUI.this);
          WalletPayUChangeBankcardUI.this.vN(0);
        }
      }, new WalletPayUChangeBankcardUI.3(this), "CREDITCARD_PAYU".equals(this.qgs.field_bankcardType));
      return;
    }
    Qj(str);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0) {
        if ((!(paramm instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b)) && (!(paramm instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a)))
        {
          bool1 = bool2;
          if (!(paramm instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b)) {}
        }
        else
        {
          paramString = this.BX;
          if (!bk.bl(this.frT)) {
            paramString.putString("key_pwd1", this.frT);
          }
          paramString.putBoolean("key_need_verify_sms", false);
          paramString.putParcelable("key_pay_info", this.nDu);
          paramString.putInt("key_pay_flag", 3);
          if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b))
          {
            com.tencent.mm.plugin.wallet_payu.pay.a.b localb = (com.tencent.mm.plugin.wallet_payu.pay.a.b)paramm;
            paramString.putString("transid", localb.iGK);
            paramString.putBoolean("key_should_redirect", localb.qNW);
            paramString.putString("key_gateway_code", localb.qMB);
            paramString.putString("key_gateway_reference", localb.qMA);
            paramString.putString("key_force_adjust_code", localb.qMD);
            paramString.putBoolean("key_should_force_adjust", localb.qNX);
            if (localb.isSuccess()) {
              paramString.putParcelable("key_orders", d.a(this.nEh, localb.qNY, localb.qNZ, localb.timestamp, localb.qAc));
            }
          }
          if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))
          {
            paramm = (com.tencent.mm.plugin.wallet_payu.balance.a.b)paramm;
            paramString.putString("transid", paramm.iGK);
            paramString.putBoolean("key_should_redirect", paramm.qMz);
            paramString.putString("key_gateway_code", paramm.qMB);
            paramString.putString("key_gateway_reference", paramm.qMA);
            paramString.putString("key_force_adjust_code", paramm.qMD);
            paramString.putBoolean("key_should_force_adjust", paramm.qMC);
          }
          com.tencent.mm.wallet_core.a.j(this, paramString);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 23351)
    {
      y.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramInt2 == -1)
      {
        this.BX.putBoolean("key_should_redirect", false);
        com.tencent.mm.wallet_core.a.j(this, this.BX);
      }
      if (paramInt2 == 0) {
        com.tencent.mm.wallet_core.a.b(this, this.BX, 0);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.udP.c(this.qOd);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.udP.d(this.qOd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */