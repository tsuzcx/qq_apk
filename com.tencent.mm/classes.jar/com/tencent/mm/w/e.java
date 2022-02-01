package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.bs;
import com.tencent.mm.u.b.a;
import com.tencent.mm.u.d;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/executor/OpNoShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class e
  implements b
{
  public static final e.a jQY;
  
  static
  {
    AppMethodBeat.i(114141);
    jQY = new e.a((byte)0);
    AppMethodBeat.o(114141);
  }
  
  public final void a(com.tencent.mm.u.e parame, s params, bs parambs, i parami1, i parami2, long paramLong)
  {
    AppMethodBeat.i(114139);
    p.k(parame, "timer");
    p.k(params, "dispatcher");
    p.k(parambs, "storage");
    p.k(parami1, "newFunctionMsgItem");
    parami1.de(false);
    if (parami2 != null)
    {
      if (parami2.getVersion() < parami1.getVersion())
      {
        Log.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, update the exist one, preVersion: %s oldFunctionMsgItem:%s", new Object[] { Long.valueOf(parami2.ZE()), parami2 });
        parami2.bC(parami2.getVersion());
        parami1.bC(parami2.getVersion());
        parami2.bE(parami1.ZJ());
        parami2.gk(parami1.ZF());
        params = parami2.ZD();
        p.j(params, "oldFunctionMsgItem!!.functionMsgId");
        bs.a(params, parami1);
        parame.a(2, parami1, (b)this);
        AppMethodBeat.o(114139);
        return;
      }
      Log.w("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show! but version is smaller");
      AppMethodBeat.o(114139);
      return;
    }
    params = (e)this;
    Log.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, insert a new one! %s", new Object[] { parami1 });
    parambs.insert((IAutoDBItem)parami1);
    parame.a(2, parami1, (b)params);
    AppMethodBeat.o(114139);
  }
  
  public final void a(com.tencent.mm.u.e parame, s params, final d paramd)
  {
    AppMethodBeat.i(114140);
    p.k(parame, "timer");
    p.k(params, "dispatcher");
    p.k(paramd, "task");
    i locali = paramd.jQM;
    if (locali.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(locali);
      new com.tencent.mm.u.b((List)localLinkedList, params, (b.a)new b(parame, paramd)).aDZ();
    }
    AppMethodBeat.o(114140);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/executor/OpNoShowExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(com.tencent.mm.u.e parame, d paramd) {}
    
    public final void a(i parami)
    {
      AppMethodBeat.i(114138);
      p.k(parami, "item");
      Log.i("FunctionMsg.OpNoShowExecutor", "[onSuccessFetch] item:".concat(String.valueOf(parami)));
      if (parami.ZJ() > cm.bfC() / 1000L) {
        this.jQT.a(2, parami, paramd.jQN);
      }
      AppMethodBeat.o(114138);
    }
    
    public final void b(i parami)
    {
      AppMethodBeat.i(114137);
      p.k(parami, "item");
      Log.w("FunctionMsg.OpNoShowExecutor", "[onFailFetch] item:".concat(String.valueOf(parami)));
      if (parami.getStatus() == -1) {
        this.jQT.a(-1, parami, paramd.jQN);
      }
      AppMethodBeat.o(114137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.w.e
 * JD-Core Version:    0.7.0.1
 */