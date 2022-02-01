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

public final class a$h
  extends i.c<h>
  implements k
{
  public static s<h> NjZ;
  private static final h NlO;
  private final d NjY;
  public List<a.r> NkM;
  public a.s NkZ;
  private int Nka;
  private byte Nkd = -1;
  private int Nke = -1;
  public int Nkt;
  public int NlC;
  public int NlP;
  public a.p NlQ;
  public int NlR;
  public a.p NlS;
  public int NlT;
  a.d NlU;
  public List<Integer> Nla;
  public List<a.t> Nll;
  
  static
  {
    AppMethodBeat.i(58618);
    NjZ = new b() {};
    h localh = new h();
    NlO = localh;
    localh.gmq();
    AppMethodBeat.o(58618);
  }
  
  private a$h()
  {
    this.NjY = d.NqI;
  }
  
  /* Error */
  private a$h(d.l.b.a.b.h.e parame, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 71	d/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 88
    //   6: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 73	d/l/b/a/b/e/a$h:Nkd	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 75	d/l/b/a/b/e/a$h:Nke	I
    //   19: aload_0
    //   20: invokespecial 66	d/l/b/a/b/e/a$h:gmq	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 92	d/l/b/a/b/h/d:grr	()Ld/l/b/a/b/h/d$b;
    //   28: astore 11
    //   30: aload 11
    //   32: iconst_1
    //   33: invokestatic 98	d/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Ld/l/b/a/b/h/f;
    //   36: astore 12
    //   38: iconst_0
    //   39: istore 8
    //   41: iload 8
    //   43: ifne +1427 -> 1470
    //   46: iload_3
    //   47: istore 5
    //   49: iload_3
    //   50: istore 4
    //   52: iload_3
    //   53: istore 6
    //   55: aload_1
    //   56: invokevirtual 104	d/l/b/a/b/h/e:zb	()I
    //   59: istore 7
    //   61: iload 7
    //   63: lookupswitch	default:+1582->1645, 0:+1585->1648, 8:+149->212, 16:+309->372, 26:+389->452, 34:+517->580, 42:+591->654, 50:+719->782, 56:+796->859, 64:+836->899, 72:+876->939, 242:+915->978, 248:+1046->1109, 250:+1122->1185, 258:+1276->1339
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
    //   200: invokevirtual 107	d/l/b/a/b/e/a$h:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/f;Ld/l/b/a/b/h/g;I)Z
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
    //   223: getfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   226: iconst_2
    //   227: ior
    //   228: putfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   231: iload_3
    //   232: istore 5
    //   234: iload_3
    //   235: istore 4
    //   237: iload_3
    //   238: istore 6
    //   240: aload_0
    //   241: aload_1
    //   242: invokevirtual 112	d/l/b/a/b/h/e:zc	()I
    //   245: putfield 114	d/l/b/a/b/e/a$h:NlP	I
    //   248: goto -207 -> 41
    //   251: astore_1
    //   252: iload 5
    //   254: istore 4
    //   256: aload_1
    //   257: aload_0
    //   258: putfield 118	d/l/b/a/b/h/k:Nrq	Ld/l/b/a/b/h/q;
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
    //   289: getfield 120	d/l/b/a/b/e/a$h:NkM	Ljava/util/List;
    //   292: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   295: putfield 120	d/l/b/a/b/e/a$h:NkM	Ljava/util/List;
    //   298: iload 4
    //   300: sipush 256
    //   303: iand
    //   304: sipush 256
    //   307: if_icmpne +14 -> 321
    //   310: aload_0
    //   311: aload_0
    //   312: getfield 128	d/l/b/a/b/e/a$h:Nll	Ljava/util/List;
    //   315: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   318: putfield 128	d/l/b/a/b/e/a$h:Nll	Ljava/util/List;
    //   321: iload 4
    //   323: sipush 1024
    //   326: iand
    //   327: sipush 1024
    //   330: if_icmpne +14 -> 344
    //   333: aload_0
    //   334: aload_0
    //   335: getfield 130	d/l/b/a/b/e/a$h:Nla	Ljava/util/List;
    //   338: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   341: putfield 130	d/l/b/a/b/e/a$h:Nla	Ljava/util/List;
    //   344: aload 12
    //   346: invokevirtual 133	d/l/b/a/b/h/f:flush	()V
    //   349: aload_0
    //   350: aload 11
    //   352: invokevirtual 139	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   355: putfield 82	d/l/b/a/b/e/a$h:NjY	Ld/l/b/a/b/h/d;
    //   358: aload_0
    //   359: getfield 143	d/l/b/a/b/h/i$c:Nra	Ld/l/b/a/b/h/h;
    //   362: invokevirtual 148	d/l/b/a/b/h/h:grH	()V
    //   365: ldc 88
    //   367: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   370: aload_1
    //   371: athrow
    //   372: iload_3
    //   373: istore 5
    //   375: iload_3
    //   376: istore 4
    //   378: iload_3
    //   379: istore 6
    //   381: aload_0
    //   382: aload_0
    //   383: getfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   386: iconst_4
    //   387: ior
    //   388: putfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   391: iload_3
    //   392: istore 5
    //   394: iload_3
    //   395: istore 4
    //   397: iload_3
    //   398: istore 6
    //   400: aload_0
    //   401: aload_1
    //   402: invokevirtual 112	d/l/b/a/b/h/e:zc	()I
    //   405: putfield 150	d/l/b/a/b/e/a$h:NlC	I
    //   408: goto -367 -> 41
    //   411: astore_1
    //   412: iload 6
    //   414: istore 4
    //   416: new 85	d/l/b/a/b/h/k
    //   419: dup
    //   420: aload_1
    //   421: invokevirtual 154	java/io/IOException:getMessage	()Ljava/lang/String;
    //   424: invokespecial 157	d/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   427: astore_1
    //   428: iload 6
    //   430: istore 4
    //   432: aload_1
    //   433: aload_0
    //   434: putfield 118	d/l/b/a/b/h/k:Nrq	Ld/l/b/a/b/h/q;
    //   437: iload 6
    //   439: istore 4
    //   441: ldc 88
    //   443: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: iload 6
    //   448: istore 4
    //   450: aload_1
    //   451: athrow
    //   452: iload_3
    //   453: istore 5
    //   455: iload_3
    //   456: istore 4
    //   458: iload_3
    //   459: istore 6
    //   461: aload_0
    //   462: getfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   465: bipush 8
    //   467: iand
    //   468: bipush 8
    //   470: if_icmpne +1169 -> 1639
    //   473: iload_3
    //   474: istore 5
    //   476: iload_3
    //   477: istore 4
    //   479: iload_3
    //   480: istore 6
    //   482: aload_0
    //   483: getfield 159	d/l/b/a/b/e/a$h:NlQ	Ld/l/b/a/b/e/a$p;
    //   486: invokestatic 164	d/l/b/a/b/e/a$p:f	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   489: astore 10
    //   491: iload_3
    //   492: istore 5
    //   494: iload_3
    //   495: istore 4
    //   497: iload_3
    //   498: istore 6
    //   500: aload_0
    //   501: aload_1
    //   502: getstatic 165	d/l/b/a/b/e/a$p:NjZ	Ld/l/b/a/b/h/s;
    //   505: aload_2
    //   506: invokevirtual 168	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   509: checkcast 161	d/l/b/a/b/e/a$p
    //   512: putfield 159	d/l/b/a/b/e/a$h:NlQ	Ld/l/b/a/b/e/a$p;
    //   515: aload 10
    //   517: ifnull +40 -> 557
    //   520: iload_3
    //   521: istore 5
    //   523: iload_3
    //   524: istore 4
    //   526: iload_3
    //   527: istore 6
    //   529: aload 10
    //   531: aload_0
    //   532: getfield 159	d/l/b/a/b/e/a$h:NlQ	Ld/l/b/a/b/e/a$p;
    //   535: invokevirtual 173	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   538: pop
    //   539: iload_3
    //   540: istore 5
    //   542: iload_3
    //   543: istore 4
    //   545: iload_3
    //   546: istore 6
    //   548: aload_0
    //   549: aload 10
    //   551: invokevirtual 177	d/l/b/a/b/e/a$p$b:gpp	()Ld/l/b/a/b/e/a$p;
    //   554: putfield 159	d/l/b/a/b/e/a$h:NlQ	Ld/l/b/a/b/e/a$p;
    //   557: iload_3
    //   558: istore 5
    //   560: iload_3
    //   561: istore 4
    //   563: iload_3
    //   564: istore 6
    //   566: aload_0
    //   567: aload_0
    //   568: getfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   571: bipush 8
    //   573: ior
    //   574: putfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   577: goto -536 -> 41
    //   580: iload_3
    //   581: istore 7
    //   583: iload_3
    //   584: bipush 32
    //   586: iand
    //   587: bipush 32
    //   589: if_icmpeq +29 -> 618
    //   592: iload_3
    //   593: istore 5
    //   595: iload_3
    //   596: istore 4
    //   598: iload_3
    //   599: istore 6
    //   601: aload_0
    //   602: new 179	java/util/ArrayList
    //   605: dup
    //   606: invokespecial 180	java/util/ArrayList:<init>	()V
    //   609: putfield 120	d/l/b/a/b/e/a$h:NkM	Ljava/util/List;
    //   612: iload_3
    //   613: bipush 32
    //   615: ior
    //   616: istore 7
    //   618: iload 7
    //   620: istore 5
    //   622: iload 7
    //   624: istore 4
    //   626: iload 7
    //   628: istore 6
    //   630: aload_0
    //   631: getfield 120	d/l/b/a/b/e/a$h:NkM	Ljava/util/List;
    //   634: aload_1
    //   635: getstatic 183	d/l/b/a/b/e/a$r:NjZ	Ld/l/b/a/b/h/s;
    //   638: aload_2
    //   639: invokevirtual 168	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   642: invokeinterface 189 2 0
    //   647: pop
    //   648: iload 7
    //   650: istore_3
    //   651: goto -610 -> 41
    //   654: iload_3
    //   655: istore 5
    //   657: iload_3
    //   658: istore 4
    //   660: iload_3
    //   661: istore 6
    //   663: aload_0
    //   664: getfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   667: bipush 32
    //   669: iand
    //   670: bipush 32
    //   672: if_icmpne +961 -> 1633
    //   675: iload_3
    //   676: istore 5
    //   678: iload_3
    //   679: istore 4
    //   681: iload_3
    //   682: istore 6
    //   684: aload_0
    //   685: getfield 191	d/l/b/a/b/e/a$h:NlS	Ld/l/b/a/b/e/a$p;
    //   688: invokestatic 164	d/l/b/a/b/e/a$p:f	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   691: astore 10
    //   693: iload_3
    //   694: istore 5
    //   696: iload_3
    //   697: istore 4
    //   699: iload_3
    //   700: istore 6
    //   702: aload_0
    //   703: aload_1
    //   704: getstatic 165	d/l/b/a/b/e/a$p:NjZ	Ld/l/b/a/b/h/s;
    //   707: aload_2
    //   708: invokevirtual 168	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   711: checkcast 161	d/l/b/a/b/e/a$p
    //   714: putfield 191	d/l/b/a/b/e/a$h:NlS	Ld/l/b/a/b/e/a$p;
    //   717: aload 10
    //   719: ifnull +40 -> 759
    //   722: iload_3
    //   723: istore 5
    //   725: iload_3
    //   726: istore 4
    //   728: iload_3
    //   729: istore 6
    //   731: aload 10
    //   733: aload_0
    //   734: getfield 191	d/l/b/a/b/e/a$h:NlS	Ld/l/b/a/b/e/a$p;
    //   737: invokevirtual 173	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   740: pop
    //   741: iload_3
    //   742: istore 5
    //   744: iload_3
    //   745: istore 4
    //   747: iload_3
    //   748: istore 6
    //   750: aload_0
    //   751: aload 10
    //   753: invokevirtual 177	d/l/b/a/b/e/a$p$b:gpp	()Ld/l/b/a/b/e/a$p;
    //   756: putfield 191	d/l/b/a/b/e/a$h:NlS	Ld/l/b/a/b/e/a$p;
    //   759: iload_3
    //   760: istore 5
    //   762: iload_3
    //   763: istore 4
    //   765: iload_3
    //   766: istore 6
    //   768: aload_0
    //   769: aload_0
    //   770: getfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   773: bipush 32
    //   775: ior
    //   776: putfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   779: goto -738 -> 41
    //   782: iload_3
    //   783: istore 7
    //   785: iload_3
    //   786: sipush 256
    //   789: iand
    //   790: sipush 256
    //   793: if_icmpeq +30 -> 823
    //   796: iload_3
    //   797: istore 5
    //   799: iload_3
    //   800: istore 4
    //   802: iload_3
    //   803: istore 6
    //   805: aload_0
    //   806: new 179	java/util/ArrayList
    //   809: dup
    //   810: invokespecial 180	java/util/ArrayList:<init>	()V
    //   813: putfield 128	d/l/b/a/b/e/a$h:Nll	Ljava/util/List;
    //   816: iload_3
    //   817: sipush 256
    //   820: ior
    //   821: istore 7
    //   823: iload 7
    //   825: istore 5
    //   827: iload 7
    //   829: istore 4
    //   831: iload 7
    //   833: istore 6
    //   835: aload_0
    //   836: getfield 128	d/l/b/a/b/e/a$h:Nll	Ljava/util/List;
    //   839: aload_1
    //   840: getstatic 194	d/l/b/a/b/e/a$t:NjZ	Ld/l/b/a/b/h/s;
    //   843: aload_2
    //   844: invokevirtual 168	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   847: invokeinterface 189 2 0
    //   852: pop
    //   853: iload 7
    //   855: istore_3
    //   856: goto -815 -> 41
    //   859: iload_3
    //   860: istore 5
    //   862: iload_3
    //   863: istore 4
    //   865: iload_3
    //   866: istore 6
    //   868: aload_0
    //   869: aload_0
    //   870: getfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   873: bipush 16
    //   875: ior
    //   876: putfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   879: iload_3
    //   880: istore 5
    //   882: iload_3
    //   883: istore 4
    //   885: iload_3
    //   886: istore 6
    //   888: aload_0
    //   889: aload_1
    //   890: invokevirtual 112	d/l/b/a/b/h/e:zc	()I
    //   893: putfield 196	d/l/b/a/b/e/a$h:NlR	I
    //   896: goto -855 -> 41
    //   899: iload_3
    //   900: istore 5
    //   902: iload_3
    //   903: istore 4
    //   905: iload_3
    //   906: istore 6
    //   908: aload_0
    //   909: aload_0
    //   910: getfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   913: bipush 64
    //   915: ior
    //   916: putfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   919: iload_3
    //   920: istore 5
    //   922: iload_3
    //   923: istore 4
    //   925: iload_3
    //   926: istore 6
    //   928: aload_0
    //   929: aload_1
    //   930: invokevirtual 112	d/l/b/a/b/h/e:zc	()I
    //   933: putfield 198	d/l/b/a/b/e/a$h:NlT	I
    //   936: goto -895 -> 41
    //   939: iload_3
    //   940: istore 5
    //   942: iload_3
    //   943: istore 4
    //   945: iload_3
    //   946: istore 6
    //   948: aload_0
    //   949: aload_0
    //   950: getfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   953: iconst_1
    //   954: ior
    //   955: putfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   958: iload_3
    //   959: istore 5
    //   961: iload_3
    //   962: istore 4
    //   964: iload_3
    //   965: istore 6
    //   967: aload_0
    //   968: aload_1
    //   969: invokevirtual 112	d/l/b/a/b/h/e:zc	()I
    //   972: putfield 200	d/l/b/a/b/e/a$h:Nkt	I
    //   975: goto -934 -> 41
    //   978: iload_3
    //   979: istore 5
    //   981: iload_3
    //   982: istore 4
    //   984: iload_3
    //   985: istore 6
    //   987: aload_0
    //   988: getfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   991: sipush 128
    //   994: iand
    //   995: sipush 128
    //   998: if_icmpne +629 -> 1627
    //   1001: iload_3
    //   1002: istore 5
    //   1004: iload_3
    //   1005: istore 4
    //   1007: iload_3
    //   1008: istore 6
    //   1010: aload_0
    //   1011: getfield 202	d/l/b/a/b/e/a$h:NkZ	Ld/l/b/a/b/e/a$s;
    //   1014: invokestatic 208	d/l/b/a/b/e/a$s:d	(Ld/l/b/a/b/e/a$s;)Ld/l/b/a/b/e/a$s$a;
    //   1017: astore 10
    //   1019: iload_3
    //   1020: istore 5
    //   1022: iload_3
    //   1023: istore 4
    //   1025: iload_3
    //   1026: istore 6
    //   1028: aload_0
    //   1029: aload_1
    //   1030: getstatic 209	d/l/b/a/b/e/a$s:NjZ	Ld/l/b/a/b/h/s;
    //   1033: aload_2
    //   1034: invokevirtual 168	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   1037: checkcast 204	d/l/b/a/b/e/a$s
    //   1040: putfield 202	d/l/b/a/b/e/a$h:NkZ	Ld/l/b/a/b/e/a$s;
    //   1043: aload 10
    //   1045: ifnull +40 -> 1085
    //   1048: iload_3
    //   1049: istore 5
    //   1051: iload_3
    //   1052: istore 4
    //   1054: iload_3
    //   1055: istore 6
    //   1057: aload 10
    //   1059: aload_0
    //   1060: getfield 202	d/l/b/a/b/e/a$h:NkZ	Ld/l/b/a/b/e/a$s;
    //   1063: invokevirtual 214	d/l/b/a/b/e/a$s$a:g	(Ld/l/b/a/b/e/a$s;)Ld/l/b/a/b/e/a$s$a;
    //   1066: pop
    //   1067: iload_3
    //   1068: istore 5
    //   1070: iload_3
    //   1071: istore 4
    //   1073: iload_3
    //   1074: istore 6
    //   1076: aload_0
    //   1077: aload 10
    //   1079: invokevirtual 218	d/l/b/a/b/e/a$s$a:gpL	()Ld/l/b/a/b/e/a$s;
    //   1082: putfield 202	d/l/b/a/b/e/a$h:NkZ	Ld/l/b/a/b/e/a$s;
    //   1085: iload_3
    //   1086: istore 5
    //   1088: iload_3
    //   1089: istore 4
    //   1091: iload_3
    //   1092: istore 6
    //   1094: aload_0
    //   1095: aload_0
    //   1096: getfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   1099: sipush 128
    //   1102: ior
    //   1103: putfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   1106: goto -1065 -> 41
    //   1109: iload_3
    //   1110: istore 7
    //   1112: iload_3
    //   1113: sipush 1024
    //   1116: iand
    //   1117: sipush 1024
    //   1120: if_icmpeq +30 -> 1150
    //   1123: iload_3
    //   1124: istore 5
    //   1126: iload_3
    //   1127: istore 4
    //   1129: iload_3
    //   1130: istore 6
    //   1132: aload_0
    //   1133: new 179	java/util/ArrayList
    //   1136: dup
    //   1137: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1140: putfield 130	d/l/b/a/b/e/a$h:Nla	Ljava/util/List;
    //   1143: iload_3
    //   1144: sipush 1024
    //   1147: ior
    //   1148: istore 7
    //   1150: iload 7
    //   1152: istore 5
    //   1154: iload 7
    //   1156: istore 4
    //   1158: iload 7
    //   1160: istore 6
    //   1162: aload_0
    //   1163: getfield 130	d/l/b/a/b/e/a$h:Nla	Ljava/util/List;
    //   1166: aload_1
    //   1167: invokevirtual 112	d/l/b/a/b/h/e:zc	()I
    //   1170: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1173: invokeinterface 189 2 0
    //   1178: pop
    //   1179: iload 7
    //   1181: istore_3
    //   1182: goto -1141 -> 41
    //   1185: iload_3
    //   1186: istore 5
    //   1188: iload_3
    //   1189: istore 4
    //   1191: iload_3
    //   1192: istore 6
    //   1194: aload_1
    //   1195: aload_1
    //   1196: invokevirtual 112	d/l/b/a/b/h/e:zc	()I
    //   1199: invokevirtual 228	d/l/b/a/b/h/e:fG	(I)I
    //   1202: istore 9
    //   1204: iload_3
    //   1205: istore 7
    //   1207: iload_3
    //   1208: sipush 1024
    //   1211: iand
    //   1212: sipush 1024
    //   1215: if_icmpeq +49 -> 1264
    //   1218: iload_3
    //   1219: istore 5
    //   1221: iload_3
    //   1222: istore 4
    //   1224: iload_3
    //   1225: istore 6
    //   1227: iload_3
    //   1228: istore 7
    //   1230: aload_1
    //   1231: invokevirtual 231	d/l/b/a/b/h/e:zf	()I
    //   1234: ifle +30 -> 1264
    //   1237: iload_3
    //   1238: istore 5
    //   1240: iload_3
    //   1241: istore 4
    //   1243: iload_3
    //   1244: istore 6
    //   1246: aload_0
    //   1247: new 179	java/util/ArrayList
    //   1250: dup
    //   1251: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1254: putfield 130	d/l/b/a/b/e/a$h:Nla	Ljava/util/List;
    //   1257: iload_3
    //   1258: sipush 1024
    //   1261: ior
    //   1262: istore 7
    //   1264: iload 7
    //   1266: istore 5
    //   1268: iload 7
    //   1270: istore 4
    //   1272: iload 7
    //   1274: istore 6
    //   1276: aload_1
    //   1277: invokevirtual 231	d/l/b/a/b/h/e:zf	()I
    //   1280: ifle +35 -> 1315
    //   1283: iload 7
    //   1285: istore 5
    //   1287: iload 7
    //   1289: istore 4
    //   1291: iload 7
    //   1293: istore 6
    //   1295: aload_0
    //   1296: getfield 130	d/l/b/a/b/e/a$h:Nla	Ljava/util/List;
    //   1299: aload_1
    //   1300: invokevirtual 112	d/l/b/a/b/h/e:zc	()I
    //   1303: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1306: invokeinterface 189 2 0
    //   1311: pop
    //   1312: goto -48 -> 1264
    //   1315: iload 7
    //   1317: istore 5
    //   1319: iload 7
    //   1321: istore 4
    //   1323: iload 7
    //   1325: istore 6
    //   1327: aload_1
    //   1328: iload 9
    //   1330: invokevirtual 234	d/l/b/a/b/h/e:fH	(I)V
    //   1333: iload 7
    //   1335: istore_3
    //   1336: goto -1295 -> 41
    //   1339: iload_3
    //   1340: istore 5
    //   1342: iload_3
    //   1343: istore 4
    //   1345: iload_3
    //   1346: istore 6
    //   1348: aload_0
    //   1349: getfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   1352: sipush 256
    //   1355: iand
    //   1356: sipush 256
    //   1359: if_icmpne +262 -> 1621
    //   1362: iload_3
    //   1363: istore 5
    //   1365: iload_3
    //   1366: istore 4
    //   1368: iload_3
    //   1369: istore 6
    //   1371: aload_0
    //   1372: getfield 236	d/l/b/a/b/e/a$h:NlU	Ld/l/b/a/b/e/a$d;
    //   1375: invokevirtual 242	d/l/b/a/b/e/a$d:gnx	()Ld/l/b/a/b/e/a$d$a;
    //   1378: astore 10
    //   1380: iload_3
    //   1381: istore 5
    //   1383: iload_3
    //   1384: istore 4
    //   1386: iload_3
    //   1387: istore 6
    //   1389: aload_0
    //   1390: aload_1
    //   1391: getstatic 243	d/l/b/a/b/e/a$d:NjZ	Ld/l/b/a/b/h/s;
    //   1394: aload_2
    //   1395: invokevirtual 168	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   1398: checkcast 238	d/l/b/a/b/e/a$d
    //   1401: putfield 236	d/l/b/a/b/e/a$h:NlU	Ld/l/b/a/b/e/a$d;
    //   1404: aload 10
    //   1406: ifnull +40 -> 1446
    //   1409: iload_3
    //   1410: istore 5
    //   1412: iload_3
    //   1413: istore 4
    //   1415: iload_3
    //   1416: istore 6
    //   1418: aload 10
    //   1420: aload_0
    //   1421: getfield 236	d/l/b/a/b/e/a$h:NlU	Ld/l/b/a/b/e/a$d;
    //   1424: invokevirtual 248	d/l/b/a/b/e/a$d$a:d	(Ld/l/b/a/b/e/a$d;)Ld/l/b/a/b/e/a$d$a;
    //   1427: pop
    //   1428: iload_3
    //   1429: istore 5
    //   1431: iload_3
    //   1432: istore 4
    //   1434: iload_3
    //   1435: istore 6
    //   1437: aload_0
    //   1438: aload 10
    //   1440: invokevirtual 252	d/l/b/a/b/e/a$d$a:gnz	()Ld/l/b/a/b/e/a$d;
    //   1443: putfield 236	d/l/b/a/b/e/a$h:NlU	Ld/l/b/a/b/e/a$d;
    //   1446: iload_3
    //   1447: istore 5
    //   1449: iload_3
    //   1450: istore 4
    //   1452: iload_3
    //   1453: istore 6
    //   1455: aload_0
    //   1456: aload_0
    //   1457: getfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   1460: sipush 256
    //   1463: ior
    //   1464: putfield 109	d/l/b/a/b/e/a$h:Nka	I
    //   1467: goto -1426 -> 41
    //   1470: iload_3
    //   1471: bipush 32
    //   1473: iand
    //   1474: bipush 32
    //   1476: if_icmpne +14 -> 1490
    //   1479: aload_0
    //   1480: aload_0
    //   1481: getfield 120	d/l/b/a/b/e/a$h:NkM	Ljava/util/List;
    //   1484: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1487: putfield 120	d/l/b/a/b/e/a$h:NkM	Ljava/util/List;
    //   1490: iload_3
    //   1491: sipush 256
    //   1494: iand
    //   1495: sipush 256
    //   1498: if_icmpne +14 -> 1512
    //   1501: aload_0
    //   1502: aload_0
    //   1503: getfield 128	d/l/b/a/b/e/a$h:Nll	Ljava/util/List;
    //   1506: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1509: putfield 128	d/l/b/a/b/e/a$h:Nll	Ljava/util/List;
    //   1512: iload_3
    //   1513: sipush 1024
    //   1516: iand
    //   1517: sipush 1024
    //   1520: if_icmpne +14 -> 1534
    //   1523: aload_0
    //   1524: aload_0
    //   1525: getfield 130	d/l/b/a/b/e/a$h:Nla	Ljava/util/List;
    //   1528: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1531: putfield 130	d/l/b/a/b/e/a$h:Nla	Ljava/util/List;
    //   1534: aload 12
    //   1536: invokevirtual 133	d/l/b/a/b/h/f:flush	()V
    //   1539: aload_0
    //   1540: aload 11
    //   1542: invokevirtual 139	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   1545: putfield 82	d/l/b/a/b/e/a$h:NjY	Ld/l/b/a/b/h/d;
    //   1548: aload_0
    //   1549: getfield 143	d/l/b/a/b/h/i$c:Nra	Ld/l/b/a/b/h/h;
    //   1552: invokevirtual 148	d/l/b/a/b/h/h:grH	()V
    //   1555: ldc 88
    //   1557: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1560: return
    //   1561: astore_1
    //   1562: aload_0
    //   1563: aload 11
    //   1565: invokevirtual 139	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   1568: putfield 82	d/l/b/a/b/e/a$h:NjY	Ld/l/b/a/b/h/d;
    //   1571: goto -23 -> 1548
    //   1574: astore_1
    //   1575: aload_0
    //   1576: aload 11
    //   1578: invokevirtual 139	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   1581: putfield 82	d/l/b/a/b/e/a$h:NjY	Ld/l/b/a/b/h/d;
    //   1584: ldc 88
    //   1586: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1589: aload_1
    //   1590: athrow
    //   1591: astore_2
    //   1592: aload_0
    //   1593: aload 11
    //   1595: invokevirtual 139	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   1598: putfield 82	d/l/b/a/b/e/a$h:NjY	Ld/l/b/a/b/h/d;
    //   1601: goto -1243 -> 358
    //   1604: astore_1
    //   1605: aload_0
    //   1606: aload 11
    //   1608: invokevirtual 139	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   1611: putfield 82	d/l/b/a/b/e/a$h:NjY	Ld/l/b/a/b/h/d;
    //   1614: ldc 88
    //   1616: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1619: aload_1
    //   1620: athrow
    //   1621: aconst_null
    //   1622: astore 10
    //   1624: goto -244 -> 1380
    //   1627: aconst_null
    //   1628: astore 10
    //   1630: goto -611 -> 1019
    //   1633: aconst_null
    //   1634: astore 10
    //   1636: goto -943 -> 693
    //   1639: aconst_null
    //   1640: astore 10
    //   1642: goto -1151 -> 491
    //   1645: goto -1461 -> 184
    //   1648: iconst_1
    //   1649: istore 8
    //   1651: goto -1610 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1654	0	this	h
    //   0	1654	1	parame	d.l.b.a.b.h.e
    //   0	1654	2	paramg	g
    //   24	1493	3	i	int
    //   50	1401	4	j	int
    //   47	1401	5	k	int
    //   53	1401	6	m	int
    //   59	1275	7	n	int
    //   39	1611	8	i1	int
    //   1202	127	9	i2	int
    //   489	1152	10	localObject	java.lang.Object
    //   28	1579	11	localb	d.l.b.a.b.h.d.b
    //   36	1499	12	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	251	d/l/b/a/b/h/k
    //   193	206	251	d/l/b/a/b/h/k
    //   221	231	251	d/l/b/a/b/h/k
    //   240	248	251	d/l/b/a/b/h/k
    //   381	391	251	d/l/b/a/b/h/k
    //   400	408	251	d/l/b/a/b/h/k
    //   461	473	251	d/l/b/a/b/h/k
    //   482	491	251	d/l/b/a/b/h/k
    //   500	515	251	d/l/b/a/b/h/k
    //   529	539	251	d/l/b/a/b/h/k
    //   548	557	251	d/l/b/a/b/h/k
    //   566	577	251	d/l/b/a/b/h/k
    //   601	612	251	d/l/b/a/b/h/k
    //   630	648	251	d/l/b/a/b/h/k
    //   663	675	251	d/l/b/a/b/h/k
    //   684	693	251	d/l/b/a/b/h/k
    //   702	717	251	d/l/b/a/b/h/k
    //   731	741	251	d/l/b/a/b/h/k
    //   750	759	251	d/l/b/a/b/h/k
    //   768	779	251	d/l/b/a/b/h/k
    //   805	816	251	d/l/b/a/b/h/k
    //   835	853	251	d/l/b/a/b/h/k
    //   868	879	251	d/l/b/a/b/h/k
    //   888	896	251	d/l/b/a/b/h/k
    //   908	919	251	d/l/b/a/b/h/k
    //   928	936	251	d/l/b/a/b/h/k
    //   948	958	251	d/l/b/a/b/h/k
    //   967	975	251	d/l/b/a/b/h/k
    //   987	1001	251	d/l/b/a/b/h/k
    //   1010	1019	251	d/l/b/a/b/h/k
    //   1028	1043	251	d/l/b/a/b/h/k
    //   1057	1067	251	d/l/b/a/b/h/k
    //   1076	1085	251	d/l/b/a/b/h/k
    //   1094	1106	251	d/l/b/a/b/h/k
    //   1132	1143	251	d/l/b/a/b/h/k
    //   1162	1179	251	d/l/b/a/b/h/k
    //   1194	1204	251	d/l/b/a/b/h/k
    //   1230	1237	251	d/l/b/a/b/h/k
    //   1246	1257	251	d/l/b/a/b/h/k
    //   1276	1283	251	d/l/b/a/b/h/k
    //   1295	1312	251	d/l/b/a/b/h/k
    //   1327	1333	251	d/l/b/a/b/h/k
    //   1348	1362	251	d/l/b/a/b/h/k
    //   1371	1380	251	d/l/b/a/b/h/k
    //   1389	1404	251	d/l/b/a/b/h/k
    //   1418	1428	251	d/l/b/a/b/h/k
    //   1437	1446	251	d/l/b/a/b/h/k
    //   1455	1467	251	d/l/b/a/b/h/k
    //   55	61	276	finally
    //   193	206	276	finally
    //   221	231	276	finally
    //   240	248	276	finally
    //   256	261	276	finally
    //   265	270	276	finally
    //   274	276	276	finally
    //   381	391	276	finally
    //   400	408	276	finally
    //   416	428	276	finally
    //   432	437	276	finally
    //   441	446	276	finally
    //   450	452	276	finally
    //   461	473	276	finally
    //   482	491	276	finally
    //   500	515	276	finally
    //   529	539	276	finally
    //   548	557	276	finally
    //   566	577	276	finally
    //   601	612	276	finally
    //   630	648	276	finally
    //   663	675	276	finally
    //   684	693	276	finally
    //   702	717	276	finally
    //   731	741	276	finally
    //   750	759	276	finally
    //   768	779	276	finally
    //   805	816	276	finally
    //   835	853	276	finally
    //   868	879	276	finally
    //   888	896	276	finally
    //   908	919	276	finally
    //   928	936	276	finally
    //   948	958	276	finally
    //   967	975	276	finally
    //   987	1001	276	finally
    //   1010	1019	276	finally
    //   1028	1043	276	finally
    //   1057	1067	276	finally
    //   1076	1085	276	finally
    //   1094	1106	276	finally
    //   1132	1143	276	finally
    //   1162	1179	276	finally
    //   1194	1204	276	finally
    //   1230	1237	276	finally
    //   1246	1257	276	finally
    //   1276	1283	276	finally
    //   1295	1312	276	finally
    //   1327	1333	276	finally
    //   1348	1362	276	finally
    //   1371	1380	276	finally
    //   1389	1404	276	finally
    //   1418	1428	276	finally
    //   1437	1446	276	finally
    //   1455	1467	276	finally
    //   55	61	411	java/io/IOException
    //   193	206	411	java/io/IOException
    //   221	231	411	java/io/IOException
    //   240	248	411	java/io/IOException
    //   381	391	411	java/io/IOException
    //   400	408	411	java/io/IOException
    //   461	473	411	java/io/IOException
    //   482	491	411	java/io/IOException
    //   500	515	411	java/io/IOException
    //   529	539	411	java/io/IOException
    //   548	557	411	java/io/IOException
    //   566	577	411	java/io/IOException
    //   601	612	411	java/io/IOException
    //   630	648	411	java/io/IOException
    //   663	675	411	java/io/IOException
    //   684	693	411	java/io/IOException
    //   702	717	411	java/io/IOException
    //   731	741	411	java/io/IOException
    //   750	759	411	java/io/IOException
    //   768	779	411	java/io/IOException
    //   805	816	411	java/io/IOException
    //   835	853	411	java/io/IOException
    //   868	879	411	java/io/IOException
    //   888	896	411	java/io/IOException
    //   908	919	411	java/io/IOException
    //   928	936	411	java/io/IOException
    //   948	958	411	java/io/IOException
    //   967	975	411	java/io/IOException
    //   987	1001	411	java/io/IOException
    //   1010	1019	411	java/io/IOException
    //   1028	1043	411	java/io/IOException
    //   1057	1067	411	java/io/IOException
    //   1076	1085	411	java/io/IOException
    //   1094	1106	411	java/io/IOException
    //   1132	1143	411	java/io/IOException
    //   1162	1179	411	java/io/IOException
    //   1194	1204	411	java/io/IOException
    //   1230	1237	411	java/io/IOException
    //   1246	1257	411	java/io/IOException
    //   1276	1283	411	java/io/IOException
    //   1295	1312	411	java/io/IOException
    //   1327	1333	411	java/io/IOException
    //   1348	1362	411	java/io/IOException
    //   1371	1380	411	java/io/IOException
    //   1389	1404	411	java/io/IOException
    //   1418	1428	411	java/io/IOException
    //   1437	1446	411	java/io/IOException
    //   1455	1467	411	java/io/IOException
    //   1534	1539	1561	java/io/IOException
    //   1534	1539	1574	finally
    //   344	349	1591	java/io/IOException
    //   344	349	1604	finally
  }
  
  private a$h(i.b<h, ?> paramb)
  {
    super(paramb);
    this.NjY = paramb.NjY;
  }
  
  public static h b(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(58615);
    paramInputStream = (h)NjZ.j(paramInputStream, paramg);
    AppMethodBeat.o(58615);
    return paramInputStream;
  }
  
  private void gmq()
  {
    AppMethodBeat.i(58611);
    this.Nkt = 6;
    this.NlP = 6;
    this.NlC = 0;
    this.NlQ = a.p.goT();
    this.NlR = 0;
    this.NkM = Collections.emptyList();
    this.NlS = a.p.goT();
    this.NlT = 0;
    this.Nll = Collections.emptyList();
    this.NkZ = a.s.gpI();
    this.Nla = Collections.emptyList();
    this.NlU = a.d.gnw();
    AppMethodBeat.o(58611);
  }
  
  public static h gnZ()
  {
    return NlO;
  }
  
  public final void a(f paramf)
  {
    int j = 0;
    AppMethodBeat.i(58613);
    zp();
    i.c.a locala = grO();
    if ((this.Nka & 0x2) == 2) {
      paramf.bx(1, this.NlP);
    }
    if ((this.Nka & 0x4) == 4) {
      paramf.bx(2, this.NlC);
    }
    if ((this.Nka & 0x8) == 8) {
      paramf.a(3, this.NlQ);
    }
    int i = 0;
    while (i < this.NkM.size())
    {
      paramf.a(4, (q)this.NkM.get(i));
      i += 1;
    }
    if ((this.Nka & 0x20) == 32) {
      paramf.a(5, this.NlS);
    }
    i = 0;
    while (i < this.Nll.size())
    {
      paramf.a(6, (q)this.Nll.get(i));
      i += 1;
    }
    if ((this.Nka & 0x10) == 16) {
      paramf.bx(7, this.NlR);
    }
    if ((this.Nka & 0x40) == 64) {
      paramf.bx(8, this.NlT);
    }
    if ((this.Nka & 0x1) == 1) {
      paramf.bx(9, this.Nkt);
    }
    i = j;
    if ((this.Nka & 0x80) == 128)
    {
      paramf.a(30, this.NkZ);
      i = j;
    }
    while (i < this.Nla.size())
    {
      paramf.bx(31, ((Integer)this.Nla.get(i)).intValue());
      i += 1;
    }
    if ((this.Nka & 0x100) == 256) {
      paramf.a(32, this.NlU);
    }
    locala.b(19000, paramf);
    paramf.e(this.NjY);
    AppMethodBeat.o(58613);
  }
  
  public final boolean gmO()
  {
    return (this.Nka & 0x1) == 1;
  }
  
  public final s<h> gmo()
  {
    return NjZ;
  }
  
  public final boolean gnL()
  {
    return (this.Nka & 0x4) == 4;
  }
  
  public final boolean gna()
  {
    return (this.Nka & 0x80) == 128;
  }
  
  public final boolean goa()
  {
    return (this.Nka & 0x2) == 2;
  }
  
  public final boolean gob()
  {
    return (this.Nka & 0x8) == 8;
  }
  
  public final boolean goc()
  {
    return (this.Nka & 0x10) == 16;
  }
  
  public final boolean god()
  {
    return (this.Nka & 0x20) == 32;
  }
  
  public final boolean goe()
  {
    return (this.Nka & 0x40) == 64;
  }
  
  public final boolean gof()
  {
    return (this.Nka & 0x100) == 256;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58612);
    int i = this.Nkd;
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
    if (!gnL())
    {
      this.Nkd = 0;
      AppMethodBeat.o(58612);
      return false;
    }
    if ((gob()) && (!this.NlQ.isInitialized()))
    {
      this.Nkd = 0;
      AppMethodBeat.o(58612);
      return false;
    }
    i = 0;
    while (i < this.NkM.size())
    {
      if (!((a.r)this.NkM.get(i)).isInitialized())
      {
        this.Nkd = 0;
        AppMethodBeat.o(58612);
        return false;
      }
      i += 1;
    }
    if ((god()) && (!this.NlS.isInitialized()))
    {
      this.Nkd = 0;
      AppMethodBeat.o(58612);
      return false;
    }
    i = 0;
    while (i < this.Nll.size())
    {
      if (!((a.t)this.Nll.get(i)).isInitialized())
      {
        this.Nkd = 0;
        AppMethodBeat.o(58612);
        return false;
      }
      i += 1;
    }
    if ((gna()) && (!this.NkZ.isInitialized()))
    {
      this.Nkd = 0;
      AppMethodBeat.o(58612);
      return false;
    }
    if ((gof()) && (!this.NlU.isInitialized()))
    {
      this.Nkd = 0;
      AppMethodBeat.o(58612);
      return false;
    }
    if (!this.Nra.isInitialized())
    {
      this.Nkd = 0;
      AppMethodBeat.o(58612);
      return false;
    }
    this.Nkd = 1;
    AppMethodBeat.o(58612);
    return true;
  }
  
  public final int zp()
  {
    AppMethodBeat.i(58614);
    int i = this.Nke;
    if (i != -1)
    {
      AppMethodBeat.o(58614);
      return i;
    }
    if ((this.Nka & 0x2) == 2) {}
    for (int j = f.bz(1, this.NlP) + 0;; j = 0)
    {
      i = j;
      if ((this.Nka & 0x4) == 4) {
        i = j + f.bz(2, this.NlC);
      }
      j = i;
      if ((this.Nka & 0x8) == 8) {
        j = i + f.c(3, this.NlQ);
      }
      int k = 0;
      i = j;
      j = k;
      while (j < this.NkM.size())
      {
        i += f.c(4, (q)this.NkM.get(j));
        j += 1;
      }
      j = i;
      if ((this.Nka & 0x20) == 32) {
        j = i + f.c(5, this.NlS);
      }
      k = 0;
      i = j;
      j = k;
      while (j < this.Nll.size())
      {
        i += f.c(6, (q)this.Nll.get(j));
        j += 1;
      }
      j = i;
      if ((this.Nka & 0x10) == 16) {
        j = i + f.bz(7, this.NlR);
      }
      i = j;
      if ((this.Nka & 0x40) == 64) {
        i = j + f.bz(8, this.NlT);
      }
      j = i;
      if ((this.Nka & 0x1) == 1) {
        j = i + f.bz(9, this.Nkt);
      }
      i = j;
      if ((this.Nka & 0x80) == 128) {
        i = j + f.c(30, this.NkZ);
      }
      k = 0;
      int m;
      for (j = 0; k < this.Nla.size(); j = m + j)
      {
        m = f.fL(((Integer)this.Nla.get(k)).intValue());
        k += 1;
      }
      j = i + j + this.Nla.size() * 2;
      i = j;
      if ((this.Nka & 0x100) == 256) {
        i = j + f.c(32, this.NlU);
      }
      i = i + this.Nra.zp() + this.NjY.size();
      this.Nke = i;
      AppMethodBeat.o(58614);
      return i;
    }
  }
  
  public static final class a
    extends i.b<a.h, a>
    implements k
  {
    private List<a.r> NkM;
    private a.s NkZ;
    private int Nka;
    private int Nkt;
    private int NlC;
    private int NlP;
    private a.p NlQ;
    private int NlR;
    private a.p NlS;
    private int NlT;
    private a.d NlU;
    private List<Integer> Nla;
    private List<a.t> Nll;
    
    private a()
    {
      AppMethodBeat.i(58586);
      this.Nkt = 6;
      this.NlP = 6;
      this.NlQ = a.p.goT();
      this.NkM = Collections.emptyList();
      this.NlS = a.p.goT();
      this.Nll = Collections.emptyList();
      this.NkZ = a.s.gpI();
      this.Nla = Collections.emptyList();
      this.NlU = a.d.gnw();
      AppMethodBeat.o(58586);
    }
    
    private a ajO(int paramInt)
    {
      this.Nka |= 0x1;
      this.Nkt = paramInt;
      return this;
    }
    
    private a ajP(int paramInt)
    {
      this.Nka |= 0x2;
      this.NlP = paramInt;
      return this;
    }
    
    private a ajQ(int paramInt)
    {
      this.Nka |= 0x4;
      this.NlC = paramInt;
      return this;
    }
    
    private a ajR(int paramInt)
    {
      this.Nka |= 0x10;
      this.NlR = paramInt;
      return this;
    }
    
    private a ajS(int paramInt)
    {
      this.Nka |= 0x80;
      this.NlT = paramInt;
      return this;
    }
    
    private a b(a.p paramp)
    {
      AppMethodBeat.i(58592);
      if (((this.Nka & 0x8) == 8) && (this.NlQ != a.p.goT())) {}
      for (this.NlQ = a.p.f(this.NlQ).j(paramp).gpp();; this.NlQ = paramp)
      {
        this.Nka |= 0x8;
        AppMethodBeat.o(58592);
        return this;
      }
    }
    
    private a b(a.s params)
    {
      AppMethodBeat.i(58596);
      if (((this.Nka & 0x200) == 512) && (this.NkZ != a.s.gpI())) {}
      for (this.NkZ = a.s.d(this.NkZ).g(params).gpL();; this.NkZ = params)
      {
        this.Nka |= 0x200;
        AppMethodBeat.o(58596);
        return this;
      }
    }
    
    private a c(a.p paramp)
    {
      AppMethodBeat.i(58594);
      if (((this.Nka & 0x40) == 64) && (this.NlS != a.p.goT())) {}
      for (this.NlS = a.p.f(this.NlS).j(paramp).gpp();; this.NlS = paramp)
      {
        this.Nka |= 0x40;
        AppMethodBeat.o(58594);
        return this;
      }
    }
    
    private a e(a.d paramd)
    {
      AppMethodBeat.i(58598);
      if (((this.Nka & 0x800) == 2048) && (this.NlU != a.d.gnw())) {}
      for (this.NlU = a.d.a(this.NlU).d(paramd).gnz();; this.NlU = paramd)
      {
        this.Nka |= 0x800;
        AppMethodBeat.o(58598);
        return this;
      }
    }
    
    private void gne()
    {
      AppMethodBeat.i(58593);
      if ((this.Nka & 0x20) != 32)
      {
        this.NkM = new ArrayList(this.NkM);
        this.Nka |= 0x20;
      }
      AppMethodBeat.o(58593);
    }
    
    private void gno()
    {
      AppMethodBeat.i(58597);
      if ((this.Nka & 0x400) != 1024)
      {
        this.Nla = new ArrayList(this.Nla);
        this.Nka |= 0x400;
      }
      AppMethodBeat.o(58597);
    }
    
    private void gnu()
    {
      AppMethodBeat.i(58595);
      if ((this.Nka & 0x100) != 256)
      {
        this.Nll = new ArrayList(this.Nll);
        this.Nka |= 0x100;
      }
      AppMethodBeat.o(58595);
    }
    
    private a gog()
    {
      AppMethodBeat.i(58587);
      a locala = new a().e(goh());
      AppMethodBeat.o(58587);
      return locala;
    }
    
    private a.h goh()
    {
      int j = 1;
      AppMethodBeat.i(58588);
      a.h localh = new a.h(this, (byte)0);
      int k = this.Nka;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.h.a(localh, this.Nkt);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.h.b(localh, this.NlP);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.h.c(localh, this.NlC);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.h.a(localh, this.NlQ);
        j = i;
        if ((k & 0x10) == 16) {
          j = i | 0x10;
        }
        a.h.d(localh, this.NlR);
        if ((this.Nka & 0x20) == 32)
        {
          this.NkM = Collections.unmodifiableList(this.NkM);
          this.Nka &= 0xFFFFFFDF;
        }
        a.h.a(localh, this.NkM);
        i = j;
        if ((k & 0x40) == 64) {
          i = j | 0x20;
        }
        a.h.b(localh, this.NlS);
        j = i;
        if ((k & 0x80) == 128) {
          j = i | 0x40;
        }
        a.h.e(localh, this.NlT);
        if ((this.Nka & 0x100) == 256)
        {
          this.Nll = Collections.unmodifiableList(this.Nll);
          this.Nka &= 0xFFFFFEFF;
        }
        a.h.b(localh, this.Nll);
        i = j;
        if ((k & 0x200) == 512) {
          i = j | 0x80;
        }
        a.h.a(localh, this.NkZ);
        if ((this.Nka & 0x400) == 1024)
        {
          this.Nla = Collections.unmodifiableList(this.Nla);
          this.Nka &= 0xFFFFFBFF;
        }
        a.h.c(localh, this.Nla);
        j = i;
        if ((k & 0x800) == 2048) {
          j = i | 0x100;
        }
        a.h.a(localh, this.NlU);
        a.h.f(localh, j);
        AppMethodBeat.o(58588);
        return localh;
        j = 0;
      }
    }
    
    /* Error */
    private a m(d.l.b.a.b.h.e parame, g paramg)
    {
      // Byte code:
      //   0: ldc 217
      //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 221	d/l/b/a/b/e/a$h:NjZ	Ld/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 226 3 0
      //   17: checkcast 9	d/l/b/a/b/e/a$h
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 171	d/l/b/a/b/e/a$h$a:e	(Ld/l/b/a/b/e/a$h;)Ld/l/b/a/b/e/a$h$a;
      //   26: pop
      //   27: ldc 217
      //   29: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 230	d/l/b/a/b/h/k:Nrq	Ld/l/b/a/b/h/q;
      //   39: checkcast 9	d/l/b/a/b/e/a$h
      //   42: astore_2
      //   43: ldc 217
      //   45: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 171	d/l/b/a/b/e/a$h$a:e	(Ld/l/b/a/b/e/a$h;)Ld/l/b/a/b/e/a$h$a;
      //   60: pop
      //   61: ldc 217
      //   63: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public final a e(a.h paramh)
    {
      AppMethodBeat.i(58589);
      if (paramh == a.h.gnZ())
      {
        AppMethodBeat.o(58589);
        return this;
      }
      if (paramh.gmO()) {
        ajO(paramh.Nkt);
      }
      if (paramh.goa()) {
        ajP(paramh.NlP);
      }
      if (paramh.gnL()) {
        ajQ(paramh.NlC);
      }
      if (paramh.gob()) {
        b(paramh.NlQ);
      }
      if (paramh.goc()) {
        ajR(paramh.NlR);
      }
      if (!a.h.a(paramh).isEmpty())
      {
        if (this.NkM.isEmpty())
        {
          this.NkM = a.h.a(paramh);
          this.Nka &= 0xFFFFFFDF;
        }
      }
      else
      {
        if (paramh.god()) {
          c(paramh.NlS);
        }
        if (paramh.goe()) {
          ajS(paramh.NlT);
        }
        if (!a.h.b(paramh).isEmpty())
        {
          if (!this.Nll.isEmpty()) {
            break label342;
          }
          this.Nll = a.h.b(paramh);
          this.Nka &= 0xFFFFFEFF;
        }
        label218:
        if (paramh.gna()) {
          b(paramh.NkZ);
        }
        if (!a.h.c(paramh).isEmpty())
        {
          if (!this.Nla.isEmpty()) {
            break label363;
          }
          this.Nla = a.h.c(paramh);
          this.Nka &= 0xFFFFFBFF;
        }
      }
      for (;;)
      {
        if (paramh.gof()) {
          e(paramh.NlU);
        }
        a(paramh);
        this.NjY = this.NjY.a(a.h.d(paramh));
        AppMethodBeat.o(58589);
        return this;
        gne();
        this.NkM.addAll(a.h.a(paramh));
        break;
        label342:
        gnu();
        this.Nll.addAll(a.h.b(paramh));
        break label218;
        label363:
        gno();
        this.Nla.addAll(a.h.c(paramh));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58590);
      if ((this.Nka & 0x4) == 4) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58590);
        return false;
      }
      if ((this.Nka & 0x8) == 8) {}
      for (i = 1; (i != 0) && (!this.NlQ.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58590);
        return false;
      }
      i = 0;
      while (i < this.NkM.size())
      {
        if (!((a.r)this.NkM.get(i)).isInitialized())
        {
          AppMethodBeat.o(58590);
          return false;
        }
        i += 1;
      }
      if ((this.Nka & 0x40) == 64) {}
      for (i = 1; (i != 0) && (!this.NlS.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58590);
        return false;
      }
      i = 0;
      while (i < this.Nll.size())
      {
        if (!((a.t)this.Nll.get(i)).isInitialized())
        {
          AppMethodBeat.o(58590);
          return false;
        }
        i += 1;
      }
      if ((this.Nka & 0x200) == 512) {}
      for (i = 1; (i != 0) && (!this.NkZ.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58590);
        return false;
      }
      if ((this.Nka & 0x800) == 2048) {}
      for (i = 1; (i != 0) && (!this.NlU.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58590);
        return false;
      }
      if (!this.Nra.isInitialized())
      {
        AppMethodBeat.o(58590);
        return false;
      }
      AppMethodBeat.o(58590);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.a.h
 * JD-Core Version:    0.7.0.1
 */