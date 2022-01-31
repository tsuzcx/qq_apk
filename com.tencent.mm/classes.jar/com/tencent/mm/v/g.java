package com.tencent.mm.v;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.f;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ba;
import com.tencent.mm.u.b.a;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import java.util.LinkedList;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/executor/OpUpdateExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class g
  implements b
{
  public static final g.a ezd;
  
  static
  {
    AppMethodBeat.i(35496);
    ezd = new g.a((byte)0);
    AppMethodBeat.o(35496);
  }
  
  public final void a(e parame, com.tencent.mm.api.l paraml, ba paramba, f paramf1, f paramf2, long paramLong)
  {
    AppMethodBeat.i(35494);
    j.q(parame, "timer");
    j.q(paraml, "dispatcher");
    j.q(paramba, "storage");
    j.q(paramf1, "newFunctionMsgItem");
    paramf1.bl(true);
    if (paramf2 == null)
    {
      ab.i("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor] op update, insert a new one! ".concat(String.valueOf(paramf1)));
      paramba.insert((c)paramf1);
      parame.a(0, paramf1, (b)this);
      AppMethodBeat.o(35494);
      return;
    }
    if (paramf2.getVersion() < paramf1.getVersion())
    {
      ab.i("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor] op update, update the exist one! [%s:%s]", new Object[] { paramf1, paramf2 });
      paramf2.aD(paramf2.getVersion());
      paramf1.aD(paramf2.getVersion());
      paraml = paramf2.Ad();
      j.p(paraml, "oldFunctionMsgItem!!.functionMsgId");
      ba.a(paraml, paramf1);
      parame.a(0, paramf1, (b)this);
      AppMethodBeat.o(35494);
      return;
    }
    if (paramf2.getVersion() >= paramf1.getVersion()) {
      ab.e("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor], id:%s old:new [%s:%s]", new Object[] { paramf2.Ad(), Long.valueOf(paramf2.getVersion()), Long.valueOf(paramf1.getVersion()) });
    }
    AppMethodBeat.o(35494);
  }
  
  public final void a(e parame, com.tencent.mm.api.l paraml, d paramd)
  {
    AppMethodBeat.i(35495);
    j.q(parame, "timer");
    j.q(paraml, "dispatcher");
    j.q(paramd, "task");
    f localf = paramd.eyP;
    if (localf.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localf);
      new com.tencent.mm.u.b((List)localLinkedList, paraml, (b.a)new g.b(parame, paramd, localf, paraml)).Pm();
      AppMethodBeat.o(35495);
      return;
    }
    if ((localf.getStatus() == 2) || (localf.getStatus() == -2))
    {
      ab.i("FunctionMsg.OpUpdateExecutor", "[onTaskExpired] id" + localf.Ad() + " actionTime:" + localf.Ai());
      if (localf.Ai() <= cb.abp() / 1000L)
      {
        paraml.a(localf.Ad(), localf, localf.Ag());
        AppMethodBeat.o(35495);
        return;
      }
      parame.a(localf.Ac(), localf, paramd.eyQ);
    }
    AppMethodBeat.o(35495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.v.g
 * JD-Core Version:    0.7.0.1
 */