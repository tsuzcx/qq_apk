package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.l;
import kotlinx.coroutines.internal.e;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentCoroutineContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "message", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"})
public final class al
{
  public static final void a(ak paramak, String paramString)
  {
    AppMethodBeat.i(204330);
    a(paramak, bm.c(paramString, null));
    AppMethodBeat.o(204330);
  }
  
  public static final void a(ak paramak, CancellationException paramCancellationException)
  {
    AppMethodBeat.i(204329);
    by localby = (by)paramak.getCoroutineContext().get((f.c)by.abxs);
    if (localby == null)
    {
      paramak = (Throwable)new IllegalStateException("Scope cannot be cancelled because it does not have a job: ".concat(String.valueOf(paramak)).toString());
      AppMethodBeat.o(204329);
      throw paramak;
    }
    localby.a(paramCancellationException);
    AppMethodBeat.o(204329);
  }
  
  public static final boolean a(ak paramak)
  {
    AppMethodBeat.i(204327);
    paramak = (by)paramak.getCoroutineContext().get((f.c)by.abxs);
    if (paramak != null)
    {
      boolean bool = paramak.isActive();
      AppMethodBeat.o(204327);
      return bool;
    }
    AppMethodBeat.o(204327);
    return true;
  }
  
  public static final ak b(ak paramak, f paramf)
  {
    AppMethodBeat.i(204324);
    paramak = (ak)new e(paramak.getCoroutineContext().plus(paramf));
    AppMethodBeat.o(204324);
    return paramak;
  }
  
  public static final ak c(f paramf)
  {
    AppMethodBeat.i(204328);
    if (paramf.get((f.c)by.abxs) != null) {}
    for (;;)
    {
      paramf = (ak)new e(paramf);
      AppMethodBeat.o(204328);
      return paramf;
      paramf = paramf.plus((f)cc.b(null));
    }
  }
  
  public static final ak iRe()
  {
    AppMethodBeat.i(204326);
    ak localak = (ak)new e(ct.iRW().plus((f)bc.iRr()));
    AppMethodBeat.o(204326);
    return localak;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.al
 * JD-Core Version:    0.7.0.1
 */