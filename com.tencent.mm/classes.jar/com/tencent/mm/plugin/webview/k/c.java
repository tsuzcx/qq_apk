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
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.protocal.protobuf.dso;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.d.f.c;
import d.g.a.s;
import d.g.b.u;
import d.g.b.v.e;
import d.g.b.w;
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
import kotlinx.coroutines.al;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.at;
import kotlinx.coroutines.bc;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "inited", "", "getJsapi", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "getReporter", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "workerManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "getWorkerManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "workerManager$delegate", "Lkotlin/Lazy;", "appendTags", "", "webCompt", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "cleanMainFrame", "clear", "createJsContext", "appId", "", "url", "launchMainFrame", "dispatchEvent", "event", "message", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluateMainFrame", "script", "callback", "Lkotlin/Function1;", "getA8Key", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "a8KeyUrl", "webComptName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppScript", "Lkotlin/Pair;", "paramsObject", "Lcom/tencent/mm/json/JSONObject;", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "performance", "frontEndPerformance", "postToBack", "postToFront", "refreshA8Key", "onerror", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "onsuccess", "config", "webComptInfo", "configTimeStamps", "", "resume", "end", "step", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "evaluate", "launch", "a8key", "records", "steps", "", "start", "toJson", "A8KeyResp", "Companion", "CreateJSContextException", "PerformanceSteps", "WebComptWorkerManager", "webview-sdk_release"})
public final class c
{
  private static String ByA;
  private static final LinkedList<l> ByB;
  private static final d.f ByC;
  private static final String ByD;
  private static final d.f ByE;
  public static final b ByF;
  private static final String Byu = "webcompt://";
  private static final d.f Byv;
  private static final d.f Byw;
  private static final d.f Byx;
  private static final d.f Byy;
  private static final e Byz;
  static final String TAG = "MicroMsg.WebComponent";
  final com.tencent.mm.plugin.webview.c.f AQP;
  final j Bys;
  private final d.f Byt;
  private boolean fFP;
  
  static
  {
    AppMethodBeat.i(82898);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(c.class), "workerManager", "getWorkerManager()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;")) };
    ByF = new b((byte)0);
    Byu = "webcompt://";
    TAG = "MicroMsg.WebComponent";
    Byv = d.g.E((d.g.a.a)g.Bzh);
    Byw = d.g.E((d.g.a.a)d.Bze);
    Byx = d.g.E((d.g.a.a)f.Bzf);
    Byy = d.g.E((d.g.a.a)i.Bzj);
    Byz = new e();
    ByA = "";
    ByB = new LinkedList();
    ByC = d.g.E((d.g.a.a)h.Bzi);
    ByD = com.tencent.mm.loader.j.b.aih() + "webcompt_debug/";
    ByE = d.g.E((d.g.a.a)c.Bzc);
    AppMethodBeat.o(82898);
  }
  
  public c(com.tencent.mm.plugin.webview.c.f paramf)
  {
    AppMethodBeat.i(189477);
    this.AQP = paramf;
    this.Bys = new j();
    b.erO().clear();
    this.Byt = d.g.E((d.g.a.a)new z(this));
    AppMethodBeat.o(189477);
  }
  
  /* Error */
  private final o<String, String> a(com.tencent.mm.ac.i parami, final biv parambiv)
  {
    // Byte code:
    //   0: ldc_w 390
    //   3: invokestatic 239	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 367	com/tencent/mm/plugin/webview/k/c:Bys	Lcom/tencent/mm/plugin/webview/k/j;
    //   10: getstatic 396	com/tencent/mm/plugin/webview/k/b:Byb	Lcom/tencent/mm/plugin/webview/k/b;
    //   13: invokevirtual 399	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
    //   16: new 97	com/tencent/mm/plugin/webview/k/c$v
    //   19: dup
    //   20: aload_0
    //   21: aload_2
    //   22: invokespecial 402	com/tencent/mm/plugin/webview/k/c$v:<init>	(Lcom/tencent/mm/plugin/webview/k/c;Lcom/tencent/mm/protocal/protobuf/biv;)V
    //   25: astore 4
    //   27: getstatic 270	com/tencent/mm/plugin/webview/k/c:TAG	Ljava/lang/String;
    //   30: new 322	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 404
    //   37: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: getfield 412	com/tencent/mm/protocal/protobuf/biv:name	Ljava/lang/String;
    //   44: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 417	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: getstatic 423	com/tencent/mm/plugin/webview/k/g:BAm	Lcom/tencent/mm/plugin/webview/k/g$a;
    //   56: astore 5
    //   58: invokestatic 429	com/tencent/mm/plugin/webview/k/g$a:getDebug	()Z
    //   61: ifeq +77 -> 138
    //   64: getstatic 423	com/tencent/mm/plugin/webview/k/g:BAm	Lcom/tencent/mm/plugin/webview/k/g$a;
    //   67: astore 5
    //   69: invokestatic 435	com/tencent/mm/plugin/webview/k/h:buO	()Lcom/tencent/mm/sdk/platformtools/ax;
    //   72: ldc_w 437
    //   75: ldc_w 307
    //   78: invokevirtual 443	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 5
    //   83: aload 5
    //   85: ifnonnull +6 -> 91
    //   88: invokestatic 446	d/g/b/k:fvU	()V
    //   91: aload 5
    //   93: checkcast 448	java/lang/CharSequence
    //   96: invokestatic 454	d/n/n:aC	(Ljava/lang/CharSequence;)Z
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
    //   126: getstatic 464	com/tencent/mm/plugin/webview/k/c$b$a:ByM	Lcom/tencent/mm/plugin/webview/k/c$b$a;
    //   129: iconst_4
    //   130: invokestatic 467	com/tencent/mm/plugin/webview/k/c$v:a	(Lcom/tencent/mm/plugin/webview/k/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)Ld/o;
    //   133: astore_1
    //   134: aload_1
    //   135: ifnonnull +967 -> 1102
    //   138: aload_2
    //   139: getfield 469	com/tencent/mm/protocal/protobuf/biv:url	Ljava/lang/String;
    //   142: checkcast 448	java/lang/CharSequence
    //   145: astore_1
    //   146: aload_1
    //   147: ifnull +10 -> 157
    //   150: aload_1
    //   151: invokestatic 454	d/n/n:aC	(Ljava/lang/CharSequence;)Z
    //   154: ifeq +313 -> 467
    //   157: iconst_1
    //   158: istore_3
    //   159: iload_3
    //   160: ifne +28 -> 188
    //   163: aload_2
    //   164: getfield 472	com/tencent/mm/protocal/protobuf/biv:md5	Ljava/lang/String;
    //   167: checkcast 448	java/lang/CharSequence
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +10 -> 182
    //   175: aload_1
    //   176: invokestatic 454	d/n/n:aC	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +293 -> 472
    //   182: iconst_1
    //   183: istore_3
    //   184: iload_3
    //   185: ifeq +292 -> 477
    //   188: aload_2
    //   189: getfield 412	com/tencent/mm/protocal/protobuf/biv:name	Ljava/lang/String;
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
    //   243: getfield 412	com/tencent/mm/protocal/protobuf/biv:name	Ljava/lang/String;
    //   246: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokevirtual 490	com/tencent/mm/ac/i:has	(Ljava/lang/String;)Z
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
    //   276: getfield 412	com/tencent/mm/protocal/protobuf/biv:name	Ljava/lang/String;
    //   279: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokevirtual 493	com/tencent/mm/ac/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokespecial 457	java/net/URL:<init>	(Ljava/lang/String;)V
    //   291: new 322	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 495
    //   298: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: aload_2
    //   302: getfield 412	com/tencent/mm/protocal/protobuf/biv:name	Ljava/lang/String;
    //   305: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: ldc_w 496
    //   314: aconst_null
    //   315: getstatic 499	com/tencent/mm/plugin/webview/k/c$b$a:ByJ	Lcom/tencent/mm/plugin/webview/k/c$b$a;
    //   318: iconst_4
    //   319: invokestatic 467	com/tencent/mm/plugin/webview/k/c$v:a	(Lcom/tencent/mm/plugin/webview/k/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)Ld/o;
    //   322: astore_1
    //   323: goto -189 -> 134
    //   326: aload_1
    //   327: ldc_w 437
    //   330: invokevirtual 490	com/tencent/mm/ac/i:has	(Ljava/lang/String;)Z
    //   333: ifeq +37 -> 370
    //   336: aload 4
    //   338: new 456	java/net/URL
    //   341: dup
    //   342: aload_1
    //   343: ldc_w 437
    //   346: invokevirtual 493	com/tencent/mm/ac/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   349: invokespecial 457	java/net/URL:<init>	(Ljava/lang/String;)V
    //   352: ldc_w 501
    //   355: ldc_w 502
    //   358: aconst_null
    //   359: getstatic 499	com/tencent/mm/plugin/webview/k/c$b$a:ByJ	Lcom/tencent/mm/plugin/webview/k/c$b$a;
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
    //   382: getfield 412	com/tencent/mm/protocal/protobuf/biv:name	Ljava/lang/String;
    //   385: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: ldc_w 506
    //   391: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 509	com/tencent/mm/plugin/webview/k/c$b:ayS	(Ljava/lang/String;)Ljava/lang/String;
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
    //   423: getfield 412	com/tencent/mm/protocal/protobuf/biv:name	Ljava/lang/String;
    //   426: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc_w 506
    //   432: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 509	com/tencent/mm/plugin/webview/k/c$b:ayS	(Ljava/lang/String;)Ljava/lang/String;
    //   441: invokespecial 510	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   444: ldc_w 515
    //   447: ldc_w 516
    //   450: aconst_null
    //   451: getstatic 519	com/tencent/mm/plugin/webview/k/c$b$a:ByK	Lcom/tencent/mm/plugin/webview/k/c$b$a;
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
    //   489: invokestatic 522	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/protocal/protobuf/biv;)Ljava/lang/String;
    //   492: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: ldc_w 506
    //   498: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokespecial 510	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   507: invokevirtual 513	com/tencent/mm/vfs/e:exists	()Z
    //   510: ifeq +166 -> 676
    //   513: aload 4
    //   515: new 504	com/tencent/mm/vfs/e
    //   518: dup
    //   519: new 322	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   526: aload_2
    //   527: invokestatic 522	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/protocal/protobuf/biv;)Ljava/lang/String;
    //   530: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc_w 506
    //   536: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokespecial 510	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   545: ldc_w 524
    //   548: sipush 21004
    //   551: getstatic 528	com/tencent/mm/plugin/webview/k/c$b$c:ByT	Lcom/tencent/mm/plugin/webview/k/c$b$c;
    //   554: aconst_null
    //   555: bipush 8
    //   557: invokestatic 467	com/tencent/mm/plugin/webview/k/c$v:a	(Lcom/tencent/mm/plugin/webview/k/c$v;Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)Ld/o;
    //   560: astore_1
    //   561: aload_0
    //   562: getfield 367	com/tencent/mm/plugin/webview/k/c:Bys	Lcom/tencent/mm/plugin/webview/k/j;
    //   565: getstatic 531	com/tencent/mm/plugin/webview/k/b:BxA	Lcom/tencent/mm/plugin/webview/k/b;
    //   568: invokevirtual 399	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
    //   571: getstatic 270	com/tencent/mm/plugin/webview/k/c:TAG	Ljava/lang/String;
    //   574: new 322	java/lang/StringBuilder
    //   577: dup
    //   578: ldc_w 533
    //   581: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   584: aload_2
    //   585: getfield 412	com/tencent/mm/protocal/protobuf/biv:name	Ljava/lang/String;
    //   588: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 417	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: getstatic 270	com/tencent/mm/plugin/webview/k/c:TAG	Ljava/lang/String;
    //   600: astore 4
    //   602: new 322	java/lang/StringBuilder
    //   605: dup
    //   606: ldc_w 535
    //   609: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   612: aload_2
    //   613: getfield 412	com/tencent/mm/protocal/protobuf/biv:name	Ljava/lang/String;
    //   616: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: bipush 10
    //   621: invokevirtual 538	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   624: astore_2
    //   625: aload_1
    //   626: getfield 544	d/o:second	Ljava/lang/Object;
    //   629: checkcast 546	java/lang/String
    //   632: astore 5
    //   634: bipush 100
    //   636: aload_1
    //   637: getfield 544	d/o:second	Ljava/lang/Object;
    //   640: checkcast 546	java/lang/String
    //   643: invokevirtual 550	java/lang/String:length	()I
    //   646: iconst_1
    //   647: isub
    //   648: invokestatic 556	java/lang/Math:min	(II)I
    //   651: istore_3
    //   652: aload 5
    //   654: ifnonnull +405 -> 1059
    //   657: new 558	d/v
    //   660: dup
    //   661: ldc_w 560
    //   664: invokespecial 561	d/v:<init>	(Ljava/lang/String;)V
    //   667: astore_1
    //   668: ldc_w 390
    //   671: invokestatic 349	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   674: aload_1
    //   675: athrow
    //   676: new 456	java/net/URL
    //   679: dup
    //   680: aload_2
    //   681: getfield 469	com/tencent/mm/protocal/protobuf/biv:url	Ljava/lang/String;
    //   684: invokespecial 457	java/net/URL:<init>	(Ljava/lang/String;)V
    //   687: astore 5
    //   689: getstatic 270	com/tencent/mm/plugin/webview/k/c:TAG	Ljava/lang/String;
    //   692: ldc_w 563
    //   695: aload 5
    //   697: invokestatic 567	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   700: invokevirtual 570	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   703: invokestatic 572	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   706: aload 5
    //   708: invokevirtual 576	java/net/URL:openStream	()Ljava/io/InputStream;
    //   711: checkcast 578	java/io/Closeable
    //   714: astore 6
    //   716: aconst_null
    //   717: astore 4
    //   719: aload 6
    //   721: checkcast 580	java/io/InputStream
    //   724: astore_1
    //   725: aload_1
    //   726: ldc_w 582
    //   729: invokestatic 477	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   732: aload_1
    //   733: invokestatic 588	d/f/a:V	(Ljava/io/InputStream;)[B
    //   736: astore_1
    //   737: aload_2
    //   738: getfield 472	com/tencent/mm/protocal/protobuf/biv:md5	Ljava/lang/String;
    //   741: new 590	java/io/ByteArrayInputStream
    //   744: dup
    //   745: aload_1
    //   746: invokespecial 593	java/io/ByteArrayInputStream:<init>	([B)V
    //   749: checkcast 580	java/io/InputStream
    //   752: aload_1
    //   753: arraylength
    //   754: invokestatic 598	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   757: invokestatic 601	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   760: ifeq +149 -> 909
    //   763: new 504	com/tencent/mm/vfs/e
    //   766: dup
    //   767: new 322	java/lang/StringBuilder
    //   770: dup
    //   771: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   774: aload_2
    //   775: invokestatic 522	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/protocal/protobuf/biv;)Ljava/lang/String;
    //   778: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: ldc_w 506
    //   784: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokespecial 510	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   793: astore 7
    //   795: new 504	com/tencent/mm/vfs/e
    //   798: dup
    //   799: aload 7
    //   801: invokevirtual 604	com/tencent/mm/vfs/e:getParent	()Ljava/lang/String;
    //   804: invokespecial 510	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   807: invokevirtual 607	com/tencent/mm/vfs/e:mkdirs	()Z
    //   810: pop
    //   811: aload 7
    //   813: invokevirtual 610	com/tencent/mm/vfs/e:createNewFile	()Z
    //   816: pop
    //   817: aload 7
    //   819: aload_1
    //   820: invokestatic 615	com/tencent/mm/vfs/f:b	(Lcom/tencent/mm/vfs/e;[B)V
    //   823: invokestatic 371	com/tencent/mm/plugin/webview/k/c$b:erO	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
    //   826: getfield 618	com/tencent/mm/plugin/webview/k/c$b$b:ByP	Ljava/util/LinkedList;
    //   829: astore 7
    //   831: aload 5
    //   833: invokevirtual 619	java/net/URL:toString	()Ljava/lang/String;
    //   836: astore 8
    //   838: aload 8
    //   840: ldc_w 621
    //   843: invokestatic 477	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   846: aload 7
    //   848: new 19	com/tencent/mm/plugin/webview/k/c$b$d
    //   851: dup
    //   852: aload 8
    //   854: getstatic 624	com/tencent/mm/plugin/webview/k/c$b$c:ByU	Lcom/tencent/mm/plugin/webview/k/c$b$c;
    //   857: aconst_null
    //   858: iconst_4
    //   859: invokespecial 627	com/tencent/mm/plugin/webview/k/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)V
    //   862: invokevirtual 631	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   865: pop
    //   866: new 540	d/o
    //   869: dup
    //   870: aload 5
    //   872: invokevirtual 619	java/net/URL:toString	()Ljava/lang/String;
    //   875: new 546	java/lang/String
    //   878: dup
    //   879: aload_1
    //   880: getstatic 637	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   883: invokespecial 640	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   886: invokespecial 643	d/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   889: astore_1
    //   890: aload_0
    //   891: getfield 367	com/tencent/mm/plugin/webview/k/c:Bys	Lcom/tencent/mm/plugin/webview/k/j;
    //   894: getstatic 646	com/tencent/mm/plugin/webview/k/b:BxB	Lcom/tencent/mm/plugin/webview/k/b;
    //   897: invokevirtual 399	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
    //   900: aload 6
    //   902: aconst_null
    //   903: invokestatic 651	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   906: goto -335 -> 571
    //   909: aload_0
    //   910: getfield 367	com/tencent/mm/plugin/webview/k/c:Bys	Lcom/tencent/mm/plugin/webview/k/j;
    //   913: getstatic 654	com/tencent/mm/plugin/webview/k/b:BxG	Lcom/tencent/mm/plugin/webview/k/b;
    //   916: invokevirtual 399	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
    //   919: aload_2
    //   920: getfield 412	com/tencent/mm/protocal/protobuf/biv:name	Ljava/lang/String;
    //   923: astore_1
    //   924: aload_1
    //   925: ldc_w 474
    //   928: invokestatic 477	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   931: new 56	com/tencent/mm/plugin/webview/k/c$j
    //   934: dup
    //   935: sipush 21003
    //   938: aload_1
    //   939: ldc_w 656
    //   942: aload 5
    //   944: invokestatic 567	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   947: invokevirtual 570	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   950: invokespecial 482	com/tencent/mm/plugin/webview/k/c$j:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   953: checkcast 389	java/lang/Throwable
    //   956: astore_1
    //   957: ldc_w 390
    //   960: invokestatic 349	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   963: aload_1
    //   964: athrow
    //   965: astore 4
    //   967: ldc_w 390
    //   970: invokestatic 349	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   973: aload 4
    //   975: athrow
    //   976: astore_1
    //   977: aload 6
    //   979: aload 4
    //   981: invokestatic 651	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   984: ldc_w 390
    //   987: invokestatic 349	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   990: aload_1
    //   991: athrow
    //   992: astore_1
    //   993: aload_2
    //   994: getfield 412	com/tencent/mm/protocal/protobuf/biv:name	Ljava/lang/String;
    //   997: astore_2
    //   998: aload_2
    //   999: ldc_w 474
    //   1002: invokestatic 477	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1005: new 56	com/tencent/mm/plugin/webview/k/c$j
    //   1008: dup
    //   1009: sipush 21002
    //   1012: aload_2
    //   1013: new 322	java/lang/StringBuilder
    //   1016: dup
    //   1017: ldc_w 658
    //   1020: invokespecial 407	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1023: aload_1
    //   1024: invokevirtual 661	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1027: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: ldc_w 663
    //   1033: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: aload 5
    //   1038: invokevirtual 666	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1041: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1044: invokespecial 482	com/tencent/mm/plugin/webview/k/c$j:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   1047: checkcast 389	java/lang/Throwable
    //   1050: astore_1
    //   1051: ldc_w 390
    //   1054: invokestatic 349	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1057: aload_1
    //   1058: athrow
    //   1059: aload 5
    //   1061: iconst_0
    //   1062: iload_3
    //   1063: invokevirtual 670	java/lang/String:substring	(II)Ljava/lang/String;
    //   1066: astore 5
    //   1068: aload 5
    //   1070: ldc_w 672
    //   1073: invokestatic 477	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1076: aload 4
    //   1078: aload_2
    //   1079: aload 5
    //   1081: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: invokevirtual 338	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1087: invokestatic 572	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1090: ldc_w 390
    //   1093: invokestatic 349	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1096: aload_1
    //   1097: areturn
    //   1098: astore_1
    //   1099: goto -122 -> 977
    //   1102: goto -531 -> 571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1105	0	this	c
    //   0	1105	1	parami	com.tencent.mm.ac.i
    //   0	1105	2	parambiv	biv
    //   103	960	3	i	int
    //   25	693	4	localObject1	Object
    //   965	112	4	localThrowable	Throwable
    //   56	1024	5	localObject2	Object
    //   714	264	6	localCloseable	java.io.Closeable
    //   793	54	7	localObject3	Object
    //   836	17	8	str	String
    // Exception table:
    //   from	to	target	type
    //   719	900	965	java/lang/Throwable
    //   909	965	965	java/lang/Throwable
    //   967	976	976	finally
    //   706	716	992	java/lang/Exception
    //   900	906	992	java/lang/Exception
    //   977	992	992	java/lang/Exception
    //   719	900	1098	finally
    //   909	965	1098	finally
  }
  
  private final String a(a parama)
  {
    AppMethodBeat.i(82905);
    Object localObject1 = parama.ByH;
    Object localObject2 = this.AQP.getSettings();
    d.g.b.k.g(localObject2, "jsapi.settings");
    localObject2 = ((com.tencent.xweb.y)localObject2).getUserAgentString();
    d.g.b.k.g(localObject2, "jsapi.settings.userAgentString");
    ((Map)localObject1).put("User-agent", localObject2);
    localObject1 = new com.tencent.mm.ac.i((Map)localObject1).toString();
    d.g.b.k.g(localObject1, "JSONObject(httpHeaders.a…ing\n        }).toString()");
    localObject2 = new StringBuilder("{clientVersion:");
    String str = com.tencent.mm.sdk.platformtools.h.glW;
    d.g.b.k.g(str, "BuildInfo.CLIENT_VERSION");
    parama = a.ayN(str) + ",headers:" + (String)localObject1 + ",fullUrl:" + a.ayN(parama.nha) + '}';
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
      localLinkedList.add(String.valueOf(paramq.bH(localk.kER + "_START", paramq.getStartTime()) - paramq.getStartTime()));
      localLinkedList.add(String.valueOf(paramq.bH(localk.kER + "_END", paramq.getStartTime()) - paramq.getStartTime()));
    }
    paramq = d.a.j.a((Iterable)localLinkedList, (CharSequence)",", null, (CharSequence)",", 0, null, null, 58) + n.s((CharSequence)"0,", (9 - paramList.size()) * 2);
    AppMethodBeat.o(82902);
    return paramq;
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, biv parambiv, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(189471);
    Object localObject = m.BzD;
    localObject = new StringBuilder("WeixinWebCompt.config({resume:").append(paramBoolean).append(", debug:");
    g.a locala = g.BAm;
    c(paramg, g.a.getDebug() + ", iframeUrlPattern:'" + b.erP() + "', configFinishTs:" + paramLong + ", bizReportId:" + parambiv.DGt + ", options:" + parambiv.DGu + "})");
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "WeixinWebCompt.config:" + parambiv.DGu);
    AppMethodBeat.o(189471);
  }
  
  static void a(com.tencent.mm.pluginsdk.q paramq, k paramk)
  {
    AppMethodBeat.i(82901);
    paramq.bG(paramk.kER + "_START", System.currentTimeMillis());
    AppMethodBeat.o(82901);
  }
  
  static void c(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, String paramString)
  {
    AppMethodBeat.i(189473);
    paramg.evaluateJavascript(paramString, null);
    AppMethodBeat.o(189473);
  }
  
  public static final void erJ()
  {
    AppMethodBeat.i(82923);
    b.tI(false);
    AppMethodBeat.o(82923);
  }
  
  private final void g(final String paramString, final d.g.a.b<? super String, d.y> paramb)
  {
    AppMethodBeat.i(82912);
    com.tencent.mm.ad.c.g((d.g.a.a)new t(this, paramString, paramb));
    AppMethodBeat.o(82912);
  }
  
  public final void aM(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(189474);
    d.g.b.k.h(paramString1, "webCompt");
    d.g.b.k.h(paramString2, "event");
    if (bt.isNullOrNil(paramString2))
    {
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "dispatch event is null");
      AppMethodBeat.o(189474);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.v(TAG, "dispatch event=%s, value=%s", new Object[] { paramString2, paramString3 });
    com.tencent.mm.ad.c.g((d.g.a.a)new q(this, paramString1, paramString2, paramString3));
    this.Bys.a(b.Byo);
    AppMethodBeat.o(189474);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.g ayO(String paramString)
  {
    AppMethodBeat.i(189475);
    d.g.b.k.h(paramString, "webCompt");
    paramString = (c.l.a)erw().get(paramString);
    if (paramString != null)
    {
      paramString = paramString.erU();
      AppMethodBeat.o(189475);
      return paramString;
    }
    AppMethodBeat.o(189475);
    return null;
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
        b.erO().clear();
        if (!this.fFP) {
          break label301;
        }
        l locall = erw();
        j localj = this.Bys;
        d.g.b.k.h(localj, "reporter");
        com.tencent.mm.sdk.platformtools.ad.i(b.erK(), "clear workerManager#" + locall.id);
        Iterator localIterator = locall.entrySet().iterator();
        i = -1;
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        locala = (c.l.a)localEntry.getValue();
        if ((!locala.used) && (locala.Bzu) && (!locall.Bzt.containsKey(localEntry.getKey())))
        {
          locala.aFm = true;
          locala.Bzy = null;
          com.tencent.mm.sdk.platformtools.ad.i(b.erK(), "WebComptWorker.recycle " + locala.appId + '@' + locala.BzB.name + ':' + locala.BzA);
          ((Map)locall.Bzt).put(localEntry.getKey(), locala);
          localj.a(b.Byp);
          continue;
        }
        if (locala.used) {
          break label279;
        }
      }
      finally {}
      if (locala.BzA == localObject.Bzr) {
        i = localObject.Bzr;
      } else {
        label279:
        locala.erU().destroy();
      }
    }
    localObject.Bzr = i;
    localObject.clear();
    label301:
    AppMethodBeat.o(82900);
  }
  
  final l erw()
  {
    AppMethodBeat.i(82899);
    l locall = (l)this.Byt.getValue();
    AppMethodBeat.o(82899);
    return locall;
  }
  
  public final void erx()
  {
    AppMethodBeat.i(189476);
    if (this.fFP)
    {
      a(this, "WeixinOpenTags.onClean()");
      this.Bys.a(b.BxN);
    }
    AppMethodBeat.o(189476);
  }
  
  public final void h(final String paramString1, final String paramString2, final String paramString3, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(82910);
    d.g.b.k.h(paramString1, "webCompt");
    d.g.b.k.h(paramString2, "errMsg");
    Object localObject = (c.l.a)erw().get(paramString1);
    if (localObject != null)
    {
      dsn localdsn = new dsn();
      localdsn.dmE = paramString2;
      localdsn.EGX = paramString3;
      localdsn.EGY = paramInt1;
      localdsn.EGZ = paramInt2;
      com.tencent.xweb.y localy = this.AQP.getSettings();
      d.g.b.k.g(localy, "jsapi.settings");
      localdsn.EEw = localy.getUserAgentString();
      localdsn.neR = ((c.l.a)localObject).neR;
      localdsn.dlB = ((c.l.a)localObject).appId;
      localdsn.EHa = paramString1;
      localdsn.EHb = b.erS().getVersion();
      localdsn.EHc = ((c.l.a)localObject).Bzw;
      localdsn.EHd = ((c.l.a)localObject).Bzx;
      this.Bys.a(b.Bym);
      localObject = new b.a();
      ((b.a)localObject).c((com.tencent.mm.bx.a)localdsn);
      ((b.a)localObject).d((com.tencent.mm.bx.a)new dso());
      ((b.a)localObject).wg("/cgi-bin/mmbiz-bin/webcompt/reportjserr");
      ((b.a)localObject).nB(2914);
      ((b.a)localObject).nD(0);
      ((b.a)localObject).nE(0);
      IPCRunCgi.a(((b.a)localObject).atI(), (IPCRunCgi.a)new r(this, paramString2, paramString3, paramInt1, paramInt2, paramString1));
      AppMethodBeat.o(82910);
      return;
    }
    AppMethodBeat.o(82910);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "", "a8key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "fullUrl", "", "httpHeaders", "", "(Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;Ljava/lang/String;Ljava/util/Map;)V", "getFullUrl", "()Ljava/lang/String;", "getHttpHeaders", "()Ljava/util/Map;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "webview-sdk_release"})
  public static final class a
  {
    final com.tencent.mm.plugin.webview.e.c ByG;
    final Map<String, String> ByH;
    final String nha;
    
    public a(com.tencent.mm.plugin.webview.e.c paramc, String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(189456);
      this.ByG = paramc;
      this.nha = paramString;
      this.ByH = paramMap;
      AppMethodBeat.o(189456);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion;", "", "()V", "PREFIX_DEBUG_PATH", "", "TAG", "getTAG$webview_sdk_release", "()Ljava/lang/String;", "_cachedFilePath", "debugInfo", "getDebugInfo", "debugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "getDebugger", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "debugger$delegate", "Lkotlin/Lazy;", "iframeUrlPattern", "getIframeUrlPattern", "iframeUrlPattern$delegate", "manager", "com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$1", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$1;", "matrix", "", "", "getMatrix", "()Ljava/util/List;", "matrix$delegate", "meta", "Lcom/tencent/mm/json/JSONObject;", "getMeta", "()Lcom/tencent/mm/json/JSONObject;", "meta$delegate", "preloadWorkers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "scheme", "scheme$annotations", "getScheme", "scriptManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "getScriptManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "scriptManager$delegate", "skeleton", "getSkeleton", "skeleton$delegate", "debugPath", "getDebugPath", "(Ljava/lang/String;)Ljava/lang/String;", "savePath", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getSavePath", "(Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;)Ljava/lang/String;", "version", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "clearDebugPath", "", "jsapiOnly", "", "appOnly", "getCachedFilePath", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalScript", "path", "scripts", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScript", "preloadWorker", "force", "readText", "DebugType", "Debugger", "ResType", "Script", "ScriptManager", "Worker", "webview-sdk_release"})
  public static final class b
  {
    static
    {
      AppMethodBeat.i(82819);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(b.class), "meta", "getMeta()Lcom/tencent/mm/json/JSONObject;")), (d.l.k)w.a(new u(w.bk(b.class), "iframeUrlPattern", "getIframeUrlPattern()Ljava/lang/String;")), (d.l.k)w.a(new u(w.bk(b.class), "matrix", "getMatrix()Ljava/util/List;")), (d.l.k)w.a(new u(w.bk(b.class), "skeleton", "getSkeleton()Ljava/lang/String;")), (d.l.k)w.a(new u(w.bk(b.class), "scriptManager", "getScriptManager()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;")), (d.l.k)w.a(new u(w.bk(b.class), "debugger", "getDebugger()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;")) };
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
      //   15: checkcast 289	java/io/Closeable
      //   18: astore_3
      //   19: aload_3
      //   20: checkcast 291	java/io/InputStream
      //   23: astore_0
      //   24: aload_0
      //   25: ldc_w 293
      //   28: invokestatic 296	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   31: new 298	java/lang/String
      //   34: dup
      //   35: aload_0
      //   36: invokestatic 304	d/f/a:V	(Ljava/io/InputStream;)[B
      //   39: getstatic 310	d/n/d:UTF_8	Ljava/nio/charset/Charset;
      //   42: invokespecial 313	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   45: astore_0
      //   46: aload_3
      //   47: aconst_null
      //   48: invokestatic 318	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   51: ldc_w 281
      //   54: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_0
      //   58: areturn
      //   59: astore_1
      //   60: ldc_w 281
      //   63: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: aload_1
      //   67: athrow
      //   68: astore_0
      //   69: aload_3
      //   70: aload_1
      //   71: invokestatic 318	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   74: ldc_w 281
      //   77: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   80: aload_0
      //   81: athrow
      //   82: astore_0
      //   83: aload_2
      //   84: astore_1
      //   85: goto -16 -> 69
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	88	0	paramp	com.tencent.mm.plugin.appbrand.appcache.p
      //   0	88	1	paramString	String
      //   1	83	2	localObject	Object
      //   18	52	3	localCloseable	java.io.Closeable
      // Exception table:
      //   from	to	target	type
      //   19	46	59	java/lang/Throwable
      //   60	68	68	finally
      //   19	46	82	finally
    }
    
    private static String ayR(String paramString)
    {
      AppMethodBeat.i(82828);
      paramString = c.erz() + paramString;
      AppMethodBeat.o(82828);
      return paramString;
    }
    
    public static String cPI()
    {
      AppMethodBeat.i(82831);
      Object localObject = c.ByF;
      localObject = erN();
      StringBuilder localStringBuilder = new StringBuilder("\n            [debug]\n            debug: ");
      g.a locala = g.BAm;
      localObject = n.aRa(g.a.getDebug() + "\n            \n            [lib]\n            version: " + ((b)localObject).ByR + "\n            res: " + ((b)localObject).ByQ + "\n\n            " + d.a.j.a((Iterable)((b)localObject).ByP, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n            \n            " + d.a.j.a((Iterable)((b)localObject).ByO, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n            ");
      AppMethodBeat.o(82831);
      return localObject;
    }
    
    public static String erK()
    {
      AppMethodBeat.i(189461);
      String str = c.access$getTAG$cp();
      AppMethodBeat.o(189461);
      return str;
    }
    
    private static e erM()
    {
      AppMethodBeat.i(82827);
      Object localObject = c.erH();
      b localb = c.ByF;
      localObject = (e)((d.f)localObject).getValue();
      AppMethodBeat.o(82827);
      return localObject;
    }
    
    private static b erN()
    {
      AppMethodBeat.i(82830);
      Object localObject = c.erI();
      b localb = c.ByF;
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
      //   2: ldc_w 501
      //   5: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 449	com/tencent/mm/plugin/webview/k/c:access$getTAG$cp	()Ljava/lang/String;
      //   11: ldc_w 503
      //   14: iconst_1
      //   15: anewarray 4	java/lang/Object
      //   18: dup
      //   19: iconst_0
      //   20: aload_0
      //   21: aastore
      //   22: invokestatic 508	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   25: getstatic 378	com/tencent/mm/plugin/webview/k/g:BAm	Lcom/tencent/mm/plugin/webview/k/g$a;
      //   28: astore_3
      //   29: invokestatic 384	com/tencent/mm/plugin/webview/k/g$a:getDebug	()Z
      //   32: ifeq +181 -> 213
      //   35: new 437	com/tencent/mm/vfs/e
      //   38: dup
      //   39: ldc_w 510
      //   42: aload_0
      //   43: invokestatic 514	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   46: invokevirtual 517	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   49: invokestatic 363	com/tencent/mm/plugin/webview/k/c$b:ayR	(Ljava/lang/String;)Ljava/lang/String;
      //   52: invokespecial 440	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
      //   55: astore_3
      //   56: aload_3
      //   57: invokevirtual 520	com/tencent/mm/vfs/e:exists	()Z
      //   60: ifeq +38 -> 98
      //   63: aload_1
      //   64: ifnull +21 -> 85
      //   67: aload_1
      //   68: new 17	com/tencent/mm/plugin/webview/k/c$b$d
      //   71: dup
      //   72: aload_0
      //   73: aconst_null
      //   74: getstatic 524	com/tencent/mm/plugin/webview/k/c$b$a:ByK	Lcom/tencent/mm/plugin/webview/k/c$b$a;
      //   77: iconst_2
      //   78: invokespecial 527	com/tencent/mm/plugin/webview/k/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)V
      //   81: invokevirtual 533	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   84: pop
      //   85: aload_3
      //   86: invokestatic 539	com/tencent/mm/vfs/f:ag	(Lcom/tencent/mm/vfs/e;)Ljava/lang/String;
      //   89: astore_0
      //   90: ldc_w 501
      //   93: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   96: aload_0
      //   97: areturn
      //   98: new 437	com/tencent/mm/vfs/e
      //   101: dup
      //   102: ldc_w 541
      //   105: invokestatic 363	com/tencent/mm/plugin/webview/k/c$b:ayR	(Ljava/lang/String;)Ljava/lang/String;
      //   108: invokespecial 440	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
      //   111: astore_3
      //   112: aload_3
      //   113: invokevirtual 520	com/tencent/mm/vfs/e:exists	()Z
      //   116: ifeq +97 -> 213
      //   119: aload_1
      //   120: ifnull +21 -> 141
      //   123: aload_1
      //   124: new 17	com/tencent/mm/plugin/webview/k/c$b$d
      //   127: dup
      //   128: aload_0
      //   129: aconst_null
      //   130: getstatic 544	com/tencent/mm/plugin/webview/k/c$b$a:ByL	Lcom/tencent/mm/plugin/webview/k/c$b$a;
      //   133: iconst_2
      //   134: invokespecial 527	com/tencent/mm/plugin/webview/k/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)V
      //   137: invokevirtual 533	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   140: pop
      //   141: new 546	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   144: dup
      //   145: aload_3
      //   146: invokespecial 548	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Lcom/tencent/mm/vfs/e;)V
      //   149: checkcast 289	java/io/Closeable
      //   152: astore_3
      //   153: aload_3
      //   154: checkcast 546	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
      //   157: astore_1
      //   158: aload_1
      //   159: invokevirtual 551	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:aPe	()Z
      //   162: pop
      //   163: getstatic 180	com/tencent/mm/plugin/webview/k/c:ByF	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   166: astore 4
      //   168: aload_1
      //   169: checkcast 283	com/tencent/mm/plugin/appbrand/appcache/p
      //   172: aload_0
      //   173: invokestatic 187	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
      //   176: astore_0
      //   177: aload_3
      //   178: aconst_null
      //   179: invokestatic 318	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   182: ldc_w 501
      //   185: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   188: aload_0
      //   189: areturn
      //   190: astore_1
      //   191: ldc_w 501
      //   194: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   197: aload_1
      //   198: athrow
      //   199: astore_0
      //   200: aload_3
      //   201: aload_1
      //   202: invokestatic 318	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   205: ldc_w 501
      //   208: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   211: aload_0
      //   212: athrow
      //   213: invokestatic 494	com/tencent/mm/plugin/webview/k/c$b:erM	()Lcom/tencent/mm/plugin/webview/k/c$b$e;
      //   216: astore_2
      //   217: aload_0
      //   218: ldc_w 552
      //   221: invokestatic 252	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   224: getstatic 180	com/tencent/mm/plugin/webview/k/c:ByF	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   227: astore_3
      //   228: aload_2
      //   229: getfield 556	com/tencent/mm/plugin/webview/k/c$b$e:ByY	Lcom/tencent/mm/plugin/appbrand/appcache/p;
      //   232: aload_0
      //   233: invokestatic 187	com/tencent/mm/plugin/webview/k/c$b:a	(Lcom/tencent/mm/plugin/appbrand/appcache/p;Ljava/lang/String;)Ljava/lang/String;
      //   236: astore_2
      //   237: aload_1
      //   238: ifnull +28 -> 266
      //   241: getstatic 180	com/tencent/mm/plugin/webview/k/c:ByF	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   244: astore_3
      //   245: aload_1
      //   246: new 17	com/tencent/mm/plugin/webview/k/c$b$d
      //   249: dup
      //   250: aload_0
      //   251: invokestatic 369	com/tencent/mm/plugin/webview/k/c$b:erN	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   254: getfield 402	com/tencent/mm/plugin/webview/k/c$b$b:ByQ	Lcom/tencent/mm/plugin/webview/k/c$b$c;
      //   257: aconst_null
      //   258: iconst_4
      //   259: invokespecial 527	com/tencent/mm/plugin/webview/k/c$b$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/k/c$b$c;Lcom/tencent/mm/plugin/webview/k/c$b$a;I)V
      //   262: invokevirtual 533	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   265: pop
      //   266: ldc_w 501
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
      String str = c.erB();
      AppMethodBeat.o(82820);
      return str;
    }
    
    public static void tI(boolean paramBoolean)
    {
      AppMethodBeat.i(82822);
      if (c.erA().size() < 3)
      {
        if (paramBoolean) {
          break label52;
        }
        if (((Collection)c.erA()).isEmpty()) {
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
      kotlinx.coroutines.d.a((kotlinx.coroutines.ad)bc.Kem, (d.d.f)at.fLg(), (d.g.a.m)new j(null), 2);
      AppMethodBeat.o(82822);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "", "(Ljava/lang/String;I)V", "NA", "PARAM", "SDCARD", "SDCARD_PKG", "COMMAND", "webview-sdk_release"})
    static enum a
    {
      static
      {
        AppMethodBeat.i(82775);
        a locala1 = new a("NA", 0);
        ByI = locala1;
        a locala2 = new a("PARAM", 1);
        ByJ = locala2;
        a locala3 = new a("SDCARD", 2);
        ByK = locala3;
        a locala4 = new a("SDCARD_PKG", 3);
        ByL = locala4;
        a locala5 = new a("COMMAND", 4);
        ByM = locala5;
        ByN = new a[] { locala1, locala2, locala3, locala4, locala5 };
        AppMethodBeat.o(82775);
      }
      
      private a() {}
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "", "()V", "isPreload", "", "()Z", "setPreload", "(Z)V", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "setResType", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;)V", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "verion", "", "getVerion", "()I", "setVerion", "(I)V", "workers", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "getWorkers", "clear", "", "webview-sdk_release"})
    static final class b
    {
      final LinkedList<c.b.f> ByO;
      final LinkedList<c.b.d> ByP;
      c.b.c ByQ;
      int ByR;
      boolean jsq;
      
      public b()
      {
        AppMethodBeat.i(82780);
        this.ByO = new LinkedList();
        this.ByP = new LinkedList();
        this.ByQ = c.b.c.ByS;
        AppMethodBeat.o(82780);
      }
      
      public final void a(c.b.c paramc)
      {
        AppMethodBeat.i(82778);
        d.g.b.k.h(paramc, "<set-?>");
        this.ByQ = paramc;
        AppMethodBeat.o(82778);
      }
      
      public final void clear()
      {
        AppMethodBeat.i(82779);
        this.ByO.clear();
        this.ByP.clear();
        AppMethodBeat.o(82779);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "", "(Ljava/lang/String;I)V", "NA", "CACHE", "NETWORK", "ASSETS", "webview-sdk_release"})
    static enum c
    {
      static
      {
        AppMethodBeat.i(82781);
        c localc1 = new c("NA", 0);
        ByS = localc1;
        c localc2 = new c("CACHE", 1);
        ByT = localc2;
        c localc3 = new c("NETWORK", 2);
        ByU = localc3;
        c localc4 = new c("ASSETS", 3);
        ByV = localc4;
        ByW = new c[] { localc1, localc2, localc3, localc4 };
        AppMethodBeat.o(82781);
      }
      
      private c() {}
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "", "uri", "", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "debugType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;)V", "getDebugType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getUri", "()Ljava/lang/String;", "toString", "webview-sdk_release"})
    static final class d
    {
      private final c.b.c ByQ;
      private final c.b.a ByX;
      private final String uri;
      
      public d(String paramString, c.b.c paramc, c.b.a parama)
      {
        AppMethodBeat.i(82785);
        this.uri = paramString;
        this.ByQ = paramc;
        this.ByX = parama;
        AppMethodBeat.o(82785);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(82784);
        StringBuilder localStringBuilder = new StringBuilder("[script]\n                ");
        if (this.ByQ != c.b.c.ByS) {}
        for (String str = "resType: " + this.ByQ;; str = "debugType: " + this.ByX)
        {
          str = n.aRa(str + "\n                " + this.uri + "\n                ");
          AppMethodBeat.o(82784);
          return str;
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)V", "version", "", "getVersion", "()I", "version$delegate", "Lkotlin/Lazy;", "getScript", "", "path", "webview-sdk_release"})
    static final class e
    {
      final com.tencent.mm.plugin.appbrand.appcache.p ByY;
      private final d.f nfa;
      
      static
      {
        AppMethodBeat.i(82788);
        $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(e.class), "version", "getVersion()I")) };
        AppMethodBeat.o(82788);
      }
      
      public e(com.tencent.mm.plugin.appbrand.appcache.p paramp)
      {
        AppMethodBeat.i(82790);
        this.ByY = paramp;
        this.nfa = d.g.E((d.g.a.a)new a(this));
        AppMethodBeat.o(82790);
      }
      
      public final int getVersion()
      {
        AppMethodBeat.i(82789);
        int i = ((Number)this.nfa.getValue()).intValue();
        AppMethodBeat.o(82789);
        return i;
      }
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "", "id", "", "isPreload", "", "isRecycled", "(IZZ)V", "getId", "()I", "()Z", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "toString", "", "webview-sdk_release"})
    static final class f
    {
      final LinkedList<c.b.d> ByP;
      private final boolean aFm;
      private final int id;
      private final boolean jsq;
      
      private f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
      {
        AppMethodBeat.i(82792);
        this.id = paramInt;
        this.jsq = paramBoolean1;
        this.aFm = paramBoolean2;
        this.ByP = new LinkedList();
        AppMethodBeat.o(82792);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(82791);
        String str = n.aRa("[worker #" + this.id + "]\n                preload: " + this.jsq + "\n                recycled: " + this.aFm + "\n                \n                " + d.a.j.a((Iterable)this.ByP, (CharSequence)"\n\n", null, null, 0, null, null, 62) + "\n                ");
        AppMethodBeat.o(82791);
        return str;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"deleteChildJs", "", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
    static final class g
      extends d.g.b.l
      implements d.g.a.b<com.tencent.mm.vfs.e, d.y>
    {
      public static final g Bza;
      
      static
      {
        AppMethodBeat.i(82798);
        Bza = new g();
        AppMethodBeat.o(82798);
      }
      
      g()
      {
        super();
      }
      
      public static void U(com.tencent.mm.vfs.e parame)
      {
        AppMethodBeat.i(175715);
        d.g.b.k.h(parame, "$this$deleteChildJs");
        parame = parame.a((com.tencent.mm.vfs.g)1.Bzb);
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
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
    static final class h<InputType, ResultType>
      implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCString>
    {
      public static final h Bzd;
      
      static
      {
        AppMethodBeat.i(82802);
        Bzd = new h();
        AppMethodBeat.o(82802);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
    static final class i
      extends d.g.b.l
      implements d.g.a.b<IPCString, d.y>
    {
      i(d.d.d paramd)
      {
        super();
      }
    }
    
    @d.d.b.a.f(c="com.tencent.mm.plugin.webview.webcompt.WebComponent$Companion$preloadWorker$1", f="WebComponent.kt", l={722}, m="invokeSuspend")
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class j
      extends d.d.b.a.j
      implements d.g.a.m<kotlinx.coroutines.ad, d.d.d<? super d.y>, Object>
    {
      int label;
      private kotlinx.coroutines.ad mTa;
      Object mTb;
      
      j(d.d.d paramd)
      {
        super();
      }
      
      public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
      {
        AppMethodBeat.i(82813);
        d.g.b.k.h(paramd, "completion");
        paramd = new j(paramd);
        paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
        AppMethodBeat.o(82813);
        return paramd;
      }
      
      public final Object cP(Object paramObject)
      {
        AppMethodBeat.i(82812);
        paramObject = d.d.a.a.JgJ;
        Object localObject;
        c.b localb;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82812);
          throw paramObject;
        case 0: 
          localObject = this.mTa;
          localb = c.ByF;
          this.mTb = localObject;
          this.label = 1;
          if (c.b.a(this) == paramObject)
          {
            AppMethodBeat.o(82812);
            return paramObject;
          }
          break;
        }
        paramObject = new c.l();
        if (paramObject.Bzr == -1)
        {
          localObject = c.ery();
          localb = c.ByF;
          paramObject.Bzr = ((c.e)localObject).create(c.b.g("/wxwebcompt.js", paramObject.Bzs.ByP));
          localObject = c.ByF;
          com.tencent.mm.sdk.platformtools.ad.i(c.b.erK(), "preload workerManager#" + paramObject.id);
        }
        for (;;)
        {
          c.erA().offerFirst(paramObject);
          paramObject = d.y.JfV;
          AppMethodBeat.o(82812);
          return paramObject;
          localObject = c.ByF;
          com.tencent.mm.sdk.platformtools.ad.w(c.b.erK(), "preload twice #" + paramObject.id);
        }
      }
      
      public final Object n(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82814);
        paramObject1 = ((j)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
        AppMethodBeat.o(82814);
        return paramObject1;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<c.b.b>
  {
    public static final c Bzc;
    
    static
    {
      AppMethodBeat.i(82800);
      Bzc = new c();
      AppMethodBeat.o(82800);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    public static final d Bze;
    
    static
    {
      AppMethodBeat.i(82805);
      Bze = new d();
      AppMethodBeat.o(82805);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$1", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AbstractMultiContextJsEngine;", "create", "", "script", "", "createJSRuntime", "Lcom/tencent/mm/appbrand/v8/IJSRuntime;", "config", "Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;", "createMainContextEngine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "jsRuntime", "mainContextTag", "webview-sdk_release"})
  public static final class e
    extends com.tencent.mm.plugin.appbrand.jsruntime.a
  {
    public final com.tencent.mm.appbrand.v8.m a(IJSRuntime paramIJSRuntime, int paramInt)
    {
      AppMethodBeat.i(189459);
      d.g.b.k.h(paramIJSRuntime, "jsRuntime");
      paramIJSRuntime = paramIJSRuntime.hE(paramInt);
      AppMethodBeat.o(189459);
      return paramIJSRuntime;
    }
    
    public final int create(String paramString)
    {
      AppMethodBeat.i(189460);
      d.g.b.k.h(paramString, "script");
      com.tencent.mm.plugin.appbrand.jsruntime.g localg = bfE();
      localg.evaluateJavascript(paramString, null);
      d.g.b.k.g(localg, "context");
      int i = localg.bfC();
      AppMethodBeat.o(189460);
      return i;
    }
    
    public final IJSRuntime g(IJSRuntime.Config paramConfig)
    {
      AppMethodBeat.i(189458);
      paramConfig = (IJSRuntime)com.tencent.mm.appbrand.v8.f.c(paramConfig);
      AppMethodBeat.o(189458);
      return paramConfig;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<List<? extends Integer>>
  {
    public static final f Bzf;
    
    static
    {
      AppMethodBeat.i(82809);
      Bzf = new f();
      AppMethodBeat.o(82809);
    }
    
    f()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.ac.i>
  {
    public static final g Bzh;
    
    static
    {
      AppMethodBeat.i(82811);
      Bzh = new g();
      AppMethodBeat.o(82811);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<c.b.e>
  {
    public static final h Bzi;
    
    static
    {
      AppMethodBeat.i(82816);
      Bzi = new h();
      AppMethodBeat.o(82816);
    }
    
    h()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    public static final i Bzj;
    
    static
    {
      AppMethodBeat.i(82818);
      Bzj = new i();
      AppMethodBeat.o(82818);
    }
    
    i()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "retCode", "", "webComptName", "", "errMsg", "(ILjava/lang/String;Ljava/lang/String;)V", "toJsonString", "webview-sdk_release"})
  public static final class j
    extends Exception
  {
    final String Bzk;
    final String errMsg;
    final int retCode;
    
    public j(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(82842);
      this.retCode = paramInt;
      this.Bzk = paramString1;
      this.errMsg = paramString2;
      AppMethodBeat.o(82842);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "", "stepName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStepName", "()Ljava/lang/String;", "STEP_CREATE_JS_CXT", "STEP_EVAL_MAIN_FRAME", "STEP_GET_A8KEY", "STEP_FETCH_WORKER", "STEP_GET_APP_SCRIPT", "webview-sdk_release"})
  static enum k
  {
    final String kER;
    
    static
    {
      AppMethodBeat.i(82843);
      k localk1 = new k("STEP_CREATE_JS_CXT", 0, "createJsContext");
      Bzl = localk1;
      k localk2 = new k("STEP_EVAL_MAIN_FRAME", 1, "evalMainFrame");
      Bzm = localk2;
      k localk3 = new k("STEP_GET_A8KEY", 2, "GetA8Key");
      Bzn = localk3;
      k localk4 = new k("STEP_FETCH_WORKER", 3, "FetchWorker");
      Bzo = localk4;
      k localk5 = new k("STEP_GET_APP_SCRIPT", 4, "GetAppScript");
      Bzp = localk5;
      Bzq = new k[] { localk1, localk2, localk3, localk4, localk5 };
      AppMethodBeat.o(82843);
    }
    
    private k(String paramString)
    {
      this.kER = paramString;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "Lkotlin/collections/HashMap;", "()V", "id", "", "getId", "()I", "preloadDebugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "preloadId", "recycleWorkers", "fetch", "appId", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "preload", "", "recycle", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "WebComptWorker", "webview-sdk_release"})
  static final class l
    extends HashMap<String, a>
  {
    int Bzr;
    c.b.f Bzs;
    final HashMap<String, a> Bzt;
    final int id;
    
    public l()
    {
      AppMethodBeat.i(82849);
      this.id = ((int)(System.currentTimeMillis() % 1000L));
      this.Bzr = -1;
      this.Bzs = new c.b.f(this.id, true, false, 4);
      this.Bzt = new HashMap();
      AppMethodBeat.o(82849);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "", "workerId", "", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;ILcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;)V", "a8KeyUrl", "", "getA8KeyUrl", "()Ljava/lang/String;", "setA8KeyUrl", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "appScriptMD5", "getAppScriptMD5", "setAppScriptMD5", "appScriptUrl", "getAppScriptUrl", "setAppScriptUrl", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "getEngine", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "isRecycled", "", "()Z", "setRecycled", "(Z)V", "jsapi", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "setJsapi", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;)V", "launched", "getLaunched", "setLaunched", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "setPerformanceHelper", "(Lcom/tencent/mm/pluginsdk/PerformanceHelper;)V", "refer", "getRefer", "setRefer", "used", "getUsed", "setUsed", "getWebComptInfo", "()Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getWorkerId", "()I", "recycle", "", "reuse", "webview-sdk_release"})
    public final class a
    {
      final int BzA;
      final biv BzB;
      boolean Bzu;
      String Bzv;
      String Bzw;
      String Bzx;
      com.tencent.mm.pluginsdk.q Bzy;
      i Bzz;
      boolean aFm;
      String appId;
      String neR;
      boolean used;
      
      public a(biv parambiv, c paramc)
      {
        AppMethodBeat.i(82848);
        this.BzA = parambiv;
        this.BzB = paramc;
        this.appId = "";
        this.neR = "";
        this.Bzv = "";
        this.Bzw = "";
        this.Bzx = "";
        this$1 = this.BzB.name;
        d.g.b.k.g(c.l.this, "webComptInfo.name");
        this.Bzz = new i(localObject, c.l.this, localObject.AQP);
        erU().addJavascriptInterface(this.Bzz, "__webcompt");
        AppMethodBeat.o(82848);
      }
      
      public final void ayT(String paramString)
      {
        AppMethodBeat.i(82846);
        d.g.b.k.h(paramString, "<set-?>");
        this.Bzw = paramString;
        AppMethodBeat.o(82846);
      }
      
      public final com.tencent.mm.plugin.appbrand.jsruntime.g erU()
      {
        AppMethodBeat.i(189462);
        com.tencent.mm.plugin.appbrand.jsruntime.g localg = c.ery().sy(this.BzA);
        d.g.b.k.g(localg, "manager.getJsContext(workerId)");
        AppMethodBeat.o(189462);
        return localg;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"toJsonStringArray", "", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.b<List<? extends String>, String>
  {
    public static final m BzD;
    
    static
    {
      AppMethodBeat.i(82862);
      BzD = new m();
      AppMethodBeat.o(82862);
    }
    
    m()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"})
  public static final class n
    extends d.d.a
    implements CoroutineExceptionHandler
  {
    public n(f.c paramc, c paramc1, v.e parame)
    {
      super();
    }
    
    public final void handleException(d.d.f paramf, Throwable paramThrowable)
    {
      AppMethodBeat.i(82863);
      this.BzE.Bys.a(b.BxT);
      if ((paramThrowable instanceof c.j))
      {
        ((d.g.a.b)this.BzF.Jhw).aA(paramThrowable);
        AppMethodBeat.o(82863);
        return;
      }
      AppMethodBeat.o(82863);
      throw paramThrowable;
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.webview.webcompt.WebComponent$createJsContext$2", f="WebComponent.kt", l={234, 329, 334, 341}, m="invokeSuspend")
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class o
    extends d.d.b.a.j
    implements d.g.a.m<kotlinx.coroutines.ad, d.d.d<? super d.y>, Object>
  {
    Object BzG;
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    Object nfO;
    Object nfP;
    Object nfQ;
    Object nfR;
    Object nfS;
    Object nfT;
    Object nfU;
    Object nfV;
    Object nfW;
    
    o(c paramc, boolean paramBoolean, com.tencent.mm.pluginsdk.q paramq, String paramString1, biv parambiv, String paramString2, String paramString3, v.e parame, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(82875);
      d.g.b.k.h(paramd, "completion");
      paramd = new o(this.BzE, this.BzH, this.BzI, this.keu, this.BzJ, this.BzK, this.iQm, this.BzL, paramd);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(82875);
      return paramd;
    }
    
    public final Object cP(final Object paramObject)
    {
      AppMethodBeat.i(82874);
      d.d.a.a locala = d.d.a.a.JgJ;
      Object localObject1;
      Object localObject5;
      Object localObject2;
      label322:
      Object localObject3;
      label379:
      Object localObject8;
      Object localObject6;
      Object localObject7;
      Object localObject4;
      label825:
      label863:
      label1127:
      Object localObject9;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(82874);
        throw paramObject;
      case 0: 
        paramObject = this.mTa;
        localObject1 = c.ByF;
        this.mTb = paramObject;
        this.label = 1;
        if (c.b.a(this) == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
        }
      case 1: 
        paramObject = (kotlinx.coroutines.ad)this.mTb;
        if (this.BzH) {
          c.a(this.BzE, this.BzI);
        }
        localObject5 = new com.tencent.mm.ac.i();
        localObject1 = ((Iterable)n.a((CharSequence)n.mH(this.keu, "#"), new String[] { "&" })).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = n.a((CharSequence)((Iterator)localObject1).next(), new String[] { "=" });
          if (((List)localObject2).size() == 2) {
            ((com.tencent.mm.ac.i)localObject5).j((String)((List)localObject2).get(0), URLDecoder.decode((String)((List)localObject2).get(1), "UTF-8"));
          }
        }
        localObject1 = g.BAm;
        if (g.a.getDebug())
        {
          localObject1 = g.BAm;
          localObject1 = h.buO().getString("debugA8Key", "");
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          if (!n.aC((CharSequence)localObject1))
          {
            i = 1;
            if (i == 0) {
              break label825;
            }
            localObject1 = new o(localObject1, c.b.a.ByM);
            if (localObject1 == null) {
              break label863;
            }
            localObject2 = (String)((o)localObject1).first;
            localObject1 = (c.b.a)((o)localObject1).second;
            localObject3 = c.ByF;
            c.b.erO().ByP.add(new c.b.d((String)localObject2, null, (c.b.a)localObject1, 2));
            localObject1 = localObject2;
            localObject2 = c.ByF;
            com.tencent.mm.sdk.platformtools.ad.d(c.b.erK(), "createJsContext a8key:".concat(String.valueOf(localObject1)));
            c.b(this.BzI, c.k.Bzl);
            localObject2 = c.ByF;
            com.tencent.mm.sdk.platformtools.ad.i(c.b.erK(), "createJsContext init " + this.BzK);
            c.c(this.BzI, c.k.Bzo);
            localObject3 = c.a(this.BzE);
            localObject8 = this.iQm;
            localObject6 = this.BzJ;
            localObject7 = this.BzE;
            d.g.b.k.h(localObject8, "appId");
            d.g.b.k.h(localObject6, "webComptInfo");
            d.g.b.k.h(localObject7, "webCompt");
            localObject4 = ((biv)localObject6).name;
            if (!((c.l)localObject3).Bzt.containsKey(localObject4)) {
              break label929;
            }
            localObject2 = (c.l.a)((c.l)localObject3).Bzt.get(localObject4);
            if ((localObject2 == null) || (!d.g.b.k.g(((c.l.a)localObject2).appId, localObject8))) {
              break label929;
            }
            ((c.l)localObject3).Bzt.remove(localObject4);
            localObject6 = (Map)localObject3;
            d.g.b.k.g(localObject4, "webComptName");
            d.g.b.k.g(localObject2, "it");
            ((Map)localObject6).put(localObject4, localObject2);
            localObject4 = c.ByF;
            c.b.erO().ByO.add(new c.b.f(((c.l)localObject3).id, false, true, 2));
            c.b(this.BzI, c.k.Bzo);
            localObject3 = this.keu;
            d.g.b.k.h(localObject3, "<set-?>");
            ((c.l.a)localObject2).neR = ((String)localObject3);
            ((c.l.a)localObject2).Bzy = this.BzI;
            localObject3 = this.iQm;
            d.g.b.k.h(localObject3, "appId");
            if ((!((c.l.a)localObject2).aFm) || (!d.g.b.k.g(((c.l.a)localObject2).appId, localObject3))) {
              break label1157;
            }
            ((c.l.a)localObject2).aFm = false;
            localObject4 = c.ByF;
            com.tencent.mm.sdk.platformtools.ad.i(c.b.erK(), "WebComptWorker.reuse " + (String)localObject3 + '@' + ((c.l.a)localObject2).BzB.name + ':' + ((c.l.a)localObject2).BzA);
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label1162;
          }
          c.b(((c.l.a)localObject2).erU(), this.BzJ, this.BzI.getStartTime());
          this.BzE.Bys.a(b.Byq);
          paramObject = d.y.JfV;
          AppMethodBeat.o(82874);
          return paramObject;
          i = 0;
          break;
          if (((com.tencent.mm.ac.i)localObject5).has("debugA8Key"))
          {
            localObject1 = new o(((com.tencent.mm.ac.i)localObject5).getString("debugA8Key"), c.b.a.ByJ);
            break label322;
          }
          localObject1 = null;
          break label322;
          localObject1 = new StringBuilder();
          localObject2 = c.ByF;
          localObject1 = c.b.getScheme() + this.BzK + "?appId=" + this.iQm + "&src=" + a.htmlEncode(this.keu);
          break label379;
          boolean bool;
          if (((c.l)localObject3).Bzr != -1)
          {
            bool = true;
            if (bool != true) {
              break label1075;
            }
            localObject2 = c.ByF;
            com.tencent.mm.sdk.platformtools.ad.i(c.b.erK(), "use preload workerManager#" + ((c.l)localObject3).id);
            localObject2 = ((c.l)localObject3).Bzs;
            localObject8 = c.ByF;
            c.b.erO().ByO.add(localObject2);
            localObject8 = c.ByF;
            c.b.erO().jsq = bool;
            if (bool != true) {
              break label1127;
            }
          }
          for (i = ((c.l)localObject3).Bzr;; i = ((c.e)localObject8).create(c.b.g("/wxwebcompt.js", ((c.b.f)localObject2).ByP)))
          {
            localObject2 = new c.l.a((c.l)localObject3, i, (biv)localObject6, (c)localObject7);
            localObject3 = (Map)localObject3;
            d.g.b.k.g(localObject4, "webComptName");
            ((Map)localObject3).put(localObject4, localObject2);
            break;
            bool = false;
            break label940;
            localObject2 = c.ByF;
            com.tencent.mm.sdk.platformtools.ad.i(c.b.erK(), "create new workerManager#" + ((c.l)localObject3).id);
            localObject2 = new c.b.f(((c.l)localObject3).id, false, false, 4);
            break label984;
            localObject8 = c.ery();
            localObject9 = c.ByF;
          }
        }
        localObject3 = this.iQm;
        d.g.b.k.h(localObject3, "<set-?>");
        ((c.l.a)localObject2).appId = ((String)localObject3);
        d.g.b.k.h(localObject1, "<set-?>");
        ((c.l.a)localObject2).Bzv = ((String)localObject1);
        localObject3 = this.BzJ.md5;
        d.g.b.k.g(localObject3, "webCompt.md5");
        d.g.b.k.h(localObject3, "<set-?>");
        ((c.l.a)localObject2).Bzx = ((String)localObject3);
        localObject3 = this.BzJ.url;
        d.g.b.k.g(localObject3, "webCompt.url");
        ((c.l.a)localObject2).ayT((String)localObject3);
        localObject4 = ((c.l.a)localObject2).erU();
        ((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject4).setJsExceptionHandler((com.tencent.mm.plugin.appbrand.jsruntime.h)new a((c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ac.i)localObject5));
        this.BzL.Jhw = ((d.g.a.b)new b((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject4, (c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ac.i)localObject5));
        c.a((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject4, this.BzJ, this.BzI.getStartTime());
        localObject3 = kotlinx.coroutines.d.b(paramObject, paramObject.fKB(), (d.g.a.m)new c(null, (c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ac.i)localObject5), 2);
        localObject6 = kotlinx.coroutines.d.b(paramObject, paramObject.fKB(), (d.g.a.m)new d((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject4, null, (c.l.a)localObject2, this, paramObject, (String)localObject1, (com.tencent.mm.ac.i)localObject5), 2);
        this.mTb = paramObject;
        this.nfO = localObject5;
        this.nfP = localObject1;
        this.nfQ = localObject2;
        this.nfR = localObject4;
        this.nfS = localObject4;
        this.nfT = localObject3;
        this.nfU = localObject6;
        this.label = 2;
        localObject8 = ((al)localObject6).f(this);
        if (localObject8 == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
        }
        break;
      case 2: 
        label929:
        label940:
        label984:
        localObject6 = (al)this.nfU;
        label1075:
        localObject3 = (al)this.nfT;
        label1157:
        label1162:
        localObject7 = (com.tencent.mm.plugin.appbrand.jsruntime.g)this.nfS;
        localObject4 = (com.tencent.mm.plugin.appbrand.jsruntime.g)this.nfR;
        localObject2 = (c.l.a)this.nfQ;
        localObject1 = (String)this.nfP;
        localObject9 = (com.tencent.mm.ac.i)this.nfO;
        localObject8 = (kotlinx.coroutines.ad)this.mTb;
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
        ((c.l.a)localObject2).ayT((String)localObject12);
        c.d((com.tencent.mm.plugin.appbrand.jsruntime.g)localObject7, "(function(WeixinWebCompt){" + (String)localObject8 + "})(WeixinWebCompt);");
        this.mTb = paramObject;
        this.nfO = localObject5;
        this.nfP = localObject1;
        this.nfQ = localObject2;
        this.nfR = localObject4;
        this.nfS = localObject7;
        this.nfT = localObject3;
        this.nfU = localObject6;
        this.nfV = localObject12;
        this.nfW = localObject8;
        this.label = 3;
        Object localObject11 = ((al)localObject3).f(this);
        Object localObject10;
        if (localObject11 == locala)
        {
          AppMethodBeat.o(82874);
          return locala;
          localObject8 = (String)this.nfW;
          localObject5 = (String)this.nfV;
          localObject10 = (al)this.nfU;
          localObject3 = (al)this.nfT;
          localObject6 = (com.tencent.mm.plugin.appbrand.jsruntime.g)this.nfS;
          localObject4 = (com.tencent.mm.plugin.appbrand.jsruntime.g)this.nfR;
          localObject2 = (c.l.a)this.nfQ;
          localObject1 = (String)this.nfP;
          localObject7 = (com.tencent.mm.ac.i)this.nfO;
          localObject9 = (kotlinx.coroutines.ad)this.mTb;
          localObject11 = paramObject;
        }
        for (;;)
        {
          paramObject = (c.a)localObject11;
          localObject11 = ((c.l.a)localObject2).Bzz;
          localObject12 = paramObject.ByG.axk(paramObject.nha);
          d.g.b.k.g(localObject12, "a8key.getJsPerm(fullUrl)");
          d.g.b.k.h(localObject12, "<set-?>");
          ((i)localObject11).ARc = ((JsapiPermissionWrapper)localObject12);
          c.a(this.BzE, (com.tencent.mm.plugin.appbrand.jsruntime.g)localObject6, paramObject);
          ((c.l.a)localObject2).Bzu = true;
          this.mTb = localObject9;
          this.nfO = localObject7;
          this.nfP = localObject1;
          this.nfQ = localObject2;
          this.nfR = localObject4;
          this.nfS = localObject6;
          this.nfT = localObject3;
          this.nfU = localObject10;
          this.nfV = localObject5;
          this.nfW = localObject8;
          this.BzG = paramObject;
          this.label = 4;
          if (ao.a(1000L, this) == locala)
          {
            AppMethodBeat.o(82874);
            return locala;
          }
          paramObject = c.ByF;
          c.b.erL();
          this.BzE.Bys.a(b.BxW);
          paramObject = c.ByF;
          com.tencent.mm.sdk.platformtools.ad.d(c.b.erK(), "createJsContext init finish " + this.BzK);
          paramObject = c.ByF;
          if (c.b.erO().jsq) {
            this.BzE.Bys.a(b.BxX);
          }
          paramObject = d.y.JfV;
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
      paramObject1 = ((o)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
      AppMethodBeat.o(82876);
      return paramObject1;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$1"})
    static final class a
      implements com.tencent.mm.plugin.appbrand.jsruntime.h
    {
      a(c.l.a parama, c.o paramo, kotlinx.coroutines.ad paramad, String paramString, com.tencent.mm.ac.i parami) {}
      
      public final void t(String paramString1, String paramString2)
      {
        AppMethodBeat.i(189463);
        Object localObject = c.ByF;
        com.tencent.mm.sdk.platformtools.ad.e(c.b.erK(), "engine " + jdField_this.BzK + " exception: " + paramString1 + " \nstackTrace:\n" + paramString2);
        localObject = jdField_this.BzE;
        String str = jdField_this.BzK;
        d.g.b.k.g(str, "name");
        d.g.b.k.g(paramString1, "message");
        c.a((c)localObject, str, paramString1, paramString2);
        jdField_this.BzE.Bys.a(b.Bye);
        AppMethodBeat.o(189463);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$2", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$2"})
    static final class b
      extends d.g.b.l
      implements d.g.a.b<c.j, d.y>
    {
      b(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, c.l.a parama, c.o paramo, kotlinx.coroutines.ad paramad, String paramString, com.tencent.mm.ac.i parami)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$asyncA8Key$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$3"})
    static final class c
      extends d.d.b.a.j
      implements d.g.a.m<kotlinx.coroutines.ad, d.d.d<? super c.a>, Object>
    {
      int label;
      private kotlinx.coroutines.ad mTa;
      Object mTb;
      
      c(d.d.d paramd, c.l.a parama, c.o paramo, kotlinx.coroutines.ad paramad, String paramString, com.tencent.mm.ac.i parami)
      {
        super();
      }
      
      public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
      {
        AppMethodBeat.i(82868);
        d.g.b.k.h(paramd, "completion");
        paramd = new c(paramd, this.BzM, jdField_this, paramObject, this.BzP, this.BzQ);
        paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
        AppMethodBeat.o(82868);
        return paramd;
      }
      
      public final Object cP(Object paramObject)
      {
        AppMethodBeat.i(82867);
        d.d.a.a locala = d.d.a.a.JgJ;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82867);
          throw paramObject;
        case 0: 
          paramObject = this.mTa;
          c.c(jdField_this.BzI, c.k.Bzn);
          Object localObject = jdField_this.BzE;
          String str1 = this.BzP;
          String str2 = jdField_this.BzJ.name;
          d.g.b.k.g(str2, "webCompt.name");
          this.mTb = paramObject;
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
        c.b(jdField_this.BzI, c.k.Bzn);
        AppMethodBeat.o(82867);
        return paramObject;
      }
      
      public final Object n(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82869);
        paramObject1 = ((c)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
        AppMethodBeat.o(82869);
        return paramObject1;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$asyncAppScript$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$4"})
    static final class d
      extends d.d.b.a.j
      implements d.g.a.m<kotlinx.coroutines.ad, d.d.d<? super o<? extends String, ? extends String>>, Object>
    {
      int label;
      private kotlinx.coroutines.ad mTa;
      Object mTb;
      Object nfO;
      
      d(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, d.d.d paramd, c.l.a parama, c.o paramo, kotlinx.coroutines.ad paramad, String paramString, com.tencent.mm.ac.i parami)
      {
        super();
      }
      
      public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
      {
        AppMethodBeat.i(82872);
        d.g.b.k.h(paramd, "completion");
        paramd = new d(this.ngr, paramd, this.BzM, jdField_this, paramObject, this.BzP, this.BzQ);
        paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
        AppMethodBeat.o(82872);
        return paramd;
      }
      
      public final Object cP(Object paramObject)
      {
        AppMethodBeat.i(82871);
        d.d.a.a locala = d.d.a.a.JgJ;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(82871);
          throw paramObject;
        case 0: 
          paramObject = this.mTa;
          c.c(jdField_this.BzI, c.k.Bzp);
          this.mTb = paramObject;
          this.nfO = this;
          this.label = 1;
          paramObject = new d.d.h(d.d.a.b.d(this));
          Object localObject = (d.d.d)paramObject;
          c.b localb = c.ByF;
          com.tencent.mm.ad.c.b(c.b.erK(), (d.g.a.a)new d.g.b.l((d.d.d)localObject) {});
          localObject = paramObject.fvB();
          if (localObject == d.d.a.a.JgJ) {
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
        c.b(jdField_this.BzI, c.k.Bzp);
        AppMethodBeat.o(82871);
        return paramObject;
      }
      
      public final Object n(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(82873);
        paramObject1 = ((d)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
        AppMethodBeat.o(82873);
        return paramObject1;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.b<c.j, d.y>
  {
    public static final p BzS;
    
    static
    {
      AppMethodBeat.i(82878);
      BzS = new p();
      AppMethodBeat.o(82878);
    }
    
    p()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    q(c paramc, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback", "com/tencent/mm/plugin/webview/webcompt/WebComponent$errReport$1$2$2", "com/tencent/mm/plugin/webview/webcompt/WebComponent$$special$$inlined$let$lambda$1"})
  static final class r
    implements IPCRunCgi.a
  {
    r(c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(82879);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        this.BzE.Bys.a(b.Byn);
      }
      AppMethodBeat.o(82879);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.b<String, d.y>
  {
    public static final s BAa;
    
    static
    {
      AppMethodBeat.i(82881);
      BAa = new s();
      AppMethodBeat.o(82881);
    }
    
    s()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class t
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    t(c paramc, String paramString, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/webcompt/WebComponent$getA8Key$2$1$1", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "", "onUrlRedirect", "webview-sdk_release", "com/tencent/mm/plugin/webview/webcompt/WebComponent$$special$$inlined$apply$lambda$1"})
  public static final class u
    implements com.tencent.mm.plugin.webview.e.a<aoj>
  {
    u(com.tencent.mm.plugin.webview.e.c paramc, d.d.d paramd, c paramc1, String paramString1, String paramString2) {}
    
    public final void A(int paramInt, String paramString1, String paramString2) {}
    
    public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
    {
      AppMethodBeat.i(82885);
      d.g.b.k.h(paramString1, "reqUrl");
      d.g.b.k.h(paramString2, "errMsg");
      paramString1 = this.BAd;
      paramString2 = (Throwable)new c.j(20001, this.BAe, "getA8Key error:" + paramInt2 + ", " + paramInt3 + ", " + paramString2);
      p.a locala = d.p.JfM;
      paramString1.eH(d.p.eF(d.q.n(paramString2)));
      this.BzE.Bys.a(b.Bya);
      AppMethodBeat.o(82885);
    }
    
    public final void be(int paramInt, String paramString)
    {
      AppMethodBeat.i(189467);
      d.g.b.k.h(paramString, "reqUrl");
      AppMethodBeat.o(189467);
    }
    
    public final void bf(int paramInt, String paramString)
    {
      AppMethodBeat.i(189466);
      d.g.b.k.h(paramString, "reqUrl");
      AppMethodBeat.o(189466);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"readText", "Lkotlin/Pair;", "", "T", "type", "errCode", "", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "debugType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "invoke", "(Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;)Lkotlin/Pair;"})
  static final class v
    extends d.g.b.l
    implements s<T, String, Integer, c.b.c, c.b.a, o<? extends String, ? extends String>>
  {
    v(c paramc, biv parambiv)
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
      //   25: getstatic 86	com/tencent/mm/plugin/webview/k/c:ByF	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   28: astore 6
      //   30: invokestatic 92	com/tencent/mm/plugin/webview/k/c$b:erK	()Ljava/lang/String;
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
      //   58: invokestatic 117	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   83: invokestatic 130	com/tencent/mm/vfs/f:ag	(Lcom/tencent/mm/vfs/e;)Ljava/lang/String;
      //   86: invokespecial 133	d/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   89: astore 6
      //   91: aload_0
      //   92: getfield 39	com/tencent/mm/plugin/webview/k/c$v:BzE	Lcom/tencent/mm/plugin/webview/k/c;
      //   95: getfield 137	com/tencent/mm/plugin/webview/k/c:Bys	Lcom/tencent/mm/plugin/webview/k/j;
      //   98: getstatic 143	com/tencent/mm/plugin/webview/k/b:Byc	Lcom/tencent/mm/plugin/webview/k/b;
      //   101: invokevirtual 148	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   104: getstatic 86	com/tencent/mm/plugin/webview/k/c:ByF	Lcom/tencent/mm/plugin/webview/k/c$b;
      //   107: astore 7
      //   109: invokestatic 152	com/tencent/mm/plugin/webview/k/c$b:erO	()Lcom/tencent/mm/plugin/webview/k/c$b$b;
      //   112: getfield 158	com/tencent/mm/plugin/webview/k/c$b$b:ByP	Ljava/util/LinkedList;
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
      //   142: invokestatic 174	com/tencent/mm/plugin/webview/k/c:erz	()Ljava/lang/String;
      //   145: ldc 175
      //   147: invokestatic 181	d/n/n:bb	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
      //   219: getfield 39	com/tencent/mm/plugin/webview/k/c$v:BzE	Lcom/tencent/mm/plugin/webview/k/c;
      //   222: getfield 137	com/tencent/mm/plugin/webview/k/c:Bys	Lcom/tencent/mm/plugin/webview/k/j;
      //   225: getstatic 213	com/tencent/mm/plugin/webview/k/b:BxE	Lcom/tencent/mm/plugin/webview/k/b;
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
      //   260: getfield 39	com/tencent/mm/plugin/webview/k/c$v:BzE	Lcom/tencent/mm/plugin/webview/k/c;
      //   263: getfield 137	com/tencent/mm/plugin/webview/k/c:Bys	Lcom/tencent/mm/plugin/webview/k/j;
      //   266: getstatic 216	com/tencent/mm/plugin/webview/k/b:BxF	Lcom/tencent/mm/plugin/webview/k/b;
      //   269: invokevirtual 148	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   272: aload_0
      //   273: getfield 39	com/tencent/mm/plugin/webview/k/c$v:BzE	Lcom/tencent/mm/plugin/webview/k/c;
      //   276: getfield 137	com/tencent/mm/plugin/webview/k/c:Bys	Lcom/tencent/mm/plugin/webview/k/j;
      //   279: getstatic 219	com/tencent/mm/plugin/webview/k/b:Byd	Lcom/tencent/mm/plugin/webview/k/b;
      //   282: invokevirtual 148	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   285: aload_0
      //   286: getfield 39	com/tencent/mm/plugin/webview/k/c$v:BzE	Lcom/tencent/mm/plugin/webview/k/c;
      //   289: getfield 137	com/tencent/mm/plugin/webview/k/c:Bys	Lcom/tencent/mm/plugin/webview/k/j;
      //   292: getstatic 222	com/tencent/mm/plugin/webview/k/b:BxH	Lcom/tencent/mm/plugin/webview/k/b;
      //   295: invokevirtual 148	com/tencent/mm/plugin/webview/k/j:a	(Lcom/tencent/mm/plugin/webview/k/b;)V
      //   298: aload_0
      //   299: getfield 41	com/tencent/mm/plugin/webview/k/c$v:BzJ	Lcom/tencent/mm/protocal/protobuf/biv;
      //   302: getfield 228	com/tencent/mm/protocal/protobuf/biv:name	Ljava/lang/String;
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"buildMatrix", "", "", "matrix", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.b<List<? extends Integer>, List<? extends String>>
  {
    public static final w BAf;
    
    static
    {
      AppMethodBeat.i(82892);
      BAf = new w();
      AppMethodBeat.o(82892);
    }
    
    w()
    {
      super();
    }
    
    public static List<String> gA(List<Integer> paramList)
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
        paramList.add(d.a.e.a(arrayOfByte, (CharSequence)"", (d.g.a.b)a.BAg));
      }
      paramList = (List)paramList;
      AppMethodBeat.o(82891);
      return paramList;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<Byte, String>
    {
      public static final a BAg;
      
      static
      {
        AppMethodBeat.i(82889);
        BAg = new a();
        AppMethodBeat.o(82889);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.b<String, d.y>
  {
    x(c paramc, com.tencent.mm.pluginsdk.q paramq)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$refreshA8Key$2$1"})
  static final class y
    extends d.d.b.a.j
    implements d.g.a.m<kotlinx.coroutines.ad, d.d.d<? super d.y>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    
    y(c.l.a parama, d.d.d paramd, c paramc, d.g.a.b paramb1, d.g.a.b paramb2)
    {
      super();
    }
    
    public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(82895);
      d.g.b.k.h(paramd, "completion");
      paramd = new y(this.BAh, paramd, this.BzE, this.BAi, this.BAj);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(82895);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(82894);
      d.d.a.a locala = d.d.a.a.JgJ;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(82894);
        throw paramObject;
      case 0: 
        paramObject = this.mTa;
      }
      try
      {
        c localc = this.BzE;
        String str = this.BAh.Bzv;
        this.mTb = paramObject;
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
          this.BAj.aA(paramObject);
        }
      }
      paramObject = (c.a)paramObject;
      this.BAi.aA(c.a(this.BzE, paramObject));
      paramObject = d.y.JfV;
      AppMethodBeat.o(82894);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(82896);
      paramObject1 = ((y)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
      AppMethodBeat.o(82896);
      return paramObject1;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "invoke"})
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