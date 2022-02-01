package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bg;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/executor/OpShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class f
  implements b
{
  public static final f.a fXB;
  
  static
  {
    AppMethodBeat.i(114144);
    fXB = new f.a((byte)0);
    AppMethodBeat.o(114144);
  }
  
  public final void a(e parame, q paramq, bg parambg, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114142);
    k.h(parame, "timer");
    k.h(paramq, "dispatcher");
    k.h(parambg, "storage");
    k.h(paramh1, "newFunctionMsgItem");
    ac.i("FunctionMsg.OpShowExecutor", "[OpShowExecutor] op show, old functionMsgItem:".concat(String.valueOf(paramh2)));
    paramh1.bX(true);
    if (paramh2 != null)
    {
      paramq = new StringBuilder("[OpShowExecutor] op show!,").append(paramh1.getVersion()).append(", ").append(paramh2.getVersion()).append(',');
      if (paramh2.Jw() != null) {
        break label236;
      }
    }
    label236:
    for (boolean bool = true;; bool = false)
    {
      ac.i("FunctionMsg.OpShowExecutor", bool);
      paramh2.bX(true);
      if ((paramh2.Jw() != null) && (paramh2.getStatus() == 2))
      {
        ac.i("FunctionMsg.OpShowExecutor", "show, update create time to: %s", new Object[] { Long.valueOf(paramLong) });
        paramq = paramh2.Jw();
        if (paramq != null) {
          paramq.CreateTime = ((int)(ce.azH() / 1000L));
        }
      }
      paramh2.bc(paramh1.Jz());
      paramh2.dN(paramh1.Jv());
      paramq = paramh2.Jt();
      k.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
      bg.a(paramq, paramh2);
      parame.a(3, paramh2, (b)this);
      AppMethodBeat.o(114142);
      return;
    }
  }
  
  public final void a(e parame, q paramq, d paramd)
  {
    AppMethodBeat.i(114143);
    k.h(parame, "timer");
    k.h(paramq, "dispatcher");
    k.h(paramd, "task");
    parame = paramd.fXo;
    paramq.a(parame.Jt(), parame, parame.Jw());
    AppMethodBeat.o(114143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.v.f
 * JD-Core Version:    0.7.0.1
 */