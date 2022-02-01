package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.protocal.protobuf.ejr;
import com.tencent.mm.protocal.protobuf.ezc;
import com.tencent.mm.protocal.protobuf.fln;
import com.tencent.mm.protocal.protobuf.flo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
  extends a
  implements m
{
  private v PxJ;
  private fln PxP;
  private flo PxQ;
  private int PxU;
  private i callback;
  private d lKU;
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
    //   14: putfield 37	com/tencent/mm/plugin/webview/fts/f:PxJ	Lcom/tencent/mm/plugin/websearch/api/v;
    //   17: aload_0
    //   18: aload_1
    //   19: getfield 43	com/tencent/mm/plugin/websearch/api/v:fwe	Ljava/lang/String;
    //   22: putfield 46	com/tencent/mm/plugin/webview/fts/f:CeE	Ljava/lang/String;
    //   25: aload_0
    //   26: aload_1
    //   27: getfield 49	com/tencent/mm/plugin/websearch/api/v:fIY	Ljava/lang/String;
    //   30: putfield 52	com/tencent/mm/plugin/webview/fts/f:fPt	Ljava/lang/String;
    //   33: aload_0
    //   34: aload_1
    //   35: getfield 55	com/tencent/mm/plugin/websearch/api/v:offset	I
    //   38: putfield 58	com/tencent/mm/plugin/webview/fts/f:zP	I
    //   41: aload_0
    //   42: aload_1
    //   43: getfield 60	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   46: putfield 63	com/tencent/mm/plugin/webview/fts/f:mScene	I
    //   49: aload_0
    //   50: aload_1
    //   51: getfield 66	com/tencent/mm/plugin/websearch/api/v:fPp	I
    //   54: putfield 69	com/tencent/mm/plugin/webview/fts/f:PxG	I
    //   57: aload_0
    //   58: aload_1
    //   59: getfield 71	com/tencent/mm/plugin/websearch/api/v:PxU	I
    //   62: putfield 72	com/tencent/mm/plugin/webview/fts/f:PxU	I
    //   65: aload_0
    //   66: aload_1
    //   67: putfield 37	com/tencent/mm/plugin/webview/fts/f:PxJ	Lcom/tencent/mm/plugin/websearch/api/v;
    //   70: aload_0
    //   71: aload_1
    //   72: getfield 76	com/tencent/mm/plugin/websearch/api/v:IGp	Landroid/os/Bundle;
    //   75: putfield 79	com/tencent/mm/plugin/webview/fts/f:PxH	Landroid/os/Bundle;
    //   78: aload_1
    //   79: getfield 43	com/tencent/mm/plugin/websearch/api/v:fwe	Ljava/lang/String;
    //   82: invokestatic 85	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   85: ifne +1669 -> 1754
    //   88: ldc 87
    //   90: ldc 89
    //   92: iconst_1
    //   93: anewarray 91	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_1
    //   99: getfield 43	com/tencent/mm/plugin/websearch/api/v:fwe	Ljava/lang/String;
    //   102: aastore
    //   103: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: aload_1
    //   108: getfield 60	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   111: putfield 97	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   114: new 99	com/tencent/mm/an/d$a
    //   117: dup
    //   118: invokespecial 100	com/tencent/mm/an/d$a:<init>	()V
    //   121: astore 9
    //   123: aload_1
    //   124: getfield 60	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   127: sipush 201
    //   130: if_icmpeq +11 -> 141
    //   133: aload_1
    //   134: getfield 103	com/tencent/mm/plugin/websearch/api/v:Pyg	I
    //   137: iconst_1
    //   138: if_icmpne +1417 -> 1555
    //   141: iconst_1
    //   142: istore 4
    //   144: iload 4
    //   146: ifeq +1415 -> 1561
    //   149: aload 9
    //   151: sipush 2676
    //   154: putfield 106	com/tencent/mm/an/d$a:funcId	I
    //   157: ldc 108
    //   159: astore 8
    //   161: aload 9
    //   163: aload 8
    //   165: putfield 111	com/tencent/mm/an/d$a:uri	Ljava/lang/String;
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
    //   186: new 115	com/tencent/mm/protocal/protobuf/fln
    //   189: dup
    //   190: invokespecial 116	com/tencent/mm/protocal/protobuf/fln:<init>	()V
    //   193: putfield 120	com/tencent/mm/an/d$a:lBU	Lcom/tencent/mm/cd/a;
    //   196: aload 9
    //   198: new 122	com/tencent/mm/protocal/protobuf/flo
    //   201: dup
    //   202: invokespecial 123	com/tencent/mm/protocal/protobuf/flo:<init>	()V
    //   205: putfield 126	com/tencent/mm/an/d$a:lBV	Lcom/tencent/mm/cd/a;
    //   208: aload_0
    //   209: aload 9
    //   211: invokevirtual 130	com/tencent/mm/an/d$a:bgN	()Lcom/tencent/mm/an/d;
    //   214: putfield 132	com/tencent/mm/plugin/webview/fts/f:lKU	Lcom/tencent/mm/an/d;
    //   217: aload_0
    //   218: aload_0
    //   219: getfield 132	com/tencent/mm/plugin/webview/fts/f:lKU	Lcom/tencent/mm/an/d;
    //   222: getfield 138	com/tencent/mm/an/d:lBR	Lcom/tencent/mm/an/d$b;
    //   225: invokestatic 144	com/tencent/mm/an/d$b:b	(Lcom/tencent/mm/an/d$b;)Lcom/tencent/mm/cd/a;
    //   228: checkcast 115	com/tencent/mm/protocal/protobuf/fln
    //   231: putfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   234: aload_0
    //   235: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   238: aload_1
    //   239: getfield 43	com/tencent/mm/plugin/websearch/api/v:fwe	Ljava/lang/String;
    //   242: putfield 149	com/tencent/mm/protocal/protobuf/fln:SYn	Ljava/lang/String;
    //   245: aload_0
    //   246: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   249: aload_1
    //   250: getfield 71	com/tencent/mm/plugin/websearch/api/v:PxU	I
    //   253: putfield 152	com/tencent/mm/protocal/protobuf/fln:Udh	I
    //   256: aload_0
    //   257: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   260: aload_1
    //   261: getfield 155	com/tencent/mm/plugin/websearch/api/v:businessType	I
    //   264: i2l
    //   265: putfield 159	com/tencent/mm/protocal/protobuf/fln:Sap	J
    //   268: aload_0
    //   269: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   272: invokestatic 165	com/tencent/mm/plugin/websearch/api/ai:czn	()Lcom/tencent/mm/protocal/protobuf/cqh;
    //   275: putfield 169	com/tencent/mm/protocal/protobuf/fln:TwK	Lcom/tencent/mm/protocal/protobuf/cqh;
    //   278: aload_0
    //   279: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   282: aload_1
    //   283: getfield 55	com/tencent/mm/plugin/websearch/api/v:offset	I
    //   286: putfield 172	com/tencent/mm/protocal/protobuf/fln:Sat	I
    //   289: aload_0
    //   290: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   293: iconst_0
    //   294: invokestatic 176	com/tencent/mm/plugin/websearch/api/ai:anh	(I)I
    //   297: putfield 179	com/tencent/mm/protocal/protobuf/fln:UKl	I
    //   300: aload_0
    //   301: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   304: aload_1
    //   305: getfield 183	com/tencent/mm/plugin/websearch/api/v:PxV	Ljava/util/LinkedList;
    //   308: putfield 186	com/tencent/mm/protocal/protobuf/fln:UgB	Ljava/util/LinkedList;
    //   311: aload_0
    //   312: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   315: aload_1
    //   316: getfield 60	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   319: putfield 189	com/tencent/mm/protocal/protobuf/fln:CPw	I
    //   322: aload_0
    //   323: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   326: aload_1
    //   327: getfield 192	com/tencent/mm/plugin/websearch/api/v:uMC	Ljava/lang/String;
    //   330: putfield 195	com/tencent/mm/protocal/protobuf/fln:Sas	Ljava/lang/String;
    //   333: aload_0
    //   334: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   337: aload_1
    //   338: getfield 198	com/tencent/mm/plugin/websearch/api/v:fPw	I
    //   341: putfield 201	com/tencent/mm/protocal/protobuf/fln:Udl	I
    //   344: aload_0
    //   345: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   348: aload_1
    //   349: getfield 204	com/tencent/mm/plugin/websearch/api/v:PxW	Ljava/lang/String;
    //   352: putfield 207	com/tencent/mm/protocal/protobuf/fln:UKm	Ljava/lang/String;
    //   355: aload_0
    //   356: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   359: aload_1
    //   360: getfield 210	com/tencent/mm/plugin/websearch/api/v:PxY	I
    //   363: putfield 213	com/tencent/mm/protocal/protobuf/fln:UKo	I
    //   366: aload_0
    //   367: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   370: aload_1
    //   371: getfield 216	com/tencent/mm/plugin/websearch/api/v:PxX	Ljava/lang/String;
    //   374: putfield 219	com/tencent/mm/protocal/protobuf/fln:UKn	Ljava/lang/String;
    //   377: aload_0
    //   378: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   381: aload_1
    //   382: getfield 222	com/tencent/mm/plugin/websearch/api/v:PxZ	Ljava/util/LinkedList;
    //   385: putfield 225	com/tencent/mm/protocal/protobuf/fln:UKp	Ljava/util/LinkedList;
    //   388: aload_0
    //   389: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   392: aload_1
    //   393: getfield 228	com/tencent/mm/plugin/websearch/api/v:Pye	Ljava/util/LinkedList;
    //   396: putfield 231	com/tencent/mm/protocal/protobuf/fln:UIj	Ljava/util/LinkedList;
    //   399: aload_0
    //   400: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   403: getfield 231	com/tencent/mm/protocal/protobuf/fln:UIj	Ljava/util/LinkedList;
    //   406: astore 9
    //   408: aload 9
    //   410: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   413: ifne +150 -> 563
    //   416: aload 9
    //   418: invokevirtual 240	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   421: astore 8
    //   423: aload 8
    //   425: invokeinterface 246 1 0
    //   430: ifeq +1348 -> 1778
    //   433: aload 8
    //   435: invokeinterface 250 1 0
    //   440: checkcast 252	com/tencent/mm/protocal/protobuf/aci
    //   443: astore 10
    //   445: aload 10
    //   447: ifnull -24 -> 423
    //   450: ldc 254
    //   452: aload 10
    //   454: getfield 257	com/tencent/mm/protocal/protobuf/aci:key	Ljava/lang/String;
    //   457: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   460: ifeq -37 -> 423
    //   463: aload 10
    //   465: getfield 266	com/tencent/mm/protocal/protobuf/aci:SnW	Ljava/lang/String;
    //   468: astore 8
    //   470: ldc 87
    //   472: ldc_w 268
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
    //   495: invokestatic 274	com/tencent/mm/model/ad:beh	()Lcom/tencent/mm/model/ad;
    //   498: aload 8
    //   500: invokevirtual 278	com/tencent/mm/model/ad:Ro	(Ljava/lang/String;)Lcom/tencent/mm/model/ad$b;
    //   503: astore 8
    //   505: aload 8
    //   507: ifnull +56 -> 563
    //   510: aload 8
    //   512: ldc_w 280
    //   515: ldc_w 282
    //   518: invokevirtual 288	com/tencent/mm/model/ad$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   521: astore 8
    //   523: aload 8
    //   525: invokestatic 85	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   528: ifne +35 -> 563
    //   531: new 252	com/tencent/mm/protocal/protobuf/aci
    //   534: dup
    //   535: invokespecial 289	com/tencent/mm/protocal/protobuf/aci:<init>	()V
    //   538: astore 10
    //   540: aload 10
    //   542: ldc_w 280
    //   545: putfield 257	com/tencent/mm/protocal/protobuf/aci:key	Ljava/lang/String;
    //   548: aload 10
    //   550: aload 8
    //   552: putfield 266	com/tencent/mm/protocal/protobuf/aci:SnW	Ljava/lang/String;
    //   555: aload 9
    //   557: aload 10
    //   559: invokevirtual 292	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   562: pop
    //   563: aload_0
    //   564: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   567: aload_1
    //   568: getfield 296	com/tencent/mm/plugin/websearch/api/v:Pyd	Lcom/tencent/mm/protocal/protobuf/eqm;
    //   571: putfield 297	com/tencent/mm/protocal/protobuf/fln:Pyd	Lcom/tencent/mm/protocal/protobuf/eqm;
    //   574: aload_0
    //   575: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   578: aload_1
    //   579: getfield 300	com/tencent/mm/plugin/websearch/api/v:Pyf	Ljava/util/LinkedList;
    //   582: putfield 303	com/tencent/mm/protocal/protobuf/fln:UKq	Ljava/util/LinkedList;
    //   585: aload_0
    //   586: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   589: aload_1
    //   590: getfield 306	com/tencent/mm/plugin/websearch/api/v:language	Ljava/lang/String;
    //   593: putfield 309	com/tencent/mm/protocal/protobuf/fln:vhq	Ljava/lang/String;
    //   596: aload_0
    //   597: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   600: aload_1
    //   601: getfield 312	com/tencent/mm/plugin/websearch/api/v:sessionId	Ljava/lang/String;
    //   604: putfield 315	com/tencent/mm/protocal/protobuf/fln:UJX	Ljava/lang/String;
    //   607: aload_0
    //   608: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   611: astore 8
    //   613: invokestatic 320	com/tencent/mm/ui/ar:isDarkMode	()Z
    //   616: ifeq +1008 -> 1624
    //   619: iconst_1
    //   620: istore 4
    //   622: aload 8
    //   624: iload 4
    //   626: putfield 323	com/tencent/mm/protocal/protobuf/fln:TQc	I
    //   629: aload_0
    //   630: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   633: invokestatic 327	com/tencent/mm/plugin/websearch/api/ai:gQO	()Lcom/tencent/mm/protocal/protobuf/aam;
    //   636: putfield 331	com/tencent/mm/protocal/protobuf/fln:TwL	Lcom/tencent/mm/protocal/protobuf/aam;
    //   639: aload_0
    //   640: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   643: astore 9
    //   645: aload_0
    //   646: getfield 97	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   649: bipush 79
    //   651: if_icmpeq +12 -> 663
    //   654: aload_0
    //   655: getfield 97	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   658: bipush 80
    //   660: if_icmpne +1016 -> 1676
    //   663: new 333	com/tencent/mm/protocal/protobuf/eqj
    //   666: dup
    //   667: invokespecial 334	com/tencent/mm/protocal/protobuf/eqj:<init>	()V
    //   670: astore 8
    //   672: aload 8
    //   674: iconst_1
    //   675: putfield 337	com/tencent/mm/protocal/protobuf/eqj:Cqs	I
    //   678: aload_1
    //   679: getfield 340	com/tencent/mm/plugin/websearch/api/v:Pyr	Ljava/lang/String;
    //   682: astore 10
    //   684: aload 10
    //   686: invokestatic 346	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   689: ifne +987 -> 1676
    //   692: aload 10
    //   694: ldc_w 348
    //   697: invokevirtual 352	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   724: putfield 355	com/tencent/mm/protocal/protobuf/eqj:UsQ	Ljava/lang/String;
    //   727: aload 8
    //   729: aload 10
    //   731: iconst_1
    //   732: aaload
    //   733: putfield 358	com/tencent/mm/protocal/protobuf/eqj:UsT	Ljava/lang/String;
    //   736: aload 8
    //   738: aload_1
    //   739: getfield 361	com/tencent/mm/plugin/websearch/api/v:Pys	I
    //   742: putfield 364	com/tencent/mm/protocal/protobuf/eqj:UsS	I
    //   745: aload 9
    //   747: aload 8
    //   749: putfield 368	com/tencent/mm/protocal/protobuf/fln:UKw	Lcom/tencent/mm/protocal/protobuf/eqj;
    //   752: aload_1
    //   753: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   756: ifnonnull +14 -> 770
    //   759: aload_1
    //   760: new 374	com/tencent/mm/protocal/protobuf/fli
    //   763: dup
    //   764: invokespecial 375	com/tencent/mm/protocal/protobuf/fli:<init>	()V
    //   767: putfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   770: aload_1
    //   771: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   774: getfield 379	com/tencent/mm/protocal/protobuf/fli:UKh	Lcom/tencent/mm/protocal/protobuf/qn;
    //   777: ifnonnull +17 -> 794
    //   780: aload_1
    //   781: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   784: new 381	com/tencent/mm/protocal/protobuf/qn
    //   787: dup
    //   788: invokespecial 382	com/tencent/mm/protocal/protobuf/qn:<init>	()V
    //   791: putfield 379	com/tencent/mm/protocal/protobuf/fli:UKh	Lcom/tencent/mm/protocal/protobuf/qn;
    //   794: aload_1
    //   795: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   798: getfield 379	com/tencent/mm/protocal/protobuf/fli:UKh	Lcom/tencent/mm/protocal/protobuf/qn;
    //   801: astore 8
    //   803: invokestatic 388	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   806: invokevirtual 394	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   809: invokevirtual 400	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   812: getfield 405	android/util/DisplayMetrics:widthPixels	I
    //   815: istore 4
    //   817: invokestatic 410	org/xwalk/core/XWalkEnvironment:getUsingCustomContext	()Z
    //   820: ifeq +862 -> 1682
    //   823: iload 4
    //   825: i2f
    //   826: invokestatic 388	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   829: invokestatic 416	com/tencent/mm/ci/a:getDensity	(Landroid/content/Context;)F
    //   832: fdiv
    //   833: invokestatic 422	java/lang/Math:round	(F)I
    //   836: istore 4
    //   838: aload 8
    //   840: iload 4
    //   842: putfield 425	com/tencent/mm/protocal/protobuf/qn:JtF	I
    //   845: ldc 87
    //   847: ldc_w 427
    //   850: iconst_3
    //   851: anewarray 91	java/lang/Object
    //   854: dup
    //   855: iconst_0
    //   856: invokestatic 388	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   859: invokevirtual 394	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   862: invokevirtual 400	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   865: getfield 405	android/util/DisplayMetrics:widthPixels	I
    //   868: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   871: aastore
    //   872: dup
    //   873: iconst_1
    //   874: aload_1
    //   875: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   878: getfield 379	com/tencent/mm/protocal/protobuf/fli:UKh	Lcom/tencent/mm/protocal/protobuf/qn;
    //   881: getfield 425	com/tencent/mm/protocal/protobuf/qn:JtF	I
    //   884: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   887: aastore
    //   888: dup
    //   889: iconst_2
    //   890: invokestatic 388	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   893: invokevirtual 394	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   896: invokevirtual 400	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   899: getfield 437	android/util/DisplayMetrics:density	F
    //   902: invokestatic 442	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   905: aastore
    //   906: invokestatic 445	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   909: fconst_0
    //   910: fstore_3
    //   911: fconst_0
    //   912: fstore_2
    //   913: aload_0
    //   914: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   917: getfield 169	com/tencent/mm/protocal/protobuf/fln:TwK	Lcom/tencent/mm/protocal/protobuf/cqh;
    //   920: ifnull +789 -> 1709
    //   923: aload_1
    //   924: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   927: getfield 379	com/tencent/mm/protocal/protobuf/fli:UKh	Lcom/tencent/mm/protocal/protobuf/qn;
    //   930: astore 8
    //   932: invokestatic 451	com/tencent/mm/modelgeo/d:blq	()Lcom/tencent/mm/modelgeo/d;
    //   935: astore 9
    //   937: aload 9
    //   939: getfield 454	com/tencent/mm/modelgeo/d:lLH	J
    //   942: lconst_0
    //   943: lcmp
    //   944: ifle +753 -> 1697
    //   947: aload 9
    //   949: getfield 458	com/tencent/mm/modelgeo/d:lLJ	Z
    //   952: ifeq +745 -> 1697
    //   955: invokestatic 464	java/lang/System:currentTimeMillis	()J
    //   958: aload 9
    //   960: getfield 454	com/tencent/mm/modelgeo/d:lLH	J
    //   963: lsub
    //   964: ldc2_w 465
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
    //   986: putfield 469	com/tencent/mm/protocal/protobuf/qn:RYR	I
    //   989: aload_0
    //   990: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   993: getfield 169	com/tencent/mm/protocal/protobuf/fln:TwK	Lcom/tencent/mm/protocal/protobuf/cqh;
    //   996: getfield 474	com/tencent/mm/protocal/protobuf/cqh:ScO	F
    //   999: fstore_3
    //   1000: aload_0
    //   1001: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   1004: getfield 169	com/tencent/mm/protocal/protobuf/fln:TwK	Lcom/tencent/mm/protocal/protobuf/cqh;
    //   1007: getfield 477	com/tencent/mm/protocal/protobuf/cqh:ScP	F
    //   1010: fstore_2
    //   1011: ldc 87
    //   1013: ldc_w 479
    //   1016: iconst_3
    //   1017: anewarray 91	java/lang/Object
    //   1020: dup
    //   1021: iconst_0
    //   1022: fload_3
    //   1023: invokestatic 442	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1026: aastore
    //   1027: dup
    //   1028: iconst_1
    //   1029: fload_2
    //   1030: invokestatic 442	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1033: aastore
    //   1034: dup
    //   1035: iconst_2
    //   1036: aload_1
    //   1037: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   1040: getfield 379	com/tencent/mm/protocal/protobuf/fli:UKh	Lcom/tencent/mm/protocal/protobuf/qn;
    //   1043: getfield 469	com/tencent/mm/protocal/protobuf/qn:RYR	I
    //   1046: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1049: aastore
    //   1050: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1053: aload_1
    //   1054: getfield 482	com/tencent/mm/plugin/websearch/api/v:Pyj	Ljava/lang/String;
    //   1057: invokestatic 346	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1060: ifne +148 -> 1208
    //   1063: aload_1
    //   1064: getfield 482	com/tencent/mm/plugin/websearch/api/v:Pyj	Ljava/lang/String;
    //   1067: invokestatic 488	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   1070: astore 8
    //   1072: new 490	org/json/JSONObject
    //   1075: dup
    //   1076: aload 8
    //   1078: invokespecial 493	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1081: astore 8
    //   1083: new 495	com/tencent/mm/protocal/protobuf/dly
    //   1086: dup
    //   1087: invokespecial 496	com/tencent/mm/protocal/protobuf/dly:<init>	()V
    //   1090: astore 9
    //   1092: aload 9
    //   1094: aload 8
    //   1096: ldc_w 498
    //   1099: invokevirtual 501	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1102: putfield 504	com/tencent/mm/protocal/protobuf/dly:mVA	Ljava/lang/String;
    //   1105: aload 9
    //   1107: aload 8
    //   1109: ldc_w 506
    //   1112: invokevirtual 501	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1115: putfield 509	com/tencent/mm/protocal/protobuf/dly:mVH	Ljava/lang/String;
    //   1118: aload 9
    //   1120: aload 8
    //   1122: ldc_w 511
    //   1125: invokevirtual 515	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   1128: d2f
    //   1129: putfield 516	com/tencent/mm/protocal/protobuf/dly:ScP	F
    //   1132: aload 9
    //   1134: aload 8
    //   1136: ldc_w 518
    //   1139: invokevirtual 515	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   1142: d2f
    //   1143: putfield 519	com/tencent/mm/protocal/protobuf/dly:ScO	F
    //   1146: aload 9
    //   1148: aload 8
    //   1150: ldc_w 521
    //   1153: invokevirtual 501	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1156: putfield 524	com/tencent/mm/protocal/protobuf/dly:TSU	Ljava/lang/String;
    //   1159: aload 9
    //   1161: aload 8
    //   1163: ldc_w 526
    //   1166: invokevirtual 501	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1169: putfield 529	com/tencent/mm/protocal/protobuf/dly:TrY	Ljava/lang/String;
    //   1172: aload 9
    //   1174: aload 8
    //   1176: ldc_w 531
    //   1179: invokevirtual 501	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1182: invokestatic 535	com/tencent/mm/plugin/websearch/api/ai:biM	(Ljava/lang/String;)J
    //   1185: putfield 538	com/tencent/mm/protocal/protobuf/dly:TSW	J
    //   1188: aload 9
    //   1190: getfield 524	com/tencent/mm/protocal/protobuf/dly:TSU	Ljava/lang/String;
    //   1193: invokestatic 346	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1196: ifne +12 -> 1208
    //   1199: aload_0
    //   1200: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   1203: aload 9
    //   1205: putfield 542	com/tencent/mm/protocal/protobuf/fln:UKv	Lcom/tencent/mm/protocal/protobuf/dly;
    //   1208: aload_1
    //   1209: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   1212: ifnull +96 -> 1308
    //   1215: aload_1
    //   1216: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   1219: ldc_w 544
    //   1222: invokestatic 550	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1225: checkcast 544	com/tencent/mm/plugin/appbrand/service/j
    //   1228: invokeinterface 554 1 0
    //   1233: putfield 557	com/tencent/mm/protocal/protobuf/fli:UKi	I
    //   1236: aload_0
    //   1237: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   1240: new 559	com/tencent/mm/cd/b
    //   1243: dup
    //   1244: aload_1
    //   1245: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   1248: invokevirtual 563	com/tencent/mm/protocal/protobuf/fli:toByteArray	()[B
    //   1251: invokespecial 566	com/tencent/mm/cd/b:<init>	([B)V
    //   1254: putfield 570	com/tencent/mm/protocal/protobuf/fln:UKs	Lcom/tencent/mm/cd/b;
    //   1257: ldc 87
    //   1259: ldc_w 572
    //   1262: iconst_3
    //   1263: anewarray 91	java/lang/Object
    //   1266: dup
    //   1267: iconst_0
    //   1268: aload_1
    //   1269: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   1272: getfield 575	com/tencent/mm/protocal/protobuf/fli:UKg	J
    //   1275: invokestatic 580	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1278: aastore
    //   1279: dup
    //   1280: iconst_1
    //   1281: aload_1
    //   1282: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   1285: getfield 379	com/tencent/mm/protocal/protobuf/fli:UKh	Lcom/tencent/mm/protocal/protobuf/qn;
    //   1288: getfield 583	com/tencent/mm/protocal/protobuf/qn:appid	Ljava/lang/String;
    //   1291: aastore
    //   1292: dup
    //   1293: iconst_2
    //   1294: aload_1
    //   1295: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   1298: getfield 379	com/tencent/mm/protocal/protobuf/fli:UKh	Lcom/tencent/mm/protocal/protobuf/qn;
    //   1301: getfield 586	com/tencent/mm/protocal/protobuf/qn:ugq	Ljava/lang/String;
    //   1304: aastore
    //   1305: invokestatic 445	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1308: aload_1
    //   1309: getfield 590	com/tencent/mm/plugin/websearch/api/v:Pyh	Lcom/tencent/mm/protocal/protobuf/fpm;
    //   1312: ifnull +24 -> 1336
    //   1315: aload_0
    //   1316: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   1319: new 559	com/tencent/mm/cd/b
    //   1322: dup
    //   1323: aload_1
    //   1324: getfield 590	com/tencent/mm/plugin/websearch/api/v:Pyh	Lcom/tencent/mm/protocal/protobuf/fpm;
    //   1327: invokevirtual 593	com/tencent/mm/protocal/protobuf/fpm:toByteArray	()[B
    //   1330: invokespecial 566	com/tencent/mm/cd/b:<init>	([B)V
    //   1333: putfield 596	com/tencent/mm/protocal/protobuf/fln:UKr	Lcom/tencent/mm/cd/b;
    //   1336: aload_0
    //   1337: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   1340: getfield 169	com/tencent/mm/protocal/protobuf/fln:TwK	Lcom/tencent/mm/protocal/protobuf/cqh;
    //   1343: ifnull +399 -> 1742
    //   1346: iconst_1
    //   1347: istore 6
    //   1349: ldc 87
    //   1351: ldc_w 598
    //   1354: bipush 7
    //   1356: anewarray 91	java/lang/Object
    //   1359: dup
    //   1360: iconst_0
    //   1361: iload 6
    //   1363: invokestatic 603	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1366: aastore
    //   1367: dup
    //   1368: iconst_1
    //   1369: aload_1
    //   1370: getfield 183	com/tencent/mm/plugin/websearch/api/v:PxV	Ljava/util/LinkedList;
    //   1373: invokevirtual 606	java/util/LinkedList:size	()I
    //   1376: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1379: aastore
    //   1380: dup
    //   1381: iconst_2
    //   1382: aload_1
    //   1383: getfield 60	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   1386: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1389: aastore
    //   1390: dup
    //   1391: iconst_3
    //   1392: aload_1
    //   1393: getfield 155	com/tencent/mm/plugin/websearch/api/v:businessType	I
    //   1396: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1399: aastore
    //   1400: dup
    //   1401: iconst_4
    //   1402: aload_0
    //   1403: getfield 72	com/tencent/mm/plugin/webview/fts/f:PxU	I
    //   1406: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1409: aastore
    //   1410: dup
    //   1411: iconst_5
    //   1412: aload_1
    //   1413: getfield 198	com/tencent/mm/plugin/websearch/api/v:fPw	I
    //   1416: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1419: aastore
    //   1420: dup
    //   1421: bipush 6
    //   1423: aload_1
    //   1424: getfield 66	com/tencent/mm/plugin/websearch/api/v:fPp	I
    //   1427: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1430: aastore
    //   1431: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1434: aload_0
    //   1435: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   1438: getfield 169	com/tencent/mm/protocal/protobuf/fln:TwK	Lcom/tencent/mm/protocal/protobuf/cqh;
    //   1441: ifnull +39 -> 1480
    //   1444: sipush 2005
    //   1447: aload_0
    //   1448: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   1451: getfield 169	com/tencent/mm/protocal/protobuf/fln:TwK	Lcom/tencent/mm/protocal/protobuf/cqh;
    //   1454: getfield 474	com/tencent/mm/protocal/protobuf/cqh:ScO	F
    //   1457: aload_0
    //   1458: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   1461: getfield 169	com/tencent/mm/protocal/protobuf/fln:TwK	Lcom/tencent/mm/protocal/protobuf/cqh;
    //   1464: getfield 477	com/tencent/mm/protocal/protobuf/cqh:ScP	F
    //   1467: aload_0
    //   1468: getfield 146	com/tencent/mm/plugin/webview/fts/f:PxP	Lcom/tencent/mm/protocal/protobuf/fln;
    //   1471: getfield 169	com/tencent/mm/protocal/protobuf/fln:TwK	Lcom/tencent/mm/protocal/protobuf/cqh;
    //   1474: getfield 609	com/tencent/mm/protocal/protobuf/cqh:Sxt	I
    //   1477: invokestatic 615	com/tencent/mm/modelstat/n:a	(IFFI)V
    //   1480: aload_1
    //   1481: getfield 60	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   1484: istore 4
    //   1486: aload_1
    //   1487: getfield 312	com/tencent/mm/plugin/websearch/api/v:sessionId	Ljava/lang/String;
    //   1490: astore 8
    //   1492: aload_1
    //   1493: getfield 618	com/tencent/mm/plugin/websearch/api/v:fPs	Ljava/lang/String;
    //   1496: astore 9
    //   1498: aload_1
    //   1499: getfield 192	com/tencent/mm/plugin/websearch/api/v:uMC	Ljava/lang/String;
    //   1502: astore 10
    //   1504: aload_1
    //   1505: getfield 55	com/tencent/mm/plugin/websearch/api/v:offset	I
    //   1508: istore 5
    //   1510: aload_1
    //   1511: getfield 71	com/tencent/mm/plugin/websearch/api/v:PxU	I
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
    //   1535: getfield 49	com/tencent/mm/plugin/websearch/api/v:fIY	Ljava/lang/String;
    //   1538: aload_1
    //   1539: getfield 43	com/tencent/mm/plugin/websearch/api/v:fwe	Ljava/lang/String;
    //   1542: aload_1
    //   1543: getfield 155	com/tencent/mm/plugin/websearch/api/v:businessType	I
    //   1546: invokestatic 623	com/tencent/mm/plugin/websearch/api/ah:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;I)V
    //   1549: ldc 29
    //   1551: invokestatic 626	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1554: return
    //   1555: iconst_0
    //   1556: istore 4
    //   1558: goto -1414 -> 144
    //   1561: aload_1
    //   1562: getfield 629	com/tencent/mm/plugin/websearch/api/v:Pyn	I
    //   1565: iconst_1
    //   1566: if_icmpne +19 -> 1585
    //   1569: aload 9
    //   1571: sipush 1011
    //   1574: putfield 106	com/tencent/mm/an/d$a:funcId	I
    //   1577: ldc_w 631
    //   1580: astore 8
    //   1582: goto -1421 -> 161
    //   1585: aload_1
    //   1586: getfield 634	com/tencent/mm/plugin/websearch/api/v:Pyo	Z
    //   1589: ifeq +19 -> 1608
    //   1592: aload 9
    //   1594: sipush 4858
    //   1597: putfield 106	com/tencent/mm/an/d$a:funcId	I
    //   1600: ldc_w 636
    //   1603: astore 8
    //   1605: goto -1444 -> 161
    //   1608: aload 9
    //   1610: sipush 719
    //   1613: putfield 106	com/tencent/mm/an/d$a:funcId	I
    //   1616: ldc_w 638
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
    //   1652: putfield 355	com/tencent/mm/protocal/protobuf/eqj:UsQ	Ljava/lang/String;
    //   1655: aload 8
    //   1657: aload 10
    //   1659: iconst_1
    //   1660: aaload
    //   1661: putfield 358	com/tencent/mm/protocal/protobuf/eqj:UsT	Ljava/lang/String;
    //   1664: aload 8
    //   1666: aload 10
    //   1668: iconst_2
    //   1669: aaload
    //   1670: putfield 641	com/tencent/mm/protocal/protobuf/eqj:UsR	Ljava/lang/String;
    //   1673: goto -937 -> 736
    //   1676: aconst_null
    //   1677: astore 8
    //   1679: goto -934 -> 745
    //   1682: iload 4
    //   1684: i2f
    //   1685: invokestatic 647	com/tencent/mm/cj/a:hrl	()F
    //   1688: fdiv
    //   1689: invokestatic 422	java/lang/Math:round	(F)I
    //   1692: istore 4
    //   1694: goto -856 -> 838
    //   1697: iconst_0
    //   1698: istore 4
    //   1700: goto -726 -> 974
    //   1703: iconst_1
    //   1704: istore 4
    //   1706: goto -724 -> 982
    //   1709: aload_1
    //   1710: getfield 372	com/tencent/mm/plugin/websearch/api/v:Pyi	Lcom/tencent/mm/protocal/protobuf/fli;
    //   1713: getfield 379	com/tencent/mm/protocal/protobuf/fli:UKh	Lcom/tencent/mm/protocal/protobuf/qn;
    //   1716: iconst_1
    //   1717: putfield 469	com/tencent/mm/protocal/protobuf/qn:RYR	I
    //   1720: goto -709 -> 1011
    //   1723: astore 8
    //   1725: ldc 87
    //   1727: aload 8
    //   1729: ldc_w 282
    //   1732: iconst_0
    //   1733: anewarray 91	java/lang/Object
    //   1736: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1739: goto -531 -> 1208
    //   1742: iconst_0
    //   1743: istore 6
    //   1745: goto -396 -> 1349
    //   1748: iconst_0
    //   1749: istore 6
    //   1751: goto -229 -> 1522
    //   1754: ldc 87
    //   1756: ldc_w 653
    //   1759: invokestatic 657	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1762: ldc 29
    //   1764: invokestatic 626	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void bV(LinkedList<ezc> paramLinkedList)
  {
    AppMethodBeat.i(77933);
    this.PxP.UgB = paramLinkedList;
    ejr localejr = new ejr();
    localejr.UlH = paramLinkedList.size();
    this.PxP.UKt = localejr;
    AppMethodBeat.o(77933);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(77931);
    ar.ls(this.scene, 2);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(77931);
    return i;
  }
  
  public final String gQp()
  {
    if (this.PxQ != null) {
      return this.PxQ.Tkw;
    }
    return "";
  }
  
  public final int gQq()
  {
    if (this.PxQ != null) {
      return this.PxQ.UKc;
    }
    return 0;
  }
  
  public final int getType()
  {
    if ((this.PxJ.scene == 201) || (this.PxJ.Pyg == 1)) {
      return 2676;
    }
    if (this.PxJ.Pyn == 1) {
      return 1011;
    }
    if (this.PxJ.Pyo) {
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
      paramInt1 = this.PxJ.scene;
      paramString = this.PxJ.sessionId;
      params = this.PxJ.fPs;
      paramArrayOfByte = this.PxJ.uMC;
      i = this.PxJ.offset;
      if (this.PxJ.PxU != 1) {
        break label194;
      }
    }
    label194:
    for (boolean bool2 = true;; bool2 = false)
    {
      ah.a(paramInt1, paramString, params, paramArrayOfByte, i, bool2, this.PxJ.fIY, bool1, this.PxJ.fwe, this.PxJ.businessType);
      ar.aO(this.scene, paramInt2, paramInt3);
      AppMethodBeat.o(77932);
      return;
      bool1 = false;
      break;
    }
    label200:
    this.PxQ = ((flo)d.c.b(this.lKU.lBS));
    String str;
    if (this.PxQ != null)
    {
      paramInt1 = this.PxJ.scene;
      params = this.PxJ.sessionId;
      paramArrayOfByte = this.PxJ.fPs;
      str = this.PxJ.uMC;
      i = this.PxJ.offset;
      if (this.PxJ.PxU != 1) {
        break label371;
      }
    }
    label371:
    for (bool2 = true;; bool2 = false)
    {
      ah.a(paramInt1, params, paramArrayOfByte, str, i, bool2, this.PxJ.fIY, bool1, this.PxJ.fwe, this.PxJ.businessType);
      Log.v("MicroMsg.WebSearch.NetSceneWebSearch", "return data\n%s", new Object[] { this.PxQ.Tkw });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ar.aO(this.scene, paramInt2, paramInt3);
      AppMethodBeat.o(77932);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.f
 * JD-Core Version:    0.7.0.1
 */