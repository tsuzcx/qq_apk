package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.g;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.i.b;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.c.a;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.h.t;

public final class a$h
  extends i.c<h>
  implements k
{
  public static t<h> aiYa;
  private static final h aiZO;
  private final d aiXZ;
  public List<a.r> aiYJ;
  public a.s aiYZ;
  public int aiYq;
  public int aiZC;
  public int aiZP;
  public a.p aiZQ;
  public int aiZR;
  public a.p aiZS;
  public int aiZT;
  a.d aiZU;
  public List<Integer> aiZa;
  public List<a.t> aiZl;
  private int bitField0_;
  private int dRJ = -1;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(58618);
    aiYa = new b() {};
    h localh = new h();
    aiZO = localh;
    localh.ktf();
    AppMethodBeat.o(58618);
  }
  
  private a$h()
  {
    this.aiXZ = d.ajeU;
  }
  
  /* Error */
  private a$h(kotlin.l.b.a.b.h.e parame, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 71	kotlin/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 88
    //   6: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 73	kotlin/l/b/a/b/e/a$h:memoizedIsInitialized	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 75	kotlin/l/b/a/b/e/a$h:dRJ	I
    //   19: aload_0
    //   20: invokespecial 66	kotlin/l/b/a/b/e/a$h:ktf	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 92	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
    //   28: astore 11
    //   30: aload 11
    //   32: iconst_1
    //   33: invokestatic 97	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   36: astore 12
    //   38: iconst_0
    //   39: istore 8
    //   41: iload 8
    //   43: ifne +1424 -> 1467
    //   46: iload_3
    //   47: istore 5
    //   49: iload_3
    //   50: istore 4
    //   52: iload_3
    //   53: istore 6
    //   55: aload_1
    //   56: invokevirtual 103	kotlin/l/b/a/b/h/e:aac	()I
    //   59: istore 7
    //   61: iload 7
    //   63: lookupswitch	default:+1576->1639, 0:+1579->1642, 8:+149->212, 16:+306->369, 26:+386->449, 34:+514->577, 42:+588->651, 50:+716->779, 56:+793->856, 64:+833->896, 72:+873->936, 242:+912->975, 248:+1043->1106, 250:+1119->1182, 258:+1273->1336
    //   185: istore 5
    //   187: iload_3
    //   188: istore 4
    //   190: iload_3
    //   191: istore 6
    //   193: aload_0
    //   194: aload_1
    //   195: aload 12
    //   197: aload_2
    //   198: iload 7
    //   200: invokevirtual 106	kotlin/l/b/a/b/e/a$h:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   203: ifne -162 -> 41
    //   206: iconst_1
    //   207: istore 8
    //   209: goto -168 -> 41
    //   212: iload_3
    //   213: istore 5
    //   215: iload_3
    //   216: istore 4
    //   218: iload_3
    //   219: istore 6
    //   221: aload_0
    //   222: aload_0
    //   223: getfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   226: iconst_2
    //   227: ior
    //   228: putfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   231: iload_3
    //   232: istore 5
    //   234: iload_3
    //   235: istore 4
    //   237: iload_3
    //   238: istore 6
    //   240: aload_0
    //   241: aload_1
    //   242: invokevirtual 111	kotlin/l/b/a/b/h/e:aar	()I
    //   245: putfield 113	kotlin/l/b/a/b/e/a$h:aiZP	I
    //   248: goto -207 -> 41
    //   251: astore_1
    //   252: iload 5
    //   254: istore 4
    //   256: aload_1
    //   257: aload_0
    //   258: putfield 117	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   261: iload 5
    //   263: istore 4
    //   265: ldc 88
    //   267: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: iload 5
    //   272: istore 4
    //   274: aload_1
    //   275: athrow
    //   276: astore_1
    //   277: iload 4
    //   279: bipush 32
    //   281: iand
    //   282: bipush 32
    //   284: if_icmpne +14 -> 298
    //   287: aload_0
    //   288: aload_0
    //   289: getfield 119	kotlin/l/b/a/b/e/a$h:aiYJ	Ljava/util/List;
    //   292: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   295: putfield 119	kotlin/l/b/a/b/e/a$h:aiYJ	Ljava/util/List;
    //   298: iload 4
    //   300: sipush 256
    //   303: iand
    //   304: sipush 256
    //   307: if_icmpne +14 -> 321
    //   310: aload_0
    //   311: aload_0
    //   312: getfield 127	kotlin/l/b/a/b/e/a$h:aiZl	Ljava/util/List;
    //   315: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   318: putfield 127	kotlin/l/b/a/b/e/a$h:aiZl	Ljava/util/List;
    //   321: iload 4
    //   323: sipush 1024
    //   326: iand
    //   327: sipush 1024
    //   330: if_icmpne +14 -> 344
    //   333: aload_0
    //   334: aload_0
    //   335: getfield 129	kotlin/l/b/a/b/e/a$h:aiZa	Ljava/util/List;
    //   338: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   341: putfield 129	kotlin/l/b/a/b/e/a$h:aiZa	Ljava/util/List;
    //   344: aload 12
    //   346: invokevirtual 132	kotlin/l/b/a/b/h/f:flush	()V
    //   349: aload_0
    //   350: aload 11
    //   352: invokevirtual 138	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   355: putfield 82	kotlin/l/b/a/b/e/a$h:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   358: aload_0
    //   359: invokevirtual 141	kotlin/l/b/a/b/e/a$h:makeExtensionsImmutable	()V
    //   362: ldc 88
    //   364: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   367: aload_1
    //   368: athrow
    //   369: iload_3
    //   370: istore 5
    //   372: iload_3
    //   373: istore 4
    //   375: iload_3
    //   376: istore 6
    //   378: aload_0
    //   379: aload_0
    //   380: getfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   383: iconst_4
    //   384: ior
    //   385: putfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   388: iload_3
    //   389: istore 5
    //   391: iload_3
    //   392: istore 4
    //   394: iload_3
    //   395: istore 6
    //   397: aload_0
    //   398: aload_1
    //   399: invokevirtual 111	kotlin/l/b/a/b/h/e:aar	()I
    //   402: putfield 143	kotlin/l/b/a/b/e/a$h:aiZC	I
    //   405: goto -364 -> 41
    //   408: astore_1
    //   409: iload 6
    //   411: istore 4
    //   413: new 85	kotlin/l/b/a/b/h/l
    //   416: dup
    //   417: aload_1
    //   418: invokevirtual 147	java/io/IOException:getMessage	()Ljava/lang/String;
    //   421: invokespecial 150	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   424: astore_1
    //   425: iload 6
    //   427: istore 4
    //   429: aload_1
    //   430: aload_0
    //   431: putfield 117	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   434: iload 6
    //   436: istore 4
    //   438: ldc 88
    //   440: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   443: iload 6
    //   445: istore 4
    //   447: aload_1
    //   448: athrow
    //   449: iload_3
    //   450: istore 5
    //   452: iload_3
    //   453: istore 4
    //   455: iload_3
    //   456: istore 6
    //   458: aload_0
    //   459: getfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   462: bipush 8
    //   464: iand
    //   465: bipush 8
    //   467: if_icmpne +1166 -> 1633
    //   470: iload_3
    //   471: istore 5
    //   473: iload_3
    //   474: istore 4
    //   476: iload_3
    //   477: istore 6
    //   479: aload_0
    //   480: getfield 152	kotlin/l/b/a/b/e/a$h:aiZQ	Lkotlin/l/b/a/b/e/a$p;
    //   483: invokestatic 158	kotlin/l/b/a/b/e/a$p:g	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   486: astore 10
    //   488: iload_3
    //   489: istore 5
    //   491: iload_3
    //   492: istore 4
    //   494: iload_3
    //   495: istore 6
    //   497: aload_0
    //   498: aload_1
    //   499: getstatic 159	kotlin/l/b/a/b/e/a$p:aiYa	Lkotlin/l/b/a/b/h/t;
    //   502: aload_2
    //   503: invokevirtual 162	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   506: checkcast 154	kotlin/l/b/a/b/e/a$p
    //   509: putfield 152	kotlin/l/b/a/b/e/a$h:aiZQ	Lkotlin/l/b/a/b/e/a$p;
    //   512: aload 10
    //   514: ifnull +40 -> 554
    //   517: iload_3
    //   518: istore 5
    //   520: iload_3
    //   521: istore 4
    //   523: iload_3
    //   524: istore 6
    //   526: aload 10
    //   528: aload_0
    //   529: getfield 152	kotlin/l/b/a/b/e/a$h:aiZQ	Lkotlin/l/b/a/b/e/a$p;
    //   532: invokevirtual 167	kotlin/l/b/a/b/e/a$p$b:k	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   535: pop
    //   536: iload_3
    //   537: istore 5
    //   539: iload_3
    //   540: istore 4
    //   542: iload_3
    //   543: istore 6
    //   545: aload_0
    //   546: aload 10
    //   548: invokevirtual 171	kotlin/l/b/a/b/e/a$p$b:kwd	()Lkotlin/l/b/a/b/e/a$p;
    //   551: putfield 152	kotlin/l/b/a/b/e/a$h:aiZQ	Lkotlin/l/b/a/b/e/a$p;
    //   554: iload_3
    //   555: istore 5
    //   557: iload_3
    //   558: istore 4
    //   560: iload_3
    //   561: istore 6
    //   563: aload_0
    //   564: aload_0
    //   565: getfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   568: bipush 8
    //   570: ior
    //   571: putfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   574: goto -533 -> 41
    //   577: iload_3
    //   578: istore 7
    //   580: iload_3
    //   581: bipush 32
    //   583: iand
    //   584: bipush 32
    //   586: if_icmpeq +29 -> 615
    //   589: iload_3
    //   590: istore 5
    //   592: iload_3
    //   593: istore 4
    //   595: iload_3
    //   596: istore 6
    //   598: aload_0
    //   599: new 173	java/util/ArrayList
    //   602: dup
    //   603: invokespecial 174	java/util/ArrayList:<init>	()V
    //   606: putfield 119	kotlin/l/b/a/b/e/a$h:aiYJ	Ljava/util/List;
    //   609: iload_3
    //   610: bipush 32
    //   612: ior
    //   613: istore 7
    //   615: iload 7
    //   617: istore 5
    //   619: iload 7
    //   621: istore 4
    //   623: iload 7
    //   625: istore 6
    //   627: aload_0
    //   628: getfield 119	kotlin/l/b/a/b/e/a$h:aiYJ	Ljava/util/List;
    //   631: aload_1
    //   632: getstatic 177	kotlin/l/b/a/b/e/a$r:aiYa	Lkotlin/l/b/a/b/h/t;
    //   635: aload_2
    //   636: invokevirtual 162	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   639: invokeinterface 183 2 0
    //   644: pop
    //   645: iload 7
    //   647: istore_3
    //   648: goto -607 -> 41
    //   651: iload_3
    //   652: istore 5
    //   654: iload_3
    //   655: istore 4
    //   657: iload_3
    //   658: istore 6
    //   660: aload_0
    //   661: getfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   664: bipush 32
    //   666: iand
    //   667: bipush 32
    //   669: if_icmpne +958 -> 1627
    //   672: iload_3
    //   673: istore 5
    //   675: iload_3
    //   676: istore 4
    //   678: iload_3
    //   679: istore 6
    //   681: aload_0
    //   682: getfield 185	kotlin/l/b/a/b/e/a$h:aiZS	Lkotlin/l/b/a/b/e/a$p;
    //   685: invokestatic 158	kotlin/l/b/a/b/e/a$p:g	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   688: astore 10
    //   690: iload_3
    //   691: istore 5
    //   693: iload_3
    //   694: istore 4
    //   696: iload_3
    //   697: istore 6
    //   699: aload_0
    //   700: aload_1
    //   701: getstatic 159	kotlin/l/b/a/b/e/a$p:aiYa	Lkotlin/l/b/a/b/h/t;
    //   704: aload_2
    //   705: invokevirtual 162	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   708: checkcast 154	kotlin/l/b/a/b/e/a$p
    //   711: putfield 185	kotlin/l/b/a/b/e/a$h:aiZS	Lkotlin/l/b/a/b/e/a$p;
    //   714: aload 10
    //   716: ifnull +40 -> 756
    //   719: iload_3
    //   720: istore 5
    //   722: iload_3
    //   723: istore 4
    //   725: iload_3
    //   726: istore 6
    //   728: aload 10
    //   730: aload_0
    //   731: getfield 185	kotlin/l/b/a/b/e/a$h:aiZS	Lkotlin/l/b/a/b/e/a$p;
    //   734: invokevirtual 167	kotlin/l/b/a/b/e/a$p$b:k	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   737: pop
    //   738: iload_3
    //   739: istore 5
    //   741: iload_3
    //   742: istore 4
    //   744: iload_3
    //   745: istore 6
    //   747: aload_0
    //   748: aload 10
    //   750: invokevirtual 171	kotlin/l/b/a/b/e/a$p$b:kwd	()Lkotlin/l/b/a/b/e/a$p;
    //   753: putfield 185	kotlin/l/b/a/b/e/a$h:aiZS	Lkotlin/l/b/a/b/e/a$p;
    //   756: iload_3
    //   757: istore 5
    //   759: iload_3
    //   760: istore 4
    //   762: iload_3
    //   763: istore 6
    //   765: aload_0
    //   766: aload_0
    //   767: getfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   770: bipush 32
    //   772: ior
    //   773: putfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   776: goto -735 -> 41
    //   779: iload_3
    //   780: istore 7
    //   782: iload_3
    //   783: sipush 256
    //   786: iand
    //   787: sipush 256
    //   790: if_icmpeq +30 -> 820
    //   793: iload_3
    //   794: istore 5
    //   796: iload_3
    //   797: istore 4
    //   799: iload_3
    //   800: istore 6
    //   802: aload_0
    //   803: new 173	java/util/ArrayList
    //   806: dup
    //   807: invokespecial 174	java/util/ArrayList:<init>	()V
    //   810: putfield 127	kotlin/l/b/a/b/e/a$h:aiZl	Ljava/util/List;
    //   813: iload_3
    //   814: sipush 256
    //   817: ior
    //   818: istore 7
    //   820: iload 7
    //   822: istore 5
    //   824: iload 7
    //   826: istore 4
    //   828: iload 7
    //   830: istore 6
    //   832: aload_0
    //   833: getfield 127	kotlin/l/b/a/b/e/a$h:aiZl	Ljava/util/List;
    //   836: aload_1
    //   837: getstatic 188	kotlin/l/b/a/b/e/a$t:aiYa	Lkotlin/l/b/a/b/h/t;
    //   840: aload_2
    //   841: invokevirtual 162	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   844: invokeinterface 183 2 0
    //   849: pop
    //   850: iload 7
    //   852: istore_3
    //   853: goto -812 -> 41
    //   856: iload_3
    //   857: istore 5
    //   859: iload_3
    //   860: istore 4
    //   862: iload_3
    //   863: istore 6
    //   865: aload_0
    //   866: aload_0
    //   867: getfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   870: bipush 16
    //   872: ior
    //   873: putfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   876: iload_3
    //   877: istore 5
    //   879: iload_3
    //   880: istore 4
    //   882: iload_3
    //   883: istore 6
    //   885: aload_0
    //   886: aload_1
    //   887: invokevirtual 111	kotlin/l/b/a/b/h/e:aar	()I
    //   890: putfield 190	kotlin/l/b/a/b/e/a$h:aiZR	I
    //   893: goto -852 -> 41
    //   896: iload_3
    //   897: istore 5
    //   899: iload_3
    //   900: istore 4
    //   902: iload_3
    //   903: istore 6
    //   905: aload_0
    //   906: aload_0
    //   907: getfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   910: bipush 64
    //   912: ior
    //   913: putfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   916: iload_3
    //   917: istore 5
    //   919: iload_3
    //   920: istore 4
    //   922: iload_3
    //   923: istore 6
    //   925: aload_0
    //   926: aload_1
    //   927: invokevirtual 111	kotlin/l/b/a/b/h/e:aar	()I
    //   930: putfield 192	kotlin/l/b/a/b/e/a$h:aiZT	I
    //   933: goto -892 -> 41
    //   936: iload_3
    //   937: istore 5
    //   939: iload_3
    //   940: istore 4
    //   942: iload_3
    //   943: istore 6
    //   945: aload_0
    //   946: aload_0
    //   947: getfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   950: iconst_1
    //   951: ior
    //   952: putfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   955: iload_3
    //   956: istore 5
    //   958: iload_3
    //   959: istore 4
    //   961: iload_3
    //   962: istore 6
    //   964: aload_0
    //   965: aload_1
    //   966: invokevirtual 111	kotlin/l/b/a/b/h/e:aar	()I
    //   969: putfield 194	kotlin/l/b/a/b/e/a$h:aiYq	I
    //   972: goto -931 -> 41
    //   975: iload_3
    //   976: istore 5
    //   978: iload_3
    //   979: istore 4
    //   981: iload_3
    //   982: istore 6
    //   984: aload_0
    //   985: getfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   988: sipush 128
    //   991: iand
    //   992: sipush 128
    //   995: if_icmpne +626 -> 1621
    //   998: iload_3
    //   999: istore 5
    //   1001: iload_3
    //   1002: istore 4
    //   1004: iload_3
    //   1005: istore 6
    //   1007: aload_0
    //   1008: getfield 196	kotlin/l/b/a/b/e/a$h:aiYZ	Lkotlin/l/b/a/b/e/a$s;
    //   1011: invokestatic 202	kotlin/l/b/a/b/e/a$s:d	(Lkotlin/l/b/a/b/e/a$s;)Lkotlin/l/b/a/b/e/a$s$a;
    //   1014: astore 10
    //   1016: iload_3
    //   1017: istore 5
    //   1019: iload_3
    //   1020: istore 4
    //   1022: iload_3
    //   1023: istore 6
    //   1025: aload_0
    //   1026: aload_1
    //   1027: getstatic 203	kotlin/l/b/a/b/e/a$s:aiYa	Lkotlin/l/b/a/b/h/t;
    //   1030: aload_2
    //   1031: invokevirtual 162	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   1034: checkcast 198	kotlin/l/b/a/b/e/a$s
    //   1037: putfield 196	kotlin/l/b/a/b/e/a$h:aiYZ	Lkotlin/l/b/a/b/e/a$s;
    //   1040: aload 10
    //   1042: ifnull +40 -> 1082
    //   1045: iload_3
    //   1046: istore 5
    //   1048: iload_3
    //   1049: istore 4
    //   1051: iload_3
    //   1052: istore 6
    //   1054: aload 10
    //   1056: aload_0
    //   1057: getfield 196	kotlin/l/b/a/b/e/a$h:aiYZ	Lkotlin/l/b/a/b/e/a$s;
    //   1060: invokevirtual 207	kotlin/l/b/a/b/e/a$s$a:g	(Lkotlin/l/b/a/b/e/a$s;)Lkotlin/l/b/a/b/e/a$s$a;
    //   1063: pop
    //   1064: iload_3
    //   1065: istore 5
    //   1067: iload_3
    //   1068: istore 4
    //   1070: iload_3
    //   1071: istore 6
    //   1073: aload_0
    //   1074: aload 10
    //   1076: invokevirtual 211	kotlin/l/b/a/b/e/a$s$a:kwz	()Lkotlin/l/b/a/b/e/a$s;
    //   1079: putfield 196	kotlin/l/b/a/b/e/a$h:aiYZ	Lkotlin/l/b/a/b/e/a$s;
    //   1082: iload_3
    //   1083: istore 5
    //   1085: iload_3
    //   1086: istore 4
    //   1088: iload_3
    //   1089: istore 6
    //   1091: aload_0
    //   1092: aload_0
    //   1093: getfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   1096: sipush 128
    //   1099: ior
    //   1100: putfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   1103: goto -1062 -> 41
    //   1106: iload_3
    //   1107: istore 7
    //   1109: iload_3
    //   1110: sipush 1024
    //   1113: iand
    //   1114: sipush 1024
    //   1117: if_icmpeq +30 -> 1147
    //   1120: iload_3
    //   1121: istore 5
    //   1123: iload_3
    //   1124: istore 4
    //   1126: iload_3
    //   1127: istore 6
    //   1129: aload_0
    //   1130: new 173	java/util/ArrayList
    //   1133: dup
    //   1134: invokespecial 174	java/util/ArrayList:<init>	()V
    //   1137: putfield 129	kotlin/l/b/a/b/e/a$h:aiZa	Ljava/util/List;
    //   1140: iload_3
    //   1141: sipush 1024
    //   1144: ior
    //   1145: istore 7
    //   1147: iload 7
    //   1149: istore 5
    //   1151: iload 7
    //   1153: istore 4
    //   1155: iload 7
    //   1157: istore 6
    //   1159: aload_0
    //   1160: getfield 129	kotlin/l/b/a/b/e/a$h:aiZa	Ljava/util/List;
    //   1163: aload_1
    //   1164: invokevirtual 111	kotlin/l/b/a/b/h/e:aar	()I
    //   1167: invokestatic 217	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1170: invokeinterface 183 2 0
    //   1175: pop
    //   1176: iload 7
    //   1178: istore_3
    //   1179: goto -1138 -> 41
    //   1182: iload_3
    //   1183: istore 5
    //   1185: iload_3
    //   1186: istore 4
    //   1188: iload_3
    //   1189: istore 6
    //   1191: aload_1
    //   1192: aload_1
    //   1193: invokevirtual 111	kotlin/l/b/a/b/h/e:aar	()I
    //   1196: invokevirtual 221	kotlin/l/b/a/b/h/e:jO	(I)I
    //   1199: istore 9
    //   1201: iload_3
    //   1202: istore 7
    //   1204: iload_3
    //   1205: sipush 1024
    //   1208: iand
    //   1209: sipush 1024
    //   1212: if_icmpeq +49 -> 1261
    //   1215: iload_3
    //   1216: istore 5
    //   1218: iload_3
    //   1219: istore 4
    //   1221: iload_3
    //   1222: istore 6
    //   1224: iload_3
    //   1225: istore 7
    //   1227: aload_1
    //   1228: invokevirtual 224	kotlin/l/b/a/b/h/e:aat	()I
    //   1231: ifle +30 -> 1261
    //   1234: iload_3
    //   1235: istore 5
    //   1237: iload_3
    //   1238: istore 4
    //   1240: iload_3
    //   1241: istore 6
    //   1243: aload_0
    //   1244: new 173	java/util/ArrayList
    //   1247: dup
    //   1248: invokespecial 174	java/util/ArrayList:<init>	()V
    //   1251: putfield 129	kotlin/l/b/a/b/e/a$h:aiZa	Ljava/util/List;
    //   1254: iload_3
    //   1255: sipush 1024
    //   1258: ior
    //   1259: istore 7
    //   1261: iload 7
    //   1263: istore 5
    //   1265: iload 7
    //   1267: istore 4
    //   1269: iload 7
    //   1271: istore 6
    //   1273: aload_1
    //   1274: invokevirtual 224	kotlin/l/b/a/b/h/e:aat	()I
    //   1277: ifle +35 -> 1312
    //   1280: iload 7
    //   1282: istore 5
    //   1284: iload 7
    //   1286: istore 4
    //   1288: iload 7
    //   1290: istore 6
    //   1292: aload_0
    //   1293: getfield 129	kotlin/l/b/a/b/e/a$h:aiZa	Ljava/util/List;
    //   1296: aload_1
    //   1297: invokevirtual 111	kotlin/l/b/a/b/h/e:aar	()I
    //   1300: invokestatic 217	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1303: invokeinterface 183 2 0
    //   1308: pop
    //   1309: goto -48 -> 1261
    //   1312: iload 7
    //   1314: istore 5
    //   1316: iload 7
    //   1318: istore 4
    //   1320: iload 7
    //   1322: istore 6
    //   1324: aload_1
    //   1325: iload 9
    //   1327: invokevirtual 227	kotlin/l/b/a/b/h/e:jP	(I)V
    //   1330: iload 7
    //   1332: istore_3
    //   1333: goto -1292 -> 41
    //   1336: iload_3
    //   1337: istore 5
    //   1339: iload_3
    //   1340: istore 4
    //   1342: iload_3
    //   1343: istore 6
    //   1345: aload_0
    //   1346: getfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   1349: sipush 256
    //   1352: iand
    //   1353: sipush 256
    //   1356: if_icmpne +259 -> 1615
    //   1359: iload_3
    //   1360: istore 5
    //   1362: iload_3
    //   1363: istore 4
    //   1365: iload_3
    //   1366: istore 6
    //   1368: aload_0
    //   1369: getfield 229	kotlin/l/b/a/b/e/a$h:aiZU	Lkotlin/l/b/a/b/e/a$d;
    //   1372: invokevirtual 235	kotlin/l/b/a/b/e/a$d:kun	()Lkotlin/l/b/a/b/e/a$d$a;
    //   1375: astore 10
    //   1377: iload_3
    //   1378: istore 5
    //   1380: iload_3
    //   1381: istore 4
    //   1383: iload_3
    //   1384: istore 6
    //   1386: aload_0
    //   1387: aload_1
    //   1388: getstatic 236	kotlin/l/b/a/b/e/a$d:aiYa	Lkotlin/l/b/a/b/h/t;
    //   1391: aload_2
    //   1392: invokevirtual 162	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   1395: checkcast 231	kotlin/l/b/a/b/e/a$d
    //   1398: putfield 229	kotlin/l/b/a/b/e/a$h:aiZU	Lkotlin/l/b/a/b/e/a$d;
    //   1401: aload 10
    //   1403: ifnull +40 -> 1443
    //   1406: iload_3
    //   1407: istore 5
    //   1409: iload_3
    //   1410: istore 4
    //   1412: iload_3
    //   1413: istore 6
    //   1415: aload 10
    //   1417: aload_0
    //   1418: getfield 229	kotlin/l/b/a/b/e/a$h:aiZU	Lkotlin/l/b/a/b/e/a$d;
    //   1421: invokevirtual 241	kotlin/l/b/a/b/e/a$d$a:d	(Lkotlin/l/b/a/b/e/a$d;)Lkotlin/l/b/a/b/e/a$d$a;
    //   1424: pop
    //   1425: iload_3
    //   1426: istore 5
    //   1428: iload_3
    //   1429: istore 4
    //   1431: iload_3
    //   1432: istore 6
    //   1434: aload_0
    //   1435: aload 10
    //   1437: invokevirtual 245	kotlin/l/b/a/b/e/a$d$a:kup	()Lkotlin/l/b/a/b/e/a$d;
    //   1440: putfield 229	kotlin/l/b/a/b/e/a$h:aiZU	Lkotlin/l/b/a/b/e/a$d;
    //   1443: iload_3
    //   1444: istore 5
    //   1446: iload_3
    //   1447: istore 4
    //   1449: iload_3
    //   1450: istore 6
    //   1452: aload_0
    //   1453: aload_0
    //   1454: getfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   1457: sipush 256
    //   1460: ior
    //   1461: putfield 108	kotlin/l/b/a/b/e/a$h:bitField0_	I
    //   1464: goto -1423 -> 41
    //   1467: iload_3
    //   1468: bipush 32
    //   1470: iand
    //   1471: bipush 32
    //   1473: if_icmpne +14 -> 1487
    //   1476: aload_0
    //   1477: aload_0
    //   1478: getfield 119	kotlin/l/b/a/b/e/a$h:aiYJ	Ljava/util/List;
    //   1481: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1484: putfield 119	kotlin/l/b/a/b/e/a$h:aiYJ	Ljava/util/List;
    //   1487: iload_3
    //   1488: sipush 256
    //   1491: iand
    //   1492: sipush 256
    //   1495: if_icmpne +14 -> 1509
    //   1498: aload_0
    //   1499: aload_0
    //   1500: getfield 127	kotlin/l/b/a/b/e/a$h:aiZl	Ljava/util/List;
    //   1503: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1506: putfield 127	kotlin/l/b/a/b/e/a$h:aiZl	Ljava/util/List;
    //   1509: iload_3
    //   1510: sipush 1024
    //   1513: iand
    //   1514: sipush 1024
    //   1517: if_icmpne +14 -> 1531
    //   1520: aload_0
    //   1521: aload_0
    //   1522: getfield 129	kotlin/l/b/a/b/e/a$h:aiZa	Ljava/util/List;
    //   1525: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1528: putfield 129	kotlin/l/b/a/b/e/a$h:aiZa	Ljava/util/List;
    //   1531: aload 12
    //   1533: invokevirtual 132	kotlin/l/b/a/b/h/f:flush	()V
    //   1536: aload_0
    //   1537: aload 11
    //   1539: invokevirtual 138	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   1542: putfield 82	kotlin/l/b/a/b/e/a$h:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   1545: aload_0
    //   1546: invokevirtual 141	kotlin/l/b/a/b/e/a$h:makeExtensionsImmutable	()V
    //   1549: ldc 88
    //   1551: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1554: return
    //   1555: astore_1
    //   1556: aload_0
    //   1557: aload 11
    //   1559: invokevirtual 138	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   1562: putfield 82	kotlin/l/b/a/b/e/a$h:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   1565: goto -20 -> 1545
    //   1568: astore_1
    //   1569: aload_0
    //   1570: aload 11
    //   1572: invokevirtual 138	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   1575: putfield 82	kotlin/l/b/a/b/e/a$h:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   1578: ldc 88
    //   1580: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1583: aload_1
    //   1584: athrow
    //   1585: astore_2
    //   1586: aload_0
    //   1587: aload 11
    //   1589: invokevirtual 138	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   1592: putfield 82	kotlin/l/b/a/b/e/a$h:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   1595: goto -1237 -> 358
    //   1598: astore_1
    //   1599: aload_0
    //   1600: aload 11
    //   1602: invokevirtual 138	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   1605: putfield 82	kotlin/l/b/a/b/e/a$h:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   1608: ldc 88
    //   1610: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1613: aload_1
    //   1614: athrow
    //   1615: aconst_null
    //   1616: astore 10
    //   1618: goto -241 -> 1377
    //   1621: aconst_null
    //   1622: astore 10
    //   1624: goto -608 -> 1016
    //   1627: aconst_null
    //   1628: astore 10
    //   1630: goto -940 -> 690
    //   1633: aconst_null
    //   1634: astore 10
    //   1636: goto -1148 -> 488
    //   1639: goto -1455 -> 184
    //   1642: iconst_1
    //   1643: istore 8
    //   1645: goto -1604 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1648	0	this	h
    //   0	1648	1	parame	kotlin.l.b.a.b.h.e
    //   0	1648	2	paramg	g
    //   24	1490	3	i	int
    //   50	1398	4	j	int
    //   47	1398	5	k	int
    //   53	1398	6	m	int
    //   59	1272	7	n	int
    //   39	1605	8	i1	int
    //   1199	127	9	i2	int
    //   486	1149	10	localObject	java.lang.Object
    //   28	1573	11	localb	kotlin.l.b.a.b.h.d.b
    //   36	1496	12	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	251	kotlin/l/b/a/b/h/l
    //   193	206	251	kotlin/l/b/a/b/h/l
    //   221	231	251	kotlin/l/b/a/b/h/l
    //   240	248	251	kotlin/l/b/a/b/h/l
    //   378	388	251	kotlin/l/b/a/b/h/l
    //   397	405	251	kotlin/l/b/a/b/h/l
    //   458	470	251	kotlin/l/b/a/b/h/l
    //   479	488	251	kotlin/l/b/a/b/h/l
    //   497	512	251	kotlin/l/b/a/b/h/l
    //   526	536	251	kotlin/l/b/a/b/h/l
    //   545	554	251	kotlin/l/b/a/b/h/l
    //   563	574	251	kotlin/l/b/a/b/h/l
    //   598	609	251	kotlin/l/b/a/b/h/l
    //   627	645	251	kotlin/l/b/a/b/h/l
    //   660	672	251	kotlin/l/b/a/b/h/l
    //   681	690	251	kotlin/l/b/a/b/h/l
    //   699	714	251	kotlin/l/b/a/b/h/l
    //   728	738	251	kotlin/l/b/a/b/h/l
    //   747	756	251	kotlin/l/b/a/b/h/l
    //   765	776	251	kotlin/l/b/a/b/h/l
    //   802	813	251	kotlin/l/b/a/b/h/l
    //   832	850	251	kotlin/l/b/a/b/h/l
    //   865	876	251	kotlin/l/b/a/b/h/l
    //   885	893	251	kotlin/l/b/a/b/h/l
    //   905	916	251	kotlin/l/b/a/b/h/l
    //   925	933	251	kotlin/l/b/a/b/h/l
    //   945	955	251	kotlin/l/b/a/b/h/l
    //   964	972	251	kotlin/l/b/a/b/h/l
    //   984	998	251	kotlin/l/b/a/b/h/l
    //   1007	1016	251	kotlin/l/b/a/b/h/l
    //   1025	1040	251	kotlin/l/b/a/b/h/l
    //   1054	1064	251	kotlin/l/b/a/b/h/l
    //   1073	1082	251	kotlin/l/b/a/b/h/l
    //   1091	1103	251	kotlin/l/b/a/b/h/l
    //   1129	1140	251	kotlin/l/b/a/b/h/l
    //   1159	1176	251	kotlin/l/b/a/b/h/l
    //   1191	1201	251	kotlin/l/b/a/b/h/l
    //   1227	1234	251	kotlin/l/b/a/b/h/l
    //   1243	1254	251	kotlin/l/b/a/b/h/l
    //   1273	1280	251	kotlin/l/b/a/b/h/l
    //   1292	1309	251	kotlin/l/b/a/b/h/l
    //   1324	1330	251	kotlin/l/b/a/b/h/l
    //   1345	1359	251	kotlin/l/b/a/b/h/l
    //   1368	1377	251	kotlin/l/b/a/b/h/l
    //   1386	1401	251	kotlin/l/b/a/b/h/l
    //   1415	1425	251	kotlin/l/b/a/b/h/l
    //   1434	1443	251	kotlin/l/b/a/b/h/l
    //   1452	1464	251	kotlin/l/b/a/b/h/l
    //   55	61	276	finally
    //   193	206	276	finally
    //   221	231	276	finally
    //   240	248	276	finally
    //   256	261	276	finally
    //   265	270	276	finally
    //   274	276	276	finally
    //   378	388	276	finally
    //   397	405	276	finally
    //   413	425	276	finally
    //   429	434	276	finally
    //   438	443	276	finally
    //   447	449	276	finally
    //   458	470	276	finally
    //   479	488	276	finally
    //   497	512	276	finally
    //   526	536	276	finally
    //   545	554	276	finally
    //   563	574	276	finally
    //   598	609	276	finally
    //   627	645	276	finally
    //   660	672	276	finally
    //   681	690	276	finally
    //   699	714	276	finally
    //   728	738	276	finally
    //   747	756	276	finally
    //   765	776	276	finally
    //   802	813	276	finally
    //   832	850	276	finally
    //   865	876	276	finally
    //   885	893	276	finally
    //   905	916	276	finally
    //   925	933	276	finally
    //   945	955	276	finally
    //   964	972	276	finally
    //   984	998	276	finally
    //   1007	1016	276	finally
    //   1025	1040	276	finally
    //   1054	1064	276	finally
    //   1073	1082	276	finally
    //   1091	1103	276	finally
    //   1129	1140	276	finally
    //   1159	1176	276	finally
    //   1191	1201	276	finally
    //   1227	1234	276	finally
    //   1243	1254	276	finally
    //   1273	1280	276	finally
    //   1292	1309	276	finally
    //   1324	1330	276	finally
    //   1345	1359	276	finally
    //   1368	1377	276	finally
    //   1386	1401	276	finally
    //   1415	1425	276	finally
    //   1434	1443	276	finally
    //   1452	1464	276	finally
    //   55	61	408	java/io/IOException
    //   193	206	408	java/io/IOException
    //   221	231	408	java/io/IOException
    //   240	248	408	java/io/IOException
    //   378	388	408	java/io/IOException
    //   397	405	408	java/io/IOException
    //   458	470	408	java/io/IOException
    //   479	488	408	java/io/IOException
    //   497	512	408	java/io/IOException
    //   526	536	408	java/io/IOException
    //   545	554	408	java/io/IOException
    //   563	574	408	java/io/IOException
    //   598	609	408	java/io/IOException
    //   627	645	408	java/io/IOException
    //   660	672	408	java/io/IOException
    //   681	690	408	java/io/IOException
    //   699	714	408	java/io/IOException
    //   728	738	408	java/io/IOException
    //   747	756	408	java/io/IOException
    //   765	776	408	java/io/IOException
    //   802	813	408	java/io/IOException
    //   832	850	408	java/io/IOException
    //   865	876	408	java/io/IOException
    //   885	893	408	java/io/IOException
    //   905	916	408	java/io/IOException
    //   925	933	408	java/io/IOException
    //   945	955	408	java/io/IOException
    //   964	972	408	java/io/IOException
    //   984	998	408	java/io/IOException
    //   1007	1016	408	java/io/IOException
    //   1025	1040	408	java/io/IOException
    //   1054	1064	408	java/io/IOException
    //   1073	1082	408	java/io/IOException
    //   1091	1103	408	java/io/IOException
    //   1129	1140	408	java/io/IOException
    //   1159	1176	408	java/io/IOException
    //   1191	1201	408	java/io/IOException
    //   1227	1234	408	java/io/IOException
    //   1243	1254	408	java/io/IOException
    //   1273	1280	408	java/io/IOException
    //   1292	1309	408	java/io/IOException
    //   1324	1330	408	java/io/IOException
    //   1345	1359	408	java/io/IOException
    //   1368	1377	408	java/io/IOException
    //   1386	1401	408	java/io/IOException
    //   1415	1425	408	java/io/IOException
    //   1434	1443	408	java/io/IOException
    //   1452	1464	408	java/io/IOException
    //   1531	1536	1555	java/io/IOException
    //   1531	1536	1568	finally
    //   344	349	1585	java/io/IOException
    //   344	349	1598	finally
  }
  
  private a$h(i.b<h, ?> paramb)
  {
    super(paramb);
    this.aiXZ = paramb.aiXZ;
  }
  
  public static h b(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(58615);
    paramInputStream = (h)aiYa.j(paramInputStream, paramg);
    AppMethodBeat.o(58615);
    return paramInputStream;
  }
  
  private void ktf()
  {
    AppMethodBeat.i(58611);
    this.aiYq = 6;
    this.aiZP = 6;
    this.aiZC = 0;
    this.aiZQ = a.p.kvH();
    this.aiZR = 0;
    this.aiYJ = Collections.emptyList();
    this.aiZS = a.p.kvH();
    this.aiZT = 0;
    this.aiZl = Collections.emptyList();
    this.aiYZ = a.s.kww();
    this.aiZa = Collections.emptyList();
    this.aiZU = a.d.kum();
    AppMethodBeat.o(58611);
  }
  
  public static h kuO()
  {
    return aiZO;
  }
  
  public final void a(f paramf)
  {
    int j = 0;
    AppMethodBeat.i(58613);
    getSerializedSize();
    i.c.a locala = kym();
    if ((this.bitField0_ & 0x2) == 2) {
      paramf.cF(1, this.aiZP);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramf.cF(2, this.aiZC);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramf.a(3, this.aiZQ);
    }
    int i = 0;
    while (i < this.aiYJ.size())
    {
      paramf.a(4, (r)this.aiYJ.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramf.a(5, this.aiZS);
    }
    i = 0;
    while (i < this.aiZl.size())
    {
      paramf.a(6, (r)this.aiZl.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramf.cF(7, this.aiZR);
    }
    if ((this.bitField0_ & 0x40) == 64) {
      paramf.cF(8, this.aiZT);
    }
    if ((this.bitField0_ & 0x1) == 1) {
      paramf.cF(9, this.aiYq);
    }
    i = j;
    if ((this.bitField0_ & 0x80) == 128)
    {
      paramf.a(30, this.aiYZ);
      i = j;
    }
    while (i < this.aiZa.size())
    {
      paramf.cF(31, ((Integer)this.aiZa.get(i)).intValue());
      i += 1;
    }
    if ((this.bitField0_ & 0x100) == 256) {
      paramf.a(32, this.aiZU);
    }
    locala.b(19000, paramf);
    paramf.e(this.aiXZ);
    AppMethodBeat.o(58613);
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(58614);
    int i = this.dRJ;
    if (i != -1)
    {
      AppMethodBeat.o(58614);
      return i;
    }
    if ((this.bitField0_ & 0x2) == 2) {}
    for (int j = f.cJ(1, this.aiZP) + 0;; j = 0)
    {
      i = j;
      if ((this.bitField0_ & 0x4) == 4) {
        i = j + f.cJ(2, this.aiZC);
      }
      j = i;
      if ((this.bitField0_ & 0x8) == 8) {
        j = i + f.c(3, this.aiZQ);
      }
      int k = 0;
      i = j;
      j = k;
      while (j < this.aiYJ.size())
      {
        i += f.c(4, (r)this.aiYJ.get(j));
        j += 1;
      }
      j = i;
      if ((this.bitField0_ & 0x20) == 32) {
        j = i + f.c(5, this.aiZS);
      }
      k = 0;
      i = j;
      j = k;
      while (j < this.aiZl.size())
      {
        i += f.c(6, (r)this.aiZl.get(j));
        j += 1;
      }
      j = i;
      if ((this.bitField0_ & 0x10) == 16) {
        j = i + f.cJ(7, this.aiZR);
      }
      i = j;
      if ((this.bitField0_ & 0x40) == 64) {
        i = j + f.cJ(8, this.aiZT);
      }
      j = i;
      if ((this.bitField0_ & 0x1) == 1) {
        j = i + f.cJ(9, this.aiYq);
      }
      i = j;
      if ((this.bitField0_ & 0x80) == 128) {
        i = j + f.c(30, this.aiYZ);
      }
      k = 0;
      int m;
      for (j = 0; k < this.aiZa.size(); j = m + j)
      {
        m = f.kp(((Integer)this.aiZa.get(k)).intValue());
        k += 1;
      }
      j = i + j + this.aiZa.size() * 2;
      i = j;
      if ((this.bitField0_ & 0x100) == 256) {
        i = j + f.c(32, this.aiZU);
      }
      i = i + aie() + this.aiXZ.size();
      this.dRJ = i;
      AppMethodBeat.o(58614);
      return i;
    }
  }
  
  public final boolean hasName()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58612);
    int i = this.memoizedIsInitialized;
    if (i == 1)
    {
      AppMethodBeat.o(58612);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58612);
      return false;
    }
    if (!hasName())
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58612);
      return false;
    }
    if ((kuQ()) && (!this.aiZQ.isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58612);
      return false;
    }
    i = 0;
    while (i < this.aiYJ.size())
    {
      if (!((a.r)this.aiYJ.get(i)).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58612);
        return false;
      }
      i += 1;
    }
    if ((kuS()) && (!this.aiZS.isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58612);
      return false;
    }
    i = 0;
    while (i < this.aiZl.size())
    {
      if (!((a.t)this.aiZl.get(i)).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58612);
        return false;
      }
      i += 1;
    }
    if ((ktQ()) && (!this.aiYZ.isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58612);
      return false;
    }
    if ((kuU()) && (!this.aiZU.isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58612);
      return false;
    }
    if (!aic())
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58612);
      return false;
    }
    this.memoizedIsInitialized = 1;
    AppMethodBeat.o(58612);
    return true;
  }
  
  public final boolean ktB()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public final boolean ktQ()
  {
    return (this.bitField0_ & 0x80) == 128;
  }
  
  public final boolean kuP()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public final boolean kuQ()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public final boolean kuR()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public final boolean kuS()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public final boolean kuT()
  {
    return (this.bitField0_ & 0x40) == 64;
  }
  
  public final boolean kuU()
  {
    return (this.bitField0_ & 0x100) == 256;
  }
  
  public static final class a
    extends i.b<a.h, a>
    implements k
  {
    private List<a.r> aiYJ;
    private a.s aiYZ;
    private int aiYq;
    private int aiZC;
    private int aiZP;
    private a.p aiZQ;
    private int aiZR;
    private a.p aiZS;
    private int aiZT;
    private a.d aiZU;
    private List<Integer> aiZa;
    private List<a.t> aiZl;
    private int bitField0_;
    
    private a()
    {
      AppMethodBeat.i(58586);
      this.aiYq = 6;
      this.aiZP = 6;
      this.aiZQ = a.p.kvH();
      this.aiYJ = Collections.emptyList();
      this.aiZS = a.p.kvH();
      this.aiZl = Collections.emptyList();
      this.aiYZ = a.s.kww();
      this.aiZa = Collections.emptyList();
      this.aiZU = a.d.kum();
      AppMethodBeat.o(58586);
    }
    
    private a aKZ(int paramInt)
    {
      this.bitField0_ |= 0x1;
      this.aiYq = paramInt;
      return this;
    }
    
    private a aLa(int paramInt)
    {
      this.bitField0_ |= 0x2;
      this.aiZP = paramInt;
      return this;
    }
    
    private a aLb(int paramInt)
    {
      this.bitField0_ |= 0x4;
      this.aiZC = paramInt;
      return this;
    }
    
    private a aLc(int paramInt)
    {
      this.bitField0_ |= 0x10;
      this.aiZR = paramInt;
      return this;
    }
    
    private a aLd(int paramInt)
    {
      this.bitField0_ |= 0x80;
      this.aiZT = paramInt;
      return this;
    }
    
    private a b(a.s params)
    {
      AppMethodBeat.i(58596);
      if (((this.bitField0_ & 0x200) == 512) && (this.aiYZ != a.s.kww())) {}
      for (this.aiYZ = a.s.d(this.aiYZ).g(params).kwz();; this.aiYZ = params)
      {
        this.bitField0_ |= 0x200;
        AppMethodBeat.o(58596);
        return this;
      }
    }
    
    private a c(a.p paramp)
    {
      AppMethodBeat.i(58592);
      if (((this.bitField0_ & 0x8) == 8) && (this.aiZQ != a.p.kvH())) {}
      for (this.aiZQ = a.p.g(this.aiZQ).k(paramp).kwd();; this.aiZQ = paramp)
      {
        this.bitField0_ |= 0x8;
        AppMethodBeat.o(58592);
        return this;
      }
    }
    
    private a d(a.p paramp)
    {
      AppMethodBeat.i(58594);
      if (((this.bitField0_ & 0x40) == 64) && (this.aiZS != a.p.kvH())) {}
      for (this.aiZS = a.p.g(this.aiZS).k(paramp).kwd();; this.aiZS = paramp)
      {
        this.bitField0_ |= 0x40;
        AppMethodBeat.o(58594);
        return this;
      }
    }
    
    private a e(a.d paramd)
    {
      AppMethodBeat.i(58598);
      if (((this.bitField0_ & 0x800) == 2048) && (this.aiZU != a.d.kum())) {}
      for (this.aiZU = a.d.a(this.aiZU).d(paramd).kup();; this.aiZU = paramd)
      {
        this.bitField0_ |= 0x800;
        AppMethodBeat.o(58598);
        return this;
      }
    }
    
    private void ktU()
    {
      AppMethodBeat.i(58593);
      if ((this.bitField0_ & 0x20) != 32)
      {
        this.aiYJ = new ArrayList(this.aiYJ);
        this.bitField0_ |= 0x20;
      }
      AppMethodBeat.o(58593);
    }
    
    private a kuV()
    {
      AppMethodBeat.i(58587);
      a locala = new a().e(kuW());
      AppMethodBeat.o(58587);
      return locala;
    }
    
    private a.h kuW()
    {
      int j = 1;
      AppMethodBeat.i(58588);
      a.h localh = new a.h(this, (byte)0);
      int k = this.bitField0_;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.h.a(localh, this.aiYq);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.h.b(localh, this.aiZP);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.h.c(localh, this.aiZC);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.h.a(localh, this.aiZQ);
        j = i;
        if ((k & 0x10) == 16) {
          j = i | 0x10;
        }
        a.h.d(localh, this.aiZR);
        if ((this.bitField0_ & 0x20) == 32)
        {
          this.aiYJ = Collections.unmodifiableList(this.aiYJ);
          this.bitField0_ &= 0xFFFFFFDF;
        }
        a.h.a(localh, this.aiYJ);
        i = j;
        if ((k & 0x40) == 64) {
          i = j | 0x20;
        }
        a.h.b(localh, this.aiZS);
        j = i;
        if ((k & 0x80) == 128) {
          j = i | 0x40;
        }
        a.h.e(localh, this.aiZT);
        if ((this.bitField0_ & 0x100) == 256)
        {
          this.aiZl = Collections.unmodifiableList(this.aiZl);
          this.bitField0_ &= 0xFFFFFEFF;
        }
        a.h.b(localh, this.aiZl);
        i = j;
        if ((k & 0x200) == 512) {
          i = j | 0x80;
        }
        a.h.a(localh, this.aiYZ);
        if ((this.bitField0_ & 0x400) == 1024)
        {
          this.aiZa = Collections.unmodifiableList(this.aiZa);
          this.bitField0_ &= 0xFFFFFBFF;
        }
        a.h.c(localh, this.aiZa);
        j = i;
        if ((k & 0x800) == 2048) {
          j = i | 0x100;
        }
        a.h.a(localh, this.aiZU);
        a.h.f(localh, j);
        AppMethodBeat.o(58588);
        return localh;
        j = 0;
      }
    }
    
    private void kue()
    {
      AppMethodBeat.i(58597);
      if ((this.bitField0_ & 0x400) != 1024)
      {
        this.aiZa = new ArrayList(this.aiZa);
        this.bitField0_ |= 0x400;
      }
      AppMethodBeat.o(58597);
    }
    
    private void kuk()
    {
      AppMethodBeat.i(58595);
      if ((this.bitField0_ & 0x100) != 256)
      {
        this.aiZl = new ArrayList(this.aiZl);
        this.bitField0_ |= 0x100;
      }
      AppMethodBeat.o(58595);
    }
    
    /* Error */
    private a m(kotlin.l.b.a.b.h.e parame, g paramg)
    {
      // Byte code:
      //   0: ldc 217
      //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 221	kotlin/l/b/a/b/e/a$h:aiYa	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 226 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$h
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 166	kotlin/l/b/a/b/e/a$h$a:e	(Lkotlin/l/b/a/b/e/a$h;)Lkotlin/l/b/a/b/e/a$h$a;
      //   30: pop
      //   31: ldc 217
      //   33: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 230	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   43: checkcast 9	kotlin/l/b/a/b/e/a$h
      //   46: astore_2
      //   47: ldc 217
      //   49: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: aload_2
      //   56: ifnull +9 -> 65
      //   59: aload_0
      //   60: aload_2
      //   61: invokevirtual 166	kotlin/l/b/a/b/e/a$h$a:e	(Lkotlin/l/b/a/b/e/a$h;)Lkotlin/l/b/a/b/e/a$h$a;
      //   64: pop
      //   65: ldc 217
      //   67: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   0	78	2	paramg	g
      //   6	68	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	kotlin/l/b/a/b/h/l
      //   47	54	54	finally
      //   7	21	72	finally
      //   39	47	72	finally
    }
    
    public final a e(a.h paramh)
    {
      AppMethodBeat.i(58589);
      if (paramh == a.h.kuO())
      {
        AppMethodBeat.o(58589);
        return this;
      }
      if (paramh.ktB()) {
        aKZ(paramh.aiYq);
      }
      if (paramh.kuP()) {
        aLa(paramh.aiZP);
      }
      if (paramh.hasName()) {
        aLb(paramh.aiZC);
      }
      if (paramh.kuQ()) {
        c(paramh.aiZQ);
      }
      if (paramh.kuR()) {
        aLc(paramh.aiZR);
      }
      if (!a.h.a(paramh).isEmpty())
      {
        if (this.aiYJ.isEmpty())
        {
          this.aiYJ = a.h.a(paramh);
          this.bitField0_ &= 0xFFFFFFDF;
        }
      }
      else
      {
        if (paramh.kuS()) {
          d(paramh.aiZS);
        }
        if (paramh.kuT()) {
          aLd(paramh.aiZT);
        }
        if (!a.h.b(paramh).isEmpty())
        {
          if (!this.aiZl.isEmpty()) {
            break label342;
          }
          this.aiZl = a.h.b(paramh);
          this.bitField0_ &= 0xFFFFFEFF;
        }
        label218:
        if (paramh.ktQ()) {
          b(paramh.aiYZ);
        }
        if (!a.h.c(paramh).isEmpty())
        {
          if (!this.aiZa.isEmpty()) {
            break label363;
          }
          this.aiZa = a.h.c(paramh);
          this.bitField0_ &= 0xFFFFFBFF;
        }
      }
      for (;;)
      {
        if (paramh.kuU()) {
          e(paramh.aiZU);
        }
        a(paramh);
        this.aiXZ = this.aiXZ.a(a.h.d(paramh));
        AppMethodBeat.o(58589);
        return this;
        ktU();
        this.aiYJ.addAll(a.h.a(paramh));
        break;
        label342:
        kuk();
        this.aiZl.addAll(a.h.b(paramh));
        break label218;
        label363:
        kue();
        this.aiZa.addAll(a.h.c(paramh));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58590);
      if ((this.bitField0_ & 0x4) == 4) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58590);
        return false;
      }
      if ((this.bitField0_ & 0x8) == 8) {}
      for (i = 1; (i != 0) && (!this.aiZQ.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58590);
        return false;
      }
      i = 0;
      while (i < this.aiYJ.size())
      {
        if (!((a.r)this.aiYJ.get(i)).isInitialized())
        {
          AppMethodBeat.o(58590);
          return false;
        }
        i += 1;
      }
      if ((this.bitField0_ & 0x40) == 64) {}
      for (i = 1; (i != 0) && (!this.aiZS.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58590);
        return false;
      }
      i = 0;
      while (i < this.aiZl.size())
      {
        if (!((a.t)this.aiZl.get(i)).isInitialized())
        {
          AppMethodBeat.o(58590);
          return false;
        }
        i += 1;
      }
      if ((this.bitField0_ & 0x200) == 512) {}
      for (i = 1; (i != 0) && (!this.aiYZ.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58590);
        return false;
      }
      if ((this.bitField0_ & 0x800) == 2048) {}
      for (i = 1; (i != 0) && (!this.aiZU.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58590);
        return false;
      }
      if (!aic())
      {
        AppMethodBeat.o(58590);
        return false;
      }
      AppMethodBeat.o(58590);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.h
 * JD-Core Version:    0.7.0.1
 */