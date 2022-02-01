package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.l;
import d.p;
import d.p.a;
import d.q;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/JobSupport;", "job", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class cb<T>
  extends br<bs>
{
  private final k<T> LSj;
  
  public cb(bs parambs, k<? super T> paramk)
  {
    super((bo)parambs);
    AppMethodBeat.i(191159);
    this.LSj = paramk;
    AppMethodBeat.o(191159);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118268);
    String str = "ResumeAwaitOnCompletion[" + this.LSj + ']';
    AppMethodBeat.o(118268);
    return str;
  }
  
  public final void u(Throwable paramThrowable)
  {
    AppMethodBeat.i(118266);
    Object localObject = ((bs)this.LRS).gee();
    if (al.gdD())
    {
      if (!(localObject instanceof bj)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramThrowable = (Throwable)new AssertionError();
        AppMethodBeat.o(118266);
        throw paramThrowable;
      }
    }
    if ((localObject instanceof t))
    {
      paramThrowable = (d)this.LSj;
      localObject = ((t)localObject).cause;
      locala = p.KTg;
      paramThrowable.eK(p.eI(q.n((Throwable)localObject)));
      AppMethodBeat.o(118266);
      return;
    }
    paramThrowable = (d)this.LSj;
    localObject = bt.fS(localObject);
    p.a locala = p.KTg;
    paramThrowable.eK(p.eI(localObject));
    AppMethodBeat.o(118266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.cb
 * JD-Core Version:    0.7.0.1
 */