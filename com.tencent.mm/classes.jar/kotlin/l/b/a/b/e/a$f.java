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
  public static t<f> aaZC;
  private static final f abba;
  private final d aaZB;
  public int abbb;
  private int bQS;
  private byte bRd = -1;
  private int bXW = -1;
  
  static
  {
    AppMethodBeat.i(58550);
    aaZC = new b() {};
    f localf = new f();
    abba = localf;
    localf.abbb = 0;
    AppMethodBeat.o(58550);
  }
  
  private a$f()
  {
    this.aaZB = d.abgb;
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
    //   13: putfield 54	kotlin/l/b/a/b/e/a$f:bRd	B
    //   16: aload_0
    //   17: iconst_m1
    //   18: putfield 56	kotlin/l/b/a/b/e/a$f:bXW	I
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 47	kotlin/l/b/a/b/e/a$f:abbb	I
    //   26: invokestatic 73	kotlin/l/b/a/b/h/d:iNH	()Lkotlin/l/b/a/b/h/d$b;
    //   29: astore 5
    //   31: aload 5
    //   33: iconst_1
    //   34: invokestatic 78	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   37: astore 6
    //   39: iload_3
    //   40: ifne +114 -> 154
    //   43: aload_1
    //   44: invokevirtual 84	kotlin/l/b/a/b/h/e:Av	()I
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
    //   96: getfield 89	kotlin/l/b/a/b/e/a$f:bQS	I
    //   99: iconst_1
    //   100: ior
    //   101: putfield 89	kotlin/l/b/a/b/e/a$f:bQS	I
    //   104: aload_0
    //   105: aload_1
    //   106: invokevirtual 92	kotlin/l/b/a/b/h/e:AK	()I
    //   109: putfield 47	kotlin/l/b/a/b/e/a$f:abbb	I
    //   112: goto -73 -> 39
    //   115: astore_1
    //   116: aload_1
    //   117: aload_0
    //   118: putfield 96	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   121: ldc 69
    //   123: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload 6
    //   131: invokevirtual 99	kotlin/l/b/a/b/h/f:flush	()V
    //   134: aload_0
    //   135: aload 5
    //   137: invokevirtual 105	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   140: putfield 63	kotlin/l/b/a/b/e/a$f:aaZB	Lkotlin/l/b/a/b/h/d;
    //   143: aload_0
    //   144: invokevirtual 108	kotlin/l/b/a/b/e/a$f:HZ	()V
    //   147: ldc 69
    //   149: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_1
    //   153: athrow
    //   154: aload 6
    //   156: invokevirtual 99	kotlin/l/b/a/b/h/f:flush	()V
    //   159: aload_0
    //   160: aload 5
    //   162: invokevirtual 105	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   165: putfield 63	kotlin/l/b/a/b/e/a$f:aaZB	Lkotlin/l/b/a/b/h/d;
    //   168: aload_0
    //   169: invokevirtual 108	kotlin/l/b/a/b/e/a$f:HZ	()V
    //   172: ldc 69
    //   174: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: return
    //   178: astore_1
    //   179: aload_0
    //   180: aload 5
    //   182: invokevirtual 105	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   185: putfield 63	kotlin/l/b/a/b/e/a$f:aaZB	Lkotlin/l/b/a/b/h/d;
    //   188: goto -20 -> 168
    //   191: astore_1
    //   192: aload_0
    //   193: aload 5
    //   195: invokevirtual 105	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   198: putfield 63	kotlin/l/b/a/b/e/a$f:aaZB	Lkotlin/l/b/a/b/h/d;
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
    //   223: putfield 96	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   226: ldc 69
    //   228: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aload_1
    //   232: athrow
    //   233: astore_2
    //   234: aload_0
    //   235: aload 5
    //   237: invokevirtual 105	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   240: putfield 63	kotlin/l/b/a/b/e/a$f:aaZB	Lkotlin/l/b/a/b/h/d;
    //   243: goto -100 -> 143
    //   246: astore_1
    //   247: aload_0
    //   248: aload 5
    //   250: invokevirtual 105	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   253: putfield 63	kotlin/l/b/a/b/e/a$f:aaZB	Lkotlin/l/b/a/b/h/d;
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
    this.aaZB = paramb.aaZB;
  }
  
  public static f iKf()
  {
    return abba;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(58547);
    int i = this.bXW;
    if (i != -1)
    {
      AppMethodBeat.o(58547);
      return i;
    }
    i = 0;
    if ((this.bQS & 0x1) == 1) {
      i = f.bM(1, this.abbb) + 0;
    }
    i = i + Ii() + this.aaZB.size();
    this.bXW = i;
    AppMethodBeat.o(58547);
    return i;
  }
  
  public final boolean Cc()
  {
    return (this.bQS & 0x1) == 1;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58546);
    Ad();
    i.c.a locala = iNU();
    if ((this.bQS & 0x1) == 1) {
      paramf.bJ(1, this.abbb);
    }
    locala.b(200, paramf);
    paramf.e(this.aaZB);
    AppMethodBeat.o(58546);
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58545);
    int i = this.bRd;
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
    if (!Ig())
    {
      this.bRd = 0;
      AppMethodBeat.o(58545);
      return false;
    }
    this.bRd = 1;
    AppMethodBeat.o(58545);
    return true;
  }
  
  public static final class a
    extends i.b<a.f, a>
    implements i
  {
    private int abbb;
    private int bQS;
    
    private a aEd(int paramInt)
    {
      this.bQS |= 0x1;
      this.abbb = paramInt;
      return this;
    }
    
    private a iKg()
    {
      AppMethodBeat.i(58528);
      a locala = new a().b(iKh());
      AppMethodBeat.o(58528);
      return locala;
    }
    
    private a.f iKh()
    {
      int i = 1;
      AppMethodBeat.i(58529);
      a.f localf = new a.f(this, (byte)0);
      if ((this.bQS & 0x1) == 1) {}
      for (;;)
      {
        a.f.a(localf, this.abbb);
        a.f.b(localf, i);
        AppMethodBeat.o(58529);
        return localf;
        i = 0;
      }
    }
    
    /* Error */
    private a k(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 64
      //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 68	kotlin/l/b/a/b/e/a$f:aaZC	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 73 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$f
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 45	kotlin/l/b/a/b/e/a$f$a:b	(Lkotlin/l/b/a/b/e/a$f;)Lkotlin/l/b/a/b/e/a$f$a;
      //   26: pop
      //   27: ldc 64
      //   29: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 77	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
      //   39: checkcast 9	kotlin/l/b/a/b/e/a$f
      //   42: astore_2
      //   43: ldc 64
      //   45: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 45	kotlin/l/b/a/b/e/a$f$a:b	(Lkotlin/l/b/a/b/e/a$f;)Lkotlin/l/b/a/b/e/a$f$a;
      //   60: pop
      //   61: ldc 64
      //   63: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: aload_1
      //   67: athrow
      //   68: astore_1
      //   69: aload_3
      //   70: astore_2
      //   71: goto -20 -> 51
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	a
      //   0	74	1	parame	kotlin.l.b.a.b.h.e
      //   0	74	2	paramg	kotlin.l.b.a.b.h.g
      //   6	64	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	kotlin/l/b/a/b/h/l
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a b(a.f paramf)
    {
      AppMethodBeat.i(58530);
      if (paramf == a.f.iKf())
      {
        AppMethodBeat.o(58530);
        return this;
      }
      if (paramf.Cc()) {
        aEd(paramf.abbb);
      }
      a(paramf);
      this.aaZB = this.aaZB.a(a.f.a(paramf));
      AppMethodBeat.o(58530);
      return this;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58531);
      if (!Ig())
      {
        AppMethodBeat.o(58531);
        return false;
      }
      AppMethodBeat.o(58531);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.f
 * JD-Core Version:    0.7.0.1
 */