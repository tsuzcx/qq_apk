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
import com.tencent.mm.u.e;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/executor/OpUpdateExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class g
  implements b
{
  public static final g.a jRa;
  
  static
  {
    AppMethodBeat.i(114149);
    jRa = new g.a((byte)0);
    AppMethodBeat.o(114149);
  }
  
  public final void a(e parame, s params, bs parambs, i parami1, i parami2, long paramLong)
  {
    AppMethodBeat.i(114147);
    p.k(parame, "timer");
    p.k(params, "dispatcher");
    p.k(parambs, "storage");
    p.k(parami1, "newFunctionMsgItem");
    parami1.de(true);
    if (parami2 == null) {
      Log.i("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor] op update, insert a new one! ".concat(String.valueOf(parami1)));
    }
    try
    {
      parambs.insert((IAutoDBItem)parami1);
      label66:
      parame.a(0, parami1, (b)this);
      AppMethodBeat.o(114147);
      return;
      if (parami2.getVersion() < parami1.getVersion())
      {
        Log.i("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor] op update, update the exist one! [%s:%s]", new Object[] { parami1, parami2 });
        parami2.bC(parami2.getVersion());
        parami1.bC(parami2.getVersion());
        params = parami2.ZD();
        p.j(params, "oldFunctionMsgItem!!.functionMsgId");
        bs.a(params, parami1);
        parame.a(0, parami1, (b)this);
        AppMethodBeat.o(114147);
        return;
      }
      if (parami2.getVersion() >= parami1.getVersion()) {
        Log.e("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor], id:%s old:new [%s:%s]", new Object[] { parami2.ZD(), Long.valueOf(parami2.getVersion()), Long.valueOf(parami1.getVersion()) });
      }
      AppMethodBeat.o(114147);
      return;
    }
    catch (Exception params)
    {
      break label66;
    }
  }
  
  public final void a(e parame, final s params, final d paramd)
  {
    AppMethodBeat.i(114148);
    p.k(parame, "timer");
    p.k(params, "dispatcher");
    p.k(paramd, "task");
    final i locali = paramd.jQM;
    if (locali.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(locali);
      new com.tencent.mm.u.b((List)localLinkedList, params, (b.a)new b(parame, paramd, locali, params)).aDZ();
      AppMethodBeat.o(114148);
      return;
    }
    if ((locali.getStatus() == 2) || (locali.getStatus() == -2))
    {
      Log.i("FunctionMsg.OpUpdateExecutor", "[onTaskExpired] id" + locali.ZD() + " actionTime:" + locali.ZJ());
      if (locali.ZJ() <= cm.bfC() / 1000L)
      {
        params.a(locali.ZD(), locali, locali.ZG(), (List)locali.ZC());
        AppMethodBeat.o(114148);
        return;
      }
      parame.a(locali.ZB(), locali, paramd.jQN);
    }
    AppMethodBeat.o(114148);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/executor/OpUpdateExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(e parame, d paramd, i parami, s params) {}
    
    public final void a(i parami)
    {
      AppMethodBeat.i(114146);
      p.k(parami, "item");
      Log.i("FunctionMsg.OpUpdateExecutor", "[onSuccessFetch] item:".concat(String.valueOf(parami)));
      if (parami.ZJ() > cm.bfC() / 1000L)
      {
        this.jQT.a(0, parami, paramd.jQN);
        AppMethodBeat.o(114146);
        return;
      }
      Log.i("FunctionMsg.OpUpdateExecutor", "[onTaskExpired] to show! id:" + locali.ZD());
      params.a(parami.ZD(), parami, parami.ZG(), (List)parami.ZC());
      AppMethodBeat.o(114146);
    }
    
    public final void b(i parami)
    {
      AppMethodBeat.i(114145);
      p.k(parami, "item");
      Log.w("FunctionMsg.OpUpdateExecutor", "[onFailFetch] item:".concat(String.valueOf(parami)));
      if (parami.getStatus() == -1) {
        this.jQT.a(-1, parami, paramd.jQN);
      }
      AppMethodBeat.o(114145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.w.g
 * JD-Core Version:    0.7.0.1
 */