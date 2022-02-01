package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaz;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public class k
{
  private static volatile k JNK = null;
  
  private static void L(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(110754);
    if (paramBoolean)
    {
      aaz localaaz = new aaz();
      localaaz.eif.dDe = 0;
      EventCenter.instance.publish(localaaz);
    }
    j.bcM(paramString);
    c.gkN().aH(paramString, 3, 6);
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
          L(paramBoolean, paramString);
          AppMethodBeat.o(110753);
          return;
        }
        paramList = j.bcJ(paramString);
        if (!Util.isNullOrNil(paramList)) {
          break;
        }
        paramList = new WepkgCrossProcessTask();
        paramList.EX = 3006;
        paramList.JNh.hhD = paramString;
        paramList.JNh.JNW = true;
        if (MMApplicationContext.isMMProcess())
        {
          paramList.bjj();
          paramList = j.bcH(paramString);
          if ((paramList != null) && (paramList.createTime != 0L))
          {
            com.tencent.mm.plugin.wepkg.utils.a.b("downloadCompleteTime", "", paramList.hhD, paramList.version, -1L, System.currentTimeMillis() - paramList.createTime * 1000L, null);
            paramList = new WepkgCrossProcessTask();
            paramList.EX = 3007;
            paramList.JNh.hhD = paramString;
            if (!MMApplicationContext.isMMProcess()) {
              break label223;
            }
            paramList.bjj();
          }
          L(paramBoolean, paramString);
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
      AppBrandMainProcessService.b(paramList);
      continue;
      label223:
      AppBrandMainProcessService.b(paramList);
    }
    Log.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", new Object[] { Integer.valueOf(paramList.size()) });
    L(paramBoolean, paramString);
    AppMethodBeat.o(110753);
    return;
    label265:
    WepkgPreloadFile localWepkgPreloadFile = (WepkgPreloadFile)paramList.remove(0);
    if (localWepkgPreloadFile != null)
    {
      Log.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", new Object[] { localWepkgPreloadFile.hhD, localWepkgPreloadFile.version, localWepkgPreloadFile.JNn });
      paramString = new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110750);
          if (((this.object instanceof WepkgPreloadFile)) && ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask)))
          {
            Object localObject2 = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            Object localObject1 = (WepkgPreloadFile)this.object;
            if ((((WepkgDownloadProcessTask)localObject2).JNp == WePkgDownloader.IWepkgUpdateCallback.RetCode.JMp) && (!Util.isNullOrNil(((WepkgDownloadProcessTask)localObject2).pkgPath)))
            {
              paramAnonymousBaseWepkgProcessTask = ((WepkgPreloadFile)localObject1).hhD;
              localObject1 = ((WepkgPreloadFile)localObject1).JNn;
              localObject2 = ((WepkgDownloadProcessTask)localObject2).pkgPath;
              WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
              localWepkgCrossProcessTask.EX = 4002;
              localWepkgCrossProcessTask.JNk.hhD = paramAnonymousBaseWepkgProcessTask;
              localWepkgCrossProcessTask.JNk.JNn = ((String)localObject1);
              localWepkgCrossProcessTask.JNk.filePath = ((String)localObject2);
              localWepkgCrossProcessTask.JNk.JNA = true;
              if (MMApplicationContext.isMMProcess()) {
                localWepkgCrossProcessTask.bjj();
              }
              for (;;)
              {
                k.a(k.this, paramString, paramList, paramBoolean);
                AppMethodBeat.o(110750);
                return;
                AppBrandMainProcessService.b(localWepkgCrossProcessTask);
              }
            }
            Log.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", new Object[] { ((WepkgDownloadProcessTask)localObject2).JNp });
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
      j.a(2, localWepkgPreloadFile.hhD, localWepkgPreloadFile.JNn, localWepkgPreloadFile.downloadUrl, localWepkgPreloadFile.size, localWepkgPreloadFile.version, localWepkgPreloadFile.md5, localWepkgPreloadFile.JMZ, paramString);
      AppMethodBeat.o(110753);
      return;
    }
    Log.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
    c(paramString, paramList, paramBoolean);
    AppMethodBeat.o(110753);
  }
  
  public static k gkU()
  {
    AppMethodBeat.i(110751);
    if (JNK == null) {}
    try
    {
      if (JNK == null) {
        JNK = new k();
      }
      k localk = JNK;
      AppMethodBeat.o(110751);
      return localk;
    }
    finally
    {
      AppMethodBeat.o(110751);
    }
  }
  
  public final void cW(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(110752);
    if (Util.isNullOrNil(paramString))
    {
      L(paramBoolean, paramString);
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
          if (!paramAnonymousBaseWepkgProcessTask.JMQ) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            k.n(str, bool2, bool1);
            k.a(k.this, str, paramBoolean);
            AppMethodBeat.o(110748);
            return;
          }
        }
        k.M(paramBoolean, paramString);
        AppMethodBeat.o(110748);
      }
    };
    local1.object = paramString;
    Log.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (Util.isNullOrNil(paramString))
    {
      L(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    Log.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    WepkgVersion localWepkgVersion = j.bcH(paramString);
    if (localWepkgVersion == null)
    {
      L(paramBoolean, paramString);
      AppMethodBeat.o(110752);
      return;
    }
    if (!localWepkgVersion.JNV)
    {
      j.a(1, localWepkgVersion.hhD, "", localWepkgVersion.downloadUrl, localWepkgVersion.JNT, localWepkgVersion.version, localWepkgVersion.md5, localWepkgVersion.JMZ, new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(110749);
          if ((paramAnonymousBaseWepkgProcessTask instanceof WepkgDownloadProcessTask))
          {
            paramAnonymousBaseWepkgProcessTask = (WepkgDownloadProcessTask)paramAnonymousBaseWepkgProcessTask;
            if ((paramAnonymousBaseWepkgProcessTask.JNp == WePkgDownloader.IWepkgUpdateCallback.RetCode.JMp) && (!Util.isNullOrNil(paramAnonymousBaseWepkgProcessTask.eig)) && (!Util.isNullOrNil(paramAnonymousBaseWepkgProcessTask.pkgPath)))
            {
              j.a(paramAnonymousBaseWepkgProcessTask.eig, paramAnonymousBaseWepkgProcessTask.pkgPath, true, local1);
              AppMethodBeat.o(110749);
              return;
            }
            if (local1 != null)
            {
              paramAnonymousBaseWepkgProcessTask = new WepkgCrossProcessTask();
              paramAnonymousBaseWepkgProcessTask.result = false;
              local1.a(paramAnonymousBaseWepkgProcessTask);
            }
            k.M(paramBoolean, paramString);
            AppMethodBeat.o(110749);
            return;
          }
          k.M(paramBoolean, paramString);
          AppMethodBeat.o(110749);
        }
      });
      AppMethodBeat.o(110752);
      return;
    }
    paramString = new WepkgCrossProcessTask();
    paramString.result = true;
    paramString.JMQ = true;
    local1.a(paramString);
    AppMethodBeat.o(110752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.k
 * JD-Core Version:    0.7.0.1
 */