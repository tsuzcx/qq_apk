package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "parent", "child", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class p
  extends bt<br>
{
  public final l<?> OeM;
  
  public p(br parambr, l<?> paraml)
  {
    super(parambr);
    this.OeM = paraml;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118228);
    String str = "ChildContinuation[" + this.OeM + ']';
    AppMethodBeat.o(118228);
    return str;
  }
  
  public final void x(Throwable paramThrowable)
  {
    AppMethodBeat.i(118226);
    l locall = this.OeM;
    Throwable localThrowable = this.OeM.a(this.OfU);
    int i;
    if (locall.Ofv != 0) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        locall.z(localThrowable);
        locall.gzs();
      }
      AppMethodBeat.o(118226);
      return;
      Object localObject = locall.Nic;
      paramThrowable = (Throwable)localObject;
      if (!(localObject instanceof au)) {
        paramThrowable = null;
      }
      paramThrowable = (au)paramThrowable;
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
            if (!d.g.b.p.i(localObject, av.Ofu)) {
              break;
            }
          } while (!au.Ofq.compareAndSet(paramThrowable, av.Ofu, localThrowable));
          i = 1;
          break;
          if ((localObject instanceof Throwable))
          {
            i = 1;
            break;
          }
        } while (!au.Ofq.compareAndSet(paramThrowable, localObject, null));
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.p
 * JD-Core Version:    0.7.0.1
 */