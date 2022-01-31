package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cpj;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class e
  extends a
  implements k
{
  private f callback;
  private b fBd;
  private s fpY;
  private int scene;
  private int uIE;
  private cyn uPc;
  private cym uPd;
  
  /* Error */
  public e(s params)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_0
    //   4: invokespecial 28	com/tencent/mm/plugin/websearch/api/a:<init>	()V
    //   7: sipush 5714
    //   10: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   13: aload_0
    //   14: aload_1
    //   15: putfield 36	com/tencent/mm/plugin/webview/fts/e:fpY	Lcom/tencent/mm/plugin/websearch/api/s;
    //   18: aload_0
    //   19: aload_1
    //   20: getfield 42	com/tencent/mm/plugin/websearch/api/s:cnv	Ljava/lang/String;
    //   23: putfield 45	com/tencent/mm/plugin/webview/fts/e:uIC	Ljava/lang/String;
    //   26: aload_0
    //   27: aload_1
    //   28: getfield 48	com/tencent/mm/plugin/websearch/api/s:ohe	Ljava/lang/String;
    //   31: putfield 51	com/tencent/mm/plugin/webview/fts/e:cCX	Ljava/lang/String;
    //   34: aload_0
    //   35: aload_1
    //   36: getfield 54	com/tencent/mm/plugin/websearch/api/s:offset	I
    //   39: putfield 57	com/tencent/mm/plugin/webview/fts/e:Fb	I
    //   42: aload_0
    //   43: aload_1
    //   44: getfield 59	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   47: putfield 62	com/tencent/mm/plugin/webview/fts/e:mScene	I
    //   50: aload_0
    //   51: aload_1
    //   52: getfield 65	com/tencent/mm/plugin/websearch/api/s:cCT	I
    //   55: putfield 68	com/tencent/mm/plugin/webview/fts/e:uIB	I
    //   58: aload_0
    //   59: aload_1
    //   60: getfield 70	com/tencent/mm/plugin/websearch/api/s:uIE	I
    //   63: putfield 71	com/tencent/mm/plugin/webview/fts/e:uIE	I
    //   66: aload_0
    //   67: aload_1
    //   68: putfield 36	com/tencent/mm/plugin/webview/fts/e:fpY	Lcom/tencent/mm/plugin/websearch/api/s;
    //   71: aload_0
    //   72: aload_1
    //   73: getfield 75	com/tencent/mm/plugin/websearch/api/s:uIV	Landroid/os/Bundle;
    //   76: putfield 78	com/tencent/mm/plugin/webview/fts/e:uID	Landroid/os/Bundle;
    //   79: aload_1
    //   80: getfield 42	com/tencent/mm/plugin/websearch/api/s:cnv	Ljava/lang/String;
    //   83: invokestatic 84	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   86: ifne +1322 -> 1408
    //   89: ldc 86
    //   91: ldc 88
    //   93: iconst_1
    //   94: anewarray 90	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: aload_1
    //   100: getfield 42	com/tencent/mm/plugin/websearch/api/s:cnv	Ljava/lang/String;
    //   103: aastore
    //   104: invokestatic 95	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload_0
    //   108: aload_1
    //   109: getfield 59	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   112: putfield 96	com/tencent/mm/plugin/webview/fts/e:scene	I
    //   115: new 98	com/tencent/mm/ai/b$a
    //   118: dup
    //   119: invokespecial 99	com/tencent/mm/ai/b$a:<init>	()V
    //   122: astore 8
    //   124: aload_1
    //   125: getfield 59	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   128: sipush 201
    //   131: if_icmpeq +11 -> 142
    //   134: aload_1
    //   135: getfield 102	com/tencent/mm/plugin/websearch/api/s:uIQ	I
    //   138: iconst_1
    //   139: if_icmpne +1199 -> 1338
    //   142: iconst_1
    //   143: istore 4
    //   145: iload 4
    //   147: ifeq +1197 -> 1344
    //   150: invokestatic 108	com/tencent/mm/plugin/appbrand/s/r:aNV	()Z
    //   153: ifeq +1191 -> 1344
    //   156: aload 8
    //   158: sipush 2676
    //   161: putfield 111	com/tencent/mm/ai/b$a:funcId	I
    //   164: aload 8
    //   166: ldc 113
    //   168: putfield 116	com/tencent/mm/ai/b$a:uri	Ljava/lang/String;
    //   171: aload 8
    //   173: new 118	com/tencent/mm/protocal/protobuf/cym
    //   176: dup
    //   177: invokespecial 119	com/tencent/mm/protocal/protobuf/cym:<init>	()V
    //   180: putfield 123	com/tencent/mm/ai/b$a:fsX	Lcom/tencent/mm/bv/a;
    //   183: aload 8
    //   185: new 125	com/tencent/mm/protocal/protobuf/cyn
    //   188: dup
    //   189: invokespecial 126	com/tencent/mm/protocal/protobuf/cyn:<init>	()V
    //   192: putfield 129	com/tencent/mm/ai/b$a:fsY	Lcom/tencent/mm/bv/a;
    //   195: aload_0
    //   196: aload 8
    //   198: invokevirtual 133	com/tencent/mm/ai/b$a:ado	()Lcom/tencent/mm/ai/b;
    //   201: putfield 135	com/tencent/mm/plugin/webview/fts/e:fBd	Lcom/tencent/mm/ai/b;
    //   204: aload_0
    //   205: aload_0
    //   206: getfield 135	com/tencent/mm/plugin/webview/fts/e:fBd	Lcom/tencent/mm/ai/b;
    //   209: getfield 141	com/tencent/mm/ai/b:fsV	Lcom/tencent/mm/ai/b$b;
    //   212: getfield 146	com/tencent/mm/ai/b$b:fta	Lcom/tencent/mm/bv/a;
    //   215: checkcast 118	com/tencent/mm/protocal/protobuf/cym
    //   218: putfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   221: aload_0
    //   222: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   225: aload_1
    //   226: getfield 42	com/tencent/mm/plugin/websearch/api/s:cnv	Ljava/lang/String;
    //   229: putfield 151	com/tencent/mm/protocal/protobuf/cym:wXt	Ljava/lang/String;
    //   232: aload_0
    //   233: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   236: aload_1
    //   237: getfield 70	com/tencent/mm/plugin/websearch/api/s:uIE	I
    //   240: putfield 154	com/tencent/mm/protocal/protobuf/cym:xHM	I
    //   243: aload_0
    //   244: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   247: aload_1
    //   248: getfield 157	com/tencent/mm/plugin/websearch/api/s:businessType	I
    //   251: i2l
    //   252: putfield 161	com/tencent/mm/protocal/protobuf/cym:wBW	J
    //   255: aload_0
    //   256: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   259: invokestatic 167	com/tencent/mm/plugin/websearch/api/aa:acv	()Lcom/tencent/mm/protocal/protobuf/azu;
    //   262: putfield 171	com/tencent/mm/protocal/protobuf/cym:xqU	Lcom/tencent/mm/protocal/protobuf/azu;
    //   265: aload_0
    //   266: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   269: aload_1
    //   270: getfield 54	com/tencent/mm/plugin/websearch/api/s:offset	I
    //   273: putfield 174	com/tencent/mm/protocal/protobuf/cym:wzS	I
    //   276: aload_0
    //   277: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   280: iconst_0
    //   281: invokestatic 178	com/tencent/mm/plugin/websearch/api/aa:Jf	(I)I
    //   284: putfield 181	com/tencent/mm/protocal/protobuf/cym:xpF	I
    //   287: aload_0
    //   288: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   291: aload_1
    //   292: getfield 185	com/tencent/mm/plugin/websearch/api/s:uIF	Ljava/util/LinkedList;
    //   295: putfield 188	com/tencent/mm/protocal/protobuf/cym:xKn	Ljava/util/LinkedList;
    //   298: aload_0
    //   299: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   302: aload_1
    //   303: getfield 59	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   306: putfield 191	com/tencent/mm/protocal/protobuf/cym:Scene	I
    //   309: aload_0
    //   310: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   313: aload_1
    //   314: getfield 194	com/tencent/mm/plugin/websearch/api/s:low	Ljava/lang/String;
    //   317: putfield 197	com/tencent/mm/protocal/protobuf/cym:wBZ	Ljava/lang/String;
    //   320: aload_0
    //   321: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   324: aload_1
    //   325: getfield 200	com/tencent/mm/plugin/websearch/api/s:cDa	I
    //   328: putfield 203	com/tencent/mm/protocal/protobuf/cym:xHQ	I
    //   331: aload_0
    //   332: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   335: aload_1
    //   336: getfield 206	com/tencent/mm/plugin/websearch/api/s:uIG	Ljava/lang/String;
    //   339: putfield 209	com/tencent/mm/protocal/protobuf/cym:yfx	Ljava/lang/String;
    //   342: aload_0
    //   343: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   346: aload_1
    //   347: getfield 212	com/tencent/mm/plugin/websearch/api/s:uII	I
    //   350: putfield 215	com/tencent/mm/protocal/protobuf/cym:yfz	I
    //   353: aload_0
    //   354: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   357: aload_1
    //   358: getfield 218	com/tencent/mm/plugin/websearch/api/s:uIH	Ljava/lang/String;
    //   361: putfield 221	com/tencent/mm/protocal/protobuf/cym:yfy	Ljava/lang/String;
    //   364: aload_0
    //   365: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   368: aload_1
    //   369: getfield 224	com/tencent/mm/plugin/websearch/api/s:uIJ	Ljava/util/LinkedList;
    //   372: putfield 227	com/tencent/mm/protocal/protobuf/cym:yfA	Ljava/util/LinkedList;
    //   375: aload_0
    //   376: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   379: aload_1
    //   380: getfield 230	com/tencent/mm/plugin/websearch/api/s:uIO	Ljava/util/LinkedList;
    //   383: putfield 233	com/tencent/mm/protocal/protobuf/cym:yel	Ljava/util/LinkedList;
    //   386: aload_0
    //   387: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   390: getfield 233	com/tencent/mm/protocal/protobuf/cym:yel	Ljava/util/LinkedList;
    //   393: astore 9
    //   395: aload 9
    //   397: invokestatic 237	com/tencent/mm/sdk/platformtools/bo:es	(Ljava/util/List;)Z
    //   400: ifne +151 -> 551
    //   403: aload 9
    //   405: invokevirtual 243	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   408: astore 8
    //   410: aload 8
    //   412: invokeinterface 248 1 0
    //   417: ifeq +1016 -> 1433
    //   420: aload 8
    //   422: invokeinterface 252 1 0
    //   427: checkcast 254	com/tencent/mm/protocal/protobuf/up
    //   430: astore 10
    //   432: aload 10
    //   434: ifnull -24 -> 410
    //   437: ldc_w 256
    //   440: aload 10
    //   442: getfield 259	com/tencent/mm/protocal/protobuf/up:key	Ljava/lang/String;
    //   445: invokevirtual 265	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   448: ifeq -38 -> 410
    //   451: aload 10
    //   453: getfield 268	com/tencent/mm/protocal/protobuf/up:wMN	Ljava/lang/String;
    //   456: astore 8
    //   458: ldc 86
    //   460: ldc_w 270
    //   463: iconst_1
    //   464: anewarray 90	java/lang/Object
    //   467: dup
    //   468: iconst_0
    //   469: aload 8
    //   471: aastore
    //   472: invokestatic 95	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   475: aload 8
    //   477: invokestatic 84	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   480: ifne +71 -> 551
    //   483: invokestatic 276	com/tencent/mm/model/v:aae	()Lcom/tencent/mm/model/v;
    //   486: aload 8
    //   488: invokevirtual 280	com/tencent/mm/model/v:oP	(Ljava/lang/String;)Lcom/tencent/mm/model/v$b;
    //   491: astore 8
    //   493: aload 8
    //   495: ifnull +56 -> 551
    //   498: aload 8
    //   500: ldc_w 282
    //   503: ldc_w 284
    //   506: invokevirtual 290	com/tencent/mm/model/v$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   509: astore 8
    //   511: aload 8
    //   513: invokestatic 84	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   516: ifne +35 -> 551
    //   519: new 254	com/tencent/mm/protocal/protobuf/up
    //   522: dup
    //   523: invokespecial 291	com/tencent/mm/protocal/protobuf/up:<init>	()V
    //   526: astore 10
    //   528: aload 10
    //   530: ldc_w 282
    //   533: putfield 259	com/tencent/mm/protocal/protobuf/up:key	Ljava/lang/String;
    //   536: aload 10
    //   538: aload 8
    //   540: putfield 268	com/tencent/mm/protocal/protobuf/up:wMN	Ljava/lang/String;
    //   543: aload 9
    //   545: aload 10
    //   547: invokevirtual 294	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   550: pop
    //   551: aload_0
    //   552: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   555: aload_1
    //   556: getfield 298	com/tencent/mm/plugin/websearch/api/s:uIN	Lcom/tencent/mm/protocal/protobuf/cjh;
    //   559: putfield 299	com/tencent/mm/protocal/protobuf/cym:uIN	Lcom/tencent/mm/protocal/protobuf/cjh;
    //   562: aload_0
    //   563: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   566: aload_1
    //   567: getfield 302	com/tencent/mm/plugin/websearch/api/s:uIP	Ljava/util/LinkedList;
    //   570: putfield 305	com/tencent/mm/protocal/protobuf/cym:yfB	Ljava/util/LinkedList;
    //   573: aload_0
    //   574: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   577: aload_1
    //   578: getfield 308	com/tencent/mm/plugin/websearch/api/s:axa	Ljava/lang/String;
    //   581: putfield 311	com/tencent/mm/protocal/protobuf/cym:lGH	Ljava/lang/String;
    //   584: aload_0
    //   585: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   588: aload_1
    //   589: getfield 314	com/tencent/mm/plugin/websearch/api/s:cpW	Ljava/lang/String;
    //   592: putfield 317	com/tencent/mm/protocal/protobuf/cym:xpJ	Ljava/lang/String;
    //   595: aload_1
    //   596: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   599: ifnonnull +14 -> 613
    //   602: aload_1
    //   603: new 323	com/tencent/mm/protocal/protobuf/cyi
    //   606: dup
    //   607: invokespecial 324	com/tencent/mm/protocal/protobuf/cyi:<init>	()V
    //   610: putfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   613: aload_1
    //   614: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   617: getfield 328	com/tencent/mm/protocal/protobuf/cyi:yft	Lcom/tencent/mm/protocal/protobuf/mc;
    //   620: ifnonnull +17 -> 637
    //   623: aload_1
    //   624: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   627: new 330	com/tencent/mm/protocal/protobuf/mc
    //   630: dup
    //   631: invokespecial 331	com/tencent/mm/protocal/protobuf/mc:<init>	()V
    //   634: putfield 328	com/tencent/mm/protocal/protobuf/cyi:yft	Lcom/tencent/mm/protocal/protobuf/mc;
    //   637: aload_1
    //   638: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   641: getfield 328	com/tencent/mm/protocal/protobuf/cyi:yft	Lcom/tencent/mm/protocal/protobuf/mc;
    //   644: invokestatic 337	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   647: invokevirtual 343	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   650: invokevirtual 349	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   653: getfield 354	android/util/DisplayMetrics:widthPixels	I
    //   656: invokestatic 359	com/tencent/mm/plugin/appbrand/s/p:pP	(I)I
    //   659: putfield 362	com/tencent/mm/protocal/protobuf/mc:qUB	I
    //   662: ldc 86
    //   664: ldc_w 364
    //   667: iconst_3
    //   668: anewarray 90	java/lang/Object
    //   671: dup
    //   672: iconst_0
    //   673: invokestatic 337	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   676: invokevirtual 343	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   679: invokevirtual 349	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   682: getfield 354	android/util/DisplayMetrics:widthPixels	I
    //   685: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   688: aastore
    //   689: dup
    //   690: iconst_1
    //   691: aload_1
    //   692: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   695: getfield 328	com/tencent/mm/protocal/protobuf/cyi:yft	Lcom/tencent/mm/protocal/protobuf/mc;
    //   698: getfield 362	com/tencent/mm/protocal/protobuf/mc:qUB	I
    //   701: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   704: aastore
    //   705: dup
    //   706: iconst_2
    //   707: invokestatic 337	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   710: invokevirtual 343	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   713: invokevirtual 349	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   716: getfield 374	android/util/DisplayMetrics:density	F
    //   719: invokestatic 379	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   722: aastore
    //   723: invokestatic 382	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   726: fconst_0
    //   727: fstore_3
    //   728: fconst_0
    //   729: fstore_2
    //   730: aload_0
    //   731: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   734: getfield 171	com/tencent/mm/protocal/protobuf/cym:xqU	Lcom/tencent/mm/protocal/protobuf/azu;
    //   737: ifnull +632 -> 1369
    //   740: aload_1
    //   741: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   744: getfield 328	com/tencent/mm/protocal/protobuf/cyi:yft	Lcom/tencent/mm/protocal/protobuf/mc;
    //   747: astore 8
    //   749: invokestatic 388	com/tencent/mm/modelgeo/d:agQ	()Lcom/tencent/mm/modelgeo/d;
    //   752: invokevirtual 391	com/tencent/mm/modelgeo/d:agT	()Z
    //   755: ifeq +608 -> 1363
    //   758: iconst_0
    //   759: istore 4
    //   761: aload 8
    //   763: iload 4
    //   765: putfield 394	com/tencent/mm/protocal/protobuf/mc:wAD	I
    //   768: aload_0
    //   769: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   772: getfield 171	com/tencent/mm/protocal/protobuf/cym:xqU	Lcom/tencent/mm/protocal/protobuf/azu;
    //   775: getfield 399	com/tencent/mm/protocal/protobuf/azu:wDh	F
    //   778: fstore_3
    //   779: aload_0
    //   780: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   783: getfield 171	com/tencent/mm/protocal/protobuf/cym:xqU	Lcom/tencent/mm/protocal/protobuf/azu;
    //   786: getfield 402	com/tencent/mm/protocal/protobuf/azu:wDi	F
    //   789: fstore_2
    //   790: ldc 86
    //   792: ldc_w 404
    //   795: iconst_3
    //   796: anewarray 90	java/lang/Object
    //   799: dup
    //   800: iconst_0
    //   801: fload_3
    //   802: invokestatic 379	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   805: aastore
    //   806: dup
    //   807: iconst_1
    //   808: fload_2
    //   809: invokestatic 379	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   812: aastore
    //   813: dup
    //   814: iconst_2
    //   815: aload_1
    //   816: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   819: getfield 328	com/tencent/mm/protocal/protobuf/cyi:yft	Lcom/tencent/mm/protocal/protobuf/mc;
    //   822: getfield 394	com/tencent/mm/protocal/protobuf/mc:wAD	I
    //   825: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   828: aastore
    //   829: invokestatic 95	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   832: aload_1
    //   833: getfield 407	com/tencent/mm/plugin/websearch/api/s:uIT	Ljava/lang/String;
    //   836: invokestatic 413	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   839: ifne +148 -> 987
    //   842: aload_1
    //   843: getfield 407	com/tencent/mm/plugin/websearch/api/s:uIT	Ljava/lang/String;
    //   846: invokestatic 419	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   849: astore 8
    //   851: new 421	org/json/JSONObject
    //   854: dup
    //   855: aload 8
    //   857: invokespecial 424	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   860: astore 8
    //   862: new 426	com/tencent/mm/protocal/protobuf/bmt
    //   865: dup
    //   866: invokespecial 427	com/tencent/mm/protocal/protobuf/bmt:<init>	()V
    //   869: astore 9
    //   871: aload 9
    //   873: aload 8
    //   875: ldc_w 429
    //   878: invokevirtual 432	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   881: putfield 435	com/tencent/mm/protocal/protobuf/bmt:gwR	Ljava/lang/String;
    //   884: aload 9
    //   886: aload 8
    //   888: ldc_w 437
    //   891: invokevirtual 432	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   894: putfield 440	com/tencent/mm/protocal/protobuf/bmt:gwY	Ljava/lang/String;
    //   897: aload 9
    //   899: aload 8
    //   901: ldc_w 442
    //   904: invokevirtual 446	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   907: d2f
    //   908: putfield 447	com/tencent/mm/protocal/protobuf/bmt:wDi	F
    //   911: aload 9
    //   913: aload 8
    //   915: ldc_w 449
    //   918: invokevirtual 446	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   921: d2f
    //   922: putfield 450	com/tencent/mm/protocal/protobuf/bmt:wDh	F
    //   925: aload 9
    //   927: aload 8
    //   929: ldc_w 452
    //   932: invokevirtual 432	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   935: putfield 455	com/tencent/mm/protocal/protobuf/bmt:xBc	Ljava/lang/String;
    //   938: aload 9
    //   940: aload 8
    //   942: ldc_w 457
    //   945: invokevirtual 432	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   948: putfield 460	com/tencent/mm/protocal/protobuf/bmt:xlb	Ljava/lang/String;
    //   951: aload 9
    //   953: aload 8
    //   955: ldc_w 462
    //   958: invokevirtual 432	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   961: invokestatic 466	com/tencent/mm/plugin/websearch/api/aa:ZN	(Ljava/lang/String;)J
    //   964: putfield 469	com/tencent/mm/protocal/protobuf/bmt:xBe	J
    //   967: aload 9
    //   969: getfield 455	com/tencent/mm/protocal/protobuf/bmt:xBc	Ljava/lang/String;
    //   972: invokestatic 413	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   975: ifne +12 -> 987
    //   978: aload_0
    //   979: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   982: aload 9
    //   984: putfield 473	com/tencent/mm/protocal/protobuf/cym:yfE	Lcom/tencent/mm/protocal/protobuf/bmt;
    //   987: aload_1
    //   988: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   991: ifnull +96 -> 1087
    //   994: aload_1
    //   995: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   998: ldc_w 475
    //   1001: invokestatic 481	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1004: checkcast 475	com/tencent/mm/plugin/appbrand/service/e
    //   1007: invokeinterface 485 1 0
    //   1012: putfield 488	com/tencent/mm/protocal/protobuf/cyi:yfu	I
    //   1015: aload_0
    //   1016: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   1019: new 490	com/tencent/mm/bv/b
    //   1022: dup
    //   1023: aload_1
    //   1024: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   1027: invokevirtual 494	com/tencent/mm/protocal/protobuf/cyi:toByteArray	()[B
    //   1030: invokespecial 497	com/tencent/mm/bv/b:<init>	([B)V
    //   1033: putfield 501	com/tencent/mm/protocal/protobuf/cym:xpK	Lcom/tencent/mm/bv/b;
    //   1036: ldc 86
    //   1038: ldc_w 503
    //   1041: iconst_3
    //   1042: anewarray 90	java/lang/Object
    //   1045: dup
    //   1046: iconst_0
    //   1047: aload_1
    //   1048: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   1051: getfield 506	com/tencent/mm/protocal/protobuf/cyi:yfs	J
    //   1054: invokestatic 511	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1057: aastore
    //   1058: dup
    //   1059: iconst_1
    //   1060: aload_1
    //   1061: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   1064: getfield 328	com/tencent/mm/protocal/protobuf/cyi:yft	Lcom/tencent/mm/protocal/protobuf/mc;
    //   1067: getfield 514	com/tencent/mm/protocal/protobuf/mc:cwc	Ljava/lang/String;
    //   1070: aastore
    //   1071: dup
    //   1072: iconst_2
    //   1073: aload_1
    //   1074: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   1077: getfield 328	com/tencent/mm/protocal/protobuf/cyi:yft	Lcom/tencent/mm/protocal/protobuf/mc;
    //   1080: getfield 517	com/tencent/mm/protocal/protobuf/mc:kXm	Ljava/lang/String;
    //   1083: aastore
    //   1084: invokestatic 382	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1087: aload_1
    //   1088: getfield 521	com/tencent/mm/plugin/websearch/api/s:uIR	Lcom/tencent/mm/protocal/protobuf/dbf;
    //   1091: ifnull +24 -> 1115
    //   1094: aload_0
    //   1095: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   1098: new 490	com/tencent/mm/bv/b
    //   1101: dup
    //   1102: aload_1
    //   1103: getfield 521	com/tencent/mm/plugin/websearch/api/s:uIR	Lcom/tencent/mm/protocal/protobuf/dbf;
    //   1106: invokevirtual 524	com/tencent/mm/protocal/protobuf/dbf:toByteArray	()[B
    //   1109: invokespecial 497	com/tencent/mm/bv/b:<init>	([B)V
    //   1112: putfield 527	com/tencent/mm/protocal/protobuf/cym:xpL	Lcom/tencent/mm/bv/b;
    //   1115: aload_0
    //   1116: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   1119: getfield 171	com/tencent/mm/protocal/protobuf/cym:xqU	Lcom/tencent/mm/protocal/protobuf/azu;
    //   1122: ifnull +280 -> 1402
    //   1125: iconst_1
    //   1126: istore 6
    //   1128: ldc 86
    //   1130: ldc_w 529
    //   1133: bipush 7
    //   1135: anewarray 90	java/lang/Object
    //   1138: dup
    //   1139: iconst_0
    //   1140: iload 6
    //   1142: invokestatic 534	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1145: aastore
    //   1146: dup
    //   1147: iconst_1
    //   1148: aload_1
    //   1149: getfield 185	com/tencent/mm/plugin/websearch/api/s:uIF	Ljava/util/LinkedList;
    //   1152: invokevirtual 537	java/util/LinkedList:size	()I
    //   1155: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1158: aastore
    //   1159: dup
    //   1160: iconst_2
    //   1161: aload_1
    //   1162: getfield 59	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   1165: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1168: aastore
    //   1169: dup
    //   1170: iconst_3
    //   1171: aload_1
    //   1172: getfield 157	com/tencent/mm/plugin/websearch/api/s:businessType	I
    //   1175: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1178: aastore
    //   1179: dup
    //   1180: iconst_4
    //   1181: aload_0
    //   1182: getfield 71	com/tencent/mm/plugin/webview/fts/e:uIE	I
    //   1185: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1188: aastore
    //   1189: dup
    //   1190: iconst_5
    //   1191: aload_1
    //   1192: getfield 200	com/tencent/mm/plugin/websearch/api/s:cDa	I
    //   1195: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1198: aastore
    //   1199: dup
    //   1200: bipush 6
    //   1202: aload_1
    //   1203: getfield 65	com/tencent/mm/plugin/websearch/api/s:cCT	I
    //   1206: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1209: aastore
    //   1210: invokestatic 95	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1213: aload_0
    //   1214: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   1217: getfield 171	com/tencent/mm/protocal/protobuf/cym:xqU	Lcom/tencent/mm/protocal/protobuf/azu;
    //   1220: ifnull +39 -> 1259
    //   1223: sipush 2005
    //   1226: aload_0
    //   1227: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   1230: getfield 171	com/tencent/mm/protocal/protobuf/cym:xqU	Lcom/tencent/mm/protocal/protobuf/azu;
    //   1233: getfield 399	com/tencent/mm/protocal/protobuf/azu:wDh	F
    //   1236: aload_0
    //   1237: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   1240: getfield 171	com/tencent/mm/protocal/protobuf/cym:xqU	Lcom/tencent/mm/protocal/protobuf/azu;
    //   1243: getfield 402	com/tencent/mm/protocal/protobuf/azu:wDi	F
    //   1246: aload_0
    //   1247: getfield 148	com/tencent/mm/plugin/webview/fts/e:uPd	Lcom/tencent/mm/protocal/protobuf/cym;
    //   1250: getfield 171	com/tencent/mm/protocal/protobuf/cym:xqU	Lcom/tencent/mm/protocal/protobuf/azu;
    //   1253: getfield 540	com/tencent/mm/protocal/protobuf/azu:wSk	I
    //   1256: invokestatic 546	com/tencent/mm/modelstat/o:a	(IFFI)V
    //   1259: aload_1
    //   1260: getfield 59	com/tencent/mm/plugin/websearch/api/s:scene	I
    //   1263: istore 4
    //   1265: aload_1
    //   1266: getfield 314	com/tencent/mm/plugin/websearch/api/s:cpW	Ljava/lang/String;
    //   1269: astore 8
    //   1271: aload_1
    //   1272: getfield 549	com/tencent/mm/plugin/websearch/api/s:cCW	Ljava/lang/String;
    //   1275: astore 9
    //   1277: aload_1
    //   1278: getfield 194	com/tencent/mm/plugin/websearch/api/s:low	Ljava/lang/String;
    //   1281: astore 10
    //   1283: aload_1
    //   1284: getfield 54	com/tencent/mm/plugin/websearch/api/s:offset	I
    //   1287: istore 5
    //   1289: iload 7
    //   1291: istore 6
    //   1293: aload_1
    //   1294: getfield 70	com/tencent/mm/plugin/websearch/api/s:uIE	I
    //   1297: iconst_1
    //   1298: if_icmpne +6 -> 1304
    //   1301: iconst_1
    //   1302: istore 6
    //   1304: iload 4
    //   1306: aload 8
    //   1308: aload 9
    //   1310: aload 10
    //   1312: iload 5
    //   1314: iload 6
    //   1316: aload_1
    //   1317: getfield 48	com/tencent/mm/plugin/websearch/api/s:ohe	Ljava/lang/String;
    //   1320: aload_1
    //   1321: getfield 42	com/tencent/mm/plugin/websearch/api/s:cnv	Ljava/lang/String;
    //   1324: aload_1
    //   1325: getfield 157	com/tencent/mm/plugin/websearch/api/s:businessType	I
    //   1328: invokestatic 554	com/tencent/mm/plugin/websearch/api/z:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;I)V
    //   1331: sipush 5714
    //   1334: invokestatic 557	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1337: return
    //   1338: iconst_0
    //   1339: istore 4
    //   1341: goto -1196 -> 145
    //   1344: aload 8
    //   1346: sipush 719
    //   1349: putfield 111	com/tencent/mm/ai/b$a:funcId	I
    //   1352: aload 8
    //   1354: ldc_w 559
    //   1357: putfield 116	com/tencent/mm/ai/b$a:uri	Ljava/lang/String;
    //   1360: goto -1189 -> 171
    //   1363: iconst_1
    //   1364: istore 4
    //   1366: goto -605 -> 761
    //   1369: aload_1
    //   1370: getfield 321	com/tencent/mm/plugin/websearch/api/s:uIS	Lcom/tencent/mm/protocal/protobuf/cyi;
    //   1373: getfield 328	com/tencent/mm/protocal/protobuf/cyi:yft	Lcom/tencent/mm/protocal/protobuf/mc;
    //   1376: iconst_1
    //   1377: putfield 394	com/tencent/mm/protocal/protobuf/mc:wAD	I
    //   1380: goto -590 -> 790
    //   1383: astore 8
    //   1385: ldc 86
    //   1387: aload 8
    //   1389: ldc_w 284
    //   1392: iconst_0
    //   1393: anewarray 90	java/lang/Object
    //   1396: invokestatic 563	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1399: goto -412 -> 987
    //   1402: iconst_0
    //   1403: istore 6
    //   1405: goto -277 -> 1128
    //   1408: ldc 86
    //   1410: ldc_w 565
    //   1413: invokestatic 569	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1416: sipush 5714
    //   1419: invokestatic 557	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1422: return
    //   1423: astore 8
    //   1425: goto -310 -> 1115
    //   1428: astore 8
    //   1430: goto -343 -> 1087
    //   1433: aconst_null
    //   1434: astore 8
    //   1436: goto -978 -> 458
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1439	0	this	e
    //   0	1439	1	params	s
    //   729	80	2	f1	float
    //   727	75	3	f2	float
    //   143	1222	4	i	int
    //   1287	26	5	j	int
    //   1126	278	6	bool1	boolean
    //   1	1289	7	bool2	boolean
    //   122	1231	8	localObject1	Object
    //   1383	5	8	localJSONException	org.json.JSONException
    //   1423	1	8	localException1	java.lang.Exception
    //   1428	1	8	localException2	java.lang.Exception
    //   1434	1	8	localObject2	Object
    //   393	916	9	localObject3	Object
    //   430	881	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   851	987	1383	org/json/JSONException
    //   1094	1115	1423	java/lang/Exception
    //   994	1087	1428	java/lang/Exception
  }
  
  public final void aB(LinkedList<cpj> paramLinkedList)
  {
    AppMethodBeat.i(5717);
    this.uPd.xKn = paramLinkedList;
    cdv localcdv = new cdv();
    localcdv.xOs = paramLinkedList.size();
    this.uPd.yfC = localcdv;
    AppMethodBeat.o(5717);
  }
  
  public final String act()
  {
    if (this.uPc != null) {
      return this.uPc.wAa;
    }
    return "";
  }
  
  public final int acu()
  {
    if (this.uPc != null) {
      return this.uPc.xpM;
    }
    return 0;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(5715);
    an.gF(this.scene, 2);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(5715);
    return i;
  }
  
  public final int getType()
  {
    return 719;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5716);
    ab.i("MicroMsg.WebSearch.NetSceneWebSearch", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        break label200;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramInt1 = this.fpY.scene;
      paramString = this.fpY.cpW;
      paramq = this.fpY.cCW;
      paramArrayOfByte = this.fpY.low;
      i = this.fpY.offset;
      if (this.fpY.uIE != 1) {
        break label194;
      }
    }
    label194:
    for (boolean bool2 = true;; bool2 = false)
    {
      z.a(paramInt1, paramString, paramq, paramArrayOfByte, i, bool2, this.fpY.ohe, bool1, this.fpY.cnv, this.fpY.businessType);
      an.am(this.scene, paramInt2, paramInt3);
      AppMethodBeat.o(5716);
      return;
      bool1 = false;
      break;
    }
    label200:
    this.uPc = ((cyn)this.fBd.fsW.fta);
    String str;
    if (this.uPc != null)
    {
      paramInt1 = this.fpY.scene;
      paramq = this.fpY.cpW;
      paramArrayOfByte = this.fpY.cCW;
      str = this.fpY.low;
      i = this.fpY.offset;
      if (this.fpY.uIE != 1) {
        break label371;
      }
    }
    label371:
    for (bool2 = true;; bool2 = false)
    {
      z.a(paramInt1, paramq, paramArrayOfByte, str, i, bool2, this.fpY.ohe, bool1, this.fpY.cnv, this.fpY.businessType);
      ab.v("MicroMsg.WebSearch.NetSceneWebSearch", "return data\n%s", new Object[] { this.uPc.wAa });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      an.am(this.scene, paramInt2, paramInt3);
      AppMethodBeat.o(5716);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.e
 * JD-Core Version:    0.7.0.1
 */