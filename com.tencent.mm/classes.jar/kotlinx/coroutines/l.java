package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "parent", "child", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class l
  extends bl<bj>
{
  public final i<?> Kdj;
  
  public l(bj parambj, i<?> parami)
  {
    super(parambj);
    this.Kdj = parami;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118228);
    String str = "ChildContinuation[" + this.Kdj + ']';
    AppMethodBeat.o(118228);
    return str;
  }
  
  public final void u(Throwable paramThrowable)
  {
    AppMethodBeat.i(118226);
    i locali = this.Kdj;
    Throwable localThrowable = this.Kdj.a(this.Kes);
    int i;
    if (locali.KdT != 0) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        locali.v(localThrowable);
        locali.fKJ();
      }
      AppMethodBeat.o(118226);
      return;
      Object localObject = locali.JgG;
      paramThrowable = (Throwable)localObject;
      if (!(localObject instanceof ap)) {
        paramThrowable = null;
      }
      paramThrowable = (ap)paramThrowable;
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
            if (!k.g(localObject, aq.KdS)) {
              break;
            }
          } while (!ap.KdO.compareAndSet(paramThrowable, aq.KdS, localThrowable));
          i = 1;
          break;
          if ((localObject instanceof Throwable))
          {
            i = 1;
            break;
          }
        } while (!ap.KdO.compareAndSet(paramThrowable, localObject, null));
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.l
 * JD-Core Version:    0.7.0.1
 */