package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlinx.coroutines.a.f;

@Metadata(d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class k$a
  implements g<T>
{
  public k$a(f paramf) {}
  
  public final Object a(h<? super T> paramh, d<? super ah> paramd)
  {
    AppMethodBeat.i(189112);
    paramh = i.a(paramh, this.ajyg.kDj(), paramd);
    if (paramh == a.aiwj)
    {
      AppMethodBeat.o(189112);
      return paramh;
    }
    paramh = ah.aiuX;
    AppMethodBeat.o(189112);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.b.k.a
 * JD-Core Version:    0.7.0.1
 */