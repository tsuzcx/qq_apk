package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class i$3
  extends a
{
  i$3(i parami, String paramString, List paramList, boolean paramBoolean) {}
  
  public final void a(BaseWepkgProcessTask paramBaseWepkgProcessTask)
  {
    AppMethodBeat.i(63592);
    if (((this.object instanceof WepkgPreloadFile)) && ((paramBaseWepkgProcessTask instanceof WepkgDownloadProcessTask)))
    {
      Object localObject2 = (WepkgDownloadProcessTask)paramBaseWepkgProcessTask;
      Object localObject1 = (WepkgPreloadFile)this.object;
      if ((((WepkgDownloadProcessTask)localObject2).vGj == WePkgDownloader.IWepkgUpdateCallback.RetCode.vFj) && (!bo.isNullOrNil(((WepkgDownloadProcessTask)localObject2).gUy)))
      {
        paramBaseWepkgProcessTask = ((WepkgPreloadFile)localObject1).ezY;
        localObject1 = ((WepkgPreloadFile)localObject1).vGh;
        localObject2 = ((WepkgDownloadProcessTask)localObject2).gUy;
        WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
        localWepkgCrossProcessTask.vA = 4002;
        localWepkgCrossProcessTask.vGe.ezY = paramBaseWepkgProcessTask;
        localWepkgCrossProcessTask.vGe.vGh = ((String)localObject1);
        localWepkgCrossProcessTask.vGe.filePath = ((String)localObject2);
        localWepkgCrossProcessTask.vGe.vGu = true;
        if (ah.brt()) {
          localWepkgCrossProcessTask.ata();
        }
        for (;;)
        {
          i.a(this.vGG, this.nom, this.vGI, this.vGF);
          AppMethodBeat.o(63592);
          return;
          WepkgMainProcessService.b(localWepkgCrossProcessTask);
        }
      }
      ab.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", new Object[] { ((WepkgDownloadProcessTask)localObject2).vGj });
      i.a(this.vGG, this.nom, this.vGI, this.vGF);
      AppMethodBeat.o(63592);
      return;
    }
    ab.i("MicroMsg.Wepkg.WepkgUpdater", "object instanceof  WepkgPreloadFile is false");
    i.a(this.vGG, this.nom, this.vGI, this.vGF);
    AppMethodBeat.o(63592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.i.3
 * JD-Core Version:    0.7.0.1
 */