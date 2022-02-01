package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.d.f.c;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "message", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"})
public final class ai
{
  public static final boolean a(ah paramah)
  {
    AppMethodBeat.i(209359);
    paramah = (br)paramah.gzg().get((f.c)br.OfS);
    if (paramah != null)
    {
      boolean bool = paramah.isActive();
      AppMethodBeat.o(209359);
      return bool;
    }
    AppMethodBeat.o(209359);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.ai
 * JD-Core Version:    0.7.0.1
 */