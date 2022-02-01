package d.l.b.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.h.b;
import d.l.b.a.b.h.d;
import d.l.b.a.b.h.f;
import d.l.b.a.b.h.i;
import d.l.b.a.b.h.i.a;
import d.l.b.a.b.h.n;
import d.l.b.a.b.h.o;
import d.l.b.a.b.h.s;
import d.l.b.a.b.h.t;

public final class a$o
  extends i
  implements q
{
  public static s<o> JFJ;
  private static final o JIj;
  private final d JFI;
  private byte JFN = -1;
  private int JFO = -1;
  private o JIk;
  
  static
  {
    AppMethodBeat.i(58800);
    JFJ = new b() {};
    o localo = new o();
    JIj = localo;
    localo.JIk = n.JNg;
    AppMethodBeat.o(58800);
  }
  
  private a$o()
  {
    this.JFI = d.JMs;
  }
  
  /* Error */
  private a$o(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 55	d/l/b/a/b/h/i:<init>	()V
    //   4: ldc 72
    //   6: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 57	d/l/b/a/b/e/a$o:JFN	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 59	d/l/b/a/b/e/a$o:JFO	I
    //   19: aload_0
    //   20: getstatic 49	d/l/b/a/b/h/n:JNg	Ld/l/b/a/b/h/o;
    //   23: putfield 51	d/l/b/a/b/e/a$o:JIk	Ld/l/b/a/b/h/o;
    //   26: invokestatic 76	d/l/b/a/b/h/d:fHp	()Ld/l/b/a/b/h/d$b;
    //   29: astore 9
    //   31: aload 9
    //   33: iconst_1
    //   34: invokestatic 82	d/l/b/a/b/h/f:f	(Ljava/io/OutputStream;I)Ld/l/b/a/b/h/f;
    //   37: astore 10
    //   39: iconst_0
    //   40: istore 6
    //   42: iconst_0
    //   43: istore_3
    //   44: iload 6
    //   46: ifne +225 -> 271
    //   49: iload_3
    //   50: istore 7
    //   52: iload_3
    //   53: istore 5
    //   55: iload_3
    //   56: istore 8
    //   58: aload_1
    //   59: invokevirtual 88	d/l/b/a/b/h/e:xR	()I
    //   62: istore 4
    //   64: iload 4
    //   66: lookupswitch	default:+350->416, 0:+353->419, 10:+54->120
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
    //   108: invokevirtual 91	d/l/b/a/b/e/a$o:a	(Ld/l/b/a/b/h/e;Ld/l/b/a/b/h/f;Ld/l/b/a/b/h/g;I)Z
    //   111: ifne -67 -> 44
    //   114: iconst_1
    //   115: istore 6
    //   117: goto -73 -> 44
    //   120: iload_3
    //   121: istore 7
    //   123: iload_3
    //   124: istore 5
    //   126: iload_3
    //   127: istore 8
    //   129: aload_1
    //   130: invokevirtual 95	d/l/b/a/b/h/e:fHv	()Ld/l/b/a/b/h/d;
    //   133: astore 11
    //   135: iload_3
    //   136: istore 4
    //   138: iload_3
    //   139: iconst_1
    //   140: iand
    //   141: iconst_1
    //   142: if_icmpeq +28 -> 170
    //   145: iload_3
    //   146: istore 7
    //   148: iload_3
    //   149: istore 5
    //   151: iload_3
    //   152: istore 8
    //   154: aload_0
    //   155: new 46	d/l/b/a/b/h/n
    //   158: dup
    //   159: invokespecial 96	d/l/b/a/b/h/n:<init>	()V
    //   162: putfield 51	d/l/b/a/b/e/a$o:JIk	Ld/l/b/a/b/h/o;
    //   165: iload_3
    //   166: iconst_1
    //   167: ior
    //   168: istore 4
    //   170: iload 4
    //   172: istore 7
    //   174: iload 4
    //   176: istore 5
    //   178: iload 4
    //   180: istore 8
    //   182: aload_0
    //   183: getfield 51	d/l/b/a/b/e/a$o:JIk	Ld/l/b/a/b/h/o;
    //   186: aload 11
    //   188: invokeinterface 101 2 0
    //   193: iload 4
    //   195: istore_3
    //   196: goto -152 -> 44
    //   199: astore_1
    //   200: iload 7
    //   202: istore 5
    //   204: aload_1
    //   205: aload_0
    //   206: putfield 105	d/l/b/a/b/h/k:JNa	Ld/l/b/a/b/h/q;
    //   209: iload 7
    //   211: istore 5
    //   213: ldc 72
    //   215: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: iload 7
    //   220: istore 5
    //   222: aload_1
    //   223: athrow
    //   224: astore_1
    //   225: iload 5
    //   227: iconst_1
    //   228: iand
    //   229: iconst_1
    //   230: if_icmpne +16 -> 246
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 51	d/l/b/a/b/e/a$o:JIk	Ld/l/b/a/b/h/o;
    //   238: invokeinterface 109 1 0
    //   243: putfield 51	d/l/b/a/b/e/a$o:JIk	Ld/l/b/a/b/h/o;
    //   246: aload 10
    //   248: invokevirtual 112	d/l/b/a/b/h/f:flush	()V
    //   251: aload_0
    //   252: aload 9
    //   254: invokevirtual 117	d/l/b/a/b/h/d$b:fHt	()Ld/l/b/a/b/h/d;
    //   257: putfield 66	d/l/b/a/b/e/a$o:JFI	Ld/l/b/a/b/h/d;
    //   260: aload_0
    //   261: invokevirtual 120	d/l/b/a/b/e/a$o:fHL	()V
    //   264: ldc 72
    //   266: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload_1
    //   270: athrow
    //   271: iload_3
    //   272: iconst_1
    //   273: iand
    //   274: iconst_1
    //   275: if_icmpne +16 -> 291
    //   278: aload_0
    //   279: aload_0
    //   280: getfield 51	d/l/b/a/b/e/a$o:JIk	Ld/l/b/a/b/h/o;
    //   283: invokeinterface 109 1 0
    //   288: putfield 51	d/l/b/a/b/e/a$o:JIk	Ld/l/b/a/b/h/o;
    //   291: aload 10
    //   293: invokevirtual 112	d/l/b/a/b/h/f:flush	()V
    //   296: aload_0
    //   297: aload 9
    //   299: invokevirtual 117	d/l/b/a/b/h/d$b:fHt	()Ld/l/b/a/b/h/d;
    //   302: putfield 66	d/l/b/a/b/e/a$o:JFI	Ld/l/b/a/b/h/d;
    //   305: aload_0
    //   306: invokevirtual 120	d/l/b/a/b/e/a$o:fHL	()V
    //   309: ldc 72
    //   311: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: return
    //   315: astore_1
    //   316: aload_0
    //   317: aload 9
    //   319: invokevirtual 117	d/l/b/a/b/h/d$b:fHt	()Ld/l/b/a/b/h/d;
    //   322: putfield 66	d/l/b/a/b/e/a$o:JFI	Ld/l/b/a/b/h/d;
    //   325: goto -20 -> 305
    //   328: astore_1
    //   329: aload_0
    //   330: aload 9
    //   332: invokevirtual 117	d/l/b/a/b/h/d$b:fHt	()Ld/l/b/a/b/h/d;
    //   335: putfield 66	d/l/b/a/b/e/a$o:JFI	Ld/l/b/a/b/h/d;
    //   338: ldc 72
    //   340: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: aload_1
    //   344: athrow
    //   345: astore_1
    //   346: iload 8
    //   348: istore 5
    //   350: new 69	d/l/b/a/b/h/k
    //   353: dup
    //   354: aload_1
    //   355: invokevirtual 124	java/io/IOException:getMessage	()Ljava/lang/String;
    //   358: invokespecial 127	d/l/b/a/b/h/k:<init>	(Ljava/lang/String;)V
    //   361: astore_1
    //   362: iload 8
    //   364: istore 5
    //   366: aload_1
    //   367: aload_0
    //   368: putfield 105	d/l/b/a/b/h/k:JNa	Ld/l/b/a/b/h/q;
    //   371: iload 8
    //   373: istore 5
    //   375: ldc 72
    //   377: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   380: iload 8
    //   382: istore 5
    //   384: aload_1
    //   385: athrow
    //   386: astore_2
    //   387: aload_0
    //   388: aload 9
    //   390: invokevirtual 117	d/l/b/a/b/h/d$b:fHt	()Ld/l/b/a/b/h/d;
    //   393: putfield 66	d/l/b/a/b/e/a$o:JFI	Ld/l/b/a/b/h/d;
    //   396: goto -136 -> 260
    //   399: astore_1
    //   400: aload_0
    //   401: aload 9
    //   403: invokevirtual 117	d/l/b/a/b/h/d$b:fHt	()Ld/l/b/a/b/h/d;
    //   406: putfield 66	d/l/b/a/b/e/a$o:JFI	Ld/l/b/a/b/h/d;
    //   409: ldc 72
    //   411: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: aload_1
    //   415: athrow
    //   416: goto -324 -> 92
    //   419: iconst_1
    //   420: istore 6
    //   422: goto -378 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	this	o
    //   0	425	1	parame	d.l.b.a.b.h.e
    //   0	425	2	paramg	d.l.b.a.b.h.g
    //   43	231	3	i	int
    //   62	132	4	j	int
    //   53	330	5	k	int
    //   40	381	6	m	int
    //   50	169	7	n	int
    //   56	325	8	i1	int
    //   29	373	9	localb	d.l.b.a.b.h.d.b
    //   37	255	10	localf	f
    //   133	54	11	locald	d
    // Exception table:
    //   from	to	target	type
    //   58	64	199	d/l/b/a/b/h/k
    //   101	114	199	d/l/b/a/b/h/k
    //   129	135	199	d/l/b/a/b/h/k
    //   154	165	199	d/l/b/a/b/h/k
    //   182	193	199	d/l/b/a/b/h/k
    //   58	64	224	finally
    //   101	114	224	finally
    //   129	135	224	finally
    //   154	165	224	finally
    //   182	193	224	finally
    //   204	209	224	finally
    //   213	218	224	finally
    //   222	224	224	finally
    //   350	362	224	finally
    //   366	371	224	finally
    //   375	380	224	finally
    //   384	386	224	finally
    //   291	296	315	java/io/IOException
    //   291	296	328	finally
    //   58	64	345	java/io/IOException
    //   101	114	345	java/io/IOException
    //   129	135	345	java/io/IOException
    //   154	165	345	java/io/IOException
    //   182	193	345	java/io/IOException
    //   246	251	386	java/io/IOException
    //   246	251	399	finally
  }
  
  private a$o(i.a parama)
  {
    super((byte)0);
    this.JFI = parama.JFI;
  }
  
  public static a b(o paramo)
  {
    AppMethodBeat.i(58797);
    paramo = a.fEP().e(paramo);
    AppMethodBeat.o(58797);
    return paramo;
  }
  
  public static o fEL()
  {
    return JIj;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(58795);
    yf();
    int i = 0;
    while (i < this.JIk.size())
    {
      paramf.a(1, this.JIk.afJ(i));
      i += 1;
    }
    paramf.e(this.JFI);
    AppMethodBeat.o(58795);
  }
  
  public final s<o> fCl()
  {
    return JFJ;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(58794);
    String str = (String)this.JIk.get(paramInt);
    AppMethodBeat.o(58794);
    return str;
  }
  
  public final boolean isInitialized()
  {
    int i = this.JFN;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.JFN = 1;
    return true;
  }
  
  public final int yf()
  {
    AppMethodBeat.i(58796);
    int i = this.JFO;
    if (i != -1)
    {
      AppMethodBeat.o(58796);
      return i;
    }
    int j = 0;
    int k;
    for (i = 0; j < this.JIk.size(); i = k + i)
    {
      k = f.d(this.JIk.afJ(j));
      j += 1;
    }
    i = i + 0 + this.JIk.size() * 1 + this.JFI.size();
    this.JFO = i;
    AppMethodBeat.o(58796);
    return i;
  }
  
  public static final class a
    extends i.a<a.o, a>
    implements q
  {
    private int JFK;
    private o JIk = n.JNg;
    
    private a fEM()
    {
      AppMethodBeat.i(58778);
      a locala = new a().e(fEN());
      AppMethodBeat.o(58778);
      return locala;
    }
    
    private void fEO()
    {
      AppMethodBeat.i(58782);
      if ((this.JFK & 0x1) != 1)
      {
        this.JIk = new n(this.JIk);
        this.JFK |= 0x1;
      }
      AppMethodBeat.o(58782);
    }
    
    /* Error */
    private a s(d.l.b.a.b.h.e parame, d.l.b.a.b.h.g paramg)
    {
      // Byte code:
      //   0: ldc 63
      //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 67	d/l/b/a/b/e/a$o:JFJ	Ld/l/b/a/b/h/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 72 3 0
      //   17: checkcast 9	d/l/b/a/b/e/a$o
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 47	d/l/b/a/b/e/a$o$a:e	(Ld/l/b/a/b/e/a$o;)Ld/l/b/a/b/e/a$o$a;
      //   26: pop
      //   27: ldc 63
      //   29: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 76	d/l/b/a/b/h/k:JNa	Ld/l/b/a/b/h/q;
      //   39: checkcast 9	d/l/b/a/b/e/a$o
      //   42: astore_2
      //   43: ldc 63
      //   45: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 47	d/l/b/a/b/e/a$o$a:e	(Ld/l/b/a/b/e/a$o;)Ld/l/b/a/b/e/a$o$a;
      //   60: pop
      //   61: ldc 63
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
    
    public final a e(a.o paramo)
    {
      AppMethodBeat.i(58780);
      if (paramo == a.o.fEL())
      {
        AppMethodBeat.o(58780);
        return this;
      }
      if (!a.o.c(paramo).isEmpty())
      {
        if (!this.JIk.isEmpty()) {
          break label84;
        }
        this.JIk = a.o.c(paramo);
        this.JFK &= 0xFFFFFFFE;
      }
      for (;;)
      {
        this.JFI = this.JFI.a(a.o.d(paramo));
        AppMethodBeat.o(58780);
        return this;
        label84:
        fEO();
        this.JIk.addAll(a.o.c(paramo));
      }
    }
    
    public final a.o fEN()
    {
      AppMethodBeat.i(58779);
      a.o localo = new a.o(this, (byte)0);
      if ((this.JFK & 0x1) == 1)
      {
        this.JIk = this.JIk.fHX();
        this.JFK &= 0xFFFFFFFE;
      }
      a.o.a(localo, this.JIk);
      AppMethodBeat.o(58779);
      return localo;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.a.o
 * JD-Core Version:    0.7.0.1
 */