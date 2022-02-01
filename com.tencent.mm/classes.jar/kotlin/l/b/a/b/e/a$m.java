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

public final class a$m
  extends i.c<m>
  implements n
{
  public static t<m> aaZC;
  private static final m abbK;
  private final d aaZB;
  public int aaZS;
  public List<a.r> abal;
  public List<Integer> abaz;
  public a.t abbL;
  public int abbM;
  public int abbN;
  public int abbb;
  public int abbo;
  public a.p abbp;
  public int abbq;
  public a.p abbr;
  public int abbs;
  private int bQS;
  private byte bRd = -1;
  private int bXW = -1;
  
  static
  {
    AppMethodBeat.i(58722);
    aaZC = new b() {};
    m localm = new m();
    abbK = localm;
    localm.iIN();
    AppMethodBeat.o(58722);
  }
  
  private a$m()
  {
    this.aaZB = d.abgb;
  }
  
  /* Error */
  private a$m(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 69	kotlin/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 86
    //   6: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 71	kotlin/l/b/a/b/e/a$m:bRd	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 73	kotlin/l/b/a/b/e/a$m:bXW	I
    //   19: aload_0
    //   20: invokespecial 64	kotlin/l/b/a/b/e/a$m:iIN	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 90	kotlin/l/b/a/b/h/d:iNH	()Lkotlin/l/b/a/b/h/d$b;
    //   28: astore 10
    //   30: aload 10
    //   32: iconst_1
    //   33: invokestatic 96	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   36: astore 11
    //   38: iconst_0
    //   39: istore 8
    //   41: iload 8
    //   43: ifne +1228 -> 1271
    //   46: iload_3
    //   47: istore 5
    //   49: iload_3
    //   50: istore 6
    //   52: iload_3
    //   53: istore 7
    //   55: aload_1
    //   56: invokevirtual 102	kotlin/l/b/a/b/h/e:Av	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+1369->1432, 0:+1372->1435, 8:+149->212, 16:+282->345, 26:+362->425, 34:+490->553, 42:+564->627, 50:+692->755, 56:+823->886, 64:+864->927, 72:+905->968, 80:+945->1008, 88:+985->1048, 248:+1024->1087, 250:+1100->1163
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
    //   200: invokevirtual 105	kotlin/l/b/a/b/e/a$m:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   203: ifne +1226 -> 1429
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
    //   223: getfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   226: iconst_2
    //   227: ior
    //   228: putfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   231: iload_3
    //   232: istore 5
    //   234: iload_3
    //   235: istore 6
    //   237: iload_3
    //   238: istore 7
    //   240: aload_0
    //   241: aload_1
    //   242: invokevirtual 110	kotlin/l/b/a/b/h/e:AK	()I
    //   245: putfield 112	kotlin/l/b/a/b/e/a$m:abbo	I
    //   248: goto -207 -> 41
    //   251: astore_1
    //   252: iload 5
    //   254: istore 4
    //   256: iload 4
    //   258: istore_3
    //   259: aload_1
    //   260: aload_0
    //   261: putfield 116	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
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
    //   289: getfield 118	kotlin/l/b/a/b/e/a$m:abal	Ljava/util/List;
    //   292: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   295: putfield 118	kotlin/l/b/a/b/e/a$m:abal	Ljava/util/List;
    //   298: iload_3
    //   299: sipush 2048
    //   302: iand
    //   303: sipush 2048
    //   306: if_icmpne +14 -> 320
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 126	kotlin/l/b/a/b/e/a$m:abaz	Ljava/util/List;
    //   314: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   317: putfield 126	kotlin/l/b/a/b/e/a$m:abaz	Ljava/util/List;
    //   320: aload 11
    //   322: invokevirtual 129	kotlin/l/b/a/b/h/f:flush	()V
    //   325: aload_0
    //   326: aload 10
    //   328: invokevirtual 135	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   331: putfield 80	kotlin/l/b/a/b/e/a$m:aaZB	Lkotlin/l/b/a/b/h/d;
    //   334: aload_0
    //   335: invokevirtual 138	kotlin/l/b/a/b/e/a$m:HZ	()V
    //   338: ldc 86
    //   340: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: aload_1
    //   344: athrow
    //   345: iload_3
    //   346: istore 5
    //   348: iload_3
    //   349: istore 6
    //   351: iload_3
    //   352: istore 7
    //   354: aload_0
    //   355: aload_0
    //   356: getfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   359: iconst_4
    //   360: ior
    //   361: putfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   364: iload_3
    //   365: istore 5
    //   367: iload_3
    //   368: istore 6
    //   370: iload_3
    //   371: istore 7
    //   373: aload_0
    //   374: aload_1
    //   375: invokevirtual 110	kotlin/l/b/a/b/h/e:AK	()I
    //   378: putfield 140	kotlin/l/b/a/b/e/a$m:abbb	I
    //   381: goto -340 -> 41
    //   384: astore_1
    //   385: iload 6
    //   387: istore 4
    //   389: iload 4
    //   391: istore_3
    //   392: new 83	kotlin/l/b/a/b/h/l
    //   395: dup
    //   396: aload_1
    //   397: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
    //   400: invokespecial 147	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   403: astore_1
    //   404: iload 4
    //   406: istore_3
    //   407: aload_1
    //   408: aload_0
    //   409: putfield 116	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   412: iload 4
    //   414: istore_3
    //   415: ldc 86
    //   417: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   420: iload 4
    //   422: istore_3
    //   423: aload_1
    //   424: athrow
    //   425: iload_3
    //   426: istore 5
    //   428: iload_3
    //   429: istore 6
    //   431: iload_3
    //   432: istore 7
    //   434: aload_0
    //   435: getfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   438: bipush 8
    //   440: iand
    //   441: bipush 8
    //   443: if_icmpne +980 -> 1423
    //   446: iload_3
    //   447: istore 5
    //   449: iload_3
    //   450: istore 6
    //   452: iload_3
    //   453: istore 7
    //   455: aload_0
    //   456: getfield 149	kotlin/l/b/a/b/e/a$m:abbp	Lkotlin/l/b/a/b/e/a$p;
    //   459: invokestatic 154	kotlin/l/b/a/b/e/a$p:f	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   462: astore 9
    //   464: iload_3
    //   465: istore 5
    //   467: iload_3
    //   468: istore 6
    //   470: iload_3
    //   471: istore 7
    //   473: aload_0
    //   474: aload_1
    //   475: getstatic 155	kotlin/l/b/a/b/e/a$p:aaZC	Lkotlin/l/b/a/b/h/t;
    //   478: aload_2
    //   479: invokevirtual 158	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   482: checkcast 151	kotlin/l/b/a/b/e/a$p
    //   485: putfield 149	kotlin/l/b/a/b/e/a$m:abbp	Lkotlin/l/b/a/b/e/a$p;
    //   488: aload 9
    //   490: ifnull +40 -> 530
    //   493: iload_3
    //   494: istore 5
    //   496: iload_3
    //   497: istore 6
    //   499: iload_3
    //   500: istore 7
    //   502: aload 9
    //   504: aload_0
    //   505: getfield 149	kotlin/l/b/a/b/e/a$m:abbp	Lkotlin/l/b/a/b/e/a$p;
    //   508: invokevirtual 163	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   511: pop
    //   512: iload_3
    //   513: istore 5
    //   515: iload_3
    //   516: istore 6
    //   518: iload_3
    //   519: istore 7
    //   521: aload_0
    //   522: aload 9
    //   524: invokevirtual 167	kotlin/l/b/a/b/e/a$p$b:iLI	()Lkotlin/l/b/a/b/e/a$p;
    //   527: putfield 149	kotlin/l/b/a/b/e/a$m:abbp	Lkotlin/l/b/a/b/e/a$p;
    //   530: iload_3
    //   531: istore 5
    //   533: iload_3
    //   534: istore 6
    //   536: iload_3
    //   537: istore 7
    //   539: aload_0
    //   540: aload_0
    //   541: getfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   544: bipush 8
    //   546: ior
    //   547: putfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   550: goto -509 -> 41
    //   553: iload_3
    //   554: istore 4
    //   556: iload_3
    //   557: bipush 32
    //   559: iand
    //   560: bipush 32
    //   562: if_icmpeq +29 -> 591
    //   565: iload_3
    //   566: istore 5
    //   568: iload_3
    //   569: istore 6
    //   571: iload_3
    //   572: istore 7
    //   574: aload_0
    //   575: new 169	java/util/ArrayList
    //   578: dup
    //   579: invokespecial 170	java/util/ArrayList:<init>	()V
    //   582: putfield 118	kotlin/l/b/a/b/e/a$m:abal	Ljava/util/List;
    //   585: iload_3
    //   586: bipush 32
    //   588: ior
    //   589: istore 4
    //   591: iload 4
    //   593: istore 5
    //   595: iload 4
    //   597: istore 6
    //   599: iload 4
    //   601: istore 7
    //   603: aload_0
    //   604: getfield 118	kotlin/l/b/a/b/e/a$m:abal	Ljava/util/List;
    //   607: aload_1
    //   608: getstatic 173	kotlin/l/b/a/b/e/a$r:aaZC	Lkotlin/l/b/a/b/h/t;
    //   611: aload_2
    //   612: invokevirtual 158	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   615: invokeinterface 179 2 0
    //   620: pop
    //   621: iload 4
    //   623: istore_3
    //   624: goto -583 -> 41
    //   627: iload_3
    //   628: istore 5
    //   630: iload_3
    //   631: istore 6
    //   633: iload_3
    //   634: istore 7
    //   636: aload_0
    //   637: getfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   640: bipush 32
    //   642: iand
    //   643: bipush 32
    //   645: if_icmpne +772 -> 1417
    //   648: iload_3
    //   649: istore 5
    //   651: iload_3
    //   652: istore 6
    //   654: iload_3
    //   655: istore 7
    //   657: aload_0
    //   658: getfield 181	kotlin/l/b/a/b/e/a$m:abbr	Lkotlin/l/b/a/b/e/a$p;
    //   661: invokestatic 154	kotlin/l/b/a/b/e/a$p:f	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   664: astore 9
    //   666: iload_3
    //   667: istore 5
    //   669: iload_3
    //   670: istore 6
    //   672: iload_3
    //   673: istore 7
    //   675: aload_0
    //   676: aload_1
    //   677: getstatic 155	kotlin/l/b/a/b/e/a$p:aaZC	Lkotlin/l/b/a/b/h/t;
    //   680: aload_2
    //   681: invokevirtual 158	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   684: checkcast 151	kotlin/l/b/a/b/e/a$p
    //   687: putfield 181	kotlin/l/b/a/b/e/a$m:abbr	Lkotlin/l/b/a/b/e/a$p;
    //   690: aload 9
    //   692: ifnull +40 -> 732
    //   695: iload_3
    //   696: istore 5
    //   698: iload_3
    //   699: istore 6
    //   701: iload_3
    //   702: istore 7
    //   704: aload 9
    //   706: aload_0
    //   707: getfield 181	kotlin/l/b/a/b/e/a$m:abbr	Lkotlin/l/b/a/b/e/a$p;
    //   710: invokevirtual 163	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   713: pop
    //   714: iload_3
    //   715: istore 5
    //   717: iload_3
    //   718: istore 6
    //   720: iload_3
    //   721: istore 7
    //   723: aload_0
    //   724: aload 9
    //   726: invokevirtual 167	kotlin/l/b/a/b/e/a$p$b:iLI	()Lkotlin/l/b/a/b/e/a$p;
    //   729: putfield 181	kotlin/l/b/a/b/e/a$m:abbr	Lkotlin/l/b/a/b/e/a$p;
    //   732: iload_3
    //   733: istore 5
    //   735: iload_3
    //   736: istore 6
    //   738: iload_3
    //   739: istore 7
    //   741: aload_0
    //   742: aload_0
    //   743: getfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   746: bipush 32
    //   748: ior
    //   749: putfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   752: goto -711 -> 41
    //   755: iload_3
    //   756: istore 5
    //   758: iload_3
    //   759: istore 6
    //   761: iload_3
    //   762: istore 7
    //   764: aload_0
    //   765: getfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   768: sipush 128
    //   771: iand
    //   772: sipush 128
    //   775: if_icmpne +636 -> 1411
    //   778: iload_3
    //   779: istore 5
    //   781: iload_3
    //   782: istore 6
    //   784: iload_3
    //   785: istore 7
    //   787: aload_0
    //   788: getfield 183	kotlin/l/b/a/b/e/a$m:abbL	Lkotlin/l/b/a/b/e/a$t;
    //   791: invokestatic 189	kotlin/l/b/a/b/e/a$t:b	(Lkotlin/l/b/a/b/e/a$t;)Lkotlin/l/b/a/b/e/a$t$a;
    //   794: astore 9
    //   796: iload_3
    //   797: istore 5
    //   799: iload_3
    //   800: istore 6
    //   802: iload_3
    //   803: istore 7
    //   805: aload_0
    //   806: aload_1
    //   807: getstatic 190	kotlin/l/b/a/b/e/a$t:aaZC	Lkotlin/l/b/a/b/h/t;
    //   810: aload_2
    //   811: invokevirtual 158	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   814: checkcast 185	kotlin/l/b/a/b/e/a$t
    //   817: putfield 183	kotlin/l/b/a/b/e/a$m:abbL	Lkotlin/l/b/a/b/e/a$t;
    //   820: aload 9
    //   822: ifnull +40 -> 862
    //   825: iload_3
    //   826: istore 5
    //   828: iload_3
    //   829: istore 6
    //   831: iload_3
    //   832: istore 7
    //   834: aload 9
    //   836: aload_0
    //   837: getfield 183	kotlin/l/b/a/b/e/a$m:abbL	Lkotlin/l/b/a/b/e/a$t;
    //   840: invokevirtual 195	kotlin/l/b/a/b/e/a$t$a:d	(Lkotlin/l/b/a/b/e/a$t;)Lkotlin/l/b/a/b/e/a$t$a;
    //   843: pop
    //   844: iload_3
    //   845: istore 5
    //   847: iload_3
    //   848: istore 6
    //   850: iload_3
    //   851: istore 7
    //   853: aload_0
    //   854: aload 9
    //   856: invokevirtual 199	kotlin/l/b/a/b/e/a$t$a:iMl	()Lkotlin/l/b/a/b/e/a$t;
    //   859: putfield 183	kotlin/l/b/a/b/e/a$m:abbL	Lkotlin/l/b/a/b/e/a$t;
    //   862: iload_3
    //   863: istore 5
    //   865: iload_3
    //   866: istore 6
    //   868: iload_3
    //   869: istore 7
    //   871: aload_0
    //   872: aload_0
    //   873: getfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   876: sipush 128
    //   879: ior
    //   880: putfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   883: goto -842 -> 41
    //   886: iload_3
    //   887: istore 5
    //   889: iload_3
    //   890: istore 6
    //   892: iload_3
    //   893: istore 7
    //   895: aload_0
    //   896: aload_0
    //   897: getfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   900: sipush 256
    //   903: ior
    //   904: putfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   907: iload_3
    //   908: istore 5
    //   910: iload_3
    //   911: istore 6
    //   913: iload_3
    //   914: istore 7
    //   916: aload_0
    //   917: aload_1
    //   918: invokevirtual 110	kotlin/l/b/a/b/h/e:AK	()I
    //   921: putfield 201	kotlin/l/b/a/b/e/a$m:abbM	I
    //   924: goto -883 -> 41
    //   927: iload_3
    //   928: istore 5
    //   930: iload_3
    //   931: istore 6
    //   933: iload_3
    //   934: istore 7
    //   936: aload_0
    //   937: aload_0
    //   938: getfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   941: sipush 512
    //   944: ior
    //   945: putfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   948: iload_3
    //   949: istore 5
    //   951: iload_3
    //   952: istore 6
    //   954: iload_3
    //   955: istore 7
    //   957: aload_0
    //   958: aload_1
    //   959: invokevirtual 110	kotlin/l/b/a/b/h/e:AK	()I
    //   962: putfield 203	kotlin/l/b/a/b/e/a$m:abbN	I
    //   965: goto -924 -> 41
    //   968: iload_3
    //   969: istore 5
    //   971: iload_3
    //   972: istore 6
    //   974: iload_3
    //   975: istore 7
    //   977: aload_0
    //   978: aload_0
    //   979: getfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   982: bipush 16
    //   984: ior
    //   985: putfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   988: iload_3
    //   989: istore 5
    //   991: iload_3
    //   992: istore 6
    //   994: iload_3
    //   995: istore 7
    //   997: aload_0
    //   998: aload_1
    //   999: invokevirtual 110	kotlin/l/b/a/b/h/e:AK	()I
    //   1002: putfield 205	kotlin/l/b/a/b/e/a$m:abbq	I
    //   1005: goto -964 -> 41
    //   1008: iload_3
    //   1009: istore 5
    //   1011: iload_3
    //   1012: istore 6
    //   1014: iload_3
    //   1015: istore 7
    //   1017: aload_0
    //   1018: aload_0
    //   1019: getfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   1022: bipush 64
    //   1024: ior
    //   1025: putfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   1028: iload_3
    //   1029: istore 5
    //   1031: iload_3
    //   1032: istore 6
    //   1034: iload_3
    //   1035: istore 7
    //   1037: aload_0
    //   1038: aload_1
    //   1039: invokevirtual 110	kotlin/l/b/a/b/h/e:AK	()I
    //   1042: putfield 207	kotlin/l/b/a/b/e/a$m:abbs	I
    //   1045: goto -1004 -> 41
    //   1048: iload_3
    //   1049: istore 5
    //   1051: iload_3
    //   1052: istore 6
    //   1054: iload_3
    //   1055: istore 7
    //   1057: aload_0
    //   1058: aload_0
    //   1059: getfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   1062: iconst_1
    //   1063: ior
    //   1064: putfield 107	kotlin/l/b/a/b/e/a$m:bQS	I
    //   1067: iload_3
    //   1068: istore 5
    //   1070: iload_3
    //   1071: istore 6
    //   1073: iload_3
    //   1074: istore 7
    //   1076: aload_0
    //   1077: aload_1
    //   1078: invokevirtual 110	kotlin/l/b/a/b/h/e:AK	()I
    //   1081: putfield 209	kotlin/l/b/a/b/e/a$m:aaZS	I
    //   1084: goto -1043 -> 41
    //   1087: iload_3
    //   1088: istore 4
    //   1090: iload_3
    //   1091: sipush 2048
    //   1094: iand
    //   1095: sipush 2048
    //   1098: if_icmpeq +30 -> 1128
    //   1101: iload_3
    //   1102: istore 5
    //   1104: iload_3
    //   1105: istore 6
    //   1107: iload_3
    //   1108: istore 7
    //   1110: aload_0
    //   1111: new 169	java/util/ArrayList
    //   1114: dup
    //   1115: invokespecial 170	java/util/ArrayList:<init>	()V
    //   1118: putfield 126	kotlin/l/b/a/b/e/a$m:abaz	Ljava/util/List;
    //   1121: iload_3
    //   1122: sipush 2048
    //   1125: ior
    //   1126: istore 4
    //   1128: iload 4
    //   1130: istore 5
    //   1132: iload 4
    //   1134: istore 6
    //   1136: iload 4
    //   1138: istore 7
    //   1140: aload_0
    //   1141: getfield 126	kotlin/l/b/a/b/e/a$m:abaz	Ljava/util/List;
    //   1144: aload_1
    //   1145: invokevirtual 110	kotlin/l/b/a/b/h/e:AK	()I
    //   1148: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1151: invokeinterface 179 2 0
    //   1156: pop
    //   1157: iload 4
    //   1159: istore_3
    //   1160: goto -1119 -> 41
    //   1163: iload_3
    //   1164: istore 5
    //   1166: iload_3
    //   1167: istore 6
    //   1169: iload_3
    //   1170: istore 7
    //   1172: aload_1
    //   1173: aload_1
    //   1174: invokevirtual 110	kotlin/l/b/a/b/h/e:AK	()I
    //   1177: invokevirtual 219	kotlin/l/b/a/b/h/e:gA	(I)I
    //   1180: istore 4
    //   1182: iload_3
    //   1183: sipush 2048
    //   1186: iand
    //   1187: sipush 2048
    //   1190: if_icmpeq +218 -> 1408
    //   1193: iload_3
    //   1194: istore 5
    //   1196: iload_3
    //   1197: istore 6
    //   1199: iload_3
    //   1200: istore 7
    //   1202: aload_1
    //   1203: invokevirtual 222	kotlin/l/b/a/b/h/e:AM	()I
    //   1206: ifle +202 -> 1408
    //   1209: iload_3
    //   1210: istore 5
    //   1212: iload_3
    //   1213: istore 6
    //   1215: iload_3
    //   1216: istore 7
    //   1218: aload_0
    //   1219: new 169	java/util/ArrayList
    //   1222: dup
    //   1223: invokespecial 170	java/util/ArrayList:<init>	()V
    //   1226: putfield 126	kotlin/l/b/a/b/e/a$m:abaz	Ljava/util/List;
    //   1229: iload_3
    //   1230: sipush 2048
    //   1233: ior
    //   1234: istore_3
    //   1235: aload_1
    //   1236: invokevirtual 222	kotlin/l/b/a/b/h/e:AM	()I
    //   1239: ifle +23 -> 1262
    //   1242: aload_0
    //   1243: getfield 126	kotlin/l/b/a/b/e/a$m:abaz	Ljava/util/List;
    //   1246: aload_1
    //   1247: invokevirtual 110	kotlin/l/b/a/b/h/e:AK	()I
    //   1250: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1253: invokeinterface 179 2 0
    //   1258: pop
    //   1259: goto -24 -> 1235
    //   1262: aload_1
    //   1263: iload 4
    //   1265: invokevirtual 225	kotlin/l/b/a/b/h/e:gB	(I)V
    //   1268: goto -1227 -> 41
    //   1271: iload_3
    //   1272: bipush 32
    //   1274: iand
    //   1275: bipush 32
    //   1277: if_icmpne +14 -> 1291
    //   1280: aload_0
    //   1281: aload_0
    //   1282: getfield 118	kotlin/l/b/a/b/e/a$m:abal	Ljava/util/List;
    //   1285: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1288: putfield 118	kotlin/l/b/a/b/e/a$m:abal	Ljava/util/List;
    //   1291: iload_3
    //   1292: sipush 2048
    //   1295: iand
    //   1296: sipush 2048
    //   1299: if_icmpne +14 -> 1313
    //   1302: aload_0
    //   1303: aload_0
    //   1304: getfield 126	kotlin/l/b/a/b/e/a$m:abaz	Ljava/util/List;
    //   1307: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1310: putfield 126	kotlin/l/b/a/b/e/a$m:abaz	Ljava/util/List;
    //   1313: aload 11
    //   1315: invokevirtual 129	kotlin/l/b/a/b/h/f:flush	()V
    //   1318: aload_0
    //   1319: aload 10
    //   1321: invokevirtual 135	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   1324: putfield 80	kotlin/l/b/a/b/e/a$m:aaZB	Lkotlin/l/b/a/b/h/d;
    //   1327: aload_0
    //   1328: invokevirtual 138	kotlin/l/b/a/b/e/a$m:HZ	()V
    //   1331: ldc 86
    //   1333: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1336: return
    //   1337: astore_1
    //   1338: aload_0
    //   1339: aload 10
    //   1341: invokevirtual 135	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   1344: putfield 80	kotlin/l/b/a/b/e/a$m:aaZB	Lkotlin/l/b/a/b/h/d;
    //   1347: goto -20 -> 1327
    //   1350: astore_1
    //   1351: aload_0
    //   1352: aload 10
    //   1354: invokevirtual 135	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   1357: putfield 80	kotlin/l/b/a/b/e/a$m:aaZB	Lkotlin/l/b/a/b/h/d;
    //   1360: ldc 86
    //   1362: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1365: aload_1
    //   1366: athrow
    //   1367: astore_2
    //   1368: aload_0
    //   1369: aload 10
    //   1371: invokevirtual 135	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   1374: putfield 80	kotlin/l/b/a/b/e/a$m:aaZB	Lkotlin/l/b/a/b/h/d;
    //   1377: goto -1043 -> 334
    //   1380: astore_1
    //   1381: aload_0
    //   1382: aload 10
    //   1384: invokevirtual 135	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   1387: putfield 80	kotlin/l/b/a/b/e/a$m:aaZB	Lkotlin/l/b/a/b/h/d;
    //   1390: ldc 86
    //   1392: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1395: aload_1
    //   1396: athrow
    //   1397: astore_1
    //   1398: goto -1120 -> 278
    //   1401: astore_1
    //   1402: iload_3
    //   1403: istore 4
    //   1405: goto -1016 -> 389
    //   1408: goto -173 -> 1235
    //   1411: aconst_null
    //   1412: astore 9
    //   1414: goto -618 -> 796
    //   1417: aconst_null
    //   1418: astore 9
    //   1420: goto -754 -> 666
    //   1423: aconst_null
    //   1424: astore 9
    //   1426: goto -962 -> 464
    //   1429: goto -161 -> 1268
    //   1432: goto -1248 -> 184
    //   1435: iconst_1
    //   1436: istore 8
    //   1438: goto -1397 -> 41
    //   1441: astore_1
    //   1442: iload 7
    //   1444: istore_3
    //   1445: goto -1167 -> 278
    //   1448: astore_1
    //   1449: iload_3
    //   1450: istore 4
    //   1452: goto -1196 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1455	0	this	m
    //   0	1455	1	parame	kotlin.l.b.a.b.h.e
    //   0	1455	2	paramg	kotlin.l.b.a.b.h.g
    //   24	1426	3	i	int
    //   59	1392	4	j	int
    //   47	1164	5	k	int
    //   50	1164	6	m	int
    //   53	1390	7	n	int
    //   39	1398	8	i1	int
    //   462	963	9	localObject	java.lang.Object
    //   28	1355	10	localb	kotlin.l.b.a.b.h.d.b
    //   36	1278	11	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	251	kotlin/l/b/a/b/h/l
    //   193	206	251	kotlin/l/b/a/b/h/l
    //   221	231	251	kotlin/l/b/a/b/h/l
    //   240	248	251	kotlin/l/b/a/b/h/l
    //   354	364	251	kotlin/l/b/a/b/h/l
    //   373	381	251	kotlin/l/b/a/b/h/l
    //   434	446	251	kotlin/l/b/a/b/h/l
    //   455	464	251	kotlin/l/b/a/b/h/l
    //   473	488	251	kotlin/l/b/a/b/h/l
    //   502	512	251	kotlin/l/b/a/b/h/l
    //   521	530	251	kotlin/l/b/a/b/h/l
    //   539	550	251	kotlin/l/b/a/b/h/l
    //   574	585	251	kotlin/l/b/a/b/h/l
    //   603	621	251	kotlin/l/b/a/b/h/l
    //   636	648	251	kotlin/l/b/a/b/h/l
    //   657	666	251	kotlin/l/b/a/b/h/l
    //   675	690	251	kotlin/l/b/a/b/h/l
    //   704	714	251	kotlin/l/b/a/b/h/l
    //   723	732	251	kotlin/l/b/a/b/h/l
    //   741	752	251	kotlin/l/b/a/b/h/l
    //   764	778	251	kotlin/l/b/a/b/h/l
    //   787	796	251	kotlin/l/b/a/b/h/l
    //   805	820	251	kotlin/l/b/a/b/h/l
    //   834	844	251	kotlin/l/b/a/b/h/l
    //   853	862	251	kotlin/l/b/a/b/h/l
    //   871	883	251	kotlin/l/b/a/b/h/l
    //   895	907	251	kotlin/l/b/a/b/h/l
    //   916	924	251	kotlin/l/b/a/b/h/l
    //   936	948	251	kotlin/l/b/a/b/h/l
    //   957	965	251	kotlin/l/b/a/b/h/l
    //   977	988	251	kotlin/l/b/a/b/h/l
    //   997	1005	251	kotlin/l/b/a/b/h/l
    //   1017	1028	251	kotlin/l/b/a/b/h/l
    //   1037	1045	251	kotlin/l/b/a/b/h/l
    //   1057	1067	251	kotlin/l/b/a/b/h/l
    //   1076	1084	251	kotlin/l/b/a/b/h/l
    //   1110	1121	251	kotlin/l/b/a/b/h/l
    //   1140	1157	251	kotlin/l/b/a/b/h/l
    //   1172	1182	251	kotlin/l/b/a/b/h/l
    //   1202	1209	251	kotlin/l/b/a/b/h/l
    //   1218	1229	251	kotlin/l/b/a/b/h/l
    //   259	264	277	finally
    //   267	272	277	finally
    //   275	277	277	finally
    //   392	404	277	finally
    //   407	412	277	finally
    //   415	420	277	finally
    //   423	425	277	finally
    //   55	61	384	java/io/IOException
    //   193	206	384	java/io/IOException
    //   221	231	384	java/io/IOException
    //   240	248	384	java/io/IOException
    //   354	364	384	java/io/IOException
    //   373	381	384	java/io/IOException
    //   434	446	384	java/io/IOException
    //   455	464	384	java/io/IOException
    //   473	488	384	java/io/IOException
    //   502	512	384	java/io/IOException
    //   521	530	384	java/io/IOException
    //   539	550	384	java/io/IOException
    //   574	585	384	java/io/IOException
    //   603	621	384	java/io/IOException
    //   636	648	384	java/io/IOException
    //   657	666	384	java/io/IOException
    //   675	690	384	java/io/IOException
    //   704	714	384	java/io/IOException
    //   723	732	384	java/io/IOException
    //   741	752	384	java/io/IOException
    //   764	778	384	java/io/IOException
    //   787	796	384	java/io/IOException
    //   805	820	384	java/io/IOException
    //   834	844	384	java/io/IOException
    //   853	862	384	java/io/IOException
    //   871	883	384	java/io/IOException
    //   895	907	384	java/io/IOException
    //   916	924	384	java/io/IOException
    //   936	948	384	java/io/IOException
    //   957	965	384	java/io/IOException
    //   977	988	384	java/io/IOException
    //   997	1005	384	java/io/IOException
    //   1017	1028	384	java/io/IOException
    //   1037	1045	384	java/io/IOException
    //   1057	1067	384	java/io/IOException
    //   1076	1084	384	java/io/IOException
    //   1110	1121	384	java/io/IOException
    //   1140	1157	384	java/io/IOException
    //   1172	1182	384	java/io/IOException
    //   1202	1209	384	java/io/IOException
    //   1218	1229	384	java/io/IOException
    //   1313	1318	1337	java/io/IOException
    //   1313	1318	1350	finally
    //   320	325	1367	java/io/IOException
    //   320	325	1380	finally
    //   1235	1259	1397	finally
    //   1262	1268	1397	finally
    //   1235	1259	1401	java/io/IOException
    //   1262	1268	1401	java/io/IOException
    //   55	61	1441	finally
    //   193	206	1441	finally
    //   221	231	1441	finally
    //   240	248	1441	finally
    //   354	364	1441	finally
    //   373	381	1441	finally
    //   434	446	1441	finally
    //   455	464	1441	finally
    //   473	488	1441	finally
    //   502	512	1441	finally
    //   521	530	1441	finally
    //   539	550	1441	finally
    //   574	585	1441	finally
    //   603	621	1441	finally
    //   636	648	1441	finally
    //   657	666	1441	finally
    //   675	690	1441	finally
    //   704	714	1441	finally
    //   723	732	1441	finally
    //   741	752	1441	finally
    //   764	778	1441	finally
    //   787	796	1441	finally
    //   805	820	1441	finally
    //   834	844	1441	finally
    //   853	862	1441	finally
    //   871	883	1441	finally
    //   895	907	1441	finally
    //   916	924	1441	finally
    //   936	948	1441	finally
    //   957	965	1441	finally
    //   977	988	1441	finally
    //   997	1005	1441	finally
    //   1017	1028	1441	finally
    //   1037	1045	1441	finally
    //   1057	1067	1441	finally
    //   1076	1084	1441	finally
    //   1110	1121	1441	finally
    //   1140	1157	1441	finally
    //   1172	1182	1441	finally
    //   1202	1209	1441	finally
    //   1218	1229	1441	finally
    //   1235	1259	1448	kotlin/l/b/a/b/h/l
    //   1262	1268	1448	kotlin/l/b/a/b/h/l
  }
  
  private a$m(i.b<m, ?> paramb)
  {
    super(paramb);
    this.aaZB = paramb.aaZB;
  }
  
  private void iIN()
  {
    AppMethodBeat.i(58716);
    this.aaZS = 518;
    this.abbo = 2054;
    this.abbb = 0;
    this.abbp = a.p.iLm();
    this.abbq = 0;
    this.abal = Collections.emptyList();
    this.abbr = a.p.iLm();
    this.abbs = 0;
    this.abbL = a.t.iMh();
    this.abbM = 0;
    this.abbN = 0;
    this.abaz = Collections.emptyList();
    AppMethodBeat.o(58716);
  }
  
  public static m iKP()
  {
    return abbK;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(58719);
    int i = this.bXW;
    if (i != -1)
    {
      AppMethodBeat.o(58719);
      return i;
    }
    if ((this.bQS & 0x2) == 2) {}
    for (int j = f.bM(1, this.abbo) + 0;; j = 0)
    {
      i = j;
      if ((this.bQS & 0x4) == 4) {
        i = j + f.bM(2, this.abbb);
      }
      j = i;
      if ((this.bQS & 0x8) == 8) {
        j = i + f.c(3, this.abbp);
      }
      int k = 0;
      i = j;
      j = k;
      while (j < this.abal.size())
      {
        i += f.c(4, (r)this.abal.get(j));
        j += 1;
      }
      j = i;
      if ((this.bQS & 0x20) == 32) {
        j = i + f.c(5, this.abbr);
      }
      i = j;
      if ((this.bQS & 0x80) == 128) {
        i = j + f.c(6, this.abbL);
      }
      j = i;
      if ((this.bQS & 0x100) == 256) {
        j = i + f.bM(7, this.abbM);
      }
      i = j;
      if ((this.bQS & 0x200) == 512) {
        i = j + f.bM(8, this.abbN);
      }
      j = i;
      if ((this.bQS & 0x10) == 16) {
        j = i + f.bM(9, this.abbq);
      }
      i = j;
      if ((this.bQS & 0x40) == 64) {
        i = j + f.bM(10, this.abbs);
      }
      j = i;
      if ((this.bQS & 0x1) == 1) {
        j = i + f.bM(11, this.aaZS);
      }
      k = 0;
      int m;
      for (i = 0; k < this.abaz.size(); i = m + i)
      {
        m = f.gM(((Integer)this.abaz.get(k)).intValue());
        k += 1;
      }
      i = j + i + this.abaz.size() * 2 + Ii() + this.aaZB.size();
      this.bXW = i;
      AppMethodBeat.o(58719);
      return i;
    }
  }
  
  public final boolean Cc()
  {
    return (this.bQS & 0x4) == 4;
  }
  
  public final void a(f paramf)
  {
    int j = 0;
    AppMethodBeat.i(58718);
    Ad();
    i.c.a locala = iNU();
    if ((this.bQS & 0x2) == 2) {
      paramf.bJ(1, this.abbo);
    }
    if ((this.bQS & 0x4) == 4) {
      paramf.bJ(2, this.abbb);
    }
    if ((this.bQS & 0x8) == 8) {
      paramf.a(3, this.abbp);
    }
    int i = 0;
    while (i < this.abal.size())
    {
      paramf.a(4, (r)this.abal.get(i));
      i += 1;
    }
    if ((this.bQS & 0x20) == 32) {
      paramf.a(5, this.abbr);
    }
    if ((this.bQS & 0x80) == 128) {
      paramf.a(6, this.abbL);
    }
    if ((this.bQS & 0x100) == 256) {
      paramf.bJ(7, this.abbM);
    }
    if ((this.bQS & 0x200) == 512) {
      paramf.bJ(8, this.abbN);
    }
    if ((this.bQS & 0x10) == 16) {
      paramf.bJ(9, this.abbq);
    }
    if ((this.bQS & 0x40) == 64) {
      paramf.bJ(10, this.abbs);
    }
    i = j;
    if ((this.bQS & 0x1) == 1)
    {
      paramf.bJ(11, this.aaZS);
      i = j;
    }
    while (i < this.abaz.size())
    {
      paramf.bJ(31, ((Integer)this.abaz.get(i)).intValue());
      i += 1;
    }
    locala.b(19000, paramf);
    paramf.e(this.aaZB);
    AppMethodBeat.o(58718);
  }
  
  public final boolean iJj()
  {
    return (this.bQS & 0x1) == 1;
  }
  
  public final boolean iKQ()
  {
    return (this.bQS & 0x80) == 128;
  }
  
  public final boolean iKR()
  {
    return (this.bQS & 0x100) == 256;
  }
  
  public final boolean iKS()
  {
    return (this.bQS & 0x200) == 512;
  }
  
  public final boolean iKu()
  {
    return (this.bQS & 0x2) == 2;
  }
  
  public final boolean iKv()
  {
    return (this.bQS & 0x8) == 8;
  }
  
  public final boolean iKw()
  {
    return (this.bQS & 0x10) == 16;
  }
  
  public final boolean iKx()
  {
    return (this.bQS & 0x20) == 32;
  }
  
  public final boolean iKy()
  {
    return (this.bQS & 0x40) == 64;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58717);
    int i = this.bRd;
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
    if (!Cc())
    {
      this.bRd = 0;
      AppMethodBeat.o(58717);
      return false;
    }
    if ((iKv()) && (!this.abbp.isInitialized()))
    {
      this.bRd = 0;
      AppMethodBeat.o(58717);
      return false;
    }
    i = 0;
    while (i < this.abal.size())
    {
      if (!((a.r)this.abal.get(i)).isInitialized())
      {
        this.bRd = 0;
        AppMethodBeat.o(58717);
        return false;
      }
      i += 1;
    }
    if ((iKx()) && (!this.abbr.isInitialized()))
    {
      this.bRd = 0;
      AppMethodBeat.o(58717);
      return false;
    }
    if ((iKQ()) && (!this.abbL.isInitialized()))
    {
      this.bRd = 0;
      AppMethodBeat.o(58717);
      return false;
    }
    if (!Ig())
    {
      this.bRd = 0;
      AppMethodBeat.o(58717);
      return false;
    }
    this.bRd = 1;
    AppMethodBeat.o(58717);
    return true;
  }
  
  public static final class a
    extends i.b<a.m, a>
    implements n
  {
    private int aaZS;
    private List<a.r> abal;
    private List<Integer> abaz;
    private a.t abbL;
    private int abbM;
    private int abbN;
    private int abbb;
    private int abbo;
    private a.p abbp;
    private int abbq;
    private a.p abbr;
    private int abbs;
    private int bQS;
    
    private a()
    {
      AppMethodBeat.i(58693);
      this.aaZS = 518;
      this.abbo = 2054;
      this.abbp = a.p.iLm();
      this.abal = Collections.emptyList();
      this.abbr = a.p.iLm();
      this.abbL = a.t.iMh();
      this.abaz = Collections.emptyList();
      AppMethodBeat.o(58693);
    }
    
    private a a(a.t paramt)
    {
      AppMethodBeat.i(58702);
      if (((this.bQS & 0x100) == 256) && (this.abbL != a.t.iMh())) {}
      for (this.abbL = a.t.b(this.abbL).d(paramt).iMl();; this.abbL = paramt)
      {
        this.bQS |= 0x100;
        AppMethodBeat.o(58702);
        return this;
      }
    }
    
    private a aEp(int paramInt)
    {
      this.bQS |= 0x1;
      this.aaZS = paramInt;
      return this;
    }
    
    private a aEq(int paramInt)
    {
      this.bQS |= 0x2;
      this.abbo = paramInt;
      return this;
    }
    
    private a aEr(int paramInt)
    {
      this.bQS |= 0x4;
      this.abbb = paramInt;
      return this;
    }
    
    private a aEs(int paramInt)
    {
      this.bQS |= 0x10;
      this.abbq = paramInt;
      return this;
    }
    
    private a aEt(int paramInt)
    {
      this.bQS |= 0x80;
      this.abbs = paramInt;
      return this;
    }
    
    private a aEu(int paramInt)
    {
      this.bQS |= 0x200;
      this.abbM = paramInt;
      return this;
    }
    
    private a aEv(int paramInt)
    {
      this.bQS |= 0x400;
      this.abbN = paramInt;
      return this;
    }
    
    private a d(a.p paramp)
    {
      AppMethodBeat.i(58699);
      if (((this.bQS & 0x8) == 8) && (this.abbp != a.p.iLm())) {}
      for (this.abbp = a.p.f(this.abbp).j(paramp).iLI();; this.abbp = paramp)
      {
        this.bQS |= 0x8;
        AppMethodBeat.o(58699);
        return this;
      }
    }
    
    private a e(a.p paramp)
    {
      AppMethodBeat.i(58701);
      if (((this.bQS & 0x40) == 64) && (this.abbr != a.p.iLm())) {}
      for (this.abbr = a.p.f(this.abbr).j(paramp).iLI();; this.abbr = paramp)
      {
        this.bQS |= 0x40;
        AppMethodBeat.o(58701);
        return this;
      }
    }
    
    private void iJJ()
    {
      AppMethodBeat.i(58703);
      if ((this.bQS & 0x800) != 2048)
      {
        this.abaz = new ArrayList(this.abaz);
        this.bQS |= 0x800;
      }
      AppMethodBeat.o(58703);
    }
    
    private void iJz()
    {
      AppMethodBeat.i(58700);
      if ((this.bQS & 0x20) != 32)
      {
        this.abal = new ArrayList(this.abal);
        this.bQS |= 0x20;
      }
      AppMethodBeat.o(58700);
    }
    
    private a iKT()
    {
      AppMethodBeat.i(58694);
      a locala = new a().d(iKU());
      AppMethodBeat.o(58694);
      return locala;
    }
    
    private a.m iKU()
    {
      int j = 1;
      AppMethodBeat.i(58695);
      a.m localm = new a.m(this, (byte)0);
      int k = this.bQS;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.m.a(localm, this.aaZS);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.m.b(localm, this.abbo);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.m.c(localm, this.abbb);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.m.a(localm, this.abbp);
        j = i;
        if ((k & 0x10) == 16) {
          j = i | 0x10;
        }
        a.m.d(localm, this.abbq);
        if ((this.bQS & 0x20) == 32)
        {
          this.abal = Collections.unmodifiableList(this.abal);
          this.bQS &= 0xFFFFFFDF;
        }
        a.m.a(localm, this.abal);
        i = j;
        if ((k & 0x40) == 64) {
          i = j | 0x20;
        }
        a.m.b(localm, this.abbr);
        j = i;
        if ((k & 0x80) == 128) {
          j = i | 0x40;
        }
        a.m.e(localm, this.abbs);
        i = j;
        if ((k & 0x100) == 256) {
          i = j | 0x80;
        }
        a.m.a(localm, this.abbL);
        j = i;
        if ((k & 0x200) == 512) {
          j = i | 0x100;
        }
        a.m.f(localm, this.abbM);
        i = j;
        if ((k & 0x400) == 1024) {
          i = j | 0x200;
        }
        a.m.g(localm, this.abbN);
        if ((this.bQS & 0x800) == 2048)
        {
          this.abaz = Collections.unmodifiableList(this.abaz);
          this.bQS &= 0xFFFFF7FF;
        }
        a.m.b(localm, this.abaz);
        a.m.h(localm, i);
        AppMethodBeat.o(58695);
        return localm;
        j = 0;
      }
    }
    
    /* Error */
    private a p(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 197
      //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 201	kotlin/l/b/a/b/e/a$m:aaZC	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 206 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$m
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 149	kotlin/l/b/a/b/e/a$m$a:d	(Lkotlin/l/b/a/b/e/a$m;)Lkotlin/l/b/a/b/e/a$m$a;
      //   26: pop
      //   27: ldc 197
      //   29: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 210	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
      //   39: checkcast 9	kotlin/l/b/a/b/e/a$m
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
      //   57: invokevirtual 149	kotlin/l/b/a/b/e/a$m$a:d	(Lkotlin/l/b/a/b/e/a$m;)Lkotlin/l/b/a/b/e/a$m$a;
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
    
    public final a d(a.m paramm)
    {
      AppMethodBeat.i(58696);
      if (paramm == a.m.iKP())
      {
        AppMethodBeat.o(58696);
        return this;
      }
      if (paramm.iJj()) {
        aEp(paramm.aaZS);
      }
      if (paramm.iKu()) {
        aEq(paramm.abbo);
      }
      if (paramm.Cc()) {
        aEr(paramm.abbb);
      }
      if (paramm.iKv()) {
        d(paramm.abbp);
      }
      if (paramm.iKw()) {
        aEs(paramm.abbq);
      }
      if (!a.m.a(paramm).isEmpty())
      {
        if (this.abal.isEmpty())
        {
          this.abal = a.m.a(paramm);
          this.bQS &= 0xFFFFFFDF;
        }
      }
      else
      {
        if (paramm.iKx()) {
          e(paramm.abbr);
        }
        if (paramm.iKy()) {
          aEt(paramm.abbs);
        }
        if (paramm.iKQ()) {
          a(paramm.abbL);
        }
        if (paramm.iKR()) {
          aEu(paramm.abbM);
        }
        if (paramm.iKS()) {
          aEv(paramm.abbN);
        }
        if (!a.m.b(paramm).isEmpty())
        {
          if (!this.abaz.isEmpty()) {
            break label314;
          }
          this.abaz = a.m.b(paramm);
          this.bQS &= 0xFFFFF7FF;
        }
      }
      for (;;)
      {
        a(paramm);
        this.aaZB = this.aaZB.a(a.m.c(paramm));
        AppMethodBeat.o(58696);
        return this;
        iJz();
        this.abal.addAll(a.m.a(paramm));
        break;
        label314:
        iJJ();
        this.abaz.addAll(a.m.b(paramm));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58697);
      if ((this.bQS & 0x4) == 4) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58697);
        return false;
      }
      if ((this.bQS & 0x8) == 8) {}
      for (i = 1; (i != 0) && (!this.abbp.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58697);
        return false;
      }
      i = 0;
      while (i < this.abal.size())
      {
        if (!((a.r)this.abal.get(i)).isInitialized())
        {
          AppMethodBeat.o(58697);
          return false;
        }
        i += 1;
      }
      if ((this.bQS & 0x40) == 64) {}
      for (i = 1; (i != 0) && (!this.abbr.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58697);
        return false;
      }
      if ((this.bQS & 0x100) == 256) {}
      for (i = 1; (i != 0) && (!this.abbL.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58697);
        return false;
      }
      if (!Ig())
      {
        AppMethodBeat.o(58697);
        return false;
      }
      AppMethodBeat.o(58697);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.m
 * JD-Core Version:    0.7.0.1
 */