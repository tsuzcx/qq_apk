package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"yield", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkCompletion", "Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"})
public final class de
{
  public static final void e(f paramf)
  {
    AppMethodBeat.i(204787);
    paramf = (by)paramf.get((f.c)by.abxs);
    if ((paramf != null) && (!paramf.isActive()))
    {
      paramf = (Throwable)paramf.iRF();
      AppMethodBeat.o(204787);
      throw paramf;
    }
    AppMethodBeat.o(204787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.de
 * JD-Core Version:    0.7.0.1
 */