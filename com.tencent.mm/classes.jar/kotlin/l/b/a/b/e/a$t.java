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
  public static t<t> aaZC;
  private static final t abcP;
  private final d aaZB;
  public int aaZS;
  public int abbb;
  public a.p abcQ;
  public int abcR;
  public a.p abcp;
  public int abcq;
  private int bQS;
  private byte bRd = -1;
  private int bXW = -1;
  
  static
  {
    AppMethodBeat.i(58986);
    aaZC = new b() {};
    t localt = new t();
    abcP = localt;
    localt.iIN();
    AppMethodBeat.o(58986);
  }
  
  private a$t()
  {
    this.aaZB = d.abgb;
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
    //   11: putfield 61	kotlin/l/b/a/b/e/a$t:bRd	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 63	kotlin/l/b/a/b/e/a$t:bXW	I
    //   19: aload_0
    //   20: invokespecial 54	kotlin/l/b/a/b/e/a$t:iIN	()V
    //   23: invokestatic 80	kotlin/l/b/a/b/h/d:iNH	()Lkotlin/l/b/a/b/h/d$b;
    //   26: astore 6
    //   28: aload 6
    //   30: iconst_1
    //   31: invokestatic 86	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   34: astore 7
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +390 -> 429
    //   42: aload_1
    //   43: invokevirtual 92	kotlin/l/b/a/b/h/e:Av	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+475->525, 0:+478->528, 8:+84->134, 16:+144->194, 26:+190->240, 34:+261->311, 40:+335->385, 48:+357->407
    //   117: aload_1
    //   118: aload 7
    //   120: aload_2
    //   121: iload 4
    //   123: invokevirtual 95	kotlin/l/b/a/b/e/a$t:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   126: ifne -88 -> 38
    //   129: iconst_1
    //   130: istore_3
    //   131: goto -93 -> 38
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   139: iconst_1
    //   140: ior
    //   141: putfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 100	kotlin/l/b/a/b/h/e:AK	()I
    //   149: putfield 102	kotlin/l/b/a/b/e/a$t:aaZS	I
    //   152: goto -114 -> 38
    //   155: astore_1
    //   156: aload_1
    //   157: aload_0
    //   158: putfield 106	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   161: ldc 76
    //   163: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_1
    //   167: athrow
    //   168: astore_1
    //   169: aload 7
    //   171: invokevirtual 109	kotlin/l/b/a/b/h/f:flush	()V
    //   174: aload_0
    //   175: aload 6
    //   177: invokevirtual 115	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   180: putfield 70	kotlin/l/b/a/b/e/a$t:aaZB	Lkotlin/l/b/a/b/h/d;
    //   183: aload_0
    //   184: invokevirtual 118	kotlin/l/b/a/b/e/a$t:HZ	()V
    //   187: ldc 76
    //   189: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_1
    //   193: athrow
    //   194: aload_0
    //   195: aload_0
    //   196: getfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   199: iconst_2
    //   200: ior
    //   201: putfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   204: aload_0
    //   205: aload_1
    //   206: invokevirtual 100	kotlin/l/b/a/b/h/e:AK	()I
    //   209: putfield 120	kotlin/l/b/a/b/e/a$t:abbb	I
    //   212: goto -174 -> 38
    //   215: astore_1
    //   216: new 73	kotlin/l/b/a/b/h/l
    //   219: dup
    //   220: aload_1
    //   221: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   224: invokespecial 127	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   227: astore_1
    //   228: aload_1
    //   229: aload_0
    //   230: putfield 106	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   233: ldc 76
    //   235: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_1
    //   239: athrow
    //   240: aload_0
    //   241: getfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   244: iconst_4
    //   245: iand
    //   246: iconst_4
    //   247: if_icmpne +272 -> 519
    //   250: aload_0
    //   251: getfield 129	kotlin/l/b/a/b/e/a$t:abcp	Lkotlin/l/b/a/b/e/a$p;
    //   254: invokevirtual 135	kotlin/l/b/a/b/e/a$p:iLz	()Lkotlin/l/b/a/b/e/a$p$b;
    //   257: astore 5
    //   259: aload_0
    //   260: aload_1
    //   261: getstatic 136	kotlin/l/b/a/b/e/a$p:aaZC	Lkotlin/l/b/a/b/h/t;
    //   264: aload_2
    //   265: invokevirtual 139	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   268: checkcast 131	kotlin/l/b/a/b/e/a$p
    //   271: putfield 129	kotlin/l/b/a/b/e/a$t:abcp	Lkotlin/l/b/a/b/e/a$p;
    //   274: aload 5
    //   276: ifnull +22 -> 298
    //   279: aload 5
    //   281: aload_0
    //   282: getfield 129	kotlin/l/b/a/b/e/a$t:abcp	Lkotlin/l/b/a/b/e/a$p;
    //   285: invokevirtual 145	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   288: pop
    //   289: aload_0
    //   290: aload 5
    //   292: invokevirtual 149	kotlin/l/b/a/b/e/a$p$b:iLI	()Lkotlin/l/b/a/b/e/a$p;
    //   295: putfield 129	kotlin/l/b/a/b/e/a$t:abcp	Lkotlin/l/b/a/b/e/a$p;
    //   298: aload_0
    //   299: aload_0
    //   300: getfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   303: iconst_4
    //   304: ior
    //   305: putfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   308: goto -270 -> 38
    //   311: aload_0
    //   312: getfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   315: bipush 16
    //   317: iand
    //   318: bipush 16
    //   320: if_icmpne +193 -> 513
    //   323: aload_0
    //   324: getfield 151	kotlin/l/b/a/b/e/a$t:abcQ	Lkotlin/l/b/a/b/e/a$p;
    //   327: invokevirtual 135	kotlin/l/b/a/b/e/a$p:iLz	()Lkotlin/l/b/a/b/e/a$p$b;
    //   330: astore 5
    //   332: aload_0
    //   333: aload_1
    //   334: getstatic 136	kotlin/l/b/a/b/e/a$p:aaZC	Lkotlin/l/b/a/b/h/t;
    //   337: aload_2
    //   338: invokevirtual 139	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   341: checkcast 131	kotlin/l/b/a/b/e/a$p
    //   344: putfield 151	kotlin/l/b/a/b/e/a$t:abcQ	Lkotlin/l/b/a/b/e/a$p;
    //   347: aload 5
    //   349: ifnull +22 -> 371
    //   352: aload 5
    //   354: aload_0
    //   355: getfield 151	kotlin/l/b/a/b/e/a$t:abcQ	Lkotlin/l/b/a/b/e/a$p;
    //   358: invokevirtual 145	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   361: pop
    //   362: aload_0
    //   363: aload 5
    //   365: invokevirtual 149	kotlin/l/b/a/b/e/a$p$b:iLI	()Lkotlin/l/b/a/b/e/a$p;
    //   368: putfield 151	kotlin/l/b/a/b/e/a$t:abcQ	Lkotlin/l/b/a/b/e/a$p;
    //   371: aload_0
    //   372: aload_0
    //   373: getfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   376: bipush 16
    //   378: ior
    //   379: putfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   382: goto -344 -> 38
    //   385: aload_0
    //   386: aload_0
    //   387: getfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   390: bipush 8
    //   392: ior
    //   393: putfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   396: aload_0
    //   397: aload_1
    //   398: invokevirtual 100	kotlin/l/b/a/b/h/e:AK	()I
    //   401: putfield 153	kotlin/l/b/a/b/e/a$t:abcq	I
    //   404: goto -366 -> 38
    //   407: aload_0
    //   408: aload_0
    //   409: getfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   412: bipush 32
    //   414: ior
    //   415: putfield 97	kotlin/l/b/a/b/e/a$t:bQS	I
    //   418: aload_0
    //   419: aload_1
    //   420: invokevirtual 100	kotlin/l/b/a/b/h/e:AK	()I
    //   423: putfield 155	kotlin/l/b/a/b/e/a$t:abcR	I
    //   426: goto -388 -> 38
    //   429: aload 7
    //   431: invokevirtual 109	kotlin/l/b/a/b/h/f:flush	()V
    //   434: aload_0
    //   435: aload 6
    //   437: invokevirtual 115	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   440: putfield 70	kotlin/l/b/a/b/e/a$t:aaZB	Lkotlin/l/b/a/b/h/d;
    //   443: aload_0
    //   444: invokevirtual 118	kotlin/l/b/a/b/e/a$t:HZ	()V
    //   447: ldc 76
    //   449: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: return
    //   453: astore_1
    //   454: aload_0
    //   455: aload 6
    //   457: invokevirtual 115	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   460: putfield 70	kotlin/l/b/a/b/e/a$t:aaZB	Lkotlin/l/b/a/b/h/d;
    //   463: goto -20 -> 443
    //   466: astore_1
    //   467: aload_0
    //   468: aload 6
    //   470: invokevirtual 115	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   473: putfield 70	kotlin/l/b/a/b/e/a$t:aaZB	Lkotlin/l/b/a/b/h/d;
    //   476: ldc 76
    //   478: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   481: aload_1
    //   482: athrow
    //   483: astore_2
    //   484: aload_0
    //   485: aload 6
    //   487: invokevirtual 115	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   490: putfield 70	kotlin/l/b/a/b/e/a$t:aaZB	Lkotlin/l/b/a/b/h/d;
    //   493: goto -310 -> 183
    //   496: astore_1
    //   497: aload_0
    //   498: aload 6
    //   500: invokevirtual 115	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   503: putfield 70	kotlin/l/b/a/b/e/a$t:aaZB	Lkotlin/l/b/a/b/h/d;
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
    this.aaZB = paramb.aaZB;
  }
  
  public static a b(t paramt)
  {
    AppMethodBeat.i(58983);
    paramt = a.iMm().d(paramt);
    AppMethodBeat.o(58983);
    return paramt;
  }
  
  private void iIN()
  {
    AppMethodBeat.i(58979);
    this.aaZS = 0;
    this.abbb = 0;
    this.abcp = a.p.iLm();
    this.abcq = 0;
    this.abcQ = a.p.iLm();
    this.abcR = 0;
    AppMethodBeat.o(58979);
  }
  
  public static t iMh()
  {
    return abcP;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(58982);
    int i = this.bXW;
    if (i != -1)
    {
      AppMethodBeat.o(58982);
      return i;
    }
    int j = 0;
    if ((this.bQS & 0x1) == 1) {
      j = f.bM(1, this.aaZS) + 0;
    }
    i = j;
    if ((this.bQS & 0x2) == 2) {
      i = j + f.bM(2, this.abbb);
    }
    j = i;
    if ((this.bQS & 0x4) == 4) {
      j = i + f.c(3, this.abcp);
    }
    i = j;
    if ((this.bQS & 0x10) == 16) {
      i = j + f.c(4, this.abcQ);
    }
    j = i;
    if ((this.bQS & 0x8) == 8) {
      j = i + f.bM(5, this.abcq);
    }
    i = j;
    if ((this.bQS & 0x20) == 32) {
      i = j + f.bM(6, this.abcR);
    }
    i = i + Ii() + this.aaZB.size();
    this.bXW = i;
    AppMethodBeat.o(58982);
    return i;
  }
  
  public final boolean Cc()
  {
    return (this.bQS & 0x2) == 2;
  }
  
  public final boolean DQ()
  {
    return (this.bQS & 0x4) == 4;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58981);
    Ad();
    i.c.a locala = iNU();
    if ((this.bQS & 0x1) == 1) {
      paramf.bJ(1, this.aaZS);
    }
    if ((this.bQS & 0x2) == 2) {
      paramf.bJ(2, this.abbb);
    }
    if ((this.bQS & 0x4) == 4) {
      paramf.a(3, this.abcp);
    }
    if ((this.bQS & 0x10) == 16) {
      paramf.a(4, this.abcQ);
    }
    if ((this.bQS & 0x8) == 8) {
      paramf.bJ(5, this.abcq);
    }
    if ((this.bQS & 0x20) == 32) {
      paramf.bJ(6, this.abcR);
    }
    locala.b(200, paramf);
    paramf.e(this.aaZB);
    AppMethodBeat.o(58981);
  }
  
  public final boolean iJj()
  {
    return (this.bQS & 0x1) == 1;
  }
  
  public final boolean iLC()
  {
    return (this.bQS & 0x8) == 8;
  }
  
  public final boolean iMi()
  {
    return (this.bQS & 0x10) == 16;
  }
  
  public final boolean iMj()
  {
    return (this.bQS & 0x20) == 32;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58980);
    int i = this.bRd;
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
    if (!Cc())
    {
      this.bRd = 0;
      AppMethodBeat.o(58980);
      return false;
    }
    if ((DQ()) && (!this.abcp.isInitialized()))
    {
      this.bRd = 0;
      AppMethodBeat.o(58980);
      return false;
    }
    if ((iMi()) && (!this.abcQ.isInitialized()))
    {
      this.bRd = 0;
      AppMethodBeat.o(58980);
      return false;
    }
    if (!Ig())
    {
      this.bRd = 0;
      AppMethodBeat.o(58980);
      return false;
    }
    this.bRd = 1;
    AppMethodBeat.o(58980);
    return true;
  }
  
  public static final class a
    extends i.b<a.t, a>
    implements w
  {
    private int aaZS;
    private int abbb;
    private a.p abcQ;
    private int abcR;
    private a.p abcp;
    private int abcq;
    private int bQS;
    
    private a()
    {
      AppMethodBeat.i(58959);
      this.abcp = a.p.iLm();
      this.abcQ = a.p.iLm();
      AppMethodBeat.o(58959);
    }
    
    private a aET(int paramInt)
    {
      this.bQS |= 0x1;
      this.aaZS = paramInt;
      return this;
    }
    
    private a aEU(int paramInt)
    {
      this.bQS |= 0x2;
      this.abbb = paramInt;
      return this;
    }
    
    private a aEV(int paramInt)
    {
      this.bQS |= 0x8;
      this.abcq = paramInt;
      return this;
    }
    
    private a aEW(int paramInt)
    {
      this.bQS |= 0x20;
      this.abcR = paramInt;
      return this;
    }
    
    private a iMk()
    {
      AppMethodBeat.i(58960);
      a locala = new a().d(iMl());
      AppMethodBeat.o(58960);
      return locala;
    }
    
    private a p(a.p paramp)
    {
      AppMethodBeat.i(58965);
      if (((this.bQS & 0x4) == 4) && (this.abcp != a.p.iLm())) {}
      for (this.abcp = a.p.f(this.abcp).j(paramp).iLI();; this.abcp = paramp)
      {
        this.bQS |= 0x4;
        AppMethodBeat.o(58965);
        return this;
      }
    }
    
    private a q(a.p paramp)
    {
      AppMethodBeat.i(58966);
      if (((this.bQS & 0x10) == 16) && (this.abcQ != a.p.iLm())) {}
      for (this.abcQ = a.p.f(this.abcQ).j(paramp).iLI();; this.abcQ = paramp)
      {
        this.bQS |= 0x10;
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
      //   7: getstatic 102	kotlin/l/b/a/b/e/a$t:aaZC	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 107 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$t
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 74	kotlin/l/b/a/b/e/a$t$a:d	(Lkotlin/l/b/a/b/e/a$t;)Lkotlin/l/b/a/b/e/a$t$a;
      //   26: pop
      //   27: ldc 98
      //   29: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 111	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
      //   39: checkcast 9	kotlin/l/b/a/b/e/a$t
      //   42: astore_2
      //   43: ldc 98
      //   45: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 74	kotlin/l/b/a/b/e/a$t$a:d	(Lkotlin/l/b/a/b/e/a$t;)Lkotlin/l/b/a/b/e/a$t$a;
      //   60: pop
      //   61: ldc 98
      //   63: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public final a d(a.t paramt)
    {
      AppMethodBeat.i(58962);
      if (paramt == a.t.iMh())
      {
        AppMethodBeat.o(58962);
        return this;
      }
      if (paramt.iJj()) {
        aET(paramt.aaZS);
      }
      if (paramt.Cc()) {
        aEU(paramt.abbb);
      }
      if (paramt.DQ()) {
        p(paramt.abcp);
      }
      if (paramt.iLC()) {
        aEV(paramt.abcq);
      }
      if (paramt.iMi()) {
        q(paramt.abcQ);
      }
      if (paramt.iMj()) {
        aEW(paramt.abcR);
      }
      a(paramt);
      this.aaZB = this.aaZB.a(a.t.c(paramt));
      AppMethodBeat.o(58962);
      return this;
    }
    
    public final a.t iMl()
    {
      int j = 1;
      AppMethodBeat.i(58961);
      a.t localt = new a.t(this, (byte)0);
      int k = this.bQS;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.t.a(localt, this.aaZS);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.t.b(localt, this.abbb);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.t.a(localt, this.abcp);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.t.c(localt, this.abcq);
        j = i;
        if ((k & 0x10) == 16) {
          j = i | 0x10;
        }
        a.t.b(localt, this.abcQ);
        i = j;
        if ((k & 0x20) == 32) {
          i = j | 0x20;
        }
        a.t.d(localt, this.abcR);
        a.t.e(localt, i);
        AppMethodBeat.o(58961);
        return localt;
        j = 0;
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58963);
      if ((this.bQS & 0x2) == 2) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58963);
        return false;
      }
      if ((this.bQS & 0x4) == 4) {}
      for (i = 1; (i != 0) && (!this.abcp.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58963);
        return false;
      }
      if ((this.bQS & 0x10) == 16) {}
      for (i = 1; (i != 0) && (!this.abcQ.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58963);
        return false;
      }
      if (!Ig())
      {
        AppMethodBeat.o(58963);
        return false;
      }
      AppMethodBeat.o(58963);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.t
 * JD-Core Version:    0.7.0.1
 */