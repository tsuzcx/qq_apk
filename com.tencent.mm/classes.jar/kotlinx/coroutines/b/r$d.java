package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.a.q;

@Metadata(d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it"}, k=3, mv={1, 5, 1}, xi=48)
final class r$d
  extends k
  implements q<h<? super R>, T, d<? super ah>, Object>
{
  int label;
  
  r$d(m<? super T, ? super d<? super R>, ? extends Object> paramm, d<? super d> paramd)
  {
    super(3, paramd);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(189059);
    a locala = a.aiwj;
    Object localObject1;
    Object localObject2;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(189059);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (h)this.L$0;
      localObject1 = this.Uf;
      localObject2 = this.ajyD;
      this.L$0 = paramObject;
      this.label = 1;
      localObject1 = ((m)localObject2).invoke(localObject1, this);
      if (localObject1 == locala)
      {
        AppMethodBeat.o(189059);
        return locala;
      }
      break;
    case 1: 
      localObject2 = (h)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject1 = paramObject;
      paramObject = localObject2;
    }
    for (;;)
    {
      localObject2 = (d)this;
      this.L$0 = null;
      this.label = 2;
      if (paramObject.a(localObject1, (d)localObject2) == locala)
      {
        AppMethodBeat.o(189059);
        return locala;
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(189059);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.b.r.d
 * JD-Core Version:    0.7.0.1
 */