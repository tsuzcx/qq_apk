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

public final class a$k
  extends i.c<k>
  implements m
{
  public static t<k> aaZC;
  private static final k abbE;
  private final d aaZB;
  public a.v abaA;
  public List<a.h> abas;
  public List<a.m> abat;
  public List<a.q> abau;
  public a.s abay;
  private int bQS;
  private byte bRd = -1;
  private int bXW = -1;
  
  static
  {
    AppMethodBeat.i(58660);
    aaZC = new b() {};
    k localk = new k();
    abbE = localk;
    localk.iIN();
    AppMethodBeat.o(58660);
  }
  
  private a$k()
  {
    this.aaZB = d.abgb;
  }
  
  /* Error */
  private a$k(kotlin.l.b.a.b.h.e parame, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 63	kotlin/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 80
    //   6: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 65	kotlin/l/b/a/b/e/a$k:bRd	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 67	kotlin/l/b/a/b/e/a$k:bXW	I
    //   19: aload_0
    //   20: invokespecial 58	kotlin/l/b/a/b/e/a$k:iIN	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 84	kotlin/l/b/a/b/h/d:iNH	()Lkotlin/l/b/a/b/h/d$b;
    //   28: astore 10
    //   30: aload 10
    //   32: iconst_1
    //   33: invokestatic 90	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   36: astore 11
    //   38: iconst_0
    //   39: istore 8
    //   41: iload 8
    //   43: ifne +717 -> 760
    //   46: iload_3
    //   47: istore 5
    //   49: iload_3
    //   50: istore 4
    //   52: iload_3
    //   53: istore 6
    //   55: aload_1
    //   56: invokevirtual 96	kotlin/l/b/a/b/h/e:Av	()I
    //   59: istore 7
    //   61: iload 7
    //   63: lookupswitch	default:+847->910, 0:+850->913, 26:+85->148, 34:+264->327, 42:+376->439, 242:+447->510, 258:+572->635
    //   121: istore 5
    //   123: iload_3
    //   124: istore 4
    //   126: iload_3
    //   127: istore 6
    //   129: aload_0
    //   130: aload_1
    //   131: aload 11
    //   133: aload_2
    //   134: iload 7
    //   136: invokevirtual 99	kotlin/l/b/a/b/e/a$k:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   139: ifne -98 -> 41
    //   142: iconst_1
    //   143: istore 8
    //   145: goto -104 -> 41
    //   148: iload_3
    //   149: istore 7
    //   151: iload_3
    //   152: iconst_1
    //   153: iand
    //   154: iconst_1
    //   155: if_icmpeq +28 -> 183
    //   158: iload_3
    //   159: istore 5
    //   161: iload_3
    //   162: istore 4
    //   164: iload_3
    //   165: istore 6
    //   167: aload_0
    //   168: new 101	java/util/ArrayList
    //   171: dup
    //   172: invokespecial 102	java/util/ArrayList:<init>	()V
    //   175: putfield 104	kotlin/l/b/a/b/e/a$k:abas	Ljava/util/List;
    //   178: iload_3
    //   179: iconst_1
    //   180: ior
    //   181: istore 7
    //   183: iload 7
    //   185: istore 5
    //   187: iload 7
    //   189: istore 4
    //   191: iload 7
    //   193: istore 6
    //   195: aload_0
    //   196: getfield 104	kotlin/l/b/a/b/e/a$k:abas	Ljava/util/List;
    //   199: aload_1
    //   200: getstatic 107	kotlin/l/b/a/b/e/a$h:aaZC	Lkotlin/l/b/a/b/h/t;
    //   203: aload_2
    //   204: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   207: invokeinterface 116 2 0
    //   212: pop
    //   213: iload 7
    //   215: istore_3
    //   216: goto -175 -> 41
    //   219: astore_1
    //   220: iload 5
    //   222: istore 4
    //   224: aload_1
    //   225: aload_0
    //   226: putfield 120	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   229: iload 5
    //   231: istore 4
    //   233: ldc 80
    //   235: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: iload 5
    //   240: istore 4
    //   242: aload_1
    //   243: athrow
    //   244: astore_1
    //   245: iload 4
    //   247: iconst_1
    //   248: iand
    //   249: iconst_1
    //   250: if_icmpne +14 -> 264
    //   253: aload_0
    //   254: aload_0
    //   255: getfield 104	kotlin/l/b/a/b/e/a$k:abas	Ljava/util/List;
    //   258: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   261: putfield 104	kotlin/l/b/a/b/e/a$k:abas	Ljava/util/List;
    //   264: iload 4
    //   266: iconst_2
    //   267: iand
    //   268: iconst_2
    //   269: if_icmpne +14 -> 283
    //   272: aload_0
    //   273: aload_0
    //   274: getfield 128	kotlin/l/b/a/b/e/a$k:abat	Ljava/util/List;
    //   277: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   280: putfield 128	kotlin/l/b/a/b/e/a$k:abat	Ljava/util/List;
    //   283: iload 4
    //   285: iconst_4
    //   286: iand
    //   287: iconst_4
    //   288: if_icmpne +14 -> 302
    //   291: aload_0
    //   292: aload_0
    //   293: getfield 130	kotlin/l/b/a/b/e/a$k:abau	Ljava/util/List;
    //   296: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   299: putfield 130	kotlin/l/b/a/b/e/a$k:abau	Ljava/util/List;
    //   302: aload 11
    //   304: invokevirtual 133	kotlin/l/b/a/b/h/f:flush	()V
    //   307: aload_0
    //   308: aload 10
    //   310: invokevirtual 139	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   313: putfield 74	kotlin/l/b/a/b/e/a$k:aaZB	Lkotlin/l/b/a/b/h/d;
    //   316: aload_0
    //   317: invokevirtual 142	kotlin/l/b/a/b/e/a$k:HZ	()V
    //   320: ldc 80
    //   322: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   325: aload_1
    //   326: athrow
    //   327: iload_3
    //   328: istore 7
    //   330: iload_3
    //   331: iconst_2
    //   332: iand
    //   333: iconst_2
    //   334: if_icmpeq +28 -> 362
    //   337: iload_3
    //   338: istore 5
    //   340: iload_3
    //   341: istore 4
    //   343: iload_3
    //   344: istore 6
    //   346: aload_0
    //   347: new 101	java/util/ArrayList
    //   350: dup
    //   351: invokespecial 102	java/util/ArrayList:<init>	()V
    //   354: putfield 128	kotlin/l/b/a/b/e/a$k:abat	Ljava/util/List;
    //   357: iload_3
    //   358: iconst_2
    //   359: ior
    //   360: istore 7
    //   362: iload 7
    //   364: istore 5
    //   366: iload 7
    //   368: istore 4
    //   370: iload 7
    //   372: istore 6
    //   374: aload_0
    //   375: getfield 128	kotlin/l/b/a/b/e/a$k:abat	Ljava/util/List;
    //   378: aload_1
    //   379: getstatic 145	kotlin/l/b/a/b/e/a$m:aaZC	Lkotlin/l/b/a/b/h/t;
    //   382: aload_2
    //   383: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   386: invokeinterface 116 2 0
    //   391: pop
    //   392: iload 7
    //   394: istore_3
    //   395: goto -354 -> 41
    //   398: astore_1
    //   399: iload 6
    //   401: istore 4
    //   403: new 77	kotlin/l/b/a/b/h/l
    //   406: dup
    //   407: aload_1
    //   408: invokevirtual 149	java/io/IOException:getMessage	()Ljava/lang/String;
    //   411: invokespecial 152	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   414: astore_1
    //   415: iload 6
    //   417: istore 4
    //   419: aload_1
    //   420: aload_0
    //   421: putfield 120	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   424: iload 6
    //   426: istore 4
    //   428: ldc 80
    //   430: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   433: iload 6
    //   435: istore 4
    //   437: aload_1
    //   438: athrow
    //   439: iload_3
    //   440: istore 7
    //   442: iload_3
    //   443: iconst_4
    //   444: iand
    //   445: iconst_4
    //   446: if_icmpeq +28 -> 474
    //   449: iload_3
    //   450: istore 5
    //   452: iload_3
    //   453: istore 4
    //   455: iload_3
    //   456: istore 6
    //   458: aload_0
    //   459: new 101	java/util/ArrayList
    //   462: dup
    //   463: invokespecial 102	java/util/ArrayList:<init>	()V
    //   466: putfield 130	kotlin/l/b/a/b/e/a$k:abau	Ljava/util/List;
    //   469: iload_3
    //   470: iconst_4
    //   471: ior
    //   472: istore 7
    //   474: iload 7
    //   476: istore 5
    //   478: iload 7
    //   480: istore 4
    //   482: iload 7
    //   484: istore 6
    //   486: aload_0
    //   487: getfield 130	kotlin/l/b/a/b/e/a$k:abau	Ljava/util/List;
    //   490: aload_1
    //   491: getstatic 155	kotlin/l/b/a/b/e/a$q:aaZC	Lkotlin/l/b/a/b/h/t;
    //   494: aload_2
    //   495: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   498: invokeinterface 116 2 0
    //   503: pop
    //   504: iload 7
    //   506: istore_3
    //   507: goto -466 -> 41
    //   510: iload_3
    //   511: istore 5
    //   513: iload_3
    //   514: istore 4
    //   516: iload_3
    //   517: istore 6
    //   519: aload_0
    //   520: getfield 157	kotlin/l/b/a/b/e/a$k:bQS	I
    //   523: iconst_1
    //   524: iand
    //   525: iconst_1
    //   526: if_icmpne +378 -> 904
    //   529: iload_3
    //   530: istore 5
    //   532: iload_3
    //   533: istore 4
    //   535: iload_3
    //   536: istore 6
    //   538: aload_0
    //   539: getfield 159	kotlin/l/b/a/b/e/a$k:abay	Lkotlin/l/b/a/b/e/a$s;
    //   542: invokestatic 165	kotlin/l/b/a/b/e/a$s:d	(Lkotlin/l/b/a/b/e/a$s;)Lkotlin/l/b/a/b/e/a$s$a;
    //   545: astore 9
    //   547: iload_3
    //   548: istore 5
    //   550: iload_3
    //   551: istore 4
    //   553: iload_3
    //   554: istore 6
    //   556: aload_0
    //   557: aload_1
    //   558: getstatic 166	kotlin/l/b/a/b/e/a$s:aaZC	Lkotlin/l/b/a/b/h/t;
    //   561: aload_2
    //   562: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   565: checkcast 161	kotlin/l/b/a/b/e/a$s
    //   568: putfield 159	kotlin/l/b/a/b/e/a$k:abay	Lkotlin/l/b/a/b/e/a$s;
    //   571: aload 9
    //   573: ifnull +40 -> 613
    //   576: iload_3
    //   577: istore 5
    //   579: iload_3
    //   580: istore 4
    //   582: iload_3
    //   583: istore 6
    //   585: aload 9
    //   587: aload_0
    //   588: getfield 159	kotlin/l/b/a/b/e/a$k:abay	Lkotlin/l/b/a/b/e/a$s;
    //   591: invokevirtual 171	kotlin/l/b/a/b/e/a$s$a:g	(Lkotlin/l/b/a/b/e/a$s;)Lkotlin/l/b/a/b/e/a$s$a;
    //   594: pop
    //   595: iload_3
    //   596: istore 5
    //   598: iload_3
    //   599: istore 4
    //   601: iload_3
    //   602: istore 6
    //   604: aload_0
    //   605: aload 9
    //   607: invokevirtual 175	kotlin/l/b/a/b/e/a$s$a:iMe	()Lkotlin/l/b/a/b/e/a$s;
    //   610: putfield 159	kotlin/l/b/a/b/e/a$k:abay	Lkotlin/l/b/a/b/e/a$s;
    //   613: iload_3
    //   614: istore 5
    //   616: iload_3
    //   617: istore 4
    //   619: iload_3
    //   620: istore 6
    //   622: aload_0
    //   623: aload_0
    //   624: getfield 157	kotlin/l/b/a/b/e/a$k:bQS	I
    //   627: iconst_1
    //   628: ior
    //   629: putfield 157	kotlin/l/b/a/b/e/a$k:bQS	I
    //   632: goto -591 -> 41
    //   635: iload_3
    //   636: istore 5
    //   638: iload_3
    //   639: istore 4
    //   641: iload_3
    //   642: istore 6
    //   644: aload_0
    //   645: getfield 157	kotlin/l/b/a/b/e/a$k:bQS	I
    //   648: iconst_2
    //   649: iand
    //   650: iconst_2
    //   651: if_icmpne +247 -> 898
    //   654: iload_3
    //   655: istore 5
    //   657: iload_3
    //   658: istore 4
    //   660: iload_3
    //   661: istore 6
    //   663: aload_0
    //   664: getfield 177	kotlin/l/b/a/b/e/a$k:abaA	Lkotlin/l/b/a/b/e/a$v;
    //   667: invokestatic 183	kotlin/l/b/a/b/e/a$v:c	(Lkotlin/l/b/a/b/e/a$v;)Lkotlin/l/b/a/b/e/a$v$a;
    //   670: astore 9
    //   672: iload_3
    //   673: istore 5
    //   675: iload_3
    //   676: istore 4
    //   678: iload_3
    //   679: istore 6
    //   681: aload_0
    //   682: aload_1
    //   683: getstatic 184	kotlin/l/b/a/b/e/a$v:aaZC	Lkotlin/l/b/a/b/h/t;
    //   686: aload_2
    //   687: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   690: checkcast 179	kotlin/l/b/a/b/e/a$v
    //   693: putfield 177	kotlin/l/b/a/b/e/a$k:abaA	Lkotlin/l/b/a/b/e/a$v;
    //   696: aload 9
    //   698: ifnull +40 -> 738
    //   701: iload_3
    //   702: istore 5
    //   704: iload_3
    //   705: istore 4
    //   707: iload_3
    //   708: istore 6
    //   710: aload 9
    //   712: aload_0
    //   713: getfield 177	kotlin/l/b/a/b/e/a$k:abaA	Lkotlin/l/b/a/b/e/a$v;
    //   716: invokevirtual 188	kotlin/l/b/a/b/e/a$v$a:f	(Lkotlin/l/b/a/b/e/a$v;)Lkotlin/l/b/a/b/e/a$v$a;
    //   719: pop
    //   720: iload_3
    //   721: istore 5
    //   723: iload_3
    //   724: istore 4
    //   726: iload_3
    //   727: istore 6
    //   729: aload_0
    //   730: aload 9
    //   732: invokevirtual 192	kotlin/l/b/a/b/e/a$v$a:iMz	()Lkotlin/l/b/a/b/e/a$v;
    //   735: putfield 177	kotlin/l/b/a/b/e/a$k:abaA	Lkotlin/l/b/a/b/e/a$v;
    //   738: iload_3
    //   739: istore 5
    //   741: iload_3
    //   742: istore 4
    //   744: iload_3
    //   745: istore 6
    //   747: aload_0
    //   748: aload_0
    //   749: getfield 157	kotlin/l/b/a/b/e/a$k:bQS	I
    //   752: iconst_2
    //   753: ior
    //   754: putfield 157	kotlin/l/b/a/b/e/a$k:bQS	I
    //   757: goto -716 -> 41
    //   760: iload_3
    //   761: iconst_1
    //   762: iand
    //   763: iconst_1
    //   764: if_icmpne +14 -> 778
    //   767: aload_0
    //   768: aload_0
    //   769: getfield 104	kotlin/l/b/a/b/e/a$k:abas	Ljava/util/List;
    //   772: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   775: putfield 104	kotlin/l/b/a/b/e/a$k:abas	Ljava/util/List;
    //   778: iload_3
    //   779: iconst_2
    //   780: iand
    //   781: iconst_2
    //   782: if_icmpne +14 -> 796
    //   785: aload_0
    //   786: aload_0
    //   787: getfield 128	kotlin/l/b/a/b/e/a$k:abat	Ljava/util/List;
    //   790: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   793: putfield 128	kotlin/l/b/a/b/e/a$k:abat	Ljava/util/List;
    //   796: iload_3
    //   797: iconst_4
    //   798: iand
    //   799: iconst_4
    //   800: if_icmpne +14 -> 814
    //   803: aload_0
    //   804: aload_0
    //   805: getfield 130	kotlin/l/b/a/b/e/a$k:abau	Ljava/util/List;
    //   808: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   811: putfield 130	kotlin/l/b/a/b/e/a$k:abau	Ljava/util/List;
    //   814: aload 11
    //   816: invokevirtual 133	kotlin/l/b/a/b/h/f:flush	()V
    //   819: aload_0
    //   820: aload 10
    //   822: invokevirtual 139	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   825: putfield 74	kotlin/l/b/a/b/e/a$k:aaZB	Lkotlin/l/b/a/b/h/d;
    //   828: aload_0
    //   829: invokevirtual 142	kotlin/l/b/a/b/e/a$k:HZ	()V
    //   832: ldc 80
    //   834: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   837: return
    //   838: astore_1
    //   839: aload_0
    //   840: aload 10
    //   842: invokevirtual 139	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   845: putfield 74	kotlin/l/b/a/b/e/a$k:aaZB	Lkotlin/l/b/a/b/h/d;
    //   848: goto -20 -> 828
    //   851: astore_1
    //   852: aload_0
    //   853: aload 10
    //   855: invokevirtual 139	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   858: putfield 74	kotlin/l/b/a/b/e/a$k:aaZB	Lkotlin/l/b/a/b/h/d;
    //   861: ldc 80
    //   863: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   866: aload_1
    //   867: athrow
    //   868: astore_2
    //   869: aload_0
    //   870: aload 10
    //   872: invokevirtual 139	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   875: putfield 74	kotlin/l/b/a/b/e/a$k:aaZB	Lkotlin/l/b/a/b/h/d;
    //   878: goto -562 -> 316
    //   881: astore_1
    //   882: aload_0
    //   883: aload 10
    //   885: invokevirtual 139	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   888: putfield 74	kotlin/l/b/a/b/e/a$k:aaZB	Lkotlin/l/b/a/b/h/d;
    //   891: ldc 80
    //   893: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   896: aload_1
    //   897: athrow
    //   898: aconst_null
    //   899: astore 9
    //   901: goto -229 -> 672
    //   904: aconst_null
    //   905: astore 9
    //   907: goto -360 -> 547
    //   910: goto -790 -> 120
    //   913: iconst_1
    //   914: istore 8
    //   916: goto -875 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	919	0	this	k
    //   0	919	1	parame	kotlin.l.b.a.b.h.e
    //   0	919	2	paramg	g
    //   24	775	3	i	int
    //   50	693	4	j	int
    //   47	693	5	k	int
    //   53	693	6	m	int
    //   59	446	7	n	int
    //   39	876	8	i1	int
    //   545	361	9	localObject	java.lang.Object
    //   28	856	10	localb	kotlin.l.b.a.b.h.d.b
    //   36	779	11	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	219	kotlin/l/b/a/b/h/l
    //   129	142	219	kotlin/l/b/a/b/h/l
    //   167	178	219	kotlin/l/b/a/b/h/l
    //   195	213	219	kotlin/l/b/a/b/h/l
    //   346	357	219	kotlin/l/b/a/b/h/l
    //   374	392	219	kotlin/l/b/a/b/h/l
    //   458	469	219	kotlin/l/b/a/b/h/l
    //   486	504	219	kotlin/l/b/a/b/h/l
    //   519	529	219	kotlin/l/b/a/b/h/l
    //   538	547	219	kotlin/l/b/a/b/h/l
    //   556	571	219	kotlin/l/b/a/b/h/l
    //   585	595	219	kotlin/l/b/a/b/h/l
    //   604	613	219	kotlin/l/b/a/b/h/l
    //   622	632	219	kotlin/l/b/a/b/h/l
    //   644	654	219	kotlin/l/b/a/b/h/l
    //   663	672	219	kotlin/l/b/a/b/h/l
    //   681	696	219	kotlin/l/b/a/b/h/l
    //   710	720	219	kotlin/l/b/a/b/h/l
    //   729	738	219	kotlin/l/b/a/b/h/l
    //   747	757	219	kotlin/l/b/a/b/h/l
    //   55	61	244	finally
    //   129	142	244	finally
    //   167	178	244	finally
    //   195	213	244	finally
    //   224	229	244	finally
    //   233	238	244	finally
    //   242	244	244	finally
    //   346	357	244	finally
    //   374	392	244	finally
    //   403	415	244	finally
    //   419	424	244	finally
    //   428	433	244	finally
    //   437	439	244	finally
    //   458	469	244	finally
    //   486	504	244	finally
    //   519	529	244	finally
    //   538	547	244	finally
    //   556	571	244	finally
    //   585	595	244	finally
    //   604	613	244	finally
    //   622	632	244	finally
    //   644	654	244	finally
    //   663	672	244	finally
    //   681	696	244	finally
    //   710	720	244	finally
    //   729	738	244	finally
    //   747	757	244	finally
    //   55	61	398	java/io/IOException
    //   129	142	398	java/io/IOException
    //   167	178	398	java/io/IOException
    //   195	213	398	java/io/IOException
    //   346	357	398	java/io/IOException
    //   374	392	398	java/io/IOException
    //   458	469	398	java/io/IOException
    //   486	504	398	java/io/IOException
    //   519	529	398	java/io/IOException
    //   538	547	398	java/io/IOException
    //   556	571	398	java/io/IOException
    //   585	595	398	java/io/IOException
    //   604	613	398	java/io/IOException
    //   622	632	398	java/io/IOException
    //   644	654	398	java/io/IOException
    //   663	672	398	java/io/IOException
    //   681	696	398	java/io/IOException
    //   710	720	398	java/io/IOException
    //   729	738	398	java/io/IOException
    //   747	757	398	java/io/IOException
    //   814	819	838	java/io/IOException
    //   814	819	851	finally
    //   302	307	868	java/io/IOException
    //   302	307	881	finally
  }
  
  private a$k(i.b<k, ?> paramb)
  {
    super(paramb);
    this.aaZB = paramb.aaZB;
  }
  
  public static a a(k paramk)
  {
    AppMethodBeat.i(58656);
    paramk = a.iKH().f(paramk);
    AppMethodBeat.o(58656);
    return paramk;
  }
  
  public static k c(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(58655);
    paramInputStream = (k)aaZC.j(paramInputStream, paramg);
    AppMethodBeat.o(58655);
    return paramInputStream;
  }
  
  private void iIN()
  {
    AppMethodBeat.i(58651);
    this.abas = Collections.emptyList();
    this.abat = Collections.emptyList();
    this.abau = Collections.emptyList();
    this.abay = a.s.iMb();
    this.abaA = a.v.iMx();
    AppMethodBeat.o(58651);
  }
  
  public static k iKD()
  {
    return abbE;
  }
  
  public final int Ad()
  {
    int n = 0;
    AppMethodBeat.i(58654);
    int i = this.bXW;
    if (i != -1)
    {
      AppMethodBeat.o(58654);
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.abas.size())
    {
      i += f.c(3, (r)this.abas.get(j));
      j += 1;
    }
    int k = 0;
    int m;
    for (;;)
    {
      m = n;
      j = i;
      if (k >= this.abat.size()) {
        break;
      }
      i += f.c(4, (r)this.abat.get(k));
      k += 1;
    }
    while (m < this.abau.size())
    {
      j += f.c(5, (r)this.abau.get(m));
      m += 1;
    }
    i = j;
    if ((this.bQS & 0x1) == 1) {
      i = j + f.c(30, this.abay);
    }
    j = i;
    if ((this.bQS & 0x2) == 2) {
      j = i + f.c(32, this.abaA);
    }
    i = Ii() + j + this.aaZB.size();
    this.bXW = i;
    AppMethodBeat.o(58654);
    return i;
  }
  
  public final void a(f paramf)
  {
    int k = 0;
    AppMethodBeat.i(58653);
    Ad();
    i.c.a locala = iNU();
    int i = 0;
    while (i < this.abas.size())
    {
      paramf.a(3, (r)this.abas.get(i));
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.abat.size()) {
        break;
      }
      paramf.a(4, (r)this.abat.get(i));
      i += 1;
    }
    while (j < this.abau.size())
    {
      paramf.a(5, (r)this.abau.get(j));
      j += 1;
    }
    if ((this.bQS & 0x1) == 1) {
      paramf.a(30, this.abay);
    }
    if ((this.bQS & 0x2) == 2) {
      paramf.a(32, this.abaA);
    }
    locala.b(200, paramf);
    paramf.e(this.aaZB);
    AppMethodBeat.o(58653);
  }
  
  public final boolean iJv()
  {
    return (this.bQS & 0x1) == 1;
  }
  
  public final boolean iJw()
  {
    return (this.bQS & 0x2) == 2;
  }
  
  public final a iKE()
  {
    AppMethodBeat.i(58657);
    a locala = a.iKH().f(this);
    AppMethodBeat.o(58657);
    return locala;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58652);
    int i = this.bRd;
    if (i == 1)
    {
      AppMethodBeat.o(58652);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58652);
      return false;
    }
    i = 0;
    while (i < this.abas.size())
    {
      if (!((a.h)this.abas.get(i)).isInitialized())
      {
        this.bRd = 0;
        AppMethodBeat.o(58652);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.abat.size())
    {
      if (!((a.m)this.abat.get(i)).isInitialized())
      {
        this.bRd = 0;
        AppMethodBeat.o(58652);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.abau.size())
    {
      if (!((a.q)this.abau.get(i)).isInitialized())
      {
        this.bRd = 0;
        AppMethodBeat.o(58652);
        return false;
      }
      i += 1;
    }
    if ((iJv()) && (!this.abay.isInitialized()))
    {
      this.bRd = 0;
      AppMethodBeat.o(58652);
      return false;
    }
    if (!Ig())
    {
      this.bRd = 0;
      AppMethodBeat.o(58652);
      return false;
    }
    this.bRd = 1;
    AppMethodBeat.o(58652);
    return true;
  }
  
  public static final class a
    extends i.b<a.k, a>
    implements m
  {
    private a.v abaA;
    private List<a.h> abas;
    private List<a.m> abat;
    private List<a.q> abau;
    private a.s abay;
    private int bQS;
    
    private a()
    {
      AppMethodBeat.i(58628);
      this.abas = Collections.emptyList();
      this.abat = Collections.emptyList();
      this.abau = Collections.emptyList();
      this.abay = a.s.iMb();
      this.abaA = a.v.iMx();
      AppMethodBeat.o(58628);
    }
    
    private a b(a.v paramv)
    {
      AppMethodBeat.i(58638);
      if (((this.bQS & 0x10) == 16) && (this.abaA != a.v.iMx())) {}
      for (this.abaA = a.v.c(this.abaA).f(paramv).iMz();; this.abaA = paramv)
      {
        this.bQS |= 0x10;
        AppMethodBeat.o(58638);
        return this;
      }
    }
    
    private a c(a.s params)
    {
      AppMethodBeat.i(58637);
      if (((this.bQS & 0x8) == 8) && (this.abay != a.s.iMb())) {}
      for (this.abay = a.s.d(this.abay).g(params).iMe();; this.abay = params)
      {
        this.bQS |= 0x8;
        AppMethodBeat.o(58637);
        return this;
      }
    }
    
    private void iJE()
    {
      AppMethodBeat.i(58634);
      if ((this.bQS & 0x1) != 1)
      {
        this.abas = new ArrayList(this.abas);
        this.bQS |= 0x1;
      }
      AppMethodBeat.o(58634);
    }
    
    private void iJF()
    {
      AppMethodBeat.i(58635);
      if ((this.bQS & 0x2) != 2)
      {
        this.abat = new ArrayList(this.abat);
        this.bQS |= 0x2;
      }
      AppMethodBeat.o(58635);
    }
    
    private void iJG()
    {
      AppMethodBeat.i(58636);
      if ((this.bQS & 0x4) != 4)
      {
        this.abau = new ArrayList(this.abau);
        this.bQS |= 0x4;
      }
      AppMethodBeat.o(58636);
    }
    
    private a iKF()
    {
      AppMethodBeat.i(58629);
      a locala = new a().f(iKG());
      AppMethodBeat.o(58629);
      return locala;
    }
    
    /* Error */
    private a n(kotlin.l.b.a.b.h.e parame, g paramg)
    {
      // Byte code:
      //   0: ldc 129
      //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 133	kotlin/l/b/a/b/e/a$k:aaZC	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 138 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$k
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 122	kotlin/l/b/a/b/e/a$k$a:f	(Lkotlin/l/b/a/b/e/a$k;)Lkotlin/l/b/a/b/e/a$k$a;
      //   26: pop
      //   27: ldc 129
      //   29: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 142	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
      //   39: checkcast 9	kotlin/l/b/a/b/e/a$k
      //   42: astore_2
      //   43: ldc 129
      //   45: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 122	kotlin/l/b/a/b/e/a$k$a:f	(Lkotlin/l/b/a/b/e/a$k;)Lkotlin/l/b/a/b/e/a$k$a;
      //   60: pop
      //   61: ldc 129
      //   63: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   0	74	2	paramg	g
      //   6	64	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	kotlin/l/b/a/b/h/l
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a f(a.k paramk)
    {
      AppMethodBeat.i(58631);
      if (paramk == a.k.iKD())
      {
        AppMethodBeat.o(58631);
        return this;
      }
      if (!a.k.b(paramk).isEmpty())
      {
        if (this.abas.isEmpty())
        {
          this.abas = a.k.b(paramk);
          this.bQS &= 0xFFFFFFFE;
        }
      }
      else
      {
        if (!a.k.c(paramk).isEmpty())
        {
          if (!this.abat.isEmpty()) {
            break label228;
          }
          this.abat = a.k.c(paramk);
          this.bQS &= 0xFFFFFFFD;
        }
        label105:
        if (!a.k.d(paramk).isEmpty())
        {
          if (!this.abau.isEmpty()) {
            break label249;
          }
          this.abau = a.k.d(paramk);
          this.bQS &= 0xFFFFFFFB;
        }
      }
      for (;;)
      {
        if (paramk.iJv()) {
          c(paramk.abay);
        }
        if (paramk.iJw()) {
          b(paramk.abaA);
        }
        a(paramk);
        this.aaZB = this.aaZB.a(a.k.e(paramk));
        AppMethodBeat.o(58631);
        return this;
        iJE();
        this.abas.addAll(a.k.b(paramk));
        break;
        label228:
        iJF();
        this.abat.addAll(a.k.c(paramk));
        break label105;
        label249:
        iJG();
        this.abau.addAll(a.k.d(paramk));
      }
    }
    
    public final a.k iKG()
    {
      int i = 1;
      AppMethodBeat.i(58630);
      a.k localk = new a.k(this, (byte)0);
      int k = this.bQS;
      if ((this.bQS & 0x1) == 1)
      {
        this.abas = Collections.unmodifiableList(this.abas);
        this.bQS &= 0xFFFFFFFE;
      }
      a.k.a(localk, this.abas);
      if ((this.bQS & 0x2) == 2)
      {
        this.abat = Collections.unmodifiableList(this.abat);
        this.bQS &= 0xFFFFFFFD;
      }
      a.k.b(localk, this.abat);
      if ((this.bQS & 0x4) == 4)
      {
        this.abau = Collections.unmodifiableList(this.abau);
        this.bQS &= 0xFFFFFFFB;
      }
      a.k.c(localk, this.abau);
      if ((k & 0x8) == 8) {}
      for (;;)
      {
        a.k.a(localk, this.abay);
        int j = i;
        if ((k & 0x10) == 16) {
          j = i | 0x2;
        }
        a.k.a(localk, this.abaA);
        a.k.a(localk, j);
        AppMethodBeat.o(58630);
        return localk;
        i = 0;
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58632);
      int i = 0;
      while (i < this.abas.size())
      {
        if (!((a.h)this.abas.get(i)).isInitialized())
        {
          AppMethodBeat.o(58632);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.abat.size())
      {
        if (!((a.m)this.abat.get(i)).isInitialized())
        {
          AppMethodBeat.o(58632);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.abau.size())
      {
        if (!((a.q)this.abau.get(i)).isInitialized())
        {
          AppMethodBeat.o(58632);
          return false;
        }
        i += 1;
      }
      if ((this.bQS & 0x8) == 8) {}
      for (i = 1; (i != 0) && (!this.abay.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58632);
        return false;
      }
      if (!Ig())
      {
        AppMethodBeat.o(58632);
        return false;
      }
      AppMethodBeat.o(58632);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.k
 * JD-Core Version:    0.7.0.1
 */