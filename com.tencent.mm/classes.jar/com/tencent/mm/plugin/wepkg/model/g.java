package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.h.a.un;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public class g
{
  private static volatile g rPN = null;
  
  private void a(String paramString, List<WepkgPreloadFile> paramList, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (!bk.dk(paramList)) {
          break label240;
        }
        y.i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
        if (bk.bl(paramString))
        {
          p(paramBoolean, paramString);
          return;
        }
        paramList = f.Vl(paramString);
        if (!bk.dk(paramList)) {
          break;
        }
        paramList = new WepkgCrossProcessTask();
        paramList.uC = 3006;
        paramList.rPj.dCD = paramString;
        paramList.rPj.rPZ = true;
        if (ae.cqV())
        {
          paramList.Zu();
          paramList = f.Vj(paramString);
          if ((paramList != null) && (paramList.createTime != 0L))
          {
            com.tencent.mm.plugin.wepkg.utils.a.b("downloadCompleteTime", "", paramList.dCD, paramList.version, -1L, System.currentTimeMillis() - paramList.createTime * 1000L, null);
            paramList = new WepkgCrossProcessTask();
            paramList.uC = 3007;
            paramList.rPj.dCD = paramString;
            if (!ae.cqV()) {
              break label203;
            }
            paramList.Zu();
          }
          p(paramBoolean, paramString);
          y.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:true");
          return;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.Wepkg.WepkgUpdater", "loopDownload err:%s", new Object[] { paramString.getMessage() });
        return;
      }
      WepkgMainProcessService.b(paramList);
      continue;
      label203:
      WepkgMainProcessService.b(paramList);
    }
    y.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", new Object[] { Integer.valueOf(paramList.size()) });
    p(paramBoolean, paramString);
    return;
    label240:
    WepkgPreloadFile localWepkgPreloadFile = (WepkgPreloadFile)paramList.remove(0);
    if (localWepkgPreloadFile != null)
    {
      y.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", new Object[] { localWepkgPreloadFile.dCD, localWepkgPreloadFile.version, localWepkgPreloadFile.rPo });
      paramString = new g.3(this, paramString, paramList, paramBoolean);
      paramString.object = localWepkgPreloadFile;
      f.a(2, localWepkgPreloadFile.dCD, localWepkgPreloadFile.rPo, localWepkgPreloadFile.downloadUrl, localWepkgPreloadFile.size, localWepkgPreloadFile.version, localWepkgPreloadFile.bIW, localWepkgPreloadFile.rPq, paramString);
      return;
    }
    y.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
    a(paramString, paramList, paramBoolean);
  }
  
  public static g cka()
  {
    if (rPN == null) {}
    try
    {
      if (rPN == null) {
        rPN = new g();
      }
      return rPN;
    }
    finally {}
  }
  
  private static void p(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      localObject = new un();
      ((un)localObject).cfh.bHz = 0;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject);
    }
    Object localObject = new WepkgCrossProcessTask();
    ((WepkgCrossProcessTask)localObject).uC = 2006;
    ((WepkgCrossProcessTask)localObject).rPj.dCD = paramString;
    if (ae.cqV()) {
      ((WepkgCrossProcessTask)localObject).Zu();
    }
    for (;;)
    {
      e.Vg(paramString);
      return;
      WepkgMainProcessService.b((WepkgMainProcessTask)localObject);
    }
  }
  
  public final void bw(String paramString, boolean paramBoolean)
  {
    if (bk.bl(paramString))
    {
      p(paramBoolean, paramString);
      return;
    }
    g.1 local1 = new g.1(this, paramBoolean, paramString);
    local1.object = paramString;
    y.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (bk.bl(paramString))
    {
      p(paramBoolean, paramString);
      return;
    }
    y.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    WepkgVersion localWepkgVersion = f.Vj(paramString);
    if (localWepkgVersion == null)
    {
      p(paramBoolean, paramString);
      return;
    }
    if (!localWepkgVersion.rPY)
    {
      f.a(1, localWepkgVersion.dCD, "", localWepkgVersion.downloadUrl, localWepkgVersion.rPW, localWepkgVersion.version, localWepkgVersion.bIW, localWepkgVersion.rPq, new g.2(this, local1, paramBoolean, paramString));
      return;
    }
    local1.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.g
 * JD-Core Version:    0.7.0.1
 */