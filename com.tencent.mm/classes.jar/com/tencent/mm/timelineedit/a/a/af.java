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

public final class af
  extends bg
  implements ag
{
  private static final cs<af> PARSER;
  private static final af adsG;
  long adrP;
  private volatile Object adsD;
  private volatile Object adsE;
  boolean adsF;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(232699);
    adsG = new af();
    PARSER = new c() {};
    AppMethodBeat.o(232699);
  }
  
  private af()
  {
    this.adsD = "";
    this.adsE = "";
  }
  
  private af(bg.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private af(com.google.d.i parami, com.google.d.at paramat)
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
    //   28: invokestatic 77	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +178 -> 214
    //   39: aload_1
    //   40: invokevirtual 83	com/google/d/i:aac	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+186->233, 0:+189->236, 10:+67->114, 18:+112->159, 24:+145->192, 32:+156->203
    //   97: aload_1
    //   98: aload 5
    //   100: aload_2
    //   101: iload 4
    //   103: invokevirtual 87	com/tencent/mm/timelineedit/a/a/af:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
    //   106: ifne -71 -> 35
    //   109: iconst_1
    //   110: istore_3
    //   111: goto -76 -> 35
    //   114: aload_0
    //   115: aload_1
    //   116: invokevirtual 91	com/google/d/i:aaj	()Ljava/lang/String;
    //   119: putfield 53	com/tencent/mm/timelineedit/a/a/af:adsD	Ljava/lang/Object;
    //   122: goto -87 -> 35
    //   125: astore_1
    //   126: aload_1
    //   127: aload_0
    //   128: putfield 95	com/google/d/bk:dST	Lcom/google/d/ce;
    //   131: ldc 68
    //   133: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: aload_0
    //   140: aload 5
    //   142: invokevirtual 101	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   145: putfield 105	com/tencent/mm/timelineedit/a/a/af:unknownFields	Lcom/google/d/dn;
    //   148: aload_0
    //   149: invokevirtual 108	com/tencent/mm/timelineedit/a/a/af:makeExtensionsImmutable	()V
    //   152: ldc 68
    //   154: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload_1
    //   158: athrow
    //   159: aload_0
    //   160: aload_1
    //   161: invokevirtual 91	com/google/d/i:aaj	()Ljava/lang/String;
    //   164: putfield 55	com/tencent/mm/timelineedit/a/a/af:adsE	Ljava/lang/Object;
    //   167: goto -132 -> 35
    //   170: astore_1
    //   171: new 65	com/google/d/bk
    //   174: dup
    //   175: aload_1
    //   176: invokespecial 111	com/google/d/bk:<init>	(Ljava/io/IOException;)V
    //   179: astore_1
    //   180: aload_1
    //   181: aload_0
    //   182: putfield 95	com/google/d/bk:dST	Lcom/google/d/ce;
    //   185: ldc 68
    //   187: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_1
    //   191: athrow
    //   192: aload_0
    //   193: aload_1
    //   194: invokevirtual 115	com/google/d/i:aae	()J
    //   197: putfield 117	com/tencent/mm/timelineedit/a/a/af:adrP	J
    //   200: goto -165 -> 35
    //   203: aload_0
    //   204: aload_1
    //   205: invokevirtual 121	com/google/d/i:aai	()Z
    //   208: putfield 123	com/tencent/mm/timelineedit/a/a/af:adsF	Z
    //   211: goto -176 -> 35
    //   214: aload_0
    //   215: aload 5
    //   217: invokevirtual 101	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   220: putfield 105	com/tencent/mm/timelineedit/a/a/af:unknownFields	Lcom/google/d/dn;
    //   223: aload_0
    //   224: invokevirtual 108	com/tencent/mm/timelineedit/a/a/af:makeExtensionsImmutable	()V
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
    //   0	241	1	parami	com.google.d.i
    //   0	241	2	paramat	com.google.d.at
    //   34	204	3	i	int
    //   43	59	4	j	int
    //   31	185	5	locala	com.google.d.dn.a
    // Exception table:
    //   from	to	target	type
    //   39	45	125	com/google/d/bk
    //   96	109	125	com/google/d/bk
    //   114	122	125	com/google/d/bk
    //   159	167	125	com/google/d/bk
    //   192	200	125	com/google/d/bk
    //   203	211	125	com/google/d/bk
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
    AppMethodBeat.i(232371);
    paramaf = adsG.jgX().f(paramaf);
    AppMethodBeat.o(232371);
    return paramaf;
  }
  
  private h jgU()
  {
    AppMethodBeat.i(232333);
    Object localObject = this.adsD;
    if ((localObject instanceof String))
    {
      localObject = h.dS((String)localObject);
      this.adsD = localObject;
      AppMethodBeat.o(232333);
      return localObject;
    }
    localObject = (h)localObject;
    AppMethodBeat.o(232333);
    return localObject;
  }
  
  private h jgW()
  {
    AppMethodBeat.i(232351);
    Object localObject = this.adsE;
    if ((localObject instanceof String))
    {
      localObject = h.dS((String)localObject);
      this.adsE = localObject;
      AppMethodBeat.o(232351);
      return localObject;
    }
    localObject = (h)localObject;
    AppMethodBeat.o(232351);
    return localObject;
  }
  
  public static af jgY()
  {
    return adsG;
  }
  
  public static cs<af> parser()
  {
    return PARSER;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232868);
    if (paramObject == this)
    {
      AppMethodBeat.o(232868);
      return true;
    }
    if (!(paramObject instanceof af))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(232868);
      return bool;
    }
    paramObject = (af)paramObject;
    if (!jgT().equals(paramObject.jgT()))
    {
      AppMethodBeat.o(232868);
      return false;
    }
    if (!jgV().equals(paramObject.jgV()))
    {
      AppMethodBeat.o(232868);
      return false;
    }
    if (this.adrP != paramObject.adrP)
    {
      AppMethodBeat.o(232868);
      return false;
    }
    if (this.adsF != paramObject.adsF)
    {
      AppMethodBeat.o(232868);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(232868);
      return false;
    }
    AppMethodBeat.o(232868);
    return true;
  }
  
  public final cs<af> getParserForType()
  {
    return PARSER;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(232845);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(232845);
      return i;
    }
    int j = 0;
    if (!jgU().isEmpty()) {
      j = bg.computeStringSize(1, this.adsD) + 0;
    }
    i = j;
    if (!jgW().isEmpty()) {
      i = j + bg.computeStringSize(2, this.adsE);
    }
    j = i;
    if (this.adrP != 0L) {
      j = i + k.q(3, this.adrP);
    }
    i = j;
    if (this.adsF) {
      i = j + k.kn(4);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    AppMethodBeat.o(232845);
    return i;
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(232889);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(232889);
      return i;
    }
    int i = (((((((((ae.adst.hashCode() + 779) * 37 + 1) * 53 + jgT().hashCode()) * 37 + 2) * 53 + jgV().hashCode()) * 37 + 3) * 53 + bj.hashLong(this.adrP)) * 37 + 4) * 53 + bj.hashBoolean(this.adsF)) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(232889);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(232748);
    bg.e locale = ae.adsu.b(af.class, a.class);
    AppMethodBeat.o(232748);
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
  
  public final String jgT()
  {
    AppMethodBeat.i(232762);
    Object localObject = this.adsD;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(232762);
      return localObject;
    }
    localObject = ((h)localObject).ZV();
    this.adsD = localObject;
    AppMethodBeat.o(232762);
    return localObject;
  }
  
  public final String jgV()
  {
    AppMethodBeat.i(232781);
    Object localObject = this.adsE;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(232781);
      return localObject;
    }
    localObject = ((h)localObject).ZV();
    this.adsE = localObject;
    AppMethodBeat.o(232781);
    return localObject;
  }
  
  public final a jgX()
  {
    AppMethodBeat.i(232906);
    if (this == adsG)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(232906);
      return locala;
    }
    a locala = new a((byte)0).f(this);
    AppMethodBeat.o(232906);
    return locala;
  }
  
  public final Object newInstance(bg.f paramf)
  {
    AppMethodBeat.i(232713);
    paramf = new af();
    AppMethodBeat.o(232713);
    return paramf;
  }
  
  public final void writeTo(k paramk)
  {
    AppMethodBeat.i(232824);
    if (!jgU().isEmpty()) {
      bg.writeString(paramk, 1, this.adsD);
    }
    if (!jgW().isEmpty()) {
      bg.writeString(paramk, 2, this.adsE);
    }
    if (this.adrP != 0L) {
      paramk.n(3, this.adrP);
    }
    if (this.adsF) {
      paramk.I(4, this.adsF);
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(232824);
  }
  
  public static final class a
    extends bg.a<a>
    implements ag
  {
    private long adrP;
    private Object adsD;
    private Object adsE;
    private boolean adsF;
    
    private a()
    {
      AppMethodBeat.i(232457);
      this.adsD = "";
      this.adsE = "";
      af.ayB();
      AppMethodBeat.o(232457);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232467);
      this.adsD = "";
      this.adsE = "";
      af.ayB();
      AppMethodBeat.o(232467);
    }
    
    private a KO(boolean paramBoolean)
    {
      AppMethodBeat.i(232543);
      this.adsF = paramBoolean;
      onChanged();
      AppMethodBeat.o(232543);
      return this;
    }
    
    private a W(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232509);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232509);
      return paramf;
    }
    
    /* Error */
    private a W(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: ldc 69
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 73	com/tencent/mm/timelineedit/a/a/af:jfV	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 79 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/af
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 83	com/tencent/mm/timelineedit/a/a/af$a:f	(Lcom/tencent/mm/timelineedit/a/a/af;)Lcom/tencent/mm/timelineedit/a/a/af$a;
      //   30: pop
      //   31: ldc 69
      //   33: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 87	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/af
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 91	com/google/d/bk:aii	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 69
      //   54: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 83	com/tencent/mm/timelineedit/a/a/af$a:f	(Lcom/tencent/mm/timelineedit/a/a/af;)Lcom/tencent/mm/timelineedit/a/a/af$a;
      //   69: pop
      //   70: ldc 69
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
    
    private a X(cb paramcb)
    {
      AppMethodBeat.i(232522);
      if ((paramcb instanceof af))
      {
        paramcb = f((af)paramcb);
        AppMethodBeat.o(232522);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232522);
      return this;
    }
    
    private a aU(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232488);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232488);
      return paramf;
    }
    
    private a aV(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232515);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232515);
      return paramf;
    }
    
    private a aW(dn paramdn)
    {
      AppMethodBeat.i(232550);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(232550);
      return paramdn;
    }
    
    private a aX(dn paramdn)
    {
      AppMethodBeat.i(232559);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(232559);
      return paramdn;
    }
    
    private a aa(am.j paramj)
    {
      AppMethodBeat.i(232503);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232503);
      return paramj;
    }
    
    private a ae(am.f paramf)
    {
      AppMethodBeat.i(232496);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232496);
      return paramf;
    }
    
    private a jgZ()
    {
      AppMethodBeat.i(232474);
      super.clear();
      this.adsD = "";
      this.adsE = "";
      this.adrP = 0L;
      this.adsF = false;
      AppMethodBeat.o(232474);
      return this;
    }
    
    private af jha()
    {
      AppMethodBeat.i(232482);
      Object localObject = jhb();
      if (!((af)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232482);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232482);
      return localObject;
    }
    
    private a zC(long paramLong)
    {
      AppMethodBeat.i(232537);
      this.adrP = paramLong;
      onChanged();
      AppMethodBeat.o(232537);
      return this;
    }
    
    public final a f(af paramaf)
    {
      AppMethodBeat.i(232597);
      if (paramaf == af.jgY())
      {
        AppMethodBeat.o(232597);
        return this;
      }
      if (!paramaf.jgT().isEmpty())
      {
        this.adsD = af.c(paramaf);
        onChanged();
      }
      if (!paramaf.jgV().isEmpty())
      {
        this.adsE = af.d(paramaf);
        onChanged();
      }
      if (paramaf.adrP != 0L) {
        zC(paramaf.adrP);
      }
      if (paramaf.adsF) {
        KO(paramaf.adsF);
      }
      aX(af.e(paramaf));
      onChanged();
      AppMethodBeat.o(232597);
      return this;
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adst;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(232577);
      bg.e locale = ae.adsu.b(af.class, a.class);
      AppMethodBeat.o(232577);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public final af jhb()
    {
      AppMethodBeat.i(232590);
      af localaf = new af(this, (byte)0);
      af.a(localaf, this.adsD);
      af.b(localaf, this.adsE);
      af.a(localaf, this.adrP);
      af.a(localaf, this.adsF);
      onBuilt();
      AppMethodBeat.o(232590);
      return localaf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.af
 * JD-Core Version:    0.7.0.1
 */