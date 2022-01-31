package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.a;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WalletPayUOrderInfoUI
  extends WalletOrderInfoOldUI
{
  public final void afK(String paramString)
  {
    AppMethodBeat.i(48479);
    doSceneProgress(new c(paramString, 1));
    AppMethodBeat.o(48479);
  }
  
  public final void cVO()
  {
    AppMethodBeat.i(48478);
    doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.b.a());
    AppMethodBeat.o(48478);
  }
  
  public final void done()
  {
    AppMethodBeat.i(48482);
    cVu();
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
    ((Bundle)localObject1).putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
    ((Bundle)localObject1).putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
    ab.i("MicroMsg.WalletPayUOrderInfoUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
    Object localObject2 = this.uqP.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if (!bo.isNullOrNil(str))
      {
        ab.d("MicroMsg.WalletPayUOrderInfoUI", "hy: doing netscene subscribe...appName: %s", new Object[] { str });
        doSceneProgress(new com.tencent.mm.wallet_core.c.r(str), false);
      }
    }
    com.tencent.mm.wallet_core.a.j(this, (Bundle)localObject1);
    if ((this.tVr != null) && (!bo.isNullOrNil(this.tVr.lHq))) {
      if (this.tVr.ujl.size() <= 0) {
        break label315;
      }
    }
    label315:
    for (localObject1 = ((Orders.Commodity)this.tVr.ujl.get(0)).cnJ;; localObject1 = "")
    {
      localObject1 = String.format("%sreqkey=%s&transid=%s", new Object[] { this.tVr.lHq, this.tVr.cnI, localObject1 });
      ab.d("MicroMsg.WalletPayUOrderInfoUI", "url = ".concat(String.valueOf(localObject1)));
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("showShare", false);
      ((Intent)localObject2).putExtra("geta8key_username", com.tencent.mm.model.r.Zn());
      com.tencent.mm.bq.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(48482);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48477);
    super.onCreate(paramBundle);
    addSceneEndListener(1554);
    AppMethodBeat.o(48477);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48480);
    removeSceneEndListener(1554);
    super.onDestroy();
    AppMethodBeat.o(48480);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48481);
    if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.pay.a.a))
    {
      AppMethodBeat.o(48481);
      return true;
    }
    Object localObject;
    if ((paramm instanceof c))
    {
      localObject = (c)paramm;
      if ((((c)localObject).qrf.ujl != null) && (((c)localObject).qrf.ujl.size() > 0)) {
        break label105;
      }
      ab.w("MicroMsg.WalletPayUOrderInfoUI", "hy: no commodity. show alert");
      h.a(this, 2131305508, 2131297087, new WalletPayUOrderInfoUI.1(this));
    }
    label105:
    do
    {
      boolean bool = super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
      AppMethodBeat.o(48481);
      return bool;
      localObject = (Orders.Commodity)((c)localObject).qrf.ujl.get(0);
      ab.d("MicroMsg.WalletPayUOrderInfoUI", "Coomdity:".concat(String.valueOf(localObject)));
      com.tencent.mm.plugin.wallet_payu.a.d.cXq().uCJ = null;
    } while (localObject == null);
    this.uqQ = new ArrayList();
    this.uqQ.add(localObject);
    g.RM();
    ad localad = ((j)g.E(j.class)).YA().arw(((Orders.Commodity)localObject).ppq);
    if ((localad != null) && ((int)localad.euF != 0)) {
      R(localad);
    }
    for (;;)
    {
      this.urM.notifyDataSetChanged();
      cVP();
      break;
      ao.a.flI.a(((Orders.Commodity)localObject).ppq, "", this.urT);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */