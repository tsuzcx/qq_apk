package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.f.d;
import rx.g;
import rx.g.a;
import rx.j;

public final class m
  extends g
{
  public static final m UmP;
  
  static
  {
    AppMethodBeat.i(90410);
    UmP = new m();
    AppMethodBeat.o(90410);
  }
  
  static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90409);
    a locala = new a();
    AppMethodBeat.o(90409);
    return locala;
  }
  
  static final class a
    extends g.a
    implements j
  {
    private final AtomicInteger UlZ;
    final PriorityBlockingQueue<m.b> UmQ;
    private final rx.f.a Uml;
    final AtomicInteger counter;
    
    a()
    {
      AppMethodBeat.i(90402);
      this.counter = new AtomicInteger();
      this.UmQ = new PriorityBlockingQueue();
      this.Uml = new rx.f.a();
      this.UlZ = new AtomicInteger();
      AppMethodBeat.o(90402);
    }
    
    private j a(final rx.b.a parama, long paramLong)
    {
      AppMethodBeat.i(90405);
      if (this.Uml.hQB())
      {
        parama = d.hRn();
        AppMethodBeat.o(90405);
        return parama;
      }
      parama = new m.b(parama, Long.valueOf(paramLong), this.counter.incrementAndGet());
      this.UmQ.add(parama);
      if (this.UlZ.getAndIncrement() == 0)
      {
        do
        {
          parama = (m.b)this.UmQ.poll();
          if (parama != null) {
            parama.Umw.call();
          }
        } while (this.UlZ.decrementAndGet() > 0);
        parama = d.hRn();
        AppMethodBeat.o(90405);
        return parama;
      }
      parama = d.e(new rx.b.a()
      {
        public final void call()
        {
          AppMethodBeat.i(90401);
          m.a.this.UmQ.remove(parama);
          AppMethodBeat.o(90401);
        }
      });
      AppMethodBeat.o(90405);
      return parama;
    }
    
    public final j a(rx.b.a parama)
    {
      AppMethodBeat.i(90403);
      parama = a(parama, now());
      AppMethodBeat.o(90403);
      return parama;
    }
    
    public final j a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90404);
      paramLong = now() + paramTimeUnit.toMillis(paramLong);
      parama = a(new l(parama, this, paramLong), paramLong);
      AppMethodBeat.o(90404);
      return parama;
    }
    
    public final void hQA()
    {
      AppMethodBeat.i(90406);
      this.Uml.hQA();
      AppMethodBeat.o(90406);
    }
    
    public final boolean hQB()
    {
      AppMethodBeat.i(90407);
      boolean bool = this.Uml.hQB();
      AppMethodBeat.o(90407);
      return bool;
    }
  }
  
  static final class b
    implements Comparable<b>
  {
    final Long UmT;
    final rx.b.a Umw;
    final int count;
    
    b(rx.b.a parama, Long paramLong, int paramInt)
    {
      this.Umw = parama;
      this.UmT = paramLong;
      this.count = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.c.m
 * JD-Core Version:    0.7.0.1
 */