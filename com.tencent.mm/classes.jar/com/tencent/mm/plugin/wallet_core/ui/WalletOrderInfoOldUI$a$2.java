package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;

final class WalletOrderInfoOldUI$a$2
  implements View.OnClickListener
{
  WalletOrderInfoOldUI$a$2(WalletOrderInfoOldUI.a parama, Orders.Commodity paramCommodity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new rc();
    paramView.caq.userName = this.qEP.qxl.qhq;
    paramView.caq.cas = bk.aM(this.qEP.qxl.qhr, "");
    paramView.caq.scene = 1034;
    paramView.caq.cat = 0;
    a.udP.m(paramView);
    h.nFQ.f(14118, new Object[] { this.qEO.qEN.mKL, this.qEO.qEN.bTO(), Integer.valueOf(1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.a.2
 * JD-Core Version:    0.7.0.1
 */