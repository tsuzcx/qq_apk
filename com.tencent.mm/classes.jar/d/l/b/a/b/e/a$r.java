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

public final class a$r
  extends i.c<r>
  implements u
{
  public static s<r> Ltc;
  private static final r Lwg;
  private final d Ltb;
  private int Ltd;
  public int Lte;
  private byte Ltg = -1;
  private int Lth = -1;
  public int LuF;
  public boolean Lwh;
  public a.r.b Lwi;
  public List<a.p> Lwj;
  public List<Integer> Lwk;
  private int Lwl = -1;
  
  static
  {
    AppMethodBeat.i(58930);
    Ltc = new b() {};
    r localr = new r();
    Lwg = localr;
    localr.fUR();
    AppMethodBeat.o(58930);
  }
  
  private a$r()
  {
    this.Ltb = d.LzL;
  }
  
  /* Error */
  private a$r(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 66	d/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 85
    //   6: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 68	d/l/b/a/b/e/a$r:Lwl	I
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 70	d/l/b/a/b/e/a$r:Ltg	B
    //   19: aload_0
    //   20: iconst_m1
    //   21: putfield 72	d/l/b/a/b/e/a$r:Lth	I
    //   24: aload_0
    //   25: invokespecial 61	d/l/b/a/b/e/a$r:fUR	()V
    //   28: iconst_0
    //   29: istore_3
    //   30: invokestatic 89	d/l/b/a/b/h/d:fZS	()Ld/l/b/a/b/h/d$b;
    //   33: astore 10
    //   35: aload 10
    //   37: iconst_1
    //   38: invokestatic 95	d/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Ld/l/b/a/b/h/f;
    //   41: astore 11
    //   43: iconst_0
    //   44: istore 5
    //   46: iload 5
    //   48: ifne +773 -> 821
    //   51: iload_3
    //   52: istore 6
    //   54: iload_3
    //   55: istore 7
    //   57: iload_3
    //   58: istore 8
    //   60: aload_1
    //   61: invokevirtual 101	d/l/b/a/b/h/e:xE	()I
    //   64: istore 4
    //   66: iload 4
    //   68: lookupswitch	default:+894->962, 0:+897->965, 8:+104->172, 16:+243->311, 24:+327->395, 32:+366->434, 42:+475->543, 48:+539->607, 50:+602->670
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
    //   160: invokevirtual 104	d/l/b/a/b/e/a$r:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/f;Ld/l/b/a/b/h/g;I)Z
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
    //   183: getfield 106	d/l/b/a/b/e/a$r:Ltd	I
    //   186: iconst_1
    //   187: ior
    //   188: putfield 106	d/l/b/a/b/e/a$r:Ltd	I
    //   191: iload_3
    //   192: istore 6
    //   194: iload_3
    //   195: istore 7
    //   197: iload_3
    //   198: istore 8
    //   200: aload_0
    //   201: aload_1
    //   202: invokevirtual 109	d/l/b/a/b/h/e:xF	()I
    //   205: putfield 111	d/l/b/a/b/e/a$r:Lte	I
    //   208: goto -162 -> 46
    //   211: astore_1
    //   212: iload 6
    //   214: istore 7
    //   216: iload 7
    //   218: istore 4
    //   220: aload_1
    //   221: aload_0
    //   222: putfield 115	d/l/b/a/b/h/k:LAt	Ld/l/b/a/b/h/q;
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
    //   253: getfield 117	d/l/b/a/b/e/a$r:Lwj	Ljava/util/List;
    //   256: invokestatic 123	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   259: putfield 117	d/l/b/a/b/e/a$r:Lwj	Ljava/util/List;
    //   262: iload 4
    //   264: bipush 32
    //   266: iand
    //   267: bipush 32
    //   269: if_icmpne +14 -> 283
    //   272: aload_0
    //   273: aload_0
    //   274: getfield 125	d/l/b/a/b/e/a$r:Lwk	Ljava/util/List;
    //   277: invokestatic 123	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   280: putfield 125	d/l/b/a/b/e/a$r:Lwk	Ljava/util/List;
    //   283: aload 11
    //   285: invokevirtual 128	d/l/b/a/b/h/f:flush	()V
    //   288: aload_0
    //   289: aload 10
    //   291: invokevirtual 134	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   294: putfield 79	d/l/b/a/b/e/a$r:Ltb	Ld/l/b/a/b/h/d;
    //   297: aload_0
    //   298: getfield 138	d/l/b/a/b/h/i$c:LAd	Ld/l/b/a/b/h/h;
    //   301: invokevirtual 143	d/l/b/a/b/h/h:gai	()V
    //   304: ldc 85
    //   306: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload_1
    //   310: athrow
    //   311: iload_3
    //   312: istore 6
    //   314: iload_3
    //   315: istore 7
    //   317: iload_3
    //   318: istore 8
    //   320: aload_0
    //   321: aload_0
    //   322: getfield 106	d/l/b/a/b/e/a$r:Ltd	I
    //   325: iconst_2
    //   326: ior
    //   327: putfield 106	d/l/b/a/b/e/a$r:Ltd	I
    //   330: iload_3
    //   331: istore 6
    //   333: iload_3
    //   334: istore 7
    //   336: iload_3
    //   337: istore 8
    //   339: aload_0
    //   340: aload_1
    //   341: invokevirtual 109	d/l/b/a/b/h/e:xF	()I
    //   344: putfield 145	d/l/b/a/b/e/a$r:LuF	I
    //   347: goto -301 -> 46
    //   350: astore_1
    //   351: iload 7
    //   353: istore 6
    //   355: iload 6
    //   357: istore 4
    //   359: new 82	d/l/b/a/b/h/k
    //   362: dup
    //   363: aload_1
    //   364: invokevirtual 149	java/io/IOException:getMessage	()Ljava/lang/String;
    //   367: invokespecial 152	d/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   370: astore_1
    //   371: iload 6
    //   373: istore 4
    //   375: aload_1
    //   376: aload_0
    //   377: putfield 115	d/l/b/a/b/h/k:LAt	Ld/l/b/a/b/h/q;
    //   380: iload 6
    //   382: istore 4
    //   384: ldc 85
    //   386: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   389: iload 6
    //   391: istore 4
    //   393: aload_1
    //   394: athrow
    //   395: iload_3
    //   396: istore 6
    //   398: iload_3
    //   399: istore 7
    //   401: iload_3
    //   402: istore 8
    //   404: aload_0
    //   405: aload_0
    //   406: getfield 106	d/l/b/a/b/e/a$r:Ltd	I
    //   409: iconst_4
    //   410: ior
    //   411: putfield 106	d/l/b/a/b/e/a$r:Ltd	I
    //   414: iload_3
    //   415: istore 6
    //   417: iload_3
    //   418: istore 7
    //   420: iload_3
    //   421: istore 8
    //   423: aload_0
    //   424: aload_1
    //   425: invokevirtual 156	d/l/b/a/b/h/e:fZX	()Z
    //   428: putfield 158	d/l/b/a/b/e/a$r:Lwh	Z
    //   431: goto -385 -> 46
    //   434: iload_3
    //   435: istore 6
    //   437: iload_3
    //   438: istore 7
    //   440: iload_3
    //   441: istore 8
    //   443: aload_1
    //   444: invokevirtual 109	d/l/b/a/b/h/e:xF	()I
    //   447: istore 9
    //   449: iload_3
    //   450: istore 6
    //   452: iload_3
    //   453: istore 7
    //   455: iload_3
    //   456: istore 8
    //   458: iload 9
    //   460: invokestatic 162	d/l/b/a/b/e/a$r$b:ahW	(I)Ld/l/b/a/b/e/a$r$b;
    //   463: astore 12
    //   465: aload 12
    //   467: ifnonnull +38 -> 505
    //   470: iload_3
    //   471: istore 6
    //   473: iload_3
    //   474: istore 7
    //   476: iload_3
    //   477: istore 8
    //   479: aload 11
    //   481: iload 4
    //   483: invokevirtual 165	d/l/b/a/b/h/f:fL	(I)V
    //   486: iload_3
    //   487: istore 6
    //   489: iload_3
    //   490: istore 7
    //   492: iload_3
    //   493: istore 8
    //   495: aload 11
    //   497: iload 9
    //   499: invokevirtual 165	d/l/b/a/b/h/f:fL	(I)V
    //   502: goto -456 -> 46
    //   505: iload_3
    //   506: istore 6
    //   508: iload_3
    //   509: istore 7
    //   511: iload_3
    //   512: istore 8
    //   514: aload_0
    //   515: aload_0
    //   516: getfield 106	d/l/b/a/b/e/a$r:Ltd	I
    //   519: bipush 8
    //   521: ior
    //   522: putfield 106	d/l/b/a/b/e/a$r:Ltd	I
    //   525: iload_3
    //   526: istore 6
    //   528: iload_3
    //   529: istore 7
    //   531: iload_3
    //   532: istore 8
    //   534: aload_0
    //   535: aload 12
    //   537: putfield 167	d/l/b/a/b/e/a$r:Lwi	Ld/l/b/a/b/e/a$r$b;
    //   540: goto -494 -> 46
    //   543: iload_3
    //   544: bipush 16
    //   546: iand
    //   547: bipush 16
    //   549: if_icmpeq +410 -> 959
    //   552: iload_3
    //   553: istore 6
    //   555: iload_3
    //   556: istore 7
    //   558: iload_3
    //   559: istore 8
    //   561: aload_0
    //   562: new 169	java/util/ArrayList
    //   565: dup
    //   566: invokespecial 170	java/util/ArrayList:<init>	()V
    //   569: putfield 117	d/l/b/a/b/e/a$r:Lwj	Ljava/util/List;
    //   572: iload_3
    //   573: bipush 16
    //   575: ior
    //   576: istore_3
    //   577: iload_3
    //   578: istore 4
    //   580: iload_3
    //   581: istore 6
    //   583: iload_3
    //   584: istore 7
    //   586: aload_0
    //   587: getfield 117	d/l/b/a/b/e/a$r:Lwj	Ljava/util/List;
    //   590: aload_1
    //   591: getstatic 173	d/l/b/a/b/e/a$p:Ltc	Ld/l/b/a/b/h/s;
    //   594: aload_2
    //   595: invokevirtual 176	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   598: invokeinterface 182 2 0
    //   603: pop
    //   604: goto -558 -> 46
    //   607: iload_3
    //   608: bipush 32
    //   610: iand
    //   611: bipush 32
    //   613: if_icmpeq +343 -> 956
    //   616: iload_3
    //   617: istore 6
    //   619: iload_3
    //   620: istore 7
    //   622: iload_3
    //   623: istore 8
    //   625: aload_0
    //   626: new 169	java/util/ArrayList
    //   629: dup
    //   630: invokespecial 170	java/util/ArrayList:<init>	()V
    //   633: putfield 125	d/l/b/a/b/e/a$r:Lwk	Ljava/util/List;
    //   636: iload_3
    //   637: bipush 32
    //   639: ior
    //   640: istore_3
    //   641: iload_3
    //   642: istore 4
    //   644: iload_3
    //   645: istore 6
    //   647: iload_3
    //   648: istore 7
    //   650: aload_0
    //   651: getfield 125	d/l/b/a/b/e/a$r:Lwk	Ljava/util/List;
    //   654: aload_1
    //   655: invokevirtual 109	d/l/b/a/b/h/e:xF	()I
    //   658: invokestatic 188	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   661: invokeinterface 182 2 0
    //   666: pop
    //   667: goto -621 -> 46
    //   670: iload_3
    //   671: istore 6
    //   673: iload_3
    //   674: istore 7
    //   676: iload_3
    //   677: istore 8
    //   679: aload_1
    //   680: aload_1
    //   681: invokevirtual 109	d/l/b/a/b/h/e:xF	()I
    //   684: invokevirtual 192	d/l/b/a/b/h/e:fD	(I)I
    //   687: istore 9
    //   689: iload_3
    //   690: istore 4
    //   692: iload_3
    //   693: bipush 32
    //   695: iand
    //   696: bipush 32
    //   698: if_icmpeq +48 -> 746
    //   701: iload_3
    //   702: istore 6
    //   704: iload_3
    //   705: istore 7
    //   707: iload_3
    //   708: istore 4
    //   710: iload_3
    //   711: istore 8
    //   713: aload_1
    //   714: invokevirtual 195	d/l/b/a/b/h/e:xI	()I
    //   717: ifle +29 -> 746
    //   720: iload_3
    //   721: istore 6
    //   723: iload_3
    //   724: istore 7
    //   726: iload_3
    //   727: istore 8
    //   729: aload_0
    //   730: new 169	java/util/ArrayList
    //   733: dup
    //   734: invokespecial 170	java/util/ArrayList:<init>	()V
    //   737: putfield 125	d/l/b/a/b/e/a$r:Lwk	Ljava/util/List;
    //   740: iload_3
    //   741: bipush 32
    //   743: ior
    //   744: istore 4
    //   746: iload 4
    //   748: istore 6
    //   750: iload 4
    //   752: istore 7
    //   754: iload 4
    //   756: istore 8
    //   758: aload_1
    //   759: invokevirtual 195	d/l/b/a/b/h/e:xI	()I
    //   762: ifle +35 -> 797
    //   765: iload 4
    //   767: istore 6
    //   769: iload 4
    //   771: istore 7
    //   773: iload 4
    //   775: istore 8
    //   777: aload_0
    //   778: getfield 125	d/l/b/a/b/e/a$r:Lwk	Ljava/util/List;
    //   781: aload_1
    //   782: invokevirtual 109	d/l/b/a/b/h/e:xF	()I
    //   785: invokestatic 188	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   788: invokeinterface 182 2 0
    //   793: pop
    //   794: goto -48 -> 746
    //   797: iload 4
    //   799: istore 6
    //   801: iload 4
    //   803: istore 7
    //   805: iload 4
    //   807: istore 8
    //   809: aload_1
    //   810: iload 9
    //   812: invokevirtual 198	d/l/b/a/b/h/e:fE	(I)V
    //   815: iload 4
    //   817: istore_3
    //   818: goto -772 -> 46
    //   821: iload_3
    //   822: bipush 16
    //   824: iand
    //   825: bipush 16
    //   827: if_icmpne +14 -> 841
    //   830: aload_0
    //   831: aload_0
    //   832: getfield 117	d/l/b/a/b/e/a$r:Lwj	Ljava/util/List;
    //   835: invokestatic 123	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   838: putfield 117	d/l/b/a/b/e/a$r:Lwj	Ljava/util/List;
    //   841: iload_3
    //   842: bipush 32
    //   844: iand
    //   845: bipush 32
    //   847: if_icmpne +14 -> 861
    //   850: aload_0
    //   851: aload_0
    //   852: getfield 125	d/l/b/a/b/e/a$r:Lwk	Ljava/util/List;
    //   855: invokestatic 123	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   858: putfield 125	d/l/b/a/b/e/a$r:Lwk	Ljava/util/List;
    //   861: aload 11
    //   863: invokevirtual 128	d/l/b/a/b/h/f:flush	()V
    //   866: aload_0
    //   867: aload 10
    //   869: invokevirtual 134	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   872: putfield 79	d/l/b/a/b/e/a$r:Ltb	Ld/l/b/a/b/h/d;
    //   875: aload_0
    //   876: getfield 138	d/l/b/a/b/h/i$c:LAd	Ld/l/b/a/b/h/h;
    //   879: invokevirtual 143	d/l/b/a/b/h/h:gai	()V
    //   882: ldc 85
    //   884: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   887: return
    //   888: astore_1
    //   889: aload_0
    //   890: aload 10
    //   892: invokevirtual 134	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   895: putfield 79	d/l/b/a/b/e/a$r:Ltb	Ld/l/b/a/b/h/d;
    //   898: goto -23 -> 875
    //   901: astore_1
    //   902: aload_0
    //   903: aload 10
    //   905: invokevirtual 134	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   908: putfield 79	d/l/b/a/b/e/a$r:Ltb	Ld/l/b/a/b/h/d;
    //   911: ldc 85
    //   913: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   916: aload_1
    //   917: athrow
    //   918: astore_2
    //   919: aload_0
    //   920: aload 10
    //   922: invokevirtual 134	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   925: putfield 79	d/l/b/a/b/e/a$r:Ltb	Ld/l/b/a/b/h/d;
    //   928: goto -631 -> 297
    //   931: astore_1
    //   932: aload_0
    //   933: aload 10
    //   935: invokevirtual 134	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   938: putfield 79	d/l/b/a/b/e/a$r:Ltb	Ld/l/b/a/b/h/d;
    //   941: ldc 85
    //   943: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   946: aload_1
    //   947: athrow
    //   948: astore_1
    //   949: goto -594 -> 355
    //   952: astore_1
    //   953: goto -737 -> 216
    //   956: goto -315 -> 641
    //   959: goto -382 -> 577
    //   962: goto -818 -> 144
    //   965: iconst_1
    //   966: istore 5
    //   968: goto -922 -> 46
    //   971: astore_1
    //   972: iload 8
    //   974: istore 4
    //   976: goto -735 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	979	0	this	r
    //   0	979	1	parame	d.l.b.a.b.h.e
    //   0	979	2	paramg	d.l.b.a.b.h.g
    //   29	816	3	i	int
    //   64	911	4	j	int
    //   44	923	5	k	int
    //   52	748	6	m	int
    //   55	749	7	n	int
    //   58	915	8	i1	int
    //   447	364	9	i2	int
    //   33	901	10	localb	d.l.b.a.b.h.d.b
    //   41	821	11	localf	f
    //   463	73	12	localb1	a.r.b
    // Exception table:
    //   from	to	target	type
    //   60	66	211	d/l/b/a/b/h/k
    //   153	166	211	d/l/b/a/b/h/k
    //   181	191	211	d/l/b/a/b/h/k
    //   200	208	211	d/l/b/a/b/h/k
    //   320	330	211	d/l/b/a/b/h/k
    //   339	347	211	d/l/b/a/b/h/k
    //   404	414	211	d/l/b/a/b/h/k
    //   423	431	211	d/l/b/a/b/h/k
    //   443	449	211	d/l/b/a/b/h/k
    //   458	465	211	d/l/b/a/b/h/k
    //   479	486	211	d/l/b/a/b/h/k
    //   495	502	211	d/l/b/a/b/h/k
    //   514	525	211	d/l/b/a/b/h/k
    //   534	540	211	d/l/b/a/b/h/k
    //   561	572	211	d/l/b/a/b/h/k
    //   625	636	211	d/l/b/a/b/h/k
    //   679	689	211	d/l/b/a/b/h/k
    //   713	720	211	d/l/b/a/b/h/k
    //   729	740	211	d/l/b/a/b/h/k
    //   758	765	211	d/l/b/a/b/h/k
    //   777	794	211	d/l/b/a/b/h/k
    //   809	815	211	d/l/b/a/b/h/k
    //   220	225	240	finally
    //   229	234	240	finally
    //   238	240	240	finally
    //   359	371	240	finally
    //   375	380	240	finally
    //   384	389	240	finally
    //   393	395	240	finally
    //   586	604	240	finally
    //   650	667	240	finally
    //   60	66	350	java/io/IOException
    //   153	166	350	java/io/IOException
    //   181	191	350	java/io/IOException
    //   200	208	350	java/io/IOException
    //   320	330	350	java/io/IOException
    //   339	347	350	java/io/IOException
    //   404	414	350	java/io/IOException
    //   423	431	350	java/io/IOException
    //   443	449	350	java/io/IOException
    //   458	465	350	java/io/IOException
    //   479	486	350	java/io/IOException
    //   495	502	350	java/io/IOException
    //   514	525	350	java/io/IOException
    //   534	540	350	java/io/IOException
    //   561	572	350	java/io/IOException
    //   625	636	350	java/io/IOException
    //   679	689	350	java/io/IOException
    //   713	720	350	java/io/IOException
    //   729	740	350	java/io/IOException
    //   758	765	350	java/io/IOException
    //   777	794	350	java/io/IOException
    //   809	815	350	java/io/IOException
    //   861	866	888	java/io/IOException
    //   861	866	901	finally
    //   283	288	918	java/io/IOException
    //   283	288	931	finally
    //   586	604	948	java/io/IOException
    //   650	667	948	java/io/IOException
    //   586	604	952	d/l/b/a/b/h/k
    //   650	667	952	d/l/b/a/b/h/k
    //   60	66	971	finally
    //   153	166	971	finally
    //   181	191	971	finally
    //   200	208	971	finally
    //   320	330	971	finally
    //   339	347	971	finally
    //   404	414	971	finally
    //   423	431	971	finally
    //   443	449	971	finally
    //   458	465	971	finally
    //   479	486	971	finally
    //   495	502	971	finally
    //   514	525	971	finally
    //   534	540	971	finally
    //   561	572	971	finally
    //   625	636	971	finally
    //   679	689	971	finally
    //   713	720	971	finally
    //   729	740	971	finally
    //   758	765	971	finally
    //   777	794	971	finally
    //   809	815	971	finally
  }
  
  private a$r(i.b<r, ?> paramb)
  {
    super(paramb);
    this.Ltb = paramb.Ltb;
  }
  
  private void fUR()
  {
    AppMethodBeat.i(58924);
    this.Lte = 0;
    this.LuF = 0;
    this.Lwh = false;
    this.Lwi = a.r.b.Lwo;
    this.Lwj = Collections.emptyList();
    this.Lwk = Collections.emptyList();
    AppMethodBeat.o(58924);
  }
  
  public static r fYb()
  {
    return Lwg;
  }
  
  public final void a(f paramf)
  {
    int j = 0;
    AppMethodBeat.i(58926);
    xS();
    i.c.a locala = gap();
    if ((this.Ltd & 0x1) == 1) {
      paramf.bv(1, this.Lte);
    }
    if ((this.Ltd & 0x2) == 2) {
      paramf.bv(2, this.LuF);
    }
    if ((this.Ltd & 0x4) == 4) {
      paramf.zr(this.Lwh);
    }
    if ((this.Ltd & 0x8) == 8) {
      paramf.lc(4, this.Lwi.value);
    }
    int i = 0;
    while (i < this.Lwj.size())
    {
      paramf.a(5, (q)this.Lwj.get(i));
      i += 1;
    }
    i = j;
    if (this.Lwk.size() > 0)
    {
      paramf.fL(50);
      paramf.fL(this.Lwl);
      i = j;
    }
    while (i < this.Lwk.size())
    {
      paramf.aiB(((Integer)this.Lwk.get(i)).intValue());
      i += 1;
    }
    locala.b(1000, paramf);
    paramf.e(this.Ltb);
    AppMethodBeat.o(58926);
  }
  
  public final s<r> fUP()
  {
    return Ltc;
  }
  
  public final boolean fUQ()
  {
    return (this.Ltd & 0x1) == 1;
  }
  
  public final boolean fWm()
  {
    return (this.Ltd & 0x2) == 2;
  }
  
  public final boolean fYc()
  {
    return (this.Ltd & 0x4) == 4;
  }
  
  public final boolean fYd()
  {
    return (this.Ltd & 0x8) == 8;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58925);
    int i = this.Ltg;
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
    if (!fUQ())
    {
      this.Ltg = 0;
      AppMethodBeat.o(58925);
      return false;
    }
    if (!fWm())
    {
      this.Ltg = 0;
      AppMethodBeat.o(58925);
      return false;
    }
    i = 0;
    while (i < this.Lwj.size())
    {
      if (!((a.p)this.Lwj.get(i)).isInitialized())
      {
        this.Ltg = 0;
        AppMethodBeat.o(58925);
        return false;
      }
      i += 1;
    }
    if (!this.LAd.isInitialized())
    {
      this.Ltg = 0;
      AppMethodBeat.o(58925);
      return false;
    }
    this.Ltg = 1;
    AppMethodBeat.o(58925);
    return true;
  }
  
  public final int xS()
  {
    AppMethodBeat.i(58927);
    int i = this.Lth;
    if (i != -1)
    {
      AppMethodBeat.o(58927);
      return i;
    }
    if ((this.Ltd & 0x1) == 1) {}
    for (int j = f.bx(1, this.Lte) + 0;; j = 0)
    {
      i = j;
      if ((this.Ltd & 0x2) == 2) {
        i = j + f.bx(2, this.LuF);
      }
      j = i;
      if ((this.Ltd & 0x4) == 4) {
        j = i + (f.fK(3) + 1);
      }
      i = j;
      if ((this.Ltd & 0x8) == 8) {
        i = j + f.ld(4, this.Lwi.value);
      }
      j = 0;
      while (j < this.Lwj.size())
      {
        i += f.c(5, (q)this.Lwj.get(j));
        j += 1;
      }
      int k = 0;
      int m;
      for (j = 0; k < this.Lwk.size(); j = m + j)
      {
        m = f.fI(((Integer)this.Lwk.get(k)).intValue());
        k += 1;
      }
      k = i + j;
      i = k;
      if (!this.Lwk.isEmpty()) {
        i = k + 1 + f.fI(j);
      }
      this.Lwl = j;
      i = i + this.LAd.xS() + this.Ltb.size();
      this.Lth = i;
      AppMethodBeat.o(58927);
      return i;
    }
  }
  
  public static final class a
    extends i.b<a.r, a>
    implements u
  {
    private int Ltd;
    private int Lte;
    private int LuF;
    private boolean Lwh;
    private a.r.b Lwi;
    private List<a.p> Lwj;
    private List<Integer> Lwk;
    
    private a()
    {
      AppMethodBeat.i(58899);
      this.Lwi = a.r.b.Lwo;
      this.Lwj = Collections.emptyList();
      this.Lwk = Collections.emptyList();
      AppMethodBeat.o(58899);
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
      this.Ltd |= 0x8;
      this.Lwi = paramb;
      AppMethodBeat.o(58905);
      return this;
    }
    
    private a ahU(int paramInt)
    {
      this.Ltd |= 0x1;
      this.Lte = paramInt;
      return this;
    }
    
    private a ahV(int paramInt)
    {
      this.Ltd |= 0x2;
      this.LuF = paramInt;
      return this;
    }
    
    private a fYe()
    {
      AppMethodBeat.i(58900);
      a locala = new a().d(fYf());
      AppMethodBeat.o(58900);
      return locala;
    }
    
    private a.r fYf()
    {
      int j = 1;
      AppMethodBeat.i(58901);
      a.r localr = new a.r(this, (byte)0);
      int k = this.Ltd;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.r.a(localr, this.Lte);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.r.b(localr, this.LuF);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.r.a(localr, this.Lwh);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.r.a(localr, this.Lwi);
        if ((this.Ltd & 0x10) == 16)
        {
          this.Lwj = Collections.unmodifiableList(this.Lwj);
          this.Ltd &= 0xFFFFFFEF;
        }
        a.r.a(localr, this.Lwj);
        if ((this.Ltd & 0x20) == 32)
        {
          this.Lwk = Collections.unmodifiableList(this.Lwk);
          this.Ltd &= 0xFFFFFFDF;
        }
        a.r.b(localr, this.Lwk);
        a.r.c(localr, i);
        AppMethodBeat.o(58901);
        return localr;
        j = 0;
      }
    }
    
    private void fYg()
    {
      AppMethodBeat.i(58906);
      if ((this.Ltd & 0x10) != 16)
      {
        this.Lwj = new ArrayList(this.Lwj);
        this.Ltd |= 0x10;
      }
      AppMethodBeat.o(58906);
    }
    
    private void fYh()
    {
      AppMethodBeat.i(58907);
      if ((this.Ltd & 0x20) != 32)
      {
        this.Lwk = new ArrayList(this.Lwk);
        this.Ltd |= 0x20;
      }
      AppMethodBeat.o(58907);
    }
    
    /* Error */
    private a w(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 130
      //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 134	d/l/b/a/b/e/a$r:Ltc	Ld/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 139 3 0
      //   17: checkcast 9	d/l/b/a/b/e/a$r
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 84	d/l/b/a/b/e/a$r$a:d	(Ld/l/b/a/b/e/a$r;)Ld/l/b/a/b/e/a$r$a;
      //   26: pop
      //   27: ldc 130
      //   29: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 143	d/l/b/a/b/h/k:LAt	Ld/l/b/a/b/h/q;
      //   39: checkcast 9	d/l/b/a/b/e/a$r
      //   42: astore_2
      //   43: ldc 130
      //   45: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 84	d/l/b/a/b/e/a$r$a:d	(Ld/l/b/a/b/e/a$r;)Ld/l/b/a/b/e/a$r$a;
      //   60: pop
      //   61: ldc 130
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
    
    private a zq(boolean paramBoolean)
    {
      this.Ltd |= 0x4;
      this.Lwh = paramBoolean;
      return this;
    }
    
    public final a d(a.r paramr)
    {
      AppMethodBeat.i(58902);
      if (paramr == a.r.fYb())
      {
        AppMethodBeat.o(58902);
        return this;
      }
      if (paramr.fUQ()) {
        ahU(paramr.Lte);
      }
      if (paramr.fWm()) {
        ahV(paramr.LuF);
      }
      if (paramr.fYc()) {
        zq(paramr.Lwh);
      }
      if (paramr.fYd()) {
        a(paramr.Lwi);
      }
      if (!a.r.a(paramr).isEmpty())
      {
        if (this.Lwj.isEmpty())
        {
          this.Lwj = a.r.a(paramr);
          this.Ltd &= 0xFFFFFFEF;
        }
      }
      else if (!a.r.b(paramr).isEmpty())
      {
        if (!this.Lwk.isEmpty()) {
          break label217;
        }
        this.Lwk = a.r.b(paramr);
        this.Ltd &= 0xFFFFFFDF;
      }
      for (;;)
      {
        a(paramr);
        this.Ltb = this.Ltb.a(a.r.c(paramr));
        AppMethodBeat.o(58902);
        return this;
        fYg();
        this.Lwj.addAll(a.r.a(paramr));
        break;
        label217:
        fYh();
        this.Lwk.addAll(a.r.b(paramr));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58903);
      if ((this.Ltd & 0x1) == 1) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58903);
        return false;
      }
      if ((this.Ltd & 0x2) == 2) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58903);
        return false;
      }
      i = 0;
      while (i < this.Lwj.size())
      {
        if (!((a.p)this.Lwj.get(i)).isInitialized())
        {
          AppMethodBeat.o(58903);
          return false;
        }
        i += 1;
      }
      if (!this.LAd.isInitialized())
      {
        AppMethodBeat.o(58903);
        return false;
      }
      AppMethodBeat.o(58903);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.a.r
 * JD-Core Version:    0.7.0.1
 */