package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.b;
import d.l.b.a.b.h.d;
import d.l.b.a.b.h.f;
import d.l.b.a.b.h.h;
import d.l.b.a.b.h.i.a;
import d.l.b.a.b.h.i.b;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.h.i.c.a;
import d.l.b.a.b.h.s;

public final class a$f
  extends i.c<f>
  implements i
{
  public static s<f> NHf;
  private static final f NIH;
  private final d NHe;
  private int NHg;
  private byte NHj = -1;
  private int NHk = -1;
  public int NII;
  
  static
  {
    AppMethodBeat.i(58550);
    NHf = new b() {};
    f localf = new f();
    NIH = localf;
    localf.NII = 0;
    AppMethodBeat.o(58550);
  }
  
  private a$f()
  {
    this.NHe = d.NNO;
  }
  
  /* Error */
  private a$f(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: invokespecial 52	d/l/b/a/b/h/i$c:<init>	()V
    //   6: ldc 69
    //   8: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: iconst_m1
    //   13: putfield 54	d/l/b/a/b/e/a$f:NHj	B
    //   16: aload_0
    //   17: iconst_m1
    //   18: putfield 56	d/l/b/a/b/e/a$f:NHk	I
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 47	d/l/b/a/b/e/a$f:NII	I
    //   26: invokestatic 73	d/l/b/a/b/h/d:gvT	()Ld/l/b/a/b/h/d$b;
    //   29: astore 5
    //   31: aload 5
    //   33: iconst_1
    //   34: invokestatic 78	d/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Ld/l/b/a/b/h/f;
    //   37: astore 6
    //   39: iload_3
    //   40: ifne +117 -> 157
    //   43: aload_1
    //   44: invokevirtual 84	d/l/b/a/b/h/e:zb	()I
    //   47: istore 4
    //   49: iload 4
    //   51: lookupswitch	default:+218->269, 0:+221->272, 8:+43->94
    //   77: aload_1
    //   78: aload 6
    //   80: aload_2
    //   81: iload 4
    //   83: invokevirtual 87	d/l/b/a/b/e/a$f:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/f;Ld/l/b/a/b/h/g;I)Z
    //   86: ifne -47 -> 39
    //   89: iconst_1
    //   90: istore_3
    //   91: goto -52 -> 39
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 89	d/l/b/a/b/e/a$f:NHg	I
    //   99: iconst_1
    //   100: ior
    //   101: putfield 89	d/l/b/a/b/e/a$f:NHg	I
    //   104: aload_0
    //   105: aload_1
    //   106: invokevirtual 92	d/l/b/a/b/h/e:zc	()I
    //   109: putfield 47	d/l/b/a/b/e/a$f:NII	I
    //   112: goto -73 -> 39
    //   115: astore_1
    //   116: aload_1
    //   117: aload_0
    //   118: putfield 96	d/l/b/a/b/h/k:NOw	Ld/l/b/a/b/h/q;
    //   121: ldc 69
    //   123: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload 6
    //   131: invokevirtual 99	d/l/b/a/b/h/f:flush	()V
    //   134: aload_0
    //   135: aload 5
    //   137: invokevirtual 105	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   140: putfield 63	d/l/b/a/b/e/a$f:NHe	Ld/l/b/a/b/h/d;
    //   143: aload_0
    //   144: getfield 109	d/l/b/a/b/h/i$c:NOg	Ld/l/b/a/b/h/h;
    //   147: invokevirtual 114	d/l/b/a/b/h/h:gwj	()V
    //   150: ldc 69
    //   152: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload_1
    //   156: athrow
    //   157: aload 6
    //   159: invokevirtual 99	d/l/b/a/b/h/f:flush	()V
    //   162: aload_0
    //   163: aload 5
    //   165: invokevirtual 105	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   168: putfield 63	d/l/b/a/b/e/a$f:NHe	Ld/l/b/a/b/h/d;
    //   171: aload_0
    //   172: getfield 109	d/l/b/a/b/h/i$c:NOg	Ld/l/b/a/b/h/h;
    //   175: invokevirtual 114	d/l/b/a/b/h/h:gwj	()V
    //   178: ldc 69
    //   180: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: return
    //   184: astore_1
    //   185: aload_0
    //   186: aload 5
    //   188: invokevirtual 105	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   191: putfield 63	d/l/b/a/b/e/a$f:NHe	Ld/l/b/a/b/h/d;
    //   194: goto -23 -> 171
    //   197: astore_1
    //   198: aload_0
    //   199: aload 5
    //   201: invokevirtual 105	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   204: putfield 63	d/l/b/a/b/e/a$f:NHe	Ld/l/b/a/b/h/d;
    //   207: ldc 69
    //   209: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_1
    //   213: athrow
    //   214: astore_1
    //   215: new 66	d/l/b/a/b/h/k
    //   218: dup
    //   219: aload_1
    //   220: invokevirtual 118	java/io/IOException:getMessage	()Ljava/lang/String;
    //   223: invokespecial 121	d/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   226: astore_1
    //   227: aload_1
    //   228: aload_0
    //   229: putfield 96	d/l/b/a/b/h/k:NOw	Ld/l/b/a/b/h/q;
    //   232: ldc 69
    //   234: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_1
    //   238: athrow
    //   239: astore_2
    //   240: aload_0
    //   241: aload 5
    //   243: invokevirtual 105	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   246: putfield 63	d/l/b/a/b/e/a$f:NHe	Ld/l/b/a/b/h/d;
    //   249: goto -106 -> 143
    //   252: astore_1
    //   253: aload_0
    //   254: aload 5
    //   256: invokevirtual 105	d/l/b/a/b/h/d$b:gvX	()Ld/l/b/a/b/h/d;
    //   259: putfield 63	d/l/b/a/b/e/a$f:NHe	Ld/l/b/a/b/h/d;
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
    //   0	277	1	parame	d.l.b.a.b.h.e
    //   0	277	2	paramg	d.l.b.a.b.h.g
    //   1	273	3	i	int
    //   47	35	4	j	int
    //   29	226	5	localb	d.l.b.a.b.h.d.b
    //   37	121	6	localf	f
    // Exception table:
    //   from	to	target	type
    //   43	49	115	d/l/b/a/b/h/k
    //   76	89	115	d/l/b/a/b/h/k
    //   94	112	115	d/l/b/a/b/h/k
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
    this.NHe = paramb.NHe;
  }
  
  public static f gsm()
  {
    return NIH;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58546);
    zp();
    i.c.a locala = gwq();
    if ((this.NHg & 0x1) == 1) {
      paramf.bx(1, this.NII);
    }
    locala.b(200, paramf);
    paramf.e(this.NHe);
    AppMethodBeat.o(58546);
  }
  
  public final s<f> gqQ()
  {
    return NHf;
  }
  
  public final boolean gsn()
  {
    return (this.NHg & 0x1) == 1;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58545);
    int i = this.NHj;
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
    if (!this.NOg.isInitialized())
    {
      this.NHj = 0;
      AppMethodBeat.o(58545);
      return false;
    }
    this.NHj = 1;
    AppMethodBeat.o(58545);
    return true;
  }
  
  public final int zp()
  {
    AppMethodBeat.i(58547);
    int i = this.NHk;
    if (i != -1)
    {
      AppMethodBeat.o(58547);
      return i;
    }
    i = 0;
    if ((this.NHg & 0x1) == 1) {
      i = f.bz(1, this.NII) + 0;
    }
    i = i + this.NOg.zp() + this.NHe.size();
    this.NHk = i;
    AppMethodBeat.o(58547);
    return i;
  }
  
  public static final class a
    extends i.b<a.f, a>
    implements i
  {
    private int NHg;
    private int NII;
    
    private a akt(int paramInt)
    {
      this.NHg |= 0x1;
      this.NII = paramInt;
      return this;
    }
    
    private a gso()
    {
      AppMethodBeat.i(58528);
      a locala = new a().b(gsp());
      AppMethodBeat.o(58528);
      return locala;
    }
    
    private a.f gsp()
    {
      int i = 1;
      AppMethodBeat.i(58529);
      a.f localf = new a.f(this, (byte)0);
      if ((this.NHg & 0x1) == 1) {}
      for (;;)
      {
        a.f.a(localf, this.NII);
        a.f.b(localf, i);
        AppMethodBeat.o(58529);
        return localf;
        i = 0;
      }
    }
    
    /* Error */
    private a k(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 64
      //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 68	d/l/b/a/b/e/a$f:NHf	Ld/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 73 3 0
      //   17: checkcast 9	d/l/b/a/b/e/a$f
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 45	d/l/b/a/b/e/a$f$a:b	(Ld/l/b/a/b/e/a$f;)Ld/l/b/a/b/e/a$f$a;
      //   26: pop
      //   27: ldc 64
      //   29: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 77	d/l/b/a/b/h/k:NOw	Ld/l/b/a/b/h/q;
      //   39: checkcast 9	d/l/b/a/b/e/a$f
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
      //   57: invokevirtual 45	d/l/b/a/b/e/a$f$a:b	(Ld/l/b/a/b/e/a$f;)Ld/l/b/a/b/e/a$f$a;
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
      //   0	74	1	parame	d.l.b.a.b.h.e
      //   0	74	2	paramg	d.l.b.a.b.h.g
      //   6	64	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	d/l/b/a/b/h/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a b(a.f paramf)
    {
      AppMethodBeat.i(58530);
      if (paramf == a.f.gsm())
      {
        AppMethodBeat.o(58530);
        return this;
      }
      if (paramf.gsn()) {
        akt(paramf.NII);
      }
      a(paramf);
      this.NHe = this.NHe.a(a.f.a(paramf));
      AppMethodBeat.o(58530);
      return this;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58531);
      if (!this.NOg.isInitialized())
      {
        AppMethodBeat.o(58531);
        return false;
      }
      AppMethodBeat.o(58531);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     d.l.b.a.b.e.a.f
 * JD-Core Version:    0.7.0.1
 */