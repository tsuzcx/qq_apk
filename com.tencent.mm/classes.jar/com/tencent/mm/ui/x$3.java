package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

final class x$3
  implements Runnable
{
  x$3(x paramx) {}
  
  public final void run()
  {
    AppMethodBeat.i(29657);
    if (!aw.RG()) {
      ab.w("MicroMsg.UnreadCountHelper", "getAddrTabUnreadCount, but mmcore not ready");
    }
    for (int i = 0;; i = ah.g((Integer)com.tencent.mm.model.c.Ru().get(143618, null)))
    {
      if (this.zcS.zcL != null) {
        this.zcS.zcL.NV(i);
      }
      AppMethodBeat.o(29657);
      return;
      aw.aaz();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29658);
    String str = super.toString() + "|setAddressTagUnread";
    AppMethodBeat.o(29658);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.x.3
 * JD-Core Version:    0.7.0.1
 */