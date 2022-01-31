package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  public static e a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(63556);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString3)) || (bo.isNullOrNil(paramString4)))
    {
      ab.i("MicroMsg.Wepkg.WepkgManager", "pkgid or pkgPath or md5 is null, pkg invalid");
      AppMethodBeat.o(63556);
      return null;
    }
    File localFile = new File(paramString3);
    if (!localFile.exists())
    {
      ab.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", new Object[] { paramString3 });
      akE(paramString1);
      a.b("PkgModified", null, paramString1, paramString2, 1L, 0L, null);
      AppMethodBeat.o(63556);
      return null;
    }
    if (localFile.length() != paramInt)
    {
      ab.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(localFile.length()) });
      localFile.delete();
      akE(paramString1);
      a.b("PkgModified", null, paramString1, paramString2, 2L, 0L, null);
      AppMethodBeat.o(63556);
      return null;
    }
    if (localFile.length() <= 5242880L)
    {
      String str = com.tencent.mm.a.g.r(localFile);
      if (!paramString4.equalsIgnoreCase(str))
      {
        ab.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", new Object[] { paramString4, str });
        localFile.delete();
        akE(paramString1);
        a.b("PkgModified", null, paramString1, paramString2, 3L, 0L, null);
        AppMethodBeat.o(63556);
        return null;
      }
    }
    else
    {
      ab.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", new Object[] { Long.valueOf(localFile.length()), Long.valueOf(5242880L) });
    }
    ab.i("MicroMsg.Wepkg.WepkgManager", "this is big package. localPath: %s", new Object[] { paramString3 });
    paramString2 = new e(localFile);
    if ((paramString2.gVO) && (paramString2.vFY != null))
    {
      AppMethodBeat.o(63556);
      return paramString2;
    }
    b.dkA();
    b.ef(paramString1, 2);
    AppMethodBeat.o(63556);
    return null;
  }
  
  public static List<String> a(bml parambml)
  {
    AppMethodBeat.i(63555);
    if ((parambml == null) || (parambml.xAO == null))
    {
      AppMethodBeat.o(63555);
      return null;
    }
    Object localObject1 = parambml.xAO.yfU;
    Object localObject2 = parambml.xAO.yfV;
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 != null) && (((cyp)localObject1).yfG != null)) {
      localArrayList.add(ag.cE(parambml.nqD + ((cyp)localObject1).yfG.wxa));
    }
    if ((localObject2 != null) && (!bo.es(((cyw)localObject2).yfR)))
    {
      localObject1 = ((cyw)localObject2).yfR.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cyt)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((cyt)localObject2).yfG != null)) {
          localArrayList.add(ag.cE(parambml.nqD + ((cyt)localObject2).yfG.wxa));
        }
      }
    }
    AppMethodBeat.o(63555);
    return localArrayList;
  }
  
  public static void a(g.a parama)
  {
    AppMethodBeat.i(63557);
    String str = c.vFO;
    File localFile = new File(str);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      parama.ac(null);
    }
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.vA = 1001;
    localWepkgCrossProcessTask.hxp = new g.1(localWepkgCrossProcessTask, str, localFile, parama);
    localWepkgCrossProcessTask.aBj();
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(63557);
  }
  
  public static f akD(String paramString)
  {
    String str;
    Object localObject1;
    long l;
    WepkgVersion localWepkgVersion;
    label280:
    e locale;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(63554);
        ab.d("MicroMsg.Wepkg.WepkgManager", "loadWepkg");
        str = d.akM(paramString);
        localObject1 = d.akN(paramString);
        l = System.currentTimeMillis();
        if ((bo.isNullOrNil(str)) || (bo.isNullOrNil((String)localObject1)))
        {
          ab.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", new Object[] { str, localObject1 });
          paramString = null;
          AppMethodBeat.o(63554);
          return paramString;
        }
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(859L, 6L, 1L, false);
        localWepkgVersion = h.akG(str);
        if (localWepkgVersion == null)
        {
          ab.i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", new Object[] { str, "", "" });
          a.b("EnterWeb", paramString, str, null, 0L, 0L, a.Lq(14));
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(859L, 7L, 1L, false);
          paramString = null;
          AppMethodBeat.o(63554);
          continue;
        }
        if (((String)localObject1).equalsIgnoreCase(localWepkgVersion.vGN)) {
          break label280;
        }
      }
      finally {}
      ab.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", new Object[] { str, localWepkgVersion.version, localObject1, localWepkgVersion.vGN });
      a.b("EnterWeb", paramString, str, null, 0L, 0L, a.Lq(13));
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(859L, 8L, 1L, false);
      paramString = null;
      AppMethodBeat.o(63554);
      continue;
      if (bo.isNullOrNil(localWepkgVersion.version))
      {
        ab.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", new Object[] { str });
        a.b("EnterWeb", paramString, str, null, 0L, 0L, a.Lq(15));
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(859L, 9L, 1L, false);
        paramString = null;
        AppMethodBeat.o(63554);
      }
      else if ((!localWepkgVersion.vGQ) || ((!localWepkgVersion.vGR) && (localWepkgVersion.vGS)))
      {
        ab.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", new Object[] { localWepkgVersion.ezY, localWepkgVersion.version, Boolean.valueOf(localWepkgVersion.vGQ), Boolean.valueOf(localWepkgVersion.vGR), Boolean.valueOf(localWepkgVersion.vGS) });
        a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, a.Lq(16));
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(859L, 10L, 1L, false);
        paramString = null;
        AppMethodBeat.o(63554);
      }
      else
      {
        locale = a(str, localWepkgVersion.version, localWepkgVersion.gUy, localWepkgVersion.cqq, localWepkgVersion.vGO);
        if ((locale != null) || (bo.isNullOrNil(localWepkgVersion.gUy))) {
          break;
        }
        a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, a.Lq(17));
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(859L, 11L, 1L, false);
        paramString = null;
        AppMethodBeat.o(63554);
      }
    }
    boolean bool = localWepkgVersion.vGS;
    if (bo.isNullOrNil(str)) {
      localObject1 = null;
    }
    for (;;)
    {
      HashMap localHashMap;
      int i;
      if (localObject1 == null)
      {
        a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, a.Lq(18));
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(859L, 11L, 1L, false);
        paramString = null;
        AppMethodBeat.o(63554);
        break;
        localHashMap = new HashMap();
        Object localObject2 = h.akJ(str);
        localObject1 = localHashMap;
        if (bo.es((List)localObject2)) {
          continue;
        }
        localObject1 = ((List)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
          if (localObject2 != null) {
            if (bo.isNullOrNil(((WepkgPreloadFile)localObject2).filePath))
            {
              ab.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath is null, isAtomic:%s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                hP(((WepkgPreloadFile)localObject2).ezY, ((WepkgPreloadFile)localObject2).vGh);
                i = 1;
              }
              else
              {
                h.a(str, ((WepkgPreloadFile)localObject2).vGh, "", null);
              }
            }
            else
            {
              File localFile = new File(((WepkgPreloadFile)localObject2).filePath);
              if (!localFile.exists())
              {
                ab.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", new Object[] { ((WepkgPreloadFile)localObject2).filePath, Boolean.valueOf(bool) });
                if (bool)
                {
                  hP(((WepkgPreloadFile)localObject2).ezY, ((WepkgPreloadFile)localObject2).vGh);
                  i = 1;
                }
                else
                {
                  h.a(str, ((WepkgPreloadFile)localObject2).vGh, "", null);
                }
              }
              else if (localFile.length() != ((WepkgPreloadFile)localObject2).size)
              {
                ab.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", new Object[] { Integer.valueOf(((WepkgPreloadFile)localObject2).size), Long.valueOf(localFile.length()), Boolean.valueOf(bool) });
                if (bool)
                {
                  hP(((WepkgPreloadFile)localObject2).ezY, ((WepkgPreloadFile)localObject2).vGh);
                  localFile.delete();
                  i = 1;
                }
                else
                {
                  h.a(str, ((WepkgPreloadFile)localObject2).vGh, "", null);
                }
              }
              else
              {
                localHashMap.put(((WepkgPreloadFile)localObject2).vGh, localObject2);
              }
            }
          }
        }
      }
      paramString = new f(localWepkgVersion, locale, (Map)localObject1);
      ab.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(859L, 12L, 1L, false);
      AppMethodBeat.o(63554);
      break;
      localObject1 = localHashMap;
      if (i != 0) {
        localObject1 = null;
      }
    }
  }
  
  private static void akE(String paramString)
  {
    AppMethodBeat.i(63558);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63558);
      return;
    }
    h.a(paramString, "", false, new g.2());
    AppMethodBeat.o(63558);
  }
  
  private static void hP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63559);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(63559);
      return;
    }
    h.a(paramString1, paramString2, "", new g.4(paramString1, new g.3()));
    AppMethodBeat.o(63559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.g
 * JD-Core Version:    0.7.0.1
 */