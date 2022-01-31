package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

final class c$2$1
  implements Runnable
{
  c$2$1(c.2 param2) {}
  
  public final void run()
  {
    Object localObject = new WepkgCrossProcessTask();
    ((WepkgCrossProcessTask)localObject).uC = 2003;
    if (ae.cqV()) {
      ((WepkgCrossProcessTask)localObject).Zu();
    }
    for (;;)
    {
      localObject = ((WepkgCrossProcessTask)localObject).rPj;
      if ((localObject != null) && (!bk.bl(((WepkgVersion)localObject).dCD))) {
        g.cka().bw(((WepkgVersion)localObject).dCD, true);
      }
      return;
      WepkgMainProcessService.b((WepkgMainProcessTask)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c.2.1
 * JD-Core Version:    0.7.0.1
 */