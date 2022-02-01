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
  public static s<p> Ltc;
  private static final p LvE;
  private final d Ltb;
  private int Ltd;
  public List<a> Ltf;
  private byte Ltg = -1;
  private int Lth = -1;
  public int Ltw;
  public boolean LvF;
  public int LvG;
  public p LvH;
  public int LvI;
  public int LvJ;
  public int LvK;
  public int LvL;
  public int LvM;
  public p LvN;
  public int LvO;
  public p LvP;
  public int LvQ;
  
  static
  {
    AppMethodBeat.i(58865);
    Ltc = new b() {};
    p localp = new p();
    LvE = localp;
    localp.fUR();
    AppMethodBeat.o(58865);
  }
  
  private a$p()
  {
    this.Ltb = d.LzL;
  }
  
  /* Error */
  private a$p(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 78	d/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 95
    //   6: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 80	d/l/b/a/b/e/a$p:Ltg	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 82	d/l/b/a/b/e/a$p:Lth	I
    //   19: aload_0
    //   20: invokespecial 73	d/l/b/a/b/e/a$p:fUR	()V
    //   23: invokestatic 99	d/l/b/a/b/h/d:fZS	()Ld/l/b/a/b/h/d$b;
    //   26: astore 10
    //   28: aload 10
    //   30: iconst_1
    //   31: invokestatic 105	d/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Ld/l/b/a/b/h/f;
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
    //   56: invokevirtual 111	d/l/b/a/b/h/e:xE	()I
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
    //   208: invokevirtual 114	d/l/b/a/b/e/a$p:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/f;Ld/l/b/a/b/h/g;I)Z
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
    //   231: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   234: sipush 4096
    //   237: ior
    //   238: putfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   241: iload_3
    //   242: istore 7
    //   244: iload_3
    //   245: istore 5
    //   247: iload_3
    //   248: istore 8
    //   250: aload_0
    //   251: aload_1
    //   252: invokevirtual 119	d/l/b/a/b/h/e:xF	()I
    //   255: putfield 121	d/l/b/a/b/e/a$p:Ltw	I
    //   258: goto -217 -> 41
    //   261: astore_1
    //   262: iload 7
    //   264: istore 5
    //   266: aload_1
    //   267: aload_0
    //   268: putfield 125	d/l/b/a/b/h/k:LAt	Ld/l/b/a/b/h/q;
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
    //   297: getfield 127	d/l/b/a/b/e/a$p:Ltf	Ljava/util/List;
    //   300: invokestatic 133	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   303: putfield 127	d/l/b/a/b/e/a$p:Ltf	Ljava/util/List;
    //   306: aload 11
    //   308: invokevirtual 136	d/l/b/a/b/h/f:flush	()V
    //   311: aload_0
    //   312: aload 10
    //   314: invokevirtual 142	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   317: putfield 89	d/l/b/a/b/e/a$p:Ltb	Ld/l/b/a/b/h/d;
    //   320: aload_0
    //   321: getfield 146	d/l/b/a/b/h/i$c:LAd	Ld/l/b/a/b/h/h;
    //   324: invokevirtual 151	d/l/b/a/b/h/h:gai	()V
    //   327: ldc 95
    //   329: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   354: new 153	java/util/ArrayList
    //   357: dup
    //   358: invokespecial 154	java/util/ArrayList:<init>	()V
    //   361: putfield 127	d/l/b/a/b/e/a$p:Ltf	Ljava/util/List;
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
    //   382: getfield 127	d/l/b/a/b/e/a$p:Ltf	Ljava/util/List;
    //   385: aload_1
    //   386: getstatic 155	d/l/b/a/b/e/a$p$a:Ltc	Ld/l/b/a/b/h/s;
    //   389: aload_2
    //   390: invokevirtual 158	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   393: invokeinterface 164 2 0
    //   398: pop
    //   399: iload 4
    //   401: istore_3
    //   402: goto -361 -> 41
    //   405: astore_1
    //   406: iload 8
    //   408: istore 5
    //   410: new 92	d/l/b/a/b/h/k
    //   413: dup
    //   414: aload_1
    //   415: invokevirtual 168	java/io/IOException:getMessage	()Ljava/lang/String;
    //   418: invokespecial 171	d/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   421: astore_1
    //   422: iload 8
    //   424: istore 5
    //   426: aload_1
    //   427: aload_0
    //   428: putfield 125	d/l/b/a/b/h/k:LAt	Ld/l/b/a/b/h/q;
    //   431: iload 8
    //   433: istore 5
    //   435: ldc 95
    //   437: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   457: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   460: iconst_1
    //   461: ior
    //   462: putfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   465: iload_3
    //   466: istore 7
    //   468: iload_3
    //   469: istore 5
    //   471: iload_3
    //   472: istore 8
    //   474: aload_0
    //   475: aload_1
    //   476: invokevirtual 175	d/l/b/a/b/h/e:fZX	()Z
    //   479: putfield 177	d/l/b/a/b/e/a$p:LvF	Z
    //   482: goto -441 -> 41
    //   485: iload_3
    //   486: istore 7
    //   488: iload_3
    //   489: istore 5
    //   491: iload_3
    //   492: istore 8
    //   494: aload_0
    //   495: aload_0
    //   496: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   499: iconst_2
    //   500: ior
    //   501: putfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   504: iload_3
    //   505: istore 7
    //   507: iload_3
    //   508: istore 5
    //   510: iload_3
    //   511: istore 8
    //   513: aload_0
    //   514: aload_1
    //   515: invokevirtual 119	d/l/b/a/b/h/e:xF	()I
    //   518: putfield 179	d/l/b/a/b/e/a$p:LvG	I
    //   521: goto -480 -> 41
    //   524: iload_3
    //   525: istore 7
    //   527: iload_3
    //   528: istore 5
    //   530: iload_3
    //   531: istore 8
    //   533: aload_0
    //   534: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
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
    //   553: getfield 181	d/l/b/a/b/e/a$p:LvH	Ld/l/b/a/b/e/a$p;
    //   556: astore 9
    //   558: iload_3
    //   559: istore 7
    //   561: iload_3
    //   562: istore 5
    //   564: iload_3
    //   565: istore 8
    //   567: invokestatic 185	d/l/b/a/b/e/a$p$b:fXR	()Ld/l/b/a/b/e/a$p$b;
    //   570: aload 9
    //   572: invokevirtual 189	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   575: astore 9
    //   577: iload_3
    //   578: istore 7
    //   580: iload_3
    //   581: istore 5
    //   583: iload_3
    //   584: istore 8
    //   586: aload_0
    //   587: aload_1
    //   588: getstatic 67	d/l/b/a/b/e/a$p:Ltc	Ld/l/b/a/b/h/s;
    //   591: aload_2
    //   592: invokevirtual 158	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   595: checkcast 2	d/l/b/a/b/e/a$p
    //   598: putfield 181	d/l/b/a/b/e/a$p:LvH	Ld/l/b/a/b/e/a$p;
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
    //   618: getfield 181	d/l/b/a/b/e/a$p:LvH	Ld/l/b/a/b/e/a$p;
    //   621: invokevirtual 189	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   624: pop
    //   625: iload_3
    //   626: istore 7
    //   628: iload_3
    //   629: istore 5
    //   631: iload_3
    //   632: istore 8
    //   634: aload_0
    //   635: aload 9
    //   637: invokevirtual 193	d/l/b/a/b/e/a$p$b:fXQ	()Ld/l/b/a/b/e/a$p;
    //   640: putfield 181	d/l/b/a/b/e/a$p:LvH	Ld/l/b/a/b/e/a$p;
    //   643: iload_3
    //   644: istore 7
    //   646: iload_3
    //   647: istore 5
    //   649: iload_3
    //   650: istore 8
    //   652: aload_0
    //   653: aload_0
    //   654: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   657: iconst_4
    //   658: ior
    //   659: putfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   662: goto -621 -> 41
    //   665: iload_3
    //   666: istore 7
    //   668: iload_3
    //   669: istore 5
    //   671: iload_3
    //   672: istore 8
    //   674: aload_0
    //   675: aload_0
    //   676: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   679: bipush 16
    //   681: ior
    //   682: putfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   685: iload_3
    //   686: istore 7
    //   688: iload_3
    //   689: istore 5
    //   691: iload_3
    //   692: istore 8
    //   694: aload_0
    //   695: aload_1
    //   696: invokevirtual 119	d/l/b/a/b/h/e:xF	()I
    //   699: putfield 195	d/l/b/a/b/e/a$p:LvJ	I
    //   702: goto -661 -> 41
    //   705: iload_3
    //   706: istore 7
    //   708: iload_3
    //   709: istore 5
    //   711: iload_3
    //   712: istore 8
    //   714: aload_0
    //   715: aload_0
    //   716: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   719: bipush 32
    //   721: ior
    //   722: putfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   725: iload_3
    //   726: istore 7
    //   728: iload_3
    //   729: istore 5
    //   731: iload_3
    //   732: istore 8
    //   734: aload_0
    //   735: aload_1
    //   736: invokevirtual 119	d/l/b/a/b/h/e:xF	()I
    //   739: putfield 197	d/l/b/a/b/e/a$p:LvK	I
    //   742: goto -701 -> 41
    //   745: iload_3
    //   746: istore 7
    //   748: iload_3
    //   749: istore 5
    //   751: iload_3
    //   752: istore 8
    //   754: aload_0
    //   755: aload_0
    //   756: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   759: bipush 8
    //   761: ior
    //   762: putfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   765: iload_3
    //   766: istore 7
    //   768: iload_3
    //   769: istore 5
    //   771: iload_3
    //   772: istore 8
    //   774: aload_0
    //   775: aload_1
    //   776: invokevirtual 119	d/l/b/a/b/h/e:xF	()I
    //   779: putfield 199	d/l/b/a/b/e/a$p:LvI	I
    //   782: goto -741 -> 41
    //   785: iload_3
    //   786: istore 7
    //   788: iload_3
    //   789: istore 5
    //   791: iload_3
    //   792: istore 8
    //   794: aload_0
    //   795: aload_0
    //   796: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   799: bipush 64
    //   801: ior
    //   802: putfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   805: iload_3
    //   806: istore 7
    //   808: iload_3
    //   809: istore 5
    //   811: iload_3
    //   812: istore 8
    //   814: aload_0
    //   815: aload_1
    //   816: invokevirtual 119	d/l/b/a/b/h/e:xF	()I
    //   819: putfield 201	d/l/b/a/b/e/a$p:LvL	I
    //   822: goto -781 -> 41
    //   825: iload_3
    //   826: istore 7
    //   828: iload_3
    //   829: istore 5
    //   831: iload_3
    //   832: istore 8
    //   834: aload_0
    //   835: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
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
    //   858: getfield 203	d/l/b/a/b/e/a$p:LvN	Ld/l/b/a/b/e/a$p;
    //   861: astore 9
    //   863: iload_3
    //   864: istore 7
    //   866: iload_3
    //   867: istore 5
    //   869: iload_3
    //   870: istore 8
    //   872: invokestatic 185	d/l/b/a/b/e/a$p$b:fXR	()Ld/l/b/a/b/e/a$p$b;
    //   875: aload 9
    //   877: invokevirtual 189	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   880: astore 9
    //   882: iload_3
    //   883: istore 7
    //   885: iload_3
    //   886: istore 5
    //   888: iload_3
    //   889: istore 8
    //   891: aload_0
    //   892: aload_1
    //   893: getstatic 67	d/l/b/a/b/e/a$p:Ltc	Ld/l/b/a/b/h/s;
    //   896: aload_2
    //   897: invokevirtual 158	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   900: checkcast 2	d/l/b/a/b/e/a$p
    //   903: putfield 203	d/l/b/a/b/e/a$p:LvN	Ld/l/b/a/b/e/a$p;
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
    //   923: getfield 203	d/l/b/a/b/e/a$p:LvN	Ld/l/b/a/b/e/a$p;
    //   926: invokevirtual 189	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   929: pop
    //   930: iload_3
    //   931: istore 7
    //   933: iload_3
    //   934: istore 5
    //   936: iload_3
    //   937: istore 8
    //   939: aload_0
    //   940: aload 9
    //   942: invokevirtual 193	d/l/b/a/b/e/a$p$b:fXQ	()Ld/l/b/a/b/e/a$p;
    //   945: putfield 203	d/l/b/a/b/e/a$p:LvN	Ld/l/b/a/b/e/a$p;
    //   948: iload_3
    //   949: istore 7
    //   951: iload_3
    //   952: istore 5
    //   954: iload_3
    //   955: istore 8
    //   957: aload_0
    //   958: aload_0
    //   959: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   962: sipush 256
    //   965: ior
    //   966: putfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   969: goto -928 -> 41
    //   972: iload_3
    //   973: istore 7
    //   975: iload_3
    //   976: istore 5
    //   978: iload_3
    //   979: istore 8
    //   981: aload_0
    //   982: aload_0
    //   983: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   986: sipush 512
    //   989: ior
    //   990: putfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   993: iload_3
    //   994: istore 7
    //   996: iload_3
    //   997: istore 5
    //   999: iload_3
    //   1000: istore 8
    //   1002: aload_0
    //   1003: aload_1
    //   1004: invokevirtual 119	d/l/b/a/b/h/e:xF	()I
    //   1007: putfield 205	d/l/b/a/b/e/a$p:LvO	I
    //   1010: goto -969 -> 41
    //   1013: iload_3
    //   1014: istore 7
    //   1016: iload_3
    //   1017: istore 5
    //   1019: iload_3
    //   1020: istore 8
    //   1022: aload_0
    //   1023: aload_0
    //   1024: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   1027: sipush 128
    //   1030: ior
    //   1031: putfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   1034: iload_3
    //   1035: istore 7
    //   1037: iload_3
    //   1038: istore 5
    //   1040: iload_3
    //   1041: istore 8
    //   1043: aload_0
    //   1044: aload_1
    //   1045: invokevirtual 119	d/l/b/a/b/h/e:xF	()I
    //   1048: putfield 207	d/l/b/a/b/e/a$p:LvM	I
    //   1051: goto -1010 -> 41
    //   1054: iload_3
    //   1055: istore 7
    //   1057: iload_3
    //   1058: istore 5
    //   1060: iload_3
    //   1061: istore 8
    //   1063: aload_0
    //   1064: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
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
    //   1087: getfield 209	d/l/b/a/b/e/a$p:LvP	Ld/l/b/a/b/e/a$p;
    //   1090: astore 9
    //   1092: iload_3
    //   1093: istore 7
    //   1095: iload_3
    //   1096: istore 5
    //   1098: iload_3
    //   1099: istore 8
    //   1101: invokestatic 185	d/l/b/a/b/e/a$p$b:fXR	()Ld/l/b/a/b/e/a$p$b;
    //   1104: aload 9
    //   1106: invokevirtual 189	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   1109: astore 9
    //   1111: iload_3
    //   1112: istore 7
    //   1114: iload_3
    //   1115: istore 5
    //   1117: iload_3
    //   1118: istore 8
    //   1120: aload_0
    //   1121: aload_1
    //   1122: getstatic 67	d/l/b/a/b/e/a$p:Ltc	Ld/l/b/a/b/h/s;
    //   1125: aload_2
    //   1126: invokevirtual 158	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   1129: checkcast 2	d/l/b/a/b/e/a$p
    //   1132: putfield 209	d/l/b/a/b/e/a$p:LvP	Ld/l/b/a/b/e/a$p;
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
    //   1152: getfield 209	d/l/b/a/b/e/a$p:LvP	Ld/l/b/a/b/e/a$p;
    //   1155: invokevirtual 189	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
    //   1158: pop
    //   1159: iload_3
    //   1160: istore 7
    //   1162: iload_3
    //   1163: istore 5
    //   1165: iload_3
    //   1166: istore 8
    //   1168: aload_0
    //   1169: aload 9
    //   1171: invokevirtual 193	d/l/b/a/b/e/a$p$b:fXQ	()Ld/l/b/a/b/e/a$p;
    //   1174: putfield 209	d/l/b/a/b/e/a$p:LvP	Ld/l/b/a/b/e/a$p;
    //   1177: iload_3
    //   1178: istore 7
    //   1180: iload_3
    //   1181: istore 5
    //   1183: iload_3
    //   1184: istore 8
    //   1186: aload_0
    //   1187: aload_0
    //   1188: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   1191: sipush 1024
    //   1194: ior
    //   1195: putfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   1198: goto -1157 -> 41
    //   1201: iload_3
    //   1202: istore 7
    //   1204: iload_3
    //   1205: istore 5
    //   1207: iload_3
    //   1208: istore 8
    //   1210: aload_0
    //   1211: aload_0
    //   1212: getfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   1215: sipush 2048
    //   1218: ior
    //   1219: putfield 116	d/l/b/a/b/e/a$p:Ltd	I
    //   1222: iload_3
    //   1223: istore 7
    //   1225: iload_3
    //   1226: istore 5
    //   1228: iload_3
    //   1229: istore 8
    //   1231: aload_0
    //   1232: aload_1
    //   1233: invokevirtual 119	d/l/b/a/b/h/e:xF	()I
    //   1236: putfield 211	d/l/b/a/b/e/a$p:LvQ	I
    //   1239: goto -1198 -> 41
    //   1242: iload_3
    //   1243: iconst_1
    //   1244: iand
    //   1245: iconst_1
    //   1246: if_icmpne +14 -> 1260
    //   1249: aload_0
    //   1250: aload_0
    //   1251: getfield 127	d/l/b/a/b/e/a$p:Ltf	Ljava/util/List;
    //   1254: invokestatic 133	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1257: putfield 127	d/l/b/a/b/e/a$p:Ltf	Ljava/util/List;
    //   1260: aload 11
    //   1262: invokevirtual 136	d/l/b/a/b/h/f:flush	()V
    //   1265: aload_0
    //   1266: aload 10
    //   1268: invokevirtual 142	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   1271: putfield 89	d/l/b/a/b/e/a$p:Ltb	Ld/l/b/a/b/h/d;
    //   1274: aload_0
    //   1275: getfield 146	d/l/b/a/b/h/i$c:LAd	Ld/l/b/a/b/h/h;
    //   1278: invokevirtual 151	d/l/b/a/b/h/h:gai	()V
    //   1281: ldc 95
    //   1283: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1286: return
    //   1287: astore_1
    //   1288: aload_0
    //   1289: aload 10
    //   1291: invokevirtual 142	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   1294: putfield 89	d/l/b/a/b/e/a$p:Ltb	Ld/l/b/a/b/h/d;
    //   1297: goto -23 -> 1274
    //   1300: astore_1
    //   1301: aload_0
    //   1302: aload 10
    //   1304: invokevirtual 142	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   1307: putfield 89	d/l/b/a/b/e/a$p:Ltb	Ld/l/b/a/b/h/d;
    //   1310: ldc 95
    //   1312: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1315: aload_1
    //   1316: athrow
    //   1317: astore_2
    //   1318: aload_0
    //   1319: aload 10
    //   1321: invokevirtual 142	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   1324: putfield 89	d/l/b/a/b/e/a$p:Ltb	Ld/l/b/a/b/h/d;
    //   1327: goto -1007 -> 320
    //   1330: astore_1
    //   1331: aload_0
    //   1332: aload 10
    //   1334: invokevirtual 142	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   1337: putfield 89	d/l/b/a/b/e/a$p:Ltb	Ld/l/b/a/b/h/d;
    //   1340: ldc 95
    //   1342: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    this.Ltb = paramb.Ltb;
  }
  
  public static b f(p paramp)
  {
    AppMethodBeat.i(210235);
    paramp = b.fXR().j(paramp);
    AppMethodBeat.o(210235);
    return paramp;
  }
  
  private void fUR()
  {
    AppMethodBeat.i(58857);
    this.Ltf = Collections.emptyList();
    this.LvF = false;
    this.LvG = 0;
    this.LvH = LvE;
    this.LvI = 0;
    this.LvJ = 0;
    this.LvK = 0;
    this.LvL = 0;
    this.LvM = 0;
    this.LvN = LvE;
    this.LvO = 0;
    this.LvP = LvE;
    this.LvQ = 0;
    this.Ltw = 0;
    AppMethodBeat.o(58857);
  }
  
  public static p fXu()
  {
    return LvE;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58859);
    xS();
    i.c.a locala = gap();
    if ((this.Ltd & 0x1000) == 4096) {
      paramf.bv(1, this.Ltw);
    }
    int i = 0;
    while (i < this.Ltf.size())
    {
      paramf.a(2, (q)this.Ltf.get(i));
      i += 1;
    }
    if ((this.Ltd & 0x1) == 1) {
      paramf.zr(this.LvF);
    }
    if ((this.Ltd & 0x2) == 2) {
      paramf.bv(4, this.LvG);
    }
    if ((this.Ltd & 0x4) == 4) {
      paramf.a(5, this.LvH);
    }
    if ((this.Ltd & 0x10) == 16) {
      paramf.bv(6, this.LvJ);
    }
    if ((this.Ltd & 0x20) == 32) {
      paramf.bv(7, this.LvK);
    }
    if ((this.Ltd & 0x8) == 8) {
      paramf.bv(8, this.LvI);
    }
    if ((this.Ltd & 0x40) == 64) {
      paramf.bv(9, this.LvL);
    }
    if ((this.Ltd & 0x100) == 256) {
      paramf.a(10, this.LvN);
    }
    if ((this.Ltd & 0x200) == 512) {
      paramf.bv(11, this.LvO);
    }
    if ((this.Ltd & 0x80) == 128) {
      paramf.bv(12, this.LvM);
    }
    if ((this.Ltd & 0x400) == 1024) {
      paramf.a(13, this.LvP);
    }
    if ((this.Ltd & 0x800) == 2048) {
      paramf.bv(14, this.LvQ);
    }
    locala.b(200, paramf);
    paramf.e(this.Ltb);
    AppMethodBeat.o(58859);
  }
  
  public final s<p> fUP()
  {
    return Ltc;
  }
  
  public final boolean fVp()
  {
    return (this.Ltd & 0x1000) == 4096;
  }
  
  public final boolean fXA()
  {
    return (this.Ltd & 0x20) == 32;
  }
  
  public final boolean fXB()
  {
    return (this.Ltd & 0x40) == 64;
  }
  
  public final boolean fXC()
  {
    return (this.Ltd & 0x80) == 128;
  }
  
  public final boolean fXD()
  {
    return (this.Ltd & 0x100) == 256;
  }
  
  public final boolean fXE()
  {
    return (this.Ltd & 0x200) == 512;
  }
  
  public final boolean fXF()
  {
    return (this.Ltd & 0x400) == 1024;
  }
  
  public final boolean fXG()
  {
    return (this.Ltd & 0x800) == 2048;
  }
  
  public final b fXH()
  {
    AppMethodBeat.i(210236);
    b localb = b.fXR().j(this);
    AppMethodBeat.o(210236);
    return localb;
  }
  
  public final boolean fXv()
  {
    return (this.Ltd & 0x1) == 1;
  }
  
  public final boolean fXw()
  {
    return (this.Ltd & 0x2) == 2;
  }
  
  public final boolean fXx()
  {
    return (this.Ltd & 0x4) == 4;
  }
  
  public final boolean fXy()
  {
    return (this.Ltd & 0x8) == 8;
  }
  
  public final boolean fXz()
  {
    return (this.Ltd & 0x10) == 16;
  }
  
  public final int getArgumentCount()
  {
    AppMethodBeat.i(58856);
    int i = this.Ltf.size();
    AppMethodBeat.o(58856);
    return i;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58858);
    int i = this.Ltg;
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
      if (!((a)this.Ltf.get(i)).isInitialized())
      {
        this.Ltg = 0;
        AppMethodBeat.o(58858);
        return false;
      }
      i += 1;
    }
    if ((fXx()) && (!this.LvH.isInitialized()))
    {
      this.Ltg = 0;
      AppMethodBeat.o(58858);
      return false;
    }
    if ((fXD()) && (!this.LvN.isInitialized()))
    {
      this.Ltg = 0;
      AppMethodBeat.o(58858);
      return false;
    }
    if ((fXF()) && (!this.LvP.isInitialized()))
    {
      this.Ltg = 0;
      AppMethodBeat.o(58858);
      return false;
    }
    if (!this.LAd.isInitialized())
    {
      this.Ltg = 0;
      AppMethodBeat.o(58858);
      return false;
    }
    this.Ltg = 1;
    AppMethodBeat.o(58858);
    return true;
  }
  
  public final int xS()
  {
    int j = 0;
    AppMethodBeat.i(58860);
    int i = this.Lth;
    if (i != -1)
    {
      AppMethodBeat.o(58860);
      return i;
    }
    if ((this.Ltd & 0x1000) == 4096) {
      i = f.bx(1, this.Ltw) + 0;
    }
    for (;;)
    {
      if (j < this.Ltf.size())
      {
        int k = f.c(2, (q)this.Ltf.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        j = i;
        if ((this.Ltd & 0x1) == 1) {
          j = i + (f.fK(3) + 1);
        }
        i = j;
        if ((this.Ltd & 0x2) == 2) {
          i = j + f.bx(4, this.LvG);
        }
        j = i;
        if ((this.Ltd & 0x4) == 4) {
          j = i + f.c(5, this.LvH);
        }
        i = j;
        if ((this.Ltd & 0x10) == 16) {
          i = j + f.bx(6, this.LvJ);
        }
        j = i;
        if ((this.Ltd & 0x20) == 32) {
          j = i + f.bx(7, this.LvK);
        }
        i = j;
        if ((this.Ltd & 0x8) == 8) {
          i = j + f.bx(8, this.LvI);
        }
        j = i;
        if ((this.Ltd & 0x40) == 64) {
          j = i + f.bx(9, this.LvL);
        }
        i = j;
        if ((this.Ltd & 0x100) == 256) {
          i = j + f.c(10, this.LvN);
        }
        j = i;
        if ((this.Ltd & 0x200) == 512) {
          j = i + f.bx(11, this.LvO);
        }
        i = j;
        if ((this.Ltd & 0x80) == 128) {
          i = j + f.bx(12, this.LvM);
        }
        j = i;
        if ((this.Ltd & 0x400) == 1024) {
          j = i + f.c(13, this.LvP);
        }
        i = j;
        if ((this.Ltd & 0x800) == 2048) {
          i = j + f.bx(14, this.LvQ);
        }
        i = this.LAd.xS() + i + this.Ltb.size();
        this.Lth = i;
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
    public static s<a> Ltc;
    private static final a LvR;
    private final d Ltb;
    private int Ltd;
    private byte Ltg = -1;
    private int Lth = -1;
    public a.p.a.b LvS;
    public a.p LvT;
    public int LvU;
    
    static
    {
      AppMethodBeat.i(58832);
      Ltc = new b() {};
      a locala = new a();
      LvR = locala;
      locala.fUR();
      AppMethodBeat.o(58832);
    }
    
    private a()
    {
      this.Ltb = d.LzL;
    }
    
    /* Error */
    private a(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 60	d/l/b/a/b/h/i:<init>	()V
      //   4: ldc 77
      //   6: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 62	d/l/b/a/b/e/a$p$a:Ltg	B
      //   14: aload_0
      //   15: iconst_m1
      //   16: putfield 64	d/l/b/a/b/e/a$p$a:Lth	I
      //   19: aload_0
      //   20: invokespecial 55	d/l/b/a/b/e/a$p$a:fUR	()V
      //   23: invokestatic 81	d/l/b/a/b/h/d:fZS	()Ld/l/b/a/b/h/d$b;
      //   26: astore 7
      //   28: aload 7
      //   30: iconst_1
      //   31: invokestatic 87	d/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Ld/l/b/a/b/h/f;
      //   34: astore 8
      //   36: iconst_0
      //   37: istore_3
      //   38: iload_3
      //   39: ifne +281 -> 320
      //   42: aload_1
      //   43: invokevirtual 93	d/l/b/a/b/h/e:xE	()I
      //   46: istore 4
      //   48: iload 4
      //   50: lookupswitch	default:+360->410, 0:+363->413, 8:+60->110, 18:+178->228, 24:+249->299
      //   93: aload_1
      //   94: aload 8
      //   96: aload_2
      //   97: iload 4
      //   99: invokevirtual 96	d/l/b/a/b/e/a$p$a:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/f;Ld/l/b/a/b/h/g;I)Z
      //   102: ifne -64 -> 38
      //   105: iconst_1
      //   106: istore_3
      //   107: goto -69 -> 38
      //   110: aload_1
      //   111: invokevirtual 99	d/l/b/a/b/h/e:xF	()I
      //   114: istore 5
      //   116: iload 5
      //   118: invokestatic 103	d/l/b/a/b/e/a$p$a$b:ahG	(I)Ld/l/b/a/b/e/a$p$a$b;
      //   121: astore 6
      //   123: aload 6
      //   125: ifnonnull +59 -> 184
      //   128: aload 8
      //   130: iload 4
      //   132: invokevirtual 106	d/l/b/a/b/h/f:fL	(I)V
      //   135: aload 8
      //   137: iload 5
      //   139: invokevirtual 106	d/l/b/a/b/h/f:fL	(I)V
      //   142: goto -104 -> 38
      //   145: astore_1
      //   146: aload_1
      //   147: aload_0
      //   148: putfield 110	d/l/b/a/b/h/k:LAt	Ld/l/b/a/b/h/q;
      //   151: ldc 77
      //   153: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   156: aload_1
      //   157: athrow
      //   158: astore_1
      //   159: aload 8
      //   161: invokevirtual 113	d/l/b/a/b/h/f:flush	()V
      //   164: aload_0
      //   165: aload 7
      //   167: invokevirtual 119	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
      //   170: putfield 71	d/l/b/a/b/e/a$p$a:Ltb	Ld/l/b/a/b/h/d;
      //   173: aload_0
      //   174: invokevirtual 122	d/l/b/a/b/e/a$p$a:gao	()V
      //   177: ldc 77
      //   179: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   182: aload_1
      //   183: athrow
      //   184: aload_0
      //   185: aload_0
      //   186: getfield 124	d/l/b/a/b/e/a$p$a:Ltd	I
      //   189: iconst_1
      //   190: ior
      //   191: putfield 124	d/l/b/a/b/e/a$p$a:Ltd	I
      //   194: aload_0
      //   195: aload 6
      //   197: putfield 126	d/l/b/a/b/e/a$p$a:LvS	Ld/l/b/a/b/e/a$p$a$b;
      //   200: goto -162 -> 38
      //   203: astore_1
      //   204: new 74	d/l/b/a/b/h/k
      //   207: dup
      //   208: aload_1
      //   209: invokevirtual 130	java/io/IOException:getMessage	()Ljava/lang/String;
      //   212: invokespecial 133	d/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
      //   215: astore_1
      //   216: aload_1
      //   217: aload_0
      //   218: putfield 110	d/l/b/a/b/h/k:LAt	Ld/l/b/a/b/h/q;
      //   221: ldc 77
      //   223: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   226: aload_1
      //   227: athrow
      //   228: aload_0
      //   229: getfield 124	d/l/b/a/b/e/a$p$a:Ltd	I
      //   232: iconst_2
      //   233: iand
      //   234: iconst_2
      //   235: if_icmpne +169 -> 404
      //   238: aload_0
      //   239: getfield 135	d/l/b/a/b/e/a$p$a:LvT	Ld/l/b/a/b/e/a$p;
      //   242: invokevirtual 139	d/l/b/a/b/e/a$p:fXH	()Ld/l/b/a/b/e/a$p$b;
      //   245: astore 6
      //   247: aload_0
      //   248: aload_1
      //   249: getstatic 140	d/l/b/a/b/e/a$p:Ltc	Ld/l/b/a/b/h/s;
      //   252: aload_2
      //   253: invokevirtual 143	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
      //   256: checkcast 8	d/l/b/a/b/e/a$p
      //   259: putfield 135	d/l/b/a/b/e/a$p$a:LvT	Ld/l/b/a/b/e/a$p;
      //   262: aload 6
      //   264: ifnull +22 -> 286
      //   267: aload 6
      //   269: aload_0
      //   270: getfield 135	d/l/b/a/b/e/a$p$a:LvT	Ld/l/b/a/b/e/a$p;
      //   273: invokevirtual 149	d/l/b/a/b/e/a$p$b:j	(Ld/l/b/a/b/e/a$p;)Ld/l/b/a/b/e/a$p$b;
      //   276: pop
      //   277: aload_0
      //   278: aload 6
      //   280: invokevirtual 153	d/l/b/a/b/e/a$p$b:fXQ	()Ld/l/b/a/b/e/a$p;
      //   283: putfield 135	d/l/b/a/b/e/a$p$a:LvT	Ld/l/b/a/b/e/a$p;
      //   286: aload_0
      //   287: aload_0
      //   288: getfield 124	d/l/b/a/b/e/a$p$a:Ltd	I
      //   291: iconst_2
      //   292: ior
      //   293: putfield 124	d/l/b/a/b/e/a$p$a:Ltd	I
      //   296: goto -258 -> 38
      //   299: aload_0
      //   300: aload_0
      //   301: getfield 124	d/l/b/a/b/e/a$p$a:Ltd	I
      //   304: iconst_4
      //   305: ior
      //   306: putfield 124	d/l/b/a/b/e/a$p$a:Ltd	I
      //   309: aload_0
      //   310: aload_1
      //   311: invokevirtual 99	d/l/b/a/b/h/e:xF	()I
      //   314: putfield 155	d/l/b/a/b/e/a$p$a:LvU	I
      //   317: goto -279 -> 38
      //   320: aload 8
      //   322: invokevirtual 113	d/l/b/a/b/h/f:flush	()V
      //   325: aload_0
      //   326: aload 7
      //   328: invokevirtual 119	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
      //   331: putfield 71	d/l/b/a/b/e/a$p$a:Ltb	Ld/l/b/a/b/h/d;
      //   334: aload_0
      //   335: invokevirtual 122	d/l/b/a/b/e/a$p$a:gao	()V
      //   338: ldc 77
      //   340: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   343: return
      //   344: astore_1
      //   345: aload_0
      //   346: aload 7
      //   348: invokevirtual 119	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
      //   351: putfield 71	d/l/b/a/b/e/a$p$a:Ltb	Ld/l/b/a/b/h/d;
      //   354: goto -20 -> 334
      //   357: astore_1
      //   358: aload_0
      //   359: aload 7
      //   361: invokevirtual 119	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
      //   364: putfield 71	d/l/b/a/b/e/a$p$a:Ltb	Ld/l/b/a/b/h/d;
      //   367: ldc 77
      //   369: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   372: aload_1
      //   373: athrow
      //   374: astore_2
      //   375: aload_0
      //   376: aload 7
      //   378: invokevirtual 119	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
      //   381: putfield 71	d/l/b/a/b/e/a$p$a:Ltb	Ld/l/b/a/b/h/d;
      //   384: goto -211 -> 173
      //   387: astore_1
      //   388: aload_0
      //   389: aload 7
      //   391: invokevirtual 119	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
      //   394: putfield 71	d/l/b/a/b/e/a$p$a:Ltb	Ld/l/b/a/b/h/d;
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
      this.Ltb = parama.Ltb;
    }
    
    private void fUR()
    {
      AppMethodBeat.i(58826);
      this.LvS = a.p.a.b.LvX;
      this.LvT = a.p.fXu();
      this.LvU = 0;
      AppMethodBeat.o(58826);
    }
    
    public static a fXI()
    {
      return LvR;
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(58828);
      xS();
      if ((this.Ltd & 0x1) == 1) {
        paramf.lc(1, this.LvS.value);
      }
      if ((this.Ltd & 0x2) == 2) {
        paramf.a(2, this.LvT);
      }
      if ((this.Ltd & 0x4) == 4) {
        paramf.bv(3, this.LvU);
      }
      paramf.e(this.Ltb);
      AppMethodBeat.o(58828);
    }
    
    public final s<a> fUP()
    {
      return Ltc;
    }
    
    public final boolean fVg()
    {
      return (this.Ltd & 0x2) == 2;
    }
    
    public final boolean fXJ()
    {
      return (this.Ltd & 0x1) == 1;
    }
    
    public final boolean fXK()
    {
      return (this.Ltd & 0x4) == 4;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58827);
      int i = this.Ltg;
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
      if ((fVg()) && (!this.LvT.isInitialized()))
      {
        this.Ltg = 0;
        AppMethodBeat.o(58827);
        return false;
      }
      this.Ltg = 1;
      AppMethodBeat.o(58827);
      return true;
    }
    
    public final int xS()
    {
      AppMethodBeat.i(58829);
      int i = this.Lth;
      if (i != -1)
      {
        AppMethodBeat.o(58829);
        return i;
      }
      int j = 0;
      if ((this.Ltd & 0x1) == 1) {
        j = f.ld(1, this.LvS.value) + 0;
      }
      i = j;
      if ((this.Ltd & 0x2) == 2) {
        i = j + f.c(2, this.LvT);
      }
      j = i;
      if ((this.Ltd & 0x4) == 4) {
        j = i + f.bx(3, this.LvU);
      }
      i = j + this.Ltb.size();
      this.Lth = i;
      AppMethodBeat.o(58829);
      return i;
    }
    
    public static final class a
      extends i.a<a.p.a, a>
      implements r
    {
      private int Ltd;
      private a.p.a.b LvS;
      private a.p LvT;
      private int LvU;
      
      private a()
      {
        AppMethodBeat.i(58803);
        this.LvS = a.p.a.b.LvX;
        this.LvT = a.p.fXu();
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
        this.Ltd |= 0x1;
        this.LvS = paramb;
        AppMethodBeat.o(58809);
        return this;
      }
      
      private a ahF(int paramInt)
      {
        this.Ltd |= 0x4;
        this.LvU = paramInt;
        return this;
      }
      
      private a fXL()
      {
        AppMethodBeat.i(58804);
        a locala = new a().b(fXM());
        AppMethodBeat.o(58804);
        return locala;
      }
      
      private a.p.a fXM()
      {
        int j = 1;
        AppMethodBeat.i(58805);
        a.p.a locala = new a.p.a(this, (byte)0);
        int k = this.Ltd;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          a.p.a.a(locala, this.LvS);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          a.p.a.a(locala, this.LvT);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          a.p.a.a(locala, this.LvU);
          a.p.a.b(locala, j);
          AppMethodBeat.o(58805);
          return locala;
          j = 0;
        }
      }
      
      private a i(a.p paramp)
      {
        AppMethodBeat.i(58810);
        if (((this.Ltd & 0x2) == 2) && (this.LvT != a.p.fXu())) {}
        for (this.LvT = a.p.f(this.LvT).j(paramp).fXQ();; this.LvT = paramp)
        {
          this.Ltd |= 0x2;
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
        //   7: getstatic 113	d/l/b/a/b/e/a$p$a:Ltc	Ld/l/b/a/b/h/s;
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
        //   36: getfield 122	d/l/b/a/b/h/k:LAt	Ld/l/b/a/b/h/q;
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
        if (parama == a.p.a.fXI())
        {
          AppMethodBeat.o(58806);
          return this;
        }
        if (parama.fXJ()) {
          a(parama.LvS);
        }
        if (parama.fVg()) {
          i(parama.LvT);
        }
        if (parama.fXK()) {
          ahF(parama.LvU);
        }
        this.Ltb = this.Ltb.a(a.p.a.a(parama));
        AppMethodBeat.o(58806);
        return this;
      }
      
      public final boolean isInitialized()
      {
        AppMethodBeat.i(58807);
        if ((this.Ltd & 0x2) == 2) {}
        for (int i = 1; (i != 0) && (!this.LvT.isInitialized()); i = 0)
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
    private int Ltd;
    private List<a.p.a> Ltf;
    private int Ltw;
    private boolean LvF;
    private int LvG;
    private a.p LvH;
    private int LvI;
    private int LvJ;
    private int LvK;
    private int LvL;
    private int LvM;
    private a.p LvN;
    private int LvO;
    private a.p LvP;
    private int LvQ;
    
    private b()
    {
      AppMethodBeat.i(58833);
      this.Ltf = Collections.emptyList();
      this.LvH = a.p.fXu();
      this.LvN = a.p.fXu();
      this.LvP = a.p.fXu();
      AppMethodBeat.o(58833);
    }
    
    private b ahH(int paramInt)
    {
      this.Ltd |= 0x4;
      this.LvG = paramInt;
      return this;
    }
    
    private b ahI(int paramInt)
    {
      this.Ltd |= 0x10;
      this.LvI = paramInt;
      return this;
    }
    
    private b ahJ(int paramInt)
    {
      this.Ltd |= 0x20;
      this.LvJ = paramInt;
      return this;
    }
    
    private b ahK(int paramInt)
    {
      this.Ltd |= 0x40;
      this.LvK = paramInt;
      return this;
    }
    
    private b ahL(int paramInt)
    {
      this.Ltd |= 0x80;
      this.LvL = paramInt;
      return this;
    }
    
    private b ahM(int paramInt)
    {
      this.Ltd |= 0x100;
      this.LvM = paramInt;
      return this;
    }
    
    private b ahN(int paramInt)
    {
      this.Ltd |= 0x400;
      this.LvO = paramInt;
      return this;
    }
    
    private b ahO(int paramInt)
    {
      this.Ltd |= 0x1000;
      this.LvQ = paramInt;
      return this;
    }
    
    private b ahP(int paramInt)
    {
      this.Ltd |= 0x2000;
      this.Ltw = paramInt;
      return this;
    }
    
    private void fVw()
    {
      AppMethodBeat.i(58840);
      if ((this.Ltd & 0x1) != 1)
      {
        this.Ltf = new ArrayList(this.Ltf);
        this.Ltd |= 0x1;
      }
      AppMethodBeat.o(58840);
    }
    
    private b fXO()
    {
      AppMethodBeat.i(58834);
      b localb = new b().j(fXQ());
      AppMethodBeat.o(58834);
      return localb;
    }
    
    private b k(a.p paramp)
    {
      AppMethodBeat.i(58841);
      if (((this.Ltd & 0x8) == 8) && (this.LvH != a.p.fXu())) {}
      for (this.LvH = a.p.f(this.LvH).j(paramp).fXQ();; this.LvH = paramp)
      {
        this.Ltd |= 0x8;
        AppMethodBeat.o(58841);
        return this;
      }
    }
    
    private b l(a.p paramp)
    {
      AppMethodBeat.i(58842);
      if (((this.Ltd & 0x200) == 512) && (this.LvN != a.p.fXu())) {}
      for (this.LvN = a.p.f(this.LvN).j(paramp).fXQ();; this.LvN = paramp)
      {
        this.Ltd |= 0x200;
        AppMethodBeat.o(58842);
        return this;
      }
    }
    
    private b m(a.p paramp)
    {
      AppMethodBeat.i(58843);
      if (((this.Ltd & 0x800) == 2048) && (this.LvP != a.p.fXu())) {}
      for (this.LvP = a.p.f(this.LvP).j(paramp).fXQ();; this.LvP = paramp)
      {
        this.Ltd |= 0x800;
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
      //   7: getstatic 134	d/l/b/a/b/e/a$p:Ltc	Ld/l/b/a/b/h/s;
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
      //   36: getfield 144	d/l/b/a/b/h/k:LAt	Ld/l/b/a/b/h/q;
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
    
    public final a.p fXP()
    {
      AppMethodBeat.i(58835);
      Object localObject = fXQ();
      if (!((a.p)localObject).isInitialized())
      {
        localObject = new w();
        AppMethodBeat.o(58835);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(58835);
      return localObject;
    }
    
    public final a.p fXQ()
    {
      int j = 1;
      AppMethodBeat.i(58836);
      a.p localp = new a.p(this, (byte)0);
      int k = this.Ltd;
      if ((this.Ltd & 0x1) == 1)
      {
        this.Ltf = Collections.unmodifiableList(this.Ltf);
        this.Ltd &= 0xFFFFFFFE;
      }
      a.p.a(localp, this.Ltf);
      if ((k & 0x2) == 2) {}
      for (;;)
      {
        a.p.a(localp, this.LvF);
        int i = j;
        if ((k & 0x4) == 4) {
          i = j | 0x2;
        }
        a.p.a(localp, this.LvG);
        j = i;
        if ((k & 0x8) == 8) {
          j = i | 0x4;
        }
        a.p.a(localp, this.LvH);
        i = j;
        if ((k & 0x10) == 16) {
          i = j | 0x8;
        }
        a.p.b(localp, this.LvI);
        j = i;
        if ((k & 0x20) == 32) {
          j = i | 0x10;
        }
        a.p.c(localp, this.LvJ);
        i = j;
        if ((k & 0x40) == 64) {
          i = j | 0x20;
        }
        a.p.d(localp, this.LvK);
        j = i;
        if ((k & 0x80) == 128) {
          j = i | 0x40;
        }
        a.p.e(localp, this.LvL);
        i = j;
        if ((k & 0x100) == 256) {
          i = j | 0x80;
        }
        a.p.f(localp, this.LvM);
        j = i;
        if ((k & 0x200) == 512) {
          j = i | 0x100;
        }
        a.p.b(localp, this.LvN);
        i = j;
        if ((k & 0x400) == 1024) {
          i = j | 0x200;
        }
        a.p.g(localp, this.LvO);
        j = i;
        if ((k & 0x800) == 2048) {
          j = i | 0x400;
        }
        a.p.c(localp, this.LvP);
        i = j;
        if ((k & 0x1000) == 4096) {
          i = j | 0x800;
        }
        a.p.h(localp, this.LvQ);
        j = i;
        if ((k & 0x2000) == 8192) {
          j = i | 0x1000;
        }
        a.p.i(localp, this.Ltw);
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
      while (i < this.Ltf.size())
      {
        if (!((a.p.a)this.Ltf.get(i)).isInitialized())
        {
          AppMethodBeat.o(58838);
          return false;
        }
        i += 1;
      }
      if ((this.Ltd & 0x8) == 8) {}
      for (i = 1; (i != 0) && (!this.LvH.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58838);
        return false;
      }
      if ((this.Ltd & 0x200) == 512) {}
      for (i = 1; (i != 0) && (!this.LvN.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58838);
        return false;
      }
      if ((this.Ltd & 0x800) == 2048) {}
      for (i = 1; (i != 0) && (!this.LvP.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58838);
        return false;
      }
      if (!this.LAd.isInitialized())
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
      if (paramp == a.p.fXu())
      {
        AppMethodBeat.o(58837);
        return this;
      }
      if (!a.p.g(paramp).isEmpty())
      {
        if (!this.Ltf.isEmpty()) {
          break label300;
        }
        this.Ltf = a.p.g(paramp);
        this.Ltd &= 0xFFFFFFFE;
      }
      for (;;)
      {
        if (paramp.fXv()) {
          zp(paramp.LvF);
        }
        if (paramp.fXw()) {
          ahH(paramp.LvG);
        }
        if (paramp.fXx()) {
          k(paramp.LvH);
        }
        if (paramp.fXy()) {
          ahI(paramp.LvI);
        }
        if (paramp.fXz()) {
          ahJ(paramp.LvJ);
        }
        if (paramp.fXA()) {
          ahK(paramp.LvK);
        }
        if (paramp.fXB()) {
          ahL(paramp.LvL);
        }
        if (paramp.fXC()) {
          ahM(paramp.LvM);
        }
        if (paramp.fXD()) {
          l(paramp.LvN);
        }
        if (paramp.fXE()) {
          ahN(paramp.LvO);
        }
        if (paramp.fXF()) {
          m(paramp.LvP);
        }
        if (paramp.fXG()) {
          ahO(paramp.LvQ);
        }
        if (paramp.fVp()) {
          ahP(paramp.Ltw);
        }
        a(paramp);
        this.Ltb = this.Ltb.a(a.p.h(paramp));
        AppMethodBeat.o(58837);
        return this;
        label300:
        fVw();
        this.Ltf.addAll(a.p.g(paramp));
      }
    }
    
    public final b zp(boolean paramBoolean)
    {
      this.Ltd |= 0x2;
      this.LvF = paramBoolean;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.a.p
 * JD-Core Version:    0.7.0.1
 */