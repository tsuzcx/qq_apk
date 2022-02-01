package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.p;
import d.p.a;
import d.q;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/JobSupport;", "job", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class ce<T>
  extends bu<bv>
{
  private final l<T> NJf;
  
  public ce(bv parambv, l<? super T> paraml)
  {
    super((br)parambv);
    AppMethodBeat.i(190770);
    this.NJf = paraml;
    AppMethodBeat.o(190770);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118268);
    String str = "ResumeAwaitOnCompletion[" + this.NJf + ']';
    AppMethodBeat.o(118268);
    return str;
  }
  
  public final void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(118266);
    Object localObject = ((bv)this.NIO).gvE();
    if (am.gvd())
    {
      if (!(localObject instanceof bm)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramThrowable = (Throwable)new AssertionError();
        AppMethodBeat.o(118266);
        throw paramThrowable;
      }
    }
    if ((localObject instanceof u))
    {
      paramThrowable = (d)this.NJf;
      localObject = ((u)localObject).cause;
      locala = p.MKe;
      paramThrowable.eN(p.eL(q.o((Throwable)localObject)));
      AppMethodBeat.o(118266);
      return;
    }
    paramThrowable = (d)this.NJf;
    localObject = bw.fV(localObject);
    p.a locala = p.MKe;
    paramThrowable.eN(p.eL(localObject));
    AppMethodBeat.o(118266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ce
 * JD-Core Version:    0.7.0.1
 */