package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.b.a;
import rx.d.c;
import rx.f.b;
import rx.j;

public final class i
  extends AtomicReference<Thread>
  implements Runnable, j
{
  final rx.internal.util.i akcJ;
  final a akcK;
  
  public i(a parama)
  {
    AppMethodBeat.i(90341);
    this.akcK = parama;
    this.akcJ = new rx.internal.util.i();
    AppMethodBeat.o(90341);
  }
  
  public i(a parama, b paramb)
  {
    AppMethodBeat.i(90342);
    this.akcK = parama;
    this.akcJ = new rx.internal.util.i(new b(this, paramb));
    AppMethodBeat.o(90342);
  }
  
  public i(a parama, rx.internal.util.i parami)
  {
    AppMethodBeat.i(90343);
    this.akcK = parama;
    this.akcJ = new rx.internal.util.i(new c(this, parami));
    AppMethodBeat.o(90343);
  }
  
  private static void am(Throwable paramThrowable)
  {
    AppMethodBeat.i(90345);
    c.l(paramThrowable);
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
    AppMethodBeat.o(90345);
  }
  
  public final void d(Future<?> paramFuture)
  {
    AppMethodBeat.i(90347);
    this.akcJ.b(new a(paramFuture));
    AppMethodBeat.o(90347);
  }
  
  public final void kKh()
  {
    AppMethodBeat.i(90346);
    if (!this.akcJ.akdH) {
      this.akcJ.kKh();
    }
    AppMethodBeat.o(90346);
  }
  
  public final boolean kKi()
  {
    return this.akcJ.akdH;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 106
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 72	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9: invokevirtual 110	rx/internal/c/i:lazySet	(Ljava/lang/Object;)V
    //   12: aload_0
    //   13: getfield 36	rx/internal/c/i:akcK	Lrx/b/a;
    //   16: invokeinterface 115 1 0
    //   21: aload_0
    //   22: invokevirtual 116	rx/internal/c/i:kKh	()V
    //   25: ldc 106
    //   27: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: return
    //   31: astore_1
    //   32: new 118	java/lang/IllegalStateException
    //   35: dup
    //   36: ldc 120
    //   38: aload_1
    //   39: invokespecial 123	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   42: invokestatic 125	rx/internal/c/i:am	(Ljava/lang/Throwable;)V
    //   45: aload_0
    //   46: invokevirtual 116	rx/internal/c/i:kKh	()V
    //   49: ldc 106
    //   51: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: astore_1
    //   56: new 118	java/lang/IllegalStateException
    //   59: dup
    //   60: ldc 127
    //   62: aload_1
    //   63: invokespecial 123	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: invokestatic 125	rx/internal/c/i:am	(Ljava/lang/Throwable;)V
    //   69: aload_0
    //   70: invokevirtual 116	rx/internal/c/i:kKh	()V
    //   73: ldc 106
    //   75: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: astore_1
    //   80: aload_0
    //   81: invokevirtual 116	rx/internal/c/i:kKh	()V
    //   84: ldc 106
    //   86: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	i
    //   31	8	1	localf	rx.a.f
    //   55	8	1	localThrowable	Throwable
    //   79	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	21	31	rx/a/f
    //   5	21	55	finally
    //   32	45	79	finally
    //   56	69	79	finally
  }
  
  final class a
    implements j
  {
    private final Future<?> akcL;
    
    a()
    {
      Object localObject;
      this.akcL = localObject;
    }
    
    public final void kKh()
    {
      AppMethodBeat.i(90337);
      if (i.this.get() != Thread.currentThread())
      {
        this.akcL.cancel(true);
        AppMethodBeat.o(90337);
        return;
      }
      this.akcL.cancel(false);
      AppMethodBeat.o(90337);
    }
    
    public final boolean kKi()
    {
      AppMethodBeat.i(90338);
      boolean bool = this.akcL.isCancelled();
      AppMethodBeat.o(90338);
      return bool;
    }
  }
  
  static final class b
    extends AtomicBoolean
    implements j
  {
    final i akcN;
    final b akcO;
    
    public b(i parami, b paramb)
    {
      this.akcN = parami;
      this.akcO = paramb;
    }
    
    public final void kKh()
    {
      AppMethodBeat.i(90339);
      if (compareAndSet(false, true)) {
        this.akcO.e(this.akcN);
      }
      AppMethodBeat.o(90339);
    }
    
    public final boolean kKi()
    {
      return this.akcN.akcJ.akdH;
    }
  }
  
  static final class c
    extends AtomicBoolean
    implements j
  {
    final i akcN;
    final rx.internal.util.i akcP;
    
    public c(i parami, rx.internal.util.i parami1)
    {
      this.akcN = parami;
      this.akcP = parami1;
    }
    
    public final void kKh()
    {
      AppMethodBeat.i(90340);
      rx.internal.util.i locali;
      i locali1;
      if (compareAndSet(false, true))
      {
        locali = this.akcP;
        locali1 = this.akcN;
        if (locali.akdH) {}
      }
      try
      {
        List localList = locali.akdG;
        if ((locali.akdH) || (localList == null)) {
          return;
        }
        boolean bool = localList.remove(locali1);
        if (bool) {
          locali1.kKh();
        }
        AppMethodBeat.o(90340);
        return;
      }
      finally
      {
        AppMethodBeat.o(90340);
      }
    }
    
    public final boolean kKi()
    {
      return this.akcN.akcJ.akdH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.c.i
 * JD-Core Version:    0.7.0.1
 */