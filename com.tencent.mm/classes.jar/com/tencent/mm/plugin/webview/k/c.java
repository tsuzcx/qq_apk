package com.tencent.mm.plugin.webview.k;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.dye;
import com.tencent.mm.protocal.protobuf.dyf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.xweb.z;
import d.d.d;
import d.d.f.c;
import d.g.a.s;
import d.g.b.u;
import d.g.b.v.f;
import d.g.b.w;
import d.n.n;
import d.o;
import d.p.a;
import d.y;
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
import kotlinx.coroutines.ag;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.as;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.bh;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "inited", "", "getJsapi", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "getReporter", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "workerManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "getWorkerManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "workerManager$delegate", "Lkotlin/Lazy;", "appendTags", "", "webCompt", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "cleanMainFrame", "clear", "createJsContext", "appId", "", "url", "launchMainFrame", "dispatchEvent", "event", "message", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluateMainFrame", "script", "callback", "Lkotlin/Function1;", "getA8Key", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "a8KeyUrl", "webComptName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppScript", "Lkotlin/Pair;", "paramsObject", "Lcom/tencent/mm/json/JSONObject;", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "performance", "frontEndPerformance", "postToBack", "postToFront", "refreshA8Key", "onerror", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "onsuccess", "config", "webComptInfo", "configTimeStamps", "", "resume", "end", "step", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "evaluate", "launch", "a8key", "records", "steps", "", "start", "toJson", "A8KeyResp", "Companion", "CreateJSContextException", "PerformanceSteps", "WebComptWorkerManager", "webview-sdk_release"})
public final class c
{
  private static final String CQC = "webcompt://";
  private static final d.f CQD;
  private static final d.f CQE;
  private static final d.f CQF;
  private static final d.f CQG;
  private static final e CQH;
  private static String CQI;
  private static final LinkedList<l> CQJ;
  private static final d.f CQK;
  private static final String CQL;
  private static final d.f CQM;
  public static final b CQN;
  static final String TAG = "MicroMsg.WebComponent";
  final j CQA;
  private final d.f CQB;
  final com.tencent.mm.plugin.webview.c.f Cjc;
  private boolean fJw;
  
  static
  {
    AppMethodBeat.i(82898);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(c.class), "workerManager", "getWorkerManager()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;")) };
    CQN = new b((byte)0);
    CQC = "webcompt://";
    TAG = "MicroMsg.WebComponent";
    CQD = d.g.K((d.g.a.a)g.CRp);
    CQE = d.g.K((d.g.a.a)d.CRm);
    CQF = d.g.K((d.g.a.a)f.CRn);
    CQG = d.g.K((d.g.a.a)i.CRr);
    CQH = new e();
    CQI = "";
    CQJ = new LinkedList();
    CQK = d.g.K((d.g.a.a)h.CRq);
    CQL = com.tencent.mm.loader.j.b.aph() + "webcompt_debug/";
    CQM = d.g.K((d.g.a.a)c.CRk);
    AppMethodBeat.o(82898);
  }
  
  public c(com.tencent.mm.plugin.webview.c.f paramf)
  {
    AppMethodBeat.i(205610);
    this.Cjc = paramf;
    this.CQA = new j();
    b.eHi().clear();
    this.CQB = d.g.K((d.g.a.a)new z(this));
    AppMethodBeat.o(205610);
  }
  
  /* Error */
  private final o<String, String> a(com.tencent.mm.ab.i parami, final bmn parambmn)
  {
    // Byte code:
    //   0: ldc_w 390
    //   3: invokestatic 239	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 367	com/tencent/mm/plugin/webview/k/c:CQA	Lcom/tencent/mm/plugin/webview/k/j;
    //   10: getstatic 396	com/tencent/mm/plugin/webview/k/b:CQj	Lcom/tencent/mm/plugin/webview/k/b;
    //   13: invokevirtual 399	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
    //   16: new 97	com/tencent/mm/plugin/webview/k/c$v
    //   19: dup
    //   20: aload_0
    //   21: aload_2
    //   22: invokespecial 402	com/tencent/mm/plugin/webview/k/c$v:<init>	(Lcom/tencent/mm/plugin/webview/k/c;Lcom/tencent/mm/protocal/protobuf/bmn;)V
    //   25: astore 4
    //   27: getstatic 270	com/tencent/mm/plugin/webview/k/c:TAG	Ljava/lang/String;
    //   30: new 322	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 404
    //   37: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: getfield 412	com/tencent/mm/protocal/protobuf/bmn:name	Ljava/lang/String;
    //   44: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 417	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: getstatic 423	com/tencent/mm/plugin/webview/k/g:CSt	Lcom/tencent/mm/plugin/webview/k/g$a;
    //   56: astore 5
    //   58: invokestatic 429	com/tencent/mm/plugin/webview/k/g$a:getDebug	()Z
    //   61: ifeq +77 -> 138
    //   64: getstatic 423	com/tencent/mm/plugin/webview/k/g:CSt	Lcom/tencent/mm/plugin/webview/k/g$a;
    //   67: astore 5
    //   69: invokestatic 435	com/tencent/mm/plugin/webview/k/h:bBL	()Lcom/tencent/mm/sdk/platformtools/aw;
    //   72: ldc_w 437
    //   75: ldc_w 307
    //   78: invokevirtual 443	com/tencent/mm/sdk/platformtools/aw:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 5
    //   83: aload 5
    //   85: ifnonnull +6 -> 91
    //   88: invokestatic 446	d/g/b/k:fOy	()V
    //   91: aload 5
    //   93: checkcast 448	java/lang/CharSequence
    //   96: invokestatic 454	d/n/n:aD	(Ljava/lang/CharSequence;)Z
    //   99: ifne +127 -> 226
    //   102: iconst_1
    //   103: istore_3
    //   104: iload_3
    //   105: ifeq +126 -> 231
    //   108: aload 4
    //   110: new 456	java/net/URL
    //   113: dup
    //   114: aload 5
    //   116: invokespecial 457	java/net/URL:<init>	(Ljava/lang/String;)V
    //   119: ldc_w 459
    //   122: ldc_w 460
    //   125: aconst_null
    //   126: getstatic 464	com/tencent/mm/plugin/webview/k/c$b$a:CQU	Lcom/tencent/mm/plugin/webview/k/c$b$a;
    //   129: iconst_4
    //   130: invokestatic 467	com/tencent/mm/plugin/webview/k/c$v:a	(Lcom/tencent/mm/plugin/webview/k/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)Ld/o;
    //   133: astore_1
    //   134: aload_1
    //   135: ifnonnull +981 -> 1116
    //   138: aload_2
    //   139: getfield 469	com/tencent/mm/protocal/protobuf/bmn:url	Ljava/lang/String;
    //   142: checkcast 448	java/lang/CharSequence
    //   145: astore_1
    //   146: aload_1
    //   147: ifnull +10 -> 157
    //   150: aload_1
    //   151: invokestatic 454	d/n/n:aD	(Ljava/lang/CharSequence;)Z
    //   154: ifeq +313 -> 467
    //   157: iconst_1
    //   158: istore_3
    //   159: iload_3
    //   160: ifne +28 -> 188
    //   163: aload_2
    //   164: getfield 472	com/tencent/mm/protocal/protobuf/bmn:md5	Ljava/lang/String;
    //   167: checkcast 448	java/lang/CharSequence
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +10 -> 182
    //   175: aload_1
    //   176: invokestatic 454	d/n/n:aD	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +293 -> 472
    //   182: iconst_1
    //   183: istore_3
    //   184: iload_3
    //   185: ifeq +292 -> 477
    //   188: aload_2
    //   189: getfield 412	com/tencent/mm/protocal/protobuf/bmn:name	Ljava/lang/String;
    //   192: astore_1
    //   193: aload_1
    //   194: ldc_w 474
    //   197: invokestatic 477	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   200: new 56	com/tencent/mm/plugin/webview/k/c$j
    //   203: dup
    //   204: sipush 21001
    //   207: aload_1
    //   208: ldc_w 479
    //   211: invokespecial 482	com/tencent/mm/plugin/webview/k/c$j:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   214: checkcast 389	java/lang/Throwable
    //   217: astore_1
    //   218: ldc_w 390
    //   221: invokestatic 349	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload_1
    //   225: athrow
    //   226: iconst_0
    //   227: istore_3
    //   228: goto -124 -> 104
    //   231: aload_1
    //   232: new 322	java/lang/StringBuilder
    //   235: dup
    //   236: ldc_w 484
    //   239: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   242: aload_2
    //   243: getfield 412	com/tencent/mm/protocal/protobuf/bmn:name	Ljava/lang/String;
    //   246: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokevirtual 490	com/tencent/mm/ab/i:has	(Ljava/lang/String;)Z
    //   255: ifeq +71 -> 326
    //   258: aload 4
    //   260: new 456	java/net/URL
    //   263: dup
    //   264: aload_1
    //   265: new 322	java/lang/StringBuilder
    //   268: dup
    //   269: ldc_w 484
    //   272: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload_2
    //   276: getfield 412	com/tencent/mm/protocal/protobuf/bmn:name	Ljava/lang/String;
    //   279: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokevirtual 493	com/tencent/mm/ab/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokespecial 457	java/net/URL:<init>	(Ljava/lang/String;)V
    //   291: new 322	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 495
    //   298: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: aload_2
    //   302: getfield 412	com/tencent/mm/protocal/protobuf/bmn:name	Ljava/lang/String;
    //   305: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: ldc_w 496
    //   314: aconst_null
    //   315: getstatic 499	com/tencent/mm/plugin/webview/k/c$b$a:CQR	Lcom/tencent/mm/plugin/webview/k/c$b$a;
    //   318: iconst_4
    //   319: invokestatic 467	com/tencent/mm/plugin/webview/k/c$v:a	(Lcom/tencent/mm/plugin/webview/k/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)Ld/o;
    //   322: astore_1
    //   323: goto -189 -> 134
    //   326: aload_1
    //   327: ldc_w 437
    //   330: invokevirtual 490	com/tencent/mm/ab/i:has	(Ljava/lang/String;)Z
    //   333: ifeq +37 -> 370
    //   336: aload 4
    //   338: new 456	java/net/URL
    //   341: dup
    //   342: aload_1
    //   343: ldc_w 437
    //   346: invokevirtual 493	com/tencent/mm/ab/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   349: invokespecial 457	java/net/URL:<init>	(Ljava/lang/String;)V
    //   352: ldc_w 501
    //   355: ldc_w 502
    //   358: aconst_null
    //   359: getstatic 499	com/tencent/mm/plugin/webview/k/c$b$a:CQR	Lcom/tencent/mm/plugin/webview/k/c$b$a;
    //   362: iconst_4
    //   363: invokestatic 467	com/tencent/mm/plugin/webview/k/c$v:a	(Lcom/tencent/mm/plugin/webview/k/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)Ld/o;
    //   366: astore_1
    //   367: goto -233 -> 134
    //   370: new 504	com/tencent/mm/vfs/e
    //   373: dup
    //   374: new 322	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   381: aload_2
    //   382: getfield 412	com/tencent/mm/protocal/protobuf/bmn:name	Ljava/lang/String;
    //   385: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: ldc_w 506
    //   391: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 509	com/tencent/mm/plugin/webview/k/c$b:aEj	(Ljava/lang/String;)Ljava/lang/String;
    //   400: invokespecial 510	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   403: invokevirtual 513	com/tencent/mm/vfs/e:exists	()Z
    //   406: ifeq +56 -> 462
    //   409: aload 4
    //   411: new 504	com/tencent/mm/vfs/e
    //   414: dup
    //   415: new 322	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   422: aload_2
    //   423: getfield 412	com/tencent/mm/protocal/protobuf/bmn:name	Ljava/lang/String;
    //   426: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc_w 506
    //   432: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 509	com/tencent/mm/plugin/webview/k/c$b:aEj	(Ljava/lang/String;)Ljava/lang/String;
    //   441: invokespecial 510	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   444: ldc_w 515
    //   447: ldc_w 516
    //   450: aconst_null
    //   451: getstatic 519	com/tencent/mm/plugin/webview/k/c$b$a:CQS	Lcom/tencent/mm/plugin/webview/k/c$b$a;
    //   454: iconst_4
    //   455: invokestatic 467	com/tencent/mm/plugin/webview/k/c$v:a	(Lcom/tencent/mm/plugin/webview/k/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)Ld/o;
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
    //   477: new 504	com/tencent/mm/vfs/e
    //   480: dup
    //   481: new 322	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   488: aload_2
    //   489: invokestatic 522	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/protocal/protobuf/bmn;)Ljava/lang/String;
    //   492: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: ldc_w 506
    //   498: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokespecial 510	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   507: invokevirtual 513	com/tencent/mm/vfs/e:exists	()Z
    //   510: ifeq +180 -> 690
    //   513: aload 4
    //   515: new 504	com/tencent/mm/vfs/e
    //   518: dup
    //   519: new 322	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   526: aload_2
    //   527: invokestatic 522	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/protocal/protobuf/bmn;)Ljava/lang/String;
    //   530: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc_w 506
    //   536: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokespecial 510	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   545: ldc_w 524
    //   548: sipush 21004
    //   551: getstatic 528	com/tencent/mm/plugin/webview/k/c$b$c:CRb	Lcom/tencent/mm/plugin/webview/k/c$b$c;
    //   554: aconst_null
    //   555: bipush 8
    //   557: invokestatic 467	com/tencent/mm/plugin/webview/k/c$v:a	(Lcom/tencent/mm/plugin/webview/k/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)Ld/o;
    //   560: astore_1
    //   561: aload_0
    //   562: getfield 367	com/tencent/mm/plugin/webview/k/c:CQA	Lcom/tencent/mm/plugin/webview/k/j;
    //   565: getstatic 531	com/tencent/mm/plugin/webview/k/b:CPI	Lcom/tencent/mm/plugin/webview/k/b;
    //   568: invokevirtual 399	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
    //   571: getstatic 270	com/tencent/mm/plugin/webview/k/c:TAG	Ljava/lang/String;
    //   574: new 322	java/lang/StringBuilder
    //   577: dup
    //   578: ldc_w 533
    //   581: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   584: aload_2
    //   585: getfield 412	com/tencent/mm/protocal/protobuf/bmn:name	Ljava/lang/String;
    //   588: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 417	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: aload_1
    //   598: getfield 539	d/o:second	Ljava/lang/Object;
    //   601: checkcast 541	java/lang/String
    //   604: invokevirtual 545	java/lang/String:length	()I
    //   607: iconst_1
    //   608: if_icmple +496 -> 1104
    //   611: getstatic 270	com/tencent/mm/plugin/webview/k/c:TAG	Ljava/lang/String;
    //   614: astore 4
    //   616: new 322	java/lang/StringBuilder
    //   619: dup
    //   620: ldc_w 547
    //   623: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   626: aload_2
    //   627: getfield 412	com/tencent/mm/protocal/protobuf/bmn:name	Ljava/lang/String;
    //   630: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: bipush 10
    //   635: invokevirtual 550	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   638: astore_2
    //   639: aload_1
    //   640: getfield 539	d/o:second	Ljava/lang/Object;
    //   643: checkcast 541	java/lang/String
    //   646: astore 5
    //   648: bipush 100
    //   650: aload_1
    //   651: getfield 539	d/o:second	Ljava/lang/Object;
    //   654: checkcast 541	java/lang/String
    //   657: invokevirtual 545	java/lang/String:length	()I
    //   660: iconst_1
    //   661: isub
    //   662: invokestatic 556	java/lang/Math:min	(II)I
    //   665: istore_3
    //   666: aload 5
    //   668: ifnonnull +405 -> 1073
    //   671: new 558	d/v
    //   674: dup
    //   675: ldc_w 560
    //   678: invokespecial 561	d/v:<init>	(Ljava/lang/String;)V
    //   681: astore_1
    //   682: ldc_w 390
    //   685: invokestatic 349	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   688: aload_1
    //   689: athrow
    //   690: new 456	java/net/URL
    //   693: dup
    //   694: aload_2
    //   695: getfield 469	com/tencent/mm/protocal/protobuf/bmn:url	Ljava/lang/String;
    //   698: invokespecial 457	java/net/URL:<init>	(Ljava/lang/String;)V
    //   701: astore 5
    //   703: getstatic 270	com/tencent/mm/plugin/webview/k/c:TAG	Ljava/lang/String;
    //   706: ldc_w 563
    //   709: aload 5
    //   711: invokestatic 567	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   714: invokevirtual 570	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   717: invokestatic 572	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: aload 5
    //   722: invokevirtual 576	java/net/URL:openStream	()Ljava/io/InputStream;
    //   725: checkcast 578	java/io/Closeable
    //   728: astore 6
    //   730: aconst_null
    //   731: astore 4
    //   733: aload 6
    //   735: checkcast 580	java/io/InputStream
    //   738: astore_1
    //   739: aload_1
    //   740: ldc_w 582
    //   743: invokestatic 477	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   746: aload_1
    //   747: invokestatic 588	d/f/a:U	(Ljava/io/InputStream;)[B
    //   750: astore_1
    //   751: aload_2
    //   752: getfield 472	com/tencent/mm/protocal/protobuf/bmn:md5	Ljava/lang/String;
    //   755: new 590	java/io/ByteArrayInputStream
    //   758: dup
    //   759: aload_1
    //   760: invokespecial 593	java/io/ByteArrayInputStream:<init>	([B)V
    //   763: checkcast 580	java/io/InputStream
    //   766: aload_1
    //   767: arraylength
    //   768: invokestatic 598	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   771: invokestatic 601	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   774: ifeq +149 -> 923
    //   777: new 504	com/tencent/mm/vfs/e
    //   780: dup
    //   781: new 322	java/lang/StringBuilder
    //   784: dup
    //   785: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   788: aload_2
    //   789: invokestatic 522	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/protocal/protobuf/bmn;)Ljava/lang/String;
    //   792: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: ldc_w 506
    //   798: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokespecial 510	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   807: astore 7
    //   809: new 504	com/tencent/mm/vfs/e
    //   812: dup
    //   813: aload 7
    //   815: invokevirtual 604	com/tencent/mm/vfs/e:getParent	()Ljava/lang/String;
    //   818: invokespecial 510	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   821: invokevirtual 607	com/tencent/mm/vfs/e:mkdirs	()Z
    //   824: pop
    //   825: aload 7
    //   827: invokevirtual 610	com/tencent/mm/vfs/e:createNewFile	()Z
    //   830: pop
    //   831: aload 7
    //   833: aload_1
    //   834: invokestatic 615	com/tencent/mm/vfs/f:b	(Lcom/tencent/mm/vfs/e;[B)V
    //   837: invokestatic 371	com/tencent/mm/plugin/webview/k/c$b:eHi	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
    //   840: getfield 618	com/tencent/mm/plugin/webview/k/c$b$b:CQX	Ljava/util/LinkedList;
    //   843: astore 7
    //   845: aload 5
    //   847: invokevirtual 619	java/net/URL:toString	()Ljava/lang/String;
    //   850: astore 8
    //   852: aload 8
    //   854: ldc_w 621
    //   857: invokestatic 477	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   860: aload 7
    //   862: new 19	com/tencent/mm/plugin/webview/k/c$b$d
    //   865: dup
    //   866: aload 8
    //   868: getstatic 624	com/tencent/mm/plugin/webview/k/c$b$c:CRc	Lcom/tencent/mm/plugin/webview/k/c$b$c;
    //   871: aconst_null
    //   872: iconst_4
    //   873: invokespecial 627	com/tencent/mm/plugin/webview/k/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)V
    //   876: invokevirtual 631	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   879: pop
    //   880: new 535	d/o
    //   883: dup
    //   884: aload 5
    //   886: invokevirtual 619	java/net/URL:toString	()Ljava/lang/String;
    //   889: new 541	java/lang/String
    //   892: dup
    //   893: aload_1
    //   894: getstatic 637	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   897: invokespecial 640	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   900: invokespecial 643	d/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   903: astore_1
    //   904: aload_0
    //   905: getfield 367	com/tencent/mm/plugin/webview/k/c:CQA	Lcom/tencent/mm/plugin/webview/k/j;
    //   908: getstatic 646	com/tencent/mm/plugin/webview/k/b:CPJ	Lcom/tencent/mm/plugin/webview/k/b;
    //   911: invokevirtual 399	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
    //   914: aload 6
    //   916: aconst_null
    //   917: invokestatic 651	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   920: goto -349 -> 571
    //   923: aload_0
    //   924: getfield 367	com/tencent/mm/plugin/webview/k/c:CQA	Lcom/tencent/mm/plugin/webview/k/j;
    //   927: getstatic 654	com/tencent/mm/plugin/webview/k/b:CPO	Lcom/tencent/mm/plugin/webview/k/b;
    //   930: invokevirtual 399	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
    //   933: aload_2
    //   934: getfield 412	com/tencent/mm/protocal/protobuf/bmn:name	Ljava/lang/String;
    //   937: astore_1
    //   938: aload_1
    //   939: ldc_w 474
    //   942: invokestatic 477	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   945: new 56	com/tencent/mm/plugin/webview/k/c$j
    //   948: dup
    //   949: sipush 21003
    //   952: aload_1
    //   953: ldc_w 656
    //   956: aload 5
    //   958: invokestatic 567	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   961: invokevirtual 570	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   964: invokespecial 482	com/tencent/mm/plugin/webview/k/c$j:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   967: checkcast 389	java/lang/Throwable
    //   970: astore_1
    //   971: ldc_w 390
    //   974: invokestatic 349	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   977: aload_1
    //   978: athrow
    //   979: astore 4
    //   981: ldc_w 390
    //   984: invokestatic 349	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   987: aload 4
    //   989: athrow
    //   990: astore_1
    //   991: aload 6
    //   993: aload 4
    //   995: invokestatic 651	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   998: ldc_w 390
    //   1001: invokestatic 349	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1004: aload_1
    //   1005: athrow
    //   1006: astore_1
    //   1007: aload_2
    //   1008: getfield 412	com/tencent/mm/protocal/protobuf/bmn:name	Ljava/lang/String;
    //   1011: astore_2
    //   1012: aload_2
    //   1013: ldc_w 474
    //   1016: invokestatic 477	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1019: new 56	com/tencent/mm/plugin/webview/k/c$j
    //   1022: dup
    //   1023: sipush 21002
    //   1026: aload_2
    //   1027: new 322	java/lang/StringBuilder
    //   1030: dup
    //   1031: ldc_w 658
    //   1034: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1037: aload_1
    //   1038: invokevirtual 661	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1041: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: ldc_w 663
    //   1047: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: aload 5
    //   1052: invokevirtual 666	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1055: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1058: invokespecial 482	com/tencent/mm/plugin/webview/k/c$j:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   1061: checkcast 389	java/lang/Throwable
    //   1064: astore_1
    //   1065: ldc_w 390
    //   1068: invokestatic 349	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1071: aload_1
    //   1072: athrow
    //   1073: aload 5
    //   1075: iconst_0
    //   1076: iload_3
    //   1077: invokevirtual 670	java/lang/String:substring	(II)Ljava/lang/String;
    //   1080: astore 5
    //   1082: aload 5
    //   1084: ldc_w 672
    //   1087: invokestatic 477	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1090: aload 4
    //   1092: aload_2
    //   1093: aload 5
    //   1095: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1101: invokestatic 572	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1104: ldc_w 390
    //   1107: invokestatic 349	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1110: aload_1
    //   1111: areturn
    //   1112: astore_1
    //   1113: goto -122 -> 991
    //   1116: goto -545 -> 571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1119	0	this	c
    //   0	1119	1	parami	com.tencent.mm.ab.i
    //   0	1119	2	parambmn	bmn
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
    Object localObject1 = parama.CQP;
    Object localObject2 = this.Cjc.getSettings();
    d.g.b.k.g(localObject2, "jsapi.settings");
    localObject2 = ((z)localObject2).getUserAgentString();
    d.g.b.k.g(localObject2, "jsapi.settings.userAgentString");
    ((Map)localObject1).put("User-agent", localObject2);
    localObject1 = new com.tencent.mm.ab.i((Map)localObject1).toString();
    d.g.b.k.g(localObject1, "JSONObject(httpHeaders.a…ing\n        }).toString()");
    localObject2 = new StringBuilder("{clientVersion:");
    String str = com.tencent.mm.sdk.platformtools.h.gMJ;
    d.g.b.k.g(str, "BuildInfo.CLIENT_VERSION");
    parama = a.aEe(str) + ",headers:" + (String)localObject1 + ",fullUrl:" + a.aEe(parama.nJQ) + '}';
    AppMethodBeat.o(82905);
    return parama;
  }
  
  static String a(com.tencent.mm.pluginsdk.q paramq, List<? extends k> paramList)
  {
    AppMethodBeat.i(82902);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      localLinkedList.add(String.valueOf(paramq.bJ(localk.lgk + "_START", paramq.getStartTime()) - paramq.getStartTime()));
      localLinkedList.add(String.valueOf(paramq.bJ(localk.lgk + "_END", paramq.getStartTime()) - paramq.getStartTime()));
    }
    paramq = d.a.j.a((Iterable)localLinkedList, (CharSequence)",", null, (CharSequence)",", 0, null, null, 58) + n.r((CharSequence)"0,", (9 - paramList.size()) * 2);
    AppMethodBeat.o(82902);
    return paramq;
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, bmn parambmn, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(205604);
    Object localObject = m.CRL;
    localObject = new StringBuilder("WeixinWebCompt.config({resume:").append(paramBoolean).append(", debug:");
    g.a locala = g.CSt;
    c(paramg, g.a.getDebug() + ", iframeUrlPattern:'" + b.eHj() + "', configFinishTs:" + paramLong + ", bizReportId:" + parambmn.FbN + ", options:" + parambmn.FbO + "})");
    ac.i(TAG, "WeixinWebCompt.config:" + parambmn.FbO);
    AppMethodBeat.o(205604);
  }
  
  static void a(com.tencent.mm.pluginsdk.q paramq, k paramk)
  {
    AppMethodBeat.i(82901);
    paramq.bI(paramk.lgk + "_START", System.currentTimeMillis());
    AppMethodBeat.o(82901);
  }
  
  static void c(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, String paramString)
  {
    AppMethodBeat.i(205606);
    paramg.evaluateJavascript(paramString, null);
    AppMethodBeat.o(205606);
  }
  
  public static final void eHd()
  {
    AppMethodBeat.i(82923);
    b.uK(false);
    AppMethodBeat.o(82923);
  }
  
  private final void h(final String paramString, final d.g.a.b<? super String, y> paramb)
  {
    AppMethodBeat.i(82912);
    com.tencent.mm.ac.c.g((d.g.a.a)new t(this, paramString, paramb));
    AppMethodBeat.o(82912);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.g aEf(String paramString)
  {
    AppMethodBeat.i(205608);
    d.g.b.k.h(paramString, "webCompt");
    paramString = (c.l.a)eGQ().get(paramString);
    if (paramString != null)
    {
      paramString = paramString.eHo();
      AppMethodBeat.o(205608);
      return paramString;
    }
    AppMethodBeat.o(205608);
    return null;
  }
  
  public final void aP(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(205607);
    d.g.b.k.h(paramString1, "webCompt");
    d.g.b.k.h(paramString2, "event");
    if (bs.isNullOrNil(paramString2))
    {
      ac.w(TAG, "dispatch event is null");
      AppMethodBeat.o(205607);
      return;
    }
    ac.v(TAG, "dispatch event=%s, value=%s", new Object[] { paramString2, paramString3 });
    com.tencent.mm.ac.c.g((d.g.a.a)new q(this, paramString1, paramString2, paramString3));
    this.CQA.a(b.CQw);
    AppMethodBeat.o(205607);
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
        b.eHi().clear();
        if (!this.fJw) {
          break label301;
        }
        l locall = eGQ();
        j localj = this.CQA;
        d.g.b.k.h(localj, "reporter");
        ac.i(b.eHe(), "clear workerManager#" + locall.id);
        Iterator localIterator = locall.entrySet().iterator();
        i = -1;
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        locala = (c.l.a)localEntry.getValue();
        if ((!locala.used) && (locala.CRC) && (!locall.CRB.containsKey(localEntry.getKey())))
        {
          locala.aGc = true;
          locala.CRG = null;
          ac.i(b.eHe(), "WebComptWorker.recycle " + locala.appId + '@' + locala.CRJ.name + ':' + locala.CRI);
          ((Map)locall.CRB).put(localEntry.getKey(), locala);
          localj.a(b.CQx);
          continue;
        }
        if (locala.used) {
          break label279;
        }
      }
      finally {}
      if (locala.CRI == localObject.CRz) {
        i = localObject.CRz;
      } else {
        label279:
        locala.eHo().destroy();
      }
    }
    localObject.CRz = i;
    localObject.clear();
    label301:
    AppMethodBeat.o(82900);
  }
  
  final l eGQ()
  {
    AppMethodBeat.i(82899);
    l locall = (l)this.CQB.getValue();
    AppMethodBeat.o(82899);
    return locall;
  }
  
  public final void eGR()
  {
    AppMethodBeat.i(205609);
    if (this.fJw)
    {
      a(this, "WeixinOpenTags.onClean()");
      this.CQA.a(b.CPV);
    }
    AppMethodBeat.o(205609);
  }
  
  public final void h(final String paramString1, final String paramString2, final String paramString3, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(82910);
    d.g.b.k.h(paramString1, "webCompt");
    d.g.b.k.h(paramString2, "errMsg");
    Object localObject = (c.l.a)eGQ().get(paramString1);
    if (localObject != null)
    {
      dye localdye = new dye();
      localdye.dkm = paramString2;
      localdye.Gej = paramString3;
      localdye.Gek = paramInt1;
      localdye.Gel = paramInt2;
      z localz = this.Cjc.getSettings();
      d.g.b.k.g(localz, "jsapi.settings");
      localdye.GbJ = localz.getUserAgentString();
      localdye.nHD = ((c.l.a)localObject).nHD;
      localdye.djj = ((c.l.a)localObject).appId;
      localdye.Gem = paramString1;
      localdye.Gen = b.eHm().getVersion();
      localdye.Geo = ((c.l.a)localObject).CRE;
      localdye.Gep = ((c.l.a)localObject).CRF;
      this.CQA.a(b.CQu);
      localObject = new b.a();
      ((b.a)localObject).c((com.tencent.mm.bw.a)localdye);
      ((b.a)localObject).d((com.tencent.mm.bw.a)new dyf());
      ((b.a)localObject).Am("/cgi-bin/mmbiz-bin/webcompt/reportjserr");
      ((b.a)localObject).op(2914);
      ((b.a)localObject).or(0);
      ((b.a)localObject).os(0);
      IPCRunCgi.a(((b.a)localObject).aAz(), (IPCRunCgi.a)new r(this, paramString2, paramString3, paramInt1, paramInt2, paramString1));
      AppMethodBeat.o(82910);
      return;
    }
    AppMethodBeat.o(82910);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "", "a8key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "fullUrl", "", "httpHeaders", "", "(Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;Ljava/lang/String;Ljava/util/Map;)V", "getFullUrl", "()Ljava/lang/String;", "getHttpHeaders", "()Ljava/util/Map;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "webview-sdk_release"})
  public static final class a
  {
    final com.tencent.mm.plugin.webview.e.c CQO;
    final Map<String, String> CQP;
    final String nJQ;
    
    public a(com.tencent.mm.plugin.webview.e.c paramc, String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(205588);
      this.CQO = paramc;
      this.nJQ = paramString;
      this.CQP = paramMap;
      AppMethodBeat.o(205588);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion;", "", "()V", "PREFIX_DEBUG_PATH", "", "TAG", "getTAG$webview_sdk_release", "()Ljava/lang/String;", "_cachedFilePath", "debugInfo", "getDebugInfo", "debugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "getDebugger", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "debugger$delegate", "Lkotlin/Lazy;", "iframeUrlPattern", "getIframeUrlPattern", "iframeUrlPattern$delegate", "manager", "com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$1", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$1;", "matrix", "", "", "getMatrix", "()Ljava/util/List;", "matrix$delegate", "meta", "Lcom/tencent/mm/json/JSONObject;", "getMeta", "()Lcom/tencent/mm/json/JSONObject;", "meta$delegate", "preloadWorkers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "scheme", "scheme$annotations", "getScheme", "scriptManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "getScriptManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "scriptManager$delegate", "skeleton", "getSkeleton", "skeleton$delegate", "debugPath", "getDebugPath", "(Ljava/lang/String;)Ljava/lang/String;", "savePath", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getSavePath", "(Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;)Ljava/lang/String;", "version", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "clearDebugPath", "", "jsapiOnly", "", "appOnly", "getCachedFilePath", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalScript", "path", "scripts", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScript", "preloadWorker", "force", "readText", "DebugType", "Debugger", "ResType", "Script", "ScriptManager", "Worker", "webview-sdk_release"})
  public static final class b
  {
    static
    {
      AppMethodBeat.i(82819);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(b.class), "meta", "getMeta()Lcom/tencent/mm/json/JSONObject;")), (d.l.k)w.a(new u(w.bn(b.class), "iframeUrlPattern", "getIframeUrlPattern()Ljava/lang/String;")), (d.l.k)w.a(new u(w.bn(b.class), "matrix", "getMatrix()Ljava/util/List;")), (d.l.k)w.a(new u(w.bn(b.class), "skeleton", "getSkeleton()Ljava/lang/String;")), (d.l.k)w.a(new u(w.bn(b.class), "scriptManager", "getScriptManager()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;")), (d.l.k)w.a(new u(w.bn(b.class), "debugger", "getDebugger()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;")) };
      AppMethodBeat.o(82819);
    }
    
    /* Error */
    private static String a(com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc_w 281
      //   5: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: aload_1
      //   10: invokeinterface 287 2 0
      //   15: astore_0
      //   16: aload_0
      //   17: ifnull +62 -> 79
      //   20: aload_0
      //   21: checkcast 289	java/io/Closeable
      //   24: astore_3
      //   25: new 291	java/lang/String
      //   28: dup
      //   29: aload_3
      //   30: checkcast 293	java/io/InputStream
      //   33: invokestatic 299	d/f/a:U	(Ljava/io/InputStream;)[B
      //   36: getstatic 305	d/n/d:UTF_8	Ljava/nio/charset/Charset;
      //   39: invokespecial 308	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   42: astore_0
      //   43: aload_3
      //   44: aconst_null
      //   45: invokestatic 313	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   48: ldc_w 281
      //   51: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: aload_0
      //   55: areturn
      //   56: astore_1
      //   57: ldc_w 281
      //   60: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   63: aload_1
      //   64: athrow
      //   65: astore_0
      //   66: aload_3
      //   67: aload_1
      //   68: invokestatic 313	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   71: ldc_w 281
      //   74: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   77: aload_0
      //   78: athrow
      //   79: ldc_w 281
      //   82: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   85: ldc_w 314
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
    
    private static String aEi(String paramString)
    {
      AppMethodBeat.i(82828);
      paramString = c.eGT() + paramString;
      AppMethodBeat.o(82828);
      return paramString;
    }
    
    public static String ddr()
    {
      AppMethodBeat.i(82831);
      Object localObject = c.CQN;
      localObject = eHh();
      StringBuilder localStringBuilder = new StringBuilder("\n            [debug]\n            debug: ");
      g.a locala = g.CSt;
      localObject = n.aWZ(g.a.getDebug() + "\n            \n            [lib]\n            version: " + ((b)localObject).CQZ + "\n            res: " + ((b)localObject).CQY + "\n\n            " + d.a.j.a((Iterable)((b)localObject).CQX, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n            \n            " + d.a.j.a((Iterable)((b)localObject).CQW, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n            ");
      AppMethodBeat.o(82831);
      return localObject;
    }
    
    public static String eHe()
    {
      AppMethodBeat.i(205593);
      String str = c.access$getTAG$cp();
      AppMethodBeat.o(205593);
      return str;
    }
    
    private static e eHg()
    {
      AppMethodBeat.i(82827);
      Object localObject = c.eHb();
      b localb = c.CQN;
      localObject = (e)((d.f)localObject).getValue();
      AppMethodBeat.o(82827);
      return localObject;
    }
    
    private static b eHh()
    {
      AppMethodBeat.i(82830);
      Object localObject = c.eHc();
      b localb = c.CQN;
      localObject = (b)((d.f)localObject).getValue();
      AppMethodBeat.o(82830);
      return localObject;
    }
    
    /* Error */
    private static String f(String paramString, LinkedList<d> paramLinkedList)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc_w 497
      //   5: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 445	com/tencent/mm/plugin/webview/k/c:access$getTAG$cp	()Ljava/lang/String;
      //   11: ldc_w 499
      //   14: iconst_1
      //   15: anewarray 4	java/lang/Object
      //   18: dup
      //   19: iconst_0
      //   20: aload_0
      //   21: aastore
      //   22: invokestatic 504	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   25: getstatic 374	com/tencent/mm/plugin/webview/k/g:CSt	Lcom/tencent/mm/plugin/webview/k/g$a;
      //   28: astore_3
      //   29: invokestatic 380	com/tencent/mm/plugin/webview/k/g$a:getDebug	()Z
      //   32: ifeq +181 -> 213
      //   35: new 433	com/tencent/mm/vfs/e
      //   38: dup
      //   39: ldc_w 506
      //   42: aload_0
      //   43: invokestatic 510	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   46: invokevirtual 513	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   49: invokestatic 359	com/tencent/mm/plugin/webview/k/c$b:aEi	(Ljava/lang/String;)Ljava/lang/String;
      //   52: invokespecial 436	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
      //   55: astore_3
      //   56: aload_3
      //   57: invokevirtual 516	com/tencent/mm/vfs/e:exists	()Z
      //   60: ifeq +38 -> 98
      //   63: aload_1
      //   64: ifnull +21 -> 85
      //   67: aload_1
      //   68: new 17	com/tencent/mm/plugin/webview/k/c$b$d
      //   71: dup
      //   72: aload_0
      //   73: aconst_null
      //   74: getstatic 520	com/tencent/mm/plugin/webview/k/c$b$a:CQS	Lcom/tencent/mm/plugin/webview/k/c$b$a;
      //   77: iconst_2
      //   78: invokespecial 523	com/tencent/mm/plugin/webview/k/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)V
      //   81: invokevirtual 529	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   84: pop
      //   85: aload_3
      //   86: invokestatic 535	com/tencent/mm/vfs/f:af	(Lcom/tencent/mm/vfs/e;)Ljava/lang/String;
      //   89: astore_0
      //   90: ldc_w 497
      //   93: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   96: aload_0
      //   97: areturn
      //   98: new 433	com/tencent/mm/vfs/e
      //   101: dup
      //   102: ldc_w 537
      //   105: invokestatic 359	com/tencent/mm/plugin/webview/k/c$b:aEi	(Ljava/lang/String;)Ljava/lang/String;
      //   108: invokespecial 436	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
      //   111: astore_3
      //   112: aload_3
      //   113: invokevirtual 516	com/tencent/mm/vfs/e:exists	()Z
      //   116: ifeq +97 -> 213
      //   119: aload_1
      //   120: ifnull +21 -> 141
      //   123: aload_1
      //   124: new 17	com/tencent/mm/plugin/webview/k/c$b$d
      //   127: dup
      //   128: aload_0
      //   129: aconst_null
      //   130: getstatic 540	com/tencent/mm/plugin/webview/k/c$b$a:CQT	Lcom/tencent/mm/plugin/webview/k/c$b$a;
      //   133: iconst_2
      //   134: invokespecial 523	com/tencent/mm/plugin/webview/k/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)V
      //   137: invokevirtual 529	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   140: pop
      //   141: new 542	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   144: dup
      //   145: aload_3
      //   146: invokespecial 544	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Lcom/tencent/mm/vfs/e;)V
      //   149: checkcast 289	java/io/Closeable
      //   152: astore_3
      //   153: aload_3
      //   154: checkcast 542	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   157: astore_1
      //   158: aload_1
      //   159: invokevirtual 547	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:aVW	()Z
      //   162: pop
      //   163: getstatic 180	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   166: astore 4
      //   168: aload_1
      //   169: checkcast 283	com/tencent/mm/plugin/appbrand/appcache/p
      //   172: aload_0
      //   173: invokestatic 187	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
      //   176: astore_0
      //   177: aload_3
      //   178: aconst_null
      //   179: invokestatic 313	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   182: ldc_w 497
      //   185: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   188: aload_0
      //   189: areturn
      //   190: astore_1
      //   191: ldc_w 497
      //   194: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   197: aload_1
      //   198: athrow
      //   199: astore_0
      //   200: aload_3
      //   201: aload_1
      //   202: invokestatic 313	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   205: ldc_w 497
      //   208: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   211: aload_0
      //   212: athrow
      //   213: invokestatic 490	com/tencent/mm/plugin/webview/k/c$b:eHg	()Lcom/tencent/mm/plugin/webview/k/c$b$e;
      //   216: astore_2
      //   217: aload_0
      //   218: ldc_w 548
      //   221: invokestatic 252	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   224: getstatic 180	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   227: astore_3
      //   228: aload_2
      //   229: getfield 552	com/tencent/mm/plugin/webview/k/c$b$e:CRg	Lcom/tencent/mm/plugin/appbrand/appcache/p;
      //   232: aload_0
      //   233: invokestatic 187	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
      //   236: astore_2
      //   237: aload_1
      //   238: ifnull +28 -> 266
      //   241: getstatic 180	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   244: astore_3
      //   245: aload_1
      //   246: new 17	com/tencent/mm/plugin/webview/k/c$b$d
      //   249: dup
      //   250: aload_0
      //   251: invokestatic 365	com/tencent/mm/plugin/webview/k/c$b:eHh	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   254: getfield 398	com/tencent/mm/plugin/webview/k/c$b$b:CQY	Lcom/tencent/mm/plugin/webview/k/c$b$c;
      //   257: aconst_null
      //   258: iconst_4
      //   259: invokespecial 523	com/tencent/mm/plugin/webview/k/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)V
      //   262: invokevirtual 529	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   265: pop
      //   266: ldc_w 497
      //   269: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public static String getScheme()
    {
      AppMethodBeat.i(82820);
      String str = c.eGV();
      AppMethodBeat.o(82820);
      return str;
    }
    
    public static void uK(boolean paramBoolean)
    {
      AppMethodBeat.i(82822);
      if (c.eGU().size() < 3)
      {
        if (paramBoolean) {
          break label52;
        }
        if (((Collection)c.eGU()).isEmpty()) {
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
      kotlinx.coroutines.f.b((ag)bh.LRM, (d.d.f)ay.gdP(), (d.g.a.m)new j(null), 2);
      AppMethodBeat.o(82822);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "", "(Ljava/lang/String;I)V", "NA", "PARAM", "SDCARD", "SDCARD_PKG", "COMMAND", "webview-sdk_release"})
    static enum a
    {
      static
      {
        AppMethodBeat.i(82775);
        a locala1 = new a("NA", 0);
        CQQ = locala1;
        a locala2 = new a("PARAM", 1);
        CQR = locala2;
        a locala3 = new a("SDCARD", 2);
        CQS = locala3;
        a locala4 = new a("SDCARD_PKG", 3);
        CQT = locala4;
        a locala5 = new a("COMMAND", 4);
        CQU = locala5;
        CQV = new a[] { locala1, locala2, locala3, locala4, locala5 };
        AppMethodBeat.o(82775);
      }
      
      private a() {}
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "", "()V", "isPreload", "", "()Z", "setPreload", "(Z)V", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "setResType", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;)V", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "verion", "", "getVerion", "()I", "setVerion", "(I)V", "workers", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "getWorkers", "clear", "", "webview-sdk_release"})
    static final class b
    {
      final LinkedList<c.b.f> CQW;
      final LinkedList<c.b.d> CQX;
      c.b.c CQY;
      int CQZ;
      boolean jSK;
      
      public b()
      {
        AppMethodBeat.i(82780);
        this.CQW = new LinkedList();
        this.CQX = new LinkedList();
        this.CQY = c.b.c.CRa;
        AppMethodBeat.o(82780);
      }
      
      public final void a(c.b.c paramc)
      {
        AppMethodBeat.i(82778);
        d.g.b.k.h(paramc, "<set-?>");
        this.CQY = paramc;
        AppMethodBeat.o(82778);
      }
      
      public final void clear()
      {
        AppMethodBeat.i(82779);
        this.CQW.clear();
        this.CQX.clear();
        AppMethodBeat.o(82779);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "", "(Ljava/lang/String;I)V", "NA", "CACHE", "NETWORK", "ASSETS", "webview-sdk_release"})
    static enum c
    {
      static
      {
        AppMethodBeat.i(82781);
        c localc1 = new c("NA", 0);
        CRa = localc1;
        c localc2 = new c("CACHE", 1);
        CRb = localc2;
        c localc3 = new c("NETWORK", 2);
        CRc = localc3;
        c localc4 = new c("ASSETS", 3);
        CRd = localc4;
        CRe = new c[] { localc1, localc2, localc3, localc4 };
        AppMethodBeat.o(82781);
      }
      
      private c() {}
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "", "uri", "", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "debugType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;)V", "getDebugType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getUri", "()Ljava/lang/String;", "toString", "webview-sdk_release"})
    static final class d
    {
      private final c.b.c CQY;
      private final c.b.a CRf;
      private final String uri;
      
      public d(String paramString, c.b.c paramc, c.b.a parama)
      {
        AppMethodBeat.i(82785);
        this.uri = paramString;
        this.CQY = paramc;
        this.CRf = parama;
        AppMethodBeat.o(82785);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(82784);
        StringBuilder localStringBuilder = new StringBuilder("[script]\n                ");
        if (this.CQY != c.b.c.CRa) {}
        for (String str = "resType: " + this.CQY;; str = "debugType: " + this.CRf)
        {
          str = n.aWZ(str + "\n                " + this.uri + "\n                ");
          AppMethodBeat.o(82784);
          return str;
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)V", "version", "", "getVersion", "()I", "version$delegate", "Lkotlin/Lazy;", "getScript", "", "path", "webview-sdk_release"})
    static final class e
    {
      final com.tencent.mm.plugin.appbrand.appcache.p CRg;
      private final d.f nHN;
      
      static
      {
        AppMethodBeat.i(82788);
        $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(e.class), "version", "getVersion()I")) };
        AppMethodBeat.o(82788);
      }
      
      public e(com.tencent.mm.plugin.appbrand.appcache.p paramp)
      {
        AppMethodBeat.i(82790);
        this.CRg = paramp;
        this.nHN = d.g.K((d.g.a.a)new a(this));
        AppMethodBeat.o(82790);
      }
      
      public final int getVersion()
      {
        AppMethodBeat.i(82789);
        int i = ((Number)this.nHN.getValue()).intValue();
        AppMethodBeat.o(82789);
        return i;
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
      static final class a
        extends d.g.b.l
        implements d.g.a.a<Integer>
      {
        a(c.b.e parame)
        {
          super();
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "", "id", "", "isPreload", "", "isRecycled", "(IZZ)V", "getId", "()I", "()Z", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "toString", "", "webview-sdk_release"})
    static final class f
    {
      final LinkedList<c.b.d> CQX;
      private final boolean aGc;
      private final int id;
      private final boolean jSK;
      
      private f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
      {
        AppMethodBeat.i(82792);
        this.id = paramInt;
        this.jSK = paramBoolean1;
        this.aGc = paramBoolean2;
        this.CQX = new LinkedList();
        AppMethodBeat.o(82792);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(82791);
        String str = n.aWZ("[worker #" + this.id + "]\n                preload: " + this.jSK + "\n                recycled: " + this.aGc + "\n                \n                " + d.a.j.a((Iterable)this.CQX, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n                ");
        AppMethodBeat.o(82791);
        return str;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"deleteChildJs", "", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
    static final class g
      extends d.g.b.l
      implements d.g.a.b<com.tencent.mm.vfs.e, y>
    {
      public static final g CRi;
      
      static
      {
        AppMethodBeat.i(82798);
        CRi = new g();
        AppMethodBeat.o(82798);
      }
      
      g()
      {
        super();
      }
      
      public static void T(com.tencent.mm.vfs.e parame)
      {
        AppMethodBeat.i(175715);
        d.g.b.k.h(parame, "$this$deleteChildJs");
        parame = parame.a((com.tencent.mm.vfs.g)1.CRj);
        d.g.b.k.g(parame, "listFiles { filter ->\n  …json\"))\n                }");
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
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
    static final class h<InputType, ResultType>
      implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCString>
    {
      public static final h CRl;
      
      static
      {
        AppMethodBeat.i(82802);
        CRl = new h();
        AppMethodBeat.o(82802);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
    static final class i
      extends d.g.b.l
      implements d.g.a.b<IPCString, y>
    {
      i(d paramd)
      {
        super();
      }
    }
    
    @d.d.b.a.e(c="com.tencent.mm.plugin.webview.webcompt.WebComponent$Companion$preloadWorker$1", f="WebComponent.kt", l={727}, m="invokeSuspend")
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class j
      extends d.d.b.a.i
      implements d.g.a.m<ag, d<? super y>, Object>
    {
      int label;
      private ag nvs;
      Object nvt;
      
      j(d paramd)
      {
        super();
      }
      
      public final d<y> a(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(82813);
        d.g.b.k.h(paramd, "completion");
        paramd = new j(paramd);
        paramd.nvs = ((ag)paramObject);
        AppMethodBeat.o(82813);
        return paramd;
      }
      
      public final Object cO(Object paramObject)
      {
        AppMethodBeat.i(82812);
        paramObject = d.d.a.a.KUd;
        Object localObject;
        c.b localb;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82812);
          throw paramObject;
        case 0: 
          localObject = this.nvs;
          localb = c.CQN;
          this.nvt = localObject;
          this.label = 1;
          if (c.b.a(this) == paramObject)
          {
            AppMethodBeat.o(82812);
            return paramObject;
          }
          break;
        }
        paramObject = new c.l();
        if (paramObject.CRz == -1)
        {
          localObject = c.eGS();
          localb = c.CQN;
          paramObject.CRz = ((c.e)localObject).create(c.b.g("/wxwebcompt.js", paramObject.CRA.CQX));
          localObject = c.CQN;
          ac.i(c.b.eHe(), "preload workerManager#" + paramObject.id);
        }
        for (;;)
        {
          c.eGU().offerFirst(paramObject);
          paramObject = y.KTp;
          AppMethodBeat.o(82812);
          return paramObject;
          localObject = c.CQN;
          ac.w(c.b.eHe(), "preload twice #" + paramObject.id);
        }
      }
      
      public final Object n(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82814);
        paramObject1 = ((j)a(paramObject1, (d)paramObject2)).cO(y.KTp);
        AppMethodBeat.o(82814);
        return paramObject1;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<c.b.b>
  {
    public static final c CRk;
    
    static
    {
      AppMethodBeat.i(82800);
      CRk = new c();
      AppMethodBeat.o(82800);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    public static final d CRm;
    
    static
    {
      AppMethodBeat.i(82805);
      CRm = new d();
      AppMethodBeat.o(82805);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$1", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AbstractMultiContextJsEngine;", "create", "", "script", "", "createJSRuntime", "Lcom/tencent/mm/appbrand/v8/IJSRuntime;", "config", "Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;", "createMainContextEngine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "jsRuntime", "mainContextTag", "webview-sdk_release"})
  public static final class e
    extends com.tencent.mm.plugin.appbrand.jsruntime.a
  {
    public final com.tencent.mm.appbrand.v8.m a(IJSRuntime paramIJSRuntime, int paramInt)
    {
      AppMethodBeat.i(205591);
      d.g.b.k.h(paramIJSRuntime, "jsRuntime");
      paramIJSRuntime = paramIJSRuntime.ho(paramInt);
      AppMethodBeat.o(205591);
      return paramIJSRuntime;
    }
    
    public final int create(String paramString)
    {
      AppMethodBeat.i(205592);
      d.g.b.k.h(paramString, "script");
      com.tencent.mm.plugin.appbrand.jsruntime.g localg = bmy();
      localg.evaluateJavascript(paramString, null);
      d.g.b.k.g(localg, "context");
      int i = localg.bmw();
      AppMethodBeat.o(205592);
      return i;
    }
    
    public final IJSRuntime g(IJSRuntime.Config paramConfig)
    {
      AppMethodBeat.i(205590);
      paramConfig = (IJSRuntime)com.tencent.mm.appbrand.v8.f.c(paramConfig);
      AppMethodBeat.o(205590);
      return paramConfig;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<List<? extends Integer>>
  {
    public static final f CRn;
    
    static
    {
      AppMethodBeat.i(82809);
      CRn = new f();
      AppMethodBeat.o(82809);
    }
    
    f()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.ab.i>
  {
    public static final g CRp;
    
    static
    {
      AppMethodBeat.i(82811);
      CRp = new g();
      AppMethodBeat.o(82811);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<c.b.e>
  {
    public static final h CRq;
    
    static
    {
      AppMethodBeat.i(82816);
      CRq = new h();
      AppMethodBeat.o(82816);
    }
    
    h()
    {
      super();
    }
    
    /* Error */
    private static c.b.e fdi()
    {
      // Byte code:
      //   0: ldc 46
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 48	com/tencent/mm/plugin/appbrand/appcache/f
      //   8: dup
      //   9: invokestatic 54	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
      //   12: ldc 56
      //   14: invokespecial 59	com/tencent/mm/plugin/appbrand/appcache/f:<init>	(Landroid/content/Context;Ljava/lang/String;)V
      //   17: astore_2
      //   18: aload_2
      //   19: invokevirtual 63	com/tencent/mm/plugin/appbrand/appcache/f:aVW	()Z
      //   22: pop
      //   23: getstatic 67	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   26: astore_3
      //   27: aload_2
      //   28: checkcast 69	com/tencent/mm/plugin/appbrand/appcache/p
      //   31: invokestatic 75	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/plugin/appbrand/appcache/p;)I
      //   34: istore_1
      //   35: invokestatic 79	com/tencent/mm/plugin/webview/k/c:eHa	()Ljava/lang/String;
      //   38: checkcast 81	java/lang/CharSequence
      //   41: invokestatic 87	d/n/n:aD	(Ljava/lang/CharSequence;)Z
      //   44: ifne +119 -> 163
      //   47: iconst_1
      //   48: istore_0
      //   49: iload_0
      //   50: ifeq +118 -> 168
      //   53: invokestatic 79	com/tencent/mm/plugin/webview/k/c:eHa	()Ljava/lang/String;
      //   56: invokestatic 93	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
      //   59: ifeq +109 -> 168
      //   62: new 95	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   65: dup
      //   66: invokestatic 79	com/tencent/mm/plugin/webview/k/c:eHa	()Ljava/lang/String;
      //   69: invokespecial 98	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
      //   72: astore_3
      //   73: aload_3
      //   74: invokevirtual 99	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:aVW	()Z
      //   77: pop
      //   78: getstatic 67	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   81: astore 4
      //   83: aload_3
      //   84: checkcast 69	com/tencent/mm/plugin/appbrand/appcache/p
      //   87: invokestatic 75	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/plugin/appbrand/appcache/p;)I
      //   90: istore_0
      //   91: iload_0
      //   92: iload_1
      //   93: if_icmple +75 -> 168
      //   96: getstatic 67	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   99: astore 4
      //   101: invokestatic 102	com/tencent/mm/plugin/webview/k/c$b:eHe	()Ljava/lang/String;
      //   104: ldc 104
      //   106: iload_0
      //   107: invokestatic 110	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   110: invokevirtual 114	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   113: invokestatic 119	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   116: getstatic 67	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   119: astore 4
      //   121: invokestatic 123	com/tencent/mm/plugin/webview/k/c$b:eHi	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   124: getstatic 129	com/tencent/mm/plugin/webview/k/c$b$c:CRc	Lcom/tencent/mm/plugin/webview/k/c$b$c;
      //   127: invokevirtual 134	com/tencent/mm/plugin/webview/k/c$b$b:a	(Lcom/tencent/mm/plugin/webview/k/c$b$c;)V
      //   130: getstatic 67	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   133: astore 4
      //   135: invokestatic 123	com/tencent/mm/plugin/webview/k/c$b:eHi	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   138: iload_0
      //   139: putfield 138	com/tencent/mm/plugin/webview/k/c$b$b:CQZ	I
      //   142: aload_3
      //   143: astore_2
      //   144: new 140	com/tencent/mm/plugin/webview/k/c$b$e
      //   147: dup
      //   148: aload_2
      //   149: checkcast 69	com/tencent/mm/plugin/appbrand/appcache/p
      //   152: invokespecial 143	com/tencent/mm/plugin/webview/k/c$b$e:<init>	(Lcom/tencent/mm/plugin/appbrand/appcache/p;)V
      //   155: astore_2
      //   156: ldc 46
      //   158: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   161: aload_2
      //   162: areturn
      //   163: iconst_0
      //   164: istore_0
      //   165: goto -116 -> 49
      //   168: getstatic 67	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   171: astore_3
      //   172: invokestatic 102	com/tencent/mm/plugin/webview/k/c$b:eHe	()Ljava/lang/String;
      //   175: ldc 145
      //   177: iload_1
      //   178: invokestatic 110	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   181: invokevirtual 114	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   184: invokestatic 119	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   187: getstatic 67	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   190: astore_3
      //   191: invokestatic 123	com/tencent/mm/plugin/webview/k/c$b:eHi	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   194: getstatic 148	com/tencent/mm/plugin/webview/k/c$b$c:CRd	Lcom/tencent/mm/plugin/webview/k/c$b$c;
      //   197: invokevirtual 134	com/tencent/mm/plugin/webview/k/c$b$b:a	(Lcom/tencent/mm/plugin/webview/k/c$b$c;)V
      //   200: getstatic 67	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   203: astore_3
      //   204: invokestatic 123	com/tencent/mm/plugin/webview/k/c$b:eHi	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   207: iload_1
      //   208: putfield 138	com/tencent/mm/plugin/webview/k/c$b$b:CQZ	I
      //   211: goto -67 -> 144
      //   214: astore_3
      //   215: getstatic 67	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   218: astore 4
      //   220: invokestatic 102	com/tencent/mm/plugin/webview/k/c$b:eHe	()Ljava/lang/String;
      //   223: new 150	java/lang/StringBuilder
      //   226: dup
      //   227: ldc 152
      //   229: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   232: aload_3
      //   233: invokevirtual 156	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   236: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   239: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   242: invokestatic 166	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   245: new 168	com/tencent/mm/plugin/webview/k/j
      //   248: dup
      //   249: invokespecial 169	com/tencent/mm/plugin/webview/k/j:<init>	()V
      //   252: getstatic 175	com/tencent/mm/plugin/webview/k/b:Hah	Lcom/tencent/mm/plugin/webview/k/b;
      //   255: invokevirtual 178	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    public static final i CRr;
    
    static
    {
      AppMethodBeat.i(82818);
      CRr = new i();
      AppMethodBeat.o(82818);
    }
    
    i()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "retCode", "", "webComptName", "", "errMsg", "(ILjava/lang/String;Ljava/lang/String;)V", "toJsonString", "webview-sdk_release"})
  public static final class j
    extends Exception
  {
    final String CRs;
    final String errMsg;
    final int retCode;
    
    public j(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(82842);
      this.retCode = paramInt;
      this.CRs = paramString1;
      this.errMsg = paramString2;
      AppMethodBeat.o(82842);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "", "stepName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStepName", "()Ljava/lang/String;", "STEP_CREATE_JS_CXT", "STEP_EVAL_MAIN_FRAME", "STEP_GET_A8KEY", "STEP_FETCH_WORKER", "STEP_GET_APP_SCRIPT", "webview-sdk_release"})
  static enum k
  {
    final String lgk;
    
    static
    {
      AppMethodBeat.i(82843);
      k localk1 = new k("STEP_CREATE_JS_CXT", 0, "createJsContext");
      CRt = localk1;
      k localk2 = new k("STEP_EVAL_MAIN_FRAME", 1, "evalMainFrame");
      CRu = localk2;
      k localk3 = new k("STEP_GET_A8KEY", 2, "GetA8Key");
      CRv = localk3;
      k localk4 = new k("STEP_FETCH_WORKER", 3, "FetchWorker");
      CRw = localk4;
      k localk5 = new k("STEP_GET_APP_SCRIPT", 4, "GetAppScript");
      CRx = localk5;
      CRy = new k[] { localk1, localk2, localk3, localk4, localk5 };
      AppMethodBeat.o(82843);
    }
    
    private k(String paramString)
    {
      this.lgk = paramString;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "Lkotlin/collections/HashMap;", "()V", "id", "", "getId", "()I", "preloadDebugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "preloadId", "recycleWorkers", "fetch", "appId", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "preload", "", "recycle", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "WebComptWorker", "webview-sdk_release"})
  static final class l
    extends HashMap<String, a>
  {
    c.b.f CRA;
    final HashMap<String, a> CRB;
    int CRz;
    final int id;
    
    public l()
    {
      AppMethodBeat.i(82849);
      this.id = ((int)(System.currentTimeMillis() % 1000L));
      this.CRz = -1;
      this.CRA = new c.b.f(this.id, true, false, 4);
      this.CRB = new HashMap();
      AppMethodBeat.o(82849);
    }
    
    public final a a(String paramString, bmn parambmn, c paramc)
    {
      boolean bool = false;
      for (;;)
      {
        Object localObject;
        try
        {
          AppMethodBeat.i(205595);
          d.g.b.k.h(paramString, "appId");
          d.g.b.k.h(parambmn, "webComptInfo");
          d.g.b.k.h(paramc, "webCompt");
          String str = parambmn.name;
          if (this.CRB.containsKey(str))
          {
            localObject = (a)this.CRB.get(str);
            if ((localObject != null) && (d.g.b.k.g(((a)localObject).appId, paramString)))
            {
              this.CRB.remove(str);
              paramString = (Map)this;
              d.g.b.k.g(str, "webComptName");
              d.g.b.k.g(localObject, "it");
              paramString.put(str, localObject);
              paramString = c.CQN;
              c.b.eHi().CQW.add(new c.b.f(this.id, false, true, 2));
              AppMethodBeat.o(205595);
              paramString = (String)localObject;
              return paramString;
            }
          }
          if (this.CRz != -1) {
            bool = true;
          }
          if (bool == true)
          {
            paramString = c.CQN;
            ac.i(c.b.eHe(), "use preload workerManager#" + this.id);
            paramString = this.CRA;
            localObject = c.CQN;
            c.b.eHi().CQW.add(paramString);
            localObject = c.CQN;
            c.b.eHi().jSK = bool;
            if (bool == true)
            {
              i = this.CRz;
              paramString = new a(i, parambmn, paramc);
              this.CRz = -1;
              parambmn = (Map)this;
              d.g.b.k.g(str, "webComptName");
              parambmn.put(str, paramString);
              AppMethodBeat.o(205595);
            }
          }
          else
          {
            paramString = c.CQN;
            ac.i(c.b.eHe(), "create new workerManager#" + this.id);
            paramString = new c.b.f(this.id, false, false, 4);
            continue;
          }
          localObject = c.eGS();
        }
        finally {}
        c.b localb = c.CQN;
        int i = ((c.e)localObject).create(c.b.g("/wxwebcompt.js", paramString.CQX));
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "", "workerId", "", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;ILcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;)V", "a8KeyUrl", "", "getA8KeyUrl", "()Ljava/lang/String;", "setA8KeyUrl", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "appScriptMD5", "getAppScriptMD5", "setAppScriptMD5", "appScriptUrl", "getAppScriptUrl", "setAppScriptUrl", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "getEngine", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "isRecycled", "", "()Z", "setRecycled", "(Z)V", "jsapi", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "setJsapi", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;)V", "launched", "getLaunched", "setLaunched", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "setPerformanceHelper", "(Lcom/tencent/mm/pluginsdk/PerformanceHelper;)V", "refer", "getRefer", "setRefer", "used", "getUsed", "setUsed", "getWebComptInfo", "()Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getWorkerId", "()I", "recycle", "", "reuse", "webview-sdk_release"})
    public final class a
    {
      boolean CRC;
      String CRD;
      String CRE;
      String CRF;
      com.tencent.mm.pluginsdk.q CRG;
      i CRH;
      final int CRI;
      final bmn CRJ;
      boolean aGc;
      String appId;
      String nHD;
      boolean used;
      
      public a(bmn parambmn, c paramc)
      {
        AppMethodBeat.i(82848);
        this.CRI = parambmn;
        this.CRJ = paramc;
        this.appId = "";
        this.nHD = "";
        this.CRD = "";
        this.CRE = "";
        this.CRF = "";
        this$1 = this.CRJ.name;
        d.g.b.k.g(c.l.this, "webComptInfo.name");
        this.CRH = new i(localObject, c.l.this, localObject.Cjc);
        eHo().addJavascriptInterface(this.CRH, "__webcompt");
        AppMethodBeat.o(82848);
      }
      
      public final void aEk(String paramString)
      {
        AppMethodBeat.i(82846);
        d.g.b.k.h(paramString, "<set-?>");
        this.CRE = paramString;
        AppMethodBeat.o(82846);
      }
      
      public final com.tencent.mm.plugin.appbrand.jsruntime.g eHo()
      {
        AppMethodBeat.i(205594);
        com.tencent.mm.plugin.appbrand.jsruntime.g localg = c.eGS().tp(this.CRI);
        d.g.b.k.g(localg, "manager.getJsContext(workerId)");
        AppMethodBeat.o(205594);
        return localg;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"toJsonStringArray", "", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.b<List<? extends String>, String>
  {
    public static final m CRL;
    
    static
    {
      AppMethodBeat.i(82862);
      CRL = new m();
      AppMethodBeat.o(82862);
    }
    
    m()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"})
  public static final class n
    extends d.d.a
    implements CoroutineExceptionHandler
  {
    public n(f.c paramc, c paramc1, v.f paramf)
    {
      super();
    }
    
    public final void handleException(d.d.f paramf, Throwable paramThrowable)
    {
      AppMethodBeat.i(82863);
      this.CRM.CQA.a(b.CQb);
      if ((paramThrowable instanceof c.j))
      {
        ((d.g.a.b)this.CRN.KUQ).ay(paramThrowable);
        AppMethodBeat.o(82863);
        return;
      }
      AppMethodBeat.o(82863);
      throw paramThrowable;
    }
  }
  
  @d.d.b.a.e(c="com.tencent.mm.plugin.webview.webcompt.WebComponent$createJsContext$2", f="WebComponent.kt", l={237, 332, 337, 344}, m="invokeSuspend")
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class o
    extends d.d.b.a.i
    implements d.g.a.m<ag, d<? super y>, Object>
  {
    int label;
    Object nIC;
    Object nID;
    Object nIE;
    Object nIF;
    Object nIG;
    Object nIH;
    Object nII;
    Object nIJ;
    Object nIK;
    Object nIL;
    private ag nvs;
    Object nvt;
    
    o(c paramc, boolean paramBoolean, com.tencent.mm.pluginsdk.q paramq, String paramString1, bmn parambmn, String paramString2, String paramString3, v.f paramf, d paramd)
    {
      super();
    }
    
    public final d<y> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(82875);
      d.g.b.k.h(paramd, "completion");
      paramd = new o(this.CRM, this.CRO, this.CRP, this.kFm, this.CRQ, this.CRR, this.jqw, this.CRS, paramd);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(82875);
      return paramd;
    }
    
    public final Object cO(final Object paramObject)
    {
      AppMethodBeat.i(82874);
      d.d.a.a locala = d.d.a.a.KUd;
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
        paramObject = this.nvs;
        localObject1 = c.CQN;
        this.nvt = paramObject;
        this.label = 1;
        if (c.b.a(this) == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
        }
      case 1: 
        paramObject = (ag)this.nvt;
        if (this.CRO) {
          c.a(this.CRM, this.CRP);
        }
        localObject5 = new com.tencent.mm.ab.i();
        localObject1 = ((Iterable)n.a((CharSequence)n.nh(this.kFm, "#"), new String[] { "&" })).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = n.a((CharSequence)((Iterator)localObject1).next(), new String[] { "=" });
          if (((List)localObject2).size() == 2) {
            ((com.tencent.mm.ab.i)localObject5).i((String)((List)localObject2).get(0), URLDecoder.decode((String)((List)localObject2).get(1), "UTF-8"));
          }
        }
        localObject1 = g.CSt;
        if (g.a.getDebug())
        {
          localObject1 = g.CSt;
          localObject1 = h.bBL().getString("debugA8Key", "");
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          if (!n.aD((CharSequence)localObject1))
          {
            i = 1;
            if (i == 0) {
              break label651;
            }
            localObject1 = new o(localObject1, c.b.a.CQU);
            if (localObject1 == null) {
              break label687;
            }
            localObject2 = (String)((o)localObject1).first;
            localObject1 = (c.b.a)((o)localObject1).second;
            localObject3 = c.CQN;
            c.b.eHi().CQX.add(new c.b.d((String)localObject2, null, (c.b.a)localObject1, 2));
            localObject1 = localObject2;
            localObject2 = c.CQN;
            ac.d(c.b.eHe(), "createJsContext a8key:".concat(String.valueOf(localObject1)));
            c.b(this.CRP, c.k.CRt);
            localObject2 = c.CQN;
            ac.i(c.b.eHe(), "createJsContext init " + this.CRR);
            c.c(this.CRP, c.k.CRw);
            localObject2 = c.a(this.CRM).a(this.jqw, this.CRQ, this.CRM);
            c.b(this.CRP, c.k.CRw);
            localObject3 = this.kFm;
            d.g.b.k.h(localObject3, "<set-?>");
            ((c.l.a)localObject2).nHD = ((String)localObject3);
            ((c.l.a)localObject2).CRG = this.CRP;
            localObject3 = this.jqw;
            d.g.b.k.h(localObject3, "appId");
            if ((!((c.l.a)localObject2).aGc) || (!d.g.b.k.g(((c.l.a)localObject2).appId, localObject3))) {
              break label750;
            }
            ((c.l.a)localObject2).aGc = false;
            localObject4 = c.CQN;
            ac.i(c.b.eHe(), "WebComptWorker.reuse " + (String)localObject3 + '@' + ((c.l.a)localObject2).CRJ.name + ':' + ((c.l.a)localObject2).CRI);
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label755;
          }
          c.b(((c.l.a)localObject2).eHo(), this.CRQ, this.CRP.getStartTime());
          this.CRM.CQA.a(b.CQy);
          paramObject = y.KTp;
          AppMethodBeat.o(82874);
          return paramObject;
          i = 0;
          break;
          if (((com.tencent.mm.ab.i)localObject5).has("debugA8Key"))
          {
            localObject1 = new o(((com.tencent.mm.ab.i)localObject5).getString("debugA8Key"), c.b.a.CQR);
            break label311;
          }
          localObject1 = null;
          break label311;
          localObject1 = new StringBuilder();
          localObject2 = c.CQN;
          localObject1 = c.b.getScheme() + this.CRR + "?appId=" + this.jqw + "&src=" + a.htmlEncode(this.kFm);
          break label362;
        }
        localObject3 = this.jqw;
        d.g.b.k.h(localObject3, "<set-?>");
        ((c.l.a)localObject2).appId = ((String)localObject3);
        d.g.b.k.h(localObject1, "<set-?>");
        ((c.l.a)localObject2).CRD = ((String)localObject1);
        localObject3 = this.CRQ.md5;
        d.g.b.k.g(localObject3, "webCompt.md5");
        d.g.b.k.h(localObject3, "<set-?>");
        ((c.l.a)localObject2).CRF = ((String)localObject3);
        localObject3 = this.CRQ.url;
        d.g.b.k.g(localObject3, "webCompt.url");
        ((c.l.a)localObject2).aEk((String)localObject3);
        localObject4 = ((c.l.a)localObject2).eHo();
        ((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject4).setJsExceptionHandler((com.tencent.mm.plugin.appbrand.jsruntime.h)new a((c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ab.i)localObject5));
        this.CRS.KUQ = ((d.g.a.b)new b((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject4, (c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ab.i)localObject5));
        c.a((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject4, this.CRQ, this.CRP.getStartTime());
        localObject3 = kotlinx.coroutines.f.a(paramObject, paramObject.gde(), (d.g.a.m)new c(null, (c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ab.i)localObject5), 2);
        localObject6 = kotlinx.coroutines.f.a(paramObject, paramObject.gde(), (d.g.a.m)new d((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject4, null, (c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ab.i)localObject5), 2);
        this.nvt = paramObject;
        this.nIC = localObject5;
        this.nID = localObject1;
        this.nIE = localObject2;
        this.nIF = localObject4;
        this.nIG = localObject4;
        this.nIH = localObject3;
        this.nII = localObject6;
        this.label = 2;
        localObject8 = ((ap)localObject6).f(this);
        if (localObject8 == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
        }
        break;
      case 2: 
        localObject6 = (ap)this.nII;
        localObject3 = (ap)this.nIH;
        localObject7 = (com.tencent.mm.plugin.appbrand.jsruntime.g)this.nIG;
        localObject4 = (com.tencent.mm.plugin.appbrand.jsruntime.g)this.nIF;
        localObject2 = (c.l.a)this.nIE;
        localObject1 = (String)this.nID;
        localObject9 = (com.tencent.mm.ab.i)this.nIC;
        localObject8 = (ag)this.nvt;
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
        ((c.l.a)localObject2).aEk((String)localObject12);
        c.d((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject7, "(function(WeixinWebCompt){" + (String)localObject8 + "})(WeixinWebCompt);");
        this.nvt = paramObject;
        this.nIC = localObject5;
        this.nID = localObject1;
        this.nIE = localObject2;
        this.nIF = localObject4;
        this.nIG = localObject7;
        this.nIH = localObject3;
        this.nII = localObject6;
        this.nIJ = localObject12;
        this.nIK = localObject8;
        this.label = 3;
        Object localObject11 = ((ap)localObject3).f(this);
        Object localObject10;
        if (localObject11 == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
          localObject8 = (String)this.nIK;
          localObject5 = (String)this.nIJ;
          localObject10 = (ap)this.nII;
          localObject3 = (ap)this.nIH;
          localObject6 = (com.tencent.mm.plugin.appbrand.jsruntime.g)this.nIG;
          localObject4 = (com.tencent.mm.plugin.appbrand.jsruntime.g)this.nIF;
          localObject2 = (c.l.a)this.nIE;
          localObject1 = (String)this.nID;
          localObject7 = (com.tencent.mm.ab.i)this.nIC;
          localObject9 = (ag)this.nvt;
          localObject11 = paramObject;
        }
        for (;;)
        {
          paramObject = (c.a)localObject11;
          localObject11 = ((c.l.a)localObject2).CRH;
          localObject12 = paramObject.CQO.aCC(paramObject.nJQ);
          d.g.b.k.g(localObject12, "a8key.getJsPerm(fullUrl)");
          d.g.b.k.h(localObject12, "<set-?>");
          ((i)localObject11).Cjp = ((JsapiPermissionWrapper)localObject12);
          c.a(this.CRM, (com.tencent.mm.plugin.appbrand.jsruntime.g)localObject6, paramObject);
          ((c.l.a)localObject2).CRC = true;
          this.nvt = localObject9;
          this.nIC = localObject7;
          this.nID = localObject1;
          this.nIE = localObject2;
          this.nIF = localObject4;
          this.nIG = localObject6;
          this.nIH = localObject3;
          this.nII = localObject10;
          this.nIJ = localObject5;
          this.nIK = localObject8;
          this.nIL = paramObject;
          this.label = 4;
          if (as.b(1000L, this) == locala)
          {
            AppMethodBeat.o(82874);
            return locala;
          }
          paramObject = c.CQN;
          c.b.eHf();
          this.CRM.CQA.a(b.CQe);
          paramObject = c.CQN;
          ac.d(c.b.eHe(), "createJsContext init finish " + this.CRR);
          paramObject = c.CQN;
          if (c.b.eHi().jSK) {
            this.CRM.CQA.a(b.CQf);
          }
          paramObject = y.KTp;
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
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(82876);
      paramObject1 = ((o)a(paramObject1, (d)paramObject2)).cO(y.KTp);
      AppMethodBeat.o(82876);
      return paramObject1;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$1"})
    static final class a
      implements com.tencent.mm.plugin.appbrand.jsruntime.h
    {
      a(c.l.a parama, c.o paramo, ag paramag, String paramString, com.tencent.mm.ab.i parami) {}
      
      public final void u(String paramString1, String paramString2)
      {
        AppMethodBeat.i(205596);
        Object localObject = c.CQN;
        ac.e(c.b.eHe(), "engine " + jdField_this.CRR + " exception: " + paramString1 + " \nstackTrace:\n" + paramString2);
        localObject = jdField_this.CRM;
        String str = jdField_this.CRR;
        d.g.b.k.g(str, "name");
        d.g.b.k.g(paramString1, "message");
        c.a((c)localObject, str, paramString1, paramString2);
        jdField_this.CRM.CQA.a(b.CQm);
        AppMethodBeat.o(205596);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$2", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$2"})
    static final class b
      extends d.g.b.l
      implements d.g.a.b<c.j, y>
    {
      b(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, c.l.a parama, c.o paramo, ag paramag, String paramString, com.tencent.mm.ab.i parami)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$asyncA8Key$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$3"})
    static final class c
      extends d.d.b.a.i
      implements d.g.a.m<ag, d<? super c.a>, Object>
    {
      int label;
      private ag nvs;
      Object nvt;
      
      c(d paramd, c.l.a parama, c.o paramo, ag paramag, String paramString, com.tencent.mm.ab.i parami)
      {
        super();
      }
      
      public final d<y> a(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(82868);
        d.g.b.k.h(paramd, "completion");
        paramd = new c(paramd, this.CRT, jdField_this, paramObject, this.CRW, this.CRX);
        paramd.nvs = ((ag)paramObject);
        AppMethodBeat.o(82868);
        return paramd;
      }
      
      public final Object cO(Object paramObject)
      {
        AppMethodBeat.i(82867);
        d.d.a.a locala = d.d.a.a.KUd;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82867);
          throw paramObject;
        case 0: 
          paramObject = this.nvs;
          c.c(jdField_this.CRP, c.k.CRv);
          Object localObject = jdField_this.CRM;
          String str1 = this.CRW;
          String str2 = jdField_this.CRQ.name;
          d.g.b.k.g(str2, "webCompt.name");
          this.nvt = paramObject;
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
        c.b(jdField_this.CRP, c.k.CRv);
        AppMethodBeat.o(82867);
        return paramObject;
      }
      
      public final Object n(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82869);
        paramObject1 = ((c)a(paramObject1, (d)paramObject2)).cO(y.KTp);
        AppMethodBeat.o(82869);
        return paramObject1;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$asyncAppScript$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$4"})
    static final class d
      extends d.d.b.a.i
      implements d.g.a.m<ag, d<? super o<? extends String, ? extends String>>, Object>
    {
      int label;
      Object nIC;
      private ag nvs;
      Object nvt;
      
      d(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, d paramd, c.l.a parama, c.o paramo, ag paramag, String paramString, com.tencent.mm.ab.i parami)
      {
        super();
      }
      
      public final d<y> a(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(82872);
        d.g.b.k.h(paramd, "completion");
        paramd = new d(this.nJh, paramd, this.CRT, jdField_this, paramObject, this.CRW, this.CRX);
        paramd.nvs = ((ag)paramObject);
        AppMethodBeat.o(82872);
        return paramd;
      }
      
      public final Object cO(Object paramObject)
      {
        AppMethodBeat.i(82871);
        d.d.a.a locala = d.d.a.a.KUd;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82871);
          throw paramObject;
        case 0: 
          paramObject = this.nvs;
          c.c(jdField_this.CRP, c.k.CRx);
          this.nvt = paramObject;
          this.nIC = this;
          this.label = 1;
          paramObject = new d.d.h(d.d.a.b.d(this));
          Object localObject = (d)paramObject;
          c.b localb = c.CQN;
          com.tencent.mm.ac.c.b(c.b.eHe(), (d.g.a.a)new d.g.b.l((d)localObject) {});
          localObject = paramObject.fOg();
          if (localObject == d.d.a.a.KUd) {
            d.g.b.k.h(this, "frame");
          }
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(82871);
            return locala;
          }
          break;
        }
        c.b(jdField_this.CRP, c.k.CRx);
        AppMethodBeat.o(82871);
        return paramObject;
      }
      
      public final Object n(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82873);
        paramObject1 = ((d)a(paramObject1, (d)paramObject2)).cO(y.KTp);
        AppMethodBeat.o(82873);
        return paramObject1;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.b<c.j, y>
  {
    public static final p CRZ;
    
    static
    {
      AppMethodBeat.i(82878);
      CRZ = new p();
      AppMethodBeat.o(82878);
    }
    
    p()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    q(c paramc, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback", "com/tencent/mm/plugin/webview/webcompt/WebComponent$errReport$1$2$2", "com/tencent/mm/plugin/webview/webcompt/WebComponent$$special$$inlined$let$lambda$1"})
  static final class r
    implements IPCRunCgi.a
  {
    r(c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(82879);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        this.CRM.CQA.a(b.CQv);
      }
      AppMethodBeat.o(82879);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    public static final s CSh;
    
    static
    {
      AppMethodBeat.i(82881);
      CSh = new s();
      AppMethodBeat.o(82881);
    }
    
    s()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class t
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    t(c paramc, String paramString, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/webcompt/WebComponent$getA8Key$2$1$1", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "", "onUrlRedirect", "webview-sdk_release", "com/tencent/mm/plugin/webview/webcompt/WebComponent$$special$$inlined$apply$lambda$1"})
  public static final class u
    implements com.tencent.mm.plugin.webview.e.a<arn>
  {
    u(com.tencent.mm.plugin.webview.e.c paramc, d paramd, c paramc1, String paramString1, String paramString2) {}
    
    public final void A(int paramInt, String paramString1, String paramString2) {}
    
    public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(82885);
      d.g.b.k.h(paramString1, "reqUrl");
      d.g.b.k.h(paramString2, "errMsg");
      paramString1 = this.CSk;
      paramString2 = (Throwable)new c.j(20001, this.CSl, "getA8Key error:" + paramInt2 + ", " + paramInt3 + ", " + paramString2);
      p.a locala = d.p.KTg;
      paramString1.eK(d.p.eI(d.q.n(paramString2)));
      this.CRM.CQA.a(b.CQi);
      AppMethodBeat.o(82885);
    }
    
    public final void bj(int paramInt, String paramString)
    {
      AppMethodBeat.i(205600);
      d.g.b.k.h(paramString, "reqUrl");
      AppMethodBeat.o(205600);
    }
    
    public final void bk(int paramInt, String paramString)
    {
      AppMethodBeat.i(205599);
      d.g.b.k.h(paramString, "reqUrl");
      AppMethodBeat.o(205599);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"readText", "Lkotlin/Pair;", "", "T", "type", "errCode", "", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "debugType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "invoke", "(Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;)Lkotlin/Pair;"})
  static final class v
    extends d.g.b.l
    implements s<T, String, Integer, c.b.c, c.b.a, o<? extends String, ? extends String>>
  {
    v(c paramc, bmn parambmn)
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
      //   8: invokestatic 80	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: aload 4
      //   13: ldc 81
      //   15: invokestatic 80	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   18: aload 5
      //   20: ldc 82
      //   22: invokestatic 80	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   25: getstatic 86	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   28: astore 6
      //   30: invokestatic 92	com/tencent/mm/plugin/webview/k/c$b:eHe	()Ljava/lang/String;
      //   33: new 94	java/lang/StringBuilder
      //   36: dup
      //   37: ldc 96
      //   39: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   42: aload_2
      //   43: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   46: ldc 105
      //   48: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   51: aload_1
      //   52: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   55: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   58: invokestatic 117	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   61: aload_1
      //   62: instanceof 119
      //   65: ifeq +104 -> 169
      //   68: new 121	d/o
      //   71: dup
      //   72: aload_1
      //   73: checkcast 119	com/tencent/mm/vfs/e
      //   76: invokevirtual 124	com/tencent/mm/vfs/e:getAbsolutePath	()Ljava/lang/String;
      //   79: aload_1
      //   80: checkcast 119	com/tencent/mm/vfs/e
      //   83: invokestatic 130	com/tencent/mm/vfs/f:af	(Lcom/tencent/mm/vfs/e;)Ljava/lang/String;
      //   86: invokespecial 133	d/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   89: astore 6
      //   91: aload_0
      //   92: getfield 39	com/tencent/mm/plugin/webview/k/c$v:CRM	Lcom/tencent/mm/plugin/webview/k/c;
      //   95: getfield 137	com/tencent/mm/plugin/webview/k/c:CQA	Lcom/tencent/mm/plugin/webview/k/j;
      //   98: getstatic 143	com/tencent/mm/plugin/webview/k/b:CQk	Lcom/tencent/mm/plugin/webview/k/b;
      //   101: invokevirtual 148	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   104: getstatic 86	com/tencent/mm/plugin/webview/k/c:CQN	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   107: astore 7
      //   109: invokestatic 152	com/tencent/mm/plugin/webview/k/c$b:eHi	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   112: getfield 158	com/tencent/mm/plugin/webview/k/c$b$b:CQX	Ljava/util/LinkedList;
      //   115: astore 7
      //   117: aload 6
      //   119: getfield 162	d/o:first	Ljava/lang/Object;
      //   122: astore 8
      //   124: aload 8
      //   126: ldc 164
      //   128: invokestatic 167	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   131: aload 7
      //   133: new 169	com/tencent/mm/plugin/webview/k/c$b$d
      //   136: dup
      //   137: aload 8
      //   139: checkcast 171	java/lang/String
      //   142: invokestatic 174	com/tencent/mm/plugin/webview/k/c:eGT	()Ljava/lang/String;
      //   145: ldc 175
      //   147: invokestatic 181	d/n/n:bg	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
      //   193: new 121	d/o
      //   196: dup
      //   197: aload 6
      //   199: new 171	java/lang/String
      //   202: dup
      //   203: aload 7
      //   205: invokestatic 207	d/f/c:e	(Ljava/net/URL;)[B
      //   208: aload 8
      //   210: invokespecial 210	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   213: invokespecial 133	d/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   216: astore 6
      //   218: aload_0
      //   219: getfield 39	com/tencent/mm/plugin/webview/k/c$v:CRM	Lcom/tencent/mm/plugin/webview/k/c;
      //   222: getfield 137	com/tencent/mm/plugin/webview/k/c:CQA	Lcom/tencent/mm/plugin/webview/k/j;
      //   225: getstatic 213	com/tencent/mm/plugin/webview/k/b:CPM	Lcom/tencent/mm/plugin/webview/k/b;
      //   228: invokevirtual 148	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   231: goto -140 -> 91
      //   234: new 121	d/o
      //   237: dup
      //   238: ldc 175
      //   240: ldc 175
      //   242: invokespecial 133	d/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   245: astore 6
      //   247: goto -156 -> 91
      //   250: astore 4
      //   252: aload_1
      //   253: instanceof 192
      //   256: ifeq +16 -> 272
      //   259: aload_0
      //   260: getfield 39	com/tencent/mm/plugin/webview/k/c$v:CRM	Lcom/tencent/mm/plugin/webview/k/c;
      //   263: getfield 137	com/tencent/mm/plugin/webview/k/c:CQA	Lcom/tencent/mm/plugin/webview/k/j;
      //   266: getstatic 216	com/tencent/mm/plugin/webview/k/b:CPN	Lcom/tencent/mm/plugin/webview/k/b;
      //   269: invokevirtual 148	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   272: aload_0
      //   273: getfield 39	com/tencent/mm/plugin/webview/k/c$v:CRM	Lcom/tencent/mm/plugin/webview/k/c;
      //   276: getfield 137	com/tencent/mm/plugin/webview/k/c:CQA	Lcom/tencent/mm/plugin/webview/k/j;
      //   279: getstatic 219	com/tencent/mm/plugin/webview/k/b:CQl	Lcom/tencent/mm/plugin/webview/k/b;
      //   282: invokevirtual 148	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   285: aload_0
      //   286: getfield 39	com/tencent/mm/plugin/webview/k/c$v:CRM	Lcom/tencent/mm/plugin/webview/k/c;
      //   289: getfield 137	com/tencent/mm/plugin/webview/k/c:CQA	Lcom/tencent/mm/plugin/webview/k/j;
      //   292: getstatic 222	com/tencent/mm/plugin/webview/k/b:CPP	Lcom/tencent/mm/plugin/webview/k/b;
      //   295: invokevirtual 148	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   298: aload_0
      //   299: getfield 41	com/tencent/mm/plugin/webview/k/c$v:CRQ	Lcom/tencent/mm/protocal/protobuf/bmn;
      //   302: getfield 228	com/tencent/mm/protocal/protobuf/bmn:name	Ljava/lang/String;
      //   305: astore 5
      //   307: aload 5
      //   309: ldc 230
      //   311: invokestatic 167	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   314: new 232	com/tencent/mm/plugin/webview/k/c$j
      //   317: dup
      //   318: iload_3
      //   319: aload 5
      //   321: new 94	java/lang/StringBuilder
      //   324: dup
      //   325: ldc 234
      //   327: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   330: aload_2
      //   331: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   334: ldc 236
      //   336: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   339: aload_1
      //   340: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   343: ldc 105
      //   345: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   348: aload 4
      //   350: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   353: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"buildMatrix", "", "", "matrix", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.b<List<? extends Integer>, List<? extends String>>
  {
    public static final w CSm;
    
    static
    {
      AppMethodBeat.i(82892);
      CSm = new w();
      AppMethodBeat.o(82892);
    }
    
    w()
    {
      super();
    }
    
    public static List<String> gL(List<Integer> paramList)
    {
      AppMethodBeat.i(82891);
      d.g.b.k.h(paramList, "matrix");
      SecureRandom localSecureRandom = new SecureRandom();
      Object localObject = (Iterable)paramList;
      paramList = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        byte[] arrayOfByte = new byte[((Number)((Iterator)localObject).next()).intValue()];
        localSecureRandom.nextBytes(arrayOfByte);
        paramList.add(d.a.e.a(arrayOfByte, (CharSequence)"", (d.g.a.b)a.CSn));
      }
      paramList = (List)paramList;
      AppMethodBeat.o(82891);
      return paramList;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<Byte, String>
    {
      public static final a CSn;
      
      static
      {
        AppMethodBeat.i(82889);
        CSn = new a();
        AppMethodBeat.o(82889);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    x(c paramc, com.tencent.mm.pluginsdk.q paramq)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$refreshA8Key$2$1"})
  static final class y
    extends d.d.b.a.i
    implements d.g.a.m<ag, d<? super y>, Object>
  {
    int label;
    private ag nvs;
    Object nvt;
    
    y(c.l.a parama, d paramd, c paramc, d.g.a.b paramb1, d.g.a.b paramb2)
    {
      super();
    }
    
    public final d<y> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(82895);
      d.g.b.k.h(paramd, "completion");
      paramd = new y(this.CSo, paramd, this.CRM, this.CSp, this.CSq);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(82895);
      return paramd;
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(82894);
      d.d.a.a locala = d.d.a.a.KUd;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(82894);
        throw paramObject;
      case 0: 
        paramObject = this.nvs;
      }
      try
      {
        c localc = this.CRM;
        String str = this.CSo.CRD;
        this.nvt = paramObject;
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
          this.CSq.ay(paramObject);
        }
      }
      paramObject = (c.a)paramObject;
      this.CSp.ay(c.a(this.CRM, paramObject));
      paramObject = y.KTp;
      AppMethodBeat.o(82894);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(82896);
      paramObject1 = ((y)a(paramObject1, (d)paramObject2)).cO(y.KTp);
      AppMethodBeat.o(82896);
      return paramObject1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "invoke"})
  static final class z
    extends d.g.b.l
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