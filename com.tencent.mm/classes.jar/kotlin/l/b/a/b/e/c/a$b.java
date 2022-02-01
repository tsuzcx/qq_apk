package kotlin.l.b.a.b.e.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.h.b;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.t;

public final class a$b
  extends i
  implements c
{
  public static t<b> aaZC;
  private static final b abeM;
  private final d aaZB;
  public int abbb;
  public int abeL;
  private int bQS;
  private byte bRd = -1;
  private int bXW = -1;
  
  static
  {
    AppMethodBeat.i(59132);
    aaZC = new b() {};
    b localb = new b();
    abeM = localb;
    localb.iIN();
    AppMethodBeat.o(59132);
  }
  
  private a$b()
  {
    this.aaZB = d.abgb;
  }
  
  /* Error */
  private a$b(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 53	kotlin/l/b/a/b/h/i:<init>	()V
    //   4: ldc 70
    //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 55	kotlin/l/b/a/b/e/c/a$b:bRd	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 57	kotlin/l/b/a/b/e/c/a$b:bXW	I
    //   19: aload_0
    //   20: invokespecial 48	kotlin/l/b/a/b/e/c/a$b:iIN	()V
    //   23: invokestatic 74	kotlin/l/b/a/b/h/d:iNH	()Lkotlin/l/b/a/b/h/d$b;
    //   26: astore 5
    //   28: aload 5
    //   30: iconst_1
    //   31: invokestatic 80	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   34: astore 6
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +169 -> 208
    //   42: aload_1
    //   43: invokevirtual 86	kotlin/l/b/a/b/h/e:Av	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+242->292, 0:+245->295, 8:+52->102, 16:+112->162
    //   85: aload_1
    //   86: aload 6
    //   88: aload_2
    //   89: iload 4
    //   91: invokevirtual 89	kotlin/l/b/a/b/e/c/a$b:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   94: ifne -56 -> 38
    //   97: iconst_1
    //   98: istore_3
    //   99: goto -61 -> 38
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 91	kotlin/l/b/a/b/e/c/a$b:bQS	I
    //   107: iconst_1
    //   108: ior
    //   109: putfield 91	kotlin/l/b/a/b/e/c/a$b:bQS	I
    //   112: aload_0
    //   113: aload_1
    //   114: invokevirtual 94	kotlin/l/b/a/b/h/e:AK	()I
    //   117: putfield 96	kotlin/l/b/a/b/e/c/a$b:abbb	I
    //   120: goto -82 -> 38
    //   123: astore_1
    //   124: aload_1
    //   125: aload_0
    //   126: putfield 100	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   129: ldc 70
    //   131: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload 6
    //   139: invokevirtual 103	kotlin/l/b/a/b/h/f:flush	()V
    //   142: aload_0
    //   143: aload 5
    //   145: invokevirtual 109	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   148: putfield 64	kotlin/l/b/a/b/e/c/a$b:aaZB	Lkotlin/l/b/a/b/h/d;
    //   151: aload_0
    //   152: invokevirtual 112	kotlin/l/b/a/b/e/c/a$b:HZ	()V
    //   155: ldc 70
    //   157: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 91	kotlin/l/b/a/b/e/c/a$b:bQS	I
    //   167: iconst_2
    //   168: ior
    //   169: putfield 91	kotlin/l/b/a/b/e/c/a$b:bQS	I
    //   172: aload_0
    //   173: aload_1
    //   174: invokevirtual 94	kotlin/l/b/a/b/h/e:AK	()I
    //   177: putfield 114	kotlin/l/b/a/b/e/c/a$b:abeL	I
    //   180: goto -142 -> 38
    //   183: astore_1
    //   184: new 67	kotlin/l/b/a/b/h/l
    //   187: dup
    //   188: aload_1
    //   189: invokevirtual 118	java/io/IOException:getMessage	()Ljava/lang/String;
    //   192: invokespecial 121	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   195: astore_1
    //   196: aload_1
    //   197: aload_0
    //   198: putfield 100	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
    //   201: ldc 70
    //   203: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_1
    //   207: athrow
    //   208: aload 6
    //   210: invokevirtual 103	kotlin/l/b/a/b/h/f:flush	()V
    //   213: aload_0
    //   214: aload 5
    //   216: invokevirtual 109	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   219: putfield 64	kotlin/l/b/a/b/e/c/a$b:aaZB	Lkotlin/l/b/a/b/h/d;
    //   222: aload_0
    //   223: invokevirtual 112	kotlin/l/b/a/b/e/c/a$b:HZ	()V
    //   226: ldc 70
    //   228: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: return
    //   232: astore_1
    //   233: aload_0
    //   234: aload 5
    //   236: invokevirtual 109	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   239: putfield 64	kotlin/l/b/a/b/e/c/a$b:aaZB	Lkotlin/l/b/a/b/h/d;
    //   242: goto -20 -> 222
    //   245: astore_1
    //   246: aload_0
    //   247: aload 5
    //   249: invokevirtual 109	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   252: putfield 64	kotlin/l/b/a/b/e/c/a$b:aaZB	Lkotlin/l/b/a/b/h/d;
    //   255: ldc 70
    //   257: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload_1
    //   261: athrow
    //   262: astore_2
    //   263: aload_0
    //   264: aload 5
    //   266: invokevirtual 109	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   269: putfield 64	kotlin/l/b/a/b/e/c/a$b:aaZB	Lkotlin/l/b/a/b/h/d;
    //   272: goto -121 -> 151
    //   275: astore_1
    //   276: aload_0
    //   277: aload 5
    //   279: invokevirtual 109	kotlin/l/b/a/b/h/d$b:iNK	()Lkotlin/l/b/a/b/h/d;
    //   282: putfield 64	kotlin/l/b/a/b/e/c/a$b:aaZB	Lkotlin/l/b/a/b/h/d;
    //   285: ldc 70
    //   287: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: aload_1
    //   291: athrow
    //   292: goto -208 -> 84
    //   295: iconst_1
    //   296: istore_3
    //   297: goto -259 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	b
    //   0	300	1	parame	kotlin.l.b.a.b.h.e
    //   0	300	2	paramg	kotlin.l.b.a.b.h.g
    //   37	260	3	i	int
    //   46	44	4	j	int
    //   26	252	5	localb	kotlin.l.b.a.b.h.d.b
    //   34	175	6	localf	f
    // Exception table:
    //   from	to	target	type
    //   42	48	123	kotlin/l/b/a/b/h/l
    //   84	97	123	kotlin/l/b/a/b/h/l
    //   102	120	123	kotlin/l/b/a/b/h/l
    //   162	180	123	kotlin/l/b/a/b/h/l
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
  
  private a$b(i.a parama)
  {
    super((byte)0);
    this.aaZB = parama.aaZB;
  }
  
  public static a a(b paramb)
  {
    AppMethodBeat.i(59128);
    paramb = a.iMQ().c(paramb);
    AppMethodBeat.o(59128);
    return paramb;
  }
  
  private void iIN()
  {
    this.abbb = 0;
    this.abeL = 0;
  }
  
  public static b iMM()
  {
    return abeM;
  }
  
  public final int Ad()
  {
    AppMethodBeat.i(59127);
    int i = this.bXW;
    if (i != -1)
    {
      AppMethodBeat.o(59127);
      return i;
    }
    i = 0;
    if ((this.bQS & 0x1) == 1) {
      i = f.bM(1, this.abbb) + 0;
    }
    int j = i;
    if ((this.bQS & 0x2) == 2) {
      j = i + f.bM(2, this.abeL);
    }
    i = j + this.aaZB.size();
    this.bXW = i;
    AppMethodBeat.o(59127);
    return i;
  }
  
  public final boolean Cc()
  {
    return (this.bQS & 0x1) == 1;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(59126);
    Ad();
    if ((this.bQS & 0x1) == 1) {
      paramf.bJ(1, this.abbb);
    }
    if ((this.bQS & 0x2) == 2) {
      paramf.bJ(2, this.abeL);
    }
    paramf.e(this.aaZB);
    AppMethodBeat.o(59126);
  }
  
  public final boolean iMH()
  {
    return (this.bQS & 0x2) == 2;
  }
  
  public final a iMN()
  {
    AppMethodBeat.i(59129);
    a locala = a.iMQ().c(this);
    AppMethodBeat.o(59129);
    return locala;
  }
  
  public final boolean isInitialized()
  {
    int i = this.bRd;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.bRd = 1;
    return true;
  }
  
  public static final class a
    extends i.a<a.b, a>
    implements c
  {
    private int abbb;
    private int abeL;
    private int bQS;
    
    /* Error */
    private a C(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 27
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 37	kotlin/l/b/a/b/e/c/a$b:aaZC	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 42 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/c/a$b
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 46	kotlin/l/b/a/b/e/c/a$b$a:c	(Lkotlin/l/b/a/b/e/c/a$b;)Lkotlin/l/b/a/b/e/c/a$b$a;
      //   26: pop
      //   27: ldc 27
      //   29: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 53	kotlin/l/b/a/b/h/l:abgy	Lkotlin/l/b/a/b/h/r;
      //   39: checkcast 9	kotlin/l/b/a/b/e/c/a$b
      //   42: astore_2
      //   43: ldc 27
      //   45: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 46	kotlin/l/b/a/b/e/c/a$b$a:c	(Lkotlin/l/b/a/b/e/c/a$b;)Lkotlin/l/b/a/b/e/c/a$b$a;
      //   60: pop
      //   61: ldc 27
      //   63: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private a aFl(int paramInt)
    {
      this.bQS |= 0x1;
      this.abbb = paramInt;
      return this;
    }
    
    private a aFm(int paramInt)
    {
      this.bQS |= 0x2;
      this.abeL = paramInt;
      return this;
    }
    
    private a iMO()
    {
      AppMethodBeat.i(59111);
      a locala = new a().c(iMP());
      AppMethodBeat.o(59111);
      return locala;
    }
    
    public final a c(a.b paramb)
    {
      AppMethodBeat.i(59113);
      if (paramb == a.b.iMM())
      {
        AppMethodBeat.o(59113);
        return this;
      }
      if (paramb.Cc()) {
        aFl(paramb.abbb);
      }
      if (paramb.iMH()) {
        aFm(paramb.abeL);
      }
      this.aaZB = this.aaZB.a(a.b.b(paramb));
      AppMethodBeat.o(59113);
      return this;
    }
    
    public final a.b iMP()
    {
      int i = 1;
      AppMethodBeat.i(59112);
      a.b localb = new a.b(this, (byte)0);
      int k = this.bQS;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.b.a(localb, this.abbb);
        int j = i;
        if ((k & 0x2) == 2) {
          j = i | 0x2;
        }
        a.b.b(localb, this.abeL);
        a.b.c(localb, j);
        AppMethodBeat.o(59112);
        return localb;
        i = 0;
      }
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.b
 * JD-Core Version:    0.7.0.1
 */