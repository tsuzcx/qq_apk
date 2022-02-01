package rx.schedulers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.f.d;
import rx.g;
import rx.g.a;
import rx.j;

public class TestScheduler
  extends g
{
  static long IuP;
  final Queue<c> cWm;
  long time;
  
  public TestScheduler()
  {
    AppMethodBeat.i(90112);
    this.cWm = new PriorityQueue(11, new a());
    AppMethodBeat.o(90112);
  }
  
  private void xW(long paramLong)
  {
    AppMethodBeat.i(90117);
    if (!this.cWm.isEmpty())
    {
      c localc = (c)this.cWm.peek();
      if (localc.time <= paramLong)
      {
        if (localc.time == 0L) {}
        for (long l = this.time;; l = localc.time)
        {
          this.time = l;
          this.cWm.remove();
          if (localc.KsQ.fNx()) {
            break;
          }
          localc.KqS.call();
          break;
        }
      }
    }
    this.time = paramLong;
    AppMethodBeat.o(90117);
  }
  
  public void advanceTimeBy(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(90114);
    advanceTimeTo(this.time + paramTimeUnit.toNanos(paramLong), TimeUnit.NANOSECONDS);
    AppMethodBeat.o(90114);
  }
  
  public void advanceTimeTo(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(90115);
    xW(paramTimeUnit.toNanos(paramLong));
    AppMethodBeat.o(90115);
  }
  
  public g.a createWorker()
  {
    AppMethodBeat.i(90118);
    b localb = new b();
    AppMethodBeat.o(90118);
    return localb;
  }
  
  public long now()
  {
    AppMethodBeat.i(90113);
    long l = TimeUnit.NANOSECONDS.toMillis(this.time);
    AppMethodBeat.o(90113);
    return l;
  }
  
  public void triggerActions()
  {
    AppMethodBeat.i(90116);
    xW(this.time);
    AppMethodBeat.o(90116);
  }
  
  static final class a
    implements Comparator<TestScheduler.c>
  {}
  
  final class b
    extends g.a
  {
    private final rx.f.a KsM;
    
    b()
    {
      AppMethodBeat.i(90106);
      this.KsM = new rx.f.a();
      AppMethodBeat.o(90106);
    }
    
    public final j a(final rx.b.a parama)
    {
      AppMethodBeat.i(90110);
      parama = new TestScheduler.c(this, 0L, parama);
      TestScheduler.this.cWm.add(parama);
      parama = d.e(new rx.b.a()
      {
        public final void call()
        {
          AppMethodBeat.i(90105);
          TestScheduler.this.cWm.remove(parama);
          AppMethodBeat.o(90105);
        }
      });
      AppMethodBeat.o(90110);
      return parama;
    }
    
    public final j a(final rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90109);
      parama = new TestScheduler.c(this, TestScheduler.this.time + paramTimeUnit.toNanos(paramLong), parama);
      TestScheduler.this.cWm.add(parama);
      parama = d.e(new rx.b.a()
      {
        public final void call()
        {
          AppMethodBeat.i(90104);
          TestScheduler.this.cWm.remove(parama);
          AppMethodBeat.o(90104);
        }
      });
      AppMethodBeat.o(90109);
      return parama;
    }
    
    public final void fNw()
    {
      AppMethodBeat.i(90107);
      this.KsM.fNw();
      AppMethodBeat.o(90107);
    }
    
    public final boolean fNx()
    {
      AppMethodBeat.i(90108);
      boolean bool = this.KsM.fNx();
      AppMethodBeat.o(90108);
      return bool;
    }
    
    public final long now()
    {
      AppMethodBeat.i(90111);
      long l = TestScheduler.this.now();
      AppMethodBeat.o(90111);
      return l;
    }
  }
  
  static final class c
  {
    final rx.b.a KqS;
    final g.a KsQ;
    final long count;
    final long time;
    
    c(g.a parama, long paramLong, rx.b.a parama1)
    {
      AppMethodBeat.i(90102);
      long l = TestScheduler.IuP;
      TestScheduler.IuP = 1L + l;
      this.count = l;
      this.time = paramLong;
      this.KqS = parama1;
      this.KsQ = parama;
      AppMethodBeat.o(90102);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(90103);
      String str = String.format("TimedAction(time = %d, action = %s)", new Object[] { Long.valueOf(this.time), this.KqS.toString() });
      AppMethodBeat.o(90103);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.schedulers.TestScheduler
 * JD-Core Version:    0.7.0.1
 */