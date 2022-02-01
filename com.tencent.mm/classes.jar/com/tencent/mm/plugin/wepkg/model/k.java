package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aee;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public class k
{
  private static volatile k XGB = null;
  
  private static void aO(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(110754);
    if (paramBoolean)
    {
      aee localaee = new aee();
      localaee.iiI.hAf = 0;
      localaee.publish();
    }
    j.boz(paramString);
    c.iFn().aR(paramString, 3, 6);
    AppMethodBeat.o(110754);
  }
  
  private void c(final String paramString, final List<WepkgPreloadFile> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(110753);
    for (;;)
    {
      try
      {
        if (!Util.isNullOrNil(paramList)) {
          break label265;
        }
        Log.i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
        if (Util.isNullOrNil(paramString))
        {
          aO(paramBoolean, paramString);
          AppMethodBeat.o(110753);
          return;
        }
        paramList = j.bow(paramString);
        if (!Util.isNullOrNil(paramList)) {
          break;
        }
        paramList = new WepkgCrossProcessTask();
        paramList.bUl = 3006;
        paramList.XFY.mtT = paramString;
        paramList.XFY.XGN = true;
        if (MMApplicationContext.isMMProcess())
        {
          paramList.asn();
          paramList = j.bou(paramString);
          if ((paramList != null) && (paramList.createTime != 0L))
          {
            com.tencent.mm.plugin.wepkg.utils.a.b("downloadCompleteTime", "", paramList.mtT, paramList.version, -1L, System.currentTimeMillis() - paramList.createTime * 1000L, null);
            paramList = new WepkgCrossProcessTask();
            paramList.bUl = 3007;
            paramList.XFY.mtT = paramString;
            if (!MMApplicationContext.isMMProcess()) {
              break label223;
            }
            paramList.asn();
          }
          aO(paramBoolean, paramString);
          Log.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:true");
          AppMethodBeat.o(110753);
          return;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.Wepkg.WepkgUpdater", "loopDownload err:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(110753);
        return;
      }
      paramList.cpB();
      continue;
      label223:
      paramList.cpB();
    }
    Log.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", new Object[] { Integer.valueOf(paramList.size()) });
    aO(paramBoolean, paramString);
    AppMethodBeat.o(110753);
    return;
    label265:
    WepkgPreloadFile localWepkgPreloadFile = (WepkgPreloadFile)paramList.remove(0);
    if (localWepkgPreloadFile != null)
    {
      Log.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", new Object[] { localWepkgPreloadFile.mtT, localWepkgPreloadFile.version, localWepkgPreloadFile.XGe });
      paramString = new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110750);
          if (((this.object instanceof WepkgPreloadFile)) && ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask)))
          {
            Object localObject2 = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            Object localObject1 = (WepkgPreloadFile)this.object;
            if ((((WepkgDownloadProcessTask)localObject2).XGg == WePkgDownloader.IWepkgUpdateCallback.RetCode.XFh) && (!Util.isNullOrNil(((WepkgDownloadProcessTask)localObject2).pkgPath)))
            {
              paramAnonymousBaseWepkgProcessTask = ((WepkgPreloadFile)localObject1).mtT;
              localObject1 = ((WepkgPreloadFile)localObject1).XGe;
              localObject2 = ((WepkgDownloadProcessTask)localObject2).pkgPath;
              WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
              localWepkgCrossProcessTask.bUl = 4002;
              localWepkgCrossProcessTask.XGb.mtT = paramAnonymousBaseWepkgProcessTask;
              localWepkgCrossProcessTask.XGb.XGe = ((String)localObject1);
              localWepkgCrossProcessTask.XGb.filePath = ((String)localObject2);
              localWepkgCrossProcessTask.XGb.XGr = true;
              if (MMApplicationContext.isMMProcess()) {
                localWepkgCrossProcessTask.asn();
              }
              for (;;)
              {
                k.a(k.this, paramString, paramList, paramBoolean);
                AppMethodBeat.o(110750);
                return;
                localWepkgCrossProcessTask.cpB();
              }
            }
            Log.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", new Object[] { ((WepkgDownloadProcessTask)localObject2).XGg });
            k.a(k.this, paramString, paramList, paramBoolean);
            AppMethodBeat.o(110750);
            return;
          }
          Log.i("MicroMsg.Wepkg.WepkgUpdater", "object instanceof  WepkgPreloadFile is false");
          k.a(k.this, paramString, paramList, paramBoolean);
          AppMethodBeat.o(110750);
        }
      };
      paramString.object = localWepkgPreloadFile;
      j.a(2, localWepkgPreloadFile.mtT, localWepkgPreloadFile.XGe, localWepkgPreloadFile.downloadUrl, localWepkgPreloadFile.size, localWepkgPreloadFile.version, localWepkgPreloadFile.md5, localWepkgPreloadFile.XFQ, paramString);
      AppMethodBeat.o(110753);
      return;
    }
    Log.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
    c(paramString, paramList, paramBoolean);
    AppMethodBeat.o(110753);
  }
  
  public static k iFv()
  {
    AppMethodBeat.i(110751);
    if (XGB == null) {}
    try
    {
      if (XGB == null) {
        XGB = new k();
      }
      k localk = XGB;
      AppMethodBeat.o(110751);
      return localk;
    }
    finally
    {
      AppMethodBeat.o(110751);
    }
  }
  
  public final void dU(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(110752);
    if (Util.isNullOrNil(paramString))
    {
      aO(paramBoolean, paramString);
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
          if (!paramAnonymousBaseWepkgProcessTask.XFH) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            k.r(str, bool2, bool1);
            k.a(k.this, str, paramBoolean);
            AppMethodBeat.o(110748);
            return;
          }
        }
        k.aP(paramBoolean, paramString);
        AppMethodBeat.o(110748);
      }
    };
    local1.object = paramString;
    Log.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (Util.isNullOrNil(paramString))
    {
      aO(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    Log.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    WepkgVersion localWepkgVersion = j.bou(paramString);
    if (localWepkgVersion == null)
    {
      aO(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    if (!localWepkgVersion.XGM)
    {
      j.a(1, localWepkgVersion.mtT, "", localWepkgVersion.downloadUrl, localWepkgVersion.XGK, localWepkgVersion.version, localWepkgVersion.md5, localWepkgVersion.XFQ, new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110749);
          if ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask))
          {
            paramAnonymousBaseWepkgProcessTask = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            if ((paramAnonymousBaseWepkgProcessTask.XGg == WePkgDownloader.IWepkgUpdateCallback.RetCode.XFh) && (!Util.isNullOrNil(paramAnonymousBaseWepkgProcessTask.iiJ)) && (!Util.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)))
            {
              j.a(paramAnonymousBaseWepkgProcessTask.iiJ, paramAnonymousBaseWepkgProcessTask.pkgPath, true, local1);
              AppMethodBeat.o(110749);
              return;
            }
            if (local1 != null)
            {
              paramAnonymousBaseWepkgProcessTask = new WepkgCrossProcessTask();
              paramAnonymousBaseWepkgProcessTask.result = false;
              local1.a(paramAnonymousBaseWepkgProcessTask);
            }
            k.aP(paramBoolean, paramString);
            AppMethodBeat.o(110749);
            return;
          }
          k.aP(paramBoolean, paramString);
          AppMethodBeat.o(110749);
        }
      });
      AppMethodBeat.o(110752);
      return;
    }
    paramString = new WepkgCrossProcessTask();
    paramString.result = true;
    paramString.XFH = true;
    local1.a(paramString);
    AppMethodBeat.o(110752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.k
 * JD-Core Version:    0.7.0.1
 */