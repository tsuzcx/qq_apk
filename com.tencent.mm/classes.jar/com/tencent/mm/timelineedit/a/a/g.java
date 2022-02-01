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
import com.google.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends bg
  implements h
{
  private static final cs<g> PARSER;
  private static final g adqm;
  long adql;
  int dLv;
  private volatile Object efu;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(232230);
    adqm = new g();
    PARSER = new c() {};
    AppMethodBeat.o(232230);
  }
  
  private g()
  {
    this.efu = "";
  }
  
  private g(bg.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private g(com.google.d.i parami, com.google.d.at paramat)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 36	com/tencent/mm/timelineedit/a/a/g:<init>	()V
    //   4: ldc 65
    //   6: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +18 -> 28
    //   13: new 67	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   20: astore_1
    //   21: ldc 65
    //   23: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_1
    //   27: athrow
    //   28: invokestatic 74	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +159 -> 195
    //   39: aload_1
    //   40: invokevirtual 80	com/google/d/i:aac	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+167->214, 0:+170->217, 10:+59->106, 16:+104->151, 24:+137->184
    //   89: aload_1
    //   90: aload 5
    //   92: aload_2
    //   93: iload 4
    //   95: invokevirtual 84	com/tencent/mm/timelineedit/a/a/g:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
    //   98: ifne -63 -> 35
    //   101: iconst_1
    //   102: istore_3
    //   103: goto -68 -> 35
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 88	com/google/d/i:aaj	()Ljava/lang/String;
    //   111: putfield 52	com/tencent/mm/timelineedit/a/a/g:efu	Ljava/lang/Object;
    //   114: goto -79 -> 35
    //   117: astore_1
    //   118: aload_1
    //   119: aload_0
    //   120: putfield 92	com/google/d/bk:dST	Lcom/google/d/ce;
    //   123: ldc 65
    //   125: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: aload_0
    //   132: aload 5
    //   134: invokevirtual 98	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   137: putfield 102	com/tencent/mm/timelineedit/a/a/g:unknownFields	Lcom/google/d/dn;
    //   140: aload_0
    //   141: invokevirtual 105	com/tencent/mm/timelineedit/a/a/g:makeExtensionsImmutable	()V
    //   144: ldc 65
    //   146: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_1
    //   150: athrow
    //   151: aload_0
    //   152: aload_1
    //   153: invokevirtual 108	com/google/d/i:aaf	()I
    //   156: putfield 110	com/tencent/mm/timelineedit/a/a/g:dLv	I
    //   159: goto -124 -> 35
    //   162: astore_1
    //   163: new 62	com/google/d/bk
    //   166: dup
    //   167: aload_1
    //   168: invokespecial 113	com/google/d/bk:<init>	(Ljava/io/IOException;)V
    //   171: astore_1
    //   172: aload_1
    //   173: aload_0
    //   174: putfield 92	com/google/d/bk:dST	Lcom/google/d/ce;
    //   177: ldc 65
    //   179: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_1
    //   183: athrow
    //   184: aload_0
    //   185: aload_1
    //   186: invokevirtual 117	com/google/d/i:aae	()J
    //   189: putfield 119	com/tencent/mm/timelineedit/a/a/g:adql	J
    //   192: goto -157 -> 35
    //   195: aload_0
    //   196: aload 5
    //   198: invokevirtual 98	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   201: putfield 102	com/tencent/mm/timelineedit/a/a/g:unknownFields	Lcom/google/d/dn;
    //   204: aload_0
    //   205: invokevirtual 105	com/tencent/mm/timelineedit/a/a/g:makeExtensionsImmutable	()V
    //   208: ldc 65
    //   210: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: return
    //   214: goto -126 -> 88
    //   217: iconst_1
    //   218: istore_3
    //   219: goto -184 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	g
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
  
  private com.google.d.h jfw()
  {
    AppMethodBeat.i(232155);
    Object localObject = this.efu;
    if ((localObject instanceof String))
    {
      localObject = com.google.d.h.dS((String)localObject);
      this.efu = localObject;
      AppMethodBeat.o(232155);
      return localObject;
    }
    localObject = (com.google.d.h)localObject;
    AppMethodBeat.o(232155);
    return localObject;
  }
  
  private a jfx()
  {
    AppMethodBeat.i(232163);
    if (this == adqm)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(232163);
      return locala;
    }
    a locala = new a((byte)0).c(this);
    AppMethodBeat.o(232163);
    return locala;
  }
  
  public static g jfy()
  {
    return adqm;
  }
  
  public static cs<g> parser()
  {
    return PARSER;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232306);
    if (paramObject == this)
    {
      AppMethodBeat.o(232306);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(232306);
      return bool;
    }
    paramObject = (g)paramObject;
    if (!getPath().equals(paramObject.getPath()))
    {
      AppMethodBeat.o(232306);
      return false;
    }
    if (this.dLv != paramObject.dLv)
    {
      AppMethodBeat.o(232306);
      return false;
    }
    if (this.adql != paramObject.adql)
    {
      AppMethodBeat.o(232306);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(232306);
      return false;
    }
    AppMethodBeat.o(232306);
    return true;
  }
  
  public final cs<g> getParserForType()
  {
    return PARSER;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(232262);
    Object localObject = this.efu;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(232262);
      return localObject;
    }
    localObject = ((com.google.d.h)localObject).ZV();
    this.efu = localObject;
    AppMethodBeat.o(232262);
    return localObject;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(232294);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(232294);
      return i;
    }
    int j = 0;
    if (!jfw().isEmpty()) {
      j = bg.computeStringSize(1, this.efu) + 0;
    }
    i = j;
    if (this.dLv != 0) {
      i = j + k.cJ(2, this.dLv);
    }
    j = i;
    if (this.adql != 0L) {
      j = i + k.q(3, this.adql);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    AppMethodBeat.o(232294);
    return i;
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(232319);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(232319);
      return i;
    }
    int i = (((((((ae.adsv.hashCode() + 779) * 37 + 1) * 53 + getPath().hashCode()) * 37 + 2) * 53 + this.dLv) * 37 + 3) * 53 + bj.hashLong(this.adql)) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(232319);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(232253);
    bg.e locale = ae.adsw.b(g.class, a.class);
    AppMethodBeat.o(232253);
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
    AppMethodBeat.i(232236);
    paramf = new g();
    AppMethodBeat.o(232236);
    return paramf;
  }
  
  public final void writeTo(k paramk)
  {
    AppMethodBeat.i(232282);
    if (!jfw().isEmpty()) {
      bg.writeString(paramk, 1, this.efu);
    }
    if (this.dLv != 0) {
      paramk.cF(2, this.dLv);
    }
    if (this.adql != 0L) {
      paramk.n(3, this.adql);
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(232282);
  }
  
  public static final class a
    extends bg.a<a>
    implements h
  {
    private long adql;
    private int dLv;
    private Object efu;
    
    private a()
    {
      AppMethodBeat.i(232217);
      this.efu = "";
      g.ayB();
      AppMethodBeat.o(232217);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232226);
      this.efu = "";
      g.ayB();
      AppMethodBeat.o(232226);
    }
    
    private a M(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232287);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232287);
      return paramf;
    }
    
    /* Error */
    private a M(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: ldc 58
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 62	com/tencent/mm/timelineedit/a/a/g:jfz	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 68 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/g
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 72	com/tencent/mm/timelineedit/a/a/g$a:c	(Lcom/tencent/mm/timelineedit/a/a/g;)Lcom/tencent/mm/timelineedit/a/a/g$a;
      //   30: pop
      //   31: ldc 58
      //   33: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 76	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/g
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 80	com/google/d/bk:aii	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 58
      //   54: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 72	com/tencent/mm/timelineedit/a/a/g$a:c	(Lcom/tencent/mm/timelineedit/a/a/g;)Lcom/tencent/mm/timelineedit/a/a/g$a;
      //   69: pop
      //   70: ldc 58
      //   72: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private a N(cb paramcb)
    {
      AppMethodBeat.i(232308);
      if ((paramcb instanceof g))
      {
        paramcb = c((g)paramcb);
        AppMethodBeat.o(232308);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232308);
      return this;
    }
    
    private a Q(am.j paramj)
    {
      AppMethodBeat.i(232280);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232280);
      return paramj;
    }
    
    private a U(am.f paramf)
    {
      AppMethodBeat.i(232269);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232269);
      return paramf;
    }
    
    private a aA(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232259);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232259);
      return paramf;
    }
    
    private a aB(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232297);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232297);
      return paramf;
    }
    
    private a aC(dn paramdn)
    {
      AppMethodBeat.i(232353);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(232353);
      return paramdn;
    }
    
    private a aD(dn paramdn)
    {
      AppMethodBeat.i(232363);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(232363);
      return paramdn;
    }
    
    private a azy(int paramInt)
    {
      AppMethodBeat.i(232332);
      this.dLv = paramInt;
      onChanged();
      AppMethodBeat.o(232332);
      return this;
    }
    
    private a jfA()
    {
      AppMethodBeat.i(232233);
      super.clear();
      this.efu = "";
      this.dLv = 0;
      this.adql = 0L;
      AppMethodBeat.o(232233);
      return this;
    }
    
    private g jfB()
    {
      AppMethodBeat.i(232242);
      Object localObject = jfC();
      if (!((g)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232242);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232242);
      return localObject;
    }
    
    private g jfC()
    {
      AppMethodBeat.i(232250);
      g localg = new g(this, (byte)0);
      g.a(localg, this.efu);
      g.a(localg, this.dLv);
      g.a(localg, this.adql);
      onBuilt();
      AppMethodBeat.o(232250);
      return localg;
    }
    
    private a zp(long paramLong)
    {
      AppMethodBeat.i(232341);
      this.adql = paramLong;
      onChanged();
      AppMethodBeat.o(232341);
      return this;
    }
    
    public final a c(g paramg)
    {
      AppMethodBeat.i(232401);
      if (paramg == g.jfy())
      {
        AppMethodBeat.o(232401);
        return this;
      }
      if (!paramg.getPath().isEmpty())
      {
        this.efu = g.a(paramg);
        onChanged();
      }
      if (paramg.dLv != 0) {
        azy(paramg.dLv);
      }
      if (paramg.adql != 0L) {
        zp(paramg.adql);
      }
      aD(g.b(paramg));
      onChanged();
      AppMethodBeat.o(232401);
      return this;
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adsv;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(232388);
      bg.e locale = ae.adsw.b(g.class, a.class);
      AppMethodBeat.o(232388);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.g
 * JD-Core Version:    0.7.0.1
 */