package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.b;
import d.l.b.a.b.h.d;
import d.l.b.a.b.h.f;
import d.l.b.a.b.h.h;
import d.l.b.a.b.h.i.a;
import d.l.b.a.b.h.i.b;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.h.i.c.a;
import d.l.b.a.b.h.q;
import d.l.b.a.b.h.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$m
  extends i.c<m>
  implements n
{
  public static s<m> NHf;
  private static final m NJr;
  public List<a.r> NHS;
  private final d NHe;
  private int NHg;
  private byte NHj = -1;
  private int NHk = -1;
  public int NHz;
  public int NII;
  public int NIV;
  public a.p NIW;
  public int NIX;
  public a.p NIY;
  public int NIZ;
  public List<Integer> NIg;
  public a.t NJs;
  public int NJt;
  public int NJu;
  
  static
  {
    AppMethodBeat.i(58722);
    NHf = new b() {};
    m localm = new m();
    NJr = localm;
    localm.gqS();
    AppMethodBeat.o(58722);
  }
  
  private a$m()
  {
    this.NHe = d.NNO;
  }
  
  /* Error */
  private a$m(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 69	d/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 86
    //   6: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 71	d/l/b/a/b/e/a$m:NHj	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 73	d/l/b/a/b/e/a$m:NHk	I
    //   19: aload_0
    //   20: invokespecial 64	d/l/b/a/b/e/a$m:gqS	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 90	d/l/b/a/b/h/d:gvT	()Ld/l/b/a/b/h/d$b;
    //   28: astore 10
    //   30: aload 10
    //   32: iconst_1
    //   33: invokestatic 96	d/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Ld/l/b/a/b/h/f;
    //   36: astore 11
    //   38: iconst_0
    //   39: istore 8
    //   41: iload 8
    //   43: ifne +1231 -> 1274
    //   46: iload_3
    //   47: istore 5
    //   49: iload_3
    //   50: istore 6
    //   52: iload_3
    //   53: istore 7
    //   55: aload_1
    //   56: invokevirtual 102	d/l/b/a/b/h/e:zb	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+1375->1438, 0:+1378->1441, 8:+149->212, 16:+285->348, 26:+365->428, 34:+493->556, 42:+567->630, 50:+695->758, 56:+826->889, 64:+867->930, 72:+908->971, 80:+948->1011, 88:+988->1051, 248:+1027->1090, 250:+1103->1166
    //   185: istore 5
    //   187: iload_3
    //   188: istore 6
    //   190: iload_3
    //   191: istore 7
    //   193: aload_0
    //   194: aload_1
    //   195: aload 11
    //   197: aload_2
    //   198: iload 4
    //   200: invokevirtual 105	d/l/b/a/b/e/a$m:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/f;Ld/l/b/a/b/h/g;I)Z
    //   203: ifne +1232 -> 1435
    //   206: iconst_1
    //   207: istore 8
    //   209: goto -168 -> 41
    //   212: iload_3
    //   213: istore 5
    //   215: iload_3
    //   216: istore 6
    //   218: iload_3
    //   219: istore 7
    //   221: aload_0
    //   222: aload_0
    //   223: getfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   226: iconst_2
    //   227: ior
    //   228: putfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   231: iload_3
    //   232: istore 5
    //   234: iload_3
    //   235: istore 6
    //   237: iload_3
    //   238: istore 7
    //   240: aload_0
    //   241: aload_1
    //   242: invokevirtual 110	d/l/b/a/b/h/e:zc	()I
    //   245: putfield 112	d/l/b/a/b/e/a$m:NIV	I
    //   248: goto -207 -> 41
    //   251: astore_1
    //   252: iload 5
    //   254: istore 4
    //   256: iload 4
    //   258: istore_3
    //   259: aload_1
    //   260: aload_0
    //   261: putfield 116	d/l/b/a/b/h/k:NOw	Ld/l/b/a/b/h/q;
    //   264: iload 4
    //   266: istore_3
    //   267: ldc 86
    //   269: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: iload 4
    //   274: istore_3
    //   275: aload_1
    //   276: athrow
    //   277: astore_1
    //   278: iload_3
    //   279: bipush 32
    //   281: iand
    //   282: bipush 32
    //   284: if_icmpne +14 -> 298
    //   287: aload_0
    //   288: aload_0
    //   289: getfield 118	d/l/b/a/b/e/a$m:NHS	Ljava/util/List;
    //   292: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   295: putfield 118	d/l/b/a/b/e/a$m:NHS	Ljava/util/List;
    //   298: iload_3
    //   299: sipush 2048
    //   302: iand
    //   303: sipush 2048
    //   306: if_icmpne +14 -> 320
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 126	d/l/b/a/b/e/a$m:NIg	Ljava/util/List;
    //   314: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   317: putfield 126	d/l/b/a/b/e/a$m:NIg	Ljava/util/List;
    //   320: aload 11
    //   322: invokevirtual 129	d/l/b/a/b/h/f:flush	()V
    //   325: aload_0
    //   326: aload 10
    //   328: invokevirtual 135	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   331: putfield 80	d/l/b/a/b/e/a$m:NHe	Ld/l/b/a/b/h/d;
    //   334: aload_0
    //   335: getfield 139	d/l/b/a/b/h/i$c:NOg	Ld/l/b/a/b/h/h;
    //   338: invokevirtual 144	d/l/b/a/b/h/h:gwj	()V
    //   341: ldc 86
    //   343: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   346: aload_1
    //   347: athrow
    //   348: iload_3
    //   349: istore 5
    //   351: iload_3
    //   352: istore 6
    //   354: iload_3
    //   355: istore 7
    //   357: aload_0
    //   358: aload_0
    //   359: getfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   362: iconst_4
    //   363: ior
    //   364: putfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   367: iload_3
    //   368: istore 5
    //   370: iload_3
    //   371: istore 6
    //   373: iload_3
    //   374: istore 7
    //   376: aload_0
    //   377: aload_1
    //   378: invokevirtual 110	d/l/b/a/b/h/e:zc	()I
    //   381: putfield 146	d/l/b/a/b/e/a$m:NII	I
    //   384: goto -343 -> 41
    //   387: astore_1
    //   388: iload 6
    //   390: istore 4
    //   392: iload 4
    //   394: istore_3
    //   395: new 83	d/l/b/a/b/h/k
    //   398: dup
    //   399: aload_1
    //   400: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   403: invokespecial 153	d/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   406: astore_1
    //   407: iload 4
    //   409: istore_3
    //   410: aload_1
    //   411: aload_0
    //   412: putfield 116	d/l/b/a/b/h/k:NOw	Ld/l/b/a/b/h/q;
    //   415: iload 4
    //   417: istore_3
    //   418: ldc 86
    //   420: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: iload 4
    //   425: istore_3
    //   426: aload_1
    //   427: athrow
    //   428: iload_3
    //   429: istore 5
    //   431: iload_3
    //   432: istore 6
    //   434: iload_3
    //   435: istore 7
    //   437: aload_0
    //   438: getfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   441: bipush 8
    //   443: iand
    //   444: bipush 8
    //   446: if_icmpne +983 -> 1429
    //   449: iload_3
    //   450: istore 5
    //   452: iload_3
    //   453: istore 6
    //   455: iload_3
    //   456: istore 7
    //   458: aload_0
    //   459: getfield 155	d/l/b/a/b/e/a$m:NIW	Ld/l/b/a/b/e/a$p;
    //   462: invokestatic 160	d/l/b/a/b/e/a$p:f	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   465: astore 9
    //   467: iload_3
    //   468: istore 5
    //   470: iload_3
    //   471: istore 6
    //   473: iload_3
    //   474: istore 7
    //   476: aload_0
    //   477: aload_1
    //   478: getstatic 161	d/l/b/a/b/e/a$p:NHf	Ld/l/b/a/b/h/s;
    //   481: aload_2
    //   482: invokevirtual 164	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   485: checkcast 157	d/l/b/a/b/e/a$p
    //   488: putfield 155	d/l/b/a/b/e/a$m:NIW	Ld/l/b/a/b/e/a$p;
    //   491: aload 9
    //   493: ifnull +40 -> 533
    //   496: iload_3
    //   497: istore 5
    //   499: iload_3
    //   500: istore 6
    //   502: iload_3
    //   503: istore 7
    //   505: aload 9
    //   507: aload_0
    //   508: getfield 155	d/l/b/a/b/e/a$m:NIW	Ld/l/b/a/b/e/a$p;
    //   511: invokevirtual 169	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   514: pop
    //   515: iload_3
    //   516: istore 5
    //   518: iload_3
    //   519: istore 6
    //   521: iload_3
    //   522: istore 7
    //   524: aload_0
    //   525: aload 9
    //   527: invokevirtual 173	d/l/b/a/b/e/a$p$b:gtR	()Ld/l/b/a/b/e/a$p;
    //   530: putfield 155	d/l/b/a/b/e/a$m:NIW	Ld/l/b/a/b/e/a$p;
    //   533: iload_3
    //   534: istore 5
    //   536: iload_3
    //   537: istore 6
    //   539: iload_3
    //   540: istore 7
    //   542: aload_0
    //   543: aload_0
    //   544: getfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   547: bipush 8
    //   549: ior
    //   550: putfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   553: goto -512 -> 41
    //   556: iload_3
    //   557: istore 4
    //   559: iload_3
    //   560: bipush 32
    //   562: iand
    //   563: bipush 32
    //   565: if_icmpeq +29 -> 594
    //   568: iload_3
    //   569: istore 5
    //   571: iload_3
    //   572: istore 6
    //   574: iload_3
    //   575: istore 7
    //   577: aload_0
    //   578: new 175	java/util/ArrayList
    //   581: dup
    //   582: invokespecial 176	java/util/ArrayList:<init>	()V
    //   585: putfield 118	d/l/b/a/b/e/a$m:NHS	Ljava/util/List;
    //   588: iload_3
    //   589: bipush 32
    //   591: ior
    //   592: istore 4
    //   594: iload 4
    //   596: istore 5
    //   598: iload 4
    //   600: istore 6
    //   602: iload 4
    //   604: istore 7
    //   606: aload_0
    //   607: getfield 118	d/l/b/a/b/e/a$m:NHS	Ljava/util/List;
    //   610: aload_1
    //   611: getstatic 179	d/l/b/a/b/e/a$r:NHf	Ld/l/b/a/b/h/s;
    //   614: aload_2
    //   615: invokevirtual 164	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   618: invokeinterface 185 2 0
    //   623: pop
    //   624: iload 4
    //   626: istore_3
    //   627: goto -586 -> 41
    //   630: iload_3
    //   631: istore 5
    //   633: iload_3
    //   634: istore 6
    //   636: iload_3
    //   637: istore 7
    //   639: aload_0
    //   640: getfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   643: bipush 32
    //   645: iand
    //   646: bipush 32
    //   648: if_icmpne +775 -> 1423
    //   651: iload_3
    //   652: istore 5
    //   654: iload_3
    //   655: istore 6
    //   657: iload_3
    //   658: istore 7
    //   660: aload_0
    //   661: getfield 187	d/l/b/a/b/e/a$m:NIY	Ld/l/b/a/b/e/a$p;
    //   664: invokestatic 160	d/l/b/a/b/e/a$p:f	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   667: astore 9
    //   669: iload_3
    //   670: istore 5
    //   672: iload_3
    //   673: istore 6
    //   675: iload_3
    //   676: istore 7
    //   678: aload_0
    //   679: aload_1
    //   680: getstatic 161	d/l/b/a/b/e/a$p:NHf	Ld/l/b/a/b/h/s;
    //   683: aload_2
    //   684: invokevirtual 164	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   687: checkcast 157	d/l/b/a/b/e/a$p
    //   690: putfield 187	d/l/b/a/b/e/a$m:NIY	Ld/l/b/a/b/e/a$p;
    //   693: aload 9
    //   695: ifnull +40 -> 735
    //   698: iload_3
    //   699: istore 5
    //   701: iload_3
    //   702: istore 6
    //   704: iload_3
    //   705: istore 7
    //   707: aload 9
    //   709: aload_0
    //   710: getfield 187	d/l/b/a/b/e/a$m:NIY	Ld/l/b/a/b/e/a$p;
    //   713: invokevirtual 169	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   716: pop
    //   717: iload_3
    //   718: istore 5
    //   720: iload_3
    //   721: istore 6
    //   723: iload_3
    //   724: istore 7
    //   726: aload_0
    //   727: aload 9
    //   729: invokevirtual 173	d/l/b/a/b/e/a$p$b:gtR	()Ld/l/b/a/b/e/a$p;
    //   732: putfield 187	d/l/b/a/b/e/a$m:NIY	Ld/l/b/a/b/e/a$p;
    //   735: iload_3
    //   736: istore 5
    //   738: iload_3
    //   739: istore 6
    //   741: iload_3
    //   742: istore 7
    //   744: aload_0
    //   745: aload_0
    //   746: getfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   749: bipush 32
    //   751: ior
    //   752: putfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   755: goto -714 -> 41
    //   758: iload_3
    //   759: istore 5
    //   761: iload_3
    //   762: istore 6
    //   764: iload_3
    //   765: istore 7
    //   767: aload_0
    //   768: getfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   771: sipush 128
    //   774: iand
    //   775: sipush 128
    //   778: if_icmpne +639 -> 1417
    //   781: iload_3
    //   782: istore 5
    //   784: iload_3
    //   785: istore 6
    //   787: iload_3
    //   788: istore 7
    //   790: aload_0
    //   791: getfield 189	d/l/b/a/b/e/a$m:NJs	Ld/l/b/a/b/e/a$t;
    //   794: invokestatic 195	d/l/b/a/b/e/a$t:b	(Ld/l/b/a/b/e/a$t;)Ld/l/b/a/b/e/a$t$a;
    //   797: astore 9
    //   799: iload_3
    //   800: istore 5
    //   802: iload_3
    //   803: istore 6
    //   805: iload_3
    //   806: istore 7
    //   808: aload_0
    //   809: aload_1
    //   810: getstatic 196	d/l/b/a/b/e/a$t:NHf	Ld/l/b/a/b/h/s;
    //   813: aload_2
    //   814: invokevirtual 164	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   817: checkcast 191	d/l/b/a/b/e/a$t
    //   820: putfield 189	d/l/b/a/b/e/a$m:NJs	Ld/l/b/a/b/e/a$t;
    //   823: aload 9
    //   825: ifnull +40 -> 865
    //   828: iload_3
    //   829: istore 5
    //   831: iload_3
    //   832: istore 6
    //   834: iload_3
    //   835: istore 7
    //   837: aload 9
    //   839: aload_0
    //   840: getfield 189	d/l/b/a/b/e/a$m:NJs	Ld/l/b/a/b/e/a$t;
    //   843: invokevirtual 201	d/l/b/a/b/e/a$t$a:d	(Ld/l/b/a/b/e/a$t;)Ld/l/b/a/b/e/a$t$a;
    //   846: pop
    //   847: iload_3
    //   848: istore 5
    //   850: iload_3
    //   851: istore 6
    //   853: iload_3
    //   854: istore 7
    //   856: aload_0
    //   857: aload 9
    //   859: invokevirtual 205	d/l/b/a/b/e/a$t$a:guu	()Ld/l/b/a/b/e/a$t;
    //   862: putfield 189	d/l/b/a/b/e/a$m:NJs	Ld/l/b/a/b/e/a$t;
    //   865: iload_3
    //   866: istore 5
    //   868: iload_3
    //   869: istore 6
    //   871: iload_3
    //   872: istore 7
    //   874: aload_0
    //   875: aload_0
    //   876: getfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   879: sipush 128
    //   882: ior
    //   883: putfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   886: goto -845 -> 41
    //   889: iload_3
    //   890: istore 5
    //   892: iload_3
    //   893: istore 6
    //   895: iload_3
    //   896: istore 7
    //   898: aload_0
    //   899: aload_0
    //   900: getfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   903: sipush 256
    //   906: ior
    //   907: putfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   910: iload_3
    //   911: istore 5
    //   913: iload_3
    //   914: istore 6
    //   916: iload_3
    //   917: istore 7
    //   919: aload_0
    //   920: aload_1
    //   921: invokevirtual 110	d/l/b/a/b/h/e:zc	()I
    //   924: putfield 207	d/l/b/a/b/e/a$m:NJt	I
    //   927: goto -886 -> 41
    //   930: iload_3
    //   931: istore 5
    //   933: iload_3
    //   934: istore 6
    //   936: iload_3
    //   937: istore 7
    //   939: aload_0
    //   940: aload_0
    //   941: getfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   944: sipush 512
    //   947: ior
    //   948: putfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   951: iload_3
    //   952: istore 5
    //   954: iload_3
    //   955: istore 6
    //   957: iload_3
    //   958: istore 7
    //   960: aload_0
    //   961: aload_1
    //   962: invokevirtual 110	d/l/b/a/b/h/e:zc	()I
    //   965: putfield 209	d/l/b/a/b/e/a$m:NJu	I
    //   968: goto -927 -> 41
    //   971: iload_3
    //   972: istore 5
    //   974: iload_3
    //   975: istore 6
    //   977: iload_3
    //   978: istore 7
    //   980: aload_0
    //   981: aload_0
    //   982: getfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   985: bipush 16
    //   987: ior
    //   988: putfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   991: iload_3
    //   992: istore 5
    //   994: iload_3
    //   995: istore 6
    //   997: iload_3
    //   998: istore 7
    //   1000: aload_0
    //   1001: aload_1
    //   1002: invokevirtual 110	d/l/b/a/b/h/e:zc	()I
    //   1005: putfield 211	d/l/b/a/b/e/a$m:NIX	I
    //   1008: goto -967 -> 41
    //   1011: iload_3
    //   1012: istore 5
    //   1014: iload_3
    //   1015: istore 6
    //   1017: iload_3
    //   1018: istore 7
    //   1020: aload_0
    //   1021: aload_0
    //   1022: getfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   1025: bipush 64
    //   1027: ior
    //   1028: putfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   1031: iload_3
    //   1032: istore 5
    //   1034: iload_3
    //   1035: istore 6
    //   1037: iload_3
    //   1038: istore 7
    //   1040: aload_0
    //   1041: aload_1
    //   1042: invokevirtual 110	d/l/b/a/b/h/e:zc	()I
    //   1045: putfield 213	d/l/b/a/b/e/a$m:NIZ	I
    //   1048: goto -1007 -> 41
    //   1051: iload_3
    //   1052: istore 5
    //   1054: iload_3
    //   1055: istore 6
    //   1057: iload_3
    //   1058: istore 7
    //   1060: aload_0
    //   1061: aload_0
    //   1062: getfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   1065: iconst_1
    //   1066: ior
    //   1067: putfield 107	d/l/b/a/b/e/a$m:NHg	I
    //   1070: iload_3
    //   1071: istore 5
    //   1073: iload_3
    //   1074: istore 6
    //   1076: iload_3
    //   1077: istore 7
    //   1079: aload_0
    //   1080: aload_1
    //   1081: invokevirtual 110	d/l/b/a/b/h/e:zc	()I
    //   1084: putfield 215	d/l/b/a/b/e/a$m:NHz	I
    //   1087: goto -1046 -> 41
    //   1090: iload_3
    //   1091: istore 4
    //   1093: iload_3
    //   1094: sipush 2048
    //   1097: iand
    //   1098: sipush 2048
    //   1101: if_icmpeq +30 -> 1131
    //   1104: iload_3
    //   1105: istore 5
    //   1107: iload_3
    //   1108: istore 6
    //   1110: iload_3
    //   1111: istore 7
    //   1113: aload_0
    //   1114: new 175	java/util/ArrayList
    //   1117: dup
    //   1118: invokespecial 176	java/util/ArrayList:<init>	()V
    //   1121: putfield 126	d/l/b/a/b/e/a$m:NIg	Ljava/util/List;
    //   1124: iload_3
    //   1125: sipush 2048
    //   1128: ior
    //   1129: istore 4
    //   1131: iload 4
    //   1133: istore 5
    //   1135: iload 4
    //   1137: istore 6
    //   1139: iload 4
    //   1141: istore 7
    //   1143: aload_0
    //   1144: getfield 126	d/l/b/a/b/e/a$m:NIg	Ljava/util/List;
    //   1147: aload_1
    //   1148: invokevirtual 110	d/l/b/a/b/h/e:zc	()I
    //   1151: invokestatic 221	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1154: invokeinterface 185 2 0
    //   1159: pop
    //   1160: iload 4
    //   1162: istore_3
    //   1163: goto -1122 -> 41
    //   1166: iload_3
    //   1167: istore 5
    //   1169: iload_3
    //   1170: istore 6
    //   1172: iload_3
    //   1173: istore 7
    //   1175: aload_1
    //   1176: aload_1
    //   1177: invokevirtual 110	d/l/b/a/b/h/e:zc	()I
    //   1180: invokevirtual 225	d/l/b/a/b/h/e:fG	(I)I
    //   1183: istore 4
    //   1185: iload_3
    //   1186: sipush 2048
    //   1189: iand
    //   1190: sipush 2048
    //   1193: if_icmpeq +221 -> 1414
    //   1196: iload_3
    //   1197: istore 5
    //   1199: iload_3
    //   1200: istore 6
    //   1202: iload_3
    //   1203: istore 7
    //   1205: aload_1
    //   1206: invokevirtual 228	d/l/b/a/b/h/e:zf	()I
    //   1209: ifle +205 -> 1414
    //   1212: iload_3
    //   1213: istore 5
    //   1215: iload_3
    //   1216: istore 6
    //   1218: iload_3
    //   1219: istore 7
    //   1221: aload_0
    //   1222: new 175	java/util/ArrayList
    //   1225: dup
    //   1226: invokespecial 176	java/util/ArrayList:<init>	()V
    //   1229: putfield 126	d/l/b/a/b/e/a$m:NIg	Ljava/util/List;
    //   1232: iload_3
    //   1233: sipush 2048
    //   1236: ior
    //   1237: istore_3
    //   1238: aload_1
    //   1239: invokevirtual 228	d/l/b/a/b/h/e:zf	()I
    //   1242: ifle +23 -> 1265
    //   1245: aload_0
    //   1246: getfield 126	d/l/b/a/b/e/a$m:NIg	Ljava/util/List;
    //   1249: aload_1
    //   1250: invokevirtual 110	d/l/b/a/b/h/e:zc	()I
    //   1253: invokestatic 221	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1256: invokeinterface 185 2 0
    //   1261: pop
    //   1262: goto -24 -> 1238
    //   1265: aload_1
    //   1266: iload 4
    //   1268: invokevirtual 231	d/l/b/a/b/h/e:fH	(I)V
    //   1271: goto -1230 -> 41
    //   1274: iload_3
    //   1275: bipush 32
    //   1277: iand
    //   1278: bipush 32
    //   1280: if_icmpne +14 -> 1294
    //   1283: aload_0
    //   1284: aload_0
    //   1285: getfield 118	d/l/b/a/b/e/a$m:NHS	Ljava/util/List;
    //   1288: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1291: putfield 118	d/l/b/a/b/e/a$m:NHS	Ljava/util/List;
    //   1294: iload_3
    //   1295: sipush 2048
    //   1298: iand
    //   1299: sipush 2048
    //   1302: if_icmpne +14 -> 1316
    //   1305: aload_0
    //   1306: aload_0
    //   1307: getfield 126	d/l/b/a/b/e/a$m:NIg	Ljava/util/List;
    //   1310: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1313: putfield 126	d/l/b/a/b/e/a$m:NIg	Ljava/util/List;
    //   1316: aload 11
    //   1318: invokevirtual 129	d/l/b/a/b/h/f:flush	()V
    //   1321: aload_0
    //   1322: aload 10
    //   1324: invokevirtual 135	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   1327: putfield 80	d/l/b/a/b/e/a$m:NHe	Ld/l/b/a/b/h/d;
    //   1330: aload_0
    //   1331: getfield 139	d/l/b/a/b/h/i$c:NOg	Ld/l/b/a/b/h/h;
    //   1334: invokevirtual 144	d/l/b/a/b/h/h:gwj	()V
    //   1337: ldc 86
    //   1339: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1342: return
    //   1343: astore_1
    //   1344: aload_0
    //   1345: aload 10
    //   1347: invokevirtual 135	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   1350: putfield 80	d/l/b/a/b/e/a$m:NHe	Ld/l/b/a/b/h/d;
    //   1353: goto -23 -> 1330
    //   1356: astore_1
    //   1357: aload_0
    //   1358: aload 10
    //   1360: invokevirtual 135	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   1363: putfield 80	d/l/b/a/b/e/a$m:NHe	Ld/l/b/a/b/h/d;
    //   1366: ldc 86
    //   1368: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1371: aload_1
    //   1372: athrow
    //   1373: astore_2
    //   1374: aload_0
    //   1375: aload 10
    //   1377: invokevirtual 135	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   1380: putfield 80	d/l/b/a/b/e/a$m:NHe	Ld/l/b/a/b/h/d;
    //   1383: goto -1049 -> 334
    //   1386: astore_1
    //   1387: aload_0
    //   1388: aload 10
    //   1390: invokevirtual 135	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   1393: putfield 80	d/l/b/a/b/e/a$m:NHe	Ld/l/b/a/b/h/d;
    //   1396: ldc 86
    //   1398: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1401: aload_1
    //   1402: athrow
    //   1403: astore_1
    //   1404: goto -1126 -> 278
    //   1407: astore_1
    //   1408: iload_3
    //   1409: istore 4
    //   1411: goto -1019 -> 392
    //   1414: goto -176 -> 1238
    //   1417: aconst_null
    //   1418: astore 9
    //   1420: goto -621 -> 799
    //   1423: aconst_null
    //   1424: astore 9
    //   1426: goto -757 -> 669
    //   1429: aconst_null
    //   1430: astore 9
    //   1432: goto -965 -> 467
    //   1435: goto -164 -> 1271
    //   1438: goto -1254 -> 184
    //   1441: iconst_1
    //   1442: istore 8
    //   1444: goto -1403 -> 41
    //   1447: astore_1
    //   1448: iload 7
    //   1450: istore_3
    //   1451: goto -1173 -> 278
    //   1454: astore_1
    //   1455: iload_3
    //   1456: istore 4
    //   1458: goto -1202 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1461	0	this	m
    //   0	1461	1	parame	d.l.b.a.b.h.e
    //   0	1461	2	paramg	d.l.b.a.b.h.g
    //   24	1432	3	i	int
    //   59	1398	4	j	int
    //   47	1167	5	k	int
    //   50	1167	6	m	int
    //   53	1396	7	n	int
    //   39	1404	8	i1	int
    //   465	966	9	localObject	java.lang.Object
    //   28	1361	10	localb	d.l.b.a.b.h.d.b
    //   36	1281	11	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	251	d/l/b/a/b/h/k
    //   193	206	251	d/l/b/a/b/h/k
    //   221	231	251	d/l/b/a/b/h/k
    //   240	248	251	d/l/b/a/b/h/k
    //   357	367	251	d/l/b/a/b/h/k
    //   376	384	251	d/l/b/a/b/h/k
    //   437	449	251	d/l/b/a/b/h/k
    //   458	467	251	d/l/b/a/b/h/k
    //   476	491	251	d/l/b/a/b/h/k
    //   505	515	251	d/l/b/a/b/h/k
    //   524	533	251	d/l/b/a/b/h/k
    //   542	553	251	d/l/b/a/b/h/k
    //   577	588	251	d/l/b/a/b/h/k
    //   606	624	251	d/l/b/a/b/h/k
    //   639	651	251	d/l/b/a/b/h/k
    //   660	669	251	d/l/b/a/b/h/k
    //   678	693	251	d/l/b/a/b/h/k
    //   707	717	251	d/l/b/a/b/h/k
    //   726	735	251	d/l/b/a/b/h/k
    //   744	755	251	d/l/b/a/b/h/k
    //   767	781	251	d/l/b/a/b/h/k
    //   790	799	251	d/l/b/a/b/h/k
    //   808	823	251	d/l/b/a/b/h/k
    //   837	847	251	d/l/b/a/b/h/k
    //   856	865	251	d/l/b/a/b/h/k
    //   874	886	251	d/l/b/a/b/h/k
    //   898	910	251	d/l/b/a/b/h/k
    //   919	927	251	d/l/b/a/b/h/k
    //   939	951	251	d/l/b/a/b/h/k
    //   960	968	251	d/l/b/a/b/h/k
    //   980	991	251	d/l/b/a/b/h/k
    //   1000	1008	251	d/l/b/a/b/h/k
    //   1020	1031	251	d/l/b/a/b/h/k
    //   1040	1048	251	d/l/b/a/b/h/k
    //   1060	1070	251	d/l/b/a/b/h/k
    //   1079	1087	251	d/l/b/a/b/h/k
    //   1113	1124	251	d/l/b/a/b/h/k
    //   1143	1160	251	d/l/b/a/b/h/k
    //   1175	1185	251	d/l/b/a/b/h/k
    //   1205	1212	251	d/l/b/a/b/h/k
    //   1221	1232	251	d/l/b/a/b/h/k
    //   259	264	277	finally
    //   267	272	277	finally
    //   275	277	277	finally
    //   395	407	277	finally
    //   410	415	277	finally
    //   418	423	277	finally
    //   426	428	277	finally
    //   55	61	387	java/io/IOException
    //   193	206	387	java/io/IOException
    //   221	231	387	java/io/IOException
    //   240	248	387	java/io/IOException
    //   357	367	387	java/io/IOException
    //   376	384	387	java/io/IOException
    //   437	449	387	java/io/IOException
    //   458	467	387	java/io/IOException
    //   476	491	387	java/io/IOException
    //   505	515	387	java/io/IOException
    //   524	533	387	java/io/IOException
    //   542	553	387	java/io/IOException
    //   577	588	387	java/io/IOException
    //   606	624	387	java/io/IOException
    //   639	651	387	java/io/IOException
    //   660	669	387	java/io/IOException
    //   678	693	387	java/io/IOException
    //   707	717	387	java/io/IOException
    //   726	735	387	java/io/IOException
    //   744	755	387	java/io/IOException
    //   767	781	387	java/io/IOException
    //   790	799	387	java/io/IOException
    //   808	823	387	java/io/IOException
    //   837	847	387	java/io/IOException
    //   856	865	387	java/io/IOException
    //   874	886	387	java/io/IOException
    //   898	910	387	java/io/IOException
    //   919	927	387	java/io/IOException
    //   939	951	387	java/io/IOException
    //   960	968	387	java/io/IOException
    //   980	991	387	java/io/IOException
    //   1000	1008	387	java/io/IOException
    //   1020	1031	387	java/io/IOException
    //   1040	1048	387	java/io/IOException
    //   1060	1070	387	java/io/IOException
    //   1079	1087	387	java/io/IOException
    //   1113	1124	387	java/io/IOException
    //   1143	1160	387	java/io/IOException
    //   1175	1185	387	java/io/IOException
    //   1205	1212	387	java/io/IOException
    //   1221	1232	387	java/io/IOException
    //   1316	1321	1343	java/io/IOException
    //   1316	1321	1356	finally
    //   320	325	1373	java/io/IOException
    //   320	325	1386	finally
    //   1238	1262	1403	finally
    //   1265	1271	1403	finally
    //   1238	1262	1407	java/io/IOException
    //   1265	1271	1407	java/io/IOException
    //   55	61	1447	finally
    //   193	206	1447	finally
    //   221	231	1447	finally
    //   240	248	1447	finally
    //   357	367	1447	finally
    //   376	384	1447	finally
    //   437	449	1447	finally
    //   458	467	1447	finally
    //   476	491	1447	finally
    //   505	515	1447	finally
    //   524	533	1447	finally
    //   542	553	1447	finally
    //   577	588	1447	finally
    //   606	624	1447	finally
    //   639	651	1447	finally
    //   660	669	1447	finally
    //   678	693	1447	finally
    //   707	717	1447	finally
    //   726	735	1447	finally
    //   744	755	1447	finally
    //   767	781	1447	finally
    //   790	799	1447	finally
    //   808	823	1447	finally
    //   837	847	1447	finally
    //   856	865	1447	finally
    //   874	886	1447	finally
    //   898	910	1447	finally
    //   919	927	1447	finally
    //   939	951	1447	finally
    //   960	968	1447	finally
    //   980	991	1447	finally
    //   1000	1008	1447	finally
    //   1020	1031	1447	finally
    //   1040	1048	1447	finally
    //   1060	1070	1447	finally
    //   1079	1087	1447	finally
    //   1113	1124	1447	finally
    //   1143	1160	1447	finally
    //   1175	1185	1447	finally
    //   1205	1212	1447	finally
    //   1221	1232	1447	finally
    //   1238	1262	1454	d/l/b/a/b/h/k
    //   1265	1271	1454	d/l/b/a/b/h/k
  }
  
  private a$m(i.b<m, ?> paramb)
  {
    super(paramb);
    this.NHe = paramb.NHe;
  }
  
  private void gqS()
  {
    AppMethodBeat.i(58716);
    this.NHz = 518;
    this.NIV = 2054;
    this.NII = 0;
    this.NIW = a.p.gtv();
    this.NIX = 0;
    this.NHS = Collections.emptyList();
    this.NIY = a.p.gtv();
    this.NIZ = 0;
    this.NJs = a.t.guq();
    this.NJt = 0;
    this.NJu = 0;
    this.NIg = Collections.emptyList();
    AppMethodBeat.o(58716);
  }
  
  public static m gsY()
  {
    return NJr;
  }
  
  public final void a(f paramf)
  {
    int j = 0;
    AppMethodBeat.i(58718);
    zp();
    i.c.a locala = gwq();
    if ((this.NHg & 0x2) == 2) {
      paramf.bx(1, this.NIV);
    }
    if ((this.NHg & 0x4) == 4) {
      paramf.bx(2, this.NII);
    }
    if ((this.NHg & 0x8) == 8) {
      paramf.a(3, this.NIW);
    }
    int i = 0;
    while (i < this.NHS.size())
    {
      paramf.a(4, (q)this.NHS.get(i));
      i += 1;
    }
    if ((this.NHg & 0x20) == 32) {
      paramf.a(5, this.NIY);
    }
    if ((this.NHg & 0x80) == 128) {
      paramf.a(6, this.NJs);
    }
    if ((this.NHg & 0x100) == 256) {
      paramf.bx(7, this.NJt);
    }
    if ((this.NHg & 0x200) == 512) {
      paramf.bx(8, this.NJu);
    }
    if ((this.NHg & 0x10) == 16) {
      paramf.bx(9, this.NIX);
    }
    if ((this.NHg & 0x40) == 64) {
      paramf.bx(10, this.NIZ);
    }
    i = j;
    if ((this.NHg & 0x1) == 1)
    {
      paramf.bx(11, this.NHz);
      i = j;
    }
    while (i < this.NIg.size())
    {
      paramf.bx(31, ((Integer)this.NIg.get(i)).intValue());
      i += 1;
    }
    locala.b(19000, paramf);
    paramf.e(this.NHe);
    AppMethodBeat.o(58718);
  }
  
  public final s<m> gqQ()
  {
    return NHf;
  }
  
  public final boolean grq()
  {
    return (this.NHg & 0x1) == 1;
  }
  
  public final boolean gsC()
  {
    return (this.NHg & 0x2) == 2;
  }
  
  public final boolean gsD()
  {
    return (this.NHg & 0x8) == 8;
  }
  
  public final boolean gsE()
  {
    return (this.NHg & 0x10) == 16;
  }
  
  public final boolean gsF()
  {
    return (this.NHg & 0x20) == 32;
  }
  
  public final boolean gsG()
  {
    return (this.NHg & 0x40) == 64;
  }
  
  public final boolean gsZ()
  {
    return (this.NHg & 0x80) == 128;
  }
  
  public final boolean gsn()
  {
    return (this.NHg & 0x4) == 4;
  }
  
  public final boolean gta()
  {
    return (this.NHg & 0x100) == 256;
  }
  
  public final boolean gtb()
  {
    return (this.NHg & 0x200) == 512;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58717);
    int i = this.NHj;
    if (i == 1)
    {
      AppMethodBeat.o(58717);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58717);
      return false;
    }
    if (!gsn())
    {
      this.NHj = 0;
      AppMethodBeat.o(58717);
      return false;
    }
    if ((gsD()) && (!this.NIW.isInitialized()))
    {
      this.NHj = 0;
      AppMethodBeat.o(58717);
      return false;
    }
    i = 0;
    while (i < this.NHS.size())
    {
      if (!((a.r)this.NHS.get(i)).isInitialized())
      {
        this.NHj = 0;
        AppMethodBeat.o(58717);
        return false;
      }
      i += 1;
    }
    if ((gsF()) && (!this.NIY.isInitialized()))
    {
      this.NHj = 0;
      AppMethodBeat.o(58717);
      return false;
    }
    if ((gsZ()) && (!this.NJs.isInitialized()))
    {
      this.NHj = 0;
      AppMethodBeat.o(58717);
      return false;
    }
    if (!this.NOg.isInitialized())
    {
      this.NHj = 0;
      AppMethodBeat.o(58717);
      return false;
    }
    this.NHj = 1;
    AppMethodBeat.o(58717);
    return true;
  }
  
  public final int zp()
  {
    AppMethodBeat.i(58719);
    int i = this.NHk;
    if (i != -1)
    {
      AppMethodBeat.o(58719);
      return i;
    }
    if ((this.NHg & 0x2) == 2) {}
    for (int j = f.bz(1, this.NIV) + 0;; j = 0)
    {
      i = j;
      if ((this.NHg & 0x4) == 4) {
        i = j + f.bz(2, this.NII);
      }
      j = i;
      if ((this.NHg & 0x8) == 8) {
        j = i + f.c(3, this.NIW);
      }
      int k = 0;
      i = j;
      j = k;
      while (j < this.NHS.size())
      {
        i += f.c(4, (q)this.NHS.get(j));
        j += 1;
      }
      j = i;
      if ((this.NHg & 0x20) == 32) {
        j = i + f.c(5, this.NIY);
      }
      i = j;
      if ((this.NHg & 0x80) == 128) {
        i = j + f.c(6, this.NJs);
      }
      j = i;
      if ((this.NHg & 0x100) == 256) {
        j = i + f.bz(7, this.NJt);
      }
      i = j;
      if ((this.NHg & 0x200) == 512) {
        i = j + f.bz(8, this.NJu);
      }
      j = i;
      if ((this.NHg & 0x10) == 16) {
        j = i + f.bz(9, this.NIX);
      }
      i = j;
      if ((this.NHg & 0x40) == 64) {
        i = j + f.bz(10, this.NIZ);
      }
      j = i;
      if ((this.NHg & 0x1) == 1) {
        j = i + f.bz(11, this.NHz);
      }
      k = 0;
      int m;
      for (i = 0; k < this.NIg.size(); i = m + i)
      {
        m = f.fL(((Integer)this.NIg.get(k)).intValue());
        k += 1;
      }
      i = j + i + this.NIg.size() * 2 + this.NOg.zp() + this.NHe.size();
      this.NHk = i;
      AppMethodBeat.o(58719);
      return i;
    }
  }
  
  public static final class a
    extends i.b<a.m, a>
    implements n
  {
    private List<a.r> NHS;
    private int NHg;
    private int NHz;
    private int NII;
    private int NIV;
    private a.p NIW;
    private int NIX;
    private a.p NIY;
    private int NIZ;
    private List<Integer> NIg;
    private a.t NJs;
    private int NJt;
    private int NJu;
    
    private a()
    {
      AppMethodBeat.i(58693);
      this.NHz = 518;
      this.NIV = 2054;
      this.NIW = a.p.gtv();
      this.NHS = Collections.emptyList();
      this.NIY = a.p.gtv();
      this.NJs = a.t.guq();
      this.NIg = Collections.emptyList();
      AppMethodBeat.o(58693);
    }
    
    private a a(a.t paramt)
    {
      AppMethodBeat.i(58702);
      if (((this.NHg & 0x100) == 256) && (this.NJs != a.t.guq())) {}
      for (this.NJs = a.t.b(this.NJs).d(paramt).guu();; this.NJs = paramt)
      {
        this.NHg |= 0x100;
        AppMethodBeat.o(58702);
        return this;
      }
    }
    
    private a akF(int paramInt)
    {
      this.NHg |= 0x1;
      this.NHz = paramInt;
      return this;
    }
    
    private a akG(int paramInt)
    {
      this.NHg |= 0x2;
      this.NIV = paramInt;
      return this;
    }
    
    private a akH(int paramInt)
    {
      this.NHg |= 0x4;
      this.NII = paramInt;
      return this;
    }
    
    private a akI(int paramInt)
    {
      this.NHg |= 0x10;
      this.NIX = paramInt;
      return this;
    }
    
    private a akJ(int paramInt)
    {
      this.NHg |= 0x80;
      this.NIZ = paramInt;
      return this;
    }
    
    private a akK(int paramInt)
    {
      this.NHg |= 0x200;
      this.NJt = paramInt;
      return this;
    }
    
    private a akL(int paramInt)
    {
      this.NHg |= 0x400;
      this.NJu = paramInt;
      return this;
    }
    
    private a d(a.p paramp)
    {
      AppMethodBeat.i(58699);
      if (((this.NHg & 0x8) == 8) && (this.NIW != a.p.gtv())) {}
      for (this.NIW = a.p.f(this.NIW).j(paramp).gtR();; this.NIW = paramp)
      {
        this.NHg |= 0x8;
        AppMethodBeat.o(58699);
        return this;
      }
    }
    
    private a e(a.p paramp)
    {
      AppMethodBeat.i(58701);
      if (((this.NHg & 0x40) == 64) && (this.NIY != a.p.gtv())) {}
      for (this.NIY = a.p.f(this.NIY).j(paramp).gtR();; this.NIY = paramp)
      {
        this.NHg |= 0x40;
        AppMethodBeat.o(58701);
        return this;
      }
    }
    
    private void grG()
    {
      AppMethodBeat.i(58700);
      if ((this.NHg & 0x20) != 32)
      {
        this.NHS = new ArrayList(this.NHS);
        this.NHg |= 0x20;
      }
      AppMethodBeat.o(58700);
    }
    
    private void grQ()
    {
      AppMethodBeat.i(58703);
      if ((this.NHg & 0x800) != 2048)
      {
        this.NIg = new ArrayList(this.NIg);
        this.NHg |= 0x800;
      }
      AppMethodBeat.o(58703);
    }
    
    private a gtc()
    {
      AppMethodBeat.i(58694);
      a locala = new a().d(gtd());
      AppMethodBeat.o(58694);
      return locala;
    }
    
    private a.m gtd()
    {
      int j = 1;
      AppMethodBeat.i(58695);
      a.m localm = new a.m(this, (byte)0);
      int k = this.NHg;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.m.a(localm, this.NHz);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.m.b(localm, this.NIV);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.m.c(localm, this.NII);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.m.a(localm, this.NIW);
        j = i;
        if ((k & 0x10) == 16) {
          j = i | 0x10;
        }
        a.m.d(localm, this.NIX);
        if ((this.NHg & 0x20) == 32)
        {
          this.NHS = Collections.unmodifiableList(this.NHS);
          this.NHg &= 0xFFFFFFDF;
        }
        a.m.a(localm, this.NHS);
        i = j;
        if ((k & 0x40) == 64) {
          i = j | 0x20;
        }
        a.m.b(localm, this.NIY);
        j = i;
        if ((k & 0x80) == 128) {
          j = i | 0x40;
        }
        a.m.e(localm, this.NIZ);
        i = j;
        if ((k & 0x100) == 256) {
          i = j | 0x80;
        }
        a.m.a(localm, this.NJs);
        j = i;
        if ((k & 0x200) == 512) {
          j = i | 0x100;
        }
        a.m.f(localm, this.NJt);
        i = j;
        if ((k & 0x400) == 1024) {
          i = j | 0x200;
        }
        a.m.g(localm, this.NJu);
        if ((this.NHg & 0x800) == 2048)
        {
          this.NIg = Collections.unmodifiableList(this.NIg);
          this.NHg &= 0xFFFFF7FF;
        }
        a.m.b(localm, this.NIg);
        a.m.h(localm, i);
        AppMethodBeat.o(58695);
        return localm;
        j = 0;
      }
    }
    
    /* Error */
    private a p(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 197
      //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 201	d/l/b/a/b/e/a$m:NHf	Ld/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 206 3 0
      //   17: checkcast 9	d/l/b/a/b/e/a$m
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 149	d/l/b/a/b/e/a$m$a:d	(Ld/l/b/a/b/e/a$m;)Ld/l/b/a/b/e/a$m$a;
      //   26: pop
      //   27: ldc 197
      //   29: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 210	d/l/b/a/b/h/k:NOw	Ld/l/b/a/b/h/q;
      //   39: checkcast 9	d/l/b/a/b/e/a$m
      //   42: astore_2
      //   43: ldc 197
      //   45: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 149	d/l/b/a/b/e/a$m$a:d	(Ld/l/b/a/b/e/a$m;)Ld/l/b/a/b/e/a$m$a;
      //   60: pop
      //   61: ldc 197
      //   63: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   0	74	2	paramg	d.l.b.a.b.h.g
      //   6	64	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	d/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a d(a.m paramm)
    {
      AppMethodBeat.i(58696);
      if (paramm == a.m.gsY())
      {
        AppMethodBeat.o(58696);
        return this;
      }
      if (paramm.grq()) {
        akF(paramm.NHz);
      }
      if (paramm.gsC()) {
        akG(paramm.NIV);
      }
      if (paramm.gsn()) {
        akH(paramm.NII);
      }
      if (paramm.gsD()) {
        d(paramm.NIW);
      }
      if (paramm.gsE()) {
        akI(paramm.NIX);
      }
      if (!a.m.a(paramm).isEmpty())
      {
        if (this.NHS.isEmpty())
        {
          this.NHS = a.m.a(paramm);
          this.NHg &= 0xFFFFFFDF;
        }
      }
      else
      {
        if (paramm.gsF()) {
          e(paramm.NIY);
        }
        if (paramm.gsG()) {
          akJ(paramm.NIZ);
        }
        if (paramm.gsZ()) {
          a(paramm.NJs);
        }
        if (paramm.gta()) {
          akK(paramm.NJt);
        }
        if (paramm.gtb()) {
          akL(paramm.NJu);
        }
        if (!a.m.b(paramm).isEmpty())
        {
          if (!this.NIg.isEmpty()) {
            break label314;
          }
          this.NIg = a.m.b(paramm);
          this.NHg &= 0xFFFFF7FF;
        }
      }
      for (;;)
      {
        a(paramm);
        this.NHe = this.NHe.a(a.m.c(paramm));
        AppMethodBeat.o(58696);
        return this;
        grG();
        this.NHS.addAll(a.m.a(paramm));
        break;
        label314:
        grQ();
        this.NIg.addAll(a.m.b(paramm));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58697);
      if ((this.NHg & 0x4) == 4) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58697);
        return false;
      }
      if ((this.NHg & 0x8) == 8) {}
      for (i = 1; (i != 0) && (!this.NIW.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58697);
        return false;
      }
      i = 0;
      while (i < this.NHS.size())
      {
        if (!((a.r)this.NHS.get(i)).isInitialized())
        {
          AppMethodBeat.o(58697);
          return false;
        }
        i += 1;
      }
      if ((this.NHg & 0x40) == 64) {}
      for (i = 1; (i != 0) && (!this.NIY.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58697);
        return false;
      }
      if ((this.NHg & 0x100) == 256) {}
      for (i = 1; (i != 0) && (!this.NJs.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58697);
        return false;
      }
      if (!this.NOg.isInitialized())
      {
        AppMethodBeat.o(58697);
        return false;
      }
      AppMethodBeat.o(58697);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     d.l.b.a.b.e.a.m
 * JD-Core Version:    0.7.0.1
 */