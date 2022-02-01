package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.acm;
import com.tencent.mm.f.a.acm.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.service.u.a;
import com.tencent.mm.plugin.appbrand.service.u.b;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.protocal.protobuf.tw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Result;
import kotlin.a.j;
import kotlin.g;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic;", "", "()V", "KEY_PREFETCHER_BIZ_APPIDS", "", "KEY_WEB_CANVAS_LAST_CLEAR_PKG_TIME", "KEY_WEB_CANVAS_LAST_DOWNLOAD_PKG_BY_GET_DATA_TIME", "KEY_WEB_CANVAS_PREVIEW_PKG_MD5", "TAG", "WEB_CANVAS_PKG_PATH", "getWEB_CANVAS_PKG_PATH", "()Ljava/lang/String;", "adPrefetchAppId", "bizPkgAppId", "lastTriggerPreDownloadTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "pkgDownloadOpen", "", "getPkgDownloadOpen", "()Z", "pkgDownloadOpen$delegate", "pkgUpdateEventListener", "com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1;", "prefetchBasePkgAppId", "prefetchBizPkgAppIds", "Ljava/util/LinkedList;", "getPrefetchBizPkgAppIds", "()Ljava/util/LinkedList;", "prefetchBizPkgAppIds$delegate", "previewMode", "", "getPreviewMode", "()I", "previewMode$delegate", "triggerDownLoadPkgInterval", "getTriggerDownLoadPkgInterval", "()J", "triggerDownLoadPkgInterval$delegate", "triggerDownLoadPkgOnGetDataInterval", "getTriggerDownLoadPkgOnGetDataInterval", "triggerDownLoadPkgOnGetDataInterval$delegate", "triggerDownLoadPrefetchPkgInterval", "getTriggerDownLoadPrefetchPkgInterval", "triggerDownLoadPrefetchPkgInterval$delegate", "webPrefetchPkgInterval", "getWebPrefetchPkgInterval", "webPrefetchPkgInterval$delegate", "wxaPkgAppId", "minBasePkgVersion", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getMinBasePkgVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "minClientVersion", "getMinClientVersion", "addPrefetchBizPkgAppId", "", "appId", "checkPreviewVersion", "clearInvalidPkg", "force", "fetchBizPrefetchPkg", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "userName", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBizAppIds", "getPkgDirectory", "getPkgInfo", "Lcom/tencent/mm/protocal/protobuf/CanvasPkgInfo;", "getPreviewPkgPath", "pkgType", "getReleasePkgPath", "getWebCanvasCachePath", "getWxaPkgVersion", "isPkgValid", "path", "wxaVersion", "isWxaPkgSupport", "bizPkg", "wxaPkg", "regPkgUpdateEventListener", "saveBizAppIds", "saveWxaPkgInfo", "pkg", "triggerPreDownload", "triggerPreDownloadBizPrefetchPkg", "interval", "triggerPreDownloadByGetData", "triggerPreDownloadPrefetchBasePkg", "triggerPreDownloadPrefetchPkg", "lastDownloadTime", "lastUsePathKey", "lastUseTimeKey", "pkgInfoKey", "PkgDownloadReporter", "webview-sdk_release"})
public final class m
{
  private static final String PuC;
  private static final kotlin.f PuD;
  private static final kotlin.f PuE;
  private static final kotlin.f PuF;
  private static final kotlin.f PuG;
  private static final kotlin.f PuH;
  private static final kotlin.f PuI;
  private static final kotlin.f PuJ;
  private static final h PuK;
  public static final m PuL;
  private static final kotlin.f lrB;
  private static long svS;
  
  static
  {
    AppMethodBeat.i(206919);
    PuL = new m();
    PuC = com.tencent.mm.loader.j.b.aSD() + "/WebCanvasPkg";
    PuD = g.ar((kotlin.g.a.a)i.PuT);
    lrB = g.ar((kotlin.g.a.a)f.PuR);
    PuE = g.ar((kotlin.g.a.a)j.PuU);
    PuF = g.ar((kotlin.g.a.a)g.PuS);
    PuG = g.ar((kotlin.g.a.a)l.PuW);
    PuH = g.ar((kotlin.g.a.a)m.PuX);
    PuI = g.ar((kotlin.g.a.a)k.PuV);
    PuJ = g.ar((kotlin.g.a.a)p.PuY);
    PuK = new h();
    AppMethodBeat.o(206919);
  }
  
  public static void CF(boolean paramBoolean)
  {
    AppMethodBeat.i(206918);
    long l2 = bcJ().decodeLong("webcanvas_last_clear_pkg_time", 0L);
    long l1 = System.currentTimeMillis();
    l2 = Math.abs(l1 - l2);
    if ((!paramBoolean) && (l2 < 86400000L))
    {
      Log.d("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg delta ".concat(String.valueOf(l2)));
      AppMethodBeat.o(206918);
      return;
    }
    bcJ().encode("webcanvas_last_clear_pkg_time", l1);
    com.tencent.e.h.ZvG.o((Runnable)d.PuP, 10000L);
    AppMethodBeat.o(206918);
  }
  
  public static void a(String paramString, tw paramtw)
  {
    AppMethodBeat.i(206904);
    kotlin.g.b.p.k(paramString, "appId");
    kotlin.g.b.p.k(paramtw, "pkg");
    bcJ().encode(bil(paramString), paramtw.toByteArray());
    AppMethodBeat.o(206904);
  }
  
  public static boolean a(com.tencent.mm.plugin.appbrand.appcache.p paramp1, com.tencent.mm.plugin.appbrand.appcache.p paramp2)
  {
    AppMethodBeat.i(206903);
    kotlin.g.b.p.k(paramp1, "bizPkg");
    kotlin.g.b.p.k(paramp2, "wxaPkg");
    try
    {
      kotlin.g.b.p.k(paramp1, "$this$minBasePkgVersion");
      int i = new com.tencent.mm.ad.i(com.tencent.mm.plugin.webview.l.a.a(paramp1, "/meta.json")).optInt("minAndroidBasePkgVersion");
      int j = com.tencent.mm.plugin.webview.l.a.b(paramp2);
      Log.i("MicroMsg.WebCanvasStorageLogic", "isPkgValid minBasePkgVersion=" + i + ", wxaPkgVersionn=" + j);
      if (i <= j)
      {
        AppMethodBeat.o(206903);
        return true;
      }
      Log.w("MicroMsg.WebCanvasStorageLogic", "isWxaPkgSupport minBasePkgVersion check fail");
      paramp1 = l.PuB;
      l.Tt(59L);
    }
    catch (Exception paramp1)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebCanvasStorageLogic", "isWxaPkgSupport ex " + paramp1.getMessage());
      }
    }
    AppMethodBeat.o(206903);
    return false;
  }
  
  private static boolean as(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(206899);
    if (!com.tencent.mm.vfs.u.agG(paramString2))
    {
      Log.w("MicroMsg.WebCanvasStorageLogic", "isPkgValid file not exit ".concat(String.valueOf(paramString2)));
      switch (paramString1.hashCode())
      {
      }
      for (;;)
      {
        paramString2 = a.PuM;
        a.t(paramString1, paramInt, 0, 3);
        AppMethodBeat.o(206899);
        return false;
        if (paramString1.equals("wx97b7aebac2183fd2"))
        {
          paramString2 = l.PuB;
          l.Tt(49L);
          continue;
          if (paramString1.equals("wxfedb0854e2b1820d"))
          {
            paramString2 = l.PuB;
            l.Tt(42L);
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = new WxaPkg(paramString2);
        paramString2.bGl();
        com.tencent.mm.plugin.appbrand.appcache.p localp = (com.tencent.mm.plugin.appbrand.appcache.p)paramString2;
        kotlin.g.b.p.k(localp, "$this$minClientVersion");
        int i = new com.tencent.mm.ad.i(com.tencent.mm.plugin.webview.l.a.a(localp, "/meta.json")).optInt("minAndroidClientVersion");
        int j = com.tencent.mm.plugin.webview.l.a.b((com.tencent.mm.plugin.appbrand.appcache.p)paramString2);
        paramString2.close();
        Log.i("MicroMsg.WebCanvasStorageLogic", "isPkgValid appId=" + paramString1 + ", minClientVersion=0x%x, localClientVersion=0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.RAD) });
        if (i <= com.tencent.mm.protocal.d.RAD)
        {
          paramString2 = a.PuM;
          a.t(paramString1, paramInt, j, 0);
          AppMethodBeat.o(206899);
          return true;
        }
        paramString2 = a.PuM;
        a.t(paramString1, paramInt, j, 1);
        Log.w("MicroMsg.WebCanvasStorageLogic", "isPkgValid minClientVersion check fail");
        paramInt = paramString1.hashCode();
        switch (paramInt)
        {
        }
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.WebCanvasStorageLogic", "isPkgValid ex " + paramString1.getMessage());
        continue;
        if (!paramString1.equals("wxfedb0854e2b1820d")) {
          continue;
        }
        paramString1 = l.PuB;
        l.Tt(43L);
        continue;
      }
      AppMethodBeat.o(206899);
      return false;
      if (paramString1.equals("wx97b7aebac2183fd2"))
      {
        paramString1 = l.PuB;
        l.Tt(50L);
      }
    }
  }
  
  private final void bC(String paramString, long paramLong)
  {
    AppMethodBeat.i(206907);
    biu(paramString);
    if (gPr() == 1)
    {
      biw("wx97b7aebac2183fd2");
      biw(paramString);
      AppMethodBeat.o(206907);
      return;
    }
    gPx();
    bD(paramString, paramLong);
    AppMethodBeat.o(206907);
  }
  
  private static boolean bD(String paramString, long paramLong)
  {
    AppMethodBeat.i(206910);
    long l2 = bcJ().getLong(bio(paramString), 0L);
    long l1 = System.currentTimeMillis();
    l2 = Math.abs(l1 - l2);
    if (((gPr() == 0) && (l2 < paramLong)) || ((gPr() != 0) && (l2 < 10000L)))
    {
      Log.d("MicroMsg.WebCanvasStorageLogic", "triggerPreDownloadPrefetchPkg return " + gPr());
      AppMethodBeat.o(206910);
      return false;
    }
    Log.d("MicroMsg.WebCanvasStorageLogic", "triggerPreDownloadPrefetchPkg ".concat(String.valueOf(paramString)));
    bcJ().encode(bio(paramString), l1);
    biv(paramString);
    AppMethodBeat.o(206910);
    return true;
  }
  
  private static MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(206891);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)lrB.getValue();
    AppMethodBeat.o(206891);
    return localMultiProcessMMKV;
  }
  
  public static String bik(String paramString)
  {
    AppMethodBeat.i(206879);
    kotlin.g.b.p.k(paramString, "appId");
    paramString = PuC + '/' + paramString;
    AppMethodBeat.o(206879);
    return paramString;
  }
  
  public static String bil(String paramString)
  {
    AppMethodBeat.i(206883);
    kotlin.g.b.p.k(paramString, "$this$pkgInfoKey");
    paramString = "webcanvas_pkg_info_".concat(String.valueOf(paramString));
    AppMethodBeat.o(206883);
    return paramString;
  }
  
  public static String bim(String paramString)
  {
    AppMethodBeat.i(206885);
    kotlin.g.b.p.k(paramString, "$this$lastUsePathKey");
    paramString = "webcanvas_last_use_pkg_path_".concat(String.valueOf(paramString));
    AppMethodBeat.o(206885);
    return paramString;
  }
  
  public static String bin(String paramString)
  {
    AppMethodBeat.i(206887);
    kotlin.g.b.p.k(paramString, "$this$lastUseTimeKey");
    paramString = "webcanvas_last_use_pkg_time_".concat(String.valueOf(paramString));
    AppMethodBeat.o(206887);
    return paramString;
  }
  
  private static String bio(String paramString)
  {
    AppMethodBeat.i(206889);
    kotlin.g.b.p.k(paramString, "$this$lastDownloadTime");
    paramString = paramString + "-lastDownLoawnTime";
    AppMethodBeat.o(206889);
    return paramString;
  }
  
  private static String biq(String paramString)
  {
    AppMethodBeat.i(206897);
    kotlin.g.b.p.k(paramString, "appId");
    for (;;)
    {
      try
      {
        bh localbh = ((v)com.tencent.mm.kernel.h.ae(v.class)).H(paramString, 2, 0);
        StringBuilder localStringBuilder = new StringBuilder("getPreviewPkgPath appId=").append(paramString).append(", pkgType=2, md5=");
        if (localbh != null)
        {
          paramString = localbh.field_versionMd5;
          localStringBuilder = localStringBuilder.append(paramString).append(" download version= ");
          if (localbh == null) {
            break label185;
          }
          paramString = Integer.valueOf(localbh.field_version);
          localStringBuilder = localStringBuilder.append(paramString).append(" path=");
          if (localbh == null) {
            break label190;
          }
          paramString = localbh.field_pkgPath;
          Log.i("MicroMsg.WebCanvasStorageLogic", paramString);
          if (localbh != null)
          {
            paramString = localbh.field_pkgPath;
            AppMethodBeat.o(206897);
            return paramString;
          }
          AppMethodBeat.o(206897);
          return null;
        }
      }
      catch (Exception paramString)
      {
        Log.w("MicroMsg.WebCanvasStorageLogic", "getPreviewPkgPath ex " + paramString.getMessage());
        AppMethodBeat.o(206897);
        return null;
      }
      paramString = null;
      continue;
      label185:
      paramString = null;
      continue;
      label190:
      paramString = null;
    }
  }
  
  public static tw bis(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(206901);
    kotlin.g.b.p.k(paramString, "appId");
    Object localObject = bcJ();
    kotlin.g.b.p.j(localObject, "mmkv");
    paramString = bil(paramString);
    int i;
    if (((MultiProcessMMKV)localObject).containsKey(paramString))
    {
      paramString = ((MultiProcessMMKV)localObject).decodeBytes(paramString);
      if (paramString != null) {
        if (paramString.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label105;
          }
          i = j;
          label62:
          if (i == 0) {
            break label128;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = tw.class.newInstance();
        ((com.tencent.mm.cd.a)localObject).parseFrom(paramString);
        paramString = (com.tencent.mm.cd.a)localObject;
        paramString = (tw)paramString;
        AppMethodBeat.o(206901);
        return paramString;
      }
      catch (Exception paramString)
      {
        label105:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label62;
      label128:
      paramString = null;
    }
  }
  
  private static void biv(String paramString)
  {
    AppMethodBeat.i(206916);
    kotlin.g.b.p.k(paramString, "appId");
    ((com.tencent.mm.plugin.appbrand.service.u)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.u.class)).a(paramString, 0, (u.b)new n(paramString), (u.a)new o(paramString));
    AppMethodBeat.o(206916);
  }
  
  private static void biw(String paramString)
  {
    AppMethodBeat.i(206917);
    ((com.tencent.mm.plugin.appbrand.service.u)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.u.class)).a(paramString, 2, (u.b)new b(paramString), (u.a)new c(paramString));
    AppMethodBeat.o(206917);
  }
  
  public static Object d(final com.tencent.mm.plugin.ax.a parama, final String paramString, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(206906);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.k(paramd));
    Object localObject1 = (kotlin.d.d)localh;
    Object localObject2 = new e((kotlin.d.d)localObject1, paramString, parama);
    PuL.bC(paramString, ((Number)PuJ.getValue()).longValue());
    bom localbom;
    int i;
    String str;
    if (com.tencent.mm.vfs.u.agG(PuL.bip(paramString)))
    {
      localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
      localbom = parama.PwI;
      i = parama.kqZ;
      str = parama.PwJ.SZA;
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      ((com.tencent.mm.plugin.report.service.h)localObject2).a(21074, new Object[] { localbom, Integer.valueOf(i), Integer.valueOf(1), "", paramString, Integer.valueOf(1), Integer.valueOf(parama.kqZ) });
      parama = Boolean.TRUE;
      paramString = Result.Companion;
      ((kotlin.d.d)localObject1).resumeWith(Result.constructor-impl(parama));
    }
    for (;;)
    {
      parama = localh.iBS();
      if (parama == kotlin.d.a.a.aaAA) {
        kotlin.g.b.p.k(paramd, "frame");
      }
      AppMethodBeat.o(206906);
      return parama;
      Log.i("MicroMsg.WebCanvasStorageLogic", "fetchBizPrefetchPkg pkg not exist, wait for download complete. appId=".concat(String.valueOf(paramString)));
      localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
      localbom = parama.PwI;
      i = parama.kqZ;
      str = parama.PwJ.SZA;
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(21074, new Object[] { localbom, Integer.valueOf(i), Integer.valueOf(1), "", paramString, Integer.valueOf(3), Integer.valueOf(parama.kqZ) });
      ((e)localObject2).invoke();
    }
  }
  
  public static String gPp()
  {
    AppMethodBeat.i(206877);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localf, "MMKernel.storage()");
    localObject = localf.getAccPath() + "webcanvascache/";
    if (!com.tencent.mm.vfs.u.agG((String)localObject)) {
      com.tencent.mm.vfs.u.bBD((String)localObject);
    }
    AppMethodBeat.o(206877);
    return localObject;
  }
  
  public static LinkedList<String> gPq()
  {
    AppMethodBeat.i(206881);
    LinkedList localLinkedList = (LinkedList)PuD.getValue();
    AppMethodBeat.o(206881);
    return localLinkedList;
  }
  
  public static int gPr()
  {
    AppMethodBeat.i(206892);
    int i = ((Number)PuE.getValue()).intValue();
    AppMethodBeat.o(206892);
    return i;
  }
  
  private static boolean gPs()
  {
    AppMethodBeat.i(206893);
    boolean bool = ((Boolean)PuF.getValue()).booleanValue();
    AppMethodBeat.o(206893);
    return bool;
  }
  
  private static long gPt()
  {
    AppMethodBeat.i(206894);
    long l = ((Number)PuH.getValue()).longValue();
    AppMethodBeat.o(206894);
    return l;
  }
  
  private static long gPu()
  {
    AppMethodBeat.i(206895);
    long l = ((Number)PuI.getValue()).longValue();
    AppMethodBeat.o(206895);
    return l;
  }
  
  public static void gPv()
  {
    AppMethodBeat.i(206900);
    PuK.alive();
    AppMethodBeat.o(206900);
  }
  
  /* Error */
  private final LinkedList<String> gPy()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 808
    //   7: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 268	com/tencent/mm/plugin/webcanvas/m:bcJ	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 627
    //   18: invokestatic 630	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: aload_3
    //   22: ldc_w 810
    //   25: invokevirtual 633	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:containsKey	(Ljava/lang/String;)Z
    //   28: ifeq +153 -> 181
    //   31: aload_3
    //   32: ldc_w 810
    //   35: invokevirtual 637	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBytes	(Ljava/lang/String;)[B
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +141 -> 181
    //   43: aload_3
    //   44: arraylength
    //   45: istore_1
    //   46: iload_1
    //   47: ifne +106 -> 153
    //   50: iconst_1
    //   51: istore_1
    //   52: iload_1
    //   53: ifne +105 -> 158
    //   56: iload_2
    //   57: istore_1
    //   58: iload_1
    //   59: ifeq +122 -> 181
    //   62: ldc_w 812
    //   65: invokevirtual 642	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   68: astore 4
    //   70: aload 4
    //   72: checkcast 644	com/tencent/mm/cd/a
    //   75: aload_3
    //   76: invokevirtual 648	com/tencent/mm/cd/a:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   79: pop
    //   80: aload 4
    //   82: checkcast 644	com/tencent/mm/cd/a
    //   85: astore_3
    //   86: aload_3
    //   87: checkcast 812	com/tencent/mm/protocal/protobuf/dnw
    //   90: astore_3
    //   91: aload_3
    //   92: ifnull +17 -> 109
    //   95: aload_3
    //   96: getfield 815	com/tencent/mm/protocal/protobuf/dnw:TVe	Ljava/util/LinkedList;
    //   99: astore 4
    //   101: aload 4
    //   103: astore_3
    //   104: aload 4
    //   106: ifnonnull +11 -> 117
    //   109: new 788	java/util/LinkedList
    //   112: dup
    //   113: invokespecial 816	java/util/LinkedList:<init>	()V
    //   116: astore_3
    //   117: ldc_w 291
    //   120: new 181	java/lang/StringBuilder
    //   123: dup
    //   124: ldc_w 818
    //   127: invokespecial 401	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   130: aload_3
    //   131: invokevirtual 821	java/util/LinkedList:size	()I
    //   134: invokevirtual 404	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: ldc_w 808
    //   146: invokestatic 260	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_3
    //   152: areturn
    //   153: iconst_0
    //   154: istore_1
    //   155: goto -103 -> 52
    //   158: iconst_0
    //   159: istore_1
    //   160: goto -102 -> 58
    //   163: astore_3
    //   164: ldc_w 650
    //   167: aload_3
    //   168: checkcast 652	java/lang/Throwable
    //   171: ldc_w 654
    //   174: iconst_0
    //   175: anewarray 4	java/lang/Object
    //   178: invokestatic 658	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: aconst_null
    //   182: astore_3
    //   183: goto -97 -> 86
    //   186: astore_3
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_3
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	m
    //   45	115	1	i	int
    //   1	56	2	j	int
    //   13	139	3	localObject1	Object
    //   163	5	3	localException	Exception
    //   182	1	3	localObject2	Object
    //   186	4	3	localObject3	Object
    //   68	37	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   62	86	163	java/lang/Exception
    //   4	39	186	finally
    //   43	46	186	finally
    //   62	86	186	finally
    //   86	91	186	finally
    //   95	101	186	finally
    //   109	117	186	finally
    //   117	149	186	finally
    //   164	181	186	finally
  }
  
  private final void gPz()
  {
    try
    {
      AppMethodBeat.i(206914);
      try
      {
        MultiProcessMMKV localMultiProcessMMKV = bcJ();
        dnw localdnw = new dnw();
        localdnw.TVe = gPq();
        localMultiProcessMMKV.encode("KPrefetcherBizAppIds", localdnw.toByteArray());
        AppMethodBeat.o(206914);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.WebCanvasStorageLogic", "saveBizAppIds ex " + localException.getMessage());
          AppMethodBeat.o(206914);
        }
      }
      return;
    }
    finally {}
  }
  
  public final String bip(String paramString)
  {
    AppMethodBeat.i(206896);
    kotlin.g.b.p.k(paramString, "appId");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(206896);
      return null;
    }
    tw localtw = bis(paramString);
    if (localtw == null)
    {
      Log.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath pkgInfo is null");
      AppMethodBeat.o(206896);
      return null;
    }
    if (!com.tencent.mm.vfs.u.agG(localtw.path))
    {
      Log.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath pkgInfo " + localtw.path + " not exist");
      AppMethodBeat.o(206896);
      return null;
    }
    Log.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath appId=" + paramString + ", md5=" + localtw.md5 + " download version= " + localtw.version + " path=" + localtw.path);
    bcJ().encode(bim(paramString), new com.tencent.mm.vfs.q(localtw.path).bOF());
    bcJ().encode(bin(paramString), System.currentTimeMillis());
    paramString = localtw.path;
    AppMethodBeat.o(206896);
    return paramString;
  }
  
  public final int bit(String paramString)
  {
    AppMethodBeat.i(206902);
    kotlin.g.b.p.k(paramString, "appId");
    paramString = bis(paramString);
    if (paramString != null)
    {
      int i = paramString.version;
      AppMethodBeat.o(206902);
      return i;
    }
    AppMethodBeat.o(206902);
    return 0;
  }
  
  public final void biu(String paramString)
  {
    AppMethodBeat.i(206912);
    kotlin.g.b.p.k(paramString, "appId");
    if (!gPq().contains(paramString))
    {
      gPq().add(paramString);
      gPz();
    }
    AppMethodBeat.o(206912);
  }
  
  public final void gPA()
  {
    AppMethodBeat.i(206915);
    if (!gPs())
    {
      AppMethodBeat.o(206915);
      return;
    }
    long l1 = bcJ().getLong("webcanvas_last_download_pkg_by_get_data_time", 0L);
    long l2 = System.currentTimeMillis();
    if (Math.abs(l2 - l1) < ((Number)PuG.getValue()).longValue())
    {
      AppMethodBeat.o(206915);
      return;
    }
    l locall = l.PuB;
    l.Tt(45L);
    bcJ().encode("webcanvas_last_download_pkg_by_get_data_time", l2);
    gPw();
    AppMethodBeat.o(206915);
  }
  
  public final void gPw()
  {
    AppMethodBeat.i(206905);
    if (System.currentTimeMillis() - svS < gPu())
    {
      AppMethodBeat.o(206905);
      return;
    }
    svS = System.currentTimeMillis();
    if (!gPs())
    {
      AppMethodBeat.o(206905);
      return;
    }
    l locall = l.PuB;
    l.Tt(40L);
    biv("wxfedb0854e2b1820d");
    biv("wxf337cbaa27790d8e");
    a(this, "wxa06c02b5c00ff39b");
    if (gPr() == 1)
    {
      biw("wxfedb0854e2b1820d");
      biw("wxf337cbaa27790d8e");
    }
    AppMethodBeat.o(206905);
  }
  
  public final void gPx()
  {
    AppMethodBeat.i(206909);
    if (b(this, "wx97b7aebac2183fd2"))
    {
      l locall = l.PuB;
      l.Tt(54L);
    }
    AppMethodBeat.o(206909);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$PkgDownloadReporter;", "", "()V", "readPkgVersionAndReport", "", "appId", "", "pkgPath", "downloadType", "", "reportPkgDownload", "wxaVersion", "pkgVersion", "downloadStatus", "DownloadStatus", "DownloadType", "webview-sdk_release"})
  public static final class a
  {
    public static final a PuM;
    
    static
    {
      AppMethodBeat.i(205312);
      PuM = new a();
      AppMethodBeat.o(205312);
    }
    
    public static void au(final String paramString1, String paramString2, final int paramInt)
    {
      AppMethodBeat.i(205310);
      kotlin.g.b.p.k(paramString1, "appId");
      kotlin.g.b.p.k(paramString2, "pkgPath");
      com.tencent.e.h.ZvG.be((Runnable)new a(paramString2, paramString1, paramInt));
      AppMethodBeat.o(205310);
    }
    
    public static void e(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(205307);
      kotlin.g.b.p.k(paramString, "appId");
      com.tencent.mm.plugin.report.service.h.IzE.a(20780, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(205307);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(String paramString1, String paramString2, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(205401);
        try
        {
          if (com.tencent.mm.vfs.u.agG(this.PuN))
          {
            localObject = (com.tencent.mm.plugin.appbrand.appcache.p)new WxaPkg(this.PuN);
            ((com.tencent.mm.plugin.appbrand.appcache.p)localObject).bGl();
            m.a locala = m.a.PuM;
            m.a.e(paramString1, 0, com.tencent.mm.plugin.webview.l.a.b((com.tencent.mm.plugin.appbrand.appcache.p)localObject), 0, paramInt);
            AppMethodBeat.o(205401);
            return;
          }
          Object localObject = m.a.PuM;
          m.a.e(paramString1, 0, 0, 3, paramInt);
          AppMethodBeat.o(205401);
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.WebCanvasStorageLogic", (Throwable)localException, "readPkgVersionAndReport exception", new Object[0]);
          AppMethodBeat.o(205401);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "filePath", "", "invoke"})
  static final class b
    implements u.b
  {
    b(String paramString) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errCode", "", "errMsg", "", "invoke"})
  static final class c
    implements u.a
  {
    c(String paramString) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d PuP;
    
    static
    {
      AppMethodBeat.i(205842);
      PuP = new d();
      AppMethodBeat.o(205842);
    }
    
    public final void run()
    {
      AppMethodBeat.i(205841);
      long l1 = System.currentTimeMillis();
      Object localObject1 = j.ag(new String[] { "wxf337cbaa27790d8e", "wxfedb0854e2b1820d", "wx97b7aebac2183fd2" });
      Object localObject2 = m.PuL;
      ((ArrayList)localObject1).addAll((Collection)m.gPq());
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        Log.v("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg appId: ".concat(String.valueOf(localObject2)));
        Object localObject3 = m.PuL;
        Object localObject4 = new com.tencent.mm.vfs.q(m.bik((String)localObject2));
        localObject3 = m.PuL;
        localObject3 = m.gPB();
        Object localObject5 = m.PuL;
        localObject3 = ((MultiProcessMMKV)localObject3).decodeString(m.bim((String)localObject2), "");
        localObject5 = m.PuL;
        localObject5 = m.gPB();
        Object localObject6 = m.PuL;
        long l2 = ((MultiProcessMMKV)localObject5).decodeLong(m.bin((String)localObject2), 0L);
        localObject5 = m.PuL.bip((String)localObject2);
        if ((((com.tencent.mm.vfs.q)localObject4).ifE()) && (((com.tencent.mm.vfs.q)localObject4).isDirectory()))
        {
          localObject4 = ((com.tencent.mm.vfs.q)localObject4).ifJ();
          if (localObject4 != null)
          {
            int j = localObject4.length;
            int i = 0;
            label219:
            if (i < j)
            {
              localObject6 = localObject4[i];
              kotlin.g.b.p.j(localObject6, "file");
              Log.v("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg file: %s, newestPath: %s, lastUsePath: %s", new Object[] { ((com.tencent.mm.vfs.q)localObject6).bOF(), localObject5, localObject3 });
              if ((Util.isEqual(((com.tencent.mm.vfs.q)localObject6).bOF(), (String)localObject3)) || (Util.isEqual(((com.tencent.mm.vfs.q)localObject6).bOF(), (String)localObject5))) {
                break label351;
              }
              ((com.tencent.mm.vfs.q)localObject6).cFq();
              Log.i("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg appId=" + (String)localObject2 + ", path=" + ((com.tencent.mm.vfs.q)localObject6).bOF());
              localObject6 = l.PuB;
              l.Tt(120L);
            }
            for (;;)
            {
              i += 1;
              break label219;
              break;
              label351:
              m localm = m.PuL;
              if ((m.gPq().contains(localObject2)) && ((kotlin.g.b.p.h("wxa06c02b5c00ff39b", localObject2) ^ true)) && (l2 != 0L) && (l1 - l2 > 2592000000L))
              {
                ((com.tencent.mm.vfs.q)localObject6).cFq();
                Log.i("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg on timeout appId=" + (String)localObject2 + ", path=" + ((com.tencent.mm.vfs.q)localObject6).bOF() + '}');
                localObject6 = l.PuB;
                l.Tt(121L);
              }
            }
          }
        }
      }
      AppMethodBeat.o(205841);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"checkDownloadResult", "", "invoke", "com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$fetchBizPrefetchPkg$2$1"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(kotlin.d.d paramd, String paramString, com.tencent.mm.plugin.ax.a parama)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(206802);
      ((com.tencent.mm.plugin.appbrand.service.u)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.u.class)).a(paramString, 0, (u.b)new u.b() {}, (u.a)new u.a() {});
      AppMethodBeat.o(206802);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final f PuR;
    
    static
    {
      AppMethodBeat.i(209085);
      PuR = new f();
      AppMethodBeat.o(209085);
    }
    
    f()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final g PuS;
    
    static
    {
      AppMethodBeat.i(210146);
      PuS = new g();
      AppMethodBeat.o(210146);
    }
    
    g()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgDownloadCompleteNotifyEvent;", "callback", "", "event", "webview-sdk_release"})
  public static final class h
    extends IListener<acm>
  {
    private static boolean a(acm paramacm)
    {
      AppMethodBeat.i(207037);
      kotlin.g.b.p.k(paramacm, "event");
      Log.v("MicroMsg.WebCanvasStorageLogic", "pkgUpdateEventListener appId=%s", new Object[] { paramacm.gcM.appId });
      if (paramacm.gcM.cBI != 0)
      {
        AppMethodBeat.o(207037);
        return true;
      }
      str1 = paramacm.gcM.appId;
      Object localObject;
      if (((kotlin.g.b.p.h("wxf337cbaa27790d8e", str1) ^ true)) && ((kotlin.g.b.p.h("wxfedb0854e2b1820d", str1) ^ true)) && ((kotlin.g.b.p.h("wx97b7aebac2183fd2", str1) ^ true)))
      {
        localObject = m.PuL;
        if (!m.gPq().contains(str1))
        {
          AppMethodBeat.o(207037);
          return false;
        }
      }
      Log.i("MicroMsg.WebCanvasStorageLogic", "pkgUpdateEventListener appId=%s, version=%d, md5=%s", new Object[] { str1, Integer.valueOf(paramacm.gcM.version), paramacm.gcM.md5 });
      label165:
      boolean bool;
      if (str1 == null)
      {
        localObject = l.PuB;
        l.Tt(62L);
        if ((!kotlin.g.b.p.h("wxfedb0854e2b1820d", str1)) && (!kotlin.g.b.p.h("wx97b7aebac2183fd2", str1))) {
          break label516;
        }
        localObject = m.PuL;
        bool = m.at(str1, paramacm.gcM.filePath, paramacm.gcM.version);
        label207:
        if (bool)
        {
          localObject = m.PuL;
          kotlin.g.b.p.j(str1, "tmpAppId");
          localObject = m.bik(str1);
          if (!com.tencent.mm.vfs.u.agG((String)localObject)) {
            com.tencent.mm.vfs.u.bBD((String)localObject);
          }
          String str2 = (String)localObject + '/' + System.currentTimeMillis() + ".wcpkg";
          com.tencent.mm.vfs.u.on(paramacm.gcM.filePath, str2);
          localObject = new tw();
          ((tw)localObject).appId = str1;
          ((tw)localObject).path = new com.tencent.mm.vfs.q(str2).bOF();
          ((tw)localObject).version = paramacm.gcM.version;
          ((tw)localObject).cBI = paramacm.gcM.cBI;
          ((tw)localObject).md5 = paramacm.gcM.md5;
        }
      }
      for (;;)
      {
        try
        {
          paramacm = m.PuL;
          m.a(str1, (tw)localObject);
          int i = str1.hashCode();
          switch (i)
          {
          }
        }
        catch (Exception paramacm)
        {
          label516:
          Log.e("MicroMsg.WebCanvasStorageLogic", "save pkg info fail " + paramacm.getMessage());
          continue;
          if (!str1.equals("wxfedb0854e2b1820d")) {
            continue;
          }
          paramacm = l.PuB;
          l.Tt(44L);
          continue;
        }
        AppMethodBeat.o(207037);
        return false;
        switch (str1.hashCode())
        {
        default: 
          break;
        case -1635202514: 
          if (!str1.equals("wx97b7aebac2183fd2")) {
            break;
          }
          localObject = l.PuB;
          l.Tt(61L);
          break;
        case -215862887: 
          if (!str1.equals("wxf337cbaa27790d8e")) {
            break;
          }
          localObject = l.PuB;
          l.Tt(51L);
          break;
        case -1154368401: 
          if (!str1.equals("wxfedb0854e2b1820d")) {
            break;
          }
          localObject = l.PuB;
          l.Tt(41L);
          break label165;
          localObject = m.a.PuM;
          kotlin.g.b.p.j(str1, "tmpAppId");
          localObject = paramacm.gcM.filePath;
          kotlin.g.b.p.j(localObject, "event.data.filePath");
          m.a.lX(str1, (String)localObject);
          bool = com.tencent.mm.vfs.u.agG(paramacm.gcM.filePath);
          break label207;
          if (str1.equals("wxf337cbaa27790d8e"))
          {
            paramacm = l.PuB;
            l.Tt(53L);
          }
          break;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinkedList<String>>
  {
    public static final i PuT;
    
    static
    {
      AppMethodBeat.i(216547);
      PuT = new i();
      AppMethodBeat.o(216547);
    }
    
    i()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    public static final j PuU;
    
    static
    {
      AppMethodBeat.i(205406);
      PuU = new j();
      AppMethodBeat.o(205406);
    }
    
    j()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Long>
  {
    public static final k PuV;
    
    static
    {
      AppMethodBeat.i(205848);
      PuV = new k();
      AppMethodBeat.o(205848);
    }
    
    k()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Long>
  {
    public static final l PuW;
    
    static
    {
      AppMethodBeat.i(206635);
      PuW = new l();
      AppMethodBeat.o(206635);
    }
    
    l()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Long>
  {
    public static final m PuX;
    
    static
    {
      AppMethodBeat.i(208176);
      PuX = new m();
      AppMethodBeat.o(208176);
    }
    
    m()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "filePath", "", "invoke"})
  static final class n
    implements u.b
  {
    n(String paramString) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errCode", "", "errMsg", "", "invoke"})
  static final class o
    implements u.a
  {
    o(String paramString) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Long>
  {
    public static final p PuY;
    
    static
    {
      AppMethodBeat.i(205404);
      PuY = new p();
      AppMethodBeat.o(205404);
    }
    
    p()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.m
 * JD-Core Version:    0.7.0.1
 */