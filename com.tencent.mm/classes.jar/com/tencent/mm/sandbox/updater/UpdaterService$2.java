package com.tencent.mm.sandbox.updater;

import com.tencent.mm.pluginsdk.model.v.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

final class UpdaterService$2
  implements Runnable
{
  UpdaterService$2(UpdaterService paramUpdaterService) {}
  
  public final void run()
  {
    if (UpdaterService.b(this.udH).size() > 0)
    {
      Iterator localIterator = UpdaterService.b(this.udH).values().iterator();
      while (localIterator.hasNext()) {
        if (((a)localIterator.next()).isBusy())
        {
          y.i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
          return;
        }
      }
    }
    if (!v.a.ckG())
    {
      this.udH.stopSelf();
      return;
    }
    y.i("TBSDownloadMgr", "is still busy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.UpdaterService.2
 * JD-Core Version:    0.7.0.1
 */