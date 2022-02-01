package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/flow/internal/SendingCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/SendChannel;)V", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class c<T>
  implements kotlinx.coroutines.b.c<T>
{
  private final kotlinx.coroutines.a.x<T> abyN;
  
  public c(kotlinx.coroutines.a.x<? super T> paramx)
  {
    this.abyN = paramx;
  }
  
  public final Object a(T paramT, d<? super kotlin.x> paramd)
  {
    AppMethodBeat.i(204305);
    paramT = this.abyN.c(paramT, paramd);
    if (paramT == a.aaAA)
    {
      AppMethodBeat.o(204305);
      return paramT;
    }
    paramT = kotlin.x.aazN;
    AppMethodBeat.o(204305);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.b.a.c
 * JD-Core Version:    0.7.0.1
 */