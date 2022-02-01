package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class m
{
  private d JNc;
  private g JNd;
  private volatile boolean JNe;
  protected volatile q JNf;
  
  /* Error */
  public final q d(q paramq)
  {
    // Byte code:
    //   0: ldc 17
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 25	d/l/b/a/b/h/m:JNf	Ld/l/b/a/b/h/q;
    //   9: ifnonnull +14 -> 23
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 25	d/l/b/a/b/h/m:JNf	Ld/l/b/a/b/h/q;
    //   18: ifnull +17 -> 35
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_0
    //   24: getfield 25	d/l/b/a/b/h/m:JNf	Ld/l/b/a/b/h/q;
    //   27: astore_1
    //   28: ldc 17
    //   30: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_1
    //   34: areturn
    //   35: aload_0
    //   36: getfield 30	d/l/b/a/b/h/m:JNc	Ld/l/b/a/b/h/d;
    //   39: ifnull +44 -> 83
    //   42: aload_0
    //   43: aload_1
    //   44: invokeinterface 36 1 0
    //   49: aload_0
    //   50: getfield 30	d/l/b/a/b/h/m:JNc	Ld/l/b/a/b/h/d;
    //   53: aload_0
    //   54: getfield 38	d/l/b/a/b/h/m:JNd	Ld/l/b/a/b/h/g;
    //   57: invokeinterface 44 3 0
    //   62: checkcast 32	d/l/b/a/b/h/q
    //   65: putfield 25	d/l/b/a/b/h/m:JNf	Ld/l/b/a/b/h/q;
    //   68: aload_0
    //   69: monitorexit
    //   70: goto -47 -> 23
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: ldc 17
    //   78: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_1
    //   82: athrow
    //   83: aload_0
    //   84: aload_1
    //   85: putfield 25	d/l/b/a/b/h/m:JNf	Ld/l/b/a/b/h/q;
    //   88: goto -20 -> 68
    //   91: astore_1
    //   92: goto -24 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	m
    //   0	95	1	paramq	q
    // Exception table:
    //   from	to	target	type
    //   14	23	73	finally
    //   35	68	73	finally
    //   68	70	73	finally
    //   74	76	73	finally
    //   83	88	73	finally
    //   35	68	91	java/io/IOException
    //   83	88	91	java/io/IOException
  }
  
  public final q e(q paramq)
  {
    q localq = this.JNf;
    this.JNf = paramq;
    this.JNc = null;
    this.JNe = true;
    return localq;
  }
  
  public final int yf()
  {
    AppMethodBeat.i(59500);
    if (this.JNe)
    {
      i = this.JNf.yf();
      AppMethodBeat.o(59500);
      return i;
    }
    int i = this.JNc.size();
    AppMethodBeat.o(59500);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.m
 * JD-Core Version:    0.7.0.1
 */