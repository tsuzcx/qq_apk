package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.i.b;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.c.a;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.h.t;

public final class a$c
  extends i.c<c>
  implements f
{
  public static t<c> aaZC;
  private static final c abaJ;
  private final d aaZB;
  public int aaZS;
  public List<a.t> abaK;
  public List<Integer> abaz;
  private int bQS;
  private byte bRd = -1;
  private int bXW = -1;
  
  static
  {
    AppMethodBeat.i(58462);
    aaZC = new b() {};
    c localc = new c();
    abaJ = localc;
    localc.iIN();
    AppMethodBeat.o(58462);
  }
  
  private a$c()
  {
    this.aaZB = d.abgb;
  }
  
  /* Error */
  private a$c(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 58	kotlin/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 75
    //   6: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 60	kotlin/l/b/a/b/e/a$c:bRd	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 62	kotlin/l/b/a/b/e/a$c:bXW	I
    //   19: aload_0
    //   20: invokespecial 53	kotlin/l/b/a/b/e/a$c:iIN	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 79	kotlin/l/b/a/b/h/d:iNH	()Lkotlin/l/b/a/b/h/d$b;
    //   28: astore 10
    //   30: aload 10
    //   32: iconst_1
    //   33: invokestatic 85	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   36: astore 11
    //   38: iconst_0
    //   39: istore 5
    //   41: iload 5
    //   43: ifne +551 -> 594
    //   46: iload_3
    //   47: istore 6
    //   49: iload_3
    //   50: istore 7
    //   52: iload_3
    //   53: istore 8
    //   55: aload_1
    //   56: invokevirtual 91	kotlin/l/b/a/b/h/e:Av	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+665->728, 0:+668->731, 8:+77->140, 18:+209->272, 248:+270->333, 250:+330->393
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
    //   128: invokevirtual 94	kotlin/l/b/a/b/e/a$c:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
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
    //   151: getfield 96	kotlin/l/b/a/b/e/a$c:bQS	I
    //   154: iconst_1
    //   155: ior
    //   156: putfield 96	kotlin/l/b/a/b/e/a$c:bQS	I
    //   159: iload_3
    //   160: istore 6
    //   162: iload_3
    //   163: istore 7
    //   165: iload_3
    //   166: istore 8
    //   168: aload_0
    //   169: aload_1
    //   170: invokevirtual 99	kotlin/l/b/a/b/h/e:AK	()I
    //   173: putfield 101	kotlin/l/b/a/b/e/a$c:aaZS	I
    //   176: goto -135 -> 41
    //   179: astore_1
    //   180: iload 6
    //   182: istore 7
    //   184: iload 7
    //   186: istore 4
    //   188: aload_1
    //   189: aload_0
    //   190: putfield 105	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
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
    //   219: getfield 107	kotlin/l/b/a/b/e/a$c:abaK	Ljava/util/List;
    //   222: invokestatic 113	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   225: putfield 107	kotlin/l/b/a/b/e/a$c:abaK	Ljava/util/List;
    //   228: iload 4
    //   230: iconst_4
    //   231: iand
    //   232: iconst_4
    //   233: if_icmpne +14 -> 247
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 115	kotlin/l/b/a/b/e/a$c:abaz	Ljava/util/List;
    //   241: invokestatic 113	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   244: putfield 115	kotlin/l/b/a/b/e/a$c:abaz	Ljava/util/List;
    //   247: aload 11
    //   249: invokevirtual 118	kotlin/l/b/a/b/h/f:flush	()V
    //   252: aload_0
    //   253: aload 10
    //   255: invokevirtual 124	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   258: putfield 69	kotlin/l/b/a/b/e/a$c:aaZB	Lkotlin/l/b/a/b/h/d;
    //   261: aload_0
    //   262: invokevirtual 127	kotlin/l/b/a/b/e/a$c:HZ	()V
    //   265: ldc 75
    //   267: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload_1
    //   271: athrow
    //   272: iload_3
    //   273: iconst_2
    //   274: iand
    //   275: iconst_2
    //   276: if_icmpeq +449 -> 725
    //   279: iload_3
    //   280: istore 6
    //   282: iload_3
    //   283: istore 7
    //   285: iload_3
    //   286: istore 8
    //   288: aload_0
    //   289: new 129	java/util/ArrayList
    //   292: dup
    //   293: invokespecial 130	java/util/ArrayList:<init>	()V
    //   296: putfield 107	kotlin/l/b/a/b/e/a$c:abaK	Ljava/util/List;
    //   299: iload_3
    //   300: iconst_2
    //   301: ior
    //   302: istore_3
    //   303: iload_3
    //   304: istore 4
    //   306: iload_3
    //   307: istore 6
    //   309: iload_3
    //   310: istore 7
    //   312: aload_0
    //   313: getfield 107	kotlin/l/b/a/b/e/a$c:abaK	Ljava/util/List;
    //   316: aload_1
    //   317: getstatic 133	kotlin/l/b/a/b/e/a$t:aaZC	Lkotlin/l/b/a/b/h/t;
    //   320: aload_2
    //   321: invokevirtual 136	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   324: invokeinterface 142 2 0
    //   329: pop
    //   330: goto -289 -> 41
    //   333: iload_3
    //   334: iconst_4
    //   335: iand
    //   336: iconst_4
    //   337: if_icmpeq +385 -> 722
    //   340: iload_3
    //   341: istore 6
    //   343: iload_3
    //   344: istore 7
    //   346: iload_3
    //   347: istore 8
    //   349: aload_0
    //   350: new 129	java/util/ArrayList
    //   353: dup
    //   354: invokespecial 130	java/util/ArrayList:<init>	()V
    //   357: putfield 115	kotlin/l/b/a/b/e/a$c:abaz	Ljava/util/List;
    //   360: iload_3
    //   361: iconst_4
    //   362: ior
    //   363: istore_3
    //   364: iload_3
    //   365: istore 4
    //   367: iload_3
    //   368: istore 6
    //   370: iload_3
    //   371: istore 7
    //   373: aload_0
    //   374: getfield 115	kotlin/l/b/a/b/e/a$c:abaz	Ljava/util/List;
    //   377: aload_1
    //   378: invokevirtual 99	kotlin/l/b/a/b/h/e:AK	()I
    //   381: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: invokeinterface 142 2 0
    //   389: pop
    //   390: goto -349 -> 41
    //   393: iload_3
    //   394: istore 6
    //   396: iload_3
    //   397: istore 7
    //   399: iload_3
    //   400: istore 8
    //   402: aload_1
    //   403: aload_1
    //   404: invokevirtual 99	kotlin/l/b/a/b/h/e:AK	()I
    //   407: invokevirtual 152	kotlin/l/b/a/b/h/e:gA	(I)I
    //   410: istore 9
    //   412: iload_3
    //   413: istore 4
    //   415: iload_3
    //   416: iconst_4
    //   417: iand
    //   418: iconst_4
    //   419: if_icmpeq +47 -> 466
    //   422: iload_3
    //   423: istore 6
    //   425: iload_3
    //   426: istore 4
    //   428: iload_3
    //   429: istore 7
    //   431: iload_3
    //   432: istore 8
    //   434: aload_1
    //   435: invokevirtual 155	kotlin/l/b/a/b/h/e:AM	()I
    //   438: ifle +28 -> 466
    //   441: iload_3
    //   442: istore 6
    //   444: iload_3
    //   445: istore 7
    //   447: iload_3
    //   448: istore 8
    //   450: aload_0
    //   451: new 129	java/util/ArrayList
    //   454: dup
    //   455: invokespecial 130	java/util/ArrayList:<init>	()V
    //   458: putfield 115	kotlin/l/b/a/b/e/a$c:abaz	Ljava/util/List;
    //   461: iload_3
    //   462: iconst_4
    //   463: ior
    //   464: istore 4
    //   466: iload 4
    //   468: istore 6
    //   470: iload 4
    //   472: istore 7
    //   474: iload 4
    //   476: istore 8
    //   478: aload_1
    //   479: invokevirtual 155	kotlin/l/b/a/b/h/e:AM	()I
    //   482: ifle +80 -> 562
    //   485: iload 4
    //   487: istore 6
    //   489: iload 4
    //   491: istore 7
    //   493: iload 4
    //   495: istore 8
    //   497: aload_0
    //   498: getfield 115	kotlin/l/b/a/b/e/a$c:abaz	Ljava/util/List;
    //   501: aload_1
    //   502: invokevirtual 99	kotlin/l/b/a/b/h/e:AK	()I
    //   505: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   508: invokeinterface 142 2 0
    //   513: pop
    //   514: goto -48 -> 466
    //   517: astore_1
    //   518: iload 7
    //   520: istore 6
    //   522: iload 6
    //   524: istore 4
    //   526: new 72	kotlin/l/b/a/b/h/l
    //   529: dup
    //   530: aload_1
    //   531: invokevirtual 159	java/io/IOException:getMessage	()Ljava/lang/String;
    //   534: invokespecial 162	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   537: astore_1
    //   538: iload 6
    //   540: istore 4
    //   542: aload_1
    //   543: aload_0
    //   544: putfield 105	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   547: iload 6
    //   549: istore 4
    //   551: ldc 75
    //   553: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   556: iload 6
    //   558: istore 4
    //   560: aload_1
    //   561: athrow
    //   562: iload 4
    //   564: istore 6
    //   566: iload 4
    //   568: istore 7
    //   570: iload 4
    //   572: istore 8
    //   574: aload_1
    //   575: iload 9
    //   577: invokevirtual 165	kotlin/l/b/a/b/h/e:gB	(I)V
    //   580: iload 4
    //   582: istore_3
    //   583: goto -542 -> 41
    //   586: astore_1
    //   587: iload 8
    //   589: istore 4
    //   591: goto -382 -> 209
    //   594: iload_3
    //   595: iconst_2
    //   596: iand
    //   597: iconst_2
    //   598: if_icmpne +14 -> 612
    //   601: aload_0
    //   602: aload_0
    //   603: getfield 107	kotlin/l/b/a/b/e/a$c:abaK	Ljava/util/List;
    //   606: invokestatic 113	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   609: putfield 107	kotlin/l/b/a/b/e/a$c:abaK	Ljava/util/List;
    //   612: iload_3
    //   613: iconst_4
    //   614: iand
    //   615: iconst_4
    //   616: if_icmpne +14 -> 630
    //   619: aload_0
    //   620: aload_0
    //   621: getfield 115	kotlin/l/b/a/b/e/a$c:abaz	Ljava/util/List;
    //   624: invokestatic 113	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   627: putfield 115	kotlin/l/b/a/b/e/a$c:abaz	Ljava/util/List;
    //   630: aload 11
    //   632: invokevirtual 118	kotlin/l/b/a/b/h/f:flush	()V
    //   635: aload_0
    //   636: aload 10
    //   638: invokevirtual 124	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   641: putfield 69	kotlin/l/b/a/b/e/a$c:aaZB	Lkotlin/l/b/a/b/h/d;
    //   644: aload_0
    //   645: invokevirtual 127	kotlin/l/b/a/b/e/a$c:HZ	()V
    //   648: ldc 75
    //   650: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   653: return
    //   654: astore_1
    //   655: aload_0
    //   656: aload 10
    //   658: invokevirtual 124	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   661: putfield 69	kotlin/l/b/a/b/e/a$c:aaZB	Lkotlin/l/b/a/b/h/d;
    //   664: goto -20 -> 644
    //   667: astore_1
    //   668: aload_0
    //   669: aload 10
    //   671: invokevirtual 124	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   674: putfield 69	kotlin/l/b/a/b/e/a$c:aaZB	Lkotlin/l/b/a/b/h/d;
    //   677: ldc 75
    //   679: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   682: aload_1
    //   683: athrow
    //   684: astore_2
    //   685: aload_0
    //   686: aload 10
    //   688: invokevirtual 124	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   691: putfield 69	kotlin/l/b/a/b/e/a$c:aaZB	Lkotlin/l/b/a/b/h/d;
    //   694: goto -433 -> 261
    //   697: astore_1
    //   698: aload_0
    //   699: aload 10
    //   701: invokevirtual 124	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   704: putfield 69	kotlin/l/b/a/b/e/a$c:aaZB	Lkotlin/l/b/a/b/h/d;
    //   707: ldc 75
    //   709: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   712: aload_1
    //   713: athrow
    //   714: astore_1
    //   715: goto -193 -> 522
    //   718: astore_1
    //   719: goto -535 -> 184
    //   722: goto -358 -> 364
    //   725: goto -422 -> 303
    //   728: goto -616 -> 112
    //   731: iconst_1
    //   732: istore 5
    //   734: goto -693 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	737	0	this	c
    //   0	737	1	parame	kotlin.l.b.a.b.h.e
    //   0	737	2	paramg	kotlin.l.b.a.b.h.g
    //   24	591	3	i	int
    //   59	531	4	j	int
    //   39	694	5	k	int
    //   47	518	6	m	int
    //   50	519	7	n	int
    //   53	535	8	i1	int
    //   410	166	9	i2	int
    //   28	672	10	localb	kotlin.l.b.a.b.h.d.b
    //   36	595	11	localf	kotlin.l.b.a.b.h.f
    // Exception table:
    //   from	to	target	type
    //   55	61	179	kotlin/l/b/a/b/h/l
    //   121	134	179	kotlin/l/b/a/b/h/l
    //   149	159	179	kotlin/l/b/a/b/h/l
    //   168	176	179	kotlin/l/b/a/b/h/l
    //   288	299	179	kotlin/l/b/a/b/h/l
    //   349	360	179	kotlin/l/b/a/b/h/l
    //   402	412	179	kotlin/l/b/a/b/h/l
    //   434	441	179	kotlin/l/b/a/b/h/l
    //   450	461	179	kotlin/l/b/a/b/h/l
    //   478	485	179	kotlin/l/b/a/b/h/l
    //   497	514	179	kotlin/l/b/a/b/h/l
    //   574	580	179	kotlin/l/b/a/b/h/l
    //   188	193	208	finally
    //   197	202	208	finally
    //   206	208	208	finally
    //   312	330	208	finally
    //   373	390	208	finally
    //   526	538	208	finally
    //   542	547	208	finally
    //   551	556	208	finally
    //   560	562	208	finally
    //   55	61	517	java/io/IOException
    //   121	134	517	java/io/IOException
    //   149	159	517	java/io/IOException
    //   168	176	517	java/io/IOException
    //   288	299	517	java/io/IOException
    //   349	360	517	java/io/IOException
    //   402	412	517	java/io/IOException
    //   434	441	517	java/io/IOException
    //   450	461	517	java/io/IOException
    //   478	485	517	java/io/IOException
    //   497	514	517	java/io/IOException
    //   574	580	517	java/io/IOException
    //   55	61	586	finally
    //   121	134	586	finally
    //   149	159	586	finally
    //   168	176	586	finally
    //   288	299	586	finally
    //   349	360	586	finally
    //   402	412	586	finally
    //   434	441	586	finally
    //   450	461	586	finally
    //   478	485	586	finally
    //   497	514	586	finally
    //   574	580	586	finally
    //   630	635	654	java/io/IOException
    //   630	635	667	finally
    //   247	252	684	java/io/IOException
    //   247	252	697	finally
    //   312	330	714	java/io/IOException
    //   373	390	714	java/io/IOException
    //   312	330	718	kotlin/l/b/a/b/h/l
    //   373	390	718	kotlin/l/b/a/b/h/l
  }
  
  private a$c(i.b<c, ?> paramb)
  {
    super(paramb);
    this.aaZB = paramb.aaZB;
  }
  
  private void iIN()
  {
    AppMethodBeat.i(58456);
    this.aaZS = 6;
    this.abaK = Collections.emptyList();
    this.abaz = Collections.emptyList();
    AppMethodBeat.o(58456);
  }
  
  public static c iJM()
  {
    return abaJ;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(58459);
    int i = this.bXW;
    if (i != -1)
    {
      AppMethodBeat.o(58459);
      return i;
    }
    if ((this.bQS & 0x1) == 1) {}
    for (i = kotlin.l.b.a.b.h.f.bM(1, this.aaZS) + 0;; i = 0)
    {
      int j = 0;
      while (j < this.abaK.size())
      {
        i += kotlin.l.b.a.b.h.f.c(2, (r)this.abaK.get(j));
        j += 1;
      }
      int k = 0;
      int m;
      for (j = 0; k < this.abaz.size(); j = m + j)
      {
        m = kotlin.l.b.a.b.h.f.gM(((Integer)this.abaz.get(k)).intValue());
        k += 1;
      }
      i = i + j + this.abaz.size() * 2 + Ii() + this.aaZB.size();
      this.bXW = i;
      AppMethodBeat.o(58459);
      return i;
    }
  }
  
  public final void a(kotlin.l.b.a.b.h.f paramf)
  {
    int k = 0;
    AppMethodBeat.i(58458);
    Ad();
    i.c.a locala = iNU();
    if ((this.bQS & 0x1) == 1) {
      paramf.bJ(1, this.aaZS);
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.abaK.size()) {
        break;
      }
      paramf.a(2, (r)this.abaK.get(i));
      i += 1;
    }
    while (j < this.abaz.size())
    {
      paramf.bJ(31, ((Integer)this.abaz.get(j)).intValue());
      j += 1;
    }
    locala.b(19000, paramf);
    paramf.e(this.aaZB);
    AppMethodBeat.o(58458);
  }
  
  public final boolean iJj()
  {
    return (this.bQS & 0x1) == 1;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58457);
    int i = this.bRd;
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
    while (i < this.abaK.size())
    {
      if (!((a.t)this.abaK.get(i)).isInitialized())
      {
        this.bRd = 0;
        AppMethodBeat.o(58457);
        return false;
      }
      i += 1;
    }
    if (!Ig())
    {
      this.bRd = 0;
      AppMethodBeat.o(58457);
      return false;
    }
    this.bRd = 1;
    AppMethodBeat.o(58457);
    return true;
  }
  
  public static final class a
    extends i.b<a.c, a>
    implements f
  {
    private int aaZS;
    private List<a.t> abaK;
    private List<Integer> abaz;
    private int bQS;
    
    private a()
    {
      AppMethodBeat.i(58436);
      this.aaZS = 6;
      this.abaK = Collections.emptyList();
      this.abaz = Collections.emptyList();
      AppMethodBeat.o(58436);
    }
    
    private a aEa(int paramInt)
    {
      this.bQS |= 0x1;
      this.aaZS = paramInt;
      return this;
    }
    
    /* Error */
    private a h(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 57
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 61	kotlin/l/b/a/b/e/a$c:aaZC	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 66 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$c
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 70	kotlin/l/b/a/b/e/a$c$a:d	(Lkotlin/l/b/a/b/e/a$c;)Lkotlin/l/b/a/b/e/a$c$a;
      //   26: pop
      //   27: ldc 57
      //   29: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 74	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
      //   39: checkcast 9	kotlin/l/b/a/b/e/a$c
      //   42: astore_2
      //   43: ldc 57
      //   45: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 70	kotlin/l/b/a/b/e/a$c$a:d	(Lkotlin/l/b/a/b/e/a$c;)Lkotlin/l/b/a/b/e/a$c$a;
      //   60: pop
      //   61: ldc 57
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
    
    private void iJJ()
    {
      AppMethodBeat.i(58443);
      if ((this.bQS & 0x4) != 4)
      {
        this.abaz = new ArrayList(this.abaz);
        this.bQS |= 0x4;
      }
      AppMethodBeat.o(58443);
    }
    
    private a iJN()
    {
      AppMethodBeat.i(58437);
      a locala = new a().d(iJO());
      AppMethodBeat.o(58437);
      return locala;
    }
    
    private a.c iJO()
    {
      int i = 1;
      AppMethodBeat.i(58438);
      a.c localc = new a.c(this, (byte)0);
      if ((this.bQS & 0x1) == 1) {}
      for (;;)
      {
        a.c.a(localc, this.aaZS);
        if ((this.bQS & 0x2) == 2)
        {
          this.abaK = Collections.unmodifiableList(this.abaK);
          this.bQS &= 0xFFFFFFFD;
        }
        a.c.a(localc, this.abaK);
        if ((this.bQS & 0x4) == 4)
        {
          this.abaz = Collections.unmodifiableList(this.abaz);
          this.bQS &= 0xFFFFFFFB;
        }
        a.c.b(localc, this.abaz);
        a.c.b(localc, i);
        AppMethodBeat.o(58438);
        return localc;
        i = 0;
      }
    }
    
    private void iJP()
    {
      AppMethodBeat.i(58442);
      if ((this.bQS & 0x2) != 2)
      {
        this.abaK = new ArrayList(this.abaK);
        this.bQS |= 0x2;
      }
      AppMethodBeat.o(58442);
    }
    
    public final a d(a.c paramc)
    {
      AppMethodBeat.i(58439);
      if (paramc == a.c.iJM())
      {
        AppMethodBeat.o(58439);
        return this;
      }
      if (paramc.iJj()) {
        aEa(paramc.aaZS);
      }
      if (!a.c.a(paramc).isEmpty())
      {
        if (this.abaK.isEmpty())
        {
          this.abaK = a.c.a(paramc);
          this.bQS &= 0xFFFFFFFD;
        }
      }
      else if (!a.c.b(paramc).isEmpty())
      {
        if (!this.abaz.isEmpty()) {
          break label169;
        }
        this.abaz = a.c.b(paramc);
        this.bQS &= 0xFFFFFFFB;
      }
      for (;;)
      {
        a(paramc);
        this.aaZB = this.aaZB.a(a.c.c(paramc));
        AppMethodBeat.o(58439);
        return this;
        iJP();
        this.abaK.addAll(a.c.a(paramc));
        break;
        label169:
        iJJ();
        this.abaz.addAll(a.c.b(paramc));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58440);
      int i = 0;
      while (i < this.abaK.size())
      {
        if (!((a.t)this.abaK.get(i)).isInitialized())
        {
          AppMethodBeat.o(58440);
          return false;
        }
        i += 1;
      }
      if (!Ig())
      {
        AppMethodBeat.o(58440);
        return false;
      }
      AppMethodBeat.o(58440);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.c
 * JD-Core Version:    0.7.0.1
 */