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
import com.google.d.df;
import com.google.d.dn;
import com.google.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends bg
  implements b
{
  private static final cs<a> PARSER;
  private static final a adpK;
  int adpI;
  private s adpJ;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(232165);
    adpK = new a();
    PARSER = new c() {};
    AppMethodBeat.o(232165);
  }
  
  private a() {}
  
  private a(bg.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private a(com.google.d.i parami, com.google.d.at paramat)
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
    //   87: invokevirtual 78	com/tencent/mm/timelineedit/a/a/a:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
    //   90: ifne +152 -> 242
    //   93: iconst_1
    //   94: istore_3
    //   95: goto +159 -> 254
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 81	com/google/d/i:aal	()I
    //   103: putfield 83	com/tencent/mm/timelineedit/a/a/a:adpI	I
    //   106: goto -71 -> 35
    //   109: astore_1
    //   110: aload_1
    //   111: aload_0
    //   112: putfield 87	com/google/d/bk:dST	Lcom/google/d/ce;
    //   115: ldc 59
    //   117: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: aload 6
    //   126: invokevirtual 93	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   129: putfield 97	com/tencent/mm/timelineedit/a/a/a:unknownFields	Lcom/google/d/dn;
    //   132: aload_0
    //   133: invokevirtual 100	com/tencent/mm/timelineedit/a/a/a:makeExtensionsImmutable	()V
    //   136: ldc 59
    //   138: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: athrow
    //   143: aload_0
    //   144: getfield 102	com/tencent/mm/timelineedit/a/a/a:adpJ	Lcom/tencent/mm/timelineedit/a/a/s;
    //   147: ifnull +98 -> 245
    //   150: aload_0
    //   151: getfield 102	com/tencent/mm/timelineedit/a/a/a:adpJ	Lcom/tencent/mm/timelineedit/a/a/s;
    //   154: invokevirtual 108	com/tencent/mm/timelineedit/a/a/s:jfZ	()Lcom/tencent/mm/timelineedit/a/a/s$a;
    //   157: astore 5
    //   159: aload_0
    //   160: aload_1
    //   161: invokestatic 112	com/tencent/mm/timelineedit/a/a/s:parser	()Lcom/google/d/cs;
    //   164: aload_2
    //   165: invokevirtual 115	com/google/d/i:a	(Lcom/google/d/cs;Lcom/google/d/at;)Lcom/google/d/ce;
    //   168: checkcast 104	com/tencent/mm/timelineedit/a/a/s
    //   171: putfield 102	com/tencent/mm/timelineedit/a/a/a:adpJ	Lcom/tencent/mm/timelineedit/a/a/s;
    //   174: aload 5
    //   176: ifnull +66 -> 242
    //   179: aload 5
    //   181: aload_0
    //   182: getfield 102	com/tencent/mm/timelineedit/a/a/a:adpJ	Lcom/tencent/mm/timelineedit/a/a/s;
    //   185: invokevirtual 121	com/tencent/mm/timelineedit/a/a/s$a:d	(Lcom/tencent/mm/timelineedit/a/a/s;)Lcom/tencent/mm/timelineedit/a/a/s$a;
    //   188: pop
    //   189: aload_0
    //   190: aload 5
    //   192: invokevirtual 125	com/tencent/mm/timelineedit/a/a/s$a:jgd	()Lcom/tencent/mm/timelineedit/a/a/s;
    //   195: putfield 102	com/tencent/mm/timelineedit/a/a/a:adpJ	Lcom/tencent/mm/timelineedit/a/a/s;
    //   198: goto -163 -> 35
    //   201: astore_1
    //   202: new 56	com/google/d/bk
    //   205: dup
    //   206: aload_1
    //   207: invokespecial 128	com/google/d/bk:<init>	(Ljava/io/IOException;)V
    //   210: astore_1
    //   211: aload_1
    //   212: aload_0
    //   213: putfield 87	com/google/d/bk:dST	Lcom/google/d/ce;
    //   216: ldc 59
    //   218: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_1
    //   222: athrow
    //   223: aload_0
    //   224: aload 6
    //   226: invokevirtual 93	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   229: putfield 97	com/tencent/mm/timelineedit/a/a/a:unknownFields	Lcom/google/d/dn;
    //   232: aload_0
    //   233: invokevirtual 100	com/tencent/mm/timelineedit/a/a/a:makeExtensionsImmutable	()V
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
    //   0	262	1	parami	com.google.d.i
    //   0	262	2	paramat	com.google.d.at
    //   34	225	3	i	int
    //   43	43	4	j	int
    //   157	90	5	locala	s.a
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
  
  private a jeH()
  {
    AppMethodBeat.i(232114);
    if (this == adpK)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(232114);
      return locala;
    }
    a locala = new a((byte)0).b(this);
    AppMethodBeat.o(232114);
    return locala;
  }
  
  public static a jeI()
  {
    return adpK;
  }
  
  public static cs<a> parser()
  {
    return PARSER;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232223);
    if (paramObject == this)
    {
      AppMethodBeat.o(232223);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(232223);
      return bool;
    }
    paramObject = (a)paramObject;
    if (this.adpI != paramObject.adpI)
    {
      AppMethodBeat.o(232223);
      return false;
    }
    if (jeF() != paramObject.jeF())
    {
      AppMethodBeat.o(232223);
      return false;
    }
    if ((jeF()) && (!jeG().equals(paramObject.jeG())))
    {
      AppMethodBeat.o(232223);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(232223);
      return false;
    }
    AppMethodBeat.o(232223);
    return true;
  }
  
  public final cs<a> getParserForType()
  {
    return PARSER;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(232213);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(232213);
      return i;
    }
    i = 0;
    if (this.adpI != 0) {
      i = k.cK(1, this.adpI) + 0;
    }
    int j = i;
    if (this.adpJ != null) {
      j = i + k.c(2, jeG());
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    AppMethodBeat.o(232213);
    return i;
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(232231);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(232231);
      return i;
    }
    int j = ((ae.adsn.hashCode() + 779) * 37 + 1) * 53 + this.adpI;
    int i = j;
    if (jeF()) {
      i = (j * 37 + 2) * 53 + jeG().hashCode();
    }
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(232231);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(232185);
    bg.e locale = ae.adso.b(a.class, a.class);
    AppMethodBeat.o(232185);
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
  
  public final boolean jeF()
  {
    return this.adpJ != null;
  }
  
  public final s jeG()
  {
    AppMethodBeat.i(232192);
    if (this.adpJ == null)
    {
      locals = s.jga();
      AppMethodBeat.o(232192);
      return locals;
    }
    s locals = this.adpJ;
    AppMethodBeat.o(232192);
    return locals;
  }
  
  public final Object newInstance(bg.f paramf)
  {
    AppMethodBeat.i(232170);
    paramf = new a();
    AppMethodBeat.o(232170);
    return paramf;
  }
  
  public final void writeTo(k paramk)
  {
    AppMethodBeat.i(232205);
    if (this.adpI != 0) {
      paramk.cG(1, this.adpI);
    }
    if (this.adpJ != null) {
      paramk.a(2, jeG());
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(232205);
  }
  
  public static final class a
    extends bg.a<a>
    implements b
  {
    private int adpI;
    private s adpJ;
    private df<s, s.a, t> adpL;
    
    private a()
    {
      AppMethodBeat.i(232513);
      a.ayB();
      AppMethodBeat.o(232513);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232519);
      a.ayB();
      AppMethodBeat.o(232519);
    }
    
    private a J(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232568);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232568);
      return paramf;
    }
    
    /* Error */
    private a J(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: ldc 55
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 59	com/tencent/mm/timelineedit/a/a/a:jeJ	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 65 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/a
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 69	com/tencent/mm/timelineedit/a/a/a$a:b	(Lcom/tencent/mm/timelineedit/a/a/a;)Lcom/tencent/mm/timelineedit/a/a/a$a;
      //   30: pop
      //   31: ldc 55
      //   33: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 73	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/a
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
      //   66: invokevirtual 69	com/tencent/mm/timelineedit/a/a/a$a:b	(Lcom/tencent/mm/timelineedit/a/a/a;)Lcom/tencent/mm/timelineedit/a/a/a$a;
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
    
    private a K(cb paramcb)
    {
      AppMethodBeat.i(232579);
      if ((paramcb instanceof a))
      {
        paramcb = b((a)paramcb);
        AppMethodBeat.o(232579);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232579);
      return this;
    }
    
    private a N(am.j paramj)
    {
      AppMethodBeat.i(232562);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232562);
      return paramj;
    }
    
    private a R(am.f paramf)
    {
      AppMethodBeat.i(232554);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232554);
      return paramf;
    }
    
    private a a(s params)
    {
      AppMethodBeat.i(232600);
      if (this.adpL == null) {
        if (this.adpJ != null)
        {
          this.adpJ = s.b(this.adpJ).d(params).jgd();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(232600);
        return this;
        this.adpJ = params;
        break;
        this.adpL.c(params);
      }
    }
    
    private a au(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232549);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232549);
      return paramf;
    }
    
    private a av(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232573);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232573);
      return paramf;
    }
    
    private a aw(dn paramdn)
    {
      AppMethodBeat.i(232605);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(232605);
      return paramdn;
    }
    
    private a ax(dn paramdn)
    {
      AppMethodBeat.i(232610);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(232610);
      return paramdn;
    }
    
    private a azx(int paramInt)
    {
      AppMethodBeat.i(232593);
      this.adpI = paramInt;
      onChanged();
      AppMethodBeat.o(232593);
      return this;
    }
    
    private a jeK()
    {
      AppMethodBeat.i(232526);
      super.clear();
      this.adpI = 0;
      if (this.adpL == null) {
        this.adpJ = null;
      }
      for (;;)
      {
        AppMethodBeat.o(232526);
        return this;
        this.adpJ = null;
        this.adpL = null;
      }
    }
    
    private a jeL()
    {
      AppMethodBeat.i(232534);
      Object localObject = jeM();
      if (!((a)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232534);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232534);
      return localObject;
    }
    
    private a jeM()
    {
      AppMethodBeat.i(232541);
      a locala = new a(this, (byte)0);
      a.a(locala, this.adpI);
      if (this.adpL == null) {
        a.a(locala, this.adpJ);
      }
      for (;;)
      {
        onBuilt();
        AppMethodBeat.o(232541);
        return locala;
        a.a(locala, (s)this.adpL.ajn());
      }
    }
    
    public final a b(a parama)
    {
      AppMethodBeat.i(232693);
      if (parama == a.jeI())
      {
        AppMethodBeat.o(232693);
        return this;
      }
      if (parama.adpI != 0) {
        azx(parama.adpI);
      }
      if (parama.jeF()) {
        a(parama.jeG());
      }
      ax(a.a(parama));
      onChanged();
      AppMethodBeat.o(232693);
      return this;
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adsn;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(232684);
      bg.e locale = ae.adso.b(a.class, a.class);
      AppMethodBeat.o(232684);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.a
 * JD-Core Version:    0.7.0.1
 */