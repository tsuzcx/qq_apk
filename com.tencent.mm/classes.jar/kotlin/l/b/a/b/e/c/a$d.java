package kotlin.l.b.a.b.e.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.g;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.h.s;

public final class a$d
  extends i
  implements f
{
  private static final d TCe;
  public static s<d> TwL;
  public List<b> TCf;
  public List<Integer> TCg;
  private int TCh = -1;
  private final d TwK;
  private byte bPe = -1;
  private int bVY = -1;
  
  static
  {
    AppMethodBeat.i(59216);
    TwL = new b() {};
    d locald = new d();
    TCe = locald;
    locald.hEu();
    AppMethodBeat.o(59216);
  }
  
  private a$d()
  {
    this.TwK = d.TDp;
  }
  
  /* Error */
  private a$d(kotlin.l.b.a.b.h.e parame, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 65	kotlin/l/b/a/b/h/i:<init>	()V
    //   4: ldc 84
    //   6: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 67	kotlin/l/b/a/b/e/c/a$d:TCh	I
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 69	kotlin/l/b/a/b/e/c/a$d:bPe	B
    //   19: aload_0
    //   20: iconst_m1
    //   21: putfield 71	kotlin/l/b/a/b/e/c/a$d:bVY	I
    //   24: aload_0
    //   25: invokespecial 60	kotlin/l/b/a/b/e/c/a$d:hEu	()V
    //   28: invokestatic 88	kotlin/l/b/a/b/h/d:hJo	()Lkotlin/l/b/a/b/h/d$b;
    //   31: astore 10
    //   33: aload 10
    //   35: iconst_1
    //   36: invokestatic 94	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   39: astore 11
    //   41: iconst_0
    //   42: istore 5
    //   44: iconst_0
    //   45: istore_3
    //   46: iload 5
    //   48: ifne +499 -> 547
    //   51: iload_3
    //   52: istore 6
    //   54: iload_3
    //   55: istore 7
    //   57: iload_3
    //   58: istore 8
    //   60: aload_1
    //   61: invokevirtual 100	kotlin/l/b/a/b/h/e:yT	()I
    //   64: istore 4
    //   66: iload 4
    //   68: lookupswitch	default:+621->689, 0:+624->692, 10:+72->140, 40:+133->201, 42:+193->261
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
    //   128: invokevirtual 103	kotlin/l/b/a/b/e/c/a$d:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   131: ifne -85 -> 46
    //   134: iconst_1
    //   135: istore 5
    //   137: goto -91 -> 46
    //   140: iload_3
    //   141: iconst_1
    //   142: iand
    //   143: iconst_1
    //   144: if_icmpeq +542 -> 686
    //   147: iload_3
    //   148: istore 6
    //   150: iload_3
    //   151: istore 7
    //   153: iload_3
    //   154: istore 8
    //   156: aload_0
    //   157: new 105	java/util/ArrayList
    //   160: dup
    //   161: invokespecial 106	java/util/ArrayList:<init>	()V
    //   164: putfield 108	kotlin/l/b/a/b/e/c/a$d:TCf	Ljava/util/List;
    //   167: iload_3
    //   168: iconst_1
    //   169: ior
    //   170: istore_3
    //   171: iload_3
    //   172: istore 4
    //   174: iload_3
    //   175: istore 6
    //   177: iload_3
    //   178: istore 7
    //   180: aload_0
    //   181: getfield 108	kotlin/l/b/a/b/e/c/a$d:TCf	Ljava/util/List;
    //   184: aload_1
    //   185: getstatic 109	kotlin/l/b/a/b/e/c/a$d$b:TwL	Lkotlin/l/b/a/b/h/s;
    //   188: aload_2
    //   189: invokevirtual 112	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   192: invokeinterface 118 2 0
    //   197: pop
    //   198: goto -152 -> 46
    //   201: iload_3
    //   202: iconst_2
    //   203: iand
    //   204: iconst_2
    //   205: if_icmpeq +478 -> 683
    //   208: iload_3
    //   209: istore 6
    //   211: iload_3
    //   212: istore 7
    //   214: iload_3
    //   215: istore 8
    //   217: aload_0
    //   218: new 105	java/util/ArrayList
    //   221: dup
    //   222: invokespecial 106	java/util/ArrayList:<init>	()V
    //   225: putfield 120	kotlin/l/b/a/b/e/c/a$d:TCg	Ljava/util/List;
    //   228: iload_3
    //   229: iconst_2
    //   230: ior
    //   231: istore_3
    //   232: iload_3
    //   233: istore 4
    //   235: iload_3
    //   236: istore 6
    //   238: iload_3
    //   239: istore 7
    //   241: aload_0
    //   242: getfield 120	kotlin/l/b/a/b/e/c/a$d:TCg	Ljava/util/List;
    //   245: aload_1
    //   246: invokevirtual 123	kotlin/l/b/a/b/h/e:zi	()I
    //   249: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: invokeinterface 118 2 0
    //   257: pop
    //   258: goto -212 -> 46
    //   261: iload_3
    //   262: istore 6
    //   264: iload_3
    //   265: istore 7
    //   267: iload_3
    //   268: istore 8
    //   270: aload_1
    //   271: aload_1
    //   272: invokevirtual 123	kotlin/l/b/a/b/h/e:zi	()I
    //   275: invokevirtual 133	kotlin/l/b/a/b/h/e:fH	(I)I
    //   278: istore 9
    //   280: iload_3
    //   281: istore 4
    //   283: iload_3
    //   284: iconst_2
    //   285: iand
    //   286: iconst_2
    //   287: if_icmpeq +47 -> 334
    //   290: iload_3
    //   291: istore 4
    //   293: iload_3
    //   294: istore 6
    //   296: iload_3
    //   297: istore 7
    //   299: iload_3
    //   300: istore 8
    //   302: aload_1
    //   303: invokevirtual 136	kotlin/l/b/a/b/h/e:zk	()I
    //   306: ifle +28 -> 334
    //   309: iload_3
    //   310: istore 6
    //   312: iload_3
    //   313: istore 7
    //   315: iload_3
    //   316: istore 8
    //   318: aload_0
    //   319: new 105	java/util/ArrayList
    //   322: dup
    //   323: invokespecial 106	java/util/ArrayList:<init>	()V
    //   326: putfield 120	kotlin/l/b/a/b/e/c/a$d:TCg	Ljava/util/List;
    //   329: iload_3
    //   330: iconst_2
    //   331: ior
    //   332: istore 4
    //   334: iload 4
    //   336: istore 6
    //   338: iload 4
    //   340: istore 7
    //   342: iload 4
    //   344: istore 8
    //   346: aload_1
    //   347: invokevirtual 136	kotlin/l/b/a/b/h/e:zk	()I
    //   350: ifle +128 -> 478
    //   353: iload 4
    //   355: istore 6
    //   357: iload 4
    //   359: istore 7
    //   361: iload 4
    //   363: istore 8
    //   365: aload_0
    //   366: getfield 120	kotlin/l/b/a/b/e/c/a$d:TCg	Ljava/util/List;
    //   369: aload_1
    //   370: invokevirtual 123	kotlin/l/b/a/b/h/e:zi	()I
    //   373: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   376: invokeinterface 118 2 0
    //   381: pop
    //   382: goto -48 -> 334
    //   385: astore_1
    //   386: iload 6
    //   388: istore 7
    //   390: iload 7
    //   392: istore 4
    //   394: aload_1
    //   395: aload_0
    //   396: putfield 140	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   399: iload 7
    //   401: istore 4
    //   403: ldc 84
    //   405: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: iload 7
    //   410: istore 4
    //   412: aload_1
    //   413: athrow
    //   414: astore_1
    //   415: iload 4
    //   417: iconst_1
    //   418: iand
    //   419: iconst_1
    //   420: if_icmpne +14 -> 434
    //   423: aload_0
    //   424: aload_0
    //   425: getfield 108	kotlin/l/b/a/b/e/c/a$d:TCf	Ljava/util/List;
    //   428: invokestatic 146	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   431: putfield 108	kotlin/l/b/a/b/e/c/a$d:TCf	Ljava/util/List;
    //   434: iload 4
    //   436: iconst_2
    //   437: iand
    //   438: iconst_2
    //   439: if_icmpne +14 -> 453
    //   442: aload_0
    //   443: aload_0
    //   444: getfield 120	kotlin/l/b/a/b/e/c/a$d:TCg	Ljava/util/List;
    //   447: invokestatic 146	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   450: putfield 120	kotlin/l/b/a/b/e/c/a$d:TCg	Ljava/util/List;
    //   453: aload 11
    //   455: invokevirtual 149	kotlin/l/b/a/b/h/f:flush	()V
    //   458: aload_0
    //   459: aload 10
    //   461: invokevirtual 155	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   464: putfield 78	kotlin/l/b/a/b/e/c/a$d:TwK	Lkotlin/l/b/a/b/h/d;
    //   467: aload_0
    //   468: invokevirtual 158	kotlin/l/b/a/b/e/c/a$d:Gw	()V
    //   471: ldc 84
    //   473: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   476: aload_1
    //   477: athrow
    //   478: iload 4
    //   480: istore 6
    //   482: iload 4
    //   484: istore 7
    //   486: iload 4
    //   488: istore 8
    //   490: aload_1
    //   491: iload 9
    //   493: invokevirtual 161	kotlin/l/b/a/b/h/e:fI	(I)V
    //   496: iload 4
    //   498: istore_3
    //   499: goto -453 -> 46
    //   502: astore_1
    //   503: iload 7
    //   505: istore 6
    //   507: iload 6
    //   509: istore 4
    //   511: new 81	kotlin/l/b/a/b/h/k
    //   514: dup
    //   515: aload_1
    //   516: invokevirtual 165	java/io/IOException:getMessage	()Ljava/lang/String;
    //   519: invokespecial 168	kotlin/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   522: astore_1
    //   523: iload 6
    //   525: istore 4
    //   527: aload_1
    //   528: aload_0
    //   529: putfield 140	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   532: iload 6
    //   534: istore 4
    //   536: ldc 84
    //   538: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   541: iload 6
    //   543: istore 4
    //   545: aload_1
    //   546: athrow
    //   547: iload_3
    //   548: iconst_1
    //   549: iand
    //   550: iconst_1
    //   551: if_icmpne +14 -> 565
    //   554: aload_0
    //   555: aload_0
    //   556: getfield 108	kotlin/l/b/a/b/e/c/a$d:TCf	Ljava/util/List;
    //   559: invokestatic 146	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   562: putfield 108	kotlin/l/b/a/b/e/c/a$d:TCf	Ljava/util/List;
    //   565: iload_3
    //   566: iconst_2
    //   567: iand
    //   568: iconst_2
    //   569: if_icmpne +14 -> 583
    //   572: aload_0
    //   573: aload_0
    //   574: getfield 120	kotlin/l/b/a/b/e/c/a$d:TCg	Ljava/util/List;
    //   577: invokestatic 146	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   580: putfield 120	kotlin/l/b/a/b/e/c/a$d:TCg	Ljava/util/List;
    //   583: aload 11
    //   585: invokevirtual 149	kotlin/l/b/a/b/h/f:flush	()V
    //   588: aload_0
    //   589: aload 10
    //   591: invokevirtual 155	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   594: putfield 78	kotlin/l/b/a/b/e/c/a$d:TwK	Lkotlin/l/b/a/b/h/d;
    //   597: aload_0
    //   598: invokevirtual 158	kotlin/l/b/a/b/e/c/a$d:Gw	()V
    //   601: ldc 84
    //   603: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   606: return
    //   607: astore_1
    //   608: aload_0
    //   609: aload 10
    //   611: invokevirtual 155	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   614: putfield 78	kotlin/l/b/a/b/e/c/a$d:TwK	Lkotlin/l/b/a/b/h/d;
    //   617: goto -20 -> 597
    //   620: astore_1
    //   621: aload_0
    //   622: aload 10
    //   624: invokevirtual 155	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   627: putfield 78	kotlin/l/b/a/b/e/c/a$d:TwK	Lkotlin/l/b/a/b/h/d;
    //   630: ldc 84
    //   632: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   635: aload_1
    //   636: athrow
    //   637: astore_2
    //   638: aload_0
    //   639: aload 10
    //   641: invokevirtual 155	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   644: putfield 78	kotlin/l/b/a/b/e/c/a$d:TwK	Lkotlin/l/b/a/b/h/d;
    //   647: goto -180 -> 467
    //   650: astore_1
    //   651: aload_0
    //   652: aload 10
    //   654: invokevirtual 155	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   657: putfield 78	kotlin/l/b/a/b/e/c/a$d:TwK	Lkotlin/l/b/a/b/h/d;
    //   660: ldc 84
    //   662: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   665: aload_1
    //   666: athrow
    //   667: astore_1
    //   668: iload 8
    //   670: istore 4
    //   672: goto -257 -> 415
    //   675: astore_1
    //   676: goto -169 -> 507
    //   679: astore_1
    //   680: goto -290 -> 390
    //   683: goto -451 -> 232
    //   686: goto -515 -> 171
    //   689: goto -577 -> 112
    //   692: iconst_1
    //   693: istore 5
    //   695: goto -649 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	698	0	this	d
    //   0	698	1	parame	kotlin.l.b.a.b.h.e
    //   0	698	2	paramg	g
    //   45	523	3	i	int
    //   64	607	4	j	int
    //   42	652	5	k	int
    //   52	490	6	m	int
    //   55	449	7	n	int
    //   58	611	8	i1	int
    //   278	214	9	i2	int
    //   31	622	10	localb	kotlin.l.b.a.b.h.d.b
    //   39	545	11	localf	kotlin.l.b.a.b.h.f
    // Exception table:
    //   from	to	target	type
    //   60	66	385	kotlin/l/b/a/b/h/k
    //   121	134	385	kotlin/l/b/a/b/h/k
    //   156	167	385	kotlin/l/b/a/b/h/k
    //   217	228	385	kotlin/l/b/a/b/h/k
    //   270	280	385	kotlin/l/b/a/b/h/k
    //   302	309	385	kotlin/l/b/a/b/h/k
    //   318	329	385	kotlin/l/b/a/b/h/k
    //   346	353	385	kotlin/l/b/a/b/h/k
    //   365	382	385	kotlin/l/b/a/b/h/k
    //   490	496	385	kotlin/l/b/a/b/h/k
    //   180	198	414	finally
    //   241	258	414	finally
    //   394	399	414	finally
    //   403	408	414	finally
    //   412	414	414	finally
    //   511	523	414	finally
    //   527	532	414	finally
    //   536	541	414	finally
    //   545	547	414	finally
    //   60	66	502	java/io/IOException
    //   121	134	502	java/io/IOException
    //   156	167	502	java/io/IOException
    //   217	228	502	java/io/IOException
    //   270	280	502	java/io/IOException
    //   302	309	502	java/io/IOException
    //   318	329	502	java/io/IOException
    //   346	353	502	java/io/IOException
    //   365	382	502	java/io/IOException
    //   490	496	502	java/io/IOException
    //   583	588	607	java/io/IOException
    //   583	588	620	finally
    //   453	458	637	java/io/IOException
    //   453	458	650	finally
    //   60	66	667	finally
    //   121	134	667	finally
    //   156	167	667	finally
    //   217	228	667	finally
    //   270	280	667	finally
    //   302	309	667	finally
    //   318	329	667	finally
    //   346	353	667	finally
    //   365	382	667	finally
    //   490	496	667	finally
    //   180	198	675	java/io/IOException
    //   241	258	675	java/io/IOException
    //   180	198	679	kotlin/l/b/a/b/h/k
    //   241	258	679	kotlin/l/b/a/b/h/k
  }
  
  private a$d(i.a parama)
  {
    super((byte)0);
    this.TwK = parama.TwK;
  }
  
  public static d f(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(59213);
    paramInputStream = (d)TwL.i(paramInputStream, paramg);
    AppMethodBeat.o(59213);
    return paramInputStream;
  }
  
  private void hEu()
  {
    AppMethodBeat.i(59210);
    this.TCf = Collections.emptyList();
    this.TCg = Collections.emptyList();
    AppMethodBeat.o(59210);
  }
  
  public static d hIF()
  {
    return TCe;
  }
  
  public final void a(kotlin.l.b.a.b.h.f paramf)
  {
    int j = 0;
    AppMethodBeat.i(59211);
    yC();
    int i = 0;
    while (i < this.TCf.size())
    {
      paramf.a(1, (q)this.TCf.get(i));
      i += 1;
    }
    i = j;
    if (this.TCg.size() > 0)
    {
      paramf.hc(42);
      paramf.hc(this.TCh);
      i = j;
    }
    while (i < this.TCg.size())
    {
      paramf.fK(((Integer)this.TCg.get(i)).intValue());
      i += 1;
    }
    paramf.e(this.TwK);
    AppMethodBeat.o(59211);
  }
  
  public final s<d> hEs()
  {
    return TwL;
  }
  
  public final boolean isInitialized()
  {
    int i = this.bPe;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.bPe = 1;
    return true;
  }
  
  public final int yC()
  {
    AppMethodBeat.i(59212);
    int i = this.bVY;
    if (i != -1)
    {
      AppMethodBeat.o(59212);
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.TCf.size())
    {
      i += kotlin.l.b.a.b.h.f.c(1, (q)this.TCf.get(j));
      j += 1;
    }
    int k = 0;
    int m;
    for (j = 0; k < this.TCg.size(); j = m + j)
    {
      m = kotlin.l.b.a.b.h.f.fT(((Integer)this.TCg.get(k)).intValue());
      k += 1;
    }
    k = i + j;
    i = k;
    if (!this.TCg.isEmpty()) {
      i = k + 1 + kotlin.l.b.a.b.h.f.fT(j);
    }
    this.TCh = j;
    i += this.TwK.size();
    this.bVY = i;
    AppMethodBeat.o(59212);
    return i;
  }
  
  public static final class a
    extends i.a<a.d, a>
    implements f
  {
    private List<a.d.b> TCf;
    private List<Integer> TCg;
    private int bOT;
    
    private a()
    {
      AppMethodBeat.i(59161);
      this.TCf = Collections.emptyList();
      this.TCg = Collections.emptyList();
      AppMethodBeat.o(59161);
    }
    
    /* Error */
    private a E(kotlin.l.b.a.b.h.e parame, g paramg)
    {
      // Byte code:
      //   0: ldc 50
      //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 54	kotlin/l/b/a/b/e/c/a$d:TwL	Lkotlin/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 59 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/c/a$d
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 62	kotlin/l/b/a/b/e/c/a$d$a:d	(Lkotlin/l/b/a/b/e/c/a$d;)Lkotlin/l/b/a/b/e/c/a$d$a;
      //   26: pop
      //   27: ldc 50
      //   29: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 66	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
      //   39: checkcast 9	kotlin/l/b/a/b/e/c/a$d
      //   42: astore_2
      //   43: ldc 50
      //   45: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 62	kotlin/l/b/a/b/e/c/a$d$a:d	(Lkotlin/l/b/a/b/e/c/a$d;)Lkotlin/l/b/a/b/e/c/a$d$a;
      //   60: pop
      //   61: ldc 50
      //   63: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   6	64	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	kotlin/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    private a hIG()
    {
      AppMethodBeat.i(59162);
      a locala = new a().d(hIH());
      AppMethodBeat.o(59162);
      return locala;
    }
    
    private a.d hIH()
    {
      AppMethodBeat.i(59163);
      a.d locald = new a.d(this, (byte)0);
      if ((this.bOT & 0x1) == 1)
      {
        this.TCf = Collections.unmodifiableList(this.TCf);
        this.bOT &= 0xFFFFFFFE;
      }
      a.d.a(locald, this.TCf);
      if ((this.bOT & 0x2) == 2)
      {
        this.TCg = Collections.unmodifiableList(this.TCg);
        this.bOT &= 0xFFFFFFFD;
      }
      a.d.b(locald, this.TCg);
      AppMethodBeat.o(59163);
      return locald;
    }
    
    private void hII()
    {
      AppMethodBeat.i(59166);
      if ((this.bOT & 0x1) != 1)
      {
        this.TCf = new ArrayList(this.TCf);
        this.bOT |= 0x1;
      }
      AppMethodBeat.o(59166);
    }
    
    private void hIJ()
    {
      AppMethodBeat.i(59167);
      if ((this.bOT & 0x2) != 2)
      {
        this.TCg = new ArrayList(this.TCg);
        this.bOT |= 0x2;
      }
      AppMethodBeat.o(59167);
    }
    
    public final a d(a.d paramd)
    {
      AppMethodBeat.i(59164);
      if (paramd == a.d.hIF())
      {
        AppMethodBeat.o(59164);
        return this;
      }
      if (!a.d.a(paramd).isEmpty())
      {
        if (this.TCf.isEmpty())
        {
          this.TCf = a.d.a(paramd);
          this.bOT &= 0xFFFFFFFE;
        }
      }
      else if (!a.d.b(paramd).isEmpty())
      {
        if (!this.TCg.isEmpty()) {
          break label148;
        }
        this.TCg = a.d.b(paramd);
        this.bOT &= 0xFFFFFFFD;
      }
      for (;;)
      {
        this.TwK = this.TwK.a(a.d.c(paramd));
        AppMethodBeat.o(59164);
        return this;
        hII();
        this.TCf.addAll(a.d.a(paramd));
        break;
        label148:
        hIJ();
        this.TCg.addAll(a.d.b(paramd));
      }
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
  
  public static final class b
    extends i
    implements e
  {
    private static final b TCi;
    public static s<b> TwL;
    public int TCj;
    public int TCk;
    public Object TCl;
    public a.d.b.b TCm;
    public List<Integer> TCn;
    private int TCo = -1;
    public List<Integer> TCp;
    private int TCq = -1;
    private final d TwK;
    private int bOT;
    private byte bPe = -1;
    private int bVY = -1;
    
    static
    {
      AppMethodBeat.i(59208);
      TwL = new b() {};
      b localb = new b();
      TCi = localb;
      localb.hEu();
      AppMethodBeat.o(59208);
    }
    
    private b()
    {
      this.TwK = d.TDp;
    }
    
    /* Error */
    private b(kotlin.l.b.a.b.h.e parame, g paramg)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 68	kotlin/l/b/a/b/h/i:<init>	()V
      //   4: ldc 89
      //   6: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 70	kotlin/l/b/a/b/e/c/a$d$b:TCo	I
      //   14: aload_0
      //   15: iconst_m1
      //   16: putfield 72	kotlin/l/b/a/b/e/c/a$d$b:TCq	I
      //   19: aload_0
      //   20: iconst_m1
      //   21: putfield 74	kotlin/l/b/a/b/e/c/a$d$b:bPe	B
      //   24: aload_0
      //   25: iconst_m1
      //   26: putfield 76	kotlin/l/b/a/b/e/c/a$d$b:bVY	I
      //   29: aload_0
      //   30: invokespecial 63	kotlin/l/b/a/b/e/c/a$d$b:hEu	()V
      //   33: iconst_0
      //   34: istore_3
      //   35: invokestatic 93	kotlin/l/b/a/b/h/d:hJo	()Lkotlin/l/b/a/b/h/d$b;
      //   38: astore 10
      //   40: aload 10
      //   42: iconst_1
      //   43: invokestatic 99	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
      //   46: astore 11
      //   48: iconst_0
      //   49: istore 8
      //   51: iload 8
      //   53: ifne +952 -> 1005
      //   56: iload_3
      //   57: istore 5
      //   59: iload_3
      //   60: istore 4
      //   62: iload_3
      //   63: istore 6
      //   65: aload_1
      //   66: invokevirtual 105	kotlin/l/b/a/b/h/e:yT	()I
      //   69: istore 7
      //   71: iload 7
      //   73: lookupswitch	default:+1056->1129, 0:+1059->1132, 8:+111->184, 16:+243->316, 24:+323->396, 32:+432->505, 34:+505->578, 40:+656->729, 42:+729->802, 50:+880->953
      //   157: istore 5
      //   159: iload_3
      //   160: istore 4
      //   162: iload_3
      //   163: istore 6
      //   165: aload_0
      //   166: aload_1
      //   167: aload 11
      //   169: aload_2
      //   170: iload 7
      //   172: invokevirtual 108	kotlin/l/b/a/b/e/c/a$d$b:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
      //   175: ifne -124 -> 51
      //   178: iconst_1
      //   179: istore 8
      //   181: goto -130 -> 51
      //   184: iload_3
      //   185: istore 5
      //   187: iload_3
      //   188: istore 4
      //   190: iload_3
      //   191: istore 6
      //   193: aload_0
      //   194: aload_0
      //   195: getfield 110	kotlin/l/b/a/b/e/c/a$d$b:bOT	I
      //   198: iconst_1
      //   199: ior
      //   200: putfield 110	kotlin/l/b/a/b/e/c/a$d$b:bOT	I
      //   203: iload_3
      //   204: istore 5
      //   206: iload_3
      //   207: istore 4
      //   209: iload_3
      //   210: istore 6
      //   212: aload_0
      //   213: aload_1
      //   214: invokevirtual 113	kotlin/l/b/a/b/h/e:zi	()I
      //   217: putfield 115	kotlin/l/b/a/b/e/c/a$d$b:TCj	I
      //   220: goto -169 -> 51
      //   223: astore_1
      //   224: iload 5
      //   226: istore 4
      //   228: aload_1
      //   229: aload_0
      //   230: putfield 119	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
      //   233: iload 5
      //   235: istore 4
      //   237: ldc 89
      //   239: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   242: iload 5
      //   244: istore 4
      //   246: aload_1
      //   247: athrow
      //   248: astore_1
      //   249: iload 4
      //   251: bipush 16
      //   253: iand
      //   254: bipush 16
      //   256: if_icmpne +14 -> 270
      //   259: aload_0
      //   260: aload_0
      //   261: getfield 121	kotlin/l/b/a/b/e/c/a$d$b:TCn	Ljava/util/List;
      //   264: invokestatic 127	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   267: putfield 121	kotlin/l/b/a/b/e/c/a$d$b:TCn	Ljava/util/List;
      //   270: iload 4
      //   272: bipush 32
      //   274: iand
      //   275: bipush 32
      //   277: if_icmpne +14 -> 291
      //   280: aload_0
      //   281: aload_0
      //   282: getfield 129	kotlin/l/b/a/b/e/c/a$d$b:TCp	Ljava/util/List;
      //   285: invokestatic 127	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   288: putfield 129	kotlin/l/b/a/b/e/c/a$d$b:TCp	Ljava/util/List;
      //   291: aload 11
      //   293: invokevirtual 132	kotlin/l/b/a/b/h/f:flush	()V
      //   296: aload_0
      //   297: aload 10
      //   299: invokevirtual 138	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
      //   302: putfield 83	kotlin/l/b/a/b/e/c/a$d$b:TwK	Lkotlin/l/b/a/b/h/d;
      //   305: aload_0
      //   306: invokevirtual 141	kotlin/l/b/a/b/e/c/a$d$b:Gw	()V
      //   309: ldc 89
      //   311: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   314: aload_1
      //   315: athrow
      //   316: iload_3
      //   317: istore 5
      //   319: iload_3
      //   320: istore 4
      //   322: iload_3
      //   323: istore 6
      //   325: aload_0
      //   326: aload_0
      //   327: getfield 110	kotlin/l/b/a/b/e/c/a$d$b:bOT	I
      //   330: iconst_2
      //   331: ior
      //   332: putfield 110	kotlin/l/b/a/b/e/c/a$d$b:bOT	I
      //   335: iload_3
      //   336: istore 5
      //   338: iload_3
      //   339: istore 4
      //   341: iload_3
      //   342: istore 6
      //   344: aload_0
      //   345: aload_1
      //   346: invokevirtual 113	kotlin/l/b/a/b/h/e:zi	()I
      //   349: putfield 143	kotlin/l/b/a/b/e/c/a$d$b:TCk	I
      //   352: goto -301 -> 51
      //   355: astore_1
      //   356: iload 6
      //   358: istore 4
      //   360: new 86	kotlin/l/b/a/b/h/k
      //   363: dup
      //   364: aload_1
      //   365: invokevirtual 147	java/io/IOException:getMessage	()Ljava/lang/String;
      //   368: invokespecial 150	kotlin/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
      //   371: astore_1
      //   372: iload 6
      //   374: istore 4
      //   376: aload_1
      //   377: aload_0
      //   378: putfield 119	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
      //   381: iload 6
      //   383: istore 4
      //   385: ldc 89
      //   387: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   390: iload 6
      //   392: istore 4
      //   394: aload_1
      //   395: athrow
      //   396: iload_3
      //   397: istore 5
      //   399: iload_3
      //   400: istore 4
      //   402: iload_3
      //   403: istore 6
      //   405: aload_1
      //   406: invokevirtual 113	kotlin/l/b/a/b/h/e:zi	()I
      //   409: istore 9
      //   411: iload_3
      //   412: istore 5
      //   414: iload_3
      //   415: istore 4
      //   417: iload_3
      //   418: istore 6
      //   420: iload 9
      //   422: invokestatic 154	kotlin/l/b/a/b/e/c/a$d$b$b:avv	(I)Lkotlin/l/b/a/b/e/c/a$d$b$b;
      //   425: astore 12
      //   427: aload 12
      //   429: ifnonnull +38 -> 467
      //   432: iload_3
      //   433: istore 5
      //   435: iload_3
      //   436: istore 4
      //   438: iload_3
      //   439: istore 6
      //   441: aload 11
      //   443: iload 7
      //   445: invokevirtual 157	kotlin/l/b/a/b/h/f:hc	(I)V
      //   448: iload_3
      //   449: istore 5
      //   451: iload_3
      //   452: istore 4
      //   454: iload_3
      //   455: istore 6
      //   457: aload 11
      //   459: iload 9
      //   461: invokevirtual 157	kotlin/l/b/a/b/h/f:hc	(I)V
      //   464: goto -413 -> 51
      //   467: iload_3
      //   468: istore 5
      //   470: iload_3
      //   471: istore 4
      //   473: iload_3
      //   474: istore 6
      //   476: aload_0
      //   477: aload_0
      //   478: getfield 110	kotlin/l/b/a/b/e/c/a$d$b:bOT	I
      //   481: bipush 8
      //   483: ior
      //   484: putfield 110	kotlin/l/b/a/b/e/c/a$d$b:bOT	I
      //   487: iload_3
      //   488: istore 5
      //   490: iload_3
      //   491: istore 4
      //   493: iload_3
      //   494: istore 6
      //   496: aload_0
      //   497: aload 12
      //   499: putfield 159	kotlin/l/b/a/b/e/c/a$d$b:TCm	Lkotlin/l/b/a/b/e/c/a$d$b$b;
      //   502: goto -451 -> 51
      //   505: iload_3
      //   506: istore 7
      //   508: iload_3
      //   509: bipush 16
      //   511: iand
      //   512: bipush 16
      //   514: if_icmpeq +29 -> 543
      //   517: iload_3
      //   518: istore 5
      //   520: iload_3
      //   521: istore 4
      //   523: iload_3
      //   524: istore 6
      //   526: aload_0
      //   527: new 161	java/util/ArrayList
      //   530: dup
      //   531: invokespecial 162	java/util/ArrayList:<init>	()V
      //   534: putfield 121	kotlin/l/b/a/b/e/c/a$d$b:TCn	Ljava/util/List;
      //   537: iload_3
      //   538: bipush 16
      //   540: ior
      //   541: istore 7
      //   543: iload 7
      //   545: istore 5
      //   547: iload 7
      //   549: istore 4
      //   551: iload 7
      //   553: istore 6
      //   555: aload_0
      //   556: getfield 121	kotlin/l/b/a/b/e/c/a$d$b:TCn	Ljava/util/List;
      //   559: aload_1
      //   560: invokevirtual 113	kotlin/l/b/a/b/h/e:zi	()I
      //   563: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   566: invokeinterface 174 2 0
      //   571: pop
      //   572: iload 7
      //   574: istore_3
      //   575: goto -524 -> 51
      //   578: iload_3
      //   579: istore 5
      //   581: iload_3
      //   582: istore 4
      //   584: iload_3
      //   585: istore 6
      //   587: aload_1
      //   588: aload_1
      //   589: invokevirtual 113	kotlin/l/b/a/b/h/e:zi	()I
      //   592: invokevirtual 178	kotlin/l/b/a/b/h/e:fH	(I)I
      //   595: istore 9
      //   597: iload_3
      //   598: istore 7
      //   600: iload_3
      //   601: bipush 16
      //   603: iand
      //   604: bipush 16
      //   606: if_icmpeq +48 -> 654
      //   609: iload_3
      //   610: istore 5
      //   612: iload_3
      //   613: istore 4
      //   615: iload_3
      //   616: istore 6
      //   618: iload_3
      //   619: istore 7
      //   621: aload_1
      //   622: invokevirtual 181	kotlin/l/b/a/b/h/e:zk	()I
      //   625: ifle +29 -> 654
      //   628: iload_3
      //   629: istore 5
      //   631: iload_3
      //   632: istore 4
      //   634: iload_3
      //   635: istore 6
      //   637: aload_0
      //   638: new 161	java/util/ArrayList
      //   641: dup
      //   642: invokespecial 162	java/util/ArrayList:<init>	()V
      //   645: putfield 121	kotlin/l/b/a/b/e/c/a$d$b:TCn	Ljava/util/List;
      //   648: iload_3
      //   649: bipush 16
      //   651: ior
      //   652: istore 7
      //   654: iload 7
      //   656: istore 5
      //   658: iload 7
      //   660: istore 4
      //   662: iload 7
      //   664: istore 6
      //   666: aload_1
      //   667: invokevirtual 181	kotlin/l/b/a/b/h/e:zk	()I
      //   670: ifle +35 -> 705
      //   673: iload 7
      //   675: istore 5
      //   677: iload 7
      //   679: istore 4
      //   681: iload 7
      //   683: istore 6
      //   685: aload_0
      //   686: getfield 121	kotlin/l/b/a/b/e/c/a$d$b:TCn	Ljava/util/List;
      //   689: aload_1
      //   690: invokevirtual 113	kotlin/l/b/a/b/h/e:zi	()I
      //   693: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   696: invokeinterface 174 2 0
      //   701: pop
      //   702: goto -48 -> 654
      //   705: iload 7
      //   707: istore 5
      //   709: iload 7
      //   711: istore 4
      //   713: iload 7
      //   715: istore 6
      //   717: aload_1
      //   718: iload 9
      //   720: invokevirtual 184	kotlin/l/b/a/b/h/e:fI	(I)V
      //   723: iload 7
      //   725: istore_3
      //   726: goto -675 -> 51
      //   729: iload_3
      //   730: istore 7
      //   732: iload_3
      //   733: bipush 32
      //   735: iand
      //   736: bipush 32
      //   738: if_icmpeq +29 -> 767
      //   741: iload_3
      //   742: istore 5
      //   744: iload_3
      //   745: istore 4
      //   747: iload_3
      //   748: istore 6
      //   750: aload_0
      //   751: new 161	java/util/ArrayList
      //   754: dup
      //   755: invokespecial 162	java/util/ArrayList:<init>	()V
      //   758: putfield 129	kotlin/l/b/a/b/e/c/a$d$b:TCp	Ljava/util/List;
      //   761: iload_3
      //   762: bipush 32
      //   764: ior
      //   765: istore 7
      //   767: iload 7
      //   769: istore 5
      //   771: iload 7
      //   773: istore 4
      //   775: iload 7
      //   777: istore 6
      //   779: aload_0
      //   780: getfield 129	kotlin/l/b/a/b/e/c/a$d$b:TCp	Ljava/util/List;
      //   783: aload_1
      //   784: invokevirtual 113	kotlin/l/b/a/b/h/e:zi	()I
      //   787: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   790: invokeinterface 174 2 0
      //   795: pop
      //   796: iload 7
      //   798: istore_3
      //   799: goto -748 -> 51
      //   802: iload_3
      //   803: istore 5
      //   805: iload_3
      //   806: istore 4
      //   808: iload_3
      //   809: istore 6
      //   811: aload_1
      //   812: aload_1
      //   813: invokevirtual 113	kotlin/l/b/a/b/h/e:zi	()I
      //   816: invokevirtual 178	kotlin/l/b/a/b/h/e:fH	(I)I
      //   819: istore 9
      //   821: iload_3
      //   822: istore 7
      //   824: iload_3
      //   825: bipush 32
      //   827: iand
      //   828: bipush 32
      //   830: if_icmpeq +48 -> 878
      //   833: iload_3
      //   834: istore 5
      //   836: iload_3
      //   837: istore 4
      //   839: iload_3
      //   840: istore 6
      //   842: iload_3
      //   843: istore 7
      //   845: aload_1
      //   846: invokevirtual 181	kotlin/l/b/a/b/h/e:zk	()I
      //   849: ifle +29 -> 878
      //   852: iload_3
      //   853: istore 5
      //   855: iload_3
      //   856: istore 4
      //   858: iload_3
      //   859: istore 6
      //   861: aload_0
      //   862: new 161	java/util/ArrayList
      //   865: dup
      //   866: invokespecial 162	java/util/ArrayList:<init>	()V
      //   869: putfield 129	kotlin/l/b/a/b/e/c/a$d$b:TCp	Ljava/util/List;
      //   872: iload_3
      //   873: bipush 32
      //   875: ior
      //   876: istore 7
      //   878: iload 7
      //   880: istore 5
      //   882: iload 7
      //   884: istore 4
      //   886: iload 7
      //   888: istore 6
      //   890: aload_1
      //   891: invokevirtual 181	kotlin/l/b/a/b/h/e:zk	()I
      //   894: ifle +35 -> 929
      //   897: iload 7
      //   899: istore 5
      //   901: iload 7
      //   903: istore 4
      //   905: iload 7
      //   907: istore 6
      //   909: aload_0
      //   910: getfield 129	kotlin/l/b/a/b/e/c/a$d$b:TCp	Ljava/util/List;
      //   913: aload_1
      //   914: invokevirtual 113	kotlin/l/b/a/b/h/e:zi	()I
      //   917: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   920: invokeinterface 174 2 0
      //   925: pop
      //   926: goto -48 -> 878
      //   929: iload 7
      //   931: istore 5
      //   933: iload 7
      //   935: istore 4
      //   937: iload 7
      //   939: istore 6
      //   941: aload_1
      //   942: iload 9
      //   944: invokevirtual 184	kotlin/l/b/a/b/h/e:fI	(I)V
      //   947: iload 7
      //   949: istore_3
      //   950: goto -899 -> 51
      //   953: iload_3
      //   954: istore 5
      //   956: iload_3
      //   957: istore 4
      //   959: iload_3
      //   960: istore 6
      //   962: aload_1
      //   963: invokevirtual 187	kotlin/l/b/a/b/h/e:hJt	()Lkotlin/l/b/a/b/h/d;
      //   966: astore 12
      //   968: iload_3
      //   969: istore 5
      //   971: iload_3
      //   972: istore 4
      //   974: iload_3
      //   975: istore 6
      //   977: aload_0
      //   978: aload_0
      //   979: getfield 110	kotlin/l/b/a/b/e/c/a$d$b:bOT	I
      //   982: iconst_4
      //   983: ior
      //   984: putfield 110	kotlin/l/b/a/b/e/c/a$d$b:bOT	I
      //   987: iload_3
      //   988: istore 5
      //   990: iload_3
      //   991: istore 4
      //   993: iload_3
      //   994: istore 6
      //   996: aload_0
      //   997: aload 12
      //   999: putfield 189	kotlin/l/b/a/b/e/c/a$d$b:TCl	Ljava/lang/Object;
      //   1002: goto -951 -> 51
      //   1005: iload_3
      //   1006: bipush 16
      //   1008: iand
      //   1009: bipush 16
      //   1011: if_icmpne +14 -> 1025
      //   1014: aload_0
      //   1015: aload_0
      //   1016: getfield 121	kotlin/l/b/a/b/e/c/a$d$b:TCn	Ljava/util/List;
      //   1019: invokestatic 127	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   1022: putfield 121	kotlin/l/b/a/b/e/c/a$d$b:TCn	Ljava/util/List;
      //   1025: iload_3
      //   1026: bipush 32
      //   1028: iand
      //   1029: bipush 32
      //   1031: if_icmpne +14 -> 1045
      //   1034: aload_0
      //   1035: aload_0
      //   1036: getfield 129	kotlin/l/b/a/b/e/c/a$d$b:TCp	Ljava/util/List;
      //   1039: invokestatic 127	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   1042: putfield 129	kotlin/l/b/a/b/e/c/a$d$b:TCp	Ljava/util/List;
      //   1045: aload 11
      //   1047: invokevirtual 132	kotlin/l/b/a/b/h/f:flush	()V
      //   1050: aload_0
      //   1051: aload 10
      //   1053: invokevirtual 138	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
      //   1056: putfield 83	kotlin/l/b/a/b/e/c/a$d$b:TwK	Lkotlin/l/b/a/b/h/d;
      //   1059: aload_0
      //   1060: invokevirtual 141	kotlin/l/b/a/b/e/c/a$d$b:Gw	()V
      //   1063: ldc 89
      //   1065: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1068: return
      //   1069: astore_1
      //   1070: aload_0
      //   1071: aload 10
      //   1073: invokevirtual 138	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
      //   1076: putfield 83	kotlin/l/b/a/b/e/c/a$d$b:TwK	Lkotlin/l/b/a/b/h/d;
      //   1079: goto -20 -> 1059
      //   1082: astore_1
      //   1083: aload_0
      //   1084: aload 10
      //   1086: invokevirtual 138	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
      //   1089: putfield 83	kotlin/l/b/a/b/e/c/a$d$b:TwK	Lkotlin/l/b/a/b/h/d;
      //   1092: ldc 89
      //   1094: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1097: aload_1
      //   1098: athrow
      //   1099: astore_2
      //   1100: aload_0
      //   1101: aload 10
      //   1103: invokevirtual 138	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
      //   1106: putfield 83	kotlin/l/b/a/b/e/c/a$d$b:TwK	Lkotlin/l/b/a/b/h/d;
      //   1109: goto -804 -> 305
      //   1112: astore_1
      //   1113: aload_0
      //   1114: aload 10
      //   1116: invokevirtual 138	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
      //   1119: putfield 83	kotlin/l/b/a/b/e/c/a$d$b:TwK	Lkotlin/l/b/a/b/h/d;
      //   1122: ldc 89
      //   1124: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1127: aload_1
      //   1128: athrow
      //   1129: goto -973 -> 156
      //   1132: iconst_1
      //   1133: istore 8
      //   1135: goto -1084 -> 51
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1138	0	this	b
      //   0	1138	1	parame	kotlin.l.b.a.b.h.e
      //   0	1138	2	paramg	g
      //   34	995	3	i	int
      //   60	932	4	j	int
      //   57	932	5	k	int
      //   63	932	6	m	int
      //   69	879	7	n	int
      //   49	1085	8	i1	int
      //   409	534	9	i2	int
      //   38	1077	10	localb	kotlin.l.b.a.b.h.d.b
      //   46	1000	11	localf	kotlin.l.b.a.b.h.f
      //   425	573	12	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   65	71	223	kotlin/l/b/a/b/h/k
      //   165	178	223	kotlin/l/b/a/b/h/k
      //   193	203	223	kotlin/l/b/a/b/h/k
      //   212	220	223	kotlin/l/b/a/b/h/k
      //   325	335	223	kotlin/l/b/a/b/h/k
      //   344	352	223	kotlin/l/b/a/b/h/k
      //   405	411	223	kotlin/l/b/a/b/h/k
      //   420	427	223	kotlin/l/b/a/b/h/k
      //   441	448	223	kotlin/l/b/a/b/h/k
      //   457	464	223	kotlin/l/b/a/b/h/k
      //   476	487	223	kotlin/l/b/a/b/h/k
      //   496	502	223	kotlin/l/b/a/b/h/k
      //   526	537	223	kotlin/l/b/a/b/h/k
      //   555	572	223	kotlin/l/b/a/b/h/k
      //   587	597	223	kotlin/l/b/a/b/h/k
      //   621	628	223	kotlin/l/b/a/b/h/k
      //   637	648	223	kotlin/l/b/a/b/h/k
      //   666	673	223	kotlin/l/b/a/b/h/k
      //   685	702	223	kotlin/l/b/a/b/h/k
      //   717	723	223	kotlin/l/b/a/b/h/k
      //   750	761	223	kotlin/l/b/a/b/h/k
      //   779	796	223	kotlin/l/b/a/b/h/k
      //   811	821	223	kotlin/l/b/a/b/h/k
      //   845	852	223	kotlin/l/b/a/b/h/k
      //   861	872	223	kotlin/l/b/a/b/h/k
      //   890	897	223	kotlin/l/b/a/b/h/k
      //   909	926	223	kotlin/l/b/a/b/h/k
      //   941	947	223	kotlin/l/b/a/b/h/k
      //   962	968	223	kotlin/l/b/a/b/h/k
      //   977	987	223	kotlin/l/b/a/b/h/k
      //   996	1002	223	kotlin/l/b/a/b/h/k
      //   65	71	248	finally
      //   165	178	248	finally
      //   193	203	248	finally
      //   212	220	248	finally
      //   228	233	248	finally
      //   237	242	248	finally
      //   246	248	248	finally
      //   325	335	248	finally
      //   344	352	248	finally
      //   360	372	248	finally
      //   376	381	248	finally
      //   385	390	248	finally
      //   394	396	248	finally
      //   405	411	248	finally
      //   420	427	248	finally
      //   441	448	248	finally
      //   457	464	248	finally
      //   476	487	248	finally
      //   496	502	248	finally
      //   526	537	248	finally
      //   555	572	248	finally
      //   587	597	248	finally
      //   621	628	248	finally
      //   637	648	248	finally
      //   666	673	248	finally
      //   685	702	248	finally
      //   717	723	248	finally
      //   750	761	248	finally
      //   779	796	248	finally
      //   811	821	248	finally
      //   845	852	248	finally
      //   861	872	248	finally
      //   890	897	248	finally
      //   909	926	248	finally
      //   941	947	248	finally
      //   962	968	248	finally
      //   977	987	248	finally
      //   996	1002	248	finally
      //   65	71	355	java/io/IOException
      //   165	178	355	java/io/IOException
      //   193	203	355	java/io/IOException
      //   212	220	355	java/io/IOException
      //   325	335	355	java/io/IOException
      //   344	352	355	java/io/IOException
      //   405	411	355	java/io/IOException
      //   420	427	355	java/io/IOException
      //   441	448	355	java/io/IOException
      //   457	464	355	java/io/IOException
      //   476	487	355	java/io/IOException
      //   496	502	355	java/io/IOException
      //   526	537	355	java/io/IOException
      //   555	572	355	java/io/IOException
      //   587	597	355	java/io/IOException
      //   621	628	355	java/io/IOException
      //   637	648	355	java/io/IOException
      //   666	673	355	java/io/IOException
      //   685	702	355	java/io/IOException
      //   717	723	355	java/io/IOException
      //   750	761	355	java/io/IOException
      //   779	796	355	java/io/IOException
      //   811	821	355	java/io/IOException
      //   845	852	355	java/io/IOException
      //   861	872	355	java/io/IOException
      //   890	897	355	java/io/IOException
      //   909	926	355	java/io/IOException
      //   941	947	355	java/io/IOException
      //   962	968	355	java/io/IOException
      //   977	987	355	java/io/IOException
      //   996	1002	355	java/io/IOException
      //   1045	1050	1069	java/io/IOException
      //   1045	1050	1082	finally
      //   291	296	1099	java/io/IOException
      //   291	296	1112	finally
    }
    
    private b(i.a parama)
    {
      super();
      this.TwK = parama.TwK;
    }
    
    private void hEu()
    {
      AppMethodBeat.i(59203);
      this.TCj = 1;
      this.TCk = 0;
      this.TCl = "";
      this.TCm = a.d.b.b.TCr;
      this.TCn = Collections.emptyList();
      this.TCp = Collections.emptyList();
      AppMethodBeat.o(59203);
    }
    
    public static b hIL()
    {
      return TCi;
    }
    
    private d hIP()
    {
      AppMethodBeat.i(59202);
      Object localObject = this.TCl;
      if ((localObject instanceof String))
      {
        localObject = d.bud((String)localObject);
        this.TCl = localObject;
        AppMethodBeat.o(59202);
        return localObject;
      }
      localObject = (d)localObject;
      AppMethodBeat.o(59202);
      return localObject;
    }
    
    public final void a(kotlin.l.b.a.b.h.f paramf)
    {
      int j = 0;
      AppMethodBeat.i(59204);
      yC();
      if ((this.bOT & 0x1) == 1) {
        paramf.bs(1, this.TCj);
      }
      if ((this.bOT & 0x2) == 2) {
        paramf.bs(2, this.TCk);
      }
      if ((this.bOT & 0x8) == 8) {
        paramf.nb(3, this.TCm.value);
      }
      if (this.TCn.size() > 0)
      {
        paramf.hc(34);
        paramf.hc(this.TCo);
      }
      int i = 0;
      while (i < this.TCn.size())
      {
        paramf.fK(((Integer)this.TCn.get(i)).intValue());
        i += 1;
      }
      i = j;
      if (this.TCp.size() > 0)
      {
        paramf.hc(42);
        paramf.hc(this.TCq);
        i = j;
      }
      while (i < this.TCp.size())
      {
        paramf.fK(((Integer)this.TCp.get(i)).intValue());
        i += 1;
      }
      if ((this.bOT & 0x4) == 4) {
        paramf.a(6, hIP());
      }
      paramf.e(this.TwK);
      AppMethodBeat.o(59204);
    }
    
    public final s<b> hEs()
    {
      return TwL;
    }
    
    public final boolean hIM()
    {
      return (this.bOT & 0x1) == 1;
    }
    
    public final boolean hIN()
    {
      return (this.bOT & 0x2) == 2;
    }
    
    public final boolean hIO()
    {
      return (this.bOT & 0x4) == 4;
    }
    
    public final boolean hIQ()
    {
      return (this.bOT & 0x8) == 8;
    }
    
    public final boolean isInitialized()
    {
      int i = this.bPe;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      AppMethodBeat.i(59205);
      int i = this.bVY;
      if (i != -1)
      {
        AppMethodBeat.o(59205);
        return i;
      }
      if ((this.bOT & 0x1) == 1) {}
      for (i = kotlin.l.b.a.b.h.f.bu(1, this.TCj) + 0;; i = 0)
      {
        int j = i;
        if ((this.bOT & 0x2) == 2) {
          j = i + kotlin.l.b.a.b.h.f.bu(2, this.TCk);
        }
        if ((this.bOT & 0x8) == 8) {}
        for (i = j + kotlin.l.b.a.b.h.f.bv(3, this.TCm.value);; i = j)
        {
          int k = 0;
          j = 0;
          while (k < this.TCn.size())
          {
            j += kotlin.l.b.a.b.h.f.fT(((Integer)this.TCn.get(k)).intValue());
            k += 1;
          }
          i += j;
          if (!this.TCn.isEmpty()) {
            i = i + 1 + kotlin.l.b.a.b.h.f.fT(j);
          }
          for (;;)
          {
            this.TCo = j;
            k = 0;
            int m;
            for (j = 0; k < this.TCp.size(); j = m + j)
            {
              m = kotlin.l.b.a.b.h.f.fT(((Integer)this.TCp.get(k)).intValue());
              k += 1;
            }
            k = i + j;
            i = k;
            if (!this.TCp.isEmpty()) {
              i = k + 1 + kotlin.l.b.a.b.h.f.fT(j);
            }
            this.TCq = j;
            j = i;
            if ((this.bOT & 0x4) == 4) {
              j = i + kotlin.l.b.a.b.h.f.c(hIP());
            }
            i = j + this.TwK.size();
            this.bVY = i;
            AppMethodBeat.o(59205);
            return i;
          }
        }
      }
    }
    
    public static final class a
      extends i.a<a.d.b, a>
      implements e
    {
      private int TCj;
      private int TCk;
      private Object TCl;
      private a.d.b.b TCm;
      private List<Integer> TCn;
      private List<Integer> TCp;
      private int bOT;
      
      private a()
      {
        AppMethodBeat.i(59179);
        this.TCj = 1;
        this.TCl = "";
        this.TCm = a.d.b.b.TCr;
        this.TCn = Collections.emptyList();
        this.TCp = Collections.emptyList();
        AppMethodBeat.o(59179);
      }
      
      /* Error */
      private a F(kotlin.l.b.a.b.h.e parame, g paramg)
      {
        // Byte code:
        //   0: ldc 71
        //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 75	kotlin/l/b/a/b/e/c/a$d$b:TwL	Lkotlin/l/b/a/b/h/s;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 80 3 0
        //   17: checkcast 14	kotlin/l/b/a/b/e/c/a$d$b
        //   20: astore_1
        //   21: aload_0
        //   22: aload_1
        //   23: invokevirtual 84	kotlin/l/b/a/b/e/c/a$d$b$a:e	(Lkotlin/l/b/a/b/e/c/a$d$b;)Lkotlin/l/b/a/b/e/c/a$d$b$a;
        //   26: pop
        //   27: ldc 71
        //   29: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   32: aload_0
        //   33: areturn
        //   34: astore_1
        //   35: aload_1
        //   36: getfield 88	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
        //   39: checkcast 14	kotlin/l/b/a/b/e/c/a$d$b
        //   42: astore_2
        //   43: ldc 71
        //   45: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   48: aload_1
        //   49: athrow
        //   50: astore_1
        //   51: aload_2
        //   52: ifnull +9 -> 61
        //   55: aload_0
        //   56: aload_2
        //   57: invokevirtual 84	kotlin/l/b/a/b/e/c/a$d$b$a:e	(Lkotlin/l/b/a/b/e/c/a$d$b;)Lkotlin/l/b/a/b/e/c/a$d$b$a;
        //   60: pop
        //   61: ldc 71
        //   63: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
        //   6	64	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	34	kotlin/l/b/a/b/h/k
        //   43	50	50	finally
        //   7	21	68	finally
        //   35	43	68	finally
      }
      
      private a a(a.d.b.b paramb)
      {
        AppMethodBeat.i(59184);
        if (paramb == null)
        {
          paramb = new NullPointerException();
          AppMethodBeat.o(59184);
          throw paramb;
        }
        this.bOT |= 0x8;
        this.TCm = paramb;
        AppMethodBeat.o(59184);
        return this;
      }
      
      private a avt(int paramInt)
      {
        this.bOT |= 0x1;
        this.TCj = paramInt;
        return this;
      }
      
      private a avu(int paramInt)
      {
        this.bOT |= 0x2;
        this.TCk = paramInt;
        return this;
      }
      
      private a hIR()
      {
        AppMethodBeat.i(59180);
        a locala = new a().e(hIS());
        AppMethodBeat.o(59180);
        return locala;
      }
      
      private a.d.b hIS()
      {
        int j = 1;
        AppMethodBeat.i(59181);
        a.d.b localb = new a.d.b(this, (byte)0);
        int k = this.bOT;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          a.d.b.a(localb, this.TCj);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          a.d.b.b(localb, this.TCk);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          a.d.b.a(localb, this.TCl);
          i = j;
          if ((k & 0x8) == 8) {
            i = j | 0x8;
          }
          a.d.b.a(localb, this.TCm);
          if ((this.bOT & 0x10) == 16)
          {
            this.TCn = Collections.unmodifiableList(this.TCn);
            this.bOT &= 0xFFFFFFEF;
          }
          a.d.b.a(localb, this.TCn);
          if ((this.bOT & 0x20) == 32)
          {
            this.TCp = Collections.unmodifiableList(this.TCp);
            this.bOT &= 0xFFFFFFDF;
          }
          a.d.b.b(localb, this.TCp);
          a.d.b.c(localb, i);
          AppMethodBeat.o(59181);
          return localb;
          j = 0;
        }
      }
      
      private void hIT()
      {
        AppMethodBeat.i(59185);
        if ((this.bOT & 0x10) != 16)
        {
          this.TCn = new ArrayList(this.TCn);
          this.bOT |= 0x10;
        }
        AppMethodBeat.o(59185);
      }
      
      private void hIU()
      {
        AppMethodBeat.i(59186);
        if ((this.bOT & 0x20) != 32)
        {
          this.TCp = new ArrayList(this.TCp);
          this.bOT |= 0x20;
        }
        AppMethodBeat.o(59186);
      }
      
      public final a e(a.d.b paramb)
      {
        AppMethodBeat.i(59182);
        if (paramb == a.d.b.hIL())
        {
          AppMethodBeat.o(59182);
          return this;
        }
        if (paramb.hIM()) {
          avt(paramb.TCj);
        }
        if (paramb.hIN()) {
          avu(paramb.TCk);
        }
        if (paramb.hIO())
        {
          this.bOT |= 0x4;
          this.TCl = a.d.b.a(paramb);
        }
        if (paramb.hIQ()) {
          a(paramb.TCm);
        }
        if (!a.d.b.b(paramb).isEmpty())
        {
          if (this.TCn.isEmpty())
          {
            this.TCn = a.d.b.b(paramb);
            this.bOT &= 0xFFFFFFEF;
          }
        }
        else if (!a.d.b.c(paramb).isEmpty())
        {
          if (!this.TCp.isEmpty()) {
            break label221;
          }
          this.TCp = a.d.b.c(paramb);
          this.bOT &= 0xFFFFFFDF;
        }
        for (;;)
        {
          this.TwK = this.TwK.a(a.d.b.d(paramb));
          AppMethodBeat.o(59182);
          return this;
          hIT();
          this.TCn.addAll(a.d.b.b(paramb));
          break;
          label221:
          hIU();
          this.TCp.addAll(a.d.b.c(paramb));
        }
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.d
 * JD-Core Version:    0.7.0.1
 */