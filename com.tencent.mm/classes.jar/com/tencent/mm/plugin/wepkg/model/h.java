package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.dqk;
import com.tencent.mm.protocal.protobuf.dtd;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.protocal.protobuf.dtl;
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
  public static List<String> a(cao paramcao)
  {
    AppMethodBeat.i(110713);
    if ((paramcao == null) || (paramcao.DWZ == null))
    {
      AppMethodBeat.o(110713);
      return null;
    }
    Object localObject1 = paramcao.DWZ.EIg;
    Object localObject2 = paramcao.DWZ.EIh;
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 != null) && (((dtd)localObject1).EHS != null)) {
      localArrayList.add(ai.du(paramcao.sag + ((dtd)localObject1).EHS.rNA));
    }
    if ((localObject2 != null) && (!bt.gL(((dtk)localObject2).EId)))
    {
      localObject1 = ((dtk)localObject2).EId.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (dth)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((dth)localObject2).EHS != null)) {
          localArrayList.add(ai.du(paramcao.sag + ((dth)localObject2).EHS.rNA));
        }
      }
    }
    AppMethodBeat.o(110713);
    return localArrayList;
  }
  
  public static void a(final a parama)
  {
    AppMethodBeat.i(110715);
    final String str = d.etN();
    final e locale = new e(str);
    if ((!locale.exists()) || (!locale.isDirectory())) {
      parama.ar(null);
    }
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.BX = 1001;
    localWepkgCrossProcessTask.jwt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110710);
        if (this.BIX.result) {
          com.tencent.mm.plugin.wepkg.utils.d.bNl().postToWorker(new Runnable()
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
                  localJSONObject1.put("rootDir", h.1.this.BIY);
                  Object localObject1 = new HashMap();
                  h.a(h.1.this.BIZ, (Map)localObject1);
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
                  localObject2 = i.azZ((String)((Map.Entry)localObject3).getKey());
                  if (localObject2 != null) {
                    localJSONObject2.put("controlInfo", ((WepkgVersion)localObject2).etO());
                  }
                  localObject4 = i.aAd((String)((Map.Entry)localObject3).getKey());
                  if (!bt.gL((List)localObject4))
                  {
                    localObject2 = new JSONArray();
                    localObject4 = ((List)localObject4).iterator();
                    if (((Iterator)localObject4).hasNext())
                    {
                      ((JSONArray)localObject2).put(((WepkgPreloadFile)((Iterator)localObject4).next()).etO());
                      continue;
                    }
                    localJSONObject2.put("preloadFilesInfo", localObject2);
                  }
                }
                catch (Exception localException)
                {
                  if (h.1.this.BJa != null) {
                    h.1.this.BJa.ar(null);
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
                  if (!bt.isNullOrNil(((h.b)localObject5).xkk))
                  {
                    localObject6 = new e(((h.b)localObject5).xkk);
                    if ((!((e)localObject6).exists()) || (!((e)localObject6).isFile())) {
                      continue;
                    }
                    ((JSONObject)localObject4).put("md5", com.tencent.mm.vfs.i.aEN(q.B(((e)localObject6).mUri)));
                    ((JSONObject)localObject4).put("size", ((e)localObject6).length());
                    Object localObject7 = new f((e)localObject6).BII;
                    if (localObject7 != null)
                    {
                      ((JSONObject)localObject4).put("charset", ((dqk)localObject7).EGf);
                      ((JSONObject)localObject4).put("desc", ((dqk)localObject7).Desc);
                      if (((dqk)localObject7).EGe != null)
                      {
                        localObject6 = new JSONArray();
                        localObject7 = ((dqk)localObject7).EGe.iterator();
                        while (((Iterator)localObject7).hasNext())
                        {
                          ahp localahp = (ahp)((Iterator)localObject7).next();
                          JSONObject localJSONObject3 = new JSONObject();
                          localJSONObject3.put("rid", localahp.Dke);
                          localJSONObject3.put("offset", localahp.Dkf);
                          localJSONObject3.put("size", localahp.mBC);
                          localJSONObject3.put("mimeType", localahp.Dkg);
                          ((JSONArray)localObject6).put(localJSONObject3);
                        }
                        ((JSONObject)localObject4).put("resList", localObject6);
                      }
                    }
                  }
                  Object localObject6 = ((h.b)localObject5).BJd;
                  if (!bt.gL((List)localObject6))
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
              if (h.1.this.BJa != null) {
                h.1.this.BJa.ar(localException);
              }
              AppMethodBeat.o(110709);
            }
          });
        }
        this.BIX.aXn();
        AppMethodBeat.o(110710);
      }
    };
    localWepkgCrossProcessTask.aXm();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110715);
  }
  
  public static g azX(String paramString)
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
        str = com.tencent.mm.plugin.wepkg.utils.d.aAg(paramString);
        localObject1 = com.tencent.mm.plugin.wepkg.utils.d.aAh(paramString);
        l = System.currentTimeMillis();
        if ((bt.isNullOrNil(str)) || (bt.isNullOrNil((String)localObject1)))
        {
          ad.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", new Object[] { str, localObject1 });
          paramString = new g(8, false, "");
          AppMethodBeat.o(110712);
          return paramString;
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(859L, 6L, 1L, false);
        localWepkgVersion = i.aAa(str);
        if (localWepkgVersion == null)
        {
          ad.i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", new Object[] { str, "", "" });
          com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ub(14));
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(859L, 7L, 1L, false);
          paramString = new g(14, false, "");
          AppMethodBeat.o(110712);
          continue;
        }
        if (!localWepkgVersion.BJA) {
          break label230;
        }
      }
      finally {}
      if ((!localWepkgVersion.BJB) && (localWepkgVersion.BJC))
      {
        ad.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", new Object[] { localWepkgVersion.fUW, localWepkgVersion.version, Boolean.valueOf(localWepkgVersion.BJA), Boolean.valueOf(localWepkgVersion.BJB), Boolean.valueOf(localWepkgVersion.BJC) });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ub(16));
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(859L, 10L, 1L, false);
        paramString = new g(16, false, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else if (!((String)localObject1).equalsIgnoreCase(localWepkgVersion.BJx))
      {
        ad.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", new Object[] { str, localWepkgVersion.version, localObject1, localWepkgVersion.BJx });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ub(13));
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(859L, 8L, 1L, false);
        paramString = new g(13, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else if (bt.isNullOrNil(localWepkgVersion.version))
      {
        ad.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", new Object[] { str });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ub(15));
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(859L, 9L, 1L, false);
        paramString = new g(15, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else
      {
        localf = b(str, localWepkgVersion.version, localWepkgVersion.pkgPath, localWepkgVersion.md5, localWepkgVersion.BJy);
        if ((localf != null) || (bt.isNullOrNil(localWepkgVersion.pkgPath))) {
          break;
        }
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ub(17));
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(859L, 11L, 1L, false);
        paramString = new g(17, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
    }
    boolean bool = localWepkgVersion.BJC;
    if (bt.isNullOrNil(str)) {
      localObject1 = null;
    }
    for (;;)
    {
      HashMap localHashMap;
      int i;
      if (localObject1 == null)
      {
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.Ub(18));
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(859L, 11L, 1L, false);
        paramString = new g(18, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
        break;
        localHashMap = new HashMap();
        Object localObject2 = i.aAd(str);
        localObject1 = localHashMap;
        if (bt.gL((List)localObject2)) {
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
                kv(((WepkgPreloadFile)localObject2).fUW, ((WepkgPreloadFile)localObject2).BIR);
                i = 1;
              }
              else
              {
                i.a(str, ((WepkgPreloadFile)localObject2).BIR, "", null);
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
                  kv(((WepkgPreloadFile)localObject2).fUW, ((WepkgPreloadFile)localObject2).BIR);
                  i = 1;
                }
                else
                {
                  i.a(str, ((WepkgPreloadFile)localObject2).BIR, "", null);
                }
              }
              else if (locale.length() != ((WepkgPreloadFile)localObject2).size)
              {
                ad.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", new Object[] { Integer.valueOf(((WepkgPreloadFile)localObject2).size), Long.valueOf(locale.length()), Boolean.valueOf(bool) });
                if (bool)
                {
                  kv(((WepkgPreloadFile)localObject2).fUW, ((WepkgPreloadFile)localObject2).BIR);
                  locale.delete();
                  i = 1;
                }
                else
                {
                  i.a(str, ((WepkgPreloadFile)localObject2).BIR, "", null);
                }
              }
              else
              {
                localHashMap.put(((WepkgPreloadFile)localObject2).BIR, localObject2);
              }
            }
          }
        }
      }
      paramString = new g(localWepkgVersion, localf, (Map)localObject1);
      ad.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(859L, 12L, 1L, false);
      AppMethodBeat.o(110712);
      break;
      localObject1 = localHashMap;
      if (i != 0) {
        localObject1 = null;
      }
    }
  }
  
  private static void azY(String paramString)
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
      azY(paramString1);
      com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 1L, 0L, null);
      AppMethodBeat.o(110714);
      return null;
    }
    if (locale.length() != paramInt)
    {
      ad.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(locale.length()) });
      locale.delete();
      azY(paramString1);
      com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 2L, 0L, null);
      AppMethodBeat.o(110714);
      return null;
    }
    if (locale.length() <= 5242880L)
    {
      String str = com.tencent.mm.vfs.i.aEN(q.B(locale.mUri));
      if (!paramString4.equalsIgnoreCase(str))
      {
        ad.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", new Object[] { paramString4, str });
        locale.delete();
        azY(paramString1);
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
    if ((paramString2.iLs) && (paramString2.BII != null))
    {
      AppMethodBeat.o(110714);
      return paramString2;
    }
    c.etK();
    c.fo(paramString1, 2);
    AppMethodBeat.o(110714);
    return null;
  }
  
  private static void kv(String paramString1, String paramString2)
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
        paramAnonymousBaseWepkgProcessTask = this.rVz;
        a locala = this.BJc;
        WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
        localWepkgCrossProcessTask.BX = 3006;
        localWepkgCrossProcessTask.BIL.fUW = paramAnonymousBaseWepkgProcessTask;
        localWepkgCrossProcessTask.BIL.BJB = false;
        if (aj.cbv())
        {
          com.tencent.mm.plugin.wepkg.utils.d.bNl().postToWorker(new i.11(localWepkgCrossProcessTask, locala));
          AppMethodBeat.o(110711);
          return;
        }
        localWepkgCrossProcessTask.jwt = new i.12(locala, localWepkgCrossProcessTask);
        localWepkgCrossProcessTask.aXm();
        AppBrandMainProcessService.a(localWepkgCrossProcessTask);
        AppMethodBeat.o(110711);
      }
    });
    AppMethodBeat.o(110717);
  }
  
  public static abstract interface a
  {
    public abstract void ar(JSONObject paramJSONObject);
  }
  
  static final class b
  {
    List<String> BJd;
    String version;
    String xkk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.h
 * JD-Core Version:    0.7.0.1
 */