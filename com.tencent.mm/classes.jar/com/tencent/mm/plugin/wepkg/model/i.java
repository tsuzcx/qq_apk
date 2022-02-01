package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.dlf;
import com.tencent.mm.protocal.protobuf.fiq;
import com.tencent.mm.protocal.protobuf.flw;
import com.tencent.mm.protocal.protobuf.flz;
import com.tencent.mm.protocal.protobuf.fma;
import com.tencent.mm.protocal.protobuf.fmd;
import com.tencent.mm.protocal.protobuf.fme;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
    q localq = new q(paramString3);
    if (!localq.ifE())
    {
      Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", new Object[] { paramString3 });
      boF(paramString1);
      com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 1L, 0L, null);
      AppMethodBeat.o(110714);
      return null;
    }
    if (localq.length() != paramInt)
    {
      Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(localq.length()) });
      localq.cFq();
      boF(paramString1);
      com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 2L, 0L, null);
      AppMethodBeat.o(110714);
      return null;
    }
    if (localq.length() <= 5242880L)
    {
      String str = u.buc(localq.getPath());
      if (!paramString4.equalsIgnoreCase(str))
      {
        Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", new Object[] { paramString4, str });
        localq.cFq();
        boF(paramString1);
        com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, paramString1, paramString2, 3L, 0L, null);
        AppMethodBeat.o(110714);
        return null;
      }
    }
    else
    {
      Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", new Object[] { Long.valueOf(localq.length()), Long.valueOf(5242880L) });
    }
    Log.i("MicroMsg.Wepkg.WepkgManager", "this is big package. localPath: %s", new Object[] { paramString3 });
    paramString2 = new g(localq);
    if ((paramString2.nEb) && (paramString2.QMx != null))
    {
      AppMethodBeat.o(110714);
      return paramString2;
    }
    c.heF();
    c.aK(paramString1, 2, 4);
    AppMethodBeat.o(110714);
    return null;
  }
  
  public static List<String> a(dlf paramdlf)
  {
    AppMethodBeat.i(110713);
    if ((paramdlf == null) || (paramdlf.TSn == null))
    {
      AppMethodBeat.o(110713);
      return null;
    }
    Object localObject1 = paramdlf.TSn.UKY;
    Object localObject2 = paramdlf.TSn.UKZ;
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 != null) && (((flw)localObject1).UKK != null)) {
      localArrayList.add(MD5Util.getMD5String(paramdlf.CNL + ((flw)localObject1).UKK.Cqt));
    }
    if ((localObject2 != null) && (!Util.isNullOrNil(((fmd)localObject2).UKV)))
    {
      localObject1 = ((fmd)localObject2).UKV.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (fma)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((fma)localObject2).UKK != null)) {
          localArrayList.add(MD5Util.getMD5String(paramdlf.CNL + ((fma)localObject2).UKK.Cqt));
        }
      }
    }
    AppMethodBeat.o(110713);
    return localArrayList;
  }
  
  public static void a(final a parama)
  {
    AppMethodBeat.i(110715);
    final String str = e.heI();
    final q localq = new q(str);
    if ((!localq.ifE()) || (!localq.isDirectory())) {
      parama.aY(null);
    }
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.Vh = 1001;
    localWepkgCrossProcessTask.otv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110710);
        if (this.QMM.result) {
          d.cMC().postToWorker(new Runnable()
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
                  localJSONObject1.put("rootDir", i.1.this.QMN);
                  Object localObject1 = new HashMap();
                  i.a(i.1.this.QMO, (Map)localObject1);
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
                  localObject2 = j.boG((String)((Map.Entry)localObject3).getKey());
                  if (localObject2 != null) {
                    localJSONObject2.put("controlInfo", ((WepkgVersion)localObject2).heM());
                  }
                  localObject4 = j.boK((String)((Map.Entry)localObject3).getKey());
                  if (!Util.isNullOrNil((List)localObject4))
                  {
                    localObject2 = new JSONArray();
                    localObject4 = ((List)localObject4).iterator();
                    if (((Iterator)localObject4).hasNext())
                    {
                      ((JSONArray)localObject2).put(((WepkgPreloadFile)((Iterator)localObject4).next()).heM());
                      continue;
                    }
                    localJSONObject2.put("preloadFilesInfo", localObject2);
                  }
                }
                catch (Exception localException)
                {
                  if (i.1.this.QMP != null) {
                    i.1.this.QMP.aY(null);
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
                  if (!Util.isNullOrNil(((i.b)localObject5).KBc))
                  {
                    localObject6 = new q(((i.b)localObject5).KBc);
                    if ((!((q)localObject6).ifE()) || (!((q)localObject6).ifH())) {
                      continue;
                    }
                    ((JSONObject)localObject4).put("md5", u.buc(((q)localObject6).getPath()));
                    ((JSONObject)localObject4).put("size", ((q)localObject6).length());
                    Object localObject7 = new g((q)localObject6).QMx;
                    if (localObject7 != null)
                    {
                      ((JSONObject)localObject4).put("charset", ((fiq)localObject7).UIr);
                      ((JSONObject)localObject4).put("desc", ((fiq)localObject7).CMB);
                      if (((fiq)localObject7).UIq != null)
                      {
                        localObject6 = new JSONArray();
                        localObject7 = ((fiq)localObject7).UIq.iterator();
                        while (((Iterator)localObject7).hasNext())
                        {
                          ape localape = (ape)((Iterator)localObject7).next();
                          JSONObject localJSONObject3 = new JSONObject();
                          localJSONObject3.put("rid", localape.SCg);
                          localJSONObject3.put("offset", localape.SCh);
                          localJSONObject3.put("size", localape.rWo);
                          localJSONObject3.put("mimeType", localape.SCi);
                          ((JSONArray)localObject6).put(localJSONObject3);
                        }
                        ((JSONObject)localObject4).put("resList", localObject6);
                      }
                    }
                  }
                  Object localObject6 = ((i.b)localObject5).QMS;
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
              if (i.1.this.QMP != null) {
                i.1.this.QMP.aY(localException);
              }
              AppMethodBeat.o(110709);
            }
          });
        }
        this.QMM.bPk();
        AppMethodBeat.o(110710);
      }
    };
    localWepkgCrossProcessTask.bsM();
    AppMethodBeat.o(110715);
  }
  
  public static h boE(String paramString)
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
        str = d.boN(paramString);
        localObject1 = d.boO(paramString);
        l = System.currentTimeMillis();
        if ((Util.isNullOrNil(str)) || (Util.isNullOrNil((String)localObject1)))
        {
          Log.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", new Object[] { str, localObject1 });
          paramString = new h(8, false, "");
          AppMethodBeat.o(110712);
          return paramString;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(859L, 6L, 1L, false);
        localWepkgVersion = j.boH(str);
        if (localWepkgVersion == null)
        {
          Log.i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", new Object[] { str, "", "" });
          com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.apj(14));
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(859L, 7L, 1L, false);
          paramString = new h(14, false, "");
          AppMethodBeat.o(110712);
          continue;
        }
        if (!localWepkgVersion.QNo) {
          break label235;
        }
      }
      finally {}
      if ((!localWepkgVersion.QNp) && (localWepkgVersion.QNq))
      {
        Log.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", new Object[] { localWepkgVersion.jTB, localWepkgVersion.version, Boolean.valueOf(localWepkgVersion.QNo), Boolean.valueOf(localWepkgVersion.QNp), Boolean.valueOf(localWepkgVersion.QNq) });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.apj(16));
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(859L, 10L, 1L, false);
        paramString = new h(16, false, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else if (!((String)localObject1).equalsIgnoreCase(localWepkgVersion.domain))
      {
        Log.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", new Object[] { str, localWepkgVersion.version, localObject1, localWepkgVersion.domain });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.apj(13));
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(859L, 8L, 1L, false);
        paramString = new h(13, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else if (Util.isNullOrNil(localWepkgVersion.version))
      {
        Log.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", new Object[] { str });
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, null, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.apj(15));
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(859L, 9L, 1L, false);
        paramString = new h(15, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
      else
      {
        localg = a(str, localWepkgVersion.version, localWepkgVersion.pkgPath, localWepkgVersion.md5, localWepkgVersion.QNm);
        if ((localg != null) || (Util.isNullOrNil(localWepkgVersion.pkgPath))) {
          break;
        }
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.apj(17));
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(859L, 11L, 1L, false);
        paramString = new h(17, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
      }
    }
    boolean bool = localWepkgVersion.QNq;
    if (Util.isNullOrNil(str)) {
      localObject1 = null;
    }
    for (;;)
    {
      HashMap localHashMap;
      int i;
      if (localObject1 == null)
      {
        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", paramString, str, localWepkgVersion.version, 0L, 0L, com.tencent.mm.plugin.wepkg.utils.a.apj(18));
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(859L, 11L, 1L, false);
        paramString = new h(18, true, localWepkgVersion.version);
        AppMethodBeat.o(110712);
        break;
        localHashMap = new HashMap();
        Object localObject2 = j.boK(str);
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
                mX(((WepkgPreloadFile)localObject2).jTB, ((WepkgPreloadFile)localObject2).QMG);
                i = 1;
              }
              else
              {
                j.a(str, ((WepkgPreloadFile)localObject2).QMG, "", null);
              }
            }
            else
            {
              q localq = new q(((WepkgPreloadFile)localObject2).filePath);
              if (!localq.ifE())
              {
                Log.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", new Object[] { ((WepkgPreloadFile)localObject2).filePath, Boolean.valueOf(bool) });
                if (bool)
                {
                  mX(((WepkgPreloadFile)localObject2).jTB, ((WepkgPreloadFile)localObject2).QMG);
                  i = 1;
                }
                else
                {
                  j.a(str, ((WepkgPreloadFile)localObject2).QMG, "", null);
                }
              }
              else if (localq.length() != ((WepkgPreloadFile)localObject2).size)
              {
                Log.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", new Object[] { Integer.valueOf(((WepkgPreloadFile)localObject2).size), Long.valueOf(localq.length()), Boolean.valueOf(bool) });
                if (bool)
                {
                  mX(((WepkgPreloadFile)localObject2).jTB, ((WepkgPreloadFile)localObject2).QMG);
                  localq.cFq();
                  i = 1;
                }
                else
                {
                  j.a(str, ((WepkgPreloadFile)localObject2).QMG, "", null);
                }
              }
              else
              {
                localHashMap.put(((WepkgPreloadFile)localObject2).QMG, localObject2);
              }
            }
          }
        }
      }
      paramString = new h(localWepkgVersion, localg, (Map)localObject1);
      Log.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(859L, 12L, 1L, false);
      AppMethodBeat.o(110712);
      break;
      localObject1 = localHashMap;
      if (i != 0) {
        localObject1 = null;
      }
    }
  }
  
  private static void boF(String paramString)
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
  
  private static void mX(String paramString1, String paramString2)
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
        paramAnonymousBaseWepkgProcessTask = this.CIC;
        a locala = this.QMR;
        WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
        localWepkgCrossProcessTask.Vh = 3006;
        localWepkgCrossProcessTask.QMA.jTB = paramAnonymousBaseWepkgProcessTask;
        localWepkgCrossProcessTask.QMA.QNp = false;
        if (MMApplicationContext.isMMProcess())
        {
          d.cMC().postToWorker(new j.11(localWepkgCrossProcessTask, locala));
          AppMethodBeat.o(110711);
          return;
        }
        localWepkgCrossProcessTask.otv = new j.12(locala, localWepkgCrossProcessTask);
        localWepkgCrossProcessTask.bsM();
        AppMethodBeat.o(110711);
      }
    });
    AppMethodBeat.o(110717);
  }
  
  public static abstract interface a
  {
    public abstract void aY(JSONObject paramJSONObject);
  }
  
  static final class b
  {
    String KBc;
    List<String> QMS;
    String version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.i
 * JD-Core Version:    0.7.0.1
 */