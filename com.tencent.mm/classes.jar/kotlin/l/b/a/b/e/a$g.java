package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.h.t;

public final class a$g
  extends i
  implements j
{
  public static t<g> aiYa;
  private static final g aiZD;
  private final d aiXZ;
  int aiYq;
  int aiZE;
  b aiZF;
  a.p aiZG;
  int aiZH;
  private List<g> aiZI;
  private List<g> aiZJ;
  private int bitField0_;
  private int dRJ = -1;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(58584);
    aiYa = new b() {};
    g localg = new g();
    aiZD = localg;
    localg.ktf();
    AppMethodBeat.o(58584);
  }
  
  private a$g()
  {
    this.aiXZ = d.ajeU;
  }
  
  /* Error */
  private a$g(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 67	kotlin/l/b/a/b/h/i:<init>	()V
    //   4: ldc 84
    //   6: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 69	kotlin/l/b/a/b/e/a$g:memoizedIsInitialized	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 71	kotlin/l/b/a/b/e/a$g:dRJ	I
    //   19: aload_0
    //   20: invokespecial 62	kotlin/l/b/a/b/e/a$g:ktf	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 88	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
    //   28: astore 11
    //   30: aload 11
    //   32: iconst_1
    //   33: invokestatic 93	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   36: astore 12
    //   38: iconst_0
    //   39: istore 5
    //   41: iload 5
    //   43: ifne +737 -> 780
    //   46: iload_3
    //   47: istore 6
    //   49: iload_3
    //   50: istore 7
    //   52: iload_3
    //   53: istore 8
    //   55: aload_1
    //   56: invokevirtual 99	kotlin/l/b/a/b/h/e:aac	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+871->934, 0:+874->937, 8:+101->164, 16:+232->295, 24:+312->375, 34:+420->483, 40:+548->611, 50:+588->651, 58:+662->725
    //   137: istore 6
    //   139: iload_3
    //   140: istore 7
    //   142: iload_3
    //   143: istore 8
    //   145: aload_0
    //   146: aload_1
    //   147: aload 12
    //   149: aload_2
    //   150: iload 4
    //   152: invokevirtual 102	kotlin/l/b/a/b/e/a$g:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   155: ifne +776 -> 931
    //   158: iconst_1
    //   159: istore 5
    //   161: goto -120 -> 41
    //   164: iload_3
    //   165: istore 6
    //   167: iload_3
    //   168: istore 7
    //   170: iload_3
    //   171: istore 8
    //   173: aload_0
    //   174: aload_0
    //   175: getfield 104	kotlin/l/b/a/b/e/a$g:bitField0_	I
    //   178: iconst_1
    //   179: ior
    //   180: putfield 104	kotlin/l/b/a/b/e/a$g:bitField0_	I
    //   183: iload_3
    //   184: istore 6
    //   186: iload_3
    //   187: istore 7
    //   189: iload_3
    //   190: istore 8
    //   192: aload_0
    //   193: aload_1
    //   194: invokevirtual 107	kotlin/l/b/a/b/h/e:aar	()I
    //   197: putfield 109	kotlin/l/b/a/b/e/a$g:aiYq	I
    //   200: goto -159 -> 41
    //   203: astore_1
    //   204: iload 6
    //   206: istore 4
    //   208: iload 4
    //   210: istore_3
    //   211: aload_1
    //   212: aload_0
    //   213: putfield 113	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   216: iload 4
    //   218: istore_3
    //   219: ldc 84
    //   221: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: iload 4
    //   226: istore_3
    //   227: aload_1
    //   228: athrow
    //   229: astore_1
    //   230: iload_3
    //   231: bipush 32
    //   233: iand
    //   234: bipush 32
    //   236: if_icmpne +14 -> 250
    //   239: aload_0
    //   240: aload_0
    //   241: getfield 115	kotlin/l/b/a/b/e/a$g:aiZI	Ljava/util/List;
    //   244: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   247: putfield 115	kotlin/l/b/a/b/e/a$g:aiZI	Ljava/util/List;
    //   250: iload_3
    //   251: bipush 64
    //   253: iand
    //   254: bipush 64
    //   256: if_icmpne +14 -> 270
    //   259: aload_0
    //   260: aload_0
    //   261: getfield 123	kotlin/l/b/a/b/e/a$g:aiZJ	Ljava/util/List;
    //   264: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   267: putfield 123	kotlin/l/b/a/b/e/a$g:aiZJ	Ljava/util/List;
    //   270: aload 12
    //   272: invokevirtual 126	kotlin/l/b/a/b/h/f:flush	()V
    //   275: aload_0
    //   276: aload 11
    //   278: invokevirtual 132	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   281: putfield 78	kotlin/l/b/a/b/e/a$g:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   284: aload_0
    //   285: invokevirtual 135	kotlin/l/b/a/b/e/a$g:makeExtensionsImmutable	()V
    //   288: ldc 84
    //   290: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: aload_1
    //   294: athrow
    //   295: iload_3
    //   296: istore 6
    //   298: iload_3
    //   299: istore 7
    //   301: iload_3
    //   302: istore 8
    //   304: aload_0
    //   305: aload_0
    //   306: getfield 104	kotlin/l/b/a/b/e/a$g:bitField0_	I
    //   309: iconst_2
    //   310: ior
    //   311: putfield 104	kotlin/l/b/a/b/e/a$g:bitField0_	I
    //   314: iload_3
    //   315: istore 6
    //   317: iload_3
    //   318: istore 7
    //   320: iload_3
    //   321: istore 8
    //   323: aload_0
    //   324: aload_1
    //   325: invokevirtual 107	kotlin/l/b/a/b/h/e:aar	()I
    //   328: putfield 137	kotlin/l/b/a/b/e/a$g:aiZE	I
    //   331: goto -290 -> 41
    //   334: astore_1
    //   335: iload 7
    //   337: istore 4
    //   339: iload 4
    //   341: istore_3
    //   342: new 81	kotlin/l/b/a/b/h/l
    //   345: dup
    //   346: aload_1
    //   347: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   350: invokespecial 144	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   353: astore_1
    //   354: iload 4
    //   356: istore_3
    //   357: aload_1
    //   358: aload_0
    //   359: putfield 113	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   362: iload 4
    //   364: istore_3
    //   365: ldc 84
    //   367: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   370: iload 4
    //   372: istore_3
    //   373: aload_1
    //   374: athrow
    //   375: iload_3
    //   376: istore 6
    //   378: iload_3
    //   379: istore 7
    //   381: iload_3
    //   382: istore 8
    //   384: aload_1
    //   385: invokevirtual 107	kotlin/l/b/a/b/h/e:aar	()I
    //   388: istore 9
    //   390: iload_3
    //   391: istore 6
    //   393: iload_3
    //   394: istore 7
    //   396: iload_3
    //   397: istore 8
    //   399: iload 9
    //   401: invokestatic 148	kotlin/l/b/a/b/e/a$g$b:aKY	(I)Lkotlin/l/b/a/b/e/a$g$b;
    //   404: astore 10
    //   406: aload 10
    //   408: ifnonnull +38 -> 446
    //   411: iload_3
    //   412: istore 6
    //   414: iload_3
    //   415: istore 7
    //   417: iload_3
    //   418: istore 8
    //   420: aload 12
    //   422: iload 4
    //   424: invokevirtual 151	kotlin/l/b/a/b/h/f:lI	(I)V
    //   427: iload_3
    //   428: istore 6
    //   430: iload_3
    //   431: istore 7
    //   433: iload_3
    //   434: istore 8
    //   436: aload 12
    //   438: iload 9
    //   440: invokevirtual 151	kotlin/l/b/a/b/h/f:lI	(I)V
    //   443: goto -402 -> 41
    //   446: iload_3
    //   447: istore 6
    //   449: iload_3
    //   450: istore 7
    //   452: iload_3
    //   453: istore 8
    //   455: aload_0
    //   456: aload_0
    //   457: getfield 104	kotlin/l/b/a/b/e/a$g:bitField0_	I
    //   460: iconst_4
    //   461: ior
    //   462: putfield 104	kotlin/l/b/a/b/e/a$g:bitField0_	I
    //   465: iload_3
    //   466: istore 6
    //   468: iload_3
    //   469: istore 7
    //   471: iload_3
    //   472: istore 8
    //   474: aload_0
    //   475: aload 10
    //   477: putfield 153	kotlin/l/b/a/b/e/a$g:aiZF	Lkotlin/l/b/a/b/e/a$g$b;
    //   480: goto -439 -> 41
    //   483: iload_3
    //   484: istore 6
    //   486: iload_3
    //   487: istore 7
    //   489: iload_3
    //   490: istore 8
    //   492: aload_0
    //   493: getfield 104	kotlin/l/b/a/b/e/a$g:bitField0_	I
    //   496: bipush 8
    //   498: iand
    //   499: bipush 8
    //   501: if_icmpne +424 -> 925
    //   504: iload_3
    //   505: istore 6
    //   507: iload_3
    //   508: istore 7
    //   510: iload_3
    //   511: istore 8
    //   513: aload_0
    //   514: getfield 155	kotlin/l/b/a/b/e/a$g:aiZG	Lkotlin/l/b/a/b/e/a$p;
    //   517: invokestatic 160	kotlin/l/b/a/b/e/a$p:g	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   520: astore 10
    //   522: iload_3
    //   523: istore 6
    //   525: iload_3
    //   526: istore 7
    //   528: iload_3
    //   529: istore 8
    //   531: aload_0
    //   532: aload_1
    //   533: getstatic 161	kotlin/l/b/a/b/e/a$p:aiYa	Lkotlin/l/b/a/b/h/t;
    //   536: aload_2
    //   537: invokevirtual 164	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   540: checkcast 157	kotlin/l/b/a/b/e/a$p
    //   543: putfield 155	kotlin/l/b/a/b/e/a$g:aiZG	Lkotlin/l/b/a/b/e/a$p;
    //   546: aload 10
    //   548: ifnull +40 -> 588
    //   551: iload_3
    //   552: istore 6
    //   554: iload_3
    //   555: istore 7
    //   557: iload_3
    //   558: istore 8
    //   560: aload 10
    //   562: aload_0
    //   563: getfield 155	kotlin/l/b/a/b/e/a$g:aiZG	Lkotlin/l/b/a/b/e/a$p;
    //   566: invokevirtual 169	kotlin/l/b/a/b/e/a$p$b:k	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   569: pop
    //   570: iload_3
    //   571: istore 6
    //   573: iload_3
    //   574: istore 7
    //   576: iload_3
    //   577: istore 8
    //   579: aload_0
    //   580: aload 10
    //   582: invokevirtual 173	kotlin/l/b/a/b/e/a$p$b:kwd	()Lkotlin/l/b/a/b/e/a$p;
    //   585: putfield 155	kotlin/l/b/a/b/e/a$g:aiZG	Lkotlin/l/b/a/b/e/a$p;
    //   588: iload_3
    //   589: istore 6
    //   591: iload_3
    //   592: istore 7
    //   594: iload_3
    //   595: istore 8
    //   597: aload_0
    //   598: aload_0
    //   599: getfield 104	kotlin/l/b/a/b/e/a$g:bitField0_	I
    //   602: bipush 8
    //   604: ior
    //   605: putfield 104	kotlin/l/b/a/b/e/a$g:bitField0_	I
    //   608: goto -567 -> 41
    //   611: iload_3
    //   612: istore 6
    //   614: iload_3
    //   615: istore 7
    //   617: iload_3
    //   618: istore 8
    //   620: aload_0
    //   621: aload_0
    //   622: getfield 104	kotlin/l/b/a/b/e/a$g:bitField0_	I
    //   625: bipush 16
    //   627: ior
    //   628: putfield 104	kotlin/l/b/a/b/e/a$g:bitField0_	I
    //   631: iload_3
    //   632: istore 6
    //   634: iload_3
    //   635: istore 7
    //   637: iload_3
    //   638: istore 8
    //   640: aload_0
    //   641: aload_1
    //   642: invokevirtual 107	kotlin/l/b/a/b/h/e:aar	()I
    //   645: putfield 175	kotlin/l/b/a/b/e/a$g:aiZH	I
    //   648: goto -607 -> 41
    //   651: iload_3
    //   652: istore 4
    //   654: iload_3
    //   655: bipush 32
    //   657: iand
    //   658: bipush 32
    //   660: if_icmpeq +29 -> 689
    //   663: iload_3
    //   664: istore 6
    //   666: iload_3
    //   667: istore 7
    //   669: iload_3
    //   670: istore 8
    //   672: aload_0
    //   673: new 177	java/util/ArrayList
    //   676: dup
    //   677: invokespecial 178	java/util/ArrayList:<init>	()V
    //   680: putfield 115	kotlin/l/b/a/b/e/a$g:aiZI	Ljava/util/List;
    //   683: iload_3
    //   684: bipush 32
    //   686: ior
    //   687: istore 4
    //   689: iload 4
    //   691: istore 6
    //   693: iload 4
    //   695: istore 7
    //   697: iload 4
    //   699: istore 8
    //   701: aload_0
    //   702: getfield 115	kotlin/l/b/a/b/e/a$g:aiZI	Ljava/util/List;
    //   705: aload_1
    //   706: getstatic 56	kotlin/l/b/a/b/e/a$g:aiYa	Lkotlin/l/b/a/b/h/t;
    //   709: aload_2
    //   710: invokevirtual 164	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   713: invokeinterface 184 2 0
    //   718: pop
    //   719: iload 4
    //   721: istore_3
    //   722: goto -681 -> 41
    //   725: iload_3
    //   726: bipush 64
    //   728: iand
    //   729: bipush 64
    //   731: if_icmpeq +191 -> 922
    //   734: iload_3
    //   735: istore 6
    //   737: iload_3
    //   738: istore 7
    //   740: iload_3
    //   741: istore 8
    //   743: aload_0
    //   744: new 177	java/util/ArrayList
    //   747: dup
    //   748: invokespecial 178	java/util/ArrayList:<init>	()V
    //   751: putfield 123	kotlin/l/b/a/b/e/a$g:aiZJ	Ljava/util/List;
    //   754: iload_3
    //   755: bipush 64
    //   757: ior
    //   758: istore_3
    //   759: aload_0
    //   760: getfield 123	kotlin/l/b/a/b/e/a$g:aiZJ	Ljava/util/List;
    //   763: aload_1
    //   764: getstatic 56	kotlin/l/b/a/b/e/a$g:aiYa	Lkotlin/l/b/a/b/h/t;
    //   767: aload_2
    //   768: invokevirtual 164	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   771: invokeinterface 184 2 0
    //   776: pop
    //   777: goto -736 -> 41
    //   780: iload_3
    //   781: bipush 32
    //   783: iand
    //   784: bipush 32
    //   786: if_icmpne +14 -> 800
    //   789: aload_0
    //   790: aload_0
    //   791: getfield 115	kotlin/l/b/a/b/e/a$g:aiZI	Ljava/util/List;
    //   794: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   797: putfield 115	kotlin/l/b/a/b/e/a$g:aiZI	Ljava/util/List;
    //   800: iload_3
    //   801: bipush 64
    //   803: iand
    //   804: bipush 64
    //   806: if_icmpne +14 -> 820
    //   809: aload_0
    //   810: aload_0
    //   811: getfield 123	kotlin/l/b/a/b/e/a$g:aiZJ	Ljava/util/List;
    //   814: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   817: putfield 123	kotlin/l/b/a/b/e/a$g:aiZJ	Ljava/util/List;
    //   820: aload 12
    //   822: invokevirtual 126	kotlin/l/b/a/b/h/f:flush	()V
    //   825: aload_0
    //   826: aload 11
    //   828: invokevirtual 132	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   831: putfield 78	kotlin/l/b/a/b/e/a$g:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   834: aload_0
    //   835: invokevirtual 135	kotlin/l/b/a/b/e/a$g:makeExtensionsImmutable	()V
    //   838: ldc 84
    //   840: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   843: return
    //   844: astore_1
    //   845: aload_0
    //   846: aload 11
    //   848: invokevirtual 132	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   851: putfield 78	kotlin/l/b/a/b/e/a$g:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   854: goto -20 -> 834
    //   857: astore_1
    //   858: aload_0
    //   859: aload 11
    //   861: invokevirtual 132	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   864: putfield 78	kotlin/l/b/a/b/e/a$g:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   867: ldc 84
    //   869: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   872: aload_1
    //   873: athrow
    //   874: astore_2
    //   875: aload_0
    //   876: aload 11
    //   878: invokevirtual 132	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   881: putfield 78	kotlin/l/b/a/b/e/a$g:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   884: goto -600 -> 284
    //   887: astore_1
    //   888: aload_0
    //   889: aload 11
    //   891: invokevirtual 132	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   894: putfield 78	kotlin/l/b/a/b/e/a$g:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   897: ldc 84
    //   899: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   902: aload_1
    //   903: athrow
    //   904: astore_1
    //   905: goto -675 -> 230
    //   908: astore_1
    //   909: iload_3
    //   910: istore 4
    //   912: goto -573 -> 339
    //   915: astore_1
    //   916: iload_3
    //   917: istore 4
    //   919: goto -711 -> 208
    //   922: goto -163 -> 759
    //   925: aconst_null
    //   926: astore 10
    //   928: goto -406 -> 522
    //   931: goto -154 -> 777
    //   934: goto -798 -> 136
    //   937: iconst_1
    //   938: istore 5
    //   940: goto -899 -> 41
    //   943: astore_1
    //   944: iload 8
    //   946: istore_3
    //   947: goto -717 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	950	0	this	g
    //   0	950	1	parame	kotlin.l.b.a.b.h.e
    //   0	950	2	paramg	kotlin.l.b.a.b.h.g
    //   24	923	3	i	int
    //   59	859	4	j	int
    //   39	900	5	k	int
    //   47	689	6	m	int
    //   50	689	7	n	int
    //   53	892	8	i1	int
    //   388	51	9	i2	int
    //   404	523	10	localObject	Object
    //   28	862	11	localb	kotlin.l.b.a.b.h.d.b
    //   36	785	12	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	203	kotlin/l/b/a/b/h/l
    //   145	158	203	kotlin/l/b/a/b/h/l
    //   173	183	203	kotlin/l/b/a/b/h/l
    //   192	200	203	kotlin/l/b/a/b/h/l
    //   304	314	203	kotlin/l/b/a/b/h/l
    //   323	331	203	kotlin/l/b/a/b/h/l
    //   384	390	203	kotlin/l/b/a/b/h/l
    //   399	406	203	kotlin/l/b/a/b/h/l
    //   420	427	203	kotlin/l/b/a/b/h/l
    //   436	443	203	kotlin/l/b/a/b/h/l
    //   455	465	203	kotlin/l/b/a/b/h/l
    //   474	480	203	kotlin/l/b/a/b/h/l
    //   492	504	203	kotlin/l/b/a/b/h/l
    //   513	522	203	kotlin/l/b/a/b/h/l
    //   531	546	203	kotlin/l/b/a/b/h/l
    //   560	570	203	kotlin/l/b/a/b/h/l
    //   579	588	203	kotlin/l/b/a/b/h/l
    //   597	608	203	kotlin/l/b/a/b/h/l
    //   620	631	203	kotlin/l/b/a/b/h/l
    //   640	648	203	kotlin/l/b/a/b/h/l
    //   672	683	203	kotlin/l/b/a/b/h/l
    //   701	719	203	kotlin/l/b/a/b/h/l
    //   743	754	203	kotlin/l/b/a/b/h/l
    //   211	216	229	finally
    //   219	224	229	finally
    //   227	229	229	finally
    //   342	354	229	finally
    //   357	362	229	finally
    //   365	370	229	finally
    //   373	375	229	finally
    //   55	61	334	java/io/IOException
    //   145	158	334	java/io/IOException
    //   173	183	334	java/io/IOException
    //   192	200	334	java/io/IOException
    //   304	314	334	java/io/IOException
    //   323	331	334	java/io/IOException
    //   384	390	334	java/io/IOException
    //   399	406	334	java/io/IOException
    //   420	427	334	java/io/IOException
    //   436	443	334	java/io/IOException
    //   455	465	334	java/io/IOException
    //   474	480	334	java/io/IOException
    //   492	504	334	java/io/IOException
    //   513	522	334	java/io/IOException
    //   531	546	334	java/io/IOException
    //   560	570	334	java/io/IOException
    //   579	588	334	java/io/IOException
    //   597	608	334	java/io/IOException
    //   620	631	334	java/io/IOException
    //   640	648	334	java/io/IOException
    //   672	683	334	java/io/IOException
    //   701	719	334	java/io/IOException
    //   743	754	334	java/io/IOException
    //   820	825	844	java/io/IOException
    //   820	825	857	finally
    //   270	275	874	java/io/IOException
    //   270	275	887	finally
    //   759	777	904	finally
    //   759	777	908	java/io/IOException
    //   759	777	915	kotlin/l/b/a/b/h/l
    //   55	61	943	finally
    //   145	158	943	finally
    //   173	183	943	finally
    //   192	200	943	finally
    //   304	314	943	finally
    //   323	331	943	finally
    //   384	390	943	finally
    //   399	406	943	finally
    //   420	427	943	finally
    //   436	443	943	finally
    //   455	465	943	finally
    //   474	480	943	finally
    //   492	504	943	finally
    //   513	522	943	finally
    //   531	546	943	finally
    //   560	570	943	finally
    //   579	588	943	finally
    //   597	608	943	finally
    //   620	631	943	finally
    //   640	648	943	finally
    //   672	683	943	finally
    //   701	719	943	finally
    //   743	754	943	finally
  }
  
  private a$g(i.a parama)
  {
    super((byte)0);
    this.aiXZ = parama.aiXZ;
  }
  
  public static a b(g paramg)
  {
    AppMethodBeat.i(58581);
    paramg = a.kuN().f(paramg);
    AppMethodBeat.o(58581);
    return paramg;
  }
  
  private void ktf()
  {
    AppMethodBeat.i(58577);
    this.aiYq = 0;
    this.aiZE = 0;
    this.aiZF = b.aiZK;
    this.aiZG = a.p.kvH();
    this.aiZH = 0;
    this.aiZI = Collections.emptyList();
    this.aiZJ = Collections.emptyList();
    AppMethodBeat.o(58577);
  }
  
  public static g kuE()
  {
    return aiZD;
  }
  
  public final void a(f paramf)
  {
    int k = 0;
    AppMethodBeat.i(58579);
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramf.cF(1, this.aiYq);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramf.cF(2, this.aiZE);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramf.cP(3, this.aiZF.value);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramf.a(4, this.aiZG);
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramf.cF(5, this.aiZH);
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.aiZI.size()) {
        break;
      }
      paramf.a(6, (r)this.aiZI.get(i));
      i += 1;
    }
    while (j < this.aiZJ.size())
    {
      paramf.a(7, (r)this.aiZJ.get(j));
      j += 1;
    }
    paramf.e(this.aiXZ);
    AppMethodBeat.o(58579);
  }
  
  public final int getSerializedSize()
  {
    int n = 0;
    AppMethodBeat.i(58580);
    int i = this.dRJ;
    if (i != -1)
    {
      AppMethodBeat.o(58580);
      return i;
    }
    if ((this.bitField0_ & 0x1) == 1) {}
    for (int j = f.cJ(1, this.aiYq) + 0;; j = 0)
    {
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + f.cJ(2, this.aiZE);
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + f.cM(3, this.aiZF.value);
      }
      i = j;
      if ((this.bitField0_ & 0x8) == 8) {
        i = j + f.c(4, this.aiZG);
      }
      j = i;
      if ((this.bitField0_ & 0x10) == 16) {
        j = i + f.cJ(5, this.aiZH);
      }
      int k = 0;
      i = j;
      j = k;
      int m;
      for (;;)
      {
        k = n;
        m = i;
        if (j >= this.aiZI.size()) {
          break;
        }
        i += f.c(6, (r)this.aiZI.get(j));
        j += 1;
      }
      while (k < this.aiZJ.size())
      {
        m += f.c(7, (r)this.aiZJ.get(k));
        k += 1;
      }
      i = this.aiXZ.size() + m;
      this.dRJ = i;
      AppMethodBeat.o(58580);
      return i;
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58578);
    int i = this.memoizedIsInitialized;
    if (i == 1)
    {
      AppMethodBeat.o(58578);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58578);
      return false;
    }
    if ((kuH()) && (!this.aiZG.isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58578);
      return false;
    }
    i = 0;
    while (i < this.aiZI.size())
    {
      if (!((g)this.aiZI.get(i)).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58578);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.aiZJ.size())
    {
      if (!((g)this.aiZJ.get(i)).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58578);
        return false;
      }
      i += 1;
    }
    this.memoizedIsInitialized = 1;
    AppMethodBeat.o(58578);
    return true;
  }
  
  public final boolean ktB()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public final boolean kuF()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public final boolean kuG()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public final boolean kuH()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public final boolean kuI()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public static final class a
    extends i.a<a.g, a>
    implements j
  {
    private int aiYq;
    private int aiZE;
    private a.g.b aiZF;
    private a.p aiZG;
    private int aiZH;
    private List<a.g> aiZI;
    private List<a.g> aiZJ;
    private int bitField0_;
    
    private a()
    {
      AppMethodBeat.i(58552);
      this.aiZF = a.g.b.aiZK;
      this.aiZG = a.p.kvH();
      this.aiZI = Collections.emptyList();
      this.aiZJ = Collections.emptyList();
      AppMethodBeat.o(58552);
    }
    
    private a a(a.g.b paramb)
    {
      AppMethodBeat.i(58558);
      if (paramb == null)
      {
        paramb = new NullPointerException();
        AppMethodBeat.o(58558);
        throw paramb;
      }
      this.bitField0_ |= 0x4;
      this.aiZF = paramb;
      AppMethodBeat.o(58558);
      return this;
    }
    
    private a aKV(int paramInt)
    {
      this.bitField0_ |= 0x1;
      this.aiYq = paramInt;
      return this;
    }
    
    private a aKW(int paramInt)
    {
      this.bitField0_ |= 0x2;
      this.aiZE = paramInt;
      return this;
    }
    
    private a aKX(int paramInt)
    {
      this.bitField0_ |= 0x10;
      this.aiZH = paramInt;
      return this;
    }
    
    private a b(a.p paramp)
    {
      AppMethodBeat.i(58559);
      if (((this.bitField0_ & 0x8) == 8) && (this.aiZG != a.p.kvH())) {}
      for (this.aiZG = a.p.g(this.aiZG).k(paramp).kwd();; this.aiZG = paramp)
      {
        this.bitField0_ |= 0x8;
        AppMethodBeat.o(58559);
        return this;
      }
    }
    
    private a kuJ()
    {
      AppMethodBeat.i(58553);
      a locala = new a().f(kuK());
      AppMethodBeat.o(58553);
      return locala;
    }
    
    private void kuL()
    {
      AppMethodBeat.i(58560);
      if ((this.bitField0_ & 0x20) != 32)
      {
        this.aiZI = new ArrayList(this.aiZI);
        this.bitField0_ |= 0x20;
      }
      AppMethodBeat.o(58560);
    }
    
    private void kuM()
    {
      AppMethodBeat.i(58561);
      if ((this.bitField0_ & 0x40) != 64)
      {
        this.aiZJ = new ArrayList(this.aiZJ);
        this.bitField0_ |= 0x40;
      }
      AppMethodBeat.o(58561);
    }
    
    /* Error */
    private a l(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 125
      //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 129	kotlin/l/b/a/b/e/a$g:aiYa	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 134 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$g
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 109	kotlin/l/b/a/b/e/a$g$a:f	(Lkotlin/l/b/a/b/e/a$g;)Lkotlin/l/b/a/b/e/a$g$a;
      //   30: pop
      //   31: ldc 125
      //   33: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 138	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   43: checkcast 9	kotlin/l/b/a/b/e/a$g
      //   46: astore_2
      //   47: ldc 125
      //   49: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: aload_2
      //   56: ifnull +9 -> 65
      //   59: aload_0
      //   60: aload_2
      //   61: invokevirtual 109	kotlin/l/b/a/b/e/a$g$a:f	(Lkotlin/l/b/a/b/e/a$g;)Lkotlin/l/b/a/b/e/a$g$a;
      //   64: pop
      //   65: ldc 125
      //   67: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   70: aload_1
      //   71: athrow
      //   72: astore_1
      //   73: aload_3
      //   74: astore_2
      //   75: goto -20 -> 55
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	a
      //   0	78	1	parame	kotlin.l.b.a.b.h.e
      //   0	78	2	paramg	kotlin.l.b.a.b.h.g
      //   6	68	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	kotlin/l/b/a/b/h/l
      //   47	54	54	finally
      //   7	21	72	finally
      //   39	47	72	finally
    }
    
    public final a f(a.g paramg)
    {
      AppMethodBeat.i(58555);
      if (paramg == a.g.kuE())
      {
        AppMethodBeat.o(58555);
        return this;
      }
      if (paramg.ktB()) {
        aKV(paramg.aiYq);
      }
      if (paramg.kuF()) {
        aKW(paramg.aiZE);
      }
      if (paramg.kuG()) {
        a(paramg.aiZF);
      }
      if (paramg.kuH()) {
        b(paramg.aiZG);
      }
      if (paramg.kuI()) {
        aKX(paramg.aiZH);
      }
      if (!a.g.c(paramg).isEmpty())
      {
        if (this.aiZI.isEmpty())
        {
          this.aiZI = a.g.c(paramg);
          this.bitField0_ &= 0xFFFFFFDF;
        }
      }
      else if (!a.g.d(paramg).isEmpty())
      {
        if (!this.aiZJ.isEmpty()) {
          break label228;
        }
        this.aiZJ = a.g.d(paramg);
        this.bitField0_ &= 0xFFFFFFBF;
      }
      for (;;)
      {
        this.aiXZ = this.aiXZ.a(a.g.e(paramg));
        AppMethodBeat.o(58555);
        return this;
        kuL();
        this.aiZI.addAll(a.g.c(paramg));
        break;
        label228:
        kuM();
        this.aiZJ.addAll(a.g.d(paramg));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58556);
      if ((this.bitField0_ & 0x8) == 8) {}
      for (int i = 1; (i != 0) && (!this.aiZG.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58556);
        return false;
      }
      i = 0;
      while (i < this.aiZI.size())
      {
        if (!((a.g)this.aiZI.get(i)).isInitialized())
        {
          AppMethodBeat.o(58556);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.aiZJ.size())
      {
        if (!((a.g)this.aiZJ.get(i)).isInitialized())
        {
          AppMethodBeat.o(58556);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(58556);
      return true;
    }
    
    public final a.g kuK()
    {
      int j = 1;
      AppMethodBeat.i(58554);
      a.g localg = new a.g(this, (byte)0);
      int k = this.bitField0_;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.g.a(localg, this.aiYq);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.g.b(localg, this.aiZE);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.g.a(localg, this.aiZF);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.g.a(localg, this.aiZG);
        j = i;
        if ((k & 0x10) == 16) {
          j = i | 0x10;
        }
        a.g.c(localg, this.aiZH);
        if ((this.bitField0_ & 0x20) == 32)
        {
          this.aiZI = Collections.unmodifiableList(this.aiZI);
          this.bitField0_ &= 0xFFFFFFDF;
        }
        a.g.a(localg, this.aiZI);
        if ((this.bitField0_ & 0x40) == 64)
        {
          this.aiZJ = Collections.unmodifiableList(this.aiZJ);
          this.bitField0_ &= 0xFFFFFFBF;
        }
        a.g.b(localg, this.aiZJ);
        a.g.d(localg, j);
        AppMethodBeat.o(58554);
        return localg;
        j = 0;
      }
    }
  }
  
  public static enum b
    implements k.a
  {
    private static k.b<b> aiYE;
    final int value;
    
    static
    {
      AppMethodBeat.i(58575);
      aiZK = new b("TRUE", 0, 0);
      aiZL = new b("FALSE", 1, 1);
      aiZM = new b("NULL", 2, 2);
      aiZN = new b[] { aiZK, aiZL, aiZM };
      aiYE = new k.b() {};
      AppMethodBeat.o(58575);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b aKY(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return aiZK;
      case 1: 
        return aiZL;
      }
      return aiZM;
    }
    
    public final int getNumber()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.g
 * JD-Core Version:    0.7.0.1
 */