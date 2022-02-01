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

public final class af
  extends bb
  implements ag
{
  private static final af VOB;
  private static final ci<af> bRf;
  long VNK;
  boolean VOA;
  private volatile Object VOy;
  private volatile Object VOz;
  private byte bRd = -1;
  
  static
  {
    AppMethodBeat.i(261832);
    VOB = new af();
    bRf = new c() {};
    AppMethodBeat.o(261832);
  }
  
  private af()
  {
    this.VOy = "";
    this.VOz = "";
  }
  
  private af(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private af(com.google.b.h paramh, com.google.b.ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 37	com/tencent/mm/timelineedit/a/a/af:<init>	()V
    //   4: ldc 68
    //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +18 -> 28
    //   13: new 70	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 71	java/lang/NullPointerException:<init>	()V
    //   20: astore_1
    //   21: ldc 68
    //   23: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_1
    //   27: athrow
    //   28: invokestatic 77	com/google/b/da:Jj	()Lcom/google/b/da$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +178 -> 214
    //   39: aload_1
    //   40: invokevirtual 83	com/google/b/h:Av	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+186->233, 0:+189->236, 10:+67->114, 18:+112->159, 24:+145->192, 32:+156->203
    //   97: aload_1
    //   98: aload 5
    //   100: aload_2
    //   101: iload 4
    //   103: invokevirtual 86	com/tencent/mm/timelineedit/a/a/af:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   106: ifne -71 -> 35
    //   109: iconst_1
    //   110: istore_3
    //   111: goto -76 -> 35
    //   114: aload_0
    //   115: aload_1
    //   116: invokevirtual 90	com/google/b/h:AC	()Ljava/lang/String;
    //   119: putfield 53	com/tencent/mm/timelineedit/a/a/af:VOy	Ljava/lang/Object;
    //   122: goto -87 -> 35
    //   125: astore_1
    //   126: aload_1
    //   127: aload_0
    //   128: putfield 94	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   131: ldc 68
    //   133: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: aload_0
    //   140: aload 5
    //   142: invokevirtual 100	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   145: putfield 104	com/tencent/mm/timelineedit/a/a/af:bVW	Lcom/google/b/da;
    //   148: aload_0
    //   149: invokevirtual 107	com/tencent/mm/timelineedit/a/a/af:HZ	()V
    //   152: ldc 68
    //   154: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload_1
    //   158: athrow
    //   159: aload_0
    //   160: aload_1
    //   161: invokevirtual 90	com/google/b/h:AC	()Ljava/lang/String;
    //   164: putfield 55	com/tencent/mm/timelineedit/a/a/af:VOz	Ljava/lang/Object;
    //   167: goto -132 -> 35
    //   170: astore_1
    //   171: new 65	com/google/b/bf
    //   174: dup
    //   175: aload_1
    //   176: invokespecial 110	com/google/b/bf:<init>	(Ljava/io/IOException;)V
    //   179: astore_1
    //   180: aload_1
    //   181: aload_0
    //   182: putfield 94	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   185: ldc 68
    //   187: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_1
    //   191: athrow
    //   192: aload_0
    //   193: aload_1
    //   194: invokevirtual 114	com/google/b/h:Ax	()J
    //   197: putfield 116	com/tencent/mm/timelineedit/a/a/af:VNK	J
    //   200: goto -165 -> 35
    //   203: aload_0
    //   204: aload_1
    //   205: invokevirtual 120	com/google/b/h:AB	()Z
    //   208: putfield 122	com/tencent/mm/timelineedit/a/a/af:VOA	Z
    //   211: goto -176 -> 35
    //   214: aload_0
    //   215: aload 5
    //   217: invokevirtual 100	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   220: putfield 104	com/tencent/mm/timelineedit/a/a/af:bVW	Lcom/google/b/da;
    //   223: aload_0
    //   224: invokevirtual 107	com/tencent/mm/timelineedit/a/a/af:HZ	()V
    //   227: ldc 68
    //   229: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: return
    //   233: goto -137 -> 96
    //   236: iconst_1
    //   237: istore_3
    //   238: goto -203 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	af
    //   0	241	1	paramh	com.google.b.h
    //   0	241	2	paramap	com.google.b.ap
    //   34	204	3	i	int
    //   43	59	4	j	int
    //   31	185	5	locala	com.google.b.da.a
    // Exception table:
    //   from	to	target	type
    //   39	45	125	com/google/b/bf
    //   96	109	125	com/google/b/bf
    //   114	122	125	com/google/b/bf
    //   159	167	125	com/google/b/bf
    //   192	200	125	com/google/b/bf
    //   203	211	125	com/google/b/bf
    //   39	45	138	finally
    //   96	109	138	finally
    //   114	122	138	finally
    //   126	138	138	finally
    //   159	167	138	finally
    //   171	192	138	finally
    //   192	200	138	finally
    //   203	211	138	finally
    //   39	45	170	java/io/IOException
    //   96	109	170	java/io/IOException
    //   114	122	170	java/io/IOException
    //   159	167	170	java/io/IOException
    //   192	200	170	java/io/IOException
    //   203	211	170	java/io/IOException
  }
  
  public static a b(af paramaf)
  {
    AppMethodBeat.i(261803);
    paramaf = VOB.hEL().f(paramaf);
    AppMethodBeat.o(261803);
    return paramaf;
  }
  
  public static ci<af> hCD()
  {
    return bRf;
  }
  
  private g hEI()
  {
    AppMethodBeat.i(261784);
    Object localObject = this.VOy;
    if ((localObject instanceof String))
    {
      localObject = g.ct((String)localObject);
      this.VOy = localObject;
      AppMethodBeat.o(261784);
      return localObject;
    }
    localObject = (g)localObject;
    AppMethodBeat.o(261784);
    return localObject;
  }
  
  private g hEK()
  {
    AppMethodBeat.i(261788);
    Object localObject = this.VOz;
    if ((localObject instanceof String))
    {
      localObject = g.ct((String)localObject);
      this.VOz = localObject;
      AppMethodBeat.o(261788);
      return localObject;
    }
    localObject = (g)localObject;
    AppMethodBeat.o(261788);
    return localObject;
  }
  
  public static af hEM()
  {
    return VOB;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(261794);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(261794);
      return i;
    }
    int j = 0;
    if (!hEI().isEmpty()) {
      j = bb.f(1, this.VOy) + 0;
    }
    i = j;
    if (!hEK().isEmpty()) {
      i = j + bb.f(2, this.VOz);
    }
    j = i;
    if (this.VNK != 0L) {
      j = i + i.p(3, this.VNK);
    }
    i = j;
    if (this.VOA) {
      i = j + i.gK(4);
    }
    i += this.bVW.Ad();
    this.bOZ = i;
    AppMethodBeat.o(261794);
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(261778);
    bb.e locale = ae.VOp.b(af.class, a.class);
    AppMethodBeat.o(261778);
    return locale;
  }
  
  public final ci<af> Co()
  {
    return bRf;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(261793);
    if (!hEI().isEmpty()) {
      bb.a(parami, 1, this.VOy);
    }
    if (!hEK().isEmpty()) {
      bb.a(parami, 2, this.VOz);
    }
    if (this.VNK != 0L) {
      parami.n(3, this.VNK);
    }
    if (this.VOA) {
      parami.t(4, this.VOA);
    }
    this.bVW.a(parami);
    AppMethodBeat.o(261793);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(261797);
    if (paramObject == this)
    {
      AppMethodBeat.o(261797);
      return true;
    }
    if (!(paramObject instanceof af))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(261797);
      return bool;
    }
    paramObject = (af)paramObject;
    if (!hEH().equals(paramObject.hEH()))
    {
      AppMethodBeat.o(261797);
      return false;
    }
    if (!hEJ().equals(paramObject.hEJ()))
    {
      AppMethodBeat.o(261797);
      return false;
    }
    if (this.VNK != paramObject.VNK)
    {
      AppMethodBeat.o(261797);
      return false;
    }
    if (this.VOA != paramObject.VOA)
    {
      AppMethodBeat.o(261797);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(261797);
      return false;
    }
    AppMethodBeat.o(261797);
    return true;
  }
  
  public final String hEH()
  {
    AppMethodBeat.i(261781);
    Object localObject = this.VOy;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(261781);
      return localObject;
    }
    localObject = ((g)localObject).Ap();
    this.VOy = localObject;
    AppMethodBeat.o(261781);
    return localObject;
  }
  
  public final String hEJ()
  {
    AppMethodBeat.i(261786);
    Object localObject = this.VOz;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(261786);
      return localObject;
    }
    localObject = ((g)localObject).Ap();
    this.VOz = localObject;
    AppMethodBeat.o(261786);
    return localObject;
  }
  
  public final a hEL()
  {
    AppMethodBeat.i(261806);
    if (this == VOB)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(261806);
      return locala;
    }
    a locala = new a((byte)0).f(this);
    AppMethodBeat.o(261806);
    return locala;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(261800);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(261800);
      return i;
    }
    int i = (((((((((ae.VOo.hashCode() + 779) * 37 + 1) * 53 + hEH().hashCode()) * 37 + 2) * 53 + hEJ().hashCode()) * 37 + 3) * 53 + be.aJ(this.VNK)) * 37 + 4) * 53 + be.bS(this.VOA)) * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(261800);
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
    implements ag
  {
    private long VNK;
    private boolean VOA;
    private Object VOy;
    private Object VOz;
    
    private a()
    {
      AppMethodBeat.i(261712);
      this.VOy = "";
      this.VOz = "";
      AppMethodBeat.o(261712);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(261713);
      this.VOy = "";
      this.VOz = "";
      AppMethodBeat.o(261713);
    }
    
    private a Fe(boolean paramBoolean)
    {
      AppMethodBeat.i(261732);
      this.VOA = paramBoolean;
      onChanged();
      AppMethodBeat.o(261732);
      return this;
    }
    
    private a Vu(long paramLong)
    {
      AppMethodBeat.i(261730);
      this.VNK = paramLong;
      onChanged();
      AppMethodBeat.o(261730);
      return this;
    }
    
    private a Z(bt parambt)
    {
      AppMethodBeat.i(261725);
      if ((parambt instanceof af))
      {
        parambt = f((af)parambt);
        AppMethodBeat.o(261725);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(261725);
      return this;
    }
    
    private a aY(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(261721);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(261721);
      return paramf;
    }
    
    private a aZ(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(261724);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(261724);
      return paramf;
    }
    
    /* Error */
    private a aa(com.google.b.h paramh, com.google.b.ap paramap)
    {
      // Byte code:
      //   0: ldc 89
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 93	com/tencent/mm/timelineedit/a/a/af:hDN	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 98 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/af
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 69	com/tencent/mm/timelineedit/a/a/af$a:f	(Lcom/tencent/mm/timelineedit/a/a/af;)Lcom/tencent/mm/timelineedit/a/a/af$a;
      //   30: pop
      //   31: ldc 89
      //   33: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 102	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/af
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 106	com/google/b/bf:Im	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 89
      //   54: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 69	com/tencent/mm/timelineedit/a/a/af$a:f	(Lcom/tencent/mm/timelineedit/a/a/af;)Lcom/tencent/mm/timelineedit/a/a/af$a;
      //   69: pop
      //   70: ldc 89
      //   72: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private a ba(da paramda)
    {
      AppMethodBeat.i(261733);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(261733);
      return paramda;
    }
    
    private a bb(da paramda)
    {
      AppMethodBeat.i(261735);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(261735);
      return paramda;
    }
    
    private af hEN()
    {
      AppMethodBeat.i(261715);
      Object localObject = hEO();
      if (!((af)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(261715);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(261715);
      return localObject;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(261710);
      bb.e locale = ae.VOp.b(af.class, a.class);
      AppMethodBeat.o(261710);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VOo;
    }
    
    public final a f(af paramaf)
    {
      AppMethodBeat.i(261727);
      if (paramaf == af.hEM())
      {
        AppMethodBeat.o(261727);
        return this;
      }
      if (!paramaf.hEH().isEmpty())
      {
        this.VOy = af.c(paramaf);
        onChanged();
      }
      if (!paramaf.hEJ().isEmpty())
      {
        this.VOz = af.d(paramaf);
        onChanged();
      }
      if (paramaf.VNK != 0L) {
        Vu(paramaf.VNK);
      }
      if (paramaf.VOA) {
        Fe(paramaf.VOA);
      }
      bb(af.e(paramaf));
      onChanged();
      AppMethodBeat.o(261727);
      return this;
    }
    
    public final af hEO()
    {
      AppMethodBeat.i(261718);
      af localaf = new af(this, (byte)0);
      af.a(localaf, this.VOy);
      af.b(localaf, this.VOz);
      af.a(localaf, this.VNK);
      af.a(localaf, this.VOA);
      Ib();
      AppMethodBeat.o(261718);
      return localaf;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.af
 * JD-Core Version:    0.7.0.1
 */