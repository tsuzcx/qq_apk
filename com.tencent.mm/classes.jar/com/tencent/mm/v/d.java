package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.bs;
import com.tencent.mm.u.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/executor/OpDeleteExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsg", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class d
  implements b
{
  public static final d.a hff;
  
  static
  {
    AppMethodBeat.i(114136);
    hff = new d.a((byte)0);
    AppMethodBeat.o(114136);
  }
  
  public final void a(e parame, s params, bs parambs, i parami1, i parami2, long paramLong)
  {
    AppMethodBeat.i(114134);
    p.h(parame, "timer");
    p.h(params, "dispatcher");
    p.h(parambs, "storage");
    p.h(parami1, "newFunctionMsgItem");
    Log.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete! id:".concat(String.valueOf(parami1)));
    if (parami2 != null)
    {
      Log.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete, newFunctionMsgItem.version: %s, functionMsgItem.version: %s, %s", new Object[] { Long.valueOf(parami1.getVersion()), Long.valueOf(parami2.getVersion()), parami2 });
      if ((parami1.getVersion() == parami2.getVersion()) || (parami1.getVersion() == 0L))
      {
        parami2.br(parami1.Vq());
        parambs.delete((IAutoDBItem)parami2, new String[0]);
        parami2.a(parami1.Vo());
        parame.a(1, parami2, (b)this);
      }
      AppMethodBeat.o(114134);
      return;
    }
    params = (d)this;
    Log.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete, the origin one not exist! ".concat(String.valueOf(parami1)));
    parame.a(1, parami1, (b)params);
    AppMethodBeat.o(114134);
  }
  
  public final void a(e parame, s params, com.tencent.mm.u.d paramd)
  {
    AppMethodBeat.i(114135);
    p.h(parame, "timer");
    p.h(params, "dispatcher");
    p.h(paramd, "task");
    Log.i("FunctionMsg.OpDeleteExecutor", "[onTaskExpired] delete " + paramd.heU.Vk());
    parame = paramd.heU;
    params.b(parame.Vk(), parame, parame.Vn());
    AppMethodBeat.o(114135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.v.d
 * JD-Core Version:    0.7.0.1
 */