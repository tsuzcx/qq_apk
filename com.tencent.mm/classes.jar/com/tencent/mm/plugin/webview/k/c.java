package com.tencent.mm.plugin.webview.k;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.eee;
import com.tencent.mm.protocal.protobuf.eef;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.d.d;
import d.d.f.c;
import d.g.a.s;
import d.g.b.y.f;
import d.l;
import d.n.n;
import d.o;
import d.p.a;
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
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.at;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bk;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "inited", "", "getJsapi", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "getReporter", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "workerManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "getWorkerManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "workerManager$delegate", "Lkotlin/Lazy;", "appendTags", "", "webCompt", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "cleanMainFrame", "clear", "createJsContext", "appId", "", "url", "launchMainFrame", "dispatchEvent", "event", "message", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluateMainFrame", "script", "callback", "Lkotlin/Function1;", "getA8Key", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "a8KeyUrl", "webComptName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppScript", "Lkotlin/Pair;", "paramsObject", "Lcom/tencent/mm/json/JSONObject;", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "performance", "frontEndPerformance", "postToBack", "postToFront", "refreshA8Key", "onerror", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "onsuccess", "config", "webComptInfo", "configTimeStamps", "", "resume", "end", "step", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "evaluate", "launch", "a8key", "records", "steps", "", "start", "toJson", "A8KeyResp", "Companion", "CreateJSContextException", "PerformanceSteps", "WebComptWorkerManager", "webview-sdk_release"})
public final class c
{
  private static final d.f DzT;
  private static final String EuH = "webcompt://";
  private static final d.f EuI;
  static final d.f EuJ;
  static final d.f EuK;
  private static final e EuL;
  private static String EuM;
  private static final LinkedList<l> EuN;
  private static final d.f EuO;
  private static final String EuP;
  private static final d.f EuQ;
  public static final b EuR;
  static final String TAG = "MicroMsg.WebComponent";
  final com.tencent.mm.plugin.webview.c.f DzP;
  final j EuF;
  private final d.f EuG;
  private boolean gcX;
  
  static
  {
    AppMethodBeat.i(82898);
    EuR = new b((byte)0);
    EuH = "webcompt://";
    TAG = "MicroMsg.WebComponent";
    DzT = d.g.O((d.g.a.a)g.Evt);
    EuI = d.g.O((d.g.a.a)d.Evq);
    EuJ = d.g.O((d.g.a.a)f.Evr);
    EuK = d.g.O((d.g.a.a)i.Evv);
    EuL = new e();
    EuM = "";
    EuN = new LinkedList();
    EuO = d.g.O((d.g.a.a)h.Evu);
    EuP = com.tencent.mm.loader.j.b.arU() + "webcompt_debug/";
    EuQ = d.g.O((d.g.a.a)c.Evo);
    AppMethodBeat.o(82898);
  }
  
  public c(com.tencent.mm.plugin.webview.c.f paramf)
  {
    AppMethodBeat.i(214404);
    this.DzP = paramf;
    this.EuF = new j();
    b.eWe().clear();
    this.EuG = d.g.O((d.g.a.a)new z(this));
    AppMethodBeat.o(214404);
  }
  
  /* Error */
  private final o<String, String> a(com.tencent.mm.ac.i parami, final bqx parambqx)
  {
    // Byte code:
    //   0: ldc_w 367
    //   3: invokestatic 237	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 344	com/tencent/mm/plugin/webview/k/c:EuF	Lcom/tencent/mm/plugin/webview/k/j;
    //   10: getstatic 373	com/tencent/mm/plugin/webview/k/b:Eun	Lcom/tencent/mm/plugin/webview/k/b;
    //   13: invokevirtual 376	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
    //   16: new 97	com/tencent/mm/plugin/webview/k/c$v
    //   19: dup
    //   20: aload_0
    //   21: aload_2
    //   22: invokespecial 379	com/tencent/mm/plugin/webview/k/c$v:<init>	(Lcom/tencent/mm/plugin/webview/k/c;Lcom/tencent/mm/protocal/protobuf/bqx;)V
    //   25: astore 4
    //   27: getstatic 247	com/tencent/mm/plugin/webview/k/c:TAG	Ljava/lang/String;
    //   30: new 299	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 381
    //   37: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: getfield 389	com/tencent/mm/protocal/protobuf/bqx:name	Ljava/lang/String;
    //   44: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 394	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: getstatic 400	com/tencent/mm/plugin/webview/k/g:Ewv	Lcom/tencent/mm/plugin/webview/k/g$a;
    //   56: astore 5
    //   58: invokestatic 406	com/tencent/mm/plugin/webview/k/g$a:getDebug	()Z
    //   61: ifeq +77 -> 138
    //   64: getstatic 400	com/tencent/mm/plugin/webview/k/g:Ewv	Lcom/tencent/mm/plugin/webview/k/g$a;
    //   67: astore 5
    //   69: invokestatic 412	com/tencent/mm/plugin/webview/k/h:bFO	()Lcom/tencent/mm/sdk/platformtools/ax;
    //   72: ldc_w 414
    //   75: ldc_w 284
    //   78: invokevirtual 420	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 5
    //   83: aload 5
    //   85: ifnonnull +6 -> 91
    //   88: invokestatic 423	d/g/b/p:gfZ	()V
    //   91: aload 5
    //   93: checkcast 425	java/lang/CharSequence
    //   96: invokestatic 431	d/n/n:aE	(Ljava/lang/CharSequence;)Z
    //   99: ifne +127 -> 226
    //   102: iconst_1
    //   103: istore_3
    //   104: iload_3
    //   105: ifeq +126 -> 231
    //   108: aload 4
    //   110: new 433	java/net/URL
    //   113: dup
    //   114: aload 5
    //   116: invokespecial 434	java/net/URL:<init>	(Ljava/lang/String;)V
    //   119: ldc_w 436
    //   122: ldc_w 437
    //   125: aconst_null
    //   126: getstatic 441	com/tencent/mm/plugin/webview/k/c$b$a:EuY	Lcom/tencent/mm/plugin/webview/k/c$b$a;
    //   129: iconst_4
    //   130: invokestatic 444	com/tencent/mm/plugin/webview/k/c$v:a	(Lcom/tencent/mm/plugin/webview/k/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)Ld/o;
    //   133: astore_1
    //   134: aload_1
    //   135: ifnonnull +981 -> 1116
    //   138: aload_2
    //   139: getfield 446	com/tencent/mm/protocal/protobuf/bqx:url	Ljava/lang/String;
    //   142: checkcast 425	java/lang/CharSequence
    //   145: astore_1
    //   146: aload_1
    //   147: ifnull +10 -> 157
    //   150: aload_1
    //   151: invokestatic 431	d/n/n:aE	(Ljava/lang/CharSequence;)Z
    //   154: ifeq +313 -> 467
    //   157: iconst_1
    //   158: istore_3
    //   159: iload_3
    //   160: ifne +28 -> 188
    //   163: aload_2
    //   164: getfield 449	com/tencent/mm/protocal/protobuf/bqx:md5	Ljava/lang/String;
    //   167: checkcast 425	java/lang/CharSequence
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +10 -> 182
    //   175: aload_1
    //   176: invokestatic 431	d/n/n:aE	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +293 -> 472
    //   182: iconst_1
    //   183: istore_3
    //   184: iload_3
    //   185: ifeq +292 -> 477
    //   188: aload_2
    //   189: getfield 389	com/tencent/mm/protocal/protobuf/bqx:name	Ljava/lang/String;
    //   192: astore_1
    //   193: aload_1
    //   194: ldc_w 451
    //   197: invokestatic 454	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   200: new 56	com/tencent/mm/plugin/webview/k/c$j
    //   203: dup
    //   204: sipush 21001
    //   207: aload_1
    //   208: ldc_w 456
    //   211: invokespecial 459	com/tencent/mm/plugin/webview/k/c$j:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   214: checkcast 366	java/lang/Throwable
    //   217: astore_1
    //   218: ldc_w 367
    //   221: invokestatic 326	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload_1
    //   225: athrow
    //   226: iconst_0
    //   227: istore_3
    //   228: goto -124 -> 104
    //   231: aload_1
    //   232: new 299	java/lang/StringBuilder
    //   235: dup
    //   236: ldc_w 461
    //   239: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   242: aload_2
    //   243: getfield 389	com/tencent/mm/protocal/protobuf/bqx:name	Ljava/lang/String;
    //   246: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokevirtual 467	com/tencent/mm/ac/i:has	(Ljava/lang/String;)Z
    //   255: ifeq +71 -> 326
    //   258: aload 4
    //   260: new 433	java/net/URL
    //   263: dup
    //   264: aload_1
    //   265: new 299	java/lang/StringBuilder
    //   268: dup
    //   269: ldc_w 461
    //   272: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload_2
    //   276: getfield 389	com/tencent/mm/protocal/protobuf/bqx:name	Ljava/lang/String;
    //   279: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokevirtual 470	com/tencent/mm/ac/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokespecial 434	java/net/URL:<init>	(Ljava/lang/String;)V
    //   291: new 299	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 472
    //   298: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: aload_2
    //   302: getfield 389	com/tencent/mm/protocal/protobuf/bqx:name	Ljava/lang/String;
    //   305: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: ldc_w 473
    //   314: aconst_null
    //   315: getstatic 476	com/tencent/mm/plugin/webview/k/c$b$a:EuV	Lcom/tencent/mm/plugin/webview/k/c$b$a;
    //   318: iconst_4
    //   319: invokestatic 444	com/tencent/mm/plugin/webview/k/c$v:a	(Lcom/tencent/mm/plugin/webview/k/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)Ld/o;
    //   322: astore_1
    //   323: goto -189 -> 134
    //   326: aload_1
    //   327: ldc_w 414
    //   330: invokevirtual 467	com/tencent/mm/ac/i:has	(Ljava/lang/String;)Z
    //   333: ifeq +37 -> 370
    //   336: aload 4
    //   338: new 433	java/net/URL
    //   341: dup
    //   342: aload_1
    //   343: ldc_w 414
    //   346: invokevirtual 470	com/tencent/mm/ac/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   349: invokespecial 434	java/net/URL:<init>	(Ljava/lang/String;)V
    //   352: ldc_w 478
    //   355: ldc_w 479
    //   358: aconst_null
    //   359: getstatic 476	com/tencent/mm/plugin/webview/k/c$b$a:EuV	Lcom/tencent/mm/plugin/webview/k/c$b$a;
    //   362: iconst_4
    //   363: invokestatic 444	com/tencent/mm/plugin/webview/k/c$v:a	(Lcom/tencent/mm/plugin/webview/k/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)Ld/o;
    //   366: astore_1
    //   367: goto -233 -> 134
    //   370: new 481	com/tencent/mm/vfs/e
    //   373: dup
    //   374: new 299	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   381: aload_2
    //   382: getfield 389	com/tencent/mm/protocal/protobuf/bqx:name	Ljava/lang/String;
    //   385: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: ldc_w 483
    //   391: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 486	com/tencent/mm/plugin/webview/k/c$b:aJJ	(Ljava/lang/String;)Ljava/lang/String;
    //   400: invokespecial 487	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   403: invokevirtual 490	com/tencent/mm/vfs/e:exists	()Z
    //   406: ifeq +56 -> 462
    //   409: aload 4
    //   411: new 481	com/tencent/mm/vfs/e
    //   414: dup
    //   415: new 299	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   422: aload_2
    //   423: getfield 389	com/tencent/mm/protocal/protobuf/bqx:name	Ljava/lang/String;
    //   426: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc_w 483
    //   432: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 486	com/tencent/mm/plugin/webview/k/c$b:aJJ	(Ljava/lang/String;)Ljava/lang/String;
    //   441: invokespecial 487	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   444: ldc_w 492
    //   447: ldc_w 493
    //   450: aconst_null
    //   451: getstatic 496	com/tencent/mm/plugin/webview/k/c$b$a:EuW	Lcom/tencent/mm/plugin/webview/k/c$b$a;
    //   454: iconst_4
    //   455: invokestatic 444	com/tencent/mm/plugin/webview/k/c$v:a	(Lcom/tencent/mm/plugin/webview/k/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)Ld/o;
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
    //   477: new 481	com/tencent/mm/vfs/e
    //   480: dup
    //   481: new 299	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   488: aload_2
    //   489: invokestatic 499	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/protocal/protobuf/bqx;)Ljava/lang/String;
    //   492: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: ldc_w 483
    //   498: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokespecial 487	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   507: invokevirtual 490	com/tencent/mm/vfs/e:exists	()Z
    //   510: ifeq +180 -> 690
    //   513: aload 4
    //   515: new 481	com/tencent/mm/vfs/e
    //   518: dup
    //   519: new 299	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   526: aload_2
    //   527: invokestatic 499	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/protocal/protobuf/bqx;)Ljava/lang/String;
    //   530: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc_w 483
    //   536: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokespecial 487	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   545: ldc_w 501
    //   548: sipush 21004
    //   551: getstatic 505	com/tencent/mm/plugin/webview/k/c$b$c:Evf	Lcom/tencent/mm/plugin/webview/k/c$b$c;
    //   554: aconst_null
    //   555: bipush 8
    //   557: invokestatic 444	com/tencent/mm/plugin/webview/k/c$v:a	(Lcom/tencent/mm/plugin/webview/k/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)Ld/o;
    //   560: astore_1
    //   561: aload_0
    //   562: getfield 344	com/tencent/mm/plugin/webview/k/c:EuF	Lcom/tencent/mm/plugin/webview/k/j;
    //   565: getstatic 508	com/tencent/mm/plugin/webview/k/b:EtM	Lcom/tencent/mm/plugin/webview/k/b;
    //   568: invokevirtual 376	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
    //   571: getstatic 247	com/tencent/mm/plugin/webview/k/c:TAG	Ljava/lang/String;
    //   574: new 299	java/lang/StringBuilder
    //   577: dup
    //   578: ldc_w 510
    //   581: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   584: aload_2
    //   585: getfield 389	com/tencent/mm/protocal/protobuf/bqx:name	Ljava/lang/String;
    //   588: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 394	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: aload_1
    //   598: getfield 516	d/o:second	Ljava/lang/Object;
    //   601: checkcast 518	java/lang/String
    //   604: invokevirtual 522	java/lang/String:length	()I
    //   607: iconst_1
    //   608: if_icmple +496 -> 1104
    //   611: getstatic 247	com/tencent/mm/plugin/webview/k/c:TAG	Ljava/lang/String;
    //   614: astore 4
    //   616: new 299	java/lang/StringBuilder
    //   619: dup
    //   620: ldc_w 524
    //   623: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   626: aload_2
    //   627: getfield 389	com/tencent/mm/protocal/protobuf/bqx:name	Ljava/lang/String;
    //   630: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: bipush 10
    //   635: invokevirtual 527	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   638: astore_2
    //   639: aload_1
    //   640: getfield 516	d/o:second	Ljava/lang/Object;
    //   643: checkcast 518	java/lang/String
    //   646: astore 5
    //   648: bipush 100
    //   650: aload_1
    //   651: getfield 516	d/o:second	Ljava/lang/Object;
    //   654: checkcast 518	java/lang/String
    //   657: invokevirtual 522	java/lang/String:length	()I
    //   660: iconst_1
    //   661: isub
    //   662: invokestatic 533	java/lang/Math:min	(II)I
    //   665: istore_3
    //   666: aload 5
    //   668: ifnonnull +405 -> 1073
    //   671: new 535	d/v
    //   674: dup
    //   675: ldc_w 537
    //   678: invokespecial 538	d/v:<init>	(Ljava/lang/String;)V
    //   681: astore_1
    //   682: ldc_w 367
    //   685: invokestatic 326	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   688: aload_1
    //   689: athrow
    //   690: new 433	java/net/URL
    //   693: dup
    //   694: aload_2
    //   695: getfield 446	com/tencent/mm/protocal/protobuf/bqx:url	Ljava/lang/String;
    //   698: invokespecial 434	java/net/URL:<init>	(Ljava/lang/String;)V
    //   701: astore 5
    //   703: getstatic 247	com/tencent/mm/plugin/webview/k/c:TAG	Ljava/lang/String;
    //   706: ldc_w 540
    //   709: aload 5
    //   711: invokestatic 544	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   714: invokevirtual 547	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   717: invokestatic 549	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: aload 5
    //   722: invokevirtual 553	java/net/URL:openStream	()Ljava/io/InputStream;
    //   725: checkcast 555	java/io/Closeable
    //   728: astore 6
    //   730: aconst_null
    //   731: astore 4
    //   733: aload 6
    //   735: checkcast 557	java/io/InputStream
    //   738: astore_1
    //   739: aload_1
    //   740: ldc_w 559
    //   743: invokestatic 454	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   746: aload_1
    //   747: invokestatic 565	d/f/a:X	(Ljava/io/InputStream;)[B
    //   750: astore_1
    //   751: aload_2
    //   752: getfield 449	com/tencent/mm/protocal/protobuf/bqx:md5	Ljava/lang/String;
    //   755: new 567	java/io/ByteArrayInputStream
    //   758: dup
    //   759: aload_1
    //   760: invokespecial 570	java/io/ByteArrayInputStream:<init>	([B)V
    //   763: checkcast 557	java/io/InputStream
    //   766: aload_1
    //   767: arraylength
    //   768: invokestatic 575	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   771: invokestatic 578	d/g/b/p:i	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   774: ifeq +149 -> 923
    //   777: new 481	com/tencent/mm/vfs/e
    //   780: dup
    //   781: new 299	java/lang/StringBuilder
    //   784: dup
    //   785: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   788: aload_2
    //   789: invokestatic 499	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/protocal/protobuf/bqx;)Ljava/lang/String;
    //   792: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: ldc_w 483
    //   798: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokespecial 487	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   807: astore 7
    //   809: new 481	com/tencent/mm/vfs/e
    //   812: dup
    //   813: aload 7
    //   815: invokevirtual 581	com/tencent/mm/vfs/e:getParent	()Ljava/lang/String;
    //   818: invokespecial 487	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   821: invokevirtual 584	com/tencent/mm/vfs/e:mkdirs	()Z
    //   824: pop
    //   825: aload 7
    //   827: invokevirtual 587	com/tencent/mm/vfs/e:createNewFile	()Z
    //   830: pop
    //   831: aload 7
    //   833: aload_1
    //   834: invokestatic 592	com/tencent/mm/vfs/f:b	(Lcom/tencent/mm/vfs/e;[B)V
    //   837: invokestatic 348	com/tencent/mm/plugin/webview/k/c$b:eWe	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
    //   840: getfield 595	com/tencent/mm/plugin/webview/k/c$b$b:Evb	Ljava/util/LinkedList;
    //   843: astore 7
    //   845: aload 5
    //   847: invokevirtual 596	java/net/URL:toString	()Ljava/lang/String;
    //   850: astore 8
    //   852: aload 8
    //   854: ldc_w 598
    //   857: invokestatic 454	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   860: aload 7
    //   862: new 19	com/tencent/mm/plugin/webview/k/c$b$d
    //   865: dup
    //   866: aload 8
    //   868: getstatic 601	com/tencent/mm/plugin/webview/k/c$b$c:Evg	Lcom/tencent/mm/plugin/webview/k/c$b$c;
    //   871: aconst_null
    //   872: iconst_4
    //   873: invokespecial 604	com/tencent/mm/plugin/webview/k/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)V
    //   876: invokevirtual 608	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   879: pop
    //   880: new 512	d/o
    //   883: dup
    //   884: aload 5
    //   886: invokevirtual 596	java/net/URL:toString	()Ljava/lang/String;
    //   889: new 518	java/lang/String
    //   892: dup
    //   893: aload_1
    //   894: getstatic 614	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   897: invokespecial 617	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   900: invokespecial 620	d/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   903: astore_1
    //   904: aload_0
    //   905: getfield 344	com/tencent/mm/plugin/webview/k/c:EuF	Lcom/tencent/mm/plugin/webview/k/j;
    //   908: getstatic 623	com/tencent/mm/plugin/webview/k/b:EtN	Lcom/tencent/mm/plugin/webview/k/b;
    //   911: invokevirtual 376	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
    //   914: aload 6
    //   916: aconst_null
    //   917: invokestatic 628	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   920: goto -349 -> 571
    //   923: aload_0
    //   924: getfield 344	com/tencent/mm/plugin/webview/k/c:EuF	Lcom/tencent/mm/plugin/webview/k/j;
    //   927: getstatic 631	com/tencent/mm/plugin/webview/k/b:EtS	Lcom/tencent/mm/plugin/webview/k/b;
    //   930: invokevirtual 376	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
    //   933: aload_2
    //   934: getfield 389	com/tencent/mm/protocal/protobuf/bqx:name	Ljava/lang/String;
    //   937: astore_1
    //   938: aload_1
    //   939: ldc_w 451
    //   942: invokestatic 454	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   945: new 56	com/tencent/mm/plugin/webview/k/c$j
    //   948: dup
    //   949: sipush 21003
    //   952: aload_1
    //   953: ldc_w 633
    //   956: aload 5
    //   958: invokestatic 544	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   961: invokevirtual 547	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   964: invokespecial 459	com/tencent/mm/plugin/webview/k/c$j:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   967: checkcast 366	java/lang/Throwable
    //   970: astore_1
    //   971: ldc_w 367
    //   974: invokestatic 326	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   977: aload_1
    //   978: athrow
    //   979: astore 4
    //   981: ldc_w 367
    //   984: invokestatic 326	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   987: aload 4
    //   989: athrow
    //   990: astore_1
    //   991: aload 6
    //   993: aload 4
    //   995: invokestatic 628	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   998: ldc_w 367
    //   1001: invokestatic 326	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1004: aload_1
    //   1005: athrow
    //   1006: astore_1
    //   1007: aload_2
    //   1008: getfield 389	com/tencent/mm/protocal/protobuf/bqx:name	Ljava/lang/String;
    //   1011: astore_2
    //   1012: aload_2
    //   1013: ldc_w 451
    //   1016: invokestatic 454	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1019: new 56	com/tencent/mm/plugin/webview/k/c$j
    //   1022: dup
    //   1023: sipush 21002
    //   1026: aload_2
    //   1027: new 299	java/lang/StringBuilder
    //   1030: dup
    //   1031: ldc_w 635
    //   1034: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1037: aload_1
    //   1038: invokevirtual 638	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1041: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: ldc_w 640
    //   1047: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: aload 5
    //   1052: invokevirtual 643	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1055: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1058: invokespecial 459	com/tencent/mm/plugin/webview/k/c$j:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   1061: checkcast 366	java/lang/Throwable
    //   1064: astore_1
    //   1065: ldc_w 367
    //   1068: invokestatic 326	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1071: aload_1
    //   1072: athrow
    //   1073: aload 5
    //   1075: iconst_0
    //   1076: iload_3
    //   1077: invokevirtual 647	java/lang/String:substring	(II)Ljava/lang/String;
    //   1080: astore 5
    //   1082: aload 5
    //   1084: ldc_w 649
    //   1087: invokestatic 454	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1090: aload 4
    //   1092: aload_2
    //   1093: aload 5
    //   1095: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1101: invokestatic 549	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1104: ldc_w 367
    //   1107: invokestatic 326	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1110: aload_1
    //   1111: areturn
    //   1112: astore_1
    //   1113: goto -122 -> 991
    //   1116: goto -545 -> 571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1119	0	this	c
    //   0	1119	1	parami	com.tencent.mm.ac.i
    //   0	1119	2	parambqx	bqx
    //   103	974	3	i	int
    //   25	707	4	localObject1	Object
    //   979	112	4	localThrowable	Throwable
    //   56	1038	5	localObject2	Object
    //   728	264	6	localCloseable	java.io.Closeable
    //   807	54	7	localObject3	Object
    //   850	17	8	str	String
    // Exception table:
    //   from	to	target	type
    //   733	914	979	java/lang/Throwable
    //   923	979	979	java/lang/Throwable
    //   981	990	990	finally
    //   720	730	1006	java/lang/Exception
    //   914	920	1006	java/lang/Exception
    //   991	1006	1006	java/lang/Exception
    //   733	914	1112	finally
    //   923	979	1112	finally
  }
  
  private final String a(a parama)
  {
    AppMethodBeat.i(82905);
    Object localObject1 = parama.EuT;
    Object localObject2 = this.DzP.getSettings();
    d.g.b.p.g(localObject2, "jsapi.settings");
    localObject2 = ((com.tencent.xweb.z)localObject2).getUserAgentString();
    d.g.b.p.g(localObject2, "jsapi.settings.userAgentString");
    ((Map)localObject1).put("User-agent", localObject2);
    localObject1 = new com.tencent.mm.ac.i((Map)localObject1).toString();
    d.g.b.p.g(localObject1, "JSONObject(httpHeaders.a…ing\n        }).toString()");
    localObject2 = new StringBuilder("{clientVersion:");
    String str = com.tencent.mm.sdk.platformtools.i.hgG;
    d.g.b.p.g(str, "BuildInfo.CLIENT_VERSION");
    parama = a.aJG(str) + ",headers:" + (String)localObject1 + ",fullUrl:" + a.aJG(parama.omw) + '}';
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
      localLinkedList.add(String.valueOf(paramr.bM(localk.lDi + "_START", paramr.getStartTime()) - paramr.getStartTime()));
      localLinkedList.add(String.valueOf(paramr.bM(localk.lDi + "_END", paramr.getStartTime()) - paramr.getStartTime()));
    }
    paramr = d.a.j.a((Iterable)localLinkedList, (CharSequence)",", null, (CharSequence)",", 0, null, null, 58) + n.r((CharSequence)"0,", (9 - paramList.size()) * 2);
    AppMethodBeat.o(82902);
    return paramr;
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, bqx parambqx, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(214398);
    Object localObject = m.EvP;
    localObject = new StringBuilder("WeixinWebCompt.config({resume:").append(paramBoolean).append(", debug:");
    g.a locala = g.Ewv;
    c(paramg, g.a.getDebug() + ", iframeUrlPattern:'" + (String)EuI.getValue() + "', configFinishTs:" + paramLong + ", bizReportId:" + parambqx.GLm + ", options:" + parambqx.GLn + "})");
    ad.i(TAG, "WeixinWebCompt.config:" + parambqx.GLn);
    AppMethodBeat.o(214398);
  }
  
  static void a(r paramr, k paramk)
  {
    AppMethodBeat.i(82901);
    paramr.bL(paramk.lDi + "_START", System.currentTimeMillis());
    AppMethodBeat.o(82901);
  }
  
  static void c(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, String paramString)
  {
    AppMethodBeat.i(214400);
    paramg.evaluateJavascript(paramString, null);
    AppMethodBeat.o(214400);
  }
  
  public static final void eWc()
  {
    AppMethodBeat.i(82923);
    b.vv(false);
    AppMethodBeat.o(82923);
  }
  
  public static final String getScheme()
  {
    return EuH;
  }
  
  private final void h(final String paramString, final d.g.a.b<? super String, d.z> paramb)
  {
    AppMethodBeat.i(82912);
    com.tencent.mm.ad.c.g((d.g.a.a)new t(this, paramString, paramb));
    AppMethodBeat.o(82912);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.g aJH(String paramString)
  {
    AppMethodBeat.i(214402);
    d.g.b.p.h(paramString, "webCompt");
    paramString = (c.l.a)eVS().get(paramString);
    if (paramString != null)
    {
      paramString = paramString.eWh();
      AppMethodBeat.o(214402);
      return paramString;
    }
    AppMethodBeat.o(214402);
    return null;
  }
  
  public final void aX(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(214401);
    d.g.b.p.h(paramString1, "webCompt");
    d.g.b.p.h(paramString2, "event");
    if (bt.isNullOrNil(paramString2))
    {
      ad.w(TAG, "dispatch event is null");
      AppMethodBeat.o(214401);
      return;
    }
    ad.v(TAG, "dispatch event=%s, value=%s", new Object[] { paramString2, paramString3 });
    com.tencent.mm.ad.c.g((d.g.a.a)new q(this, paramString1, paramString2, paramString3));
    this.EuF.a(b.EuA);
    AppMethodBeat.o(214401);
  }
  
  public final void clear()
  {
    int i;
    for (;;)
    {
      c.l.a locala;
      try
      {
        AppMethodBeat.i(82900);
        b.eWe().clear();
        if (!this.gcX) {
          break label301;
        }
        l locall = eVS();
        j localj = this.EuF;
        d.g.b.p.h(localj, "reporter");
        ad.i(TAG, "clear workerManager#" + locall.id);
        Iterator localIterator = locall.entrySet().iterator();
        i = -1;
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        locala = (c.l.a)localEntry.getValue();
        if ((!locala.used) && (locala.EvG) && (!locall.EvF.containsKey(localEntry.getKey())))
        {
          locala.aHT = true;
          locala.EvK = null;
          ad.i(TAG, "WebComptWorker.recycle " + locala.appId + '@' + locala.EvN.name + ':' + locala.EvM);
          ((Map)locall.EvF).put(localEntry.getKey(), locala);
          localj.a(b.EuC);
          continue;
        }
        if (locala.used) {
          break label279;
        }
      }
      finally {}
      if (locala.EvM == localObject.EvD) {
        i = localObject.EvD;
      } else {
        label279:
        locala.eWh().destroy();
      }
    }
    localObject.EvD = i;
    localObject.clear();
    label301:
    AppMethodBeat.o(82900);
  }
  
  final l eVS()
  {
    AppMethodBeat.i(82899);
    l locall = (l)this.EuG.getValue();
    AppMethodBeat.o(82899);
    return locall;
  }
  
  public final void eVT()
  {
    AppMethodBeat.i(214403);
    if (this.gcX)
    {
      a(this, "WeixinOpenTags.onClean()");
      this.EuF.a(b.EtZ);
    }
    AppMethodBeat.o(214403);
  }
  
  public final void h(final String paramString1, final String paramString2, final String paramString3, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(82910);
    d.g.b.p.h(paramString1, "webCompt");
    d.g.b.p.h(paramString2, "errMsg");
    Object localObject = (c.l.a)eVS().get(paramString1);
    if (localObject != null)
    {
      eee localeee = new eee();
      localeee.dvZ = paramString2;
      localeee.HPp = paramString3;
      localeee.HPq = paramInt1;
      localeee.HPr = paramInt2;
      com.tencent.xweb.z localz = this.DzP.getSettings();
      d.g.b.p.g(localz, "jsapi.settings");
      localeee.HMG = localz.getUserAgentString();
      localeee.okh = ((c.l.a)localObject).okh;
      localeee.duW = ((c.l.a)localObject).appId;
      localeee.HPs = paramString1;
      localeee.HPt = b.eWd().getVersion();
      localeee.HPu = ((c.l.a)localObject).EvI;
      localeee.HPv = ((c.l.a)localObject).EvJ;
      this.EuF.a(b.Euy);
      localObject = new b.a();
      ((b.a)localObject).c((com.tencent.mm.bx.a)localeee);
      ((b.a)localObject).d((com.tencent.mm.bx.a)new eef());
      ((b.a)localObject).Dl("/cgi-bin/mmbiz-bin/webcompt/reportjserr");
      ((b.a)localObject).oP(2914);
      ((b.a)localObject).oR(0);
      ((b.a)localObject).oS(0);
      IPCRunCgi.a(((b.a)localObject).aDC(), (IPCRunCgi.a)new r(this, paramString2, paramString3, paramInt1, paramInt2, paramString1));
      AppMethodBeat.o(82910);
      return;
    }
    AppMethodBeat.o(82910);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "", "a8key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "fullUrl", "", "httpHeaders", "", "(Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;Ljava/lang/String;Ljava/util/Map;)V", "getFullUrl", "()Ljava/lang/String;", "getHttpHeaders", "()Ljava/util/Map;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "webview-sdk_release"})
  public static final class a
  {
    final com.tencent.mm.plugin.webview.e.c EuS;
    final Map<String, String> EuT;
    final String omw;
    
    public a(com.tencent.mm.plugin.webview.e.c paramc, String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(214381);
      this.EuS = paramc;
      this.omw = paramString;
      this.EuT = paramMap;
      AppMethodBeat.o(214381);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion;", "", "()V", "PREFIX_DEBUG_PATH", "", "TAG", "getTAG$webview_sdk_release", "()Ljava/lang/String;", "_cachedFilePath", "debugInfo", "getDebugInfo", "debugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "getDebugger", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "debugger$delegate", "Lkotlin/Lazy;", "iframeUrlPattern", "getIframeUrlPattern", "iframeUrlPattern$delegate", "manager", "com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$1", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$1;", "matrix", "", "", "getMatrix", "()Ljava/util/List;", "matrix$delegate", "meta", "Lcom/tencent/mm/json/JSONObject;", "getMeta", "()Lcom/tencent/mm/json/JSONObject;", "meta$delegate", "preloadWorkers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "scheme", "scheme$annotations", "getScheme", "scriptManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "getScriptManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "scriptManager$delegate", "skeleton", "getSkeleton", "skeleton$delegate", "debugPath", "getDebugPath", "(Ljava/lang/String;)Ljava/lang/String;", "savePath", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getSavePath", "(Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;)Ljava/lang/String;", "version", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "clearDebugPath", "", "jsapiOnly", "", "appOnly", "getCachedFilePath", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalScript", "path", "scripts", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScript", "preloadWorker", "force", "readText", "DebugType", "Debugger", "ResType", "Script", "ScriptManager", "Worker", "webview-sdk_release"})
  public static final class b
  {
    static String a(bqx parambqx)
    {
      AppMethodBeat.i(214387);
      parambqx = com.tencent.mm.loader.j.b.arM() + "webcompt/" + parambqx.name + '/' + parambqx.md5;
      AppMethodBeat.o(214387);
      return parambqx;
    }
    
    static String aJJ(String paramString)
    {
      AppMethodBeat.i(82828);
      paramString = c.eVV() + paramString;
      AppMethodBeat.o(82828);
      return paramString;
    }
    
    /* Error */
    private static String b(com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc_w 257
      //   5: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: aload_1
      //   10: invokeinterface 263 2 0
      //   15: astore_0
      //   16: aload_0
      //   17: ifnull +62 -> 79
      //   20: aload_0
      //   21: checkcast 265	java/io/Closeable
      //   24: astore_3
      //   25: new 267	java/lang/String
      //   28: dup
      //   29: aload_3
      //   30: checkcast 269	java/io/InputStream
      //   33: invokestatic 275	d/f/a:X	(Ljava/io/InputStream;)[B
      //   36: getstatic 281	d/n/d:UTF_8	Ljava/nio/charset/Charset;
      //   39: invokespecial 284	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   42: astore_0
      //   43: aload_3
      //   44: aconst_null
      //   45: invokestatic 289	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   48: ldc_w 257
      //   51: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: aload_0
      //   55: areturn
      //   56: astore_1
      //   57: ldc_w 257
      //   60: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   63: aload_1
      //   64: athrow
      //   65: astore_0
      //   66: aload_3
      //   67: aload_1
      //   68: invokestatic 289	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   71: ldc_w 257
      //   74: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   77: aload_0
      //   78: athrow
      //   79: ldc_w 257
      //   82: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   85: ldc_w 290
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
    
    static e eWd()
    {
      AppMethodBeat.i(82827);
      Object localObject = c.eWa();
      b localb = c.EuR;
      localObject = (e)((d.f)localObject).getValue();
      AppMethodBeat.o(82827);
      return localObject;
    }
    
    static b eWe()
    {
      AppMethodBeat.i(82830);
      Object localObject = c.eWb();
      b localb = c.EuR;
      localObject = (b)((d.f)localObject).getValue();
      AppMethodBeat.o(82830);
      return localObject;
    }
    
    /* Error */
    public static String f(String paramString, LinkedList<d> paramLinkedList)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc_w 351
      //   5: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 354	com/tencent/mm/plugin/webview/k/c:access$getTAG$cp	()Ljava/lang/String;
      //   11: ldc_w 356
      //   14: iconst_1
      //   15: anewarray 4	java/lang/Object
      //   18: dup
      //   19: iconst_0
      //   20: aload_0
      //   21: aastore
      //   22: invokestatic 361	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   25: getstatic 367	com/tencent/mm/plugin/webview/k/g:Ewv	Lcom/tencent/mm/plugin/webview/k/g$a;
      //   28: astore_3
      //   29: invokestatic 373	com/tencent/mm/plugin/webview/k/g$a:getDebug	()Z
      //   32: ifeq +181 -> 213
      //   35: new 318	com/tencent/mm/vfs/e
      //   38: dup
      //   39: ldc_w 375
      //   42: aload_0
      //   43: invokestatic 379	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   46: invokevirtual 382	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   49: invokestatic 384	com/tencent/mm/plugin/webview/k/c$b:aJJ	(Ljava/lang/String;)Ljava/lang/String;
      //   52: invokespecial 321	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
      //   55: astore_3
      //   56: aload_3
      //   57: invokevirtual 387	com/tencent/mm/vfs/e:exists	()Z
      //   60: ifeq +38 -> 98
      //   63: aload_1
      //   64: ifnull +21 -> 85
      //   67: aload_1
      //   68: new 17	com/tencent/mm/plugin/webview/k/c$b$d
      //   71: dup
      //   72: aload_0
      //   73: aconst_null
      //   74: getstatic 391	com/tencent/mm/plugin/webview/k/c$b$a:EuW	Lcom/tencent/mm/plugin/webview/k/c$b$a;
      //   77: iconst_2
      //   78: invokespecial 394	com/tencent/mm/plugin/webview/k/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)V
      //   81: invokevirtual 400	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   84: pop
      //   85: aload_3
      //   86: invokestatic 406	com/tencent/mm/vfs/f:ah	(Lcom/tencent/mm/vfs/e;)Ljava/lang/String;
      //   89: astore_0
      //   90: ldc_w 351
      //   93: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   96: aload_0
      //   97: areturn
      //   98: new 318	com/tencent/mm/vfs/e
      //   101: dup
      //   102: ldc_w 408
      //   105: invokestatic 384	com/tencent/mm/plugin/webview/k/c$b:aJJ	(Ljava/lang/String;)Ljava/lang/String;
      //   108: invokespecial 321	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
      //   111: astore_3
      //   112: aload_3
      //   113: invokevirtual 387	com/tencent/mm/vfs/e:exists	()Z
      //   116: ifeq +97 -> 213
      //   119: aload_1
      //   120: ifnull +21 -> 141
      //   123: aload_1
      //   124: new 17	com/tencent/mm/plugin/webview/k/c$b$d
      //   127: dup
      //   128: aload_0
      //   129: aconst_null
      //   130: getstatic 411	com/tencent/mm/plugin/webview/k/c$b$a:EuX	Lcom/tencent/mm/plugin/webview/k/c$b$a;
      //   133: iconst_2
      //   134: invokespecial 394	com/tencent/mm/plugin/webview/k/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)V
      //   137: invokevirtual 400	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   140: pop
      //   141: new 413	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   144: dup
      //   145: aload_3
      //   146: invokespecial 415	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Lcom/tencent/mm/vfs/e;)V
      //   149: checkcast 265	java/io/Closeable
      //   152: astore_3
      //   153: aload_3
      //   154: checkcast 413	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   157: astore_1
      //   158: aload_1
      //   159: invokevirtual 418	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:aZr	()Z
      //   162: pop
      //   163: getstatic 296	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   166: astore 4
      //   168: aload_1
      //   169: checkcast 259	com/tencent/mm/plugin/appbrand/appcache/p
      //   172: aload_0
      //   173: invokestatic 302	com/tencent/mm/plugin/webview/k/c$b:b	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
      //   176: astore_0
      //   177: aload_3
      //   178: aconst_null
      //   179: invokestatic 289	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   182: ldc_w 351
      //   185: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   188: aload_0
      //   189: areturn
      //   190: astore_1
      //   191: ldc_w 351
      //   194: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   197: aload_1
      //   198: athrow
      //   199: astore_0
      //   200: aload_3
      //   201: aload_1
      //   202: invokestatic 289	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   205: ldc_w 351
      //   208: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   211: aload_0
      //   212: athrow
      //   213: invokestatic 420	com/tencent/mm/plugin/webview/k/c$b:eWd	()Lcom/tencent/mm/plugin/webview/k/c$b$e;
      //   216: astore_2
      //   217: aload_0
      //   218: ldc_w 421
      //   221: invokestatic 188	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   224: getstatic 296	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   227: astore_3
      //   228: aload_2
      //   229: getfield 425	com/tencent/mm/plugin/webview/k/c$b$e:Evk	Lcom/tencent/mm/plugin/appbrand/appcache/p;
      //   232: aload_0
      //   233: invokestatic 302	com/tencent/mm/plugin/webview/k/c$b:b	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
      //   236: astore_2
      //   237: aload_1
      //   238: ifnull +28 -> 266
      //   241: getstatic 296	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   244: astore_3
      //   245: aload_1
      //   246: new 17	com/tencent/mm/plugin/webview/k/c$b$d
      //   249: dup
      //   250: aload_0
      //   251: invokestatic 427	com/tencent/mm/plugin/webview/k/c$b:eWe	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   254: getfield 431	com/tencent/mm/plugin/webview/k/c$b$b:Evc	Lcom/tencent/mm/plugin/webview/k/c$b$c;
      //   257: aconst_null
      //   258: iconst_4
      //   259: invokespecial 394	com/tencent/mm/plugin/webview/k/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)V
      //   262: invokevirtual 400	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   265: pop
      //   266: ldc_w 351
      //   269: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public static void vv(boolean paramBoolean)
    {
      AppMethodBeat.i(82822);
      if (c.eVW().size() < 3)
      {
        if (paramBoolean) {
          break label52;
        }
        if (((Collection)c.eVW()).isEmpty()) {
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
      kotlinx.coroutines.f.b((ah)bk.NII, (d.d.f)az.gvp(), (d.g.a.m)new j(null), 2);
      AppMethodBeat.o(82822);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "", "(Ljava/lang/String;I)V", "NA", "PARAM", "SDCARD", "SDCARD_PKG", "COMMAND", "webview-sdk_release"})
    static enum a
    {
      static
      {
        AppMethodBeat.i(82775);
        a locala1 = new a("NA", 0);
        EuU = locala1;
        a locala2 = new a("PARAM", 1);
        EuV = locala2;
        a locala3 = new a("SDCARD", 2);
        EuW = locala3;
        a locala4 = new a("SDCARD_PKG", 3);
        EuX = locala4;
        a locala5 = new a("COMMAND", 4);
        EuY = locala5;
        EuZ = new a[] { locala1, locala2, locala3, locala4, locala5 };
        AppMethodBeat.o(82775);
      }
      
      private a() {}
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "", "()V", "isPreload", "", "()Z", "setPreload", "(Z)V", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "setResType", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;)V", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "verion", "", "getVerion", "()I", "setVerion", "(I)V", "workers", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "getWorkers", "clear", "", "webview-sdk_release"})
    static final class b
    {
      final LinkedList<c.b.f> Eva;
      final LinkedList<c.b.d> Evb;
      c.b.c Evc;
      int Evd;
      boolean kmY;
      
      public b()
      {
        AppMethodBeat.i(82780);
        this.Eva = new LinkedList();
        this.Evb = new LinkedList();
        this.Evc = c.b.c.Eve;
        AppMethodBeat.o(82780);
      }
      
      public final void a(c.b.c paramc)
      {
        AppMethodBeat.i(82778);
        d.g.b.p.h(paramc, "<set-?>");
        this.Evc = paramc;
        AppMethodBeat.o(82778);
      }
      
      public final void clear()
      {
        AppMethodBeat.i(82779);
        this.Eva.clear();
        this.Evb.clear();
        AppMethodBeat.o(82779);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "", "(Ljava/lang/String;I)V", "NA", "CACHE", "NETWORK", "ASSETS", "webview-sdk_release"})
    static enum c
    {
      static
      {
        AppMethodBeat.i(82781);
        c localc1 = new c("NA", 0);
        Eve = localc1;
        c localc2 = new c("CACHE", 1);
        Evf = localc2;
        c localc3 = new c("NETWORK", 2);
        Evg = localc3;
        c localc4 = new c("ASSETS", 3);
        Evh = localc4;
        Evi = new c[] { localc1, localc2, localc3, localc4 };
        AppMethodBeat.o(82781);
      }
      
      private c() {}
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "", "uri", "", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "debugType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;)V", "getDebugType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getUri", "()Ljava/lang/String;", "toString", "webview-sdk_release"})
    static final class d
    {
      private final c.b.c Evc;
      private final c.b.a Evj;
      private final String uri;
      
      public d(String paramString, c.b.c paramc, c.b.a parama)
      {
        AppMethodBeat.i(82785);
        this.uri = paramString;
        this.Evc = paramc;
        this.Evj = parama;
        AppMethodBeat.o(82785);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(82784);
        StringBuilder localStringBuilder = new StringBuilder("[script]\n                ");
        if (this.Evc != c.b.c.Eve) {}
        for (String str = "resType: " + this.Evc;; str = "debugType: " + this.Evj)
        {
          str = n.bdc(str + "\n                " + this.uri + "\n                ");
          AppMethodBeat.o(82784);
          return str;
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)V", "version", "", "getVersion", "()I", "version$delegate", "Lkotlin/Lazy;", "getScript", "", "path", "webview-sdk_release"})
    static final class e
    {
      final com.tencent.mm.plugin.appbrand.appcache.p Evk;
      private final d.f okr;
      
      public e(com.tencent.mm.plugin.appbrand.appcache.p paramp)
      {
        AppMethodBeat.i(82790);
        this.Evk = paramp;
        this.okr = d.g.O((d.g.a.a)new a(this));
        AppMethodBeat.o(82790);
      }
      
      public final int getVersion()
      {
        AppMethodBeat.i(82789);
        int i = ((Number)this.okr.getValue()).intValue();
        AppMethodBeat.o(82789);
        return i;
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
      static final class a
        extends d.g.b.q
        implements d.g.a.a<Integer>
      {
        a(c.b.e parame)
        {
          super();
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "", "id", "", "isPreload", "", "isRecycled", "(IZZ)V", "getId", "()I", "()Z", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "toString", "", "webview-sdk_release"})
    static final class f
    {
      final LinkedList<c.b.d> Evb;
      private final boolean aHT;
      private final int id;
      private final boolean kmY;
      
      private f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
      {
        AppMethodBeat.i(82792);
        this.id = paramInt;
        this.kmY = paramBoolean1;
        this.aHT = paramBoolean2;
        this.Evb = new LinkedList();
        AppMethodBeat.o(82792);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(82791);
        String str = n.bdc("[worker #" + this.id + "]\n                preload: " + this.kmY + "\n                recycled: " + this.aHT + "\n                \n                " + d.a.j.a((Iterable)this.Evb, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n                ");
        AppMethodBeat.o(82791);
        return str;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"deleteChildJs", "", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
    static final class g
      extends d.g.b.q
      implements d.g.a.b<com.tencent.mm.vfs.e, d.z>
    {
      public static final g Evm;
      
      static
      {
        AppMethodBeat.i(82798);
        Evm = new g();
        AppMethodBeat.o(82798);
      }
      
      g()
      {
        super();
      }
      
      public static void V(com.tencent.mm.vfs.e parame)
      {
        AppMethodBeat.i(175715);
        d.g.b.p.h(parame, "$this$deleteChildJs");
        parame = parame.a((com.tencent.mm.vfs.g)1.Evn);
        d.g.b.p.g(parame, "listFiles { filter ->\n  …json\"))\n                }");
        int j = parame.length;
        int i = 0;
        while (i < j)
        {
          parame[i].delete();
          i += 1;
        }
        AppMethodBeat.o(175715);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
    static final class h<InputType, ResultType>
      implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCString>
    {
      public static final h Evp;
      
      static
      {
        AppMethodBeat.i(82802);
        Evp = new h();
        AppMethodBeat.o(82802);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
    static final class i
      extends d.g.b.q
      implements d.g.a.b<IPCString, d.z>
    {
      i(d paramd)
      {
        super();
      }
    }
    
    @d.d.b.a.f(c="com.tencent.mm.plugin.webview.webcompt.WebComponent$Companion$preloadWorker$1", f="WebComponent.kt", gfL={727}, m="invokeSuspend")
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class j
      extends d.d.b.a.j
      implements d.g.a.m<ah, d<? super d.z>, Object>
    {
      int label;
      private ah nWQ;
      Object nWR;
      
      j(d paramd)
      {
        super();
      }
      
      public final d<d.z> a(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(82813);
        d.g.b.p.h(paramd, "completion");
        paramd = new j(paramd);
        paramd.nWQ = ((ah)paramObject);
        AppMethodBeat.o(82813);
        return paramd;
      }
      
      public final Object cQ(Object paramObject)
      {
        AppMethodBeat.i(82812);
        paramObject = d.d.a.a.MLc;
        Object localObject;
        c.b localb;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82812);
          throw paramObject;
        case 0: 
          localObject = this.nWQ;
          localb = c.EuR;
          this.nWR = localObject;
          this.label = 1;
          if (c.b.a(this) == paramObject)
          {
            AppMethodBeat.o(82812);
            return paramObject;
          }
          break;
        }
        paramObject = new c.l();
        if (paramObject.EvD == -1)
        {
          localObject = c.eVU();
          localb = c.EuR;
          paramObject.EvD = ((c.e)localObject).create(c.b.f("/wxwebcompt.js", paramObject.EvE.Evb));
          localObject = c.EuR;
          ad.i(c.access$getTAG$cp(), "preload workerManager#" + paramObject.id);
        }
        for (;;)
        {
          c.eVW().offerFirst(paramObject);
          paramObject = d.z.MKo;
          AppMethodBeat.o(82812);
          return paramObject;
          localObject = c.EuR;
          ad.w(c.access$getTAG$cp(), "preload twice #" + paramObject.id);
        }
      }
      
      public final Object p(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82814);
        paramObject1 = ((j)a(paramObject1, (d)paramObject2)).cQ(d.z.MKo);
        AppMethodBeat.o(82814);
        return paramObject1;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<c.b.b>
  {
    public static final c Evo;
    
    static
    {
      AppMethodBeat.i(82800);
      Evo = new c();
      AppMethodBeat.o(82800);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    public static final d Evq;
    
    static
    {
      AppMethodBeat.i(82805);
      Evq = new d();
      AppMethodBeat.o(82805);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$1", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AbstractMultiContextJsEngine;", "create", "", "script", "", "createJSRuntime", "Lcom/tencent/mm/appbrand/v8/IJSRuntime;", "config", "Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;", "createMainContextEngine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "jsRuntime", "mainContextTag", "webview-sdk_release"})
  public static final class e
    extends com.tencent.mm.plugin.appbrand.jsruntime.a
  {
    public final com.tencent.mm.appbrand.v8.m a(IJSRuntime paramIJSRuntime, int paramInt)
    {
      AppMethodBeat.i(214384);
      d.g.b.p.h(paramIJSRuntime, "jsRuntime");
      paramIJSRuntime = paramIJSRuntime.hv(paramInt);
      AppMethodBeat.o(214384);
      return paramIJSRuntime;
    }
    
    public final int create(String paramString)
    {
      AppMethodBeat.i(214385);
      d.g.b.p.h(paramString, "script");
      com.tencent.mm.plugin.appbrand.jsruntime.g localg = bqj();
      localg.evaluateJavascript(paramString, null);
      d.g.b.p.g(localg, "context");
      int i = localg.bqh();
      AppMethodBeat.o(214385);
      return i;
    }
    
    public final IJSRuntime g(IJSRuntime.Config paramConfig)
    {
      AppMethodBeat.i(214383);
      paramConfig = (IJSRuntime)com.tencent.mm.appbrand.v8.f.c(paramConfig);
      AppMethodBeat.o(214383);
      return paramConfig;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<List<? extends Integer>>
  {
    public static final f Evr;
    
    static
    {
      AppMethodBeat.i(82809);
      Evr = new f();
      AppMethodBeat.o(82809);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.ac.i>
  {
    public static final g Evt;
    
    static
    {
      AppMethodBeat.i(82811);
      Evt = new g();
      AppMethodBeat.o(82811);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<c.b.e>
  {
    public static final h Evu;
    
    static
    {
      AppMethodBeat.i(82816);
      Evu = new h();
      AppMethodBeat.o(82816);
    }
    
    h()
    {
      super();
    }
    
    /* Error */
    private static c.b.e eWg()
    {
      // Byte code:
      //   0: ldc 46
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 48	com/tencent/mm/plugin/appbrand/appcache/f
      //   8: dup
      //   9: invokestatic 54	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   12: ldc 56
      //   14: invokespecial 59	com/tencent/mm/plugin/appbrand/appcache/f:<init>	(Landroid/content/Context;Ljava/lang/String;)V
      //   17: astore_2
      //   18: aload_2
      //   19: invokevirtual 63	com/tencent/mm/plugin/appbrand/appcache/f:aZr	()Z
      //   22: pop
      //   23: getstatic 67	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   26: astore_3
      //   27: aload_2
      //   28: checkcast 69	com/tencent/mm/plugin/appbrand/appcache/p
      //   31: invokestatic 75	com/tencent/mm/plugin/webview/k/c$b:d	(Lcom/tencent/mm/plugin/appbrand/appcache/p;)I
      //   34: istore_1
      //   35: invokestatic 79	com/tencent/mm/plugin/webview/k/c:eVZ	()Ljava/lang/String;
      //   38: checkcast 81	java/lang/CharSequence
      //   41: invokestatic 87	d/n/n:aE	(Ljava/lang/CharSequence;)Z
      //   44: ifne +119 -> 163
      //   47: iconst_1
      //   48: istore_0
      //   49: iload_0
      //   50: ifeq +118 -> 168
      //   53: invokestatic 79	com/tencent/mm/plugin/webview/k/c:eVZ	()Ljava/lang/String;
      //   56: invokestatic 93	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
      //   59: ifeq +109 -> 168
      //   62: new 95	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   65: dup
      //   66: invokestatic 79	com/tencent/mm/plugin/webview/k/c:eVZ	()Ljava/lang/String;
      //   69: invokespecial 98	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
      //   72: astore_3
      //   73: aload_3
      //   74: invokevirtual 99	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:aZr	()Z
      //   77: pop
      //   78: getstatic 67	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   81: astore 4
      //   83: aload_3
      //   84: checkcast 69	com/tencent/mm/plugin/appbrand/appcache/p
      //   87: invokestatic 75	com/tencent/mm/plugin/webview/k/c$b:d	(Lcom/tencent/mm/plugin/appbrand/appcache/p;)I
      //   90: istore_0
      //   91: iload_0
      //   92: iload_1
      //   93: if_icmple +75 -> 168
      //   96: getstatic 67	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   99: astore 4
      //   101: invokestatic 102	com/tencent/mm/plugin/webview/k/c:access$getTAG$cp	()Ljava/lang/String;
      //   104: ldc 104
      //   106: iload_0
      //   107: invokestatic 110	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   110: invokevirtual 114	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   113: invokestatic 119	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   116: getstatic 67	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   119: astore 4
      //   121: invokestatic 123	com/tencent/mm/plugin/webview/k/c$b:eWe	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   124: getstatic 129	com/tencent/mm/plugin/webview/k/c$b$c:Evg	Lcom/tencent/mm/plugin/webview/k/c$b$c;
      //   127: invokevirtual 135	com/tencent/mm/plugin/webview/k/c$b$b:a	(Lcom/tencent/mm/plugin/webview/k/c$b$c;)V
      //   130: getstatic 67	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   133: astore 4
      //   135: invokestatic 123	com/tencent/mm/plugin/webview/k/c$b:eWe	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   138: iload_0
      //   139: putfield 139	com/tencent/mm/plugin/webview/k/c$b$b:Evd	I
      //   142: aload_3
      //   143: astore_2
      //   144: new 141	com/tencent/mm/plugin/webview/k/c$b$e
      //   147: dup
      //   148: aload_2
      //   149: checkcast 69	com/tencent/mm/plugin/appbrand/appcache/p
      //   152: invokespecial 144	com/tencent/mm/plugin/webview/k/c$b$e:<init>	(Lcom/tencent/mm/plugin/appbrand/appcache/p;)V
      //   155: astore_2
      //   156: ldc 46
      //   158: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   161: aload_2
      //   162: areturn
      //   163: iconst_0
      //   164: istore_0
      //   165: goto -116 -> 49
      //   168: getstatic 67	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   171: astore_3
      //   172: invokestatic 102	com/tencent/mm/plugin/webview/k/c:access$getTAG$cp	()Ljava/lang/String;
      //   175: ldc 146
      //   177: iload_1
      //   178: invokestatic 110	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   181: invokevirtual 114	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   184: invokestatic 119	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   187: getstatic 67	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   190: astore_3
      //   191: invokestatic 123	com/tencent/mm/plugin/webview/k/c$b:eWe	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   194: getstatic 149	com/tencent/mm/plugin/webview/k/c$b$c:Evh	Lcom/tencent/mm/plugin/webview/k/c$b$c;
      //   197: invokevirtual 135	com/tencent/mm/plugin/webview/k/c$b$b:a	(Lcom/tencent/mm/plugin/webview/k/c$b$c;)V
      //   200: getstatic 67	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   203: astore_3
      //   204: invokestatic 123	com/tencent/mm/plugin/webview/k/c$b:eWe	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   207: iload_1
      //   208: putfield 139	com/tencent/mm/plugin/webview/k/c$b$b:Evd	I
      //   211: goto -67 -> 144
      //   214: astore_3
      //   215: getstatic 67	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   218: astore 4
      //   220: invokestatic 102	com/tencent/mm/plugin/webview/k/c:access$getTAG$cp	()Ljava/lang/String;
      //   223: new 151	java/lang/StringBuilder
      //   226: dup
      //   227: ldc 153
      //   229: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   232: aload_3
      //   233: invokevirtual 157	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   236: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   239: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   242: invokestatic 167	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   245: new 169	com/tencent/mm/plugin/webview/k/j
      //   248: dup
      //   249: invokespecial 170	com/tencent/mm/plugin/webview/k/j:<init>	()V
      //   252: getstatic 176	com/tencent/mm/plugin/webview/k/b:EuB	Lcom/tencent/mm/plugin/webview/k/b;
      //   255: invokevirtual 179	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    public static final i Evv;
    
    static
    {
      AppMethodBeat.i(82818);
      Evv = new i();
      AppMethodBeat.o(82818);
    }
    
    i()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "retCode", "", "webComptName", "", "errMsg", "(ILjava/lang/String;Ljava/lang/String;)V", "toJsonString", "webview-sdk_release"})
  public static final class j
    extends Exception
  {
    final String Evw;
    final String errMsg;
    final int retCode;
    
    public j(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(82842);
      this.retCode = paramInt;
      this.Evw = paramString1;
      this.errMsg = paramString2;
      AppMethodBeat.o(82842);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "", "stepName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStepName", "()Ljava/lang/String;", "STEP_CREATE_JS_CXT", "STEP_EVAL_MAIN_FRAME", "STEP_GET_A8KEY", "STEP_FETCH_WORKER", "STEP_GET_APP_SCRIPT", "webview-sdk_release"})
  static enum k
  {
    final String lDi;
    
    static
    {
      AppMethodBeat.i(82843);
      k localk1 = new k("STEP_CREATE_JS_CXT", 0, "createJsContext");
      Evx = localk1;
      k localk2 = new k("STEP_EVAL_MAIN_FRAME", 1, "evalMainFrame");
      Evy = localk2;
      k localk3 = new k("STEP_GET_A8KEY", 2, "GetA8Key");
      Evz = localk3;
      k localk4 = new k("STEP_FETCH_WORKER", 3, "FetchWorker");
      EvA = localk4;
      k localk5 = new k("STEP_GET_APP_SCRIPT", 4, "GetAppScript");
      EvB = localk5;
      EvC = new k[] { localk1, localk2, localk3, localk4, localk5 };
      AppMethodBeat.o(82843);
    }
    
    private k(String paramString)
    {
      this.lDi = paramString;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "Lkotlin/collections/HashMap;", "()V", "id", "", "getId", "()I", "preloadDebugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "preloadId", "recycleWorkers", "fetch", "appId", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "preload", "", "recycle", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "WebComptWorker", "webview-sdk_release"})
  static final class l
    extends HashMap<String, a>
  {
    int EvD;
    c.b.f EvE;
    final HashMap<String, a> EvF;
    final int id;
    
    public l()
    {
      AppMethodBeat.i(82849);
      this.id = ((int)(System.currentTimeMillis() % 1000L));
      this.EvD = -1;
      this.EvE = new c.b.f(this.id, true, false, 4);
      this.EvF = new HashMap();
      AppMethodBeat.o(82849);
    }
    
    public final a a(String paramString, bqx parambqx, c paramc)
    {
      boolean bool = false;
      for (;;)
      {
        Object localObject;
        try
        {
          AppMethodBeat.i(214389);
          d.g.b.p.h(paramString, "appId");
          d.g.b.p.h(parambqx, "webComptInfo");
          d.g.b.p.h(paramc, "webCompt");
          String str = parambqx.name;
          if (this.EvF.containsKey(str))
          {
            localObject = (a)this.EvF.get(str);
            if ((localObject != null) && (d.g.b.p.i(((a)localObject).appId, paramString)))
            {
              this.EvF.remove(str);
              paramString = (Map)this;
              d.g.b.p.g(str, "webComptName");
              d.g.b.p.g(localObject, "it");
              paramString.put(str, localObject);
              paramString = c.EuR;
              c.b.eWe().Eva.add(new c.b.f(this.id, false, true, 2));
              AppMethodBeat.o(214389);
              paramString = (String)localObject;
              return paramString;
            }
          }
          if (this.EvD != -1) {
            bool = true;
          }
          if (bool == true)
          {
            paramString = c.EuR;
            ad.i(c.access$getTAG$cp(), "use preload workerManager#" + this.id);
            paramString = this.EvE;
            localObject = c.EuR;
            c.b.eWe().Eva.add(paramString);
            localObject = c.EuR;
            c.b.eWe().kmY = bool;
            if (bool == true)
            {
              i = this.EvD;
              paramString = new a(i, parambqx, paramc);
              this.EvD = -1;
              parambqx = (Map)this;
              d.g.b.p.g(str, "webComptName");
              parambqx.put(str, paramString);
              AppMethodBeat.o(214389);
            }
          }
          else
          {
            paramString = c.EuR;
            ad.i(c.access$getTAG$cp(), "create new workerManager#" + this.id);
            paramString = new c.b.f(this.id, false, false, 4);
            continue;
          }
          localObject = c.eVU();
        }
        finally {}
        c.b localb = c.EuR;
        int i = ((c.e)localObject).create(c.b.f("/wxwebcompt.js", paramString.Evb));
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "", "workerId", "", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;ILcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;)V", "a8KeyUrl", "", "getA8KeyUrl", "()Ljava/lang/String;", "setA8KeyUrl", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "appScriptMD5", "getAppScriptMD5", "setAppScriptMD5", "appScriptUrl", "getAppScriptUrl", "setAppScriptUrl", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "getEngine", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "isRecycled", "", "()Z", "setRecycled", "(Z)V", "jsapi", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "setJsapi", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;)V", "launched", "getLaunched", "setLaunched", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "setPerformanceHelper", "(Lcom/tencent/mm/pluginsdk/PerformanceHelper;)V", "refer", "getRefer", "setRefer", "used", "getUsed", "setUsed", "getWebComptInfo", "()Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getWorkerId", "()I", "recycle", "", "reuse", "webview-sdk_release"})
    public final class a
    {
      boolean EvG;
      String EvH;
      String EvI;
      String EvJ;
      r EvK;
      i EvL;
      final int EvM;
      final bqx EvN;
      boolean aHT;
      String appId;
      String okh;
      boolean used;
      
      public a(bqx parambqx, c paramc)
      {
        AppMethodBeat.i(82848);
        this.EvM = parambqx;
        this.EvN = paramc;
        this.appId = "";
        this.okh = "";
        this.EvH = "";
        this.EvI = "";
        this.EvJ = "";
        this$1 = this.EvN.name;
        d.g.b.p.g(c.l.this, "webComptInfo.name");
        this.EvL = new i(localObject, c.l.this, localObject.DzP);
        eWh().addJavascriptInterface(this.EvL, "__webcompt");
        AppMethodBeat.o(82848);
      }
      
      public final void aJK(String paramString)
      {
        AppMethodBeat.i(82846);
        d.g.b.p.h(paramString, "<set-?>");
        this.EvI = paramString;
        AppMethodBeat.o(82846);
      }
      
      public final com.tencent.mm.plugin.appbrand.jsruntime.g eWh()
      {
        AppMethodBeat.i(214388);
        com.tencent.mm.plugin.appbrand.jsruntime.g localg = c.eVU().tS(this.EvM);
        d.g.b.p.g(localg, "manager.getJsContext(workerId)");
        AppMethodBeat.o(214388);
        return localg;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"toJsonStringArray", "", "", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.b<List<? extends String>, String>
  {
    public static final m EvP;
    
    static
    {
      AppMethodBeat.i(82862);
      EvP = new m();
      AppMethodBeat.o(82862);
    }
    
    m()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"})
  public static final class n
    extends d.d.a
    implements CoroutineExceptionHandler
  {
    public n(f.c paramc, c paramc1, y.f paramf)
    {
      super();
    }
    
    public final void handleException(d.d.f paramf, Throwable paramThrowable)
    {
      AppMethodBeat.i(82863);
      this.EvQ.EuF.a(b.Euf);
      if ((paramThrowable instanceof c.j))
      {
        ((d.g.a.b)this.EvR.MLV).invoke(paramThrowable);
        AppMethodBeat.o(82863);
        return;
      }
      AppMethodBeat.o(82863);
      throw paramThrowable;
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.webview.webcompt.WebComponent$createJsContext$2", f="WebComponent.kt", gfL={237, 332, 337, 344}, m="invokeSuspend")
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class o
    extends d.d.b.a.j
    implements d.g.a.m<ah, d<? super d.z>, Object>
  {
    int label;
    private ah nWQ;
    Object nWR;
    Object olg;
    Object olh;
    Object oli;
    Object olj;
    Object olk;
    Object oll;
    Object olm;
    Object oln;
    Object olo;
    Object olp;
    
    o(c paramc, boolean paramBoolean, r paramr, String paramString1, bqx parambqx, String paramString2, String paramString3, y.f paramf, d paramd)
    {
      super();
    }
    
    public final d<d.z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(82875);
      d.g.b.p.h(paramd, "completion");
      paramd = new o(this.EvQ, this.EvS, this.EvT, this.lby, this.EvU, this.lOT, this.jKq, this.EvV, paramd);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(82875);
      return paramd;
    }
    
    public final Object cQ(final Object paramObject)
    {
      AppMethodBeat.i(82874);
      d.d.a.a locala = d.d.a.a.MLc;
      Object localObject1;
      Object localObject5;
      Object localObject2;
      label311:
      Object localObject3;
      label362:
      Object localObject4;
      label651:
      label687:
      label750:
      label755:
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
        paramObject = this.nWQ;
        localObject1 = c.EuR;
        this.nWR = paramObject;
        this.label = 1;
        if (c.b.a(this) == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
        }
      case 1: 
        paramObject = (ah)this.nWR;
        if (this.EvS) {
          c.a(this.EvQ, this.EvT);
        }
        localObject5 = new com.tencent.mm.ac.i();
        localObject1 = ((Iterable)n.a((CharSequence)n.nF(this.lby, "#"), new String[] { "&" })).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = n.a((CharSequence)((Iterator)localObject1).next(), new String[] { "=" });
          if (((List)localObject2).size() == 2) {
            ((com.tencent.mm.ac.i)localObject5).h((String)((List)localObject2).get(0), URLDecoder.decode((String)((List)localObject2).get(1), "UTF-8"));
          }
        }
        localObject1 = g.Ewv;
        if (g.a.getDebug())
        {
          localObject1 = g.Ewv;
          localObject1 = h.bFO().getString("debugA8Key", "");
          if (localObject1 == null) {
            d.g.b.p.gfZ();
          }
          if (!n.aE((CharSequence)localObject1))
          {
            i = 1;
            if (i == 0) {
              break label651;
            }
            localObject1 = new o(localObject1, c.b.a.EuY);
            if (localObject1 == null) {
              break label687;
            }
            localObject2 = (String)((o)localObject1).first;
            localObject1 = (c.b.a)((o)localObject1).second;
            localObject3 = c.EuR;
            c.b.eWe().Evb.add(new c.b.d((String)localObject2, null, (c.b.a)localObject1, 2));
            localObject1 = localObject2;
            localObject2 = c.EuR;
            ad.d(c.access$getTAG$cp(), "createJsContext a8key:".concat(String.valueOf(localObject1)));
            c.b(this.EvT, c.k.Evx);
            localObject2 = c.EuR;
            ad.i(c.access$getTAG$cp(), "createJsContext init " + this.lOT);
            c.c(this.EvT, c.k.EvA);
            localObject2 = c.a(this.EvQ).a(this.jKq, this.EvU, this.EvQ);
            c.b(this.EvT, c.k.EvA);
            localObject3 = this.lby;
            d.g.b.p.h(localObject3, "<set-?>");
            ((c.l.a)localObject2).okh = ((String)localObject3);
            ((c.l.a)localObject2).EvK = this.EvT;
            localObject3 = this.jKq;
            d.g.b.p.h(localObject3, "appId");
            if ((!((c.l.a)localObject2).aHT) || (!d.g.b.p.i(((c.l.a)localObject2).appId, localObject3))) {
              break label750;
            }
            ((c.l.a)localObject2).aHT = false;
            localObject4 = c.EuR;
            ad.i(c.access$getTAG$cp(), "WebComptWorker.reuse " + (String)localObject3 + '@' + ((c.l.a)localObject2).EvN.name + ':' + ((c.l.a)localObject2).EvM);
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label755;
          }
          c.b(((c.l.a)localObject2).eWh(), this.EvU, this.EvT.getStartTime());
          this.EvQ.EuF.a(b.EuD);
          paramObject = d.z.MKo;
          AppMethodBeat.o(82874);
          return paramObject;
          i = 0;
          break;
          if (((com.tencent.mm.ac.i)localObject5).has("debugA8Key"))
          {
            localObject1 = new o(((com.tencent.mm.ac.i)localObject5).getString("debugA8Key"), c.b.a.EuV);
            break label311;
          }
          localObject1 = null;
          break label311;
          localObject1 = new StringBuilder();
          localObject2 = c.EuR;
          localObject1 = c.eVX() + this.lOT + "?appId=" + this.jKq + "&src=" + a.htmlEncode(this.lby);
          break label362;
        }
        localObject3 = this.jKq;
        d.g.b.p.h(localObject3, "<set-?>");
        ((c.l.a)localObject2).appId = ((String)localObject3);
        d.g.b.p.h(localObject1, "<set-?>");
        ((c.l.a)localObject2).EvH = ((String)localObject1);
        localObject3 = this.EvU.md5;
        d.g.b.p.g(localObject3, "webCompt.md5");
        d.g.b.p.h(localObject3, "<set-?>");
        ((c.l.a)localObject2).EvJ = ((String)localObject3);
        localObject3 = this.EvU.url;
        d.g.b.p.g(localObject3, "webCompt.url");
        ((c.l.a)localObject2).aJK((String)localObject3);
        localObject4 = ((c.l.a)localObject2).eWh();
        ((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject4).setJsExceptionHandler((com.tencent.mm.plugin.appbrand.jsruntime.h)new a((c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ac.i)localObject5));
        this.EvV.MLV = ((d.g.a.b)new b((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject4, (c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ac.i)localObject5));
        c.a((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject4, this.EvU, this.EvT.getStartTime());
        localObject3 = kotlinx.coroutines.f.a(paramObject, paramObject.guE(), (d.g.a.m)new c(null, (c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ac.i)localObject5), 2);
        localObject6 = kotlinx.coroutines.f.a(paramObject, paramObject.guE(), (d.g.a.m)new d((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject4, null, (c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ac.i)localObject5), 2);
        this.nWR = paramObject;
        this.olg = localObject5;
        this.olh = localObject1;
        this.oli = localObject2;
        this.olj = localObject4;
        this.olk = localObject4;
        this.oll = localObject3;
        this.olm = localObject6;
        this.label = 2;
        localObject8 = ((aq)localObject6).f(this);
        if (localObject8 == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
        }
        break;
      case 2: 
        localObject6 = (aq)this.olm;
        localObject3 = (aq)this.oll;
        localObject7 = (com.tencent.mm.plugin.appbrand.jsruntime.g)this.olk;
        localObject4 = (com.tencent.mm.plugin.appbrand.jsruntime.g)this.olj;
        localObject2 = (c.l.a)this.oli;
        localObject1 = (String)this.olh;
        localObject9 = (com.tencent.mm.ac.i)this.olg;
        localObject8 = (ah)this.nWR;
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
        ((c.l.a)localObject2).aJK((String)localObject12);
        c.d((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject7, "(function(WeixinWebCompt){" + (String)localObject8 + "})(WeixinWebCompt);");
        this.nWR = paramObject;
        this.olg = localObject5;
        this.olh = localObject1;
        this.oli = localObject2;
        this.olj = localObject4;
        this.olk = localObject7;
        this.oll = localObject3;
        this.olm = localObject6;
        this.oln = localObject12;
        this.olo = localObject8;
        this.label = 3;
        Object localObject11 = ((aq)localObject3).f(this);
        Object localObject10;
        if (localObject11 == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
          localObject8 = (String)this.olo;
          localObject5 = (String)this.oln;
          localObject10 = (aq)this.olm;
          localObject3 = (aq)this.oll;
          localObject6 = (com.tencent.mm.plugin.appbrand.jsruntime.g)this.olk;
          localObject4 = (com.tencent.mm.plugin.appbrand.jsruntime.g)this.olj;
          localObject2 = (c.l.a)this.oli;
          localObject1 = (String)this.olh;
          localObject7 = (com.tencent.mm.ac.i)this.olg;
          localObject9 = (ah)this.nWR;
          localObject11 = paramObject;
        }
        for (;;)
        {
          paramObject = (c.a)localObject11;
          localObject11 = ((c.l.a)localObject2).EvL;
          localObject12 = paramObject.EuS.aIe(paramObject.omw);
          d.g.b.p.g(localObject12, "a8key.getJsPerm(fullUrl)");
          d.g.b.p.h(localObject12, "<set-?>");
          ((i)localObject11).DzO = ((JsapiPermissionWrapper)localObject12);
          c.a(this.EvQ, (com.tencent.mm.plugin.appbrand.jsruntime.g)localObject6, paramObject);
          ((c.l.a)localObject2).EvG = true;
          this.nWR = localObject9;
          this.olg = localObject7;
          this.olh = localObject1;
          this.oli = localObject2;
          this.olj = localObject4;
          this.olk = localObject6;
          this.oll = localObject3;
          this.olm = localObject10;
          this.oln = localObject5;
          this.olo = localObject8;
          this.olp = paramObject;
          this.label = 4;
          if (at.a(1000L, this) == locala)
          {
            AppMethodBeat.o(82874);
            return locala;
          }
          paramObject = c.EuR;
          c.b.vv(true);
          this.EvQ.EuF.a(b.Eui);
          paramObject = c.EuR;
          ad.d(c.access$getTAG$cp(), "createJsContext init finish " + this.lOT);
          paramObject = c.EuR;
          if (c.b.eWe().kmY) {
            this.EvQ.EuF.a(b.Euj);
          }
          paramObject = d.z.MKo;
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
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(82876);
      paramObject1 = ((o)a(paramObject1, (d)paramObject2)).cQ(d.z.MKo);
      AppMethodBeat.o(82876);
      return paramObject1;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$1"})
    static final class a
      implements com.tencent.mm.plugin.appbrand.jsruntime.h
    {
      a(c.l.a parama, c.o paramo, ah paramah, String paramString, com.tencent.mm.ac.i parami) {}
      
      public final void u(String paramString1, String paramString2)
      {
        AppMethodBeat.i(214390);
        Object localObject = c.EuR;
        ad.e(c.access$getTAG$cp(), "engine " + jdField_this.lOT + " exception: " + paramString1 + " \nstackTrace:\n" + paramString2);
        localObject = jdField_this.EvQ;
        String str = jdField_this.lOT;
        d.g.b.p.g(str, "name");
        d.g.b.p.g(paramString1, "message");
        c.a((c)localObject, str, paramString1, paramString2);
        jdField_this.EvQ.EuF.a(b.Euq);
        AppMethodBeat.o(214390);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$2", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$2"})
    static final class b
      extends d.g.b.q
      implements d.g.a.b<c.j, d.z>
    {
      b(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, c.l.a parama, c.o paramo, ah paramah, String paramString, com.tencent.mm.ac.i parami)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$asyncA8Key$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$3"})
    static final class c
      extends d.d.b.a.j
      implements d.g.a.m<ah, d<? super c.a>, Object>
    {
      int label;
      private ah nWQ;
      Object nWR;
      
      c(d paramd, c.l.a parama, c.o paramo, ah paramah, String paramString, com.tencent.mm.ac.i parami)
      {
        super();
      }
      
      public final d<d.z> a(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(82868);
        d.g.b.p.h(paramd, "completion");
        paramd = new c(paramd, this.EvW, jdField_this, paramObject, this.EvY, this.EvZ);
        paramd.nWQ = ((ah)paramObject);
        AppMethodBeat.o(82868);
        return paramd;
      }
      
      public final Object cQ(Object paramObject)
      {
        AppMethodBeat.i(82867);
        d.d.a.a locala = d.d.a.a.MLc;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82867);
          throw paramObject;
        case 0: 
          paramObject = this.nWQ;
          c.c(jdField_this.EvT, c.k.Evz);
          Object localObject = jdField_this.EvQ;
          String str1 = this.EvY;
          String str2 = jdField_this.EvU.name;
          d.g.b.p.g(str2, "webCompt.name");
          this.nWR = paramObject;
          this.label = 1;
          localObject = ((c)localObject).a(str1, str2, this);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(82867);
            return locala;
          }
          break;
        }
        c.b(jdField_this.EvT, c.k.Evz);
        AppMethodBeat.o(82867);
        return paramObject;
      }
      
      public final Object p(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82869);
        paramObject1 = ((c)a(paramObject1, (d)paramObject2)).cQ(d.z.MKo);
        AppMethodBeat.o(82869);
        return paramObject1;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$asyncAppScript$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$4"})
    static final class d
      extends d.d.b.a.j
      implements d.g.a.m<ah, d<? super o<? extends String, ? extends String>>, Object>
    {
      int label;
      private ah nWQ;
      Object nWR;
      Object olg;
      
      d(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, d paramd, c.l.a parama, c.o paramo, ah paramah, String paramString, com.tencent.mm.ac.i parami)
      {
        super();
      }
      
      public final d<d.z> a(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(82872);
        d.g.b.p.h(paramd, "completion");
        paramd = new d(this.olN, paramd, this.EvW, jdField_this, paramObject, this.EvY, this.EvZ);
        paramd.nWQ = ((ah)paramObject);
        AppMethodBeat.o(82872);
        return paramd;
      }
      
      public final Object cQ(Object paramObject)
      {
        AppMethodBeat.i(82871);
        d.d.a.a locala = d.d.a.a.MLc;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82871);
          throw paramObject;
        case 0: 
          paramObject = this.nWQ;
          c.c(jdField_this.EvT, c.k.EvB);
          this.nWR = paramObject;
          this.olg = this;
          this.label = 1;
          paramObject = new d.d.h(d.d.a.b.d(this));
          Object localObject = (d)paramObject;
          c.b localb = c.EuR;
          com.tencent.mm.ad.c.b(c.access$getTAG$cp(), (d.g.a.a)new d.g.b.q((d)localObject) {});
          localObject = paramObject.gfF();
          if (localObject == d.d.a.a.MLc) {
            d.g.b.p.h(this, "frame");
          }
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(82871);
            return locala;
          }
          break;
        }
        c.b(jdField_this.EvT, c.k.EvB);
        AppMethodBeat.o(82871);
        return paramObject;
      }
      
      public final Object p(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82873);
        paramObject1 = ((d)a(paramObject1, (d)paramObject2)).cQ(d.z.MKo);
        AppMethodBeat.o(82873);
        return paramObject1;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke"})
  static final class p
    extends d.g.b.q
    implements d.g.a.b<c.j, d.z>
  {
    public static final p Ewb;
    
    static
    {
      AppMethodBeat.i(82878);
      Ewb = new p();
      AppMethodBeat.o(82878);
    }
    
    p()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    q(c paramc, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback", "com/tencent/mm/plugin/webview/webcompt/WebComponent$errReport$1$2$2", "com/tencent/mm/plugin/webview/webcompt/WebComponent$$special$$inlined$let$lambda$1"})
  static final class r
    implements IPCRunCgi.a
  {
    r(c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(82879);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        this.EvQ.EuF.a(b.Euz);
      }
      AppMethodBeat.o(82879);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class s
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    public static final s Ewj;
    
    static
    {
      AppMethodBeat.i(82881);
      Ewj = new s();
      AppMethodBeat.o(82881);
    }
    
    s()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class t
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    t(c paramc, String paramString, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/webcompt/WebComponent$getA8Key$2$1$1", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "", "onUrlRedirect", "forceRedirect", "webview-sdk_release", "com/tencent/mm/plugin/webview/webcompt/WebComponent$$special$$inlined$apply$lambda$1"})
  public static final class u
    implements com.tencent.mm.plugin.webview.e.a<avj>
  {
    u(com.tencent.mm.plugin.webview.e.c paramc, d paramd, c paramc1, String paramString1, String paramString2) {}
    
    public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(82885);
      d.g.b.p.h(paramString1, "reqUrl");
      d.g.b.p.h(paramString2, "errMsg");
      paramString1 = this.Ewm;
      paramString2 = (Throwable)new c.j(20001, this.Ewn, "getA8Key error:" + paramInt2 + ", " + paramInt3 + ", " + paramString2);
      p.a locala = d.p.MKe;
      paramString1.eN(d.p.eL(d.q.o(paramString2)));
      this.EvQ.EuF.a(b.Eum);
      AppMethodBeat.o(82885);
    }
    
    public final void bm(int paramInt, String paramString)
    {
      AppMethodBeat.i(214394);
      d.g.b.p.h(paramString, "reqUrl");
      AppMethodBeat.o(214394);
    }
    
    public final void bn(int paramInt, String paramString)
    {
      AppMethodBeat.i(214393);
      d.g.b.p.h(paramString, "reqUrl");
      AppMethodBeat.o(214393);
    }
    
    public final void z(int paramInt, String paramString1, String paramString2) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"readText", "Lkotlin/Pair;", "", "T", "type", "errCode", "", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "debugType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "invoke", "(Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;)Lkotlin/Pair;"})
  static final class v
    extends d.g.b.q
    implements s<T, String, Integer, c.b.c, c.b.a, o<? extends String, ? extends String>>
  {
    v(c paramc, bqx parambqx)
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
      //   8: invokestatic 80	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: aload 4
      //   13: ldc 81
      //   15: invokestatic 80	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   18: aload 5
      //   20: ldc 82
      //   22: invokestatic 80	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   25: getstatic 86	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   28: astore 6
      //   30: invokestatic 90	com/tencent/mm/plugin/webview/k/c:access$getTAG$cp	()Ljava/lang/String;
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
      //   58: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   61: aload_1
      //   62: instanceof 117
      //   65: ifeq +104 -> 169
      //   68: new 119	d/o
      //   71: dup
      //   72: aload_1
      //   73: checkcast 117	com/tencent/mm/vfs/e
      //   76: invokevirtual 122	com/tencent/mm/vfs/e:getAbsolutePath	()Ljava/lang/String;
      //   79: aload_1
      //   80: checkcast 117	com/tencent/mm/vfs/e
      //   83: invokestatic 128	com/tencent/mm/vfs/f:ah	(Lcom/tencent/mm/vfs/e;)Ljava/lang/String;
      //   86: invokespecial 131	d/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   89: astore 6
      //   91: aload_0
      //   92: getfield 39	com/tencent/mm/plugin/webview/k/c$v:EvQ	Lcom/tencent/mm/plugin/webview/k/c;
      //   95: getfield 135	com/tencent/mm/plugin/webview/k/c:EuF	Lcom/tencent/mm/plugin/webview/k/j;
      //   98: getstatic 141	com/tencent/mm/plugin/webview/k/b:Euo	Lcom/tencent/mm/plugin/webview/k/b;
      //   101: invokevirtual 146	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   104: getstatic 86	com/tencent/mm/plugin/webview/k/c:EuR	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   107: astore 7
      //   109: invokestatic 152	com/tencent/mm/plugin/webview/k/c$b:eWe	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   112: getfield 158	com/tencent/mm/plugin/webview/k/c$b$b:Evb	Ljava/util/LinkedList;
      //   115: astore 7
      //   117: aload 6
      //   119: getfield 162	d/o:first	Ljava/lang/Object;
      //   122: astore 8
      //   124: aload 8
      //   126: ldc 164
      //   128: invokestatic 167	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   131: aload 7
      //   133: new 169	com/tencent/mm/plugin/webview/k/c$b$d
      //   136: dup
      //   137: aload 8
      //   139: checkcast 171	java/lang/String
      //   142: invokestatic 174	com/tencent/mm/plugin/webview/k/c:eVV	()Ljava/lang/String;
      //   145: ldc 175
      //   147: invokestatic 181	d/n/n:bp	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   150: aload 4
      //   152: aload 5
      //   154: invokespecial 184	com/tencent/mm/plugin/webview/k/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;)V
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
      //   188: getstatic 201	d/n/d:UTF_8	Ljava/nio/charset/Charset;
      //   191: astore 8
      //   193: new 119	d/o
      //   196: dup
      //   197: aload 6
      //   199: new 171	java/lang/String
      //   202: dup
      //   203: aload 7
      //   205: invokestatic 207	d/f/c:e	(Ljava/net/URL;)[B
      //   208: aload 8
      //   210: invokespecial 210	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   213: invokespecial 131	d/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   216: astore 6
      //   218: aload_0
      //   219: getfield 39	com/tencent/mm/plugin/webview/k/c$v:EvQ	Lcom/tencent/mm/plugin/webview/k/c;
      //   222: getfield 135	com/tencent/mm/plugin/webview/k/c:EuF	Lcom/tencent/mm/plugin/webview/k/j;
      //   225: getstatic 213	com/tencent/mm/plugin/webview/k/b:EtQ	Lcom/tencent/mm/plugin/webview/k/b;
      //   228: invokevirtual 146	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   231: goto -140 -> 91
      //   234: new 119	d/o
      //   237: dup
      //   238: ldc 175
      //   240: ldc 175
      //   242: invokespecial 131	d/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   245: astore 6
      //   247: goto -156 -> 91
      //   250: astore 4
      //   252: aload_1
      //   253: instanceof 192
      //   256: ifeq +16 -> 272
      //   259: aload_0
      //   260: getfield 39	com/tencent/mm/plugin/webview/k/c$v:EvQ	Lcom/tencent/mm/plugin/webview/k/c;
      //   263: getfield 135	com/tencent/mm/plugin/webview/k/c:EuF	Lcom/tencent/mm/plugin/webview/k/j;
      //   266: getstatic 216	com/tencent/mm/plugin/webview/k/b:EtR	Lcom/tencent/mm/plugin/webview/k/b;
      //   269: invokevirtual 146	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   272: aload_0
      //   273: getfield 39	com/tencent/mm/plugin/webview/k/c$v:EvQ	Lcom/tencent/mm/plugin/webview/k/c;
      //   276: getfield 135	com/tencent/mm/plugin/webview/k/c:EuF	Lcom/tencent/mm/plugin/webview/k/j;
      //   279: getstatic 219	com/tencent/mm/plugin/webview/k/b:Eup	Lcom/tencent/mm/plugin/webview/k/b;
      //   282: invokevirtual 146	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   285: aload_0
      //   286: getfield 39	com/tencent/mm/plugin/webview/k/c$v:EvQ	Lcom/tencent/mm/plugin/webview/k/c;
      //   289: getfield 135	com/tencent/mm/plugin/webview/k/c:EuF	Lcom/tencent/mm/plugin/webview/k/j;
      //   292: getstatic 222	com/tencent/mm/plugin/webview/k/b:EtT	Lcom/tencent/mm/plugin/webview/k/b;
      //   295: invokevirtual 146	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   298: aload_0
      //   299: getfield 41	com/tencent/mm/plugin/webview/k/c$v:EvU	Lcom/tencent/mm/protocal/protobuf/bqx;
      //   302: getfield 228	com/tencent/mm/protocal/protobuf/bqx:name	Ljava/lang/String;
      //   305: astore 5
      //   307: aload 5
      //   309: ldc 230
      //   311: invokestatic 167	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   314: new 232	com/tencent/mm/plugin/webview/k/c$j
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
      //   356: invokespecial 239	com/tencent/mm/plugin/webview/k/c$j:<init>	(ILjava/lang/String;Ljava/lang/String;)V
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"buildMatrix", "", "", "matrix", "", "invoke"})
  static final class w
    extends d.g.b.q
    implements d.g.a.b<List<? extends Integer>, List<? extends String>>
  {
    public static final w Ewo;
    
    static
    {
      AppMethodBeat.i(82892);
      Ewo = new w();
      AppMethodBeat.o(82892);
    }
    
    w()
    {
      super();
    }
    
    public static List<String> gX(List<Integer> paramList)
    {
      AppMethodBeat.i(82891);
      d.g.b.p.h(paramList, "matrix");
      SecureRandom localSecureRandom = new SecureRandom();
      Object localObject = (Iterable)paramList;
      paramList = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        byte[] arrayOfByte = new byte[((Number)((Iterator)localObject).next()).intValue()];
        localSecureRandom.nextBytes(arrayOfByte);
        paramList.add(d.a.e.a(arrayOfByte, (CharSequence)"", (d.g.a.b)a.Ewp));
      }
      paramList = (List)paramList;
      AppMethodBeat.o(82891);
      return paramList;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.b<Byte, String>
    {
      public static final a Ewp;
      
      static
      {
        AppMethodBeat.i(82889);
        Ewp = new a();
        AppMethodBeat.o(82889);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class x
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    x(c paramc, r paramr)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$refreshA8Key$2$1"})
  static final class y
    extends d.d.b.a.j
    implements d.g.a.m<ah, d<? super d.z>, Object>
  {
    int label;
    private ah nWQ;
    Object nWR;
    
    y(c.l.a parama, d paramd, c paramc, d.g.a.b paramb1, d.g.a.b paramb2)
    {
      super();
    }
    
    public final d<d.z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(82895);
      d.g.b.p.h(paramd, "completion");
      paramd = new y(this.Ewq, paramd, this.EvQ, this.Ewr, this.Ews);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(82895);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(82894);
      d.d.a.a locala = d.d.a.a.MLc;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(82894);
        throw paramObject;
      case 0: 
        paramObject = this.nWQ;
      }
      try
      {
        c localc = this.EvQ;
        String str = this.Ewq.EvH;
        this.nWR = paramObject;
        this.label = 1;
        paramObject = c.a(localc, str, this);
        if (paramObject != locala) {
          break label151;
        }
        AppMethodBeat.o(82894);
        return locala;
      }
      catch (c.j paramObject)
      {
        for (;;)
        {
          this.Ews.invoke(paramObject);
        }
      }
      paramObject = (c.a)paramObject;
      this.Ewr.invoke(c.a(this.EvQ, paramObject));
      paramObject = d.z.MKo;
      AppMethodBeat.o(82894);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(82896);
      paramObject1 = ((y)a(paramObject1, (d)paramObject2)).cQ(d.z.MKo);
      AppMethodBeat.o(82896);
      return paramObject1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "invoke"})
  static final class z
    extends d.g.b.q
    implements d.g.a.a<c.l>
  {
    z(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.c
 * JD-Core Version:    0.7.0.1
 */