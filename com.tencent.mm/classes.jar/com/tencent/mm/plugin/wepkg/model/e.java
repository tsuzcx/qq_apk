package com.tencent.mm.plugin.wepkg.model;

import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.utils.b;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.cla;
import com.tencent.mm.protocal.c.cld;
import com.tencent.mm.protocal.c.cle;
import com.tencent.mm.protocal.c.clg;
import com.tencent.mm.protocal.c.clh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class e
{
  public static d Ve(String paramString)
  {
    for (;;)
    {
      String str;
      Object localObject1;
      long l;
      WepkgVersion localWepkgVersion;
      c localc;
      boolean bool;
      HashMap localHashMap;
      Object localObject2;
      int i;
      try
      {
        str = com.tencent.mm.plugin.wepkg.utils.d.Vq(paramString);
        localObject1 = com.tencent.mm.plugin.wepkg.utils.d.Vr(paramString);
        l = System.currentTimeMillis();
        if ((bk.bl(str)) || (bk.bl((String)localObject1)))
        {
          y.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", new Object[] { str, localObject1 });
          paramString = null;
          return paramString;
        }
        h.nFQ.a(859L, 6L, 1L, false);
        localWepkgVersion = f.Vk(str);
        if (localWepkgVersion == null)
        {
          y.i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", new Object[] { str, "", "" });
          com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Dy(14));
          h.nFQ.a(859L, 7L, 1L, false);
          paramString = null;
          continue;
        }
        if (!((String)localObject1).equalsIgnoreCase(localWepkgVersion.ceG))
        {
          y.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", new Object[] { str, localWepkgVersion.version, localObject1, localWepkgVersion.ceG });
          com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Dy(13));
          h.nFQ.a(859L, 8L, 1L, false);
          paramString = null;
          continue;
        }
        if (bk.bl(localWepkgVersion.version))
        {
          y.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", new Object[] { str });
          com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Dy(15));
          h.nFQ.a(859L, 9L, 1L, false);
          paramString = null;
          continue;
        }
        if ((!localWepkgVersion.rPY) || ((!localWepkgVersion.rPZ) && (localWepkgVersion.rQa)))
        {
          y.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", new Object[] { localWepkgVersion.dCD, localWepkgVersion.version, Boolean.valueOf(localWepkgVersion.rPY), Boolean.valueOf(localWepkgVersion.rPZ), Boolean.valueOf(localWepkgVersion.rQa) });
          com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Dy(16));
          h.nFQ.a(859L, 10L, 1L, false);
          paramString = null;
          continue;
        }
        localc = a(str, localWepkgVersion.version, localWepkgVersion.fCl, localWepkgVersion.bIW, localWepkgVersion.rPW);
        if ((localc == null) && (!bk.bl(localWepkgVersion.fCl)))
        {
          com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Dy(17));
          h.nFQ.a(859L, 11L, 1L, false);
          paramString = null;
          continue;
        }
        bool = localWepkgVersion.rQa;
        if (bk.bl(str))
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label912;
          }
          com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Dy(18));
          h.nFQ.a(859L, 11L, 1L, false);
          paramString = null;
          continue;
        }
        localHashMap = new HashMap();
        localObject2 = f.Vm(str);
        localObject1 = localHashMap;
        if (bk.dk((List)localObject2)) {
          continue;
        }
        localObject1 = ((List)localObject2).iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label965;
        }
        localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
        if (localObject2 == null) {
          continue;
        }
        if (bk.bl(((WepkgPreloadFile)localObject2).filePath))
        {
          y.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath is null, isAtomic:%s", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            fM(((WepkgPreloadFile)localObject2).dCD, ((WepkgPreloadFile)localObject2).rPo);
            i = 1;
            continue;
          }
          f.a(str, ((WepkgPreloadFile)localObject2).rPo, "", null);
          continue;
        }
        localFile = new File(((WepkgPreloadFile)localObject2).filePath);
      }
      finally {}
      File localFile;
      if (!localFile.exists())
      {
        y.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", new Object[] { ((WepkgPreloadFile)localObject2).filePath, Boolean.valueOf(bool) });
        if (bool)
        {
          fM(((WepkgPreloadFile)localObject2).dCD, ((WepkgPreloadFile)localObject2).rPo);
          i = 1;
        }
        else
        {
          f.a(str, ((WepkgPreloadFile)localObject2).rPo, "", null);
        }
      }
      else if (localFile.length() != ((WepkgPreloadFile)localObject2).size)
      {
        y.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", new Object[] { Integer.valueOf(((WepkgPreloadFile)localObject2).size), Long.valueOf(localFile.length()), Boolean.valueOf(bool) });
        if (bool)
        {
          fM(((WepkgPreloadFile)localObject2).dCD, ((WepkgPreloadFile)localObject2).rPo);
          localFile.delete();
          i = 1;
        }
        else
        {
          f.a(str, ((WepkgPreloadFile)localObject2).rPo, "", null);
        }
      }
      else
      {
        localHashMap.put(((WepkgPreloadFile)localObject2).rPo, localObject2);
        continue;
        label912:
        paramString = new d(localWepkgVersion, localc, (Map)localObject1);
        y.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        h.nFQ.a(859L, 12L, 1L, false);
        continue;
        label965:
        localObject1 = localHashMap;
        if (i != 0) {
          localObject1 = null;
        }
      }
    }
  }
  
  public static void Vf(String paramString)
  {
    y.i("MicroMsg.Wepkg.WepkgManager", "clear wepkg info, pkgid:%s", new Object[] { paramString });
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.uC = 2001;
    localWepkgCrossProcessTask.rPj.dCD = paramString;
    if (ae.cqV())
    {
      com.tencent.mm.plugin.wepkg.utils.d.DS().O(new f.2(localWepkgCrossProcessTask));
      return;
    }
    localWepkgCrossProcessTask.gfD = new f.3(localWepkgCrossProcessTask);
    localWepkgCrossProcessTask.ahC();
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
  }
  
  public static void Vg(String paramString)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putString("call_pkg_id", paramString);
    ToolsProcessIPCService.a(localBundle, e.b.class, new e.1(paramString));
  }
  
  public static boolean Vh(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      Object localObject = paramString.getName() + "_temp";
      localObject = new File(paramString.getParent(), (String)localObject);
      if (paramString.renameTo((File)localObject))
      {
        com.tencent.mm.a.e.k((File)localObject);
        return true;
      }
    }
    catch (Exception paramString)
    {
      y.i("MicroMsg.Wepkg.WepkgManager", "safeDeleteDir err:" + paramString.getMessage());
    }
    return false;
  }
  
  private static void Vi(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    f.a(paramString, "", false, new e.4());
  }
  
  public static c a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString3)) || (bk.bl(paramString4)))
    {
      y.i("MicroMsg.Wepkg.WepkgManager", "pkgid or pkgPath or md5 is null, pkg invalid");
      paramString2 = null;
    }
    do
    {
      return paramString2;
      File localFile = new File(paramString3);
      if (!localFile.exists())
      {
        y.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", new Object[] { paramString3 });
        Vi(paramString1);
        com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 1L, 0L, null);
        return null;
      }
      if (localFile.length() != paramInt)
      {
        y.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(localFile.length()) });
        localFile.delete();
        Vi(paramString1);
        com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 2L, 0L, null);
        return null;
      }
      if (localFile.length() <= 5242880L)
      {
        paramString3 = g.m(localFile);
        if (!paramString4.equalsIgnoreCase(paramString3))
        {
          y.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", new Object[] { paramString4, paramString3 });
          localFile.delete();
          Vi(paramString1);
          com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 3L, 0L, null);
          return null;
        }
      }
      else
      {
        y.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", new Object[] { Long.valueOf(localFile.length()), Long.valueOf(5242880L) });
      }
      paramString3 = new c(localFile);
      if (!paramString3.fDy) {
        break;
      }
      paramString2 = paramString3;
    } while (paramString3.rPg != null);
    Vf(paramString1);
    return null;
  }
  
  public static List<String> a(bet parambet)
  {
    if ((parambet == null) || (parambet.tzE == null)) {
      return null;
    }
    Object localObject1 = parambet.tzE.tYB;
    Object localObject2 = parambet.tzE.tYC;
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 != null) && (((cla)localObject1).tYo != null)) {
      localArrayList.add(ad.bB(parambet.kSE + ((cla)localObject1).tYo.sww));
    }
    if ((localObject2 != null) && (!bk.dk(((clg)localObject2).tYy)))
    {
      localObject1 = ((clg)localObject2).tYy.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cle)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((cle)localObject2).tYo != null)) {
          localArrayList.add(ad.bB(parambet.kSE + ((cle)localObject2).tYo.sww));
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(e.a parama)
  {
    String str = b.OBJECT_ROOT_DIR_PATH;
    File localFile = new File(str);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      parama.R(null);
    }
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.uC = 1001;
    localWepkgCrossProcessTask.gfD = new e.3(localWepkgCrossProcessTask, str, localFile, parama);
    localWepkgCrossProcessTask.ahC();
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
  }
  
  private static void fM(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return;
    }
    f.a(paramString1, paramString2, "", new e.6(paramString1, new a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
    }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.e
 * JD-Core Version:    0.7.0.1
 */