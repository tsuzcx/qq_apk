package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public class j
{
  private static volatile j BJo = null;
  
  private static void C(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(110754);
    if (paramBoolean)
    {
      yh localyh = new yh();
      localyh.dEN.dbV = 0;
      com.tencent.mm.sdk.b.a.ESL.l(localyh);
    }
    i.aAe(paramString);
    c.etK().fn(paramString, 3);
    AppMethodBeat.o(110754);
  }
  
  private void c(final String paramString, final List<WepkgPreloadFile> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(110753);
    for (;;)
    {
      try
      {
        if (!bt.gL(paramList)) {
          break label265;
        }
        ad.i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
        if (bt.isNullOrNil(paramString))
        {
          C(paramBoolean, paramString);
          AppMethodBeat.o(110753);
          return;
        }
        paramList = i.aAb(paramString);
        if (!bt.gL(paramList)) {
          break;
        }
        paramList = new WepkgCrossProcessTask();
        paramList.BX = 3006;
        paramList.BIL.fUW = paramString;
        paramList.BIL.BJB = true;
        if (aj.cbv())
        {
          paramList.aEz();
          paramList = i.azZ(paramString);
          if ((paramList != null) && (paramList.createTime != 0L))
          {
            com.tencent.mm.plugin.wepkg.utils.a.b("downloadCompleteTime", "", paramList.fUW, paramList.version, -1L, System.currentTimeMillis() - paramList.createTime * 1000L, null);
            paramList = new WepkgCrossProcessTask();
            paramList.BX = 3007;
            paramList.BIL.fUW = paramString;
            if (!aj.cbv()) {
              break label223;
            }
            paramList.aEz();
          }
          C(paramBoolean, paramString);
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
    C(paramBoolean, paramString);
    AppMethodBeat.o(110753);
    return;
    label265:
    WepkgPreloadFile localWepkgPreloadFile = (WepkgPreloadFile)paramList.remove(0);
    if (localWepkgPreloadFile != null)
    {
      ad.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", new Object[] { localWepkgPreloadFile.fUW, localWepkgPreloadFile.version, localWepkgPreloadFile.BIR });
      paramString = new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110750);
          if (((this.object instanceof WepkgPreloadFile)) && ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask)))
          {
            Object localObject2 = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            Object localObject1 = (WepkgPreloadFile)this.object;
            if ((((WepkgDownloadProcessTask)localObject2).BIT == WePkgDownloader.IWepkgUpdateCallback.RetCode.BHV) && (!bt.isNullOrNil(((WepkgDownloadProcessTask)localObject2).pkgPath)))
            {
              paramAnonymousBaseWepkgProcessTask = ((WepkgPreloadFile)localObject1).fUW;
              localObject1 = ((WepkgPreloadFile)localObject1).BIR;
              localObject2 = ((WepkgDownloadProcessTask)localObject2).pkgPath;
              WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
              localWepkgCrossProcessTask.BX = 4002;
              localWepkgCrossProcessTask.BIO.fUW = paramAnonymousBaseWepkgProcessTask;
              localWepkgCrossProcessTask.BIO.BIR = ((String)localObject1);
              localWepkgCrossProcessTask.BIO.filePath = ((String)localObject2);
              localWepkgCrossProcessTask.BIO.BJe = true;
              if (aj.cbv()) {
                localWepkgCrossProcessTask.aEz();
              }
              for (;;)
              {
                j.a(j.this, paramString, paramList, paramBoolean);
                AppMethodBeat.o(110750);
                return;
                AppBrandMainProcessService.b(localWepkgCrossProcessTask);
              }
            }
            ad.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", new Object[] { ((WepkgDownloadProcessTask)localObject2).BIT });
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
      i.a(2, localWepkgPreloadFile.fUW, localWepkgPreloadFile.BIR, localWepkgPreloadFile.downloadUrl, localWepkgPreloadFile.size, localWepkgPreloadFile.version, localWepkgPreloadFile.md5, localWepkgPreloadFile.BID, paramString);
      AppMethodBeat.o(110753);
      return;
    }
    ad.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
    c(paramString, paramList, paramBoolean);
    AppMethodBeat.o(110753);
  }
  
  public static j etP()
  {
    AppMethodBeat.i(110751);
    if (BJo == null) {}
    try
    {
      if (BJo == null) {
        BJo = new j();
      }
      j localj = BJo;
      AppMethodBeat.o(110751);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(110751);
    }
  }
  
  public final void cm(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(110752);
    if (bt.isNullOrNil(paramString))
    {
      C(paramBoolean, paramString);
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
          if (!paramAnonymousBaseWepkgProcessTask.BIv) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            j.i(str, bool2, bool1);
            j.a(j.this, str, paramBoolean);
            AppMethodBeat.o(110748);
            return;
          }
        }
        j.D(paramBoolean, paramString);
        AppMethodBeat.o(110748);
      }
    };
    local1.object = paramString;
    ad.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (bt.isNullOrNil(paramString))
    {
      C(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    ad.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    WepkgVersion localWepkgVersion = i.azZ(paramString);
    if (localWepkgVersion == null)
    {
      C(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    if (!localWepkgVersion.BJA)
    {
      i.a(1, localWepkgVersion.fUW, "", localWepkgVersion.downloadUrl, localWepkgVersion.BJy, localWepkgVersion.version, localWepkgVersion.md5, localWepkgVersion.BID, new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110749);
          if ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask))
          {
            paramAnonymousBaseWepkgProcessTask = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            if ((paramAnonymousBaseWepkgProcessTask.BIT == WePkgDownloader.IWepkgUpdateCallback.RetCode.BHV) && (!bt.isNullOrNil(paramAnonymousBaseWepkgProcessTask.dEO)) && (!bt.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)))
            {
              i.a(paramAnonymousBaseWepkgProcessTask.dEO, paramAnonymousBaseWepkgProcessTask.pkgPath, true, local1);
              AppMethodBeat.o(110749);
              return;
            }
            if (local1 != null)
            {
              paramAnonymousBaseWepkgProcessTask = new WepkgCrossProcessTask();
              paramAnonymousBaseWepkgProcessTask.result = false;
              local1.a(paramAnonymousBaseWepkgProcessTask);
            }
            j.D(paramBoolean, paramString);
            AppMethodBeat.o(110749);
            return;
          }
          j.D(paramBoolean, paramString);
          AppMethodBeat.o(110749);
        }
      });
      AppMethodBeat.o(110752);
      return;
    }
    paramString = new WepkgCrossProcessTask();
    paramString.result = true;
    paramString.BIv = true;
    local1.a(paramString);
    AppMethodBeat.o(110752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.j
 * JD-Core Version:    0.7.0.1
 */