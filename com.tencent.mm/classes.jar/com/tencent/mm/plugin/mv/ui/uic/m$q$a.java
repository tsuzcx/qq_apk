package com.tencent.mm.plugin.mv.ui.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.model.e.e;
import com.tencent.mm.plugin.thumbplayer.a.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class m$q$a
  extends k
  implements m<aq, d<? super b>, Object>
{
  int label;
  
  m$q$a(e.e parame, d<? super a> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(287800);
    paramObject = (d)new a(this.Mgq, paramd);
    AppMethodBeat.o(287800);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(287792);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(287792);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = this.Mgq.gpB();
    AppMethodBeat.o(287792);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.m.q.a
 * JD-Core Version:    0.7.0.1
 */