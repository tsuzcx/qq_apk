package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bn;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/executor/OpShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class f
  implements b
{
  public static final f.a gtx;
  
  static
  {
    AppMethodBeat.i(114144);
    gtx = new f.a((byte)0);
    AppMethodBeat.o(114144);
  }
  
  public final void a(e parame, q paramq, bn parambn, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114142);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(parambn, "storage");
    p.h(paramh1, "newFunctionMsgItem");
    ae.i("FunctionMsg.OpShowExecutor", "[OpShowExecutor] op show, old functionMsgItem:".concat(String.valueOf(paramh2)));
    paramh1.bZ(true);
    if (paramh2 != null)
    {
      paramq = new StringBuilder("[OpShowExecutor] op show!,").append(paramh1.getVersion()).append(", ").append(paramh2.getVersion()).append(',');
      if (paramh2.Ld() != null) {
        break label236;
      }
    }
    label236:
    for (boolean bool = true;; bool = false)
    {
      ae.i("FunctionMsg.OpShowExecutor", bool);
      paramh2.bZ(true);
      if ((paramh2.Ld() != null) && (paramh2.getStatus() == 2))
      {
        ae.i("FunctionMsg.OpShowExecutor", "show, update create time to: %s", new Object[] { Long.valueOf(paramLong) });
        paramq = paramh2.Ld();
        if (paramq != null) {
          paramq.CreateTime = ((int)(ch.aDa() / 1000L));
        }
      }
      paramh2.bc(paramh1.Lg());
      paramh2.eN(paramh1.Lc());
      paramq = paramh2.La();
      p.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
      bn.a(paramq, paramh2);
      parame.a(3, paramh2, (b)this);
      AppMethodBeat.o(114142);
      return;
    }
  }
  
  public final void a(e parame, q paramq, d paramd)
  {
    AppMethodBeat.i(114143);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(paramd, "task");
    parame = paramd.gtk;
    paramq.a(parame.La(), parame, parame.Ld());
    AppMethodBeat.o(114143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.v.f
 * JD-Core Version:    0.7.0.1
 */