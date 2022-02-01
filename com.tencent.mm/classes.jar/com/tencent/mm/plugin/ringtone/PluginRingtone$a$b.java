package com.tencent.mm.plugin.ringtone;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.a.q;
import com.tencent.mm.protocal.protobuf.a.s;
import com.tencent.mm.protocal.protobuf.a.t;
import com.tencent.mm.protocal.protobuf.a.u;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/ringtone/GetRingBackDetailInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class PluginRingtone$a$b
  extends k
  implements m<aq, kotlin.d.d<? super q>, Object>
{
  int label;
  
  PluginRingtone$a$b(int paramInt, kotlin.d.d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(272777);
    paramObject = (kotlin.d.d)new b(this.OBp, paramd);
    AppMethodBeat.o(272777);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(272774);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(272774);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
    }
    try
    {
      paramObject = new t();
      paramObject.vhJ = 1;
      Object localObject = new u();
      ((u)localObject).aaYO = this.OBp;
      ah localah = ah.aiuX;
      paramObject.acjh = ((u)localObject);
      localObject = new LinkedList();
      ((LinkedList)localObject).add(paramObject);
      paramObject = (com.tencent.mm.am.b)new com.tencent.mm.plugin.ringtone.f.d((LinkedList)localObject);
      localObject = (kotlin.d.d)this;
      this.label = 1;
      paramObject = com.tencent.mm.af.b.a(paramObject, (kotlin.d.d)localObject);
      localObject = paramObject;
      if (paramObject == locala)
      {
        AppMethodBeat.o(272774);
        return locala;
        ResultKt.throwOnFailure(paramObject);
        localObject = paramObject;
      }
      paramObject = ((s)localObject).acja;
      if (paramObject != null)
      {
        paramObject = (q)paramObject.getFirst();
        if (paramObject != null)
        {
          AppMethodBeat.o(272774);
          return paramObject;
        }
      }
    }
    catch (Exception paramObject)
    {
      AppMethodBeat.o(272774);
      return null;
    }
    AppMethodBeat.o(272774);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.PluginRingtone.a.b
 * JD-Core Version:    0.7.0.1
 */