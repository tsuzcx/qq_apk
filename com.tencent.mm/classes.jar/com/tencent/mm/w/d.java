package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bm;
import com.tencent.mm.v.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/executor/OpDeleteExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsg", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class d
  implements b
{
  public static final d.a gqV;
  
  static
  {
    AppMethodBeat.i(114136);
    gqV = new d.a((byte)0);
    AppMethodBeat.o(114136);
  }
  
  public final void a(e parame, q paramq, bm parambm, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114134);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(parambm, "storage");
    p.h(paramh1, "newFunctionMsgItem");
    ad.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete! id:".concat(String.valueOf(paramh1)));
    if (paramh2 != null)
    {
      ad.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete, newFunctionMsgItem.version: %s, functionMsgItem.version: %s, %s", new Object[] { Long.valueOf(paramh1.getVersion()), Long.valueOf(paramh2.getVersion()), paramh2 });
      if ((paramh1.getVersion() == paramh2.getVersion()) || (paramh1.getVersion() == 0L))
      {
        paramh2.bc(paramh1.KY());
        parambm.delete((c)paramh2, new String[0]);
        paramh2.a(paramh1.KW());
        parame.a(1, paramh2, (b)this);
      }
      AppMethodBeat.o(114134);
      return;
    }
    paramq = (d)this;
    ad.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete, the origin one not exist! ".concat(String.valueOf(paramh1)));
    parame.a(1, paramh1, (b)paramq);
    AppMethodBeat.o(114134);
  }
  
  public final void a(e parame, q paramq, com.tencent.mm.v.d paramd)
  {
    AppMethodBeat.i(114135);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(paramd, "task");
    ad.i("FunctionMsg.OpDeleteExecutor", "[onTaskExpired] delete " + paramd.gqK.KS());
    parame = paramd.gqK;
    paramq.b(parame.KS(), parame, parame.KV());
    AppMethodBeat.o(114135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.w.d
 * JD-Core Version:    0.7.0.1
 */