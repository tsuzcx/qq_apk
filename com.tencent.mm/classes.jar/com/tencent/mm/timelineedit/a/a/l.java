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
import com.google.d.dn;
import com.google.d.h;
import com.google.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends bg
  implements m
{
  private static final cs<l> PARSER;
  private static final l adqA;
  long adqy;
  long adqz;
  private volatile Object efu;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(232263);
    adqA = new l();
    PARSER = new c() {};
    AppMethodBeat.o(232263);
  }
  
  private l()
  {
    this.efu = "";
  }
  
  private l(bg.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private l(com.google.d.i parami, com.google.d.at paramat)
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
    //   28: invokestatic 73	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +159 -> 195
    //   39: aload_1
    //   40: invokevirtual 79	com/google/d/i:aac	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+167->214, 0:+170->217, 10:+59->106, 16:+104->151, 24:+137->184
    //   89: aload_1
    //   90: aload 5
    //   92: aload_2
    //   93: iload 4
    //   95: invokevirtual 83	com/tencent/mm/timelineedit/a/a/l:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
    //   98: ifne -63 -> 35
    //   101: iconst_1
    //   102: istore_3
    //   103: goto -68 -> 35
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 87	com/google/d/i:aaj	()Ljava/lang/String;
    //   111: putfield 51	com/tencent/mm/timelineedit/a/a/l:efu	Ljava/lang/Object;
    //   114: goto -79 -> 35
    //   117: astore_1
    //   118: aload_1
    //   119: aload_0
    //   120: putfield 91	com/google/d/bk:dST	Lcom/google/d/ce;
    //   123: ldc 64
    //   125: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: aload_0
    //   132: aload 5
    //   134: invokevirtual 97	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   137: putfield 101	com/tencent/mm/timelineedit/a/a/l:unknownFields	Lcom/google/d/dn;
    //   140: aload_0
    //   141: invokevirtual 104	com/tencent/mm/timelineedit/a/a/l:makeExtensionsImmutable	()V
    //   144: ldc 64
    //   146: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_1
    //   150: athrow
    //   151: aload_0
    //   152: aload_1
    //   153: invokevirtual 108	com/google/d/i:aae	()J
    //   156: putfield 110	com/tencent/mm/timelineedit/a/a/l:adqy	J
    //   159: goto -124 -> 35
    //   162: astore_1
    //   163: new 61	com/google/d/bk
    //   166: dup
    //   167: aload_1
    //   168: invokespecial 113	com/google/d/bk:<init>	(Ljava/io/IOException;)V
    //   171: astore_1
    //   172: aload_1
    //   173: aload_0
    //   174: putfield 91	com/google/d/bk:dST	Lcom/google/d/ce;
    //   177: ldc 64
    //   179: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_1
    //   183: athrow
    //   184: aload_0
    //   185: aload_1
    //   186: invokevirtual 108	com/google/d/i:aae	()J
    //   189: putfield 115	com/tencent/mm/timelineedit/a/a/l:adqz	J
    //   192: goto -157 -> 35
    //   195: aload_0
    //   196: aload 5
    //   198: invokevirtual 97	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   201: putfield 101	com/tencent/mm/timelineedit/a/a/l:unknownFields	Lcom/google/d/dn;
    //   204: aload_0
    //   205: invokevirtual 104	com/tencent/mm/timelineedit/a/a/l:makeExtensionsImmutable	()V
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
    //   0	222	1	parami	com.google.d.i
    //   0	222	2	paramat	com.google.d.at
    //   34	185	3	i	int
    //   43	51	4	j	int
    //   31	166	5	locala	com.google.d.dn.a
    // Exception table:
    //   from	to	target	type
    //   39	45	117	com/google/d/bk
    //   88	101	117	com/google/d/bk
    //   106	114	117	com/google/d/bk
    //   151	159	117	com/google/d/bk
    //   184	192	117	com/google/d/bk
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
  
  private a jfN()
  {
    AppMethodBeat.i(232179);
    if (this == adqA)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(232179);
      return locala;
    }
    a locala = new a((byte)0).c(this);
    AppMethodBeat.o(232179);
    return locala;
  }
  
  public static l jfO()
  {
    return adqA;
  }
  
  private h jfw()
  {
    AppMethodBeat.i(232171);
    Object localObject = this.efu;
    if ((localObject instanceof String))
    {
      localObject = h.dS((String)localObject);
      this.efu = localObject;
      AppMethodBeat.o(232171);
      return localObject;
    }
    localObject = (h)localObject;
    AppMethodBeat.o(232171);
    return localObject;
  }
  
  public static cs<l> parser()
  {
    return PARSER;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232349);
    if (paramObject == this)
    {
      AppMethodBeat.o(232349);
      return true;
    }
    if (!(paramObject instanceof l))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(232349);
      return bool;
    }
    paramObject = (l)paramObject;
    if (!getPath().equals(paramObject.getPath()))
    {
      AppMethodBeat.o(232349);
      return false;
    }
    if (this.adqy != paramObject.adqy)
    {
      AppMethodBeat.o(232349);
      return false;
    }
    if (this.adqz != paramObject.adqz)
    {
      AppMethodBeat.o(232349);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(232349);
      return false;
    }
    AppMethodBeat.o(232349);
    return true;
  }
  
  public final cs<l> getParserForType()
  {
    return PARSER;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(232301);
    Object localObject = this.efu;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(232301);
      return localObject;
    }
    localObject = ((h)localObject).ZV();
    this.efu = localObject;
    AppMethodBeat.o(232301);
    return localObject;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(232337);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(232337);
      return i;
    }
    int j = 0;
    if (!jfw().isEmpty()) {
      j = bg.computeStringSize(1, this.efu) + 0;
    }
    i = j;
    if (this.adqy != 0L) {
      i = j + k.q(2, this.adqy);
    }
    j = i;
    if (this.adqz != 0L) {
      j = i + k.q(3, this.adqz);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    AppMethodBeat.o(232337);
    return i;
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(232361);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(232361);
      return i;
    }
    int i = (((((((ae.adsr.hashCode() + 779) * 37 + 1) * 53 + getPath().hashCode()) * 37 + 2) * 53 + bj.hashLong(this.adqy)) * 37 + 3) * 53 + bj.hashLong(this.adqz)) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(232361);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(232292);
    bg.e locale = ae.adss.b(l.class, a.class);
    AppMethodBeat.o(232292);
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
  
  public final Object newInstance(bg.f paramf)
  {
    AppMethodBeat.i(232272);
    paramf = new l();
    AppMethodBeat.o(232272);
    return paramf;
  }
  
  public final void writeTo(k paramk)
  {
    AppMethodBeat.i(232323);
    if (!jfw().isEmpty()) {
      bg.writeString(paramk, 1, this.efu);
    }
    if (this.adqy != 0L) {
      paramk.n(2, this.adqy);
    }
    if (this.adqz != 0L) {
      paramk.n(3, this.adqz);
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(232323);
  }
  
  public static final class a
    extends bg.a<a>
    implements m
  {
    private long adqy;
    private long adqz;
    private Object efu;
    
    private a()
    {
      AppMethodBeat.i(232707);
      this.efu = "";
      l.ayB();
      AppMethodBeat.o(232707);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232718);
      this.efu = "";
      l.ayB();
      AppMethodBeat.o(232718);
    }
    
    private a O(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232792);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232792);
      return paramf;
    }
    
    /* Error */
    private a O(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: ldc 57
      //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 61	com/tencent/mm/timelineedit/a/a/l:jfz	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 67 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/l
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 71	com/tencent/mm/timelineedit/a/a/l$a:c	(Lcom/tencent/mm/timelineedit/a/a/l;)Lcom/tencent/mm/timelineedit/a/a/l$a;
      //   30: pop
      //   31: ldc 57
      //   33: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 75	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/l
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 79	com/google/d/bk:aii	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 57
      //   54: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 71	com/tencent/mm/timelineedit/a/a/l$a:c	(Lcom/tencent/mm/timelineedit/a/a/l;)Lcom/tencent/mm/timelineedit/a/a/l$a;
      //   69: pop
      //   70: ldc 57
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
    
    private a P(cb paramcb)
    {
      AppMethodBeat.i(232813);
      if ((paramcb instanceof l))
      {
        paramcb = c((l)paramcb);
        AppMethodBeat.o(232813);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232813);
      return this;
    }
    
    private a S(am.j paramj)
    {
      AppMethodBeat.i(232779);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232779);
      return paramj;
    }
    
    private a W(am.f paramf)
    {
      AppMethodBeat.i(232768);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232768);
      return paramf;
    }
    
    private a aE(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232759);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232759);
      return paramf;
    }
    
    private a aF(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232802);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232802);
      return paramf;
    }
    
    private a aG(dn paramdn)
    {
      AppMethodBeat.i(232862);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(232862);
      return paramdn;
    }
    
    private a aH(dn paramdn)
    {
      AppMethodBeat.i(232873);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(232873);
      return paramdn;
    }
    
    private a jfP()
    {
      AppMethodBeat.i(232726);
      super.clear();
      this.efu = "";
      this.adqy = 0L;
      this.adqz = 0L;
      AppMethodBeat.o(232726);
      return this;
    }
    
    private l jfQ()
    {
      AppMethodBeat.i(232736);
      Object localObject = jfR();
      if (!((l)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232736);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232736);
      return localObject;
    }
    
    private l jfR()
    {
      AppMethodBeat.i(232749);
      l locall = new l(this, (byte)0);
      l.a(locall, this.efu);
      l.a(locall, this.adqy);
      l.b(locall, this.adqz);
      onBuilt();
      AppMethodBeat.o(232749);
      return locall;
    }
    
    private a zq(long paramLong)
    {
      AppMethodBeat.i(232841);
      this.adqy = paramLong;
      onChanged();
      AppMethodBeat.o(232841);
      return this;
    }
    
    private a zr(long paramLong)
    {
      AppMethodBeat.i(232852);
      this.adqz = paramLong;
      onChanged();
      AppMethodBeat.o(232852);
      return this;
    }
    
    public final a c(l paraml)
    {
      AppMethodBeat.i(232922);
      if (paraml == l.jfO())
      {
        AppMethodBeat.o(232922);
        return this;
      }
      if (!paraml.getPath().isEmpty())
      {
        this.efu = l.a(paraml);
        onChanged();
      }
      if (paraml.adqy != 0L) {
        zq(paraml.adqy);
      }
      if (paraml.adqz != 0L) {
        zr(paraml.adqz);
      }
      aH(l.b(paraml));
      onChanged();
      AppMethodBeat.o(232922);
      return this;
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adsr;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(232901);
      bg.e locale = ae.adss.b(l.class, a.class);
      AppMethodBeat.o(232901);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.l
 * JD-Core Version:    0.7.0.1
 */