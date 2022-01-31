package com.tencent.mm.v;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.f;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ba;
import com.tencent.mm.u.b.a;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import java.util.LinkedList;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/executor/OpDelayExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class c
  implements b
{
  public static final c.a eyV;
  
  static
  {
    AppMethodBeat.i(35480);
    eyV = new c.a((byte)0);
    AppMethodBeat.o(35480);
  }
  
  public final void a(e parame, com.tencent.mm.api.l paraml, ba paramba, f paramf1, f paramf2, long paramLong)
  {
    AppMethodBeat.i(35478);
    j.q(parame, "timer");
    j.q(paraml, "dispatcher");
    j.q(paramba, "storage");
    j.q(paramf1, "newFunctionMsgItem");
    if (paramf2 != null)
    {
      paramf1.bl(true);
      paramf2.aD(paramf2.getVersion());
      paramf2.aC(paramf1.getVersion());
      if (0L < paramf1.Ai()) {
        paramf2.aF(paramf1.Ai() + paramf1.Ah());
      }
      for (;;)
      {
        paramf2.cY(paramf1.Af());
        paraml = paramf2.Ad();
        j.p(paraml, "oldFunctionMsgItem!!.functionMsgId");
        ba.a(paraml, paramf2);
        ab.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor], functionMsgId: " + paramf1.Ad() + ", op delay! update the exist one, new ActionTime:" + paramf1.Ai() + " new delay:" + paramf1.Ah() + " reslt:" + paramf2);
        parame.a(101, paramf2, (b)this);
        AppMethodBeat.o(35478);
        return;
        paramf2.aF(paramf2.Ai() + paramf1.Ah());
      }
    }
    ab.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor] op delay, oldFunctionMsgItem is null! newFunctionMsgItem: ".concat(String.valueOf(paramf1)));
    AppMethodBeat.o(35478);
  }
  
  public final void a(e parame, com.tencent.mm.api.l paraml, d paramd)
  {
    AppMethodBeat.i(35479);
    j.q(parame, "timer");
    j.q(paraml, "dispatcher");
    j.q(paramd, "task");
    f localf = paramd.eyP;
    if (localf.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localf);
      new com.tencent.mm.u.b((List)localLinkedList, paraml, (b.a)new c.b(parame, paramd, localf, paraml)).Pm();
      AppMethodBeat.o(35479);
      return;
    }
    if ((localf.getStatus() == 2) || (localf.getStatus() == -2))
    {
      ab.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] id" + localf.Ad() + " actionTime:" + localf.Ai());
      if (localf.Ai() <= cb.abp() / 1000L)
      {
        paraml.a(localf.Ad(), localf, localf.Ag());
        AppMethodBeat.o(35479);
        return;
      }
      parame.a(localf.Ac(), localf, paramd.eyQ);
    }
    AppMethodBeat.o(35479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.v.c
 * JD-Core Version:    0.7.0.1
 */