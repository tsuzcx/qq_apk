package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.ae;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.b.ah.d;

@Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class u$d
  implements h<T>
{
  public u$d(h paramh, ah.d paramd) {}
  
  public final Object a(T paramT, d<? super ah> paramd)
  {
    AppMethodBeat.i(189064);
    h localh = this.bLr;
    int i = this.ajyJ.aixb;
    this.ajyJ.aixb = (i + 1);
    if (i < 0)
    {
      paramT = new ArithmeticException("Index overflow has happened");
      AppMethodBeat.o(189064);
      throw paramT;
    }
    paramT = localh.a(new ae(i, paramT), paramd);
    if (paramT == a.aiwj)
    {
      AppMethodBeat.o(189064);
      return paramT;
    }
    paramT = ah.aiuX;
    AppMethodBeat.o(189064);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.b.u.d
 * JD-Core Version:    0.7.0.1
 */