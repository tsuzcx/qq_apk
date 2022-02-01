package com.tencent.mm.plugin.mv.ui.uic;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.b;
import com.tencent.mm.protocal.protobuf.dsg;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class j$c
  extends k
  implements m<aq, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  j$c(g<com.tencent.mm.am.a.a<dsg>> paramg, j paramj, kotlin.d.d<? super c> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(288061);
    paramObject = (kotlin.d.d)new c(this.pXA, this.Mfi, paramd);
    AppMethodBeat.o(288061);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(288055);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(288055);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.pXA;
      h localh = (h)new a(this.Mfi);
      kotlin.d.d locald = (kotlin.d.d)this;
      this.label = 1;
      if (paramObject.a(localh, locald) == locala)
      {
        AppMethodBeat.o(288055);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(288055);
    return paramObject;
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements h<com.tencent.mm.am.a.a<dsg>>
  {
    public a(j paramj) {}
    
    public final Object a(com.tencent.mm.am.a.a<dsg> parama, kotlin.d.d<? super ah> paramd)
    {
      AppMethodBeat.i(287604);
      paramd = (com.tencent.mm.am.a.a)parama;
      int i;
      if (paramd.ovD == b.ovB)
      {
        StringBuilder localStringBuilder = new StringBuilder("syncBeatTrack sceneEnd errType:").append(paramd.errType).append(" errCode:").append(paramd.errCode).append(" errMsg:").append(paramd.errMsg).append(" flexSize:");
        parama = (dsg)paramd.ott;
        if (parama != null) {
          break label151;
        }
        parama = null;
        Log.i("MicroMsg.Mv.MusicMvMakerDataUIC", parama);
        if (paramd.errCode == 0)
        {
          parama = (dtf)j.a(this.Mfi).getValue();
          if (parama != null)
          {
            paramd = (dsg)paramd.ott;
            if (paramd != null) {
              break label176;
            }
            i = 20;
          }
        }
      }
      for (;;)
      {
        parama.Mea = i;
        parama = ah.aiuX;
        AppMethodBeat.o(287604);
        return parama;
        label151:
        parama = parama.aaYd;
        if (parama == null)
        {
          parama = null;
          break;
        }
        parama = Integer.valueOf(parama.size());
        break;
        label176:
        paramd = paramd.aaYd;
        if (paramd == null) {
          i = 20;
        } else {
          i = paramd.size();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.j.c
 * JD-Core Version:    0.7.0.1
 */