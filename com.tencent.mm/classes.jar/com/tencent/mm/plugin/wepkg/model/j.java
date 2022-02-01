package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public class j
{
  private static volatile j Dbx = null;
  
  private static void D(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(110754);
    if (paramBoolean)
    {
      ys localys = new ys();
      localys.dCz.cZu = 0;
      com.tencent.mm.sdk.b.a.GpY.l(localys);
    }
    i.aFw(paramString);
    c.eJd().az(paramString, 3, 6);
    AppMethodBeat.o(110754);
  }
  
  private void c(final String paramString, final List<WepkgPreloadFile> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(110753);
    for (;;)
    {
      try
      {
        if (!bs.gY(paramList)) {
          break label265;
        }
        ac.i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
        if (bs.isNullOrNil(paramString))
        {
          D(paramBoolean, paramString);
          AppMethodBeat.o(110753);
          return;
        }
        paramList = i.aFt(paramString);
        if (!bs.gY(paramList)) {
          break;
        }
        paramList = new WepkgCrossProcessTask();
        paramList.CW = 3006;
        paramList.DaU.fYR = paramString;
        paramList.DaU.DbK = true;
        if (ai.ciE())
        {
          paramList.aLq();
          paramList = i.aFr(paramString);
          if ((paramList != null) && (paramList.createTime != 0L))
          {
            com.tencent.mm.plugin.wepkg.utils.a.b("downloadCompleteTime", "", paramList.fYR, paramList.version, -1L, System.currentTimeMillis() - paramList.createTime * 1000L, null);
            paramList = new WepkgCrossProcessTask();
            paramList.CW = 3007;
            paramList.DaU.fYR = paramString;
            if (!ai.ciE()) {
              break label223;
            }
            paramList.aLq();
          }
          D(paramBoolean, paramString);
          ac.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:true");
          AppMethodBeat.o(110753);
          return;
        }
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.Wepkg.WepkgUpdater", "loopDownload err:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(110753);
        return;
      }
      AppBrandMainProcessService.b(paramList);
      continue;
      label223:
      AppBrandMainProcessService.b(paramList);
    }
    ac.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", new Object[] { Integer.valueOf(paramList.size()) });
    D(paramBoolean, paramString);
    AppMethodBeat.o(110753);
    return;
    label265:
    WepkgPreloadFile localWepkgPreloadFile = (WepkgPreloadFile)paramList.remove(0);
    if (localWepkgPreloadFile != null)
    {
      ac.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", new Object[] { localWepkgPreloadFile.fYR, localWepkgPreloadFile.version, localWepkgPreloadFile.Dba });
      paramString = new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110750);
          if (((this.object instanceof WepkgPreloadFile)) && ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask)))
          {
            Object localObject2 = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            Object localObject1 = (WepkgPreloadFile)this.object;
            if ((((WepkgDownloadProcessTask)localObject2).Dbc == WePkgDownloader.IWepkgUpdateCallback.RetCode.Dad) && (!bs.isNullOrNil(((WepkgDownloadProcessTask)localObject2).pkgPath)))
            {
              paramAnonymousBaseWepkgProcessTask = ((WepkgPreloadFile)localObject1).fYR;
              localObject1 = ((WepkgPreloadFile)localObject1).Dba;
              localObject2 = ((WepkgDownloadProcessTask)localObject2).pkgPath;
              WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
              localWepkgCrossProcessTask.CW = 4002;
              localWepkgCrossProcessTask.DaX.fYR = paramAnonymousBaseWepkgProcessTask;
              localWepkgCrossProcessTask.DaX.Dba = ((String)localObject1);
              localWepkgCrossProcessTask.DaX.filePath = ((String)localObject2);
              localWepkgCrossProcessTask.DaX.Dbn = true;
              if (ai.ciE()) {
                localWepkgCrossProcessTask.aLq();
              }
              for (;;)
              {
                j.a(j.this, paramString, paramList, paramBoolean);
                AppMethodBeat.o(110750);
                return;
                AppBrandMainProcessService.b(localWepkgCrossProcessTask);
              }
            }
            ac.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", new Object[] { ((WepkgDownloadProcessTask)localObject2).Dbc });
            j.a(j.this, paramString, paramList, paramBoolean);
            AppMethodBeat.o(110750);
            return;
          }
          ac.i("MicroMsg.Wepkg.WepkgUpdater", "object instanceof  WepkgPreloadFile is false");
          j.a(j.this, paramString, paramList, paramBoolean);
          AppMethodBeat.o(110750);
        }
      };
      paramString.object = localWepkgPreloadFile;
      i.a(2, localWepkgPreloadFile.fYR, localWepkgPreloadFile.Dba, localWepkgPreloadFile.downloadUrl, localWepkgPreloadFile.size, localWepkgPreloadFile.version, localWepkgPreloadFile.md5, localWepkgPreloadFile.DaM, paramString);
      AppMethodBeat.o(110753);
      return;
    }
    ac.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
    c(paramString, paramList, paramBoolean);
    AppMethodBeat.o(110753);
  }
  
  public static j eJi()
  {
    AppMethodBeat.i(110751);
    if (Dbx == null) {}
    try
    {
      if (Dbx == null) {
        Dbx = new j();
      }
      j localj = Dbx;
      AppMethodBeat.o(110751);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(110751);
    }
  }
  
  public final void cs(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(110752);
    if (bs.isNullOrNil(paramString))
    {
      D(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    final a local1 = new a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
      {
        AppMethodBeat.i(110748);
        if ((this.object instanceof String))
        {
          String str = (String)this.object;
          boolean bool2 = paramAnonymousBaseWepkgProcessTask.result;
          if (!paramAnonymousBaseWepkgProcessTask.DaE) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            j.j(str, bool2, bool1);
            j.a(j.this, str, paramBoolean);
            AppMethodBeat.o(110748);
            return;
          }
        }
        j.E(paramBoolean, paramString);
        AppMethodBeat.o(110748);
      }
    };
    local1.object = paramString;
    ac.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (bs.isNullOrNil(paramString))
    {
      D(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    ac.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    WepkgVersion localWepkgVersion = i.aFr(paramString);
    if (localWepkgVersion == null)
    {
      D(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    if (!localWepkgVersion.DbJ)
    {
      i.a(1, localWepkgVersion.fYR, "", localWepkgVersion.downloadUrl, localWepkgVersion.DbH, localWepkgVersion.version, localWepkgVersion.md5, localWepkgVersion.DaM, new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110749);
          if ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask))
          {
            paramAnonymousBaseWepkgProcessTask = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            if ((paramAnonymousBaseWepkgProcessTask.Dbc == WePkgDownloader.IWepkgUpdateCallback.RetCode.Dad) && (!bs.isNullOrNil(paramAnonymousBaseWepkgProcessTask.dCA)) && (!bs.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)))
            {
              i.a(paramAnonymousBaseWepkgProcessTask.dCA, paramAnonymousBaseWepkgProcessTask.pkgPath, true, local1);
              AppMethodBeat.o(110749);
              return;
            }
            if (local1 != null)
            {
              paramAnonymousBaseWepkgProcessTask = new WepkgCrossProcessTask();
              paramAnonymousBaseWepkgProcessTask.result = false;
              local1.a(paramAnonymousBaseWepkgProcessTask);
            }
            j.E(paramBoolean, paramString);
            AppMethodBeat.o(110749);
            return;
          }
          j.E(paramBoolean, paramString);
          AppMethodBeat.o(110749);
        }
      });
      AppMethodBeat.o(110752);
      return;
    }
    paramString = new WepkgCrossProcessTask();
    paramString.result = true;
    paramString.DaE = true;
    local1.a(paramString);
    AppMethodBeat.o(110752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.j
 * JD-Core Version:    0.7.0.1
 */