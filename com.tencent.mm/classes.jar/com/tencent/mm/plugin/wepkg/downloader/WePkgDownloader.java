package com.tencent.mm.plugin.wepkg.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.wepkg.c.a.a;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WePkgDownloader
{
  private static volatile WePkgDownloader CZW = null;
  private Map<String, IWepkgUpdateCallback> CZX;
  private a CZY;
  
  public WePkgDownloader()
  {
    AppMethodBeat.i(110610);
    this.CZY = new a()
    {
      public final void a(g paramAnonymousg)
      {
        for (;;)
        {
          try
          {
            AppMethodBeat.i(110603);
            if (paramAnonymousg.mStatus == 1)
            {
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(859L, 2L, 1L, false);
              localObject1 = paramAnonymousg.CZL.mFilePath;
              if ((bs.isNullOrNil((String)localObject1)) || (!new e((String)localObject1).exists()))
              {
                ac.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, pkgPath is null or nil");
                localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.Dae;
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(859L, 4L, 1L, false);
                ac.i("MicroMsg.Wepkg.WepkgDownloader", "download callback retCode:".concat(String.valueOf(localObject1)));
                localObject2 = (WePkgDownloader.IWepkgUpdateCallback)WePkgDownloader.a(WePkgDownloader.this).remove(paramAnonymousg.CZL.Dal);
                if (localObject2 != null)
                {
                  ((WePkgDownloader.IWepkgUpdateCallback)localObject2).a(paramAnonymousg.CZL.Dam, paramAnonymousg.CZL.mFilePath, (WePkgDownloader.IWepkgUpdateCallback.RetCode)localObject1);
                  if ((paramAnonymousg.CZL.oIR != 1) && (paramAnonymousg.CZL.oIR != 3)) {
                    break label401;
                  }
                  localObject1 = paramAnonymousg.CZL.Dam;
                  localObject2 = new WepkgCrossProcessTask();
                  ((WepkgCrossProcessTask)localObject2).CW = 3008;
                  ((WepkgCrossProcessTask)localObject2).DaU.fYR = ((String)localObject1);
                  if (!ai.ciE()) {
                    break label393;
                  }
                  ((WepkgCrossProcessTask)localObject2).aLq();
                  WePkgDownloader.b(paramAnonymousg);
                  d.eIZ().aFh(paramAnonymousg.CZL.Dal);
                  AppMethodBeat.o(110603);
                }
              }
              else
              {
                localObject2 = paramAnonymousg.CZL.jYv;
                localObject3 = com.tencent.mm.vfs.i.aKe((String)localObject1);
                if (!bs.nullAsNil((String)localObject3).equalsIgnoreCase((String)localObject2))
                {
                  ac.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, file.md5(%s) != net.md5(%s)", new Object[] { localObject3, localObject2 });
                  com.tencent.mm.vfs.i.deleteFile((String)localObject1);
                  localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.Daf;
                  paramAnonymousg.pwp = 1012;
                  com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(859L, 3L, 1L, false);
                  continue;
                }
                localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.Dad;
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(859L, 5L, 1L, false);
                continue;
              }
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(859L, 1L, 1L, false);
              localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.Dah;
              continue;
            }
            ac.i("MicroMsg.Wepkg.WepkgDownloader", "download callback invalid");
            com.tencent.mm.plugin.wepkg.utils.a.b("CallbackInvalid", paramAnonymousg.CZL.mUrl, paramAnonymousg.CZL.Dam, null, -1L, 0L, null);
            continue;
            AppBrandMainProcessService.b((MainProcessTask)localObject2);
          }
          finally {}
          label393:
          continue;
          label401:
          Object localObject1 = paramAnonymousg.CZL.Dam;
          Object localObject2 = paramAnonymousg.CZL.Dan;
          Object localObject3 = new WepkgCrossProcessTask();
          ((WepkgCrossProcessTask)localObject3).CW = 4005;
          ((WepkgCrossProcessTask)localObject3).DaX.fYR = ((String)localObject1);
          ((WepkgCrossProcessTask)localObject3).DaX.Dba = ((String)localObject2);
          if (ai.ciE()) {
            ((WepkgCrossProcessTask)localObject3).aLq();
          } else {
            AppBrandMainProcessService.b((MainProcessTask)localObject3);
          }
        }
      }
    };
    if (this.CZX == null) {
      this.CZX = new ConcurrentHashMap();
    }
    AppMethodBeat.o(110610);
  }
  
  private void a(e parame, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(177087);
    if ((parame == null) || (!parame.exists()))
    {
      AppMethodBeat.o(177087);
      return;
    }
    if ((parame.isFile()) && (parame.getName().equals(paramString)))
    {
      paramString = paramList;
      if (paramList == null) {
        paramString = new ArrayList();
      }
      paramString.add(q.B(parame.fxV()));
      AppMethodBeat.o(177087);
      return;
    }
    if (parame.isDirectory())
    {
      parame = parame.fxX();
      if (parame != null)
      {
        int i = 0;
        while (i < parame.length)
        {
          a(parame[i], paramString, paramList);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(177087);
  }
  
  public static WePkgDownloader eJa()
  {
    AppMethodBeat.i(110609);
    if (CZW == null) {}
    try
    {
      if (CZW == null) {
        CZW = new WePkgDownloader();
      }
      WePkgDownloader localWePkgDownloader = CZW;
      AppMethodBeat.o(110609);
      return localWePkgDownloader;
    }
    finally
    {
      AppMethodBeat.o(110609);
    }
  }
  
  private static boolean h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(110612);
    l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        i = ((IBSPatchJNIService)com.tencent.mm.kernel.g.ab(IBSPatchJNIService.class)).bspatch(paramString3, paramString2, paramString4);
        l2 = System.currentTimeMillis() - l1;
        ac.i("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPackage, result: %d, cost: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l2) });
        if (i != 0) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.wUl.dB(859, 34);
        boolean bool;
        if (bs.isNullOrNil(paramString5))
        {
          bool = true;
          if (bool)
          {
            com.tencent.mm.plugin.wepkg.utils.a.c(paramString1, 0, "", l2);
            AppMethodBeat.o(110612);
            return true;
          }
        }
        else
        {
          String str = com.tencent.mm.vfs.i.aKe(paramString2);
          if (bs.isNullOrNil(str))
          {
            bool = false;
            continue;
          }
          ac.i("MicroMsg.Wepkg.WepkgDownloader", "matchMd5, fileMd5: %s, md5: %s", new Object[] { str, paramString5 });
          bool = paramString5.trim().equalsIgnoreCase(str.trim());
          continue;
        }
        com.tencent.mm.plugin.report.service.h.wUl.dB(859, 35);
        com.tencent.mm.plugin.wepkg.utils.a.c(paramString1, 2007, "", l2);
      }
      catch (Exception paramString5)
      {
        int i;
        long l2 = System.currentTimeMillis();
        ac.e("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", new Object[] { paramString5, paramString3, paramString2, paramString4 });
        ac.printErrStackTrace("MicroMsg.Wepkg.WepkgDownloader", paramString5, "", new Object[0]);
        com.tencent.mm.plugin.report.service.h.wUl.dB(859, 33);
        com.tencent.mm.plugin.wepkg.utils.a.c(paramString1, 2006, "", l2 - l1);
        continue;
      }
      AppMethodBeat.o(110612);
      return false;
      com.tencent.mm.plugin.report.service.h.wUl.dB(859, 27);
      com.tencent.mm.plugin.report.service.h.wUl.dB(859, 25 - i);
      com.tencent.mm.plugin.wepkg.utils.a.c(paramString1, 1998 - i, "", l2);
    }
  }
  
  private static String kN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110613);
    paramString1 = com.tencent.mm.plugin.wepkg.model.d.kP(paramString1, paramString2);
    com.tencent.mm.plugin.wepkg.utils.d.aFC(paramString1);
    paramString1 = paramString1 + "/package";
    AppMethodBeat.o(110613);
    return paramString1;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt2, IWepkgUpdateCallback paramIWepkgUpdateCallback)
  {
    AppMethodBeat.i(110614);
    ac.i("MicroMsg.Wepkg.WepkgDownloader", "triggerDownloadWepkg, fileType:%s, pkgid:%s, downloadUrl:%s, pkgSize:%d, version:%s, md5:%s, downloadNetType:%d", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString4, Long.valueOf(paramLong), paramString5, paramString7, Integer.valueOf(paramInt2) });
    if (paramInt1 == 2)
    {
      paramString2 = com.tencent.mm.plugin.wepkg.model.d.kP(paramString1, paramString5) + "/preload_files";
      com.tencent.mm.plugin.wepkg.utils.d.aFC(paramString2);
    }
    for (String str = paramString2 + "/" + paramString7;; str = paramString2)
    {
      if (bs.isNullOrNil(str))
      {
        ac.i("MicroMsg.Wepkg.WepkgDownloader", "pkgPath:%s is null", new Object[] { str });
        a.a.eJj().y(paramString1, paramString4, 0L);
        if (paramIWepkgUpdateCallback != null) {
          paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.Dah);
        }
        AppMethodBeat.o(110614);
        return;
      }
      if (com.tencent.mm.pluginsdk.h.a.d.a.eA(str))
      {
        if (bs.nullAsNil(com.tencent.mm.vfs.i.aKe(str)).equals(paramString7))
        {
          ac.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", new Object[] { paramString5, str });
          a.a.eJj().y(paramString1, paramString4, 0L);
          if (paramIWepkgUpdateCallback != null) {
            paramIWepkgUpdateCallback.a(paramString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.Dad);
          }
          AppMethodBeat.o(110614);
        }
      }
      else
      {
        paramString2 = com.tencent.mm.plugin.wepkg.model.d.aFj(paramString1);
        if (!bs.isNullOrNil(paramString2))
        {
          e locale = new e(paramString2);
          ArrayList localArrayList = new ArrayList();
          if ((str == null) || (str.length() <= 0)) {
            paramString2 = "";
          }
          for (;;)
          {
            a(locale, paramString2, localArrayList);
            ac.i("MicroMsg.Wepkg.WepkgDownloader", "local have the same file. size:%s", new Object[] { Integer.valueOf(localArrayList.size()) });
            paramString2 = localArrayList.iterator();
            do
            {
              if (!paramString2.hasNext()) {
                break;
              }
              localObject = new e((String)paramString2.next());
            } while ((!((e)localObject).isFile()) || (((e)localObject).length() != paramLong) || (!bs.nullAsNil(com.tencent.mm.vfs.i.aKe(q.B(((e)localObject).mUri))).equalsIgnoreCase(paramString7)));
            com.tencent.mm.vfs.i.lZ(q.B(((e)localObject).fxV()), str);
            ac.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in other version path:%s, pkgPath:%s", new Object[] { q.B(((e)localObject).fxV()), str });
            a.a.eJj().y(paramString1, paramString4, 0L);
            if (paramIWepkgUpdateCallback != null) {
              paramIWepkgUpdateCallback.a(paramString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.Dad);
            }
            AppMethodBeat.o(110614);
            return;
            Object localObject = new e(str).getName();
            i = ((String)localObject).lastIndexOf('.');
            paramString2 = (String)localObject;
            if (i >= 0) {
              if (i == 0) {
                paramString2 = "";
              } else {
                paramString2 = ((String)localObject).substring(0, i);
              }
            }
          }
        }
      }
      int j = 0;
      boolean bool4 = false;
      boolean bool6 = false;
      boolean bool5 = false;
      boolean bool3 = false;
      boolean bool1 = bool5;
      int i = j;
      boolean bool2 = bool3;
      switch (paramInt2)
      {
      default: 
        bool2 = bool3;
        i = j;
        bool1 = bool5;
      case 2: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
        if (i != 0)
        {
          a.a.eJj().y(paramString1, paramString4, paramLong);
          label660:
          ac.i("MicroMsg.Wepkg.WepkgDownloader", "allowDownload:%s", new Object[] { Boolean.valueOf(bool1) });
          if (!bool1) {
            break label1007;
          }
          paramString2 = new c(new f(com.tencent.mm.b.g.getMessageDigest(paramString4.getBytes()), paramInt1, paramString1, paramString3, paramString5, paramString6, paramString4, str, paramLong, paramString7, bool2, this.CZY));
          paramString3 = d.eIZ();
          if (paramString3.CZV.containsKey(paramString2.CZL.Dal)) {
            break label977;
          }
          paramString2.CZM = b.eIX().CZK.submit(paramString2);
          paramString3.CZV.put(paramString2.CZL.Dal, paramString2);
        }
        break;
      }
      label977:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label982;
        }
        this.CZX.put(com.tencent.mm.b.g.getMessageDigest(paramString4.getBytes()), paramIWepkgUpdateCallback);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(859L, 0L, 1L, false);
        AppMethodBeat.o(110614);
        return;
        bool1 = true;
        for (;;)
        {
          i = 1;
          bool2 = bool3;
          break;
          if (!ax.iO(ai.getContext()))
          {
            bool1 = bool6;
            if (!ax.is3G(ai.getContext())) {}
          }
          else
          {
            bool1 = true;
          }
          i = 1;
          bool2 = bool3;
          break;
          bool1 = bool5;
          i = j;
          bool2 = bool3;
          if (!ax.isWifi(ai.getContext())) {
            break;
          }
          bool1 = true;
          bool2 = true;
          i = j;
          break;
          if (ax.isWifi(ai.getContext()))
          {
            bool1 = true;
          }
          else if (!ax.iO(ai.getContext()))
          {
            bool1 = bool4;
            if (!ax.is3G(ai.getContext())) {}
          }
          else
          {
            bool1 = bool4;
            if (com.tencent.mm.plugin.wepkg.utils.d.eJm()) {
              bool1 = true;
            }
          }
        }
        a.a.eJj().y(paramString1, paramString4, 0L);
        break label660;
      }
      label982:
      if (paramIWepkgUpdateCallback != null) {
        paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.Dai);
      }
      AppMethodBeat.o(110614);
      return;
      label1007:
      ac.i("MicroMsg.Wepkg.WepkgDownloader", "net is not match, dont download");
      if (paramIWepkgUpdateCallback != null) {
        paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.Dai);
      }
      AppMethodBeat.o(110614);
      return;
    }
  }
  
  public final void a(String paramString, final IWepkgUpdateCallback paramIWepkgUpdateCallback)
  {
    final WepkgVersion localWepkgVersion;
    String str;
    try
    {
      AppMethodBeat.i(110611);
      localWepkgVersion = com.tencent.mm.plugin.wepkg.model.i.aFr(paramString);
      if (localWepkgVersion == null)
      {
        ac.e("MicroMsg.Wepkg.WepkgDownloader", "downloadWepkg, wepkgVersion is null");
        AppMethodBeat.o(110611);
      }
      for (;;)
      {
        return;
        str = kN(paramString, localWepkgVersion.version);
        if ((!com.tencent.mm.vfs.i.eA(str)) || (!bs.nullAsNil(com.tencent.mm.vfs.i.aKe(str)).equals(localWepkgVersion.md5))) {
          break;
        }
        ac.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", new Object[] { localWepkgVersion.version, str });
        a.a.eJj().y(paramString, localWepkgVersion.downloadUrl, 0L);
        if (paramIWepkgUpdateCallback != null) {
          paramIWepkgUpdateCallback.a(paramString, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.Dad);
        }
        AppMethodBeat.o(110611);
      }
      locala = com.tencent.mm.plugin.wepkg.b.b.eIR().aEV(paramString);
    }
    finally {}
    final com.tencent.mm.plugin.wepkg.b.a locala;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (locala != null)
    {
      ac.i("MicroMsg.Wepkg.WepkgDownloader", "diff is not null, pkgId: %s", new Object[] { paramString });
      if (bs.nullAsNil(locala.field_version).equals(localWepkgVersion.version)) {
        break label382;
      }
      ac.i("MicroMsg.Wepkg.WepkgDownloader", "diff version is not equal to package version, pkgId: %s, diffVersion: %s, packageVersion: %s", new Object[] { paramString, locala.field_version, localWepkgVersion.version });
      com.tencent.mm.plugin.wepkg.b.b.eIR().zB(paramString);
      bool1 = bool2;
    }
    for (;;)
    {
      ac.i("MicroMsg.Wepkg.WepkgDownloader", "downloadBigPackage, downloadDiff = %b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        com.tencent.mm.plugin.report.service.h.wUl.dB(859, 22);
        paramString = new IWepkgUpdateCallback()
        {
          public final void a(String paramAnonymousString1, String paramAnonymousString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymousRetCode)
          {
            AppMethodBeat.i(110602);
            String str = WePkgDownloader.kO(paramAnonymousString1, localWepkgVersion.version);
            if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.Dad)
            {
              com.tencent.mm.plugin.report.service.h.wUl.dB(859, 24);
              boolean bool = WePkgDownloader.i(paramAnonymousString1, str, locala.field_oldPath, paramAnonymousString2, localWepkgVersion.md5);
              com.tencent.mm.vfs.i.deleteFile(paramAnonymousString2);
              com.tencent.mm.plugin.wepkg.b.b.eIR().zB(paramAnonymousString1);
              if (bool)
              {
                paramIWepkgUpdateCallback.a(paramAnonymousString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.Dad);
                AppMethodBeat.o(110602);
                return;
              }
              WePkgDownloader.this.a(paramAnonymousString1, paramIWepkgUpdateCallback);
              AppMethodBeat.o(110602);
              return;
            }
            if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.Dai)
            {
              paramIWepkgUpdateCallback.a(paramAnonymousString1, str, paramAnonymousRetCode);
              AppMethodBeat.o(110602);
              return;
            }
            if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.Dah) {
              com.tencent.mm.plugin.report.service.h.wUl.dB(859, 23);
            }
            for (;;)
            {
              com.tencent.mm.vfs.i.deleteFile(paramAnonymousString2);
              com.tencent.mm.plugin.wepkg.b.b.eIR().zB(paramAnonymousString1);
              WePkgDownloader.this.a(paramAnonymousString1, paramIWepkgUpdateCallback);
              AppMethodBeat.o(110602);
              return;
              if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.Daf) {
                com.tencent.mm.plugin.report.service.h.wUl.dB(859, 25);
              } else if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.Dae) {
                com.tencent.mm.plugin.report.service.h.wUl.dB(859, 26);
              }
            }
          }
        };
        paramIWepkgUpdateCallback = com.tencent.mm.plugin.wepkg.model.d.kP(locala.field_pkgId, locala.field_version);
        com.tencent.mm.plugin.wepkg.utils.d.aFC(paramIWepkgUpdateCallback);
        paramIWepkgUpdateCallback = paramIWepkgUpdateCallback + "/diff";
        a(3, locala.field_pkgId, paramIWepkgUpdateCallback, "", locala.field_downloadUrl, locala.field_pkgSize, locala.field_version, locala.field_oldVersion, locala.field_md5, locala.field_downloadNetType, paramString);
        AppMethodBeat.o(110611);
        break;
        label382:
        if (bs.isNullOrNil(locala.field_downloadUrl))
        {
          ac.i("MicroMsg.Wepkg.WepkgDownloader", "diff downloadurl is null, pkgId: %s, diffVersion: %s", new Object[] { paramString, locala.field_version });
          com.tencent.mm.plugin.wepkg.b.b.eIR().zB(paramString);
          bool1 = bool2;
          continue;
        }
        if (com.tencent.mm.vfs.i.eA(locala.field_oldPath)) {
          break label532;
        }
        ac.i("MicroMsg.Wepkg.WepkgDownloader", "old package is not exists, pkgId: %s, oldPath: %s", new Object[] { paramString, locala.field_oldPath });
        com.tencent.mm.plugin.wepkg.b.b.eIR().zB(paramString);
        bool1 = bool2;
        continue;
      }
      a(1, localWepkgVersion.fYR, str, "", localWepkgVersion.downloadUrl, localWepkgVersion.DbH, localWepkgVersion.version, "", localWepkgVersion.md5, localWepkgVersion.DaM, paramIWepkgUpdateCallback);
      AppMethodBeat.o(110611);
      break;
      label532:
      bool1 = true;
    }
  }
  
  public static abstract interface IWepkgUpdateCallback
  {
    public abstract void a(String paramString1, String paramString2, RetCode paramRetCode);
    
    public static enum RetCode
      implements Parcelable
    {
      public static final Parcelable.Creator<RetCode> CREATOR;
      
      static
      {
        AppMethodBeat.i(110608);
        Dad = new RetCode("OK", 0);
        Dae = new RetCode("LOCAL_FILE_NOT_FOUND", 1);
        Daf = new RetCode("PKG_INTEGRITY_FAILED", 2);
        Dag = new RetCode("PKG_INVALID", 3);
        Dah = new RetCode("FAILED", 4);
        Dai = new RetCode("CANCEL", 5);
        Daj = new RetCode[] { Dad, Dae, Daf, Dag, Dah, Dai };
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(110608);
      }
      
      private RetCode() {}
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(110607);
        paramParcel.writeInt(ordinal());
        AppMethodBeat.o(110607);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader
 * JD-Core Version:    0.7.0.1
 */