package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a.d;
import rx.d.b;
import rx.i;
import rx.internal.util.b;
import rx.internal.util.b.a;

public final class k<T>
  implements d.b<T, T>
{
  private final Long akbt = null;
  private final rx.b.a akbu = null;
  private final a.d akbv = rx.a.ajZT;
  
  private i<? super T> b(i<? super T> parami)
  {
    AppMethodBeat.i(90289);
    a locala = new a(parami, this.akbt, this.akbu, this.akbv);
    parami.b(locala);
    parami.a(locala.akby);
    AppMethodBeat.o(90289);
    return locala;
  }
  
  public static <T> k<T> kKp()
  {
    return b.akbz;
  }
  
  static final class a<T>
    extends i<T>
    implements b.a
  {
    private final ConcurrentLinkedQueue<Object> Gap;
    private final i<? super T> akbm;
    private final c<T> akbo;
    private final rx.b.a akbu;
    private final a.d akbv;
    private final AtomicLong akbw;
    private final AtomicBoolean akbx;
    final b akby;
    
    public a(i<? super T> parami, Long paramLong, rx.b.a parama, a.d paramd)
    {
      AppMethodBeat.i(90279);
      this.Gap = new ConcurrentLinkedQueue();
      this.akbx = new AtomicBoolean(false);
      this.akbo = c.kKn();
      this.akbm = parami;
      if (paramLong != null) {}
      for (parami = new AtomicLong(paramLong.longValue());; parami = null)
      {
        this.akbw = parami;
        this.akbu = parama;
        this.akby = new b(this);
        this.akbv = paramd;
        AppMethodBeat.o(90279);
        return;
      }
    }
    
    /* Error */
    private boolean kKq()
    {
      // Byte code:
      //   0: ldc 98
      //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 76	rx/internal/a/k$a:akbw	Ljava/util/concurrent/atomic/AtomicLong;
      //   9: ifnonnull +10 -> 19
      //   12: ldc 98
      //   14: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   17: iconst_1
      //   18: ireturn
      //   19: aload_0
      //   20: getfield 76	rx/internal/a/k$a:akbw	Ljava/util/concurrent/atomic/AtomicLong;
      //   23: invokevirtual 101	java/util/concurrent/atomic/AtomicLong:get	()J
      //   26: lstore_2
      //   27: lload_2
      //   28: lconst_0
      //   29: lcmp
      //   30: ifgt +115 -> 145
      //   33: aload_0
      //   34: getfield 87	rx/internal/a/k$a:akbv	Lrx/a$d;
      //   37: invokeinterface 106 1 0
      //   42: ifeq +43 -> 85
      //   45: aload_0
      //   46: invokevirtual 110	rx/internal/a/k$a:poll	()Ljava/lang/Object;
      //   49: astore 4
      //   51: aload 4
      //   53: ifnull +32 -> 85
      //   56: iconst_1
      //   57: istore_1
      //   58: aload_0
      //   59: getfield 78	rx/internal/a/k$a:akbu	Lrx/b/a;
      //   62: ifnull +12 -> 74
      //   65: aload_0
      //   66: getfield 78	rx/internal/a/k$a:akbu	Lrx/b/a;
      //   69: invokeinterface 115 1 0
      //   74: iload_1
      //   75: ifne +70 -> 145
      //   78: ldc 98
      //   80: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   83: iconst_0
      //   84: ireturn
      //   85: iconst_0
      //   86: istore_1
      //   87: goto -29 -> 58
      //   90: astore 4
      //   92: aload_0
      //   93: getfield 53	rx/internal/a/k$a:akbx	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   96: iconst_0
      //   97: iconst_1
      //   98: invokevirtual 119	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
      //   101: ifeq +16 -> 117
      //   104: aload_0
      //   105: invokevirtual 122	rx/internal/a/k$a:kKh	()V
      //   108: aload_0
      //   109: getfield 63	rx/internal/a/k$a:akbm	Lrx/i;
      //   112: aload 4
      //   114: invokevirtual 126	rx/i:l	(Ljava/lang/Throwable;)V
      //   117: iconst_0
      //   118: istore_1
      //   119: goto -61 -> 58
      //   122: astore 4
      //   124: aload 4
      //   126: invokestatic 131	rx/a/b:ai	(Ljava/lang/Throwable;)V
      //   129: aload_0
      //   130: getfield 85	rx/internal/a/k$a:akby	Lrx/internal/util/b;
      //   133: aload 4
      //   135: invokevirtual 134	rx/internal/util/b:an	(Ljava/lang/Throwable;)V
      //   138: ldc 98
      //   140: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   143: iconst_0
      //   144: ireturn
      //   145: aload_0
      //   146: getfield 76	rx/internal/a/k$a:akbw	Ljava/util/concurrent/atomic/AtomicLong;
      //   149: lload_2
      //   150: lload_2
      //   151: lconst_1
      //   152: lsub
      //   153: invokevirtual 137	java/util/concurrent/atomic/AtomicLong:compareAndSet	(JJ)Z
      //   156: ifeq -137 -> 19
      //   159: ldc 98
      //   161: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   164: iconst_1
      //   165: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	166	0	this	a
      //   57	62	1	i	int
      //   26	125	2	l	long
      //   49	3	4	localObject	Object
      //   90	23	4	localc	rx.a.c
      //   122	12	4	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   33	51	90	rx/a/c
      //   65	74	122	finally
    }
    
    public final void al(Throwable paramThrowable)
    {
      AppMethodBeat.i(90285);
      if (paramThrowable != null)
      {
        this.akbm.l(paramThrowable);
        AppMethodBeat.o(90285);
        return;
      }
      this.akbm.fvq();
      AppMethodBeat.o(90285);
    }
    
    public final boolean be(Object paramObject)
    {
      AppMethodBeat.i(90284);
      boolean bool = c.a(this.akbm, paramObject);
      AppMethodBeat.o(90284);
      return bool;
    }
    
    public final void fvq()
    {
      AppMethodBeat.i(90281);
      if (!this.akbx.get())
      {
        b localb = this.akby;
        localb.terminated = true;
        localb.kKw();
      }
      AppMethodBeat.o(90281);
    }
    
    public final void jV(T paramT)
    {
      AppMethodBeat.i(90283);
      if (!kKq())
      {
        AppMethodBeat.o(90283);
        return;
      }
      this.Gap.offer(c.jY(paramT));
      this.akby.kKw();
      AppMethodBeat.o(90283);
    }
    
    public final void l(Throwable paramThrowable)
    {
      AppMethodBeat.i(90282);
      if (!this.akbx.get()) {
        this.akby.an(paramThrowable);
      }
      AppMethodBeat.o(90282);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(90280);
      Cp(9223372036854775807L);
      AppMethodBeat.o(90280);
    }
    
    public final Object peek()
    {
      AppMethodBeat.i(90286);
      Object localObject = this.Gap.peek();
      AppMethodBeat.o(90286);
      return localObject;
    }
    
    public final Object poll()
    {
      AppMethodBeat.i(90287);
      Object localObject = this.Gap.poll();
      if ((this.akbw != null) && (localObject != null)) {
        this.akbw.incrementAndGet();
      }
      AppMethodBeat.o(90287);
      return localObject;
    }
  }
  
  static final class b
  {
    static final k<?> akbz;
    
    static
    {
      AppMethodBeat.i(90278);
      akbz = new k();
      AppMethodBeat.o(90278);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.a.k
 * JD-Core Version:    0.7.0.1
 */