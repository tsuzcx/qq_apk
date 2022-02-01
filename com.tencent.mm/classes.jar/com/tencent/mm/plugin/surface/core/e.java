package com.tencent.mm.plugin.surface.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.protocal.protobuf.edp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/PackageDownloadManager;", "", "()V", "APPID_2_USERNAME", "Ljava/util/concurrent/ConcurrentHashMap;", "", "kotlin.jvm.PlatformType", "getAPPID_2_USERNAME", "()Ljava/util/concurrent/ConcurrentHashMap;", "KEY_PKG_DOWNLOAD_APPIDS", "TAG", "finderLiveGameAppId", "libAppId", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "pkgDownloadAppIds", "Ljava/util/LinkedList;", "getPkgDownloadAppIds", "()Ljava/util/LinkedList;", "pkgDownloadAppIds$delegate", "pkgUpdateEventListener", "com/tencent/mm/plugin/surface/core/PackageDownloadManager$pkgUpdateEventListener$1", "Lcom/tencent/mm/plugin/surface/core/PackageDownloadManager$pkgUpdateEventListener$1;", "preDownLoadSceneDefault", "", "previewMode", "getPreviewMode", "()I", "previewMode$delegate", "triggerDownLoadPkgInterval", "", "getTriggerDownLoadPkgInterval", "()J", "triggerDownLoadPkgInterval$delegate", "addBizPkgAppId", "", "appId", "checkPreviewVersion", "downloadPkg", "getBizAppIds", "getPkgInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "pkgType", "getPkgPath", "getPreviewPkgPath", "getReleasePkgPath", "getWxaPkgVersion", "init", "isPreviewMode", "", "regPkgUpdateEventListener", "saveBizAppIds", "triggerPreDownload", "scene", "currentUseVersion", "lastDownloadTime", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e SKg;
  private static final j SKh;
  private static final j SKi;
  private static final j SKj;
  private static final PackageDownloadManager.pkgUpdateEventListener.1 SKk;
  private static final j exj;
  private static final ConcurrentHashMap<String, String> raM;
  
  static
  {
    AppMethodBeat.i(265346);
    SKg = new e();
    exj = k.cm((kotlin.g.a.a)a.SKl);
    SKh = k.cm((kotlin.g.a.a)c.SKn);
    SKi = k.cm((kotlin.g.a.a)b.SKm);
    SKj = k.cm((kotlin.g.a.a)d.SKo);
    Map localMap = ak.f(new r[] { v.Y("wx9e221f7828fa7482", "gh_54c3d560a72d@app") });
    Object localObject = i.SKz;
    if (i.hBN()) {
      localMap.put("wx4edd479d258d7f25", "gh_071444f0c9bf@app");
    }
    localObject = ah.aiuX;
    raM = new ConcurrentHashMap(localMap);
    SKk = new PackageDownloadManager.pkgUpdateEventListener.1(com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(265346);
  }
  
  private static final void Q(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(265334);
    s.u(paramString1, "$appId");
    Log.e("MicroMsg.SurfaceApp.PackageDownloadManager", "checkPreviewVersion(appId:" + paramString1 + "), onError(errCode:" + paramInt + ", errMsg:" + paramString2 + ')');
    AppMethodBeat.o(265334);
  }
  
  private static final void a(String paramString1, bh parambh, String paramString2)
  {
    AppMethodBeat.i(265330);
    s.u(paramString1, "$appId");
    s.u(parambh, "record");
    s.u(paramString2, "filePath");
    Log.i("MicroMsg.SurfaceApp.PackageDownloadManager", "checkPreviewVersion(appId:" + paramString1 + "), onSuccess(path:" + paramString2 + ')');
    AppMethodBeat.o(265330);
  }
  
  private static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(265223);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(265223);
    return localMultiProcessMMKV;
  }
  
  private static String bcQ(String paramString)
  {
    AppMethodBeat.i(265247);
    s.u(paramString, "<this>");
    paramString = s.X("surfaceLastUseVersion_", paramString);
    AppMethodBeat.o(265247);
    return paramString;
  }
  
  private static String bcR(String paramString)
  {
    AppMethodBeat.i(265254);
    s.u(paramString, "<this>");
    paramString = s.X("lastDownLoadTime_", paramString);
    AppMethodBeat.o(265254);
    return paramString;
  }
  
  public static String bcS(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(265269);
    s.u(paramString, "appId");
    if (hBF() == 1) {}
    while (i != 0)
    {
      s.u(paramString, "appId");
      paramString = hn(paramString, 2);
      if (paramString == null)
      {
        AppMethodBeat.o(265269);
        return null;
        i = 0;
      }
      else
      {
        paramString = paramString.field_pkgPath;
        AppMethodBeat.o(265269);
        return paramString;
      }
    }
    s.u(paramString, "appId");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(265269);
      return null;
    }
    bh localbh = hn(paramString, 0);
    if (localbh == null)
    {
      Log.i("MicroMsg.SurfaceApp.PackageDownloadManager", "geReleasePkgPath pkgInfo is null");
      AppMethodBeat.o(265269);
      return null;
    }
    if (!com.tencent.mm.vfs.y.ZC(localbh.field_pkgPath))
    {
      Log.i("MicroMsg.SurfaceApp.PackageDownloadManager", "geReleasePkgPath pkgInfo " + localbh.field_pkgPath + " not exist");
      AppMethodBeat.o(265269);
      return null;
    }
    atj().encode(bcQ(paramString), localbh.field_version);
    paramString = localbh.field_pkgPath;
    AppMethodBeat.o(265269);
    return paramString;
  }
  
  private void bcT(String paramString)
  {
    try
    {
      AppMethodBeat.i(265298);
      s.u(paramString, "appId");
      if (!hBG().contains(paramString))
      {
        hBG().add(paramString);
        x localx = (x)com.tencent.mm.kernel.h.ax(x.class);
        if (localx != null) {
          localx.bM(paramString, 0);
        }
        hBJ();
      }
      AppMethodBeat.o(265298);
      return;
    }
    finally {}
  }
  
  private final void bcV(String paramString)
  {
    AppMethodBeat.i(265310);
    ((com.tencent.mm.plugin.appbrand.service.y)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.y.class)).z(null, paramString, 12);
    bcT(paramString);
    AppMethodBeat.o(265310);
  }
  
  private static void bcW(String paramString)
  {
    AppMethodBeat.i(265312);
    ((w)com.tencent.mm.kernel.h.ax(w.class)).a(paramString, 2, new e..ExternalSyntheticLambda1(paramString), new e..ExternalSyntheticLambda0(paramString));
    AppMethodBeat.o(265312);
  }
  
  private static int hBF()
  {
    AppMethodBeat.i(265231);
    int i = ((Number)SKh.getValue()).intValue();
    AppMethodBeat.o(265231);
    return i;
  }
  
  public static LinkedList<String> hBG()
  {
    AppMethodBeat.i(265239);
    LinkedList localLinkedList = (LinkedList)SKi.getValue();
    AppMethodBeat.o(265239);
    return localLinkedList;
  }
  
  private static long hBH()
  {
    AppMethodBeat.i(265261);
    long l = ((Number)SKj.getValue()).longValue();
    AppMethodBeat.o(265261);
    return l;
  }
  
  private final LinkedList<String> hBI()
  {
    int j = 1;
    label187:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(265285);
        Object localObject1 = atj();
        s.s(localObject1, "mmkv");
        if (((MultiProcessMMKV)localObject1).containsKey("KPkgDownloadBizAppIds"))
        {
          localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes("KPkgDownloadBizAppIds");
          if (localObject1 != null)
          {
            int i = localObject1.length;
            if (i == 0)
            {
              i = 1;
              if (i != 0) {
                continue;
              }
              i = j;
              if (i == 0) {
                break label187;
              }
            }
            try
            {
              Object localObject4 = edp.class.newInstance();
              ((com.tencent.mm.bx.a)localObject4).parseFrom((byte[])localObject1);
              localObject1 = (com.tencent.mm.bx.a)localObject4;
              localObject1 = (edp)localObject1;
              if (localObject1 != null) {
                continue;
              }
              localObject1 = null;
              localObject4 = localObject1;
              if (localObject1 == null) {
                localObject4 = new LinkedList();
              }
              Log.d("MicroMsg.SurfaceApp.PackageDownloadManager", s.X("getBizAppIds size ", Integer.valueOf(((LinkedList)localObject4).size())));
              AppMethodBeat.o(265285);
              return localObject4;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
            }
            i = 0;
            continue;
            i = 0;
            continue;
            LinkedList localLinkedList = localException.abiK;
            continue;
          }
        }
        Object localObject3 = null;
      }
      finally {}
    }
  }
  
  private final void hBJ()
  {
    try
    {
      AppMethodBeat.i(265293);
      try
      {
        MultiProcessMMKV localMultiProcessMMKV = atj();
        edp localedp = new edp();
        localedp.abiK = hBG();
        ah localah = ah.aiuX;
        localMultiProcessMMKV.encode("KPkgDownloadBizAppIds", localedp.toByteArray());
        AppMethodBeat.o(265293);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SurfaceApp.PackageDownloadManager", s.X("saveBizAppIds ex ", localException.getMessage()));
          AppMethodBeat.o(265293);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void hBK()
  {
    AppMethodBeat.i(265320);
    SKk.alive();
    AppMethodBeat.o(265320);
  }
  
  private static final void hBL()
  {
    AppMethodBeat.i(265324);
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).addAll((Collection)hBG());
    Log.i("MicroMsg.SurfaceApp.PackageDownloadManager", s.X("init appId size = ", Integer.valueOf(((LinkedList)localObject1).size())));
    localObject1 = ((Iterable)localObject1).iterator();
    label222:
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      if (raM.containsKey(str))
      {
        localObject2 = (w)com.tencent.mm.kernel.h.ax(w.class);
        if (localObject2 != null) {
          ((w)localObject2).A((String)raM.get(str), str, 998);
        }
      }
      Object localObject2 = hn(str, 0);
      if (localObject2 != null)
      {
        x localx = (x)com.tencent.mm.kernel.h.ax(x.class);
        if (localx != null) {
          localx.bM(str, ((bh)localObject2).field_version);
        }
        int j = atj().decodeInt(bcQ(str), ((bh)localObject2).field_version);
        if (j == ((bh)localObject2).field_version) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label222;
          }
          localObject2 = (x)com.tencent.mm.kernel.h.ax(x.class);
          if (localObject2 == null) {
            break;
          }
          ((x)localObject2).bM(str, j);
          break;
        }
      }
    }
    AppMethodBeat.o(265324);
  }
  
  private static bh hn(String paramString, int paramInt)
  {
    AppMethodBeat.i(265275);
    s.u(paramString, "appId");
    for (;;)
    {
      try
      {
        localbh = ((x)com.tencent.mm.kernel.h.ax(x.class)).L(paramString, paramInt, 0);
        StringBuilder localStringBuilder = new StringBuilder("getPkgInfo appId=").append(paramString).append(", pkgType=").append(paramInt).append(", md5=");
        if (localbh != null) {
          continue;
        }
        paramString = null;
        localStringBuilder = localStringBuilder.append(paramString).append(" download version= ");
        if (localbh != null) {
          continue;
        }
        paramString = null;
        localStringBuilder = localStringBuilder.append(paramString).append(" path=");
        if (localbh != null) {
          continue;
        }
        paramString = null;
        Log.i("MicroMsg.SurfaceApp.PackageDownloadManager", paramString);
        paramString = localbh;
      }
      catch (Exception paramString)
      {
        bh localbh;
        Log.w("MicroMsg.SurfaceApp.PackageDownloadManager", s.X("getPreviewPkgPath ex ", paramString.getMessage()));
        paramString = null;
        continue;
      }
      AppMethodBeat.o(265275);
      return paramString;
      paramString = localbh.field_versionMd5;
      continue;
      paramString = Integer.valueOf(localbh.field_version);
      continue;
      paramString = localbh.field_pkgPath;
    }
  }
  
  public static void init()
  {
    AppMethodBeat.i(265304);
    com.tencent.threadpool.h.ahAA.a(e..ExternalSyntheticLambda2.INSTANCE, 15000L, "PackageDownloadManager");
    AppMethodBeat.o(265304);
  }
  
  public final void bcU(String paramString)
  {
    AppMethodBeat.i(265365);
    s.u(paramString, "appId");
    long l2 = atj().getLong(bcR(paramString), 0L);
    long l1 = System.currentTimeMillis();
    l2 = Math.abs(l1 - l2);
    if (((hBF() == 0) && (l2 < hBH())) || ((hBF() != 0) && (l2 < 10000L)))
    {
      Log.d("MicroMsg.SurfaceApp.PackageDownloadManager", s.X("checkPreDownload return ", Integer.valueOf(hBF())));
      AppMethodBeat.o(265365);
      return;
    }
    Log.i("MicroMsg.SurfaceApp.PackageDownloadManager", s.X("checkPreDownload ", paramString));
    atj().encode(bcR(paramString), l1);
    if (hBF() == 1) {
      bcW(paramString);
    }
    for (;;)
    {
      paramString = f.SKp;
      f.a.wi(0L);
      AppMethodBeat.o(265365);
      return;
      bcV(paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final a SKl;
    
    static
    {
      AppMethodBeat.i(265215);
      SKl = new a();
      AppMethodBeat.o(265215);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<LinkedList<String>>
  {
    public static final b SKm;
    
    static
    {
      AppMethodBeat.i(265226);
      SKm = new b();
      AppMethodBeat.o(265226);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final c SKn;
    
    static
    {
      AppMethodBeat.i(265229);
      SKn = new c();
      AppMethodBeat.o(265229);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Long>
  {
    public static final d SKo;
    
    static
    {
      AppMethodBeat.i(265224);
      SKo = new d();
      AppMethodBeat.o(265224);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.core.e
 * JD-Core Version:    0.7.0.1
 */