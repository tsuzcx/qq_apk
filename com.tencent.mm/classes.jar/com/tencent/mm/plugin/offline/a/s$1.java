package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

final class s$1
  implements Runnable
{
  s$1(s params) {}
  
  public final void run()
  {
    AppMethodBeat.i(43421);
    ab.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
    g.RM();
    g.RK().eHt.a(new b(this.plR), 0);
    AppMethodBeat.o(43421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.s.1
 * JD-Core Version:    0.7.0.1
 */