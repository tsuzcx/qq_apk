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

public final class y
  extends bg
  implements z
{
  private static final cs<y> PARSER;
  private static final y adrt;
  float adrs;
  private byte memoizedIsInitialized = -1;
  int type_;
  
  static
  {
    AppMethodBeat.i(232805);
    adrt = new y();
    PARSER = new c() {};
    AppMethodBeat.o(232805);
  }
  
  private y()
  {
    this.type_ = 0;
  }
  
  private y(bg.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private y(com.google.d.i parami, com.google.d.at paramat)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 34	com/tencent/mm/timelineedit/a/a/y:<init>	()V
    //   4: ldc 61
    //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +18 -> 28
    //   13: new 63	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 64	java/lang/NullPointerException:<init>	()V
    //   20: astore_1
    //   21: ldc 61
    //   23: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_1
    //   27: athrow
    //   28: invokestatic 70	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +140 -> 176
    //   39: aload_1
    //   40: invokevirtual 76	com/google/d/i:aac	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+148->195, 0:+151->198, 8:+51->98, 21:+96->143
    //   81: aload_1
    //   82: aload 5
    //   84: aload_2
    //   85: iload 4
    //   87: invokevirtual 80	com/tencent/mm/timelineedit/a/a/y:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
    //   90: ifne -55 -> 35
    //   93: iconst_1
    //   94: istore_3
    //   95: goto -60 -> 35
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 83	com/google/d/i:aam	()I
    //   103: putfield 48	com/tencent/mm/timelineedit/a/a/y:type_	I
    //   106: goto -71 -> 35
    //   109: astore_1
    //   110: aload_1
    //   111: aload_0
    //   112: putfield 87	com/google/d/bk:dST	Lcom/google/d/ce;
    //   115: ldc 61
    //   117: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: aload 5
    //   126: invokevirtual 93	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   129: putfield 97	com/tencent/mm/timelineedit/a/a/y:unknownFields	Lcom/google/d/dn;
    //   132: aload_0
    //   133: invokevirtual 100	com/tencent/mm/timelineedit/a/a/y:makeExtensionsImmutable	()V
    //   136: ldc 61
    //   138: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: athrow
    //   143: aload_0
    //   144: aload_1
    //   145: invokevirtual 104	com/google/d/i:readFloat	()F
    //   148: putfield 106	com/tencent/mm/timelineedit/a/a/y:adrs	F
    //   151: goto -116 -> 35
    //   154: astore_1
    //   155: new 58	com/google/d/bk
    //   158: dup
    //   159: aload_1
    //   160: invokespecial 109	com/google/d/bk:<init>	(Ljava/io/IOException;)V
    //   163: astore_1
    //   164: aload_1
    //   165: aload_0
    //   166: putfield 87	com/google/d/bk:dST	Lcom/google/d/ce;
    //   169: ldc 61
    //   171: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_1
    //   175: athrow
    //   176: aload_0
    //   177: aload 5
    //   179: invokevirtual 93	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   182: putfield 97	com/tencent/mm/timelineedit/a/a/y:unknownFields	Lcom/google/d/dn;
    //   185: aload_0
    //   186: invokevirtual 100	com/tencent/mm/timelineedit/a/a/y:makeExtensionsImmutable	()V
    //   189: ldc 61
    //   191: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: return
    //   195: goto -115 -> 80
    //   198: iconst_1
    //   199: istore_3
    //   200: goto -165 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	y
    //   0	203	1	parami	com.google.d.i
    //   0	203	2	paramat	com.google.d.at
    //   34	166	3	i	int
    //   43	43	4	j	int
    //   31	147	5	locala	com.google.d.dn.a
    // Exception table:
    //   from	to	target	type
    //   39	45	109	com/google/d/bk
    //   80	93	109	com/google/d/bk
    //   98	106	109	com/google/d/bk
    //   143	151	109	com/google/d/bk
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
  
  public static a a(y paramy)
  {
    AppMethodBeat.i(232701);
    paramy = adrt.jgs().d(paramy);
    AppMethodBeat.o(232701);
    return paramy;
  }
  
  public static y jgt()
  {
    return adrt;
  }
  
  public static cs<y> parser()
  {
    return PARSER;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232890);
    if (paramObject == this)
    {
      AppMethodBeat.o(232890);
      return true;
    }
    if (!(paramObject instanceof y))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(232890);
      return bool;
    }
    paramObject = (y)paramObject;
    if (this.type_ != paramObject.type_)
    {
      AppMethodBeat.o(232890);
      return false;
    }
    if (Float.floatToIntBits(this.adrs) != Float.floatToIntBits(paramObject.adrs))
    {
      AppMethodBeat.o(232890);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(232890);
      return false;
    }
    AppMethodBeat.o(232890);
    return true;
  }
  
  public final cs<y> getParserForType()
  {
    return PARSER;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(232879);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(232879);
      return i;
    }
    i = 0;
    if (this.type_ != n.adqB.getNumber()) {
      i = k.cM(1, this.type_) + 0;
    }
    int j = i;
    if (this.adrs != 0.0F) {
      j = i + k.kl(2);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    AppMethodBeat.o(232879);
    return i;
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(232900);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(232900);
      return i;
    }
    int i = (((((ae.adsd.hashCode() + 779) * 37 + 1) * 53 + this.type_) * 37 + 2) * 53 + Float.floatToIntBits(this.adrs)) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(232900);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(232839);
    bg.e locale = ae.adse.b(y.class, a.class);
    AppMethodBeat.o(232839);
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
  
  public final a jgs()
  {
    AppMethodBeat.i(232910);
    if (this == adrt)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(232910);
      return locala;
    }
    a locala = new a((byte)0).d(this);
    AppMethodBeat.o(232910);
    return locala;
  }
  
  public final Object newInstance(bg.f paramf)
  {
    AppMethodBeat.i(232815);
    paramf = new y();
    AppMethodBeat.o(232815);
    return paramf;
  }
  
  public final void writeTo(k paramk)
  {
    AppMethodBeat.i(232865);
    if (this.type_ != n.adqB.getNumber()) {
      paramk.cF(1, this.type_);
    }
    if (this.adrs != 0.0F) {
      paramk.l(2, this.adrs);
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(232865);
  }
  
  public static final class a
    extends bg.a<a>
    implements z
  {
    private float adrs;
    private int type_;
    
    private a()
    {
      AppMethodBeat.i(232703);
      this.type_ = 0;
      y.ayB();
      AppMethodBeat.o(232703);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232710);
      this.type_ = 0;
      y.ayB();
      AppMethodBeat.o(232710);
    }
    
    private a T(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232775);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232775);
      return paramf;
    }
    
    /* Error */
    private a T(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: ldc 54
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 58	com/tencent/mm/timelineedit/a/a/y:jeJ	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 64 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/y
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 68	com/tencent/mm/timelineedit/a/a/y$a:d	(Lcom/tencent/mm/timelineedit/a/a/y;)Lcom/tencent/mm/timelineedit/a/a/y$a;
      //   30: pop
      //   31: ldc 54
      //   33: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 72	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/y
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 76	com/google/d/bk:aii	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 54
      //   54: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 68	com/tencent/mm/timelineedit/a/a/y$a:d	(Lcom/tencent/mm/timelineedit/a/a/y;)Lcom/tencent/mm/timelineedit/a/a/y$a;
      //   69: pop
      //   70: ldc 54
      //   72: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private a U(cb paramcb)
    {
      AppMethodBeat.i(232800);
      if ((paramcb instanceof y))
      {
        paramcb = d((y)paramcb);
        AppMethodBeat.o(232800);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232800);
      return this;
    }
    
    private a X(am.j paramj)
    {
      AppMethodBeat.i(232765);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232765);
      return paramj;
    }
    
    private a aO(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232740);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232740);
      return paramf;
    }
    
    private a aP(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232788);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232788);
      return paramf;
    }
    
    private a aQ(dn paramdn)
    {
      AppMethodBeat.i(232848);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(232848);
      return paramdn;
    }
    
    private a aR(dn paramdn)
    {
      AppMethodBeat.i(232859);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(232859);
      return paramdn;
    }
    
    private a ab(am.f paramf)
    {
      AppMethodBeat.i(232750);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232750);
      return paramf;
    }
    
    private a azK(int paramInt)
    {
      AppMethodBeat.i(232826);
      this.type_ = paramInt;
      onChanged();
      AppMethodBeat.o(232826);
      return this;
    }
    
    private a dM(float paramFloat)
    {
      AppMethodBeat.i(232835);
      this.adrs = paramFloat;
      onChanged();
      AppMethodBeat.o(232835);
      return this;
    }
    
    private a jgu()
    {
      AppMethodBeat.i(232721);
      super.clear();
      this.type_ = 0;
      this.adrs = 0.0F;
      AppMethodBeat.o(232721);
      return this;
    }
    
    private y jgv()
    {
      AppMethodBeat.i(232730);
      Object localObject = jgw();
      if (!((y)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232730);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232730);
      return localObject;
    }
    
    public final a d(y paramy)
    {
      AppMethodBeat.i(232919);
      if (paramy == y.jgt())
      {
        AppMethodBeat.o(232919);
        return this;
      }
      if (y.b(paramy) != 0) {
        azK(paramy.type_);
      }
      if (paramy.adrs != 0.0F) {
        dM(paramy.adrs);
      }
      aR(y.c(paramy));
      onChanged();
      AppMethodBeat.o(232919);
      return this;
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adsd;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(232891);
      bg.e locale = ae.adse.b(y.class, a.class);
      AppMethodBeat.o(232891);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public final y jgw()
    {
      AppMethodBeat.i(232909);
      y localy = new y(this, (byte)0);
      y.a(localy, this.type_);
      y.a(localy, this.adrs);
      onBuilt();
      AppMethodBeat.o(232909);
      return localy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.y
 * JD-Core Version:    0.7.0.1
 */