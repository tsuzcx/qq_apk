package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class k$n
  extends kotlin.d.b.a.k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  k$n(k paramk, Intent paramIntent, int paramInt, d<? super n> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(287553);
    paramObject = (d)new n(this.Mfr, this.Mfs, this.Mft, paramd);
    AppMethodBeat.o(287553);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(287547);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(287547);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    k.a(this.Mfr, this.Mfs, this.Mft);
    paramObject = ah.aiuX;
    AppMethodBeat.o(287547);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.k.n
 * JD-Core Version:    0.7.0.1
 */