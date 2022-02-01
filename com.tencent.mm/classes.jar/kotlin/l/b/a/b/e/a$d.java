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

public final class a$d
  extends i
  implements g
{
  public static t<d> aiYa;
  private static final d aiZm;
  private final d aiXZ;
  private List<a.e> aiZn;
  private int dRJ = -1;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(58489);
    aiYa = new b() {};
    d locald = new d();
    aiZm = locald;
    locald.aiZn = Collections.emptyList();
    AppMethodBeat.o(58489);
  }
  
  private a$d()
  {
    this.aiXZ = d.ajeU;
  }
  
  /* Error */
  private a$d(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 58	kotlin/l/b/a/b/h/i:<init>	()V
    //   4: ldc 75
    //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 60	kotlin/l/b/a/b/e/a$d:memoizedIsInitialized	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 62	kotlin/l/b/a/b/e/a$d:dRJ	I
    //   19: aload_0
    //   20: invokestatic 51	java/util/Collections:emptyList	()Ljava/util/List;
    //   23: putfield 53	kotlin/l/b/a/b/e/a$d:aiZn	Ljava/util/List;
    //   26: invokestatic 79	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
    //   29: astore 9
    //   31: aload 9
    //   33: iconst_1
    //   34: invokestatic 84	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
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
    //   59: invokevirtual 90	kotlin/l/b/a/b/h/e:aac	()I
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
    //   108: invokevirtual 93	kotlin/l/b/a/b/e/a$d:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
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
    //   140: new 95	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 96	java/util/ArrayList:<init>	()V
    //   147: putfield 53	kotlin/l/b/a/b/e/a$d:aiZn	Ljava/util/List;
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
    //   168: getfield 53	kotlin/l/b/a/b/e/a$d:aiZn	Ljava/util/List;
    //   171: aload_1
    //   172: getstatic 99	kotlin/l/b/a/b/e/a$e:aiYa	Lkotlin/l/b/a/b/h/t;
    //   175: aload_2
    //   176: invokevirtual 102	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   179: invokeinterface 108 2 0
    //   184: pop
    //   185: iload 4
    //   187: istore_3
    //   188: goto -144 -> 44
    //   191: astore_1
    //   192: iload 7
    //   194: istore 5
    //   196: aload_1
    //   197: aload_0
    //   198: putfield 112	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
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
    //   227: getfield 53	kotlin/l/b/a/b/e/a$d:aiZn	Ljava/util/List;
    //   230: invokestatic 116	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   233: putfield 53	kotlin/l/b/a/b/e/a$d:aiZn	Ljava/util/List;
    //   236: aload 10
    //   238: invokevirtual 119	kotlin/l/b/a/b/h/f:flush	()V
    //   241: aload_0
    //   242: aload 9
    //   244: invokevirtual 125	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   247: putfield 69	kotlin/l/b/a/b/e/a$d:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   250: aload_0
    //   251: invokevirtual 128	kotlin/l/b/a/b/e/a$d:makeExtensionsImmutable	()V
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
    //   270: getfield 53	kotlin/l/b/a/b/e/a$d:aiZn	Ljava/util/List;
    //   273: invokestatic 116	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   276: putfield 53	kotlin/l/b/a/b/e/a$d:aiZn	Ljava/util/List;
    //   279: aload 10
    //   281: invokevirtual 119	kotlin/l/b/a/b/h/f:flush	()V
    //   284: aload_0
    //   285: aload 9
    //   287: invokevirtual 125	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   290: putfield 69	kotlin/l/b/a/b/e/a$d:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   293: aload_0
    //   294: invokevirtual 128	kotlin/l/b/a/b/e/a$d:makeExtensionsImmutable	()V
    //   297: ldc 75
    //   299: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: return
    //   303: astore_1
    //   304: aload_0
    //   305: aload 9
    //   307: invokevirtual 125	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   310: putfield 69	kotlin/l/b/a/b/e/a$d:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   313: goto -20 -> 293
    //   316: astore_1
    //   317: aload_0
    //   318: aload 9
    //   320: invokevirtual 125	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   323: putfield 69	kotlin/l/b/a/b/e/a$d:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   326: ldc 75
    //   328: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: aload_1
    //   332: athrow
    //   333: astore_1
    //   334: iload 8
    //   336: istore 5
    //   338: new 72	kotlin/l/b/a/b/h/l
    //   341: dup
    //   342: aload_1
    //   343: invokevirtual 132	java/io/IOException:getMessage	()Ljava/lang/String;
    //   346: invokespecial 135	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   349: astore_1
    //   350: iload 8
    //   352: istore 5
    //   354: aload_1
    //   355: aload_0
    //   356: putfield 112	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
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
    //   378: invokevirtual 125	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   381: putfield 69	kotlin/l/b/a/b/e/a$d:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   384: goto -134 -> 250
    //   387: astore_1
    //   388: aload_0
    //   389: aload 9
    //   391: invokevirtual 125	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   394: putfield 69	kotlin/l/b/a/b/e/a$d:aiXZ	Lkotlin/l/b/a/b/h/d;
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
    //   0	413	0	this	d
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
  
  private a$d(i.a parama)
  {
    super((byte)0);
    this.aiXZ = parama.aiXZ;
  }
  
  public static a a(d paramd)
  {
    AppMethodBeat.i(58485);
    paramd = a.kur().d(paramd);
    AppMethodBeat.o(58485);
    return paramd;
  }
  
  public static d kum()
  {
    return aiZm;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58483);
    getSerializedSize();
    int i = 0;
    while (i < this.aiZn.size())
    {
      paramf.a(1, (r)this.aiZn.get(i));
      i += 1;
    }
    paramf.e(this.aiXZ);
    AppMethodBeat.o(58483);
  }
  
  public final int getSerializedSize()
  {
    AppMethodBeat.i(58484);
    int i = this.dRJ;
    if (i != -1)
    {
      AppMethodBeat.o(58484);
      return i;
    }
    i = 0;
    int j = 0;
    while (i < this.aiZn.size())
    {
      j += f.c(1, (r)this.aiZn.get(i));
      i += 1;
    }
    i = this.aiXZ.size() + j;
    this.dRJ = i;
    AppMethodBeat.o(58484);
    return i;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58482);
    int i = this.memoizedIsInitialized;
    if (i == 1)
    {
      AppMethodBeat.o(58482);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58482);
      return false;
    }
    i = 0;
    while (i < this.aiZn.size())
    {
      if (!((a.e)this.aiZn.get(i)).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58482);
        return false;
      }
      i += 1;
    }
    this.memoizedIsInitialized = 1;
    AppMethodBeat.o(58482);
    return true;
  }
  
  public final a kun()
  {
    AppMethodBeat.i(58486);
    a locala = a.kur().d(this);
    AppMethodBeat.o(58486);
    return locala;
  }
  
  public static final class a
    extends i.a<a.d, a>
    implements g
  {
    private List<a.e> aiZn;
    private int bitField0_;
    
    private a()
    {
      AppMethodBeat.i(58464);
      this.aiZn = Collections.emptyList();
      AppMethodBeat.o(58464);
    }
    
    /* Error */
    private a i(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 45
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 49	kotlin/l/b/a/b/e/a$d:aiYa	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 54 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$d
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 57	kotlin/l/b/a/b/e/a$d$a:d	(Lkotlin/l/b/a/b/e/a$d;)Lkotlin/l/b/a/b/e/a$d$a;
      //   30: pop
      //   31: ldc 45
      //   33: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 61	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   43: checkcast 9	kotlin/l/b/a/b/e/a$d
      //   46: astore_2
      //   47: ldc 45
      //   49: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: aload_2
      //   56: ifnull +9 -> 65
      //   59: aload_0
      //   60: aload_2
      //   61: invokevirtual 57	kotlin/l/b/a/b/e/a$d$a:d	(Lkotlin/l/b/a/b/e/a$d;)Lkotlin/l/b/a/b/e/a$d$a;
      //   64: pop
      //   65: ldc 45
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
      //   6	68	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	38	kotlin/l/b/a/b/h/l
      //   47	54	54	finally
      //   7	21	72	finally
      //   39	47	72	finally
    }
    
    private a kuo()
    {
      AppMethodBeat.i(58465);
      a locala = new a().d(kup());
      AppMethodBeat.o(58465);
      return locala;
    }
    
    private void kuq()
    {
      AppMethodBeat.i(58470);
      if ((this.bitField0_ & 0x1) != 1)
      {
        this.aiZn = new ArrayList(this.aiZn);
        this.bitField0_ |= 0x1;
      }
      AppMethodBeat.o(58470);
    }
    
    public final a d(a.d paramd)
    {
      AppMethodBeat.i(58467);
      if (paramd == a.d.kum())
      {
        AppMethodBeat.o(58467);
        return this;
      }
      if (!a.d.b(paramd).isEmpty())
      {
        if (!this.aiZn.isEmpty()) {
          break label84;
        }
        this.aiZn = a.d.b(paramd);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      for (;;)
      {
        this.aiXZ = this.aiXZ.a(a.d.c(paramd));
        AppMethodBeat.o(58467);
        return this;
        label84:
        kuq();
        this.aiZn.addAll(a.d.b(paramd));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58468);
      int i = 0;
      while (i < this.aiZn.size())
      {
        if (!((a.e)this.aiZn.get(i)).isInitialized())
        {
          AppMethodBeat.o(58468);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(58468);
      return true;
    }
    
    public final a.d kup()
    {
      AppMethodBeat.i(58466);
      a.d locald = new a.d(this, (byte)0);
      if ((this.bitField0_ & 0x1) == 1)
      {
        this.aiZn = Collections.unmodifiableList(this.aiZn);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      a.d.a(locald, this.aiZn);
      AppMethodBeat.o(58466);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.d
 * JD-Core Version:    0.7.0.1
 */