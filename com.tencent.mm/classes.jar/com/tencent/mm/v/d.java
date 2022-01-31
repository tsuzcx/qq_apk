package com.tencent.mm.v;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.f;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ba;
import com.tencent.mm.u.e;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/executor/OpDeleteExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsg", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class d
  implements b
{
  public static final d.a eza;
  
  static
  {
    AppMethodBeat.i(35483);
    eza = new d.a((byte)0);
    AppMethodBeat.o(35483);
  }
  
  public final void a(e parame, com.tencent.mm.api.l paraml, ba paramba, f paramf1, f paramf2, long paramLong)
  {
    AppMethodBeat.i(35481);
    j.q(parame, "timer");
    j.q(paraml, "dispatcher");
    j.q(paramba, "storage");
    j.q(paramf1, "newFunctionMsgItem");
    ab.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete! id:".concat(String.valueOf(paramf1)));
    if (paramf2 != null)
    {
      ab.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete, newFunctionMsgItem.version: %s, functionMsgItem.version: %s, %s", new Object[] { Long.valueOf(paramf1.getVersion()), Long.valueOf(paramf2.getVersion()), paramf2 });
      if ((paramf1.getVersion() == paramf2.getVersion()) || (paramf1.getVersion() == 0L))
      {
        paramf2.aF(paramf1.Ai());
        paramba.delete((c)paramf2, new String[0]);
        parame.a(1, paramf2, (b)this);
      }
      AppMethodBeat.o(35481);
      return;
    }
    ab.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete, the origin one not exist! ".concat(String.valueOf(paramf1)));
    AppMethodBeat.o(35481);
  }
  
  public final void a(e parame, com.tencent.mm.api.l paraml, com.tencent.mm.u.d paramd)
  {
    AppMethodBeat.i(35482);
    j.q(parame, "timer");
    j.q(paraml, "dispatcher");
    j.q(paramd, "task");
    ab.i("FunctionMsg.OpDeleteExecutor", "[onTaskExpired] delete " + paramd.eyP.Ad());
    parame = paramd.eyP;
    paraml.b(parame.Ad(), parame, parame.Ag());
    AppMethodBeat.o(35482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.d
 * JD-Core Version:    0.7.0.1
 */