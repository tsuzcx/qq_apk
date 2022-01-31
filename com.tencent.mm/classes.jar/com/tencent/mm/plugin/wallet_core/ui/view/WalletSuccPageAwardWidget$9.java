package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import d.a.a.c;
import d.a.a.g;

final class WalletSuccPageAwardWidget$9
  implements View.OnClickListener
{
  WalletSuccPageAwardWidget$9(WalletSuccPageAwardWidget paramWalletSuccPageAwardWidget) {}
  
  public final void onClick(View paramView)
  {
    int i = 2;
    AppMethodBeat.i(47953);
    if ((WalletSuccPageAwardWidget.j(this.uxM) != null) && (WalletSuccPageAwardWidget.j(this.uxM).wRb != null))
    {
      WalletSuccPageAwardWidget.a(this.uxM, WalletSuccPageAwardWidget.j(this.uxM).wRb);
      ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(this.uxM).CLj) });
      if (WalletSuccPageAwardWidget.k(this.uxM).CLj != 1) {
        break label241;
      }
      ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(this.uxM).CLj), WalletSuccPageAwardWidget.k(this.uxM).url });
      e.m(WalletSuccPageAwardWidget.l(this.uxM), WalletSuccPageAwardWidget.k(this.uxM).url, false);
      WalletSuccPageAwardWidget.m(this.uxM);
      WalletSuccPageAwardWidget.n(this.uxM);
      WalletSuccPageAwardWidget.o(this.uxM);
      WalletSuccPageAwardWidget.p(this.uxM).postDelayed(new WalletSuccPageAwardWidget.9.1(this), 3000L);
      paramView = h.qsU;
      if (!WalletSuccPageAwardWidget.e(this.uxM)) {
        break label705;
      }
    }
    for (;;)
    {
      paramView.e(15225, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
      AppMethodBeat.o(47953);
      return;
      label241:
      if (WalletSuccPageAwardWidget.k(this.uxM).CLj == 2)
      {
        paramView = WalletSuccPageAwardWidget.k(this.uxM).CLk;
        if (paramView != null)
        {
          ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", new Object[] { paramView.xzC, paramView.xzD, Integer.valueOf(paramView.xzE) });
          so localso = new so();
          localso.cIQ.userName = paramView.xzC;
          localso.cIQ.cIS = bo.bf(paramView.xzD, "");
          localso.cIQ.scene = 1060;
          localso.cIQ.cmF = WalletSuccPageAwardWidget.q(this.uxM);
          localso.cIQ.cIT = 0;
          if (paramView.xzE > 0) {
            localso.cIQ.bDc = paramView.xzE;
          }
          localso.cIQ.context = WalletSuccPageAwardWidget.l(this.uxM);
          com.tencent.mm.sdk.b.a.ymk.l(localso);
          WalletSuccPageAwardWidget.m(this.uxM);
          WalletSuccPageAwardWidget.o(this.uxM);
          WalletSuccPageAwardWidget.p(this.uxM).postDelayed(new WalletSuccPageAwardWidget.9.2(this), 3000L);
        }
        WalletSuccPageAwardWidget.n(this.uxM);
        break;
      }
      if (WalletSuccPageAwardWidget.k(this.uxM).CLj == 3)
      {
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
        WalletSuccPageAwardWidget.r(this.uxM);
        WalletSuccPageAwardWidget.n(this.uxM);
        break;
      }
      if (WalletSuccPageAwardWidget.k(this.uxM).CLj == 5)
      {
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
        break;
      }
      if (WalletSuccPageAwardWidget.k(this.uxM).CLj == 6)
      {
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
        WalletSuccPageAwardWidget.n(this.uxM);
        break;
      }
      if (WalletSuccPageAwardWidget.k(this.uxM).CLj == 7)
      {
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
        WalletSuccPageAwardWidget.a(this.uxM, 3, true);
        WalletSuccPageAwardWidget.n(this.uxM);
        break;
      }
      if (WalletSuccPageAwardWidget.k(this.uxM).CLj == 8)
      {
        WalletSuccPageAwardWidget.r(this.uxM);
        ab.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", new Object[] { Integer.valueOf(WalletSuccPageAwardWidget.k(this.uxM).CLj), WalletSuccPageAwardWidget.k(this.uxM).url });
        WalletSuccPageAwardWidget.n(this.uxM);
        break;
      }
      if (WalletSuccPageAwardWidget.k(this.uxM).CLj != 9) {
        break;
      }
      WalletSuccPageAwardWidget.r(this.uxM);
      WalletSuccPageAwardWidget.n(this.uxM);
      break;
      label705:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.9
 * JD-Core Version:    0.7.0.1
 */