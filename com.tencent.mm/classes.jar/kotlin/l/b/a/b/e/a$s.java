package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.h.t;

public final class a$s
  extends i
  implements v
{
  public static t<s> aiYa;
  private static final s ajbn;
  private final d aiXZ;
  public List<a.p> ajbo;
  public int ajbp;
  private int bitField0_;
  private int dRJ = -1;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(58957);
    aiYa = new b() {};
    s locals = new s();
    ajbn = locals;
    locals.ktf();
    AppMethodBeat.o(58957);
  }
  
  private a$s()
  {
    this.aiXZ = d.ajeU;
  }
  
  /* Error */
  private a$s(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 55	kotlin/l/b/a/b/h/i:<init>	()V
    //   4: ldc 72
    //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 57	kotlin/l/b/a/b/e/a$s:memoizedIsInitialized	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 59	kotlin/l/b/a/b/e/a$s:dRJ	I
    //   19: aload_0
    //   20: invokespecial 50	kotlin/l/b/a/b/e/a$s:ktf	()V
    //   23: invokestatic 76	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
    //   26: astore 9
    //   28: aload 9
    //   30: iconst_1
    //   31: invokestatic 81	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   34: astore 10
    //   36: iconst_0
    //   37: istore 6
    //   39: iconst_0
    //   40: istore_3
    //   41: iload 6
    //   43: ifne +302 -> 345
    //   46: iload_3
    //   47: istore 7
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 8
    //   55: aload_1
    //   56: invokevirtual 87	kotlin/l/b/a/b/h/e:aac	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+384->447, 0:+387->450, 10:+61->124, 16:+202->265
    //   97: istore 7
    //   99: iload_3
    //   100: istore 5
    //   102: iload_3
    //   103: istore 8
    //   105: aload_0
    //   106: aload_1
    //   107: aload 10
    //   109: aload_2
    //   110: iload 4
    //   112: invokevirtual 90	kotlin/l/b/a/b/e/a$s:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   115: ifne -74 -> 41
    //   118: iconst_1
    //   119: istore 6
    //   121: goto -80 -> 41
    //   124: iload_3
    //   125: istore 4
    //   127: iload_3
    //   128: iconst_1
    //   129: iand
    //   130: iconst_1
    //   131: if_icmpeq +28 -> 159
    //   134: iload_3
    //   135: istore 7
    //   137: iload_3
    //   138: istore 5
    //   140: iload_3
    //   141: istore 8
    //   143: aload_0
    //   144: new 92	java/util/ArrayList
    //   147: dup
    //   148: invokespecial 93	java/util/ArrayList:<init>	()V
    //   151: putfield 95	kotlin/l/b/a/b/e/a$s:ajbo	Ljava/util/List;
    //   154: iload_3
    //   155: iconst_1
    //   156: ior
    //   157: istore 4
    //   159: iload 4
    //   161: istore 7
    //   163: iload 4
    //   165: istore 5
    //   167: iload 4
    //   169: istore 8
    //   171: aload_0
    //   172: getfield 95	kotlin/l/b/a/b/e/a$s:ajbo	Ljava/util/List;
    //   175: aload_1
    //   176: getstatic 98	kotlin/l/b/a/b/e/a$p:aiYa	Lkotlin/l/b/a/b/h/t;
    //   179: aload_2
    //   180: invokevirtual 101	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   183: invokeinterface 107 2 0
    //   188: pop
    //   189: iload 4
    //   191: istore_3
    //   192: goto -151 -> 41
    //   195: astore_1
    //   196: iload 7
    //   198: istore 5
    //   200: aload_1
    //   201: aload_0
    //   202: putfield 111	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   205: iload 7
    //   207: istore 5
    //   209: ldc 72
    //   211: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: iload 7
    //   216: istore 5
    //   218: aload_1
    //   219: athrow
    //   220: astore_1
    //   221: iload 5
    //   223: iconst_1
    //   224: iand
    //   225: iconst_1
    //   226: if_icmpne +14 -> 240
    //   229: aload_0
    //   230: aload_0
    //   231: getfield 95	kotlin/l/b/a/b/e/a$s:ajbo	Ljava/util/List;
    //   234: invokestatic 117	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   237: putfield 95	kotlin/l/b/a/b/e/a$s:ajbo	Ljava/util/List;
    //   240: aload 10
    //   242: invokevirtual 120	kotlin/l/b/a/b/h/f:flush	()V
    //   245: aload_0
    //   246: aload 9
    //   248: invokevirtual 126	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   251: putfield 66	kotlin/l/b/a/b/e/a$s:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   254: aload_0
    //   255: invokevirtual 129	kotlin/l/b/a/b/e/a$s:makeExtensionsImmutable	()V
    //   258: ldc 72
    //   260: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload_1
    //   264: athrow
    //   265: iload_3
    //   266: istore 7
    //   268: iload_3
    //   269: istore 5
    //   271: iload_3
    //   272: istore 8
    //   274: aload_0
    //   275: aload_0
    //   276: getfield 131	kotlin/l/b/a/b/e/a$s:bitField0_	I
    //   279: iconst_1
    //   280: ior
    //   281: putfield 131	kotlin/l/b/a/b/e/a$s:bitField0_	I
    //   284: iload_3
    //   285: istore 7
    //   287: iload_3
    //   288: istore 5
    //   290: iload_3
    //   291: istore 8
    //   293: aload_0
    //   294: aload_1
    //   295: invokevirtual 134	kotlin/l/b/a/b/h/e:aar	()I
    //   298: putfield 136	kotlin/l/b/a/b/e/a$s:ajbp	I
    //   301: goto -260 -> 41
    //   304: astore_1
    //   305: iload 8
    //   307: istore 5
    //   309: new 69	kotlin/l/b/a/b/h/l
    //   312: dup
    //   313: aload_1
    //   314: invokevirtual 140	java/io/IOException:getMessage	()Ljava/lang/String;
    //   317: invokespecial 143	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   320: astore_1
    //   321: iload 8
    //   323: istore 5
    //   325: aload_1
    //   326: aload_0
    //   327: putfield 111	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   330: iload 8
    //   332: istore 5
    //   334: ldc 72
    //   336: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: iload 8
    //   341: istore 5
    //   343: aload_1
    //   344: athrow
    //   345: iload_3
    //   346: iconst_1
    //   347: iand
    //   348: iconst_1
    //   349: if_icmpne +14 -> 363
    //   352: aload_0
    //   353: aload_0
    //   354: getfield 95	kotlin/l/b/a/b/e/a$s:ajbo	Ljava/util/List;
    //   357: invokestatic 117	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   360: putfield 95	kotlin/l/b/a/b/e/a$s:ajbo	Ljava/util/List;
    //   363: aload 10
    //   365: invokevirtual 120	kotlin/l/b/a/b/h/f:flush	()V
    //   368: aload_0
    //   369: aload 9
    //   371: invokevirtual 126	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   374: putfield 66	kotlin/l/b/a/b/e/a$s:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   377: aload_0
    //   378: invokevirtual 129	kotlin/l/b/a/b/e/a$s:makeExtensionsImmutable	()V
    //   381: ldc 72
    //   383: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: return
    //   387: astore_1
    //   388: aload_0
    //   389: aload 9
    //   391: invokevirtual 126	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   394: putfield 66	kotlin/l/b/a/b/e/a$s:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   397: goto -20 -> 377
    //   400: astore_1
    //   401: aload_0
    //   402: aload 9
    //   404: invokevirtual 126	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   407: putfield 66	kotlin/l/b/a/b/e/a$s:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   410: ldc 72
    //   412: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   415: aload_1
    //   416: athrow
    //   417: astore_2
    //   418: aload_0
    //   419: aload 9
    //   421: invokevirtual 126	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   424: putfield 66	kotlin/l/b/a/b/e/a$s:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   427: goto -173 -> 254
    //   430: astore_1
    //   431: aload_0
    //   432: aload 9
    //   434: invokevirtual 126	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   437: putfield 66	kotlin/l/b/a/b/e/a$s:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   440: ldc 72
    //   442: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   445: aload_1
    //   446: athrow
    //   447: goto -351 -> 96
    //   450: iconst_1
    //   451: istore 6
    //   453: goto -412 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	s
    //   0	456	1	parame	kotlin.l.b.a.b.h.e
    //   0	456	2	paramg	kotlin.l.b.a.b.h.g
    //   40	308	3	i	int
    //   59	131	4	j	int
    //   50	292	5	k	int
    //   37	415	6	m	int
    //   47	239	7	n	int
    //   53	287	8	i1	int
    //   26	407	9	localb	kotlin.l.b.a.b.h.d.b
    //   34	330	10	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	195	kotlin/l/b/a/b/h/l
    //   105	118	195	kotlin/l/b/a/b/h/l
    //   143	154	195	kotlin/l/b/a/b/h/l
    //   171	189	195	kotlin/l/b/a/b/h/l
    //   274	284	195	kotlin/l/b/a/b/h/l
    //   293	301	195	kotlin/l/b/a/b/h/l
    //   55	61	220	finally
    //   105	118	220	finally
    //   143	154	220	finally
    //   171	189	220	finally
    //   200	205	220	finally
    //   209	214	220	finally
    //   218	220	220	finally
    //   274	284	220	finally
    //   293	301	220	finally
    //   309	321	220	finally
    //   325	330	220	finally
    //   334	339	220	finally
    //   343	345	220	finally
    //   55	61	304	java/io/IOException
    //   105	118	304	java/io/IOException
    //   143	154	304	java/io/IOException
    //   171	189	304	java/io/IOException
    //   274	284	304	java/io/IOException
    //   293	301	304	java/io/IOException
    //   363	368	387	java/io/IOException
    //   363	368	400	finally
    //   240	245	417	java/io/IOException
    //   240	245	430	finally
  }
  
  private a$s(i.a parama)
  {
    super((byte)0);
    this.aiXZ = parama.aiXZ;
  }
  
  public static a d(s params)
  {
    AppMethodBeat.i(58954);
    params = a.kwB().g(params);
    AppMethodBeat.o(58954);
    return params;
  }
  
  private void ktf()
  {
    AppMethodBeat.i(58950);
    this.ajbo = Collections.emptyList();
    this.ajbp = -1;
    AppMethodBeat.o(58950);
  }
  
  public static s kww()
  {
    return ajbn;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58952);
    getSerializedSize();
    int i = 0;
    while (i < this.ajbo.size())
    {
      paramf.a(1, (r)this.ajbo.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x1) == 1) {
      paramf.cF(2, this.ajbp);
    }
    paramf.e(this.aiXZ);
    AppMethodBeat.o(58952);
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(58953);
    int i = this.dRJ;
    if (i != -1)
    {
      AppMethodBeat.o(58953);
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.ajbo.size())
    {
      i += f.c(1, (r)this.ajbo.get(j));
      j += 1;
    }
    j = i;
    if ((this.bitField0_ & 0x1) == 1) {
      j = i + f.cJ(2, this.ajbp);
    }
    i = this.aiXZ.size() + j;
    this.dRJ = i;
    AppMethodBeat.o(58953);
    return i;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58951);
    int i = this.memoizedIsInitialized;
    if (i == 1)
    {
      AppMethodBeat.o(58951);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58951);
      return false;
    }
    i = 0;
    while (i < this.ajbo.size())
    {
      if (!((a.p)this.ajbo.get(i)).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58951);
        return false;
      }
      i += 1;
    }
    this.memoizedIsInitialized = 1;
    AppMethodBeat.o(58951);
    return true;
  }
  
  public final boolean kwx()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public static final class a
    extends i.a<a.s, a>
    implements v
  {
    private List<a.p> ajbo;
    private int ajbp;
    private int bitField0_;
    
    private a()
    {
      AppMethodBeat.i(58932);
      this.ajbo = Collections.emptyList();
      this.ajbp = -1;
      AppMethodBeat.o(58932);
    }
    
    private a aLJ(int paramInt)
    {
      this.bitField0_ |= 0x2;
      this.ajbp = paramInt;
      return this;
    }
    
    private void kwA()
    {
      AppMethodBeat.i(58938);
      if ((this.bitField0_ & 0x1) != 1)
      {
        this.ajbo = new ArrayList(this.ajbo);
        this.bitField0_ |= 0x1;
      }
      AppMethodBeat.o(58938);
    }
    
    private a kwy()
    {
      AppMethodBeat.i(58933);
      a locala = new a().g(kwz());
      AppMethodBeat.o(58933);
      return locala;
    }
    
    /* Error */
    private a x(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 74
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 78	kotlin/l/b/a/b/e/a$s:aiYa	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 83 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$s
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 69	kotlin/l/b/a/b/e/a$s$a:g	(Lkotlin/l/b/a/b/e/a$s;)Lkotlin/l/b/a/b/e/a$s$a;
      //   30: pop
      //   31: ldc 74
      //   33: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 87	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   43: checkcast 9	kotlin/l/b/a/b/e/a$s
      //   46: astore_2
      //   47: ldc 74
      //   49: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: aload_2
      //   56: ifnull +9 -> 65
      //   59: aload_0
      //   60: aload_2
      //   61: invokevirtual 69	kotlin/l/b/a/b/e/a$s$a:g	(Lkotlin/l/b/a/b/e/a$s;)Lkotlin/l/b/a/b/e/a$s$a;
      //   64: pop
      //   65: ldc 74
      //   67: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   70: aload_1
      //   71: athrow
      //   72: astore_1
      //   73: aload_3
      //   74: astore_2
      //   75: goto -20 -> 55
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	a
      //   0	78	1	parame	kotlin.l.b.a.b.h.e
      //   0	78	2	paramg	kotlin.l.b.a.b.h.g
      //   6	68	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	kotlin/l/b/a/b/h/l
      //   47	54	54	finally
      //   7	21	72	finally
      //   39	47	72	finally
    }
    
    public final a g(a.s params)
    {
      AppMethodBeat.i(58935);
      if (params == a.s.kww())
      {
        AppMethodBeat.o(58935);
        return this;
      }
      if (!a.s.e(params).isEmpty())
      {
        if (!this.ajbo.isEmpty()) {
          break label100;
        }
        this.ajbo = a.s.e(params);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      for (;;)
      {
        if (params.kwx()) {
          aLJ(params.ajbp);
        }
        this.aiXZ = this.aiXZ.a(a.s.f(params));
        AppMethodBeat.o(58935);
        return this;
        label100:
        kwA();
        this.ajbo.addAll(a.s.e(params));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58936);
      int i = 0;
      while (i < this.ajbo.size())
      {
        if (!((a.p)this.ajbo.get(i)).isInitialized())
        {
          AppMethodBeat.o(58936);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(58936);
      return true;
    }
    
    public final a.s kwz()
    {
      int i = 1;
      AppMethodBeat.i(58934);
      a.s locals = new a.s(this, (byte)0);
      int j = this.bitField0_;
      if ((this.bitField0_ & 0x1) == 1)
      {
        this.ajbo = Collections.unmodifiableList(this.ajbo);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      a.s.a(locals, this.ajbo);
      if ((j & 0x2) == 2) {}
      for (;;)
      {
        a.s.a(locals, this.ajbp);
        a.s.b(locals, i);
        AppMethodBeat.o(58934);
        return locals;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.s
 * JD-Core Version:    0.7.0.1
 */