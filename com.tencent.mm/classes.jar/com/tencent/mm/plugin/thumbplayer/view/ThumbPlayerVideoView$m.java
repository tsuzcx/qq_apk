package com.tencent.mm.plugin.thumbplayer.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class ThumbPlayerVideoView$m
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  ThumbPlayerVideoView$m(ThumbPlayerVideoView paramThumbPlayerVideoView, d<? super m> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(272339);
    paramObject = (d)new m(this.THu, paramd);
    AppMethodBeat.o(272339);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(272332);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(272332);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
    }
    for (;;)
    {
      paramObject = (d)this;
      this.label = 1;
      if (bb.e(500L, paramObject) == locala)
      {
        AppMethodBeat.o(272332);
        return locala;
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ThumbPlayerVideoView.c(this.THu);
      if (paramObject == null) {}
      for (paramObject = null; paramObject == null; paramObject = kotlin.d.b.a.b.BF(paramObject.getCurrentPositionMs()))
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(272332);
        return paramObject;
      }
      long l = paramObject.longValue();
      paramObject = this.THu.getProgressListener();
      if (paramObject != null) {
        paramObject.qT(l);
      }
      ThumbPlayerVideoView.a(this.THu, (kotlin.g.a.b)new ThumbPlayerVideoView.m.1(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView.m
 * JD-Core Version:    0.7.0.1
 */