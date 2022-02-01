package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.protocal.protobuf.dad;
import com.tencent.mm.protocal.protobuf.doh;
import com.tencent.mm.protocal.protobuf.dyp;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class e
  extends a
  implements k
{
  private p BYB;
  private int BYg;
  private dyq Chk;
  private dyp Chl;
  private g callback;
  private b hEg;
  private int scene;
  
  /* Error */
  public e(p paramp)
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
    //   14: putfield 37	com/tencent/mm/plugin/webview/fts/e:BYB	Lcom/tencent/mm/plugin/websearch/api/p;
    //   17: aload_0
    //   18: aload_1
    //   19: getfield 43	com/tencent/mm/plugin/websearch/api/p:cZL	Ljava/lang/String;
    //   22: putfield 46	com/tencent/mm/plugin/webview/fts/e:sTA	Ljava/lang/String;
    //   25: aload_0
    //   26: aload_1
    //   27: getfield 49	com/tencent/mm/plugin/websearch/api/p:dlj	Ljava/lang/String;
    //   30: putfield 52	com/tencent/mm/plugin/webview/fts/e:drg	Ljava/lang/String;
    //   33: aload_0
    //   34: aload_1
    //   35: getfield 55	com/tencent/mm/plugin/websearch/api/p:offset	I
    //   38: putfield 58	com/tencent/mm/plugin/webview/fts/e:MW	I
    //   41: aload_0
    //   42: aload_1
    //   43: getfield 60	com/tencent/mm/plugin/websearch/api/p:scene	I
    //   46: putfield 63	com/tencent/mm/plugin/webview/fts/e:mScene	I
    //   49: aload_0
    //   50: aload_1
    //   51: getfield 66	com/tencent/mm/plugin/websearch/api/p:drc	I
    //   54: putfield 69	com/tencent/mm/plugin/webview/fts/e:BYb	I
    //   57: aload_0
    //   58: aload_1
    //   59: getfield 71	com/tencent/mm/plugin/websearch/api/p:BYg	I
    //   62: putfield 72	com/tencent/mm/plugin/webview/fts/e:BYg	I
    //   65: aload_0
    //   66: aload_1
    //   67: putfield 37	com/tencent/mm/plugin/webview/fts/e:BYB	Lcom/tencent/mm/plugin/websearch/api/p;
    //   70: aload_0
    //   71: aload_1
    //   72: getfield 76	com/tencent/mm/plugin/websearch/api/p:wWc	Landroid/os/Bundle;
    //   75: putfield 79	com/tencent/mm/plugin/webview/fts/e:BYc	Landroid/os/Bundle;
    //   78: aload_1
    //   79: getfield 43	com/tencent/mm/plugin/websearch/api/p:cZL	Ljava/lang/String;
    //   82: invokestatic 85	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   85: ifne +1430 -> 1515
    //   88: ldc 87
    //   90: ldc 89
    //   92: iconst_1
    //   93: anewarray 91	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_1
    //   99: getfield 43	com/tencent/mm/plugin/websearch/api/p:cZL	Ljava/lang/String;
    //   102: aastore
    //   103: invokestatic 96	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: aload_1
    //   108: getfield 60	com/tencent/mm/plugin/websearch/api/p:scene	I
    //   111: putfield 97	com/tencent/mm/plugin/webview/fts/e:scene	I
    //   114: new 99	com/tencent/mm/ak/b$a
    //   117: dup
    //   118: invokespecial 100	com/tencent/mm/ak/b$a:<init>	()V
    //   121: astore 8
    //   123: aload_1
    //   124: getfield 60	com/tencent/mm/plugin/websearch/api/p:scene	I
    //   127: sipush 201
    //   130: if_icmpeq +11 -> 141
    //   133: aload_1
    //   134: getfield 103	com/tencent/mm/plugin/websearch/api/p:BYs	I
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
    //   166: new 113	com/tencent/mm/protocal/protobuf/dyp
    //   169: dup
    //   170: invokespecial 114	com/tencent/mm/protocal/protobuf/dyp:<init>	()V
    //   173: putfield 118	com/tencent/mm/ak/b$a:hvt	Lcom/tencent/mm/bw/a;
    //   176: aload 8
    //   178: new 120	com/tencent/mm/protocal/protobuf/dyq
    //   181: dup
    //   182: invokespecial 121	com/tencent/mm/protocal/protobuf/dyq:<init>	()V
    //   185: putfield 124	com/tencent/mm/ak/b$a:hvu	Lcom/tencent/mm/bw/a;
    //   188: aload_0
    //   189: aload 8
    //   191: invokevirtual 128	com/tencent/mm/ak/b$a:aAz	()Lcom/tencent/mm/ak/b;
    //   194: putfield 130	com/tencent/mm/plugin/webview/fts/e:hEg	Lcom/tencent/mm/ak/b;
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 130	com/tencent/mm/plugin/webview/fts/e:hEg	Lcom/tencent/mm/ak/b;
    //   202: getfield 136	com/tencent/mm/ak/b:hvr	Lcom/tencent/mm/ak/b$b;
    //   205: getfield 141	com/tencent/mm/ak/b$b:hvw	Lcom/tencent/mm/bw/a;
    //   208: checkcast 113	com/tencent/mm/protocal/protobuf/dyp
    //   211: putfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   214: aload_0
    //   215: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   218: aload_1
    //   219: getfield 43	com/tencent/mm/plugin/websearch/api/p:cZL	Ljava/lang/String;
    //   222: putfield 146	com/tencent/mm/protocal/protobuf/dyp:EJp	Ljava/lang/String;
    //   225: aload_0
    //   226: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   229: aload_1
    //   230: getfield 71	com/tencent/mm/plugin/websearch/api/p:BYg	I
    //   233: putfield 149	com/tencent/mm/protocal/protobuf/dyp:FCc	I
    //   236: aload_0
    //   237: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   240: aload_1
    //   241: getfield 152	com/tencent/mm/plugin/websearch/api/p:businessType	I
    //   244: i2l
    //   245: putfield 156	com/tencent/mm/protocal/protobuf/dyp:EfR	J
    //   248: aload_0
    //   249: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   252: invokestatic 162	com/tencent/mm/plugin/websearch/api/z:bJn	()Lcom/tencent/mm/protocal/protobuf/bpa;
    //   255: putfield 166	com/tencent/mm/protocal/protobuf/dyp:FhT	Lcom/tencent/mm/protocal/protobuf/bpa;
    //   258: aload_0
    //   259: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   262: aload_1
    //   263: getfield 55	com/tencent/mm/plugin/websearch/api/p:offset	I
    //   266: putfield 169	com/tencent/mm/protocal/protobuf/dyp:EfV	I
    //   269: aload_0
    //   270: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   273: iconst_0
    //   274: invokestatic 173	com/tencent/mm/plugin/websearch/api/z:Ul	(I)I
    //   277: putfield 176	com/tencent/mm/protocal/protobuf/dyp:GeJ	I
    //   280: aload_0
    //   281: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   284: aload_1
    //   285: getfield 180	com/tencent/mm/plugin/websearch/api/p:BYh	Ljava/util/LinkedList;
    //   288: putfield 183	com/tencent/mm/protocal/protobuf/dyp:FEW	Ljava/util/LinkedList;
    //   291: aload_0
    //   292: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   295: aload_1
    //   296: getfield 60	com/tencent/mm/plugin/websearch/api/p:scene	I
    //   299: putfield 186	com/tencent/mm/protocal/protobuf/dyp:Scene	I
    //   302: aload_0
    //   303: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   306: aload_1
    //   307: getfield 189	com/tencent/mm/plugin/websearch/api/p:pik	Ljava/lang/String;
    //   310: putfield 192	com/tencent/mm/protocal/protobuf/dyp:EfU	Ljava/lang/String;
    //   313: aload_0
    //   314: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   317: aload_1
    //   318: getfield 195	com/tencent/mm/plugin/websearch/api/p:drj	I
    //   321: putfield 198	com/tencent/mm/protocal/protobuf/dyp:FCg	I
    //   324: aload_0
    //   325: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   328: aload_1
    //   329: getfield 201	com/tencent/mm/plugin/websearch/api/p:BYi	Ljava/lang/String;
    //   332: putfield 204	com/tencent/mm/protocal/protobuf/dyp:GeK	Ljava/lang/String;
    //   335: aload_0
    //   336: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   339: aload_1
    //   340: getfield 207	com/tencent/mm/plugin/websearch/api/p:BYk	I
    //   343: putfield 210	com/tencent/mm/protocal/protobuf/dyp:GeM	I
    //   346: aload_0
    //   347: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   350: aload_1
    //   351: getfield 213	com/tencent/mm/plugin/websearch/api/p:BYj	Ljava/lang/String;
    //   354: putfield 216	com/tencent/mm/protocal/protobuf/dyp:GeL	Ljava/lang/String;
    //   357: aload_0
    //   358: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   361: aload_1
    //   362: getfield 219	com/tencent/mm/plugin/websearch/api/p:BYl	Ljava/util/LinkedList;
    //   365: putfield 222	com/tencent/mm/protocal/protobuf/dyp:GeN	Ljava/util/LinkedList;
    //   368: aload_0
    //   369: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   372: aload_1
    //   373: getfield 225	com/tencent/mm/plugin/websearch/api/p:BYq	Ljava/util/LinkedList;
    //   376: putfield 228	com/tencent/mm/protocal/protobuf/dyp:Gdj	Ljava/util/LinkedList;
    //   379: aload_0
    //   380: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   383: getfield 228	com/tencent/mm/protocal/protobuf/dyp:Gdj	Ljava/util/LinkedList;
    //   386: astore 9
    //   388: aload 9
    //   390: invokestatic 232	com/tencent/mm/sdk/platformtools/bs:gY	(Ljava/util/List;)Z
    //   393: ifne +150 -> 543
    //   396: aload 9
    //   398: invokevirtual 238	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   401: astore 8
    //   403: aload 8
    //   405: invokeinterface 244 1 0
    //   410: ifeq +1129 -> 1539
    //   413: aload 8
    //   415: invokeinterface 248 1 0
    //   420: checkcast 250	com/tencent/mm/protocal/protobuf/yh
    //   423: astore 10
    //   425: aload 10
    //   427: ifnull -24 -> 403
    //   430: ldc 252
    //   432: aload 10
    //   434: getfield 255	com/tencent/mm/protocal/protobuf/yh:key	Ljava/lang/String;
    //   437: invokevirtual 261	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   440: ifeq -37 -> 403
    //   443: aload 10
    //   445: getfield 264	com/tencent/mm/protocal/protobuf/yh:ErW	Ljava/lang/String;
    //   448: astore 8
    //   450: ldc 87
    //   452: ldc_w 266
    //   455: iconst_1
    //   456: anewarray 91	java/lang/Object
    //   459: dup
    //   460: iconst_0
    //   461: aload 8
    //   463: aastore
    //   464: invokestatic 96	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   467: aload 8
    //   469: invokestatic 85	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   472: ifne +71 -> 543
    //   475: invokestatic 272	com/tencent/mm/model/y:ayq	()Lcom/tencent/mm/model/y;
    //   478: aload 8
    //   480: invokevirtual 276	com/tencent/mm/model/y:xI	(Ljava/lang/String;)Lcom/tencent/mm/model/y$b;
    //   483: astore 8
    //   485: aload 8
    //   487: ifnull +56 -> 543
    //   490: aload 8
    //   492: ldc_w 278
    //   495: ldc_w 280
    //   498: invokevirtual 286	com/tencent/mm/model/y$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   501: astore 8
    //   503: aload 8
    //   505: invokestatic 85	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   508: ifne +35 -> 543
    //   511: new 250	com/tencent/mm/protocal/protobuf/yh
    //   514: dup
    //   515: invokespecial 287	com/tencent/mm/protocal/protobuf/yh:<init>	()V
    //   518: astore 10
    //   520: aload 10
    //   522: ldc_w 278
    //   525: putfield 255	com/tencent/mm/protocal/protobuf/yh:key	Ljava/lang/String;
    //   528: aload 10
    //   530: aload 8
    //   532: putfield 264	com/tencent/mm/protocal/protobuf/yh:ErW	Ljava/lang/String;
    //   535: aload 9
    //   537: aload 10
    //   539: invokevirtual 290	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   542: pop
    //   543: aload_0
    //   544: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   547: aload_1
    //   548: getfield 294	com/tencent/mm/plugin/websearch/api/p:BYp	Lcom/tencent/mm/protocal/protobuf/dgk;
    //   551: putfield 295	com/tencent/mm/protocal/protobuf/dyp:BYp	Lcom/tencent/mm/protocal/protobuf/dgk;
    //   554: aload_0
    //   555: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   558: aload_1
    //   559: getfield 298	com/tencent/mm/plugin/websearch/api/p:BYr	Ljava/util/LinkedList;
    //   562: putfield 301	com/tencent/mm/protocal/protobuf/dyp:GeO	Ljava/util/LinkedList;
    //   565: aload_0
    //   566: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   569: aload_1
    //   570: getfield 304	com/tencent/mm/plugin/websearch/api/p:aTm	Ljava/lang/String;
    //   573: putfield 307	com/tencent/mm/protocal/protobuf/dyp:pAD	Ljava/lang/String;
    //   576: aload_0
    //   577: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   580: aload_1
    //   581: getfield 310	com/tencent/mm/plugin/websearch/api/p:sessionId	Ljava/lang/String;
    //   584: putfield 313	com/tencent/mm/protocal/protobuf/dyp:Gev	Ljava/lang/String;
    //   587: aload_0
    //   588: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   591: astore 8
    //   593: invokestatic 318	com/tencent/mm/ui/aj:DT	()Z
    //   596: ifeq +841 -> 1437
    //   599: iconst_1
    //   600: istore 4
    //   602: aload 8
    //   604: iload 4
    //   606: putfield 321	com/tencent/mm/protocal/protobuf/dyp:FrR	I
    //   609: aload_1
    //   610: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   613: ifnonnull +14 -> 627
    //   616: aload_1
    //   617: new 327	com/tencent/mm/protocal/protobuf/dyl
    //   620: dup
    //   621: invokespecial 328	com/tencent/mm/protocal/protobuf/dyl:<init>	()V
    //   624: putfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   627: aload_1
    //   628: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   631: getfield 332	com/tencent/mm/protocal/protobuf/dyl:GeF	Lcom/tencent/mm/protocal/protobuf/om;
    //   634: ifnonnull +17 -> 651
    //   637: aload_1
    //   638: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   641: new 334	com/tencent/mm/protocal/protobuf/om
    //   644: dup
    //   645: invokespecial 335	com/tencent/mm/protocal/protobuf/om:<init>	()V
    //   648: putfield 332	com/tencent/mm/protocal/protobuf/dyl:GeF	Lcom/tencent/mm/protocal/protobuf/om;
    //   651: aload_1
    //   652: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   655: getfield 332	com/tencent/mm/protocal/protobuf/dyl:GeF	Lcom/tencent/mm/protocal/protobuf/om;
    //   658: astore 8
    //   660: invokestatic 341	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   663: invokevirtual 347	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   666: invokevirtual 353	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   669: getfield 358	android/util/DisplayMetrics:widthPixels	I
    //   672: istore 4
    //   674: invokestatic 363	org/xwalk/core/XWalkEnvironment:getUsingCustomContext	()Z
    //   677: ifeq +766 -> 1443
    //   680: iload 4
    //   682: i2f
    //   683: invokestatic 341	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   686: invokestatic 369	com/tencent/mm/cc/a:getDensity	(Landroid/content/Context;)F
    //   689: fdiv
    //   690: invokestatic 375	java/lang/Math:round	(F)I
    //   693: istore 4
    //   695: aload 8
    //   697: iload 4
    //   699: putfield 378	com/tencent/mm/protocal/protobuf/om:xEp	I
    //   702: ldc 87
    //   704: ldc_w 380
    //   707: iconst_3
    //   708: anewarray 91	java/lang/Object
    //   711: dup
    //   712: iconst_0
    //   713: invokestatic 341	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   716: invokevirtual 347	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   719: invokevirtual 353	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   722: getfield 358	android/util/DisplayMetrics:widthPixels	I
    //   725: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   728: aastore
    //   729: dup
    //   730: iconst_1
    //   731: aload_1
    //   732: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   735: getfield 332	com/tencent/mm/protocal/protobuf/dyl:GeF	Lcom/tencent/mm/protocal/protobuf/om;
    //   738: getfield 378	com/tencent/mm/protocal/protobuf/om:xEp	I
    //   741: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   744: aastore
    //   745: dup
    //   746: iconst_2
    //   747: invokestatic 341	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   750: invokevirtual 347	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   753: invokevirtual 353	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   756: getfield 390	android/util/DisplayMetrics:density	F
    //   759: invokestatic 395	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   762: aastore
    //   763: invokestatic 398	com/tencent/mm/sdk/platformtools/ac:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   766: fconst_0
    //   767: fstore_3
    //   768: fconst_0
    //   769: fstore_2
    //   770: aload_0
    //   771: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   774: getfield 166	com/tencent/mm/protocal/protobuf/dyp:FhT	Lcom/tencent/mm/protocal/protobuf/bpa;
    //   777: ifnull +693 -> 1470
    //   780: aload_1
    //   781: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   784: getfield 332	com/tencent/mm/protocal/protobuf/dyl:GeF	Lcom/tencent/mm/protocal/protobuf/om;
    //   787: astore 8
    //   789: invokestatic 404	com/tencent/mm/modelgeo/d:aEL	()Lcom/tencent/mm/modelgeo/d;
    //   792: astore 9
    //   794: aload 9
    //   796: getfield 407	com/tencent/mm/modelgeo/d:hES	J
    //   799: lconst_0
    //   800: lcmp
    //   801: ifle +657 -> 1458
    //   804: aload 9
    //   806: getfield 411	com/tencent/mm/modelgeo/d:hEU	Z
    //   809: ifeq +649 -> 1458
    //   812: invokestatic 417	java/lang/System:currentTimeMillis	()J
    //   815: aload 9
    //   817: getfield 407	com/tencent/mm/modelgeo/d:hES	J
    //   820: lsub
    //   821: ldc2_w 418
    //   824: lcmp
    //   825: ifge +633 -> 1458
    //   828: iconst_1
    //   829: istore 4
    //   831: iload 4
    //   833: ifeq +631 -> 1464
    //   836: iconst_0
    //   837: istore 4
    //   839: aload 8
    //   841: iload 4
    //   843: putfield 422	com/tencent/mm/protocal/protobuf/om:Eet	I
    //   846: aload_0
    //   847: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   850: getfield 166	com/tencent/mm/protocal/protobuf/dyp:FhT	Lcom/tencent/mm/protocal/protobuf/bpa;
    //   853: getfield 427	com/tencent/mm/protocal/protobuf/bpa:Eht	F
    //   856: fstore_3
    //   857: aload_0
    //   858: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   861: getfield 166	com/tencent/mm/protocal/protobuf/dyp:FhT	Lcom/tencent/mm/protocal/protobuf/bpa;
    //   864: getfield 430	com/tencent/mm/protocal/protobuf/bpa:Ehu	F
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
    //   894: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   897: getfield 332	com/tencent/mm/protocal/protobuf/dyl:GeF	Lcom/tencent/mm/protocal/protobuf/om;
    //   900: getfield 422	com/tencent/mm/protocal/protobuf/om:Eet	I
    //   903: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   906: aastore
    //   907: invokestatic 96	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   910: aload_1
    //   911: getfield 435	com/tencent/mm/plugin/websearch/api/p:BYv	Ljava/lang/String;
    //   914: invokestatic 441	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   917: ifne +148 -> 1065
    //   920: aload_1
    //   921: getfield 435	com/tencent/mm/plugin/websearch/api/p:BYv	Ljava/lang/String;
    //   924: invokestatic 447	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   927: astore 8
    //   929: new 449	org/json/JSONObject
    //   932: dup
    //   933: aload 8
    //   935: invokespecial 452	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   938: astore 8
    //   940: new 454	com/tencent/mm/protocal/protobuf/cfw
    //   943: dup
    //   944: invokespecial 455	com/tencent/mm/protocal/protobuf/cfw:<init>	()V
    //   947: astore 9
    //   949: aload 9
    //   951: aload 8
    //   953: ldc_w 457
    //   956: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   959: putfield 463	com/tencent/mm/protocal/protobuf/cfw:iJV	Ljava/lang/String;
    //   962: aload 9
    //   964: aload 8
    //   966: ldc_w 465
    //   969: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   972: putfield 468	com/tencent/mm/protocal/protobuf/cfw:iKc	Ljava/lang/String;
    //   975: aload 9
    //   977: aload 8
    //   979: ldc_w 470
    //   982: invokevirtual 474	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   985: d2f
    //   986: putfield 475	com/tencent/mm/protocal/protobuf/cfw:Ehu	F
    //   989: aload 9
    //   991: aload 8
    //   993: ldc_w 477
    //   996: invokevirtual 474	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   999: d2f
    //   1000: putfield 478	com/tencent/mm/protocal/protobuf/cfw:Eht	F
    //   1003: aload 9
    //   1005: aload 8
    //   1007: ldc_w 480
    //   1010: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1013: putfield 483	com/tencent/mm/protocal/protobuf/cfw:Fud	Ljava/lang/String;
    //   1016: aload 9
    //   1018: aload 8
    //   1020: ldc_w 485
    //   1023: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1026: putfield 488	com/tencent/mm/protocal/protobuf/cfw:Fai	Ljava/lang/String;
    //   1029: aload 9
    //   1031: aload 8
    //   1033: ldc_w 490
    //   1036: invokevirtual 460	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1039: invokestatic 494	com/tencent/mm/plugin/websearch/api/z:aAs	(Ljava/lang/String;)J
    //   1042: putfield 497	com/tencent/mm/protocal/protobuf/cfw:Fuf	J
    //   1045: aload 9
    //   1047: getfield 483	com/tencent/mm/protocal/protobuf/cfw:Fud	Ljava/lang/String;
    //   1050: invokestatic 441	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1053: ifne +12 -> 1065
    //   1056: aload_0
    //   1057: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   1060: aload 9
    //   1062: putfield 501	com/tencent/mm/protocal/protobuf/dyp:GeT	Lcom/tencent/mm/protocal/protobuf/cfw;
    //   1065: aload_1
    //   1066: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   1069: ifnull +96 -> 1165
    //   1072: aload_1
    //   1073: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   1076: ldc_w 503
    //   1079: invokestatic 509	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1082: checkcast 503	com/tencent/mm/plugin/appbrand/service/i
    //   1085: invokeinterface 513 1 0
    //   1090: putfield 516	com/tencent/mm/protocal/protobuf/dyl:GeG	I
    //   1093: aload_0
    //   1094: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   1097: new 518	com/tencent/mm/bw/b
    //   1100: dup
    //   1101: aload_1
    //   1102: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   1105: invokevirtual 522	com/tencent/mm/protocal/protobuf/dyl:toByteArray	()[B
    //   1108: invokespecial 525	com/tencent/mm/bw/b:<init>	([B)V
    //   1111: putfield 529	com/tencent/mm/protocal/protobuf/dyp:GeQ	Lcom/tencent/mm/bw/b;
    //   1114: ldc 87
    //   1116: ldc_w 531
    //   1119: iconst_3
    //   1120: anewarray 91	java/lang/Object
    //   1123: dup
    //   1124: iconst_0
    //   1125: aload_1
    //   1126: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   1129: getfield 534	com/tencent/mm/protocal/protobuf/dyl:GeE	J
    //   1132: invokestatic 539	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1135: aastore
    //   1136: dup
    //   1137: iconst_1
    //   1138: aload_1
    //   1139: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   1142: getfield 332	com/tencent/mm/protocal/protobuf/dyl:GeF	Lcom/tencent/mm/protocal/protobuf/om;
    //   1145: getfield 542	com/tencent/mm/protocal/protobuf/om:djj	Ljava/lang/String;
    //   1148: aastore
    //   1149: dup
    //   1150: iconst_2
    //   1151: aload_1
    //   1152: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   1155: getfield 332	com/tencent/mm/protocal/protobuf/dyl:GeF	Lcom/tencent/mm/protocal/protobuf/om;
    //   1158: getfield 545	com/tencent/mm/protocal/protobuf/om:oHB	Ljava/lang/String;
    //   1161: aastore
    //   1162: invokestatic 398	com/tencent/mm/sdk/platformtools/ac:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1165: aload_1
    //   1166: getfield 549	com/tencent/mm/plugin/websearch/api/p:BYt	Lcom/tencent/mm/protocal/protobuf/ebv;
    //   1169: ifnull +24 -> 1193
    //   1172: aload_0
    //   1173: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   1176: new 518	com/tencent/mm/bw/b
    //   1179: dup
    //   1180: aload_1
    //   1181: getfield 549	com/tencent/mm/plugin/websearch/api/p:BYt	Lcom/tencent/mm/protocal/protobuf/ebv;
    //   1184: invokevirtual 552	com/tencent/mm/protocal/protobuf/ebv:toByteArray	()[B
    //   1187: invokespecial 525	com/tencent/mm/bw/b:<init>	([B)V
    //   1190: putfield 555	com/tencent/mm/protocal/protobuf/dyp:GeP	Lcom/tencent/mm/bw/b;
    //   1193: aload_0
    //   1194: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   1197: getfield 166	com/tencent/mm/protocal/protobuf/dyp:FhT	Lcom/tencent/mm/protocal/protobuf/bpa;
    //   1200: ifnull +303 -> 1503
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
    //   1227: getfield 180	com/tencent/mm/plugin/websearch/api/p:BYh	Ljava/util/LinkedList;
    //   1230: invokevirtual 565	java/util/LinkedList:size	()I
    //   1233: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1236: aastore
    //   1237: dup
    //   1238: iconst_2
    //   1239: aload_1
    //   1240: getfield 60	com/tencent/mm/plugin/websearch/api/p:scene	I
    //   1243: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1246: aastore
    //   1247: dup
    //   1248: iconst_3
    //   1249: aload_1
    //   1250: getfield 152	com/tencent/mm/plugin/websearch/api/p:businessType	I
    //   1253: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1256: aastore
    //   1257: dup
    //   1258: iconst_4
    //   1259: aload_0
    //   1260: getfield 72	com/tencent/mm/plugin/webview/fts/e:BYg	I
    //   1263: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1266: aastore
    //   1267: dup
    //   1268: iconst_5
    //   1269: aload_1
    //   1270: getfield 195	com/tencent/mm/plugin/websearch/api/p:drj	I
    //   1273: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1276: aastore
    //   1277: dup
    //   1278: bipush 6
    //   1280: aload_1
    //   1281: getfield 66	com/tencent/mm/plugin/websearch/api/p:drc	I
    //   1284: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1287: aastore
    //   1288: invokestatic 96	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1291: aload_0
    //   1292: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   1295: getfield 166	com/tencent/mm/protocal/protobuf/dyp:FhT	Lcom/tencent/mm/protocal/protobuf/bpa;
    //   1298: ifnull +39 -> 1337
    //   1301: sipush 2005
    //   1304: aload_0
    //   1305: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   1308: getfield 166	com/tencent/mm/protocal/protobuf/dyp:FhT	Lcom/tencent/mm/protocal/protobuf/bpa;
    //   1311: getfield 427	com/tencent/mm/protocal/protobuf/bpa:Eht	F
    //   1314: aload_0
    //   1315: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   1318: getfield 166	com/tencent/mm/protocal/protobuf/dyp:FhT	Lcom/tencent/mm/protocal/protobuf/bpa;
    //   1321: getfield 430	com/tencent/mm/protocal/protobuf/bpa:Ehu	F
    //   1324: aload_0
    //   1325: getfield 143	com/tencent/mm/plugin/webview/fts/e:Chl	Lcom/tencent/mm/protocal/protobuf/dyp;
    //   1328: getfield 166	com/tencent/mm/protocal/protobuf/dyp:FhT	Lcom/tencent/mm/protocal/protobuf/bpa;
    //   1331: getfield 568	com/tencent/mm/protocal/protobuf/bpa:EyK	I
    //   1334: invokestatic 574	com/tencent/mm/modelstat/o:a	(IFFI)V
    //   1337: aload_1
    //   1338: getfield 60	com/tencent/mm/plugin/websearch/api/p:scene	I
    //   1341: istore 4
    //   1343: aload_1
    //   1344: getfield 310	com/tencent/mm/plugin/websearch/api/p:sessionId	Ljava/lang/String;
    //   1347: astore 8
    //   1349: aload_1
    //   1350: getfield 577	com/tencent/mm/plugin/websearch/api/p:drf	Ljava/lang/String;
    //   1353: astore 9
    //   1355: aload_1
    //   1356: getfield 189	com/tencent/mm/plugin/websearch/api/p:pik	Ljava/lang/String;
    //   1359: astore 10
    //   1361: aload_1
    //   1362: getfield 55	com/tencent/mm/plugin/websearch/api/p:offset	I
    //   1365: istore 5
    //   1367: aload_1
    //   1368: getfield 71	com/tencent/mm/plugin/websearch/api/p:BYg	I
    //   1371: iconst_1
    //   1372: if_icmpne +137 -> 1509
    //   1375: iload 7
    //   1377: istore 6
    //   1379: iload 4
    //   1381: aload 8
    //   1383: aload 9
    //   1385: aload 10
    //   1387: iload 5
    //   1389: iload 6
    //   1391: aload_1
    //   1392: getfield 49	com/tencent/mm/plugin/websearch/api/p:dlj	Ljava/lang/String;
    //   1395: aload_1
    //   1396: getfield 43	com/tencent/mm/plugin/websearch/api/p:cZL	Ljava/lang/String;
    //   1399: aload_1
    //   1400: getfield 152	com/tencent/mm/plugin/websearch/api/p:businessType	I
    //   1403: invokestatic 582	com/tencent/mm/plugin/websearch/api/y:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;I)V
    //   1406: ldc 29
    //   1408: invokestatic 585	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1411: return
    //   1412: iconst_0
    //   1413: istore 4
    //   1415: goto -1271 -> 144
    //   1418: aload 8
    //   1420: sipush 719
    //   1423: putfield 106	com/tencent/mm/ak/b$a:funcId	I
    //   1426: aload 8
    //   1428: ldc_w 587
    //   1431: putfield 111	com/tencent/mm/ak/b$a:uri	Ljava/lang/String;
    //   1434: goto -1270 -> 164
    //   1437: iconst_0
    //   1438: istore 4
    //   1440: goto -838 -> 602
    //   1443: iload 4
    //   1445: i2f
    //   1446: invokestatic 593	com/tencent/mm/cd/a:eSs	()F
    //   1449: fdiv
    //   1450: invokestatic 375	java/lang/Math:round	(F)I
    //   1453: istore 4
    //   1455: goto -760 -> 695
    //   1458: iconst_0
    //   1459: istore 4
    //   1461: goto -630 -> 831
    //   1464: iconst_1
    //   1465: istore 4
    //   1467: goto -628 -> 839
    //   1470: aload_1
    //   1471: getfield 325	com/tencent/mm/plugin/websearch/api/p:BYu	Lcom/tencent/mm/protocal/protobuf/dyl;
    //   1474: getfield 332	com/tencent/mm/protocal/protobuf/dyl:GeF	Lcom/tencent/mm/protocal/protobuf/om;
    //   1477: iconst_1
    //   1478: putfield 422	com/tencent/mm/protocal/protobuf/om:Eet	I
    //   1481: goto -613 -> 868
    //   1484: astore 8
    //   1486: ldc 87
    //   1488: aload 8
    //   1490: ldc_w 280
    //   1493: iconst_0
    //   1494: anewarray 91	java/lang/Object
    //   1497: invokestatic 597	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1500: goto -435 -> 1065
    //   1503: iconst_0
    //   1504: istore 6
    //   1506: goto -300 -> 1206
    //   1509: iconst_0
    //   1510: istore 6
    //   1512: goto -133 -> 1379
    //   1515: ldc 87
    //   1517: ldc_w 599
    //   1520: invokestatic 603	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1523: ldc 29
    //   1525: invokestatic 585	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1528: return
    //   1529: astore 8
    //   1531: goto -338 -> 1193
    //   1534: astore 8
    //   1536: goto -371 -> 1165
    //   1539: aconst_null
    //   1540: astore 8
    //   1542: goto -1092 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1545	0	this	e
    //   0	1545	1	paramp	p
    //   769	118	2	f1	float
    //   767	113	3	f2	float
    //   142	1324	4	i	int
    //   1365	23	5	j	int
    //   1204	307	6	bool1	boolean
    //   1	1375	7	bool2	boolean
    //   121	1306	8	localObject1	Object
    //   1484	5	8	localJSONException	org.json.JSONException
    //   1529	1	8	localException1	java.lang.Exception
    //   1534	1	8	localException2	java.lang.Exception
    //   1540	1	8	localObject2	Object
    //   386	998	9	localObject3	Object
    //   423	963	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   929	1065	1484	org/json/JSONException
    //   1172	1193	1529	java/lang/Exception
    //   1072	1165	1534	java/lang/Exception
  }
  
  public final void ba(LinkedList<doh> paramLinkedList)
  {
    AppMethodBeat.i(77933);
    this.Chl.FEW = paramLinkedList;
    dad localdad = new dad();
    localdad.FJu = paramLinkedList.size();
    this.Chl.GeR = localdad;
    AppMethodBeat.o(77933);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(77931);
    ai.iF(this.scene, 2);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(77931);
    return i;
  }
  
  public final String ewZ()
  {
    if (this.Chk != null) {
      return this.Chk.FhN;
    }
    return "";
  }
  
  public final int exa()
  {
    if (this.Chk != null) {
      return this.Chk.GeA;
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
    ac.i("MicroMsg.WebSearch.NetSceneWebSearch", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label200;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramInt1 = this.BYB.scene;
      paramString = this.BYB.sessionId;
      paramq = this.BYB.drf;
      paramArrayOfByte = this.BYB.pik;
      i = this.BYB.offset;
      if (this.BYB.BYg != 1) {
        break label194;
      }
    }
    label194:
    for (boolean bool2 = true;; bool2 = false)
    {
      y.a(paramInt1, paramString, paramq, paramArrayOfByte, i, bool2, this.BYB.dlj, bool1, this.BYB.cZL, this.BYB.businessType);
      ai.az(this.scene, paramInt2, paramInt3);
      AppMethodBeat.o(77932);
      return;
      bool1 = false;
      break;
    }
    label200:
    this.Chk = ((dyq)this.hEg.hvs.hvw);
    String str;
    if (this.Chk != null)
    {
      paramInt1 = this.BYB.scene;
      paramq = this.BYB.sessionId;
      paramArrayOfByte = this.BYB.drf;
      str = this.BYB.pik;
      i = this.BYB.offset;
      if (this.BYB.BYg != 1) {
        break label371;
      }
    }
    label371:
    for (bool2 = true;; bool2 = false)
    {
      y.a(paramInt1, paramq, paramArrayOfByte, str, i, bool2, this.BYB.dlj, bool1, this.BYB.cZL, this.BYB.businessType);
      ac.v("MicroMsg.WebSearch.NetSceneWebSearch", "return data\n%s", new Object[] { this.Chk.FhN });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      ai.az(this.scene, paramInt2, paramInt3);
      AppMethodBeat.o(77932);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.e
 * JD-Core Version:    0.7.0.1
 */