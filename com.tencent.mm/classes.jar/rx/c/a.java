package rx.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.a.b;
import rx.a.d;
import rx.a.h;
import rx.d.c;
import rx.i;

public final class a<T>
  extends i<T>
{
  private final i<? super T> akaV;
  boolean done;
  
  public a(i<? super T> parami)
  {
    super(parami);
    this.akaV = parami;
  }
  
  public final void fvq()
  {
    AppMethodBeat.i(90432);
    if (!this.done)
    {
      this.done = true;
      try
      {
        this.akaV.fvq();
        h localh1;
        try
        {
          kKh();
          AppMethodBeat.o(90432);
          return;
        }
        finally
        {
          c.l(localThrowable1);
          localh1 = new h(localThrowable1.getMessage(), localThrowable1);
          AppMethodBeat.o(90432);
        }
        d locald;
        h localh2;
        AppMethodBeat.o(90432);
      }
      finally {}
    }
  }
  
  public final void jV(T paramT)
  {
    AppMethodBeat.i(90434);
    try
    {
      if (!this.done) {
        this.akaV.jV(paramT);
      }
      AppMethodBeat.o(90434);
      return;
    }
    finally
    {
      b.a(paramT, this);
      AppMethodBeat.o(90434);
    }
  }
  
  /* Error */
  public final void l(Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc 76
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 60	rx/a/b:ai	(Ljava/lang/Throwable;)V
    //   9: aload_0
    //   10: getfield 30	rx/c/a:done	Z
    //   13: ifne +206 -> 219
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 30	rx/c/a:done	Z
    //   21: aload_1
    //   22: invokestatic 44	rx/d/c:l	(Ljava/lang/Throwable;)V
    //   25: aload_0
    //   26: getfield 16	rx/c/a:akaV	Lrx/i;
    //   29: aload_1
    //   30: invokevirtual 77	rx/i:l	(Ljava/lang/Throwable;)V
    //   33: aload_0
    //   34: invokevirtual 35	rx/c/a:kKh	()V
    //   37: ldc 76
    //   39: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: return
    //   43: astore_2
    //   44: aload_0
    //   45: invokevirtual 35	rx/c/a:kKh	()V
    //   48: ldc 76
    //   50: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_2
    //   54: athrow
    //   55: astore_2
    //   56: aload_2
    //   57: invokestatic 44	rx/d/c:l	(Ljava/lang/Throwable;)V
    //   60: new 75	rx/a/f
    //   63: dup
    //   64: ldc 79
    //   66: new 81	rx/a/a
    //   69: dup
    //   70: iconst_2
    //   71: anewarray 48	java/lang/Throwable
    //   74: dup
    //   75: iconst_0
    //   76: aload_1
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: aload_2
    //   81: aastore
    //   82: invokestatic 87	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   85: iconst_0
    //   86: invokespecial 90	rx/a/a:<init>	(Ljava/util/Collection;B)V
    //   89: invokespecial 91	rx/a/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   92: astore_1
    //   93: ldc 76
    //   95: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_1
    //   99: athrow
    //   100: astore_2
    //   101: aload_2
    //   102: invokestatic 44	rx/d/c:l	(Ljava/lang/Throwable;)V
    //   105: aload_0
    //   106: invokevirtual 35	rx/c/a:kKh	()V
    //   109: new 93	rx/a/e
    //   112: dup
    //   113: ldc 95
    //   115: new 81	rx/a/a
    //   118: dup
    //   119: iconst_2
    //   120: anewarray 48	java/lang/Throwable
    //   123: dup
    //   124: iconst_0
    //   125: aload_1
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: aload_2
    //   130: aastore
    //   131: invokestatic 87	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   134: iconst_0
    //   135: invokespecial 90	rx/a/a:<init>	(Ljava/util/Collection;B)V
    //   138: invokespecial 96	rx/a/e:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   141: astore_1
    //   142: ldc 76
    //   144: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_1
    //   148: athrow
    //   149: astore_3
    //   150: aload_3
    //   151: invokestatic 44	rx/d/c:l	(Ljava/lang/Throwable;)V
    //   154: new 93	rx/a/e
    //   157: dup
    //   158: ldc 98
    //   160: new 81	rx/a/a
    //   163: dup
    //   164: iconst_3
    //   165: anewarray 48	java/lang/Throwable
    //   168: dup
    //   169: iconst_0
    //   170: aload_1
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: aload_2
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload_3
    //   179: aastore
    //   180: invokestatic 87	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   183: iconst_0
    //   184: invokespecial 90	rx/a/a:<init>	(Ljava/util/Collection;B)V
    //   187: invokespecial 96	rx/a/e:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   190: astore_1
    //   191: ldc 76
    //   193: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: aload_1
    //   200: invokestatic 44	rx/d/c:l	(Ljava/lang/Throwable;)V
    //   203: new 93	rx/a/e
    //   206: dup
    //   207: aload_1
    //   208: invokespecial 100	rx/a/e:<init>	(Ljava/lang/Throwable;)V
    //   211: astore_1
    //   212: ldc 76
    //   214: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_1
    //   218: athrow
    //   219: ldc 76
    //   221: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	a
    //   0	225	1	paramThrowable	Throwable
    //   43	11	2	localf	rx.a.f
    //   55	26	2	localThrowable1	Throwable
    //   100	75	2	localThrowable2	Throwable
    //   149	30	3	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   25	33	43	rx/a/f
    //   44	48	55	finally
    //   25	33	100	finally
    //   105	109	149	finally
    //   33	37	198	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.c.a
 * JD-Core Version:    0.7.0.1
 */