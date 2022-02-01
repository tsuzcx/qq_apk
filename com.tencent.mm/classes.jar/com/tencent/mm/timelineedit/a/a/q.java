package com.tencent.mm.timelineedit.a.a;

import com.google.d.am.a;
import com.google.d.am.f;
import com.google.d.am.j;
import com.google.d.bg;
import com.google.d.bg.a;
import com.google.d.bg.b;
import com.google.d.bg.e;
import com.google.d.bg.f;
import com.google.d.c;
import com.google.d.cb;
import com.google.d.cs;
import com.google.d.dn;
import com.google.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends bg
  implements r
{
  private static final cs<q> PARSER;
  private static final q adqZ;
  int adqV;
  int adqW;
  int adqX;
  int adqY;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(232200);
    adqZ = new q();
    PARSER = new c() {};
    AppMethodBeat.o(232200);
  }
  
  private q() {}
  
  private q(bg.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private q(com.google.d.i parami, com.google.d.at paramat)
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
    //   28: invokestatic 69	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +178 -> 214
    //   39: aload_1
    //   40: invokevirtual 75	com/google/d/i:aac	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+186->233, 0:+189->236, 8:+67->114, 16:+112->159, 24:+145->192, 32:+156->203
    //   97: aload_1
    //   98: aload 5
    //   100: aload_2
    //   101: iload 4
    //   103: invokevirtual 79	com/tencent/mm/timelineedit/a/a/q:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
    //   106: ifne -71 -> 35
    //   109: iconst_1
    //   110: istore_3
    //   111: goto -76 -> 35
    //   114: aload_0
    //   115: aload_1
    //   116: invokevirtual 82	com/google/d/i:aaf	()I
    //   119: putfield 84	com/tencent/mm/timelineedit/a/a/q:adqV	I
    //   122: goto -87 -> 35
    //   125: astore_1
    //   126: aload_1
    //   127: aload_0
    //   128: putfield 88	com/google/d/bk:dST	Lcom/google/d/ce;
    //   131: ldc 60
    //   133: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: aload_0
    //   140: aload 5
    //   142: invokevirtual 94	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   145: putfield 98	com/tencent/mm/timelineedit/a/a/q:unknownFields	Lcom/google/d/dn;
    //   148: aload_0
    //   149: invokevirtual 101	com/tencent/mm/timelineedit/a/a/q:makeExtensionsImmutable	()V
    //   152: ldc 60
    //   154: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload_1
    //   158: athrow
    //   159: aload_0
    //   160: aload_1
    //   161: invokevirtual 82	com/google/d/i:aaf	()I
    //   164: putfield 103	com/tencent/mm/timelineedit/a/a/q:adqW	I
    //   167: goto -132 -> 35
    //   170: astore_1
    //   171: new 57	com/google/d/bk
    //   174: dup
    //   175: aload_1
    //   176: invokespecial 106	com/google/d/bk:<init>	(Ljava/io/IOException;)V
    //   179: astore_1
    //   180: aload_1
    //   181: aload_0
    //   182: putfield 88	com/google/d/bk:dST	Lcom/google/d/ce;
    //   185: ldc 60
    //   187: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_1
    //   191: athrow
    //   192: aload_0
    //   193: aload_1
    //   194: invokevirtual 82	com/google/d/i:aaf	()I
    //   197: putfield 108	com/tencent/mm/timelineedit/a/a/q:adqX	I
    //   200: goto -165 -> 35
    //   203: aload_0
    //   204: aload_1
    //   205: invokevirtual 82	com/google/d/i:aaf	()I
    //   208: putfield 110	com/tencent/mm/timelineedit/a/a/q:adqY	I
    //   211: goto -176 -> 35
    //   214: aload_0
    //   215: aload 5
    //   217: invokevirtual 94	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   220: putfield 98	com/tencent/mm/timelineedit/a/a/q:unknownFields	Lcom/google/d/dn;
    //   223: aload_0
    //   224: invokevirtual 101	com/tencent/mm/timelineedit/a/a/q:makeExtensionsImmutable	()V
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
  
  public static a j(q paramq)
  {
    AppMethodBeat.i(232139);
    paramq = adqZ.jfT().l(paramq);
    AppMethodBeat.o(232139);
    return paramq;
  }
  
  public static a jfS()
  {
    AppMethodBeat.i(232133);
    a locala = adqZ.jfT();
    AppMethodBeat.o(232133);
    return locala;
  }
  
  public static q jfU()
  {
    return adqZ;
  }
  
  public static cs<q> parser()
  {
    return PARSER;
  }
  
  public final int CP()
  {
    return this.adqX;
  }
  
  public final int CQ()
  {
    return this.adqY;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232304);
    if (paramObject == this)
    {
      AppMethodBeat.o(232304);
      return true;
    }
    if (!(paramObject instanceof q))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(232304);
      return bool;
    }
    paramObject = (q)paramObject;
    if (this.adqV != paramObject.adqV)
    {
      AppMethodBeat.o(232304);
      return false;
    }
    if (this.adqW != paramObject.adqW)
    {
      AppMethodBeat.o(232304);
      return false;
    }
    if (this.adqX != paramObject.adqX)
    {
      AppMethodBeat.o(232304);
      return false;
    }
    if (this.adqY != paramObject.adqY)
    {
      AppMethodBeat.o(232304);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(232304);
      return false;
    }
    AppMethodBeat.o(232304);
    return true;
  }
  
  public final cs<q> getParserForType()
  {
    return PARSER;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(232290);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(232290);
      return i;
    }
    int j = 0;
    if (this.adqV != 0) {
      j = k.cJ(1, this.adqV) + 0;
    }
    i = j;
    if (this.adqW != 0) {
      i = j + k.cJ(2, this.adqW);
    }
    j = i;
    if (this.adqX != 0) {
      j = i + k.cJ(3, this.adqX);
    }
    i = j;
    if (this.adqY != 0) {
      i = j + k.cJ(4, this.adqY);
    }
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    AppMethodBeat.o(232290);
    return i;
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(232316);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(232316);
      return i;
    }
    int i = (((((((((ae.adrT.hashCode() + 779) * 37 + 1) * 53 + this.adqV) * 37 + 2) * 53 + this.adqW) * 37 + 3) * 53 + this.adqX) * 37 + 4) * 53 + this.adqY) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(232316);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(232220);
    bg.e locale = ae.adrU.b(q.class, a.class);
    AppMethodBeat.o(232220);
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
  
  public final a jfT()
  {
    AppMethodBeat.i(232328);
    if (this == adqZ)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(232328);
      return locala;
    }
    a locala = new a((byte)0).l(this);
    AppMethodBeat.o(232328);
    return locala;
  }
  
  public final Object newInstance(bg.f paramf)
  {
    AppMethodBeat.i(232207);
    paramf = new q();
    AppMethodBeat.o(232207);
    return paramf;
  }
  
  public final void writeTo(k paramk)
  {
    AppMethodBeat.i(232277);
    if (this.adqV != 0) {
      paramk.cF(1, this.adqV);
    }
    if (this.adqW != 0) {
      paramk.cF(2, this.adqW);
    }
    if (this.adqX != 0) {
      paramk.cF(3, this.adqX);
    }
    if (this.adqY != 0) {
      paramk.cF(4, this.adqY);
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(232277);
  }
  
  public final int yY()
  {
    return this.adqV;
  }
  
  public final int yZ()
  {
    return this.adqW;
  }
  
  public static final class a
    extends bg.a<a>
    implements r
  {
    private int adqV;
    private int adqW;
    private int adqX;
    private int adqY;
    
    private a()
    {
      AppMethodBeat.i(232077);
      q.ayB();
      AppMethodBeat.o(232077);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232084);
      q.ayB();
      AppMethodBeat.o(232084);
    }
    
    private a P(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232113);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232113);
      return paramf;
    }
    
    /* Error */
    private a P(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: ldc 53
      //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 57	com/tencent/mm/timelineedit/a/a/q:jfV	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 63 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/q
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 67	com/tencent/mm/timelineedit/a/a/q$a:l	(Lcom/tencent/mm/timelineedit/a/a/q;)Lcom/tencent/mm/timelineedit/a/a/q$a;
      //   30: pop
      //   31: ldc 53
      //   33: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 71	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/q
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 75	com/google/d/bk:aii	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 53
      //   54: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 67	com/tencent/mm/timelineedit/a/a/q$a:l	(Lcom/tencent/mm/timelineedit/a/a/q;)Lcom/tencent/mm/timelineedit/a/a/q$a;
      //   69: pop
      //   70: ldc 53
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
    
    private a Q(cb paramcb)
    {
      AppMethodBeat.i(232122);
      if ((paramcb instanceof q))
      {
        paramcb = l((q)paramcb);
        AppMethodBeat.o(232122);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232122);
      return this;
    }
    
    private a T(am.j paramj)
    {
      AppMethodBeat.i(232105);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232105);
      return paramj;
    }
    
    private a X(am.f paramf)
    {
      AppMethodBeat.i(232097);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232097);
      return paramf;
    }
    
    private a aG(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232094);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232094);
      return paramf;
    }
    
    private a aH(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232117);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232117);
      return paramf;
    }
    
    private a aI(dn paramdn)
    {
      AppMethodBeat.i(232137);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(232137);
      return paramdn;
    }
    
    private a aJ(dn paramdn)
    {
      AppMethodBeat.i(232142);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(232142);
      return paramdn;
    }
    
    private a jfW()
    {
      AppMethodBeat.i(232091);
      super.clear();
      this.adqV = 0;
      this.adqW = 0;
      this.adqX = 0;
      this.adqY = 0;
      AppMethodBeat.o(232091);
      return this;
    }
    
    public final a azB(int paramInt)
    {
      AppMethodBeat.i(232190);
      this.adqV = paramInt;
      onChanged();
      AppMethodBeat.o(232190);
      return this;
    }
    
    public final a azC(int paramInt)
    {
      AppMethodBeat.i(232194);
      this.adqW = paramInt;
      onChanged();
      AppMethodBeat.o(232194);
      return this;
    }
    
    public final a azD(int paramInt)
    {
      AppMethodBeat.i(232199);
      this.adqX = paramInt;
      onChanged();
      AppMethodBeat.o(232199);
      return this;
    }
    
    public final a azE(int paramInt)
    {
      AppMethodBeat.i(232204);
      this.adqY = paramInt;
      onChanged();
      AppMethodBeat.o(232204);
      return this;
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adrT;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(232156);
      bg.e locale = ae.adrU.b(q.class, a.class);
      AppMethodBeat.o(232156);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public final q jfX()
    {
      AppMethodBeat.i(232168);
      Object localObject = jfY();
      if (!((q)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232168);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232168);
      return localObject;
    }
    
    public final q jfY()
    {
      AppMethodBeat.i(232174);
      q localq = new q(this, (byte)0);
      q.a(localq, this.adqV);
      q.b(localq, this.adqW);
      q.c(localq, this.adqX);
      q.d(localq, this.adqY);
      onBuilt();
      AppMethodBeat.o(232174);
      return localq;
    }
    
    public final a l(q paramq)
    {
      AppMethodBeat.i(232183);
      if (paramq == q.jfU())
      {
        AppMethodBeat.o(232183);
        return this;
      }
      if (paramq.adqV != 0) {
        azB(paramq.adqV);
      }
      if (paramq.adqW != 0) {
        azC(paramq.adqW);
      }
      if (paramq.adqX != 0) {
        azD(paramq.adqX);
      }
      if (paramq.adqY != 0) {
        azE(paramq.adqY);
      }
      aJ(q.k(paramq));
      onChanged();
      AppMethodBeat.o(232183);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.q
 * JD-Core Version:    0.7.0.1
 */