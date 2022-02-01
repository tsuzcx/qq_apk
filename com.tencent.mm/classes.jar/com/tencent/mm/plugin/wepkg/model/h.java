package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.ecb;
import com.tencent.mm.protocal.protobuf.eew;
import com.tencent.mm.protocal.protobuf.eez;
import com.tencent.mm.protocal.protobuf.efa;
import com.tencent.mm.protocal.protobuf.efd;
import com.tencent.mm.protocal.protobuf.efe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
{
  public static List<String> a(ckm paramckm)
  {
    AppMethodBeat.i(110713);
    if ((paramckm == null) || (paramckm.HdX == null))
    {
      AppMethodBeat.o(110713);
      return null;
    }
    Object localObject1 = paramckm.HdX.HQz;
    Object localObject2 = paramckm.HdX.HQA;
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 != null) && (((eew)localObject1).HQl != null)) {
      localArrayList.add(ai.ee(paramckm.ufQ + ((eew)localObject1).HQl.tRU));
    }
    if ((localObject2 != null) && (!bt.hj(((efd)localObject2).HQw)))
    {
      localObject1 = ((efd)localObject2).HQw.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (efa)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((efa)localObject2).HQl != null)) {
          localArrayList.add(ai.ee(paramckm.ufQ + ((efa)localObject2).HQl.tRU));
        }
      }
    }
    AppMethodBeat.o(110713);
    return localArrayList;
  }
  
  public static void a(final a parama)
  {
    AppMethodBeat.i(110715);
    final String str = d.eXZ();
    final e locale = new e(str);
    if ((!locale.exists()) || (!locale.isDirectory())) {
      parama.av(null);
    }
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 1001;
    localWepkgCrossProcessTask.krg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110710);
        if (this.EFf.result) {
          com.tencent.mm.plugin.wepkg.utils.d.bZb().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(110709);
              JSONArray localJSONArray;
              for (;;)
              {
                JSONObject localJSONObject2;
                Object localObject4;
                try
                {
                  JSONObject localJSONObject1 = new JSONObject();
                  localJSONObject1.put("rootDir", h.1.this.EFg);
                  Object localObject1 = new HashMap();
                  h.a(h.1.this.EFh, (Map)localObject1);
                  localJSONArray = new JSONArray();
                  localObject1 = ((Map)localObject1).entrySet().iterator();
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                  localObject3 = (Map.Entry)((Iterator)localObject1).next();
                  if (((List)((Map.Entry)localObject3).getValue()).size() == 0) {
                    continue;
                  }
                  localJSONObject2 = new JSONObject();
                  localJSONObject2.put("pkgId", ((Map.Entry)localObject3).getKey());
                  localObject2 = i.aKR((String)((Map.Entry)localObject3).getKey());
                  if (localObject2 != null) {
                    localJSONObject2.put("controlInfo", ((WepkgVersion)localObject2).eYb());
                  }
                  localObject4 = i.aKV((String)((Map.Entry)localObject3).getKey());
                  if (!bt.hj((List)localObject4))
                  {
                    localObject2 = new JSONArray();
                    localObject4 = ((List)localObject4).iterator();
                    if (((Iterator)localObject4).hasNext())
                    {
                      ((JSONArray)localObject2).put(((WepkgPreloadFile)((Iterator)localObject4).next()).eYb());
                      continue;
                    }
                    localJSONObject2.put("preloadFilesInfo", localObject2);
                  }
                }
                catch (Exception localException)
                {
                  if (h.1.this.EFi != null) {
                    h.1.this.EFi.av(null);
                  }
                  AppMethodBeat.o(110709);
                  return;
                }
                Object localObject2 = new JSONArray();
                Object localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  Object localObject5 = (h.b)((Iterator)localObject3).next();
                  localObject4 = new JSONObject();
                  ((JSONObject)localObject4).put("version", ((h.b)localObject5).version);
                  if (!bt.isNullOrNil(((h.b)localObject5).zOp))
                  {
                    localObject6 = new e(((h.b)localObject5).zOp);
                    if ((!((e)localObject6).exists()) || (!((e)localObject6).isFile())) {
                      continue;
                    }
                    ((JSONObject)localObject4).put("md5", com.tencent.mm.vfs.i.aPK(q.B(((e)localObject6).mUri)));
                    ((JSONObject)localObject4).put("size", ((e)localObject6).length());
                    Object localObject7 = new f((e)localObject6).EEQ;
                    if (localObject7 != null)
                    {
                      ((JSONObject)localObject4).put("charset", ((ecb)localObject7).HOx);
                      ((JSONObject)localObject4).put("desc", ((ecb)localObject7).Desc);
                      if (((ecb)localObject7).HOw != null)
                      {
                        localObject6 = new JSONArray();
                        localObject7 = ((ecb)localObject7).HOw.iterator();
                        while (((Iterator)localObject7).hasNext())
                        {
                          ale localale = (ale)((Iterator)localObject7).next();
                          JSONObject localJSONObject3 = new JSONObject();
                          localJSONObject3.put("rid", localale.GkU);
                          localJSONObject3.put("offset", localale.GkV);
                          localJSONObject3.put("size", localale.nEa);
                          localJSONObject3.put("mimeType", localale.GkW);
                          ((JSONArray)localObject6).put(localJSONObject3);
                        }
                        ((JSONObject)localObject4).put("resList", localObject6);
                      }
                    }
                  }
                  Object localObject6 = ((h.b)localObject5).EFl;
                  if (!bt.hj((List)localObject6))
                  {
                    localObject5 = new JSONArray();
                    localObject6 = ((List)localObject6).iterator();
                    while (((Iterator)localObject6).hasNext()) {
                      ((JSONArray)localObject5).put((String)((Iterator)localObject6).next());
                    }
                    ((JSONObject)localObject4).put("preloadFiles", localObject5);
                  }
                  ((JSONArray)localObject2).put(localObject4);
                }
                localJSONObject2.put("versionList", localObject2);
                localJSONArray.put(localJSONObject2);
              }
              localException.put("pkgList", localJSONArray);
              if (h.1.this.EFi != null) {
                h.1.this.EFi.av(localException);
              }
              AppMethodBeat.o(110709);
            }
          });
        }
        this.EFf.bhO();
        AppMethodBeat.o(110710);
      }
    };
    localWepkgCrossProcessTask.bhN();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110715);
  }
  
  public static g aKP(String paramString)
  {
    String str;
    Object localObject1;
    long l;
    WepkgVersion localWepkgVersion;
    label230:
    f localf;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(110712);
        ad.d("MicroMsg.Wepkg.WepkgManager", "loadWepkg");
        str = com.tencent.mm.plugin.wepkg.utils.d.aKY(paramString);
        localObject1 = com.tencent.mm.plugin.wepkg.utils.d.aKZ(paramString);
        l = System.currentTimeMillis();
        if ((bt.isNullOrNil(str)) || (bt.isNullOrNil((String)localObject1)))
        {
          ad.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", new Object[] { str, localObject1 });
          paramString = new g(8, false, "");
          AppMethodBeat.o(110712);
          return paramString;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 6L, 1L, false);
        localWepkgVersion = i.aKS(str);
        if (localWepkgVersion == null)
        {
          ad.i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", new Object[] { str, "", "" });
          com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ya(14));
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 7L, 1L, false);
          paramString = new g(14, false, "");
          AppMethodBeat.o(110712);
          continue;
        }
        if (!localWepkgVersion.EFI) {
          break label230;
        }
      }
      finally {}
      if ((!localWepkgVersion.EFJ) && (localWepkgVersion.EFK))
      {
        ad.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", new Object[] { localWepkgVersion.gsn, localWepkgVersion.version, Boolean.valueOf(localWepkgVersion.EFI), Boolean.valueOf(localWepkgVersion.EFJ), Boolean.valueOf(localWepkgVersion.EFK) });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ya(16));
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 10L, 1L, false);
        paramString = new g(16, false, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else if (!((String)localObject1).equalsIgnoreCase(localWepkgVersion.EFF))
      {
        ad.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", new Object[] { str, localWepkgVersion.version, localObject1, localWepkgVersion.EFF });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ya(13));
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 8L, 1L, false);
        paramString = new g(13, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else if (bt.isNullOrNil(localWepkgVersion.version))
      {
        ad.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", new Object[] { str });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ya(15));
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 9L, 1L, false);
        paramString = new g(15, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else
      {
        localf = b(str, localWepkgVersion.version, localWepkgVersion.pkgPath, localWepkgVersion.md5, localWepkgVersion.EFG);
        if ((localf != null) || (bt.isNullOrNil(localWepkgVersion.pkgPath))) {
          break;
        }
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ya(17));
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 11L, 1L, false);
        paramString = new g(17, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
    }
    boolean bool = localWepkgVersion.EFK;
    if (bt.isNullOrNil(str)) {
      localObject1 = null;
    }
    for (;;)
    {
      HashMap localHashMap;
      int i;
      if (localObject1 == null)
      {
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ya(18));
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 11L, 1L, false);
        paramString = new g(18, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
        break;
        localHashMap = new HashMap();
        Object localObject2 = i.aKV(str);
        localObject1 = localHashMap;
        if (bt.hj((List)localObject2)) {
          continue;
        }
        localObject1 = ((List)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
          if (localObject2 != null) {
            if (bt.isNullOrNil(((WepkgPreloadFile)localObject2).filePath))
            {
              ad.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath is null, isAtomic:%s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                lo(((WepkgPreloadFile)localObject2).gsn, ((WepkgPreloadFile)localObject2).EEZ);
                i = 1;
              }
              else
              {
                i.a(str, ((WepkgPreloadFile)localObject2).EEZ, "", null);
              }
            }
            else
            {
              e locale = new e(((WepkgPreloadFile)localObject2).filePath);
              if (!locale.exists())
              {
                ad.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", new Object[] { ((WepkgPreloadFile)localObject2).filePath, Boolean.valueOf(bool) });
                if (bool)
                {
                  lo(((WepkgPreloadFile)localObject2).gsn, ((WepkgPreloadFile)localObject2).EEZ);
                  i = 1;
                }
                else
                {
                  i.a(str, ((WepkgPreloadFile)localObject2).EEZ, "", null);
                }
              }
              else if (locale.length() != ((WepkgPreloadFile)localObject2).size)
              {
                ad.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", new Object[] { Integer.valueOf(((WepkgPreloadFile)localObject2).size), Long.valueOf(locale.length()), Boolean.valueOf(bool) });
                if (bool)
                {
                  lo(((WepkgPreloadFile)localObject2).gsn, ((WepkgPreloadFile)localObject2).EEZ);
                  locale.delete();
                  i = 1;
                }
                else
                {
                  i.a(str, ((WepkgPreloadFile)localObject2).EEZ, "", null);
                }
              }
              else
              {
                localHashMap.put(((WepkgPreloadFile)localObject2).EEZ, localObject2);
              }
            }
          }
        }
      }
      paramString = new g(localWepkgVersion, localf, (Map)localObject1);
      ad.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(859L, 12L, 1L, false);
      AppMethodBeat.o(110712);
      break;
      localObject1 = localHashMap;
      if (i != 0) {
        localObject1 = null;
      }
    }
  }
  
  private static void aKQ(String paramString)
  {
    AppMethodBeat.i(110716);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110716);
      return;
    }
    i.a(paramString, "", false, new a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
    });
    AppMethodBeat.o(110716);
  }
  
  public static f b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(110714);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString3)) || (bt.isNullOrNil(paramString4)))
    {
      ad.i("MicroMsg.Wepkg.WepkgManager", "pkgid or pkgPath or md5 is null, pkg invalid");
      AppMethodBeat.o(110714);
      return null;
    }
    e locale = new e(paramString3);
    if (!locale.exists())
    {
      ad.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", new Object[] { paramString3 });
      aKQ(paramString1);
      com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 1L, 0L, null);
      AppMethodBeat.o(110714);
      return null;
    }
    if (locale.length() != paramInt)
    {
      ad.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(locale.length()) });
      locale.delete();
      aKQ(paramString1);
      com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 2L, 0L, null);
      AppMethodBeat.o(110714);
      return null;
    }
    if (locale.length() <= 5242880L)
    {
      String str = com.tencent.mm.vfs.i.aPK(q.B(locale.mUri));
      if (!paramString4.equalsIgnoreCase(str))
      {
        ad.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", new Object[] { paramString4, str });
        locale.delete();
        aKQ(paramString1);
        com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 3L, 0L, null);
        AppMethodBeat.o(110714);
        return null;
      }
    }
    else
    {
      ad.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", new Object[] { Long.valueOf(locale.length()), Long.valueOf(5242880L) });
    }
    ad.i("MicroMsg.Wepkg.WepkgManager", "this is big package. localPath: %s", new Object[] { paramString3 });
    paramString2 = new f(locale);
    if ((paramString2.jFp) && (paramString2.EEQ != null))
    {
      AppMethodBeat.o(110714);
      return paramString2;
    }
    c.eXW();
    c.aE(paramString1, 2, 4);
    AppMethodBeat.o(110714);
    return null;
  }
  
  private static void lo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110717);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110717);
      return;
    }
    i.a(paramString1, paramString2, "", new a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
    }
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
      {
        AppMethodBeat.i(110711);
        paramAnonymousBaseWepkgProcessTask = this.ubh;
        a locala = this.EFk;
        WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
        localWepkgCrossProcessTask.EN = 3006;
        localWepkgCrossProcessTask.EET.gsn = paramAnonymousBaseWepkgProcessTask;
        localWepkgCrossProcessTask.EET.EFJ = false;
        if (aj.cnC())
        {
          com.tencent.mm.plugin.wepkg.utils.d.bZb().postToWorker(new i.11(localWepkgCrossProcessTask, locala));
          AppMethodBeat.o(110711);
          return;
        }
        localWepkgCrossProcessTask.krg = new i.12(locala, localWepkgCrossProcessTask);
        localWepkgCrossProcessTask.bhN();
        AppBrandMainProcessService.a(localWepkgCrossProcessTask);
        AppMethodBeat.o(110711);
      }
    });
    AppMethodBeat.o(110717);
  }
  
  public static abstract interface a
  {
    public abstract void av(JSONObject paramJSONObject);
  }
  
  static final class b
  {
    List<String> EFl;
    String version;
    String zOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.h
 * JD-Core Version:    0.7.0.1
 */