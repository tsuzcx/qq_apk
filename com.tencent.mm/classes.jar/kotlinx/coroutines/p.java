package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "parent", "child", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class p
  extends bt<br>
{
  public final l<?> NHG;
  
  public p(br parambr, l<?> paraml)
  {
    super(parambr);
    this.NHG = paraml;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118228);
    String str = "ChildContinuation[" + this.NHG + ']';
    AppMethodBeat.o(118228);
    return str;
  }
  
  public final void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(118226);
    l locall = this.NHG;
    Throwable localThrowable = this.NHG.a(this.NIO);
    int i;
    if (locall.NIp != 0) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        locall.y(localThrowable);
        locall.guQ();
      }
      AppMethodBeat.o(118226);
      return;
      Object localObject = locall.MKZ;
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
            if (!d.g.b.p.i(localObject, av.NIo)) {
              break;
            }
          } while (!au.NIk.compareAndSet(paramThrowable, av.NIo, localThrowable));
          i = 1;
          break;
          if ((localObject instanceof Throwable))
          {
            i = 1;
            break;
          }
        } while (!au.NIk.compareAndSet(paramThrowable, localObject, null));
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.p
 * JD-Core Version:    0.7.0.1
 */