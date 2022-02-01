package com.tencent.mm.timelineedit.a.a;

import com.google.b.aj.a;
import com.google.b.aj.f;
import com.google.b.bb;
import com.google.b.bb.a;
import com.google.b.bb.b;
import com.google.b.bb.e;
import com.google.b.bt;
import com.google.b.c;
import com.google.b.ci;
import com.google.b.cs;
import com.google.b.da;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends bb
  implements j
{
  private static final i VMk;
  private static final ci<i> bRf;
  private q VMi;
  private q VMj;
  private byte bRd = -1;
  
  static
  {
    AppMethodBeat.i(260639);
    VMk = new i();
    bRf = new c() {};
    AppMethodBeat.o(260639);
  }
  
  private i() {}
  
  private i(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private i(com.google.b.h paramh, com.google.b.ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 33	com/tencent/mm/timelineedit/a/a/i:<init>	()V
    //   4: ldc 58
    //   6: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +18 -> 28
    //   13: new 60	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 61	java/lang/NullPointerException:<init>	()V
    //   20: astore_1
    //   21: ldc 58
    //   23: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_1
    //   27: athrow
    //   28: invokestatic 67	com/google/b/da:Jj	()Lcom/google/b/da$a;
    //   31: astore 6
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +234 -> 270
    //   39: aload_1
    //   40: invokevirtual 73	com/google/b/h:Av	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+257->304, 0:+263->310, 10:+51->98, 18:+143->190
    //   81: aload_1
    //   82: aload 6
    //   84: aload_2
    //   85: iload 4
    //   87: invokevirtual 76	com/tencent/mm/timelineedit/a/a/i:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   90: ifne +199 -> 289
    //   93: iconst_1
    //   94: istore_3
    //   95: goto +212 -> 307
    //   98: aload_0
    //   99: getfield 78	com/tencent/mm/timelineedit/a/a/i:VMi	Lcom/tencent/mm/timelineedit/a/a/q;
    //   102: ifnull +196 -> 298
    //   105: aload_0
    //   106: getfield 78	com/tencent/mm/timelineedit/a/a/i:VMi	Lcom/tencent/mm/timelineedit/a/a/q;
    //   109: invokevirtual 84	com/tencent/mm/timelineedit/a/a/q:hDL	()Lcom/tencent/mm/timelineedit/a/a/q$a;
    //   112: astore 5
    //   114: aload_0
    //   115: aload_1
    //   116: invokestatic 88	com/tencent/mm/timelineedit/a/a/q:hCD	()Lcom/google/b/ci;
    //   119: aload_2
    //   120: invokevirtual 91	com/google/b/h:a	(Lcom/google/b/ci;Lcom/google/b/ap;)Lcom/google/b/bw;
    //   123: checkcast 80	com/tencent/mm/timelineedit/a/a/q
    //   126: putfield 78	com/tencent/mm/timelineedit/a/a/i:VMi	Lcom/tencent/mm/timelineedit/a/a/q;
    //   129: aload 5
    //   131: ifnull +158 -> 289
    //   134: aload 5
    //   136: aload_0
    //   137: getfield 78	com/tencent/mm/timelineedit/a/a/i:VMi	Lcom/tencent/mm/timelineedit/a/a/q;
    //   140: invokevirtual 97	com/tencent/mm/timelineedit/a/a/q$a:l	(Lcom/tencent/mm/timelineedit/a/a/q;)Lcom/tencent/mm/timelineedit/a/a/q$a;
    //   143: pop
    //   144: aload_0
    //   145: aload 5
    //   147: invokevirtual 101	com/tencent/mm/timelineedit/a/a/q$a:hDP	()Lcom/tencent/mm/timelineedit/a/a/q;
    //   150: putfield 78	com/tencent/mm/timelineedit/a/a/i:VMi	Lcom/tencent/mm/timelineedit/a/a/q;
    //   153: goto -118 -> 35
    //   156: astore_1
    //   157: aload_1
    //   158: aload_0
    //   159: putfield 105	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   162: ldc 58
    //   164: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: aload_0
    //   171: aload 6
    //   173: invokevirtual 111	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   176: putfield 115	com/tencent/mm/timelineedit/a/a/i:bVW	Lcom/google/b/da;
    //   179: aload_0
    //   180: invokevirtual 118	com/tencent/mm/timelineedit/a/a/i:HZ	()V
    //   183: ldc 58
    //   185: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: athrow
    //   190: aload_0
    //   191: getfield 120	com/tencent/mm/timelineedit/a/a/i:VMj	Lcom/tencent/mm/timelineedit/a/a/q;
    //   194: ifnull +98 -> 292
    //   197: aload_0
    //   198: getfield 120	com/tencent/mm/timelineedit/a/a/i:VMj	Lcom/tencent/mm/timelineedit/a/a/q;
    //   201: invokevirtual 84	com/tencent/mm/timelineedit/a/a/q:hDL	()Lcom/tencent/mm/timelineedit/a/a/q$a;
    //   204: astore 5
    //   206: aload_0
    //   207: aload_1
    //   208: invokestatic 88	com/tencent/mm/timelineedit/a/a/q:hCD	()Lcom/google/b/ci;
    //   211: aload_2
    //   212: invokevirtual 91	com/google/b/h:a	(Lcom/google/b/ci;Lcom/google/b/ap;)Lcom/google/b/bw;
    //   215: checkcast 80	com/tencent/mm/timelineedit/a/a/q
    //   218: putfield 120	com/tencent/mm/timelineedit/a/a/i:VMj	Lcom/tencent/mm/timelineedit/a/a/q;
    //   221: aload 5
    //   223: ifnull +66 -> 289
    //   226: aload 5
    //   228: aload_0
    //   229: getfield 120	com/tencent/mm/timelineedit/a/a/i:VMj	Lcom/tencent/mm/timelineedit/a/a/q;
    //   232: invokevirtual 97	com/tencent/mm/timelineedit/a/a/q$a:l	(Lcom/tencent/mm/timelineedit/a/a/q;)Lcom/tencent/mm/timelineedit/a/a/q$a;
    //   235: pop
    //   236: aload_0
    //   237: aload 5
    //   239: invokevirtual 101	com/tencent/mm/timelineedit/a/a/q$a:hDP	()Lcom/tencent/mm/timelineedit/a/a/q;
    //   242: putfield 120	com/tencent/mm/timelineedit/a/a/i:VMj	Lcom/tencent/mm/timelineedit/a/a/q;
    //   245: goto -210 -> 35
    //   248: astore_1
    //   249: new 55	com/google/b/bf
    //   252: dup
    //   253: aload_1
    //   254: invokespecial 123	com/google/b/bf:<init>	(Ljava/io/IOException;)V
    //   257: astore_1
    //   258: aload_1
    //   259: aload_0
    //   260: putfield 105	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   263: ldc 58
    //   265: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aload_1
    //   269: athrow
    //   270: aload_0
    //   271: aload 6
    //   273: invokevirtual 111	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   276: putfield 115	com/tencent/mm/timelineedit/a/a/i:bVW	Lcom/google/b/da;
    //   279: aload_0
    //   280: invokevirtual 118	com/tencent/mm/timelineedit/a/a/i:HZ	()V
    //   283: ldc 58
    //   285: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: return
    //   289: goto +18 -> 307
    //   292: aconst_null
    //   293: astore 5
    //   295: goto -89 -> 206
    //   298: aconst_null
    //   299: astore 5
    //   301: goto -187 -> 114
    //   304: goto -224 -> 80
    //   307: goto -272 -> 35
    //   310: iconst_1
    //   311: istore_3
    //   312: goto -277 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	i
    //   0	315	1	paramh	com.google.b.h
    //   0	315	2	paramap	com.google.b.ap
    //   34	278	3	i	int
    //   43	43	4	j	int
    //   112	188	5	locala	q.a
    //   31	241	6	locala1	com.google.b.da.a
    // Exception table:
    //   from	to	target	type
    //   39	45	156	com/google/b/bf
    //   80	93	156	com/google/b/bf
    //   98	114	156	com/google/b/bf
    //   114	129	156	com/google/b/bf
    //   134	153	156	com/google/b/bf
    //   190	206	156	com/google/b/bf
    //   206	221	156	com/google/b/bf
    //   226	245	156	com/google/b/bf
    //   39	45	169	finally
    //   80	93	169	finally
    //   98	114	169	finally
    //   114	129	169	finally
    //   134	153	169	finally
    //   157	169	169	finally
    //   190	206	169	finally
    //   206	221	169	finally
    //   226	245	169	finally
    //   249	270	169	finally
    //   39	45	248	java/io/IOException
    //   80	93	248	java/io/IOException
    //   98	114	248	java/io/IOException
    //   114	129	248	java/io/IOException
    //   134	153	248	java/io/IOException
    //   190	206	248	java/io/IOException
    //   206	221	248	java/io/IOException
    //   226	245	248	java/io/IOException
  }
  
  public static a a(i parami)
  {
    AppMethodBeat.i(260625);
    parami = VMk.hDA().c(parami);
    AppMethodBeat.o(260625);
    return parami;
  }
  
  public static ci<i> hCD()
  {
    return bRf;
  }
  
  public static i hDB()
  {
    return VMk;
  }
  
  public static a hDz()
  {
    AppMethodBeat.i(260622);
    a locala = VMk.hDA();
    AppMethodBeat.o(260622);
    return locala;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(260617);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(260617);
      return i;
    }
    i = 0;
    if (this.VMi != null) {
      i = com.google.b.i.c(1, hDw()) + 0;
    }
    int j = i;
    if (this.VMj != null) {
      j = i + com.google.b.i.c(2, hDy());
    }
    i = j + this.bVW.Ad();
    this.bOZ = i;
    AppMethodBeat.o(260617);
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(260610);
    bb.e locale = ae.VNV.b(i.class, a.class);
    AppMethodBeat.o(260610);
    return locale;
  }
  
  public final ci<i> Co()
  {
    return bRf;
  }
  
  public final void a(com.google.b.i parami)
  {
    AppMethodBeat.i(260616);
    if (this.VMi != null) {
      parami.a(1, hDw());
    }
    if (this.VMj != null) {
      parami.a(2, hDy());
    }
    this.bVW.a(parami);
    AppMethodBeat.o(260616);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(260619);
    if (paramObject == this)
    {
      AppMethodBeat.o(260619);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(260619);
      return bool;
    }
    paramObject = (i)paramObject;
    if (hDv() != paramObject.hDv())
    {
      AppMethodBeat.o(260619);
      return false;
    }
    if ((hDv()) && (!hDw().equals(paramObject.hDw())))
    {
      AppMethodBeat.o(260619);
      return false;
    }
    if (hDx() != paramObject.hDx())
    {
      AppMethodBeat.o(260619);
      return false;
    }
    if ((hDx()) && (!hDy().equals(paramObject.hDy())))
    {
      AppMethodBeat.o(260619);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(260619);
      return false;
    }
    AppMethodBeat.o(260619);
    return true;
  }
  
  public final a hDA()
  {
    AppMethodBeat.i(260626);
    if (this == VMk)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(260626);
      return locala;
    }
    a locala = new a((byte)0).c(this);
    AppMethodBeat.o(260626);
    return locala;
  }
  
  public final boolean hDv()
  {
    return this.VMi != null;
  }
  
  public final q hDw()
  {
    AppMethodBeat.i(260614);
    if (this.VMi == null)
    {
      localq = q.hDM();
      AppMethodBeat.o(260614);
      return localq;
    }
    q localq = this.VMi;
    AppMethodBeat.o(260614);
    return localq;
  }
  
  public final boolean hDx()
  {
    return this.VMj != null;
  }
  
  public final q hDy()
  {
    AppMethodBeat.i(260615);
    if (this.VMj == null)
    {
      localq = q.hDM();
      AppMethodBeat.o(260615);
      return localq;
    }
    q localq = this.VMj;
    AppMethodBeat.o(260615);
    return localq;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(260621);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(260621);
      return i;
    }
    int j = ae.VNU.hashCode() + 779;
    int i = j;
    if (hDv()) {
      i = (j * 37 + 1) * 53 + hDw().hashCode();
    }
    j = i;
    if (hDx()) {
      j = (i * 37 + 2) * 53 + hDy().hashCode();
    }
    i = j * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(260621);
    return i;
  }
  
  public final boolean isInitialized()
  {
    int i = this.bRd;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.bRd = 1;
    return true;
  }
  
  public static final class a
    extends bb.a<a>
    implements j
  {
    private q VMi;
    private q VMj;
    private cs<q, q.a, r> VMl;
    private cs<q, q.a, r> VMm;
    
    private a()
    {
      AppMethodBeat.i(260435);
      AppMethodBeat.o(260435);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(260438);
      AppMethodBeat.o(260438);
    }
    
    private a Q(bt parambt)
    {
      AppMethodBeat.i(260445);
      if ((parambt instanceof i))
      {
        parambt = c((i)parambt);
        AppMethodBeat.o(260445);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(260445);
      return this;
    }
    
    /* Error */
    private a R(com.google.b.h paramh, com.google.b.ap paramap)
    {
      // Byte code:
      //   0: ldc 59
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 63	com/tencent/mm/timelineedit/a/a/i:hCE	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 69 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/i
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 51	com/tencent/mm/timelineedit/a/a/i$a:c	(Lcom/tencent/mm/timelineedit/a/a/i;)Lcom/tencent/mm/timelineedit/a/a/i$a;
      //   30: pop
      //   31: ldc 59
      //   33: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 73	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/i
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 77	com/google/b/bf:Im	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 59
      //   54: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 51	com/tencent/mm/timelineedit/a/a/i$a:c	(Lcom/tencent/mm/timelineedit/a/a/i;)Lcom/tencent/mm/timelineedit/a/a/i$a;
      //   69: pop
      //   70: ldc 59
      //   72: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   75: aload_1
      //   76: athrow
      //   77: astore_1
      //   78: aload_3
      //   79: astore_2
      //   80: goto -20 -> 60
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	a
      //   0	83	1	paramh	com.google.b.h
      //   0	83	2	paramap	com.google.b.ap
      //   6	73	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	com/google/b/bf
      //   47	59	59	finally
      //   7	21	77	finally
      //   39	47	77	finally
    }
    
    private a aG(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260443);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(260443);
      return paramf;
    }
    
    private a aH(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260444);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(260444);
      return paramf;
    }
    
    private a aI(da paramda)
    {
      AppMethodBeat.i(260452);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(260452);
      return paramda;
    }
    
    private a aJ(da paramda)
    {
      AppMethodBeat.i(260453);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(260453);
      return paramda;
    }
    
    private a g(q paramq)
    {
      AppMethodBeat.i(260449);
      if (this.VMl == null) {
        if (this.VMi != null)
        {
          this.VMi = q.j(this.VMi).l(paramq).hDP();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(260449);
        return this;
        this.VMi = paramq;
        break;
        this.VMl.c(paramq);
      }
    }
    
    private a i(q paramq)
    {
      AppMethodBeat.i(260451);
      if (this.VMm == null) {
        if (this.VMj != null)
        {
          this.VMj = q.j(this.VMj).l(paramq).hDP();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(260451);
        return this;
        this.VMj = paramq;
        break;
        this.VMm.c(paramq);
      }
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(260431);
      bb.e locale = ae.VNV.b(i.class, a.class);
      AppMethodBeat.o(260431);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VNU;
    }
    
    public final a c(i parami)
    {
      AppMethodBeat.i(260446);
      if (parami == i.hDB())
      {
        AppMethodBeat.o(260446);
        return this;
      }
      if (parami.hDv()) {
        g(parami.hDw());
      }
      if (parami.hDx()) {
        i(parami.hDy());
      }
      aJ(i.b(parami));
      onChanged();
      AppMethodBeat.o(260446);
      return this;
    }
    
    public final a f(q paramq)
    {
      AppMethodBeat.i(260448);
      if (this.VMl == null)
      {
        if (paramq == null)
        {
          paramq = new NullPointerException();
          AppMethodBeat.o(260448);
          throw paramq;
        }
        this.VMi = paramq;
        onChanged();
      }
      for (;;)
      {
        AppMethodBeat.o(260448);
        return this;
        this.VMl.b(paramq);
      }
    }
    
    public final a h(q paramq)
    {
      AppMethodBeat.i(260450);
      if (this.VMm == null)
      {
        if (paramq == null)
        {
          paramq = new NullPointerException();
          AppMethodBeat.o(260450);
          throw paramq;
        }
        this.VMj = paramq;
        onChanged();
      }
      for (;;)
      {
        AppMethodBeat.o(260450);
        return this;
        this.VMm.b(paramq);
      }
    }
    
    public final i hDC()
    {
      AppMethodBeat.i(260441);
      Object localObject = hDD();
      if (!((i)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(260441);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(260441);
      return localObject;
    }
    
    public final i hDD()
    {
      AppMethodBeat.i(260442);
      i locali = new i(this, (byte)0);
      if (this.VMl == null)
      {
        i.a(locali, this.VMi);
        if (this.VMm != null) {
          break label78;
        }
        i.b(locali, this.VMj);
      }
      for (;;)
      {
        Ib();
        AppMethodBeat.o(260442);
        return locali;
        i.a(locali, (q)this.VMl.IV());
        break;
        label78:
        i.b(locali, (q)this.VMm.IV());
      }
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.i
 * JD-Core Version:    0.7.0.1
 */