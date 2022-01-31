package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

final class g$4
  extends a
{
  g$4(String paramString, a parama) {}
  
  public final void a(BaseWepkgProcessTask paramBaseWepkgProcessTask)
  {
    AppMethodBeat.i(63553);
    paramBaseWepkgProcessTask = this.nom;
    a locala = this.vGs;
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.vA = 3006;
    localWepkgCrossProcessTask.vGb.ezY = paramBaseWepkgProcessTask;
    localWepkgCrossProcessTask.vGb.vGR = false;
    if (ah.brt())
    {
      d.aNS().ac(new h.11(localWepkgCrossProcessTask, locala));
      AppMethodBeat.o(63553);
      return;
    }
    localWepkgCrossProcessTask.hxp = new h.12(locala, localWepkgCrossProcessTask);
    localWepkgCrossProcessTask.aBj();
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(63553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.g.4
 * JD-Core Version:    0.7.0.1
 */