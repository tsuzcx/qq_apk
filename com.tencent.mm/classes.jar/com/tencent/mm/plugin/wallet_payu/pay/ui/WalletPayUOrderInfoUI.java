package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.a;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WalletPayUOrderInfoUI
  extends WalletOrderInfoOldUI
{
  protected final void QM(String paramString)
  {
    a(new c(paramString, 1), true, true);
  }
  
  protected final void bWL()
  {
    a(new com.tencent.mm.plugin.wallet_core.c.b.a(), true, true);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a)) {
      return true;
    }
    Object localObject;
    if ((paramm instanceof c))
    {
      localObject = (c)paramm;
      if ((((c)localObject).nEh.qwN != null) && (((c)localObject).nEh.qwN.size() > 0)) {
        break label88;
      }
      y.w("MicroMsg.WalletPayUOrderInfoUI", "hy: no commodity. show alert");
      h.a(this, a.i.wallet_payu_show_order_error, a.i.app_tip, new WalletPayUOrderInfoUI.1(this));
    }
    label88:
    do
    {
      return super.c(paramInt1, paramInt2, paramString, paramm);
      localObject = (Orders.Commodity)((c)localObject).nEh.qwN.get(0);
      y.d("MicroMsg.WalletPayUOrderInfoUI", "Coomdity:" + localObject);
      com.tencent.mm.plugin.wallet_payu.a.d.bXH().qNC = null;
    } while (localObject == null);
    this.qDV = new ArrayList();
    this.qDV.add(localObject);
    g.DQ();
    ad localad = ((j)g.r(j.class)).Fw().abl(((Orders.Commodity)localObject).mPa);
    if ((localad != null) && ((int)localad.dBe != 0)) {
      O(localad);
    }
    for (;;)
    {
      this.qEE.notifyDataSetChanged();
      bWM();
      break;
      am.a.dVy.a(((Orders.Commodity)localObject).mPa, "", this.qEL);
    }
  }
  
  public final void done()
  {
    bWx();
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("intent_pay_end_errcode", this.BX.getInt("intent_pay_end_errcode"));
    ((Bundle)localObject1).putString("intent_pay_app_url", this.BX.getString("intent_pay_app_url"));
    ((Bundle)localObject1).putBoolean("intent_pay_end", this.BX.getBoolean("intent_pay_end"));
    y.i("MicroMsg.WalletPayUOrderInfoUI", "pay done...feedbackData errCode:" + this.BX.getInt("intent_pay_end_errcode"));
    Object localObject2 = this.qDU.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if (!bk.bl(str))
      {
        y.d("MicroMsg.WalletPayUOrderInfoUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str });
        a(new p(str), false, false);
      }
    }
    com.tencent.mm.wallet_core.a.j(this, (Bundle)localObject1);
    if ((this.qmc != null) && (!bk.bl(this.qmc.jxR))) {
      if (this.qmc.qwN.size() <= 0) {
        break label321;
      }
    }
    label321:
    for (localObject1 = ((Orders.Commodity)this.qmc.qwN.get(0)).bMY;; localObject1 = "")
    {
      localObject1 = String.format("%sreqkey=%s&transid=%s", new Object[] { this.qmc.jxR, this.qmc.bMX, localObject1 });
      y.d("MicroMsg.WalletPayUOrderInfoUI", "url = " + (String)localObject1);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("showShare", false);
      ((Intent)localObject2).putExtra("geta8key_username", q.Gj());
      com.tencent.mm.br.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject2);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(1554);
  }
  
  public void onDestroy()
  {
    ki(1554);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */