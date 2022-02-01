package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.internal.ag;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/UndispatchedContextCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "downstream", "emitContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "countOrElement", "", "emitRef", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function2;", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class aa<T>
  implements h<T>
{
  private final Object ajAa;
  private final m<T, d<? super ah>, Object> ajAb;
  private final kotlin.d.f ajzZ;
  
  public aa(h<? super T> paramh, kotlin.d.f paramf)
  {
    AppMethodBeat.i(189156);
    this.ajzZ = paramf;
    this.ajAa = ag.i(this.ajzZ);
    this.ajAb = ((m)new a(paramh, null));
    AppMethodBeat.o(189156);
  }
  
  public final Object a(T paramT, d<? super ah> paramd)
  {
    AppMethodBeat.i(189165);
    paramT = f.a(this.ajzZ, paramT, this.ajAa, this.ajAb, paramd);
    if (paramT == a.aiwj)
    {
      AppMethodBeat.o(189165);
      return paramT;
    }
    paramT = ah.aiuX;
    AppMethodBeat.o(189165);
    return paramT;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "it"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<T, d<? super ah>, Object>
  {
    int label;
    
    a(h<? super T> paramh, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(189198);
      paramd = new a(this.ajAc, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(189198);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(189189);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(189189);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.L$0;
        h localh = this.ajAc;
        d locald = (d)this;
        this.label = 1;
        if (localh.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(189189);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(189189);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.b.a.aa
 * JD-Core Version:    0.7.0.1
 */