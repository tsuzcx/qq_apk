package com.tencent.mm.sns_compose.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sns_compose.a.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;"}, k=3, mv={1, 5, 1}, xi=48)
final class g$a
  extends k
  implements m<f, kotlin.d.d<? super Boolean>, Object>
{
  int label;
  
  g$a(d paramd, kotlin.d.d<? super a> paramd1)
  {
    super(2, paramd1);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(235523);
    paramd = new a(this.aczY, paramd);
    paramd.L$0 = paramObject;
    paramObject = (kotlin.d.d)paramd;
    AppMethodBeat.o(235523);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(235517);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(235517);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = (f)this.L$0;
    if (!s.p(((d.a)this.aczY).aczN.hQX, paramObject.hQX)) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(235517);
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sns_compose.c.g.a
 * JD-Core Version:    0.7.0.1
 */