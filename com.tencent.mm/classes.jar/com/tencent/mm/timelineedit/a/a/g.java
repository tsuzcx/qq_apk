package com.tencent.mm.timelineedit.a.a;

import com.google.b.aj.a;
import com.google.b.aj.f;
import com.google.b.bb;
import com.google.b.bb.a;
import com.google.b.bb.b;
import com.google.b.bb.e;
import com.google.b.be;
import com.google.b.bt;
import com.google.b.c;
import com.google.b.ci;
import com.google.b.da;
import com.google.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends bb
  implements h
{
  private static final g VMh;
  private static final ci<g> bRf;
  long VMg;
  int bRI;
  private byte bRd = -1;
  private volatile Object coo;
  
  static
  {
    AppMethodBeat.i(260412);
    VMh = new g();
    bRf = new c() {};
    AppMethodBeat.o(260412);
  }
  
  private g()
  {
    this.coo = "";
  }
  
  private g(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private g(com.google.b.h paramh, com.google.b.ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 36	com/tencent/mm/timelineedit/a/a/g:<init>	()V
    //   4: ldc 65
    //   6: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +18 -> 28
    //   13: new 67	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   20: astore_1
    //   21: ldc 65
    //   23: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_1
    //   27: athrow
    //   28: invokestatic 74	com/google/b/da:Jj	()Lcom/google/b/da$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +159 -> 195
    //   39: aload_1
    //   40: invokevirtual 80	com/google/b/h:Av	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+167->214, 0:+170->217, 10:+59->106, 16:+104->151, 24:+137->184
    //   89: aload_1
    //   90: aload 5
    //   92: aload_2
    //   93: iload 4
    //   95: invokevirtual 83	com/tencent/mm/timelineedit/a/a/g:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   98: ifne -63 -> 35
    //   101: iconst_1
    //   102: istore_3
    //   103: goto -68 -> 35
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 87	com/google/b/h:AC	()Ljava/lang/String;
    //   111: putfield 52	com/tencent/mm/timelineedit/a/a/g:coo	Ljava/lang/Object;
    //   114: goto -79 -> 35
    //   117: astore_1
    //   118: aload_1
    //   119: aload_0
    //   120: putfield 91	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   123: ldc 65
    //   125: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: aload_0
    //   132: aload 5
    //   134: invokevirtual 97	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   137: putfield 101	com/tencent/mm/timelineedit/a/a/g:bVW	Lcom/google/b/da;
    //   140: aload_0
    //   141: invokevirtual 104	com/tencent/mm/timelineedit/a/a/g:HZ	()V
    //   144: ldc 65
    //   146: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_1
    //   150: athrow
    //   151: aload_0
    //   152: aload_1
    //   153: invokevirtual 107	com/google/b/h:Ay	()I
    //   156: putfield 109	com/tencent/mm/timelineedit/a/a/g:bRI	I
    //   159: goto -124 -> 35
    //   162: astore_1
    //   163: new 62	com/google/b/bf
    //   166: dup
    //   167: aload_1
    //   168: invokespecial 112	com/google/b/bf:<init>	(Ljava/io/IOException;)V
    //   171: astore_1
    //   172: aload_1
    //   173: aload_0
    //   174: putfield 91	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   177: ldc 65
    //   179: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_1
    //   183: athrow
    //   184: aload_0
    //   185: aload_1
    //   186: invokevirtual 116	com/google/b/h:Ax	()J
    //   189: putfield 118	com/tencent/mm/timelineedit/a/a/g:VMg	J
    //   192: goto -157 -> 35
    //   195: aload_0
    //   196: aload 5
    //   198: invokevirtual 97	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   201: putfield 101	com/tencent/mm/timelineedit/a/a/g:bVW	Lcom/google/b/da;
    //   204: aload_0
    //   205: invokevirtual 104	com/tencent/mm/timelineedit/a/a/g:HZ	()V
    //   208: ldc 65
    //   210: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: return
    //   214: goto -126 -> 88
    //   217: iconst_1
    //   218: istore_3
    //   219: goto -184 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	g
    //   0	222	1	paramh	com.google.b.h
    //   0	222	2	paramap	com.google.b.ap
    //   34	185	3	i	int
    //   43	51	4	j	int
    //   31	166	5	locala	com.google.b.da.a
    // Exception table:
    //   from	to	target	type
    //   39	45	117	com/google/b/bf
    //   88	101	117	com/google/b/bf
    //   106	114	117	com/google/b/bf
    //   151	159	117	com/google/b/bf
    //   184	192	117	com/google/b/bf
    //   39	45	130	finally
    //   88	101	130	finally
    //   106	114	130	finally
    //   118	130	130	finally
    //   151	159	130	finally
    //   163	184	130	finally
    //   184	192	130	finally
    //   39	45	162	java/io/IOException
    //   88	101	162	java/io/IOException
    //   106	114	162	java/io/IOException
    //   151	159	162	java/io/IOException
    //   184	192	162	java/io/IOException
  }
  
  public static ci<g> hCD()
  {
    return bRf;
  }
  
  private com.google.b.g hDp()
  {
    AppMethodBeat.i(260396);
    Object localObject = this.coo;
    if ((localObject instanceof String))
    {
      localObject = com.google.b.g.ct((String)localObject);
      this.coo = localObject;
      AppMethodBeat.o(260396);
      return localObject;
    }
    localObject = (com.google.b.g)localObject;
    AppMethodBeat.o(260396);
    return localObject;
  }
  
  private a hDq()
  {
    AppMethodBeat.i(260402);
    if (this == VMh)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(260402);
      return locala;
    }
    a locala = new a((byte)0).c(this);
    AppMethodBeat.o(260402);
    return locala;
  }
  
  public static g hDr()
  {
    return VMh;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(260398);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(260398);
      return i;
    }
    int j = 0;
    if (!hDp().isEmpty()) {
      j = bb.f(1, this.coo) + 0;
    }
    i = j;
    if (this.bRI != 0) {
      i = j + i.bM(2, this.bRI);
    }
    j = i;
    if (this.VMg != 0L) {
      j = i + i.p(3, this.VMg);
    }
    i = j + this.bVW.Ad();
    this.bOZ = i;
    AppMethodBeat.o(260398);
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(260393);
    bb.e locale = ae.VOr.b(g.class, a.class);
    AppMethodBeat.o(260393);
    return locale;
  }
  
  public final ci<g> Co()
  {
    return bRf;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(260397);
    if (!hDp().isEmpty()) {
      bb.a(parami, 1, this.coo);
    }
    if (this.bRI != 0) {
      parami.bJ(2, this.bRI);
    }
    if (this.VMg != 0L) {
      parami.n(3, this.VMg);
    }
    this.bVW.a(parami);
    AppMethodBeat.o(260397);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(260399);
    if (paramObject == this)
    {
      AppMethodBeat.o(260399);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(260399);
      return bool;
    }
    paramObject = (g)paramObject;
    if (!getPath().equals(paramObject.getPath()))
    {
      AppMethodBeat.o(260399);
      return false;
    }
    if (this.bRI != paramObject.bRI)
    {
      AppMethodBeat.o(260399);
      return false;
    }
    if (this.VMg != paramObject.VMg)
    {
      AppMethodBeat.o(260399);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(260399);
      return false;
    }
    AppMethodBeat.o(260399);
    return true;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(260395);
    Object localObject = this.coo;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(260395);
      return localObject;
    }
    localObject = ((com.google.b.g)localObject).Ap();
    this.coo = localObject;
    AppMethodBeat.o(260395);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(260401);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(260401);
      return i;
    }
    int i = (((((((ae.VOq.hashCode() + 779) * 37 + 1) * 53 + getPath().hashCode()) * 37 + 2) * 53 + this.bRI) * 37 + 3) * 53 + be.aJ(this.VMg)) * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(260401);
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
    implements h
  {
    private long VMg;
    private int bRI;
    private Object coo;
    
    private a()
    {
      AppMethodBeat.i(260329);
      this.coo = "";
      AppMethodBeat.o(260329);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(260330);
      this.coo = "";
      AppMethodBeat.o(260330);
    }
    
    private a P(bt parambt)
    {
      AppMethodBeat.i(260340);
      if ((parambt instanceof g))
      {
        parambt = c((g)parambt);
        AppMethodBeat.o(260340);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(260340);
      return this;
    }
    
    /* Error */
    private a Q(com.google.b.h paramh, com.google.b.ap paramap)
    {
      // Byte code:
      //   0: ldc 62
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 66	com/tencent/mm/timelineedit/a/a/g:hDs	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 72 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/g
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 54	com/tencent/mm/timelineedit/a/a/g$a:c	(Lcom/tencent/mm/timelineedit/a/a/g;)Lcom/tencent/mm/timelineedit/a/a/g$a;
      //   30: pop
      //   31: ldc 62
      //   33: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 76	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/g
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 80	com/google/b/bf:Im	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 62
      //   54: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 54	com/tencent/mm/timelineedit/a/a/g$a:c	(Lcom/tencent/mm/timelineedit/a/a/g;)Lcom/tencent/mm/timelineedit/a/a/g$a;
      //   69: pop
      //   70: ldc 62
      //   72: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private a Vh(long paramLong)
    {
      AppMethodBeat.i(260347);
      this.VMg = paramLong;
      onChanged();
      AppMethodBeat.o(260347);
      return this;
    }
    
    private a aE(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260336);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(260336);
      return paramf;
    }
    
    private a aF(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260338);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(260338);
      return paramf;
    }
    
    private a aG(da paramda)
    {
      AppMethodBeat.i(260348);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(260348);
      return paramda;
    }
    
    private a aH(da paramda)
    {
      AppMethodBeat.i(260349);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(260349);
      return paramda;
    }
    
    private a ati(int paramInt)
    {
      AppMethodBeat.i(260346);
      this.bRI = paramInt;
      onChanged();
      AppMethodBeat.o(260346);
      return this;
    }
    
    private g hDt()
    {
      AppMethodBeat.i(260333);
      Object localObject = hDu();
      if (!((g)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(260333);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(260333);
      return localObject;
    }
    
    private g hDu()
    {
      AppMethodBeat.i(260335);
      g localg = new g(this, (byte)0);
      g.a(localg, this.coo);
      g.a(localg, this.bRI);
      g.a(localg, this.VMg);
      Ib();
      AppMethodBeat.o(260335);
      return localg;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(260328);
      bb.e locale = ae.VOr.b(g.class, a.class);
      AppMethodBeat.o(260328);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VOq;
    }
    
    public final a c(g paramg)
    {
      AppMethodBeat.i(260342);
      if (paramg == g.hDr())
      {
        AppMethodBeat.o(260342);
        return this;
      }
      if (!paramg.getPath().isEmpty())
      {
        this.coo = g.a(paramg);
        onChanged();
      }
      if (paramg.bRI != 0) {
        ati(paramg.bRI);
      }
      if (paramg.VMg != 0L) {
        Vh(paramg.VMg);
      }
      aH(g.b(paramg));
      onChanged();
      AppMethodBeat.o(260342);
      return this;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.g
 * JD-Core Version:    0.7.0.1
 */