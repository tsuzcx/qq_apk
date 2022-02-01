package com.tencent.mm.plugin.webview.l;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.app.o.a;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.protocal.protobuf.fkw;
import com.tencent.mm.protocal.protobuf.fkx;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.aa;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.security.SecureRandom;
import java.util.ArrayList;
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
import kotlin.a.e;
import kotlin.d.f.c;
import kotlin.g.b.aa.f;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.at;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "", "weakJsapi", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Ljava/lang/ref/WeakReference;)V", "inited", "", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "getReporter", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "getWeakJsapi", "()Ljava/lang/ref/WeakReference;", "workerManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "getWorkerManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "workerManager$delegate", "Lkotlin/Lazy;", "appendTags", "", "webCompt", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "cleanMainFrame", "clear", "createJsContext", "appId", "", "url", "launchMainFrame", "dispatchEvent", "event", "message", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluateMainFrame", "script", "callback", "Lkotlin/Function1;", "getA8Key", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "a8KeyUrl", "webComptName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppScript", "Lkotlin/Pair;", "paramsObject", "Lcom/tencent/mm/json/JSONObject;", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "performance", "frontEndPerformance", "postToBack", "postToFront", "refreshA8Key", "onerror", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "onsuccess", "config", "webComptInfo", "configTimeStamps", "", "resume", "end", "step", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "evaluate", "launch", "a8key", "records", "steps", "", "start", "toJson", "A8KeyResp", "Companion", "CreateJSContextException", "PerformanceSteps", "WebComptWorkerManager", "webview-sdk_release"})
public final class c
{
  private static final kotlin.f Pwc;
  private static final String QBE = "webcompt://";
  private static final kotlin.f QBF;
  static final kotlin.f QBG;
  static final kotlin.f QBH;
  private static final kotlin.f QBI;
  private static final kotlin.f QBJ;
  private static String QBK;
  private static final LinkedList<m> QBL;
  private static final kotlin.f QBM;
  private static final String QBN;
  private static final kotlin.f QBO;
  public static final b QBP;
  static final String TAG = "MicroMsg.WebComponent";
  final j QBB;
  private final kotlin.f QBC;
  final WeakReference<com.tencent.mm.plugin.webview.d.h> QBD;
  private boolean jvb;
  
  static
  {
    AppMethodBeat.i(82898);
    QBP = new b((byte)0);
    QBE = "webcompt://";
    TAG = "MicroMsg.WebComponent";
    Pwc = kotlin.g.ar((kotlin.g.a.a)g.QCt);
    QBF = kotlin.g.ar((kotlin.g.a.a)d.QCo);
    QBG = kotlin.g.ar((kotlin.g.a.a)f.QCs);
    QBH = kotlin.g.ar((kotlin.g.a.a)j.QCw);
    QBI = kotlin.g.ar((kotlin.g.a.a)h.QCu);
    QBJ = kotlin.g.ar((kotlin.g.a.a)e.QCq);
    QBK = "";
    QBL = new LinkedList();
    QBM = kotlin.g.ar((kotlin.g.a.a)i.QCv);
    QBN = com.tencent.mm.loader.j.b.aSL() + "webcompt_debug/";
    QBO = kotlin.g.ar((kotlin.g.a.a)c.QCm);
    AppMethodBeat.o(82898);
  }
  
  public c(WeakReference<com.tencent.mm.plugin.webview.d.h> paramWeakReference)
  {
    AppMethodBeat.i(205813);
    this.QBD = paramWeakReference;
    this.QBB = new j();
    b.hcG().clear();
    this.QBC = kotlin.g.ar((kotlin.g.a.a)new aa(this));
    AppMethodBeat.o(205813);
  }
  
  private final String a(a parama)
  {
    AppMethodBeat.i(82905);
    Object localObject3 = parama.QBR;
    Object localObject1 = (com.tencent.mm.plugin.webview.d.h)this.QBD.get();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.webview.d.h)localObject1).getSettings();
      if (localObject1 != null)
      {
        localObject2 = ((aa)localObject1).getUserAgentString();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label51;
        }
      }
    }
    localObject1 = "";
    label51:
    ((Map)localObject3).put("User-agent", localObject1);
    localObject1 = new com.tencent.mm.ad.i((Map)localObject3).toString();
    kotlin.g.b.p.j(localObject1, "JSONObject(httpHeaders.a… \"\"\n        }).toString()");
    Object localObject2 = new StringBuilder("{clientVersion:");
    localObject3 = BuildInfo.CLIENT_VERSION;
    kotlin.g.b.p.j(localObject3, "BuildInfo.CLIENT_VERSION");
    parama = a.bns((String)localObject3) + ",headers:" + (String)localObject1 + ",fullUrl:" + a.bns(parama.pHq) + '}';
    AppMethodBeat.o(82905);
    return parama;
  }
  
  static String a(r paramr, List<? extends l> paramList)
  {
    AppMethodBeat.i(82902);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      localLinkedList.add(String.valueOf(paramr.bV(locall.pQp + "_START", paramr.getStartTime()) - paramr.getStartTime()));
      localLinkedList.add(String.valueOf(paramr.bV(locall.pQp + "_END", paramr.getStartTime()) - paramr.getStartTime()));
    }
    paramr = kotlin.a.j.a((Iterable)localLinkedList, (CharSequence)",", null, (CharSequence)",", 0, null, null, 58) + n.v((CharSequence)"0,", (9 - paramList.size()) * 2);
    AppMethodBeat.o(82902);
    return paramr;
  }
  
  /* Error */
  private final o<String, String> a(com.tencent.mm.ad.i parami, final cnf paramcnf)
  {
    // Byte code:
    //   0: ldc_w 534
    //   3: invokestatic 248	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 362	com/tencent/mm/plugin/webview/l/c:QBB	Lcom/tencent/mm/plugin/webview/l/j;
    //   10: getstatic 540	com/tencent/mm/plugin/webview/l/b:QBj	Lcom/tencent/mm/plugin/webview/l/b;
    //   13: invokevirtual 543	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
    //   16: new 109	com/tencent/mm/plugin/webview/l/c$w
    //   19: dup
    //   20: aload_0
    //   21: aload_2
    //   22: invokespecial 546	com/tencent/mm/plugin/webview/l/c$w:<init>	(Lcom/tencent/mm/plugin/webview/l/c;Lcom/tencent/mm/protocal/protobuf/cnf;)V
    //   25: astore 4
    //   27: getstatic 258	com/tencent/mm/plugin/webview/l/c:TAG	Ljava/lang/String;
    //   30: new 319	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 548
    //   37: invokespecial 433	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: getfield 553	com/tencent/mm/protocal/protobuf/cnf:name	Ljava/lang/String;
    //   44: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 558	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: getstatic 564	com/tencent/mm/plugin/webview/l/g:QDw	Lcom/tencent/mm/plugin/webview/l/g$a;
    //   56: astore 5
    //   58: invokestatic 569	com/tencent/mm/plugin/webview/l/g$a:getDebug	()Z
    //   61: ifeq +77 -> 138
    //   64: getstatic 564	com/tencent/mm/plugin/webview/l/g:QDw	Lcom/tencent/mm/plugin/webview/l/g$a;
    //   67: astore 5
    //   69: invokestatic 575	com/tencent/mm/plugin/webview/l/h:cqu	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   72: ldc_w 577
    //   75: ldc_w 303
    //   78: invokevirtual 583	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 5
    //   83: aload 5
    //   85: ifnonnull +6 -> 91
    //   88: invokestatic 586	kotlin/g/b/p:iCn	()V
    //   91: aload 5
    //   93: checkcast 508	java/lang/CharSequence
    //   96: invokestatic 590	kotlin/n/n:ba	(Ljava/lang/CharSequence;)Z
    //   99: ifne +127 -> 226
    //   102: iconst_1
    //   103: istore_3
    //   104: iload_3
    //   105: ifeq +126 -> 231
    //   108: aload 4
    //   110: new 592	java/net/URL
    //   113: dup
    //   114: aload 5
    //   116: invokespecial 593	java/net/URL:<init>	(Ljava/lang/String;)V
    //   119: ldc_w 595
    //   122: ldc_w 596
    //   125: aconst_null
    //   126: getstatic 600	com/tencent/mm/plugin/webview/l/c$b$a:QBW	Lcom/tencent/mm/plugin/webview/l/c$b$a;
    //   129: iconst_4
    //   130: invokestatic 603	com/tencent/mm/plugin/webview/l/c$w:a	(Lcom/tencent/mm/plugin/webview/l/c$w;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)Lkotlin/o;
    //   133: astore_1
    //   134: aload_1
    //   135: ifnonnull +993 -> 1128
    //   138: aload_2
    //   139: getfield 605	com/tencent/mm/protocal/protobuf/cnf:url	Ljava/lang/String;
    //   142: checkcast 508	java/lang/CharSequence
    //   145: astore_1
    //   146: aload_1
    //   147: ifnull +10 -> 157
    //   150: aload_1
    //   151: invokestatic 590	kotlin/n/n:ba	(Ljava/lang/CharSequence;)Z
    //   154: ifeq +313 -> 467
    //   157: iconst_1
    //   158: istore_3
    //   159: iload_3
    //   160: ifne +28 -> 188
    //   163: aload_2
    //   164: getfield 608	com/tencent/mm/protocal/protobuf/cnf:md5	Ljava/lang/String;
    //   167: checkcast 508	java/lang/CharSequence
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +10 -> 182
    //   175: aload_1
    //   176: invokestatic 590	kotlin/n/n:ba	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +293 -> 472
    //   182: iconst_1
    //   183: istore_3
    //   184: iload_3
    //   185: ifeq +292 -> 477
    //   188: aload_2
    //   189: getfield 553	com/tencent/mm/protocal/protobuf/cnf:name	Ljava/lang/String;
    //   192: astore_1
    //   193: aload_1
    //   194: ldc_w 610
    //   197: invokestatic 428	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   200: new 68	com/tencent/mm/plugin/webview/l/c$k
    //   203: dup
    //   204: sipush 21001
    //   207: aload_1
    //   208: ldc_w 612
    //   211: invokespecial 615	com/tencent/mm/plugin/webview/l/c$k:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   214: checkcast 533	java/lang/Throwable
    //   217: astore_1
    //   218: ldc_w 534
    //   221: invokestatic 346	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload_1
    //   225: athrow
    //   226: iconst_0
    //   227: istore_3
    //   228: goto -124 -> 104
    //   231: aload_1
    //   232: new 319	java/lang/StringBuilder
    //   235: dup
    //   236: ldc_w 617
    //   239: invokespecial 433	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   242: aload_2
    //   243: getfield 553	com/tencent/mm/protocal/protobuf/cnf:name	Ljava/lang/String;
    //   246: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokevirtual 621	com/tencent/mm/ad/i:has	(Ljava/lang/String;)Z
    //   255: ifeq +71 -> 326
    //   258: aload 4
    //   260: new 592	java/net/URL
    //   263: dup
    //   264: aload_1
    //   265: new 319	java/lang/StringBuilder
    //   268: dup
    //   269: ldc_w 617
    //   272: invokespecial 433	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload_2
    //   276: getfield 553	com/tencent/mm/protocal/protobuf/cnf:name	Ljava/lang/String;
    //   279: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokevirtual 623	com/tencent/mm/ad/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokespecial 593	java/net/URL:<init>	(Ljava/lang/String;)V
    //   291: new 319	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 625
    //   298: invokespecial 433	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: aload_2
    //   302: getfield 553	com/tencent/mm/protocal/protobuf/cnf:name	Ljava/lang/String;
    //   305: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: ldc_w 626
    //   314: aconst_null
    //   315: getstatic 629	com/tencent/mm/plugin/webview/l/c$b$a:QBT	Lcom/tencent/mm/plugin/webview/l/c$b$a;
    //   318: iconst_4
    //   319: invokestatic 603	com/tencent/mm/plugin/webview/l/c$w:a	(Lcom/tencent/mm/plugin/webview/l/c$w;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)Lkotlin/o;
    //   322: astore_1
    //   323: goto -189 -> 134
    //   326: aload_1
    //   327: ldc_w 577
    //   330: invokevirtual 621	com/tencent/mm/ad/i:has	(Ljava/lang/String;)Z
    //   333: ifeq +37 -> 370
    //   336: aload 4
    //   338: new 592	java/net/URL
    //   341: dup
    //   342: aload_1
    //   343: ldc_w 577
    //   346: invokevirtual 623	com/tencent/mm/ad/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   349: invokespecial 593	java/net/URL:<init>	(Ljava/lang/String;)V
    //   352: ldc_w 631
    //   355: ldc_w 632
    //   358: aconst_null
    //   359: getstatic 629	com/tencent/mm/plugin/webview/l/c$b$a:QBT	Lcom/tencent/mm/plugin/webview/l/c$b$a;
    //   362: iconst_4
    //   363: invokestatic 603	com/tencent/mm/plugin/webview/l/c$w:a	(Lcom/tencent/mm/plugin/webview/l/c$w;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)Lkotlin/o;
    //   366: astore_1
    //   367: goto -233 -> 134
    //   370: new 634	com/tencent/mm/vfs/q
    //   373: dup
    //   374: new 319	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   381: aload_2
    //   382: getfield 553	com/tencent/mm/protocal/protobuf/cnf:name	Ljava/lang/String;
    //   385: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: ldc_w 636
    //   391: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 639	com/tencent/mm/plugin/webview/l/c$b:bnv	(Ljava/lang/String;)Ljava/lang/String;
    //   400: invokespecial 640	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   403: invokevirtual 643	com/tencent/mm/vfs/q:ifE	()Z
    //   406: ifeq +56 -> 462
    //   409: aload 4
    //   411: new 634	com/tencent/mm/vfs/q
    //   414: dup
    //   415: new 319	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   422: aload_2
    //   423: getfield 553	com/tencent/mm/protocal/protobuf/cnf:name	Ljava/lang/String;
    //   426: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc_w 636
    //   432: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 639	com/tencent/mm/plugin/webview/l/c$b:bnv	(Ljava/lang/String;)Ljava/lang/String;
    //   441: invokespecial 640	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   444: ldc_w 645
    //   447: ldc_w 646
    //   450: aconst_null
    //   451: getstatic 649	com/tencent/mm/plugin/webview/l/c$b$a:QBU	Lcom/tencent/mm/plugin/webview/l/c$b$a;
    //   454: iconst_4
    //   455: invokestatic 603	com/tencent/mm/plugin/webview/l/c$w:a	(Lcom/tencent/mm/plugin/webview/l/c$w;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)Lkotlin/o;
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
    //   477: new 634	com/tencent/mm/vfs/q
    //   480: dup
    //   481: new 319	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   488: aload_2
    //   489: invokestatic 652	com/tencent/mm/plugin/webview/l/c$b:a	(Lcom/tencent/mm/protocal/protobuf/cnf;)Ljava/lang/String;
    //   492: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: ldc_w 636
    //   498: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokespecial 640	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   507: invokevirtual 643	com/tencent/mm/vfs/q:ifE	()Z
    //   510: ifeq +180 -> 690
    //   513: aload 4
    //   515: new 634	com/tencent/mm/vfs/q
    //   518: dup
    //   519: new 319	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   526: aload_2
    //   527: invokestatic 652	com/tencent/mm/plugin/webview/l/c$b:a	(Lcom/tencent/mm/protocal/protobuf/cnf;)Ljava/lang/String;
    //   530: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc_w 636
    //   536: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokespecial 640	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   545: ldc_w 654
    //   548: sipush 21004
    //   551: getstatic 658	com/tencent/mm/plugin/webview/l/c$b$c:QCd	Lcom/tencent/mm/plugin/webview/l/c$b$c;
    //   554: aconst_null
    //   555: bipush 8
    //   557: invokestatic 603	com/tencent/mm/plugin/webview/l/c$w:a	(Lcom/tencent/mm/plugin/webview/l/c$w;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)Lkotlin/o;
    //   560: astore_1
    //   561: aload_0
    //   562: getfield 362	com/tencent/mm/plugin/webview/l/c:QBB	Lcom/tencent/mm/plugin/webview/l/j;
    //   565: getstatic 661	com/tencent/mm/plugin/webview/l/b:QAI	Lcom/tencent/mm/plugin/webview/l/b;
    //   568: invokevirtual 543	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
    //   571: getstatic 258	com/tencent/mm/plugin/webview/l/c:TAG	Ljava/lang/String;
    //   574: new 319	java/lang/StringBuilder
    //   577: dup
    //   578: ldc_w 663
    //   581: invokespecial 433	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   584: aload_2
    //   585: getfield 553	com/tencent/mm/protocal/protobuf/cnf:name	Ljava/lang/String;
    //   588: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 558	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: aload_1
    //   598: getfield 669	kotlin/o:My	Ljava/lang/Object;
    //   601: checkcast 494	java/lang/String
    //   604: invokevirtual 672	java/lang/String:length	()I
    //   607: iconst_1
    //   608: if_icmple +508 -> 1116
    //   611: getstatic 258	com/tencent/mm/plugin/webview/l/c:TAG	Ljava/lang/String;
    //   614: astore 4
    //   616: new 319	java/lang/StringBuilder
    //   619: dup
    //   620: ldc_w 674
    //   623: invokespecial 433	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   626: aload_2
    //   627: getfield 553	com/tencent/mm/protocal/protobuf/cnf:name	Ljava/lang/String;
    //   630: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: bipush 10
    //   635: invokevirtual 456	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   638: astore_2
    //   639: aload_1
    //   640: getfield 669	kotlin/o:My	Ljava/lang/Object;
    //   643: checkcast 494	java/lang/String
    //   646: astore 5
    //   648: bipush 100
    //   650: aload_1
    //   651: getfield 669	kotlin/o:My	Ljava/lang/Object;
    //   654: checkcast 494	java/lang/String
    //   657: invokevirtual 672	java/lang/String:length	()I
    //   660: iconst_1
    //   661: isub
    //   662: invokestatic 680	java/lang/Math:min	(II)I
    //   665: istore_3
    //   666: aload 5
    //   668: ifnonnull +417 -> 1085
    //   671: new 682	kotlin/t
    //   674: dup
    //   675: ldc_w 684
    //   678: invokespecial 685	kotlin/t:<init>	(Ljava/lang/String;)V
    //   681: astore_1
    //   682: ldc_w 534
    //   685: invokestatic 346	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   688: aload_1
    //   689: athrow
    //   690: new 592	java/net/URL
    //   693: dup
    //   694: aload_2
    //   695: getfield 605	com/tencent/mm/protocal/protobuf/cnf:url	Ljava/lang/String;
    //   698: invokespecial 593	java/net/URL:<init>	(Ljava/lang/String;)V
    //   701: astore 5
    //   703: getstatic 258	com/tencent/mm/plugin/webview/l/c:TAG	Ljava/lang/String;
    //   706: ldc_w 687
    //   709: aload 5
    //   711: invokestatic 690	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   714: invokevirtual 693	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   717: invokestatic 695	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: aload 5
    //   722: invokevirtual 699	java/net/URL:openStream	()Ljava/io/InputStream;
    //   725: checkcast 701	java/io/Closeable
    //   728: astore 6
    //   730: aconst_null
    //   731: astore 4
    //   733: aload 6
    //   735: checkcast 703	java/io/InputStream
    //   738: astore_1
    //   739: aload_1
    //   740: ldc_w 705
    //   743: invokestatic 428	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   746: aload_1
    //   747: invokestatic 711	kotlin/f/a:S	(Ljava/io/InputStream;)[B
    //   750: astore_1
    //   751: aload_2
    //   752: getfield 608	com/tencent/mm/protocal/protobuf/cnf:md5	Ljava/lang/String;
    //   755: new 713	java/io/ByteArrayInputStream
    //   758: dup
    //   759: aload_1
    //   760: invokespecial 716	java/io/ByteArrayInputStream:<init>	([B)V
    //   763: checkcast 703	java/io/InputStream
    //   766: aload_1
    //   767: arraylength
    //   768: invokestatic 721	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   771: invokestatic 725	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   774: ifeq +161 -> 935
    //   777: new 634	com/tencent/mm/vfs/q
    //   780: dup
    //   781: new 319	java/lang/StringBuilder
    //   784: dup
    //   785: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   788: aload_2
    //   789: invokestatic 652	com/tencent/mm/plugin/webview/l/c$b:a	(Lcom/tencent/mm/protocal/protobuf/cnf;)Ljava/lang/String;
    //   792: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: ldc_w 636
    //   798: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokespecial 640	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   807: astore 7
    //   809: aload 7
    //   811: invokevirtual 728	com/tencent/mm/vfs/q:ifA	()Ljava/lang/String;
    //   814: astore 8
    //   816: aload 8
    //   818: ifnonnull +6 -> 824
    //   821: invokestatic 586	kotlin/g/b/p:iCn	()V
    //   824: new 634	com/tencent/mm/vfs/q
    //   827: dup
    //   828: aload 8
    //   830: invokespecial 640	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   833: invokevirtual 731	com/tencent/mm/vfs/q:ifL	()Z
    //   836: pop
    //   837: aload 7
    //   839: invokevirtual 734	com/tencent/mm/vfs/q:ifM	()Z
    //   842: pop
    //   843: aload 7
    //   845: aload_1
    //   846: invokestatic 739	com/tencent/mm/vfs/r:b	(Lcom/tencent/mm/vfs/q;[B)V
    //   849: invokestatic 366	com/tencent/mm/plugin/webview/l/c$b:hcG	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
    //   852: getfield 742	com/tencent/mm/plugin/webview/l/c$b$b:QBZ	Ljava/util/LinkedList;
    //   855: astore 7
    //   857: aload 5
    //   859: invokevirtual 743	java/net/URL:toString	()Ljava/lang/String;
    //   862: astore 8
    //   864: aload 8
    //   866: ldc_w 745
    //   869: invokestatic 428	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   872: aload 7
    //   874: new 21	com/tencent/mm/plugin/webview/l/c$b$d
    //   877: dup
    //   878: aload 8
    //   880: getstatic 748	com/tencent/mm/plugin/webview/l/c$b$c:QCe	Lcom/tencent/mm/plugin/webview/l/c$b$c;
    //   883: aconst_null
    //   884: iconst_4
    //   885: invokespecial 751	com/tencent/mm/plugin/webview/l/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)V
    //   888: invokevirtual 502	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   891: pop
    //   892: new 665	kotlin/o
    //   895: dup
    //   896: aload 5
    //   898: invokevirtual 743	java/net/URL:toString	()Ljava/lang/String;
    //   901: new 494	java/lang/String
    //   904: dup
    //   905: aload_1
    //   906: getstatic 757	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   909: invokespecial 760	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   912: invokespecial 763	kotlin/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   915: astore_1
    //   916: aload_0
    //   917: getfield 362	com/tencent/mm/plugin/webview/l/c:QBB	Lcom/tencent/mm/plugin/webview/l/j;
    //   920: getstatic 766	com/tencent/mm/plugin/webview/l/b:QAJ	Lcom/tencent/mm/plugin/webview/l/b;
    //   923: invokevirtual 543	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
    //   926: aload 6
    //   928: aconst_null
    //   929: invokestatic 771	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   932: goto -361 -> 571
    //   935: aload_0
    //   936: getfield 362	com/tencent/mm/plugin/webview/l/c:QBB	Lcom/tencent/mm/plugin/webview/l/j;
    //   939: getstatic 774	com/tencent/mm/plugin/webview/l/b:QAO	Lcom/tencent/mm/plugin/webview/l/b;
    //   942: invokevirtual 543	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
    //   945: aload_2
    //   946: getfield 553	com/tencent/mm/protocal/protobuf/cnf:name	Ljava/lang/String;
    //   949: astore_1
    //   950: aload_1
    //   951: ldc_w 610
    //   954: invokestatic 428	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   957: new 68	com/tencent/mm/plugin/webview/l/c$k
    //   960: dup
    //   961: sipush 21003
    //   964: aload_1
    //   965: ldc_w 776
    //   968: aload 5
    //   970: invokestatic 690	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   973: invokevirtual 693	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   976: invokespecial 615	com/tencent/mm/plugin/webview/l/c$k:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   979: checkcast 533	java/lang/Throwable
    //   982: astore_1
    //   983: ldc_w 534
    //   986: invokestatic 346	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   989: aload_1
    //   990: athrow
    //   991: astore 4
    //   993: ldc_w 534
    //   996: invokestatic 346	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   999: aload 4
    //   1001: athrow
    //   1002: astore_1
    //   1003: aload 6
    //   1005: aload 4
    //   1007: invokestatic 771	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   1010: ldc_w 534
    //   1013: invokestatic 346	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1016: aload_1
    //   1017: athrow
    //   1018: astore_1
    //   1019: aload_2
    //   1020: getfield 553	com/tencent/mm/protocal/protobuf/cnf:name	Ljava/lang/String;
    //   1023: astore_2
    //   1024: aload_2
    //   1025: ldc_w 610
    //   1028: invokestatic 428	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1031: new 68	com/tencent/mm/plugin/webview/l/c$k
    //   1034: dup
    //   1035: sipush 21002
    //   1038: aload_2
    //   1039: new 319	java/lang/StringBuilder
    //   1042: dup
    //   1043: ldc_w 778
    //   1046: invokespecial 433	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1049: aload_1
    //   1050: invokevirtual 781	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1053: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: ldc_w 783
    //   1059: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: aload 5
    //   1064: invokevirtual 786	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1067: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1070: invokespecial 615	com/tencent/mm/plugin/webview/l/c$k:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   1073: checkcast 533	java/lang/Throwable
    //   1076: astore_1
    //   1077: ldc_w 534
    //   1080: invokestatic 346	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1083: aload_1
    //   1084: athrow
    //   1085: aload 5
    //   1087: iconst_0
    //   1088: iload_3
    //   1089: invokevirtual 790	java/lang/String:substring	(II)Ljava/lang/String;
    //   1092: astore 5
    //   1094: aload 5
    //   1096: ldc_w 792
    //   1099: invokestatic 428	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1102: aload 4
    //   1104: aload_2
    //   1105: aload 5
    //   1107: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1113: invokestatic 695	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1116: ldc_w 534
    //   1119: invokestatic 346	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1122: aload_1
    //   1123: areturn
    //   1124: astore_1
    //   1125: goto -122 -> 1003
    //   1128: goto -557 -> 571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1131	0	this	c
    //   0	1131	1	parami	com.tencent.mm.ad.i
    //   0	1131	2	paramcnf	cnf
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
  
  private static void a(com.tencent.mm.plugin.appbrand.m.g paramg, cnf paramcnf, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(205806);
    Object localObject = n.QCR;
    localObject = new StringBuilder("WeixinWebCompt.config({resume:").append(paramBoolean).append(", debug:");
    g.a locala = g.QDw;
    c(paramg, g.a.getDebug() + ", iframeUrlPattern:'" + (String)QBF.getValue() + "', configFinishTs:" + paramLong + ", bizReportId:" + paramcnf.TuL + ", options:" + paramcnf.TuM + "})");
    Log.i(TAG, "WeixinWebCompt.config:" + paramcnf.TuM);
    AppMethodBeat.o(205806);
  }
  
  static void a(r paramr, l paraml)
  {
    AppMethodBeat.i(82901);
    paramr.bU(paraml.pQp + "_START", System.currentTimeMillis());
    AppMethodBeat.o(82901);
  }
  
  static void c(com.tencent.mm.plugin.appbrand.m.g paramg, String paramString)
  {
    AppMethodBeat.i(205808);
    paramg.evaluateJavascript(paramString, null);
    AppMethodBeat.o(205808);
  }
  
  public static final String getScheme()
  {
    return QBE;
  }
  
  public static final void hcE()
  {
    AppMethodBeat.i(82923);
    b.Dy(false);
    AppMethodBeat.o(82923);
  }
  
  private final void q(final String paramString, final kotlin.g.a.b<? super String, x> paramb)
  {
    AppMethodBeat.i(82912);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u(this, paramString, paramb));
    AppMethodBeat.o(82912);
  }
  
  public final void bd(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(205810);
    kotlin.g.b.p.k(paramString1, "webCompt");
    kotlin.g.b.p.k(paramString2, "event");
    if (Util.isNullOrNil(paramString2))
    {
      Log.w(TAG, "dispatch event is null");
      AppMethodBeat.o(205810);
      return;
    }
    Log.v(TAG, "dispatch event=%s, value=%s", new Object[] { paramString2, paramString3 });
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new r(this, paramString1, paramString2, paramString3));
    this.QBB.a(b.QBw);
    AppMethodBeat.o(205810);
  }
  
  public final com.tencent.mm.plugin.appbrand.m.g bnt(String paramString)
  {
    AppMethodBeat.i(205811);
    kotlin.g.b.p.k(paramString, "webCompt");
    paramString = (c.m.a)hct().get(paramString);
    if (paramString != null)
    {
      paramString = paramString.hcK();
      AppMethodBeat.o(205811);
      return paramString;
    }
    AppMethodBeat.o(205811);
    return null;
  }
  
  public final void clear()
  {
    int i;
    for (;;)
    {
      Object localObject2;
      c.m.a locala;
      try
      {
        AppMethodBeat.i(82900);
        b.hcG().clear();
        if (!this.jvb) {
          break label339;
        }
        m localm = hct();
        j localj = this.QBB;
        kotlin.g.b.p.k(localj, "reporter");
        Log.i(TAG, "clear workerManager#" + localm.id);
        Iterator localIterator = localm.entrySet().iterator();
        i = -1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator.next();
        locala = (c.m.a)((Map.Entry)localObject2).getValue();
        if ((!locala.Al) && (locala.QCH) && (!localm.QCG.containsKey(((Map.Entry)localObject2).getKey())))
        {
          locala.QCj = true;
          locala.QCL = null;
          Log.i(TAG, "WebComptWorker.recycle " + locala.appId + '@' + locala.QCO.name + ':' + locala.QCN);
          ((Map)localm.QCG).put(((Map.Entry)localObject2).getKey(), locala);
          localj.a(b.QBy);
          continue;
        }
        if (locala.Al) {
          break label279;
        }
      }
      finally {}
      if (locala.QCN == localObject1.QCE)
      {
        i = localObject1.QCE;
      }
      else
      {
        label279:
        localObject2 = locala.QCP;
        String str = locala.QCO.name;
        kotlin.g.b.p.j(str, "webComptInfo.name");
        ((c)localObject2).bd(str, "onWebComptDestroy", "{}");
        locala.hcK().destroy();
      }
    }
    localObject1.QCE = i;
    localObject1.clear();
    label339:
    AppMethodBeat.o(82900);
  }
  
  final m hct()
  {
    AppMethodBeat.i(82899);
    m localm = (m)this.QBC.getValue();
    AppMethodBeat.o(82899);
    return localm;
  }
  
  public final void hcu()
  {
    AppMethodBeat.i(205812);
    if (this.jvb)
    {
      a(this, "window.WeixinOpenTags && window.WeixinOpenTags.onClean()");
      this.QBB.a(b.QAV);
    }
    AppMethodBeat.o(205812);
  }
  
  public final void j(final String paramString1, final String paramString2, final String paramString3, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(82910);
    kotlin.g.b.p.k(paramString1, "webCompt");
    kotlin.g.b.p.k(paramString2, "errMsg");
    c.m.a locala = (c.m.a)hct().get(paramString1);
    if (locala != null)
    {
      fkw localfkw = new fkw();
      localfkw.fHW = paramString2;
      localfkw.UJl = paramString3;
      localfkw.UJm = paramInt1;
      localfkw.UJn = paramInt2;
      Object localObject = (com.tencent.mm.plugin.webview.d.h)this.QBD.get();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.webview.d.h)localObject).getSettings();
        if (localObject != null)
        {
          String str = ((aa)localObject).getUserAgentString();
          localObject = str;
          if (str != null) {
            break label123;
          }
        }
      }
      localObject = "";
      label123:
      localfkw.UGj = ((String)localObject);
      localfkw.sNY = locala.sNY;
      localfkw.appid = locala.appId;
      localfkw.UJo = paramString1;
      localfkw.UJp = b.hcF().getVersion();
      localfkw.UJq = locala.QCJ;
      localfkw.UJr = locala.QCK;
      this.QBB.a(b.QBu);
      localObject = new d.a();
      ((d.a)localObject).c((com.tencent.mm.cd.a)localfkw);
      ((d.a)localObject).d((com.tencent.mm.cd.a)new fkx());
      ((d.a)localObject).TW("/cgi-bin/mmbiz-bin/webcompt/reportjserr");
      ((d.a)localObject).vD(2914);
      ((d.a)localObject).vF(0);
      ((d.a)localObject).vG(0);
      IPCRunCgi.a(((d.a)localObject).bgN(), (IPCRunCgi.a)new s(this, paramString2, paramString3, paramInt1, paramInt2, paramString1));
      AppMethodBeat.o(82910);
      return;
    }
    AppMethodBeat.o(82910);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "", "a8key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "fullUrl", "", "httpHeaders", "", "(Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;Ljava/lang/String;Ljava/util/Map;)V", "getFullUrl", "()Ljava/lang/String;", "getHttpHeaders", "()Ljava/util/Map;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "webview-sdk_release"})
  public static final class a
  {
    final com.tencent.mm.plugin.webview.f.c QBQ;
    final Map<String, String> QBR;
    final String pHq;
    
    public a(com.tencent.mm.plugin.webview.f.c paramc, String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(206468);
      this.QBQ = paramc;
      this.pHq = paramString;
      this.QBR = paramMap;
      AppMethodBeat.o(206468);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "invoke"})
  static final class aa
    extends kotlin.g.b.q
    implements kotlin.g.a.a<c.m>
  {
    aa(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion;", "", "()V", "PREFIX_DEBUG_PATH", "", "TAG", "getTAG$webview_sdk_release", "()Ljava/lang/String;", "_cachedFilePath", "debugInfo", "getDebugInfo", "debugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "getDebugger", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "debugger$delegate", "Lkotlin/Lazy;", "iframeUrlPattern", "getIframeUrlPattern", "iframeUrlPattern$delegate", "manager", "com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$2$1", "getManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$2$1;", "manager$delegate", "matrix", "", "", "getMatrix", "()Ljava/util/List;", "matrix$delegate", "meta", "Lcom/tencent/mm/json/JSONObject;", "getMeta", "()Lcom/tencent/mm/json/JSONObject;", "meta$delegate", "pauseOnBackForeground", "", "getPauseOnBackForeground", "()Z", "pauseOnBackForeground$delegate", "preloadWorkers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "scheme", "scheme$annotations", "getScheme", "scriptManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "getScriptManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "scriptManager$delegate", "skeleton", "getSkeleton", "skeleton$delegate", "debugPath", "getDebugPath", "(Ljava/lang/String;)Ljava/lang/String;", "savePath", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getSavePath", "(Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;)Ljava/lang/String;", "version", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "clearDebugPath", "", "jsapiOnly", "appOnly", "getCachedFilePath", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedfilePathInMain", "getLocalScript", "path", "scripts", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScript", "initBackForegroundListener", "preloadWorker", "force", "readText", "DebugType", "Debugger", "ResType", "Script", "ScriptManager", "Worker", "webview-sdk_release"})
  public static final class b
  {
    public static void Dy(boolean paramBoolean)
    {
      AppMethodBeat.i(82822);
      if (c.hcw().size() < 3)
      {
        if (paramBoolean) {
          break label50;
        }
        if (((Collection)c.hcw()).isEmpty()) {
          break label45;
        }
      }
      label45:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(82822);
        return;
      }
      label50:
      kotlinx.coroutines.g.b((ak)br.abxo, (kotlin.d.f)bc.iRs(), (kotlin.g.a.m)new k(null), 2);
      AppMethodBeat.o(82822);
    }
    
    static String a(cnf paramcnf)
    {
      AppMethodBeat.i(205168);
      paramcnf = com.tencent.mm.loader.j.b.aSD() + "webcompt/" + paramcnf.name + '/' + paramcnf.md5;
      AppMethodBeat.o(205168);
      return paramcnf;
    }
    
    static String bnv(String paramString)
    {
      AppMethodBeat.i(82828);
      paramString = c.hcv() + paramString;
      AppMethodBeat.o(82828);
      return paramString;
    }
    
    static int c(com.tencent.mm.plugin.appbrand.appcache.p paramp)
    {
      AppMethodBeat.i(205167);
      try
      {
        localb = c.QBP;
        paramp = c(paramp, "/meta.json");
        if (((CharSequence)paramp).length() != 0) {
          break label98;
        }
        i = 1;
      }
      catch (Exception paramp)
      {
        for (;;)
        {
          b localb = c.QBP;
          Log.e(c.access$getTAG$cp(), "parse IWxaPkg.version Error:" + paramp.getMessage());
          int i = 0;
          continue;
          i = 0;
        }
      }
      if (i != 0)
      {
        AppMethodBeat.o(205167);
        return 0;
      }
      i = new com.tencent.mm.ad.i(paramp).optInt("version");
      AppMethodBeat.o(205167);
      return i;
    }
    
    /* Error */
    private static String c(com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc_w 273
      //   5: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: aload_1
      //   10: invokeinterface 279 2 0
      //   15: astore_0
      //   16: aload_0
      //   17: ifnull +62 -> 79
      //   20: aload_0
      //   21: checkcast 281	java/io/Closeable
      //   24: astore_3
      //   25: new 283	java/lang/String
      //   28: dup
      //   29: aload_3
      //   30: checkcast 285	java/io/InputStream
      //   33: invokestatic 291	kotlin/f/a:S	(Ljava/io/InputStream;)[B
      //   36: getstatic 297	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
      //   39: invokespecial 300	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   42: astore_0
      //   43: aload_3
      //   44: aconst_null
      //   45: invokestatic 305	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   48: ldc_w 273
      //   51: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: aload_0
      //   55: areturn
      //   56: astore_1
      //   57: ldc_w 273
      //   60: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   63: aload_1
      //   64: athrow
      //   65: astore_0
      //   66: aload_3
      //   67: aload_1
      //   68: invokestatic 305	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   71: ldc_w 273
      //   74: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   77: aload_0
      //   78: athrow
      //   79: ldc_w 273
      //   82: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   85: ldc_w 306
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
    
    public static String eTh()
    {
      AppMethodBeat.i(82831);
      Object localObject = c.QBP;
      localObject = hcG();
      StringBuilder localStringBuilder = new StringBuilder("\n            [debug]\n            debug: ");
      g.a locala = g.QDw;
      localObject = n.bHx(g.a.getDebug() + "\n\n            [lib]\n            version: " + ((b)localObject).QCb + "\n            res: " + ((b)localObject).QCa + "\n\n            " + kotlin.a.j.a((Iterable)((b)localObject).QBZ, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n\n            " + kotlin.a.j.a((Iterable)((b)localObject).QBY, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n            ");
      AppMethodBeat.o(82831);
      return localObject;
    }
    
    /* Error */
    static String g(String paramString, LinkedList<d> paramLinkedList)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc_w 388
      //   5: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 259	com/tencent/mm/plugin/webview/l/c:access$getTAG$cp	()Ljava/lang/String;
      //   11: ldc_w 390
      //   14: iconst_1
      //   15: anewarray 4	java/lang/Object
      //   18: dup
      //   19: iconst_0
      //   20: aload_0
      //   21: aastore
      //   22: invokestatic 393	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   25: getstatic 335	com/tencent/mm/plugin/webview/l/g:QDw	Lcom/tencent/mm/plugin/webview/l/g$a;
      //   28: astore_3
      //   29: invokestatic 340	com/tencent/mm/plugin/webview/l/g$a:getDebug	()Z
      //   32: ifeq +181 -> 213
      //   35: new 314	com/tencent/mm/vfs/q
      //   38: dup
      //   39: ldc_w 395
      //   42: aload_0
      //   43: invokestatic 399	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   46: invokevirtual 402	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   49: invokestatic 404	com/tencent/mm/plugin/webview/l/c$b:bnv	(Ljava/lang/String;)Ljava/lang/String;
      //   52: invokespecial 317	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
      //   55: astore_3
      //   56: aload_3
      //   57: invokevirtual 407	com/tencent/mm/vfs/q:ifE	()Z
      //   60: ifeq +38 -> 98
      //   63: aload_1
      //   64: ifnull +21 -> 85
      //   67: aload_1
      //   68: new 17	com/tencent/mm/plugin/webview/l/c$b$d
      //   71: dup
      //   72: aload_0
      //   73: aconst_null
      //   74: getstatic 411	com/tencent/mm/plugin/webview/l/c$b$a:QBU	Lcom/tencent/mm/plugin/webview/l/c$b$a;
      //   77: iconst_2
      //   78: invokespecial 414	com/tencent/mm/plugin/webview/l/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)V
      //   81: invokevirtual 418	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   84: pop
      //   85: aload_3
      //   86: invokestatic 424	com/tencent/mm/vfs/r:ak	(Lcom/tencent/mm/vfs/q;)Ljava/lang/String;
      //   89: astore_0
      //   90: ldc_w 388
      //   93: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   96: aload_0
      //   97: areturn
      //   98: new 314	com/tencent/mm/vfs/q
      //   101: dup
      //   102: ldc_w 426
      //   105: invokestatic 404	com/tencent/mm/plugin/webview/l/c$b:bnv	(Ljava/lang/String;)Ljava/lang/String;
      //   108: invokespecial 317	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
      //   111: astore_3
      //   112: aload_3
      //   113: invokevirtual 407	com/tencent/mm/vfs/q:ifE	()Z
      //   116: ifeq +97 -> 213
      //   119: aload_1
      //   120: ifnull +21 -> 141
      //   123: aload_1
      //   124: new 17	com/tencent/mm/plugin/webview/l/c$b$d
      //   127: dup
      //   128: aload_0
      //   129: aconst_null
      //   130: getstatic 429	com/tencent/mm/plugin/webview/l/c$b$a:QBV	Lcom/tencent/mm/plugin/webview/l/c$b$a;
      //   133: iconst_2
      //   134: invokespecial 414	com/tencent/mm/plugin/webview/l/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)V
      //   137: invokevirtual 418	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   140: pop
      //   141: new 431	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   144: dup
      //   145: aload_3
      //   146: invokespecial 433	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Lcom/tencent/mm/vfs/q;)V
      //   149: checkcast 281	java/io/Closeable
      //   152: astore_3
      //   153: aload_3
      //   154: checkcast 431	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   157: astore_1
      //   158: aload_1
      //   159: invokevirtual 436	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:bGl	()Z
      //   162: pop
      //   163: getstatic 236	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   166: astore 4
      //   168: aload_1
      //   169: checkcast 275	com/tencent/mm/plugin/appbrand/appcache/p
      //   172: aload_0
      //   173: invokestatic 241	com/tencent/mm/plugin/webview/l/c$b:c	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
      //   176: astore_0
      //   177: aload_3
      //   178: aconst_null
      //   179: invokestatic 305	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   182: ldc_w 388
      //   185: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   188: aload_0
      //   189: areturn
      //   190: astore_1
      //   191: ldc_w 388
      //   194: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   197: aload_1
      //   198: athrow
      //   199: astore_0
      //   200: aload_3
      //   201: aload_1
      //   202: invokestatic 305	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   205: ldc_w 388
      //   208: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   211: aload_0
      //   212: athrow
      //   213: invokestatic 440	com/tencent/mm/plugin/webview/l/c$b:hcF	()Lcom/tencent/mm/plugin/webview/l/c$b$e;
      //   216: astore_2
      //   217: aload_0
      //   218: ldc_w 441
      //   221: invokestatic 447	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
      //   224: getstatic 236	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   227: astore_3
      //   228: aload_2
      //   229: getfield 451	com/tencent/mm/plugin/webview/l/c$b$e:Puv	Lcom/tencent/mm/plugin/appbrand/appcache/p;
      //   232: aload_0
      //   233: invokestatic 241	com/tencent/mm/plugin/webview/l/c$b:c	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
      //   236: astore_2
      //   237: aload_1
      //   238: ifnull +28 -> 266
      //   241: getstatic 236	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   244: astore_3
      //   245: aload_1
      //   246: new 17	com/tencent/mm/plugin/webview/l/c$b$d
      //   249: dup
      //   250: aload_0
      //   251: invokestatic 327	com/tencent/mm/plugin/webview/l/c$b:hcG	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   254: getfield 358	com/tencent/mm/plugin/webview/l/c$b$b:QCa	Lcom/tencent/mm/plugin/webview/l/c$b$c;
      //   257: aconst_null
      //   258: iconst_4
      //   259: invokespecial 414	com/tencent/mm/plugin/webview/l/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/l/c$b$c;Lcom/tencent/mm/plugin/webview/l/c$b$a;I)V
      //   262: invokevirtual 418	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   265: pop
      //   266: ldc_w 388
      //   269: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    static e hcF()
    {
      AppMethodBeat.i(82827);
      Object localObject = c.hcC();
      b localb = c.QBP;
      localObject = (e)((kotlin.f)localObject).getValue();
      AppMethodBeat.o(82827);
      return localObject;
    }
    
    static b hcG()
    {
      AppMethodBeat.i(82830);
      Object localObject = c.hcD();
      b localb = c.QBP;
      localObject = (b)((kotlin.f)localObject).getValue();
      AppMethodBeat.o(82830);
      return localObject;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "", "(Ljava/lang/String;I)V", "NA", "PARAM", "SDCARD", "SDCARD_PKG", "COMMAND", "webview-sdk_release"})
    static enum a
    {
      static
      {
        AppMethodBeat.i(82775);
        a locala1 = new a("NA", 0);
        QBS = locala1;
        a locala2 = new a("PARAM", 1);
        QBT = locala2;
        a locala3 = new a("SDCARD", 2);
        QBU = locala3;
        a locala4 = new a("SDCARD_PKG", 3);
        QBV = locala4;
        a locala5 = new a("COMMAND", 4);
        QBW = locala5;
        QBX = new a[] { locala1, locala2, locala3, locala4, locala5 };
        AppMethodBeat.o(82775);
      }
      
      private a() {}
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "", "()V", "isPreload", "", "()Z", "setPreload", "(Z)V", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "setResType", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;)V", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "verion", "", "getVerion", "()I", "setVerion", "(I)V", "workers", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "getWorkers", "clear", "", "webview-sdk_release"})
    static final class b
    {
      final LinkedList<c.b.f> QBY;
      final LinkedList<c.b.d> QBZ;
      c.b.c QCa;
      int QCb;
      boolean ooW;
      
      public b()
      {
        AppMethodBeat.i(82780);
        this.QBY = new LinkedList();
        this.QBZ = new LinkedList();
        this.QCa = c.b.c.QCc;
        AppMethodBeat.o(82780);
      }
      
      public final void a(c.b.c paramc)
      {
        AppMethodBeat.i(82778);
        kotlin.g.b.p.k(paramc, "<set-?>");
        this.QCa = paramc;
        AppMethodBeat.o(82778);
      }
      
      public final void clear()
      {
        AppMethodBeat.i(82779);
        this.QBY.clear();
        this.QBZ.clear();
        AppMethodBeat.o(82779);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "", "(Ljava/lang/String;I)V", "NA", "CACHE", "NETWORK", "ASSETS", "webview-sdk_release"})
    static enum c
    {
      static
      {
        AppMethodBeat.i(82781);
        c localc1 = new c("NA", 0);
        QCc = localc1;
        c localc2 = new c("CACHE", 1);
        QCd = localc2;
        c localc3 = new c("NETWORK", 2);
        QCe = localc3;
        c localc4 = new c("ASSETS", 3);
        QCf = localc4;
        QCg = new c[] { localc1, localc2, localc3, localc4 };
        AppMethodBeat.o(82781);
      }
      
      private c() {}
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "", "uri", "", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "debugType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;)V", "getDebugType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getUri", "()Ljava/lang/String;", "toString", "webview-sdk_release"})
    static final class d
    {
      private final c.b.c QCa;
      private final c.b.a QCh;
      private final String uri;
      
      public d(String paramString, c.b.c paramc, c.b.a parama)
      {
        AppMethodBeat.i(82785);
        this.uri = paramString;
        this.QCa = paramc;
        this.QCh = parama;
        AppMethodBeat.o(82785);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(82784);
        StringBuilder localStringBuilder = new StringBuilder("[script]\n                ");
        if (this.QCa != c.b.c.QCc) {}
        for (String str = "resType: " + this.QCa;; str = "debugType: " + this.QCh)
        {
          str = n.bHx(str + "\n                " + this.uri + "\n                ");
          AppMethodBeat.o(82784);
          return str;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)V", "version", "", "getVersion", "()I", "version$delegate", "Lkotlin/Lazy;", "getScript", "", "path", "webview-sdk_release"})
    static final class e
    {
      final com.tencent.mm.plugin.appbrand.appcache.p Puv;
      private final kotlin.f Pwd;
      
      public e(com.tencent.mm.plugin.appbrand.appcache.p paramp)
      {
        AppMethodBeat.i(82790);
        this.Puv = paramp;
        this.Pwd = kotlin.g.ar((kotlin.g.a.a)new a(this));
        AppMethodBeat.o(82790);
      }
      
      public final int getVersion()
      {
        AppMethodBeat.i(82789);
        int i = ((Number)this.Pwd.getValue()).intValue();
        AppMethodBeat.o(82789);
        return i;
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
      static final class a
        extends kotlin.g.b.q
        implements kotlin.g.a.a<Integer>
      {
        a(c.b.e parame)
        {
          super();
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "", "id", "", "isPreload", "", "isRecycled", "(IZZ)V", "getId", "()I", "()Z", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "toString", "", "webview-sdk_release"})
    static final class f
    {
      final LinkedList<c.b.d> QBZ;
      private final boolean QCj;
      private final int id;
      private final boolean ooW;
      
      private f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
      {
        AppMethodBeat.i(82792);
        this.id = paramInt;
        this.ooW = paramBoolean1;
        this.QCj = paramBoolean2;
        this.QBZ = new LinkedList();
        AppMethodBeat.o(82792);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(82791);
        String str = n.bHx("[worker #" + this.id + "]\n                preload: " + this.ooW + "\n                recycled: " + this.QCj + "\n\n                " + kotlin.a.j.a((Iterable)this.QBZ, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n                ");
        AppMethodBeat.o(82791);
        return str;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"deleteChildJs", "", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
    static final class g
      extends kotlin.g.b.q
      implements kotlin.g.a.b<com.tencent.mm.vfs.q, x>
    {
      public static final g QCk;
      
      static
      {
        AppMethodBeat.i(82798);
        QCk = new g();
        AppMethodBeat.o(82798);
      }
      
      g()
      {
        super();
      }
      
      public static void Z(com.tencent.mm.vfs.q paramq)
      {
        AppMethodBeat.i(175715);
        kotlin.g.b.p.k(paramq, "$this$deleteChildJs");
        paramq = paramq.a((com.tencent.mm.vfs.s)1.QCl);
        if (paramq == null) {
          kotlin.g.b.p.iCn();
        }
        kotlin.g.b.p.j(paramq, "listFiles { filter ->\n  …on\"))\n                }!!");
        int j = paramq.length;
        int i = 0;
        while (i < j)
        {
          paramq[i].cFq();
          i += 1;
        }
        AppMethodBeat.o(175715);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
    static final class h<InputType, ResultType>
      implements com.tencent.mm.ipcinvoker.d<IPCVoid, IPCString>
    {
      public static final h QCn;
      
      static
      {
        AppMethodBeat.i(82802);
        QCn = new h();
        AppMethodBeat.o(82802);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
    static final class i
      extends kotlin.g.b.q
      implements kotlin.g.a.b<IPCString, x>
    {
      i(kotlin.d.d paramd)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$initBackForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "isPaused", "", "()Z", "setPaused", "(Z)V", "onAppBackground", "", "activity", "", "onAppForeground", "webview-sdk_release"})
    public static final class j
      extends o.a
    {
      boolean isPaused;
      
      public final void onAppBackground(String paramString)
      {
        AppMethodBeat.i(206691);
        com.tencent.mm.ae.d.a(10000L, (kotlin.g.a.a)new a(this));
        AppMethodBeat.o(206691);
      }
      
      public final void onAppForeground(String paramString)
      {
        AppMethodBeat.i(206689);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
        AppMethodBeat.o(206689);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
      static final class a
        extends kotlin.g.b.q
        implements kotlin.g.a.a<x>
      {
        a(c.b.j paramj)
        {
          super();
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
      static final class b
        extends kotlin.g.b.q
        implements kotlin.g.a.a<x>
      {
        b(c.b.j paramj)
        {
          super();
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class k
      extends kotlin.d.b.a.j
      implements kotlin.g.a.m<ak, kotlin.d.d<? super x>, Object>
    {
      Object L$0;
      int label;
      private ak p$;
      
      k(kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(82813);
        kotlin.g.b.p.k(paramd, "completion");
        paramd = new k(paramd);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(82813);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82814);
        paramObject1 = ((k)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
        AppMethodBeat.o(82814);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(82812);
        Object localObject = kotlin.d.a.a.aaAA;
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
          localb = c.QBP;
          this.L$0 = paramObject;
          this.label = 1;
          if (c.b.h(this) == localObject)
          {
            AppMethodBeat.o(82812);
            return localObject;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = new c.m();
        if (paramObject.QCE == -1)
        {
          localObject = c.QBP;
          localObject = c.b.hcH();
          localb = c.QBP;
          paramObject.QCE = ((c.e.1)localObject).create(c.b.g("/wxwebcompt.js", paramObject.QCF.QBZ));
          localObject = c.QBP;
          Log.i(c.access$getTAG$cp(), "preload workerManager#" + paramObject.id);
        }
        for (;;)
        {
          c.hcw().offerFirst(paramObject);
          paramObject = x.aazN;
          AppMethodBeat.o(82812);
          return paramObject;
          localObject = c.QBP;
          Log.w(c.access$getTAG$cp(), "preload twice #" + paramObject.id);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<c.b.b>
  {
    public static final c QCm;
    
    static
    {
      AppMethodBeat.i(82800);
      QCm = new c();
      AppMethodBeat.o(82800);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    public static final d QCo;
    
    static
    {
      AppMethodBeat.i(82805);
      QCo = new d();
      AppMethodBeat.o(82805);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$2$1", "invoke", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$2$1;"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<1>
  {
    public static final e QCq;
    
    static
    {
      AppMethodBeat.i(205924);
      QCq = new e();
      AppMethodBeat.o(205924);
    }
    
    e()
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a QCr;
      
      static
      {
        AppMethodBeat.i(207187);
        QCr = new a();
        AppMethodBeat.o(207187);
      }
      
      public final void run()
      {
        AppMethodBeat.i(207186);
        Object localObject = c.QBP;
        localObject = c.hcz();
        c.b localb = c.QBP;
        if (((Boolean)((kotlin.f)localObject).getValue()).booleanValue()) {
          new c.b.j().alive();
        }
        AppMethodBeat.o(207186);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<List<? extends Integer>>
  {
    public static final f QCs;
    
    static
    {
      AppMethodBeat.i(82809);
      QCs = new f();
      AppMethodBeat.o(82809);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.ad.i>
  {
    public static final g QCt;
    
    static
    {
      AppMethodBeat.i(82811);
      QCt = new g();
      AppMethodBeat.o(82811);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final h QCu;
    
    static
    {
      AppMethodBeat.i(206957);
      QCu = new h();
      AppMethodBeat.o(206957);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<c.b.e>
  {
    public static final i QCv;
    
    static
    {
      AppMethodBeat.i(82816);
      QCv = new i();
      AppMethodBeat.o(82816);
    }
    
    i()
    {
      super();
    }
    
    /* Error */
    private static c.b.e hcJ()
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
      //   19: invokevirtual 63	com/tencent/mm/plugin/appbrand/appcache/f:bGl	()Z
      //   22: pop
      //   23: getstatic 67	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   26: astore_3
      //   27: aload_2
      //   28: checkcast 69	com/tencent/mm/plugin/appbrand/appcache/p
      //   31: invokestatic 75	com/tencent/mm/plugin/webview/l/c$b:c	(Lcom/tencent/mm/plugin/appbrand/appcache/p;)I
      //   34: istore_1
      //   35: invokestatic 79	com/tencent/mm/plugin/webview/l/c:hcB	()Ljava/lang/String;
      //   38: checkcast 81	java/lang/CharSequence
      //   41: invokestatic 87	kotlin/n/n:ba	(Ljava/lang/CharSequence;)Z
      //   44: ifne +119 -> 163
      //   47: iconst_1
      //   48: istore_0
      //   49: iload_0
      //   50: ifeq +118 -> 168
      //   53: invokestatic 79	com/tencent/mm/plugin/webview/l/c:hcB	()Ljava/lang/String;
      //   56: invokestatic 93	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
      //   59: ifeq +109 -> 168
      //   62: new 95	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   65: dup
      //   66: invokestatic 79	com/tencent/mm/plugin/webview/l/c:hcB	()Ljava/lang/String;
      //   69: invokespecial 98	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
      //   72: astore_3
      //   73: aload_3
      //   74: invokevirtual 99	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:bGl	()Z
      //   77: pop
      //   78: getstatic 67	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   81: astore 4
      //   83: aload_3
      //   84: checkcast 69	com/tencent/mm/plugin/appbrand/appcache/p
      //   87: invokestatic 75	com/tencent/mm/plugin/webview/l/c$b:c	(Lcom/tencent/mm/plugin/appbrand/appcache/p;)I
      //   90: istore_0
      //   91: iload_0
      //   92: iload_1
      //   93: if_icmple +75 -> 168
      //   96: getstatic 67	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   99: astore 4
      //   101: invokestatic 102	com/tencent/mm/plugin/webview/l/c:access$getTAG$cp	()Ljava/lang/String;
      //   104: ldc 104
      //   106: iload_0
      //   107: invokestatic 110	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   110: invokevirtual 114	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   113: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   116: getstatic 67	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   119: astore 4
      //   121: invokestatic 123	com/tencent/mm/plugin/webview/l/c$b:hcG	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   124: getstatic 129	com/tencent/mm/plugin/webview/l/c$b$c:QCe	Lcom/tencent/mm/plugin/webview/l/c$b$c;
      //   127: invokevirtual 135	com/tencent/mm/plugin/webview/l/c$b$b:a	(Lcom/tencent/mm/plugin/webview/l/c$b$c;)V
      //   130: getstatic 67	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   133: astore 4
      //   135: invokestatic 123	com/tencent/mm/plugin/webview/l/c$b:hcG	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   138: iload_0
      //   139: putfield 139	com/tencent/mm/plugin/webview/l/c$b$b:QCb	I
      //   142: aload_3
      //   143: astore_2
      //   144: new 141	com/tencent/mm/plugin/webview/l/c$b$e
      //   147: dup
      //   148: aload_2
      //   149: checkcast 69	com/tencent/mm/plugin/appbrand/appcache/p
      //   152: invokespecial 144	com/tencent/mm/plugin/webview/l/c$b$e:<init>	(Lcom/tencent/mm/plugin/appbrand/appcache/p;)V
      //   155: astore_2
      //   156: ldc 46
      //   158: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   161: aload_2
      //   162: areturn
      //   163: iconst_0
      //   164: istore_0
      //   165: goto -116 -> 49
      //   168: getstatic 67	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   171: astore_3
      //   172: invokestatic 102	com/tencent/mm/plugin/webview/l/c:access$getTAG$cp	()Ljava/lang/String;
      //   175: ldc 146
      //   177: iload_1
      //   178: invokestatic 110	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   181: invokevirtual 114	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   184: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   187: getstatic 67	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   190: astore_3
      //   191: invokestatic 123	com/tencent/mm/plugin/webview/l/c$b:hcG	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   194: getstatic 149	com/tencent/mm/plugin/webview/l/c$b$c:QCf	Lcom/tencent/mm/plugin/webview/l/c$b$c;
      //   197: invokevirtual 135	com/tencent/mm/plugin/webview/l/c$b$b:a	(Lcom/tencent/mm/plugin/webview/l/c$b$c;)V
      //   200: getstatic 67	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   203: astore_3
      //   204: invokestatic 123	com/tencent/mm/plugin/webview/l/c$b:hcG	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   207: iload_1
      //   208: putfield 139	com/tencent/mm/plugin/webview/l/c$b$b:QCb	I
      //   211: goto -67 -> 144
      //   214: astore_3
      //   215: getstatic 67	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   218: astore 4
      //   220: invokestatic 102	com/tencent/mm/plugin/webview/l/c:access$getTAG$cp	()Ljava/lang/String;
      //   223: new 151	java/lang/StringBuilder
      //   226: dup
      //   227: ldc 153
      //   229: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   232: aload_3
      //   233: invokevirtual 157	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   236: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   239: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   242: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   245: new 169	com/tencent/mm/plugin/webview/l/j
      //   248: dup
      //   249: invokespecial 170	com/tencent/mm/plugin/webview/l/j:<init>	()V
      //   252: getstatic 176	com/tencent/mm/plugin/webview/l/b:QBx	Lcom/tencent/mm/plugin/webview/l/b;
      //   255: invokevirtual 179	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    public static final j QCw;
    
    static
    {
      AppMethodBeat.i(82818);
      QCw = new j();
      AppMethodBeat.o(82818);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "retCode", "", "webComptName", "", "errMsg", "(ILjava/lang/String;Ljava/lang/String;)V", "toJsonString", "webview-sdk_release"})
  public static final class k
    extends Exception
  {
    final String QCx;
    final String errMsg;
    final int retCode;
    
    public k(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(82842);
      this.retCode = paramInt;
      this.QCx = paramString1;
      this.errMsg = paramString2;
      AppMethodBeat.o(82842);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "", "stepName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStepName", "()Ljava/lang/String;", "STEP_CREATE_JS_CXT", "STEP_EVAL_MAIN_FRAME", "STEP_GET_A8KEY", "STEP_FETCH_WORKER", "STEP_GET_APP_SCRIPT", "webview-sdk_release"})
  static enum l
  {
    final String pQp;
    
    static
    {
      AppMethodBeat.i(82843);
      l locall1 = new l("STEP_CREATE_JS_CXT", 0, "createJsContext");
      QCy = locall1;
      l locall2 = new l("STEP_EVAL_MAIN_FRAME", 1, "evalMainFrame");
      QCz = locall2;
      l locall3 = new l("STEP_GET_A8KEY", 2, "GetA8Key");
      QCA = locall3;
      l locall4 = new l("STEP_FETCH_WORKER", 3, "FetchWorker");
      QCB = locall4;
      l locall5 = new l("STEP_GET_APP_SCRIPT", 4, "GetAppScript");
      QCC = locall5;
      QCD = new l[] { locall1, locall2, locall3, locall4, locall5 };
      AppMethodBeat.o(82843);
    }
    
    private l(String paramString)
    {
      this.pQp = paramString;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "Lkotlin/collections/HashMap;", "()V", "id", "", "getId", "()I", "preloadDebugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "preloadId", "recycleWorkers", "fetch", "appId", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "preload", "", "recycle", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "WebComptWorker", "webview-sdk_release"})
  static final class m
    extends HashMap<String, a>
  {
    int QCE;
    c.b.f QCF;
    final HashMap<String, a> QCG;
    final int id;
    
    public m()
    {
      AppMethodBeat.i(82849);
      this.id = ((int)(System.currentTimeMillis() % 1000L));
      this.QCE = -1;
      this.QCF = new c.b.f(this.id, true, false, 4);
      this.QCG = new HashMap();
      AppMethodBeat.o(82849);
    }
    
    public final a a(String paramString, cnf paramcnf, c paramc)
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(211990);
          kotlin.g.b.p.k(paramString, "appId");
          kotlin.g.b.p.k(paramcnf, "webComptInfo");
          kotlin.g.b.p.k(paramc, "webCompt");
          String str = paramcnf.name;
          if (this.QCG.containsKey(str))
          {
            localObject = (a)this.QCG.get(str);
            if ((localObject != null) && (kotlin.g.b.p.h(((a)localObject).appId, paramString)))
            {
              this.QCG.remove(str);
              paramString = (Map)this;
              kotlin.g.b.p.j(str, "webComptName");
              kotlin.g.b.p.j(localObject, "it");
              paramString.put(str, localObject);
              paramString = c.QBP;
              c.b.hcG().QBY.add(new c.b.f(this.id, false, true, 2));
              AppMethodBeat.o(211990);
              paramString = (String)localObject;
              return paramString;
            }
          }
          if (this.QCE != -1) {
            bool = true;
          }
          if (bool == true)
          {
            paramString = c.QBP;
            Log.i(c.access$getTAG$cp(), "use preload workerManager#" + this.id);
            paramString = this.QCF;
            localObject = c.QBP;
            c.b.hcG().QBY.add(paramString);
            localObject = c.QBP;
            c.b.hcG().ooW = bool;
            if (bool == true)
            {
              i = this.QCE;
              paramString = new a(i, paramcnf, paramc);
              this.QCE = -1;
              paramcnf = (Map)this;
              kotlin.g.b.p.j(str, "webComptName");
              paramcnf.put(str, paramString);
              AppMethodBeat.o(211990);
            }
          }
          else
          {
            paramString = c.QBP;
            Log.i(c.access$getTAG$cp(), "create new workerManager#" + this.id);
            paramString = new c.b.f(this.id, false, false, 4);
            continue;
          }
          localObject = c.QBP;
        }
        finally {}
        Object localObject = c.b.hcH();
        c.b localb = c.QBP;
        int i = ((c.e.1)localObject).create(c.b.g("/wxwebcompt.js", paramString.QBZ));
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "", "workerId", "", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;ILcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;)V", "a8KeyUrl", "", "getA8KeyUrl", "()Ljava/lang/String;", "setA8KeyUrl", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "appScriptMD5", "getAppScriptMD5", "setAppScriptMD5", "appScriptUrl", "getAppScriptUrl", "setAppScriptUrl", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "getEngine", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "isRecycled", "", "()Z", "setRecycled", "(Z)V", "jsapi", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "setJsapi", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;)V", "launched", "getLaunched", "setLaunched", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "setPerformanceHelper", "(Lcom/tencent/mm/pluginsdk/PerformanceHelper;)V", "refer", "getRefer", "setRefer", "used", "getUsed", "setUsed", "getWebCompt", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "getWebComptInfo", "()Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getWorkerId", "()I", "recycle", "", "reuse", "webview-sdk_release"})
    public final class a
    {
      boolean Al;
      boolean QCH;
      String QCI;
      String QCJ;
      String QCK;
      r QCL;
      i QCM;
      final int QCN;
      final cnf QCO;
      final c QCP;
      boolean QCj;
      String appId;
      String sNY;
      
      public a(cnf paramcnf, c paramc)
      {
        AppMethodBeat.i(82848);
        this.QCN = paramcnf;
        this.QCO = paramc;
        this.QCP = localObject;
        this.appId = "";
        this.sNY = "";
        this.QCI = "";
        this.QCJ = "";
        this.QCK = "";
        this$1 = this.QCP;
        paramc = this.QCO.name;
        kotlin.g.b.p.j(paramc, "webComptInfo.name");
        this.QCM = new i(c.m.this, paramc);
        hcK().addJavascriptInterface(this.QCM, "__webcompt");
        AppMethodBeat.o(82848);
      }
      
      public final void bnw(String paramString)
      {
        AppMethodBeat.i(82846);
        kotlin.g.b.p.k(paramString, "<set-?>");
        this.QCJ = paramString;
        AppMethodBeat.o(82846);
      }
      
      public final com.tencent.mm.plugin.appbrand.m.g hcK()
      {
        AppMethodBeat.i(206547);
        Object localObject = c.QBP;
        localObject = c.b.hcH().Bx(this.QCN);
        kotlin.g.b.p.j(localObject, "manager.getJsContext(workerId)");
        AppMethodBeat.o(206547);
        return localObject;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"toJsonStringArray", "", "", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.b<List<? extends String>, String>
  {
    public static final n QCR;
    
    static
    {
      AppMethodBeat.i(82862);
      QCR = new n();
      AppMethodBeat.o(82862);
    }
    
    n()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"})
  public static final class o
    extends kotlin.d.a
    implements CoroutineExceptionHandler
  {
    public o(f.c paramc, c paramc1, aa.f paramf)
    {
      super();
    }
    
    public final void handleException(kotlin.d.f paramf, Throwable paramThrowable)
    {
      AppMethodBeat.i(82863);
      this.QCS.QBB.a(b.QBb);
      if ((paramThrowable instanceof c.k))
      {
        ((kotlin.g.a.b)this.QCT.aaBC).invoke(paramThrowable);
        AppMethodBeat.o(82863);
        return;
      }
      AppMethodBeat.o(82863);
      throw paramThrowable;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class p
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    Object pGq;
    Object pGr;
    Object rdb;
    Object sPl;
    Object sPm;
    Object sPn;
    Object sPo;
    Object sPp;
    Object sPq;
    
    p(c paramc, boolean paramBoolean, r paramr, String paramString1, cnf paramcnf, String paramString2, String paramString3, aa.f paramf, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(82875);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new p(this.QCS, this.QCU, this.QCV, this.piM, this.QCW, this.qbm, this.cBD, this.QCX, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(82875);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(82876);
      paramObject1 = ((p)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(82876);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(82874);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      Object localObject1;
      Object localObject5;
      Object localObject2;
      Object localObject4;
      label385:
      Object localObject3;
      label436:
      label725:
      label763:
      Object localObject6;
      label826:
      label831:
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
        localObject1 = c.QBP;
        this.L$0 = paramObject;
        this.label = 1;
        if (c.b.h(this) == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
        }
      case 1: 
        localObject1 = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
        if (this.QCU) {
          c.a(this.QCS, this.QCV);
        }
        localObject5 = new com.tencent.mm.ad.i();
        localObject1 = g.QDw;
        if (g.a.getDebug())
        {
          localObject1 = ((Iterable)n.a((CharSequence)n.pz(this.piM, "#"), new String[] { "&" })).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = n.a((CharSequence)((Iterator)localObject1).next(), new String[] { "=" });
            if (((List)localObject2).size() == 2) {
              try
              {
                ((com.tencent.mm.ad.i)localObject5).g((String)((List)localObject2).get(0), URLDecoder.decode((String)((List)localObject2).get(1), "UTF-8"));
              }
              catch (Exception localException)
              {
                localObject4 = c.QBP;
                Log.e(c.access$getTAG$cp(), "parse paramsObject '" + (String)((List)localObject2).get(0) + "' exception: " + localException);
              }
            }
          }
        }
        localObject1 = g.QDw;
        if (g.a.getDebug())
        {
          localObject1 = g.QDw;
          localObject1 = h.cqu().getString("debugA8Key", "");
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          if (!n.ba((CharSequence)localObject1))
          {
            i = 1;
            if (i == 0) {
              break label725;
            }
            localObject1 = new o(localObject1, c.b.a.QBW);
            if (localObject1 == null) {
              break label763;
            }
            localObject2 = (String)((o)localObject1).Mx;
            localObject1 = (c.b.a)((o)localObject1).My;
            localObject3 = c.QBP;
            c.b.hcG().QBZ.add(new c.b.d((String)localObject2, null, (c.b.a)localObject1, 2));
            localObject1 = localObject2;
            localObject2 = c.QBP;
            Log.d(c.access$getTAG$cp(), "createJsContext a8key:".concat(String.valueOf(localObject1)));
            c.b(this.QCV, c.l.QCy);
            localObject2 = c.QBP;
            Log.i(c.access$getTAG$cp(), "createJsContext init " + this.qbm);
            c.c(this.QCV, c.l.QCB);
            localObject2 = c.a(this.QCS).a(this.cBD, this.QCW, this.QCS);
            c.b(this.QCV, c.l.QCB);
            localObject3 = this.piM;
            kotlin.g.b.p.k(localObject3, "<set-?>");
            ((c.m.a)localObject2).sNY = ((String)localObject3);
            ((c.m.a)localObject2).QCL = this.QCV;
            localObject3 = this.cBD;
            kotlin.g.b.p.k(localObject3, "appId");
            if ((!((c.m.a)localObject2).QCj) || (!kotlin.g.b.p.h(((c.m.a)localObject2).appId, localObject3))) {
              break label826;
            }
            ((c.m.a)localObject2).QCj = false;
            localObject4 = c.QBP;
            Log.i(c.access$getTAG$cp(), "WebComptWorker.reuse " + (String)localObject3 + '@' + ((c.m.a)localObject2).QCO.name + ':' + ((c.m.a)localObject2).QCN);
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label831;
          }
          c.b(((c.m.a)localObject2).hcK(), this.QCW, this.QCV.getStartTime());
          this.QCS.QBB.a(b.QBz);
          paramObject = x.aazN;
          AppMethodBeat.o(82874);
          return paramObject;
          i = 0;
          break;
          if (((com.tencent.mm.ad.i)localObject5).has("debugA8Key"))
          {
            localObject1 = new o(((com.tencent.mm.ad.i)localObject5).getString("debugA8Key"), c.b.a.QBT);
            break label385;
          }
          localObject1 = null;
          break label385;
          localObject1 = new StringBuilder();
          localObject2 = c.QBP;
          localObject1 = c.hcx() + this.qbm + "?appId=" + this.cBD + "&src=" + a.bnr(this.piM);
          break label436;
        }
        localObject3 = this.cBD;
        kotlin.g.b.p.k(localObject3, "<set-?>");
        ((c.m.a)localObject2).appId = ((String)localObject3);
        kotlin.g.b.p.k(localObject1, "<set-?>");
        ((c.m.a)localObject2).QCI = ((String)localObject1);
        localObject3 = this.QCW.md5;
        kotlin.g.b.p.j(localObject3, "webCompt.md5");
        kotlin.g.b.p.k(localObject3, "<set-?>");
        ((c.m.a)localObject2).QCK = ((String)localObject3);
        localObject3 = this.QCW.url;
        kotlin.g.b.p.j(localObject3, "webCompt.url");
        ((c.m.a)localObject2).bnw((String)localObject3);
        localObject6 = ((c.m.a)localObject2).hcK();
        ((com.tencent.mm.plugin.appbrand.m.g)localObject6).setJsExceptionHandler((com.tencent.mm.plugin.appbrand.m.h)new a((c.m.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ad.i)localObject5));
        this.QCX.aaBC = ((kotlin.g.a.b)new b((com.tencent.mm.plugin.appbrand.m.g)localObject6, (c.m.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ad.i)localObject5));
        c.a((com.tencent.mm.plugin.appbrand.m.g)localObject6, this.QCW, this.QCV.getStartTime());
        localObject3 = kotlinx.coroutines.g.a(paramObject, paramObject.getCoroutineContext(), (kotlin.g.a.m)new c(null, (c.m.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ad.i)localObject5), 2);
        localObject4 = kotlinx.coroutines.g.a(paramObject, paramObject.getCoroutineContext(), (kotlin.g.a.m)new d((com.tencent.mm.plugin.appbrand.m.g)localObject6, null, (c.m.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ad.i)localObject5), 2);
        this.L$0 = paramObject;
        this.oDA = localObject5;
        this.pGq = localObject1;
        this.pGr = localObject2;
        this.rdb = localObject6;
        this.sPl = localObject6;
        this.sPm = localObject3;
        this.sPn = localObject4;
        this.label = 2;
        localObject8 = ((at)localObject4).n(this);
        if (localObject8 == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
        }
        break;
      case 2: 
        localObject4 = (at)this.sPn;
        localObject3 = (at)this.sPm;
        localObject7 = (com.tencent.mm.plugin.appbrand.m.g)this.sPl;
        localObject6 = (com.tencent.mm.plugin.appbrand.m.g)this.rdb;
        localObject2 = (c.m.a)this.pGr;
        localObject1 = (String)this.pGq;
        localObject9 = (com.tencent.mm.ad.i)this.oDA;
        localObject8 = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject5 = paramObject;
        paramObject = localObject8;
        localObject8 = localObject5;
        localObject5 = localObject9;
      }
      for (;;)
      {
        localObject8 = (o)localObject8;
        Object localObject12 = (String)((o)localObject8).Mx;
        localObject9 = (String)((o)localObject8).My;
        ((c.m.a)localObject2).bnw((String)localObject12);
        c.d((com.tencent.mm.plugin.appbrand.m.g)localObject7, "(function(WeixinWebCompt){" + (String)localObject9 + "})(WeixinWebCompt);");
        this.L$0 = paramObject;
        this.oDA = localObject5;
        this.pGq = localObject1;
        this.pGr = localObject2;
        this.rdb = localObject6;
        this.sPl = localObject7;
        this.sPm = localObject3;
        this.sPn = localObject4;
        this.sPo = localObject12;
        this.sPp = localObject9;
        this.label = 3;
        Object localObject11 = ((at)localObject3).n(this);
        Object localObject10;
        if (localObject11 == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
          localObject9 = (String)this.sPp;
          localObject11 = (String)this.sPo;
          localObject4 = (at)this.sPn;
          localObject3 = (at)this.sPm;
          localObject6 = (com.tencent.mm.plugin.appbrand.m.g)this.sPl;
          localObject7 = (com.tencent.mm.plugin.appbrand.m.g)this.rdb;
          localObject2 = (c.m.a)this.pGr;
          localObject1 = (String)this.pGq;
          localObject8 = (com.tencent.mm.ad.i)this.oDA;
          localObject10 = (ak)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject5 = paramObject;
          paramObject = localObject10;
          localObject10 = localObject5;
          localObject5 = localObject11;
        }
        for (;;)
        {
          localObject10 = (c.a)localObject10;
          localObject11 = ((c.m.a)localObject2).QCM;
          localObject12 = ((c.a)localObject10).QBQ.bly(((c.a)localObject10).pHq);
          if (localObject12 == null) {
            kotlin.g.b.p.iCn();
          }
          kotlin.g.b.p.k(localObject12, "<set-?>");
          ((i)localObject11).PvI = ((JsapiPermissionWrapper)localObject12);
          c.a(this.QCS, (com.tencent.mm.plugin.appbrand.m.g)localObject6, (c.a)localObject10);
          ((c.m.a)localObject2).QCH = true;
          this.L$0 = paramObject;
          this.oDA = localObject8;
          this.pGq = localObject1;
          this.pGr = localObject2;
          this.rdb = localObject7;
          this.sPl = localObject6;
          this.sPm = localObject3;
          this.sPn = localObject4;
          this.sPo = localObject5;
          this.sPp = localObject9;
          this.sPq = localObject10;
          this.label = 4;
          if (aw.a(1000L, this) == locala)
          {
            AppMethodBeat.o(82874);
            return locala;
            ResultKt.throwOnFailure(paramObject);
          }
          paramObject = c.QBP;
          c.b.Dy(true);
          this.QCS.QBB.a(b.QBe);
          paramObject = c.QBP;
          Log.d(c.access$getTAG$cp(), "createJsContext init finish " + this.qbm);
          paramObject = c.QBP;
          if (c.b.hcG().ooW) {
            this.QCS.QBB.a(b.QBf);
          }
          paramObject = x.aazN;
          AppMethodBeat.o(82874);
          return paramObject;
          localObject8 = localObject6;
          localObject10 = localObject5;
          localObject5 = localObject12;
          localObject6 = localObject7;
          localObject7 = localObject8;
          localObject8 = localObject10;
          localObject10 = localObject11;
        }
        localObject7 = localObject6;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$1"})
    static final class a
      implements com.tencent.mm.plugin.appbrand.m.h
    {
      a(c.m.a parama, c.p paramp, ak paramak, String paramString, com.tencent.mm.ad.i parami) {}
      
      public final void A(String paramString1, String paramString2)
      {
        AppMethodBeat.i(205891);
        Object localObject = c.QBP;
        Log.e(c.access$getTAG$cp(), "engine " + jdField_this.qbm + " exception: " + paramString1 + " \nstackTrace:\n" + paramString2);
        localObject = jdField_this.QCS;
        String str = jdField_this.qbm;
        kotlin.g.b.p.j(str, "name");
        kotlin.g.b.p.j(paramString1, "message");
        c.a((c)localObject, str, paramString1, paramString2);
        jdField_this.QCS.QBB.a(b.QBm);
        AppMethodBeat.o(205891);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$2", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$2"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.b<c.k, x>
    {
      b(com.tencent.mm.plugin.appbrand.m.g paramg, c.m.a parama, c.p paramp, ak paramak, String paramString, com.tencent.mm.ad.i parami)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$asyncA8Key$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$3"})
    static final class c
      extends kotlin.d.b.a.j
      implements kotlin.g.a.m<ak, kotlin.d.d<? super c.a>, Object>
    {
      Object L$0;
      int label;
      private ak p$;
      
      c(kotlin.d.d paramd, c.m.a parama, c.p paramp, ak paramak, String paramString, com.tencent.mm.ad.i parami)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(82868);
        kotlin.g.b.p.k(paramd, "completion");
        paramd = new c(paramd, this.QCY, jdField_this, paramObject, this.QDa, this.QDb);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(82868);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82869);
        paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
        AppMethodBeat.o(82869);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(82867);
        kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82867);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.p$;
          c.c(jdField_this.QCV, c.l.QCA);
          Object localObject = jdField_this.QCS;
          String str1 = this.QDa;
          String str2 = jdField_this.QCW.name;
          kotlin.g.b.p.j(str2, "webCompt.name");
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
        c.b(jdField_this.QCV, c.l.QCA);
        AppMethodBeat.o(82867);
        return paramObject;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$asyncAppScript$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$4"})
    static final class d
      extends kotlin.d.b.a.j
      implements kotlin.g.a.m<ak, kotlin.d.d<? super o<? extends String, ? extends String>>, Object>
    {
      Object L$0;
      int label;
      Object oDA;
      private ak p$;
      
      d(com.tencent.mm.plugin.appbrand.m.g paramg, kotlin.d.d paramd, c.m.a parama, c.p paramp, ak paramak, String paramString, com.tencent.mm.ad.i parami)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(82872);
        kotlin.g.b.p.k(paramd, "completion");
        paramd = new d(this.sKo, paramd, this.QCY, jdField_this, paramObject, this.QDa, this.QDb);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(82872);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82873);
        paramObject1 = ((d)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
        AppMethodBeat.o(82873);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(82871);
        kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82871);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.p$;
          c.c(jdField_this.QCV, c.l.QCC);
          this.L$0 = paramObject;
          this.oDA = this;
          this.label = 1;
          paramObject = new kotlin.d.h(kotlin.d.a.b.k(this));
          Object localObject = (kotlin.d.d)paramObject;
          c.b localb = c.QBP;
          com.tencent.mm.ae.d.b(c.access$getTAG$cp(), (kotlin.g.a.a)new kotlin.g.b.q((kotlin.d.d)localObject) {});
          localObject = paramObject.iBS();
          if (localObject == kotlin.d.a.a.aaAA) {
            kotlin.g.b.p.k(this, "frame");
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
        c.b(jdField_this.QCV, c.l.QCC);
        AppMethodBeat.o(82871);
        return paramObject;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.b<c.k, x>
  {
    public static final q QDd;
    
    static
    {
      AppMethodBeat.i(82878);
      QDd = new q();
      AppMethodBeat.o(82878);
    }
    
    q()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    r(c paramc, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback", "com/tencent/mm/plugin/webview/webcompt/WebComponent$errReport$1$2$2", "com/tencent/mm/plugin/webview/webcompt/WebComponent$$special$$inlined$let$lambda$1"})
  static final class s
    implements IPCRunCgi.a
  {
    s(c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(82879);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        this.QCS.QBB.a(b.QBv);
      }
      AppMethodBeat.o(82879);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    public static final t QDk;
    
    static
    {
      AppMethodBeat.i(82881);
      QDk = new t();
      AppMethodBeat.o(82881);
    }
    
    t()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    u(c paramc, String paramString, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/webcompt/WebComponent$getA8Key$2$1$1", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "", "onUrlRedirect", "forceRedirect", "webview-sdk_release", "com/tencent/mm/plugin/webview/webcompt/WebComponent$$special$$inlined$apply$lambda$1"})
  public static final class v
    implements com.tencent.mm.plugin.webview.f.a<bot>
  {
    v(com.tencent.mm.plugin.webview.f.c paramc, kotlin.d.d paramd, c paramc1, String paramString1, String paramString2) {}
    
    public final void F(int paramInt, String paramString1, String paramString2) {}
    
    public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(82885);
      kotlin.g.b.p.k(paramString1, "reqUrl");
      kotlin.g.b.p.k(paramString2, "errMsg");
      paramString1 = this.QDn;
      paramString2 = (Throwable)new c.k(20001, this.QDo, "getA8Key error:" + paramInt2 + ", " + paramInt3 + ", " + paramString2);
      Result.Companion localCompanion = Result.Companion;
      paramString1.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramString2)));
      this.QCS.QBB.a(b.QBi);
      AppMethodBeat.o(82885);
    }
    
    public final void bu(int paramInt, String paramString)
    {
      AppMethodBeat.i(205632);
      kotlin.g.b.p.k(paramString, "reqUrl");
      AppMethodBeat.o(205632);
    }
    
    public final void bv(int paramInt, String paramString)
    {
      AppMethodBeat.i(205631);
      kotlin.g.b.p.k(paramString, "reqUrl");
      AppMethodBeat.o(205631);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"readText", "Lkotlin/Pair;", "", "T", "type", "errCode", "", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "debugType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "invoke", "(Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;)Lkotlin/Pair;"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.s<T, String, Integer, c.b.c, c.b.a, o<? extends String, ? extends String>>
  {
    w(c paramc, cnf paramcnf)
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
      //   8: invokestatic 80	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: aload 4
      //   13: ldc 81
      //   15: invokestatic 80	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
      //   18: aload 5
      //   20: ldc 82
      //   22: invokestatic 80	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
      //   25: getstatic 86	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
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
      //   73: checkcast 117	com/tencent/mm/vfs/q
      //   76: invokevirtual 122	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
      //   79: aload_1
      //   80: checkcast 117	com/tencent/mm/vfs/q
      //   83: invokestatic 128	com/tencent/mm/vfs/r:ak	(Lcom/tencent/mm/vfs/q;)Ljava/lang/String;
      //   86: invokespecial 131	kotlin/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   89: astore 6
      //   91: aload_0
      //   92: getfield 39	com/tencent/mm/plugin/webview/l/c$w:QCS	Lcom/tencent/mm/plugin/webview/l/c;
      //   95: getfield 135	com/tencent/mm/plugin/webview/l/c:QBB	Lcom/tencent/mm/plugin/webview/l/j;
      //   98: getstatic 141	com/tencent/mm/plugin/webview/l/b:QBk	Lcom/tencent/mm/plugin/webview/l/b;
      //   101: invokevirtual 146	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
      //   104: getstatic 86	com/tencent/mm/plugin/webview/l/c:QBP	Lcom/tencent/mm/plugin/webview/l/c$b;
      //   107: astore 7
      //   109: invokestatic 152	com/tencent/mm/plugin/webview/l/c$b:hcG	()Lcom/tencent/mm/plugin/webview/l/c$b$b;
      //   112: getfield 158	com/tencent/mm/plugin/webview/l/c$b$b:QBZ	Ljava/util/LinkedList;
      //   115: astore 7
      //   117: aload 6
      //   119: getfield 162	kotlin/o:Mx	Ljava/lang/Object;
      //   122: astore 8
      //   124: aload 8
      //   126: ldc 164
      //   128: invokestatic 167	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   131: aload 7
      //   133: new 169	com/tencent/mm/plugin/webview/l/c$b$d
      //   136: dup
      //   137: aload 8
      //   139: checkcast 171	java/lang/String
      //   142: invokestatic 174	com/tencent/mm/plugin/webview/l/c:hcv	()Ljava/lang/String;
      //   145: ldc 175
      //   147: invokestatic 181	kotlin/n/n:bx	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
      //   219: getfield 39	com/tencent/mm/plugin/webview/l/c$w:QCS	Lcom/tencent/mm/plugin/webview/l/c;
      //   222: getfield 135	com/tencent/mm/plugin/webview/l/c:QBB	Lcom/tencent/mm/plugin/webview/l/j;
      //   225: getstatic 213	com/tencent/mm/plugin/webview/l/b:QAM	Lcom/tencent/mm/plugin/webview/l/b;
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
      //   260: getfield 39	com/tencent/mm/plugin/webview/l/c$w:QCS	Lcom/tencent/mm/plugin/webview/l/c;
      //   263: getfield 135	com/tencent/mm/plugin/webview/l/c:QBB	Lcom/tencent/mm/plugin/webview/l/j;
      //   266: getstatic 216	com/tencent/mm/plugin/webview/l/b:QAN	Lcom/tencent/mm/plugin/webview/l/b;
      //   269: invokevirtual 146	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
      //   272: aload_0
      //   273: getfield 39	com/tencent/mm/plugin/webview/l/c$w:QCS	Lcom/tencent/mm/plugin/webview/l/c;
      //   276: getfield 135	com/tencent/mm/plugin/webview/l/c:QBB	Lcom/tencent/mm/plugin/webview/l/j;
      //   279: getstatic 219	com/tencent/mm/plugin/webview/l/b:QBl	Lcom/tencent/mm/plugin/webview/l/b;
      //   282: invokevirtual 146	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
      //   285: aload_0
      //   286: getfield 39	com/tencent/mm/plugin/webview/l/c$w:QCS	Lcom/tencent/mm/plugin/webview/l/c;
      //   289: getfield 135	com/tencent/mm/plugin/webview/l/c:QBB	Lcom/tencent/mm/plugin/webview/l/j;
      //   292: getstatic 222	com/tencent/mm/plugin/webview/l/b:QAP	Lcom/tencent/mm/plugin/webview/l/b;
      //   295: invokevirtual 146	com/tencent/mm/plugin/webview/l/j:a	(Lcom/tencent/mm/plugin/webview/l/b;)V
      //   298: aload_0
      //   299: getfield 41	com/tencent/mm/plugin/webview/l/c$w:QCW	Lcom/tencent/mm/protocal/protobuf/cnf;
      //   302: getfield 228	com/tencent/mm/protocal/protobuf/cnf:name	Ljava/lang/String;
      //   305: astore 5
      //   307: aload 5
      //   309: ldc 230
      //   311: invokestatic 167	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   314: new 232	com/tencent/mm/plugin/webview/l/c$k
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
      //   356: invokespecial 239	com/tencent/mm/plugin/webview/l/c$k:<init>	(ILjava/lang/String;Ljava/lang/String;)V
      //   359: checkcast 241	java/lang/Throwable
      //   362: astore_1
      //   363: ldc 73
      //   365: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   368: aload_1
      //   369: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	370	0	this	w
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"buildMatrix", "", "", "matrix", "", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.b<List<? extends Integer>, List<? extends String>>
  {
    public static final x QDp;
    
    static
    {
      AppMethodBeat.i(82892);
      QDp = new x();
      AppMethodBeat.o(82892);
    }
    
    x()
    {
      super();
    }
    
    public static List<String> je(List<Integer> paramList)
    {
      AppMethodBeat.i(82891);
      kotlin.g.b.p.k(paramList, "matrix");
      SecureRandom localSecureRandom = new SecureRandom();
      Object localObject = (Iterable)paramList;
      paramList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        byte[] arrayOfByte = new byte[((Number)((Iterator)localObject).next()).intValue()];
        localSecureRandom.nextBytes(arrayOfByte);
        paramList.add(e.a(arrayOfByte, (CharSequence)"", (kotlin.g.a.b)a.QDq));
      }
      paramList = (List)paramList;
      AppMethodBeat.o(82891);
      return paramList;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<Byte, String>
    {
      public static final a QDq;
      
      static
      {
        AppMethodBeat.i(82889);
        QDq = new a();
        AppMethodBeat.o(82889);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    y(c paramc, r paramr)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$refreshA8Key$2$1"})
  static final class z
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    z(c.m.a parama, kotlin.d.d paramd, c paramc, kotlin.g.a.b paramb1, kotlin.g.a.b paramb2)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(82895);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new z(this.QDr, paramd, this.QCS, this.QDs, this.QDt);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(82895);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(82896);
      paramObject1 = ((z)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(82896);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(82894);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
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
        c localc = this.QCS;
        String str = this.QDr.QCI;
        this.L$0 = paramObject;
        this.label = 1;
        paramObject = c.a(localc, str, this);
        if (paramObject != locala) {
          break label159;
        }
        AppMethodBeat.o(82894);
        return locala;
      }
      catch (c.k paramObject)
      {
        for (;;)
        {
          this.QDt.invoke(paramObject);
        }
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = (c.a)paramObject;
      this.QDs.invoke(c.a(this.QCS, paramObject));
      paramObject = x.aazN;
      AppMethodBeat.o(82894);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.c
 * JD-Core Version:    0.7.0.1
 */