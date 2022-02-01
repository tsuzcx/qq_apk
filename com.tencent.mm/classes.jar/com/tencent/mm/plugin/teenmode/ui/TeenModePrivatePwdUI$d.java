package com.tencent.mm.plugin.teenmode.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fwq;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.bg;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class TeenModePrivatePwdUI$d
  extends k
  implements kotlin.g.a.m<aq, d<? super ah>, Object>
{
  int label;
  
  TeenModePrivatePwdUI$d(g<com.tencent.mm.am.a.a<fwq>> paramg, TeenModePrivatePwdUI paramTeenModePrivatePwdUI, d<? super d> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(279270);
    paramObject = (d)new d(this.Tbd, this.Tbm, paramd);
    AppMethodBeat.o(279270);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(279258);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(279258);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = kotlinx.coroutines.b.m.a(this.Tbd, (f)bg.kCh());
      h localh = (h)new TeenModePrivatePwdUI.d.b(this.Tbm);
      d locald = (d)this;
      this.label = 1;
      if (paramObject.a(localh, locald) == locala)
      {
        AppMethodBeat.o(279258);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(279258);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.TeenModePrivatePwdUI.d
 * JD-Core Version:    0.7.0.1
 */