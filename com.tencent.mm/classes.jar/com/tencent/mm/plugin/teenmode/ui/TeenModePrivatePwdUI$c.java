package com.tencent.mm.plugin.teenmode.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fak;
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
final class TeenModePrivatePwdUI$c
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  TeenModePrivatePwdUI$c(g<com.tencent.mm.am.a.a<fak>> paramg, TeenModePrivatePwdUI paramTeenModePrivatePwdUI, d<? super c> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(279246);
    paramObject = (d)new c(this.Tbd, this.Tbm, paramd);
    AppMethodBeat.o(279246);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(279236);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(279236);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.Tbd;
      h localh = (h)new TeenModePrivatePwdUI.c.a(this.Tbm);
      d locald = (d)this;
      this.label = 1;
      if (paramObject.a(localh, locald) == locala)
      {
        AppMethodBeat.o(279236);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(279236);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.TeenModePrivatePwdUI.c
 * JD-Core Version:    0.7.0.1
 */