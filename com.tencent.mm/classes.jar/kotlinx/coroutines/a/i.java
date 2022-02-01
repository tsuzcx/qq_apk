package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Channel", "Lkotlinx/coroutines/channels/Channel;", "E", "capacity", "", "kotlinx-coroutines-core"})
public final class i
{
  public static final <E> g<E> aFQ(int paramInt)
  {
    AppMethodBeat.i(204359);
    switch (paramInt)
    {
    default: 
      localObject = (g)new e(paramInt);
      AppMethodBeat.o(204359);
      return localObject;
    case 0: 
      localObject = (g)new v();
      AppMethodBeat.o(204359);
      return localObject;
    case 2147483647: 
      localObject = (g)new p();
      AppMethodBeat.o(204359);
      return localObject;
    case -1: 
      localObject = (g)new o();
      AppMethodBeat.o(204359);
      return localObject;
    }
    Object localObject = g.abyq;
    localObject = (g)new e(g.a.iSw());
    AppMethodBeat.o(204359);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.i
 * JD-Core Version:    0.7.0.1
 */