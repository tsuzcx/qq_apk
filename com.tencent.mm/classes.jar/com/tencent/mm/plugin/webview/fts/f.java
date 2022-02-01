package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.fdy;
import com.tencent.mm.protocal.protobuf.fvd;
import com.tencent.mm.protocal.protobuf.gic;
import com.tencent.mm.protocal.protobuf.gid;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
  extends a
  implements m
{
  private long WBf;
  private gic WnQ;
  private gid WnR;
  private w WnS;
  private int Wob;
  private h callback;
  private c oDw;
  private int scene;
  
  /* Error */
  public f(w paramw)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: aload_0
    //   4: invokespecial 30	com/tencent/mm/plugin/websearch/api/a:<init>	()V
    //   7: ldc 31
    //   9: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: lconst_0
    //   14: putfield 39	com/tencent/mm/plugin/webview/fts/f:WBf	J
    //   17: aload_0
    //   18: aload_1
    //   19: putfield 41	com/tencent/mm/plugin/webview/fts/f:WnS	Lcom/tencent/mm/plugin/websearch/api/w;
    //   22: aload_0
    //   23: aload_1
    //   24: getfield 47	com/tencent/mm/plugin/websearch/api/w:hAB	Ljava/lang/String;
    //   27: putfield 50	com/tencent/mm/plugin/webview/fts/f:HQI	Ljava/lang/String;
    //   30: aload_0
    //   31: aload_1
    //   32: getfield 53	com/tencent/mm/plugin/websearch/api/w:hOG	Ljava/lang/String;
    //   35: putfield 56	com/tencent/mm/plugin/webview/fts/f:hVo	Ljava/lang/String;
    //   38: aload_0
    //   39: aload_1
    //   40: getfield 59	com/tencent/mm/plugin/websearch/api/w:offset	I
    //   43: putfield 62	com/tencent/mm/plugin/webview/fts/f:Sc	I
    //   46: aload_0
    //   47: aload_1
    //   48: getfield 64	com/tencent/mm/plugin/websearch/api/w:scene	I
    //   51: putfield 67	com/tencent/mm/plugin/webview/fts/f:mScene	I
    //   54: aload_0
    //   55: aload_1
    //   56: getfield 70	com/tencent/mm/plugin/websearch/api/w:hVk	I
    //   59: putfield 73	com/tencent/mm/plugin/webview/fts/f:WnM	I
    //   62: aload_0
    //   63: aload_1
    //   64: getfield 75	com/tencent/mm/plugin/websearch/api/w:Wob	I
    //   67: putfield 76	com/tencent/mm/plugin/webview/fts/f:Wob	I
    //   70: aload_0
    //   71: aload_1
    //   72: putfield 41	com/tencent/mm/plugin/webview/fts/f:WnS	Lcom/tencent/mm/plugin/websearch/api/w;
    //   75: aload_0
    //   76: aload_1
    //   77: getfield 80	com/tencent/mm/plugin/websearch/api/w:OMx	Landroid/os/Bundle;
    //   80: putfield 83	com/tencent/mm/plugin/webview/fts/f:WnN	Landroid/os/Bundle;
    //   83: aload_1
    //   84: getfield 47	com/tencent/mm/plugin/websearch/api/w:hAB	Ljava/lang/String;
    //   87: invokestatic 89	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   90: ifne +1660 -> 1750
    //   93: ldc 91
    //   95: ldc 93
    //   97: iconst_1
    //   98: anewarray 95	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload_1
    //   104: getfield 47	com/tencent/mm/plugin/websearch/api/w:hAB	Ljava/lang/String;
    //   107: aastore
    //   108: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_0
    //   112: aload_1
    //   113: getfield 64	com/tencent/mm/plugin/websearch/api/w:scene	I
    //   116: putfield 101	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   119: new 103	com/tencent/mm/am/c$a
    //   122: dup
    //   123: invokespecial 104	com/tencent/mm/am/c$a:<init>	()V
    //   126: astore 9
    //   128: aload_1
    //   129: getfield 107	com/tencent/mm/plugin/websearch/api/w:Won	I
    //   132: iconst_1
    //   133: if_icmpne +1418 -> 1551
    //   136: iconst_1
    //   137: istore 4
    //   139: iload 4
    //   141: ifeq +1416 -> 1557
    //   144: aload 9
    //   146: sipush 2676
    //   149: putfield 110	com/tencent/mm/am/c$a:funcId	I
    //   152: ldc 112
    //   154: astore 8
    //   156: aload 9
    //   158: aload 8
    //   160: putfield 115	com/tencent/mm/am/c$a:uri	Ljava/lang/String;
    //   163: ldc 91
    //   165: ldc 117
    //   167: iconst_1
    //   168: anewarray 95	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload 8
    //   175: aastore
    //   176: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: aload 9
    //   181: new 119	com/tencent/mm/protocal/protobuf/gic
    //   184: dup
    //   185: invokespecial 120	com/tencent/mm/protocal/protobuf/gic:<init>	()V
    //   188: putfield 124	com/tencent/mm/am/c$a:otE	Lcom/tencent/mm/bx/a;
    //   191: aload 9
    //   193: new 126	com/tencent/mm/protocal/protobuf/gid
    //   196: dup
    //   197: invokespecial 127	com/tencent/mm/protocal/protobuf/gid:<init>	()V
    //   200: putfield 130	com/tencent/mm/am/c$a:otF	Lcom/tencent/mm/bx/a;
    //   203: aload_0
    //   204: aload 9
    //   206: invokevirtual 134	com/tencent/mm/am/c$a:bEF	()Lcom/tencent/mm/am/c;
    //   209: putfield 136	com/tencent/mm/plugin/webview/fts/f:oDw	Lcom/tencent/mm/am/c;
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 136	com/tencent/mm/plugin/webview/fts/f:oDw	Lcom/tencent/mm/am/c;
    //   217: getfield 142	com/tencent/mm/am/c:otB	Lcom/tencent/mm/am/c$b;
    //   220: invokestatic 148	com/tencent/mm/am/c$b:b	(Lcom/tencent/mm/am/c$b;)Lcom/tencent/mm/bx/a;
    //   223: checkcast 119	com/tencent/mm/protocal/protobuf/gic
    //   226: putfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   229: aload_0
    //   230: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   233: aload_1
    //   234: getfield 47	com/tencent/mm/plugin/websearch/api/w:hAB	Ljava/lang/String;
    //   237: putfield 153	com/tencent/mm/protocal/protobuf/gic:aakp	Ljava/lang/String;
    //   240: aload_0
    //   241: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   244: aload_1
    //   245: getfield 75	com/tencent/mm/plugin/websearch/api/w:Wob	I
    //   248: putfield 156	com/tencent/mm/protocal/protobuf/gic:abuB	I
    //   251: aload_0
    //   252: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   255: aload_1
    //   256: getfield 159	com/tencent/mm/plugin/websearch/api/w:businessType	I
    //   259: i2l
    //   260: putfield 162	com/tencent/mm/protocal/protobuf/gic:YYo	J
    //   263: aload_0
    //   264: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   267: invokestatic 168	com/tencent/mm/plugin/websearch/api/aj:dch	()Lcom/tencent/mm/protocal/protobuf/dhb;
    //   270: putfield 172	com/tencent/mm/protocal/protobuf/gic:aaLr	Lcom/tencent/mm/protocal/protobuf/dhb;
    //   273: aload_0
    //   274: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   277: aload_1
    //   278: getfield 59	com/tencent/mm/plugin/websearch/api/w:offset	I
    //   281: putfield 175	com/tencent/mm/protocal/protobuf/gic:YYs	I
    //   284: aload_0
    //   285: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   288: iconst_0
    //   289: invokestatic 179	com/tencent/mm/plugin/websearch/api/aj:asY	(I)I
    //   292: putfield 182	com/tencent/mm/protocal/protobuf/gic:acet	I
    //   295: aload_0
    //   296: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   299: aload_1
    //   300: getfield 186	com/tencent/mm/plugin/websearch/api/w:Woc	Ljava/util/LinkedList;
    //   303: putfield 189	com/tencent/mm/protocal/protobuf/gic:abyc	Ljava/util/LinkedList;
    //   306: aload_0
    //   307: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   310: aload_1
    //   311: getfield 64	com/tencent/mm/plugin/websearch/api/w:scene	I
    //   314: putfield 192	com/tencent/mm/protocal/protobuf/gic:IJG	I
    //   317: aload_0
    //   318: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   321: aload_1
    //   322: getfield 195	com/tencent/mm/plugin/websearch/api/w:xVe	Ljava/lang/String;
    //   325: putfield 198	com/tencent/mm/protocal/protobuf/gic:YYr	Ljava/lang/String;
    //   328: aload_0
    //   329: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   332: aload_1
    //   333: getfield 201	com/tencent/mm/plugin/websearch/api/w:hVr	I
    //   336: putfield 204	com/tencent/mm/protocal/protobuf/gic:abuF	I
    //   339: aload_0
    //   340: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   343: aload_1
    //   344: getfield 207	com/tencent/mm/plugin/websearch/api/w:Wod	Ljava/lang/String;
    //   347: putfield 210	com/tencent/mm/protocal/protobuf/gic:aceu	Ljava/lang/String;
    //   350: aload_0
    //   351: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   354: aload_1
    //   355: getfield 213	com/tencent/mm/plugin/websearch/api/w:Wof	I
    //   358: putfield 216	com/tencent/mm/protocal/protobuf/gic:acew	I
    //   361: aload_0
    //   362: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   365: aload_1
    //   366: getfield 219	com/tencent/mm/plugin/websearch/api/w:Woe	Ljava/lang/String;
    //   369: putfield 222	com/tencent/mm/protocal/protobuf/gic:acev	Ljava/lang/String;
    //   372: aload_0
    //   373: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   376: aload_1
    //   377: getfield 225	com/tencent/mm/plugin/websearch/api/w:Wog	Ljava/util/LinkedList;
    //   380: putfield 228	com/tencent/mm/protocal/protobuf/gic:acex	Ljava/util/LinkedList;
    //   383: aload_0
    //   384: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   387: aload_1
    //   388: getfield 231	com/tencent/mm/plugin/websearch/api/w:Wol	Ljava/util/LinkedList;
    //   391: putfield 234	com/tencent/mm/protocal/protobuf/gic:accs	Ljava/util/LinkedList;
    //   394: aload_0
    //   395: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   398: getfield 234	com/tencent/mm/protocal/protobuf/gic:accs	Ljava/util/LinkedList;
    //   401: astore 9
    //   403: aload 9
    //   405: invokestatic 237	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   408: ifne +151 -> 559
    //   411: aload 9
    //   413: invokevirtual 243	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   416: astore 8
    //   418: aload 8
    //   420: invokeinterface 249 1 0
    //   425: ifeq +1349 -> 1774
    //   428: aload 8
    //   430: invokeinterface 253 1 0
    //   435: checkcast 255	com/tencent/mm/protocal/protobuf/aem
    //   438: astore 10
    //   440: aload 10
    //   442: ifnull -24 -> 418
    //   445: ldc_w 257
    //   448: aload 10
    //   450: getfield 260	com/tencent/mm/protocal/protobuf/aem:key	Ljava/lang/String;
    //   453: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   456: ifeq -38 -> 418
    //   459: aload 10
    //   461: getfield 269	com/tencent/mm/protocal/protobuf/aem:Zmy	Ljava/lang/String;
    //   464: astore 8
    //   466: ldc 91
    //   468: ldc_w 271
    //   471: iconst_1
    //   472: anewarray 95	java/lang/Object
    //   475: dup
    //   476: iconst_0
    //   477: aload 8
    //   479: aastore
    //   480: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   483: aload 8
    //   485: invokestatic 89	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   488: ifne +71 -> 559
    //   491: invokestatic 277	com/tencent/mm/model/ad:bCb	()Lcom/tencent/mm/model/ad;
    //   494: aload 8
    //   496: invokevirtual 281	com/tencent/mm/model/ad:Jn	(Ljava/lang/String;)Lcom/tencent/mm/model/ad$b;
    //   499: astore 8
    //   501: aload 8
    //   503: ifnull +56 -> 559
    //   506: aload 8
    //   508: ldc_w 283
    //   511: ldc_w 285
    //   514: invokevirtual 291	com/tencent/mm/model/ad$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   517: astore 8
    //   519: aload 8
    //   521: invokestatic 89	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   524: ifne +35 -> 559
    //   527: new 255	com/tencent/mm/protocal/protobuf/aem
    //   530: dup
    //   531: invokespecial 292	com/tencent/mm/protocal/protobuf/aem:<init>	()V
    //   534: astore 10
    //   536: aload 10
    //   538: ldc_w 283
    //   541: putfield 260	com/tencent/mm/protocal/protobuf/aem:key	Ljava/lang/String;
    //   544: aload 10
    //   546: aload 8
    //   548: putfield 269	com/tencent/mm/protocal/protobuf/aem:Zmy	Ljava/lang/String;
    //   551: aload 9
    //   553: aload 10
    //   555: invokevirtual 295	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   558: pop
    //   559: aload_0
    //   560: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   563: aload_1
    //   564: getfield 299	com/tencent/mm/plugin/websearch/api/w:Wok	Lcom/tencent/mm/protocal/protobuf/flq;
    //   567: putfield 300	com/tencent/mm/protocal/protobuf/gic:Wok	Lcom/tencent/mm/protocal/protobuf/flq;
    //   570: aload_0
    //   571: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   574: aload_1
    //   575: getfield 303	com/tencent/mm/plugin/websearch/api/w:Wom	Ljava/util/LinkedList;
    //   578: putfield 306	com/tencent/mm/protocal/protobuf/gic:acey	Ljava/util/LinkedList;
    //   581: aload_0
    //   582: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   585: aload_1
    //   586: getfield 309	com/tencent/mm/plugin/websearch/api/w:language	Ljava/lang/String;
    //   589: putfield 312	com/tencent/mm/protocal/protobuf/gic:yts	Ljava/lang/String;
    //   592: aload_0
    //   593: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   596: aload_1
    //   597: getfield 315	com/tencent/mm/plugin/websearch/api/w:sessionId	Ljava/lang/String;
    //   600: putfield 318	com/tencent/mm/protocal/protobuf/gic:acee	Ljava/lang/String;
    //   603: aload_0
    //   604: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   607: astore 8
    //   609: invokestatic 323	com/tencent/mm/ui/aw:isDarkMode	()Z
    //   612: ifeq +1008 -> 1620
    //   615: iconst_1
    //   616: istore 4
    //   618: aload 8
    //   620: iload 4
    //   622: putfield 326	com/tencent/mm/protocal/protobuf/gic:abgz	I
    //   625: aload_0
    //   626: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   629: invokestatic 330	com/tencent/mm/plugin/websearch/api/aj:iqa	()Lcom/tencent/mm/protocal/protobuf/acm;
    //   632: putfield 334	com/tencent/mm/protocal/protobuf/gic:aaLs	Lcom/tencent/mm/protocal/protobuf/acm;
    //   635: aload_0
    //   636: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   639: astore 9
    //   641: aload_0
    //   642: getfield 101	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   645: bipush 79
    //   647: if_icmpeq +12 -> 659
    //   650: aload_0
    //   651: getfield 101	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   654: bipush 80
    //   656: if_icmpne +1016 -> 1672
    //   659: new 336	com/tencent/mm/protocal/protobuf/fln
    //   662: dup
    //   663: invokespecial 337	com/tencent/mm/protocal/protobuf/fln:<init>	()V
    //   666: astore 8
    //   668: aload 8
    //   670: iconst_1
    //   671: putfield 340	com/tencent/mm/protocal/protobuf/fln:IcB	I
    //   674: aload_1
    //   675: getfield 343	com/tencent/mm/plugin/websearch/api/w:Woy	Ljava/lang/String;
    //   678: astore 10
    //   680: aload 10
    //   682: invokestatic 349	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   685: ifne +987 -> 1672
    //   688: aload 10
    //   690: ldc_w 351
    //   693: invokevirtual 355	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   696: astore 10
    //   698: aload_0
    //   699: getfield 101	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   702: bipush 79
    //   704: if_icmpne +922 -> 1626
    //   707: aload 10
    //   709: arraylength
    //   710: iconst_2
    //   711: if_icmplt +21 -> 732
    //   714: aload 8
    //   716: aload 10
    //   718: iconst_0
    //   719: aaload
    //   720: putfield 358	com/tencent/mm/protocal/protobuf/fln:abLY	Ljava/lang/String;
    //   723: aload 8
    //   725: aload 10
    //   727: iconst_1
    //   728: aaload
    //   729: putfield 361	com/tencent/mm/protocal/protobuf/fln:abMa	Ljava/lang/String;
    //   732: aload 8
    //   734: aload_1
    //   735: getfield 364	com/tencent/mm/plugin/websearch/api/w:Woz	I
    //   738: putfield 367	com/tencent/mm/protocal/protobuf/fln:aamC	I
    //   741: aload 9
    //   743: aload 8
    //   745: putfield 371	com/tencent/mm/protocal/protobuf/gic:aceE	Lcom/tencent/mm/protocal/protobuf/fln;
    //   748: aload_1
    //   749: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   752: ifnonnull +14 -> 766
    //   755: aload_1
    //   756: new 377	com/tencent/mm/protocal/protobuf/ghx
    //   759: dup
    //   760: invokespecial 378	com/tencent/mm/protocal/protobuf/ghx:<init>	()V
    //   763: putfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   766: aload_1
    //   767: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   770: getfield 382	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   773: ifnonnull +17 -> 790
    //   776: aload_1
    //   777: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   780: new 384	com/tencent/mm/protocal/protobuf/ry
    //   783: dup
    //   784: invokespecial 385	com/tencent/mm/protocal/protobuf/ry:<init>	()V
    //   787: putfield 382	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   790: aload_1
    //   791: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   794: getfield 382	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   797: astore 8
    //   799: invokestatic 391	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   802: invokevirtual 397	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   805: invokevirtual 403	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   808: getfield 408	android/util/DisplayMetrics:widthPixels	I
    //   811: istore 4
    //   813: invokestatic 413	org/xwalk/core/XWalkEnvironment:getUsingCustomContext	()Z
    //   816: ifeq +862 -> 1678
    //   819: iload 4
    //   821: i2f
    //   822: invokestatic 391	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   825: invokestatic 419	com/tencent/mm/cd/a:getDensity	(Landroid/content/Context;)F
    //   828: fdiv
    //   829: invokestatic 425	java/lang/Math:round	(F)I
    //   832: istore 4
    //   834: aload 8
    //   836: iload 4
    //   838: putfield 428	com/tencent/mm/protocal/protobuf/ry:PHe	I
    //   841: ldc 91
    //   843: ldc_w 430
    //   846: iconst_3
    //   847: anewarray 95	java/lang/Object
    //   850: dup
    //   851: iconst_0
    //   852: invokestatic 391	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   855: invokevirtual 397	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   858: invokevirtual 403	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   861: getfield 408	android/util/DisplayMetrics:widthPixels	I
    //   864: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   867: aastore
    //   868: dup
    //   869: iconst_1
    //   870: aload_1
    //   871: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   874: getfield 382	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   877: getfield 428	com/tencent/mm/protocal/protobuf/ry:PHe	I
    //   880: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   883: aastore
    //   884: dup
    //   885: iconst_2
    //   886: invokestatic 391	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   889: invokevirtual 397	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   892: invokevirtual 403	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   895: getfield 440	android/util/DisplayMetrics:density	F
    //   898: invokestatic 445	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   901: aastore
    //   902: invokestatic 448	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   905: fconst_0
    //   906: fstore_3
    //   907: fconst_0
    //   908: fstore_2
    //   909: aload_0
    //   910: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   913: getfield 172	com/tencent/mm/protocal/protobuf/gic:aaLr	Lcom/tencent/mm/protocal/protobuf/dhb;
    //   916: ifnull +789 -> 1705
    //   919: aload_1
    //   920: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   923: getfield 382	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   926: astore 8
    //   928: invokestatic 454	com/tencent/mm/modelgeo/d:bJl	()Lcom/tencent/mm/modelgeo/d;
    //   931: astore 9
    //   933: aload 9
    //   935: getfield 457	com/tencent/mm/modelgeo/d:oEj	J
    //   938: lconst_0
    //   939: lcmp
    //   940: ifle +753 -> 1693
    //   943: aload 9
    //   945: getfield 461	com/tencent/mm/modelgeo/d:oEl	Z
    //   948: ifeq +745 -> 1693
    //   951: invokestatic 467	java/lang/System:currentTimeMillis	()J
    //   954: aload 9
    //   956: getfield 457	com/tencent/mm/modelgeo/d:oEj	J
    //   959: lsub
    //   960: ldc2_w 468
    //   963: lcmp
    //   964: ifge +729 -> 1693
    //   967: iconst_1
    //   968: istore 4
    //   970: iload 4
    //   972: ifeq +727 -> 1699
    //   975: iconst_0
    //   976: istore 4
    //   978: aload 8
    //   980: iload 4
    //   982: putfield 472	com/tencent/mm/protocal/protobuf/ry:YWR	I
    //   985: aload_0
    //   986: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   989: getfield 172	com/tencent/mm/protocal/protobuf/gic:aaLr	Lcom/tencent/mm/protocal/protobuf/dhb;
    //   992: getfield 477	com/tencent/mm/protocal/protobuf/dhb:ZaG	F
    //   995: fstore_3
    //   996: aload_0
    //   997: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   1000: getfield 172	com/tencent/mm/protocal/protobuf/gic:aaLr	Lcom/tencent/mm/protocal/protobuf/dhb;
    //   1003: getfield 480	com/tencent/mm/protocal/protobuf/dhb:ZaH	F
    //   1006: fstore_2
    //   1007: ldc 91
    //   1009: ldc_w 482
    //   1012: iconst_3
    //   1013: anewarray 95	java/lang/Object
    //   1016: dup
    //   1017: iconst_0
    //   1018: fload_3
    //   1019: invokestatic 445	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1022: aastore
    //   1023: dup
    //   1024: iconst_1
    //   1025: fload_2
    //   1026: invokestatic 445	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1029: aastore
    //   1030: dup
    //   1031: iconst_2
    //   1032: aload_1
    //   1033: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1036: getfield 382	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1039: getfield 472	com/tencent/mm/protocal/protobuf/ry:YWR	I
    //   1042: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1045: aastore
    //   1046: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1049: aload_1
    //   1050: getfield 485	com/tencent/mm/plugin/websearch/api/w:Woq	Ljava/lang/String;
    //   1053: invokestatic 349	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1056: ifne +148 -> 1204
    //   1059: aload_1
    //   1060: getfield 485	com/tencent/mm/plugin/websearch/api/w:Woq	Ljava/lang/String;
    //   1063: invokestatic 491	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   1066: astore 8
    //   1068: new 493	org/json/JSONObject
    //   1071: dup
    //   1072: aload 8
    //   1074: invokespecial 496	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1077: astore 8
    //   1079: new 498	com/tencent/mm/protocal/protobuf/eej
    //   1082: dup
    //   1083: invokespecial 499	com/tencent/mm/protocal/protobuf/eej:<init>	()V
    //   1086: astore 9
    //   1088: aload 9
    //   1090: aload 8
    //   1092: ldc_w 501
    //   1095: invokevirtual 504	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1098: putfield 507	com/tencent/mm/protocal/protobuf/eej:pSh	Ljava/lang/String;
    //   1101: aload 9
    //   1103: aload 8
    //   1105: ldc_w 509
    //   1108: invokevirtual 504	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1111: putfield 512	com/tencent/mm/protocal/protobuf/eej:pSo	Ljava/lang/String;
    //   1114: aload 9
    //   1116: aload 8
    //   1118: ldc_w 514
    //   1121: invokevirtual 518	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   1124: d2f
    //   1125: putfield 519	com/tencent/mm/protocal/protobuf/eej:ZaH	F
    //   1128: aload 9
    //   1130: aload 8
    //   1132: ldc_w 521
    //   1135: invokevirtual 518	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   1138: d2f
    //   1139: putfield 522	com/tencent/mm/protocal/protobuf/eej:ZaG	F
    //   1142: aload 9
    //   1144: aload 8
    //   1146: ldc_w 524
    //   1149: invokevirtual 504	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1152: putfield 527	com/tencent/mm/protocal/protobuf/eej:abjt	Ljava/lang/String;
    //   1155: aload 9
    //   1157: aload 8
    //   1159: ldc_w 529
    //   1162: invokevirtual 504	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1165: putfield 532	com/tencent/mm/protocal/protobuf/eej:aaGj	Ljava/lang/String;
    //   1168: aload 9
    //   1170: aload 8
    //   1172: ldc_w 534
    //   1175: invokevirtual 504	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1178: invokestatic 538	com/tencent/mm/plugin/websearch/api/aj:biu	(Ljava/lang/String;)J
    //   1181: putfield 541	com/tencent/mm/protocal/protobuf/eej:abjv	J
    //   1184: aload 9
    //   1186: getfield 527	com/tencent/mm/protocal/protobuf/eej:abjt	Ljava/lang/String;
    //   1189: invokestatic 349	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1192: ifne +12 -> 1204
    //   1195: aload_0
    //   1196: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   1199: aload 9
    //   1201: putfield 545	com/tencent/mm/protocal/protobuf/gic:aceD	Lcom/tencent/mm/protocal/protobuf/eej;
    //   1204: aload_1
    //   1205: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1208: ifnull +96 -> 1304
    //   1211: aload_1
    //   1212: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1215: ldc_w 547
    //   1218: invokestatic 553	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1221: checkcast 547	com/tencent/mm/plugin/appbrand/service/k
    //   1224: invokeinterface 557 1 0
    //   1229: putfield 560	com/tencent/mm/protocal/protobuf/ghx:aceq	I
    //   1232: aload_0
    //   1233: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   1236: new 562	com/tencent/mm/bx/b
    //   1239: dup
    //   1240: aload_1
    //   1241: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1244: invokevirtual 566	com/tencent/mm/protocal/protobuf/ghx:toByteArray	()[B
    //   1247: invokespecial 569	com/tencent/mm/bx/b:<init>	([B)V
    //   1250: putfield 573	com/tencent/mm/protocal/protobuf/gic:aceA	Lcom/tencent/mm/bx/b;
    //   1253: ldc 91
    //   1255: ldc_w 575
    //   1258: iconst_3
    //   1259: anewarray 95	java/lang/Object
    //   1262: dup
    //   1263: iconst_0
    //   1264: aload_1
    //   1265: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1268: getfield 578	com/tencent/mm/protocal/protobuf/ghx:aceo	J
    //   1271: invokestatic 583	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1274: aastore
    //   1275: dup
    //   1276: iconst_1
    //   1277: aload_1
    //   1278: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1281: getfield 382	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1284: getfield 586	com/tencent/mm/protocal/protobuf/ry:appid	Ljava/lang/String;
    //   1287: aastore
    //   1288: dup
    //   1289: iconst_2
    //   1290: aload_1
    //   1291: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1294: getfield 382	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1297: getfield 589	com/tencent/mm/protocal/protobuf/ry:xmx	Ljava/lang/String;
    //   1300: aastore
    //   1301: invokestatic 448	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1304: aload_1
    //   1305: getfield 593	com/tencent/mm/plugin/websearch/api/w:Woo	Lcom/tencent/mm/protocal/protobuf/gmm;
    //   1308: ifnull +24 -> 1332
    //   1311: aload_0
    //   1312: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   1315: new 562	com/tencent/mm/bx/b
    //   1318: dup
    //   1319: aload_1
    //   1320: getfield 593	com/tencent/mm/plugin/websearch/api/w:Woo	Lcom/tencent/mm/protocal/protobuf/gmm;
    //   1323: invokevirtual 596	com/tencent/mm/protocal/protobuf/gmm:toByteArray	()[B
    //   1326: invokespecial 569	com/tencent/mm/bx/b:<init>	([B)V
    //   1329: putfield 599	com/tencent/mm/protocal/protobuf/gic:acez	Lcom/tencent/mm/bx/b;
    //   1332: aload_0
    //   1333: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   1336: getfield 172	com/tencent/mm/protocal/protobuf/gic:aaLr	Lcom/tencent/mm/protocal/protobuf/dhb;
    //   1339: ifnull +399 -> 1738
    //   1342: iconst_1
    //   1343: istore 6
    //   1345: ldc 91
    //   1347: ldc_w 601
    //   1350: bipush 7
    //   1352: anewarray 95	java/lang/Object
    //   1355: dup
    //   1356: iconst_0
    //   1357: iload 6
    //   1359: invokestatic 606	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1362: aastore
    //   1363: dup
    //   1364: iconst_1
    //   1365: aload_1
    //   1366: getfield 186	com/tencent/mm/plugin/websearch/api/w:Woc	Ljava/util/LinkedList;
    //   1369: invokevirtual 609	java/util/LinkedList:size	()I
    //   1372: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1375: aastore
    //   1376: dup
    //   1377: iconst_2
    //   1378: aload_1
    //   1379: getfield 64	com/tencent/mm/plugin/websearch/api/w:scene	I
    //   1382: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1385: aastore
    //   1386: dup
    //   1387: iconst_3
    //   1388: aload_1
    //   1389: getfield 159	com/tencent/mm/plugin/websearch/api/w:businessType	I
    //   1392: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1395: aastore
    //   1396: dup
    //   1397: iconst_4
    //   1398: aload_0
    //   1399: getfield 76	com/tencent/mm/plugin/webview/fts/f:Wob	I
    //   1402: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1405: aastore
    //   1406: dup
    //   1407: iconst_5
    //   1408: aload_1
    //   1409: getfield 201	com/tencent/mm/plugin/websearch/api/w:hVr	I
    //   1412: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1415: aastore
    //   1416: dup
    //   1417: bipush 6
    //   1419: aload_1
    //   1420: getfield 70	com/tencent/mm/plugin/websearch/api/w:hVk	I
    //   1423: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1426: aastore
    //   1427: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1430: aload_0
    //   1431: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   1434: getfield 172	com/tencent/mm/protocal/protobuf/gic:aaLr	Lcom/tencent/mm/protocal/protobuf/dhb;
    //   1437: ifnull +39 -> 1476
    //   1440: sipush 2005
    //   1443: aload_0
    //   1444: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   1447: getfield 172	com/tencent/mm/protocal/protobuf/gic:aaLr	Lcom/tencent/mm/protocal/protobuf/dhb;
    //   1450: getfield 477	com/tencent/mm/protocal/protobuf/dhb:ZaG	F
    //   1453: aload_0
    //   1454: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   1457: getfield 172	com/tencent/mm/protocal/protobuf/gic:aaLr	Lcom/tencent/mm/protocal/protobuf/dhb;
    //   1460: getfield 480	com/tencent/mm/protocal/protobuf/dhb:ZaH	F
    //   1463: aload_0
    //   1464: getfield 150	com/tencent/mm/plugin/webview/fts/f:WnQ	Lcom/tencent/mm/protocal/protobuf/gic;
    //   1467: getfield 172	com/tencent/mm/protocal/protobuf/gic:aaLr	Lcom/tencent/mm/protocal/protobuf/dhb;
    //   1470: getfield 612	com/tencent/mm/protocal/protobuf/dhb:Zyl	I
    //   1473: invokestatic 618	com/tencent/mm/modelstat/n:a	(IFFI)V
    //   1476: aload_1
    //   1477: getfield 64	com/tencent/mm/plugin/websearch/api/w:scene	I
    //   1480: istore 4
    //   1482: aload_1
    //   1483: getfield 315	com/tencent/mm/plugin/websearch/api/w:sessionId	Ljava/lang/String;
    //   1486: astore 8
    //   1488: aload_1
    //   1489: getfield 621	com/tencent/mm/plugin/websearch/api/w:hVn	Ljava/lang/String;
    //   1492: astore 9
    //   1494: aload_1
    //   1495: getfield 195	com/tencent/mm/plugin/websearch/api/w:xVe	Ljava/lang/String;
    //   1498: astore 10
    //   1500: aload_1
    //   1501: getfield 59	com/tencent/mm/plugin/websearch/api/w:offset	I
    //   1504: istore 5
    //   1506: aload_1
    //   1507: getfield 75	com/tencent/mm/plugin/websearch/api/w:Wob	I
    //   1510: iconst_1
    //   1511: if_icmpne +233 -> 1744
    //   1514: iload 7
    //   1516: istore 6
    //   1518: iload 4
    //   1520: aload 8
    //   1522: aload 9
    //   1524: aload 10
    //   1526: iload 5
    //   1528: iload 6
    //   1530: aload_1
    //   1531: getfield 53	com/tencent/mm/plugin/websearch/api/w:hOG	Ljava/lang/String;
    //   1534: aload_1
    //   1535: getfield 47	com/tencent/mm/plugin/websearch/api/w:hAB	Ljava/lang/String;
    //   1538: aload_1
    //   1539: getfield 159	com/tencent/mm/plugin/websearch/api/w:businessType	I
    //   1542: invokestatic 626	com/tencent/mm/plugin/websearch/api/ai:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;I)V
    //   1545: ldc 31
    //   1547: invokestatic 629	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1550: return
    //   1551: iconst_0
    //   1552: istore 4
    //   1554: goto -1415 -> 139
    //   1557: aload_1
    //   1558: getfield 632	com/tencent/mm/plugin/websearch/api/w:Wou	I
    //   1561: iconst_1
    //   1562: if_icmpne +19 -> 1581
    //   1565: aload 9
    //   1567: sipush 1011
    //   1570: putfield 110	com/tencent/mm/am/c$a:funcId	I
    //   1573: ldc_w 634
    //   1576: astore 8
    //   1578: goto -1422 -> 156
    //   1581: aload_1
    //   1582: getfield 637	com/tencent/mm/plugin/websearch/api/w:Wov	Z
    //   1585: ifeq +19 -> 1604
    //   1588: aload 9
    //   1590: sipush 4858
    //   1593: putfield 110	com/tencent/mm/am/c$a:funcId	I
    //   1596: ldc_w 639
    //   1599: astore 8
    //   1601: goto -1445 -> 156
    //   1604: aload 9
    //   1606: sipush 719
    //   1609: putfield 110	com/tencent/mm/am/c$a:funcId	I
    //   1612: ldc_w 641
    //   1615: astore 8
    //   1617: goto -1461 -> 156
    //   1620: iconst_0
    //   1621: istore 4
    //   1623: goto -1005 -> 618
    //   1626: aload_0
    //   1627: getfield 101	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   1630: bipush 80
    //   1632: if_icmpne -900 -> 732
    //   1635: aload 10
    //   1637: arraylength
    //   1638: iconst_3
    //   1639: if_icmplt -907 -> 732
    //   1642: aload 8
    //   1644: aload 10
    //   1646: iconst_0
    //   1647: aaload
    //   1648: putfield 358	com/tencent/mm/protocal/protobuf/fln:abLY	Ljava/lang/String;
    //   1651: aload 8
    //   1653: aload 10
    //   1655: iconst_1
    //   1656: aaload
    //   1657: putfield 361	com/tencent/mm/protocal/protobuf/fln:abMa	Ljava/lang/String;
    //   1660: aload 8
    //   1662: aload 10
    //   1664: iconst_2
    //   1665: aaload
    //   1666: putfield 644	com/tencent/mm/protocal/protobuf/fln:abLZ	Ljava/lang/String;
    //   1669: goto -937 -> 732
    //   1672: aconst_null
    //   1673: astore 8
    //   1675: goto -934 -> 741
    //   1678: iload 4
    //   1680: i2f
    //   1681: invokestatic 650	com/tencent/mm/ce/c:iRA	()F
    //   1684: fdiv
    //   1685: invokestatic 425	java/lang/Math:round	(F)I
    //   1688: istore 4
    //   1690: goto -856 -> 834
    //   1693: iconst_0
    //   1694: istore 4
    //   1696: goto -726 -> 970
    //   1699: iconst_1
    //   1700: istore 4
    //   1702: goto -724 -> 978
    //   1705: aload_1
    //   1706: getfield 375	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1709: getfield 382	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1712: iconst_1
    //   1713: putfield 472	com/tencent/mm/protocal/protobuf/ry:YWR	I
    //   1716: goto -709 -> 1007
    //   1719: astore 8
    //   1721: ldc 91
    //   1723: aload 8
    //   1725: ldc_w 285
    //   1728: iconst_0
    //   1729: anewarray 95	java/lang/Object
    //   1732: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1735: goto -531 -> 1204
    //   1738: iconst_0
    //   1739: istore 6
    //   1741: goto -396 -> 1345
    //   1744: iconst_0
    //   1745: istore 6
    //   1747: goto -229 -> 1518
    //   1750: ldc 91
    //   1752: ldc_w 656
    //   1755: invokestatic 660	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1758: ldc 31
    //   1760: invokestatic 629	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1763: return
    //   1764: astore 8
    //   1766: goto -434 -> 1332
    //   1769: astore 8
    //   1771: goto -467 -> 1304
    //   1774: aconst_null
    //   1775: astore 8
    //   1777: goto -1311 -> 466
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1780	0	this	f
    //   0	1780	1	paramw	w
    //   908	118	2	f1	float
    //   906	113	3	f2	float
    //   137	1564	4	i	int
    //   1504	23	5	j	int
    //   1343	403	6	bool1	boolean
    //   1	1514	7	bool2	boolean
    //   154	1520	8	localObject1	Object
    //   1719	5	8	localJSONException	org.json.JSONException
    //   1764	1	8	localException1	java.lang.Exception
    //   1769	1	8	localException2	java.lang.Exception
    //   1775	1	8	localObject2	Object
    //   126	1479	9	localObject3	Object
    //   438	1225	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   1068	1204	1719	org/json/JSONException
    //   1311	1332	1764	java/lang/Exception
    //   1211	1304	1769	java/lang/Exception
  }
  
  public final void cg(LinkedList<fvd> paramLinkedList)
  {
    AppMethodBeat.i(77933);
    this.WnQ.abyc = paramLinkedList;
    fdy localfdy = new fdy();
    localfdy.abDC = paramLinkedList.size();
    this.WnQ.aceB = localfdy;
    AppMethodBeat.o(77933);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(77931);
    this.WBf = cn.bDw();
    as.nc(this.scene, 2);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(77931);
    return i;
  }
  
  public final int getType()
  {
    if (this.WnS.Wou == 1) {
      return 1011;
    }
    if (this.WnS.Wov) {
      return 4858;
    }
    return 719;
  }
  
  public final String ipG()
  {
    if (this.WnR != null) {
      return this.WnR.aayd;
    }
    return "";
  }
  
  public final int ipH()
  {
    if (this.WnR != null) {
      return this.WnR.acek;
    }
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77932);
    Log.i("MicroMsg.WebSearch.NetSceneWebSearch", "onGYNetEnd netId %d | errType %d | errCode %d | errMsg %s useTime: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(cn.bDu() - this.WBf) });
    boolean bool1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label214;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramInt1 = this.WnS.scene;
      paramString = this.WnS.sessionId;
      params = this.WnS.hVn;
      paramArrayOfByte = this.WnS.xVe;
      i = this.WnS.offset;
      if (this.WnS.Wob != 1) {
        break label208;
      }
    }
    label208:
    for (boolean bool2 = true;; bool2 = false)
    {
      ai.a(paramInt1, paramString, params, paramArrayOfByte, i, bool2, this.WnS.hOG, bool1, this.WnS.hAB, this.WnS.businessType);
      as.bq(this.scene, paramInt2, paramInt3);
      AppMethodBeat.o(77932);
      return;
      bool1 = false;
      break;
    }
    label214:
    this.WnR = ((gid)c.c.b(this.oDw.otC));
    String str;
    if (this.WnR != null)
    {
      paramInt1 = this.WnS.scene;
      params = this.WnS.sessionId;
      paramArrayOfByte = this.WnS.hVn;
      str = this.WnS.xVe;
      i = this.WnS.offset;
      if (this.WnS.Wob != 1) {
        break label385;
      }
    }
    label385:
    for (bool2 = true;; bool2 = false)
    {
      ai.a(paramInt1, params, paramArrayOfByte, str, i, bool2, this.WnS.hOG, bool1, this.WnS.hAB, this.WnS.businessType);
      Log.v("MicroMsg.WebSearch.NetSceneWebSearch", "return data\n%s", new Object[] { this.WnR.aayd });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      as.bq(this.scene, paramInt2, paramInt3);
      AppMethodBeat.o(77932);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.f
 * JD-Core Version:    0.7.0.1
 */