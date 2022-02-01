package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/executor/OpShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class f
  implements b
{
  public static final f.a fTH;
  
  static
  {
    AppMethodBeat.i(114144);
    fTH = new f.a((byte)0);
    AppMethodBeat.o(114144);
  }
  
  public final void a(e parame, q paramq, bd parambd, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114142);
    k.h(parame, "timer");
    k.h(paramq, "dispatcher");
    k.h(parambd, "storage");
    k.h(paramh1, "newFunctionMsgItem");
    ad.i("FunctionMsg.OpShowExecutor", "[OpShowExecutor] op show, old functionMsgItem:".concat(String.valueOf(paramh2)));
    paramh1.bW(true);
    if (paramh2 != null)
    {
      paramq = new StringBuilder("[OpShowExecutor] op show!,").append(paramh1.getVersion()).append(", ").append(paramh2.getVersion()).append(',');
      if (paramh2.JN() != null) {
        break label236;
      }
    }
    label236:
    for (boolean bool = true;; bool = false)
    {
      ad.i("FunctionMsg.OpShowExecutor", bool);
      paramh2.bW(true);
      if ((paramh2.JN() != null) && (paramh2.getStatus() == 2))
      {
        ad.i("FunctionMsg.OpShowExecutor", "show, update create time to: %s", new Object[] { Long.valueOf(paramLong) });
        paramq = paramh2.JN();
        if (paramq != null) {
          paramq.CreateTime = ((int)(ce.asQ() / 1000L));
        }
      }
      paramh2.setActionTime(paramh1.getActionTime());
      paramh2.dY(paramh1.JM());
      paramq = paramh2.JK();
      k.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
      bd.a(paramq, paramh2);
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
    parame = paramd.fTu;
    paramq.a(parame.JK(), parame, parame.JN());
    AppMethodBeat.o(114143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.f
 * JD-Core Version:    0.7.0.1
 */