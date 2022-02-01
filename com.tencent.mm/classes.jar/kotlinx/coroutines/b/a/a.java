package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.au;
import kotlinx.coroutines.b.h;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/AbortFlowException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "owner", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;)V", "getOwner", "()Lkotlinx/coroutines/flow/FlowCollector;", "fillInStackTrace", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends CancellationException
{
  public final h<?> ajzf;
  
  public a(h<?> paramh)
  {
    super("Flow was aborted, no more elements needed");
    this.ajzf = paramh;
  }
  
  public final Throwable fillInStackTrace()
  {
    AppMethodBeat.i(189193);
    if (au.DEBUG)
    {
      localThrowable = super.fillInStackTrace();
      AppMethodBeat.o(189193);
      return localThrowable;
    }
    setStackTrace((StackTraceElement[])new StackTraceElement[0]);
    Throwable localThrowable = (Throwable)this;
    AppMethodBeat.o(189193);
    return localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.a
 * JD-Core Version:    0.7.0.1
 */