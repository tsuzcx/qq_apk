package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.g;

final class WalletBankcardManageUI$4
  implements MenuItem.OnMenuItemClickListener
{
  WalletBankcardManageUI$4(WalletBankcardManageUI paramWalletBankcardManageUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(69104);
    paramMenuItem = new e(this.Ovo.getContext(), 1, false);
    paramMenuItem.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(69102);
        paramAnonymouso.mn(0, a.i.wallet_bankcard_manager_ui_help_text);
        AppMethodBeat.o(69102);
      }
    };
    paramMenuItem.ODU = new q.g()
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
          paramAnonymousMenuItem.putExtra(f.r.VSX, true);
          paramAnonymousMenuItem.putExtra("rawUrl", "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
          g.aJ(WalletBankcardManageUI.4.this.Ovo.getContext(), paramAnonymousMenuItem);
          h.IzE.a(14422, new Object[] { Integer.valueOf(3) });
        }
      }
    };
    paramMenuItem.eik();
    AppMethodBeat.o(69104);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.4
 * JD-Core Version:    0.7.0.1
 */