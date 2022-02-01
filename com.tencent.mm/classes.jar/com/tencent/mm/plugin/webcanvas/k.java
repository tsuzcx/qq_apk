package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.w.a;
import com.tencent.mm.plugin.appbrand.service.w.b;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.protocal.protobuf.egn;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic;", "", "()V", "KEY_PREFETCHER_BIZ_APPIDS", "", "KEY_WEB_CANVAS_LAST_CLEAR_PKG_TIME", "KEY_WEB_CANVAS_LAST_DOWNLOAD_PKG_BY_GET_DATA_TIME", "KEY_WEB_CANVAS_PREVIEW_PKG_MD5", "TAG", "WEB_CANVAS_DIRECTORY", "WEB_CANVAS_PKG_PATH", "WEB_PREFETCHER_PKG_DIRECTORY", "WEB_PREFETCHER_PKG_PATH", "adPrefetchAppId", "batchDownloadAppIds", "", "getBatchDownloadAppIds", "()Ljava/util/List;", "batchDownloadAppIds$delegate", "Lkotlin/Lazy;", "bizPkgAppId", "lastTriggerPreDownloadTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "pkgClearListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$PkgClearListener;", "pkgDownloadOpen", "", "getPkgDownloadOpen", "()Z", "pkgDownloadOpen$delegate", "pkgUpdateEventListener", "com/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$pkgUpdateEventListener$1;", "pkgUpdateListener", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$PkgUpdateCallback;", "preDownLoadSceneBiz", "", "preDownLoadSceneCommFetch", "prefetchBasePkgAppId", "prefetchBizPkgAppIds", "Ljava/util/LinkedList;", "getPrefetchBizPkgAppIds", "()Ljava/util/LinkedList;", "prefetchBizPkgAppIds$delegate", "previewMode", "getPreviewMode", "()I", "previewMode$delegate", "triggerDownLoadPkgInterval", "getTriggerDownLoadPkgInterval", "()J", "triggerDownLoadPkgInterval$delegate", "triggerDownLoadPkgOnGetDataInterval", "getTriggerDownLoadPkgOnGetDataInterval", "triggerDownLoadPkgOnGetDataInterval$delegate", "triggerDownLoadPrefetchPkgInterval", "getTriggerDownLoadPrefetchPkgInterval", "triggerDownLoadPrefetchPkgInterval$delegate", "usePreDownLoad", "getUsePreDownLoad", "usePreDownLoad$delegate", "webPrefetchPkgInterval", "getWebPrefetchPkgInterval", "webPrefetchPkgInterval$delegate", "wxaPkgAppId", "minBasePkgVersion", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getMinBasePkgVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "minClientVersion", "getMinClientVersion", "addPrefetchBizPkgAppId", "", "appId", "checkPreviewVersion", "clearInvalidPkg", "force", "clearPkgImpl", "dir", "Lcom/tencent/mm/vfs/VFSFile;", "current", "clearPkgInfo", "fetchBizPrefetchPkg", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "userName", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBizAppIds", "getPkgInfo", "Lcom/tencent/mm/protocal/protobuf/CanvasPkgInfo;", "getPkgPath", "pkgType", "getReleasePkgPath", "getWebCanvasCachePath", "getWebCanvasPkgDirectory", "getWebPrefetcherPkgDirectory", "getWxaPkgVersion", "isPkgValid", "path", "wxaVersion", "isWxaPkgSupport", "bizPkg", "wxaPkg", "regPkgUpdateEventListener", "registerPkgClearListener", "listener", "saveBizAppIds", "saveWxaPkgInfo", "pkg", "triggerPreDownload", "scene", "triggerPreDownloadBizPrefetchPkg", "interval", "triggerPreDownloadByGetData", "triggerPreDownloadPrefetchBasePkg", "triggerPreDownloadPrefetchPkg", "unregisterPkgClearListener", "fileValid", "lastDownloadTime", "lastUsePathKey", "lastUseTimeKey", "pkgInfoKey", "PkgClearListener", "PkgDownloadReporter", "PkgUpdateCallback", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  private static final kotlin.j SKA;
  private static final kotlin.j SKh;
  private static final kotlin.j SKj;
  public static final k WkZ;
  private static final String Wla;
  private static final String Wlb;
  private static final CopyOnWriteArraySet<a> Wlc;
  private static final kotlin.j Wld;
  private static final kotlin.j Wle;
  private static final kotlin.j Wlf;
  private static final kotlin.j Wlg;
  private static final kotlin.j Wlh;
  private static final kotlin.j Wli;
  private static final ConcurrentHashMap<String, Object> Wlj;
  private static final WebCanvasStorageLogic.pkgUpdateEventListener.1 Wlk;
  private static final kotlin.j exj;
  private static long vBG;
  
  static
  {
    AppMethodBeat.i(261491);
    WkZ = new k();
    Wla = s.X(com.tencent.mm.loader.i.b.bmr(), "/WebCanvasPkg");
    Wlb = s.X(com.tencent.mm.loader.i.b.bmr(), "/WebPrefetcherPkg");
    Wlc = new CopyOnWriteArraySet();
    Wld = kotlin.k.cm((kotlin.g.a.a)h.Wlp);
    exj = kotlin.k.cm((kotlin.g.a.a)f.Wln);
    SKh = kotlin.k.cm((kotlin.g.a.a)i.Wlq);
    Wle = kotlin.k.cm((kotlin.g.a.a)g.Wlo);
    SKA = kotlin.k.cm((kotlin.g.a.a)m.Wlu);
    Wlf = kotlin.k.cm((kotlin.g.a.a)c.Wlm);
    Wlg = kotlin.k.cm((kotlin.g.a.a)k.Wls);
    Wlh = kotlin.k.cm((kotlin.g.a.a)l.Wlt);
    SKj = kotlin.k.cm((kotlin.g.a.a)j.Wlr);
    Wli = kotlin.k.cm((kotlin.g.a.a)n.Wlv);
    Wlj = new ConcurrentHashMap();
    Wlk = new WebCanvasStorageLogic.pkgUpdateEventListener.1(com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(261491);
  }
  
  public static void Ik(boolean paramBoolean)
  {
    AppMethodBeat.i(261416);
    long l2 = atj().decodeLong("webcanvas_last_clear_pkg_time", 0L);
    long l1 = System.currentTimeMillis();
    l2 = Math.abs(l1 - l2);
    if ((!paramBoolean) && (l2 < 86400000L))
    {
      Log.d("MicroMsg.WebCanvasStorageLogic", s.X("clearInvalidPkg delta ", Long.valueOf(l2)));
      AppMethodBeat.o(261416);
      return;
    }
    atj().encode("webcanvas_last_clear_pkg_time", l1);
    com.tencent.threadpool.h.ahAA.p(k..ExternalSyntheticLambda4.INSTANCE, 20000L);
    AppMethodBeat.o(261416);
  }
  
  private static final void R(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(261439);
    s.u(paramString1, "$appId");
    Log.e("MicroMsg.WebCanvasStorageLogic", "triggerPreDownload(appId:" + paramString1 + "), onError(errCode:" + paramInt + ", errMsg:" + paramString2 + ')');
    AppMethodBeat.o(261439);
  }
  
  private static final void S(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(261452);
    s.u(paramString1, "$appId");
    Log.e("MicroMsg.WebCanvasStorageLogic", "checkPreviewVersion(appId:" + paramString1 + "), onError(errCode:" + paramInt + ", errMsg:" + paramString2 + ')');
    AppMethodBeat.o(261452);
  }
  
  public static final void a(a parama)
  {
    AppMethodBeat.i(261269);
    s.u(parama, "listener");
    Wlc.add(parama);
    AppMethodBeat.o(261269);
  }
  
  private final void a(com.tencent.mm.vfs.u paramu, String paramString, long paramLong)
  {
    AppMethodBeat.i(261426);
    if (!paramu.jKS())
    {
      AppMethodBeat.o(261426);
      return;
    }
    Object localObject1 = (x)com.tencent.mm.kernel.h.ax(x.class);
    if (localObject1 != null) {
      ((x)localObject1).bM(paramString, bid(paramString));
    }
    localObject1 = atj().decodeString(bhZ(paramString), "");
    long l = atj().decodeLong(bia(paramString), 0L);
    String str = bib(paramString);
    if ((paramu.jKS()) && (paramu.isDirectory()))
    {
      paramu = paramu.jKX();
      if (paramu != null)
      {
        int j = paramu.length;
        int i = 0;
        if (i < j)
        {
          Object localObject2 = paramu[i];
          Log.v("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg file: %s, newestPath: %s, lastUsePath: %s, fileName: %s", new Object[] { com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)localObject2).jKT()), str, localObject1, ((com.tencent.mm.vfs.u)localObject2).getName() });
          if ((!Util.isEqual(com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)localObject2).jKT()), (String)localObject1)) && (!Util.isEqual(com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)localObject2).jKT()), str)))
          {
            ((com.tencent.mm.vfs.u)localObject2).diJ();
            s.s(localObject2, "file");
            h(paramString, (com.tencent.mm.vfs.u)localObject2);
            Log.i("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg appId=" + paramString + ", path=" + com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)localObject2).jKT()));
            localObject2 = j.WkY;
            j.xC(120L);
          }
          for (;;)
          {
            i += 1;
            break;
            if ((ioL().contains(paramString)) && (!s.p("wxa06c02b5c00ff39b", paramString)) && (l != 0L) && (paramLong - l > 2592000000L))
            {
              ((com.tencent.mm.vfs.u)localObject2).diJ();
              s.s(localObject2, "file");
              h(paramString, (com.tencent.mm.vfs.u)localObject2);
              Log.i("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg on timeout appId=" + paramString + ", path=" + com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)localObject2).jKT()) + '}');
              localObject2 = j.WkY;
              j.xC(121L);
            }
          }
        }
      }
    }
    AppMethodBeat.o(261426);
  }
  
  public static void a(String paramString, vn paramvn)
  {
    AppMethodBeat.i(261367);
    s.u(paramString, "appId");
    s.u(paramvn, "pkg");
    atj().encode(bhY(paramString), paramvn.toByteArray());
    AppMethodBeat.o(261367);
  }
  
  public static boolean a(q paramq1, q paramq2)
  {
    AppMethodBeat.i(261365);
    s.u(paramq1, "bizPkg");
    s.u(paramq2, "wxaPkg");
    try
    {
      s.u(paramq1, "<this>");
      int i = new com.tencent.mm.ad.i(r.a(paramq1, "/meta.json")).optInt("minAndroidBasePkgVersion");
      int j = com.tencent.mm.plugin.webview.l.a.h(paramq2);
      Log.i("MicroMsg.WebCanvasStorageLogic", "isPkgValid minBasePkgVersion=" + i + ", wxaPkgVersionn=" + j);
      if (i <= j)
      {
        AppMethodBeat.o(261365);
        return true;
      }
      Log.w("MicroMsg.WebCanvasStorageLogic", "isWxaPkgSupport minBasePkgVersion check fail");
      paramq1 = j.WkY;
      j.xC(59L);
    }
    catch (Exception paramq1)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebCanvasStorageLogic", s.X("isWxaPkgSupport ex ", paramq1.getMessage()));
      }
    }
    AppMethodBeat.o(261365);
    return false;
  }
  
  private static boolean aD(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(261357);
    if (!com.tencent.mm.vfs.y.ZC(paramString2))
    {
      Log.w("MicroMsg.WebCanvasStorageLogic", s.X("isPkgValid file not exit ", paramString2));
      if (s.p(paramString1, "wxfedb0854e2b1820d"))
      {
        paramString2 = j.WkY;
        j.xC(42L);
      }
      for (;;)
      {
        paramString2 = b.Wll;
        b.t(paramString1, paramInt, 0, 3);
        AppMethodBeat.o(261357);
        return false;
        if (s.p(paramString1, "wx97b7aebac2183fd2"))
        {
          paramString2 = j.WkY;
          j.xC(49L);
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = new WxaPkg(paramString2);
        paramString2.cfK();
        q localq = (q)paramString2;
        s.u(localq, "<this>");
        int i = new com.tencent.mm.ad.i(r.a(localq, "/meta.json")).optInt("minAndroidClientVersion");
        int j = com.tencent.mm.plugin.webview.l.a.h((q)paramString2);
        paramString2.close();
        Log.i("MicroMsg.WebCanvasStorageLogic", "isPkgValid appId=" + paramString1 + ", minClientVersion=0x%x, localClientVersion=0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.Yxh) });
        if (i <= com.tencent.mm.protocal.d.Yxh)
        {
          paramString2 = b.Wll;
          b.t(paramString1, paramInt, j, 0);
          AppMethodBeat.o(261357);
          return true;
        }
        paramString2 = b.Wll;
        b.t(paramString1, paramInt, j, 1);
        Log.w("MicroMsg.WebCanvasStorageLogic", "isPkgValid minClientVersion check fail");
        if (!s.p(paramString1, "wxfedb0854e2b1820d")) {
          continue;
        }
        paramString1 = j.WkY;
        j.xC(43L);
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.WebCanvasStorageLogic", s.X("isPkgValid ex ", paramString1.getMessage()));
        continue;
      }
      AppMethodBeat.o(261357);
      return false;
      if (s.p(paramString1, "wx97b7aebac2183fd2"))
      {
        paramString1 = j.WkY;
        j.xC(50L);
      }
    }
  }
  
  public static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(261323);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(261323);
    return localMultiProcessMMKV;
  }
  
  private static final void b(String paramString1, bh parambh, String paramString2)
  {
    AppMethodBeat.i(261431);
    s.u(paramString1, "$appId");
    s.u(parambh, "record");
    s.u(paramString2, "filePath");
    Log.i("MicroMsg.WebCanvasStorageLogic", "triggerPreDownload(appId:" + paramString1 + "), onSuccess(path:" + paramString2 + ')');
    AppMethodBeat.o(261431);
  }
  
  private static void bL(String paramString, int paramInt)
  {
    AppMethodBeat.i(261408);
    s.u(paramString, "appId");
    if ((hBN()) && (!ioN().contains(paramString)))
    {
      ((com.tencent.mm.plugin.appbrand.service.y)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.y.class)).z(null, paramString, paramInt);
      AppMethodBeat.o(261408);
      return;
    }
    ((w)com.tencent.mm.kernel.h.ax(w.class)).a(paramString, 0, new k..ExternalSyntheticLambda2(paramString), new k..ExternalSyntheticLambda1(paramString));
    AppMethodBeat.o(261408);
  }
  
  private static String bcR(String paramString)
  {
    AppMethodBeat.i(261320);
    s.u(paramString, "<this>");
    paramString = s.X(paramString, "-lastDownLoawnTime");
    AppMethodBeat.o(261320);
    return paramString;
  }
  
  private static void bcW(String paramString)
  {
    AppMethodBeat.i(261411);
    ((w)com.tencent.mm.kernel.h.ax(w.class)).a(paramString, 2, new k..ExternalSyntheticLambda3(paramString), new k..ExternalSyntheticLambda0(paramString));
    AppMethodBeat.o(261411);
  }
  
  public static String bhW(String paramString)
  {
    AppMethodBeat.i(261278);
    s.u(paramString, "appId");
    paramString = Wla + '/' + paramString;
    AppMethodBeat.o(261278);
    return paramString;
  }
  
  public static String bhX(String paramString)
  {
    AppMethodBeat.i(261284);
    s.u(paramString, "appId");
    paramString = Wlb + '/' + paramString;
    AppMethodBeat.o(261284);
    return paramString;
  }
  
  private static String bhY(String paramString)
  {
    AppMethodBeat.i(261300);
    s.u(paramString, "<this>");
    paramString = s.X("webcanvas_pkg_info_", paramString);
    AppMethodBeat.o(261300);
    return paramString;
  }
  
  private static String bhZ(String paramString)
  {
    AppMethodBeat.i(261311);
    s.u(paramString, "<this>");
    paramString = s.X("webcanvas_last_use_pkg_path_", paramString);
    AppMethodBeat.o(261311);
    return paramString;
  }
  
  private static String bia(String paramString)
  {
    AppMethodBeat.i(261316);
    s.u(paramString, "<this>");
    paramString = s.X("webcanvas_last_use_pkg_time_", paramString);
    AppMethodBeat.o(261316);
    return paramString;
  }
  
  public static String bib(String paramString)
  {
    AppMethodBeat.i(261347);
    s.u(paramString, "appId");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(261347);
      return null;
    }
    vn localvn = bic(paramString);
    if (localvn == null)
    {
      Log.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath pkgInfo is null");
      AppMethodBeat.o(261347);
      return null;
    }
    if (!com.tencent.mm.vfs.y.ZC(localvn.path))
    {
      String str = hK(paramString, 0);
      if (com.tencent.mm.vfs.y.ZC(str))
      {
        j localj = j.WkY;
        j.xC(123L);
        Log.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath use wxa appId=" + paramString + ", md5=" + localvn.md5 + " download version= " + localvn.version + " path=" + str);
        AppMethodBeat.o(261347);
        return str;
      }
      Log.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath pkgInfo " + localvn.path + " not exist");
      AppMethodBeat.o(261347);
      return null;
    }
    Log.i("MicroMsg.WebCanvasStorageLogic", "geReleasePkgPath appId=" + paramString + ", md5=" + localvn.md5 + " download version= " + localvn.version + " path=" + localvn.path);
    atj().encode(bhZ(paramString), com.tencent.mm.vfs.ah.v(new com.tencent.mm.vfs.u(localvn.path).jKT()));
    atj().encode(bia(paramString), System.currentTimeMillis());
    paramString = localvn.path;
    AppMethodBeat.o(261347);
    return paramString;
  }
  
  public static vn bic(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(261361);
    s.u(paramString, "appId");
    Object localObject = atj();
    s.s(localObject, "mmkv");
    paramString = bhY(paramString);
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
        localObject = vn.class.newInstance();
        ((com.tencent.mm.bx.a)localObject).parseFrom(paramString);
        paramString = (com.tencent.mm.bx.a)localObject;
        paramString = (vn)paramString;
        AppMethodBeat.o(261361);
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
  
  public static int bid(String paramString)
  {
    AppMethodBeat.i(261363);
    s.u(paramString, "appId");
    paramString = bic(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(261363);
      return 0;
    }
    int i = paramString.version;
    AppMethodBeat.o(261363);
    return i;
  }
  
  private static final void c(String paramString1, bh parambh, String paramString2)
  {
    AppMethodBeat.i(261445);
    s.u(paramString1, "$appId");
    s.u(parambh, "record");
    s.u(paramString2, "filePath");
    Log.i("MicroMsg.WebCanvasStorageLogic", "checkPreviewVersion(appId:" + paramString1 + "), onSuccess(path:" + paramString2 + ')');
    AppMethodBeat.o(261445);
  }
  
  public static Object d(final com.tencent.mm.plugin.az.a parama, String paramString, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(261374);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.au(paramd));
    final kotlin.d.d locald = (kotlin.d.d)localh;
    WkZ.v(paramString, ((Number)Wli.getValue()).longValue(), 10);
    if (com.tencent.mm.vfs.y.ZC(bib(paramString)))
    {
      localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
      localObject3 = parama.WmS;
      i = parama.mUU;
      localObject1 = parama.WmT.aamu;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      ((com.tencent.mm.plugin.report.service.h)localObject2).b(21074, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(1), "", paramString, Integer.valueOf(1), Integer.valueOf(parama.mUU) });
      parama = Boolean.TRUE;
      paramString = Result.Companion;
      locald.resumeWith(Result.constructor-impl(parama));
      parama = localh.kli();
      if (parama == kotlin.d.a.a.aiwj) {
        s.u(paramd, "frame");
      }
      AppMethodBeat.o(261374);
      return parama;
    }
    Log.i("MicroMsg.WebCanvasStorageLogic", s.X("fetchBizPrefetchPkg pkg not exist, wait for download complete. appId=", paramString));
    Object localObject3 = com.tencent.mm.plugin.report.service.h.OAn;
    ccy localccy = parama.WmS;
    int i = parama.mUU;
    Object localObject2 = parama.WmT.aamu;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((com.tencent.mm.plugin.report.service.h)localObject3).b(21074, new Object[] { localccy, Integer.valueOf(i), Integer.valueOf(1), "", localObject1, Integer.valueOf(3), Integer.valueOf(parama.mUU) });
    localObject1 = (w)com.tencent.mm.kernel.h.ax(w.class);
    if (hBF() == 1) {}
    for (i = 2;; i = 0)
    {
      ((w)localObject1).a(paramString, i, (w.b)new d(paramString, parama, locald), (w.a)new e(paramString, locald));
      break;
    }
  }
  
  private static final void h(String paramString, com.tencent.mm.vfs.u paramu)
  {
    AppMethodBeat.i(261465);
    synchronized ((Iterable)Wlc)
    {
      Iterator localIterator = ???.iterator();
      if (localIterator.hasNext()) {
        ((a)localIterator.next()).d(paramString, paramu);
      }
    }
    paramString = kotlin.ah.aiuX;
    AppMethodBeat.o(261465);
  }
  
  public static int hBF()
  {
    AppMethodBeat.i(261328);
    int i = ((Number)SKh.getValue()).intValue();
    AppMethodBeat.o(261328);
    return i;
  }
  
  private static long hBH()
  {
    AppMethodBeat.i(261343);
    long l = ((Number)SKj.getValue()).longValue();
    AppMethodBeat.o(261343);
    return l;
  }
  
  private final LinkedList<String> hBI()
  {
    int j = 1;
    label188:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(261395);
        Object localObject1 = atj();
        s.s(localObject1, "mmkv");
        if (((MultiProcessMMKV)localObject1).containsKey("KPrefetcherBizAppIds"))
        {
          localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes("KPrefetcherBizAppIds");
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
                break label188;
              }
            }
            try
            {
              Object localObject4 = egn.class.newInstance();
              ((com.tencent.mm.bx.a)localObject4).parseFrom((byte[])localObject1);
              localObject1 = (com.tencent.mm.bx.a)localObject4;
              localObject1 = (egn)localObject1;
              if (localObject1 != null) {
                continue;
              }
              localObject1 = null;
              localObject4 = localObject1;
              if (localObject1 == null) {
                localObject4 = new LinkedList();
              }
              Log.d("MicroMsg.WebCanvasStorageLogic", s.X("getBizAppIds size ", Integer.valueOf(((LinkedList)localObject4).size())));
              AppMethodBeat.o(261395);
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
      AppMethodBeat.i(261399);
      try
      {
        MultiProcessMMKV localMultiProcessMMKV = atj();
        egn localegn = new egn();
        localegn.abiK = ioL();
        kotlin.ah localah = kotlin.ah.aiuX;
        localMultiProcessMMKV.encode("KPrefetcherBizAppIds", localegn.toByteArray());
        AppMethodBeat.o(261399);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.WebCanvasStorageLogic", s.X("saveBizAppIds ex ", localException.getMessage()));
          AppMethodBeat.o(261399);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void hBK()
  {
    AppMethodBeat.i(261359);
    Wlk.alive();
    AppMethodBeat.o(261359);
  }
  
  private static boolean hBN()
  {
    AppMethodBeat.i(261336);
    boolean bool = ((Boolean)SKA.getValue()).booleanValue();
    AppMethodBeat.o(261336);
    return bool;
  }
  
  public static String hK(String paramString, int paramInt)
  {
    AppMethodBeat.i(261351);
    s.u(paramString, "appId");
    try
    {
      bh localbh = ((x)com.tencent.mm.kernel.h.ax(x.class)).L(paramString, paramInt, 0);
      StringBuilder localStringBuilder = new StringBuilder("getPreviewPkgPath appId=").append(paramString).append(", pkgType=").append(paramInt).append(", md5=");
      if (localbh == null)
      {
        paramString = null;
        localStringBuilder = localStringBuilder.append(paramString).append(" download version= ");
        if (localbh != null) {
          break label138;
        }
        paramString = null;
        label86:
        localStringBuilder = localStringBuilder.append(paramString).append(" path=");
        if (localbh != null) {
          break label149;
        }
      }
      label138:
      label149:
      for (paramString = null;; paramString = localbh.field_pkgPath)
      {
        Log.i("MicroMsg.WebCanvasStorageLogic", paramString);
        if (localbh != null) {
          break label157;
        }
        AppMethodBeat.o(261351);
        return null;
        paramString = localbh.field_versionMd5;
        break;
        paramString = Integer.valueOf(localbh.field_version);
        break label86;
      }
      label157:
      paramString = localbh.field_pkgPath;
      AppMethodBeat.o(261351);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.WebCanvasStorageLogic", s.X("getPreviewPkgPath ex ", paramString.getMessage()));
      AppMethodBeat.o(261351);
    }
    return null;
  }
  
  public static String ioK()
  {
    AppMethodBeat.i(261275);
    String str = s.X(com.tencent.mm.kernel.h.baE().mCJ, "webcanvascache/");
    if (!com.tencent.mm.vfs.y.ZC(str)) {
      com.tencent.mm.vfs.y.bDX(str);
    }
    AppMethodBeat.o(261275);
    return str;
  }
  
  public static LinkedList<String> ioL()
  {
    AppMethodBeat.i(261291);
    LinkedList localLinkedList = (LinkedList)Wld.getValue();
    AppMethodBeat.o(261291);
    return localLinkedList;
  }
  
  private static boolean ioM()
  {
    AppMethodBeat.i(261333);
    boolean bool = ((Boolean)Wle.getValue()).booleanValue();
    AppMethodBeat.o(261333);
    return bool;
  }
  
  private static List<String> ioN()
  {
    AppMethodBeat.i(261339);
    List localList = (List)Wlf.getValue();
    AppMethodBeat.o(261339);
    return localList;
  }
  
  private static long ioO()
  {
    AppMethodBeat.i(261341);
    long l = ((Number)Wlh.getValue()).longValue();
    AppMethodBeat.o(261341);
    return l;
  }
  
  private static final void ioS()
  {
    AppMethodBeat.i(261458);
    long l = System.currentTimeMillis();
    Object localObject = p.al(new String[] { "wxf337cbaa27790d8e", "wxfedb0854e2b1820d", "wx97b7aebac2183fd2" });
    ((ArrayList)localObject).addAll((Collection)ioL());
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      Log.v("MicroMsg.WebCanvasStorageLogic", s.X("clearInvalidPkg appId: ", str));
      com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u(bhW(str));
      WkZ.a(localu, str, l);
      localu = new com.tencent.mm.vfs.u(bhX(str));
      WkZ.a(localu, str, l);
    }
    AppMethodBeat.o(261458);
  }
  
  private final void v(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(261376);
    bie(paramString);
    if (hBF() == 1)
    {
      bcW("wx97b7aebac2183fd2");
      bcW(paramString);
      AppMethodBeat.o(261376);
      return;
    }
    ioQ();
    w(paramString, paramLong, paramInt);
    AppMethodBeat.o(261376);
  }
  
  private static boolean w(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(261384);
    long l2 = atj().getLong(bcR(paramString), 0L);
    long l1 = System.currentTimeMillis();
    l2 = Math.abs(l1 - l2);
    if (((hBF() == 0) && (l2 < paramLong)) || ((hBF() != 0) && (l2 < 10000L)))
    {
      Log.d("MicroMsg.WebCanvasStorageLogic", s.X("triggerPreDownloadPrefetchPkg return ", Integer.valueOf(hBF())));
      AppMethodBeat.o(261384);
      return false;
    }
    Log.d("MicroMsg.WebCanvasStorageLogic", s.X("triggerPreDownloadPrefetchPkg ", paramString));
    atj().encode(bcR(paramString), l1);
    bL(paramString, paramInt);
    AppMethodBeat.o(261384);
    return true;
  }
  
  /* Error */
  public final void bie(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1124
    //   5: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc_w 597
    //   12: invokestatic 423	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: checkcast 1126	java/lang/CharSequence
    //   19: invokeinterface 1129 1 0
    //   24: ifle +62 -> 86
    //   27: iconst_1
    //   28: istore_2
    //   29: iload_2
    //   30: ifeq +47 -> 77
    //   33: invokestatic 578	com/tencent/mm/plugin/webcanvas/k:ioL	()Ljava/util/LinkedList;
    //   36: aload_1
    //   37: invokevirtual 583	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   40: ifne +37 -> 77
    //   43: invokestatic 578	com/tencent/mm/plugin/webcanvas/k:ioL	()Ljava/util/LinkedList;
    //   46: aload_1
    //   47: invokevirtual 1130	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   50: pop
    //   51: ldc_w 486
    //   54: invokestatic 492	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   57: checkcast 486	com/tencent/mm/plugin/appbrand/service/x
    //   60: astore_3
    //   61: aload_3
    //   62: ifnull +11 -> 73
    //   65: aload_3
    //   66: aload_1
    //   67: iconst_0
    //   68: invokeinterface 500 3 0
    //   73: aload_0
    //   74: invokespecial 1132	com/tencent/mm/plugin/webcanvas/k:hBJ	()V
    //   77: ldc_w 1124
    //   80: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: iconst_0
    //   87: istore_2
    //   88: goto -59 -> 29
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	k
    //   0	96	1	paramString	String
    //   28	60	2	i	int
    //   60	6	3	localx	x
    // Exception table:
    //   from	to	target	type
    //   2	27	91	finally
    //   33	61	91	finally
    //   65	73	91	finally
    //   73	77	91	finally
    //   77	83	91	finally
  }
  
  public final void ioP()
  {
    AppMethodBeat.i(261526);
    if (System.currentTimeMillis() - vBG < hBH())
    {
      AppMethodBeat.o(261526);
      return;
    }
    vBG = System.currentTimeMillis();
    if (!ioM())
    {
      AppMethodBeat.o(261526);
      return;
    }
    j localj = j.WkY;
    j.xC(40L);
    bL("wxfedb0854e2b1820d", 6);
    bL("wxf337cbaa27790d8e", 6);
    a(this, "wxa06c02b5c00ff39b");
    if (hBF() == 1)
    {
      bcW("wxfedb0854e2b1820d");
      bcW("wxf337cbaa27790d8e");
    }
    AppMethodBeat.o(261526);
  }
  
  public final void ioQ()
  {
    AppMethodBeat.i(261532);
    if (b(this, "wx97b7aebac2183fd2"))
    {
      j localj = j.WkY;
      j.xC(54L);
    }
    AppMethodBeat.o(261532);
  }
  
  public final void ioR()
  {
    AppMethodBeat.i(261547);
    if (!ioM())
    {
      AppMethodBeat.o(261547);
      return;
    }
    long l1 = atj().getLong("webcanvas_last_download_pkg_by_get_data_time", 0L);
    long l2 = System.currentTimeMillis();
    if (Math.abs(l2 - l1) < ((Number)Wlg.getValue()).longValue())
    {
      AppMethodBeat.o(261547);
      return;
    }
    j localj = j.WkY;
    j.xC(45L);
    atj().encode("webcanvas_last_download_pkg_by_get_data_time", l2);
    ioP();
    AppMethodBeat.o(261547);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$PkgClearListener;", "", "onPkgClear", "", "appId", "", "pkgFile", "Lcom/tencent/mm/vfs/VFSFile;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void d(String paramString, com.tencent.mm.vfs.u paramu);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$PkgDownloadReporter;", "", "()V", "readPkgVersionAndReport", "", "appId", "", "pkgPath", "downloadType", "", "reportPkgDownload", "wxaVersion", "pkgVersion", "downloadStatus", "DownloadStatus", "DownloadType", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final b Wll;
    
    static
    {
      AppMethodBeat.i(261235);
      Wll = new b();
      AppMethodBeat.o(261235);
    }
    
    public static void aF(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(261209);
      s.u(paramString1, "appId");
      s.u(paramString2, "pkgPath");
      com.tencent.threadpool.h.ahAA.bm(new k.b..ExternalSyntheticLambda0(paramString2, paramString1, paramInt));
      AppMethodBeat.o(261209);
    }
    
    private static final void aG(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(261230);
      s.u(paramString1, "$pkgPath");
      s.u(paramString2, "$appId");
      try
      {
        if (com.tencent.mm.vfs.y.ZC(paramString1))
        {
          paramString1 = new WxaPkg(paramString1);
          ((q)paramString1).cfK();
          e(paramString2, 0, com.tencent.mm.plugin.webview.l.a.h((q)paramString1), 0, paramInt);
          AppMethodBeat.o(261230);
          return;
        }
        e(paramString2, 0, 0, 3, paramInt);
        AppMethodBeat.o(261230);
        return;
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.WebCanvasStorageLogic", (Throwable)paramString1, "readPkgVersionAndReport exception", new Object[0]);
        AppMethodBeat.o(261230);
      }
    }
    
    public static void e(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(261191);
      s.u(paramString, "appId");
      com.tencent.mm.plugin.report.service.h.OAn.b(20780, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(261191);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<List<? extends String>>
  {
    public static final c Wlm;
    
    static
    {
      AppMethodBeat.i(261183);
      Wlm = new c();
      AppMethodBeat.o(261183);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "filePath", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    implements w.b
  {
    d(String paramString, com.tencent.mm.plugin.az.a parama, kotlin.d.d<? super Boolean> paramd) {}
    
    public final void onSuccess(bh parambh, String paramString)
    {
      AppMethodBeat.i(261185);
      s.u(parambh, "record");
      s.u(paramString, "filePath");
      Log.i("MicroMsg.WebCanvasStorageLogic", "fetchBizPrefetchPkg(appId:" + this.eug + "), onSuccess(path:" + paramString + ')');
      if (com.tencent.mm.vfs.y.ZC(paramString))
      {
        Log.i("MicroMsg.WebCanvasStorageLogic", s.X("fetchBizPrefetchPkg download success. appId=", this.eug));
        localObject = com.tencent.mm.plugin.report.service.h.OAn;
        ccy localccy = parama.WmS;
        int i = parama.mUU;
        paramString = parama.WmT.aamu;
        parambh = paramString;
        if (paramString == null) {
          parambh = "";
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).b(21074, new Object[] { localccy, Integer.valueOf(i), Integer.valueOf(1), "", parambh, Integer.valueOf(1), Integer.valueOf(parama.mUU) });
        parambh = locald;
        paramString = Boolean.TRUE;
        localObject = Result.Companion;
        parambh.resumeWith(Result.constructor-impl(paramString));
        AppMethodBeat.o(261185);
        return;
      }
      parambh = locald;
      paramString = Boolean.FALSE;
      Object localObject = Result.Companion;
      parambh.resumeWith(Result.constructor-impl(paramString));
      AppMethodBeat.o(261185);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errCode", "", "errMsg", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    implements w.a
  {
    e(String paramString, kotlin.d.d<? super Boolean> paramd) {}
    
    public final void onError(int paramInt, String paramString)
    {
      AppMethodBeat.i(261152);
      Log.e("MicroMsg.WebCanvasStorageLogic", "triggerPreDownload(appId:" + this.eug + "), onError(errCode:" + paramInt + ", errMsg:" + paramString + ')');
      paramString = locald;
      Boolean localBoolean = Boolean.FALSE;
      Result.Companion localCompanion = Result.Companion;
      paramString.resumeWith(Result.constructor-impl(localBoolean));
      AppMethodBeat.o(261152);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final f Wln;
    
    static
    {
      AppMethodBeat.i(261165);
      Wln = new f();
      AppMethodBeat.o(261165);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    public static final g Wlo;
    
    static
    {
      AppMethodBeat.i(261167);
      Wlo = new g();
      AppMethodBeat.o(261167);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<LinkedList<String>>
  {
    public static final h Wlp;
    
    static
    {
      AppMethodBeat.i(261171);
      Wlp = new h();
      AppMethodBeat.o(261171);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    public static final i Wlq;
    
    static
    {
      AppMethodBeat.i(261201);
      Wlq = new i();
      AppMethodBeat.o(261201);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Long>
  {
    public static final j Wlr;
    
    static
    {
      AppMethodBeat.i(261202);
      Wlr = new j();
      AppMethodBeat.o(261202);
    }
    
    j()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Long>
  {
    public static final k Wls;
    
    static
    {
      AppMethodBeat.i(261206);
      Wls = new k();
      AppMethodBeat.o(261206);
    }
    
    k()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Long>
  {
    public static final l Wlt;
    
    static
    {
      AppMethodBeat.i(261207);
      Wlt = new l();
      AppMethodBeat.o(261207);
    }
    
    l()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    public static final m Wlu;
    
    static
    {
      AppMethodBeat.i(261203);
      Wlu = new m();
      AppMethodBeat.o(261203);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Long>
  {
    public static final n Wlv;
    
    static
    {
      AppMethodBeat.i(261198);
      Wlv = new n();
      AppMethodBeat.o(261198);
    }
    
    n()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.k
 * JD-Core Version:    0.7.0.1
 */