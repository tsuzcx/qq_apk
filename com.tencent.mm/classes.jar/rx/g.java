package rx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import rx.b.a;
import rx.b.e;
import rx.f.c;
import rx.internal.c.k;

public abstract class g
{
  static final long NXe = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15L).longValue());
  
  public abstract a createWorker();
  
  public long now()
  {
    return System.currentTimeMillis();
  }
  
  public <S extends g,  extends j> S when(e<d<d<b>>, b> parame)
  {
    return new k(parame, this);
  }
  
  public static abstract class a
    implements j
  {
    public abstract j a(a parama);
    
    public abstract j a(a parama, long paramLong, TimeUnit paramTimeUnit);
    
    public long now()
    {
      return System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.g
 * JD-Core Version:    0.7.0.1
 */