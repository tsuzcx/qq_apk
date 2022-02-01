package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.a.x;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.i;

@Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class e$a
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  e$a(h<? super T> paramh, e<T> parame, d<? super a> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(189170);
    paramd = new a(this.ajzk, this.ajzl, paramd);
    paramd.L$0 = paramObject;
    paramObject = (d)paramd;
    AppMethodBeat.o(189170);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(189158);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(189158);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      Object localObject = (aq)this.L$0;
      paramObject = this.ajzk;
      localObject = this.ajzl.b((aq)localObject);
      d locald = (d)this;
      this.label = 1;
      if (i.a(paramObject, (x)localObject, locald) == locala)
      {
        AppMethodBeat.o(189158);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(189158);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.b.a.e.a
 * JD-Core Version:    0.7.0.1
 */