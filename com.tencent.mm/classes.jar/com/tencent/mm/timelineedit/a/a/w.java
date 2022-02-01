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
import com.google.b.cs;
import com.google.b.da;
import com.google.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends bb
  implements x
{
  private static final w VNl;
  private static final ci<w> bRf;
  long VNj;
  private aa VNk;
  private byte bRd = -1;
  
  static
  {
    AppMethodBeat.i(261264);
    VNl = new w();
    bRf = new c() {};
    AppMethodBeat.o(261264);
  }
  
  private w() {}
  
  private w(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private w(com.google.b.h paramh, com.google.b.ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 34	com/tencent/mm/timelineedit/a/a/w:<init>	()V
    //   4: ldc 59
    //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +18 -> 28
    //   13: new 61	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 62	java/lang/NullPointerException:<init>	()V
    //   20: astore_1
    //   21: ldc 59
    //   23: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_1
    //   27: athrow
    //   28: invokestatic 68	com/google/b/da:Jj	()Lcom/google/b/da$a;
    //   31: astore 6
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +187 -> 223
    //   39: aload_1
    //   40: invokevirtual 74	com/google/b/h:Av	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+204->251, 0:+210->257, 8:+51->98, 18:+96->143
    //   81: aload_1
    //   82: aload 6
    //   84: aload_2
    //   85: iload 4
    //   87: invokevirtual 77	com/tencent/mm/timelineedit/a/a/w:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   90: ifne +152 -> 242
    //   93: iconst_1
    //   94: istore_3
    //   95: goto +159 -> 254
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 81	com/google/b/h:Aw	()J
    //   103: putfield 83	com/tencent/mm/timelineedit/a/a/w:VNj	J
    //   106: goto -71 -> 35
    //   109: astore_1
    //   110: aload_1
    //   111: aload_0
    //   112: putfield 87	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   115: ldc 59
    //   117: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: aload 6
    //   126: invokevirtual 93	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   129: putfield 97	com/tencent/mm/timelineedit/a/a/w:bVW	Lcom/google/b/da;
    //   132: aload_0
    //   133: invokevirtual 100	com/tencent/mm/timelineedit/a/a/w:HZ	()V
    //   136: ldc 59
    //   138: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: athrow
    //   143: aload_0
    //   144: getfield 102	com/tencent/mm/timelineedit/a/a/w:VNk	Lcom/tencent/mm/timelineedit/a/a/aa;
    //   147: ifnull +98 -> 245
    //   150: aload_0
    //   151: getfield 102	com/tencent/mm/timelineedit/a/a/w:VNk	Lcom/tencent/mm/timelineedit/a/a/aa;
    //   154: invokevirtual 108	com/tencent/mm/timelineedit/a/a/aa:hEw	()Lcom/tencent/mm/timelineedit/a/a/aa$a;
    //   157: astore 5
    //   159: aload_0
    //   160: aload_1
    //   161: invokestatic 112	com/tencent/mm/timelineedit/a/a/aa:hCD	()Lcom/google/b/ci;
    //   164: aload_2
    //   165: invokevirtual 115	com/google/b/h:a	(Lcom/google/b/ci;Lcom/google/b/ap;)Lcom/google/b/bw;
    //   168: checkcast 104	com/tencent/mm/timelineedit/a/a/aa
    //   171: putfield 102	com/tencent/mm/timelineedit/a/a/w:VNk	Lcom/tencent/mm/timelineedit/a/a/aa;
    //   174: aload 5
    //   176: ifnull +66 -> 242
    //   179: aload 5
    //   181: aload_0
    //   182: getfield 102	com/tencent/mm/timelineedit/a/a/w:VNk	Lcom/tencent/mm/timelineedit/a/a/aa;
    //   185: invokevirtual 121	com/tencent/mm/timelineedit/a/a/aa$a:g	(Lcom/tencent/mm/timelineedit/a/a/aa;)Lcom/tencent/mm/timelineedit/a/a/aa$a;
    //   188: pop
    //   189: aload_0
    //   190: aload 5
    //   192: invokevirtual 125	com/tencent/mm/timelineedit/a/a/aa$a:hEA	()Lcom/tencent/mm/timelineedit/a/a/aa;
    //   195: putfield 102	com/tencent/mm/timelineedit/a/a/w:VNk	Lcom/tencent/mm/timelineedit/a/a/aa;
    //   198: goto -163 -> 35
    //   201: astore_1
    //   202: new 56	com/google/b/bf
    //   205: dup
    //   206: aload_1
    //   207: invokespecial 128	com/google/b/bf:<init>	(Ljava/io/IOException;)V
    //   210: astore_1
    //   211: aload_1
    //   212: aload_0
    //   213: putfield 87	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   216: ldc 59
    //   218: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_1
    //   222: athrow
    //   223: aload_0
    //   224: aload 6
    //   226: invokevirtual 93	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   229: putfield 97	com/tencent/mm/timelineedit/a/a/w:bVW	Lcom/google/b/da;
    //   232: aload_0
    //   233: invokevirtual 100	com/tencent/mm/timelineedit/a/a/w:HZ	()V
    //   236: ldc 59
    //   238: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: return
    //   242: goto +12 -> 254
    //   245: aconst_null
    //   246: astore 5
    //   248: goto -89 -> 159
    //   251: goto -171 -> 80
    //   254: goto -219 -> 35
    //   257: iconst_1
    //   258: istore_3
    //   259: goto -224 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	w
    //   0	262	1	paramh	com.google.b.h
    //   0	262	2	paramap	com.google.b.ap
    //   34	225	3	i	int
    //   43	43	4	j	int
    //   157	90	5	locala	aa.a
    //   31	194	6	locala1	com.google.b.da.a
    // Exception table:
    //   from	to	target	type
    //   39	45	109	com/google/b/bf
    //   80	93	109	com/google/b/bf
    //   98	106	109	com/google/b/bf
    //   143	159	109	com/google/b/bf
    //   159	174	109	com/google/b/bf
    //   179	198	109	com/google/b/bf
    //   39	45	122	finally
    //   80	93	122	finally
    //   98	106	122	finally
    //   110	122	122	finally
    //   143	159	122	finally
    //   159	174	122	finally
    //   179	198	122	finally
    //   202	223	122	finally
    //   39	45	201	java/io/IOException
    //   80	93	201	java/io/IOException
    //   98	106	201	java/io/IOException
    //   143	159	201	java/io/IOException
    //   159	174	201	java/io/IOException
    //   179	198	201	java/io/IOException
  }
  
  public static w di(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(261248);
    paramArrayOfByte = (w)bRf.w(paramArrayOfByte);
    AppMethodBeat.o(261248);
    return paramArrayOfByte;
  }
  
  private a hEd()
  {
    AppMethodBeat.i(261251);
    if (this == VNl)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(261251);
      return locala;
    }
    a locala = new a((byte)0).b(this);
    AppMethodBeat.o(261251);
    return locala;
  }
  
  public static w hEe()
  {
    return VNl;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(261241);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(261241);
      return i;
    }
    i = 0;
    if (this.VNj != 0L) {
      i = i.q(1, this.VNj) + 0;
    }
    int j = i;
    if (this.VNk != null) {
      j = i + i.c(2, hEc());
    }
    i = j + this.bVW.Ad();
    this.bOZ = i;
    AppMethodBeat.o(261241);
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(261236);
    bb.e locale = ae.VOx.b(w.class, a.class);
    AppMethodBeat.o(261236);
    return locale;
  }
  
  public final ci<w> Co()
  {
    return bRf;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(261240);
    if (this.VNj != 0L) {
      parami.n(1, this.VNj);
    }
    if (this.VNk != null) {
      parami.a(2, hEc());
    }
    this.bVW.a(parami);
    AppMethodBeat.o(261240);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(261243);
    if (paramObject == this)
    {
      AppMethodBeat.o(261243);
      return true;
    }
    if (!(paramObject instanceof w))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(261243);
      return bool;
    }
    paramObject = (w)paramObject;
    if (this.VNj != paramObject.VNj)
    {
      AppMethodBeat.o(261243);
      return false;
    }
    if (hEb() != paramObject.hEb())
    {
      AppMethodBeat.o(261243);
      return false;
    }
    if ((hEb()) && (!hEc().equals(paramObject.hEc())))
    {
      AppMethodBeat.o(261243);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(261243);
      return false;
    }
    AppMethodBeat.o(261243);
    return true;
  }
  
  public final long hEa()
  {
    return this.VNj;
  }
  
  public final boolean hEb()
  {
    return this.VNk != null;
  }
  
  public final aa hEc()
  {
    AppMethodBeat.i(261239);
    if (this.VNk == null)
    {
      localaa = aa.hEx();
      AppMethodBeat.o(261239);
      return localaa;
    }
    aa localaa = this.VNk;
    AppMethodBeat.o(261239);
    return localaa;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(261245);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(261245);
      return i;
    }
    int j = ((ae.VOw.hashCode() + 779) * 37 + 1) * 53 + be.aJ(this.VNj);
    int i = j;
    if (hEb()) {
      i = (j * 37 + 2) * 53 + hEc().hashCode();
    }
    i = i * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(261245);
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
    implements x
  {
    private long VNj;
    private aa VNk;
    private cs<aa, aa.a, ab> VNm;
    
    private a()
    {
      AppMethodBeat.i(261139);
      AppMethodBeat.o(261139);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(261141);
      AppMethodBeat.o(261141);
    }
    
    private a V(bt parambt)
    {
      AppMethodBeat.i(261150);
      if ((parambt instanceof w))
      {
        parambt = b((w)parambt);
        AppMethodBeat.o(261150);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(261150);
      return this;
    }
    
    private a Vl(long paramLong)
    {
      AppMethodBeat.i(261154);
      this.VNj = paramLong;
      onChanged();
      AppMethodBeat.o(261154);
      return this;
    }
    
    /* Error */
    private a W(com.google.b.h paramh, com.google.b.ap paramap)
    {
      // Byte code:
      //   0: ldc 67
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 71	com/tencent/mm/timelineedit/a/a/w:hCE	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 77 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/w
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 51	com/tencent/mm/timelineedit/a/a/w$a:b	(Lcom/tencent/mm/timelineedit/a/a/w;)Lcom/tencent/mm/timelineedit/a/a/w$a;
      //   30: pop
      //   31: ldc 67
      //   33: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 81	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/w
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 85	com/google/b/bf:Im	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 67
      //   54: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 51	com/tencent/mm/timelineedit/a/a/w$a:b	(Lcom/tencent/mm/timelineedit/a/a/w;)Lcom/tencent/mm/timelineedit/a/a/w$a;
      //   69: pop
      //   70: ldc 67
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
    
    private a a(aa paramaa)
    {
      AppMethodBeat.i(261157);
      if (this.VNm == null) {
        if (this.VNk != null)
        {
          this.VNk = aa.b(this.VNk).g(paramaa).hEA();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(261157);
        return this;
        this.VNk = paramaa;
        break;
        this.VNm.c(paramaa);
      }
    }
    
    private a aQ(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(261148);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(261148);
      return paramf;
    }
    
    private a aR(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(261149);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(261149);
      return paramf;
    }
    
    private a aS(da paramda)
    {
      AppMethodBeat.i(261159);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(261159);
      return paramda;
    }
    
    private a aT(da paramda)
    {
      AppMethodBeat.i(261160);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(261160);
      return paramda;
    }
    
    private w hEf()
    {
      AppMethodBeat.i(261144);
      Object localObject = hEg();
      if (!((w)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(261144);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(261144);
      return localObject;
    }
    
    private w hEg()
    {
      AppMethodBeat.i(261146);
      w localw = new w(this, (byte)0);
      w.a(localw, this.VNj);
      if (this.VNm == null) {
        w.a(localw, this.VNk);
      }
      for (;;)
      {
        Ib();
        AppMethodBeat.o(261146);
        return localw;
        w.a(localw, (aa)this.VNm.IV());
      }
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(261135);
      bb.e locale = ae.VOx.b(w.class, a.class);
      AppMethodBeat.o(261135);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VOw;
    }
    
    public final a b(w paramw)
    {
      AppMethodBeat.i(261151);
      if (paramw == w.hEe())
      {
        AppMethodBeat.o(261151);
        return this;
      }
      if (paramw.VNj != 0L) {
        Vl(paramw.VNj);
      }
      if (paramw.hEb()) {
        a(paramw.hEc());
      }
      aT(w.a(paramw));
      onChanged();
      AppMethodBeat.o(261151);
      return this;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.w
 * JD-Core Version:    0.7.0.1
 */