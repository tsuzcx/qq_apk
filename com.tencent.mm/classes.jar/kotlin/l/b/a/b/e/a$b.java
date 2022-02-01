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

public final class a$b
  extends i.c<b>
  implements e
{
  public static t<b> aaZC;
  private static final b abai;
  private final d aaZB;
  public int aaZS;
  public a.v abaA;
  public int abaj;
  public int abak;
  public List<a.r> abal;
  public List<a.p> abam;
  public List<Integer> aban;
  private int abao = -1;
  public List<Integer> abap;
  private int abaq = -1;
  public List<a.c> abar;
  public List<a.h> abas;
  public List<a.m> abat;
  public List<a.q> abau;
  public List<a.f> abav;
  public List<Integer> abaw;
  private int abax = -1;
  public a.s abay;
  public List<Integer> abaz;
  private int bQS;
  private byte bRd = -1;
  private int bXW = -1;
  
  static
  {
    AppMethodBeat.i(58434);
    aaZC = new b() {};
    b localb = new b();
    abai = localb;
    localb.iIN();
    AppMethodBeat.o(58434);
  }
  
  private a$b()
  {
    this.aaZB = d.abgb;
  }
  
  /* Error */
  private a$b(kotlin.l.b.a.b.h.e parame, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 84	kotlin/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 107
    //   6: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 86	kotlin/l/b/a/b/e/a$b:abao	I
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 88	kotlin/l/b/a/b/e/a$b:abaq	I
    //   19: aload_0
    //   20: iconst_m1
    //   21: putfield 90	kotlin/l/b/a/b/e/a$b:abax	I
    //   24: aload_0
    //   25: iconst_m1
    //   26: putfield 92	kotlin/l/b/a/b/e/a$b:bRd	B
    //   29: aload_0
    //   30: iconst_m1
    //   31: putfield 94	kotlin/l/b/a/b/e/a$b:bXW	I
    //   34: aload_0
    //   35: invokespecial 79	kotlin/l/b/a/b/e/a$b:iIN	()V
    //   38: iconst_0
    //   39: istore_3
    //   40: invokestatic 111	kotlin/l/b/a/b/h/d:iNH	()Lkotlin/l/b/a/b/h/d$b;
    //   43: astore 11
    //   45: aload 11
    //   47: iconst_1
    //   48: invokestatic 117	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   51: astore 12
    //   53: iconst_0
    //   54: istore 8
    //   56: iload 8
    //   58: ifne +2377 -> 2435
    //   61: iload_3
    //   62: istore 5
    //   64: iload_3
    //   65: istore 4
    //   67: iload_3
    //   68: istore 6
    //   70: aload_1
    //   71: invokevirtual 123	kotlin/l/b/a/b/h/e:Av	()I
    //   74: istore 7
    //   76: iload 7
    //   78: lookupswitch	default:+2687->2765, 0:+2690->2768, 8:+206->284, 16:+541->619, 18:+655->733, 24:+806->884, 32:+845->923, 42:+884->962, 50:+958->1036, 56:+1032->1110, 58:+1105->1183, 66:+1256->1334, 74:+1333->1411, 82:+1410->1488, 90:+1487->1565, 106:+1564->1642, 128:+1641->1719, 130:+1717->1795, 242:+1871->1949, 248:+1999->2077, 250:+2075->2153, 258:+2229->2307
    //   257: istore 5
    //   259: iload_3
    //   260: istore 4
    //   262: iload_3
    //   263: istore 6
    //   265: aload_0
    //   266: aload_1
    //   267: aload 12
    //   269: aload_2
    //   270: iload 7
    //   272: invokevirtual 126	kotlin/l/b/a/b/e/a$b:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   275: ifne -219 -> 56
    //   278: iconst_1
    //   279: istore 8
    //   281: goto -225 -> 56
    //   284: iload_3
    //   285: istore 5
    //   287: iload_3
    //   288: istore 4
    //   290: iload_3
    //   291: istore 6
    //   293: aload_0
    //   294: aload_0
    //   295: getfield 128	kotlin/l/b/a/b/e/a$b:bQS	I
    //   298: iconst_1
    //   299: ior
    //   300: putfield 128	kotlin/l/b/a/b/e/a$b:bQS	I
    //   303: iload_3
    //   304: istore 5
    //   306: iload_3
    //   307: istore 4
    //   309: iload_3
    //   310: istore 6
    //   312: aload_0
    //   313: aload_1
    //   314: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   317: putfield 133	kotlin/l/b/a/b/e/a$b:aaZS	I
    //   320: goto -264 -> 56
    //   323: astore_1
    //   324: iload 5
    //   326: istore 4
    //   328: aload_1
    //   329: aload_0
    //   330: putfield 137	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   333: iload 5
    //   335: istore 4
    //   337: ldc 107
    //   339: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: iload 5
    //   344: istore 4
    //   346: aload_1
    //   347: athrow
    //   348: astore_1
    //   349: iload 4
    //   351: bipush 32
    //   353: iand
    //   354: bipush 32
    //   356: if_icmpne +14 -> 370
    //   359: aload_0
    //   360: aload_0
    //   361: getfield 139	kotlin/l/b/a/b/e/a$b:aban	Ljava/util/List;
    //   364: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   367: putfield 139	kotlin/l/b/a/b/e/a$b:aban	Ljava/util/List;
    //   370: iload 4
    //   372: bipush 8
    //   374: iand
    //   375: bipush 8
    //   377: if_icmpne +14 -> 391
    //   380: aload_0
    //   381: aload_0
    //   382: getfield 147	kotlin/l/b/a/b/e/a$b:abal	Ljava/util/List;
    //   385: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   388: putfield 147	kotlin/l/b/a/b/e/a$b:abal	Ljava/util/List;
    //   391: iload 4
    //   393: bipush 16
    //   395: iand
    //   396: bipush 16
    //   398: if_icmpne +14 -> 412
    //   401: aload_0
    //   402: aload_0
    //   403: getfield 149	kotlin/l/b/a/b/e/a$b:abam	Ljava/util/List;
    //   406: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   409: putfield 149	kotlin/l/b/a/b/e/a$b:abam	Ljava/util/List;
    //   412: iload 4
    //   414: bipush 64
    //   416: iand
    //   417: bipush 64
    //   419: if_icmpne +14 -> 433
    //   422: aload_0
    //   423: aload_0
    //   424: getfield 151	kotlin/l/b/a/b/e/a$b:abap	Ljava/util/List;
    //   427: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   430: putfield 151	kotlin/l/b/a/b/e/a$b:abap	Ljava/util/List;
    //   433: iload 4
    //   435: sipush 128
    //   438: iand
    //   439: sipush 128
    //   442: if_icmpne +14 -> 456
    //   445: aload_0
    //   446: aload_0
    //   447: getfield 153	kotlin/l/b/a/b/e/a$b:abar	Ljava/util/List;
    //   450: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   453: putfield 153	kotlin/l/b/a/b/e/a$b:abar	Ljava/util/List;
    //   456: iload 4
    //   458: sipush 256
    //   461: iand
    //   462: sipush 256
    //   465: if_icmpne +14 -> 479
    //   468: aload_0
    //   469: aload_0
    //   470: getfield 155	kotlin/l/b/a/b/e/a$b:abas	Ljava/util/List;
    //   473: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   476: putfield 155	kotlin/l/b/a/b/e/a$b:abas	Ljava/util/List;
    //   479: iload 4
    //   481: sipush 512
    //   484: iand
    //   485: sipush 512
    //   488: if_icmpne +14 -> 502
    //   491: aload_0
    //   492: aload_0
    //   493: getfield 157	kotlin/l/b/a/b/e/a$b:abat	Ljava/util/List;
    //   496: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   499: putfield 157	kotlin/l/b/a/b/e/a$b:abat	Ljava/util/List;
    //   502: iload 4
    //   504: sipush 1024
    //   507: iand
    //   508: sipush 1024
    //   511: if_icmpne +14 -> 525
    //   514: aload_0
    //   515: aload_0
    //   516: getfield 159	kotlin/l/b/a/b/e/a$b:abau	Ljava/util/List;
    //   519: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   522: putfield 159	kotlin/l/b/a/b/e/a$b:abau	Ljava/util/List;
    //   525: iload 4
    //   527: sipush 2048
    //   530: iand
    //   531: sipush 2048
    //   534: if_icmpne +14 -> 548
    //   537: aload_0
    //   538: aload_0
    //   539: getfield 161	kotlin/l/b/a/b/e/a$b:abav	Ljava/util/List;
    //   542: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   545: putfield 161	kotlin/l/b/a/b/e/a$b:abav	Ljava/util/List;
    //   548: iload 4
    //   550: sipush 4096
    //   553: iand
    //   554: sipush 4096
    //   557: if_icmpne +14 -> 571
    //   560: aload_0
    //   561: aload_0
    //   562: getfield 163	kotlin/l/b/a/b/e/a$b:abaw	Ljava/util/List;
    //   565: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   568: putfield 163	kotlin/l/b/a/b/e/a$b:abaw	Ljava/util/List;
    //   571: iload 4
    //   573: sipush 16384
    //   576: iand
    //   577: sipush 16384
    //   580: if_icmpne +14 -> 594
    //   583: aload_0
    //   584: aload_0
    //   585: getfield 165	kotlin/l/b/a/b/e/a$b:abaz	Ljava/util/List;
    //   588: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   591: putfield 165	kotlin/l/b/a/b/e/a$b:abaz	Ljava/util/List;
    //   594: aload 12
    //   596: invokevirtual 168	kotlin/l/b/a/b/h/f:flush	()V
    //   599: aload_0
    //   600: aload 11
    //   602: invokevirtual 174	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   605: putfield 101	kotlin/l/b/a/b/e/a$b:aaZB	Lkotlin/l/b/a/b/h/d;
    //   608: aload_0
    //   609: invokevirtual 177	kotlin/l/b/a/b/e/a$b:HZ	()V
    //   612: ldc 107
    //   614: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   617: aload_1
    //   618: athrow
    //   619: iload_3
    //   620: istore 7
    //   622: iload_3
    //   623: bipush 32
    //   625: iand
    //   626: bipush 32
    //   628: if_icmpeq +29 -> 657
    //   631: iload_3
    //   632: istore 5
    //   634: iload_3
    //   635: istore 4
    //   637: iload_3
    //   638: istore 6
    //   640: aload_0
    //   641: new 179	java/util/ArrayList
    //   644: dup
    //   645: invokespecial 180	java/util/ArrayList:<init>	()V
    //   648: putfield 139	kotlin/l/b/a/b/e/a$b:aban	Ljava/util/List;
    //   651: iload_3
    //   652: bipush 32
    //   654: ior
    //   655: istore 7
    //   657: iload 7
    //   659: istore 5
    //   661: iload 7
    //   663: istore 4
    //   665: iload 7
    //   667: istore 6
    //   669: aload_0
    //   670: getfield 139	kotlin/l/b/a/b/e/a$b:aban	Ljava/util/List;
    //   673: aload_1
    //   674: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   677: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   680: invokeinterface 192 2 0
    //   685: pop
    //   686: iload 7
    //   688: istore_3
    //   689: goto -633 -> 56
    //   692: astore_1
    //   693: iload 6
    //   695: istore 4
    //   697: new 104	kotlin/l/b/a/b/h/l
    //   700: dup
    //   701: aload_1
    //   702: invokevirtual 196	java/io/IOException:getMessage	()Ljava/lang/String;
    //   705: invokespecial 199	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   708: astore_1
    //   709: iload 6
    //   711: istore 4
    //   713: aload_1
    //   714: aload_0
    //   715: putfield 137	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   718: iload 6
    //   720: istore 4
    //   722: ldc 107
    //   724: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   727: iload 6
    //   729: istore 4
    //   731: aload_1
    //   732: athrow
    //   733: iload_3
    //   734: istore 5
    //   736: iload_3
    //   737: istore 4
    //   739: iload_3
    //   740: istore 6
    //   742: aload_1
    //   743: aload_1
    //   744: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   747: invokevirtual 203	kotlin/l/b/a/b/h/e:gA	(I)I
    //   750: istore 9
    //   752: iload_3
    //   753: istore 7
    //   755: iload_3
    //   756: bipush 32
    //   758: iand
    //   759: bipush 32
    //   761: if_icmpeq +48 -> 809
    //   764: iload_3
    //   765: istore 5
    //   767: iload_3
    //   768: istore 4
    //   770: iload_3
    //   771: istore 6
    //   773: iload_3
    //   774: istore 7
    //   776: aload_1
    //   777: invokevirtual 206	kotlin/l/b/a/b/h/e:AM	()I
    //   780: ifle +29 -> 809
    //   783: iload_3
    //   784: istore 5
    //   786: iload_3
    //   787: istore 4
    //   789: iload_3
    //   790: istore 6
    //   792: aload_0
    //   793: new 179	java/util/ArrayList
    //   796: dup
    //   797: invokespecial 180	java/util/ArrayList:<init>	()V
    //   800: putfield 139	kotlin/l/b/a/b/e/a$b:aban	Ljava/util/List;
    //   803: iload_3
    //   804: bipush 32
    //   806: ior
    //   807: istore 7
    //   809: iload 7
    //   811: istore 5
    //   813: iload 7
    //   815: istore 4
    //   817: iload 7
    //   819: istore 6
    //   821: aload_1
    //   822: invokevirtual 206	kotlin/l/b/a/b/h/e:AM	()I
    //   825: ifle +35 -> 860
    //   828: iload 7
    //   830: istore 5
    //   832: iload 7
    //   834: istore 4
    //   836: iload 7
    //   838: istore 6
    //   840: aload_0
    //   841: getfield 139	kotlin/l/b/a/b/e/a$b:aban	Ljava/util/List;
    //   844: aload_1
    //   845: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   848: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   851: invokeinterface 192 2 0
    //   856: pop
    //   857: goto -48 -> 809
    //   860: iload 7
    //   862: istore 5
    //   864: iload 7
    //   866: istore 4
    //   868: iload 7
    //   870: istore 6
    //   872: aload_1
    //   873: iload 9
    //   875: invokevirtual 209	kotlin/l/b/a/b/h/e:gB	(I)V
    //   878: iload 7
    //   880: istore_3
    //   881: goto -825 -> 56
    //   884: iload_3
    //   885: istore 5
    //   887: iload_3
    //   888: istore 4
    //   890: iload_3
    //   891: istore 6
    //   893: aload_0
    //   894: aload_0
    //   895: getfield 128	kotlin/l/b/a/b/e/a$b:bQS	I
    //   898: iconst_2
    //   899: ior
    //   900: putfield 128	kotlin/l/b/a/b/e/a$b:bQS	I
    //   903: iload_3
    //   904: istore 5
    //   906: iload_3
    //   907: istore 4
    //   909: iload_3
    //   910: istore 6
    //   912: aload_0
    //   913: aload_1
    //   914: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   917: putfield 211	kotlin/l/b/a/b/e/a$b:abaj	I
    //   920: goto -864 -> 56
    //   923: iload_3
    //   924: istore 5
    //   926: iload_3
    //   927: istore 4
    //   929: iload_3
    //   930: istore 6
    //   932: aload_0
    //   933: aload_0
    //   934: getfield 128	kotlin/l/b/a/b/e/a$b:bQS	I
    //   937: iconst_4
    //   938: ior
    //   939: putfield 128	kotlin/l/b/a/b/e/a$b:bQS	I
    //   942: iload_3
    //   943: istore 5
    //   945: iload_3
    //   946: istore 4
    //   948: iload_3
    //   949: istore 6
    //   951: aload_0
    //   952: aload_1
    //   953: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   956: putfield 213	kotlin/l/b/a/b/e/a$b:abak	I
    //   959: goto -903 -> 56
    //   962: iload_3
    //   963: istore 7
    //   965: iload_3
    //   966: bipush 8
    //   968: iand
    //   969: bipush 8
    //   971: if_icmpeq +29 -> 1000
    //   974: iload_3
    //   975: istore 5
    //   977: iload_3
    //   978: istore 4
    //   980: iload_3
    //   981: istore 6
    //   983: aload_0
    //   984: new 179	java/util/ArrayList
    //   987: dup
    //   988: invokespecial 180	java/util/ArrayList:<init>	()V
    //   991: putfield 147	kotlin/l/b/a/b/e/a$b:abal	Ljava/util/List;
    //   994: iload_3
    //   995: bipush 8
    //   997: ior
    //   998: istore 7
    //   1000: iload 7
    //   1002: istore 5
    //   1004: iload 7
    //   1006: istore 4
    //   1008: iload 7
    //   1010: istore 6
    //   1012: aload_0
    //   1013: getfield 147	kotlin/l/b/a/b/e/a$b:abal	Ljava/util/List;
    //   1016: aload_1
    //   1017: getstatic 216	kotlin/l/b/a/b/e/a$r:aaZC	Lkotlin/l/b/a/b/h/t;
    //   1020: aload_2
    //   1021: invokevirtual 219	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   1024: invokeinterface 192 2 0
    //   1029: pop
    //   1030: iload 7
    //   1032: istore_3
    //   1033: goto -977 -> 56
    //   1036: iload_3
    //   1037: istore 7
    //   1039: iload_3
    //   1040: bipush 16
    //   1042: iand
    //   1043: bipush 16
    //   1045: if_icmpeq +29 -> 1074
    //   1048: iload_3
    //   1049: istore 5
    //   1051: iload_3
    //   1052: istore 4
    //   1054: iload_3
    //   1055: istore 6
    //   1057: aload_0
    //   1058: new 179	java/util/ArrayList
    //   1061: dup
    //   1062: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1065: putfield 149	kotlin/l/b/a/b/e/a$b:abam	Ljava/util/List;
    //   1068: iload_3
    //   1069: bipush 16
    //   1071: ior
    //   1072: istore 7
    //   1074: iload 7
    //   1076: istore 5
    //   1078: iload 7
    //   1080: istore 4
    //   1082: iload 7
    //   1084: istore 6
    //   1086: aload_0
    //   1087: getfield 149	kotlin/l/b/a/b/e/a$b:abam	Ljava/util/List;
    //   1090: aload_1
    //   1091: getstatic 222	kotlin/l/b/a/b/e/a$p:aaZC	Lkotlin/l/b/a/b/h/t;
    //   1094: aload_2
    //   1095: invokevirtual 219	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   1098: invokeinterface 192 2 0
    //   1103: pop
    //   1104: iload 7
    //   1106: istore_3
    //   1107: goto -1051 -> 56
    //   1110: iload_3
    //   1111: istore 7
    //   1113: iload_3
    //   1114: bipush 64
    //   1116: iand
    //   1117: bipush 64
    //   1119: if_icmpeq +29 -> 1148
    //   1122: iload_3
    //   1123: istore 5
    //   1125: iload_3
    //   1126: istore 4
    //   1128: iload_3
    //   1129: istore 6
    //   1131: aload_0
    //   1132: new 179	java/util/ArrayList
    //   1135: dup
    //   1136: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1139: putfield 151	kotlin/l/b/a/b/e/a$b:abap	Ljava/util/List;
    //   1142: iload_3
    //   1143: bipush 64
    //   1145: ior
    //   1146: istore 7
    //   1148: iload 7
    //   1150: istore 5
    //   1152: iload 7
    //   1154: istore 4
    //   1156: iload 7
    //   1158: istore 6
    //   1160: aload_0
    //   1161: getfield 151	kotlin/l/b/a/b/e/a$b:abap	Ljava/util/List;
    //   1164: aload_1
    //   1165: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   1168: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1171: invokeinterface 192 2 0
    //   1176: pop
    //   1177: iload 7
    //   1179: istore_3
    //   1180: goto -1124 -> 56
    //   1183: iload_3
    //   1184: istore 5
    //   1186: iload_3
    //   1187: istore 4
    //   1189: iload_3
    //   1190: istore 6
    //   1192: aload_1
    //   1193: aload_1
    //   1194: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   1197: invokevirtual 203	kotlin/l/b/a/b/h/e:gA	(I)I
    //   1200: istore 9
    //   1202: iload_3
    //   1203: istore 7
    //   1205: iload_3
    //   1206: bipush 64
    //   1208: iand
    //   1209: bipush 64
    //   1211: if_icmpeq +48 -> 1259
    //   1214: iload_3
    //   1215: istore 5
    //   1217: iload_3
    //   1218: istore 4
    //   1220: iload_3
    //   1221: istore 6
    //   1223: iload_3
    //   1224: istore 7
    //   1226: aload_1
    //   1227: invokevirtual 206	kotlin/l/b/a/b/h/e:AM	()I
    //   1230: ifle +29 -> 1259
    //   1233: iload_3
    //   1234: istore 5
    //   1236: iload_3
    //   1237: istore 4
    //   1239: iload_3
    //   1240: istore 6
    //   1242: aload_0
    //   1243: new 179	java/util/ArrayList
    //   1246: dup
    //   1247: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1250: putfield 151	kotlin/l/b/a/b/e/a$b:abap	Ljava/util/List;
    //   1253: iload_3
    //   1254: bipush 64
    //   1256: ior
    //   1257: istore 7
    //   1259: iload 7
    //   1261: istore 5
    //   1263: iload 7
    //   1265: istore 4
    //   1267: iload 7
    //   1269: istore 6
    //   1271: aload_1
    //   1272: invokevirtual 206	kotlin/l/b/a/b/h/e:AM	()I
    //   1275: ifle +35 -> 1310
    //   1278: iload 7
    //   1280: istore 5
    //   1282: iload 7
    //   1284: istore 4
    //   1286: iload 7
    //   1288: istore 6
    //   1290: aload_0
    //   1291: getfield 151	kotlin/l/b/a/b/e/a$b:abap	Ljava/util/List;
    //   1294: aload_1
    //   1295: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   1298: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1301: invokeinterface 192 2 0
    //   1306: pop
    //   1307: goto -48 -> 1259
    //   1310: iload 7
    //   1312: istore 5
    //   1314: iload 7
    //   1316: istore 4
    //   1318: iload 7
    //   1320: istore 6
    //   1322: aload_1
    //   1323: iload 9
    //   1325: invokevirtual 209	kotlin/l/b/a/b/h/e:gB	(I)V
    //   1328: iload 7
    //   1330: istore_3
    //   1331: goto -1275 -> 56
    //   1334: iload_3
    //   1335: istore 7
    //   1337: iload_3
    //   1338: sipush 128
    //   1341: iand
    //   1342: sipush 128
    //   1345: if_icmpeq +30 -> 1375
    //   1348: iload_3
    //   1349: istore 5
    //   1351: iload_3
    //   1352: istore 4
    //   1354: iload_3
    //   1355: istore 6
    //   1357: aload_0
    //   1358: new 179	java/util/ArrayList
    //   1361: dup
    //   1362: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1365: putfield 153	kotlin/l/b/a/b/e/a$b:abar	Ljava/util/List;
    //   1368: iload_3
    //   1369: sipush 128
    //   1372: ior
    //   1373: istore 7
    //   1375: iload 7
    //   1377: istore 5
    //   1379: iload 7
    //   1381: istore 4
    //   1383: iload 7
    //   1385: istore 6
    //   1387: aload_0
    //   1388: getfield 153	kotlin/l/b/a/b/e/a$b:abar	Ljava/util/List;
    //   1391: aload_1
    //   1392: getstatic 225	kotlin/l/b/a/b/e/a$c:aaZC	Lkotlin/l/b/a/b/h/t;
    //   1395: aload_2
    //   1396: invokevirtual 219	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   1399: invokeinterface 192 2 0
    //   1404: pop
    //   1405: iload 7
    //   1407: istore_3
    //   1408: goto -1352 -> 56
    //   1411: iload_3
    //   1412: istore 7
    //   1414: iload_3
    //   1415: sipush 256
    //   1418: iand
    //   1419: sipush 256
    //   1422: if_icmpeq +30 -> 1452
    //   1425: iload_3
    //   1426: istore 5
    //   1428: iload_3
    //   1429: istore 4
    //   1431: iload_3
    //   1432: istore 6
    //   1434: aload_0
    //   1435: new 179	java/util/ArrayList
    //   1438: dup
    //   1439: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1442: putfield 155	kotlin/l/b/a/b/e/a$b:abas	Ljava/util/List;
    //   1445: iload_3
    //   1446: sipush 256
    //   1449: ior
    //   1450: istore 7
    //   1452: iload 7
    //   1454: istore 5
    //   1456: iload 7
    //   1458: istore 4
    //   1460: iload 7
    //   1462: istore 6
    //   1464: aload_0
    //   1465: getfield 155	kotlin/l/b/a/b/e/a$b:abas	Ljava/util/List;
    //   1468: aload_1
    //   1469: getstatic 228	kotlin/l/b/a/b/e/a$h:aaZC	Lkotlin/l/b/a/b/h/t;
    //   1472: aload_2
    //   1473: invokevirtual 219	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   1476: invokeinterface 192 2 0
    //   1481: pop
    //   1482: iload 7
    //   1484: istore_3
    //   1485: goto -1429 -> 56
    //   1488: iload_3
    //   1489: istore 7
    //   1491: iload_3
    //   1492: sipush 512
    //   1495: iand
    //   1496: sipush 512
    //   1499: if_icmpeq +30 -> 1529
    //   1502: iload_3
    //   1503: istore 5
    //   1505: iload_3
    //   1506: istore 4
    //   1508: iload_3
    //   1509: istore 6
    //   1511: aload_0
    //   1512: new 179	java/util/ArrayList
    //   1515: dup
    //   1516: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1519: putfield 157	kotlin/l/b/a/b/e/a$b:abat	Ljava/util/List;
    //   1522: iload_3
    //   1523: sipush 512
    //   1526: ior
    //   1527: istore 7
    //   1529: iload 7
    //   1531: istore 5
    //   1533: iload 7
    //   1535: istore 4
    //   1537: iload 7
    //   1539: istore 6
    //   1541: aload_0
    //   1542: getfield 157	kotlin/l/b/a/b/e/a$b:abat	Ljava/util/List;
    //   1545: aload_1
    //   1546: getstatic 231	kotlin/l/b/a/b/e/a$m:aaZC	Lkotlin/l/b/a/b/h/t;
    //   1549: aload_2
    //   1550: invokevirtual 219	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   1553: invokeinterface 192 2 0
    //   1558: pop
    //   1559: iload 7
    //   1561: istore_3
    //   1562: goto -1506 -> 56
    //   1565: iload_3
    //   1566: istore 7
    //   1568: iload_3
    //   1569: sipush 1024
    //   1572: iand
    //   1573: sipush 1024
    //   1576: if_icmpeq +30 -> 1606
    //   1579: iload_3
    //   1580: istore 5
    //   1582: iload_3
    //   1583: istore 4
    //   1585: iload_3
    //   1586: istore 6
    //   1588: aload_0
    //   1589: new 179	java/util/ArrayList
    //   1592: dup
    //   1593: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1596: putfield 159	kotlin/l/b/a/b/e/a$b:abau	Ljava/util/List;
    //   1599: iload_3
    //   1600: sipush 1024
    //   1603: ior
    //   1604: istore 7
    //   1606: iload 7
    //   1608: istore 5
    //   1610: iload 7
    //   1612: istore 4
    //   1614: iload 7
    //   1616: istore 6
    //   1618: aload_0
    //   1619: getfield 159	kotlin/l/b/a/b/e/a$b:abau	Ljava/util/List;
    //   1622: aload_1
    //   1623: getstatic 234	kotlin/l/b/a/b/e/a$q:aaZC	Lkotlin/l/b/a/b/h/t;
    //   1626: aload_2
    //   1627: invokevirtual 219	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   1630: invokeinterface 192 2 0
    //   1635: pop
    //   1636: iload 7
    //   1638: istore_3
    //   1639: goto -1583 -> 56
    //   1642: iload_3
    //   1643: istore 7
    //   1645: iload_3
    //   1646: sipush 2048
    //   1649: iand
    //   1650: sipush 2048
    //   1653: if_icmpeq +30 -> 1683
    //   1656: iload_3
    //   1657: istore 5
    //   1659: iload_3
    //   1660: istore 4
    //   1662: iload_3
    //   1663: istore 6
    //   1665: aload_0
    //   1666: new 179	java/util/ArrayList
    //   1669: dup
    //   1670: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1673: putfield 161	kotlin/l/b/a/b/e/a$b:abav	Ljava/util/List;
    //   1676: iload_3
    //   1677: sipush 2048
    //   1680: ior
    //   1681: istore 7
    //   1683: iload 7
    //   1685: istore 5
    //   1687: iload 7
    //   1689: istore 4
    //   1691: iload 7
    //   1693: istore 6
    //   1695: aload_0
    //   1696: getfield 161	kotlin/l/b/a/b/e/a$b:abav	Ljava/util/List;
    //   1699: aload_1
    //   1700: getstatic 237	kotlin/l/b/a/b/e/a$f:aaZC	Lkotlin/l/b/a/b/h/t;
    //   1703: aload_2
    //   1704: invokevirtual 219	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   1707: invokeinterface 192 2 0
    //   1712: pop
    //   1713: iload 7
    //   1715: istore_3
    //   1716: goto -1660 -> 56
    //   1719: iload_3
    //   1720: istore 7
    //   1722: iload_3
    //   1723: sipush 4096
    //   1726: iand
    //   1727: sipush 4096
    //   1730: if_icmpeq +30 -> 1760
    //   1733: iload_3
    //   1734: istore 5
    //   1736: iload_3
    //   1737: istore 4
    //   1739: iload_3
    //   1740: istore 6
    //   1742: aload_0
    //   1743: new 179	java/util/ArrayList
    //   1746: dup
    //   1747: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1750: putfield 163	kotlin/l/b/a/b/e/a$b:abaw	Ljava/util/List;
    //   1753: iload_3
    //   1754: sipush 4096
    //   1757: ior
    //   1758: istore 7
    //   1760: iload 7
    //   1762: istore 5
    //   1764: iload 7
    //   1766: istore 4
    //   1768: iload 7
    //   1770: istore 6
    //   1772: aload_0
    //   1773: getfield 163	kotlin/l/b/a/b/e/a$b:abaw	Ljava/util/List;
    //   1776: aload_1
    //   1777: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   1780: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1783: invokeinterface 192 2 0
    //   1788: pop
    //   1789: iload 7
    //   1791: istore_3
    //   1792: goto -1736 -> 56
    //   1795: iload_3
    //   1796: istore 5
    //   1798: iload_3
    //   1799: istore 4
    //   1801: iload_3
    //   1802: istore 6
    //   1804: aload_1
    //   1805: aload_1
    //   1806: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   1809: invokevirtual 203	kotlin/l/b/a/b/h/e:gA	(I)I
    //   1812: istore 9
    //   1814: iload_3
    //   1815: istore 7
    //   1817: iload_3
    //   1818: sipush 4096
    //   1821: iand
    //   1822: sipush 4096
    //   1825: if_icmpeq +49 -> 1874
    //   1828: iload_3
    //   1829: istore 5
    //   1831: iload_3
    //   1832: istore 4
    //   1834: iload_3
    //   1835: istore 6
    //   1837: iload_3
    //   1838: istore 7
    //   1840: aload_1
    //   1841: invokevirtual 206	kotlin/l/b/a/b/h/e:AM	()I
    //   1844: ifle +30 -> 1874
    //   1847: iload_3
    //   1848: istore 5
    //   1850: iload_3
    //   1851: istore 4
    //   1853: iload_3
    //   1854: istore 6
    //   1856: aload_0
    //   1857: new 179	java/util/ArrayList
    //   1860: dup
    //   1861: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1864: putfield 163	kotlin/l/b/a/b/e/a$b:abaw	Ljava/util/List;
    //   1867: iload_3
    //   1868: sipush 4096
    //   1871: ior
    //   1872: istore 7
    //   1874: iload 7
    //   1876: istore 5
    //   1878: iload 7
    //   1880: istore 4
    //   1882: iload 7
    //   1884: istore 6
    //   1886: aload_1
    //   1887: invokevirtual 206	kotlin/l/b/a/b/h/e:AM	()I
    //   1890: ifle +35 -> 1925
    //   1893: iload 7
    //   1895: istore 5
    //   1897: iload 7
    //   1899: istore 4
    //   1901: iload 7
    //   1903: istore 6
    //   1905: aload_0
    //   1906: getfield 163	kotlin/l/b/a/b/e/a$b:abaw	Ljava/util/List;
    //   1909: aload_1
    //   1910: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   1913: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1916: invokeinterface 192 2 0
    //   1921: pop
    //   1922: goto -48 -> 1874
    //   1925: iload 7
    //   1927: istore 5
    //   1929: iload 7
    //   1931: istore 4
    //   1933: iload 7
    //   1935: istore 6
    //   1937: aload_1
    //   1938: iload 9
    //   1940: invokevirtual 209	kotlin/l/b/a/b/h/e:gB	(I)V
    //   1943: iload 7
    //   1945: istore_3
    //   1946: goto -1890 -> 56
    //   1949: iload_3
    //   1950: istore 5
    //   1952: iload_3
    //   1953: istore 4
    //   1955: iload_3
    //   1956: istore 6
    //   1958: aload_0
    //   1959: getfield 128	kotlin/l/b/a/b/e/a$b:bQS	I
    //   1962: bipush 8
    //   1964: iand
    //   1965: bipush 8
    //   1967: if_icmpne +792 -> 2759
    //   1970: iload_3
    //   1971: istore 5
    //   1973: iload_3
    //   1974: istore 4
    //   1976: iload_3
    //   1977: istore 6
    //   1979: aload_0
    //   1980: getfield 239	kotlin/l/b/a/b/e/a$b:abay	Lkotlin/l/b/a/b/e/a$s;
    //   1983: invokestatic 245	kotlin/l/b/a/b/e/a$s:d	(Lkotlin/l/b/a/b/e/a$s;)Lkotlin/l/b/a/b/e/a$s$a;
    //   1986: astore 10
    //   1988: iload_3
    //   1989: istore 5
    //   1991: iload_3
    //   1992: istore 4
    //   1994: iload_3
    //   1995: istore 6
    //   1997: aload_0
    //   1998: aload_1
    //   1999: getstatic 246	kotlin/l/b/a/b/e/a$s:aaZC	Lkotlin/l/b/a/b/h/t;
    //   2002: aload_2
    //   2003: invokevirtual 219	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   2006: checkcast 241	kotlin/l/b/a/b/e/a$s
    //   2009: putfield 239	kotlin/l/b/a/b/e/a$b:abay	Lkotlin/l/b/a/b/e/a$s;
    //   2012: aload 10
    //   2014: ifnull +40 -> 2054
    //   2017: iload_3
    //   2018: istore 5
    //   2020: iload_3
    //   2021: istore 4
    //   2023: iload_3
    //   2024: istore 6
    //   2026: aload 10
    //   2028: aload_0
    //   2029: getfield 239	kotlin/l/b/a/b/e/a$b:abay	Lkotlin/l/b/a/b/e/a$s;
    //   2032: invokevirtual 251	kotlin/l/b/a/b/e/a$s$a:g	(Lkotlin/l/b/a/b/e/a$s;)Lkotlin/l/b/a/b/e/a$s$a;
    //   2035: pop
    //   2036: iload_3
    //   2037: istore 5
    //   2039: iload_3
    //   2040: istore 4
    //   2042: iload_3
    //   2043: istore 6
    //   2045: aload_0
    //   2046: aload 10
    //   2048: invokevirtual 255	kotlin/l/b/a/b/e/a$s$a:iMe	()Lkotlin/l/b/a/b/e/a$s;
    //   2051: putfield 239	kotlin/l/b/a/b/e/a$b:abay	Lkotlin/l/b/a/b/e/a$s;
    //   2054: iload_3
    //   2055: istore 5
    //   2057: iload_3
    //   2058: istore 4
    //   2060: iload_3
    //   2061: istore 6
    //   2063: aload_0
    //   2064: aload_0
    //   2065: getfield 128	kotlin/l/b/a/b/e/a$b:bQS	I
    //   2068: bipush 8
    //   2070: ior
    //   2071: putfield 128	kotlin/l/b/a/b/e/a$b:bQS	I
    //   2074: goto -2018 -> 56
    //   2077: iload_3
    //   2078: istore 7
    //   2080: iload_3
    //   2081: sipush 16384
    //   2084: iand
    //   2085: sipush 16384
    //   2088: if_icmpeq +30 -> 2118
    //   2091: iload_3
    //   2092: istore 5
    //   2094: iload_3
    //   2095: istore 4
    //   2097: iload_3
    //   2098: istore 6
    //   2100: aload_0
    //   2101: new 179	java/util/ArrayList
    //   2104: dup
    //   2105: invokespecial 180	java/util/ArrayList:<init>	()V
    //   2108: putfield 165	kotlin/l/b/a/b/e/a$b:abaz	Ljava/util/List;
    //   2111: iload_3
    //   2112: sipush 16384
    //   2115: ior
    //   2116: istore 7
    //   2118: iload 7
    //   2120: istore 5
    //   2122: iload 7
    //   2124: istore 4
    //   2126: iload 7
    //   2128: istore 6
    //   2130: aload_0
    //   2131: getfield 165	kotlin/l/b/a/b/e/a$b:abaz	Ljava/util/List;
    //   2134: aload_1
    //   2135: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   2138: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2141: invokeinterface 192 2 0
    //   2146: pop
    //   2147: iload 7
    //   2149: istore_3
    //   2150: goto -2094 -> 56
    //   2153: iload_3
    //   2154: istore 5
    //   2156: iload_3
    //   2157: istore 4
    //   2159: iload_3
    //   2160: istore 6
    //   2162: aload_1
    //   2163: aload_1
    //   2164: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   2167: invokevirtual 203	kotlin/l/b/a/b/h/e:gA	(I)I
    //   2170: istore 9
    //   2172: iload_3
    //   2173: istore 7
    //   2175: iload_3
    //   2176: sipush 16384
    //   2179: iand
    //   2180: sipush 16384
    //   2183: if_icmpeq +49 -> 2232
    //   2186: iload_3
    //   2187: istore 5
    //   2189: iload_3
    //   2190: istore 4
    //   2192: iload_3
    //   2193: istore 6
    //   2195: iload_3
    //   2196: istore 7
    //   2198: aload_1
    //   2199: invokevirtual 206	kotlin/l/b/a/b/h/e:AM	()I
    //   2202: ifle +30 -> 2232
    //   2205: iload_3
    //   2206: istore 5
    //   2208: iload_3
    //   2209: istore 4
    //   2211: iload_3
    //   2212: istore 6
    //   2214: aload_0
    //   2215: new 179	java/util/ArrayList
    //   2218: dup
    //   2219: invokespecial 180	java/util/ArrayList:<init>	()V
    //   2222: putfield 165	kotlin/l/b/a/b/e/a$b:abaz	Ljava/util/List;
    //   2225: iload_3
    //   2226: sipush 16384
    //   2229: ior
    //   2230: istore 7
    //   2232: iload 7
    //   2234: istore 5
    //   2236: iload 7
    //   2238: istore 4
    //   2240: iload 7
    //   2242: istore 6
    //   2244: aload_1
    //   2245: invokevirtual 206	kotlin/l/b/a/b/h/e:AM	()I
    //   2248: ifle +35 -> 2283
    //   2251: iload 7
    //   2253: istore 5
    //   2255: iload 7
    //   2257: istore 4
    //   2259: iload 7
    //   2261: istore 6
    //   2263: aload_0
    //   2264: getfield 165	kotlin/l/b/a/b/e/a$b:abaz	Ljava/util/List;
    //   2267: aload_1
    //   2268: invokevirtual 131	kotlin/l/b/a/b/h/e:AK	()I
    //   2271: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2274: invokeinterface 192 2 0
    //   2279: pop
    //   2280: goto -48 -> 2232
    //   2283: iload 7
    //   2285: istore 5
    //   2287: iload 7
    //   2289: istore 4
    //   2291: iload 7
    //   2293: istore 6
    //   2295: aload_1
    //   2296: iload 9
    //   2298: invokevirtual 209	kotlin/l/b/a/b/h/e:gB	(I)V
    //   2301: iload 7
    //   2303: istore_3
    //   2304: goto -2248 -> 56
    //   2307: iload_3
    //   2308: istore 5
    //   2310: iload_3
    //   2311: istore 4
    //   2313: iload_3
    //   2314: istore 6
    //   2316: aload_0
    //   2317: getfield 128	kotlin/l/b/a/b/e/a$b:bQS	I
    //   2320: bipush 16
    //   2322: iand
    //   2323: bipush 16
    //   2325: if_icmpne +428 -> 2753
    //   2328: iload_3
    //   2329: istore 5
    //   2331: iload_3
    //   2332: istore 4
    //   2334: iload_3
    //   2335: istore 6
    //   2337: aload_0
    //   2338: getfield 257	kotlin/l/b/a/b/e/a$b:abaA	Lkotlin/l/b/a/b/e/a$v;
    //   2341: invokestatic 263	kotlin/l/b/a/b/e/a$v:c	(Lkotlin/l/b/a/b/e/a$v;)Lkotlin/l/b/a/b/e/a$v$a;
    //   2344: astore 10
    //   2346: iload_3
    //   2347: istore 5
    //   2349: iload_3
    //   2350: istore 4
    //   2352: iload_3
    //   2353: istore 6
    //   2355: aload_0
    //   2356: aload_1
    //   2357: getstatic 264	kotlin/l/b/a/b/e/a$v:aaZC	Lkotlin/l/b/a/b/h/t;
    //   2360: aload_2
    //   2361: invokevirtual 219	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   2364: checkcast 259	kotlin/l/b/a/b/e/a$v
    //   2367: putfield 257	kotlin/l/b/a/b/e/a$b:abaA	Lkotlin/l/b/a/b/e/a$v;
    //   2370: aload 10
    //   2372: ifnull +40 -> 2412
    //   2375: iload_3
    //   2376: istore 5
    //   2378: iload_3
    //   2379: istore 4
    //   2381: iload_3
    //   2382: istore 6
    //   2384: aload 10
    //   2386: aload_0
    //   2387: getfield 257	kotlin/l/b/a/b/e/a$b:abaA	Lkotlin/l/b/a/b/e/a$v;
    //   2390: invokevirtual 268	kotlin/l/b/a/b/e/a$v$a:f	(Lkotlin/l/b/a/b/e/a$v;)Lkotlin/l/b/a/b/e/a$v$a;
    //   2393: pop
    //   2394: iload_3
    //   2395: istore 5
    //   2397: iload_3
    //   2398: istore 4
    //   2400: iload_3
    //   2401: istore 6
    //   2403: aload_0
    //   2404: aload 10
    //   2406: invokevirtual 272	kotlin/l/b/a/b/e/a$v$a:iMz	()Lkotlin/l/b/a/b/e/a$v;
    //   2409: putfield 257	kotlin/l/b/a/b/e/a$b:abaA	Lkotlin/l/b/a/b/e/a$v;
    //   2412: iload_3
    //   2413: istore 5
    //   2415: iload_3
    //   2416: istore 4
    //   2418: iload_3
    //   2419: istore 6
    //   2421: aload_0
    //   2422: aload_0
    //   2423: getfield 128	kotlin/l/b/a/b/e/a$b:bQS	I
    //   2426: bipush 16
    //   2428: ior
    //   2429: putfield 128	kotlin/l/b/a/b/e/a$b:bQS	I
    //   2432: goto -2376 -> 56
    //   2435: iload_3
    //   2436: bipush 32
    //   2438: iand
    //   2439: bipush 32
    //   2441: if_icmpne +14 -> 2455
    //   2444: aload_0
    //   2445: aload_0
    //   2446: getfield 139	kotlin/l/b/a/b/e/a$b:aban	Ljava/util/List;
    //   2449: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2452: putfield 139	kotlin/l/b/a/b/e/a$b:aban	Ljava/util/List;
    //   2455: iload_3
    //   2456: bipush 8
    //   2458: iand
    //   2459: bipush 8
    //   2461: if_icmpne +14 -> 2475
    //   2464: aload_0
    //   2465: aload_0
    //   2466: getfield 147	kotlin/l/b/a/b/e/a$b:abal	Ljava/util/List;
    //   2469: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2472: putfield 147	kotlin/l/b/a/b/e/a$b:abal	Ljava/util/List;
    //   2475: iload_3
    //   2476: bipush 16
    //   2478: iand
    //   2479: bipush 16
    //   2481: if_icmpne +14 -> 2495
    //   2484: aload_0
    //   2485: aload_0
    //   2486: getfield 149	kotlin/l/b/a/b/e/a$b:abam	Ljava/util/List;
    //   2489: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2492: putfield 149	kotlin/l/b/a/b/e/a$b:abam	Ljava/util/List;
    //   2495: iload_3
    //   2496: bipush 64
    //   2498: iand
    //   2499: bipush 64
    //   2501: if_icmpne +14 -> 2515
    //   2504: aload_0
    //   2505: aload_0
    //   2506: getfield 151	kotlin/l/b/a/b/e/a$b:abap	Ljava/util/List;
    //   2509: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2512: putfield 151	kotlin/l/b/a/b/e/a$b:abap	Ljava/util/List;
    //   2515: iload_3
    //   2516: sipush 128
    //   2519: iand
    //   2520: sipush 128
    //   2523: if_icmpne +14 -> 2537
    //   2526: aload_0
    //   2527: aload_0
    //   2528: getfield 153	kotlin/l/b/a/b/e/a$b:abar	Ljava/util/List;
    //   2531: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2534: putfield 153	kotlin/l/b/a/b/e/a$b:abar	Ljava/util/List;
    //   2537: iload_3
    //   2538: sipush 256
    //   2541: iand
    //   2542: sipush 256
    //   2545: if_icmpne +14 -> 2559
    //   2548: aload_0
    //   2549: aload_0
    //   2550: getfield 155	kotlin/l/b/a/b/e/a$b:abas	Ljava/util/List;
    //   2553: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2556: putfield 155	kotlin/l/b/a/b/e/a$b:abas	Ljava/util/List;
    //   2559: iload_3
    //   2560: sipush 512
    //   2563: iand
    //   2564: sipush 512
    //   2567: if_icmpne +14 -> 2581
    //   2570: aload_0
    //   2571: aload_0
    //   2572: getfield 157	kotlin/l/b/a/b/e/a$b:abat	Ljava/util/List;
    //   2575: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2578: putfield 157	kotlin/l/b/a/b/e/a$b:abat	Ljava/util/List;
    //   2581: iload_3
    //   2582: sipush 1024
    //   2585: iand
    //   2586: sipush 1024
    //   2589: if_icmpne +14 -> 2603
    //   2592: aload_0
    //   2593: aload_0
    //   2594: getfield 159	kotlin/l/b/a/b/e/a$b:abau	Ljava/util/List;
    //   2597: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2600: putfield 159	kotlin/l/b/a/b/e/a$b:abau	Ljava/util/List;
    //   2603: iload_3
    //   2604: sipush 2048
    //   2607: iand
    //   2608: sipush 2048
    //   2611: if_icmpne +14 -> 2625
    //   2614: aload_0
    //   2615: aload_0
    //   2616: getfield 161	kotlin/l/b/a/b/e/a$b:abav	Ljava/util/List;
    //   2619: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2622: putfield 161	kotlin/l/b/a/b/e/a$b:abav	Ljava/util/List;
    //   2625: iload_3
    //   2626: sipush 4096
    //   2629: iand
    //   2630: sipush 4096
    //   2633: if_icmpne +14 -> 2647
    //   2636: aload_0
    //   2637: aload_0
    //   2638: getfield 163	kotlin/l/b/a/b/e/a$b:abaw	Ljava/util/List;
    //   2641: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2644: putfield 163	kotlin/l/b/a/b/e/a$b:abaw	Ljava/util/List;
    //   2647: iload_3
    //   2648: sipush 16384
    //   2651: iand
    //   2652: sipush 16384
    //   2655: if_icmpne +14 -> 2669
    //   2658: aload_0
    //   2659: aload_0
    //   2660: getfield 165	kotlin/l/b/a/b/e/a$b:abaz	Ljava/util/List;
    //   2663: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2666: putfield 165	kotlin/l/b/a/b/e/a$b:abaz	Ljava/util/List;
    //   2669: aload 12
    //   2671: invokevirtual 168	kotlin/l/b/a/b/h/f:flush	()V
    //   2674: aload_0
    //   2675: aload 11
    //   2677: invokevirtual 174	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   2680: putfield 101	kotlin/l/b/a/b/e/a$b:aaZB	Lkotlin/l/b/a/b/h/d;
    //   2683: aload_0
    //   2684: invokevirtual 177	kotlin/l/b/a/b/e/a$b:HZ	()V
    //   2687: ldc 107
    //   2689: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2692: return
    //   2693: astore_1
    //   2694: aload_0
    //   2695: aload 11
    //   2697: invokevirtual 174	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   2700: putfield 101	kotlin/l/b/a/b/e/a$b:aaZB	Lkotlin/l/b/a/b/h/d;
    //   2703: goto -20 -> 2683
    //   2706: astore_1
    //   2707: aload_0
    //   2708: aload 11
    //   2710: invokevirtual 174	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   2713: putfield 101	kotlin/l/b/a/b/e/a$b:aaZB	Lkotlin/l/b/a/b/h/d;
    //   2716: ldc 107
    //   2718: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2721: aload_1
    //   2722: athrow
    //   2723: astore_2
    //   2724: aload_0
    //   2725: aload 11
    //   2727: invokevirtual 174	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   2730: putfield 101	kotlin/l/b/a/b/e/a$b:aaZB	Lkotlin/l/b/a/b/h/d;
    //   2733: goto -2125 -> 608
    //   2736: astore_1
    //   2737: aload_0
    //   2738: aload 11
    //   2740: invokevirtual 174	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   2743: putfield 101	kotlin/l/b/a/b/e/a$b:aaZB	Lkotlin/l/b/a/b/h/d;
    //   2746: ldc 107
    //   2748: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2751: aload_1
    //   2752: athrow
    //   2753: aconst_null
    //   2754: astore 10
    //   2756: goto -410 -> 2346
    //   2759: aconst_null
    //   2760: astore 10
    //   2762: goto -774 -> 1988
    //   2765: goto -2509 -> 256
    //   2768: iconst_1
    //   2769: istore 8
    //   2771: goto -2715 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2774	0	this	b
    //   0	2774	1	parame	kotlin.l.b.a.b.h.e
    //   0	2774	2	paramg	g
    //   39	2613	3	i	int
    //   65	2352	4	j	int
    //   62	2352	5	k	int
    //   68	2352	6	m	int
    //   74	2228	7	n	int
    //   54	2716	8	i1	int
    //   750	1547	9	i2	int
    //   1986	775	10	localObject	java.lang.Object
    //   43	2696	11	localb	kotlin.l.b.a.b.h.d.b
    //   51	2619	12	localf	f
    // Exception table:
    //   from	to	target	type
    //   70	76	323	kotlin/l/b/a/b/h/l
    //   265	278	323	kotlin/l/b/a/b/h/l
    //   293	303	323	kotlin/l/b/a/b/h/l
    //   312	320	323	kotlin/l/b/a/b/h/l
    //   640	651	323	kotlin/l/b/a/b/h/l
    //   669	686	323	kotlin/l/b/a/b/h/l
    //   742	752	323	kotlin/l/b/a/b/h/l
    //   776	783	323	kotlin/l/b/a/b/h/l
    //   792	803	323	kotlin/l/b/a/b/h/l
    //   821	828	323	kotlin/l/b/a/b/h/l
    //   840	857	323	kotlin/l/b/a/b/h/l
    //   872	878	323	kotlin/l/b/a/b/h/l
    //   893	903	323	kotlin/l/b/a/b/h/l
    //   912	920	323	kotlin/l/b/a/b/h/l
    //   932	942	323	kotlin/l/b/a/b/h/l
    //   951	959	323	kotlin/l/b/a/b/h/l
    //   983	994	323	kotlin/l/b/a/b/h/l
    //   1012	1030	323	kotlin/l/b/a/b/h/l
    //   1057	1068	323	kotlin/l/b/a/b/h/l
    //   1086	1104	323	kotlin/l/b/a/b/h/l
    //   1131	1142	323	kotlin/l/b/a/b/h/l
    //   1160	1177	323	kotlin/l/b/a/b/h/l
    //   1192	1202	323	kotlin/l/b/a/b/h/l
    //   1226	1233	323	kotlin/l/b/a/b/h/l
    //   1242	1253	323	kotlin/l/b/a/b/h/l
    //   1271	1278	323	kotlin/l/b/a/b/h/l
    //   1290	1307	323	kotlin/l/b/a/b/h/l
    //   1322	1328	323	kotlin/l/b/a/b/h/l
    //   1357	1368	323	kotlin/l/b/a/b/h/l
    //   1387	1405	323	kotlin/l/b/a/b/h/l
    //   1434	1445	323	kotlin/l/b/a/b/h/l
    //   1464	1482	323	kotlin/l/b/a/b/h/l
    //   1511	1522	323	kotlin/l/b/a/b/h/l
    //   1541	1559	323	kotlin/l/b/a/b/h/l
    //   1588	1599	323	kotlin/l/b/a/b/h/l
    //   1618	1636	323	kotlin/l/b/a/b/h/l
    //   1665	1676	323	kotlin/l/b/a/b/h/l
    //   1695	1713	323	kotlin/l/b/a/b/h/l
    //   1742	1753	323	kotlin/l/b/a/b/h/l
    //   1772	1789	323	kotlin/l/b/a/b/h/l
    //   1804	1814	323	kotlin/l/b/a/b/h/l
    //   1840	1847	323	kotlin/l/b/a/b/h/l
    //   1856	1867	323	kotlin/l/b/a/b/h/l
    //   1886	1893	323	kotlin/l/b/a/b/h/l
    //   1905	1922	323	kotlin/l/b/a/b/h/l
    //   1937	1943	323	kotlin/l/b/a/b/h/l
    //   1958	1970	323	kotlin/l/b/a/b/h/l
    //   1979	1988	323	kotlin/l/b/a/b/h/l
    //   1997	2012	323	kotlin/l/b/a/b/h/l
    //   2026	2036	323	kotlin/l/b/a/b/h/l
    //   2045	2054	323	kotlin/l/b/a/b/h/l
    //   2063	2074	323	kotlin/l/b/a/b/h/l
    //   2100	2111	323	kotlin/l/b/a/b/h/l
    //   2130	2147	323	kotlin/l/b/a/b/h/l
    //   2162	2172	323	kotlin/l/b/a/b/h/l
    //   2198	2205	323	kotlin/l/b/a/b/h/l
    //   2214	2225	323	kotlin/l/b/a/b/h/l
    //   2244	2251	323	kotlin/l/b/a/b/h/l
    //   2263	2280	323	kotlin/l/b/a/b/h/l
    //   2295	2301	323	kotlin/l/b/a/b/h/l
    //   2316	2328	323	kotlin/l/b/a/b/h/l
    //   2337	2346	323	kotlin/l/b/a/b/h/l
    //   2355	2370	323	kotlin/l/b/a/b/h/l
    //   2384	2394	323	kotlin/l/b/a/b/h/l
    //   2403	2412	323	kotlin/l/b/a/b/h/l
    //   2421	2432	323	kotlin/l/b/a/b/h/l
    //   70	76	348	finally
    //   265	278	348	finally
    //   293	303	348	finally
    //   312	320	348	finally
    //   328	333	348	finally
    //   337	342	348	finally
    //   346	348	348	finally
    //   640	651	348	finally
    //   669	686	348	finally
    //   697	709	348	finally
    //   713	718	348	finally
    //   722	727	348	finally
    //   731	733	348	finally
    //   742	752	348	finally
    //   776	783	348	finally
    //   792	803	348	finally
    //   821	828	348	finally
    //   840	857	348	finally
    //   872	878	348	finally
    //   893	903	348	finally
    //   912	920	348	finally
    //   932	942	348	finally
    //   951	959	348	finally
    //   983	994	348	finally
    //   1012	1030	348	finally
    //   1057	1068	348	finally
    //   1086	1104	348	finally
    //   1131	1142	348	finally
    //   1160	1177	348	finally
    //   1192	1202	348	finally
    //   1226	1233	348	finally
    //   1242	1253	348	finally
    //   1271	1278	348	finally
    //   1290	1307	348	finally
    //   1322	1328	348	finally
    //   1357	1368	348	finally
    //   1387	1405	348	finally
    //   1434	1445	348	finally
    //   1464	1482	348	finally
    //   1511	1522	348	finally
    //   1541	1559	348	finally
    //   1588	1599	348	finally
    //   1618	1636	348	finally
    //   1665	1676	348	finally
    //   1695	1713	348	finally
    //   1742	1753	348	finally
    //   1772	1789	348	finally
    //   1804	1814	348	finally
    //   1840	1847	348	finally
    //   1856	1867	348	finally
    //   1886	1893	348	finally
    //   1905	1922	348	finally
    //   1937	1943	348	finally
    //   1958	1970	348	finally
    //   1979	1988	348	finally
    //   1997	2012	348	finally
    //   2026	2036	348	finally
    //   2045	2054	348	finally
    //   2063	2074	348	finally
    //   2100	2111	348	finally
    //   2130	2147	348	finally
    //   2162	2172	348	finally
    //   2198	2205	348	finally
    //   2214	2225	348	finally
    //   2244	2251	348	finally
    //   2263	2280	348	finally
    //   2295	2301	348	finally
    //   2316	2328	348	finally
    //   2337	2346	348	finally
    //   2355	2370	348	finally
    //   2384	2394	348	finally
    //   2403	2412	348	finally
    //   2421	2432	348	finally
    //   70	76	692	java/io/IOException
    //   265	278	692	java/io/IOException
    //   293	303	692	java/io/IOException
    //   312	320	692	java/io/IOException
    //   640	651	692	java/io/IOException
    //   669	686	692	java/io/IOException
    //   742	752	692	java/io/IOException
    //   776	783	692	java/io/IOException
    //   792	803	692	java/io/IOException
    //   821	828	692	java/io/IOException
    //   840	857	692	java/io/IOException
    //   872	878	692	java/io/IOException
    //   893	903	692	java/io/IOException
    //   912	920	692	java/io/IOException
    //   932	942	692	java/io/IOException
    //   951	959	692	java/io/IOException
    //   983	994	692	java/io/IOException
    //   1012	1030	692	java/io/IOException
    //   1057	1068	692	java/io/IOException
    //   1086	1104	692	java/io/IOException
    //   1131	1142	692	java/io/IOException
    //   1160	1177	692	java/io/IOException
    //   1192	1202	692	java/io/IOException
    //   1226	1233	692	java/io/IOException
    //   1242	1253	692	java/io/IOException
    //   1271	1278	692	java/io/IOException
    //   1290	1307	692	java/io/IOException
    //   1322	1328	692	java/io/IOException
    //   1357	1368	692	java/io/IOException
    //   1387	1405	692	java/io/IOException
    //   1434	1445	692	java/io/IOException
    //   1464	1482	692	java/io/IOException
    //   1511	1522	692	java/io/IOException
    //   1541	1559	692	java/io/IOException
    //   1588	1599	692	java/io/IOException
    //   1618	1636	692	java/io/IOException
    //   1665	1676	692	java/io/IOException
    //   1695	1713	692	java/io/IOException
    //   1742	1753	692	java/io/IOException
    //   1772	1789	692	java/io/IOException
    //   1804	1814	692	java/io/IOException
    //   1840	1847	692	java/io/IOException
    //   1856	1867	692	java/io/IOException
    //   1886	1893	692	java/io/IOException
    //   1905	1922	692	java/io/IOException
    //   1937	1943	692	java/io/IOException
    //   1958	1970	692	java/io/IOException
    //   1979	1988	692	java/io/IOException
    //   1997	2012	692	java/io/IOException
    //   2026	2036	692	java/io/IOException
    //   2045	2054	692	java/io/IOException
    //   2063	2074	692	java/io/IOException
    //   2100	2111	692	java/io/IOException
    //   2130	2147	692	java/io/IOException
    //   2162	2172	692	java/io/IOException
    //   2198	2205	692	java/io/IOException
    //   2214	2225	692	java/io/IOException
    //   2244	2251	692	java/io/IOException
    //   2263	2280	692	java/io/IOException
    //   2295	2301	692	java/io/IOException
    //   2316	2328	692	java/io/IOException
    //   2337	2346	692	java/io/IOException
    //   2355	2370	692	java/io/IOException
    //   2384	2394	692	java/io/IOException
    //   2403	2412	692	java/io/IOException
    //   2421	2432	692	java/io/IOException
    //   2669	2674	2693	java/io/IOException
    //   2669	2674	2706	finally
    //   594	599	2723	java/io/IOException
    //   594	599	2736	finally
  }
  
  private a$b(i.b<b, ?> paramb)
  {
    super(paramb);
    this.aaZB = paramb.aaZB;
  }
  
  public static b a(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(58431);
    paramInputStream = (b)aaZC.j(paramInputStream, paramg);
    AppMethodBeat.o(58431);
    return paramInputStream;
  }
  
  private void iIN()
  {
    AppMethodBeat.i(58427);
    this.aaZS = 6;
    this.abaj = 0;
    this.abak = 0;
    this.abal = Collections.emptyList();
    this.abam = Collections.emptyList();
    this.aban = Collections.emptyList();
    this.abap = Collections.emptyList();
    this.abar = Collections.emptyList();
    this.abas = Collections.emptyList();
    this.abat = Collections.emptyList();
    this.abau = Collections.emptyList();
    this.abav = Collections.emptyList();
    this.abaw = Collections.emptyList();
    this.abay = a.s.iMb();
    this.abaz = Collections.emptyList();
    this.abaA = a.v.iMx();
    AppMethodBeat.o(58427);
  }
  
  public static b iJs()
  {
    return abai;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(58430);
    int i = this.bXW;
    if (i != -1)
    {
      AppMethodBeat.o(58430);
      return i;
    }
    if ((this.bQS & 0x1) == 1) {}
    for (i = f.bM(1, this.aaZS) + 0;; i = 0)
    {
      int k = 0;
      int j = 0;
      while (k < this.aban.size())
      {
        j += f.gM(((Integer)this.aban.get(k)).intValue());
        k += 1;
      }
      k = i + j;
      i = k;
      if (!this.aban.isEmpty()) {
        i = k + 1 + f.gM(j);
      }
      this.abao = j;
      j = i;
      if ((this.bQS & 0x2) == 2) {
        j = i + f.bM(3, this.abaj);
      }
      i = j;
      if ((this.bQS & 0x4) == 4) {
        i = j + f.bM(4, this.abak);
      }
      j = 0;
      while (j < this.abal.size())
      {
        i += f.c(5, (r)this.abal.get(j));
        j += 1;
      }
      j = 0;
      while (j < this.abam.size())
      {
        i += f.c(6, (r)this.abam.get(j));
        j += 1;
      }
      k = 0;
      j = 0;
      while (k < this.abap.size())
      {
        j += f.gM(((Integer)this.abap.get(k)).intValue());
        k += 1;
      }
      k = i + j;
      i = k;
      if (!this.abap.isEmpty()) {
        i = k + 1 + f.gM(j);
      }
      this.abaq = j;
      j = 0;
      while (j < this.abar.size())
      {
        i += f.c(8, (r)this.abar.get(j));
        j += 1;
      }
      j = 0;
      while (j < this.abas.size())
      {
        i += f.c(9, (r)this.abas.get(j));
        j += 1;
      }
      j = 0;
      while (j < this.abat.size())
      {
        i += f.c(10, (r)this.abat.get(j));
        j += 1;
      }
      j = 0;
      while (j < this.abau.size())
      {
        i += f.c(11, (r)this.abau.get(j));
        j += 1;
      }
      j = 0;
      while (j < this.abav.size())
      {
        i += f.c(13, (r)this.abav.get(j));
        j += 1;
      }
      k = 0;
      j = 0;
      while (k < this.abaw.size())
      {
        j += f.gM(((Integer)this.abaw.get(k)).intValue());
        k += 1;
      }
      k = i + j;
      i = k;
      if (!this.abaw.isEmpty()) {
        i = k + 2 + f.gM(j);
      }
      this.abax = j;
      if ((this.bQS & 0x8) == 8) {
        i += f.c(30, this.abay);
      }
      for (;;)
      {
        k = 0;
        int m;
        for (j = 0; k < this.abaz.size(); j = m + j)
        {
          m = f.gM(((Integer)this.abaz.get(k)).intValue());
          k += 1;
        }
        j = i + j + this.abaz.size() * 2;
        i = j;
        if ((this.bQS & 0x10) == 16) {
          i = j + f.c(32, this.abaA);
        }
        i = i + Ii() + this.aaZB.size();
        this.bXW = i;
        AppMethodBeat.o(58430);
        return i;
      }
    }
  }
  
  public final void a(f paramf)
  {
    int j = 0;
    AppMethodBeat.i(58429);
    Ad();
    i.c.a locala = iNU();
    if ((this.bQS & 0x1) == 1) {
      paramf.bJ(1, this.aaZS);
    }
    if (this.aban.size() > 0)
    {
      paramf.hT(18);
      paramf.hT(this.abao);
    }
    int i = 0;
    while (i < this.aban.size())
    {
      paramf.gD(((Integer)this.aban.get(i)).intValue());
      i += 1;
    }
    if ((this.bQS & 0x2) == 2) {
      paramf.bJ(3, this.abaj);
    }
    if ((this.bQS & 0x4) == 4) {
      paramf.bJ(4, this.abak);
    }
    i = 0;
    while (i < this.abal.size())
    {
      paramf.a(5, (r)this.abal.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.abam.size())
    {
      paramf.a(6, (r)this.abam.get(i));
      i += 1;
    }
    if (this.abap.size() > 0)
    {
      paramf.hT(58);
      paramf.hT(this.abaq);
    }
    i = 0;
    while (i < this.abap.size())
    {
      paramf.gD(((Integer)this.abap.get(i)).intValue());
      i += 1;
    }
    i = 0;
    while (i < this.abar.size())
    {
      paramf.a(8, (r)this.abar.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.abas.size())
    {
      paramf.a(9, (r)this.abas.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.abat.size())
    {
      paramf.a(10, (r)this.abat.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.abau.size())
    {
      paramf.a(11, (r)this.abau.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.abav.size())
    {
      paramf.a(13, (r)this.abav.get(i));
      i += 1;
    }
    if (this.abaw.size() > 0)
    {
      paramf.hT(130);
      paramf.hT(this.abax);
    }
    i = 0;
    while (i < this.abaw.size())
    {
      paramf.gD(((Integer)this.abaw.get(i)).intValue());
      i += 1;
    }
    i = j;
    if ((this.bQS & 0x8) == 8)
    {
      paramf.a(30, this.abay);
      i = j;
    }
    while (i < this.abaz.size())
    {
      paramf.bJ(31, ((Integer)this.abaz.get(i)).intValue());
      i += 1;
    }
    if ((this.bQS & 0x10) == 16) {
      paramf.a(32, this.abaA);
    }
    locala.b(19000, paramf);
    paramf.e(this.aaZB);
    AppMethodBeat.o(58429);
  }
  
  public final boolean iJj()
  {
    return (this.bQS & 0x1) == 1;
  }
  
  public final boolean iJt()
  {
    return (this.bQS & 0x2) == 2;
  }
  
  public final boolean iJu()
  {
    return (this.bQS & 0x4) == 4;
  }
  
  public final boolean iJv()
  {
    return (this.bQS & 0x8) == 8;
  }
  
  public final boolean iJw()
  {
    return (this.bQS & 0x10) == 16;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58428);
    int i = this.bRd;
    if (i == 1)
    {
      AppMethodBeat.o(58428);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58428);
      return false;
    }
    if (!iJt())
    {
      this.bRd = 0;
      AppMethodBeat.o(58428);
      return false;
    }
    i = 0;
    while (i < this.abal.size())
    {
      if (!((a.r)this.abal.get(i)).isInitialized())
      {
        this.bRd = 0;
        AppMethodBeat.o(58428);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.abam.size())
    {
      if (!((a.p)this.abam.get(i)).isInitialized())
      {
        this.bRd = 0;
        AppMethodBeat.o(58428);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.abar.size())
    {
      if (!((a.c)this.abar.get(i)).isInitialized())
      {
        this.bRd = 0;
        AppMethodBeat.o(58428);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.abas.size())
    {
      if (!((a.h)this.abas.get(i)).isInitialized())
      {
        this.bRd = 0;
        AppMethodBeat.o(58428);
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
        AppMethodBeat.o(58428);
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
        AppMethodBeat.o(58428);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.abav.size())
    {
      if (!((a.f)this.abav.get(i)).isInitialized())
      {
        this.bRd = 0;
        AppMethodBeat.o(58428);
        return false;
      }
      i += 1;
    }
    if ((iJv()) && (!this.abay.isInitialized()))
    {
      this.bRd = 0;
      AppMethodBeat.o(58428);
      return false;
    }
    if (!Ig())
    {
      this.bRd = 0;
      AppMethodBeat.o(58428);
      return false;
    }
    this.bRd = 1;
    AppMethodBeat.o(58428);
    return true;
  }
  
  public static final class a
    extends i.b<a.b, a>
    implements e
  {
    private int aaZS;
    private a.v abaA;
    private int abaj;
    private int abak;
    private List<a.r> abal;
    private List<a.p> abam;
    private List<Integer> aban;
    private List<Integer> abap;
    private List<a.c> abar;
    private List<a.h> abas;
    private List<a.m> abat;
    private List<a.q> abau;
    private List<a.f> abav;
    private List<Integer> abaw;
    private a.s abay;
    private List<Integer> abaz;
    private int bQS;
    
    private a()
    {
      AppMethodBeat.i(58392);
      this.aaZS = 6;
      this.abal = Collections.emptyList();
      this.abam = Collections.emptyList();
      this.aban = Collections.emptyList();
      this.abap = Collections.emptyList();
      this.abar = Collections.emptyList();
      this.abas = Collections.emptyList();
      this.abat = Collections.emptyList();
      this.abau = Collections.emptyList();
      this.abav = Collections.emptyList();
      this.abaw = Collections.emptyList();
      this.abay = a.s.iMb();
      this.abaz = Collections.emptyList();
      this.abaA = a.v.iMx();
      AppMethodBeat.o(58392);
    }
    
    private a a(a.s params)
    {
      AppMethodBeat.i(58408);
      if (((this.bQS & 0x2000) == 8192) && (this.abay != a.s.iMb())) {}
      for (this.abay = a.s.d(this.abay).g(params).iMe();; this.abay = params)
      {
        this.bQS |= 0x2000;
        AppMethodBeat.o(58408);
        return this;
      }
    }
    
    private a a(a.v paramv)
    {
      AppMethodBeat.i(58410);
      if (((this.bQS & 0x8000) == 32768) && (this.abaA != a.v.iMx())) {}
      for (this.abaA = a.v.c(this.abaA).f(paramv).iMz();; this.abaA = paramv)
      {
        this.bQS |= 0x8000;
        AppMethodBeat.o(58410);
        return this;
      }
    }
    
    private a aDW(int paramInt)
    {
      this.bQS |= 0x1;
      this.aaZS = paramInt;
      return this;
    }
    
    private a aDX(int paramInt)
    {
      this.bQS |= 0x2;
      this.abaj = paramInt;
      return this;
    }
    
    private a aDY(int paramInt)
    {
      this.bQS |= 0x4;
      this.abak = paramInt;
      return this;
    }
    
    /* Error */
    private a g(kotlin.l.b.a.b.h.e parame, g paramg)
    {
      // Byte code:
      //   0: ldc 146
      //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 150	kotlin/l/b/a/b/e/a$b:aaZC	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 155 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$b
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 159	kotlin/l/b/a/b/e/a$b$a:m	(Lkotlin/l/b/a/b/e/a$b;)Lkotlin/l/b/a/b/e/a$b$a;
      //   26: pop
      //   27: ldc 146
      //   29: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 163	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
      //   39: checkcast 9	kotlin/l/b/a/b/e/a$b
      //   42: astore_2
      //   43: ldc 146
      //   45: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 159	kotlin/l/b/a/b/e/a$b$a:m	(Lkotlin/l/b/a/b/e/a$b;)Lkotlin/l/b/a/b/e/a$b$a;
      //   60: pop
      //   61: ldc 146
      //   63: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private void iJA()
    {
      AppMethodBeat.i(58399);
      if ((this.bQS & 0x10) != 16)
      {
        this.abam = new ArrayList(this.abam);
        this.bQS |= 0x10;
      }
      AppMethodBeat.o(58399);
    }
    
    private void iJB()
    {
      AppMethodBeat.i(58400);
      if ((this.bQS & 0x20) != 32)
      {
        this.aban = new ArrayList(this.aban);
        this.bQS |= 0x20;
      }
      AppMethodBeat.o(58400);
    }
    
    private void iJC()
    {
      AppMethodBeat.i(58401);
      if ((this.bQS & 0x40) != 64)
      {
        this.abap = new ArrayList(this.abap);
        this.bQS |= 0x40;
      }
      AppMethodBeat.o(58401);
    }
    
    private void iJD()
    {
      AppMethodBeat.i(58402);
      if ((this.bQS & 0x80) != 128)
      {
        this.abar = new ArrayList(this.abar);
        this.bQS |= 0x80;
      }
      AppMethodBeat.o(58402);
    }
    
    private void iJE()
    {
      AppMethodBeat.i(58403);
      if ((this.bQS & 0x100) != 256)
      {
        this.abas = new ArrayList(this.abas);
        this.bQS |= 0x100;
      }
      AppMethodBeat.o(58403);
    }
    
    private void iJF()
    {
      AppMethodBeat.i(58404);
      if ((this.bQS & 0x200) != 512)
      {
        this.abat = new ArrayList(this.abat);
        this.bQS |= 0x200;
      }
      AppMethodBeat.o(58404);
    }
    
    private void iJG()
    {
      AppMethodBeat.i(58405);
      if ((this.bQS & 0x400) != 1024)
      {
        this.abau = new ArrayList(this.abau);
        this.bQS |= 0x400;
      }
      AppMethodBeat.o(58405);
    }
    
    private void iJH()
    {
      AppMethodBeat.i(58406);
      if ((this.bQS & 0x800) != 2048)
      {
        this.abav = new ArrayList(this.abav);
        this.bQS |= 0x800;
      }
      AppMethodBeat.o(58406);
    }
    
    private void iJI()
    {
      AppMethodBeat.i(58407);
      if ((this.bQS & 0x1000) != 4096)
      {
        this.abaw = new ArrayList(this.abaw);
        this.bQS |= 0x1000;
      }
      AppMethodBeat.o(58407);
    }
    
    private void iJJ()
    {
      AppMethodBeat.i(58409);
      if ((this.bQS & 0x4000) != 16384)
      {
        this.abaz = new ArrayList(this.abaz);
        this.bQS |= 0x4000;
      }
      AppMethodBeat.o(58409);
    }
    
    private a iJx()
    {
      AppMethodBeat.i(58393);
      a locala = new a().m(iJy());
      AppMethodBeat.o(58393);
      return locala;
    }
    
    private a.b iJy()
    {
      int j = 1;
      AppMethodBeat.i(58394);
      a.b localb = new a.b(this, (byte)0);
      int k = this.bQS;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.b.a(localb, this.aaZS);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.b.b(localb, this.abaj);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.b.c(localb, this.abak);
        if ((this.bQS & 0x8) == 8)
        {
          this.abal = Collections.unmodifiableList(this.abal);
          this.bQS &= 0xFFFFFFF7;
        }
        a.b.a(localb, this.abal);
        if ((this.bQS & 0x10) == 16)
        {
          this.abam = Collections.unmodifiableList(this.abam);
          this.bQS &= 0xFFFFFFEF;
        }
        a.b.b(localb, this.abam);
        if ((this.bQS & 0x20) == 32)
        {
          this.aban = Collections.unmodifiableList(this.aban);
          this.bQS &= 0xFFFFFFDF;
        }
        a.b.c(localb, this.aban);
        if ((this.bQS & 0x40) == 64)
        {
          this.abap = Collections.unmodifiableList(this.abap);
          this.bQS &= 0xFFFFFFBF;
        }
        a.b.d(localb, this.abap);
        if ((this.bQS & 0x80) == 128)
        {
          this.abar = Collections.unmodifiableList(this.abar);
          this.bQS &= 0xFFFFFF7F;
        }
        a.b.e(localb, this.abar);
        if ((this.bQS & 0x100) == 256)
        {
          this.abas = Collections.unmodifiableList(this.abas);
          this.bQS &= 0xFFFFFEFF;
        }
        a.b.f(localb, this.abas);
        if ((this.bQS & 0x200) == 512)
        {
          this.abat = Collections.unmodifiableList(this.abat);
          this.bQS &= 0xFFFFFDFF;
        }
        a.b.g(localb, this.abat);
        if ((this.bQS & 0x400) == 1024)
        {
          this.abau = Collections.unmodifiableList(this.abau);
          this.bQS &= 0xFFFFFBFF;
        }
        a.b.h(localb, this.abau);
        if ((this.bQS & 0x800) == 2048)
        {
          this.abav = Collections.unmodifiableList(this.abav);
          this.bQS &= 0xFFFFF7FF;
        }
        a.b.i(localb, this.abav);
        if ((this.bQS & 0x1000) == 4096)
        {
          this.abaw = Collections.unmodifiableList(this.abaw);
          this.bQS &= 0xFFFFEFFF;
        }
        a.b.j(localb, this.abaw);
        i = j;
        if ((k & 0x2000) == 8192) {
          i = j | 0x8;
        }
        a.b.a(localb, this.abay);
        if ((this.bQS & 0x4000) == 16384)
        {
          this.abaz = Collections.unmodifiableList(this.abaz);
          this.bQS &= 0xFFFFBFFF;
        }
        a.b.k(localb, this.abaz);
        j = i;
        if ((k & 0x8000) == 32768) {
          j = i | 0x10;
        }
        a.b.a(localb, this.abaA);
        a.b.d(localb, j);
        AppMethodBeat.o(58394);
        return localb;
        j = 0;
      }
    }
    
    private void iJz()
    {
      AppMethodBeat.i(58398);
      if ((this.bQS & 0x8) != 8)
      {
        this.abal = new ArrayList(this.abal);
        this.bQS |= 0x8;
      }
      AppMethodBeat.o(58398);
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58396);
      if ((this.bQS & 0x2) == 2) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58396);
        return false;
      }
      i = 0;
      while (i < this.abal.size())
      {
        if (!((a.r)this.abal.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.abam.size())
      {
        if (!((a.p)this.abam.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.abar.size())
      {
        if (!((a.c)this.abar.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.abas.size())
      {
        if (!((a.h)this.abas.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.abat.size())
      {
        if (!((a.m)this.abat.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.abau.size())
      {
        if (!((a.q)this.abau.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.abav.size())
      {
        if (!((a.f)this.abav.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      if ((this.bQS & 0x2000) == 8192) {}
      for (i = 1; (i != 0) && (!this.abay.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58396);
        return false;
      }
      if (!Ig())
      {
        AppMethodBeat.o(58396);
        return false;
      }
      AppMethodBeat.o(58396);
      return true;
    }
    
    public final a m(a.b paramb)
    {
      AppMethodBeat.i(58395);
      if (paramb == a.b.iJs())
      {
        AppMethodBeat.o(58395);
        return this;
      }
      if (paramb.iJj()) {
        aDW(paramb.aaZS);
      }
      if (paramb.iJt()) {
        aDX(paramb.abaj);
      }
      if (paramb.iJu()) {
        aDY(paramb.abak);
      }
      if (!a.b.a(paramb).isEmpty())
      {
        if (this.abal.isEmpty())
        {
          this.abal = a.b.a(paramb);
          this.bQS &= 0xFFFFFFF7;
        }
      }
      else
      {
        if (!a.b.b(paramb).isEmpty())
        {
          if (!this.abam.isEmpty()) {
            break label630;
          }
          this.abam = a.b.b(paramb);
          this.bQS &= 0xFFFFFFEF;
        }
        label155:
        if (!a.b.c(paramb).isEmpty())
        {
          if (!this.aban.isEmpty()) {
            break label651;
          }
          this.aban = a.b.c(paramb);
          this.bQS &= 0xFFFFFFDF;
        }
        label198:
        if (!a.b.d(paramb).isEmpty())
        {
          if (!this.abap.isEmpty()) {
            break label672;
          }
          this.abap = a.b.d(paramb);
          this.bQS &= 0xFFFFFFBF;
        }
        label241:
        if (!a.b.e(paramb).isEmpty())
        {
          if (!this.abar.isEmpty()) {
            break label693;
          }
          this.abar = a.b.e(paramb);
          this.bQS &= 0xFFFFFF7F;
        }
        label285:
        if (!a.b.f(paramb).isEmpty())
        {
          if (!this.abas.isEmpty()) {
            break label714;
          }
          this.abas = a.b.f(paramb);
          this.bQS &= 0xFFFFFEFF;
        }
        label329:
        if (!a.b.g(paramb).isEmpty())
        {
          if (!this.abat.isEmpty()) {
            break label735;
          }
          this.abat = a.b.g(paramb);
          this.bQS &= 0xFFFFFDFF;
        }
        label373:
        if (!a.b.h(paramb).isEmpty())
        {
          if (!this.abau.isEmpty()) {
            break label756;
          }
          this.abau = a.b.h(paramb);
          this.bQS &= 0xFFFFFBFF;
        }
        label417:
        if (!a.b.i(paramb).isEmpty())
        {
          if (!this.abav.isEmpty()) {
            break label777;
          }
          this.abav = a.b.i(paramb);
          this.bQS &= 0xFFFFF7FF;
        }
        label461:
        if (!a.b.j(paramb).isEmpty())
        {
          if (!this.abaw.isEmpty()) {
            break label798;
          }
          this.abaw = a.b.j(paramb);
          this.bQS &= 0xFFFFEFFF;
        }
        label505:
        if (paramb.iJv()) {
          a(paramb.abay);
        }
        if (!a.b.k(paramb).isEmpty())
        {
          if (!this.abaz.isEmpty()) {
            break label819;
          }
          this.abaz = a.b.k(paramb);
          this.bQS &= 0xFFFFBFFF;
        }
      }
      for (;;)
      {
        if (paramb.iJw()) {
          a(paramb.abaA);
        }
        a(paramb);
        this.aaZB = this.aaZB.a(a.b.l(paramb));
        AppMethodBeat.o(58395);
        return this;
        iJz();
        this.abal.addAll(a.b.a(paramb));
        break;
        label630:
        iJA();
        this.abam.addAll(a.b.b(paramb));
        break label155;
        label651:
        iJB();
        this.aban.addAll(a.b.c(paramb));
        break label198;
        label672:
        iJC();
        this.abap.addAll(a.b.d(paramb));
        break label241;
        label693:
        iJD();
        this.abar.addAll(a.b.e(paramb));
        break label285;
        label714:
        iJE();
        this.abas.addAll(a.b.f(paramb));
        break label329;
        label735:
        iJF();
        this.abat.addAll(a.b.g(paramb));
        break label373;
        label756:
        iJG();
        this.abau.addAll(a.b.h(paramb));
        break label417;
        label777:
        iJH();
        this.abav.addAll(a.b.i(paramb));
        break label461;
        label798:
        iJI();
        this.abaw.addAll(a.b.j(paramb));
        break label505;
        label819:
        iJJ();
        this.abaz.addAll(a.b.k(paramb));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.b
 * JD-Core Version:    0.7.0.1
 */