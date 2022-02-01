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
import com.google.b.da;
import com.google.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends bb
  implements r
{
  private static final q VMU;
  private static final ci<q> bRf;
  int VMQ;
  int VMR;
  int VMS;
  int VMT;
  private byte bRd = -1;
  
  static
  {
    AppMethodBeat.i(260929);
    VMU = new q();
    bRf = new c() {};
    AppMethodBeat.o(260929);
  }
  
  private q() {}
  
  private q(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private q(com.google.b.h paramh, com.google.b.ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 35	com/tencent/mm/timelineedit/a/a/q:<init>	()V
    //   4: ldc 60
    //   6: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +18 -> 28
    //   13: new 62	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 63	java/lang/NullPointerException:<init>	()V
    //   20: astore_1
    //   21: ldc 60
    //   23: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_1
    //   27: athrow
    //   28: invokestatic 69	com/google/b/da:Jj	()Lcom/google/b/da$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +178 -> 214
    //   39: aload_1
    //   40: invokevirtual 75	com/google/b/h:Av	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+186->233, 0:+189->236, 8:+67->114, 16:+112->159, 24:+145->192, 32:+156->203
    //   97: aload_1
    //   98: aload 5
    //   100: aload_2
    //   101: iload 4
    //   103: invokevirtual 78	com/tencent/mm/timelineedit/a/a/q:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   106: ifne -71 -> 35
    //   109: iconst_1
    //   110: istore_3
    //   111: goto -76 -> 35
    //   114: aload_0
    //   115: aload_1
    //   116: invokevirtual 81	com/google/b/h:Ay	()I
    //   119: putfield 83	com/tencent/mm/timelineedit/a/a/q:VMQ	I
    //   122: goto -87 -> 35
    //   125: astore_1
    //   126: aload_1
    //   127: aload_0
    //   128: putfield 87	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   131: ldc 60
    //   133: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: aload_0
    //   140: aload 5
    //   142: invokevirtual 93	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   145: putfield 97	com/tencent/mm/timelineedit/a/a/q:bVW	Lcom/google/b/da;
    //   148: aload_0
    //   149: invokevirtual 100	com/tencent/mm/timelineedit/a/a/q:HZ	()V
    //   152: ldc 60
    //   154: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload_1
    //   158: athrow
    //   159: aload_0
    //   160: aload_1
    //   161: invokevirtual 81	com/google/b/h:Ay	()I
    //   164: putfield 102	com/tencent/mm/timelineedit/a/a/q:VMR	I
    //   167: goto -132 -> 35
    //   170: astore_1
    //   171: new 57	com/google/b/bf
    //   174: dup
    //   175: aload_1
    //   176: invokespecial 105	com/google/b/bf:<init>	(Ljava/io/IOException;)V
    //   179: astore_1
    //   180: aload_1
    //   181: aload_0
    //   182: putfield 87	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   185: ldc 60
    //   187: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_1
    //   191: athrow
    //   192: aload_0
    //   193: aload_1
    //   194: invokevirtual 81	com/google/b/h:Ay	()I
    //   197: putfield 107	com/tencent/mm/timelineedit/a/a/q:VMS	I
    //   200: goto -165 -> 35
    //   203: aload_0
    //   204: aload_1
    //   205: invokevirtual 81	com/google/b/h:Ay	()I
    //   208: putfield 109	com/tencent/mm/timelineedit/a/a/q:VMT	I
    //   211: goto -176 -> 35
    //   214: aload_0
    //   215: aload 5
    //   217: invokevirtual 93	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   220: putfield 97	com/tencent/mm/timelineedit/a/a/q:bVW	Lcom/google/b/da;
    //   223: aload_0
    //   224: invokevirtual 100	com/tencent/mm/timelineedit/a/a/q:HZ	()V
    //   227: ldc 60
    //   229: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: return
    //   233: goto -137 -> 96
    //   236: iconst_1
    //   237: istore_3
    //   238: goto -203 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	q
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
  
  public static ci<q> hCD()
  {
    return bRf;
  }
  
  public static a hDK()
  {
    AppMethodBeat.i(260917);
    a locala = VMU.hDL();
    AppMethodBeat.o(260917);
    return locala;
  }
  
  public static q hDM()
  {
    return VMU;
  }
  
  public static a j(q paramq)
  {
    AppMethodBeat.i(260918);
    paramq = VMU.hDL().l(paramq);
    AppMethodBeat.o(260918);
    return paramq;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(260913);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(260913);
      return i;
    }
    int j = 0;
    if (this.VMQ != 0) {
      j = i.bM(1, this.VMQ) + 0;
    }
    i = j;
    if (this.VMR != 0) {
      i = j + i.bM(2, this.VMR);
    }
    j = i;
    if (this.VMS != 0) {
      j = i + i.bM(3, this.VMS);
    }
    i = j;
    if (this.VMT != 0) {
      i = j + i.bM(4, this.VMT);
    }
    i += this.bVW.Ad();
    this.bOZ = i;
    AppMethodBeat.o(260913);
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(260906);
    bb.e locale = ae.VNP.b(q.class, a.class);
    AppMethodBeat.o(260906);
    return locale;
  }
  
  public final ci<q> Co()
  {
    return bRf;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(260912);
    if (this.VMQ != 0) {
      parami.bJ(1, this.VMQ);
    }
    if (this.VMR != 0) {
      parami.bJ(2, this.VMR);
    }
    if (this.VMS != 0) {
      parami.bJ(3, this.VMS);
    }
    if (this.VMT != 0) {
      parami.bJ(4, this.VMT);
    }
    this.bVW.a(parami);
    AppMethodBeat.o(260912);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(260914);
    if (paramObject == this)
    {
      AppMethodBeat.o(260914);
      return true;
    }
    if (!(paramObject instanceof q))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(260914);
      return bool;
    }
    paramObject = (q)paramObject;
    if (this.VMQ != paramObject.VMQ)
    {
      AppMethodBeat.o(260914);
      return false;
    }
    if (this.VMR != paramObject.VMR)
    {
      AppMethodBeat.o(260914);
      return false;
    }
    if (this.VMS != paramObject.VMS)
    {
      AppMethodBeat.o(260914);
      return false;
    }
    if (this.VMT != paramObject.VMT)
    {
      AppMethodBeat.o(260914);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(260914);
      return false;
    }
    AppMethodBeat.o(260914);
    return true;
  }
  
  public final int fG()
  {
    return this.VMS;
  }
  
  public final int fH()
  {
    return this.VMT;
  }
  
  public final int hDI()
  {
    return this.VMQ;
  }
  
  public final int hDJ()
  {
    return this.VMR;
  }
  
  public final a hDL()
  {
    AppMethodBeat.i(260920);
    if (this == VMU)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(260920);
      return locala;
    }
    a locala = new a((byte)0).l(this);
    AppMethodBeat.o(260920);
    return locala;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(260915);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(260915);
      return i;
    }
    int i = (((((((((ae.VNO.hashCode() + 779) * 37 + 1) * 53 + this.VMQ) * 37 + 2) * 53 + this.VMR) * 37 + 3) * 53 + this.VMS) * 37 + 4) * 53 + this.VMT) * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(260915);
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
    implements r
  {
    private int VMQ;
    private int VMR;
    private int VMS;
    private int VMT;
    
    private a()
    {
      AppMethodBeat.i(260829);
      AppMethodBeat.o(260829);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(260831);
      AppMethodBeat.o(260831);
    }
    
    private a S(bt parambt)
    {
      AppMethodBeat.i(260840);
      if ((parambt instanceof q))
      {
        parambt = l((q)parambt);
        AppMethodBeat.o(260840);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(260840);
      return this;
    }
    
    /* Error */
    private a T(com.google.b.h paramh, com.google.b.ap paramap)
    {
      // Byte code:
      //   0: ldc 57
      //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 61	com/tencent/mm/timelineedit/a/a/q:hDN	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 67 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/q
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 49	com/tencent/mm/timelineedit/a/a/q$a:l	(Lcom/tencent/mm/timelineedit/a/a/q;)Lcom/tencent/mm/timelineedit/a/a/q$a;
      //   30: pop
      //   31: ldc 57
      //   33: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 71	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/q
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 75	com/google/b/bf:Im	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 57
      //   54: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 49	com/tencent/mm/timelineedit/a/a/q$a:l	(Lcom/tencent/mm/timelineedit/a/a/q;)Lcom/tencent/mm/timelineedit/a/a/q$a;
      //   69: pop
      //   70: ldc 57
      //   72: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private a aK(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260837);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(260837);
      return paramf;
    }
    
    private a aL(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260838);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(260838);
      return paramf;
    }
    
    private a aM(da paramda)
    {
      AppMethodBeat.i(260853);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(260853);
      return paramda;
    }
    
    private a aN(da paramda)
    {
      AppMethodBeat.i(260855);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(260855);
      return paramda;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(260828);
      bb.e locale = ae.VNP.b(q.class, a.class);
      AppMethodBeat.o(260828);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VNO;
    }
    
    public final a atl(int paramInt)
    {
      AppMethodBeat.i(260846);
      this.VMQ = paramInt;
      onChanged();
      AppMethodBeat.o(260846);
      return this;
    }
    
    public final a atm(int paramInt)
    {
      AppMethodBeat.i(260848);
      this.VMR = paramInt;
      onChanged();
      AppMethodBeat.o(260848);
      return this;
    }
    
    public final a atn(int paramInt)
    {
      AppMethodBeat.i(260850);
      this.VMS = paramInt;
      onChanged();
      AppMethodBeat.o(260850);
      return this;
    }
    
    public final a ato(int paramInt)
    {
      AppMethodBeat.i(260851);
      this.VMT = paramInt;
      onChanged();
      AppMethodBeat.o(260851);
      return this;
    }
    
    public final q hDO()
    {
      AppMethodBeat.i(260833);
      Object localObject = hDP();
      if (!((q)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(260833);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(260833);
      return localObject;
    }
    
    public final q hDP()
    {
      AppMethodBeat.i(260835);
      q localq = new q(this, (byte)0);
      q.a(localq, this.VMQ);
      q.b(localq, this.VMR);
      q.c(localq, this.VMS);
      q.d(localq, this.VMT);
      Ib();
      AppMethodBeat.o(260835);
      return localq;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public final a l(q paramq)
    {
      AppMethodBeat.i(260842);
      if (paramq == q.hDM())
      {
        AppMethodBeat.o(260842);
        return this;
      }
      if (paramq.VMQ != 0) {
        atl(paramq.VMQ);
      }
      if (paramq.VMR != 0) {
        atm(paramq.VMR);
      }
      if (paramq.VMS != 0) {
        atn(paramq.VMS);
      }
      if (paramq.VMT != 0) {
        ato(paramq.VMT);
      }
      aN(q.k(paramq));
      onChanged();
      AppMethodBeat.o(260842);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.q
 * JD-Core Version:    0.7.0.1
 */