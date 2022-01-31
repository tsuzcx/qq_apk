package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$15
  implements o.a
{
  c$15(c paramc, s.g paramg) {}
  
  public final void bqo()
  {
    if (this.mMg.mMb != null) {
      this.mMg.mMb.d(0, this.mMh.id, "", this.mMh.bOT);
    }
    g.ce(this.mMh.bOT, g.mJV);
    y.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.15
 * JD-Core Version:    0.7.0.1
 */