package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.eya;
import com.tencent.mm.protocal.protobuf.fbd;
import com.tencent.mm.protocal.protobuf.fbg;
import com.tencent.mm.protocal.protobuf.fbh;
import com.tencent.mm.protocal.protobuf.fbk;
import com.tencent.mm.protocal.protobuf.fbl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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

public final class i
{
  public static g a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(110714);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString3)) || (Util.isNullOrNil(paramString4)))
    {
      Log.i("MicroMsg.Wepkg.WepkgManager", "pkgid or pkgPath or md5 is null, pkg invalid");
      AppMethodBeat.o(110714);
      return null;
    }
    o localo = new o(paramString3);
    if (!localo.exists())
    {
      Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", new Object[] { paramString3 });
      bcG(paramString1);
      com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 1L, 0L, null);
      AppMethodBeat.o(110714);
      return null;
    }
    if (localo.length() != paramInt)
    {
      Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(localo.length()) });
      localo.delete();
      bcG(paramString1);
      com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 2L, 0L, null);
      AppMethodBeat.o(110714);
      return null;
    }
    if (localo.length() <= 5242880L)
    {
      String str = s.bhK(aa.z(localo.mUri));
      if (!paramString4.equalsIgnoreCase(str))
      {
        Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", new Object[] { paramString4, str });
        localo.delete();
        bcG(paramString1);
        com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 3L, 0L, null);
        AppMethodBeat.o(110714);
        return null;
      }
    }
    else
    {
      Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", new Object[] { Long.valueOf(localo.length()), Long.valueOf(5242880L) });
    }
    Log.i("MicroMsg.Wepkg.WepkgManager", "this is big package. localPath: %s", new Object[] { paramString3 });
    paramString2 = new g(localo);
    if ((paramString2.kKk) && (paramString2.JNe != null))
    {
      AppMethodBeat.o(110714);
      return paramString2;
    }
    c.gkN();
    c.aI(paramString1, 2, 4);
    AppMethodBeat.o(110714);
    return null;
  }
  
  public static List<String> a(dbq paramdbq)
  {
    AppMethodBeat.i(110713);
    if ((paramdbq == null) || (paramdbq.MGA == null))
    {
      AppMethodBeat.o(110713);
      return null;
    }
    Object localObject1 = paramdbq.MGA.NxH;
    Object localObject2 = paramdbq.MGA.NxI;
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 != null) && (((fbd)localObject1).Nxt != null)) {
      localArrayList.add(MD5Util.getMD5String(paramdbq.xJD + ((fbd)localObject1).Nxt.xuc));
    }
    if ((localObject2 != null) && (!Util.isNullOrNil(((fbk)localObject2).NxE)))
    {
      localObject1 = ((fbk)localObject2).NxE.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (fbh)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((fbh)localObject2).Nxt != null)) {
          localArrayList.add(MD5Util.getMD5String(paramdbq.xJD + ((fbh)localObject2).Nxt.xuc));
        }
      }
    }
    AppMethodBeat.o(110713);
    return localArrayList;
  }
  
  public static void a(final a parama)
  {
    AppMethodBeat.i(110715);
    final String str = e.gkQ();
    final o localo = new o(str);
    if ((!localo.exists()) || (!localo.isDirectory())) {
      parama.aR(null);
    }
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EX = 1001;
    localWepkgCrossProcessTask.lyv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110710);
        if (this.JNt.result) {
          d.cyh().postToWorker(new Runnable()
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
                  localJSONObject1.put("rootDir", i.1.this.JNu);
                  Object localObject1 = new HashMap();
                  i.a(i.1.this.JNv, (Map)localObject1);
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
                  localObject2 = j.bcH((String)((Map.Entry)localObject3).getKey());
                  if (localObject2 != null) {
                    localJSONObject2.put("controlInfo", ((WepkgVersion)localObject2).gkT());
                  }
                  localObject4 = j.bcL((String)((Map.Entry)localObject3).getKey());
                  if (!Util.isNullOrNil((List)localObject4))
                  {
                    localObject2 = new JSONArray();
                    localObject4 = ((List)localObject4).iterator();
                    if (((Iterator)localObject4).hasNext())
                    {
                      ((JSONArray)localObject2).put(((WepkgPreloadFile)((Iterator)localObject4).next()).gkT());
                      continue;
                    }
                    localJSONObject2.put("preloadFilesInfo", localObject2);
                  }
                }
                catch (Exception localException)
                {
                  if (i.1.this.JNw != null) {
                    i.1.this.JNw.aR(null);
                  }
                  AppMethodBeat.o(110709);
                  return;
                }
                Object localObject2 = new JSONArray();
                Object localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  Object localObject5 = (i.b)((Iterator)localObject3).next();
                  localObject4 = new JSONObject();
                  ((JSONObject)localObject4).put("version", ((i.b)localObject5).version);
                  if (!Util.isNullOrNil(((i.b)localObject5).EnT))
                  {
                    localObject6 = new o(((i.b)localObject5).EnT);
                    if ((!((o)localObject6).exists()) || (!((o)localObject6).isFile())) {
                      continue;
                    }
                    ((JSONObject)localObject4).put("md5", s.bhK(aa.z(((o)localObject6).mUri)));
                    ((JSONObject)localObject4).put("size", ((o)localObject6).length());
                    Object localObject7 = new g((o)localObject6).JNe;
                    if (localObject7 != null)
                    {
                      ((JSONObject)localObject4).put("charset", ((eya)localObject7).Nvi);
                      ((JSONObject)localObject4).put("desc", ((eya)localObject7).Desc);
                      if (((eya)localObject7).Nvh != null)
                      {
                        localObject6 = new JSONArray();
                        localObject7 = ((eya)localObject7).Nvh.iterator();
                        while (((Iterator)localObject7).hasNext())
                        {
                          aod localaod = (aod)((Iterator)localObject7).next();
                          JSONObject localJSONObject3 = new JSONObject();
                          localJSONObject3.put("rid", localaod.LzG);
                          localJSONObject3.put("offset", localaod.LzH);
                          localJSONObject3.put("size", localaod.oUq);
                          localJSONObject3.put("mimeType", localaod.LzI);
                          ((JSONArray)localObject6).put(localJSONObject3);
                        }
                        ((JSONObject)localObject4).put("resList", localObject6);
                      }
                    }
                  }
                  Object localObject6 = ((i.b)localObject5).JNz;
                  if (!Util.isNullOrNil((List)localObject6))
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
              if (i.1.this.JNw != null) {
                i.1.this.JNw.aR(localException);
              }
              AppMethodBeat.o(110709);
            }
          });
        }
        this.JNt.bDK();
        AppMethodBeat.o(110710);
      }
    };
    localWepkgCrossProcessTask.bDJ();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110715);
  }
  
  public static h bcF(String paramString)
  {
    String str;
    Object localObject1;
    long l;
    WepkgVersion localWepkgVersion;
    label235:
    g localg;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(110712);
        Log.d("MicroMsg.Wepkg.WepkgManager", "loadWepkg");
        str = d.bcO(paramString);
        localObject1 = d.bcP(paramString);
        l = System.currentTimeMillis();
        if ((Util.isNullOrNil(str)) || (Util.isNullOrNil((String)localObject1)))
        {
          Log.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", new Object[] { str, localObject1 });
          paramString = new h(8, false, "");
          AppMethodBeat.o(110712);
          return paramString;
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(859L, 6L, 1L, false);
        localWepkgVersion = j.bcI(str);
        if (localWepkgVersion == null)
        {
          Log.i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", new Object[] { str, "", "" });
          com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.ahr(14));
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(859L, 7L, 1L, false);
          paramString = new h(14, false, "");
          AppMethodBeat.o(110712);
          continue;
        }
        if (!localWepkgVersion.JNV) {
          break label235;
        }
      }
      finally {}
      if ((!localWepkgVersion.JNW) && (localWepkgVersion.JNX))
      {
        Log.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", new Object[] { localWepkgVersion.hhD, localWepkgVersion.version, Boolean.valueOf(localWepkgVersion.JNV), Boolean.valueOf(localWepkgVersion.JNW), Boolean.valueOf(localWepkgVersion.JNX) });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.ahr(16));
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(859L, 10L, 1L, false);
        paramString = new h(16, false, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else if (!((String)localObject1).equalsIgnoreCase(localWepkgVersion.domain))
      {
        Log.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", new Object[] { str, localWepkgVersion.version, localObject1, localWepkgVersion.domain });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.ahr(13));
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(859L, 8L, 1L, false);
        paramString = new h(13, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else if (Util.isNullOrNil(localWepkgVersion.version))
      {
        Log.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", new Object[] { str });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.ahr(15));
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(859L, 9L, 1L, false);
        paramString = new h(15, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else
      {
        localg = a(str, localWepkgVersion.version, localWepkgVersion.pkgPath, localWepkgVersion.md5, localWepkgVersion.JNT);
        if ((localg != null) || (Util.isNullOrNil(localWepkgVersion.pkgPath))) {
          break;
        }
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.ahr(17));
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(859L, 11L, 1L, false);
        paramString = new h(17, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
    }
    boolean bool = localWepkgVersion.JNX;
    if (Util.isNullOrNil(str)) {
      localObject1 = null;
    }
    for (;;)
    {
      HashMap localHashMap;
      int i;
      if (localObject1 == null)
      {
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.ahr(18));
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(859L, 11L, 1L, false);
        paramString = new h(18, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
        break;
        localHashMap = new HashMap();
        Object localObject2 = j.bcL(str);
        localObject1 = localHashMap;
        if (Util.isNullOrNil((List)localObject2)) {
          continue;
        }
        localObject1 = ((List)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
          if (localObject2 != null) {
            if (Util.isNullOrNil(((WepkgPreloadFile)localObject2).filePath))
            {
              Log.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath is null, isAtomic:%s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                mu(((WepkgPreloadFile)localObject2).hhD, ((WepkgPreloadFile)localObject2).JNn);
                i = 1;
              }
              else
              {
                j.a(str, ((WepkgPreloadFile)localObject2).JNn, "", null);
              }
            }
            else
            {
              o localo = new o(((WepkgPreloadFile)localObject2).filePath);
              if (!localo.exists())
              {
                Log.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", new Object[] { ((WepkgPreloadFile)localObject2).filePath, Boolean.valueOf(bool) });
                if (bool)
                {
                  mu(((WepkgPreloadFile)localObject2).hhD, ((WepkgPreloadFile)localObject2).JNn);
                  i = 1;
                }
                else
                {
                  j.a(str, ((WepkgPreloadFile)localObject2).JNn, "", null);
                }
              }
              else if (localo.length() != ((WepkgPreloadFile)localObject2).size)
              {
                Log.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", new Object[] { Integer.valueOf(((WepkgPreloadFile)localObject2).size), Long.valueOf(localo.length()), Boolean.valueOf(bool) });
                if (bool)
                {
                  mu(((WepkgPreloadFile)localObject2).hhD, ((WepkgPreloadFile)localObject2).JNn);
                  localo.delete();
                  i = 1;
                }
                else
                {
                  j.a(str, ((WepkgPreloadFile)localObject2).JNn, "", null);
                }
              }
              else
              {
                localHashMap.put(((WepkgPreloadFile)localObject2).JNn, localObject2);
              }
            }
          }
        }
      }
      paramString = new h(localWepkgVersion, localg, (Map)localObject1);
      Log.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(859L, 12L, 1L, false);
      AppMethodBeat.o(110712);
      break;
      localObject1 = localHashMap;
      if (i != 0) {
        localObject1 = null;
      }
    }
  }
  
  private static void bcG(String paramString)
  {
    AppMethodBeat.i(110716);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110716);
      return;
    }
    j.a(paramString, "", false, new a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
    });
    AppMethodBeat.o(110716);
  }
  
  private static void mu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110717);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(110717);
      return;
    }
    j.a(paramString1, paramString2, "", new a()
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask) {}
    }
    {
      public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
      {
        AppMethodBeat.i(110711);
        paramAnonymousBaseWepkgProcessTask = this.xEB;
        a locala = this.JNy;
        WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
        localWepkgCrossProcessTask.EX = 3006;
        localWepkgCrossProcessTask.JNh.hhD = paramAnonymousBaseWepkgProcessTask;
        localWepkgCrossProcessTask.JNh.JNW = false;
        if (MMApplicationContext.isMMProcess())
        {
          d.cyh().postToWorker(new j.11(localWepkgCrossProcessTask, locala));
          AppMethodBeat.o(110711);
          return;
        }
        localWepkgCrossProcessTask.lyv = new j.12(locala, localWepkgCrossProcessTask);
        localWepkgCrossProcessTask.bDJ();
        AppBrandMainProcessService.a(localWepkgCrossProcessTask);
        AppMethodBeat.o(110711);
      }
    });
    AppMethodBeat.o(110717);
  }
  
  public static abstract interface a
  {
    public abstract void aR(JSONObject paramJSONObject);
  }
  
  static final class b
  {
    String EnT;
    List<String> JNz;
    String version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.i
 * JD-Core Version:    0.7.0.1
 */