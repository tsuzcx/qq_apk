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

public final class ac
  extends bb
  implements ad
{
  private static final ac VNL;
  private static final ci<ac> bRf;
  long VNJ;
  long VNK;
  private byte bRd = -1;
  private volatile Object coo;
  
  static
  {
    AppMethodBeat.i(261690);
    VNL = new ac();
    bRf = new c() {};
    AppMethodBeat.o(261690);
  }
  
  private ac()
  {
    this.coo = "";
  }
  
  private ac(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private ac(com.google.b.h paramh, com.google.b.ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 35	com/tencent/mm/timelineedit/a/a/ac:<init>	()V
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
    //   95: invokevirtual 82	com/tencent/mm/timelineedit/a/a/ac:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   98: ifne -63 -> 35
    //   101: iconst_1
    //   102: istore_3
    //   103: goto -68 -> 35
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 86	com/google/b/h:AC	()Ljava/lang/String;
    //   111: putfield 51	com/tencent/mm/timelineedit/a/a/ac:coo	Ljava/lang/Object;
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
    //   137: putfield 100	com/tencent/mm/timelineedit/a/a/ac:bVW	Lcom/google/b/da;
    //   140: aload_0
    //   141: invokevirtual 103	com/tencent/mm/timelineedit/a/a/ac:HZ	()V
    //   144: ldc 64
    //   146: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_1
    //   150: athrow
    //   151: aload_0
    //   152: aload_1
    //   153: invokevirtual 107	com/google/b/h:Ax	()J
    //   156: putfield 109	com/tencent/mm/timelineedit/a/a/ac:VNJ	J
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
    //   189: putfield 114	com/tencent/mm/timelineedit/a/a/ac:VNK	J
    //   192: goto -157 -> 35
    //   195: aload_0
    //   196: aload 5
    //   198: invokevirtual 96	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   201: putfield 100	com/tencent/mm/timelineedit/a/a/ac:bVW	Lcom/google/b/da;
    //   204: aload_0
    //   205: invokevirtual 103	com/tencent/mm/timelineedit/a/a/ac:HZ	()V
    //   208: ldc 64
    //   210: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: return
    //   214: goto -126 -> 88
    //   217: iconst_1
    //   218: istore_3
    //   219: goto -184 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	ac
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
  
  public static a b(ac paramac)
  {
    AppMethodBeat.i(261664);
    paramac = VNL.hED().e(paramac);
    AppMethodBeat.o(261664);
    return paramac;
  }
  
  public static ci<ac> hCD()
  {
    return bRf;
  }
  
  private g hDp()
  {
    AppMethodBeat.i(261652);
    Object localObject = this.coo;
    if ((localObject instanceof String))
    {
      localObject = g.ct((String)localObject);
      this.coo = localObject;
      AppMethodBeat.o(261652);
      return localObject;
    }
    localObject = (g)localObject;
    AppMethodBeat.o(261652);
    return localObject;
  }
  
  public static ac hEE()
  {
    return VNL;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(261659);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(261659);
      return i;
    }
    int j = 0;
    if (!hDp().isEmpty()) {
      j = bb.f(1, this.coo) + 0;
    }
    i = j;
    if (this.VNJ != 0L) {
      i = j + i.p(2, this.VNJ);
    }
    j = i;
    if (this.VNK != 0L) {
      j = i + i.p(3, this.VNK);
    }
    i = j + this.bVW.Ad();
    this.bOZ = i;
    AppMethodBeat.o(261659);
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(261649);
    bb.e locale = ae.VNX.b(ac.class, a.class);
    AppMethodBeat.o(261649);
    return locale;
  }
  
  public final ci<ac> Co()
  {
    return bRf;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(261656);
    if (!hDp().isEmpty()) {
      bb.a(parami, 1, this.coo);
    }
    if (this.VNJ != 0L) {
      parami.n(2, this.VNJ);
    }
    if (this.VNK != 0L) {
      parami.n(3, this.VNK);
    }
    this.bVW.a(parami);
    AppMethodBeat.o(261656);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(261661);
    if (paramObject == this)
    {
      AppMethodBeat.o(261661);
      return true;
    }
    if (!(paramObject instanceof ac))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(261661);
      return bool;
    }
    paramObject = (ac)paramObject;
    if (!getPath().equals(paramObject.getPath()))
    {
      AppMethodBeat.o(261661);
      return false;
    }
    if (this.VNJ != paramObject.VNJ)
    {
      AppMethodBeat.o(261661);
      return false;
    }
    if (this.VNK != paramObject.VNK)
    {
      AppMethodBeat.o(261661);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(261661);
      return false;
    }
    AppMethodBeat.o(261661);
    return true;
  }
  
  public final long getDuration()
  {
    return this.VNK;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(261651);
    Object localObject = this.coo;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(261651);
      return localObject;
    }
    localObject = ((g)localObject).Ap();
    this.coo = localObject;
    AppMethodBeat.o(261651);
    return localObject;
  }
  
  public final a hED()
  {
    AppMethodBeat.i(261665);
    if (this == VNL)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(261665);
      return locala;
    }
    a locala = new a((byte)0).e(this);
    AppMethodBeat.o(261665);
    return locala;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(261662);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(261662);
      return i;
    }
    int i = (((((((ae.VNW.hashCode() + 779) * 37 + 1) * 53 + getPath().hashCode()) * 37 + 2) * 53 + be.aJ(this.VNJ)) * 37 + 3) * 53 + be.aJ(this.VNK)) * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(261662);
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
    implements ad
  {
    private long VNJ;
    private long VNK;
    private Object coo;
    
    private a()
    {
      AppMethodBeat.i(261575);
      this.coo = "";
      AppMethodBeat.o(261575);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(261576);
      this.coo = "";
      AppMethodBeat.o(261576);
    }
    
    private a Vs(long paramLong)
    {
      AppMethodBeat.i(261595);
      this.VNJ = paramLong;
      onChanged();
      AppMethodBeat.o(261595);
      return this;
    }
    
    private a Vt(long paramLong)
    {
      AppMethodBeat.i(261597);
      this.VNK = paramLong;
      onChanged();
      AppMethodBeat.o(261597);
      return this;
    }
    
    private a Y(bt parambt)
    {
      AppMethodBeat.i(261584);
      if ((parambt instanceof ac))
      {
        parambt = e((ac)parambt);
        AppMethodBeat.o(261584);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(261584);
      return this;
    }
    
    /* Error */
    private a Z(com.google.b.h paramh, com.google.b.ap paramap)
    {
      // Byte code:
      //   0: ldc 73
      //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 77	com/tencent/mm/timelineedit/a/a/ac:hDs	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 83 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/ac
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 65	com/tencent/mm/timelineedit/a/a/ac$a:e	(Lcom/tencent/mm/timelineedit/a/a/ac;)Lcom/tencent/mm/timelineedit/a/a/ac$a;
      //   30: pop
      //   31: ldc 73
      //   33: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 87	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/ac
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 91	com/google/b/bf:Im	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 73
      //   54: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 65	com/tencent/mm/timelineedit/a/a/ac$a:e	(Lcom/tencent/mm/timelineedit/a/a/ac;)Lcom/tencent/mm/timelineedit/a/a/ac$a;
      //   69: pop
      //   70: ldc 73
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
    
    private a aW(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(261581);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(261581);
      return paramf;
    }
    
    private a aX(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(261582);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(261582);
      return paramf;
    }
    
    private a aY(da paramda)
    {
      AppMethodBeat.i(261601);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(261601);
      return paramda;
    }
    
    private a aZ(da paramda)
    {
      AppMethodBeat.i(261602);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(261602);
      return paramda;
    }
    
    private ac hEF()
    {
      AppMethodBeat.i(261579);
      Object localObject = hEG();
      if (!((ac)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(261579);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(261579);
      return localObject;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(261573);
      bb.e locale = ae.VNX.b(ac.class, a.class);
      AppMethodBeat.o(261573);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VNW;
    }
    
    public final a e(ac paramac)
    {
      AppMethodBeat.i(261585);
      if (paramac == ac.hEE())
      {
        AppMethodBeat.o(261585);
        return this;
      }
      if (!paramac.getPath().isEmpty())
      {
        this.coo = ac.c(paramac);
        onChanged();
      }
      if (paramac.VNJ != 0L) {
        Vs(paramac.VNJ);
      }
      if (paramac.VNK != 0L) {
        Vt(paramac.VNK);
      }
      aZ(ac.d(paramac));
      onChanged();
      AppMethodBeat.o(261585);
      return this;
    }
    
    public final ac hEG()
    {
      AppMethodBeat.i(261580);
      ac localac = new ac(this, (byte)0);
      ac.a(localac, this.coo);
      ac.a(localac, this.VNJ);
      ac.b(localac, this.VNK);
      Ib();
      AppMethodBeat.o(261580);
      return localac;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.ac
 * JD-Core Version:    0.7.0.1
 */