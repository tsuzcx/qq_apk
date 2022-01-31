package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    Object localObject = new WepkgCrossProcessTask();
    ((WepkgCrossProcessTask)localObject).uC = 2005;
    if (ae.cqV()) {
      ((WepkgCrossProcessTask)localObject).Zu();
    }
    for (;;)
    {
      localObject = ((WepkgCrossProcessTask)localObject).rPk;
      if (bk.dk((List)localObject)) {
        break;
      }
      y.i("MicroMsg.Wepkg.CleanWepkgMgr", "need to clean list.size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WepkgVersion localWepkgVersion = (WepkgVersion)((Iterator)localObject).next();
        if (localWepkgVersion != null) {
          b.a(this.rOY, localWepkgVersion.dCD);
        }
      }
      WepkgMainProcessService.b((WepkgMainProcessTask)localObject);
    }
    y.i("MicroMsg.Wepkg.CleanWepkgMgr", "no need to clean wepkg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.b.1
 * JD-Core Version:    0.7.0.1
 */