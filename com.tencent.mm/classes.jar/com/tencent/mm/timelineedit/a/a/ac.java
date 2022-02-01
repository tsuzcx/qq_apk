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

public final class ac
  extends bg
  implements ad
{
  private static final cs<ac> PARSER;
  private static final ac adrQ;
  long adrO;
  long adrP;
  private volatile Object efu;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(232744);
    adrQ = new ac();
    PARSER = new c() {};
    AppMethodBeat.o(232744);
  }
  
  private ac()
  {
    this.efu = "";
  }
  
  private ac(bg.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private ac(com.google.d.i parami, com.google.d.at paramat)
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
    //   95: invokevirtual 83	com/tencent/mm/timelineedit/a/a/ac:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
    //   98: ifne -63 -> 35
    //   101: iconst_1
    //   102: istore_3
    //   103: goto -68 -> 35
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 87	com/google/d/i:aaj	()Ljava/lang/String;
    //   111: putfield 51	com/tencent/mm/timelineedit/a/a/ac:efu	Ljava/lang/Object;
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
    //   137: putfield 101	com/tencent/mm/timelineedit/a/a/ac:unknownFields	Lcom/google/d/dn;
    //   140: aload_0
    //   141: invokevirtual 104	com/tencent/mm/timelineedit/a/a/ac:makeExtensionsImmutable	()V
    //   144: ldc 64
    //   146: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_1
    //   150: athrow
    //   151: aload_0
    //   152: aload_1
    //   153: invokevirtual 108	com/google/d/i:aae	()J
    //   156: putfield 110	com/tencent/mm/timelineedit/a/a/ac:adrO	J
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
    //   189: putfield 115	com/tencent/mm/timelineedit/a/a/ac:adrP	J
    //   192: goto -157 -> 35
    //   195: aload_0
    //   196: aload 5
    //   198: invokevirtual 97	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   201: putfield 101	com/tencent/mm/timelineedit/a/a/ac:unknownFields	Lcom/google/d/dn;
    //   204: aload_0
    //   205: invokevirtual 104	com/tencent/mm/timelineedit/a/a/ac:makeExtensionsImmutable	()V
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
  
  public static a b(ac paramac)
  {
    AppMethodBeat.i(232428);
    paramac = adrQ.jgO().e(paramac);
    AppMethodBeat.o(232428);
    return paramac;
  }
  
  private h jfw()
  {
    AppMethodBeat.i(232419);
    Object localObject = this.efu;
    if ((localObject instanceof String))
    {
      localObject = h.dS((String)localObject);
      this.efu = localObject;
      AppMethodBeat.o(232419);
      return localObject;
    }
    localObject = (h)localObject;
    AppMethodBeat.o(232419);
    return localObject;
  }
  
  public static ac jgP()
  {
    return adrQ;
  }
  
  public static cs<ac> parser()
  {
    return PARSER;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232849);
    if (paramObject == this)
    {
      AppMethodBeat.o(232849);
      return true;
    }
    if (!(paramObject instanceof ac))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(232849);
      return bool;
    }
    paramObject = (ac)paramObject;
    if (!getPath().equals(paramObject.getPath()))
    {
      AppMethodBeat.o(232849);
      return false;
    }
    if (this.adrO != paramObject.adrO)
    {
      AppMethodBeat.o(232849);
      return false;
    }
    if (this.adrP != paramObject.adrP)
    {
      AppMethodBeat.o(232849);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(232849);
      return false;
    }
    AppMethodBeat.o(232849);
    return true;
  }
  
  public final long getDuration()
  {
    return this.adrP;
  }
  
  public final cs<ac> getParserForType()
  {
    return PARSER;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(232789);
    Object localObject = this.efu;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(232789);
      return localObject;
    }
    localObject = ((h)localObject).ZV();
    this.efu = localObject;
    AppMethodBeat.o(232789);
    return localObject;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(232834);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(232834);
      return i;
    }
    int j = 0;
    if (!jfw().isEmpty()) {
      j = bg.computeStringSize(1, this.efu) + 0;
    }
    i = j;
    if (this.adrO != 0L) {
      i = j + k.q(2, this.adrO);
    }
    j = i;
    if (this.adrP != 0L) {
      j = i + k.q(3, this.adrP);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    AppMethodBeat.o(232834);
    return i;
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(232863);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(232863);
      return i;
    }
    int i = (((((((ae.adsb.hashCode() + 779) * 37 + 1) * 53 + getPath().hashCode()) * 37 + 2) * 53 + bj.hashLong(this.adrO)) * 37 + 3) * 53 + bj.hashLong(this.adrP)) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(232863);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(232773);
    bg.e locale = ae.adsc.b(ac.class, a.class);
    AppMethodBeat.o(232773);
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
  
  public final a jgO()
  {
    AppMethodBeat.i(232876);
    if (this == adrQ)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(232876);
      return locala;
    }
    a locala = new a((byte)0).e(this);
    AppMethodBeat.o(232876);
    return locala;
  }
  
  public final Object newInstance(bg.f paramf)
  {
    AppMethodBeat.i(232755);
    paramf = new ac();
    AppMethodBeat.o(232755);
    return paramf;
  }
  
  public final void writeTo(k paramk)
  {
    AppMethodBeat.i(232825);
    if (!jfw().isEmpty()) {
      bg.writeString(paramk, 1, this.efu);
    }
    if (this.adrO != 0L) {
      paramk.n(2, this.adrO);
    }
    if (this.adrP != 0L) {
      paramk.n(3, this.adrP);
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(232825);
  }
  
  public static final class a
    extends bg.a<a>
    implements ad
  {
    private long adrO;
    private long adrP;
    private Object efu;
    
    private a()
    {
      AppMethodBeat.i(232720);
      this.efu = "";
      ac.ayB();
      AppMethodBeat.o(232720);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232729);
      this.efu = "";
      ac.ayB();
      AppMethodBeat.o(232729);
    }
    
    private a V(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232808);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232808);
      return paramf;
    }
    
    /* Error */
    private a V(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: ldc 57
      //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 61	com/tencent/mm/timelineedit/a/a/ac:jfz	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 67 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/ac
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 71	com/tencent/mm/timelineedit/a/a/ac$a:e	(Lcom/tencent/mm/timelineedit/a/a/ac;)Lcom/tencent/mm/timelineedit/a/a/ac$a;
      //   30: pop
      //   31: ldc 57
      //   33: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 75	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/ac
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
      //   66: invokevirtual 71	com/tencent/mm/timelineedit/a/a/ac$a:e	(Lcom/tencent/mm/timelineedit/a/a/ac;)Lcom/tencent/mm/timelineedit/a/a/ac$a;
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
    
    private a W(cb paramcb)
    {
      AppMethodBeat.i(232830);
      if ((paramcb instanceof ac))
      {
        paramcb = e((ac)paramcb);
        AppMethodBeat.o(232830);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232830);
      return this;
    }
    
    private a Z(am.j paramj)
    {
      AppMethodBeat.i(232795);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232795);
      return paramj;
    }
    
    private a aS(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232770);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232770);
      return paramf;
    }
    
    private a aT(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232819);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232819);
      return paramf;
    }
    
    private a aU(dn paramdn)
    {
      AppMethodBeat.i(232880);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(232880);
      return paramdn;
    }
    
    private a aV(dn paramdn)
    {
      AppMethodBeat.i(232887);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(232887);
      return paramdn;
    }
    
    private a ad(am.f paramf)
    {
      AppMethodBeat.i(232784);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232784);
      return paramf;
    }
    
    private a jgQ()
    {
      AppMethodBeat.i(232738);
      super.clear();
      this.efu = "";
      this.adrO = 0L;
      this.adrP = 0L;
      AppMethodBeat.o(232738);
      return this;
    }
    
    private ac jgR()
    {
      AppMethodBeat.i(232760);
      Object localObject = jgS();
      if (!((ac)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232760);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232760);
      return localObject;
    }
    
    private a zA(long paramLong)
    {
      AppMethodBeat.i(232856);
      this.adrO = paramLong;
      onChanged();
      AppMethodBeat.o(232856);
      return this;
    }
    
    private a zB(long paramLong)
    {
      AppMethodBeat.i(232869);
      this.adrP = paramLong;
      onChanged();
      AppMethodBeat.o(232869);
      return this;
    }
    
    public final a e(ac paramac)
    {
      AppMethodBeat.i(232954);
      if (paramac == ac.jgP())
      {
        AppMethodBeat.o(232954);
        return this;
      }
      if (!paramac.getPath().isEmpty())
      {
        this.efu = ac.c(paramac);
        onChanged();
      }
      if (paramac.adrO != 0L) {
        zA(paramac.adrO);
      }
      if (paramac.adrP != 0L) {
        zB(paramac.adrP);
      }
      aV(ac.d(paramac));
      onChanged();
      AppMethodBeat.o(232954);
      return this;
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adsb;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(232917);
      bg.e locale = ae.adsc.b(ac.class, a.class);
      AppMethodBeat.o(232917);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public final ac jgS()
    {
      AppMethodBeat.i(232933);
      ac localac = new ac(this, (byte)0);
      ac.a(localac, this.efu);
      ac.a(localac, this.adrO);
      ac.b(localac, this.adrP);
      onBuilt();
      AppMethodBeat.o(232933);
      return localac;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.ac
 * JD-Core Version:    0.7.0.1
 */