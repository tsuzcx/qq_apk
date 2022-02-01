package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.i.b;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.c.a;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.h.t;

public final class a$r
  extends i.c<r>
  implements u
{
  public static t<r> aaZC;
  private static final r abcC;
  private final d aaZB;
  public int aaZD;
  public int abbb;
  public boolean abcD;
  public a.r.b abcE;
  public List<a.p> abcF;
  public List<Integer> abcG;
  private int abcH = -1;
  private int bQS;
  private byte bRd = -1;
  private int bXW = -1;
  
  static
  {
    AppMethodBeat.i(58930);
    aaZC = new b() {};
    r localr = new r();
    abcC = localr;
    localr.iIN();
    AppMethodBeat.o(58930);
  }
  
  private a$r()
  {
    this.aaZB = d.abgb;
  }
  
  /* Error */
  private a$r(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 66	kotlin/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 85
    //   6: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 68	kotlin/l/b/a/b/e/a$r:abcH	I
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 70	kotlin/l/b/a/b/e/a$r:bRd	B
    //   19: aload_0
    //   20: iconst_m1
    //   21: putfield 72	kotlin/l/b/a/b/e/a$r:bXW	I
    //   24: aload_0
    //   25: invokespecial 61	kotlin/l/b/a/b/e/a$r:iIN	()V
    //   28: iconst_0
    //   29: istore_3
    //   30: invokestatic 89	kotlin/l/b/a/b/h/d:iNH	()Lkotlin/l/b/a/b/h/d$b;
    //   33: astore 10
    //   35: aload 10
    //   37: iconst_1
    //   38: invokestatic 95	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   41: astore 11
    //   43: iconst_0
    //   44: istore 5
    //   46: iload 5
    //   48: ifne +770 -> 818
    //   51: iload_3
    //   52: istore 6
    //   54: iload_3
    //   55: istore 7
    //   57: iload_3
    //   58: istore 8
    //   60: aload_1
    //   61: invokevirtual 101	kotlin/l/b/a/b/h/e:Av	()I
    //   64: istore 4
    //   66: iload 4
    //   68: lookupswitch	default:+888->956, 0:+891->959, 8:+104->172, 16:+240->308, 24:+324->392, 32:+363->431, 42:+472->540, 48:+536->604, 50:+599->667
    //   145: istore 6
    //   147: iload_3
    //   148: istore 7
    //   150: iload_3
    //   151: istore 8
    //   153: aload_0
    //   154: aload_1
    //   155: aload 11
    //   157: aload_2
    //   158: iload 4
    //   160: invokevirtual 104	kotlin/l/b/a/b/e/a$r:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   163: ifne -117 -> 46
    //   166: iconst_1
    //   167: istore 5
    //   169: goto -123 -> 46
    //   172: iload_3
    //   173: istore 6
    //   175: iload_3
    //   176: istore 7
    //   178: iload_3
    //   179: istore 8
    //   181: aload_0
    //   182: aload_0
    //   183: getfield 106	kotlin/l/b/a/b/e/a$r:bQS	I
    //   186: iconst_1
    //   187: ior
    //   188: putfield 106	kotlin/l/b/a/b/e/a$r:bQS	I
    //   191: iload_3
    //   192: istore 6
    //   194: iload_3
    //   195: istore 7
    //   197: iload_3
    //   198: istore 8
    //   200: aload_0
    //   201: aload_1
    //   202: invokevirtual 109	kotlin/l/b/a/b/h/e:AK	()I
    //   205: putfield 111	kotlin/l/b/a/b/e/a$r:aaZD	I
    //   208: goto -162 -> 46
    //   211: astore_1
    //   212: iload 6
    //   214: istore 7
    //   216: iload 7
    //   218: istore 4
    //   220: aload_1
    //   221: aload_0
    //   222: putfield 115	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   225: iload 7
    //   227: istore 4
    //   229: ldc 85
    //   231: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: iload 7
    //   236: istore 4
    //   238: aload_1
    //   239: athrow
    //   240: astore_1
    //   241: iload 4
    //   243: bipush 16
    //   245: iand
    //   246: bipush 16
    //   248: if_icmpne +14 -> 262
    //   251: aload_0
    //   252: aload_0
    //   253: getfield 117	kotlin/l/b/a/b/e/a$r:abcF	Ljava/util/List;
    //   256: invokestatic 123	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   259: putfield 117	kotlin/l/b/a/b/e/a$r:abcF	Ljava/util/List;
    //   262: iload 4
    //   264: bipush 32
    //   266: iand
    //   267: bipush 32
    //   269: if_icmpne +14 -> 283
    //   272: aload_0
    //   273: aload_0
    //   274: getfield 125	kotlin/l/b/a/b/e/a$r:abcG	Ljava/util/List;
    //   277: invokestatic 123	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   280: putfield 125	kotlin/l/b/a/b/e/a$r:abcG	Ljava/util/List;
    //   283: aload 11
    //   285: invokevirtual 128	kotlin/l/b/a/b/h/f:flush	()V
    //   288: aload_0
    //   289: aload 10
    //   291: invokevirtual 134	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   294: putfield 79	kotlin/l/b/a/b/e/a$r:aaZB	Lkotlin/l/b/a/b/h/d;
    //   297: aload_0
    //   298: invokevirtual 137	kotlin/l/b/a/b/e/a$r:HZ	()V
    //   301: ldc 85
    //   303: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_1
    //   307: athrow
    //   308: iload_3
    //   309: istore 6
    //   311: iload_3
    //   312: istore 7
    //   314: iload_3
    //   315: istore 8
    //   317: aload_0
    //   318: aload_0
    //   319: getfield 106	kotlin/l/b/a/b/e/a$r:bQS	I
    //   322: iconst_2
    //   323: ior
    //   324: putfield 106	kotlin/l/b/a/b/e/a$r:bQS	I
    //   327: iload_3
    //   328: istore 6
    //   330: iload_3
    //   331: istore 7
    //   333: iload_3
    //   334: istore 8
    //   336: aload_0
    //   337: aload_1
    //   338: invokevirtual 109	kotlin/l/b/a/b/h/e:AK	()I
    //   341: putfield 139	kotlin/l/b/a/b/e/a$r:abbb	I
    //   344: goto -298 -> 46
    //   347: astore_1
    //   348: iload 7
    //   350: istore 6
    //   352: iload 6
    //   354: istore 4
    //   356: new 82	kotlin/l/b/a/b/h/l
    //   359: dup
    //   360: aload_1
    //   361: invokevirtual 143	java/io/IOException:getMessage	()Ljava/lang/String;
    //   364: invokespecial 146	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   367: astore_1
    //   368: iload 6
    //   370: istore 4
    //   372: aload_1
    //   373: aload_0
    //   374: putfield 115	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   377: iload 6
    //   379: istore 4
    //   381: ldc 85
    //   383: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: iload 6
    //   388: istore 4
    //   390: aload_1
    //   391: athrow
    //   392: iload_3
    //   393: istore 6
    //   395: iload_3
    //   396: istore 7
    //   398: iload_3
    //   399: istore 8
    //   401: aload_0
    //   402: aload_0
    //   403: getfield 106	kotlin/l/b/a/b/e/a$r:bQS	I
    //   406: iconst_4
    //   407: ior
    //   408: putfield 106	kotlin/l/b/a/b/e/a$r:bQS	I
    //   411: iload_3
    //   412: istore 6
    //   414: iload_3
    //   415: istore 7
    //   417: iload_3
    //   418: istore 8
    //   420: aload_0
    //   421: aload_1
    //   422: invokevirtual 150	kotlin/l/b/a/b/h/e:AB	()Z
    //   425: putfield 152	kotlin/l/b/a/b/e/a$r:abcD	Z
    //   428: goto -382 -> 46
    //   431: iload_3
    //   432: istore 6
    //   434: iload_3
    //   435: istore 7
    //   437: iload_3
    //   438: istore 8
    //   440: aload_1
    //   441: invokevirtual 109	kotlin/l/b/a/b/h/e:AK	()I
    //   444: istore 9
    //   446: iload_3
    //   447: istore 6
    //   449: iload_3
    //   450: istore 7
    //   452: iload_3
    //   453: istore 8
    //   455: iload 9
    //   457: invokestatic 156	kotlin/l/b/a/b/e/a$r$b:aER	(I)Lkotlin/l/b/a/b/e/a$r$b;
    //   460: astore 12
    //   462: aload 12
    //   464: ifnonnull +38 -> 502
    //   467: iload_3
    //   468: istore 6
    //   470: iload_3
    //   471: istore 7
    //   473: iload_3
    //   474: istore 8
    //   476: aload 11
    //   478: iload 4
    //   480: invokevirtual 159	kotlin/l/b/a/b/h/f:hT	(I)V
    //   483: iload_3
    //   484: istore 6
    //   486: iload_3
    //   487: istore 7
    //   489: iload_3
    //   490: istore 8
    //   492: aload 11
    //   494: iload 9
    //   496: invokevirtual 159	kotlin/l/b/a/b/h/f:hT	(I)V
    //   499: goto -453 -> 46
    //   502: iload_3
    //   503: istore 6
    //   505: iload_3
    //   506: istore 7
    //   508: iload_3
    //   509: istore 8
    //   511: aload_0
    //   512: aload_0
    //   513: getfield 106	kotlin/l/b/a/b/e/a$r:bQS	I
    //   516: bipush 8
    //   518: ior
    //   519: putfield 106	kotlin/l/b/a/b/e/a$r:bQS	I
    //   522: iload_3
    //   523: istore 6
    //   525: iload_3
    //   526: istore 7
    //   528: iload_3
    //   529: istore 8
    //   531: aload_0
    //   532: aload 12
    //   534: putfield 161	kotlin/l/b/a/b/e/a$r:abcE	Lkotlin/l/b/a/b/e/a$r$b;
    //   537: goto -491 -> 46
    //   540: iload_3
    //   541: bipush 16
    //   543: iand
    //   544: bipush 16
    //   546: if_icmpeq +407 -> 953
    //   549: iload_3
    //   550: istore 6
    //   552: iload_3
    //   553: istore 7
    //   555: iload_3
    //   556: istore 8
    //   558: aload_0
    //   559: new 163	java/util/ArrayList
    //   562: dup
    //   563: invokespecial 164	java/util/ArrayList:<init>	()V
    //   566: putfield 117	kotlin/l/b/a/b/e/a$r:abcF	Ljava/util/List;
    //   569: iload_3
    //   570: bipush 16
    //   572: ior
    //   573: istore_3
    //   574: iload_3
    //   575: istore 4
    //   577: iload_3
    //   578: istore 6
    //   580: iload_3
    //   581: istore 7
    //   583: aload_0
    //   584: getfield 117	kotlin/l/b/a/b/e/a$r:abcF	Ljava/util/List;
    //   587: aload_1
    //   588: getstatic 167	kotlin/l/b/a/b/e/a$p:aaZC	Lkotlin/l/b/a/b/h/t;
    //   591: aload_2
    //   592: invokevirtual 170	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   595: invokeinterface 176 2 0
    //   600: pop
    //   601: goto -555 -> 46
    //   604: iload_3
    //   605: bipush 32
    //   607: iand
    //   608: bipush 32
    //   610: if_icmpeq +340 -> 950
    //   613: iload_3
    //   614: istore 6
    //   616: iload_3
    //   617: istore 7
    //   619: iload_3
    //   620: istore 8
    //   622: aload_0
    //   623: new 163	java/util/ArrayList
    //   626: dup
    //   627: invokespecial 164	java/util/ArrayList:<init>	()V
    //   630: putfield 125	kotlin/l/b/a/b/e/a$r:abcG	Ljava/util/List;
    //   633: iload_3
    //   634: bipush 32
    //   636: ior
    //   637: istore_3
    //   638: iload_3
    //   639: istore 4
    //   641: iload_3
    //   642: istore 6
    //   644: iload_3
    //   645: istore 7
    //   647: aload_0
    //   648: getfield 125	kotlin/l/b/a/b/e/a$r:abcG	Ljava/util/List;
    //   651: aload_1
    //   652: invokevirtual 109	kotlin/l/b/a/b/h/e:AK	()I
    //   655: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   658: invokeinterface 176 2 0
    //   663: pop
    //   664: goto -618 -> 46
    //   667: iload_3
    //   668: istore 6
    //   670: iload_3
    //   671: istore 7
    //   673: iload_3
    //   674: istore 8
    //   676: aload_1
    //   677: aload_1
    //   678: invokevirtual 109	kotlin/l/b/a/b/h/e:AK	()I
    //   681: invokevirtual 186	kotlin/l/b/a/b/h/e:gA	(I)I
    //   684: istore 9
    //   686: iload_3
    //   687: istore 4
    //   689: iload_3
    //   690: bipush 32
    //   692: iand
    //   693: bipush 32
    //   695: if_icmpeq +48 -> 743
    //   698: iload_3
    //   699: istore 6
    //   701: iload_3
    //   702: istore 7
    //   704: iload_3
    //   705: istore 4
    //   707: iload_3
    //   708: istore 8
    //   710: aload_1
    //   711: invokevirtual 189	kotlin/l/b/a/b/h/e:AM	()I
    //   714: ifle +29 -> 743
    //   717: iload_3
    //   718: istore 6
    //   720: iload_3
    //   721: istore 7
    //   723: iload_3
    //   724: istore 8
    //   726: aload_0
    //   727: new 163	java/util/ArrayList
    //   730: dup
    //   731: invokespecial 164	java/util/ArrayList:<init>	()V
    //   734: putfield 125	kotlin/l/b/a/b/e/a$r:abcG	Ljava/util/List;
    //   737: iload_3
    //   738: bipush 32
    //   740: ior
    //   741: istore 4
    //   743: iload 4
    //   745: istore 6
    //   747: iload 4
    //   749: istore 7
    //   751: iload 4
    //   753: istore 8
    //   755: aload_1
    //   756: invokevirtual 189	kotlin/l/b/a/b/h/e:AM	()I
    //   759: ifle +35 -> 794
    //   762: iload 4
    //   764: istore 6
    //   766: iload 4
    //   768: istore 7
    //   770: iload 4
    //   772: istore 8
    //   774: aload_0
    //   775: getfield 125	kotlin/l/b/a/b/e/a$r:abcG	Ljava/util/List;
    //   778: aload_1
    //   779: invokevirtual 109	kotlin/l/b/a/b/h/e:AK	()I
    //   782: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   785: invokeinterface 176 2 0
    //   790: pop
    //   791: goto -48 -> 743
    //   794: iload 4
    //   796: istore 6
    //   798: iload 4
    //   800: istore 7
    //   802: iload 4
    //   804: istore 8
    //   806: aload_1
    //   807: iload 9
    //   809: invokevirtual 192	kotlin/l/b/a/b/h/e:gB	(I)V
    //   812: iload 4
    //   814: istore_3
    //   815: goto -769 -> 46
    //   818: iload_3
    //   819: bipush 16
    //   821: iand
    //   822: bipush 16
    //   824: if_icmpne +14 -> 838
    //   827: aload_0
    //   828: aload_0
    //   829: getfield 117	kotlin/l/b/a/b/e/a$r:abcF	Ljava/util/List;
    //   832: invokestatic 123	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   835: putfield 117	kotlin/l/b/a/b/e/a$r:abcF	Ljava/util/List;
    //   838: iload_3
    //   839: bipush 32
    //   841: iand
    //   842: bipush 32
    //   844: if_icmpne +14 -> 858
    //   847: aload_0
    //   848: aload_0
    //   849: getfield 125	kotlin/l/b/a/b/e/a$r:abcG	Ljava/util/List;
    //   852: invokestatic 123	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   855: putfield 125	kotlin/l/b/a/b/e/a$r:abcG	Ljava/util/List;
    //   858: aload 11
    //   860: invokevirtual 128	kotlin/l/b/a/b/h/f:flush	()V
    //   863: aload_0
    //   864: aload 10
    //   866: invokevirtual 134	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   869: putfield 79	kotlin/l/b/a/b/e/a$r:aaZB	Lkotlin/l/b/a/b/h/d;
    //   872: aload_0
    //   873: invokevirtual 137	kotlin/l/b/a/b/e/a$r:HZ	()V
    //   876: ldc 85
    //   878: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   881: return
    //   882: astore_1
    //   883: aload_0
    //   884: aload 10
    //   886: invokevirtual 134	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   889: putfield 79	kotlin/l/b/a/b/e/a$r:aaZB	Lkotlin/l/b/a/b/h/d;
    //   892: goto -20 -> 872
    //   895: astore_1
    //   896: aload_0
    //   897: aload 10
    //   899: invokevirtual 134	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   902: putfield 79	kotlin/l/b/a/b/e/a$r:aaZB	Lkotlin/l/b/a/b/h/d;
    //   905: ldc 85
    //   907: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   910: aload_1
    //   911: athrow
    //   912: astore_2
    //   913: aload_0
    //   914: aload 10
    //   916: invokevirtual 134	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   919: putfield 79	kotlin/l/b/a/b/e/a$r:aaZB	Lkotlin/l/b/a/b/h/d;
    //   922: goto -625 -> 297
    //   925: astore_1
    //   926: aload_0
    //   927: aload 10
    //   929: invokevirtual 134	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   932: putfield 79	kotlin/l/b/a/b/e/a$r:aaZB	Lkotlin/l/b/a/b/h/d;
    //   935: ldc 85
    //   937: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   940: aload_1
    //   941: athrow
    //   942: astore_1
    //   943: goto -591 -> 352
    //   946: astore_1
    //   947: goto -731 -> 216
    //   950: goto -312 -> 638
    //   953: goto -379 -> 574
    //   956: goto -812 -> 144
    //   959: iconst_1
    //   960: istore 5
    //   962: goto -916 -> 46
    //   965: astore_1
    //   966: iload 8
    //   968: istore 4
    //   970: goto -729 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	973	0	this	r
    //   0	973	1	parame	kotlin.l.b.a.b.h.e
    //   0	973	2	paramg	kotlin.l.b.a.b.h.g
    //   29	813	3	i	int
    //   64	905	4	j	int
    //   44	917	5	k	int
    //   52	745	6	m	int
    //   55	746	7	n	int
    //   58	909	8	i1	int
    //   444	364	9	i2	int
    //   33	895	10	localb	kotlin.l.b.a.b.h.d.b
    //   41	818	11	localf	f
    //   460	73	12	localb1	a.r.b
    // Exception table:
    //   from	to	target	type
    //   60	66	211	kotlin/l/b/a/b/h/l
    //   153	166	211	kotlin/l/b/a/b/h/l
    //   181	191	211	kotlin/l/b/a/b/h/l
    //   200	208	211	kotlin/l/b/a/b/h/l
    //   317	327	211	kotlin/l/b/a/b/h/l
    //   336	344	211	kotlin/l/b/a/b/h/l
    //   401	411	211	kotlin/l/b/a/b/h/l
    //   420	428	211	kotlin/l/b/a/b/h/l
    //   440	446	211	kotlin/l/b/a/b/h/l
    //   455	462	211	kotlin/l/b/a/b/h/l
    //   476	483	211	kotlin/l/b/a/b/h/l
    //   492	499	211	kotlin/l/b/a/b/h/l
    //   511	522	211	kotlin/l/b/a/b/h/l
    //   531	537	211	kotlin/l/b/a/b/h/l
    //   558	569	211	kotlin/l/b/a/b/h/l
    //   622	633	211	kotlin/l/b/a/b/h/l
    //   676	686	211	kotlin/l/b/a/b/h/l
    //   710	717	211	kotlin/l/b/a/b/h/l
    //   726	737	211	kotlin/l/b/a/b/h/l
    //   755	762	211	kotlin/l/b/a/b/h/l
    //   774	791	211	kotlin/l/b/a/b/h/l
    //   806	812	211	kotlin/l/b/a/b/h/l
    //   220	225	240	finally
    //   229	234	240	finally
    //   238	240	240	finally
    //   356	368	240	finally
    //   372	377	240	finally
    //   381	386	240	finally
    //   390	392	240	finally
    //   583	601	240	finally
    //   647	664	240	finally
    //   60	66	347	java/io/IOException
    //   153	166	347	java/io/IOException
    //   181	191	347	java/io/IOException
    //   200	208	347	java/io/IOException
    //   317	327	347	java/io/IOException
    //   336	344	347	java/io/IOException
    //   401	411	347	java/io/IOException
    //   420	428	347	java/io/IOException
    //   440	446	347	java/io/IOException
    //   455	462	347	java/io/IOException
    //   476	483	347	java/io/IOException
    //   492	499	347	java/io/IOException
    //   511	522	347	java/io/IOException
    //   531	537	347	java/io/IOException
    //   558	569	347	java/io/IOException
    //   622	633	347	java/io/IOException
    //   676	686	347	java/io/IOException
    //   710	717	347	java/io/IOException
    //   726	737	347	java/io/IOException
    //   755	762	347	java/io/IOException
    //   774	791	347	java/io/IOException
    //   806	812	347	java/io/IOException
    //   858	863	882	java/io/IOException
    //   858	863	895	finally
    //   283	288	912	java/io/IOException
    //   283	288	925	finally
    //   583	601	942	java/io/IOException
    //   647	664	942	java/io/IOException
    //   583	601	946	kotlin/l/b/a/b/h/l
    //   647	664	946	kotlin/l/b/a/b/h/l
    //   60	66	965	finally
    //   153	166	965	finally
    //   181	191	965	finally
    //   200	208	965	finally
    //   317	327	965	finally
    //   336	344	965	finally
    //   401	411	965	finally
    //   420	428	965	finally
    //   440	446	965	finally
    //   455	462	965	finally
    //   476	483	965	finally
    //   492	499	965	finally
    //   511	522	965	finally
    //   531	537	965	finally
    //   558	569	965	finally
    //   622	633	965	finally
    //   676	686	965	finally
    //   710	717	965	finally
    //   726	737	965	finally
    //   755	762	965	finally
    //   774	791	965	finally
    //   806	812	965	finally
  }
  
  private a$r(i.b<r, ?> paramb)
  {
    super(paramb);
    this.aaZB = paramb.aaZB;
  }
  
  private void iIN()
  {
    AppMethodBeat.i(58924);
    this.aaZD = 0;
    this.abbb = 0;
    this.abcD = false;
    this.abcE = a.r.b.abcK;
    this.abcF = Collections.emptyList();
    this.abcG = Collections.emptyList();
    AppMethodBeat.o(58924);
  }
  
  public static r iLT()
  {
    return abcC;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(58927);
    int i = this.bXW;
    if (i != -1)
    {
      AppMethodBeat.o(58927);
      return i;
    }
    if ((this.bQS & 0x1) == 1) {}
    for (int j = f.bM(1, this.aaZD) + 0;; j = 0)
    {
      i = j;
      if ((this.bQS & 0x2) == 2) {
        i = j + f.bM(2, this.abbb);
      }
      j = i;
      if ((this.bQS & 0x4) == 4) {
        j = i + (f.gL(3) + 1);
      }
      i = j;
      if ((this.bQS & 0x8) == 8) {
        i = j + f.bO(4, this.abcE.value);
      }
      j = 0;
      while (j < this.abcF.size())
      {
        i += f.c(5, (r)this.abcF.get(j));
        j += 1;
      }
      int k = 0;
      int m;
      for (j = 0; k < this.abcG.size(); j = m + j)
      {
        m = f.gM(((Integer)this.abcG.get(k)).intValue());
        k += 1;
      }
      k = i + j;
      i = k;
      if (!this.abcG.isEmpty()) {
        i = k + 1 + f.gM(j);
      }
      this.abcH = j;
      i = i + Ii() + this.aaZB.size();
      this.bXW = i;
      AppMethodBeat.o(58927);
      return i;
    }
  }
  
  public final boolean Cc()
  {
    return (this.bQS & 0x2) == 2;
  }
  
  public final void a(f paramf)
  {
    int j = 0;
    AppMethodBeat.i(58926);
    Ad();
    i.c.a locala = iNU();
    if ((this.bQS & 0x1) == 1) {
      paramf.bJ(1, this.aaZD);
    }
    if ((this.bQS & 0x2) == 2) {
      paramf.bJ(2, this.abbb);
    }
    if ((this.bQS & 0x4) == 4) {
      paramf.Jq(this.abcD);
    }
    if ((this.bQS & 0x8) == 8) {
      paramf.ox(4, this.abcE.value);
    }
    int i = 0;
    while (i < this.abcF.size())
    {
      paramf.a(5, (r)this.abcF.get(i));
      i += 1;
    }
    i = j;
    if (this.abcG.size() > 0)
    {
      paramf.hT(50);
      paramf.hT(this.abcH);
      i = j;
    }
    while (i < this.abcG.size())
    {
      paramf.gD(((Integer)this.abcG.get(i)).intValue());
      i += 1;
    }
    locala.b(1000, paramf);
    paramf.e(this.aaZB);
    AppMethodBeat.o(58926);
  }
  
  public final boolean iIM()
  {
    return (this.bQS & 0x1) == 1;
  }
  
  public final boolean iLU()
  {
    return (this.bQS & 0x4) == 4;
  }
  
  public final boolean iLV()
  {
    return (this.bQS & 0x8) == 8;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58925);
    int i = this.bRd;
    if (i == 1)
    {
      AppMethodBeat.o(58925);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58925);
      return false;
    }
    if (!iIM())
    {
      this.bRd = 0;
      AppMethodBeat.o(58925);
      return false;
    }
    if (!Cc())
    {
      this.bRd = 0;
      AppMethodBeat.o(58925);
      return false;
    }
    i = 0;
    while (i < this.abcF.size())
    {
      if (!((a.p)this.abcF.get(i)).isInitialized())
      {
        this.bRd = 0;
        AppMethodBeat.o(58925);
        return false;
      }
      i += 1;
    }
    if (!Ig())
    {
      this.bRd = 0;
      AppMethodBeat.o(58925);
      return false;
    }
    this.bRd = 1;
    AppMethodBeat.o(58925);
    return true;
  }
  
  public static final class a
    extends i.b<a.r, a>
    implements u
  {
    private int aaZD;
    private int abbb;
    private boolean abcD;
    private a.r.b abcE;
    private List<a.p> abcF;
    private List<Integer> abcG;
    private int bQS;
    
    private a()
    {
      AppMethodBeat.i(58899);
      this.abcE = a.r.b.abcK;
      this.abcF = Collections.emptyList();
      this.abcG = Collections.emptyList();
      AppMethodBeat.o(58899);
    }
    
    private a Jp(boolean paramBoolean)
    {
      this.bQS |= 0x4;
      this.abcD = paramBoolean;
      return this;
    }
    
    private a a(a.r.b paramb)
    {
      AppMethodBeat.i(58905);
      if (paramb == null)
      {
        paramb = new NullPointerException();
        AppMethodBeat.o(58905);
        throw paramb;
      }
      this.bQS |= 0x8;
      this.abcE = paramb;
      AppMethodBeat.o(58905);
      return this;
    }
    
    private a aEP(int paramInt)
    {
      this.bQS |= 0x1;
      this.aaZD = paramInt;
      return this;
    }
    
    private a aEQ(int paramInt)
    {
      this.bQS |= 0x2;
      this.abbb = paramInt;
      return this;
    }
    
    private a iLW()
    {
      AppMethodBeat.i(58900);
      a locala = new a().d(iLX());
      AppMethodBeat.o(58900);
      return locala;
    }
    
    private a.r iLX()
    {
      int j = 1;
      AppMethodBeat.i(58901);
      a.r localr = new a.r(this, (byte)0);
      int k = this.bQS;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.r.a(localr, this.aaZD);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.r.b(localr, this.abbb);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.r.a(localr, this.abcD);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.r.a(localr, this.abcE);
        if ((this.bQS & 0x10) == 16)
        {
          this.abcF = Collections.unmodifiableList(this.abcF);
          this.bQS &= 0xFFFFFFEF;
        }
        a.r.a(localr, this.abcF);
        if ((this.bQS & 0x20) == 32)
        {
          this.abcG = Collections.unmodifiableList(this.abcG);
          this.bQS &= 0xFFFFFFDF;
        }
        a.r.b(localr, this.abcG);
        a.r.c(localr, i);
        AppMethodBeat.o(58901);
        return localr;
        j = 0;
      }
    }
    
    private void iLY()
    {
      AppMethodBeat.i(58906);
      if ((this.bQS & 0x10) != 16)
      {
        this.abcF = new ArrayList(this.abcF);
        this.bQS |= 0x10;
      }
      AppMethodBeat.o(58906);
    }
    
    private void iLZ()
    {
      AppMethodBeat.i(58907);
      if ((this.bQS & 0x20) != 32)
      {
        this.abcG = new ArrayList(this.abcG);
        this.bQS |= 0x20;
      }
      AppMethodBeat.o(58907);
    }
    
    /* Error */
    private a w(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 132
      //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 136	kotlin/l/b/a/b/e/a$r:aaZC	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 141 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$r
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 88	kotlin/l/b/a/b/e/a$r$a:d	(Lkotlin/l/b/a/b/e/a$r;)Lkotlin/l/b/a/b/e/a$r$a;
      //   26: pop
      //   27: ldc 132
      //   29: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 145	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
      //   39: checkcast 9	kotlin/l/b/a/b/e/a$r
      //   42: astore_2
      //   43: ldc 132
      //   45: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 88	kotlin/l/b/a/b/e/a$r$a:d	(Lkotlin/l/b/a/b/e/a$r;)Lkotlin/l/b/a/b/e/a$r$a;
      //   60: pop
      //   61: ldc 132
      //   63: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   6	64	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	kotlin/l/b/a/b/h/l
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a d(a.r paramr)
    {
      AppMethodBeat.i(58902);
      if (paramr == a.r.iLT())
      {
        AppMethodBeat.o(58902);
        return this;
      }
      if (paramr.iIM()) {
        aEP(paramr.aaZD);
      }
      if (paramr.Cc()) {
        aEQ(paramr.abbb);
      }
      if (paramr.iLU()) {
        Jp(paramr.abcD);
      }
      if (paramr.iLV()) {
        a(paramr.abcE);
      }
      if (!a.r.a(paramr).isEmpty())
      {
        if (this.abcF.isEmpty())
        {
          this.abcF = a.r.a(paramr);
          this.bQS &= 0xFFFFFFEF;
        }
      }
      else if (!a.r.b(paramr).isEmpty())
      {
        if (!this.abcG.isEmpty()) {
          break label217;
        }
        this.abcG = a.r.b(paramr);
        this.bQS &= 0xFFFFFFDF;
      }
      for (;;)
      {
        a(paramr);
        this.aaZB = this.aaZB.a(a.r.c(paramr));
        AppMethodBeat.o(58902);
        return this;
        iLY();
        this.abcF.addAll(a.r.a(paramr));
        break;
        label217:
        iLZ();
        this.abcG.addAll(a.r.b(paramr));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58903);
      if ((this.bQS & 0x1) == 1) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58903);
        return false;
      }
      if ((this.bQS & 0x2) == 2) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58903);
        return false;
      }
      i = 0;
      while (i < this.abcF.size())
      {
        if (!((a.p)this.abcF.get(i)).isInitialized())
        {
          AppMethodBeat.o(58903);
          return false;
        }
        i += 1;
      }
      if (!Ig())
      {
        AppMethodBeat.o(58903);
        return false;
      }
      AppMethodBeat.o(58903);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.r
 * JD-Core Version:    0.7.0.1
 */