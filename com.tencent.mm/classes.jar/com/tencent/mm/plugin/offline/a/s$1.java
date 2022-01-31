package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;

final class s$1
  implements Runnable
{
  s$1(s params) {}
  
  public final void run()
  {
    y.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
    g.DQ();
    g.DO().dJT.a(new b(this.mLA), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.s.1
 * JD-Core Version:    0.7.0.1
 */