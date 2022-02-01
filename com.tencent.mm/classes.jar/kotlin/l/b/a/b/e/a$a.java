package kotlin.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.h.i.a;
import kotlin.l.b.a.b.h.k.a;
import kotlin.l.b.a.b.h.k.b;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.h.t;

public final class a$a
  extends i
  implements d
{
  private static final a aiXY;
  public static t<a> aiYa;
  private final kotlin.l.b.a.b.h.d aiXZ;
  public int aiYb;
  public List<a> aiYc;
  private int bitField0_;
  private int dRJ = -1;
  private byte memoizedIsInitialized = -1;
  
  static
  {
    AppMethodBeat.i(58390);
    aiYa = new kotlin.l.b.a.b.h.b() {};
    a locala = new a();
    aiXY = locala;
    locala.ktf();
    AppMethodBeat.o(58390);
  }
  
  private a$a()
  {
    this.aiXZ = kotlin.l.b.a.b.h.d.ajeU;
  }
  
  /* Error */
  private a$a(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 71	kotlin/l/b/a/b/h/i:<init>	()V
    //   4: ldc 88
    //   6: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 73	kotlin/l/b/a/b/e/a$a:memoizedIsInitialized	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 75	kotlin/l/b/a/b/e/a$a:dRJ	I
    //   19: aload_0
    //   20: invokespecial 66	kotlin/l/b/a/b/e/a$a:ktf	()V
    //   23: invokestatic 92	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
    //   26: astore 9
    //   28: aload 9
    //   30: iconst_1
    //   31: invokestatic 97	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
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
    //   56: invokevirtual 103	kotlin/l/b/a/b/h/e:aac	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+384->447, 0:+387->450, 8:+61->124, 18:+170->233
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
    //   112: invokevirtual 106	kotlin/l/b/a/b/e/a$a:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
    //   115: ifne -74 -> 41
    //   118: iconst_1
    //   119: istore 6
    //   121: goto -80 -> 41
    //   124: iload_3
    //   125: istore 7
    //   127: iload_3
    //   128: istore 5
    //   130: iload_3
    //   131: istore 8
    //   133: aload_0
    //   134: aload_0
    //   135: getfield 108	kotlin/l/b/a/b/e/a$a:bitField0_	I
    //   138: iconst_1
    //   139: ior
    //   140: putfield 108	kotlin/l/b/a/b/e/a$a:bitField0_	I
    //   143: iload_3
    //   144: istore 7
    //   146: iload_3
    //   147: istore 5
    //   149: iload_3
    //   150: istore 8
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 111	kotlin/l/b/a/b/h/e:aar	()I
    //   157: putfield 113	kotlin/l/b/a/b/e/a$a:aiYb	I
    //   160: goto -119 -> 41
    //   163: astore_1
    //   164: iload 7
    //   166: istore 5
    //   168: aload_1
    //   169: aload_0
    //   170: putfield 117	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   173: iload 7
    //   175: istore 5
    //   177: ldc 88
    //   179: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: iload 7
    //   184: istore 5
    //   186: aload_1
    //   187: athrow
    //   188: astore_1
    //   189: iload 5
    //   191: iconst_2
    //   192: iand
    //   193: iconst_2
    //   194: if_icmpne +14 -> 208
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 119	kotlin/l/b/a/b/e/a$a:aiYc	Ljava/util/List;
    //   202: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   205: putfield 119	kotlin/l/b/a/b/e/a$a:aiYc	Ljava/util/List;
    //   208: aload 10
    //   210: invokevirtual 128	kotlin/l/b/a/b/h/f:flush	()V
    //   213: aload_0
    //   214: aload 9
    //   216: invokevirtual 134	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   219: putfield 82	kotlin/l/b/a/b/e/a$a:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   222: aload_0
    //   223: invokevirtual 137	kotlin/l/b/a/b/e/a$a:makeExtensionsImmutable	()V
    //   226: ldc 88
    //   228: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aload_1
    //   232: athrow
    //   233: iload_3
    //   234: istore 4
    //   236: iload_3
    //   237: iconst_2
    //   238: iand
    //   239: iconst_2
    //   240: if_icmpeq +28 -> 268
    //   243: iload_3
    //   244: istore 7
    //   246: iload_3
    //   247: istore 5
    //   249: iload_3
    //   250: istore 8
    //   252: aload_0
    //   253: new 139	java/util/ArrayList
    //   256: dup
    //   257: invokespecial 140	java/util/ArrayList:<init>	()V
    //   260: putfield 119	kotlin/l/b/a/b/e/a$a:aiYc	Ljava/util/List;
    //   263: iload_3
    //   264: iconst_2
    //   265: ior
    //   266: istore 4
    //   268: iload 4
    //   270: istore 7
    //   272: iload 4
    //   274: istore 5
    //   276: iload 4
    //   278: istore 8
    //   280: aload_0
    //   281: getfield 119	kotlin/l/b/a/b/e/a$a:aiYc	Ljava/util/List;
    //   284: aload_1
    //   285: getstatic 141	kotlin/l/b/a/b/e/a$a$a:aiYa	Lkotlin/l/b/a/b/h/t;
    //   288: aload_2
    //   289: invokevirtual 144	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
    //   292: invokeinterface 150 2 0
    //   297: pop
    //   298: iload 4
    //   300: istore_3
    //   301: goto -260 -> 41
    //   304: astore_1
    //   305: iload 8
    //   307: istore 5
    //   309: new 85	kotlin/l/b/a/b/h/l
    //   312: dup
    //   313: aload_1
    //   314: invokevirtual 154	java/io/IOException:getMessage	()Ljava/lang/String;
    //   317: invokespecial 157	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
    //   320: astore_1
    //   321: iload 8
    //   323: istore 5
    //   325: aload_1
    //   326: aload_0
    //   327: putfield 117	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
    //   330: iload 8
    //   332: istore 5
    //   334: ldc 88
    //   336: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: iload 8
    //   341: istore 5
    //   343: aload_1
    //   344: athrow
    //   345: iload_3
    //   346: iconst_2
    //   347: iand
    //   348: iconst_2
    //   349: if_icmpne +14 -> 363
    //   352: aload_0
    //   353: aload_0
    //   354: getfield 119	kotlin/l/b/a/b/e/a$a:aiYc	Ljava/util/List;
    //   357: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   360: putfield 119	kotlin/l/b/a/b/e/a$a:aiYc	Ljava/util/List;
    //   363: aload 10
    //   365: invokevirtual 128	kotlin/l/b/a/b/h/f:flush	()V
    //   368: aload_0
    //   369: aload 9
    //   371: invokevirtual 134	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   374: putfield 82	kotlin/l/b/a/b/e/a$a:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   377: aload_0
    //   378: invokevirtual 137	kotlin/l/b/a/b/e/a$a:makeExtensionsImmutable	()V
    //   381: ldc 88
    //   383: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: return
    //   387: astore_1
    //   388: aload_0
    //   389: aload 9
    //   391: invokevirtual 134	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   394: putfield 82	kotlin/l/b/a/b/e/a$a:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   397: goto -20 -> 377
    //   400: astore_1
    //   401: aload_0
    //   402: aload 9
    //   404: invokevirtual 134	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   407: putfield 82	kotlin/l/b/a/b/e/a$a:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   410: ldc 88
    //   412: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   415: aload_1
    //   416: athrow
    //   417: astore_2
    //   418: aload_0
    //   419: aload 9
    //   421: invokevirtual 134	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   424: putfield 82	kotlin/l/b/a/b/e/a$a:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   427: goto -205 -> 222
    //   430: astore_1
    //   431: aload_0
    //   432: aload 9
    //   434: invokevirtual 134	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
    //   437: putfield 82	kotlin/l/b/a/b/e/a$a:aiXZ	Lkotlin/l/b/a/b/h/d;
    //   440: ldc 88
    //   442: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   445: aload_1
    //   446: athrow
    //   447: goto -351 -> 96
    //   450: iconst_1
    //   451: istore 6
    //   453: goto -412 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	a
    //   0	456	1	parame	kotlin.l.b.a.b.h.e
    //   0	456	2	paramg	kotlin.l.b.a.b.h.g
    //   40	308	3	i	int
    //   59	240	4	j	int
    //   50	292	5	k	int
    //   37	415	6	m	int
    //   47	224	7	n	int
    //   53	287	8	i1	int
    //   26	407	9	localb	kotlin.l.b.a.b.h.d.b
    //   34	330	10	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	163	kotlin/l/b/a/b/h/l
    //   105	118	163	kotlin/l/b/a/b/h/l
    //   133	143	163	kotlin/l/b/a/b/h/l
    //   152	160	163	kotlin/l/b/a/b/h/l
    //   252	263	163	kotlin/l/b/a/b/h/l
    //   280	298	163	kotlin/l/b/a/b/h/l
    //   55	61	188	finally
    //   105	118	188	finally
    //   133	143	188	finally
    //   152	160	188	finally
    //   168	173	188	finally
    //   177	182	188	finally
    //   186	188	188	finally
    //   252	263	188	finally
    //   280	298	188	finally
    //   309	321	188	finally
    //   325	330	188	finally
    //   334	339	188	finally
    //   343	345	188	finally
    //   55	61	304	java/io/IOException
    //   105	118	304	java/io/IOException
    //   133	143	304	java/io/IOException
    //   152	160	304	java/io/IOException
    //   252	263	304	java/io/IOException
    //   280	298	304	java/io/IOException
    //   363	368	387	java/io/IOException
    //   363	368	400	finally
    //   208	213	417	java/io/IOException
    //   208	213	430	finally
  }
  
  private a$a(i.a parama)
  {
    super((byte)0);
    this.aiXZ = parama.aiXZ;
  }
  
  public static b a(a parama)
  {
    AppMethodBeat.i(58386);
    parama = b.ktJ().e(parama);
    AppMethodBeat.o(58386);
    return parama;
  }
  
  public static a ktd()
  {
    return aiXY;
  }
  
  private void ktf()
  {
    AppMethodBeat.i(58382);
    this.aiYb = 0;
    this.aiYc = Collections.emptyList();
    AppMethodBeat.o(58382);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58384);
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramf.cF(1, this.aiYb);
    }
    int i = 0;
    while (i < this.aiYc.size())
    {
      paramf.a(2, (r)this.aiYc.get(i));
      i += 1;
    }
    paramf.e(this.aiXZ);
    AppMethodBeat.o(58384);
  }
  
  public final int getArgumentCount()
  {
    AppMethodBeat.i(58381);
    int i = this.aiYc.size();
    AppMethodBeat.o(58381);
    return i;
  }
  
  public final int getSerializedSize()
  {
    int j = 0;
    AppMethodBeat.i(58385);
    int i = this.dRJ;
    if (i != -1)
    {
      AppMethodBeat.o(58385);
      return i;
    }
    if ((this.bitField0_ & 0x1) == 1) {
      i = f.cJ(1, this.aiYb) + 0;
    }
    for (;;)
    {
      if (j < this.aiYc.size())
      {
        int k = f.c(2, (r)this.aiYc.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        i = this.aiXZ.size() + i;
        this.dRJ = i;
        AppMethodBeat.o(58385);
        return i;
        i = 0;
      }
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(58383);
    int i = this.memoizedIsInitialized;
    if (i == 1)
    {
      AppMethodBeat.o(58383);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(58383);
      return false;
    }
    if (!kte())
    {
      this.memoizedIsInitialized = 0;
      AppMethodBeat.o(58383);
      return false;
    }
    i = 0;
    while (i < getArgumentCount())
    {
      if (!((a)this.aiYc.get(i)).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58383);
        return false;
      }
      i += 1;
    }
    this.memoizedIsInitialized = 1;
    AppMethodBeat.o(58383);
    return true;
  }
  
  public final boolean kte()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public final b ktg()
  {
    AppMethodBeat.i(58387);
    b localb = b.ktJ().e(this);
    AppMethodBeat.o(58387);
    return localb;
  }
  
  public static final class a
    extends i
    implements c
  {
    public static t<a> aiYa;
    private static final a aiYd;
    private final kotlin.l.b.a.b.h.d aiXZ;
    public int aiYe;
    public b aiYf;
    private int bitField0_;
    private int dRJ = -1;
    private byte memoizedIsInitialized = -1;
    
    static
    {
      AppMethodBeat.i(58362);
      aiYa = new kotlin.l.b.a.b.h.b() {};
      a locala = new a();
      aiYd = locala;
      locala.ktf();
      AppMethodBeat.o(58362);
    }
    
    private a()
    {
      this.aiXZ = kotlin.l.b.a.b.h.d.ajeU;
    }
    
    /* Error */
    private a(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 66	kotlin/l/b/a/b/h/i:<init>	()V
      //   4: ldc 83
      //   6: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 68	kotlin/l/b/a/b/e/a$a$a:memoizedIsInitialized	B
      //   14: aload_0
      //   15: iconst_m1
      //   16: putfield 70	kotlin/l/b/a/b/e/a$a$a:dRJ	I
      //   19: aload_0
      //   20: invokespecial 61	kotlin/l/b/a/b/e/a$a$a:ktf	()V
      //   23: invokestatic 87	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
      //   26: astore 6
      //   28: aload 6
      //   30: iconst_1
      //   31: invokestatic 92	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
      //   34: astore 7
      //   36: iconst_0
      //   37: istore_3
      //   38: iload_3
      //   39: ifne +219 -> 258
      //   42: aload_1
      //   43: invokevirtual 98	kotlin/l/b/a/b/h/e:aac	()I
      //   46: istore 4
      //   48: iload 4
      //   50: lookupswitch	default:+298->348, 0:+301->351, 8:+52->102, 18:+112->162
      //   85: aload_1
      //   86: aload 7
      //   88: aload_2
      //   89: iload 4
      //   91: invokevirtual 101	kotlin/l/b/a/b/e/a$a$a:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
      //   94: ifne -56 -> 38
      //   97: iconst_1
      //   98: istore_3
      //   99: goto -61 -> 38
      //   102: aload_0
      //   103: aload_0
      //   104: getfield 103	kotlin/l/b/a/b/e/a$a$a:bitField0_	I
      //   107: iconst_1
      //   108: ior
      //   109: putfield 103	kotlin/l/b/a/b/e/a$a$a:bitField0_	I
      //   112: aload_0
      //   113: aload_1
      //   114: invokevirtual 106	kotlin/l/b/a/b/h/e:aar	()I
      //   117: putfield 108	kotlin/l/b/a/b/e/a$a$a:aiYe	I
      //   120: goto -82 -> 38
      //   123: astore_1
      //   124: aload_1
      //   125: aload_0
      //   126: putfield 112	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   129: ldc 83
      //   131: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   134: aload_1
      //   135: athrow
      //   136: astore_1
      //   137: aload 7
      //   139: invokevirtual 115	kotlin/l/b/a/b/h/f:flush	()V
      //   142: aload_0
      //   143: aload 6
      //   145: invokevirtual 121	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
      //   148: putfield 77	kotlin/l/b/a/b/e/a$a$a:aiXZ	Lkotlin/l/b/a/b/h/d;
      //   151: aload_0
      //   152: invokevirtual 124	kotlin/l/b/a/b/e/a$a$a:makeExtensionsImmutable	()V
      //   155: ldc 83
      //   157: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   160: aload_1
      //   161: athrow
      //   162: aload_0
      //   163: getfield 103	kotlin/l/b/a/b/e/a$a$a:bitField0_	I
      //   166: iconst_2
      //   167: iand
      //   168: iconst_2
      //   169: if_icmpne +173 -> 342
      //   172: aload_0
      //   173: getfield 126	kotlin/l/b/a/b/e/a$a$a:aiYf	Lkotlin/l/b/a/b/e/a$a$a$b;
      //   176: invokestatic 129	kotlin/l/b/a/b/e/a$a$a$b:b	(Lkotlin/l/b/a/b/e/a$a$a$b;)Lkotlin/l/b/a/b/e/a$a$a$b$a;
      //   179: astore 5
      //   181: aload_0
      //   182: aload_1
      //   183: getstatic 130	kotlin/l/b/a/b/e/a$a$a$b:aiYa	Lkotlin/l/b/a/b/h/t;
      //   186: aload_2
      //   187: invokevirtual 133	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
      //   190: checkcast 17	kotlin/l/b/a/b/e/a$a$a$b
      //   193: putfield 126	kotlin/l/b/a/b/e/a$a$a:aiYf	Lkotlin/l/b/a/b/e/a$a$a$b;
      //   196: aload 5
      //   198: ifnull +22 -> 220
      //   201: aload 5
      //   203: aload_0
      //   204: getfield 126	kotlin/l/b/a/b/e/a$a$a:aiYf	Lkotlin/l/b/a/b/e/a$a$a$b;
      //   207: invokevirtual 136	kotlin/l/b/a/b/e/a$a$a$b$a:e	(Lkotlin/l/b/a/b/e/a$a$a$b;)Lkotlin/l/b/a/b/e/a$a$a$b$a;
      //   210: pop
      //   211: aload_0
      //   212: aload 5
      //   214: invokevirtual 140	kotlin/l/b/a/b/e/a$a$a$b$a:ktD	()Lkotlin/l/b/a/b/e/a$a$a$b;
      //   217: putfield 126	kotlin/l/b/a/b/e/a$a$a:aiYf	Lkotlin/l/b/a/b/e/a$a$a$b;
      //   220: aload_0
      //   221: aload_0
      //   222: getfield 103	kotlin/l/b/a/b/e/a$a$a:bitField0_	I
      //   225: iconst_2
      //   226: ior
      //   227: putfield 103	kotlin/l/b/a/b/e/a$a$a:bitField0_	I
      //   230: goto -192 -> 38
      //   233: astore_1
      //   234: new 80	kotlin/l/b/a/b/h/l
      //   237: dup
      //   238: aload_1
      //   239: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
      //   242: invokespecial 147	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
      //   245: astore_1
      //   246: aload_1
      //   247: aload_0
      //   248: putfield 112	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   251: ldc 83
      //   253: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   256: aload_1
      //   257: athrow
      //   258: aload 7
      //   260: invokevirtual 115	kotlin/l/b/a/b/h/f:flush	()V
      //   263: aload_0
      //   264: aload 6
      //   266: invokevirtual 121	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
      //   269: putfield 77	kotlin/l/b/a/b/e/a$a$a:aiXZ	Lkotlin/l/b/a/b/h/d;
      //   272: aload_0
      //   273: invokevirtual 124	kotlin/l/b/a/b/e/a$a$a:makeExtensionsImmutable	()V
      //   276: ldc 83
      //   278: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   281: return
      //   282: astore_1
      //   283: aload_0
      //   284: aload 6
      //   286: invokevirtual 121	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
      //   289: putfield 77	kotlin/l/b/a/b/e/a$a$a:aiXZ	Lkotlin/l/b/a/b/h/d;
      //   292: goto -20 -> 272
      //   295: astore_1
      //   296: aload_0
      //   297: aload 6
      //   299: invokevirtual 121	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
      //   302: putfield 77	kotlin/l/b/a/b/e/a$a$a:aiXZ	Lkotlin/l/b/a/b/h/d;
      //   305: ldc 83
      //   307: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   310: aload_1
      //   311: athrow
      //   312: astore_2
      //   313: aload_0
      //   314: aload 6
      //   316: invokevirtual 121	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
      //   319: putfield 77	kotlin/l/b/a/b/e/a$a$a:aiXZ	Lkotlin/l/b/a/b/h/d;
      //   322: goto -171 -> 151
      //   325: astore_1
      //   326: aload_0
      //   327: aload 6
      //   329: invokevirtual 121	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
      //   332: putfield 77	kotlin/l/b/a/b/e/a$a$a:aiXZ	Lkotlin/l/b/a/b/h/d;
      //   335: ldc 83
      //   337: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   340: aload_1
      //   341: athrow
      //   342: aconst_null
      //   343: astore 5
      //   345: goto -164 -> 181
      //   348: goto -264 -> 84
      //   351: iconst_1
      //   352: istore_3
      //   353: goto -315 -> 38
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	356	0	this	a
      //   0	356	1	parame	kotlin.l.b.a.b.h.e
      //   0	356	2	paramg	kotlin.l.b.a.b.h.g
      //   37	316	3	i	int
      //   46	44	4	j	int
      //   179	165	5	locala	a.a.a.b.a
      //   26	302	6	localb	kotlin.l.b.a.b.h.d.b
      //   34	225	7	localf	f
      // Exception table:
      //   from	to	target	type
      //   42	48	123	kotlin/l/b/a/b/h/l
      //   84	97	123	kotlin/l/b/a/b/h/l
      //   102	120	123	kotlin/l/b/a/b/h/l
      //   162	181	123	kotlin/l/b/a/b/h/l
      //   181	196	123	kotlin/l/b/a/b/h/l
      //   201	220	123	kotlin/l/b/a/b/h/l
      //   220	230	123	kotlin/l/b/a/b/h/l
      //   42	48	136	finally
      //   84	97	136	finally
      //   102	120	136	finally
      //   124	136	136	finally
      //   162	181	136	finally
      //   181	196	136	finally
      //   201	220	136	finally
      //   220	230	136	finally
      //   234	258	136	finally
      //   42	48	233	java/io/IOException
      //   84	97	233	java/io/IOException
      //   102	120	233	java/io/IOException
      //   162	181	233	java/io/IOException
      //   181	196	233	java/io/IOException
      //   201	220	233	java/io/IOException
      //   220	230	233	java/io/IOException
      //   258	263	282	java/io/IOException
      //   258	263	295	finally
      //   137	142	312	java/io/IOException
      //   137	142	325	finally
    }
    
    private a(i.a parama)
    {
      super();
      this.aiXZ = parama.aiXZ;
    }
    
    private void ktf()
    {
      AppMethodBeat.i(58356);
      this.aiYe = 0;
      this.aiYf = b.ktu();
      AppMethodBeat.o(58356);
    }
    
    public static a ktk()
    {
      return aiYd;
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(58358);
      getSerializedSize();
      if ((this.bitField0_ & 0x1) == 1) {
        paramf.cF(1, this.aiYe);
      }
      if ((this.bitField0_ & 0x2) == 2) {
        paramf.a(2, this.aiYf);
      }
      paramf.e(this.aiXZ);
      AppMethodBeat.o(58358);
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(58359);
      int i = this.dRJ;
      if (i != -1)
      {
        AppMethodBeat.o(58359);
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) == 1) {
        i = f.cJ(1, this.aiYe) + 0;
      }
      int j = i;
      if ((this.bitField0_ & 0x2) == 2) {
        j = i + f.c(2, this.aiYf);
      }
      i = j + this.aiXZ.size();
      this.dRJ = i;
      AppMethodBeat.o(58359);
      return i;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58357);
      int i = this.memoizedIsInitialized;
      if (i == 1)
      {
        AppMethodBeat.o(58357);
        return true;
      }
      if (i == 0)
      {
        AppMethodBeat.o(58357);
        return false;
      }
      if (!ktl())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58357);
        return false;
      }
      if (!ktm())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58357);
        return false;
      }
      if (!this.aiYf.isInitialized())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(58357);
        return false;
      }
      this.memoizedIsInitialized = 1;
      AppMethodBeat.o(58357);
      return true;
    }
    
    public final boolean ktl()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public final boolean ktm()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public static final class a
      extends i.a<a.a.a, a>
      implements c
    {
      private int aiYe;
      private a.a.a.b aiYf;
      private int bitField0_;
      
      private a()
      {
        AppMethodBeat.i(58304);
        this.aiYf = a.a.a.b.ktu();
        AppMethodBeat.o(58304);
      }
      
      private a a(a.a.a.b paramb)
      {
        AppMethodBeat.i(58310);
        if (((this.bitField0_ & 0x2) == 2) && (this.aiYf != a.a.a.b.ktu())) {}
        for (this.aiYf = a.a.a.b.b(this.aiYf).e(paramb).ktD();; this.aiYf = paramb)
        {
          this.bitField0_ |= 0x2;
          AppMethodBeat.o(58310);
          return this;
        }
      }
      
      private a aKB(int paramInt)
      {
        this.bitField0_ |= 0x1;
        this.aiYe = paramInt;
        return this;
      }
      
      /* Error */
      private a b(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
      {
        // Byte code:
        //   0: ldc 66
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 70	kotlin/l/b/a/b/e/a$a$a:aiYa	Lkotlin/l/b/a/b/h/t;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 75 3 0
        //   17: checkcast 14	kotlin/l/b/a/b/e/a$a$a
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 78	kotlin/l/b/a/b/e/a$a$a$a:b	(Lkotlin/l/b/a/b/e/a$a$a;)Lkotlin/l/b/a/b/e/a$a$a$a;
        //   30: pop
        //   31: ldc 66
        //   33: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 82	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
        //   43: checkcast 14	kotlin/l/b/a/b/e/a$a$a
        //   46: astore_2
        //   47: ldc 66
        //   49: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   52: aload_1
        //   53: athrow
        //   54: astore_1
        //   55: aload_2
        //   56: ifnull +9 -> 65
        //   59: aload_0
        //   60: aload_2
        //   61: invokevirtual 78	kotlin/l/b/a/b/e/a$a$a$a:b	(Lkotlin/l/b/a/b/e/a$a$a;)Lkotlin/l/b/a/b/e/a$a$a$a;
        //   64: pop
        //   65: ldc 66
        //   67: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      
      private a ktn()
      {
        AppMethodBeat.i(58305);
        a locala = new a().b(kto());
        AppMethodBeat.o(58305);
        return locala;
      }
      
      private a.a.a kto()
      {
        int i = 1;
        AppMethodBeat.i(58306);
        a.a.a locala = new a.a.a(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          a.a.a.a(locala, this.aiYe);
          int j = i;
          if ((k & 0x2) == 2) {
            j = i | 0x2;
          }
          a.a.a.a(locala, this.aiYf);
          a.a.a.b(locala, j);
          AppMethodBeat.o(58306);
          return locala;
          i = 0;
        }
      }
      
      public final a b(a.a.a parama)
      {
        AppMethodBeat.i(58307);
        if (parama == a.a.a.ktk())
        {
          AppMethodBeat.o(58307);
          return this;
        }
        if (parama.ktl()) {
          aKB(parama.aiYe);
        }
        if (parama.ktm()) {
          a(parama.aiYf);
        }
        this.aiXZ = this.aiXZ.a(a.a.a.a(parama));
        AppMethodBeat.o(58307);
        return this;
      }
      
      public final boolean isInitialized()
      {
        AppMethodBeat.i(58308);
        if ((this.bitField0_ & 0x1) == 1) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(58308);
          return false;
        }
        if ((this.bitField0_ & 0x2) == 2) {}
        for (i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(58308);
          return false;
        }
        if (!this.aiYf.isInitialized())
        {
          AppMethodBeat.o(58308);
          return false;
        }
        AppMethodBeat.o(58308);
        return true;
      }
    }
    
    public static final class b
      extends i
      implements b
    {
      public static t<b> aiYa;
      private static final b aiYg;
      private final kotlin.l.b.a.b.h.d aiXZ;
      public b aiYh;
      public long aiYi;
      public float aiYj;
      public int aiYk;
      public int aiYl;
      public int aiYm;
      public a.a aiYn;
      public List<b> aiYo;
      public int aiYp;
      public int aiYq;
      private int bitField0_;
      public double dNT;
      private int dRJ = -1;
      private byte memoizedIsInitialized = -1;
      
      static
      {
        AppMethodBeat.i(58354);
        aiYa = new kotlin.l.b.a.b.h.b() {};
        b localb = new b();
        aiYg = localb;
        localb.ktf();
        AppMethodBeat.o(58354);
      }
      
      private b()
      {
        this.aiXZ = kotlin.l.b.a.b.h.d.ajeU;
      }
      
      /* Error */
      private b(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 77	kotlin/l/b/a/b/h/i:<init>	()V
        //   4: ldc 94
        //   6: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   9: aload_0
        //   10: iconst_m1
        //   11: putfield 79	kotlin/l/b/a/b/e/a$a$a$b:memoizedIsInitialized	B
        //   14: aload_0
        //   15: iconst_m1
        //   16: putfield 81	kotlin/l/b/a/b/e/a$a$a$b:dRJ	I
        //   19: aload_0
        //   20: invokespecial 72	kotlin/l/b/a/b/e/a$a$a$b:ktf	()V
        //   23: invokestatic 98	kotlin/l/b/a/b/h/d:kya	()Lkotlin/l/b/a/b/h/d$b;
        //   26: astore 11
        //   28: aload 11
        //   30: iconst_1
        //   31: invokestatic 103	kotlin/l/b/a/b/h/f:i	(Ljava/io/OutputStream;I)Lkotlin/l/b/a/b/h/f;
        //   34: astore 12
        //   36: iconst_0
        //   37: istore 6
        //   39: iconst_0
        //   40: istore_3
        //   41: iload 6
        //   43: ifne +913 -> 956
        //   46: iload_3
        //   47: istore 7
        //   49: iload_3
        //   50: istore 5
        //   52: iload_3
        //   53: istore 8
        //   55: aload_1
        //   56: invokevirtual 109	kotlin/l/b/a/b/h/e:aac	()I
        //   59: istore 4
        //   61: iload 4
        //   63: lookupswitch	default:+1005->1068, 0:+1008->1071, 8:+133->196, 16:+356->419, 29:+398->461, 33:+440->503, 40:+483->546, 48:+523->586, 56:+563->626, 66:+603->666, 74:+734->797, 80:+811->874, 88:+852->915
        //   169: istore 7
        //   171: iload_3
        //   172: istore 5
        //   174: iload_3
        //   175: istore 8
        //   177: aload_0
        //   178: aload_1
        //   179: aload 12
        //   181: aload_2
        //   182: iload 4
        //   184: invokevirtual 112	kotlin/l/b/a/b/e/a$a$a$b:a	(Lkotlin/l/b/a/b/h/e;Lkotlin/l/b/a/b/h/f;Lkotlin/l/b/a/b/h/g;I)Z
        //   187: ifne -146 -> 41
        //   190: iconst_1
        //   191: istore 6
        //   193: goto -152 -> 41
        //   196: iload_3
        //   197: istore 7
        //   199: iload_3
        //   200: istore 5
        //   202: iload_3
        //   203: istore 8
        //   205: aload_1
        //   206: invokevirtual 115	kotlin/l/b/a/b/h/e:aar	()I
        //   209: istore 9
        //   211: iload_3
        //   212: istore 7
        //   214: iload_3
        //   215: istore 5
        //   217: iload_3
        //   218: istore 8
        //   220: iload 9
        //   222: invokestatic 119	kotlin/l/b/a/b/e/a$a$a$b$b:aKI	(I)Lkotlin/l/b/a/b/e/a$a$a$b$b;
        //   225: astore 10
        //   227: aload 10
        //   229: ifnonnull +112 -> 341
        //   232: iload_3
        //   233: istore 7
        //   235: iload_3
        //   236: istore 5
        //   238: iload_3
        //   239: istore 8
        //   241: aload 12
        //   243: iload 4
        //   245: invokevirtual 122	kotlin/l/b/a/b/h/f:lI	(I)V
        //   248: iload_3
        //   249: istore 7
        //   251: iload_3
        //   252: istore 5
        //   254: iload_3
        //   255: istore 8
        //   257: aload 12
        //   259: iload 9
        //   261: invokevirtual 122	kotlin/l/b/a/b/h/f:lI	(I)V
        //   264: goto -223 -> 41
        //   267: astore_1
        //   268: iload 7
        //   270: istore 5
        //   272: aload_1
        //   273: aload_0
        //   274: putfield 126	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
        //   277: iload 7
        //   279: istore 5
        //   281: ldc 94
        //   283: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   286: iload 7
        //   288: istore 5
        //   290: aload_1
        //   291: athrow
        //   292: astore_1
        //   293: iload 5
        //   295: sipush 256
        //   298: iand
        //   299: sipush 256
        //   302: if_icmpne +14 -> 316
        //   305: aload_0
        //   306: aload_0
        //   307: getfield 128	kotlin/l/b/a/b/e/a$a$a$b:aiYo	Ljava/util/List;
        //   310: invokestatic 134	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
        //   313: putfield 128	kotlin/l/b/a/b/e/a$a$a$b:aiYo	Ljava/util/List;
        //   316: aload 12
        //   318: invokevirtual 137	kotlin/l/b/a/b/h/f:flush	()V
        //   321: aload_0
        //   322: aload 11
        //   324: invokevirtual 143	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
        //   327: putfield 88	kotlin/l/b/a/b/e/a$a$a$b:aiXZ	Lkotlin/l/b/a/b/h/d;
        //   330: aload_0
        //   331: invokevirtual 146	kotlin/l/b/a/b/e/a$a$a$b:makeExtensionsImmutable	()V
        //   334: ldc 94
        //   336: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   339: aload_1
        //   340: athrow
        //   341: iload_3
        //   342: istore 7
        //   344: iload_3
        //   345: istore 5
        //   347: iload_3
        //   348: istore 8
        //   350: aload_0
        //   351: aload_0
        //   352: getfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   355: iconst_1
        //   356: ior
        //   357: putfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   360: iload_3
        //   361: istore 7
        //   363: iload_3
        //   364: istore 5
        //   366: iload_3
        //   367: istore 8
        //   369: aload_0
        //   370: aload 10
        //   372: putfield 150	kotlin/l/b/a/b/e/a$a$a$b:aiYh	Lkotlin/l/b/a/b/e/a$a$a$b$b;
        //   375: goto -334 -> 41
        //   378: astore_1
        //   379: iload 8
        //   381: istore 5
        //   383: new 91	kotlin/l/b/a/b/h/l
        //   386: dup
        //   387: aload_1
        //   388: invokevirtual 154	java/io/IOException:getMessage	()Ljava/lang/String;
        //   391: invokespecial 157	kotlin/l/b/a/b/h/l:<init>	(Ljava/lang/String;)V
        //   394: astore_1
        //   395: iload 8
        //   397: istore 5
        //   399: aload_1
        //   400: aload_0
        //   401: putfield 126	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
        //   404: iload 8
        //   406: istore 5
        //   408: ldc 94
        //   410: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   413: iload 8
        //   415: istore 5
        //   417: aload_1
        //   418: athrow
        //   419: iload_3
        //   420: istore 7
        //   422: iload_3
        //   423: istore 5
        //   425: iload_3
        //   426: istore 8
        //   428: aload_0
        //   429: aload_0
        //   430: getfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   433: iconst_2
        //   434: ior
        //   435: putfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   438: iload_3
        //   439: istore 7
        //   441: iload_3
        //   442: istore 5
        //   444: iload_3
        //   445: istore 8
        //   447: aload_0
        //   448: aload_1
        //   449: invokevirtual 161	kotlin/l/b/a/b/h/e:aaw	()J
        //   452: invokestatic 165	kotlin/l/b/a/b/h/e:cO	(J)J
        //   455: putfield 167	kotlin/l/b/a/b/e/a$a$a$b:aiYi	J
        //   458: goto -417 -> 41
        //   461: iload_3
        //   462: istore 7
        //   464: iload_3
        //   465: istore 5
        //   467: iload_3
        //   468: istore 8
        //   470: aload_0
        //   471: aload_0
        //   472: getfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   475: iconst_4
        //   476: ior
        //   477: putfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   480: iload_3
        //   481: istore 7
        //   483: iload_3
        //   484: istore 5
        //   486: iload_3
        //   487: istore 8
        //   489: aload_0
        //   490: aload_1
        //   491: invokevirtual 170	kotlin/l/b/a/b/h/e:aax	()I
        //   494: invokestatic 176	java/lang/Float:intBitsToFloat	(I)F
        //   497: putfield 178	kotlin/l/b/a/b/e/a$a$a$b:aiYj	F
        //   500: goto -459 -> 41
        //   503: iload_3
        //   504: istore 7
        //   506: iload_3
        //   507: istore 5
        //   509: iload_3
        //   510: istore 8
        //   512: aload_0
        //   513: aload_0
        //   514: getfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   517: bipush 8
        //   519: ior
        //   520: putfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   523: iload_3
        //   524: istore 7
        //   526: iload_3
        //   527: istore 5
        //   529: iload_3
        //   530: istore 8
        //   532: aload_0
        //   533: aload_1
        //   534: invokevirtual 181	kotlin/l/b/a/b/h/e:aay	()J
        //   537: invokestatic 187	java/lang/Double:longBitsToDouble	(J)D
        //   540: putfield 189	kotlin/l/b/a/b/e/a$a$a$b:dNT	D
        //   543: goto -502 -> 41
        //   546: iload_3
        //   547: istore 7
        //   549: iload_3
        //   550: istore 5
        //   552: iload_3
        //   553: istore 8
        //   555: aload_0
        //   556: aload_0
        //   557: getfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   560: bipush 16
        //   562: ior
        //   563: putfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   566: iload_3
        //   567: istore 7
        //   569: iload_3
        //   570: istore 5
        //   572: iload_3
        //   573: istore 8
        //   575: aload_0
        //   576: aload_1
        //   577: invokevirtual 115	kotlin/l/b/a/b/h/e:aar	()I
        //   580: putfield 191	kotlin/l/b/a/b/e/a$a$a$b:aiYk	I
        //   583: goto -542 -> 41
        //   586: iload_3
        //   587: istore 7
        //   589: iload_3
        //   590: istore 5
        //   592: iload_3
        //   593: istore 8
        //   595: aload_0
        //   596: aload_0
        //   597: getfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   600: bipush 32
        //   602: ior
        //   603: putfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   606: iload_3
        //   607: istore 7
        //   609: iload_3
        //   610: istore 5
        //   612: iload_3
        //   613: istore 8
        //   615: aload_0
        //   616: aload_1
        //   617: invokevirtual 115	kotlin/l/b/a/b/h/e:aar	()I
        //   620: putfield 193	kotlin/l/b/a/b/e/a$a$a$b:aiYl	I
        //   623: goto -582 -> 41
        //   626: iload_3
        //   627: istore 7
        //   629: iload_3
        //   630: istore 5
        //   632: iload_3
        //   633: istore 8
        //   635: aload_0
        //   636: aload_0
        //   637: getfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   640: bipush 64
        //   642: ior
        //   643: putfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   646: iload_3
        //   647: istore 7
        //   649: iload_3
        //   650: istore 5
        //   652: iload_3
        //   653: istore 8
        //   655: aload_0
        //   656: aload_1
        //   657: invokevirtual 115	kotlin/l/b/a/b/h/e:aar	()I
        //   660: putfield 195	kotlin/l/b/a/b/e/a$a$a$b:aiYm	I
        //   663: goto -622 -> 41
        //   666: iload_3
        //   667: istore 7
        //   669: iload_3
        //   670: istore 5
        //   672: iload_3
        //   673: istore 8
        //   675: aload_0
        //   676: getfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   679: sipush 128
        //   682: iand
        //   683: sipush 128
        //   686: if_icmpne +376 -> 1062
        //   689: iload_3
        //   690: istore 7
        //   692: iload_3
        //   693: istore 5
        //   695: iload_3
        //   696: istore 8
        //   698: aload_0
        //   699: getfield 197	kotlin/l/b/a/b/e/a$a$a$b:aiYn	Lkotlin/l/b/a/b/e/a$a;
        //   702: invokevirtual 201	kotlin/l/b/a/b/e/a$a:ktg	()Lkotlin/l/b/a/b/e/a$a$b;
        //   705: astore 10
        //   707: iload_3
        //   708: istore 7
        //   710: iload_3
        //   711: istore 5
        //   713: iload_3
        //   714: istore 8
        //   716: aload_0
        //   717: aload_1
        //   718: getstatic 202	kotlin/l/b/a/b/e/a$a:aiYa	Lkotlin/l/b/a/b/h/t;
        //   721: aload_2
        //   722: invokevirtual 205	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
        //   725: checkcast 8	kotlin/l/b/a/b/e/a$a
        //   728: putfield 197	kotlin/l/b/a/b/e/a$a$a$b:aiYn	Lkotlin/l/b/a/b/e/a$a;
        //   731: aload 10
        //   733: ifnull +40 -> 773
        //   736: iload_3
        //   737: istore 7
        //   739: iload_3
        //   740: istore 5
        //   742: iload_3
        //   743: istore 8
        //   745: aload 10
        //   747: aload_0
        //   748: getfield 197	kotlin/l/b/a/b/e/a$a$a$b:aiYn	Lkotlin/l/b/a/b/e/a$a;
        //   751: invokevirtual 211	kotlin/l/b/a/b/e/a$a$b:e	(Lkotlin/l/b/a/b/e/a$a;)Lkotlin/l/b/a/b/e/a$a$b;
        //   754: pop
        //   755: iload_3
        //   756: istore 7
        //   758: iload_3
        //   759: istore 5
        //   761: iload_3
        //   762: istore 8
        //   764: aload_0
        //   765: aload 10
        //   767: invokevirtual 215	kotlin/l/b/a/b/e/a$a$b:ktH	()Lkotlin/l/b/a/b/e/a$a;
        //   770: putfield 197	kotlin/l/b/a/b/e/a$a$a$b:aiYn	Lkotlin/l/b/a/b/e/a$a;
        //   773: iload_3
        //   774: istore 7
        //   776: iload_3
        //   777: istore 5
        //   779: iload_3
        //   780: istore 8
        //   782: aload_0
        //   783: aload_0
        //   784: getfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   787: sipush 128
        //   790: ior
        //   791: putfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   794: goto -753 -> 41
        //   797: iload_3
        //   798: istore 4
        //   800: iload_3
        //   801: sipush 256
        //   804: iand
        //   805: sipush 256
        //   808: if_icmpeq +30 -> 838
        //   811: iload_3
        //   812: istore 7
        //   814: iload_3
        //   815: istore 5
        //   817: iload_3
        //   818: istore 8
        //   820: aload_0
        //   821: new 217	java/util/ArrayList
        //   824: dup
        //   825: invokespecial 218	java/util/ArrayList:<init>	()V
        //   828: putfield 128	kotlin/l/b/a/b/e/a$a$a$b:aiYo	Ljava/util/List;
        //   831: iload_3
        //   832: sipush 256
        //   835: ior
        //   836: istore 4
        //   838: iload 4
        //   840: istore 7
        //   842: iload 4
        //   844: istore 5
        //   846: iload 4
        //   848: istore 8
        //   850: aload_0
        //   851: getfield 128	kotlin/l/b/a/b/e/a$a$a$b:aiYo	Ljava/util/List;
        //   854: aload_1
        //   855: getstatic 66	kotlin/l/b/a/b/e/a$a$a$b:aiYa	Lkotlin/l/b/a/b/h/t;
        //   858: aload_2
        //   859: invokevirtual 205	kotlin/l/b/a/b/h/e:a	(Lkotlin/l/b/a/b/h/t;Lkotlin/l/b/a/b/h/g;)Lkotlin/l/b/a/b/h/r;
        //   862: invokeinterface 224 2 0
        //   867: pop
        //   868: iload 4
        //   870: istore_3
        //   871: goto -830 -> 41
        //   874: iload_3
        //   875: istore 7
        //   877: iload_3
        //   878: istore 5
        //   880: iload_3
        //   881: istore 8
        //   883: aload_0
        //   884: aload_0
        //   885: getfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   888: sipush 512
        //   891: ior
        //   892: putfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   895: iload_3
        //   896: istore 7
        //   898: iload_3
        //   899: istore 5
        //   901: iload_3
        //   902: istore 8
        //   904: aload_0
        //   905: aload_1
        //   906: invokevirtual 115	kotlin/l/b/a/b/h/e:aar	()I
        //   909: putfield 226	kotlin/l/b/a/b/e/a$a$a$b:aiYq	I
        //   912: goto -871 -> 41
        //   915: iload_3
        //   916: istore 7
        //   918: iload_3
        //   919: istore 5
        //   921: iload_3
        //   922: istore 8
        //   924: aload_0
        //   925: aload_0
        //   926: getfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   929: sipush 256
        //   932: ior
        //   933: putfield 148	kotlin/l/b/a/b/e/a$a$a$b:bitField0_	I
        //   936: iload_3
        //   937: istore 7
        //   939: iload_3
        //   940: istore 5
        //   942: iload_3
        //   943: istore 8
        //   945: aload_0
        //   946: aload_1
        //   947: invokevirtual 115	kotlin/l/b/a/b/h/e:aar	()I
        //   950: putfield 228	kotlin/l/b/a/b/e/a$a$a$b:aiYp	I
        //   953: goto -912 -> 41
        //   956: iload_3
        //   957: sipush 256
        //   960: iand
        //   961: sipush 256
        //   964: if_icmpne +14 -> 978
        //   967: aload_0
        //   968: aload_0
        //   969: getfield 128	kotlin/l/b/a/b/e/a$a$a$b:aiYo	Ljava/util/List;
        //   972: invokestatic 134	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
        //   975: putfield 128	kotlin/l/b/a/b/e/a$a$a$b:aiYo	Ljava/util/List;
        //   978: aload 12
        //   980: invokevirtual 137	kotlin/l/b/a/b/h/f:flush	()V
        //   983: aload_0
        //   984: aload 11
        //   986: invokevirtual 143	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
        //   989: putfield 88	kotlin/l/b/a/b/e/a$a$a$b:aiXZ	Lkotlin/l/b/a/b/h/d;
        //   992: aload_0
        //   993: invokevirtual 146	kotlin/l/b/a/b/e/a$a$a$b:makeExtensionsImmutable	()V
        //   996: ldc 94
        //   998: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1001: return
        //   1002: astore_1
        //   1003: aload_0
        //   1004: aload 11
        //   1006: invokevirtual 143	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
        //   1009: putfield 88	kotlin/l/b/a/b/e/a$a$a$b:aiXZ	Lkotlin/l/b/a/b/h/d;
        //   1012: goto -20 -> 992
        //   1015: astore_1
        //   1016: aload_0
        //   1017: aload 11
        //   1019: invokevirtual 143	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
        //   1022: putfield 88	kotlin/l/b/a/b/e/a$a$a$b:aiXZ	Lkotlin/l/b/a/b/h/d;
        //   1025: ldc 94
        //   1027: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1030: aload_1
        //   1031: athrow
        //   1032: astore_2
        //   1033: aload_0
        //   1034: aload 11
        //   1036: invokevirtual 143	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
        //   1039: putfield 88	kotlin/l/b/a/b/e/a$a$a$b:aiXZ	Lkotlin/l/b/a/b/h/d;
        //   1042: goto -712 -> 330
        //   1045: astore_1
        //   1046: aload_0
        //   1047: aload 11
        //   1049: invokevirtual 143	kotlin/l/b/a/b/h/d$b:kyc	()Lkotlin/l/b/a/b/h/d;
        //   1052: putfield 88	kotlin/l/b/a/b/e/a$a$a$b:aiXZ	Lkotlin/l/b/a/b/h/d;
        //   1055: ldc 94
        //   1057: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1060: aload_1
        //   1061: athrow
        //   1062: aconst_null
        //   1063: astore 10
        //   1065: goto -358 -> 707
        //   1068: goto -900 -> 168
        //   1071: iconst_1
        //   1072: istore 6
        //   1074: goto -1033 -> 41
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1077	0	this	b
        //   0	1077	1	parame	kotlin.l.b.a.b.h.e
        //   0	1077	2	paramg	kotlin.l.b.a.b.h.g
        //   40	921	3	i	int
        //   59	810	4	j	int
        //   50	891	5	k	int
        //   37	1036	6	m	int
        //   47	891	7	n	int
        //   53	891	8	i1	int
        //   209	51	9	i2	int
        //   225	839	10	localObject	Object
        //   26	1022	11	localb	kotlin.l.b.a.b.h.d.b
        //   34	945	12	localf	f
        // Exception table:
        //   from	to	target	type
        //   55	61	267	kotlin/l/b/a/b/h/l
        //   177	190	267	kotlin/l/b/a/b/h/l
        //   205	211	267	kotlin/l/b/a/b/h/l
        //   220	227	267	kotlin/l/b/a/b/h/l
        //   241	248	267	kotlin/l/b/a/b/h/l
        //   257	264	267	kotlin/l/b/a/b/h/l
        //   350	360	267	kotlin/l/b/a/b/h/l
        //   369	375	267	kotlin/l/b/a/b/h/l
        //   428	438	267	kotlin/l/b/a/b/h/l
        //   447	458	267	kotlin/l/b/a/b/h/l
        //   470	480	267	kotlin/l/b/a/b/h/l
        //   489	500	267	kotlin/l/b/a/b/h/l
        //   512	523	267	kotlin/l/b/a/b/h/l
        //   532	543	267	kotlin/l/b/a/b/h/l
        //   555	566	267	kotlin/l/b/a/b/h/l
        //   575	583	267	kotlin/l/b/a/b/h/l
        //   595	606	267	kotlin/l/b/a/b/h/l
        //   615	623	267	kotlin/l/b/a/b/h/l
        //   635	646	267	kotlin/l/b/a/b/h/l
        //   655	663	267	kotlin/l/b/a/b/h/l
        //   675	689	267	kotlin/l/b/a/b/h/l
        //   698	707	267	kotlin/l/b/a/b/h/l
        //   716	731	267	kotlin/l/b/a/b/h/l
        //   745	755	267	kotlin/l/b/a/b/h/l
        //   764	773	267	kotlin/l/b/a/b/h/l
        //   782	794	267	kotlin/l/b/a/b/h/l
        //   820	831	267	kotlin/l/b/a/b/h/l
        //   850	868	267	kotlin/l/b/a/b/h/l
        //   883	895	267	kotlin/l/b/a/b/h/l
        //   904	912	267	kotlin/l/b/a/b/h/l
        //   924	936	267	kotlin/l/b/a/b/h/l
        //   945	953	267	kotlin/l/b/a/b/h/l
        //   55	61	292	finally
        //   177	190	292	finally
        //   205	211	292	finally
        //   220	227	292	finally
        //   241	248	292	finally
        //   257	264	292	finally
        //   272	277	292	finally
        //   281	286	292	finally
        //   290	292	292	finally
        //   350	360	292	finally
        //   369	375	292	finally
        //   383	395	292	finally
        //   399	404	292	finally
        //   408	413	292	finally
        //   417	419	292	finally
        //   428	438	292	finally
        //   447	458	292	finally
        //   470	480	292	finally
        //   489	500	292	finally
        //   512	523	292	finally
        //   532	543	292	finally
        //   555	566	292	finally
        //   575	583	292	finally
        //   595	606	292	finally
        //   615	623	292	finally
        //   635	646	292	finally
        //   655	663	292	finally
        //   675	689	292	finally
        //   698	707	292	finally
        //   716	731	292	finally
        //   745	755	292	finally
        //   764	773	292	finally
        //   782	794	292	finally
        //   820	831	292	finally
        //   850	868	292	finally
        //   883	895	292	finally
        //   904	912	292	finally
        //   924	936	292	finally
        //   945	953	292	finally
        //   55	61	378	java/io/IOException
        //   177	190	378	java/io/IOException
        //   205	211	378	java/io/IOException
        //   220	227	378	java/io/IOException
        //   241	248	378	java/io/IOException
        //   257	264	378	java/io/IOException
        //   350	360	378	java/io/IOException
        //   369	375	378	java/io/IOException
        //   428	438	378	java/io/IOException
        //   447	458	378	java/io/IOException
        //   470	480	378	java/io/IOException
        //   489	500	378	java/io/IOException
        //   512	523	378	java/io/IOException
        //   532	543	378	java/io/IOException
        //   555	566	378	java/io/IOException
        //   575	583	378	java/io/IOException
        //   595	606	378	java/io/IOException
        //   615	623	378	java/io/IOException
        //   635	646	378	java/io/IOException
        //   655	663	378	java/io/IOException
        //   675	689	378	java/io/IOException
        //   698	707	378	java/io/IOException
        //   716	731	378	java/io/IOException
        //   745	755	378	java/io/IOException
        //   764	773	378	java/io/IOException
        //   782	794	378	java/io/IOException
        //   820	831	378	java/io/IOException
        //   850	868	378	java/io/IOException
        //   883	895	378	java/io/IOException
        //   904	912	378	java/io/IOException
        //   924	936	378	java/io/IOException
        //   945	953	378	java/io/IOException
        //   978	983	1002	java/io/IOException
        //   978	983	1015	finally
        //   316	321	1032	java/io/IOException
        //   316	321	1045	finally
      }
      
      private b(i.a parama)
      {
        super();
        this.aiXZ = parama.aiXZ;
      }
      
      public static a b(b paramb)
      {
        AppMethodBeat.i(58351);
        paramb = a.ktF().e(paramb);
        AppMethodBeat.o(58351);
        return paramb;
      }
      
      private void ktf()
      {
        AppMethodBeat.i(58347);
        this.aiYh = b.aiYr;
        this.aiYi = 0L;
        this.aiYj = 0.0F;
        this.dNT = 0.0D;
        this.aiYk = 0;
        this.aiYl = 0;
        this.aiYm = 0;
        this.aiYn = a.a.ktd();
        this.aiYo = Collections.emptyList();
        this.aiYp = 0;
        this.aiYq = 0;
        AppMethodBeat.o(58347);
      }
      
      public static b ktu()
      {
        return aiYg;
      }
      
      public final void a(f paramf)
      {
        AppMethodBeat.i(58349);
        getSerializedSize();
        if ((this.bitField0_ & 0x1) == 1) {
          paramf.cP(1, this.aiYh.value);
        }
        if ((this.bitField0_ & 0x2) == 2)
        {
          long l = this.aiYi;
          paramf.cE(2, 0);
          paramf.cQ(l);
        }
        if ((this.bitField0_ & 0x4) == 4)
        {
          float f = this.aiYj;
          paramf.cE(3, 5);
          paramf.bd(f);
        }
        if ((this.bitField0_ & 0x8) == 8)
        {
          double d = this.dNT;
          paramf.cE(4, 1);
          paramf.u(d);
        }
        if ((this.bitField0_ & 0x10) == 16) {
          paramf.cF(5, this.aiYk);
        }
        if ((this.bitField0_ & 0x20) == 32) {
          paramf.cF(6, this.aiYl);
        }
        if ((this.bitField0_ & 0x40) == 64) {
          paramf.cF(7, this.aiYm);
        }
        if ((this.bitField0_ & 0x80) == 128) {
          paramf.a(8, this.aiYn);
        }
        int i = 0;
        while (i < this.aiYo.size())
        {
          paramf.a(9, (r)this.aiYo.get(i));
          i += 1;
        }
        if ((this.bitField0_ & 0x200) == 512) {
          paramf.cF(10, this.aiYq);
        }
        if ((this.bitField0_ & 0x100) == 256) {
          paramf.cF(11, this.aiYp);
        }
        paramf.e(this.aiXZ);
        AppMethodBeat.o(58349);
      }
      
      public final b aKC(int paramInt)
      {
        AppMethodBeat.i(58346);
        b localb = (b)this.aiYo.get(paramInt);
        AppMethodBeat.o(58346);
        return localb;
      }
      
      public final boolean ady()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      public final boolean agE()
      {
        return (this.bitField0_ & 0x8) == 8;
      }
      
      public final boolean agF()
      {
        return (this.bitField0_ & 0x10) == 16;
      }
      
      public final int getSerializedSize()
      {
        int k = 0;
        AppMethodBeat.i(58350);
        int i = this.dRJ;
        if (i != -1)
        {
          AppMethodBeat.o(58350);
          return i;
        }
        if ((this.bitField0_ & 0x1) == 1) {}
        for (int j = f.cM(1, this.aiYh.value) + 0;; j = 0)
        {
          i = j;
          if ((this.bitField0_ & 0x2) == 2) {
            i = j + f.BI(this.aiYi);
          }
          j = i;
          if ((this.bitField0_ & 0x4) == 4) {
            j = i + (f.ko(3) + 4);
          }
          i = j;
          if ((this.bitField0_ & 0x8) == 8) {
            i = j + (f.ko(4) + 8);
          }
          j = i;
          if ((this.bitField0_ & 0x10) == 16) {
            j = i + f.cJ(5, this.aiYk);
          }
          i = j;
          if ((this.bitField0_ & 0x20) == 32) {
            i = j + f.cJ(6, this.aiYl);
          }
          j = i;
          if ((this.bitField0_ & 0x40) == 64) {
            j = i + f.cJ(7, this.aiYm);
          }
          i = j;
          if ((this.bitField0_ & 0x80) == 128) {
            i = j + f.c(8, this.aiYn);
          }
          j = k;
          while (j < this.aiYo.size())
          {
            k = f.c(9, (r)this.aiYo.get(j));
            j += 1;
            i = k + i;
          }
          j = i;
          if ((this.bitField0_ & 0x200) == 512) {
            j = i + f.cJ(10, this.aiYq);
          }
          i = j;
          if ((this.bitField0_ & 0x100) == 256) {
            i = j + f.cJ(11, this.aiYp);
          }
          i = this.aiXZ.size() + i;
          this.dRJ = i;
          AppMethodBeat.o(58350);
          return i;
        }
      }
      
      public final boolean isInitialized()
      {
        AppMethodBeat.i(58348);
        int i = this.memoizedIsInitialized;
        if (i == 1)
        {
          AppMethodBeat.o(58348);
          return true;
        }
        if (i == 0)
        {
          AppMethodBeat.o(58348);
          return false;
        }
        if ((ktz()) && (!this.aiYn.isInitialized()))
        {
          this.memoizedIsInitialized = 0;
          AppMethodBeat.o(58348);
          return false;
        }
        i = 0;
        while (i < this.aiYo.size())
        {
          if (!aKC(i).isInitialized())
          {
            this.memoizedIsInitialized = 0;
            AppMethodBeat.o(58348);
            return false;
          }
          i += 1;
        }
        this.memoizedIsInitialized = 1;
        AppMethodBeat.o(58348);
        return true;
      }
      
      public final boolean ktA()
      {
        return (this.bitField0_ & 0x100) == 256;
      }
      
      public final boolean ktB()
      {
        return (this.bitField0_ & 0x200) == 512;
      }
      
      public final boolean ktv()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      public final boolean ktw()
      {
        return (this.bitField0_ & 0x4) == 4;
      }
      
      public final boolean ktx()
      {
        return (this.bitField0_ & 0x20) == 32;
      }
      
      public final boolean kty()
      {
        return (this.bitField0_ & 0x40) == 64;
      }
      
      public final boolean ktz()
      {
        return (this.bitField0_ & 0x80) == 128;
      }
      
      public static final class a
        extends i.a<a.a.a.b, a>
        implements b
      {
        private a.a.a.b.b aiYh;
        private long aiYi;
        private float aiYj;
        private int aiYk;
        private int aiYl;
        private int aiYm;
        private a.a aiYn;
        private List<a.a.a.b> aiYo;
        private int aiYp;
        private int aiYq;
        private int bitField0_;
        private double dNT;
        
        private a()
        {
          AppMethodBeat.i(58322);
          this.aiYh = a.a.a.b.b.aiYr;
          this.aiYn = a.a.ktd();
          this.aiYo = Collections.emptyList();
          AppMethodBeat.o(58322);
        }
        
        private a BH(long paramLong)
        {
          this.bitField0_ |= 0x2;
          this.aiYi = paramLong;
          return this;
        }
        
        private a a(a.a.a.b.b paramb)
        {
          AppMethodBeat.i(58328);
          if (paramb == null)
          {
            paramb = new NullPointerException();
            AppMethodBeat.o(58328);
            throw paramb;
          }
          this.bitField0_ |= 0x1;
          this.aiYh = paramb;
          AppMethodBeat.o(58328);
          return this;
        }
        
        private a aKD(int paramInt)
        {
          this.bitField0_ |= 0x10;
          this.aiYk = paramInt;
          return this;
        }
        
        private a aKE(int paramInt)
        {
          this.bitField0_ |= 0x20;
          this.aiYl = paramInt;
          return this;
        }
        
        private a aKF(int paramInt)
        {
          this.bitField0_ |= 0x40;
          this.aiYm = paramInt;
          return this;
        }
        
        private a aKG(int paramInt)
        {
          this.bitField0_ |= 0x200;
          this.aiYp = paramInt;
          return this;
        }
        
        private a aKH(int paramInt)
        {
          this.bitField0_ |= 0x400;
          this.aiYq = paramInt;
          return this;
        }
        
        private a ak(double paramDouble)
        {
          this.bitField0_ |= 0x8;
          this.dNT = paramDouble;
          return this;
        }
        
        private a d(a.a parama)
        {
          AppMethodBeat.i(58329);
          if (((this.bitField0_ & 0x80) == 128) && (this.aiYn != a.a.ktd())) {}
          for (this.aiYn = a.a.a(this.aiYn).e(parama).ktH();; this.aiYn = parama)
          {
            this.bitField0_ |= 0x80;
            AppMethodBeat.o(58329);
            return this;
          }
        }
        
        /* Error */
        private a e(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
        {
          // Byte code:
          //   0: ldc 122
          //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aconst_null
          //   6: astore_3
          //   7: getstatic 126	kotlin/l/b/a/b/e/a$a$a$b:aiYa	Lkotlin/l/b/a/b/h/t;
          //   10: aload_1
          //   11: aload_2
          //   12: invokeinterface 131 3 0
          //   17: checkcast 16	kotlin/l/b/a/b/e/a$a$a$b
          //   20: astore_1
          //   21: aload_1
          //   22: ifnull +9 -> 31
          //   25: aload_0
          //   26: aload_1
          //   27: invokevirtual 134	kotlin/l/b/a/b/e/a$a$a$b$a:e	(Lkotlin/l/b/a/b/e/a$a$a$b;)Lkotlin/l/b/a/b/e/a$a$a$b$a;
          //   30: pop
          //   31: ldc 122
          //   33: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   36: aload_0
          //   37: areturn
          //   38: astore_1
          //   39: aload_1
          //   40: getfield 138	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
          //   43: checkcast 16	kotlin/l/b/a/b/e/a$a$a$b
          //   46: astore_2
          //   47: ldc 122
          //   49: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   52: aload_1
          //   53: athrow
          //   54: astore_1
          //   55: aload_2
          //   56: ifnull +9 -> 65
          //   59: aload_0
          //   60: aload_2
          //   61: invokevirtual 134	kotlin/l/b/a/b/e/a$a$a$b$a:e	(Lkotlin/l/b/a/b/e/a$a$a$b;)Lkotlin/l/b/a/b/e/a$a$a$b$a;
          //   64: pop
          //   65: ldc 122
          //   67: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
        
        private a eI(float paramFloat)
        {
          this.bitField0_ |= 0x4;
          this.aiYj = paramFloat;
          return this;
        }
        
        private a ktC()
        {
          AppMethodBeat.i(58323);
          a locala = new a().e(ktD());
          AppMethodBeat.o(58323);
          return locala;
        }
        
        private void ktE()
        {
          AppMethodBeat.i(58330);
          if ((this.bitField0_ & 0x100) != 256)
          {
            this.aiYo = new ArrayList(this.aiYo);
            this.bitField0_ |= 0x100;
          }
          AppMethodBeat.o(58330);
        }
        
        public final a e(a.a.a.b paramb)
        {
          AppMethodBeat.i(58325);
          if (paramb == a.a.a.b.ktu())
          {
            AppMethodBeat.o(58325);
            return this;
          }
          if (paramb.ady()) {
            a(paramb.aiYh);
          }
          if (paramb.ktv()) {
            BH(paramb.aiYi);
          }
          if (paramb.ktw()) {
            eI(paramb.aiYj);
          }
          if (paramb.agE()) {
            ak(paramb.dNT);
          }
          if (paramb.agF()) {
            aKD(paramb.aiYk);
          }
          if (paramb.ktx()) {
            aKE(paramb.aiYl);
          }
          if (paramb.kty()) {
            aKF(paramb.aiYm);
          }
          if (paramb.ktz()) {
            d(paramb.aiYn);
          }
          if (!a.a.a.b.c(paramb).isEmpty())
          {
            if (!this.aiYo.isEmpty()) {
              break label245;
            }
            this.aiYo = a.a.a.b.c(paramb);
            this.bitField0_ &= 0xFFFFFEFF;
          }
          for (;;)
          {
            if (paramb.ktA()) {
              aKG(paramb.aiYp);
            }
            if (paramb.ktB()) {
              aKH(paramb.aiYq);
            }
            this.aiXZ = this.aiXZ.a(a.a.a.b.d(paramb));
            AppMethodBeat.o(58325);
            return this;
            label245:
            ktE();
            this.aiYo.addAll(a.a.a.b.c(paramb));
          }
        }
        
        public final boolean isInitialized()
        {
          AppMethodBeat.i(58326);
          if ((this.bitField0_ & 0x80) == 128) {}
          for (int i = 1; (i != 0) && (!this.aiYn.isInitialized()); i = 0)
          {
            AppMethodBeat.o(58326);
            return false;
          }
          i = 0;
          while (i < this.aiYo.size())
          {
            if (!((a.a.a.b)this.aiYo.get(i)).isInitialized())
            {
              AppMethodBeat.o(58326);
              return false;
            }
            i += 1;
          }
          AppMethodBeat.o(58326);
          return true;
        }
        
        public final a.a.a.b ktD()
        {
          int j = 1;
          AppMethodBeat.i(58324);
          a.a.a.b localb = new a.a.a.b(this, (byte)0);
          int k = this.bitField0_;
          if ((k & 0x1) == 1) {}
          for (;;)
          {
            a.a.a.b.a(localb, this.aiYh);
            int i = j;
            if ((k & 0x2) == 2) {
              i = j | 0x2;
            }
            a.a.a.b.a(localb, this.aiYi);
            j = i;
            if ((k & 0x4) == 4) {
              j = i | 0x4;
            }
            a.a.a.b.a(localb, this.aiYj);
            i = j;
            if ((k & 0x8) == 8) {
              i = j | 0x8;
            }
            a.a.a.b.a(localb, this.dNT);
            j = i;
            if ((k & 0x10) == 16) {
              j = i | 0x10;
            }
            a.a.a.b.a(localb, this.aiYk);
            i = j;
            if ((k & 0x20) == 32) {
              i = j | 0x20;
            }
            a.a.a.b.b(localb, this.aiYl);
            j = i;
            if ((k & 0x40) == 64) {
              j = i | 0x40;
            }
            a.a.a.b.c(localb, this.aiYm);
            i = j;
            if ((k & 0x80) == 128) {
              i = j | 0x80;
            }
            a.a.a.b.a(localb, this.aiYn);
            if ((this.bitField0_ & 0x100) == 256)
            {
              this.aiYo = Collections.unmodifiableList(this.aiYo);
              this.bitField0_ &= 0xFFFFFEFF;
            }
            a.a.a.b.a(localb, this.aiYo);
            j = i;
            if ((k & 0x200) == 512) {
              j = i | 0x100;
            }
            a.a.a.b.d(localb, this.aiYp);
            i = j;
            if ((k & 0x400) == 1024) {
              i = j | 0x200;
            }
            a.a.a.b.e(localb, this.aiYq);
            a.a.a.b.f(localb, i);
            AppMethodBeat.o(58324);
            return localb;
            j = 0;
          }
        }
      }
      
      public static enum b
        implements k.a
      {
        private static k.b<b> aiYE;
        final int value;
        
        static
        {
          AppMethodBeat.i(58344);
          aiYr = new b("BYTE", 0, 0);
          aiYs = new b("CHAR", 1, 1);
          aiYt = new b("SHORT", 2, 2);
          aiYu = new b("INT", 3, 3);
          aiYv = new b("LONG", 4, 4);
          aiYw = new b("FLOAT", 5, 5);
          aiYx = new b("DOUBLE", 6, 6);
          aiYy = new b("BOOLEAN", 7, 7);
          aiYz = new b("STRING", 8, 8);
          aiYA = new b("CLASS", 9, 9);
          aiYB = new b("ENUM", 10, 10);
          aiYC = new b("ANNOTATION", 11, 11);
          aiYD = new b("ARRAY", 12, 12);
          aiYF = new b[] { aiYr, aiYs, aiYt, aiYu, aiYv, aiYw, aiYx, aiYy, aiYz, aiYA, aiYB, aiYC, aiYD };
          aiYE = new k.b() {};
          AppMethodBeat.o(58344);
        }
        
        private b(int paramInt)
        {
          this.value = paramInt;
        }
        
        public static b aKI(int paramInt)
        {
          switch (paramInt)
          {
          default: 
            return null;
          case 0: 
            return aiYr;
          case 1: 
            return aiYs;
          case 2: 
            return aiYt;
          case 3: 
            return aiYu;
          case 4: 
            return aiYv;
          case 5: 
            return aiYw;
          case 6: 
            return aiYx;
          case 7: 
            return aiYy;
          case 8: 
            return aiYz;
          case 9: 
            return aiYA;
          case 10: 
            return aiYB;
          case 11: 
            return aiYC;
          }
          return aiYD;
        }
        
        public final int getNumber()
        {
          return this.value;
        }
      }
    }
  }
  
  public static final class b
    extends i.a<a.a, b>
    implements d
  {
    private int aiYb;
    private List<a.a.a> aiYc;
    private int bitField0_;
    
    private b()
    {
      AppMethodBeat.i(58363);
      this.aiYc = Collections.emptyList();
      AppMethodBeat.o(58363);
    }
    
    private b aKK(int paramInt)
    {
      this.bitField0_ |= 0x1;
      this.aiYb = paramInt;
      return this;
    }
    
    /* Error */
    private b f(kotlin.l.b.a.b.h.e parame, kotlin.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 53
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 57	kotlin/l/b/a/b/e/a$a:aiYa	Lkotlin/l/b/a/b/h/t;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 62 3 0
      //   17: checkcast 9	kotlin/l/b/a/b/e/a$a
      //   20: astore_1
      //   21: aload_1
      //   22: ifnull +9 -> 31
      //   25: aload_0
      //   26: aload_1
      //   27: invokevirtual 66	kotlin/l/b/a/b/e/a$a$b:e	(Lkotlin/l/b/a/b/e/a$a;)Lkotlin/l/b/a/b/e/a$a$b;
      //   30: pop
      //   31: ldc 53
      //   33: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aload_0
      //   37: areturn
      //   38: astore_1
      //   39: aload_1
      //   40: getfield 70	kotlin/l/b/a/b/h/l:ajfp	Lkotlin/l/b/a/b/h/r;
      //   43: checkcast 9	kotlin/l/b/a/b/e/a$a
      //   46: astore_2
      //   47: ldc 53
      //   49: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   52: aload_1
      //   53: athrow
      //   54: astore_1
      //   55: aload_2
      //   56: ifnull +9 -> 65
      //   59: aload_0
      //   60: aload_2
      //   61: invokevirtual 66	kotlin/l/b/a/b/e/a$a$b:e	(Lkotlin/l/b/a/b/e/a$a;)Lkotlin/l/b/a/b/e/a$a$b;
      //   64: pop
      //   65: ldc 53
      //   67: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   70: aload_1
      //   71: athrow
      //   72: astore_1
      //   73: aload_3
      //   74: astore_2
      //   75: goto -20 -> 55
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	b
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
    
    private b ktG()
    {
      AppMethodBeat.i(58364);
      b localb = new b().e(ktH());
      AppMethodBeat.o(58364);
      return localb;
    }
    
    private void ktI()
    {
      AppMethodBeat.i(58369);
      if ((this.bitField0_ & 0x2) != 2)
      {
        this.aiYc = new ArrayList(this.aiYc);
        this.bitField0_ |= 0x2;
      }
      AppMethodBeat.o(58369);
    }
    
    public final b e(a.a parama)
    {
      AppMethodBeat.i(58366);
      if (parama == a.a.ktd())
      {
        AppMethodBeat.o(58366);
        return this;
      }
      if (parama.kte()) {
        aKK(parama.aiYb);
      }
      if (!a.a.b(parama).isEmpty())
      {
        if (!this.aiYc.isEmpty()) {
          break label100;
        }
        this.aiYc = a.a.b(parama);
        this.bitField0_ &= 0xFFFFFFFD;
      }
      for (;;)
      {
        this.aiXZ = this.aiXZ.a(a.a.c(parama));
        AppMethodBeat.o(58366);
        return this;
        label100:
        ktI();
        this.aiYc.addAll(a.a.b(parama));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(58367);
      if ((this.bitField0_ & 0x1) == 1) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(58367);
        return false;
      }
      i = 0;
      while (i < this.aiYc.size())
      {
        if (!((a.a.a)this.aiYc.get(i)).isInitialized())
        {
          AppMethodBeat.o(58367);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(58367);
      return true;
    }
    
    public final a.a ktH()
    {
      int i = 1;
      AppMethodBeat.i(58365);
      a.a locala = new a.a(this, (byte)0);
      if ((this.bitField0_ & 0x1) == 1) {}
      for (;;)
      {
        a.a.a(locala, this.aiYb);
        if ((this.bitField0_ & 0x2) == 2)
        {
          this.aiYc = Collections.unmodifiableList(this.aiYc);
          this.bitField0_ &= 0xFFFFFFFD;
        }
        a.a.a(locala, this.aiYc);
        a.a.b(locala, i);
        AppMethodBeat.o(58365);
        return locala;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.a.a
 * JD-Core Version:    0.7.0.1
 */