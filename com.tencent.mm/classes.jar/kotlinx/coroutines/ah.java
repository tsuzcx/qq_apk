package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.d.f.c;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "message", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"})
public final class ah
{
  public static final boolean a(ag paramag)
  {
    AppMethodBeat.i(191255);
    paramag = (bo)paramag.gde().get((f.c)bo.LRQ);
    if (paramag != null)
    {
      boolean bool = paramag.isActive();
      AppMethodBeat.o(191255);
      return bool;
    }
    AppMethodBeat.o(191255);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.ah
 * JD-Core Version:    0.7.0.1
 */