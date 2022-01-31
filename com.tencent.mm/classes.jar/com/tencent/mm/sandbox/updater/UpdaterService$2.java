package com.tencent.mm.sandbox.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class UpdaterService$2
  implements Runnable
{
  UpdaterService$2(UpdaterService paramUpdaterService) {}
  
  public final void run()
  {
    AppMethodBeat.i(28985);
    if (UpdaterService.b(this.ylW).size() > 0)
    {
      Iterator localIterator = UpdaterService.b(this.ylW).values().iterator();
      while (localIterator.hasNext()) {
        if (((a)localIterator.next()).isBusy())
        {
          ab.i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
          AppMethodBeat.o(28985);
          return;
        }
      }
    }
    if (!u.a.dlo())
    {
      this.ylW.stopSelf();
      AppMethodBeat.o(28985);
      return;
    }
    ab.i("TBSDownloadMgr", "is still busy");
    AppMethodBeat.o(28985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.UpdaterService.2
 * JD-Core Version:    0.7.0.1
 */