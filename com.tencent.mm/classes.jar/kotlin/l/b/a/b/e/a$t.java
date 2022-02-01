package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.h;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.i.b;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.c.a;
import kotlin.l.b.a.b.h.s;

public final class a$t
  extends i.c<t>
  implements w
{
  public static s<t> TwL;
  private static final t TzY;
  public int TAa;
  private final d TwK;
  public int Txb;
  public int Tyk;
  public a.p TzZ;
  public a.p Tzy;
  public int Tzz;
  private int bOT;
  private byte bPe = -1;
  private int bVY = -1;
  
  static
  {
    AppMethodBeat.i(58986);
    TwL = new b() {};
    t localt = new t();
    TzY = localt;
    localt.hEu();
    AppMethodBeat.o(58986);
  }
  
  private a$t()
  {
    this.TwK = d.TDp;
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
    //   11: putfield 61	kotlin/l/b/a/b/e/a$t:bPe	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 63	kotlin/l/b/a/b/e/a$t:bVY	I
    //   19: aload_0
    //   20: invokespecial 54	kotlin/l/b/a/b/e/a$t:hEu	()V
    //   23: invokestatic 80	kotlin/l/b/a/b/h/d:hJo	()Lkotlin/l/b/a/b/h/d$b;
    //   26: astore 6
    //   28: aload 6
    //   30: iconst_1
    //   31: invokestatic 86	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   34: astore 7
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +393 -> 432
    //   42: aload_1
    //   43: invokevirtual 92	kotlin/l/b/a/b/h/e:yT	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+481->531, 0:+484->534, 8:+84->134, 16:+147->197, 26:+193->243, 34:+264->314, 40:+338->388, 48:+360->410
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
    //   136: getfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   139: iconst_1
    //   140: ior
    //   141: putfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 100	kotlin/l/b/a/b/h/e:zi	()I
    //   149: putfield 102	kotlin/l/b/a/b/e/a$t:Txb	I
    //   152: goto -114 -> 38
    //   155: astore_1
    //   156: aload_1
    //   157: aload_0
    //   158: putfield 106	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   161: ldc 76
    //   163: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_1
    //   167: athrow
    //   168: astore_1
    //   169: aload 7
    //   171: invokevirtual 109	kotlin/l/b/a/b/h/f:flush	()V
    //   174: aload_0
    //   175: aload 6
    //   177: invokevirtual 115	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   180: putfield 70	kotlin/l/b/a/b/e/a$t:TwK	Lkotlin/l/b/a/b/h/d;
    //   183: aload_0
    //   184: getfield 119	kotlin/l/b/a/b/h/i$c:TDA	Lkotlin/l/b/a/b/h/h;
    //   187: invokevirtual 124	kotlin/l/b/a/b/h/h:yK	()V
    //   190: ldc 76
    //   192: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aload_1
    //   196: athrow
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   202: iconst_2
    //   203: ior
    //   204: putfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   207: aload_0
    //   208: aload_1
    //   209: invokevirtual 100	kotlin/l/b/a/b/h/e:zi	()I
    //   212: putfield 126	kotlin/l/b/a/b/e/a$t:Tyk	I
    //   215: goto -177 -> 38
    //   218: astore_1
    //   219: new 73	kotlin/l/b/a/b/h/k
    //   222: dup
    //   223: aload_1
    //   224: invokevirtual 130	java/io/IOException:getMessage	()Ljava/lang/String;
    //   227: invokespecial 133	kotlin/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   230: astore_1
    //   231: aload_1
    //   232: aload_0
    //   233: putfield 106	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   236: ldc 76
    //   238: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aload_1
    //   242: athrow
    //   243: aload_0
    //   244: getfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   247: iconst_4
    //   248: iand
    //   249: iconst_4
    //   250: if_icmpne +275 -> 525
    //   253: aload_0
    //   254: getfield 135	kotlin/l/b/a/b/e/a$t:Tzy	Lkotlin/l/b/a/b/e/a$p;
    //   257: invokevirtual 141	kotlin/l/b/a/b/e/a$p:hHf	()Lkotlin/l/b/a/b/e/a$p$b;
    //   260: astore 5
    //   262: aload_0
    //   263: aload_1
    //   264: getstatic 142	kotlin/l/b/a/b/e/a$p:TwL	Lkotlin/l/b/a/b/h/s;
    //   267: aload_2
    //   268: invokevirtual 145	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   271: checkcast 137	kotlin/l/b/a/b/e/a$p
    //   274: putfield 135	kotlin/l/b/a/b/e/a$t:Tzy	Lkotlin/l/b/a/b/e/a$p;
    //   277: aload 5
    //   279: ifnull +22 -> 301
    //   282: aload 5
    //   284: aload_0
    //   285: getfield 135	kotlin/l/b/a/b/e/a$t:Tzy	Lkotlin/l/b/a/b/e/a$p;
    //   288: invokevirtual 151	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   291: pop
    //   292: aload_0
    //   293: aload 5
    //   295: invokevirtual 155	kotlin/l/b/a/b/e/a$p$b:hHo	()Lkotlin/l/b/a/b/e/a$p;
    //   298: putfield 135	kotlin/l/b/a/b/e/a$t:Tzy	Lkotlin/l/b/a/b/e/a$p;
    //   301: aload_0
    //   302: aload_0
    //   303: getfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   306: iconst_4
    //   307: ior
    //   308: putfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   311: goto -273 -> 38
    //   314: aload_0
    //   315: getfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   318: bipush 16
    //   320: iand
    //   321: bipush 16
    //   323: if_icmpne +196 -> 519
    //   326: aload_0
    //   327: getfield 157	kotlin/l/b/a/b/e/a$t:TzZ	Lkotlin/l/b/a/b/e/a$p;
    //   330: invokevirtual 141	kotlin/l/b/a/b/e/a$p:hHf	()Lkotlin/l/b/a/b/e/a$p$b;
    //   333: astore 5
    //   335: aload_0
    //   336: aload_1
    //   337: getstatic 142	kotlin/l/b/a/b/e/a$p:TwL	Lkotlin/l/b/a/b/h/s;
    //   340: aload_2
    //   341: invokevirtual 145	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   344: checkcast 137	kotlin/l/b/a/b/e/a$p
    //   347: putfield 157	kotlin/l/b/a/b/e/a$t:TzZ	Lkotlin/l/b/a/b/e/a$p;
    //   350: aload 5
    //   352: ifnull +22 -> 374
    //   355: aload 5
    //   357: aload_0
    //   358: getfield 157	kotlin/l/b/a/b/e/a$t:TzZ	Lkotlin/l/b/a/b/e/a$p;
    //   361: invokevirtual 151	kotlin/l/b/a/b/e/a$p$b:j	(Lkotlin/l/b/a/b/e/a$p;)Lkotlin/l/b/a/b/e/a$p$b;
    //   364: pop
    //   365: aload_0
    //   366: aload 5
    //   368: invokevirtual 155	kotlin/l/b/a/b/e/a$p$b:hHo	()Lkotlin/l/b/a/b/e/a$p;
    //   371: putfield 157	kotlin/l/b/a/b/e/a$t:TzZ	Lkotlin/l/b/a/b/e/a$p;
    //   374: aload_0
    //   375: aload_0
    //   376: getfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   379: bipush 16
    //   381: ior
    //   382: putfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   385: goto -347 -> 38
    //   388: aload_0
    //   389: aload_0
    //   390: getfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   393: bipush 8
    //   395: ior
    //   396: putfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   399: aload_0
    //   400: aload_1
    //   401: invokevirtual 100	kotlin/l/b/a/b/h/e:zi	()I
    //   404: putfield 159	kotlin/l/b/a/b/e/a$t:Tzz	I
    //   407: goto -369 -> 38
    //   410: aload_0
    //   411: aload_0
    //   412: getfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   415: bipush 32
    //   417: ior
    //   418: putfield 97	kotlin/l/b/a/b/e/a$t:bOT	I
    //   421: aload_0
    //   422: aload_1
    //   423: invokevirtual 100	kotlin/l/b/a/b/h/e:zi	()I
    //   426: putfield 161	kotlin/l/b/a/b/e/a$t:TAa	I
    //   429: goto -391 -> 38
    //   432: aload 7
    //   434: invokevirtual 109	kotlin/l/b/a/b/h/f:flush	()V
    //   437: aload_0
    //   438: aload 6
    //   440: invokevirtual 115	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   443: putfield 70	kotlin/l/b/a/b/e/a$t:TwK	Lkotlin/l/b/a/b/h/d;
    //   446: aload_0
    //   447: getfield 119	kotlin/l/b/a/b/h/i$c:TDA	Lkotlin/l/b/a/b/h/h;
    //   450: invokevirtual 124	kotlin/l/b/a/b/h/h:yK	()V
    //   453: ldc 76
    //   455: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   458: return
    //   459: astore_1
    //   460: aload_0
    //   461: aload 6
    //   463: invokevirtual 115	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   466: putfield 70	kotlin/l/b/a/b/e/a$t:TwK	Lkotlin/l/b/a/b/h/d;
    //   469: goto -23 -> 446
    //   472: astore_1
    //   473: aload_0
    //   474: aload 6
    //   476: invokevirtual 115	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   479: putfield 70	kotlin/l/b/a/b/e/a$t:TwK	Lkotlin/l/b/a/b/h/d;
    //   482: ldc 76
    //   484: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   487: aload_1
    //   488: athrow
    //   489: astore_2
    //   490: aload_0
    //   491: aload 6
    //   493: invokevirtual 115	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   496: putfield 70	kotlin/l/b/a/b/e/a$t:TwK	Lkotlin/l/b/a/b/h/d;
    //   499: goto -316 -> 183
    //   502: astore_1
    //   503: aload_0
    //   504: aload 6
    //   506: invokevirtual 115	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   509: putfield 70	kotlin/l/b/a/b/e/a$t:TwK	Lkotlin/l/b/a/b/h/d;
    //   512: ldc 76
    //   514: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   517: aload_1
    //   518: athrow
    //   519: aconst_null
    //   520: astore 5
    //   522: goto -187 -> 335
    //   525: aconst_null
    //   526: astore 5
    //   528: goto -266 -> 262
    //   531: goto -415 -> 116
    //   534: iconst_1
    //   535: istore_3
    //   536: goto -498 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	t
    //   0	539	1	parame	kotlin.l.b.a.b.h.e
    //   0	539	2	paramg	kotlin.l.b.a.b.h.g
    //   37	499	3	i	int
    //   46	76	4	j	int
    //   260	267	5	localb	a.p.b
    //   26	479	6	localb1	kotlin.l.b.a.b.h.d.b
    //   34	399	7	localf	f
    // Exception table:
    //   from	to	target	type
    //   42	48	155	kotlin/l/b/a/b/h/k
    //   116	129	155	kotlin/l/b/a/b/h/k
    //   134	152	155	kotlin/l/b/a/b/h/k
    //   197	215	155	kotlin/l/b/a/b/h/k
    //   243	262	155	kotlin/l/b/a/b/h/k
    //   262	277	155	kotlin/l/b/a/b/h/k
    //   282	301	155	kotlin/l/b/a/b/h/k
    //   301	311	155	kotlin/l/b/a/b/h/k
    //   314	335	155	kotlin/l/b/a/b/h/k
    //   335	350	155	kotlin/l/b/a/b/h/k
    //   355	374	155	kotlin/l/b/a/b/h/k
    //   374	385	155	kotlin/l/b/a/b/h/k
    //   388	407	155	kotlin/l/b/a/b/h/k
    //   410	429	155	kotlin/l/b/a/b/h/k
    //   42	48	168	finally
    //   116	129	168	finally
    //   134	152	168	finally
    //   156	168	168	finally
    //   197	215	168	finally
    //   219	243	168	finally
    //   243	262	168	finally
    //   262	277	168	finally
    //   282	301	168	finally
    //   301	311	168	finally
    //   314	335	168	finally
    //   335	350	168	finally
    //   355	374	168	finally
    //   374	385	168	finally
    //   388	407	168	finally
    //   410	429	168	finally
    //   42	48	218	java/io/IOException
    //   116	129	218	java/io/IOException
    //   134	152	218	java/io/IOException
    //   197	215	218	java/io/IOException
    //   243	262	218	java/io/IOException
    //   262	277	218	java/io/IOException
    //   282	301	218	java/io/IOException
    //   301	311	218	java/io/IOException
    //   314	335	218	java/io/IOException
    //   335	350	218	java/io/IOException
    //   355	374	218	java/io/IOException
    //   374	385	218	java/io/IOException
    //   388	407	218	java/io/IOException
    //   410	429	218	java/io/IOException
    //   432	437	459	java/io/IOException
    //   432	437	472	finally
    //   169	174	489	java/io/IOException
    //   169	174	502	finally
  }
  
  private a$t(i.b<t, ?> paramb)
  {
    super(paramb);
    this.TwK = paramb.TwK;
  }
  
  public static a b(t paramt)
  {
    AppMethodBeat.i(58983);
    paramt = a.hHS().d(paramt);
    AppMethodBeat.o(58983);
    return paramt;
  }
  
  private void hEu()
  {
    AppMethodBeat.i(58979);
    this.Txb = 0;
    this.Tyk = 0;
    this.Tzy = a.p.hGS();
    this.Tzz = 0;
    this.TzZ = a.p.hGS();
    this.TAa = 0;
    AppMethodBeat.o(58979);
  }
  
  public static t hHN()
  {
    return TzY;
  }
  
  public final boolean Az()
  {
    return (this.bOT & 0x2) == 2;
  }
  
  public final boolean Cm()
  {
    return (this.bOT & 0x4) == 4;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58981);
    yC();
    i.c.a locala = hJC();
    if ((this.bOT & 0x1) == 1) {
      paramf.bs(1, this.Txb);
    }
    if ((this.bOT & 0x2) == 2) {
      paramf.bs(2, this.Tyk);
    }
    if ((this.bOT & 0x4) == 4) {
      paramf.a(3, this.Tzy);
    }
    if ((this.bOT & 0x10) == 16) {
      paramf.a(4, this.TzZ);
    }
    if ((this.bOT & 0x8) == 8) {
      paramf.bs(5, this.Tzz);
    }
    if ((this.bOT & 0x20) == 32) {
      paramf.bs(6, this.TAa);
    }
    locala.b(200, paramf);
    paramf.e(this.TwK);
    AppMethodBeat.o(58981);
  }
  
  public final boolean hEP()
  {
    return (this.bOT & 0x1) == 1;
  }
  
  public final s<t> hEs()
  {
    return TwL;
  }
  
  public final boolean hHO()
  {
    return (this.bOT & 0x10) == 16;
  }
  
  public final boolean hHP()
  {
    return (this.bOT & 0x20) == 32;
  }
  
  public final boolean hHi()
  {
    return (this.bOT & 0x8) == 8;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58980);
    int i = this.bPe;
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
    if (!Az())
    {
      this.bPe = 0;
      AppMethodBeat.o(58980);
      return false;
    }
    if ((Cm()) && (!this.Tzy.isInitialized()))
    {
      this.bPe = 0;
      AppMethodBeat.o(58980);
      return false;
    }
    if ((hHO()) && (!this.TzZ.isInitialized()))
    {
      this.bPe = 0;
      AppMethodBeat.o(58980);
      return false;
    }
    if (!this.TDA.isInitialized())
    {
      this.bPe = 0;
      AppMethodBeat.o(58980);
      return false;
    }
    this.bPe = 1;
    AppMethodBeat.o(58980);
    return true;
  }
  
  public final int yC()
  {
    AppMethodBeat.i(58982);
    int i = this.bVY;
    if (i != -1)
    {
      AppMethodBeat.o(58982);
      return i;
    }
    int j = 0;
    if ((this.bOT & 0x1) == 1) {
      j = f.bu(1, this.Txb) + 0;
    }
    i = j;
    if ((this.bOT & 0x2) == 2) {
      i = j + f.bu(2, this.Tyk);
    }
    j = i;
    if ((this.bOT & 0x4) == 4) {
      j = i + f.c(3, this.Tzy);
    }
    i = j;
    if ((this.bOT & 0x10) == 16) {
      i = j + f.c(4, this.TzZ);
    }
    j = i;
    if ((this.bOT & 0x8) == 8) {
      j = i + f.bu(5, this.Tzz);
    }
    i = j;
    if ((this.bOT & 0x20) == 32) {
      i = j + f.bu(6, this.TAa);
    }
    i = i + this.TDA.yC() + this.TwK.size();
    this.bVY = i;
    AppMethodBeat.o(58982);
    return i;
  }
  
  public static final class a
    extends i.b<a.t, a>
    implements w
  {
    private int TAa;
    private int Txb;
    private int Tyk;
    private a.p TzZ;
    private a.p Tzy;
    private int Tzz;
    private int bOT;
    
    private a()
    {
      AppMethodBeat.i(58959);
      this.Tzy = a.p.hGS();
      this.TzZ = a.p.hGS();
      AppMethodBeat.o(58959);
    }
    
    private a auZ(int paramInt)
    {
      this.bOT |= 0x1;
      this.Txb = paramInt;
      return this;
    }
    
    private a ava(int paramInt)
    {
      this.bOT |= 0x2;
      this.Tyk = paramInt;
      return this;
    }
    
    private a avb(int paramInt)
    {
      this.bOT |= 0x8;
      this.Tzz = paramInt;
      return this;
    }
    
    private a avc(int paramInt)
    {
      this.bOT |= 0x20;
      this.TAa = paramInt;
      return this;
    }
    
    private a hHQ()
    {
      AppMethodBeat.i(58960);
      a locala = new a().d(hHR());
      AppMethodBeat.o(58960);
      return locala;
    }
    
    private a p(a.p paramp)
    {
      AppMethodBeat.i(58965);
      if (((this.bOT & 0x4) == 4) && (this.Tzy != a.p.hGS())) {}
      for (this.Tzy = a.p.f(this.Tzy).j(paramp).hHo();; this.Tzy = paramp)
      {
        this.bOT |= 0x4;
        AppMethodBeat.o(58965);
        return this;
      }
    }
    
    private a q(a.p paramp)
    {
      AppMethodBeat.i(58966);
      if (((this.bOT & 0x10) == 16) && (this.TzZ != a.p.hGS())) {}
      for (this.TzZ = a.p.f(this.TzZ).j(paramp).hHo();; this.TzZ = paramp)
      {
        this.bOT |= 0x10;
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
      //   7: getstatic 102	kotlin/l/b/a/b/e/a$t:TwL	Lkotlin/l/b/a/b/h/s;
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
      //   36: getfield 111	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
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
      //   7	21	34	kotlin/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a d(a.t paramt)
    {
      AppMethodBeat.i(58962);
      if (paramt == a.t.hHN())
      {
        AppMethodBeat.o(58962);
        return this;
      }
      if (paramt.hEP()) {
        auZ(paramt.Txb);
      }
      if (paramt.Az()) {
        ava(paramt.Tyk);
      }
      if (paramt.Cm()) {
        p(paramt.Tzy);
      }
      if (paramt.hHi()) {
        avb(paramt.Tzz);
      }
      if (paramt.hHO()) {
        q(paramt.TzZ);
      }
      if (paramt.hHP()) {
        avc(paramt.TAa);
      }
      a(paramt);
      this.TwK = this.TwK.a(a.t.c(paramt));
      AppMethodBeat.o(58962);
      return this;
    }
    
    public final a.t hHR()
    {
      int j = 1;
      AppMethodBeat.i(58961);
      a.t localt = new a.t(this, (byte)0);
      int k = this.bOT;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.t.a(localt, this.Txb);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.t.b(localt, this.Tyk);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.t.a(localt, this.Tzy);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.t.c(localt, this.Tzz);
        j = i;
        if ((k & 0x10) == 16) {
          j = i | 0x10;
        }
        a.t.b(localt, this.TzZ);
        i = j;
        if ((k & 0x20) == 32) {
          i = j | 0x20;
        }
        a.t.d(localt, this.TAa);
        a.t.e(localt, i);
        AppMethodBeat.o(58961);
        return localt;
        j = 0;
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58963);
      if ((this.bOT & 0x2) == 2) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58963);
        return false;
      }
      if ((this.bOT & 0x4) == 4) {}
      for (i = 1; (i != 0) && (!this.Tzy.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58963);
        return false;
      }
      if ((this.bOT & 0x10) == 16) {}
      for (i = 1; (i != 0) && (!this.TzZ.isInitialized()); i = 0)
      {
        AppMethodBeat.o(58963);
        return false;
      }
      if (!this.TDA.isInitialized())
      {
        AppMethodBeat.o(58963);
        return false;
      }
      AppMethodBeat.o(58963);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.t
 * JD-Core Version:    0.7.0.1
 */