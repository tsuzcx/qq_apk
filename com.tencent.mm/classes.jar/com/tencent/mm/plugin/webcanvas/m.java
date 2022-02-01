package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.plugin.appbrand.service.u.a;
import com.tencent.mm.plugin.appbrand.service.u.b;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.protocal.protobuf.deg;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import kotlin.Result;
import kotlin.f;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic;", "", "()V", "KEY_PREFETCHER_BIZ_APPIDS", "", "KEY_WEB_CANVAS_LAST_CLEAR_PKG_TIME", "KEY_WEB_CANVAS_LAST_DOWNLOAD_PKG_BY_GET_DATA_TIME", "KEY_WEB_CANVAS_PREVIEW_PKG_MD5", "TAG", "WEB_CANVAS_PKG_PATH", "getWEB_CANVAS_PKG_PATH", "()Ljava/lang/String;", "adPrefetchAppId", "bizPkgAppId", "lastTriggerPreDownloadTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "pkgDownloadOpen", "", "getPkgDownloadOpen", "()Z", "pkgDownloadOpen$delegate", "pkgUpdateEventListener", "com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1;", "prefetchBasePkgAppId", "prefetchBizPkgAppIds", "Ljava/util/LinkedList;", "getPrefetchBizPkgAppIds", "()Ljava/util/LinkedList;", "prefetchBizPkgAppIds$delegate", "previewMode", "", "getPreviewMode", "()I", "previewMode$delegate", "triggerDownLoadPkgInterval", "getTriggerDownLoadPkgInterval", "()J", "triggerDownLoadPkgInterval$delegate", "triggerDownLoadPkgOnGetDataInterval", "getTriggerDownLoadPkgOnGetDataInterval", "triggerDownLoadPkgOnGetDataInterval$delegate", "triggerDownLoadPrefetchPkgInterval", "getTriggerDownLoadPrefetchPkgInterval", "triggerDownLoadPrefetchPkgInterval$delegate", "wxaPkgAppId", "minBasePkgVersion", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getMinBasePkgVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "minClientVersion", "getMinClientVersion", "version", "getVersion", "checkPreviewVersion", "", "appId", "clearInvalidPkg", "force", "fetchBizPrefetchPkg", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "userName", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBizAppIds", "getPkgInfo", "Lcom/tencent/mm/protocal/protobuf/CanvasPkgInfo;", "getPreviewPkgPath", "pkgType", "getReleasePkgPath", "getWebCanvasCachePath", "getWxaPkgVersion", "isPkgValid", "path", "wxaVersion", "isWxaPkgSupport", "bizPkg", "wxaPkg", "regPkgUpdateEventListener", "saveBizAppIds", "triggerPreDownload", "triggerPreDownloadBizPrefetchPkg", "triggerPreDownloadByGetData", "triggerPreDownloadPrefetchBasePkg", "triggerPreDownloadPrefetchPkg", "lastDownloadTime", "lastUsePathKey", "lastUseTimeKey", "pkgInfoKey", "readFile", "webview-sdk_release"})
public final class m
{
  private static final f IAA;
  private static final f IAB;
  private static final f IAC;
  private static final f IAD;
  private static final f IAE;
  private static final m.g IAF;
  public static final m IAG;
  private static final String IAy;
  private static final f IAz;
  private static final f iBW;
  private static long pmU;
  
  static
  {
    AppMethodBeat.i(224755);
    IAG = new m();
    IAy = com.tencent.mm.loader.j.b.aKB() + "/WebCanvasPkg";
    IAz = kotlin.g.ah((kotlin.g.a.a)m.h.IAL);
    iBW = kotlin.g.ah((kotlin.g.a.a)m.e.IAJ);
    IAA = kotlin.g.ah((kotlin.g.a.a)m.i.IAM);
    IAB = kotlin.g.ah((kotlin.g.a.a)m.f.IAK);
    IAC = kotlin.g.ah((kotlin.g.a.a)m.k.IAO);
    IAD = kotlin.g.ah((kotlin.g.a.a)m.l.IAP);
    IAE = kotlin.g.ah((kotlin.g.a.a)m.j.IAN);
    IAF = new m.g();
    AppMethodBeat.o(224755);
  }
  
  private static int a(com.tencent.mm.plugin.appbrand.appcache.p paramp)
  {
    AppMethodBeat.i(224738);
    kotlin.g.b.p.h(paramp, "$this$version");
    int i = new com.tencent.mm.ab.i(a(paramp, "/meta.json")).optInt("version");
    AppMethodBeat.o(224738);
    return i;
  }
  
  public static Object a(final com.tencent.mm.plugin.ad.a parama, final String paramString1, final String paramString2, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(224745);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.e(paramd));
    Object localObject1 = (kotlin.d.d)localh;
    Object localObject2 = new d((kotlin.d.d)localObject1, paramString1, parama, paramString2);
    Object localObject3 = (CharSequence)paramString2;
    int i;
    if ((localObject3 == null) || (n.aL((CharSequence)localObject3)))
    {
      i = 1;
      if (i == 0)
      {
        if (!n.K(paramString2, "@app", true)) {
          break label266;
        }
        label78:
        ((u)com.tencent.mm.kernel.g.af(u.class)).r(paramString2, paramString1, 998);
      }
      IAG.aWL(paramString1);
      if (!s.YS(IAG.aWH(paramString1))) {
        break label290;
      }
      localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
      localObject3 = parama.ICs;
      i = parama.hDa;
      paramString2 = parama.ICt.LQV;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      ((com.tencent.mm.plugin.report.service.h)localObject2).a(21074, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(1), "", paramString1, Integer.valueOf(1), Integer.valueOf(parama.hDa) });
      parama = Boolean.TRUE;
      paramString1 = Result.Companion;
      ((kotlin.d.d)localObject1).resumeWith(Result.constructor-impl(parama));
    }
    for (;;)
    {
      parama = localh.hxK();
      if (parama == kotlin.d.a.a.SXO) {
        kotlin.g.b.p.h(paramd, "frame");
      }
      AppMethodBeat.o(224745);
      return parama;
      i = 0;
      break;
      label266:
      paramString2 = paramString2 + "@app";
      break label78;
      label290:
      Log.i("MicroMsg.WebCanvasStorageLogic", "fetchBizPrefetchPkg pkg not exist, wait for download complete. appId=".concat(String.valueOf(paramString1)));
      localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
      localObject3 = parama.ICs;
      i = parama.hDa;
      paramString2 = parama.ICt.LQV;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(21074, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(1), "", paramString1, Integer.valueOf(3), Integer.valueOf(parama.hDa) });
      ((d)localObject2).invoke();
    }
  }
  
  /* Error */
  private static String a(com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 407
    //   5: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ldc_w 409
    //   12: invokestatic 243	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: ldc_w 410
    //   19: invokestatic 243	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokeinterface 416 2 0
    //   29: checkcast 418	java/io/Closeable
    //   32: astore_3
    //   33: aload_3
    //   34: checkcast 420	java/io/InputStream
    //   37: astore_0
    //   38: aload_0
    //   39: ldc_w 422
    //   42: invokestatic 425	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   45: new 388	java/lang/String
    //   48: dup
    //   49: aload_0
    //   50: invokestatic 431	kotlin/f/a:U	(Ljava/io/InputStream;)[B
    //   53: getstatic 437	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   56: invokespecial 440	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   59: astore_0
    //   60: aload_3
    //   61: aconst_null
    //   62: invokestatic 445	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   65: ldc_w 407
    //   68: invokestatic 230	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_0
    //   72: areturn
    //   73: astore_1
    //   74: ldc_w 407
    //   77: invokestatic 230	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_1
    //   81: athrow
    //   82: astore_0
    //   83: aload_3
    //   84: aload_1
    //   85: invokestatic 445	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   88: ldc_w 407
    //   91: invokestatic 230	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_0
    //   95: athrow
    //   96: astore_0
    //   97: aload_2
    //   98: astore_1
    //   99: goto -16 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramp	com.tencent.mm.plugin.appbrand.appcache.p
    //   0	102	1	paramString	String
    //   1	97	2	localObject	Object
    //   32	52	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   33	60	73	java/lang/Throwable
    //   74	82	82	finally
    //   33	60	96	finally
  }
  
  public static boolean a(com.tencent.mm.plugin.appbrand.appcache.p paramp1, com.tencent.mm.plugin.appbrand.appcache.p paramp2)
  {
    AppMethodBeat.i(224743);
    kotlin.g.b.p.h(paramp1, "bizPkg");
    kotlin.g.b.p.h(paramp2, "wxaPkg");
    try
    {
      kotlin.g.b.p.h(paramp1, "$this$minBasePkgVersion");
      int i = new com.tencent.mm.ab.i(a(paramp1, "/meta.json")).optInt("minAndroidBasePkgVersion");
      int j = a(paramp2);
      Log.i("MicroMsg.WebCanvasStorageLogic", "isPkgValid minBasePkgVersion=" + i + ", wxaPkgVersionn=" + j);
      if (i <= j)
      {
        AppMethodBeat.o(224743);
        return true;
      }
      Log.w("MicroMsg.WebCanvasStorageLogic", "isWxaPkgSupport minBasePkgVersion check fail");
      paramp1 = l.IAx;
      l.LV(59L);
    }
    catch (Exception paramp1)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebCanvasStorageLogic", "isWxaPkgSupport ex " + paramp1.getMessage());
      }
    }
    AppMethodBeat.o(224743);
    return false;
  }
  
  private static MultiProcessMMKV aTI()
  {
    AppMethodBeat.i(224730);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)iBW.getValue();
    AppMethodBeat.o(224730);
    return localMultiProcessMMKV;
  }
  
  public static String aWD(String paramString)
  {
    AppMethodBeat.i(224726);
    kotlin.g.b.p.h(paramString, "$this$pkgInfoKey");
    paramString = "webcanvas_pkg_info_".concat(String.valueOf(paramString));
    AppMethodBeat.o(224726);
    return paramString;
  }
  
  public static String aWE(String paramString)
  {
    AppMethodBeat.i(224727);
    kotlin.g.b.p.h(paramString, "$this$lastUsePathKey");
    paramString = "webcanvas_last_use_pkg_path_".concat(String.valueOf(paramString));
    AppMethodBeat.o(224727);
    return paramString;
  }
  
  public static String aWF(String paramString)
  {
    AppMethodBeat.i(224728);
    kotlin.g.b.p.h(paramString, "$this$lastUseTimeKey");
    paramString = "webcanvas_last_use_pkg_time_".concat(String.valueOf(paramString));
    AppMethodBeat.o(224728);
    return paramString;
  }
  
  private static String aWG(String paramString)
  {
    AppMethodBeat.i(224729);
    kotlin.g.b.p.h(paramString, "$this$lastDownloadTime");
    paramString = paramString + "-lastDownLoawnTime";
    AppMethodBeat.o(224729);
    return paramString;
  }
  
  public static tu aWJ(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(224741);
    kotlin.g.b.p.h(paramString, "appId");
    Object localObject = aTI();
    kotlin.g.b.p.g(localObject, "mmkv");
    paramString = aWD(paramString);
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
        localObject = tu.class.newInstance();
        ((com.tencent.mm.bw.a)localObject).parseFrom(paramString);
        paramString = (com.tencent.mm.bw.a)localObject;
        paramString = (tu)paramString;
        AppMethodBeat.o(224741);
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
  
  private void aWL(String paramString)
  {
    AppMethodBeat.i(224746);
    kotlin.g.b.p.h(paramString, "appId");
    fWP();
    if (!fWI().contains(paramString))
    {
      fWI().add(paramString);
      fWR();
    }
    aWM(paramString);
    if (fWJ() == 1)
    {
      aWO("wx97b7aebac2183fd2");
      aWO(paramString);
    }
    AppMethodBeat.o(224746);
  }
  
  private static boolean aWM(String paramString)
  {
    AppMethodBeat.i(224748);
    long l2 = aTI().getLong(aWG(paramString), 0L);
    long l1 = System.currentTimeMillis();
    l2 = Math.abs(l1 - l2);
    if (((fWJ() == 0) && (l2 < fWL())) || ((fWJ() != 0) && (l2 < 10000L)))
    {
      Log.d("MicroMsg.WebCanvasStorageLogic", "triggerPreDownloadPrefetchPkg return " + fWJ());
      AppMethodBeat.o(224748);
      return false;
    }
    Log.d("MicroMsg.WebCanvasStorageLogic", "triggerPreDownloadPrefetchPkg ".concat(String.valueOf(paramString)));
    aTI().encode(aWG(paramString), l1);
    aWN(paramString);
    AppMethodBeat.o(224748);
    return true;
  }
  
  private static void aWN(String paramString)
  {
    AppMethodBeat.i(224752);
    kotlin.g.b.p.h(paramString, "appId");
    ((u)com.tencent.mm.kernel.g.af(u.class)).a(paramString, 0, (u.b)new m.m(paramString), (u.a)new m.n(paramString));
    AppMethodBeat.o(224752);
  }
  
  private static void aWO(String paramString)
  {
    AppMethodBeat.i(224753);
    ((u)com.tencent.mm.kernel.g.af(u.class)).a(paramString, 2, (u.b)new m.a(paramString), (u.a)new m.b(paramString));
    AppMethodBeat.o(224753);
  }
  
  private static boolean al(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(224739);
    if (!s.YS(paramString2))
    {
      Log.w("MicroMsg.WebCanvasStorageLogic", "isPkgValid file not exit ".concat(String.valueOf(paramString2)));
      switch (paramString1.hashCode())
      {
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(20780, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(3) });
        AppMethodBeat.o(224739);
        return false;
        if (paramString1.equals("wx97b7aebac2183fd2"))
        {
          paramString2 = l.IAx;
          l.LV(49L);
          continue;
          if (paramString1.equals("wxfedb0854e2b1820d"))
          {
            paramString2 = l.IAx;
            l.LV(42L);
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = new WxaPkg(paramString2);
        paramString2.bvf();
        com.tencent.mm.plugin.appbrand.appcache.p localp = (com.tencent.mm.plugin.appbrand.appcache.p)paramString2;
        kotlin.g.b.p.h(localp, "$this$minClientVersion");
        int i = new com.tencent.mm.ab.i(a(localp, "/meta.json")).optInt("minAndroidClientVersion");
        int j = a((com.tencent.mm.plugin.appbrand.appcache.p)paramString2);
        paramString2.close();
        Log.i("MicroMsg.WebCanvasStorageLogic", "isPkgValid appId=" + paramString1 + ", minClientVersion=0x%x, localClientVersion=0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.KyO) });
        if (i <= com.tencent.mm.protocal.d.KyO)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(20780, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(0) });
          AppMethodBeat.o(224739);
          return true;
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(20780, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(1) });
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
        paramString1 = l.IAx;
        l.LV(43L);
        continue;
      }
      AppMethodBeat.o(224739);
      return false;
      if (paramString1.equals("wx97b7aebac2183fd2"))
      {
        paramString1 = l.IAx;
        l.LV(50L);
      }
    }
  }
  
  public static String fWG()
  {
    return IAy;
  }
  
  public static String fWH()
  {
    AppMethodBeat.i(224724);
    Object localObject = new StringBuilder();
    e locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    localObject = locale.getAccPath() + "webcanvascache/";
    if (!s.YS((String)localObject)) {
      s.boN((String)localObject);
    }
    AppMethodBeat.o(224724);
    return localObject;
  }
  
  public static LinkedList<String> fWI()
  {
    AppMethodBeat.i(224725);
    LinkedList localLinkedList = (LinkedList)IAz.getValue();
    AppMethodBeat.o(224725);
    return localLinkedList;
  }
  
  public static int fWJ()
  {
    AppMethodBeat.i(224731);
    int i = ((Number)IAA.getValue()).intValue();
    AppMethodBeat.o(224731);
    return i;
  }
  
  private static boolean fWK()
  {
    AppMethodBeat.i(224732);
    boolean bool = ((Boolean)IAB.getValue()).booleanValue();
    AppMethodBeat.o(224732);
    return bool;
  }
  
  private static long fWL()
  {
    AppMethodBeat.i(224733);
    long l = ((Number)IAD.getValue()).longValue();
    AppMethodBeat.o(224733);
    return l;
  }
  
  private static long fWM()
  {
    AppMethodBeat.i(224734);
    long l = ((Number)IAE.getValue()).longValue();
    AppMethodBeat.o(224734);
    return l;
  }
  
  public static void fWN()
  {
    AppMethodBeat.i(224740);
    IAF.alive();
    AppMethodBeat.o(224740);
  }
  
  /* Error */
  private final LinkedList<String> fWQ()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 781
    //   7: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 569	com/tencent/mm/plugin/webcanvas/m:aTI	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 570
    //   18: invokestatic 425	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: aload_3
    //   22: ldc_w 783
    //   25: invokevirtual 575	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:containsKey	(Ljava/lang/String;)Z
    //   28: ifeq +153 -> 181
    //   31: aload_3
    //   32: ldc_w 783
    //   35: invokevirtual 579	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBytes	(Ljava/lang/String;)[B
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
    //   62: ldc_w 785
    //   65: invokevirtual 586	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   68: astore 4
    //   70: aload 4
    //   72: checkcast 588	com/tencent/mm/bw/a
    //   75: aload_3
    //   76: invokevirtual 592	com/tencent/mm/bw/a:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   79: pop
    //   80: aload 4
    //   82: checkcast 588	com/tencent/mm/bw/a
    //   85: astore_3
    //   86: aload_3
    //   87: checkcast 785	com/tencent/mm/protocal/protobuf/deg
    //   90: astore_3
    //   91: aload_3
    //   92: ifnull +17 -> 109
    //   95: aload_3
    //   96: getfield 788	com/tencent/mm/protocal/protobuf/deg:MJp	Ljava/util/LinkedList;
    //   99: astore 4
    //   101: aload 4
    //   103: astore_3
    //   104: aload 4
    //   106: ifnonnull +11 -> 117
    //   109: new 609	java/util/LinkedList
    //   112: dup
    //   113: invokespecial 789	java/util/LinkedList:<init>	()V
    //   116: astore_3
    //   117: ldc_w 384
    //   120: new 141	java/lang/StringBuilder
    //   123: dup
    //   124: ldc_w 791
    //   127: invokespecial 465	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   130: aload_3
    //   131: invokevirtual 794	java/util/LinkedList:size	()I
    //   134: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 658	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: ldc_w 781
    //   146: invokestatic 230	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   164: ldc_w 594
    //   167: aload_3
    //   168: checkcast 406	java/lang/Throwable
    //   171: ldc_w 596
    //   174: iconst_0
    //   175: anewarray 4	java/lang/Object
    //   178: invokestatic 600	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private final void fWR()
  {
    try
    {
      AppMethodBeat.i(224750);
      try
      {
        MultiProcessMMKV localMultiProcessMMKV = aTI();
        deg localdeg = new deg();
        localdeg.MJp = fWI();
        localMultiProcessMMKV.encode("KPrefetcherBizAppIds", localdeg.toByteArray());
        AppMethodBeat.o(224750);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.WebCanvasStorageLogic", "saveBizAppIds ex " + localException.getMessage());
          AppMethodBeat.o(224750);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void yK(boolean paramBoolean)
  {
    AppMethodBeat.i(224754);
    long l2 = aTI().decodeLong("webcanvas_last_clear_pkg_time", 0L);
    long l1 = System.currentTimeMillis();
    l2 = Math.abs(l1 - l2);
    if ((!paramBoolean) && (l2 < 86400000L))
    {
      Log.d("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg delta ".concat(String.valueOf(l2)));
      AppMethodBeat.o(224754);
      return;
    }
    aTI().encode("webcanvas_last_clear_pkg_time", l1);
    com.tencent.f.h.RTc.o((Runnable)m.c.IAH, 10000L);
    AppMethodBeat.o(224754);
  }
  
  public final String aWH(String paramString)
  {
    AppMethodBeat.i(224735);
    kotlin.g.b.p.h(paramString, "appId");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(224735);
      return null;
    }
    tu localtu = aWJ(paramString);
    if (localtu == null)
    {
      Log.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath pkgInfo is null");
      AppMethodBeat.o(224735);
      return null;
    }
    if (!s.YS(localtu.path))
    {
      Log.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath pkgInfo " + localtu.path + " not exist");
      AppMethodBeat.o(224735);
      return null;
    }
    Log.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath appId=" + paramString + ", md5=" + localtu.md5 + " download version= " + localtu.version + " path=" + localtu.path);
    aTI().encode(aWE(paramString), new o(localtu.path).getAbsolutePath());
    aTI().encode(aWF(paramString), System.currentTimeMillis());
    paramString = localtu.path;
    AppMethodBeat.o(224735);
    return paramString;
  }
  
  public final int aWK(String paramString)
  {
    AppMethodBeat.i(224742);
    kotlin.g.b.p.h(paramString, "appId");
    paramString = aWJ(paramString);
    if (paramString != null)
    {
      int i = paramString.version;
      AppMethodBeat.o(224742);
      return i;
    }
    AppMethodBeat.o(224742);
    return 0;
  }
  
  public final void fWO()
  {
    AppMethodBeat.i(224744);
    if (System.currentTimeMillis() - pmU < fWM())
    {
      AppMethodBeat.o(224744);
      return;
    }
    pmU = System.currentTimeMillis();
    if (!fWK())
    {
      AppMethodBeat.o(224744);
      return;
    }
    l locall = l.IAx;
    l.LV(40L);
    aWN("wxfedb0854e2b1820d");
    aWN("wxf337cbaa27790d8e");
    aWL("wxa06c02b5c00ff39b");
    if (fWJ() == 1)
    {
      aWO("wxfedb0854e2b1820d");
      aWO("wxf337cbaa27790d8e");
    }
    AppMethodBeat.o(224744);
  }
  
  public final void fWP()
  {
    AppMethodBeat.i(224747);
    if (aWM("wx97b7aebac2183fd2"))
    {
      l locall = l.IAx;
      l.LV(54L);
    }
    AppMethodBeat.o(224747);
  }
  
  public final void fWS()
  {
    AppMethodBeat.i(224751);
    if (!fWK())
    {
      AppMethodBeat.o(224751);
      return;
    }
    long l1 = aTI().getLong("webcanvas_last_download_pkg_by_get_data_time", 0L);
    long l2 = System.currentTimeMillis();
    if (Math.abs(l2 - l1) < ((Number)IAC.getValue()).longValue())
    {
      AppMethodBeat.o(224751);
      return;
    }
    l locall = l.IAx;
    l.LV(45L);
    aTI().encode("webcanvas_last_download_pkg_by_get_data_time", l2);
    fWO();
    AppMethodBeat.o(224751);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"checkDownloadResult", "", "invoke", "com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$fetchBizPrefetchPkg$2$1"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(kotlin.d.d paramd, String paramString1, com.tencent.mm.plugin.ad.a parama, String paramString2)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(224705);
      ((u)com.tencent.mm.kernel.g.af(u.class)).a(paramString1, 0, (u.b)new u.b() {}, (u.a)new u.a() {});
      AppMethodBeat.o(224705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.m
 * JD-Core Version:    0.7.0.1
 */