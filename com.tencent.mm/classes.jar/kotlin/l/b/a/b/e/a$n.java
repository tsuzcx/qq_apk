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
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.h.t;

public final class a$n
  extends i
  implements p
{
  public static t<n> aiYa;
  private static final n ajap;
  private final d aiXZ;
  private List<b> ajaq;
  private int dRJ = -1;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(58776);
    aiYa = new b() {};
    n localn = new n();
    ajap = localn;
    localn.ajaq = Collections.emptyList();
    AppMethodBeat.o(58776);
  }
  
  private a$n()
  {
    this.aiXZ = d.ajeU;
  }
  
  /* Error */
  private a$n(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 69	kotlin/l/b/a/b/h/i:<init>	()V
    //   4: ldc 86
    //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 71	kotlin/l/b/a/b/e/a$n:memoizedIsInitialized	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 73	kotlin/l/b/a/b/e/a$n:dRJ	I
    //   19: aload_0
    //   20: invokestatic 62	java/util/Collections:emptyList	()Ljava/util/List;
    //   23: putfield 64	kotlin/l/b/a/b/e/a$n:ajaq	Ljava/util/List;
    //   26: invokestatic 90	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
    //   29: astore 9
    //   31: aload 9
    //   33: iconst_1
    //   34: invokestatic 95	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
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
    //   59: invokevirtual 101	kotlin/l/b/a/b/h/e:aac	()I
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
    //   108: invokevirtual 104	kotlin/l/b/a/b/e/a$n:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
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
    //   140: new 106	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 107	java/util/ArrayList:<init>	()V
    //   147: putfield 64	kotlin/l/b/a/b/e/a$n:ajaq	Ljava/util/List;
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
    //   168: getfield 64	kotlin/l/b/a/b/e/a$n:ajaq	Ljava/util/List;
    //   171: aload_1
    //   172: getstatic 108	kotlin/l/b/a/b/e/a$n$b:aiYa	Lkotlin/l/b/a/b/h/t;
    //   175: aload_2
    //   176: invokevirtual 111	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   179: invokeinterface 117 2 0
    //   184: pop
    //   185: iload 4
    //   187: istore_3
    //   188: goto -144 -> 44
    //   191: astore_1
    //   192: iload 7
    //   194: istore 5
    //   196: aload_1
    //   197: aload_0
    //   198: putfield 121	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   201: iload 7
    //   203: istore 5
    //   205: ldc 86
    //   207: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   227: getfield 64	kotlin/l/b/a/b/e/a$n:ajaq	Ljava/util/List;
    //   230: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   233: putfield 64	kotlin/l/b/a/b/e/a$n:ajaq	Ljava/util/List;
    //   236: aload 10
    //   238: invokevirtual 128	kotlin/l/b/a/b/h/f:flush	()V
    //   241: aload_0
    //   242: aload 9
    //   244: invokevirtual 134	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   247: putfield 80	kotlin/l/b/a/b/e/a$n:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   250: aload_0
    //   251: invokevirtual 137	kotlin/l/b/a/b/e/a$n:makeExtensionsImmutable	()V
    //   254: ldc 86
    //   256: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_1
    //   260: athrow
    //   261: iload_3
    //   262: iconst_1
    //   263: iand
    //   264: iconst_1
    //   265: if_icmpne +14 -> 279
    //   268: aload_0
    //   269: aload_0
    //   270: getfield 64	kotlin/l/b/a/b/e/a$n:ajaq	Ljava/util/List;
    //   273: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   276: putfield 64	kotlin/l/b/a/b/e/a$n:ajaq	Ljava/util/List;
    //   279: aload 10
    //   281: invokevirtual 128	kotlin/l/b/a/b/h/f:flush	()V
    //   284: aload_0
    //   285: aload 9
    //   287: invokevirtual 134	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   290: putfield 80	kotlin/l/b/a/b/e/a$n:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   293: aload_0
    //   294: invokevirtual 137	kotlin/l/b/a/b/e/a$n:makeExtensionsImmutable	()V
    //   297: ldc 86
    //   299: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: return
    //   303: astore_1
    //   304: aload_0
    //   305: aload 9
    //   307: invokevirtual 134	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   310: putfield 80	kotlin/l/b/a/b/e/a$n:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   313: goto -20 -> 293
    //   316: astore_1
    //   317: aload_0
    //   318: aload 9
    //   320: invokevirtual 134	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   323: putfield 80	kotlin/l/b/a/b/e/a$n:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   326: ldc 86
    //   328: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: aload_1
    //   332: athrow
    //   333: astore_1
    //   334: iload 8
    //   336: istore 5
    //   338: new 83	kotlin/l/b/a/b/h/l
    //   341: dup
    //   342: aload_1
    //   343: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   346: invokespecial 144	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   349: astore_1
    //   350: iload 8
    //   352: istore 5
    //   354: aload_1
    //   355: aload_0
    //   356: putfield 121	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   359: iload 8
    //   361: istore 5
    //   363: ldc 86
    //   365: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: iload 8
    //   370: istore 5
    //   372: aload_1
    //   373: athrow
    //   374: astore_2
    //   375: aload_0
    //   376: aload 9
    //   378: invokevirtual 134	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   381: putfield 80	kotlin/l/b/a/b/e/a$n:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   384: goto -134 -> 250
    //   387: astore_1
    //   388: aload_0
    //   389: aload 9
    //   391: invokevirtual 134	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   394: putfield 80	kotlin/l/b/a/b/e/a$n:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   397: ldc 86
    //   399: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: aload_1
    //   403: athrow
    //   404: goto -312 -> 92
    //   407: iconst_1
    //   408: istore 6
    //   410: goto -366 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	n
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
    //   58	64	191	kotlin/l/b/a/b/h/l
    //   101	114	191	kotlin/l/b/a/b/h/l
    //   139	150	191	kotlin/l/b/a/b/h/l
    //   167	185	191	kotlin/l/b/a/b/h/l
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
  
  private a$n(i.a parama)
  {
    super((byte)0);
    this.aiXZ = parama.aiXZ;
  }
  
  public static a b(n paramn)
  {
    AppMethodBeat.i(58773);
    paramn = a.kvv().e(paramn);
    AppMethodBeat.o(58773);
    return paramn;
  }
  
  public static n kvr()
  {
    return ajap;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58771);
    getSerializedSize();
    int i = 0;
    while (i < this.ajaq.size())
    {
      paramf.a(1, (r)this.ajaq.get(i));
      i += 1;
    }
    paramf.e(this.aiXZ);
    AppMethodBeat.o(58771);
  }
  
  public final b aLn(int paramInt)
  {
    AppMethodBeat.i(58769);
    b localb = (b)this.ajaq.get(paramInt);
    AppMethodBeat.o(58769);
    return localb;
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(58772);
    int i = this.dRJ;
    if (i != -1)
    {
      AppMethodBeat.o(58772);
      return i;
    }
    i = 0;
    int j = 0;
    while (i < this.ajaq.size())
    {
      j += f.c(1, (r)this.ajaq.get(i));
      i += 1;
    }
    i = this.aiXZ.size() + j;
    this.dRJ = i;
    AppMethodBeat.o(58772);
    return i;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58770);
    int i = this.memoizedIsInitialized;
    if (i == 1)
    {
      AppMethodBeat.o(58770);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58770);
      return false;
    }
    i = 0;
    while (i < this.ajaq.size())
    {
      if (!aLn(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58770);
        return false;
      }
      i += 1;
    }
    this.memoizedIsInitialized = 1;
    AppMethodBeat.o(58770);
    return true;
  }
  
  public static final class a
    extends i.a<a.n, a>
    implements p
  {
    private List<a.n.b> ajaq;
    private int bitField0_;
    
    private a()
    {
      AppMethodBeat.i(58724);
      this.ajaq = Collections.emptyList();
      AppMethodBeat.o(58724);
    }
    
    private a kvs()
    {
      AppMethodBeat.i(58725);
      a locala = new a().e(kvt());
      AppMethodBeat.o(58725);
      return locala;
    }
    
    private void kvu()
    {
      AppMethodBeat.i(58730);
      if ((this.bitField0_ & 0x1) != 1)
      {
        this.ajaq = new ArrayList(this.ajaq);
        this.bitField0_ |= 0x1;
      }
      AppMethodBeat.o(58730);
    }
    
    /* Error */
    private a q(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 69
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 73	kotlin/l/b/a/b/e/a$n:aiYa	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 78 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$n
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 53	kotlin/l/b/a/b/e/a$n$a:e	(Lkotlin/l/b/a/b/e/a$n;)Lkotlin/l/b/a/b/e/a$n$a;
      //   30: pop
      //   31: ldc 69
      //   33: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 82	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   43: checkcast 9	kotlin/l/b/a/b/e/a$n
      //   46: astore_2
      //   47: ldc 69
      //   49: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: aload_2
      //   56: ifnull +9 -> 65
      //   59: aload_0
      //   60: aload_2
      //   61: invokevirtual 53	kotlin/l/b/a/b/e/a$n$a:e	(Lkotlin/l/b/a/b/e/a$n;)Lkotlin/l/b/a/b/e/a$n$a;
      //   64: pop
      //   65: ldc 69
      //   67: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   6	68	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	kotlin/l/b/a/b/h/l
      //   47	54	54	finally
      //   7	21	72	finally
      //   39	47	72	finally
    }
    
    public final a e(a.n paramn)
    {
      AppMethodBeat.i(58727);
      if (paramn == a.n.kvr())
      {
        AppMethodBeat.o(58727);
        return this;
      }
      if (!a.n.c(paramn).isEmpty())
      {
        if (!this.ajaq.isEmpty()) {
          break label84;
        }
        this.ajaq = a.n.c(paramn);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      for (;;)
      {
        this.aiXZ = this.aiXZ.a(a.n.d(paramn));
        AppMethodBeat.o(58727);
        return this;
        label84:
        kvu();
        this.ajaq.addAll(a.n.c(paramn));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58728);
      int i = 0;
      while (i < this.ajaq.size())
      {
        if (!((a.n.b)this.ajaq.get(i)).isInitialized())
        {
          AppMethodBeat.o(58728);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(58728);
      return true;
    }
    
    public final a.n kvt()
    {
      AppMethodBeat.i(58726);
      a.n localn = new a.n(this, (byte)0);
      if ((this.bitField0_ & 0x1) == 1)
      {
        this.ajaq = Collections.unmodifiableList(this.ajaq);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      a.n.a(localn, this.ajaq);
      AppMethodBeat.o(58726);
      return localn;
    }
  }
  
  public static final class b
    extends i
    implements o
  {
    public static t<b> aiYa;
    private static final b ajar;
    private final d aiXZ;
    public int ajas;
    public int ajat;
    public b ajau;
    private int bitField0_;
    private int dRJ = -1;
    private byte memoizedIsInitialized = -1;
    
    static
    {
      AppMethodBeat.i(58767);
      aiYa = new b() {};
      b localb = new b();
      ajar = localb;
      localb.ktf();
      AppMethodBeat.o(58767);
    }
    
    private b()
    {
      this.aiXZ = d.ajeU;
    }
    
    /* Error */
    private b(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 62	kotlin/l/b/a/b/h/i:<init>	()V
      //   4: ldc 79
      //   6: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 64	kotlin/l/b/a/b/e/a$n$b:memoizedIsInitialized	B
      //   14: aload_0
      //   15: iconst_m1
      //   16: putfield 66	kotlin/l/b/a/b/e/a$n$b:dRJ	I
      //   19: aload_0
      //   20: invokespecial 57	kotlin/l/b/a/b/e/a$n$b:ktf	()V
      //   23: invokestatic 83	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
      //   26: astore 6
      //   28: aload 6
      //   30: iconst_1
      //   31: invokestatic 88	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
      //   34: astore 7
      //   36: iconst_0
      //   37: istore_3
      //   38: iload_3
      //   39: ifne +231 -> 270
      //   42: aload_1
      //   43: invokevirtual 94	kotlin/l/b/a/b/h/e:aac	()I
      //   46: istore 4
      //   48: iload 4
      //   50: lookupswitch	default:+304->354, 0:+307->357, 8:+60->110, 16:+120->170, 24:+166->216
      //   93: aload_1
      //   94: aload 7
      //   96: aload_2
      //   97: iload 4
      //   99: invokevirtual 97	kotlin/l/b/a/b/e/a$n$b:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
      //   102: ifne -64 -> 38
      //   105: iconst_1
      //   106: istore_3
      //   107: goto -69 -> 38
      //   110: aload_0
      //   111: aload_0
      //   112: getfield 99	kotlin/l/b/a/b/e/a$n$b:bitField0_	I
      //   115: iconst_1
      //   116: ior
      //   117: putfield 99	kotlin/l/b/a/b/e/a$n$b:bitField0_	I
      //   120: aload_0
      //   121: aload_1
      //   122: invokevirtual 102	kotlin/l/b/a/b/h/e:aar	()I
      //   125: putfield 104	kotlin/l/b/a/b/e/a$n$b:ajas	I
      //   128: goto -90 -> 38
      //   131: astore_1
      //   132: aload_1
      //   133: aload_0
      //   134: putfield 108	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   137: ldc 79
      //   139: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   142: aload_1
      //   143: athrow
      //   144: astore_1
      //   145: aload 7
      //   147: invokevirtual 111	kotlin/l/b/a/b/h/f:flush	()V
      //   150: aload_0
      //   151: aload 6
      //   153: invokevirtual 117	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
      //   156: putfield 73	kotlin/l/b/a/b/e/a$n$b:aiXZ	Lkotlin/l/b/a/b/h/d;
      //   159: aload_0
      //   160: invokevirtual 120	kotlin/l/b/a/b/e/a$n$b:makeExtensionsImmutable	()V
      //   163: ldc 79
      //   165: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   168: aload_1
      //   169: athrow
      //   170: aload_0
      //   171: aload_0
      //   172: getfield 99	kotlin/l/b/a/b/e/a$n$b:bitField0_	I
      //   175: iconst_2
      //   176: ior
      //   177: putfield 99	kotlin/l/b/a/b/e/a$n$b:bitField0_	I
      //   180: aload_0
      //   181: aload_1
      //   182: invokevirtual 102	kotlin/l/b/a/b/h/e:aar	()I
      //   185: putfield 122	kotlin/l/b/a/b/e/a$n$b:ajat	I
      //   188: goto -150 -> 38
      //   191: astore_1
      //   192: new 76	kotlin/l/b/a/b/h/l
      //   195: dup
      //   196: aload_1
      //   197: invokevirtual 126	java/io/IOException:getMessage	()Ljava/lang/String;
      //   200: invokespecial 129	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
      //   203: astore_1
      //   204: aload_1
      //   205: aload_0
      //   206: putfield 108	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   209: ldc 79
      //   211: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   214: aload_1
      //   215: athrow
      //   216: aload_1
      //   217: invokevirtual 102	kotlin/l/b/a/b/h/e:aar	()I
      //   220: istore 5
      //   222: iload 5
      //   224: invokestatic 133	kotlin/l/b/a/b/e/a$n$b$b:aLq	(I)Lkotlin/l/b/a/b/e/a$n$b$b;
      //   227: astore 8
      //   229: aload 8
      //   231: ifnonnull +20 -> 251
      //   234: aload 7
      //   236: iload 4
      //   238: invokevirtual 136	kotlin/l/b/a/b/h/f:lI	(I)V
      //   241: aload 7
      //   243: iload 5
      //   245: invokevirtual 136	kotlin/l/b/a/b/h/f:lI	(I)V
      //   248: goto -210 -> 38
      //   251: aload_0
      //   252: aload_0
      //   253: getfield 99	kotlin/l/b/a/b/e/a$n$b:bitField0_	I
      //   256: iconst_4
      //   257: ior
      //   258: putfield 99	kotlin/l/b/a/b/e/a$n$b:bitField0_	I
      //   261: aload_0
      //   262: aload 8
      //   264: putfield 138	kotlin/l/b/a/b/e/a$n$b:ajau	Lkotlin/l/b/a/b/e/a$n$b$b;
      //   267: goto -229 -> 38
      //   270: aload 7
      //   272: invokevirtual 111	kotlin/l/b/a/b/h/f:flush	()V
      //   275: aload_0
      //   276: aload 6
      //   278: invokevirtual 117	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
      //   281: putfield 73	kotlin/l/b/a/b/e/a$n$b:aiXZ	Lkotlin/l/b/a/b/h/d;
      //   284: aload_0
      //   285: invokevirtual 120	kotlin/l/b/a/b/e/a$n$b:makeExtensionsImmutable	()V
      //   288: ldc 79
      //   290: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   293: return
      //   294: astore_1
      //   295: aload_0
      //   296: aload 6
      //   298: invokevirtual 117	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
      //   301: putfield 73	kotlin/l/b/a/b/e/a$n$b:aiXZ	Lkotlin/l/b/a/b/h/d;
      //   304: goto -20 -> 284
      //   307: astore_1
      //   308: aload_0
      //   309: aload 6
      //   311: invokevirtual 117	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
      //   314: putfield 73	kotlin/l/b/a/b/e/a$n$b:aiXZ	Lkotlin/l/b/a/b/h/d;
      //   317: ldc 79
      //   319: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   322: aload_1
      //   323: athrow
      //   324: astore_2
      //   325: aload_0
      //   326: aload 6
      //   328: invokevirtual 117	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
      //   331: putfield 73	kotlin/l/b/a/b/e/a$n$b:aiXZ	Lkotlin/l/b/a/b/h/d;
      //   334: goto -175 -> 159
      //   337: astore_1
      //   338: aload_0
      //   339: aload 6
      //   341: invokevirtual 117	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
      //   344: putfield 73	kotlin/l/b/a/b/e/a$n$b:aiXZ	Lkotlin/l/b/a/b/h/d;
      //   347: ldc 79
      //   349: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   352: aload_1
      //   353: athrow
      //   354: goto -262 -> 92
      //   357: iconst_1
      //   358: istore_3
      //   359: goto -321 -> 38
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	362	0	this	b
      //   0	362	1	parame	kotlin.l.b.a.b.h.e
      //   0	362	2	paramg	kotlin.l.b.a.b.h.g
      //   37	322	3	i	int
      //   46	191	4	j	int
      //   220	24	5	k	int
      //   26	314	6	localb	kotlin.l.b.a.b.h.d.b
      //   34	237	7	localf	f
      //   227	36	8	localb1	b
      // Exception table:
      //   from	to	target	type
      //   42	48	131	kotlin/l/b/a/b/h/l
      //   92	105	131	kotlin/l/b/a/b/h/l
      //   110	128	131	kotlin/l/b/a/b/h/l
      //   170	188	131	kotlin/l/b/a/b/h/l
      //   216	229	131	kotlin/l/b/a/b/h/l
      //   234	248	131	kotlin/l/b/a/b/h/l
      //   251	267	131	kotlin/l/b/a/b/h/l
      //   42	48	144	finally
      //   92	105	144	finally
      //   110	128	144	finally
      //   132	144	144	finally
      //   170	188	144	finally
      //   192	216	144	finally
      //   216	229	144	finally
      //   234	248	144	finally
      //   251	267	144	finally
      //   42	48	191	java/io/IOException
      //   92	105	191	java/io/IOException
      //   110	128	191	java/io/IOException
      //   170	188	191	java/io/IOException
      //   216	229	191	java/io/IOException
      //   234	248	191	java/io/IOException
      //   251	267	191	java/io/IOException
      //   270	275	294	java/io/IOException
      //   270	275	307	finally
      //   145	150	324	java/io/IOException
      //   145	150	337	finally
    }
    
    private b(i.a parama)
    {
      super();
      this.aiXZ = parama.aiXZ;
    }
    
    private void ktf()
    {
      this.ajas = -1;
      this.ajat = 0;
      this.ajau = b.ajaw;
    }
    
    public static b kvw()
    {
      return ajar;
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(58763);
      getSerializedSize();
      if ((this.bitField0_ & 0x1) == 1) {
        paramf.cF(1, this.ajas);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramf.cF(2, this.ajat);
      }
      if ((this.bitField0_ & 0x4) == 4) {
        paramf.cP(3, this.ajau.value);
      }
      paramf.e(this.aiXZ);
      AppMethodBeat.o(58763);
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(58764);
      int i = this.dRJ;
      if (i != -1)
      {
        AppMethodBeat.o(58764);
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        j = f.cJ(1, this.ajas) + 0;
      }
      i = j;
      if ((this.bitField0_ & 0x2) == 2) {
        i = j + f.cJ(2, this.ajat);
      }
      j = i;
      if ((this.bitField0_ & 0x4) == 4) {
        j = i + f.cM(3, this.ajau.value);
      }
      i = j + this.aiXZ.size();
      this.dRJ = i;
      AppMethodBeat.o(58764);
      return i;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58762);
      int i = this.memoizedIsInitialized;
      if (i == 1)
      {
        AppMethodBeat.o(58762);
        return true;
      }
      if (i == 0)
      {
        AppMethodBeat.o(58762);
        return false;
      }
      if (!kvy())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58762);
        return false;
      }
      this.memoizedIsInitialized = 1;
      AppMethodBeat.o(58762);
      return true;
    }
    
    public final boolean kuv()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public final boolean kvx()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public final boolean kvy()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public static final class a
      extends i.a<a.n.b, a>
      implements o
    {
      private int ajas = -1;
      private int ajat;
      private a.n.b.b ajau = a.n.b.b.ajaw;
      private int bitField0_;
      
      private a a(a.n.b.b paramb)
      {
        AppMethodBeat.i(58746);
        if (paramb == null)
        {
          paramb = new NullPointerException();
          AppMethodBeat.o(58746);
          throw paramb;
        }
        this.bitField0_ |= 0x4;
        this.ajau = paramb;
        AppMethodBeat.o(58746);
        return this;
      }
      
      private a aLo(int paramInt)
      {
        this.bitField0_ |= 0x1;
        this.ajas = paramInt;
        return this;
      }
      
      private a aLp(int paramInt)
      {
        this.bitField0_ |= 0x2;
        this.ajat = paramInt;
        return this;
      }
      
      private a.n.b kvA()
      {
        int j = 1;
        AppMethodBeat.i(58743);
        a.n.b localb = new a.n.b(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          a.n.b.a(localb, this.ajas);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          a.n.b.b(localb, this.ajat);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          a.n.b.a(localb, this.ajau);
          a.n.b.c(localb, j);
          AppMethodBeat.o(58743);
          return localb;
          j = 0;
        }
      }
      
      private a kvz()
      {
        AppMethodBeat.i(58742);
        a locala = new a().b(kvA());
        AppMethodBeat.o(58742);
        return locala;
      }
      
      /* Error */
      private a r(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
      {
        // Byte code:
        //   0: ldc 90
        //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 94	kotlin/l/b/a/b/e/a$n$b:aiYa	Lkotlin/l/b/a/b/h/t;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 99 3 0
        //   17: checkcast 14	kotlin/l/b/a/b/e/a$n$b
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 85	kotlin/l/b/a/b/e/a$n$b$a:b	(Lkotlin/l/b/a/b/e/a$n$b;)Lkotlin/l/b/a/b/e/a$n$b$a;
        //   30: pop
        //   31: ldc 90
        //   33: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 103	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
        //   43: checkcast 14	kotlin/l/b/a/b/e/a$n$b
        //   46: astore_2
        //   47: ldc 90
        //   49: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   52: aload_1
        //   53: athrow
        //   54: astore_1
        //   55: aload_2
        //   56: ifnull +9 -> 65
        //   59: aload_0
        //   60: aload_2
        //   61: invokevirtual 85	kotlin/l/b/a/b/e/a$n$b$a:b	(Lkotlin/l/b/a/b/e/a$n$b;)Lkotlin/l/b/a/b/e/a$n$b$a;
        //   64: pop
        //   65: ldc 90
        //   67: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
        //   6	68	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	kotlin/l/b/a/b/h/l
        //   47	54	54	finally
        //   7	21	72	finally
        //   39	47	72	finally
      }
      
      public final a b(a.n.b paramb)
      {
        AppMethodBeat.i(58744);
        if (paramb == a.n.b.kvw())
        {
          AppMethodBeat.o(58744);
          return this;
        }
        if (paramb.kvx()) {
          aLo(paramb.ajas);
        }
        if (paramb.kvy()) {
          aLp(paramb.ajat);
        }
        if (paramb.kuv()) {
          a(paramb.ajau);
        }
        this.aiXZ = this.aiXZ.a(a.n.b.a(paramb));
        AppMethodBeat.o(58744);
        return this;
      }
      
      public final boolean isInitialized()
      {
        if ((this.bitField0_ & 0x2) == 2) {}
        for (int i = 1; i == 0; i = 0) {
          return false;
        }
        return true;
      }
    }
    
    public static enum b
      implements k.a
    {
      private static k.b<b> aiYE;
      final int value;
      
      static
      {
        AppMethodBeat.i(58760);
        ajav = new b("CLASS", 0, 0);
        ajaw = new b("PACKAGE", 1, 1);
        ajax = new b("LOCAL", 2, 2);
        ajay = new b[] { ajav, ajaw, ajax };
        aiYE = new k.b() {};
        AppMethodBeat.o(58760);
      }
      
      private b(int paramInt)
      {
        this.value = paramInt;
      }
      
      public static b aLq(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 0: 
          return ajav;
        case 1: 
          return ajaw;
        }
        return ajax;
      }
      
      public final int getNumber()
      {
        return this.value;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.n
 * JD-Core Version:    0.7.0.1
 */