package com.tencent.mm.ui;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

final class HomeUI$11
  implements Runnable
{
  HomeUI$11(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(33189);
    HomeUI.jjc();
    h localh = h.OAn;
    synchronized (localh.OAq)
    {
      Iterator localIterator = localh.OAq.iterator();
      if (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        localh.p(((Long)localPair.first).longValue(), ((Long)localPair.second).longValue(), 1L);
      }
    }
    Log.i("MicroMsg.ReportManagerKvCheck", "clear all pendding stat %d", new Object[] { Integer.valueOf(localObject.OAq.size()) });
    localObject.OAq.clear();
    AppMethodBeat.o(33189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.11
 * JD-Core Version:    0.7.0.1
 */