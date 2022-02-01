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

public final class a$q
  extends i.c<q>
  implements s
{
  public static t<q> aiYa;
  private static final q ajaX;
  private final d aiXZ;
  public List<a.r> aiYJ;
  public int aiYq;
  public int aiZC;
  public List<Integer> aiZa;
  public a.p ajaY;
  public int ajaZ;
  public a.p ajba;
  public int ajbb;
  public List<a.a> ajbc;
  private int bitField0_;
  private int dRJ = -1;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(58897);
    aiYa = new b() {};
    q localq = new q();
    ajaX = localq;
    localq.ktf();
    AppMethodBeat.o(58897);
  }
  
  private a$q()
  {
    this.aiXZ = d.ajeU;
  }
  
  /* Error */
  private a$q(kotlin.l.b.a.b.h.e parame, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 66	kotlin/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 83
    //   6: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 68	kotlin/l/b/a/b/e/a$q:memoizedIsInitialized	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 70	kotlin/l/b/a/b/e/a$q:dRJ	I
    //   19: aload_0
    //   20: invokespecial 61	kotlin/l/b/a/b/e/a$q:ktf	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 87	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
    //   28: astore 10
    //   30: aload 10
    //   32: iconst_1
    //   33: invokestatic 92	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   36: astore 11
    //   38: iconst_0
    //   39: istore 8
    //   41: iload 8
    //   43: ifne +1039 -> 1082
    //   46: iload_3
    //   47: istore 4
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 6
    //   55: aload_1
    //   56: invokevirtual 98	kotlin/l/b/a/b/h/e:aac	()I
    //   59: istore 7
    //   61: iload 7
    //   63: lookupswitch	default:+1194->1257, 0:+1197->1260, 8:+125->188, 16:+274->337, 26:+354->417, 34:+425->488, 40:+550->613, 50:+590->653, 56:+718->781, 66:+758->821, 248:+835->898, 250:+911->974
    //   161: istore 4
    //   163: iload_3
    //   164: istore 5
    //   166: iload_3
    //   167: istore 6
    //   169: aload_0
    //   170: aload_1
    //   171: aload 11
    //   173: aload_2
    //   174: iload 7
    //   176: invokevirtual 101	kotlin/l/b/a/b/e/a$q:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   179: ifne +1075 -> 1254
    //   182: iconst_1
    //   183: istore 8
    //   185: goto -144 -> 41
    //   188: iload_3
    //   189: istore 4
    //   191: iload_3
    //   192: istore 5
    //   194: iload_3
    //   195: istore 6
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   202: iconst_1
    //   203: ior
    //   204: putfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   207: iload_3
    //   208: istore 4
    //   210: iload_3
    //   211: istore 5
    //   213: iload_3
    //   214: istore 6
    //   216: aload_0
    //   217: aload_1
    //   218: invokevirtual 106	kotlin/l/b/a/b/h/e:aar	()I
    //   221: putfield 108	kotlin/l/b/a/b/e/a$q:aiYq	I
    //   224: goto -183 -> 41
    //   227: astore_1
    //   228: iload 4
    //   230: istore_3
    //   231: aload_1
    //   232: aload_0
    //   233: putfield 112	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   236: iload 4
    //   238: istore_3
    //   239: ldc 83
    //   241: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: iload 4
    //   246: istore_3
    //   247: aload_1
    //   248: athrow
    //   249: astore_1
    //   250: iload_3
    //   251: iconst_4
    //   252: iand
    //   253: iconst_4
    //   254: if_icmpne +14 -> 268
    //   257: aload_0
    //   258: aload_0
    //   259: getfield 114	kotlin/l/b/a/b/e/a$q:aiYJ	Ljava/util/List;
    //   262: invokestatic 120	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   265: putfield 114	kotlin/l/b/a/b/e/a$q:aiYJ	Ljava/util/List;
    //   268: iload_3
    //   269: sipush 128
    //   272: iand
    //   273: sipush 128
    //   276: if_icmpne +14 -> 290
    //   279: aload_0
    //   280: aload_0
    //   281: getfield 122	kotlin/l/b/a/b/e/a$q:ajbc	Ljava/util/List;
    //   284: invokestatic 120	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   287: putfield 122	kotlin/l/b/a/b/e/a$q:ajbc	Ljava/util/List;
    //   290: iload_3
    //   291: sipush 256
    //   294: iand
    //   295: sipush 256
    //   298: if_icmpne +14 -> 312
    //   301: aload_0
    //   302: aload_0
    //   303: getfield 124	kotlin/l/b/a/b/e/a$q:aiZa	Ljava/util/List;
    //   306: invokestatic 120	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   309: putfield 124	kotlin/l/b/a/b/e/a$q:aiZa	Ljava/util/List;
    //   312: aload 11
    //   314: invokevirtual 127	kotlin/l/b/a/b/h/f:flush	()V
    //   317: aload_0
    //   318: aload 10
    //   320: invokevirtual 133	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   323: putfield 77	kotlin/l/b/a/b/e/a$q:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   326: aload_0
    //   327: invokevirtual 136	kotlin/l/b/a/b/e/a$q:makeExtensionsImmutable	()V
    //   330: ldc 83
    //   332: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aload_1
    //   336: athrow
    //   337: iload_3
    //   338: istore 4
    //   340: iload_3
    //   341: istore 5
    //   343: iload_3
    //   344: istore 6
    //   346: aload_0
    //   347: aload_0
    //   348: getfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   351: iconst_2
    //   352: ior
    //   353: putfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   356: iload_3
    //   357: istore 4
    //   359: iload_3
    //   360: istore 5
    //   362: iload_3
    //   363: istore 6
    //   365: aload_0
    //   366: aload_1
    //   367: invokevirtual 106	kotlin/l/b/a/b/h/e:aar	()I
    //   370: putfield 138	kotlin/l/b/a/b/e/a$q:aiZC	I
    //   373: goto -332 -> 41
    //   376: astore_1
    //   377: iload 5
    //   379: istore 4
    //   381: iload 4
    //   383: istore_3
    //   384: new 80	kotlin/l/b/a/b/h/l
    //   387: dup
    //   388: aload_1
    //   389: invokevirtual 142	java/io/IOException:getMessage	()Ljava/lang/String;
    //   392: invokespecial 145	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   395: astore_1
    //   396: iload 4
    //   398: istore_3
    //   399: aload_1
    //   400: aload_0
    //   401: putfield 112	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   404: iload 4
    //   406: istore_3
    //   407: ldc 83
    //   409: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: iload 4
    //   414: istore_3
    //   415: aload_1
    //   416: athrow
    //   417: iload_3
    //   418: istore 7
    //   420: iload_3
    //   421: iconst_4
    //   422: iand
    //   423: iconst_4
    //   424: if_icmpeq +28 -> 452
    //   427: iload_3
    //   428: istore 4
    //   430: iload_3
    //   431: istore 5
    //   433: iload_3
    //   434: istore 6
    //   436: aload_0
    //   437: new 147	java/util/ArrayList
    //   440: dup
    //   441: invokespecial 148	java/util/ArrayList:<init>	()V
    //   444: putfield 114	kotlin/l/b/a/b/e/a$q:aiYJ	Ljava/util/List;
    //   447: iload_3
    //   448: iconst_4
    //   449: ior
    //   450: istore 7
    //   452: iload 7
    //   454: istore 4
    //   456: iload 7
    //   458: istore 5
    //   460: iload 7
    //   462: istore 6
    //   464: aload_0
    //   465: getfield 114	kotlin/l/b/a/b/e/a$q:aiYJ	Ljava/util/List;
    //   468: aload_1
    //   469: getstatic 151	kotlin/l/b/a/b/e/a$r:aiYa	Lkotlin/l/b/a/b/h/t;
    //   472: aload_2
    //   473: invokevirtual 154	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   476: invokeinterface 160 2 0
    //   481: pop
    //   482: iload 7
    //   484: istore_3
    //   485: goto -444 -> 41
    //   488: iload_3
    //   489: istore 4
    //   491: iload_3
    //   492: istore 5
    //   494: iload_3
    //   495: istore 6
    //   497: aload_0
    //   498: getfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   501: iconst_4
    //   502: iand
    //   503: iconst_4
    //   504: if_icmpne +744 -> 1248
    //   507: iload_3
    //   508: istore 4
    //   510: iload_3
    //   511: istore 5
    //   513: iload_3
    //   514: istore 6
    //   516: aload_0
    //   517: getfield 162	kotlin/l/b/a/b/e/a$q:ajaY	Lkotlin/l/b/a/b/e/a$p;
    //   520: invokevirtual 168	kotlin/l/b/a/b/e/a$p:kvU	()Lkotlin/l/b/a/b/e/a$p$b;
    //   523: astore 9
    //   525: iload_3
    //   526: istore 4
    //   528: iload_3
    //   529: istore 5
    //   531: iload_3
    //   532: istore 6
    //   534: aload_0
    //   535: aload_1
    //   536: getstatic 169	kotlin/l/b/a/b/e/a$p:aiYa	Lkotlin/l/b/a/b/h/t;
    //   539: aload_2
    //   540: invokevirtual 154	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   543: checkcast 164	kotlin/l/b/a/b/e/a$p
    //   546: putfield 162	kotlin/l/b/a/b/e/a$q:ajaY	Lkotlin/l/b/a/b/e/a$p;
    //   549: aload 9
    //   551: ifnull +40 -> 591
    //   554: iload_3
    //   555: istore 4
    //   557: iload_3
    //   558: istore 5
    //   560: iload_3
    //   561: istore 6
    //   563: aload 9
    //   565: aload_0
    //   566: getfield 162	kotlin/l/b/a/b/e/a$q:ajaY	Lkotlin/l/b/a/b/e/a$p;
    //   569: invokevirtual 175	kotlin/l/b/a/b/e/a$p$b:k	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   572: pop
    //   573: iload_3
    //   574: istore 4
    //   576: iload_3
    //   577: istore 5
    //   579: iload_3
    //   580: istore 6
    //   582: aload_0
    //   583: aload 9
    //   585: invokevirtual 179	kotlin/l/b/a/b/e/a$p$b:kwd	()Lkotlin/l/b/a/b/e/a$p;
    //   588: putfield 162	kotlin/l/b/a/b/e/a$q:ajaY	Lkotlin/l/b/a/b/e/a$p;
    //   591: iload_3
    //   592: istore 4
    //   594: iload_3
    //   595: istore 5
    //   597: iload_3
    //   598: istore 6
    //   600: aload_0
    //   601: aload_0
    //   602: getfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   605: iconst_4
    //   606: ior
    //   607: putfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   610: goto -569 -> 41
    //   613: iload_3
    //   614: istore 4
    //   616: iload_3
    //   617: istore 5
    //   619: iload_3
    //   620: istore 6
    //   622: aload_0
    //   623: aload_0
    //   624: getfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   627: bipush 8
    //   629: ior
    //   630: putfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   633: iload_3
    //   634: istore 4
    //   636: iload_3
    //   637: istore 5
    //   639: iload_3
    //   640: istore 6
    //   642: aload_0
    //   643: aload_1
    //   644: invokevirtual 106	kotlin/l/b/a/b/h/e:aar	()I
    //   647: putfield 181	kotlin/l/b/a/b/e/a$q:ajaZ	I
    //   650: goto -609 -> 41
    //   653: iload_3
    //   654: istore 4
    //   656: iload_3
    //   657: istore 5
    //   659: iload_3
    //   660: istore 6
    //   662: aload_0
    //   663: getfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   666: bipush 16
    //   668: iand
    //   669: bipush 16
    //   671: if_icmpne +571 -> 1242
    //   674: iload_3
    //   675: istore 4
    //   677: iload_3
    //   678: istore 5
    //   680: iload_3
    //   681: istore 6
    //   683: aload_0
    //   684: getfield 183	kotlin/l/b/a/b/e/a$q:ajba	Lkotlin/l/b/a/b/e/a$p;
    //   687: invokevirtual 168	kotlin/l/b/a/b/e/a$p:kvU	()Lkotlin/l/b/a/b/e/a$p$b;
    //   690: astore 9
    //   692: iload_3
    //   693: istore 4
    //   695: iload_3
    //   696: istore 5
    //   698: iload_3
    //   699: istore 6
    //   701: aload_0
    //   702: aload_1
    //   703: getstatic 169	kotlin/l/b/a/b/e/a$p:aiYa	Lkotlin/l/b/a/b/h/t;
    //   706: aload_2
    //   707: invokevirtual 154	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   710: checkcast 164	kotlin/l/b/a/b/e/a$p
    //   713: putfield 183	kotlin/l/b/a/b/e/a$q:ajba	Lkotlin/l/b/a/b/e/a$p;
    //   716: aload 9
    //   718: ifnull +40 -> 758
    //   721: iload_3
    //   722: istore 4
    //   724: iload_3
    //   725: istore 5
    //   727: iload_3
    //   728: istore 6
    //   730: aload 9
    //   732: aload_0
    //   733: getfield 183	kotlin/l/b/a/b/e/a$q:ajba	Lkotlin/l/b/a/b/e/a$p;
    //   736: invokevirtual 175	kotlin/l/b/a/b/e/a$p$b:k	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   739: pop
    //   740: iload_3
    //   741: istore 4
    //   743: iload_3
    //   744: istore 5
    //   746: iload_3
    //   747: istore 6
    //   749: aload_0
    //   750: aload 9
    //   752: invokevirtual 179	kotlin/l/b/a/b/e/a$p$b:kwd	()Lkotlin/l/b/a/b/e/a$p;
    //   755: putfield 183	kotlin/l/b/a/b/e/a$q:ajba	Lkotlin/l/b/a/b/e/a$p;
    //   758: iload_3
    //   759: istore 4
    //   761: iload_3
    //   762: istore 5
    //   764: iload_3
    //   765: istore 6
    //   767: aload_0
    //   768: aload_0
    //   769: getfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   772: bipush 16
    //   774: ior
    //   775: putfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   778: goto -737 -> 41
    //   781: iload_3
    //   782: istore 4
    //   784: iload_3
    //   785: istore 5
    //   787: iload_3
    //   788: istore 6
    //   790: aload_0
    //   791: aload_0
    //   792: getfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   795: bipush 32
    //   797: ior
    //   798: putfield 103	kotlin/l/b/a/b/e/a$q:bitField0_	I
    //   801: iload_3
    //   802: istore 4
    //   804: iload_3
    //   805: istore 5
    //   807: iload_3
    //   808: istore 6
    //   810: aload_0
    //   811: aload_1
    //   812: invokevirtual 106	kotlin/l/b/a/b/h/e:aar	()I
    //   815: putfield 185	kotlin/l/b/a/b/e/a$q:ajbb	I
    //   818: goto -777 -> 41
    //   821: iload_3
    //   822: istore 7
    //   824: iload_3
    //   825: sipush 128
    //   828: iand
    //   829: sipush 128
    //   832: if_icmpeq +30 -> 862
    //   835: iload_3
    //   836: istore 4
    //   838: iload_3
    //   839: istore 5
    //   841: iload_3
    //   842: istore 6
    //   844: aload_0
    //   845: new 147	java/util/ArrayList
    //   848: dup
    //   849: invokespecial 148	java/util/ArrayList:<init>	()V
    //   852: putfield 122	kotlin/l/b/a/b/e/a$q:ajbc	Ljava/util/List;
    //   855: iload_3
    //   856: sipush 128
    //   859: ior
    //   860: istore 7
    //   862: iload 7
    //   864: istore 4
    //   866: iload 7
    //   868: istore 5
    //   870: iload 7
    //   872: istore 6
    //   874: aload_0
    //   875: getfield 122	kotlin/l/b/a/b/e/a$q:ajbc	Ljava/util/List;
    //   878: aload_1
    //   879: getstatic 188	kotlin/l/b/a/b/e/a$a:aiYa	Lkotlin/l/b/a/b/h/t;
    //   882: aload_2
    //   883: invokevirtual 154	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   886: invokeinterface 160 2 0
    //   891: pop
    //   892: iload 7
    //   894: istore_3
    //   895: goto -854 -> 41
    //   898: iload_3
    //   899: istore 7
    //   901: iload_3
    //   902: sipush 256
    //   905: iand
    //   906: sipush 256
    //   909: if_icmpeq +30 -> 939
    //   912: iload_3
    //   913: istore 4
    //   915: iload_3
    //   916: istore 5
    //   918: iload_3
    //   919: istore 6
    //   921: aload_0
    //   922: new 147	java/util/ArrayList
    //   925: dup
    //   926: invokespecial 148	java/util/ArrayList:<init>	()V
    //   929: putfield 124	kotlin/l/b/a/b/e/a$q:aiZa	Ljava/util/List;
    //   932: iload_3
    //   933: sipush 256
    //   936: ior
    //   937: istore 7
    //   939: iload 7
    //   941: istore 4
    //   943: iload 7
    //   945: istore 5
    //   947: iload 7
    //   949: istore 6
    //   951: aload_0
    //   952: getfield 124	kotlin/l/b/a/b/e/a$q:aiZa	Ljava/util/List;
    //   955: aload_1
    //   956: invokevirtual 106	kotlin/l/b/a/b/h/e:aar	()I
    //   959: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   962: invokeinterface 160 2 0
    //   967: pop
    //   968: iload 7
    //   970: istore_3
    //   971: goto -930 -> 41
    //   974: iload_3
    //   975: istore 4
    //   977: iload_3
    //   978: istore 5
    //   980: iload_3
    //   981: istore 6
    //   983: aload_1
    //   984: aload_1
    //   985: invokevirtual 106	kotlin/l/b/a/b/h/e:aar	()I
    //   988: invokevirtual 198	kotlin/l/b/a/b/h/e:jO	(I)I
    //   991: istore 7
    //   993: iload_3
    //   994: sipush 256
    //   997: iand
    //   998: sipush 256
    //   1001: if_icmpeq +238 -> 1239
    //   1004: iload_3
    //   1005: istore 4
    //   1007: iload_3
    //   1008: istore 5
    //   1010: iload_3
    //   1011: istore 6
    //   1013: aload_1
    //   1014: invokevirtual 201	kotlin/l/b/a/b/h/e:aat	()I
    //   1017: ifle +222 -> 1239
    //   1020: iload_3
    //   1021: istore 4
    //   1023: iload_3
    //   1024: istore 5
    //   1026: iload_3
    //   1027: istore 6
    //   1029: aload_0
    //   1030: new 147	java/util/ArrayList
    //   1033: dup
    //   1034: invokespecial 148	java/util/ArrayList:<init>	()V
    //   1037: putfield 124	kotlin/l/b/a/b/e/a$q:aiZa	Ljava/util/List;
    //   1040: iload_3
    //   1041: sipush 256
    //   1044: ior
    //   1045: istore_3
    //   1046: aload_1
    //   1047: invokevirtual 201	kotlin/l/b/a/b/h/e:aat	()I
    //   1050: ifle +23 -> 1073
    //   1053: aload_0
    //   1054: getfield 124	kotlin/l/b/a/b/e/a$q:aiZa	Ljava/util/List;
    //   1057: aload_1
    //   1058: invokevirtual 106	kotlin/l/b/a/b/h/e:aar	()I
    //   1061: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1064: invokeinterface 160 2 0
    //   1069: pop
    //   1070: goto -24 -> 1046
    //   1073: aload_1
    //   1074: iload 7
    //   1076: invokevirtual 204	kotlin/l/b/a/b/h/e:jP	(I)V
    //   1079: goto -1038 -> 41
    //   1082: iload_3
    //   1083: iconst_4
    //   1084: iand
    //   1085: iconst_4
    //   1086: if_icmpne +14 -> 1100
    //   1089: aload_0
    //   1090: aload_0
    //   1091: getfield 114	kotlin/l/b/a/b/e/a$q:aiYJ	Ljava/util/List;
    //   1094: invokestatic 120	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1097: putfield 114	kotlin/l/b/a/b/e/a$q:aiYJ	Ljava/util/List;
    //   1100: iload_3
    //   1101: sipush 128
    //   1104: iand
    //   1105: sipush 128
    //   1108: if_icmpne +14 -> 1122
    //   1111: aload_0
    //   1112: aload_0
    //   1113: getfield 122	kotlin/l/b/a/b/e/a$q:ajbc	Ljava/util/List;
    //   1116: invokestatic 120	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1119: putfield 122	kotlin/l/b/a/b/e/a$q:ajbc	Ljava/util/List;
    //   1122: iload_3
    //   1123: sipush 256
    //   1126: iand
    //   1127: sipush 256
    //   1130: if_icmpne +14 -> 1144
    //   1133: aload_0
    //   1134: aload_0
    //   1135: getfield 124	kotlin/l/b/a/b/e/a$q:aiZa	Ljava/util/List;
    //   1138: invokestatic 120	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1141: putfield 124	kotlin/l/b/a/b/e/a$q:aiZa	Ljava/util/List;
    //   1144: aload 11
    //   1146: invokevirtual 127	kotlin/l/b/a/b/h/f:flush	()V
    //   1149: aload_0
    //   1150: aload 10
    //   1152: invokevirtual 133	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   1155: putfield 77	kotlin/l/b/a/b/e/a$q:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   1158: aload_0
    //   1159: invokevirtual 136	kotlin/l/b/a/b/e/a$q:makeExtensionsImmutable	()V
    //   1162: ldc 83
    //   1164: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1167: return
    //   1168: astore_1
    //   1169: aload_0
    //   1170: aload 10
    //   1172: invokevirtual 133	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   1175: putfield 77	kotlin/l/b/a/b/e/a$q:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   1178: goto -20 -> 1158
    //   1181: astore_1
    //   1182: aload_0
    //   1183: aload 10
    //   1185: invokevirtual 133	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   1188: putfield 77	kotlin/l/b/a/b/e/a$q:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   1191: ldc 83
    //   1193: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1196: aload_1
    //   1197: athrow
    //   1198: astore_2
    //   1199: aload_0
    //   1200: aload 10
    //   1202: invokevirtual 133	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   1205: putfield 77	kotlin/l/b/a/b/e/a$q:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   1208: goto -882 -> 326
    //   1211: astore_1
    //   1212: aload_0
    //   1213: aload 10
    //   1215: invokevirtual 133	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   1218: putfield 77	kotlin/l/b/a/b/e/a$q:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   1221: ldc 83
    //   1223: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1226: aload_1
    //   1227: athrow
    //   1228: astore_1
    //   1229: goto -979 -> 250
    //   1232: astore_1
    //   1233: iload_3
    //   1234: istore 4
    //   1236: goto -855 -> 381
    //   1239: goto -193 -> 1046
    //   1242: aconst_null
    //   1243: astore 9
    //   1245: goto -553 -> 692
    //   1248: aconst_null
    //   1249: astore 9
    //   1251: goto -726 -> 525
    //   1254: goto -175 -> 1079
    //   1257: goto -1097 -> 160
    //   1260: iconst_1
    //   1261: istore 8
    //   1263: goto -1222 -> 41
    //   1266: astore_1
    //   1267: iload 6
    //   1269: istore_3
    //   1270: goto -1020 -> 250
    //   1273: astore_1
    //   1274: iload_3
    //   1275: istore 4
    //   1277: goto -1049 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1280	0	this	q
    //   0	1280	1	parame	kotlin.l.b.a.b.h.e
    //   0	1280	2	paramg	g
    //   24	1251	3	i	int
    //   47	1229	4	j	int
    //   50	975	5	k	int
    //   53	1215	6	m	int
    //   59	1016	7	n	int
    //   39	1223	8	i1	int
    //   523	727	9	localb	a.p.b
    //   28	1186	10	localb1	kotlin.l.b.a.b.h.d.b
    //   36	1109	11	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	227	kotlin/l/b/a/b/h/l
    //   169	182	227	kotlin/l/b/a/b/h/l
    //   197	207	227	kotlin/l/b/a/b/h/l
    //   216	224	227	kotlin/l/b/a/b/h/l
    //   346	356	227	kotlin/l/b/a/b/h/l
    //   365	373	227	kotlin/l/b/a/b/h/l
    //   436	447	227	kotlin/l/b/a/b/h/l
    //   464	482	227	kotlin/l/b/a/b/h/l
    //   497	507	227	kotlin/l/b/a/b/h/l
    //   516	525	227	kotlin/l/b/a/b/h/l
    //   534	549	227	kotlin/l/b/a/b/h/l
    //   563	573	227	kotlin/l/b/a/b/h/l
    //   582	591	227	kotlin/l/b/a/b/h/l
    //   600	610	227	kotlin/l/b/a/b/h/l
    //   622	633	227	kotlin/l/b/a/b/h/l
    //   642	650	227	kotlin/l/b/a/b/h/l
    //   662	674	227	kotlin/l/b/a/b/h/l
    //   683	692	227	kotlin/l/b/a/b/h/l
    //   701	716	227	kotlin/l/b/a/b/h/l
    //   730	740	227	kotlin/l/b/a/b/h/l
    //   749	758	227	kotlin/l/b/a/b/h/l
    //   767	778	227	kotlin/l/b/a/b/h/l
    //   790	801	227	kotlin/l/b/a/b/h/l
    //   810	818	227	kotlin/l/b/a/b/h/l
    //   844	855	227	kotlin/l/b/a/b/h/l
    //   874	892	227	kotlin/l/b/a/b/h/l
    //   921	932	227	kotlin/l/b/a/b/h/l
    //   951	968	227	kotlin/l/b/a/b/h/l
    //   983	993	227	kotlin/l/b/a/b/h/l
    //   1013	1020	227	kotlin/l/b/a/b/h/l
    //   1029	1040	227	kotlin/l/b/a/b/h/l
    //   231	236	249	finally
    //   239	244	249	finally
    //   247	249	249	finally
    //   384	396	249	finally
    //   399	404	249	finally
    //   407	412	249	finally
    //   415	417	249	finally
    //   55	61	376	java/io/IOException
    //   169	182	376	java/io/IOException
    //   197	207	376	java/io/IOException
    //   216	224	376	java/io/IOException
    //   346	356	376	java/io/IOException
    //   365	373	376	java/io/IOException
    //   436	447	376	java/io/IOException
    //   464	482	376	java/io/IOException
    //   497	507	376	java/io/IOException
    //   516	525	376	java/io/IOException
    //   534	549	376	java/io/IOException
    //   563	573	376	java/io/IOException
    //   582	591	376	java/io/IOException
    //   600	610	376	java/io/IOException
    //   622	633	376	java/io/IOException
    //   642	650	376	java/io/IOException
    //   662	674	376	java/io/IOException
    //   683	692	376	java/io/IOException
    //   701	716	376	java/io/IOException
    //   730	740	376	java/io/IOException
    //   749	758	376	java/io/IOException
    //   767	778	376	java/io/IOException
    //   790	801	376	java/io/IOException
    //   810	818	376	java/io/IOException
    //   844	855	376	java/io/IOException
    //   874	892	376	java/io/IOException
    //   921	932	376	java/io/IOException
    //   951	968	376	java/io/IOException
    //   983	993	376	java/io/IOException
    //   1013	1020	376	java/io/IOException
    //   1029	1040	376	java/io/IOException
    //   1144	1149	1168	java/io/IOException
    //   1144	1149	1181	finally
    //   312	317	1198	java/io/IOException
    //   312	317	1211	finally
    //   1046	1070	1228	finally
    //   1073	1079	1228	finally
    //   1046	1070	1232	java/io/IOException
    //   1073	1079	1232	java/io/IOException
    //   55	61	1266	finally
    //   169	182	1266	finally
    //   197	207	1266	finally
    //   216	224	1266	finally
    //   346	356	1266	finally
    //   365	373	1266	finally
    //   436	447	1266	finally
    //   464	482	1266	finally
    //   497	507	1266	finally
    //   516	525	1266	finally
    //   534	549	1266	finally
    //   563	573	1266	finally
    //   582	591	1266	finally
    //   600	610	1266	finally
    //   622	633	1266	finally
    //   642	650	1266	finally
    //   662	674	1266	finally
    //   683	692	1266	finally
    //   701	716	1266	finally
    //   730	740	1266	finally
    //   749	758	1266	finally
    //   767	778	1266	finally
    //   790	801	1266	finally
    //   810	818	1266	finally
    //   844	855	1266	finally
    //   874	892	1266	finally
    //   921	932	1266	finally
    //   951	968	1266	finally
    //   983	993	1266	finally
    //   1013	1020	1266	finally
    //   1029	1040	1266	finally
    //   1046	1070	1273	kotlin/l/b/a/b/h/l
    //   1073	1079	1273	kotlin/l/b/a/b/h/l
  }
  
  private a$q(i.b<q, ?> paramb)
  {
    super(paramb);
    this.aiXZ = paramb.aiXZ;
  }
  
  public static q e(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(58894);
    paramInputStream = (q)aiYa.i(paramInputStream, paramg);
    AppMethodBeat.o(58894);
    return paramInputStream;
  }
  
  private void ktf()
  {
    AppMethodBeat.i(58890);
    this.aiYq = 6;
    this.aiZC = 0;
    this.aiYJ = Collections.emptyList();
    this.ajaY = a.p.kvH();
    this.ajaZ = 0;
    this.ajba = a.p.kvH();
    this.ajbb = 0;
    this.ajbc = Collections.emptyList();
    this.aiZa = Collections.emptyList();
    AppMethodBeat.o(58890);
  }
  
  public static q kwf()
  {
    return ajaX;
  }
  
  public final void a(f paramf)
  {
    int k = 0;
    AppMethodBeat.i(58892);
    getSerializedSize();
    i.c.a locala = kym();
    if ((this.bitField0_ & 0x1) == 1) {
      paramf.cF(1, this.aiYq);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramf.cF(2, this.aiZC);
    }
    int i = 0;
    while (i < this.aiYJ.size())
    {
      paramf.a(3, (r)this.aiYJ.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramf.a(4, this.ajaY);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramf.cF(5, this.ajaZ);
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramf.a(6, this.ajba);
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramf.cF(7, this.ajbb);
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.ajbc.size()) {
        break;
      }
      paramf.a(8, (r)this.ajbc.get(i));
      i += 1;
    }
    while (j < this.aiZa.size())
    {
      paramf.cF(31, ((Integer)this.aiZa.get(j)).intValue());
      j += 1;
    }
    locala.b(200, paramf);
    paramf.e(this.aiXZ);
    AppMethodBeat.o(58892);
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(58893);
    int i = this.dRJ;
    if (i != -1)
    {
      AppMethodBeat.o(58893);
      return i;
    }
    if ((this.bitField0_ & 0x1) == 1) {}
    for (int j = f.cJ(1, this.aiYq) + 0;; j = 0)
    {
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + f.cJ(2, this.aiZC);
      }
      j = 0;
      while (j < this.aiYJ.size())
      {
        i += f.c(3, (r)this.aiYJ.get(j));
        j += 1;
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + f.c(4, this.ajaY);
      }
      i = j;
      if ((this.bitField0_ & 0x8) == 8) {
        i = j + f.cJ(5, this.ajaZ);
      }
      j = i;
      if ((this.bitField0_ & 0x10) == 16) {
        j = i + f.c(6, this.ajba);
      }
      i = j;
      if ((this.bitField0_ & 0x20) == 32) {
        i = j + f.cJ(7, this.ajbb);
      }
      j = 0;
      while (j < this.ajbc.size())
      {
        i += f.c(8, (r)this.ajbc.get(j));
        j += 1;
      }
      int k = 0;
      int m;
      for (j = 0; k < this.aiZa.size(); j = m + j)
      {
        m = f.kp(((Integer)this.aiZa.get(k)).intValue());
        k += 1;
      }
      i = i + j + this.aiZa.size() * 2 + aie() + this.aiXZ.size();
      this.dRJ = i;
      AppMethodBeat.o(58893);
      return i;
    }
  }
  
  public final boolean hasName()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58891);
    int i = this.memoizedIsInitialized;
    if (i == 1)
    {
      AppMethodBeat.o(58891);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58891);
      return false;
    }
    if (!hasName())
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58891);
      return false;
    }
    i = 0;
    while (i < this.aiYJ.size())
    {
      if (!((a.r)this.aiYJ.get(i)).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58891);
        return false;
      }
      i += 1;
    }
    if ((kwg()) && (!this.ajaY.isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58891);
      return false;
    }
    if ((kwi()) && (!this.ajba.isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58891);
      return false;
    }
    i = 0;
    while (i < this.ajbc.size())
    {
      if (!((a.a)this.ajbc.get(i)).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58891);
        return false;
      }
      i += 1;
    }
    if (!aic())
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58891);
      return false;
    }
    this.memoizedIsInitialized = 1;
    AppMethodBeat.o(58891);
    return true;
  }
  
  public final boolean ktB()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public final boolean kwg()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public final boolean kwh()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public final boolean kwi()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public final boolean kwj()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public static final class a
    extends i.b<a.q, a>
    implements s
  {
    private List<a.r> aiYJ;
    private int aiYq;
    private int aiZC;
    private List<Integer> aiZa;
    private a.p ajaY;
    private int ajaZ;
    private a.p ajba;
    private int ajbb;
    private List<a.a> ajbc;
    private int bitField0_;
    
    private a()
    {
      AppMethodBeat.i(58867);
      this.aiYq = 6;
      this.aiYJ = Collections.emptyList();
      this.ajaY = a.p.kvH();
      this.ajba = a.p.kvH();
      this.ajbc = Collections.emptyList();
      this.aiZa = Collections.emptyList();
      AppMethodBeat.o(58867);
    }
    
    private a aLC(int paramInt)
    {
      this.bitField0_ |= 0x1;
      this.aiYq = paramInt;
      return this;
    }
    
    private a aLD(int paramInt)
    {
      this.bitField0_ |= 0x2;
      this.aiZC = paramInt;
      return this;
    }
    
    private a aLE(int paramInt)
    {
      this.bitField0_ |= 0x10;
      this.ajaZ = paramInt;
      return this;
    }
    
    private a aLF(int paramInt)
    {
      this.bitField0_ |= 0x40;
      this.ajbb = paramInt;
      return this;
    }
    
    private void ktU()
    {
      AppMethodBeat.i(58873);
      if ((this.bitField0_ & 0x4) != 4)
      {
        this.aiYJ = new ArrayList(this.aiYJ);
        this.bitField0_ |= 0x4;
      }
      AppMethodBeat.o(58873);
    }
    
    private void kue()
    {
      AppMethodBeat.i(58877);
      if ((this.bitField0_ & 0x100) != 256)
      {
        this.aiZa = new ArrayList(this.aiZa);
        this.bitField0_ |= 0x100;
      }
      AppMethodBeat.o(58877);
    }
    
    private a kwk()
    {
      AppMethodBeat.i(58868);
      a locala = new a().e(kwl());
      AppMethodBeat.o(58868);
      return locala;
    }
    
    private a.q kwl()
    {
      int j = 1;
      AppMethodBeat.i(58869);
      a.q localq = new a.q(this, (byte)0);
      int k = this.bitField0_;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.q.a(localq, this.aiYq);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.q.b(localq, this.aiZC);
        if ((this.bitField0_ & 0x4) == 4)
        {
          this.aiYJ = Collections.unmodifiableList(this.aiYJ);
          this.bitField0_ &= 0xFFFFFFFB;
        }
        a.q.a(localq, this.aiYJ);
        j = i;
        if ((k & 0x8) == 8) {
          j = i | 0x4;
        }
        a.q.a(localq, this.ajaY);
        i = j;
        if ((k & 0x10) == 16) {
          i = j | 0x8;
        }
        a.q.c(localq, this.ajaZ);
        j = i;
        if ((k & 0x20) == 32) {
          j = i | 0x10;
        }
        a.q.b(localq, this.ajba);
        i = j;
        if ((k & 0x40) == 64) {
          i = j | 0x20;
        }
        a.q.d(localq, this.ajbb);
        if ((this.bitField0_ & 0x80) == 128)
        {
          this.ajbc = Collections.unmodifiableList(this.ajbc);
          this.bitField0_ &= 0xFFFFFF7F;
        }
        a.q.b(localq, this.ajbc);
        if ((this.bitField0_ & 0x100) == 256)
        {
          this.aiZa = Collections.unmodifiableList(this.aiZa);
          this.bitField0_ &= 0xFFFFFEFF;
        }
        a.q.c(localq, this.aiZa);
        a.q.e(localq, i);
        AppMethodBeat.o(58869);
        return localq;
        j = 0;
      }
    }
    
    private void kwm()
    {
      AppMethodBeat.i(58876);
      if ((this.bitField0_ & 0x80) != 128)
      {
        this.ajbc = new ArrayList(this.ajbc);
        this.bitField0_ |= 0x80;
      }
      AppMethodBeat.o(58876);
    }
    
    private a o(a.p paramp)
    {
      AppMethodBeat.i(58874);
      if (((this.bitField0_ & 0x8) == 8) && (this.ajaY != a.p.kvH())) {}
      for (this.ajaY = a.p.g(this.ajaY).k(paramp).kwd();; this.ajaY = paramp)
      {
        this.bitField0_ |= 0x8;
        AppMethodBeat.o(58874);
        return this;
      }
    }
    
    private a p(a.p paramp)
    {
      AppMethodBeat.i(58875);
      if (((this.bitField0_ & 0x20) == 32) && (this.ajba != a.p.kvH())) {}
      for (this.ajba = a.p.g(this.ajba).k(paramp).kwd();; this.ajba = paramp)
      {
        this.bitField0_ |= 0x20;
        AppMethodBeat.o(58875);
        return this;
      }
    }
    
    /* Error */
    private a v(kotlin.l.b.a.b.h.e parame, g paramg)
    {
      // Byte code:
      //   0: ldc 161
      //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 165	kotlin/l/b/a/b/e/a$q:aiYa	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 170 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$q
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 102	kotlin/l/b/a/b/e/a$q$a:e	(Lkotlin/l/b/a/b/e/a$q;)Lkotlin/l/b/a/b/e/a$q$a;
      //   30: pop
      //   31: ldc 161
      //   33: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 174	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   43: checkcast 9	kotlin/l/b/a/b/e/a$q
      //   46: astore_2
      //   47: ldc 161
      //   49: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: aload_2
      //   56: ifnull +9 -> 65
      //   59: aload_0
      //   60: aload_2
      //   61: invokevirtual 102	kotlin/l/b/a/b/e/a$q$a:e	(Lkotlin/l/b/a/b/e/a$q;)Lkotlin/l/b/a/b/e/a$q$a;
      //   64: pop
      //   65: ldc 161
      //   67: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public final a e(a.q paramq)
    {
      AppMethodBeat.i(58870);
      if (paramq == a.q.kwf())
      {
        AppMethodBeat.o(58870);
        return this;
      }
      if (paramq.ktB()) {
        aLC(paramq.aiYq);
      }
      if (paramq.hasName()) {
        aLD(paramq.aiZC);
      }
      if (!a.q.a(paramq).isEmpty())
      {
        if (this.aiYJ.isEmpty())
        {
          this.aiYJ = a.q.a(paramq);
          this.bitField0_ &= 0xFFFFFFFB;
        }
      }
      else
      {
        if (paramq.kwg()) {
          o(paramq.ajaY);
        }
        if (paramq.kwh()) {
          aLE(paramq.ajaZ);
        }
        if (paramq.kwi()) {
          p(paramq.ajba);
        }
        if (paramq.kwj()) {
          aLF(paramq.ajbb);
        }
        if (!a.q.b(paramq).isEmpty())
        {
          if (!this.ajbc.isEmpty()) {
            break label294;
          }
          this.ajbc = a.q.b(paramq);
          this.bitField0_ &= 0xFFFFFF7F;
        }
        label202:
        if (!a.q.c(paramq).isEmpty())
        {
          if (!this.aiZa.isEmpty()) {
            break label315;
          }
          this.aiZa = a.q.c(paramq);
          this.bitField0_ &= 0xFFFFFEFF;
        }
      }
      for (;;)
      {
        a(paramq);
        this.aiXZ = this.aiXZ.a(a.q.d(paramq));
        AppMethodBeat.o(58870);
        return this;
        ktU();
        this.aiYJ.addAll(a.q.a(paramq));
        break;
        label294:
        kwm();
        this.ajbc.addAll(a.q.b(paramq));
        break label202;
        label315:
        kue();
        this.aiZa.addAll(a.q.c(paramq));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58871);
      if ((this.bitField0_ & 0x2) == 2) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58871);
        return false;
      }
      i = 0;
      while (i < this.aiYJ.size())
      {
        if (!((a.r)this.aiYJ.get(i)).isInitialized())
        {
          AppMethodBeat.o(58871);
          return false;
        }
        i += 1;
      }
      if ((this.bitField0_ & 0x8) == 8) {}
      for (i = 1; (i != 0) && (!this.ajaY.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58871);
        return false;
      }
      if ((this.bitField0_ & 0x20) == 32) {}
      for (i = 1; (i != 0) && (!this.ajba.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58871);
        return false;
      }
      i = 0;
      while (i < this.ajbc.size())
      {
        if (!((a.a)this.ajbc.get(i)).isInitialized())
        {
          AppMethodBeat.o(58871);
          return false;
        }
        i += 1;
      }
      if (!aic())
      {
        AppMethodBeat.o(58871);
        return false;
      }
      AppMethodBeat.o(58871);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.q
 * JD-Core Version:    0.7.0.1
 */