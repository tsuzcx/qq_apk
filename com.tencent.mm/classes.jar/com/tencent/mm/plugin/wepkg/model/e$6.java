package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;

final class e$6
  extends a
{
  e$6(String paramString, a parama) {}
  
  public final void a(BaseWepkgProcessTask paramBaseWepkgProcessTask)
  {
    paramBaseWepkgProcessTask = this.rOZ;
    a locala = this.rPB;
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.uC = 3006;
    localWepkgCrossProcessTask.rPj.dCD = paramBaseWepkgProcessTask;
    localWepkgCrossProcessTask.rPj.rPZ = false;
    if (ae.cqV())
    {
      d.DS().O(new f.12(localWepkgCrossProcessTask, locala));
      return;
    }
    localWepkgCrossProcessTask.gfD = new f.13(locala, localWepkgCrossProcessTask);
    localWepkgCrossProcessTask.ahC();
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.e.6
 * JD-Core Version:    0.7.0.1
 */