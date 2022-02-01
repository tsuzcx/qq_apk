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
import kotlin.l.b.a.b.h.i.b;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.c.a;
import kotlin.l.b.a.b.h.x;

public final class a$p
  extends i.c<p>
  implements t
{
  public static kotlin.l.b.a.b.h.t<p> aaZC;
  private static final p abca;
  private final d aaZB;
  public List<a> aaZE;
  public int aaZS;
  public boolean abcb;
  public int abcc;
  public p abcd;
  public int abce;
  public int abcf;
  public int abcg;
  public int abch;
  public int abci;
  public p abcj;
  public int abck;
  public p abcl;
  public int abcm;
  private int bQS;
  private byte bRd = -1;
  private int bXW = -1;
  
  static
  {
    AppMethodBeat.i(58865);
    aaZC = new b() {};
    p localp = new p();
    abca = localp;
    localp.iIN();
    AppMethodBeat.o(58865);
  }
  
  private a$p()
  {
    this.aaZB = d.abgb;
  }
  
  /* Error */
  private a$p(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 78	kotlin/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 95
    //   6: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 80	kotlin/l/b/a/b/e/a$p:bRd	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 82	kotlin/l/b/a/b/e/a$p:bXW	I
    //   19: aload_0
    //   20: invokespecial 73	kotlin/l/b/a/b/e/a$p:iIN	()V
    //   23: invokestatic 99	kotlin/l/b/a/b/h/d:iNH	()Lkotlin/l/b/a/b/h/d$b;
    //   26: astore 10
    //   28: aload 10
    //   30: iconst_1
    //   31: invokestatic 105	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   34: astore 11
    //   36: iconst_0
    //   37: istore 6
    //   39: iconst_0
    //   40: istore_3
    //   41: iload 6
    //   43: ifne +1196 -> 1239
    //   46: iload_3
    //   47: istore 7
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 8
    //   55: aload_1
    //   56: invokevirtual 111	kotlin/l/b/a/b/h/e:Av	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+1296->1359, 0:+1299->1362, 8:+157->220, 18:+268->331, 24:+380->443, 32:+419->482, 42:+458->521, 48:+599->662, 56:+639->702, 64:+679->742, 72:+719->782, 82:+759->822, 88:+906->969, 96:+947->1010, 106:+988->1051, 112:+1135->1198
    //   193: istore 7
    //   195: iload_3
    //   196: istore 5
    //   198: iload_3
    //   199: istore 8
    //   201: aload_0
    //   202: aload_1
    //   203: aload 11
    //   205: aload_2
    //   206: iload 4
    //   208: invokevirtual 114	kotlin/l/b/a/b/e/a$p:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   211: ifne -170 -> 41
    //   214: iconst_1
    //   215: istore 6
    //   217: goto -176 -> 41
    //   220: iload_3
    //   221: istore 7
    //   223: iload_3
    //   224: istore 5
    //   226: iload_3
    //   227: istore 8
    //   229: aload_0
    //   230: aload_0
    //   231: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   234: sipush 4096
    //   237: ior
    //   238: putfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   241: iload_3
    //   242: istore 7
    //   244: iload_3
    //   245: istore 5
    //   247: iload_3
    //   248: istore 8
    //   250: aload_0
    //   251: aload_1
    //   252: invokevirtual 119	kotlin/l/b/a/b/h/e:AK	()I
    //   255: putfield 121	kotlin/l/b/a/b/e/a$p:aaZS	I
    //   258: goto -217 -> 41
    //   261: astore_1
    //   262: iload 7
    //   264: istore 5
    //   266: aload_1
    //   267: aload_0
    //   268: putfield 125	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   271: iload 7
    //   273: istore 5
    //   275: ldc 95
    //   277: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: iload 7
    //   282: istore 5
    //   284: aload_1
    //   285: athrow
    //   286: astore_1
    //   287: iload 5
    //   289: iconst_1
    //   290: iand
    //   291: iconst_1
    //   292: if_icmpne +14 -> 306
    //   295: aload_0
    //   296: aload_0
    //   297: getfield 127	kotlin/l/b/a/b/e/a$p:aaZE	Ljava/util/List;
    //   300: invokestatic 133	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   303: putfield 127	kotlin/l/b/a/b/e/a$p:aaZE	Ljava/util/List;
    //   306: aload 11
    //   308: invokevirtual 136	kotlin/l/b/a/b/h/f:flush	()V
    //   311: aload_0
    //   312: aload 10
    //   314: invokevirtual 142	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   317: putfield 89	kotlin/l/b/a/b/e/a$p:aaZB	Lkotlin/l/b/a/b/h/d;
    //   320: aload_0
    //   321: invokevirtual 145	kotlin/l/b/a/b/e/a$p:HZ	()V
    //   324: ldc 95
    //   326: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: aload_1
    //   330: athrow
    //   331: iload_3
    //   332: istore 4
    //   334: iload_3
    //   335: iconst_1
    //   336: iand
    //   337: iconst_1
    //   338: if_icmpeq +28 -> 366
    //   341: iload_3
    //   342: istore 7
    //   344: iload_3
    //   345: istore 5
    //   347: iload_3
    //   348: istore 8
    //   350: aload_0
    //   351: new 147	java/util/ArrayList
    //   354: dup
    //   355: invokespecial 148	java/util/ArrayList:<init>	()V
    //   358: putfield 127	kotlin/l/b/a/b/e/a$p:aaZE	Ljava/util/List;
    //   361: iload_3
    //   362: iconst_1
    //   363: ior
    //   364: istore 4
    //   366: iload 4
    //   368: istore 7
    //   370: iload 4
    //   372: istore 5
    //   374: iload 4
    //   376: istore 8
    //   378: aload_0
    //   379: getfield 127	kotlin/l/b/a/b/e/a$p:aaZE	Ljava/util/List;
    //   382: aload_1
    //   383: getstatic 149	kotlin/l/b/a/b/e/a$p$a:aaZC	Lkotlin/l/b/a/b/h/t;
    //   386: aload_2
    //   387: invokevirtual 152	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   390: invokeinterface 158 2 0
    //   395: pop
    //   396: iload 4
    //   398: istore_3
    //   399: goto -358 -> 41
    //   402: astore_1
    //   403: iload 8
    //   405: istore 5
    //   407: new 92	kotlin/l/b/a/b/h/l
    //   410: dup
    //   411: aload_1
    //   412: invokevirtual 162	java/io/IOException:getMessage	()Ljava/lang/String;
    //   415: invokespecial 165	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   418: astore_1
    //   419: iload 8
    //   421: istore 5
    //   423: aload_1
    //   424: aload_0
    //   425: putfield 125	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   428: iload 8
    //   430: istore 5
    //   432: ldc 95
    //   434: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   437: iload 8
    //   439: istore 5
    //   441: aload_1
    //   442: athrow
    //   443: iload_3
    //   444: istore 7
    //   446: iload_3
    //   447: istore 5
    //   449: iload_3
    //   450: istore 8
    //   452: aload_0
    //   453: aload_0
    //   454: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   457: iconst_1
    //   458: ior
    //   459: putfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   462: iload_3
    //   463: istore 7
    //   465: iload_3
    //   466: istore 5
    //   468: iload_3
    //   469: istore 8
    //   471: aload_0
    //   472: aload_1
    //   473: invokevirtual 169	kotlin/l/b/a/b/h/e:AB	()Z
    //   476: putfield 171	kotlin/l/b/a/b/e/a$p:abcb	Z
    //   479: goto -438 -> 41
    //   482: iload_3
    //   483: istore 7
    //   485: iload_3
    //   486: istore 5
    //   488: iload_3
    //   489: istore 8
    //   491: aload_0
    //   492: aload_0
    //   493: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   496: iconst_2
    //   497: ior
    //   498: putfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   501: iload_3
    //   502: istore 7
    //   504: iload_3
    //   505: istore 5
    //   507: iload_3
    //   508: istore 8
    //   510: aload_0
    //   511: aload_1
    //   512: invokevirtual 119	kotlin/l/b/a/b/h/e:AK	()I
    //   515: putfield 173	kotlin/l/b/a/b/e/a$p:abcc	I
    //   518: goto -477 -> 41
    //   521: iload_3
    //   522: istore 7
    //   524: iload_3
    //   525: istore 5
    //   527: iload_3
    //   528: istore 8
    //   530: aload_0
    //   531: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   534: iconst_4
    //   535: iand
    //   536: iconst_4
    //   537: if_icmpne +816 -> 1353
    //   540: iload_3
    //   541: istore 7
    //   543: iload_3
    //   544: istore 5
    //   546: iload_3
    //   547: istore 8
    //   549: aload_0
    //   550: getfield 175	kotlin/l/b/a/b/e/a$p:abcd	Lkotlin/l/b/a/b/e/a$p;
    //   553: astore 9
    //   555: iload_3
    //   556: istore 7
    //   558: iload_3
    //   559: istore 5
    //   561: iload_3
    //   562: istore 8
    //   564: invokestatic 179	kotlin/l/b/a/b/e/a$p$b:iLJ	()Lkotlin/l/b/a/b/e/a$p$b;
    //   567: aload 9
    //   569: invokevirtual 183	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   572: astore 9
    //   574: iload_3
    //   575: istore 7
    //   577: iload_3
    //   578: istore 5
    //   580: iload_3
    //   581: istore 8
    //   583: aload_0
    //   584: aload_1
    //   585: getstatic 67	kotlin/l/b/a/b/e/a$p:aaZC	Lkotlin/l/b/a/b/h/t;
    //   588: aload_2
    //   589: invokevirtual 152	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   592: checkcast 2	kotlin/l/b/a/b/e/a$p
    //   595: putfield 175	kotlin/l/b/a/b/e/a$p:abcd	Lkotlin/l/b/a/b/e/a$p;
    //   598: aload 9
    //   600: ifnull +40 -> 640
    //   603: iload_3
    //   604: istore 7
    //   606: iload_3
    //   607: istore 5
    //   609: iload_3
    //   610: istore 8
    //   612: aload 9
    //   614: aload_0
    //   615: getfield 175	kotlin/l/b/a/b/e/a$p:abcd	Lkotlin/l/b/a/b/e/a$p;
    //   618: invokevirtual 183	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   621: pop
    //   622: iload_3
    //   623: istore 7
    //   625: iload_3
    //   626: istore 5
    //   628: iload_3
    //   629: istore 8
    //   631: aload_0
    //   632: aload 9
    //   634: invokevirtual 187	kotlin/l/b/a/b/e/a$p$b:iLI	()Lkotlin/l/b/a/b/e/a$p;
    //   637: putfield 175	kotlin/l/b/a/b/e/a$p:abcd	Lkotlin/l/b/a/b/e/a$p;
    //   640: iload_3
    //   641: istore 7
    //   643: iload_3
    //   644: istore 5
    //   646: iload_3
    //   647: istore 8
    //   649: aload_0
    //   650: aload_0
    //   651: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   654: iconst_4
    //   655: ior
    //   656: putfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   659: goto -618 -> 41
    //   662: iload_3
    //   663: istore 7
    //   665: iload_3
    //   666: istore 5
    //   668: iload_3
    //   669: istore 8
    //   671: aload_0
    //   672: aload_0
    //   673: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   676: bipush 16
    //   678: ior
    //   679: putfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   682: iload_3
    //   683: istore 7
    //   685: iload_3
    //   686: istore 5
    //   688: iload_3
    //   689: istore 8
    //   691: aload_0
    //   692: aload_1
    //   693: invokevirtual 119	kotlin/l/b/a/b/h/e:AK	()I
    //   696: putfield 189	kotlin/l/b/a/b/e/a$p:abcf	I
    //   699: goto -658 -> 41
    //   702: iload_3
    //   703: istore 7
    //   705: iload_3
    //   706: istore 5
    //   708: iload_3
    //   709: istore 8
    //   711: aload_0
    //   712: aload_0
    //   713: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   716: bipush 32
    //   718: ior
    //   719: putfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   722: iload_3
    //   723: istore 7
    //   725: iload_3
    //   726: istore 5
    //   728: iload_3
    //   729: istore 8
    //   731: aload_0
    //   732: aload_1
    //   733: invokevirtual 119	kotlin/l/b/a/b/h/e:AK	()I
    //   736: putfield 191	kotlin/l/b/a/b/e/a$p:abcg	I
    //   739: goto -698 -> 41
    //   742: iload_3
    //   743: istore 7
    //   745: iload_3
    //   746: istore 5
    //   748: iload_3
    //   749: istore 8
    //   751: aload_0
    //   752: aload_0
    //   753: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   756: bipush 8
    //   758: ior
    //   759: putfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   762: iload_3
    //   763: istore 7
    //   765: iload_3
    //   766: istore 5
    //   768: iload_3
    //   769: istore 8
    //   771: aload_0
    //   772: aload_1
    //   773: invokevirtual 119	kotlin/l/b/a/b/h/e:AK	()I
    //   776: putfield 193	kotlin/l/b/a/b/e/a$p:abce	I
    //   779: goto -738 -> 41
    //   782: iload_3
    //   783: istore 7
    //   785: iload_3
    //   786: istore 5
    //   788: iload_3
    //   789: istore 8
    //   791: aload_0
    //   792: aload_0
    //   793: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   796: bipush 64
    //   798: ior
    //   799: putfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   802: iload_3
    //   803: istore 7
    //   805: iload_3
    //   806: istore 5
    //   808: iload_3
    //   809: istore 8
    //   811: aload_0
    //   812: aload_1
    //   813: invokevirtual 119	kotlin/l/b/a/b/h/e:AK	()I
    //   816: putfield 195	kotlin/l/b/a/b/e/a$p:abch	I
    //   819: goto -778 -> 41
    //   822: iload_3
    //   823: istore 7
    //   825: iload_3
    //   826: istore 5
    //   828: iload_3
    //   829: istore 8
    //   831: aload_0
    //   832: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   835: sipush 256
    //   838: iand
    //   839: sipush 256
    //   842: if_icmpne +505 -> 1347
    //   845: iload_3
    //   846: istore 7
    //   848: iload_3
    //   849: istore 5
    //   851: iload_3
    //   852: istore 8
    //   854: aload_0
    //   855: getfield 197	kotlin/l/b/a/b/e/a$p:abcj	Lkotlin/l/b/a/b/e/a$p;
    //   858: astore 9
    //   860: iload_3
    //   861: istore 7
    //   863: iload_3
    //   864: istore 5
    //   866: iload_3
    //   867: istore 8
    //   869: invokestatic 179	kotlin/l/b/a/b/e/a$p$b:iLJ	()Lkotlin/l/b/a/b/e/a$p$b;
    //   872: aload 9
    //   874: invokevirtual 183	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   877: astore 9
    //   879: iload_3
    //   880: istore 7
    //   882: iload_3
    //   883: istore 5
    //   885: iload_3
    //   886: istore 8
    //   888: aload_0
    //   889: aload_1
    //   890: getstatic 67	kotlin/l/b/a/b/e/a$p:aaZC	Lkotlin/l/b/a/b/h/t;
    //   893: aload_2
    //   894: invokevirtual 152	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   897: checkcast 2	kotlin/l/b/a/b/e/a$p
    //   900: putfield 197	kotlin/l/b/a/b/e/a$p:abcj	Lkotlin/l/b/a/b/e/a$p;
    //   903: aload 9
    //   905: ifnull +40 -> 945
    //   908: iload_3
    //   909: istore 7
    //   911: iload_3
    //   912: istore 5
    //   914: iload_3
    //   915: istore 8
    //   917: aload 9
    //   919: aload_0
    //   920: getfield 197	kotlin/l/b/a/b/e/a$p:abcj	Lkotlin/l/b/a/b/e/a$p;
    //   923: invokevirtual 183	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   926: pop
    //   927: iload_3
    //   928: istore 7
    //   930: iload_3
    //   931: istore 5
    //   933: iload_3
    //   934: istore 8
    //   936: aload_0
    //   937: aload 9
    //   939: invokevirtual 187	kotlin/l/b/a/b/e/a$p$b:iLI	()Lkotlin/l/b/a/b/e/a$p;
    //   942: putfield 197	kotlin/l/b/a/b/e/a$p:abcj	Lkotlin/l/b/a/b/e/a$p;
    //   945: iload_3
    //   946: istore 7
    //   948: iload_3
    //   949: istore 5
    //   951: iload_3
    //   952: istore 8
    //   954: aload_0
    //   955: aload_0
    //   956: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   959: sipush 256
    //   962: ior
    //   963: putfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   966: goto -925 -> 41
    //   969: iload_3
    //   970: istore 7
    //   972: iload_3
    //   973: istore 5
    //   975: iload_3
    //   976: istore 8
    //   978: aload_0
    //   979: aload_0
    //   980: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   983: sipush 512
    //   986: ior
    //   987: putfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   990: iload_3
    //   991: istore 7
    //   993: iload_3
    //   994: istore 5
    //   996: iload_3
    //   997: istore 8
    //   999: aload_0
    //   1000: aload_1
    //   1001: invokevirtual 119	kotlin/l/b/a/b/h/e:AK	()I
    //   1004: putfield 199	kotlin/l/b/a/b/e/a$p:abck	I
    //   1007: goto -966 -> 41
    //   1010: iload_3
    //   1011: istore 7
    //   1013: iload_3
    //   1014: istore 5
    //   1016: iload_3
    //   1017: istore 8
    //   1019: aload_0
    //   1020: aload_0
    //   1021: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   1024: sipush 128
    //   1027: ior
    //   1028: putfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   1031: iload_3
    //   1032: istore 7
    //   1034: iload_3
    //   1035: istore 5
    //   1037: iload_3
    //   1038: istore 8
    //   1040: aload_0
    //   1041: aload_1
    //   1042: invokevirtual 119	kotlin/l/b/a/b/h/e:AK	()I
    //   1045: putfield 201	kotlin/l/b/a/b/e/a$p:abci	I
    //   1048: goto -1007 -> 41
    //   1051: iload_3
    //   1052: istore 7
    //   1054: iload_3
    //   1055: istore 5
    //   1057: iload_3
    //   1058: istore 8
    //   1060: aload_0
    //   1061: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   1064: sipush 1024
    //   1067: iand
    //   1068: sipush 1024
    //   1071: if_icmpne +270 -> 1341
    //   1074: iload_3
    //   1075: istore 7
    //   1077: iload_3
    //   1078: istore 5
    //   1080: iload_3
    //   1081: istore 8
    //   1083: aload_0
    //   1084: getfield 203	kotlin/l/b/a/b/e/a$p:abcl	Lkotlin/l/b/a/b/e/a$p;
    //   1087: astore 9
    //   1089: iload_3
    //   1090: istore 7
    //   1092: iload_3
    //   1093: istore 5
    //   1095: iload_3
    //   1096: istore 8
    //   1098: invokestatic 179	kotlin/l/b/a/b/e/a$p$b:iLJ	()Lkotlin/l/b/a/b/e/a$p$b;
    //   1101: aload 9
    //   1103: invokevirtual 183	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   1106: astore 9
    //   1108: iload_3
    //   1109: istore 7
    //   1111: iload_3
    //   1112: istore 5
    //   1114: iload_3
    //   1115: istore 8
    //   1117: aload_0
    //   1118: aload_1
    //   1119: getstatic 67	kotlin/l/b/a/b/e/a$p:aaZC	Lkotlin/l/b/a/b/h/t;
    //   1122: aload_2
    //   1123: invokevirtual 152	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   1126: checkcast 2	kotlin/l/b/a/b/e/a$p
    //   1129: putfield 203	kotlin/l/b/a/b/e/a$p:abcl	Lkotlin/l/b/a/b/e/a$p;
    //   1132: aload 9
    //   1134: ifnull +40 -> 1174
    //   1137: iload_3
    //   1138: istore 7
    //   1140: iload_3
    //   1141: istore 5
    //   1143: iload_3
    //   1144: istore 8
    //   1146: aload 9
    //   1148: aload_0
    //   1149: getfield 203	kotlin/l/b/a/b/e/a$p:abcl	Lkotlin/l/b/a/b/e/a$p;
    //   1152: invokevirtual 183	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   1155: pop
    //   1156: iload_3
    //   1157: istore 7
    //   1159: iload_3
    //   1160: istore 5
    //   1162: iload_3
    //   1163: istore 8
    //   1165: aload_0
    //   1166: aload 9
    //   1168: invokevirtual 187	kotlin/l/b/a/b/e/a$p$b:iLI	()Lkotlin/l/b/a/b/e/a$p;
    //   1171: putfield 203	kotlin/l/b/a/b/e/a$p:abcl	Lkotlin/l/b/a/b/e/a$p;
    //   1174: iload_3
    //   1175: istore 7
    //   1177: iload_3
    //   1178: istore 5
    //   1180: iload_3
    //   1181: istore 8
    //   1183: aload_0
    //   1184: aload_0
    //   1185: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   1188: sipush 1024
    //   1191: ior
    //   1192: putfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   1195: goto -1154 -> 41
    //   1198: iload_3
    //   1199: istore 7
    //   1201: iload_3
    //   1202: istore 5
    //   1204: iload_3
    //   1205: istore 8
    //   1207: aload_0
    //   1208: aload_0
    //   1209: getfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   1212: sipush 2048
    //   1215: ior
    //   1216: putfield 116	kotlin/l/b/a/b/e/a$p:bQS	I
    //   1219: iload_3
    //   1220: istore 7
    //   1222: iload_3
    //   1223: istore 5
    //   1225: iload_3
    //   1226: istore 8
    //   1228: aload_0
    //   1229: aload_1
    //   1230: invokevirtual 119	kotlin/l/b/a/b/h/e:AK	()I
    //   1233: putfield 205	kotlin/l/b/a/b/e/a$p:abcm	I
    //   1236: goto -1195 -> 41
    //   1239: iload_3
    //   1240: iconst_1
    //   1241: iand
    //   1242: iconst_1
    //   1243: if_icmpne +14 -> 1257
    //   1246: aload_0
    //   1247: aload_0
    //   1248: getfield 127	kotlin/l/b/a/b/e/a$p:aaZE	Ljava/util/List;
    //   1251: invokestatic 133	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1254: putfield 127	kotlin/l/b/a/b/e/a$p:aaZE	Ljava/util/List;
    //   1257: aload 11
    //   1259: invokevirtual 136	kotlin/l/b/a/b/h/f:flush	()V
    //   1262: aload_0
    //   1263: aload 10
    //   1265: invokevirtual 142	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   1268: putfield 89	kotlin/l/b/a/b/e/a$p:aaZB	Lkotlin/l/b/a/b/h/d;
    //   1271: aload_0
    //   1272: invokevirtual 145	kotlin/l/b/a/b/e/a$p:HZ	()V
    //   1275: ldc 95
    //   1277: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1280: return
    //   1281: astore_1
    //   1282: aload_0
    //   1283: aload 10
    //   1285: invokevirtual 142	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   1288: putfield 89	kotlin/l/b/a/b/e/a$p:aaZB	Lkotlin/l/b/a/b/h/d;
    //   1291: goto -20 -> 1271
    //   1294: astore_1
    //   1295: aload_0
    //   1296: aload 10
    //   1298: invokevirtual 142	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   1301: putfield 89	kotlin/l/b/a/b/e/a$p:aaZB	Lkotlin/l/b/a/b/h/d;
    //   1304: ldc 95
    //   1306: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1309: aload_1
    //   1310: athrow
    //   1311: astore_2
    //   1312: aload_0
    //   1313: aload 10
    //   1315: invokevirtual 142	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   1318: putfield 89	kotlin/l/b/a/b/e/a$p:aaZB	Lkotlin/l/b/a/b/h/d;
    //   1321: goto -1001 -> 320
    //   1324: astore_1
    //   1325: aload_0
    //   1326: aload 10
    //   1328: invokevirtual 142	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   1331: putfield 89	kotlin/l/b/a/b/e/a$p:aaZB	Lkotlin/l/b/a/b/h/d;
    //   1334: ldc 95
    //   1336: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1339: aload_1
    //   1340: athrow
    //   1341: aconst_null
    //   1342: astore 9
    //   1344: goto -236 -> 1108
    //   1347: aconst_null
    //   1348: astore 9
    //   1350: goto -471 -> 879
    //   1353: aconst_null
    //   1354: astore 9
    //   1356: goto -782 -> 574
    //   1359: goto -1167 -> 192
    //   1362: iconst_1
    //   1363: istore 6
    //   1365: goto -1324 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1368	0	this	p
    //   0	1368	1	parame	kotlin.l.b.a.b.h.e
    //   0	1368	2	paramg	kotlin.l.b.a.b.h.g
    //   40	1202	3	i	int
    //   59	338	4	j	int
    //   50	1174	5	k	int
    //   37	1327	6	m	int
    //   47	1174	7	n	int
    //   53	1174	8	i1	int
    //   553	802	9	localObject	Object
    //   26	1301	10	localb	kotlin.l.b.a.b.h.d.b
    //   34	1224	11	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	261	kotlin/l/b/a/b/h/l
    //   201	214	261	kotlin/l/b/a/b/h/l
    //   229	241	261	kotlin/l/b/a/b/h/l
    //   250	258	261	kotlin/l/b/a/b/h/l
    //   350	361	261	kotlin/l/b/a/b/h/l
    //   378	396	261	kotlin/l/b/a/b/h/l
    //   452	462	261	kotlin/l/b/a/b/h/l
    //   471	479	261	kotlin/l/b/a/b/h/l
    //   491	501	261	kotlin/l/b/a/b/h/l
    //   510	518	261	kotlin/l/b/a/b/h/l
    //   530	540	261	kotlin/l/b/a/b/h/l
    //   549	555	261	kotlin/l/b/a/b/h/l
    //   564	574	261	kotlin/l/b/a/b/h/l
    //   583	598	261	kotlin/l/b/a/b/h/l
    //   612	622	261	kotlin/l/b/a/b/h/l
    //   631	640	261	kotlin/l/b/a/b/h/l
    //   649	659	261	kotlin/l/b/a/b/h/l
    //   671	682	261	kotlin/l/b/a/b/h/l
    //   691	699	261	kotlin/l/b/a/b/h/l
    //   711	722	261	kotlin/l/b/a/b/h/l
    //   731	739	261	kotlin/l/b/a/b/h/l
    //   751	762	261	kotlin/l/b/a/b/h/l
    //   771	779	261	kotlin/l/b/a/b/h/l
    //   791	802	261	kotlin/l/b/a/b/h/l
    //   811	819	261	kotlin/l/b/a/b/h/l
    //   831	845	261	kotlin/l/b/a/b/h/l
    //   854	860	261	kotlin/l/b/a/b/h/l
    //   869	879	261	kotlin/l/b/a/b/h/l
    //   888	903	261	kotlin/l/b/a/b/h/l
    //   917	927	261	kotlin/l/b/a/b/h/l
    //   936	945	261	kotlin/l/b/a/b/h/l
    //   954	966	261	kotlin/l/b/a/b/h/l
    //   978	990	261	kotlin/l/b/a/b/h/l
    //   999	1007	261	kotlin/l/b/a/b/h/l
    //   1019	1031	261	kotlin/l/b/a/b/h/l
    //   1040	1048	261	kotlin/l/b/a/b/h/l
    //   1060	1074	261	kotlin/l/b/a/b/h/l
    //   1083	1089	261	kotlin/l/b/a/b/h/l
    //   1098	1108	261	kotlin/l/b/a/b/h/l
    //   1117	1132	261	kotlin/l/b/a/b/h/l
    //   1146	1156	261	kotlin/l/b/a/b/h/l
    //   1165	1174	261	kotlin/l/b/a/b/h/l
    //   1183	1195	261	kotlin/l/b/a/b/h/l
    //   1207	1219	261	kotlin/l/b/a/b/h/l
    //   1228	1236	261	kotlin/l/b/a/b/h/l
    //   55	61	286	finally
    //   201	214	286	finally
    //   229	241	286	finally
    //   250	258	286	finally
    //   266	271	286	finally
    //   275	280	286	finally
    //   284	286	286	finally
    //   350	361	286	finally
    //   378	396	286	finally
    //   407	419	286	finally
    //   423	428	286	finally
    //   432	437	286	finally
    //   441	443	286	finally
    //   452	462	286	finally
    //   471	479	286	finally
    //   491	501	286	finally
    //   510	518	286	finally
    //   530	540	286	finally
    //   549	555	286	finally
    //   564	574	286	finally
    //   583	598	286	finally
    //   612	622	286	finally
    //   631	640	286	finally
    //   649	659	286	finally
    //   671	682	286	finally
    //   691	699	286	finally
    //   711	722	286	finally
    //   731	739	286	finally
    //   751	762	286	finally
    //   771	779	286	finally
    //   791	802	286	finally
    //   811	819	286	finally
    //   831	845	286	finally
    //   854	860	286	finally
    //   869	879	286	finally
    //   888	903	286	finally
    //   917	927	286	finally
    //   936	945	286	finally
    //   954	966	286	finally
    //   978	990	286	finally
    //   999	1007	286	finally
    //   1019	1031	286	finally
    //   1040	1048	286	finally
    //   1060	1074	286	finally
    //   1083	1089	286	finally
    //   1098	1108	286	finally
    //   1117	1132	286	finally
    //   1146	1156	286	finally
    //   1165	1174	286	finally
    //   1183	1195	286	finally
    //   1207	1219	286	finally
    //   1228	1236	286	finally
    //   55	61	402	java/io/IOException
    //   201	214	402	java/io/IOException
    //   229	241	402	java/io/IOException
    //   250	258	402	java/io/IOException
    //   350	361	402	java/io/IOException
    //   378	396	402	java/io/IOException
    //   452	462	402	java/io/IOException
    //   471	479	402	java/io/IOException
    //   491	501	402	java/io/IOException
    //   510	518	402	java/io/IOException
    //   530	540	402	java/io/IOException
    //   549	555	402	java/io/IOException
    //   564	574	402	java/io/IOException
    //   583	598	402	java/io/IOException
    //   612	622	402	java/io/IOException
    //   631	640	402	java/io/IOException
    //   649	659	402	java/io/IOException
    //   671	682	402	java/io/IOException
    //   691	699	402	java/io/IOException
    //   711	722	402	java/io/IOException
    //   731	739	402	java/io/IOException
    //   751	762	402	java/io/IOException
    //   771	779	402	java/io/IOException
    //   791	802	402	java/io/IOException
    //   811	819	402	java/io/IOException
    //   831	845	402	java/io/IOException
    //   854	860	402	java/io/IOException
    //   869	879	402	java/io/IOException
    //   888	903	402	java/io/IOException
    //   917	927	402	java/io/IOException
    //   936	945	402	java/io/IOException
    //   954	966	402	java/io/IOException
    //   978	990	402	java/io/IOException
    //   999	1007	402	java/io/IOException
    //   1019	1031	402	java/io/IOException
    //   1040	1048	402	java/io/IOException
    //   1060	1074	402	java/io/IOException
    //   1083	1089	402	java/io/IOException
    //   1098	1108	402	java/io/IOException
    //   1117	1132	402	java/io/IOException
    //   1146	1156	402	java/io/IOException
    //   1165	1174	402	java/io/IOException
    //   1183	1195	402	java/io/IOException
    //   1207	1219	402	java/io/IOException
    //   1228	1236	402	java/io/IOException
    //   1257	1262	1281	java/io/IOException
    //   1257	1262	1294	finally
    //   306	311	1311	java/io/IOException
    //   306	311	1324	finally
  }
  
  private a$p(i.b<p, ?> paramb)
  {
    super(paramb);
    this.aaZB = paramb.aaZB;
  }
  
  public static b f(p paramp)
  {
    AppMethodBeat.i(293006);
    paramp = b.iLJ().j(paramp);
    AppMethodBeat.o(293006);
    return paramp;
  }
  
  private void iIN()
  {
    AppMethodBeat.i(58857);
    this.aaZE = Collections.emptyList();
    this.abcb = false;
    this.abcc = 0;
    this.abcd = abca;
    this.abce = 0;
    this.abcf = 0;
    this.abcg = 0;
    this.abch = 0;
    this.abci = 0;
    this.abcj = abca;
    this.abck = 0;
    this.abcl = abca;
    this.abcm = 0;
    this.aaZS = 0;
    AppMethodBeat.o(58857);
  }
  
  public static p iLm()
  {
    return abca;
  }
  
  public final int Ad()
  {
    int j = 0;
    AppMethodBeat.i(58860);
    int i = this.bXW;
    if (i != -1)
    {
      AppMethodBeat.o(58860);
      return i;
    }
    if ((this.bQS & 0x1000) == 4096) {
      i = f.bM(1, this.aaZS) + 0;
    }
    for (;;)
    {
      if (j < this.aaZE.size())
      {
        int k = f.c(2, (kotlin.l.b.a.b.h.r)this.aaZE.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        j = i;
        if ((this.bQS & 0x1) == 1) {
          j = i + (f.gL(3) + 1);
        }
        i = j;
        if ((this.bQS & 0x2) == 2) {
          i = j + f.bM(4, this.abcc);
        }
        j = i;
        if ((this.bQS & 0x4) == 4) {
          j = i + f.c(5, this.abcd);
        }
        i = j;
        if ((this.bQS & 0x10) == 16) {
          i = j + f.bM(6, this.abcf);
        }
        j = i;
        if ((this.bQS & 0x20) == 32) {
          j = i + f.bM(7, this.abcg);
        }
        i = j;
        if ((this.bQS & 0x8) == 8) {
          i = j + f.bM(8, this.abce);
        }
        j = i;
        if ((this.bQS & 0x40) == 64) {
          j = i + f.bM(9, this.abch);
        }
        i = j;
        if ((this.bQS & 0x100) == 256) {
          i = j + f.c(10, this.abcj);
        }
        j = i;
        if ((this.bQS & 0x200) == 512) {
          j = i + f.bM(11, this.abck);
        }
        i = j;
        if ((this.bQS & 0x80) == 128) {
          i = j + f.bM(12, this.abci);
        }
        j = i;
        if ((this.bQS & 0x400) == 1024) {
          j = i + f.c(13, this.abcl);
        }
        i = j;
        if ((this.bQS & 0x800) == 2048) {
          i = j + f.bM(14, this.abcm);
        }
        i = Ii() + i + this.aaZB.size();
        this.bXW = i;
        AppMethodBeat.o(58860);
        return i;
        i = 0;
      }
    }
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58859);
    Ad();
    i.c.a locala = iNU();
    if ((this.bQS & 0x1000) == 4096) {
      paramf.bJ(1, this.aaZS);
    }
    int i = 0;
    while (i < this.aaZE.size())
    {
      paramf.a(2, (kotlin.l.b.a.b.h.r)this.aaZE.get(i));
      i += 1;
    }
    if ((this.bQS & 0x1) == 1) {
      paramf.Jq(this.abcb);
    }
    if ((this.bQS & 0x2) == 2) {
      paramf.bJ(4, this.abcc);
    }
    if ((this.bQS & 0x4) == 4) {
      paramf.a(5, this.abcd);
    }
    if ((this.bQS & 0x10) == 16) {
      paramf.bJ(6, this.abcf);
    }
    if ((this.bQS & 0x20) == 32) {
      paramf.bJ(7, this.abcg);
    }
    if ((this.bQS & 0x8) == 8) {
      paramf.bJ(8, this.abce);
    }
    if ((this.bQS & 0x40) == 64) {
      paramf.bJ(9, this.abch);
    }
    if ((this.bQS & 0x100) == 256) {
      paramf.a(10, this.abcj);
    }
    if ((this.bQS & 0x200) == 512) {
      paramf.bJ(11, this.abck);
    }
    if ((this.bQS & 0x80) == 128) {
      paramf.bJ(12, this.abci);
    }
    if ((this.bQS & 0x400) == 1024) {
      paramf.a(13, this.abcl);
    }
    if ((this.bQS & 0x800) == 2048) {
      paramf.bJ(14, this.abcm);
    }
    locala.b(200, paramf);
    paramf.e(this.aaZB);
    AppMethodBeat.o(58859);
  }
  
  public final int getArgumentCount()
  {
    AppMethodBeat.i(58856);
    int i = this.aaZE.size();
    AppMethodBeat.o(58856);
    return i;
  }
  
  public final boolean iJj()
  {
    return (this.bQS & 0x1000) == 4096;
  }
  
  public final boolean iLn()
  {
    return (this.bQS & 0x1) == 1;
  }
  
  public final boolean iLo()
  {
    return (this.bQS & 0x2) == 2;
  }
  
  public final boolean iLp()
  {
    return (this.bQS & 0x4) == 4;
  }
  
  public final boolean iLq()
  {
    return (this.bQS & 0x8) == 8;
  }
  
  public final boolean iLr()
  {
    return (this.bQS & 0x10) == 16;
  }
  
  public final boolean iLs()
  {
    return (this.bQS & 0x20) == 32;
  }
  
  public final boolean iLt()
  {
    return (this.bQS & 0x40) == 64;
  }
  
  public final boolean iLu()
  {
    return (this.bQS & 0x80) == 128;
  }
  
  public final boolean iLv()
  {
    return (this.bQS & 0x100) == 256;
  }
  
  public final boolean iLw()
  {
    return (this.bQS & 0x200) == 512;
  }
  
  public final boolean iLx()
  {
    return (this.bQS & 0x400) == 1024;
  }
  
  public final boolean iLy()
  {
    return (this.bQS & 0x800) == 2048;
  }
  
  public final b iLz()
  {
    AppMethodBeat.i(293007);
    b localb = b.iLJ().j(this);
    AppMethodBeat.o(293007);
    return localb;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58858);
    int i = this.bRd;
    if (i == 1)
    {
      AppMethodBeat.o(58858);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58858);
      return false;
    }
    i = 0;
    while (i < getArgumentCount())
    {
      if (!((a)this.aaZE.get(i)).isInitialized())
      {
        this.bRd = 0;
        AppMethodBeat.o(58858);
        return false;
      }
      i += 1;
    }
    if ((iLp()) && (!this.abcd.isInitialized()))
    {
      this.bRd = 0;
      AppMethodBeat.o(58858);
      return false;
    }
    if ((iLv()) && (!this.abcj.isInitialized()))
    {
      this.bRd = 0;
      AppMethodBeat.o(58858);
      return false;
    }
    if ((iLx()) && (!this.abcl.isInitialized()))
    {
      this.bRd = 0;
      AppMethodBeat.o(58858);
      return false;
    }
    if (!Ig())
    {
      this.bRd = 0;
      AppMethodBeat.o(58858);
      return false;
    }
    this.bRd = 1;
    AppMethodBeat.o(58858);
    return true;
  }
  
  public static final class a
    extends i
    implements r
  {
    public static kotlin.l.b.a.b.h.t<a> aaZC;
    private static final a abcn;
    private final d aaZB;
    public a.p.a.b abco;
    public a.p abcp;
    public int abcq;
    private int bQS;
    private byte bRd = -1;
    private int bXW = -1;
    
    static
    {
      AppMethodBeat.i(58832);
      aaZC = new b() {};
      a locala = new a();
      abcn = locala;
      locala.iIN();
      AppMethodBeat.o(58832);
    }
    
    private a()
    {
      this.aaZB = d.abgb;
    }
    
    /* Error */
    private a(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 60	kotlin/l/b/a/b/h/i:<init>	()V
      //   4: ldc 77
      //   6: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 62	kotlin/l/b/a/b/e/a$p$a:bRd	B
      //   14: aload_0
      //   15: iconst_m1
      //   16: putfield 64	kotlin/l/b/a/b/e/a$p$a:bXW	I
      //   19: aload_0
      //   20: invokespecial 55	kotlin/l/b/a/b/e/a$p$a:iIN	()V
      //   23: invokestatic 81	kotlin/l/b/a/b/h/d:iNH	()Lkotlin/l/b/a/b/h/d$b;
      //   26: astore 7
      //   28: aload 7
      //   30: iconst_1
      //   31: invokestatic 87	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
      //   34: astore 8
      //   36: iconst_0
      //   37: istore_3
      //   38: iload_3
      //   39: ifne +281 -> 320
      //   42: aload_1
      //   43: invokevirtual 93	kotlin/l/b/a/b/h/e:Av	()I
      //   46: istore 4
      //   48: iload 4
      //   50: lookupswitch	default:+360->410, 0:+363->413, 8:+60->110, 18:+178->228, 24:+249->299
      //   93: aload_1
      //   94: aload 8
      //   96: aload_2
      //   97: iload 4
      //   99: invokevirtual 96	kotlin/l/b/a/b/e/a$p$a:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
      //   102: ifne -64 -> 38
      //   105: iconst_1
      //   106: istore_3
      //   107: goto -69 -> 38
      //   110: aload_1
      //   111: invokevirtual 99	kotlin/l/b/a/b/h/e:AK	()I
      //   114: istore 5
      //   116: iload 5
      //   118: invokestatic 103	kotlin/l/b/a/b/e/a$p$a$b:aEB	(I)Lkotlin/l/b/a/b/e/a$p$a$b;
      //   121: astore 6
      //   123: aload 6
      //   125: ifnonnull +59 -> 184
      //   128: aload 8
      //   130: iload 4
      //   132: invokevirtual 106	kotlin/l/b/a/b/h/f:hT	(I)V
      //   135: aload 8
      //   137: iload 5
      //   139: invokevirtual 106	kotlin/l/b/a/b/h/f:hT	(I)V
      //   142: goto -104 -> 38
      //   145: astore_1
      //   146: aload_1
      //   147: aload_0
      //   148: putfield 110	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
      //   151: ldc 77
      //   153: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   156: aload_1
      //   157: athrow
      //   158: astore_1
      //   159: aload 8
      //   161: invokevirtual 113	kotlin/l/b/a/b/h/f:flush	()V
      //   164: aload_0
      //   165: aload 7
      //   167: invokevirtual 119	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
      //   170: putfield 71	kotlin/l/b/a/b/e/a$p$a:aaZB	Lkotlin/l/b/a/b/h/d;
      //   173: aload_0
      //   174: invokevirtual 122	kotlin/l/b/a/b/e/a$p$a:HZ	()V
      //   177: ldc 77
      //   179: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   182: aload_1
      //   183: athrow
      //   184: aload_0
      //   185: aload_0
      //   186: getfield 124	kotlin/l/b/a/b/e/a$p$a:bQS	I
      //   189: iconst_1
      //   190: ior
      //   191: putfield 124	kotlin/l/b/a/b/e/a$p$a:bQS	I
      //   194: aload_0
      //   195: aload 6
      //   197: putfield 126	kotlin/l/b/a/b/e/a$p$a:abco	Lkotlin/l/b/a/b/e/a$p$a$b;
      //   200: goto -162 -> 38
      //   203: astore_1
      //   204: new 74	kotlin/l/b/a/b/h/l
      //   207: dup
      //   208: aload_1
      //   209: invokevirtual 130	java/io/IOException:getMessage	()Ljava/lang/String;
      //   212: invokespecial 133	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
      //   215: astore_1
      //   216: aload_1
      //   217: aload_0
      //   218: putfield 110	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
      //   221: ldc 77
      //   223: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   226: aload_1
      //   227: athrow
      //   228: aload_0
      //   229: getfield 124	kotlin/l/b/a/b/e/a$p$a:bQS	I
      //   232: iconst_2
      //   233: iand
      //   234: iconst_2
      //   235: if_icmpne +169 -> 404
      //   238: aload_0
      //   239: getfield 135	kotlin/l/b/a/b/e/a$p$a:abcp	Lkotlin/l/b/a/b/e/a$p;
      //   242: invokevirtual 139	kotlin/l/b/a/b/e/a$p:iLz	()Lkotlin/l/b/a/b/e/a$p$b;
      //   245: astore 6
      //   247: aload_0
      //   248: aload_1
      //   249: getstatic 140	kotlin/l/b/a/b/e/a$p:aaZC	Lkotlin/l/b/a/b/h/t;
      //   252: aload_2
      //   253: invokevirtual 143	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
      //   256: checkcast 8	kotlin/l/b/a/b/e/a$p
      //   259: putfield 135	kotlin/l/b/a/b/e/a$p$a:abcp	Lkotlin/l/b/a/b/e/a$p;
      //   262: aload 6
      //   264: ifnull +22 -> 286
      //   267: aload 6
      //   269: aload_0
      //   270: getfield 135	kotlin/l/b/a/b/e/a$p$a:abcp	Lkotlin/l/b/a/b/e/a$p;
      //   273: invokevirtual 149	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
      //   276: pop
      //   277: aload_0
      //   278: aload 6
      //   280: invokevirtual 153	kotlin/l/b/a/b/e/a$p$b:iLI	()Lkotlin/l/b/a/b/e/a$p;
      //   283: putfield 135	kotlin/l/b/a/b/e/a$p$a:abcp	Lkotlin/l/b/a/b/e/a$p;
      //   286: aload_0
      //   287: aload_0
      //   288: getfield 124	kotlin/l/b/a/b/e/a$p$a:bQS	I
      //   291: iconst_2
      //   292: ior
      //   293: putfield 124	kotlin/l/b/a/b/e/a$p$a:bQS	I
      //   296: goto -258 -> 38
      //   299: aload_0
      //   300: aload_0
      //   301: getfield 124	kotlin/l/b/a/b/e/a$p$a:bQS	I
      //   304: iconst_4
      //   305: ior
      //   306: putfield 124	kotlin/l/b/a/b/e/a$p$a:bQS	I
      //   309: aload_0
      //   310: aload_1
      //   311: invokevirtual 99	kotlin/l/b/a/b/h/e:AK	()I
      //   314: putfield 155	kotlin/l/b/a/b/e/a$p$a:abcq	I
      //   317: goto -279 -> 38
      //   320: aload 8
      //   322: invokevirtual 113	kotlin/l/b/a/b/h/f:flush	()V
      //   325: aload_0
      //   326: aload 7
      //   328: invokevirtual 119	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
      //   331: putfield 71	kotlin/l/b/a/b/e/a$p$a:aaZB	Lkotlin/l/b/a/b/h/d;
      //   334: aload_0
      //   335: invokevirtual 122	kotlin/l/b/a/b/e/a$p$a:HZ	()V
      //   338: ldc 77
      //   340: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   343: return
      //   344: astore_1
      //   345: aload_0
      //   346: aload 7
      //   348: invokevirtual 119	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
      //   351: putfield 71	kotlin/l/b/a/b/e/a$p$a:aaZB	Lkotlin/l/b/a/b/h/d;
      //   354: goto -20 -> 334
      //   357: astore_1
      //   358: aload_0
      //   359: aload 7
      //   361: invokevirtual 119	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
      //   364: putfield 71	kotlin/l/b/a/b/e/a$p$a:aaZB	Lkotlin/l/b/a/b/h/d;
      //   367: ldc 77
      //   369: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   372: aload_1
      //   373: athrow
      //   374: astore_2
      //   375: aload_0
      //   376: aload 7
      //   378: invokevirtual 119	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
      //   381: putfield 71	kotlin/l/b/a/b/e/a$p$a:aaZB	Lkotlin/l/b/a/b/h/d;
      //   384: goto -211 -> 173
      //   387: astore_1
      //   388: aload_0
      //   389: aload 7
      //   391: invokevirtual 119	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
      //   394: putfield 71	kotlin/l/b/a/b/e/a$p$a:aaZB	Lkotlin/l/b/a/b/h/d;
      //   397: ldc 77
      //   399: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   402: aload_1
      //   403: athrow
      //   404: aconst_null
      //   405: astore 6
      //   407: goto -160 -> 247
      //   410: goto -318 -> 92
      //   413: iconst_1
      //   414: istore_3
      //   415: goto -377 -> 38
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	418	0	this	a
      //   0	418	1	parame	kotlin.l.b.a.b.h.e
      //   0	418	2	paramg	kotlin.l.b.a.b.h.g
      //   37	378	3	i	int
      //   46	85	4	j	int
      //   114	24	5	k	int
      //   121	285	6	localObject	Object
      //   26	364	7	localb	kotlin.l.b.a.b.h.d.b
      //   34	287	8	localf	f
      // Exception table:
      //   from	to	target	type
      //   42	48	145	kotlin/l/b/a/b/h/l
      //   92	105	145	kotlin/l/b/a/b/h/l
      //   110	123	145	kotlin/l/b/a/b/h/l
      //   128	142	145	kotlin/l/b/a/b/h/l
      //   184	200	145	kotlin/l/b/a/b/h/l
      //   228	247	145	kotlin/l/b/a/b/h/l
      //   247	262	145	kotlin/l/b/a/b/h/l
      //   267	286	145	kotlin/l/b/a/b/h/l
      //   286	296	145	kotlin/l/b/a/b/h/l
      //   299	317	145	kotlin/l/b/a/b/h/l
      //   42	48	158	finally
      //   92	105	158	finally
      //   110	123	158	finally
      //   128	142	158	finally
      //   146	158	158	finally
      //   184	200	158	finally
      //   204	228	158	finally
      //   228	247	158	finally
      //   247	262	158	finally
      //   267	286	158	finally
      //   286	296	158	finally
      //   299	317	158	finally
      //   42	48	203	java/io/IOException
      //   92	105	203	java/io/IOException
      //   110	123	203	java/io/IOException
      //   128	142	203	java/io/IOException
      //   184	200	203	java/io/IOException
      //   228	247	203	java/io/IOException
      //   247	262	203	java/io/IOException
      //   267	286	203	java/io/IOException
      //   286	296	203	java/io/IOException
      //   299	317	203	java/io/IOException
      //   320	325	344	java/io/IOException
      //   320	325	357	finally
      //   159	164	374	java/io/IOException
      //   159	164	387	finally
    }
    
    private a(i.a parama)
    {
      super();
      this.aaZB = parama.aaZB;
    }
    
    private void iIN()
    {
      AppMethodBeat.i(58826);
      this.abco = a.p.a.b.abct;
      this.abcp = a.p.iLm();
      this.abcq = 0;
      AppMethodBeat.o(58826);
    }
    
    public static a iLA()
    {
      return abcn;
    }
    
    public final int Ad()
    {
      AppMethodBeat.i(58829);
      int i = this.bXW;
      if (i != -1)
      {
        AppMethodBeat.o(58829);
        return i;
      }
      int j = 0;
      if ((this.bQS & 0x1) == 1) {
        j = f.bO(1, this.abco.value) + 0;
      }
      i = j;
      if ((this.bQS & 0x2) == 2) {
        i = j + f.c(2, this.abcp);
      }
      j = i;
      if ((this.bQS & 0x4) == 4) {
        j = i + f.bM(3, this.abcq);
      }
      i = j + this.aaZB.size();
      this.bXW = i;
      AppMethodBeat.o(58829);
      return i;
    }
    
    public final boolean DQ()
    {
      return (this.bQS & 0x2) == 2;
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(58828);
      Ad();
      if ((this.bQS & 0x1) == 1) {
        paramf.ox(1, this.abco.value);
      }
      if ((this.bQS & 0x2) == 2) {
        paramf.a(2, this.abcp);
      }
      if ((this.bQS & 0x4) == 4) {
        paramf.bJ(3, this.abcq);
      }
      paramf.e(this.aaZB);
      AppMethodBeat.o(58828);
    }
    
    public final boolean iLB()
    {
      return (this.bQS & 0x1) == 1;
    }
    
    public final boolean iLC()
    {
      return (this.bQS & 0x4) == 4;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58827);
      int i = this.bRd;
      if (i == 1)
      {
        AppMethodBeat.o(58827);
        return true;
      }
      if (i == 0)
      {
        AppMethodBeat.o(58827);
        return false;
      }
      if ((DQ()) && (!this.abcp.isInitialized()))
      {
        this.bRd = 0;
        AppMethodBeat.o(58827);
        return false;
      }
      this.bRd = 1;
      AppMethodBeat.o(58827);
      return true;
    }
    
    public static final class a
      extends i.a<a.p.a, a>
      implements r
    {
      private a.p.a.b abco;
      private a.p abcp;
      private int abcq;
      private int bQS;
      
      private a()
      {
        AppMethodBeat.i(58803);
        this.abco = a.p.a.b.abct;
        this.abcp = a.p.iLm();
        AppMethodBeat.o(58803);
      }
      
      private a a(a.p.a.b paramb)
      {
        AppMethodBeat.i(58809);
        if (paramb == null)
        {
          paramb = new NullPointerException();
          AppMethodBeat.o(58809);
          throw paramb;
        }
        this.bQS |= 0x1;
        this.abco = paramb;
        AppMethodBeat.o(58809);
        return this;
      }
      
      private a aEA(int paramInt)
      {
        this.bQS |= 0x4;
        this.abcq = paramInt;
        return this;
      }
      
      private a i(a.p paramp)
      {
        AppMethodBeat.i(58810);
        if (((this.bQS & 0x2) == 2) && (this.abcp != a.p.iLm())) {}
        for (this.abcp = a.p.f(this.abcp).j(paramp).iLI();; this.abcp = paramp)
        {
          this.bQS |= 0x2;
          AppMethodBeat.o(58810);
          return this;
        }
      }
      
      private a iLD()
      {
        AppMethodBeat.i(58804);
        a locala = new a().b(iLE());
        AppMethodBeat.o(58804);
        return locala;
      }
      
      private a.p.a iLE()
      {
        int j = 1;
        AppMethodBeat.i(58805);
        a.p.a locala = new a.p.a(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          a.p.a.a(locala, this.abco);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          a.p.a.a(locala, this.abcp);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          a.p.a.a(locala, this.abcq);
          a.p.a.b(locala, j);
          AppMethodBeat.o(58805);
          return locala;
          j = 0;
        }
      }
      
      /* Error */
      private a t(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
      {
        // Byte code:
        //   0: ldc 109
        //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 113	kotlin/l/b/a/b/e/a$p$a:aaZC	Lkotlin/l/b/a/b/h/t;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 118 3 0
        //   17: checkcast 14	kotlin/l/b/a/b/e/a$p$a
        //   20: astore_1
        //   21: aload_0
        //   22: aload_1
        //   23: invokevirtual 87	kotlin/l/b/a/b/e/a$p$a$a:b	(Lkotlin/l/b/a/b/e/a$p$a;)Lkotlin/l/b/a/b/e/a$p$a$a;
        //   26: pop
        //   27: ldc 109
        //   29: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   32: aload_0
        //   33: areturn
        //   34: astore_1
        //   35: aload_1
        //   36: getfield 122	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
        //   39: checkcast 14	kotlin/l/b/a/b/e/a$p$a
        //   42: astore_2
        //   43: ldc 109
        //   45: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   48: aload_1
        //   49: athrow
        //   50: astore_1
        //   51: aload_2
        //   52: ifnull +9 -> 61
        //   55: aload_0
        //   56: aload_2
        //   57: invokevirtual 87	kotlin/l/b/a/b/e/a$p$a$a:b	(Lkotlin/l/b/a/b/e/a$p$a;)Lkotlin/l/b/a/b/e/a$p$a$a;
        //   60: pop
        //   61: ldc 109
        //   63: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
        //   7	21	34	kotlin/l/b/a/b/h/l
        //   43	50	50	finally
        //   7	21	68	finally
        //   35	43	68	finally
      }
      
      public final a b(a.p.a parama)
      {
        AppMethodBeat.i(58806);
        if (parama == a.p.a.iLA())
        {
          AppMethodBeat.o(58806);
          return this;
        }
        if (parama.iLB()) {
          a(parama.abco);
        }
        if (parama.DQ()) {
          i(parama.abcp);
        }
        if (parama.iLC()) {
          aEA(parama.abcq);
        }
        this.aaZB = this.aaZB.a(a.p.a.a(parama));
        AppMethodBeat.o(58806);
        return this;
      }
      
      public final boolean isInitialized()
      {
        AppMethodBeat.i(58807);
        if ((this.bQS & 0x2) == 2) {}
        for (int i = 1; (i != 0) && (!this.abcp.isInitialized()); i = 0)
        {
          AppMethodBeat.o(58807);
          return false;
        }
        AppMethodBeat.o(58807);
        return true;
      }
    }
  }
  
  public static final class b
    extends i.b<a.p, b>
    implements t
  {
    private List<a.p.a> aaZE;
    private int aaZS;
    private boolean abcb;
    private int abcc;
    private a.p abcd;
    private int abce;
    private int abcf;
    private int abcg;
    private int abch;
    private int abci;
    private a.p abcj;
    private int abck;
    private a.p abcl;
    private int abcm;
    private int bQS;
    
    private b()
    {
      AppMethodBeat.i(58833);
      this.aaZE = Collections.emptyList();
      this.abcd = a.p.iLm();
      this.abcj = a.p.iLm();
      this.abcl = a.p.iLm();
      AppMethodBeat.o(58833);
    }
    
    private b aEC(int paramInt)
    {
      this.bQS |= 0x4;
      this.abcc = paramInt;
      return this;
    }
    
    private b aED(int paramInt)
    {
      this.bQS |= 0x10;
      this.abce = paramInt;
      return this;
    }
    
    private b aEE(int paramInt)
    {
      this.bQS |= 0x20;
      this.abcf = paramInt;
      return this;
    }
    
    private b aEF(int paramInt)
    {
      this.bQS |= 0x40;
      this.abcg = paramInt;
      return this;
    }
    
    private b aEG(int paramInt)
    {
      this.bQS |= 0x80;
      this.abch = paramInt;
      return this;
    }
    
    private b aEH(int paramInt)
    {
      this.bQS |= 0x100;
      this.abci = paramInt;
      return this;
    }
    
    private b aEI(int paramInt)
    {
      this.bQS |= 0x400;
      this.abck = paramInt;
      return this;
    }
    
    private b aEJ(int paramInt)
    {
      this.bQS |= 0x1000;
      this.abcm = paramInt;
      return this;
    }
    
    private b aEK(int paramInt)
    {
      this.bQS |= 0x2000;
      this.aaZS = paramInt;
      return this;
    }
    
    private void iJq()
    {
      AppMethodBeat.i(58840);
      if ((this.bQS & 0x1) != 1)
      {
        this.aaZE = new ArrayList(this.aaZE);
        this.bQS |= 0x1;
      }
      AppMethodBeat.o(58840);
    }
    
    private b iLG()
    {
      AppMethodBeat.i(58834);
      b localb = new b().j(iLI());
      AppMethodBeat.o(58834);
      return localb;
    }
    
    private b k(a.p paramp)
    {
      AppMethodBeat.i(58841);
      if (((this.bQS & 0x8) == 8) && (this.abcd != a.p.iLm())) {}
      for (this.abcd = a.p.f(this.abcd).j(paramp).iLI();; this.abcd = paramp)
      {
        this.bQS |= 0x8;
        AppMethodBeat.o(58841);
        return this;
      }
    }
    
    private b l(a.p paramp)
    {
      AppMethodBeat.i(58842);
      if (((this.bQS & 0x200) == 512) && (this.abcj != a.p.iLm())) {}
      for (this.abcj = a.p.f(this.abcj).j(paramp).iLI();; this.abcj = paramp)
      {
        this.bQS |= 0x200;
        AppMethodBeat.o(58842);
        return this;
      }
    }
    
    private b m(a.p paramp)
    {
      AppMethodBeat.i(58843);
      if (((this.bQS & 0x800) == 2048) && (this.abcl != a.p.iLm())) {}
      for (this.abcl = a.p.f(this.abcl).j(paramp).iLI();; this.abcl = paramp)
      {
        this.bQS |= 0x800;
        AppMethodBeat.o(58843);
        return this;
      }
    }
    
    /* Error */
    private b u(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 130
      //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 134	kotlin/l/b/a/b/e/a$p:aaZC	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 140 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$p
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 114	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
      //   26: pop
      //   27: ldc 130
      //   29: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 144	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
      //   39: checkcast 9	kotlin/l/b/a/b/e/a$p
      //   42: astore_2
      //   43: ldc 130
      //   45: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 114	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
      //   60: pop
      //   61: ldc 130
      //   63: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: aload_1
      //   67: athrow
      //   68: astore_1
      //   69: aload_3
      //   70: astore_2
      //   71: goto -20 -> 51
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	b
      //   0	74	1	parame	kotlin.l.b.a.b.h.e
      //   0	74	2	paramg	kotlin.l.b.a.b.h.g
      //   6	64	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	kotlin/l/b/a/b/h/l
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final b Jo(boolean paramBoolean)
    {
      this.bQS |= 0x2;
      this.abcb = paramBoolean;
      return this;
    }
    
    public final a.p iLH()
    {
      AppMethodBeat.i(58835);
      Object localObject = iLI();
      if (!((a.p)localObject).isInitialized())
      {
        localObject = new x();
        AppMethodBeat.o(58835);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(58835);
      return localObject;
    }
    
    public final a.p iLI()
    {
      int j = 1;
      AppMethodBeat.i(58836);
      a.p localp = new a.p(this, (byte)0);
      int k = this.bQS;
      if ((this.bQS & 0x1) == 1)
      {
        this.aaZE = Collections.unmodifiableList(this.aaZE);
        this.bQS &= 0xFFFFFFFE;
      }
      a.p.a(localp, this.aaZE);
      if ((k & 0x2) == 2) {}
      for (;;)
      {
        a.p.a(localp, this.abcb);
        int i = j;
        if ((k & 0x4) == 4) {
          i = j | 0x2;
        }
        a.p.a(localp, this.abcc);
        j = i;
        if ((k & 0x8) == 8) {
          j = i | 0x4;
        }
        a.p.a(localp, this.abcd);
        i = j;
        if ((k & 0x10) == 16) {
          i = j | 0x8;
        }
        a.p.b(localp, this.abce);
        j = i;
        if ((k & 0x20) == 32) {
          j = i | 0x10;
        }
        a.p.c(localp, this.abcf);
        i = j;
        if ((k & 0x40) == 64) {
          i = j | 0x20;
        }
        a.p.d(localp, this.abcg);
        j = i;
        if ((k & 0x80) == 128) {
          j = i | 0x40;
        }
        a.p.e(localp, this.abch);
        i = j;
        if ((k & 0x100) == 256) {
          i = j | 0x80;
        }
        a.p.f(localp, this.abci);
        j = i;
        if ((k & 0x200) == 512) {
          j = i | 0x100;
        }
        a.p.b(localp, this.abcj);
        i = j;
        if ((k & 0x400) == 1024) {
          i = j | 0x200;
        }
        a.p.g(localp, this.abck);
        j = i;
        if ((k & 0x800) == 2048) {
          j = i | 0x400;
        }
        a.p.c(localp, this.abcl);
        i = j;
        if ((k & 0x1000) == 4096) {
          i = j | 0x800;
        }
        a.p.h(localp, this.abcm);
        j = i;
        if ((k & 0x2000) == 8192) {
          j = i | 0x1000;
        }
        a.p.i(localp, this.aaZS);
        a.p.j(localp, j);
        AppMethodBeat.o(58836);
        return localp;
        j = 0;
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58838);
      int i = 0;
      while (i < this.aaZE.size())
      {
        if (!((a.p.a)this.aaZE.get(i)).isInitialized())
        {
          AppMethodBeat.o(58838);
          return false;
        }
        i += 1;
      }
      if ((this.bQS & 0x8) == 8) {}
      for (i = 1; (i != 0) && (!this.abcd.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58838);
        return false;
      }
      if ((this.bQS & 0x200) == 512) {}
      for (i = 1; (i != 0) && (!this.abcj.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58838);
        return false;
      }
      if ((this.bQS & 0x800) == 2048) {}
      for (i = 1; (i != 0) && (!this.abcl.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58838);
        return false;
      }
      if (!Ig())
      {
        AppMethodBeat.o(58838);
        return false;
      }
      AppMethodBeat.o(58838);
      return true;
    }
    
    public final b j(a.p paramp)
    {
      AppMethodBeat.i(58837);
      if (paramp == a.p.iLm())
      {
        AppMethodBeat.o(58837);
        return this;
      }
      if (!a.p.g(paramp).isEmpty())
      {
        if (!this.aaZE.isEmpty()) {
          break label297;
        }
        this.aaZE = a.p.g(paramp);
        this.bQS &= 0xFFFFFFFE;
      }
      for (;;)
      {
        if (paramp.iLn()) {
          Jo(paramp.abcb);
        }
        if (paramp.iLo()) {
          aEC(paramp.abcc);
        }
        if (paramp.iLp()) {
          k(paramp.abcd);
        }
        if (paramp.iLq()) {
          aED(paramp.abce);
        }
        if (paramp.iLr()) {
          aEE(paramp.abcf);
        }
        if (paramp.iLs()) {
          aEF(paramp.abcg);
        }
        if (paramp.iLt()) {
          aEG(paramp.abch);
        }
        if (paramp.iLu()) {
          aEH(paramp.abci);
        }
        if (paramp.iLv()) {
          l(paramp.abcj);
        }
        if (paramp.iLw()) {
          aEI(paramp.abck);
        }
        if (paramp.iLx()) {
          m(paramp.abcl);
        }
        if (paramp.iLy()) {
          aEJ(paramp.abcm);
        }
        if (paramp.iJj()) {
          aEK(paramp.aaZS);
        }
        a(paramp);
        this.aaZB = this.aaZB.a(a.p.h(paramp));
        AppMethodBeat.o(58837);
        return this;
        label297:
        iJq();
        this.aaZE.addAll(a.p.g(paramp));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.p
 * JD-Core Version:    0.7.0.1
 */