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
import com.google.b.g;
import com.google.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  extends bb
  implements t
{
  private static final s VMX;
  private static final ci<s> bRf;
  int VMV;
  g VMW;
  private byte bRd = -1;
  
  static
  {
    AppMethodBeat.i(261032);
    VMX = new s();
    bRf = new c() {};
    AppMethodBeat.o(261032);
  }
  
  private s()
  {
    this.VMW = g.bPf;
  }
  
  private s(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private s(com.google.b.h paramh, com.google.b.ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 34	com/tencent/mm/timelineedit/a/a/s:<init>	()V
    //   4: ldc 66
    //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +18 -> 28
    //   13: new 68	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   20: astore_1
    //   21: ldc 66
    //   23: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_1
    //   27: athrow
    //   28: invokestatic 75	com/google/b/da:Jj	()Lcom/google/b/da$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +140 -> 176
    //   39: aload_1
    //   40: invokevirtual 81	com/google/b/h:Av	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+148->195, 0:+151->198, 8:+51->98, 18:+96->143
    //   81: aload_1
    //   82: aload 5
    //   84: aload_2
    //   85: iload 4
    //   87: invokevirtual 84	com/tencent/mm/timelineedit/a/a/s:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   90: ifne -55 -> 35
    //   93: iconst_1
    //   94: istore_3
    //   95: goto -60 -> 35
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 87	com/google/b/h:AE	()I
    //   103: putfield 89	com/tencent/mm/timelineedit/a/a/s:VMV	I
    //   106: goto -71 -> 35
    //   109: astore_1
    //   110: aload_1
    //   111: aload_0
    //   112: putfield 93	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   115: ldc 66
    //   117: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: aload 5
    //   126: invokevirtual 99	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   129: putfield 103	com/tencent/mm/timelineedit/a/a/s:bVW	Lcom/google/b/da;
    //   132: aload_0
    //   133: invokevirtual 106	com/tencent/mm/timelineedit/a/a/s:HZ	()V
    //   136: ldc 66
    //   138: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: athrow
    //   143: aload_0
    //   144: aload_1
    //   145: invokevirtual 110	com/google/b/h:AD	()Lcom/google/b/g;
    //   148: putfield 53	com/tencent/mm/timelineedit/a/a/s:VMW	Lcom/google/b/g;
    //   151: goto -116 -> 35
    //   154: astore_1
    //   155: new 63	com/google/b/bf
    //   158: dup
    //   159: aload_1
    //   160: invokespecial 113	com/google/b/bf:<init>	(Ljava/io/IOException;)V
    //   163: astore_1
    //   164: aload_1
    //   165: aload_0
    //   166: putfield 93	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   169: ldc 66
    //   171: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_1
    //   175: athrow
    //   176: aload_0
    //   177: aload 5
    //   179: invokevirtual 99	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   182: putfield 103	com/tencent/mm/timelineedit/a/a/s:bVW	Lcom/google/b/da;
    //   185: aload_0
    //   186: invokevirtual 106	com/tencent/mm/timelineedit/a/a/s:HZ	()V
    //   189: ldc 66
    //   191: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: return
    //   195: goto -115 -> 80
    //   198: iconst_1
    //   199: istore_3
    //   200: goto -165 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	s
    //   0	203	1	paramh	com.google.b.h
    //   0	203	2	paramap	com.google.b.ap
    //   34	166	3	i	int
    //   43	43	4	j	int
    //   31	147	5	locala	com.google.b.da.a
    // Exception table:
    //   from	to	target	type
    //   39	45	109	com/google/b/bf
    //   80	93	109	com/google/b/bf
    //   98	106	109	com/google/b/bf
    //   143	151	109	com/google/b/bf
    //   39	45	122	finally
    //   80	93	122	finally
    //   98	106	122	finally
    //   110	122	122	finally
    //   143	151	122	finally
    //   155	176	122	finally
    //   39	45	154	java/io/IOException
    //   80	93	154	java/io/IOException
    //   98	106	154	java/io/IOException
    //   143	151	154	java/io/IOException
  }
  
  public static a b(s params)
  {
    AppMethodBeat.i(261009);
    params = VMX.hDQ().d(params);
    AppMethodBeat.o(261009);
    return params;
  }
  
  public static ci<s> hCD()
  {
    return bRf;
  }
  
  public static s hDR()
  {
    return VMX;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(261006);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(261006);
      return i;
    }
    i = 0;
    if (this.VMV != 0) {
      i = i.bN(1, this.VMV) + 0;
    }
    int j = i;
    if (!this.VMW.isEmpty()) {
      j = i + i.c(2, this.VMW);
    }
    i = j + this.bVW.Ad();
    this.bOZ = i;
    AppMethodBeat.o(261006);
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(261004);
    bb.e locale = ae.VOh.b(s.class, a.class);
    AppMethodBeat.o(261004);
    return locale;
  }
  
  public final ci<s> Co()
  {
    return bRf;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(261005);
    if (this.VMV != 0) {
      parami.bK(1, this.VMV);
    }
    if (!this.VMW.isEmpty()) {
      parami.a(2, this.VMW);
    }
    this.bVW.a(parami);
    AppMethodBeat.o(261005);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(261007);
    if (paramObject == this)
    {
      AppMethodBeat.o(261007);
      return true;
    }
    if (!(paramObject instanceof s))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(261007);
      return bool;
    }
    paramObject = (s)paramObject;
    if (this.VMV != paramObject.VMV)
    {
      AppMethodBeat.o(261007);
      return false;
    }
    if (!this.VMW.equals(paramObject.VMW))
    {
      AppMethodBeat.o(261007);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(261007);
      return false;
    }
    AppMethodBeat.o(261007);
    return true;
  }
  
  public final a hDQ()
  {
    AppMethodBeat.i(261010);
    if (this == VMX)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(261010);
      return locala;
    }
    a locala = new a((byte)0).d(this);
    AppMethodBeat.o(261010);
    return locala;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(261008);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(261008);
      return i;
    }
    int i = (((((ae.VOg.hashCode() + 779) * 37 + 1) * 53 + this.VMV) * 37 + 2) * 53 + this.VMW.hashCode()) * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(261008);
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
    implements t
  {
    private int VMV;
    private g VMW;
    
    private a()
    {
      AppMethodBeat.i(260942);
      this.VMW = g.bPf;
      AppMethodBeat.o(260942);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(260943);
      this.VMW = g.bPf;
      AppMethodBeat.o(260943);
    }
    
    private a T(bt parambt)
    {
      AppMethodBeat.i(260950);
      if ((parambt instanceof s))
      {
        parambt = d((s)parambt);
        AppMethodBeat.o(260950);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(260950);
      return this;
    }
    
    /* Error */
    private a U(com.google.b.h paramh, com.google.b.ap paramap)
    {
      // Byte code:
      //   0: ldc 63
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 67	com/tencent/mm/timelineedit/a/a/s:hCE	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 72 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/s
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 55	com/tencent/mm/timelineedit/a/a/s$a:d	(Lcom/tencent/mm/timelineedit/a/a/s;)Lcom/tencent/mm/timelineedit/a/a/s$a;
      //   30: pop
      //   31: ldc 63
      //   33: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 76	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/s
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 80	com/google/b/bf:Im	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 63
      //   54: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 55	com/tencent/mm/timelineedit/a/a/s$a:d	(Lcom/tencent/mm/timelineedit/a/a/s;)Lcom/tencent/mm/timelineedit/a/a/s$a;
      //   69: pop
      //   70: ldc 63
      //   72: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private a aM(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260946);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(260946);
      return paramf;
    }
    
    private a aN(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(260948);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(260948);
      return paramf;
    }
    
    private a aO(da paramda)
    {
      AppMethodBeat.i(260957);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(260957);
      return paramda;
    }
    
    private a aP(da paramda)
    {
      AppMethodBeat.i(260959);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(260959);
      return paramda;
    }
    
    private a atp(int paramInt)
    {
      AppMethodBeat.i(260955);
      this.VMV = paramInt;
      onChanged();
      AppMethodBeat.o(260955);
      return this;
    }
    
    private s hDS()
    {
      AppMethodBeat.i(260944);
      Object localObject = hDT();
      if (!((s)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(260944);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(260944);
      return localObject;
    }
    
    private a s(g paramg)
    {
      AppMethodBeat.i(260956);
      if (paramg == null)
      {
        paramg = new NullPointerException();
        AppMethodBeat.o(260956);
        throw paramg;
      }
      this.VMW = paramg;
      onChanged();
      AppMethodBeat.o(260956);
      return this;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(260941);
      bb.e locale = ae.VOh.b(s.class, a.class);
      AppMethodBeat.o(260941);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VOg;
    }
    
    public final a d(s params)
    {
      AppMethodBeat.i(260952);
      if (params == s.hDR())
      {
        AppMethodBeat.o(260952);
        return this;
      }
      if (params.VMV != 0) {
        atp(params.VMV);
      }
      if (params.VMW != g.bPf) {
        s(params.VMW);
      }
      aP(s.c(params));
      onChanged();
      AppMethodBeat.o(260952);
      return this;
    }
    
    public final s hDT()
    {
      AppMethodBeat.i(260945);
      s locals = new s(this, (byte)0);
      s.a(locals, this.VMV);
      s.a(locals, this.VMW);
      Ib();
      AppMethodBeat.o(260945);
      return locals;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.s
 * JD-Core Version:    0.7.0.1
 */