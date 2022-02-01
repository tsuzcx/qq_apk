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

public final class i
  extends bg
  implements j
{
  private static final cs<i> PARSER;
  private static final i adqp;
  private q adqn;
  private q adqo;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(232330);
    adqp = new i();
    PARSER = new c() {};
    AppMethodBeat.o(232330);
  }
  
  private i() {}
  
  private i(bg.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private i(com.google.d.i parami, com.google.d.at paramat)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 33	com/tencent/mm/timelineedit/a/a/i:<init>	()V
    //   4: ldc 58
    //   6: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +18 -> 28
    //   13: new 60	java/lang/NullPointerException
    //   16: dup
    //   17: invokespecial 61	java/lang/NullPointerException:<init>	()V
    //   20: astore_1
    //   21: ldc 58
    //   23: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_1
    //   27: athrow
    //   28: invokestatic 67	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
    //   31: astore 6
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +234 -> 270
    //   39: aload_1
    //   40: invokevirtual 73	com/google/d/i:aac	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+257->304, 0:+263->310, 10:+51->98, 18:+143->190
    //   81: aload_1
    //   82: aload 6
    //   84: aload_2
    //   85: iload 4
    //   87: invokevirtual 77	com/tencent/mm/timelineedit/a/a/i:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
    //   90: ifne +199 -> 289
    //   93: iconst_1
    //   94: istore_3
    //   95: goto +212 -> 307
    //   98: aload_0
    //   99: getfield 79	com/tencent/mm/timelineedit/a/a/i:adqn	Lcom/tencent/mm/timelineedit/a/a/q;
    //   102: ifnull +196 -> 298
    //   105: aload_0
    //   106: getfield 79	com/tencent/mm/timelineedit/a/a/i:adqn	Lcom/tencent/mm/timelineedit/a/a/q;
    //   109: invokevirtual 85	com/tencent/mm/timelineedit/a/a/q:jfT	()Lcom/tencent/mm/timelineedit/a/a/q$a;
    //   112: astore 5
    //   114: aload_0
    //   115: aload_1
    //   116: invokestatic 89	com/tencent/mm/timelineedit/a/a/q:parser	()Lcom/google/d/cs;
    //   119: aload_2
    //   120: invokevirtual 92	com/google/d/i:a	(Lcom/google/d/cs;Lcom/google/d/at;)Lcom/google/d/ce;
    //   123: checkcast 81	com/tencent/mm/timelineedit/a/a/q
    //   126: putfield 79	com/tencent/mm/timelineedit/a/a/i:adqn	Lcom/tencent/mm/timelineedit/a/a/q;
    //   129: aload 5
    //   131: ifnull +158 -> 289
    //   134: aload 5
    //   136: aload_0
    //   137: getfield 79	com/tencent/mm/timelineedit/a/a/i:adqn	Lcom/tencent/mm/timelineedit/a/a/q;
    //   140: invokevirtual 98	com/tencent/mm/timelineedit/a/a/q$a:l	(Lcom/tencent/mm/timelineedit/a/a/q;)Lcom/tencent/mm/timelineedit/a/a/q$a;
    //   143: pop
    //   144: aload_0
    //   145: aload 5
    //   147: invokevirtual 102	com/tencent/mm/timelineedit/a/a/q$a:jfY	()Lcom/tencent/mm/timelineedit/a/a/q;
    //   150: putfield 79	com/tencent/mm/timelineedit/a/a/i:adqn	Lcom/tencent/mm/timelineedit/a/a/q;
    //   153: goto -118 -> 35
    //   156: astore_1
    //   157: aload_1
    //   158: aload_0
    //   159: putfield 106	com/google/d/bk:dST	Lcom/google/d/ce;
    //   162: ldc 58
    //   164: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: aload_0
    //   171: aload 6
    //   173: invokevirtual 112	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   176: putfield 116	com/tencent/mm/timelineedit/a/a/i:unknownFields	Lcom/google/d/dn;
    //   179: aload_0
    //   180: invokevirtual 119	com/tencent/mm/timelineedit/a/a/i:makeExtensionsImmutable	()V
    //   183: ldc 58
    //   185: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: athrow
    //   190: aload_0
    //   191: getfield 121	com/tencent/mm/timelineedit/a/a/i:adqo	Lcom/tencent/mm/timelineedit/a/a/q;
    //   194: ifnull +98 -> 292
    //   197: aload_0
    //   198: getfield 121	com/tencent/mm/timelineedit/a/a/i:adqo	Lcom/tencent/mm/timelineedit/a/a/q;
    //   201: invokevirtual 85	com/tencent/mm/timelineedit/a/a/q:jfT	()Lcom/tencent/mm/timelineedit/a/a/q$a;
    //   204: astore 5
    //   206: aload_0
    //   207: aload_1
    //   208: invokestatic 89	com/tencent/mm/timelineedit/a/a/q:parser	()Lcom/google/d/cs;
    //   211: aload_2
    //   212: invokevirtual 92	com/google/d/i:a	(Lcom/google/d/cs;Lcom/google/d/at;)Lcom/google/d/ce;
    //   215: checkcast 81	com/tencent/mm/timelineedit/a/a/q
    //   218: putfield 121	com/tencent/mm/timelineedit/a/a/i:adqo	Lcom/tencent/mm/timelineedit/a/a/q;
    //   221: aload 5
    //   223: ifnull +66 -> 289
    //   226: aload 5
    //   228: aload_0
    //   229: getfield 121	com/tencent/mm/timelineedit/a/a/i:adqo	Lcom/tencent/mm/timelineedit/a/a/q;
    //   232: invokevirtual 98	com/tencent/mm/timelineedit/a/a/q$a:l	(Lcom/tencent/mm/timelineedit/a/a/q;)Lcom/tencent/mm/timelineedit/a/a/q$a;
    //   235: pop
    //   236: aload_0
    //   237: aload 5
    //   239: invokevirtual 102	com/tencent/mm/timelineedit/a/a/q$a:jfY	()Lcom/tencent/mm/timelineedit/a/a/q;
    //   242: putfield 121	com/tencent/mm/timelineedit/a/a/i:adqo	Lcom/tencent/mm/timelineedit/a/a/q;
    //   245: goto -210 -> 35
    //   248: astore_1
    //   249: new 55	com/google/d/bk
    //   252: dup
    //   253: aload_1
    //   254: invokespecial 124	com/google/d/bk:<init>	(Ljava/io/IOException;)V
    //   257: astore_1
    //   258: aload_1
    //   259: aload_0
    //   260: putfield 106	com/google/d/bk:dST	Lcom/google/d/ce;
    //   263: ldc 58
    //   265: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aload_1
    //   269: athrow
    //   270: aload_0
    //   271: aload 6
    //   273: invokevirtual 112	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
    //   276: putfield 116	com/tencent/mm/timelineedit/a/a/i:unknownFields	Lcom/google/d/dn;
    //   279: aload_0
    //   280: invokevirtual 119	com/tencent/mm/timelineedit/a/a/i:makeExtensionsImmutable	()V
    //   283: ldc 58
    //   285: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: return
    //   289: goto +18 -> 307
    //   292: aconst_null
    //   293: astore 5
    //   295: goto -89 -> 206
    //   298: aconst_null
    //   299: astore 5
    //   301: goto -187 -> 114
    //   304: goto -224 -> 80
    //   307: goto -272 -> 35
    //   310: iconst_1
    //   311: istore_3
    //   312: goto -277 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	i
    //   0	315	1	parami	com.google.d.i
    //   0	315	2	paramat	com.google.d.at
    //   34	278	3	i	int
    //   43	43	4	j	int
    //   112	188	5	locala	q.a
    //   31	241	6	locala1	com.google.d.dn.a
    // Exception table:
    //   from	to	target	type
    //   39	45	156	com/google/d/bk
    //   80	93	156	com/google/d/bk
    //   98	114	156	com/google/d/bk
    //   114	129	156	com/google/d/bk
    //   134	153	156	com/google/d/bk
    //   190	206	156	com/google/d/bk
    //   206	221	156	com/google/d/bk
    //   226	245	156	com/google/d/bk
    //   39	45	169	finally
    //   80	93	169	finally
    //   98	114	169	finally
    //   114	129	169	finally
    //   134	153	169	finally
    //   157	169	169	finally
    //   190	206	169	finally
    //   206	221	169	finally
    //   226	245	169	finally
    //   249	270	169	finally
    //   39	45	248	java/io/IOException
    //   80	93	248	java/io/IOException
    //   98	114	248	java/io/IOException
    //   114	129	248	java/io/IOException
    //   134	153	248	java/io/IOException
    //   190	206	248	java/io/IOException
    //   206	221	248	java/io/IOException
    //   226	245	248	java/io/IOException
  }
  
  public static a a(i parami)
  {
    AppMethodBeat.i(232196);
    parami = adqp.jfI().c(parami);
    AppMethodBeat.o(232196);
    return parami;
  }
  
  public static a jfH()
  {
    AppMethodBeat.i(232188);
    a locala = adqp.jfI();
    AppMethodBeat.o(232188);
    return locala;
  }
  
  public static i jfJ()
  {
    return adqp;
  }
  
  public static cs<i> parser()
  {
    return PARSER;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232475);
    if (paramObject == this)
    {
      AppMethodBeat.o(232475);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(232475);
      return bool;
    }
    paramObject = (i)paramObject;
    if (jfD() != paramObject.jfD())
    {
      AppMethodBeat.o(232475);
      return false;
    }
    if ((jfD()) && (!jfE().equals(paramObject.jfE())))
    {
      AppMethodBeat.o(232475);
      return false;
    }
    if (jfF() != paramObject.jfF())
    {
      AppMethodBeat.o(232475);
      return false;
    }
    if ((jfF()) && (!jfG().equals(paramObject.jfG())))
    {
      AppMethodBeat.o(232475);
      return false;
    }
    if (!this.unknownFields.equals(paramObject.unknownFields))
    {
      AppMethodBeat.o(232475);
      return false;
    }
    AppMethodBeat.o(232475);
    return true;
  }
  
  public final cs<i> getParserForType()
  {
    return PARSER;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(232461);
    int i = this.memoizedSize;
    if (i != -1)
    {
      AppMethodBeat.o(232461);
      return i;
    }
    i = 0;
    if (this.adqn != null) {
      i = k.c(1, jfE()) + 0;
    }
    int j = i;
    if (this.adqo != null) {
      j = i + k.c(2, jfG());
    }
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    AppMethodBeat.o(232461);
    return i;
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(232492);
    if (this.memoizedHashCode != 0)
    {
      i = this.memoizedHashCode;
      AppMethodBeat.o(232492);
      return i;
    }
    int j = ae.adrZ.hashCode() + 779;
    int i = j;
    if (jfD()) {
      i = (j * 37 + 1) * 53 + jfE().hashCode();
    }
    j = i;
    if (jfF()) {
      j = (i * 37 + 2) * 53 + jfG().hashCode();
    }
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    AppMethodBeat.o(232492);
    return i;
  }
  
  public final bg.e internalGetFieldAccessorTable()
  {
    AppMethodBeat.i(232378);
    bg.e locale = ae.adsa.b(i.class, a.class);
    AppMethodBeat.o(232378);
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
  
  public final boolean jfD()
  {
    return this.adqn != null;
  }
  
  public final q jfE()
  {
    AppMethodBeat.i(232403);
    if (this.adqn == null)
    {
      localq = q.jfU();
      AppMethodBeat.o(232403);
      return localq;
    }
    q localq = this.adqn;
    AppMethodBeat.o(232403);
    return localq;
  }
  
  public final boolean jfF()
  {
    return this.adqo != null;
  }
  
  public final q jfG()
  {
    AppMethodBeat.i(232429);
    if (this.adqo == null)
    {
      localq = q.jfU();
      AppMethodBeat.o(232429);
      return localq;
    }
    q localq = this.adqo;
    AppMethodBeat.o(232429);
    return localq;
  }
  
  public final a jfI()
  {
    AppMethodBeat.i(232501);
    if (this == adqp)
    {
      locala = new a((byte)0);
      AppMethodBeat.o(232501);
      return locala;
    }
    a locala = new a((byte)0).c(this);
    AppMethodBeat.o(232501);
    return locala;
  }
  
  public final Object newInstance(bg.f paramf)
  {
    AppMethodBeat.i(232347);
    paramf = new i();
    AppMethodBeat.o(232347);
    return paramf;
  }
  
  public final void writeTo(k paramk)
  {
    AppMethodBeat.i(232449);
    if (this.adqn != null) {
      paramk.a(1, jfE());
    }
    if (this.adqo != null) {
      paramk.a(2, jfG());
    }
    this.unknownFields.writeTo(paramk);
    AppMethodBeat.o(232449);
  }
  
  public static final class a
    extends bg.a<a>
    implements j
  {
    private q adqn;
    private q adqo;
    private df<q, q.a, r> adqq;
    private df<q, q.a, r> adqr;
    
    private a()
    {
      AppMethodBeat.i(232448);
      i.ayB();
      AppMethodBeat.o(232448);
    }
    
    private a(bg.b paramb)
    {
      super();
      AppMethodBeat.i(232455);
      i.ayB();
      AppMethodBeat.o(232455);
    }
    
    private a N(am.f paramf, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(232494);
      paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
      AppMethodBeat.o(232494);
      return paramf;
    }
    
    /* Error */
    private a N(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: ldc 55
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: invokestatic 59	com/tencent/mm/timelineedit/a/a/i:jeJ	()Lcom/google/d/cs;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 65 3 0
      //   17: checkcast 9	com/tencent/mm/timelineedit/a/a/i
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 69	com/tencent/mm/timelineedit/a/a/i$a:c	(Lcom/tencent/mm/timelineedit/a/a/i;)Lcom/tencent/mm/timelineedit/a/a/i$a;
      //   30: pop
      //   31: ldc 55
      //   33: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 73	com/google/d/bk:dST	Lcom/google/d/ce;
      //   43: checkcast 9	com/tencent/mm/timelineedit/a/a/i
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
      //   66: invokevirtual 69	com/tencent/mm/timelineedit/a/a/i$a:c	(Lcom/tencent/mm/timelineedit/a/a/i;)Lcom/tencent/mm/timelineedit/a/a/i$a;
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
    
    private a O(cb paramcb)
    {
      AppMethodBeat.i(232507);
      if ((paramcb instanceof i))
      {
        paramcb = c((i)paramcb);
        AppMethodBeat.o(232507);
        return paramcb;
      }
      super.mergeFrom(paramcb);
      AppMethodBeat.o(232507);
      return this;
    }
    
    private a R(am.j paramj)
    {
      AppMethodBeat.i(232485);
      paramj = (a)super.clearOneof(paramj);
      AppMethodBeat.o(232485);
      return paramj;
    }
    
    private a V(am.f paramf)
    {
      AppMethodBeat.i(232478);
      paramf = (a)super.clearField(paramf);
      AppMethodBeat.o(232478);
      return paramf;
    }
    
    private a aC(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232470);
      paramf = (a)super.setField(paramf, paramObject);
      AppMethodBeat.o(232470);
      return paramf;
    }
    
    private a aD(am.f paramf, Object paramObject)
    {
      AppMethodBeat.i(232499);
      paramf = (a)super.addRepeatedField(paramf, paramObject);
      AppMethodBeat.o(232499);
      return paramf;
    }
    
    private a aE(dn paramdn)
    {
      AppMethodBeat.i(232536);
      paramdn = (a)super.setUnknownFields(paramdn);
      AppMethodBeat.o(232536);
      return paramdn;
    }
    
    private a aF(dn paramdn)
    {
      AppMethodBeat.i(232542);
      paramdn = (a)super.mergeUnknownFields(paramdn);
      AppMethodBeat.o(232542);
      return paramdn;
    }
    
    private a g(q paramq)
    {
      AppMethodBeat.i(232521);
      if (this.adqq == null) {
        if (this.adqn != null)
        {
          this.adqn = q.j(this.adqn).l(paramq).jfY();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(232521);
        return this;
        this.adqn = paramq;
        break;
        this.adqq.c(paramq);
      }
    }
    
    private a i(q paramq)
    {
      AppMethodBeat.i(232529);
      if (this.adqr == null) {
        if (this.adqo != null)
        {
          this.adqo = q.j(this.adqo).l(paramq).jfY();
          onChanged();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(232529);
        return this;
        this.adqo = paramq;
        break;
        this.adqr.c(paramq);
      }
    }
    
    private a jfK()
    {
      AppMethodBeat.i(232463);
      super.clear();
      if (this.adqq == null)
      {
        this.adqn = null;
        if (this.adqr != null) {
          break label54;
        }
        this.adqo = null;
      }
      for (;;)
      {
        AppMethodBeat.o(232463);
        return this;
        this.adqn = null;
        this.adqq = null;
        break;
        label54:
        this.adqo = null;
        this.adqr = null;
      }
    }
    
    public final a c(i parami)
    {
      AppMethodBeat.i(232587);
      if (parami == i.jfJ())
      {
        AppMethodBeat.o(232587);
        return this;
      }
      if (parami.jfD()) {
        g(parami.jfE());
      }
      if (parami.jfF()) {
        i(parami.jfG());
      }
      aF(i.b(parami));
      onChanged();
      AppMethodBeat.o(232587);
      return this;
    }
    
    public final a f(q paramq)
    {
      AppMethodBeat.i(232598);
      if (this.adqq == null)
      {
        if (paramq == null)
        {
          paramq = new NullPointerException();
          AppMethodBeat.o(232598);
          throw paramq;
        }
        this.adqn = paramq;
        onChanged();
      }
      for (;;)
      {
        AppMethodBeat.o(232598);
        return this;
        this.adqq.b(paramq);
      }
    }
    
    public final am.a getDescriptorForType()
    {
      return ae.adrZ;
    }
    
    public final a h(q paramq)
    {
      AppMethodBeat.i(232604);
      if (this.adqr == null)
      {
        if (paramq == null)
        {
          paramq = new NullPointerException();
          AppMethodBeat.o(232604);
          throw paramq;
        }
        this.adqo = paramq;
        onChanged();
      }
      for (;;)
      {
        AppMethodBeat.o(232604);
        return this;
        this.adqr.b(paramq);
      }
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(232561);
      bg.e locale = ae.adsa.b(i.class, a.class);
      AppMethodBeat.o(232561);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public final i jfL()
    {
      AppMethodBeat.i(232574);
      Object localObject = jfM();
      if (!((i)localObject).isInitialized())
      {
        localObject = newUninitializedMessageException((cb)localObject);
        AppMethodBeat.o(232574);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(232574);
      return localObject;
    }
    
    public final i jfM()
    {
      AppMethodBeat.i(232582);
      i locali = new i(this, (byte)0);
      if (this.adqq == null)
      {
        i.a(locali, this.adqn);
        if (this.adqr != null) {
          break label78;
        }
        i.b(locali, this.adqo);
      }
      for (;;)
      {
        onBuilt();
        AppMethodBeat.o(232582);
        return locali;
        i.a(locali, (q)this.adqq.ajn());
        break;
        label78:
        i.b(locali, (q)this.adqr.ajn());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.a.i
 * JD-Core Version:    0.7.0.1
 */