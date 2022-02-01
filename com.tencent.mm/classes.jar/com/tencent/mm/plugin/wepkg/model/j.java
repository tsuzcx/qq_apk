package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zs;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public class j
{
  private static volatile j EXS = null;
  
  private static void K(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(110754);
    if (paramBoolean)
    {
      zs localzs = new zs();
      localzs.dQc.dlO = 0;
      com.tencent.mm.sdk.b.a.IvT.l(localzs);
    }
    i.aMs(paramString);
    c.fbI().aF(paramString, 3, 6);
    AppMethodBeat.o(110754);
  }
  
  private void c(final String paramString, final List<WepkgPreloadFile> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(110753);
    for (;;)
    {
      try
      {
        if (!bu.ht(paramList)) {
          break label265;
        }
        ae.i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
        if (bu.isNullOrNil(paramString))
        {
          K(paramBoolean, paramString);
          AppMethodBeat.o(110753);
          return;
        }
        paramList = i.aMp(paramString);
        if (!bu.ht(paramList)) {
          break;
        }
        paramList = new WepkgCrossProcessTask();
        paramList.EN = 3006;
        paramList.EXp.guO = paramString;
        paramList.EXp.EYf = true;
        if (ak.cpe())
        {
          paramList.aOX();
          paramList = i.aMn(paramString);
          if ((paramList != null) && (paramList.createTime != 0L))
          {
            com.tencent.mm.plugin.wepkg.utils.a.b("downloadCompleteTime", "", paramList.guO, paramList.version, -1L, System.currentTimeMillis() - paramList.createTime * 1000L, null);
            paramList = new WepkgCrossProcessTask();
            paramList.EN = 3007;
            paramList.EXp.guO = paramString;
            if (!ak.cpe()) {
              break label223;
            }
            paramList.aOX();
          }
          K(paramBoolean, paramString);
          ae.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:true");
          AppMethodBeat.o(110753);
          return;
        }
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.Wepkg.WepkgUpdater", "loopDownload err:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(110753);
        return;
      }
      AppBrandMainProcessService.b(paramList);
      continue;
      label223:
      AppBrandMainProcessService.b(paramList);
    }
    ae.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", new Object[] { Integer.valueOf(paramList.size()) });
    K(paramBoolean, paramString);
    AppMethodBeat.o(110753);
    return;
    label265:
    WepkgPreloadFile localWepkgPreloadFile = (WepkgPreloadFile)paramList.remove(0);
    if (localWepkgPreloadFile != null)
    {
      ae.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", new Object[] { localWepkgPreloadFile.guO, localWepkgPreloadFile.version, localWepkgPreloadFile.EXv });
      paramString = new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110750);
          if (((this.object instanceof WepkgPreloadFile)) && ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask)))
          {
            Object localObject2 = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            Object localObject1 = (WepkgPreloadFile)this.object;
            if ((((WepkgDownloadProcessTask)localObject2).EXx == WePkgDownloader.IWepkgUpdateCallback.RetCode.EWy) && (!bu.isNullOrNil(((WepkgDownloadProcessTask)localObject2).pkgPath)))
            {
              paramAnonymousBaseWepkgProcessTask = ((WepkgPreloadFile)localObject1).guO;
              localObject1 = ((WepkgPreloadFile)localObject1).EXv;
              localObject2 = ((WepkgDownloadProcessTask)localObject2).pkgPath;
              WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
              localWepkgCrossProcessTask.EN = 4002;
              localWepkgCrossProcessTask.EXs.guO = paramAnonymousBaseWepkgProcessTask;
              localWepkgCrossProcessTask.EXs.EXv = ((String)localObject1);
              localWepkgCrossProcessTask.EXs.filePath = ((String)localObject2);
              localWepkgCrossProcessTask.EXs.EXI = true;
              if (ak.cpe()) {
                localWepkgCrossProcessTask.aOX();
              }
              for (;;)
              {
                j.a(j.this, paramString, paramList, paramBoolean);
                AppMethodBeat.o(110750);
                return;
                AppBrandMainProcessService.b(localWepkgCrossProcessTask);
              }
            }
            ae.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", new Object[] { ((WepkgDownloadProcessTask)localObject2).EXx });
            j.a(j.this, paramString, paramList, paramBoolean);
            AppMethodBeat.o(110750);
            return;
          }
          ae.i("MicroMsg.Wepkg.WepkgUpdater", "object instanceof  WepkgPreloadFile is false");
          j.a(j.this, paramString, paramList, paramBoolean);
          AppMethodBeat.o(110750);
        }
      };
      paramString.object = localWepkgPreloadFile;
      i.a(2, localWepkgPreloadFile.guO, localWepkgPreloadFile.EXv, localWepkgPreloadFile.downloadUrl, localWepkgPreloadFile.size, localWepkgPreloadFile.version, localWepkgPreloadFile.md5, localWepkgPreloadFile.EXh, paramString);
      AppMethodBeat.o(110753);
      return;
    }
    ae.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
    c(paramString, paramList, paramBoolean);
    AppMethodBeat.o(110753);
  }
  
  public static j fbO()
  {
    AppMethodBeat.i(110751);
    if (EXS == null) {}
    try
    {
      if (EXS == null) {
        EXS = new j();
      }
      j localj = EXS;
      AppMethodBeat.o(110751);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(110751);
    }
  }
  
  public final void cB(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(110752);
    if (bu.isNullOrNil(paramString))
    {
      K(paramBoolean, paramString);
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
          if (!paramAnonymousBaseWepkgProcessTask.EWZ) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            j.l(str, bool2, bool1);
            j.a(j.this, str, paramBoolean);
            AppMethodBeat.o(110748);
            return;
          }
        }
        j.L(paramBoolean, paramString);
        AppMethodBeat.o(110748);
      }
    };
    local1.object = paramString;
    ae.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (bu.isNullOrNil(paramString))
    {
      K(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    ae.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    WepkgVersion localWepkgVersion = i.aMn(paramString);
    if (localWepkgVersion == null)
    {
      K(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    if (!localWepkgVersion.EYe)
    {
      i.a(1, localWepkgVersion.guO, "", localWepkgVersion.downloadUrl, localWepkgVersion.EYc, localWepkgVersion.version, localWepkgVersion.md5, localWepkgVersion.EXh, new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110749);
          if ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask))
          {
            paramAnonymousBaseWepkgProcessTask = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            if ((paramAnonymousBaseWepkgProcessTask.EXx == WePkgDownloader.IWepkgUpdateCallback.RetCode.EWy) && (!bu.isNullOrNil(paramAnonymousBaseWepkgProcessTask.dQd)) && (!bu.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)))
            {
              i.a(paramAnonymousBaseWepkgProcessTask.dQd, paramAnonymousBaseWepkgProcessTask.pkgPath, true, local1);
              AppMethodBeat.o(110749);
              return;
            }
            if (local1 != null)
            {
              paramAnonymousBaseWepkgProcessTask = new WepkgCrossProcessTask();
              paramAnonymousBaseWepkgProcessTask.result = false;
              local1.a(paramAnonymousBaseWepkgProcessTask);
            }
            j.L(paramBoolean, paramString);
            AppMethodBeat.o(110749);
            return;
          }
          j.L(paramBoolean, paramString);
          AppMethodBeat.o(110749);
        }
      });
      AppMethodBeat.o(110752);
      return;
    }
    paramString = new WepkgCrossProcessTask();
    paramString.result = true;
    paramString.EWZ = true;
    local1.a(paramString);
    AppMethodBeat.o(110752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.j
 * JD-Core Version:    0.7.0.1
 */