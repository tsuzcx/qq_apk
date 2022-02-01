package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.b.h;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/SendingCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/SendChannel;)V", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class y<T>
  implements h<T>
{
  private final ab<T> bLy;
  
  public y(ab<? super T> paramab)
  {
    this.bLy = paramab;
  }
  
  public final Object a(T paramT, d<? super ah> paramd)
  {
    AppMethodBeat.i(189238);
    paramT = this.bLy.b(paramT, paramd);
    if (paramT == a.aiwj)
    {
      AppMethodBeat.o(189238);
      return paramT;
    }
    paramT = ah.aiuX;
    AppMethodBeat.o(189238);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.y
 * JD-Core Version:    0.7.0.1
 */