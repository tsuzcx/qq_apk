package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bs;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/executor/OpShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class f
  implements b
{
  public static final f.a jQZ;
  
  static
  {
    AppMethodBeat.i(114144);
    jQZ = new f.a((byte)0);
    AppMethodBeat.o(114144);
  }
  
  public final void a(e parame, s params, bs parambs, i parami1, i parami2, long paramLong)
  {
    AppMethodBeat.i(114142);
    p.k(parame, "timer");
    p.k(params, "dispatcher");
    p.k(parambs, "storage");
    p.k(parami1, "newFunctionMsgItem");
    Log.i("FunctionMsg.OpShowExecutor", "[OpShowExecutor] op show, old functionMsgItem:".concat(String.valueOf(parami2)));
    parami1.de(true);
    if (parami2 != null)
    {
      params = new StringBuilder("[OpShowExecutor] op show!,").append(parami1.getVersion()).append(", ").append(parami2.getVersion()).append(',');
      if (parami2.ZG() != null) {
        break label236;
      }
    }
    label236:
    for (boolean bool = true;; bool = false)
    {
      Log.i("FunctionMsg.OpShowExecutor", bool);
      parami2.de(true);
      if ((parami2.ZG() != null) && (parami2.getStatus() == 2))
      {
        Log.i("FunctionMsg.OpShowExecutor", "show, update create time to: %s", new Object[] { Long.valueOf(paramLong) });
        params = parami2.ZG();
        if (params != null) {
          params.CreateTime = ((int)(cm.bfC() / 1000L));
        }
      }
      parami2.bE(parami1.ZJ());
      parami2.gk(parami1.ZF());
      params = parami2.ZD();
      p.j(params, "oldFunctionMsgItem!!.functionMsgId");
      bs.a(params, parami2);
      parame.a(3, parami2, (b)this);
      AppMethodBeat.o(114142);
      return;
    }
  }
  
  public final void a(e parame, s params, d paramd)
  {
    AppMethodBeat.i(114143);
    p.k(parame, "timer");
    p.k(params, "dispatcher");
    p.k(paramd, "task");
    parame = paramd.jQM;
    params.a(parame.ZD(), parame, parame.ZG(), (List)parame.ZC());
    AppMethodBeat.o(114143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.w.f
 * JD-Core Version:    0.7.0.1
 */