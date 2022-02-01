package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.cf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bm;
import com.tencent.mm.v.d;
import com.tencent.mm.v.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/executor/OpShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class f
  implements b
{
  public static final f.a gqX;
  
  static
  {
    AppMethodBeat.i(114144);
    gqX = new f.a((byte)0);
    AppMethodBeat.o(114144);
  }
  
  public final void a(e parame, q paramq, bm parambm, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114142);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(parambm, "storage");
    p.h(paramh1, "newFunctionMsgItem");
    ad.i("FunctionMsg.OpShowExecutor", "[OpShowExecutor] op show, old functionMsgItem:".concat(String.valueOf(paramh2)));
    paramh1.bZ(true);
    if (paramh2 != null)
    {
      paramq = new StringBuilder("[OpShowExecutor] op show!,").append(paramh1.getVersion()).append(", ").append(paramh2.getVersion()).append(',');
      if (paramh2.KV() != null) {
        break label236;
      }
    }
    label236:
    for (boolean bool = true;; bool = false)
    {
      ad.i("FunctionMsg.OpShowExecutor", bool);
      paramh2.bZ(true);
      if ((paramh2.KV() != null) && (paramh2.getStatus() == 2))
      {
        ad.i("FunctionMsg.OpShowExecutor", "show, update create time to: %s", new Object[] { Long.valueOf(paramLong) });
        paramq = paramh2.KV();
        if (paramq != null) {
          paramq.CreateTime = ((int)(cf.aCK() / 1000L));
        }
      }
      paramh2.bc(paramh1.KY());
      paramh2.eI(paramh1.KU());
      paramq = paramh2.KS();
      p.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
      bm.a(paramq, paramh2);
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
    parame = paramd.gqK;
    paramq.a(parame.KS(), parame, parame.KV());
    AppMethodBeat.o(114143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.w.f
 * JD-Core Version:    0.7.0.1
 */