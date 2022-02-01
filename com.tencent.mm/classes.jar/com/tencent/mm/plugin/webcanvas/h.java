package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.g.a.zx;
import com.tencent.mm.g.a.zx.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj.a;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ehl;
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.protocal.protobuf.wx;
import com.tencent.mm.protocal.protobuf.wy;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import d.a.j;
import d.g.b.q;
import d.l;
import java.io.Closeable;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic;", "", "()V", "KEY_WEB_CANVAS_LAST_CLEAR_PKG_TIME", "", "KEY_WEB_CANVAS_LAST_DOWNLOAD_PKG_BY_GET_DATA_TIME", "KEY_WEB_CANVAS_PREVIEW_PKG_MD5", "TAG", "WEB_CANVAS_PKG_PATH", "getWEB_CANVAS_PKG_PATH", "()Ljava/lang/String;", "bizPkgAppId", "bizPkgUserName", "lastTriggerPreDownloadTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "pkgDownloadOpen", "", "getPkgDownloadOpen", "()Z", "pkgDownloadOpen$delegate", "pkgUpdateEventListener", "com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1;", "previewMode", "", "getPreviewMode", "()I", "previewMode$delegate", "triggerDownLoadPkgInterval", "getTriggerDownLoadPkgInterval", "()J", "triggerDownLoadPkgInterval$delegate", "triggerDownLoadPkgOnGetDataInterval", "getTriggerDownLoadPkgOnGetDataInterval", "triggerDownLoadPkgOnGetDataInterval$delegate", "wxaPkgAppId", "wxaPkgUserName", "minBasePkgVersion", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getMinBasePkgVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "minClientVersion", "getMinClientVersion", "version", "getVersion", "checkPreviewVersion", "", "appId", "clearInvalidPkg", "force", "createResResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "md5", "getBizPkgPath", "getBizPreviewPkgPath", "getBizReleasePkgPath", "getPkgInfo", "Lcom/tencent/mm/protocal/protobuf/CanvasPkgInfo;", "getPreviewPkgPath", "pkgType", "getReleasePkgPath", "getWebCanvasCachePath", "getWxaPkg", "getWxaPkgPath", "getWxaPkgVersion", "getWxaPreviewPkgPath", "getWxaReleasePkgPath", "isPkgValid", "path", "wxaVersion", "isWxaPkgSupport", "bizPkg", "wxaPkg", "regPkgUpdateEventListener", "startDownloadDebugPkg", "debugType", "downloadURL", "checkSumMd5", "triggerPreDownload", "username", "triggerPreDownloadByGetData", "lastUsePathKey", "pkgInfoKey", "readFile", "webview-sdk_release"})
public final class h
{
  private static final String DQH;
  private static final d.f DQI;
  private static final e DQJ;
  private static final d.f DQK;
  public static final h DQL;
  private static final d.f JhZ;
  private static final d.f Jia;
  private static final d.f nUv;
  private static long obX;
  
  static
  {
    AppMethodBeat.i(213976);
    DQL = new h();
    DQH = com.tencent.mm.loader.j.b.asb() + "/WebCanvasPkg";
    nUv = d.g.O((d.g.a.a)c.DQN);
    DQI = d.g.O((d.g.a.a)f.DQP);
    DQK = d.g.O((d.g.a.a)d.DQO);
    JhZ = d.g.O((d.g.a.a)h.i.Jic);
    Jia = d.g.O((d.g.a.a)h.h.Jib);
    DQJ = new e();
    AppMethodBeat.o(213976);
  }
  
  private static void Mr(String paramString)
  {
    AppMethodBeat.i(213972);
    d.g.b.p.h(paramString, "username");
    ((s)com.tencent.mm.kernel.g.ab(s.class)).Mr(paramString);
    AppMethodBeat.o(213972);
  }
  
  /* Error */
  private static String a(com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 233
    //   4: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 235
    //   10: invokestatic 218	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc 236
    //   16: invokestatic 218	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokeinterface 242 2 0
    //   26: checkcast 244	java/io/Closeable
    //   29: astore_3
    //   30: aload_3
    //   31: checkcast 246	java/io/InputStream
    //   34: astore_0
    //   35: aload_0
    //   36: ldc 248
    //   38: invokestatic 251	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   41: new 253	java/lang/String
    //   44: dup
    //   45: aload_0
    //   46: invokestatic 259	d/f/a:X	(Ljava/io/InputStream;)[B
    //   49: getstatic 265	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   52: invokespecial 268	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   55: astore_0
    //   56: aload_3
    //   57: aconst_null
    //   58: invokestatic 273	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   61: ldc 233
    //   63: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: areturn
    //   68: astore_1
    //   69: ldc 233
    //   71: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_1
    //   75: athrow
    //   76: astore_0
    //   77: aload_3
    //   78: aload_1
    //   79: invokestatic 273	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   82: ldc 233
    //   84: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_0
    //   88: athrow
    //   89: astore_0
    //   90: aload_2
    //   91: astore_1
    //   92: goto -15 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramp	com.tencent.mm.plugin.appbrand.appcache.p
    //   0	95	1	paramString	String
    //   1	90	2	localObject	Object
    //   29	49	3	localCloseable	Closeable
    // Exception table:
    //   from	to	target	type
    //   30	56	68	java/lang/Throwable
    //   69	76	76	finally
    //   30	56	89	finally
  }
  
  public static boolean a(com.tencent.mm.plugin.appbrand.appcache.p paramp1, com.tencent.mm.plugin.appbrand.appcache.p paramp2)
  {
    AppMethodBeat.i(213970);
    d.g.b.p.h(paramp1, "bizPkg");
    d.g.b.p.h(paramp2, "wxaPkg");
    try
    {
      d.g.b.p.h(paramp1, "$this$minBasePkgVersion");
      int i = new com.tencent.mm.ab.i(a(paramp1, "/meta.json")).optInt("minBasePkgVersion");
      int j = b(paramp2);
      ae.i("MicroMsg.WebCanvasStorageLogic", "isPkgValid minBasePkgVersion=" + i + ", wxaPkgVersionn=" + j);
      if (i <= j)
      {
        AppMethodBeat.o(213970);
        return true;
      }
      ae.w("MicroMsg.WebCanvasStorageLogic", "isWxaPkgSupport minBasePkgVersion check fail");
      paramp1 = g.DQG;
      g.CH(59L);
    }
    catch (Exception paramp1)
    {
      for (;;)
      {
        ae.e("MicroMsg.WebCanvasStorageLogic", "isWxaPkgSupport ex " + paramp1.getMessage());
      }
    }
    AppMethodBeat.o(213970);
    return false;
  }
  
  public static String aGS(String paramString)
  {
    AppMethodBeat.i(213956);
    d.g.b.p.h(paramString, "$this$pkgInfoKey");
    paramString = "webcanvas_pkg_info_".concat(String.valueOf(paramString));
    AppMethodBeat.o(213956);
    return paramString;
  }
  
  public static String aGT(String paramString)
  {
    AppMethodBeat.i(213957);
    d.g.b.p.h(paramString, "$this$lastUsePathKey");
    paramString = "webcanvas_last_use_pkg_path_".concat(String.valueOf(paramString));
    AppMethodBeat.o(213957);
    return paramString;
  }
  
  static String aGU(String paramString)
  {
    AppMethodBeat.i(213961);
    sp localsp = aGW(paramString);
    if (localsp == null)
    {
      ae.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath pkgInfo is null");
      AppMethodBeat.o(213961);
      return null;
    }
    if (!o.fB(localsp.path))
    {
      ae.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath pkgInfo " + localsp.path + " not exist");
      AppMethodBeat.o(213961);
      return null;
    }
    ae.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath appId=" + paramString + ", md5=" + localsp.md5 + " download version= " + localsp.version + " path=" + localsp.path);
    bOc().encode(aGT(paramString), new k(localsp.path).getAbsolutePath());
    paramString = localsp.path;
    AppMethodBeat.o(213961);
    return paramString;
  }
  
  static String aGV(String paramString)
  {
    AppMethodBeat.i(213962);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class);
    d.g.b.p.g(localObject, "MMKernel.service(IWxaPkg…orageService::class.java)");
    localObject = ((com.tencent.mm.plugin.appbrand.api.e)localObject).aYP().a(paramString, 2, new String[] { "version", "pkgPath", "versionMd5" });
    StringBuilder localStringBuilder = new StringBuilder("getPreviewPkgPath appId=").append(paramString).append(", pkgType=2, md5=");
    if (localObject != null)
    {
      paramString = ((bd)localObject).field_versionMd5;
      localStringBuilder = localStringBuilder.append(paramString).append(" download version= ");
      if (localObject == null) {
        break label168;
      }
      paramString = Integer.valueOf(((bd)localObject).field_version);
      label111:
      localStringBuilder = localStringBuilder.append(paramString).append(" path=");
      if (localObject == null) {
        break label173;
      }
    }
    label168:
    label173:
    for (paramString = ((bd)localObject).field_pkgPath;; paramString = null)
    {
      ae.i("MicroMsg.WebCanvasStorageLogic", paramString);
      if (localObject == null) {
        break label178;
      }
      paramString = ((bd)localObject).field_pkgPath;
      AppMethodBeat.o(213962);
      return paramString;
      paramString = null;
      break;
      paramString = null;
      break label111;
    }
    label178:
    AppMethodBeat.o(213962);
    return null;
  }
  
  public static sp aGW(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(213968);
    d.g.b.p.h(paramString, "appId");
    Object localObject = bOc();
    d.g.b.p.g(localObject, "mmkv");
    paramString = aGS(paramString);
    int i;
    if (((ay)localObject).containsKey(paramString))
    {
      paramString = ((ay)localObject).decodeBytes(paramString);
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
        localObject = sp.class.newInstance();
        ((com.tencent.mm.bw.a)localObject).parseFrom(paramString);
        paramString = (com.tencent.mm.bw.a)localObject;
        paramString = (sp)paramString;
        AppMethodBeat.o(213968);
        return paramString;
      }
      catch (Exception paramString)
      {
        label105:
        ae.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label62;
      label128:
      paramString = null;
    }
  }
  
  public static int aGX(String paramString)
  {
    AppMethodBeat.i(213969);
    d.g.b.p.h(paramString, "appId");
    paramString = aGW(paramString);
    if (paramString != null)
    {
      int i = paramString.version;
      AppMethodBeat.o(213969);
      return i;
    }
    AppMethodBeat.o(213969);
    return 0;
  }
  
  private static void aGY(String paramString)
  {
    AppMethodBeat.i(213973);
    IPCRunCgi.a(kF(paramString, ""), (IPCRunCgi.a)new a(paramString));
    AppMethodBeat.o(213973);
  }
  
  private final boolean ah(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(213965);
    if (!o.fB(paramString2))
    {
      ae.w("MicroMsg.WebCanvasStorageLogic", "isPkgValid file not exit ".concat(String.valueOf(paramString2)));
      paramString2 = g.DQG;
      g.CH(42L);
      com.tencent.mm.plugin.report.service.g.yxI.f(20780, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(3) });
      AppMethodBeat.o(213965);
      return false;
    }
    if (d.g.b.p.i(paramString1, "wxfedb0854e2b1820d")) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.appcache.p localp;
      int i;
      try
      {
        paramString2 = new WxaPkg(paramString2);
        paramString2.aZO();
        localp = (com.tencent.mm.plugin.appbrand.appcache.p)paramString2;
        d.g.b.p.h(localp, "$this$minClientVersion");
        i = new com.tencent.mm.ab.i(a(localp, "/meta.json")).optInt("minClientVersion");
        int j = b((com.tencent.mm.plugin.appbrand.appcache.p)paramString2);
        paramString2.close();
        ae.i("MicroMsg.WebCanvasStorageLogic", "isPkgValid appId=" + paramString1 + ", minClientVersion=0x%x, localClientVersion=0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(d.FFH) });
        if (i <= d.FFH)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(20780, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(0) });
          AppMethodBeat.o(213965);
          return true;
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(20780, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(1) });
        ae.w("MicroMsg.WebCanvasStorageLogic", "isPkgValid minClientVersion check fail");
        paramString1 = g.DQG;
        g.CH(43L);
      }
      catch (Exception paramString1)
      {
        ae.e("MicroMsg.WebCanvasStorageLogic", "isPkgValid ex " + paramString1.getMessage());
        continue;
      }
      AppMethodBeat.o(213965);
      return false;
      if (!d.g.b.p.i(paramString1, "wxf337cbaa27790d8e")) {
        continue;
      }
      try
      {
        paramString2 = new WxaPkg(paramString2);
        paramString2.aZO();
        i = b((com.tencent.mm.plugin.appbrand.appcache.p)paramString2);
        localp = eOF();
        boolean bool = a((com.tencent.mm.plugin.appbrand.appcache.p)paramString2, localp);
        if (!bool)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(20780, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(0) });
          paramString1 = g.DQG;
          g.CH(52L);
        }
        for (;;)
        {
          paramString2.close();
          ((Closeable)localp).close();
          AppMethodBeat.o(213965);
          return bool;
          com.tencent.mm.plugin.report.service.g.yxI.f(20780, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(2) });
        }
      }
      catch (Exception paramString1)
      {
        ae.e("MicroMsg.WebCanvasStorageLogic", "isPkgValid ex " + paramString1.getMessage());
      }
    }
  }
  
  private static int b(com.tencent.mm.plugin.appbrand.appcache.p paramp)
  {
    AppMethodBeat.i(213964);
    d.g.b.p.h(paramp, "$this$version");
    int i = new com.tencent.mm.ab.i(a(paramp, "/meta.json")).optInt("version");
    AppMethodBeat.o(213964);
    return i;
  }
  
  private static ay bOc()
  {
    AppMethodBeat.i(213958);
    ay localay = (ay)nUv.getValue();
    AppMethodBeat.o(213958);
    return localay;
  }
  
  private static boolean eEL()
  {
    AppMethodBeat.i(224476);
    boolean bool = ((Boolean)DQK.getValue()).booleanValue();
    AppMethodBeat.o(224476);
    return bool;
  }
  
  private com.tencent.mm.plugin.appbrand.appcache.p eOF()
  {
    AppMethodBeat.i(213966);
    Object localObject = eOZ();
    com.tencent.mm.plugin.appbrand.appcache.p localp = (com.tencent.mm.plugin.appbrand.appcache.p)new com.tencent.mm.plugin.appbrand.appcache.f(ak.getContext(), "jsapi/webtimeline.wspkg");
    localp.aZO();
    try
    {
      int i = b(localp);
      if (o.fB((String)localObject))
      {
        localObject = (com.tencent.mm.plugin.appbrand.appcache.p)new WxaPkg((String)localObject);
        ((com.tencent.mm.plugin.appbrand.appcache.p)localObject).aZO();
        int j = b((com.tencent.mm.plugin.appbrand.appcache.p)localObject);
        ae.i("MicroMsg.WebCanvasStorageLogic", "wxaPkg resVersion=" + j + " assetsVersion=" + i + ' ');
        if (j > i)
        {
          ae.i("MicroMsg.WebCanvasStorageLogic", "wxaPkg use resPkg");
          AppMethodBeat.o(213966);
          return localObject;
        }
      }
      else
      {
        ae.i("MicroMsg.WebCanvasStorageLogic", "wxaPkg use assets version:".concat(String.valueOf(i)));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.WebCanvasStorageLogic", "wxaPkg handle error: " + localException.getMessage());
      }
    }
    AppMethodBeat.o(213966);
    return localp;
  }
  
  public static String eOW()
  {
    return DQH;
  }
  
  public static String eOX()
  {
    AppMethodBeat.i(213955);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(locale, "MMKernel.storage()");
    localObject = locale.getAccPath() + "webcanvascache/";
    if (!o.fB((String)localObject)) {
      o.aZI((String)localObject);
    }
    AppMethodBeat.o(213955);
    return localObject;
  }
  
  public static int eOY()
  {
    AppMethodBeat.i(213959);
    int i = ((Number)DQI.getValue()).intValue();
    AppMethodBeat.o(213959);
    return i;
  }
  
  public static String eOZ()
  {
    AppMethodBeat.i(213960);
    if (eOY() == 1)
    {
      str = aGV("wxfedb0854e2b1820d");
      AppMethodBeat.o(213960);
      return str;
    }
    String str = aGU("wxfedb0854e2b1820d");
    AppMethodBeat.o(213960);
    return str;
  }
  
  public static void ePa()
  {
    AppMethodBeat.i(213967);
    DQJ.alive();
    AppMethodBeat.o(213967);
  }
  
  public static void ePb()
  {
    AppMethodBeat.i(213971);
    if (System.currentTimeMillis() - obX < ((Number)Jia.getValue()).longValue())
    {
      AppMethodBeat.o(213971);
      return;
    }
    obX = System.currentTimeMillis();
    if (!eEL())
    {
      AppMethodBeat.o(213971);
      return;
    }
    g localg = g.DQG;
    g.CH(40L);
    Mr("gh_a23053671f48@app");
    Mr("gh_c9d570035c3b@app");
    if (eOY() > 0)
    {
      aGY("wxfedb0854e2b1820d");
      aGY("wxf337cbaa27790d8e");
    }
    AppMethodBeat.o(213971);
  }
  
  public static void eUa()
  {
    AppMethodBeat.i(224477);
    if (!eEL())
    {
      AppMethodBeat.o(224477);
      return;
    }
    long l1 = bOc().getLong("webcanvas_last_download_pkg_by_get_data_time", 0L);
    long l2 = System.currentTimeMillis();
    if (Math.abs(l2 - l1) < ((Number)JhZ.getValue()).longValue())
    {
      AppMethodBeat.o(224477);
      return;
    }
    g localg = g.DQG;
    g.CH(45L);
    bOc().encode("webcanvas_last_download_pkg_by_get_data_time", l2);
    ePb();
    AppMethodBeat.o(224477);
  }
  
  private static com.tencent.mm.ak.b kF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213974);
    b.a locala = new b.a();
    wx localwx = new wx();
    localwx.dwb = paramString1;
    localwx.GoB = paramString2;
    locala.c((com.tencent.mm.bw.a)localwx);
    locala.d((com.tencent.mm.bw.a)new wy());
    locala.DN("/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo");
    locala.oS(1124);
    paramString1 = locala.aDS();
    d.g.b.p.g(paramString1, "builder.buildInstance()");
    AppMethodBeat.o(213974);
    return paramString1;
  }
  
  public static void uV(boolean paramBoolean)
  {
    AppMethodBeat.i(213975);
    long l2 = bOc().decodeLong("webcanvas_last_clear_pkg_time", 0L);
    long l1 = System.currentTimeMillis();
    l2 = Math.abs(l1 - l2);
    if ((!paramBoolean) && (l2 < 86400000L))
    {
      ae.d("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg delta ".concat(String.valueOf(l2)));
      AppMethodBeat.o(213975);
      return;
    }
    bOc().encode("webcanvas_last_clear_pkg_time", l1);
    com.tencent.e.h.MqF.r((Runnable)b.DQM, 10000L);
    AppMethodBeat.o(213975);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(213942);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.WebCanvasStorageLogic", "checkPreviewVersion, appId %s, errType %d, errCode %d, errMsg %s", new Object[] { this.jNC, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(213942);
        return;
      }
      do
      {
        for (;;)
        {
          try
          {
            d.g.b.p.g(paramb, "rr");
            paramb = paramb.aEV();
            paramString = paramb;
            if (!(paramb instanceof wy)) {
              paramString = null;
            }
            paramb = (wy)paramString;
            if (paramb != null)
            {
              paramString = paramb.GoD;
              if (paramString != null) {
                break;
              }
              ae.e("MicroMsg.WebCanvasStorageLogic", "checkPreviewVersion, appId %s, null wxaapp resp", new Object[] { this.jNC });
              AppMethodBeat.o(213942);
              return;
            }
          }
          catch (Exception paramString)
          {
            ae.printErrStackTrace("MicroMsg.WebCanvasStorageLogic", (Throwable)paramString, "checkPreviewVersion, appId %s, cast response failed", new Object[] { this.jNC });
            AppMethodBeat.o(213942);
            return;
          }
          paramString = null;
        }
        paramString = h.DQL;
        paramString = h.ePc().decodeString("webcanvas_preview_pkg_md5_" + this.jNC, "");
        ae.i("MicroMsg.WebCanvasStorageLogic", "checkPreviewVersion, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s, localDemoVersionMd5 %s", new Object[] { this.jNC, Integer.valueOf(paramb.GoD.qkQ), Boolean.valueOf(paramb.GoE), paramb.GoF, paramb.GoG, paramString });
        if (paramb.GoD.qkQ != 0)
        {
          ae.e("MicroMsg.WebCanvasStorageLogic", "checkPreviewVersion, baseresponse.ErrCode = " + paramb.GoD.qkQ);
          AppMethodBeat.o(213942);
          return;
        }
        localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class);
        d.g.b.p.g(localObject, "MMKernel.service(IWxaPkg…orageService::class.java)");
        ((com.tencent.mm.plugin.appbrand.api.e)localObject).aYP().a(this.jNC, 2, paramb.GoF, paramb.GoG, 0L, 0L);
      } while ((!paramb.GoE) || (bu.isNullOrNil(paramb.GoG)) || (!(d.g.b.p.i(paramb.GoG, paramString) ^ true)) || (bu.isNullOrNil(paramb.GoF)));
      paramString = h.DQL;
      paramString = this.jNC;
      Object localObject = paramb.GoF;
      d.g.b.p.g(localObject, "response.new_demo_download_url");
      paramb = paramb.GoG;
      d.g.b.p.g(paramb, "response.new_demo_md5");
      h.aQ(paramString, (String)localObject, paramb);
      AppMethodBeat.o(213942);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b DQM;
    
    static
    {
      AppMethodBeat.i(213944);
      DQM = new b();
      AppMethodBeat.o(213944);
    }
    
    public final void run()
    {
      AppMethodBeat.i(213943);
      Iterator localIterator = ((Iterable)j.ab(new String[] { "wxf337cbaa27790d8e", "wxfedb0854e2b1820d" })).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject1 = new StringBuilder();
        Object localObject2 = h.DQL;
        localObject1 = new k(h.eOW() + '/' + str + '/');
        localObject2 = h.DQL;
        localObject2 = h.ePc();
        Object localObject3 = h.DQL;
        localObject2 = ((ay)localObject2).decodeString(h.aGT(str), "");
        localObject3 = h.DQL;
        localObject3 = h.aGZ(str);
        if ((((k)localObject1).exists()) && (((k)localObject1).isDirectory()))
        {
          localObject1 = ((k)localObject1).fTj();
          if (localObject1 != null)
          {
            int j = localObject1.length;
            int i = 0;
            while (i < j)
            {
              Object localObject4 = localObject1[i];
              d.g.b.p.g(localObject4, "file");
              if ((!bu.lX(localObject4.getAbsolutePath(), (String)localObject2)) && (!bu.lX(localObject4.getAbsolutePath(), (String)localObject3)))
              {
                localObject4.delete();
                ae.i("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg appId=" + str + ", path=" + localObject4.getAbsolutePath() + '}');
              }
              i += 1;
            }
          }
        }
      }
      AppMethodBeat.o(213943);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<ay>
  {
    public static final c DQN;
    
    static
    {
      AppMethodBeat.i(213946);
      DQN = new c();
      AppMethodBeat.o(213946);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<Boolean>
  {
    public static final d DQO;
    
    static
    {
      AppMethodBeat.i(213948);
      DQO = new d();
      AppMethodBeat.o(213948);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgDownloadCompleteNotifyEvent;", "callback", "", "event", "webview-sdk_release"})
  public static final class e
    extends c<zx>
  {
    private static boolean a(zx paramzx)
    {
      AppMethodBeat.i(213949);
      d.g.b.p.h(paramzx, "event");
      ae.v("MicroMsg.WebCanvasStorageLogic", "pkgUpdateEventListener appId=%s", new Object[] { paramzx.dQu.appId });
      if (paramzx.dQu.dQv != 0)
      {
        AppMethodBeat.o(213949);
        return true;
      }
      String str = paramzx.dQu.appId;
      if (((d.g.b.p.i("wxf337cbaa27790d8e", str) ^ true)) && ((d.g.b.p.i("wxfedb0854e2b1820d", str) ^ true)))
      {
        AppMethodBeat.o(213949);
        return false;
      }
      ae.i("MicroMsg.WebCanvasStorageLogic", "pkgUpdateEventListener appId=%s, version=%d, md5=%s", new Object[] { str, Integer.valueOf(paramzx.dQu.version), paramzx.dQu.md5 });
      Object localObject1 = g.DQG;
      long l;
      Object localObject2;
      if (d.g.b.p.i("wxfedb0854e2b1820d", str))
      {
        l = 41L;
        g.CH(l);
        if (h.a(h.DQL, str, paramzx.dQu.filePath, paramzx.dQu.version))
        {
          localObject1 = new StringBuilder();
          localObject2 = h.DQL;
          localObject1 = h.eOW() + '/' + str;
          if (!o.fB((String)localObject1)) {
            o.aZI((String)localObject1);
          }
          localObject2 = (String)localObject1 + '/' + System.currentTimeMillis() + ".wcpkg";
          o.mF(paramzx.dQu.filePath, (String)localObject2);
          localObject1 = new sp();
          ((sp)localObject1).appId = str;
          ((sp)localObject1).path = new k((String)localObject2).getAbsolutePath();
          ((sp)localObject1).version = paramzx.dQu.version;
          ((sp)localObject1).dQv = paramzx.dQu.dQv;
          ((sp)localObject1).md5 = paramzx.dQu.md5;
        }
      }
      for (;;)
      {
        try
        {
          paramzx = h.DQL;
          paramzx = h.ePc();
          localObject2 = h.DQL;
          paramzx.encode(h.aGS(str), ((sp)localObject1).toByteArray());
          paramzx = g.DQG;
          if (!d.g.b.p.i("wxfedb0854e2b1820d", str)) {
            continue;
          }
          l = 44L;
          g.CH(l);
        }
        catch (Exception paramzx)
        {
          ae.e("MicroMsg.WebCanvasStorageLogic", "save pkg info fail " + paramzx.getMessage());
          continue;
        }
        AppMethodBeat.o(213949);
        return false;
        l = 51L;
        break;
        l = 53L;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<Integer>
  {
    public static final f DQP;
    
    static
    {
      AppMethodBeat.i(213952);
      DQP = new f();
      AppMethodBeat.o(213952);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$startDownloadDebugPkg$1", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$IWxaPkgUpdateCallback;", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onPkgUpdateResult", "appId", "", "errCode", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "response", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$Response;", "webview-sdk_release"})
  public static final class g
    implements bj.a
  {
    g(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.h
 * JD-Core Version:    0.7.0.1
 */