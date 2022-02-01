package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class q$n
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  q$n(q paramq, ThumbPlayerVideoView paramThumbPlayerVideoView, d<? super n> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(254769);
    paramd = new n(this.aeEU, this.aeEY, paramd);
    paramd.L$0 = paramObject;
    paramObject = (d)paramd;
    AppMethodBeat.o(254769);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(254762);
    a locala = a.aiwj;
    Object localObject;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(254762);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (aq)this.L$0;
      if (ar.a(paramObject))
      {
        localObject = (d)this;
        this.L$0 = paramObject;
        this.label = 1;
        if (bb.e(500L, (d)localObject) != locala) {
          break label145;
        }
        AppMethodBeat.o(254762);
        return locala;
      }
      break;
    case 1: 
      localObject = (aq)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      paramObject = localObject;
    }
    label145:
    for (;;)
    {
      q.b(this.aeEU, this.aeEY);
      break;
      paramObject = ah.aiuX;
      AppMethodBeat.o(254762);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.q.n
 * JD-Core Version:    0.7.0.1
 */