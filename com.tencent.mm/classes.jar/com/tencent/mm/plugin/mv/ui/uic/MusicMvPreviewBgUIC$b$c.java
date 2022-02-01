package com.tencent.mm.plugin.mv.ui.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;

@f(c="com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC$initBgVideo$1$mediaInfoList$1", f="MusicMvPreviewBgUIC.kt", hxM={}, m="invokeSuspend")
@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class MusicMvPreviewBgUIC$b$c
  extends j
  implements m<ai, d<? super LinkedList<com.tencent.mm.plugin.thumbplayer.d.a>>, Object>
{
  int label;
  private ai p$;
  
  MusicMvPreviewBgUIC$b$c(MusicMvPreviewBgUIC.b paramb, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<x> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(258926);
    p.h(paramd, "completion");
    paramd = new c(this.Urp, paramd);
    paramd.p$ = ((ai)paramObject);
    AppMethodBeat.o(258926);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(258927);
    paramObject1 = ((c)create(paramObject1, (d)paramObject2)).invokeSuspend(x.SXb);
    AppMethodBeat.o(258927);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(258925);
    kotlin.d.a.a locala = kotlin.d.a.a.SXO;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(258925);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = this.Urp.Avx.ewh();
    AppMethodBeat.o(258925);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC.b.c
 * JD-Core Version:    0.7.0.1
 */