package d.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class e
  implements Lock
{
  public static final Lock NYn;
  
  static
  {
    AppMethodBeat.i(60555);
    NYn = new e();
    AppMethodBeat.o(60555);
  }
  
  public final void lock() {}
  
  public final void lockInterruptibly()
  {
    AppMethodBeat.i(60551);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Should not be called");
    AppMethodBeat.o(60551);
    throw localUnsupportedOperationException;
  }
  
  public final Condition newCondition()
  {
    AppMethodBeat.i(60554);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Should not be called");
    AppMethodBeat.o(60554);
    throw localUnsupportedOperationException;
  }
  
  public final boolean tryLock()
  {
    AppMethodBeat.i(60552);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Should not be called");
    AppMethodBeat.o(60552);
    throw localUnsupportedOperationException;
  }
  
  public final boolean tryLock(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(60553);
    if (paramTimeUnit == null)
    {
      paramTimeUnit = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[] { "unit", "kotlin/reflect/jvm/internal/impl/storage/NoLock", "tryLock" }));
      AppMethodBeat.o(60553);
      throw paramTimeUnit;
    }
    paramTimeUnit = new UnsupportedOperationException("Should not be called");
    AppMethodBeat.o(60553);
    throw paramTimeUnit;
  }
  
  public final void unlock() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.l.b.a.b.l.e
 * JD-Core Version:    0.7.0.1
 */