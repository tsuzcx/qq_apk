package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.magicbrush.al;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.av.o;
import com.tencent.mm.plugin.aw.b.a;
import com.tencent.mm.plugin.aw.b.c;
import com.tencent.mm.plugin.aw.f.f;
import com.tencent.mm.plugin.aw.f.i;
import com.tencent.mm.plugin.webview.d.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "()V", "TAG", "", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizAppId", "getBizAppId", "()Ljava/lang/String;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getBizPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "bizPkg$delegate", "Lkotlin/Lazy;", "bizPkgVersion", "getBizPkgVersion", "canvasContexts", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "engine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "getEngine", "()Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "engine$delegate", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "initStartTime", "", "lastRenderAction", "performanceReporter", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "getPerformanceReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "popupId", "getPopupId", "setPopupId", "(Ljava/lang/String;)V", "renderJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "getRenderJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "wxaPkg", "getWxaPkg", "wxaPkg$delegate", "attach", "", "canvasId", "clear", "create", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "type", "data", "context", "Landroid/content/Context;", "detach", "emit", "event", "cb", "Landroid/webkit/ValueCallback;", "getClientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "getVideoPos", "", "initEnv", "onConfigClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "onConfigClientInject", "name", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "contextReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "Lkotlin/Function1;", "onTransferMessage", "message", "targetOrigin", "pause", "recycleContext", "reflow", "start", "resume", "stop", "touch", "Landroid/view/MotionEvent;", "touch$webview_sdk_release", "update", "Companion", "webview-sdk_release"})
public abstract class c
  extends com.tencent.mm.plugin.aw.c
  implements com.tencent.mm.plugin.av.k
{
  public static final a PtO = new a((byte)0);
  private static final kotlin.f Ptm = kotlin.g.ar((kotlin.g.a.a)b.PtP);
  private final kotlin.f PtH = kotlin.g.ar((kotlin.g.a.a)new e(this));
  public final HashMap<String, Integer> PtI = new HashMap();
  protected final com.tencent.mm.plugin.aw.b PtJ;
  private final kotlin.f PtK;
  private final kotlin.f PtL;
  private String PtM;
  private String PtN;
  public final String TAG = "MicroMsg.WebCanvasJsEngine";
  private final long kbR;
  private final com.tencent.mm.plugin.aw.g sPV = new com.tencent.mm.plugin.aw.g();
  
  public c()
  {
    long l = MMSlotKt.now();
    Log.d(this.TAG, "performance: initStartTime");
    this.kbR = l;
    this.PtJ = new com.tencent.mm.plugin.aw.b(this.kbR);
    this.PtK = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.PtL = kotlin.g.ar((kotlin.g.a.a)new c(this));
    cAL();
    this.PtM = "none";
    this.PtN = "";
  }
  
  /* Error */
  public final a a(final String paramString1, final String paramString2, final String paramString3, final Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc_w 299
    //   6: invokestatic 271	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_2
    //   10: ldc_w 272
    //   13: invokestatic 271	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: aload_3
    //   17: ldc_w 300
    //   20: invokestatic 271	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload 4
    //   25: ldc_w 301
    //   28: invokestatic 271	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 201	com/tencent/mm/plugin/webcanvas/c:PtI	Ljava/util/HashMap;
    //   35: aload_2
    //   36: invokevirtual 305	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   39: ifeq +18 -> 57
    //   42: aload_0
    //   43: invokevirtual 309	com/tencent/mm/plugin/webcanvas/c:cAK	()Lcom/tencent/mm/plugin/webcanvas/k;
    //   46: aload 4
    //   48: aload_2
    //   49: invokestatic 314	com/tencent/mm/plugin/webcanvas/k:a	(Lcom/tencent/mm/plugin/webcanvas/k;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mm/plugin/webcanvas/a;
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: invokestatic 207	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   60: lstore 5
    //   62: aload_0
    //   63: getfield 186	com/tencent/mm/plugin/webcanvas/c:TAG	Ljava/lang/String;
    //   66: ldc_w 316
    //   69: aload_2
    //   70: invokestatic 322	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   73: invokevirtual 326	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   76: invokestatic 329	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: getfield 201	com/tencent/mm/plugin/webcanvas/c:PtI	Ljava/util/HashMap;
    //   83: checkcast 331	java/util/Map
    //   86: astore 9
    //   88: aload_0
    //   89: invokevirtual 335	com/tencent/mm/plugin/webcanvas/c:bYV	()Lcom/tencent/mm/plugin/appbrand/m/g;
    //   92: astore 10
    //   94: aload 10
    //   96: ldc_w 337
    //   99: invokestatic 255	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   102: aload_0
    //   103: aload 4
    //   105: aload_2
    //   106: aload_3
    //   107: aload 10
    //   109: checkcast 339	com/tencent/mm/plugin/appbrand/m/i
    //   112: invokevirtual 342	com/tencent/mm/plugin/webcanvas/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/m/i;)V
    //   115: aload_0
    //   116: aload 10
    //   118: ldc_w 344
    //   121: aload_2
    //   122: invokestatic 322	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokevirtual 326	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   128: aload_1
    //   129: new 19	com/tencent/mm/plugin/webcanvas/c$d
    //   132: dup
    //   133: aload_0
    //   134: aload 4
    //   136: aload_2
    //   137: aload_3
    //   138: aload_1
    //   139: invokespecial 347	com/tencent/mm/plugin/webcanvas/c$d:<init>	(Lcom/tencent/mm/plugin/webcanvas/c;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   142: checkcast 349	kotlin/g/a/b
    //   145: aconst_null
    //   146: bipush 16
    //   148: invokestatic 352	com/tencent/mm/plugin/aw/c:a	(Lcom/tencent/mm/plugin/aw/c;Lcom/tencent/mm/plugin/appbrand/m/g;Ljava/lang/String;Ljava/lang/String;Lkotlin/g/a/b;Lcom/tencent/mm/plugin/aw/c$a;I)V
    //   151: aload_0
    //   152: getfield 224	com/tencent/mm/plugin/webcanvas/c:PtJ	Lcom/tencent/mm/plugin/aw/b;
    //   155: astore_1
    //   156: aload_2
    //   157: ldc_w 354
    //   160: invokestatic 271	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   163: aload_1
    //   164: getfield 358	com/tencent/mm/plugin/aw/b:PvQ	Ljava/util/concurrent/ConcurrentHashMap;
    //   167: aload_2
    //   168: invokevirtual 364	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   171: checkcast 366	com/tencent/mm/plugin/aw/b$c
    //   174: astore_3
    //   175: aload_3
    //   176: ifnull +74 -> 250
    //   179: invokestatic 371	java/lang/System:currentTimeMillis	()J
    //   182: aload_3
    //   183: getfield 374	com/tencent/mm/plugin/aw/b$c:createTime	J
    //   186: lsub
    //   187: lstore 7
    //   189: aload_1
    //   190: ldc2_w 375
    //   193: lconst_1
    //   194: invokevirtual 380	com/tencent/mm/plugin/aw/b:V	(JJ)V
    //   197: aload_1
    //   198: ldc2_w 381
    //   201: lload 7
    //   203: invokevirtual 380	com/tencent/mm/plugin/aw/b:V	(JJ)V
    //   206: aload_3
    //   207: lload 7
    //   209: l2i
    //   210: putfield 386	com/tencent/mm/plugin/aw/b$c:Pwa	I
    //   213: ldc_w 388
    //   216: new 274	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 390
    //   223: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: lload 7
    //   228: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   231: ldc_w 395
    //   234: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_3
    //   238: getfield 399	com/tencent/mm/plugin/aw/b$c:PvO	Z
    //   241: invokevirtual 402	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   244: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 329	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 9
    //   252: aload_2
    //   253: aload 10
    //   255: invokeinterface 407 1 0
    //   260: invokestatic 412	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   263: invokeinterface 416 3 0
    //   268: pop
    //   269: aload_0
    //   270: getfield 224	com/tencent/mm/plugin/webcanvas/c:PtJ	Lcom/tencent/mm/plugin/aw/b;
    //   273: astore_1
    //   274: aload_2
    //   275: ldc_w 354
    //   278: invokestatic 271	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   281: aload_1
    //   282: lload 5
    //   284: putfield 419	com/tencent/mm/plugin/aw/b:PvS	J
    //   287: aload_1
    //   288: getfield 358	com/tencent/mm/plugin/aw/b:PvQ	Ljava/util/concurrent/ConcurrentHashMap;
    //   291: checkcast 331	java/util/Map
    //   294: aload_2
    //   295: new 366	com/tencent/mm/plugin/aw/b$c
    //   298: dup
    //   299: aload_1
    //   300: getfield 419	com/tencent/mm/plugin/aw/b:PvS	J
    //   303: aload_1
    //   304: getfield 420	com/tencent/mm/plugin/aw/b:PvO	Z
    //   307: invokespecial 423	com/tencent/mm/plugin/aw/b$c:<init>	(JZ)V
    //   310: invokeinterface 416 3 0
    //   315: pop
    //   316: aload_0
    //   317: invokevirtual 309	com/tencent/mm/plugin/webcanvas/c:cAK	()Lcom/tencent/mm/plugin/webcanvas/k;
    //   320: aload 4
    //   322: aload_2
    //   323: invokestatic 314	com/tencent/mm/plugin/webcanvas/k:a	(Lcom/tencent/mm/plugin/webcanvas/k;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mm/plugin/webcanvas/a;
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
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramString1, "canvasId");
    kotlin.g.b.p.k(paramString2, "data");
    kotlin.g.b.p.k(parami, "jsRuntime");
    new com.tencent.mm.plugin.av.j((com.tencent.mm.plugin.av.k)this).h(parami);
    paramContext = k.a(cAK(), paramContext, paramString1);
    new com.tencent.mm.plugin.av.f((com.tencent.mm.plugin.av.g)paramContext).h(parami);
    new com.tencent.mm.plugin.av.n((o)new i((j)paramContext, this, cAK())).h(parami);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.m.g paramg, com.tencent.mm.plugin.aw.f paramf, kotlin.g.a.b<? super String, x> paramb)
  {
    kotlin.g.b.p.k(paramString1, "name");
    kotlin.g.b.p.k(paramString2, "type");
    kotlin.g.b.p.k(paramg, "context");
    kotlin.g.b.p.k(paramf, "contextReporter");
    for (;;)
    {
      try
      {
        String str1 = com.tencent.mm.plugin.webview.l.a.a(gPj()).MJ("client").MJ(paramString2).getString("path");
        Object localObject = gPj();
        kotlin.g.b.p.j(str1, "path");
        localObject = com.tencent.mm.plugin.webview.l.a.a((com.tencent.mm.plugin.appbrand.appcache.p)localObject, str1);
        if (BuildInfo.DEBUG)
        {
          if (paramb != null)
          {
            paramb = new e(paramb);
            paramg.evaluateJavascript((String)localObject, (ValueCallback)paramb);
            Log.d(this.TAG, "biz loaded:" + str1 + " to " + paramString1);
          }
        }
        else
        {
          URL localURL = new URL("https://ws/usr/" + bsE() + str1);
          String str2 = mb(bsE(), str1);
          int i = com.tencent.mm.plugin.webview.l.a.b(gPj());
          if (paramb != null)
          {
            paramb = new e(paramb);
            paramg.a(localURL, str2, String.valueOf(i), 0, (String)localObject, (ValueCallback)paramb);
          }
          else {}
        }
      }
      catch (Exception paramg)
      {
        paramf.a((f.i)new f.f());
        paramf = l.PuB;
        l.aU(bsE(), paramString1, "type=" + paramString2 + ", " + paramg.getMessage());
        Log.printErrStackTrace(this.TAG, (Throwable)paramg, "read client context script", new Object[0]);
        throw ((Throwable)paramg);
      }
    }
  }
  
  public final void bB(String paramString, long paramLong)
  {
    kotlin.g.b.p.k(paramString, "canvasId");
    Log.i(this.TAG, "reflow #".concat(String.valueOf(paramString)));
    a locala = cAK().bij(paramString);
    if (locala != null) {
      locala.gOV();
    }
    com.tencent.mm.plugin.av.c.a.a(this, "reflow", "{target:'" + paramString + "', start:" + paramLong + '}', null, 4);
  }
  
  public final float[] bic(String paramString)
  {
    kotlin.g.b.p.k(paramString, "canvasId");
    paramString = cAK().bij(paramString);
    if (paramString != null) {
      return paramString.Ptb;
    }
    return null;
  }
  
  public final void bid(String paramString)
  {
    kotlin.g.b.p.k(paramString, "<set-?>");
    this.PtM = paramString;
  }
  
  public final com.tencent.mm.plugin.aw.c.a bie(String paramString)
  {
    kotlin.g.b.p.k(paramString, "type");
    String str = bsE();
    paramString = com.tencent.mm.plugin.webview.l.a.a(gPj()).MK("client").MK(paramString);
    if (paramString != null) {}
    for (long l = paramString.optLong("idKey");; l = 0L) {
      return new com.tencent.mm.plugin.aw.c.a(str, l);
    }
  }
  
  public abstract String bsE();
  
  protected abstract k cAK();
  
  protected void cAL()
  {
    Log.i(this.TAG, "init");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
    {
      localObject = new com.tencent.magicbrush.f();
      ((com.tencent.magicbrush.g)localObject).context = MMApplicationContext.getContext();
      ((com.tencent.magicbrush.g)localObject).cMv = ((kotlin.g.a.a)new f(this));
      ((com.tencent.magicbrush.g)localObject).cMu = ((com.tencent.magicbrush.handler.a)new g(this));
      ((com.tencent.magicbrush.f)localObject).UW();
    }
    Object localObject = new com.tencent.mm.plugin.av.i((com.tencent.mm.plugin.av.c)this);
    com.tencent.mm.plugin.appbrand.m.g localg = bYU();
    kotlin.g.b.p.j(localg, "mainJsContext");
    ((com.tencent.mm.plugin.av.i)localObject).h((com.tencent.mm.plugin.appbrand.m.i)localg);
    this.PtJ.gPL();
    ad((kotlin.g.a.b)new h(this));
    this.PtJ.gPM();
    new i(this).alive();
  }
  
  public final void clear()
  {
    cAI().eU(MMApplicationContext.getContext());
    k localk = cAK();
    Iterator localIterator = ((Iterable)localk.Pus).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Log.i(localk.TAG, "canvasContext#" + (String)localObject1 + " should be destroyed");
      a locala = (a)localk.Puq.get(localObject1);
      if (locala != null)
      {
        n localn = locala.PsX;
        if (localn != null)
        {
          locala.gOT().By(localn.Pva);
          locala.gOT().b("destroy", "{target:'" + locala.owd + "'}", (ValueCallback)new a.i(localn));
          Object localObject2 = localn.PI().getParent();
          localObject1 = localObject2;
          if (!(localObject2 instanceof ViewGroup)) {
            localObject1 = null;
          }
          localObject1 = (ViewGroup)localObject1;
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localn.PI());
          }
          localObject2 = localn.PI().getContext();
          localObject1 = localObject2;
          if (!(localObject2 instanceof MutableContextWrapper)) {
            localObject1 = null;
          }
          localObject1 = (MutableContextWrapper)localObject1;
          if (localObject1 != null) {
            ((MutableContextWrapper)localObject1).setBaseContext(MMApplicationContext.getContext());
          }
          Log.i(a.TAG, "canvas#" + locala.owd + ':' + localn.Pva + '@' + localn.PI().getVirtualElementId() + " has been destroyed");
        }
        locala.PsX = null;
      }
    }
    localk.Pus.clear();
  }
  
  public final com.tencent.mm.plugin.aw.g gPh()
  {
    return this.sPV;
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.p gPi()
  {
    return (com.tencent.mm.plugin.appbrand.appcache.p)this.PtK.getValue();
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.p gPj()
  {
    return (com.tencent.mm.plugin.appbrand.appcache.p)this.PtL.getValue();
  }
  
  public final int getBasePkgVersion()
  {
    return com.tencent.mm.plugin.webview.l.a.b(gPi());
  }
  
  public final int getBizPkgVersion()
  {
    return com.tencent.mm.plugin.webview.l.a.b(gPj());
  }
  
  public final void hP(String paramString)
  {
    boolean bool2 = false;
    kotlin.g.b.p.k(paramString, "canvasId");
    long l = MMSlotKt.now();
    Log.i(this.TAG, "resume #" + paramString + ", " + l);
    Object localObject1 = this.PtJ;
    int i = paramString.hashCode();
    kotlin.g.b.p.k(paramString, "canvasId");
    Object localObject2;
    b.a locala;
    b.c localc;
    if (!((com.tencent.mm.plugin.aw.b)localObject1).PvR.containsKey(Integer.valueOf(i)))
    {
      localObject2 = (Map)((com.tencent.mm.plugin.aw.b)localObject1).PvR;
      locala = new b.a(System.currentTimeMillis(), i, paramString);
      localc = (b.c)((com.tencent.mm.plugin.aw.b)localObject1).PvQ.get(paramString);
      if (localc == null) {
        break label306;
      }
    }
    label306:
    for (boolean bool1 = localc.PvZ;; bool1 = false)
    {
      locala.PvZ = bool1;
      ((Map)localObject2).put(Integer.valueOf(i), locala);
      localObject2 = (b.a)((com.tencent.mm.plugin.aw.b)localObject1).PvR.get(Integer.valueOf(i));
      if (localObject2 != null)
      {
        if (((b.a)localObject2).PvY) {
          ((b.a)localObject2).createTime = System.currentTimeMillis();
        }
        localObject1 = (b.c)((com.tencent.mm.plugin.aw.b)localObject1).PvQ.get(paramString);
        bool1 = bool2;
        if (localObject1 != null) {
          bool1 = ((b.c)localObject1).PvZ;
        }
        ((b.a)localObject2).PvZ = bool1;
      }
      a(this, "resume", paramString);
      cAK().gPl();
      cAK().a(l, paramString, null);
      cAK().bih(paramString);
      if ((kotlin.g.b.p.h(this.PtN, "resume") ^ true))
      {
        this.PtN = "resume";
        cAK().a(l, this.PtM, null);
        cAK().bih(this.PtM);
      }
      return;
    }
  }
  
  public final void hQ(String paramString)
  {
    kotlin.g.b.p.k(paramString, "canvasId");
    Log.i(this.TAG, "pause #".concat(String.valueOf(paramString)));
    a(this, "pause", paramString);
    cAK().big(paramString);
    cAK();
    kotlin.g.b.p.k(paramString, "canvasId");
    if ((kotlin.g.b.p.h(this.PtN, "pause") ^ true))
    {
      this.PtN = "pause";
      cAK().big(this.PtM);
      cAK();
      kotlin.g.b.p.k(this.PtM, "canvasId");
    }
  }
  
  public final void lW(String paramString1, String paramString2)
  {
    kotlin.g.b.p.k(paramString1, "message");
    kotlin.g.b.p.k(paramString2, "targetOrigin");
    cAK().mc(paramString1, paramString2);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$Companion;", "", "()V", "canvasStorage", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getCanvasStorage", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "canvasStorage$delegate", "Lkotlin/Lazy;", "webview-sdk_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MMKVSlotManager>
  {
    public static final b PtP;
    
    static
    {
      AppMethodBeat.i(207118);
      PtP = new b();
      AppMethodBeat.o(207118);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.appcache.p>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$create$1$1"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    d(c paramc, Context paramContext, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<m>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke", "com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$initEnv$1$1"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<al>
  {
    f(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$initEnv$1$2", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "p0", "Ljava/lang/Runnable;", "p1", "resumeLoopTasks", "webview-sdk_release"})
  public static final class g
    implements com.tencent.magicbrush.handler.a
  {
    g(c paramc) {}
    
    public final boolean OF()
    {
      AppMethodBeat.i(207180);
      IJSRuntime localIJSRuntime = this.PtQ.bYQ();
      kotlin.g.b.p.j(localIJSRuntime, "this@WebCanvasJsEngine.jsRuntime");
      boolean bool = localIJSRuntime.abY();
      AppMethodBeat.o(207180);
      return bool;
    }
    
    public final String OG()
    {
      AppMethodBeat.i(207174);
      String str = this.PtQ.OG();
      AppMethodBeat.o(207174);
      return str;
    }
    
    public final void a(Runnable paramRunnable, boolean paramBoolean)
    {
      AppMethodBeat.i(207179);
      kotlin.g.b.p.k(paramRunnable, "p0");
      this.PtQ.a(paramRunnable, paramBoolean);
      AppMethodBeat.o(207179);
    }
    
    public final boolean doInnerLoopTask()
    {
      AppMethodBeat.i(207176);
      boolean bool = this.PtQ.bYQ().doInnerLoopTask();
      AppMethodBeat.o(207176);
      return bool;
    }
    
    public final void resumeLoopTasks()
    {
      AppMethodBeat.i(207175);
      this.PtQ.bYQ().resumeLoopTasks();
      AppMethodBeat.o(207175);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$initEnv$3", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "webview-sdk_release"})
  public static final class i
    extends o.a
  {
    public final void onAppBackground(String arg1)
    {
      AppMethodBeat.i(206110);
      kotlin.g.b.p.k(???, "activity");
      com.tencent.mm.plugin.av.c.a.a(this.PtQ, "background", null, (ValueCallback)new a(this), 2);
      synchronized (this.PtQ.cAK())
      {
        if (!???.isPaused)
        {
          ???.isPaused = true;
          ???.gPn();
          ???.pause();
          Log.i(???.TAG, "renderJsEngine pause");
        }
        x localx = x.aazN;
        AppMethodBeat.o(206110);
        return;
      }
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(206108);
      kotlin.g.b.p.k(paramString, "activity");
      Log.i(c.a(this.PtQ), "logicJsEngine and renderJsEngine resume");
      this.PtQ.cAK().gPl();
      this.PtQ.resume();
      com.tencent.mm.plugin.av.c.a.a(this.PtQ, "foreground", null, null, 6);
      AppMethodBeat.o(206108);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class a<T>
      implements ValueCallback<String>
    {
      a(c.i parami) {}
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.c
 * JD-Core Version:    0.7.0.1
 */