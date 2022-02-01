package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.j;
import com.tencent.mm.api.u;
import com.tencent.mm.s.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.bu;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/executor/OpDeleteExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsg", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements b
{
  public static final d.a mqg;
  
  static
  {
    AppMethodBeat.i(114136);
    mqg = new d.a((byte)0);
    AppMethodBeat.o(114136);
  }
  
  public final void a(e parame, u paramu, com.tencent.mm.s.d paramd)
  {
    AppMethodBeat.i(114135);
    s.u(parame, "timer");
    s.u(paramu, "dispatcher");
    s.u(paramd, "task");
    Log.i("FunctionMsg.OpDeleteExecutor", s.X("[onTaskExpired] delete ", paramd.mpT.field_functionmsgid));
    parame = paramd.mpT;
    paramu.a(parame.field_functionmsgid, parame, parame.field_addMsg);
    AppMethodBeat.o(114135);
  }
  
  public final void a(e parame, u paramu, bu parambu, j paramj1, j paramj2, long paramLong)
  {
    AppMethodBeat.i(114134);
    s.u(parame, "timer");
    s.u(paramu, "dispatcher");
    s.u(parambu, "storage");
    s.u(paramj1, "newFunctionMsgItem");
    Log.i("FunctionMsg.OpDeleteExecutor", s.X("[OpDeleteExecutor] op delete! id:", paramj1));
    if (paramj2 == null) {}
    for (paramu = null;; paramu = ah.aiuX)
    {
      if (paramu == null)
      {
        paramu = (d)this;
        Log.i("FunctionMsg.OpDeleteExecutor", s.X("[OpDeleteExecutor] op delete, the origin one not exist! ", paramj1));
        parame.a(1, paramj1, (b)paramu);
      }
      AppMethodBeat.o(114134);
      return;
      paramLong = paramj1.field_version;
      s.checkNotNull(paramj2);
      Log.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete, newFunctionMsgItem.version: %s, functionMsgItem.version: %s, %s", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramj2.field_version), paramj2 });
      if ((paramj1.field_version == paramj2.field_version) || (paramj1.field_version == 0L))
      {
        paramj2.field_actionTime = paramj1.field_actionTime;
        parambu.delete((IAutoDBItem)paramj2, new String[0]);
        paramj2.field_businessInfo = paramj1.field_businessInfo;
        parame.a(1, paramj2, (b)this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.d
 * JD-Core Version:    0.7.0.1
 */