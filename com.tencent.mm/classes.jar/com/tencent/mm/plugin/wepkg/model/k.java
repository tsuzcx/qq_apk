package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ach;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public class k
{
  private static volatile k QNd = null;
  
  private static void R(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(110754);
    if (paramBoolean)
    {
      ach localach = new ach();
      localach.gcw.fvK = 0;
      EventCenter.instance.publish(localach);
    }
    j.boL(paramString);
    c.heF().aJ(paramString, 3, 6);
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
          R(paramBoolean, paramString);
          AppMethodBeat.o(110753);
          return;
        }
        paramList = j.boI(paramString);
        if (!Util.isNullOrNil(paramList)) {
          break;
        }
        paramList = new WepkgCrossProcessTask();
        paramList.Vh = 3006;
        paramList.QMA.jTB = paramString;
        paramList.QMA.QNp = true;
        if (MMApplicationContext.isMMProcess())
        {
          paramList.RW();
          paramList = j.boG(paramString);
          if ((paramList != null) && (paramList.createTime != 0L))
          {
            com.tencent.mm.plugin.wepkg.utils.a.b("downloadCompleteTime", "", paramList.jTB, paramList.version, -1L, System.currentTimeMillis() - paramList.createTime * 1000L, null);
            paramList = new WepkgCrossProcessTask();
            paramList.Vh = 3007;
            paramList.QMA.jTB = paramString;
            if (!MMApplicationContext.isMMProcess()) {
              break label223;
            }
            paramList.RW();
          }
          R(paramBoolean, paramString);
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
      paramList.bPu();
      continue;
      label223:
      paramList.bPu();
    }
    Log.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", new Object[] { Integer.valueOf(paramList.size()) });
    R(paramBoolean, paramString);
    AppMethodBeat.o(110753);
    return;
    label265:
    WepkgPreloadFile localWepkgPreloadFile = (WepkgPreloadFile)paramList.remove(0);
    if (localWepkgPreloadFile != null)
    {
      Log.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", new Object[] { localWepkgPreloadFile.jTB, localWepkgPreloadFile.version, localWepkgPreloadFile.QMG });
      paramString = new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110750);
          if (((this.object instanceof WepkgPreloadFile)) && ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask)))
          {
            Object localObject2 = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            Object localObject1 = (WepkgPreloadFile)this.object;
            if ((((WepkgDownloadProcessTask)localObject2).QMI == WePkgDownloader.IWepkgUpdateCallback.RetCode.QLI) && (!Util.isNullOrNil(((WepkgDownloadProcessTask)localObject2).pkgPath)))
            {
              paramAnonymousBaseWepkgProcessTask = ((WepkgPreloadFile)localObject1).jTB;
              localObject1 = ((WepkgPreloadFile)localObject1).QMG;
              localObject2 = ((WepkgDownloadProcessTask)localObject2).pkgPath;
              WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
              localWepkgCrossProcessTask.Vh = 4002;
              localWepkgCrossProcessTask.QMD.jTB = paramAnonymousBaseWepkgProcessTask;
              localWepkgCrossProcessTask.QMD.QMG = ((String)localObject1);
              localWepkgCrossProcessTask.QMD.filePath = ((String)localObject2);
              localWepkgCrossProcessTask.QMD.QMT = true;
              if (MMApplicationContext.isMMProcess()) {
                localWepkgCrossProcessTask.RW();
              }
              for (;;)
              {
                k.a(k.this, paramString, paramList, paramBoolean);
                AppMethodBeat.o(110750);
                return;
                localWepkgCrossProcessTask.bPu();
              }
            }
            Log.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", new Object[] { ((WepkgDownloadProcessTask)localObject2).QMI });
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
      j.a(2, localWepkgPreloadFile.jTB, localWepkgPreloadFile.QMG, localWepkgPreloadFile.downloadUrl, localWepkgPreloadFile.size, localWepkgPreloadFile.version, localWepkgPreloadFile.md5, localWepkgPreloadFile.QMs, paramString);
      AppMethodBeat.o(110753);
      return;
    }
    Log.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
    c(paramString, paramList, paramBoolean);
    AppMethodBeat.o(110753);
  }
  
  public static k heN()
  {
    AppMethodBeat.i(110751);
    if (QNd == null) {}
    try
    {
      if (QNd == null) {
        QNd = new k();
      }
      k localk = QNd;
      AppMethodBeat.o(110751);
      return localk;
    }
    finally
    {
      AppMethodBeat.o(110751);
    }
  }
  
  public final void dk(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(110752);
    if (Util.isNullOrNil(paramString))
    {
      R(paramBoolean, paramString);
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
          if (!paramAnonymousBaseWepkgProcessTask.QMj) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            k.n(str, bool2, bool1);
            k.a(k.this, str, paramBoolean);
            AppMethodBeat.o(110748);
            return;
          }
        }
        k.S(paramBoolean, paramString);
        AppMethodBeat.o(110748);
      }
    };
    local1.object = paramString;
    Log.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (Util.isNullOrNil(paramString))
    {
      R(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    Log.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    WepkgVersion localWepkgVersion = j.boG(paramString);
    if (localWepkgVersion == null)
    {
      R(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    if (!localWepkgVersion.QNo)
    {
      j.a(1, localWepkgVersion.jTB, "", localWepkgVersion.downloadUrl, localWepkgVersion.QNm, localWepkgVersion.version, localWepkgVersion.md5, localWepkgVersion.QMs, new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110749);
          if ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask))
          {
            paramAnonymousBaseWepkgProcessTask = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            if ((paramAnonymousBaseWepkgProcessTask.QMI == WePkgDownloader.IWepkgUpdateCallback.RetCode.QLI) && (!Util.isNullOrNil(paramAnonymousBaseWepkgProcessTask.gcx)) && (!Util.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)))
            {
              j.a(paramAnonymousBaseWepkgProcessTask.gcx, paramAnonymousBaseWepkgProcessTask.pkgPath, true, local1);
              AppMethodBeat.o(110749);
              return;
            }
            if (local1 != null)
            {
              paramAnonymousBaseWepkgProcessTask = new WepkgCrossProcessTask();
              paramAnonymousBaseWepkgProcessTask.result = false;
              local1.a(paramAnonymousBaseWepkgProcessTask);
            }
            k.S(paramBoolean, paramString);
            AppMethodBeat.o(110749);
            return;
          }
          k.S(paramBoolean, paramString);
          AppMethodBeat.o(110749);
        }
      });
      AppMethodBeat.o(110752);
      return;
    }
    paramString = new WepkgCrossProcessTask();
    paramString.result = true;
    paramString.QMj = true;
    local1.a(paramString);
    AppMethodBeat.o(110752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.k
 * JD-Core Version:    0.7.0.1
 */