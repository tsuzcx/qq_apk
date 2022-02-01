package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.faf;
import com.tencent.mm.protocal.protobuf.fag;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.z;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.g.a.s;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "", "weakJsapi", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Ljava/lang/ref/WeakReference;)V", "inited", "", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "getReporter", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "getWeakJsapi", "()Ljava/lang/ref/WeakReference;", "workerManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "getWorkerManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "workerManager$delegate", "Lkotlin/Lazy;", "appendTags", "", "webCompt", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "cleanMainFrame", "clear", "createJsContext", "appId", "", "url", "launchMainFrame", "dispatchEvent", "event", "message", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluateMainFrame", "script", "callback", "Lkotlin/Function1;", "getA8Key", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "a8KeyUrl", "webComptName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppScript", "Lkotlin/Pair;", "paramsObject", "Lcom/tencent/mm/json/JSONObject;", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "performance", "frontEndPerformance", "postToBack", "postToFront", "refreshA8Key", "onerror", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "onsuccess", "config", "webComptInfo", "configTimeStamps", "", "resume", "end", "step", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "evaluate", "launch", "a8key", "records", "steps", "", "start", "toJson", "A8KeyResp", "Companion", "CreateJSContextException", "PerformanceSteps", "WebComptWorkerManager", "webview-sdk_release"})
public final class c
{
  private static final kotlin.f IBP;
  private static final String JCV = "webcompt://";
  private static final kotlin.f JCW;
  static final kotlin.f JCX;
  static final kotlin.f JCY;
  private static final kotlin.f JCZ;
  private static String JDa;
  private static final LinkedList<l> JDb;
  private static final kotlin.f JDc;
  private static final String JDd;
  private static final kotlin.f JDe;
  public static final b JDf;
  static final String TAG = "MicroMsg.WebComponent";
  final j JCS;
  private final kotlin.f JCT;
  final WeakReference<com.tencent.mm.plugin.webview.d.h> JCU;
  private boolean gKM;
  
  static
  {
    AppMethodBeat.i(82898);
    JDf = new b((byte)0);
    JCV = "webcompt://";
    TAG = "MicroMsg.WebComponent";
    IBP = kotlin.g.ah((kotlin.g.a.a)g.JDG);
    JCW = kotlin.g.ah((kotlin.g.a.a)d.JDD);
    JCX = kotlin.g.ah((kotlin.g.a.a)f.JDF);
    JCY = kotlin.g.ah((kotlin.g.a.a)i.JDI);
    JCZ = kotlin.g.ah((kotlin.g.a.a)c.e.JDE);
    JDa = "";
    JDb = new LinkedList();
    JDc = kotlin.g.ah((kotlin.g.a.a)h.JDH);
    JDd = com.tencent.mm.loader.j.b.aKJ() + "webcompt_debug/";
    JDe = kotlin.g.ah((kotlin.g.a.a)c.JDB);
    AppMethodBeat.o(82898);
  }
  
  public c(WeakReference<com.tencent.mm.plugin.webview.d.h> paramWeakReference)
  {
    AppMethodBeat.i(225204);
    this.JCU = paramWeakReference;
    this.JCS = new j();
    b.giV().clear();
    this.JCT = kotlin.g.ah((kotlin.g.a.a)new z(this));
    AppMethodBeat.o(225204);
  }
  
  private final String a(a parama)
  {
    AppMethodBeat.i(82905);
    Object localObject3 = parama.JDh;
    Object localObject1 = (com.tencent.mm.plugin.webview.d.h)this.JCU.get();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.webview.d.h)localObject1).getSettings();
      if (localObject1 != null)
      {
        localObject2 = ((z)localObject1).getUserAgentString();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label51;
        }
      }
    }
    localObject1 = "";
    label51:
    ((Map)localObject3).put("User-agent", localObject1);
    localObject1 = new com.tencent.mm.ab.i((Map)localObject3).toString();
    kotlin.g.b.p.g(localObject1, "JSONObject(httpHeaders.a… \"\"\n        }).toString()");
    Object localObject2 = new StringBuilder("{clientVersion:");
    localObject3 = BuildInfo.CLIENT_VERSION;
    kotlin.g.b.p.g(localObject3, "BuildInfo.CLIENT_VERSION");
    parama = a.bbs((String)localObject3) + ",headers:" + (String)localObject1 + ",fullUrl:" + a.bbs(parama.pFJ) + '}';
    AppMethodBeat.o(82905);
    return parama;
  }
  
  static String a(r paramr, List<? extends k> paramList)
  {
    AppMethodBeat.i(82902);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      localLinkedList.add(String.valueOf(paramr.bO(localk.mPw + "_START", paramr.getStartTime()) - paramr.getStartTime()));
      localLinkedList.add(String.valueOf(paramr.bO(localk.mPw + "_END", paramr.getStartTime()) - paramr.getStartTime()));
    }
    paramr = kotlin.a.j.a((Iterable)localLinkedList, (CharSequence)",", null, (CharSequence)",", 0, null, null, 58) + n.r((CharSequence)"0,", (9 - paramList.size()) * 2);
    AppMethodBeat.o(82902);
    return paramr;
  }
  
  /* Error */
  private final o<String, String> a(com.tencent.mm.ab.i parami, final cel paramcel)
  {
    // Byte code:
    //   0: ldc_w 495
    //   3: invokestatic 212	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 323	com/tencent/mm/plugin/webview/l/c:JCS	Lcom/tencent/mm/plugin/webview/l/j;
    //   10: getstatic 501	com/tencent/mm/plugin/webview/l/b:JCA	Lcom/tencent/mm/plugin/webview/l/b;
    //   13: invokevirtual 504	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
    //   16: new 76	com/tencent/mm/plugin/webview/l/c$v
    //   19: dup
    //   20: aload_0
    //   21: aload_2
    //   22: invokespecial 507	com/tencent/mm/plugin/webview/l/c$v:<init>	(Lcom/tencent/mm/plugin/webview/l/c;Lcom/tencent/mm/protocal/protobuf/cel;)V
    //   25: astore 4
    //   27: getstatic 222	com/tencent/mm/plugin/webview/l/c:TAG	Ljava/lang/String;
    //   30: new 279	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 509
    //   37: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: getfield 514	com/tencent/mm/protocal/protobuf/cel:name	Ljava/lang/String;
    //   44: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 519	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: getstatic 525	com/tencent/mm/plugin/webview/l/g:JEH	Lcom/tencent/mm/plugin/webview/l/g$a;
    //   56: astore 5
    //   58: invokestatic 530	com/tencent/mm/plugin/webview/l/g$a:getDebug	()Z
    //   61: ifeq +77 -> 138
    //   64: getstatic 525	com/tencent/mm/plugin/webview/l/g:JEH	Lcom/tencent/mm/plugin/webview/l/g$a;
    //   67: astore 5
    //   69: invokestatic 536	com/tencent/mm/plugin/webview/l/h:cdi	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   72: ldc_w 538
    //   75: ldc_w 263
    //   78: invokevirtual 544	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 5
    //   83: aload 5
    //   85: ifnonnull +6 -> 91
    //   88: invokestatic 547	kotlin/g/b/p:hyc	()V
    //   91: aload 5
    //   93: checkcast 469	java/lang/CharSequence
    //   96: invokestatic 551	kotlin/n/n:aL	(Ljava/lang/CharSequence;)Z
    //   99: ifne +127 -> 226
    //   102: iconst_1
    //   103: istore_3
    //   104: iload_3
    //   105: ifeq +126 -> 231
    //   108: aload 4
    //   110: new 553	java/net/URL
    //   113: dup
    //   114: aload 5
    //   116: invokespecial 554	java/net/URL:<init>	(Ljava/lang/String;)V
    //   119: ldc_w 556
    //   122: ldc_w 557
    //   125: aconst_null
    //   126: getstatic 561	com/tencent/mm/plugin/webview/l/c$b$a:JDm	Lcom/tencent/mm/plugin/webview/l/c$b$a;
    //   129: iconst_4
    //   130: invokestatic 564	com/tencent/mm/plugin/webview/l/c$v:a	(Lcom/tencent/mm/plugin/webview/l/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)Lkotlin/o;
    //   133: astore_1
    //   134: aload_1
    //   135: ifnonnull +993 -> 1128
    //   138: aload_2
    //   139: getfield 566	com/tencent/mm/protocal/protobuf/cel:url	Ljava/lang/String;
    //   142: checkcast 469	java/lang/CharSequence
    //   145: astore_1
    //   146: aload_1
    //   147: ifnull +10 -> 157
    //   150: aload_1
    //   151: invokestatic 551	kotlin/n/n:aL	(Ljava/lang/CharSequence;)Z
    //   154: ifeq +313 -> 467
    //   157: iconst_1
    //   158: istore_3
    //   159: iload_3
    //   160: ifne +28 -> 188
    //   163: aload_2
    //   164: getfield 569	com/tencent/mm/protocal/protobuf/cel:md5	Ljava/lang/String;
    //   167: checkcast 469	java/lang/CharSequence
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +10 -> 182
    //   175: aload_1
    //   176: invokestatic 551	kotlin/n/n:aL	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +293 -> 472
    //   182: iconst_1
    //   183: istore_3
    //   184: iload_3
    //   185: ifeq +292 -> 477
    //   188: aload_2
    //   189: getfield 514	com/tencent/mm/protocal/protobuf/cel:name	Ljava/lang/String;
    //   192: astore_1
    //   193: aload_1
    //   194: ldc_w 571
    //   197: invokestatic 389	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   200: new 45	com/tencent/mm/plugin/webview/l/c$j
    //   203: dup
    //   204: sipush 21001
    //   207: aload_1
    //   208: ldc_w 573
    //   211: invokespecial 576	com/tencent/mm/plugin/webview/l/c$j:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   214: checkcast 494	java/lang/Throwable
    //   217: astore_1
    //   218: ldc_w 495
    //   221: invokestatic 306	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload_1
    //   225: athrow
    //   226: iconst_0
    //   227: istore_3
    //   228: goto -124 -> 104
    //   231: aload_1
    //   232: new 279	java/lang/StringBuilder
    //   235: dup
    //   236: ldc_w 578
    //   239: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   242: aload_2
    //   243: getfield 514	com/tencent/mm/protocal/protobuf/cel:name	Ljava/lang/String;
    //   246: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokevirtual 582	com/tencent/mm/ab/i:has	(Ljava/lang/String;)Z
    //   255: ifeq +71 -> 326
    //   258: aload 4
    //   260: new 553	java/net/URL
    //   263: dup
    //   264: aload_1
    //   265: new 279	java/lang/StringBuilder
    //   268: dup
    //   269: ldc_w 578
    //   272: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload_2
    //   276: getfield 514	com/tencent/mm/protocal/protobuf/cel:name	Ljava/lang/String;
    //   279: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokevirtual 584	com/tencent/mm/ab/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokespecial 554	java/net/URL:<init>	(Ljava/lang/String;)V
    //   291: new 279	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 586
    //   298: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: aload_2
    //   302: getfield 514	com/tencent/mm/protocal/protobuf/cel:name	Ljava/lang/String;
    //   305: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: ldc_w 587
    //   314: aconst_null
    //   315: getstatic 590	com/tencent/mm/plugin/webview/l/c$b$a:JDj	Lcom/tencent/mm/plugin/webview/l/c$b$a;
    //   318: iconst_4
    //   319: invokestatic 564	com/tencent/mm/plugin/webview/l/c$v:a	(Lcom/tencent/mm/plugin/webview/l/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)Lkotlin/o;
    //   322: astore_1
    //   323: goto -189 -> 134
    //   326: aload_1
    //   327: ldc_w 538
    //   330: invokevirtual 582	com/tencent/mm/ab/i:has	(Ljava/lang/String;)Z
    //   333: ifeq +37 -> 370
    //   336: aload 4
    //   338: new 553	java/net/URL
    //   341: dup
    //   342: aload_1
    //   343: ldc_w 538
    //   346: invokevirtual 584	com/tencent/mm/ab/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   349: invokespecial 554	java/net/URL:<init>	(Ljava/lang/String;)V
    //   352: ldc_w 592
    //   355: ldc_w 593
    //   358: aconst_null
    //   359: getstatic 590	com/tencent/mm/plugin/webview/l/c$b$a:JDj	Lcom/tencent/mm/plugin/webview/l/c$b$a;
    //   362: iconst_4
    //   363: invokestatic 564	com/tencent/mm/plugin/webview/l/c$v:a	(Lcom/tencent/mm/plugin/webview/l/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)Lkotlin/o;
    //   366: astore_1
    //   367: goto -233 -> 134
    //   370: new 595	com/tencent/mm/vfs/o
    //   373: dup
    //   374: new 279	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   381: aload_2
    //   382: getfield 514	com/tencent/mm/protocal/protobuf/cel:name	Ljava/lang/String;
    //   385: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: ldc_w 597
    //   391: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 600	com/tencent/mm/plugin/webview/l/c$b:bbv	(Ljava/lang/String;)Ljava/lang/String;
    //   400: invokespecial 601	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   403: invokevirtual 604	com/tencent/mm/vfs/o:exists	()Z
    //   406: ifeq +56 -> 462
    //   409: aload 4
    //   411: new 595	com/tencent/mm/vfs/o
    //   414: dup
    //   415: new 279	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   422: aload_2
    //   423: getfield 514	com/tencent/mm/protocal/protobuf/cel:name	Ljava/lang/String;
    //   426: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc_w 597
    //   432: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 600	com/tencent/mm/plugin/webview/l/c$b:bbv	(Ljava/lang/String;)Ljava/lang/String;
    //   441: invokespecial 601	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   444: ldc_w 606
    //   447: ldc_w 607
    //   450: aconst_null
    //   451: getstatic 610	com/tencent/mm/plugin/webview/l/c$b$a:JDk	Lcom/tencent/mm/plugin/webview/l/c$b$a;
    //   454: iconst_4
    //   455: invokestatic 564	com/tencent/mm/plugin/webview/l/c$v:a	(Lcom/tencent/mm/plugin/webview/l/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)Lkotlin/o;
    //   458: astore_1
    //   459: goto -325 -> 134
    //   462: aconst_null
    //   463: astore_1
    //   464: goto -330 -> 134
    //   467: iconst_0
    //   468: istore_3
    //   469: goto -310 -> 159
    //   472: iconst_0
    //   473: istore_3
    //   474: goto -290 -> 184
    //   477: new 595	com/tencent/mm/vfs/o
    //   480: dup
    //   481: new 279	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   488: aload_2
    //   489: invokestatic 613	com/tencent/mm/plugin/webview/l/c$b:a	(Lcom/tencent/mm/protocal/protobuf/cel;)Ljava/lang/String;
    //   492: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: ldc_w 597
    //   498: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokespecial 601	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   507: invokevirtual 604	com/tencent/mm/vfs/o:exists	()Z
    //   510: ifeq +180 -> 690
    //   513: aload 4
    //   515: new 595	com/tencent/mm/vfs/o
    //   518: dup
    //   519: new 279	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   526: aload_2
    //   527: invokestatic 613	com/tencent/mm/plugin/webview/l/c$b:a	(Lcom/tencent/mm/protocal/protobuf/cel;)Ljava/lang/String;
    //   530: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc_w 597
    //   536: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokespecial 601	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   545: ldc_w 615
    //   548: sipush 21004
    //   551: getstatic 619	com/tencent/mm/plugin/webview/l/c$b$c:JDt	Lcom/tencent/mm/plugin/webview/l/c$b$c;
    //   554: aconst_null
    //   555: bipush 8
    //   557: invokestatic 564	com/tencent/mm/plugin/webview/l/c$v:a	(Lcom/tencent/mm/plugin/webview/l/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)Lkotlin/o;
    //   560: astore_1
    //   561: aload_0
    //   562: getfield 323	com/tencent/mm/plugin/webview/l/c:JCS	Lcom/tencent/mm/plugin/webview/l/j;
    //   565: getstatic 622	com/tencent/mm/plugin/webview/l/b:JBZ	Lcom/tencent/mm/plugin/webview/l/b;
    //   568: invokevirtual 504	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
    //   571: getstatic 222	com/tencent/mm/plugin/webview/l/c:TAG	Ljava/lang/String;
    //   574: new 279	java/lang/StringBuilder
    //   577: dup
    //   578: ldc_w 624
    //   581: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   584: aload_2
    //   585: getfield 514	com/tencent/mm/protocal/protobuf/cel:name	Ljava/lang/String;
    //   588: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 519	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: aload_1
    //   598: getfield 630	kotlin/o:second	Ljava/lang/Object;
    //   601: checkcast 455	java/lang/String
    //   604: invokevirtual 633	java/lang/String:length	()I
    //   607: iconst_1
    //   608: if_icmple +508 -> 1116
    //   611: getstatic 222	com/tencent/mm/plugin/webview/l/c:TAG	Ljava/lang/String;
    //   614: astore 4
    //   616: new 279	java/lang/StringBuilder
    //   619: dup
    //   620: ldc_w 635
    //   623: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   626: aload_2
    //   627: getfield 514	com/tencent/mm/protocal/protobuf/cel:name	Ljava/lang/String;
    //   630: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: bipush 10
    //   635: invokevirtual 417	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   638: astore_2
    //   639: aload_1
    //   640: getfield 630	kotlin/o:second	Ljava/lang/Object;
    //   643: checkcast 455	java/lang/String
    //   646: astore 5
    //   648: bipush 100
    //   650: aload_1
    //   651: getfield 630	kotlin/o:second	Ljava/lang/Object;
    //   654: checkcast 455	java/lang/String
    //   657: invokevirtual 633	java/lang/String:length	()I
    //   660: iconst_1
    //   661: isub
    //   662: invokestatic 641	java/lang/Math:min	(II)I
    //   665: istore_3
    //   666: aload 5
    //   668: ifnonnull +417 -> 1085
    //   671: new 643	kotlin/t
    //   674: dup
    //   675: ldc_w 645
    //   678: invokespecial 646	kotlin/t:<init>	(Ljava/lang/String;)V
    //   681: astore_1
    //   682: ldc_w 495
    //   685: invokestatic 306	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   688: aload_1
    //   689: athrow
    //   690: new 553	java/net/URL
    //   693: dup
    //   694: aload_2
    //   695: getfield 566	com/tencent/mm/protocal/protobuf/cel:url	Ljava/lang/String;
    //   698: invokespecial 554	java/net/URL:<init>	(Ljava/lang/String;)V
    //   701: astore 5
    //   703: getstatic 222	com/tencent/mm/plugin/webview/l/c:TAG	Ljava/lang/String;
    //   706: ldc_w 648
    //   709: aload 5
    //   711: invokestatic 651	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   714: invokevirtual 654	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   717: invokestatic 656	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: aload 5
    //   722: invokevirtual 660	java/net/URL:openStream	()Ljava/io/InputStream;
    //   725: checkcast 662	java/io/Closeable
    //   728: astore 6
    //   730: aconst_null
    //   731: astore 4
    //   733: aload 6
    //   735: checkcast 664	java/io/InputStream
    //   738: astore_1
    //   739: aload_1
    //   740: ldc_w 666
    //   743: invokestatic 389	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   746: aload_1
    //   747: invokestatic 672	kotlin/f/a:U	(Ljava/io/InputStream;)[B
    //   750: astore_1
    //   751: aload_2
    //   752: getfield 569	com/tencent/mm/protocal/protobuf/cel:md5	Ljava/lang/String;
    //   755: new 674	java/io/ByteArrayInputStream
    //   758: dup
    //   759: aload_1
    //   760: invokespecial 677	java/io/ByteArrayInputStream:<init>	([B)V
    //   763: checkcast 664	java/io/InputStream
    //   766: aload_1
    //   767: arraylength
    //   768: invokestatic 682	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   771: invokestatic 685	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   774: ifeq +161 -> 935
    //   777: new 595	com/tencent/mm/vfs/o
    //   780: dup
    //   781: new 279	java/lang/StringBuilder
    //   784: dup
    //   785: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   788: aload_2
    //   789: invokestatic 613	com/tencent/mm/plugin/webview/l/c$b:a	(Lcom/tencent/mm/protocal/protobuf/cel;)Ljava/lang/String;
    //   792: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: ldc_w 597
    //   798: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokespecial 601	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   807: astore 7
    //   809: aload 7
    //   811: invokevirtual 688	com/tencent/mm/vfs/o:getParent	()Ljava/lang/String;
    //   814: astore 8
    //   816: aload 8
    //   818: ifnonnull +6 -> 824
    //   821: invokestatic 547	kotlin/g/b/p:hyc	()V
    //   824: new 595	com/tencent/mm/vfs/o
    //   827: dup
    //   828: aload 8
    //   830: invokespecial 601	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   833: invokevirtual 691	com/tencent/mm/vfs/o:mkdirs	()Z
    //   836: pop
    //   837: aload 7
    //   839: invokevirtual 694	com/tencent/mm/vfs/o:createNewFile	()Z
    //   842: pop
    //   843: aload 7
    //   845: aload_1
    //   846: invokestatic 699	com/tencent/mm/vfs/p:b	(Lcom/tencent/mm/vfs/o;[B)V
    //   849: invokestatic 327	com/tencent/mm/plugin/webview/l/c$b:giV	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
    //   852: getfield 702	com/tencent/mm/plugin/webview/l/c$b$b:JDp	Ljava/util/LinkedList;
    //   855: astore 7
    //   857: aload 5
    //   859: invokevirtual 703	java/net/URL:toString	()Ljava/lang/String;
    //   862: astore 8
    //   864: aload 8
    //   866: ldc_w 705
    //   869: invokestatic 389	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   872: aload 7
    //   874: new 19	com/tencent/mm/plugin/webview/l/c$b$d
    //   877: dup
    //   878: aload 8
    //   880: getstatic 708	com/tencent/mm/plugin/webview/l/c$b$c:JDu	Lcom/tencent/mm/plugin/webview/l/c$b$c;
    //   883: aconst_null
    //   884: iconst_4
    //   885: invokespecial 711	com/tencent/mm/plugin/webview/l/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)V
    //   888: invokevirtual 463	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   891: pop
    //   892: new 626	kotlin/o
    //   895: dup
    //   896: aload 5
    //   898: invokevirtual 703	java/net/URL:toString	()Ljava/lang/String;
    //   901: new 455	java/lang/String
    //   904: dup
    //   905: aload_1
    //   906: getstatic 717	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   909: invokespecial 720	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   912: invokespecial 723	kotlin/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   915: astore_1
    //   916: aload_0
    //   917: getfield 323	com/tencent/mm/plugin/webview/l/c:JCS	Lcom/tencent/mm/plugin/webview/l/j;
    //   920: getstatic 726	com/tencent/mm/plugin/webview/l/b:JCa	Lcom/tencent/mm/plugin/webview/l/b;
    //   923: invokevirtual 504	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
    //   926: aload 6
    //   928: aconst_null
    //   929: invokestatic 731	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   932: goto -361 -> 571
    //   935: aload_0
    //   936: getfield 323	com/tencent/mm/plugin/webview/l/c:JCS	Lcom/tencent/mm/plugin/webview/l/j;
    //   939: getstatic 734	com/tencent/mm/plugin/webview/l/b:JCf	Lcom/tencent/mm/plugin/webview/l/b;
    //   942: invokevirtual 504	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
    //   945: aload_2
    //   946: getfield 514	com/tencent/mm/protocal/protobuf/cel:name	Ljava/lang/String;
    //   949: astore_1
    //   950: aload_1
    //   951: ldc_w 571
    //   954: invokestatic 389	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   957: new 45	com/tencent/mm/plugin/webview/l/c$j
    //   960: dup
    //   961: sipush 21003
    //   964: aload_1
    //   965: ldc_w 736
    //   968: aload 5
    //   970: invokestatic 651	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   973: invokevirtual 654	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   976: invokespecial 576	com/tencent/mm/plugin/webview/l/c$j:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   979: checkcast 494	java/lang/Throwable
    //   982: astore_1
    //   983: ldc_w 495
    //   986: invokestatic 306	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   989: aload_1
    //   990: athrow
    //   991: astore 4
    //   993: ldc_w 495
    //   996: invokestatic 306	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   999: aload 4
    //   1001: athrow
    //   1002: astore_1
    //   1003: aload 6
    //   1005: aload 4
    //   1007: invokestatic 731	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   1010: ldc_w 495
    //   1013: invokestatic 306	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1016: aload_1
    //   1017: athrow
    //   1018: astore_1
    //   1019: aload_2
    //   1020: getfield 514	com/tencent/mm/protocal/protobuf/cel:name	Ljava/lang/String;
    //   1023: astore_2
    //   1024: aload_2
    //   1025: ldc_w 571
    //   1028: invokestatic 389	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1031: new 45	com/tencent/mm/plugin/webview/l/c$j
    //   1034: dup
    //   1035: sipush 21002
    //   1038: aload_2
    //   1039: new 279	java/lang/StringBuilder
    //   1042: dup
    //   1043: ldc_w 738
    //   1046: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1049: aload_1
    //   1050: invokevirtual 741	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1053: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: ldc_w 743
    //   1059: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: aload 5
    //   1064: invokevirtual 746	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1067: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1070: invokespecial 576	com/tencent/mm/plugin/webview/l/c$j:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   1073: checkcast 494	java/lang/Throwable
    //   1076: astore_1
    //   1077: ldc_w 495
    //   1080: invokestatic 306	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1083: aload_1
    //   1084: athrow
    //   1085: aload 5
    //   1087: iconst_0
    //   1088: iload_3
    //   1089: invokevirtual 750	java/lang/String:substring	(II)Ljava/lang/String;
    //   1092: astore 5
    //   1094: aload 5
    //   1096: ldc_w 752
    //   1099: invokestatic 389	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1102: aload 4
    //   1104: aload_2
    //   1105: aload 5
    //   1107: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1113: invokestatic 656	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1116: ldc_w 495
    //   1119: invokestatic 306	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1122: aload_1
    //   1123: areturn
    //   1124: astore_1
    //   1125: goto -122 -> 1003
    //   1128: goto -557 -> 571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1131	0	this	c
    //   0	1131	1	parami	com.tencent.mm.ab.i
    //   0	1131	2	paramcel	cel
    //   103	986	3	i	int
    //   25	707	4	localObject1	Object
    //   991	112	4	localThrowable	Throwable
    //   56	1050	5	localObject2	Object
    //   728	276	6	localCloseable	java.io.Closeable
    //   807	66	7	localObject3	Object
    //   814	65	8	str	String
    // Exception table:
    //   from	to	target	type
    //   733	816	991	java/lang/Throwable
    //   821	824	991	java/lang/Throwable
    //   824	926	991	java/lang/Throwable
    //   935	991	991	java/lang/Throwable
    //   993	1002	1002	finally
    //   720	730	1018	java/lang/Exception
    //   926	932	1018	java/lang/Exception
    //   1003	1018	1018	java/lang/Exception
    //   733	816	1124	finally
    //   821	824	1124	finally
    //   824	926	1124	finally
    //   935	991	1124	finally
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.m.g paramg, cel paramcel, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(225198);
    Object localObject = c.m.JEd;
    localObject = new StringBuilder("WeixinWebCompt.config({resume:").append(paramBoolean).append(", debug:");
    g.a locala = g.JEH;
    c(paramg, g.a.getDebug() + ", iframeUrlPattern:'" + (String)JCW.getValue() + "', configFinishTs:" + paramLong + ", bizReportId:" + paramcel.MjV + ", options:" + paramcel.MjW + "})");
    Log.i(TAG, "WeixinWebCompt.config:" + paramcel.MjW);
    AppMethodBeat.o(225198);
  }
  
  static void a(r paramr, k paramk)
  {
    AppMethodBeat.i(82901);
    paramr.bN(paramk.mPw + "_START", System.currentTimeMillis());
    AppMethodBeat.o(82901);
  }
  
  static void c(com.tencent.mm.plugin.appbrand.m.g paramg, String paramString)
  {
    AppMethodBeat.i(225200);
    paramg.evaluateJavascript(paramString, null);
    AppMethodBeat.o(225200);
  }
  
  public static final String getScheme()
  {
    return JCV;
  }
  
  public static final void giT()
  {
    AppMethodBeat.i(82923);
    b.zA(false);
    AppMethodBeat.o(82923);
  }
  
  private final void o(String paramString, kotlin.g.a.b<? super String, x> paramb)
  {
    AppMethodBeat.i(82912);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new c.t(this, paramString, paramb));
    AppMethodBeat.o(82912);
  }
  
  public final com.tencent.mm.plugin.appbrand.m.g bbt(String paramString)
  {
    AppMethodBeat.i(225202);
    kotlin.g.b.p.h(paramString, "webCompt");
    paramString = (c.l.a)giJ().get(paramString);
    if (paramString != null)
    {
      paramString = paramString.giZ();
      AppMethodBeat.o(225202);
      return paramString;
    }
    AppMethodBeat.o(225202);
    return null;
  }
  
  public final void bi(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(225201);
    kotlin.g.b.p.h(paramString1, "webCompt");
    kotlin.g.b.p.h(paramString2, "event");
    if (Util.isNullOrNil(paramString2))
    {
      Log.w(TAG, "dispatch event is null");
      AppMethodBeat.o(225201);
      return;
    }
    Log.v(TAG, "dispatch event=%s, value=%s", new Object[] { paramString2, paramString3 });
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new q(this, paramString1, paramString2, paramString3));
    this.JCS.a(b.JCN);
    AppMethodBeat.o(225201);
  }
  
  public final void clear()
  {
    int i;
    for (;;)
    {
      Object localObject2;
      c.l.a locala;
      try
      {
        AppMethodBeat.i(82900);
        b.giV().clear();
        if (!this.gKM) {
          break label339;
        }
        l locall = giJ();
        j localj = this.JCS;
        kotlin.g.b.p.h(localj, "reporter");
        Log.i(TAG, "clear workerManager#" + locall.id);
        Iterator localIterator = locall.entrySet().iterator();
        i = -1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator.next();
        locala = (c.l.a)((Map.Entry)localObject2).getValue();
        if ((!locala.used) && (locala.JDT) && (!locall.JDS.containsKey(((Map.Entry)localObject2).getKey())))
        {
          locala.aHN = true;
          locala.JDX = null;
          Log.i(TAG, "WebComptWorker.recycle " + locala.appId + '@' + locala.JEa.name + ':' + locala.JDZ);
          ((Map)locall.JDS).put(((Map.Entry)localObject2).getKey(), locala);
          localj.a(b.JCP);
          continue;
        }
        if (locala.used) {
          break label279;
        }
      }
      finally {}
      if (locala.JDZ == localObject1.JDQ)
      {
        i = localObject1.JDQ;
      }
      else
      {
        label279:
        localObject2 = locala.JEb;
        String str = locala.JEa.name;
        kotlin.g.b.p.g(str, "webComptInfo.name");
        ((c)localObject2).bi(str, "onWebComptDestroy", "{}");
        locala.giZ().destroy();
      }
    }
    localObject1.JDQ = i;
    localObject1.clear();
    label339:
    AppMethodBeat.o(82900);
  }
  
  final l giJ()
  {
    AppMethodBeat.i(82899);
    l locall = (l)this.JCT.getValue();
    AppMethodBeat.o(82899);
    return locall;
  }
  
  public final void giK()
  {
    AppMethodBeat.i(225203);
    if (this.gKM)
    {
      a(this, "window.WeixinOpenTags && window.WeixinOpenTags.onClean()");
      this.JCS.a(b.JCm);
    }
    AppMethodBeat.o(225203);
  }
  
  public final void h(final String paramString1, final String paramString2, final String paramString3, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(82910);
    kotlin.g.b.p.h(paramString1, "webCompt");
    kotlin.g.b.p.h(paramString2, "errMsg");
    c.l.a locala = (c.l.a)giJ().get(paramString1);
    if (locala != null)
    {
      faf localfaf = new faf();
      localfaf.dOL = paramString2;
      localfaf.Nwa = paramString3;
      localfaf.Nwb = paramInt1;
      localfaf.Nwc = paramInt2;
      Object localObject = (com.tencent.mm.plugin.webview.d.h)this.JCU.get();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.webview.d.h)localObject).getSettings();
        if (localObject != null)
        {
          String str = ((z)localObject).getUserAgentString();
          localObject = str;
          if (str != null) {
            break label123;
          }
        }
      }
      localObject = "";
      label123:
      localfaf.Ntl = ((String)localObject);
      localfaf.pDH = locala.pDH;
      localfaf.dNI = locala.appId;
      localfaf.Nwd = paramString1;
      localfaf.Nwe = b.giU().getVersion();
      localfaf.Nwf = locala.JDV;
      localfaf.Nwg = locala.JDW;
      this.JCS.a(b.JCL);
      localObject = new d.a();
      ((d.a)localObject).c((com.tencent.mm.bw.a)localfaf);
      ((d.a)localObject).d((com.tencent.mm.bw.a)new fag());
      ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/webcompt/reportjserr");
      ((d.a)localObject).sG(2914);
      ((d.a)localObject).sI(0);
      ((d.a)localObject).sJ(0);
      IPCRunCgi.a(((d.a)localObject).aXF(), (IPCRunCgi.a)new r(this, paramString2, paramString3, paramInt1, paramInt2, paramString1));
      AppMethodBeat.o(82910);
      return;
    }
    AppMethodBeat.o(82910);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "", "a8key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "fullUrl", "", "httpHeaders", "", "(Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;Ljava/lang/String;Ljava/util/Map;)V", "getFullUrl", "()Ljava/lang/String;", "getHttpHeaders", "()Ljava/util/Map;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "webview-sdk_release"})
  public static final class a
  {
    final com.tencent.mm.plugin.webview.f.c JDg;
    final Map<String, String> JDh;
    final String pFJ;
    
    public a(com.tencent.mm.plugin.webview.f.c paramc, String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(225177);
      this.JDg = paramc;
      this.pFJ = paramString;
      this.JDh = paramMap;
      AppMethodBeat.o(225177);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion;", "", "()V", "PREFIX_DEBUG_PATH", "", "TAG", "getTAG$webview_sdk_release", "()Ljava/lang/String;", "_cachedFilePath", "debugInfo", "getDebugInfo", "debugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "getDebugger", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "debugger$delegate", "Lkotlin/Lazy;", "iframeUrlPattern", "getIframeUrlPattern", "iframeUrlPattern$delegate", "manager", "com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$2$1", "getManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$2$1;", "manager$delegate", "matrix", "", "", "getMatrix", "()Ljava/util/List;", "matrix$delegate", "meta", "Lcom/tencent/mm/json/JSONObject;", "getMeta", "()Lcom/tencent/mm/json/JSONObject;", "meta$delegate", "preloadWorkers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "scheme", "scheme$annotations", "getScheme", "scriptManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "getScriptManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "scriptManager$delegate", "skeleton", "getSkeleton", "skeleton$delegate", "debugPath", "getDebugPath", "(Ljava/lang/String;)Ljava/lang/String;", "savePath", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getSavePath", "(Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;)Ljava/lang/String;", "version", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "clearDebugPath", "", "jsapiOnly", "", "appOnly", "getCachedFilePath", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedfilePathInMain", "getLocalScript", "path", "scripts", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScript", "preloadWorker", "force", "readText", "DebugType", "Debugger", "ResType", "Script", "ScriptManager", "Worker", "webview-sdk_release"})
  public static final class b
  {
    static int a(com.tencent.mm.plugin.appbrand.appcache.p paramp)
    {
      AppMethodBeat.i(225185);
      try
      {
        localb = c.JDf;
        paramp = c(paramp, "/meta.json");
        if (((CharSequence)paramp).length() != 0) {
          break label97;
        }
        i = 1;
      }
      catch (Exception paramp)
      {
        for (;;)
        {
          b localb = c.JDf;
          Log.e(c.access$getTAG$cp(), "parse IWxaPkg.version Error:" + paramp.getMessage());
          int i = 0;
          continue;
          i = 0;
        }
      }
      if (i != 0)
      {
        AppMethodBeat.o(225185);
        return 0;
      }
      i = new com.tencent.mm.ab.i(paramp).optInt("version");
      AppMethodBeat.o(225185);
      return i;
    }
    
    static String a(cel paramcel)
    {
      AppMethodBeat.i(225186);
      paramcel = com.tencent.mm.loader.j.b.aKB() + "webcompt/" + paramcel.name + '/' + paramcel.md5;
      AppMethodBeat.o(225186);
      return paramcel;
    }
    
    static String bbv(String paramString)
    {
      AppMethodBeat.i(82828);
      paramString = c.giL() + paramString;
      AppMethodBeat.o(82828);
      return paramString;
    }
    
    /* Error */
    private static String c(com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc_w 303
      //   5: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: aload_1
      //   10: invokeinterface 309 2 0
      //   15: astore_0
      //   16: aload_0
      //   17: ifnull +62 -> 79
      //   20: aload_0
      //   21: checkcast 311	java/io/Closeable
      //   24: astore_3
      //   25: new 313	java/lang/String
      //   28: dup
      //   29: aload_3
      //   30: checkcast 315	java/io/InputStream
      //   33: invokestatic 321	kotlin/f/a:U	(Ljava/io/InputStream;)[B
      //   36: getstatic 327	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
      //   39: invokespecial 330	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   42: astore_0
      //   43: aload_3
      //   44: aconst_null
      //   45: invokestatic 335	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   48: ldc_w 303
      //   51: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: aload_0
      //   55: areturn
      //   56: astore_1
      //   57: ldc_w 303
      //   60: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   63: aload_1
      //   64: athrow
      //   65: astore_0
      //   66: aload_3
      //   67: aload_1
      //   68: invokestatic 335	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   71: ldc_w 303
      //   74: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   77: aload_0
      //   78: athrow
      //   79: ldc_w 303
      //   82: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   85: ldc_w 336
      //   88: areturn
      //   89: astore_0
      //   90: aload_2
      //   91: astore_1
      //   92: goto -26 -> 66
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	95	0	paramp	com.tencent.mm.plugin.appbrand.appcache.p
      //   0	95	1	paramString	String
      //   1	90	2	localObject	Object
      //   24	43	3	localCloseable	java.io.Closeable
      // Exception table:
      //   from	to	target	type
      //   25	43	56	java/lang/Throwable
      //   57	65	65	finally
      //   25	43	89	finally
    }
    
    public static String ejA()
    {
      AppMethodBeat.i(82831);
      Object localObject = c.JDf;
      localObject = giV();
      StringBuilder localStringBuilder = new StringBuilder("\n            [debug]\n            debug: ");
      g.a locala = g.JEH;
      localObject = n.buv(g.a.getDebug() + "\n\n            [lib]\n            version: " + ((b)localObject).JDr + "\n            res: " + ((b)localObject).JDq + "\n\n            " + kotlin.a.j.a((Iterable)((b)localObject).JDp, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n\n            " + kotlin.a.j.a((Iterable)((b)localObject).JDo, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n            ");
      AppMethodBeat.o(82831);
      return localObject;
    }
    
    /* Error */
    static String f(String paramString, LinkedList<d> paramLinkedList)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc_w 419
      //   5: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 162	com/tencent/mm/plugin/webview/l/c:access$getTAG$cp	()Ljava/lang/String;
      //   11: ldc_w 421
      //   14: iconst_1
      //   15: anewarray 4	java/lang/Object
      //   18: dup
      //   19: iconst_0
      //   20: aload_0
      //   21: aastore
      //   22: invokestatic 424	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   25: getstatic 367	com/tencent/mm/plugin/webview/l/g:JEH	Lcom/tencent/mm/plugin/webview/l/g$a;
      //   28: astore_3
      //   29: invokestatic 373	com/tencent/mm/plugin/webview/l/g$a:getDebug	()Z
      //   32: ifeq +181 -> 213
      //   35: new 346	com/tencent/mm/vfs/o
      //   38: dup
      //   39: ldc_w 426
      //   42: aload_0
      //   43: invokestatic 430	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   46: invokevirtual 433	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   49: invokestatic 435	com/tencent/mm/plugin/webview/l/c$b:bbv	(Ljava/lang/String;)Ljava/lang/String;
      //   52: invokespecial 349	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
      //   55: astore_3
      //   56: aload_3
      //   57: invokevirtual 438	com/tencent/mm/vfs/o:exists	()Z
      //   60: ifeq +38 -> 98
      //   63: aload_1
      //   64: ifnull +21 -> 85
      //   67: aload_1
      //   68: new 17	com/tencent/mm/plugin/webview/l/c$b$d
      //   71: dup
      //   72: aload_0
      //   73: aconst_null
      //   74: getstatic 442	com/tencent/mm/plugin/webview/l/c$b$a:JDk	Lcom/tencent/mm/plugin/webview/l/c$b$a;
      //   77: iconst_2
      //   78: invokespecial 445	com/tencent/mm/plugin/webview/l/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)V
      //   81: invokevirtual 451	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   84: pop
      //   85: aload_3
      //   86: invokestatic 457	com/tencent/mm/vfs/p:an	(Lcom/tencent/mm/vfs/o;)Ljava/lang/String;
      //   89: astore_0
      //   90: ldc_w 419
      //   93: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   96: aload_0
      //   97: areturn
      //   98: new 346	com/tencent/mm/vfs/o
      //   101: dup
      //   102: ldc_w 459
      //   105: invokestatic 435	com/tencent/mm/plugin/webview/l/c$b:bbv	(Ljava/lang/String;)Ljava/lang/String;
      //   108: invokespecial 349	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
      //   111: astore_3
      //   112: aload_3
      //   113: invokevirtual 438	com/tencent/mm/vfs/o:exists	()Z
      //   116: ifeq +97 -> 213
      //   119: aload_1
      //   120: ifnull +21 -> 141
      //   123: aload_1
      //   124: new 17	com/tencent/mm/plugin/webview/l/c$b$d
      //   127: dup
      //   128: aload_0
      //   129: aconst_null
      //   130: getstatic 462	com/tencent/mm/plugin/webview/l/c$b$a:JDl	Lcom/tencent/mm/plugin/webview/l/c$b$a;
      //   133: iconst_2
      //   134: invokespecial 445	com/tencent/mm/plugin/webview/l/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)V
      //   137: invokevirtual 451	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   140: pop
      //   141: new 464	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   144: dup
      //   145: aload_3
      //   146: invokespecial 466	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Lcom/tencent/mm/vfs/o;)V
      //   149: checkcast 311	java/io/Closeable
      //   152: astore_3
      //   153: aload_3
      //   154: checkcast 464	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   157: astore_1
      //   158: aload_1
      //   159: invokevirtual 469	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:bvf	()Z
      //   162: pop
      //   163: getstatic 135	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   166: astore 4
      //   168: aload_1
      //   169: checkcast 305	com/tencent/mm/plugin/appbrand/appcache/p
      //   172: aload_0
      //   173: invokestatic 140	com/tencent/mm/plugin/webview/l/c$b:c	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
      //   176: astore_0
      //   177: aload_3
      //   178: aconst_null
      //   179: invokestatic 335	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   182: ldc_w 419
      //   185: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   188: aload_0
      //   189: areturn
      //   190: astore_1
      //   191: ldc_w 419
      //   194: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   197: aload_1
      //   198: athrow
      //   199: astore_0
      //   200: aload_3
      //   201: aload_1
      //   202: invokestatic 335	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   205: ldc_w 419
      //   208: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   211: aload_0
      //   212: athrow
      //   213: invokestatic 473	com/tencent/mm/plugin/webview/l/c$b:giU	()Lcom/tencent/mm/plugin/webview/l/c$b$e;
      //   216: astore_2
      //   217: aload_0
      //   218: ldc_w 474
      //   221: invokestatic 259	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   224: getstatic 135	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   227: astore_3
      //   228: aload_2
      //   229: getfield 478	com/tencent/mm/plugin/webview/l/c$b$e:IAs	Lcom/tencent/mm/plugin/appbrand/appcache/p;
      //   232: aload_0
      //   233: invokestatic 140	com/tencent/mm/plugin/webview/l/c$b:c	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
      //   236: astore_2
      //   237: aload_1
      //   238: ifnull +28 -> 266
      //   241: getstatic 135	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   244: astore_3
      //   245: aload_1
      //   246: new 17	com/tencent/mm/plugin/webview/l/c$b$d
      //   249: dup
      //   250: aload_0
      //   251: invokestatic 359	com/tencent/mm/plugin/webview/l/c$b:giV	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   254: getfield 391	com/tencent/mm/plugin/webview/l/c$b$b:JDq	Lcom/tencent/mm/plugin/webview/l/c$b$c;
      //   257: aconst_null
      //   258: iconst_4
      //   259: invokespecial 445	com/tencent/mm/plugin/webview/l/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)V
      //   262: invokevirtual 451	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   265: pop
      //   266: ldc_w 419
      //   269: invokestatic 149	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   272: aload_2
      //   273: areturn
      //   274: astore_0
      //   275: aload_2
      //   276: astore_1
      //   277: goto -77 -> 200
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	280	0	paramString	String
      //   0	280	1	paramLinkedList	LinkedList<d>
      //   1	275	2	localObject1	Object
      //   28	217	3	localObject2	Object
      //   166	1	4	localb	b
      // Exception table:
      //   from	to	target	type
      //   153	177	190	java/lang/Throwable
      //   191	199	199	finally
      //   153	177	274	finally
    }
    
    static e giU()
    {
      AppMethodBeat.i(82827);
      Object localObject = c.giR();
      b localb = c.JDf;
      localObject = (e)((kotlin.f)localObject).getValue();
      AppMethodBeat.o(82827);
      return localObject;
    }
    
    static b giV()
    {
      AppMethodBeat.i(82830);
      Object localObject = c.giS();
      b localb = c.JDf;
      localObject = (b)((kotlin.f)localObject).getValue();
      AppMethodBeat.o(82830);
      return localObject;
    }
    
    public static void zA(boolean paramBoolean)
    {
      AppMethodBeat.i(82822);
      if (c.giM().size() < 3)
      {
        if (paramBoolean) {
          break label52;
        }
        if (((Collection)c.giM()).isEmpty()) {
          break label47;
        }
      }
      label47:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(82822);
        return;
      }
      label52:
      kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMW(), (m)new j(null), 2);
      AppMethodBeat.o(82822);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "", "(Ljava/lang/String;I)V", "NA", "PARAM", "SDCARD", "SDCARD_PKG", "COMMAND", "webview-sdk_release"})
    static enum a
    {
      static
      {
        AppMethodBeat.i(82775);
        a locala1 = new a("NA", 0);
        JDi = locala1;
        a locala2 = new a("PARAM", 1);
        JDj = locala2;
        a locala3 = new a("SDCARD", 2);
        JDk = locala3;
        a locala4 = new a("SDCARD_PKG", 3);
        JDl = locala4;
        a locala5 = new a("COMMAND", 4);
        JDm = locala5;
        JDn = new a[] { locala1, locala2, locala3, locala4, locala5 };
        AppMethodBeat.o(82775);
      }
      
      private a() {}
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "", "()V", "isPreload", "", "()Z", "setPreload", "(Z)V", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "setResType", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;)V", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "verion", "", "getVerion", "()I", "setVerion", "(I)V", "workers", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "getWorkers", "clear", "", "webview-sdk_release"})
    static final class b
    {
      final LinkedList<c.b.f> JDo;
      final LinkedList<c.b.d> JDp;
      c.b.c JDq;
      int JDr;
      boolean ltW;
      
      public b()
      {
        AppMethodBeat.i(82780);
        this.JDo = new LinkedList();
        this.JDp = new LinkedList();
        this.JDq = c.b.c.JDs;
        AppMethodBeat.o(82780);
      }
      
      public final void a(c.b.c paramc)
      {
        AppMethodBeat.i(82778);
        kotlin.g.b.p.h(paramc, "<set-?>");
        this.JDq = paramc;
        AppMethodBeat.o(82778);
      }
      
      public final void clear()
      {
        AppMethodBeat.i(82779);
        this.JDo.clear();
        this.JDp.clear();
        AppMethodBeat.o(82779);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "", "(Ljava/lang/String;I)V", "NA", "CACHE", "NETWORK", "ASSETS", "webview-sdk_release"})
    static enum c
    {
      static
      {
        AppMethodBeat.i(82781);
        c localc1 = new c("NA", 0);
        JDs = localc1;
        c localc2 = new c("CACHE", 1);
        JDt = localc2;
        c localc3 = new c("NETWORK", 2);
        JDu = localc3;
        c localc4 = new c("ASSETS", 3);
        JDv = localc4;
        JDw = new c[] { localc1, localc2, localc3, localc4 };
        AppMethodBeat.o(82781);
      }
      
      private c() {}
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "", "uri", "", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "debugType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;)V", "getDebugType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getUri", "()Ljava/lang/String;", "toString", "webview-sdk_release"})
    static final class d
    {
      private final c.b.c JDq;
      private final c.b.a JDx;
      private final String uri;
      
      public d(String paramString, c.b.c paramc, c.b.a parama)
      {
        AppMethodBeat.i(82785);
        this.uri = paramString;
        this.JDq = paramc;
        this.JDx = parama;
        AppMethodBeat.o(82785);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(82784);
        StringBuilder localStringBuilder = new StringBuilder("[script]\n                ");
        if (this.JDq != c.b.c.JDs) {}
        for (String str = "resType: " + this.JDq;; str = "debugType: " + this.JDx)
        {
          str = n.buv(str + "\n                " + this.uri + "\n                ");
          AppMethodBeat.o(82784);
          return str;
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)V", "version", "", "getVersion", "()I", "version$delegate", "Lkotlin/Lazy;", "getScript", "", "path", "webview-sdk_release"})
    static final class e
    {
      final com.tencent.mm.plugin.appbrand.appcache.p IAs;
      private final kotlin.f IBQ;
      
      public e(com.tencent.mm.plugin.appbrand.appcache.p paramp)
      {
        AppMethodBeat.i(82790);
        this.IAs = paramp;
        this.IBQ = kotlin.g.ah((kotlin.g.a.a)new a(this));
        AppMethodBeat.o(82790);
      }
      
      public final int getVersion()
      {
        AppMethodBeat.i(82789);
        int i = ((Number)this.IBQ.getValue()).intValue();
        AppMethodBeat.o(82789);
        return i;
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
      static final class a
        extends q
        implements kotlin.g.a.a<Integer>
      {
        a(c.b.e parame)
        {
          super();
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
    static final class i
      extends q
      implements kotlin.g.a.b<IPCString, x>
    {
      i(kotlin.d.d paramd)
      {
        super();
      }
    }
    
    @kotlin.d.b.a.f(c="com.tencent.mm.plugin.webview.webcompt.WebComponent$Companion$preloadWorker$1", f="WebComponent.kt", hxM={735}, m="invokeSuspend")
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class j
      extends kotlin.d.b.a.j
      implements m<ai, kotlin.d.d<? super x>, Object>
    {
      Object L$0;
      int label;
      private ai p$;
      
      j(kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(82813);
        kotlin.g.b.p.h(paramd, "completion");
        paramd = new j(paramd);
        paramd.p$ = ((ai)paramObject);
        AppMethodBeat.o(82813);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82814);
        paramObject1 = ((j)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
        AppMethodBeat.o(82814);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(82812);
        Object localObject = kotlin.d.a.a.SXO;
        c.b localb;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82812);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.p$;
          localb = c.JDf;
          this.L$0 = paramObject;
          this.label = 1;
          if (c.b.b(this) == localObject)
          {
            AppMethodBeat.o(82812);
            return localObject;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = new c.l();
        if (paramObject.JDQ == -1)
        {
          localObject = c.JDf;
          localObject = c.b.giW();
          localb = c.JDf;
          paramObject.JDQ = ((c.e.1)localObject).create(c.b.f("/wxwebcompt.js", paramObject.JDR.JDp));
          localObject = c.JDf;
          Log.i(c.access$getTAG$cp(), "preload workerManager#" + paramObject.id);
        }
        for (;;)
        {
          c.giM().offerFirst(paramObject);
          paramObject = x.SXb;
          AppMethodBeat.o(82812);
          return paramObject;
          localObject = c.JDf;
          Log.w(c.access$getTAG$cp(), "preload twice #" + paramObject.id);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<c.b.b>
  {
    public static final c JDB;
    
    static
    {
      AppMethodBeat.i(82800);
      JDB = new c();
      AppMethodBeat.o(82800);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<String>
  {
    public static final d JDD;
    
    static
    {
      AppMethodBeat.i(82805);
      JDD = new d();
      AppMethodBeat.o(82805);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<List<? extends Integer>>
  {
    public static final f JDF;
    
    static
    {
      AppMethodBeat.i(82809);
      JDF = new f();
      AppMethodBeat.o(82809);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<com.tencent.mm.ab.i>
  {
    public static final g JDG;
    
    static
    {
      AppMethodBeat.i(82811);
      JDG = new g();
      AppMethodBeat.o(82811);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<c.b.e>
  {
    public static final h JDH;
    
    static
    {
      AppMethodBeat.i(82816);
      JDH = new h();
      AppMethodBeat.o(82816);
    }
    
    h()
    {
      super();
    }
    
    /* Error */
    private static c.b.e giY()
    {
      // Byte code:
      //   0: ldc 46
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 48	com/tencent/mm/plugin/appbrand/appcache/f
      //   8: dup
      //   9: invokestatic 54	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   12: ldc 56
      //   14: invokespecial 59	com/tencent/mm/plugin/appbrand/appcache/f:<init>	(Landroid/content/Context;Ljava/lang/String;)V
      //   17: astore_2
      //   18: aload_2
      //   19: invokevirtual 63	com/tencent/mm/plugin/appbrand/appcache/f:bvf	()Z
      //   22: pop
      //   23: getstatic 67	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   26: astore_3
      //   27: aload_2
      //   28: checkcast 69	com/tencent/mm/plugin/appbrand/appcache/p
      //   31: invokestatic 75	com/tencent/mm/plugin/webview/l/c$b:a	(Lcom/tencent/mm/plugin/appbrand/appcache/p;)I
      //   34: istore_1
      //   35: invokestatic 79	com/tencent/mm/plugin/webview/l/c:giQ	()Ljava/lang/String;
      //   38: checkcast 81	java/lang/CharSequence
      //   41: invokestatic 87	kotlin/n/n:aL	(Ljava/lang/CharSequence;)Z
      //   44: ifne +119 -> 163
      //   47: iconst_1
      //   48: istore_0
      //   49: iload_0
      //   50: ifeq +118 -> 168
      //   53: invokestatic 79	com/tencent/mm/plugin/webview/l/c:giQ	()Ljava/lang/String;
      //   56: invokestatic 93	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
      //   59: ifeq +109 -> 168
      //   62: new 95	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   65: dup
      //   66: invokestatic 79	com/tencent/mm/plugin/webview/l/c:giQ	()Ljava/lang/String;
      //   69: invokespecial 98	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
      //   72: astore_3
      //   73: aload_3
      //   74: invokevirtual 99	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:bvf	()Z
      //   77: pop
      //   78: getstatic 67	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   81: astore 4
      //   83: aload_3
      //   84: checkcast 69	com/tencent/mm/plugin/appbrand/appcache/p
      //   87: invokestatic 75	com/tencent/mm/plugin/webview/l/c$b:a	(Lcom/tencent/mm/plugin/appbrand/appcache/p;)I
      //   90: istore_0
      //   91: iload_0
      //   92: iload_1
      //   93: if_icmple +75 -> 168
      //   96: getstatic 67	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   99: astore 4
      //   101: invokestatic 102	com/tencent/mm/plugin/webview/l/c:access$getTAG$cp	()Ljava/lang/String;
      //   104: ldc 104
      //   106: iload_0
      //   107: invokestatic 110	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   110: invokevirtual 114	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   113: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   116: getstatic 67	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   119: astore 4
      //   121: invokestatic 123	com/tencent/mm/plugin/webview/l/c$b:giV	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   124: getstatic 129	com/tencent/mm/plugin/webview/l/c$b$c:JDu	Lcom/tencent/mm/plugin/webview/l/c$b$c;
      //   127: invokevirtual 134	com/tencent/mm/plugin/webview/l/c$b$b:a	(Lcom/tencent/mm/plugin/webview/l/c$b$c;)V
      //   130: getstatic 67	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   133: astore 4
      //   135: invokestatic 123	com/tencent/mm/plugin/webview/l/c$b:giV	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   138: iload_0
      //   139: putfield 138	com/tencent/mm/plugin/webview/l/c$b$b:JDr	I
      //   142: aload_3
      //   143: astore_2
      //   144: new 140	com/tencent/mm/plugin/webview/l/c$b$e
      //   147: dup
      //   148: aload_2
      //   149: checkcast 69	com/tencent/mm/plugin/appbrand/appcache/p
      //   152: invokespecial 143	com/tencent/mm/plugin/webview/l/c$b$e:<init>	(Lcom/tencent/mm/plugin/appbrand/appcache/p;)V
      //   155: astore_2
      //   156: ldc 46
      //   158: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   161: aload_2
      //   162: areturn
      //   163: iconst_0
      //   164: istore_0
      //   165: goto -116 -> 49
      //   168: getstatic 67	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   171: astore_3
      //   172: invokestatic 102	com/tencent/mm/plugin/webview/l/c:access$getTAG$cp	()Ljava/lang/String;
      //   175: ldc 145
      //   177: iload_1
      //   178: invokestatic 110	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   181: invokevirtual 114	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   184: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   187: getstatic 67	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   190: astore_3
      //   191: invokestatic 123	com/tencent/mm/plugin/webview/l/c$b:giV	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   194: getstatic 148	com/tencent/mm/plugin/webview/l/c$b$c:JDv	Lcom/tencent/mm/plugin/webview/l/c$b$c;
      //   197: invokevirtual 134	com/tencent/mm/plugin/webview/l/c$b$b:a	(Lcom/tencent/mm/plugin/webview/l/c$b$c;)V
      //   200: getstatic 67	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   203: astore_3
      //   204: invokestatic 123	com/tencent/mm/plugin/webview/l/c$b:giV	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   207: iload_1
      //   208: putfield 138	com/tencent/mm/plugin/webview/l/c$b$b:JDr	I
      //   211: goto -67 -> 144
      //   214: astore_3
      //   215: getstatic 67	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   218: astore 4
      //   220: invokestatic 102	com/tencent/mm/plugin/webview/l/c:access$getTAG$cp	()Ljava/lang/String;
      //   223: new 150	java/lang/StringBuilder
      //   226: dup
      //   227: ldc 152
      //   229: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   232: aload_3
      //   233: invokevirtual 156	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   236: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   239: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   242: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   245: new 168	com/tencent/mm/plugin/webview/l/j
      //   248: dup
      //   249: invokespecial 169	com/tencent/mm/plugin/webview/l/j:<init>	()V
      //   252: getstatic 175	com/tencent/mm/plugin/webview/l/b:JCO	Lcom/tencent/mm/plugin/webview/l/b;
      //   255: invokevirtual 178	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
      //   258: goto -47 -> 211
      // Local variable table:
      //   start	length	slot	name	signature
      //   48	117	0	i	int
      //   34	174	1	j	int
      //   17	145	2	localObject1	Object
      //   26	178	3	localObject2	Object
      //   214	19	3	localException	Exception
      //   81	138	4	localb	c.b
      // Exception table:
      //   from	to	target	type
      //   23	47	214	java/lang/Exception
      //   53	91	214	java/lang/Exception
      //   96	142	214	java/lang/Exception
      //   168	211	214	java/lang/Exception
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<String>
  {
    public static final i JDI;
    
    static
    {
      AppMethodBeat.i(82818);
      JDI = new i();
      AppMethodBeat.o(82818);
    }
    
    i()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "retCode", "", "webComptName", "", "errMsg", "(ILjava/lang/String;Ljava/lang/String;)V", "toJsonString", "webview-sdk_release"})
  public static final class j
    extends Exception
  {
    final String JDJ;
    final String errMsg;
    final int retCode;
    
    public j(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(82842);
      this.retCode = paramInt;
      this.JDJ = paramString1;
      this.errMsg = paramString2;
      AppMethodBeat.o(82842);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "", "stepName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStepName", "()Ljava/lang/String;", "STEP_CREATE_JS_CXT", "STEP_EVAL_MAIN_FRAME", "STEP_GET_A8KEY", "STEP_FETCH_WORKER", "STEP_GET_APP_SCRIPT", "webview-sdk_release"})
  static enum k
  {
    final String mPw;
    
    static
    {
      AppMethodBeat.i(82843);
      k localk1 = new k("STEP_CREATE_JS_CXT", 0, "createJsContext");
      JDK = localk1;
      k localk2 = new k("STEP_EVAL_MAIN_FRAME", 1, "evalMainFrame");
      JDL = localk2;
      k localk3 = new k("STEP_GET_A8KEY", 2, "GetA8Key");
      JDM = localk3;
      k localk4 = new k("STEP_FETCH_WORKER", 3, "FetchWorker");
      JDN = localk4;
      k localk5 = new k("STEP_GET_APP_SCRIPT", 4, "GetAppScript");
      JDO = localk5;
      JDP = new k[] { localk1, localk2, localk3, localk4, localk5 };
      AppMethodBeat.o(82843);
    }
    
    private k(String paramString)
    {
      this.mPw = paramString;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "Lkotlin/collections/HashMap;", "()V", "id", "", "getId", "()I", "preloadDebugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "preloadId", "recycleWorkers", "fetch", "appId", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "preload", "", "recycle", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "WebComptWorker", "webview-sdk_release"})
  static final class l
    extends HashMap<String, a>
  {
    int JDQ;
    c.b.f JDR;
    final HashMap<String, a> JDS;
    final int id;
    
    public l()
    {
      AppMethodBeat.i(82849);
      this.id = ((int)(System.currentTimeMillis() % 1000L));
      this.JDQ = -1;
      this.JDR = new c.b.f(this.id, true, false, 4);
      this.JDS = new HashMap();
      AppMethodBeat.o(82849);
    }
    
    public final a a(String paramString, cel paramcel, c paramc)
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(225189);
          kotlin.g.b.p.h(paramString, "appId");
          kotlin.g.b.p.h(paramcel, "webComptInfo");
          kotlin.g.b.p.h(paramc, "webCompt");
          String str = paramcel.name;
          if (this.JDS.containsKey(str))
          {
            localObject = (a)this.JDS.get(str);
            if ((localObject != null) && (kotlin.g.b.p.j(((a)localObject).appId, paramString)))
            {
              this.JDS.remove(str);
              paramString = (Map)this;
              kotlin.g.b.p.g(str, "webComptName");
              kotlin.g.b.p.g(localObject, "it");
              paramString.put(str, localObject);
              paramString = c.JDf;
              c.b.giV().JDo.add(new c.b.f(this.id, false, true, 2));
              AppMethodBeat.o(225189);
              paramString = (String)localObject;
              return paramString;
            }
          }
          if (this.JDQ != -1) {
            bool = true;
          }
          if (bool == true)
          {
            paramString = c.JDf;
            Log.i(c.access$getTAG$cp(), "use preload workerManager#" + this.id);
            paramString = this.JDR;
            localObject = c.JDf;
            c.b.giV().JDo.add(paramString);
            localObject = c.JDf;
            c.b.giV().ltW = bool;
            if (bool == true)
            {
              i = this.JDQ;
              paramString = new a(i, paramcel, paramc);
              this.JDQ = -1;
              paramcel = (Map)this;
              kotlin.g.b.p.g(str, "webComptName");
              paramcel.put(str, paramString);
              AppMethodBeat.o(225189);
            }
          }
          else
          {
            paramString = c.JDf;
            Log.i(c.access$getTAG$cp(), "create new workerManager#" + this.id);
            paramString = new c.b.f(this.id, false, false, 4);
            continue;
          }
          localObject = c.JDf;
        }
        finally {}
        Object localObject = c.b.giW();
        c.b localb = c.JDf;
        int i = ((c.e.1)localObject).create(c.b.f("/wxwebcompt.js", paramString.JDp));
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "", "workerId", "", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;ILcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;)V", "a8KeyUrl", "", "getA8KeyUrl", "()Ljava/lang/String;", "setA8KeyUrl", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "appScriptMD5", "getAppScriptMD5", "setAppScriptMD5", "appScriptUrl", "getAppScriptUrl", "setAppScriptUrl", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "getEngine", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "isRecycled", "", "()Z", "setRecycled", "(Z)V", "jsapi", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "setJsapi", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;)V", "launched", "getLaunched", "setLaunched", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "setPerformanceHelper", "(Lcom/tencent/mm/pluginsdk/PerformanceHelper;)V", "refer", "getRefer", "setRefer", "used", "getUsed", "setUsed", "getWebCompt", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "getWebComptInfo", "()Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getWorkerId", "()I", "recycle", "", "reuse", "webview-sdk_release"})
    public final class a
    {
      boolean JDT;
      String JDU;
      String JDV;
      String JDW;
      r JDX;
      i JDY;
      final int JDZ;
      final cel JEa;
      final c JEb;
      boolean aHN;
      String appId;
      String pDH;
      boolean used;
      
      public a(cel paramcel, c paramc)
      {
        AppMethodBeat.i(82848);
        this.JDZ = paramcel;
        this.JEa = paramc;
        this.JEb = localObject;
        this.appId = "";
        this.pDH = "";
        this.JDU = "";
        this.JDV = "";
        this.JDW = "";
        this$1 = this.JEb;
        paramc = this.JEa.name;
        kotlin.g.b.p.g(paramc, "webComptInfo.name");
        this.JDY = new i(c.l.this, paramc);
        giZ().addJavascriptInterface(this.JDY, "__webcompt");
        AppMethodBeat.o(82848);
      }
      
      public final void bbw(String paramString)
      {
        AppMethodBeat.i(82846);
        kotlin.g.b.p.h(paramString, "<set-?>");
        this.JDV = paramString;
        AppMethodBeat.o(82846);
      }
      
      public final com.tencent.mm.plugin.appbrand.m.g giZ()
      {
        AppMethodBeat.i(225188);
        Object localObject = c.JDf;
        localObject = c.b.giW().xX(this.JDZ);
        kotlin.g.b.p.g(localObject, "manager.getJsContext(workerId)");
        AppMethodBeat.o(225188);
        return localObject;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"})
  public static final class n
    extends kotlin.d.a
    implements CoroutineExceptionHandler
  {
    public n(f.c paramc, c paramc1, z.f paramf)
    {
      super();
    }
    
    public final void handleException(kotlin.d.f paramf, Throwable paramThrowable)
    {
      AppMethodBeat.i(82863);
      this.JEe.JCS.a(b.JCs);
      if ((paramThrowable instanceof c.j))
      {
        ((kotlin.g.a.b)this.JEf.SYG).invoke(paramThrowable);
        AppMethodBeat.o(82863);
        return;
      }
      AppMethodBeat.o(82863);
      throw paramThrowable;
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.webview.webcompt.WebComponent$createJsContext$2", f="WebComponent.kt", hxM={239, 334, 339, 346}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class o
    extends kotlin.d.b.a.j
    implements m<ai, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    Object pED;
    Object pEE;
    Object pEF;
    Object pEG;
    Object pEH;
    Object pEI;
    Object pEJ;
    Object pEK;
    Object pEL;
    Object pEM;
    
    o(c paramc, boolean paramBoolean, r paramr, String paramString1, cel paramcel, String paramString2, String paramString3, z.f paramf, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(82875);
      kotlin.g.b.p.h(paramd, "completion");
      paramd = new o(this.JEe, this.JEg, this.JEh, this.mkH, this.JEi, this.naX, this.kPQ, this.JEj, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(82875);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(82876);
      paramObject1 = ((o)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(82876);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(82874);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      Object localObject1;
      Object localObject5;
      Object localObject2;
      label321:
      Object localObject3;
      label372:
      Object localObject4;
      label661:
      label697:
      label760:
      label765:
      Object localObject6;
      Object localObject8;
      Object localObject7;
      Object localObject9;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(82874);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        localObject1 = c.JDf;
        this.L$0 = paramObject;
        this.label = 1;
        if (c.b.b(this) == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
        }
      case 1: 
        localObject1 = (ai)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
        if (this.JEg) {
          c.a(this.JEe, this.JEh);
        }
        localObject5 = new com.tencent.mm.ab.i();
        localObject1 = ((Iterable)n.a((CharSequence)n.oD(this.mkH, "#"), new String[] { "&" })).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = n.a((CharSequence)((Iterator)localObject1).next(), new String[] { "=" });
          if (((List)localObject2).size() == 2) {
            ((com.tencent.mm.ab.i)localObject5).h((String)((List)localObject2).get(0), URLDecoder.decode((String)((List)localObject2).get(1), "UTF-8"));
          }
        }
        localObject1 = g.JEH;
        if (g.a.getDebug())
        {
          localObject1 = g.JEH;
          localObject1 = h.cdi().getString("debugA8Key", "");
          if (localObject1 == null) {
            kotlin.g.b.p.hyc();
          }
          if (!n.aL((CharSequence)localObject1))
          {
            i = 1;
            if (i == 0) {
              break label661;
            }
            localObject1 = new o(localObject1, c.b.a.JDm);
            if (localObject1 == null) {
              break label697;
            }
            localObject2 = (String)((o)localObject1).first;
            localObject1 = (c.b.a)((o)localObject1).second;
            localObject3 = c.JDf;
            c.b.giV().JDp.add(new c.b.d((String)localObject2, null, (c.b.a)localObject1, 2));
            localObject1 = localObject2;
            localObject2 = c.JDf;
            Log.d(c.access$getTAG$cp(), "createJsContext a8key:".concat(String.valueOf(localObject1)));
            c.b(this.JEh, c.k.JDK);
            localObject2 = c.JDf;
            Log.i(c.access$getTAG$cp(), "createJsContext init " + this.naX);
            c.c(this.JEh, c.k.JDN);
            localObject2 = c.a(this.JEe).a(this.kPQ, this.JEi, this.JEe);
            c.b(this.JEh, c.k.JDN);
            localObject3 = this.mkH;
            kotlin.g.b.p.h(localObject3, "<set-?>");
            ((c.l.a)localObject2).pDH = ((String)localObject3);
            ((c.l.a)localObject2).JDX = this.JEh;
            localObject3 = this.kPQ;
            kotlin.g.b.p.h(localObject3, "appId");
            if ((!((c.l.a)localObject2).aHN) || (!kotlin.g.b.p.j(((c.l.a)localObject2).appId, localObject3))) {
              break label760;
            }
            ((c.l.a)localObject2).aHN = false;
            localObject4 = c.JDf;
            Log.i(c.access$getTAG$cp(), "WebComptWorker.reuse " + (String)localObject3 + '@' + ((c.l.a)localObject2).JEa.name + ':' + ((c.l.a)localObject2).JDZ);
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label765;
          }
          c.b(((c.l.a)localObject2).giZ(), this.JEi, this.JEh.getStartTime());
          this.JEe.JCS.a(b.JCQ);
          paramObject = x.SXb;
          AppMethodBeat.o(82874);
          return paramObject;
          i = 0;
          break;
          if (((com.tencent.mm.ab.i)localObject5).has("debugA8Key"))
          {
            localObject1 = new o(((com.tencent.mm.ab.i)localObject5).getString("debugA8Key"), c.b.a.JDj);
            break label321;
          }
          localObject1 = null;
          break label321;
          localObject1 = new StringBuilder();
          localObject2 = c.JDf;
          localObject1 = c.giN() + this.naX + "?appId=" + this.kPQ + "&src=" + a.htmlEncode(this.mkH);
          break label372;
        }
        localObject3 = this.kPQ;
        kotlin.g.b.p.h(localObject3, "<set-?>");
        ((c.l.a)localObject2).appId = ((String)localObject3);
        kotlin.g.b.p.h(localObject1, "<set-?>");
        ((c.l.a)localObject2).JDU = ((String)localObject1);
        localObject3 = this.JEi.md5;
        kotlin.g.b.p.g(localObject3, "webCompt.md5");
        kotlin.g.b.p.h(localObject3, "<set-?>");
        ((c.l.a)localObject2).JDW = ((String)localObject3);
        localObject3 = this.JEi.url;
        kotlin.g.b.p.g(localObject3, "webCompt.url");
        ((c.l.a)localObject2).bbw((String)localObject3);
        localObject4 = ((c.l.a)localObject2).giZ();
        ((com.tencent.mm.plugin.appbrand.m.g)localObject4).setJsExceptionHandler((com.tencent.mm.plugin.appbrand.m.h)new a((c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ab.i)localObject5));
        this.JEj.SYG = ((kotlin.g.a.b)new b((com.tencent.mm.plugin.appbrand.m.g)localObject4, (c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ab.i)localObject5));
        c.a((com.tencent.mm.plugin.appbrand.m.g)localObject4, this.JEi, this.JEh.getStartTime());
        localObject3 = kotlinx.coroutines.f.a(paramObject, paramObject.hMk(), (m)new c(null, (c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ab.i)localObject5), 2);
        localObject6 = kotlinx.coroutines.f.a(paramObject, paramObject.hMk(), (m)new d((com.tencent.mm.plugin.appbrand.m.g)localObject4, null, (c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ab.i)localObject5), 2);
        this.L$0 = paramObject;
        this.pED = localObject5;
        this.pEE = localObject1;
        this.pEF = localObject2;
        this.pEG = localObject4;
        this.pEH = localObject4;
        this.pEI = localObject3;
        this.pEJ = localObject6;
        this.label = 2;
        localObject8 = ((ar)localObject6).g(this);
        if (localObject8 == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
        }
        break;
      case 2: 
        localObject6 = (ar)this.pEJ;
        localObject3 = (ar)this.pEI;
        localObject7 = (com.tencent.mm.plugin.appbrand.m.g)this.pEH;
        localObject4 = (com.tencent.mm.plugin.appbrand.m.g)this.pEG;
        localObject2 = (c.l.a)this.pEF;
        localObject1 = (String)this.pEE;
        localObject9 = (com.tencent.mm.ab.i)this.pED;
        localObject8 = (ai)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject5 = paramObject;
        paramObject = localObject8;
        localObject8 = localObject5;
        localObject5 = localObject9;
      }
      for (;;)
      {
        localObject8 = (o)localObject8;
        Object localObject12 = (String)((o)localObject8).first;
        localObject8 = (String)((o)localObject8).second;
        ((c.l.a)localObject2).bbw((String)localObject12);
        c.d((com.tencent.mm.plugin.appbrand.m.g)localObject7, "(function(WeixinWebCompt){" + (String)localObject8 + "})(WeixinWebCompt);");
        this.L$0 = paramObject;
        this.pED = localObject5;
        this.pEE = localObject1;
        this.pEF = localObject2;
        this.pEG = localObject4;
        this.pEH = localObject7;
        this.pEI = localObject3;
        this.pEJ = localObject6;
        this.pEK = localObject12;
        this.pEL = localObject8;
        this.label = 3;
        Object localObject11 = ((ar)localObject3).g(this);
        Object localObject10;
        if (localObject11 == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
          localObject8 = (String)this.pEL;
          localObject5 = (String)this.pEK;
          localObject10 = (ar)this.pEJ;
          localObject3 = (ar)this.pEI;
          localObject6 = (com.tencent.mm.plugin.appbrand.m.g)this.pEH;
          localObject4 = (com.tencent.mm.plugin.appbrand.m.g)this.pEG;
          localObject2 = (c.l.a)this.pEF;
          localObject1 = (String)this.pEE;
          localObject7 = (com.tencent.mm.ab.i)this.pED;
          localObject9 = (ai)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject11 = paramObject;
        }
        for (;;)
        {
          paramObject = (c.a)localObject11;
          localObject11 = ((c.l.a)localObject2).JDY;
          localObject12 = paramObject.JDg.aZE(paramObject.pFJ);
          kotlin.g.b.p.g(localObject12, "a8key.getJsPerm(fullUrl)");
          kotlin.g.b.p.h(localObject12, "<set-?>");
          ((i)localObject11).IBv = ((JsapiPermissionWrapper)localObject12);
          c.a(this.JEe, (com.tencent.mm.plugin.appbrand.m.g)localObject6, paramObject);
          ((c.l.a)localObject2).JDT = true;
          this.L$0 = localObject9;
          this.pED = localObject7;
          this.pEE = localObject1;
          this.pEF = localObject2;
          this.pEG = localObject4;
          this.pEH = localObject6;
          this.pEI = localObject3;
          this.pEJ = localObject10;
          this.pEK = localObject5;
          this.pEL = localObject8;
          this.pEM = paramObject;
          this.label = 4;
          if (au.a(1000L, this) == locala)
          {
            AppMethodBeat.o(82874);
            return locala;
            ResultKt.throwOnFailure(paramObject);
          }
          paramObject = c.JDf;
          c.b.zA(true);
          this.JEe.JCS.a(b.JCv);
          paramObject = c.JDf;
          Log.d(c.access$getTAG$cp(), "createJsContext init finish " + this.naX);
          paramObject = c.JDf;
          if (c.b.giV().ltW) {
            this.JEe.JCS.a(b.JCw);
          }
          paramObject = x.SXb;
          AppMethodBeat.o(82874);
          return paramObject;
          localObject10 = localObject6;
          localObject9 = localObject5;
          localObject5 = localObject12;
          localObject6 = localObject7;
          localObject7 = localObject9;
          localObject9 = paramObject;
        }
        localObject7 = localObject4;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$1"})
    static final class a
      implements com.tencent.mm.plugin.appbrand.m.h
    {
      a(c.l.a parama, c.o paramo, ai paramai, String paramString, com.tencent.mm.ab.i parami) {}
      
      public final void u(String paramString1, String paramString2)
      {
        AppMethodBeat.i(225190);
        Object localObject = c.JDf;
        Log.e(c.access$getTAG$cp(), "engine " + jdField_this.naX + " exception: " + paramString1 + " \nstackTrace:\n" + paramString2);
        localObject = jdField_this.JEe;
        String str = jdField_this.naX;
        kotlin.g.b.p.g(str, "name");
        kotlin.g.b.p.g(paramString1, "message");
        c.a((c)localObject, str, paramString1, paramString2);
        jdField_this.JEe.JCS.a(b.JCD);
        AppMethodBeat.o(225190);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$2", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$2"})
    static final class b
      extends q
      implements kotlin.g.a.b<c.j, x>
    {
      b(com.tencent.mm.plugin.appbrand.m.g paramg, c.l.a parama, c.o paramo, ai paramai, String paramString, com.tencent.mm.ab.i parami)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$asyncA8Key$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$3"})
    static final class c
      extends kotlin.d.b.a.j
      implements m<ai, kotlin.d.d<? super c.a>, Object>
    {
      Object L$0;
      int label;
      private ai p$;
      
      c(kotlin.d.d paramd, c.l.a parama, c.o paramo, ai paramai, String paramString, com.tencent.mm.ab.i parami)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(82868);
        kotlin.g.b.p.h(paramd, "completion");
        paramd = new c(paramd, this.JEk, jdField_this, paramObject, this.JEm, this.JEn);
        paramd.p$ = ((ai)paramObject);
        AppMethodBeat.o(82868);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82869);
        paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
        AppMethodBeat.o(82869);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(82867);
        kotlin.d.a.a locala = kotlin.d.a.a.SXO;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82867);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.p$;
          c.c(jdField_this.JEh, c.k.JDM);
          Object localObject = jdField_this.JEe;
          String str1 = this.JEm;
          String str2 = jdField_this.JEi.name;
          kotlin.g.b.p.g(str2, "webCompt.name");
          this.L$0 = paramObject;
          this.label = 1;
          localObject = ((c)localObject).b(str1, str2, this);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(82867);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        c.b(jdField_this.JEh, c.k.JDM);
        AppMethodBeat.o(82867);
        return paramObject;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$asyncAppScript$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$4"})
    static final class d
      extends kotlin.d.b.a.j
      implements m<ai, kotlin.d.d<? super o<? extends String, ? extends String>>, Object>
    {
      Object L$0;
      int label;
      private ai p$;
      Object pED;
      
      d(com.tencent.mm.plugin.appbrand.m.g paramg, kotlin.d.d paramd, c.l.a parama, c.o paramo, ai paramai, String paramString, com.tencent.mm.ab.i parami)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(82872);
        kotlin.g.b.p.h(paramd, "completion");
        paramd = new d(this.pAh, paramd, this.JEk, jdField_this, paramObject, this.JEm, this.JEn);
        paramd.p$ = ((ai)paramObject);
        AppMethodBeat.o(82872);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82873);
        paramObject1 = ((d)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
        AppMethodBeat.o(82873);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(82871);
        kotlin.d.a.a locala = kotlin.d.a.a.SXO;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82871);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.p$;
          c.c(jdField_this.JEh, c.k.JDO);
          this.L$0 = paramObject;
          this.pED = this;
          this.label = 1;
          paramObject = new kotlin.d.h(kotlin.d.a.b.e(this));
          Object localObject = (kotlin.d.d)paramObject;
          c.b localb = c.JDf;
          com.tencent.mm.ac.d.b(c.access$getTAG$cp(), (kotlin.g.a.a)new q((kotlin.d.d)localObject) {});
          localObject = paramObject.hxK();
          if (localObject == kotlin.d.a.a.SXO) {
            kotlin.g.b.p.h(this, "frame");
          }
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(82871);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        c.b(jdField_this.JEh, c.k.JDO);
        AppMethodBeat.o(82871);
        return paramObject;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<x>
  {
    q(c paramc, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback", "com/tencent/mm/plugin/webview/webcompt/WebComponent$errReport$1$2$2", "com/tencent/mm/plugin/webview/webcompt/WebComponent$$special$$inlined$let$lambda$1"})
  static final class r
    implements IPCRunCgi.a
  {
    r(c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd)
    {
      AppMethodBeat.i(82879);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        this.JEe.JCS.a(b.JCM);
      }
      AppMethodBeat.o(82879);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/webcompt/WebComponent$getA8Key$2$1$1", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "", "onUrlRedirect", "forceRedirect", "webview-sdk_release", "com/tencent/mm/plugin/webview/webcompt/WebComponent$$special$$inlined$apply$lambda$1"})
  public static final class u
    implements com.tencent.mm.plugin.webview.f.a<bhj>
  {
    u(com.tencent.mm.plugin.webview.f.c paramc, kotlin.d.d paramd, c paramc1, String paramString1, String paramString2) {}
    
    public final void C(int paramInt, String paramString1, String paramString2) {}
    
    public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(82885);
      kotlin.g.b.p.h(paramString1, "reqUrl");
      kotlin.g.b.p.h(paramString2, "errMsg");
      paramString1 = this.JEy;
      paramString2 = (Throwable)new c.j(20001, this.JEz, "getA8Key error:" + paramInt2 + ", " + paramInt3 + ", " + paramString2);
      Result.Companion localCompanion = Result.Companion;
      paramString1.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramString2)));
      this.JEe.JCS.a(b.JCz);
      AppMethodBeat.o(82885);
    }
    
    public final void bx(int paramInt, String paramString)
    {
      AppMethodBeat.i(225194);
      kotlin.g.b.p.h(paramString, "reqUrl");
      AppMethodBeat.o(225194);
    }
    
    public final void by(int paramInt, String paramString)
    {
      AppMethodBeat.i(225193);
      kotlin.g.b.p.h(paramString, "reqUrl");
      AppMethodBeat.o(225193);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"readText", "Lkotlin/Pair;", "", "T", "type", "errCode", "", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "debugType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "invoke", "(Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;)Lkotlin/Pair;"})
  static final class v
    extends q
    implements s<T, String, Integer, c.b.c, c.b.a, o<? extends String, ? extends String>>
  {
    v(c paramc, cel paramcel)
    {
      super();
    }
    
    /* Error */
    private <T> o<String, String> a(T paramT, String paramString, int paramInt, c.b.c paramc, c.b.a parama)
    {
      // Byte code:
      //   0: ldc 73
      //   2: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_2
      //   6: ldc 74
      //   8: invokestatic 80	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: aload 4
      //   13: ldc 81
      //   15: invokestatic 80	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   18: aload 5
      //   20: ldc 82
      //   22: invokestatic 80	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   25: getstatic 86	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   28: astore 6
      //   30: invokestatic 90	com/tencent/mm/plugin/webview/l/c:access$getTAG$cp	()Ljava/lang/String;
      //   33: new 92	java/lang/StringBuilder
      //   36: dup
      //   37: ldc 94
      //   39: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   42: aload_2
      //   43: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   46: ldc 103
      //   48: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   51: aload_1
      //   52: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   55: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   58: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   61: aload_1
      //   62: instanceof 117
      //   65: ifeq +104 -> 169
      //   68: new 119	kotlin/o
      //   71: dup
      //   72: aload_1
      //   73: checkcast 117	com/tencent/mm/vfs/o
      //   76: invokevirtual 122	com/tencent/mm/vfs/o:getAbsolutePath	()Ljava/lang/String;
      //   79: aload_1
      //   80: checkcast 117	com/tencent/mm/vfs/o
      //   83: invokestatic 128	com/tencent/mm/vfs/p:an	(Lcom/tencent/mm/vfs/o;)Ljava/lang/String;
      //   86: invokespecial 131	kotlin/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   89: astore 6
      //   91: aload_0
      //   92: getfield 39	com/tencent/mm/plugin/webview/l/c$v:JEe	Lcom/tencent/mm/plugin/webview/l/c;
      //   95: getfield 135	com/tencent/mm/plugin/webview/l/c:JCS	Lcom/tencent/mm/plugin/webview/l/j;
      //   98: getstatic 141	com/tencent/mm/plugin/webview/l/b:JCB	Lcom/tencent/mm/plugin/webview/l/b;
      //   101: invokevirtual 146	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
      //   104: getstatic 86	com/tencent/mm/plugin/webview/l/c:JDf	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   107: astore 7
      //   109: invokestatic 152	com/tencent/mm/plugin/webview/l/c$b:giV	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   112: getfield 158	com/tencent/mm/plugin/webview/l/c$b$b:JDp	Ljava/util/LinkedList;
      //   115: astore 7
      //   117: aload 6
      //   119: getfield 162	kotlin/o:first	Ljava/lang/Object;
      //   122: astore 8
      //   124: aload 8
      //   126: ldc 164
      //   128: invokestatic 167	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   131: aload 7
      //   133: new 169	com/tencent/mm/plugin/webview/l/c$b$d
      //   136: dup
      //   137: aload 8
      //   139: checkcast 171	java/lang/String
      //   142: invokestatic 174	com/tencent/mm/plugin/webview/l/c:giL	()Ljava/lang/String;
      //   145: ldc 175
      //   147: invokestatic 181	kotlin/n/n:by	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   150: aload 4
      //   152: aload 5
      //   154: invokespecial 184	com/tencent/mm/plugin/webview/l/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;)V
      //   157: invokevirtual 190	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   160: pop
      //   161: ldc 73
      //   163: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   166: aload 6
      //   168: areturn
      //   169: aload_1
      //   170: instanceof 192
      //   173: ifeq +61 -> 234
      //   176: aload_1
      //   177: invokevirtual 195	java/lang/Object:toString	()Ljava/lang/String;
      //   180: astore 6
      //   182: aload_1
      //   183: checkcast 192	java/net/URL
      //   186: astore 7
      //   188: getstatic 201	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
      //   191: astore 8
      //   193: new 119	kotlin/o
      //   196: dup
      //   197: aload 6
      //   199: new 171	java/lang/String
      //   202: dup
      //   203: aload 7
      //   205: invokestatic 207	kotlin/f/d:e	(Ljava/net/URL;)[B
      //   208: aload 8
      //   210: invokespecial 210	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   213: invokespecial 131	kotlin/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   216: astore 6
      //   218: aload_0
      //   219: getfield 39	com/tencent/mm/plugin/webview/l/c$v:JEe	Lcom/tencent/mm/plugin/webview/l/c;
      //   222: getfield 135	com/tencent/mm/plugin/webview/l/c:JCS	Lcom/tencent/mm/plugin/webview/l/j;
      //   225: getstatic 213	com/tencent/mm/plugin/webview/l/b:JCd	Lcom/tencent/mm/plugin/webview/l/b;
      //   228: invokevirtual 146	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
      //   231: goto -140 -> 91
      //   234: new 119	kotlin/o
      //   237: dup
      //   238: ldc 175
      //   240: ldc 175
      //   242: invokespecial 131	kotlin/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   245: astore 6
      //   247: goto -156 -> 91
      //   250: astore 4
      //   252: aload_1
      //   253: instanceof 192
      //   256: ifeq +16 -> 272
      //   259: aload_0
      //   260: getfield 39	com/tencent/mm/plugin/webview/l/c$v:JEe	Lcom/tencent/mm/plugin/webview/l/c;
      //   263: getfield 135	com/tencent/mm/plugin/webview/l/c:JCS	Lcom/tencent/mm/plugin/webview/l/j;
      //   266: getstatic 216	com/tencent/mm/plugin/webview/l/b:JCe	Lcom/tencent/mm/plugin/webview/l/b;
      //   269: invokevirtual 146	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
      //   272: aload_0
      //   273: getfield 39	com/tencent/mm/plugin/webview/l/c$v:JEe	Lcom/tencent/mm/plugin/webview/l/c;
      //   276: getfield 135	com/tencent/mm/plugin/webview/l/c:JCS	Lcom/tencent/mm/plugin/webview/l/j;
      //   279: getstatic 219	com/tencent/mm/plugin/webview/l/b:JCC	Lcom/tencent/mm/plugin/webview/l/b;
      //   282: invokevirtual 146	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
      //   285: aload_0
      //   286: getfield 39	com/tencent/mm/plugin/webview/l/c$v:JEe	Lcom/tencent/mm/plugin/webview/l/c;
      //   289: getfield 135	com/tencent/mm/plugin/webview/l/c:JCS	Lcom/tencent/mm/plugin/webview/l/j;
      //   292: getstatic 222	com/tencent/mm/plugin/webview/l/b:JCg	Lcom/tencent/mm/plugin/webview/l/b;
      //   295: invokevirtual 146	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
      //   298: aload_0
      //   299: getfield 41	com/tencent/mm/plugin/webview/l/c$v:JEi	Lcom/tencent/mm/protocal/protobuf/cel;
      //   302: getfield 228	com/tencent/mm/protocal/protobuf/cel:name	Ljava/lang/String;
      //   305: astore 5
      //   307: aload 5
      //   309: ldc 230
      //   311: invokestatic 167	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   314: new 232	com/tencent/mm/plugin/webview/l/c$j
      //   317: dup
      //   318: iload_3
      //   319: aload 5
      //   321: new 92	java/lang/StringBuilder
      //   324: dup
      //   325: ldc 234
      //   327: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   330: aload_2
      //   331: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   334: ldc 236
      //   336: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   339: aload_1
      //   340: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   343: ldc 103
      //   345: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   348: aload 4
      //   350: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   353: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   356: invokespecial 239	com/tencent/mm/plugin/webview/l/c$j:<init>	(ILjava/lang/String;Ljava/lang/String;)V
      //   359: checkcast 241	java/lang/Throwable
      //   362: astore_1
      //   363: ldc 73
      //   365: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   368: aload_1
      //   369: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	370	0	this	v
      //   0	370	1	paramT	T
      //   0	370	2	paramString	String
      //   0	370	3	paramInt	int
      //   0	370	4	paramc	c.b.c
      //   0	370	5	parama	c.b.a
      //   28	218	6	localObject1	Object
      //   107	97	7	localObject2	Object
      //   122	87	8	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   61	91	250	java/lang/Exception
      //   91	166	250	java/lang/Exception
      //   169	231	250	java/lang/Exception
      //   234	247	250	java/lang/Exception
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class x
    extends q
    implements kotlin.g.a.b<String, x>
  {
    x(c paramc, r paramr)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$refreshA8Key$2$1"})
  static final class y
    extends kotlin.d.b.a.j
    implements m<ai, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    
    y(c.l.a parama, kotlin.d.d paramd, c paramc, kotlin.g.a.b paramb1, kotlin.g.a.b paramb2)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(82895);
      kotlin.g.b.p.h(paramd, "completion");
      paramd = new y(this.JEC, paramd, this.JEe, this.JED, this.JEE);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(82895);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(82896);
      paramObject1 = ((y)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(82896);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(82894);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(82894);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
      }
      try
      {
        c localc = this.JEe;
        String str = this.JEC.JDU;
        this.L$0 = paramObject;
        this.label = 1;
        paramObject = c.a(localc, str, this);
        if (paramObject != locala) {
          break label159;
        }
        AppMethodBeat.o(82894);
        return locala;
      }
      catch (c.j paramObject)
      {
        for (;;)
        {
          this.JEE.invoke(paramObject);
        }
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = (c.a)paramObject;
      this.JED.invoke(c.a(this.JEe, paramObject));
      paramObject = x.SXb;
      AppMethodBeat.o(82894);
      return paramObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "invoke"})
  static final class z
    extends q
    implements kotlin.g.a.a<c.l>
  {
    z(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.c
 * JD-Core Version:    0.7.0.1
 */