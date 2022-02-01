package com.tencent.mm.plugin.mv.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class b$b$1
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  b$b$1(kotlin.g.a.a<ah> parama, d<? super 1> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(286233);
    paramObject = (d)new 1(this.nBK, paramd);
    AppMethodBeat.o(286233);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(286230);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(286230);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    this.nBK.invoke();
    paramObject = ah.aiuX;
    AppMethodBeat.o(286230);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b.b.b.1
 * JD-Core Version:    0.7.0.1
 */