package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.d.f.c;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "message", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"})
public final class ai
{
  public static final boolean a(ah paramah)
  {
    AppMethodBeat.i(190868);
    paramah = (br)paramah.guE().get((f.c)br.NIM);
    if (paramah != null)
    {
      boolean bool = paramah.isActive();
      AppMethodBeat.o(190868);
      return bool;
    }
    AppMethodBeat.o(190868);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.ai
 * JD-Core Version:    0.7.0.1
 */