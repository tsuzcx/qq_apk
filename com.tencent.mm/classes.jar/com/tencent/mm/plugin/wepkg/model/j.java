package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zm;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public class j
{
  private static volatile j EFw = null;
  
  private static void I(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(110754);
    if (paramBoolean)
    {
      zm localzm = new zm();
      localzm.dOM.dkM = 0;
      com.tencent.mm.sdk.b.a.IbL.l(localzm);
    }
    i.aKW(paramString);
    c.eXW().aD(paramString, 3, 6);
    AppMethodBeat.o(110754);
  }
  
  private void c(final String paramString, final List<WepkgPreloadFile> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(110753);
    for (;;)
    {
      try
      {
        if (!bt.hj(paramList)) {
          break label265;
        }
        ad.i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
        if (bt.isNullOrNil(paramString))
        {
          I(paramBoolean, paramString);
          AppMethodBeat.o(110753);
          return;
        }
        paramList = i.aKT(paramString);
        if (!bt.hj(paramList)) {
          break;
        }
        paramList = new WepkgCrossProcessTask();
        paramList.EN = 3006;
        paramList.EET.gsn = paramString;
        paramList.EET.EFJ = true;
        if (aj.cnC())
        {
          paramList.aOA();
          paramList = i.aKR(paramString);
          if ((paramList != null) && (paramList.createTime != 0L))
          {
            com.tencent.mm.plugin.wepkg.utils.a.b("downloadCompleteTime", "", paramList.gsn, paramList.version, -1L, System.currentTimeMillis() - paramList.createTime * 1000L, null);
            paramList = new WepkgCrossProcessTask();
            paramList.EN = 3007;
            paramList.EET.gsn = paramString;
            if (!aj.cnC()) {
              break label223;
            }
            paramList.aOA();
          }
          I(paramBoolean, paramString);
          ad.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:true");
          AppMethodBeat.o(110753);
          return;
        }
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.Wepkg.WepkgUpdater", "loopDownload err:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(110753);
        return;
      }
      AppBrandMainProcessService.b(paramList);
      continue;
      label223:
      AppBrandMainProcessService.b(paramList);
    }
    ad.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", new Object[] { Integer.valueOf(paramList.size()) });
    I(paramBoolean, paramString);
    AppMethodBeat.o(110753);
    return;
    label265:
    WepkgPreloadFile localWepkgPreloadFile = (WepkgPreloadFile)paramList.remove(0);
    if (localWepkgPreloadFile != null)
    {
      ad.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", new Object[] { localWepkgPreloadFile.gsn, localWepkgPreloadFile.version, localWepkgPreloadFile.EEZ });
      paramString = new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110750);
          if (((this.object instanceof WepkgPreloadFile)) && ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask)))
          {
            Object localObject2 = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            Object localObject1 = (WepkgPreloadFile)this.object;
            if ((((WepkgDownloadProcessTask)localObject2).EFb == WePkgDownloader.IWepkgUpdateCallback.RetCode.EEc) && (!bt.isNullOrNil(((WepkgDownloadProcessTask)localObject2).pkgPath)))
            {
              paramAnonymousBaseWepkgProcessTask = ((WepkgPreloadFile)localObject1).gsn;
              localObject1 = ((WepkgPreloadFile)localObject1).EEZ;
              localObject2 = ((WepkgDownloadProcessTask)localObject2).pkgPath;
              WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
              localWepkgCrossProcessTask.EN = 4002;
              localWepkgCrossProcessTask.EEW.gsn = paramAnonymousBaseWepkgProcessTask;
              localWepkgCrossProcessTask.EEW.EEZ = ((String)localObject1);
              localWepkgCrossProcessTask.EEW.filePath = ((String)localObject2);
              localWepkgCrossProcessTask.EEW.EFm = true;
              if (aj.cnC()) {
                localWepkgCrossProcessTask.aOA();
              }
              for (;;)
              {
                j.a(j.this, paramString, paramList, paramBoolean);
                AppMethodBeat.o(110750);
                return;
                AppBrandMainProcessService.b(localWepkgCrossProcessTask);
              }
            }
            ad.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", new Object[] { ((WepkgDownloadProcessTask)localObject2).EFb });
            j.a(j.this, paramString, paramList, paramBoolean);
            AppMethodBeat.o(110750);
            return;
          }
          ad.i("MicroMsg.Wepkg.WepkgUpdater", "object instanceof  WepkgPreloadFile is false");
          j.a(j.this, paramString, paramList, paramBoolean);
          AppMethodBeat.o(110750);
        }
      };
      paramString.object = localWepkgPreloadFile;
      i.a(2, localWepkgPreloadFile.gsn, localWepkgPreloadFile.EEZ, localWepkgPreloadFile.downloadUrl, localWepkgPreloadFile.size, localWepkgPreloadFile.version, localWepkgPreloadFile.md5, localWepkgPreloadFile.EEL, paramString);
      AppMethodBeat.o(110753);
      return;
    }
    ad.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
    c(paramString, paramList, paramBoolean);
    AppMethodBeat.o(110753);
  }
  
  public static j eYc()
  {
    AppMethodBeat.i(110751);
    if (EFw == null) {}
    try
    {
      if (EFw == null) {
        EFw = new j();
      }
      j localj = EFw;
      AppMethodBeat.o(110751);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(110751);
    }
  }
  
  public final void cx(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(110752);
    if (bt.isNullOrNil(paramString))
    {
      I(paramBoolean, paramString);
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
          if (!paramAnonymousBaseWepkgProcessTask.EED) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            j.l(str, bool2, bool1);
            j.a(j.this, str, paramBoolean);
            AppMethodBeat.o(110748);
            return;
          }
        }
        j.J(paramBoolean, paramString);
        AppMethodBeat.o(110748);
      }
    };
    local1.object = paramString;
    ad.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (bt.isNullOrNil(paramString))
    {
      I(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    ad.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    WepkgVersion localWepkgVersion = i.aKR(paramString);
    if (localWepkgVersion == null)
    {
      I(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    if (!localWepkgVersion.EFI)
    {
      i.a(1, localWepkgVersion.gsn, "", localWepkgVersion.downloadUrl, localWepkgVersion.EFG, localWepkgVersion.version, localWepkgVersion.md5, localWepkgVersion.EEL, new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110749);
          if ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask))
          {
            paramAnonymousBaseWepkgProcessTask = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            if ((paramAnonymousBaseWepkgProcessTask.EFb == WePkgDownloader.IWepkgUpdateCallback.RetCode.EEc) && (!bt.isNullOrNil(paramAnonymousBaseWepkgProcessTask.dON)) && (!bt.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)))
            {
              i.a(paramAnonymousBaseWepkgProcessTask.dON, paramAnonymousBaseWepkgProcessTask.pkgPath, true, local1);
              AppMethodBeat.o(110749);
              return;
            }
            if (local1 != null)
            {
              paramAnonymousBaseWepkgProcessTask = new WepkgCrossProcessTask();
              paramAnonymousBaseWepkgProcessTask.result = false;
              local1.a(paramAnonymousBaseWepkgProcessTask);
            }
            j.J(paramBoolean, paramString);
            AppMethodBeat.o(110749);
            return;
          }
          j.J(paramBoolean, paramString);
          AppMethodBeat.o(110749);
        }
      });
      AppMethodBeat.o(110752);
      return;
    }
    paramString = new WepkgCrossProcessTask();
    paramString.result = true;
    paramString.EED = true;
    local1.a(paramString);
    AppMethodBeat.o(110752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.j
 * JD-Core Version:    0.7.0.1
 */