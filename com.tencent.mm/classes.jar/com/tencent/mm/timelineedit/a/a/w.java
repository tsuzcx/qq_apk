package com.tencent.mm.timelineedit.a.a;

import com.google.d.am.a;
import com.google.d.am.f;
import com.google.d.am.j;
import com.google.d.bg;
import com.google.d.bg.a;
import com.google.d.bg.b;
import com.google.d.bg.e;
import com.google.d.bg.f;
import com.google.d.bj;
import com.google.d.c;
import com.google.d.cb;
import com.google.d.cs;
import com.google.d.df;
import com.google.d.dn;
import com.google.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends bg
  implements x
{
  private static final cs<w> PARSER;
  private static final w adrq;
  public long adro;
  private aa adrp;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(232706);
    adrq = new w();
    PARSER = new c() {};
    AppMethodBeat.o(232706);
  }
  
  private w() {}
  
  private w(bg.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private w(com.google.d.i parami, com.google.d.at paramat)
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
    //   28: invokestatic 68	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
    //   31: astore 6
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +187 -> 223
    //   39: aload_1
    //   40: invokevirtual 74	com/google/d/i:aac	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+204->251, 0:+210->257, 8:+51->98, 18:+96->143
    //   81: aload_1
    //   82: aload 6
    //   84: aload_2
    //   85: iload 4
    //   87: invokevirtual 78	com/tencent/mm/timelineedit/a/a/w:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
    //   90: ifne +152 -> 242
    //   93: iconst_1
    //   94: istore_3
    //   95: goto +159 -> 254
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 82	com/google/d/i:aad	()J
    //   103: putfield 84	com/tencent/mm/timelineedit/a/a/w:adro	J
    //   106: goto -71 -> 35
    //   109: astore_1
    //   110: aload_1
    //   111: aload_0
    //   112: putfield 88	com/google/d/bk:dST	Lcom/google/d/ce;
    //   115: ldc 59
    //   117: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: aload 6
    //   126: invokevirtual 94	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   129: putfield 98	com/tencent/mm/timelineedit/a/a/w:unknownFields	Lcom/google/d/dn;
    //   132: aload_0
    //   133: invokevirtual 101	com/tencent/mm/timelineedit/a/a/w:makeExtensionsImmutable	()V
    //   136: ldc 59
    //   138: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: athrow
    //   143: aload_0
    //   144: getfield 103	com/tencent/mm/timelineedit/a/a/w:adrp	Lcom/tencent/mm/timelineedit/a/a/aa;
    //   147: ifnull +98 -> 245
    //   150: aload_0
    //   151: getfield 103	com/tencent/mm/timelineedit/a/a/w:adrp	Lcom/tencent/mm/timelineedit/a/a/aa;
    //   154: invokevirtual 109	com/tencent/mm/timelineedit/a/a/aa:jgI	()Lcom/tencent/mm/timelineedit/a/a/aa$a;
    //   157: astore 5
    //   159: aload_0
    //   160: aload_1
    //   161: invokestatic 113	com/tencent/mm/timelineedit/a/a/aa:parser	()Lcom/google/d/cs;
    //   164: aload_2
    //   165: invokevirtual 116	com/google/d/i:a	(Lcom/google/d/cs;Lcom/google/d/at;)Lcom/google/d/ce;
    //   168: checkcast 105	com/tencent/mm/timelineedit/a/a/aa
    //   171: putfield 103	com/tencent/mm/timelineedit/a/a/w:adrp	Lcom/tencent/mm/timelineedit/a/a/aa;
    //   174: aload 5
    //   176: ifnull +66 -> 242
    //   179: aload 5
    //   181: aload_0
    //   182: getfield 103	com/tencent/mm/timelineedit/a/a/w:adrp	Lcom/tencent/mm/timelineedit/a/a/aa;
    //   185: invokevirtual 122	com/tencent/mm/timelineedit/a/a/aa$a:g	(Lcom/tencent/mm/timelineedit/a/a/aa;)Lcom/tencent/mm/timelineedit/a/a/aa$a;
    //   188: pop
    //   189: aload_0
    //   190: aload 5
    //   192: invokevirtual 126	com/tencent/mm/timelineedit/a/a/aa$a:jgN	()Lcom/tencent/mm/timelineedit/a/a/aa;
    //   195: putfield 103	com/tencent/mm/timelineedit/a/a/w:adrp	Lcom/tencent/mm/timelineedit/a/a/aa;
    //   198: goto -163 -> 35
    //   201: astore_1
    //   202: new 56	com/google/d/bk
    //   205: dup
    //   206: aload_1
    //   207: invokespecial 129	com/google/d/bk:<init>	(Ljava/io/IOException;)V
    //   210: astore_1
    //   211: aload_1
    //   212: aload_0
    //   213: putfield 88	com/google/d/bk:dST	Lcom/google/d/ce;
    //   216: ldc 59
    //   218: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_1
    //   222: athrow
    //   223: aload_0
    //   224: aload 6
    //   226: invokevirtual 94	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   229: putfield 98	com/tencent/mm/timelineedit/a/a/w:unknownFields	Lcom/google/d/dn;
    //   232: aload_0
    //   233: invokevirtual 101	com/tencent/mm/timelineedit/a/a/w:makeExtensionsImmutable	()V
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
    //   0	262	1	parami	com.google.d.i
    //   0	262	2	paramat	com.google.d.at
    //   34	225	3	i	int
    //   43	43	4	j	int
    //   157	90	5	locala	aa.a
    //   31	194	6	locala1	com.google.d.dn.a
    // Exception table:
    //   from	to	target	type
    //   39	45	109	com/google/d/bk
    //   80	93	109	com/google/d/bk
    //   98	106	109	com/google/d/bk
    //   143	159	109	com/google/d/bk
    //   159	174	109	com/google/d/bk
    //   179	198	109	com/google/d/bk
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
  
  public static w dl(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(232656);
    paramArrayOfByte = (w)PARSER.parseFrom(paramArrayOfByte);
    AppMethodBeat.o(232656);
    return paramArrayOfByte;
  }
  
  private a jgn()
  {
    AppMethodBeat.i(232659);
    if (this == adrq)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(232659);
      return locala;
    }
    a locala = new a((byte)0).b(this);
    AppMethodBeat.o(232659);
    return locala;
  }
  
  public static w jgo()
  {
    return adrq;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232803);
    if (paramObject == this)
    {
      AppMethodBeat.o(232803);
      return true;
    }
    if (!(paramObject instanceof w))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(232803);
      return bool;
    }
    paramObject = (w)paramObject;
    if (this.adro != paramObject.adro)
    {
      AppMethodBeat.o(232803);
      return false;
    }
    if (jgl() != paramObject.jgl())
    {
      AppMethodBeat.o(232803);
      return false;
    }
    if ((jgl()) && (!jgm().equals(paramObject.jgm())))
    {
      AppMethodBeat.o(232803);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(232803);
      return false;
    }
    AppMethodBeat.o(232803);
    return true;
  }
  
  public final cs<w> getParserForType()
  {
    return PARSER;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(232791);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(232791);
      return i;
    }
    i = 0;
    if (this.adro != 0L) {
      i = k.r(1, this.adro) + 0;
    }
    int j = i;
    if (this.adrp != null) {
      j = i + k.c(2, jgm());
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    AppMethodBeat.o(232791);
    return i;
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(232817);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(232817);
      return i;
    }
    int j = ((ae.adsB.hashCode() + 779) * 37 + 1) * 53 + bj.hashLong(this.adro);
    int i = j;
    if (jgl()) {
      i = (j * 37 + 2) * 53 + jgm().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(232817);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(232734);
    bg.e locale = ae.adsC.b(w.class, a.class);
    AppMethodBeat.o(232734);
    return locale;
  }
  
  public final boolean isInitialized()
  {
    int i = this.memoizedIsInitialized;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public final boolean jgl()
  {
    return this.adrp != null;
  }
  
  public final aa jgm()
  {
    AppMethodBeat.i(232753);
    if (this.adrp == null)
    {
      localaa = aa.jgJ();
      AppMethodBeat.o(232753);
      return localaa;
    }
    aa localaa = this.adrp;
    AppMethodBeat.o(232753);
    return localaa;
  }
  
  public final Object newInstance(bg.f paramf)
  {
    AppMethodBeat.i(232717);
    paramf = new w();
    AppMethodBeat.o(232717);
    return paramf;
  }
  
  public final void writeTo(k paramk)
  {
    AppMethodBeat.i(232777);
    if (this.adro != 0L) {
      paramk.n(1, this.adro);
    }
    if (this.adrp != null) {
      paramk.a(2, jgm());
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(232777);
  }
  
  public static final class a
    extends bg.a<a>
    implements x
  {
    private long adro;
    private aa adrp;
    private df<aa, aa.a, ab> adrr;
    
    private a()
    {
      AppMethodBeat.i(232098);
      w.ayB();
      AppMethodBeat.o(232098);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232111);
      w.ayB();
      AppMethodBeat.o(232111);
    }
    
    private a S(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232180);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232180);
      return paramf;
    }
    
    /* Error */
    private a S(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: ldc 55
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 59	com/tencent/mm/timelineedit/a/a/w:jeJ	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 65 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/w
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 69	com/tencent/mm/timelineedit/a/a/w$a:b	(Lcom/tencent/mm/timelineedit/a/a/w;)Lcom/tencent/mm/timelineedit/a/a/w$a;
      //   30: pop
      //   31: ldc 55
      //   33: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 73	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/w
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 77	com/google/d/bk:aii	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 55
      //   54: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 69	com/tencent/mm/timelineedit/a/a/w$a:b	(Lcom/tencent/mm/timelineedit/a/a/w;)Lcom/tencent/mm/timelineedit/a/a/w$a;
      //   69: pop
      //   70: ldc 55
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
      //   0	83	1	parami	com.google.d.i
      //   0	83	2	paramat	com.google.d.at
      //   6	73	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	com/google/d/bk
      //   47	59	59	finally
      //   7	21	77	finally
      //   39	47	77	finally
    }
    
    private a T(cb paramcb)
    {
      AppMethodBeat.i(232198);
      if ((paramcb instanceof w))
      {
        paramcb = b((w)paramcb);
        AppMethodBeat.o(232198);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232198);
      return this;
    }
    
    private a W(am.j paramj)
    {
      AppMethodBeat.i(232169);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232169);
      return paramj;
    }
    
    private a a(aa paramaa)
    {
      AppMethodBeat.i(232239);
      if (this.adrr == null) {
        if (this.adrp != null)
        {
          this.adrp = aa.b(this.adrp).g(paramaa).jgN();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(232239);
        return this;
        this.adrp = paramaa;
        break;
        this.adrr.c(paramaa);
      }
    }
    
    private a aM(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232150);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232150);
      return paramf;
    }
    
    private a aN(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232189);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232189);
      return paramf;
    }
    
    private a aO(dn paramdn)
    {
      AppMethodBeat.i(232252);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(232252);
      return paramdn;
    }
    
    private a aP(dn paramdn)
    {
      AppMethodBeat.i(232268);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(232268);
      return paramdn;
    }
    
    private a aa(am.f paramf)
    {
      AppMethodBeat.i(232160);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232160);
      return paramf;
    }
    
    private a jgp()
    {
      AppMethodBeat.i(232119);
      super.clear();
      this.adro = 0L;
      if (this.adrr == null) {
        this.adrp = null;
      }
      for (;;)
      {
        AppMethodBeat.o(232119);
        return this;
        this.adrp = null;
        this.adrr = null;
      }
    }
    
    private w jgq()
    {
      AppMethodBeat.i(232128);
      Object localObject = jgr();
      if (!((w)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232128);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232128);
      return localObject;
    }
    
    private w jgr()
    {
      AppMethodBeat.i(232144);
      w localw = new w(this, (byte)0);
      w.a(localw, this.adro);
      if (this.adrr == null) {
        w.a(localw, this.adrp);
      }
      for (;;)
      {
        onBuilt();
        AppMethodBeat.o(232144);
        return localw;
        w.a(localw, (aa)this.adrr.ajn());
      }
    }
    
    private a zt(long paramLong)
    {
      AppMethodBeat.i(232222);
      this.adro = paramLong;
      onChanged();
      AppMethodBeat.o(232222);
      return this;
    }
    
    public final a b(w paramw)
    {
      AppMethodBeat.i(232360);
      if (paramw == w.jgo())
      {
        AppMethodBeat.o(232360);
        return this;
      }
      if (paramw.adro != 0L) {
        zt(paramw.adro);
      }
      if (paramw.jgl()) {
        a(paramw.jgm());
      }
      aP(w.a(paramw));
      onChanged();
      AppMethodBeat.o(232360);
      return this;
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adsB;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(232320);
      bg.e locale = ae.adsC.b(w.class, a.class);
      AppMethodBeat.o(232320);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.w
 * JD-Core Version:    0.7.0.1
 */