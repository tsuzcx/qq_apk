package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoUI
  extends WalletBaseUI
{
  private String mKL;
  protected am.b.a qEL = new WalletOrderInfoUI.1(this);
  private Orders qmc;
  
  protected static String d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString5 = URLEncoder.encode(URLEncoder.encode(paramString5, "utf-8"), "utf-8");
      if ((paramString1.indexOf("%7Breqkey%7D") > 0) || (paramString1.indexOf("%7Btransid%7D") > 0) || (paramString1.indexOf("%7Bphone%7D") > 0) || (paramString1.indexOf("%7Bremark%7D") > 0))
      {
        y.i("MicroMsg.WalletOrderInfoUI", "concat url 1: ");
        return paramString1.replace("%7Breqkey%7D", paramString2).replace("%7Btransid%7D", paramString3).replace("%7Bphone%7D", paramString4).replace("%7Bremark%7D", paramString5);
      }
      if ((paramString1.indexOf("{reqkey}") > 0) || (paramString1.indexOf("{transid}") > 0) || (paramString1.indexOf("{phone}") > 0) || (paramString1.indexOf("{remark}") > 0))
      {
        y.i("MicroMsg.WalletOrderInfoUI", "concat url 2: ");
        return paramString1.replace("{reqkey}", paramString2).replace("{transid}", paramString3).replace("{phone}", paramString4).replace("{remark}", paramString5);
      }
      y.i("MicroMsg.WalletOrderInfoUI", "concat url 3: ");
      paramString2 = paramString1 + String.format("?reqkey=%s&transid=%s&phone=%s&remark=%s", new Object[] { paramString2, paramString3, paramString4, paramString5 });
      return paramString2;
    }
    catch (Exception paramString2)
    {
      y.printErrStackTrace("MicroMsg.WalletOrderInfoUI", paramString2, "", new Object[0]);
    }
    return paramString1;
  }
  
  private void d(Orders paramOrders)
  {
    y.l("MicroMsg.WalletOrderInfoUI", "goToOrderInfoUI, is_use_new_paid_succ_page: %d", new Object[] { Integer.valueOf(paramOrders.qwX) });
    if (paramOrders.qwX == 1) {
      cNj().b(this, WalletOrderInfoNewUI.class, this.BX);
    }
    for (;;)
    {
      finish();
      return;
      cNj().b(this, WalletOrderInfoOldUI.class, this.BX);
    }
  }
  
  protected void O(ad paramad)
  {
    if ((paramad != null) && ((int)paramad.dBe != 0))
    {
      String str = paramad.Bp();
      y.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + str + " username: " + paramad.field_username);
      if ((this.qmc.qwN != null) && (this.qmc.qwN.size() > 0))
      {
        paramad = this.qmc.qwN.iterator();
        while (paramad.hasNext()) {
          ((Orders.Commodity)paramad.next()).mPa = str;
        }
      }
    }
  }
  
  public void QM(String paramString)
  {
    a(new z(paramString), true, true);
  }
  
  public Orders bWG()
  {
    return (Orders)this.BX.getParcelable("key_orders");
  }
  
  protected boolean bwM()
  {
    return true;
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramm instanceof z))
    {
      bool1 = bool2;
      if (paramInt1 == 0)
      {
        bool1 = bool2;
        if (paramInt2 == 0)
        {
          this.qmc = ((z)paramm).qre;
          if (this.qmc == null) {
            break label207;
          }
          if ((this.qmc.qwN != null) && (this.qmc.qwN.size() != 0))
          {
            paramString = (Orders.Commodity)this.qmc.qwN.get(0);
            this.mKL = paramString.bMY;
            y.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + paramString.toString());
            g.DQ();
            paramm = ((j)g.r(j.class)).Fw().abl(paramString.mPa);
            if ((paramm == null) || ((int)paramm.dBe == 0)) {
              break label186;
            }
            O(paramm);
          }
          d(this.qmc);
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label186:
      am.a.dVy.a(paramString.mPa, "", this.qEL);
      break;
      label207:
      y.e("MicroMsg.WalletOrderInfoUI", "cannot get orders");
      h.a(this.mController.uMN, a.i.wallet_order_info_err, 0, new WalletOrderInfoUI.2(this));
    }
  }
  
  protected void cG(String paramString, int paramInt)
  {
    a(new z(paramString, paramInt), true, true);
  }
  
  protected int getLayoutId()
  {
    return a.g.transparent_layout;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i;
    if (bwM())
    {
      this.qmc = bWG();
      this.mKL = this.BX.getString("key_trans_id");
      i = this.BX.getInt("key_pay_type", -1);
      y.i("MicroMsg.WalletOrderInfoUI", "mTransId %s", new Object[] { this.mKL });
      if (this.mKL == null) {
        break label96;
      }
      if (i != -1) {
        break label86;
      }
      QM(this.mKL);
    }
    label86:
    label96:
    while (this.qmc == null)
    {
      return;
      cG(this.mKL, i);
      return;
    }
    d(this.qmc);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.qmc != null) && (!bk.bl(this.qmc.username))) {
      am.a.dVy.iC(this.qmc.username);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */