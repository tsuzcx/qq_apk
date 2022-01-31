package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class c$3$1
  implements Runnable
{
  c$3$1(c.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(141557);
    Object localObject = new WepkgCrossProcessTask();
    ((WepkgCrossProcessTask)localObject).vA = 2003;
    if (ah.brt()) {
      ((WepkgCrossProcessTask)localObject).ata();
    }
    for (;;)
    {
      localObject = ((WepkgCrossProcessTask)localObject).vGb;
      if ((localObject != null) && (!bo.isNullOrNil(((WepkgVersion)localObject).ezY))) {
        i.dkE().bX(((WepkgVersion)localObject).ezY, true);
      }
      AppMethodBeat.o(141557);
      return;
      WepkgMainProcessService.b((WepkgMainProcessTask)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c.3.1
 * JD-Core Version:    0.7.0.1
 */