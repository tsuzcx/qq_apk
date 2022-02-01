package kotlin.l.b.a.b.e.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.s;

public final class a$a
  extends i
  implements b
{
  private static final a TBW;
  public static s<a> TwL;
  public int TBX;
  private final d TwK;
  public int Tyk;
  private int bOT;
  private byte bPe = -1;
  private int bVY = -1;
  
  static
  {
    AppMethodBeat.i(59109);
    TwL = new kotlin.l.b.a.b.h.b() {};
    a locala = new a();
    TBW = locala;
    locala.hEu();
    AppMethodBeat.o(59109);
  }
  
  private a$a()
  {
    this.TwK = d.TDp;
  }
  
  /* Error */
  private a$a(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 52	kotlin/l/b/a/b/h/i:<init>	()V
    //   4: ldc 69
    //   6: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 54	kotlin/l/b/a/b/e/c/a$a:bPe	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 56	kotlin/l/b/a/b/e/c/a$a:bVY	I
    //   19: aload_0
    //   20: invokespecial 47	kotlin/l/b/a/b/e/c/a$a:hEu	()V
    //   23: invokestatic 73	kotlin/l/b/a/b/h/d:hJo	()Lkotlin/l/b/a/b/h/d$b;
    //   26: astore 5
    //   28: aload 5
    //   30: iconst_1
    //   31: invokestatic 79	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   34: astore 6
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +169 -> 208
    //   42: aload_1
    //   43: invokevirtual 85	kotlin/l/b/a/b/h/e:yT	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+242->292, 0:+245->295, 8:+52->102, 16:+112->162
    //   85: aload_1
    //   86: aload 6
    //   88: aload_2
    //   89: iload 4
    //   91: invokevirtual 88	kotlin/l/b/a/b/e/c/a$a:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   94: ifne -56 -> 38
    //   97: iconst_1
    //   98: istore_3
    //   99: goto -61 -> 38
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 90	kotlin/l/b/a/b/e/c/a$a:bOT	I
    //   107: iconst_1
    //   108: ior
    //   109: putfield 90	kotlin/l/b/a/b/e/c/a$a:bOT	I
    //   112: aload_0
    //   113: aload_1
    //   114: invokevirtual 93	kotlin/l/b/a/b/h/e:zi	()I
    //   117: putfield 95	kotlin/l/b/a/b/e/c/a$a:Tyk	I
    //   120: goto -82 -> 38
    //   123: astore_1
    //   124: aload_1
    //   125: aload_0
    //   126: putfield 99	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   129: ldc 69
    //   131: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload 6
    //   139: invokevirtual 102	kotlin/l/b/a/b/h/f:flush	()V
    //   142: aload_0
    //   143: aload 5
    //   145: invokevirtual 108	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   148: putfield 63	kotlin/l/b/a/b/e/c/a$a:TwK	Lkotlin/l/b/a/b/h/d;
    //   151: aload_0
    //   152: invokevirtual 111	kotlin/l/b/a/b/e/c/a$a:Gw	()V
    //   155: ldc 69
    //   157: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 90	kotlin/l/b/a/b/e/c/a$a:bOT	I
    //   167: iconst_2
    //   168: ior
    //   169: putfield 90	kotlin/l/b/a/b/e/c/a$a:bOT	I
    //   172: aload_0
    //   173: aload_1
    //   174: invokevirtual 93	kotlin/l/b/a/b/h/e:zi	()I
    //   177: putfield 113	kotlin/l/b/a/b/e/c/a$a:TBX	I
    //   180: goto -142 -> 38
    //   183: astore_1
    //   184: new 66	kotlin/l/b/a/b/h/k
    //   187: dup
    //   188: aload_1
    //   189: invokevirtual 117	java/io/IOException:getMessage	()Ljava/lang/String;
    //   192: invokespecial 120	kotlin/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   195: astore_1
    //   196: aload_1
    //   197: aload_0
    //   198: putfield 99	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   201: ldc 69
    //   203: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_1
    //   207: athrow
    //   208: aload 6
    //   210: invokevirtual 102	kotlin/l/b/a/b/h/f:flush	()V
    //   213: aload_0
    //   214: aload 5
    //   216: invokevirtual 108	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   219: putfield 63	kotlin/l/b/a/b/e/c/a$a:TwK	Lkotlin/l/b/a/b/h/d;
    //   222: aload_0
    //   223: invokevirtual 111	kotlin/l/b/a/b/e/c/a$a:Gw	()V
    //   226: ldc 69
    //   228: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: return
    //   232: astore_1
    //   233: aload_0
    //   234: aload 5
    //   236: invokevirtual 108	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   239: putfield 63	kotlin/l/b/a/b/e/c/a$a:TwK	Lkotlin/l/b/a/b/h/d;
    //   242: goto -20 -> 222
    //   245: astore_1
    //   246: aload_0
    //   247: aload 5
    //   249: invokevirtual 108	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   252: putfield 63	kotlin/l/b/a/b/e/c/a$a:TwK	Lkotlin/l/b/a/b/h/d;
    //   255: ldc 69
    //   257: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload_1
    //   261: athrow
    //   262: astore_2
    //   263: aload_0
    //   264: aload 5
    //   266: invokevirtual 108	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   269: putfield 63	kotlin/l/b/a/b/e/c/a$a:TwK	Lkotlin/l/b/a/b/h/d;
    //   272: goto -121 -> 151
    //   275: astore_1
    //   276: aload_0
    //   277: aload 5
    //   279: invokevirtual 108	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   282: putfield 63	kotlin/l/b/a/b/e/c/a$a:TwK	Lkotlin/l/b/a/b/h/d;
    //   285: ldc 69
    //   287: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: aload_1
    //   291: athrow
    //   292: goto -208 -> 84
    //   295: iconst_1
    //   296: istore_3
    //   297: goto -259 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	a
    //   0	300	1	parame	kotlin.l.b.a.b.h.e
    //   0	300	2	paramg	kotlin.l.b.a.b.h.g
    //   37	260	3	i	int
    //   46	44	4	j	int
    //   26	252	5	localb	kotlin.l.b.a.b.h.d.b
    //   34	175	6	localf	f
    // Exception table:
    //   from	to	target	type
    //   42	48	123	kotlin/l/b/a/b/h/k
    //   84	97	123	kotlin/l/b/a/b/h/k
    //   102	120	123	kotlin/l/b/a/b/h/k
    //   162	180	123	kotlin/l/b/a/b/h/k
    //   42	48	136	finally
    //   84	97	136	finally
    //   102	120	136	finally
    //   124	136	136	finally
    //   162	180	136	finally
    //   184	208	136	finally
    //   42	48	183	java/io/IOException
    //   84	97	183	java/io/IOException
    //   102	120	183	java/io/IOException
    //   162	180	183	java/io/IOException
    //   208	213	232	java/io/IOException
    //   208	213	245	finally
    //   137	142	262	java/io/IOException
    //   137	142	275	finally
  }
  
  private a$a(i.a parama)
  {
    super((byte)0);
    this.TwK = parama.TwK;
  }
  
  public static a a(a parama)
  {
    AppMethodBeat.i(59105);
    parama = a.hIr().c(parama);
    AppMethodBeat.o(59105);
    return parama;
  }
  
  private void hEu()
  {
    this.Tyk = 0;
    this.TBX = 0;
  }
  
  public static a hIm()
  {
    return TBW;
  }
  
  public final boolean Az()
  {
    return (this.bOT & 0x1) == 1;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(59103);
    yC();
    if ((this.bOT & 0x1) == 1) {
      paramf.bs(1, this.Tyk);
    }
    if ((this.bOT & 0x2) == 2) {
      paramf.bs(2, this.TBX);
    }
    paramf.e(this.TwK);
    AppMethodBeat.o(59103);
  }
  
  public final s<a> hEs()
  {
    return TwL;
  }
  
  public final boolean hIn()
  {
    return (this.bOT & 0x2) == 2;
  }
  
  public final a hIo()
  {
    AppMethodBeat.i(59106);
    a locala = a.hIr().c(this);
    AppMethodBeat.o(59106);
    return locala;
  }
  
  public final boolean isInitialized()
  {
    int i = this.bPe;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.bPe = 1;
    return true;
  }
  
  public final int yC()
  {
    AppMethodBeat.i(59104);
    int i = this.bVY;
    if (i != -1)
    {
      AppMethodBeat.o(59104);
      return i;
    }
    i = 0;
    if ((this.bOT & 0x1) == 1) {
      i = f.bu(1, this.Tyk) + 0;
    }
    int j = i;
    if ((this.bOT & 0x2) == 2) {
      j = i + f.bu(2, this.TBX);
    }
    i = j + this.TwK.size();
    this.bVY = i;
    AppMethodBeat.o(59104);
    return i;
  }
  
  public static final class a
    extends i.a<a.a, a>
    implements b
  {
    private int TBX;
    private int Tyk;
    private int bOT;
    
    /* Error */
    private a B(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 26
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 36	kotlin/l/b/a/b/e/c/a$a:TwL	Lkotlin/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 41 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/c/a$a
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 45	kotlin/l/b/a/b/e/c/a$a$a:c	(Lkotlin/l/b/a/b/e/c/a$a;)Lkotlin/l/b/a/b/e/c/a$a$a;
      //   26: pop
      //   27: ldc 26
      //   29: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 52	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
      //   39: checkcast 9	kotlin/l/b/a/b/e/c/a$a
      //   42: astore_2
      //   43: ldc 26
      //   45: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 45	kotlin/l/b/a/b/e/c/a$a$a:c	(Lkotlin/l/b/a/b/e/c/a$a;)Lkotlin/l/b/a/b/e/c/a$a$a;
      //   60: pop
      //   61: ldc 26
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
    
    private a avp(int paramInt)
    {
      this.bOT |= 0x1;
      this.Tyk = paramInt;
      return this;
    }
    
    private a avq(int paramInt)
    {
      this.bOT |= 0x2;
      this.TBX = paramInt;
      return this;
    }
    
    private a hIp()
    {
      AppMethodBeat.i(59088);
      a locala = new a().c(hIq());
      AppMethodBeat.o(59088);
      return locala;
    }
    
    public final a c(a.a parama)
    {
      AppMethodBeat.i(59090);
      if (parama == a.a.hIm())
      {
        AppMethodBeat.o(59090);
        return this;
      }
      if (parama.Az()) {
        avp(parama.Tyk);
      }
      if (parama.hIn()) {
        avq(parama.TBX);
      }
      this.TwK = this.TwK.a(a.a.b(parama));
      AppMethodBeat.o(59090);
      return this;
    }
    
    public final a.a hIq()
    {
      int i = 1;
      AppMethodBeat.i(59089);
      a.a locala = new a.a(this, (byte)0);
      int k = this.bOT;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.a.a(locala, this.Tyk);
        int j = i;
        if ((k & 0x2) == 2) {
          j = i | 0x2;
        }
        a.a.b(locala, this.TBX);
        a.a.c(locala, j);
        AppMethodBeat.o(59089);
        return locala;
        i = 0;
      }
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.a
 * JD-Core Version:    0.7.0.1
 */