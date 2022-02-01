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
import com.google.b.g;
import com.google.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends bb
  implements m
{
  private static final l VMv;
  private static final ci<l> bRf;
  long VMt;
  long VMu;
  private byte bRd = -1;
  private volatile Object coo;
  
  static
  {
    AppMethodBeat.i(260771);
    VMv = new l();
    bRf = new c() {};
    AppMethodBeat.o(260771);
  }
  
  private l()
  {
    this.coo = "";
  }
  
  private l(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private l(com.google.b.h paramh, com.google.b.ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 35	com/tencent/mm/timelineedit/a/a/l:<init>	()V
    //   4: ldc 64
    //   6: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +18 -> 28
    //   13: new 66	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 67	java/lang/NullPointerException:<init>	()V
    //   20: astore_1
    //   21: ldc 64
    //   23: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_1
    //   27: athrow
    //   28: invokestatic 73	com/google/b/da:Jj	()Lcom/google/b/da$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +159 -> 195
    //   39: aload_1
    //   40: invokevirtual 79	com/google/b/h:Av	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+167->214, 0:+170->217, 10:+59->106, 16:+104->151, 24:+137->184
    //   89: aload_1
    //   90: aload 5
    //   92: aload_2
    //   93: iload 4
    //   95: invokevirtual 82	com/tencent/mm/timelineedit/a/a/l:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   98: ifne -63 -> 35
    //   101: iconst_1
    //   102: istore_3
    //   103: goto -68 -> 35
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 86	com/google/b/h:AC	()Ljava/lang/String;
    //   111: putfield 51	com/tencent/mm/timelineedit/a/a/l:coo	Ljava/lang/Object;
    //   114: goto -79 -> 35
    //   117: astore_1
    //   118: aload_1
    //   119: aload_0
    //   120: putfield 90	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   123: ldc 64
    //   125: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: aload_0
    //   132: aload 5
    //   134: invokevirtual 96	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   137: putfield 100	com/tencent/mm/timelineedit/a/a/l:bVW	Lcom/google/b/da;
    //   140: aload_0
    //   141: invokevirtual 103	com/tencent/mm/timelineedit/a/a/l:HZ	()V
    //   144: ldc 64
    //   146: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_1
    //   150: athrow
    //   151: aload_0
    //   152: aload_1
    //   153: invokevirtual 107	com/google/b/h:Ax	()J
    //   156: putfield 109	com/tencent/mm/timelineedit/a/a/l:VMt	J
    //   159: goto -124 -> 35
    //   162: astore_1
    //   163: new 61	com/google/b/bf
    //   166: dup
    //   167: aload_1
    //   168: invokespecial 112	com/google/b/bf:<init>	(Ljava/io/IOException;)V
    //   171: astore_1
    //   172: aload_1
    //   173: aload_0
    //   174: putfield 90	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   177: ldc 64
    //   179: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_1
    //   183: athrow
    //   184: aload_0
    //   185: aload_1
    //   186: invokevirtual 107	com/google/b/h:Ax	()J
    //   189: putfield 114	com/tencent/mm/timelineedit/a/a/l:VMu	J
    //   192: goto -157 -> 35
    //   195: aload_0
    //   196: aload 5
    //   198: invokevirtual 96	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   201: putfield 100	com/tencent/mm/timelineedit/a/a/l:bVW	Lcom/google/b/da;
    //   204: aload_0
    //   205: invokevirtual 103	com/tencent/mm/timelineedit/a/a/l:HZ	()V
    //   208: ldc 64
    //   210: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: return
    //   214: goto -126 -> 88
    //   217: iconst_1
    //   218: istore_3
    //   219: goto -184 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	l
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
  
  public static ci<l> hCD()
  {
    return bRf;
  }
  
  private a hDE()
  {
    AppMethodBeat.i(260753);
    if (this == VMv)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(260753);
      return locala;
    }
    a locala = new a((byte)0).c(this);
    AppMethodBeat.o(260753);
    return locala;
  }
  
  public static l hDF()
  {
    return VMv;
  }
  
  private g hDp()
  {
    AppMethodBeat.i(260738);
    Object localObject = this.coo;
    if ((localObject instanceof String))
    {
      localObject = g.ct((String)localObject);
      this.coo = localObject;
      AppMethodBeat.o(260738);
      return localObject;
    }
    localObject = (g)localObject;
    AppMethodBeat.o(260738);
    return localObject;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(260747);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(260747);
      return i;
    }
    int j = 0;
    if (!hDp().isEmpty()) {
      j = bb.f(1, this.coo) + 0;
    }
    i = j;
    if (this.VMt != 0L) {
      i = j + i.p(2, this.VMt);
    }
    j = i;
    if (this.VMu != 0L) {
      j = i + i.p(3, this.VMu);
    }
    i = j + this.bVW.Ad();
    this.bOZ = i;
    AppMethodBeat.o(260747);
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(260734);
    bb.e locale = ae.VOn.b(l.class, a.class);
    AppMethodBeat.o(260734);
    return locale;
  }
  
  public final ci<l> Co()
  {
    return bRf;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(260744);
    if (!hDp().isEmpty()) {
      bb.a(parami, 1, this.coo);
    }
    if (this.VMt != 0L) {
      parami.n(2, this.VMt);
    }
    if (this.VMu != 0L) {
      parami.n(3, this.VMu);
    }
    this.bVW.a(parami);
    AppMethodBeat.o(260744);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(260749);
    if (paramObject == this)
    {
      AppMethodBeat.o(260749);
      return true;
    }
    if (!(paramObject instanceof l))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(260749);
      return bool;
    }
    paramObject = (l)paramObject;
    if (!getPath().equals(paramObject.getPath()))
    {
      AppMethodBeat.o(260749);
      return false;
    }
    if (this.VMt != paramObject.VMt)
    {
      AppMethodBeat.o(260749);
      return false;
    }
    if (this.VMu != paramObject.VMu)
    {
      AppMethodBeat.o(260749);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(260749);
      return false;
    }
    AppMethodBeat.o(260749);
    return true;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(260736);
    Object localObject = this.coo;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(260736);
      return localObject;
    }
    localObject = ((g)localObject).Ap();
    this.coo = localObject;
    AppMethodBeat.o(260736);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(260750);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(260750);
      return i;
    }
    int i = (((((((ae.VOm.hashCode() + 779) * 37 + 1) * 53 + getPath().hashCode()) * 37 + 2) * 53 + be.aJ(this.VMt)) * 37 + 3) * 53 + be.aJ(this.VMu)) * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(260750);
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
    implements m
  {
    private long VMt;
    private long VMu;
    private Object coo;
    
    private a()
    {
      AppMethodBeat.i(260656);
      this.coo = "";
      AppMethodBeat.o(260656);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(260657);
      this.coo = "";
      AppMethodBeat.o(260657);
    }
    
    private a R(bt parambt)
    {
      AppMethodBeat.i(260664);
      if ((parambt instanceof l))
      {
        parambt = c((l)parambt);
        AppMethodBeat.o(260664);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(260664);
      return this;
    }
    
    /* Error */
    private a S(com.google.b.h paramh, com.google.b.ap paramap)
    {
      // Byte code:
      //   0: ldc 61
      //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 65	com/tencent/mm/timelineedit/a/a/l:hDs	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 71 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/l
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 53	com/tencent/mm/timelineedit/a/a/l$a:c	(Lcom/tencent/mm/timelineedit/a/a/l;)Lcom/tencent/mm/timelineedit/a/a/l$a;
      //   30: pop
      //   31: ldc 61
      //   33: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 75	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/l
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 79	com/google/b/bf:Im	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 61
      //   54: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 53	com/tencent/mm/timelineedit/a/a/l$a:c	(Lcom/tencent/mm/timelineedit/a/a/l;)Lcom/tencent/mm/timelineedit/a/a/l$a;
      //   69: pop
      //   70: ldc 61
      //   72: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private a Vi(long paramLong)
    {
      AppMethodBeat.i(260667);
      this.VMt = paramLong;
      onChanged();
      AppMethodBeat.o(260667);
      return this;
    }
    
    private a Vj(long paramLong)
    {
      AppMethodBeat.i(260669);
      this.VMu = paramLong;
      onChanged();
      AppMethodBeat.o(260669);
      return this;
    }
    
    private a aI(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260662);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(260662);
      return paramf;
    }
    
    private a aJ(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260663);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(260663);
      return paramf;
    }
    
    private a aK(da paramda)
    {
      AppMethodBeat.i(260671);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(260671);
      return paramda;
    }
    
    private a aL(da paramda)
    {
      AppMethodBeat.i(260672);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(260672);
      return paramda;
    }
    
    private l hDG()
    {
      AppMethodBeat.i(260659);
      Object localObject = hDH();
      if (!((l)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(260659);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(260659);
      return localObject;
    }
    
    private l hDH()
    {
      AppMethodBeat.i(260660);
      l locall = new l(this, (byte)0);
      l.a(locall, this.coo);
      l.a(locall, this.VMt);
      l.b(locall, this.VMu);
      Ib();
      AppMethodBeat.o(260660);
      return locall;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(260655);
      bb.e locale = ae.VOn.b(l.class, a.class);
      AppMethodBeat.o(260655);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VOm;
    }
    
    public final a c(l paraml)
    {
      AppMethodBeat.i(260665);
      if (paraml == l.hDF())
      {
        AppMethodBeat.o(260665);
        return this;
      }
      if (!paraml.getPath().isEmpty())
      {
        this.coo = l.a(paraml);
        onChanged();
      }
      if (paraml.VMt != 0L) {
        Vi(paraml.VMt);
      }
      if (paraml.VMu != 0L) {
        Vj(paraml.VMu);
      }
      aL(l.b(paraml));
      onChanged();
      AppMethodBeat.o(260665);
      return this;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.l
 * JD-Core Version:    0.7.0.1
 */