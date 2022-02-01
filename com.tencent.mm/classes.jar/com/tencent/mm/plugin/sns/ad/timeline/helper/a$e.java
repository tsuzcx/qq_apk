package com.tencent.mm.plugin.sns.ad.timeline.helper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.l;
import kotlinx.coroutines.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ThumbResult;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
final class a$e
  extends k
  implements q<h<? super a.b>, Throwable, d<? super ah>, Object>
{
  int label;
  
  a$e(String paramString, d<? super e> paramd)
  {
    super(3, paramd);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(311092);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(311092);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (h)this.L$0;
      Object localObject = this.Qak;
      s.s(localObject, "cacheName");
      localObject = u.b((g)a.aWL((String)localObject));
      d locald = (d)this;
      this.label = 1;
      if (l.a(paramObject, (g)localObject, locald) == locala)
      {
        AppMethodBeat.o(311092);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(311092);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.a.e
 * JD-Core Version:    0.7.0.1
 */