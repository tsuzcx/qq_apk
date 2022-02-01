package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.b;
import d.l.b.a.b.h.d;
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

public final class a$c
  extends i.c<c>
  implements f
{
  public static s<c> Ltc;
  private static final c Lun;
  private final d Ltb;
  private int Ltd;
  private byte Ltg = -1;
  private int Lth = -1;
  public int Ltw;
  public List<Integer> Lud;
  public List<a.t> Luo;
  
  static
  {
    AppMethodBeat.i(58462);
    Ltc = new b() {};
    c localc = new c();
    Lun = localc;
    localc.fUR();
    AppMethodBeat.o(58462);
  }
  
  private a$c()
  {
    this.Ltb = d.LzL;
  }
  
  /* Error */
  private a$c(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 58	d/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 75
    //   6: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 60	d/l/b/a/b/e/a$c:Ltg	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 62	d/l/b/a/b/e/a$c:Lth	I
    //   19: aload_0
    //   20: invokespecial 53	d/l/b/a/b/e/a$c:fUR	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 79	d/l/b/a/b/h/d:fZS	()Ld/l/b/a/b/h/d$b;
    //   28: astore 10
    //   30: aload 10
    //   32: iconst_1
    //   33: invokestatic 85	d/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Ld/l/b/a/b/h/f;
    //   36: astore 11
    //   38: iconst_0
    //   39: istore 5
    //   41: iload 5
    //   43: ifne +554 -> 597
    //   46: iload_3
    //   47: istore 6
    //   49: iload_3
    //   50: istore 7
    //   52: iload_3
    //   53: istore 8
    //   55: aload_1
    //   56: invokevirtual 91	d/l/b/a/b/h/e:xE	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+671->734, 0:+674->737, 8:+77->140, 18:+212->275, 248:+273->336, 250:+333->396
    //   113: istore 6
    //   115: iload_3
    //   116: istore 7
    //   118: iload_3
    //   119: istore 8
    //   121: aload_0
    //   122: aload_1
    //   123: aload 11
    //   125: aload_2
    //   126: iload 4
    //   128: invokevirtual 94	d/l/b/a/b/e/a$c:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/f;Ld/l/b/a/b/h/g;I)Z
    //   131: ifne -90 -> 41
    //   134: iconst_1
    //   135: istore 5
    //   137: goto -96 -> 41
    //   140: iload_3
    //   141: istore 6
    //   143: iload_3
    //   144: istore 7
    //   146: iload_3
    //   147: istore 8
    //   149: aload_0
    //   150: aload_0
    //   151: getfield 96	d/l/b/a/b/e/a$c:Ltd	I
    //   154: iconst_1
    //   155: ior
    //   156: putfield 96	d/l/b/a/b/e/a$c:Ltd	I
    //   159: iload_3
    //   160: istore 6
    //   162: iload_3
    //   163: istore 7
    //   165: iload_3
    //   166: istore 8
    //   168: aload_0
    //   169: aload_1
    //   170: invokevirtual 99	d/l/b/a/b/h/e:xF	()I
    //   173: putfield 101	d/l/b/a/b/e/a$c:Ltw	I
    //   176: goto -135 -> 41
    //   179: astore_1
    //   180: iload 6
    //   182: istore 7
    //   184: iload 7
    //   186: istore 4
    //   188: aload_1
    //   189: aload_0
    //   190: putfield 105	d/l/b/a/b/h/k:LAt	Ld/l/b/a/b/h/q;
    //   193: iload 7
    //   195: istore 4
    //   197: ldc 75
    //   199: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: iload 7
    //   204: istore 4
    //   206: aload_1
    //   207: athrow
    //   208: astore_1
    //   209: iload 4
    //   211: iconst_2
    //   212: iand
    //   213: iconst_2
    //   214: if_icmpne +14 -> 228
    //   217: aload_0
    //   218: aload_0
    //   219: getfield 107	d/l/b/a/b/e/a$c:Luo	Ljava/util/List;
    //   222: invokestatic 113	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   225: putfield 107	d/l/b/a/b/e/a$c:Luo	Ljava/util/List;
    //   228: iload 4
    //   230: iconst_4
    //   231: iand
    //   232: iconst_4
    //   233: if_icmpne +14 -> 247
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 115	d/l/b/a/b/e/a$c:Lud	Ljava/util/List;
    //   241: invokestatic 113	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   244: putfield 115	d/l/b/a/b/e/a$c:Lud	Ljava/util/List;
    //   247: aload 11
    //   249: invokevirtual 118	d/l/b/a/b/h/f:flush	()V
    //   252: aload_0
    //   253: aload 10
    //   255: invokevirtual 124	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   258: putfield 69	d/l/b/a/b/e/a$c:Ltb	Ld/l/b/a/b/h/d;
    //   261: aload_0
    //   262: getfield 128	d/l/b/a/b/h/i$c:LAd	Ld/l/b/a/b/h/h;
    //   265: invokevirtual 133	d/l/b/a/b/h/h:gai	()V
    //   268: ldc 75
    //   270: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: aload_1
    //   274: athrow
    //   275: iload_3
    //   276: iconst_2
    //   277: iand
    //   278: iconst_2
    //   279: if_icmpeq +452 -> 731
    //   282: iload_3
    //   283: istore 6
    //   285: iload_3
    //   286: istore 7
    //   288: iload_3
    //   289: istore 8
    //   291: aload_0
    //   292: new 135	java/util/ArrayList
    //   295: dup
    //   296: invokespecial 136	java/util/ArrayList:<init>	()V
    //   299: putfield 107	d/l/b/a/b/e/a$c:Luo	Ljava/util/List;
    //   302: iload_3
    //   303: iconst_2
    //   304: ior
    //   305: istore_3
    //   306: iload_3
    //   307: istore 4
    //   309: iload_3
    //   310: istore 6
    //   312: iload_3
    //   313: istore 7
    //   315: aload_0
    //   316: getfield 107	d/l/b/a/b/e/a$c:Luo	Ljava/util/List;
    //   319: aload_1
    //   320: getstatic 139	d/l/b/a/b/e/a$t:Ltc	Ld/l/b/a/b/h/s;
    //   323: aload_2
    //   324: invokevirtual 142	d/l/b/a/b/h/e:a	(Ld/l/b/a/b/h/s;Ld/l/b/a/b/h/g;)Ld/l/b/a/b/h/q;
    //   327: invokeinterface 148 2 0
    //   332: pop
    //   333: goto -292 -> 41
    //   336: iload_3
    //   337: iconst_4
    //   338: iand
    //   339: iconst_4
    //   340: if_icmpeq +388 -> 728
    //   343: iload_3
    //   344: istore 6
    //   346: iload_3
    //   347: istore 7
    //   349: iload_3
    //   350: istore 8
    //   352: aload_0
    //   353: new 135	java/util/ArrayList
    //   356: dup
    //   357: invokespecial 136	java/util/ArrayList:<init>	()V
    //   360: putfield 115	d/l/b/a/b/e/a$c:Lud	Ljava/util/List;
    //   363: iload_3
    //   364: iconst_4
    //   365: ior
    //   366: istore_3
    //   367: iload_3
    //   368: istore 4
    //   370: iload_3
    //   371: istore 6
    //   373: iload_3
    //   374: istore 7
    //   376: aload_0
    //   377: getfield 115	d/l/b/a/b/e/a$c:Lud	Ljava/util/List;
    //   380: aload_1
    //   381: invokevirtual 99	d/l/b/a/b/h/e:xF	()I
    //   384: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   387: invokeinterface 148 2 0
    //   392: pop
    //   393: goto -352 -> 41
    //   396: iload_3
    //   397: istore 6
    //   399: iload_3
    //   400: istore 7
    //   402: iload_3
    //   403: istore 8
    //   405: aload_1
    //   406: aload_1
    //   407: invokevirtual 99	d/l/b/a/b/h/e:xF	()I
    //   410: invokevirtual 158	d/l/b/a/b/h/e:fD	(I)I
    //   413: istore 9
    //   415: iload_3
    //   416: istore 4
    //   418: iload_3
    //   419: iconst_4
    //   420: iand
    //   421: iconst_4
    //   422: if_icmpeq +47 -> 469
    //   425: iload_3
    //   426: istore 6
    //   428: iload_3
    //   429: istore 4
    //   431: iload_3
    //   432: istore 7
    //   434: iload_3
    //   435: istore 8
    //   437: aload_1
    //   438: invokevirtual 161	d/l/b/a/b/h/e:xI	()I
    //   441: ifle +28 -> 469
    //   444: iload_3
    //   445: istore 6
    //   447: iload_3
    //   448: istore 7
    //   450: iload_3
    //   451: istore 8
    //   453: aload_0
    //   454: new 135	java/util/ArrayList
    //   457: dup
    //   458: invokespecial 136	java/util/ArrayList:<init>	()V
    //   461: putfield 115	d/l/b/a/b/e/a$c:Lud	Ljava/util/List;
    //   464: iload_3
    //   465: iconst_4
    //   466: ior
    //   467: istore 4
    //   469: iload 4
    //   471: istore 6
    //   473: iload 4
    //   475: istore 7
    //   477: iload 4
    //   479: istore 8
    //   481: aload_1
    //   482: invokevirtual 161	d/l/b/a/b/h/e:xI	()I
    //   485: ifle +80 -> 565
    //   488: iload 4
    //   490: istore 6
    //   492: iload 4
    //   494: istore 7
    //   496: iload 4
    //   498: istore 8
    //   500: aload_0
    //   501: getfield 115	d/l/b/a/b/e/a$c:Lud	Ljava/util/List;
    //   504: aload_1
    //   505: invokevirtual 99	d/l/b/a/b/h/e:xF	()I
    //   508: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: invokeinterface 148 2 0
    //   516: pop
    //   517: goto -48 -> 469
    //   520: astore_1
    //   521: iload 7
    //   523: istore 6
    //   525: iload 6
    //   527: istore 4
    //   529: new 72	d/l/b/a/b/h/k
    //   532: dup
    //   533: aload_1
    //   534: invokevirtual 165	java/io/IOException:getMessage	()Ljava/lang/String;
    //   537: invokespecial 168	d/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   540: astore_1
    //   541: iload 6
    //   543: istore 4
    //   545: aload_1
    //   546: aload_0
    //   547: putfield 105	d/l/b/a/b/h/k:LAt	Ld/l/b/a/b/h/q;
    //   550: iload 6
    //   552: istore 4
    //   554: ldc 75
    //   556: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   559: iload 6
    //   561: istore 4
    //   563: aload_1
    //   564: athrow
    //   565: iload 4
    //   567: istore 6
    //   569: iload 4
    //   571: istore 7
    //   573: iload 4
    //   575: istore 8
    //   577: aload_1
    //   578: iload 9
    //   580: invokevirtual 171	d/l/b/a/b/h/e:fE	(I)V
    //   583: iload 4
    //   585: istore_3
    //   586: goto -545 -> 41
    //   589: astore_1
    //   590: iload 8
    //   592: istore 4
    //   594: goto -385 -> 209
    //   597: iload_3
    //   598: iconst_2
    //   599: iand
    //   600: iconst_2
    //   601: if_icmpne +14 -> 615
    //   604: aload_0
    //   605: aload_0
    //   606: getfield 107	d/l/b/a/b/e/a$c:Luo	Ljava/util/List;
    //   609: invokestatic 113	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   612: putfield 107	d/l/b/a/b/e/a$c:Luo	Ljava/util/List;
    //   615: iload_3
    //   616: iconst_4
    //   617: iand
    //   618: iconst_4
    //   619: if_icmpne +14 -> 633
    //   622: aload_0
    //   623: aload_0
    //   624: getfield 115	d/l/b/a/b/e/a$c:Lud	Ljava/util/List;
    //   627: invokestatic 113	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   630: putfield 115	d/l/b/a/b/e/a$c:Lud	Ljava/util/List;
    //   633: aload 11
    //   635: invokevirtual 118	d/l/b/a/b/h/f:flush	()V
    //   638: aload_0
    //   639: aload 10
    //   641: invokevirtual 124	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   644: putfield 69	d/l/b/a/b/e/a$c:Ltb	Ld/l/b/a/b/h/d;
    //   647: aload_0
    //   648: getfield 128	d/l/b/a/b/h/i$c:LAd	Ld/l/b/a/b/h/h;
    //   651: invokevirtual 133	d/l/b/a/b/h/h:gai	()V
    //   654: ldc 75
    //   656: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   659: return
    //   660: astore_1
    //   661: aload_0
    //   662: aload 10
    //   664: invokevirtual 124	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   667: putfield 69	d/l/b/a/b/e/a$c:Ltb	Ld/l/b/a/b/h/d;
    //   670: goto -23 -> 647
    //   673: astore_1
    //   674: aload_0
    //   675: aload 10
    //   677: invokevirtual 124	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   680: putfield 69	d/l/b/a/b/e/a$c:Ltb	Ld/l/b/a/b/h/d;
    //   683: ldc 75
    //   685: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   688: aload_1
    //   689: athrow
    //   690: astore_2
    //   691: aload_0
    //   692: aload 10
    //   694: invokevirtual 124	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   697: putfield 69	d/l/b/a/b/e/a$c:Ltb	Ld/l/b/a/b/h/d;
    //   700: goto -439 -> 261
    //   703: astore_1
    //   704: aload_0
    //   705: aload 10
    //   707: invokevirtual 124	d/l/b/a/b/h/d$b:fZW	()Ld/l/b/a/b/h/d;
    //   710: putfield 69	d/l/b/a/b/e/a$c:Ltb	Ld/l/b/a/b/h/d;
    //   713: ldc 75
    //   715: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   718: aload_1
    //   719: athrow
    //   720: astore_1
    //   721: goto -196 -> 525
    //   724: astore_1
    //   725: goto -541 -> 184
    //   728: goto -361 -> 367
    //   731: goto -425 -> 306
    //   734: goto -622 -> 112
    //   737: iconst_1
    //   738: istore 5
    //   740: goto -699 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	this	c
    //   0	743	1	parame	d.l.b.a.b.h.e
    //   0	743	2	paramg	d.l.b.a.b.h.g
    //   24	594	3	i	int
    //   59	534	4	j	int
    //   39	700	5	k	int
    //   47	521	6	m	int
    //   50	522	7	n	int
    //   53	538	8	i1	int
    //   413	166	9	i2	int
    //   28	678	10	localb	d.l.b.a.b.h.d.b
    //   36	598	11	localf	d.l.b.a.b.h.f
    // Exception table:
    //   from	to	target	type
    //   55	61	179	d/l/b/a/b/h/k
    //   121	134	179	d/l/b/a/b/h/k
    //   149	159	179	d/l/b/a/b/h/k
    //   168	176	179	d/l/b/a/b/h/k
    //   291	302	179	d/l/b/a/b/h/k
    //   352	363	179	d/l/b/a/b/h/k
    //   405	415	179	d/l/b/a/b/h/k
    //   437	444	179	d/l/b/a/b/h/k
    //   453	464	179	d/l/b/a/b/h/k
    //   481	488	179	d/l/b/a/b/h/k
    //   500	517	179	d/l/b/a/b/h/k
    //   577	583	179	d/l/b/a/b/h/k
    //   188	193	208	finally
    //   197	202	208	finally
    //   206	208	208	finally
    //   315	333	208	finally
    //   376	393	208	finally
    //   529	541	208	finally
    //   545	550	208	finally
    //   554	559	208	finally
    //   563	565	208	finally
    //   55	61	520	java/io/IOException
    //   121	134	520	java/io/IOException
    //   149	159	520	java/io/IOException
    //   168	176	520	java/io/IOException
    //   291	302	520	java/io/IOException
    //   352	363	520	java/io/IOException
    //   405	415	520	java/io/IOException
    //   437	444	520	java/io/IOException
    //   453	464	520	java/io/IOException
    //   481	488	520	java/io/IOException
    //   500	517	520	java/io/IOException
    //   577	583	520	java/io/IOException
    //   55	61	589	finally
    //   121	134	589	finally
    //   149	159	589	finally
    //   168	176	589	finally
    //   291	302	589	finally
    //   352	363	589	finally
    //   405	415	589	finally
    //   437	444	589	finally
    //   453	464	589	finally
    //   481	488	589	finally
    //   500	517	589	finally
    //   577	583	589	finally
    //   633	638	660	java/io/IOException
    //   633	638	673	finally
    //   247	252	690	java/io/IOException
    //   247	252	703	finally
    //   315	333	720	java/io/IOException
    //   376	393	720	java/io/IOException
    //   315	333	724	d/l/b/a/b/h/k
    //   376	393	724	d/l/b/a/b/h/k
  }
  
  private a$c(i.b<c, ?> paramb)
  {
    super(paramb);
    this.Ltb = paramb.Ltb;
  }
  
  private void fUR()
  {
    AppMethodBeat.i(58456);
    this.Ltw = 6;
    this.Luo = Collections.emptyList();
    this.Lud = Collections.emptyList();
    AppMethodBeat.o(58456);
  }
  
  public static c fVS()
  {
    return Lun;
  }
  
  public final void a(d.l.b.a.b.h.f paramf)
  {
    int k = 0;
    AppMethodBeat.i(58458);
    xS();
    i.c.a locala = gap();
    if ((this.Ltd & 0x1) == 1) {
      paramf.bv(1, this.Ltw);
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.Luo.size()) {
        break;
      }
      paramf.a(2, (q)this.Luo.get(i));
      i += 1;
    }
    while (j < this.Lud.size())
    {
      paramf.bv(31, ((Integer)this.Lud.get(j)).intValue());
      j += 1;
    }
    locala.b(19000, paramf);
    paramf.e(this.Ltb);
    AppMethodBeat.o(58458);
  }
  
  public final s<c> fUP()
  {
    return Ltc;
  }
  
  public final boolean fVp()
  {
    return (this.Ltd & 0x1) == 1;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58457);
    int i = this.Ltg;
    if (i == 1)
    {
      AppMethodBeat.o(58457);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58457);
      return false;
    }
    i = 0;
    while (i < this.Luo.size())
    {
      if (!((a.t)this.Luo.get(i)).isInitialized())
      {
        this.Ltg = 0;
        AppMethodBeat.o(58457);
        return false;
      }
      i += 1;
    }
    if (!this.LAd.isInitialized())
    {
      this.Ltg = 0;
      AppMethodBeat.o(58457);
      return false;
    }
    this.Ltg = 1;
    AppMethodBeat.o(58457);
    return true;
  }
  
  public final int xS()
  {
    AppMethodBeat.i(58459);
    int i = this.Lth;
    if (i != -1)
    {
      AppMethodBeat.o(58459);
      return i;
    }
    if ((this.Ltd & 0x1) == 1) {}
    for (i = d.l.b.a.b.h.f.bx(1, this.Ltw) + 0;; i = 0)
    {
      int j = 0;
      while (j < this.Luo.size())
      {
        i += d.l.b.a.b.h.f.c(2, (q)this.Luo.get(j));
        j += 1;
      }
      int k = 0;
      int m;
      for (j = 0; k < this.Lud.size(); j = m + j)
      {
        m = d.l.b.a.b.h.f.fI(((Integer)this.Lud.get(k)).intValue());
        k += 1;
      }
      i = i + j + this.Lud.size() * 2 + this.LAd.xS() + this.Ltb.size();
      this.Lth = i;
      AppMethodBeat.o(58459);
      return i;
    }
  }
  
  public static final class a
    extends i.b<a.c, a>
    implements f
  {
    private int Ltd;
    private int Ltw;
    private List<Integer> Lud;
    private List<a.t> Luo;
    
    private a()
    {
      AppMethodBeat.i(58436);
      this.Ltw = 6;
      this.Luo = Collections.emptyList();
      this.Lud = Collections.emptyList();
      AppMethodBeat.o(58436);
    }
    
    private a ahf(int paramInt)
    {
      this.Ltd |= 0x1;
      this.Ltw = paramInt;
      return this;
    }
    
    private void fVP()
    {
      AppMethodBeat.i(58443);
      if ((this.Ltd & 0x4) != 4)
      {
        this.Lud = new ArrayList(this.Lud);
        this.Ltd |= 0x4;
      }
      AppMethodBeat.o(58443);
    }
    
    private a fVT()
    {
      AppMethodBeat.i(58437);
      a locala = new a().d(fVU());
      AppMethodBeat.o(58437);
      return locala;
    }
    
    private a.c fVU()
    {
      int i = 1;
      AppMethodBeat.i(58438);
      a.c localc = new a.c(this, (byte)0);
      if ((this.Ltd & 0x1) == 1) {}
      for (;;)
      {
        a.c.a(localc, this.Ltw);
        if ((this.Ltd & 0x2) == 2)
        {
          this.Luo = Collections.unmodifiableList(this.Luo);
          this.Ltd &= 0xFFFFFFFD;
        }
        a.c.a(localc, this.Luo);
        if ((this.Ltd & 0x4) == 4)
        {
          this.Lud = Collections.unmodifiableList(this.Lud);
          this.Ltd &= 0xFFFFFFFB;
        }
        a.c.b(localc, this.Lud);
        a.c.b(localc, i);
        AppMethodBeat.o(58438);
        return localc;
        i = 0;
      }
    }
    
    private void fVV()
    {
      AppMethodBeat.i(58442);
      if ((this.Ltd & 0x2) != 2)
      {
        this.Luo = new ArrayList(this.Luo);
        this.Ltd |= 0x2;
      }
      AppMethodBeat.o(58442);
    }
    
    /* Error */
    private a h(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 99
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 103	d/l/b/a/b/e/a$c:Ltc	Ld/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 108 3 0
      //   17: checkcast 9	d/l/b/a/b/e/a$c
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 71	d/l/b/a/b/e/a$c$a:d	(Ld/l/b/a/b/e/a$c;)Ld/l/b/a/b/e/a$c$a;
      //   26: pop
      //   27: ldc 99
      //   29: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 112	d/l/b/a/b/h/k:LAt	Ld/l/b/a/b/h/q;
      //   39: checkcast 9	d/l/b/a/b/e/a$c
      //   42: astore_2
      //   43: ldc 99
      //   45: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 71	d/l/b/a/b/e/a$c$a:d	(Ld/l/b/a/b/e/a$c;)Ld/l/b/a/b/e/a$c$a;
      //   60: pop
      //   61: ldc 99
      //   63: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public final a d(a.c paramc)
    {
      AppMethodBeat.i(58439);
      if (paramc == a.c.fVS())
      {
        AppMethodBeat.o(58439);
        return this;
      }
      if (paramc.fVp()) {
        ahf(paramc.Ltw);
      }
      if (!a.c.a(paramc).isEmpty())
      {
        if (this.Luo.isEmpty())
        {
          this.Luo = a.c.a(paramc);
          this.Ltd &= 0xFFFFFFFD;
        }
      }
      else if (!a.c.b(paramc).isEmpty())
      {
        if (!this.Lud.isEmpty()) {
          break label169;
        }
        this.Lud = a.c.b(paramc);
        this.Ltd &= 0xFFFFFFFB;
      }
      for (;;)
      {
        a(paramc);
        this.Ltb = this.Ltb.a(a.c.c(paramc));
        AppMethodBeat.o(58439);
        return this;
        fVV();
        this.Luo.addAll(a.c.a(paramc));
        break;
        label169:
        fVP();
        this.Lud.addAll(a.c.b(paramc));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58440);
      int i = 0;
      while (i < this.Luo.size())
      {
        if (!((a.t)this.Luo.get(i)).isInitialized())
        {
          AppMethodBeat.o(58440);
          return false;
        }
        i += 1;
      }
      if (!this.LAd.isInitialized())
      {
        AppMethodBeat.o(58440);
        return false;
      }
      AppMethodBeat.o(58440);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.a.c
 * JD-Core Version:    0.7.0.1
 */