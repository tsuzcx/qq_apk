package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.b;
import d.l.b.a.b.h.d;
import d.l.b.a.b.h.f;
import d.l.b.a.b.h.h;
import d.l.b.a.b.h.i;
import d.l.b.a.b.h.i.a;
import d.l.b.a.b.h.i.b;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.h.i.c.a;
import d.l.b.a.b.h.j.a;
import d.l.b.a.b.h.j.b;
import d.l.b.a.b.h.q;
import d.l.b.a.b.h.s;
import d.l.b.a.b.h.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$p
  extends i.c<p>
  implements t
{
  public static s<p> NjZ;
  private static final p NmB;
  private final d NjY;
  private int Nka;
  public List<a> Nkc;
  private byte Nkd = -1;
  private int Nke = -1;
  public int Nkt;
  public boolean NmC;
  public int NmD;
  public p NmE;
  public int NmF;
  public int NmG;
  public int NmH;
  public int NmI;
  public int NmJ;
  public p NmK;
  public int NmL;
  public p NmM;
  public int NmN;
  
  static
  {
    AppMethodBeat.i(58865);
    NjZ = new b() {};
    p localp = new p();
    NmB = localp;
    localp.gmq();
    AppMethodBeat.o(58865);
  }
  
  private a$p()
  {
    this.NjY = d.NqI;
  }
  
  /* Error */
  private a$p(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 80	d/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 97
    //   6: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 82	d/l/b/a/b/e/a$p:Nkd	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 84	d/l/b/a/b/e/a$p:Nke	I
    //   19: aload_0
    //   20: invokespecial 75	d/l/b/a/b/e/a$p:gmq	()V
    //   23: invokestatic 101	d/l/b/a/b/h/d:grr	()Ld/l/b/a/b/h/d$b;
    //   26: astore 10
    //   28: aload 10
    //   30: iconst_1
    //   31: invokestatic 107	d/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Ld/l/b/a/b/h/f;
    //   34: astore 11
    //   36: iconst_0
    //   37: istore 6
    //   39: iconst_0
    //   40: istore_3
    //   41: iload 6
    //   43: ifne +1199 -> 1242
    //   46: iload_3
    //   47: istore 7
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 8
    //   55: aload_1
    //   56: invokevirtual 113	d/l/b/a/b/h/e:zb	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+1302->1365, 0:+1305->1368, 8:+157->220, 18:+271->334, 24:+383->446, 32:+422->485, 42:+461->524, 48:+602->665, 56:+642->705, 64:+682->745, 72:+722->785, 82:+762->825, 88:+909->972, 96:+950->1013, 106:+991->1054, 112:+1138->1201
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
    //   208: invokevirtual 116	d/l/b/a/b/e/a$p:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/f;Ld/l/b/a/b/h/g;I)Z
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
    //   231: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   234: sipush 4096
    //   237: ior
    //   238: putfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   241: iload_3
    //   242: istore 7
    //   244: iload_3
    //   245: istore 5
    //   247: iload_3
    //   248: istore 8
    //   250: aload_0
    //   251: aload_1
    //   252: invokevirtual 121	d/l/b/a/b/h/e:zc	()I
    //   255: putfield 123	d/l/b/a/b/e/a$p:Nkt	I
    //   258: goto -217 -> 41
    //   261: astore_1
    //   262: iload 7
    //   264: istore 5
    //   266: aload_1
    //   267: aload_0
    //   268: putfield 127	d/l/b/a/b/h/k:Nrq	Ld/l/b/a/b/h/q;
    //   271: iload 7
    //   273: istore 5
    //   275: ldc 97
    //   277: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   297: getfield 129	d/l/b/a/b/e/a$p:Nkc	Ljava/util/List;
    //   300: invokestatic 135	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   303: putfield 129	d/l/b/a/b/e/a$p:Nkc	Ljava/util/List;
    //   306: aload 11
    //   308: invokevirtual 138	d/l/b/a/b/h/f:flush	()V
    //   311: aload_0
    //   312: aload 10
    //   314: invokevirtual 144	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   317: putfield 91	d/l/b/a/b/e/a$p:NjY	Ld/l/b/a/b/h/d;
    //   320: aload_0
    //   321: getfield 148	d/l/b/a/b/h/i$c:Nra	Ld/l/b/a/b/h/h;
    //   324: invokevirtual 153	d/l/b/a/b/h/h:grH	()V
    //   327: ldc 97
    //   329: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   332: aload_1
    //   333: athrow
    //   334: iload_3
    //   335: istore 4
    //   337: iload_3
    //   338: iconst_1
    //   339: iand
    //   340: iconst_1
    //   341: if_icmpeq +28 -> 369
    //   344: iload_3
    //   345: istore 7
    //   347: iload_3
    //   348: istore 5
    //   350: iload_3
    //   351: istore 8
    //   353: aload_0
    //   354: new 155	java/util/ArrayList
    //   357: dup
    //   358: invokespecial 156	java/util/ArrayList:<init>	()V
    //   361: putfield 129	d/l/b/a/b/e/a$p:Nkc	Ljava/util/List;
    //   364: iload_3
    //   365: iconst_1
    //   366: ior
    //   367: istore 4
    //   369: iload 4
    //   371: istore 7
    //   373: iload 4
    //   375: istore 5
    //   377: iload 4
    //   379: istore 8
    //   381: aload_0
    //   382: getfield 129	d/l/b/a/b/e/a$p:Nkc	Ljava/util/List;
    //   385: aload_1
    //   386: getstatic 157	d/l/b/a/b/e/a$p$a:NjZ	Ld/l/b/a/b/h/s;
    //   389: aload_2
    //   390: invokevirtual 160	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   393: invokeinterface 166 2 0
    //   398: pop
    //   399: iload 4
    //   401: istore_3
    //   402: goto -361 -> 41
    //   405: astore_1
    //   406: iload 8
    //   408: istore 5
    //   410: new 94	d/l/b/a/b/h/k
    //   413: dup
    //   414: aload_1
    //   415: invokevirtual 170	java/io/IOException:getMessage	()Ljava/lang/String;
    //   418: invokespecial 173	d/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   421: astore_1
    //   422: iload 8
    //   424: istore 5
    //   426: aload_1
    //   427: aload_0
    //   428: putfield 127	d/l/b/a/b/h/k:Nrq	Ld/l/b/a/b/h/q;
    //   431: iload 8
    //   433: istore 5
    //   435: ldc 97
    //   437: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: iload 8
    //   442: istore 5
    //   444: aload_1
    //   445: athrow
    //   446: iload_3
    //   447: istore 7
    //   449: iload_3
    //   450: istore 5
    //   452: iload_3
    //   453: istore 8
    //   455: aload_0
    //   456: aload_0
    //   457: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   460: iconst_1
    //   461: ior
    //   462: putfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   465: iload_3
    //   466: istore 7
    //   468: iload_3
    //   469: istore 5
    //   471: iload_3
    //   472: istore 8
    //   474: aload_0
    //   475: aload_1
    //   476: invokevirtual 177	d/l/b/a/b/h/e:grw	()Z
    //   479: putfield 179	d/l/b/a/b/e/a$p:NmC	Z
    //   482: goto -441 -> 41
    //   485: iload_3
    //   486: istore 7
    //   488: iload_3
    //   489: istore 5
    //   491: iload_3
    //   492: istore 8
    //   494: aload_0
    //   495: aload_0
    //   496: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   499: iconst_2
    //   500: ior
    //   501: putfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   504: iload_3
    //   505: istore 7
    //   507: iload_3
    //   508: istore 5
    //   510: iload_3
    //   511: istore 8
    //   513: aload_0
    //   514: aload_1
    //   515: invokevirtual 121	d/l/b/a/b/h/e:zc	()I
    //   518: putfield 181	d/l/b/a/b/e/a$p:NmD	I
    //   521: goto -480 -> 41
    //   524: iload_3
    //   525: istore 7
    //   527: iload_3
    //   528: istore 5
    //   530: iload_3
    //   531: istore 8
    //   533: aload_0
    //   534: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   537: iconst_4
    //   538: iand
    //   539: iconst_4
    //   540: if_icmpne +819 -> 1359
    //   543: iload_3
    //   544: istore 7
    //   546: iload_3
    //   547: istore 5
    //   549: iload_3
    //   550: istore 8
    //   552: aload_0
    //   553: getfield 183	d/l/b/a/b/e/a$p:NmE	Ld/l/b/a/b/e/a$p;
    //   556: astore 9
    //   558: iload_3
    //   559: istore 7
    //   561: iload_3
    //   562: istore 5
    //   564: iload_3
    //   565: istore 8
    //   567: invokestatic 187	d/l/b/a/b/e/a$p$b:gpq	()Ld/l/b/a/b/e/a$p$b;
    //   570: aload 9
    //   572: invokevirtual 191	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   575: astore 9
    //   577: iload_3
    //   578: istore 7
    //   580: iload_3
    //   581: istore 5
    //   583: iload_3
    //   584: istore 8
    //   586: aload_0
    //   587: aload_1
    //   588: getstatic 69	d/l/b/a/b/e/a$p:NjZ	Ld/l/b/a/b/h/s;
    //   591: aload_2
    //   592: invokevirtual 160	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   595: checkcast 2	d/l/b/a/b/e/a$p
    //   598: putfield 183	d/l/b/a/b/e/a$p:NmE	Ld/l/b/a/b/e/a$p;
    //   601: aload 9
    //   603: ifnull +40 -> 643
    //   606: iload_3
    //   607: istore 7
    //   609: iload_3
    //   610: istore 5
    //   612: iload_3
    //   613: istore 8
    //   615: aload 9
    //   617: aload_0
    //   618: getfield 183	d/l/b/a/b/e/a$p:NmE	Ld/l/b/a/b/e/a$p;
    //   621: invokevirtual 191	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   624: pop
    //   625: iload_3
    //   626: istore 7
    //   628: iload_3
    //   629: istore 5
    //   631: iload_3
    //   632: istore 8
    //   634: aload_0
    //   635: aload 9
    //   637: invokevirtual 195	d/l/b/a/b/e/a$p$b:gpp	()Ld/l/b/a/b/e/a$p;
    //   640: putfield 183	d/l/b/a/b/e/a$p:NmE	Ld/l/b/a/b/e/a$p;
    //   643: iload_3
    //   644: istore 7
    //   646: iload_3
    //   647: istore 5
    //   649: iload_3
    //   650: istore 8
    //   652: aload_0
    //   653: aload_0
    //   654: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   657: iconst_4
    //   658: ior
    //   659: putfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   662: goto -621 -> 41
    //   665: iload_3
    //   666: istore 7
    //   668: iload_3
    //   669: istore 5
    //   671: iload_3
    //   672: istore 8
    //   674: aload_0
    //   675: aload_0
    //   676: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   679: bipush 16
    //   681: ior
    //   682: putfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   685: iload_3
    //   686: istore 7
    //   688: iload_3
    //   689: istore 5
    //   691: iload_3
    //   692: istore 8
    //   694: aload_0
    //   695: aload_1
    //   696: invokevirtual 121	d/l/b/a/b/h/e:zc	()I
    //   699: putfield 197	d/l/b/a/b/e/a$p:NmG	I
    //   702: goto -661 -> 41
    //   705: iload_3
    //   706: istore 7
    //   708: iload_3
    //   709: istore 5
    //   711: iload_3
    //   712: istore 8
    //   714: aload_0
    //   715: aload_0
    //   716: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   719: bipush 32
    //   721: ior
    //   722: putfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   725: iload_3
    //   726: istore 7
    //   728: iload_3
    //   729: istore 5
    //   731: iload_3
    //   732: istore 8
    //   734: aload_0
    //   735: aload_1
    //   736: invokevirtual 121	d/l/b/a/b/h/e:zc	()I
    //   739: putfield 199	d/l/b/a/b/e/a$p:NmH	I
    //   742: goto -701 -> 41
    //   745: iload_3
    //   746: istore 7
    //   748: iload_3
    //   749: istore 5
    //   751: iload_3
    //   752: istore 8
    //   754: aload_0
    //   755: aload_0
    //   756: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   759: bipush 8
    //   761: ior
    //   762: putfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   765: iload_3
    //   766: istore 7
    //   768: iload_3
    //   769: istore 5
    //   771: iload_3
    //   772: istore 8
    //   774: aload_0
    //   775: aload_1
    //   776: invokevirtual 121	d/l/b/a/b/h/e:zc	()I
    //   779: putfield 201	d/l/b/a/b/e/a$p:NmF	I
    //   782: goto -741 -> 41
    //   785: iload_3
    //   786: istore 7
    //   788: iload_3
    //   789: istore 5
    //   791: iload_3
    //   792: istore 8
    //   794: aload_0
    //   795: aload_0
    //   796: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   799: bipush 64
    //   801: ior
    //   802: putfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   805: iload_3
    //   806: istore 7
    //   808: iload_3
    //   809: istore 5
    //   811: iload_3
    //   812: istore 8
    //   814: aload_0
    //   815: aload_1
    //   816: invokevirtual 121	d/l/b/a/b/h/e:zc	()I
    //   819: putfield 203	d/l/b/a/b/e/a$p:NmI	I
    //   822: goto -781 -> 41
    //   825: iload_3
    //   826: istore 7
    //   828: iload_3
    //   829: istore 5
    //   831: iload_3
    //   832: istore 8
    //   834: aload_0
    //   835: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   838: sipush 256
    //   841: iand
    //   842: sipush 256
    //   845: if_icmpne +508 -> 1353
    //   848: iload_3
    //   849: istore 7
    //   851: iload_3
    //   852: istore 5
    //   854: iload_3
    //   855: istore 8
    //   857: aload_0
    //   858: getfield 205	d/l/b/a/b/e/a$p:NmK	Ld/l/b/a/b/e/a$p;
    //   861: astore 9
    //   863: iload_3
    //   864: istore 7
    //   866: iload_3
    //   867: istore 5
    //   869: iload_3
    //   870: istore 8
    //   872: invokestatic 187	d/l/b/a/b/e/a$p$b:gpq	()Ld/l/b/a/b/e/a$p$b;
    //   875: aload 9
    //   877: invokevirtual 191	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   880: astore 9
    //   882: iload_3
    //   883: istore 7
    //   885: iload_3
    //   886: istore 5
    //   888: iload_3
    //   889: istore 8
    //   891: aload_0
    //   892: aload_1
    //   893: getstatic 69	d/l/b/a/b/e/a$p:NjZ	Ld/l/b/a/b/h/s;
    //   896: aload_2
    //   897: invokevirtual 160	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   900: checkcast 2	d/l/b/a/b/e/a$p
    //   903: putfield 205	d/l/b/a/b/e/a$p:NmK	Ld/l/b/a/b/e/a$p;
    //   906: aload 9
    //   908: ifnull +40 -> 948
    //   911: iload_3
    //   912: istore 7
    //   914: iload_3
    //   915: istore 5
    //   917: iload_3
    //   918: istore 8
    //   920: aload 9
    //   922: aload_0
    //   923: getfield 205	d/l/b/a/b/e/a$p:NmK	Ld/l/b/a/b/e/a$p;
    //   926: invokevirtual 191	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   929: pop
    //   930: iload_3
    //   931: istore 7
    //   933: iload_3
    //   934: istore 5
    //   936: iload_3
    //   937: istore 8
    //   939: aload_0
    //   940: aload 9
    //   942: invokevirtual 195	d/l/b/a/b/e/a$p$b:gpp	()Ld/l/b/a/b/e/a$p;
    //   945: putfield 205	d/l/b/a/b/e/a$p:NmK	Ld/l/b/a/b/e/a$p;
    //   948: iload_3
    //   949: istore 7
    //   951: iload_3
    //   952: istore 5
    //   954: iload_3
    //   955: istore 8
    //   957: aload_0
    //   958: aload_0
    //   959: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   962: sipush 256
    //   965: ior
    //   966: putfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   969: goto -928 -> 41
    //   972: iload_3
    //   973: istore 7
    //   975: iload_3
    //   976: istore 5
    //   978: iload_3
    //   979: istore 8
    //   981: aload_0
    //   982: aload_0
    //   983: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   986: sipush 512
    //   989: ior
    //   990: putfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   993: iload_3
    //   994: istore 7
    //   996: iload_3
    //   997: istore 5
    //   999: iload_3
    //   1000: istore 8
    //   1002: aload_0
    //   1003: aload_1
    //   1004: invokevirtual 121	d/l/b/a/b/h/e:zc	()I
    //   1007: putfield 207	d/l/b/a/b/e/a$p:NmL	I
    //   1010: goto -969 -> 41
    //   1013: iload_3
    //   1014: istore 7
    //   1016: iload_3
    //   1017: istore 5
    //   1019: iload_3
    //   1020: istore 8
    //   1022: aload_0
    //   1023: aload_0
    //   1024: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   1027: sipush 128
    //   1030: ior
    //   1031: putfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   1034: iload_3
    //   1035: istore 7
    //   1037: iload_3
    //   1038: istore 5
    //   1040: iload_3
    //   1041: istore 8
    //   1043: aload_0
    //   1044: aload_1
    //   1045: invokevirtual 121	d/l/b/a/b/h/e:zc	()I
    //   1048: putfield 209	d/l/b/a/b/e/a$p:NmJ	I
    //   1051: goto -1010 -> 41
    //   1054: iload_3
    //   1055: istore 7
    //   1057: iload_3
    //   1058: istore 5
    //   1060: iload_3
    //   1061: istore 8
    //   1063: aload_0
    //   1064: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   1067: sipush 1024
    //   1070: iand
    //   1071: sipush 1024
    //   1074: if_icmpne +273 -> 1347
    //   1077: iload_3
    //   1078: istore 7
    //   1080: iload_3
    //   1081: istore 5
    //   1083: iload_3
    //   1084: istore 8
    //   1086: aload_0
    //   1087: getfield 211	d/l/b/a/b/e/a$p:NmM	Ld/l/b/a/b/e/a$p;
    //   1090: astore 9
    //   1092: iload_3
    //   1093: istore 7
    //   1095: iload_3
    //   1096: istore 5
    //   1098: iload_3
    //   1099: istore 8
    //   1101: invokestatic 187	d/l/b/a/b/e/a$p$b:gpq	()Ld/l/b/a/b/e/a$p$b;
    //   1104: aload 9
    //   1106: invokevirtual 191	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   1109: astore 9
    //   1111: iload_3
    //   1112: istore 7
    //   1114: iload_3
    //   1115: istore 5
    //   1117: iload_3
    //   1118: istore 8
    //   1120: aload_0
    //   1121: aload_1
    //   1122: getstatic 69	d/l/b/a/b/e/a$p:NjZ	Ld/l/b/a/b/h/s;
    //   1125: aload_2
    //   1126: invokevirtual 160	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   1129: checkcast 2	d/l/b/a/b/e/a$p
    //   1132: putfield 211	d/l/b/a/b/e/a$p:NmM	Ld/l/b/a/b/e/a$p;
    //   1135: aload 9
    //   1137: ifnull +40 -> 1177
    //   1140: iload_3
    //   1141: istore 7
    //   1143: iload_3
    //   1144: istore 5
    //   1146: iload_3
    //   1147: istore 8
    //   1149: aload 9
    //   1151: aload_0
    //   1152: getfield 211	d/l/b/a/b/e/a$p:NmM	Ld/l/b/a/b/e/a$p;
    //   1155: invokevirtual 191	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   1158: pop
    //   1159: iload_3
    //   1160: istore 7
    //   1162: iload_3
    //   1163: istore 5
    //   1165: iload_3
    //   1166: istore 8
    //   1168: aload_0
    //   1169: aload 9
    //   1171: invokevirtual 195	d/l/b/a/b/e/a$p$b:gpp	()Ld/l/b/a/b/e/a$p;
    //   1174: putfield 211	d/l/b/a/b/e/a$p:NmM	Ld/l/b/a/b/e/a$p;
    //   1177: iload_3
    //   1178: istore 7
    //   1180: iload_3
    //   1181: istore 5
    //   1183: iload_3
    //   1184: istore 8
    //   1186: aload_0
    //   1187: aload_0
    //   1188: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   1191: sipush 1024
    //   1194: ior
    //   1195: putfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   1198: goto -1157 -> 41
    //   1201: iload_3
    //   1202: istore 7
    //   1204: iload_3
    //   1205: istore 5
    //   1207: iload_3
    //   1208: istore 8
    //   1210: aload_0
    //   1211: aload_0
    //   1212: getfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   1215: sipush 2048
    //   1218: ior
    //   1219: putfield 118	d/l/b/a/b/e/a$p:Nka	I
    //   1222: iload_3
    //   1223: istore 7
    //   1225: iload_3
    //   1226: istore 5
    //   1228: iload_3
    //   1229: istore 8
    //   1231: aload_0
    //   1232: aload_1
    //   1233: invokevirtual 121	d/l/b/a/b/h/e:zc	()I
    //   1236: putfield 213	d/l/b/a/b/e/a$p:NmN	I
    //   1239: goto -1198 -> 41
    //   1242: iload_3
    //   1243: iconst_1
    //   1244: iand
    //   1245: iconst_1
    //   1246: if_icmpne +14 -> 1260
    //   1249: aload_0
    //   1250: aload_0
    //   1251: getfield 129	d/l/b/a/b/e/a$p:Nkc	Ljava/util/List;
    //   1254: invokestatic 135	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1257: putfield 129	d/l/b/a/b/e/a$p:Nkc	Ljava/util/List;
    //   1260: aload 11
    //   1262: invokevirtual 138	d/l/b/a/b/h/f:flush	()V
    //   1265: aload_0
    //   1266: aload 10
    //   1268: invokevirtual 144	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   1271: putfield 91	d/l/b/a/b/e/a$p:NjY	Ld/l/b/a/b/h/d;
    //   1274: aload_0
    //   1275: getfield 148	d/l/b/a/b/h/i$c:Nra	Ld/l/b/a/b/h/h;
    //   1278: invokevirtual 153	d/l/b/a/b/h/h:grH	()V
    //   1281: ldc 97
    //   1283: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1286: return
    //   1287: astore_1
    //   1288: aload_0
    //   1289: aload 10
    //   1291: invokevirtual 144	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   1294: putfield 91	d/l/b/a/b/e/a$p:NjY	Ld/l/b/a/b/h/d;
    //   1297: goto -23 -> 1274
    //   1300: astore_1
    //   1301: aload_0
    //   1302: aload 10
    //   1304: invokevirtual 144	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   1307: putfield 91	d/l/b/a/b/e/a$p:NjY	Ld/l/b/a/b/h/d;
    //   1310: ldc 97
    //   1312: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1315: aload_1
    //   1316: athrow
    //   1317: astore_2
    //   1318: aload_0
    //   1319: aload 10
    //   1321: invokevirtual 144	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   1324: putfield 91	d/l/b/a/b/e/a$p:NjY	Ld/l/b/a/b/h/d;
    //   1327: goto -1007 -> 320
    //   1330: astore_1
    //   1331: aload_0
    //   1332: aload 10
    //   1334: invokevirtual 144	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
    //   1337: putfield 91	d/l/b/a/b/e/a$p:NjY	Ld/l/b/a/b/h/d;
    //   1340: ldc 97
    //   1342: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1345: aload_1
    //   1346: athrow
    //   1347: aconst_null
    //   1348: astore 9
    //   1350: goto -239 -> 1111
    //   1353: aconst_null
    //   1354: astore 9
    //   1356: goto -474 -> 882
    //   1359: aconst_null
    //   1360: astore 9
    //   1362: goto -785 -> 577
    //   1365: goto -1173 -> 192
    //   1368: iconst_1
    //   1369: istore 6
    //   1371: goto -1330 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1374	0	this	p
    //   0	1374	1	parame	d.l.b.a.b.h.e
    //   0	1374	2	paramg	d.l.b.a.b.h.g
    //   40	1205	3	i	int
    //   59	341	4	j	int
    //   50	1177	5	k	int
    //   37	1333	6	m	int
    //   47	1177	7	n	int
    //   53	1177	8	i1	int
    //   556	805	9	localObject	Object
    //   26	1307	10	localb	d.l.b.a.b.h.d.b
    //   34	1227	11	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	261	d/l/b/a/b/h/k
    //   201	214	261	d/l/b/a/b/h/k
    //   229	241	261	d/l/b/a/b/h/k
    //   250	258	261	d/l/b/a/b/h/k
    //   353	364	261	d/l/b/a/b/h/k
    //   381	399	261	d/l/b/a/b/h/k
    //   455	465	261	d/l/b/a/b/h/k
    //   474	482	261	d/l/b/a/b/h/k
    //   494	504	261	d/l/b/a/b/h/k
    //   513	521	261	d/l/b/a/b/h/k
    //   533	543	261	d/l/b/a/b/h/k
    //   552	558	261	d/l/b/a/b/h/k
    //   567	577	261	d/l/b/a/b/h/k
    //   586	601	261	d/l/b/a/b/h/k
    //   615	625	261	d/l/b/a/b/h/k
    //   634	643	261	d/l/b/a/b/h/k
    //   652	662	261	d/l/b/a/b/h/k
    //   674	685	261	d/l/b/a/b/h/k
    //   694	702	261	d/l/b/a/b/h/k
    //   714	725	261	d/l/b/a/b/h/k
    //   734	742	261	d/l/b/a/b/h/k
    //   754	765	261	d/l/b/a/b/h/k
    //   774	782	261	d/l/b/a/b/h/k
    //   794	805	261	d/l/b/a/b/h/k
    //   814	822	261	d/l/b/a/b/h/k
    //   834	848	261	d/l/b/a/b/h/k
    //   857	863	261	d/l/b/a/b/h/k
    //   872	882	261	d/l/b/a/b/h/k
    //   891	906	261	d/l/b/a/b/h/k
    //   920	930	261	d/l/b/a/b/h/k
    //   939	948	261	d/l/b/a/b/h/k
    //   957	969	261	d/l/b/a/b/h/k
    //   981	993	261	d/l/b/a/b/h/k
    //   1002	1010	261	d/l/b/a/b/h/k
    //   1022	1034	261	d/l/b/a/b/h/k
    //   1043	1051	261	d/l/b/a/b/h/k
    //   1063	1077	261	d/l/b/a/b/h/k
    //   1086	1092	261	d/l/b/a/b/h/k
    //   1101	1111	261	d/l/b/a/b/h/k
    //   1120	1135	261	d/l/b/a/b/h/k
    //   1149	1159	261	d/l/b/a/b/h/k
    //   1168	1177	261	d/l/b/a/b/h/k
    //   1186	1198	261	d/l/b/a/b/h/k
    //   1210	1222	261	d/l/b/a/b/h/k
    //   1231	1239	261	d/l/b/a/b/h/k
    //   55	61	286	finally
    //   201	214	286	finally
    //   229	241	286	finally
    //   250	258	286	finally
    //   266	271	286	finally
    //   275	280	286	finally
    //   284	286	286	finally
    //   353	364	286	finally
    //   381	399	286	finally
    //   410	422	286	finally
    //   426	431	286	finally
    //   435	440	286	finally
    //   444	446	286	finally
    //   455	465	286	finally
    //   474	482	286	finally
    //   494	504	286	finally
    //   513	521	286	finally
    //   533	543	286	finally
    //   552	558	286	finally
    //   567	577	286	finally
    //   586	601	286	finally
    //   615	625	286	finally
    //   634	643	286	finally
    //   652	662	286	finally
    //   674	685	286	finally
    //   694	702	286	finally
    //   714	725	286	finally
    //   734	742	286	finally
    //   754	765	286	finally
    //   774	782	286	finally
    //   794	805	286	finally
    //   814	822	286	finally
    //   834	848	286	finally
    //   857	863	286	finally
    //   872	882	286	finally
    //   891	906	286	finally
    //   920	930	286	finally
    //   939	948	286	finally
    //   957	969	286	finally
    //   981	993	286	finally
    //   1002	1010	286	finally
    //   1022	1034	286	finally
    //   1043	1051	286	finally
    //   1063	1077	286	finally
    //   1086	1092	286	finally
    //   1101	1111	286	finally
    //   1120	1135	286	finally
    //   1149	1159	286	finally
    //   1168	1177	286	finally
    //   1186	1198	286	finally
    //   1210	1222	286	finally
    //   1231	1239	286	finally
    //   55	61	405	java/io/IOException
    //   201	214	405	java/io/IOException
    //   229	241	405	java/io/IOException
    //   250	258	405	java/io/IOException
    //   353	364	405	java/io/IOException
    //   381	399	405	java/io/IOException
    //   455	465	405	java/io/IOException
    //   474	482	405	java/io/IOException
    //   494	504	405	java/io/IOException
    //   513	521	405	java/io/IOException
    //   533	543	405	java/io/IOException
    //   552	558	405	java/io/IOException
    //   567	577	405	java/io/IOException
    //   586	601	405	java/io/IOException
    //   615	625	405	java/io/IOException
    //   634	643	405	java/io/IOException
    //   652	662	405	java/io/IOException
    //   674	685	405	java/io/IOException
    //   694	702	405	java/io/IOException
    //   714	725	405	java/io/IOException
    //   734	742	405	java/io/IOException
    //   754	765	405	java/io/IOException
    //   774	782	405	java/io/IOException
    //   794	805	405	java/io/IOException
    //   814	822	405	java/io/IOException
    //   834	848	405	java/io/IOException
    //   857	863	405	java/io/IOException
    //   872	882	405	java/io/IOException
    //   891	906	405	java/io/IOException
    //   920	930	405	java/io/IOException
    //   939	948	405	java/io/IOException
    //   957	969	405	java/io/IOException
    //   981	993	405	java/io/IOException
    //   1002	1010	405	java/io/IOException
    //   1022	1034	405	java/io/IOException
    //   1043	1051	405	java/io/IOException
    //   1063	1077	405	java/io/IOException
    //   1086	1092	405	java/io/IOException
    //   1101	1111	405	java/io/IOException
    //   1120	1135	405	java/io/IOException
    //   1149	1159	405	java/io/IOException
    //   1168	1177	405	java/io/IOException
    //   1186	1198	405	java/io/IOException
    //   1210	1222	405	java/io/IOException
    //   1231	1239	405	java/io/IOException
    //   1260	1265	1287	java/io/IOException
    //   1260	1265	1300	finally
    //   306	311	1317	java/io/IOException
    //   306	311	1330	finally
  }
  
  private a$p(i.b<p, ?> paramb)
  {
    super(paramb);
    this.NjY = paramb.NjY;
  }
  
  public static b f(p paramp)
  {
    AppMethodBeat.i(221691);
    paramp = b.gpq().j(paramp);
    AppMethodBeat.o(221691);
    return paramp;
  }
  
  private void gmq()
  {
    AppMethodBeat.i(58857);
    this.Nkc = Collections.emptyList();
    this.NmC = false;
    this.NmD = 0;
    this.NmE = NmB;
    this.NmF = 0;
    this.NmG = 0;
    this.NmH = 0;
    this.NmI = 0;
    this.NmJ = 0;
    this.NmK = NmB;
    this.NmL = 0;
    this.NmM = NmB;
    this.NmN = 0;
    this.Nkt = 0;
    AppMethodBeat.o(58857);
  }
  
  public static p goT()
  {
    return NmB;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58859);
    zp();
    i.c.a locala = grO();
    if ((this.Nka & 0x1000) == 4096) {
      paramf.bx(1, this.Nkt);
    }
    int i = 0;
    while (i < this.Nkc.size())
    {
      paramf.a(2, (q)this.Nkc.get(i));
      i += 1;
    }
    if ((this.Nka & 0x1) == 1) {
      paramf.Af(this.NmC);
    }
    if ((this.Nka & 0x2) == 2) {
      paramf.bx(4, this.NmD);
    }
    if ((this.Nka & 0x4) == 4) {
      paramf.a(5, this.NmE);
    }
    if ((this.Nka & 0x10) == 16) {
      paramf.bx(6, this.NmG);
    }
    if ((this.Nka & 0x20) == 32) {
      paramf.bx(7, this.NmH);
    }
    if ((this.Nka & 0x8) == 8) {
      paramf.bx(8, this.NmF);
    }
    if ((this.Nka & 0x40) == 64) {
      paramf.bx(9, this.NmI);
    }
    if ((this.Nka & 0x100) == 256) {
      paramf.a(10, this.NmK);
    }
    if ((this.Nka & 0x200) == 512) {
      paramf.bx(11, this.NmL);
    }
    if ((this.Nka & 0x80) == 128) {
      paramf.bx(12, this.NmJ);
    }
    if ((this.Nka & 0x400) == 1024) {
      paramf.a(13, this.NmM);
    }
    if ((this.Nka & 0x800) == 2048) {
      paramf.bx(14, this.NmN);
    }
    locala.b(200, paramf);
    paramf.e(this.NjY);
    AppMethodBeat.o(58859);
  }
  
  public final int getArgumentCount()
  {
    AppMethodBeat.i(58856);
    int i = this.Nkc.size();
    AppMethodBeat.o(58856);
    return i;
  }
  
  public final boolean gmO()
  {
    return (this.Nka & 0x1000) == 4096;
  }
  
  public final s<p> gmo()
  {
    return NjZ;
  }
  
  public final boolean goU()
  {
    return (this.Nka & 0x1) == 1;
  }
  
  public final boolean goV()
  {
    return (this.Nka & 0x2) == 2;
  }
  
  public final boolean goW()
  {
    return (this.Nka & 0x4) == 4;
  }
  
  public final boolean goX()
  {
    return (this.Nka & 0x8) == 8;
  }
  
  public final boolean goY()
  {
    return (this.Nka & 0x10) == 16;
  }
  
  public final boolean goZ()
  {
    return (this.Nka & 0x20) == 32;
  }
  
  public final boolean gpa()
  {
    return (this.Nka & 0x40) == 64;
  }
  
  public final boolean gpb()
  {
    return (this.Nka & 0x80) == 128;
  }
  
  public final boolean gpc()
  {
    return (this.Nka & 0x100) == 256;
  }
  
  public final boolean gpd()
  {
    return (this.Nka & 0x200) == 512;
  }
  
  public final boolean gpe()
  {
    return (this.Nka & 0x400) == 1024;
  }
  
  public final boolean gpf()
  {
    return (this.Nka & 0x800) == 2048;
  }
  
  public final b gpg()
  {
    AppMethodBeat.i(221692);
    b localb = b.gpq().j(this);
    AppMethodBeat.o(221692);
    return localb;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58858);
    int i = this.Nkd;
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
      if (!((a)this.Nkc.get(i)).isInitialized())
      {
        this.Nkd = 0;
        AppMethodBeat.o(58858);
        return false;
      }
      i += 1;
    }
    if ((goW()) && (!this.NmE.isInitialized()))
    {
      this.Nkd = 0;
      AppMethodBeat.o(58858);
      return false;
    }
    if ((gpc()) && (!this.NmK.isInitialized()))
    {
      this.Nkd = 0;
      AppMethodBeat.o(58858);
      return false;
    }
    if ((gpe()) && (!this.NmM.isInitialized()))
    {
      this.Nkd = 0;
      AppMethodBeat.o(58858);
      return false;
    }
    if (!this.Nra.isInitialized())
    {
      this.Nkd = 0;
      AppMethodBeat.o(58858);
      return false;
    }
    this.Nkd = 1;
    AppMethodBeat.o(58858);
    return true;
  }
  
  public final int zp()
  {
    int j = 0;
    AppMethodBeat.i(58860);
    int i = this.Nke;
    if (i != -1)
    {
      AppMethodBeat.o(58860);
      return i;
    }
    if ((this.Nka & 0x1000) == 4096) {
      i = f.bz(1, this.Nkt) + 0;
    }
    for (;;)
    {
      if (j < this.Nkc.size())
      {
        int k = f.c(2, (q)this.Nkc.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        j = i;
        if ((this.Nka & 0x1) == 1) {
          j = i + (f.fN(3) + 1);
        }
        i = j;
        if ((this.Nka & 0x2) == 2) {
          i = j + f.bz(4, this.NmD);
        }
        j = i;
        if ((this.Nka & 0x4) == 4) {
          j = i + f.c(5, this.NmE);
        }
        i = j;
        if ((this.Nka & 0x10) == 16) {
          i = j + f.bz(6, this.NmG);
        }
        j = i;
        if ((this.Nka & 0x20) == 32) {
          j = i + f.bz(7, this.NmH);
        }
        i = j;
        if ((this.Nka & 0x8) == 8) {
          i = j + f.bz(8, this.NmF);
        }
        j = i;
        if ((this.Nka & 0x40) == 64) {
          j = i + f.bz(9, this.NmI);
        }
        i = j;
        if ((this.Nka & 0x100) == 256) {
          i = j + f.c(10, this.NmK);
        }
        j = i;
        if ((this.Nka & 0x200) == 512) {
          j = i + f.bz(11, this.NmL);
        }
        i = j;
        if ((this.Nka & 0x80) == 128) {
          i = j + f.bz(12, this.NmJ);
        }
        j = i;
        if ((this.Nka & 0x400) == 1024) {
          j = i + f.c(13, this.NmM);
        }
        i = j;
        if ((this.Nka & 0x800) == 2048) {
          i = j + f.bz(14, this.NmN);
        }
        i = this.Nra.zp() + i + this.NjY.size();
        this.Nke = i;
        AppMethodBeat.o(58860);
        return i;
        i = 0;
      }
    }
  }
  
  public static final class a
    extends i
    implements r
  {
    public static s<a> NjZ;
    private static final a NmO;
    private final d NjY;
    private int Nka;
    private byte Nkd = -1;
    private int Nke = -1;
    public b NmP;
    public a.p NmQ;
    public int NmR;
    
    static
    {
      AppMethodBeat.i(58832);
      NjZ = new b() {};
      a locala = new a();
      NmO = locala;
      locala.gmq();
      AppMethodBeat.o(58832);
    }
    
    private a()
    {
      this.NjY = d.NqI;
    }
    
    /* Error */
    private a(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 63	d/l/b/a/b/h/i:<init>	()V
      //   4: ldc 80
      //   6: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 65	d/l/b/a/b/e/a$p$a:Nkd	B
      //   14: aload_0
      //   15: iconst_m1
      //   16: putfield 67	d/l/b/a/b/e/a$p$a:Nke	I
      //   19: aload_0
      //   20: invokespecial 58	d/l/b/a/b/e/a$p$a:gmq	()V
      //   23: invokestatic 84	d/l/b/a/b/h/d:grr	()Ld/l/b/a/b/h/d$b;
      //   26: astore 7
      //   28: aload 7
      //   30: iconst_1
      //   31: invokestatic 90	d/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Ld/l/b/a/b/h/f;
      //   34: astore 8
      //   36: iconst_0
      //   37: istore_3
      //   38: iload_3
      //   39: ifne +281 -> 320
      //   42: aload_1
      //   43: invokevirtual 96	d/l/b/a/b/h/e:zb	()I
      //   46: istore 4
      //   48: iload 4
      //   50: lookupswitch	default:+360->410, 0:+363->413, 8:+60->110, 18:+178->228, 24:+249->299
      //   93: aload_1
      //   94: aload 8
      //   96: aload_2
      //   97: iload 4
      //   99: invokevirtual 99	d/l/b/a/b/e/a$p$a:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/f;Ld/l/b/a/b/h/g;I)Z
      //   102: ifne -64 -> 38
      //   105: iconst_1
      //   106: istore_3
      //   107: goto -69 -> 38
      //   110: aload_1
      //   111: invokevirtual 102	d/l/b/a/b/h/e:zc	()I
      //   114: istore 5
      //   116: iload 5
      //   118: invokestatic 106	d/l/b/a/b/e/a$p$a$b:akh	(I)Ld/l/b/a/b/e/a$p$a$b;
      //   121: astore 6
      //   123: aload 6
      //   125: ifnonnull +59 -> 184
      //   128: aload 8
      //   130: iload 4
      //   132: invokevirtual 109	d/l/b/a/b/h/f:fO	(I)V
      //   135: aload 8
      //   137: iload 5
      //   139: invokevirtual 109	d/l/b/a/b/h/f:fO	(I)V
      //   142: goto -104 -> 38
      //   145: astore_1
      //   146: aload_1
      //   147: aload_0
      //   148: putfield 113	d/l/b/a/b/h/k:Nrq	Ld/l/b/a/b/h/q;
      //   151: ldc 80
      //   153: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   156: aload_1
      //   157: athrow
      //   158: astore_1
      //   159: aload 8
      //   161: invokevirtual 116	d/l/b/a/b/h/f:flush	()V
      //   164: aload_0
      //   165: aload 7
      //   167: invokevirtual 122	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
      //   170: putfield 74	d/l/b/a/b/e/a$p$a:NjY	Ld/l/b/a/b/h/d;
      //   173: aload_0
      //   174: invokevirtual 125	d/l/b/a/b/e/a$p$a:grN	()V
      //   177: ldc 80
      //   179: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   182: aload_1
      //   183: athrow
      //   184: aload_0
      //   185: aload_0
      //   186: getfield 127	d/l/b/a/b/e/a$p$a:Nka	I
      //   189: iconst_1
      //   190: ior
      //   191: putfield 127	d/l/b/a/b/e/a$p$a:Nka	I
      //   194: aload_0
      //   195: aload 6
      //   197: putfield 129	d/l/b/a/b/e/a$p$a:NmP	Ld/l/b/a/b/e/a$p$a$b;
      //   200: goto -162 -> 38
      //   203: astore_1
      //   204: new 77	d/l/b/a/b/h/k
      //   207: dup
      //   208: aload_1
      //   209: invokevirtual 133	java/io/IOException:getMessage	()Ljava/lang/String;
      //   212: invokespecial 136	d/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
      //   215: astore_1
      //   216: aload_1
      //   217: aload_0
      //   218: putfield 113	d/l/b/a/b/h/k:Nrq	Ld/l/b/a/b/h/q;
      //   221: ldc 80
      //   223: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   226: aload_1
      //   227: athrow
      //   228: aload_0
      //   229: getfield 127	d/l/b/a/b/e/a$p$a:Nka	I
      //   232: iconst_2
      //   233: iand
      //   234: iconst_2
      //   235: if_icmpne +169 -> 404
      //   238: aload_0
      //   239: getfield 138	d/l/b/a/b/e/a$p$a:NmQ	Ld/l/b/a/b/e/a$p;
      //   242: invokevirtual 142	d/l/b/a/b/e/a$p:gpg	()Ld/l/b/a/b/e/a$p$b;
      //   245: astore 6
      //   247: aload_0
      //   248: aload_1
      //   249: getstatic 143	d/l/b/a/b/e/a$p:NjZ	Ld/l/b/a/b/h/s;
      //   252: aload_2
      //   253: invokevirtual 146	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
      //   256: checkcast 8	d/l/b/a/b/e/a$p
      //   259: putfield 138	d/l/b/a/b/e/a$p$a:NmQ	Ld/l/b/a/b/e/a$p;
      //   262: aload 6
      //   264: ifnull +22 -> 286
      //   267: aload 6
      //   269: aload_0
      //   270: getfield 138	d/l/b/a/b/e/a$p$a:NmQ	Ld/l/b/a/b/e/a$p;
      //   273: invokevirtual 152	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
      //   276: pop
      //   277: aload_0
      //   278: aload 6
      //   280: invokevirtual 156	d/l/b/a/b/e/a$p$b:gpp	()Ld/l/b/a/b/e/a$p;
      //   283: putfield 138	d/l/b/a/b/e/a$p$a:NmQ	Ld/l/b/a/b/e/a$p;
      //   286: aload_0
      //   287: aload_0
      //   288: getfield 127	d/l/b/a/b/e/a$p$a:Nka	I
      //   291: iconst_2
      //   292: ior
      //   293: putfield 127	d/l/b/a/b/e/a$p$a:Nka	I
      //   296: goto -258 -> 38
      //   299: aload_0
      //   300: aload_0
      //   301: getfield 127	d/l/b/a/b/e/a$p$a:Nka	I
      //   304: iconst_4
      //   305: ior
      //   306: putfield 127	d/l/b/a/b/e/a$p$a:Nka	I
      //   309: aload_0
      //   310: aload_1
      //   311: invokevirtual 102	d/l/b/a/b/h/e:zc	()I
      //   314: putfield 158	d/l/b/a/b/e/a$p$a:NmR	I
      //   317: goto -279 -> 38
      //   320: aload 8
      //   322: invokevirtual 116	d/l/b/a/b/h/f:flush	()V
      //   325: aload_0
      //   326: aload 7
      //   328: invokevirtual 122	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
      //   331: putfield 74	d/l/b/a/b/e/a$p$a:NjY	Ld/l/b/a/b/h/d;
      //   334: aload_0
      //   335: invokevirtual 125	d/l/b/a/b/e/a$p$a:grN	()V
      //   338: ldc 80
      //   340: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   343: return
      //   344: astore_1
      //   345: aload_0
      //   346: aload 7
      //   348: invokevirtual 122	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
      //   351: putfield 74	d/l/b/a/b/e/a$p$a:NjY	Ld/l/b/a/b/h/d;
      //   354: goto -20 -> 334
      //   357: astore_1
      //   358: aload_0
      //   359: aload 7
      //   361: invokevirtual 122	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
      //   364: putfield 74	d/l/b/a/b/e/a$p$a:NjY	Ld/l/b/a/b/h/d;
      //   367: ldc 80
      //   369: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   372: aload_1
      //   373: athrow
      //   374: astore_2
      //   375: aload_0
      //   376: aload 7
      //   378: invokevirtual 122	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
      //   381: putfield 74	d/l/b/a/b/e/a$p$a:NjY	Ld/l/b/a/b/h/d;
      //   384: goto -211 -> 173
      //   387: astore_1
      //   388: aload_0
      //   389: aload 7
      //   391: invokevirtual 122	d/l/b/a/b/h/d$b:grv	()Ld/l/b/a/b/h/d;
      //   394: putfield 74	d/l/b/a/b/e/a$p$a:NjY	Ld/l/b/a/b/h/d;
      //   397: ldc 80
      //   399: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   0	418	1	parame	d.l.b.a.b.h.e
      //   0	418	2	paramg	d.l.b.a.b.h.g
      //   37	378	3	i	int
      //   46	85	4	j	int
      //   114	24	5	k	int
      //   121	285	6	localObject	Object
      //   26	364	7	localb	d.l.b.a.b.h.d.b
      //   34	287	8	localf	f
      // Exception table:
      //   from	to	target	type
      //   42	48	145	d/l/b/a/b/h/k
      //   92	105	145	d/l/b/a/b/h/k
      //   110	123	145	d/l/b/a/b/h/k
      //   128	142	145	d/l/b/a/b/h/k
      //   184	200	145	d/l/b/a/b/h/k
      //   228	247	145	d/l/b/a/b/h/k
      //   247	262	145	d/l/b/a/b/h/k
      //   267	286	145	d/l/b/a/b/h/k
      //   286	296	145	d/l/b/a/b/h/k
      //   299	317	145	d/l/b/a/b/h/k
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
      this.NjY = parama.NjY;
    }
    
    private void gmq()
    {
      AppMethodBeat.i(58826);
      this.NmP = b.NmU;
      this.NmQ = a.p.goT();
      this.NmR = 0;
      AppMethodBeat.o(58826);
    }
    
    public static a gph()
    {
      return NmO;
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(58828);
      zp();
      if ((this.Nka & 0x1) == 1) {
        paramf.lr(1, this.NmP.value);
      }
      if ((this.Nka & 0x2) == 2) {
        paramf.a(2, this.NmQ);
      }
      if ((this.Nka & 0x4) == 4) {
        paramf.bx(3, this.NmR);
      }
      paramf.e(this.NjY);
      AppMethodBeat.o(58828);
    }
    
    public final boolean gmF()
    {
      return (this.Nka & 0x2) == 2;
    }
    
    public final s<a> gmo()
    {
      return NjZ;
    }
    
    public final boolean gpi()
    {
      return (this.Nka & 0x1) == 1;
    }
    
    public final boolean gpj()
    {
      return (this.Nka & 0x4) == 4;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58827);
      int i = this.Nkd;
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
      if ((gmF()) && (!this.NmQ.isInitialized()))
      {
        this.Nkd = 0;
        AppMethodBeat.o(58827);
        return false;
      }
      this.Nkd = 1;
      AppMethodBeat.o(58827);
      return true;
    }
    
    public final int zp()
    {
      AppMethodBeat.i(58829);
      int i = this.Nke;
      if (i != -1)
      {
        AppMethodBeat.o(58829);
        return i;
      }
      int j = 0;
      if ((this.Nka & 0x1) == 1) {
        j = f.ls(1, this.NmP.value) + 0;
      }
      i = j;
      if ((this.Nka & 0x2) == 2) {
        i = j + f.c(2, this.NmQ);
      }
      j = i;
      if ((this.Nka & 0x4) == 4) {
        j = i + f.bz(3, this.NmR);
      }
      i = j + this.NjY.size();
      this.Nke = i;
      AppMethodBeat.o(58829);
      return i;
    }
    
    public static final class a
      extends i.a<a.p.a, a>
      implements r
    {
      private int Nka;
      private a.p.a.b NmP;
      private a.p NmQ;
      private int NmR;
      
      private a()
      {
        AppMethodBeat.i(58803);
        this.NmP = a.p.a.b.NmU;
        this.NmQ = a.p.goT();
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
        this.Nka |= 0x1;
        this.NmP = paramb;
        AppMethodBeat.o(58809);
        return this;
      }
      
      private a akg(int paramInt)
      {
        this.Nka |= 0x4;
        this.NmR = paramInt;
        return this;
      }
      
      private a gpk()
      {
        AppMethodBeat.i(58804);
        a locala = new a().b(gpl());
        AppMethodBeat.o(58804);
        return locala;
      }
      
      private a.p.a gpl()
      {
        int j = 1;
        AppMethodBeat.i(58805);
        a.p.a locala = new a.p.a(this, (byte)0);
        int k = this.Nka;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          a.p.a.a(locala, this.NmP);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          a.p.a.a(locala, this.NmQ);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          a.p.a.a(locala, this.NmR);
          a.p.a.b(locala, j);
          AppMethodBeat.o(58805);
          return locala;
          j = 0;
        }
      }
      
      private a i(a.p paramp)
      {
        AppMethodBeat.i(58810);
        if (((this.Nka & 0x2) == 2) && (this.NmQ != a.p.goT())) {}
        for (this.NmQ = a.p.f(this.NmQ).j(paramp).gpp();; this.NmQ = paramp)
        {
          this.Nka |= 0x2;
          AppMethodBeat.o(58810);
          return this;
        }
      }
      
      /* Error */
      private a t(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
      {
        // Byte code:
        //   0: ldc 109
        //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 113	d/l/b/a/b/e/a$p$a:NjZ	Ld/l/b/a/b/h/s;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 118 3 0
        //   17: checkcast 14	d/l/b/a/b/e/a$p$a
        //   20: astore_1
        //   21: aload_0
        //   22: aload_1
        //   23: invokevirtual 73	d/l/b/a/b/e/a$p$a$a:b	(Ld/l/b/a/b/e/a$p$a;)Ld/l/b/a/b/e/a$p$a$a;
        //   26: pop
        //   27: ldc 109
        //   29: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   32: aload_0
        //   33: areturn
        //   34: astore_1
        //   35: aload_1
        //   36: getfield 122	d/l/b/a/b/h/k:Nrq	Ld/l/b/a/b/h/q;
        //   39: checkcast 14	d/l/b/a/b/e/a$p$a
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
        //   57: invokevirtual 73	d/l/b/a/b/e/a$p$a$a:b	(Ld/l/b/a/b/e/a$p$a;)Ld/l/b/a/b/e/a$p$a$a;
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
        //   0	74	1	parame	d.l.b.a.b.h.e
        //   0	74	2	paramg	d.l.b.a.b.h.g
        //   6	64	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	34	d/l/b/a/b/h/k
        //   43	50	50	finally
        //   7	21	68	finally
        //   35	43	68	finally
      }
      
      public final a b(a.p.a parama)
      {
        AppMethodBeat.i(58806);
        if (parama == a.p.a.gph())
        {
          AppMethodBeat.o(58806);
          return this;
        }
        if (parama.gpi()) {
          a(parama.NmP);
        }
        if (parama.gmF()) {
          i(parama.NmQ);
        }
        if (parama.gpj()) {
          akg(parama.NmR);
        }
        this.NjY = this.NjY.a(a.p.a.a(parama));
        AppMethodBeat.o(58806);
        return this;
      }
      
      public final boolean isInitialized()
      {
        AppMethodBeat.i(58807);
        if ((this.Nka & 0x2) == 2) {}
        for (int i = 1; (i != 0) && (!this.NmQ.isInitialized()); i = 0)
        {
          AppMethodBeat.o(58807);
          return false;
        }
        AppMethodBeat.o(58807);
        return true;
      }
    }
    
    public static enum b
      implements j.a
    {
      private static j.b<b> NkH;
      final int value;
      
      static
      {
        AppMethodBeat.i(58824);
        NmS = new b("IN", 0, 0);
        NmT = new b("OUT", 1, 1);
        NmU = new b("INV", 2, 2);
        NmV = new b("STAR", 3, 3);
        NmW = new b[] { NmS, NmT, NmU, NmV };
        NkH = new j.b() {};
        AppMethodBeat.o(58824);
      }
      
      private b(int paramInt1, int paramInt2)
      {
        this.value = paramInt1;
      }
      
      public static b akh(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 0: 
          return NmS;
        case 1: 
          return NmT;
        case 2: 
          return NmU;
        }
        return NmV;
      }
      
      public final int getNumber()
      {
        return this.value;
      }
    }
  }
  
  public static final class b
    extends i.b<a.p, b>
    implements t
  {
    private int Nka;
    private List<a.p.a> Nkc;
    private int Nkt;
    private boolean NmC;
    private int NmD;
    private a.p NmE;
    private int NmF;
    private int NmG;
    private int NmH;
    private int NmI;
    private int NmJ;
    private a.p NmK;
    private int NmL;
    private a.p NmM;
    private int NmN;
    
    private b()
    {
      AppMethodBeat.i(58833);
      this.Nkc = Collections.emptyList();
      this.NmE = a.p.goT();
      this.NmK = a.p.goT();
      this.NmM = a.p.goT();
      AppMethodBeat.o(58833);
    }
    
    private b aki(int paramInt)
    {
      this.Nka |= 0x4;
      this.NmD = paramInt;
      return this;
    }
    
    private b akj(int paramInt)
    {
      this.Nka |= 0x10;
      this.NmF = paramInt;
      return this;
    }
    
    private b akk(int paramInt)
    {
      this.Nka |= 0x20;
      this.NmG = paramInt;
      return this;
    }
    
    private b akl(int paramInt)
    {
      this.Nka |= 0x40;
      this.NmH = paramInt;
      return this;
    }
    
    private b akm(int paramInt)
    {
      this.Nka |= 0x80;
      this.NmI = paramInt;
      return this;
    }
    
    private b akn(int paramInt)
    {
      this.Nka |= 0x100;
      this.NmJ = paramInt;
      return this;
    }
    
    private b ako(int paramInt)
    {
      this.Nka |= 0x400;
      this.NmL = paramInt;
      return this;
    }
    
    private b akp(int paramInt)
    {
      this.Nka |= 0x1000;
      this.NmN = paramInt;
      return this;
    }
    
    private b akq(int paramInt)
    {
      this.Nka |= 0x2000;
      this.Nkt = paramInt;
      return this;
    }
    
    private void gmV()
    {
      AppMethodBeat.i(58840);
      if ((this.Nka & 0x1) != 1)
      {
        this.Nkc = new ArrayList(this.Nkc);
        this.Nka |= 0x1;
      }
      AppMethodBeat.o(58840);
    }
    
    private b gpn()
    {
      AppMethodBeat.i(58834);
      b localb = new b().j(gpp());
      AppMethodBeat.o(58834);
      return localb;
    }
    
    private b k(a.p paramp)
    {
      AppMethodBeat.i(58841);
      if (((this.Nka & 0x8) == 8) && (this.NmE != a.p.goT())) {}
      for (this.NmE = a.p.f(this.NmE).j(paramp).gpp();; this.NmE = paramp)
      {
        this.Nka |= 0x8;
        AppMethodBeat.o(58841);
        return this;
      }
    }
    
    private b l(a.p paramp)
    {
      AppMethodBeat.i(58842);
      if (((this.Nka & 0x200) == 512) && (this.NmK != a.p.goT())) {}
      for (this.NmK = a.p.f(this.NmK).j(paramp).gpp();; this.NmK = paramp)
      {
        this.Nka |= 0x200;
        AppMethodBeat.o(58842);
        return this;
      }
    }
    
    private b m(a.p paramp)
    {
      AppMethodBeat.i(58843);
      if (((this.Nka & 0x800) == 2048) && (this.NmM != a.p.goT())) {}
      for (this.NmM = a.p.f(this.NmM).j(paramp).gpp();; this.NmM = paramp)
      {
        this.Nka |= 0x800;
        AppMethodBeat.o(58843);
        return this;
      }
    }
    
    /* Error */
    private b u(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 130
      //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 134	d/l/b/a/b/e/a$p:NjZ	Ld/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 140 3 0
      //   17: checkcast 9	d/l/b/a/b/e/a$p
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 114	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
      //   26: pop
      //   27: ldc 130
      //   29: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 144	d/l/b/a/b/h/k:Nrq	Ld/l/b/a/b/h/q;
      //   39: checkcast 9	d/l/b/a/b/e/a$p
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
      //   57: invokevirtual 114	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
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
      //   0	74	1	parame	d.l.b.a.b.h.e
      //   0	74	2	paramg	d.l.b.a.b.h.g
      //   6	64	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	d/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final b Ad(boolean paramBoolean)
    {
      this.Nka |= 0x2;
      this.NmC = paramBoolean;
      return this;
    }
    
    public final a.p gpo()
    {
      AppMethodBeat.i(58835);
      Object localObject = gpp();
      if (!((a.p)localObject).isInitialized())
      {
        localObject = new w();
        AppMethodBeat.o(58835);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(58835);
      return localObject;
    }
    
    public final a.p gpp()
    {
      int j = 1;
      AppMethodBeat.i(58836);
      a.p localp = new a.p(this, (byte)0);
      int k = this.Nka;
      if ((this.Nka & 0x1) == 1)
      {
        this.Nkc = Collections.unmodifiableList(this.Nkc);
        this.Nka &= 0xFFFFFFFE;
      }
      a.p.a(localp, this.Nkc);
      if ((k & 0x2) == 2) {}
      for (;;)
      {
        a.p.a(localp, this.NmC);
        int i = j;
        if ((k & 0x4) == 4) {
          i = j | 0x2;
        }
        a.p.a(localp, this.NmD);
        j = i;
        if ((k & 0x8) == 8) {
          j = i | 0x4;
        }
        a.p.a(localp, this.NmE);
        i = j;
        if ((k & 0x10) == 16) {
          i = j | 0x8;
        }
        a.p.b(localp, this.NmF);
        j = i;
        if ((k & 0x20) == 32) {
          j = i | 0x10;
        }
        a.p.c(localp, this.NmG);
        i = j;
        if ((k & 0x40) == 64) {
          i = j | 0x20;
        }
        a.p.d(localp, this.NmH);
        j = i;
        if ((k & 0x80) == 128) {
          j = i | 0x40;
        }
        a.p.e(localp, this.NmI);
        i = j;
        if ((k & 0x100) == 256) {
          i = j | 0x80;
        }
        a.p.f(localp, this.NmJ);
        j = i;
        if ((k & 0x200) == 512) {
          j = i | 0x100;
        }
        a.p.b(localp, this.NmK);
        i = j;
        if ((k & 0x400) == 1024) {
          i = j | 0x200;
        }
        a.p.g(localp, this.NmL);
        j = i;
        if ((k & 0x800) == 2048) {
          j = i | 0x400;
        }
        a.p.c(localp, this.NmM);
        i = j;
        if ((k & 0x1000) == 4096) {
          i = j | 0x800;
        }
        a.p.h(localp, this.NmN);
        j = i;
        if ((k & 0x2000) == 8192) {
          j = i | 0x1000;
        }
        a.p.i(localp, this.Nkt);
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
      while (i < this.Nkc.size())
      {
        if (!((a.p.a)this.Nkc.get(i)).isInitialized())
        {
          AppMethodBeat.o(58838);
          return false;
        }
        i += 1;
      }
      if ((this.Nka & 0x8) == 8) {}
      for (i = 1; (i != 0) && (!this.NmE.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58838);
        return false;
      }
      if ((this.Nka & 0x200) == 512) {}
      for (i = 1; (i != 0) && (!this.NmK.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58838);
        return false;
      }
      if ((this.Nka & 0x800) == 2048) {}
      for (i = 1; (i != 0) && (!this.NmM.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58838);
        return false;
      }
      if (!this.Nra.isInitialized())
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
      if (paramp == a.p.goT())
      {
        AppMethodBeat.o(58837);
        return this;
      }
      if (!a.p.g(paramp).isEmpty())
      {
        if (!this.Nkc.isEmpty()) {
          break label300;
        }
        this.Nkc = a.p.g(paramp);
        this.Nka &= 0xFFFFFFFE;
      }
      for (;;)
      {
        if (paramp.goU()) {
          Ad(paramp.NmC);
        }
        if (paramp.goV()) {
          aki(paramp.NmD);
        }
        if (paramp.goW()) {
          k(paramp.NmE);
        }
        if (paramp.goX()) {
          akj(paramp.NmF);
        }
        if (paramp.goY()) {
          akk(paramp.NmG);
        }
        if (paramp.goZ()) {
          akl(paramp.NmH);
        }
        if (paramp.gpa()) {
          akm(paramp.NmI);
        }
        if (paramp.gpb()) {
          akn(paramp.NmJ);
        }
        if (paramp.gpc()) {
          l(paramp.NmK);
        }
        if (paramp.gpd()) {
          ako(paramp.NmL);
        }
        if (paramp.gpe()) {
          m(paramp.NmM);
        }
        if (paramp.gpf()) {
          akp(paramp.NmN);
        }
        if (paramp.gmO()) {
          akq(paramp.Nkt);
        }
        a(paramp);
        this.NjY = this.NjY.a(a.p.h(paramp));
        AppMethodBeat.o(58837);
        return this;
        label300:
        gmV();
        this.Nkc.addAll(a.p.g(paramp));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.a.p
 * JD-Core Version:    0.7.0.1
 */