package com.tencent.mm.plugin.thumbplayer.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ResultKt;
import kotlin.d.b.a.b;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.aw;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class ThumbPlayerVideoView$m
  extends j
  implements m<ak, d<? super x>, Object>
{
  Object L$0;
  int label;
  private ak p$;
  
  ThumbPlayerVideoView$m(ThumbPlayerVideoView paramThumbPlayerVideoView, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<x> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(191576);
    p.k(paramd, "completion");
    paramd = new m(this.MUS, paramd);
    paramd.p$ = ((ak)paramObject);
    AppMethodBeat.o(191576);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(191580);
    paramObject1 = ((m)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
    AppMethodBeat.o(191580);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(191569);
    kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
    Object localObject;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(191569);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      localObject = this.p$;
    }
    for (;;)
    {
      this.L$0 = localObject;
      this.label = 1;
      paramObject = localObject;
      if (aw.a(500L, this) == locala)
      {
        AppMethodBeat.o(191569);
        return locala;
        localObject = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
      }
      localObject = ThumbPlayerVideoView.a(this.MUS);
      if (localObject == null) {
        break;
      }
      long l = b.Xu(((com.tencent.mm.plugin.thumbplayer.f.a)localObject).getCurrentPositionMs()).longValue();
      ThumbPlayerVideoView.d locald = this.MUS.getProgressListener();
      localObject = paramObject;
      if (locald != null)
      {
        locald.Np(l);
        localObject = paramObject;
      }
    }
    paramObject = x.aazN;
    AppMethodBeat.o(191569);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView.m
 * JD-Core Version:    0.7.0.1
 */