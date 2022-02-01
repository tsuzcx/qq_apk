package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

final class ab$4
  implements Runnable
{
  ab$4(ab paramab) {}
  
  public final void run()
  {
    AppMethodBeat.i(232649);
    if (!bg.aAc()) {
      Log.w("MicroMsg.UnreadCountHelper", "getAddrTabUnreadCount, but mmcore not ready");
    }
    for (int i = 0;; i = Util.nullAsNil((Integer)com.tencent.mm.model.c.azQ().get(143618, null)))
    {
      if (ab.a(this.OIv) != null) {
        ab.a(this.OIv).akI(i);
      }
      AppMethodBeat.o(232649);
      return;
      bg.aVF();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(232650);
    String str = super.toString() + "|setAddressTagUnread";
    AppMethodBeat.o(232650);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.ab.4
 * JD-Core Version:    0.7.0.1
 */