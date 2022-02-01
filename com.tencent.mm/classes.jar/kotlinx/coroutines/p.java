package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "parent", "child", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class p
  extends bw<bu>
{
  public final l<?> TTG;
  
  public p(bu parambu, l<?> paraml)
  {
    super(parambu);
    this.TTG = paraml;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118228);
    String str = "ChildContinuation[" + this.TTG + ']';
    AppMethodBeat.o(118228);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(118226);
    l locall = this.TTG;
    Throwable localThrowable = this.TTG.a(this.TUQ);
    int i;
    if (locall.TUq != 0) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        locall.A(localThrowable);
        locall.hMw();
      }
      AppMethodBeat.o(118226);
      return;
      Object localObject = locall.SXL;
      paramThrowable = (Throwable)localObject;
      if (!(localObject instanceof av)) {
        paramThrowable = null;
      }
      paramThrowable = (av)paramThrowable;
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
            if (!kotlin.g.b.p.j(localObject, aw.TUp)) {
              break;
            }
          } while (!av.TUl.compareAndSet(paramThrowable, aw.TUp, localThrowable));
          i = 1;
          break;
          if ((localObject instanceof Throwable))
          {
            i = 1;
            break;
          }
        } while (!av.TUl.compareAndSet(paramThrowable, localObject, null));
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.p
 * JD-Core Version:    0.7.0.1
 */