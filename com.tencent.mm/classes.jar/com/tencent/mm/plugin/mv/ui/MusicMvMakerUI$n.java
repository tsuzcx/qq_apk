package com.tencent.mm.plugin.mv.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.model.flex.MusicMvFlexLiveList;
import com.tencent.mm.plugin.mv.ui.uic.j;
import com.tencent.mm.plugin.mv.ui.uic.l;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class MusicMvMakerUI$n
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  MusicMvMakerUI$n(l paraml, j paramj, MusicMvMakerUI paramMusicMvMakerUI, d<? super n> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(286512);
    paramObject = (d)new n(this.Maf, this.Mag, this.Mad, paramd);
    AppMethodBeat.o(286512);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(286505);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(286505);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.Maf.MfF.LYw;
      h localh = (h)new a(this.Mag, this.Mad);
      d locald = (d)this;
      this.label = 1;
      if (paramObject.a(localh, locald) == locala)
      {
        AppMethodBeat.o(286505);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(286505);
    return paramObject;
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements h<HashSet<com.tencent.mm.plugin.mv.model.flex.a>>
  {
    public a(j paramj, MusicMvMakerUI paramMusicMvMakerUI) {}
    
    public final Object a(HashSet<com.tencent.mm.plugin.mv.model.flex.a> paramHashSet, d<? super ah> paramd)
    {
      AppMethodBeat.i(286444);
      paramHashSet = (Iterable)paramHashSet;
      int i;
      if ((!(paramHashSet instanceof Collection)) || (!((Collection)paramHashSet).isEmpty()))
      {
        paramHashSet = paramHashSet.iterator();
        if (paramHashSet.hasNext()) {
          if (((com.tencent.mm.plugin.mv.model.flex.a)paramHashSet.next()).type != 0)
          {
            i = 1;
            label65:
            if (i == 0) {
              break label105;
            }
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (this.Mah.gqh()) {
          MusicMvMakerUI.a(this.Mad, bool);
        }
        paramHashSet = ah.aiuX;
        AppMethodBeat.o(286444);
        return paramHashSet;
        i = 0;
        break label65;
        label105:
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMakerUI.n
 * JD-Core Version:    0.7.0.1
 */