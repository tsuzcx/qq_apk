package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.p;
import d.p.a;
import d.q;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/JobSupport;", "job", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class ce<T>
  extends bu<bv>
{
  private final l<T> Ogl;
  
  public ce(bv parambv, l<? super T> paraml)
  {
    super((br)parambv);
    AppMethodBeat.i(209261);
    this.Ogl = paraml;
    AppMethodBeat.o(209261);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118268);
    String str = "ResumeAwaitOnCompletion[" + this.Ogl + ']';
    AppMethodBeat.o(118268);
    return str;
  }
  
  public final void x(Throwable paramThrowable)
  {
    AppMethodBeat.i(118266);
    Object localObject = ((bv)this.OfU).gAg();
    if (am.gzF())
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
      paramThrowable = (d)this.Ogl;
      localObject = ((u)localObject).cause;
      locala = p.Nhh;
      paramThrowable.eQ(p.eO(q.p((Throwable)localObject)));
      AppMethodBeat.o(118266);
      return;
    }
    paramThrowable = (d)this.Ogl;
    localObject = bw.fY(localObject);
    p.a locala = p.Nhh;
    paramThrowable.eQ(p.eO(localObject));
    AppMethodBeat.o(118266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ce
 * JD-Core Version:    0.7.0.1
 */