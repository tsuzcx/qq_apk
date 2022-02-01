package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.internal.h;
import kotlinx.coroutines.internal.i;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobCancellingNode;", "child", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends cd
{
  public final q<?> ajvt;
  
  public u(q<?> paramq)
  {
    this.ajvt = paramq;
  }
  
  public final void N(Throwable paramThrowable)
  {
    AppMethodBeat.i(118226);
    paramThrowable = this.ajvt;
    Throwable localThrowable = this.ajvt.c((cb)kCx());
    int i;
    if (!paramThrowable.kBB()) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramThrowable.P(localThrowable);
        paramThrowable.kBH();
      }
      AppMethodBeat.o(118226);
      return;
      h localh = (h)paramThrowable.aiwg;
      Object localObject;
      do
      {
        do
        {
          localObject = localh._reusableCancellableContinuation;
          if (!s.p(localObject, i.ajAn)) {
            break;
          }
        } while (!h.ajAm.compareAndSet(localh, i.ajAn, localThrowable));
        i = 1;
        break;
        if ((localObject instanceof Throwable))
        {
          i = 1;
          break;
        }
      } while (!h.ajAm.compareAndSet(localh, localObject, null));
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.u
 * JD-Core Version:    0.7.0.1
 */