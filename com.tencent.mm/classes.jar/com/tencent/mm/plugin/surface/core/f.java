package com.tencent.mm.plugin.surface.core;

import com.tencent.mapsdk.rastercore.tools.IO;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/PackageManager;", "Lcom/tencent/mm/plugin/surface/core/MultiWxaPkgSelector;", "()V", "basic", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getBasic", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "cache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "findWxaPkg", "appId", "path", "downLoadPath", "validResPkg", "Lkotlin/Function3;", "", "getWxaPkg", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends d
{
  public static final a SKp;
  private static final j<Boolean> SKr;
  private static final j<HashSet<String>> SKs;
  final com.tencent.mm.plugin.appbrand.appcache.q SKq;
  private final HashMap<String, com.tencent.mm.plugin.appbrand.appcache.q> cache;
  
  static
  {
    AppMethodBeat.i(265251);
    SKp = new a((byte)0);
    SKr = kotlin.k.cm((a)c.SKu);
    SKs = kotlin.k.cm((a)b.SKt);
    AppMethodBeat.o(265251);
  }
  
  public f()
  {
    AppMethodBeat.i(265208);
    this.cache = new HashMap();
    com.tencent.mm.plugin.appbrand.appcache.q localq = bcO("wx");
    s.checkNotNull(localq);
    this.SKq = localq;
    AppMethodBeat.o(265208);
  }
  
  private final com.tencent.mm.plugin.appbrand.appcache.q a(String paramString1, String paramString2, String paramString3, kotlin.g.a.q<? super com.tencent.mm.plugin.appbrand.appcache.q, ? super String, ? super String, Boolean> paramq)
  {
    AppMethodBeat.i(265232);
    Object localObject1 = (com.tencent.mm.plugin.appbrand.appcache.q)this.cache.get(paramString1);
    ah.f localf2;
    ah.f localf1;
    ah.a locala;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label914;
      }
      localObject1 = (f)this;
      localf2 = new ah.f();
      localf2.aqH = "";
      localf1 = new ah.f();
      localf1.aqH = "";
      locala = new ah.a();
      localObject2 = s.X(b.bmz(), paramString2);
      if ((!((Boolean)SKr.getValue()).booleanValue()) || (!y.ZC((String)localObject2))) {
        break label169;
      }
      Log.i("MicroMsg.SurfaceApp.PackageManager", s.X("#readPkg use sdcard ", localObject2));
      paramString2 = new WxaPkg((String)localObject2);
      paramString2.cfK();
      paramString2 = (com.tencent.mm.plugin.appbrand.appcache.q)paramString2;
    }
    for (;;)
    {
      if (paramString2 == null)
      {
        AppMethodBeat.o(265232);
        return null;
        Log.i("MicroMsg.SurfaceApp.PackageManager", s.X("#readPkg use cache appId=", paramString1));
        break;
        label169:
        localObject2 = s.X("jsapi/", paramString2);
        if (!((HashSet)SKs.getValue()).contains(localObject2)) {
          try
          {
            paramq = a(localf2, paramString1, paramq, localf1, locala, paramString3);
            if (paramq == null)
            {
              a.wi(6L);
              Log.e("MicroMsg.SurfaceApp.PackageManager", "pkg asset jsapi/" + paramString2 + " and downloadPath " + paramString2 + " not found");
              h.OAn.b(20781, new Object[] { paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), "", "" });
              break label922;
            }
            Log.i("MicroMsg.SurfaceApp.PackageManager", "#readPkg without assets appId=" + paramString1 + ", path=" + paramString2);
            h.OAn.b(20781, new Object[] { paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), "", localf2.aqH });
            paramq.cfK();
            AppMethodBeat.o(265232);
            return paramq;
          }
          catch (Exception paramString2)
          {
            a.wi(7L);
            Log.printErrStackTrace("MicroMsg.SurfaceApp.PackageManager", (Throwable)paramString2, "#readPkg " + paramString3 + " error: " + paramString1, new Object[0]);
            h.OAn.b(20781, new Object[] { paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), paramString2.getMessage(), "" });
          }
        }
        Log.i("MicroMsg.SurfaceApp.PackageManager", "#readPkg appId=" + paramString1 + ", path=" + paramString2);
        localObject2 = new com.tencent.mm.plugin.appbrand.appcache.f(MMApplicationContext.getContext(), s.X("jsapi/", paramString2));
        ((com.tencent.mm.plugin.appbrand.appcache.f)localObject2).cfK();
        try
        {
          if (a.bcX(paramString1))
          {
            paramString2 = a.c((com.tencent.mm.plugin.appbrand.appcache.q)localObject2);
            label577:
            localf1.aqH = paramString2;
            paramString2 = a(localf2, paramString1, paramq, localf1, locala, paramString3);
            if ((paramString2 == null) || (!locala.aiwY)) {
              break label863;
            }
            h.OAn.b(20781, new Object[] { paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), "", localf2.aqH });
          }
        }
        catch (Exception paramString2)
        {
          Log.printErrStackTrace("MicroMsg.SurfaceApp.PackageManager", (Throwable)paramString2, "#readPkg " + paramString3 + " error: " + paramString1, new Object[0]);
          a.wi(8L);
          h.OAn.b(20781, new Object[] { paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), paramString2.getMessage(), localf1.aqH });
        }
        label863:
        do
        {
          h.OAn.b(20781, new Object[] { paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), "", localf1.aqH });
          Log.i("MicroMsg.SurfaceApp.PackageManager", "#readPkg " + paramString1 + " use assert");
          paramString2 = (com.tencent.mm.plugin.appbrand.appcache.q)localObject2;
          break;
          paramString2 = a.e((com.tencent.mm.plugin.appbrand.appcache.q)localObject2);
          break label577;
        } while (paramString2 == null);
        if ((paramString2 instanceof Closeable)) {}
        for (paramString2 = (Closeable)paramString2;; paramString2 = null)
        {
          IO.safeClose(paramString2);
          break;
        }
      }
      ((Map)((f)localObject1).cache).put(paramString1, paramString2);
      AppMethodBeat.o(265232);
      return paramString2;
      label914:
      AppMethodBeat.o(265232);
      return localObject1;
      label922:
      paramString2 = null;
    }
  }
  
  private static final com.tencent.mm.plugin.appbrand.appcache.q a(ah.f<String> paramf1, String paramString1, kotlin.g.a.q<? super com.tencent.mm.plugin.appbrand.appcache.q, ? super String, ? super String, Boolean> paramq, ah.f<String> paramf2, ah.a parama, String paramString2)
  {
    AppMethodBeat.i(265243);
    if (y.ZC(paramString2))
    {
      paramString2 = new WxaPkg(paramString2);
      ((com.tencent.mm.plugin.appbrand.appcache.q)paramString2).cfK();
      com.tencent.mm.plugin.appbrand.appcache.q localq = (com.tencent.mm.plugin.appbrand.appcache.q)paramString2;
      if (a.bcX(paramString1)) {}
      for (paramString2 = a.c(localq);; paramString2 = a.e(localq))
      {
        paramf1.aqH = paramString2;
        if (!((Boolean)paramq.invoke(localq, paramf1.aqH, paramf2.aqH)).booleanValue()) {
          break;
        }
        parama.aiwY = true;
        Log.i("MicroMsg.SurfaceApp.PackageManager", "#readPkg " + paramString1 + " use res");
        AppMethodBeat.o(265243);
        return localq;
      }
      AppMethodBeat.o(265243);
      return localq;
    }
    AppMethodBeat.o(265243);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.q bcO(String paramString)
  {
    AppMethodBeat.i(265263);
    s.u(paramString, "appId");
    if (s.p(paramString, "wx"))
    {
      localObject = i.SKz;
      if (i.hBN()) {
        localObject = e.SKg;
      }
      for (localObject = e.bcS("wx4edd479d258d7f25");; localObject = null)
      {
        paramString = a(paramString, "surface/basic.wspkg", (String)localObject, (kotlin.g.a.q)new d(paramString));
        AppMethodBeat.o(265263);
        return paramString;
      }
    }
    Object localObject = "surface/app/" + paramString + ".wspkg";
    e locale = e.SKg;
    paramString = a(paramString, (String)localObject, e.bcS(paramString), (kotlin.g.a.q)new e(paramString, this));
    AppMethodBeat.o(265263);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/PackageManager$Companion;", "", "()V", "TAG", "", "assets", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getAssets", "()Ljava/util/HashSet;", "assets$delegate", "Lkotlin/Lazy;", "debuggable", "", "getDebuggable", "()Z", "debuggable$delegate", "libAppId", "appConfig", "Lcom/tencent/mm/json/JSONObject;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getAppConfig", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)Lcom/tencent/mm/json/JSONObject;", "bizVersion", "getBizVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)Ljava/lang/String;", "libVersion", "getLibVersion", "minAndroidClientVersion", "", "getMinAndroidClientVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "requiredMinLibVersion", "getRequiredMinLibVersion", "version", "getVersion", "compareVersion", "version1", "version2", "idKey1811", "", "value", "", "isLibAppId", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static com.tencent.mm.ad.i b(com.tencent.mm.plugin.appbrand.appcache.q paramq)
    {
      AppMethodBeat.i(265311);
      s.u(paramq, "<this>");
      paramq = new com.tencent.mm.ad.i(r.a(paramq, "/version.json"));
      AppMethodBeat.o(265311);
      return paramq;
    }
    
    public static boolean bcX(String paramString)
    {
      AppMethodBeat.i(265309);
      s.u(paramString, "<this>");
      boolean bool = s.p(paramString, "wx");
      AppMethodBeat.o(265309);
      return bool;
    }
    
    public static String c(com.tencent.mm.plugin.appbrand.appcache.q paramq)
    {
      AppMethodBeat.i(265318);
      s.u(paramq, "<this>");
      paramq = b(paramq);
      if (paramq == null)
      {
        AppMethodBeat.o(265318);
        return "";
      }
      paramq = paramq.optString("version", "");
      if (paramq == null)
      {
        AppMethodBeat.o(265318);
        return "";
      }
      AppMethodBeat.o(265318);
      return paramq;
    }
    
    public static int compareVersion(String paramString1, String paramString2)
    {
      AppMethodBeat.i(265336);
      Object localObject = (CharSequence)paramString1;
      if ((localObject == null) || (n.bp((CharSequence)localObject)))
      {
        i = 1;
        if (i == 0)
        {
          localObject = (CharSequence)paramString2;
          if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
            break label97;
          }
        }
      }
      label97:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label102;
        }
        Log.w("MicroMsg.SurfaceApp.PackageManager", "compareVersion error:illegal params, version1=" + paramString1 + ", version2=" + paramString2);
        AppMethodBeat.o(265336);
        return 0;
        i = 0;
        break;
      }
      label102:
      paramString1 = ((Collection)n.b((CharSequence)paramString1, new String[] { "\\." })).toArray(new String[0]);
      if (paramString1 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(265336);
        throw paramString1;
      }
      paramString1 = (String[])paramString1;
      paramString2 = ((Collection)n.b((CharSequence)paramString2, new String[] { "\\." })).toArray(new String[0]);
      if (paramString2 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(265336);
        throw paramString1;
      }
      paramString2 = (String[])paramString2;
      int m = kotlin.k.k.qv(paramString1.length, paramString2.length);
      i = 0;
      int j = 0;
      while (j < m)
      {
        int n = paramString1[j].length();
        int k = paramString2[j].length();
        localObject = ah.aiuX;
        i = k;
        if (n - k != 0) {
          break;
        }
        k = paramString1[j].compareTo(paramString2[j]);
        i = k;
        if (k != 0) {
          break;
        }
        j += 1;
        i = k;
      }
      if (i != 0)
      {
        AppMethodBeat.o(265336);
        return i;
      }
      i = paramString1.length;
      j = paramString2.length;
      AppMethodBeat.o(265336);
      return i - j;
    }
    
    public static com.tencent.mm.ad.i d(com.tencent.mm.plugin.appbrand.appcache.q paramq)
    {
      AppMethodBeat.i(265323);
      s.u(paramq, "<this>");
      paramq = new com.tencent.mm.ad.i(r.a(paramq, "/app-config.json"));
      AppMethodBeat.o(265323);
      return paramq;
    }
    
    public static String e(com.tencent.mm.plugin.appbrand.appcache.q paramq)
    {
      AppMethodBeat.i(265325);
      s.u(paramq, "<this>");
      paramq = d(paramq);
      if (paramq == null)
      {
        AppMethodBeat.o(265325);
        return "";
      }
      paramq = paramq.optString("version", "");
      if (paramq == null)
      {
        AppMethodBeat.o(265325);
        return "";
      }
      AppMethodBeat.o(265325);
      return paramq;
    }
    
    public static void wi(long paramLong)
    {
      AppMethodBeat.i(265339);
      h.OAn.p(1811L, paramLong, 1L);
      AppMethodBeat.o(265339);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<HashSet<String>>
  {
    public static final b SKt;
    
    static
    {
      AppMethodBeat.i(265292);
      SKt = new b();
      AppMethodBeat.o(265292);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Boolean>
  {
    public static final c SKu;
    
    static
    {
      AppMethodBeat.i(265290);
      SKu = new c();
      AppMethodBeat.o(265290);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "resVersion", "", "assetsVersion"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.q<com.tencent.mm.plugin.appbrand.appcache.q, String, String, Boolean>
  {
    d(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "resVersion", "", "assetsVersion"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.q<com.tencent.mm.plugin.appbrand.appcache.q, String, String, Boolean>
  {
    e(String paramString, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.core.f
 * JD-Core Version:    0.7.0.1
 */