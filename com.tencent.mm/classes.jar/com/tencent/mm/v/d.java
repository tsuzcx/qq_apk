package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bn;
import com.tencent.mm.u.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/executor/OpDeleteExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsg", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class d
  implements b
{
  public static final d.a gtv;
  
  static
  {
    AppMethodBeat.i(114136);
    gtv = new d.a((byte)0);
    AppMethodBeat.o(114136);
  }
  
  public final void a(e parame, q paramq, bn parambn, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114134);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(parambn, "storage");
    p.h(paramh1, "newFunctionMsgItem");
    ae.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete! id:".concat(String.valueOf(paramh1)));
    if (paramh2 != null)
    {
      ae.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete, newFunctionMsgItem.version: %s, functionMsgItem.version: %s, %s", new Object[] { Long.valueOf(paramh1.getVersion()), Long.valueOf(paramh2.getVersion()), paramh2 });
      if ((paramh1.getVersion() == paramh2.getVersion()) || (paramh1.getVersion() == 0L))
      {
        paramh2.bc(paramh1.Lg());
        parambn.delete((c)paramh2, new String[0]);
        paramh2.a(paramh1.Le());
        parame.a(1, paramh2, (b)this);
      }
      AppMethodBeat.o(114134);
      return;
    }
    paramq = (d)this;
    ae.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete, the origin one not exist! ".concat(String.valueOf(paramh1)));
    parame.a(1, paramh1, (b)paramq);
    AppMethodBeat.o(114134);
  }
  
  public final void a(e parame, q paramq, com.tencent.mm.u.d paramd)
  {
    AppMethodBeat.i(114135);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(paramd, "task");
    ae.i("FunctionMsg.OpDeleteExecutor", "[onTaskExpired] delete " + paramd.gtk.La());
    parame = paramd.gtk;
    paramq.b(parame.La(), parame, parame.Ld());
    AppMethodBeat.o(114135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.v.d
 * JD-Core Version:    0.7.0.1
 */