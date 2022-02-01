package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.b;
import d.d.d;
import d.g.a.m;
import d.l;
import d.p;
import d.p.a;
import d.q;
import d.y;
import kotlinx.coroutines.aq;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"runSafely", "", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"})
public final class a
{
  public static final void a(d<? super y> paramd, d<?> paramd1)
  {
    AppMethodBeat.i(190037);
    try
    {
      paramd = b.d(paramd);
      locala = p.JfM;
      aq.a(paramd, p.eF(y.JfV));
      AppMethodBeat.o(190037);
      return;
    }
    catch (Throwable paramd)
    {
      p.a locala = p.JfM;
      paramd1.eH(p.eF(q.n(paramd)));
      AppMethodBeat.o(190037);
    }
  }
  
  public static final <R, T> void b(m<? super R, ? super d<? super T>, ? extends Object> paramm, R paramR, d<? super T> paramd)
  {
    AppMethodBeat.i(202331);
    try
    {
      paramm = b.d(b.a(paramm, paramR, paramd));
      paramR = p.JfM;
      aq.a(paramm, p.eF(y.JfV));
      AppMethodBeat.o(202331);
      return;
    }
    catch (Throwable paramm)
    {
      paramR = p.JfM;
      paramd.eH(p.eF(q.n(paramm)));
      AppMethodBeat.o(202331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.b.a
 * JD-Core Version:    0.7.0.1
 */