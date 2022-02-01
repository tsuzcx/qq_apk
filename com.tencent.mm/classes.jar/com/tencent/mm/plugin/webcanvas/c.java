package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.ab.o;
import com.tencent.mm.plugin.ac.b.a;
import com.tencent.mm.plugin.ac.b.c;
import com.tencent.mm.plugin.ac.f.f;
import com.tencent.mm.plugin.ac.f.i;
import com.tencent.mm.plugin.webview.d.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "()V", "TAG", "", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizAppId", "getBizAppId", "()Ljava/lang/String;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getBizPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "bizPkg$delegate", "Lkotlin/Lazy;", "bizPkgVersion", "getBizPkgVersion", "canvasContexts", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "engine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "getEngine", "()Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "engine$delegate", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "initStartTime", "", "lastRenderAction", "performanceReporter", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "getPerformanceReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "popupId", "getPopupId", "setPopupId", "(Ljava/lang/String;)V", "renderJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "getRenderJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "wxaPkg", "getWxaPkg", "wxaPkg$delegate", "attach", "", "canvasId", "clear", "create", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "type", "data", "context", "Landroid/content/Context;", "detach", "emit", "event", "cb", "Landroid/webkit/ValueCallback;", "getClientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "getVideoPos", "", "initEnv", "onConfigClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "onConfigClientInject", "name", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "contextReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "Lkotlin/Function1;", "onTransferMessage", "message", "targetOrigin", "pause", "reflow", "start", "resume", "stop", "touch", "Landroid/view/MotionEvent;", "touch$webview_sdk_release", "update", "Companion", "webview-sdk_release"})
public abstract class c
  extends com.tencent.mm.plugin.ac.c
  implements com.tencent.mm.plugin.ab.k
{
  public static final c.a IzL = new c.a((byte)0);
  private static final kotlin.f Izi = kotlin.g.ah((kotlin.g.a.a)c.b.IzM);
  private final kotlin.f IzD = kotlin.g.ah((kotlin.g.a.a)new e(this));
  private final com.tencent.mm.plugin.ac.g IzE = new com.tencent.mm.plugin.ac.g();
  public final HashMap<String, Integer> IzF = new HashMap();
  protected final com.tencent.mm.plugin.ac.b IzG;
  private final kotlin.f IzH;
  private final kotlin.f IzI;
  private String IzJ;
  private String IzK;
  public final String TAG = "MicroMsg.WebCanvasJsEngine";
  private final long hpW;
  
  public c()
  {
    long l = MMSlotKt.now();
    Log.d(this.TAG, "performance: initStartTime");
    this.hpW = l;
    this.IzG = new com.tencent.mm.plugin.ac.b(this.hpW);
    this.IzH = kotlin.g.ah((kotlin.g.a.a)new j(this));
    this.IzI = kotlin.g.ah((kotlin.g.a.a)new c(this));
    cnc();
    this.IzJ = "none";
    this.IzK = "";
  }
  
  /* Error */
  public final a a(final String paramString1, final String paramString2, final String paramString3, final Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc_w 290
    //   6: invokestatic 262	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_2
    //   10: ldc_w 263
    //   13: invokestatic 262	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: aload_3
    //   17: ldc_w 291
    //   20: invokestatic 262	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload 4
    //   25: ldc_w 292
    //   28: invokestatic 262	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 191	com/tencent/mm/plugin/webcanvas/c:IzF	Ljava/util/HashMap;
    //   35: aload_2
    //   36: invokevirtual 296	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   39: ifeq +18 -> 57
    //   42: aload_0
    //   43: invokevirtual 300	com/tencent/mm/plugin/webcanvas/c:cnb	()Lcom/tencent/mm/plugin/webcanvas/k;
    //   46: aload 4
    //   48: aload_2
    //   49: invokestatic 305	com/tencent/mm/plugin/webcanvas/k:a	(Lcom/tencent/mm/plugin/webcanvas/k;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mm/plugin/webcanvas/a;
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: invokestatic 197	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   60: lstore 5
    //   62: aload_0
    //   63: getfield 176	com/tencent/mm/plugin/webcanvas/c:TAG	Ljava/lang/String;
    //   66: ldc_w 307
    //   69: aload_2
    //   70: invokestatic 313	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   73: invokevirtual 317	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   76: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: getfield 191	com/tencent/mm/plugin/webcanvas/c:IzF	Ljava/util/HashMap;
    //   83: checkcast 322	java/util/Map
    //   86: astore 9
    //   88: aload_0
    //   89: invokevirtual 326	com/tencent/mm/plugin/webcanvas/c:bME	()Lcom/tencent/mm/plugin/appbrand/m/g;
    //   92: astore 10
    //   94: aload 10
    //   96: ldc_w 328
    //   99: invokestatic 246	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   102: aload_0
    //   103: aload 4
    //   105: aload_2
    //   106: aload_3
    //   107: aload 10
    //   109: checkcast 330	com/tencent/mm/plugin/appbrand/m/i
    //   112: invokevirtual 333	com/tencent/mm/plugin/webcanvas/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/m/i;)V
    //   115: aload_0
    //   116: aload 10
    //   118: ldc_w 335
    //   121: aload_2
    //   122: invokestatic 313	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokevirtual 317	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   128: aload_1
    //   129: new 16	com/tencent/mm/plugin/webcanvas/c$d
    //   132: dup
    //   133: aload_0
    //   134: aload 4
    //   136: aload_2
    //   137: aload_3
    //   138: aload_1
    //   139: invokespecial 338	com/tencent/mm/plugin/webcanvas/c$d:<init>	(Lcom/tencent/mm/plugin/webcanvas/c;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   142: checkcast 340	kotlin/g/a/b
    //   145: aconst_null
    //   146: bipush 16
    //   148: invokestatic 343	com/tencent/mm/plugin/ac/c:a	(Lcom/tencent/mm/plugin/ac/c;Lcom/tencent/mm/plugin/appbrand/m/g;Ljava/lang/String;Ljava/lang/String;Lkotlin/g/a/b;Lcom/tencent/mm/plugin/ac/c$a;I)V
    //   151: aload_0
    //   152: getfield 214	com/tencent/mm/plugin/webcanvas/c:IzG	Lcom/tencent/mm/plugin/ac/b;
    //   155: astore_1
    //   156: aload_2
    //   157: ldc_w 345
    //   160: invokestatic 262	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   163: aload_1
    //   164: getfield 349	com/tencent/mm/plugin/ac/b:IBD	Ljava/util/concurrent/ConcurrentHashMap;
    //   167: aload_2
    //   168: invokevirtual 355	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   171: checkcast 357	com/tencent/mm/plugin/ac/b$c
    //   174: astore_3
    //   175: aload_3
    //   176: ifnull +74 -> 250
    //   179: invokestatic 362	java/lang/System:currentTimeMillis	()J
    //   182: aload_3
    //   183: getfield 365	com/tencent/mm/plugin/ac/b$c:createTime	J
    //   186: lsub
    //   187: lstore 7
    //   189: aload_1
    //   190: ldc2_w 366
    //   193: lconst_1
    //   194: invokevirtual 371	com/tencent/mm/plugin/ac/b:Q	(JJ)V
    //   197: aload_1
    //   198: ldc2_w 372
    //   201: lload 7
    //   203: invokevirtual 371	com/tencent/mm/plugin/ac/b:Q	(JJ)V
    //   206: aload_3
    //   207: lload 7
    //   209: l2i
    //   210: putfield 377	com/tencent/mm/plugin/ac/b$c:IBN	I
    //   213: ldc_w 379
    //   216: new 265	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 381
    //   223: invokespecial 269	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: lload 7
    //   228: invokevirtual 384	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   231: ldc_w 386
    //   234: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_3
    //   238: getfield 390	com/tencent/mm/plugin/ac/b$c:IBB	Z
    //   241: invokevirtual 393	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   244: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 9
    //   252: aload_2
    //   253: aload 10
    //   255: invokeinterface 398 1 0
    //   260: invokestatic 403	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   263: invokeinterface 407 3 0
    //   268: pop
    //   269: aload_0
    //   270: getfield 214	com/tencent/mm/plugin/webcanvas/c:IzG	Lcom/tencent/mm/plugin/ac/b;
    //   273: astore_1
    //   274: aload_2
    //   275: ldc_w 345
    //   278: invokestatic 262	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   281: aload_1
    //   282: lload 5
    //   284: putfield 410	com/tencent/mm/plugin/ac/b:IBF	J
    //   287: aload_1
    //   288: getfield 349	com/tencent/mm/plugin/ac/b:IBD	Ljava/util/concurrent/ConcurrentHashMap;
    //   291: checkcast 322	java/util/Map
    //   294: aload_2
    //   295: new 357	com/tencent/mm/plugin/ac/b$c
    //   298: dup
    //   299: aload_1
    //   300: getfield 410	com/tencent/mm/plugin/ac/b:IBF	J
    //   303: aload_1
    //   304: getfield 411	com/tencent/mm/plugin/ac/b:IBB	Z
    //   307: invokespecial 414	com/tencent/mm/plugin/ac/b$c:<init>	(JZ)V
    //   310: invokeinterface 407 3 0
    //   315: pop
    //   316: aload_0
    //   317: invokevirtual 300	com/tencent/mm/plugin/webcanvas/c:cnb	()Lcom/tencent/mm/plugin/webcanvas/k;
    //   320: aload 4
    //   322: aload_2
    //   323: invokestatic 305	com/tencent/mm/plugin/webcanvas/k:a	(Lcom/tencent/mm/plugin/webcanvas/k;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mm/plugin/webcanvas/a;
    //   326: astore_1
    //   327: goto -274 -> 53
    //   330: astore_1
    //   331: aload_0
    //   332: monitorexit
    //   333: aload_1
    //   334: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	c
    //   0	335	1	paramString1	String
    //   0	335	2	paramString2	String
    //   0	335	3	paramString3	String
    //   0	335	4	paramContext	Context
    //   60	223	5	l1	long
    //   187	40	7	l2	long
    //   86	165	9	localMap	Map
    //   92	162	10	localg	com.tencent.mm.plugin.appbrand.m.g
    // Exception table:
    //   from	to	target	type
    //   2	53	330	finally
    //   57	175	330	finally
    //   179	250	330	finally
    //   250	327	330	finally
  }
  
  protected void a(Context paramContext, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.m.i parami)
  {
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramString1, "canvasId");
    kotlin.g.b.p.h(paramString2, "data");
    kotlin.g.b.p.h(parami, "jsRuntime");
    new com.tencent.mm.plugin.ab.j((com.tencent.mm.plugin.ab.k)this).f(parami);
    paramContext = k.a(cnb(), paramContext, paramString1);
    new com.tencent.mm.plugin.ab.f((com.tencent.mm.plugin.ab.g)paramContext).f(parami);
    new com.tencent.mm.plugin.ab.n((o)new i((j)paramContext, this, cnb())).f(parami);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.m.g paramg, com.tencent.mm.plugin.ac.f paramf, kotlin.g.a.b<? super String, x> paramb)
  {
    kotlin.g.b.p.h(paramString1, "name");
    kotlin.g.b.p.h(paramString2, "type");
    kotlin.g.b.p.h(paramg, "context");
    kotlin.g.b.p.h(paramf, "contextReporter");
    for (;;)
    {
      try
      {
        String str1 = com.tencent.mm.plugin.ac.c.b.b(fWA()).FJ("client").FJ(paramString2).getString("path");
        paramString2 = fWA();
        kotlin.g.b.p.g(str1, "path");
        String str2 = com.tencent.mm.plugin.ac.c.b.a(paramString2, str1);
        if (BuildInfo.DEBUG)
        {
          if (paramb == null) {
            break label299;
          }
          paramString2 = new e(paramb);
          paramg.evaluateJavascript(str2, (ValueCallback)paramString2);
          Log.d(this.TAG, "biz loaded:" + str1 + " to " + paramString1);
          return;
        }
        URL localURL = new URL("https://ws/usr/" + bje() + str1);
        String str3 = lB(bje(), str1);
        int i = com.tencent.mm.plugin.ac.c.b.a(fWA());
        if (paramb != null)
        {
          paramString2 = new e(paramb);
          paramg.a(localURL, str3, String.valueOf(i), 0, str2, (ValueCallback)paramString2);
          continue;
        }
        paramString2 = paramb;
      }
      catch (Exception paramString2)
      {
        paramf.a((f.i)new f.f());
        paramg = l.IAx;
        l.ba(bje(), paramString1, paramString2.getMessage());
        Log.printErrStackTrace(this.TAG, (Throwable)paramString2, "read client context script", new Object[0]);
        throw ((Throwable)paramString2);
      }
      continue;
      label299:
      paramString2 = paramb;
    }
  }
  
  public final float[] aWv(String paramString)
  {
    kotlin.g.b.p.h(paramString, "canvasId");
    paramString = cnb().aWC(paramString);
    if (paramString != null) {
      return paramString.IyY;
    }
    return null;
  }
  
  public final void aWw(String paramString)
  {
    kotlin.g.b.p.h(paramString, "<set-?>");
    this.IzJ = paramString;
  }
  
  public final com.tencent.mm.plugin.ac.c.a aWx(String paramString)
  {
    kotlin.g.b.p.h(paramString, "type");
    String str = bje();
    paramString = com.tencent.mm.plugin.ac.c.b.b(fWA()).FK("client").FK(paramString);
    if (paramString != null) {}
    for (long l = paramString.optLong("idKey");; l = 0L) {
      return new com.tencent.mm.plugin.ac.c.a(str, l);
    }
  }
  
  public abstract String bje();
  
  public final void bw(String paramString, long paramLong)
  {
    kotlin.g.b.p.h(paramString, "canvasId");
    Log.i(this.TAG, "reflow #".concat(String.valueOf(paramString)));
    a locala = cnb().aWC(paramString);
    if (locala != null) {
      locala.fWm();
    }
    com.tencent.mm.plugin.ab.c.a.a(this, "reflow", "{target:'" + paramString + "', start:" + paramLong + '}', null, 4);
  }
  
  public final void clear()
  {
    cna().eQ(MMApplicationContext.getContext());
    k localk = cnb();
    Iterator localIterator = ((Iterable)localk.IAp).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Log.i(localk.TAG, "canvasContext#" + (String)localObject1 + " should be destroyed");
      a locala = (a)localk.IAn.get(localObject1);
      if (locala != null)
      {
        n localn = locala.IyU;
        if (localn != null)
        {
          locala.fWk().xY(localn.IAR);
          locala.fWk().b("destroy", "{target:'" + locala.lAN + "'}", (ValueCallback)new a.i(localn));
          Object localObject2 = localn.MQ().getParent();
          localObject1 = localObject2;
          if (!(localObject2 instanceof ViewGroup)) {
            localObject1 = null;
          }
          localObject1 = (ViewGroup)localObject1;
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localn.MQ());
          }
          localObject2 = localn.MQ().getContext();
          localObject1 = localObject2;
          if (!(localObject2 instanceof MutableContextWrapper)) {
            localObject1 = null;
          }
          localObject1 = (MutableContextWrapper)localObject1;
          if (localObject1 != null) {
            ((MutableContextWrapper)localObject1).setBaseContext(MMApplicationContext.getContext());
          }
          Log.i(a.TAG, "canvas#" + locala.lAN + ':' + localn.IAR + '@' + localn.MQ().getVirtualElementId() + " has been destroyed");
        }
        locala.IyU = null;
      }
    }
    localk.IAp.clear();
  }
  
  protected abstract k cnb();
  
  protected void cnc()
  {
    Log.i(this.TAG, "init");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
    {
      localObject = new com.tencent.magicbrush.f();
      ((com.tencent.magicbrush.g)localObject).context = MMApplicationContext.getContext();
      ((com.tencent.magicbrush.g)localObject).cLK = ((kotlin.g.a.a)new c.f(this));
      ((com.tencent.magicbrush.g)localObject).cLJ = ((com.tencent.magicbrush.handler.a)new c.g(this));
      ((com.tencent.magicbrush.f)localObject).Rm();
    }
    Object localObject = new com.tencent.mm.plugin.ab.i((com.tencent.mm.plugin.ab.c)this);
    com.tencent.mm.plugin.appbrand.m.g localg = bMD();
    kotlin.g.b.p.g(localg, "mainJsContext");
    ((com.tencent.mm.plugin.ab.i)localObject).f((com.tencent.mm.plugin.appbrand.m.i)localg);
    this.IzG.fXb();
    P((kotlin.g.a.b)new c.h(this));
    this.IzG.fXc();
    new i(this).alive();
  }
  
  protected final com.tencent.mm.plugin.appbrand.appcache.p fWA()
  {
    return (com.tencent.mm.plugin.appbrand.appcache.p)this.IzI.getValue();
  }
  
  public final com.tencent.mm.plugin.ac.g fWy()
  {
    return this.IzE;
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.p fWz()
  {
    return (com.tencent.mm.plugin.appbrand.appcache.p)this.IzH.getValue();
  }
  
  public final int getBasePkgVersion()
  {
    return fWz().version();
  }
  
  public final int getBizPkgVersion()
  {
    return fWA().version();
  }
  
  public final void hc(String paramString)
  {
    boolean bool2 = false;
    kotlin.g.b.p.h(paramString, "canvasId");
    long l = MMSlotKt.now();
    Log.i(this.TAG, "resume #" + paramString + ", " + l);
    Object localObject1 = this.IzG;
    int i = paramString.hashCode();
    kotlin.g.b.p.h(paramString, "canvasId");
    Object localObject2;
    b.a locala;
    b.c localc;
    if (!((com.tencent.mm.plugin.ac.b)localObject1).IBE.containsKey(Integer.valueOf(i)))
    {
      localObject2 = (Map)((com.tencent.mm.plugin.ac.b)localObject1).IBE;
      locala = new b.a(System.currentTimeMillis(), i, paramString);
      localc = (b.c)((com.tencent.mm.plugin.ac.b)localObject1).IBD.get(paramString);
      if (localc == null) {
        break label306;
      }
    }
    label306:
    for (boolean bool1 = localc.IBM;; bool1 = false)
    {
      locala.IBM = bool1;
      ((Map)localObject2).put(Integer.valueOf(i), locala);
      localObject2 = (b.a)((com.tencent.mm.plugin.ac.b)localObject1).IBE.get(Integer.valueOf(i));
      if (localObject2 != null)
      {
        if (((b.a)localObject2).IBL) {
          ((b.a)localObject2).createTime = System.currentTimeMillis();
        }
        localObject1 = (b.c)((com.tencent.mm.plugin.ac.b)localObject1).IBD.get(paramString);
        bool1 = bool2;
        if (localObject1 != null) {
          bool1 = ((b.c)localObject1).IBM;
        }
        ((b.a)localObject2).IBM = bool1;
      }
      a(this, "resume", paramString);
      cnb().fWC();
      cnb().a(l, paramString, null);
      cnb().aWA(paramString);
      if ((kotlin.g.b.p.j(this.IzK, "resume") ^ true))
      {
        this.IzK = "resume";
        cnb().a(l, this.IzJ, null);
        cnb().aWA(this.IzJ);
      }
      return;
    }
  }
  
  public final void hd(String paramString)
  {
    kotlin.g.b.p.h(paramString, "canvasId");
    Log.i(this.TAG, "pause #".concat(String.valueOf(paramString)));
    a(this, "pause", paramString);
    cnb().aWz(paramString);
    cnb();
    kotlin.g.b.p.h(paramString, "canvasId");
    if ((kotlin.g.b.p.j(this.IzK, "pause") ^ true))
    {
      this.IzK = "pause";
      cnb().aWz(this.IzJ);
      cnb();
      kotlin.g.b.p.h(this.IzJ, "canvasId");
    }
  }
  
  public final void ly(String paramString1, String paramString2)
  {
    kotlin.g.b.p.h(paramString1, "message");
    kotlin.g.b.p.h(paramString2, "targetOrigin");
    cnb().lC(paramString1, paramString2);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.appcache.p>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$create$1$1"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    d(c paramc, Context paramContext, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<m>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$initEnv$3", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "webview-sdk_release"})
  public static final class i
    extends o.a
  {
    public final void onAppBackground(String arg1)
    {
      AppMethodBeat.i(224638);
      kotlin.g.b.p.h(???, "activity");
      com.tencent.mm.plugin.ab.c.a.a(this.IzN, "background", null, (ValueCallback)new a(this), 2);
      synchronized (this.IzN.cnb())
      {
        if (!???.isPaused)
        {
          ???.isPaused = true;
          ???.fWE();
          ???.pause();
          Log.i(???.TAG, "renderJsEngine pause");
        }
        x localx = x.SXb;
        AppMethodBeat.o(224638);
        return;
      }
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(224637);
      kotlin.g.b.p.h(paramString, "activity");
      Log.i(c.a(this.IzN), "logicJsEngine and renderJsEngine resume");
      this.IzN.cnb().fWC();
      this.IzN.resume();
      com.tencent.mm.plugin.ab.c.a.a(this.IzN, "foreground", null, null, 6);
      AppMethodBeat.o(224637);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class a<T>
      implements ValueCallback<String>
    {
      a(c.i parami) {}
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.appcache.p>
  {
    j(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.c
 * JD-Core Version:    0.7.0.1
 */