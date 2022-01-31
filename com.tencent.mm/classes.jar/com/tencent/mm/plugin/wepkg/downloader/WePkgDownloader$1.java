package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.Map;

final class WePkgDownloader$1
  implements a
{
  WePkgDownloader$1(WePkgDownloader paramWePkgDownloader) {}
  
  public final void a(g paramg)
  {
    for (;;)
    {
      try
      {
        d.cjS().Vc(paramg.rOg.rOD);
        if (paramg.mStatus == 1)
        {
          h.nFQ.a(859L, 2L, 1L, false);
          localObject1 = paramg.rOg.mFilePath;
          if ((bk.bl((String)localObject1)) || (!new File((String)localObject1).exists()))
          {
            y.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, pkgPath is null or nil");
            localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.rOw;
            h.nFQ.a(859L, 4L, 1L, false);
            y.i("MicroMsg.Wepkg.WepkgDownloader", "download callback retCode:" + localObject1);
            localObject2 = (WePkgDownloader.IWepkgUpdateCallback)WePkgDownloader.a(this.rOu).remove(paramg.rOg.rOD);
            if (localObject2 != null)
            {
              ((WePkgDownloader.IWepkgUpdateCallback)localObject2).a(paramg.rOg.rOE, paramg.rOg.mFilePath, (WePkgDownloader.IWepkgUpdateCallback.RetCode)localObject1);
              if (paramg.rOg.iPx != 1) {
                break label387;
              }
              localObject1 = paramg.rOg.rOE;
              localObject2 = new WepkgCrossProcessTask();
              ((WepkgCrossProcessTask)localObject2).uC = 3008;
              ((WepkgCrossProcessTask)localObject2).rPj.dCD = ((String)localObject1);
              if (!ae.cqV()) {
                break label379;
              }
              ((WepkgCrossProcessTask)localObject2).Zu();
              WePkgDownloader.b(paramg);
            }
          }
          else
          {
            localObject2 = paramg.rOg.ghQ;
            localObject3 = com.tencent.mm.a.g.bQ((String)localObject1);
            if (!bk.pm((String)localObject3).equalsIgnoreCase((String)localObject2))
            {
              y.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, file.md5(%s) != net.md5(%s)", new Object[] { localObject3, localObject2 });
              e.deleteFile((String)localObject1);
              localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.rOx;
              paramg.jsT = 1012;
              h.nFQ.a(859L, 3L, 1L, false);
              continue;
            }
            localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.rOv;
            h.nFQ.a(859L, 5L, 1L, false);
            continue;
          }
        }
        else
        {
          h.nFQ.a(859L, 1L, 1L, false);
          localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.rOz;
          continue;
        }
        y.i("MicroMsg.Wepkg.WepkgDownloader", "download callback invalid");
        com.tencent.mm.plugin.wepkg.utils.a.b("CallbackInvalid", paramg.rOg.mUrl, paramg.rOg.rOE, null, -1L, 0L, null);
        continue;
        WepkgMainProcessService.b((WepkgMainProcessTask)localObject2);
      }
      finally {}
      label379:
      continue;
      label387:
      Object localObject1 = paramg.rOg.rOE;
      Object localObject2 = paramg.rOg.rOF;
      Object localObject3 = new WepkgCrossProcessTask();
      ((WepkgCrossProcessTask)localObject3).uC = 4005;
      ((WepkgCrossProcessTask)localObject3).rPl.dCD = ((String)localObject1);
      ((WepkgCrossProcessTask)localObject3).rPl.rPo = ((String)localObject2);
      if (ae.cqV()) {
        ((WepkgCrossProcessTask)localObject3).Zu();
      } else {
        WepkgMainProcessService.b((WepkgMainProcessTask)localObject3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.1
 * JD-Core Version:    0.7.0.1
 */