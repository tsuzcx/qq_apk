package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bhm;
import com.tencent.mm.protocal.c.uc;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;

final class WalletLqtDetailUI$4$2
  implements n.d
{
  WalletLqtDetailUI$4$2(WalletLqtDetailUI.4 param4) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem.getItemId() == -1) && (!WalletLqtDetailUI.c(this.qim.qil).tCj)) {
      if (WalletLqtDetailUI.c(this.qim.qil).sOy == 0)
      {
        paramMenuItem = this.qim.qil.getString(a.i.wallet_lqt_close_alert_wording);
        h.a(this.qim.qil, paramMenuItem, "", this.qim.qil.getString(a.i.close_btn), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            WalletLqtDetailUI.g(WalletLqtDetailUI.4.2.this.qim.qil);
            paramAnonymousDialogInterface = new Intent(WalletLqtDetailUI.4.2.this.qim.qil, WalletLqtSimpleCheckPwdUI.class);
            WalletLqtDetailUI.4.2.this.qim.qil.startActivityForResult(paramAnonymousDialogInterface, 123);
          }
        });
      }
    }
    while ((WalletLqtDetailUI.c(this.qim.qil).tCc == null) || (WalletLqtDetailUI.c(this.qim.qil).tCc.size() <= 0) || (paramMenuItem.getItemId() >= WalletLqtDetailUI.c(this.qim.qil).tCc.size())) {
      for (;;)
      {
        return;
        paramMenuItem = this.qim.qil.getString(a.i.wallet_lqb_close_alert_wording);
      }
    }
    paramMenuItem = (uc)WalletLqtDetailUI.c(this.qim.qil).tCc.get(paramMenuItem.getItemId());
    e.l(this.qim.qil, paramMenuItem.sQT, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.4.2
 * JD-Core Version:    0.7.0.1
 */