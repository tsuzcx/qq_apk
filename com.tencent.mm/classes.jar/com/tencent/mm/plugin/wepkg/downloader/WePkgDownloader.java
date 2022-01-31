package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.wepkg.c.a.a;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WePkgDownloader
{
  private static volatile WePkgDownloader vFc = null;
  private Map<String, WePkgDownloader.IWepkgUpdateCallback> vFd;
  private a vFe;
  
  public WePkgDownloader()
  {
    AppMethodBeat.i(63439);
    this.vFe = new WePkgDownloader.2(this);
    if (this.vFd == null) {
      this.vFd = new ConcurrentHashMap();
    }
    AppMethodBeat.o(63439);
  }
  
  private void a(File paramFile, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(63444);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(63444);
      return;
    }
    if ((paramFile.isFile()) && (paramFile.getName().equals(paramString)))
    {
      paramString = paramList;
      if (paramList == null) {
        paramString = new ArrayList();
      }
      paramString.add(paramFile.getAbsolutePath());
      AppMethodBeat.o(63444);
      return;
    }
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int i = 0;
        while (i < paramFile.length)
        {
          a(paramFile[i], paramString, paramList);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(63444);
  }
  
  public static WePkgDownloader dky()
  {
    AppMethodBeat.i(63438);
    if (vFc == null) {}
    try
    {
      if (vFc == null) {
        vFc = new WePkgDownloader();
      }
      WePkgDownloader localWePkgDownloader = vFc;
      AppMethodBeat.o(63438);
      return localWePkgDownloader;
    }
    finally
    {
      AppMethodBeat.o(63438);
    }
  }
  
  private static boolean f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63441);
    l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        i = ((IBSPatchJNIService)com.tencent.mm.kernel.g.E(IBSPatchJNIService.class)).bspatch(paramString3, paramString2, paramString4);
        l2 = System.currentTimeMillis() - l1;
        ab.i("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPackage, result: %d, cost: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l2) });
        if (i != 0) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.qsU.cT(859, 34);
        boolean bool;
        if (bo.isNullOrNil(paramString5))
        {
          bool = true;
          if (bool)
          {
            com.tencent.mm.plugin.wepkg.utils.a.c(paramString1, 0, "", l2);
            AppMethodBeat.o(63441);
            return true;
          }
        }
        else
        {
          String str = com.tencent.mm.vfs.e.avP(paramString2);
          if (bo.isNullOrNil(str))
          {
            bool = false;
            continue;
          }
          ab.i("MicroMsg.Wepkg.WepkgDownloader", "matchMd5, fileMd5: %s, md5: %s", new Object[] { str, paramString5 });
          bool = paramString5.trim().equalsIgnoreCase(str.trim());
          continue;
        }
        com.tencent.mm.plugin.report.service.h.qsU.cT(859, 35);
        com.tencent.mm.plugin.wepkg.utils.a.c(paramString1, 2007, "", l2);
      }
      catch (Exception paramString5)
      {
        int i;
        long l2 = System.currentTimeMillis();
        ab.e("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", new Object[] { paramString5, paramString3, paramString2, paramString4 });
        ab.printErrStackTrace("MicroMsg.Wepkg.WepkgDownloader", paramString5, "", new Object[0]);
        com.tencent.mm.plugin.report.service.h.qsU.cT(859, 33);
        com.tencent.mm.plugin.wepkg.utils.a.c(paramString1, 2006, "", l2 - l1);
        continue;
      }
      AppMethodBeat.o(63441);
      return false;
      com.tencent.mm.plugin.report.service.h.qsU.cT(859, 27);
      com.tencent.mm.plugin.report.service.h.qsU.cT(859, 25 - i);
      com.tencent.mm.plugin.wepkg.utils.a.c(paramString1, 1998 - i, "", l2);
    }
  }
  
  private static String hL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63442);
    paramString1 = com.tencent.mm.plugin.wepkg.model.c.hN(paramString1, paramString2);
    com.tencent.mm.plugin.wepkg.utils.d.akQ(paramString1);
    paramString1 = paramString1 + "/package";
    AppMethodBeat.o(63442);
    return paramString1;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt2, WePkgDownloader.IWepkgUpdateCallback paramIWepkgUpdateCallback)
  {
    AppMethodBeat.i(63443);
    ab.i("MicroMsg.Wepkg.WepkgDownloader", "triggerDownloadWepkg, fileType:%s, pkgid:%s, downloadUrl:%s, pkgSize:%d, version:%s, md5:%s, downloadNetType:%d", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString4, Long.valueOf(paramLong), paramString5, paramString7, Integer.valueOf(paramInt2) });
    if (paramInt1 == 2)
    {
      paramString2 = com.tencent.mm.plugin.wepkg.model.c.hN(paramString1, paramString5) + "/preload_files";
      com.tencent.mm.plugin.wepkg.utils.d.akQ(paramString2);
    }
    for (String str = paramString2 + "/" + paramString7;; str = paramString2)
    {
      if (bo.isNullOrNil(str))
      {
        ab.i("MicroMsg.Wepkg.WepkgDownloader", "pkgPath:%s is null", new Object[] { str });
        a.a.dkF().p(paramString1, paramString4, 0L);
        if (paramIWepkgUpdateCallback != null) {
          paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.vFn);
        }
        AppMethodBeat.o(63443);
        return;
      }
      if (com.tencent.mm.pluginsdk.g.a.d.a.cN(str))
      {
        if (bo.nullAsNil(com.tencent.mm.a.g.getMD5(str)).equals(paramString7))
        {
          ab.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", new Object[] { paramString5, str });
          a.a.dkF().p(paramString1, paramString4, 0L);
          if (paramIWepkgUpdateCallback != null) {
            paramIWepkgUpdateCallback.a(paramString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.vFj);
          }
          AppMethodBeat.o(63443);
        }
      }
      else
      {
        paramString2 = com.tencent.mm.plugin.wepkg.model.c.akz(paramString1);
        if (!bo.isNullOrNil(paramString2))
        {
          File localFile = new File(paramString2);
          ArrayList localArrayList = new ArrayList();
          if ((str == null) || (str.length() <= 0)) {
            paramString2 = "";
          }
          for (;;)
          {
            a(localFile, paramString2, localArrayList);
            ab.i("MicroMsg.Wepkg.WepkgDownloader", "local have the same file. size:%s", new Object[] { Integer.valueOf(localArrayList.size()) });
            paramString2 = localArrayList.iterator();
            do
            {
              if (!paramString2.hasNext()) {
                break;
              }
              localObject = new File((String)paramString2.next());
            } while ((!((File)localObject).isFile()) || (((File)localObject).length() != paramLong) || (!bo.nullAsNil(com.tencent.mm.a.g.r((File)localObject)).equalsIgnoreCase(paramString7)));
            com.tencent.mm.a.e.C(((File)localObject).getAbsolutePath(), str);
            ab.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in other version path:%s, pkgPath:%s", new Object[] { ((File)localObject).getAbsolutePath(), str });
            a.a.dkF().p(paramString1, paramString4, 0L);
            if (paramIWepkgUpdateCallback != null) {
              paramIWepkgUpdateCallback.a(paramString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.vFj);
            }
            AppMethodBeat.o(63443);
            return;
            Object localObject = new File(str).getName();
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
          a.a.dkF().p(paramString1, paramString4, paramLong);
          label648:
          ab.i("MicroMsg.Wepkg.WepkgDownloader", "allowDownload:%s", new Object[] { Boolean.valueOf(bool1) });
          if (!bool1) {
            break label995;
          }
          paramString2 = new c(new f(com.tencent.mm.a.g.w(paramString4.getBytes()), paramInt1, paramString1, paramString3, paramString5, paramString6, paramString4, str, paramLong, paramString7, bool2, this.vFe));
          paramString3 = d.dkx();
          if (paramString3.vFb.containsKey(paramString2.vER.vFr)) {
            break label965;
          }
          paramString2.vES = b.dkv().vEQ.submit(paramString2);
          paramString3.vFb.put(paramString2.vER.vFr, paramString2);
        }
        break;
      }
      label965:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label970;
        }
        this.vFd.put(com.tencent.mm.a.g.w(paramString4.getBytes()), paramIWepkgUpdateCallback);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(859L, 0L, 1L, false);
        AppMethodBeat.o(63443);
        return;
        bool1 = true;
        for (;;)
        {
          i = 1;
          bool2 = bool3;
          break;
          if (!at.ha(ah.getContext()))
          {
            bool1 = bool6;
            if (!at.is3G(ah.getContext())) {}
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
          if (!at.isWifi(ah.getContext())) {
            break;
          }
          bool1 = true;
          bool2 = true;
          i = j;
          break;
          if (at.isWifi(ah.getContext()))
          {
            bool1 = true;
          }
          else if (!at.ha(ah.getContext()))
          {
            bool1 = bool4;
            if (!at.is3G(ah.getContext())) {}
          }
          else
          {
            bool1 = bool4;
            if (com.tencent.mm.plugin.wepkg.utils.d.dkI()) {
              bool1 = true;
            }
          }
        }
        a.a.dkF().p(paramString1, paramString4, 0L);
        break label648;
      }
      label970:
      if (paramIWepkgUpdateCallback != null) {
        paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.vFo);
      }
      AppMethodBeat.o(63443);
      return;
      label995:
      ab.i("MicroMsg.Wepkg.WepkgDownloader", "net is not match, dont download");
      if (paramIWepkgUpdateCallback != null) {
        paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.vFo);
      }
      AppMethodBeat.o(63443);
      return;
    }
  }
  
  public final void a(String paramString, WePkgDownloader.IWepkgUpdateCallback paramIWepkgUpdateCallback)
  {
    AppMethodBeat.i(63440);
    WepkgVersion localWepkgVersion = com.tencent.mm.plugin.wepkg.model.h.akF(paramString);
    if (localWepkgVersion == null)
    {
      ab.e("MicroMsg.Wepkg.WepkgDownloader", "downloadWepkg, wepkgVersion is null");
      AppMethodBeat.o(63440);
      return;
    }
    String str = hL(paramString, localWepkgVersion.version);
    if ((com.tencent.mm.vfs.e.cN(str)) && (bo.nullAsNil(com.tencent.mm.a.g.getMD5(str)).equals(localWepkgVersion.cqq)))
    {
      ab.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", new Object[] { localWepkgVersion.version, str });
      a.a.dkF().p(paramString, localWepkgVersion.downloadUrl, 0L);
      if (paramIWepkgUpdateCallback != null) {
        paramIWepkgUpdateCallback.a(paramString, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.vFj);
      }
      AppMethodBeat.o(63440);
      return;
    }
    com.tencent.mm.plugin.wepkg.b.a locala = com.tencent.mm.plugin.wepkg.b.b.dko().akl(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (locala != null)
    {
      ab.i("MicroMsg.Wepkg.WepkgDownloader", "diff is not null, pkgId: %s", new Object[] { paramString });
      if (bo.nullAsNil(locala.field_version).equals(localWepkgVersion.version)) {
        break label369;
      }
      ab.i("MicroMsg.Wepkg.WepkgDownloader", "diff version is not equal to package version, pkgId: %s, diffVersion: %s, packageVersion: %s", new Object[] { paramString, locala.field_version, localWepkgVersion.version });
      com.tencent.mm.plugin.wepkg.b.b.dko().qD(paramString);
      bool1 = bool2;
    }
    for (;;)
    {
      ab.i("MicroMsg.Wepkg.WepkgDownloader", "downloadBigPackage, downloadDiff = %b", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.qsU.cT(859, 22);
      paramString = new WePkgDownloader.1(this, localWepkgVersion, locala, paramIWepkgUpdateCallback);
      paramIWepkgUpdateCallback = com.tencent.mm.plugin.wepkg.model.c.hN(locala.field_pkgId, locala.field_version);
      com.tencent.mm.plugin.wepkg.utils.d.akQ(paramIWepkgUpdateCallback);
      paramIWepkgUpdateCallback = paramIWepkgUpdateCallback + "/diff";
      a(3, locala.field_pkgId, paramIWepkgUpdateCallback, "", locala.field_downloadUrl, locala.field_pkgSize, locala.field_version, locala.field_oldVersion, locala.field_md5, locala.field_downloadNetType, paramString);
      AppMethodBeat.o(63440);
      return;
      label369:
      if (bo.isNullOrNil(locala.field_downloadUrl))
      {
        ab.i("MicroMsg.Wepkg.WepkgDownloader", "diff downloadurl is null, pkgId: %s, diffVersion: %s", new Object[] { paramString, locala.field_version });
        com.tencent.mm.plugin.wepkg.b.b.dko().qD(paramString);
        bool1 = bool2;
      }
      else if (!com.tencent.mm.vfs.e.cN(locala.field_oldPath))
      {
        ab.i("MicroMsg.Wepkg.WepkgDownloader", "old package is not exists, pkgId: %s, oldPath: %s", new Object[] { paramString, locala.field_oldPath });
        com.tencent.mm.plugin.wepkg.b.b.dko().qD(paramString);
        bool1 = bool2;
      }
      else
      {
        bool1 = true;
      }
    }
    a(1, localWepkgVersion.ezY, str, "", localWepkgVersion.downloadUrl, localWepkgVersion.vGO, localWepkgVersion.version, "", localWepkgVersion.cqq, localWepkgVersion.vFT, paramIWepkgUpdateCallback);
    AppMethodBeat.o(63440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader
 * JD-Core Version:    0.7.0.1
 */