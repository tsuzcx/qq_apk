package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "parent", "child", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class r
  extends ca<by>
{
  public final n<?> abwl;
  
  public r(by paramby, n<?> paramn)
  {
    super(paramby);
    this.abwl = paramn;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118228);
    String str = "ChildContinuation[" + this.abwl + ']';
    AppMethodBeat.o(118228);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(118226);
    n localn = this.abwl;
    Throwable localThrowable = this.abwl.a(this.Gib);
    int i;
    if (localn.abwT != 0) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        localn.A(localThrowable);
        localn.iQR();
      }
      AppMethodBeat.o(118226);
      return;
      Object localObject = localn.aaAx;
      paramThrowable = (Throwable)localObject;
      if (!(localObject instanceof ax)) {
        paramThrowable = null;
      }
      paramThrowable = (ax)paramThrowable;
      if (paramThrowable == null)
      {
        i = 0;
      }
      else
      {
        do
        {
          do
          {
            localObject = paramThrowable._reusableCancellableContinuation;
            if (!p.h(localObject, ay.abwS)) {
              break;
            }
          } while (!ax.abwO.compareAndSet(paramThrowable, ay.abwS, localThrowable));
          i = 1;
          break;
          if ((localObject instanceof Throwable))
          {
            i = 1;
            break;
          }
        } while (!ax.abwO.compareAndSet(paramThrowable, localObject, null));
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.r
 * JD-Core Version:    0.7.0.1
 */