package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.wallet.balance.a.a.k;
import com.tencent.mm.protocal.c.bhm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$2
  implements View.OnClickListener
{
  WalletLqtDetailUI$2(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = null;
    Object localObject = null;
    boolean bool3 = true;
    boolean bool2 = true;
    if (ae.eTL)
    {
      Intent localIntent = new Intent(this.qil, WalletLqtSaveFetchUI.class);
      paramView = (View)localObject;
      if (WalletLqtDetailUI.c(this.qil) != null) {
        paramView = WalletLqtDetailUI.c(this.qil).tBg;
      }
      localIntent.putExtra("lqt_save_fund_code", paramView);
      localIntent.putExtra("lqt_save_fetch_mode", 1);
      if (WalletLqtDetailUI.c(this.qil).cdr == 1)
      {
        bool1 = true;
        localIntent.putExtra("lqt_is_show_protocol", bool1);
        if (WalletLqtDetailUI.c(this.qil).tBZ != 1) {
          break label171;
        }
      }
      label171:
      for (bool1 = bool2;; bool1 = false)
      {
        localIntent.putExtra("lqt_is_agree_protocol", bool1);
        localIntent.putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.e(this.qil));
        localIntent.putExtra("lqt_profile_wording", WalletLqtDetailUI.c(this.qil).tBT);
        this.qil.startActivity(localIntent);
        return;
        bool1 = false;
        break;
      }
    }
    localObject = WalletLqtDetailUI.f(this.qil).qfI;
    f.ci(Integer.valueOf(WalletLqtDetailUI.c(this.qil).sOy)).c((a)localObject);
    if (!bk.bl(WalletLqtDetailUI.c(this.qil).tCf))
    {
      y.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", new Object[] { WalletLqtDetailUI.c(this.qil).tCf });
      e.l(this.qil, WalletLqtDetailUI.c(this.qil).tCf, false);
      return;
    }
    localObject = new Intent(this.qil, WalletLqtSaveFetchUI.class);
    if (WalletLqtDetailUI.c(this.qil) != null) {
      paramView = WalletLqtDetailUI.c(this.qil).tBg;
    }
    ((Intent)localObject).putExtra("lqt_save_fund_code", paramView);
    ((Intent)localObject).putExtra("lqt_save_fetch_mode", 1);
    if (WalletLqtDetailUI.c(this.qil).cdr == 1)
    {
      bool1 = true;
      ((Intent)localObject).putExtra("lqt_is_show_protocol", bool1);
      if (WalletLqtDetailUI.c(this.qil).tBZ != 1) {
        break label460;
      }
    }
    label460:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      ((Intent)localObject).putExtra("lqt_is_agree_protocol", bool1);
      ((Intent)localObject).putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.e(this.qil));
      ((Intent)localObject).putExtra("lqt_profile_wording", WalletLqtDetailUI.c(this.qil).tBT);
      ((Intent)localObject).putExtra("lqt_account_type", WalletLqtDetailUI.c(this.qil).sOy);
      ((Intent)localObject).putExtra("lqt_fund_spid", WalletLqtDetailUI.c(this.qil).tBi);
      this.qil.startActivity((Intent)localObject);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.2
 * JD-Core Version:    0.7.0.1
 */