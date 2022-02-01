package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.f;

final class WalletBankcardManageUI$4
  implements MenuItem.OnMenuItemClickListener
{
  WalletBankcardManageUI$4(WalletBankcardManageUI paramWalletBankcardManageUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(69104);
    paramMenuItem = new e(this.HDv.getContext(), 1, false);
    paramMenuItem.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(69102);
        paramAnonymousm.kV(0, 2131767502);
        AppMethodBeat.o(69102);
      }
    };
    paramMenuItem.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(69103);
        paramAnonymousInt = paramAnonymousMenuItem.getItemId();
        Log.i("MicroMsg.WalletBankcardManageUI", "operType：%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(69103);
          return;
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra(e.p.OzJ, true);
          paramAnonymousMenuItem.putExtra("rawUrl", "https://" + WeChatHosts.domainString(2131761715) + "/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
          f.aA(WalletBankcardManageUI.4.this.HDv.getContext(), paramAnonymousMenuItem);
          h.CyF.a(14422, new Object[] { Integer.valueOf(3) });
        }
      }
    };
    paramMenuItem.dGm();
    AppMethodBeat.o(69104);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.4
 * JD-Core Version:    0.7.0.1
 */