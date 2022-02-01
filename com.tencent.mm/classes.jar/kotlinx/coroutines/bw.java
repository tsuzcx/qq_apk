package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.l;
import d.p;
import d.p.a;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/JobSupport;", "job", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class bw<T>
  extends bm<bn>
{
  private final i<T> KeJ;
  
  public bw(bn parambn, i<? super T> parami)
  {
    super((bj)parambn);
    AppMethodBeat.i(190038);
    this.KeJ = parami;
    AppMethodBeat.o(190038);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118268);
    String str = "ResumeAwaitOnCompletion[" + this.KeJ + ']';
    AppMethodBeat.o(118268);
    return str;
  }
  
  public final void u(Throwable paramThrowable)
  {
    AppMethodBeat.i(118266);
    Object localObject = ((bn)this.Kes).fLv();
    if (ah.fKW())
    {
      if (!(localObject instanceof be)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramThrowable = (Throwable)new AssertionError();
        AppMethodBeat.o(118266);
        throw paramThrowable;
      }
    }
    if ((localObject instanceof q))
    {
      paramThrowable = (d)this.KeJ;
      localObject = ((q)localObject).cause;
      locala = p.JfM;
      paramThrowable.eH(p.eF(d.q.n((Throwable)localObject)));
      AppMethodBeat.o(118266);
      return;
    }
    paramThrowable = (d)this.KeJ;
    localObject = bo.fK(localObject);
    p.a locala = p.JfM;
    paramThrowable.eH(p.eF(localObject));
    AppMethodBeat.o(118266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bw
 * JD-Core Version:    0.7.0.1
 */