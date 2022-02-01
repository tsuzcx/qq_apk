package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import com.tencent.magicbrush.an;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.ax.n;
import com.tencent.mm.plugin.ax.o;
import com.tencent.mm.plugin.ay.d;
import com.tencent.mm.plugin.ay.d.f;
import com.tencent.mm.plugin.ay.d.i;
import com.tencent.mm.plugin.ay.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "()V", "TAG", "", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizAppId", "getBizAppId", "()Ljava/lang/String;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getBizPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "bizPkg$delegate", "Lkotlin/Lazy;", "bizPkgVersion", "getBizPkgVersion", "canvasContexts", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "engine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "getEngine", "()Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "engine$delegate", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "initStartTime", "", "lastRenderAction", "performanceReporter", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "getPerformanceReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "popupId", "getPopupId", "setPopupId", "(Ljava/lang/String;)V", "renderJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "getRenderJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "wxaPkg", "getWxaPkg", "wxaPkg$delegate", "attach", "", "canvasId", "clear", "configClient", "context", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "name", "type", "cb", "Lkotlin/Function1;", "clientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "create", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "data", "Landroid/content/Context;", "detach", "emit", "event", "Landroid/webkit/ValueCallback;", "enterUI", "exitUI", "findCanvasContext", "getClientInfo", "getVideoPos", "", "initEnv", "onConfigClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "onConfigClientInject", "contextReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "onTransferMessage", "message", "targetOrigin", "pause", "recycleAllContext", "recycleContext", "contextId", "reflow", "start", "resume", "stop", "touch", "Landroid/view/MotionEvent;", "touch$webview_sdk_release", "update", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends com.tencent.mm.plugin.ay.c
  implements com.tencent.mm.plugin.ax.k
{
  private static final kotlin.j<MMKVSlotManager> WjZ = kotlin.k.cm((kotlin.g.a.a)b.Wky);
  public static final a Wkq = new a((byte)0);
  final String TAG = "MicroMsg.WebCanvasJsEngine";
  private final kotlin.j Wkr = kotlin.k.cm((kotlin.g.a.a)new e(this));
  private final HashMap<String, Integer> Wks = new HashMap();
  protected final com.tencent.mm.plugin.ay.b Wkt;
  private final kotlin.j Wku;
  private final kotlin.j Wkv;
  String Wkw;
  String Wkx;
  private final long mBX;
  private final e vVl = new e();
  
  public c()
  {
    long l = MMSlotKt.now();
    Log.d(this.TAG, "performance: initStartTime");
    ah localah = ah.aiuX;
    this.mBX = l;
    this.Wkt = new com.tencent.mm.plugin.ay.b(this.mBX);
    this.Wku = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.Wkv = kotlin.k.cm((kotlin.g.a.a)new c(this));
    ddO();
    this.Wkw = "none";
    this.Wkx = "";
  }
  
  private static final void b(c paramc, String paramString)
  {
    s.u(paramc, "this$0");
    Log.d(paramc.TAG, s.X("recycleContext destroy# ", paramString));
  }
  
  private static final void b(c paramc, String paramString1, String paramString2)
  {
    s.u(paramc, "this$0");
    s.u(paramString1, "$canvasId");
    Log.d(paramc.TAG, s.X("enterUI# ", paramString1));
  }
  
  private static final void c(c paramc, String paramString1, String paramString2)
  {
    s.u(paramc, "this$0");
    s.u(paramString1, "$canvasId");
    Log.d(paramc.TAG, s.X("exitUI# ", paramString1));
  }
  
  private static final void c(kotlin.g.a.b paramb, String paramString)
  {
    paramb.invoke(paramString);
  }
  
  private static final void d(kotlin.g.a.b paramb, String paramString)
  {
    paramb.invoke(paramString);
  }
  
  private void hJ(String paramString, int paramInt)
  {
    s.u(paramString, "canvasId");
    b("destroy", "{target:'" + paramString + "'}", new c..ExternalSyntheticLambda0(this));
    BL(paramInt);
    Log.i(this.TAG, "recycleContext canvasId=" + paramString + ", contextId=" + paramInt);
  }
  
  /* Error */
  public final a a(String paramString1, final String paramString2, String paramString3, Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc_w 376
    //   6: invokestatic 308	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_2
    //   10: ldc_w 309
    //   13: invokestatic 308	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: aload_3
    //   17: ldc_w 377
    //   20: invokestatic 308	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload 4
    //   25: ldc_w 378
    //   28: invokestatic 308	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 235	com/tencent/mm/plugin/webcanvas/c:Wks	Ljava/util/HashMap;
    //   35: aload_2
    //   36: invokevirtual 382	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   39: ifeq +18 -> 57
    //   42: aload_0
    //   43: invokevirtual 386	com/tencent/mm/plugin/webcanvas/c:ddP	()Lcom/tencent/mm/plugin/webcanvas/i;
    //   46: aload 4
    //   48: aload_2
    //   49: invokestatic 391	com/tencent/mm/plugin/webcanvas/i:a	(Lcom/tencent/mm/plugin/webcanvas/i;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mm/plugin/webcanvas/a;
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: invokestatic 241	com/tencent/mm/sdk/platformtools/MMSlotKt:now	()J
    //   60: lstore 5
    //   62: aload_0
    //   63: getfield 220	com/tencent/mm/plugin/webcanvas/c:TAG	Ljava/lang/String;
    //   66: ldc_w 393
    //   69: aload_2
    //   70: invokestatic 340	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   73: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: getfield 235	com/tencent/mm/plugin/webcanvas/c:Wks	Ljava/util/HashMap;
    //   80: checkcast 395	java/util/Map
    //   83: astore 9
    //   85: aload_0
    //   86: getfield 401	com/tencent/mm/plugin/appbrand/n/a:sSV	Lcom/tencent/mm/plugin/appbrand/n/e;
    //   89: invokevirtual 407	com/tencent/mm/plugin/appbrand/n/e:czj	()Lcom/tencent/mm/plugin/appbrand/n/g;
    //   92: astore 10
    //   94: aload 10
    //   96: ldc_w 409
    //   99: invokestatic 294	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   102: aload_0
    //   103: aload 4
    //   105: aload_2
    //   106: aload_3
    //   107: aload 10
    //   109: checkcast 411	com/tencent/mm/plugin/appbrand/n/i
    //   112: invokevirtual 414	com/tencent/mm/plugin/webcanvas/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/n/i;)V
    //   115: aload_0
    //   116: checkcast 4	com/tencent/mm/plugin/ay/c
    //   119: aload 10
    //   121: ldc_w 416
    //   124: aload_2
    //   125: invokestatic 340	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   128: aload_1
    //   129: new 21	com/tencent/mm/plugin/webcanvas/c$d
    //   132: dup
    //   133: aload_0
    //   134: aload_2
    //   135: lload 5
    //   137: invokespecial 419	com/tencent/mm/plugin/webcanvas/c$d:<init>	(Lcom/tencent/mm/plugin/webcanvas/c;Ljava/lang/String;J)V
    //   140: checkcast 348	kotlin/g/a/b
    //   143: aconst_null
    //   144: bipush 16
    //   146: invokestatic 422	com/tencent/mm/plugin/ay/c:a	(Lcom/tencent/mm/plugin/ay/c;Lcom/tencent/mm/plugin/appbrand/n/g;Ljava/lang/String;Ljava/lang/String;Lkotlin/g/a/b;Lcom/tencent/mm/plugin/ay/c$a;I)V
    //   149: aload_0
    //   150: getfield 263	com/tencent/mm/plugin/webcanvas/c:Wkt	Lcom/tencent/mm/plugin/ay/b;
    //   153: astore_1
    //   154: aload_2
    //   155: ldc_w 424
    //   158: invokestatic 308	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   161: aload_1
    //   162: getfield 428	com/tencent/mm/plugin/ay/b:Wmg	Ljava/util/concurrent/ConcurrentHashMap;
    //   165: aload_2
    //   166: invokevirtual 433	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   169: checkcast 435	com/tencent/mm/plugin/ay/b$c
    //   172: astore_3
    //   173: aload_3
    //   174: ifnull +72 -> 246
    //   177: invokestatic 440	java/lang/System:currentTimeMillis	()J
    //   180: lload 5
    //   182: lsub
    //   183: lstore 7
    //   185: aload_1
    //   186: ldc2_w 441
    //   189: lconst_1
    //   190: invokevirtual 446	com/tencent/mm/plugin/ay/b:as	(JJ)V
    //   193: aload_1
    //   194: ldc2_w 447
    //   197: lload 7
    //   199: invokevirtual 446	com/tencent/mm/plugin/ay/b:as	(JJ)V
    //   202: aload_3
    //   203: lload 7
    //   205: l2i
    //   206: putfield 452	com/tencent/mm/plugin/ay/b$c:Wmp	I
    //   209: ldc_w 454
    //   212: new 311	java/lang/StringBuilder
    //   215: dup
    //   216: ldc_w 456
    //   219: invokespecial 315	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   222: lload 7
    //   224: invokevirtual 459	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   227: ldc_w 461
    //   230: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_3
    //   234: getfield 465	com/tencent/mm/plugin/ay/b$c:Wme	Z
    //   237: invokevirtual 468	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   240: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: aload 9
    //   248: aload_2
    //   249: aload 10
    //   251: invokeinterface 473 1 0
    //   256: invokestatic 479	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: invokeinterface 483 3 0
    //   264: pop
    //   265: aload_0
    //   266: getfield 263	com/tencent/mm/plugin/webcanvas/c:Wkt	Lcom/tencent/mm/plugin/ay/b;
    //   269: astore_1
    //   270: aload_2
    //   271: ldc_w 424
    //   274: invokestatic 308	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   277: aload_1
    //   278: lload 5
    //   280: putfield 486	com/tencent/mm/plugin/ay/b:Wmi	J
    //   283: aload_1
    //   284: getfield 428	com/tencent/mm/plugin/ay/b:Wmg	Ljava/util/concurrent/ConcurrentHashMap;
    //   287: checkcast 395	java/util/Map
    //   290: aload_2
    //   291: new 435	com/tencent/mm/plugin/ay/b$c
    //   294: dup
    //   295: aload_1
    //   296: getfield 486	com/tencent/mm/plugin/ay/b:Wmi	J
    //   299: aload_1
    //   300: getfield 487	com/tencent/mm/plugin/ay/b:Wme	Z
    //   303: invokespecial 490	com/tencent/mm/plugin/ay/b$c:<init>	(JZ)V
    //   306: invokeinterface 483 3 0
    //   311: pop
    //   312: aload_0
    //   313: invokevirtual 386	com/tencent/mm/plugin/webcanvas/c:ddP	()Lcom/tencent/mm/plugin/webcanvas/i;
    //   316: aload 4
    //   318: aload_2
    //   319: invokestatic 391	com/tencent/mm/plugin/webcanvas/i:a	(Lcom/tencent/mm/plugin/webcanvas/i;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mm/plugin/webcanvas/a;
    //   322: astore_1
    //   323: goto -270 -> 53
    //   326: astore_1
    //   327: aload_0
    //   328: monitorexit
    //   329: aload_1
    //   330: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	c
    //   0	331	1	paramString1	String
    //   0	331	2	paramString2	String
    //   0	331	3	paramString3	String
    //   0	331	4	paramContext	Context
    //   60	219	5	l1	long
    //   183	40	7	l2	long
    //   83	164	9	localMap	Map
    //   92	158	10	localg	com.tencent.mm.plugin.appbrand.n.g
    // Exception table:
    //   from	to	target	type
    //   2	53	326	finally
    //   57	173	326	finally
    //   177	246	326	finally
    //   246	323	326	finally
  }
  
  protected void a(Context paramContext, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.n.i parami)
  {
    s.u(paramContext, "context");
    s.u(paramString1, "canvasId");
    s.u(paramString2, "data");
    s.u(parami, "jsRuntime");
    new com.tencent.mm.plugin.ax.j((com.tencent.mm.plugin.ax.k)this).l(parami);
    paramContext = i.a(ddP(), paramContext, paramString1);
    new com.tencent.mm.plugin.ax.f((com.tencent.mm.plugin.ax.g)paramContext).l(parami);
    new n((o)new g((h)paramContext, this)).l(parami);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.n.g paramg, String paramString1, String paramString2, kotlin.g.a.b<? super String, ah> paramb, com.tencent.mm.plugin.ay.c.a parama)
  {
    s.u(paramg, "context");
    s.u(paramString1, "name");
    s.u(paramString2, "type");
    com.tencent.mm.plugin.appbrand.n.g localg = czi();
    if (localg != null) {
      localg.b(paramg, "NativeGlobal");
    }
    super.a(paramg, paramString1, paramString2, paramb, parama);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.n.g paramg, d paramd, kotlin.g.a.b<? super String, ah> paramb)
  {
    Object localObject = null;
    URL localURL = null;
    s.u(paramString1, "name");
    s.u(paramString2, "type");
    s.u(paramg, "context");
    s.u(paramd, "contextReporter");
    String str1;
    String str2;
    try
    {
      str1 = com.tencent.mm.plugin.webview.l.a.f(ioy()).Fs("client").Fs(paramString2).getString("path");
      paramString2 = ioy();
      s.s(str1, "path");
      str2 = r.a(paramString2, str1);
      if ((BuildInfo.DEBUG) && (1 > Log.getLogLevel()))
      {
        if (paramb == null) {}
        for (paramString2 = localURL;; paramString2 = new c..ExternalSyntheticLambda4(paramb))
        {
          paramg.evaluateJavascript(str2, paramString2);
          Log.d(this.TAG, "biz loaded:" + str1 + " to " + paramString1);
          return;
        }
      }
      localURL = new URL("https://ws/usr/" + bQl() + str1);
    }
    catch (Exception paramString1)
    {
      paramd.a((d.i)new d.f());
      throw paramString1;
    }
    String str3 = nN(bQl(), str1);
    int i = com.tencent.mm.plugin.webview.l.a.h(ioy());
    if (paramb == null) {}
    for (paramString2 = localObject;; paramString2 = new c..ExternalSyntheticLambda3(paramb))
    {
      paramg.a(localURL, str3, String.valueOf(i), 0, str2, paramString2);
      break;
    }
  }
  
  public final void bO(String paramString, long paramLong)
  {
    s.u(paramString, "canvasId");
    Log.i(this.TAG, s.X("reflow #", paramString));
    a locala = ddP().bhV(paramString);
    if (locala != null) {
      locala.ioj();
    }
    com.tencent.mm.plugin.ax.c.a.a((com.tencent.mm.plugin.ax.c)this, "reflow", "{target:'" + paramString + "', start:" + paramLong + '}', null, 4);
  }
  
  public abstract String bQl();
  
  public final float[] bhN(String paramString)
  {
    s.u(paramString, "canvasId");
    paramString = ddP().bhV(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.WjT;
  }
  
  public final void bhO(String paramString)
  {
    s.u(paramString, "<set-?>");
    this.Wkw = paramString;
  }
  
  public final void bhP(String paramString)
  {
    try
    {
      s.u(paramString, "canvasId");
      if (this.Wks.containsKey(paramString))
      {
        Integer localInteger = (Integer)this.Wks.get(paramString);
        if (localInteger != null) {
          hJ(paramString, localInteger.intValue());
        }
        this.Wks.remove(paramString);
      }
      return;
    }
    finally {}
  }
  
  public final com.tencent.mm.plugin.ay.c.a bhQ(String paramString)
  {
    s.u(paramString, "type");
    String str = bQl();
    paramString = com.tencent.mm.plugin.webview.l.a.f(ioy()).Ft("client").Ft(paramString);
    if (paramString == null) {}
    for (long l = 0L;; l = paramString.optLong("idKey")) {
      return new com.tencent.mm.plugin.ay.c.a(str, l);
    }
  }
  
  /* Error */
  public final void bm(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc_w 376
    //   6: invokestatic 308	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_2
    //   10: ldc_w 309
    //   13: invokestatic 308	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: aload_3
    //   17: ldc_w 377
    //   20: invokestatic 308	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload_0
    //   24: getfield 220	com/tencent/mm/plugin/webcanvas/c:TAG	Ljava/lang/String;
    //   27: ldc_w 694
    //   30: aload_2
    //   31: invokestatic 340	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield 235	com/tencent/mm/plugin/webcanvas/c:Wks	Ljava/util/HashMap;
    //   41: aload_2
    //   42: invokevirtual 382	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   45: ifne +14 -> 59
    //   48: aload_0
    //   49: aload_1
    //   50: aload_2
    //   51: aload_3
    //   52: invokestatic 696	com/tencent/mm/plugin/webcanvas/c:a	(Lcom/tencent/mm/plugin/webcanvas/c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/plugin/webcanvas/a;
    //   55: pop
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: aload_0
    //   60: ldc_w 697
    //   63: aload_2
    //   64: invokestatic 699	com/tencent/mm/plugin/webcanvas/c:a	(Lcom/tencent/mm/plugin/webcanvas/c;Ljava/lang/String;Ljava/lang/String;)V
    //   67: goto -11 -> 56
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	c
    //   0	75	1	paramString1	String
    //   0	75	2	paramString2	String
    //   0	75	3	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   2	56	70	finally
    //   59	67	70	finally
  }
  
  public void clear()
  {
    ddL().fR(MMApplicationContext.getContext());
    i locali = ddP();
    Iterator localIterator = ((Iterable)locali.WkV).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      Log.i(locali.TAG, "canvasContext#" + localObject + " should be destroyed");
      localObject = (a)locali.WkT.get(localObject);
      if (localObject != null) {
        ((a)localObject).destroy();
      }
    }
    locali.WkV.clear();
  }
  
  protected void ddO()
  {
    Log.i(this.TAG, "init");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
    {
      localObject = new com.tencent.magicbrush.f();
      ((com.tencent.magicbrush.g)localObject).context = MMApplicationContext.getContext();
      ((com.tencent.magicbrush.g)localObject).eHO = ((kotlin.g.a.a)new f(this));
      ((com.tencent.magicbrush.g)localObject).eHN = ((com.tencent.magicbrush.handler.a)new g(this));
      ((com.tencent.magicbrush.f)localObject).avz();
    }
    Object localObject = new com.tencent.mm.plugin.ax.i((com.tencent.mm.plugin.ax.c)this);
    com.tencent.mm.plugin.appbrand.n.g localg = czi();
    s.s(localg, "mainJsContext");
    ((com.tencent.mm.plugin.ax.i)localObject).l((com.tencent.mm.plugin.appbrand.n.i)localg);
    com.tencent.mm.plugin.ay.b.a(this.Wkt);
    aR((kotlin.g.a.b)new h(this));
    com.tencent.mm.plugin.ay.b.b(this.Wkt);
    new i(this).alive();
  }
  
  public abstract i ddP();
  
  public final int getBasePkgVersion()
  {
    return com.tencent.mm.plugin.webview.l.a.h(iox());
  }
  
  public final int getBizPkgVersion()
  {
    return com.tencent.mm.plugin.webview.l.a.h(ioy());
  }
  
  public final void ioA()
  {
    try
    {
      Iterator localIterator = ((Map)this.Wks).entrySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((Map.Entry)localIterator.next()).getKey();
        b("enterUI", "{target:'" + str + "'}", new c..ExternalSyntheticLambda2(this, str));
      }
    }
    finally {}
  }
  
  public final void ioB()
  {
    try
    {
      Iterator localIterator = ((Map)this.Wks).entrySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((Map.Entry)localIterator.next()).getKey();
        b("exitUI", "{target:'" + str + "'}", new c..ExternalSyntheticLambda1(this, str));
      }
    }
    finally {}
  }
  
  public final e iow()
  {
    return this.vVl;
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.q iox()
  {
    return (com.tencent.mm.plugin.appbrand.appcache.q)this.Wku.getValue();
  }
  
  public final com.tencent.mm.plugin.appbrand.appcache.q ioy()
  {
    return (com.tencent.mm.plugin.appbrand.appcache.q)this.Wkv.getValue();
  }
  
  public final void ioz()
  {
    try
    {
      Iterator localIterator = ((Map)this.Wks).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        hJ((String)localEntry.getKey(), ((Number)localEntry.getValue()).intValue());
      }
      this.Wks.clear();
    }
    finally {}
  }
  
  public final void nI(String paramString1, String paramString2)
  {
    s.u(paramString1, "message");
    s.u(paramString2, "targetOrigin");
    ddP().nO(paramString1, paramString2);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$Companion;", "", "()V", "canvasStorage", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getCanvasStorage", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "canvasStorage$delegate", "Lkotlin/Lazy;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<MMKVSlotManager>
  {
    public static final b Wky;
    
    static
    {
      AppMethodBeat.i(261239);
      Wky = new b();
      AppMethodBeat.o(261239);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.appcache.q>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    d(c paramc, String paramString, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<m>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<an>
  {
    f(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$initEnv$1$2", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "p0", "Ljava/lang/Runnable;", "p1", "resumeLoopTasks", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.magicbrush.handler.a
  {
    g(c paramc) {}
    
    public final void a(Runnable paramRunnable, boolean paramBoolean)
    {
      AppMethodBeat.i(261247);
      s.u(paramRunnable, "p0");
      this.Wkz.a(paramRunnable, paramBoolean);
      AppMethodBeat.o(261247);
    }
    
    public final boolean aoN()
    {
      AppMethodBeat.i(261254);
      boolean bool = this.Wkz.hnh.aDX();
      AppMethodBeat.o(261254);
      return bool;
    }
    
    public final String aoO()
    {
      AppMethodBeat.i(261234);
      String str = this.Wkz.aoO();
      AppMethodBeat.o(261234);
      return str;
    }
    
    public final boolean doInnerLoopTask()
    {
      AppMethodBeat.i(261240);
      boolean bool = this.Wkz.hnh.doInnerLoopTask();
      AppMethodBeat.o(261240);
      return bool;
    }
    
    public final void resumeLoopTasks()
    {
      AppMethodBeat.i(261237);
      this.Wkz.hnh.resumeLoopTasks();
      AppMethodBeat.o(261237);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    h(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$initEnv$3", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "isAppForeground", "", "onAppBackground", "", "activity", "", "onAppForeground", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends q.a
  {
    private boolean eLx = true;
    
    i(c paramc) {}
    
    private static final void a(c paramc, i parami)
    {
      AppMethodBeat.i(261280);
      s.u(paramc, "this$0");
      s.u(parami, "this$1");
      Log.i(c.a(paramc), s.X("logicJsEngine pause isAppForeground=", Boolean.valueOf(parami.eLx)));
      if (!parami.eLx) {
        paramc.pause();
      }
      AppMethodBeat.o(261280);
    }
    
    private static final void c(c paramc, String paramString)
    {
      AppMethodBeat.i(261273);
      s.u(paramc, "this$0");
      Log.i(c.a(paramc), "logicJsEngine pause callback");
      AppMethodBeat.o(261273);
    }
    
    /* Error */
    public final void onAppBackground(String arg1)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 100
      //   4: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_1
      //   8: ldc 101
      //   10: invokestatic 70	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
      //   13: aload_0
      //   14: iconst_0
      //   15: putfield 61	com/tencent/mm/plugin/webcanvas/c$i:eLx	Z
      //   18: aload_0
      //   19: getfield 57	com/tencent/mm/plugin/webcanvas/c$i:Wkz	Lcom/tencent/mm/plugin/webcanvas/c;
      //   22: checkcast 103	com/tencent/mm/plugin/ax/c
      //   25: ldc 105
      //   27: aconst_null
      //   28: new 107	com/tencent/mm/plugin/webcanvas/c$i$$ExternalSyntheticLambda0
      //   31: dup
      //   32: aload_0
      //   33: getfield 57	com/tencent/mm/plugin/webcanvas/c$i:Wkz	Lcom/tencent/mm/plugin/webcanvas/c;
      //   36: invokespecial 109	com/tencent/mm/plugin/webcanvas/c$i$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/plugin/webcanvas/c;)V
      //   39: iconst_2
      //   40: invokestatic 114	com/tencent/mm/plugin/ax/c$a:a	(Lcom/tencent/mm/plugin/ax/c;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/ValueCallback;I)V
      //   43: getstatic 120	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
      //   46: new 122	com/tencent/mm/plugin/webcanvas/c$i$$ExternalSyntheticLambda1
      //   49: dup
      //   50: aload_0
      //   51: getfield 57	com/tencent/mm/plugin/webcanvas/c$i:Wkz	Lcom/tencent/mm/plugin/webcanvas/c;
      //   54: aload_0
      //   55: invokespecial 124	com/tencent/mm/plugin/webcanvas/c$i$$ExternalSyntheticLambda1:<init>	(Lcom/tencent/mm/plugin/webcanvas/c;Lcom/tencent/mm/plugin/webcanvas/c$i;)V
      //   58: ldc2_w 125
      //   61: invokeinterface 131 4 0
      //   66: pop
      //   67: aload_0
      //   68: getfield 57	com/tencent/mm/plugin/webcanvas/c$i:Wkz	Lcom/tencent/mm/plugin/webcanvas/c;
      //   71: invokevirtual 135	com/tencent/mm/plugin/webcanvas/c:ddP	()Lcom/tencent/mm/plugin/webcanvas/i;
      //   74: astore_1
      //   75: aload_1
      //   76: monitorenter
      //   77: aload_1
      //   78: getfield 140	com/tencent/mm/plugin/webcanvas/i:isPaused	Z
      //   81: ifne +25 -> 106
      //   84: aload_1
      //   85: iconst_1
      //   86: putfield 140	com/tencent/mm/plugin/webcanvas/i:isPaused	Z
      //   89: aload_1
      //   90: invokevirtual 143	com/tencent/mm/plugin/webcanvas/i:ioI	()V
      //   93: aload_1
      //   94: invokevirtual 144	com/tencent/mm/plugin/webcanvas/i:pause	()V
      //   97: aload_1
      //   98: getfield 148	com/tencent/mm/plugin/webcanvas/i:TAG	Ljava/lang/String;
      //   101: ldc 150
      //   103: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   106: getstatic 156	kotlin/ah:aiuX	Lkotlin/ah;
      //   109: astore_2
      //   110: aload_1
      //   111: monitorexit
      //   112: ldc 100
      //   114: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   117: aload_0
      //   118: monitorexit
      //   119: return
      //   120: astore_2
      //   121: aload_1
      //   122: monitorexit
      //   123: ldc 100
      //   125: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   128: aload_2
      //   129: athrow
      //   130: astore_1
      //   131: aload_0
      //   132: monitorexit
      //   133: aload_1
      //   134: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	135	0	this	i
      //   109	1	2	localah	ah
      //   120	9	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   77	106	120	finally
      //   106	110	120	finally
      //   2	77	130	finally
      //   110	117	130	finally
      //   121	130	130	finally
    }
    
    public final void onAppForeground(String paramString)
    {
      try
      {
        AppMethodBeat.i(261303);
        s.u(paramString, "activity");
        this.eLx = true;
        Log.i(c.a(this.Wkz), "logicJsEngine resume");
        try
        {
          this.Wkz.ddP().ioF();
          this.Wkz.resume();
          com.tencent.mm.plugin.ax.c.a.a((com.tencent.mm.plugin.ax.c)this.Wkz, "foreground", null, null, 6);
          AppMethodBeat.o(261303);
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.printErrStackTrace(c.a(this.Wkz), (Throwable)paramString, "onAppForeground ex", new Object[0]);
            AppMethodBeat.o(261303);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.appcache.q>
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