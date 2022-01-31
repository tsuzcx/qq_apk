package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.wallet.balance.a.a.ac;
import com.tencent.mm.plugin.wallet.balance.a.a.r;
import com.tencent.mm.plugin.wallet.balance.a.a.r.c;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$6
  implements View.OnClickListener
{
  WalletLqtDetailUI$6(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(45527);
    if (ae.glG)
    {
      Intent localIntent = new Intent(this.tPQ, WalletLqtSaveFetchUI.class);
      if (WalletLqtDetailUI.e(this.tPQ) != null)
      {
        paramView = WalletLqtDetailUI.e(this.tPQ).xCP;
        localIntent.putExtra("lqt_save_fund_code", paramView);
        localIntent.putExtra("lqt_save_fetch_mode", 1);
        if (WalletLqtDetailUI.e(this.tPQ).cMb != 1) {
          break label170;
        }
        bool1 = true;
        label83:
        localIntent.putExtra("lqt_is_show_protocol", bool1);
        if (WalletLqtDetailUI.e(this.tPQ).xDQ != 1) {
          break label175;
        }
      }
      label170:
      label175:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localIntent.putExtra("lqt_is_agree_protocol", bool1);
        localIntent.putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.g(this.tPQ));
        localIntent.putExtra("lqt_profile_wording", WalletLqtDetailUI.e(this.tPQ).xDJ);
        this.tPQ.startActivity(localIntent);
        AppMethodBeat.o(45527);
        return;
        paramView = null;
        break;
        bool1 = false;
        break label83;
      }
    }
    if ((WalletLqtDetailUI.e(this.tPQ).xEi != null) && (WalletLqtDetailUI.e(this.tPQ).xEi.xoA) && (WalletLqtDetailUI.e(this.tPQ).xwr != null))
    {
      ac.a(this.tPQ.getContext(), WalletLqtDetailUI.e(this.tPQ).xwr);
      AppMethodBeat.o(45527);
      return;
    }
    WalletLqtDetailUI.h(this.tPQ).tMJ.gu(WalletLqtDetailUI.e(this.tPQ).wMx, 1);
    if (!bo.isNullOrNil(WalletLqtDetailUI.e(this.tPQ).xDW))
    {
      ab.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", new Object[] { WalletLqtDetailUI.e(this.tPQ).xDW });
      e.m(this.tPQ, WalletLqtDetailUI.e(this.tPQ).xDW, false);
      AppMethodBeat.o(45527);
      return;
    }
    WalletLqtDetailUI.a(this.tPQ, true, WalletLqtDetailUI.e(this.tPQ).xEi);
    AppMethodBeat.o(45527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.6
 * JD-Core Version:    0.7.0.1
 */