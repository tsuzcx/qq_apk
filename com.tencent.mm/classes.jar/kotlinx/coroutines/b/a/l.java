package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.au;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/ChildCancelledException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()V", "fillInStackTrace", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends CancellationException
{
  public l()
  {
    super("Child of the scoped flow was cancelled");
  }
  
  public final Throwable fillInStackTrace()
  {
    AppMethodBeat.i(189202);
    if (au.DEBUG)
    {
      localThrowable = super.fillInStackTrace();
      AppMethodBeat.o(189202);
      return localThrowable;
    }
    setStackTrace((StackTraceElement[])new StackTraceElement[0]);
    Throwable localThrowable = (Throwable)this;
    AppMethodBeat.o(189202);
    return localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.l
 * JD-Core Version:    0.7.0.1
 */