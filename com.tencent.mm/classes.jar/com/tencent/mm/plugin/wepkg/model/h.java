package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.protocal.protobuf.egn;
import com.tencent.mm.protocal.protobuf.egq;
import com.tencent.mm.protocal.protobuf.egr;
import com.tencent.mm.protocal.protobuf.egu;
import com.tencent.mm.protocal.protobuf.egv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
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
  public static List<String> a(clg paramclg)
  {
    AppMethodBeat.i(110713);
    if ((paramclg == null) || (paramclg.Hxx == null))
    {
      AppMethodBeat.o(110713);
      return null;
    }
    Object localObject1 = paramclg.Hxx.IkG;
    Object localObject2 = paramclg.Hxx.IkH;
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 != null) && (((egn)localObject1).Iks != null)) {
      localArrayList.add(aj.ej(paramclg.urm + ((egn)localObject1).Iks.ucL));
    }
    if ((localObject2 != null) && (!bu.ht(((egu)localObject2).IkD)))
    {
      localObject1 = ((egu)localObject2).IkD.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (egr)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((egr)localObject2).Iks != null)) {
          localArrayList.add(aj.ej(paramclg.urm + ((egr)localObject2).Iks.ucL));
        }
      }
    }
    AppMethodBeat.o(110713);
    return localArrayList;
  }
  
  public static void a(final a parama)
  {
    AppMethodBeat.i(110715);
    final String str = d.fbL();
    final k localk = new k(str);
    if ((!localk.exists()) || (!localk.isDirectory())) {
      parama.av(null);
    }
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 1001;
    localWepkgCrossProcessTask.kuv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110710);
        if (this.EXB.result) {
          com.tencent.mm.plugin.wepkg.utils.d.caq().postToWorker(new Runnable()
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
                  localJSONObject1.put("rootDir", h.1.this.EXC);
                  Object localObject1 = new HashMap();
                  h.a(h.1.this.EXD, (Map)localObject1);
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
                  localObject2 = i.aMn((String)((Map.Entry)localObject3).getKey());
                  if (localObject2 != null) {
                    localJSONObject2.put("controlInfo", ((WepkgVersion)localObject2).fbN());
                  }
                  localObject4 = i.aMr((String)((Map.Entry)localObject3).getKey());
                  if (!bu.ht((List)localObject4))
                  {
                    localObject2 = new JSONArray();
                    localObject4 = ((List)localObject4).iterator();
                    if (((Iterator)localObject4).hasNext())
                    {
                      ((JSONArray)localObject2).put(((WepkgPreloadFile)((Iterator)localObject4).next()).fbN());
                      continue;
                    }
                    localJSONObject2.put("preloadFilesInfo", localObject2);
                  }
                }
                catch (Exception localException)
                {
                  if (h.1.this.EXE != null) {
                    h.1.this.EXE.av(null);
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
                  if (!bu.isNullOrNil(((h.b)localObject5).Afw))
                  {
                    localObject6 = new k(((h.b)localObject5).Afw);
                    if ((!((k)localObject6).exists()) || (!((k)localObject6).isFile())) {
                      continue;
                    }
                    ((JSONObject)localObject4).put("md5", o.aRh(w.B(((k)localObject6).mUri)));
                    ((JSONObject)localObject4).put("size", ((k)localObject6).length());
                    Object localObject7 = new f((k)localObject6).EXm;
                    if (localObject7 != null)
                    {
                      ((JSONObject)localObject4).put("charset", ((eds)localObject7).IiE);
                      ((JSONObject)localObject4).put("desc", ((eds)localObject7).Desc);
                      if (((eds)localObject7).IiD != null)
                      {
                        localObject6 = new JSONArray();
                        localObject7 = ((eds)localObject7).IiD.iterator();
                        while (((Iterator)localObject7).hasNext())
                        {
                          alo localalo = (alo)((Iterator)localObject7).next();
                          JSONObject localJSONObject3 = new JSONObject();
                          localJSONObject3.put("rid", localalo.GDE);
                          localJSONObject3.put("offset", localalo.GDF);
                          localJSONObject3.put("size", localalo.nJv);
                          localJSONObject3.put("mimeType", localalo.GDG);
                          ((JSONArray)localObject6).put(localJSONObject3);
                        }
                        ((JSONObject)localObject4).put("resList", localObject6);
                      }
                    }
                  }
                  Object localObject6 = ((h.b)localObject5).EXH;
                  if (!bu.ht((List)localObject6))
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
              if (h.1.this.EXE != null) {
                h.1.this.EXE.av(localException);
              }
              AppMethodBeat.o(110709);
            }
          });
        }
        this.EXB.bix();
        AppMethodBeat.o(110710);
      }
    };
    localWepkgCrossProcessTask.biw();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110715);
  }
  
  public static g aMl(String paramString)
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
        ae.d("MicroMsg.Wepkg.WepkgManager", "loadWepkg");
        str = com.tencent.mm.plugin.wepkg.utils.d.aMu(paramString);
        localObject1 = com.tencent.mm.plugin.wepkg.utils.d.aMv(paramString);
        l = System.currentTimeMillis();
        if ((bu.isNullOrNil(str)) || (bu.isNullOrNil((String)localObject1)))
        {
          ae.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", new Object[] { str, localObject1 });
          paramString = new g(8, false, "");
          AppMethodBeat.o(110712);
          return paramString;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(859L, 6L, 1L, false);
        localWepkgVersion = i.aMo(str);
        if (localWepkgVersion == null)
        {
          ae.i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", new Object[] { str, "", "" });
          com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.YG(14));
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(859L, 7L, 1L, false);
          paramString = new g(14, false, "");
          AppMethodBeat.o(110712);
          continue;
        }
        if (!localWepkgVersion.EYe) {
          break label230;
        }
      }
      finally {}
      if ((!localWepkgVersion.EYf) && (localWepkgVersion.EYg))
      {
        ae.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", new Object[] { localWepkgVersion.guO, localWepkgVersion.version, Boolean.valueOf(localWepkgVersion.EYe), Boolean.valueOf(localWepkgVersion.EYf), Boolean.valueOf(localWepkgVersion.EYg) });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.YG(16));
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(859L, 10L, 1L, false);
        paramString = new g(16, false, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else if (!((String)localObject1).equalsIgnoreCase(localWepkgVersion.EYb))
      {
        ae.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", new Object[] { str, localWepkgVersion.version, localObject1, localWepkgVersion.EYb });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.YG(13));
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(859L, 8L, 1L, false);
        paramString = new g(13, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else if (bu.isNullOrNil(localWepkgVersion.version))
      {
        ae.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", new Object[] { str });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.YG(15));
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(859L, 9L, 1L, false);
        paramString = new g(15, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else
      {
        localf = b(str, localWepkgVersion.version, localWepkgVersion.pkgPath, localWepkgVersion.md5, localWepkgVersion.EYc);
        if ((localf != null) || (bu.isNullOrNil(localWepkgVersion.pkgPath))) {
          break;
        }
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.YG(17));
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(859L, 11L, 1L, false);
        paramString = new g(17, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
    }
    boolean bool = localWepkgVersion.EYg;
    if (bu.isNullOrNil(str)) {
      localObject1 = null;
    }
    for (;;)
    {
      HashMap localHashMap;
      int i;
      if (localObject1 == null)
      {
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.YG(18));
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(859L, 11L, 1L, false);
        paramString = new g(18, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
        break;
        localHashMap = new HashMap();
        Object localObject2 = i.aMr(str);
        localObject1 = localHashMap;
        if (bu.ht((List)localObject2)) {
          continue;
        }
        localObject1 = ((List)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
          if (localObject2 != null) {
            if (bu.isNullOrNil(((WepkgPreloadFile)localObject2).filePath))
            {
              ae.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath is null, isAtomic:%s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                lv(((WepkgPreloadFile)localObject2).guO, ((WepkgPreloadFile)localObject2).EXv);
                i = 1;
              }
              else
              {
                i.a(str, ((WepkgPreloadFile)localObject2).EXv, "", null);
              }
            }
            else
            {
              k localk = new k(((WepkgPreloadFile)localObject2).filePath);
              if (!localk.exists())
              {
                ae.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", new Object[] { ((WepkgPreloadFile)localObject2).filePath, Boolean.valueOf(bool) });
                if (bool)
                {
                  lv(((WepkgPreloadFile)localObject2).guO, ((WepkgPreloadFile)localObject2).EXv);
                  i = 1;
                }
                else
                {
                  i.a(str, ((WepkgPreloadFile)localObject2).EXv, "", null);
                }
              }
              else if (localk.length() != ((WepkgPreloadFile)localObject2).size)
              {
                ae.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", new Object[] { Integer.valueOf(((WepkgPreloadFile)localObject2).size), Long.valueOf(localk.length()), Boolean.valueOf(bool) });
                if (bool)
                {
                  lv(((WepkgPreloadFile)localObject2).guO, ((WepkgPreloadFile)localObject2).EXv);
                  localk.delete();
                  i = 1;
                }
                else
                {
                  i.a(str, ((WepkgPreloadFile)localObject2).EXv, "", null);
                }
              }
              else
              {
                localHashMap.put(((WepkgPreloadFile)localObject2).EXv, localObject2);
              }
            }
          }
        }
      }
      paramString = new g(localWepkgVersion, localf, (Map)localObject1);
      ae.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(859L, 12L, 1L, false);
      AppMethodBeat.o(110712);
      break;
      localObject1 = localHashMap;
      if (i != 0) {
        localObject1 = null;
      }
    }
  }
  
  private static void aMm(String paramString)
  {
    AppMethodBeat.i(110716);
    if (bu.isNullOrNil(paramString))
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
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString3)) || (bu.isNullOrNil(paramString4)))
    {
      ae.i("MicroMsg.Wepkg.WepkgManager", "pkgid or pkgPath or md5 is null, pkg invalid");
      AppMethodBeat.o(110714);
      return null;
    }
    k localk = new k(paramString3);
    if (!localk.exists())
    {
      ae.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", new Object[] { paramString3 });
      aMm(paramString1);
      com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 1L, 0L, null);
      AppMethodBeat.o(110714);
      return null;
    }
    if (localk.length() != paramInt)
    {
      ae.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(localk.length()) });
      localk.delete();
      aMm(paramString1);
      com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 2L, 0L, null);
      AppMethodBeat.o(110714);
      return null;
    }
    if (localk.length() <= 5242880L)
    {
      String str = o.aRh(w.B(localk.mUri));
      if (!paramString4.equalsIgnoreCase(str))
      {
        ae.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", new Object[] { paramString4, str });
        localk.delete();
        aMm(paramString1);
        com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 3L, 0L, null);
        AppMethodBeat.o(110714);
        return null;
      }
    }
    else
    {
      ae.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", new Object[] { Long.valueOf(localk.length()), Long.valueOf(5242880L) });
    }
    ae.i("MicroMsg.Wepkg.WepkgManager", "this is big package. localPath: %s", new Object[] { paramString3 });
    paramString2 = new f(localk);
    if ((paramString2.jIo) && (paramString2.EXm != null))
    {
      AppMethodBeat.o(110714);
      return paramString2;
    }
    c.fbI();
    c.aG(paramString1, 2, 4);
    AppMethodBeat.o(110714);
    return null;
  }
  
  private static void lv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110717);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
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
        paramAnonymousBaseWepkgProcessTask = this.umj;
        a locala = this.EXG;
        WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
        localWepkgCrossProcessTask.EN = 3006;
        localWepkgCrossProcessTask.EXp.guO = paramAnonymousBaseWepkgProcessTask;
        localWepkgCrossProcessTask.EXp.EYf = false;
        if (ak.cpe())
        {
          com.tencent.mm.plugin.wepkg.utils.d.caq().postToWorker(new i.11(localWepkgCrossProcessTask, locala));
          AppMethodBeat.o(110711);
          return;
        }
        localWepkgCrossProcessTask.kuv = new i.12(locala, localWepkgCrossProcessTask);
        localWepkgCrossProcessTask.biw();
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
    String Afw;
    List<String> EXH;
    String version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.h
 * JD-Core Version:    0.7.0.1
 */