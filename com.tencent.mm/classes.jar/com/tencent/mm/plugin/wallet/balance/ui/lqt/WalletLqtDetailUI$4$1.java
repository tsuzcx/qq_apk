package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bhm;
import com.tencent.mm.protocal.c.uc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.LinkedList;

final class WalletLqtDetailUI$4$1
  implements n.c
{
  WalletLqtDetailUI$4$1(WalletLqtDetailUI.4 param4) {}
  
  public final void a(l paraml)
  {
    if ((WalletLqtDetailUI.c(this.qim.qil).tCc != null) && (WalletLqtDetailUI.c(this.qim.qil).tCc.size() > 0))
    {
      Iterator localIterator = WalletLqtDetailUI.c(this.qim.qil).tCc.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        uc localuc = (uc)localIterator.next();
        if ((!bk.bl(localuc.title)) && (!bk.bl(localuc.sQT))) {
          paraml.add(0, i, 0, localuc.title);
        }
        i += 1;
      }
    }
    if (!WalletLqtDetailUI.c(this.qim.qil).tCj) {
      paraml.add(0, -1, 0, a.i.wallet_lqt_close_account);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.4.1
 * JD-Core Version:    0.7.0.1
 */