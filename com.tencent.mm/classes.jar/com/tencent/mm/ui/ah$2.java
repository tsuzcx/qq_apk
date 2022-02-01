package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.conversation.j;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

final class ah$2
  implements Runnable
{
  ah$2(ah paramah) {}
  
  public final void run()
  {
    AppMethodBeat.i(33493);
    long l = System.currentTimeMillis();
    final int i = j.jAf();
    h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249546);
        ah localah = ah.2.this.adHs;
        int i = i;
        if (localah.adHj != null)
        {
          localah.adHj.azS(i);
          localah.adHh.jiV();
        }
        AppMethodBeat.o(249546);
      }
    });
    Log.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "unreadcheck setConversationTagUnread  last time %d, unread %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
    AppMethodBeat.o(33493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.ah.2
 * JD-Core Version:    0.7.0.1
 */