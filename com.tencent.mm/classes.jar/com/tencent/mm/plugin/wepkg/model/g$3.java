package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class g$3
  extends a
{
  g$3(g paramg, String paramString, List paramList, boolean paramBoolean) {}
  
  public final void a(BaseWepkgProcessTask paramBaseWepkgProcessTask)
  {
    if (((this.object instanceof WepkgPreloadFile)) && ((paramBaseWepkgProcessTask instanceof WepkgDownloadProcessTask)))
    {
      Object localObject2 = (WepkgDownloadProcessTask)paramBaseWepkgProcessTask;
      Object localObject1 = (WepkgPreloadFile)this.object;
      if ((((WepkgDownloadProcessTask)localObject2).rPr == WePkgDownloader.IWepkgUpdateCallback.RetCode.rOv) && (!bk.bl(((WepkgDownloadProcessTask)localObject2).fCl)))
      {
        paramBaseWepkgProcessTask = ((WepkgPreloadFile)localObject1).dCD;
        localObject1 = ((WepkgPreloadFile)localObject1).rPo;
        localObject2 = ((WepkgDownloadProcessTask)localObject2).fCl;
        WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
        localWepkgCrossProcessTask.uC = 4002;
        localWepkgCrossProcessTask.rPl.dCD = paramBaseWepkgProcessTask;
        localWepkgCrossProcessTask.rPl.rPo = ((String)localObject1);
        localWepkgCrossProcessTask.rPl.filePath = ((String)localObject2);
        localWepkgCrossProcessTask.rPl.rPD = true;
        if (ae.cqV()) {
          localWepkgCrossProcessTask.Zu();
        }
        for (;;)
        {
          boolean bool = localWepkgCrossProcessTask.bFQ;
          g.a(this.rPP, this.rOZ, this.rPR, this.rPO);
          return;
          WepkgMainProcessService.b(localWepkgCrossProcessTask);
        }
      }
      y.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", new Object[] { ((WepkgDownloadProcessTask)localObject2).rPr });
      g.a(this.rPP, this.rOZ, this.rPR, this.rPO);
      return;
    }
    y.i("MicroMsg.Wepkg.WepkgUpdater", "object instanceof  WepkgPreloadFile is false");
    g.a(this.rPP, this.rOZ, this.rPR, this.rPO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.g.3
 * JD-Core Version:    0.7.0.1
 */