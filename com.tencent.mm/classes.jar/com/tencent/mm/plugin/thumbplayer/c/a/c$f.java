package com.tencent.mm.plugin.thumbplayer.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class c$f
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  c$f(cb paramcb, c paramc, kotlin.g.a.a<ah> parama, d<? super f> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(272602);
    paramObject = (d)new f(this.DjO, this.TEA, this.TEC, paramd);
    AppMethodBeat.o(272602);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(272597);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(272597);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      if (this.DjO.isCompleted())
      {
        Log.i(c.b(this.TEA), "bitmap loading job has been already finished");
        this.TEC.invoke();
      }
      break;
    }
    for (;;)
    {
      paramObject = ah.aiuX;
      AppMethodBeat.o(272597);
      return paramObject;
      Log.i(c.b(this.TEA), "joins the bitmap loading job");
      paramObject = this.DjO;
      d locald = (d)this;
      this.label = 1;
      if (paramObject.ay(locald) == locala)
      {
        AppMethodBeat.o(272597);
        return locala;
        ResultKt.throwOnFailure(paramObject);
      }
      Log.i(c.b(this.TEA), "bitmap loading job has been finished");
      this.TEC.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.a.c.f
 * JD-Core Version:    0.7.0.1
 */