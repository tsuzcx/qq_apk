package com.tencent.mm.ui;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class ab$3
  implements Runnable
{
  ab$3(ab paramab) {}
  
  public final void run()
  {
    AppMethodBeat.i(33493);
    long l = System.currentTimeMillis();
    final int i = com.tencent.mm.ui.conversation.h.gVB();
    com.tencent.f.h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(232648);
        ab localab = ab.3.this.OIv;
        int i = i;
        if (localab.OIo != null)
        {
          localab.OIo.akH(i);
          localab.OIn.gIa();
        }
        AppMethodBeat.o(232648);
      }
    });
    Log.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "unreadcheck setConversationTagUnread  last time %d, unread %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
    AppMethodBeat.o(33493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.ab.3
 * JD-Core Version:    0.7.0.1
 */