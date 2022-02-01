package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.i.b;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.c.a;
import kotlin.l.b.a.b.h.t;

public final class a$t
  extends i.c<t>
  implements w
{
  public static t<t> aiYa;
  private static final t ajbq;
  private final d aiXZ;
  public int aiYq;
  public int aiZC;
  public a.p ajaQ;
  public int ajaR;
  public a.p ajbr;
  public int ajbs;
  private int bitField0_;
  private int dRJ = -1;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(58986);
    aiYa = new b() {};
    t localt = new t();
    ajbq = localt;
    localt.ktf();
    AppMethodBeat.o(58986);
  }
  
  private a$t()
  {
    this.aiXZ = d.ajeU;
  }
  
  /* Error */
  private a$t(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 59	kotlin/l/b/a/b/h/i$c:<init>	()V
    //   4: ldc 76
    //   6: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 61	kotlin/l/b/a/b/e/a$t:memoizedIsInitialized	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 63	kotlin/l/b/a/b/e/a$t:dRJ	I
    //   19: aload_0
    //   20: invokespecial 54	kotlin/l/b/a/b/e/a$t:ktf	()V
    //   23: invokestatic 80	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
    //   26: astore 6
    //   28: aload 6
    //   30: iconst_1
    //   31: invokestatic 85	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   34: astore 7
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +390 -> 429
    //   42: aload_1
    //   43: invokevirtual 91	kotlin/l/b/a/b/h/e:aac	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+475->525, 0:+478->528, 8:+84->134, 16:+144->194, 26:+190->240, 34:+261->311, 40:+335->385, 48:+357->407
    //   117: aload_1
    //   118: aload 7
    //   120: aload_2
    //   121: iload 4
    //   123: invokevirtual 94	kotlin/l/b/a/b/e/a$t:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   126: ifne -88 -> 38
    //   129: iconst_1
    //   130: istore_3
    //   131: goto -93 -> 38
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   139: iconst_1
    //   140: ior
    //   141: putfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 99	kotlin/l/b/a/b/h/e:aar	()I
    //   149: putfield 101	kotlin/l/b/a/b/e/a$t:aiYq	I
    //   152: goto -114 -> 38
    //   155: astore_1
    //   156: aload_1
    //   157: aload_0
    //   158: putfield 105	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   161: ldc 76
    //   163: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_1
    //   167: athrow
    //   168: astore_1
    //   169: aload 7
    //   171: invokevirtual 108	kotlin/l/b/a/b/h/f:flush	()V
    //   174: aload_0
    //   175: aload 6
    //   177: invokevirtual 114	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   180: putfield 70	kotlin/l/b/a/b/e/a$t:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   183: aload_0
    //   184: invokevirtual 117	kotlin/l/b/a/b/e/a$t:makeExtensionsImmutable	()V
    //   187: ldc 76
    //   189: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_1
    //   193: athrow
    //   194: aload_0
    //   195: aload_0
    //   196: getfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   199: iconst_2
    //   200: ior
    //   201: putfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   204: aload_0
    //   205: aload_1
    //   206: invokevirtual 99	kotlin/l/b/a/b/h/e:aar	()I
    //   209: putfield 119	kotlin/l/b/a/b/e/a$t:aiZC	I
    //   212: goto -174 -> 38
    //   215: astore_1
    //   216: new 73	kotlin/l/b/a/b/h/l
    //   219: dup
    //   220: aload_1
    //   221: invokevirtual 123	java/io/IOException:getMessage	()Ljava/lang/String;
    //   224: invokespecial 126	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   227: astore_1
    //   228: aload_1
    //   229: aload_0
    //   230: putfield 105	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   233: ldc 76
    //   235: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_1
    //   239: athrow
    //   240: aload_0
    //   241: getfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   244: iconst_4
    //   245: iand
    //   246: iconst_4
    //   247: if_icmpne +272 -> 519
    //   250: aload_0
    //   251: getfield 128	kotlin/l/b/a/b/e/a$t:ajaQ	Lkotlin/l/b/a/b/e/a$p;
    //   254: invokevirtual 134	kotlin/l/b/a/b/e/a$p:kvU	()Lkotlin/l/b/a/b/e/a$p$b;
    //   257: astore 5
    //   259: aload_0
    //   260: aload_1
    //   261: getstatic 135	kotlin/l/b/a/b/e/a$p:aiYa	Lkotlin/l/b/a/b/h/t;
    //   264: aload_2
    //   265: invokevirtual 138	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   268: checkcast 130	kotlin/l/b/a/b/e/a$p
    //   271: putfield 128	kotlin/l/b/a/b/e/a$t:ajaQ	Lkotlin/l/b/a/b/e/a$p;
    //   274: aload 5
    //   276: ifnull +22 -> 298
    //   279: aload 5
    //   281: aload_0
    //   282: getfield 128	kotlin/l/b/a/b/e/a$t:ajaQ	Lkotlin/l/b/a/b/e/a$p;
    //   285: invokevirtual 144	kotlin/l/b/a/b/e/a$p$b:k	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   288: pop
    //   289: aload_0
    //   290: aload 5
    //   292: invokevirtual 148	kotlin/l/b/a/b/e/a$p$b:kwd	()Lkotlin/l/b/a/b/e/a$p;
    //   295: putfield 128	kotlin/l/b/a/b/e/a$t:ajaQ	Lkotlin/l/b/a/b/e/a$p;
    //   298: aload_0
    //   299: aload_0
    //   300: getfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   303: iconst_4
    //   304: ior
    //   305: putfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   308: goto -270 -> 38
    //   311: aload_0
    //   312: getfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   315: bipush 16
    //   317: iand
    //   318: bipush 16
    //   320: if_icmpne +193 -> 513
    //   323: aload_0
    //   324: getfield 150	kotlin/l/b/a/b/e/a$t:ajbr	Lkotlin/l/b/a/b/e/a$p;
    //   327: invokevirtual 134	kotlin/l/b/a/b/e/a$p:kvU	()Lkotlin/l/b/a/b/e/a$p$b;
    //   330: astore 5
    //   332: aload_0
    //   333: aload_1
    //   334: getstatic 135	kotlin/l/b/a/b/e/a$p:aiYa	Lkotlin/l/b/a/b/h/t;
    //   337: aload_2
    //   338: invokevirtual 138	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   341: checkcast 130	kotlin/l/b/a/b/e/a$p
    //   344: putfield 150	kotlin/l/b/a/b/e/a$t:ajbr	Lkotlin/l/b/a/b/e/a$p;
    //   347: aload 5
    //   349: ifnull +22 -> 371
    //   352: aload 5
    //   354: aload_0
    //   355: getfield 150	kotlin/l/b/a/b/e/a$t:ajbr	Lkotlin/l/b/a/b/e/a$p;
    //   358: invokevirtual 144	kotlin/l/b/a/b/e/a$p$b:k	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   361: pop
    //   362: aload_0
    //   363: aload 5
    //   365: invokevirtual 148	kotlin/l/b/a/b/e/a$p$b:kwd	()Lkotlin/l/b/a/b/e/a$p;
    //   368: putfield 150	kotlin/l/b/a/b/e/a$t:ajbr	Lkotlin/l/b/a/b/e/a$p;
    //   371: aload_0
    //   372: aload_0
    //   373: getfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   376: bipush 16
    //   378: ior
    //   379: putfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   382: goto -344 -> 38
    //   385: aload_0
    //   386: aload_0
    //   387: getfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   390: bipush 8
    //   392: ior
    //   393: putfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   396: aload_0
    //   397: aload_1
    //   398: invokevirtual 99	kotlin/l/b/a/b/h/e:aar	()I
    //   401: putfield 152	kotlin/l/b/a/b/e/a$t:ajaR	I
    //   404: goto -366 -> 38
    //   407: aload_0
    //   408: aload_0
    //   409: getfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   412: bipush 32
    //   414: ior
    //   415: putfield 96	kotlin/l/b/a/b/e/a$t:bitField0_	I
    //   418: aload_0
    //   419: aload_1
    //   420: invokevirtual 99	kotlin/l/b/a/b/h/e:aar	()I
    //   423: putfield 154	kotlin/l/b/a/b/e/a$t:ajbs	I
    //   426: goto -388 -> 38
    //   429: aload 7
    //   431: invokevirtual 108	kotlin/l/b/a/b/h/f:flush	()V
    //   434: aload_0
    //   435: aload 6
    //   437: invokevirtual 114	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   440: putfield 70	kotlin/l/b/a/b/e/a$t:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   443: aload_0
    //   444: invokevirtual 117	kotlin/l/b/a/b/e/a$t:makeExtensionsImmutable	()V
    //   447: ldc 76
    //   449: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: return
    //   453: astore_1
    //   454: aload_0
    //   455: aload 6
    //   457: invokevirtual 114	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   460: putfield 70	kotlin/l/b/a/b/e/a$t:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   463: goto -20 -> 443
    //   466: astore_1
    //   467: aload_0
    //   468: aload 6
    //   470: invokevirtual 114	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   473: putfield 70	kotlin/l/b/a/b/e/a$t:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   476: ldc 76
    //   478: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   481: aload_1
    //   482: athrow
    //   483: astore_2
    //   484: aload_0
    //   485: aload 6
    //   487: invokevirtual 114	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   490: putfield 70	kotlin/l/b/a/b/e/a$t:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   493: goto -310 -> 183
    //   496: astore_1
    //   497: aload_0
    //   498: aload 6
    //   500: invokevirtual 114	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   503: putfield 70	kotlin/l/b/a/b/e/a$t:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   506: ldc 76
    //   508: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: aload_1
    //   512: athrow
    //   513: aconst_null
    //   514: astore 5
    //   516: goto -184 -> 332
    //   519: aconst_null
    //   520: astore 5
    //   522: goto -263 -> 259
    //   525: goto -409 -> 116
    //   528: iconst_1
    //   529: istore_3
    //   530: goto -492 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	t
    //   0	533	1	parame	kotlin.l.b.a.b.h.e
    //   0	533	2	paramg	kotlin.l.b.a.b.h.g
    //   37	493	3	i	int
    //   46	76	4	j	int
    //   257	264	5	localb	a.p.b
    //   26	473	6	localb1	kotlin.l.b.a.b.h.d.b
    //   34	396	7	localf	f
    // Exception table:
    //   from	to	target	type
    //   42	48	155	kotlin/l/b/a/b/h/l
    //   116	129	155	kotlin/l/b/a/b/h/l
    //   134	152	155	kotlin/l/b/a/b/h/l
    //   194	212	155	kotlin/l/b/a/b/h/l
    //   240	259	155	kotlin/l/b/a/b/h/l
    //   259	274	155	kotlin/l/b/a/b/h/l
    //   279	298	155	kotlin/l/b/a/b/h/l
    //   298	308	155	kotlin/l/b/a/b/h/l
    //   311	332	155	kotlin/l/b/a/b/h/l
    //   332	347	155	kotlin/l/b/a/b/h/l
    //   352	371	155	kotlin/l/b/a/b/h/l
    //   371	382	155	kotlin/l/b/a/b/h/l
    //   385	404	155	kotlin/l/b/a/b/h/l
    //   407	426	155	kotlin/l/b/a/b/h/l
    //   42	48	168	finally
    //   116	129	168	finally
    //   134	152	168	finally
    //   156	168	168	finally
    //   194	212	168	finally
    //   216	240	168	finally
    //   240	259	168	finally
    //   259	274	168	finally
    //   279	298	168	finally
    //   298	308	168	finally
    //   311	332	168	finally
    //   332	347	168	finally
    //   352	371	168	finally
    //   371	382	168	finally
    //   385	404	168	finally
    //   407	426	168	finally
    //   42	48	215	java/io/IOException
    //   116	129	215	java/io/IOException
    //   134	152	215	java/io/IOException
    //   194	212	215	java/io/IOException
    //   240	259	215	java/io/IOException
    //   259	274	215	java/io/IOException
    //   279	298	215	java/io/IOException
    //   298	308	215	java/io/IOException
    //   311	332	215	java/io/IOException
    //   332	347	215	java/io/IOException
    //   352	371	215	java/io/IOException
    //   371	382	215	java/io/IOException
    //   385	404	215	java/io/IOException
    //   407	426	215	java/io/IOException
    //   429	434	453	java/io/IOException
    //   429	434	466	finally
    //   169	174	483	java/io/IOException
    //   169	174	496	finally
  }
  
  private a$t(i.b<t, ?> paramb)
  {
    super(paramb);
    this.aiXZ = paramb.aiXZ;
  }
  
  public static a b(t paramt)
  {
    AppMethodBeat.i(58983);
    paramt = a.kwH().d(paramt);
    AppMethodBeat.o(58983);
    return paramt;
  }
  
  private void ktf()
  {
    AppMethodBeat.i(58979);
    this.aiYq = 0;
    this.aiZC = 0;
    this.ajaQ = a.p.kvH();
    this.ajaR = 0;
    this.ajbr = a.p.kvH();
    this.ajbs = 0;
    AppMethodBeat.o(58979);
  }
  
  public static t kwC()
  {
    return ajbq;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58981);
    getSerializedSize();
    i.c.a locala = kym();
    if ((this.bitField0_ & 0x1) == 1) {
      paramf.cF(1, this.aiYq);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramf.cF(2, this.aiZC);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramf.a(3, this.ajaQ);
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramf.a(4, this.ajbr);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramf.cF(5, this.ajaR);
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramf.cF(6, this.ajbs);
    }
    locala.b(200, paramf);
    paramf.e(this.aiXZ);
    AppMethodBeat.o(58981);
  }
  
  public final boolean ady()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(58982);
    int i = this.dRJ;
    if (i != -1)
    {
      AppMethodBeat.o(58982);
      return i;
    }
    int j = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      j = f.cJ(1, this.aiYq) + 0;
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + f.cJ(2, this.aiZC);
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + f.c(3, this.ajaQ);
    }
    i = j;
    if ((this.bitField0_ & 0x10) == 16) {
      i = j + f.c(4, this.ajbr);
    }
    j = i;
    if ((this.bitField0_ & 0x8) == 8) {
      j = i + f.cJ(5, this.ajaR);
    }
    i = j;
    if ((this.bitField0_ & 0x20) == 32) {
      i = j + f.cJ(6, this.ajbs);
    }
    i = i + aie() + this.aiXZ.size();
    this.dRJ = i;
    AppMethodBeat.o(58982);
    return i;
  }
  
  public final boolean hasName()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58980);
    int i = this.memoizedIsInitialized;
    if (i == 1)
    {
      AppMethodBeat.o(58980);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58980);
      return false;
    }
    if (!hasName())
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58980);
      return false;
    }
    if ((ady()) && (!this.ajaQ.isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58980);
      return false;
    }
    if ((kwD()) && (!this.ajbr.isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58980);
      return false;
    }
    if (!aic())
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58980);
      return false;
    }
    this.memoizedIsInitialized = 1;
    AppMethodBeat.o(58980);
    return true;
  }
  
  public final boolean ktB()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public final boolean kvX()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public final boolean kwD()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public final boolean kwE()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public static final class a
    extends i.b<a.t, a>
    implements w
  {
    private int aiYq;
    private int aiZC;
    private a.p ajaQ;
    private int ajaR;
    private a.p ajbr;
    private int ajbs;
    private int bitField0_;
    
    private a()
    {
      AppMethodBeat.i(58959);
      this.ajaQ = a.p.kvH();
      this.ajbr = a.p.kvH();
      AppMethodBeat.o(58959);
    }
    
    private a aLK(int paramInt)
    {
      this.bitField0_ |= 0x1;
      this.aiYq = paramInt;
      return this;
    }
    
    private a aLL(int paramInt)
    {
      this.bitField0_ |= 0x2;
      this.aiZC = paramInt;
      return this;
    }
    
    private a aLM(int paramInt)
    {
      this.bitField0_ |= 0x8;
      this.ajaR = paramInt;
      return this;
    }
    
    private a aLN(int paramInt)
    {
      this.bitField0_ |= 0x20;
      this.ajbs = paramInt;
      return this;
    }
    
    private a kwF()
    {
      AppMethodBeat.i(58960);
      a locala = new a().d(kwG());
      AppMethodBeat.o(58960);
      return locala;
    }
    
    private a q(a.p paramp)
    {
      AppMethodBeat.i(58965);
      if (((this.bitField0_ & 0x4) == 4) && (this.ajaQ != a.p.kvH())) {}
      for (this.ajaQ = a.p.g(this.ajaQ).k(paramp).kwd();; this.ajaQ = paramp)
      {
        this.bitField0_ |= 0x4;
        AppMethodBeat.o(58965);
        return this;
      }
    }
    
    private a r(a.p paramp)
    {
      AppMethodBeat.i(58966);
      if (((this.bitField0_ & 0x10) == 16) && (this.ajbr != a.p.kvH())) {}
      for (this.ajbr = a.p.g(this.ajbr).k(paramp).kwd();; this.ajbr = paramp)
      {
        this.bitField0_ |= 0x10;
        AppMethodBeat.o(58966);
        return this;
      }
    }
    
    /* Error */
    private a y(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 98
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 102	kotlin/l/b/a/b/e/a$t:aiYa	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 107 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$t
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 74	kotlin/l/b/a/b/e/a$t$a:d	(Lkotlin/l/b/a/b/e/a$t;)Lkotlin/l/b/a/b/e/a$t$a;
      //   30: pop
      //   31: ldc 98
      //   33: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 111	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   43: checkcast 9	kotlin/l/b/a/b/e/a$t
      //   46: astore_2
      //   47: ldc 98
      //   49: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: aload_2
      //   56: ifnull +9 -> 65
      //   59: aload_0
      //   60: aload_2
      //   61: invokevirtual 74	kotlin/l/b/a/b/e/a$t$a:d	(Lkotlin/l/b/a/b/e/a$t;)Lkotlin/l/b/a/b/e/a$t$a;
      //   64: pop
      //   65: ldc 98
      //   67: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   70: aload_1
      //   71: athrow
      //   72: astore_1
      //   73: aload_3
      //   74: astore_2
      //   75: goto -20 -> 55
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	a
      //   0	78	1	parame	kotlin.l.b.a.b.h.e
      //   0	78	2	paramg	kotlin.l.b.a.b.h.g
      //   6	68	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	kotlin/l/b/a/b/h/l
      //   47	54	54	finally
      //   7	21	72	finally
      //   39	47	72	finally
    }
    
    public final a d(a.t paramt)
    {
      AppMethodBeat.i(58962);
      if (paramt == a.t.kwC())
      {
        AppMethodBeat.o(58962);
        return this;
      }
      if (paramt.ktB()) {
        aLK(paramt.aiYq);
      }
      if (paramt.hasName()) {
        aLL(paramt.aiZC);
      }
      if (paramt.ady()) {
        q(paramt.ajaQ);
      }
      if (paramt.kvX()) {
        aLM(paramt.ajaR);
      }
      if (paramt.kwD()) {
        r(paramt.ajbr);
      }
      if (paramt.kwE()) {
        aLN(paramt.ajbs);
      }
      a(paramt);
      this.aiXZ = this.aiXZ.a(a.t.c(paramt));
      AppMethodBeat.o(58962);
      return this;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58963);
      if ((this.bitField0_ & 0x2) == 2) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58963);
        return false;
      }
      if ((this.bitField0_ & 0x4) == 4) {}
      for (i = 1; (i != 0) && (!this.ajaQ.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58963);
        return false;
      }
      if ((this.bitField0_ & 0x10) == 16) {}
      for (i = 1; (i != 0) && (!this.ajbr.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58963);
        return false;
      }
      if (!aic())
      {
        AppMethodBeat.o(58963);
        return false;
      }
      AppMethodBeat.o(58963);
      return true;
    }
    
    public final a.t kwG()
    {
      int j = 1;
      AppMethodBeat.i(58961);
      a.t localt = new a.t(this, (byte)0);
      int k = this.bitField0_;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.t.a(localt, this.aiYq);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.t.b(localt, this.aiZC);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.t.a(localt, this.ajaQ);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.t.c(localt, this.ajaR);
        j = i;
        if ((k & 0x10) == 16) {
          j = i | 0x10;
        }
        a.t.b(localt, this.ajbr);
        i = j;
        if ((k & 0x20) == 32) {
          i = j | 0x20;
        }
        a.t.d(localt, this.ajbs);
        a.t.e(localt, i);
        AppMethodBeat.o(58961);
        return localt;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.t
 * JD-Core Version:    0.7.0.1
 */