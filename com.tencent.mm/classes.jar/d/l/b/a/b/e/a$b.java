package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.b;
import d.l.b.a.b.h.d;
import d.l.b.a.b.h.f;
import d.l.b.a.b.h.g;
import d.l.b.a.b.h.h;
import d.l.b.a.b.h.i.a;
import d.l.b.a.b.h.i.b;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.h.i.c.a;
import d.l.b.a.b.h.q;
import d.l.b.a.b.h.s;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$b
  extends i.c<b>
  implements e
{
  private static final b NHP;
  public static s<b> NHf;
  public int NHQ;
  public int NHR;
  public List<a.r> NHS;
  public List<a.p> NHT;
  public List<Integer> NHU;
  private int NHV = -1;
  public List<Integer> NHW;
  private int NHX = -1;
  public List<a.c> NHY;
  public List<a.h> NHZ;
  private final d NHe;
  private int NHg;
  private byte NHj = -1;
  private int NHk = -1;
  public int NHz;
  public List<a.m> NIa;
  public List<a.q> NIb;
  public List<a.f> NIc;
  public List<Integer> NId;
  private int NIe = -1;
  public a.s NIf;
  public List<Integer> NIg;
  public a.v NIh;
  
  static
  {
    AppMethodBeat.i(58434);
    NHf = new b() {};
    b localb = new b();
    NHP = localb;
    localb.gqS();
    AppMethodBeat.o(58434);
  }
  
  private a$b()
  {
    this.NHe = d.NNO;
  }
  
  /* Error */
  private a$b(d.l.b.a.b.h.e parame, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 84	d/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 107
    //   6: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 86	d/l/b/a/b/e/a$b:NHV	I
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 88	d/l/b/a/b/e/a$b:NHX	I
    //   19: aload_0
    //   20: iconst_m1
    //   21: putfield 90	d/l/b/a/b/e/a$b:NIe	I
    //   24: aload_0
    //   25: iconst_m1
    //   26: putfield 92	d/l/b/a/b/e/a$b:NHj	B
    //   29: aload_0
    //   30: iconst_m1
    //   31: putfield 94	d/l/b/a/b/e/a$b:NHk	I
    //   34: aload_0
    //   35: invokespecial 79	d/l/b/a/b/e/a$b:gqS	()V
    //   38: iconst_0
    //   39: istore_3
    //   40: invokestatic 111	d/l/b/a/b/h/d:gvT	()Ld/l/b/a/b/h/d$b;
    //   43: astore 11
    //   45: aload 11
    //   47: iconst_1
    //   48: invokestatic 117	d/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Ld/l/b/a/b/h/f;
    //   51: astore 12
    //   53: iconst_0
    //   54: istore 8
    //   56: iload 8
    //   58: ifne +2380 -> 2438
    //   61: iload_3
    //   62: istore 5
    //   64: iload_3
    //   65: istore 4
    //   67: iload_3
    //   68: istore 6
    //   70: aload_1
    //   71: invokevirtual 123	d/l/b/a/b/h/e:zb	()I
    //   74: istore 7
    //   76: iload 7
    //   78: lookupswitch	default:+2693->2771, 0:+2696->2774, 8:+206->284, 16:+544->622, 18:+658->736, 24:+809->887, 32:+848->926, 42:+887->965, 50:+961->1039, 56:+1035->1113, 58:+1108->1186, 66:+1259->1337, 74:+1336->1414, 82:+1413->1491, 90:+1490->1568, 106:+1567->1645, 128:+1644->1722, 130:+1720->1798, 242:+1874->1952, 248:+2002->2080, 250:+2078->2156, 258:+2232->2310
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
    //   272: invokevirtual 126	d/l/b/a/b/e/a$b:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/f;Ld/l/b/a/b/h/g;I)Z
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
    //   295: getfield 128	d/l/b/a/b/e/a$b:NHg	I
    //   298: iconst_1
    //   299: ior
    //   300: putfield 128	d/l/b/a/b/e/a$b:NHg	I
    //   303: iload_3
    //   304: istore 5
    //   306: iload_3
    //   307: istore 4
    //   309: iload_3
    //   310: istore 6
    //   312: aload_0
    //   313: aload_1
    //   314: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   317: putfield 133	d/l/b/a/b/e/a$b:NHz	I
    //   320: goto -264 -> 56
    //   323: astore_1
    //   324: iload 5
    //   326: istore 4
    //   328: aload_1
    //   329: aload_0
    //   330: putfield 137	d/l/b/a/b/h/k:NOw	Ld/l/b/a/b/h/q;
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
    //   361: getfield 139	d/l/b/a/b/e/a$b:NHU	Ljava/util/List;
    //   364: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   367: putfield 139	d/l/b/a/b/e/a$b:NHU	Ljava/util/List;
    //   370: iload 4
    //   372: bipush 8
    //   374: iand
    //   375: bipush 8
    //   377: if_icmpne +14 -> 391
    //   380: aload_0
    //   381: aload_0
    //   382: getfield 147	d/l/b/a/b/e/a$b:NHS	Ljava/util/List;
    //   385: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   388: putfield 147	d/l/b/a/b/e/a$b:NHS	Ljava/util/List;
    //   391: iload 4
    //   393: bipush 16
    //   395: iand
    //   396: bipush 16
    //   398: if_icmpne +14 -> 412
    //   401: aload_0
    //   402: aload_0
    //   403: getfield 149	d/l/b/a/b/e/a$b:NHT	Ljava/util/List;
    //   406: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   409: putfield 149	d/l/b/a/b/e/a$b:NHT	Ljava/util/List;
    //   412: iload 4
    //   414: bipush 64
    //   416: iand
    //   417: bipush 64
    //   419: if_icmpne +14 -> 433
    //   422: aload_0
    //   423: aload_0
    //   424: getfield 151	d/l/b/a/b/e/a$b:NHW	Ljava/util/List;
    //   427: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   430: putfield 151	d/l/b/a/b/e/a$b:NHW	Ljava/util/List;
    //   433: iload 4
    //   435: sipush 128
    //   438: iand
    //   439: sipush 128
    //   442: if_icmpne +14 -> 456
    //   445: aload_0
    //   446: aload_0
    //   447: getfield 153	d/l/b/a/b/e/a$b:NHY	Ljava/util/List;
    //   450: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   453: putfield 153	d/l/b/a/b/e/a$b:NHY	Ljava/util/List;
    //   456: iload 4
    //   458: sipush 256
    //   461: iand
    //   462: sipush 256
    //   465: if_icmpne +14 -> 479
    //   468: aload_0
    //   469: aload_0
    //   470: getfield 155	d/l/b/a/b/e/a$b:NHZ	Ljava/util/List;
    //   473: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   476: putfield 155	d/l/b/a/b/e/a$b:NHZ	Ljava/util/List;
    //   479: iload 4
    //   481: sipush 512
    //   484: iand
    //   485: sipush 512
    //   488: if_icmpne +14 -> 502
    //   491: aload_0
    //   492: aload_0
    //   493: getfield 157	d/l/b/a/b/e/a$b:NIa	Ljava/util/List;
    //   496: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   499: putfield 157	d/l/b/a/b/e/a$b:NIa	Ljava/util/List;
    //   502: iload 4
    //   504: sipush 1024
    //   507: iand
    //   508: sipush 1024
    //   511: if_icmpne +14 -> 525
    //   514: aload_0
    //   515: aload_0
    //   516: getfield 159	d/l/b/a/b/e/a$b:NIb	Ljava/util/List;
    //   519: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   522: putfield 159	d/l/b/a/b/e/a$b:NIb	Ljava/util/List;
    //   525: iload 4
    //   527: sipush 2048
    //   530: iand
    //   531: sipush 2048
    //   534: if_icmpne +14 -> 548
    //   537: aload_0
    //   538: aload_0
    //   539: getfield 161	d/l/b/a/b/e/a$b:NIc	Ljava/util/List;
    //   542: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   545: putfield 161	d/l/b/a/b/e/a$b:NIc	Ljava/util/List;
    //   548: iload 4
    //   550: sipush 4096
    //   553: iand
    //   554: sipush 4096
    //   557: if_icmpne +14 -> 571
    //   560: aload_0
    //   561: aload_0
    //   562: getfield 163	d/l/b/a/b/e/a$b:NId	Ljava/util/List;
    //   565: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   568: putfield 163	d/l/b/a/b/e/a$b:NId	Ljava/util/List;
    //   571: iload 4
    //   573: sipush 16384
    //   576: iand
    //   577: sipush 16384
    //   580: if_icmpne +14 -> 594
    //   583: aload_0
    //   584: aload_0
    //   585: getfield 165	d/l/b/a/b/e/a$b:NIg	Ljava/util/List;
    //   588: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   591: putfield 165	d/l/b/a/b/e/a$b:NIg	Ljava/util/List;
    //   594: aload 12
    //   596: invokevirtual 168	d/l/b/a/b/h/f:flush	()V
    //   599: aload_0
    //   600: aload 11
    //   602: invokevirtual 174	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   605: putfield 101	d/l/b/a/b/e/a$b:NHe	Ld/l/b/a/b/h/d;
    //   608: aload_0
    //   609: getfield 178	d/l/b/a/b/h/i$c:NOg	Ld/l/b/a/b/h/h;
    //   612: invokevirtual 183	d/l/b/a/b/h/h:gwj	()V
    //   615: ldc 107
    //   617: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   620: aload_1
    //   621: athrow
    //   622: iload_3
    //   623: istore 7
    //   625: iload_3
    //   626: bipush 32
    //   628: iand
    //   629: bipush 32
    //   631: if_icmpeq +29 -> 660
    //   634: iload_3
    //   635: istore 5
    //   637: iload_3
    //   638: istore 4
    //   640: iload_3
    //   641: istore 6
    //   643: aload_0
    //   644: new 185	java/util/ArrayList
    //   647: dup
    //   648: invokespecial 186	java/util/ArrayList:<init>	()V
    //   651: putfield 139	d/l/b/a/b/e/a$b:NHU	Ljava/util/List;
    //   654: iload_3
    //   655: bipush 32
    //   657: ior
    //   658: istore 7
    //   660: iload 7
    //   662: istore 5
    //   664: iload 7
    //   666: istore 4
    //   668: iload 7
    //   670: istore 6
    //   672: aload_0
    //   673: getfield 139	d/l/b/a/b/e/a$b:NHU	Ljava/util/List;
    //   676: aload_1
    //   677: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   680: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   683: invokeinterface 198 2 0
    //   688: pop
    //   689: iload 7
    //   691: istore_3
    //   692: goto -636 -> 56
    //   695: astore_1
    //   696: iload 6
    //   698: istore 4
    //   700: new 104	d/l/b/a/b/h/k
    //   703: dup
    //   704: aload_1
    //   705: invokevirtual 202	java/io/IOException:getMessage	()Ljava/lang/String;
    //   708: invokespecial 205	d/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   711: astore_1
    //   712: iload 6
    //   714: istore 4
    //   716: aload_1
    //   717: aload_0
    //   718: putfield 137	d/l/b/a/b/h/k:NOw	Ld/l/b/a/b/h/q;
    //   721: iload 6
    //   723: istore 4
    //   725: ldc 107
    //   727: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   730: iload 6
    //   732: istore 4
    //   734: aload_1
    //   735: athrow
    //   736: iload_3
    //   737: istore 5
    //   739: iload_3
    //   740: istore 4
    //   742: iload_3
    //   743: istore 6
    //   745: aload_1
    //   746: aload_1
    //   747: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   750: invokevirtual 209	d/l/b/a/b/h/e:fG	(I)I
    //   753: istore 9
    //   755: iload_3
    //   756: istore 7
    //   758: iload_3
    //   759: bipush 32
    //   761: iand
    //   762: bipush 32
    //   764: if_icmpeq +48 -> 812
    //   767: iload_3
    //   768: istore 5
    //   770: iload_3
    //   771: istore 4
    //   773: iload_3
    //   774: istore 6
    //   776: iload_3
    //   777: istore 7
    //   779: aload_1
    //   780: invokevirtual 212	d/l/b/a/b/h/e:zf	()I
    //   783: ifle +29 -> 812
    //   786: iload_3
    //   787: istore 5
    //   789: iload_3
    //   790: istore 4
    //   792: iload_3
    //   793: istore 6
    //   795: aload_0
    //   796: new 185	java/util/ArrayList
    //   799: dup
    //   800: invokespecial 186	java/util/ArrayList:<init>	()V
    //   803: putfield 139	d/l/b/a/b/e/a$b:NHU	Ljava/util/List;
    //   806: iload_3
    //   807: bipush 32
    //   809: ior
    //   810: istore 7
    //   812: iload 7
    //   814: istore 5
    //   816: iload 7
    //   818: istore 4
    //   820: iload 7
    //   822: istore 6
    //   824: aload_1
    //   825: invokevirtual 212	d/l/b/a/b/h/e:zf	()I
    //   828: ifle +35 -> 863
    //   831: iload 7
    //   833: istore 5
    //   835: iload 7
    //   837: istore 4
    //   839: iload 7
    //   841: istore 6
    //   843: aload_0
    //   844: getfield 139	d/l/b/a/b/e/a$b:NHU	Ljava/util/List;
    //   847: aload_1
    //   848: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   851: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   854: invokeinterface 198 2 0
    //   859: pop
    //   860: goto -48 -> 812
    //   863: iload 7
    //   865: istore 5
    //   867: iload 7
    //   869: istore 4
    //   871: iload 7
    //   873: istore 6
    //   875: aload_1
    //   876: iload 9
    //   878: invokevirtual 215	d/l/b/a/b/h/e:fH	(I)V
    //   881: iload 7
    //   883: istore_3
    //   884: goto -828 -> 56
    //   887: iload_3
    //   888: istore 5
    //   890: iload_3
    //   891: istore 4
    //   893: iload_3
    //   894: istore 6
    //   896: aload_0
    //   897: aload_0
    //   898: getfield 128	d/l/b/a/b/e/a$b:NHg	I
    //   901: iconst_2
    //   902: ior
    //   903: putfield 128	d/l/b/a/b/e/a$b:NHg	I
    //   906: iload_3
    //   907: istore 5
    //   909: iload_3
    //   910: istore 4
    //   912: iload_3
    //   913: istore 6
    //   915: aload_0
    //   916: aload_1
    //   917: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   920: putfield 217	d/l/b/a/b/e/a$b:NHQ	I
    //   923: goto -867 -> 56
    //   926: iload_3
    //   927: istore 5
    //   929: iload_3
    //   930: istore 4
    //   932: iload_3
    //   933: istore 6
    //   935: aload_0
    //   936: aload_0
    //   937: getfield 128	d/l/b/a/b/e/a$b:NHg	I
    //   940: iconst_4
    //   941: ior
    //   942: putfield 128	d/l/b/a/b/e/a$b:NHg	I
    //   945: iload_3
    //   946: istore 5
    //   948: iload_3
    //   949: istore 4
    //   951: iload_3
    //   952: istore 6
    //   954: aload_0
    //   955: aload_1
    //   956: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   959: putfield 219	d/l/b/a/b/e/a$b:NHR	I
    //   962: goto -906 -> 56
    //   965: iload_3
    //   966: istore 7
    //   968: iload_3
    //   969: bipush 8
    //   971: iand
    //   972: bipush 8
    //   974: if_icmpeq +29 -> 1003
    //   977: iload_3
    //   978: istore 5
    //   980: iload_3
    //   981: istore 4
    //   983: iload_3
    //   984: istore 6
    //   986: aload_0
    //   987: new 185	java/util/ArrayList
    //   990: dup
    //   991: invokespecial 186	java/util/ArrayList:<init>	()V
    //   994: putfield 147	d/l/b/a/b/e/a$b:NHS	Ljava/util/List;
    //   997: iload_3
    //   998: bipush 8
    //   1000: ior
    //   1001: istore 7
    //   1003: iload 7
    //   1005: istore 5
    //   1007: iload 7
    //   1009: istore 4
    //   1011: iload 7
    //   1013: istore 6
    //   1015: aload_0
    //   1016: getfield 147	d/l/b/a/b/e/a$b:NHS	Ljava/util/List;
    //   1019: aload_1
    //   1020: getstatic 222	d/l/b/a/b/e/a$r:NHf	Ld/l/b/a/b/h/s;
    //   1023: aload_2
    //   1024: invokevirtual 225	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   1027: invokeinterface 198 2 0
    //   1032: pop
    //   1033: iload 7
    //   1035: istore_3
    //   1036: goto -980 -> 56
    //   1039: iload_3
    //   1040: istore 7
    //   1042: iload_3
    //   1043: bipush 16
    //   1045: iand
    //   1046: bipush 16
    //   1048: if_icmpeq +29 -> 1077
    //   1051: iload_3
    //   1052: istore 5
    //   1054: iload_3
    //   1055: istore 4
    //   1057: iload_3
    //   1058: istore 6
    //   1060: aload_0
    //   1061: new 185	java/util/ArrayList
    //   1064: dup
    //   1065: invokespecial 186	java/util/ArrayList:<init>	()V
    //   1068: putfield 149	d/l/b/a/b/e/a$b:NHT	Ljava/util/List;
    //   1071: iload_3
    //   1072: bipush 16
    //   1074: ior
    //   1075: istore 7
    //   1077: iload 7
    //   1079: istore 5
    //   1081: iload 7
    //   1083: istore 4
    //   1085: iload 7
    //   1087: istore 6
    //   1089: aload_0
    //   1090: getfield 149	d/l/b/a/b/e/a$b:NHT	Ljava/util/List;
    //   1093: aload_1
    //   1094: getstatic 228	d/l/b/a/b/e/a$p:NHf	Ld/l/b/a/b/h/s;
    //   1097: aload_2
    //   1098: invokevirtual 225	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   1101: invokeinterface 198 2 0
    //   1106: pop
    //   1107: iload 7
    //   1109: istore_3
    //   1110: goto -1054 -> 56
    //   1113: iload_3
    //   1114: istore 7
    //   1116: iload_3
    //   1117: bipush 64
    //   1119: iand
    //   1120: bipush 64
    //   1122: if_icmpeq +29 -> 1151
    //   1125: iload_3
    //   1126: istore 5
    //   1128: iload_3
    //   1129: istore 4
    //   1131: iload_3
    //   1132: istore 6
    //   1134: aload_0
    //   1135: new 185	java/util/ArrayList
    //   1138: dup
    //   1139: invokespecial 186	java/util/ArrayList:<init>	()V
    //   1142: putfield 151	d/l/b/a/b/e/a$b:NHW	Ljava/util/List;
    //   1145: iload_3
    //   1146: bipush 64
    //   1148: ior
    //   1149: istore 7
    //   1151: iload 7
    //   1153: istore 5
    //   1155: iload 7
    //   1157: istore 4
    //   1159: iload 7
    //   1161: istore 6
    //   1163: aload_0
    //   1164: getfield 151	d/l/b/a/b/e/a$b:NHW	Ljava/util/List;
    //   1167: aload_1
    //   1168: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   1171: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1174: invokeinterface 198 2 0
    //   1179: pop
    //   1180: iload 7
    //   1182: istore_3
    //   1183: goto -1127 -> 56
    //   1186: iload_3
    //   1187: istore 5
    //   1189: iload_3
    //   1190: istore 4
    //   1192: iload_3
    //   1193: istore 6
    //   1195: aload_1
    //   1196: aload_1
    //   1197: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   1200: invokevirtual 209	d/l/b/a/b/h/e:fG	(I)I
    //   1203: istore 9
    //   1205: iload_3
    //   1206: istore 7
    //   1208: iload_3
    //   1209: bipush 64
    //   1211: iand
    //   1212: bipush 64
    //   1214: if_icmpeq +48 -> 1262
    //   1217: iload_3
    //   1218: istore 5
    //   1220: iload_3
    //   1221: istore 4
    //   1223: iload_3
    //   1224: istore 6
    //   1226: iload_3
    //   1227: istore 7
    //   1229: aload_1
    //   1230: invokevirtual 212	d/l/b/a/b/h/e:zf	()I
    //   1233: ifle +29 -> 1262
    //   1236: iload_3
    //   1237: istore 5
    //   1239: iload_3
    //   1240: istore 4
    //   1242: iload_3
    //   1243: istore 6
    //   1245: aload_0
    //   1246: new 185	java/util/ArrayList
    //   1249: dup
    //   1250: invokespecial 186	java/util/ArrayList:<init>	()V
    //   1253: putfield 151	d/l/b/a/b/e/a$b:NHW	Ljava/util/List;
    //   1256: iload_3
    //   1257: bipush 64
    //   1259: ior
    //   1260: istore 7
    //   1262: iload 7
    //   1264: istore 5
    //   1266: iload 7
    //   1268: istore 4
    //   1270: iload 7
    //   1272: istore 6
    //   1274: aload_1
    //   1275: invokevirtual 212	d/l/b/a/b/h/e:zf	()I
    //   1278: ifle +35 -> 1313
    //   1281: iload 7
    //   1283: istore 5
    //   1285: iload 7
    //   1287: istore 4
    //   1289: iload 7
    //   1291: istore 6
    //   1293: aload_0
    //   1294: getfield 151	d/l/b/a/b/e/a$b:NHW	Ljava/util/List;
    //   1297: aload_1
    //   1298: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   1301: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1304: invokeinterface 198 2 0
    //   1309: pop
    //   1310: goto -48 -> 1262
    //   1313: iload 7
    //   1315: istore 5
    //   1317: iload 7
    //   1319: istore 4
    //   1321: iload 7
    //   1323: istore 6
    //   1325: aload_1
    //   1326: iload 9
    //   1328: invokevirtual 215	d/l/b/a/b/h/e:fH	(I)V
    //   1331: iload 7
    //   1333: istore_3
    //   1334: goto -1278 -> 56
    //   1337: iload_3
    //   1338: istore 7
    //   1340: iload_3
    //   1341: sipush 128
    //   1344: iand
    //   1345: sipush 128
    //   1348: if_icmpeq +30 -> 1378
    //   1351: iload_3
    //   1352: istore 5
    //   1354: iload_3
    //   1355: istore 4
    //   1357: iload_3
    //   1358: istore 6
    //   1360: aload_0
    //   1361: new 185	java/util/ArrayList
    //   1364: dup
    //   1365: invokespecial 186	java/util/ArrayList:<init>	()V
    //   1368: putfield 153	d/l/b/a/b/e/a$b:NHY	Ljava/util/List;
    //   1371: iload_3
    //   1372: sipush 128
    //   1375: ior
    //   1376: istore 7
    //   1378: iload 7
    //   1380: istore 5
    //   1382: iload 7
    //   1384: istore 4
    //   1386: iload 7
    //   1388: istore 6
    //   1390: aload_0
    //   1391: getfield 153	d/l/b/a/b/e/a$b:NHY	Ljava/util/List;
    //   1394: aload_1
    //   1395: getstatic 231	d/l/b/a/b/e/a$c:NHf	Ld/l/b/a/b/h/s;
    //   1398: aload_2
    //   1399: invokevirtual 225	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   1402: invokeinterface 198 2 0
    //   1407: pop
    //   1408: iload 7
    //   1410: istore_3
    //   1411: goto -1355 -> 56
    //   1414: iload_3
    //   1415: istore 7
    //   1417: iload_3
    //   1418: sipush 256
    //   1421: iand
    //   1422: sipush 256
    //   1425: if_icmpeq +30 -> 1455
    //   1428: iload_3
    //   1429: istore 5
    //   1431: iload_3
    //   1432: istore 4
    //   1434: iload_3
    //   1435: istore 6
    //   1437: aload_0
    //   1438: new 185	java/util/ArrayList
    //   1441: dup
    //   1442: invokespecial 186	java/util/ArrayList:<init>	()V
    //   1445: putfield 155	d/l/b/a/b/e/a$b:NHZ	Ljava/util/List;
    //   1448: iload_3
    //   1449: sipush 256
    //   1452: ior
    //   1453: istore 7
    //   1455: iload 7
    //   1457: istore 5
    //   1459: iload 7
    //   1461: istore 4
    //   1463: iload 7
    //   1465: istore 6
    //   1467: aload_0
    //   1468: getfield 155	d/l/b/a/b/e/a$b:NHZ	Ljava/util/List;
    //   1471: aload_1
    //   1472: getstatic 234	d/l/b/a/b/e/a$h:NHf	Ld/l/b/a/b/h/s;
    //   1475: aload_2
    //   1476: invokevirtual 225	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   1479: invokeinterface 198 2 0
    //   1484: pop
    //   1485: iload 7
    //   1487: istore_3
    //   1488: goto -1432 -> 56
    //   1491: iload_3
    //   1492: istore 7
    //   1494: iload_3
    //   1495: sipush 512
    //   1498: iand
    //   1499: sipush 512
    //   1502: if_icmpeq +30 -> 1532
    //   1505: iload_3
    //   1506: istore 5
    //   1508: iload_3
    //   1509: istore 4
    //   1511: iload_3
    //   1512: istore 6
    //   1514: aload_0
    //   1515: new 185	java/util/ArrayList
    //   1518: dup
    //   1519: invokespecial 186	java/util/ArrayList:<init>	()V
    //   1522: putfield 157	d/l/b/a/b/e/a$b:NIa	Ljava/util/List;
    //   1525: iload_3
    //   1526: sipush 512
    //   1529: ior
    //   1530: istore 7
    //   1532: iload 7
    //   1534: istore 5
    //   1536: iload 7
    //   1538: istore 4
    //   1540: iload 7
    //   1542: istore 6
    //   1544: aload_0
    //   1545: getfield 157	d/l/b/a/b/e/a$b:NIa	Ljava/util/List;
    //   1548: aload_1
    //   1549: getstatic 237	d/l/b/a/b/e/a$m:NHf	Ld/l/b/a/b/h/s;
    //   1552: aload_2
    //   1553: invokevirtual 225	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   1556: invokeinterface 198 2 0
    //   1561: pop
    //   1562: iload 7
    //   1564: istore_3
    //   1565: goto -1509 -> 56
    //   1568: iload_3
    //   1569: istore 7
    //   1571: iload_3
    //   1572: sipush 1024
    //   1575: iand
    //   1576: sipush 1024
    //   1579: if_icmpeq +30 -> 1609
    //   1582: iload_3
    //   1583: istore 5
    //   1585: iload_3
    //   1586: istore 4
    //   1588: iload_3
    //   1589: istore 6
    //   1591: aload_0
    //   1592: new 185	java/util/ArrayList
    //   1595: dup
    //   1596: invokespecial 186	java/util/ArrayList:<init>	()V
    //   1599: putfield 159	d/l/b/a/b/e/a$b:NIb	Ljava/util/List;
    //   1602: iload_3
    //   1603: sipush 1024
    //   1606: ior
    //   1607: istore 7
    //   1609: iload 7
    //   1611: istore 5
    //   1613: iload 7
    //   1615: istore 4
    //   1617: iload 7
    //   1619: istore 6
    //   1621: aload_0
    //   1622: getfield 159	d/l/b/a/b/e/a$b:NIb	Ljava/util/List;
    //   1625: aload_1
    //   1626: getstatic 240	d/l/b/a/b/e/a$q:NHf	Ld/l/b/a/b/h/s;
    //   1629: aload_2
    //   1630: invokevirtual 225	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   1633: invokeinterface 198 2 0
    //   1638: pop
    //   1639: iload 7
    //   1641: istore_3
    //   1642: goto -1586 -> 56
    //   1645: iload_3
    //   1646: istore 7
    //   1648: iload_3
    //   1649: sipush 2048
    //   1652: iand
    //   1653: sipush 2048
    //   1656: if_icmpeq +30 -> 1686
    //   1659: iload_3
    //   1660: istore 5
    //   1662: iload_3
    //   1663: istore 4
    //   1665: iload_3
    //   1666: istore 6
    //   1668: aload_0
    //   1669: new 185	java/util/ArrayList
    //   1672: dup
    //   1673: invokespecial 186	java/util/ArrayList:<init>	()V
    //   1676: putfield 161	d/l/b/a/b/e/a$b:NIc	Ljava/util/List;
    //   1679: iload_3
    //   1680: sipush 2048
    //   1683: ior
    //   1684: istore 7
    //   1686: iload 7
    //   1688: istore 5
    //   1690: iload 7
    //   1692: istore 4
    //   1694: iload 7
    //   1696: istore 6
    //   1698: aload_0
    //   1699: getfield 161	d/l/b/a/b/e/a$b:NIc	Ljava/util/List;
    //   1702: aload_1
    //   1703: getstatic 243	d/l/b/a/b/e/a$f:NHf	Ld/l/b/a/b/h/s;
    //   1706: aload_2
    //   1707: invokevirtual 225	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   1710: invokeinterface 198 2 0
    //   1715: pop
    //   1716: iload 7
    //   1718: istore_3
    //   1719: goto -1663 -> 56
    //   1722: iload_3
    //   1723: istore 7
    //   1725: iload_3
    //   1726: sipush 4096
    //   1729: iand
    //   1730: sipush 4096
    //   1733: if_icmpeq +30 -> 1763
    //   1736: iload_3
    //   1737: istore 5
    //   1739: iload_3
    //   1740: istore 4
    //   1742: iload_3
    //   1743: istore 6
    //   1745: aload_0
    //   1746: new 185	java/util/ArrayList
    //   1749: dup
    //   1750: invokespecial 186	java/util/ArrayList:<init>	()V
    //   1753: putfield 163	d/l/b/a/b/e/a$b:NId	Ljava/util/List;
    //   1756: iload_3
    //   1757: sipush 4096
    //   1760: ior
    //   1761: istore 7
    //   1763: iload 7
    //   1765: istore 5
    //   1767: iload 7
    //   1769: istore 4
    //   1771: iload 7
    //   1773: istore 6
    //   1775: aload_0
    //   1776: getfield 163	d/l/b/a/b/e/a$b:NId	Ljava/util/List;
    //   1779: aload_1
    //   1780: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   1783: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1786: invokeinterface 198 2 0
    //   1791: pop
    //   1792: iload 7
    //   1794: istore_3
    //   1795: goto -1739 -> 56
    //   1798: iload_3
    //   1799: istore 5
    //   1801: iload_3
    //   1802: istore 4
    //   1804: iload_3
    //   1805: istore 6
    //   1807: aload_1
    //   1808: aload_1
    //   1809: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   1812: invokevirtual 209	d/l/b/a/b/h/e:fG	(I)I
    //   1815: istore 9
    //   1817: iload_3
    //   1818: istore 7
    //   1820: iload_3
    //   1821: sipush 4096
    //   1824: iand
    //   1825: sipush 4096
    //   1828: if_icmpeq +49 -> 1877
    //   1831: iload_3
    //   1832: istore 5
    //   1834: iload_3
    //   1835: istore 4
    //   1837: iload_3
    //   1838: istore 6
    //   1840: iload_3
    //   1841: istore 7
    //   1843: aload_1
    //   1844: invokevirtual 212	d/l/b/a/b/h/e:zf	()I
    //   1847: ifle +30 -> 1877
    //   1850: iload_3
    //   1851: istore 5
    //   1853: iload_3
    //   1854: istore 4
    //   1856: iload_3
    //   1857: istore 6
    //   1859: aload_0
    //   1860: new 185	java/util/ArrayList
    //   1863: dup
    //   1864: invokespecial 186	java/util/ArrayList:<init>	()V
    //   1867: putfield 163	d/l/b/a/b/e/a$b:NId	Ljava/util/List;
    //   1870: iload_3
    //   1871: sipush 4096
    //   1874: ior
    //   1875: istore 7
    //   1877: iload 7
    //   1879: istore 5
    //   1881: iload 7
    //   1883: istore 4
    //   1885: iload 7
    //   1887: istore 6
    //   1889: aload_1
    //   1890: invokevirtual 212	d/l/b/a/b/h/e:zf	()I
    //   1893: ifle +35 -> 1928
    //   1896: iload 7
    //   1898: istore 5
    //   1900: iload 7
    //   1902: istore 4
    //   1904: iload 7
    //   1906: istore 6
    //   1908: aload_0
    //   1909: getfield 163	d/l/b/a/b/e/a$b:NId	Ljava/util/List;
    //   1912: aload_1
    //   1913: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   1916: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1919: invokeinterface 198 2 0
    //   1924: pop
    //   1925: goto -48 -> 1877
    //   1928: iload 7
    //   1930: istore 5
    //   1932: iload 7
    //   1934: istore 4
    //   1936: iload 7
    //   1938: istore 6
    //   1940: aload_1
    //   1941: iload 9
    //   1943: invokevirtual 215	d/l/b/a/b/h/e:fH	(I)V
    //   1946: iload 7
    //   1948: istore_3
    //   1949: goto -1893 -> 56
    //   1952: iload_3
    //   1953: istore 5
    //   1955: iload_3
    //   1956: istore 4
    //   1958: iload_3
    //   1959: istore 6
    //   1961: aload_0
    //   1962: getfield 128	d/l/b/a/b/e/a$b:NHg	I
    //   1965: bipush 8
    //   1967: iand
    //   1968: bipush 8
    //   1970: if_icmpne +795 -> 2765
    //   1973: iload_3
    //   1974: istore 5
    //   1976: iload_3
    //   1977: istore 4
    //   1979: iload_3
    //   1980: istore 6
    //   1982: aload_0
    //   1983: getfield 245	d/l/b/a/b/e/a$b:NIf	Ld/l/b/a/b/e/a$s;
    //   1986: invokestatic 251	d/l/b/a/b/e/a$s:d	(Ld/l/b/a/b/e/a$s;)Ld/l/b/a/b/e/a$s$a;
    //   1989: astore 10
    //   1991: iload_3
    //   1992: istore 5
    //   1994: iload_3
    //   1995: istore 4
    //   1997: iload_3
    //   1998: istore 6
    //   2000: aload_0
    //   2001: aload_1
    //   2002: getstatic 252	d/l/b/a/b/e/a$s:NHf	Ld/l/b/a/b/h/s;
    //   2005: aload_2
    //   2006: invokevirtual 225	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   2009: checkcast 247	d/l/b/a/b/e/a$s
    //   2012: putfield 245	d/l/b/a/b/e/a$b:NIf	Ld/l/b/a/b/e/a$s;
    //   2015: aload 10
    //   2017: ifnull +40 -> 2057
    //   2020: iload_3
    //   2021: istore 5
    //   2023: iload_3
    //   2024: istore 4
    //   2026: iload_3
    //   2027: istore 6
    //   2029: aload 10
    //   2031: aload_0
    //   2032: getfield 245	d/l/b/a/b/e/a$b:NIf	Ld/l/b/a/b/e/a$s;
    //   2035: invokevirtual 257	d/l/b/a/b/e/a$s$a:g	(Ld/l/b/a/b/e/a$s;)Ld/l/b/a/b/e/a$s$a;
    //   2038: pop
    //   2039: iload_3
    //   2040: istore 5
    //   2042: iload_3
    //   2043: istore 4
    //   2045: iload_3
    //   2046: istore 6
    //   2048: aload_0
    //   2049: aload 10
    //   2051: invokevirtual 261	d/l/b/a/b/e/a$s$a:gun	()Ld/l/b/a/b/e/a$s;
    //   2054: putfield 245	d/l/b/a/b/e/a$b:NIf	Ld/l/b/a/b/e/a$s;
    //   2057: iload_3
    //   2058: istore 5
    //   2060: iload_3
    //   2061: istore 4
    //   2063: iload_3
    //   2064: istore 6
    //   2066: aload_0
    //   2067: aload_0
    //   2068: getfield 128	d/l/b/a/b/e/a$b:NHg	I
    //   2071: bipush 8
    //   2073: ior
    //   2074: putfield 128	d/l/b/a/b/e/a$b:NHg	I
    //   2077: goto -2021 -> 56
    //   2080: iload_3
    //   2081: istore 7
    //   2083: iload_3
    //   2084: sipush 16384
    //   2087: iand
    //   2088: sipush 16384
    //   2091: if_icmpeq +30 -> 2121
    //   2094: iload_3
    //   2095: istore 5
    //   2097: iload_3
    //   2098: istore 4
    //   2100: iload_3
    //   2101: istore 6
    //   2103: aload_0
    //   2104: new 185	java/util/ArrayList
    //   2107: dup
    //   2108: invokespecial 186	java/util/ArrayList:<init>	()V
    //   2111: putfield 165	d/l/b/a/b/e/a$b:NIg	Ljava/util/List;
    //   2114: iload_3
    //   2115: sipush 16384
    //   2118: ior
    //   2119: istore 7
    //   2121: iload 7
    //   2123: istore 5
    //   2125: iload 7
    //   2127: istore 4
    //   2129: iload 7
    //   2131: istore 6
    //   2133: aload_0
    //   2134: getfield 165	d/l/b/a/b/e/a$b:NIg	Ljava/util/List;
    //   2137: aload_1
    //   2138: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   2141: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2144: invokeinterface 198 2 0
    //   2149: pop
    //   2150: iload 7
    //   2152: istore_3
    //   2153: goto -2097 -> 56
    //   2156: iload_3
    //   2157: istore 5
    //   2159: iload_3
    //   2160: istore 4
    //   2162: iload_3
    //   2163: istore 6
    //   2165: aload_1
    //   2166: aload_1
    //   2167: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   2170: invokevirtual 209	d/l/b/a/b/h/e:fG	(I)I
    //   2173: istore 9
    //   2175: iload_3
    //   2176: istore 7
    //   2178: iload_3
    //   2179: sipush 16384
    //   2182: iand
    //   2183: sipush 16384
    //   2186: if_icmpeq +49 -> 2235
    //   2189: iload_3
    //   2190: istore 5
    //   2192: iload_3
    //   2193: istore 4
    //   2195: iload_3
    //   2196: istore 6
    //   2198: iload_3
    //   2199: istore 7
    //   2201: aload_1
    //   2202: invokevirtual 212	d/l/b/a/b/h/e:zf	()I
    //   2205: ifle +30 -> 2235
    //   2208: iload_3
    //   2209: istore 5
    //   2211: iload_3
    //   2212: istore 4
    //   2214: iload_3
    //   2215: istore 6
    //   2217: aload_0
    //   2218: new 185	java/util/ArrayList
    //   2221: dup
    //   2222: invokespecial 186	java/util/ArrayList:<init>	()V
    //   2225: putfield 165	d/l/b/a/b/e/a$b:NIg	Ljava/util/List;
    //   2228: iload_3
    //   2229: sipush 16384
    //   2232: ior
    //   2233: istore 7
    //   2235: iload 7
    //   2237: istore 5
    //   2239: iload 7
    //   2241: istore 4
    //   2243: iload 7
    //   2245: istore 6
    //   2247: aload_1
    //   2248: invokevirtual 212	d/l/b/a/b/h/e:zf	()I
    //   2251: ifle +35 -> 2286
    //   2254: iload 7
    //   2256: istore 5
    //   2258: iload 7
    //   2260: istore 4
    //   2262: iload 7
    //   2264: istore 6
    //   2266: aload_0
    //   2267: getfield 165	d/l/b/a/b/e/a$b:NIg	Ljava/util/List;
    //   2270: aload_1
    //   2271: invokevirtual 131	d/l/b/a/b/h/e:zc	()I
    //   2274: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2277: invokeinterface 198 2 0
    //   2282: pop
    //   2283: goto -48 -> 2235
    //   2286: iload 7
    //   2288: istore 5
    //   2290: iload 7
    //   2292: istore 4
    //   2294: iload 7
    //   2296: istore 6
    //   2298: aload_1
    //   2299: iload 9
    //   2301: invokevirtual 215	d/l/b/a/b/h/e:fH	(I)V
    //   2304: iload 7
    //   2306: istore_3
    //   2307: goto -2251 -> 56
    //   2310: iload_3
    //   2311: istore 5
    //   2313: iload_3
    //   2314: istore 4
    //   2316: iload_3
    //   2317: istore 6
    //   2319: aload_0
    //   2320: getfield 128	d/l/b/a/b/e/a$b:NHg	I
    //   2323: bipush 16
    //   2325: iand
    //   2326: bipush 16
    //   2328: if_icmpne +431 -> 2759
    //   2331: iload_3
    //   2332: istore 5
    //   2334: iload_3
    //   2335: istore 4
    //   2337: iload_3
    //   2338: istore 6
    //   2340: aload_0
    //   2341: getfield 263	d/l/b/a/b/e/a$b:NIh	Ld/l/b/a/b/e/a$v;
    //   2344: invokestatic 269	d/l/b/a/b/e/a$v:c	(Ld/l/b/a/b/e/a$v;)Ld/l/b/a/b/e/a$v$a;
    //   2347: astore 10
    //   2349: iload_3
    //   2350: istore 5
    //   2352: iload_3
    //   2353: istore 4
    //   2355: iload_3
    //   2356: istore 6
    //   2358: aload_0
    //   2359: aload_1
    //   2360: getstatic 270	d/l/b/a/b/e/a$v:NHf	Ld/l/b/a/b/h/s;
    //   2363: aload_2
    //   2364: invokevirtual 225	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   2367: checkcast 265	d/l/b/a/b/e/a$v
    //   2370: putfield 263	d/l/b/a/b/e/a$b:NIh	Ld/l/b/a/b/e/a$v;
    //   2373: aload 10
    //   2375: ifnull +40 -> 2415
    //   2378: iload_3
    //   2379: istore 5
    //   2381: iload_3
    //   2382: istore 4
    //   2384: iload_3
    //   2385: istore 6
    //   2387: aload 10
    //   2389: aload_0
    //   2390: getfield 263	d/l/b/a/b/e/a$b:NIh	Ld/l/b/a/b/e/a$v;
    //   2393: invokevirtual 274	d/l/b/a/b/e/a$v$a:f	(Ld/l/b/a/b/e/a$v;)Ld/l/b/a/b/e/a$v$a;
    //   2396: pop
    //   2397: iload_3
    //   2398: istore 5
    //   2400: iload_3
    //   2401: istore 4
    //   2403: iload_3
    //   2404: istore 6
    //   2406: aload_0
    //   2407: aload 10
    //   2409: invokevirtual 278	d/l/b/a/b/e/a$v$a:guI	()Ld/l/b/a/b/e/a$v;
    //   2412: putfield 263	d/l/b/a/b/e/a$b:NIh	Ld/l/b/a/b/e/a$v;
    //   2415: iload_3
    //   2416: istore 5
    //   2418: iload_3
    //   2419: istore 4
    //   2421: iload_3
    //   2422: istore 6
    //   2424: aload_0
    //   2425: aload_0
    //   2426: getfield 128	d/l/b/a/b/e/a$b:NHg	I
    //   2429: bipush 16
    //   2431: ior
    //   2432: putfield 128	d/l/b/a/b/e/a$b:NHg	I
    //   2435: goto -2379 -> 56
    //   2438: iload_3
    //   2439: bipush 32
    //   2441: iand
    //   2442: bipush 32
    //   2444: if_icmpne +14 -> 2458
    //   2447: aload_0
    //   2448: aload_0
    //   2449: getfield 139	d/l/b/a/b/e/a$b:NHU	Ljava/util/List;
    //   2452: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2455: putfield 139	d/l/b/a/b/e/a$b:NHU	Ljava/util/List;
    //   2458: iload_3
    //   2459: bipush 8
    //   2461: iand
    //   2462: bipush 8
    //   2464: if_icmpne +14 -> 2478
    //   2467: aload_0
    //   2468: aload_0
    //   2469: getfield 147	d/l/b/a/b/e/a$b:NHS	Ljava/util/List;
    //   2472: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2475: putfield 147	d/l/b/a/b/e/a$b:NHS	Ljava/util/List;
    //   2478: iload_3
    //   2479: bipush 16
    //   2481: iand
    //   2482: bipush 16
    //   2484: if_icmpne +14 -> 2498
    //   2487: aload_0
    //   2488: aload_0
    //   2489: getfield 149	d/l/b/a/b/e/a$b:NHT	Ljava/util/List;
    //   2492: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2495: putfield 149	d/l/b/a/b/e/a$b:NHT	Ljava/util/List;
    //   2498: iload_3
    //   2499: bipush 64
    //   2501: iand
    //   2502: bipush 64
    //   2504: if_icmpne +14 -> 2518
    //   2507: aload_0
    //   2508: aload_0
    //   2509: getfield 151	d/l/b/a/b/e/a$b:NHW	Ljava/util/List;
    //   2512: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2515: putfield 151	d/l/b/a/b/e/a$b:NHW	Ljava/util/List;
    //   2518: iload_3
    //   2519: sipush 128
    //   2522: iand
    //   2523: sipush 128
    //   2526: if_icmpne +14 -> 2540
    //   2529: aload_0
    //   2530: aload_0
    //   2531: getfield 153	d/l/b/a/b/e/a$b:NHY	Ljava/util/List;
    //   2534: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2537: putfield 153	d/l/b/a/b/e/a$b:NHY	Ljava/util/List;
    //   2540: iload_3
    //   2541: sipush 256
    //   2544: iand
    //   2545: sipush 256
    //   2548: if_icmpne +14 -> 2562
    //   2551: aload_0
    //   2552: aload_0
    //   2553: getfield 155	d/l/b/a/b/e/a$b:NHZ	Ljava/util/List;
    //   2556: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2559: putfield 155	d/l/b/a/b/e/a$b:NHZ	Ljava/util/List;
    //   2562: iload_3
    //   2563: sipush 512
    //   2566: iand
    //   2567: sipush 512
    //   2570: if_icmpne +14 -> 2584
    //   2573: aload_0
    //   2574: aload_0
    //   2575: getfield 157	d/l/b/a/b/e/a$b:NIa	Ljava/util/List;
    //   2578: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2581: putfield 157	d/l/b/a/b/e/a$b:NIa	Ljava/util/List;
    //   2584: iload_3
    //   2585: sipush 1024
    //   2588: iand
    //   2589: sipush 1024
    //   2592: if_icmpne +14 -> 2606
    //   2595: aload_0
    //   2596: aload_0
    //   2597: getfield 159	d/l/b/a/b/e/a$b:NIb	Ljava/util/List;
    //   2600: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2603: putfield 159	d/l/b/a/b/e/a$b:NIb	Ljava/util/List;
    //   2606: iload_3
    //   2607: sipush 2048
    //   2610: iand
    //   2611: sipush 2048
    //   2614: if_icmpne +14 -> 2628
    //   2617: aload_0
    //   2618: aload_0
    //   2619: getfield 161	d/l/b/a/b/e/a$b:NIc	Ljava/util/List;
    //   2622: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2625: putfield 161	d/l/b/a/b/e/a$b:NIc	Ljava/util/List;
    //   2628: iload_3
    //   2629: sipush 4096
    //   2632: iand
    //   2633: sipush 4096
    //   2636: if_icmpne +14 -> 2650
    //   2639: aload_0
    //   2640: aload_0
    //   2641: getfield 163	d/l/b/a/b/e/a$b:NId	Ljava/util/List;
    //   2644: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2647: putfield 163	d/l/b/a/b/e/a$b:NId	Ljava/util/List;
    //   2650: iload_3
    //   2651: sipush 16384
    //   2654: iand
    //   2655: sipush 16384
    //   2658: if_icmpne +14 -> 2672
    //   2661: aload_0
    //   2662: aload_0
    //   2663: getfield 165	d/l/b/a/b/e/a$b:NIg	Ljava/util/List;
    //   2666: invokestatic 145	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2669: putfield 165	d/l/b/a/b/e/a$b:NIg	Ljava/util/List;
    //   2672: aload 12
    //   2674: invokevirtual 168	d/l/b/a/b/h/f:flush	()V
    //   2677: aload_0
    //   2678: aload 11
    //   2680: invokevirtual 174	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   2683: putfield 101	d/l/b/a/b/e/a$b:NHe	Ld/l/b/a/b/h/d;
    //   2686: aload_0
    //   2687: getfield 178	d/l/b/a/b/h/i$c:NOg	Ld/l/b/a/b/h/h;
    //   2690: invokevirtual 183	d/l/b/a/b/h/h:gwj	()V
    //   2693: ldc 107
    //   2695: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2698: return
    //   2699: astore_1
    //   2700: aload_0
    //   2701: aload 11
    //   2703: invokevirtual 174	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   2706: putfield 101	d/l/b/a/b/e/a$b:NHe	Ld/l/b/a/b/h/d;
    //   2709: goto -23 -> 2686
    //   2712: astore_1
    //   2713: aload_0
    //   2714: aload 11
    //   2716: invokevirtual 174	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   2719: putfield 101	d/l/b/a/b/e/a$b:NHe	Ld/l/b/a/b/h/d;
    //   2722: ldc 107
    //   2724: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2727: aload_1
    //   2728: athrow
    //   2729: astore_2
    //   2730: aload_0
    //   2731: aload 11
    //   2733: invokevirtual 174	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   2736: putfield 101	d/l/b/a/b/e/a$b:NHe	Ld/l/b/a/b/h/d;
    //   2739: goto -2131 -> 608
    //   2742: astore_1
    //   2743: aload_0
    //   2744: aload 11
    //   2746: invokevirtual 174	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   2749: putfield 101	d/l/b/a/b/e/a$b:NHe	Ld/l/b/a/b/h/d;
    //   2752: ldc 107
    //   2754: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2757: aload_1
    //   2758: athrow
    //   2759: aconst_null
    //   2760: astore 10
    //   2762: goto -413 -> 2349
    //   2765: aconst_null
    //   2766: astore 10
    //   2768: goto -777 -> 1991
    //   2771: goto -2515 -> 256
    //   2774: iconst_1
    //   2775: istore 8
    //   2777: goto -2721 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2780	0	this	b
    //   0	2780	1	parame	d.l.b.a.b.h.e
    //   0	2780	2	paramg	g
    //   39	2616	3	i	int
    //   65	2355	4	j	int
    //   62	2355	5	k	int
    //   68	2355	6	m	int
    //   74	2231	7	n	int
    //   54	2722	8	i1	int
    //   753	1547	9	i2	int
    //   1989	778	10	localObject	java.lang.Object
    //   43	2702	11	localb	d.l.b.a.b.h.d.b
    //   51	2622	12	localf	f
    // Exception table:
    //   from	to	target	type
    //   70	76	323	d/l/b/a/b/h/k
    //   265	278	323	d/l/b/a/b/h/k
    //   293	303	323	d/l/b/a/b/h/k
    //   312	320	323	d/l/b/a/b/h/k
    //   643	654	323	d/l/b/a/b/h/k
    //   672	689	323	d/l/b/a/b/h/k
    //   745	755	323	d/l/b/a/b/h/k
    //   779	786	323	d/l/b/a/b/h/k
    //   795	806	323	d/l/b/a/b/h/k
    //   824	831	323	d/l/b/a/b/h/k
    //   843	860	323	d/l/b/a/b/h/k
    //   875	881	323	d/l/b/a/b/h/k
    //   896	906	323	d/l/b/a/b/h/k
    //   915	923	323	d/l/b/a/b/h/k
    //   935	945	323	d/l/b/a/b/h/k
    //   954	962	323	d/l/b/a/b/h/k
    //   986	997	323	d/l/b/a/b/h/k
    //   1015	1033	323	d/l/b/a/b/h/k
    //   1060	1071	323	d/l/b/a/b/h/k
    //   1089	1107	323	d/l/b/a/b/h/k
    //   1134	1145	323	d/l/b/a/b/h/k
    //   1163	1180	323	d/l/b/a/b/h/k
    //   1195	1205	323	d/l/b/a/b/h/k
    //   1229	1236	323	d/l/b/a/b/h/k
    //   1245	1256	323	d/l/b/a/b/h/k
    //   1274	1281	323	d/l/b/a/b/h/k
    //   1293	1310	323	d/l/b/a/b/h/k
    //   1325	1331	323	d/l/b/a/b/h/k
    //   1360	1371	323	d/l/b/a/b/h/k
    //   1390	1408	323	d/l/b/a/b/h/k
    //   1437	1448	323	d/l/b/a/b/h/k
    //   1467	1485	323	d/l/b/a/b/h/k
    //   1514	1525	323	d/l/b/a/b/h/k
    //   1544	1562	323	d/l/b/a/b/h/k
    //   1591	1602	323	d/l/b/a/b/h/k
    //   1621	1639	323	d/l/b/a/b/h/k
    //   1668	1679	323	d/l/b/a/b/h/k
    //   1698	1716	323	d/l/b/a/b/h/k
    //   1745	1756	323	d/l/b/a/b/h/k
    //   1775	1792	323	d/l/b/a/b/h/k
    //   1807	1817	323	d/l/b/a/b/h/k
    //   1843	1850	323	d/l/b/a/b/h/k
    //   1859	1870	323	d/l/b/a/b/h/k
    //   1889	1896	323	d/l/b/a/b/h/k
    //   1908	1925	323	d/l/b/a/b/h/k
    //   1940	1946	323	d/l/b/a/b/h/k
    //   1961	1973	323	d/l/b/a/b/h/k
    //   1982	1991	323	d/l/b/a/b/h/k
    //   2000	2015	323	d/l/b/a/b/h/k
    //   2029	2039	323	d/l/b/a/b/h/k
    //   2048	2057	323	d/l/b/a/b/h/k
    //   2066	2077	323	d/l/b/a/b/h/k
    //   2103	2114	323	d/l/b/a/b/h/k
    //   2133	2150	323	d/l/b/a/b/h/k
    //   2165	2175	323	d/l/b/a/b/h/k
    //   2201	2208	323	d/l/b/a/b/h/k
    //   2217	2228	323	d/l/b/a/b/h/k
    //   2247	2254	323	d/l/b/a/b/h/k
    //   2266	2283	323	d/l/b/a/b/h/k
    //   2298	2304	323	d/l/b/a/b/h/k
    //   2319	2331	323	d/l/b/a/b/h/k
    //   2340	2349	323	d/l/b/a/b/h/k
    //   2358	2373	323	d/l/b/a/b/h/k
    //   2387	2397	323	d/l/b/a/b/h/k
    //   2406	2415	323	d/l/b/a/b/h/k
    //   2424	2435	323	d/l/b/a/b/h/k
    //   70	76	348	finally
    //   265	278	348	finally
    //   293	303	348	finally
    //   312	320	348	finally
    //   328	333	348	finally
    //   337	342	348	finally
    //   346	348	348	finally
    //   643	654	348	finally
    //   672	689	348	finally
    //   700	712	348	finally
    //   716	721	348	finally
    //   725	730	348	finally
    //   734	736	348	finally
    //   745	755	348	finally
    //   779	786	348	finally
    //   795	806	348	finally
    //   824	831	348	finally
    //   843	860	348	finally
    //   875	881	348	finally
    //   896	906	348	finally
    //   915	923	348	finally
    //   935	945	348	finally
    //   954	962	348	finally
    //   986	997	348	finally
    //   1015	1033	348	finally
    //   1060	1071	348	finally
    //   1089	1107	348	finally
    //   1134	1145	348	finally
    //   1163	1180	348	finally
    //   1195	1205	348	finally
    //   1229	1236	348	finally
    //   1245	1256	348	finally
    //   1274	1281	348	finally
    //   1293	1310	348	finally
    //   1325	1331	348	finally
    //   1360	1371	348	finally
    //   1390	1408	348	finally
    //   1437	1448	348	finally
    //   1467	1485	348	finally
    //   1514	1525	348	finally
    //   1544	1562	348	finally
    //   1591	1602	348	finally
    //   1621	1639	348	finally
    //   1668	1679	348	finally
    //   1698	1716	348	finally
    //   1745	1756	348	finally
    //   1775	1792	348	finally
    //   1807	1817	348	finally
    //   1843	1850	348	finally
    //   1859	1870	348	finally
    //   1889	1896	348	finally
    //   1908	1925	348	finally
    //   1940	1946	348	finally
    //   1961	1973	348	finally
    //   1982	1991	348	finally
    //   2000	2015	348	finally
    //   2029	2039	348	finally
    //   2048	2057	348	finally
    //   2066	2077	348	finally
    //   2103	2114	348	finally
    //   2133	2150	348	finally
    //   2165	2175	348	finally
    //   2201	2208	348	finally
    //   2217	2228	348	finally
    //   2247	2254	348	finally
    //   2266	2283	348	finally
    //   2298	2304	348	finally
    //   2319	2331	348	finally
    //   2340	2349	348	finally
    //   2358	2373	348	finally
    //   2387	2397	348	finally
    //   2406	2415	348	finally
    //   2424	2435	348	finally
    //   70	76	695	java/io/IOException
    //   265	278	695	java/io/IOException
    //   293	303	695	java/io/IOException
    //   312	320	695	java/io/IOException
    //   643	654	695	java/io/IOException
    //   672	689	695	java/io/IOException
    //   745	755	695	java/io/IOException
    //   779	786	695	java/io/IOException
    //   795	806	695	java/io/IOException
    //   824	831	695	java/io/IOException
    //   843	860	695	java/io/IOException
    //   875	881	695	java/io/IOException
    //   896	906	695	java/io/IOException
    //   915	923	695	java/io/IOException
    //   935	945	695	java/io/IOException
    //   954	962	695	java/io/IOException
    //   986	997	695	java/io/IOException
    //   1015	1033	695	java/io/IOException
    //   1060	1071	695	java/io/IOException
    //   1089	1107	695	java/io/IOException
    //   1134	1145	695	java/io/IOException
    //   1163	1180	695	java/io/IOException
    //   1195	1205	695	java/io/IOException
    //   1229	1236	695	java/io/IOException
    //   1245	1256	695	java/io/IOException
    //   1274	1281	695	java/io/IOException
    //   1293	1310	695	java/io/IOException
    //   1325	1331	695	java/io/IOException
    //   1360	1371	695	java/io/IOException
    //   1390	1408	695	java/io/IOException
    //   1437	1448	695	java/io/IOException
    //   1467	1485	695	java/io/IOException
    //   1514	1525	695	java/io/IOException
    //   1544	1562	695	java/io/IOException
    //   1591	1602	695	java/io/IOException
    //   1621	1639	695	java/io/IOException
    //   1668	1679	695	java/io/IOException
    //   1698	1716	695	java/io/IOException
    //   1745	1756	695	java/io/IOException
    //   1775	1792	695	java/io/IOException
    //   1807	1817	695	java/io/IOException
    //   1843	1850	695	java/io/IOException
    //   1859	1870	695	java/io/IOException
    //   1889	1896	695	java/io/IOException
    //   1908	1925	695	java/io/IOException
    //   1940	1946	695	java/io/IOException
    //   1961	1973	695	java/io/IOException
    //   1982	1991	695	java/io/IOException
    //   2000	2015	695	java/io/IOException
    //   2029	2039	695	java/io/IOException
    //   2048	2057	695	java/io/IOException
    //   2066	2077	695	java/io/IOException
    //   2103	2114	695	java/io/IOException
    //   2133	2150	695	java/io/IOException
    //   2165	2175	695	java/io/IOException
    //   2201	2208	695	java/io/IOException
    //   2217	2228	695	java/io/IOException
    //   2247	2254	695	java/io/IOException
    //   2266	2283	695	java/io/IOException
    //   2298	2304	695	java/io/IOException
    //   2319	2331	695	java/io/IOException
    //   2340	2349	695	java/io/IOException
    //   2358	2373	695	java/io/IOException
    //   2387	2397	695	java/io/IOException
    //   2406	2415	695	java/io/IOException
    //   2424	2435	695	java/io/IOException
    //   2672	2677	2699	java/io/IOException
    //   2672	2677	2712	finally
    //   594	599	2729	java/io/IOException
    //   594	599	2742	finally
  }
  
  private a$b(i.b<b, ?> paramb)
  {
    super(paramb);
    this.NHe = paramb.NHe;
  }
  
  public static b a(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(58431);
    paramInputStream = (b)NHf.j(paramInputStream, paramg);
    AppMethodBeat.o(58431);
    return paramInputStream;
  }
  
  private void gqS()
  {
    AppMethodBeat.i(58427);
    this.NHz = 6;
    this.NHQ = 0;
    this.NHR = 0;
    this.NHS = Collections.emptyList();
    this.NHT = Collections.emptyList();
    this.NHU = Collections.emptyList();
    this.NHW = Collections.emptyList();
    this.NHY = Collections.emptyList();
    this.NHZ = Collections.emptyList();
    this.NIa = Collections.emptyList();
    this.NIb = Collections.emptyList();
    this.NIc = Collections.emptyList();
    this.NId = Collections.emptyList();
    this.NIf = a.s.guk();
    this.NIg = Collections.emptyList();
    this.NIh = a.v.guG();
    AppMethodBeat.o(58427);
  }
  
  public static b grz()
  {
    return NHP;
  }
  
  public final void a(f paramf)
  {
    int j = 0;
    AppMethodBeat.i(58429);
    zp();
    i.c.a locala = gwq();
    if ((this.NHg & 0x1) == 1) {
      paramf.bx(1, this.NHz);
    }
    if (this.NHU.size() > 0)
    {
      paramf.fO(18);
      paramf.fO(this.NHV);
    }
    int i = 0;
    while (i < this.NHU.size())
    {
      paramf.alM(((Integer)this.NHU.get(i)).intValue());
      i += 1;
    }
    if ((this.NHg & 0x2) == 2) {
      paramf.bx(3, this.NHQ);
    }
    if ((this.NHg & 0x4) == 4) {
      paramf.bx(4, this.NHR);
    }
    i = 0;
    while (i < this.NHS.size())
    {
      paramf.a(5, (q)this.NHS.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.NHT.size())
    {
      paramf.a(6, (q)this.NHT.get(i));
      i += 1;
    }
    if (this.NHW.size() > 0)
    {
      paramf.fO(58);
      paramf.fO(this.NHX);
    }
    i = 0;
    while (i < this.NHW.size())
    {
      paramf.alM(((Integer)this.NHW.get(i)).intValue());
      i += 1;
    }
    i = 0;
    while (i < this.NHY.size())
    {
      paramf.a(8, (q)this.NHY.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.NHZ.size())
    {
      paramf.a(9, (q)this.NHZ.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.NIa.size())
    {
      paramf.a(10, (q)this.NIa.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.NIb.size())
    {
      paramf.a(11, (q)this.NIb.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.NIc.size())
    {
      paramf.a(13, (q)this.NIc.get(i));
      i += 1;
    }
    if (this.NId.size() > 0)
    {
      paramf.fO(130);
      paramf.fO(this.NIe);
    }
    i = 0;
    while (i < this.NId.size())
    {
      paramf.alM(((Integer)this.NId.get(i)).intValue());
      i += 1;
    }
    i = j;
    if ((this.NHg & 0x8) == 8)
    {
      paramf.a(30, this.NIf);
      i = j;
    }
    while (i < this.NIg.size())
    {
      paramf.bx(31, ((Integer)this.NIg.get(i)).intValue());
      i += 1;
    }
    if ((this.NHg & 0x10) == 16) {
      paramf.a(32, this.NIh);
    }
    locala.b(19000, paramf);
    paramf.e(this.NHe);
    AppMethodBeat.o(58429);
  }
  
  public final s<b> gqQ()
  {
    return NHf;
  }
  
  public final boolean grA()
  {
    return (this.NHg & 0x2) == 2;
  }
  
  public final boolean grB()
  {
    return (this.NHg & 0x4) == 4;
  }
  
  public final boolean grC()
  {
    return (this.NHg & 0x8) == 8;
  }
  
  public final boolean grD()
  {
    return (this.NHg & 0x10) == 16;
  }
  
  public final boolean grq()
  {
    return (this.NHg & 0x1) == 1;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58428);
    int i = this.NHj;
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
    if (!grA())
    {
      this.NHj = 0;
      AppMethodBeat.o(58428);
      return false;
    }
    i = 0;
    while (i < this.NHS.size())
    {
      if (!((a.r)this.NHS.get(i)).isInitialized())
      {
        this.NHj = 0;
        AppMethodBeat.o(58428);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.NHT.size())
    {
      if (!((a.p)this.NHT.get(i)).isInitialized())
      {
        this.NHj = 0;
        AppMethodBeat.o(58428);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.NHY.size())
    {
      if (!((a.c)this.NHY.get(i)).isInitialized())
      {
        this.NHj = 0;
        AppMethodBeat.o(58428);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.NHZ.size())
    {
      if (!((a.h)this.NHZ.get(i)).isInitialized())
      {
        this.NHj = 0;
        AppMethodBeat.o(58428);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.NIa.size())
    {
      if (!((a.m)this.NIa.get(i)).isInitialized())
      {
        this.NHj = 0;
        AppMethodBeat.o(58428);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.NIb.size())
    {
      if (!((a.q)this.NIb.get(i)).isInitialized())
      {
        this.NHj = 0;
        AppMethodBeat.o(58428);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.NIc.size())
    {
      if (!((a.f)this.NIc.get(i)).isInitialized())
      {
        this.NHj = 0;
        AppMethodBeat.o(58428);
        return false;
      }
      i += 1;
    }
    if ((grC()) && (!this.NIf.isInitialized()))
    {
      this.NHj = 0;
      AppMethodBeat.o(58428);
      return false;
    }
    if (!this.NOg.isInitialized())
    {
      this.NHj = 0;
      AppMethodBeat.o(58428);
      return false;
    }
    this.NHj = 1;
    AppMethodBeat.o(58428);
    return true;
  }
  
  public final int zp()
  {
    AppMethodBeat.i(58430);
    int i = this.NHk;
    if (i != -1)
    {
      AppMethodBeat.o(58430);
      return i;
    }
    if ((this.NHg & 0x1) == 1) {}
    for (i = f.bz(1, this.NHz) + 0;; i = 0)
    {
      int k = 0;
      int j = 0;
      while (k < this.NHU.size())
      {
        j += f.fL(((Integer)this.NHU.get(k)).intValue());
        k += 1;
      }
      k = i + j;
      i = k;
      if (!this.NHU.isEmpty()) {
        i = k + 1 + f.fL(j);
      }
      this.NHV = j;
      j = i;
      if ((this.NHg & 0x2) == 2) {
        j = i + f.bz(3, this.NHQ);
      }
      i = j;
      if ((this.NHg & 0x4) == 4) {
        i = j + f.bz(4, this.NHR);
      }
      j = 0;
      while (j < this.NHS.size())
      {
        i += f.c(5, (q)this.NHS.get(j));
        j += 1;
      }
      j = 0;
      while (j < this.NHT.size())
      {
        i += f.c(6, (q)this.NHT.get(j));
        j += 1;
      }
      k = 0;
      j = 0;
      while (k < this.NHW.size())
      {
        j += f.fL(((Integer)this.NHW.get(k)).intValue());
        k += 1;
      }
      k = i + j;
      i = k;
      if (!this.NHW.isEmpty()) {
        i = k + 1 + f.fL(j);
      }
      this.NHX = j;
      j = 0;
      while (j < this.NHY.size())
      {
        i += f.c(8, (q)this.NHY.get(j));
        j += 1;
      }
      j = 0;
      while (j < this.NHZ.size())
      {
        i += f.c(9, (q)this.NHZ.get(j));
        j += 1;
      }
      j = 0;
      while (j < this.NIa.size())
      {
        i += f.c(10, (q)this.NIa.get(j));
        j += 1;
      }
      j = 0;
      while (j < this.NIb.size())
      {
        i += f.c(11, (q)this.NIb.get(j));
        j += 1;
      }
      j = 0;
      while (j < this.NIc.size())
      {
        i += f.c(13, (q)this.NIc.get(j));
        j += 1;
      }
      k = 0;
      j = 0;
      while (k < this.NId.size())
      {
        j += f.fL(((Integer)this.NId.get(k)).intValue());
        k += 1;
      }
      k = i + j;
      i = k;
      if (!this.NId.isEmpty()) {
        i = k + 2 + f.fL(j);
      }
      this.NIe = j;
      if ((this.NHg & 0x8) == 8) {
        i += f.c(30, this.NIf);
      }
      for (;;)
      {
        k = 0;
        int m;
        for (j = 0; k < this.NIg.size(); j = m + j)
        {
          m = f.fL(((Integer)this.NIg.get(k)).intValue());
          k += 1;
        }
        j = i + j + this.NIg.size() * 2;
        i = j;
        if ((this.NHg & 0x10) == 16) {
          i = j + f.c(32, this.NIh);
        }
        i = i + this.NOg.zp() + this.NHe.size();
        this.NHk = i;
        AppMethodBeat.o(58430);
        return i;
      }
    }
  }
  
  public static final class a
    extends i.b<a.b, a>
    implements e
  {
    private int NHQ;
    private int NHR;
    private List<a.r> NHS;
    private List<a.p> NHT;
    private List<Integer> NHU;
    private List<Integer> NHW;
    private List<a.c> NHY;
    private List<a.h> NHZ;
    private int NHg;
    private int NHz;
    private List<a.m> NIa;
    private List<a.q> NIb;
    private List<a.f> NIc;
    private List<Integer> NId;
    private a.s NIf;
    private List<Integer> NIg;
    private a.v NIh;
    
    private a()
    {
      AppMethodBeat.i(58392);
      this.NHz = 6;
      this.NHS = Collections.emptyList();
      this.NHT = Collections.emptyList();
      this.NHU = Collections.emptyList();
      this.NHW = Collections.emptyList();
      this.NHY = Collections.emptyList();
      this.NHZ = Collections.emptyList();
      this.NIa = Collections.emptyList();
      this.NIb = Collections.emptyList();
      this.NIc = Collections.emptyList();
      this.NId = Collections.emptyList();
      this.NIf = a.s.guk();
      this.NIg = Collections.emptyList();
      this.NIh = a.v.guG();
      AppMethodBeat.o(58392);
    }
    
    private a a(a.s params)
    {
      AppMethodBeat.i(58408);
      if (((this.NHg & 0x2000) == 8192) && (this.NIf != a.s.guk())) {}
      for (this.NIf = a.s.d(this.NIf).g(params).gun();; this.NIf = params)
      {
        this.NHg |= 0x2000;
        AppMethodBeat.o(58408);
        return this;
      }
    }
    
    private a a(a.v paramv)
    {
      AppMethodBeat.i(58410);
      if (((this.NHg & 0x8000) == 32768) && (this.NIh != a.v.guG())) {}
      for (this.NIh = a.v.c(this.NIh).f(paramv).guI();; this.NIh = paramv)
      {
        this.NHg |= 0x8000;
        AppMethodBeat.o(58410);
        return this;
      }
    }
    
    private a akm(int paramInt)
    {
      this.NHg |= 0x1;
      this.NHz = paramInt;
      return this;
    }
    
    private a akn(int paramInt)
    {
      this.NHg |= 0x2;
      this.NHQ = paramInt;
      return this;
    }
    
    private a ako(int paramInt)
    {
      this.NHg |= 0x4;
      this.NHR = paramInt;
      return this;
    }
    
    /* Error */
    private a g(d.l.b.a.b.h.e parame, g paramg)
    {
      // Byte code:
      //   0: ldc 146
      //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 150	d/l/b/a/b/e/a$b:NHf	Ld/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 155 3 0
      //   17: checkcast 9	d/l/b/a/b/e/a$b
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 159	d/l/b/a/b/e/a$b$a:m	(Ld/l/b/a/b/e/a$b;)Ld/l/b/a/b/e/a$b$a;
      //   26: pop
      //   27: ldc 146
      //   29: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 163	d/l/b/a/b/h/k:NOw	Ld/l/b/a/b/h/q;
      //   39: checkcast 9	d/l/b/a/b/e/a$b
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
      //   57: invokevirtual 159	d/l/b/a/b/e/a$b$a:m	(Ld/l/b/a/b/e/a$b;)Ld/l/b/a/b/e/a$b$a;
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
      //   0	74	1	parame	d.l.b.a.b.h.e
      //   0	74	2	paramg	g
      //   6	64	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	d/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    private a grE()
    {
      AppMethodBeat.i(58393);
      a locala = new a().m(grF());
      AppMethodBeat.o(58393);
      return locala;
    }
    
    private a.b grF()
    {
      int j = 1;
      AppMethodBeat.i(58394);
      a.b localb = new a.b(this, (byte)0);
      int k = this.NHg;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.b.a(localb, this.NHz);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.b.b(localb, this.NHQ);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.b.c(localb, this.NHR);
        if ((this.NHg & 0x8) == 8)
        {
          this.NHS = Collections.unmodifiableList(this.NHS);
          this.NHg &= 0xFFFFFFF7;
        }
        a.b.a(localb, this.NHS);
        if ((this.NHg & 0x10) == 16)
        {
          this.NHT = Collections.unmodifiableList(this.NHT);
          this.NHg &= 0xFFFFFFEF;
        }
        a.b.b(localb, this.NHT);
        if ((this.NHg & 0x20) == 32)
        {
          this.NHU = Collections.unmodifiableList(this.NHU);
          this.NHg &= 0xFFFFFFDF;
        }
        a.b.c(localb, this.NHU);
        if ((this.NHg & 0x40) == 64)
        {
          this.NHW = Collections.unmodifiableList(this.NHW);
          this.NHg &= 0xFFFFFFBF;
        }
        a.b.d(localb, this.NHW);
        if ((this.NHg & 0x80) == 128)
        {
          this.NHY = Collections.unmodifiableList(this.NHY);
          this.NHg &= 0xFFFFFF7F;
        }
        a.b.e(localb, this.NHY);
        if ((this.NHg & 0x100) == 256)
        {
          this.NHZ = Collections.unmodifiableList(this.NHZ);
          this.NHg &= 0xFFFFFEFF;
        }
        a.b.f(localb, this.NHZ);
        if ((this.NHg & 0x200) == 512)
        {
          this.NIa = Collections.unmodifiableList(this.NIa);
          this.NHg &= 0xFFFFFDFF;
        }
        a.b.g(localb, this.NIa);
        if ((this.NHg & 0x400) == 1024)
        {
          this.NIb = Collections.unmodifiableList(this.NIb);
          this.NHg &= 0xFFFFFBFF;
        }
        a.b.h(localb, this.NIb);
        if ((this.NHg & 0x800) == 2048)
        {
          this.NIc = Collections.unmodifiableList(this.NIc);
          this.NHg &= 0xFFFFF7FF;
        }
        a.b.i(localb, this.NIc);
        if ((this.NHg & 0x1000) == 4096)
        {
          this.NId = Collections.unmodifiableList(this.NId);
          this.NHg &= 0xFFFFEFFF;
        }
        a.b.j(localb, this.NId);
        i = j;
        if ((k & 0x2000) == 8192) {
          i = j | 0x8;
        }
        a.b.a(localb, this.NIf);
        if ((this.NHg & 0x4000) == 16384)
        {
          this.NIg = Collections.unmodifiableList(this.NIg);
          this.NHg &= 0xFFFFBFFF;
        }
        a.b.k(localb, this.NIg);
        j = i;
        if ((k & 0x8000) == 32768) {
          j = i | 0x10;
        }
        a.b.a(localb, this.NIh);
        a.b.d(localb, j);
        AppMethodBeat.o(58394);
        return localb;
        j = 0;
      }
    }
    
    private void grG()
    {
      AppMethodBeat.i(58398);
      if ((this.NHg & 0x8) != 8)
      {
        this.NHS = new ArrayList(this.NHS);
        this.NHg |= 0x8;
      }
      AppMethodBeat.o(58398);
    }
    
    private void grH()
    {
      AppMethodBeat.i(58399);
      if ((this.NHg & 0x10) != 16)
      {
        this.NHT = new ArrayList(this.NHT);
        this.NHg |= 0x10;
      }
      AppMethodBeat.o(58399);
    }
    
    private void grI()
    {
      AppMethodBeat.i(58400);
      if ((this.NHg & 0x20) != 32)
      {
        this.NHU = new ArrayList(this.NHU);
        this.NHg |= 0x20;
      }
      AppMethodBeat.o(58400);
    }
    
    private void grJ()
    {
      AppMethodBeat.i(58401);
      if ((this.NHg & 0x40) != 64)
      {
        this.NHW = new ArrayList(this.NHW);
        this.NHg |= 0x40;
      }
      AppMethodBeat.o(58401);
    }
    
    private void grK()
    {
      AppMethodBeat.i(58402);
      if ((this.NHg & 0x80) != 128)
      {
        this.NHY = new ArrayList(this.NHY);
        this.NHg |= 0x80;
      }
      AppMethodBeat.o(58402);
    }
    
    private void grL()
    {
      AppMethodBeat.i(58403);
      if ((this.NHg & 0x100) != 256)
      {
        this.NHZ = new ArrayList(this.NHZ);
        this.NHg |= 0x100;
      }
      AppMethodBeat.o(58403);
    }
    
    private void grM()
    {
      AppMethodBeat.i(58404);
      if ((this.NHg & 0x200) != 512)
      {
        this.NIa = new ArrayList(this.NIa);
        this.NHg |= 0x200;
      }
      AppMethodBeat.o(58404);
    }
    
    private void grN()
    {
      AppMethodBeat.i(58405);
      if ((this.NHg & 0x400) != 1024)
      {
        this.NIb = new ArrayList(this.NIb);
        this.NHg |= 0x400;
      }
      AppMethodBeat.o(58405);
    }
    
    private void grO()
    {
      AppMethodBeat.i(58406);
      if ((this.NHg & 0x800) != 2048)
      {
        this.NIc = new ArrayList(this.NIc);
        this.NHg |= 0x800;
      }
      AppMethodBeat.o(58406);
    }
    
    private void grP()
    {
      AppMethodBeat.i(58407);
      if ((this.NHg & 0x1000) != 4096)
      {
        this.NId = new ArrayList(this.NId);
        this.NHg |= 0x1000;
      }
      AppMethodBeat.o(58407);
    }
    
    private void grQ()
    {
      AppMethodBeat.i(58409);
      if ((this.NHg & 0x4000) != 16384)
      {
        this.NIg = new ArrayList(this.NIg);
        this.NHg |= 0x4000;
      }
      AppMethodBeat.o(58409);
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58396);
      if ((this.NHg & 0x2) == 2) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58396);
        return false;
      }
      i = 0;
      while (i < this.NHS.size())
      {
        if (!((a.r)this.NHS.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.NHT.size())
      {
        if (!((a.p)this.NHT.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.NHY.size())
      {
        if (!((a.c)this.NHY.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.NHZ.size())
      {
        if (!((a.h)this.NHZ.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.NIa.size())
      {
        if (!((a.m)this.NIa.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.NIb.size())
      {
        if (!((a.q)this.NIb.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.NIc.size())
      {
        if (!((a.f)this.NIc.get(i)).isInitialized())
        {
          AppMethodBeat.o(58396);
          return false;
        }
        i += 1;
      }
      if ((this.NHg & 0x2000) == 8192) {}
      for (i = 1; (i != 0) && (!this.NIf.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58396);
        return false;
      }
      if (!this.NOg.isInitialized())
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
      if (paramb == a.b.grz())
      {
        AppMethodBeat.o(58395);
        return this;
      }
      if (paramb.grq()) {
        akm(paramb.NHz);
      }
      if (paramb.grA()) {
        akn(paramb.NHQ);
      }
      if (paramb.grB()) {
        ako(paramb.NHR);
      }
      if (!a.b.a(paramb).isEmpty())
      {
        if (this.NHS.isEmpty())
        {
          this.NHS = a.b.a(paramb);
          this.NHg &= 0xFFFFFFF7;
        }
      }
      else
      {
        if (!a.b.b(paramb).isEmpty())
        {
          if (!this.NHT.isEmpty()) {
            break label630;
          }
          this.NHT = a.b.b(paramb);
          this.NHg &= 0xFFFFFFEF;
        }
        label155:
        if (!a.b.c(paramb).isEmpty())
        {
          if (!this.NHU.isEmpty()) {
            break label651;
          }
          this.NHU = a.b.c(paramb);
          this.NHg &= 0xFFFFFFDF;
        }
        label198:
        if (!a.b.d(paramb).isEmpty())
        {
          if (!this.NHW.isEmpty()) {
            break label672;
          }
          this.NHW = a.b.d(paramb);
          this.NHg &= 0xFFFFFFBF;
        }
        label241:
        if (!a.b.e(paramb).isEmpty())
        {
          if (!this.NHY.isEmpty()) {
            break label693;
          }
          this.NHY = a.b.e(paramb);
          this.NHg &= 0xFFFFFF7F;
        }
        label285:
        if (!a.b.f(paramb).isEmpty())
        {
          if (!this.NHZ.isEmpty()) {
            break label714;
          }
          this.NHZ = a.b.f(paramb);
          this.NHg &= 0xFFFFFEFF;
        }
        label329:
        if (!a.b.g(paramb).isEmpty())
        {
          if (!this.NIa.isEmpty()) {
            break label735;
          }
          this.NIa = a.b.g(paramb);
          this.NHg &= 0xFFFFFDFF;
        }
        label373:
        if (!a.b.h(paramb).isEmpty())
        {
          if (!this.NIb.isEmpty()) {
            break label756;
          }
          this.NIb = a.b.h(paramb);
          this.NHg &= 0xFFFFFBFF;
        }
        label417:
        if (!a.b.i(paramb).isEmpty())
        {
          if (!this.NIc.isEmpty()) {
            break label777;
          }
          this.NIc = a.b.i(paramb);
          this.NHg &= 0xFFFFF7FF;
        }
        label461:
        if (!a.b.j(paramb).isEmpty())
        {
          if (!this.NId.isEmpty()) {
            break label798;
          }
          this.NId = a.b.j(paramb);
          this.NHg &= 0xFFFFEFFF;
        }
        label505:
        if (paramb.grC()) {
          a(paramb.NIf);
        }
        if (!a.b.k(paramb).isEmpty())
        {
          if (!this.NIg.isEmpty()) {
            break label819;
          }
          this.NIg = a.b.k(paramb);
          this.NHg &= 0xFFFFBFFF;
        }
      }
      for (;;)
      {
        if (paramb.grD()) {
          a(paramb.NIh);
        }
        a(paramb);
        this.NHe = this.NHe.a(a.b.l(paramb));
        AppMethodBeat.o(58395);
        return this;
        grG();
        this.NHS.addAll(a.b.a(paramb));
        break;
        label630:
        grH();
        this.NHT.addAll(a.b.b(paramb));
        break label155;
        label651:
        grI();
        this.NHU.addAll(a.b.c(paramb));
        break label198;
        label672:
        grJ();
        this.NHW.addAll(a.b.d(paramb));
        break label241;
        label693:
        grK();
        this.NHY.addAll(a.b.e(paramb));
        break label285;
        label714:
        grL();
        this.NHZ.addAll(a.b.f(paramb));
        break label329;
        label735:
        grM();
        this.NIa.addAll(a.b.g(paramb));
        break label373;
        label756:
        grN();
        this.NIb.addAll(a.b.h(paramb));
        break label417;
        label777:
        grO();
        this.NIc.addAll(a.b.i(paramb));
        break label461;
        label798:
        grP();
        this.NId.addAll(a.b.j(paramb));
        break label505;
        label819:
        grQ();
        this.NIg.addAll(a.b.k(paramb));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     d.l.b.a.b.e.a.b
 * JD-Core Version:    0.7.0.1
 */