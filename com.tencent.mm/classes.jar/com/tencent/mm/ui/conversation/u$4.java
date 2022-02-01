package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class u$4
  implements Runnable
{
  u$4(u paramu) {}
  
  public final void run()
  {
    AppMethodBeat.i(38729);
    if (!MMApplicationContext.isAppHasInit())
    {
      MMApplicationContext.setAppHasInitFlag(true);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38728);
          Log.i("MicroMsg.RefreshHelper", "APPHasInitEvent begin");
          new b().publish();
          AppMethodBeat.o(38728);
        }
      }, 100L);
    }
    g.ahx(8);
    AppMethodBeat.o(38729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.u.4
 * JD-Core Version:    0.7.0.1
 */