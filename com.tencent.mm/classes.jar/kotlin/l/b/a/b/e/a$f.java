package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.i.b;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.c.a;
import kotlin.l.b.a.b.h.t;

public final class a$f
  extends i.c<f>
  implements i
{
  public static t<f> aiYa;
  private static final f aiZB;
  private final d aiXZ;
  public int aiZC;
  private int bitField0_;
  private int dRJ = -1;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(58550);
    aiYa = new b() {};
    f localf = new f();
    aiZB = localf;
    localf.aiZC = 0;
    AppMethodBeat.o(58550);
  }
  
  private a$f()
  {
    this.aiXZ = d.ajeU;
  }
  
  /* Error */
  private a$f(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: invokespecial 52	kotlin/l/b/a/b/h/i$c:<init>	()V
    //   6: ldc 69
    //   8: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: iconst_m1
    //   13: putfield 54	kotlin/l/b/a/b/e/a$f:memoizedIsInitialized	B
    //   16: aload_0
    //   17: iconst_m1
    //   18: putfield 56	kotlin/l/b/a/b/e/a$f:dRJ	I
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 47	kotlin/l/b/a/b/e/a$f:aiZC	I
    //   26: invokestatic 73	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
    //   29: astore 5
    //   31: aload 5
    //   33: iconst_1
    //   34: invokestatic 78	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   37: astore 6
    //   39: iload_3
    //   40: ifne +114 -> 154
    //   43: aload_1
    //   44: invokevirtual 84	kotlin/l/b/a/b/h/e:aac	()I
    //   47: istore 4
    //   49: iload 4
    //   51: lookupswitch	default:+212->263, 0:+215->266, 8:+43->94
    //   77: aload_1
    //   78: aload 6
    //   80: aload_2
    //   81: iload 4
    //   83: invokevirtual 87	kotlin/l/b/a/b/e/a$f:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   86: ifne -47 -> 39
    //   89: iconst_1
    //   90: istore_3
    //   91: goto -52 -> 39
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 89	kotlin/l/b/a/b/e/a$f:bitField0_	I
    //   99: iconst_1
    //   100: ior
    //   101: putfield 89	kotlin/l/b/a/b/e/a$f:bitField0_	I
    //   104: aload_0
    //   105: aload_1
    //   106: invokevirtual 92	kotlin/l/b/a/b/h/e:aar	()I
    //   109: putfield 47	kotlin/l/b/a/b/e/a$f:aiZC	I
    //   112: goto -73 -> 39
    //   115: astore_1
    //   116: aload_1
    //   117: aload_0
    //   118: putfield 96	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   121: ldc 69
    //   123: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload 6
    //   131: invokevirtual 99	kotlin/l/b/a/b/h/f:flush	()V
    //   134: aload_0
    //   135: aload 5
    //   137: invokevirtual 105	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   140: putfield 63	kotlin/l/b/a/b/e/a$f:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   143: aload_0
    //   144: invokevirtual 108	kotlin/l/b/a/b/e/a$f:makeExtensionsImmutable	()V
    //   147: ldc 69
    //   149: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_1
    //   153: athrow
    //   154: aload 6
    //   156: invokevirtual 99	kotlin/l/b/a/b/h/f:flush	()V
    //   159: aload_0
    //   160: aload 5
    //   162: invokevirtual 105	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   165: putfield 63	kotlin/l/b/a/b/e/a$f:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   168: aload_0
    //   169: invokevirtual 108	kotlin/l/b/a/b/e/a$f:makeExtensionsImmutable	()V
    //   172: ldc 69
    //   174: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: return
    //   178: astore_1
    //   179: aload_0
    //   180: aload 5
    //   182: invokevirtual 105	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   185: putfield 63	kotlin/l/b/a/b/e/a$f:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   188: goto -20 -> 168
    //   191: astore_1
    //   192: aload_0
    //   193: aload 5
    //   195: invokevirtual 105	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   198: putfield 63	kotlin/l/b/a/b/e/a$f:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   201: ldc 69
    //   203: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_1
    //   207: athrow
    //   208: astore_1
    //   209: new 66	kotlin/l/b/a/b/h/l
    //   212: dup
    //   213: aload_1
    //   214: invokevirtual 112	java/io/IOException:getMessage	()Ljava/lang/String;
    //   217: invokespecial 115	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   220: astore_1
    //   221: aload_1
    //   222: aload_0
    //   223: putfield 96	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   226: ldc 69
    //   228: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aload_1
    //   232: athrow
    //   233: astore_2
    //   234: aload_0
    //   235: aload 5
    //   237: invokevirtual 105	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   240: putfield 63	kotlin/l/b/a/b/e/a$f:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   243: goto -100 -> 143
    //   246: astore_1
    //   247: aload_0
    //   248: aload 5
    //   250: invokevirtual 105	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   253: putfield 63	kotlin/l/b/a/b/e/a$f:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   256: ldc 69
    //   258: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: aload_1
    //   262: athrow
    //   263: goto -187 -> 76
    //   266: iconst_1
    //   267: istore_3
    //   268: goto -229 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	f
    //   0	271	1	parame	kotlin.l.b.a.b.h.e
    //   0	271	2	paramg	kotlin.l.b.a.b.h.g
    //   1	267	3	i	int
    //   47	35	4	j	int
    //   29	220	5	localb	kotlin.l.b.a.b.h.d.b
    //   37	118	6	localf	f
    // Exception table:
    //   from	to	target	type
    //   43	49	115	kotlin/l/b/a/b/h/l
    //   76	89	115	kotlin/l/b/a/b/h/l
    //   94	112	115	kotlin/l/b/a/b/h/l
    //   43	49	128	finally
    //   76	89	128	finally
    //   94	112	128	finally
    //   116	128	128	finally
    //   209	233	128	finally
    //   154	159	178	java/io/IOException
    //   154	159	191	finally
    //   43	49	208	java/io/IOException
    //   76	89	208	java/io/IOException
    //   94	112	208	java/io/IOException
    //   129	134	233	java/io/IOException
    //   129	134	246	finally
  }
  
  private a$f(i.b<f, ?> paramb)
  {
    super(paramb);
    this.aiXZ = paramb.aiXZ;
  }
  
  public static f kuA()
  {
    return aiZB;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58546);
    getSerializedSize();
    i.c.a locala = kym();
    if ((this.bitField0_ & 0x1) == 1) {
      paramf.cF(1, this.aiZC);
    }
    locala.b(200, paramf);
    paramf.e(this.aiXZ);
    AppMethodBeat.o(58546);
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(58547);
    int i = this.dRJ;
    if (i != -1)
    {
      AppMethodBeat.o(58547);
      return i;
    }
    i = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      i = f.cJ(1, this.aiZC) + 0;
    }
    i = i + aie() + this.aiXZ.size();
    this.dRJ = i;
    AppMethodBeat.o(58547);
    return i;
  }
  
  public final boolean hasName()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58545);
    int i = this.memoizedIsInitialized;
    if (i == 1)
    {
      AppMethodBeat.o(58545);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58545);
      return false;
    }
    if (!aic())
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58545);
      return false;
    }
    this.memoizedIsInitialized = 1;
    AppMethodBeat.o(58545);
    return true;
  }
  
  public static final class a
    extends i.b<a.f, a>
    implements i
  {
    private int aiZC;
    private int bitField0_;
    
    private a aKU(int paramInt)
    {
      this.bitField0_ |= 0x1;
      this.aiZC = paramInt;
      return this;
    }
    
    /* Error */
    private a k(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 32
      //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 42	kotlin/l/b/a/b/e/a$f:aiYa	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 47 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$f
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 51	kotlin/l/b/a/b/e/a$f$a:b	(Lkotlin/l/b/a/b/e/a$f;)Lkotlin/l/b/a/b/e/a$f$a;
      //   30: pop
      //   31: ldc 32
      //   33: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 58	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   43: checkcast 9	kotlin/l/b/a/b/e/a$f
      //   46: astore_2
      //   47: ldc 32
      //   49: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: aload_2
      //   56: ifnull +9 -> 65
      //   59: aload_0
      //   60: aload_2
      //   61: invokevirtual 51	kotlin/l/b/a/b/e/a$f$a:b	(Lkotlin/l/b/a/b/e/a$f;)Lkotlin/l/b/a/b/e/a$f$a;
      //   64: pop
      //   65: ldc 32
      //   67: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private a kuB()
    {
      AppMethodBeat.i(58528);
      a locala = new a().b(kuC());
      AppMethodBeat.o(58528);
      return locala;
    }
    
    private a.f kuC()
    {
      int i = 1;
      AppMethodBeat.i(58529);
      a.f localf = new a.f(this, (byte)0);
      if ((this.bitField0_ & 0x1) == 1) {}
      for (;;)
      {
        a.f.a(localf, this.aiZC);
        a.f.b(localf, i);
        AppMethodBeat.o(58529);
        return localf;
        i = 0;
      }
    }
    
    public final a b(a.f paramf)
    {
      AppMethodBeat.i(58530);
      if (paramf == a.f.kuA())
      {
        AppMethodBeat.o(58530);
        return this;
      }
      if (paramf.hasName()) {
        aKU(paramf.aiZC);
      }
      a(paramf);
      this.aiXZ = this.aiXZ.a(a.f.a(paramf));
      AppMethodBeat.o(58530);
      return this;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58531);
      if (!aic())
      {
        AppMethodBeat.o(58531);
        return false;
      }
      AppMethodBeat.o(58531);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.f
 * JD-Core Version:    0.7.0.1
 */