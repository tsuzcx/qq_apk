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
import com.google.d.h;
import com.google.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  extends bg
  implements t
{
  private static final cs<s> PARSER;
  private static final s adrc;
  int adra;
  h adrb;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(232195);
    adrc = new s();
    PARSER = new c() {};
    AppMethodBeat.o(232195);
  }
  
  private s()
  {
    this.adrb = h.dIJ;
  }
  
  private s(bg.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private s(com.google.d.i parami, com.google.d.at paramat)
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
    //   28: invokestatic 75	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +140 -> 176
    //   39: aload_1
    //   40: invokevirtual 81	com/google/d/i:aac	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+148->195, 0:+151->198, 8:+51->98, 18:+96->143
    //   81: aload_1
    //   82: aload 5
    //   84: aload_2
    //   85: iload 4
    //   87: invokevirtual 85	com/tencent/mm/timelineedit/a/a/s:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
    //   90: ifne -55 -> 35
    //   93: iconst_1
    //   94: istore_3
    //   95: goto -60 -> 35
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 88	com/google/d/i:aal	()I
    //   103: putfield 90	com/tencent/mm/timelineedit/a/a/s:adra	I
    //   106: goto -71 -> 35
    //   109: astore_1
    //   110: aload_1
    //   111: aload_0
    //   112: putfield 94	com/google/d/bk:dST	Lcom/google/d/ce;
    //   115: ldc 66
    //   117: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: aload 5
    //   126: invokevirtual 100	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   129: putfield 104	com/tencent/mm/timelineedit/a/a/s:unknownFields	Lcom/google/d/dn;
    //   132: aload_0
    //   133: invokevirtual 107	com/tencent/mm/timelineedit/a/a/s:makeExtensionsImmutable	()V
    //   136: ldc 66
    //   138: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: athrow
    //   143: aload_0
    //   144: aload_1
    //   145: invokevirtual 111	com/google/d/i:aak	()Lcom/google/d/h;
    //   148: putfield 53	com/tencent/mm/timelineedit/a/a/s:adrb	Lcom/google/d/h;
    //   151: goto -116 -> 35
    //   154: astore_1
    //   155: new 63	com/google/d/bk
    //   158: dup
    //   159: aload_1
    //   160: invokespecial 114	com/google/d/bk:<init>	(Ljava/io/IOException;)V
    //   163: astore_1
    //   164: aload_1
    //   165: aload_0
    //   166: putfield 94	com/google/d/bk:dST	Lcom/google/d/ce;
    //   169: ldc 66
    //   171: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_1
    //   175: athrow
    //   176: aload_0
    //   177: aload 5
    //   179: invokevirtual 100	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   182: putfield 104	com/tencent/mm/timelineedit/a/a/s:unknownFields	Lcom/google/d/dn;
    //   185: aload_0
    //   186: invokevirtual 107	com/tencent/mm/timelineedit/a/a/s:makeExtensionsImmutable	()V
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
  
  public static a b(s params)
  {
    AppMethodBeat.i(232146);
    params = adrc.jfZ().d(params);
    AppMethodBeat.o(232146);
    return params;
  }
  
  public static s jga()
  {
    return adrc;
  }
  
  public static cs<s> parser()
  {
    return PARSER;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232254);
    if (paramObject == this)
    {
      AppMethodBeat.o(232254);
      return true;
    }
    if (!(paramObject instanceof s))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(232254);
      return bool;
    }
    paramObject = (s)paramObject;
    if (this.adra != paramObject.adra)
    {
      AppMethodBeat.o(232254);
      return false;
    }
    if (!this.adrb.equals(paramObject.adrb))
    {
      AppMethodBeat.o(232254);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(232254);
      return false;
    }
    AppMethodBeat.o(232254);
    return true;
  }
  
  public final cs<s> getParserForType()
  {
    return PARSER;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(232246);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(232246);
      return i;
    }
    i = 0;
    if (this.adra != 0) {
      i = k.cK(1, this.adra) + 0;
    }
    int j = i;
    if (!this.adrb.isEmpty()) {
      j = i + k.c(2, this.adrb);
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    AppMethodBeat.o(232246);
    return i;
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(232266);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(232266);
      return i;
    }
    int i = (((((ae.adsl.hashCode() + 779) * 37 + 1) * 53 + this.adra) * 37 + 2) * 53 + this.adrb.hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(232266);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(232219);
    bg.e locale = ae.adsm.b(s.class, a.class);
    AppMethodBeat.o(232219);
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
  
  public final a jfZ()
  {
    AppMethodBeat.i(232275);
    if (this == adrc)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(232275);
      return locala;
    }
    a locala = new a((byte)0).d(this);
    AppMethodBeat.o(232275);
    return locala;
  }
  
  public final Object newInstance(bg.f paramf)
  {
    AppMethodBeat.i(232206);
    paramf = new s();
    AppMethodBeat.o(232206);
    return paramf;
  }
  
  public final void writeTo(k paramk)
  {
    AppMethodBeat.i(232237);
    if (this.adra != 0) {
      paramk.cG(1, this.adra);
    }
    if (!this.adrb.isEmpty()) {
      paramk.a(2, this.adrb);
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(232237);
  }
  
  public static final class a
    extends bg.a<a>
    implements t
  {
    private int adra;
    private h adrb;
    
    private a()
    {
      AppMethodBeat.i(232075);
      this.adrb = h.dIJ;
      s.ayB();
      AppMethodBeat.o(232075);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232081);
      this.adrb = h.dIJ;
      s.ayB();
      AppMethodBeat.o(232081);
    }
    
    private a Q(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232116);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232116);
      return paramf;
    }
    
    /* Error */
    private a Q(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: ldc 59
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 63	com/tencent/mm/timelineedit/a/a/s:jeJ	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 69 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/s
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 73	com/tencent/mm/timelineedit/a/a/s$a:d	(Lcom/tencent/mm/timelineedit/a/a/s;)Lcom/tencent/mm/timelineedit/a/a/s$a;
      //   30: pop
      //   31: ldc 59
      //   33: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 77	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/s
      //   46: astore_2
      //   47: aload_1
      //   48: invokevirtual 81	com/google/d/bk:aii	()Ljava/io/IOException;
      //   51: astore_1
      //   52: ldc 59
      //   54: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   57: aload_1
      //   58: athrow
      //   59: astore_1
      //   60: aload_2
      //   61: ifnull +9 -> 70
      //   64: aload_0
      //   65: aload_2
      //   66: invokevirtual 73	com/tencent/mm/timelineedit/a/a/s$a:d	(Lcom/tencent/mm/timelineedit/a/a/s;)Lcom/tencent/mm/timelineedit/a/a/s$a;
      //   69: pop
      //   70: ldc 59
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
    
    private a R(cb paramcb)
    {
      AppMethodBeat.i(232127);
      if ((paramcb instanceof s))
      {
        paramcb = d((s)paramcb);
        AppMethodBeat.o(232127);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232127);
      return this;
    }
    
    private a U(am.j paramj)
    {
      AppMethodBeat.i(232109);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232109);
      return paramj;
    }
    
    private a Y(am.f paramf)
    {
      AppMethodBeat.i(232101);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232101);
      return paramf;
    }
    
    private a aI(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232096);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232096);
      return paramf;
    }
    
    private a aJ(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232120);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232120);
      return paramf;
    }
    
    private a aK(dn paramdn)
    {
      AppMethodBeat.i(232152);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(232152);
      return paramdn;
    }
    
    private a aL(dn paramdn)
    {
      AppMethodBeat.i(232157);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(232157);
      return paramdn;
    }
    
    private a azF(int paramInt)
    {
      AppMethodBeat.i(232141);
      this.adra = paramInt;
      onChanged();
      AppMethodBeat.o(232141);
      return this;
    }
    
    private a jgb()
    {
      AppMethodBeat.i(232090);
      super.clear();
      this.adra = 0;
      this.adrb = h.dIJ;
      AppMethodBeat.o(232090);
      return this;
    }
    
    private s jgc()
    {
      AppMethodBeat.i(232093);
      Object localObject = jgd();
      if (!((s)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232093);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232093);
      return localObject;
    }
    
    private a t(h paramh)
    {
      AppMethodBeat.i(232147);
      if (paramh == null)
      {
        paramh = new NullPointerException();
        AppMethodBeat.o(232147);
        throw paramh;
      }
      this.adrb = paramh;
      onChanged();
      AppMethodBeat.o(232147);
      return this;
    }
    
    public final a d(s params)
    {
      AppMethodBeat.i(232193);
      if (params == s.jga())
      {
        AppMethodBeat.o(232193);
        return this;
      }
      if (params.adra != 0) {
        azF(params.adra);
      }
      if (params.adrb != h.dIJ) {
        t(params.adrb);
      }
      aL(s.c(params));
      onChanged();
      AppMethodBeat.o(232193);
      return this;
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adsl;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(232177);
      bg.e locale = ae.adsm.b(s.class, a.class);
      AppMethodBeat.o(232177);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public final s jgd()
    {
      AppMethodBeat.i(232187);
      s locals = new s(this, (byte)0);
      s.a(locals, this.adra);
      s.a(locals, this.adrb);
      onBuilt();
      AppMethodBeat.o(232187);
      return locals;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.s
 * JD-Core Version:    0.7.0.1
 */