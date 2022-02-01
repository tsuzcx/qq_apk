package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class p$7
  implements Runnable
{
  p$7(p paramp) {}
  
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
          a locala = new a();
          EventCenter.instance.publish(locala);
          AppMethodBeat.o(38728);
        }
      }, 100L);
    }
    g.Wm(8);
    AppMethodBeat.o(38729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.p.7
 * JD-Core Version:    0.7.0.1
 */