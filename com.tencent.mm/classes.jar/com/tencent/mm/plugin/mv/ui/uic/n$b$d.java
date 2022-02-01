package com.tencent.mm.plugin.mv.ui.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class n$b$d
  extends k
  implements m<aq, kotlin.d.d<? super LinkedList<com.tencent.mm.plugin.thumbplayer.d.d>>, Object>
{
  int label;
  
  n$b$d(n paramn, kotlin.d.d<? super d> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(288019);
    paramObject = (kotlin.d.d)new d(this.Mgw, paramd);
    AppMethodBeat.o(288019);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(288012);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(288012);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = this.Mgw.grd();
    AppMethodBeat.o(288012);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.n.b.d
 * JD-Core Version:    0.7.0.1
 */