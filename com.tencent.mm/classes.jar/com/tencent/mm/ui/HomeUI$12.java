package com.tencent.mm.ui;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

final class HomeUI$12
  implements Runnable
{
  HomeUI$12(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(33189);
    HomeUI.hGR();
    h localh = h.IzE;
    synchronized (localh.IzH)
    {
      Iterator localIterator = localh.IzH.iterator();
      if (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        localh.p(((Long)localPair.first).longValue(), ((Long)localPair.second).longValue(), 1L);
      }
    }
    Log.i("MicroMsg.ReportManagerKvCheck", "clear all pendding stat %d", new Object[] { Integer.valueOf(localObject.IzH.size()) });
    localObject.IzH.clear();
    AppMethodBeat.o(33189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.12
 * JD-Core Version:    0.7.0.1
 */