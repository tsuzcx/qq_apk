package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

final class aa$12
  implements Runnable
{
  aa$12(aa paramaa) {}
  
  public final void run()
  {
    AppMethodBeat.i(221394);
    if (!ba.ajx()) {
      ad.w("MicroMsg.UnreadCountHelper", "getAddrTabUnreadCount, but mmcore not ready");
    }
    for (int i = 0;; i = bt.n((Integer)com.tencent.mm.model.c.ajl().get(143618, null)))
    {
      if (this.Jdr.Jdk != null) {
        this.Jdr.Jdk.abt(i);
      }
      AppMethodBeat.o(221394);
      return;
      ba.aBQ();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221395);
    String str = super.toString() + "|setAddressTagUnread";
    AppMethodBeat.o(221395);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.aa.12
 * JD-Core Version:    0.7.0.1
 */