package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.protocal.protobuf.duv;
import com.tencent.mm.protocal.protobuf.egi;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class f
  extends a
  implements k
{
  private int DSW;
  private s DTs;
  private egj Ecp;
  private egi Ecq;
  private com.tencent.mm.ak.f callback;
  private b hZD;
  private int scene;
  
  /* Error */
  public f(s params)
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
    //   14: putfield 37	com/tencent/mm/plugin/webview/fts/f:DTs	Lcom/tencent/mm/plugin/websearch/api/s;
    //   17: aload_0
    //   18: aload_1
    //   19: getfield 43	com/tencent/mm/plugin/websearch/api/s:dmf	Ljava/lang/String;
    //   22: putfield 46	com/tencent/mm/plugin/webview/fts/f:uaV	Ljava/lang/String;
    //   25: aload_0
    //   26: aload_1
    //   27: getfield 49	com/tencent/mm/plugin/websearch/api/s:dyb	Ljava/lang/String;
    //   30: putfield 52	com/tencent/mm/plugin/webview/fts/f:dEc	Ljava/lang/String;
    //   33: aload_0
    //   34: aload_1
    //   35: getfield 55	com/tencent/mm/plugin/websearch/api/s:offset	I
    //   38: putfield 58	com/tencent/mm/plugin/webview/fts/f:fq	I
    //   41: aload_0
    //   42: aload_1
    //   43: getfield 60	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   46: putfield 63	com/tencent/mm/plugin/webview/fts/f:mScene	I
    //   49: aload_0
    //   50: aload_1
    //   51: getfield 66	com/tencent/mm/plugin/websearch/api/s:dDY	I
    //   54: putfield 69	com/tencent/mm/plugin/webview/fts/f:DSQ	I
    //   57: aload_0
    //   58: aload_1
    //   59: getfield 71	com/tencent/mm/plugin/websearch/api/s:DSW	I
    //   62: putfield 72	com/tencent/mm/plugin/webview/fts/f:DSW	I
    //   65: aload_0
    //   66: aload_1
    //   67: putfield 37	com/tencent/mm/plugin/webview/fts/f:DTs	Lcom/tencent/mm/plugin/websearch/api/s;
    //   70: aload_0
    //   71: aload_1
    //   72: getfield 76	com/tencent/mm/plugin/websearch/api/s:yzF	Landroid/os/Bundle;
    //   75: putfield 79	com/tencent/mm/plugin/webview/fts/f:DSR	Landroid/os/Bundle;
    //   78: aload_1
    //   79: getfield 43	com/tencent/mm/plugin/websearch/api/s:dmf	Ljava/lang/String;
    //   82: invokestatic 85	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   85: ifne +1457 -> 1542
    //   88: ldc 87
    //   90: ldc 89
    //   92: iconst_1
    //   93: anewarray 91	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_1
    //   99: getfield 43	com/tencent/mm/plugin/websearch/api/s:dmf	Ljava/lang/String;
    //   102: aastore
    //   103: invokestatic 96	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: aload_1
    //   108: getfield 60	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   111: putfield 97	com/tencent/mm/plugin/webview/fts/f:scene	I
    //   114: new 99	com/tencent/mm/ak/b$a
    //   117: dup
    //   118: invokespecial 100	com/tencent/mm/ak/b$a:<init>	()V
    //   121: astore 8
    //   123: aload_1
    //   124: getfield 60	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   127: sipush 201
    //   130: if_icmpeq +11 -> 141
    //   133: aload_1
    //   134: getfield 103	com/tencent/mm/plugin/websearch/api/s:DTi	I
    //   137: iconst_1
    //   138: if_icmpne +1274 -> 1412
    //   141: iconst_1
    //   142: istore 4
    //   144: iload 4
    //   146: ifeq +1272 -> 1418
    //   149: aload 8
    //   151: sipush 2676
    //   154: putfield 106	com/tencent/mm/ak/b$a:funcId	I
    //   157: aload 8
    //   159: ldc 108
    //   161: putfield 111	com/tencent/mm/ak/b$a:uri	Ljava/lang/String;
    //   164: aload 8
    //   166: new 113	com/tencent/mm/protocal/protobuf/egi
    //   169: dup
    //   170: invokespecial 114	com/tencent/mm/protocal/protobuf/egi:<init>	()V
    //   173: putfield 118	com/tencent/mm/ak/b$a:hQF	Lcom/tencent/mm/bw/a;
    //   176: aload 8
    //   178: new 120	com/tencent/mm/protocal/protobuf/egj
    //   181: dup
    //   182: invokespecial 121	com/tencent/mm/protocal/protobuf/egj:<init>	()V
    //   185: putfield 124	com/tencent/mm/ak/b$a:hQG	Lcom/tencent/mm/bw/a;
    //   188: aload_0
    //   189: aload 8
    //   191: invokevirtual 128	com/tencent/mm/ak/b$a:aDS	()Lcom/tencent/mm/ak/b;
    //   194: putfield 130	com/tencent/mm/plugin/webview/fts/f:hZD	Lcom/tencent/mm/ak/b;
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 130	com/tencent/mm/plugin/webview/fts/f:hZD	Lcom/tencent/mm/ak/b;
    //   202: getfield 136	com/tencent/mm/ak/b:hQD	Lcom/tencent/mm/ak/b$b;
    //   205: getfield 141	com/tencent/mm/ak/b$b:hQJ	Lcom/tencent/mm/bw/a;
    //   208: checkcast 113	com/tencent/mm/protocal/protobuf/egi
    //   211: putfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   214: aload_0
    //   215: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   218: aload_1
    //   219: getfield 43	com/tencent/mm/plugin/websearch/api/s:dmf	Ljava/lang/String;
    //   222: putfield 146	com/tencent/mm/protocal/protobuf/egi:GLP	Ljava/lang/String;
    //   225: aload_0
    //   226: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   229: aload_1
    //   230: getfield 71	com/tencent/mm/plugin/websearch/api/s:DSW	I
    //   233: putfield 149	com/tencent/mm/protocal/protobuf/egi:HFR	I
    //   236: aload_0
    //   237: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   240: aload_1
    //   241: getfield 152	com/tencent/mm/plugin/websearch/api/s:businessType	I
    //   244: i2l
    //   245: putfield 156	com/tencent/mm/protocal/protobuf/egi:GeP	J
    //   248: aload_0
    //   249: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   252: invokestatic 162	com/tencent/mm/plugin/websearch/api/ad:bOD	()Lcom/tencent/mm/protocal/protobuf/buh;
    //   255: putfield 166	com/tencent/mm/protocal/protobuf/egi:HkU	Lcom/tencent/mm/protocal/protobuf/buh;
    //   258: aload_0
    //   259: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   262: aload_1
    //   263: getfield 55	com/tencent/mm/plugin/websearch/api/s:offset	I
    //   266: putfield 169	com/tencent/mm/protocal/protobuf/egi:GeT	I
    //   269: aload_0
    //   270: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   273: iconst_0
    //   274: invokestatic 173	com/tencent/mm/plugin/websearch/api/ad:WL	(I)I
    //   277: putfield 176	com/tencent/mm/protocal/protobuf/egi:IjW	I
    //   280: aload_0
    //   281: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   284: aload_1
    //   285: getfield 180	com/tencent/mm/plugin/websearch/api/s:DSX	Ljava/util/LinkedList;
    //   288: putfield 183	com/tencent/mm/protocal/protobuf/egi:HIX	Ljava/util/LinkedList;
    //   291: aload_0
    //   292: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   295: aload_1
    //   296: getfield 60	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   299: putfield 186	com/tencent/mm/protocal/protobuf/egi:Scene	I
    //   302: aload_0
    //   303: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   306: aload_1
    //   307: getfield 189	com/tencent/mm/plugin/websearch/api/s:pSq	Ljava/lang/String;
    //   310: putfield 192	com/tencent/mm/protocal/protobuf/egi:GeS	Ljava/lang/String;
    //   313: aload_0
    //   314: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   317: aload_1
    //   318: getfield 195	com/tencent/mm/plugin/websearch/api/s:dEf	I
    //   321: putfield 198	com/tencent/mm/protocal/protobuf/egi:HFV	I
    //   324: aload_0
    //   325: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   328: aload_1
    //   329: getfield 201	com/tencent/mm/plugin/websearch/api/s:DSY	Ljava/lang/String;
    //   332: putfield 204	com/tencent/mm/protocal/protobuf/egi:IjX	Ljava/lang/String;
    //   335: aload_0
    //   336: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   339: aload_1
    //   340: getfield 207	com/tencent/mm/plugin/websearch/api/s:DTa	I
    //   343: putfield 210	com/tencent/mm/protocal/protobuf/egi:IjZ	I
    //   346: aload_0
    //   347: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   350: aload_1
    //   351: getfield 213	com/tencent/mm/plugin/websearch/api/s:DSZ	Ljava/lang/String;
    //   354: putfield 216	com/tencent/mm/protocal/protobuf/egi:IjY	Ljava/lang/String;
    //   357: aload_0
    //   358: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   361: aload_1
    //   362: getfield 219	com/tencent/mm/plugin/websearch/api/s:DTb	Ljava/util/LinkedList;
    //   365: putfield 222	com/tencent/mm/protocal/protobuf/egi:Ika	Ljava/util/LinkedList;
    //   368: aload_0
    //   369: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   372: aload_1
    //   373: getfield 225	com/tencent/mm/plugin/websearch/api/s:DTg	Ljava/util/LinkedList;
    //   376: putfield 228	com/tencent/mm/protocal/protobuf/egi:Iiw	Ljava/util/LinkedList;
    //   379: aload_0
    //   380: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   383: getfield 228	com/tencent/mm/protocal/protobuf/egi:Iiw	Ljava/util/LinkedList;
    //   386: astore 9
    //   388: aload 9
    //   390: invokestatic 232	com/tencent/mm/sdk/platformtools/bu:ht	(Ljava/util/List;)Z
    //   393: ifne +150 -> 543
    //   396: aload 9
    //   398: invokevirtual 238	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   401: astore 8
    //   403: aload 8
    //   405: invokeinterface 244 1 0
    //   410: ifeq +1156 -> 1566
    //   413: aload 8
    //   415: invokeinterface 248 1 0
    //   420: checkcast 250	com/tencent/mm/protocal/protobuf/aaj
    //   423: astore 10
    //   425: aload 10
    //   427: ifnull -24 -> 403
    //   430: ldc 252
    //   432: aload 10
    //   434: getfield 255	com/tencent/mm/protocal/protobuf/aaj:key	Ljava/lang/String;
    //   437: invokevirtual 261	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   440: ifeq -37 -> 403
    //   443: aload 10
    //   445: getfield 264	com/tencent/mm/protocal/protobuf/aaj:GrF	Ljava/lang/String;
    //   448: astore 8
    //   450: ldc 87
    //   452: ldc_w 266
    //   455: iconst_1
    //   456: anewarray 91	java/lang/Object
    //   459: dup
    //   460: iconst_0
    //   461: aload 8
    //   463: aastore
    //   464: invokestatic 96	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   467: aload 8
    //   469: invokestatic 85	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   472: ifne +71 -> 543
    //   475: invokestatic 272	com/tencent/mm/model/z:aBG	()Lcom/tencent/mm/model/z;
    //   478: aload 8
    //   480: invokevirtual 276	com/tencent/mm/model/z:Bq	(Ljava/lang/String;)Lcom/tencent/mm/model/z$b;
    //   483: astore 8
    //   485: aload 8
    //   487: ifnull +56 -> 543
    //   490: aload 8
    //   492: ldc_w 278
    //   495: ldc_w 280
    //   498: invokevirtual 286	com/tencent/mm/model/z$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   501: astore 8
    //   503: aload 8
    //   505: invokestatic 85	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   508: ifne +35 -> 543
    //   511: new 250	com/tencent/mm/protocal/protobuf/aaj
    //   514: dup
    //   515: invokespecial 287	com/tencent/mm/protocal/protobuf/aaj:<init>	()V
    //   518: astore 10
    //   520: aload 10
    //   522: ldc_w 278
    //   525: putfield 255	com/tencent/mm/protocal/protobuf/aaj:key	Ljava/lang/String;
    //   528: aload 10
    //   530: aload 8
    //   532: putfield 264	com/tencent/mm/protocal/protobuf/aaj:GrF	Ljava/lang/String;
    //   535: aload 9
    //   537: aload 10
    //   539: invokevirtual 290	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   542: pop
    //   543: aload_0
    //   544: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   547: aload_1
    //   548: getfield 294	com/tencent/mm/plugin/websearch/api/s:DTf	Lcom/tencent/mm/protocal/protobuf/dmu;
    //   551: putfield 295	com/tencent/mm/protocal/protobuf/egi:DTf	Lcom/tencent/mm/protocal/protobuf/dmu;
    //   554: aload_0
    //   555: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   558: aload_1
    //   559: getfield 298	com/tencent/mm/plugin/websearch/api/s:DTh	Ljava/util/LinkedList;
    //   562: putfield 301	com/tencent/mm/protocal/protobuf/egi:Ikb	Ljava/util/LinkedList;
    //   565: aload_0
    //   566: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   569: aload_1
    //   570: getfield 304	com/tencent/mm/plugin/websearch/api/s:language	Ljava/lang/String;
    //   573: putfield 307	com/tencent/mm/protocal/protobuf/egi:qkN	Ljava/lang/String;
    //   576: aload_0
    //   577: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   580: aload_1
    //   581: getfield 310	com/tencent/mm/plugin/websearch/api/s:sessionId	Ljava/lang/String;
    //   584: putfield 313	com/tencent/mm/protocal/protobuf/egi:IjI	Ljava/lang/String;
    //   587: aload_0
    //   588: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   591: astore 8
    //   593: invokestatic 318	com/tencent/mm/ui/al:isDarkMode	()Z
    //   596: ifeq +868 -> 1464
    //   599: iconst_1
    //   600: istore 4
    //   602: aload 8
    //   604: iload 4
    //   606: putfield 321	com/tencent/mm/protocal/protobuf/egi:Hvv	I
    //   609: aload_1
    //   610: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   613: ifnonnull +14 -> 627
    //   616: aload_1
    //   617: new 327	com/tencent/mm/protocal/protobuf/ege
    //   620: dup
    //   621: invokespecial 328	com/tencent/mm/protocal/protobuf/ege:<init>	()V
    //   624: putfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   627: aload_1
    //   628: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   631: getfield 332	com/tencent/mm/protocal/protobuf/ege:IjS	Lcom/tencent/mm/protocal/protobuf/pt;
    //   634: ifnonnull +17 -> 651
    //   637: aload_1
    //   638: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   641: new 334	com/tencent/mm/protocal/protobuf/pt
    //   644: dup
    //   645: invokespecial 335	com/tencent/mm/protocal/protobuf/pt:<init>	()V
    //   648: putfield 332	com/tencent/mm/protocal/protobuf/ege:IjS	Lcom/tencent/mm/protocal/protobuf/pt;
    //   651: aload_1
    //   652: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   655: getfield 332	com/tencent/mm/protocal/protobuf/ege:IjS	Lcom/tencent/mm/protocal/protobuf/pt;
    //   658: astore 8
    //   660: invokestatic 341	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   663: invokevirtual 347	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   666: invokevirtual 353	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   669: getfield 358	android/util/DisplayMetrics:widthPixels	I
    //   672: istore 4
    //   674: invokestatic 363	org/xwalk/core/XWalkEnvironment:getUsingCustomContext	()Z
    //   677: ifeq +793 -> 1470
    //   680: iload 4
    //   682: i2f
    //   683: invokestatic 341	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   686: invokestatic 369	com/tencent/mm/cb/a:getDensity	(Landroid/content/Context;)F
    //   689: fdiv
    //   690: invokestatic 375	java/lang/Math:round	(F)I
    //   693: istore 4
    //   695: aload 8
    //   697: iload 4
    //   699: putfield 378	com/tencent/mm/protocal/protobuf/pt:zjj	I
    //   702: ldc 87
    //   704: ldc_w 380
    //   707: iconst_3
    //   708: anewarray 91	java/lang/Object
    //   711: dup
    //   712: iconst_0
    //   713: invokestatic 341	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   716: invokevirtual 347	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   719: invokevirtual 353	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   722: getfield 358	android/util/DisplayMetrics:widthPixels	I
    //   725: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   728: aastore
    //   729: dup
    //   730: iconst_1
    //   731: aload_1
    //   732: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   735: getfield 332	com/tencent/mm/protocal/protobuf/ege:IjS	Lcom/tencent/mm/protocal/protobuf/pt;
    //   738: getfield 378	com/tencent/mm/protocal/protobuf/pt:zjj	I
    //   741: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   744: aastore
    //   745: dup
    //   746: iconst_2
    //   747: invokestatic 341	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   750: invokevirtual 347	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   753: invokevirtual 353	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   756: getfield 390	android/util/DisplayMetrics:density	F
    //   759: invokestatic 395	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   762: aastore
    //   763: invokestatic 398	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   766: fconst_0
    //   767: fstore_3
    //   768: fconst_0
    //   769: fstore_2
    //   770: aload_0
    //   771: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   774: getfield 166	com/tencent/mm/protocal/protobuf/egi:HkU	Lcom/tencent/mm/protocal/protobuf/buh;
    //   777: ifnull +720 -> 1497
    //   780: aload_1
    //   781: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   784: getfield 332	com/tencent/mm/protocal/protobuf/ege:IjS	Lcom/tencent/mm/protocal/protobuf/pt;
    //   787: astore 8
    //   789: invokestatic 404	com/tencent/mm/modelgeo/d:aIh	()Lcom/tencent/mm/modelgeo/d;
    //   792: astore 9
    //   794: aload 9
    //   796: getfield 407	com/tencent/mm/modelgeo/d:iap	J
    //   799: lconst_0
    //   800: lcmp
    //   801: ifle +684 -> 1485
    //   804: aload 9
    //   806: getfield 411	com/tencent/mm/modelgeo/d:iar	Z
    //   809: ifeq +676 -> 1485
    //   812: invokestatic 417	java/lang/System:currentTimeMillis	()J
    //   815: aload 9
    //   817: getfield 407	com/tencent/mm/modelgeo/d:iap	J
    //   820: lsub
    //   821: ldc2_w 418
    //   824: lcmp
    //   825: ifge +660 -> 1485
    //   828: iconst_1
    //   829: istore 4
    //   831: iload 4
    //   833: ifeq +658 -> 1491
    //   836: iconst_0
    //   837: istore 4
    //   839: aload 8
    //   841: iload 4
    //   843: putfield 422	com/tencent/mm/protocal/protobuf/pt:Gdr	I
    //   846: aload_0
    //   847: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   850: getfield 166	com/tencent/mm/protocal/protobuf/egi:HkU	Lcom/tencent/mm/protocal/protobuf/buh;
    //   853: getfield 427	com/tencent/mm/protocal/protobuf/buh:GgZ	F
    //   856: fstore_3
    //   857: aload_0
    //   858: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   861: getfield 166	com/tencent/mm/protocal/protobuf/egi:HkU	Lcom/tencent/mm/protocal/protobuf/buh;
    //   864: getfield 430	com/tencent/mm/protocal/protobuf/buh:Gha	F
    //   867: fstore_2
    //   868: ldc 87
    //   870: ldc_w 432
    //   873: iconst_3
    //   874: anewarray 91	java/lang/Object
    //   877: dup
    //   878: iconst_0
    //   879: fload_3
    //   880: invokestatic 395	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   883: aastore
    //   884: dup
    //   885: iconst_1
    //   886: fload_2
    //   887: invokestatic 395	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   890: aastore
    //   891: dup
    //   892: iconst_2
    //   893: aload_1
    //   894: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   897: getfield 332	com/tencent/mm/protocal/protobuf/ege:IjS	Lcom/tencent/mm/protocal/protobuf/pt;
    //   900: getfield 422	com/tencent/mm/protocal/protobuf/pt:Gdr	I
    //   903: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   906: aastore
    //   907: invokestatic 96	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   910: aload_1
    //   911: getfield 435	com/tencent/mm/plugin/websearch/api/s:DTl	Ljava/lang/String;
    //   914: invokestatic 441	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   917: ifne +148 -> 1065
    //   920: aload_1
    //   921: getfield 435	com/tencent/mm/plugin/websearch/api/s:DTl	Ljava/lang/String;
    //   924: invokestatic 447	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   927: astore 8
    //   929: new 449	org/json/JSONObject
    //   932: dup
    //   933: aload 8
    //   935: invokespecial 452	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   938: astore 8
    //   940: new 454	com/tencent/mm/protocal/protobuf/clp
    //   943: dup
    //   944: invokespecial 455	com/tencent/mm/protocal/protobuf/clp:<init>	()V
    //   947: astore 9
    //   949: aload 9
    //   951: aload 8
    //   953: ldc_w 457
    //   956: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   959: putfield 463	com/tencent/mm/protocal/protobuf/clp:jfX	Ljava/lang/String;
    //   962: aload 9
    //   964: aload 8
    //   966: ldc_w 465
    //   969: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   972: putfield 468	com/tencent/mm/protocal/protobuf/clp:jge	Ljava/lang/String;
    //   975: aload 9
    //   977: aload 8
    //   979: ldc_w 470
    //   982: invokevirtual 474	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   985: d2f
    //   986: putfield 475	com/tencent/mm/protocal/protobuf/clp:Gha	F
    //   989: aload 9
    //   991: aload 8
    //   993: ldc_w 477
    //   996: invokevirtual 474	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   999: d2f
    //   1000: putfield 478	com/tencent/mm/protocal/protobuf/clp:GgZ	F
    //   1003: aload 9
    //   1005: aload 8
    //   1007: ldc_w 480
    //   1010: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1013: putfield 483	com/tencent/mm/protocal/protobuf/clp:HxI	Ljava/lang/String;
    //   1016: aload 9
    //   1018: aload 8
    //   1020: ldc_w 485
    //   1023: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1026: putfield 488	com/tencent/mm/protocal/protobuf/clp:Hdi	Ljava/lang/String;
    //   1029: aload 9
    //   1031: aload 8
    //   1033: ldc_w 490
    //   1036: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1039: invokestatic 494	com/tencent/mm/plugin/websearch/api/ad:aHg	(Ljava/lang/String;)J
    //   1042: putfield 497	com/tencent/mm/protocal/protobuf/clp:HxK	J
    //   1045: aload 9
    //   1047: getfield 483	com/tencent/mm/protocal/protobuf/clp:HxI	Ljava/lang/String;
    //   1050: invokestatic 441	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1053: ifne +12 -> 1065
    //   1056: aload_0
    //   1057: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   1060: aload 9
    //   1062: putfield 501	com/tencent/mm/protocal/protobuf/egi:Ikg	Lcom/tencent/mm/protocal/protobuf/clp;
    //   1065: aload_1
    //   1066: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   1069: ifnull +96 -> 1165
    //   1072: aload_1
    //   1073: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   1076: ldc_w 503
    //   1079: invokestatic 509	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1082: checkcast 503	com/tencent/mm/plugin/appbrand/service/i
    //   1085: invokeinterface 513 1 0
    //   1090: putfield 516	com/tencent/mm/protocal/protobuf/ege:IjT	I
    //   1093: aload_0
    //   1094: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   1097: new 518	com/tencent/mm/bw/b
    //   1100: dup
    //   1101: aload_1
    //   1102: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   1105: invokevirtual 522	com/tencent/mm/protocal/protobuf/ege:toByteArray	()[B
    //   1108: invokespecial 525	com/tencent/mm/bw/b:<init>	([B)V
    //   1111: putfield 529	com/tencent/mm/protocal/protobuf/egi:Ikd	Lcom/tencent/mm/bw/b;
    //   1114: ldc 87
    //   1116: ldc_w 531
    //   1119: iconst_3
    //   1120: anewarray 91	java/lang/Object
    //   1123: dup
    //   1124: iconst_0
    //   1125: aload_1
    //   1126: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   1129: getfield 534	com/tencent/mm/protocal/protobuf/ege:IjR	J
    //   1132: invokestatic 539	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1135: aastore
    //   1136: dup
    //   1137: iconst_1
    //   1138: aload_1
    //   1139: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   1142: getfield 332	com/tencent/mm/protocal/protobuf/ege:IjS	Lcom/tencent/mm/protocal/protobuf/pt;
    //   1145: getfield 542	com/tencent/mm/protocal/protobuf/pt:dwb	Ljava/lang/String;
    //   1148: aastore
    //   1149: dup
    //   1150: iconst_2
    //   1151: aload_1
    //   1152: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   1155: getfield 332	com/tencent/mm/protocal/protobuf/ege:IjS	Lcom/tencent/mm/protocal/protobuf/pt;
    //   1158: getfield 545	com/tencent/mm/protocal/protobuf/pt:prK	Ljava/lang/String;
    //   1161: aastore
    //   1162: invokestatic 398	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1165: aload_1
    //   1166: getfield 549	com/tencent/mm/plugin/websearch/api/s:DTj	Lcom/tencent/mm/protocal/protobuf/ejs;
    //   1169: ifnull +24 -> 1193
    //   1172: aload_0
    //   1173: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   1176: new 518	com/tencent/mm/bw/b
    //   1179: dup
    //   1180: aload_1
    //   1181: getfield 549	com/tencent/mm/plugin/websearch/api/s:DTj	Lcom/tencent/mm/protocal/protobuf/ejs;
    //   1184: invokevirtual 552	com/tencent/mm/protocal/protobuf/ejs:toByteArray	()[B
    //   1187: invokespecial 525	com/tencent/mm/bw/b:<init>	([B)V
    //   1190: putfield 555	com/tencent/mm/protocal/protobuf/egi:Ikc	Lcom/tencent/mm/bw/b;
    //   1193: aload_0
    //   1194: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   1197: getfield 166	com/tencent/mm/protocal/protobuf/egi:HkU	Lcom/tencent/mm/protocal/protobuf/buh;
    //   1200: ifnull +330 -> 1530
    //   1203: iconst_1
    //   1204: istore 6
    //   1206: ldc 87
    //   1208: ldc_w 557
    //   1211: bipush 7
    //   1213: anewarray 91	java/lang/Object
    //   1216: dup
    //   1217: iconst_0
    //   1218: iload 6
    //   1220: invokestatic 562	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1223: aastore
    //   1224: dup
    //   1225: iconst_1
    //   1226: aload_1
    //   1227: getfield 180	com/tencent/mm/plugin/websearch/api/s:DSX	Ljava/util/LinkedList;
    //   1230: invokevirtual 565	java/util/LinkedList:size	()I
    //   1233: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1236: aastore
    //   1237: dup
    //   1238: iconst_2
    //   1239: aload_1
    //   1240: getfield 60	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   1243: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1246: aastore
    //   1247: dup
    //   1248: iconst_3
    //   1249: aload_1
    //   1250: getfield 152	com/tencent/mm/plugin/websearch/api/s:businessType	I
    //   1253: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1256: aastore
    //   1257: dup
    //   1258: iconst_4
    //   1259: aload_0
    //   1260: getfield 72	com/tencent/mm/plugin/webview/fts/f:DSW	I
    //   1263: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1266: aastore
    //   1267: dup
    //   1268: iconst_5
    //   1269: aload_1
    //   1270: getfield 195	com/tencent/mm/plugin/websearch/api/s:dEf	I
    //   1273: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1276: aastore
    //   1277: dup
    //   1278: bipush 6
    //   1280: aload_1
    //   1281: getfield 66	com/tencent/mm/plugin/websearch/api/s:dDY	I
    //   1284: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1287: aastore
    //   1288: invokestatic 96	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1291: aload_0
    //   1292: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   1295: getfield 166	com/tencent/mm/protocal/protobuf/egi:HkU	Lcom/tencent/mm/protocal/protobuf/buh;
    //   1298: ifnull +39 -> 1337
    //   1301: sipush 2005
    //   1304: aload_0
    //   1305: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   1308: getfield 166	com/tencent/mm/protocal/protobuf/egi:HkU	Lcom/tencent/mm/protocal/protobuf/buh;
    //   1311: getfield 427	com/tencent/mm/protocal/protobuf/buh:GgZ	F
    //   1314: aload_0
    //   1315: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   1318: getfield 166	com/tencent/mm/protocal/protobuf/egi:HkU	Lcom/tencent/mm/protocal/protobuf/buh;
    //   1321: getfield 430	com/tencent/mm/protocal/protobuf/buh:Gha	F
    //   1324: aload_0
    //   1325: getfield 143	com/tencent/mm/plugin/webview/fts/f:Ecq	Lcom/tencent/mm/protocal/protobuf/egi;
    //   1328: getfield 166	com/tencent/mm/protocal/protobuf/egi:HkU	Lcom/tencent/mm/protocal/protobuf/buh;
    //   1331: getfield 568	com/tencent/mm/protocal/protobuf/buh:Gzf	I
    //   1334: invokestatic 574	com/tencent/mm/modelstat/o:a	(IFFI)V
    //   1337: aload_1
    //   1338: getfield 60	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   1341: istore 4
    //   1343: aload_1
    //   1344: getfield 310	com/tencent/mm/plugin/websearch/api/s:sessionId	Ljava/lang/String;
    //   1347: astore 8
    //   1349: aload_1
    //   1350: getfield 577	com/tencent/mm/plugin/websearch/api/s:dEb	Ljava/lang/String;
    //   1353: astore 9
    //   1355: aload_1
    //   1356: getfield 189	com/tencent/mm/plugin/websearch/api/s:pSq	Ljava/lang/String;
    //   1359: astore 10
    //   1361: aload_1
    //   1362: getfield 55	com/tencent/mm/plugin/websearch/api/s:offset	I
    //   1365: istore 5
    //   1367: aload_1
    //   1368: getfield 71	com/tencent/mm/plugin/websearch/api/s:DSW	I
    //   1371: iconst_1
    //   1372: if_icmpne +164 -> 1536
    //   1375: iload 7
    //   1377: istore 6
    //   1379: iload 4
    //   1381: aload 8
    //   1383: aload 9
    //   1385: aload 10
    //   1387: iload 5
    //   1389: iload 6
    //   1391: aload_1
    //   1392: getfield 49	com/tencent/mm/plugin/websearch/api/s:dyb	Ljava/lang/String;
    //   1395: aload_1
    //   1396: getfield 43	com/tencent/mm/plugin/websearch/api/s:dmf	Ljava/lang/String;
    //   1399: aload_1
    //   1400: getfield 152	com/tencent/mm/plugin/websearch/api/s:businessType	I
    //   1403: invokestatic 582	com/tencent/mm/plugin/websearch/api/ac:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;I)V
    //   1406: ldc 29
    //   1408: invokestatic 585	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1411: return
    //   1412: iconst_0
    //   1413: istore 4
    //   1415: goto -1271 -> 144
    //   1418: aload_1
    //   1419: getfield 588	com/tencent/mm/plugin/websearch/api/s:DTp	I
    //   1422: iconst_1
    //   1423: if_icmpne +22 -> 1445
    //   1426: aload 8
    //   1428: sipush 1011
    //   1431: putfield 106	com/tencent/mm/ak/b$a:funcId	I
    //   1434: aload 8
    //   1436: ldc_w 590
    //   1439: putfield 111	com/tencent/mm/ak/b$a:uri	Ljava/lang/String;
    //   1442: goto -1278 -> 164
    //   1445: aload 8
    //   1447: sipush 719
    //   1450: putfield 106	com/tencent/mm/ak/b$a:funcId	I
    //   1453: aload 8
    //   1455: ldc_w 592
    //   1458: putfield 111	com/tencent/mm/ak/b$a:uri	Ljava/lang/String;
    //   1461: goto -1297 -> 164
    //   1464: iconst_0
    //   1465: istore 4
    //   1467: goto -865 -> 602
    //   1470: iload 4
    //   1472: i2f
    //   1473: invokestatic 598	com/tencent/mm/cc/a:flD	()F
    //   1476: fdiv
    //   1477: invokestatic 375	java/lang/Math:round	(F)I
    //   1480: istore 4
    //   1482: goto -787 -> 695
    //   1485: iconst_0
    //   1486: istore 4
    //   1488: goto -657 -> 831
    //   1491: iconst_1
    //   1492: istore 4
    //   1494: goto -655 -> 839
    //   1497: aload_1
    //   1498: getfield 325	com/tencent/mm/plugin/websearch/api/s:DTk	Lcom/tencent/mm/protocal/protobuf/ege;
    //   1501: getfield 332	com/tencent/mm/protocal/protobuf/ege:IjS	Lcom/tencent/mm/protocal/protobuf/pt;
    //   1504: iconst_1
    //   1505: putfield 422	com/tencent/mm/protocal/protobuf/pt:Gdr	I
    //   1508: goto -640 -> 868
    //   1511: astore 8
    //   1513: ldc 87
    //   1515: aload 8
    //   1517: ldc_w 280
    //   1520: iconst_0
    //   1521: anewarray 91	java/lang/Object
    //   1524: invokestatic 602	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1527: goto -462 -> 1065
    //   1530: iconst_0
    //   1531: istore 6
    //   1533: goto -327 -> 1206
    //   1536: iconst_0
    //   1537: istore 6
    //   1539: goto -160 -> 1379
    //   1542: ldc 87
    //   1544: ldc_w 604
    //   1547: invokestatic 608	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1550: ldc 29
    //   1552: invokestatic 585	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1555: return
    //   1556: astore 8
    //   1558: goto -365 -> 1193
    //   1561: astore 8
    //   1563: goto -398 -> 1165
    //   1566: aconst_null
    //   1567: astore 8
    //   1569: goto -1119 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1572	0	this	f
    //   0	1572	1	params	s
    //   769	118	2	f1	float
    //   767	113	3	f2	float
    //   142	1351	4	i	int
    //   1365	23	5	j	int
    //   1204	334	6	bool1	boolean
    //   1	1375	7	bool2	boolean
    //   121	1333	8	localObject1	Object
    //   1511	5	8	localJSONException	org.json.JSONException
    //   1556	1	8	localException1	java.lang.Exception
    //   1561	1	8	localException2	java.lang.Exception
    //   1567	1	8	localObject2	Object
    //   386	998	9	localObject3	Object
    //   423	963	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   929	1065	1511	org/json/JSONException
    //   1172	1193	1556	java/lang/Exception
    //   1072	1165	1561	java/lang/Exception
  }
  
  public final void bc(LinkedList<duv> paramLinkedList)
  {
    AppMethodBeat.i(77933);
    this.Ecq.HIX = paramLinkedList;
    dgk localdgk = new dgk();
    localdgk.HNF = paramLinkedList.size();
    this.Ecq.Ike = localdgk;
    AppMethodBeat.o(77933);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(77931);
    am.iW(this.scene, 2);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(77931);
    return i;
  }
  
  public final String ePw()
  {
    if (this.Ecp != null) {
      return this.Ecp.GWB;
    }
    return "";
  }
  
  public final int ePx()
  {
    if (this.Ecp != null) {
      return this.Ecp.IjN;
    }
    return 0;
  }
  
  public final int getType()
  {
    return 719;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77932);
    ae.i("MicroMsg.WebSearch.NetSceneWebSearch", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label200;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramInt1 = this.DTs.scene;
      paramString = this.DTs.sessionId;
      paramq = this.DTs.dEb;
      paramArrayOfByte = this.DTs.pSq;
      i = this.DTs.offset;
      if (this.DTs.DSW != 1) {
        break label194;
      }
    }
    label194:
    for (boolean bool2 = true;; bool2 = false)
    {
      ac.a(paramInt1, paramString, paramq, paramArrayOfByte, i, bool2, this.DTs.dyb, bool1, this.DTs.dmf, this.DTs.businessType);
      am.aC(this.scene, paramInt2, paramInt3);
      AppMethodBeat.o(77932);
      return;
      bool1 = false;
      break;
    }
    label200:
    this.Ecp = ((egj)this.hZD.hQE.hQJ);
    String str;
    if (this.Ecp != null)
    {
      paramInt1 = this.DTs.scene;
      paramq = this.DTs.sessionId;
      paramArrayOfByte = this.DTs.dEb;
      str = this.DTs.pSq;
      i = this.DTs.offset;
      if (this.DTs.DSW != 1) {
        break label371;
      }
    }
    label371:
    for (bool2 = true;; bool2 = false)
    {
      ac.a(paramInt1, paramq, paramArrayOfByte, str, i, bool2, this.DTs.dyb, bool1, this.DTs.dmf, this.DTs.businessType);
      ae.v("MicroMsg.WebSearch.NetSceneWebSearch", "return data\n%s", new Object[] { this.Ecp.GWB });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      am.aC(this.scene, paramInt2, paramInt3);
      AppMethodBeat.o(77932);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.f
 * JD-Core Version:    0.7.0.1
 */