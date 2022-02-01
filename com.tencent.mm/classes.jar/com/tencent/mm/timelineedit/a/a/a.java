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
import com.google.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends bb
  implements b
{
  private static final a VLF;
  private static final ci<a> bRf;
  int VLD;
  private s VLE;
  private byte bRd = -1;
  
  static
  {
    AppMethodBeat.i(260002);
    VLF = new a();
    bRf = new c() {};
    AppMethodBeat.o(260002);
  }
  
  private a() {}
  
  private a(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private a(com.google.b.h paramh, com.google.b.ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 34	com/tencent/mm/timelineedit/a/a/a:<init>	()V
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
    //   87: invokevirtual 77	com/tencent/mm/timelineedit/a/a/a:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   90: ifne +152 -> 242
    //   93: iconst_1
    //   94: istore_3
    //   95: goto +159 -> 254
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 80	com/google/b/h:AE	()I
    //   103: putfield 82	com/tencent/mm/timelineedit/a/a/a:VLD	I
    //   106: goto -71 -> 35
    //   109: astore_1
    //   110: aload_1
    //   111: aload_0
    //   112: putfield 86	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   115: ldc 59
    //   117: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: aload 6
    //   126: invokevirtual 92	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   129: putfield 96	com/tencent/mm/timelineedit/a/a/a:bVW	Lcom/google/b/da;
    //   132: aload_0
    //   133: invokevirtual 99	com/tencent/mm/timelineedit/a/a/a:HZ	()V
    //   136: ldc 59
    //   138: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: athrow
    //   143: aload_0
    //   144: getfield 101	com/tencent/mm/timelineedit/a/a/a:VLE	Lcom/tencent/mm/timelineedit/a/a/s;
    //   147: ifnull +98 -> 245
    //   150: aload_0
    //   151: getfield 101	com/tencent/mm/timelineedit/a/a/a:VLE	Lcom/tencent/mm/timelineedit/a/a/s;
    //   154: invokevirtual 107	com/tencent/mm/timelineedit/a/a/s:hDQ	()Lcom/tencent/mm/timelineedit/a/a/s$a;
    //   157: astore 5
    //   159: aload_0
    //   160: aload_1
    //   161: invokestatic 111	com/tencent/mm/timelineedit/a/a/s:hCD	()Lcom/google/b/ci;
    //   164: aload_2
    //   165: invokevirtual 114	com/google/b/h:a	(Lcom/google/b/ci;Lcom/google/b/ap;)Lcom/google/b/bw;
    //   168: checkcast 103	com/tencent/mm/timelineedit/a/a/s
    //   171: putfield 101	com/tencent/mm/timelineedit/a/a/a:VLE	Lcom/tencent/mm/timelineedit/a/a/s;
    //   174: aload 5
    //   176: ifnull +66 -> 242
    //   179: aload 5
    //   181: aload_0
    //   182: getfield 101	com/tencent/mm/timelineedit/a/a/a:VLE	Lcom/tencent/mm/timelineedit/a/a/s;
    //   185: invokevirtual 120	com/tencent/mm/timelineedit/a/a/s$a:d	(Lcom/tencent/mm/timelineedit/a/a/s;)Lcom/tencent/mm/timelineedit/a/a/s$a;
    //   188: pop
    //   189: aload_0
    //   190: aload 5
    //   192: invokevirtual 124	com/tencent/mm/timelineedit/a/a/s$a:hDT	()Lcom/tencent/mm/timelineedit/a/a/s;
    //   195: putfield 101	com/tencent/mm/timelineedit/a/a/a:VLE	Lcom/tencent/mm/timelineedit/a/a/s;
    //   198: goto -163 -> 35
    //   201: astore_1
    //   202: new 56	com/google/b/bf
    //   205: dup
    //   206: aload_1
    //   207: invokespecial 127	com/google/b/bf:<init>	(Ljava/io/IOException;)V
    //   210: astore_1
    //   211: aload_1
    //   212: aload_0
    //   213: putfield 86	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   216: ldc 59
    //   218: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_1
    //   222: athrow
    //   223: aload_0
    //   224: aload 6
    //   226: invokevirtual 92	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   229: putfield 96	com/tencent/mm/timelineedit/a/a/a:bVW	Lcom/google/b/da;
    //   232: aload_0
    //   233: invokevirtual 99	com/tencent/mm/timelineedit/a/a/a:HZ	()V
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
    //   0	262	0	this	a
    //   0	262	1	paramh	com.google.b.h
    //   0	262	2	paramap	com.google.b.ap
    //   34	225	3	i	int
    //   43	43	4	j	int
    //   157	90	5	locala	s.a
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
  
  private a hCB()
  {
    AppMethodBeat.i(259996);
    if (this == VLF)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(259996);
      return locala;
    }
    a locala = new a((byte)0).b(this);
    AppMethodBeat.o(259996);
    return locala;
  }
  
  public static a hCC()
  {
    return VLF;
  }
  
  public static ci<a> hCD()
  {
    return bRf;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(259993);
    int i = this.bOZ;
    if (i != -1)
    {
      AppMethodBeat.o(259993);
      return i;
    }
    i = 0;
    if (this.VLD != 0) {
      i = i.bN(1, this.VLD) + 0;
    }
    int j = i;
    if (this.VLE != null) {
      j = i + i.c(2, hCA());
    }
    i = j + this.bVW.Ad();
    this.bOZ = i;
    AppMethodBeat.o(259993);
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final bb.e Cb()
  {
    AppMethodBeat.i(259988);
    bb.e locale = ae.VOj.b(a.class, a.class);
    AppMethodBeat.o(259988);
    return locale;
  }
  
  public final ci<a> Co()
  {
    return bRf;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(259992);
    if (this.VLD != 0) {
      parami.bK(1, this.VLD);
    }
    if (this.VLE != null) {
      parami.a(2, hCA());
    }
    this.bVW.a(parami);
    AppMethodBeat.o(259992);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(259994);
    if (paramObject == this)
    {
      AppMethodBeat.o(259994);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(259994);
      return bool;
    }
    paramObject = (a)paramObject;
    if (this.VLD != paramObject.VLD)
    {
      AppMethodBeat.o(259994);
      return false;
    }
    if (hCz() != paramObject.hCz())
    {
      AppMethodBeat.o(259994);
      return false;
    }
    if ((hCz()) && (!hCA().equals(paramObject.hCA())))
    {
      AppMethodBeat.o(259994);
      return false;
    }
    if (!this.bVW.equals(paramObject.bVW))
    {
      AppMethodBeat.o(259994);
      return false;
    }
    AppMethodBeat.o(259994);
    return true;
  }
  
  public final s hCA()
  {
    AppMethodBeat.i(259991);
    if (this.VLE == null)
    {
      locals = s.hDR();
      AppMethodBeat.o(259991);
      return locals;
    }
    s locals = this.VLE;
    AppMethodBeat.o(259991);
    return locals;
  }
  
  public final boolean hCz()
  {
    return this.VLE != null;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(259995);
    if (this.bPa != 0)
    {
      i = this.bPa;
      AppMethodBeat.o(259995);
      return i;
    }
    int j = ((ae.VOi.hashCode() + 779) * 37 + 1) * 53 + this.VLD;
    int i = j;
    if (hCz()) {
      i = (j * 37 + 2) * 53 + hCA().hashCode();
    }
    i = i * 29 + this.bVW.hashCode();
    this.bPa = i;
    AppMethodBeat.o(259995);
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
    implements b
  {
    private int VLD;
    private s VLE;
    private cs<s, s.a, t> VLG;
    
    private a()
    {
      AppMethodBeat.i(259928);
      AppMethodBeat.o(259928);
    }
    
    private a(bb.b paramb)
    {
      super();
      AppMethodBeat.i(259929);
      AppMethodBeat.o(259929);
    }
    
    private a M(bt parambt)
    {
      AppMethodBeat.i(259941);
      if ((parambt instanceof a))
      {
        parambt = b((a)parambt);
        AppMethodBeat.o(259941);
        return parambt;
      }
      super.a(parambt);
      AppMethodBeat.o(259941);
      return this;
    }
    
    /* Error */
    private a N(com.google.b.h paramh, com.google.b.ap paramap)
    {
      // Byte code:
      //   0: ldc 59
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 63	com/tencent/mm/timelineedit/a/a/a:hCE	()Lcom/google/b/ci;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 69 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/a
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 51	com/tencent/mm/timelineedit/a/a/a$a:b	(Lcom/tencent/mm/timelineedit/a/a/a;)Lcom/tencent/mm/timelineedit/a/a/a$a;
      //   30: pop
      //   31: ldc 59
      //   33: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 73	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/a
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
      //   66: invokevirtual 51	com/tencent/mm/timelineedit/a/a/a$a:b	(Lcom/tencent/mm/timelineedit/a/a/a;)Lcom/tencent/mm/timelineedit/a/a/a$a;
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
    
    private a a(s params)
    {
      AppMethodBeat.i(259948);
      if (this.VLG == null) {
        if (this.VLE != null)
        {
          this.VLE = s.b(this.VLE).d(params).hDT();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(259948);
        return this;
        this.VLE = params;
        break;
        this.VLG.c(params);
      }
    }
    
    private a aA(da paramda)
    {
      AppMethodBeat.i(259949);
      paramda = (a)super.e(paramda);
      AppMethodBeat.o(259949);
      return paramda;
    }
    
    private a aB(da paramda)
    {
      AppMethodBeat.i(259950);
      paramda = (a)super.d(paramda);
      AppMethodBeat.o(259950);
      return paramda;
    }
    
    private a ath(int paramInt)
    {
      AppMethodBeat.i(259947);
      this.VLD = paramInt;
      onChanged();
      AppMethodBeat.o(259947);
      return this;
    }
    
    private a ay(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(259938);
      paramf = (a)super.d(paramf, paramObject);
      AppMethodBeat.o(259938);
      return paramf;
    }
    
    private a az(aj.f paramf, Object paramObject)
    {
      AppMethodBeat.i(259939);
      paramf = (a)super.c(paramf, paramObject);
      AppMethodBeat.o(259939);
      return paramf;
    }
    
    private a hCF()
    {
      AppMethodBeat.i(259932);
      Object localObject = hCG();
      if (!((a)localObject).isInitialized())
      {
        localObject = b((bt)localObject);
        AppMethodBeat.o(259932);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(259932);
      return localObject;
    }
    
    private a hCG()
    {
      AppMethodBeat.i(259934);
      a locala = new a(this, (byte)0);
      a.a(locala, this.VLD);
      if (this.VLG == null) {
        a.a(locala, this.VLE);
      }
      for (;;)
      {
        Ib();
        AppMethodBeat.o(259934);
        return locala;
        a.a(locala, (s)this.VLG.IV());
      }
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(259926);
      bb.e locale = ae.VOj.b(a.class, a.class);
      AppMethodBeat.o(259926);
      return locale;
    }
    
    public final aj.a Cv()
    {
      return ae.VOi;
    }
    
    public final a b(a parama)
    {
      AppMethodBeat.i(259942);
      if (parama == a.hCC())
      {
        AppMethodBeat.o(259942);
        return this;
      }
      if (parama.VLD != 0) {
        ath(parama.VLD);
      }
      if (parama.hCz()) {
        a(parama.hCA());
      }
      aB(a.a(parama));
      onChanged();
      AppMethodBeat.o(259942);
      return this;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.a
 * JD-Core Version:    0.7.0.1
 */