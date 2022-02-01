package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.c.b;
import kotlinx.coroutines.internal.g;
import kotlinx.coroutines.internal.y;

@Metadata(d1={""}, d2={"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentCoroutineContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "message", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class ar
{
  public static final void a(aq paramaq, String paramString)
  {
    AppMethodBeat.i(188882);
    a(paramaq, bq.i(paramString, null));
    AppMethodBeat.o(188882);
  }
  
  public static final void a(aq paramaq, CancellationException paramCancellationException)
  {
    AppMethodBeat.i(188874);
    cb localcb = (cb)paramaq.getCoroutineContext().get((f.c)cb.ajws);
    if (localcb == null)
    {
      paramaq = (Throwable)new IllegalStateException(s.X("Scope cannot be cancelled because it does not have a job: ", paramaq).toString());
      AppMethodBeat.o(188874);
      throw paramaq;
    }
    localcb.a(paramCancellationException);
    AppMethodBeat.o(188874);
  }
  
  public static final boolean a(aq paramaq)
  {
    AppMethodBeat.i(188860);
    paramaq = (cb)paramaq.getCoroutineContext().get((f.c)cb.ajws);
    if (paramaq == null)
    {
      AppMethodBeat.o(188860);
      return true;
    }
    boolean bool = paramaq.isActive();
    AppMethodBeat.o(188860);
    return bool;
  }
  
  public static final aq b(aq paramaq, f paramf)
  {
    AppMethodBeat.i(188853);
    paramaq = (aq)new g(paramaq.getCoroutineContext().plus(paramf));
    AppMethodBeat.o(188853);
    return paramaq;
  }
  
  public static final <R> Object c(m<? super aq, ? super d<? super R>, ? extends Object> paramm, d<? super R> paramd)
  {
    AppMethodBeat.i(188863);
    y localy = new y(paramd.getContext(), paramd);
    paramm = b.a(localy, localy, paramm);
    if (paramm == a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(188863);
    return paramm;
  }
  
  public static final aq d(f paramf)
  {
    AppMethodBeat.i(188868);
    if (paramf.get((f.c)cb.ajws) != null) {}
    for (;;)
    {
      paramf = (aq)new g(paramf);
      AppMethodBeat.o(188868);
      return paramf;
      paramf = paramf.plus((f)cg.e(null));
    }
  }
  
  public static final aq kBZ()
  {
    AppMethodBeat.i(188858);
    aq localaq = (aq)new g(cx.g(null).plus((f)bg.kCh()));
    AppMethodBeat.o(188858);
    return localaq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ar
 * JD-Core Version:    0.7.0.1
 */