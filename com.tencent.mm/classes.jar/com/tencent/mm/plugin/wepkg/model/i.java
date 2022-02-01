package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.edq;
import com.tencent.mm.protocal.protobuf.gfd;
import com.tencent.mm.protocal.protobuf.gip;
import com.tencent.mm.protocal.protobuf.gis;
import com.tencent.mm.protocal.protobuf.git;
import com.tencent.mm.protocal.protobuf.giw;
import com.tencent.mm.protocal.protobuf.gix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  public static List<String> a(edq paramedq)
  {
    AppMethodBeat.i(110713);
    if ((paramedq == null) || (paramedq.abiM == null))
    {
      AppMethodBeat.o(110713);
      return null;
    }
    Object localObject1 = paramedq.abiM.acfm;
    Object localObject2 = paramedq.abiM.acfn;
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 != null) && (((gip)localObject1).aceY != null)) {
      localArrayList.add(MD5Util.getMD5String(paramedq.IHV + ((gip)localObject1).aceY.IcC));
    }
    if ((localObject2 != null) && (!Util.isNullOrNil(((giw)localObject2).acfj)))
    {
      localObject1 = ((giw)localObject2).acfj.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (git)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((git)localObject2).aceY != null)) {
          localArrayList.add(MD5Util.getMD5String(paramedq.IHV + ((git)localObject2).aceY.IcC));
        }
      }
    }
    AppMethodBeat.o(110713);
    return localArrayList;
  }
  
  public static void a(final a parama)
  {
    AppMethodBeat.i(110715);
    final String str = e.iFq();
    final u localu = new u(str);
    if ((!localu.jKS()) || (!localu.isDirectory())) {
      parama.bl(null);
    }
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.bUl = 1001;
    localWepkgCrossProcessTask.rxj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110710);
        if (i.this.result) {
          d.dqg().postToWorker(new Runnable()
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
                  localJSONObject1.put("rootDir", i.1.this.XGl);
                  Object localObject1 = new HashMap();
                  i.a(i.1.this.XGm, (Map)localObject1);
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
                  localObject2 = j.bou((String)((Map.Entry)localObject3).getKey());
                  if (localObject2 != null) {
                    localJSONObject2.put("controlInfo", ((WepkgVersion)localObject2).iFu());
                  }
                  localObject4 = j.boy((String)((Map.Entry)localObject3).getKey());
                  if (!Util.isNullOrNil((List)localObject4))
                  {
                    localObject2 = new JSONArray();
                    localObject4 = ((List)localObject4).iterator();
                    if (((Iterator)localObject4).hasNext())
                    {
                      ((JSONArray)localObject2).put(((WepkgPreloadFile)((Iterator)localObject4).next()).iFu());
                      continue;
                    }
                    localJSONObject2.put("preloadFilesInfo", localObject2);
                  }
                }
                catch (Exception localException)
                {
                  if (i.1.this.XGn != null) {
                    i.1.this.XGn.bl(null);
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
                  if (!Util.isNullOrNil(((i.b)localObject5).RaJ))
                  {
                    localObject6 = new u(((i.b)localObject5).RaJ);
                    if ((!((u)localObject6).jKS()) || (!((u)localObject6).jKV())) {
                      continue;
                    }
                    ((JSONObject)localObject4).put("md5", y.bub(ah.v(((u)localObject6).mUri)));
                    ((JSONObject)localObject4).put("size", ((u)localObject6).length());
                    Object localObject7 = new g((u)localObject6).XFV;
                    if (localObject7 != null)
                    {
                      ((JSONObject)localObject4).put("charset", ((gfd)localObject7).accA);
                      ((JSONObject)localObject4).put("desc", ((gfd)localObject7).IGG);
                      if (((gfd)localObject7).accz != null)
                      {
                        localObject6 = new JSONArray();
                        localObject7 = ((gfd)localObject7).accz.iterator();
                        while (((Iterator)localObject7).hasNext())
                        {
                          asx localasx = (asx)((Iterator)localObject7).next();
                          JSONObject localJSONObject3 = new JSONObject();
                          localJSONObject3.put("rid", localasx.ZCY);
                          localJSONObject3.put("offset", localasx.ZCZ);
                          localJSONObject3.put("size", localasx.vhE);
                          localJSONObject3.put("mimeType", localasx.ZDa);
                          ((JSONArray)localObject6).put(localJSONObject3);
                        }
                        ((JSONObject)localObject4).put("resList", localObject6);
                      }
                    }
                  }
                  Object localObject6 = ((i.b)localObject5).XGq;
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
              if (i.1.this.XGn != null) {
                i.1.this.XGn.bl(localException);
              }
              AppMethodBeat.o(110709);
            }
          });
        }
        i.this.cpx();
        AppMethodBeat.o(110710);
      }
    };
    localWepkgCrossProcessTask.bQt();
    AppMethodBeat.o(110715);
  }
  
  public static g b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(110714);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString3)) || (Util.isNullOrNil(paramString4)))
    {
      Log.i("MicroMsg.Wepkg.WepkgManager", "pkgid or pkgPath or md5 is null, pkg invalid");
      AppMethodBeat.o(110714);
      return null;
    }
    u localu = new u(paramString3);
    if (!localu.jKS())
    {
      Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", new Object[] { paramString3 });
      bot(paramString1);
      com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 1L, 0L, null);
      AppMethodBeat.o(110714);
      return null;
    }
    if (localu.length() != paramInt)
    {
      Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(localu.length()) });
      localu.diJ();
      bot(paramString1);
      com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 2L, 0L, null);
      AppMethodBeat.o(110714);
      return null;
    }
    if (localu.length() <= 5242880L)
    {
      String str = y.bub(ah.v(localu.mUri));
      if (!paramString4.equalsIgnoreCase(str))
      {
        Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", new Object[] { paramString4, str });
        localu.diJ();
        bot(paramString1);
        com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 3L, 0L, null);
        AppMethodBeat.o(110714);
        return null;
      }
    }
    else
    {
      Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", new Object[] { Long.valueOf(localu.length()), Long.valueOf(5242880L) });
    }
    Log.i("MicroMsg.Wepkg.WepkgManager", "this is big package. localPath: %s", new Object[] { paramString3 });
    paramString2 = new g(localu);
    if ((paramString2.qDW) && (paramString2.XFV != null))
    {
      AppMethodBeat.o(110714);
      return paramString2;
    }
    c.iFn();
    c.aS(paramString1, 2, 4);
    AppMethodBeat.o(110714);
    return null;
  }
  
  public static h bos(String paramString)
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
        str = d.boB(paramString);
        localObject1 = d.boC(paramString);
        l = System.currentTimeMillis();
        if ((Util.isNullOrNil(str)) || (Util.isNullOrNil((String)localObject1)))
        {
          Log.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", new Object[] { str, localObject1 });
          paramString = new h(8, false, "");
          AppMethodBeat.o(110712);
          return paramString;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 6L, 1L, false);
        localWepkgVersion = j.bov(str);
        if (localWepkgVersion == null)
        {
          Log.i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", new Object[] { str, "", "" });
          com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.avh(14));
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 7L, 1L, false);
          paramString = new h(14, false, "");
          AppMethodBeat.o(110712);
          continue;
        }
        if (!localWepkgVersion.XGM) {
          break label235;
        }
      }
      finally {}
      if ((!localWepkgVersion.XGN) && (localWepkgVersion.XGO))
      {
        Log.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", new Object[] { localWepkgVersion.mtT, localWepkgVersion.version, Boolean.valueOf(localWepkgVersion.XGM), Boolean.valueOf(localWepkgVersion.XGN), Boolean.valueOf(localWepkgVersion.XGO) });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.avh(16));
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 10L, 1L, false);
        paramString = new h(16, false, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else if (!((String)localObject1).equalsIgnoreCase(localWepkgVersion.domain))
      {
        Log.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", new Object[] { str, localWepkgVersion.version, localObject1, localWepkgVersion.domain });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.avh(13));
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 8L, 1L, false);
        paramString = new h(13, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else if (Util.isNullOrNil(localWepkgVersion.version))
      {
        Log.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", new Object[] { str });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.avh(15));
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 9L, 1L, false);
        paramString = new h(15, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else
      {
        localg = b(str, localWepkgVersion.version, localWepkgVersion.pkgPath, localWepkgVersion.md5, localWepkgVersion.XGK);
        if ((localg != null) || (Util.isNullOrNil(localWepkgVersion.pkgPath))) {
          break;
        }
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.avh(17));
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 11L, 1L, false);
        paramString = new h(17, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
    }
    boolean bool = localWepkgVersion.XGO;
    if (Util.isNullOrNil(str)) {
      localObject1 = null;
    }
    for (;;)
    {
      HashMap localHashMap;
      int i;
      if (localObject1 == null)
      {
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.avh(18));
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 11L, 1L, false);
        paramString = new h(18, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
        break;
        localHashMap = new HashMap();
        Object localObject2 = j.boy(str);
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
                oN(((WepkgPreloadFile)localObject2).mtT, ((WepkgPreloadFile)localObject2).XGe);
                i = 1;
              }
              else
              {
                j.a(str, ((WepkgPreloadFile)localObject2).XGe, "", null);
              }
            }
            else
            {
              u localu = new u(((WepkgPreloadFile)localObject2).filePath);
              if (!localu.jKS())
              {
                Log.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", new Object[] { ((WepkgPreloadFile)localObject2).filePath, Boolean.valueOf(bool) });
                if (bool)
                {
                  oN(((WepkgPreloadFile)localObject2).mtT, ((WepkgPreloadFile)localObject2).XGe);
                  i = 1;
                }
                else
                {
                  j.a(str, ((WepkgPreloadFile)localObject2).XGe, "", null);
                }
              }
              else if (localu.length() != ((WepkgPreloadFile)localObject2).size)
              {
                Log.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", new Object[] { Integer.valueOf(((WepkgPreloadFile)localObject2).size), Long.valueOf(localu.length()), Boolean.valueOf(bool) });
                if (bool)
                {
                  oN(((WepkgPreloadFile)localObject2).mtT, ((WepkgPreloadFile)localObject2).XGe);
                  localu.diJ();
                  i = 1;
                }
                else
                {
                  j.a(str, ((WepkgPreloadFile)localObject2).XGe, "", null);
                }
              }
              else
              {
                localHashMap.put(((WepkgPreloadFile)localObject2).XGe, localObject2);
              }
            }
          }
        }
      }
      paramString = new h(localWepkgVersion, localg, (Map)localObject1);
      Log.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 12L, 1L, false);
      AppMethodBeat.o(110712);
      break;
      localObject1 = localHashMap;
      if (i != 0) {
        localObject1 = null;
      }
    }
  }
  
  private static void bot(String paramString)
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
  
  private static void oN(String paramString1, String paramString2)
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
        paramAnonymousBaseWepkgProcessTask = i.this;
        a locala = this.XGp;
        WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
        localWepkgCrossProcessTask.bUl = 3006;
        localWepkgCrossProcessTask.XFY.mtT = paramAnonymousBaseWepkgProcessTask;
        localWepkgCrossProcessTask.XFY.XGN = false;
        if (MMApplicationContext.isMMProcess())
        {
          d.dqg().postToWorker(new j.11(localWepkgCrossProcessTask, locala));
          AppMethodBeat.o(110711);
          return;
        }
        localWepkgCrossProcessTask.rxj = new j.12(locala, localWepkgCrossProcessTask);
        localWepkgCrossProcessTask.bQt();
        AppMethodBeat.o(110711);
      }
    });
    AppMethodBeat.o(110717);
  }
  
  public static abstract interface a
  {
    public abstract void bl(JSONObject paramJSONObject);
  }
  
  static final class b
  {
    String RaJ;
    List<String> XGq;
    String version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.i
 * JD-Core Version:    0.7.0.1
 */