package rx.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.e;
import rx.internal.a.c;

public final class b<T>
  implements e<T>
{
  private final c<T> McA;
  private boolean Mcy;
  private final e<? super T> MfL;
  private b.a MfM;
  private volatile boolean terminated;
  
  public b(e<? super T> parame)
  {
    AppMethodBeat.i(90428);
    this.McA = c.ggs();
    this.MfL = parame;
    AppMethodBeat.o(90428);
  }
  
  /* Error */
  public final void gd(T paramT)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 55	rx/c/b:terminated	Z
    //   9: ifeq +9 -> 18
    //   12: ldc 53
    //   14: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: return
    //   18: aload_0
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 55	rx/c/b:terminated	Z
    //   24: ifeq +11 -> 35
    //   27: aload_0
    //   28: monitorexit
    //   29: ldc 53
    //   31: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: return
    //   35: aload_0
    //   36: getfield 57	rx/c/b:Mcy	Z
    //   39: ifeq +50 -> 89
    //   42: aload_0
    //   43: getfield 59	rx/c/b:MfM	Lrx/c/b$a;
    //   46: astore 5
    //   48: aload 5
    //   50: astore 4
    //   52: aload 5
    //   54: ifnonnull +18 -> 72
    //   57: new 9	rx/c/b$a
    //   60: dup
    //   61: invokespecial 60	rx/c/b$a:<init>	()V
    //   64: astore 4
    //   66: aload_0
    //   67: aload 4
    //   69: putfield 59	rx/c/b:MfM	Lrx/c/b$a;
    //   72: aload 4
    //   74: aload_1
    //   75: invokestatic 64	rx/internal/a/c:gf	(Ljava/lang/Object;)Ljava/lang/Object;
    //   78: invokevirtual 67	rx/c/b$a:add	(Ljava/lang/Object;)V
    //   81: aload_0
    //   82: monitorexit
    //   83: ldc 53
    //   85: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: return
    //   89: aload_0
    //   90: iconst_1
    //   91: putfield 57	rx/c/b:Mcy	Z
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_0
    //   97: getfield 42	rx/c/b:MfL	Lrx/e;
    //   100: aload_1
    //   101: invokeinterface 69 2 0
    //   106: aload_0
    //   107: monitorenter
    //   108: aload_0
    //   109: getfield 59	rx/c/b:MfM	Lrx/c/b$a;
    //   112: astore 4
    //   114: aload 4
    //   116: ifnonnull +49 -> 165
    //   119: aload_0
    //   120: iconst_0
    //   121: putfield 57	rx/c/b:Mcy	Z
    //   124: aload_0
    //   125: monitorexit
    //   126: ldc 53
    //   128: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: return
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: ldc 53
    //   137: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_1
    //   141: athrow
    //   142: astore 4
    //   144: aload_0
    //   145: iconst_1
    //   146: putfield 55	rx/c/b:terminated	Z
    //   149: aload 4
    //   151: aload_0
    //   152: getfield 42	rx/c/b:MfL	Lrx/e;
    //   155: aload_1
    //   156: invokestatic 75	rx/a/b:a	(Ljava/lang/Throwable;Lrx/e;Ljava/lang/Object;)V
    //   159: ldc 53
    //   161: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: return
    //   165: aload_0
    //   166: aconst_null
    //   167: putfield 59	rx/c/b:MfM	Lrx/c/b$a;
    //   170: aload_0
    //   171: monitorexit
    //   172: aload 4
    //   174: getfield 79	rx/c/b$a:KUx	[Ljava/lang/Object;
    //   177: astore 4
    //   179: aload 4
    //   181: arraylength
    //   182: istore_3
    //   183: iconst_0
    //   184: istore_2
    //   185: iload_2
    //   186: iload_3
    //   187: if_icmpge -81 -> 106
    //   190: aload 4
    //   192: iload_2
    //   193: aaload
    //   194: astore 5
    //   196: aload 5
    //   198: ifnull -92 -> 106
    //   201: aload_0
    //   202: getfield 42	rx/c/b:MfL	Lrx/e;
    //   205: aload 5
    //   207: invokestatic 82	rx/internal/a/c:a	(Lrx/e;Ljava/lang/Object;)Z
    //   210: ifeq +57 -> 267
    //   213: aload_0
    //   214: iconst_1
    //   215: putfield 55	rx/c/b:terminated	Z
    //   218: ldc 53
    //   220: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: return
    //   224: astore_1
    //   225: aload_0
    //   226: monitorexit
    //   227: ldc 53
    //   229: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aload_1
    //   233: athrow
    //   234: astore 4
    //   236: aload_0
    //   237: iconst_1
    //   238: putfield 55	rx/c/b:terminated	Z
    //   241: aload 4
    //   243: invokestatic 86	rx/a/b:J	(Ljava/lang/Throwable;)V
    //   246: aload_0
    //   247: getfield 42	rx/c/b:MfL	Lrx/e;
    //   250: aload 4
    //   252: aload_1
    //   253: invokestatic 91	rx/a/g:a	(Ljava/lang/Throwable;Ljava/lang/Object;)Ljava/lang/Throwable;
    //   256: invokeinterface 94 2 0
    //   261: ldc 53
    //   263: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: return
    //   267: iload_2
    //   268: iconst_1
    //   269: iadd
    //   270: istore_2
    //   271: goto -86 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	b
    //   0	274	1	paramT	T
    //   184	87	2	i	int
    //   182	6	3	j	int
    //   50	65	4	locala1	b.a
    //   142	31	4	localThrowable1	Throwable
    //   177	14	4	arrayOfObject	Object[]
    //   234	17	4	localThrowable2	Throwable
    //   46	160	5	locala2	b.a
    // Exception table:
    //   from	to	target	type
    //   20	29	132	finally
    //   35	48	132	finally
    //   57	72	132	finally
    //   72	83	132	finally
    //   89	96	132	finally
    //   133	135	132	finally
    //   96	106	142	java/lang/Throwable
    //   108	114	224	finally
    //   119	126	224	finally
    //   165	172	224	finally
    //   225	227	224	finally
    //   201	218	234	java/lang/Throwable
  }
  
  public final void ggi()
  {
    AppMethodBeat.i(90431);
    if (this.terminated)
    {
      AppMethodBeat.o(90431);
      return;
    }
    try
    {
      if (this.terminated) {
        return;
      }
      this.terminated = true;
      if (this.Mcy)
      {
        b.a locala2 = this.MfM;
        b.a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new b.a();
          this.MfM = locala1;
        }
        locala1.add(c.ggt());
        return;
      }
      this.Mcy = true;
      this.MfL.ggi();
      AppMethodBeat.o(90431);
      return;
    }
    finally
    {
      AppMethodBeat.o(90431);
    }
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90430);
    rx.a.b.J(paramThrowable);
    if (this.terminated)
    {
      AppMethodBeat.o(90430);
      return;
    }
    try
    {
      if (this.terminated) {
        return;
      }
      this.terminated = true;
      if (this.Mcy)
      {
        b.a locala2 = this.MfM;
        b.a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new b.a();
          this.MfM = locala1;
        }
        locala1.add(c.L(paramThrowable));
        return;
      }
      this.Mcy = true;
      this.MfL.onError(paramThrowable);
      AppMethodBeat.o(90430);
      return;
    }
    finally
    {
      AppMethodBeat.o(90430);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.c.b
 * JD-Core Version:    0.7.0.1
 */