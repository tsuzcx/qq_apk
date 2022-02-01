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
import kotlin.l.b.a.b.h.h;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.i.b;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.c.a;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.h.s;

public final class a$k
  extends i.c<k>
  implements m
{
  public static s<k> TwL;
  private static final k TyN;
  private final d TwK;
  public List<a.h> TxB;
  public List<a.m> TxC;
  public List<a.q> TxD;
  public a.s TxH;
  public a.v TxJ;
  private int bOT;
  private byte bPe = -1;
  private int bVY = -1;
  
  static
  {
    AppMethodBeat.i(58660);
    TwL = new b() {};
    k localk = new k();
    TyN = localk;
    localk.hEu();
    AppMethodBeat.o(58660);
  }
  
  private a$k()
  {
    this.TwK = d.TDp;
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
    //   11: putfield 65	kotlin/l/b/a/b/e/a$k:bPe	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 67	kotlin/l/b/a/b/e/a$k:bVY	I
    //   19: aload_0
    //   20: invokespecial 58	kotlin/l/b/a/b/e/a$k:hEu	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 84	kotlin/l/b/a/b/h/d:hJo	()Lkotlin/l/b/a/b/h/d$b;
    //   28: astore 10
    //   30: aload 10
    //   32: iconst_1
    //   33: invokestatic 90	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   36: astore 11
    //   38: iconst_0
    //   39: istore 8
    //   41: iload 8
    //   43: ifne +720 -> 763
    //   46: iload_3
    //   47: istore 5
    //   49: iload_3
    //   50: istore 4
    //   52: iload_3
    //   53: istore 6
    //   55: aload_1
    //   56: invokevirtual 96	kotlin/l/b/a/b/h/e:yT	()I
    //   59: istore 7
    //   61: iload 7
    //   63: lookupswitch	default:+853->916, 0:+856->919, 26:+85->148, 34:+267->330, 42:+379->442, 242:+450->513, 258:+575->638
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
    //   175: putfield 104	kotlin/l/b/a/b/e/a$k:TxB	Ljava/util/List;
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
    //   196: getfield 104	kotlin/l/b/a/b/e/a$k:TxB	Ljava/util/List;
    //   199: aload_1
    //   200: getstatic 107	kotlin/l/b/a/b/e/a$h:TwL	Lkotlin/l/b/a/b/h/s;
    //   203: aload_2
    //   204: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
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
    //   226: putfield 120	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
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
    //   255: getfield 104	kotlin/l/b/a/b/e/a$k:TxB	Ljava/util/List;
    //   258: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   261: putfield 104	kotlin/l/b/a/b/e/a$k:TxB	Ljava/util/List;
    //   264: iload 4
    //   266: iconst_2
    //   267: iand
    //   268: iconst_2
    //   269: if_icmpne +14 -> 283
    //   272: aload_0
    //   273: aload_0
    //   274: getfield 128	kotlin/l/b/a/b/e/a$k:TxC	Ljava/util/List;
    //   277: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   280: putfield 128	kotlin/l/b/a/b/e/a$k:TxC	Ljava/util/List;
    //   283: iload 4
    //   285: iconst_4
    //   286: iand
    //   287: iconst_4
    //   288: if_icmpne +14 -> 302
    //   291: aload_0
    //   292: aload_0
    //   293: getfield 130	kotlin/l/b/a/b/e/a$k:TxD	Ljava/util/List;
    //   296: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   299: putfield 130	kotlin/l/b/a/b/e/a$k:TxD	Ljava/util/List;
    //   302: aload 11
    //   304: invokevirtual 133	kotlin/l/b/a/b/h/f:flush	()V
    //   307: aload_0
    //   308: aload 10
    //   310: invokevirtual 139	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   313: putfield 74	kotlin/l/b/a/b/e/a$k:TwK	Lkotlin/l/b/a/b/h/d;
    //   316: aload_0
    //   317: getfield 143	kotlin/l/b/a/b/h/i$c:TDA	Lkotlin/l/b/a/b/h/h;
    //   320: invokevirtual 148	kotlin/l/b/a/b/h/h:yK	()V
    //   323: ldc 80
    //   325: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: aload_1
    //   329: athrow
    //   330: iload_3
    //   331: istore 7
    //   333: iload_3
    //   334: iconst_2
    //   335: iand
    //   336: iconst_2
    //   337: if_icmpeq +28 -> 365
    //   340: iload_3
    //   341: istore 5
    //   343: iload_3
    //   344: istore 4
    //   346: iload_3
    //   347: istore 6
    //   349: aload_0
    //   350: new 101	java/util/ArrayList
    //   353: dup
    //   354: invokespecial 102	java/util/ArrayList:<init>	()V
    //   357: putfield 128	kotlin/l/b/a/b/e/a$k:TxC	Ljava/util/List;
    //   360: iload_3
    //   361: iconst_2
    //   362: ior
    //   363: istore 7
    //   365: iload 7
    //   367: istore 5
    //   369: iload 7
    //   371: istore 4
    //   373: iload 7
    //   375: istore 6
    //   377: aload_0
    //   378: getfield 128	kotlin/l/b/a/b/e/a$k:TxC	Ljava/util/List;
    //   381: aload_1
    //   382: getstatic 151	kotlin/l/b/a/b/e/a$m:TwL	Lkotlin/l/b/a/b/h/s;
    //   385: aload_2
    //   386: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   389: invokeinterface 116 2 0
    //   394: pop
    //   395: iload 7
    //   397: istore_3
    //   398: goto -357 -> 41
    //   401: astore_1
    //   402: iload 6
    //   404: istore 4
    //   406: new 77	kotlin/l/b/a/b/h/k
    //   409: dup
    //   410: aload_1
    //   411: invokevirtual 155	java/io/IOException:getMessage	()Ljava/lang/String;
    //   414: invokespecial 158	kotlin/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   417: astore_1
    //   418: iload 6
    //   420: istore 4
    //   422: aload_1
    //   423: aload_0
    //   424: putfield 120	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   427: iload 6
    //   429: istore 4
    //   431: ldc 80
    //   433: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   436: iload 6
    //   438: istore 4
    //   440: aload_1
    //   441: athrow
    //   442: iload_3
    //   443: istore 7
    //   445: iload_3
    //   446: iconst_4
    //   447: iand
    //   448: iconst_4
    //   449: if_icmpeq +28 -> 477
    //   452: iload_3
    //   453: istore 5
    //   455: iload_3
    //   456: istore 4
    //   458: iload_3
    //   459: istore 6
    //   461: aload_0
    //   462: new 101	java/util/ArrayList
    //   465: dup
    //   466: invokespecial 102	java/util/ArrayList:<init>	()V
    //   469: putfield 130	kotlin/l/b/a/b/e/a$k:TxD	Ljava/util/List;
    //   472: iload_3
    //   473: iconst_4
    //   474: ior
    //   475: istore 7
    //   477: iload 7
    //   479: istore 5
    //   481: iload 7
    //   483: istore 4
    //   485: iload 7
    //   487: istore 6
    //   489: aload_0
    //   490: getfield 130	kotlin/l/b/a/b/e/a$k:TxD	Ljava/util/List;
    //   493: aload_1
    //   494: getstatic 161	kotlin/l/b/a/b/e/a$q:TwL	Lkotlin/l/b/a/b/h/s;
    //   497: aload_2
    //   498: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   501: invokeinterface 116 2 0
    //   506: pop
    //   507: iload 7
    //   509: istore_3
    //   510: goto -469 -> 41
    //   513: iload_3
    //   514: istore 5
    //   516: iload_3
    //   517: istore 4
    //   519: iload_3
    //   520: istore 6
    //   522: aload_0
    //   523: getfield 163	kotlin/l/b/a/b/e/a$k:bOT	I
    //   526: iconst_1
    //   527: iand
    //   528: iconst_1
    //   529: if_icmpne +381 -> 910
    //   532: iload_3
    //   533: istore 5
    //   535: iload_3
    //   536: istore 4
    //   538: iload_3
    //   539: istore 6
    //   541: aload_0
    //   542: getfield 165	kotlin/l/b/a/b/e/a$k:TxH	Lkotlin/l/b/a/b/e/a$s;
    //   545: invokestatic 171	kotlin/l/b/a/b/e/a$s:d	(Lkotlin/l/b/a/b/e/a$s;)Lkotlin/l/b/a/b/e/a$s$a;
    //   548: astore 9
    //   550: iload_3
    //   551: istore 5
    //   553: iload_3
    //   554: istore 4
    //   556: iload_3
    //   557: istore 6
    //   559: aload_0
    //   560: aload_1
    //   561: getstatic 172	kotlin/l/b/a/b/e/a$s:TwL	Lkotlin/l/b/a/b/h/s;
    //   564: aload_2
    //   565: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   568: checkcast 167	kotlin/l/b/a/b/e/a$s
    //   571: putfield 165	kotlin/l/b/a/b/e/a$k:TxH	Lkotlin/l/b/a/b/e/a$s;
    //   574: aload 9
    //   576: ifnull +40 -> 616
    //   579: iload_3
    //   580: istore 5
    //   582: iload_3
    //   583: istore 4
    //   585: iload_3
    //   586: istore 6
    //   588: aload 9
    //   590: aload_0
    //   591: getfield 165	kotlin/l/b/a/b/e/a$k:TxH	Lkotlin/l/b/a/b/e/a$s;
    //   594: invokevirtual 177	kotlin/l/b/a/b/e/a$s$a:g	(Lkotlin/l/b/a/b/e/a$s;)Lkotlin/l/b/a/b/e/a$s$a;
    //   597: pop
    //   598: iload_3
    //   599: istore 5
    //   601: iload_3
    //   602: istore 4
    //   604: iload_3
    //   605: istore 6
    //   607: aload_0
    //   608: aload 9
    //   610: invokevirtual 181	kotlin/l/b/a/b/e/a$s$a:hHK	()Lkotlin/l/b/a/b/e/a$s;
    //   613: putfield 165	kotlin/l/b/a/b/e/a$k:TxH	Lkotlin/l/b/a/b/e/a$s;
    //   616: iload_3
    //   617: istore 5
    //   619: iload_3
    //   620: istore 4
    //   622: iload_3
    //   623: istore 6
    //   625: aload_0
    //   626: aload_0
    //   627: getfield 163	kotlin/l/b/a/b/e/a$k:bOT	I
    //   630: iconst_1
    //   631: ior
    //   632: putfield 163	kotlin/l/b/a/b/e/a$k:bOT	I
    //   635: goto -594 -> 41
    //   638: iload_3
    //   639: istore 5
    //   641: iload_3
    //   642: istore 4
    //   644: iload_3
    //   645: istore 6
    //   647: aload_0
    //   648: getfield 163	kotlin/l/b/a/b/e/a$k:bOT	I
    //   651: iconst_2
    //   652: iand
    //   653: iconst_2
    //   654: if_icmpne +250 -> 904
    //   657: iload_3
    //   658: istore 5
    //   660: iload_3
    //   661: istore 4
    //   663: iload_3
    //   664: istore 6
    //   666: aload_0
    //   667: getfield 183	kotlin/l/b/a/b/e/a$k:TxJ	Lkotlin/l/b/a/b/e/a$v;
    //   670: invokestatic 189	kotlin/l/b/a/b/e/a$v:c	(Lkotlin/l/b/a/b/e/a$v;)Lkotlin/l/b/a/b/e/a$v$a;
    //   673: astore 9
    //   675: iload_3
    //   676: istore 5
    //   678: iload_3
    //   679: istore 4
    //   681: iload_3
    //   682: istore 6
    //   684: aload_0
    //   685: aload_1
    //   686: getstatic 190	kotlin/l/b/a/b/e/a$v:TwL	Lkotlin/l/b/a/b/h/s;
    //   689: aload_2
    //   690: invokevirtual 110	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   693: checkcast 185	kotlin/l/b/a/b/e/a$v
    //   696: putfield 183	kotlin/l/b/a/b/e/a$k:TxJ	Lkotlin/l/b/a/b/e/a$v;
    //   699: aload 9
    //   701: ifnull +40 -> 741
    //   704: iload_3
    //   705: istore 5
    //   707: iload_3
    //   708: istore 4
    //   710: iload_3
    //   711: istore 6
    //   713: aload 9
    //   715: aload_0
    //   716: getfield 183	kotlin/l/b/a/b/e/a$k:TxJ	Lkotlin/l/b/a/b/e/a$v;
    //   719: invokevirtual 194	kotlin/l/b/a/b/e/a$v$a:f	(Lkotlin/l/b/a/b/e/a$v;)Lkotlin/l/b/a/b/e/a$v$a;
    //   722: pop
    //   723: iload_3
    //   724: istore 5
    //   726: iload_3
    //   727: istore 4
    //   729: iload_3
    //   730: istore 6
    //   732: aload_0
    //   733: aload 9
    //   735: invokevirtual 198	kotlin/l/b/a/b/e/a$v$a:hIf	()Lkotlin/l/b/a/b/e/a$v;
    //   738: putfield 183	kotlin/l/b/a/b/e/a$k:TxJ	Lkotlin/l/b/a/b/e/a$v;
    //   741: iload_3
    //   742: istore 5
    //   744: iload_3
    //   745: istore 4
    //   747: iload_3
    //   748: istore 6
    //   750: aload_0
    //   751: aload_0
    //   752: getfield 163	kotlin/l/b/a/b/e/a$k:bOT	I
    //   755: iconst_2
    //   756: ior
    //   757: putfield 163	kotlin/l/b/a/b/e/a$k:bOT	I
    //   760: goto -719 -> 41
    //   763: iload_3
    //   764: iconst_1
    //   765: iand
    //   766: iconst_1
    //   767: if_icmpne +14 -> 781
    //   770: aload_0
    //   771: aload_0
    //   772: getfield 104	kotlin/l/b/a/b/e/a$k:TxB	Ljava/util/List;
    //   775: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   778: putfield 104	kotlin/l/b/a/b/e/a$k:TxB	Ljava/util/List;
    //   781: iload_3
    //   782: iconst_2
    //   783: iand
    //   784: iconst_2
    //   785: if_icmpne +14 -> 799
    //   788: aload_0
    //   789: aload_0
    //   790: getfield 128	kotlin/l/b/a/b/e/a$k:TxC	Ljava/util/List;
    //   793: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   796: putfield 128	kotlin/l/b/a/b/e/a$k:TxC	Ljava/util/List;
    //   799: iload_3
    //   800: iconst_4
    //   801: iand
    //   802: iconst_4
    //   803: if_icmpne +14 -> 817
    //   806: aload_0
    //   807: aload_0
    //   808: getfield 130	kotlin/l/b/a/b/e/a$k:TxD	Ljava/util/List;
    //   811: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   814: putfield 130	kotlin/l/b/a/b/e/a$k:TxD	Ljava/util/List;
    //   817: aload 11
    //   819: invokevirtual 133	kotlin/l/b/a/b/h/f:flush	()V
    //   822: aload_0
    //   823: aload 10
    //   825: invokevirtual 139	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   828: putfield 74	kotlin/l/b/a/b/e/a$k:TwK	Lkotlin/l/b/a/b/h/d;
    //   831: aload_0
    //   832: getfield 143	kotlin/l/b/a/b/h/i$c:TDA	Lkotlin/l/b/a/b/h/h;
    //   835: invokevirtual 148	kotlin/l/b/a/b/h/h:yK	()V
    //   838: ldc 80
    //   840: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   843: return
    //   844: astore_1
    //   845: aload_0
    //   846: aload 10
    //   848: invokevirtual 139	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   851: putfield 74	kotlin/l/b/a/b/e/a$k:TwK	Lkotlin/l/b/a/b/h/d;
    //   854: goto -23 -> 831
    //   857: astore_1
    //   858: aload_0
    //   859: aload 10
    //   861: invokevirtual 139	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   864: putfield 74	kotlin/l/b/a/b/e/a$k:TwK	Lkotlin/l/b/a/b/h/d;
    //   867: ldc 80
    //   869: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   872: aload_1
    //   873: athrow
    //   874: astore_2
    //   875: aload_0
    //   876: aload 10
    //   878: invokevirtual 139	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   881: putfield 74	kotlin/l/b/a/b/e/a$k:TwK	Lkotlin/l/b/a/b/h/d;
    //   884: goto -568 -> 316
    //   887: astore_1
    //   888: aload_0
    //   889: aload 10
    //   891: invokevirtual 139	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   894: putfield 74	kotlin/l/b/a/b/e/a$k:TwK	Lkotlin/l/b/a/b/h/d;
    //   897: ldc 80
    //   899: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   902: aload_1
    //   903: athrow
    //   904: aconst_null
    //   905: astore 9
    //   907: goto -232 -> 675
    //   910: aconst_null
    //   911: astore 9
    //   913: goto -363 -> 550
    //   916: goto -796 -> 120
    //   919: iconst_1
    //   920: istore 8
    //   922: goto -881 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	925	0	this	k
    //   0	925	1	parame	kotlin.l.b.a.b.h.e
    //   0	925	2	paramg	g
    //   24	778	3	i	int
    //   50	696	4	j	int
    //   47	696	5	k	int
    //   53	696	6	m	int
    //   59	449	7	n	int
    //   39	882	8	i1	int
    //   548	364	9	localObject	java.lang.Object
    //   28	862	10	localb	kotlin.l.b.a.b.h.d.b
    //   36	782	11	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	219	kotlin/l/b/a/b/h/k
    //   129	142	219	kotlin/l/b/a/b/h/k
    //   167	178	219	kotlin/l/b/a/b/h/k
    //   195	213	219	kotlin/l/b/a/b/h/k
    //   349	360	219	kotlin/l/b/a/b/h/k
    //   377	395	219	kotlin/l/b/a/b/h/k
    //   461	472	219	kotlin/l/b/a/b/h/k
    //   489	507	219	kotlin/l/b/a/b/h/k
    //   522	532	219	kotlin/l/b/a/b/h/k
    //   541	550	219	kotlin/l/b/a/b/h/k
    //   559	574	219	kotlin/l/b/a/b/h/k
    //   588	598	219	kotlin/l/b/a/b/h/k
    //   607	616	219	kotlin/l/b/a/b/h/k
    //   625	635	219	kotlin/l/b/a/b/h/k
    //   647	657	219	kotlin/l/b/a/b/h/k
    //   666	675	219	kotlin/l/b/a/b/h/k
    //   684	699	219	kotlin/l/b/a/b/h/k
    //   713	723	219	kotlin/l/b/a/b/h/k
    //   732	741	219	kotlin/l/b/a/b/h/k
    //   750	760	219	kotlin/l/b/a/b/h/k
    //   55	61	244	finally
    //   129	142	244	finally
    //   167	178	244	finally
    //   195	213	244	finally
    //   224	229	244	finally
    //   233	238	244	finally
    //   242	244	244	finally
    //   349	360	244	finally
    //   377	395	244	finally
    //   406	418	244	finally
    //   422	427	244	finally
    //   431	436	244	finally
    //   440	442	244	finally
    //   461	472	244	finally
    //   489	507	244	finally
    //   522	532	244	finally
    //   541	550	244	finally
    //   559	574	244	finally
    //   588	598	244	finally
    //   607	616	244	finally
    //   625	635	244	finally
    //   647	657	244	finally
    //   666	675	244	finally
    //   684	699	244	finally
    //   713	723	244	finally
    //   732	741	244	finally
    //   750	760	244	finally
    //   55	61	401	java/io/IOException
    //   129	142	401	java/io/IOException
    //   167	178	401	java/io/IOException
    //   195	213	401	java/io/IOException
    //   349	360	401	java/io/IOException
    //   377	395	401	java/io/IOException
    //   461	472	401	java/io/IOException
    //   489	507	401	java/io/IOException
    //   522	532	401	java/io/IOException
    //   541	550	401	java/io/IOException
    //   559	574	401	java/io/IOException
    //   588	598	401	java/io/IOException
    //   607	616	401	java/io/IOException
    //   625	635	401	java/io/IOException
    //   647	657	401	java/io/IOException
    //   666	675	401	java/io/IOException
    //   684	699	401	java/io/IOException
    //   713	723	401	java/io/IOException
    //   732	741	401	java/io/IOException
    //   750	760	401	java/io/IOException
    //   817	822	844	java/io/IOException
    //   817	822	857	finally
    //   302	307	874	java/io/IOException
    //   302	307	887	finally
  }
  
  private a$k(i.b<k, ?> paramb)
  {
    super(paramb);
    this.TwK = paramb.TwK;
  }
  
  public static a a(k paramk)
  {
    AppMethodBeat.i(58656);
    paramk = a.hGn().f(paramk);
    AppMethodBeat.o(58656);
    return paramk;
  }
  
  public static k c(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(58655);
    paramInputStream = (k)TwL.j(paramInputStream, paramg);
    AppMethodBeat.o(58655);
    return paramInputStream;
  }
  
  private void hEu()
  {
    AppMethodBeat.i(58651);
    this.TxB = Collections.emptyList();
    this.TxC = Collections.emptyList();
    this.TxD = Collections.emptyList();
    this.TxH = a.s.hHH();
    this.TxJ = a.v.hId();
    AppMethodBeat.o(58651);
  }
  
  public static k hGj()
  {
    return TyN;
  }
  
  public final void a(f paramf)
  {
    int k = 0;
    AppMethodBeat.i(58653);
    yC();
    i.c.a locala = hJC();
    int i = 0;
    while (i < this.TxB.size())
    {
      paramf.a(3, (q)this.TxB.get(i));
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.TxC.size()) {
        break;
      }
      paramf.a(4, (q)this.TxC.get(i));
      i += 1;
    }
    while (j < this.TxD.size())
    {
      paramf.a(5, (q)this.TxD.get(j));
      j += 1;
    }
    if ((this.bOT & 0x1) == 1) {
      paramf.a(30, this.TxH);
    }
    if ((this.bOT & 0x2) == 2) {
      paramf.a(32, this.TxJ);
    }
    locala.b(200, paramf);
    paramf.e(this.TwK);
    AppMethodBeat.o(58653);
  }
  
  public final s<k> hEs()
  {
    return TwL;
  }
  
  public final boolean hFb()
  {
    return (this.bOT & 0x1) == 1;
  }
  
  public final boolean hFc()
  {
    return (this.bOT & 0x2) == 2;
  }
  
  public final a hGk()
  {
    AppMethodBeat.i(58657);
    a locala = a.hGn().f(this);
    AppMethodBeat.o(58657);
    return locala;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58652);
    int i = this.bPe;
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
    while (i < this.TxB.size())
    {
      if (!((a.h)this.TxB.get(i)).isInitialized())
      {
        this.bPe = 0;
        AppMethodBeat.o(58652);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.TxC.size())
    {
      if (!((a.m)this.TxC.get(i)).isInitialized())
      {
        this.bPe = 0;
        AppMethodBeat.o(58652);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.TxD.size())
    {
      if (!((a.q)this.TxD.get(i)).isInitialized())
      {
        this.bPe = 0;
        AppMethodBeat.o(58652);
        return false;
      }
      i += 1;
    }
    if ((hFb()) && (!this.TxH.isInitialized()))
    {
      this.bPe = 0;
      AppMethodBeat.o(58652);
      return false;
    }
    if (!this.TDA.isInitialized())
    {
      this.bPe = 0;
      AppMethodBeat.o(58652);
      return false;
    }
    this.bPe = 1;
    AppMethodBeat.o(58652);
    return true;
  }
  
  public final int yC()
  {
    int n = 0;
    AppMethodBeat.i(58654);
    int i = this.bVY;
    if (i != -1)
    {
      AppMethodBeat.o(58654);
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.TxB.size())
    {
      i += f.c(3, (q)this.TxB.get(j));
      j += 1;
    }
    int k = 0;
    int m;
    for (;;)
    {
      m = n;
      j = i;
      if (k >= this.TxC.size()) {
        break;
      }
      i += f.c(4, (q)this.TxC.get(k));
      k += 1;
    }
    while (m < this.TxD.size())
    {
      j += f.c(5, (q)this.TxD.get(m));
      m += 1;
    }
    i = j;
    if ((this.bOT & 0x1) == 1) {
      i = j + f.c(30, this.TxH);
    }
    j = i;
    if ((this.bOT & 0x2) == 2) {
      j = i + f.c(32, this.TxJ);
    }
    i = this.TDA.yC() + j + this.TwK.size();
    this.bVY = i;
    AppMethodBeat.o(58654);
    return i;
  }
  
  public static final class a
    extends i.b<a.k, a>
    implements m
  {
    private List<a.h> TxB;
    private List<a.m> TxC;
    private List<a.q> TxD;
    private a.s TxH;
    private a.v TxJ;
    private int bOT;
    
    private a()
    {
      AppMethodBeat.i(58628);
      this.TxB = Collections.emptyList();
      this.TxC = Collections.emptyList();
      this.TxD = Collections.emptyList();
      this.TxH = a.s.hHH();
      this.TxJ = a.v.hId();
      AppMethodBeat.o(58628);
    }
    
    private a b(a.v paramv)
    {
      AppMethodBeat.i(58638);
      if (((this.bOT & 0x10) == 16) && (this.TxJ != a.v.hId())) {}
      for (this.TxJ = a.v.c(this.TxJ).f(paramv).hIf();; this.TxJ = paramv)
      {
        this.bOT |= 0x10;
        AppMethodBeat.o(58638);
        return this;
      }
    }
    
    private a c(a.s params)
    {
      AppMethodBeat.i(58637);
      if (((this.bOT & 0x8) == 8) && (this.TxH != a.s.hHH())) {}
      for (this.TxH = a.s.d(this.TxH).g(params).hHK();; this.TxH = params)
      {
        this.bOT |= 0x8;
        AppMethodBeat.o(58637);
        return this;
      }
    }
    
    private void hFk()
    {
      AppMethodBeat.i(58634);
      if ((this.bOT & 0x1) != 1)
      {
        this.TxB = new ArrayList(this.TxB);
        this.bOT |= 0x1;
      }
      AppMethodBeat.o(58634);
    }
    
    private void hFl()
    {
      AppMethodBeat.i(58635);
      if ((this.bOT & 0x2) != 2)
      {
        this.TxC = new ArrayList(this.TxC);
        this.bOT |= 0x2;
      }
      AppMethodBeat.o(58635);
    }
    
    private void hFm()
    {
      AppMethodBeat.i(58636);
      if ((this.bOT & 0x4) != 4)
      {
        this.TxD = new ArrayList(this.TxD);
        this.bOT |= 0x4;
      }
      AppMethodBeat.o(58636);
    }
    
    private a hGl()
    {
      AppMethodBeat.i(58629);
      a locala = new a().f(hGm());
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
      //   7: getstatic 133	kotlin/l/b/a/b/e/a$k:TwL	Lkotlin/l/b/a/b/h/s;
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
      //   36: getfield 142	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
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
      //   7	21	34	kotlin/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a f(a.k paramk)
    {
      AppMethodBeat.i(58631);
      if (paramk == a.k.hGj())
      {
        AppMethodBeat.o(58631);
        return this;
      }
      if (!a.k.b(paramk).isEmpty())
      {
        if (this.TxB.isEmpty())
        {
          this.TxB = a.k.b(paramk);
          this.bOT &= 0xFFFFFFFE;
        }
      }
      else
      {
        if (!a.k.c(paramk).isEmpty())
        {
          if (!this.TxC.isEmpty()) {
            break label228;
          }
          this.TxC = a.k.c(paramk);
          this.bOT &= 0xFFFFFFFD;
        }
        label105:
        if (!a.k.d(paramk).isEmpty())
        {
          if (!this.TxD.isEmpty()) {
            break label249;
          }
          this.TxD = a.k.d(paramk);
          this.bOT &= 0xFFFFFFFB;
        }
      }
      for (;;)
      {
        if (paramk.hFb()) {
          c(paramk.TxH);
        }
        if (paramk.hFc()) {
          b(paramk.TxJ);
        }
        a(paramk);
        this.TwK = this.TwK.a(a.k.e(paramk));
        AppMethodBeat.o(58631);
        return this;
        hFk();
        this.TxB.addAll(a.k.b(paramk));
        break;
        label228:
        hFl();
        this.TxC.addAll(a.k.c(paramk));
        break label105;
        label249:
        hFm();
        this.TxD.addAll(a.k.d(paramk));
      }
    }
    
    public final a.k hGm()
    {
      int i = 1;
      AppMethodBeat.i(58630);
      a.k localk = new a.k(this, (byte)0);
      int k = this.bOT;
      if ((this.bOT & 0x1) == 1)
      {
        this.TxB = Collections.unmodifiableList(this.TxB);
        this.bOT &= 0xFFFFFFFE;
      }
      a.k.a(localk, this.TxB);
      if ((this.bOT & 0x2) == 2)
      {
        this.TxC = Collections.unmodifiableList(this.TxC);
        this.bOT &= 0xFFFFFFFD;
      }
      a.k.b(localk, this.TxC);
      if ((this.bOT & 0x4) == 4)
      {
        this.TxD = Collections.unmodifiableList(this.TxD);
        this.bOT &= 0xFFFFFFFB;
      }
      a.k.c(localk, this.TxD);
      if ((k & 0x8) == 8) {}
      for (;;)
      {
        a.k.a(localk, this.TxH);
        int j = i;
        if ((k & 0x10) == 16) {
          j = i | 0x2;
        }
        a.k.a(localk, this.TxJ);
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
      while (i < this.TxB.size())
      {
        if (!((a.h)this.TxB.get(i)).isInitialized())
        {
          AppMethodBeat.o(58632);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.TxC.size())
      {
        if (!((a.m)this.TxC.get(i)).isInitialized())
        {
          AppMethodBeat.o(58632);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.TxD.size())
      {
        if (!((a.q)this.TxD.get(i)).isInitialized())
        {
          AppMethodBeat.o(58632);
          return false;
        }
        i += 1;
      }
      if ((this.bOT & 0x8) == 8) {}
      for (i = 1; (i != 0) && (!this.TxH.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58632);
        return false;
      }
      if (!this.TDA.isInitialized())
      {
        AppMethodBeat.o(58632);
        return false;
      }
      AppMethodBeat.o(58632);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.k
 * JD-Core Version:    0.7.0.1
 */