package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.LinkedList;

final class WalletLqtDetailUI$10$1
  implements n.c
{
  WalletLqtDetailUI$10$1(WalletLqtDetailUI.10 param10) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(142291);
    if ((WalletLqtDetailUI.e(this.tPT.tPQ).xEn != null) && (WalletLqtDetailUI.e(this.tPT.tPQ).xEn.size() > 0))
    {
      Iterator localIterator = WalletLqtDetailUI.e(this.tPT.tPQ).xEn.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        bfx localbfx = (bfx)localIterator.next();
        if (!bo.isNullOrNil(localbfx.title)) {
          paraml.add(0, i, 0, localbfx.title);
        }
        i += 1;
      }
    }
    if (!WalletLqtDetailUI.e(this.tPT.tPQ).xEa) {
      paraml.add(0, -1, 0, 2131305187);
    }
    AppMethodBeat.o(142291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.10.1
 * JD-Core Version:    0.7.0.1
 */