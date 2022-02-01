package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.l;
import kotlinx.coroutines.internal.e;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "message", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"})
public final class aj
{
  public static final boolean a(ai paramai)
  {
    AppMethodBeat.i(192512);
    paramai = (bu)paramai.hMk().get((f.c)bu.TUO);
    if (paramai != null)
    {
      boolean bool = paramai.isActive();
      AppMethodBeat.o(192512);
      return bool;
    }
    AppMethodBeat.o(192512);
    return true;
  }
  
  public static final void b(ai paramai)
  {
    AppMethodBeat.i(192513);
    bu localbu = (bu)paramai.hMk().get((f.c)bu.TUO);
    if (localbu == null)
    {
      paramai = (Throwable)new IllegalStateException("Scope cannot be cancelled because it does not have a job: ".concat(String.valueOf(paramai)).toString());
      AppMethodBeat.o(192513);
      throw paramai;
    }
    localbu.a(null);
    AppMethodBeat.o(192513);
  }
  
  public static final ai hMI()
  {
    AppMethodBeat.i(192511);
    ai localai = (ai)new e(cn.hNy().plus((f)ba.hMV()));
    AppMethodBeat.o(192511);
    return localai;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.aj
 * JD-Core Version:    0.7.0.1
 */