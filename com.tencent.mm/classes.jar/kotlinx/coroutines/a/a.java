package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.d;
import d.g.a.m;
import d.l;
import d.p;
import d.p.a;
import d.q;
import d.y;
import kotlinx.coroutines.au;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"runSafely", "", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"})
public final class a
{
  public static final void a(d<? super y> paramd, d<?> paramd1)
  {
    AppMethodBeat.i(191152);
    try
    {
      paramd = b.d(paramd);
      locala = p.KTg;
      au.a(paramd, p.eI(y.KTp));
      AppMethodBeat.o(191152);
      return;
    }
    catch (Throwable paramd)
    {
      p.a locala = p.KTg;
      paramd1.eK(p.eI(q.n(paramd)));
      AppMethodBeat.o(191152);
    }
  }
  
  public static final <R, T> void b(m<? super R, ? super d<? super T>, ? extends Object> paramm, R paramR, d<? super T> paramd)
  {
    AppMethodBeat.i(118134);
    try
    {
      paramm = b.d(b.a(paramm, paramR, paramd));
      paramR = p.KTg;
      au.a(paramm, p.eI(y.KTp));
      AppMethodBeat.o(118134);
      return;
    }
    catch (Throwable paramm)
    {
      paramR = p.KTg;
      paramd.eK(p.eI(q.n(paramm)));
      AppMethodBeat.o(118134);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.a.a
 * JD-Core Version:    0.7.0.1
 */