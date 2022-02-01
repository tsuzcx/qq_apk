package com.tencent.mm.plugin.webcanvas;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.g.a.zr;
import com.tencent.mm.g.a.zr.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bi.a;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.efu;
import com.tencent.mm.protocal.protobuf.sn;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.q;
import d.l;
import java.io.Closeable;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic;", "", "()V", "KEY_WEB_CANVAS_LAST_CLEAR_PKG_TIME", "", "KEY_WEB_CANVAS_PREVIEW_PKG_MD5", "MAX_TriggerPreDownload_INTERVAL", "", "TAG", "WEB_CANVAS_PKG_PATH", "getWEB_CANVAS_PKG_PATH", "()Ljava/lang/String;", "bizPkgAppId", "bizPkgUserName", "lastTriggerPreDownloadTime", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "pkgDownloadOpen", "", "getPkgDownloadOpen", "()Z", "pkgDownloadOpen$delegate", "pkgUpdateEventListener", "com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1;", "previewMode", "", "getPreviewMode", "()I", "previewMode$delegate", "wxaPkgAppId", "wxaPkgUserName", "minBasePkgVersion", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getMinBasePkgVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "minClientVersion", "getMinClientVersion", "version", "getVersion", "checkPreviewVersion", "", "appId", "clearInvalidPkg", "force", "createResResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "md5", "getBizPkgPath", "getBizPreviewPkgPath", "getBizReleasePkgPath", "getPkgInfo", "Lcom/tencent/mm/protocal/protobuf/CanvasPkgInfo;", "getPreviewPkgPath", "pkgType", "getReleasePkgPath", "getWxaPkg", "getWxaPkgPath", "getWxaPkgVersion", "getWxaPreviewPkgPath", "getWxaReleasePkgPath", "isPkgValid", "path", "wxaVersion", "isWxaPkgSupport", "bizPkg", "wxaPkg", "regPkgUpdateEventListener", "startDownloadDebugPkg", "debugType", "downloadURL", "checkSumMd5", "triggerPreDownload", "username", "lastUsePathKey", "pkgInfoKey", "readFile", "webview-sdk_release"})
public final class g
{
  private static final String DyY;
  private static final d.f DyZ;
  private static final e Dza;
  private static final d.f Dzb;
  public static final g Dzc;
  private static final d.f nOP;
  private static long nWo;
  
  static
  {
    AppMethodBeat.i(214133);
    Dzc = new g();
    DyY = com.tencent.mm.loader.j.b.arM() + "/WebCanvasPkg";
    nOP = d.g.O((d.g.a.a)g.c.Dze);
    DyZ = d.g.O((d.g.a.a)f.Dzg);
    Dza = new e();
    Dzb = d.g.O((d.g.a.a)g.d.Dzf);
    AppMethodBeat.o(214133);
  }
  
  private static void LO(String paramString)
  {
    AppMethodBeat.i(214129);
    d.g.b.p.h(paramString, "username");
    ((r)com.tencent.mm.kernel.g.ab(r.class)).LO(paramString);
    AppMethodBeat.o(214129);
  }
  
  /* Error */
  private static String a(com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 206
    //   4: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 208
    //   10: invokestatic 191	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc 209
    //   16: invokestatic 191	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokeinterface 215 2 0
    //   26: checkcast 217	java/io/Closeable
    //   29: astore_3
    //   30: aload_3
    //   31: checkcast 219	java/io/InputStream
    //   34: astore_0
    //   35: aload_0
    //   36: ldc 221
    //   38: invokestatic 224	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   41: new 226	java/lang/String
    //   44: dup
    //   45: aload_0
    //   46: invokestatic 232	d/f/a:X	(Ljava/io/InputStream;)[B
    //   49: getstatic 238	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   52: invokespecial 241	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   55: astore_0
    //   56: aload_3
    //   57: aconst_null
    //   58: invokestatic 246	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   61: ldc 206
    //   63: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: areturn
    //   68: astore_1
    //   69: ldc 206
    //   71: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_1
    //   75: athrow
    //   76: astore_0
    //   77: aload_3
    //   78: aload_1
    //   79: invokestatic 246	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   82: ldc 206
    //   84: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(214127);
    d.g.b.p.h(paramp1, "bizPkg");
    d.g.b.p.h(paramp2, "wxaPkg");
    try
    {
      d.g.b.p.h(paramp1, "$this$minBasePkgVersion");
      int i = new com.tencent.mm.ac.i(a(paramp1, "/meta.json")).optInt("minBasePkgVersion");
      int j = b(paramp2);
      ad.i("MicroMsg.WebCanvasStorageLogic", "isPkgValid minBasePkgVersion=" + i + ", wxaPkgVersionn=" + j);
      if (i <= j)
      {
        AppMethodBeat.o(214127);
        return true;
      }
      ad.w("MicroMsg.WebCanvasStorageLogic", "isWxaPkgSupport minBasePkgVersion check fail");
      paramp1 = f.DyX;
      f.Cj(59L);
    }
    catch (Exception paramp1)
    {
      for (;;)
      {
        ad.e("MicroMsg.WebCanvasStorageLogic", "isWxaPkgSupport ex " + paramp1.getMessage());
      }
    }
    AppMethodBeat.o(214127);
    return false;
  }
  
  static String aFA(String paramString)
  {
    AppMethodBeat.i(214118);
    sn localsn = aFC(paramString);
    if (localsn == null)
    {
      ad.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath pkgInfo is null");
      AppMethodBeat.o(214118);
      return null;
    }
    if (!com.tencent.mm.vfs.i.fv(localsn.path))
    {
      ad.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath pkgInfo " + localsn.path + " not exist");
      AppMethodBeat.o(214118);
      return null;
    }
    ad.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath appId=" + paramString + ", md5=" + localsn.md5 + " download version= " + localsn.version + " path=" + localsn.path);
    bNe().encode(aFz(paramString), new com.tencent.mm.vfs.e(localsn.path).getAbsolutePath());
    paramString = localsn.path;
    AppMethodBeat.o(214118);
    return paramString;
  }
  
  static String aFB(String paramString)
  {
    AppMethodBeat.i(214119);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class);
    d.g.b.p.g(localObject, "MMKernel.service(IWxaPkg…orageService::class.java)");
    localObject = ((com.tencent.mm.plugin.appbrand.api.e)localObject).aYu().a(paramString, 2, new String[] { "version", "pkgPath", "versionMd5" });
    StringBuilder localStringBuilder = new StringBuilder("getPreviewPkgPath appId=").append(paramString).append(", pkgType=2, md5=");
    if (localObject != null)
    {
      paramString = ((bc)localObject).field_versionMd5;
      localStringBuilder = localStringBuilder.append(paramString).append(" download version= ");
      if (localObject == null) {
        break label168;
      }
      paramString = Integer.valueOf(((bc)localObject).field_version);
      label111:
      localStringBuilder = localStringBuilder.append(paramString).append(" path=");
      if (localObject == null) {
        break label173;
      }
    }
    label168:
    label173:
    for (paramString = ((bc)localObject).field_pkgPath;; paramString = null)
    {
      ad.i("MicroMsg.WebCanvasStorageLogic", paramString);
      if (localObject == null) {
        break label178;
      }
      paramString = ((bc)localObject).field_pkgPath;
      AppMethodBeat.o(214119);
      return paramString;
      paramString = null;
      break;
      paramString = null;
      break label111;
    }
    label178:
    AppMethodBeat.o(214119);
    return null;
  }
  
  public static sn aFC(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(214125);
    d.g.b.p.h(paramString, "appId");
    Object localObject = bNe();
    d.g.b.p.g(localObject, "mmkv");
    paramString = aFy(paramString);
    int i;
    if (((ax)localObject).containsKey(paramString))
    {
      paramString = ((ax)localObject).decodeBytes(paramString);
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
        localObject = sn.class.newInstance();
        ((com.tencent.mm.bx.a)localObject).parseFrom(paramString);
        paramString = (com.tencent.mm.bx.a)localObject;
        paramString = (sn)paramString;
        AppMethodBeat.o(214125);
        return paramString;
      }
      catch (Exception paramString)
      {
        label105:
        ad.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label62;
      label128:
      paramString = null;
    }
  }
  
  public static int aFD(String paramString)
  {
    AppMethodBeat.i(214126);
    d.g.b.p.h(paramString, "appId");
    paramString = aFC(paramString);
    if (paramString != null)
    {
      int i = paramString.version;
      AppMethodBeat.o(214126);
      return i;
    }
    AppMethodBeat.o(214126);
    return 0;
  }
  
  private static void aFE(String paramString)
  {
    AppMethodBeat.i(214130);
    IPCRunCgi.a(ky(paramString, ""), (IPCRunCgi.a)new a(paramString));
    AppMethodBeat.o(214130);
  }
  
  public static String aFy(String paramString)
  {
    AppMethodBeat.i(214113);
    d.g.b.p.h(paramString, "$this$pkgInfoKey");
    paramString = "webcanvas_pkg_info_".concat(String.valueOf(paramString));
    AppMethodBeat.o(214113);
    return paramString;
  }
  
  public static String aFz(String paramString)
  {
    AppMethodBeat.i(214114);
    d.g.b.p.h(paramString, "$this$lastUsePathKey");
    paramString = "webcanvas_last_use_pkg_path_".concat(String.valueOf(paramString));
    AppMethodBeat.o(214114);
    return paramString;
  }
  
  private final boolean af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(214122);
    if (!com.tencent.mm.vfs.i.fv(paramString2))
    {
      ad.w("MicroMsg.WebCanvasStorageLogic", "isPkgValid file not exit ".concat(String.valueOf(paramString2)));
      paramString2 = f.DyX;
      f.Cj(42L);
      com.tencent.mm.plugin.report.service.g.yhR.f(20780, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(3) });
      AppMethodBeat.o(214122);
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
        paramString2.aZr();
        localp = (com.tencent.mm.plugin.appbrand.appcache.p)paramString2;
        d.g.b.p.h(localp, "$this$minClientVersion");
        i = new com.tencent.mm.ac.i(a(localp, "/meta.json")).optInt("minClientVersion");
        int j = b((com.tencent.mm.plugin.appbrand.appcache.p)paramString2);
        paramString2.close();
        ad.i("MicroMsg.WebCanvasStorageLogic", "isPkgValid appId=" + paramString1 + ", minClientVersion=0x%x, localClientVersion=0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(d.Fnj) });
        if (i <= d.Fnj)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(20780, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(0) });
          AppMethodBeat.o(214122);
          return true;
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(20780, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(1) });
        ad.w("MicroMsg.WebCanvasStorageLogic", "isPkgValid minClientVersion check fail");
        paramString1 = f.DyX;
        f.Cj(43L);
      }
      catch (Exception paramString1)
      {
        ad.e("MicroMsg.WebCanvasStorageLogic", "isPkgValid ex " + paramString1.getMessage());
        continue;
      }
      AppMethodBeat.o(214122);
      return false;
      if (!d.g.b.p.i(paramString1, "wxf337cbaa27790d8e")) {
        continue;
      }
      try
      {
        paramString2 = new WxaPkg(paramString2);
        paramString2.aZr();
        i = b((com.tencent.mm.plugin.appbrand.appcache.p)paramString2);
        localp = eKX();
        boolean bool = a((com.tencent.mm.plugin.appbrand.appcache.p)paramString2, localp);
        if (!bool)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(20780, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(0) });
          paramString1 = f.DyX;
          f.Cj(52L);
        }
        for (;;)
        {
          paramString2.close();
          ((Closeable)localp).close();
          AppMethodBeat.o(214122);
          return bool;
          com.tencent.mm.plugin.report.service.g.yhR.f(20780, new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(2) });
        }
      }
      catch (Exception paramString1)
      {
        ad.e("MicroMsg.WebCanvasStorageLogic", "isPkgValid ex " + paramString1.getMessage());
      }
    }
  }
  
  private static int b(com.tencent.mm.plugin.appbrand.appcache.p paramp)
  {
    AppMethodBeat.i(214121);
    d.g.b.p.h(paramp, "$this$version");
    int i = new com.tencent.mm.ac.i(a(paramp, "/meta.json")).optInt("version");
    AppMethodBeat.o(214121);
    return i;
  }
  
  private static ax bNe()
  {
    AppMethodBeat.i(214115);
    ax localax = (ax)nOP.getValue();
    AppMethodBeat.o(214115);
    return localax;
  }
  
  private com.tencent.mm.plugin.appbrand.appcache.p eKX()
  {
    AppMethodBeat.i(214123);
    Object localObject = eLq();
    com.tencent.mm.plugin.appbrand.appcache.p localp = (com.tencent.mm.plugin.appbrand.appcache.p)new com.tencent.mm.plugin.appbrand.appcache.f(aj.getContext(), "jsapi/webtimeline.wspkg");
    localp.aZr();
    try
    {
      int i = b(localp);
      if (com.tencent.mm.vfs.i.fv((String)localObject))
      {
        localObject = (com.tencent.mm.plugin.appbrand.appcache.p)new WxaPkg((String)localObject);
        ((com.tencent.mm.plugin.appbrand.appcache.p)localObject).aZr();
        int j = b((com.tencent.mm.plugin.appbrand.appcache.p)localObject);
        ad.i("MicroMsg.WebCanvasStorageLogic", "wxaPkg resVersion=" + j + " assetsVersion=" + i + ' ');
        if (j > i)
        {
          ad.i("MicroMsg.WebCanvasStorageLogic", "wxaPkg use resPkg");
          AppMethodBeat.o(214123);
          return localObject;
        }
      }
      else
      {
        ad.i("MicroMsg.WebCanvasStorageLogic", "wxaPkg use assets version:".concat(String.valueOf(i)));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.WebCanvasStorageLogic", "wxaPkg handle error: " + localException.getMessage());
      }
    }
    AppMethodBeat.o(214123);
    return localp;
  }
  
  public static String eLo()
  {
    return DyY;
  }
  
  public static int eLp()
  {
    AppMethodBeat.i(214116);
    int i = ((Number)DyZ.getValue()).intValue();
    AppMethodBeat.o(214116);
    return i;
  }
  
  public static String eLq()
  {
    AppMethodBeat.i(214117);
    if (eLp() == 1)
    {
      str = aFB("wxfedb0854e2b1820d");
      AppMethodBeat.o(214117);
      return str;
    }
    String str = aFA("wxfedb0854e2b1820d");
    AppMethodBeat.o(214117);
    return str;
  }
  
  public static void eLr()
  {
    AppMethodBeat.i(214124);
    Dza.alive();
    AppMethodBeat.o(214124);
  }
  
  public static void eLs()
  {
    AppMethodBeat.i(214128);
    if (System.currentTimeMillis() - nWo < 1800000L)
    {
      AppMethodBeat.o(214128);
      return;
    }
    nWo = System.currentTimeMillis();
    if (!((Boolean)Dzb.getValue()).booleanValue())
    {
      AppMethodBeat.o(214128);
      return;
    }
    f localf = f.DyX;
    f.Cj(40L);
    LO("gh_a23053671f48@app");
    LO("gh_c9d570035c3b@app");
    if (eLp() > 0)
    {
      aFE("wxfedb0854e2b1820d");
      aFE("wxf337cbaa27790d8e");
    }
    AppMethodBeat.o(214128);
  }
  
  private static com.tencent.mm.al.b ky(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214131);
    b.a locala = new b.a();
    wu localwu = new wu();
    localwu.duW = paramString1;
    localwu.FWc = paramString2;
    locala.c((com.tencent.mm.bx.a)localwu);
    locala.d((com.tencent.mm.bx.a)new wv());
    locala.Dl("/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo");
    locala.oP(1124);
    paramString1 = locala.aDC();
    d.g.b.p.g(paramString1, "builder.buildInstance()");
    AppMethodBeat.o(214131);
    return paramString1;
  }
  
  public static void uN(boolean paramBoolean)
  {
    AppMethodBeat.i(214132);
    long l2 = bNe().decodeLong("webcanvas_last_clear_pkg_time", 0L);
    long l1 = System.currentTimeMillis();
    l2 = Math.abs(l1 - l2);
    if ((!paramBoolean) && (l2 < 86400000L))
    {
      ad.d("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg delta ".concat(String.valueOf(l2)));
      AppMethodBeat.o(214132);
      return;
    }
    bNe().encode("webcanvas_last_clear_pkg_time", l1);
    h.LTJ.r((Runnable)b.Dzd, 10000L);
    AppMethodBeat.o(214132);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(214100);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.WebCanvasStorageLogic", "checkPreviewVersion, appId %s, errType %d, errCode %d, errMsg %s", new Object[] { this.jKq, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(214100);
        return;
      }
      do
      {
        for (;;)
        {
          try
          {
            d.g.b.p.g(paramb, "rr");
            paramb = paramb.aEF();
            paramString = paramb;
            if (!(paramb instanceof wv)) {
              paramString = null;
            }
            paramb = (wv)paramString;
            if (paramb != null)
            {
              paramString = paramb.FWe;
              if (paramString != null) {
                break;
              }
              ad.e("MicroMsg.WebCanvasStorageLogic", "checkPreviewVersion, appId %s, null wxaapp resp", new Object[] { this.jKq });
              AppMethodBeat.o(214100);
              return;
            }
          }
          catch (Exception paramString)
          {
            ad.printErrStackTrace("MicroMsg.WebCanvasStorageLogic", (Throwable)paramString, "checkPreviewVersion, appId %s, cast response failed", new Object[] { this.jKq });
            AppMethodBeat.o(214100);
            return;
          }
          paramString = null;
        }
        paramString = g.Dzc;
        paramString = g.eLt().decodeString("webcanvas_preview_pkg_md5_" + this.jKq, "");
        ad.i("MicroMsg.WebCanvasStorageLogic", "checkPreviewVersion, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s, localDemoVersionMd5 %s", new Object[] { this.jKq, Integer.valueOf(paramb.FWe.qel), Boolean.valueOf(paramb.FWf), paramb.FWg, paramb.FWh, paramString });
        if (paramb.FWe.qel != 0)
        {
          ad.e("MicroMsg.WebCanvasStorageLogic", "checkPreviewVersion, baseresponse.ErrCode = " + paramb.FWe.qel);
          AppMethodBeat.o(214100);
          return;
        }
        localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class);
        d.g.b.p.g(localObject, "MMKernel.service(IWxaPkg…orageService::class.java)");
        ((com.tencent.mm.plugin.appbrand.api.e)localObject).aYu().a(this.jKq, 2, paramb.FWg, paramb.FWh, 0L, 0L);
      } while ((!paramb.FWf) || (bt.isNullOrNil(paramb.FWh)) || (!(d.g.b.p.i(paramb.FWh, paramString) ^ true)) || (bt.isNullOrNil(paramb.FWg)));
      paramString = g.Dzc;
      paramString = this.jKq;
      Object localObject = paramb.FWg;
      d.g.b.p.g(localObject, "response.new_demo_download_url");
      paramb = paramb.FWh;
      d.g.b.p.g(paramb, "response.new_demo_md5");
      g.aP(paramString, (String)localObject, paramb);
      AppMethodBeat.o(214100);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b Dzd;
    
    static
    {
      AppMethodBeat.i(214102);
      Dzd = new b();
      AppMethodBeat.o(214102);
    }
    
    public final void run()
    {
      AppMethodBeat.i(214101);
      Iterator localIterator = ((Iterable)j.ac(new String[] { "wxf337cbaa27790d8e", "wxfedb0854e2b1820d" })).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject1 = new StringBuilder();
        Object localObject2 = g.Dzc;
        localObject1 = new com.tencent.mm.vfs.e(g.eLo() + '/' + str + '/');
        localObject2 = g.Dzc;
        localObject2 = g.eLt();
        Object localObject3 = g.Dzc;
        localObject2 = ((ax)localObject2).decodeString(g.aFz(str), "");
        localObject3 = g.Dzc;
        localObject3 = g.aFF(str);
        if ((((com.tencent.mm.vfs.e)localObject1).exists()) && (((com.tencent.mm.vfs.e)localObject1).isDirectory()))
        {
          localObject1 = ((com.tencent.mm.vfs.e)localObject1).fOM();
          if (localObject1 != null)
          {
            int j = localObject1.length;
            int i = 0;
            while (i < j)
            {
              Object localObject4 = localObject1[i];
              d.g.b.p.g(localObject4, "file");
              if ((!bt.lQ(localObject4.getAbsolutePath(), (String)localObject2)) && (!bt.lQ(localObject4.getAbsolutePath(), (String)localObject3)))
              {
                localObject4.delete();
                ad.i("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg appId=" + str + ", path=" + localObject4.getAbsolutePath() + '}');
              }
              i += 1;
            }
          }
        }
      }
      AppMethodBeat.o(214101);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WxaPkgDownloadCompleteNotifyEvent;", "callback", "", "event", "webview-sdk_release"})
  public static final class e
    extends c<zr>
  {
    private static boolean a(zr paramzr)
    {
      AppMethodBeat.i(214107);
      d.g.b.p.h(paramzr, "event");
      ad.v("MicroMsg.WebCanvasStorageLogic", "pkgUpdateEventListener appId=%s", new Object[] { paramzr.dPe.appId });
      if (paramzr.dPe.dPf != 0)
      {
        AppMethodBeat.o(214107);
        return true;
      }
      String str = paramzr.dPe.appId;
      if (((d.g.b.p.i("wxf337cbaa27790d8e", str) ^ true)) && ((d.g.b.p.i("wxfedb0854e2b1820d", str) ^ true)))
      {
        AppMethodBeat.o(214107);
        return false;
      }
      ad.i("MicroMsg.WebCanvasStorageLogic", "pkgUpdateEventListener appId=%s, version=%d, md5=%s", new Object[] { str, Integer.valueOf(paramzr.dPe.version), paramzr.dPe.md5 });
      Object localObject1 = f.DyX;
      long l;
      if (d.g.b.p.i("wxfedb0854e2b1820d", str)) {
        l = 41L;
      }
      for (;;)
      {
        f.Cj(l);
        Object localObject2;
        if (g.a(g.Dzc, str, paramzr.dPe.filePath, paramzr.dPe.version))
        {
          localObject1 = new StringBuilder();
          localObject2 = g.Dzc;
          localObject1 = g.eLo() + '/' + str;
          if (!com.tencent.mm.vfs.i.fv((String)localObject1)) {
            com.tencent.mm.vfs.i.aYg((String)localObject1);
          }
          localObject2 = (String)localObject1 + '/' + System.currentTimeMillis() + ".wcpkg";
          com.tencent.mm.vfs.i.mz(paramzr.dPe.filePath, (String)localObject2);
          localObject1 = new sn();
          ((sn)localObject1).appId = str;
          ((sn)localObject1).path = new com.tencent.mm.vfs.e((String)localObject2).getAbsolutePath();
          ((sn)localObject1).version = paramzr.dPe.version;
          ((sn)localObject1).dPf = paramzr.dPe.dPf;
          ((sn)localObject1).md5 = paramzr.dPe.md5;
        }
        try
        {
          paramzr = g.Dzc;
          paramzr = g.eLt();
          localObject2 = g.Dzc;
          paramzr.encode(g.aFy(str), ((sn)localObject1).toByteArray());
          AppMethodBeat.o(214107);
          return false;
          l = 51L;
        }
        catch (Exception paramzr)
        {
          for (;;)
          {
            ad.e("MicroMsg.WebCanvasStorageLogic", "save pkg info fail " + paramzr.getMessage());
          }
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<Integer>
  {
    public static final f Dzg;
    
    static
    {
      AppMethodBeat.i(214110);
      Dzg = new f();
      AppMethodBeat.o(214110);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$startDownloadDebugPkg$1", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$IWxaPkgUpdateCallback;", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onPkgUpdateResult", "appId", "", "errCode", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "response", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$Response;", "webview-sdk_release"})
  public static final class g
    implements bi.a
  {
    g(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.g
 * JD-Core Version:    0.7.0.1
 */