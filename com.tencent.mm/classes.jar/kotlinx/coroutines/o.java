package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "parent", "child", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class o
  extends bq<bo>
{
  public final k<?> LQL;
  
  public o(bo parambo, k<?> paramk)
  {
    super(parambo);
    this.LQL = paramk;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118228);
    String str = "ChildContinuation[" + this.LQL + ']';
    AppMethodBeat.o(118228);
    return str;
  }
  
  public final void u(Throwable paramThrowable)
  {
    AppMethodBeat.i(118226);
    k localk = this.LQL;
    Throwable localThrowable = this.LQL.a(this.LRS);
    int i;
    if (localk.LRu != 0) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        localk.x(localThrowable);
        localk.gdq();
      }
      AppMethodBeat.o(118226);
      return;
      Object localObject = localk.KUa;
      paramThrowable = (Throwable)localObject;
      if (!(localObject instanceof at)) {
        paramThrowable = null;
      }
      paramThrowable = (at)paramThrowable;
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
            if (!d.g.b.k.g(localObject, au.LRt)) {
              break;
            }
          } while (!at.LRp.compareAndSet(paramThrowable, au.LRt, localThrowable));
          i = 1;
          break;
          if ((localObject instanceof Throwable))
          {
            i = 1;
            break;
          }
        } while (!at.LRp.compareAndSet(paramThrowable, localObject, null));
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.o
 * JD-Core Version:    0.7.0.1
 */