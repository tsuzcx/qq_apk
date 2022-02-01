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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static volatile WePkgDownloader EDV = null;
  private Map<String, IWepkgUpdateCallback> EDW;
  private a EDX;
  
  public WePkgDownloader()
  {
    AppMethodBeat.i(110610);
    this.EDX = new a()
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
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 2L, 1L, false);
              localObject1 = paramAnonymousg.EDK.mFilePath;
              if ((bt.isNullOrNil((String)localObject1)) || (!new e((String)localObject1).exists()))
              {
                ad.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, pkgPath is null or nil");
                localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.EEd;
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 4L, 1L, false);
                ad.i("MicroMsg.Wepkg.WepkgDownloader", "download callback retCode:".concat(String.valueOf(localObject1)));
                localObject2 = (WePkgDownloader.IWepkgUpdateCallback)WePkgDownloader.a(WePkgDownloader.this).remove(paramAnonymousg.EDK.EEk);
                if (localObject2 != null)
                {
                  ((WePkgDownloader.IWepkgUpdateCallback)localObject2).a(paramAnonymousg.EDK.EEl, paramAnonymousg.EDK.mFilePath, (WePkgDownloader.IWepkgUpdateCallback.RetCode)localObject1);
                  if ((paramAnonymousg.EDK.pmx != 1) && (paramAnonymousg.EDK.pmx != 3)) {
                    break label401;
                  }
                  localObject1 = paramAnonymousg.EDK.EEl;
                  localObject2 = new WepkgCrossProcessTask();
                  ((WepkgCrossProcessTask)localObject2).EN = 3008;
                  ((WepkgCrossProcessTask)localObject2).EET.gsn = ((String)localObject1);
                  if (!aj.cnC()) {
                    break label393;
                  }
                  ((WepkgCrossProcessTask)localObject2).aOA();
                  WePkgDownloader.b(paramAnonymousg);
                  d.eXT().aKG(paramAnonymousg.EDK.EEk);
                  AppMethodBeat.o(110603);
                }
              }
              else
              {
                localObject2 = paramAnonymousg.EDK.ksR;
                localObject3 = com.tencent.mm.vfs.i.aPK((String)localObject1);
                if (!bt.nullAsNil((String)localObject3).equalsIgnoreCase((String)localObject2))
                {
                  ad.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, file.md5(%s) != net.md5(%s)", new Object[] { localObject3, localObject2 });
                  com.tencent.mm.vfs.i.deleteFile((String)localObject1);
                  localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.EEe;
                  paramAnonymousg.pZU = 1012;
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 3L, 1L, false);
                  continue;
                }
                localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.EEc;
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 5L, 1L, false);
                continue;
              }
            }
            else
            {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 1L, 1L, false);
              localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.EEg;
              continue;
            }
            ad.i("MicroMsg.Wepkg.WepkgDownloader", "download callback invalid");
            com.tencent.mm.plugin.wepkg.utils.a.b("CallbackInvalid", paramAnonymousg.EDK.mUrl, paramAnonymousg.EDK.EEl, null, -1L, 0L, null);
            continue;
            AppBrandMainProcessService.b((MainProcessTask)localObject2);
          }
          finally {}
          label393:
          continue;
          label401:
          Object localObject1 = paramAnonymousg.EDK.EEl;
          Object localObject2 = paramAnonymousg.EDK.EEm;
          Object localObject3 = new WepkgCrossProcessTask();
          ((WepkgCrossProcessTask)localObject3).EN = 4005;
          ((WepkgCrossProcessTask)localObject3).EEW.gsn = ((String)localObject1);
          ((WepkgCrossProcessTask)localObject3).EEW.EEZ = ((String)localObject2);
          if (aj.cnC()) {
            ((WepkgCrossProcessTask)localObject3).aOA();
          } else {
            AppBrandMainProcessService.b((MainProcessTask)localObject3);
          }
        }
      }
    };
    if (this.EDW == null) {
      this.EDW = new ConcurrentHashMap();
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
      paramString.add(q.B(parame.fOK()));
      AppMethodBeat.o(177087);
      return;
    }
    if (parame.isDirectory())
    {
      parame = parame.fOM();
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
  
  public static WePkgDownloader eXU()
  {
    AppMethodBeat.i(110609);
    if (EDV == null) {}
    try
    {
      if (EDV == null) {
        EDV = new WePkgDownloader();
      }
      WePkgDownloader localWePkgDownloader = EDV;
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
        ad.i("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPackage, result: %d, cost: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l2) });
        if (i != 0) {
          continue;
        }
        com.tencent.mm.plugin.report.service.g.yhR.dD(859, 34);
        boolean bool;
        if (bt.isNullOrNil(paramString5))
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
          String str = com.tencent.mm.vfs.i.aPK(paramString2);
          if (bt.isNullOrNil(str))
          {
            bool = false;
            continue;
          }
          ad.i("MicroMsg.Wepkg.WepkgDownloader", "matchMd5, fileMd5: %s, md5: %s", new Object[] { str, paramString5 });
          bool = paramString5.trim().equalsIgnoreCase(str.trim());
          continue;
        }
        com.tencent.mm.plugin.report.service.g.yhR.dD(859, 35);
        com.tencent.mm.plugin.wepkg.utils.a.c(paramString1, 2007, "", l2);
      }
      catch (Exception paramString5)
      {
        int i;
        long l2 = System.currentTimeMillis();
        ad.e("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", new Object[] { paramString5, paramString3, paramString2, paramString4 });
        ad.printErrStackTrace("MicroMsg.Wepkg.WepkgDownloader", paramString5, "", new Object[0]);
        com.tencent.mm.plugin.report.service.g.yhR.dD(859, 33);
        com.tencent.mm.plugin.wepkg.utils.a.c(paramString1, 2006, "", l2 - l1);
        continue;
      }
      AppMethodBeat.o(110612);
      return false;
      com.tencent.mm.plugin.report.service.g.yhR.dD(859, 27);
      com.tencent.mm.plugin.report.service.g.yhR.dD(859, 25 - i);
      com.tencent.mm.plugin.wepkg.utils.a.c(paramString1, 1998 - i, "", l2);
    }
  }
  
  private static String lk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110613);
    paramString1 = com.tencent.mm.plugin.wepkg.model.d.lm(paramString1, paramString2);
    com.tencent.mm.plugin.wepkg.utils.d.aLc(paramString1);
    paramString1 = paramString1 + "/package";
    AppMethodBeat.o(110613);
    return paramString1;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt2, IWepkgUpdateCallback paramIWepkgUpdateCallback)
  {
    AppMethodBeat.i(110614);
    ad.i("MicroMsg.Wepkg.WepkgDownloader", "triggerDownloadWepkg, fileType:%s, pkgid:%s, downloadUrl:%s, pkgSize:%d, version:%s, md5:%s, downloadNetType:%d", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString4, Long.valueOf(paramLong), paramString5, paramString7, Integer.valueOf(paramInt2) });
    if (paramInt1 == 2)
    {
      paramString2 = com.tencent.mm.plugin.wepkg.model.d.lm(paramString1, paramString5) + "/preload_files";
      com.tencent.mm.plugin.wepkg.utils.d.aLc(paramString2);
    }
    for (String str = paramString2 + "/" + paramString7;; str = paramString2)
    {
      if (bt.isNullOrNil(str))
      {
        ad.i("MicroMsg.Wepkg.WepkgDownloader", "pkgPath:%s is null", new Object[] { str });
        a.a.eYd().m(paramString1, paramString4, 0L);
        if (paramIWepkgUpdateCallback != null) {
          paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.EEg);
        }
        AppMethodBeat.o(110614);
        return;
      }
      if (com.tencent.mm.pluginsdk.j.a.d.a.fv(str))
      {
        if (bt.nullAsNil(com.tencent.mm.vfs.i.aPK(str)).equals(paramString7))
        {
          ad.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", new Object[] { paramString5, str });
          a.a.eYd().m(paramString1, paramString4, 0L);
          if (paramIWepkgUpdateCallback != null) {
            paramIWepkgUpdateCallback.a(paramString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.EEc);
          }
          AppMethodBeat.o(110614);
        }
      }
      else
      {
        paramString2 = com.tencent.mm.plugin.wepkg.model.d.aKI(paramString1);
        if (!bt.isNullOrNil(paramString2))
        {
          e locale = new e(paramString2);
          ArrayList localArrayList = new ArrayList();
          if ((str == null) || (str.length() <= 0)) {
            paramString2 = "";
          }
          for (;;)
          {
            a(locale, paramString2, localArrayList);
            ad.i("MicroMsg.Wepkg.WepkgDownloader", "local have the same file. size:%s", new Object[] { Integer.valueOf(localArrayList.size()) });
            paramString2 = localArrayList.iterator();
            do
            {
              if (!paramString2.hasNext()) {
                break;
              }
              localObject = new e((String)paramString2.next());
            } while ((!((e)localObject).isFile()) || (((e)localObject).length() != paramLong) || (!bt.nullAsNil(com.tencent.mm.vfs.i.aPK(q.B(((e)localObject).mUri))).equalsIgnoreCase(paramString7)));
            com.tencent.mm.vfs.i.mz(q.B(((e)localObject).fOK()), str);
            ad.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in other version path:%s, pkgPath:%s", new Object[] { q.B(((e)localObject).fOK()), str });
            a.a.eYd().m(paramString1, paramString4, 0L);
            if (paramIWepkgUpdateCallback != null) {
              paramIWepkgUpdateCallback.a(paramString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.EEc);
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
          a.a.eYd().m(paramString1, paramString4, paramLong);
          label660:
          ad.i("MicroMsg.Wepkg.WepkgDownloader", "allowDownload:%s", new Object[] { Boolean.valueOf(bool1) });
          if (!bool1) {
            break label1007;
          }
          paramString2 = new c(new f(com.tencent.mm.b.g.getMessageDigest(paramString4.getBytes()), paramInt1, paramString1, paramString3, paramString5, paramString6, paramString4, str, paramLong, paramString7, bool2, this.EDX));
          paramString3 = d.eXT();
          if (paramString3.EDU.containsKey(paramString2.EDK.EEk)) {
            break label977;
          }
          paramString2.EDL = b.eXR().EDJ.submit(paramString2);
          paramString3.EDU.put(paramString2.EDK.EEk, paramString2);
        }
        break;
      }
      label977:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label982;
        }
        this.EDW.put(com.tencent.mm.b.g.getMessageDigest(paramString4.getBytes()), paramIWepkgUpdateCallback);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 0L, 1L, false);
        AppMethodBeat.o(110614);
        return;
        bool1 = true;
        for (;;)
        {
          i = 1;
          bool2 = bool3;
          break;
          if (!ay.iY(aj.getContext()))
          {
            bool1 = bool6;
            if (!ay.is3G(aj.getContext())) {}
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
          if (!ay.isWifi(aj.getContext())) {
            break;
          }
          bool1 = true;
          bool2 = true;
          i = j;
          break;
          if (ay.isWifi(aj.getContext()))
          {
            bool1 = true;
          }
          else if (!ay.iY(aj.getContext()))
          {
            bool1 = bool4;
            if (!ay.is3G(aj.getContext())) {}
          }
          else
          {
            bool1 = bool4;
            if (com.tencent.mm.plugin.wepkg.utils.d.eYg()) {
              bool1 = true;
            }
          }
        }
        a.a.eYd().m(paramString1, paramString4, 0L);
        break label660;
      }
      label982:
      if (paramIWepkgUpdateCallback != null) {
        paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.EEh);
      }
      AppMethodBeat.o(110614);
      return;
      label1007:
      ad.i("MicroMsg.Wepkg.WepkgDownloader", "net is not match, dont download");
      if (paramIWepkgUpdateCallback != null) {
        paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.EEh);
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
      localWepkgVersion = com.tencent.mm.plugin.wepkg.model.i.aKR(paramString);
      if (localWepkgVersion == null)
      {
        ad.e("MicroMsg.Wepkg.WepkgDownloader", "downloadWepkg, wepkgVersion is null");
        AppMethodBeat.o(110611);
      }
      for (;;)
      {
        return;
        str = lk(paramString, localWepkgVersion.version);
        if ((!com.tencent.mm.vfs.i.fv(str)) || (!bt.nullAsNil(com.tencent.mm.vfs.i.aPK(str)).equals(localWepkgVersion.md5))) {
          break;
        }
        ad.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", new Object[] { localWepkgVersion.version, str });
        a.a.eYd().m(paramString, localWepkgVersion.downloadUrl, 0L);
        if (paramIWepkgUpdateCallback != null) {
          paramIWepkgUpdateCallback.a(paramString, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.EEc);
        }
        AppMethodBeat.o(110611);
      }
      locala = com.tencent.mm.plugin.wepkg.b.b.eXL().aKv(paramString);
    }
    finally {}
    final com.tencent.mm.plugin.wepkg.b.a locala;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (locala != null)
    {
      ad.i("MicroMsg.Wepkg.WepkgDownloader", "diff is not null, pkgId: %s", new Object[] { paramString });
      if (bt.nullAsNil(locala.field_version).equals(localWepkgVersion.version)) {
        break label382;
      }
      ad.i("MicroMsg.Wepkg.WepkgDownloader", "diff version is not equal to package version, pkgId: %s, diffVersion: %s, packageVersion: %s", new Object[] { paramString, locala.field_version, localWepkgVersion.version });
      com.tencent.mm.plugin.wepkg.b.b.eXL().CA(paramString);
      bool1 = bool2;
    }
    for (;;)
    {
      ad.i("MicroMsg.Wepkg.WepkgDownloader", "downloadBigPackage, downloadDiff = %b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        com.tencent.mm.plugin.report.service.g.yhR.dD(859, 22);
        paramString = new IWepkgUpdateCallback()
        {
          public final void a(String paramAnonymousString1, String paramAnonymousString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymousRetCode)
          {
            AppMethodBeat.i(110602);
            String str = WePkgDownloader.ll(paramAnonymousString1, localWepkgVersion.version);
            if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.EEc)
            {
              com.tencent.mm.plugin.report.service.g.yhR.dD(859, 24);
              boolean bool = WePkgDownloader.i(paramAnonymousString1, str, locala.field_oldPath, paramAnonymousString2, localWepkgVersion.md5);
              com.tencent.mm.vfs.i.deleteFile(paramAnonymousString2);
              com.tencent.mm.plugin.wepkg.b.b.eXL().CA(paramAnonymousString1);
              if (bool)
              {
                paramIWepkgUpdateCallback.a(paramAnonymousString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.EEc);
                AppMethodBeat.o(110602);
                return;
              }
              WePkgDownloader.this.a(paramAnonymousString1, paramIWepkgUpdateCallback);
              AppMethodBeat.o(110602);
              return;
            }
            if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.EEh)
            {
              paramIWepkgUpdateCallback.a(paramAnonymousString1, str, paramAnonymousRetCode);
              AppMethodBeat.o(110602);
              return;
            }
            if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.EEg) {
              com.tencent.mm.plugin.report.service.g.yhR.dD(859, 23);
            }
            for (;;)
            {
              com.tencent.mm.vfs.i.deleteFile(paramAnonymousString2);
              com.tencent.mm.plugin.wepkg.b.b.eXL().CA(paramAnonymousString1);
              WePkgDownloader.this.a(paramAnonymousString1, paramIWepkgUpdateCallback);
              AppMethodBeat.o(110602);
              return;
              if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.EEe) {
                com.tencent.mm.plugin.report.service.g.yhR.dD(859, 25);
              } else if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.EEd) {
                com.tencent.mm.plugin.report.service.g.yhR.dD(859, 26);
              }
            }
          }
        };
        paramIWepkgUpdateCallback = com.tencent.mm.plugin.wepkg.model.d.lm(locala.field_pkgId, locala.field_version);
        com.tencent.mm.plugin.wepkg.utils.d.aLc(paramIWepkgUpdateCallback);
        paramIWepkgUpdateCallback = paramIWepkgUpdateCallback + "/diff";
        a(3, locala.field_pkgId, paramIWepkgUpdateCallback, "", locala.field_downloadUrl, locala.field_pkgSize, locala.field_version, locala.field_oldVersion, locala.field_md5, locala.field_downloadNetType, paramString);
        AppMethodBeat.o(110611);
        break;
        label382:
        if (bt.isNullOrNil(locala.field_downloadUrl))
        {
          ad.i("MicroMsg.Wepkg.WepkgDownloader", "diff downloadurl is null, pkgId: %s, diffVersion: %s", new Object[] { paramString, locala.field_version });
          com.tencent.mm.plugin.wepkg.b.b.eXL().CA(paramString);
          bool1 = bool2;
          continue;
        }
        if (com.tencent.mm.vfs.i.fv(locala.field_oldPath)) {
          break label532;
        }
        ad.i("MicroMsg.Wepkg.WepkgDownloader", "old package is not exists, pkgId: %s, oldPath: %s", new Object[] { paramString, locala.field_oldPath });
        com.tencent.mm.plugin.wepkg.b.b.eXL().CA(paramString);
        bool1 = bool2;
        continue;
      }
      a(1, localWepkgVersion.gsn, str, "", localWepkgVersion.downloadUrl, localWepkgVersion.EFG, localWepkgVersion.version, "", localWepkgVersion.md5, localWepkgVersion.EEL, paramIWepkgUpdateCallback);
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
        EEc = new RetCode("OK", 0);
        EEd = new RetCode("LOCAL_FILE_NOT_FOUND", 1);
        EEe = new RetCode("PKG_INTEGRITY_FAILED", 2);
        EEf = new RetCode("PKG_INVALID", 3);
        EEg = new RetCode("FAILED", 4);
        EEh = new RetCode("CANCEL", 5);
        EEi = new RetCode[] { EEc, EEd, EEe, EEf, EEg, EEh };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader
 * JD-Core Version:    0.7.0.1
 */