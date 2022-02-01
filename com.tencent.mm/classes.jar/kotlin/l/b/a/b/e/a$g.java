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
import kotlin.l.b.a.b.h.j.a;
import kotlin.l.b.a.b.h.j.b;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.h.s;

public final class a$g
  extends i
  implements j
{
  public static s<g> TwL;
  private static final g Tyl;
  private final d TwK;
  int Txb;
  int Tym;
  b Tyn;
  a.p Tyo;
  int Typ;
  private List<g> Tyq;
  private List<g> Tyr;
  private int bOT;
  private byte bPe = -1;
  private int bVY = -1;
  
  static
  {
    AppMethodBeat.i(58584);
    TwL = new b() {};
    g localg = new g();
    Tyl = localg;
    localg.hEu();
    AppMethodBeat.o(58584);
  }
  
  private a$g()
  {
    this.TwK = d.TDp;
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
    //   11: putfield 69	kotlin/l/b/a/b/e/a$g:bPe	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 71	kotlin/l/b/a/b/e/a$g:bVY	I
    //   19: aload_0
    //   20: invokespecial 62	kotlin/l/b/a/b/e/a$g:hEu	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 88	kotlin/l/b/a/b/h/d:hJo	()Lkotlin/l/b/a/b/h/d$b;
    //   28: astore 11
    //   30: aload 11
    //   32: iconst_1
    //   33: invokestatic 94	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
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
    //   56: invokevirtual 100	kotlin/l/b/a/b/h/e:yT	()I
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
    //   152: invokevirtual 103	kotlin/l/b/a/b/e/a$g:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
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
    //   175: getfield 105	kotlin/l/b/a/b/e/a$g:bOT	I
    //   178: iconst_1
    //   179: ior
    //   180: putfield 105	kotlin/l/b/a/b/e/a$g:bOT	I
    //   183: iload_3
    //   184: istore 6
    //   186: iload_3
    //   187: istore 7
    //   189: iload_3
    //   190: istore 8
    //   192: aload_0
    //   193: aload_1
    //   194: invokevirtual 108	kotlin/l/b/a/b/h/e:zi	()I
    //   197: putfield 110	kotlin/l/b/a/b/e/a$g:Txb	I
    //   200: goto -159 -> 41
    //   203: astore_1
    //   204: iload 6
    //   206: istore 4
    //   208: iload 4
    //   210: istore_3
    //   211: aload_1
    //   212: aload_0
    //   213: putfield 114	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
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
    //   241: getfield 116	kotlin/l/b/a/b/e/a$g:Tyq	Ljava/util/List;
    //   244: invokestatic 122	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   247: putfield 116	kotlin/l/b/a/b/e/a$g:Tyq	Ljava/util/List;
    //   250: iload_3
    //   251: bipush 64
    //   253: iand
    //   254: bipush 64
    //   256: if_icmpne +14 -> 270
    //   259: aload_0
    //   260: aload_0
    //   261: getfield 124	kotlin/l/b/a/b/e/a$g:Tyr	Ljava/util/List;
    //   264: invokestatic 122	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   267: putfield 124	kotlin/l/b/a/b/e/a$g:Tyr	Ljava/util/List;
    //   270: aload 12
    //   272: invokevirtual 127	kotlin/l/b/a/b/h/f:flush	()V
    //   275: aload_0
    //   276: aload 11
    //   278: invokevirtual 133	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   281: putfield 78	kotlin/l/b/a/b/e/a$g:TwK	Lkotlin/l/b/a/b/h/d;
    //   284: aload_0
    //   285: invokevirtual 136	kotlin/l/b/a/b/e/a$g:Gw	()V
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
    //   306: getfield 105	kotlin/l/b/a/b/e/a$g:bOT	I
    //   309: iconst_2
    //   310: ior
    //   311: putfield 105	kotlin/l/b/a/b/e/a$g:bOT	I
    //   314: iload_3
    //   315: istore 6
    //   317: iload_3
    //   318: istore 7
    //   320: iload_3
    //   321: istore 8
    //   323: aload_0
    //   324: aload_1
    //   325: invokevirtual 108	kotlin/l/b/a/b/h/e:zi	()I
    //   328: putfield 138	kotlin/l/b/a/b/e/a$g:Tym	I
    //   331: goto -290 -> 41
    //   334: astore_1
    //   335: iload 7
    //   337: istore 4
    //   339: iload 4
    //   341: istore_3
    //   342: new 81	kotlin/l/b/a/b/h/k
    //   345: dup
    //   346: aload_1
    //   347: invokevirtual 142	java/io/IOException:getMessage	()Ljava/lang/String;
    //   350: invokespecial 145	kotlin/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   353: astore_1
    //   354: iload 4
    //   356: istore_3
    //   357: aload_1
    //   358: aload_0
    //   359: putfield 114	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
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
    //   385: invokevirtual 108	kotlin/l/b/a/b/h/e:zi	()I
    //   388: istore 9
    //   390: iload_3
    //   391: istore 6
    //   393: iload_3
    //   394: istore 7
    //   396: iload_3
    //   397: istore 8
    //   399: iload 9
    //   401: invokestatic 149	kotlin/l/b/a/b/e/a$g$b:aun	(I)Lkotlin/l/b/a/b/e/a$g$b;
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
    //   424: invokevirtual 152	kotlin/l/b/a/b/h/f:hc	(I)V
    //   427: iload_3
    //   428: istore 6
    //   430: iload_3
    //   431: istore 7
    //   433: iload_3
    //   434: istore 8
    //   436: aload 12
    //   438: iload 9
    //   440: invokevirtual 152	kotlin/l/b/a/b/h/f:hc	(I)V
    //   443: goto -402 -> 41
    //   446: iload_3
    //   447: istore 6
    //   449: iload_3
    //   450: istore 7
    //   452: iload_3
    //   453: istore 8
    //   455: aload_0
    //   456: aload_0
    //   457: getfield 105	kotlin/l/b/a/b/e/a$g:bOT	I
    //   460: iconst_4
    //   461: ior
    //   462: putfield 105	kotlin/l/b/a/b/e/a$g:bOT	I
    //   465: iload_3
    //   466: istore 6
    //   468: iload_3
    //   469: istore 7
    //   471: iload_3
    //   472: istore 8
    //   474: aload_0
    //   475: aload 10
    //   477: putfield 154	kotlin/l/b/a/b/e/a$g:Tyn	Lkotlin/l/b/a/b/e/a$g$b;
    //   480: goto -439 -> 41
    //   483: iload_3
    //   484: istore 6
    //   486: iload_3
    //   487: istore 7
    //   489: iload_3
    //   490: istore 8
    //   492: aload_0
    //   493: getfield 105	kotlin/l/b/a/b/e/a$g:bOT	I
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
    //   514: getfield 156	kotlin/l/b/a/b/e/a$g:Tyo	Lkotlin/l/b/a/b/e/a$p;
    //   517: invokestatic 161	kotlin/l/b/a/b/e/a$p:f	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   520: astore 10
    //   522: iload_3
    //   523: istore 6
    //   525: iload_3
    //   526: istore 7
    //   528: iload_3
    //   529: istore 8
    //   531: aload_0
    //   532: aload_1
    //   533: getstatic 162	kotlin/l/b/a/b/e/a$p:TwL	Lkotlin/l/b/a/b/h/s;
    //   536: aload_2
    //   537: invokevirtual 165	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   540: checkcast 158	kotlin/l/b/a/b/e/a$p
    //   543: putfield 156	kotlin/l/b/a/b/e/a$g:Tyo	Lkotlin/l/b/a/b/e/a$p;
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
    //   563: getfield 156	kotlin/l/b/a/b/e/a$g:Tyo	Lkotlin/l/b/a/b/e/a$p;
    //   566: invokevirtual 170	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   569: pop
    //   570: iload_3
    //   571: istore 6
    //   573: iload_3
    //   574: istore 7
    //   576: iload_3
    //   577: istore 8
    //   579: aload_0
    //   580: aload 10
    //   582: invokevirtual 174	kotlin/l/b/a/b/e/a$p$b:hHo	()Lkotlin/l/b/a/b/e/a$p;
    //   585: putfield 156	kotlin/l/b/a/b/e/a$g:Tyo	Lkotlin/l/b/a/b/e/a$p;
    //   588: iload_3
    //   589: istore 6
    //   591: iload_3
    //   592: istore 7
    //   594: iload_3
    //   595: istore 8
    //   597: aload_0
    //   598: aload_0
    //   599: getfield 105	kotlin/l/b/a/b/e/a$g:bOT	I
    //   602: bipush 8
    //   604: ior
    //   605: putfield 105	kotlin/l/b/a/b/e/a$g:bOT	I
    //   608: goto -567 -> 41
    //   611: iload_3
    //   612: istore 6
    //   614: iload_3
    //   615: istore 7
    //   617: iload_3
    //   618: istore 8
    //   620: aload_0
    //   621: aload_0
    //   622: getfield 105	kotlin/l/b/a/b/e/a$g:bOT	I
    //   625: bipush 16
    //   627: ior
    //   628: putfield 105	kotlin/l/b/a/b/e/a$g:bOT	I
    //   631: iload_3
    //   632: istore 6
    //   634: iload_3
    //   635: istore 7
    //   637: iload_3
    //   638: istore 8
    //   640: aload_0
    //   641: aload_1
    //   642: invokevirtual 108	kotlin/l/b/a/b/h/e:zi	()I
    //   645: putfield 176	kotlin/l/b/a/b/e/a$g:Typ	I
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
    //   673: new 178	java/util/ArrayList
    //   676: dup
    //   677: invokespecial 179	java/util/ArrayList:<init>	()V
    //   680: putfield 116	kotlin/l/b/a/b/e/a$g:Tyq	Ljava/util/List;
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
    //   702: getfield 116	kotlin/l/b/a/b/e/a$g:Tyq	Ljava/util/List;
    //   705: aload_1
    //   706: getstatic 56	kotlin/l/b/a/b/e/a$g:TwL	Lkotlin/l/b/a/b/h/s;
    //   709: aload_2
    //   710: invokevirtual 165	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   713: invokeinterface 185 2 0
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
    //   744: new 178	java/util/ArrayList
    //   747: dup
    //   748: invokespecial 179	java/util/ArrayList:<init>	()V
    //   751: putfield 124	kotlin/l/b/a/b/e/a$g:Tyr	Ljava/util/List;
    //   754: iload_3
    //   755: bipush 64
    //   757: ior
    //   758: istore_3
    //   759: aload_0
    //   760: getfield 124	kotlin/l/b/a/b/e/a$g:Tyr	Ljava/util/List;
    //   763: aload_1
    //   764: getstatic 56	kotlin/l/b/a/b/e/a$g:TwL	Lkotlin/l/b/a/b/h/s;
    //   767: aload_2
    //   768: invokevirtual 165	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   771: invokeinterface 185 2 0
    //   776: pop
    //   777: goto -736 -> 41
    //   780: iload_3
    //   781: bipush 32
    //   783: iand
    //   784: bipush 32
    //   786: if_icmpne +14 -> 800
    //   789: aload_0
    //   790: aload_0
    //   791: getfield 116	kotlin/l/b/a/b/e/a$g:Tyq	Ljava/util/List;
    //   794: invokestatic 122	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   797: putfield 116	kotlin/l/b/a/b/e/a$g:Tyq	Ljava/util/List;
    //   800: iload_3
    //   801: bipush 64
    //   803: iand
    //   804: bipush 64
    //   806: if_icmpne +14 -> 820
    //   809: aload_0
    //   810: aload_0
    //   811: getfield 124	kotlin/l/b/a/b/e/a$g:Tyr	Ljava/util/List;
    //   814: invokestatic 122	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   817: putfield 124	kotlin/l/b/a/b/e/a$g:Tyr	Ljava/util/List;
    //   820: aload 12
    //   822: invokevirtual 127	kotlin/l/b/a/b/h/f:flush	()V
    //   825: aload_0
    //   826: aload 11
    //   828: invokevirtual 133	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   831: putfield 78	kotlin/l/b/a/b/e/a$g:TwK	Lkotlin/l/b/a/b/h/d;
    //   834: aload_0
    //   835: invokevirtual 136	kotlin/l/b/a/b/e/a$g:Gw	()V
    //   838: ldc 84
    //   840: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   843: return
    //   844: astore_1
    //   845: aload_0
    //   846: aload 11
    //   848: invokevirtual 133	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   851: putfield 78	kotlin/l/b/a/b/e/a$g:TwK	Lkotlin/l/b/a/b/h/d;
    //   854: goto -20 -> 834
    //   857: astore_1
    //   858: aload_0
    //   859: aload 11
    //   861: invokevirtual 133	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   864: putfield 78	kotlin/l/b/a/b/e/a$g:TwK	Lkotlin/l/b/a/b/h/d;
    //   867: ldc 84
    //   869: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   872: aload_1
    //   873: athrow
    //   874: astore_2
    //   875: aload_0
    //   876: aload 11
    //   878: invokevirtual 133	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   881: putfield 78	kotlin/l/b/a/b/e/a$g:TwK	Lkotlin/l/b/a/b/h/d;
    //   884: goto -600 -> 284
    //   887: astore_1
    //   888: aload_0
    //   889: aload 11
    //   891: invokevirtual 133	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   894: putfield 78	kotlin/l/b/a/b/e/a$g:TwK	Lkotlin/l/b/a/b/h/d;
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
    //   55	61	203	kotlin/l/b/a/b/h/k
    //   145	158	203	kotlin/l/b/a/b/h/k
    //   173	183	203	kotlin/l/b/a/b/h/k
    //   192	200	203	kotlin/l/b/a/b/h/k
    //   304	314	203	kotlin/l/b/a/b/h/k
    //   323	331	203	kotlin/l/b/a/b/h/k
    //   384	390	203	kotlin/l/b/a/b/h/k
    //   399	406	203	kotlin/l/b/a/b/h/k
    //   420	427	203	kotlin/l/b/a/b/h/k
    //   436	443	203	kotlin/l/b/a/b/h/k
    //   455	465	203	kotlin/l/b/a/b/h/k
    //   474	480	203	kotlin/l/b/a/b/h/k
    //   492	504	203	kotlin/l/b/a/b/h/k
    //   513	522	203	kotlin/l/b/a/b/h/k
    //   531	546	203	kotlin/l/b/a/b/h/k
    //   560	570	203	kotlin/l/b/a/b/h/k
    //   579	588	203	kotlin/l/b/a/b/h/k
    //   597	608	203	kotlin/l/b/a/b/h/k
    //   620	631	203	kotlin/l/b/a/b/h/k
    //   640	648	203	kotlin/l/b/a/b/h/k
    //   672	683	203	kotlin/l/b/a/b/h/k
    //   701	719	203	kotlin/l/b/a/b/h/k
    //   743	754	203	kotlin/l/b/a/b/h/k
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
    //   759	777	915	kotlin/l/b/a/b/h/k
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
    this.TwK = parama.TwK;
  }
  
  public static a b(g paramg)
  {
    AppMethodBeat.i(58581);
    paramg = a.hFY().f(paramg);
    AppMethodBeat.o(58581);
    return paramg;
  }
  
  private void hEu()
  {
    AppMethodBeat.i(58577);
    this.Txb = 0;
    this.Tym = 0;
    this.Tyn = b.Tys;
    this.Tyo = a.p.hGS();
    this.Typ = 0;
    this.Tyq = Collections.emptyList();
    this.Tyr = Collections.emptyList();
    AppMethodBeat.o(58577);
  }
  
  public static g hFP()
  {
    return Tyl;
  }
  
  public final void a(f paramf)
  {
    int k = 0;
    AppMethodBeat.i(58579);
    yC();
    if ((this.bOT & 0x1) == 1) {
      paramf.bs(1, this.Txb);
    }
    if ((this.bOT & 0x2) == 2) {
      paramf.bs(2, this.Tym);
    }
    if ((this.bOT & 0x4) == 4) {
      paramf.nb(3, this.Tyn.value);
    }
    if ((this.bOT & 0x8) == 8) {
      paramf.a(4, this.Tyo);
    }
    if ((this.bOT & 0x10) == 16) {
      paramf.bs(5, this.Typ);
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.Tyq.size()) {
        break;
      }
      paramf.a(6, (q)this.Tyq.get(i));
      i += 1;
    }
    while (j < this.Tyr.size())
    {
      paramf.a(7, (q)this.Tyr.get(j));
      j += 1;
    }
    paramf.e(this.TwK);
    AppMethodBeat.o(58579);
  }
  
  public final boolean hEP()
  {
    return (this.bOT & 0x1) == 1;
  }
  
  public final s<g> hEs()
  {
    return TwL;
  }
  
  public final boolean hFQ()
  {
    return (this.bOT & 0x2) == 2;
  }
  
  public final boolean hFR()
  {
    return (this.bOT & 0x4) == 4;
  }
  
  public final boolean hFS()
  {
    return (this.bOT & 0x8) == 8;
  }
  
  public final boolean hFT()
  {
    return (this.bOT & 0x10) == 16;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58578);
    int i = this.bPe;
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
    if ((hFS()) && (!this.Tyo.isInitialized()))
    {
      this.bPe = 0;
      AppMethodBeat.o(58578);
      return false;
    }
    i = 0;
    while (i < this.Tyq.size())
    {
      if (!((g)this.Tyq.get(i)).isInitialized())
      {
        this.bPe = 0;
        AppMethodBeat.o(58578);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.Tyr.size())
    {
      if (!((g)this.Tyr.get(i)).isInitialized())
      {
        this.bPe = 0;
        AppMethodBeat.o(58578);
        return false;
      }
      i += 1;
    }
    this.bPe = 1;
    AppMethodBeat.o(58578);
    return true;
  }
  
  public final int yC()
  {
    int n = 0;
    AppMethodBeat.i(58580);
    int i = this.bVY;
    if (i != -1)
    {
      AppMethodBeat.o(58580);
      return i;
    }
    if ((this.bOT & 0x1) == 1) {}
    for (int j = f.bu(1, this.Txb) + 0;; j = 0)
    {
      i = j;
      if ((this.bOT & 0x2) == 2) {
        i = j + f.bu(2, this.Tym);
      }
      j = i;
      if ((this.bOT & 0x4) == 4) {
        j = i + f.bv(3, this.Tyn.value);
      }
      i = j;
      if ((this.bOT & 0x8) == 8) {
        i = j + f.c(4, this.Tyo);
      }
      j = i;
      if ((this.bOT & 0x10) == 16) {
        j = i + f.bu(5, this.Typ);
      }
      int k = 0;
      i = j;
      j = k;
      int m;
      for (;;)
      {
        k = n;
        m = i;
        if (j >= this.Tyq.size()) {
          break;
        }
        i += f.c(6, (q)this.Tyq.get(j));
        j += 1;
      }
      while (k < this.Tyr.size())
      {
        m += f.c(7, (q)this.Tyr.get(k));
        k += 1;
      }
      i = this.TwK.size() + m;
      this.bVY = i;
      AppMethodBeat.o(58580);
      return i;
    }
  }
  
  public static final class a
    extends i.a<a.g, a>
    implements j
  {
    private int Txb;
    private int Tym;
    private a.g.b Tyn;
    private a.p Tyo;
    private int Typ;
    private List<a.g> Tyq;
    private List<a.g> Tyr;
    private int bOT;
    
    private a()
    {
      AppMethodBeat.i(58552);
      this.Tyn = a.g.b.Tys;
      this.Tyo = a.p.hGS();
      this.Tyq = Collections.emptyList();
      this.Tyr = Collections.emptyList();
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
      this.bOT |= 0x4;
      this.Tyn = paramb;
      AppMethodBeat.o(58558);
      return this;
    }
    
    private a a(a.p paramp)
    {
      AppMethodBeat.i(58559);
      if (((this.bOT & 0x8) == 8) && (this.Tyo != a.p.hGS())) {}
      for (this.Tyo = a.p.f(this.Tyo).j(paramp).hHo();; this.Tyo = paramp)
      {
        this.bOT |= 0x8;
        AppMethodBeat.o(58559);
        return this;
      }
    }
    
    private a auk(int paramInt)
    {
      this.bOT |= 0x1;
      this.Txb = paramInt;
      return this;
    }
    
    private a aul(int paramInt)
    {
      this.bOT |= 0x2;
      this.Tym = paramInt;
      return this;
    }
    
    private a aum(int paramInt)
    {
      this.bOT |= 0x10;
      this.Typ = paramInt;
      return this;
    }
    
    private a hFU()
    {
      AppMethodBeat.i(58553);
      a locala = new a().f(hFV());
      AppMethodBeat.o(58553);
      return locala;
    }
    
    private void hFW()
    {
      AppMethodBeat.i(58560);
      if ((this.bOT & 0x20) != 32)
      {
        this.Tyq = new ArrayList(this.Tyq);
        this.bOT |= 0x20;
      }
      AppMethodBeat.o(58560);
    }
    
    private void hFX()
    {
      AppMethodBeat.i(58561);
      if ((this.bOT & 0x40) != 64)
      {
        this.Tyr = new ArrayList(this.Tyr);
        this.bOT |= 0x40;
      }
      AppMethodBeat.o(58561);
    }
    
    /* Error */
    private a l(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 124
      //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 128	kotlin/l/b/a/b/e/a$g:TwL	Lkotlin/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 133 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$g
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 108	kotlin/l/b/a/b/e/a$g$a:f	(Lkotlin/l/b/a/b/e/a$g;)Lkotlin/l/b/a/b/e/a$g$a;
      //   26: pop
      //   27: ldc 124
      //   29: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 137	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
      //   39: checkcast 9	kotlin/l/b/a/b/e/a$g
      //   42: astore_2
      //   43: ldc 124
      //   45: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 108	kotlin/l/b/a/b/e/a$g$a:f	(Lkotlin/l/b/a/b/e/a$g;)Lkotlin/l/b/a/b/e/a$g$a;
      //   60: pop
      //   61: ldc 124
      //   63: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: aload_1
      //   67: athrow
      //   68: astore_1
      //   69: aload_3
      //   70: astore_2
      //   71: goto -20 -> 51
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	a
      //   0	74	1	parame	kotlin.l.b.a.b.h.e
      //   0	74	2	paramg	kotlin.l.b.a.b.h.g
      //   6	64	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	kotlin/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a f(a.g paramg)
    {
      AppMethodBeat.i(58555);
      if (paramg == a.g.hFP())
      {
        AppMethodBeat.o(58555);
        return this;
      }
      if (paramg.hEP()) {
        auk(paramg.Txb);
      }
      if (paramg.hFQ()) {
        aul(paramg.Tym);
      }
      if (paramg.hFR()) {
        a(paramg.Tyn);
      }
      if (paramg.hFS()) {
        a(paramg.Tyo);
      }
      if (paramg.hFT()) {
        aum(paramg.Typ);
      }
      if (!a.g.c(paramg).isEmpty())
      {
        if (this.Tyq.isEmpty())
        {
          this.Tyq = a.g.c(paramg);
          this.bOT &= 0xFFFFFFDF;
        }
      }
      else if (!a.g.d(paramg).isEmpty())
      {
        if (!this.Tyr.isEmpty()) {
          break label228;
        }
        this.Tyr = a.g.d(paramg);
        this.bOT &= 0xFFFFFFBF;
      }
      for (;;)
      {
        this.TwK = this.TwK.a(a.g.e(paramg));
        AppMethodBeat.o(58555);
        return this;
        hFW();
        this.Tyq.addAll(a.g.c(paramg));
        break;
        label228:
        hFX();
        this.Tyr.addAll(a.g.d(paramg));
      }
    }
    
    public final a.g hFV()
    {
      int j = 1;
      AppMethodBeat.i(58554);
      a.g localg = new a.g(this, (byte)0);
      int k = this.bOT;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.g.a(localg, this.Txb);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.g.b(localg, this.Tym);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.g.a(localg, this.Tyn);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.g.a(localg, this.Tyo);
        j = i;
        if ((k & 0x10) == 16) {
          j = i | 0x10;
        }
        a.g.c(localg, this.Typ);
        if ((this.bOT & 0x20) == 32)
        {
          this.Tyq = Collections.unmodifiableList(this.Tyq);
          this.bOT &= 0xFFFFFFDF;
        }
        a.g.a(localg, this.Tyq);
        if ((this.bOT & 0x40) == 64)
        {
          this.Tyr = Collections.unmodifiableList(this.Tyr);
          this.bOT &= 0xFFFFFFBF;
        }
        a.g.b(localg, this.Tyr);
        a.g.d(localg, j);
        AppMethodBeat.o(58554);
        return localg;
        j = 0;
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58556);
      if ((this.bOT & 0x8) == 8) {}
      for (int i = 1; (i != 0) && (!this.Tyo.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58556);
        return false;
      }
      i = 0;
      while (i < this.Tyq.size())
      {
        if (!((a.g)this.Tyq.get(i)).isInitialized())
        {
          AppMethodBeat.o(58556);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.Tyr.size())
      {
        if (!((a.g)this.Tyr.get(i)).isInitialized())
        {
          AppMethodBeat.o(58556);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(58556);
      return true;
    }
  }
  
  public static enum b
    implements j.a
  {
    private static j.b<b> Txp;
    final int value;
    
    static
    {
      AppMethodBeat.i(58575);
      Tys = new b("TRUE", 0, 0);
      Tyt = new b("FALSE", 1, 1);
      Tyu = new b("NULL", 2, 2);
      Tyv = new b[] { Tys, Tyt, Tyu };
      Txp = new j.b() {};
      AppMethodBeat.o(58575);
    }
    
    private b(int paramInt1, int paramInt2)
    {
      this.value = paramInt1;
    }
    
    public static b aun(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return Tys;
      case 1: 
        return Tyt;
      }
      return Tyu;
    }
    
    public final int getNumber()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.g
 * JD-Core Version:    0.7.0.1
 */