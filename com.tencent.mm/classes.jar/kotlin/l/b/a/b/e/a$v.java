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
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.h.s;

public final class a$v
  extends i
  implements y
{
  private static final v TAq;
  public static s<v> TwL;
  public List<a.u> TAr;
  private final d TwK;
  private byte bPe = -1;
  private int bVY = -1;
  
  static
  {
    AppMethodBeat.i(59041);
    TwL = new b() {};
    v localv = new v();
    TAq = localv;
    localv.TAr = Collections.emptyList();
    AppMethodBeat.o(59041);
  }
  
  private a$v()
  {
    this.TwK = d.TDp;
  }
  
  /* Error */
  private a$v(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 58	kotlin/l/b/a/b/h/i:<init>	()V
    //   4: ldc 75
    //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 60	kotlin/l/b/a/b/e/a$v:bPe	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 62	kotlin/l/b/a/b/e/a$v:bVY	I
    //   19: aload_0
    //   20: invokestatic 51	java/util/Collections:emptyList	()Ljava/util/List;
    //   23: putfield 53	kotlin/l/b/a/b/e/a$v:TAr	Ljava/util/List;
    //   26: invokestatic 79	kotlin/l/b/a/b/h/d:hJo	()Lkotlin/l/b/a/b/h/d$b;
    //   29: astore 9
    //   31: aload 9
    //   33: iconst_1
    //   34: invokestatic 85	kotlin/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
    //   37: astore 10
    //   39: iconst_0
    //   40: istore 6
    //   42: iconst_0
    //   43: istore_3
    //   44: iload 6
    //   46: ifne +215 -> 261
    //   49: iload_3
    //   50: istore 7
    //   52: iload_3
    //   53: istore 5
    //   55: iload_3
    //   56: istore 8
    //   58: aload_1
    //   59: invokevirtual 91	kotlin/l/b/a/b/h/e:yT	()I
    //   62: istore 4
    //   64: iload 4
    //   66: lookupswitch	default:+338->404, 0:+341->407, 10:+54->120
    //   93: istore 7
    //   95: iload_3
    //   96: istore 5
    //   98: iload_3
    //   99: istore 8
    //   101: aload_0
    //   102: aload_1
    //   103: aload 10
    //   105: aload_2
    //   106: iload 4
    //   108: invokevirtual 94	kotlin/l/b/a/b/e/a$v:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   111: ifne -67 -> 44
    //   114: iconst_1
    //   115: istore 6
    //   117: goto -73 -> 44
    //   120: iload_3
    //   121: istore 4
    //   123: iload_3
    //   124: iconst_1
    //   125: iand
    //   126: iconst_1
    //   127: if_icmpeq +28 -> 155
    //   130: iload_3
    //   131: istore 7
    //   133: iload_3
    //   134: istore 5
    //   136: iload_3
    //   137: istore 8
    //   139: aload_0
    //   140: new 96	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 97	java/util/ArrayList:<init>	()V
    //   147: putfield 53	kotlin/l/b/a/b/e/a$v:TAr	Ljava/util/List;
    //   150: iload_3
    //   151: iconst_1
    //   152: ior
    //   153: istore 4
    //   155: iload 4
    //   157: istore 7
    //   159: iload 4
    //   161: istore 5
    //   163: iload 4
    //   165: istore 8
    //   167: aload_0
    //   168: getfield 53	kotlin/l/b/a/b/e/a$v:TAr	Ljava/util/List;
    //   171: aload_1
    //   172: getstatic 100	kotlin/l/b/a/b/e/a$u:TwL	Lkotlin/l/b/a/b/h/s;
    //   175: aload_2
    //   176: invokevirtual 103	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/s;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/q;
    //   179: invokeinterface 109 2 0
    //   184: pop
    //   185: iload 4
    //   187: istore_3
    //   188: goto -144 -> 44
    //   191: astore_1
    //   192: iload 7
    //   194: istore 5
    //   196: aload_1
    //   197: aload_0
    //   198: putfield 113	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   201: iload 7
    //   203: istore 5
    //   205: ldc 75
    //   207: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: iload 7
    //   212: istore 5
    //   214: aload_1
    //   215: athrow
    //   216: astore_1
    //   217: iload 5
    //   219: iconst_1
    //   220: iand
    //   221: iconst_1
    //   222: if_icmpne +14 -> 236
    //   225: aload_0
    //   226: aload_0
    //   227: getfield 53	kotlin/l/b/a/b/e/a$v:TAr	Ljava/util/List;
    //   230: invokestatic 117	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   233: putfield 53	kotlin/l/b/a/b/e/a$v:TAr	Ljava/util/List;
    //   236: aload 10
    //   238: invokevirtual 120	kotlin/l/b/a/b/h/f:flush	()V
    //   241: aload_0
    //   242: aload 9
    //   244: invokevirtual 126	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   247: putfield 69	kotlin/l/b/a/b/e/a$v:TwK	Lkotlin/l/b/a/b/h/d;
    //   250: aload_0
    //   251: invokevirtual 129	kotlin/l/b/a/b/e/a$v:Gw	()V
    //   254: ldc 75
    //   256: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_1
    //   260: athrow
    //   261: iload_3
    //   262: iconst_1
    //   263: iand
    //   264: iconst_1
    //   265: if_icmpne +14 -> 279
    //   268: aload_0
    //   269: aload_0
    //   270: getfield 53	kotlin/l/b/a/b/e/a$v:TAr	Ljava/util/List;
    //   273: invokestatic 117	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   276: putfield 53	kotlin/l/b/a/b/e/a$v:TAr	Ljava/util/List;
    //   279: aload 10
    //   281: invokevirtual 120	kotlin/l/b/a/b/h/f:flush	()V
    //   284: aload_0
    //   285: aload 9
    //   287: invokevirtual 126	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   290: putfield 69	kotlin/l/b/a/b/e/a$v:TwK	Lkotlin/l/b/a/b/h/d;
    //   293: aload_0
    //   294: invokevirtual 129	kotlin/l/b/a/b/e/a$v:Gw	()V
    //   297: ldc 75
    //   299: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: return
    //   303: astore_1
    //   304: aload_0
    //   305: aload 9
    //   307: invokevirtual 126	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   310: putfield 69	kotlin/l/b/a/b/e/a$v:TwK	Lkotlin/l/b/a/b/h/d;
    //   313: goto -20 -> 293
    //   316: astore_1
    //   317: aload_0
    //   318: aload 9
    //   320: invokevirtual 126	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   323: putfield 69	kotlin/l/b/a/b/e/a$v:TwK	Lkotlin/l/b/a/b/h/d;
    //   326: ldc 75
    //   328: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: aload_1
    //   332: athrow
    //   333: astore_1
    //   334: iload 8
    //   336: istore 5
    //   338: new 72	kotlin/l/b/a/b/h/k
    //   341: dup
    //   342: aload_1
    //   343: invokevirtual 133	java/io/IOException:getMessage	()Ljava/lang/String;
    //   346: invokespecial 136	kotlin/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   349: astore_1
    //   350: iload 8
    //   352: istore 5
    //   354: aload_1
    //   355: aload_0
    //   356: putfield 113	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
    //   359: iload 8
    //   361: istore 5
    //   363: ldc 75
    //   365: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: iload 8
    //   370: istore 5
    //   372: aload_1
    //   373: athrow
    //   374: astore_2
    //   375: aload_0
    //   376: aload 9
    //   378: invokevirtual 126	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   381: putfield 69	kotlin/l/b/a/b/e/a$v:TwK	Lkotlin/l/b/a/b/h/d;
    //   384: goto -134 -> 250
    //   387: astore_1
    //   388: aload_0
    //   389: aload 9
    //   391: invokevirtual 126	kotlin/l/b/a/b/h/d$b:hJs	()Lkotlin/l/b/a/b/h/d;
    //   394: putfield 69	kotlin/l/b/a/b/e/a$v:TwK	Lkotlin/l/b/a/b/h/d;
    //   397: ldc 75
    //   399: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: aload_1
    //   403: athrow
    //   404: goto -312 -> 92
    //   407: iconst_1
    //   408: istore 6
    //   410: goto -366 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	v
    //   0	413	1	parame	kotlin.l.b.a.b.h.e
    //   0	413	2	paramg	kotlin.l.b.a.b.h.g
    //   43	221	3	i	int
    //   62	124	4	j	int
    //   53	318	5	k	int
    //   40	369	6	m	int
    //   50	161	7	n	int
    //   56	313	8	i1	int
    //   29	361	9	localb	kotlin.l.b.a.b.h.d.b
    //   37	243	10	localf	f
    // Exception table:
    //   from	to	target	type
    //   58	64	191	kotlin/l/b/a/b/h/k
    //   101	114	191	kotlin/l/b/a/b/h/k
    //   139	150	191	kotlin/l/b/a/b/h/k
    //   167	185	191	kotlin/l/b/a/b/h/k
    //   58	64	216	finally
    //   101	114	216	finally
    //   139	150	216	finally
    //   167	185	216	finally
    //   196	201	216	finally
    //   205	210	216	finally
    //   214	216	216	finally
    //   338	350	216	finally
    //   354	359	216	finally
    //   363	368	216	finally
    //   372	374	216	finally
    //   279	284	303	java/io/IOException
    //   279	284	316	finally
    //   58	64	333	java/io/IOException
    //   101	114	333	java/io/IOException
    //   139	150	333	java/io/IOException
    //   167	185	333	java/io/IOException
    //   236	241	374	java/io/IOException
    //   236	241	387	finally
  }
  
  private a$v(i.a parama)
  {
    super((byte)0);
    this.TwK = parama.TwK;
  }
  
  public static a c(v paramv)
  {
    AppMethodBeat.i(59038);
    paramv = a.hIh().f(paramv);
    AppMethodBeat.o(59038);
    return paramv;
  }
  
  public static v hId()
  {
    return TAq;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(59036);
    yC();
    int i = 0;
    while (i < this.TAr.size())
    {
      paramf.a(1, (q)this.TAr.get(i));
      i += 1;
    }
    paramf.e(this.TwK);
    AppMethodBeat.o(59036);
  }
  
  public final s<v> hEs()
  {
    return TwL;
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
    AppMethodBeat.i(59037);
    int i = this.bVY;
    if (i != -1)
    {
      AppMethodBeat.o(59037);
      return i;
    }
    i = 0;
    int j = 0;
    while (i < this.TAr.size())
    {
      j += f.c(1, (q)this.TAr.get(i));
      i += 1;
    }
    i = this.TwK.size() + j;
    this.bVY = i;
    AppMethodBeat.o(59037);
    return i;
  }
  
  public static final class a
    extends i.a<a.v, a>
    implements y
  {
    private List<a.u> TAr;
    private int bOT;
    
    private a()
    {
      AppMethodBeat.i(59019);
      this.TAr = Collections.emptyList();
      AppMethodBeat.o(59019);
    }
    
    /* Error */
    private a A(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 46
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 50	kotlin/l/b/a/b/e/a$v:TwL	Lkotlin/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 55 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$v
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 59	kotlin/l/b/a/b/e/a$v$a:f	(Lkotlin/l/b/a/b/e/a$v;)Lkotlin/l/b/a/b/e/a$v$a;
      //   26: pop
      //   27: ldc 46
      //   29: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 63	kotlin/l/b/a/b/h/k:TDK	Lkotlin/l/b/a/b/h/q;
      //   39: checkcast 9	kotlin/l/b/a/b/e/a$v
      //   42: astore_2
      //   43: ldc 46
      //   45: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 59	kotlin/l/b/a/b/e/a$v$a:f	(Lkotlin/l/b/a/b/e/a$v;)Lkotlin/l/b/a/b/e/a$v$a;
      //   60: pop
      //   61: ldc 46
      //   63: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    private a hIe()
    {
      AppMethodBeat.i(59020);
      a locala = new a().f(hIf());
      AppMethodBeat.o(59020);
      return locala;
    }
    
    private void hIg()
    {
      AppMethodBeat.i(59024);
      if ((this.bOT & 0x1) != 1)
      {
        this.TAr = new ArrayList(this.TAr);
        this.bOT |= 0x1;
      }
      AppMethodBeat.o(59024);
    }
    
    public final a f(a.v paramv)
    {
      AppMethodBeat.i(59022);
      if (paramv == a.v.hId())
      {
        AppMethodBeat.o(59022);
        return this;
      }
      if (!a.v.d(paramv).isEmpty())
      {
        if (!this.TAr.isEmpty()) {
          break label84;
        }
        this.TAr = a.v.d(paramv);
        this.bOT &= 0xFFFFFFFE;
      }
      for (;;)
      {
        this.TwK = this.TwK.a(a.v.e(paramv));
        AppMethodBeat.o(59022);
        return this;
        label84:
        hIg();
        this.TAr.addAll(a.v.d(paramv));
      }
    }
    
    public final a.v hIf()
    {
      AppMethodBeat.i(59021);
      a.v localv = new a.v(this, (byte)0);
      if ((this.bOT & 0x1) == 1)
      {
        this.TAr = Collections.unmodifiableList(this.TAr);
        this.bOT &= 0xFFFFFFFE;
      }
      a.v.a(localv, this.TAr);
      AppMethodBeat.o(59021);
      return localv;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.v
 * JD-Core Version:    0.7.0.1
 */