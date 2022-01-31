package com.tencent.mm.plugin.offline.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.sdk.platformtools.ab;

final class c$15
  implements q.a
{
  c$15(c paramc, s.g paramg) {}
  
  public final void bYU()
  {
    AppMethodBeat.i(43485);
    if (this.pmw.pmr != null) {
      this.pmw.pmr.e(0, this.pmx.id, "", this.pmx.cwk);
    }
    g.cW(this.pmx.cwk, g.pkk);
    ab.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
    AppMethodBeat.o(43485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.15
 * JD-Core Version:    0.7.0.1
 */