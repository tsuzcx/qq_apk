package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bs;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/executor/OpShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class f
  implements b
{
  public static final f.a hfh;
  
  static
  {
    AppMethodBeat.i(114144);
    hfh = new f.a((byte)0);
    AppMethodBeat.o(114144);
  }
  
  public final void a(e parame, s params, bs parambs, i parami1, i parami2, long paramLong)
  {
    AppMethodBeat.i(114142);
    p.h(parame, "timer");
    p.h(params, "dispatcher");
    p.h(parambs, "storage");
    p.h(parami1, "newFunctionMsgItem");
    Log.i("FunctionMsg.OpShowExecutor", "[OpShowExecutor] op show, old functionMsgItem:".concat(String.valueOf(parami2)));
    parami1.cI(true);
    if (parami2 != null)
    {
      params = new StringBuilder("[OpShowExecutor] op show!,").append(parami1.getVersion()).append(", ").append(parami2.getVersion()).append(',');
      if (parami2.Vn() != null) {
        break label236;
      }
    }
    label236:
    for (boolean bool = true;; bool = false)
    {
      Log.i("FunctionMsg.OpShowExecutor", bool);
      parami2.cI(true);
      if ((parami2.Vn() != null) && (parami2.getStatus() == 2))
      {
        Log.i("FunctionMsg.OpShowExecutor", "show, update create time to: %s", new Object[] { Long.valueOf(paramLong) });
        params = parami2.Vn();
        if (params != null) {
          params.CreateTime = ((int)(cl.aWy() / 1000L));
        }
      }
      parami2.br(parami1.Vq());
      parami2.fz(parami1.Vm());
      params = parami2.Vk();
      p.g(params, "oldFunctionMsgItem!!.functionMsgId");
      bs.a(params, parami2);
      parame.a(3, parami2, (b)this);
      AppMethodBeat.o(114142);
      return;
    }
  }
  
  public final void a(e parame, s params, d paramd)
  {
    AppMethodBeat.i(114143);
    p.h(parame, "timer");
    p.h(params, "dispatcher");
    p.h(paramd, "task");
    parame = paramd.heU;
    params.a(parame.Vk(), parame, parame.Vn());
    AppMethodBeat.o(114143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.v.f
 * JD-Core Version:    0.7.0.1
 */