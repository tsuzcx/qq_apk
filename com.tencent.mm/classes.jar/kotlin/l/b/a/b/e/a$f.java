package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.h;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.i.b;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.c.a;
import kotlin.l.b.a.b.h.s;

public final class a$f
  extends i.c<f>
  implements i
{
  public static s<f> TwL;
  private static final f Tyj;
  private final d TwK;
  public int Tyk;
  private int bOT;
  private byte bPe = -1;
  private int bVY = -1;
  
  static
  {
    AppMethodBeat.i(58550);
    TwL = new b() {};
    f localf = new f();
    Tyj = localf;
    localf.Tyk = 0;
    AppMethodBeat.o(58550);
  }
  
  private a$f()
  {
    this.TwK = d.TDp;
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
    //   13: putfield 54	kotlin/l/b/a/b/e/a$f:bPe	B
    //   16: aload_0
    //   17: iconst_m1
    //   18: putfield 56	kotlin/l/b/a/b/e/a$f:bVY	I
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 47	kotlin/l/b/a/b/e/a$f:Tyk	I
    //   26: invokestatic 73	kotlin/l/b/a/b/h/d:hJo	()Lkotlin/l/b/a/b/h/d$b;
    //   29: astore 5
    //   31: aload 5
    //   33: iconst_1
    //   34: invokestatic 78	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   37: astore 6
    //   39: iload_3
    //   40: ifne +117 -> 157
    //   43: aload_1
    //   44: invokevirtual 84	kotlin/l/b/a/b/h/e:yT	()I
    //   47: istore 4
    //   49: iload 4
    //   51: lookupswitch	default:+218->269, 0:+221->272, 8:+43->94
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
    //   96: getfield 89	kotlin/l/b/a/b/e/a$f:bOT	I
    //   99: iconst_1
    //   100: ior
    //   101: putfield 89	kotlin/l/b/a/b/e/a$f:bOT	I
    //   104: aload_0
    //   105: aload_1
    //   106: invokevirtual 92	kotlin/l/b/a/b/h/e:zi	()I
    //   109: putfield 47	kotlin/l/b/a/b/e/a$f:Tyk	I
    //   112: goto -73 -> 39
    //   115: astore_1
    //   116: aload_1
    //   117: aload_0
    //   118: putfield 96	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   121: ldc 69
    //   123: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload 6
    //   131: invokevirtual 99	kotlin/l/b/a/b/h/f:flush	()V
    //   134: aload_0
    //   135: aload 5
    //   137: invokevirtual 105	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   140: putfield 63	kotlin/l/b/a/b/e/a$f:TwK	Lkotlin/l/b/a/b/h/d;
    //   143: aload_0
    //   144: getfield 109	kotlin/l/b/a/b/h/i$c:TDA	Lkotlin/l/b/a/b/h/h;
    //   147: invokevirtual 114	kotlin/l/b/a/b/h/h:yK	()V
    //   150: ldc 69
    //   152: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload_1
    //   156: athrow
    //   157: aload 6
    //   159: invokevirtual 99	kotlin/l/b/a/b/h/f:flush	()V
    //   162: aload_0
    //   163: aload 5
    //   165: invokevirtual 105	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   168: putfield 63	kotlin/l/b/a/b/e/a$f:TwK	Lkotlin/l/b/a/b/h/d;
    //   171: aload_0
    //   172: getfield 109	kotlin/l/b/a/b/h/i$c:TDA	Lkotlin/l/b/a/b/h/h;
    //   175: invokevirtual 114	kotlin/l/b/a/b/h/h:yK	()V
    //   178: ldc 69
    //   180: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: return
    //   184: astore_1
    //   185: aload_0
    //   186: aload 5
    //   188: invokevirtual 105	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   191: putfield 63	kotlin/l/b/a/b/e/a$f:TwK	Lkotlin/l/b/a/b/h/d;
    //   194: goto -23 -> 171
    //   197: astore_1
    //   198: aload_0
    //   199: aload 5
    //   201: invokevirtual 105	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   204: putfield 63	kotlin/l/b/a/b/e/a$f:TwK	Lkotlin/l/b/a/b/h/d;
    //   207: ldc 69
    //   209: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_1
    //   213: athrow
    //   214: astore_1
    //   215: new 66	kotlin/l/b/a/b/h/k
    //   218: dup
    //   219: aload_1
    //   220: invokevirtual 118	java/io/IOException:getMessage	()Ljava/lang/String;
    //   223: invokespecial 121	kotlin/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   226: astore_1
    //   227: aload_1
    //   228: aload_0
    //   229: putfield 96	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   232: ldc 69
    //   234: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_1
    //   238: athrow
    //   239: astore_2
    //   240: aload_0
    //   241: aload 5
    //   243: invokevirtual 105	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   246: putfield 63	kotlin/l/b/a/b/e/a$f:TwK	Lkotlin/l/b/a/b/h/d;
    //   249: goto -106 -> 143
    //   252: astore_1
    //   253: aload_0
    //   254: aload 5
    //   256: invokevirtual 105	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   259: putfield 63	kotlin/l/b/a/b/e/a$f:TwK	Lkotlin/l/b/a/b/h/d;
    //   262: ldc 69
    //   264: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: aload_1
    //   268: athrow
    //   269: goto -193 -> 76
    //   272: iconst_1
    //   273: istore_3
    //   274: goto -235 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	f
    //   0	277	1	parame	kotlin.l.b.a.b.h.e
    //   0	277	2	paramg	kotlin.l.b.a.b.h.g
    //   1	273	3	i	int
    //   47	35	4	j	int
    //   29	226	5	localb	kotlin.l.b.a.b.h.d.b
    //   37	121	6	localf	f
    // Exception table:
    //   from	to	target	type
    //   43	49	115	kotlin/l/b/a/b/h/k
    //   76	89	115	kotlin/l/b/a/b/h/k
    //   94	112	115	kotlin/l/b/a/b/h/k
    //   43	49	128	finally
    //   76	89	128	finally
    //   94	112	128	finally
    //   116	128	128	finally
    //   215	239	128	finally
    //   157	162	184	java/io/IOException
    //   157	162	197	finally
    //   43	49	214	java/io/IOException
    //   76	89	214	java/io/IOException
    //   94	112	214	java/io/IOException
    //   129	134	239	java/io/IOException
    //   129	134	252	finally
  }
  
  private a$f(i.b<f, ?> paramb)
  {
    super(paramb);
    this.TwK = paramb.TwK;
  }
  
  public static f hFL()
  {
    return Tyj;
  }
  
  public final boolean Az()
  {
    return (this.bOT & 0x1) == 1;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58546);
    yC();
    i.c.a locala = hJC();
    if ((this.bOT & 0x1) == 1) {
      paramf.bs(1, this.Tyk);
    }
    locala.b(200, paramf);
    paramf.e(this.TwK);
    AppMethodBeat.o(58546);
  }
  
  public final s<f> hEs()
  {
    return TwL;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58545);
    int i = this.bPe;
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
    if (!this.TDA.isInitialized())
    {
      this.bPe = 0;
      AppMethodBeat.o(58545);
      return false;
    }
    this.bPe = 1;
    AppMethodBeat.o(58545);
    return true;
  }
  
  public final int yC()
  {
    AppMethodBeat.i(58547);
    int i = this.bVY;
    if (i != -1)
    {
      AppMethodBeat.o(58547);
      return i;
    }
    i = 0;
    if ((this.bOT & 0x1) == 1) {
      i = f.bu(1, this.Tyk) + 0;
    }
    i = i + this.TDA.yC() + this.TwK.size();
    this.bVY = i;
    AppMethodBeat.o(58547);
    return i;
  }
  
  public static final class a
    extends i.b<a.f, a>
    implements i
  {
    private int Tyk;
    private int bOT;
    
    private a auj(int paramInt)
    {
      this.bOT |= 0x1;
      this.Tyk = paramInt;
      return this;
    }
    
    private a hFM()
    {
      AppMethodBeat.i(58528);
      a locala = new a().b(hFN());
      AppMethodBeat.o(58528);
      return locala;
    }
    
    private a.f hFN()
    {
      int i = 1;
      AppMethodBeat.i(58529);
      a.f localf = new a.f(this, (byte)0);
      if ((this.bOT & 0x1) == 1) {}
      for (;;)
      {
        a.f.a(localf, this.Tyk);
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
      //   7: getstatic 68	kotlin/l/b/a/b/e/a$f:TwL	Lkotlin/l/b/a/b/h/s;
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
      //   36: getfield 77	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
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
      //   7	21	34	kotlin/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a b(a.f paramf)
    {
      AppMethodBeat.i(58530);
      if (paramf == a.f.hFL())
      {
        AppMethodBeat.o(58530);
        return this;
      }
      if (paramf.Az()) {
        auj(paramf.Tyk);
      }
      a(paramf);
      this.TwK = this.TwK.a(a.f.a(paramf));
      AppMethodBeat.o(58530);
      return this;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58531);
      if (!this.TDA.isInitialized())
      {
        AppMethodBeat.o(58531);
        return false;
      }
      AppMethodBeat.o(58531);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.f
 * JD-Core Version:    0.7.0.1
 */