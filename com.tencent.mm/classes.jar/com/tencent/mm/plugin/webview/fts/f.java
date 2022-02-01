package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.protocal.protobuf.dzr;
import com.tencent.mm.protocal.protobuf.eou;
import com.tencent.mm.protocal.protobuf.fau;
import com.tencent.mm.protocal.protobuf.fav;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
  extends a
  implements m
{
  private fav IDA;
  private int IDE;
  private v IDt;
  private fau IDz;
  private i callback;
  private d iUB;
  private int scene;
  
  /* Error */
  public f(v paramv)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: aload_0
    //   4: invokespecial 28	com/tencent/mm/plugin/websearch/api/a:<init>	()V
    //   7: ldc 29
    //   9: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: aload_1
    //   14: putfield 37	com/tencent/mm/plugin/webview/fts/f:IDt	Lcom/tencent/mm/plugin/websearch/api/v;
    //   17: aload_0
    //   18: aload_1
    //   19: getfield 43	com/tencent/mm/plugin/websearch/api/v:dDv	Ljava/lang/String;
    //   22: putfield 46	com/tencent/mm/plugin/webview/fts/f:xsj	Ljava/lang/String;
    //   25: aload_0
    //   26: aload_1
    //   27: getfield 49	com/tencent/mm/plugin/websearch/api/v:dPI	Ljava/lang/String;
    //   30: putfield 52	com/tencent/mm/plugin/webview/fts/f:dVP	Ljava/lang/String;
    //   33: aload_0
    //   34: aload_1
    //   35: getfield 55	com/tencent/mm/plugin/websearch/api/v:offset	I
    //   38: putfield 58	com/tencent/mm/plugin/webview/fts/f:fs	I
    //   41: aload_0
    //   42: aload_1
    //   43: getfield 60	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   46: putfield 63	com/tencent/mm/plugin/webview/fts/f:mScene	I
    //   49: aload_0
    //   50: aload_1
    //   51: getfield 66	com/tencent/mm/plugin/websearch/api/v:dVL	I
    //   54: putfield 69	com/tencent/mm/plugin/webview/fts/f:IDq	I
    //   57: aload_0
    //   58: aload_1
    //   59: getfield 71	com/tencent/mm/plugin/websearch/api/v:IDE	I
    //   62: putfield 72	com/tencent/mm/plugin/webview/fts/f:IDE	I
    //   65: aload_0
    //   66: aload_1
    //   67: putfield 37	com/tencent/mm/plugin/webview/fts/f:IDt	Lcom/tencent/mm/plugin/websearch/api/v;
    //   70: aload_0
    //   71: aload_1
    //   72: getfield 76	com/tencent/mm/plugin/websearch/api/v:CAJ	Landroid/os/Bundle;
    //   75: putfield 79	com/tencent/mm/plugin/webview/fts/f:IDr	Landroid/os/Bundle;
    //   78: aload_1
    //   79: getfield 43	com/tencent/mm/plugin/websearch/api/v:dDv	Ljava/lang/String;
    //   82: invokestatic 85	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   85: ifne +1669 -> 1754
    //   88: ldc 87
    //   90: ldc 89
    //   92: iconst_1
    //   93: anewarray 91	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_1
    //   99: getfield 43	com/tencent/mm/plugin/websearch/api/v:dDv	Ljava/lang/String;
    //   102: aastore
    //   103: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: aload_1
    //   108: getfield 60	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   111: putfield 97	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   114: new 99	com/tencent/mm/ak/d$a
    //   117: dup
    //   118: invokespecial 100	com/tencent/mm/ak/d$a:<init>	()V
    //   121: astore 9
    //   123: aload_1
    //   124: getfield 60	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   127: sipush 201
    //   130: if_icmpeq +11 -> 141
    //   133: aload_1
    //   134: getfield 103	com/tencent/mm/plugin/websearch/api/v:IDQ	I
    //   137: iconst_1
    //   138: if_icmpne +1417 -> 1555
    //   141: iconst_1
    //   142: istore 4
    //   144: iload 4
    //   146: ifeq +1415 -> 1561
    //   149: aload 9
    //   151: sipush 2676
    //   154: putfield 106	com/tencent/mm/ak/d$a:funcId	I
    //   157: ldc 108
    //   159: astore 8
    //   161: aload 9
    //   163: aload 8
    //   165: putfield 111	com/tencent/mm/ak/d$a:uri	Ljava/lang/String;
    //   168: ldc 87
    //   170: ldc 113
    //   172: iconst_1
    //   173: anewarray 91	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload 8
    //   180: aastore
    //   181: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload 9
    //   186: new 115	com/tencent/mm/protocal/protobuf/fau
    //   189: dup
    //   190: invokespecial 116	com/tencent/mm/protocal/protobuf/fau:<init>	()V
    //   193: putfield 120	com/tencent/mm/ak/d$a:iLN	Lcom/tencent/mm/bw/a;
    //   196: aload 9
    //   198: new 122	com/tencent/mm/protocal/protobuf/fav
    //   201: dup
    //   202: invokespecial 123	com/tencent/mm/protocal/protobuf/fav:<init>	()V
    //   205: putfield 126	com/tencent/mm/ak/d$a:iLO	Lcom/tencent/mm/bw/a;
    //   208: aload_0
    //   209: aload 9
    //   211: invokevirtual 130	com/tencent/mm/ak/d$a:aXF	()Lcom/tencent/mm/ak/d;
    //   214: putfield 132	com/tencent/mm/plugin/webview/fts/f:iUB	Lcom/tencent/mm/ak/d;
    //   217: aload_0
    //   218: aload_0
    //   219: getfield 132	com/tencent/mm/plugin/webview/fts/f:iUB	Lcom/tencent/mm/ak/d;
    //   222: getfield 138	com/tencent/mm/ak/d:iLK	Lcom/tencent/mm/ak/d$b;
    //   225: getfield 143	com/tencent/mm/ak/d$b:iLR	Lcom/tencent/mm/bw/a;
    //   228: checkcast 115	com/tencent/mm/protocal/protobuf/fau
    //   231: putfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   234: aload_0
    //   235: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   238: aload_1
    //   239: getfield 43	com/tencent/mm/plugin/websearch/api/v:dDv	Ljava/lang/String;
    //   242: putfield 148	com/tencent/mm/protocal/protobuf/fau:LPT	Ljava/lang/String;
    //   245: aload_0
    //   246: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   249: aload_1
    //   250: getfield 71	com/tencent/mm/plugin/websearch/api/v:IDE	I
    //   253: putfield 151	com/tencent/mm/protocal/protobuf/fau:MRb	I
    //   256: aload_0
    //   257: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   260: aload_1
    //   261: getfield 154	com/tencent/mm/plugin/websearch/api/v:businessType	I
    //   264: i2l
    //   265: putfield 158	com/tencent/mm/protocal/protobuf/fau:KZg	J
    //   268: aload_0
    //   269: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   272: invokestatic 164	com/tencent/mm/plugin/websearch/api/ai:clJ	()Lcom/tencent/mm/protocal/protobuf/chl;
    //   275: putfield 168	com/tencent/mm/protocal/protobuf/fau:MlQ	Lcom/tencent/mm/protocal/protobuf/chl;
    //   278: aload_0
    //   279: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   282: aload_1
    //   283: getfield 55	com/tencent/mm/plugin/websearch/api/v:offset	I
    //   286: putfield 171	com/tencent/mm/protocal/protobuf/fau:KZk	I
    //   289: aload_0
    //   290: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   293: iconst_0
    //   294: invokestatic 175	com/tencent/mm/plugin/websearch/api/ai:aft	(I)I
    //   297: putfield 178	com/tencent/mm/protocal/protobuf/fau:NwV	I
    //   300: aload_0
    //   301: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   304: aload_1
    //   305: getfield 182	com/tencent/mm/plugin/websearch/api/v:IDF	Ljava/util/LinkedList;
    //   308: putfield 185	com/tencent/mm/protocal/protobuf/fau:MUs	Ljava/util/LinkedList;
    //   311: aload_0
    //   312: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   315: aload_1
    //   316: getfield 60	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   319: putfield 188	com/tencent/mm/protocal/protobuf/fau:Scene	I
    //   322: aload_0
    //   323: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   326: aload_1
    //   327: getfield 191	com/tencent/mm/plugin/websearch/api/v:rjq	Ljava/lang/String;
    //   330: putfield 194	com/tencent/mm/protocal/protobuf/fau:KZj	Ljava/lang/String;
    //   333: aload_0
    //   334: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   337: aload_1
    //   338: getfield 197	com/tencent/mm/plugin/websearch/api/v:dVS	I
    //   341: putfield 200	com/tencent/mm/protocal/protobuf/fau:MRf	I
    //   344: aload_0
    //   345: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   348: aload_1
    //   349: getfield 203	com/tencent/mm/plugin/websearch/api/v:IDG	Ljava/lang/String;
    //   352: putfield 206	com/tencent/mm/protocal/protobuf/fau:NwW	Ljava/lang/String;
    //   355: aload_0
    //   356: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   359: aload_1
    //   360: getfield 209	com/tencent/mm/plugin/websearch/api/v:IDI	I
    //   363: putfield 212	com/tencent/mm/protocal/protobuf/fau:NwY	I
    //   366: aload_0
    //   367: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   370: aload_1
    //   371: getfield 215	com/tencent/mm/plugin/websearch/api/v:IDH	Ljava/lang/String;
    //   374: putfield 218	com/tencent/mm/protocal/protobuf/fau:NwX	Ljava/lang/String;
    //   377: aload_0
    //   378: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   381: aload_1
    //   382: getfield 221	com/tencent/mm/plugin/websearch/api/v:IDJ	Ljava/util/LinkedList;
    //   385: putfield 224	com/tencent/mm/protocal/protobuf/fau:NwZ	Ljava/util/LinkedList;
    //   388: aload_0
    //   389: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   392: aload_1
    //   393: getfield 227	com/tencent/mm/plugin/websearch/api/v:IDO	Ljava/util/LinkedList;
    //   396: putfield 230	com/tencent/mm/protocal/protobuf/fau:Nva	Ljava/util/LinkedList;
    //   399: aload_0
    //   400: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   403: getfield 230	com/tencent/mm/protocal/protobuf/fau:Nva	Ljava/util/LinkedList;
    //   406: astore 9
    //   408: aload 9
    //   410: invokestatic 233	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   413: ifne +150 -> 563
    //   416: aload 9
    //   418: invokevirtual 239	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   421: astore 8
    //   423: aload 8
    //   425: invokeinterface 245 1 0
    //   430: ifeq +1348 -> 1778
    //   433: aload 8
    //   435: invokeinterface 249 1 0
    //   440: checkcast 251	com/tencent/mm/protocal/protobuf/aca
    //   443: astore 10
    //   445: aload 10
    //   447: ifnull -24 -> 423
    //   450: ldc 253
    //   452: aload 10
    //   454: getfield 256	com/tencent/mm/protocal/protobuf/aca:key	Ljava/lang/String;
    //   457: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   460: ifeq -37 -> 423
    //   463: aload 10
    //   465: getfield 265	com/tencent/mm/protocal/protobuf/aca:LmD	Ljava/lang/String;
    //   468: astore 8
    //   470: ldc 87
    //   472: ldc_w 267
    //   475: iconst_1
    //   476: anewarray 91	java/lang/Object
    //   479: dup
    //   480: iconst_0
    //   481: aload 8
    //   483: aastore
    //   484: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   487: aload 8
    //   489: invokestatic 85	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   492: ifne +71 -> 563
    //   495: invokestatic 273	com/tencent/mm/model/ad:aVe	()Lcom/tencent/mm/model/ad;
    //   498: aload 8
    //   500: invokevirtual 277	com/tencent/mm/model/ad:JW	(Ljava/lang/String;)Lcom/tencent/mm/model/ad$b;
    //   503: astore 8
    //   505: aload 8
    //   507: ifnull +56 -> 563
    //   510: aload 8
    //   512: ldc_w 279
    //   515: ldc_w 281
    //   518: invokevirtual 287	com/tencent/mm/model/ad$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   521: astore 8
    //   523: aload 8
    //   525: invokestatic 85	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   528: ifne +35 -> 563
    //   531: new 251	com/tencent/mm/protocal/protobuf/aca
    //   534: dup
    //   535: invokespecial 288	com/tencent/mm/protocal/protobuf/aca:<init>	()V
    //   538: astore 10
    //   540: aload 10
    //   542: ldc_w 279
    //   545: putfield 256	com/tencent/mm/protocal/protobuf/aca:key	Ljava/lang/String;
    //   548: aload 10
    //   550: aload 8
    //   552: putfield 265	com/tencent/mm/protocal/protobuf/aca:LmD	Ljava/lang/String;
    //   555: aload 9
    //   557: aload 10
    //   559: invokevirtual 291	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   562: pop
    //   563: aload_0
    //   564: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   567: aload_1
    //   568: getfield 295	com/tencent/mm/plugin/websearch/api/v:IDN	Lcom/tencent/mm/protocal/protobuf/egk;
    //   571: putfield 296	com/tencent/mm/protocal/protobuf/fau:IDN	Lcom/tencent/mm/protocal/protobuf/egk;
    //   574: aload_0
    //   575: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   578: aload_1
    //   579: getfield 299	com/tencent/mm/plugin/websearch/api/v:IDP	Ljava/util/LinkedList;
    //   582: putfield 302	com/tencent/mm/protocal/protobuf/fau:Nxa	Ljava/util/LinkedList;
    //   585: aload_0
    //   586: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   589: aload_1
    //   590: getfield 305	com/tencent/mm/plugin/websearch/api/v:language	Ljava/lang/String;
    //   593: putfield 308	com/tencent/mm/protocal/protobuf/fau:rBI	Ljava/lang/String;
    //   596: aload_0
    //   597: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   600: aload_1
    //   601: getfield 311	com/tencent/mm/plugin/websearch/api/v:sessionId	Ljava/lang/String;
    //   604: putfield 314	com/tencent/mm/protocal/protobuf/fau:NwH	Ljava/lang/String;
    //   607: aload_0
    //   608: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   611: astore 8
    //   613: invokestatic 319	com/tencent/mm/ui/ao:isDarkMode	()Z
    //   616: ifeq +1008 -> 1624
    //   619: iconst_1
    //   620: istore 4
    //   622: aload 8
    //   624: iload 4
    //   626: putfield 322	com/tencent/mm/protocal/protobuf/fau:MEt	I
    //   629: aload_0
    //   630: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   633: invokestatic 326	com/tencent/mm/plugin/websearch/api/ai:fYd	()Lcom/tencent/mm/protocal/protobuf/aah;
    //   636: putfield 330	com/tencent/mm/protocal/protobuf/fau:MlR	Lcom/tencent/mm/protocal/protobuf/aah;
    //   639: aload_0
    //   640: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   643: astore 9
    //   645: aload_0
    //   646: getfield 97	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   649: bipush 79
    //   651: if_icmpeq +12 -> 663
    //   654: aload_0
    //   655: getfield 97	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   658: bipush 80
    //   660: if_icmpne +1016 -> 1676
    //   663: new 332	com/tencent/mm/protocal/protobuf/egh
    //   666: dup
    //   667: invokespecial 333	com/tencent/mm/protocal/protobuf/egh:<init>	()V
    //   670: astore 8
    //   672: aload 8
    //   674: iconst_1
    //   675: putfield 336	com/tencent/mm/protocal/protobuf/egh:xub	I
    //   678: aload_1
    //   679: getfield 339	com/tencent/mm/plugin/websearch/api/v:IEb	Ljava/lang/String;
    //   682: astore 10
    //   684: aload 10
    //   686: invokestatic 345	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   689: ifne +987 -> 1676
    //   692: aload 10
    //   694: ldc_w 347
    //   697: invokevirtual 351	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   700: astore 10
    //   702: aload_0
    //   703: getfield 97	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   706: bipush 79
    //   708: if_icmpne +922 -> 1630
    //   711: aload 10
    //   713: arraylength
    //   714: iconst_2
    //   715: if_icmplt +21 -> 736
    //   718: aload 8
    //   720: aload 10
    //   722: iconst_0
    //   723: aaload
    //   724: putfield 354	com/tencent/mm/protocal/protobuf/egh:Ngm	Ljava/lang/String;
    //   727: aload 8
    //   729: aload 10
    //   731: iconst_1
    //   732: aaload
    //   733: putfield 357	com/tencent/mm/protocal/protobuf/egh:Ngp	Ljava/lang/String;
    //   736: aload 8
    //   738: aload_1
    //   739: getfield 360	com/tencent/mm/plugin/websearch/api/v:IEc	I
    //   742: putfield 363	com/tencent/mm/protocal/protobuf/egh:Ngo	I
    //   745: aload 9
    //   747: aload 8
    //   749: putfield 367	com/tencent/mm/protocal/protobuf/fau:Nxg	Lcom/tencent/mm/protocal/protobuf/egh;
    //   752: aload_1
    //   753: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   756: ifnonnull +14 -> 770
    //   759: aload_1
    //   760: new 373	com/tencent/mm/protocal/protobuf/fap
    //   763: dup
    //   764: invokespecial 374	com/tencent/mm/protocal/protobuf/fap:<init>	()V
    //   767: putfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   770: aload_1
    //   771: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   774: getfield 378	com/tencent/mm/protocal/protobuf/fap:NwR	Lcom/tencent/mm/protocal/protobuf/qu;
    //   777: ifnonnull +17 -> 794
    //   780: aload_1
    //   781: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   784: new 380	com/tencent/mm/protocal/protobuf/qu
    //   787: dup
    //   788: invokespecial 381	com/tencent/mm/protocal/protobuf/qu:<init>	()V
    //   791: putfield 378	com/tencent/mm/protocal/protobuf/fap:NwR	Lcom/tencent/mm/protocal/protobuf/qu;
    //   794: aload_1
    //   795: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   798: getfield 378	com/tencent/mm/protocal/protobuf/fap:NwR	Lcom/tencent/mm/protocal/protobuf/qu;
    //   801: astore 8
    //   803: invokestatic 387	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   806: invokevirtual 393	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   809: invokevirtual 399	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   812: getfield 404	android/util/DisplayMetrics:widthPixels	I
    //   815: istore 4
    //   817: invokestatic 409	org/xwalk/core/XWalkEnvironment:getUsingCustomContext	()Z
    //   820: ifeq +862 -> 1682
    //   823: iload 4
    //   825: i2f
    //   826: invokestatic 387	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   829: invokestatic 415	com/tencent/mm/cb/a:getDensity	(Landroid/content/Context;)F
    //   832: fdiv
    //   833: invokestatic 421	java/lang/Math:round	(F)I
    //   836: istore 4
    //   838: aload 8
    //   840: iload 4
    //   842: putfield 424	com/tencent/mm/protocal/protobuf/qu:Doa	I
    //   845: ldc 87
    //   847: ldc_w 426
    //   850: iconst_3
    //   851: anewarray 91	java/lang/Object
    //   854: dup
    //   855: iconst_0
    //   856: invokestatic 387	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   859: invokevirtual 393	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   862: invokevirtual 399	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   865: getfield 404	android/util/DisplayMetrics:widthPixels	I
    //   868: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   871: aastore
    //   872: dup
    //   873: iconst_1
    //   874: aload_1
    //   875: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   878: getfield 378	com/tencent/mm/protocal/protobuf/fap:NwR	Lcom/tencent/mm/protocal/protobuf/qu;
    //   881: getfield 424	com/tencent/mm/protocal/protobuf/qu:Doa	I
    //   884: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   887: aastore
    //   888: dup
    //   889: iconst_2
    //   890: invokestatic 387	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   893: invokevirtual 393	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   896: invokevirtual 399	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   899: getfield 436	android/util/DisplayMetrics:density	F
    //   902: invokestatic 441	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   905: aastore
    //   906: invokestatic 444	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   909: fconst_0
    //   910: fstore_3
    //   911: fconst_0
    //   912: fstore_2
    //   913: aload_0
    //   914: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   917: getfield 168	com/tencent/mm/protocal/protobuf/fau:MlQ	Lcom/tencent/mm/protocal/protobuf/chl;
    //   920: ifnull +789 -> 1709
    //   923: aload_1
    //   924: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   927: getfield 378	com/tencent/mm/protocal/protobuf/fap:NwR	Lcom/tencent/mm/protocal/protobuf/qu;
    //   930: astore 8
    //   932: invokestatic 450	com/tencent/mm/modelgeo/d:bca	()Lcom/tencent/mm/modelgeo/d;
    //   935: astore 9
    //   937: aload 9
    //   939: getfield 453	com/tencent/mm/modelgeo/d:iVn	J
    //   942: lconst_0
    //   943: lcmp
    //   944: ifle +753 -> 1697
    //   947: aload 9
    //   949: getfield 457	com/tencent/mm/modelgeo/d:iVp	Z
    //   952: ifeq +745 -> 1697
    //   955: invokestatic 463	java/lang/System:currentTimeMillis	()J
    //   958: aload 9
    //   960: getfield 453	com/tencent/mm/modelgeo/d:iVn	J
    //   963: lsub
    //   964: ldc2_w 464
    //   967: lcmp
    //   968: ifge +729 -> 1697
    //   971: iconst_1
    //   972: istore 4
    //   974: iload 4
    //   976: ifeq +727 -> 1703
    //   979: iconst_0
    //   980: istore 4
    //   982: aload 8
    //   984: iload 4
    //   986: putfield 468	com/tencent/mm/protocal/protobuf/qu:KXI	I
    //   989: aload_0
    //   990: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   993: getfield 168	com/tencent/mm/protocal/protobuf/fau:MlQ	Lcom/tencent/mm/protocal/protobuf/chl;
    //   996: getfield 473	com/tencent/mm/protocal/protobuf/chl:LbC	F
    //   999: fstore_3
    //   1000: aload_0
    //   1001: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   1004: getfield 168	com/tencent/mm/protocal/protobuf/fau:MlQ	Lcom/tencent/mm/protocal/protobuf/chl;
    //   1007: getfield 476	com/tencent/mm/protocal/protobuf/chl:LbD	F
    //   1010: fstore_2
    //   1011: ldc 87
    //   1013: ldc_w 478
    //   1016: iconst_3
    //   1017: anewarray 91	java/lang/Object
    //   1020: dup
    //   1021: iconst_0
    //   1022: fload_3
    //   1023: invokestatic 441	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1026: aastore
    //   1027: dup
    //   1028: iconst_1
    //   1029: fload_2
    //   1030: invokestatic 441	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1033: aastore
    //   1034: dup
    //   1035: iconst_2
    //   1036: aload_1
    //   1037: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   1040: getfield 378	com/tencent/mm/protocal/protobuf/fap:NwR	Lcom/tencent/mm/protocal/protobuf/qu;
    //   1043: getfield 468	com/tencent/mm/protocal/protobuf/qu:KXI	I
    //   1046: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1049: aastore
    //   1050: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1053: aload_1
    //   1054: getfield 481	com/tencent/mm/plugin/websearch/api/v:IDT	Ljava/lang/String;
    //   1057: invokestatic 345	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1060: ifne +148 -> 1208
    //   1063: aload_1
    //   1064: getfield 481	com/tencent/mm/plugin/websearch/api/v:IDT	Ljava/lang/String;
    //   1067: invokestatic 487	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   1070: astore 8
    //   1072: new 489	org/json/JSONObject
    //   1075: dup
    //   1076: aload 8
    //   1078: invokespecial 492	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1081: astore 8
    //   1083: new 494	com/tencent/mm/protocal/protobuf/dci
    //   1086: dup
    //   1087: invokespecial 495	com/tencent/mm/protocal/protobuf/dci:<init>	()V
    //   1090: astore 9
    //   1092: aload 9
    //   1094: aload 8
    //   1096: ldc_w 497
    //   1099: invokevirtual 500	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1102: putfield 503	com/tencent/mm/protocal/protobuf/dci:kea	Ljava/lang/String;
    //   1105: aload 9
    //   1107: aload 8
    //   1109: ldc_w 505
    //   1112: invokevirtual 500	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1115: putfield 508	com/tencent/mm/protocal/protobuf/dci:keh	Ljava/lang/String;
    //   1118: aload 9
    //   1120: aload 8
    //   1122: ldc_w 510
    //   1125: invokevirtual 514	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   1128: d2f
    //   1129: putfield 515	com/tencent/mm/protocal/protobuf/dci:LbD	F
    //   1132: aload 9
    //   1134: aload 8
    //   1136: ldc_w 517
    //   1139: invokevirtual 514	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   1142: d2f
    //   1143: putfield 518	com/tencent/mm/protocal/protobuf/dci:LbC	F
    //   1146: aload 9
    //   1148: aload 8
    //   1150: ldc_w 520
    //   1153: invokevirtual 500	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1156: putfield 523	com/tencent/mm/protocal/protobuf/dci:MHg	Ljava/lang/String;
    //   1159: aload 9
    //   1161: aload 8
    //   1163: ldc_w 525
    //   1166: invokevirtual 500	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1169: putfield 528	com/tencent/mm/protocal/protobuf/dci:Mil	Ljava/lang/String;
    //   1172: aload 9
    //   1174: aload 8
    //   1176: ldc_w 530
    //   1179: invokevirtual 500	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1182: invokestatic 534	com/tencent/mm/plugin/websearch/api/ai:aXb	(Ljava/lang/String;)J
    //   1185: putfield 537	com/tencent/mm/protocal/protobuf/dci:MHi	J
    //   1188: aload 9
    //   1190: getfield 523	com/tencent/mm/protocal/protobuf/dci:MHg	Ljava/lang/String;
    //   1193: invokestatic 345	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1196: ifne +12 -> 1208
    //   1199: aload_0
    //   1200: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   1203: aload 9
    //   1205: putfield 541	com/tencent/mm/protocal/protobuf/fau:Nxf	Lcom/tencent/mm/protocal/protobuf/dci;
    //   1208: aload_1
    //   1209: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   1212: ifnull +96 -> 1308
    //   1215: aload_1
    //   1216: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   1219: ldc_w 543
    //   1222: invokestatic 549	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1225: checkcast 543	com/tencent/mm/plugin/appbrand/service/j
    //   1228: invokeinterface 553 1 0
    //   1233: putfield 556	com/tencent/mm/protocal/protobuf/fap:NwS	I
    //   1236: aload_0
    //   1237: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   1240: new 558	com/tencent/mm/bw/b
    //   1243: dup
    //   1244: aload_1
    //   1245: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   1248: invokevirtual 562	com/tencent/mm/protocal/protobuf/fap:toByteArray	()[B
    //   1251: invokespecial 565	com/tencent/mm/bw/b:<init>	([B)V
    //   1254: putfield 569	com/tencent/mm/protocal/protobuf/fau:Nxc	Lcom/tencent/mm/bw/b;
    //   1257: ldc 87
    //   1259: ldc_w 571
    //   1262: iconst_3
    //   1263: anewarray 91	java/lang/Object
    //   1266: dup
    //   1267: iconst_0
    //   1268: aload_1
    //   1269: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   1272: getfield 574	com/tencent/mm/protocal/protobuf/fap:NwQ	J
    //   1275: invokestatic 579	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1278: aastore
    //   1279: dup
    //   1280: iconst_1
    //   1281: aload_1
    //   1282: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   1285: getfield 378	com/tencent/mm/protocal/protobuf/fap:NwR	Lcom/tencent/mm/protocal/protobuf/qu;
    //   1288: getfield 582	com/tencent/mm/protocal/protobuf/qu:dNI	Ljava/lang/String;
    //   1291: aastore
    //   1292: dup
    //   1293: iconst_2
    //   1294: aload_1
    //   1295: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   1298: getfield 378	com/tencent/mm/protocal/protobuf/fap:NwR	Lcom/tencent/mm/protocal/protobuf/qu;
    //   1301: getfield 585	com/tencent/mm/protocal/protobuf/qu:qHp	Ljava/lang/String;
    //   1304: aastore
    //   1305: invokestatic 444	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1308: aload_1
    //   1309: getfield 589	com/tencent/mm/plugin/websearch/api/v:IDR	Lcom/tencent/mm/protocal/protobuf/fel;
    //   1312: ifnull +24 -> 1336
    //   1315: aload_0
    //   1316: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   1319: new 558	com/tencent/mm/bw/b
    //   1322: dup
    //   1323: aload_1
    //   1324: getfield 589	com/tencent/mm/plugin/websearch/api/v:IDR	Lcom/tencent/mm/protocal/protobuf/fel;
    //   1327: invokevirtual 592	com/tencent/mm/protocal/protobuf/fel:toByteArray	()[B
    //   1330: invokespecial 565	com/tencent/mm/bw/b:<init>	([B)V
    //   1333: putfield 595	com/tencent/mm/protocal/protobuf/fau:Nxb	Lcom/tencent/mm/bw/b;
    //   1336: aload_0
    //   1337: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   1340: getfield 168	com/tencent/mm/protocal/protobuf/fau:MlQ	Lcom/tencent/mm/protocal/protobuf/chl;
    //   1343: ifnull +399 -> 1742
    //   1346: iconst_1
    //   1347: istore 6
    //   1349: ldc 87
    //   1351: ldc_w 597
    //   1354: bipush 7
    //   1356: anewarray 91	java/lang/Object
    //   1359: dup
    //   1360: iconst_0
    //   1361: iload 6
    //   1363: invokestatic 602	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1366: aastore
    //   1367: dup
    //   1368: iconst_1
    //   1369: aload_1
    //   1370: getfield 182	com/tencent/mm/plugin/websearch/api/v:IDF	Ljava/util/LinkedList;
    //   1373: invokevirtual 605	java/util/LinkedList:size	()I
    //   1376: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1379: aastore
    //   1380: dup
    //   1381: iconst_2
    //   1382: aload_1
    //   1383: getfield 60	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   1386: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1389: aastore
    //   1390: dup
    //   1391: iconst_3
    //   1392: aload_1
    //   1393: getfield 154	com/tencent/mm/plugin/websearch/api/v:businessType	I
    //   1396: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1399: aastore
    //   1400: dup
    //   1401: iconst_4
    //   1402: aload_0
    //   1403: getfield 72	com/tencent/mm/plugin/webview/fts/f:IDE	I
    //   1406: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1409: aastore
    //   1410: dup
    //   1411: iconst_5
    //   1412: aload_1
    //   1413: getfield 197	com/tencent/mm/plugin/websearch/api/v:dVS	I
    //   1416: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1419: aastore
    //   1420: dup
    //   1421: bipush 6
    //   1423: aload_1
    //   1424: getfield 66	com/tencent/mm/plugin/websearch/api/v:dVL	I
    //   1427: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1430: aastore
    //   1431: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1434: aload_0
    //   1435: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   1438: getfield 168	com/tencent/mm/protocal/protobuf/fau:MlQ	Lcom/tencent/mm/protocal/protobuf/chl;
    //   1441: ifnull +39 -> 1480
    //   1444: sipush 2005
    //   1447: aload_0
    //   1448: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   1451: getfield 168	com/tencent/mm/protocal/protobuf/fau:MlQ	Lcom/tencent/mm/protocal/protobuf/chl;
    //   1454: getfield 473	com/tencent/mm/protocal/protobuf/chl:LbC	F
    //   1457: aload_0
    //   1458: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   1461: getfield 168	com/tencent/mm/protocal/protobuf/fau:MlQ	Lcom/tencent/mm/protocal/protobuf/chl;
    //   1464: getfield 476	com/tencent/mm/protocal/protobuf/chl:LbD	F
    //   1467: aload_0
    //   1468: getfield 145	com/tencent/mm/plugin/webview/fts/f:IDz	Lcom/tencent/mm/protocal/protobuf/fau;
    //   1471: getfield 168	com/tencent/mm/protocal/protobuf/fau:MlQ	Lcom/tencent/mm/protocal/protobuf/chl;
    //   1474: getfield 608	com/tencent/mm/protocal/protobuf/chl:LuT	I
    //   1477: invokestatic 614	com/tencent/mm/modelstat/o:a	(IFFI)V
    //   1480: aload_1
    //   1481: getfield 60	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   1484: istore 4
    //   1486: aload_1
    //   1487: getfield 311	com/tencent/mm/plugin/websearch/api/v:sessionId	Ljava/lang/String;
    //   1490: astore 8
    //   1492: aload_1
    //   1493: getfield 617	com/tencent/mm/plugin/websearch/api/v:dVO	Ljava/lang/String;
    //   1496: astore 9
    //   1498: aload_1
    //   1499: getfield 191	com/tencent/mm/plugin/websearch/api/v:rjq	Ljava/lang/String;
    //   1502: astore 10
    //   1504: aload_1
    //   1505: getfield 55	com/tencent/mm/plugin/websearch/api/v:offset	I
    //   1508: istore 5
    //   1510: aload_1
    //   1511: getfield 71	com/tencent/mm/plugin/websearch/api/v:IDE	I
    //   1514: iconst_1
    //   1515: if_icmpne +233 -> 1748
    //   1518: iload 7
    //   1520: istore 6
    //   1522: iload 4
    //   1524: aload 8
    //   1526: aload 9
    //   1528: aload 10
    //   1530: iload 5
    //   1532: iload 6
    //   1534: aload_1
    //   1535: getfield 49	com/tencent/mm/plugin/websearch/api/v:dPI	Ljava/lang/String;
    //   1538: aload_1
    //   1539: getfield 43	com/tencent/mm/plugin/websearch/api/v:dDv	Ljava/lang/String;
    //   1542: aload_1
    //   1543: getfield 154	com/tencent/mm/plugin/websearch/api/v:businessType	I
    //   1546: invokestatic 622	com/tencent/mm/plugin/websearch/api/ah:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;I)V
    //   1549: ldc 29
    //   1551: invokestatic 625	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1554: return
    //   1555: iconst_0
    //   1556: istore 4
    //   1558: goto -1414 -> 144
    //   1561: aload_1
    //   1562: getfield 628	com/tencent/mm/plugin/websearch/api/v:IDX	I
    //   1565: iconst_1
    //   1566: if_icmpne +19 -> 1585
    //   1569: aload 9
    //   1571: sipush 1011
    //   1574: putfield 106	com/tencent/mm/ak/d$a:funcId	I
    //   1577: ldc_w 630
    //   1580: astore 8
    //   1582: goto -1421 -> 161
    //   1585: aload_1
    //   1586: getfield 633	com/tencent/mm/plugin/websearch/api/v:IDY	Z
    //   1589: ifeq +19 -> 1608
    //   1592: aload 9
    //   1594: sipush 4858
    //   1597: putfield 106	com/tencent/mm/ak/d$a:funcId	I
    //   1600: ldc_w 635
    //   1603: astore 8
    //   1605: goto -1444 -> 161
    //   1608: aload 9
    //   1610: sipush 719
    //   1613: putfield 106	com/tencent/mm/ak/d$a:funcId	I
    //   1616: ldc_w 637
    //   1619: astore 8
    //   1621: goto -1460 -> 161
    //   1624: iconst_0
    //   1625: istore 4
    //   1627: goto -1005 -> 622
    //   1630: aload_0
    //   1631: getfield 97	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   1634: bipush 80
    //   1636: if_icmpne -900 -> 736
    //   1639: aload 10
    //   1641: arraylength
    //   1642: iconst_3
    //   1643: if_icmplt -907 -> 736
    //   1646: aload 8
    //   1648: aload 10
    //   1650: iconst_0
    //   1651: aaload
    //   1652: putfield 354	com/tencent/mm/protocal/protobuf/egh:Ngm	Ljava/lang/String;
    //   1655: aload 8
    //   1657: aload 10
    //   1659: iconst_1
    //   1660: aaload
    //   1661: putfield 357	com/tencent/mm/protocal/protobuf/egh:Ngp	Ljava/lang/String;
    //   1664: aload 8
    //   1666: aload 10
    //   1668: iconst_2
    //   1669: aaload
    //   1670: putfield 640	com/tencent/mm/protocal/protobuf/egh:Ngn	Ljava/lang/String;
    //   1673: goto -937 -> 736
    //   1676: aconst_null
    //   1677: astore 8
    //   1679: goto -934 -> 745
    //   1682: iload 4
    //   1684: i2f
    //   1685: invokestatic 646	com/tencent/mm/cc/a:gvp	()F
    //   1688: fdiv
    //   1689: invokestatic 421	java/lang/Math:round	(F)I
    //   1692: istore 4
    //   1694: goto -856 -> 838
    //   1697: iconst_0
    //   1698: istore 4
    //   1700: goto -726 -> 974
    //   1703: iconst_1
    //   1704: istore 4
    //   1706: goto -724 -> 982
    //   1709: aload_1
    //   1710: getfield 371	com/tencent/mm/plugin/websearch/api/v:IDS	Lcom/tencent/mm/protocal/protobuf/fap;
    //   1713: getfield 378	com/tencent/mm/protocal/protobuf/fap:NwR	Lcom/tencent/mm/protocal/protobuf/qu;
    //   1716: iconst_1
    //   1717: putfield 468	com/tencent/mm/protocal/protobuf/qu:KXI	I
    //   1720: goto -709 -> 1011
    //   1723: astore 8
    //   1725: ldc 87
    //   1727: aload 8
    //   1729: ldc_w 281
    //   1732: iconst_0
    //   1733: anewarray 91	java/lang/Object
    //   1736: invokestatic 650	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1739: goto -531 -> 1208
    //   1742: iconst_0
    //   1743: istore 6
    //   1745: goto -396 -> 1349
    //   1748: iconst_0
    //   1749: istore 6
    //   1751: goto -229 -> 1522
    //   1754: ldc 87
    //   1756: ldc_w 652
    //   1759: invokestatic 656	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1762: ldc 29
    //   1764: invokestatic 625	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1767: return
    //   1768: astore 8
    //   1770: goto -434 -> 1336
    //   1773: astore 8
    //   1775: goto -467 -> 1308
    //   1778: aconst_null
    //   1779: astore 8
    //   1781: goto -1311 -> 470
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1784	0	this	f
    //   0	1784	1	paramv	v
    //   912	118	2	f1	float
    //   910	113	3	f2	float
    //   142	1563	4	i	int
    //   1508	23	5	j	int
    //   1347	403	6	bool1	boolean
    //   1	1518	7	bool2	boolean
    //   159	1519	8	localObject1	Object
    //   1723	5	8	localJSONException	org.json.JSONException
    //   1768	1	8	localException1	java.lang.Exception
    //   1773	1	8	localException2	java.lang.Exception
    //   1779	1	8	localObject2	Object
    //   121	1488	9	localObject3	Object
    //   443	1224	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   1072	1208	1723	org/json/JSONException
    //   1315	1336	1768	java/lang/Exception
    //   1215	1308	1773	java/lang/Exception
  }
  
  public final void by(LinkedList<eou> paramLinkedList)
  {
    AppMethodBeat.i(77933);
    this.IDz.MUs = paramLinkedList;
    dzr localdzr = new dzr();
    localdzr.MZn = paramLinkedList.size();
    this.IDz.Nxd = localdzr;
    AppMethodBeat.o(77933);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(77931);
    ar.kc(this.scene, 2);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(77931);
    return i;
  }
  
  public final String fXC()
  {
    if (this.IDA != null) {
      return this.IDA.MaZ;
    }
    return "";
  }
  
  public final int fXD()
  {
    if (this.IDA != null) {
      return this.IDA.NwM;
    }
    return 0;
  }
  
  public final int getType()
  {
    if ((this.IDt.scene == 201) || (this.IDt.IDQ == 1)) {
      return 2676;
    }
    if (this.IDt.IDX == 1) {
      return 1011;
    }
    if (this.IDt.IDY) {
      return 4858;
    }
    return 719;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77932);
    Log.i("MicroMsg.WebSearch.NetSceneWebSearch", "onGYNetEnd netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label200;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramInt1 = this.IDt.scene;
      paramString = this.IDt.sessionId;
      params = this.IDt.dVO;
      paramArrayOfByte = this.IDt.rjq;
      i = this.IDt.offset;
      if (this.IDt.IDE != 1) {
        break label194;
      }
    }
    label194:
    for (boolean bool2 = true;; bool2 = false)
    {
      ah.a(paramInt1, paramString, params, paramArrayOfByte, i, bool2, this.IDt.dPI, bool1, this.IDt.dDv, this.IDt.businessType);
      ar.aK(this.scene, paramInt2, paramInt3);
      AppMethodBeat.o(77932);
      return;
      bool1 = false;
      break;
    }
    label200:
    this.IDA = ((fav)this.iUB.iLL.iLR);
    String str;
    if (this.IDA != null)
    {
      paramInt1 = this.IDt.scene;
      params = this.IDt.sessionId;
      paramArrayOfByte = this.IDt.dVO;
      str = this.IDt.rjq;
      i = this.IDt.offset;
      if (this.IDt.IDE != 1) {
        break label371;
      }
    }
    label371:
    for (bool2 = true;; bool2 = false)
    {
      ah.a(paramInt1, params, paramArrayOfByte, str, i, bool2, this.IDt.dPI, bool1, this.IDt.dDv, this.IDt.businessType);
      Log.v("MicroMsg.WebSearch.NetSceneWebSearch", "return data\n%s", new Object[] { this.IDA.MaZ });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ar.aK(this.scene, paramInt2, paramInt3);
      AppMethodBeat.o(77932);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.f
 * JD-Core Version:    0.7.0.1
 */