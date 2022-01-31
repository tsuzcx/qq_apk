package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.Map;

final class WePkgDownloader$2
  implements a
{
  WePkgDownloader$2(WePkgDownloader paramWePkgDownloader) {}
  
  public final void a(g paramg)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(63432);
        d.dkx().akx(paramg.vER.vFr);
        if (paramg.mStatus == 1)
        {
          h.qsU.idkeyStat(859L, 2L, 1L, false);
          localObject1 = paramg.vER.mFilePath;
          if ((bo.isNullOrNil((String)localObject1)) || (!new File((String)localObject1).exists()))
          {
            ab.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, pkgPath is null or nil");
            localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.vFk;
            h.qsU.idkeyStat(859L, 4L, 1L, false);
            ab.i("MicroMsg.Wepkg.WepkgDownloader", "download callback retCode:".concat(String.valueOf(localObject1)));
            localObject2 = (WePkgDownloader.IWepkgUpdateCallback)WePkgDownloader.a(this.vFi).remove(paramg.vER.vFr);
            if (localObject2 != null)
            {
              ((WePkgDownloader.IWepkgUpdateCallback)localObject2).a(paramg.vER.vFs, paramg.vER.mFilePath, (WePkgDownloader.IWepkgUpdateCallback.RetCode)localObject1);
              if (paramg.vER.kYE != 1) {
                break label390;
              }
              localObject1 = paramg.vER.vFs;
              localObject2 = new WepkgCrossProcessTask();
              ((WepkgCrossProcessTask)localObject2).vA = 3008;
              ((WepkgCrossProcessTask)localObject2).vGb.ezY = ((String)localObject1);
              if (!ah.brt()) {
                break label382;
              }
              ((WepkgCrossProcessTask)localObject2).ata();
              WePkgDownloader.b(paramg);
              AppMethodBeat.o(63432);
            }
          }
          else
          {
            localObject2 = paramg.vER.hyD;
            localObject3 = com.tencent.mm.a.g.getMD5((String)localObject1);
            if (!bo.nullAsNil((String)localObject3).equalsIgnoreCase((String)localObject2))
            {
              ab.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, file.md5(%s) != net.md5(%s)", new Object[] { localObject3, localObject2 });
              e.deleteFile((String)localObject1);
              localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.vFl;
              paramg.lCs = 1012;
              h.qsU.idkeyStat(859L, 3L, 1L, false);
              continue;
            }
            localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.vFj;
            h.qsU.idkeyStat(859L, 5L, 1L, false);
            continue;
          }
        }
        else
        {
          h.qsU.idkeyStat(859L, 1L, 1L, false);
          localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.vFn;
          continue;
        }
        ab.i("MicroMsg.Wepkg.WepkgDownloader", "download callback invalid");
        com.tencent.mm.plugin.wepkg.utils.a.b("CallbackInvalid", paramg.vER.mUrl, paramg.vER.vFs, null, -1L, 0L, null);
        continue;
        WepkgMainProcessService.b((WepkgMainProcessTask)localObject2);
      }
      finally {}
      label382:
      continue;
      label390:
      Object localObject1 = paramg.vER.vFs;
      Object localObject2 = paramg.vER.vFt;
      Object localObject3 = new WepkgCrossProcessTask();
      ((WepkgCrossProcessTask)localObject3).vA = 4005;
      ((WepkgCrossProcessTask)localObject3).vGe.ezY = ((String)localObject1);
      ((WepkgCrossProcessTask)localObject3).vGe.vGh = ((String)localObject2);
      if (ah.brt()) {
        ((WepkgCrossProcessTask)localObject3).ata();
      } else {
        WepkgMainProcessService.b((WepkgMainProcessTask)localObject3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.2
 * JD-Core Version:    0.7.0.1
 */