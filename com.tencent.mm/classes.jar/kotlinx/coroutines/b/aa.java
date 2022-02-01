package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/SafeFlow;", "T", "Lkotlinx/coroutines/flow/AbstractFlow;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "collectSafely", "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class aa<T>
  extends a<T>
{
  private final m<h<? super T>, d<? super ah>, Object> aoK;
  
  public aa(m<? super h<? super T>, ? super d<? super ah>, ? extends Object> paramm)
  {
    this.aoK = paramm;
  }
  
  public final Object b(h<? super T> paramh, d<? super ah> paramd)
  {
    AppMethodBeat.i(189014);
    paramh = this.aoK.invoke(paramh, paramd);
    if (paramh == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(189014);
      return paramh;
    }
    paramh = ah.aiuX;
    AppMethodBeat.o(189014);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.aa
 * JD-Core Version:    0.7.0.1
 */