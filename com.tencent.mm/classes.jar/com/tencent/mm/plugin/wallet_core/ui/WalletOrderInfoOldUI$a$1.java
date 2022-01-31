package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Set;

final class WalletOrderInfoOldUI$a$1
  implements AdapterView.OnItemClickListener
{
  WalletOrderInfoOldUI$a$1(WalletOrderInfoOldUI.a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.qEO.qEN.qEH.AW(paramInt);
    if (!bk.bl(paramAdapterView.mPa)) {
      if (this.qEO.qEN.qDU.contains(paramAdapterView.mPa))
      {
        this.qEO.qEN.qDU.remove(paramAdapterView.mPa);
        this.qEO.qEN.qEE.notifyDataSetChanged();
      }
    }
    do
    {
      return;
      this.qEO.qEN.qDU.add(paramAdapterView.mPa);
      break;
      paramView = this.qEO.qEN.gL(paramAdapterView.qqG);
    } while ((!"-1".equals(paramView)) && (!"3".equals(paramView)));
    h.nFQ.f(13472, new Object[] { WalletOrderInfoOldUI.b(this.qEO.qEN), Integer.valueOf(paramAdapterView.qxB), Integer.valueOf(1), Long.valueOf(paramAdapterView.qqG), Long.valueOf(paramAdapterView.qwo) });
    h.nFQ.f(13033, new Object[] { Integer.valueOf(2), "", paramAdapterView.url, paramAdapterView.name, "" });
    if ((!bk.bl(paramAdapterView.qxE)) && (!bk.bl(paramAdapterView.qxF)))
    {
      y.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", new Object[] { paramAdapterView.qxE, paramAdapterView.qxF });
      paramView = new rc();
      paramView.caq.userName = paramAdapterView.qxE;
      paramView.caq.cas = bk.aM(paramAdapterView.qxF, "");
      paramView.caq.scene = 1060;
      paramView.caq.bFv = this.qEO.qEN.mKL;
      paramView.caq.cat = 0;
      a.udP.m(paramView);
      h.nFQ.f(14118, new Object[] { this.qEO.qEN.mKL, this.qEO.qEN.bTO(), Integer.valueOf(2) });
      WalletOrderInfoOldUI.a(this.qEO.qEN, new WalletOrderInfoOldUI.d(this.qEO.qEN, paramAdapterView.qqG, paramAdapterView.qxC, paramAdapterView.qwm, paramAdapterView.qwn, this.qEO.qEN.bTO(), WalletOrderInfoOldUI.b(this.qEO.qEN), paramAdapterView.qwo));
      WalletOrderInfoOldUI.a(this.qEO.qEN, true);
      return;
    }
    if (paramAdapterView.qxB == 1)
    {
      this.qEO.qEN.a(paramAdapterView);
      return;
    }
    if ((paramAdapterView.qxB == 2) && (!bk.bl(paramAdapterView.url)))
    {
      if (WalletOrderInfoOldUI.c(this.qEO.qEN).containsKey(paramAdapterView.qqG))
      {
        paramAdapterView = (WalletOrderInfoOldUI.b)WalletOrderInfoOldUI.c(this.qEO.qEN).get(paramAdapterView.qqG);
        y.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", new Object[] { paramAdapterView.url });
        this.qEO.qEN.QK(paramAdapterView.url);
        return;
      }
      this.qEO.qEN.qAP = paramAdapterView.url;
      this.qEO.qEN.a(paramAdapterView.url, new WalletOrderInfoOldUI.d(this.qEO.qEN, paramAdapterView.qqG, paramAdapterView.qxC, paramAdapterView.qwm, paramAdapterView.qwn, this.qEO.qEN.bTO(), WalletOrderInfoOldUI.b(this.qEO.qEN), paramAdapterView.qwo));
      return;
    }
    y.e("MicroMsg.WalletOrderInfoOldUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.a.1
 * JD-Core Version:    0.7.0.1
 */